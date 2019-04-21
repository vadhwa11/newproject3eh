//package com.jkt.dp.sms;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.log4j.Logger;
//
//import com.objectxp.msg.Message;
//import com.objectxp.msg.MessageEvent;
//import com.objectxp.msg.SmsMessage;
//
//@SuppressWarnings("unused")
//public class PublicBusinessServiceBackUp  {
//
//static Logger logger = Logger.getLogger(PublicBusinessServiceBackUp.class);
//public enum PublicService {SV,UN,PV,AR,PS,MM,EM,MO,PH,MT,VL,CE,OI,DO,ST,DU,UC}
//
//	public static String  processMessage(String messageReceived,String sender)
//	{
//				String messageToSend ="";
//				String[] messageContents = messageReceived.trim().split(" ");
//				String msgFormat = "";
//				String msgString1 = "";
//				String msgString2 ="";
//				Map<String, Object> utilMap = new HashMap<String, Object>();
//				utilMap = (Map<String, Object>)DPUtil.getCurrentDateAndTime();
//				String currentDate = (String)utilMap.get("currentDate");
//				String currentTime = (String)utilMap.get("currentTime");
//				
//				if(messageReceived.length() > 0)
//				{
//					
//					try{
//						msgFormat =messageContents[0].trim();
//						msgString1 =messageContents[1].trim();
//						msgString2 =messageContents[2].trim();
//					}catch(Exception e){}
//					//---Validating the message format---
//					if(DPUtil.validateMessage(msgFormat,msgString1,msgString2)){
//						
//						Connection remoteConnection =null;
//				 		try {
//				 			remoteConnection = SimpleConnection.getConnectionFromOracle();
//				 		} catch (Exception e2) {
//				 		}
//				 		Connection connection =null;
//				 		try {
//				 			connection = ConnectionPool.getConnectionFromOracle();
//				 		} catch (Exception e2) {
//				 		}
//				 		PublicService publicService = PublicService.valueOf(msgFormat.toUpperCase());
//				 		 ResultSet resultSet=null;
//					switch(publicService){
//				 			
//				 	case SV:
//				 		// Stolen Vehicle Search
//				 		   messageToSend=DPUtil.getRequiredDataForStolenVehicle(msgString1,remoteConnection);
//						   DPUtil.addRecord(sender,"Stolen Vehicle Search","SV",messageReceived);
//					break;
//				 	case UN:
//				 			//Unclaimed Vehicle Search
//				 			messageToSend=DPUtil.getRequiredDataForUnclaimedVehicle(msgString1,remoteConnection);
//							DPUtil.addRecord(sender,"Unclaimed Vehicle Search","UN",messageReceived);
//					break;
//				 	case PV:
//				 		Connection connectionFromAccessForPV =null;
//				 		try {
//				 			connectionFromAccessForPV = SimpleConnection.getConnectionFromAccessForPV();
//				 		} catch (Exception e2) {
//				 		}
//				 				messageToSend=DPUtil.getRequiredDataForPassport(msgString1,connectionFromAccessForPV);
//								DPUtil.addRecord(sender,"Passport Verification Status","PV",messageReceived);
//				 	break;
//					/*Stolen fire Arm Search */
//					case AR:
//						messageToSend=DPUtil.getRequiredDataForStolenFireArm(msgString1,remoteConnection);
//						DPUtil.addRecord(sender,"Stolen fire Arm Search","AR",messageReceived);
//					break;
//					/* Telephone Number Of Police Station */
//					case PS:
//						messageToSend=DPUtil.getTelNoOfPoliceStation(msgString1,connection);
//						DPUtil.addRecord(sender,"Telephone Number Of Police Station","PS",messageReceived);
//					break;
//					/* Stolen/Missing Mobile Phones */
//					case MM:
//						messageToSend=DPUtil.getRequiredDataForStolenMobile(msgString1,connection);
//						DPUtil.addRecord(sender,"Stolen/Missing Mobile Phones","MM",messageReceived);
//					break;
//					case EM:
//						try{
//							String emMsg ="";
//							try{
//								emMsg=messageReceived.substring(2, messageReceived.length());
//							}catch (Exception e) {
//								emMsg=messageReceived.substring(2, messageReceived.length()-1);
//							}
//							DPUtil.saveEmergencyDetails(emMsg,sender,currentDate,currentTime);
//						}catch (Exception e) {
//						}
//					break;
//				 		
//					//Mobile Service Provider Tracking
//					case MO:
//						messageToSend=DPUtil.getMobileServiceProviderTrackingData(sender,msgString1, connection);
//						DPUtil.addRecord(sender,"Mobile Service Provider Tracking","M0",messageReceived);
//					break;
//					//PCO Phone Details
//					case PH:
//						messageToSend=DPUtil.getPcoPhoneDetailData(sender,msgString1,connection);
//						DPUtil.addRecord(sender,"PCO Phone Details","PH",messageReceived);
//					break;
//					//MTNL Telephone Directory Service using SoundEx
//					case MT:
//						messageToSend=DPUtil.getMTNLData(sender,msgString1,connection);
//						DPUtil.addRecord(sender,"MTNL Telephone Directory Service using SoundEx","MT",messageReceived);
//						break;
//					//Service using SoundEx Technique on the basis of data
//					case VL:
//						messageToSend=DPUtil.getMTNLData(sender,msgString1,connection);
//						DPUtil.addRecord(sender,"Mobile Service Provider Tracking","VL",messageReceived);
//					break;
//					//OwnerShip Details on the basis of chasis & Engine Number(Data Provided by Delhi Traffic Police)
//					case CE:
//						messageToSend=DPUtil.getOwnerShipDetailsChasisData(sender,msgString1,connection);
//						DPUtil.addRecord(sender,"OwnerShip Details on the basis of chasis & Engine Number(Data Provided by Delhi Traffic Police)","CE",messageReceived);
//					break;
//					//Ownership details registered with STA,Delhi(Data provided by Delhi Traffic Police)
//					case OI:
//						messageToSend=DPUtil.getOwnershipDetailsRegisteredWithSTAData(sender,msgString1,connection);
//						DPUtil.addRecord(sender,"Ownership details registered with STA,Delhi(Data provided by Delhi Traffic Police)","OI",messageReceived);
//					break;
//					//Arrest data access using soundex technique
//					case DO:
//						messageToSend=DPUtil.getArrestdataUsingSoundexData(sender,msgString1,connection);
//						DPUtil.addRecord(sender,"Arrest data access using soundex technique","DO",messageReceived);
//					break;
//					//STD/ISD Code
//					case ST:
//						messageToSend=DPUtil.getSTDISDCodeData(sender,msgString1,connection);
//						DPUtil.addRecord(sender,"STD/ISD Code","ST",messageReceived);
//					break;
//					//Dossier Details
//					case DU:
//						messageToSend=DPUtil.getDossierDetailsData(sender,msgString1,connection);
//						DPUtil.addRecord(sender,"Dossier Details","DU",messageReceived);
//					break;
//					//==============User Creation start=================
//					case UC:
//						messageToSend=DPUtil.getUserCreationData(sender,msgString1,msgString2,connection,currentDate,currentTime);
//					break;
//					default:
//						messageToSend = "Please check the SMS Format.";
//					}
//				}else{
//					//------Else block for validation message ---------
//						messageToSend = "Please check the SMS Format.";
//				}
//				}
//				
//				return messageToSend;
//				
//		}
//
//	
//}
