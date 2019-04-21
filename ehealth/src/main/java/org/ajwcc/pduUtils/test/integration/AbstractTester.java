
package org.ajwcc.pduUtils.test.integration;

import org.smslib.*;
import org.smslib.Message.*;
import org.smslib.modem.*;

public abstract class AbstractTester
{
	protected Service srv;

	protected static final String MODEM_NUMBER = "xxxx";

	protected static final String PHONE_NUMBER = "xxxx";

	protected void initModem() throws Exception
	{
		
		
		srv = new Service();
		SerialModemGateway gateway = new SerialModemGateway("modem.com1", "COM10", 115200, "Wavecom", "");
		gateway.setSimPin("0000");
		gateway.setOutbound(true);
		OutboundNotification outboundNotification = new OutboundNotification();
		srv.setOutboundNotification(outboundNotification);
		gateway.setInbound(true);
		InboundNotification inboundNotification = new InboundNotification();
		srv.setInboundNotification(inboundNotification);
		srv.addGateway(gateway);
		srv.startService();
		
		
		
		
		
		
		
		
		
	}

	protected abstract void test() throws Exception;

	public class InboundNotification implements IInboundMessageNotification
	{
		public void process(String gatewayId, MessageTypes msgType, InboundMessage msg)
		{
			if (msgType == MessageTypes.INBOUND)
			{
				
			}
			else if (msgType == MessageTypes.STATUSREPORT)
			{
				
			}
			
			try
			{
				// Uncomment following line if you wish to delete the message upon arrival.
				srv.deleteMessage(msg);
			}
			catch (Exception e)
			{
				
				e.printStackTrace();
			}
		}
	}

	public class CallNotification implements ICallNotification
	{
		public void process(String gatewayId, String callerId)
		{
			
		}
	}

	public class OutboundNotification implements IOutboundMessageNotification
	{
		public void process(String gatewayId, OutboundMessage msg)
		{
			
			
		}
	}
}
