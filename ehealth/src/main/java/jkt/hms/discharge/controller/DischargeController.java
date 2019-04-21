/**
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Class DischargeController.java
 * To feed discharge summary details
 * Tables Used: discharge_items, discharge_items_category, discharge_summary
 * @author  Create Date: 11.02.2008  Name: Othivadivel K R
 * Revision Date:      		Revision By:
 * @version 1.0
 * @see DischargeHandlerService.java, DischargeHandlerServiceImpl.java, DischargeDataService.java, DischargeDataServiceImpl.java
 **/
package jkt.hms.discharge.controller;
import static jkt.hms.util.RequestConstants.ADMISSION_NUMBER;
import static jkt.hms.util.RequestConstants.CLINICAL_SHEET_REPORT_SCREEN;
import static jkt.hms.util.RequestConstants.DISCHARGE_DETAILS_INPUT_JSP;
import static jkt.hms.util.RequestConstants.DISCHARGE_FIELDS_DISPLAY_JSP;
import static jkt.hms.util.RequestConstants.DISCHARGE_SUMMARY_GENERAL_REPORT;
import static jkt.hms.util.RequestConstants.DISCHARGE_SUMMARY_GYNA_REPORT;
import static jkt.hms.util.RequestConstants.DISCHARGE_SUMMARY_PEDIA_REPORT;
import static jkt.hms.util.RequestConstants.DISCHARGE_SUMMARY_REPORT_SCREEN;
import static jkt.hms.util.RequestConstants.FILE_NAME;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.MESSAGE_FOR_DISCHARGE_SUMMARY;
import static jkt.hms.util.RequestConstants.OUTPUT_TO;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.USER_ID;

import java.sql.Connection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.discharge.handler.DischargeHandlerService;
import jkt.hms.ipd.handler.IPDHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class DischargeController extends MultiActionController {

	DischargeHandlerService dischargeHandlerService = null;
	IPDHandlerService ipdHandlerService = null;
	String jsp = "";
	String title = "";
	String userName = null;
	String message = null;
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = null;

	public ModelAndView showDischargeInputJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		int inPatient = 0;
		int hospitalId=0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("parent") != null
				&& request.getParameter("parent") != "") {
			inPatient = Integer.parseInt(request.getParameter("parent"));
		}
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		dataMap.put("inPatient", inPatient);
		dataMap.put(HOSPITAL_ID, hospitalId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map = dischargeHandlerService.getDischargePatientDetails(dataMap);
		jsp = DISCHARGE_DETAILS_INPUT_JSP;
		jsp += ".jsp";
		title = "Discharge Details Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView displayDischargeFields(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		if (request.getParameter("casetype") != null
				&& request.getParameter("casetype") != "") {
			requestParameters.put("casetype", request.getParameter("casetype"));
		}

		if (request.getParameter(ADMISSION_NUMBER) != null
				&& request.getParameter(ADMISSION_NUMBER) != "") {
			requestParameters.put(ADMISSION_NUMBER,
					request.getParameter(ADMISSION_NUMBER));
		}

		if (request.getParameter(HIN_ID) != null
				&& request.getParameter(HIN_ID) != "") {
			requestParameters.put(HIN_ID, request.getParameter(HIN_ID));
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& request.getParameter(INPATIENT_ID) != "") {
			requestParameters.put(INPATIENT_ID,
					request.getParameter(INPATIENT_ID));
		}
		String type="";
		if (request.getParameter("type") != null
				&& request.getParameter("type") != "") {
			requestParameters.put("type",
					request.getParameter("type"));
		}	
		requestParameters.put(HOSPITAL_ID, session.getAttribute("hospitalId"));

		Map<String, Object> map = new HashMap<String, Object>();
		map = dischargeHandlerService.getDischargeFields(requestParameters);
		jsp = DISCHARGE_FIELDS_DISPLAY_JSP;
		title = "Discharge Details Entry";
		if (request.getParameter(INPATIENT_ID) != null
				&& request.getParameter(INPATIENT_ID) != "") {
			map.put("parent",
					Integer.parseInt(request.getParameter(INPATIENT_ID)));
		}
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView addDischargeSummary(HttpServletRequest request,
			HttpServletResponse response) {
		Enumeration e = request.getParameterNames();
		Map<String, Object> requestDataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		int hospitalId=0;
		int userId=0;
		requestDataMap.put(HOSPITAL_ID, (Integer)session.getAttribute(HOSPITAL_ID));
		requestDataMap.put(USER_ID, (Integer)session.getAttribute(USER_ID));
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			String value = request.getParameter(key);
			requestDataMap.put(key, value);
		}
		String andNo = "";
		String hinNo = "";

		if (request.getParameter(ADMISSION_NUMBER) != null
				&& request.getParameter(ADMISSION_NUMBER) != "") {
			andNo = (request.getParameter(ADMISSION_NUMBER));
		}
		if (request.getParameter(HIN_NO) != null
				&& request.getParameter(HIN_NO) != "") {
			hinNo = (request.getParameter(HIN_NO));
		}
		if(requestDataMap!=null){
		map = dischargeHandlerService.addDischargeSummary(requestDataMap);
		}
		Set set = (Set) map.get("inpatientSet");
		// List list=(List) set;
		map.put("inPatientSet", set);
		jsp = MESSAGE_FOR_DISCHARGE_SUMMARY;
		jsp += ".jsp";
		title = "title";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("andNo", andNo);
		map.put(HIN_NO, hinNo);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPatientDischargeSummary(HttpServletRequest request,
			HttpServletResponse response) {
		jsp = DISCHARGE_SUMMARY_REPORT_SCREEN;
		jsp += ".jsp";
		title = "title";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("status", "fresh");
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showClinicalSheetReportScreen(
			HttpServletRequest request, HttpServletResponse response) {
		String adNo = "";
		String serviceNo = "";
		if (request.getParameter("parent") != null) {
			adNo = request.getParameter("parent");
		}
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		jsp = CLINICAL_SHEET_REPORT_SCREEN;
		jsp += ".jsp";
		title = "title";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("adNo", adNo);
		map.put("serviceNo", serviceNo);
		map.put("status", "fresh");
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showClinicalSheetReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String admissionNumber = null;
		String fileName = null;
		String serviceNo = null;
		String hinNo = null;
		String outputTo = null;
		String casetype = null;
		int hospitalId=0;
		session = request.getSession();
		
		try {
			if(session.getAttribute(HOSPITAL_ID)!=null)
			{
				hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
			}
			requestParameters.put(HOSPITAL_ID,hospitalId);
			if (request.getParameter(ADMISSION_NUMBER) != null
					&& !(request.getParameter(ADMISSION_NUMBER).equals(""))) {
				admissionNumber = request.getParameter(ADMISSION_NUMBER);
				requestParameters.put(ADMISSION_NUMBER, admissionNumber);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				requestParameters.put(SERVICE_NO, serviceNo);
			}

			if (request.getParameter("hinNo") != null
					&& !(request.getParameter("hinNo").equals(""))) {
				hinNo = request.getParameter("hinNo");
				requestParameters.put("hinNo", hinNo);
			}
			if (request.getParameter(FILE_NAME) != null
					&& !(request.getParameter(FILE_NAME).equals(""))) {
				fileName = request.getParameter(FILE_NAME) + ".pdf";
				requestParameters.put(FILE_NAME, fileName);
			}
			if (request.getParameter(OUTPUT_TO) != null
					&& !(request.getParameter(OUTPUT_TO).equals(""))) {
				outputTo = request.getParameter(OUTPUT_TO);
				requestParameters.put(OUTPUT_TO, outputTo);
			}

			if (request.getParameter("casetype") != null
					&& !(request.getParameter("casetype").equals(""))) {
				casetype = request.getParameter("casetype");
				requestParameters.put("casetype", casetype);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		parameters = dischargeHandlerService
				.getClinicalSheetReportDetails(requestParameters);
		if (parameters.get("hinNo") != null) {
			hinNo = ("" + parameters.get("hinNo"));
		}
		/*
		 * Parameters (ad_no and hospitalId) is used in the sql query which build in JASPER
		 * report Rest of the parameter values in the "parameter" map are used
		 * in Report Form
		 */
		parameters.put("ad_no", admissionNumber);
		parameters.put("hospitalId", hospitalId);
		parameters.put("hospital_id", hospitalId);
		parameters.put("PATH_TO_SUBREPORTS",getServletContext().getRealPath("/Reports/"));
//		if (parameters.get("status") != null) {
//			map.put("status", "nodata");
//			map.put("admissionNumber", admissionNumber);
//		} else {
			HMSUtil.generateReport("Clinical_Sheet_Report", parameters,
					(Connection) parameters.get("conn"), response,
					getServletContext());
//		}
		return null;
	}

	public ModelAndView showDischargeSummaryReport(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String admissionNumber = null;
		String fileName = null;
		String hinNo = null;
		String outputTo = null;
		String casetype = null;
		String reportName = "";
		String flag="";
		int hospitalId=0;
		session = request.getSession();
		if(session.getAttribute(HOSPITAL_ID)!=null)
		{
			hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		}
		requestParameters.put(HOSPITAL_ID, hospitalId);
		try {
			if (request.getParameter(ADMISSION_NUMBER) != null
					&& !(request.getParameter(ADMISSION_NUMBER).equals(""))) {
				admissionNumber = request.getParameter(ADMISSION_NUMBER);
				requestParameters.put(ADMISSION_NUMBER, admissionNumber);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				requestParameters.put(HIN_NO, hinNo);
			}else{
				hinNo=dischargeHandlerService.getHinNo(admissionNumber);
			}
			
		parameters = dischargeHandlerService
				.getDischargeSummaryReportDetails(requestParameters);
		if (request.getParameter("flag") != null
				&& !(request.getParameter("flag").equals(""))) {
			casetype=(String) parameters.get("casetype");
			if (casetype.equalsIgnoreCase("G")) {
				parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
				reportName = DISCHARGE_SUMMARY_GENERAL_REPORT;
			} else if (casetype.equalsIgnoreCase("O")) {
				parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
				reportName  = DISCHARGE_SUMMARY_GYNA_REPORT;
			} else if (casetype.equalsIgnoreCase("P")) {
				parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
				reportName= DISCHARGE_SUMMARY_PEDIA_REPORT;
		}
		}
		/*
		 * Following two parameters (hinNo, adNo) are used in the sql query
		 * which build in JASPER report Rest of the parameter values in the
		 * "parameter" map are used in Report Form
		 */
		if (parameters.get("casetype").toString().equalsIgnoreCase("G")) {
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
			reportName = DISCHARGE_SUMMARY_GENERAL_REPORT;
		} else if (parameters.get("casetype").toString().equalsIgnoreCase("O")) {
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
			reportName  = DISCHARGE_SUMMARY_GYNA_REPORT;
		} else if (parameters.get("casetype").toString().equalsIgnoreCase("P")) {
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
			reportName= DISCHARGE_SUMMARY_PEDIA_REPORT;
		} else {
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
			reportName = DISCHARGE_SUMMARY_GENERAL_REPORT;
			map.put("status", "nodata");
			map.put("admissionNumber", admissionNumber);
			map.put("hinNo", hinNo);
		}
		parameters.put("hinNo", hinNo);
		parameters.put("adNo", admissionNumber);
		parameters.put("hospitalId", hospitalId);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
	//	
		
		String flag1="1";
		if (request.getParameter("flag1") != null) {
			flag1 = request.getParameter("flag1");
		}

		if (flag1.equals("1"))
		{
			HMSUtil.generateReport(reportName, parameters,
					(Connection) parameters.get("conn"), response,
					getServletContext());
		}

		else if(flag1.equals("2")) {
					HMSUtil.generateHTMLReport(reportName, parameters,
							(Connection) parameters.get("conn"), response,
							getServletContext());
		}
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ModelAndView  showDischargeSummaryRepor2t(HttpServletRequest request,HttpServletResponse response) {
		String admissionNumber="";
		String hinNo="";
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		if (request.getParameter(ADMISSION_NUMBER) != null
				&& !(request.getParameter(ADMISSION_NUMBER).equals(""))) {
			admissionNumber = request.getParameter(ADMISSION_NUMBER);
			requestParameters.put(ADMISSION_NUMBER, admissionNumber);
		}
		hinNo=dischargeHandlerService.getHinNo(admissionNumber);
		int hospitalId=0;
		session = request.getSession();
		if(request.getParameter("hospitalId")!=null)
		{
			hospitalId=(Integer.parseInt(request.getParameter("hospitalId")));
		}
		requestParameters.put(HOSPITAL_ID, hospitalId);
		requestParameters.put(ADMISSION_NUMBER, admissionNumber);
		requestParameters.put(HIN_NO, hinNo);
		parameters = dischargeHandlerService
				.getDischargeSummaryReportDetails(requestParameters);
		parameters.put("hinNo", hinNo);
		parameters.put("adNo", admissionNumber);
		parameters.put("hospitalId", hospitalId);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		System.out.println(""+parameters);
		HMSUtil.generateReport(DISCHARGE_SUMMARY_GENERAL_REPORT, parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		
		//	
		return null;
	}
	public ModelAndView viewDischargeSummary(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String hinNo = "";
		String msg = "";
		String reportName = "";
		String casetype = "";
		String admissionNumber = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		try {
		if(request.getParameter("motherHinNo") != null){
			hinNo = request.getParameter("motherHinNo");
			box.put("hinNo", hinNo);
			requestParameters.put(HIN_NO, hinNo);
		}
		map = dischargeHandlerService.viewDischargeSummary(box);
		
		if(map.get("adNo") != null){
			admissionNumber = (String)map.get("adNo");
			requestParameters.put("admissionNumber", admissionNumber);
		}
		parameters = dischargeHandlerService.getDischargeSummaryReportDetails(requestParameters);
		if (request.getParameter("flag") != null
				&& !(request.getParameter("flag").equals(""))) {
			casetype=(String) parameters.get("casetype");
			if (casetype.equalsIgnoreCase("G")) {
				parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
				reportName = DISCHARGE_SUMMARY_GENERAL_REPORT;
			} else if (casetype.equalsIgnoreCase("O")) {
				parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
				reportName  = DISCHARGE_SUMMARY_GYNA_REPORT;
			} else if (casetype.equalsIgnoreCase("P")) {
				parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
				reportName= DISCHARGE_SUMMARY_PEDIA_REPORT;
		}
		}
		/*
		 * Following two parameters (hinNo, adNo) are used in the sql query
		 * which build in JASPER report Rest of the parameter values in the
		 * "parameter" map are used in Report Form
		 */
		if (parameters.get("casetype").toString().equalsIgnoreCase("G")) {
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
			reportName = DISCHARGE_SUMMARY_GENERAL_REPORT;
		} else if (parameters.get("casetype").toString().equalsIgnoreCase("O")) {
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
			reportName  = DISCHARGE_SUMMARY_GYNA_REPORT;
		} else if (parameters.get("casetype").toString().equalsIgnoreCase("P")) {
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
			reportName= DISCHARGE_SUMMARY_PEDIA_REPORT;
		} else {
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
			reportName = DISCHARGE_SUMMARY_GENERAL_REPORT;
			map.put("status", "nodata");
			map.put("admissionNumber", admissionNumber);
			map.put("hinNo", hinNo);
		}
		parameters.put("hinNo", hinNo);
		parameters.put("adNo", admissionNumber);
		parameters.put("hospitalId", hospitalId);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
	//	
		HMSUtil.generateReport(reportName, parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	

	public ModelAndView getAdmissionNumberList(HttpServletRequest request,
			HttpServletResponse response) {
		String hinNo = null;
		String flag="";
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		session = request.getSession(false);
		requestParameters.put(HOSPITAL_ID, session.getAttribute("hospitalId"));

		if (request.getParameter(HIN_NO) != null && request.getParameter(HIN_NO) != "") {
			hinNo = request.getParameter(HIN_NO);
			requestParameters.put("hinNo", hinNo);
		}
		if (request.getParameter("flag") != null && request.getParameter("flag") != "") {
			flag = request.getParameter("flag");
			
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map = dischargeHandlerService.getAdmissionNumberList(requestParameters);
		jsp = "admissionNumberPopulate";
		map.put("flag", flag);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showPatientSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();

		if (request.getParameter("serviceNo") != null
				&& request.getParameter("serviceNo") != "") {
			requestParameters.put("serviceNo",
					request.getParameter("serviceNo"));
		}

		if (request.getParameter("serviceType") != null
				&& request.getParameter("serviceType") != "") {
			requestParameters.put("serviceType",
					request.getParameter("serviceType"));
		}

		if (request.getParameter("rank") != null
				&& request.getParameter("rank") != "") {
			requestParameters.put("rank", request.getParameter("rank"));
		}

		if (request.getParameter("unit") != null
				&& request.getParameter("unit") != "") {
			requestParameters.put("unit", request.getParameter("unit"));
		}

		if (request.getParameter("patientName") != null
				&& request.getParameter("patientName") != "") {
			requestParameters.put("patientName",
					request.getParameter("patientName"));
		}

		if (request.getParameter("servicePersonnelName") != null
				&& request.getParameter("servicePersonnelName") != "") {
			requestParameters.put("servicePersonnelName",
					request.getParameter("servicePersonnelName"));
		}

		if (request.getParameter("SearchFlag") != null
				&& request.getParameter("SearchFlag") != "") {
			requestParameters.put("SearchFlag",
					request.getParameter("SearchFlag"));
		}
		if (request.getParameter("adNo") != null
				&& request.getParameter("adNo") != "") {
			requestParameters.put("adNo", request.getParameter("adNo"));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		requestParameters.put("deptId", deptId);
		map = dischargeHandlerService
				.getSearchPatientComboDetails(requestParameters);
		jsp = "Discharge_Patient_Search";
		title = "Patient Search Screen";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}
	public void getDischargeSummaryDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();

		if (request.getParameter("inpatientId") != null
				&& request.getParameter("inpatientId") != "") {
			requestParameters.put("inpatientId",
					request.getParameter("inpatientId"));
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map = dischargeHandlerService.getDischargeFields(requestParameters);
		String diagnosis = "";
		String investigations = "";
		String history = "";
		if (map.get("DIAG")!=null)
			diagnosis = map.get("DIAG").toString();

		if (map.get("HIST")!=null)
			history = map.get("HIST").toString();

		if (map.get("INVS")!=null)
			investigations = map.get("INVS").toString();

		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<item>");
			sb.append("<diagnosis>" + diagnosis + "</diagnosis>");
			sb.append("<history>" + history + "</history>");
			sb.append("<investigations>" + investigations + "</investigations>");
			sb.append("</item>");

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");

		} catch (Exception e) {
			e.printStackTrace();
		}


	}
	public void setDischargeHandlerService(
			DischargeHandlerService dischargeHandlerService) {
		this.dischargeHandlerService = dischargeHandlerService;
	}
//---By dipali----09/nov--
	public ModelAndView getAdmissionNumberList1(HttpServletRequest request,
			HttpServletResponse response) {
		String hinNo = null;
		Map<String, Object> detailmap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		detailmap.put(HOSPITAL_ID, session.getAttribute("hospitalId"));
		if (request.getParameter(HIN_NO) != null&& request.getParameter(HIN_NO) != "") {
			hinNo = request.getParameter(HIN_NO);
		}
		detailmap.put("hinNo", hinNo);
		Map<String, Object> map = new HashMap<String, Object>();
		map = dischargeHandlerService.getAdmissionNumberList1(detailmap);
		jsp = "admissionNumberPopulate";
		map.put("hinNo", hinNo);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}
	
	
	
	/*public ModelAndView showDischargeSummaryJsp(HttpServletRequest request,HttpServletResponse response) {
		jsp = "dischargeSlipjsp";
		jsp += ".jsp";
//		title = "Pending Acknowledge List";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}*/
}
