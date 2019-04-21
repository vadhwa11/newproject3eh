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

package org.smslib.smsserver;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.smslib.GatewayException;
import org.smslib.InboundBinaryMessage;
import org.smslib.InboundMessage;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.TimeoutException;
import org.smslib.InboundMessage.MessageClasses;
import org.smslib.smsserver.gateways.AGateway;
import org.smslib.smsserver.interfaces.Interface;
import org.smslib.smsserver.interfaces.Interface.InterfaceTypes;

import sms.ConnectionPool;
import sms.DPUtil;
import sms.PublicBusinessService;
import sms.SimpleConnection;

/**
 * SMSServer Application.
 */

public class SMSServer
{
	static Logger logger = Logger.getLogger(SMSServer.class);
	private static Connection  bulkConnection =null;
	private static Connection remoteConnection =null;
	private static Connection remoteConnection2 =null;
	private static Connection publicConnection =null;

	Service srv;

	Properties props;

	boolean shutdown = false;

	List<Interface<? extends Object>> infList;

	//InboundNotification inboundNotification;

	OutboundNotification outboundNotification;

	CallNotification callNotification;

	QueueSendingNotification queueSendingNotification;

	//InboundPollingThread inboundPollingThread;

	OutboundPollingThread outboundPollingThread;
	OutboundMessage sendMsg;

	boolean optRunOnce = false;

	public SMSServer()
	{
		this.srv = new Service();
		this.infList = new ArrayList<Interface<? extends Object>>();
		Runtime.getRuntime().addShutdownHook(new Shutdown());
		//this.inboundNotification = new InboundNotification();
		this.outboundNotification = new OutboundNotification();
		this.callNotification = new CallNotification();
		this.queueSendingNotification = new QueueSendingNotification();
		//this.inboundPollingThread = null;
		this.outboundPollingThread = null;
		//getService().setInboundNotification(this.inboundNotification);
		getService().setOutboundNotification(this.outboundNotification);
		getService().setCallNotification(this.callNotification);
		getService().setQueueSendingNotification(this.queueSendingNotification);
	}

	public Service getService()
	{
		return this.srv;
	}

	public List<Interface<? extends Object>> getInfList()
	{
		return this.infList;
	}

	public Properties getProperties()
	{
		return this.props;
	}

	class Shutdown extends Thread
	{
		@Override
		public void run()
		{
			
			SMSServer.this.shutdown = true;
			try
			{
				stopInterfaces();
				getService().stopService();
//				if (SMSServer.this.inboundPollingThread != null)
//				{
//					SMSServer.this.inboundPollingThread.interrupt();
//					SMSServer.this.inboundPollingThread.join();
//				}
				if (SMSServer.this.outboundPollingThread != null)
				{
					SMSServer.this.outboundPollingThread.interrupt();
					SMSServer.this.outboundPollingThread.join();
				}
			}
			catch (Exception e)
			{
				
				logger.info("Exception in Thread Running :"+e.getMessage() );

			}
		}
	}

	@SuppressWarnings("unchecked")
	private void loadConfiguration() throws Exception
	{
		FileInputStream f;
		this.props = new Properties();
//		if (System.getProperty("smsserver.configdir") != null)
//			f = new FileInputStream(System.getProperty("smsserver.configdir") + "SMSServer.conf");
//		else if (System.getProperty("smsserver.configfile") != null) f = new FileInputStream(System.getProperty("smsserver.configfile"));
//		else f = new FileInputStream("SMSServer.conf");
		f = new FileInputStream("c:\\SMSServer.conf");
		getProperties().load(f);
		f.close();
		if (getProperties().getProperty("smsserver.balancer", "").length() > 0)
		{
			try
			{
				Object[] args = new Object[] { getService() };
				Class<?>[] argsClass = new Class[] { Service.class };
				Class<?> c = Class.forName((getProperties().getProperty("smsserver.balancer", "").indexOf('.') == -1 ? "org.smslib.balancing." : "") + getProperties().getProperty("smsserver.balancer", ""));
				Constructor<?> constructor = c.getConstructor(argsClass);
				org.smslib.balancing.LoadBalancer balancer = (org.smslib.balancing.LoadBalancer) constructor.newInstance(args);
				getService().setLoadBalancer(balancer);
				
			}
			catch (Exception e)
			{
				//e.printStackTrace();
				
			}
		}
		if (getProperties().getProperty("smsserver.router", "").length() > 0)
		{
			try
			{
				Object[] args = new Object[] { getService() };
				Class<?>[] argsClass = new Class[] { Service.class };
				Class<?> c = Class.forName((getProperties().getProperty("smsserver.router", "").indexOf('.') == -1 ? "org.smslib.routing." : "") + getProperties().getProperty("smsserver.router", ""));
				Constructor<?> constructor = c.getConstructor(argsClass);
				org.smslib.routing.Router router = (org.smslib.routing.Router) constructor.newInstance(args);
				getService().setRouter(router);
				
			}
			catch (Exception e)
			{
				
			}
		}
		for (int i = 0; i < Integer.MAX_VALUE; i++)
		{
			try
			{
				String propName = "gateway." + i;
				String propValue = getProperties().getProperty(propName, "");
				if (propValue.length() == 0) break;
				StringTokenizer tokens = new StringTokenizer(propValue, ",");
				String gtwId = tokens.nextToken().trim();
				String gtwClass = tokens.nextToken().trim();
				Object[] args = new Object[] { gtwId, getProperties(), this };
				Class<?>[] argsClass = new Class[] { String.class, Properties.class, SMSServer.class };
				Class<?> c = Class.forName((gtwClass.indexOf('.') == -1 ? "org.smslib.smsserver.gateways." : "") + gtwClass);
				Constructor<?> constructor = c.getConstructor(argsClass);
				AGateway gtw = (AGateway) constructor.newInstance(args);
				gtw.create();
				getService().addGateway(gtw.getGateway());
				//
			}
			catch (Exception e)
			{
				
			}
		}
		for (int i = 0; i < Integer.MAX_VALUE; i++)
		{
			try
			{
				String propName = "interface." + i;
				String propValue = getProperties().getProperty(propName, "");
				if (propValue.length() == 0) break;
				StringTokenizer tokens = new StringTokenizer(propValue, ",");
				String infId = tokens.nextToken().trim();
				String infClass = tokens.nextToken().trim();
				InterfaceTypes infType = null;
				String sinfType = tokens.hasMoreTokens() ? tokens.nextToken() : "inoutbound";
				sinfType = sinfType.trim();
				if ("inbound".equalsIgnoreCase(sinfType))
				{
					infType = InterfaceTypes.INBOUND;
				}
				else if ("outbound".equalsIgnoreCase(sinfType))
				{
					infType = InterfaceTypes.OUTBOUND;
				}
				else
				{ // NULL or other crap
					infType = InterfaceTypes.INOUTBOUND;
				}
				Object[] args = new Object[] { infId, getProperties(), this, infType };
				Class<?>[] argsClass = new Class[] { String.class, Properties.class, SMSServer.class, InterfaceTypes.class };
				Class<?> c = Class.forName((infClass.indexOf('.') == -1 ? "org.smslib.smsserver.interfaces." : "") + infClass);
				Constructor<?> constructor = c.getConstructor(argsClass);
				Interface<? extends Object> inf = (Interface<? extends Object>) constructor.newInstance(args);
				getInfList().add(inf);
				//
			}
			/* Check for exceptions thrown by the constructor itself */
			catch (InvocationTargetException e)
			{
				
			}
			catch (Exception e)
			{
				
			}
		}
	}

//	class InboundPollingThread extends Thread
//	{
//		@Override
//		public void run()
//		{
//			try
//			{
//				while (!SMSServer.this.shutdown)
//				{
//					getService().getLogger().logDebug("InboundPollingThread() run.");
//					readMessages();
//					if (SMSServer.this.optRunOnce) break;
//					Thread.sleep(Integer.parseInt(getProperties().getProperty("settings.inbound_interval", "60")) * 1000);
//				}
//			}
//			catch (InterruptedException e)
//			{
//				getService().getLogger().logDebug("InboundPollingThread() interrupted.");
//			}
//			catch (Exception e)
//			{
//				getService().getLogger().logDebug("Error in InboundPollingThread()", e, null);
//			}
//		}
//	}

	class OutboundPollingThread extends Thread
	{
		@Override
		public void run()
		{
			try
			{

				while (!SMSServer.this.shutdown)
				{
					int count=0;
					
					//commented for maven
				/*	if(bulkConnection ==null)
						bulkConnection = ConnectionPool.getConnectionFromOracle();*/
					Calendar calendar=Calendar.getInstance();
					Map map = new HashMap();
					map = DPUtil.getCurrentDateAndTime();
					String currentDate = (String) map.get("currentDate");
					String currentTime = (String) map.get("currentTime");
					//

					if(currentTime.equalsIgnoreCase("09:00:00")){
						sendMsg("9873595976","Good Morning DP SMS is Working Fine 9AM Thanks");//Mukesh
						sendMsg("9717365663","Good Morning DP SMS is Working Fine 9AM Thanks");
						sendMsg("9968411595","Good Morning DP SMS is Working Fine 9AM Thanks");// Siva Jee Sir
						sendMsg("9873595977","Good Morning DP SMS is Working Fine 9AM Thanks");// Ritu
						sendMsg("9873265667","Good Morning DP SMS is Working Fine 9AM Thanks");// Gijesh
					}if(currentTime.equalsIgnoreCase("09:30:00")){
						sendMsg("9873595976","Good Morning DP SMS is Working Fine 9 30 AM Thanks");
						sendMsg("9717365663","Good Morning DP SMS is Working Fine 9 30 AM Thanks");
						sendMsg("9968411595","Good Morning DP SMS is Working Fine 9 30 AM Thanks");
						sendMsg("9873595977","Good Morning DP SMS is Working Fine 9 30 AM Thanks");// Ritu
						sendMsg("9873265667","Good Morning DP SMS is Working Fine 9 30 AM Thanks");// Gijesh
					}else if(currentTime.equalsIgnoreCase("15:00:00")){
						
						sendMsg("9717365663","Good Afternoon DP SMS is Working Fine 3PM Thanks");
						sendMsg("9968411595","Good Afternoon DP SMS is Working Fine 3PM Thanks");
						sendMsg("9873595977","Good Afternoon DP SMS is Working Fine 3PM Thanks");// Ritu
						sendMsg("9873265667","Good Afternoon DP SMS is Working Fine 3PM Thanks");// Gijesh
					}else if(currentTime.equalsIgnoreCase("15:30:00")){
						sendMsg("9873595976","Good Afternoon DP SMS is Working Fine 3 30 PM Thanks");
						sendMsg("9717365663","Good Afternoon DP SMS is Working Fine 3 30 PM Thanks");
						sendMsg("9968411595","Good Afternoon DP SMS is Working Fine 3 30 PM Thanks");
						sendMsg("9873595977","Good Afternoon DP SMS is Working Fine 3 30 PM Thanks");// Ritu
						sendMsg("9873265667","Good Afternoon DP SMS is Working Fine 3 30 PM Thanks");// Gijesh
					}else if(currentTime.equalsIgnoreCase("21:00:00")){
						sendMsg("9873595976","Good Evening SMS is Working Fine 9PM Thanks");
						sendMsg("9717365663","Good Evening SMS is Working Fine 9PM Thanks");
						sendMsg("9968411595","Good Evening SMS is Working Fine 9PM Thanks");
						sendMsg("9873595977","Good Evening SMS is Working Fine 9PM Thanks");// Ritu
						sendMsg("9873265667","Good Evening SMS is Working Fine 9PM Thanks");// Gijesh
					}else if(currentTime.equalsIgnoreCase("21:30:00")){
						sendMsg("9873595976","Good Evening SMS is Working Fine 9 30 PM Thanks");
						sendMsg("9717365663","Good Evening SMS is Working Fine 9 30 PM Thanks");
						sendMsg("9968411595","Good Evening SMS is Working Fine 9 30 PM Thanks");
						sendMsg("9873595977","Good Evening SMS is Working Fine 9 30 PM Thanks");// Ritu
						sendMsg("9873265667","Good Evening SMS is Working Fine 9 30 PM Thanks");// Gijesh
					}
					/*for(int i=0;i<1000;i++){
						sendMsg("9868843160","DP SMS is Working Fine  Thanks"+i);
						
					}*/
					int minutes=0;

					try{
						minutes=Integer.parseInt(""+currentTime.substring(0,2))*60+Integer.parseInt(""+currentTime.substring(3,5));
					}catch (Exception e) {
						//e.printStackTrace();
						logger.info("Exception :"+e.getMessage() );

					}
					if(bulkConnection !=null){
					//===================================== To send Bulk SMS =====================================
						try{
							String qryCount ="SELECT count(*) FROM bulk_details detail,bulk_main main where detail.group_main_id=main.id and detail.status='U'  and to_char(main.activate_date,'YYYY-MM-DD') ='"+sms.DPUtil.converStringToDate(currentDate)+"' and (main.hours*60+main.minutes) > '"+minutes+"' ";
							Statement statementCount = bulkConnection.createStatement();
							ResultSet resultSetCount = statementCount.executeQuery(qryCount);
							while(resultSetCount.next()){
								count=Integer.parseInt(""+resultSetCount.getString(1));
							}
							resultSetCount.close();
							statementCount.close();
						}catch (Exception e) {
							logger.info("Exception :"+e.getMessage() );
						}

					//Checking the size of BULK MESSAGES
					if(count !=0){
					try{
					Statement statementBulk = bulkConnection.createStatement();
					String qry ="SELECT detail.id,detail.mobile_no,main.message FROM bulk_details detail,bulk_main main where detail.group_main_id=main.id and detail.status='U' and rownum=1 and to_char(main.activate_date,'YYYY-MM-DD') ='"+sms.DPUtil.converStringToDate(currentDate)+"' and (main.hours*60+main.minutes) > '"+minutes+"' ";
					//
					ResultSet resultSet1 = statementBulk.executeQuery(qry);
					Statement statementBulk2 = bulkConnection.createStatement();
					while(resultSet1.next()){
						logger.info("  <----------- Sending Bulk SMS ------------>  "+resultSet1.getString(3).length());
						if(resultSet1.getString(3).length() <160){
							 if(sendMsg( resultSet1.getString("MOBILE_NO"), resultSet1.getString("MESSAGE"))){
								int update = statementBulk2.executeUpdate("update bulk_details  set Status = 'S' ,  sent_time='"+currentTime+"' where ID = "+resultSet1.getString(1));
							 }else{
								 int update = statementBulk2.executeUpdate("update bulk_details  set Status = 'F' , sent_time='"+currentTime+"' where ID = "+resultSet1.getString(1));
							 }
						}else{
							logger.info("  <----------- Sending Bulk SMS is more than 159 char------------>  ");
						}
					}
					resultSet1.close();
					statementBulk2.close();
					statementBulk.close();
					//Thread.sleep(Integer.parseInt(getProperties().getProperty("settings.outbound_interval", "60")) * 1000);
					}
					catch(Exception ex){
						logger.info("---------------------   Exception in send Bulk SMS ------------------");
					}
					}else{
						readMessages();
					}
					// =========================================== One to One ======================================================
					try{
					Statement statementOneToOne = bulkConnection.createStatement();
					ResultSet resultSet = statementOneToOne.executeQuery("SELECT id,mobileNo,message FROM one_to_one where status='U' and type='N'");
					Statement statementOneToOne2 = bulkConnection.createStatement();
					while(resultSet.next()){
						if(resultSet.getString("message").length() <160){
							if(sendMsg( resultSet.getString("mobileNo"), resultSet.getString("message"))){
									int update = statementOneToOne2.executeUpdate("update one_to_one  set Status = 'S' where id = "+resultSet.getString("id"));
							}else{
								int update = statementOneToOne2.executeUpdate("update one_to_one  set Status = 'F' where id = "+resultSet.getString("id"));
							}
							}
					}
					resultSet.close();
					statementOneToOne.close();
					statementOneToOne2.close();
					}
					catch(Exception ex){
						logger.info("---------------------   Exception in One to One ------------------"+ex.getMessage());
					}
					// Code By Mukesh 10/04/2012
					// =========================================== One to One By Feed Back Web application======================================================
					try{
					Statement statementOneToOne = bulkConnection.createStatement();
					ResultSet resultSet = statementOneToOne.executeQuery("SELECT id,mobileNo,message FROM one_to_one where status='U' and type='W'");
					Statement statementOneToOne2 = bulkConnection.createStatement();
					while(resultSet.next()){
						if(resultSet.getString("message").length() <160){
							if(sendMsg( resultSet.getString("mobileNo"), resultSet.getString("message"))){
									int update = statementOneToOne2.executeUpdate("update one_to_one  set Status = 'S' where id = "+resultSet.getString("id"));
							}else{
								int update = statementOneToOne2.executeUpdate("update one_to_one  set Status = 'F' where id = "+resultSet.getString("id"));
							}
							}
					}
					resultSet.close();
					statementOneToOne.close();
					statementOneToOne2.close();
					}
					catch(Exception ex){
						logger.info("---------------------   Exception in One to One Feed Back------------------"+ex.getMessage());
					}
					// =========================================== One to One Unlimited======================================================
					try{
					Statement statementUn = bulkConnection.createStatement();
					ResultSet resultSetUn = statementUn.executeQuery("SELECT id,mobileNo,message FROM one_to_one where status='U' and type='U'");
					//statement.close();
					 Statement statementUn2 = bulkConnection.createStatement();
					while(resultSetUn.next()){
						logger.info("One to One Unlimited");
						if(resultSetUn.getString("message").length() <160){
							if(sendMsg( resultSetUn.getString("mobileNo"), resultSetUn.getString("message"))){
									int update = statementUn2.executeUpdate("update one_to_one  set status = 'S' where id = "+resultSetUn.getString("id"));
							}else{
								int update = statementUn2.executeUpdate("update one_to_one  set status = 'F' where id = "+resultSetUn.getString("id"));
							}
							}
					}
					resultSetUn.close();
					statementUn2.close();
					statementUn.close();
					}
					catch(Exception e){
						logger.info("---------------------   Exception in One to One Unlimited ------------------"+e.getMessage());
					}
				// =========================================== Emergency ======================================================
					Statement statementEm = bulkConnection.createStatement();
					 Statement statementEm2 = bulkConnection.createStatement();
					try{
					ResultSet resultSet4 = statementEm.executeQuery("SELECT id,sender,msg_to_send FROM emergency where status='u'");
					while(resultSet4.next()){
							 if(sendMsg(resultSet4.getString("sender"), resultSet4.getString("msg_to_send"))){
									int update = statementEm2.executeUpdate("update emergency  set status = 'S' where id = '"+resultSet4.getString("id")+"'");
							 }else{
									int update = statementEm2.executeUpdate("update emergency  set status = 'F' where id = '"+resultSet4.getString("id")+"'");
							 }
					}
					statementEm.close();
					statementEm2.close();
					}

					catch(Exception ex){
						logger.info("Exception :"+ex.getMessage() );
					}


					//Thread.sleep(Integer.parseInt(getProperties().getProperty("settings.outbound_interval", "60")) * 1000);
					}

				}
			}

			catch (Exception e)
			{
				
			}
		}
	}

	private void process() throws Exception
	{
//		this.inboundPollingThread = new InboundPollingThread();
//		this.inboundPollingThread.setName("SMSServer - InboundPollingThread");
//		this.inboundPollingThread.start();
		this.outboundPollingThread = new OutboundPollingThread();
		this.outboundPollingThread.setName("SMSServer - OutboundPollingThread");
		this.outboundPollingThread.start();
		while (!this.shutdown)
			Thread.sleep(1000);
	}

	void startInterfaces() throws Exception
	{
		for (Interface<? extends Object> inf : getInfList())
			inf.start();
	}

	void stopInterfaces() throws Exception
	{
		for (Interface<? extends Object> inf : getInfList())
			inf.stop();
	}

	private void run() throws Exception
	{
		loadConfiguration();
		try
		{
			startInterfaces();
			getService().startService();
			process();
		}
		catch (Exception e)
		{
			stopInterfaces();
			getService().stopService();
//			if (this.inboundPollingThread != null)
//			{
//				this.inboundPollingThread.interrupt();
//				this.inboundPollingThread.join();
//			}
			logger.info("Inside Run method Exception::::" +e);
			if (this.outboundPollingThread != null)
			{
				this.outboundPollingThread.interrupt();
				this.outboundPollingThread.join();
			}
		}
	}

	void readMessages() throws Exception
	{
		String mobilNo ="";
		long mobileNoInt =0;
		try {


			if(remoteConnection==null)
				remoteConnection = SimpleConnection.getConnectionFromOracle();
			if(remoteConnection2==null)
				remoteConnection2 = SimpleConnection.getConnectionFromOracle2();
			
			//commented for maven
			/*if(publicConnection==null)
				publicConnection= ConnectionPool.getConnectionFromOracle();*/

 		} catch (Exception e2) {
 			e2.printStackTrace();
 			logger.info("SPECIAL MESSAGE DELETED"+e2.getMessage() );
 		}
		//Calendar calendar=Calendar.getInstance();
 		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>)DPUtil.getCurrentDateAndTime();
		String recvDate = (String)utilMap.get("currentDate");
		String recvTime = (String)utilMap.get("currentTime");

		List<InboundMessage> msgList = new ArrayList<InboundMessage>();
		getService().readMessages(msgList, MessageClasses.ALL);

		if (msgList.size() > 0)
		{

			for (Interface<? extends Object> inf : getInfList())
				if (inf.isInbound()) inf.MessagesReceived(msgList);

			for (InboundMessage msg : msgList){
				mobileNoInt=0;
				mobilNo = msg.getOriginator();
				
				if(DPUtil.validateMobileNo(mobilNo)){
			 try{
					mobileNoInt = Long.parseLong(msg.getOriginator());
				}catch (Exception e) {
					e.printStackTrace();
					logger.info("Exception :"+e.getMessage() );
				}
				if(!(msg instanceof InboundBinaryMessage)){
					logger.info("======== Message("+msg.getText()+") Received At: "+recvDate+":"+recvTime+" =============" );
				}else{
					logger.info("======== Non Text Message Received At: "+recvDate+":"+recvTime+" ============= will be deleted" );
				}
				if(!(msg instanceof InboundBinaryMessage) && mobileNoInt != 0){
					String messageToSend=PublicBusinessService
							.processMessage(msg.getText(), msg.getOriginator(),publicConnection,remoteConnection,remoteConnection2);
					if(sendMsg(msg.getOriginator(),messageToSend))
					{
						Map<String, Object> mutilMap = new HashMap<String, Object>();
						utilMap = (Map<String, Object>)DPUtil.getCurrentDateAndTime();
						String respDate = (String)utilMap.get("currentDate");
						String respTime = (String)utilMap.get("currentTime");
						
						String[] messageContents = msg.getText().trim().split(" ");
						String msgFormat = "";
						String msgString1 = "";
						String msgString2 ="";
						try{
							if(messageContents.length>1){
							  msgFormat =messageContents[0].trim();
							  msgString1 =messageContents[1].trim();
							  if(messageContents.length==3){
									msgString2 =messageContents[2].trim();
									msgString1=msgString1+" "+msgString2;
								}
							  DPUtil.savePublicServiceDetails(recvDate,recvTime,respDate,respTime,msg.getOriginator(),msgFormat.toUpperCase(),msgString1,messageToSend,publicConnection);
							}
						}catch(Exception e){
							e.printStackTrace();
						}

						getService().deleteMessage(msg);
					}
				}else{
					getService().deleteMessage(msg);
				}
			}else{
				logger.info("======== Mobile Number not valid or junk mobile no.." );
			}
			}

		}
	}

	void sendMessages() throws Exception
	{
		boolean foundOutboundGateway = false;
		for (org.smslib.AGateway gtw : getService().getGateways())
			if (gtw.isOutbound())
			{
				foundOutboundGateway = true;
				break;
			}
		if (foundOutboundGateway)
		{
			List<OutboundMessage> msgList = new ArrayList<OutboundMessage>();
			for (Interface<? extends Object> inf : getInfList())
				if (inf.isOutbound()) msgList.addAll(inf.getMessagesToSend());
			if (getProperties().getProperty("settings.send_mode", "sync").equalsIgnoreCase(("sync")))
			{
				
				getService().sendMessages(msgList);
				for (Interface<? extends Object> inf : getInfList())
					if (inf.isOutbound()) inf.markMessages(msgList);
			}
			else
			{
				
				getService().queueMessages(msgList);
			}
		}
	}
	public synchronized boolean sendMsg(String mobileNo,String message){
		boolean flag=false;
		sendMsg = new OutboundMessage(mobileNo,message);
		//
		//srv.removeMessage(sendMsg);
		try {

			srv.sendMessage(sendMsg);
			Calendar calendar=Calendar.getInstance();

			logger.info("======== Message...\n("+message+")\n ...Sent to "+mobileNo+" At: "+calendar.getTime()+" =============" );
			flag=true;
		} catch (TimeoutException e) {
			logger.info("TimeoutException :"+e.getMessage() );
		} catch (GatewayException e) {
			logger.info("GatewayException :"+e.getMessage() );
		} catch (IOException e) {
			logger.info("IOException :"+e.getMessage() );
		} catch (InterruptedException e) {
			logger.info("InterruptedException :"+e.getMessage() );
		}
		return flag;
	}
//	class InboundNotification implements org.smslib.IInboundMessageNotification
//	{
//		public void process(String gtwId, MessageTypes msgType, InboundMessage msg)
//		{
//			try {
//				if(remoteConnection==null)
//	 			remoteConnection = SimpleConnection.getConnectionFromOracle();
//				if(publicConnection==null)
//					publicConnection= ConnectionPool.getConnectionFromOracle();
//	 		} catch (Exception e2) {
//	 			e2.printStackTrace();
//	 		}
//			Calendar calendar=Calendar.getInstance();
//			logger.info("=============================   Public Service Message("+msg.getText()+") Received At: "+calendar.getTime()+" ==========================" );
//			List<InboundMessage> msgList = new ArrayList<InboundMessage>();
//			msgList.add(msg);
//			sendMsg(msg.getOriginator(),PublicBusinessService.processMessage(msg.getText(), msg.getOriginator(),publicConnection,remoteConnection));
//			for (Interface<? extends Object> inf : getInfList())
//				if (inf.isInbound())
//				{
//					try
//					{
//						inf.MessagesReceived(msgList);
//					}
//					catch (Exception e)
//					{
//						
//					}
//				}
//			msgList.clear();
//			try {
//				getService().deleteMessage(msg);
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//		}
//	}

	class OutboundNotification implements org.smslib.IOutboundMessageNotification
	{
		public void process(String gtwId, org.smslib.OutboundMessage msg)
		{
			try
			{
				for (Interface<? extends Object> inf : getInfList())
					if (inf.isOutbound()) inf.markMessage(msg);
			}
			catch (Exception e)
			{
				
			}
		}
	}

	class CallNotification implements org.smslib.ICallNotification
	{
		public void process(String gtwId, String callerId)
		{
			try
			{
				for (Interface<? extends Object> inf : getInfList())
					inf.CallReceived(gtwId, callerId);
			}
			catch (Exception e)
			{
				
			}
		}
	}

	class QueueSendingNotification implements org.smslib.IQueueSendingNotification
	{
		public void process(String gtwId, OutboundMessage msg)
		{
			
		}
	}

	public boolean checkPriorityTimeFrame(int priority)
	{
		String timeFrame;
		String from, to, current;
		Calendar cal = Calendar.getInstance();
		if (priority < 0) timeFrame = getProperties().getProperty("settings.timeframe.low", "0000-2359");
		else if (priority == 0) timeFrame = getProperties().getProperty("settings.timeframe.normal", "0000-2359");
		else if (priority >= 0) timeFrame = getProperties().getProperty("settings.timeframe.high", "0000-2359");
		else timeFrame = "0000-2359";
		from = timeFrame.substring(0, 4);
		to = timeFrame.substring(5, 9);
		cal.setTime(new java.util.Date());
		current = cal.get(Calendar.HOUR_OF_DAY) < 10 ? "0" + cal.get(Calendar.HOUR_OF_DAY) : "" + cal.get(Calendar.HOUR_OF_DAY);
		current += cal.get(Calendar.MINUTE) < 10 ? "0" + cal.get(Calendar.MINUTE) : "" + cal.get(Calendar.MINUTE);
		if ((Integer.parseInt(current) >= Integer.parseInt(from)) && (Integer.parseInt(current) < Integer.parseInt(to))) return true;
		return false;
	}

	public static void main(String[] args)
										{
											logger.info("============================================================================================");
											logger.info("==================================== SMSServer Started =====================================");
											logger.info("========This SERVER is used to send BULK SMS,ONE TO ONE SMS,PUBLIC SMS,EMERGENCY SMS========");
											logger.info("============================================================================================");
											SMSServer app = new SMSServer();
											for (int i = 0; i < args.length; i++)
											{
												logger.info("Inside For Loop:::::");
												if (args[i].equalsIgnoreCase("-runonce"))
													app.optRunOnce = true;
												else
													logger.info("Invalid argument: " + args[i]);
											}
											try
											{
												logger.info("Inside try block::::");
												app.run();
												
											}
											catch (Exception e)
											{
												
												try
												{
													app.srv.stopService();
												}
												catch (Exception e1)
												{
													// Swallow this...
												}
											}
										}

	/*public static void main(String[] args)
		{
		try {
			
			if(publicConnection==null)
				publicConnection= ConnectionPool.getConnectionFromOracle();
			if(remoteConnection==null)
				remoteConnection = SimpleConnection.getConnectionFromOracle();

			if(remoteConnection2==null)
				remoteConnection2=SimpleConnection.getConnectionFromOracle2();
			
			//Connection publicConnection=ConnectionPool.getConnectionFromOracle();
			//Connection remoteConnection2=SimpleConnection.getConnectionFromOracle2();

 		} catch (Exception e2) {
 			e2.printStackTrace();
 		}
		//PublicBusinessService.processMessage("DO AMRIKSINGH BALKARSINGH","9654111625"
				//,publicConnection,remoteConnection,remoteConnection2);

		}*/
}
