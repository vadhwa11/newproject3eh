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
import ca.uhn.hl7v2.model.v22.segment.OBX;
import ca.uhn.hl7v2.model.v22.segment.PID;
import ca.uhn.hl7v2.model.v22.segment.PV1;
import ca.uhn.hl7v2.model.v22.segment.PV2;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;

/**
 * Example servlet implementation which receives HL7 messages and uses HAPI to
 * process them.
 */
public class HL7ForLeanServer extends HohServlet {

	/**
	 * Initialise the servlet
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
			String currentDate = (String) utilMap.get("currentDate");
			String currentTime = (String) utilMap.get("currentTime");
			java.util.Date changeDate = HMSUtil
					.convertStringTypeDateToDateType(currentDate);
			ADT_A01 adtMsg = (ADT_A01) theMessage;
			boolean somethingFailed = false;
			
			int currentVisitNo = 0; //added by amit das on 06-10-2016
			String hinNo = null; // added by amit das on 06-10-2016
			int visitNo = 0; // added by amit das on 07-10-2016
			Visit visit = new Visit();
			Patient patient = new Patient();
			BlOpBillHeader opBillHeader = new BlOpBillHeader();
			QueueManagment queue = new QueueManagment();
			BlOpBillDetails opBillDetails = new BlOpBillDetails();
			PID pid = adtMsg.getPID();
			PV1 pv1 = adtMsg.getPV1();
			PV2 pv2 = adtMsg.getPV2();
			OBX obx = adtMsg.getOBX();   // added by amit das  on 25-09-2017
					
			System.out.println("Received message:\n" + theMessage.encode());
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("jdbc.properties");
			Properties pacProper = new Properties();
			InputStream input;
			try {
				input = new FileInputStream(new File(resourcePath.getFile()));
				pacProper.load(input);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			String url = pacProper.getProperty("database.url");
			String driverName = pacProper.getProperty("database.driver");
			String userName = pacProper.getProperty("database.user");
			String password = pacProper.getProperty("database.password");
			Statement statement = null;
			Connection con=null;
			try {
				Class.forName(driverName);
				/*Connection con = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/LiveDB30012016",
						"postgres", "postgres");*/
			    con = DriverManager.getConnection(url,userName,password);
				// Class.forName(driverName);
				// Connection connection = DriverManager.getConnection(url,
				// userName, password);
			     con.setAutoCommit(false);
			    //con.setAutoCommit(true);
				statement = con.createStatement();
				int hin_id = 0;
				int hospIdForPharmacyLabQueue = 0;
				Date visitDate = null;
				String visitTime = null;
				hinNo =	pid.getPid4_AlternatePatientID().getValue(); //added by amit das on 06-10-2016
			
				String patientQuery = "select * from patient where hin_no= '"
						+ pid.getPid4_AlternatePatientID().getValue() + "'";

				try {
					ResultSet resultSet = statement.executeQuery(patientQuery);
					while (resultSet.next()) {
						hin_id = resultSet.getInt("hin_id");
						currentVisitNo = resultSet.getInt("current_visit_no"); //added by amit das on 06-10-2016
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				if (hin_id == 0) {
					StringBuilder insertPatientFilds = new StringBuilder(
							"INSERT INTO patient(patient_status,add_edit_date,add_edit_time,");
					StringBuilder insertPatientValues = new StringBuilder(
							")VALUES(?,?,?,");
					if (pid.getPid2_PatientIDExternalID().getCk1_IDNumber()
							.getValue() != null) {
						insertPatientFilds.append("aadhaar_no,");
						insertPatientValues.append("?,");
					}
					if (pid.getPid4_AlternatePatientID().getValue() != null) {
						insertPatientFilds.append("hin_no,");
						insertPatientValues.append("?,");
					}
					if (pid.getPid5_PatientName().getFamilyName().getValue() != null) {
						insertPatientFilds.append("full_name,");
						insertPatientValues.append("?,");
					}

					if (pid.getPid5_PatientName().getGivenName().getValue() != null) {
						insertPatientFilds.append("p_first_name,");
						insertPatientValues.append("?,");
					}
					if (pid.getPid6_MotherSMaidenName().getValue() != null) {
						insertPatientFilds.append("father_mother_name,");
						insertPatientValues.append("?,");
					}
					if (pid.getPid7_DateOfBirth().getTs1_TimeOfAnEvent()
							.getValue() != null) {
						insertPatientFilds.append("date_of_birth,");
						insertPatientValues.append("?,");
					}
					if(pid.getPid7_DateOfBirth().getTs2_DegreeOfPrecision().getValue()!=null){
						insertPatientFilds.append("age,");
						insertPatientValues.append("?,"); 
					}
					if (pid.getPid8_Sex().getValue() != null) {
						insertPatientFilds.append("sex_id,");
						insertPatientValues.append("?,");
					}

					if (pid.getPid9_PatientAlias(0).getFamilyName().getValue() != null) {
						insertPatientFilds.append("patient_type_id,");
						insertPatientValues.append("?,");
					}
					if (pid.getPid10_Race().getValue() != null) {
						insertPatientFilds.append("bpl_status,");
						insertPatientValues.append("?,");
					}
					if (pid.getPid12_CountyCode().getValue() != null) {
						insertPatientFilds.append("nativity_type,");
						insertPatientValues.append("?,");
					}
					if (pid.getPid13_PhoneNumberHome(0).getValue() != null) {
						insertPatientFilds.append("mobile_number,");
						insertPatientValues.append("?,");
					}
					if (pid.getPid14_PhoneNumberBusiness(0).getValue() != null) {
						insertPatientFilds.append("blood_group_id,");
						insertPatientValues.append("?,");
					}
					if (pid.getPid15_LanguagePatient().getValue() != null) {
						insertPatientFilds.append("id_no,");
						insertPatientValues.append("?,");
					}
					if (pid.getPid16_MaritalStatus().getValue() != null) {
						insertPatientFilds.append("marital_status_id,");
						insertPatientValues.append("?,");
					}
					if (pid.getPid17_Religion().getValue() != null) {
						insertPatientFilds.append("religion_id,");
						insertPatientValues.append("?,");
					}
					if (pid.getPid18_PatientAccountNumber().getCk1_IDNumber()
							.getValue() != null) {
						insertPatientFilds.append("otp_number,");
						insertPatientValues.append("?,");
					}
					if (pid.getPid19_SocialSecurityNumberPatient().getValue() != null) {
						insertPatientFilds.append("current_visit_no,");
						insertPatientValues.append("?,");
					}
					if (pid.getPid20_DriverSLicenseNumberPatient()
							.getCm_license_no1_LicenseNumber().getValue() != null) {
						insertPatientFilds.append("id_card,");
						insertPatientValues.append("?,");
					}
					if (pid.getPid21_MotherSIdentifier().getCk1_IDNumber()
							.getValue() != null) {
						insertPatientFilds.append("relation_id,");
						insertPatientValues.append("?,");
					}
					if (pid.getPid22_EthnicGroup().getValue() != null) {
						insertPatientFilds.append("reg_time,");
						insertPatientValues.append("?,");
					}
					if (pid.getPid23_BirthPlace().getValue() != null) {
						insertPatientFilds.append("notional_dob_status,");
						insertPatientValues.append("?,");
					}
					if (pid.getPid24_MultipleBirthIndicator().getValue() != null) {
						insertPatientFilds.append("reg_date,");
						insertPatientValues.append("?,");
					}
					if (pid.getPid25_BirthOrder().getValue() != null) {
						insertPatientFilds.append("year_of_birth,");
						insertPatientValues.append("?,");
					}
					if (pid.getPid26_Citizenship(0).getValue() != null) {
						insertPatientFilds.append("hospital_id,");
						insertPatientValues.append("?,");
					}
					if (pv1.getPv17_AttendingDoctor().getCn1_IDNumber()
							.getValue() != null) {
						insertPatientFilds.append("add_edit_by_id");
						insertPatientValues.append("?)");
					}
					String insertPatient = insertPatientFilds.append(
							insertPatientValues).toString();
					try {
						DateFormat formatter = null;
						PreparedStatement ps = con.prepareStatement(
								insertPatient, Statement.RETURN_GENERATED_KEYS);
						int index = 1;
						ps.setString(index++, "Out Patient");
						ps.setDate(index++, new Date(changeDate.getTime()));
						ps.setString(index++, currentTime);
						// aadharNo
						if (pid.getPid2_PatientIDExternalID().getCk1_IDNumber()
								.getValue() != null) {
							ps.setLong(
									index++,
									Long.parseLong(pid
											.getPid2_PatientIDExternalID()
											.getCk1_IDNumber().getValue()));
						}

						// hinNO
						if (pid.getPid4_AlternatePatientID().getValue() != null) {
							ps.setString(index++, pid
									.getPid4_AlternatePatientID().getValue());
						}

						// fullName
						if (pid.getPid5_PatientName().getFamilyName()
								.getValue() != null) {
							ps.setString(index++, pid.getPid5_PatientName()
									.getFamilyName().getValue());
						}

						// pfirstName
						if (pid.getPid5_PatientName().getGivenName().getValue() != null) {
							ps.setString(index++, pid.getPid5_PatientName()
									.getGivenName().getValue());
						}

						// FatherMotherName
						if (pid.getPid6_MotherSMaidenName().getValue() != null) {
							ps.setString(index++, pid
									.getPid6_MotherSMaidenName().getValue());
						}

						// pDateOfBirth
						if (pid.getPid7_DateOfBirth().getTs1_TimeOfAnEvent()
								.getValue() != null) {
							ps.setDate(index++,
									convertStringTypeDateToSQLDate(pid
											.getPid7_DateOfBirth()
											.getTs1_TimeOfAnEvent().getValue()));

						}
						//age
						if(pid.getPid7_DateOfBirth().getTs2_DegreeOfPrecision().getValue()!=null){
							ps.setString(index++, pid.getPid7_DateOfBirth().getTs2_DegreeOfPrecision().getValue()); 
						} 
						// pSex
						if (pid.getPid8_Sex().getValue() != null) {
							ps.setInt(index++, Integer.parseInt(pid
									.getPid8_Sex().getValue()));
						}

						// patientType
						if (pid.getPid9_PatientAlias(0).getFamilyName()
								.getValue() != null) {
							ps.setInt(
									index++,
									Integer.parseInt(pid
											.getPid9_PatientAlias(0)
											.getFamilyName().getValue()));
						}

						// BplStatus
						if (pid.getPid10_Race().getValue() != null) {
							ps.setString(index++, pid.getPid10_Race()
									.getValue());
						}

						// nativityType
						if (pid.getPid12_CountyCode().getValue() != null) {
							ps.setString(index++, pid.getPid12_CountyCode()
									.getValue());
						}

						// Mobile NO
						if (pid.getPid13_PhoneNumberHome(0).getValue() != null) {
							// ps.setString(index++, pid.getPid13_PhoneNumberHome(0).getValue()); // commented by amit das on 01-08-2016
							ps.setString(index++, HMSUtil.convertHL7ToPhoneNumber(pid.getPid13_PhoneNumberHome(0).getValue())); // added by amit das on 01-08-2016
							
						}

						// bloodGroup
						if (pid.getPid14_PhoneNumberBusiness(0).getValue() != null) {
							ps.setInt(index++, Integer
									.parseInt(pid.getPid14_PhoneNumberBusiness(
											0).getValue()));
						}

						// patientIdNo
						if (pid.getPid15_LanguagePatient().getValue() != null) {
							ps.setString(index++, pid
									.getPid15_LanguagePatient().getValue());
						}

						// maritalStatus
						if (pid.getPid16_MaritalStatus().getValue() != null) {
							ps.setInt(index++, Integer.parseInt(pid
									.getPid16_MaritalStatus().getValue()));
						}

						// religion
						if (pid.getPid17_Religion().getValue() != null) {
							ps.setInt(index++, Integer.parseInt(pid
									.getPid17_Religion().getValue()));
						}

						// otpNumber
						if (pid.getPid18_PatientAccountNumber()
								.getCk1_IDNumber().getValue() != null) {
							ps.setInt(
									index++,
									Integer.parseInt(pid
											.getPid18_PatientAccountNumber()
											.getCk1_IDNumber().getValue()));
						}

						// surrentvisitno
						if (pid.getPid19_SocialSecurityNumberPatient()
								.getValue() != null) {
							ps.setInt(index++, Integer.parseInt(pid
									.getPid19_SocialSecurityNumberPatient()
									.getValue()));
						}
						// idCard
						if (pid.getPid20_DriverSLicenseNumberPatient()
								.getCm_license_no1_LicenseNumber().getValue() != null) {
							ps.setInt(index++, Integer.parseInt(pid
									.getPid20_DriverSLicenseNumberPatient()
									.getCm_license_no1_LicenseNumber()
									.getValue()));
						}

						// relation
						if (pid.getPid21_MotherSIdentifier().getCk1_IDNumber()
								.getValue() != null) {
							ps.setInt(
									index++,
									Integer.parseInt(pid
											.getPid21_MotherSIdentifier()
											.getCk1_IDNumber().getValue()));
						}
						// regTime
						if (pid.getPid22_EthnicGroup().getValue() != null) {
							ps.setString(index++, pid.getPid22_EthnicGroup()
									.getValue());
						}
						// nationaldobstatus
						if (pid.getPid23_BirthPlace().getValue() != null) {
							ps.setString(index++, pid.getPid23_BirthPlace()
									.getValue());
						}
						// regdate
						if (pid.getPid24_MultipleBirthIndicator().getValue() != null) {
							/*ps.setDate(index++, new Date(
									HMSUtil
									.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(pid
											.getPid24_MultipleBirthIndicator()
											.getValue()).getTime()));*/
							// commented by amit das on 21-12-2016
							// added by amit das on 21-12-2016
							formatter = new SimpleDateFormat("yyyy-MM-dd");
							ps.setDate(index++, new Date(
									formatter.parse(pid
											.getPid24_MultipleBirthIndicator()
											.getValue()).getTime()));
						}
						// yearofbirth
						if (pid.getPid25_BirthOrder().getValue() != null) {
							ps.setString(index++, pid.getPid25_BirthOrder()
									.getValue());
						}

						// hospitalId
						if (pid.getPid26_Citizenship(0).getValue() != null) {
							ps.setInt(index++, Integer.parseInt(pid
									.getPid26_Citizenship(0).getValue()));
						}
						// addeditbyid
						if (pv1.getPv17_AttendingDoctor().getCn1_IDNumber()
								.getValue() != null) {
							ps.setInt(
									index++,
									Integer.parseInt(pv1
											.getPv17_AttendingDoctor()
											.getCn1_IDNumber().getValue()));
						}
						Boolean bool = ps.execute();
						if (!bool) {
							ResultSet res = ps.getGeneratedKeys();
							while (res.next()) {
								hin_id = res.getInt("hin_id");
							} 
						}

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				StringBuilder insertVisitField=new StringBuilder("INSERT INTO visit(");
				StringBuilder insertVisitValue=new StringBuilder(")VALUES(");
				
				StringBuilder insertQueueField=new StringBuilder("INSERT INTO queue_managment(visit_id,");
				StringBuilder insertQueueValue=new StringBuilder(")VALUES(?,");
				
				StringBuilder insertBlOpBillHeaderField=new StringBuilder("INSERT INTO bl_op_bill_header(");
				StringBuilder insertBlOpBillHeaderValue=new StringBuilder(")VALUES(");
				
				StringBuilder insertBlOpBillDetailsField=new StringBuilder("INSERT INTO bl_op_bill_details(op_bill_header_id,");
				StringBuilder insertBlOpBillDetailsValue=new StringBuilder(")VALUES(?,");
				
				// added by amit das on 06-10-2016
				String updatePatientField= "UPDATE patient set current_visit_no = ? where hin_no = ?";
				
				 
				if(pv1.getPv15_PreadmitNumber().getValue()!=null){
					insertVisitField.append("priority_number,");
					insertVisitValue.append("?,");
					insertQueueField.append("priority_number,");
					insertQueueValue.append("?,");
				}
				if (pv1.getPv16_PriorPatientLocation()
						.getCm_internal_location1_NurseUnitStation().getValue() != null) {
					insertVisitField.append("unit_id,");
					insertVisitValue.append("?,"); 
				}
				if (pv1.getPv17_AttendingDoctor().getCn1_IDNumber().getValue() != null) {
					insertVisitField.append("add_edit_by_id,");
					insertVisitValue.append("?,");  
					insertBlOpBillHeaderField.append("changed_by,");
					insertBlOpBillHeaderValue.append("?,");
					insertBlOpBillDetailsField.append("changed_by,");
					insertBlOpBillDetailsValue.append("?,");
				} 
				if (pv1.getPv18_ReferringDoctor().getIDNumber().getValue() != null) {
					insertVisitField.append("doctor_id,");
					insertVisitValue.append("?,");
					insertQueueField.append("docotor_id,");
					insertQueueValue.append("?,");
				}
				if (pv1.getPv110_HospitalService().getValue() != null) { 
					insertVisitField.append("hospital_id,");
					insertVisitValue.append("?,"); 
					insertQueueField.append("hospital_id,");
					insertQueueValue.append("?,");
					insertBlOpBillHeaderField.append("hospital_id,");
					insertBlOpBillHeaderValue.append("?,");
					hospIdForPharmacyLabQueue = Integer.parseInt(pv1.getPv110_HospitalService().getValue());
				}
				if(pv1.getPv111_TemporaryLocation().getCm_internal_location1_NurseUnitStation().getValue()!=null){ 
					insertVisitField.append("total_hospital_visit,");
					insertVisitValue.append("?,");  
					insertQueueField.append("total_hospital_visit,");
					insertQueueValue.append("?,");
				}
				
				if (pv1.getPv112_PreadmitTestIndicator().getValue() != null) {
					insertVisitField.append("diagnosis_id,");
					insertVisitValue.append("?,"); 
				}
				if (pv1.getPv113_ReadmissionIndicator().getValue() != null) {
					insertVisitField.append("complaint_id,");
					insertVisitValue.append("?,");  
				}
				if(pv1.getPv114_AdmitSource().getValue()!=null){
					insertVisitField.append("ed_status,");
					insertVisitValue.append("?,"); 
				}
				if(pv1.getPv115_AmbulatoryStatus(0).getValue()!=null){
					insertVisitField.append("visit_status,");
					insertVisitValue.append("?,");   
				}
				if(pv1.getPv116_VIPIndicator().getValue()!=null){
					insertVisitField.append("token_no,");
					insertVisitValue.append("?,"); 
					insertQueueField.append("token_no,");
					insertQueueValue.append("?,");
				}
				if(hin_id>0){
					insertVisitField.append("hin_id,");
					insertVisitValue.append("?,"); 
					insertQueueField.append("hin_id,");
					insertQueueValue.append("?,");
					insertBlOpBillHeaderField.append("hin_id,");
					insertBlOpBillHeaderValue.append("?,"); 
				}
				if(pv1.getPv119_VisitNumber().getCm_pat_id1_IDNumber().getValue()!=null){
					insertVisitField.append("visit_no,");
					insertVisitValue.append("?,");  
				}
				if(pv1.getPv122_CourtesyCode().getValue()!=null){
					insertVisitField.append("cur_phar_visit_status,");
					insertVisitValue.append("?,");  
				}
				if(pv1.getPv123_CreditRating().getValue()!=null){
					insertVisitField.append("status,");
					insertVisitValue.append("?,");  
				}
				if(pv1.getPv124_ContractCode(0).getValue()!=null){
					insertVisitField.append("appointment_type,");
					insertVisitValue.append("?,");  
				}
				if (pv1.getPv125_ContractEffectiveDate(0).getValue() != null) {
					insertVisitField.append("add_edit_date,");
					insertVisitValue.append("?,"); 

				}
				if (pv1.getPv142_PendingLocation().getCm_internal_location3_Bed().getValue() != null) {
					insertVisitField.append("add_edit_time,");
					insertVisitValue.append("?,");  
				}
				if (pv1.getPv139_ServicingFacility().getValue() != null) {
					insertVisitField.append("case_type_id,");
					insertVisitValue.append("?,");   
				}
				if (pv1.getPv140_BedStatus().getValue() != null) {
					insertVisitField.append("department_id,");
					insertVisitValue.append("?,"); 
					insertQueueField.append("department_id,");
					insertQueueValue.append("?,");
				} 
				if (pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().getValue() != null) {
					insertVisitField.append("visit_date,");
					insertVisitValue.append("?,");
					insertQueueField.append("ls_cng_date,");
					insertQueueValue.append("?,");
					insertBlOpBillHeaderField.append("bill_date,");
					insertBlOpBillHeaderValue.append("?,"); 
					insertBlOpBillDetailsField.append("bill_date,");
					insertBlOpBillDetailsValue.append("?,"); 
				} 
				if(pid.getPid7_DateOfBirth().getTs2_DegreeOfPrecision().getValue()!=null){
					insertVisitField.append("age,");
					insertVisitValue.append("?,"); 
				}
				
				// added by amit on 16-03-2017
				if(pv1.getPv117_AdmittingDoctor().getCn8_SourceTableId().getValue()!=null){
					insertVisitField.append("visit_session,");
					insertVisitValue.append("?,"); 
				} 
				
				// added by amit on 25-07-2017
				if(pv1.getPv117_AdmittingDoctor().getCn3_GivenName().getValue()!=null){
					insertVisitField.append("display_after_no,");
					insertVisitValue.append("?,"); 
				} 
				
				// added by amit on 29-08-2017
				if(pv1.getPv117_AdmittingDoctor().getCn2_FamilyName().getValue()!=null){
					insertVisitField.append("creation_source,");
					insertVisitValue.append("?,"); 
				} 
				
				if (pv1.getPv144_AdmitDateTime().getTs2_DegreeOfPrecision()
						.getValue() != null) {
					insertVisitField.append("visit_time");
					insertVisitValue.append("?)"); 
					insertQueueField.append("ls_cng_time");
					insertQueueValue.append("?)");
					insertBlOpBillHeaderField.append("bill_time,");
					insertBlOpBillHeaderValue.append("?,"); 
					insertBlOpBillDetailsField.append("bill_time,");
					insertBlOpBillDetailsValue.append("?,"); 
					visitTime = pv1.getPv144_AdmitDateTime().getTs2_DegreeOfPrecision()
							.getValue();
				}  
				if(pv1.getPv147_TotalCharges().getValue()!=null){
					insertBlOpBillHeaderField.append("bill_amt,");
					insertBlOpBillHeaderValue.append("?,"); 
				} 
				if (pv1.getPv148_TotalAdjustments().getValue() != null) {
					insertBlOpBillHeaderField.append("advance_adjustment,");
					insertBlOpBillHeaderValue.append("?,"); 

				}
				if (pv1.getPv149_TotalPayments().getValue() != null) {
					insertBlOpBillHeaderField.append("actual_collected_amt,");
					insertBlOpBillHeaderValue.append("?,");  
				}
				if (pid.getPid4_AlternatePatientID().getValue() != null) {
					insertBlOpBillHeaderField.append("hin_no,");
					insertBlOpBillHeaderValue.append("?,");  
				} 
				if(pv2.getPv25_PatientValuables(0).getValue()!=null){
					insertBlOpBillDetailsField.append("rate,");
					insertBlOpBillDetailsValue.append("?,");  
				}
				if(pv2.getPv26_PatientValuablesLocation().getValue()!=null){
					insertBlOpBillDetailsField.append("amount,");
					insertBlOpBillDetailsValue.append("?,");   
				}
				if(pv1.getPv146_CurrentPatientBalance().getValue()!=null){
					insertBlOpBillHeaderField.append("discount_amt,");
					insertBlOpBillHeaderValue.append("?,");  
				}
				if(pv1.getPv150_AlternateVisitID().getIDNumber().getValue()!=null){
					insertBlOpBillHeaderField.append("bill_no,");
					insertBlOpBillHeaderValue.append("?,");  
				}
				if(pv2.getPv21_PriorPendingLocation().getBedStatus().getValue()!=null){
					insertBlOpBillDetailsField.append("charge_code_id,");
					insertBlOpBillDetailsValue.append("?,");  
				}
				if(pv2.getPv23_AdmitReason().getCe2_Text().getValue()!=null){
					insertBlOpBillDetailsField.append("discount_percent,");
					insertBlOpBillDetailsValue.append("?,");  
				}
				if(pv2.getPv24_TransferReason().getCe2_Text().getValue()!=null){
					insertBlOpBillDetailsField.append("discount_amt,");
					insertBlOpBillDetailsValue.append("?,");  
				}
				
				if(pv2.getPv22_AccommodationCode().getCe1_Identifier().getValue()!=null){
					insertBlOpBillHeaderField.append("status");
					insertBlOpBillHeaderValue.append("?)");
					insertBlOpBillDetailsField.append("refundable_status");
					insertBlOpBillDetailsValue.append("?)"); 
				}  
				

				String insertVisit = insertVisitField.append(insertVisitValue).toString(); 
				String insertQueue = insertQueueField.append(insertQueueValue).toString();
				String insertBlOpBillHeader = insertBlOpBillHeaderField.append(insertBlOpBillHeaderValue).toString();
				String insertBlOpBillDetails = insertBlOpBillDetailsField.append(insertBlOpBillDetailsValue).toString();
				
				
				PreparedStatement vs = con.prepareStatement(insertVisit,
						Statement.RETURN_GENERATED_KEYS);
				
				int index=1;
				if(pv1.getPv15_PreadmitNumber().getValue()!=null){
					vs.setInt(index++,Integer.parseInt(pv1.getPv15_PreadmitNumber().getValue()));  
				}
				if (pv1.getPv16_PriorPatientLocation()
						.getCm_internal_location1_NurseUnitStation().getValue() != null) {
					vs.setInt(index++, Integer.parseInt(pv1.getPv16_PriorPatientLocation()
							.getCm_internal_location1_NurseUnitStation().getValue())); 
				}
				if (pv1.getPv17_AttendingDoctor().getCn1_IDNumber().getValue() != null) { 
					vs.setInt(index++, Integer.parseInt(pv1.getPv17_AttendingDoctor().getCn1_IDNumber().getValue())); 
				} 
				if (pv1.getPv18_ReferringDoctor().getIDNumber().getValue() != null) {
					vs.setInt(index++, Integer.parseInt(pv1.getPv18_ReferringDoctor().getIDNumber().getValue())); 
				}
				if (pv1.getPv110_HospitalService().getValue() != null) {
					vs.setInt(index++, Integer.parseInt(pv1.getPv110_HospitalService().getValue() )); 
				}
				if(pv1.getPv111_TemporaryLocation().getCm_internal_location1_NurseUnitStation().getValue()!=null){ 
					vs.setInt(index++, Integer.parseInt(pv1.getPv111_TemporaryLocation().getCm_internal_location1_NurseUnitStation().getValue()));
					 
				}
				
				if (pv1.getPv112_PreadmitTestIndicator().getValue() != null) {
					vs.setInt(index++, Integer.parseInt(pv1.getPv112_PreadmitTestIndicator().getValue()));  
				}
				if (pv1.getPv113_ReadmissionIndicator().getValue() != null) {
					vs.setInt(index++,Integer.parseInt(pv1.getPv113_ReadmissionIndicator().getValue())); 
				}
				if(pv1.getPv114_AdmitSource().getValue()!=null){
					vs.setString(index++, pv1.getPv114_AdmitSource().getValue()); 
				}
				if(pv1.getPv115_AmbulatoryStatus(0).getValue()!=null){
					vs.setString(index++, pv1.getPv115_AmbulatoryStatus(0).getValue());  
				}
				if(pv1.getPv116_VIPIndicator().getValue()!=null){
					vs.setInt(index++,Integer.parseInt(pv1.getPv116_VIPIndicator().getValue()));  
				}
				if(hin_id>0){
					vs.setInt(index++,hin_id);  
					 
				}
				if(pv1.getPv119_VisitNumber().getCm_pat_id1_IDNumber().getValue()!=null){
					visitNo = Integer.parseInt(pv1.getPv119_VisitNumber().getCm_pat_id1_IDNumber().getValue()); // added by amit das on 08-12-2016
					vs.setInt(index++,visitNo);  
				}
				if(pv1.getPv122_CourtesyCode().getValue()!=null){
					vs.setString(index++, pv1.getPv122_CourtesyCode().getValue()); 
				}
				if(pv1.getPv123_CreditRating().getValue()!=null){
					vs.setString(index++, pv1.getPv123_CreditRating().getValue()); 
				}
				if(pv1.getPv124_ContractCode(0).getValue()!=null){
					vs.setString(index++,pv1.getPv124_ContractCode(0).getValue());   
				}
				if (pv1.getPv125_ContractEffectiveDate(0).getValue() != null) {
					vs.setDate(index++, convertStringTypeDateToSQLDate(pv1.getPv125_ContractEffectiveDate(0).getValue())); 
				}
				if (pv1.getPv142_PendingLocation().getCm_internal_location3_Bed().getValue() != null) {
					vs.setString(index++, pv1.getPv127_ContractPeriod(0).getValue()); 
				}
				if (pv1.getPv139_ServicingFacility().getValue() != null) {
					vs.setInt(index++, Integer.parseInt(pv1.getPv139_ServicingFacility().getValue())); 
				}
				if (pv1.getPv140_BedStatus().getValue() != null) {
					vs.setInt(index++, Integer.parseInt(pv1.getPv140_BedStatus().getValue()));  
				} 
				if (pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().getValue() != null) {
					vs.setDate(index++, convertStringTypeDateToSQLDate(pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().getValue())); 
				} 
				if(pid.getPid7_DateOfBirth().getTs2_DegreeOfPrecision().getValue()!=null){
					vs.setString(index++, pid.getPid7_DateOfBirth().getTs2_DegreeOfPrecision().getValue());   
				}
				
				// added by amit das on 16-03-2017
				if(pv1.getPv117_AdmittingDoctor().getCn8_SourceTableId().getValue()!=null){
					vs.setInt(index++, Integer.parseInt(pv1.getPv117_AdmittingDoctor().getCn8_SourceTableId().getValue()));   
				}
				
				// added by amit das on 25-07-2017
				if(pv1.getPv117_AdmittingDoctor().getCn3_GivenName().getValue()!=null){
					vs.setInt(index++, Integer.parseInt(pv1.getPv117_AdmittingDoctor().getCn3_GivenName().getValue()));   
				}
				
				// added by amit on 29-08-2017
				if(pv1.getPv117_AdmittingDoctor().getCn2_FamilyName().getValue()!=null){
					vs.setString(index++, pv1.getPv117_AdmittingDoctor().getCn2_FamilyName().getValue());
				}
				
				if (pv1.getPv144_AdmitDateTime().getTs2_DegreeOfPrecision()
						.getValue() != null) {
					vs.setString(index++, pv1.getPv144_AdmitDateTime().getTs2_DegreeOfPrecision().getValue());  
				} 
				
				
				// added by amit das on 05-12-2016
				
				if(hin_id>0) {
				boolean bool= false;
				String visitQuery = "select * from visit where hin_id =? and visit_no =? and department_id=? and visit_date=? and hospital_id=?";
				PreparedStatement selectPrep = con
						.prepareStatement(visitQuery);
				int indexForVisit = 1;
				selectPrep.setInt(indexForVisit++, hin_id);
				selectPrep.setInt(indexForVisit++, visitNo); // added by amit das on 07-12-2016
				selectPrep.setInt(indexForVisit++, Integer.parseInt(pv1.getPv140_BedStatus().getValue()));
				visitDate = convertStringTypeDateToSQLDate(pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().getValue());
				selectPrep.setDate(indexForVisit++, visitDate);
				selectPrep.setInt(indexForVisit++, Integer.parseInt(pv1.getPv110_HospitalService().getValue() ));
				ResultSet visitResult = selectPrep.executeQuery();
				int visit_id = 0;
				while (visitResult.next()) {
					visit_id = visitResult.getInt("visit_id");
					System.out.println("Visit already created !!!");
					bool = true;
				}
				// end by amit das on 05-12-2016
				
				
				if(visit_id==0){
					bool=vs.execute();
					System.out.println("*******Visit Saved for HIN - "+hin_id+"*********");
				}
				
				if(!bool && visit_id==0){
				ResultSet vSet=vs.getGeneratedKeys();
				while (vSet.next()) {
					visit_id = vSet.getInt("visit_id");
				}  
				}
				
				// added by amit das on 06-10-2016
				PreparedStatement ps = con.prepareStatement(updatePatientField,
						Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, currentVisitNo+1);
				ps.setString(2, hinNo);
				ps.executeUpdate();
				// ended by amit das on 06-10-2016
				
				PreparedStatement qs = con.prepareStatement(insertQueue,
						Statement.RETURN_GENERATED_KEYS);
				if(visit_id>0){
					index=1;
					qs.setInt(index++,visit_id); 
					if(pv1.getPv15_PreadmitNumber().getValue()!=null){
						qs.setInt(index++,Integer.parseInt(pv1.getPv15_PreadmitNumber().getValue())); 
					}
					if (pv1.getPv18_ReferringDoctor().getIDNumber().getValue() != null) {
						qs.setInt(index++,Integer.parseInt(pv1.getPv18_ReferringDoctor().getIDNumber().getValue())); 
						 
					}
					if (pv1.getPv110_HospitalService().getValue() != null) { 
						qs.setInt(index++,Integer.parseInt(pv1.getPv110_HospitalService().getValue()));  
					}
					if(pv1.getPv111_TemporaryLocation().getCm_internal_location1_NurseUnitStation().getValue()!=null){ 
						qs.setInt(index++,Integer.parseInt(pv1.getPv111_TemporaryLocation().getCm_internal_location1_NurseUnitStation().getValue())); 
						 
					}
					if(pv1.getPv116_VIPIndicator().getValue()!=null){
						qs.setInt(index++,Integer.parseInt(pv1.getPv116_VIPIndicator().getValue())); 
					}
					if(hin_id>0){
						qs.setInt(index++,hin_id);  
					}
					if (pv1.getPv140_BedStatus().getValue() != null) {
						qs.setInt(index++,Integer.parseInt(pv1.getPv140_BedStatus().getValue()));  
					} 
					if (pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().getValue() != null) {
						qs.setDate(index++, convertStringTypeDateToSQLDate(pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().getValue())); 
					} 
					if (pv1.getPv144_AdmitDateTime().getTs2_DegreeOfPrecision().getValue() != null) {
						qs.setString(index++, pv1.getPv144_AdmitDateTime().getTs2_DegreeOfPrecision().getValue() ); 
					} 
				    qs.execute();
				    System.out.println("*******Queue Managemnent Saved for HIN - "+hin_id+"*********");
				    
				    PreparedStatement hs = con.prepareStatement(insertBlOpBillHeader,
							Statement.RETURN_GENERATED_KEYS);
				    index=1;
				    if (pv1.getPv17_AttendingDoctor().getCn1_IDNumber().getValue() != null) {
				    	hs.setInt(index++,Integer.parseInt(pv1.getPv17_AttendingDoctor().getCn1_IDNumber().getValue())); 
					}
				    if (pv1.getPv110_HospitalService().getValue() != null) { 
				    	hs.setInt(index++,Integer.parseInt(pv1.getPv110_HospitalService().getValue()));  
					}
					if(hin_id>0){
						hs.setInt(index++,hin_id); 
					}
					if (pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().getValue() != null) { 
						hs.setDate(index++, convertStringTypeDateToSQLDate(pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().getValue())); 
					}
					if (pv1.getPv144_AdmitDateTime().getTs2_DegreeOfPrecision()
							.getValue() != null) { 
						hs.setString(index++, pv1.getPv144_AdmitDateTime().getTs2_DegreeOfPrecision()
								.getValue()); 
					}
					if(pv1.getPv147_TotalCharges().getValue()!=null){
						hs.setBigDecimal(index++, new BigDecimal(pv1.getPv147_TotalCharges().getValue()));  
					} 
					if (pv1.getPv148_TotalAdjustments().getValue() != null) {
						hs.setBigDecimal(index++, new BigDecimal(pv1.getPv148_TotalAdjustments().getValue()));   
					}
					if (pv1.getPv149_TotalPayments().getValue() != null) {
						hs.setBigDecimal(index++, new BigDecimal(pv1.getPv149_TotalPayments().getValue()));    
					}
					if (pid.getPid4_AlternatePatientID().getValue() != null) {
						hs.setString(index++, pid.getPid4_AlternatePatientID().getValue());  
					}
					if(pv1.getPv146_CurrentPatientBalance().getValue()!=null){
						hs.setBigDecimal(index++, new BigDecimal(pv1.getPv146_CurrentPatientBalance().getValue()));  
					}
					if(pv1.getPv150_AlternateVisitID().getIDNumber().getValue()!=null){
						hs.setString(index++, pv1.getPv150_AlternateVisitID().getIDNumber().getValue());   
					}
					if(pv2.getPv22_AccommodationCode().getCe1_Identifier().getValue()!=null){
						hs.setString(index++, pv2.getPv22_AccommodationCode().getCe1_Identifier().getValue()); 
					}
					int headerId=0;
					if(pv2.getPv21_PriorPendingLocation().getBedStatus().getValue()!=null){
						boolean val=hs.execute();
						if(!val){
						ResultSet set=hs.getGeneratedKeys();
						System.out.println("*******Bl Op Bill Header Saved for HIN - "+hin_id+"*********");
						while (set.next()) {
							headerId = set.getInt("op_bill_header_id");
							}   
						}
					}
					
					 PreparedStatement ds = con.prepareStatement(insertBlOpBillDetails,
								Statement.RETURN_GENERATED_KEYS);
					if(headerId>0 && pv2.getPv21_PriorPendingLocation().getBedStatus().getValue()!=null){
						index=1;
						ds.setInt(index++, headerId);
						if (pv1.getPv17_AttendingDoctor().getCn1_IDNumber().getValue() != null) {
							ds.setInt(index++,Integer.parseInt(pv1.getPv17_AttendingDoctor().getCn1_IDNumber().getValue()));  
						}
						if (pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().getValue() != null) {
							ds.setDate(index++, convertStringTypeDateToSQLDate(pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().getValue())); 

						}
						if (pv1.getPv144_AdmitDateTime().getTs2_DegreeOfPrecision()
								.getValue() != null) {
							ds.setString(index++, pv1.getPv144_AdmitDateTime().getTs2_DegreeOfPrecision()
									.getValue()); 
						}
						if(pv2.getPv25_PatientValuables(0).getValue()!=null){
							ds.setBigDecimal(index++, new BigDecimal(pv2.getPv25_PatientValuables(0).getValue()));  
						}
						if(pv2.getPv26_PatientValuablesLocation().getValue()!=null){
							ds.setBigDecimal(index++, new BigDecimal(pv2.getPv26_PatientValuablesLocation().getValue()));  
						}
						if(pv2.getPv21_PriorPendingLocation().getBedStatus().getValue()!=null){
							ds.setInt(index++,Integer.parseInt(pv2.getPv21_PriorPendingLocation().getBedStatus().getValue()));  
						}
						if(pv2.getPv23_AdmitReason().getCe2_Text().getValue()!=null){
							ds.setBigDecimal(index++, new BigDecimal(pv2.getPv23_AdmitReason().getCe2_Text().getValue())); 
						}
						if(pv2.getPv24_TransferReason().getCe2_Text().getValue()!=null){
							ds.setBigDecimal(index++, new BigDecimal(pv2.getPv24_TransferReason().getCe2_Text().getValue()));  
						}
						if(pv2.getPv22_AccommodationCode().getCe1_Identifier().getValue()!=null){
							ds.setString(index++, pv2.getPv22_AccommodationCode().getCe1_Identifier().getValue()); 
						}  
						ds.execute();
						System.out.println("*******Bl Op Bill Details Saved for HIN - "+hin_id+"*********");
					}
					
					

					// *******************pharmacy lab queue*****************************
					  if(obx!= null && obx.getObservationSubID().getValue()!=null){
					              int tokenNo     			  	= 	0;
					              int departmentId				=	0;
					              String pharmacyLabStatus		=	"";
					              String status					=	"";
					              int totalHospitalVisits		=	0;
					              
					              if(obx.getResponsibleObserver().getCn2_FamilyName()!=null)
					            	  	tokenNo = Integer.parseInt(obx.getResponsibleObserver().getCn2_FamilyName().getValue());
					              
					              departmentId	= Integer.parseInt(obx.getObx7_ReferencesRange().getValue());
					              pharmacyLabStatus = obx.getObservationIdentifier().getCe1_Identifier().getValue();
					              status = obx.getObservationSubID().getValue();
					              
					              if(obx.getResponsibleObserver().getCn2_FamilyName()!=null)
					            	  	totalHospitalVisits = Integer.parseInt(obx.getObx10_NatureOfAbnormalTest().getValue());
					             
					              
					            	  
					              StringBuilder insertPharmacyLabQueueField = new StringBuilder(
					                  "INSERT INTO pharmacy_lab_queue(visit_id,token_no,department_id,hospital_id,opd_date,opd_time,pharmacy_lab_status,status,total_hospital_visit");
					              StringBuilder insertPharmacyLabQueueValue = new StringBuilder(
					                  ")VALUES(?,?,?,?,?,?,?,?,?)");
					              String insertPharmacyLabQueue = insertPharmacyLabQueueField
					                  .append(insertPharmacyLabQueueValue).toString();
					             
					                PreparedStatement insertPharmacyLabQueueStatement = con.prepareStatement(
					                    insertPharmacyLabQueue);
					                index = 1;
					                
					                insertPharmacyLabQueueStatement.setInt(index++, visit_id);
					                
					                if(tokenNo!=0)
					                  insertPharmacyLabQueueStatement.setInt(index++, tokenNo);
					                else
					                  insertPharmacyLabQueueStatement.setNull(index++, java.sql.Types.INTEGER);
					                
					                insertPharmacyLabQueueStatement.setInt(index++, departmentId);
					                insertPharmacyLabQueueStatement.setInt(index++, hospIdForPharmacyLabQueue);
					                insertPharmacyLabQueueStatement.setDate(index++, visitDate);
					                insertPharmacyLabQueueStatement.setString(index++, visitTime);
					                insertPharmacyLabQueueStatement.setString(index++, pharmacyLabStatus);
					                insertPharmacyLabQueueStatement.setString(index++, status);
					                
					                if(totalHospitalVisits!=0)
						                  insertPharmacyLabQueueStatement.setInt(index++, totalHospitalVisits);
						                else
						                  insertPharmacyLabQueueStatement.setNull(index++, java.sql.Types.INTEGER);
						            
					                insertPharmacyLabQueueStatement.execute();
					                System.out.println("*******pharmacy lab queue Saved for HIN - "+hin_id+"*********");
					              
					            }
					            
				}
			   }else{
				   System.out.println("hin_id was not found !!!");
				   somethingFailed = true;
			   }
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
			/*opBillHeader.setStatus(pv1.getPv14_AdmissionType().getValue());
			
			queue.setPriorityNumber(Integer.parseInt(pv1
					.getPv15_PreadmitNumber().getValue()));
			if(pv1.getPv15_PreadmitNumber().getValue()!=null){
				visit.setPriorityNumber(Integer.parseInt(pv1
						.getPv15_PreadmitNumber().getValue()));
			} 
			if (pv1.getPv16_PriorPatientLocation()
					.getCm_internal_location1_NurseUnitStation().getValue() != null) {
				HospitalDoctorUnitM unitM = new HospitalDoctorUnitM(
						Integer.parseInt(pv1.getPv16_PriorPatientLocation()
								.getCm_internal_location1_NurseUnitStation()
								.getValue()));
				visit.setUnit(unitM);
			}
			if (pv1.getPv17_AttendingDoctor().getCn1_IDNumber().getValue() != null) {
				Users users = new Users(
						Integer.parseInt(pv1.getPv17_AttendingDoctor()
								.getCn1_IDNumber().getValue()));
				visit.setAddEditBy(users);
			}
			if (pv1.getPv18_ReferringDoctor().getIDNumber().getValue() != null) {
				MasEmployee masEmployee = new MasEmployee(Integer.parseInt(pv1
						.getPv18_ReferringDoctor().getIDNumber().getValue()));
				visit.setDoctor(masEmployee);
				queue.setDocotor(masEmployee);
			}
			if (pv1.getPv110_HospitalService().getValue() != null) {
				MasHospital hospital = new MasHospital(Integer.parseInt(pv1
						.getPv110_HospitalService().getValue()));
				visit.setHospital(hospital);
				queue.setHospital(hospital);
			}
			visit.setTotalHospitalVisit(Integer.parseInt(pv1
					.getPv111_TemporaryLocation()
					.getCm_internal_location1_NurseUnitStation().getValue()));
			queue.setTotalHospitalVisit(Integer.parseInt(pv1
					.getPv111_TemporaryLocation()
					.getCm_internal_location1_NurseUnitStation().getValue()));
			if (pv1.getPv112_PreadmitTestIndicator().getValue() != null) {
				MasDiagnosisConclusion conclusion = new MasDiagnosisConclusion(
						Integer.getInteger(pv1.getPv112_PreadmitTestIndicator()
								.getValue()));
				visit.setDiagnosis(conclusion);
			}
			if (pv1.getPv113_ReadmissionIndicator().getValue() != null) {
				MasComplaint masComplaint = new MasComplaint(
						Integer.parseInt(pv1.getPv113_ReadmissionIndicator()
								.getValue()));
				visit.setComplaint(masComplaint);
			}
			visit.setEdStatus(pv1.getPv114_AdmitSource().getValue());
			visit.setVisitStatus(pv1.getPv115_AmbulatoryStatus(0).getValue());
			visit.setTokenNo(Integer.parseInt(pv1.getPv116_VIPIndicator()
					.getValue()));
			queue.setTokenNo(Integer.parseInt(pv1.getPv116_VIPIndicator()
					.getValue()));
			// visit.setHin(patient);
			// queue.setHin(patient);
			visit.setVisitNo(Integer.parseInt(pv1.getPv119_VisitNumber()
					.getCm_pat_id1_IDNumber().getValue()));
			visit.setCurPharVisitStatus(pv1.getPv122_CourtesyCode().getValue());
			visit.setStatus(pv1.getPv123_CreditRating().getValue());
			visit.setAppointmentType(pv1.getPv124_ContractCode(0).getValue());

			if (pv1.getPv125_ContractEffectiveDate(0).getValue() != null) {
				// visit.setAddEditDate(pv1.getPv125_ContractEffectiveDate(0).getValue());

			}
			if (pv1.getPv127_ContractPeriod(0).getValue() != null) {
				visit.setAddEditTime(pv1.getPv127_ContractPeriod(0).getValue());
			}
			if (pv1.getPv139_ServicingFacility().getValue() != null) {
				MasCaseType caseType = new MasCaseType(Integer.parseInt(pv1
						.getPv139_ServicingFacility().getValue()));
				visit.setCaseType(caseType);
			}
			if (pv1.getPv140_BedStatus().getValue() != null) {
				MasDepartment department = new MasDepartment(
						Integer.parseInt(pv1.getPv140_BedStatus().getValue()));
				visit.setDepartment(department);
				queue.setDepartment(department);
			}
			if (pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().getValue() != null) {
				 //visit.setVisitDate(pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().getValue());
				// queue.setLsCngDate(pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().getValue());
			}
			if (pv1.getPv144_AdmitDateTime().getTs2_DegreeOfPrecision()
					.getValue() != null) {
				visit.setVisitTime(pv1.getPv144_AdmitDateTime()
						.getTs2_DegreeOfPrecision().getValue());
			}
			
			if(pv1.getPv147_TotalCharges().getValue()!=null) // added by amit das on 28-11-2016
			opBillHeader.setBillAmt(new BigDecimal(pv1.getPv147_TotalCharges()
					.getValue()));
			
			if (pv1.getPv148_TotalAdjustments().getValue()!= null) {
				opBillHeader.setAdvanceAdjustment(new BigDecimal(pv1
						.getPv148_TotalAdjustments().getValue()));

			}
			
			if (pv1.getPv149_TotalPayments().getValue()!= null) {
				opBillHeader.setActualCollectedAmt(new BigDecimal(pv1
						.getPv149_TotalPayments().getValue()));
			}*/ // commented by amit das on 26-12-2016
			// **queue.getPriorityNumber();
			// **queue.getDocotor();
			// queue.getHin();
			// **queue.getLsCngDate();**visitDate
			// **queue.getHospital();
			// **queue.getDepartment();
			// **queue.getTotalHospitalVisit();
			// **queue.getTokenNo();
			// queue.getVisit();
			
			// opBillHeader.getBillAmt();
			// opBillHeader.getAdvanceAdjustment();
			// opBillHeader.getActualCollectedAmt();
			// opBillHeader.getHin();
			// opBillHeader.getHinNo();
			// opBillHeader.getBillDate();
			// opBillHeader.getBillTime();
			// opBillHeader.getChangedBy();
			// opBillHeader.getStatus();

			// opBillDetails.getRate()
			// opBillDetails.getAmount();
			// opBillDetails.getChargeCode();not applicable
			// opBillDetails.getBillDate();
			// opBillDetails.getBillTime();
			// opBillDetails.getChangedBy();
			// opBillDetails.getRefundableStatus();

			
			/*pv2.getPv27_VisitUserCode().setValue(queue.getTokenStatus());
			pv2.getPv25_PatientValuables(0).setValue(
					opBillDetails.getRate() + "");
			pv2.getPv26_PatientValuablesLocation().setValue(
					opBillDetails.getAmount() + "");
			pv2.getPv22_AccommodationCode().getCe1_Identifier()
					.setValue(opBillDetails.getRefundableStatus() + "");*/ 
			
			// commented by amit das on 
			// PV1 pv2=(PV1)theMessage.get("PV1");
			System.out.println("Patient Visit:\n" + pv1.getPv12_PatientClass());
			// Segment segment = (Segment)Msg.get("PV1");
			// Structure[] Structs = Msg.getAll("DG1");
			// .. process the message ..

			/*
			 * Now reply to the message
			 */
			Message response;
			try {
				response = theMessage.generateACK();
			} catch (IOException e) {
				throw new ReceivingApplicationException(e);
			}

			/*
			 * If something goes horribly wrong, you can throw an exception and
			 * an HTTP 500 error will be generated. However, it is preferable to
			 * return a normal HL7 ACK message with an "AE" response code to
			 * note an error.
			 */
			
			/*if (somethingFailed) {
				throw new ReceivingApplicationException("");
			}*/

			/*
			 * It is better to return an HL7 message with an AE response code.
			 * This will still be returned by the transport with an HTTP 500
			 * status code, but an HL7 message will still be propagated up.
			 */
			if (somethingFailed) {
				try {
					System.out.println("Something has failed !!!!");
					response = theMessage.generateACK("AE", new HL7Exception(
							"There was a problem!!"));
				} catch (IOException e) {
					throw new ReceivingApplicationException(e);
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