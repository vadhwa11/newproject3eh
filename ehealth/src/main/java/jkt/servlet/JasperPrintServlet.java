/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2009 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */
package jkt.servlet;

import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.PRESCRIPTION_SLIP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.net.URL;

import jkt.hms.adt.handler.RegistrationHandlerService;
import jkt.hms.adt.handler.RegistrationHandlerServiceImpl;
import jkt.hms.masters.business.BlOpBillDetails;
import jkt.hms.masters.business.BlOpBillHeader;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientAddress;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.business.Users;
import jkt.hms.util.HMSUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JasperPrintServlet.java,v 1.1 2010/12/03 09:16:29 dipali Exp $
 */
public class JasperPrintServlet extends HttpServlet
{


	/**
	 *
	 */
	public void service(
		HttpServletRequest request,
		HttpServletResponse response
		) throws IOException, ServletException
	{
		ServletContext context = this.getServletConfig().getServletContext();
		File reportFile = null;
		Map parameters = new HashMap();
		
		Properties prop = new Properties();
		InputStream input = null;
		
		String hinNo = "";
		String loginName = "";;
		String report = "";
		String Duplicate="Duplicate";
		int inpatientId = 0;
		int hospitalId = 0;
		int departmentId=0;
		int pHinId=0;
		
		
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("jdbc.properties");
		try {
			 input = new FileInputStream(new
			 File(resourcePath.getFile()));
			 prop.load(input);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		if(request.getParameter("hinNo") != null){
			hinNo = request.getParameter("hinNo");
		}
		if(request.getParameter("loginName") != null){
			loginName = request.getParameter("loginName");
		}
		if(request.getParameter("report") != null){
			report = request.getParameter("report");
		}
		if(request.getParameter("inpatientId") != null){
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		}
		if (request.getParameter("pHinId") != null) {
			pHinId =Integer.parseInt( request.getParameter("pHinId"));
		}
		if (request.getParameter("hospitalId") != null) {
			hospitalId =Integer.parseInt( request.getParameter("hospitalId"));
		}
		
		
		System.out.println("hinNo=== "+hinNo);	
		System.out.println("loginName=== "+loginName);	
		System.out.println("report---- "+report);
		System.out.println("inpatientId---- "+inpatientId);
		System.out.println("pHinId---- "+pHinId);
		System.out.println("hospitalId---- "+hospitalId);
		
		/*if(billType.equals("servicing")){
			reportFile = new File(context.getRealPath("/Reports/Servicing_Bill.jasper"));
			parameters.put("billNo", billNo);
			parameters.put("loginname", loginName);
		}else if(billType.equals("dispensing")){
			reportFile = new File(context.getRealPath("/Reports/BillDispensingsummary.jasper"));
			parameters.put("billNo", billNo);
			parameters.put("loginname", loginName);
		}else if(billType.equals("finalBill")){
			reportFile = new File(context.getRealPath("/Reports/finalsettlementSummary.jasper"));
			parameters.put("inpatientId", inpatientId);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		}else if(billType.equals("finalBillSettlement")){
			reportFile = new File(context.getRealPath("/Reports/finalBillSettlementSummary.jasper"));
			parameters.put("inpatientId", inpatientId);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		}else if(billType.equals("receipt")){
			reportFile = new File(context.getRealPath("/Reports/Receipt.jasper"));
			parameters.put("receiptNo", billNo);
		}else if(billType.equals("chargeSlip"))
		{
			parameters.put("billNo", Integer.parseInt(billNo));
			reportFile = new File(context.getRealPath("/Reports/ChargeSlip.jasper"));
		}else if(billType.equals("refunds"))
		{
			parameters.put("refundno", billNo);
			reportFile = new File(context.getRealPath("/Reports/CashRefund.jasper"));
		}else if(billType.equals("servicingDup")){
			reportFile = new File(context.getRealPath("/Reports/Servicing_Bill.jasper"));
			parameters.put("billNo", billNo);
			parameters.put("loginname", loginName);
			parameters.put("Duplicate", Duplicate);
		}else if(billType.equals("dispensingDup")){
			reportFile = new File(context.getRealPath("/Reports/BillDispensingsummary.jasper"));
			parameters.put("billNo", billNo);
			parameters.put("loginname", loginName);
			parameters.put("Duplicate", Duplicate);
		}else if(billType.equals("finalBillDup")){
			reportFile = new File(context.getRealPath("/Reports/finalsettlementSummary.jasper"));
			parameters.put("Duplicate", Duplicate);
			parameters.put("inpatientId", inpatientId);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		}else if(billType.equals("finalBillSettlementDup")){
			reportFile = new File(context.getRealPath("/Reports/finalBillSettlementSummary.jasper"));
			parameters.put("Duplicate", Duplicate);
			parameters.put("inpatientId", inpatientId);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		}else if(billType.equals("receiptDup")){
			parameters.put("Duplicate", Duplicate);
			reportFile = new File(context.getRealPath("/Reports/Receipt.jasper"));
			parameters.put("receiptNo", billNo);
		}else if(billType.equals("chargeSlipDup"))
		{
			parameters.put("Duplicate", Duplicate);
			parameters.put("billNo", Integer.parseInt(billNo));
			reportFile = new File(context.getRealPath("/Reports/ChargeSlip.jasper"));
		}else if(billType.equals("refundsDup"))
		{
			parameters.put("Duplicate", Duplicate);
			parameters.put("refundno", billNo);
			reportFile = new File(context.getRealPath("/Reports/CashRefund.jasper"));
		}*/
		
		
		// added by amit das on 27-05-2016
		if(report!=null && report.equalsIgnoreCase("RegistrationCardNew")){
			//
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> dMap = new HashMap<String, Object>();
			Map<String, Object> patientMap = new HashMap<String, Object>();
			RegistrationHandlerService registrationHandlerService = new RegistrationHandlerServiceImpl();
			String hinNoRandom="";
			HttpSession session = request.getSession();
			//@SuppressWarnings("unused")
			// String opdPrint ="n";
			String pSlip = "n";
			String billNo = "";
			/*synchronized (session) {*/
				// hospitalId = (Integer) session.getAttribute(HOSPITAL_ID); // commented by amit das on 13-06-2016
			/*}*/
				
				hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
			
			if (request.getParameter("hinNo") != null) {
				hinNo = request.getParameter("hinNo");
				parameters.put("hinNo", hinNo);
			}

			if (request.getParameter(PRESCRIPTION_SLIP) != null) {
				pSlip = request.getParameter(PRESCRIPTION_SLIP);
			}
			// if(request.getParameter(MEDICAL_CASE_SHEET) != null){
			// mcs=request.getParameter(MEDICAL_CASE_SHEET);
			// }
			// if(request.getParameter(OPD_PRINT) != null){
			// opdPrint=request.getParameter(OPD_PRINT);
			// }
			/**
			* For Patient Photo
			*/
			
			
			Patient patient = new Patient();
			int patientHinId=0;
			
			if(null !=request.getParameter("patientHinId") && !request.getParameter("patientHinId").equals("")){
				patientHinId=Integer.parseInt(request.getParameter("patientHinId"));
				patient.setId(patientHinId);
				System.out.println("!!!!patientHinId &&***###@@@   "+patientHinId);
			BlOpBillHeader opBillHeader=new BlOpBillHeader();
			
			double totalPastDue=0.0;
			double availableCreditBal=0.0;
			double revisedCreditBalance=0.0;
			
			if(null !=request.getParameter("availableCreditBalance") && !request.getParameter("availableCreditBalance").equals("")){
				availableCreditBal=Double.parseDouble(request.getParameter("availableCreditBalance"));
			}
			if(null !=request.getParameter("revisedCreditBalance") && !request.getParameter("revisedCreditBalance").equals("")){
				revisedCreditBalance=Double.parseDouble(request.getParameter("revisedCreditBalance"));
			}
			totalPastDue=availableCreditBal+revisedCreditBalance;
			
			if(null !=request.getParameter("billAmount")&& !request.getParameter("billAmount").equals("") ){
				opBillHeader.setBillAmt(new BigDecimal(request.getParameter("billAmount")));
			}
			if(null !=request.getParameter("adjustAgainstCreditName") && !request.getParameter("adjustAgainstCreditName").equals("")){
				
				opBillHeader.setAdvanceAdjustment(new BigDecimal(request.getParameter("adjustAgainstCreditName")));
			}
			if(null !=request.getParameter("amountTendered") && !request.getParameter("amountTendered").equals("")){
				
				opBillHeader.setActualCollectedAmt(new BigDecimal(request.getParameter("amountTendered")));
			}
			
			/*if(null !=request.getParameter("balanceToBePaid")){
				
				opBillHeader.set(new BigDecimal(request.getParameter("balanceToBePaid")));
			}*/
			opBillHeader.setHin(patient);
			opBillHeader.setHinNo(hinNo);
			
			opBillHeader.setBillDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter(CHANGED_DATE)));
			opBillHeader.setBillTime(request.getParameter(CHANGED_TIME));
			
			
			
			Users user = new Users();
			int userId =0;
			Users userObj = new Users();
			synchronized (session) {
				user = (Users) session.getAttribute("users");
				userId=user.getId();
				userObj.setId(userId);
			}
			userObj.setId(userId);

			opBillHeader.setChangedBy(userObj);
			opBillHeader.setStatus("y");
			
			dMap.put("opBillHeader", opBillHeader);
			
			BlOpBillDetails opBillDetails=new BlOpBillDetails();
			if(null !=request.getParameter("billAmount") ){
				opBillDetails.setRate(new BigDecimal(request.getParameter("billAmount")));
			}
			if(null !=request.getParameter("billAmount") ){
				opBillDetails.setAmount(new BigDecimal(request.getParameter("billAmount")));
			}
			
			int chargeId=0;
			if(null !=request.getParameter("registrationType") && !request.getParameter("registrationType").equals("0") ){
				chargeId=Integer.parseInt(request.getParameter("registrationType"));
				MasChargeCode chargeCode=new MasChargeCode();
				chargeCode.setId(chargeId);
				opBillDetails.setChargeCode(chargeCode);
				
				
			}
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			Date changeDate = HMSUtil.convertStringTypeDateToDateType(date);
			
			opBillDetails.setBillDate(changeDate);
			opBillDetails.setBillTime(time);
			opBillDetails.setChangedBy(user);
			
			opBillDetails.setRefundableStatus("y");
			dMap.put("opBillDetails", opBillDetails);
			dMap.put("totalPastDue", totalPastDue);
			dMap.put("hospitalId", hospitalId);
			dMap.put("patientHinId", patientHinId);
			// registrationHandlerService.saveRegistrationCardPrintAmount(dMap);
			}
			Random rnd = new Random(System.currentTimeMillis());
			int radonNumber=(rnd.nextInt(900) + 100);
			hinNoRandom=hinNo+radonNumber;
		
			// registrationHandlerService.updatePatientPrintStatus(hinNo,radonNumber);
			// detailsMap = registrationHandlerService.getConnectionForReport();
			// patientMap = registrationHandlerService.getPatientList(hinNo);
			String imgfile ="";
			String state="";
			String district="";
			String address="";
			
			String houseNo="";
			String lsgHouseNo="";
			String Postoffice="";
			String pincode="";
					
			
			
			List<Patient> patientList = new ArrayList<Patient>();
			List<UploadDocuments> uploadDocumentList=new ArrayList<UploadDocuments>();
			List<PatientAddress> patientAddressList=new ArrayList<PatientAddress>();
			
			if (patientMap.get("uploadDocumentList") != null) {
				uploadDocumentList = (List<UploadDocuments>) patientMap.get("uploadDocumentList");
			}
			if (patientMap.get("patientAddressList") != null) {
				patientAddressList = (List<PatientAddress>) patientMap.get("patientAddressList");
			}
			if(null !=patientAddressList && patientAddressList.size()>0){
				for(PatientAddress paddress:patientAddressList){
					if(null!=paddress.getState()){
					state=paddress.getState().getStateName();
					}
					if(null!=paddress.getDistrict()){
					district=paddress.getDistrict().getDistrictName();
					}
					if(null !=paddress.getHouseNo()){
						houseNo=paddress.getHouseNo();
					}
					if(null !=paddress.getLsgHouseNo()){
						lsgHouseNo=paddress.getLsgHouseNo();
					}
					if(null !=paddress.getPostOffice()){
						Postoffice=paddress.getPostOffice().getPostCodeName();
					}
					if(null !=paddress.getPinCode()){
						pincode=""+paddress.getPinCode();
					}
					address=houseNo+" "+lsgHouseNo+" "+Postoffice+" "+pincode;
				}
				
			}

			String userHome = getServletContext().getRealPath("");
			String fileSeparator = System.getProperty("file.separator");

			String uploadURL = request.getSession().getServletContext().getRealPath(fileSeparator+"photo"+fileSeparator);

			String path="";
			if (uploadDocumentList != null
			&& uploadDocumentList.size() > 0)
			{
			UploadDocuments document= new UploadDocuments();
			document = (UploadDocuments) uploadDocumentList.get(0);

			path=uploadURL;
			if(document.getPatientDocument()!=null){


			File f = new File(path);
			try {
			if (f.exists()) {
			f.delete();
			f.mkdir();

			File someFile = new File(path+fileSeparator+hinNo + ".jpg");
			FileOutputStream fos = new FileOutputStream(
			someFile);
			fos.write(document.getPatientDocument());
			fos.flush();
			fos.close();
			} else {
			f.mkdir();
			File someFile = new File(path+fileSeparator+hinNo + ".jpg");
			FileOutputStream fos = new FileOutputStream(
			someFile);
			fos.write(document.getPatientDocument());
			fos.flush();
			fos.close();
			}
			} catch (Exception e) {
			e.printStackTrace();
			}

			imgfile =path+fileSeparator+hinNo+".jpg";
			}
			}

			File f2=null;
			Map<String, Object> dataMap = new HashMap<String, Object>();
			@SuppressWarnings("unused")
			Map<String, Object> map = new HashMap<String, Object>();
			dataMap.put("hinNo", hinNo);
			parameters.put("hinNo", hinNo);
			parameters.put("hinNoRandom", hinNoRandom);
			try{
			path=uploadURL;
			File f = new File(path);
			f2 = new File(path+fileSeparator+hinNo + ".jpg");
			if (f.exists()) {
			if(!f2.exists()){
			File someFile = new File(path+fileSeparator+"default.jpg");
			FileOutputStream fos = new FileOutputStream(
			someFile);
			//byte image[];
			fos.write(1111);
			fos.flush();
			fos.close();
			}
			}else{
			f.mkdir();
			File someFile = new File(path+fileSeparator+"default.jpg");
			FileOutputStream fos = new FileOutputStream(
			someFile);
			//byte image[];
			fos.write(1111);
			fos.flush();
			fos.close();
			}
			}
			catch (Exception e) {
			e.printStackTrace();
			}
			
			System.out.println(request.getSession().getServletContext().getRealPath("/images/instructionImag.jpg"));

			parameters.put("Instruction_IMAGE", getServletContext().getRealPath("/images/instructionImag.jpg"));
			parameters.put("Logo_IMAGE", getServletContext().getRealPath("/images/ehealthLogo.jpg"));
			//parameters.put("Instruction_IMAGE", "/images/instructionImag.jpg");
			if(f2.exists()){
			if(request.getSession().getServletContext().getRealPath("/photo/"+hinNo+".jpg") != null)
			{
				
				parameters.put("paddress",address);
				parameters.put("state",state);
				parameters.put("district",district);
			parameters.put("PATIENT_IMAGE", request.getSession().getServletContext().getRealPath("/photo/"+hinNo+".jpg"));
		//	HMSUtil.generateReport("RegistrationCardNew", parameters,(Connection) detailsMap.get("conn"), response,getServletContext());
			}
			}else{
				parameters.put("paddress",address);
				parameters.put("state",state);
				parameters.put("district",district);
			/*parameters.put("PATIENT_IMAGE", request.getSession().getServletContext().getRealPath("/photo/"+"default"+".jpg"));*/
			// HMSUtil.generateReport("RegistrationCardNewD", parameters,(Connection) detailsMap.get("conn"), response,getServletContext());
				
			 report = "RegistrationCardNewD";	
			}
			
			
			
		/*	
			HMSUtil.generateReport("RegistrationCardNew", parameters,(Connection) detailsMap.get("conn"), response,getServletContext());
	*/
			

		/*	if (request.getParameter("billNo") != null) {
				billNo = request.getParameter("billNo");
			}*/
			/*String reportName = "";
			String hin_name="";
			hin_name=properties.getProperty("com.jkt.hms.registration_no");
			Map<String, Object> dataMap1 = new HashMap<String, Object>();
			Map<String, Object> map1 = new HashMap<String, Object>();
			dataMap1.put("hinNo", hinNo);
			map1 = registrationHandlerService.getTokenNo(dataMap1);
	*/

			/*
			 * get Data For patient Photo
			 * Code By Mukesh Narayan Singh
			 * Date 05 Oct 2010
			 */
			/*String imgfile ="";
			List<Patient> patientList = new ArrayList<Patient>();
			if (map1.get("patientList") != null) {
				patientList = (List<Patient>) map1.get("patientList");
			}*/
			//map=
			//String uploadURL ="";
			/*String userHome = getServletContext().getRealPath("");
			String fileSeparator = System.getProperty("file.separator");
			String uploadURL = userHome+fileSeparator+"uploadedImage"+fileSeparator;*/
			/*if(map.get("uploadURL")!=null){
				uploadURL=(String)map.get("uploadURL");
			}*/
			/*if (patientList != null
					&& patientList.size() > 0) {
				Patient patient= new Patient();
				patient = (Patient) patientList.get(0);
				String path="";
				path=uploadURL+hinNo;

				if(patient.getPatientImage()!=null){

				File f = new File(path);
				try {
					if (f.exists()) {
						f.delete();
						f.mkdir();
						//File someFile = new File(hinNo + ".jpg");
						File someFile = new File(path+fileSeparator+hinNo + ".jpg");
						FileOutputStream fos = new FileOutputStream(
								someFile);
						//fos.write(patient.getPatientImage());
						fos.flush();
						fos.close();
					} else {
						f.mkdir();
						File someFile = new File(path+fileSeparator+hinNo + ".jpg");
						FileOutputStream fos = new FileOutputStream(
								someFile);
						//fos.write(patient.getPatientImage());
						fos.flush();
						fos.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				//String imgfile = uploadURL+uploadDocumentsList.get(0).getFileName()+"."+uploadDocumentsList.get(0).getFileExtension() ;
				imgfile =path+fileSeparator+hinNo+".jpg";
				}
			}*/
			/*
			 * get Data For patient Photo
			 * Code By Mukesh Narayan Singh
			 * Date 05 Oct 2010
			 */
			synchronized (this) {


			/*if (pSlip.equalsIgnoreCase("p")) {
				try {

					parameters.put("hinNo", hinNo);
					parameters.put("tokenNo", "" + map1.get("tokenNo"));
					parameters.put("hinNo", hinNo);
					parameters.put("hin_name", hin_name);
					parameters.put("IMAGE_RKS", getServletContext().getRealPath("/jsp/images/rks.gif"));
					parameters.put("IMAGE_DIR", getServletContext().getRealPath("/jsp/images/svb.jpg"));
					parameters.put("HOSPITAL_ID", hospitalId);
					reportName = "prescriptionSlip";
					HMSUtil.generateReport(reportName, parameters,
							(Connection) detailsMap.get("conn"), response,
							getServletContext());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}*/
			/*if (pSlip.equalsIgnoreCase("m")) {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				Map<String, Object> map = new HashMap<String, Object>();
				dataMap.put("hinNo", hinNo);
				map = registrationHandlerService.getVisitData(dataMap);
				
				 
				parameters.put("visitDate", "" + map.get("visitDate"));
				parameters.put("diagnosis", "" + map.get("visitDiagnosis"));
				parameters.put("hinNo", hinNo);
				parameters.put("hin_name", hin_name);
				parameters.put("IMAGE_RKS", getServletContext().getRealPath("/jsp/images/rks.gif"));
				parameters.put("IMAGE_DIR", getServletContext().getRealPath("/jsp/images/svb.jpg"));
				parameters.put("HOSPITAL_ID", hospitalId);
				reportName = "medicalCaseSheet";
				HMSUtil.generateReport(reportName, parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}*/
			/*if (pSlip.equalsIgnoreCase("o")) {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				@SuppressWarnings("unused")
				Map<String, Object> map = new HashMap<String, Object>();
				dataMap.put("hinNo", hinNo);
				parameters.put("hinNo", hinNo);
				parameters.put("hin_name", hin_name);
				parameters.put("IMAGE_RKS", getServletContext().getRealPath("/jsp/images/rks.gif"));
				parameters.put("IMAGE_DIR", getServletContext().getRealPath("/jsp/images/svb.jpg"));
				parameters.put("PATIENT_IMAGE", getServletContext().getRealPath("/uploadedImage/"+hinNo+"/"+hinNo+".jpg"));
				parameters.put("HOSPITAL_ID", hospitalId);
				
				if(imgfile!=""){
					parameters.put("PATIENT_IMAGE", imgfile);
				}
				reportName = "RegistrationCard";
				HMSUtil.generateReport(reportName, parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}*/
			/*if (pSlip.equalsIgnoreCase("b")) {
			//	detailsMap = registrationHandlerService.getConnectionForReport();
				String loginName = "";
				Users user = new Users();
				synchronized (session) {
					if (session.getAttribute("users") != null) {
						user = (Users) session.getAttribute("users");
						loginName = user.getLoginName();
					}
				}
				parameters.put("billNo", billNo);
				parameters.put("loginname", loginName);
				parameters.put("IMAGE_RKS", getServletContext().getRealPath("/jsp/images/rks.gif"));
				parameters.put("IMAGE_DIR", getServletContext().getRealPath("/jsp/images/svb.jpg"));
				parameters.put("HOSPITAL_ID", hospitalId);
				reportName = "Servicing_Bill";
				HMSUtil.generateReport(reportName, parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());

			}*/
			}
	/*
			try {
				JasperReport jasperReport = JasperCompileManager
						.compileReport(getServletContext().getRealPath(
								"/Reports/" + reportName + ".jrxml"));
				JasperPrint jasperPrint = JasperFillManager.fillReport(
						jasperReport, parameters,
						(Connection) detailsMap.get("conn"));

				Properties properties = new Properties();
				URL resourcePath = Thread.currentThread().getContextClassLoader()
						.getResource("printername.properties");
				try {
					properties.load(resourcePath.openStream());
				} catch (Exception e) {
					e.printStackTrace();
				}
				String billingPrinterName = properties
						.getProperty("billingPrinterName");
				String labelPrinterName = properties
						.getProperty("labelPrinterName");

				PrinterJob job = PrinterJob.getPrinterJob();
				PrintService[] services = PrintServiceLookup.lookupPrintServices(
						null, null);
				int selectedService = 0;
				for (int i = 0; i < services.length; i++) {
					if (reportName.equals("Servicing_Bill")) {
						if (services[i].getName().contains(billingPrinterName)) {
							selectedService = i;
						}
					} else if (reportName.equals("RegistrationCard")) {
						if (services[i].getName().contains(labelPrinterName)) {
							selectedService = i;
						}
					}
				}
				try {
					job.setPrintService(services[selectedService]);
				} catch (PrinterException e) {
					e.printStackTrace();
				}
				PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
				MediaSizeName mediaSizeName = MediaSize.findMedia(4, 4,
						MediaPrintableArea.INCH);
				printRequestAttributeSet.add(mediaSizeName);
				printRequestAttributeSet.add(new Copies(1));
				JRPrintServiceExporter exporter;
				exporter = new JRPrintServiceExporter();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				// We set the selected service and pass it as a paramenter
				exporter.setParameter(
						JRPrintServiceExporterParameter.PRINT_SERVICE,
						services[selectedService]);
				exporter.setParameter(
						JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET,
						services[selectedService].getAttributes());
				exporter.setParameter(
						JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET,
						printRequestAttributeSet);
				exporter.setParameter(
						JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG,
						Boolean.FALSE);
				exporter.setParameter(
						JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG,
						Boolean.FALSE);
				exporter.exportReport();

			} catch (JRException e) {
				e.printStackTrace();
			}*/
			//
		}
		
		
		if(report!=null && !report.equals("")){
			reportFile = new File(context.getRealPath("/Reports/"+report+".jasper"));
			parameters.put("hinNo", hinNo);
			parameters.put("pHinId", pHinId);
			parameters.put("hospitalId", hospitalId);
		}
		
		if (!reportFile.exists())
			throw new JRRuntimeException("File jasper file not found. The report design must be compiled first.");

		
		Connection conn = null;
					
		JasperPrint jasperPrint = null;
		try{
			Class.forName(prop.getProperty("database.driver")).newInstance();
			conn = DriverManager.getConnection(prop.getProperty("database.url"), prop.getProperty("database.user"), prop.getProperty("database.password"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try
		{
			JasperReport jasperReport = (JasperReport)JRLoader.loadObject(reportFile);
			
			jasperPrint = 
				JasperFillManager.fillReport(
					jasperReport,
					parameters, 
					conn
					);
		}
		catch (JRException e)
		{
			response.setContentType("text/html");
			e.printStackTrace();
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>JasperReports - Web Application Sample</title>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../stylesheet.css\" title=\"Style\">");
			out.println("</head>");
			
			out.println("<body bgcolor=\"white\">");

			out.println("<span class=\"bnew\">JasperReports encountered this error :</span>");
			out.println("<pre>");

			e.printStackTrace(out);

			out.println("</pre>");

			out.println("</body>");
			out.println("</html>");

			return;
		}

		if (jasperPrint != null)
		{
			response.setContentType("application/octet-stream");
			ServletOutputStream ouputStream = response.getOutputStream();
			
			ObjectOutputStream oos = new ObjectOutputStream(ouputStream);
			oos.writeObject(jasperPrint);
			oos.flush();
			oos.close();

			ouputStream.flush();
			ouputStream.close();
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>JasperReports - Web Application Sample</title>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../stylesheet.css\" title=\"Style\">");
			out.println("</head>");
			
			out.println("<body bgcolor=\"white\">");
	
			out.println("<span class=\"bold\">Empty response.</span>");
	
			out.println("</body>");
			out.println("</html>");
		}
	}
	
}
