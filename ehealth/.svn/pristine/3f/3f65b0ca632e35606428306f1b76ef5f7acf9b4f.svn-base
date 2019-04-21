//package com.jkt.dp.sms;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//
//public class PublicServiceThread extends Thread{
//	public void run(){
//		PublicBusinessService publicBusinessService=new PublicBusinessService();
//		Connection  publicConnection =null;
//		String messageToSend ="";
//		String sender="";
//		String messageReceived="";
//		int IN_ID=0;
//		while(true)
//		{
//			String qry="select * from SMSSERVER_IN where type='I'";
//			
//				if(publicConnection ==null)
//					try {
//						publicConnection = ConnectionPool.getConnectionFromOracle();
//					} catch (SQLException e1) {
//						// TODO Auto-generated catch block
//					}
//				
//			try{
//				Statement statementBulk = publicConnection.createStatement();
//				ResultSet resultSet1 = statementBulk.executeQuery(qry);
//				Statement statementBulk2 = publicConnection.createStatement();
//				while(resultSet1.next()){
//					IN_ID=Integer.parseInt(""+resultSet1.getString("ID"));
//					sender=resultSet1.getString("ORIGINATOR");
//					messageToSend =publicBusinessService.processMessage(resultSet1.getString("TEXT"), resultSet1.getString("ORIGINATOR"));
//					PreparedStatement prepareStatement = publicConnection.prepareStatement("INSERT INTO SMSSERVER_OUT (RECIPIENT,TEXT,STATUS,PRIORITY) VALUES(?,?,?,?)");
//						prepareStatement.setString(1, sender);
//						prepareStatement.setString(2, messageToSend);
//						prepareStatement.setString(3, "U");
//						prepareStatement.setInt(4, 2);
//						prepareStatement.executeUpdate();
//						prepareStatement.close();
//						
//						PreparedStatement prepareStatement2 = publicConnection.prepareStatement("update SMSSERVER_IN set TYPE='O' where ID ="+IN_ID);
//						prepareStatement2.executeUpdate();
//						prepareStatement2.close();
//				}
//				resultSet1.close();
//				statementBulk2.close();
//				statementBulk.close();
//
//			}catch (Exception e) {
//			}
//		
//		
//	
//}
//}}