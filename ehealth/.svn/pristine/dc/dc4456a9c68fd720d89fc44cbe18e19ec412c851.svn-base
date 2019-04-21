// SendMessage.java - Sample application.
//
// This application shows you the basic procedure for sending messages.
// You will find how to send synchronous and asynchronous messages.
//
// For asynchronous dispatch, the example application sets a callback
// notification, to see what's happened with messages.
//
// Bulk Operator used: Clickatell (http://www.clickatell.com)
// Please look the ClickatellHTTPGateway documentation for details.

package org.ajwcc.pduUtils.test.integration;

import org.smslib.*;
import org.smslib.http.*;

public class ClickatellSendPortMessage extends AbstractTester
{
	@Override
	public void test() throws Exception
	{
		OutboundMessage msg;
		OutboundNotification outboundNotification = new OutboundNotification();
		
		
		
		ClickatellHTTPGateway gateway = new ClickatellHTTPGateway("clickatell.http.1", " 2982992", "tdelenikas", "AFghjkr3");
		gateway.setOutbound(true);
		srv.setOutboundNotification(outboundNotification);
		// Do we need secure (https) communication?
		// True uses "https", false uses "http" - default is false.
		gateway.setSecure(true);
		srv.addGateway(gateway);
		gateway.startGateway();
		// Create a message.
		msg = new OutboundMessage("xxxx", "Hello from SMSLib (Clickatell handler)");
		msg.setFrom("SMSLIB.ORG");
		msg.setSrcPort(0);
		msg.setDstPort(4501);
		// Ask for coverage.
		
		// Send the message.
		gateway.sendMessage(msg);
		
		
		// Now query the service to find out our credit balance.
		
		
		System.in.read();
		srv.stopService();
	}

	public class OutboundNotification implements IOutboundMessageNotification
	{
		public void process(String gatewayId, OutboundMessage msg)
		{
			
			
		}
	}

	public static void main(String args[])
	{
		ClickatellSendPortMessage app = new ClickatellSendPortMessage();
		try
		{
			app.initModem();
			app.test();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
