package com.jkt.hl7.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

//import org.exolab.castor.builder.SGTypes;



import com.sun.corba.se.impl.protocol.InfoOnlyServantCacheLocalCRDImpl;

import jkt.hms.masters.business.BlOpBillDetails;
import jkt.hms.masters.business.BlOpBillHeader;
import jkt.hms.masters.business.HospitalDoctorUnitM;
import jkt.hms.masters.business.MasCaseType;
import jkt.hms.masters.business.MasComplaint;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDiagnosisConclusion;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.QueueManagment;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.HMSUtil;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.hoh.hapi.server.HohServlet;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v22.message.ADT_A01;
import ca.uhn.hl7v2.model.v22.message.ORM_O01;
import ca.uhn.hl7v2.model.v22.segment.BLG;
import ca.uhn.hl7v2.model.v22.segment.OBR;
import ca.uhn.hl7v2.model.v22.segment.OBX;
import ca.uhn.hl7v2.model.v22.segment.ORC;
import ca.uhn.hl7v2.model.v22.segment.PID;
import ca.uhn.hl7v2.model.v22.segment.PV1;
import ca.uhn.hl7v2.model.v22.segment.PV2;
import ca.uhn.hl7v2.model.v22.segment.RQD;
import ca.uhn.hl7v2.model.v22.segment.RXO;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;

/**
 * Example servlet implementation which receives HL7 messages and uses HAPI to
 * process them.
 */
public class HL7ForCentralServer extends HohServlet {

	/**
	 * Initialise the servlaet
	 */
	// private Connection connection = null;
	// private Statement statement = null;

	@Override
	public void init(ServletConfig theConfig) throws ServletException {

		/*
		 * Servlet should be initialized with an instance of
		 * ReceivingApplication, which handles incoming messages
		 */
		setApplication(new MyApplication());
	}

	/**
	 * The application does the actual processing
	 */
	private class MyApplication implements ReceivingApplication {

		/**
		 * processMessage is fired each time a new message arrives.
		 * 
		 * @param theMessage
		 *            The message which was received
		 * @param theMetadata
		 *            A map containing additional information about the message,
		 *            where it came from, etc.
		 */
		public Message processMessage(Message theMessage,
				Map<String, Object> theMetadata)
				throws ReceivingApplicationException, HL7Exception {
			// System.out.println("Session Factory"+sessionFactory);
			Map<String, Object> utilMap = HMSUtil.getCurrentDateAndTime();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			String currentDate = (String) utilMap.get("currentDate");
			String currentTime = (String) utilMap.get("currentTime");
			java.util.Date changeDate = HMSUtil
					.convertStringTypeDateToDateType(currentDate);

			String msg = "MSH|^~\\&|INSTAPACS||HMS||20151221131527||ORM^O01||P|2.2\r"
					+ "PID||T000011612150001||3391|n|||0,0,|||||||||44 Years||1|n,n,|y|342,340,|992,|n||All System NAD|1\r"
					+ "PV1|||^2|2|1,1,|^^2|122,|^^^23,||1|^^n,n,|||0.0|1|0|2.0,2.0,|D|P,P,|||/|Y|783/2015||||2,2,|n,n,||1.0,1.0,|||||||128|84,122,|P,|Y|^^992,|^^279,992,|^Mon Dec 21 00:00:00 IST 2015||0.0||432||OP,OP,\r"
					+ "ORC|\r"
					+ "OBR|955|p|955|^1|2|^279,992,|^OP||^OP|P||^n,n,|128|^C|^Y^Regular|1,1,||Y|P|y,n,|n||0|p|p|^0.0|^^12:58||2187771,\r"
					+ "BLG|y,||17,23,\r";

			// Parser parser=new PipeParser();
			// Message theMessage=parser.parse(msg);
			ORM_O01 orm_O01 = (ORM_O01) theMessage;

			/*Visit visit = new Visit();
			Patient patient = new Patient();
			BlOpBillHeader opBillHeader = new BlOpBillHeader();
			QueueManagment queue = new QueueManagment();
			BlOpBillDetails opBillDetails = new BlOpBillDetails();*/
			
			PID pid = orm_O01.getPATIENT().getPID();
			// visit detail
			PV1 pv1 = orm_O01.getPATIENT().getPV1();
			// observation
			OBR obr = orm_O01.getORDER().getORDER_DETAIL().getOBR();
			// phramacy request
			RXO rxo = orm_O01.getORDER().getORDER_DETAIL().getRXO();
			// billing
			BLG blg = orm_O01.getORDER().getBLG();
			//orc data
			ORC orc=orm_O01.getORDER(0).getORC();   	
			// investion request
			OBX obx = orm_O01.getORDER().getORDER_DETAIL().getOBX() ;  // added by amit das on 19-09-2017
			
			System.out.println("Received message:\n" + theMessage.encode());
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("jdbc.properties");
			 Properties prop = new Properties();
			InputStream input;
			try {
				 input = new FileInputStream(new
				 File(resourcePath.getFile()));
				 prop.load(input);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			 String url = prop.getProperty("database.url");
			 String driverName = prop.getProperty("database.driver");
			 String userName = prop.getProperty("database.user");
			 String password = prop.getProperty("database.password");
			 System.out.print("opd data comes from client");
			 System.out.print("driver name>>>> "+driverName);
			 System.out.print("url>>>>> "+url);
			 System.out.print("driver name>>>>> "+userName);
			 System.out.print("userName>>> "+password); 
			Statement statement = null;
			Message response=null;
			Connection con=null;
			try {
				Class.forName(driverName);
				 con = DriverManager.getConnection(url,userName,password);
				// Class.forName(driverName);
				// Connection connection = DriverManager.getConnection(url,
				// userName, password);
				con.setAutoCommit(false);
				statement = con.createStatement();
				int hin_id = 0;
				int hospitalId = 0;
				String pname="";
	            int sexId=0;
	            int patient_type_id=0;
	            int pharmacyLabQueueIdForLab = 0; // addded by amit das on 25-10-2017
	            int pharmacyLabQueueIdForPharmacy = 0;  // addded by amit das on 25-10-2017
				boolean bool = false;
				String patientQuery = "select * from patient where hin_no= ?";
				PreparedStatement patientQueryPre=con.prepareStatement(patientQuery);  	
				patientQueryPre.setString(1, pid.getPid2_PatientIDExternalID().getCk1_IDNumber()
							.getValue()+""); 

				try {
					ResultSet resultSet =patientQueryPre.executeQuery(); //statement.executeQuery(patientQuery);
					while (resultSet.next()) {
						hin_id = resultSet.getInt("hin_id");
						pname=resultSet.getString("p_first_name");
                        sexId = resultSet.getInt("sex_id");
                        patient_type_id = resultSet.getInt("patient_type_id");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				if (hin_id != 0) {
					// ******************Visit*************************************

					// int
					// visit_no=Integer.parseInt(pid.getPid4_AlternatePatientID().getValue());
					int empId = Integer.parseInt(obr
							.getObr1_SetIDObservationRequest().getValue());
					int addEditById = Integer.parseInt(pv1
							.getPv148_TotalAdjustments().getValue());
					int visitNo = Integer.parseInt(pid
							.getPid19_SocialSecurityNumberPatient().getValue());
					int tokenNo = Integer.parseInt(pid
							.getPid27_VeteransMilitaryStatus().getValue());
					String age = pid.getPid17_Religion().getValue();
					if(age==null && "null".equalsIgnoreCase(age)){
						age="";
					}
					String status = pid.getPid21_MotherSIdentifier()
							.getCk1_IDNumber().getValue();
					String edStatus = pid.getPid5_PatientName()
							.getPn1_FamilyName().getValue();
					String appoinmentType = pv1.getPv118_PatientType()
							.getValue();
					int hospId = Integer.parseInt(pv1
							.getPv110_HospitalService().getValue());
					int priorityNo = Integer.parseInt(pv1
							.getPv13_AssignedPatientLocation()
							.getCm_internal_location2_Room().getValue());
					String curPhVisit = pv1.getPv141_AccountStatus().getValue();
					int totalVisitStatus = Integer.parseInt(pv1
							.getPv14_AdmissionType().getValue());
					int departId =Integer.parseInt(pv1.getPv138_DietType().getValue());
					// Date
					// date=convertStringTypeDateToSQLDate(pv1.getPv144_AdmitDateTime().getTs2_DegreeOfPrecision().getValue());
					Date date = new Date(new java.util.Date().getTime());
					if(pv1.getPv144_AdmitDateTime().getTs2_DegreeOfPrecision().getValue()!=null){ 
						DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
						try {
						java.util.Date	currentDt = (java.util.Date)formatter.parse(pv1.getPv144_AdmitDateTime().getTs2_DegreeOfPrecision().getValue());
						date=new Date(currentDt.getTime());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						 
					}
					
					date =   new Date(simpleDateFormat.parse(orm_O01.getMSH().getMsh7_DateTimeOfMessage().getTimeOfAnEvent().getValue()).getTime()); // added by amit das on 27-10-2017
					int hospIdForPharmacyLabQueue = hospId;
					
					String time = obr.getObr27_QuantityTiming(0).getDuration()
							.getValue();
					 String visitStatus = "C"; // commented by amit das on 26-08-2016 
					
					//pv1.getPv14_AdmissionType().getValue();
					
					//String visitStatus = pv1.getPv149_TotalPayments().getValue(); // added by amit das on 26-08-2016

					String visitQuery = "select * from visit where hin_id =? and department_id=? and visit_no=? and visit_date=? and hospital_id=?"; // changed by amit das on 07-12-2016
					PreparedStatement selectPrep = con
							.prepareStatement(visitQuery);
					int index = 1;
					selectPrep.setInt(index++, hin_id);
					selectPrep.setInt(index++, departId);
					selectPrep.setInt(index++, visitNo); // added by amit das on 07-12-2016
					selectPrep.setDate(index++, new Date(date.getTime()));
					selectPrep.setInt(index++, hospId);
					ResultSet visitResult = selectPrep.executeQuery();
					String updateVisit = "update visit set visit_status=?,cur_phar_visit_status=? where visit_id=?";
					int visit_id = 0;
					while (visitResult.next()) {
						visit_id = visitResult.getInt("visit_id");
						PreparedStatement updatePrepare = con
								.prepareStatement(updateVisit);
						index = 1;
						updatePrepare.setString(index++, visitStatus);
						updatePrepare.setString(index++, curPhVisit);
						updatePrepare.setInt(index++, visit_id);
						updatePrepare.executeUpdate();
						System.out.println("********Visit updated***********");

					}

					if(visit_id!=0) {  // added by amit das on 23-12-2016
					
					/*StringBuilder insertVisitField = new StringBuilder(
							"INSERT INTO visit(visit_no,token_no,hin_id,age,status,ed_status,appointment_type,priority_number,cur_phar_visit_status,total_hospital_visit,department_id,visit_date,visit_time,hospital_id,add_edit_by_id,visit_status,openby,openat");
					StringBuilder insertVisitValue = new StringBuilder(
							")VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					String insertVisit = insertVisitField.append(
							insertVisitValue).toString();
					PreparedStatement vs = con.prepareStatement(insertVisit,
							Statement.RETURN_GENERATED_KEYS);

					index = 1;

					vs.setInt(index++, visitNo);
					vs.setInt(index++, tokenNo);
					vs.setInt(index++, hin_id);
					vs.setString(index++, age);
					vs.setString(index++, status);
					vs.setString(index++, edStatus);
					vs.setString(index++, appoinmentType);
					vs.setInt(index++, priorityNo);
					vs.setString(index++, curPhVisit);
					vs.setInt(index++, totalVisitStatus);
					vs.setInt(index++, departId);
					vs.setDate(index++, date);
					vs.setString(index++, time);
					vs.setInt(index++, hospId);
					vs.setInt(index++, addEditById);
					vs.setString(index++, visitStatus);
					vs.setInt(index++, addEditById);
					vs.setString(index++, time);*/ // commented by amit das on 10-01-2017

				/*	if (visit_id == 0) {
						bool = vs.execute(); 
						if (!bool) {
							ResultSet vSet = vs.getGeneratedKeys();
							System.out.println("********Visit saved***********");
							while (vSet.next()) {
								visit_id = vSet.getInt("visit_id");
							}
						}
					}*/ // commented by amit das on 23-12-2016
					
					// **********************OPDPatientDetials**************************************

					int pulse = Integer.parseInt(pv1.getPv116_VIPIndicator()
							.getValue());
					String bp = pv1.getPv122_CourtesyCode().getValue();
					BigDecimal temp = new BigDecimal(pv1.getPv114_AdmitSource()
							.getValue());
					BigDecimal bmi = new BigDecimal(pv1
							.getPv146_CurrentPatientBalance().getValue());
					String systmeticExm = pid.getPid26_Citizenship(0)
							.getValue();
					String admisionAdvice=null;
					String adminssionward=null; 
					if(orc.getOrc2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().getValue()!=null){ 
						adminssionward=orc.getOrc2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().getValue();
					}
					if(orc.getOrc5_OrderStatus().getValue()!=null){ 
						admisionAdvice=orc.getOrc5_OrderStatus().getValue();
					}
					java.util.Date dateForAdmission=null;
					if(orc.getOrc10_EnteredBy().getCn1_IDNumber().getValue()!=null){ 
						DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
						try {
							dateForAdmission = (java.util.Date)formatter.parse(orc.getOrc10_EnteredBy().getCn1_IDNumber().getValue());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}  
					} 
					
					
					
					// added by amit das on 26-08-2016
					int opdPDetialsId = 0;
					String queryforGetOpdPatientDetails = "SELECT * FROM opd_patient_details where visit_id=?";
					PreparedStatement getOpdPatientDetials = con.prepareStatement(
							queryforGetOpdPatientDetails);
					getOpdPatientDetials.setInt(1, visit_id);
					getOpdPatientDetials.execute();
					ResultSet getOpdPDetialsSet = getOpdPatientDetials
								.getResultSet();
					
					if(getOpdPDetialsSet!=null && getOpdPDetialsSet.next()){
						opdPDetialsId = getOpdPDetialsSet.getInt("id");
					StringBuilder updateOPDPatientDetailsField = new StringBuilder("UPDATE opd_patient_details set employee_id=?,hospital_id=?,pulse=?,bp=?,temperature=?,bmi=?,systemic_examination=?,consultation_date=?,consultation_time=?,opd_date=?,opd_time=?,referred_hospital_id=?");
					if(admisionAdvice!=null){
						updateOPDPatientDetailsField.append(",admission_advised=?");
					}
					if(adminssionward!=null){
						updateOPDPatientDetailsField.append(",admission_ward=?");
					}
					if(dateForAdmission!=null){
						updateOPDPatientDetailsField.append(",admission_date=?");
					}
					updateOPDPatientDetailsField.append("where id = ?"); 
					PreparedStatement updateOpdPatientDetials = con.prepareStatement(
							updateOPDPatientDetailsField.toString(),
							Statement.RETURN_GENERATED_KEYS);
					index = 1;
					updateOpdPatientDetials.setInt(index++, empId);
					updateOpdPatientDetials.setInt(index++, hospId);
					updateOpdPatientDetials.setInt(index++, pulse);
					updateOpdPatientDetials.setString(index++, bp);
					updateOpdPatientDetials.setBigDecimal(index++, temp);
					updateOpdPatientDetials.setBigDecimal(index++, bmi);
					updateOpdPatientDetials.setString(index++, systmeticExm);
					updateOpdPatientDetials.setDate(index++, date);
					updateOpdPatientDetials.setString(index++, time);
					updateOpdPatientDetials.setDate(index++, date);
					updateOpdPatientDetials.setString(index++, time);
					updateOpdPatientDetials.setInt(index++, hospId);
					hospitalId = hospId;
					if(admisionAdvice!=null){
						updateOpdPatientDetials.setString(index++, admisionAdvice);;
					}
					if(adminssionward!=null){
						updateOpdPatientDetials.setInt(index++, Integer.parseInt(adminssionward));;
					}
					if(dateForAdmission!=null){
						updateOpdPatientDetials.setDate(index++, new Date(dateForAdmission.getTime()));;
					}
					updateOpdPatientDetials.setInt(index++, opdPDetialsId);
					bool = updateOpdPatientDetials.execute();
					if (!bool) {
						System.out.println("********opd_patient_details updated***********");
					}
					
					}else {
					// ended by amit das on 26-08-2016
					
					StringBuilder insertOPDPatientDetailsField = new StringBuilder(
							"INSERT INTO opd_patient_details(visit_id,employee_id,hospital_id,pulse,bp,temperature,bmi,systemic_examination,consultation_date,consultation_time,opd_date,opd_time,referred_hospital_id");
					if(admisionAdvice!=null){
						insertOPDPatientDetailsField.append(",admission_advised");
					}
					if(adminssionward!=null){
						insertOPDPatientDetailsField.append(",admission_ward");
					}
					if(dateForAdmission!=null){
						insertOPDPatientDetailsField.append(",admission_date");
					}
					StringBuilder insertOPDPatientDetailsValue = new StringBuilder(
							")VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?");
					if(admisionAdvice!=null){
						insertOPDPatientDetailsValue.append(",?");
					}
					if(adminssionward!=null){
						insertOPDPatientDetailsValue.append(",?");
					}
					if(dateForAdmission!=null){
						insertOPDPatientDetailsValue.append(",?");
					}
					insertOPDPatientDetailsValue.append(")");
					String insertOPDPatientDetails = insertOPDPatientDetailsField
							.append(insertOPDPatientDetailsValue).toString();
					PreparedStatement opdPDetials = con.prepareStatement(
							insertOPDPatientDetails,
							Statement.RETURN_GENERATED_KEYS);
					index = 1;
					opdPDetials.setInt(index++, visit_id);
					opdPDetials.setInt(index++, empId);
					opdPDetials.setInt(index++, hospId);
					opdPDetials.setInt(index++, pulse);
					opdPDetials.setString(index++, bp);
					opdPDetials.setBigDecimal(index++, temp);
					opdPDetials.setBigDecimal(index++, bmi);
					opdPDetials.setString(index++, systmeticExm);
					opdPDetials.setDate(index++, date);
					opdPDetials.setString(index++, time);
					opdPDetials.setDate(index++, date);
					opdPDetials.setString(index++, time);
					opdPDetials.setInt(index++, hospId);
					if(admisionAdvice!=null){
						opdPDetials.setString(index++, admisionAdvice);;
					}
					if(adminssionward!=null){
						opdPDetials.setInt(index++, Integer.parseInt(adminssionward));;
					}
					if(dateForAdmission!=null){
						opdPDetials.setDate(index++, new Date(dateForAdmission.getTime()));;
					}
					bool = opdPDetials.execute();
					if (!bool) {
						ResultSet opdPDetialsSet = opdPDetials
								.getGeneratedKeys();
						System.out.println("********opd_patient_details saved***********");
						while (opdPDetialsSet.next()) {
							opdPDetialsId = opdPDetialsSet.getInt("id");
						}
					}
					
					}

					// *************PatientObersvation*****************************

					// added by amit das on 29-08-2016
					int patientObersvationId = 0;
					String queryforGetPatientObservation = "SELECT * FROM patient_observation where opd_patient_details_id=?";
					PreparedStatement getPatientObservation = con.prepareStatement(
							queryforGetPatientObservation);
					getPatientObservation.setInt(1, opdPDetialsId);
					getPatientObservation.execute();
					ResultSet getPatientObservationSet = getPatientObservation
								.getResultSet();
					if(getPatientObservationSet!=null && getPatientObservationSet.next()){
					
					String updatePatientObservationField = "UPDATE patient_observation set pulse=?,temperature=?,bp=?,last_chg_by=?,last_chg_date=?,last_chg_time=? where opd_patient_details_id = ?"; 
					PreparedStatement updatePatientObservation = con.prepareStatement(
							updatePatientObservationField,
							Statement.RETURN_GENERATED_KEYS);
					index = 1;
					updatePatientObservation.setInt(index++, pulse);
					updatePatientObservation.setBigDecimal(index++, temp);
					updatePatientObservation.setString(index++, bp);
					updatePatientObservation.setInt(index++, addEditById);
					updatePatientObservation.setDate(index++, date);
					updatePatientObservation.setString(index++, time);
					updatePatientObservation.setInt(index++, opdPDetialsId);
					
					bool = updatePatientObservation.execute();
					patientObersvationId = 0;
					if (!bool) {
						ResultSet patientObservationSet = updatePatientObservation
								.getGeneratedKeys();
						System.out.println("********patient_observation updated***********");
						while (patientObservationSet.next()) {
							patientObersvationId = patientObservationSet.getInt("observation_id");
						}
					}
					
					} else {
					// ended by amit das on 29-08-2016
					
					StringBuilder insertPatientObersvationField = new StringBuilder(
							"INSERT INTO patient_observation(opd_patient_details_id,pulse,temperature,bp,last_chg_by,last_chg_date,last_chg_time");
					StringBuilder insertPatientObersvationValue = new StringBuilder(
							")VALUES(?,?,?,?,?,?,?)");

					String insertPatientObersvation = insertPatientObersvationField
							.append(insertPatientObersvationValue).toString();
					PreparedStatement patientObersvation = con
							.prepareStatement(insertPatientObersvation,
									Statement.RETURN_GENERATED_KEYS);
					index = 1;
					patientObersvation.setInt(index++, opdPDetialsId);
					patientObersvation.setInt(index++, pulse);
					patientObersvation.setBigDecimal(index++, temp);
					patientObersvation.setString(index++, bp);
					patientObersvation.setInt(index++, addEditById);
					patientObersvation.setDate(index++, date);
					patientObersvation.setString(index++, time);

					bool = patientObersvation.execute();
				
					if (!bool) {
						ResultSet patientObersvationSet = patientObersvation
								.getGeneratedKeys();
						System.out.println("********patient_observation saved***********");
						while (patientObersvationSet.next()) {
							patientObersvationId = patientObersvationSet
									.getInt("observation_id");
						}
					}
					
					}
					

					// ******************QueueManagment****************************

					int qMangtokenNo = Integer.parseInt(obr
							.getObr4_UniversalServiceID().getCe2_Text()
							.getValue());
					String tokenStatus = obr
							.getObr14_SpecimenReceivedDateTime()
							.getTs2_DegreeOfPrecision().getValue();
					int qMangPriorityNo = 0;
					String qMangPriorityNoStr = obr.getObr5_PriorityNotused().getValue();
					if(qMangPriorityNoStr!=null && !qMangPriorityNoStr.equals("") && !qMangPriorityNoStr.equalsIgnoreCase("null"))
							qMangPriorityNo = Integer.parseInt(qMangPriorityNoStr);
					
					int qMangTotalHsVisit = Integer.parseInt(pv1
							.getPv16_PriorPatientLocation()
							.getCm_internal_location3_Bed().getValue());

					StringBuilder insertQueueField = new StringBuilder(
							"INSERT INTO queue_managment(hin_id,department_id,hospital_id,visit_id,token_no,token_status,priority_number,total_hospital_visit,ls_cng_date");
					StringBuilder insertQueueValue = new StringBuilder(
							")VALUES(?,?,?,?,?,?,?,?,?)");

					String insertQueue = insertQueueField.append(
							insertQueueValue).toString();
					PreparedStatement qs = con.prepareStatement(insertQueue,
							Statement.RETURN_GENERATED_KEYS);
					index = 1;
					qs.setInt(index++, hin_id);
					qs.setInt(index++, departId);
					qs.setInt(index++, hospId);
					qs.setInt(index++, visit_id);
					qs.setInt(index++, qMangtokenNo);
					qs.setString(index++, tokenStatus);
					qs.setInt(index++, qMangPriorityNo);
					qs.setInt(index++, qMangTotalHsVisit);
					qs.setDate(index++, date);
					// qs.setString(index++, time);
					bool = qs.execute();
					int qsId = 0;
					if (!bool) {
						ResultSet qsSet = qs.getGeneratedKeys();
						System.out.println("********queue_managment saved***********");
						while (qsSet.next()) {
							qsId = qsSet.getInt("id");
						}
					}
					// ***************DischargeIcdCode***************************

					
					
					// added by amit das on 29-08-2016
					if(pid.getPid4_AlternatePatientID().getValue()!=null){
					
					int dIcdId = 0;
					String disDignostatus = obr
							.getObr24_DiagnosticServiceSectionID().getValue();
					int icdId = Integer.parseInt(pid
							.getPid4_AlternatePatientID().getValue());
					String disChargeStatus = obr.getObr18_PlacerField1()
							.getValue();
					
					String queryforGetPatientDischargeIcd = "SELECT * FROM discharge_icd_code where visit_id=?";
					PreparedStatement getPatientDischargeIcd = con.prepareStatement(
							queryforGetPatientDischargeIcd);
					getPatientDischargeIcd.setInt(1, visit_id);
					getPatientDischargeIcd.execute();
					
					ResultSet getPatientDischargeIcdSet = getPatientDischargeIcd
								.getResultSet();
					if(getPatientDischargeIcdSet!=null && getPatientDischargeIcdSet.next()){
					
					String updatePatientDischargeIcdField = "UPDATE discharge_icd_code set hin_id=?,icd_id=?,status=?,diagnosis_status=?,add_edit_date=?,add_edit_time=? where visit_id = ?"; 
					PreparedStatement updatePatientDischargeIcd = con.prepareStatement(
							updatePatientDischargeIcdField,
							Statement.RETURN_GENERATED_KEYS);
					index = 1;
					updatePatientDischargeIcd.setInt(index++, hin_id);
					updatePatientDischargeIcd.setInt(index++, icdId);
					updatePatientDischargeIcd.setString(index++, disChargeStatus);

					updatePatientDischargeIcd.setString(index++, disDignostatus);
					updatePatientDischargeIcd.setDate(index++, date);
					updatePatientDischargeIcd.setString(index++, time);
					updatePatientDischargeIcd.setInt(index++, visit_id);
					
					bool = updatePatientDischargeIcd.execute();
					dIcdId = 0;
					if (!bool) {
						ResultSet patientDischargeIcdSet = updatePatientDischargeIcd
								.getGeneratedKeys();
						System.out.println("********discharge_icd_code updated***********");
						while (patientDischargeIcdSet.next()) {
							dIcdId = patientDischargeIcdSet.getInt("discharge_icd_code_id");
						}
					}
					
					} else {
					// ended by amit das on 29-08-2016
					StringBuilder insertDisIcdCodeField = new StringBuilder(
							"INSERT INTO discharge_icd_code(hin_id,icd_id,status,diagnosis_status,add_edit_date,add_edit_time,visit_id");
					StringBuilder insertDisIcdCodeValue = new StringBuilder(
							")VALUES(?,?,?,?,?,?,?)");

					String insertDisChargeCode = insertDisIcdCodeField.append(
							insertDisIcdCodeValue).toString();
					PreparedStatement dIcd = con.prepareStatement(
							insertDisChargeCode,
							Statement.RETURN_GENERATED_KEYS);
					index = 1;
					dIcd.setInt(index++, hin_id);
					dIcd.setInt(index++, icdId);
					dIcd.setString(index++, disChargeStatus);

					dIcd.setString(index++, disDignostatus);
					dIcd.setDate(index++, date);
					dIcd.setString(index++, time);
					dIcd.setInt(index++, visit_id);
					bool = dIcd.execute();
					if (!bool) {
						ResultSet dIcdSet = dIcd.getGeneratedKeys();
						System.out.println("********discharge_icd_code saved***********");
						while (dIcdSet.next()) {
							dIcdId = dIcdSet.getInt("discharge_icd_code_id");
						}
					}
					
					}
				 }
					
					
					// **********PatientInvestigationHeader**************//
					int investigation_header_id = 0;
					String pInvesTigationHdrStatus = obr
							.getObr25_ResultStatus().getValue();
					
					// added by amit das on 29-08-2016
					String queryforGetPatientInvestigationHeader = "SELECT * FROM patient_investigation_header where opd_patient_detail_id=?";
					PreparedStatement getPatientInvestigationHeader = con.prepareStatement(
							queryforGetPatientInvestigationHeader);
					getPatientInvestigationHeader.setInt(1, opdPDetialsId);
					getPatientInvestigationHeader.execute();
				
					ResultSet getPatientInvestigationHeaderSet = getPatientInvestigationHeader
								.getResultSet();
					if(getPatientInvestigationHeaderSet!=null && getPatientInvestigationHeaderSet.next()){
					
					String updatePatientInvestigationHeaderField = "UPDATE patient_investigation_header set department_id=?,hospital_id=?,investigation_date=?,status=?,investigation_time=?,hin_id=?,visit_id=? where opd_patient_detail_id = ?"; 
					PreparedStatement updatePatientInvestigationHeader  = con.prepareStatement(
							updatePatientInvestigationHeaderField,
							Statement.RETURN_GENERATED_KEYS);
					index = 1;
					updatePatientInvestigationHeader.setInt(index++, departId);
					updatePatientInvestigationHeader.setInt(index++, hospId);
					updatePatientInvestigationHeader.setDate(index++, date);
					updatePatientInvestigationHeader.setString(index++, pInvesTigationHdrStatus);
					updatePatientInvestigationHeader.setString(index++, time);
					updatePatientInvestigationHeader.setInt(index++, hin_id);
					updatePatientInvestigationHeader.setInt(index++, visit_id);
					updatePatientInvestigationHeader.setInt(index++, opdPDetialsId);
					
					bool = updatePatientInvestigationHeader.execute();
					
					investigation_header_id = 0;
					if (!bool) {
						ResultSet patPatientInvestigationHeaderSet = updatePatientInvestigationHeader
								.getGeneratedKeys();
						System.out.println("********patient_investigation_header updated***********");
						while (patPatientInvestigationHeaderSet.next()) {
							investigation_header_id = patPatientInvestigationHeaderSet.getInt("investigation_header_id");
						}
					}
					
					
					} else {
					// ended by amit das on 29-08-2016
					
					
					StringBuilder insertPatientInvestigationHdrField = new StringBuilder(
							"INSERT INTO patient_investigation_header(department_id,hospital_id,status,investigation_date,investigation_time,hin_id,visit_id,opd_patient_detail_id");
					StringBuilder insertPatientInvestigationHdrValue = new StringBuilder(
							")VALUES(?,?,?,?,?,?,?,?)");
					String insertPatientInvestigationHdr = insertPatientInvestigationHdrField
							.append(insertPatientInvestigationHdrValue)
							.toString();
					PreparedStatement pIHdr = con.prepareStatement(
							insertPatientInvestigationHdr,
							Statement.RETURN_GENERATED_KEYS);
					index = 1;
					pIHdr.setInt(index++, departId);
					pIHdr.setInt(index++, hospId);
					pIHdr.setString(index++, pInvesTigationHdrStatus);
					pIHdr.setDate(index++, date);
					pIHdr.setString(index++, time);
					pIHdr.setInt(index++, hin_id);
					pIHdr.setInt(index++, visit_id);
					pIHdr.setInt(index++, opdPDetialsId);

					bool = pIHdr.execute();
					investigation_header_id = 0;
					if (!bool) {
						ResultSet pIHdrSet = pIHdr.getGeneratedKeys();
						System.out.println("********patient_investigation_header saved***********");
						while (pIHdrSet.next()) {
							investigation_header_id = pIHdrSet
									.getInt("investigation_header_id");
						}
					}
					
					}
					
					// 	***********DgOrderHeader***********************************//
					
					String orderNo = pv1.getPv124_ContractCode(0).getValue();
					int orderhd_id = 0;
					int sample_collection_header_id = 0;

					if(orderNo!=null){
					// added by amit das on 29-08-2016

					String testType = obr.getObr15_SpecimenSource()
								.getCm_sps3_Freetext().getValue();
					// String
					// patientType=obr.getObr9_CollectionVolume().getCq_quantity2_Units().getValue(); 
					int prescribedBy = Integer.parseInt(obr
								.getObr3_FillerOrderNumber()
								.getCm_filler1_UniqueFillerId().getValue());
					int netAmt = Integer.parseInt(obr
								.getObr23_ChargeToPractice()
								.getCm_moc1_DollarAmount().getValue());
					String orderStatus = obr.getObr19_PlacerField2().getValue();
					// String
					// blChargeSlipNo=pv1.getPv147_TotalCharges().getValue();
					String queryforGetDgOrderHdr = "SELECT * FROM dg_orderhd where visit_id=?";
					PreparedStatement getDgOrderHdr= con.prepareStatement(
							queryforGetDgOrderHdr);
					getDgOrderHdr.setInt(1, visit_id);
					getDgOrderHdr.execute();
					
					ResultSet getDgOrderHdrSet = getDgOrderHdr
								.getResultSet();
					if(getDgOrderHdrSet!=null && getDgOrderHdrSet.next()){
					
					String updateDgOrderHdrField = "UPDATE dg_orderhd set hospital_id=?,department_id=?,test_type=?,prescribed_by=?,order_no=?,patient_type=?,order_status=?,last_chg_date=?,last_chg_time=?,net_amount=?,order_date=?,order_time=?,hin_id=?,last_chg_by=?,investigation_requestion_no=? where visit_id = ?"; 
					PreparedStatement updateDgOrderHdr  = con.prepareStatement(
							updateDgOrderHdrField,
							Statement.RETURN_GENERATED_KEYS);
					index = 1;
					updateDgOrderHdr.setInt(index++, hospId);
					updateDgOrderHdr.setInt(index++, departId);
					updateDgOrderHdr.setString(index++, testType);

					updateDgOrderHdr.setInt(index++, prescribedBy);
					updateDgOrderHdr.setString(index++, orderNo);  
					updateDgOrderHdr.setString(index++, "OP"); 
					updateDgOrderHdr.setString(index++, orderStatus);
					updateDgOrderHdr.setDate(index++, date);
					updateDgOrderHdr.setString(index++, time);
					updateDgOrderHdr.setInt(index++, netAmt);
					updateDgOrderHdr.setDate(index++, date);
					updateDgOrderHdr.setString(index++, time);
					updateDgOrderHdr.setInt(index++, hin_id);
					updateDgOrderHdr.setInt(index++, addEditById);
					updateDgOrderHdr.setInt(index++, investigation_header_id);
					updateDgOrderHdr.setInt(index++, visit_id);
					
					bool = updateDgOrderHdr.execute();
					
					orderhd_id = 0;
					if (!bool) {
						ResultSet dgOrderHdrSet = updateDgOrderHdr
								.getGeneratedKeys();
						System.out.println("********dg_orderhd updated***********");
						while (dgOrderHdrSet.next()) {
							orderhd_id = dgOrderHdrSet.getInt("orderhd_id");
						}
					}
					
					
					} else {
					// ended by amit das on 29-08-2016
					

						StringBuilder insertDgOrderHdrField = new StringBuilder(
								"INSERT INTO dg_orderhd(hospital_id,department_id,test_type,prescribed_by,order_no,patient_type,order_status,last_chg_date,last_chg_time,net_amount,order_date,order_time,hin_id,last_chg_by,investigation_requestion_no,visit_id");
						StringBuilder insertDgOrderHdrValue = new StringBuilder(
								")VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
						String insertDgOrderHdrId = insertDgOrderHdrField.append(
								insertDgOrderHdrValue).toString();
						PreparedStatement dgHdr = con
								.prepareStatement(insertDgOrderHdrId,
										Statement.RETURN_GENERATED_KEYS);

						index = 1;
						dgHdr.setInt(index++, hospId);
						dgHdr.setInt(index++, departId);
						dgHdr.setString(index++, testType);

						dgHdr.setInt(index++, prescribedBy);
						dgHdr.setString(index++, orderNo);  
						dgHdr.setString(index++, "OP"); 
						dgHdr.setString(index++, orderStatus);
						dgHdr.setDate(index++, date);
						dgHdr.setString(index++, time);
						dgHdr.setInt(index++, netAmt);
						dgHdr.setDate(index++, date);
						dgHdr.setString(index++, time);
						dgHdr.setInt(index++, hin_id);
						dgHdr.setInt(index++, addEditById);
						dgHdr.setInt(index++, investigation_header_id);
						dgHdr.setInt(index++, visit_id);
						// dgHdr.setString(index++, blChargeSlipNo);
						bool=true;
						if(orderNo!=null &&!("null".equalsIgnoreCase(orderNo))){
							bool = dgHdr.execute();
						}  
						if (!bool) {
							ResultSet dgHdrSet = dgHdr.getGeneratedKeys();
							System.out.println("********dg_orderhd saved*************");
							while (dgHdrSet.next()) {
								orderhd_id = dgHdrSet.getInt("orderhd_id");
							}

						}
					}
					
					}
					

					// *******************pharmacy lab queue*****************************
					  if(obx!= null && obx.getObservationSubID().getValue()!=null){
							String[] tokenNoArray 			 = obx.getResponsibleObserver().getCn2_FamilyName().getValue().split(",");
							String[] departmentArray 		 = obx.getObx7_ReferencesRange().getValue().split(",");
							String[] pharmacyLabStatusArray  = obx.getObservationIdentifier().getCe1_Identifier().getValue().split(",");
							String[] statusArray 			 = obx.getObservationSubID().getValue().split(",");
							String[] totalHospitalVisitArray = obx.getObx10_NatureOfAbnormalTest().getValue().split(",");
							String[] dgOrderHdArray			 = obx.getObx11_ObservationResultStatus().getValue().split(",");
							int pharmacyLabQueueSize		 = Integer.parseInt(obx.getObx13_UserDefinedAccessChecks().getValue());
							
							String queryforGetPharmacyLabQueue = "SELECT * FROM pharmacy_lab_queue where visit_id=? and token_no=?";
							String updatePharmacyLabQueueField = "UPDATE pharmacy_lab_queue set opd_date=?,opd_time=? where visit_id=? and token_no=?"; 
							String insertPharmacyLabQueue = "INSERT INTO pharmacy_lab_queue(visit_id,token_no,department_id,hospital_id,opd_date,opd_time,pharmacy_lab_status,status,total_hospital_visit,dg_orderhd_id)VALUES(?,?,?,?,?,?,?,?,?,?)";
							
							for(int i=0;i<pharmacyLabQueueSize;i++){
								index = 1;
								PreparedStatement insertPharmacyLabQueueStatement = con.prepareStatement(
										insertPharmacyLabQueue,Statement.RETURN_GENERATED_KEYS);
								PreparedStatement getPharmacyLabQueue = con.prepareStatement(
										queryforGetPharmacyLabQueue);
								
								getPharmacyLabQueue.setInt(1, visit_id);
								getPharmacyLabQueue.setInt(2, Integer.parseInt(tokenNoArray[i].trim()));
								getPharmacyLabQueue.execute();
								
								ResultSet getPharmacyLabQueueSet = getPharmacyLabQueue
											.getResultSet();
								if(getPharmacyLabQueueSet!=null && getPharmacyLabQueueSet.next()){
									PreparedStatement updatePharmacyLabQueue  = con.prepareStatement(
											updatePharmacyLabQueueField,
											Statement.RETURN_GENERATED_KEYS);
									updatePharmacyLabQueue.setDate(1, date);
									updatePharmacyLabQueue.setString(2, time);
									updatePharmacyLabQueue.setInt(3, visit_id);
									updatePharmacyLabQueue.setInt(4, Integer.parseInt(tokenNoArray[i].trim()));
									bool = updatePharmacyLabQueue.execute();
									if (!bool) {
										ResultSet updatePharmacyLabQueueSet = updatePharmacyLabQueue
												.getGeneratedKeys();
										System.out.println("********pharmacy lab queue updated***********");
										while (updatePharmacyLabQueueSet.next()) {
											if(dgOrderHdArray[i].trim().equalsIgnoreCase("Y"))
												pharmacyLabQueueIdForLab = updatePharmacyLabQueueSet.getInt("id");
											else
												pharmacyLabQueueIdForPharmacy = updatePharmacyLabQueueSet.getInt("id");
										}
									}
									
								}else{
								
								
								insertPharmacyLabQueueStatement.setInt(index++, visit_id);
								
								if(!tokenNoArray[i].trim().equals(""))
									insertPharmacyLabQueueStatement.setInt(index++, Integer.parseInt(tokenNoArray[i].trim()));
								else
									insertPharmacyLabQueueStatement.setNull(index++, java.sql.Types.INTEGER);
								
								insertPharmacyLabQueueStatement.setInt(index++, Integer.parseInt(departmentArray[i].trim()));
								insertPharmacyLabQueueStatement.setInt(index++, hospIdForPharmacyLabQueue);
								insertPharmacyLabQueueStatement.setDate(index++, date);
								insertPharmacyLabQueueStatement.setString(index++, time);
								insertPharmacyLabQueueStatement.setString(index++, pharmacyLabStatusArray[i].trim());
								insertPharmacyLabQueueStatement.setString(index++, statusArray[i].trim());
								insertPharmacyLabQueueStatement.setInt(index++, Integer.parseInt(totalHospitalVisitArray[i].trim()));
								if(dgOrderHdArray[i].trim().equalsIgnoreCase("Y") && orderhd_id!=0)
									insertPharmacyLabQueueStatement.setInt(index++, orderhd_id);
								else
									insertPharmacyLabQueueStatement.setNull(index++, java.sql.Types.INTEGER);
								
								bool = insertPharmacyLabQueueStatement.execute();
								
								if (!bool) {
									ResultSet insertPharmacyLabQueueStatementSet = insertPharmacyLabQueueStatement
											.getGeneratedKeys();
									System.out.println("********pharmacy lab queue saved***********");
									while (insertPharmacyLabQueueStatementSet.next()) {
										if(dgOrderHdArray[i].trim().equalsIgnoreCase("Y"))
											pharmacyLabQueueIdForLab = insertPharmacyLabQueueStatementSet.getInt("id");
										else
											pharmacyLabQueueIdForPharmacy = insertPharmacyLabQueueStatementSet.getInt("id");
									}
								}
								
							}
						 }
					  }
					

					// *******************PatientPrescriptionHeader****************************

					int pphdrId = 0;
					String patientPrescriptionNo = pv1
							.getPv115_AmbulatoryStatus(0).getValue();
					
					String patientPrescrStatus = obr
							.getObr2_PlacerOrderNumber()
							.getCm_placer1_UniquePlacerId().getValue();
					
					// added by amit das on 29-08-2016
					String queryforGetPatPrecriptionHeader = "SELECT * FROM patient_prescription_header where opd_patient_detail_id=?";
					PreparedStatement getPatPrecriptionHeader = con.prepareStatement(
							queryforGetPatPrecriptionHeader);
					getPatPrecriptionHeader.setInt(1, opdPDetialsId);
					getPatPrecriptionHeader.execute();
					ResultSet getPatPrecriptionHeaderSet = getPatPrecriptionHeader
								.getResultSet();
					if(getPatPrecriptionHeaderSet!=null && getPatPrecriptionHeaderSet.next()){
					
					String updatePatPrecriptionHeaderField = "UPDATE patient_prescription_header set department_id=?,hospital_id=?,prescription_date=?,status=?,prescription_time=?,prescription_no=?,hin_id=?,visit_id=?,dispencing_date=?,pharmacy_lab_queue_id=? where opd_patient_detail_id = ?"; 
					PreparedStatement updatePatPrecriptionHeader  = con.prepareStatement(
							updatePatPrecriptionHeaderField,
							Statement.RETURN_GENERATED_KEYS);
					index = 1;
					updatePatPrecriptionHeader.setInt(index++, departId);
					updatePatPrecriptionHeader.setInt(index++, hospId);
					updatePatPrecriptionHeader.setDate(index++, date);

					updatePatPrecriptionHeader.setString(index++, patientPrescrStatus);
					updatePatPrecriptionHeader.setString(index++, time);
					updatePatPrecriptionHeader.setString(index++, patientPrescriptionNo);
					updatePatPrecriptionHeader.setInt(index++, hin_id);
					updatePatPrecriptionHeader.setInt(index++, visit_id);
					updatePatPrecriptionHeader.setDate(index++, date);
					updatePatPrecriptionHeader.setInt(index++, pharmacyLabQueueIdForPharmacy);
					updatePatPrecriptionHeader.setInt(index++, opdPDetialsId);
					bool=true;
					if(patientPrescriptionNo!=null && !("null".equalsIgnoreCase(patientPrescriptionNo))){
						bool = updatePatPrecriptionHeader.execute();
					}
					pphdrId = 0;
					if (!bool) {
						ResultSet patPrecriptionHeaderSet = updatePatPrecriptionHeader
								.getGeneratedKeys();
						System.out.println("********patient_prescription_header updated***********");
						while (patPrecriptionHeaderSet.next()) {
							pphdrId = patPrecriptionHeaderSet.getInt("prescription_id");
						}
					}
					
					
					} else {
					// ended by amit das on 29-08-2016
					
					StringBuilder insertPatPrecriptionHeaderField = new StringBuilder(
							"INSERT INTO patient_prescription_header(department_id,hospital_id,prescription_date,status,prescription_time,prescription_no,hin_id,visit_id,opd_patient_detail_id,dispencing_date,pharmacy_lab_queue_id");
					StringBuilder insertPatPrecriptionHeaderValue = new StringBuilder(
							")VALUES(?,?,?,?,?,?,?,?,?,?,?)");

					String insertPatientPrecriptionHdr = insertPatPrecriptionHeaderField
							.append(insertPatPrecriptionHeaderValue).toString();
					PreparedStatement pphdr = con.prepareStatement(
							insertPatientPrecriptionHdr,
							Statement.RETURN_GENERATED_KEYS);
					index = 1;
					pphdr.setInt(index++, departId);
					pphdr.setInt(index++, hospId);
					pphdr.setDate(index++, date);

					pphdr.setString(index++, patientPrescrStatus);
					pphdr.setString(index++, time);
					pphdr.setString(index++, patientPrescriptionNo);
					pphdr.setInt(index++, hin_id);
					pphdr.setInt(index++, visit_id);
					pphdr.setInt(index++, opdPDetialsId);
					pphdr.setDate(index++, date);
					pphdr.setInt(index++, pharmacyLabQueueIdForPharmacy);
					bool=true;
					if(patientPrescriptionNo!=null && !("null".equalsIgnoreCase(patientPrescriptionNo))){
						bool = pphdr.execute();
					} 
					if (!bool) {
						ResultSet pphHdrSet = pphdr.getGeneratedKeys();
						System.out.println("********patient_prescription_header saved***********");
						while (pphHdrSet.next()) {
							pphdrId = pphHdrSet.getInt("prescription_id");
						}
					}
					
					}
					
					
					// **********************patientPrescriptionDetailsListObject***********************//
					
					
					String[] type2=null;
					if(pid.getPid22_EthnicGroup().getValue()!=null){
						String[] item = pid.getPid22_EthnicGroup().getValue()
								.split(",");
						String[] frq = pv1.getPv128_InterestCode().getValue()
								.split(",");
						String[] doges = pv1.getPv131_BadDebtAgencyCode()
								.getValue().split(",");

						type2 = pv1.getPv150_AlternateVisitID()
								.getCm_pat_id_01921_IDNumber().getValue()
								.split(",");
						String[] nursingStatus = pv1.getPv111_TemporaryLocation()
								.getCm_internal_location3_Bed().getValue()
								.split(",");
						String[] injectionStatus = pv1
								.getPv129_TransferToBadDebtCode().getValue()
								.split(",");
						String[] total = pv1.getPv117_AdmittingDoctor()
								.getCn1_IDNumber().getValue().split(",");
						String[] noOfDays = pv1.getPv15_PreadmitNumber().getValue()
								.split(","); 
						
						
						
						// added by amit das on 29-08-2016
						String queryforGetPatientPrescriptionDetails = "SELECT * FROM patient_prescription_details where prescription_id=? and item_id=?";
						StringBuilder insertPatientPrecriptionDetailsField = new StringBuilder(
								"INSERT INTO patient_prescription_details(item_id,dosage,frequency_id,no_of_days,total,type,nursing_status,injection_status,prescription_id,start_date,end_date");
						StringBuilder insertPatientPrecriptionDetailsValue = new StringBuilder(
								")VALUES(?,?,?,?,?,?,?,?,?,?,?)");

						String insertPatientPrescriptionDetails = insertPatientPrecriptionDetailsField
								.append(insertPatientPrecriptionDetailsValue)
								.toString();
						String updatePatientPrescriptionDetailsField = "UPDATE patient_prescription_details set dosage=?,frequency_id=?,no_of_days=?,total=?,type=?,nursing_status=?,injection_status=?,start_date=?,end_date=? where prescription_id = ? and item_id=?"; 

						

						for (int a = 0; a < item.length; a++) {
						if(!item[a].equals("0")){	
						PreparedStatement getPatientPrescriptionDetails  = con.prepareStatement(
								queryforGetPatientPrescriptionDetails);
						getPatientPrescriptionDetails.setInt(1, pphdrId);
						getPatientPrescriptionDetails.setInt(2, Integer.parseInt(item[a]));
						
						getPatientPrescriptionDetails.execute();
						ResultSet getPatientPrescriptionDetailSet = getPatientPrescriptionDetails
									.getResultSet();
						if(getPatientPrescriptionDetailSet!=null && getPatientPrescriptionDetailSet.next()){
						
						
						PreparedStatement updatePatientPrescriptionDetails  = con.prepareStatement(
								updatePatientPrescriptionDetailsField,
								Statement.RETURN_GENERATED_KEYS);
						index = 1;
						updatePatientPrescriptionDetails.setBigDecimal(index++, new BigDecimal(""
								+ doges[a]));
						updatePatientPrescriptionDetails.setInt(index++, Integer.parseInt(frq[a]));
						updatePatientPrescriptionDetails
								.setInt(index++, Integer.parseInt(noOfDays[a]));
						
						updatePatientPrescriptionDetails.setBigDecimal(index++, new BigDecimal(""
								+ total[a]));
						
						updatePatientPrescriptionDetails.setString(index++, "OP");
						updatePatientPrescriptionDetails.setString(index++, nursingStatus[a]);
						updatePatientPrescriptionDetails.setString(index++, injectionStatus[a]);
						updatePatientPrescriptionDetails.setDate(index++, date);
						updatePatientPrescriptionDetails.setDate(index++, date);
						updatePatientPrescriptionDetails.setInt(index++, pphdrId);
						updatePatientPrescriptionDetails.setInt(index++, Integer.parseInt(item[a]));
						bool = updatePatientPrescriptionDetails.execute();
						if (!bool) {
							ResultSet patientPrescriptionDetailsSet = updatePatientPrescriptionDetails
									.getGeneratedKeys();
							System.out.println("********patient_prescription_details updated***********");
						}
						
						} else {
						// ended by amit das on 29-08-2016	
						
						// for (int a = 0; a < item.length; a++) { // commented by amit das on 29-08-2016
						PreparedStatement ppDetials = con.prepareStatement(
								insertPatientPrescriptionDetails,
								Statement.RETURN_GENERATED_KEYS);
						index = 1;
						ppDetials.setInt(index++, Integer.parseInt(item[a]));
						ppDetials.setBigDecimal(index++, new BigDecimal(""
								+ doges[a]));
						ppDetials.setInt(index++, Integer.parseInt(frq[a]));
						ppDetials
								.setInt(index++, Integer.parseInt(noOfDays[a]));
						ppDetials.setBigDecimal(index++, new BigDecimal(""
								+ total[a]));
						ppDetials.setString(index++, "OP");
						ppDetials.setString(index++, nursingStatus[a]);
						ppDetials.setString(index++, injectionStatus[a]);
						ppDetials.setInt(index++, pphdrId);
						ppDetials.setDate(index++, date);
						ppDetials.setDate(index++, date);

						/*
						 * ppDetials.setDate(index++, date);
						 * ppDetials.setString(index++, time);
						 */
						bool=true;
						if(pphdrId!=0){
							bool = ppDetials.execute();
						} 
						int ppDetialsId = 0;
						if (!bool) {
							ResultSet ppDetialsSet = ppDetials
									.getGeneratedKeys();
							System.out.println("********patient_prescription_details saved***********");
							while (ppDetialsSet.next()) {
								ppDetialsId = ppDetialsSet.getInt("id");
							}

						}
					}
					
						}	
						
					}
					
				}
					
					
			
					
						
						// *******************DgSampleColledtionHeader*****************************
				  if(obr.getObr10_CollectorIdentifier(0)
								.getCn1_IDNumber().getValue()!=null){
					  
					  
						String DgSampleStatus = obr.getObr10_CollectorIdentifier(0)
								.getCn1_IDNumber().getValue();
						int radioDeptId = Integer.parseInt(obr
								.getObr13_RelevantClinicalInformation().getValue());
						
						
						// added by amit das on 30-08-2016
						String queryforGetDgSampleColletionHdr = "SELECT * FROM dg_sample_collection_header where order_id=?";
						PreparedStatement getDgSampleColletionHdr  = con.prepareStatement(
								queryforGetDgSampleColletionHdr);
						getDgSampleColletionHdr.setInt(1, orderhd_id);
						getDgSampleColletionHdr.execute();
						
						ResultSet getDgSampleColletionHdrSet = getDgSampleColletionHdr
									.getResultSet();
						if(getDgSampleColletionHdrSet!=null && getDgSampleColletionHdrSet.next()){
						
						String updateDgSampleColletionHdrField = "UPDATE dg_sample_collection_header set last_chg_time=?,last_chg_date=?,order_status=?,department_id=?,hospital_id=?,hin_id=?,last_chg_by=?,diagnosis_date=?,diagnosis_time=?,sample_validation_date=?,sample_validation_time=? where order_id = ?"; 
						PreparedStatement updateDgSampleColletionHdr  = con.prepareStatement(
								updateDgSampleColletionHdrField,
								Statement.RETURN_GENERATED_KEYS);
						index = 1;
						updateDgSampleColletionHdr.setString(index++, time);
						updateDgSampleColletionHdr.setDate(index++, date);
						updateDgSampleColletionHdr.setString(index++, DgSampleStatus);
						updateDgSampleColletionHdr.setInt(index++, radioDeptId);
						updateDgSampleColletionHdr.setInt(index++, hospId);
						updateDgSampleColletionHdr.setInt(index++, hin_id);
						updateDgSampleColletionHdr.setInt(index++, addEditById);
						updateDgSampleColletionHdr.setDate(index++, date);
						updateDgSampleColletionHdr.setString(index++, time);
						updateDgSampleColletionHdr.setDate(index++, date);
						updateDgSampleColletionHdr.setString(index++, time);
						updateDgSampleColletionHdr.setInt(index++, orderhd_id);
						
						bool = updateDgSampleColletionHdr.execute();
						
						sample_collection_header_id = 0;
						if (!bool) {
							ResultSet dgSampleColletionHdrSet = updateDgSampleColletionHdr
									.getGeneratedKeys();
							System.out.println("********dg_sample_collection_header updated***********");
							while (dgSampleColletionHdrSet.next()) {
								sample_collection_header_id = dgSampleColletionHdrSet.getInt("sample_collection_header_id");
							}
						}
						
						
						} else {
						// ended by amit das on 30-08-2016
						
						StringBuilder insertDgSampleColletionHdrField = new StringBuilder(
								"INSERT INTO dg_sample_collection_header(last_chg_time,last_chg_date,order_status,department_id,hospital_id,hin_id,order_id,last_chg_by,diagnosis_date,diagnosis_time,sample_validation_date,sample_validation_time");
						StringBuilder insertDgSampleColletionHdrValue = new StringBuilder(
								")VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
						String insertDgSampleCollectionHdr = insertDgSampleColletionHdrField
								.append(insertDgSampleColletionHdrValue).toString();
						PreparedStatement dgSample = con.prepareStatement(
								insertDgSampleCollectionHdr,
								Statement.RETURN_GENERATED_KEYS);
						index = 1;
						dgSample.setString(index++, time);
						dgSample.setDate(index++, date);
						dgSample.setString(index++, DgSampleStatus);
						dgSample.setInt(index++, radioDeptId);
						dgSample.setInt(index++, hospId);
						dgSample.setInt(index++, hin_id);
						dgSample.setInt(index++, orderhd_id);
						dgSample.setInt(index++, addEditById);
						dgSample.setDate(index++, date);
						dgSample.setString(index++, time);
						dgSample.setDate(index++, date);
						dgSample.setString(index++, time);
						bool=true;
						if(orderhd_id!=0){
							bool = dgSample.execute();
						}  
						if (!bool) {
							ResultSet dgSampleSet = dgSample.getGeneratedKeys();
							System.out.println("********dg_sample_collection_header saved***********");
							while (dgSampleSet.next()) {
								sample_collection_header_id = dgSampleSet
										.getInt("sample_collection_header_id");
							}
						}
						
						}
						
					 }
					
					

					

					// ******************OPDPatientHistory********************************

					String hisStatus = pv1.getPv123_CreditRating().getValue();

					
					// added by amit das on 30-08-2016
					int opd_patient_history_id = 0;
					String queryforGetOPDPatientHistory = "SELECT * FROM opd_patient_history where opd_patient_details=?";
					PreparedStatement getOPDPatientHistory  = con.prepareStatement(
							queryforGetOPDPatientHistory);
					getOPDPatientHistory.setInt(1, opdPDetialsId);
					getOPDPatientHistory.execute();
					
					ResultSet getOPDPatientHistorySet = getOPDPatientHistory
								.getResultSet();
					if(getOPDPatientHistorySet!=null && getOPDPatientHistorySet.next()){
					
					String updateOPDPatientHistoryField = "UPDATE opd_patient_history set visit_inpatient_id=?,hin_id=?,department_id=?,last_chg_by=?,last_chg_date=?,last_chg_time=?,status=?,hospital_id=?,ip_op_pac_status=? where opd_patient_details = ?"; 
					PreparedStatement updateOPDPatientHistory  = con.prepareStatement(
							updateOPDPatientHistoryField,
							Statement.RETURN_GENERATED_KEYS);
					index = 1;
					updateOPDPatientHistory.setInt(index++, visit_id);
					updateOPDPatientHistory.setInt(index++, hin_id);
					updateOPDPatientHistory.setInt(index++, departId);
					updateOPDPatientHistory.setInt(index++, addEditById);
					updateOPDPatientHistory.setDate(index++, date);
					updateOPDPatientHistory.setString(index++, time);
					updateOPDPatientHistory.setString(index++, hisStatus);
					updateOPDPatientHistory.setInt(index++, hospId);
					updateOPDPatientHistory.setString(index++, "OP");
					updateOPDPatientHistory.setInt(index++, opdPDetialsId);
					
					bool = updateOPDPatientHistory.execute();
					
					opd_patient_history_id = 0;
					if (!bool) {
						ResultSet oPDPatientHistorySet = updateOPDPatientHistory
								.getGeneratedKeys();
						System.out.println("********opd_patient_history updated***********");
						while (oPDPatientHistorySet.next()) {
							opd_patient_history_id = oPDPatientHistorySet.getInt("opd_patient_history_id");
						}
					}
					
					} else {
					// ended by amit das on 30-08-2016
					
					StringBuilder insertOPDPatientHistoryField = new StringBuilder(
							"INSERT INTO opd_patient_history(visit_inpatient_id,hin_id,department_id,last_chg_by,last_chg_date,last_chg_time,status,hospital_id,ip_op_pac_status,opd_patient_details");
					StringBuilder insertOPDPatientHistoryValue = new StringBuilder(
							")VALUES(?,?,?,?,?,?,?,?,?,?)");

					String insertOPDPatientHistory = insertOPDPatientHistoryField
							.append(insertOPDPatientHistoryValue).toString();
					PreparedStatement patientHistory = con.prepareStatement(
							insertOPDPatientHistory,
							Statement.RETURN_GENERATED_KEYS);
					index = 1;
					patientHistory.setInt(index++, visit_id);
					patientHistory.setInt(index++, hin_id);
					patientHistory.setInt(index++, departId);
					patientHistory.setInt(index++, addEditById);
					patientHistory.setDate(index++, date);
					patientHistory.setString(index++, time);
					patientHistory.setString(index++, hisStatus);
					patientHistory.setInt(index++, hospId);
					patientHistory.setString(index++, "OP");
					patientHistory.setInt(index++, opdPDetialsId);

					bool = patientHistory.execute();
					if (!bool) {
						ResultSet patientHistorySet = patientHistory
								.getGeneratedKeys();
						System.out.println("********opd_patient_history saved***********");
						while (patientHistorySet.next()) {
							opd_patient_history_id = patientHistorySet
									.getInt("opd_patient_history_id");
						}
					}
					}
					
					
					// ********************************OpdPatientAllergyM*************************
					String mStatus = obr.getObr15_SpecimenSource()
							.getCm_sps2_Additives().getValue();

					// added by amit das on 30-08-2016
					int opdPatientAllergy_Id = 0;
					String queryforGetOpdPatientAllergyM = "SELECT * FROM opd_patient_allergy_m where visit_id=?";
					PreparedStatement getOpdPatientAllergyM  = con.prepareStatement(
							queryforGetOpdPatientAllergyM);
					getOpdPatientAllergyM.setInt(1, visit_id);
					getOpdPatientAllergyM.execute();

					ResultSet getOpdPatientAllergyMSet = getOpdPatientAllergyM
								.getResultSet();
					if(getOpdPatientAllergyMSet!=null && getOpdPatientAllergyMSet.next()){
					
					String updateOpdPatientAllergyMField = "UPDATE opd_patient_allergy_m set employee_id=?,department_id=?,hospital_id=?,status=?,last_chg_date=?,last_chg_time=?,hin_id=?,last_chg_by=? where visit_id = ?"; 
					PreparedStatement updateOpdPatientAllergyM  = con.prepareStatement(
							updateOpdPatientAllergyMField,
							Statement.RETURN_GENERATED_KEYS);
					index = 1;
					updateOpdPatientAllergyM.setInt(index++, empId);
					updateOpdPatientAllergyM.setInt(index++, departId);
					updateOpdPatientAllergyM.setInt(index++, hospId);
					updateOpdPatientAllergyM.setString(index++, mStatus);
					updateOpdPatientAllergyM.setDate(index++, date);
					updateOpdPatientAllergyM.setString(index++, time);
					updateOpdPatientAllergyM.setInt(index++, hin_id);
					updateOpdPatientAllergyM.setInt(index++, addEditById);
					updateOpdPatientAllergyM.setInt(index++, visit_id);
					bool = updateOpdPatientAllergyM.execute();
					
					opdPatientAllergy_Id = 0;
					if (!bool) {
						ResultSet opdPatientAllergyMSet = updateOpdPatientAllergyM
								.getGeneratedKeys();
						System.out.println("********opd_patient_allergy_m updated***********");
						while (opdPatientAllergyMSet.next()) {
							opdPatientAllergy_Id = opdPatientAllergyMSet.getInt("m_id");
						}
					}
					
					
					} else {
					// ended by amit das on 30-08-2016
					
					StringBuilder insertOPDAlergyMField = new StringBuilder(
							"INSERT INTO opd_patient_allergy_m(employee_id,department_id,hospital_id,status,last_chg_date,last_chg_time,visit_id,hin_id,last_chg_by");
					StringBuilder insertOPDAlergyMValue = new StringBuilder(
							")VALUES(?,?,?,?,?,?,?,?,?)");

					String insertOPDpatientAlrgyM = insertOPDAlergyMField
							.append(insertOPDAlergyMValue).toString();
					PreparedStatement opdPatientAllergy = con.prepareStatement(
							insertOPDpatientAlrgyM,
							Statement.RETURN_GENERATED_KEYS);
					index = 1;
					opdPatientAllergy.setInt(index++, empId);
					opdPatientAllergy.setInt(index++, departId);
					opdPatientAllergy.setInt(index++, hospId);
					opdPatientAllergy.setString(index++, mStatus);
					opdPatientAllergy.setDate(index++, date);
					opdPatientAllergy.setString(index++, time);
					opdPatientAllergy.setInt(index++, visit_id);
					opdPatientAllergy.setInt(index++, hin_id);
					opdPatientAllergy.setInt(index++, addEditById);

					bool = opdPatientAllergy.execute();
					opdPatientAllergy_Id = 0;
					if (!bool) {
						ResultSet OPDALLMSet = opdPatientAllergy
								.getGeneratedKeys();
						System.out.println("********opd_patient_allergy_m saved***********");
						while (OPDALLMSet.next()) {
							opdPatientAllergy_Id = OPDALLMSet.getInt("m_id");
						}
					}
					
					}
					
					
					
					// ******************************ProcedureHeader**************************
					// added by amit das on 30-08-2016
					if(obr.getObr21_FillerField2()!=null || obr.getObr21_FillerField2().getValue().equals("")){ // added by amit das on 18-07-2017
					int poceHdrId = 0;
					String prcedStatus = obr.getObr21_FillerField2().getValue();
					String queryforGetProcedureHeader= "SELECT * FROM procedure_header where visit_id=?";
					PreparedStatement getProcedureHeader = con.prepareStatement(
							queryforGetProcedureHeader);
					getProcedureHeader.setInt(1, visit_id);
					getProcedureHeader.execute();
					ResultSet getProcedureHeaderSet = getProcedureHeader
								.getResultSet();
					if(getProcedureHeaderSet!=null && getProcedureHeaderSet.next()){
					
					String updateProcedureHeaderField = "UPDATE procedure_header set hospital_id=?,last_chg_date=?,status=?,hin_id=?,last_chg_by=? where visit_id = ? and opd_patient_details_id = ?"; 
					PreparedStatement updateProcedureHeader = con.prepareStatement(
							updateProcedureHeaderField,
							Statement.RETURN_GENERATED_KEYS);
					index = 1;
					updateProcedureHeader.setInt(index++, hospId);
					updateProcedureHeader.setDate(index++, date);
					updateProcedureHeader.setString(index++, prcedStatus);
					updateProcedureHeader.setInt(index++, hin_id);
					updateProcedureHeader.setInt(index++, addEditById);

					updateProcedureHeader.setInt(index++, visit_id);
					updateProcedureHeader.setInt(index++, opdPDetialsId);
					bool = updateProcedureHeader.execute();
					
					poceHdrId = 0;
					if (!bool) {
						ResultSet procedureHeaderSet = updateProcedureHeader
								.getGeneratedKeys();
						System.out.println("********procedure_header updated***********");
						while (procedureHeaderSet.next()) {
							poceHdrId = procedureHeaderSet.getInt("procedure_header_id");
						}
					}
					
					
					} else {
					// ended by amit das on 30-08-2016
					StringBuilder insertProcedureHdrField = new StringBuilder(
							"INSERT INTO procedure_header(hospital_id,last_chg_date,status,hin_id,last_chg_by,visit_id,opd_patient_details_id");
					StringBuilder insertProcedureHdrValue = new StringBuilder(
							")VALUES(?,?,?,?,?,?,?)");

					String insertProcuderHdr = insertProcedureHdrField.append(
							insertProcedureHdrValue).toString();
					PreparedStatement poceHdr = con.prepareStatement(
							insertProcuderHdr, Statement.RETURN_GENERATED_KEYS);
					index = 1;
					poceHdr.setInt(index++, hospId);
					poceHdr.setDate(index++, date);
					poceHdr.setString(index++, prcedStatus);
					poceHdr.setInt(index++, hin_id);
					poceHdr.setInt(index++, addEditById);

					poceHdr.setInt(index++, visit_id);
					poceHdr.setInt(index++, opdPDetialsId);
					poceHdrId = 0;
					bool = poceHdr.execute();
					if (!bool) {
						ResultSet poceHdrSet = poceHdr.getGeneratedKeys();
						System.out.println("********procedure_header saved***********");
						while (poceHdrSet.next()) {
							poceHdrId = poceHdrSet
									.getInt("procedure_header_id");
						}

					}
					}
					
					}
					// *****************OPDSurgeryHeader************************
					// String
					// surgeryHrStatus=obr.getObr7_ObservationDateTime().getTs2_DegreeOfPrecision().getValue();
					// String
					// patient1Status=obr.getObr7_ObservationDateTime().getTs2_DegreeOfPrecision().getValue();
					
					String bill1Status = pid.getPid24_MultipleBirthIndicator()
							.getValue(); 
					// added by amit das on 30-08-2016

					int opd_surgery_id = 0;
					
					String queryforGetOPDSurgeryHeader= "SELECT * FROM opd_surgery_header where visit_id=?";
					PreparedStatement getOPDSurgeryHeader = con.prepareStatement(
							queryforGetOPDSurgeryHeader);
					getOPDSurgeryHeader.setInt(1, visit_id);
					getOPDSurgeryHeader.execute();
					
					ResultSet getOPDSurgeryHeaderSet = getOPDSurgeryHeader
								.getResultSet();
					if(getOPDSurgeryHeaderSet!=null && getOPDSurgeryHeaderSet.next()){
					
					String updateOPDSurgeryHeaderField = "UPDATE opd_surgery_header set prescribed_department_id=?,requisition_date=?,requisition_time=?,patient_status=?,billing_status=?,hospital_id=?,hin_id=? where visit_id = ?"; 
					PreparedStatement updateOPDSurgeryHeader= con.prepareStatement(
							updateOPDSurgeryHeaderField,
							Statement.RETURN_GENERATED_KEYS);
					index = 1;
					updateOPDSurgeryHeader.setInt(index++, departId);
					updateOPDSurgeryHeader.setDate(index++, date);
					updateOPDSurgeryHeader.setString(index++, time);
					updateOPDSurgeryHeader.setString(index++, "OP");
					updateOPDSurgeryHeader.setString(index++, bill1Status);
					updateOPDSurgeryHeader.setInt(index++, hospId);
					updateOPDSurgeryHeader.setInt(index++, hin_id);
					updateOPDSurgeryHeader.setInt(index++, visit_id);
					bool = updateOPDSurgeryHeader.execute();
					
					opd_surgery_id = 0;
					if (!bool) {
						ResultSet opDSurgeryHeaderSet = updateOPDSurgeryHeader
								.getGeneratedKeys();
						System.out.println("********opd_surgery_header updated***********");
						while (opDSurgeryHeaderSet.next()) {
							opd_surgery_id = opDSurgeryHeaderSet.getInt("opd_surgery_id");
						}
					}
					
					
					} else {
					// ended by amit das on 30-08-2016
					StringBuilder insertOPDSurgeryHeaderField = new StringBuilder(
							"INSERT INTO opd_surgery_header(prescribed_department_id,requisition_date,requisition_time,patient_status,billing_status,hospital_id,hin_id,visit_id");
					StringBuilder insertOPDSurgeryHeaderValue = new StringBuilder(
							")VALUES(?,?,?,?,?,?,?,?)");

					String insertOPDSurgeryHdr = insertOPDSurgeryHeaderField
							.append(insertOPDSurgeryHeaderValue).toString();
					PreparedStatement opdSurgeryHdr = con.prepareStatement(
							insertOPDSurgeryHdr,
							Statement.RETURN_GENERATED_KEYS);
					index = 1;
					opdSurgeryHdr.setInt(index++, departId);
					opdSurgeryHdr.setDate(index++, date);
					opdSurgeryHdr.setString(index++, time);
					opdSurgeryHdr.setString(index++, "OP");
					opdSurgeryHdr.setString(index++, bill1Status);
					opdSurgeryHdr.setInt(index++, hospId);
					opdSurgeryHdr.setInt(index++, hin_id);
					opdSurgeryHdr.setInt(index++, visit_id);
					bool = opdSurgeryHdr.execute();
					opd_surgery_id = 0;
					if (!bool) {
						ResultSet opdSurgeryHdrSet = opdSurgeryHdr
								.getGeneratedKeys();
						System.out.println("********opd_surgery_header saved***********");
						while (opdSurgeryHdrSet.next()) {
							opd_surgery_id = opdSurgeryHdrSet
									.getInt("opd_surgery_id");
						}
					}
					
					}

					// ***************************patientInvestigatinDetailsListObject************************
					if(orderNo!=null){
						int investigation_detail_id = 0;
						String[] chargeCode = obr
								.getObr6_RequestedDateTimeNotused()
								.getTs2_DegreeOfPrecision().getValue().split(",");

						StringBuilder insertPatientPrescrptonDetailsField = new StringBuilder(
								"INSERT INTO patient_investigation_details(charge_code_id,investigation_header_id");
						StringBuilder insertPatientPrescrptonDetailsValue = new StringBuilder(
								")VALUES(?,?)");
						String insertPatientPrescrptonDetails = insertPatientPrescrptonDetailsField
								.append(insertPatientPrescrptonDetailsValue)
								.toString();
						for (int i = 0; i < chargeCode.length; i++) {
							
							PreparedStatement pInvestigationDetails = con
									.prepareStatement(
											insertPatientPrescrptonDetails,
											Statement.RETURN_GENERATED_KEYS);
							index = 1;
							pInvestigationDetails.setInt(index++,
									Integer.parseInt(chargeCode[i]));
							pInvestigationDetails.setInt(index++,
									investigation_header_id);

							bool = pInvestigationDetails.execute();
							
							if (!bool) {
								ResultSet pInvestigationDetailsSet = pInvestigationDetails
										.getGeneratedKeys();
								System.out.println("********patient_investigation_details saved***********");
								while (pInvestigationDetailsSet.next()) {
									investigation_detail_id = pInvestigationDetailsSet
											.getInt("investigation_detail_id");
								}
							}
							
							}
						
					
					
					// ******************************dgOrderDetailsListObject***************************
					 
					String[] orderQnty = obr.getObr16_OrderingProvider()
							.getCn1_IDNumber().getValue().split(",");
					String[] amt = pid.getPid8_Sex().getValue().split(",");
					String[] msgSent = pid
							.getPid20_DriverSLicenseNumberPatient()
							.getLicenseNumber().getValue().split(",");
					String[] packStatus = obr.getObr12_DangerCode()
							.getCe2_Text().getValue().split(",");
					String[] payMode = obr.getObr20_FillerField1().getValue()
							.split(",");
					String[] order1Status = pv1.getPv119_VisitNumber()
							.getCm_pat_id1_IDNumber().getValue().split(",");
					String[] mainChargeId = blg.getBlg3_AccountID()
							.getCk1_IDNumber().getValue().split(",");
					String[] subCharge = pv1.getPv139_ServicingFacility()
							.getValue().split(",");
					String[] chargeCodeId = pv1
							.getPv143_PriorTemporaryLocation()
							.getCm_internal_location3_Bed().getValue()
							.split(",");
					
					String[] billNo=pv1.getPv134_DeleteAccountIndicator().getValue().split(",");
                    char[] billPatientStatus=pid.getPid18_PatientAccountNumber().getCheckDigit().getValue().toCharArray();
                    char[] billStatus=pid.getPid25_BirthOrder().getValue().toCharArray();
                    String[] billDetialQauntity=null;
                    if(obr.getObr32_PrincipalResultInterpreter().getCm_ndl1_InterpreterTechnician().getCn10_Telefon().getValue()!=null){
                    	billDetialQauntity=obr.getObr32_PrincipalResultInterpreter().getCm_ndl1_InterpreterTechnician().getCn10_Telefon().getValue().split(",");
                    }
                    char[] billDetailRefundableStatus=null;
                    if(pv1.getPv11_SetIDPatientVisit().getValue()!=null){
                    	 billDetailRefundableStatus= pv1.getPv11_SetIDPatientVisit().getValue().toCharArray();
                    }
                    

                    String queryforGetPatientDgOrderDetails = "select * FROM dg_orderdt where orderhd_id=? and charge_code_id=?";
					
					for (int i = 0; i < orderQnty.length; i++) {
						
						
					
						// ******************************bl_op_bill_header object***************************
						StringBuilder insertBlOpBillHdeaderField=new StringBuilder("INSERT INTO bl_op_bill_header(hin_id,patient_name,sex_id,bill_no,bill_amt,discount_amt,outstanding,round_off,discount_on_bill,net_amt,hospital_id,bill_date,bill_time,patient_status,advance_adjustment,payable_amt,changed_by,visit_id,status,actual_collected_amt");
                        StringBuilder nsertBlOpBillHdeaderValue=new StringBuilder(")VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
                        
                        // added by amit das on 30-12-2016
                        String queryForBlParameters = "select * from bl_parameter where prefix = 'BS' and hospital_id = ?";
                        String updateBlParameterFeild = "update bl_parameter set seq_no =? where prefix = ? and hospital_id = ?";
                        String insertBlParameterFeild = "insert into bl_parameter (seq_no,criteria,prefix,last_chg_date,last_chg_time,hospital_id) values (?,?,?,?,?,?)";
                        
                       
                        
                        // added by amit das on 23-11-2016
                        if(patient_type_id!=0){
                        	insertBlOpBillHdeaderField.append(",patient_type_id");
                        	nsertBlOpBillHdeaderValue.append(",?)");
                        }else{
                        	nsertBlOpBillHdeaderValue.append(")");
                        }
						
						
                        // added by amit das on 30-12-2016
                        PreparedStatement getBlParameter = con.prepareStatement(
                        		queryForBlParameters);
                        getBlParameter.setInt(1, hospId);
                        getBlParameter.execute();
    					
                        // added by amit das on 30-12-2016
                        PreparedStatement updateBlParameter= con.prepareStatement(
                        		updateBlParameterFeild,
    							Statement.RETURN_GENERATED_KEYS);
                        
                        // added by amit das on 30-12-2016
                        PreparedStatement insertBlParameter = con
								.prepareStatement(
										insertBlParameterFeild,
										Statement.RETURN_GENERATED_KEYS);
                        
                        String insertBlOpBillHdeader=insertBlOpBillHdeaderField.append(nsertBlOpBillHdeaderValue).toString();
                        
                        PreparedStatement blOpBillHdeader = con.prepareStatement(insertBlOpBillHdeader,
                                                Statement.RETURN_GENERATED_KEYS);
                        index=1; 
                        blOpBillHdeader.setInt(index++, hin_id);
                        blOpBillHdeader.setString(index++, pname);
                        blOpBillHdeader.setInt(index++, sexId);
                        blOpBillHdeader.setString(index++, billNo[i]);
                        blOpBillHdeader.setBigDecimal(index++, new BigDecimal("0.0"));
                        blOpBillHdeader.setBigDecimal(index++, new BigDecimal("0.0"));
                        blOpBillHdeader.setBigDecimal(index++, new BigDecimal("0.0"));
                        blOpBillHdeader.setBigDecimal(index++, new BigDecimal("0.0"));
                        blOpBillHdeader.setBigDecimal(index++, new BigDecimal("0.0"));
                        blOpBillHdeader.setBigDecimal(index++, new BigDecimal("0.0"));
                        blOpBillHdeader.setInt(index++, hospId);
                        blOpBillHdeader.setDate(index++, date);
                        blOpBillHdeader.setString(index++, time);
                        if("1".equalsIgnoreCase(billPatientStatus[i]+"")){
                        	blOpBillHdeader.setString(index++, "Y");	
                        }else{
                        	 blOpBillHdeader.setString(index++, "N");	
                        }
                        
                        blOpBillHdeader.setBigDecimal(index++, new BigDecimal("0.0"));
                        blOpBillHdeader.setBigDecimal(index++, new BigDecimal("0.0"));
                        blOpBillHdeader.setInt(index++, addEditById);
                        blOpBillHdeader.setInt(index++, visit_id);
                        if("1".equalsIgnoreCase(billStatus[i]+"")){
                        	 blOpBillHdeader.setString(index++, "Y");
                        }else{
                        	blOpBillHdeader.setString(index++, "N");
                        } 
                        blOpBillHdeader.setBigDecimal(index++, new BigDecimal("0.0"));
                        
                        if(patient_type_id!=0) // added by amit das on 23-11-2016
                        	blOpBillHdeader.setInt(index++, patient_type_id);

                        bool=true;
                        int blOpBillHeaderId = 0;
                        int seqNo = 0;
                        if(!("0".equalsIgnoreCase(billNo[i]))){ 
                        	 bool = blOpBillHdeader.execute();  
                             if (!bool) {
                             	ResultSet blOpBillHeaderIdSet = blOpBillHdeader
                                     .getGeneratedKeys();
                             	System.out.println("********bl_op_bill_header saved***********");
                             	while (blOpBillHeaderIdSet.next()) {
                             blOpBillHeaderId = blOpBillHeaderIdSet
                                             .getInt("op_bill_header_id");
                             	}
                               
                             	
                             	// added by amit das on 30-12-2016
            					ResultSet getBlParameterSet = getBlParameter
            								.getResultSet();
            					if(getBlParameterSet!=null && getBlParameterSet.next()){
            						index = 1;
                					updateBlParameter.setInt(index++, Integer.parseInt(billNo[i]));
                					updateBlParameter.setString(index++, "BS");
                					updateBlParameter.setInt(index++, hospId);
                					
                					bool = updateBlParameter.execute();
            					} else {
            						
        							index = 1;
        							insertBlParameter.setInt(index++,
        									Integer.parseInt(billNo[i]));
        							insertBlParameter.setString(index++,
        									"c");
        							insertBlParameter.setString(index++,
        									"BS");
        							insertBlParameter.setDate(index++, date);
        							insertBlParameter.setString(index++,(String)utilMap.get("currentTime"));
        							insertBlParameter.setInt(index++,
        									hospId);
        							bool = insertBlParameter.execute();
            					}
            					
                             	// ended by amit das on 30-12-2016
                             	
                             }
                        	
                        } 
                     // ******************************bl_op_bill_details object***************************
                        StringBuilder insertBlOpBillDetailsField=new StringBuilder("INSERT INTO bl_op_bill_details(op_bill_header_id,charge_code_id,quqntity,rate,amount,discount_amt,proportional_discount_amount,net_amt,bill_date,bill_time,changed_by,refundable_status");
                        StringBuilder insertBlOpBillDetailsValue=new StringBuilder(")VALUES(?,?,?,?,?,?,?,?,?,?,?)");
                        String insertBlOpBillDetails=insertBlOpBillDetailsField.append(insertBlOpBillDetailsValue).toString();
                        
                          for (int k = 0; k < billNo.length; k++) {
                        	  PreparedStatement blOpBillDetails = con
                              .prepareStatement(insertBlOpBillDetails,
                                              Statement.RETURN_GENERATED_KEYS);

                        index=1;
                        blOpBillDetails.setInt(index++, blOpBillHeaderId);
                        blOpBillDetails.setInt(index++,Integer.parseInt(chargeCodeId[k]));
                        if(billDetialQauntity!=null){
                        	blOpBillDetails.setInt(index++, Integer.parseInt(billDetialQauntity[k]));
                        } 
                        blOpBillDetails.setBigDecimal(index++, new BigDecimal("0.0"));
                        blOpBillDetails.setBigDecimal(index++, new BigDecimal("0.0"));
                        blOpBillDetails.setBigDecimal(index++, new BigDecimal("0.0"));
                        blOpBillDetails.setBigDecimal(index++, new BigDecimal("0.0"));
                        blOpBillDetails.setBigDecimal(index++, new BigDecimal("0.0"));
                        blOpBillDetails.setDate(index++, date);
                        blOpBillDetails.setString(index++, time);
                        blOpBillDetails.setInt(index++, addEditById);
                        if(billDetailRefundableStatus!=null){
                        	 if("1".equalsIgnoreCase(billDetailRefundableStatus[k]+"")){
                             	blOpBillDetails.setString(index++, "Y"); 
                             }else{
                             	blOpBillDetails.setString(index++, "N");
                             } 
                        }
                       
                        bool=true;
                        
                        if(billDetialQauntity!=null && !("1".equalsIgnoreCase(billDetialQauntity[k]))){
                        	 bool = blOpBillDetails.execute();
                        } 
                        int blOpBillDetailsId = 0;
                        if (!bool) {
                        	ResultSet blOpBillDetailsIdSet = blOpBillDetails
                		.getGeneratedKeys();
                        	System.out.println("********bl_op_bill_details saved***********");
                        	while (blOpBillDetailsIdSet.next()) {
                        		blOpBillDetailsId = blOpBillDetailsIdSet
                                        .getInt("op_bill_details_id");
                        		} 
                        	}  
                          }
                        
                          
                         // added by amit das on 22-12-2016 
                        String updateDgOderDeatilsField = "UPDATE dg_orderdt set order_qty=?,order_status=?,last_chg_date=?,last_chg_time=?,msg_sent=?,pacs_status=?,last_chg_by=? where orderhd_id = ? and charge_code_id=?"; 
  
                        StringBuilder insertDgOderDeatilsField = new StringBuilder(
      							"INSERT INTO dg_orderdt(charge_code_id,order_qty,order_status,last_chg_date,last_chg_time,main_chargecode_id,sub_chargeid,payment_made,amount,msg_sent,pacs_status,orderhd_id,last_chg_by");
                        if(blOpBillHeaderId!=0){
                        	// insertDgOderDeatilsField.append(",bill_no"); // commented by amit das on 23-11-2016
                        	insertDgOderDeatilsField.append(",bill_id"); // added by amit das on 23-11-2016
                        }
      					StringBuilder insertDgOderDeatilsValue = new StringBuilder(
      							")VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?");
      					
      					if(blOpBillHeaderId!=0){
      						insertDgOderDeatilsValue.append(",?");
      					} 
      					insertDgOderDeatilsValue.append(")");
      					String insertDgOderDetails = insertDgOderDeatilsField
      							.append(insertDgOderDeatilsValue).toString();
      					
      					// added by amit das on 22-12-2016
      					PreparedStatement getPatientDgOderDeatils  = con.prepareStatement(
  								queryforGetPatientDgOrderDetails);
                        getPatientDgOderDeatils.setInt(1, orderhd_id);
                        getPatientDgOderDeatils.setInt(2, Integer.parseInt(chargeCodeId[i]));
                        // ended by amit das on 22-12-2016
      					
						PreparedStatement dgOrderDetails = con
								.prepareStatement(insertDgOderDetails,
										Statement.RETURN_GENERATED_KEYS);

						// added by amit das on 22-12-2016
						getPatientDgOderDeatils.execute();
						ResultSet getPatientDgOderDeatilSet = getPatientDgOderDeatils
									.getResultSet();
						// added by amit das on 22-12-2016
						if(getPatientDgOderDeatilSet!=null && getPatientDgOderDeatilSet.next()){
							
							
							PreparedStatement updatePatientDgOderDeatils  = con.prepareStatement(
									updateDgOderDeatilsField,
									Statement.RETURN_GENERATED_KEYS);
							index = 1;
							updatePatientDgOderDeatils.setInt(index++,
									Integer.parseInt(orderQnty[i]));
							updatePatientDgOderDeatils
							.setString(index++, order1Status[i]);
							updatePatientDgOderDeatils.setDate(index++, date);
							updatePatientDgOderDeatils.setString(index++, time);
							updatePatientDgOderDeatils.setString(index++, msgSent[i]);
							updatePatientDgOderDeatils.setString(index++, packStatus[i]);
							updatePatientDgOderDeatils.setInt(index++, addEditById);
							updatePatientDgOderDeatils.setInt(index++, orderhd_id);
							updatePatientDgOderDeatils.setInt(index++,
									Integer.parseInt(chargeCodeId[i]));
							bool = updatePatientDgOderDeatils.execute();
							if (!bool) {
								ResultSet patientDgOrderDetailsSet = updatePatientDgOderDeatils
										.getGeneratedKeys();
								System.out.println("********dg_orderdt updated***********");
							}
							
							} 	// ended by amit das on 22-12-2016
						else {
						index = 1;
								
						dgOrderDetails.setInt(index++,
								Integer.parseInt(chargeCodeId[i]));
						dgOrderDetails.setInt(index++,
								Integer.parseInt(orderQnty[i]));
						dgOrderDetails.setString(index++, order1Status[i]);
						dgOrderDetails.setDate(index++, date);
						dgOrderDetails.setString(index++, time);
						dgOrderDetails.setInt(index++,
								Integer.parseInt(mainChargeId[i]));
						dgOrderDetails.setInt(index++,
								Integer.parseInt(subCharge[i]));
						dgOrderDetails.setString(index++, payMode[i]);
						dgOrderDetails
								.setInt(index++, Integer.parseInt(amt[i]));
						dgOrderDetails.setString(index++, msgSent[i]);
						dgOrderDetails.setString(index++, packStatus[i]);
						dgOrderDetails.setInt(index++, orderhd_id);
						dgOrderDetails.setInt(index++, addEditById);
						if(blOpBillHeaderId!=0){
							dgOrderDetails.setInt(index++, blOpBillHeaderId);
						}  
						bool=true;
						if(orderhd_id!=0){
							bool = dgOrderDetails.execute();
						} 
						int DgOrderDetailsId = 0;
						if (!bool) {
							ResultSet DgOrderDetailsSet = dgOrderDetails
									.getGeneratedKeys();
							System.out.println("********dg_orderdt saved***********");
							while (DgOrderDetailsSet.next()) {
								DgOrderDetailsId = DgOrderDetailsSet
										.getInt("orderdt_id");
							}

						}

					}
					
				 }
					
					

					// **************************DgSampleCollectionDetails*********************
					if(blg.getBlg1_WhenToCharge()
							.getCm_ccd1_WhenToCharge().getValue()!=null){ 
					String[] colleted = blg.getBlg1_WhenToCharge()
							.getCm_ccd1_WhenToCharge().getValue().split(",");
					String[] order2Status = pv1.getPv140_BedStatus().getValue()
							.split(",");
					String[] chargeCodeIdDg = pv1.getPv142_PendingLocation()
							.getCm_internal_location3_Bed().getValue()
							.split(",");
					String[] mainChargeIdDg = pv1.getPv18_ReferringDoctor()
							.getCn4_MiddleInitialOrName().getValue().split(",");
					String[] subChargeIdDg = pv1.getPv17_AttendingDoctor()
							.getCn1_IDNumber().getValue().split(",");
					String[] investigationId = pid.getPid23_BirthPlace()
							.getValue().split(",");

					StringBuilder insertDgSampleDetialsField = new StringBuilder(
							"INSERT INTO dg_sample_collection_details(charge_code_id,collected,order_status,last_chg_time,last_chg_date,maincharge,subcharge,sample_collection_header_id,last_chg_by,investigation_id,sample_coll_datetime");
					StringBuilder insertDgSampleDetialsValue = new StringBuilder(
							")VALUES(?,?,?,?,?,?,?,?,?,?,?)");
					String insertDgSampleDetails = insertDgSampleDetialsField
							.append(insertDgSampleDetialsValue).toString();
					for (int i = 0; i < colleted.length; i++) {
						PreparedStatement dgSamDetails = con.prepareStatement(
								insertDgSampleDetails,
								Statement.RETURN_GENERATED_KEYS);
						index = 1;
						dgSamDetails.setInt(index++,
								Integer.parseInt(chargeCodeIdDg[i]));
						dgSamDetails.setString(index++, colleted[i]);
						dgSamDetails.setString(index++, order2Status[i]);
						dgSamDetails.setString(index++, time);
						dgSamDetails.setDate(index++, date);
						dgSamDetails.setInt(index++,
								Integer.parseInt(mainChargeIdDg[i]));
						dgSamDetails.setInt(index++,
								Integer.parseInt(subChargeIdDg[i]));
						dgSamDetails.setInt(index++,
								sample_collection_header_id);
						dgSamDetails.setInt(index++, addEditById);
						dgSamDetails.setInt(index++,
								Integer.parseInt(investigationId[i]));
						dgSamDetails.setDate(index++, date);
						bool=true;
						if(sample_collection_header_id!=0){
							bool = dgSamDetails.execute();
						} 
						int dgSamDetailsId = 0;
						if (!bool) {
							ResultSet dgSamDetailsSet = dgSamDetails
									.getGeneratedKeys();
							System.out.println("********dg_sample_collection_details saved***********");
							while (dgSamDetailsSet.next()) {
								dgSamDetailsId = dgSamDetailsSet
										.getInt("sample_collection_details_id");
							}
						}
						if (dgSamDetailsId != 0 && dgSamDetailsId > 0) {
							bool = true;
							}
							}
						}
					
					}

					 bool=true;
					 con.commit();
					} else { // added by amit das on 23-12-2016
						 bool=false;
					}
				}	
					try {
						response = theMessage.generateACK();
					} catch (IOException e) {
						throw new ReceivingApplicationException(e);
					}

					/*
					 * If something goes horribly wrong, you can throw an
					 * exception and an HTTP 500 error will be generated.
					 * However, it is preferable to return a normal HL7 ACK
					 * message with an "AE" response code to note an error.
					 */
					boolean somethingFailed = bool;
					/*if (!somethingFailed) {
						throw new ReceivingApplicationException("");
					}*/

					/*
					 * It is better to return an HL7 message with an AE response
					 * code. This will still be returned by the transport with
					 * an HTTP 500 status code, but an HL7 message will still be
					 * propagated up.
					 */
					if (!somethingFailed) {
						try {
							response = theMessage.generateACK("AE",
									new HL7Exception("There was a problem!!"));
						} catch (IOException e) {
							throw new ReceivingApplicationException(e);
						}
					}
					//return response;
				
				con.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if(con!=null){
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}finally{
				if(con!=null){
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			return response;
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean canProcess(Message theMessage) {
			return true;
		}

	}

	public static Date convertStringTypeDateToSQLDate(String date) {
		Date orderDate = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		if (date != null) {
			java.util.Date da;
			try {
				da = df.parse(date);
				orderDate = new Date(da.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return orderDate;
	}

}