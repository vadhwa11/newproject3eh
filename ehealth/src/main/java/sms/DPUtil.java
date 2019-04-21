package sms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.objectxp.msg.GsmSmsService;

public class DPUtil {

	public static  GsmSmsService service =null;
	public static Properties config, messageFile;
	private static Logger logger = Logger.getLogger(DPUtil.class);
	//--To Search Stolen Vehicle details ----
	public static String  getRequiredDataForStolenVehicle(String FileNo,Connection connection)
	{
		ResultSet resultSet=null;
		 String regNumber="";
		 String chassisNumber="";
		 String engineNumber="";
		 String policeStation="";
		 String fireNumber="";
		 String model ="";
		 String make="";
		 String color="";
		 String  messageToSend="";
		 String  status="";
		 boolean flag=false;
		 PreparedStatement statement=null;
		try {

			String qry="select A.detail STATUS_CODE,  B.REG_NO REG_NO,  B.CHASIS_NO CHASIS_NO,  B.ENGINE_NO ENGINE_NO,  C.NAME POLICE_STATION_CODE,  B.FIR_NUMBER||'/'||b.year FIR_NUMBER,  E.DETAIL MAKE_CODE,  B.MODEL MODEL,  D.DETAIL COLOUR_CODE  from STATUS_M A,automobile B,POLICE_STATION_M C ,COLOUR_M D,AUTOMOBILE_M E where b.police_dist_code=c.police_dist_code and b.police_station_code=c.police_station_code and A.STATUS_M = B.STATUS_CODE AND B.MAKE_CODE = E.MAKE_CODE AND B.TYPE_CODE = E.TYPE_CODE AND b.COLOUR_CODE = D.COLOUR_CODE(+) AND B.status_code ='005' and (upper(B.engine_no)=upper(?) or upper(B.chasis_no)=upper(?) or upper(B.reg_no)=upper(?))";
			statement = connection.prepareStatement(qry);
			statement.setString(1, FileNo);
			statement.setString(2, FileNo);
			statement.setString(3, FileNo);
		    resultSet = statement.executeQuery();
			 if(resultSet !=null)
		while(resultSet.next()){
			  if(resultSet.getString("status_code") !=null)
			status = resultSet.getString("status_code");
			  if(resultSet.getString("reg_no") !=null)
			regNumber = resultSet.getString("reg_no");
			  if(resultSet.getString("chasis_no") !=null)
			chassisNumber = resultSet.getString("chasis_no");
			if(resultSet.getString("engine_no") !=null)
			engineNumber = resultSet.getString("engine_no");
			  if(resultSet.getString("police_station_code") !=null)
			policeStation = resultSet.getString("police_station_code");
			  if(resultSet.getString("fir_number") !=null)
			fireNumber = resultSet.getString("fir_number");
			  if(resultSet.getString("model") !=null)
			model = resultSet.getString("model");
			  if(resultSet.getString("make_code") !=null)
			make = resultSet.getString("make_code");
			  if(resultSet.getString("colour_code") !=null)
			color = resultSet.getString("colour_code");
			  flag=true;
			  messageToSend = "st:"+status+"\nRgNo:"+regNumber+"\nChNo:"+chassisNumber+"\nEgNo:"+engineNumber+"\nPS:"+policeStation+"\nFirNo:"+fireNumber+"\nMake:"+make+"\nModel:"+model+"\nCol:"+color ;
		}
		 if(!flag){
				messageToSend ="No Information Found ";
			}
		 statement.close();

		}catch(Exception e){
		   logger.info("Exception :"+e.getMessage() );
	   }
		return messageToSend ;
	}
	//--To Search Unclaimed Vehicle details ----
	public static String  getRequiredDataForUnclaimedVehicle(String FileNo,Connection connection)
	{
			PreparedStatement statement=null;
			ResultSet resultSet =null;
			 String regNumber="";
			 String chassisNumber="";
			 String engineNumber="";
			 String policeStation="";
			 String fireNumber="";
			 String model ="";
			 String make="";
			 String color="";
			 String status="";
			 String  messageToSend="";
			 boolean flag=false;
			try {
			String qry ="select	A.REG_NO REG_NO, A.CHASIS_NO  CHASIS_NO, A.ENGINE_NO ENGINE_NO,	 B.NAME POLICE_STATION_CODE," +
					" A.FIR_NUMBER||'/'||A.YEAR FIR_NUMBER,C.detail MAKE_CODE ,A.MODEL MODEL ,D.DETAIL COLOUR_CODE,S.detail as status" +
					" from AUTOMOBILE_UNCLAIMED  A , POLICE_STATION_M B, AUTOMOBILE_M C, COLOUR_M D ,PROPERTY_STATUS_M S" +
					" where A.POLICE_DIST_CODE = B.POLICE_DIST_CODE " +
					" AND  A.POLICE_STATION_CODE = B.POLICE_STATION_CODE AND   A.MAKE_CODE = C.MAKE_CODE " +
					" AND A.TYPE_CODE = C.TYPE_CODE AND A.COLOUR_CODE = D.COLOUR_CODE (+) and A.status_code=S.status_code " +
					" and  (upper(A.engine_no)=upper(?) or upper(A.chasis_no)=upper(?) or upper(A.reg_no)=upper(?))";

			statement = connection.prepareStatement(qry);
			statement.setString(1, FileNo);
			statement.setString(2, FileNo);
			statement.setString(3, FileNo);
		    resultSet = statement.executeQuery();

				while(resultSet.next()){
					if(resultSet.getString("reg_no") !=null)
					   regNumber = resultSet.getString("reg_no");
					if(resultSet.getString("chasis_no") !=null)
						chassisNumber = resultSet.getString("chasis_no");
					if(resultSet.getString("engine_no") !=null)
						engineNumber = resultSet.getString("engine_no");
					if(resultSet.getString("police_station_code") !=null)
						policeStation = resultSet.getString("police_station_code");
					if(resultSet.getString("fir_number") !=null)
						fireNumber = resultSet.getString("fir_number");
					if(resultSet.getString("model") !=null)
						model = resultSet.getString("model");
					if(resultSet.getString("make_code") !=null)
						make = resultSet.getString("make_code");
					 if(resultSet.getString("colour_code") !=null)
						color = resultSet.getString("colour_code");
					 if(resultSet.getString("status") !=null)
						status = resultSet.getString("status");
					flag=true;
					 messageToSend = "RgNo:"+regNumber+"\nChNo:"+chassisNumber+"\nEgNo:"+engineNumber+"\nPS:"+policeStation+"\nFirNo:"+fireNumber+"\nStatus:"+status+"\nType:"+make+"\nModel:"+model+"\nCol:"+color ;
				}
				 if(!flag){
						messageToSend ="No Information Found ";
					}
				 statement.close();
			   }catch(Exception e){
				   logger.info("Exception :"+e.getMessage() );
			   }
		return messageToSend ;
	}

	//--To Search Vehicle details by Regisration No. ----
	public static String  getRequiredDataForVehicleByRegistrationNo(String sender,String messageString,Connection connection)
	{
		ResultSet resultSet=null;
		 String regNumber="";
		 String chassisNumber="";
		 String ownerName="";
		 String ownerAddress="";
		 String engineNumber="";
		 String model ="";
		 //String make="";
		 String color="";
		 String  messageToSend="";

		 String qry="SELECT OT.REGNO REGNO, OT.OWNER OWNER, ( OT.ADDRESS || ','||OT.ADD2||' '||OT.CITY||':'||OT.PINCODE)  ADDRESS, OT.MAKER_MODEL MODEL, OT.ENG_NO ENGNO," +
			"OT.CH_NO CHASISNO,OT.COLOUR COLOR FROM OWNER_TAB OT  " +
			"WHERE upper(OT.REGNO)=upper(?)";

		 if(DPUtil.authenticateNumber(sender.substring(2, sender.length()),"W",connection) ){
				try {
					PreparedStatement statement = connection.prepareStatement(qry);
					statement.setString(1, messageString);
					resultSet = statement.executeQuery();

					  while(resultSet.next()){
							 if(resultSet.getString("regno") !=null)
								  regNumber = resultSet.getString("regno");
							  if(resultSet.getString("owner") !=null)
								  ownerName = resultSet.getString("owner");
							  if(resultSet.getString("address") !=null)
								  ownerAddress = resultSet.getString("address");
							  if(resultSet.getString("model") !=null)
								  model = resultSet.getString("model");
							  if(resultSet.getString("engno") !=null)
								  engineNumber = resultSet.getString("engno");
							  if(resultSet.getString("chasisno") !=null)
								  chassisNumber = resultSet.getString("chasisno");
							  if(resultSet.getString("color") !=null)
								  color = resultSet.getString("color");

							  messageToSend = regNumber+"\nEgNo:"+engineNumber+",\nChNo:"+chassisNumber+",\n"+ownerName+",\n"+ownerAddress+"\nModel:"+model;
						}
					resultSet.close();
					statement.close();
					if(messageToSend.equalsIgnoreCase("")){
						messageToSend ="No Information Found ";
					}

				} catch (Exception e) {
					logger.info("Exception :"+e.getMessage() );
				}
			}else{
					messageToSend="This phone number is not authenticated number";
			}


		return messageToSend ;
	}

	//--To Search Passport Verification details ----
	public static String getRequiredDataForPassport(String FileNo, Connection connectionFromAccessForPV )
	{
	PreparedStatement prepareStatement=null;
	String messageToSend="";
	ResultSet resultSet =null;
	ResultSet resultSet2 =null;
	boolean flag= false;
	try {

		String qryAccess = "select dispatchdata.FileNo as FileNo,status.status as status," +
				"dispatchdata.Name as Name,dispatchdata.Father as Father," +
				"dispatchdata.dispatchNo as dispatchNo,dispatchdata.dispatchdate as dispatchdate" +
				" from dispatchdata,status where FileNo = '"+FileNo.toUpperCase()+"' " +
				"and dispatchdata.status=status.code1";

		//
		prepareStatement = connectionFromAccessForPV.prepareStatement(qryAccess);
			resultSet = prepareStatement.executeQuery();

			 String fileNumber;
			 String status1;
			 String name ;
			 String fatherName;
			 String dispatchNo;
			 Date date;
			 String dispatchDate;
			 while(resultSet.next()){
				 fileNumber = resultSet.getString("FileNo");
				 status1 =resultSet.getString("Status");
				 name = resultSet.getString("Name");
				 fatherName = resultSet.getString("Father");
				 dispatchNo= resultSet.getString("dispatchNo");
				 date = resultSet.getDate("dispatchdate");
				 dispatchDate = DPUtil.convertDateToStringWithoutTime(date);
			    messageToSend = "FNo:"+fileNumber+"\nSt:"+status1+"\nName:"+name+"\nFName:"+fatherName+"\nDispNo:"+dispatchNo+"\nDispDt:"+dispatchDate ;
			 }
			 resultSet.close();
			 prepareStatement.close();

		    if(messageToSend.equalsIgnoreCase("")){
		    	PreparedStatement preparedStatement2=null;
		    	String dairyNo="";
		    	String diaryDate="";
		    	String qryOracle2 ="select DiaryNo,DiaryDate from diaryData where FILENO = '"+FileNo.toUpperCase()+"'";
				preparedStatement2 = connectionFromAccessForPV.prepareStatement(qryOracle2);
			    resultSet2 = preparedStatement2.executeQuery();
			    while(resultSet2.next()){
			    	dairyNo=resultSet2.getString("DiaryNo");
			    	diaryDate=DPUtil.convertDateToStringWithoutTime(resultSet2.getDate("DiaryDate"));
			    	flag=true;
			    }
			    if(flag){
					 messageToSend="Verification received in this office.(Diary No. "+dairyNo+", Date "+diaryDate+") is under process.";
				 }else{
					 messageToSend= "file No."+FileNo.toUpperCase()+" not received in this office so far.";
				 }
			    resultSet2.close();
			    preparedStatement2.close();
			}

	}catch (Exception e)
					{
						logger.error(" Error while executing query in  getRequiredDataForPassport-->"+ e.getLocalizedMessage() );
					}
		return messageToSend ;
	}
	//--To Search Stolen FireArm details ----
	public static String getRequiredDataForStolenFireArm(String FileNo,Connection connection)
	{
		PreparedStatement statement=null;

		ResultSet resultSet =null;

		try
		{	String sqlQry="select A.FIR_NUMBER||'/'||A.YEAR FIR_NUMBER,B.NAME POLICE_STATION_CODE, A.MAKE MAKE, A.MODEL MODEL  from arms_stolen A,POLICE_STATION_M B where status_code ='005' AND A.POLICE_DIST_CODE = B.POLICE_DIST_CODE AND A.POLICE_STATION_CODE = B.POLICE_STATION_CODE AND upper(A.arms_number)=upper(?)";
			statement = connection.prepareStatement(sqlQry);
			statement.setString(1,FileNo);
		    resultSet = statement.executeQuery();
		}
		catch (SQLException e)
		{	e.printStackTrace();
			logger.error(" Error while executing query in  getRequiredDataForStolenFireArm-->"+ e.getLocalizedMessage() );
		}
		 String policeStation="";
		 String firNumber="";
		 String  model ="";
		 String  make="";
		 String  messageToSend  ="";
		boolean  flag =false;
		 try{
		while(resultSet.next()){
			if(resultSet.getString("police_station_code") !=null)
				policeStation = resultSet.getString("police_station_code");
			if(resultSet.getString("fir_number") !=null)
				firNumber = resultSet.getString("fir_number");
			if(resultSet.getString("model") !=null)
				model = resultSet.getString("model");
			if(resultSet.getString("make") !=null)
				make = resultSet.getString("make");
			flag=true;
			  messageToSend ="FirNo:"+firNumber+"\nPS:"+policeStation+"\nMake:"+make+"\nModel:"+model ;
		}
		 if(!flag){
				messageToSend ="No Information Found ";
			}
		 statement.close();
		 resultSet.close();
	   }catch(Exception e){
		   logger.info("Exception :"+e.getMessage() );
	   }

		return messageToSend ;
	}
	//--To Search Tel No Of Police Station details ----
	public static String  getTelNoOfPoliceStation(String str,Connection connection)
	{
		PreparedStatement statement=null;
		ResultSet resultSet =null;
		try
		{
			statement = connection.prepareStatement("select psname,telephonesho,telephonedo,telephoneaddsho from police_station_tel where upper(psname)=upper(?)");
			statement.setString(1, str);
		    resultSet = statement.executeQuery();
		}
		catch (SQLException e)
		{
			logger.error("Error while executing query in getRequiredDataForStolenFireArm-->"+ e.getLocalizedMessage() );
		}
		String psname="";
		 String telephonesho="";
		 String telephonedo ="";
		 String telephoneaddsho="";
		 String messageToSend ="";
		  boolean flag =false;
	try{

		while(resultSet.next()){
			if(resultSet.getString("psname") !=null)
				psname = resultSet.getString("psname");
			if(resultSet.getString("telephonesho") !=null)
				telephonesho = resultSet.getString("telephonesho");
			if(resultSet.getString("telephonedo") !=null)
				telephonedo = resultSet.getString("telephonedo");
			if(resultSet.getString("telephoneaddsho") !=null)
				telephoneaddsho = resultSet.getString("telephoneaddsho");
			flag=true;
			  messageToSend ="PsName:"+psname+"\nTELSHO:"+telephonesho+"\nTELDO:"+telephonedo+"\nTELADDSHO:"+telephoneaddsho ;
		}
		 if(!flag){
				messageToSend ="No Information Found ";
			}
		 statement.close();
		 resultSet.close();

	   }catch(Exception e){
		   logger.info("Exception :"+e.getMessage() );
	   }
		return messageToSend ;
	}
	//--To Search Stolen Mobile details ----
	public static String getRequiredDataForStolenMobile(String imeiNo,Connection connection)
	{
				PreparedStatement statement=null;
				String messageToSend="";
				String state;
				   String status;
				   String district="";
				   String IMEINo;
				   String ps;
				   String fir_no;
				   String fir_date="";
				ResultSet resultSet=null;
		try
		{
			statement = connection.prepareStatement("select * from Stolen_mobile where imei_no = ? ");
			statement.setString(1, imeiNo);
			 resultSet = statement.executeQuery();
			 while(resultSet.next())
			   {
				   state = resultSet.getString("state");
				   district = resultSet.getString("district");
				   status = resultSet.getString("status");
				   IMEINo = resultSet.getString("imei_no");
				   ps =  resultSet.getString("ps");
				   fir_no =  resultSet.getString("fir_no");
				   Date date =null;
					date = resultSet.getDate("fir_dt");
					 fir_date = DPUtil.convertDateToStringWithoutTime(date);
				  messageToSend = "St:"+status+"\nIMEI:"+IMEINo+"\nState:"+state+"\nDist:"+district+"\nPS:"+ps+"\nFirNo:"+fir_no+"\nFirDt:"+fir_date;

			  }
			statement.close();
			resultSet.close();

			if(messageToSend.equalsIgnoreCase("")){
				messageToSend ="No Information Found ";
			}

		}
		catch (SQLException e)
		{
			logger.error(" Error while executing query for stolen mobile -->"+ e.getLocalizedMessage() );
		}

		return messageToSend ;
	}
	//--To Search Mobile Service Provider Tracking details ----
	public static String getMobileServiceProviderTrackingData(String sender,String msgString1,Connection connection)
	{
		String messageToSend="";
		ResultSet resultSet=null;
		if(DPUtil.authenticateNumber(sender.substring(2, sender.length()),"MO",connection) ){
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM mobile where Mobile= ?");
			statement.setString(1, msgString1);
			 resultSet = statement.executeQuery();
			while(resultSet.next()){
				messageToSend="MNo:"+resultSet.getString(1)+"\nServProvdr:"+resultSet.getString(2)+"\nOprArea:"+resultSet.getString(3)+"\nCustCareNo:"+resultSet.getString(4);
			}
			resultSet.close();
			statement.close();
			if(messageToSend.equalsIgnoreCase("")){
				messageToSend ="No Information Found ";
			}
			statement.close();
			resultSet.close();
		} catch (Exception e) {
			logger.info("Exception :"+e.getMessage() );
		}
		}else{
			messageToSend="This phone number is not  Authenticated number";
		}
		return messageToSend ;
	}


	//-- Search Village details by Village Name and District Name ----
	public static String  getVillageData(String sender,String messageString1,String messageString2,Connection connection,Connection remoteConnection)
	{
		ResultSet resultSet=null;
		 String stateName="";
		 String districtName="";
		 String villageName="";
		 String  messageToSend="";

		 String qry="SELECT S.NAME STATE, V.DIST_NAME DISTRICT, V.VILLAGE VILLAGE " +
		 			"FROM ALL_INDIA_VILLAGE_M V,ALL_INDIA_STATE_VIEW S " +
		 			"WHERE UPPER(V.DIST_NAME)=UPPER(?) AND UPPER(V.VILLAGE)=UPPER(?) AND S.STATE_CODE=V.STATE_CODE";

		 if(DPUtil.authenticateNumber(sender.substring(2, sender.length()),"VL",connection) ){
				try {
					PreparedStatement statement = remoteConnection.prepareStatement(qry);
					statement.setString(1, messageString2);
					statement.setString(2, messageString1);
					resultSet = statement.executeQuery();

					  while(resultSet.next()){
						 if(resultSet.getString("state") !=null)
							 stateName = resultSet.getString("state");
						 if(resultSet.getString("district") !=null)
							 districtName = resultSet.getString("district");
						 if(resultSet.getString("village") !=null)
							 villageName = resultSet.getString("village");

						  messageToSend = "ST.Name:"+stateName+",\nDName:"+districtName+",\nVill..:"+villageName;
					  }
					resultSet.close();
					statement.close();
					if(messageToSend.equalsIgnoreCase("")){
						messageToSend ="No Information Found ";
					}

				} catch (Exception e) {
					logger.info("Exception :"+e.getMessage());
				}
		 }else{
		  	messageToSend="This phone number is not authenticated number";
		 }

		return messageToSend;
	}

	//PCO Phone Details
	public static String getPcoPhoneDetailData(String sender,String msgString1,Connection connection)
	{
		String messageToSend="";
		ResultSet resultSet=null;
		if(DPUtil.authenticateNumber(sender,"PH",connection) ){
			try {
				PreparedStatement statement = connection.prepareStatement("SELECT PHONE,Name,Add1,Add2,Add3,Add4 FROM PCO where phone = ? ");
				statement.setString(1, msgString1);
				 resultSet = statement.executeQuery();
				while(resultSet.next()){
					messageToSend="PhNo:"+resultSet.getString(1)+"\n,"+resultSet.getString(2)+"\n,"+resultSet.getString(3)+","+resultSet.getString(4);
				}
				resultSet.close();
				statement.close();
				if(messageToSend.equalsIgnoreCase("")){
					messageToSend ="No Information Found ";
				}
			} catch (SQLException e) {
			}
		}else{
			messageToSend="This phone number is not  Authenticated number";
		}
		return messageToSend ;
	}

	public static String getMTNLData(String sender,String msgString1,Connection connection)
	{
		String messageToSend="";
		ResultSet resultSet=null;
		if(DPUtil.authenticateNumber(sender,"MT",connection) ){
			try {
					PreparedStatement statement = connection.prepareStatement("SELECT Unique(PHONE_No) as Ph,NAME AS NAME,Address  as ADDRESS  FROM Delhi_Mtnl_Phone_m where rownum&lt;=1 and '$mobileNo'=(select distinct mobile_no from veh.mobile_no_m where mobile_no='$mobileNo') and PHONE_No='$msgString1' or PHONE_No=(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(substr('$msgString1',1,(instr('$msgString1','!')-1)),'-',''),'/',''),':',''),',',''),';',''),'_',''),'.',''),'!+&lt;19&gt;',''),'!',''),' ',''))");
					 resultSet = statement.executeQuery();
					while(resultSet.next()){
						messageToSend=resultSet.getString(1)+","+resultSet.getString(2)+","+resultSet.getString(3);
					}
					if(messageToSend.equalsIgnoreCase("")){
						messageToSend ="No Information Found ";
					}
					resultSet.close();
					statement.close();
			} catch (Exception e) {
				logger.info("Exception :"+e.getMessage() );
			}
		}else{
			messageToSend="This phone number is not  Authenticated number";
		}
		return messageToSend ;
	}

	/*public static String getServiceUsingSoundExData(String sender,String msgString1,Connection connection)
	{
		String messageToSend="";
		ResultSet resultSet=null;
		if(DPUtil.authenticateNumber(sender,"VL",connection) ){
			try {
				PreparedStatement statement = connection.prepareStatement("SELECT b.name as STName,Upper(a.Dist_Name) as DisttName,Upper(a.village) as VillageName FROM all_india_village_m a,supervisor.all_india_police_station_m b where '$mobileNo'=(select distinct mobile_no from veh.mobile_no_m where mobile_no='$mobileNo') and a.State_code=b.State_code and b.police_dist_code='000' and (replace(replace(replace(replace(replace(Upper(village),'A',''),'E',''),'I',''),'O',''),'U',''))=(replace(replace(replace(replace(replace(Upper('$msgString1'),'A',''),'E',''),'I',''),'O',''),'U','')) and ((replace(replace(replace(replace(replace(Upper(Dist_Name),'A',''),'E',''),'I',''),'O',''),'U',''))=(replace(replace(replace(replace(replace(substr(Upper('$msgString2'),1,(instr(Upper('$msgString2'),'!')-1)),'A',''),'E',''),'I',''),'O',''),'U','')) or (replace(replace(replace(replace(replace(Upper(Dist_Name),'A',''),'E',''),'I',''),'O',''),'U',''))=(replace(replace(replace(replace(replace(Upper('$msgString2'),'A',''),'E',''),'I',''),'O',''),'U','')))");
				 resultSet = statement.executeQuery();
				while(resultSet.next()){
					messageToSend=resultSet.getString(1)+","+resultSet.getString(2)+","+resultSet.getString(3);
				}
				resultSet.close();
				statement.close();
			} catch (Exception e) {
				logger.info("Exception :"+e.getMessage() );
			}
		}else{
			messageToSend="This phone number is not  Authenticated number";
		}
		return messageToSend ;
	}*/

	public static String getOwnerShipDetailsChasisData(String sender,String msgChasisNo,String msgEngineNo,Connection connection)
	{
		String messageToSend="";
		ResultSet resultSet=null;
		if(DPUtil.authenticateNumber(sender,"CE",connection) ){
			try {
				PreparedStatement statement = connection.prepareStatement("select * from owner_tab where eng_no=? and ch_no=?");
				statement.setString(1, msgEngineNo);
				statement.setString(2, msgChasisNo);
				 resultSet = statement.executeQuery();
				while(resultSet.next()){
					messageToSend=resultSet.getString(7)+",ChNo."+resultSet.getString(5)+",\nEngNo."+resultSet.getString(4)+","+resultSet.getString(3)+","+resultSet.getString(1)+","+resultSet.getString(2);;
				}
				if(messageToSend.equalsIgnoreCase("")){
					messageToSend ="No Information Found ";
				}
				resultSet.close();
				statement.close();
			} catch (Exception e) {
				logger.info("Exception :"+e.getMessage() );
			}
		}else{
			messageToSend="This phone number is not  Authenticated number";
		}
		return messageToSend ;
	}
	/*public static String getOwnershipDetailsRegisteredWithSTAData(String sender,String msgString1,Connection connection)
	{
		String messageToSend="";
		ResultSet resultSet=null;
		if(DPUtil.authenticateNumber(sender,"OI",connection) ){
			try {
				PreparedStatement statement = connection.prepareStatement("select REGN_NO as RN,Chasi_no as CN,eng_no as EN,manu_YR as YR,O_name||' ' ||f_name as Name,add1||' '||add2||' '||add3 as ADR from veh.v_mast  where '$REMOTE_ADDR'=(select distinct mobile_no from veh.mobile_no_m where mobile_no='$REMOTE_ADDR') and Regn_No= concat(rpad(Upper('$reg'),6,' '),lpad(Upper('$se'),4,' ')) or Regn_No =concat(rpad(Upper('$reg'),6,' '),lpad((replace(replace(replace(replace(replace(replace(replace(replace(replace(substr(Upper('$se'),1,(instr(Upper('$se'),'!')-1)),'-',''),'/',''),':',''),',',''),';',''),'_',''),'.',''),'!+&lt;19&gt;',''),'!+&lt;BP&gt;','')),4,' '))");
				 resultSet = statement.executeQuery();
				while(resultSet.next()){
					messageToSend=resultSet.getString(1)+","+resultSet.getString(2)+","+resultSet.getString(3)+resultSet.getString(4)+","+resultSet.getString(5)+","+resultSet.getString(6);;
				}
				resultSet.close();
				statement.close();
			} catch (Exception e) {
				logger.info("Exception :"+e.getMessage() );
			}
		}else{
			messageToSend="This phone number is not  Authenticated number";
		}
		return messageToSend ;
	}*/
	public static String getArrestdataUsingSoundexData(String sender,String msgString1,String msgString2,
			Connection connection,Connection remoteConnection2)
	{
		String messageToSend="";
		ResultSet resultSet=null;
		if(DPUtil.authenticateNumber(sender,"DO",connection) ){
			try {

				String qry="SELECT AA.NAME AS NAME,AA.PARENTAGE_NAME AS PNAME,AA.ADDRESS AS ADDRESS,CASE " +
						"WHEN A.PERSONAL_FILE_NUMBER IS NULL THEN 0 ELSE A.PERSONAL_FILE_NUMBER END AS FNUMBER," +
						"CASE WHEN A.DOSSIER_NO IS NULL THEN 'N/A' ELSE A.DOSSIER_NO END AS DOSSIERNO FROM " +
						"CCIS_ARREST_ALIASES AA,CCIS_ARREST A WHERE AA.CCIS_ARREST_NUMBER=A.CCIS_ARREST_NUMBER " +
						"AND UPPER(REPLACE(AA.NAME,' ',''))=UPPER('"+msgString1+"') " +
						"AND UPPER(REPLACE(AA.PARENTAGE_NAME,' ',''))=UPPER('"+msgString2+"')";

				//
				 PreparedStatement statement = remoteConnection2.prepareStatement(qry);
				 resultSet = statement.executeQuery();
				while(resultSet.next()){
					messageToSend=resultSet.getString(1)+","+resultSet.getString(2)+","+resultSet.getString(3)+",\nFNO."+resultSet.getString(4)+",\nDNO."+resultSet.getString(5);
				}
				if(messageToSend.equalsIgnoreCase("")){
					messageToSend ="No Information Found ";
				}
				resultSet.close();
				statement.close();

			} catch (Exception ee) {
				//ee.getStackTrace();
				logger.info("Exception :"+ee.getMessage() );
			}
		}else{
			messageToSend="This phone number is not  Authenticated number";
		}
		return messageToSend ;
	}
	public static String getSTDISDCodeData(String sender,String msgString1,Connection connection,Connection remoteConnection)
	{
		String messageToSend="";
		ResultSet resultSet=null;
		if(DPUtil.authenticateNumber(sender,"ST",connection) ){
			try {
				//
				PreparedStatement statement = remoteConnection.
							prepareStatement("select * from All_INDIA_STD_CODE_M where STD_CODE=?");
				 statement.setString(1, msgString1);
				 resultSet = statement.executeQuery();
				while(resultSet.next()){
					messageToSend=resultSet.getString(1)+","+resultSet.getString(2)+","+resultSet.getString(3)+","+resultSet.getString(4);
				}
				if(messageToSend.equalsIgnoreCase("")){
					messageToSend ="No Information Found ";
				}
				resultSet.close();
				statement.close();
			} catch (Exception e) {
				logger.info("Exception :"+e.getMessage() );
			}
		}else{
			messageToSend="This phone number is not  Authenticated number";
		}
		return messageToSend ;
	}
	public static String getDossierDetailsData(String sender,String msgString1,Connection connection,Connection remoteConnection2)
	{
		String messageToSend="";
		ResultSet resultSet=null;
		if(DPUtil.authenticateNumber(sender,"DU",connection) ){
			try {
				String query="SELECT AA.NAME AS NAME,AA.PARENTAGE_NAME AS PNAME,AA.ADDRESS AS ADDRESS " +
						"FROM CCIS_ARREST_ALIASES AA,CCIS_ARREST A " +
						"WHERE AA.CCIS_ARREST_NUMBER=A.CCIS_ARREST_NUMBER " +
						"AND UPPER(A.DOSSIER_NO)=UPPER('"+msgString1+"')";

				PreparedStatement statement = remoteConnection2.prepareStatement(query);
				 resultSet = statement.executeQuery();
				while(resultSet.next()){
					messageToSend=resultSet.getString(1)+",S/O "+resultSet.getString(2)+","+resultSet.getString(3);
				}
				resultSet.close();
				statement.close();
				if(messageToSend.equalsIgnoreCase("")){
					messageToSend ="No Information Found ";
				}
			} catch (Exception e) {
				logger.info("Exception :"+e.getMessage() );
			}
		}else{
			messageToSend="This phone number is not  Authenticated number";
		}
		return messageToSend ;
	}

	public static String getUserCreationData(String sender,String msgString1,String msgString2,Connection connection,String currentDate,String currentTime)
	{
		String messageToSend="";
		if(DPUtil.authenticateNumber(sender,"UC",connection) ){
			try{
				boolean duplicate = false;
				PreparedStatement statementTemp = connection.prepareStatement("select * from users where login_name = ? ");
				statementTemp.setString(1, msgString1);
				ResultSet temResultSet = statementTemp.executeQuery();
				while (temResultSet.next()) {
					duplicate = true;
				}
				temResultSet.close();
				statementTemp.close();
				if(!duplicate){
			PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO users (login_name,user_name,password,status,last_chg_by,last_chg_date,last_chg_time) VALUES(?,?,?,?,?,?,?)");
			prepareStatement.setString(1, msgString1);
			prepareStatement.setString(2, msgString1);
			prepareStatement.setString(3, msgString2);
			prepareStatement.setString(4, "y");
			prepareStatement.setString(5, "admin");
			prepareStatement.setDate(6, DPUtil.converStringToDate(currentDate));
			prepareStatement.setString(7, currentTime);
			prepareStatement.executeUpdate();
			prepareStatement.close();
			messageToSend="User created Successfully";
				}else{
					messageToSend="Login Name already Exists";
				}
			}catch (Exception e) {
				logger.info("Exception :"+e.getMessage() );
			}
		}else{
			messageToSend="This phone number is not  Authenticated number";
		}
		return messageToSend ;
	}




	public static Map<String,Object> getCurrentDateAndTime() {

		Map<String, Object> map = new HashMap<String, Object>();
		String currentDate="";
		String currentTime="";
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String datetime = dateFormat.format(date);
		StringTokenizer s = new StringTokenizer(datetime," ");
		while(s.hasMoreTokens())
		{
			currentDate = s.nextToken();
			currentTime = s.nextToken();
		}
		map.put("currentDate", currentDate);
		map.put("currentTime", currentTime);
		return map;
	}



	public static String convertDateToStringWithoutTime(Date date) {
		int dateOfMonth, month, year;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime( date );
		StringBuffer dateOnly = new StringBuffer();
		dateOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		if (dateOfMonth < 10)
			dateOnly.append("0");
		dateOnly.append( dateOfMonth );
		dateOnly.append("/");
		month = calendar.get(Calendar.MONTH) + 1;
		if (month < 10)
			dateOnly.append("0");
		dateOnly.append(month);
		dateOnly.append("/");
		year = calendar.get(Calendar.YEAR);
		dateOnly.append(year);
		return dateOnly.toString();
	}
	//This is the common method to authenticate the mobile number

	public static boolean authenticateNumber(String sender,String type,Connection connection)
	{

			boolean status=false;
			try {
				PreparedStatement statement=null;
				statement = connection.prepareStatement("select * from validate_no where nos like '%"+sender+"%' and "+type+"='y'");
				ResultSet resultSet = statement.executeQuery();
				if(resultSet.next()){
					status=true;
				}
				resultSet.close();
				statement.close();
			}
		catch (Exception e)
		{
			logger.info("Exception :"+e.getMessage() );
			logger.error(" Error while executing query in authenticateNumber -->"+ e.getLocalizedMessage() );
		}
		return status ;
	}
	//This method is to validate the message
	public static boolean validateMessage(String prefix,String msgString1,String msgString2)
	{
		//
		boolean status=false;
		try{
		      if(prefix.equalsIgnoreCase("SV")){
		    	  if(msgString1.length() >0 ){
		    		  status=true;
		    	  }

		}else if(prefix.equalsIgnoreCase("UN")){
			if(msgString1.length() >0 ){
	    		  status=true;
	    	  }
		}
		else if(prefix.equalsIgnoreCase("PV")){
			if(msgString1.length() >0 ){
	    		  status=true;
	    	  }
		}
		else if(prefix.equalsIgnoreCase("AR")){
			if(msgString1.length() >0 ){
	    		  status=true;
	    	  }
		}
		else if(prefix.equalsIgnoreCase("PS")){
			if(msgString1.length() >0 ){
	    		  status=true;
	    	  }
		}
		else if(prefix.equalsIgnoreCase("MM")){
			if(msgString1.length() >0){
	    		  status=true;
	    	  }
		}

		else if(prefix.equalsIgnoreCase("EM")){
			if(msgString1.length() >0 ){
	    		  status=true;
	    	  }
		}
		else if(prefix.equalsIgnoreCase("MO")){
			if(msgString1.length() >0 & isNumber(msgString1)  && (msgString1.length()==4)){
	    		  status=true;
	    	  }
		}else if(prefix.equalsIgnoreCase("W")){
			if(msgString1.length() >0 ){
	    		  status=true;
	    	  }
		}
		else if(prefix.equalsIgnoreCase("PH")){
			if(msgString1.length() >0 & isNumber(msgString1) ){
	    		  status=true;
	    	  }
		}
		else if(prefix.equalsIgnoreCase("MT")){
			if(msgString1.length() >0 & isNumber(msgString1)){
	    		  status=true;
	    	  }
		}
		else if(prefix.equalsIgnoreCase("VL")){
			if(msgString1.length() >0 ){
	    		  status=true;
	    	  }
		}
		else if(prefix.equalsIgnoreCase("CE")){
			if(msgString1.length() >0 && isNumber(msgString1) && isNumber(msgString2)){
	    		  status=true;
	    	  }
		}
		else if(prefix.equalsIgnoreCase("OI")){
			if(msgString1.length() >0 && isNumber(msgString2) && (msgString2.length()==4)){
	    		  status=true;
	    	  }
		}
		else if(prefix.equalsIgnoreCase("DO")){
			if(msgString1.length() >0 ){
	    		  status=true;
	    	  }
		}
		else if(prefix.equalsIgnoreCase("ST")){
			if(msgString1.length() >0 && isNumber(msgString1)){
	    		  status=true;
	    	  }
		}
		else if(prefix.equalsIgnoreCase("DU")){
			if(msgString1.length() >0 ){
	    		  status=true;
	    	  }
		}
		else if(prefix.equalsIgnoreCase("UC")){
			if(msgString1.length() >0 ){
	    		  status=true;
	    	  }
		}
		}catch (Exception e) {
			logger.info("Exception :"+e.getMessage() );
		}
		return status ;
	}
	public static boolean isNumber(String no)
	{
		boolean status =false;
		try{
			@SuppressWarnings("unused")
			Integer integer=Integer.parseInt(no);
			status=true;
		}catch (Exception e) {
			status =false;
			logger.info("Exception :"+e.getMessage() );
		}
		return status;
		}

	public static void saveEmergencyDetails(String emMsg,String sender,String currentDate,String currentTime,Connection connection) {


		 try {
			  PreparedStatement prepareStatement = connection
			  .prepareStatement("INSERT INTO emergency (sender,message,status,msg_date,time) VALUES(?,?,?,?,?)");

			  prepareStatement.setString(1, sender);
			  prepareStatement.setString(2, emMsg);
			  prepareStatement.setString(3, "r");
			  prepareStatement.setDate(4,converStringToDate(currentDate) );
			  prepareStatement.setString(5, currentTime);

			  prepareStatement.executeUpdate();
			  prepareStatement.close();
			} catch (SQLException e) {
				logger.error("error in add record for emergency service ...");
				logger.info("Exception :"+e.getMessage() );
			}

	}

	public static void savePublicServiceDetails(String currentDate,String currentTime,String respDate,String respTime,String sender,
			String messageType,String msgRecieved,String msgSent,Connection connection) {

			//
		 try {
			  PreparedStatement prepareStatement = connection
			  .prepareStatement("INSERT INTO inbox (MSGDATE,MSGTIME,MOBILENO,APPLICATION,MESSAGETYPE,MESSAGE,MESSAGESENT,STATUS,PRIORITY,SENTDATE,SENT_TIME)" +
			  		" VALUES(?,?,?,?,?,?,?,?,?,?,?)");


			  prepareStatement.setDate(1, converStringToDate(currentDate));
			  prepareStatement.setString(2, currentTime);
			  prepareStatement.setString(3, sender);
			  prepareStatement.setString(4, messageType);
			  prepareStatement.setString(5, messageType);
			  prepareStatement.setString(6, msgRecieved);
			  prepareStatement.setString(7, msgSent);
			  prepareStatement.setString(8, "S");
			  prepareStatement.setInt(9, 0);
			  prepareStatement.setString(10,respDate);
			  prepareStatement.setString(11,respTime);
			  prepareStatement.executeUpdate();
			  prepareStatement.close();
			 // 
			 // 
			  logger.info("added record for public service ...");
			} catch (SQLException e) {
				//e.printStackTrace();
				logger.error("error in add record for public service ...");
				logger.info("Exception :"+e.getMessage());
			}

	}

	/*
	 * Converts dd/mm/yyyy string in to yyyy-mm-dd Sql Date Format
	 */
	public static java.sql.Date converStringToDate(String date)
	{

		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new  SimpleDateFormat("yyyy-MM-dd");
		String date4MySQL2 =null;
		try {
			date4MySQL2 = formatterOut.format(formatterIn.parse(date));
		} catch (ParseException e1) {
			logger.info("Exception :"+e1.getMessage() );
		}
		java.sql.Date startDate = java.sql.Date.valueOf(date4MySQL2);

		return startDate;


		}
	/*
	 * Converts yyyy-mm-dd Sql Date Format in to dd/mm/yyyy string  Format
	 */
	public static String converDateToString(Date date)
	{
		SimpleDateFormat formatterIn1 = new SimpleDateFormat("yyyy-mm-dd");
		SimpleDateFormat formatterOut1 = new  SimpleDateFormat("dd/MM/yyyy");
		String date4String =null;
		 try {
			 date4String=formatterOut1.format(formatterIn1.parse(""+date));
		} catch (ParseException e) {
			logger.info("Exception :"+e.getMessage() );
		}
		return date4String;
		}

	//===============  Validate Bulk Response ==============


	public static void main(String arg[]){
	try{
		//Connection connectionFromAccessForPV = SimpleConnection.getConnectionFromAccessForPV();

		/* Code commended by MNS
		 * Connection remoteConnection = SimpleConnection.getConnectionFromOracle();
		Connection publicConnection=ConnectionPool.getConnectionFromOracle();
*/
		//Connection remoteConnection2=SimpleConnection.getConnectionFromOracle2();

		//
		//
		//
	    //
	    //
	    //
	    //
		//
		//
		 /* Code commented by MNS
		
		*/
		 long heapSize = Runtime.getRuntime().totalMemory();

	        //Print the jvm heap size.
	        
	        
	 }catch(Exception ee){
		 ee.printStackTrace();
	  }
	}
	/**
     * @author Mukesh Narayan Singh
     * Validate Only Indian Mobile Number
     * @param mobile no as 919873595976
     * @date 10/04/2012
     * @return true/false
     */
	public static boolean validateMobileNo(String mobileNo)
	{
		boolean validate=false;
		if(mobileNo.length()==12){
			String prefix="";
			prefix=mobileNo.substring(0, 2);
			//
			if(prefix.equalsIgnoreCase("91")){
				String validatedMobileNo="";
				validatedMobileNo=mobileNo.substring(2, mobileNo.length());
				
				if(validatedMobileNo.length()==10){
					validate=true;
				}else{
					validate=false;
				}
			}else{
				validate=false;
			}
		}else if(mobileNo.length()==11){
			String prefix="";
			prefix=mobileNo.substring(0, 1);
			if(prefix.equalsIgnoreCase("0")){
				String validatedMobileNo="";
				validatedMobileNo=mobileNo.substring(1, mobileNo.length());
				if(validatedMobileNo.length()==10){
					validate=true;
				}else{
					validate=false;
				}
			}else{
				validate=false;
			}
		}else if(mobileNo.length()==13){
			String prefix="";
			prefix=mobileNo.substring(0, 3);
			if(prefix.equalsIgnoreCase("+91")){
				String validatedMobileNo="";
				validatedMobileNo=mobileNo.substring(3, mobileNo.length());
				if(validatedMobileNo.length()==10){
					validate=true;
				}else{
					validate=false;
				}
			}else{
				validate=false;
			}
		}else{
			validate=false;
		}
		return validate;
		}
}
