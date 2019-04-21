/**
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * EnquiryController.java
 * Purpose of the class - This is Enquiry Module.
 * It contains Patient Enquiry and Doctor Enquiry.
 * @author  Ritu Sahu
 * Create Date: 8th Feb,2008
 * Revision Date:
 * Revision By: Purpose
 * @version 1.0
 **/

package jkt.hms.enquiry.controller;

import static jkt.hms.util.RequestConstants.ADDRESS;
import static jkt.hms.util.RequestConstants.AD_NO;
import static jkt.hms.util.RequestConstants.DISTRICT_ID;
import static jkt.hms.util.RequestConstants.DOCTOR_ENQUIRY_JSP;
import static jkt.hms.util.RequestConstants.DOCTOR_NAME;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.IN_PATIENT_ENQUIRY_JSP;
import static jkt.hms.util.RequestConstants.MOBILE_NO;
import static jkt.hms.util.RequestConstants.PATIENT_DEPARTMENT;
import static jkt.hms.util.RequestConstants.PATIENT_DETAILS;
import static jkt.hms.util.RequestConstants.PATIENT_ENQUIRY_JSP;
import static jkt.hms.util.RequestConstants.PATIENT_NAME;
import static jkt.hms.util.RequestConstants.PATIENT_STATUS;
import static jkt.hms.util.RequestConstants.POLICE_STATION;
import static jkt.hms.util.RequestConstants.P_FIRST_NAME;
import static jkt.hms.util.RequestConstants.P_LAST_NAME;
import static jkt.hms.util.RequestConstants.P_MIDDLE_NAME;
import static jkt.hms.util.RequestConstants.RANK_ID;
import static jkt.hms.util.RequestConstants.RESPONCE_FOR_AD_VISIT;
import static jkt.hms.util.RequestConstants.RESPONCE_FOR_ALL_ENQUIRY;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.SERVICE_PERSON_NAME;
import static jkt.hms.util.RequestConstants.SERVICE_TYPE_ID;
import static jkt.hms.util.RequestConstants.STATE_ID;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.UNIT_ID;
import static jkt.hms.util.RequestConstants.VILLAGE;
import static jkt.hms.util.RequestConstants.WARD_ID;
import static jkt.hms.util.RequestConstants.WARD_WISE_PATIENT_POPUP_JSP;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.enquiry.handler.EnquiryHandlerService;
import jkt.hms.masters.business.DgResultEntryDetail;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientAddress;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class EnquiryController extends MultiActionController {

	EnquiryHandlerService enquiryHandlerService = null;

	public ModelAndView showEnquiryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		String jsp = "";
		if (request.getParameter("jspName") != null) {
			jsp = request.getParameter("jspName");
		}
		if (jsp.equals("patientEnquiry")) {
			map = enquiryHandlerService.getDetailsForEnquiry();
		} else if (jsp.equals("doctorEnquiry")) {
			wardList = enquiryHandlerService.getWardList();
			map.put("wardList", wardList);
		} else if (jsp.equals("inPatientEnquiry")) {
			map = enquiryHandlerService.getDetailsForEnquiry();
		}
		
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPatientForEnquiry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> enquiryMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		
		String relativeName = "";
		String village = "";
		String hinNo = "";
		String adNo = "";
		int patientRelation = 0;
		Date toDate = new Date();
		Date fromDate = new Date();
		String patientName = "";
		int hinId = 0;
		String address = "";
		int stateId = 0;
		String policeStation = "";
		String patientStatus = "";
		String mobileNo = "";
		int  hospitalId = 0;
		try {
			
			HttpSession session = request.getSession();

			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			enquiryMap.put("hospitalId", hospitalId);
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				enquiryMap.put("hinNo", hinNo);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				enquiryMap.put("adNo", adNo);
			}
			if (request.getParameter("relativeName") != null
					&& !(request.getParameter("relativeName").equals(""))) {
				relativeName = request.getParameter("relativeName");
				enquiryMap.put("relativeName", relativeName);
			}
			if (request.getParameter("patientRelation") != null
					&& !(request.getParameter("patientRelation").equals(""))) {
				patientRelation = Integer.parseInt(request
						.getParameter("patientRelation"));
				enquiryMap.put("patientRelation", patientRelation);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				enquiryMap.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				enquiryMap.put("toDate", toDate);
			}
			if (request.getParameter(PATIENT_NAME) != null
					&& !(request.getParameter(PATIENT_NAME).equals(""))) {
				patientName = request.getParameter(PATIENT_NAME);
				enquiryMap.put("patientName", patientName);
			}
			if (request.getParameter(ADDRESS) != null
					&& !(request.getParameter(ADDRESS).equals(""))) {
				address = request.getParameter(ADDRESS);
				enquiryMap.put("address", address);
			}
			if (!(request.getParameter(STATE_ID).equals("0"))) {
				stateId = Integer.parseInt(request.getParameter(STATE_ID));
				enquiryMap.put("stateId", stateId);
			}
			if (request.getParameter("hinId") != null) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				enquiryMap.put("hinId", hinId);
			}
			if (request.getParameter(PATIENT_STATUS) != null
					&& !(request.getParameter(PATIENT_STATUS).equals(""))) {
				patientStatus = request.getParameter(PATIENT_STATUS);
				enquiryMap.put("patientStatus", patientStatus);
			}
			if (request.getParameter(POLICE_STATION) != null
					&& !(request.getParameter(POLICE_STATION).equals(""))) {
				policeStation = request.getParameter(POLICE_STATION);
				enquiryMap.put("policeStation", policeStation);
			}
			if (request.getParameter(MOBILE_NO) != null
					&& !(request.getParameter(MOBILE_NO).equals(""))) {
				mobileNo = request.getParameter(MOBILE_NO);
				enquiryMap.put("mobileNo", mobileNo);
			}
			if (request.getParameter(VILLAGE) != null
					&& !(request.getParameter(VILLAGE).equals(""))) {
				village = request.getParameter(VILLAGE);
				String villageCode = "";
				int index = village.lastIndexOf("[");
				villageCode = village.substring((index + 1),
						(village.length() - 1));
				village = villageCode;

				enquiryMap.put("village", village);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = enquiryHandlerService.getPatientDetailsForEnquiry(enquiryMap);
				
		map = enquiryHandlerService.getDetailsForEnquiry();

		String jsp = PATIENT_ENQUIRY_JSP;
		jsp += ".jsp";
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchDoctorForEnquiry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> enquiryMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String doctorName = "";
		int departmentId = 0;
		int hospitalId = 0;
		if (request.getParameter(DOCTOR_NAME) != null
				&& !request.getParameter(DOCTOR_NAME).equals("")) {
			doctorName = request.getParameter(DOCTOR_NAME);
			enquiryMap.put("doctorName", doctorName);
		}
		if (!request.getParameter(PATIENT_DEPARTMENT).equals("0")) {
			departmentId = Integer.parseInt(request
					.getParameter(PATIENT_DEPARTMENT));
			enquiryMap.put("departmentId", departmentId);
		}
	

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		enquiryMap.put("hospitalId", hospitalId);
		map = enquiryHandlerService.getDoctorList(enquiryMap);

		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		wardList = enquiryHandlerService.getWardList();
		map.put("wardList", wardList);

		String jsp = DOCTOR_ENQUIRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	// -----------------------------------------InPatient
	// Enquiry--------------------------------
	public ModelAndView searchInPatientForEnquiry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> enquiryMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();

		String serviceNo = "";
		String hinNo = "";
		String adNo = "";
		int serviceTypeId = 0;
		int rankId = 0;
		int unitId = 0;
		String serPersonName = "";
		String patientName = "";
		int hinId = 0;
		String address = "";
		int districtId = 0;
		int stateId = 0;
		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				enquiryMap.put("hinNo", hinNo);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				enquiryMap.put("adNo", adNo);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				enquiryMap.put("serviceNo", serviceNo);
			}
			if (!(request.getParameter(SERVICE_TYPE_ID).equals("0"))) {
				serviceTypeId = Integer.parseInt(request
						.getParameter(SERVICE_TYPE_ID));
				enquiryMap.put("serviceTypeId", serviceTypeId);
			}
			if (!(request.getParameter(RANK_ID).equals("0"))) {
				rankId = Integer.parseInt(request.getParameter(RANK_ID));
				enquiryMap.put("rankId", rankId);
			}
			if (!(request.getParameter(UNIT_ID).equals("0"))) {
				unitId = Integer.parseInt(request.getParameter(UNIT_ID));
				enquiryMap.put("unitId", unitId);
			}
			if (request.getParameter(SERVICE_PERSON_NAME) != null
					&& !(request.getParameter(SERVICE_PERSON_NAME).equals(""))) {
				serPersonName = request.getParameter(SERVICE_PERSON_NAME);
				enquiryMap.put("serPersonName", serPersonName);
			}
			if (request.getParameter(PATIENT_NAME) != null
					&& !(request.getParameter(PATIENT_NAME).equals(""))) {
				patientName = request.getParameter(PATIENT_NAME);
				enquiryMap.put("patientName", patientName);
			}
			if (request.getParameter(ADDRESS) != null
					&& !(request.getParameter(ADDRESS).equals(""))) {
				address = request.getParameter(ADDRESS);
				enquiryMap.put("address", address);
			}
			if (!(request.getParameter(DISTRICT_ID).equals("0"))) {
				districtId = Integer
						.parseInt(request.getParameter(DISTRICT_ID));
				enquiryMap.put("districtId", districtId);
			}
			if (!(request.getParameter(STATE_ID).equals("0"))) {
				stateId = Integer.parseInt(request.getParameter(STATE_ID));
				enquiryMap.put("stateId", stateId);
			}
			if (request.getParameter("hinId") != null) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				enquiryMap.put("hinId", hinId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = enquiryHandlerService
				.getInPatientDetailsForEnquiry(enquiryMap);
		map = enquiryHandlerService.getDetailsForEnquiry();

		String jsp = IN_PATIENT_ENQUIRY_JSP;
		jsp += ".jsp";
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPatientDetail(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		int patientHinId = 0;
		String patientIpd = "";
		String jsp = "";
		try
		{
			if (request.getParameter("patientHinId") != null) {
				patientHinId = Integer.parseInt(request.getParameter("patientHinId"));
			}
			if (request.getParameter("patientIpd") != null) {
				patientIpd = request.getParameter("patientIpd");
			}
			map = enquiryHandlerService.getPatientDetailsForFinalBill(patientHinId,patientIpd);

			String includedJsp = "ipPatientFinal"+".jsp";
			map.put("includedJsp", includedJsp);

			jsp = "ipPatientSearch"+".jsp";
			map.put("contentJsp", jsp);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchIP(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();

		String hinNo = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		String adNo = "";
		int inpatientId = 0;
		String policeStation = "";
		String villageCode = "";
		String village = "";
		int hospitalId=0;
		try {
			HttpSession session = request.getSession();

			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			mapForDs.put("hospitalId", hospitalId);
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(POLICE_STATION) != null
					&& !(request.getParameter(POLICE_STATION).equals(""))) {
				policeStation = request.getParameter(POLICE_STATION);
				mapForDs.put("policeStation", policeStation);
			}
			if (request.getParameter(VILLAGE) != null
					&& !(request.getParameter(VILLAGE).equals(""))) {
				village = request.getParameter(VILLAGE);

				int index = village.lastIndexOf("[");
				villageCode = village.substring((index + 1),
						(village.length() - 1));
				village = villageCode;


				mapForDs.put("village", village);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(P_MIDDLE_NAME) != null
					&& !(request.getParameter(P_MIDDLE_NAME).equals(""))) {
				patientMName = request.getParameter(P_MIDDLE_NAME);
				mapForDs.put("patientMName", patientMName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDs.put("patientLName", patientLName);
			}
			if (request.getParameter("inpatientId") != null) {
				inpatientId = Integer.parseInt(request
						.getParameter("inpatientId"));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter(WARD_ID) != null
					&& !request.getParameter(WARD_ID).equals("0")) {
				mapForDs.put("wardId",
						Integer.parseInt(request.getParameter(WARD_ID)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = enquiryHandlerService
				.getInPatientDetailsForEnquiry2(mapForDs);
		String jsp = "";
		map = enquiryHandlerService.getDetailsForEnquiry();
		jsp = "inPatientEnquiry" + ".jsp";

		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// -------Added by Vivek At Bangalore-------------

	public ModelAndView getAdVisitDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		String parentId = "";
		String detailId = "";
		int id = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("id") != null) {
			id = Integer.parseInt("" + request.getParameter("id"));
		}


		dataMap.put("id", id);
		map = enquiryHandlerService.getAdVisitDetails(dataMap);
		String jsp = RESPONCE_FOR_AD_VISIT;
		map.put("contentJsp", jsp);
		map.put("parentId", parentId);
		map.put("detailId", detailId);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getAllEnquiry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		String opOrString = "";
		String detailId = "";
		int id = 0;
		int hinId = 0;
		String adVisitNo=null;
		String empName="";
		HttpSession session=request.getSession();
		if(session.getAttribute("empName")!=null){
			empName=(String)session.getAttribute("empName");
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("opOrString") != null) {
			opOrString = ("" + request.getParameter("opOrString"));
		}
		if (request.getParameter("adVisitNo") != null) {
			adVisitNo = ("" + request.getParameter("adVisitNo"));
			dataMap.put("adVisitNo", adVisitNo);
		}
		if (request.getParameter("detailId") != null) {
			detailId = ("" + request.getParameter("detailId"));
		}
		if (request.getParameter("id") != null) {
			id = Integer.parseInt("" + request.getParameter("id"));
		}
		if (request.getParameter("hinId") != null) {
			hinId = Integer.parseInt("" + request.getParameter("hinId"));
		}
		int visitId =0;
		if (request.getParameter("visitId") != null) {
			visitId = Integer.parseInt( request.getParameter("visitId"));
		}
		int currentVisitId=0;
		if(request.getParameter("currentVisitId") != null){
			currentVisitId=Integer.parseInt(request.getParameter("currentVisitId"));
		}
 		dataMap.put("detailId", detailId);
		dataMap.put("opOrString", opOrString);
		dataMap.put("id", id);
		dataMap.put("visitId",  visitId);
		dataMap.put("hinId", hinId);
		dataMap.put("currentVisitId", currentVisitId);
		map = enquiryHandlerService.getAllEnquiry(dataMap);
		String jsp = "";
		if (detailId.equals("Diagnostics")) {
			jsp = "responseForOrderDetailsEnquiry";
		} else {
			jsp = RESPONCE_FOR_ALL_ENQUIRY;
		}
		map.put("contentJsp", jsp);
		map.put("opOrString", opOrString);
		map.put("detailId", detailId);
		map.put("empName",empName);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showPatientDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		int currentVisitId= 0;
		int episodeId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("hinNo") != null) {
			hinNo = request.getParameter("hinNo");
		}
		
		if (request.getParameter("visitId") != null) {
			currentVisitId = Integer.parseInt(request.getParameter("visitId"));
		}
		
		if (request.getParameter("episodeId") != null && !request.getParameter("episodeId").trim().equals("0")) {
			episodeId = Integer.parseInt(request.getParameter("episodeId"));
		}
		
		dataMap.put("hinNo", hinNo);
		dataMap.put("currentVisitId", currentVisitId);
		dataMap.put("episodeId", episodeId);
		map = enquiryHandlerService.showPatientDetails(dataMap);
		String historyPath=getServletContext().getRealPath("/uploadedImage/"+hinNo+".html"); 
		File fileName=new File(historyPath);
		if(fileName.exists()){ 
			map.put("historyUrl", "../uploadedImage/"+hinNo+".html");
		} 
		String jsp = PATIENT_DETAILS ;
		map.put("contentJsp", jsp);
		map.put("currentVisitId",currentVisitId);
		map.put("episodeId",episodeId);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView viewItemsForPrescription(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);
		map = enquiryHandlerService.getItemsForPrescription(box);
		String jsp = "responseForPrescriptionDetails";
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView	showPatientEpfJsp(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
				try{
				map = enquiryHandlerService.showPatientEpfJsp();
				}
				catch(Exception e){
					e.printStackTrace();
				}
				String hin_no = "";
				if (request.getParameter("hin_no") != null) {
					hin_no = request.getParameter("hin_no");
				}
				
				String jsp="showPatientEpfJsp";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				map.put("hin_no",hin_no);
				return new ModelAndView("index", "map", map);
	}
	 
	public ModelAndView	showExpiredPatientJsp(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
				try{
				map = enquiryHandlerService.showPatientEpfJsp();
				}
				catch(Exception e){
					e.printStackTrace();
				}
				String jsp="expiredPatient";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView printPatientEpfReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String query="";
		Date fromDate=new Date();
		Date toDate=new Date();
		///int  hin_no=0;
		String addEditDate=null;
		String addEditTime="";
		int ehrCount=0;
          Box box = HMSUtil.getBox(request);
		String hin_no="";
		int episodeId = 0;     //  added by amit das on 08-09-2016
        HttpSession session=request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String reportName="PATIENT_EPF1";
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		
		
		String patientDetailsStatus="";
		if(request.getParameter("patientDetailsStatus") != null){
			//hin_no = Integer.parseInt(request.getParameter("hin_no"));
			patientDetailsStatus =""+request.getParameter("patientDetailsStatus");
		}
		
		if(patientDetailsStatus.equalsIgnoreCase("y")){
			reportName="PATIENT_EPF1";
		}else if(patientDetailsStatus.equalsIgnoreCase("n")) {
			reportName="PATIENT_EPF2";
		}
		
		// added by amit das on 08-09-2016
		if(request.getParameter("episodeId") != null){
			episodeId =Integer.parseInt(request.getParameter("episodeId"));
		}
		
		
		if(request.getParameter("hin_no") != null){
			//hin_no = Integer.parseInt(request.getParameter("hin_no"));
			hin_no =""+request.getParameter("hin_no");
		}
		String  name="";
          synchronized (session) {
        	  name = (String) session.getAttribute("empName");
		if(name!=null){	
			box.put("name", name);
		}
		}
		if(request.getParameter("editDate") != null){
			addEditDate =request.getParameter("editDate");
			box.put("addEditDate", addEditDate);
		}
		
		if(request.getParameter("editTime") != null){
			addEditTime =""+request.getParameter("editTime");
			box.put("addEditTime", addEditTime);
		}
		
		
		if(request.getParameter("fromDate") != null){
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate") != null){
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("toDate"));
		}
		if(request.getParameter("flag")!=null && request.getParameter("flag").equals("ehr")){
			query = " and p.patient_status!='Expired'";
		}
		if(request.getParameter("flag")!=null && request.getParameter("flag").equals("exp")){
			
			query = " and p.patient_status like'Expired'";
		}
		System.out.println("query "+query);
		String address="";
		 map=enquiryHandlerService.showPaitentDetail(box);
		 ehrCount=Integer.parseInt((String) map.get("eherCount").toString());
		 PatientAddress patientAddress=(PatientAddress)map.get("patientAddress");
		 UploadDocuments uploadDocuments=(UploadDocuments)map.get("uploadDocument");
		
		//Changed by arbind on 13-01-2017
		if(patientAddress!=null){
			if("C".equalsIgnoreCase(patientAddress.getAddressType().getAddressTypeCode())){
				if(patientAddress.getHouseNo()!=null)
					address=patientAddress.getHouseNo()+"\n";
				if(patientAddress.getStreetRoad()!=null)
					address+=patientAddress.getStreetRoad()+"\n";
				if(patientAddress.getDistrict()!=null)
					address+=patientAddress.getDistrict().getDistrictName()+"\n";
				if(patientAddress.getTaluk()!=null && !patientAddress.getTaluk().equals("")){
					if(!patientAddress.getTaluk().getTalukName().equals(patientAddress.getDistrict().getDistrictName()))
						address+=patientAddress.getTaluk().getTalukName()+"\n";
				}
				if(patientAddress.getVillage()!=null){
					address+=patientAddress.getVillage().getVillageName()+"\n";
				}
				if(patientAddress.getPostOffice()!=null){
					address+=patientAddress.getPostOffice().getPostCodeName()+"\n";
				}
				if(patientAddress.getPinCode()!=null && !patientAddress.getPinCode().equals("")){
					address+=patientAddress.getPinCode().toString();
				}
			} 
		} 
		BufferedImage img=null;
		if(uploadDocuments!=null){
		 byte byteImg[]=uploadDocuments.getPatientDocument(); 
		 try { 	
			 img = ImageIO.read(new ByteArrayInputStream(byteImg));
		} catch (IOException e) {  
			e.printStackTrace();
		} 
		}
		//added by govind 8-12-2016
		List<PatientAddress> patientAddressList =new ArrayList<PatientAddress>();
		if(map.get("patientAddressList")!=null){
			patientAddressList=(List<PatientAddress>)map.get("patientAddressList");
		}
		String patAddress="";
		if(patientAddressList.size()>0){
			for(PatientAddress pa:patientAddressList){
				if(pa.getDistrict()!=null && !pa.getDistrict().equals("")){
					patAddress=pa.getDistrict().getDistrictName()+"\n";
				}
					if(pa.getTaluk()!=null && !pa.getTaluk().equals("")){
						if(!pa.getTaluk().getTalukName().equals(pa.getDistrict().getDistrictName())){
						patAddress=patAddress+pa.getTaluk().getTalukName()+"\n";
						}
					}
					if(pa.getVillage()!=null && !pa.getVillage().equals("")){
						patAddress=patAddress+pa.getVillage().getVillageName()+"\n";
					}
					if(pa.getPinCode()!=null && !pa.getPinCode().equals("")){
						patAddress=patAddress+pa.getPinCode().toString();
					}
				             
			}
		}
		System.out.println("Address "+address);
		parameters.put("patientAddress", patAddress);
		//added by govind 8-12-2016 end
		parameters.put("genCount", ehrCount);
		parameters.put("image", img);
		parameters.put("address", address);
		parameters.put("hin_no", hin_no);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("query", query);
		parameters.put("episodeId", episodeId); // added by amit das on 08-09-2016
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		parameters.put("hospitalId", hospitalId);
		parameters.put("IMAGE_DIR", getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT", getServletContext().getRealPath("/jsp/images/gok-logo.jpg"));

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = enquiryHandlerService.getConnectionForReport();
		
		
		HMSUtil.generateReport(reportName, parameters, (Connection)detailsMap.get("con"), response, getServletContext());
		return null;
		}
	
	public ModelAndView showWardWiseDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		int hospitalId=0;
		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		detailMap.put("hospitalId", hospitalId);
		map = enquiryHandlerService.showWardWiseDetails(detailMap);
		String jsp = WARD_WISE_PATIENT_POPUP_JSP;
		jsp += ".jsp";
		String title = "Ward Wise Patient Display";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(WARD_WISE_PATIENT_POPUP_JSP, "map", map);
	}
	public ModelAndView investigationResult(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		Map<String, Object> resultDetailsMap = new HashMap<String, Object>();
		List<Map<String, Object>> resultDetailsMapList = new ArrayList<Map<String, Object>>(); 
		String query = "";
		int srn = 0;
		String src = "";
		int id = 0;
		String crit = "";
		String deptName = "";
		int deptId = 0;
		Box box=HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		box.put("deptId", deptId); 
		map.put("chargeCodeId", box.get("chargeCodeId"));
		try {   
				detailsMap1 = enquiryHandlerService
						.investigationResult(box);

				map.put("detailsMap1", detailsMap1);
				map.put("deptName", deptName);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("investigationResultJspForOP", "map", map);
	}
	// -----------------------------------------------------------------------------------------------------------
	public EnquiryHandlerService getEnquiryHandlerService() {
		return enquiryHandlerService;
	}

	public void setEnquiryHandlerService(
			EnquiryHandlerService enquiryHandlerService) {
		this.enquiryHandlerService = enquiryHandlerService;
	}
	
	// -------------- EHF REPORT OPD ------------------
	public ModelAndView printPatientEpfReportOpd(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String query="";
		Date fromDate=new Date();
		Date toDate=new Date();
		String addEditDate=null;
		String addEditTime="";
		///int  hin_no=0;
		Box box = HMSUtil.getBox(request);
		String hin_no="";
		HttpSession session=request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String reportName="PATIENT_EPF1";
		System.out.println("hin_nohin_nohin_nohin_no "+request.getParameter("hinNo"));
		if(request.getParameter("hinNo") != null){
			//hin_no = Integer.parseInt(request.getParameter("hin_no"));
			hin_no =""+request.getParameter("hinNo");
			box.put("hin_no", hin_no);
		}
	
		Calendar now = Calendar.getInstance();
		String futureMonth =HMSUtil.getFutureMonth(now.get(Calendar.MONTH));
		
		if(request.getParameter("toDate") != null){
		fromDate = HMSUtil.convertStringTypeDateToDateType(futureMonth);
		}
		if(request.getParameter("toDate") != null){
		toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("toDate") );
		}
		if(request.getParameter("flag")!=null && request.getParameter("flag").equals("ehr")){
			query = " and p.patient_status!='Expired'";
		}
		if(request.getParameter("flag")!=null && request.getParameter("flag").equals("exp")){
			
			query = " and p.patient_status like'Expired'";
		}
		String address="";
		 map=enquiryHandlerService.showPaitentDetail(box);
		 
		 PatientAddress patientAddress=(PatientAddress)map.get("patientAddress");
		 UploadDocuments uploadDocuments=(UploadDocuments)map.get("uploadDocument");
		if(patientAddress!=null){
			if("P".equalsIgnoreCase(patientAddress.getAddressType().getAddressTypeCode())){
				address=patientAddress.getAddress();
				if(patientAddress.getVillage()!=null){
					address=","+patientAddress.getVillage().getVillageName();
				}if(patientAddress.getCity()!=null){
					address=","+patientAddress.getCity();
				}
				if(patientAddress.getDistrict()!=null){
					address=","+patientAddress.getDistrict().getDistrictName();
				}if(patientAddress.getState()!=null){
					address=","+patientAddress.getState().getStateName();
				}
		} 
		} 
		BufferedImage img=null;
		if(uploadDocuments!=null){
		 byte byteImg[]=uploadDocuments.getPatientDocument(); 
		 try { 	
			 img = ImageIO.read(new ByteArrayInputStream(byteImg));
		} catch (IOException e) {  
			e.printStackTrace();
		} 
		}
		
		parameters.put("image", img);
		parameters.put("address", address);
		parameters.put("hin_no", hin_no);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("query", query);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		parameters.put("IMAGE_DIR", getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT", getServletContext().getRealPath("/jsp/images/gok-logo.jpg"));

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = enquiryHandlerService.getConnectionForReport();
		HMSUtil.generateReport(reportName, parameters, (Connection)detailsMap.get("con"), response, getServletContext());
		return null;
		}
	
	public void saveClinicalObservation(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box=HMSUtil.getBox(request);
		
		boolean flag = false ;
		String message = "";
		map = enquiryHandlerService.saveClinicalObservation(box);
		if(map.get("flag") != null){
			flag = (Boolean)map.get("flag");
		}
		if(flag){
			message = "clinical Observation saved sucessfully.";
		}else{
			message = "Some Problem occured.";
		}
		
		StringBuffer sb = new StringBuffer();
		try {

				sb.append("<item>");
				
			    sb.append("<message>" +message+ "</message>");

	            sb.append("</item>");

		}catch (Exception e) {
					e.printStackTrace();
				}
		    response.setContentType("text/xml");
		    response.setHeader("Cache-Control", "no-cache");

		try{

			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//added by govind 16-11-2016
	public ModelAndView getPatientList(HttpServletRequest request,HttpServletResponse response) {
		String title = "";
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String hinNo = box.get("hin_no");
		List<Patient> patientList = enquiryHandlerService.getPatientList(hinNo);
		
		String jsp = "responseForPatient";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("patientList", patientList);
		return new ModelAndView(jsp, "map", map);
	}
	

}
