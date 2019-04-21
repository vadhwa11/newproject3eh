// SMSLib for Java v3
// A Java API library for sending and receiving SMS via a GSM modem
// or other supported gateways.
// Web Site: http://www.smslib.org
//
// Copyright (C) 2002-2009, Thanasis Delenikas, Athens/GREECE.
// SMSLib is distributed under the terms of the Apache License version 2.0
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.smslib.modem;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import org.smslib.GatewayException;
import org.smslib.Service;
import org.smslib.helper.CommPortIdentifier;
import org.smslib.helper.SerialPort;
import org.smslib.helper.SerialPortEvent;
import org.smslib.helper.SerialPortEventListener;
import org.smslib.scheduler.ASchedulerTask;

class SerialModemDriver extends AModemDriver implements SerialPortEventListener
{
	private String comPort;

	private int baudRate;

	private CommPortIdentifier portId;

	private SerialPort serialPort;

	private InputStream in;

	private OutputStream out;

	private PortReader portReader;

	protected SerialModemDriver(ModemGateway myGateway, String deviceParms)
	{
		super(myGateway, deviceParms);
		StringTokenizer tokens = new StringTokenizer(deviceParms, ":");
		setComPort(tokens.nextToken());
		setBaudRate(Integer.parseInt(tokens.nextToken()));
		setSerialPort(null);
	}

	@Override
	protected void connectPort() throws GatewayException, IOException, InterruptedException
	{
		if (getGateway().getService().getSettings().SERIAL_NOFLUSH) 
			//getGateway().getService().getLogger().logInfo("Comm port flushing is disabled.", null, getGateway().getGatewayId());
		if (getGateway().getService().getSettings().SERIAL_POLLING) 
			//getGateway().getService().getLogger().logInfo("Using polled serial port mode.", null, getGateway().getGatewayId());
		try
		{
			//getGateway().getService().getLogger().logInfo("Opening: " + getComPort() + " @" + getBaudRate(), null, getGateway().getGatewayId());
			setPortId(CommPortIdentifier.getPortIdentifier(getComPort()));
			setSerialPort(getPortId().open("org.smslib", 1971));
			setIn(getSerialPort().getInputStream());
			setOut(getSerialPort().getOutputStream());
			if (!getGateway().getService().getSettings().SERIAL_POLLING)
			{
				getSerialPort().notifyOnDataAvailable(true);
				getSerialPort().notifyOnOutputEmpty(true);
			}
			getSerialPort().notifyOnBreakInterrupt(true);
			getSerialPort().notifyOnFramingError(true);
			getSerialPort().notifyOnOverrunError(true);
			getSerialPort().notifyOnParityError(true);
			if (getGateway().getService().getSettings().SERIAL_RTSCTS_OUT) getSerialPort().setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN | SerialPort.FLOWCONTROL_RTSCTS_OUT);
			else getSerialPort().setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN);
			getSerialPort().addEventListener(this);
			getSerialPort().setSerialPortParams(getBaudRate(), SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
			getSerialPort().setInputBufferSize(getGateway().getService().getSettings().SERIAL_BUFFER_SIZE);
			getSerialPort().setOutputBufferSize(getGateway().getService().getSettings().SERIAL_BUFFER_SIZE);
			getSerialPort().enableReceiveThreshold(1);
			getSerialPort().enableReceiveTimeout(getGateway().getService().getSettings().SERIAL_TIMEOUT);
			if (getGateway().getService().getSettings().SERIAL_POLLING)
			{
				setPortReader(new PortReader("PortReader() [" + getComPort() + "]", getGateway().getService()));
				getGateway().getService().getScheduler().scheduleWithFixedDelay(getPortReader(), getGateway().getService().getSettings().SERIAL_POLLING_INTERVAL, getGateway().getService().getSettings().SERIAL_POLLING_INTERVAL, TimeUnit.MILLISECONDS);
				getPortReader().enable();
			}
		}
		catch (Exception e)
		{
			throw new GatewayException("Comm library exception: " + e.getMessage());
		}
	}

	@Override
	protected void disconnectPort() throws IOException, InterruptedException
	{
		synchronized (getSYNCReader())
		{
			if (getGateway().getService().getSettings().SERIAL_POLLING)
			{
				getGateway().getService().getScheduler().remove(getPortReader());
			}
			if (getSerialPort() != null) getSerialPort().close();
			//getGateway().getService().getLogger().logInfo("Closing: " + getComPort() + " @" + getBaudRate(), null, getGateway().getGatewayId());
		}
	}

	@Override
	protected void clear() throws IOException
	{
		while (portHasData())
			read();
	}

	@Override
	protected boolean portHasData() throws IOException
	{
		return (getIn().available() > 0);
	}

	public void serialEvent(SerialPortEvent event)
	{
		int eventType = event.getEventType();
		if (eventType == SerialPortEvent.OE) //getGateway().getService().getLogger().logError("Overrun Error!", null, getGateway().getGatewayId());
		{}else if (eventType == SerialPortEvent.FE)
		{}// getGateway().getService().getLogger().logError("Framing Error!", null, getGateway().getGatewayId());
		else if (eventType == SerialPortEvent.PE){} //getGateway().getService().getLogger().logError("Parity Error!", null, getGateway().getGatewayId());
		else if (eventType == SerialPortEvent.DATA_AVAILABLE)
		{
			if (!getGateway().getService().getSettings().SERIAL_POLLING)
			{
				synchronized (getSYNCReader())
				{
					setDataReceived(true);
					getSYNCReader().notifyAll();
				}
			}
		}
	}

	@Override
	public void write(char c) throws IOException
	{
		getOut().write(c);
		if (!getGateway().getService().getSettings().SERIAL_NOFLUSH) getOut().flush();
	}

	@Override
	public void write(byte[] s) throws IOException
	{
		getOut().write(s);
		if (!getGateway().getService().getSettings().SERIAL_NOFLUSH) getOut().flush();
	}

	@Override
	protected int read() throws IOException
	{
		return getIn().read();
	}

	PortReader getPortReader()
	{
		return this.portReader;
	}

	void setPortReader(PortReader myPortReader)
	{
		this.portReader = myPortReader;
	}

	private class PortReader extends ASchedulerTask
	{
		public PortReader(String myName, Service myService)
		{
			super(myName, myService);
		}

		public void process()
		{
			try
			{
				if (portHasData())
				{
					synchronized (getSYNCReader())
					{
						setDataReceived(true);
						getSYNCReader().notifyAll();
					}
				}
			}
			catch (Exception e)
			{
				// Swallow this...
			}
		}
	}

	String getComPort()
	{
		return this.comPort;
	}

	void setComPort(String myComPort)
	{
		this.comPort = myComPort;
	}

	int getBaudRate()
	{
		return this.baudRate;
	}

	void setBaudRate(int myBaudRate)
	{
		this.baudRate = myBaudRate;
	}

	CommPortIdentifier getPortId()
	{
		return this.portId;
	}

	void setPortId(CommPortIdentifier myPortId)
	{
		this.portId = myPortId;
	}

	SerialPort getSerialPort()
	{
		return this.serialPort;
	}

	void setSerialPort(SerialPort mySerialPort)
	{
		this.serialPort = mySerialPort;
	}

	InputStream getIn()
	{
		return this.in;
	}

	void setIn(InputStream myIn)
	{
		this.in = myIn;
	}

	OutputStream getOut()
	{
		return this.out;
	}

	void setOut(OutputStream myOut)
	{
		this.out = myOut;
	}
}
