package sms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.objectxp.msg.Message;
import com.objectxp.msg.MessageEvent;
import com.objectxp.msg.SmsMessage;

@SuppressWarnings("unused")
public class PublicBusinessService  {

static Logger logger = Logger.getLogger(PublicBusinessService.class);
public enum PublicService {SV,UN,PV,AR,PS,MM,EM,MO,PH,MT,VL,CE,OI,DO,ST,DU,UC,W}

	public static String  processMessage(
			String messageReceived,String sender,Connection connection,
			Connection remoteConnection,Connection remoteConnection2)
	{
				String messageToSend ="";
				String[] messageContents = messageReceived.trim().split(" ");
				String msgFormat = "";
				String msgString1 = "";
				String msgString2 ="";
				Map<String, Object> utilMap = new HashMap<String, Object>();
				utilMap = (Map<String, Object>)DPUtil.getCurrentDateAndTime();
				String currentDate = (String)utilMap.get("currentDate");
				String currentTime = (String)utilMap.get("currentTime");
				
				if(messageReceived.length() > 0 && messageContents.length > 1)
				{
					
					try{
						msgFormat =messageContents[0].trim();
						msgString1 =messageContents[1].trim();
						if(messageContents.length==3){
							msgString2 =messageContents[2].trim();
						}
					}catch(Exception e){
						e.printStackTrace();
					}
					//---Validating the message format---
					if(DPUtil.validateMessage(msgFormat,msgString1,msgString2)){
				 		PublicService publicService = PublicService.valueOf(msgFormat.toUpperCase());
				 		ResultSet resultSet=null;
					switch(publicService){
				 			
				 	case SV:
				 		// Stolen Vehicle Search
				 		   messageToSend=DPUtil.getRequiredDataForStolenVehicle(msgString1,remoteConnection);
					break;
				 	case UN:
				 			//Unclaimed Vehicle Search
				 			messageToSend=DPUtil.getRequiredDataForUnclaimedVehicle(msgString1,remoteConnection);
					break;
				 	case PV://Passport verification
				 		Connection connectionFromAccessForPV =null;
				 		try {
				 			connectionFromAccessForPV = SimpleConnection.getConnectionFromAccessForPV();
				 		} catch (Exception e2) {
				 			logger.info("Exception :"+e2.getMessage());
				 		}
				 				messageToSend=DPUtil.getRequiredDataForPassport(msgString1,connectionFromAccessForPV);
				 	break;
					/*Stolen fire Arm Search */
					case AR:
						messageToSend=DPUtil.getRequiredDataForStolenFireArm(msgString1,remoteConnection);
					break;
					/* Telephone Number Of Police Station */
					case PS:
						if(msgString2!=null && !msgString2.equalsIgnoreCase("")){
							msgString1=msgString1+" "+msgString2;
						}
						messageToSend=DPUtil.getTelNoOfPoliceStation(msgString1,connection);
					break;
					/* Stolen/Missing Mobile Phones */
					case MM:
						messageToSend=DPUtil.getRequiredDataForStolenMobile(msgString1,connection);
					break;
					case EM:
						try{
							String emMsg ="";
							try{
								emMsg=messageReceived.substring(2, messageReceived.length());
							}catch (Exception e) {
								emMsg=messageReceived.substring(2, messageReceived.length()-1);
							}
							DPUtil.saveEmergencyDetails(emMsg,sender,currentDate,currentTime,connection);
							messageToSend="Delhi Police SMS Server Received Emergency Message ";
						}catch (Exception e) {
							logger.info("Exception :"+e.getMessage());
						}
					break;
				 		
					//Mobile Service Provider Tracking
					case MO:
						messageToSend=DPUtil.getMobileServiceProviderTrackingData(sender,msgString1, connection);
					break;
					// Vehicle Search by registration No.
					case W:
			 			messageToSend=DPUtil.getRequiredDataForVehicleByRegistrationNo(sender,msgString1,connection);
			 			break;
					//PCO Phone Details
					case PH:
						messageToSend=DPUtil.getPcoPhoneDetailData(sender,msgString1,connection);
					break;
					//MTNL Telephone Directory Service using SoundEx 
					case MT:
						messageToSend=DPUtil.getMTNLData(sender,msgString1,connection);
						break;
					//Service using SoundEx Technique on the basis of data
					case VL:
						messageToSend=DPUtil.getVillageData(sender,msgString1,msgString2,connection,remoteConnection);
					break;
					//OwnerShip Details on the basis of chasis & Engine Number(Data Provided by Delhi Traffic Police)
					case CE:
						messageToSend=DPUtil.getOwnerShipDetailsChasisData(sender,msgString1,msgString2,connection);
					break;
					//Ownership details registered with STA,Delhi(Data provided by Delhi Traffic Police)
					case OI:
						//messageToSend=DPUtil.getOwnershipDetailsRegisteredWithSTAData(sender,msgString1,connection);
					break;
					//Arrest data access using soundex technique
					case DO:
						messageToSend=DPUtil.getArrestdataUsingSoundexData(sender,msgString1,msgString2,
									connection,remoteConnection2);
					break;
					//STD/ISD Code
					case ST:
						messageToSend=DPUtil.getSTDISDCodeData(sender,msgString1,connection,remoteConnection);
					break;
					//Dossier Details
					case DU:
						messageToSend=DPUtil.getDossierDetailsData(sender,msgString1,connection,remoteConnection2);
					break;
					//==============User Creation start=================
					case UC:
						messageToSend=DPUtil.getUserCreationData(sender,msgString1,msgString2,connection,currentDate,currentTime);
					break;
					default:
						messageToSend = "Please check the SMS Format.";
					}
			
					
				}else{
					//------Else block for validation message ---------
						messageToSend = "Please check the SMS Format.";
				}
			}else{
					//------Else block for validation message ---------
					messageToSend = "Please check the SMS Format.";
			}
				
				return messageToSend;
				
		}

	
}
