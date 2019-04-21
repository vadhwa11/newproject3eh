package jkt.hms.util;
//SendMessage.java - Sample application.
//
// This application shows you the basic procedure for sending messages.
// You will find how to send synchronous and asynchronous messages.
//
// For asynchronous dispatch, the example application sets a callback
// notification, to see what's happened with messages.
//
// Bulk Operator used: BULKSMS (http://www.bulksms.com)
// Please look the BulkSmsHTTPGateway documentation for details.



import org.smslib.Library;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.http.BulkSmsHTTPGateway;

public class SendMessage
{
	
	public void doIt() throws Exception
	{
		Service srv;
		OutboundMessage msg;
		srv = new Service();
		BulkSmsHTTPGateway gateway = new BulkSmsHTTPGateway("bulksms.http.1", "username", "password");
		gateway.setOutbound(true);
		srv.addGateway(gateway);
		srv.startService();
		// Query the service to find out our credit balance.
		// Send a message synchronously.
		msg = new OutboundMessage("+9871495400", "Hello from SMSLib (BULKSMS handler)");
		srv.sendMessage(msg);
		System.in.read();
		srv.stopService();
	}

	public static void main(String args[])
	{
		SendMessage app = new SendMessage();
		try
		{
			app.doIt();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
