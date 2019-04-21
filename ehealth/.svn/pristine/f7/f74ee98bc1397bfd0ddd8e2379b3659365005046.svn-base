/**
 * Copyright 2008 JK Technosoft Ltd. All rights reserved..
 * Use is subject to license terms.
 * ADTController.java � java
 * Purpose of the class - This is the Admission, Discharge & Transfer Module of ADT.
 * It contains Admission, Attached Admission, Medico Legal Case Admission, Transfer & Discharge of the patient.
 * @author  Deepti Tevatia
 * @author  Ritu Sahu
 * Create Date: 3rd Jan,2008
 * Revision Date:
 * Revision By: Purpose
 * @version 1.0
 **/

package jkt.hms.adt.controller;

import static jkt.hms.util.RequestConstants.*;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.account.handler.AccountHandlerService;
import jkt.hms.adt.handler.ADTHandlerService;
import jkt.hms.billing.handler.BillingHandlerService;
import jkt.hms.billing.handler.OpBillingHandlerService;
import jkt.hms.masters.business.AttachInpatient;
import jkt.hms.masters.business.DialysisSchudeling;
import jkt.hms.masters.business.Discharge;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.ExpiryDetails;
import jkt.hms.masters.business.HospitalDoctorUnitM;
import jkt.hms.masters.business.HospitalDoctorUnitT;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasAdmissionType;
import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasCareType;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDischargeStatus;
import jkt.hms.masters.business.MasDisposal;
import jkt.hms.masters.business.MasDisposedTo;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasIcd;
import jkt.hms.masters.business.MasLsg;
import jkt.hms.masters.business.MasPostCode;
import jkt.hms.masters.business.MasScheme;
import jkt.hms.masters.business.MasTaluk;
import jkt.hms.masters.business.MasWard;
import jkt.hms.masters.business.MlcCase;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientAddress;
import jkt.hms.masters.business.PhMasLocality;
import jkt.hms.masters.business.Transfer;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import net.sf.jasperreports.engine.JRException;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ADTController extends MultiActionController {
	/*
	 * Logger Implemented By Mukesh Narayan Singh Date 18 Aug 2010
	 */

	static final Logger LOGGER = Logger.getLogger(ADTController.class);

	ADTHandlerService adtHandlerService = null;
	OpBillingHandlerService opBillingHandlerService = null;
	AccountHandlerService accountHandlerService = null;
	BillingHandlerService billingHandlerService = null;
	/*
	 * Code for read from property file from src package
	 */
	Properties properties = new Properties();
	{
		try {
			ClassLoader loader = getClass().getClassLoader();
			InputStream inStream = loader.getResourceAsStream("commonReportFile.properties");
			properties.load(inStream);
		} catch (IOException ioException) {
			LOGGER.error("Error while loading  commonReportFile.properties" + ioException.getStackTrace().toString());
		}
	}
	String jsp = "";
	public static int count = 0;

	public ModelAndView showAdmissionJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showAdmissionJsp ");
		HttpSession session = request.getSession();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		int hospitalId = 0;
		String hinIdMother = "";
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		mapForDs.put("hospitalId", hospitalId);
		String hinNo = request.getParameter(HIN_NO);
		String patientFName = request.getParameter(P_FIRST_NAME);
		String mobileNo = request.getParameter(MOBILE_NO);
		String doctorId = request.getParameter(DOCTOR_NAME);
		String departmentId = request.getParameter(DEPARTMENT_ID);
		String admDepartmentId = request.getParameter("admdepartment");
		try {
			
			if (hinNo != null && !(hinNo.equals(""))) {
				mapForDs.put("hinNo", hinNo);
			}

			
			if (patientFName != null && !(patientFName.equals(""))) {
				mapForDs.put("patientFName", patientFName);
			}

			
			if (mobileNo != null && !(mobileNo.equals(""))) {
				mapForDs.put("mobileNo", mobileNo);
			}

			
			if (doctorId != null && !(doctorId.equals(""))) {
				mapForDs.put("doctorId", Integer.parseInt(doctorId));
			}

			
			if (departmentId != null && !(departmentId.equals(""))) {
				mapForDs.put("departmentId", Integer.parseInt(departmentId));
			}

			
			if (admDepartmentId != null && !(admDepartmentId.equals(""))) {
				mapForDs.put("admDepartmentId", Integer.parseInt(admDepartmentId));
			}

			String flag = request.getParameter("flag");
			if (flag != null) {
				mapForDs.put("flag", flag);
			}

			String babyHin = request.getParameter("babyHin");
			if (babyHin != null) {
				mapForDs.put("babyHin", babyHin);
			}

			if (request.getParameter("hinIdMother") != null) {
				hinIdMother = request.getParameter("hinIdMother");
				mapForDs.put("hinIdMother", hinIdMother);
			}

		
			
		} catch (Exception e) {
			LOGGER.error("Exception occured in showAdmissionJsp : " + e.getStackTrace().toString());
		}
		Map<String, Object> map = adtHandlerService.getDetailsForPatientAdission(mapForDs);
		map.put(HIN_NO,hinNo);
		map.put(P_FIRST_NAME,patientFName);
		map.put(MOBILE_NO,mobileNo);
		map.put(DOCTOR_NAME,doctorId);
		map.put(DEPARTMENT_ID,departmentId);
		map.put("admDepartmentId",admDepartmentId);
		map.put("contentJsp", PATIENT_ADMISSION_SEARCH_JSP);
		map.put("hinIdMother", hinIdMother);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showIpAdmissionDetailJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showIpAdmissionDetailJsp ");
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		String hinNo = "";
		String patientFName = "";
		String mobileNo = "";
		String ipNumber = "";
		int doctorId = 0;
		int hospitalId = 0;
		int departmentId = 0;
		String hinIdMother = "";
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		try {
			if (request.getParameter(HIN_NO) != null && !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(P_FIRST_NAME) != null && !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(MOBILE_NO) != null && !(request.getParameter(MOBILE_NO).equals(""))) {
				mobileNo = request.getParameter(MOBILE_NO);
				mapForDs.put("mobileNo", mobileNo);
			}

			if (request.getParameter("IPNumber") != null && !(request.getParameter("IPNumber").equals(""))) {
				ipNumber = request.getParameter("IPNumber");
				mapForDs.put("ipNumber", ipNumber);
			}
			if (request.getParameter(DOCTOR_NAME) != null && !(request.getParameter(DOCTOR_NAME).equals(""))) {
				doctorId = Integer.parseInt(request.getParameter(DOCTOR_NAME));
				mapForDs.put("doctorId", doctorId);
			}

			mapForDs.put("hospitalId", hospitalId);

			if (request.getParameter("department") != null && !(request.getParameter("department").equals(""))) {
				departmentId = Integer.parseInt(request.getParameter("department"));
				mapForDs.put("departmentId", departmentId);
			}
			int admDepartmentId = 0;
			if (request.getParameter("admdepartment") != null && !(request.getParameter("admdepartment").equals(""))) {
				admDepartmentId = Integer.parseInt(request.getParameter("admdepartment"));
				mapForDs.put("admDepartmentId", admDepartmentId);
			}
			String flag = "";
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
				mapForDs.put("flag", flag);
			}
			String babyHin = "";
			if (request.getParameter("babyHin") != null) {
				babyHin = request.getParameter("babyHin");
				mapForDs.put("babyHin", babyHin);
			}

			if (request.getParameter("hinIdMother") != null) {
				hinIdMother = request.getParameter("hinIdMother");
				mapForDs.put("hinIdMother", hinIdMother);
			}

		} catch (Exception e) {
			LOGGER.error("Error occurred : " + e.getStackTrace().toString());
		}
		map = adtHandlerService.getAdmissionPatientDetail(mapForDs);
		jsp = PATIENT_ADMISSION_VIEW_JSP + ".jsp";
		map.put("contentJsp", jsp);
		map.put("hinIdMother", hinIdMother);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientDetailsForAdmission(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside searchPatientDetailsForAdmission ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int hinId = 0;
		int hospitalId = 0;
		int deptId = 0;
		String hinIdMother = "";
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		try {

			if (request.getParameter("hinId") != null) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				mapForDs.put("hinId", hinId);
			}
			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}
			if (hospitalId != 0) {
				mapForDs.put("hospitalId", hospitalId);
			}
			String flag = request.getParameter("flag");
			if (flag != null) {
				mapForDs.put("flag", flag);
			}
			if (request.getParameter("hinIdMother") != null) {
				hinIdMother = request.getParameter("hinIdMother");
				mapForDs.put("hinIdMother", hinIdMother);
			}

		} catch (Exception e) {
			LOGGER.error("Error occurred : " + e.getStackTrace().toString());
		}

		Map<String, Object> patientMap = adtHandlerService.getDetailsForPatientAdission(mapForDs);
		String jsp = "";
		String message = "";
		List<OpdPatientDetails> patientList = new ArrayList<OpdPatientDetails>();
		List<Patient> patientBabyList = new ArrayList<Patient>();
		List<DialysisSchudeling> dialysisSchedulingList = new ArrayList<DialysisSchudeling>();
		if (patientMap.get("patientList") != null) {
			patientList = (List<OpdPatientDetails>) patientMap.get("patientList");
		}
		if (patientMap.get("dialysisSchedulingList") != null) {
			dialysisSchedulingList = (List<DialysisSchudeling>) patientMap.get("dialysisSchedulingList");
		}

		if (patientMap.get("patientBabyList") != null) {
			patientBabyList = (List<Patient>) patientMap.get("patientBabyList");
		}
		List<Patient> ipPatientList = new ArrayList<Patient>();
		if (patientMap.get("ipPatientList") != null) {
			ipPatientList = (List<Patient>) patientMap.get("ipPatientList");
		}
		if (ipPatientList.size() > 0 && hinId != 0) {
			Map<String, Object> ipDataMap = new HashMap<String, Object>();
			ipDataMap.put("ipPatientList", ipPatientList);
			for (Patient patient : ipPatientList) {
				LOGGER.debug(" ipPatientList " + ipPatientList.size());
				if (patient.getPatientStatus().equals("Out Patient")) {
					ipDataMap.put("hinNo", patient.getHinNo());
					ipDataMap.put("hinId", hinId);
					ipDataMap.put("hospitalId", hospitalId);
					ipDataMap.put("deptId", deptId);
					ipDataMap.put("hinIdMother", hinIdMother);
					int chargeSlipNo = billingHandlerService.getChargeSlipNo("display", hospitalId);
					detailsMap = adtHandlerService.getAdmissionDetails(ipDataMap);
					detailsMap.put("ipPatientList", ipPatientList);
					jsp = ADMISSION_BY_HIN_NO_JSP;
					map.put("chargeSlipNo", chargeSlipNo);
				}
			}
		}
		if (patientList.size() > 0 && hinId != 0) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("patientList", patientList);
			for (OpdPatientDetails patient : patientList) {
				if (patient.getVisit().getHin().getPatientStatus().equals("Out Patient")) {
					dataMap.put("hinNo", patient.getVisit().getHin().getHinNo());
					dataMap.put("hinId", hinId);
					dataMap.put("hospitalId", hospitalId);
					dataMap.put("deptId", deptId);
					dataMap.put("hinIdMother", hinIdMother);
					int chargeSlipNo = billingHandlerService.getChargeSlipNo("display", hospitalId);
					detailsMap = adtHandlerService.getAdmissionDetails(dataMap);
					jsp = ADMISSION_BY_HIN_NO_JSP;
					map.put("chargeSlipNo", chargeSlipNo);
				} else {
					map = adtHandlerService.getDetailsForPatientAdission(mapForDs);
					message = "Patient already admitted";
					map.put("message", message);
					jsp = PATIENT_ADMISSION_SEARCH_JSP;
				}
			}

		} else if (patientBabyList.size() > 0) {
			for (Patient p : patientBabyList) {

				if (p.getPatientStatus().equals("In Patient")) {
					Map<String, Object> dataMap = new HashMap<String, Object>();

					dataMap.put("hinNo", p.getHinNo());
					dataMap.put("hinId", hinId);
					dataMap.put("hospitalId", hospitalId);
					dataMap.put("deptId", deptId);

					int chargeSlipNo = 0;
					chargeSlipNo = billingHandlerService.getChargeSlipNo("display", hospitalId);
					dataMap.put("hinIdMother", hinIdMother);
					detailsMap = adtHandlerService.getAdmissionDetails(dataMap);
					jsp = ADMISSION_BY_HIN_NO_JSP;
					map.put("chargeSlipNo", chargeSlipNo);
					map.put("patientBabyList", patientBabyList);
				}
			}
		} else if (dialysisSchedulingList.size() > 0) {
			for (DialysisSchudeling dialysisSchudeling : dialysisSchedulingList) {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				dataMap.put("hinNo", dialysisSchudeling.getHin().getHinNo());
				dataMap.put("hinId", dialysisSchudeling.getHin().getId());
				dataMap.put("hospitalId", hospitalId);
				dataMap.put("deptId", deptId);
				int chargeSlipNo = 0;

				dataMap.put("hinIdMother", hinIdMother);
				chargeSlipNo = billingHandlerService.getChargeSlipNo("display", hospitalId);

				detailsMap = adtHandlerService.getAdmissionDetails(dataMap);
				jsp = ADMISSION_BY_HIN_NO_JSP;
				map.put("chargeSlipNo", chargeSlipNo);
				map.put("dialysisSchedulingList", dialysisSchedulingList);
			}
		} else {
			map = adtHandlerService.getDetailsForSearch();
			jsp = PATIENT_ADMISSION_SEARCH_JSP;
		}

		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchIPPatientViewAndUpdate(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside searchIPPatientViewAndUpdate ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int InpId = 0;
		int hospitalId = 0;
		String hinIdMother = "";
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		try {
			LOGGER.debug("request.getParameter()" + request.getParameter("InpId"));
			if (request.getParameter("InpId") != null) {
				InpId = Integer.parseInt(request.getParameter("InpId"));
				mapForDs.put("InpId", InpId);
			}
			if (hospitalId != 0) {
				mapForDs.put("hospitalId", hospitalId);
			}
			String flag = "";
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
				mapForDs.put("flag", flag);
			}
			if (request.getParameter("hinIdMother") != null) {
				hinIdMother = request.getParameter("hinIdMother");
				mapForDs.put("hinIdMother", hinIdMother);
			}

		} catch (Exception e) {
			LOGGER.error("Error occurred : " + e.getStackTrace().toString());
		}

		patientMap = adtHandlerService.getDetailIpPatientView(mapForDs);
		LOGGER.debug("......ffffffffff.........." + patientMap.size());
		// patientMap =
		// adtHandlerService.getDetailsForPatientAdission(mapForDs);
		String jsp = "";
		jsp = IP_PATIENT_VIEW_AND_UPDATE + ".jsp";

		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public void getChargeCodeDetails(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside getChargeCodeDetails ");
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		StringBuffer sb = new StringBuffer();
		int chargeTypeId = 0;
		if (request.getParameter("chargeTypeId") != null) {

			chargeTypeId = Integer.parseInt(request.getParameter("chargeTypeId"));
		}
		map = adtHandlerService.getChargeCodeDetails(chargeTypeId);
		if (map.get("chargeCodeList") != null) {
			chargeCodeList = (List<MasChargeCode>) map.get("chargeCodeList");
		}
		try {
			for (MasChargeCode masChargeCode : chargeCodeList) {

				sb.append("<item>");
				sb.append("<id>" + masChargeCode.getId() + "</id>");
				sb.append("<chargeName>" + masChargeCode.getChargeCodeName() + "</chargeName>");

				sb.append("</item>");
			}
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			LOGGER.error("Error occurred : " + e.getStackTrace().toString());
		}
	}

	/*
	 * Fetching the Patient Details, NOK Details, and Registration details from
	 * admission screen and admit the registered patient into the hospital by
	 * saving the data.
	 */

	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	public ModelAndView submitAdmissionInformation(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside submitAdmissionInformation ");
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int hinId = 0;
		String adNo = "";
		String remarks = "";
		int patientTypeId = 0;
		int patientCategoryId = 0;
		int hospitalId = 0;

		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Properties properties1 = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		try {
			properties1.load(resourcePath.openStream());
		} catch (IOException e) {
			LOGGER.error("IOException occurred while loading adt.properties file : " + e.getStackTrace().toString());
		}

		String conditionNormal = properties1.getProperty("conditionNormal");
		String conditionDead = properties1.getProperty("conditionDead");
		String conditionCritical = properties1.getProperty("conditionCritical");

		Inpatient inpatient = new Inpatient();
		if (request.getParameter(HIN_ID) != null && !request.getParameter(HIN_ID).equals("0")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			Patient patientObj = new Patient();
			patientObj.setId(hinId);
			inpatient.setHin(patientObj);

		}

		int patienthinId = 0;
		if (request.getParameter("patienthinId") != null && !request.getParameter("patienthinId").equals("")) {
			patienthinId = Integer.parseInt(request.getParameter("patienthinId"));

		}
		LOGGER.debug("patienthinId   patienthinId patienthinId    " + patienthinId);

		Map<String, Object> patientMap = new HashMap<String, Object>();
		String opdpatientdetail = request.getParameter("opdpatientdetail");
		if (opdpatientdetail != null && !opdpatientdetail.equals("0") && !opdpatientdetail.equals("")) {
			patientMap.put("opdpatientdetailId", Integer.parseInt(opdpatientdetail));
		}

		Map<String, Object> admissionMap = new HashMap<String, Object>();
		String admittingDoctorDept = request.getParameter("admittingDoctorDept");
		if (admittingDoctorDept != null && !admittingDoctorDept.equals("0")) {
			admissionMap.put("admittingDeptId", Integer.parseInt(admittingDoctorDept));
		}

		String consultingDoctor = request.getParameter("consultingDoctor");
		if (consultingDoctor != null && !consultingDoctor.equals("0")) {
			admissionMap.put("admittingDoctorId", Integer.parseInt(consultingDoctor));
		}

		String monthlyIncome = request.getParameter("monthlyIncome");
		if (monthlyIncome != null && !monthlyIncome.equals("")) {
			admissionMap.put("patient_income", monthlyIncome);
		}

		// ------Checking for AD no Duplicate----------
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Inpatient> ipList = new ArrayList<Inpatient>();
		dataMap.put("hinId", hinId);
		Map<String, Object> ipMap = adtHandlerService.checkAdNoDuplication(dataMap);

		if (ipMap.get("inpatientList") != null) {
			ipList = (List<Inpatient>) ipMap.get("inpatientList");
		}
		LOGGER.debug("ipList---" + ipList.size());
		if (ipList.size() > 0) {

			for (Inpatient inpatient2 : ipList) {
				adNo = inpatient2.getAdNo();
			}
			map.put("adNo", adNo);
			String ipNo = properties.getProperty("com.jkt.hms.ipd_no");
			String msg = "Patient has been admitted successfully with '" + ipNo + " " + adNo
					+ "'.Do you want to print IP Admission slip? ";
			map.put("message", msg);

			jsp = MESSAGE_FOR_ADT_JSP + ".jsp";
			map.put("message", msg);
			map.put("patienthinId", patienthinId);
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}

		// ---------------------------------------------
		MasHospital masHospital = new MasHospital();
		if (session.getAttribute(HOSPITAL_ID) != "0") {
			masHospital.setId(hospitalId);
			inpatient.setHospital(masHospital);

		}

		int consultingDoctorId = 0;
		MasEmployee masEmployee = new MasEmployee();
		if (request.getParameter(CONSULTING_DOCTOR) != null && !request.getParameter(CONSULTING_DOCTOR).equals("0")) {
			consultingDoctorId = Integer.parseInt(request.getParameter(CONSULTING_DOCTOR));
			masEmployee.setId(consultingDoctorId);
			inpatient.setDoctor(masEmployee);
		}
		/*
		 * Added By Ujjwal For MRD No.
		 */
		String mrdNo = "";

		String bplStatus = request.getParameter("bplStatus");
		if (bplStatus != null && !bplStatus.equals("")) {
			patientMap.put("bplStatus", bplStatus);
		}

		if (request.getParameter("patientTypeId") != null && !request.getParameter("patientTypeId").equals("")
				&& !request.getParameter("patientTypeId").equals("0")) {
			patientTypeId = Integer.parseInt(request.getParameter("patientTypeId"));
			patientMap.put("patientTypeId", patientTypeId);
		}

		if (request.getParameter("otherCategoryId") != null) {
			patientMap.put("patientCategoryId", request.getParameterValues("otherCategoryId"));
		}

		// --------------------CHECK IT ONCE

		String admissionTypeId = request.getParameter(ADMISSION_TYPE_ID);
		if (!admissionTypeId.equals("0")) {
			MasAdmissionType admissionType = new MasAdmissionType();
			admissionType.setId(Integer.parseInt(admissionTypeId));
			inpatient.setAdmissionType(admissionType);
		}

		String dateOfAdmission = request.getParameter(DATE_OF_ADMISSION);
		if (dateOfAdmission != null) {
			inpatient.setDateOfAddmission(HMSUtil.convertStringTypeDateToDateType(dateOfAdmission));
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String date4MySQL = "";
			try {
				date4MySQL = formatterOut.format(formatterIn.parse(dateOfAdmission));
			} catch (ParseException e) {
				LOGGER.error("ParseException Occured while parseing date of admission : "
						+ e.getStackTrace().toString());
			}
			admissionMap.put("doa", date4MySQL);

		}

		Map<String, Object> utilMap = (Map) HMSUtil.getCurrentDateAndTime();

		String timeOfAdmission = request.getParameter(TIME_OF_ADMISSION);
		if (timeOfAdmission != null) {
			inpatient.setTimeOfAddmission(timeOfAdmission);
			admissionMap.put("toa", timeOfAdmission);
		} else {
			String currentTime = (String) utilMap.get("currentTime");
			inpatient.setTimeOfAddmission(currentTime);

		}
		if (request.getParameter(REMARKS) != null) {
			remarks = "" + request.getParameter(REMARKS);
			inpatient.setRemarks(remarks);
		}

		String departmentId = request.getParameter(DEPARTMENT_ID);
		if (!departmentId.equals("0")) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(Integer.parseInt(departmentId));
			inpatient.setDepartment(masDepartment);
			inpatient.setAdWard(masDepartment);
		}

		// Added by Amit Das on 23-02-2016
		String schemeList = request.getParameter("schemeList");
		if (schemeList != null && !schemeList.equals("0")) {
			MasScheme masScheme = new MasScheme();
			masScheme.setId(Integer.parseInt(schemeList));
			inpatient.setScheme(masScheme);
		}

		String relativeName = request.getParameter(RELATIVE_NAME);
		if (relativeName != null && !relativeName.equals("")) {
			patientMap.put(RELATIVE_NAME, relativeName);
		}

		String relativeAddress = request.getParameter(ADDRESS);
		if (relativeAddress != null && !relativeAddress.equals("")) {
			patientMap.put(ADDRESS, relativeAddress);
		}

		String relativeMobile = request.getParameter(MOBILE);
		if (relativeMobile != null && !relativeMobile.equals("")) {
			patientMap.put(MOBILE, relativeMobile);
		}

		String relativerelation = request.getParameter(RELATION_ID);
		if (relativerelation != null && !relativerelation.equals("")) {
			patientMap.put(RELATION_ID, Integer.parseInt(relativerelation));
		}

		String hospitalUnitId = request.getParameter("hospitalUnitId");
		if (hospitalUnitId != null && !hospitalUnitId.equals("")) {
			HospitalDoctorUnitM hospitalDoctorUnitM = new HospitalDoctorUnitM();
			hospitalDoctorUnitM.setId(Integer.parseInt(hospitalUnitId));
			inpatient.setUnitM(hospitalDoctorUnitM);
		}

		String motherUHID = request.getParameter("motherUHID");
		if (motherUHID != null && !motherUHID.equals("")) {
			inpatient.setMotherAdNo(motherUHID);
		}

		String mlc = request.getParameter(MLC);
		if (mlc != null && !mlc.equals("")) {
			inpatient.setMlc("y");
		} else {
			inpatient.setMlc("n");
		}

		String condition = request.getParameter(CONDITION);
		if (condition != null && !condition.equals("")) {
			inpatient.setCriticalCondition("y");
		} else {
			inpatient.setCriticalCondition("n");
		}

		// added by arbind on 10-02-2017
		String cashReceivedStatus = "n";
		if (null != request.getParameter("cashreceived") && request.getParameter("cashreceived").equals("y")) {
			cashReceivedStatus = request.getParameter("cashreceived");
		}
		inpatient.setCashReceivedStatus(cashReceivedStatus);

		String cashNotReceivedReason = request.getParameter("cashReason");
		if (null != cashNotReceivedReason && !cashNotReceivedReason.equals("")) {
			inpatient.setCashNotReceivedReason(cashNotReceivedReason);
			LOGGER.debug("cashNotReceivedReason inside -->" + cashNotReceivedReason);
		}
		// added by arbind on 10-02-2017 end
		String hinNo = request.getParameter(HIN_NO);
		if (hinNo != null && !hinNo.equals("")) {
			inpatient.setHinNo(hinNo);
		}

		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		Users userObj = new Users();
		userObj.setId(userId);
		inpatient.setAddEditBy(userObj);
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		inpatient.setStatus("y");
		inpatient.setAdStatus("W");
		inpatient.setAttachedPatient("n");
		String dialysisSchudelingId = request.getParameter("dialysisSchudelingId");
		if (dialysisSchudelingId != null) {
			admissionMap.put("dialysisSchudelingId", Integer.parseInt(dialysisSchudelingId));
		}

		Map<String, Object> adMap = new HashMap<String, Object>();
		adMap.put("date", date);
		adMap.put("hospitalId", hospitalId);
		adNo = adtHandlerService.generateAdNumber(adMap);
		if (adNo != null) {
			inpatient.setAdNo(adNo);
			inpatient.setAdNoType("a");
		}

		admissionMap.put("patientTypeId", patientTypeId);

		Date addEditDate = new Date();
		String[] diagnosidIdArray = null;
		Patient patient = new Patient();
		Map<String, Object> billingDetailsMap = new HashMap<String, Object>();
		billingDetailsMap.put("changedBy", request.getParameter(CHANGED_BY));
		admissionMap.put("patient", patient);
		admissionMap.put("inpatient", inpatient);
		admissionMap.put("hinId", hinId);
		admissionMap.put("patientMap", patientMap);
		admissionMap.put("diagnosidIdArray", diagnosidIdArray);
		admissionMap.put("addEditTime", (String) utilMap.get("currentTime"));
		admissionMap.put("addEditDate", addEditDate);
		admissionMap.put("userId", userId);
		admissionMap.put("adNo", adNo);
		admissionMap.put("departmentId", departmentId);
		admissionMap.put("consultingDoctorId", consultingDoctorId);
		admissionMap.put("hospitalId", hospitalId);
		String message = "";
		Map<String, Object> mapTemp = new HashMap<String, Object>();
		
		if (!adNo.equalsIgnoreCase("NO")) {
			// added by govind 29-8-2016
			LOGGER.debug("calling  code submitpatient");
			int perAddId = 0;

			PatientAddress permenentAddress = new PatientAddress();
			String permanentDistrict = request.getParameter("permanentDistrict");
			if (permanentDistrict != null && !permanentDistrict.equals("") && !permanentDistrict.equals("0")) {
				MasDistrict masDistrict = new MasDistrict();
				masDistrict.setId(Integer.parseInt(permanentDistrict));
				permenentAddress.setDistrict(masDistrict);
			}
			String pTaluk = request.getParameter("pTaluk");
			if (pTaluk != null && !pTaluk.equals("") && !pTaluk.equals("0")) {
				MasTaluk masTaluk = new MasTaluk();
				masTaluk.setId(Integer.parseInt(pTaluk));
				permenentAddress.setTaluk(masTaluk);

			}
			String pLsgName = request.getParameter("pLsgName");
			if (pLsgName != null && !pLsgName.equals(" ") && !pLsgName.equals("0")) {
				MasLsg masLsg = new MasLsg();
				masLsg.setId(Integer.parseInt(pLsgName));
				permenentAddress.setLsgName(masLsg);
			}
			String pWard = request.getParameter("pWard");
			if (pWard != null && !pWard.equals("") && !pWard.equals("0")) {
				MasWard masWard = new MasWard();
				masWard.setId(Integer.parseInt(pWard));
				permenentAddress.setWardNo(masWard);
			}
			String pLocality = request.getParameter("pLocality");
			if (pLocality != null && !pLocality.equals("") && !pLocality.equals("0")) {
				PhMasLocality phMasLocality = new PhMasLocality();
				phMasLocality.setId(Integer.parseInt(pLocality));
				permenentAddress.setLocality(phMasLocality);
			}
			String pLsgHouseNo = request.getParameter("pLsgHouseNo");
			if (pLsgHouseNo != null && !pLsgHouseNo.equals("")) {
				permenentAddress.setLsgHouseNo(pLsgHouseNo);
			}
			String pPostOffice = request.getParameter("pPostOffice");
			if (pPostOffice != null && !pPostOffice.equals("") && !pPostOffice.equals("0")) {
				MasPostCode masPostCode = new MasPostCode();
				masPostCode.setId(Integer.parseInt(pPostOffice));
				permenentAddress.setPostOffice(masPostCode);
			}
			String aPinCode = request.getParameter("aPinCode");
			if (aPinCode != null && !aPinCode.equals("")) {
				permenentAddress.setPinCode(Long.parseLong(aPinCode));
			}
			String pHealthHouseId = request.getParameter("pHealthHouseId");
			if (pHealthHouseId != null && !pHealthHouseId.equals("")) {
				permenentAddress.setHealthHouseId(pHealthHouseId);
			}
			if (request.getParameter("perAddId") != null && !request.getParameter("perAddId").equals("")) {
				perAddId = Integer.parseInt(request.getParameter("perAddId"));
				permenentAddress.setId(perAddId);
			}
			admissionMap.put("permenentAddress", permenentAddress);
			admissionMap.put("perAddId", perAddId);
			// added by govind 29-8-2016 end
			mapTemp = adtHandlerService.submitAdmissionInformation(admissionMap);
		}

		List<Inpatient> inpatientList = (List<Inpatient>) mapTemp.get("inpatientList");
		String admissionFlag = "" + mapTemp.get("admissionFlag");
		String ipNo = properties.getProperty("com.jkt.hms.ipd_no");
		if (admissionFlag.equals("true")) {
			map.put("adNo", adNo);
			ipNo = properties.getProperty("com.jkt.hms.ipd_no");
			String msg = "Patient has been admitted successfully with '" + ipNo + " " + adNo
					+ "'.Do you want to print IP Admission slip? ";
			map.put("message", msg);
			jsp = MESSAGE_FOR_ADT_JSP + ".jsp";
		} else {
			if (adNo.equalsIgnoreCase("NO"))
				message = "Some Error Has occured While Generating  " + ipNo + ".";
			else
				message = "Some Error Has occured.";
			jsp = MESSAGE_FOR_ADT_JSP + ".jsp";
			map.put("message", message);
			map.put("hinId", hinId);
		}
		map.put("patienthinId", patienthinId);
		String backUrl = "/hms/hms/adt?method=showAdmissionJsp";
		map.put("backUrl", backUrl);
		map.put("dateOfAdmission", dateOfAdmission);

		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printIPAdmissionSlip(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside printIPAdmissionSlip ");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String adNo = "";
		if (request.getParameter("adNo") != null) {
			adNo = request.getParameter("adNo");
		}
		detailsMap = adtHandlerService.getConnectionForReport();
		parameters.put("adNo", adNo);
		HMSUtil.generateReport("IPAdmissionSlip", parameters, (Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView getMotherName(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside getMotherName ");
		Map<String, Object> map = new HashMap<String, Object>();
		String motherAdNo = request.getParameter("motherAd");
		String motherName = adtHandlerService.getMotherName(motherAdNo);
		if (motherName.equals("")) {
			motherName = "No Records Matched!";
		}
		String jsp = AJAX_MESSAGE_JSP;
		String message = motherName;
		map.put("message", message);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView saveAttachedAdmission(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside saveAttachedAdmission ");
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> attachMap = new HashMap<String, Object>();
		String attachName = "";
		String age = "";
		String dietType = "";
		String attachTime = "";
		String adNo = "";
		int sexId = 0;
		int dietId = 0;
		int relationId = 0;
		int wardId = 0;
		int hinId = 0;
		int hospitalId = 0;
		String atOrDt = "";
		AttachInpatient attachInpatient = new AttachInpatient();
		String parentAdNo = "" + box.get("parentAdNo");
		HttpSession session = request.getSession();
		try {
			if (session.getAttribute(HOSPITAL_ID) != "0") {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				attachInpatient.setHospital(masHospital);
			}
			if (request.getParameter(NAME_OF_ATTACH) != null) {
				attachName = request.getParameter(NAME_OF_ATTACH);
				attachInpatient.setNameOfAttached(attachName.toUpperCase(Locale.ENGLISH));
			}
			String ageUnit = "";
			if (request.getParameter(AGE) != null) {
				age = request.getParameter(AGE);
				if (request.getParameter(AGE_UNIT) != null) {
					ageUnit = request.getParameter(AGE_UNIT);
				}
				age = age + " " + ageUnit;
				attachInpatient.setAge(age);
				attachMap.put("age", age);
			}
			if (request.getParameter(DIET_TYPE) != null) {
				dietType = request.getParameter(DIET_TYPE);
				attachInpatient.setDietType(dietType);
			}
			if (!request.getParameter(HIN_ID).equals("0")) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				attachMap.put("hinId", hinId);
			}
			if (!request.getParameter(DIET_ID).equals("0")) {
				dietId = Integer.parseInt(request.getParameter(DIET_ID));
				attachMap.put("dietId", dietId);
			}
			if (!request.getParameter(SEX_ID).equals("0")) {
				sexId = Integer.parseInt(request.getParameter(SEX_ID));
				attachMap.put("sexId", sexId);
			}
			if (!request.getParameter(RELATION_ID).equals("0")) {
				relationId = Integer.parseInt(request.getParameter(RELATION_ID));
				attachMap.put("relationId", relationId);
			}
			if (!request.getParameter(DEPARTMENT_ID).equals("0")) {
				wardId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
				attachMap.put("wardId", wardId);
			}
			if (request.getParameter(BED_ID) != null && !request.getParameter(BED_ID).equals("")) {
				int bedId = Integer.parseInt(request.getParameter(BED_ID));
				MasBed bed = new MasBed();
				bed.setId(bedId);
				attachInpatient.setBed(bed);
				attachMap.put("bedId", bedId);
			}
			if (!request.getParameter(DIET_ID).equals("0")) {
				dietId = Integer.parseInt(request.getParameter(DIET_ID));
				attachMap.put("dietId", dietId);
			}
			if (request.getParameter(CHANGED_DATE) != null) {
				attachInpatient.setAttachDate(HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(CHANGED_DATE)));
			}
			if (request.getParameter(CHANGED_TIME) != null) {
				attachTime = request.getParameter(CHANGED_TIME);
				attachInpatient.setAttachTime(attachTime);
			}
			if (request.getParameter(AT_OR_DT) != null) {
				atOrDt = request.getParameter(AT_OR_DT);
			}

			Users user = (Users) session.getAttribute("users");
			int userId = user.getId();
			Users userObj = new Users();
			userObj.setId(userId);
			attachInpatient.setAddEditBy(userObj);

			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");

			attachInpatient.setAttachDate(HMSUtil.convertStringTypeDateToDateType(date));
			attachInpatient.setAttachTime(time);
			attachInpatient.setStatus("y");

			Map<String, Object> adMap = new HashMap<String, Object>();
			adMap.put("date", date);
			if (adNo != null) {
				attachInpatient.setAdNo(adNo);
			}
			attachMap.put("attachInpatient", attachInpatient);
			attachMap.put("hospitalId", hospitalId);
			attachMap.put("attachName", attachName);
			attachMap.put("box", box);
			attachMap.put("parentAdNo", parentAdNo);
			attachMap.put("atOrDt", atOrDt);
			Map<String, Object> tempMap = new HashMap<String, Object>();
			String attachFlag = "";
			attachMap.put("wardId", wardId);
			tempMap = adtHandlerService.saveAttachedAdmission(attachMap);
			attachFlag = "" + tempMap.get("attachFlag");
			adNo = "" + tempMap.get("adNo");
			String message = "";
			String ipno = "";
			ipno = properties.getProperty("com.jkt.hms.ipd_no");
			if (attachFlag.equals("true")) {
				message = "Attach Patient has been submitted successfully with " + ipno + " " + adNo + "'";
			} else {
				message = "Some Error has occured";
			}
			map.put("message", message);
			jsp = MESSAGE_FOR_ADT_JSP + ".jsp";

		} catch (Exception e) {
			LOGGER.error("Error occurred : " + e.getStackTrace().toString());
		}
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showMedicoLegalCaseDetails(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showMedicoLegalCaseDetails ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mlcMap = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		String flag = "";
		String mlcNo = "";
		int visitNo = 0;
		String hin = "";
		String adNo = "";
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		parameterMap.put("date", date);

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			map.put("flag", flag);
		}
		if (request.getParameter(VISIT_NUMBER) != null) {
			visitNo = Integer.parseInt(request.getParameter(VISIT_NUMBER));
			map.put("visitNo", visitNo);
		}
		if (request.getParameter(HIN_NO) != null) {
			hin = request.getParameter(HIN_NO);
			parameterMap.put("hinNo", hin);
		}
		if (request.getParameter(AD_NO) != null) {
			adNo = request.getParameter(AD_NO);
			parameterMap.put("adNo", adNo);
		}
		patientMap = adtHandlerService.getPatientDetails(parameterMap);

		mlcMap = adtHandlerService.getDetailsForMLC(hospitalId);

		mlcNo = adtHandlerService.generateMLCNo(parameterMap);
		map.put("mlcNo", mlcNo);
		map.put("adNo", adNo);
		jsp = MEDICO_LEGAL_CASE_JSP + ".jsp";
		map.put("patientMap", patientMap);
		map.put("detailsMap", mlcMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView submitMLCDetails(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside submitMLCDetails ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mlcDetailsMap = new HashMap<String, Object>();
		MlcCase mlcCase = new MlcCase();
		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		String mlcNo = "";
		int injuryNatureId = 0;
		int doctorId = 0;
		int bodyPartId = 0;
		int hinId = 0;
		int inpId = 0;
		int visitNo = 0;
		int visitId = 0;
		String injuryType = "";
		String injuryDimension = "";
		String injuryDetails = "";
		String firNo = "";
		String policeOfficer = "";
		String policeStation = "";
		String statement = "";
		String broughtBy = "";
		String patientCondition = "";
		String weaponUsed = "";
		String incidentTime = "";
		String incidentPlace = "";
		String typeAndNoOfVehicle = "";
		String nameAndAddressOfDriver = "";
		String adNo = "";
		String remarks = "";
		String mlcTime = "";
		String natureOfMlc = "";
		String severityOfInjury = "";

		if (session.getAttribute(HOSPITAL_ID) != "0" && session.getAttribute(HOSPITAL_ID) != null) {
			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			mlcCase.setHospital(masHospital);
		}

		if (request.getParameter("inpId") != null && !request.getParameter("inpId").equals("0")) {
			inpId = Integer.parseInt(request.getParameter("inpId"));
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpId);
			mlcCase.setInpatient(inpatient);
		}

		if (request.getParameter("visitId") != null && !request.getParameter("visitId").equals("0")) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
			Visit visit = new Visit();
			visit.setId(visitId);
			mlcCase.setVisit(visit);
		}
		if (!request.getParameter(HIN_ID).equals("0")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			mlcDetailsMap.put("hinId", hinId);
		}
		if (request.getParameter(MLC_NO) != null) {
			mlcNo = request.getParameter(MLC_NO);
			mlcCase.setMlcNo(mlcNo);
		}
		if (request.getParameter(AD_NO) != null) {
			adNo = request.getParameter(AD_NO);
			mlcCase.setAdNo(adNo);
		}
		if (request.getParameter(VISIT_NUMBER) != null && !request.getParameter(VISIT_NUMBER).equals("0")) {
			visitNo = Integer.parseInt(request.getParameter(VISIT_NUMBER));
			mlcCase.setVisitNo(visitNo);
		}
		if (request.getParameter(MLC_DATE) != null) {
			mlcCase.setMlcDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(MLC_DATE)));
		}
		if (request.getParameter(MLC_TIME) != null) {
			mlcTime = request.getParameter(MLC_TIME);
			mlcCase.setMlcTime(mlcTime);
		}
		if (request.getParameter(NATURE_OF_MLC) != null) {
			natureOfMlc = request.getParameter(NATURE_OF_MLC);
			mlcCase.setNatureOfMlc(natureOfMlc);
		}
		if (request.getParameter(INJURY_TYPE) != null) {
			injuryType = request.getParameter(INJURY_TYPE);
			mlcCase.setInjuryType(injuryType);
		}
		if (request.getParameter(SEVERITY_OF_INJURY) != null) {
			severityOfInjury = request.getParameter(SEVERITY_OF_INJURY);
			mlcCase.setSeverityOfInjury(severityOfInjury);
		}
		if (request.getParameter(INJURY_DIMENSION) != null) {
			injuryDimension = request.getParameter(INJURY_DIMENSION);
			mlcCase.setInjuryDimension(injuryDimension);
		}
		if (!request.getParameter(INJURY_NATURE_ID).equals("0")) {
			injuryNatureId = Integer.parseInt(request.getParameter(INJURY_NATURE_ID));
			mlcDetailsMap.put("injuryNatureId", injuryNatureId);
		}
		if (request.getParameter(INJURY_DETAILS) != null) {
			injuryDetails = request.getParameter(INJURY_DETAILS);
			mlcCase.setInjuryDetails(injuryDetails);
		}
		if (request.getParameter(FIR_NO) != null) {
			firNo = request.getParameter(FIR_NO);
			mlcCase.setFirNo(firNo);
		}
		if (request.getParameter(POLICE_OFFICER) != null) {
			policeOfficer = request.getParameter(POLICE_OFFICER);
			mlcCase.setPoliceOfficer(policeOfficer);
		}
		if (request.getParameter(POLICE_STATION) != null) {
			policeStation = request.getParameter(POLICE_STATION);
			mlcCase.setPoliceStation(policeStation);
		}
		if (request.getParameter(STATEMENT) != null) {
			statement = request.getParameter(STATEMENT);
			mlcCase.setStatement(statement);
		}
		if (request.getParameter(BROUGHT_BY) != null) {
			broughtBy = request.getParameter(BROUGHT_BY);
			mlcCase.setBroughtBy(broughtBy);
		}
		String addressBroughtBy = "";
		if (request.getParameter(ADDRESS_OF_BROUGHT_BY) != null) {
			addressBroughtBy = request.getParameter(ADDRESS_OF_BROUGHT_BY);
			mlcCase.setBroughtByAddr(addressBroughtBy);
		}
		if (request.getParameter(CONDITION) != null) {
			patientCondition = request.getParameter(CONDITION);
			mlcCase.setPatientCondition(patientCondition);
		}
		if (request.getParameter(WEAPON_USED) != null) {
			weaponUsed = request.getParameter(WEAPON_USED);
			mlcCase.setWeaponUsed(weaponUsed);
		}
		if (request.getParameter(CONDITION) != null) {
			patientCondition = request.getParameter(CONDITION);
			mlcCase.setPatientCondition(patientCondition);
		}
		if (request.getParameter(INCIDENCE_DATE) != null) {
			mlcCase.setIncidentDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(INCIDENCE_DATE)));
		}
		if (request.getParameter(INCIDENCE_TIME) != null) {
			incidentTime = request.getParameter(INCIDENCE_TIME);
			mlcCase.setIncidentTime(incidentTime);
		}
		if (request.getParameter(INCIDENCE_PLACE) != null) {
			incidentPlace = request.getParameter(INCIDENCE_PLACE);
			mlcCase.setIncidentPlace(incidentPlace);
		}
		if (request.getParameter(TYPE_AND_NO_OF_VEHICLE) != null) {
			typeAndNoOfVehicle = request.getParameter(TYPE_AND_NO_OF_VEHICLE);
			mlcCase.setTypeAndNoOfVehicle(typeAndNoOfVehicle);
		}
		if (request.getParameter(NAME_AND_ADDR_OF_DRIVER) != null) {
			nameAndAddressOfDriver = request.getParameter(NAME_AND_ADDR_OF_DRIVER);
			mlcCase.setNameAndAddressOfDriver(nameAndAddressOfDriver);
		}
		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
			mlcCase.setRemarks(remarks);
		}
		if (!request.getParameter(CONSULTING_DOCTOR).equals("0")) {
			doctorId = Integer.parseInt(request.getParameter(CONSULTING_DOCTOR));
			mlcDetailsMap.put("doctorId", doctorId);
		}
		if (!request.getParameter(BODY_PART_ID).equals("0")) {
			bodyPartId = Integer.parseInt(request.getParameter(BODY_PART_ID));
			mlcDetailsMap.put("bodyPartId", bodyPartId);
		}
		if (request.getParameter(MLC_TIME) != null) {
			MasDepartment department = new MasDepartment();
			department.setId(deptId);
			mlcCase.setDepartment(department);
		}
		if (request.getParameter("patientRelation") != null) {
			mlcCase.setPatientRelation(request.getParameter("patientRelation"));

		}
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		Users userObj = new Users();
		userObj.setId(userId);
		mlcCase.setAddEditBy(userObj);

		if (request.getParameter(CHANGED_DATE) != null) {
			Date addEditDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
			mlcCase.setAddEditDate(addEditDate);
		}
		if (request.getParameter(CHANGED_TIME) != null) {
			String addEditTime = request.getParameter(CHANGED_TIME);
			mlcCase.setAddEditTime(addEditTime);
		}
		mlcCase.setStatus("y");

		mlcDetailsMap.put("mlcCase", mlcCase);
		mlcDetailsMap.put("adNo", adNo);

		boolean mlcFlag = adtHandlerService.submitMLCDetails(mlcDetailsMap);
		String message = "";
		if (mlcFlag == true) {
			if (request.getParameter("flag").equals("ipMlc")) {
				message = "MLC Information has been added successfully";

			} else if (request.getParameter("flag").equals("opMlc")) {
				message = "MLC Information has been added successfully.";
			}
		} else {
			message = "Some Error Occurred. ";

		}
		jsp = MESSAGE_FOR_ADT_JSP + ".jsp";
		map.put("adNo", adNo);
		map.put("tempFlag", "yes");
		map.put("message", message);
		map.put("contentJsp", jsp);
		//
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView showTransferJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showTransferJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		map = adtHandlerService.getDetailsForSearch();

		jsp = PATIENT_TRANSFER_SEARCH_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientDetailsForTransfer(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside searchPatientDetailsForTransfer ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		String hinNo = "";
		int wardId = 0;
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		String adNo = "";
		int inpatientId = 0;
		int hospitalId = 0;
		int deptId = 0;

		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			deptId = (Integer) session.getAttribute(DEPT_ID);
		}

		try {
			if (request.getParameter(AD_NO) != null && !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(HIN_NO) != null && !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(WARD_ID) != null && !(request.getParameter(WARD_ID).equals("0"))) {
				wardId = Integer.parseInt(request.getParameter(WARD_ID));
				mapForDs.put("wardId", wardId);
			}
			if (request.getParameter(P_FIRST_NAME) != null && !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(P_MIDDLE_NAME) != null && !(request.getParameter(P_MIDDLE_NAME).equals(""))) {
				patientMName = request.getParameter(P_MIDDLE_NAME);
				mapForDs.put("patientMName", patientMName);
			}
			if (request.getParameter(P_LAST_NAME) != null && !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDs.put("patientLName", patientLName);
			}
			if (request.getParameter("inpatientId") != null) {
				inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (hospitalId > 0) {
				mapForDs.put("hospitalId", hospitalId);
			}
		} catch (Exception e) {
			LOGGER.error("Error occurred : " + e.getStackTrace().toString());
		}
		patientMap = adtHandlerService.getPatientDetailsForTransfer(mapForDs);
		String jsp = "";
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();

		if (patientMap.get("inpatientList") != null) {
			inpatientList = (List<Inpatient>) patientMap.get("inpatientList");
		}
		if ((!adNo.equals("") && inpatientList.size() > 0) || inpatientId != 0) {
			detailsMap = adtHandlerService.getTransferDetails(hospitalId, deptId, inpatientId);
			jsp = TRANSFER_BY_HIN_NO_JSP + ".jsp";
		} else {
			map = adtHandlerService.getDetailsForSearch();
			jsp = PATIENT_TRANSFER_SEARCH_JSP + ".jsp";
		}

		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitTransferInformation(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside submitTransferInformation ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> transferMap = new HashMap<String, Object>();
		int hinId = 0;
		int fromWardId = 0;
		int toWardId = 0;
		int fromBedId = 0;
		int toBedId = 0;
		int authorizerId = 0;
		boolean transferedSuccessfully = false;

		HttpSession session = request.getSession();
		String message = "";
		String adNo = "";
		Integer inpatientID = 0;
		if (request.getParameter(HIN_ID) != null) {

			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			transferMap.put(HIN_ID, hinId);
		}
		if (request.getParameter(AD_NO) != null) {
			adNo = request.getParameter(AD_NO);
			transferMap.put(AD_NO, adNo);
		}

		if (request.getParameter(INPATIENT_ID) != null) {
			inpatientID = Integer.parseInt(request.getParameter(INPATIENT_ID));
			transferMap.put(INPATIENT_ID, inpatientID);
		}

		if (request.getParameter(FROM_WARD) != null) {
			fromWardId = Integer.parseInt(request.getParameter(FROM_WARD));
			transferMap.put(FROM_WARD, fromWardId);
		}
		if (request.getParameter(TO_WARD) != null && !request.getParameter(TO_WARD).equals("0")) {
			toWardId = Integer.parseInt(request.getParameter(TO_WARD));
			transferMap.put(TO_WARD, toWardId);
		}
		if (request.getParameter(FROM_BED) != null) {
			fromBedId = Integer.parseInt(request.getParameter(FROM_BED));
			transferMap.put(FROM_BED, fromBedId);
		}
		if (request.getParameter(BED_ID) != null && !request.getParameter(BED_ID).equals("0")
				&& !request.getParameter(BED_ID).equals("")) {
			toBedId = Integer.parseInt(request.getParameter(BED_ID));
			transferMap.put(BED_ID, toBedId);
		}
		if (request.getParameter(TRANSFER_DATE) != null) {
			transferMap
					.put(TRANSFER_DATE, HMSUtil.convertStringTypeDateToDateType(request.getParameter(TRANSFER_DATE)));
		}
		if (request.getParameter(TRANSFER_TIME) != null) {
			transferMap.put(TRANSFER_TIME, request.getParameter(TRANSFER_TIME));
		}
		if (request.getParameter(AUTHORIZER_ID) != null && !request.getParameter(AUTHORIZER_ID).equals("0")) {

			authorizerId = Integer.parseInt(request.getParameter(AUTHORIZER_ID));
			transferMap.put(AUTHORIZER_ID, authorizerId);
		}

		if (session.getAttribute(USER_ID) != null) {
			transferMap.put(USER_ID, (Integer) session.getAttribute(USER_ID));
		}

		if (session.getAttribute(HOSPITAL_ID) != null) {
			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			transferMap.put(HOSPITAL_ID, hospitalId);
		}

		transferMap.put("transferType", request.getParameter("transferType"));
		transferMap.put("reason", request.getParameter("reason"));

		transferMap.put(AD_NO, adNo);
		transferMap.put(FROM_BED, fromBedId);
		transferMap.put(TO_BED, toBedId);
		transferMap.put(TO_WARD, toWardId);

		transferedSuccessfully = adtHandlerService.submitTransferInformation(transferMap);

		if (transferedSuccessfully) {
			message = " Transfer has been completed Successfully.";

		} else {
			message = "Some problem Occured! Try Again.";
		}

		String backUrl = "";
		backUrl = "/hms/hms/adt?method=showTransferJsp";
		map.put("backUrl", backUrl);

		jsp = MESSAGE_FOR_ADT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		//
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showDischargeJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showDischargeJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		map = adtHandlerService.getDetailsForSearch();
		jsp = PATIENT_DISCHARGE_SEARCH_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPatientDetailsForDischargeWard(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside searchPatientDetailsForDischargeWard ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientDiagnosisMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int inpatientId = 0;
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		try {

			if (request.getParameter("inpatientId") != null) {
				inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
			}
		} catch (Exception e) {
			LOGGER.error("Error occurred : " + e.getStackTrace().toString());
		}

		patientMap = adtHandlerService.getPatientDetailsForDischargeForWard(inpatientId);
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		if (patientMap.get("inpatientList") != null) {
			inpatientList = (List<Inpatient>) patientMap.get("inpatientList");
		}

		String jsp = "";
		String adNo = "";
		for (Inpatient ip : inpatientList) {
			adNo = ip.getAdNo();
		}

		if (inpatientId != 0) {

			detailsMap = adtHandlerService.getDischargeDetails(hospitalId, inpatientId);

			patientDiagnosisMap = adtHandlerService.getPatientDiagnosis(adNo, inpatientId);

			map.put("patientDiagnosisMap", patientDiagnosisMap);
			map.put("inpatientList", inpatientList);
			jsp = DISCHARGE_BY_HIN_NO_JSP + ".jsp";
		}
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		//
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientDetailsForDischarge(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside searchPatientDetailsForDischarge ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		String hinNo = "";
		int wardId = 0;
		String adNo = "";
		int inpatientId = 0;
		int hospitalId = 0;

		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		try {

			if (request.getParameter(AD_NO) != null && !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(HIN_NO) != null && !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(WARD_ID) != null && !(request.getParameter(WARD_ID).equals("0"))) {
				wardId = Integer.parseInt(request.getParameter(WARD_ID));
				mapForDs.put("wardId", wardId);
			}
			if (request.getParameter("inpatientId") != null) {
				inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (hospitalId > 0) {
				mapForDs.put("hospitalId", hospitalId);
			}
		} catch (Exception e) {
			LOGGER.error("Error occurred : " + e.getStackTrace().toString());
		}
		patientMap = adtHandlerService.getPatientDetailsForDischarge(mapForDs);

		String jsp = "";
		String message = "";
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();

		if (patientMap.get("inpatientList") != null) {
			inpatientList = (List<Inpatient>) patientMap.get("inpatientList");
		}
		if ((!adNo.equals("") && inpatientList.size() > 0) || inpatientId != 0) {
			map = adtHandlerService.getDetailsForSearch();
			map.put("message", message);
			jsp = PATIENT_DISCHARGE_SEARCH_JSP + ".jsp";
		} else {
			message = "Discharge Summary of patient is not prepared.Please first prepare discharge summary.";
			map = adtHandlerService.getDetailsForSearch();
			jsp = PATIENT_DISCHARGE_SEARCH_JSP + ".jsp";
		}

		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitDischargeInformation(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside submitDischargeInformation ");
		Map<String, Object> map = new HashMap<String, Object>();
		Discharge discharge = new Discharge();
		HttpSession httpSession = request.getSession();
		int hospitalId = (Integer) httpSession.getAttribute(HOSPITAL_ID);
		int deptId = (Integer) httpSession.getAttribute(DEPT_ID);
		int hinId = 0;
		int bedId = 0;
		String adNo = "";
		int disposedToId = 0;
		int careTypeId = 0;
		int doctorId = 0;
		int inpatientId = 0;
		Date dischargeDate = null;
		String dischargeTime = "";
		int dischargeStatusId = 0;
		int departmentId = 0;
		List dishargeCodeList = new ArrayList();

		HttpSession session = request.getSession();

		if (request.getParameter(INPATIENT_ID) != null) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		if (request.getParameter(DISCHARGE_NO) != null) {
			discharge.setDischargeNo(Integer.parseInt(request.getParameter(DISCHARGE_NO)));
		}
		if (request.getParameter(HIN_ID) != null) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			Patient patient = new Patient();

			patient.setId(hinId);
			discharge.setHin(patient);
		}
		if (request.getParameter(AD_NO) != null) {
			adNo = request.getParameter(AD_NO);
			discharge.setAdNo(adNo);
		}
		MasDisposal masDisposal = new MasDisposal();
		masDisposal.setId(7);
		discharge.setDisposal(masDisposal);
		if (!request.getParameter(DISPOSED_TO_ID).equals("0")) {
			disposedToId = Integer.parseInt(request.getParameter(DISPOSED_TO_ID));
			MasDisposedTo masDisposedTo = new MasDisposedTo();
			masDisposedTo.setId(disposedToId);
			discharge.setDisposedTo(masDisposedTo);
		}
		if (request.getParameter(CARE_TYPE_ID) != null && !request.getParameter(CARE_TYPE_ID).equals("0")) {
			careTypeId = Integer.parseInt(request.getParameter(CARE_TYPE_ID));
			MasCareType masCareType = new MasCareType();
			masCareType.setId(careTypeId);
			discharge.setCareType(masCareType);
		}
		if (request.getParameter(DOCTOR_NAME) != null && !request.getParameter(DOCTOR_NAME).equals("0")) {
			doctorId = Integer.parseInt(request.getParameter(DOCTOR_NAME));
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(doctorId);
			discharge.setDoctor(masEmployee);
		}
		if (!request.getParameter(DISCHARGE_STATUS_ID).equals("0")) {
			dischargeStatusId = Integer.parseInt(request.getParameter(DISCHARGE_STATUS_ID));
			MasDischargeStatus masDischargeStatus = new MasDischargeStatus();
			masDischargeStatus.setId(dischargeStatusId);
			discharge.setDischargeStatus(masDischargeStatus);
		}
		if (!request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			discharge.setWard(masDepartment);
		}

		discharge.setAdStatus("A");

		if (request.getParameter(DISCHARGE_IN_MEDICAL_CATEGORY) != null) {
			discharge.setDischargeInMedicalCategory(request.getParameter(DISCHARGE_IN_MEDICAL_CATEGORY));
		}
		if (request.getParameter(INJURY_REPORT_INITIATED_ON) != null
				&& !(request.getParameter(INJURY_REPORT_INITIATED_ON).equals(""))) {
			discharge.setInjuryReportInitiatedOn(HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(INJURY_REPORT_INITIATED_ON)));
		}
		if (request.getParameter(BOARD_HELD_ON) != null && !(request.getParameter(BOARD_HELD_ON).equals(""))) {
			discharge.setBoardHeldOn(HMSUtil.convertStringTypeDateToDateType(request.getParameter(BOARD_HELD_ON)));
		}
		if (request.getParameter(CARE_SUMMARY) != null) {
			discharge.setCareSummary(request.getParameter(CARE_SUMMARY));
		}
		if (request.getParameter(INSTRUCTIONS) != null) {
			discharge.setInstructionsToPatient(request.getParameter(INSTRUCTIONS));
		}
		if (request.getParameter(FOLLOW_UP) != null && !(request.getParameter(FOLLOW_UP).equals(""))) {
			discharge.setFollowUpDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(FOLLOW_UP)));
		}
		if (request.getParameter(OTHER_HOSPITAL_NAME) != null && !request.getParameter(OTHER_HOSPITAL_NAME).equals("")) {
			discharge.setOtherHospital(request.getParameter(OTHER_HOSPITAL_NAME));
		}

		if (request.getParameter("injury_report_init_at") != null
				&& !request.getParameter("injury_report_init_at").equals("")) {
			discharge.setInjuryReportInitAt(request.getParameter("injury_report_init_at"));
		}

		if (request.getParameter("document_initiated") != null
				&& !request.getParameter("document_initiated").equals("")) {
			discharge.setDocumentInitiated(request.getParameter("document_initiated"));
		}

		bedId = Integer.parseInt(request.getParameter(BED_ID));

		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		Users userObj = new Users();
		userObj.setId(userId);
		discharge.setAddEditBy(userObj);
		Map<String, Object> dischargeMap = new HashMap<String, Object>();
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		discharge.setHospital(masHospital);
		String addEditTime = "";
		Date addEditDate = null;
		if (request.getParameter(DISCHARGE_DATE) != null) {
			addEditDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(DISCHARGE_DATE));
			discharge.setAddEditDate(addEditDate);
			discharge.setDateOfDischarge(addEditDate);
			dischargeMap.put("addEditDate", addEditDate);
		}
		if (request.getParameter(DISCHARGE_TIME) != null) {
			addEditTime = request.getParameter(DISCHARGE_TIME);
			discharge.setAddEditTime(addEditTime);
			discharge.setTimeOfDischarge(addEditTime);
			dischargeMap.put("addEditTime", addEditTime);
		}
		discharge.setStatus("y");
		discharge.setDischargeAdviced("y");
		if (request.getParameterValues(DIAGNOSIS_ID) != null) {
			String arr[] = request.getParameterValues(DIAGNOSIS_ID);
			int hdb = 1;
			if (Integer.parseInt(request.getParameter("hdb")) != 1) {
				hdb = Integer.parseInt(request.getParameter("hdb"));
			}

			String[] icdIdArr = new String[hdb];
			String str = "";
			try {
				for (int i = 0; i < arr.length; i++) {

					dishargeCodeList.add(arr[i]);
					str = (i + 1 + 1) + "";
				}
			} catch (Exception e) {
				LOGGER.error("Error occurred : " + e.getStackTrace().toString());
			}

			List<DischargeIcdCode> icdCodeList = new ArrayList<DischargeIcdCode>();
			try {
				str = "";
				for (int i = 0; i < dishargeCodeList.size(); i++) {
					DischargeIcdCode dischargeIcdCode = new DischargeIcdCode();
					if (!((String) dishargeCodeList.get(i)).equals("")) {
						Patient patient = new Patient();
						patient.setId(hinId);
						dischargeIcdCode.setHin(patient);

						Inpatient inpatient = new Inpatient();
						inpatient.setId(inpatientId);
						dischargeIcdCode.setInpatient(inpatient);

						if (request.getParameter(Z03) != null) {
							dischargeIcdCode.setZ03("y");
						} else {
							dischargeIcdCode.setZ03("n");
						}
						dischargeIcdCode.setDiagnosisStatus("f");

						Users userObject = new Users();
						userObject.setId(userId);
						dischargeIcdCode.setAddEditBy(userObject);

						dischargeIcdCode.setAddEditDate(addEditDate);
						dischargeIcdCode.setAddEditTime(addEditTime);
						dischargeIcdCode.setStatus("y");

						masHospital.setId(hospitalId);
						dischargeIcdCode.setHospital(masHospital);

						icdCodeList.add(dischargeIcdCode);
						str = (i + 1 + 1) + "";
					}
				}
				dischargeMap.put("icdCodeList", icdCodeList);
				dischargeMap.put("icdIdArr", icdIdArr);
				dischargeMap.put("dishargeCodeList", dishargeCodeList);

			} catch (Exception e) {
				LOGGER.error("Error occurred : " + e.getStackTrace().toString());
			}
		}

		dischargeMap.put("hinId", hinId);
		dischargeMap.put("inpatientId", inpatientId);
		dischargeMap.put("adNo", adNo);
		dischargeMap.put("discharge", discharge);
		dischargeMap.put("bedId", bedId);
		dischargeMap.put("dischargeDate", dischargeDate);
		dischargeMap.put("dischargeTime", dischargeTime);

		boolean dischargeInfoSave = false;
		dischargeInfoSave = adtHandlerService.submitDischargeInformation(dischargeMap);

		String message = "";
		Map<String, Object> patientDetailsMap = new HashMap<String, Object>();
		patientDetailsMap.put("adNo", adNo);
		patientDetailsMap.put("inpatientId", inpatientId);
		patientDetailsMap.put(HOSPITAL_ID, hospitalId);
		patientDetailsMap.put(DEPT_ID, deptId);

		if (dischargeInfoSave) {
			message = " Discharge Information has been submitted Successfully";
			if (request.getParameter("flag") != null && request.getParameter("flag").equals("expiry")) {

				String transferType = "ward";

				Transfer transfer = new Transfer();
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				transfer.setInpatient(inpatient);
				Patient patient = new Patient();
				patient.setId(hinId);
				transfer.setHin(patient);
				transfer.setAdNo(adNo);
				MasHospital hospital = new MasHospital();
				hospital.setId((Integer) session.getAttribute(HOSPITAL_ID));
				transfer.setHospital(hospital);
				transfer.setRequestStatus("p");
				transfer.setTransferType(transferType);
				transfer.setTransferReason("Death");
				transfer.setAdStatus(inpatient.getAdStatus());
				transfer.setStatus("y");
				Users users = new Users();
				users.setId((Integer) session.getAttribute(USER_ID));
				transfer.setAddEditBy(users);
				Map<String, Object> utilMap = new HashMap<String, Object>();
				utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
				String date2 = (String) utilMap.get("currentDate");
				String time = (String) utilMap.get("currentTime");
				transfer.setAddEditDate(HMSUtil.convertStringTypeDateToDateType(date2));
				transfer.setAddEditTime(time);
				transfer.setDateOfTransfer(HMSUtil.convertStringTypeDateToDateType(date2));
				transfer.setTimeOfTransfer(time);
				patientDetailsMap.put("transfer", transfer);
				map = adtHandlerService.showExpiryDetails(patientDetailsMap);
				jsp = EXPIRY_DETAILS_JSP + ".jsp";

			} else {
				jsp = MESSAGE_FOR_DISCHARGE_JSP + ".jsp";
			}
		} else {
			message = "Some problem Occured! Try Again.";
			jsp = MESSAGE_FOR_DISCHARGE_JSP + ".jsp";
		}
		String backUrl = "";
		backUrl = "/hms/hms/adt?method=showDischargeJsp";
		map.put("inpatientId", inpatientId);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("backUrl", backUrl);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showFinalDischargeJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showFinalDischargeJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		departmentList = adtHandlerService.getDepartmentList();
		jsp = FINAL_DISCHARGE_JSP + ".jsp";
		map.put("departmentList", departmentList);
		map.put("contentJsp", jsp);
		//
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showReadyToDischargeList(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showReadyToDischargeList ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> dischargeMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int departmentId = 0;
		String adNo = null;
		String hin = null;
		int hospitalId = 0;

		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		try {
			if (request.getParameter(AD_NO) != null && !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				dischargeMap.put("adNo", adNo);
			}
			if (request.getParameter(HIN_NO) != null && !(request.getParameter(HIN_NO).equals(""))) {
				hin = request.getParameter(HIN_NO);
				dischargeMap.put("hin", hin);
			}
			if (!(request.getParameter(WARD_ID).equals("0"))) {
				departmentId = Integer.parseInt(request.getParameter(WARD_ID));
				dischargeMap.put("departmentId", departmentId);
			}
			if (hospitalId > 0) {
				dischargeMap.put("hospitalId", hospitalId);
			}

		} catch (Exception e) {
			LOGGER.error("Error occurred : " + e.getStackTrace().toString());
		}

		patientMap = adtHandlerService.getDischargePatientList(dischargeMap);

		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		departmentList = adtHandlerService.getDepartmentList();

		jsp = FINAL_DISCHARGE_JSP + ".jsp";

		map.put("departmentList", departmentList);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("departmentId", departmentId);
		//
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView dischargePatient(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside dischargePatient ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> tempMap = new HashMap<String, Object>();
		int dischargeId = 0;
		if (request.getParameter("parent") != null) {
			dischargeId = Integer.parseInt(request.getParameter("parent"));
			detailsMap.put("dischargeId", dischargeId);
		}
		String dischargeSuccessfully = "false";
		tempMap = adtHandlerService.dischargePatient(detailsMap);

		String message = "";
		dischargeSuccessfully = "" + tempMap.get("dischargeSuccessfully");
		if (dischargeSuccessfully.equals("true")) {
			message = " Discharged Successfully.Do you want print ?";

		} else {
			message = "Some problem Occured! Try Again.";
		}
		String backUrl = "";
		backUrl = "/hms/hms/adt?method=showFinalDischargeJsp";

		jsp = MESSAGE_FOR_DISCHARGE_JSP + ".jsp";
		map.put("inpatientId", tempMap.get("inpatientId"));
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("backUrl", backUrl);
		//
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitExpiryDetails(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside submitExpiryDetails ");
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		ExpiryDetails expiryDetails = new ExpiryDetails();
		int hinId = 0;
		int inpatientId = 0;
		int bedId = 0;
		int wardId = 0;
		int transactionId = 0;
		int deathCertificateNo = 0;

		if (request.getParameter(INPATIENT_ID) != null) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			expiryDetails.setInpatient(inpatient);
		}
		if (request.getParameter(HIN_ID) != null) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			Patient patient = new Patient();
			patient.setId(hinId);
			expiryDetails.setHin(patient);
		}
		if (request.getParameter(WARD_ID) != null) {
			wardId = Integer.parseInt(request.getParameter(WARD_ID));
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(wardId);
			expiryDetails.setWard(masDepartment);
		}
		if (request.getParameter(BED_ID) != null) {
			bedId = Integer.parseInt(request.getParameter(BED_ID));
			MasBed masBed = new MasBed();
			masBed.setId(bedId);
			expiryDetails.setBed(masBed);
		}
		if (request.getParameter(D_DEATH_CAUSE_ID) != null) {
			expiryDetails.setDDeathCauseText("" + request.getParameter(D_DEATH_CAUSE_ID));
		}
		if (request.getParameter(S_DEATH_CAUSE_ID) != null) {
			expiryDetails.setSDeathCauseText("" + request.getParameter(S_DEATH_CAUSE_ID));
		}
		if (request.getParameter(C_DEATH_CAUSE_ID) != null) {
			expiryDetails.setCDeathCauseText("" + request.getParameter(C_DEATH_CAUSE_ID));
		}

		if (request.getParameter("issueDate") != null) {
			expiryDetails.setIssueDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter("issueDate")));
		}
		if (request.getParameter("issueTime") != null) {
			expiryDetails.setIssueTime(request.getParameter("issueTime"));
		}
		if (request.getParameter(DEATH_CERTIFICATE_NO) != null) {
			expiryDetails.setDeathCertificateNo(request.getParameter(DEATH_CERTIFICATE_NO));
			deathCertificateNo = Integer.parseInt(request.getParameter(DEATH_CERTIFICATE_NO));
		}
		if (request.getParameter("transactionId") != null) {
			transactionId = Integer.parseInt(request.getParameter("transactionId"));
		}
		if (request.getParameter(DEATH_CERTIFICATE_TAKEN_BY) != null) {
			expiryDetails.setDeathCertificateTakenBy(request.getParameter(DEATH_CERTIFICATE_TAKEN_BY));
		}
		if (request.getParameter(DATE_OF_EXPIRY) != null && !(request.getParameter(DATE_OF_EXPIRY).equals(""))) {
			expiryDetails.setExpiryDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE_OF_EXPIRY)));
		}
		if (request.getParameter(TIME_OF_EXPIRY) != null) {
			expiryDetails.setExpiryTime(request.getParameter(TIME_OF_EXPIRY));
		}
		if (request.getParameter(CONSQUENCE_OF) != null) {
			expiryDetails.setConsequenceOf("" + request.getParameter(CONSQUENCE_OF));
		}
		if (request.getParameter(ID_MARK1) != null) {
			expiryDetails.setIdMarks1("" + request.getParameter(ID_MARK1));
		}
		if (request.getParameter(ID_MARK2) != null) {
			expiryDetails.setIdMarks2("" + request.getParameter(ID_MARK2));
		}
		if (request.getParameter(REMARKS) != null) {
			expiryDetails.setRemarks("" + request.getParameter(REMARKS));
		}
		String flagJsp = "";
		if (request.getParameter("flagJsp") != null) {
			flagJsp = request.getParameter("flagJsp");
		}
		HttpSession session = request.getSession();

		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		expiryDetails.setHospital(masHospital);

		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		Users userObj = new Users();
		userObj.setId(userId);
		expiryDetails.setAddEditBy(userObj);

		if (request.getParameter(CHANGED_DATE) != null) {
			Date addEditDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
			expiryDetails.setAddEditDate(addEditDate);
		}
		if (request.getParameter(CHANGED_TIME) != null) {
			String addEditTime = request.getParameter(CHANGED_TIME);
			expiryDetails.setAddEditTime(addEditTime);
		}

		Map<String, Object> expiryDetilsMap = new HashMap<String, Object>();
		expiryDetilsMap.put("expiryDetails", expiryDetails);
		expiryDetilsMap.put("transactionId", transactionId);
		expiryDetilsMap.put("deathCertificateNo", deathCertificateNo);

		expiryDetilsMap.put("hinId", hinId);
		boolean saved = false;
		saved = adtHandlerService.submitExpiryDetails(expiryDetilsMap, box);
		String message = "";

		if (saved == true) {
			message = "Expiry Details  saved successfully.Do you want print ?";
		} else {
			message = "Some problem Occured! Try Again.";
		}
		if (flagJsp.equalsIgnoreCase("popup")) {
			map.put("inpatientId", inpatientId);
			map.put("message", message);
			map.put("flagJsp", flagJsp);
			return new ModelAndView("messageForExpiryDetails", "map", map);
		} else {
			jsp = MESSAGE_FOR_EXPIRY_DETAILS + ".jsp";
			map.put("inpatientId", inpatientId);
			map.put("contentJsp", jsp);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
	}

	// -----------------------------For Reports----------------

	public ModelAndView showIPAdmissionReportJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showIPAdmissionReportJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = IP_ADMISSION_REPORT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings({ "unchecked" })
	public ModelAndView showIPAdmissionReport(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showIPAdmissionReport ");
		String adNo = "";
		Date dateOfAdmission=null;
		String userName = "";
		int relation_id = 0;
		int service_status_id = 0;
		String service = "";
		String relationForReport = "";
		HttpSession session = request.getSession();
		int hospitalId = 0;
		String condition_status = "";
		int hinId = 0;
		String hinNo=null;
		StringBuffer condition_status_message = new StringBuffer();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (request.getParameter(AD_NO) != null) {
			adNo = request.getParameter(AD_NO);
		}
		if (request.getParameter("hin_no") != null) {
			hinNo = request.getParameter("hin_no");
		}
		if (request.getParameter("hinId") != null) {
			hinId = Integer.parseInt(request.getParameter("hinId"));
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("adNo", adNo);
		dataMap.put("hinId", hinId);
		dataMap.put("hinNo", hinNo);
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		detailsMap = adtHandlerService.getDiagnosisAndDocInit(dataMap);

		String department = "";
		if (null != detailsMap.get("department")) {
			department = (String) detailsMap.get("department");
		}

		inpatientList = (List<Inpatient>) detailsMap.get("inpatientList");
		for (Inpatient inpatient : inpatientList) {
			if (inpatient.getHin().getRelation() != null)
				relation_id = inpatient.getHin().getRelation().getId();
			if (inpatient.getHin().getServiceStatus() != null)
				service_status_id = inpatient.getHin().getServiceStatus().getId();

			if (inpatient.getConditionStatus() != null && condition_status.equalsIgnoreCase("SIL")
					|| condition_status.equalsIgnoreCase("DIL")) {
				condition_status = inpatient.getConditionStatus();
				condition_status_message.append("Patient Admitted as ");
				condition_status_message.append(condition_status);
				condition_status_message.append(" on ");
				try {
					SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat formatterOut = new SimpleDateFormat("dd/MM/yyyy");
					String date4MySQL = formatterOut.format(formatterIn.parse("" + inpatient.getDateOfAddmission()));
					condition_status_message.append(date4MySQL);
				} catch (Exception e) {
					e.printStackTrace();
				}
				condition_status_message.append(" at ");
				condition_status_message.append(inpatient.getTimeOfAddmission());
			}
			if (inpatient.getHin().getRelation() != null)
				if (Integer.parseInt("" + inpatient.getHin().getRelation().getId()) == 8) {
					relationForReport = "" + inpatient.getHin().getRelation().getRelationName();
				} else {
					relationForReport = "" + inpatient.getHin().getRelation().getRelationName() + " of";
				}
		}
		if (service_status_id == 1) {
			if (relation_id == 8) {
				service = "Serving Personal";
			} else {
				service = "Serving Personal Dependent ";
			}

		} else if (service_status_id == 2) {
			if (relation_id == 8) {
				service = "Ex Service Personal";
			} else {
				service = "Ex Service Personal Dependent ";
			}

		}
		
		if (request.getParameter(DATE_OF_ADMISSION) != null) {
			dateOfAdmission = HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE_OF_ADMISSION));
		}
		
		parameters.put("relationForReport", relationForReport);
		parameters.put("service", service);
		parameters.put("adNo", adNo);
		parameters.put("dateOfAdmission", dateOfAdmission);
		parameters.put("condition_status_message", condition_status_message.toString());
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		parameters.put("userName", userName);
		parameters.put("doc_attached", "" + detailsMap.get("docString"));
		parameters.put("diagnosis", "" + detailsMap.get("diagnosisString"));
		parameters.put("HOSPITAL_ID", hospitalId);
		parameters.put("department", department);
		parameters.put("hinNo", hinNo);

		detailsMap.put("Report_Path", request.getContextPath() + "/Reports/" + "IPRegistrationSlip" + ".pdf");
		HMSUtil.generateReportForDirectPrint("IPRegistrationSlip", parameters, (Connection) detailsMap.get("conn"),
				response, getServletContext(), getServletContext().getRealPath("/Reports/"));

		return new ModelAndView("printReports", "map", detailsMap);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView getAdmissionNoList(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside getAdmissionNoList ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String serviceNo = "";
		String hinNo = "";
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		try {
			if (request.getParameter(HIN_NO) != null && !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				detailsMap.put("hinNo", hinNo);
			}
			if (hospitalId > 0) {
				detailsMap.put("hospitalId", hospitalId);
			}
			List<Object> admissionNoList = new ArrayList<Object>();
			List<Object> hinNoList = new ArrayList<Object>();
			String flag = "";
			String mlc = "";
			String wound = "";
			String silDil = "";
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (request.getParameter("silDil") != null) {
				silDil = request.getParameter("silDil");
			}
			if (request.getParameter("mlc") != null) {
				mlc = request.getParameter("mlc");
				map.put("mlc", mlc);
			}
			if (request.getParameter("wound") != null) {
				wound = request.getParameter("wound");
				map.put("wound", wound);
			}
			if (flag.equals("admission")) {
				admissionNoList = adtHandlerService.getAdmissionNoList(detailsMap);
				map.put("admissionNoList", admissionNoList);
				if (silDil.equals("silDil")) {
					jsp = RESPONSE_FOR_ADMISSION_NO_NEW;
				} else {
					jsp = RESPONSE_FOR_ADMISSION_NO;
				}
			} else if (flag.equals("hin")) {
				hinNoList = adtHandlerService.getHinNoList(serviceNo);
				map.put("hinNoList", hinNoList);
				if (request.getParameter("medical") != null) {
					jsp = HIN_NO_fOR_MEDICAL_CERTIFICATE_JSP;
				} else {
					jsp = RESPONSE_FOR_HIN_NO;
				}
			} else if (flag.equals("mlc")) {
				admissionNoList = adtHandlerService.getAdmissionNoList(detailsMap);
				map.put("admissionNoList", admissionNoList);
				jsp = "responseForAdNoUpdateMlc";
			}
			if (silDil.equals("silDil")) {
				map.put("silDil", silDil);
			}
		} catch (Exception e) {
			LOGGER.error("Error occurred : " + e.getStackTrace().toString());
		}
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView showWoundReportJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showWoundReportJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = WOUND_REPORT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showWoundCertificateReport(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showWoundCertificateReport ");
		HttpSession session = request.getSession();
		int hospitalId = 0;
		String adNo = "";

		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter(AD_NO) != null) {
			adNo = request.getParameter(AD_NO);
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = adtHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("adNo", adNo);
		parameters.put("HOSPITAL_ID", hospitalId);

		HMSUtil.generateReport("WoundCertificate", parameters, (Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView showIpAdmissionRegisterReportJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showIpAdmissionRegisterReportJsp ");
		HttpSession session = request.getSession();
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map = adtHandlerService.populateIPAdmissionRegister(hospitalId);
		jsp = IP_ADMISSION_REGISTER_REPORT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showIpAdmissionRegisterReport(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showIpAdmissionRegisterReport ");
		HttpSession session = request.getSession();
		Date fromDate = null;
		Date toDate = null;
		String fromTime = "";
		String toTime = "";
		int caseTypeId = 0;
		int departmentId = 0;
		int wardId = 0;
		String stringVariable = "";
		int hospitalId = 0;
		long fromAge = 0;
		long toAge = 0;
		String fromAgeType = null;
		String toAgeType = null;
		int sexId = 0;
		int schemeId = 0;
		BigDecimal fromMonthlyIncome = null;
		BigDecimal toMonthlyIncome = null;
		int patientTypeId = 0;
		String bplStatus = null;
		String departmentName = "";
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> deptMap = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		String type = "";
		if (request.getParameter("type") != null) {
			type = request.getParameter("type");
		}

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
		// added by arbind on 02-02-2017
		if (request.getParameter("fromTime") != null) {
			fromTime = request.getParameter("fromTime");
		}
		if (request.getParameter("toTime") != null) {
			toTime = request.getParameter("toTime");
		}
		// added by arbind on 02-02-2017 end
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("fromTime", fromTime);
		parameters.put("toTime", toTime);

		if (type.equals("ip")) {
			stringVariable = "  and inpatient.ad_status!='C'";
			if (!request.getParameter(WARD_ID).equals("0")) {
				wardId = Integer.parseInt(request.getParameter(WARD_ID));
				stringVariable = stringVariable + " and inpatient.department_id=" + wardId;
			}
			if (!request.getParameter(DEPARTMENT_ID).equals("")) {
				departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
				stringVariable = stringVariable + " and inpatient.admitting_departmet_id=" + departmentId;
			}

			detailMap.put("deptId", departmentId);
			deptMap = adtHandlerService.getHeaderDetails(detailMap);

			if (deptMap.get("deptName") != null) {
				departmentName = (String) deptMap.get("deptName");
			}

			if (request.getParameter("fromAge") != null && !request.getParameter("fromAge").equals("")) {
				fromAge = Long.parseLong(request.getParameter("fromAge"));
				if (request.getParameter("fromAgeType") != null) {
					fromAgeType = request.getParameter("fromAgeType");
					if (fromAgeType.equalsIgnoreCase("years")) {
						fromAge = fromAge * 365 + (fromAge / 4);
					} else if (fromAgeType.equalsIgnoreCase("months")) {
						fromAge = fromAge * 30;
					}
				}
			}

			if (request.getParameter("toAge") != null && !request.getParameter("toAge").equals("")) {
				toAge = Long.parseLong(request.getParameter("toAge"));
				if (request.getParameter("toAgeType") != null) {
					toAgeType = request.getParameter("toAgeType");
					if (toAgeType.equalsIgnoreCase("years")) {
						toAge = toAge * 365 + 364 + (toAge / 4);
					} else if (toAgeType.equalsIgnoreCase("months")) {
						toAge = toAge * 30 + 29;
					}
					stringVariable += " and EXTRACT(DAY FROM(now()-patient.date_of_birth)) between " + fromAge
							+ " and " + toAge;
				}
			}

			String BPLString = "";
			if (request.getParameter(BPL_STATUS) != null) {
				bplStatus = (String) request.getParameter(BPL_STATUS);
				stringVariable += " and patient.bpl_status = 'y' ";
				BPLString = "BPL";
			}

			if (!request.getParameter(SCHEME_ID).equals("")) {
				schemeId = Integer.parseInt(request.getParameter(SCHEME_ID));
				stringVariable += " and inpatient.scheme_id = " + schemeId;
			}

			if (!request.getParameter(SEX_ID).equals("")) {
				sexId = Integer.parseInt(request.getParameter(SEX_ID));
				stringVariable += " and patient.sex_id = " + sexId;
			}

			if (!request.getParameter("fromMonthlyIncome").equals("")) {
				fromMonthlyIncome = new BigDecimal((String) request.getParameter("fromMonthlyIncome"));
				stringVariable += " and patient.monthly_income >= " + fromMonthlyIncome;
			}

			if (!request.getParameter("toMonthlyIncome").equals("")) {
				toMonthlyIncome = new BigDecimal((String) request.getParameter("toMonthlyIncome"));
				stringVariable += " and patient.monthly_income <= " + toMonthlyIncome;
			}

			if (!request.getParameter(PATIENT_TYPE_ID).equals("")) {
				patientTypeId = Integer.parseInt(request.getParameter(PATIENT_TYPE_ID));
				stringVariable += " and patient.patient_type_id = " + patientTypeId;
			}

			if (!request.getParameter(CASE_TYPE_ID).equals("0")) {
				caseTypeId = Integer.parseInt(request.getParameter(CASE_TYPE_ID));
				stringVariable = stringVariable + " and inpatient.case_type_id=" + caseTypeId;

			}
			// added by govind 12-01-2017
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			Map<String, Object> map = new HashMap<String, Object>();
			String hospitalName = "";
			map = adtHandlerService.getHospitalParameterDetails(hospitalId);
			if (map.get("hospitalList") != null) {
				hospitalList = (List<MasHospital>) map.get("hospitalList");
			}
			if (hospitalList != null && hospitalList.size() > 0) {
				hospitalName = hospitalList.get(0).getHospitalName();
			}
			parameters.put("hospitalName", hospitalName);
			// added by govind 12-01-2017 end

			String cashReceived = "n";
			String cashReceivedStr = "";
			if (null != request.getParameter("cashreceived") && request.getParameter("cashreceived").equals("y")) {
				cashReceived = request.getParameter("cashreceived");
				cashReceivedStr = "Cash Received : Yes";
			}
			if (cashReceived.equalsIgnoreCase("y")) {
				stringVariable += " and inpatient.cash_received_status='y'";
			}
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			detailsMap = adtHandlerService.getConnectionForReport();
			parameters.put("cashReceivedStr", cashReceivedStr); // added by
																// arbind on
																// 10-02-2017
			parameters.put("BPLString", BPLString);
			parameters.put("stringVariable", stringVariable);
			parameters.put("HOSPITAL_ID", hospitalId);
			parameters.put("departmentName", departmentName);
			
			String flag="1";
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (flag.equals("1"))
			{
				HMSUtil.generateReport("IPAdmissionRegister", parameters, (Connection) detailsMap.get("conn"), response,
						getServletContext());
			}

			else if(flag.equals("2")) {
						HMSUtil.generateHTMLReport("IPAdmissionRegister", parameters, (Connection) detailsMap.get("conn"), response,
								getServletContext());
			}
			
		} else if (type.equals("asOn")) {
			//
			stringVariable = " ";
			if (!request.getParameter(CASE_TYPE_ID).equals("0") && request.getParameter(DEPARTMENT_ID).equals("0")) {
				stringVariable = " and Main.Case_type_id=" + Integer.parseInt(request.getParameter(CASE_TYPE_ID));
			}
			if (!request.getParameter(DEPARTMENT_ID).equals("0") && request.getParameter(CASE_TYPE_ID).equals("0")) {
				departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
				stringVariable = " and inpatient.department_id=" + departmentId;
			}
			if (!request.getParameter(DEPARTMENT_ID).equals("0") && !request.getParameter(CASE_TYPE_ID).equals("0")) {

				departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
				stringVariable = " and inpatient.department_id=" + departmentId + " and Main.Case_type_id="
						+ Integer.parseInt(request.getParameter(CASE_TYPE_ID));
			}
			//
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			detailsMap = adtHandlerService.getConnectionForReport();
			parameters.put("stringVariable", stringVariable);
			parameters.put("HOSPITAL_ID", hospitalId);
			//
			HMSUtil.generateReport("PresentAdmissionRegister", parameters, (Connection) detailsMap.get("conn"),
					response, getServletContext());
			

		}
		return null;
	}

	public ModelAndView showIPAdmServiceTypeCategoryWiseReportJsp(HttpServletRequest request,
			HttpServletResponse response) {

		LOGGER.debug("Inside showIPAdmServiceTypeCategoryWiseReportJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		map = adtHandlerService.getServiceTypeDepartmentCategory();

		jsp = IP_ADM_SERVICE_TYPE_CATEGORY_REPORT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showIpAdmissionServiceTypeCategoryReport(HttpServletRequest request,
			HttpServletResponse response) {

		LOGGER.debug("Inside showIpAdmissionServiceTypeCategoryReport ");
		Date date = null;
		int departmentId = 0;
		String criteria = "";
		String silOrDil = "";
		if (request.getParameter(DATE) != null) {
			date = HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE));
		}
		if (!request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			criteria = " and inpatient.department_id=" + departmentId;
		}

		if (request.getParameter(SILORDIL) != null) {
			silOrDil = request.getParameter(SILORDIL);
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = adtHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("date", date);
		parameters.put("criteria", criteria);
		if (silOrDil.equals("y")) {
			HMSUtil.generateReport("IPAdmServiceTypeCategoryWiseSIDI", parameters, (Connection) detailsMap.get("conn"),
					response, getServletContext());
		} else {
			HMSUtil.generateReport("IPAdmissionServiceTypeCategoryWise", parameters,
					(Connection) detailsMap.get("conn"), response, getServletContext());
		}
		return null;
	}

	public ModelAndView showMedicalCertificateReportJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showMedicalCertificateReportJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = MEDICAL_CERTIFICATE_REPORT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getVisitDates(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside getVisitDates ");
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String hinNo = "";
		int hospitalId = 0;

		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}
		map = adtHandlerService.getVisitDates(hinNo, hospitalId);
		jsp = RESPONSE_FOR_VISIT_DATE;
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getDiagnosis(HttpServletRequest request, HttpServletResponse response) throws ParseException {

		LOGGER.debug("Inside getDiagnosis ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		String fromDate = "";
		String toDate = "";
		String hinNo = "";
		if (request.getParameter(TO_DATE) != null && !request.getParameterValues(TO_DATE).equals("")) {
			toDate = request.getParameter(TO_DATE);
		}
		if (request.getParameter(FROM_DATE) != null && !request.getParameterValues(FROM_DATE).equals("")) {
			fromDate = request.getParameter(FROM_DATE);
		}
		if (request.getParameter(HIN_NO) != null && !request.getParameterValues(HIN_NO).equals("")) {
			hinNo = request.getParameter(HIN_NO);
		}
		parameterMap.put("fromDate", fromDate);
		parameterMap.put("toDate", toDate);
		parameterMap.put("hinNo", hinNo);
		map = adtHandlerService.getDiagnosis(parameterMap);
		jsp = "responseForDiagnosis";
		//
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showMedicalCertificateReport(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showMedicalCertificateReport ");
		HttpSession session = request.getSession();
		Date fromDate = null;
		Date toDate = null;
		String hinNo = "";
		String fitUnfitFor = "";
		String[] diagnosis = null;
		StringBuffer dtStr = new StringBuffer();
		int hospitalId = 0;
		Map<String, Object> parameters = new HashMap<String, Object>();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}

		if (request.getParameterValues(DIAGNOSIS_ID) != null && !request.getParameterValues(DIAGNOSIS_ID).equals("")) {
			diagnosis = (String[]) (request.getParameterValues(DIAGNOSIS_ID));
			for (int i = 0; i < diagnosis.length; i++) {
				dtStr.append(diagnosis[i]);
				dtStr.append(",");
			}
			parameters.put("diagnosis", dtStr.toString());
		}
		LOGGER.debug(dtStr.toString() + " dtStr.toString()");
		if (request.getParameter(FIT_UNFIT_FOR) != null) {
			fitUnfitFor = request.getParameter(FIT_UNFIT_FOR);
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = adtHandlerService.getConnectionForReport();

		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("hinNo", hinNo);
		parameters.put("fitUnfitFor", fitUnfitFor);
		parameters.put("HOSPITAL_ID", hospitalId);
		HMSUtil.generateReport("MedicalCertificate", parameters, (Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	/**
	 * ----------------------------------- Update Admission
	 * ----------------------------
	 */

	public ModelAndView showUpdateSearchJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showUpdateSearchJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		if (request.getParameter("jsp").equals("admission")) {
			jsp = SEARCH_ADMISSION_JSP;
		}
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showUpdateAdmissionJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showUpdateAdmissionJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientAdmissionMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String adNo = "";
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter(AD_NO) != null) {
			adNo = request.getParameter(AD_NO);
		}
		patientAdmissionMap = adtHandlerService.getPatientAdmissionDetailsForUpdate(adNo);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("hospitalId", hospitalId);
		map = adtHandlerService.getAdmissionDetails(dataMap);

		String jsp = UPDATE_ADMISSION_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("patientAdmissionMap", patientAdmissionMap);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateAdmissionInformation(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside updateAdmissionInformation ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int inpatientId = 0;
		int hinId = 0;
		String dietType = "";
		if (!request.getParameter(INPATIENT_ID).equals("0")) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			parameterMap.put("inpatientId", inpatientId);
		}
		if (!request.getParameter(HIN_ID).equals("0")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			parameterMap.put("hinId", hinId);
		}

		if (!request.getParameter(CONSULTING_DOCTOR).equals("0")) {
			int consultingDoctorId = Integer.parseInt(request.getParameter(CONSULTING_DOCTOR));
			parameterMap.put("consultingDoctorId", consultingDoctorId);

		}

		if (!request.getParameter(CASE_TYPE_ID).equals("0")) {
			int caseTypeId = Integer.parseInt(request.getParameter(CASE_TYPE_ID));
			parameterMap.put("caseTypeId", caseTypeId);

		}
		if (!request.getParameter(ADMISSION_TYPE_ID).equals("0")) {
			int admissionTypeId = Integer.parseInt(request.getParameter(ADMISSION_TYPE_ID));
			parameterMap.put("admissionTypeId", admissionTypeId);

		}
		if (!request.getParameter(DIET_ID).equals("0")) {
			int dietId = Integer.parseInt(request.getParameter(DIET_ID));
			parameterMap.put("dietId", dietId);
		}
		if (request.getParameter("ageAsDob") != null) {
			String ageAsDob = request.getParameter("ageAsDob").trim();
			parameterMap.put("ageAsDob", ageAsDob);
		}

		/*
		 * Code for Status Code By Mukesh Date 26 Oct 2010
		 */
		Properties properties1 = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		try {
			properties1.load(resourcePath.openStream());
		} catch (IOException e) {
			LOGGER.error("IOException occurred while loading adt.properties : " + e.getStackTrace().toString());
		}
		String condition = "";
		String conditionStatus = "";
		String conditionNormal = properties1.getProperty("conditionNormal");
		String conditionDead = properties1.getProperty("conditionDead");
		String conditionCritical = properties1.getProperty("conditionCritical");
		if (request.getParameter(CONDITION) != null) {
			condition = request.getParameter(CONDITION);
			if (condition.equals(conditionNormal)) {
				parameterMap.put("condition", condition);
			} else if (condition.equals(conditionDead)) {
				// inpatient.setConditionStatus(condition);
				parameterMap.put("condition", condition);
			} else if (condition.equals(conditionCritical)) {
				if (request.getParameter(CONDITION_STATUS) != null) {
					conditionStatus = request.getParameter(CONDITION_STATUS);
					parameterMap.put("conditionStatus", conditionStatus);
				}
			}
			parameterMap.put("condition", condition);
			if (condition.equals("Dead")) {
				parameterMap.put("patientStatus", "Expired");
			}
		}
		String icd;
		if (request.getParameter("icd") != null) {
			icd = request.getParameter("icd");
			parameterMap.put("icd", icd);
		}
		if (request.getParameter(DIET_TYPE) != null) {
			dietType = request.getParameter(DIET_TYPE);
			parameterMap.put("dietType", dietType);
		}

		String[] documentIdArray = null;

		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		parameterMap.put("userId", userId);
		Date addEditDate = null;

		if (request.getParameter(CHANGED_DATE) != null) {
			addEditDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
			parameterMap.put("addEditDate", addEditDate);
		}
		if (request.getParameter(CHANGED_TIME) != null) {
			String addEditTime = request.getParameter(CHANGED_TIME);
			parameterMap.put("addEditTime", addEditTime);
		}

		String message = "";
		parameterMap.put("documentIdArray", documentIdArray);
		boolean admissionFlag = adtHandlerService.updateAdmissionInformation(parameterMap);

		if (admissionFlag == true) {
			message = "Patient Admission Information Updated successfully.";
		} else {
			message = "Some Error Has occured.";

		}
		String backUrl = "";
		backUrl = "/hms/hms/adt?method=showUpdateSearchJsp";
		map.put("backUrl", backUrl);

		jsp = MESSAGE_FOR_ADT_JSP + ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		//
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView cancelAdmissionInformation(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside cancelAdmissionInformation ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		HttpSession session = request.getSession();
		int inpatientId = 0;
		int bedId = 0;
		String message = "";
		String parentAdNo = "";
		if (!request.getParameter(INPATIENT_ID).equals("0")) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			parameterMap.put("inpatientId", inpatientId);
		}
		if (!request.getParameter(BED_ID).equals("0")) {
			bedId = Integer.parseInt(request.getParameter(BED_ID));
			parameterMap.put("bedId", bedId);
		}
		if (request.getParameter("parentAdNo") != null) {
			parentAdNo = (request.getParameter("parentAdNo"));
			parameterMap.put("parentAdNo", parentAdNo);
		}
		boolean admissionFlag = adtHandlerService.cancelAdmissionInformation(parameterMap);

		if (admissionFlag == true) {
			message = "Patient Admission has cancel successfully.";
		} else {
			message = "Some Error Has occured.";

		}
		String backUrl = "";
		backUrl = "/hms/hms/adt?method=showUpdateSearchJsp";
		map.put("backUrl", backUrl);

		jsp = MESSAGE_FOR_ADT_JSP + ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAdditionalInfoJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showAdditionalInfoJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		jsp = "dischargeAdditionInfo";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView saveAdditionalInfoForDischarge(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside saveAdditionalInfoForDischarge ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		String jsp = "";
		String movementCode = "";
		String warrantNo = "";
		String shr = "";
		String remarks = "";
		int dischargeId = 0;
		boolean flag = false;
		String formName = "";

		if (request.getParameter(DISCHARGE_ID) != null) {
			dischargeId = Integer.parseInt(request.getParameter(DISCHARGE_ID));
			parameterMap.put("dischargeId", dischargeId);
		}
		if (request.getParameter(MOVEMENT_CODE) != null) {
			movementCode = request.getParameter(MOVEMENT_CODE);
			parameterMap.put("movementCode", movementCode);

		}
		if (request.getParameter(WARRANT_NO) != null) {
			warrantNo = request.getParameter(WARRANT_NO);
			parameterMap.put("warrantNo", warrantNo);
		}
		if (request.getParameter(SHR) != null) {
			shr = request.getParameter(SHR);
			parameterMap.put("shr", shr);
		}
		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
			parameterMap.put("remarks", remarks);
		}
		if (request.getParameter("formName") != null) {
			formName = request.getParameter("formName");
		}
		flag = adtHandlerService.saveAdditionalInfoForDischarge(parameterMap);

		String message = "";
		if (flag == true) {
			message = "Information has been submitted successfully";
		} else {
			message = "Some Error has occured";
		}

		jsp = MESSAGE_FOR_ADT_JSP;
		map.put("formName", formName);
		map.put("message", message);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showOPMlcJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showOPMlcJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = OP_MLC_CASE_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showSiDiReportJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showSiDiReportJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		jsp = SI_DI_REPORT_JSP;
		String serviceNo = "";
		if (request.getParameter("serviceNo") != null) {
			serviceNo = request.getParameter("serviceNo");
		}
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("serviceNo", serviceNo);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showSiDiReport(HttpServletRequest request, HttpServletResponse response) throws JRException,
			IOException {

		LOGGER.debug("Inside showSiDiReport ");
		HttpSession session = request.getSession();
		String adNo = "";
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter(AD_NO) != null) {
			adNo = request.getParameter(AD_NO);
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("adNo", adNo);
		detailsMap = adtHandlerService.getSiDiData(dataMap);
		Map<String, Object> parameters = new HashMap<String, Object>();
		String dateSilDil = "";
		try {
			parameters.put("placed_by", "" + detailsMap.get("placed_by"));
			parameters.put("Placed_on", "" + detailsMap.get("Placed_on"));
			parameters.put("si_di", "" + detailsMap.get("si_di"));
			SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat formatterOut = new SimpleDateFormat("dd/MM/yyyy");
			if (detailsMap.get("si_di_date") != null && !detailsMap.get("si_di_date").equals(""))
				dateSilDil = formatterOut.format(formatterIn.parse("" + detailsMap.get("si_di_date")));

			parameters.put("si_di_date", dateSilDil);
			parameters.put("si_di_time", "" + detailsMap.get("si_di_time"));
			parameters.put("diagnosis", "" + detailsMap.get("diagnosis"));
			parameters.put("nok_status", "" + detailsMap.get("nok_status"));

		} catch (Exception e) {
			LOGGER.error("Error occurred : " + e.getStackTrace().toString());
		}

		parameters.put("adNo", adNo);
		parameters.put("HOSPITAL_ID", hospitalId);
		HMSUtil.generateReport("SiDiReport", parameters, (Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView showMedicoLegalReportJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showMedicoLegalReportJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		jsp = MEDICO_LEGAL_REPORT_JSP;

		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getMlcNo(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside getMlcNo ");
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Map<String, Object> details = new HashMap<String, Object>();
		String hinNo = "";
		String adNo = "";
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}
		if (request.getParameter(AD_NO) != null) {
			adNo = request.getParameter(AD_NO);
		}
		if (!hinNo.equals("")) {
			details.put("hinNo", hinNo);
		}
		if (!adNo.equals("")) {
			details.put("adNo", adNo);
		}
		if (hospitalId != 0) {
			details.put("hospitalId", hospitalId);
		}
		map = adtHandlerService.getMlcNo(details);
		jsp = RESPONSE_FOR_MLC_NO;
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showMedicoLegalReport(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showMedicoLegalReport ");
		HttpSession session = request.getSession();
		int hospitalId = 0;
		String mlcNo = "";

		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter(MLC_NO) != null) {
			mlcNo = request.getParameter(MLC_NO);
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = adtHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("mlcNo", mlcNo);
		parameters.put("HOSPITAL_ID", hospitalId);
		HMSUtil.generateReport("MedicoLegalReport", parameters, (Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	// ---------------------At Bangalore ----------------------
	public ModelAndView showSilDilInAdt(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showSilDilInAdt ");
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = SIL_DIL_IN_ADT + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showIPMlcJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showIPMlcJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = IP_MLC_CASE_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getIPMlcJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside getIPMlcJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			map.put("flag", flag);
		}
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printSilDilRepotInAdt(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside printSilDilRepotInAdt ");
		Date fromDate = null;
		Date toDate = null;
		int departmentId = 0;
		String stringVariable = "";
		Map<String, Object> parameters = new HashMap<String, Object>();
		String reportName = "SilDil_As_On_Main";

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		if (!request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			stringVariable = " and inpatient.department_id=" + departmentId;
		}
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		detailsMap = adtHandlerService.getConnectionForReport();
		parameters.put("stringVariable", stringVariable);

		HMSUtil.generateReport(reportName, parameters, (Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	// --Added on 10-07-08----------------

	@SuppressWarnings("unchecked")
	public void chechBed(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside chechBed ");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBed> bedList = new ArrayList<MasBed>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int wardId = 0;
		if (request.getParameter("wardId") != null) {
			wardId = Integer.parseInt(request.getParameter("wardId"));
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		dataMap.put("wardId", wardId);
		dataMap.put(HOSPITAL_ID, hospitalId);
		map = adtHandlerService.chechBed(dataMap);
		bedList = (List<MasBed>) map.get("bedList");
		int bedId = 0;
		for (MasBed bed : bedList) {
			bedId = bed.getId();
			//
		}
		StringBuffer sb = new StringBuffer();

		sb.append("<item>");
		if (bedId > 0) {
			sb.append("<bedStatus>" + "yes" + "</bedStatus>");
		} else {
			sb.append("<bedStatus>" + "no" + "</bedStatus>");
		}
		sb.append("<bedId>" + bedId + "</bedId>");
		sb.append("</item>");

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			//
		} catch (IOException ioException) {
			LOGGER.error("Error while writing to printwriter" + ioException.getStackTrace().toString());
		}
	}

	@SuppressWarnings("unchecked")
	public void checkAdNoDuplication(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside checkAdNoDuplication ");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		String adNo = "";
		if (request.getParameter("adNo") != null) {
			adNo = (request.getParameter("adNo"));
		}

		dataMap.put("adNo", adNo);
		map = adtHandlerService.checkOffLineAdNoDuplicationFor(dataMap);
		inpatientList = (List<Inpatient>) map.get("inpatientList");
		StringBuffer sb = new StringBuffer();

		sb.append("<item>");
		if (inpatientList.size() > 0) {
			sb.append("<adStatus>" + "yes" + "</adStatus>");
		} else {
			sb.append("<adStatus>" + "no" + "</adStatus>");
		}
		sb.append("</item>");

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (IOException ioException) {
			LOGGER.error("Error while writing to printwriter" + ioException.getStackTrace().toString());
		}
	}

	@SuppressWarnings({ "rawtypes" })
	public void checkForDuplicateOfAdnoInAttach(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside checkForDuplicateOfAdnoInAttach ");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List objectList = new ArrayList();
		String serviceNo = "";
		int relationId = 0;
		int serviceTypeId = 0;
		if (request.getParameter("serviceNo") != null) {
			serviceNo = (request.getParameter("serviceNo"));
		}
		if (request.getParameter("serviceTypeId") != null) {
			serviceTypeId = Integer.parseInt("" + (request.getParameter("serviceTypeId")));
		}
		if (request.getParameter("relationId") != null) {
			relationId = Integer.parseInt("" + (request.getParameter("relationId")));
		}
		dataMap.put("serviceNo", serviceNo);
		dataMap.put("serviceTypeId", serviceTypeId);
		dataMap.put("relationId", relationId);
		map = adtHandlerService.checkForDuplicateOfAdnoInAttach(dataMap);
		objectList = (List) map.get("objectList");
		int uniqueRelId = 0;
		String info = "ALREADY ADMITTED INFORMATION...!" + "\n\n";
		try {
			if (objectList.size() > 0) {
				for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
					Object[] object = (Object[]) iterator.next();
					if (relationId == 2 || relationId == 3 || relationId == 8)
						if (Integer.parseInt("" + object[0]) == relationId)
							uniqueRelId = Integer.parseInt("" + object[0]);
					info = info + object[1] + " (" + object[4] + ") " + "\n";
				}
			}
			//
			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			sb.append("<uniqueRelId>" + uniqueRelId + "</uniqueRelId>");
			sb.append("<info>" + info + "</info>");
			sb.append("</item>");

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");

			response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");

		} catch (IOException ioException) {
			LOGGER.error("Error while writing to printwriter" + ioException.getStackTrace().toString());
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getIcdWithIcdCode(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside getIcdWithIcdCode ");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String icdCode = "";
		if (request.getParameter("icdCode") != null) {
			icdCode = (request.getParameter("icdCode"));
		}
		dataMap.put("icdCode", icdCode);
		List<MasIcd> masIcdList = new ArrayList<MasIcd>();
		map = adtHandlerService.getIcdWithIcdCode(dataMap);
		masIcdList = (List) map.get("masIcdList");
		String icdString = "no";
		for (MasIcd masIcd : masIcdList) {
			icdString = masIcd.getIcdName() + "[" + masIcd.getIcdCode() + "]";
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<icdString>" + icdString.toUpperCase() + "</icdString>");
		sb.append("</item>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");

		try {
			response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (IOException ioException) {
			LOGGER.error("Error while writing to printwriter" + ioException.getStackTrace().toString());
		}
	}

	public ModelAndView oldDischargeEntry(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside oldDischargeEntry ");
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = OLD_DISCHARGE_ENTRY + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("rawtypes")
	public void getDischargeDetails(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside getDischargeDetails ");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		List objectList = new ArrayList();
		String hinNo = "";
		int hospitalId = 0;
		if (request.getParameter("hinNo") != null) {
			hinNo = (request.getParameter("hinNo"));
		}
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		dataMap.put("hinNo", hinNo);
		if (hospitalId != 0) {
			dataMap.put("hospitalId", hospitalId);
		}
		map = adtHandlerService.getDischargeDetails(dataMap);
		objectList = (List) map.get("objectList");
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<adLists>");
		try {
			for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
				Object[] object = (Object[]) iterator.next();

				sb.append("<adList>");
				sb.append("<adId>" + object[0] + "</adId>");
				sb.append("<adNo>" + object[1] + "</adNo>");
				sb.append("</adList>");
			}
		} catch (Exception e) {
			LOGGER.error("Error occurred : " + e.getStackTrace().toString());
		}

		sb.append("</adLists>");
		sb.append("</item>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");

		try {
			response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (IOException ioException) {
			LOGGER.error("Error while writing to printwriter" + ioException.getStackTrace().toString());
		}
	}

	@SuppressWarnings("unchecked")
	public void getDetailsOfDischarge(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside getDetailsOfDischarge ");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String inpatientId = "";
		String admissionNo = "";
		if (request.getParameter("inpatientId") != null) {
			inpatientId = (request.getParameter("inpatientId"));
		}
		if (request.getParameter("admissionNo") != null) {
			admissionNo = (request.getParameter("admissionNo"));
		}
		dataMap.put("inpatientId", inpatientId);
		dataMap.put("admissionNo", admissionNo);

		List<Inpatient> inpatientList = new ArrayList<Inpatient>();

		List<Discharge> dischargeList = new ArrayList<Discharge>();
		List<DischargeIcdCode> dischargeIcdCodeList = new ArrayList<DischargeIcdCode>();
		map = adtHandlerService.getDetailsOfDischarge(dataMap);

		inpatientList = (List<Inpatient>) map.get("inpatientList");
		dischargeList = (List<Discharge>) map.get("dischargeList");
		dischargeIcdCodeList = (List<DischargeIcdCode>) map.get("dischargeIcdCodeList");
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		for (Inpatient inpatient : inpatientList) {
			String pName = "";
			pName = inpatient.getHin().getPFirstName();
			if (inpatient.getHin().getPMiddleName() != null) {
				pName += " " + inpatient.getHin().getPMiddleName();
			}
			if (inpatient.getHin().getPLastName() != null) {
				pName += " " + inpatient.getHin().getPLastName();
			}
			sb.append("<pName>" + pName + "</pName>");
			try {
				SimpleDateFormat formatterIn2 = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat formatterOut2 = new SimpleDateFormat("dd/MM/yyyy");
				String date4MySQL2 = formatterOut2.format(formatterIn2.parse("" + inpatient.getDateOfAddmission()));
				sb.append("<doa>" + date4MySQL2 + "</doa>");
			} catch (Exception e) {
				e.printStackTrace();
			}
			sb.append("<age>" + inpatient.getAge() + "</age>");
			sb.append("<sex>" + inpatient.getHin().getSex().getAdministrativeSexName() + "</sex>");
			sb.append("<hinId>" + inpatient.getHin().getId() + "</hinId>");
			sb.append("<deptId>" + inpatient.getDepartment().getId() + "</deptId>");
		}
		String date4MySQL = "no";
		String disTime = "no";
		String disId = "no";
		for (Discharge discharge : dischargeList) {
			SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat formatterOut = new SimpleDateFormat("dd/MM/yyyy");

			try {
				date4MySQL = formatterOut.format(formatterIn.parse("" + discharge.getDateOfDischarge()));
				disTime = discharge.getTimeOfDischarge();
				disId = "" + discharge.getId();
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		sb.append("<dDate>" + date4MySQL + "</dDate>");
		sb.append("<dTime>" + disTime + "</dTime>");
		sb.append("<dId>" + disId + "</dId>");
		String diagnosis = "";
		try {
			if (dischargeIcdCodeList.size() > 0) {

				for (DischargeIcdCode dischargeIcdCode : dischargeIcdCodeList) {
					//
					if (dischargeIcdCode.getIcd() != null)
						diagnosis = diagnosis + dischargeIcdCode.getIcd().getIcdName() + "["
								+ dischargeIcdCode.getIcd().getIcdCode() + "]" + ",";
				}
			}
		} catch (Exception e) {
			LOGGER.error("Error Occured : " + e.getStackTrace().toString());
		}

		if (diagnosis.equals("")) {
			diagnosis = "-NO-";
		}
		sb.append("<diagnosis>" + diagnosis + "</diagnosis>");
		sb.append("</item>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");

		try {
			response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (IOException ioException) {
			LOGGER.error("Error while writing to printwriter" + ioException.getStackTrace().toString());
		}
	}

	public ModelAndView updateDischarge(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside updateDischarge ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Discharge discharge = new Discharge();
		String adNo = "";
		int departmentId = 0;
		int inpatientId = 0;
		int hospitalId = 0;
		HttpSession session = request.getSession();

		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		dataMap.put("userId", userId);
		session = request.getSession();

		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
		if (request.getParameter("hinId") != null) {
			dataMap.put("hinId", request.getParameter("hinId"));
		}
		if (request.getParameter(DISCHARGE_DATE) != null) {
			dataMap.put("dischargeDate", request.getParameter(DISCHARGE_DATE));
		}
		if (request.getParameter(INPATIENT_ID) != null) {
			dataMap.put("inpatientId", request.getParameter(INPATIENT_ID));
		}
		if (request.getParameter(DISCHARGE_TIME) != null) {

			dataMap.put("dischargeTime", request.getParameter(DISCHARGE_TIME));
		}
		int dId = 0;
		if (request.getParameter("dId") != null) {
			dId = Integer.parseInt("" + request.getParameter("dId"));
			dataMap.put("dischargeId", request.getParameter("dId"));
		}

		if (dId == 0) {

			if (request.getParameter(DISCHARGE_NO) != null) {
				discharge.setDischargeNo(Integer.parseInt(request.getParameter(DISCHARGE_NO)));
			}
			if (request.getParameter("hinId") != null) {
				discharge.setHin(new Patient(Integer.parseInt("" + request.getParameter("hinId"))));
			}
			if (request.getParameter("admissionNo") != null) {
				adNo = request.getParameter("admissionNo");
				discharge.setAdNo(adNo);
			}

			MasDisposal masDisposal = new MasDisposal();
			masDisposal.setId(7);
			discharge.setDisposal(masDisposal);

			MasDisposedTo masDisposedTo = new MasDisposedTo();
			masDisposedTo.setId(5);
			discharge.setDisposedTo(masDisposedTo);

			MasCareType masCareType = new MasCareType();
			masCareType.setId(6);
			discharge.setCareType(masCareType);

			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(1);
			discharge.setDoctor(masEmployee);

			MasDischargeStatus masDischargeStatus = new MasDischargeStatus();
			masDischargeStatus.setId(5);
			discharge.setDischargeStatus(masDischargeStatus);
			discharge.setHospital(new MasHospital(hospitalId));
			if (!request.getParameter("deptId").equals("0")) {
				departmentId = Integer.parseInt(request.getParameter("deptId"));
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				discharge.setWard(masDepartment);
			}

			discharge.setStatus("y");
			discharge.setDischargeAdviced("y");

		}
		int hdb = 1;
		if (Integer.parseInt(request.getParameter("hdb")) != 1) {
			hdb = Integer.parseInt(request.getParameter("hdb"));
		}

		String[] diagnosidIdArray = new String[hdb];
		String str = "";
		try {
			for (int i = 0; i < hdb; i++) {
				if (request.getParameter("icd" + str) != null) {
					String icd = request.getParameter("icd" + str);
					diagnosidIdArray[i] = (icd);
					str = (i + 1 + 1) + "";
				}
			}
		} catch (Exception e) {
			LOGGER.error("Error Occurred : " + e.getStackTrace().toString());
		}

		dataMap.put("diagnosidIdArray", diagnosidIdArray);
		dataMap.put("discharge", discharge);
		dataMap.put("dId", dId);
		map = adtHandlerService.updateDischarge(dataMap);

		String message = "";
		String saved = "n";

		saved = "" + map.get("saved");
		if (saved.equals("y")) {
			message = "Discharge Information has been Updated Successfully.";
			jsp = MESSAGE_FOR_ADT_JSP + ".jsp";

		} else {
			message = "Some problem Occured! Try Again.";
			jsp = MESSAGE_FOR_ADT_JSP + ".jsp";
		}
		map.put("inpatientId", inpatientId);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView showICDSearchJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showICDSearchJsp ");
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = adtHandlerService.getICDDetails(box);
		jsp = "ADT_ICD_Search";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showAvailableBedStatus(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showAvailableBedStatus ");
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		map = adtHandlerService.getBedStatus(box, hospitalId);
		jsp = "ADT_Bed_Selection";
		map.put("contentJsp", jsp);
		map.put("chargeCodeId", box.getInt("chargeCodeId"));
		map.put("hinNo", box.getString("hinNo"));
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showExpiryDetailsSearchJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showExpiryDetailsSearchJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		map = adtHandlerService.getDetailsForSearch();
		jsp = SEARCH_EXPITY_DETAILS_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchExpiryDetails(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside searchExpiryDetails ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientDiagnosisMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		String hinNo = "";
		int wardId = 0;
		String adNo = "";
		int inpatientId = 0;
		String serviceNo = "";
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		try {

			if (request.getParameter(SERVICE_NO) != null && !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				dataMap.put("serviceNo", serviceNo);
			}
			if (request.getParameter(AD_NO) != null && !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				dataMap.put("adNo", adNo);
			}
			if (request.getParameter(HIN_NO) != null && !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				dataMap.put("hinNo", hinNo);
			}
			if (request.getParameter(WARD_ID) != null && !(request.getParameter(WARD_ID).equals("0"))) {
				wardId = Integer.parseInt(request.getParameter(WARD_ID));
				dataMap.put("wardId", wardId);
			}
			if (request.getParameter("inpatientId") != null) {
				inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
				dataMap.put("inpatientId", inpatientId);
			}
		} catch (Exception e) {
			LOGGER.error("Error Coccurred : " + e.getStackTrace().toString());
		}

		patientMap = adtHandlerService.searchExpiryDetails(dataMap);

		String jsp = "";
		String message = "";
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Inpatient> inpatientTempList = new ArrayList<Inpatient>();

		if (patientMap.get("inpatientList") != null) {
			inpatientList = (List<Inpatient>) patientMap.get("inpatientList");
		}
		if (patientMap.get("inpatientTempList") != null) {
			inpatientTempList = (List<Inpatient>) patientMap.get("inpatientTempList");
		}
		if ((!adNo.equals("") && inpatientList.size() > 0) || inpatientId != 0) {
			detailsMap = adtHandlerService.getDischargeDetails(hospitalId, inpatientId);
			patientDiagnosisMap = adtHandlerService.getPatientDiagnosis(adNo, inpatientId);
			map.put("patientDiagnosisMap", patientDiagnosisMap);
			jsp = DISCHARGE_BY_HIN_NO_JSP + ".jsp";
		} else if (!adNo.equals("") && inpatientTempList.size() > 0 && inpatientList.size() == 0) {
			map = adtHandlerService.getDetailsForSearch();
			message = "Discharge Summary of patient is not prepared.Please first prepare discharge summary.";
			map.put("message", message);
			jsp = SEARCH_EXPITY_DETAILS_JSP + ".jsp";
		} else {
			map = adtHandlerService.getDetailsForSearch();
			jsp = SEARCH_EXPITY_DETAILS_JSP + ".jsp";
		}

		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showExpiryDetails(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showExpiryDetails ");
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String message = "";
		String adNo = "";
		int inpatientId = 0;
		int hospitalId = 0;
		int deptId = 0;
		String flagJsp = "";
		if (session.getAttribute(DEPT_ID) != null) {
			deptId = (Integer) session.getAttribute(DEPT_ID);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Map<String, Object> patientDetailsMap = new HashMap<String, Object>();

		if (request.getParameter("adNo") != null) {
			adNo = (request.getParameter("adNo"));
		}
		if (request.getParameter("flagJsp") != null) {
			flagJsp = (request.getParameter("flagJsp"));
		}
		if (request.getParameter("inpatientId") != null) {
			inpatientId = Integer.parseInt((request.getParameter("inpatientId")));
		}

		patientDetailsMap.put("deptId", deptId);
		patientDetailsMap.put("hospitalId", hospitalId);
		patientDetailsMap.put("inpatientId", inpatientId);
		patientDetailsMap.put("adNo", adNo);
		patientDetailsMap.put("flagJsp", flagJsp);
		map = adtHandlerService.showExpiryDetails(patientDetailsMap);

		if (flagJsp.equalsIgnoreCase("popup")) {
			map.put("message", message);
			jsp = "expiryDetails";
			return new ModelAndView(jsp, "map", map);
		} else {
			jsp = "expiryDetails";
			jsp += ".jsp";
			map.put("message", message);
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
	}

	public ModelAndView getDischargeScreen(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside getDischargeScreen ");
		Map<String, Object> map = new HashMap<String, Object>();
		int inpatientId = 0;
		String adNo = "";
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("users");
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String ambulanceStatus = "";
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Inpatient> inpatientTempList = new ArrayList<Inpatient>();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Map<String, Object> patientDiagnosisMap = new HashMap<String, Object>();
		if (request.getParameter("parent") != null) {
			inpatientId = Integer.parseInt(request.getParameter("parent"));
			mapForDs.put("inpatientId", inpatientId);
		}
		mapForDs.put("user", user);
		mapForDs.put(HOSPITAL_ID, hospitalId);

		patientMap = adtHandlerService.getPatientDetailsForDischarge(mapForDs);
		if (patientMap.get("inpatientList") != null) {
			inpatientList = (List<Inpatient>) patientMap.get("inpatientList");
		}
		if (patientMap.get("inpatientTempList") != null) {
			inpatientTempList = (List<Inpatient>) patientMap.get("inpatientTempList");
		}

		if ((inpatientList.size() > 0) || inpatientId != 0) {
			detailsMap = adtHandlerService.getDischargeDetails(hospitalId, inpatientId);
			patientDiagnosisMap = adtHandlerService.getPatientDiagnosis(adNo, inpatientId);
			ambulanceStatus = adtHandlerService.getAmbulanceStatus(inpatientId);
			map.put("ambulanceStatus", ambulanceStatus);
			map.put("patientDiagnosisMap", patientDiagnosisMap);
			jsp = DISCHARGE_BY_HIN_NO_JSP + ".jsp";
		}
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView getTransferScreen(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside getTransferScreen ");
		Map<String, Object> map = new HashMap<String, Object>();
		String message = "";
		int inpatientId = 0;
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Transfer> transferListForDuplicate = new ArrayList<Transfer>();

		HttpSession session = request.getSession();
		int hospitalId = 0;

		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter("parent") != null) {
			inpatientId = Integer.parseInt(request.getParameter("parent"));
		}
		int deptId = (Integer) session.getAttribute(DEPT_ID);
		mapForDs.put(DEPT_ID, deptId);
		mapForDs.put("inpatientId", inpatientId);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		patientMap = adtHandlerService.getPatientDetailsForTransfer(mapForDs);
		String jsp = "";
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		if (patientMap.get("inpatientList") != null) {
			inpatientList = (List<Inpatient>) patientMap.get("inpatientList");
		}

		if ((inpatientList.size() > 0) || inpatientId != 0) {
			detailsMap = adtHandlerService.getTransferDetails(hospitalId, deptId, inpatientId);
			if (detailsMap.get("transferListForDuplicate") != null) {
				transferListForDuplicate = (List<Transfer>) detailsMap.get("transferListForDuplicate");
			}
			if (transferListForDuplicate.size() > 0) {
				message = "Transfer request of this patient is pending";
			}
		}
		jsp = TRANSFER_BY_HIN_NO_JSP + ".jsp";
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printExpiryDetails(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside printExpiryDetails ");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int inpatientId = 0;
		Map<String, Object> parameters = new HashMap<String, Object>();
		String reportName = "d_certificate";
		if (request.getParameter("inpatientId") != null) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		dataMap.put("inpatientId", inpatientId);
		detailsMap = adtHandlerService.printExpiryDetails(dataMap);
		parameters.put("inpatientId", inpatientId);
		HMSUtil.generateReport(reportName, parameters, (Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView showSearchPopup(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showSearchPopup ");
		Map<String, Object> map = new HashMap<String, Object>();
		map = adtHandlerService.getDetailsForSearch();
		jsp = SEARCH_POPUP;
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchUpdatePatientDischarge(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside searchUpdatePatientDischarge ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();

		String serviceNo = "";
		String hinNo = "";
		int serviceTypeId = 0;
		int rankId = 0;
		int unitId = 0;
		String serPersonFName = "";
		String serPersonMName = "";
		String serPersonLName = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		String adNo = "";
		int inpatientId = 0;
		try {
			if (request.getParameter(AD_NO) != null && !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(HIN_NO) != null && !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(SERVICE_NO) != null && !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(SERVICE_TYPE_ID) != null && !(request.getParameter(SERVICE_TYPE_ID).equals("0"))) {
				serviceTypeId = Integer.parseInt(request.getParameter(SERVICE_TYPE_ID));
				mapForDs.put("serviceTypeId", serviceTypeId);
			}
			if (request.getParameter(RANK_ID) != null && !(request.getParameter(RANK_ID).equals(""))) {
				rankId = Integer.parseInt(request.getParameter(RANK_ID));
				mapForDs.put("rankId", rankId);
			}
			if (request.getParameter(UNIT_ID) != null && !(request.getParameter(UNIT_ID).equals("0"))) {
				unitId = Integer.parseInt(request.getParameter(UNIT_ID));
				mapForDs.put("unitId", unitId);
			}
			if (request.getParameter(S_FIRST_NAME) != null && !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(S_MIDDLE_NAME) != null && !(request.getParameter(S_MIDDLE_NAME).equals(""))) {
				serPersonMName = request.getParameter(S_MIDDLE_NAME);
				mapForDs.put("serPersonMName", serPersonMName);
			}
			if (request.getParameter(S_LAST_NAME) != null && !(request.getParameter(S_LAST_NAME).equals(""))) {
				serPersonLName = request.getParameter(S_LAST_NAME);
				mapForDs.put("serPersonLName", serPersonLName);
			}
			if (request.getParameter(P_FIRST_NAME) != null && !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(P_MIDDLE_NAME) != null && !(request.getParameter(P_MIDDLE_NAME).equals(""))) {
				patientMName = request.getParameter(P_MIDDLE_NAME);
				mapForDs.put("patientMName", patientMName);
			}
			if (request.getParameter(P_LAST_NAME) != null && !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDs.put("patientLName", patientLName);
			}
			if (request.getParameter("inpatientId") != null) {
				inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
				mapForDs.put("inpatientId", inpatientId);
			}
		} catch (Exception e) {
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
		}

		patientMap = adtHandlerService.searchPatientDischarge(mapForDs);
		map = adtHandlerService.getDetailsForSearch();
		String jsp = "";
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();

		if (patientMap.get("inpatientList") != null) {
			inpatientList = (List<Inpatient>) patientMap.get("inpatientList");
		}
		map.put("inpatientList", inpatientList);
		map.put("contentJsp", jsp);
		jsp = SEARCH_POPUP;
		return new ModelAndView(jsp, "map", map);

	}

	public void checkCancelAdmissionState(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside checkCancelAdmissionState ");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String inpatientId = "";
		String cancelState = "no";
		if (request.getParameter("inpatientId") != null) {
			inpatientId = (request.getParameter("inpatientId"));
		}
		dataMap.put("inpatientId", inpatientId);
		map = adtHandlerService.checkCancelAdmissionState(dataMap);
		if (map.get("cancelState") != null) {
			cancelState = "" + map.get("cancelState");
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");

		sb.append("<cancelState>" + cancelState + "</cancelState>");

		sb.append("</item>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");

		try {
			response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (IOException ioException) {
			LOGGER.error("Error while writing to printwriter" + ioException.getStackTrace().toString());
		}
	}

	public ModelAndView showTransferRegReportJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showTransferRegReportJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		map = adtHandlerService.getServiceTypeDepartmentCategory();

		jsp = TRANSFER_REG_REPORT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printTransferRegReport(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside printTransferRegReport ");
		Date fromDate = new Date();
		Date toDate = new Date();
		int departmentId1 = 0;
		int departmentId2 = 0;
		String stringVariable = "";
		Map<String, Object> parameters = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
		if (!request.getParameter(DEPARTMENT_ID).equals("0") && request.getParameter(DEPARTMENT_ID) != null) {
			departmentId1 = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			stringVariable = " and transfer.from_ward_id=" + departmentId1;
		}
		if (!request.getParameter(DEPARTMENT_ID_TEMP).equals("0") && request.getParameter(DEPARTMENT_ID_TEMP) != null) {
			departmentId2 = Integer.parseInt(request.getParameter(DEPARTMENT_ID_TEMP));
			stringVariable = stringVariable + " and transfer.to_ward_id=" + departmentId2;
		}
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = adtHandlerService.getConnectionForReport();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("stringVariable", stringVariable);
		HMSUtil.generateReport("TransferReg", parameters, (Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	/**
	 * ------------- Month wise MLC Case Report ------------- added by Priyanka
	 * 
	 * @return
	 */
	public ModelAndView showMonthlyMlcCoseJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showMonthlyMlcCoseJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		jsp = "monthlyMLCCasesReport";

		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showMonthlyMlcCaseReport(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showMonthlyMlcCaseReport ");
		HttpSession session = request.getSession();
		Date fromDate = new Date();
		Date toDate = new Date();
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = adtHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("FROM_DATE", fromDate);
		parameters.put("TO_DATE", toDate);
		parameters.put("HOSPITAL_ID", hospitalId);
		String hin_name = "";
		hin_name = properties.getProperty("com.jkt.hms.registration_no");
		parameters.put("hin_name", hin_name);
		HMSUtil.generateReport("monthwiseMlcCasesReport", parameters, (Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView showPatientStaticsReportJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showPatientStaticsReportJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		jsp = "PatientStaticsReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPatientStaticsReportCaseJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showPatientStaticsReportCaseJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		jsp = "patientStaticsCaseWise";

		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView printPatientStaticsReport(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside printPatientStaticsReport ");
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		int hospitalId = 0;
		String hospitalName = "";
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		HttpSession session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
		map = adtHandlerService.getHospitalParameterDetails(hospitalId);
		if (map.get("hospitalList") != null) {
			hospitalList = (List<MasHospital>) map.get("hospitalList");
		}
		if (hospitalList != null && hospitalList.size() > 0) {
			hospitalName = hospitalList.get(0).getHospitalName();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = adtHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("hospitalName", hospitalName);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("HOSPITAL_ID", hospitalId);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		HMSUtil.generateReport("Patientstatistics", parameters, (Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView printPatientStaticsReportCase(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside printPatientStaticsReportCase ");
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		int hospitalId = 0;
		String hospitalName = "";
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		HttpSession session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
		map = adtHandlerService.getHospitalParameterDetails(hospitalId);
		if (map.get("hospitalList") != null) {
			hospitalList = (List<MasHospital>) map.get("hospitalList");
		}
		if (hospitalList != null && hospitalList.size() > 0) {
			hospitalName = hospitalList.get(0).getHospitalName();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = adtHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("hospitalName", hospitalName);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		HMSUtil.generateReport("PatientstatisticsCase", parameters, (Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView showInPatientStaticsReportJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showInPatientStaticsReportJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		jsp = "InPatientStaticsReport";

		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView printInPatientStaticsReport(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside printInPatientStaticsReport ");
		int hospitalId = 0;
		String hospitalName = "";
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		HttpSession session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map = adtHandlerService.getHospitalParameterDetails(hospitalId);
		if (map.get("hospitalList") != null) {
			hospitalList = (List<MasHospital>) map.get("hospitalList");
		}
		if (hospitalList != null && hospitalList.size() > 0) {
			hospitalName = hospitalList.get(0).getHospitalName();
		}
		Date fromDate = new Date();

		Date toDate = new Date();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}

		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = adtHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(FROM_DATE, fromDate);
		parameters.put("hospitalName", hospitalName);
		parameters.put(TO_DATE, toDate);
		parameters.put("HOSPITAL_ID", hospitalId);
		HMSUtil.generateReport("InPatientStatistics", parameters, (Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView showVillageWiseStaticsReportJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showVillageWiseStaticsReportJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetails = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();

		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		mapDetails.put("hospitalId", hospitalId);
		map = adtHandlerService.showVillageWiseStaticsReportJsp(mapDetails);
		String jsp = "";
		jsp = "villageStaticsReport";

		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView printVillageStaticsReport(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside printVillageStaticsReport ");
		int hospitalId = 0;
		String hospitalName = "";
		String reportName = "";
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		HttpSession session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map = adtHandlerService.getHospitalParameterDetails(hospitalId);
		if (map.get("hospitalList") != null) {
			hospitalList = (List<MasHospital>) map.get("hospitalList");
		}
		if (hospitalList != null && hospitalList.size() > 0) {
			hospitalName = hospitalList.get(0).getHospitalName();
		}
		Date fromDate = new Date();

		Date toDate = new Date();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}

		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}

		if (request.getParameter("reportName") != null && !(request.getParameter("reportName").equals(""))) {
			reportName = (request.getParameter("reportName"));
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = adtHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(FROM_DATE, fromDate);
		parameters.put("hospitalName", hospitalName);
		parameters.put(TO_DATE, toDate);
		parameters.put("HOSPITAL_ID", hospitalId);
		HMSUtil.generateReport(reportName, parameters, (Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	/**
	 * ------------- IP Discharge Register Report ------------- added by
	 * Rajendra
	 * 
	 * @return
	 */
	public ModelAndView showIpDischargeRegisterJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showIpDischargeRegisterJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";

		map = adtHandlerService.getServiceTypeDepartmentCategory();

		jsp = IP_DISCHARGE_REGISTER;

		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printIPDischargeRegister(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside printIPDischargeRegister ");
		Date fromDate = new Date();
		Date toDate = new Date();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int deptId = 0;
		String query = "";

		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}

		if (!request.getParameter(DEPARTMENT_ID).equals("0")) {
			deptId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			query = " and inpatient.department_id=" + deptId;
		}

		try {
			// Added by Arbind on 08-03-2017
			detailsMap = adtHandlerService.getConnectionForReport();
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("fromDate", fromDate);
			parameters.put("toDate", toDate);
			parameters.put("query", query);
			parameters.put("HOSPITAL_ID", hospitalId);
			HMSUtil.generateReport("IpDischargeRegister", parameters, (Connection) detailsMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
		}
		return null;
	}

	public ModelAndView showUpdateOPMlcJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showUpdateOPMlcJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "updateOPMlcCaseSearch.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showUpdateIPMlcJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showUpdateIPMlcJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "updateIPMlcCaseSearch.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showUpdateMedicoLegalCaseDetails(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showUpdateMedicoLegalCaseDetails ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int hospitalId = 0;
		Box box = HMSUtil.getBox(request);

		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		map = adtHandlerService.getMlcDetailsForUpdate(box);
		detailsMap = adtHandlerService.getDetailsForMLC(hospitalId);
		jsp = "updateMedicoLegalCase.jsp";
		map.put("flag", box.getString("flag"));
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateMLCDetails(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside updateMLCDetails ");
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		box.put("userId", userId);
		boolean mlcFlag = adtHandlerService.updateMLCDetails(box);
		String message = "";
		if (mlcFlag == true) {
			if (request.getParameter("flag").equals("ipMlc")) {
				message = "MLC Information has been updated successfully";

			} else if (request.getParameter("flag").equals("opMlc")) {
				message = "MLC Information has been added successfully.";
			}
		} else {
			message = "Some Error Occurred. ";

		}
		jsp = MESSAGE_FOR_ADT_JSP + ".jsp";
		map.put("tempFlag", "yes");
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAppointmentPatientJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showAppointmentPatientJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		map = adtHandlerService.showAppointmentPatientJsp();
		jsp = PATIENTS_APPOINTMENT_JSP;
		jsp += ".jsp";
		String title = " Patient Appointments for Registration and visit";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showDiagnosisWisePatientJsp(HttpServletRequest request, HttpServletResponse response) {
		LOGGER.debug("Inside showDiagnosisWisePatientJsp ");
		Map<String, Object> map = new HashMap<String, Object>();

		jsp = "diagnosisWisePatientJsp";
		jsp += ".jsp";
		String title = " Disease Wise Patint List";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printDiseaseWisePatientReport(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside printDiseaseWisePatientReport ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		HttpSession session = request.getSession();
		String diseaseWise = "";
		String diseaseWise1 = "";
		String toDate = "";
		String fromDate = "";
		String query = "";
		int checked = 0;
		String age1 = null;
		String age = null;
		if (request.getParameter("diseaseWise") != null && !request.getParameter("diseaseWise").equals("")) {
			diseaseWise = request.getParameter("diseaseWise").trim();

			Integer index1 = diseaseWise.lastIndexOf("[") + 1;
			int index2 = diseaseWise.lastIndexOf("]");
			diseaseWise1 = diseaseWise.substring(index1, index2);
		}
		try {
			int hospitalId = 0;
			String hospitalName = "";
			String hospitalAddress = "";
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
			}
			map = adtHandlerService.getHospitalParameterDetails(hospitalId);
			if (map.get("hospitalList") != null) {
				hospitalList = (List<MasHospital>) map.get("hospitalList");
			}
			if (hospitalList != null && hospitalList.size() > 0) {
				hospitalName = hospitalList.get(0).getHospitalName();
			}
			if (hospitalList != null && hospitalList.size() > 0) {
				hospitalAddress = hospitalList.get(0).getAddress();
			}
			if (request.getParameter(TO_DATE) != null) {
				toDate = request.getParameter(TO_DATE);
			}
			if (request.getParameter(FROM_DATE) != null) {
				fromDate = request.getParameter(FROM_DATE);
			}
			if (request.getParameter("ipd") != null) {
				checked = Integer.parseInt(request.getParameter("ipd"));
			}
			if (request.getParameter("age") != null) {
				age = request.getParameter("age");
			}
			if (request.getParameter("age1") != null) {
				age1 = request.getParameter("age1");
			}
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String date4MySQL1 = formatterOut.format(formatterIn.parse(fromDate));
			String date4MySQL2 = formatterOut.format(formatterIn.parse(toDate));
			java.sql.Date startDate = java.sql.Date.valueOf(date4MySQL1);
			java.sql.Date endDate = java.sql.Date.valueOf(date4MySQL2);

			map = adtHandlerService.getDiseaseId(diseaseWise);
			if (!age.equalsIgnoreCase(null) && age != "") {
				query = " where dic.icd_id =" + diseaseWise1 + "  and dic.add_edit_date>='" + startDate
						+ "'  and dic.add_edit_date<='" + endDate + "' and p.age='" + age + " " + age1 + "'";
			} else if (diseaseWise1 != "") {
				query = " where dic.icd_id =" + diseaseWise1 + "  and dic.add_edit_date>='" + startDate
						+ "'  and dic.add_edit_date<='" + endDate + "'";
			} else {
				query = " where dic.add_edit_date>='" + startDate + "'  and dic.add_edit_date<='" + endDate + "'";
			}
			parameters.put("query", query);
			parameters.put("startDate", startDate);
			parameters.put("endDate", endDate);
			parameters.put("checked", checked);
			parameters.put("hospitalName", hospitalName);
			parameters.put("hospitalAddress", hospitalAddress);
			parameters.put("icd_id", diseaseWise1);
		} catch (Exception e) {
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
		}

		detailsMap = adtHandlerService.getConnectionForReport();
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		parameters.put("IMAGE_DIR", getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT", getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		HMSUtil.generateReport("diagnosis_wise_report", parameters, (Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView getListForDisease(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside getListForDisease ");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String autoHint = "";
		String itemNameField = "";

		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(itemNameField) != null) {
			autoHint = (request.getParameter(itemNameField));
		}
		dataMap.put("autoHint", autoHint);
		map = adtHandlerService.getListForDisease(dataMap);
		jsp = "resultForAutoCompleteDiagnosis";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showPoliceIntimationJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showPoliceIntimationJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = "policeIntimation" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showTreatmentDischargeCertificateJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showTreatmentDischargeCertificateJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = "treatmentDischargeCertificate" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAccidentRegisterCumWoundCertificateJsp(HttpServletRequest request,
			HttpServletResponse response) {

		LOGGER.debug("Inside showAccidentRegisterCumWoundCertificateJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = "accidentRegisterCumWoundCertificate" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showProformaForRecordingDyingDeclarationJsp(HttpServletRequest request,
			HttpServletResponse response) {

		LOGGER.debug("Inside showProformaForRecordingDyingDeclarationJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = "proformaForRecordingDyingDeclaration" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getMLCNoList(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside getMLCNoList ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String hinNo = "";

		try {

			if (request.getParameter(HIN_NO) != null && !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				detailsMap.put("hinNo", hinNo);
			}

			map = adtHandlerService.getMLCNoList(detailsMap);

			jsp = "responseForMlcNoList";

		} catch (Exception e) {
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
		}

		return new ModelAndView(jsp, "map", map);

	}

	// ------------------------------------------------------------------

	public void generateReportForMLCNo(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside generateReportForMLCNo ");
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		String hospitalName = "";
		int medico_legal_details_id = 0;
		String jasper = "";
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		map = adtHandlerService.getHospitalParameterDetails(hospitalId);
		if (map.get("hospitalList") != null) {
			hospitalList = (List<MasHospital>) map.get("hospitalList");
		}
		if (hospitalList != null && hospitalList.size() > 0) {
			hospitalName = hospitalList.get(0).getHospitalName();
		}
		if (request.getParameter("mlcNo") != null && !request.getParameter("mlcNo").equals("0")) {
			medico_legal_details_id = Integer.parseInt(request.getParameter("mlcNo"));
		} else if (request.getParameter("medicoLegalDetailsId") != null
				&& !request.getParameter("medicoLegalDetailsId").equals("0")) {
			medico_legal_details_id = Integer.parseInt(request.getParameter("medicoLegalDetailsId"));
		}
		if (request.getParameter(JASPER_FILE_NAME) != null) {
			jasper = request.getParameter(JASPER_FILE_NAME);
		}
		String UHID_No = "";
		if (request.getParameter(HIN_NO) != null) {
			UHID_No = request.getParameter(HIN_NO);
			box.put("hinNo", UHID_No);
		}

		LOGGER.debug(" UHID_No==" + UHID_No);
		if (jasper.equalsIgnoreCase("accidentRegisterCumWoundCertificate")) {
			map = adtHandlerService.updateWoundCertificateStatus(box);
		}
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("hospitalId", hospitalId);
		parameters.put("UHID_No", UHID_No);
		parameters.put("medicoLegalDetailsId", medico_legal_details_id);
		parameters.put("medico_legal_details_id", medico_legal_details_id);
		parameters.put("hospitalName", hospitalName);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));

		Map<String, Object> connectionMap = adtHandlerService.getConnectionForReport();

		HMSUtil.generateReport(jasper, parameters, (Connection) connectionMap.get("conn"), response,
				getServletContext());
	}

	@SuppressWarnings("unchecked")
	public ModelAndView getIPNO(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside getIPNO ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String hinNo = "";
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		try {
			if (request.getParameter(HIN_NO) != null && !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				detailsMap.put("hinNo", hinNo);
			}
			if (hospitalId > 0) {
				detailsMap.put("hospitalId", hospitalId);
			}

			List<Object> admissionNoList = new ArrayList<Object>();

			admissionNoList = adtHandlerService.getAdmissionNoList(detailsMap);
			map.put("admissionNoList", admissionNoList);

			jsp = "responseForAdNo";

		} catch (Exception e) {
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
		}
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView showMedicoLegalCaseDetailsNew(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showMedicoLegalCaseDetailsNew ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mlcMap = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> dMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		String flag = "";
		String mlcNo = "";
		int visitId = 0;
		String hin = "";
		int inpId = 0;
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		parameterMap.put("date", date);

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			map.put("flag", flag);
		}
		if (request.getParameter("visitId") != null) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
			parameterMap.put("visitId", visitId);
		}
		if (request.getParameter(HIN_NO) != null) {
			hin = request.getParameter(HIN_NO);
			parameterMap.put("hinNo", hin);
		}
		if (request.getParameter("inpId") != null) {
			inpId = Integer.parseInt(request.getParameter("inpId"));
			parameterMap.put("inpId", inpId);
		}
		dMap = adtHandlerService.showMedicoLegalCaseDetailsNew(parameterMap);

		patientMap = adtHandlerService.getPatientDetails(parameterMap);

		mlcMap = adtHandlerService.getDetailsForMLC(hospitalId);

		mlcNo = adtHandlerService.generateMLCNo(parameterMap);
		map.put("mlcNo", mlcNo);
		jsp = "medico_legal_case_new" + ".jsp";
		map.put("patientMap", patientMap);
		map.put("detailsMap", mlcMap);
		map.put("dMap", dMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public void displayUnitHeadName(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside displayUnitHeadName ");
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalUnitId = 0;
		if (request.getParameter("hospitalUnitId") != null && !(request.getParameter("hospitalUnitId").equals("0"))) {
			hospitalUnitId = Integer.parseInt(request.getParameter("hospitalUnitId"));
			box.put("hospitalUnitId", hospitalUnitId);
		}
		List<HospitalDoctorUnitT> hospitalUnitTList = new ArrayList<HospitalDoctorUnitT>();
		map = adtHandlerService.displayUnitHeadName(box);
		if (map.get("hospitalUnitTList") != null) {
			hospitalUnitTList = (List) map.get("hospitalUnitTList");
		}

		try {
			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			if (hospitalUnitTList.size() > 0) {
				HospitalDoctorUnitT hospitalUnitT = hospitalUnitTList.get(0);
				String empName = "";
				if (hospitalUnitT.getEmployee() != null) {
					empName = hospitalUnitT.getEmployee().getFirstName();

					sb.append("<empName>" + empName + "</empName>");
				} else {
					sb.append("<empName>" + "" + "</empName>");
				}

			}
			sb.append("</item>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (IOException ioException) {
			LOGGER.error("Error while writing to printwriter" + ioException.getStackTrace().toString());
		}
	}

	public ModelAndView checkBedStatus(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside checkBedStatus ");
		Map<String, Object> map = new HashMap<String, Object>();
		int bedId = 0;
		if (request.getParameter("bedId") != null && !request.getParameter("bedId").equals("")) {
			bedId = Integer.parseInt(request.getParameter("bedId"));
		}
		boolean status = false;
		if (bedId != 0) {
			status = adtHandlerService.checkBedStatus(bedId);
		}
		map.put("status", status);
		String jsp = "checkBedStatus";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getIpNo(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside getIpNo ");
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Map<String, Object> details = new HashMap<String, Object>();
		String hinNo = "";
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}

		if (!hinNo.equals("")) {
			details.put("hinNo", hinNo);
		}

		if (hospitalId != 0) {
			details.put("hospitalId", hospitalId);
		}
		map = adtHandlerService.getIpNo(details);
		jsp = "respone_ip_no";
		//
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView generateReportForTrearmentDischargeCertificate(HttpServletRequest request,
			HttpServletResponse response) {

		LOGGER.debug("Inside generateReportForTrearmentDischargeCertificate ");
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int medicoLegalDetailsId = 0;
		String jasper = "";
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		map = adtHandlerService.getHospitalParameterDetails(hospitalId);
		if (request.getParameter(JASPER_FILE_NAME) != null) {
			jasper = request.getParameter(JASPER_FILE_NAME);
		}
		if (request.getParameter("medicoLegalDetailsId") != null
				&& !(request.getParameter("medicoLegalDetailsId").equals(""))) {
			medicoLegalDetailsId = Integer.parseInt(request.getParameter("medicoLegalDetailsId"));
		}
		String UHID_No = "";
		if (request.getParameter(HIN_NO) != null) {
			UHID_No = request.getParameter(HIN_NO);
		}
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("UHID_No", UHID_No);
		parameters.put("medicoLegalDetailsId", medicoLegalDetailsId);

		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));

		Map<String, Object> connectionMap = adtHandlerService.getConnectionForReport();

		HMSUtil.generateReport(jasper, parameters, (Connection) connectionMap.get("conn"), response,
				getServletContext());

		return new ModelAndView("index", "map", map);
	}

	public void checkMotherDetail(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside checkMotherDetail ");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		Box box = HMSUtil.getBox(request);
		String hinNo = "";
		if (request.getParameter("hinNo") != null) {
			hinNo = (request.getParameter("hinNo"));
		}

		box.put("hinNo", hinNo);
		map = adtHandlerService.checkMotherDetail(box);
		patientList = (List<Patient>) map.get("patientList");
		StringBuffer sb = new StringBuffer();

		sb.append("<item>");
		if (patientList.size() > 0) {
		} else {
			sb.append("<msg>" + "No Record Exist" + "</msg>");
		}
		sb.append("</item>");

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (IOException ioException) {
			LOGGER.error("Error while writing to printwriter" + ioException.getStackTrace().toString());
		}

	}

	public String submitAdmissionInformationFromLean(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside submitAdmissionInformationFromLean ");
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = adtHandlerService.saveObject(map, box);
		if (map.get("success") != null) {
			return "success";
		} else {
			return "failure";
		}

	}

	public String dischargePatientFromLean(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside dischargePatientFromLean ");
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = adtHandlerService.dischargePatientFromLean(map, box);
		if (map.get("success") != null) {
			return "success";
		} else {
			return "failure";
		}

	}

	public ModelAndView getMortuaryList(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside getMortuaryList ");
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession httpSession = request.getSession();
		int hospitalId = (Integer) httpSession.getAttribute("hospitalId");
		box.put("hospitalId", hospitalId);
		map = adtHandlerService.pendingMortuaryList(box);
		String jsp = "patient_Mortuary_Waiting_ListJsp";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addMourtaryRegisterDetail(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside addMourtaryRegisterDetail ");
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession httpSession = request.getSession();
		int hospitalId = (Integer) httpSession.getAttribute("hospitalId");
		box.put("hospitalId", hospitalId);
		int empId = 0;
		String empName = "";
		if (httpSession.getAttribute("users") != null) {
			Users users = (Users) httpSession.getAttribute("users");
			empId = users.getEmployee().getId();
			empName = users.getEmployee().getEmployeeName();

		}
		String hospitalCode = "";
		String financialYearDesc = "";
		if (httpSession.getAttribute("hospitalCode") != null) {
			hospitalCode = (String) httpSession.getAttribute("hospitalCode");
		}
		box.put("hospitalCode", hospitalCode);
		if (httpSession.getAttribute("fYearDesc1") != null) {
			financialYearDesc = (String) httpSession.getAttribute("fYearDesc1");
		}
		box.put("financialYearDesc", financialYearDesc);
		map = adtHandlerService.showRegistrationMourtaryListWithoutMLC(box);
		String jsp = "addmortuaryRegisterWithoutMLCJsp";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("empId", empId);
		map.put("empName", empName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitMortuaryRegisterWithoutMLC(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside submitMortuaryRegisterWithoutMLC ");
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession httpSession = request.getSession();
		Box box = HMSUtil.getBox(request);
		String hospitalCode = "";
		String financialYearDesc = "";
		int hospitalId = (Integer) httpSession.getAttribute("hospitalId");
		box.put("hospitalId", hospitalId);
		if (httpSession.getAttribute("hospitalCode") != null) {
			hospitalCode = (String) httpSession.getAttribute("hospitalCode");
		}
		box.put("hospitalCode", hospitalCode);
		if (httpSession.getAttribute("fYearDesc1") != null) {
			financialYearDesc = (String) httpSession.getAttribute("fYearDesc1");
		}
		box.put("financialYearDesc", financialYearDesc);
		map = adtHandlerService.submitMortuaryRegister(box);
		boolean flag = true;
		if (map.get("flag") != null) {
			flag = (Boolean) map.get("flag");
		}
		String msg = "";

		if (box.getString("flagStatus").equalsIgnoreCase("save")) {
			LOGGER.debug("fffffffffffffffffffff");
			msg = "Record Saved Successfully";
			map = adtHandlerService.showRegistrationMourtaryListWithoutMLC(box);
			jsp = "addmortuaryRegisterWithoutMLCJsp";
			jsp += ".jsp";
		} else {
			if (flag) {
				msg = "Record Saved Successfully";
			} else {
				msg = "Records Not Added/Updated!... Try Again.....";
				map.put("messageType", "failure");
			}

			jsp = "msgForMlc";
			jsp += ".jsp";
		}
		String title = "CAUSE OF DEATH";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("msg", msg);
		return new ModelAndView("index", "map", map);
	}

	// added by amit das on 23-05-2016
	public ModelAndView showOPNominalRegisterJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showOPNominalRegisterJsp ");
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitaId = (Integer) session.getAttribute(HOSPITAL_ID);
		String jsp = "";

		map = adtHandlerService.populateOPNominalRegister(hospitaId);
		jsp = OP_NOMINAL_REGISTER;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	// added by amit das on 23-05-2016
	public ModelAndView printOPNominalRegister(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside printOPNominalRegister ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		String qry="";
		Date fromDate = new Date();
		Date toDate = new Date();
		String fromTime = "";
		String toTime = "";
		int hospitalId = 0;
		int deptId = 0;
		long fromAge = -1;
		long toAge = -1;
		String fromAgeType = null;
		String toAgeType = null;
		int sexId = 0;
		int schemeId = 0;
		BigDecimal fromMonthlyIncome = null;
		BigDecimal toMonthlyIncome = null;
		int patientTypeId = 0;
		String bplStatus = null;
		int serviceCentreId = 0;
		int employeeId=0;
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
		if (request.getParameter("visitType") != null && request.getParameter("visitType").equalsIgnoreCase("Appointment") ) {
			parameters.put("visitType", "A");
		}
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
		// added by arbind on 03-02-2017
		if (request.getParameter("fromTime") != null) {
			fromTime = request.getParameter("fromTime");
			parameters.put("fromTime", fromTime);
		}
		if (request.getParameter("toTime") != null) {
			toTime = request.getParameter("toTime");
			parameters.put("toTime", toTime);
		}
		// added by arbind on 03-02-2017 end
		if (!request.getParameter(DEPARTMENT_ID).equals("")) {
			deptId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			parameters.put("deptId", deptId);
		}
		// added by govind 18-11-2016

		String fromAgeP = "", toAgeP = "", monthIncom1 = "", monthIncom2 = "";
		if (request.getParameter("fromAge") != null && !request.getParameter("fromAge").equals("")) {
			fromAge = Long.parseLong(request.getParameter("fromAge"));
			fromAgeP = request.getParameter("fromAge");
			if (request.getParameter("fromAgeType") != null) {
				fromAgeType = request.getParameter("fromAgeType");
				if (fromAgeType.equalsIgnoreCase("years")) {
					fromAge = fromAge * 365 + (fromAge / 4);
				} else if (fromAgeType.equalsIgnoreCase("months")) {
					fromAge = fromAge * 30;
				}
				parameters.put("fromAge", fromAge);
			}
		}

		if (request.getParameter("toAge") != null && !request.getParameter("toAge").equals("")) {
			toAge = Long.parseLong(request.getParameter("toAge"));
			toAgeP = request.getParameter("toAge");
			if (request.getParameter("toAgeType") != null) {
				toAgeType = request.getParameter("toAgeType");
				if (toAgeType.equalsIgnoreCase("years")) {
					toAge = toAge * 365 + 364 + (toAge / 4);
				} else if (toAgeType.equalsIgnoreCase("months")) {
					toAge = toAge * 30 + 29;
				}
				parameters.put("toAge", toAge);
			}
		}

		if (!request.getParameter(SCHEME_ID).equals("")) {
			schemeId = Integer.parseInt(request.getParameter(SCHEME_ID));
			parameters.put(SCHEME_ID, schemeId);
		}

		if (!request.getParameter(SEX_ID).equals("")) {
			sexId = Integer.parseInt(request.getParameter(SEX_ID));
			parameters.put(SEX_ID, sexId);
		}

		if (!request.getParameter("fromMonthlyIncome").equals("")) {
			monthIncom1 = (String) request.getParameter("fromMonthlyIncome");
			fromMonthlyIncome = new BigDecimal((String) request.getParameter("fromMonthlyIncome"));
			parameters.put("fromMonthlyIncome", fromMonthlyIncome);
		}

		if (!request.getParameter("toMonthlyIncome").equals("")) {
			monthIncom2 = (String) request.getParameter("toMonthlyIncome");
			toMonthlyIncome = new BigDecimal((String) request.getParameter("toMonthlyIncome"));
			parameters.put("toMonthlyIncome", toMonthlyIncome);
		}

		if (!request.getParameter(PATIENT_TYPE_ID).equals("")) {
			patientTypeId = Integer.parseInt(request.getParameter(PATIENT_TYPE_ID));
			parameters.put(PATIENT_TYPE_ID, patientTypeId);
		}

		if (!request.getParameter("employeeId").equals("0")) {
			employeeId = Integer.parseInt(request.getParameter("employeeId"));
			qry = " and me.employee_id=" + employeeId;
		}
		parameters.put("qry", qry);

		String BPLString = "";
		if (request.getParameter(BPL_STATUS) != null) {
			bplStatus = (String) request.getParameter(BPL_STATUS);
			parameters.put(BPL_STATUS, bplStatus);
			BPLString = "BPL";
		}
		//Added by Arbind on 16-12-2017
		if (request.getParameter("serviceCentreId") != null && !request.getParameter("serviceCentreId").equals("")) {
			serviceCentreId = Integer.parseInt(request.getParameter("serviceCentreId"));
			parameters.put("serviceCentreId", serviceCentreId);
		}

		LOGGER.debug("govin code start");
		LOGGER.debug("govin sexId " + sexId + " schemeId " + schemeId + " deptId " + deptId + " patientTypeId "
				+ patientTypeId);
		// added by govind 18-11-2016
		String serviceCenter = "", gender = "", scheme = "", socialCategory = "" , serviceCentreName = "";
		detailsMap.put("sexId", sexId);
		detailsMap.put("schemeId", schemeId);
		detailsMap.put("deptId", deptId);
		detailsMap.put("patientTypeId", patientTypeId);
		detailsMap.put("serviceCentreId", serviceCentreId);

		map = adtHandlerService.getHeaderDetails(detailsMap);

		if (map.get("deptName") != null) {
			serviceCenter = (String) map.get("deptName");
		}
		if (map.get("genName") != null) {
			gender = (String) map.get("genName");
		}
		if (map.get("schemName") != null) {
			scheme = (String) map.get("schemName");
		}
		if (map.get("socialName") != null) {
			socialCategory = (String) map.get("socialName");
		}
		if (map.get("serviceCentreName") != null) {
			serviceCentreName = (String) map.get("serviceCentreName");
		}
		parameters.put("serviceCenter", serviceCenter);
		parameters.put("genderP", gender);
		parameters.put("schemeP", scheme);
		parameters.put("socialCategory", socialCategory);
		parameters.put("fromAgeType", fromAgeType);
		parameters.put("toAgeType", toAgeType);
		parameters.put("BPLString", BPLString);
		parameters.put("fromAgeP", fromAgeP);
		parameters.put("toAgeP", toAgeP);
		parameters.put("monthIncom1", monthIncom1);
		parameters.put("monthIncom2", monthIncom2);
		parameters.put("serviceCentreName", serviceCentreName); //Added by Arbind on 16-12-2017

		// added by govind 18-11-2016

		try {
			detailsMap = adtHandlerService.getConnectionForReport();
			parameters.put("fromDate", fromDate);
			parameters.put("toDate", toDate);
			parameters.put(HOSPITAL_ID, hospitalId);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));

			
			String flag="1";
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (flag.equals("1"))
			{

				HMSUtil.generateReport("OpNominalRegister", parameters, (Connection) detailsMap.get("conn"), response,
						getServletContext());
			}

			else if(flag.equals("2")) {
						HMSUtil.generateHTMLReport("OpNominalRegister", parameters, (Connection) detailsMap.get("conn"), response,
								getServletContext());
			}
		} catch (Exception e) {
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
		}
		return null;
	}

	// added by amit das on 25-05-2016
	public ModelAndView showOPClinicalRegisterJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showOPClinicalRegisterJsp ");
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitaId = (Integer) session.getAttribute(HOSPITAL_ID);
		String jsp = "";

		map = adtHandlerService.populateOPClinicalRegister(hospitaId);

		jsp = OP_CLINICAL_REGISTER;

		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	// added by amit das on 25-05-2016
	public ModelAndView printOPClinicalRegister(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside printOPClinicalRegister ");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		HttpSession session = request.getSession();

		Date fromDate = new Date();
		Date toDate = new Date();
		int hospitalId = 0;
		int deptId = 0;
		int serviceCentreId = 0;
		String stringVariable = "";
		String stringVariableDep = "";

		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
		// added by arbind on 04-02-2017 end
		if (!request.getParameter(DEPARTMENT_ID).equals("")) {
			deptId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			parameters.put("deptId", deptId);
			stringVariable += " and mdp.emp_dept_id =" + deptId;
			stringVariableDep += " and md.emp_dept_id =" + deptId;
		}
		if (request.getParameter("serviceCentreId") != null && !request.getParameter("serviceCentreId").equals("")) {
			serviceCentreId = Integer.parseInt(request.getParameter("serviceCentreId"));
			stringVariable += " and v.department_id =" + serviceCentreId;
			stringVariableDep += " and md.department_id =" + serviceCentreId;
		}

		try {
			detailsMap = adtHandlerService.getConnectionForReport();
			parameters.put("fromDate", fromDate);
			parameters.put("toDate", toDate);
			parameters.put("hospitalId", hospitalId);
			parameters.put("stringVariable", stringVariable);
			parameters.put("stringVariableDep", stringVariableDep);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
			


			
			
			String flag="1";
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (flag.equals("1"))
			{
				HMSUtil.generateReport("OpClinicalRegister", parameters, (Connection) detailsMap.get("conn"), response,
						getServletContext());
			}

			else if(flag.equals("2")) {
						HMSUtil.generateHTMLReport("OpClinicalRegister", parameters, (Connection) detailsMap.get("conn"), response,
								getServletContext());
			}

		} catch (Exception e) {
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
		}
		return null;
	}

	// added by amit das on 31-05-2016
	public ModelAndView showOPDStatisticsJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showOPDStatisticsJsp ");
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitaId = (Integer) session.getAttribute(HOSPITAL_ID);
		String jsp = "";

		map = adtHandlerService.populateOPClinicalRegister(hospitaId);
		jsp = OPD_STATISTICS;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	// added by amit das on 31-05-2016
	public ModelAndView printOPDStatistics(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside printOPDStatistics ");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		HttpSession session = request.getSession();

		Date fromDate = new Date();
		Date toDate = new Date();
		String fromTime = "";
		String toTime = "";
		int hospitalId = 0;
		int deptId = 0;
		int patientTypeId = 0;
		int serviceCentreId = 0;

		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
		// added by arbind on 04-02-2017
		if (request.getParameter("fromTime") != null) {
			fromTime = request.getParameter("fromTime");
		}
		if (request.getParameter("toTime") != null) {
			toTime = request.getParameter("toTime");
		}
		// added by arbind on 04-02-2017 end
		if (!request.getParameter(DEPARTMENT_ID).equals("")) {
			deptId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter("serviceCentreId") != null && !request.getParameter("serviceCentreId").equals("")) {
			serviceCentreId = Integer.parseInt(request.getParameter("serviceCentreId"));
		}

		if (request.getParameter(PATIENT_TYPE_ID) != null && !request.getParameter(PATIENT_TYPE_ID).equals("")) {
			patientTypeId = Integer.parseInt(request.getParameter(PATIENT_TYPE_ID));
			parameters.put(PATIENT_TYPE_ID, patientTypeId);
		}

		try {
			detailsMap = adtHandlerService.getConnectionForReport();
			parameters.put("fromDate", fromDate);
			parameters.put("toDate", toDate);
			parameters.put("fromTime", fromTime);
			parameters.put("toTime", toTime);
			parameters.put(HOSPITAL_ID, hospitalId);
			parameters.put("deptId", deptId);
			parameters.put("serviceCentreId", serviceCentreId);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
			
			String flag="1";
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
if (flag.equals("1"))
{
	HMSUtil.generateReport("OpdStatistics", parameters, (Connection) detailsMap.get("conn"), response,
			getServletContext());
}

else if(flag.equals("2")) {
			HMSUtil.generateHTMLReport("OpdStatistics", parameters, (Connection) detailsMap.get("conn"), response,
					getServletContext());
}
		} catch (Exception e) {
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
		}
		return null;
	}

	// added by amit das on 31-05-2016
	public ModelAndView showHospitalServiceUlilizationReportJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showHospitalServiceUlilizationReportJsp ");
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitaId = (Integer) session.getAttribute(HOSPITAL_ID);
		String jsp = "";

		map = adtHandlerService.populateOPClinicalRegister(hospitaId);
		jsp = "hospitalServiceUlilizationReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	// added by amit das on 31-05-2016
	public ModelAndView printHospitalServiceUlilization(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside printHospitalServiceUlilization ");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		HttpSession session = request.getSession();

		Date fromDate = new Date();
		Date toDate = new Date();
		int hospitalId = 0;
		int deptId = 0;

		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}

		if (!request.getParameter(DEPARTMENT_ID).equals("")) {
			deptId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			parameters.put("deptId", deptId);
		}

		try {
			detailsMap = adtHandlerService.getConnectionForReport();
			parameters.put("fromDate", fromDate);
			parameters.put("toDate", toDate);
			parameters.put(HOSPITAL_ID, hospitalId);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));

			HMSUtil.generateReport("hospital_service_ulilization_report", parameters,
					(Connection) detailsMap.get("conn"), response, getServletContext());

		} catch (Exception e) {
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
		}
		return null;
	}

	// added by amit das on 10-12-2016
	public void submitMobileNumberForOTP(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside submitMobileNumberForOTP ");
		Box box = HMSUtil.getBox(request);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = adtHandlerService.submitMobileNumberForOTP(box);
		String responseMsg = "1";
		if (detailsMap.get("msg") != null) {
			responseMsg = (String) detailsMap.get("msg");
		}

		try {
			response.getWriter().write(responseMsg);
		} catch (IOException ioException) {
			LOGGER.error("Error while writing to printwriter" + ioException.getStackTrace().toString());
		}

	}

	// added by amit das on 10-12-2016
	public void sendSMSForAppointmentDetails(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside sendSMSForAppointmentDetails ");
		Box box = HMSUtil.getBox(request);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = adtHandlerService.sendSMSForAppointmentDetails(box);
		String responseMsg = "1";
		if (detailsMap.get("msg") != null) {
			responseMsg = (String) detailsMap.get("msg");
		}

		try {
			response.getWriter().write(responseMsg);
		} catch (IOException ioException) {
			LOGGER.error("Error while writing to printwriter" + ioException.getStackTrace().toString());
		}

	}

	// added by amit das on 10-12-2016
	public void sendRegistrationConfirmMessage(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside sendRegistrationConfirmMessage ");
		Box box = HMSUtil.getBox(request);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = adtHandlerService.sendRegistrationConfirmMessage(box);
		String responseMsg = "1";
		if (detailsMap.get("msg") != null) {
			responseMsg = (String) detailsMap.get("msg");
		}

		try {
			response.getWriter().write(responseMsg);
		} catch (IOException ioException) {
			LOGGER.error("Error while writing to printwriter" + ioException.getStackTrace().toString());
		}

	}

	// added by amit das on 10-12-2016
	public void sendAppointmentCancellationMessage(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside sendAppointmentCancellationMessage ");
		Box box = HMSUtil.getBox(request);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = adtHandlerService.sendAppointmentCancellationMessage(box);
		String responseMsg = "1";
		if (detailsMap.get("msg") != null) {
			responseMsg = (String) detailsMap.get("msg");
		}

		try {
			response.getWriter().write(responseMsg);
		} catch (IOException ioException) {
			LOGGER.error("Error while writing to printwriter" + ioException.getStackTrace().toString());
		}
	}
	
	// Added by Arbind 11-12-2017
	public ModelAndView showDailyVisitReportJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showDailyVisitReportJsp ");
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitaId = (Integer) session.getAttribute(HOSPITAL_ID);
		String jsp = "";

		map = adtHandlerService.populateDailyVisitReport(hospitaId);
		jsp = "dailyVisitReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	// Added by Arbind 11-12-2017
	@SuppressWarnings("unchecked")
	public ModelAndView getServiceCentreDoctors(HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		int departmentId=0;
		String doctorsDiv = "";

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		box.put("hospitalId",hospitalId);
		if (request.getParameter(DEPARTMENT_ID) != null && !(request.getParameter(DEPARTMENT_ID).equals(""))) {
			departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		box.put("departmentId",departmentId);
		if(request.getParameter("doctorsDiv") != null &&  !request.getParameter("doctorsDiv").equals("")) {
			doctorsDiv = request.getParameter("doctorsDiv");
		}
		map = adtHandlerService.getServiceCentreDoctors(box);
		map.put("doctorsDiv", doctorsDiv);
		jsp = "responseServiceCentreDoctors";

		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getDoctors(HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		int serviceCentreId=0;
		String doctorsDiv = "";

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		box.put("hospitalId",hospitalId);
		if (request.getParameter("serviceCentreId") != null && !(request.getParameter("serviceCentreId").equals("0"))) {
			serviceCentreId = Integer.parseInt(request.getParameter("serviceCentreId"));
		}
		box.put("serviceCentreId",serviceCentreId);
		
		map = adtHandlerService.getDoctors(box);
		
		jsp = "responseDoctors";

		return new ModelAndView(jsp, "map", map);
	}
	

	// Added by Arbind 11-12-2017
	public ModelAndView printDailyVisitReport(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside printOPNominalRegister ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		HttpSession session = request.getSession();

		Date fromDate = new Date();
		Date toDate = new Date();
		String fromTime = "";
		String toTime = "";
		int hospitalId = 0;
		int deptId = 0;
		int serviceCentreId = 0;
		int employeeId = 0;

		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
		if (request.getParameter("fromTime") != null) {
			fromTime = request.getParameter("fromTime");
		}
		if (request.getParameter("toTime") != null) {
			toTime = request.getParameter("toTime");
		}
		if (request.getParameter(DEPARTMENT_ID) != null && !request.getParameter(DEPARTMENT_ID).equals("")) {
			deptId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter("serviceCentreId") != null && !request.getParameter("serviceCentreId").equals("")) {
			serviceCentreId = Integer.parseInt(request.getParameter("serviceCentreId"));
		}
		if (request.getParameter("employyeId") != null && !request.getParameter("employyeId").equals("")) {
			employeeId = Integer.parseInt(request.getParameter("employyeId"));
		}

		try {
			detailsMap = adtHandlerService.getConnectionForReport();
			parameters.put("fromDate", fromDate);
			parameters.put("toDate", toDate);
			parameters.put("fromTime", fromTime);
			parameters.put("toTime", toTime);
			parameters.put(HOSPITAL_ID, hospitalId);
			parameters.put("deptId", deptId);
			parameters.put("serviceCentreId", serviceCentreId);
			parameters.put("employeeId", employeeId);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));

			HMSUtil.generateReport("DailyVisitReport", parameters, (Connection) detailsMap.get("conn"), response,
					getServletContext());

		} catch (Exception e) {
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
		}
		return null;
	}

	//Added by Arbind kumar on 08-02-2018
	public ModelAndView showOPConsultationRegisterJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showOPConsultationRegisterJsp ");
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitaId = (Integer) session.getAttribute(HOSPITAL_ID);
		String jsp = "";

		map = adtHandlerService.populateOPNominalRegister(hospitaId);
		jsp = "opConsultationRegister";
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	//Added by Arbind kumar on 08-02-2018
	public ModelAndView printOPConsultationRegister(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside printOPConsultationRegister ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		HttpSession session = request.getSession();

		Date fromDate = new Date();
		Date toDate = new Date();
		String fromTime = "";
		String toTime = "";
		int hospitalId = 0;
		int deptId = 0;
		long fromAge = -1;
		long toAge = -1;
		String fromAgeType = null;
		String toAgeType = null;
		int sexId = 0;
		int schemeId = 0;
		BigDecimal fromMonthlyIncome = null;
		BigDecimal toMonthlyIncome = null;
		int patientTypeId = 0;
		String bplStatus = null;
		int serviceCentreId = 0;

		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
		if (request.getParameter("fromTime") != null) {
			fromTime = request.getParameter("fromTime");
			parameters.put("fromTime", fromTime);
		}
		if (request.getParameter("toTime") != null) {
			toTime = request.getParameter("toTime");
			parameters.put("toTime", toTime);
		}
		if (!request.getParameter(DEPARTMENT_ID).equals("")) {
			deptId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			parameters.put("deptId", deptId);
		}

		String fromAgeP = "", toAgeP = "", monthIncom1 = "", monthIncom2 = "";
		if (request.getParameter("fromAge") != null && !request.getParameter("fromAge").equals("")) {
			fromAge = Long.parseLong(request.getParameter("fromAge"));
			fromAgeP = request.getParameter("fromAge");
			if (request.getParameter("fromAgeType") != null) {
				fromAgeType = request.getParameter("fromAgeType");
				if (fromAgeType.equalsIgnoreCase("years")) {
					fromAge = fromAge * 365 + (fromAge / 4);
				} else if (fromAgeType.equalsIgnoreCase("months")) {
					fromAge = fromAge * 30;
				}
				parameters.put("fromAge", fromAge);
			}
		}

		if (request.getParameter("toAge") != null && !request.getParameter("toAge").equals("")) {
			toAge = Long.parseLong(request.getParameter("toAge"));
			toAgeP = request.getParameter("toAge");
			if (request.getParameter("toAgeType") != null) {
				toAgeType = request.getParameter("toAgeType");
				if (toAgeType.equalsIgnoreCase("years")) {
					toAge = toAge * 365 + 364 + (toAge / 4);
				} else if (toAgeType.equalsIgnoreCase("months")) {
					toAge = toAge * 30 + 29;
				}
				parameters.put("toAge", toAge);
			}
		}

		if (!request.getParameter(SCHEME_ID).equals("")) {
			schemeId = Integer.parseInt(request.getParameter(SCHEME_ID));
			parameters.put(SCHEME_ID, schemeId);
		}

		if (!request.getParameter(SEX_ID).equals("")) {
			sexId = Integer.parseInt(request.getParameter(SEX_ID));
			parameters.put(SEX_ID, sexId);
		}

		if (!request.getParameter("fromMonthlyIncome").equals("")) {
			monthIncom1 = (String) request.getParameter("fromMonthlyIncome");
			fromMonthlyIncome = new BigDecimal((String) request.getParameter("fromMonthlyIncome"));
			parameters.put("fromMonthlyIncome", fromMonthlyIncome);
		}

		if (!request.getParameter("toMonthlyIncome").equals("")) {
			monthIncom2 = (String) request.getParameter("toMonthlyIncome");
			toMonthlyIncome = new BigDecimal((String) request.getParameter("toMonthlyIncome"));
			parameters.put("toMonthlyIncome", toMonthlyIncome);
		}

		if (!request.getParameter(PATIENT_TYPE_ID).equals("")) {
			patientTypeId = Integer.parseInt(request.getParameter(PATIENT_TYPE_ID));
			parameters.put(PATIENT_TYPE_ID, patientTypeId);
		}

		String BPLString = "";
		if (request.getParameter(BPL_STATUS) != null) {
			bplStatus = (String) request.getParameter(BPL_STATUS);
			parameters.put(BPL_STATUS, bplStatus);
			BPLString = "BPL";
		}
		if (request.getParameter("serviceCentreId") != null && !request.getParameter("serviceCentreId").equals("")) {
			serviceCentreId = Integer.parseInt(request.getParameter("serviceCentreId"));
			parameters.put("serviceCentreId", serviceCentreId);
		}

		LOGGER.debug("govin code start");
		LOGGER.debug("govin sexId " + sexId + " schemeId " + schemeId + " deptId " + deptId + " patientTypeId "
				+ patientTypeId);
		String serviceCenter = "", gender = "", scheme = "", socialCategory = "" , serviceCentreName = "";
		detailsMap.put("sexId", sexId);
		detailsMap.put("schemeId", schemeId);
		detailsMap.put("deptId", deptId);
		detailsMap.put("patientTypeId", patientTypeId);
		detailsMap.put("serviceCentreId", serviceCentreId);

		map = adtHandlerService.getHeaderDetails(detailsMap);

		if (map.get("deptName") != null) {
			serviceCenter = (String) map.get("deptName");
		}
		if (map.get("genName") != null) {
			gender = (String) map.get("genName");
		}
		if (map.get("schemName") != null) {
			scheme = (String) map.get("schemName");
		}
		if (map.get("socialName") != null) {
			socialCategory = (String) map.get("socialName");
		}
		if (map.get("serviceCentreName") != null) {
			serviceCentreName = (String) map.get("serviceCentreName");
		}
		parameters.put("serviceCenter", serviceCenter);
		parameters.put("genderP", gender);
		parameters.put("schemeP", scheme);
		parameters.put("socialCategory", socialCategory);
		parameters.put("fromAgeType", fromAgeType);
		parameters.put("toAgeType", toAgeType);
		parameters.put("BPLString", BPLString);
		parameters.put("fromAgeP", fromAgeP);
		parameters.put("toAgeP", toAgeP);
		parameters.put("monthIncom1", monthIncom1);
		parameters.put("monthIncom2", monthIncom2);
		parameters.put("serviceCentreName", serviceCentreName);


		try {
			detailsMap = adtHandlerService.getConnectionForReport();
			parameters.put("fromDate", fromDate);
			parameters.put("toDate", toDate);
			parameters.put(HOSPITAL_ID, hospitalId);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));

			HMSUtil.generateReport("OpConsultationRegister", parameters, (Connection) detailsMap.get("conn"), response,
					getServletContext());

		} catch (Exception e) {
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
		}
		return null;
	}

	//Added by Arbind kumar on 08-02-2018
	public ModelAndView showSkipPatientDetailsJsp(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside showSkipPatientDetailsJsp ");
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";

		jsp = "skipPatientDetails";
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	//Added by Arbind kumar on 08-02-2018
	public ModelAndView printSkipPatientDetails(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.debug("Inside printSkipPatientDetails ");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		HttpSession session = request.getSession();

		Date fromDate = new Date();
		Date toDate = new Date();
		int hospitalId = 0;

		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}

		try {
			detailsMap = adtHandlerService.getConnectionForReport();
			parameters.put("fromDate", fromDate);
			parameters.put("toDate", toDate);
			parameters.put(HOSPITAL_ID, hospitalId);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));

			HMSUtil.generateReport("SkipPatientDetail", parameters, (Connection) detailsMap.get("conn"), response,
					getServletContext());

		} catch (Exception e) {
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
		}
		return null;
	}

	// -------------------------------------------------------------------
	public ADTHandlerService getAdtHandlerService() {
		return adtHandlerService;
	}

	public void setAdtHandlerService(ADTHandlerService adtHandlerService) {
		this.adtHandlerService = adtHandlerService;
	}

	public OpBillingHandlerService getOpBillingHandlerService() {
		return opBillingHandlerService;
	}

	public void setOpBillingHandlerService(OpBillingHandlerService opBillingHandlerService) {
		this.opBillingHandlerService = opBillingHandlerService;
	}

	public AccountHandlerService getAccountHandlerService() {
		return accountHandlerService;
	}

	public void setAccountHandlerService(AccountHandlerService accountHandlerService) {
		this.accountHandlerService = accountHandlerService;
	}

	public BillingHandlerService getBillingHandlerService() {
		return billingHandlerService;
	}

	public void setBillingHandlerService(BillingHandlerService billingHandlerService) {
		this.billingHandlerService = billingHandlerService;
	}

}
