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
import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.hoh.hapi.server.HohServlet;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v22.message.ADT_A01;
import ca.uhn.hl7v2.model.v22.segment.PID;
import ca.uhn.hl7v2.model.v22.segment.PV1;
import ca.uhn.hl7v2.model.v22.segment.PV2;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;

/**
 * Example servlet implementation which receives HL7 messages and uses HAPI to
 * process them.
 */
public class HL7ForLeanServerToUpdateVisit extends HohServlet {

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
			boolean somethingFailed = false;
			Map<String, Object> utilMap = HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			String currentTime = (String) utilMap.get("currentTime");
			java.util.Date changeDate = HMSUtil
					.convertStringTypeDateToDateType(currentDate);
			String testMsg="MSH|^~\\&|VISIT|RIH|HMS|EKG|20160202190336||ADT^A01|123|P|2.2\r"
							+"PID||||T000911301160001\r"
							+"PV1||||||||||1|||||C|||806393||||||||||||||||||||||219||||20160202^17:19\r";
			
			//HapiContext hapiContext = new DefaultHapiContext();
			//Parser p = hapiContext.getGenericParser();
			//Message hapiMsg2 = p.parse(testMsg);
			 //ADT_A01 adtMsg = (ADT_A01) testMsg;
			ADT_A01 adtMsg = (ADT_A01) theMessage;  
			PID pid = adtMsg.getPID();
			PV1 pv1 = adtMsg.getPV1(); 
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
			Connection con =null;
			try {
				Class.forName(driverName);
				 con = DriverManager.getConnection(url,userName,password);
				// Class.forName(driverName);
				// Connection connection = DriverManager.getConnection(url,
				// userName, password);
				 con.setAutoCommit(false);
				statement = con.createStatement();
				int hin_id = 0;
				int visitNo = 0 ;
				if(pv1.getPv119_VisitNumber().getCm_pat_id1_IDNumber()!=null && pv1.getPv119_VisitNumber().getCm_pat_id1_IDNumber().getValue()!=null){
					visitNo = 	Integer.parseInt(pv1.getPv119_VisitNumber().getCm_pat_id1_IDNumber().getValue());
				}
				String patientQuery = "select * from patient where hin_no= '"
						+ pid.getPid4_AlternatePatientID().getValue() + "'";
				int hospId = Integer.parseInt(pv1
						.getPv110_HospitalService().getValue());
				int departId =Integer.parseInt(pv1.getPv140_BedStatus().getValue());
				java.util.Date date = pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().getValueAsDate();
				String currentVisitPharmacyStatus = pv1.getPv122_CourtesyCode().getValue();
				try {
					ResultSet resultSet = statement.executeQuery(patientQuery);
					while (resultSet.next()) {
						hin_id = resultSet.getInt("hin_id");
					}
				} catch (SQLException e1) {
					somethingFailed = true;
					e1.printStackTrace();
				}
				System.out.println(" hin_id ============ "+hin_id);
				if (hin_id != 0) {
					String visitQuery = "select * from visit where hin_id =? and visit_no =? and department_id=? and visit_date=? and hospital_id=?";
					PreparedStatement selectPrep = con
							.prepareStatement(visitQuery);
					int index = 1;
					selectPrep.setInt(index++, hin_id);
					selectPrep.setInt(index++, visitNo); // added by amit das on 24-12-2016
					selectPrep.setInt(index++, departId);
					selectPrep.setDate(index++, new Date(date.getTime()));
					selectPrep.setInt(index++, hospId);
					ResultSet visitResult = selectPrep.executeQuery();
					String updateVisit = "update visit set cur_phar_visit_status=? where visit_id=?";
					int visit_id = 0;
					
					System.out.println(" visit_id ============ "+visit_id);
					if (visitResult.next()) {
						visit_id = visitResult.getInt("visit_id");
						PreparedStatement updatePrepare = con
								.prepareStatement(updateVisit);
						index = 1;
						updatePrepare.setString(index++, currentVisitPharmacyStatus); 
						updatePrepare.setInt(index++, visit_id);
						updatePrepare.executeUpdate(); 
						System.out.println(" cur_phar_visit_status updated for visit_id  ============ "+visit_id);
					}else {
						somethingFailed = true;
					}
					
				}else{
					somethingFailed = true;
				}
				 
				con.commit();
			} catch (ClassNotFoundException e) {
				somethingFailed = true;
				e.printStackTrace();
			} catch (SQLException e) {
				somethingFailed = true;
				e.printStackTrace();
			}finally{
				if(con!=null){
					try {
						con.close();
					} catch (SQLException e) { 
						e.printStackTrace();
					}
				}
			}
			 

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