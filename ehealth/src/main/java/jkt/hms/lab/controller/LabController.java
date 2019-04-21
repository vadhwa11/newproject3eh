package jkt.hms.lab.controller;

import static jkt.hms.util.RequestConstants.AD_NO;
import static jkt.hms.util.RequestConstants.AMOUNT;
import static jkt.hms.util.RequestConstants.CHARGE_CODE_ID;
import static jkt.hms.util.RequestConstants.CLINICAL_NOTE;
import static jkt.hms.util.RequestConstants.COLLECTION_CENTER_ID;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.CREATED_BY;
import static jkt.hms.util.RequestConstants.DAILY_BLOOD_COLLECTION_REPORT_JSP;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DEPARTMENT_TYPE_CODE;
import static jkt.hms.util.RequestConstants.DEPARTMENT_WISE_MONTHLY_SUMMARY_JSP;
import static jkt.hms.util.RequestConstants.DG_DIAGNOSTIC_REGISTER_DIAGNOSIS_WISE;
import static jkt.hms.util.RequestConstants.DG_DIAGNOSTIC_REGISTER_DOCTOR_WISE;
import static jkt.hms.util.RequestConstants.DG_INVESTIGATION_ORDER_BOOKING;
import static jkt.hms.util.RequestConstants.DG_MESSAGE_FOR_SAMPLE;
import static jkt.hms.util.RequestConstants.DG_MESSAGE_SAMPLE_COLLECTION;
import static jkt.hms.util.RequestConstants.DG_MSG_FOR_LAB;
import static jkt.hms.util.RequestConstants.DG_OP_ORDER_BOOKING_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.DG_ORDER_DETAIL_ID;
import static jkt.hms.util.RequestConstants.DG_PATIENT_DIAGNOSTIC_REGISTER;
import static jkt.hms.util.RequestConstants.DG_PENDING_SAMPLE_COLLECTION;
import static jkt.hms.util.RequestConstants.DG_PENDING_SAMPLE_VALIDATION;
import static jkt.hms.util.RequestConstants.DG_RESPONSE_FOR_CHARGE_CODE_DETAIL_JSP;
import static jkt.hms.util.RequestConstants.DG_SAMPLE_ACCEPTANCE;
import static jkt.hms.util.RequestConstants.DG_SAMPLE_COLLECTION;
import static jkt.hms.util.RequestConstants.DIAGNOSIS_NO;
import static jkt.hms.util.RequestConstants.EMPLOYEE_ID;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.GROUP_NAME;
import static jkt.hms.util.RequestConstants.GROUP_SEQUENCE;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.INVESTIGATION_ID;
import static jkt.hms.util.RequestConstants.INVESTIGATION_TEMPLATE_REPORT_JSP;
import static jkt.hms.util.RequestConstants.LOGIN_NAME;
import static jkt.hms.util.RequestConstants.MACHINE_NAME;
import static jkt.hms.util.RequestConstants.MAIN_CHARGECODE_ID;
import static jkt.hms.util.RequestConstants.MESSAGE_OREDER_BOOKING;
import static jkt.hms.util.RequestConstants.MONTHLY_SUMMARY_REPORT;
import static jkt.hms.util.RequestConstants.MONTHLY_TEST_RESULT_REPORT;
import static jkt.hms.util.RequestConstants.MSG_FOR_LAB;
import static jkt.hms.util.RequestConstants.ORDER_BOOKING;
import static jkt.hms.util.RequestConstants.ORDER_BOOKING_ID;
import static jkt.hms.util.RequestConstants.ORDER_BOOKING_WARD;
import static jkt.hms.util.RequestConstants.ORDER_NO;
import static jkt.hms.util.RequestConstants.ORDER_STATUS;
import static jkt.hms.util.RequestConstants.ORDER_STATUS_FOR_WARD_MANAGEMENT;
import static jkt.hms.util.RequestConstants.ORDER_STATUS_REPORT_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.PACKING_LIST;
import static jkt.hms.util.RequestConstants.PACKING_LIST_REPORT;
import static jkt.hms.util.RequestConstants.PATIENT_TEST_RESULT_PRINT_REPORT_JSP;
import static jkt.hms.util.RequestConstants.PATIENT_TYPE;
import static jkt.hms.util.RequestConstants.PROVISIONAL_DIAG;
import static jkt.hms.util.RequestConstants.P_FIRST_NAME;
import static jkt.hms.util.RequestConstants.QUANTITY;
import static jkt.hms.util.RequestConstants.REASON;
import static jkt.hms.util.RequestConstants.REPORT_NAME;
import static jkt.hms.util.RequestConstants.ROUTINE;
import static jkt.hms.util.RequestConstants.SAMPLE_COLLECTION_DETAIL_ID;
import static jkt.hms.util.RequestConstants.SAMPLE_ID;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.SEQUENCE_NO;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.STATUS;
import static jkt.hms.util.RequestConstants.SUB_CHARGECODE_ID;
import static jkt.hms.util.RequestConstants.TEST_TYPE;
import static jkt.hms.util.RequestConstants.TOTAL_AMOUNT;
import static jkt.hms.util.RequestConstants.TOTAL_TEST_PERFORMED_REPORT_JSP;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.URGENT_DETAILS;
import static jkt.hms.util.RequestConstants.USER_ID;
import static jkt.hms.util.RequestConstants.VIEW_MULTIPLE_PARAMETER_STATUS;
import static jkt.hms.util.RequestConstants.VIEW_SENSITIVE_STATUS;
import static jkt.hms.util.RequestConstants.VIEW_SINGLE_PARAMETER_STATUS;
import static jkt.hms.util.RequestConstants.VIEW_TEMPLATE_STATUS;
import static jkt.hms.util.RequestConstants.VIEW_TEMPLATE_STATUS_FOR_LAB;
import static jkt.hms.util.RequestConstants.VIEW_TEST_DETAILS_FOR_ORDER_NO;
import static jkt.hms.util.RequestConstants.VIEW_TEST_DETAILS_REPORT_ORDER_STATUS;
import static jkt.hms.util.RequestConstants.VISIT_ID;
import static jkt.hms.util.RequestConstants.VISIT_NUMBER;
import static jkt.hms.util.RequestConstants.WEEKLY_TEST_REPORT;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.billing.handler.BillingHandlerService;
import jkt.hms.lab.handler.LabHandlerService;
import jkt.hms.masters.business.DgHistoSampleCollectionDetails;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgMasInvestigationReportTemplate;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgResultEntryDetail;
import jkt.hms.masters.business.DgResultEntryHeader;
import jkt.hms.masters.business.DgSampleCollectionDetails;
import jkt.hms.masters.business.DgSampleCollectionHeader;
import jkt.hms.masters.business.DgSubMasInvestigation;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmpaneled;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasLionc;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.NursingcareSetup;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientAddress;
import jkt.hms.masters.business.PatientMainLabInfo;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class LabController extends MultiActionController {
	LabHandlerService labHandlerService = null;
	BillingHandlerService billingHandlerService = null;
	private static final Logger logger = org.apache.log4j.Logger.getLogger(LabController.class);

	HttpSession session = null;
	String jsp = "";
	String title = "";
	String url = "";
	String url1 = "";
	String userName = null;
	String message = null;
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	

	// ------------------------Investigation
	// Requation------------------------------------
	public ModelAndView showOrderBookingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		int inPatientId = Integer.parseInt(request.getParameter("parent"));
		String deptName = request.getParameter("deptName");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("inPatientId", inPatientId);
		map.put("deptId", deptId);

		map = labHandlerService.showOrderBookingJsp(map);
		String entrySeqNo = request.getParameter("entrySeqNo");
		entrySeqNo = labHandlerService.getOrderSeqForDisplay("HEN");
		if (entrySeqNo != null) {
			map.put("orderSeqNo", entrySeqNo);
		}
		detailsMap = labHandlerService.getMainAndSubCharge();
		map.put("detailsMap", detailsMap);
		jsp = ORDER_BOOKING;
		jsp += ".jsp";
		title = "OrderBooking";
		map.put("deptName", deptName);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView showOrderBookingOP(HttpServletRequest request,
			HttpServletResponse response) {
		String buttonFlag = "";
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		int visitId = Integer.parseInt(request.getParameter("visitId"));
		String deptName = request.getParameter("deptName");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("visitId", visitId);
		map.put("deptId", deptId);

		if (request.getParameter("buttonFlag") != null) {
			buttonFlag = request.getParameter("buttonFlag");
			int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}

		map = labHandlerService.showOrderBookingOP(map);
		String orderSeqNo = request.getParameter("orderSeqNo");
		orderSeqNo = labHandlerService.getOrderSeqForDisplay("ON");
		if (orderSeqNo != null) {
			map.put("orderSeqNo", orderSeqNo);
		}
		detailsMap = labHandlerService.getMainAndSubCharge();
		map.put("detailsMap", detailsMap);
		jsp = DG_INVESTIGATION_ORDER_BOOKING;
		jsp += ".jsp";
		title = "OrderBooking";
		map.put("deptName", deptName);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	/*
	 * public ModelAndView getChargeCode(HttpServletRequest request,
	 * HttpServletResponse response) { Map<String, Object> map = new
	 * HashMap<String, Object>(); Map<String, Object> parameterMap = new
	 * HashMap<String, Object>(); int subChargeCodeId = 0; int mainChargeCodeId
	 * = 0; String nameField = ""; String autoHint = ""; if
	 * (request.getParameter("requiredField") != null) { nameField =
	 * (request.getParameter("requiredField")); } if
	 * (request.getParameter(nameField) != null) { autoHint =
	 * (request.getParameter(nameField)); }
	 * if(request.getParameter("subChargeCodeId") != null){ subChargeCodeId =
	 * Integer.parseInt(request.getParameter("subChargeCodeId")); }
	 * if(request.getParameter("mainChargeCodeId") != null){ mainChargeCodeId =
	 * Integer.parseInt(request.getParameter("mainChargeCodeId")); }
	 * parameterMap.put("subChargeCodeId", subChargeCodeId);
	 * parameterMap.put("mainChargeCodeId", mainChargeCodeId);
	 * parameterMap.put("autoHint", autoHint);
	 * 
	 * map = labHandlerService.getChargeCode(parameterMap); String jsp = ""; jsp
	 * = "diag_responseForMainChargeCodeGrid"; return new
	 * ModelAndView(jsp,"map",map); }
	 */
	public ModelAndView getChargeCodeForAutoComplete(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		int subChargeCodeId = 0;
		int mainChargeCodeId = 0;
		String nameField = "";
		String autoHint = "";
		String rareCommon = "";
		int orderHdId = 0;
        int hospitalId=0;
		if (request.getParameter("requiredField") != null) {
			nameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(nameField) != null) {
			autoHint = (request.getParameter(nameField));
		}
		if (request.getParameter("subChargeCodeId") != null) {
			subChargeCodeId = Integer.parseInt(request
					.getParameter("subChargeCodeId"));
		}
		if (request.getParameter("mainChargeCodeId") != null) {
			mainChargeCodeId = Integer.parseInt(request
					.getParameter("mainChargeCodeId"));
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt(session.getAttribute(HOSPITAL_ID).toString());
		}
		if (request.getParameter("orderHdId") != null) {
			orderHdId = Integer.parseInt(request.getParameter("orderHdId"));
		}

		if (request.getParameter("rareCommon") != null) {
			rareCommon = request.getParameter("rareCommon");
		}

		parameterMap.put("subChargeCodeId", subChargeCodeId);
		parameterMap.put("mainChargeCodeId", mainChargeCodeId);
		parameterMap.put("rareCommon", rareCommon);
		parameterMap.put("autoHint", autoHint);
		parameterMap.put("orderHdId", orderHdId);
		parameterMap.put("hospitalId", hospitalId);
		map = labHandlerService.getChargeCodeForAutoComplete(parameterMap);

		String jsp = "";
		jsp = "diag_responseForMainChargeCodeGrid";

		return new ModelAndView(jsp, "map", map);
	}

	
	public ModelAndView fillChargeCode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String rowVal = request.getParameter("rowVal");
		String chargeCodeWithId = request.getParameter("chargeCode" + rowVal);
		HttpSession session=request.getSession(); 
		int hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		int hinId = 0;
		if (request.getParameter("hin") != null) {
			hinId = Integer.parseInt(request.getParameter("hin"));

		}

		int index1 = chargeCodeWithId.lastIndexOf("[");
		String chargeCodeName = chargeCodeWithId.substring(0, index1);
		int mainCharge = 0;
		if (request.getParameter("mainCharge") != null
				&& !request.getParameter("mainCharge").equals("")) {
			mainCharge = Integer.parseInt(request.getParameter("mainCharge"));
		}
		if (mainCharge == 19 || mainCharge == 44) {
			map = labHandlerService
					.getChargeCodeDetails1(chargeCodeName, hinId);
		} else {
			map = labHandlerService.getChargeCodeDetails(chargeCodeName, hinId,hospitalId);
		}
		String jsp = "";
		jsp = DG_RESPONSE_FOR_CHARGE_CODE_DETAIL_JSP;

		map.put("rowVal", rowVal);
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView submitOrderBooking(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		int chargeListLength = 0;
		Box box = HMSUtil.getBox(request);
		List chargeList = new ArrayList();
		List qtyList = new ArrayList();
		List amountList = new ArrayList();
		List netAmountList = new ArrayList();
		List mainChargeList = new ArrayList();
		List subChargeList = new ArrayList();
		List sampleDetailIdList = new ArrayList();
		List orderDetailIdList = new ArrayList();
		List deptCodeList = new ArrayList();
		List deptIdList = new ArrayList();

		// String userName = (String) session.getAttribute("userName");

		BigDecimal totalCost = new BigDecimal(0);
		String date = "";
		String time = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		String clinicalNote = "";
		String orderSeqNo = "";
		String orderStatus = "";
		String testType = "";
		String urgentDetails = "";
		int hospitalId = 0;
		int placedBy = 0;
		Users users = null;
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			infoMap.put("hospitalId", hospitalId);
		}
		int departmentId = (Integer) session.getAttribute("deptId");
		int userId = (Integer) session.getAttribute(USER_ID);
		infoMap.put(USER_ID, userId);
		box.put(USER_ID, userId);
		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);

		DgOrderhd dgOrderhd = new DgOrderhd();
		dgOrderhd.setHospital(hospital);
		Patient patient = new Patient();
		Inpatient inpatient = new Inpatient();

		if (request.getParameter(HIN_ID) != null) {
			patient.setId(Integer.parseInt(request.getParameter(HIN_ID)));
			dgOrderhd.setHin(patient);
			infoMap.put("hinId", Integer.parseInt(request.getParameter(HIN_ID)));
		}
		if (request.getParameter(INPATIENT_ID) != null) {
			inpatient
					.setId(Integer.parseInt(request.getParameter(INPATIENT_ID)));
			dgOrderhd.setInpatient(inpatient);
			infoMap.put("inpatientId",
					Integer.parseInt(request.getParameter(INPATIENT_ID)));
		}
		if (!request.getParameter(EMPLOYEE_ID).equals("0")) {
			placedBy = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(TEST_TYPE) != null
				&& !(request.getParameter(TEST_TYPE).equals(""))) {
			testType = request.getParameter(TEST_TYPE);
		}
		if (request.getParameter(CLINICAL_NOTE) != null
				&& !(request.getParameter(CLINICAL_NOTE).equals(""))) {
			clinicalNote = request.getParameter(CLINICAL_NOTE);
		}
		if (request.getParameter(ORDER_STATUS) != null
				&& !(request.getParameter(ORDER_STATUS).equals(""))) {
			orderStatus = request.getParameter(ORDER_STATUS);
		}
		if (request.getParameter(ORDER_NO) != null) {
			orderSeqNo = request.getParameter(ORDER_NO);
		}
		if (request.getParameter(TOTAL_AMOUNT) != null) {
			totalCost = new BigDecimal(request.getParameter(TOTAL_AMOUNT));
		}
		if (request.getParameter(URGENT_DETAILS) != null
				&& !(request.getParameter(URGENT_DETAILS).equals(""))) {
			urgentDetails = request.getParameter(URGENT_DETAILS);
		}
		if (placedBy != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(placedBy);
			dgOrderhd.setPrescribedBy(masEmployee);
		}
		if (departmentId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			dgOrderhd.setDepartment(masDepartment);
		}
		Vector mainCharge = null;
		if (box.getVector("mainCharge") != null) {
			mainCharge = box.getVector("mainCharge");
		}
		int mainChargeId = 0;
		//
		for (int i = 0; i < mainCharge.size(); i++) {
			mainChargeId = Integer.parseInt("" + mainCharge.get(i));

		}
		int value = 19;
		boolean flag = false;
		for (int i = 0; i < mainCharge.size(); i++) {
			if (Integer.parseInt("" + mainCharge.get(i)) == value) {
				flag = true;
			}
		}

		//
		if (flag == true) {
		}

		//
		String temp = labHandlerService.generateOrderNumber();
		dgOrderhd.setOrderNo(orderSeqNo);
		dgOrderhd.setTestType(testType);
		dgOrderhd.setNetAmount(totalCost);
		dgOrderhd.setOrderStatus(orderStatus);
		dgOrderhd.setClinicalNote(clinicalNote);
		dgOrderhd.setOrderDate(HMSUtil.convertStringTypeDateToDateType(date));
		dgOrderhd.setOrderTime(time);
		dgOrderhd.setPatientType("IP");
		dgOrderhd.setOrderStatus("P");
		dgOrderhd.setLastChgBy(users);
		dgOrderhd.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
		dgOrderhd.setLastChgTime(time);
		dgOrderhd.setUrgentRemarks(urgentDetails);
		dgOrderhd.setHospital(hospital);
		infoMap.put("dgOrderhd", dgOrderhd);

		/*
		 * // ----------Saving Data in DgSampleCollection's Table where
		 * MainCharge is RADIOLOGY-----------------------------
		 * 
		 * DgSampleCollectionHeader dgSampleCollectionHeader = new
		 * DgSampleCollectionHeader();
		 * dgSampleCollectionHeader.setHospital(hospital);
		 * 
		 * dgSampleCollectionHeader.setOrderStatus("P");
		 * dgSampleCollectionHeader.setLastChgBy(userName);
		 * dgSampleCollectionHeader
		 * .setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
		 * dgSampleCollectionHeader.setLastChgTime(time);
		 * dgSampleCollectionHeader
		 * .setDiagnosisDate(HMSUtil.convertStringTypeDateToDateType(date));
		 * dgSampleCollectionHeader.setDiagnosisTime(time); if
		 * (request.getParameter(HIN_ID) != null) {
		 * dgSampleCollectionHeader.setHin(patient); } int inpatientId = 0; if
		 * (inpatientId != 0) { Inpatient inpatient = new Inpatient();
		 * inpatient.setId(inpatientId);
		 * dgSampleCollectionHeader.setInpatient(inpatient); }
		 * 
		 * int collectionCenterId=0; if (collectionCenterId != 0) {
		 * DgCollectionCenter dgCollectionCenter = new DgCollectionCenter();
		 * dgCollectionCenter.setId(collectionCenterId);
		 * dgSampleCollectionHeader.setCollectionCenter(dgCollectionCenter); }
		 * dgSampleCollectionHeader.setOrder(dgOrderhd);
		 * infoMap.put("dgSampleCollectionHeader", dgSampleCollectionHeader);
		 */

		if (request.getParameter("hiddenValueCharge") != null) {
			chargeListLength = Integer.parseInt(request
					.getParameter("hiddenValueCharge"));
		}
		int i = 1;
		for (int a = 1; a <= chargeListLength; a++) {
			if (request.getParameter(CHARGE_CODE_ID + i) != null
					&& !request.getParameter(CHARGE_CODE_ID + i).equals("")) {
				chargeList.add(request.getParameter(CHARGE_CODE_ID + i));

			} else {
				chargeList.add("");
			}
			if (request.getParameter(QUANTITY + i) != null
					&& !request.getParameter(QUANTITY + i).equals("")) {
				qtyList.add(request.getParameter(QUANTITY + i));
			} else {
				qtyList.add("1");
			}
			if (request.getParameter(AMOUNT + i) != null
					&& !request.getParameter(AMOUNT + i).equals("")) {
				amountList.add(request.getParameter(AMOUNT + i));
			} else {
				amountList.add("");
			}

			if (request.getParameter(MAIN_CHARGECODE_ID + i) != null) {
				mainChargeList
						.add(request.getParameter(MAIN_CHARGECODE_ID + i));
			} else {
				mainChargeList.add("");
			}
			if (request.getParameter(SUB_CHARGECODE_ID + i) != null) {
				subChargeList.add(request.getParameter(SUB_CHARGECODE_ID + i));
			} else {
				subChargeList.add("");
			}
			if (request.getParameter(SAMPLE_COLLECTION_DETAIL_ID + i) != null) {
				sampleDetailIdList.add(request
						.getParameter(SAMPLE_COLLECTION_DETAIL_ID + i));
			} else {
				sampleDetailIdList.add("");
			}
			if (request.getParameter(DG_ORDER_DETAIL_ID + i) != null) {
				orderDetailIdList.add(request.getParameter(DG_ORDER_DETAIL_ID
						+ i));
			} else {
				orderDetailIdList.add("");
			}
			if (request.getParameter(DEPARTMENT_TYPE_CODE + i) != null
					&& !request.getParameter(DEPARTMENT_TYPE_CODE + i).equals(
							"")) {
				deptCodeList
						.add(request.getParameter(DEPARTMENT_TYPE_CODE + i));
			} else {
				deptCodeList.add("");
			}
			if (request.getParameter(DEPARTMENT_ID + i) != null
					&& !request.getParameter(DEPARTMENT_ID + i).equals("0")) {
				deptIdList.add(request.getParameter(DEPARTMENT_ID + i));
			} else {
				deptIdList.add("");
			}
			i++;
		}

		infoMap.put("orderSeqNo", orderSeqNo);
		infoMap.put("sampleDetailIdList", sampleDetailIdList);
		infoMap.put("userName", userName);
		infoMap.put("chargeList", chargeList);
		infoMap.put("mainChargeList", mainChargeList);
		infoMap.put("subChargeList", subChargeList);
		infoMap.put("qtyList", qtyList);
		infoMap.put("amountList", amountList);
		infoMap.put("orderDetailIdList", orderDetailIdList);
		infoMap.put("deptCodeList", deptCodeList);
		infoMap.put("deptIdList", deptIdList);

		boolean saved = false;
		String message = "";
		map = labHandlerService.submitOrderBookingForInvestigation(box,
				infoMap);
		
		if(map.get("saved")!=null)
			saved = (boolean)map.get("saved");

		/**
		 * Code Added By Ritu For ChargeSlip Entry (Billing)
		 * 
		 */

		box.put("hospitalId", session.getAttribute(HOSPITAL_ID));
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		int chargeSlipNo = 0;
		chargeSlipNo = billingHandlerService.getChargeSlipNo("save",hospitalId);
		box.put("chargeSlipNo", chargeSlipNo);
		// box.put("orderBooked", "y");
		billingHandlerService.submitChargeSlipDetails(box);

		/**
		 * End of code by Ritu
		 */

		if (saved) {
			message = "Order Booking has been done Successfully !!Do you want to print ? ";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);

		String jsp = MESSAGE_OREDER_BOOKING + ".jsp";
		map.put("contentJsp", jsp);
		map.put("orderSeqNo", orderSeqNo);
		return new ModelAndView("index", "map", map);
	}

	// ----------------------OrderBooking For
	// Investigation----------------------------

	public ModelAndView showOpOrderBookingSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		Integer hospitalId = 0;
		String uhid="";
		String patientType="OP";
		String ipNumber=null;
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if(request.getParameter("uhid")!=null)
		{
			 uhid=(String) request.getParameter("uhid");
		}
		if(request.getParameter("labType")!=null){
			patientType=(String) request.getParameter("labType");
		}
		if(request.getParameter("ipNo")!=null){
			ipNumber=(String) request.getParameter("ipNo");
		}
		dataMap.put("uhid", uhid);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("patientType", patientType);
		dataMap.put("ipNumber", ipNumber);
		map=labHandlerService.getPatientDetailGrid(dataMap);
		String jsp = DG_OP_ORDER_BOOKING_SEARCH_JSP;
		jsp += ".jsp";
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView showOPClinicwWaitingPatientListJsp(HttpServletRequest request,HttpServletResponse response) {
		int deptId = 0;
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		
		int tokeNo=0;
		String patientName;
		String uhid;
		int opd_DepartmentId=0;
		int hospitalId=0;
		int searchFlag=0;
		mapForDS.put("forOPClinnic", true);
		if(request.getParameter("searchFlag")!=null){
			searchFlag=Integer.parseInt(request.getParameter("searchFlag"));
			mapForDS.put("searchFlag",searchFlag);
		}
		if(request.getParameter("tokenNo")!=null && !request.getParameter("tokenNo").equals("") ){
			tokeNo = Integer.parseInt(request.getParameter("tokenNo"));
			mapForDS.put("tokenNo",tokeNo);
		}
		if(request.getParameter("patientName")!=null && !request.getParameter("patientName").equals("") ){
			patientName = request.getParameter("patientName");
			mapForDS.put("patientName", patientName);
		}
		if(request.getParameter("uhid")!=null){
			uhid = request.getParameter("uhid");
			mapForDS.put("uhid", uhid);
		}
		if(session.getAttribute(HOSPITAL_ID)!=null){
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
			session.setAttribute("deptId", deptId);
			mapForDS.put("deptId", deptId);
		} else {
			if(session.getAttribute("deptId")!=null){
			deptId = (Integer) session.getAttribute("deptId");
			mapForDS.put("deptId", deptId);
			}
		}
		
		String title = request.getParameter("title");
		mapForDS.put("hospitalId", hospitalId);
		mapForDS.put("opClinicalWaitinList", true);
		
		map = labHandlerService.getWaitingPatientList(mapForDS);
		String deptName =(String)map.get("deptName");
		
		session.setAttribute("deptName", deptName);
		String jsp = "op_clinical_waiting_list";
		jsp += ".jsp";
		title = "Waiting Patient List";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showOpOrderBookingSearchJspForQC(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		String jsp =RequestConstants.DG_OP_ORDER_BOOKING_SEARCH_JSP_FOR_QC;
		jsp += ".jsp";
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * public ModelAndView getPatientNameForOrderBooking(HttpServletRequest
	 * request, HttpServletResponse response) { Map<String, Object> map = new
	 * HashMap<String, Object>(); String serviceNo = ""; String flag = "";
	 * List<Patient> patientList = new ArrayList<Patient>();
	 * if(request.getParameter(SERVICE_NO) != null){ serviceNo = SERVICE_NO); }
	 * if(request.getParameter("flag") != null){ flag =
	 * request.getParameter("flag"); map.put("flag", flag); } patientList =
	 * labHandlerService.getPatientName(serviceNo); if(patientList.size() > 0){
	 * map.put("patientList", patientList); } String jsp = "diag_populateHin";
	 * return new ModelAndView(jsp, "map" ,map); }
	 */
	public ModelAndView getVisitNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Visit> visitNoList = new ArrayList<Visit>(); 
		
		String hinNo = "";
		Integer hospitalId = 0;
		int deptId=0;
		HttpSession session = request.getSession();
		if (request.getParameter(HIN_NO) != null
				&& !request.getParameter(HIN_NO).equals("")) {
			hinNo = request.getParameter(HIN_NO);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (session.getAttribute(RequestConstants.DEPT_ID) != null) {
			deptId = (Integer) session.getAttribute(RequestConstants.DEPT_ID);
		}
		dataMap.put(HIN_NO, hinNo);
		dataMap.put(HOSPITAL_ID, hospitalId);
		dataMap.put(RequestConstants.DEPT_ID, deptId);
		map.put("flag", "lab");
		visitNoList = labHandlerService.getVisitNo(dataMap);
		
		if (visitNoList.size() > 0) {
			map.put("visitNoList", visitNoList);
		}
		String jsp = "lastVisitNo";
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView getVisitNoForQC(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Visit> visitNoList = new ArrayList<Visit>(); 
		String hinNo = "";
		Integer hospitalId = 0;
		int deptId=0;
		int userId=0;
		HttpSession session = request.getSession();
		if (request.getParameter(HIN_NO) != null
				&& !request.getParameter(HIN_NO).equals("")) {
			hinNo = request.getParameter(HIN_NO);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (session.getAttribute(RequestConstants.DEPT_ID) != null) {
			deptId = (Integer) session.getAttribute(RequestConstants.DEPT_ID);
		}
		if(session.getAttribute(USER_ID) != null){
			userId = (Integer) session.getAttribute(USER_ID);
		}
		dataMap.put(HIN_NO, hinNo);
		dataMap.put(HOSPITAL_ID, hospitalId);
		dataMap.put(RequestConstants.DEPT_ID, deptId);
		dataMap.put(USER_ID, userId);
		map.put("flag", "lab");
		visitNoList = labHandlerService.getVisitNoForQC(dataMap);
		if (visitNoList.size() > 0) {
			map.put("visitNoList", visitNoList);
		}
		String jsp = "lastVisitNoForQC";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getPatientDetails(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> inpatMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		String deptType = "";
		String billingScreen = null;
		int visitNo = 0;
		int visitId = 0;
		int hospitalId=0;
		int deptId =0;
		
		int pharmacyLabQueueId=0;
		
		if(session.getAttribute("deptId")!=null){
			deptId = (Integer)session.getAttribute("deptId");
			//mapDetails.put("deptId",deptId);
		}
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}

		if (request.getParameter(VISIT_NUMBER) != null) {
			visitNo = Integer.parseInt(request.getParameter(VISIT_NUMBER));
			map.put("visitNo", visitNo);
		}
		if (request.getParameter("visitId") != null) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
			map.put("visitId", visitId);
		}
		if (request.getParameter("pharmacyLabQueue") != null) {
			pharmacyLabQueueId = Integer.parseInt(request.getParameter("pharmacyLabQueue"));
			
		}

		billingScreen = request.getParameter("billingScreen");
		dataMap.put("billingScreen", billingScreen);	
		
		//added by govind 26-07-2017
		int inpatientId=0;
		String patientType=null;
		if (request.getParameter("inpatientId") != null) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
			
		}
		if (request.getParameter("patientType") != null) {
			patientType =request.getParameter("patientType");
			
		}
		//added by govind 26-07-2017
		
		if (visitNo != 0) {
			map = labHandlerService
					.showOrderBookingForInvestigationJsp(visitNo,hospitalId);
			String orderSeqNo = "";
			orderSeqNo = labHandlerService.getOrderSeqForDisplay("ON");
			if (orderSeqNo != null) {
				map.put("orderSeqNo", orderSeqNo);
			}
		}
		//added by govind 26-07-2017 
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		if(patientType.equals("IP")){
			String orderSeqNo = "";
			orderSeqNo = labHandlerService.getOrderSeqForDisplay("ON");
			if (orderSeqNo != null) {
				map.put("orderSeqNo", orderSeqNo);
			}
			if(inpatientId>0){				
				inpatMap.put("inpatientId", inpatientId);
				inpatMap=labHandlerService.getInpatientList(inpatMap);
				
				if(inpatMap.get("inpatientList")!=null){
					inpatientList=(List<Inpatient>)inpatMap.get("inpatientList");
					map.put("inpatientList", inpatientList);
				}
				
			}			
		}
		//added by govind 26-07-2017 end
		dataMap.put("deptType", deptType);
		detailsMap = labHandlerService.getMainAndSubChargeForLab(dataMap);
		/*String includedJsp = DG_INVESTIGATION_ORDER_BOOKING + ".jsp";
		DG_INVESTIGATION_ORDER_BOOKING*/
	//	jsp = DG_OP_ORDER_BOOKING_SEARCH_JSP + ".jsp";
		jsp = DG_INVESTIGATION_ORDER_BOOKING + ".jsp";
		map.put("deptName", deptName);
		//map.put("includedJsp", includedJsp);
		map.put("hospitalId", hospitalId);
		map.put("deptId", deptId);
		map.put("detailsMap", detailsMap);
		map.put("pharmacyLabQueueId", pharmacyLabQueueId);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("billingScreen", billingScreen);	//added by amit das on 11-05-2017
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView getPatientDetailsForQC(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		String deptType = "";
		int visitNo = 0;
		int visitId = 0;
		String hinNo="";
		int hospitalId=0;
		int deptId=0;
		int userId=0;
		//Box box=HMSUtil.getBox(request);
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (session.getAttribute(RequestConstants.DEPT_ID) != null) {
			deptId = (Integer) session.getAttribute(RequestConstants.DEPT_ID);
		}
		if(session.getAttribute(USER_ID) != null){
			userId = (Integer) session.getAttribute(USER_ID);
		}
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}

		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}

		if (request.getParameter(VISIT_NUMBER) != null && !"".equalsIgnoreCase(request.getParameter(VISIT_NUMBER).toString().trim())) {
			visitNo = Integer.parseInt(request.getParameter(VISIT_NUMBER));
			map.put("visitNo", visitNo);
		}
		if (request.getParameter("hinNo") != null) {
			hinNo = request.getParameter("hinNo");
			map.put("visitId", hinNo);
		}
		data.put(HIN_NO, hinNo);
		data.put(HOSPITAL_ID, hospitalId);
		data.put(RequestConstants.DEPT_ID, deptId);
		data.put(USER_ID, userId); 
		List<Visit> visitNoList = labHandlerService.getVisitNoForQC(data);
		/*if (request.getParameter("visitId") != null) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
			map.put("visitId", visitId);
		} */
		//if (visitNo != 0) {
		if(visitNoList!=null && visitNoList.size()>0){
			map = labHandlerService
					.showOrderBookingForInvestigationJsp(visitNoList.get(0).getId(),hospitalId);
			String orderSeqNo = "";
			orderSeqNo = labHandlerService.getOrderSeqForDisplay("ON");
			if (orderSeqNo != null) {
				map.put("orderSeqNo", orderSeqNo);
			}
			map.put("visitNo", visitNoList.get(0).getVisitNo());
		}
		dataMap.put("deptType", deptType);
		detailsMap = labHandlerService.getMainAndSubChargeForLab(dataMap);
		String includedJsp = DG_INVESTIGATION_ORDER_BOOKING + ".jsp";

		//jsp =RequestConstants.DG_OP_ORDER_BOOKING_SEARCH_JSP_FOR_QC + ".jsp";
		map.put("deptName", deptName);
		map.put("includedJsp", includedJsp);
		map.put("detailsMap", detailsMap);
		map.put("message", message);
		map.put("contentJsp", includedJsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView submitOrderBookingForInvestigation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		int chargeListLength = 0;

		List chargeList = new ArrayList();
		List qtyList = new ArrayList();
		List amountList = new ArrayList();
		List mainChargeList = new ArrayList();
		List subChargeList = new ArrayList();
		List sampleDetailIdList = new ArrayList();
		List orderDetailIdList = new ArrayList();
		List deptCodeList = new ArrayList();
		List deptIdList = new ArrayList();
		Box box = HMSUtil.getBox(request);
		String userName = (String) session.getAttribute("userName");
		Integer userId = (Integer) session.getAttribute("userId");
		Users users = (Users) session.getAttribute(RequestConstants.USERS);
		BigDecimal totalCost = new BigDecimal(0);
		String date = "";
		String time = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		String clinicalNote = "";
		String orderSeqNo = "";
		String orderStatus = "";
		String testType = "";
		String routineUrgent = "";
		String urgentDetails = "";
		int hospitalId = 0;
		int placedBy = 0;
		int pharmacyLabQueueId=0;
		int dgOrderHdId = 0;
		String billingScreen = null;
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			infoMap.put("hospitalId", hospitalId);
		}
		int departmentId = (Integer) session.getAttribute("deptId");
		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);
		
		
		if(request.getParameter("dgOrderHdId")!=null){
			dgOrderHdId = Integer.parseInt(request.getParameter("dgOrderHdId"));
		}
		
		DgOrderhd dgOrderhd = new DgOrderhd();
		dgOrderhd.setHospital(hospital);
		Patient patient = new Patient();
		Visit visit = new Visit();

		if (request.getParameter(HIN_ID) != null) {
			patient.setId(Integer.parseInt(request.getParameter(HIN_ID)));
			dgOrderhd.setHin(patient);
			infoMap.put("hinId", Integer.parseInt(request.getParameter(HIN_ID)));
		}
		if (request.getParameter(VISIT_ID) != null) {
			visit.setId(Integer.parseInt(request.getParameter(VISIT_ID)));
			dgOrderhd.setVisit(visit);
		}
		if (null !=request.getParameter(EMPLOYEE_ID) && !request.getParameter(EMPLOYEE_ID).equals("0")) {
			placedBy = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(TEST_TYPE) != null
				&& !(request.getParameter(TEST_TYPE).equals(""))) {
			testType = request.getParameter(TEST_TYPE);
		}
		if (request.getParameter(CLINICAL_NOTE) != null
				&& !(request.getParameter(CLINICAL_NOTE).equals(""))) {
			clinicalNote = request.getParameter(CLINICAL_NOTE);
		}
		if (request.getParameter(ORDER_STATUS) != null
				&& !(request.getParameter(ORDER_STATUS).equals(""))) {
			orderStatus = request.getParameter(ORDER_STATUS);
		}

		if (request.getParameter(ROUTINE) != null
				&& !(request.getParameter(ROUTINE).equals(""))) {
			routineUrgent = request.getParameter(ROUTINE);
		}

		if (request.getParameter(URGENT_DETAILS) != null
				&& !(request.getParameter(URGENT_DETAILS).equals(""))) {
			urgentDetails = request.getParameter(URGENT_DETAILS);
		}
		if (request.getParameter(ORDER_NO) != null) {
			orderSeqNo = request.getParameter(ORDER_NO);
		}
		if (request.getParameter(TOTAL_AMOUNT) != null) {
			totalCost = new BigDecimal(request.getParameter(TOTAL_AMOUNT));
		}
		if (request.getParameter("pharmacyLabQueueId") != null) {
			pharmacyLabQueueId = Integer.parseInt(request.getParameter("pharmacyLabQueueId"));
			infoMap.put("pharmacyLabQueueId", pharmacyLabQueueId);
		}
		if (request.getParameter(INPATIENT_ID) != null) {
			Inpatient inpat=new Inpatient();
			if(Integer.parseInt(request.getParameter(INPATIENT_ID))>0){
			inpat.setId(Integer.parseInt(request.getParameter(INPATIENT_ID)));
			dgOrderhd.setInpatient(inpat);
			}
		}
		
		billingScreen = request.getParameter("billingScreen"); // added by amit das on 11-05-2017
		
		if (placedBy != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(placedBy);
			dgOrderhd.setPrescribedBy(masEmployee);
		}
		if (departmentId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			dgOrderhd.setDepartment(masDepartment);
		}
		String patientType="";
		if(request.getParameter("patientType")!=null){
			patientType=request.getParameter("patientType");
		}
		String temp = labHandlerService.generateOrderNumber();
		dgOrderhd.setOrderNo(orderSeqNo);
		dgOrderhd.setTestType(testType);
		dgOrderhd.setNetAmount(totalCost);
		dgOrderhd.setOrderStatus(orderStatus);
		dgOrderhd.setClinicalNote(clinicalNote);
		dgOrderhd.setOrderDate(HMSUtil.convertStringTypeDateToDateType(date));
		dgOrderhd.setOrderTime(time);
		if(patientType.equals("OP")){
			dgOrderhd.setPatientType("OP");
		}if(patientType.equals("IP")){
			dgOrderhd.setPatientType("IP");
		}
		dgOrderhd.setOrderStatus("P");
		/*
		 * Users users = new Users(); users.setId(userId);
		 */
		dgOrderhd.setLastChgBy(users);
		dgOrderhd.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
		dgOrderhd.setLastChgTime(time);
		dgOrderhd.setRoutineUrgentStatus(routineUrgent);
		dgOrderhd.setUrgentRemarks(urgentDetails);
		infoMap.put("dgOrderhd", dgOrderhd);
		infoMap.put("dgOrderHdId", dgOrderHdId);

		if (request.getParameter("hiddenValueCharge") != null) {
			chargeListLength = Integer.parseInt(request
					.getParameter("hiddenValueCharge"));
		}
		//int i = 1;
		for (int i = 1; i <= chargeListLength; i++) {
			if (request.getParameter(CHARGE_CODE_ID + i) != null
					&& !request.getParameter(CHARGE_CODE_ID + i).equals("")) {
				chargeList.add(request.getParameter(CHARGE_CODE_ID + i));

			}
			if (request.getParameter(QUANTITY + i) != null
					&& !request.getParameter(QUANTITY + i).equals("")) {
				qtyList.add(request.getParameter(QUANTITY + i));
			} else {
				qtyList.add("1");
			}
			if (request.getParameter(AMOUNT + i) != null
					&& !request.getParameter(AMOUNT + i).equals("")) {
				amountList.add(request.getParameter(AMOUNT + i));
			} else {
				amountList.add("");
			}

			if (request.getParameter(MAIN_CHARGECODE_ID + i) != null) {
				mainChargeList
						.add(request.getParameter(MAIN_CHARGECODE_ID + i));
			} else {
				mainChargeList.add("");
			}
			if (request.getParameter(SUB_CHARGECODE_ID + i) != null) {
				subChargeList.add(request.getParameter(SUB_CHARGECODE_ID + i));
			} else {
				subChargeList.add("");
			}
			if (request.getParameter(SAMPLE_COLLECTION_DETAIL_ID + i) != null) {
				sampleDetailIdList.add(request
						.getParameter(SAMPLE_COLLECTION_DETAIL_ID + i));
			} else {
				sampleDetailIdList.add("");
			}
			if (request.getParameter(DG_ORDER_DETAIL_ID + i) != null) {
				orderDetailIdList.add(request.getParameter(DG_ORDER_DETAIL_ID
						+ i));
			} else {
				orderDetailIdList.add("");
			}
			if (request.getParameter(DEPARTMENT_TYPE_CODE + i) != null
					&& !request.getParameter(DEPARTMENT_TYPE_CODE + i).equals(
							"")) {
				deptCodeList
						.add(request.getParameter(DEPARTMENT_TYPE_CODE + i));
			} else {
				deptCodeList.add("");
			}
			if (request.getParameter(DEPARTMENT_ID + i) != null
					&& !request.getParameter(DEPARTMENT_ID + i).equals("0")) {
				deptIdList.add(request.getParameter(DEPARTMENT_ID + i));
			} else {
				deptIdList.add("");
			}
			//i++;
		}
		int visitId=0;
		if(request.getParameter("visitId")!=null){
			visitId=Integer.parseInt(request.getParameter("visitId"));
		}
		
		infoMap.put("visitId", visitId);
		infoMap.put("orderSeqNo", orderSeqNo);
		infoMap.put("sampleDetailIdList", sampleDetailIdList);
		infoMap.put("userName", userName);
		infoMap.put("userId", userId);
		infoMap.put("chargeList", chargeList);
		infoMap.put("mainChargeList", mainChargeList);
		infoMap.put("subChargeList", subChargeList);
		infoMap.put("qtyList", qtyList);
		infoMap.put("amountList", amountList);
		infoMap.put("orderDetailIdList", orderDetailIdList);
		infoMap.put("deptCodeList", deptCodeList);
		infoMap.put("deptIdList", deptIdList);
		infoMap.put(RequestConstants.USERS, users);

		boolean saved = false;
		String message = "";
		map = labHandlerService.submitOrderBookingForInvestigation(box,
				infoMap);
		
		if(map.get("saved")!=null)
			saved = (boolean)map.get("saved");
		
		if(map.get("dgOrderHdId")!=null)
			dgOrderHdId = (int)map.get("dgOrderHdId");
		
		String adNo="",uHid="";
		if(map.get("adNo")!=null){
			adNo = (String)map.get("adNo");
		}
		if(map.get("uHid")!=null){
			uHid = (String)map.get("uHid");
		}
		
		if (saved) {
			message = "Order Booking has been done Successfully !!Do you want to print ? ";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);

		String jsp = DG_MSG_FOR_LAB + ".jsp";
		map.put("orderDetailsFlag", request.getParameter("orderDetailsFlag")!=null?request.getParameter("orderDetailsFlag"):"");
		map.put("contentJsp", jsp);
		map.put("orderSeqNo", orderSeqNo);
		map.put("dgOrderHdId", dgOrderHdId);
		
		map.put("patientType", patientType);
	   if (request.getParameter(HIN_ID) != null) {
		map.put("orderId", Integer.parseInt(request.getParameter(HIN_ID)));
	   }
		if (request.getParameter(VISIT_ID) != null) {
		map.put("visitId", Integer.parseInt(request.getParameter(VISIT_ID)));
		}
		map.put("billingScreen", billingScreen); // added by amit das on 11-05-2017
		map.put("adNo", adNo);
		map.put("uHid", uHid);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printOrderBooking(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String query = "";

		try {

			if (request.getParameter("orderNo") != null
					&& (!request.getParameter("orderNo").equals(""))) {
				query = "where dgorderhd.order_no = '"
						+ request.getParameter("orderNo") + "' ";
			}
			if (request.getParameter("visitNo") != null
					&& (!request.getParameter("visitNo").equals(""))) {
				query = query + "AND visit.visit_no = '"
						+ request.getParameter("visitNo") + "' ";
			}
			if (request.getParameter("hinNo") != null
					&& (!request.getParameter("hinNo").equals(""))) {
				query = query + "AND patient.hin_no = '"
						+ request.getParameter("hinNo") + "' ";
			}
			if (request.getParameter("inpatientId") != null
					&& (!request.getParameter("inpatientId").equals("0"))) {
				query = query + "AND inpatient.inpatient_id = "
						+ request.getParameter("inpatientId");
			}
			if (session.getAttribute(HOSPITAL_ID) != null) {
				query = query + "AND dgorderhd.hospital_id = "
						+ (Integer) session.getAttribute(HOSPITAL_ID);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		detailsMap = labHandlerService.getConnectionForReport();

		parameters.put("QUERY", query);

		try {

			HMSUtil.generateReport("diagnosticOrderBooking", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ModelAndView printBulkOrderBooking(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String query = "";

		try {

			if (request.getParameter("orderNo") != null
					&& (!request.getParameter("orderNo").equals(""))) {
				query = "where dgorderhd.order_no = '"
						+ request.getParameter("orderNo") + "' ";
			}
			if (request.getParameter("visitNo") != null
					&& (!request.getParameter("visitNo").equals(""))) {
				query = query + "AND visit.visit_no = '"
						+ request.getParameter("visitNo") + "' ";
			}
			if (request.getParameter("hinNo") != null
					&& (!request.getParameter("hinNo").equals(""))) {
				query = query + "AND patient.hin_no = '"
						+ request.getParameter("hinNo") + "' ";
			}
			if (request.getParameter("inpatientId") != null
					&& (!request.getParameter("inpatientId").equals("0"))) {
				query = query + "AND inpatient.inpatient_id = "
						+ request.getParameter("inpatientId");
			}
			if (session.getAttribute(HOSPITAL_ID) != null) {
				query = query + "AND dgorderhd.hospital_id = "
						+ (Integer) session.getAttribute(HOSPITAL_ID);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		detailsMap = labHandlerService.getConnectionForReport();

		parameters.put("QUERY", query);

		try {

			HMSUtil.generateReport("diagnosticOrderBooking", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	// ------------------------------Pending For Sample
	// Collection--------------------------------


	public ModelAndView showPendingSampleCollectionJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		Integer hospitalId = 0;
		String patientType = null;
		int deptId;
		if (request.getParameter("flag") != null) {
			patientType = (String) request.getParameter("flag");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			mapForDs.put("departmentId", deptId);
		}
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		mapForDs.put(PATIENT_TYPE, patientType);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		detailsMap = labHandlerService.getDetailsForSearch(map);
		patientMap = labHandlerService.getSampleCollectionGrid(mapForDs);
		jsp = DG_PENDING_SAMPLE_COLLECTION + ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptName", deptName);
		map.put("patientType", patientType);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showPendingSampleCollectionInIPWardJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		Integer hospitalId = 0;
		String patientType = "IP";
		int deptId;
		if (request.getParameter("flag") != null) {
			patientType = "IP";//(String) request.getParameter("flag");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			mapForDs.put("departmentId", deptId);
		}
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		mapForDs.put(PATIENT_TYPE, patientType);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		detailsMap = labHandlerService.getDetailsForSearch(map);
		patientMap = labHandlerService.getSampleCollectionGridIPd(mapForDs);
		jsp = "diag_pendingSampleCollectionForIPWard.jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptName", deptName);
		map.put("patientType", patientType);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}	
	public ModelAndView showPendingSampleCollectionJspForQC(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		Integer hospitalId = 0;
		String patientType = null;
		Box box = HMSUtil.getBox(request);
		if (request.getParameter("flag") != null) {
			patientType = (String) request.getParameter("flag");
		}
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}//searchPatientForQC
		mapForDs.put("box", box);
		mapForDs.put(PATIENT_TYPE, "OP"); 
		mapForDs.put(HOSPITAL_ID, hospitalId);
		detailsMap = labHandlerService.getDetailsForSearch(map);
		patientMap = labHandlerService.getSampleCollectionGrid(mapForDs);
		jsp =RequestConstants.DG_PENDING_SAMPLE_COLLECTION_FOR_QC + ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptName", deptName);
		map.put("patientType", "OP");
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatient(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = new Date();
		Date toDate = new Date();
		String patientFName = "";
		String orderStatus = "";
		String hinNo = "";
		String adNo = "";
		String patientType = null;
		int chargeCodeId = 0;
		int departmentId = 0;
		int inpatientId = 0;
		int subGroupId = 0;
		int sampleId = 0;
		int orderId = 0;
		int hinId = 0;
		String visitNumber = null;
		Integer hospitalId = 0;
		String deptName = "";
		String doctorName = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
		int deptId = 0;
		String deptType ="";
		try {
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				mapForDs.put(HOSPITAL_ID, hospitalId);
			}
			if (session.getAttribute("deptName") != null) {
				deptName = (String) session.getAttribute("deptName");
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			String orderNo="";
			if (request.getParameter("orderNo") != null
					&& !(request.getParameter("orderNo").equals(""))) {
				orderNo = request.getParameter("orderNo");
				mapForDs.put("orderNo", orderNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				mapForDs.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				mapForDs.put("toDate", toDate);
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				patientType = request.getParameter(PATIENT_TYPE);
			}
			if (request.getParameter(RequestConstants.DOCTOR_NAME) != null
					&& !(request.getParameter(RequestConstants.DOCTOR_NAME)
							.equals(""))) {
				doctorName = request.getParameter(RequestConstants.DOCTOR_NAME);
			}
			
			if (request.getParameter(CHARGE_CODE_ID) != null &&
			  !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID)); 
				mapForDs.put("chargeCodeId", chargeCodeId); 
			} 
			 if (request.getParameter(SUB_CHARGECODE_ID) != null &&
					  !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				 		subGroupId = Integer.parseInt(request
				 					.getParameter(SUB_CHARGECODE_ID));
				 	mapForDs.put("subGroupId",subGroupId); 
				 					
			}
			 int subchargeId=0; 
			 if (request.getParameter("subGroupId") != null  &&!(request.getParameter("subGroupId").equals("")) &&
					  !(request.getParameter("subGroupId").equals("0"))) {
				 subchargeId = Integer.parseInt(request
				 					.getParameter("subGroupId"));
				 	mapForDs.put("subchargeId",subchargeId); 
				 					
			}
			  if (request.getParameter("sampleName") != null &&
					  !(request.getParameter("sampleName").equals("0"))) {
				  	sampleId =   Integer.parseInt(request.getParameter("sampleName"));
				  	mapForDs.put("sampleId", sampleId); 
			  }
			  
			  if (request.getParameterValues("invName") != null &&
					  !(request.getParameterValues("invName").length==0)) {
				  String[]  invNameId =   request.getParameterValues("invName");
				  mapForDs.put("invName", invNameId); 
			  }
			
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			/*
			 * if (request.getParameter(AD_NO) != null &&
			 * !(request.getParameter(AD_NO).equals(""))) { adNo =
			 * request.getParameter(AD_NO); mapForDs.put("adNo", adNo); }
			 */
			/*
			 * if (request.getParameter(DEPARTMENT_ID) != null &&
			 * !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
			 * departmentId = Integer.parseInt(request
			 * .getParameter(DEPARTMENT_ID)); mapForDs.put("departmentId",
			 * departmentId); }
			 */
			/*
			 * if (request.getParameter(HIN_ID) != null &&
			 * !(request.getParameter(HIN_ID).equals("0"))) { hinId =
			 * Integer.parseInt(request.getParameter(HIN_ID));
			 * mapForDs.put("hinId", hinId); }
			 */
			/*
			 * if (request.getParameter(ORDER_STATUS) != null &&
			 * !(request.getParameter(ORDER_STATUS).equals("0"))) { orderStatus
			 * = request.getParameter(ORDER_STATUS); mapForDs.put("orderStatus",
			 * orderStatus); }
			 */
			if (request.getParameter(VISIT_NUMBER) != null
					&& !(request.getParameter(VISIT_NUMBER).equals(""))) {
				visitNumber = request.getParameter(VISIT_NUMBER);
				mapForDs.put(VISIT_NUMBER, visitNumber);
			}
			if (request.getParameter(ORDER_BOOKING_ID) != null
					&& !(request.getParameter(ORDER_BOOKING_ID).equals("0"))) {
				orderId = new Integer(request.getParameter(ORDER_BOOKING_ID));
				mapForDs.put("orderId", orderId);
			}
			String priorityId="";
			if (request.getParameter("priorityId") != null
					&& !(request.getParameter("priorityId").equals("0"))) {
				priorityId = request.getParameter("priorityId");
				mapForDs.put("priorityId", priorityId);
			}
			
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
			}
			
			mapForDs.put(RequestConstants.DOCTOR_NAME, doctorName);
			mapForDs.put(PATIENT_TYPE, patientType);
			mapForDs.put("deptId", deptId);

			if (session.getAttribute("deptType") != null) {
				deptType = (String) session.getAttribute("deptType");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = labHandlerService
				.getPatientDetailsSampleColletion(mapForDs);
		String diagSeqNo = "";
		String jsp = "";
		@SuppressWarnings("unused")
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailList");
		}
		
		map = labHandlerService.getSampleCollectionDetails(mapForDs);
		List<PatientAddress> patientAddress=new ArrayList<PatientAddress>();
		if (map.get("patientAddress") != null) {
			patientAddress = (List<PatientAddress>) map.get("patientAddress");
		}
		@SuppressWarnings("unused")
		List<DgOrderdt> dgOrderdtList = new ArrayList<DgOrderdt>();
		if (map != null && map.get("dgOrderdtList") != null) {
			dgOrderdtList = (List<DgOrderdt>) map.get("dgOrderdtList");
			diagSeqNo = (String) map.get("diagSeqNo");
			if (diagSeqNo != null) {
				map.put("diagSeqNo", diagSeqNo);
			}
			jsp = DG_SAMPLE_COLLECTION + ".jsp";
		} else {
			//detailsMap = labHandlerService.getDetailsForSearch();
			//jsp = DG_PENDING_SAMPLE_COLLECTION + ".jsp";
			int visitId = 0;
			
			if(request.getParameter("visitId") != null && !request.getParameter("visitId").equals(""))
				visitId = Integer.parseInt(request.getParameter("visitId") );
			map = labHandlerService
					.showOrderBookingForInvestigationJsp(visitId,hospitalId);
			String orderSeqNo = "";
			orderSeqNo = labHandlerService.getOrderSeqForDisplay("ON");
			if (orderSeqNo != null) {
				map.put("orderSeqNo", orderSeqNo);
			}
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("deptType", deptType);
			dataMap.put("deptId",deptId);
			detailsMap = labHandlerService.getMainAndSubChargeForLab(dataMap);
			
			jsp = DG_INVESTIGATION_ORDER_BOOKING + ".jsp";
			map.put("orderDetailsFlag", "no");
			map.put("orderId", orderId);
		}
		
		map.put("box", box);
		map.put("diagSeqNo", diagSeqNo);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("patientType", patientType);
		map.put("patientAddress", patientAddress);
		return new ModelAndView("index", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForQC(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = new Date();
		Date toDate = new Date();
		String patientFName = ""; 
		String hinNo = "";  
		String patientType = null;  
		int inpatientId = 0;  
		int orderId = 0;  
		String visitNumber = null;
		Integer hospitalId = 0;
		String deptName = "";
		String doctorName = "";
		Box box = HMSUtil.getBox(request);
		//session.setAttribute("box", box);
		session = request.getSession();

		try {
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				mapForDs.put(HOSPITAL_ID, hospitalId);
			}
			if (session.getAttribute("deptName") != null) {
				deptName = (String) session.getAttribute("deptName");
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				mapForDs.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				mapForDs.put("toDate", toDate);
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				patientType = request.getParameter(PATIENT_TYPE);
			}
			if (request.getParameter(RequestConstants.DOCTOR_NAME) != null
					&& !(request.getParameter(RequestConstants.DOCTOR_NAME)
							.equals(""))) {
				doctorName = request.getParameter(RequestConstants.DOCTOR_NAME);
			}
			 
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			 
			if (request.getParameter(VISIT_NUMBER) != null
					&& !(request.getParameter(VISIT_NUMBER).equals(""))) {
				visitNumber = request.getParameter(VISIT_NUMBER);
				mapForDs.put(VISIT_NUMBER, visitNumber);
			}
			if (request.getParameter(ORDER_BOOKING_ID) != null
					&& !(request.getParameter(ORDER_BOOKING_ID).equals("0"))) {
				orderId = new Integer(request.getParameter(ORDER_BOOKING_ID));
				mapForDs.put("orderId", orderId);
			}
			int deptId = 0;
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
			}
			mapForDs.put(RequestConstants.DOCTOR_NAME, doctorName);
			mapForDs.put(PATIENT_TYPE, patientType);
			mapForDs.put("deptId", deptId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = labHandlerService
				.getPatientDetailsSampleColletion(mapForDs);
		String diagSeqNo = "";
		String jsp = "";
		@SuppressWarnings("unused")
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailList");
		}
		map = labHandlerService.getSampleCollectionDetails(mapForDs);
		@SuppressWarnings("unused")
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		if (map != null && map.get("dgOrderhdList") != null) {
			dgOrderhdList = (List<DgOrderhd>) map.get("dgOrderhdList");
			diagSeqNo = (String) map.get("diagSeqNo");
			if (diagSeqNo != null) {
				map.put("diagSeqNo", diagSeqNo);
			}
			jsp = DG_SAMPLE_COLLECTION + ".jsp";
		} else {
			detailsMap = labHandlerService.getDetailsForSearch(map);
			jsp =RequestConstants.DG_PENDING_SAMPLE_COLLECTION_FOR_QC + ".jsp";
		}
		map.put("box", box);
		map.put("diagSeqNo", diagSeqNo);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("patientType", patientType);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitSampleCollection(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		boolean saved = false;
		int hospitalId = 0;
		String diagSeqNo = "";
		String userName = "";
		int noOfRecords = 0;
		Users users = null;
		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("hospitalId", hospitalId);
		}
		if (request.getParameter("diagNo") != null) {
			diagSeqNo = request.getParameter("diagNo");
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			parameterMap.put("userName", userName);
		}
		if (session.getAttribute(RequestConstants.USERS) != null) {
			users = (Users) session.getAttribute(RequestConstants.USERS);
			parameterMap.put(RequestConstants.USERS, users);
		}
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}
		String orderHeaderId = "";
		int newOrderId = 0;
		orderHeaderId =request.getParameter(ORDER_BOOKING_ID);
		String orderHdID[]=orderHeaderId.split(",");
		List<DgOrderhd> patientDetailList = new ArrayList<DgOrderhd>();
		patientDetailList = (List<DgOrderhd>) session
				.getAttribute("patientDetailList");

		if (patientDetailList.size() > 0) {
			for (Iterator iterator = patientDetailList.iterator(); iterator
					.hasNext();) {
				DgOrderhd dgOrderhd = (DgOrderhd) iterator.next();
				newOrderId = dgOrderhd.getId();
				for(String orderId:orderHdID){

					if(null !=orderId && !orderId.equals(""))
				if (newOrderId == Integer.parseInt(orderId) ) {
					iterator.remove();

				}
				}
			}
		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		if (newOrderId != 0) {
			map = labHandlerService
					.getSampleCollectionDetailsForNext(newOrderId);
		}
		parameterMap.put("box", box);
		parameterMap.put("diagSeqNo", diagSeqNo);
		// diagSeqNo = labHandlerService.generateDiagNumber();
		// diagSeqNo = labHandlerService.generateDiagNumber(hinId);
		map = labHandlerService.submitSampleCollection(parameterMap);
		saved = (Boolean) map.get("saved");
		List<DgSampleCollectionDetails> sampleDetails = new ArrayList<DgSampleCollectionDetails>();
		if (map.get("sampleDetails") != null) {
			sampleDetails = (List<DgSampleCollectionDetails>) map
					.get("sampleDetails");
		}

		String messageTOBeVisibleToTheUser = "";
		if (saved) {
			messageTOBeVisibleToTheUser = "Sample Collection Done Successfully !!";
		} else {
			messageTOBeVisibleToTheUser = "Some Problem Occured !! Try Again ..";
		}
		//url = "/hms/hms/lab?method=showPendingSampleCollectionJsp";
		url = "/hms/hms/lab?method=showPendingSampleCollectionJsp&flag=OP";//&selectedAppId=A1688&childAppId=A1563";//added by govind 1-11-2016
		int departmentId = box.getInt(DEPARTMENT_ID); 
		
		//Added by Arbind on 17-04-2017
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		int labDepartmentId = Integer.parseInt(properties.getProperty("labDepartmentId"));
		url1 = "/hms/hms/lab?method=showPendingSampleValidationJsp";
		
		String jsp = DG_MESSAGE_SAMPLE_COLLECTION + ".jsp";
		map.put("diagSeqNo", diagSeqNo);
		map.put("orderHeaderId", orderHeaderId);
		map.put("newOrderId", newOrderId);
		map.put("url", url);
		if(departmentId==labDepartmentId){
			map.put("url1", url1);
		}
		
		map.put("sampleDetails", sampleDetails);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView submitSampleCollectionEmpnalled(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		boolean saved = false;
		int hospitalId = 0;
		String diagSeqNo = "";
		String userName = "";
		int noOfRecords = 0;
		MasEmpaneled masEmpaneled = null;
		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("hospitalId", hospitalId);
		}
		if (request.getParameter("diagNo") != null) {
			diagSeqNo = request.getParameter("diagNo");
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			parameterMap.put("userName", userName);
		}
		if (session.getAttribute(RequestConstants.USERS) != null) {
			masEmpaneled = (MasEmpaneled) session.getAttribute(RequestConstants.USERS);
			parameterMap.put(RequestConstants.USERS, masEmpaneled);
		}
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}
		int orderHeaderId = 0;
		int newOrderId = 0;
		orderHeaderId = Integer
				.parseInt(request.getParameter(ORDER_BOOKING_ID));
		List<DgOrderhd> patientDetailList = new ArrayList<DgOrderhd>();
		patientDetailList = (List<DgOrderhd>) session
				.getAttribute("patientDetailList");

		if (patientDetailList.size() > 0) {
			for (Iterator iterator = patientDetailList.iterator(); iterator
					.hasNext();) {
				DgOrderhd dgOrderhd = (DgOrderhd) iterator.next();
				newOrderId = dgOrderhd.getId();
				if (newOrderId == orderHeaderId) {
					iterator.remove();

				}
			}
		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		if (newOrderId != 0) {
			map = labHandlerService
					.getSampleCollectionDetailsForNext(newOrderId);
		}
		parameterMap.put("box", box);
		parameterMap.put("diagSeqNo", diagSeqNo);
		// diagSeqNo = labHandlerService.generateDiagNumber();
		// diagSeqNo = labHandlerService.generateDiagNumber(hinId);
		map = labHandlerService.submitSampleCollectionEmpanelled(parameterMap);
		saved = (Boolean) map.get("saved");
		List<DgSampleCollectionDetails> sampleDetails = new ArrayList<DgSampleCollectionDetails>();
		if (map.get("sampleDetails") != null) {
			sampleDetails = (List<DgSampleCollectionDetails>) map
					.get("sampleDetails");
		}

		String messageTOBeVisibleToTheUser = "";
		if (saved) {
			messageTOBeVisibleToTheUser = "Sample Collection Done Successfully !!";
		} else {
			messageTOBeVisibleToTheUser = "Some Problem Occured !! Try Again ..";
		}
		url = "/hms/hms/lab?method=showPendingSampleCollectionJsp";
		int departmentId = box.getInt(DEPARTMENT_ID); 
		url1 = "/hms/hms/lab?method=showPendingSampleValidationJsp";
		
		String jsp = DG_MESSAGE_SAMPLE_COLLECTION + ".jsp";

		map.put("orderHeaderId", orderHeaderId);
		map.put("newOrderId", newOrderId);
		map.put("url", url);
		if(departmentId==45){
			map.put("url1", url1);
		}
		
		map.put("sampleDetails", sampleDetails);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	} 

	// ------------------------------Pending For Sample
	// Validation-------------------------------
	public ModelAndView showPendingSampleValidationJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		String deptType = "";
		int deptId = 0;
		Integer hospitalId = 0;
		int userId = 0;  // added by amit das on 17-07-2017
		
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		// added by amit das on 17-07-2017
		if (session.getAttribute("userId") != null) {
			userId = (int) session.getAttribute("userId");
		}
		mapForDs.put(HOSPITAL_ID, hospitalId);
		mapForDs.put("deptId", deptId);
		mapForDs.put("hospitalId",hospitalId);
		mapForDs.put("userId",userId); // added by amit das on 17-07-2017
		detailsMap = labHandlerService.getSampleValidationSearch(mapForDs);
		
		
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		int labDepartmentId = Integer.parseInt(properties.getProperty("labDepartmentId"));
		int radiologyDepartmentId = Integer.parseInt(properties.getProperty("radiologyDepartmentId"));
		
		if(radiologyDepartmentId == deptId){
			patientMap = labHandlerService.getSampleValidationGridRadiology(mapForDs);
		jsp = DG_PENDING_SAMPLE_VALIDATION + ".jsp";
		}
		 
		if(labDepartmentId == deptId){
			map.put("hinNo", "");
			map.put("pFirstName", "");	
			patientMap = labHandlerService.getSampleValidationGrid(mapForDs);
			jsp = "diag_pendingSampleValidationLab.jsp";
		}else {
			// jsp = "diag_pendingSampleValidationLab.jsp";
			jsp = DG_PENDING_SAMPLE_VALIDATION + ".jsp";
		
		}
		detailsMap.put("userId",userId); // added by amit das on 17-07-2017
		
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("deptType", deptType);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	} 
	
	public ModelAndView showPendingSampleValidationJspForEmpanelled(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		String deptType = "";
		int deptId = 0;
		Integer hospitalId = 0;
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		mapForDs.put(HOSPITAL_ID, hospitalId);
		mapForDs.put("deptId", deptId);
		mapForDs.put("hospitalId",hospitalId);
		detailsMap = labHandlerService.getSampleValidationSearch(mapForDs);
		patientMap = labHandlerService.getSampleValidationGridForEmpanelled(mapForDs);
		jsp = "diag_pendingSampleValidationForEmpanelled" + ".jsp";
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("deptType", deptType);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showPendingSampleValidationJspForQC(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		String deptType = "";
		int deptId = 0;
		Integer hospitalId = 0;
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		mapForDs.put(HOSPITAL_ID, hospitalId);
		mapForDs.put("deptId", deptId);
		detailsMap = labHandlerService.getSampleValidationSearch(mapForDs);
		patientMap = labHandlerService.getSampleValidationGrid(mapForDs);
		jsp =RequestConstants.DG_PENDING_SAMPLE_VALIDATION_FOR_QC + ".jsp";
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("deptType", deptType);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForValidation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = new Date();
		Date toDate = new Date();
		String fromDates="",toDates="";
		int chargeCodeId = 0;
		int departmentId = 0;
		int inpatientId = 0;
		int subGroupId = 0;
		int sampleId = 0;
		int hinId = 0;
		int deptId = 0;
		String patientFName = "";
		String deptName = "";
		String deptType = "";
		String hinNo = "";
		String adNo = "";
		String pType = "";
		String reason = "";
		Integer hospitalId = 0;
		String wardName = "";
		String mobileNo = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
		int uid = 0;
		String barcodetext="";
		String sampleIdSearch=null;
		
		try {
			if (session.getAttribute("deptName") != null) {
				deptName = (String) session.getAttribute("deptName");
			}
			if (session.getAttribute("deptType") != null) {
				deptType = (String) session.getAttribute("deptType");
			}
			if (session.getAttribute("users") != null) {
				Users user = (Users) session.getAttribute("users");
				uid = user.getId();
				mapForDs.put("uid", uid);
			}
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				mapForDs.put(HOSPITAL_ID, hospitalId);

			}
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
				mapForDs.put("departmentId", deptId);
			}
			
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				fromDates=request.getParameter(FROM_DATE);
				mapForDs.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				toDates=request.getParameter(TO_DATE);
				mapForDs.put("toDate", toDate);
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				pType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("pType", pType);
			}
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subGroupId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subGroupId", subGroupId);
			}
			
			if (request.getParameter(SUB_CHARGECODE_ID) != null &&
					  !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				 		subGroupId = Integer.parseInt(request
				 					.getParameter(SUB_CHARGECODE_ID));
				 	mapForDs.put("subGroupId",subGroupId); 
				 					
			} 
			  if (request.getParameter("sampleName") != null &&
					  !(request.getParameter("sampleName").equals("0"))) {
				  	sampleId =   Integer.parseInt(request.getParameter("sampleName"));
				  	mapForDs.put("sampleId", sampleId); 
			  }
			  
			  if (request.getParameterValues("invName") != null &&
					  !(request.getParameterValues("invName").length==0)) {
				  String[]  invNameId =   request.getParameterValues("invName");
				  mapForDs.put("invName", invNameId); 
			  }
			
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("departmentId", departmentId);
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(REASON) != null
					&& !(request.getParameter(REASON).equals(""))) {
				reason = request.getParameter(REASON);
				mapForDs.put("reason", reason);
			}
			if (request.getParameter(RequestConstants.WARD_NAME) != null
					&& !(request.getParameter(RequestConstants.WARD_NAME)
							.equals(""))) {
				wardName = request.getParameter(RequestConstants.WARD_NAME);
				mapForDs.put(RequestConstants.WARD_NAME, wardName);
			}
			if (request.getParameter(RequestConstants.MOBILE_NO) != null
					&& !(request.getParameter(RequestConstants.MOBILE_NO)
							.equals(""))) {
				mobileNo = request.getParameter(RequestConstants.MOBILE_NO);
				mapForDs.put(RequestConstants.MOBILE_NO, mobileNo);
			}
			
			if (request.getParameter("barcodetext") != null
					&& !(request.getParameter("barcodetext")
							.equals(""))) {
				barcodetext =request.getParameter("barcodetext").trim();
				mapForDs.put("barcodetext", barcodetext);
			}
			
			if (request.getParameter("sampleId") != null
					&& !(request.getParameter("sampleId")
							.equals(""))) {
				sampleIdSearch =request.getParameter("sampleId").trim();
				mapForDs.put("sampleIdSearch", sampleIdSearch);
			}
			String priorityId="";
			if (request.getParameter("priorityId") != null
					&& !(request.getParameter("priorityId").equals("0"))) {
				priorityId = request.getParameter("priorityId");
				mapForDs.put("priorityId", priorityId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = labHandlerService.getPatientDetailsForValidation(mapForDs);
		String jsp = "";
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDeatilList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDeatilList");
		}
		int orderId = 0,subChargeIdDup=0;
		 
		if (request.getParameter("orderId") != null
				&& !(request.getParameter("orderId").equals("0"))) {
			String CombinedIds=request.getParameter("orderId");
		
			String idsArray[]=null;
			idsArray = CombinedIds.split(",");
			orderId = Integer.parseInt(idsArray[0]);
			int subChargeId =0;
			if(null !=idsArray && idsArray.length>1  )
		      subChargeId = Integer.parseInt(idsArray[1]);
			subChargeIdDup=subChargeId;
			mapForDs.put("subChargeId", subChargeId);  
			mapForDs.put("orderId", orderId);

		}
		logger.info("orderId "+orderId);
		if (orderId != 0) {
			map = labHandlerService.getSampleValidationDetails(mapForDs);
		}
		
		//added by govind 03-05-2017
		map.put("subGroupId", subGroupId);
		int modalityId=0;
		if (request.getParameter("modalityId") != null) {
			modalityId = Integer.parseInt(request.getParameter("modalityId"));
			map.put("modalityId", modalityId);
		}
		if(modalityId==0){
			modalityId=subChargeIdDup;
			map.put("modalityId", modalityId);
		}
		//added by govind 03-05-2017 end
		if (map != null && map.get("sampleDtList") != null) {
			jsp = DG_SAMPLE_ACCEPTANCE + ".jsp";
		} else {
			detailsMap = labHandlerService.getDetailsForSearch(map);
			jsp = DG_PENDING_SAMPLE_VALIDATION + ".jsp";
		}
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("deptType", deptType);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("pFirstName", patientFName);
		map.put("barcodetext", barcodetext);  
		map.put("sampleIdSearch", sampleIdSearch);
		map.put("hinNo", hinNo);
		map.put("fromDate", fromDates);
		map.put("toDate", toDates);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForValidationForEmpanelled(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = new Date();
		Date toDate = new Date();
		int chargeCodeId = 0;
		int departmentId = 0;
		int inpatientId = 0;
		int subGroupId = 0;
		int sampleId = 0;
		int hinId = 0;
		int deptId = 0;
		String patientFName = "";
		String deptName = "";
		String deptType = "";
		String hinNo = "";
		String adNo = "";
		String flag = "";
		String pType = "";
		String reason = "";
		Integer hospitalId = 0;
		String wardName = "";
		String mobileNo = "";
		Integer barCode = 0;
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
		int uid = 0;
		try {
			if (session.getAttribute("deptName") != null) {
				deptName = (String) session.getAttribute("deptName");
			}
			if (session.getAttribute("deptType") != null) {
				deptType = (String) session.getAttribute("deptType");
			}
			if (session.getAttribute("users") != null) {
				MasEmpaneled masEmpaneled = (MasEmpaneled) session.getAttribute("users");
				//uid = user.getId();
				mapForDs.put("uid", masEmpaneled.getId());
			}
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				mapForDs.put(HOSPITAL_ID, hospitalId);

			}
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
				mapForDs.put("departmentId", deptId);
			}
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				mapForDs.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				mapForDs.put("toDate", toDate);
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				pType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("pType", pType);
			}
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subGroupId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subGroupId", subGroupId);
			}
			/*if (request.getParameter(SAMPLE_ID) != null
					&& !(request.getParameter(SAMPLE_ID).equals("0"))) {
				sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
				mapForDs.put("sampleId", sampleId);
			}*/
			if (request.getParameter(SUB_CHARGECODE_ID) != null &&
					  !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				 		subGroupId = Integer.parseInt(request
				 					.getParameter(SUB_CHARGECODE_ID));
				 	mapForDs.put("subGroupId",subGroupId); 
				 					
			} 
			  if (request.getParameter("sampleName") != null &&
					  !(request.getParameter("sampleName").equals("0"))) {
				  	sampleId =   Integer.parseInt(request.getParameter("sampleName"));
				  	mapForDs.put("sampleId", sampleId); 
			  }
			  
			  if (request.getParameterValues("invName") != null &&
					  !(request.getParameterValues("invName").length==0)) {
				  String[]  invNameId =   request.getParameterValues("invName");
				  mapForDs.put("invName", invNameId); 
			  }
			
			
			
			
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("departmentId", departmentId);
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(REASON) != null
					&& !(request.getParameter(REASON).equals(""))) {
				reason = request.getParameter(REASON);
				mapForDs.put("reason", reason);
			}
			if (request.getParameter(RequestConstants.WARD_NAME) != null
					&& !(request.getParameter(RequestConstants.WARD_NAME)
							.equals(""))) {
				wardName = request.getParameter(RequestConstants.WARD_NAME);
				mapForDs.put(RequestConstants.WARD_NAME, wardName);
			}
			if (request.getParameter(RequestConstants.MOBILE_NO) != null
					&& !(request.getParameter(RequestConstants.MOBILE_NO)
							.equals(""))) {
				mobileNo = request.getParameter(RequestConstants.MOBILE_NO);
				mapForDs.put(RequestConstants.MOBILE_NO, mobileNo);
			}
			if (request.getParameter(RequestConstants.BARCODE) != null
					&& !(request.getParameter(RequestConstants.BARCODE)
							.equals(""))) {
				barCode = Integer.parseInt(request
						.getParameter(RequestConstants.BARCODE));
				mapForDs.put(RequestConstants.BARCODE, barCode);
			}
			String priorityId="";
			if (request.getParameter("priorityId") != null
					&& !(request.getParameter("priorityId").equals("0"))) {
				priorityId = request.getParameter("priorityId");
				mapForDs.put("priorityId", priorityId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = labHandlerService.getPatientDetailsForValidationForEmpanelled(mapForDs);
		String jsp = "";
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDeatilList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDeatilList");
		}
		int orderId = 0;
		 
		if (request.getParameter("orderId") != null
				&& !(request.getParameter("orderId").equals("0"))) {
			String CombinedIds=request.getParameter("orderId");
			String idsArray[]=new String[2];
			idsArray = CombinedIds.split(",");
			orderId = Integer.parseInt(idsArray[0]); 
			int subChargeId = Integer.parseInt(idsArray[1]);
			mapForDs.put("subChargeId", subChargeId);  
			mapForDs.put("orderId", orderId);

		}
		if (orderId != 0) {
			map = labHandlerService.getSampleValidationDetailsForEmpanelled(mapForDs);
		}
		if (map != null && map.get("sampleDtList") != null) {
			jsp = "diag_sampleAcceptanceForEmpanelled" + ".jsp";
		} else {
			detailsMap = labHandlerService.getDetailsForSearch(map);
			jsp = "diag_pendingSampleValidationForEmpanelled" + ".jsp";
		}

		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("deptType", deptType);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForValidationForQC(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = new Date();
		Date toDate = new Date();
		int chargeCodeId = 0;
		int departmentId = 0;
		int inpatientId = 0;
		int subGroupId = 0;
		int sampleId = 0;
		int hinId = 0;
		int deptId = 0;
		String patientFName = "";
		String deptName = "";
		String deptType = "";
		String hinNo = "";
		String adNo = "";
		String flag = "";
		String pType = "";
		String reason = "";
		Integer hospitalId = 0;
		String wardName = "";
		String mobileNo = "";
		Integer barCode = 0;
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
		int uid = 0;
		try {
			if (session.getAttribute("deptName") != null) {
				deptName = (String) session.getAttribute("deptName");
			}
			if (session.getAttribute("deptType") != null) {
				deptType = (String) session.getAttribute("deptType");
			}
			if (session.getAttribute("users") != null) {
				Users user = (Users) session.getAttribute("users");
				uid = user.getId();
			}
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				mapForDs.put(HOSPITAL_ID, hospitalId);

			}
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
				mapForDs.put("departmentId", deptId);
			}
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				mapForDs.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				mapForDs.put("toDate", toDate);
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				pType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("pType", pType);
			}
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subGroupId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subGroupId", subGroupId);
			}
			if (request.getParameter(SAMPLE_ID) != null
					&& !(request.getParameter(SAMPLE_ID).equals("0"))) {
				sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
				mapForDs.put("sampleId", sampleId);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("departmentId", departmentId);
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(REASON) != null
					&& !(request.getParameter(REASON).equals(""))) {
				reason = request.getParameter(REASON);
				mapForDs.put("reason", reason);
			}
			if (request.getParameter(RequestConstants.WARD_NAME) != null
					&& !(request.getParameter(RequestConstants.WARD_NAME)
							.equals(""))) {
				wardName = request.getParameter(RequestConstants.WARD_NAME);
				mapForDs.put(RequestConstants.WARD_NAME, wardName);
			}
			if (request.getParameter(RequestConstants.MOBILE_NO) != null
					&& !(request.getParameter(RequestConstants.MOBILE_NO)
							.equals(""))) {
				mobileNo = request.getParameter(RequestConstants.MOBILE_NO);
				mapForDs.put(RequestConstants.MOBILE_NO, mobileNo);
			}
			if (request.getParameter(RequestConstants.BARCODE) != null
					&& !(request.getParameter(RequestConstants.BARCODE)
							.equals(""))) {
				barCode = Integer.parseInt(request
						.getParameter(RequestConstants.BARCODE));
				mapForDs.put(RequestConstants.BARCODE, barCode);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = labHandlerService.getPatientDetailsForValidation(mapForDs);
		String jsp = "";
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDeatilList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDeatilList");
		}
		int orderId = 0;
		if (request.getParameter("orderId") != null
				&& !(request.getParameter("orderId").equals("0"))) {
			orderId = new Integer(request.getParameter("orderId"));
			mapForDs.put("orderId", orderId);

		}
		if (orderId != 0) {
			map = labHandlerService.getSampleDetailsForHisto(orderId, uid,
					deptId,hospitalId);
		}
		if (map != null && map.get("samplehdList") != null) {
			jsp = DG_SAMPLE_ACCEPTANCE + ".jsp";
		} else {
			detailsMap = labHandlerService.getDetailsForSearch(map);
			jsp =RequestConstants.DG_PENDING_SAMPLE_VALIDATION_FOR_QC + ".jsp";
		}

		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("deptType", deptType);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView submitSampleAcceptance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		int hospitalId = 0;
		String userName = "";
		String deptType = "";
		Users users = null;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			parameterMap.put("userName", userName);
		}
		if (session.getAttribute(RequestConstants.USERS) != null) {
			users = (Users) session.getAttribute(RequestConstants.USERS);
			parameterMap.put(RequestConstants.USERS, users);
		}
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}
		parameterMap.put("deptType", deptType);
		int counter = 0;
		if (request.getParameter("counter1") != null) {
			counter = Integer.parseInt(request.getParameter("counter1"));
		}
		String modalityStr = request.getParameter("modalityId");
		int modalityId = 0;
		if (modalityStr!= null && !modalityStr.equals("") && !modalityStr.equals("0")) {
			modalityId = Integer.parseInt(modalityStr);
		}
		
		List accepList = new ArrayList();
		List rejList = new ArrayList();
		for (int i = 1; i <= counter; i++) {
			if (request.getParameter("check" + i) != null) {
				accepList.add("y");
			} else {
				accepList.add("n");
			}
			if (request.getParameter("check1" + i) != null) {
				rejList.add("y");
			} else {
				rejList.add("n");
			}
		}
		int sampleCollectionHeaderId = 0;
		int newSampleId = 0;
		sampleCollectionHeaderId = Integer.parseInt(request
				.getParameter("sampleCollectionHeaderId"));
		List<DgSampleCollectionHeader> patientDeatilList = new ArrayList<DgSampleCollectionHeader>();

		patientDeatilList = (List<DgSampleCollectionHeader>) session
				.getAttribute("patientDeatilList");

		if (patientDeatilList.size() > 0) {
			for (Iterator iterator = patientDeatilList.iterator(); iterator
					.hasNext();) {
				DgSampleCollectionHeader dgSampleCollectionHeader = (DgSampleCollectionHeader) iterator
						.next();
				newSampleId = dgSampleCollectionHeader.getId();
				if (newSampleId == sampleCollectionHeaderId) {
					iterator.remove();
				}
			}

		}
		int orderid=0;
		Map<String, Object> patientMap = new HashMap<String, Object>();
		if (newSampleId != 0) {
			//map = labHandlerService.getSampleValidationDetailsForNext(newSampleId,orderid); //changed by govind 3-11-2016
		}
		parameterMap.put("accepList", accepList);
		parameterMap.put("rejList", rejList);

		Box box = HMSUtil.getBox(request);
		parameterMap.put("box", box);
		boolean successfullyUpdated = false;
		successfullyUpdated = labHandlerService
				.submitSampleAcceptance(parameterMap);
		
		//added by govind 03-05-2017
		int pendSampleId=0,pendOrderid=0;
		Map<String, Object> pendMap = new HashMap<String, Object>();
		
		pendMap.put("sampleId", newSampleId);	
		pendMap.put("orderId", modalityId);
		pendMap.put("sampleCollectionHeaderId", sampleCollectionHeaderId);
		pendMap.put("hospitalId", hospitalId);
		patientMap=labHandlerService.getPendingValidation(pendMap);
		
		if(patientMap.get("pendSampleId")!=null){
			pendSampleId=(Integer)patientMap.get("pendSampleId");
			map.put("pendSampleId", pendSampleId);
		}
		if(patientMap.get("pendOrderid")!=null){
			pendOrderid=(Integer)patientMap.get("pendOrderid");
			map.put("pendOrderid", pendOrderid);
		}
		
		Integer pendHeaderId=0,pendSubChargeId=0;
		if(patientMap.get("pendHeaderId")!=null){
			pendHeaderId=(Integer)patientMap.get("pendHeaderId");
			map.put("pendHeaderId", pendHeaderId);
		}
		if(patientMap.get("pendSubChargeId")!=null){
			pendSubChargeId=(Integer)patientMap.get("pendSubChargeId");
			map.put("pendSubChargeId", pendSubChargeId);
		}
		Integer nextHeaderId=0,nextSubChargeId=0;
		 
		 if(patientMap.get("nextHeaderId")!=null){
			 nextHeaderId=(Integer)patientMap.get("nextHeaderId");
				map.put("nextHeaderId", nextHeaderId);
			}
			if(patientMap.get("nextSubChargeId")!=null){
				nextSubChargeId=(Integer)patientMap.get("nextSubChargeId");
				map.put("nextSubChargeId", nextSubChargeId);
			}
		
		if(modalityId==0){
			modalityId=pendOrderid;
		}
		//added by govind 03-05-2017 end
		String messageTOBeVisibleToTheUser = "";
		if (successfullyUpdated) {
			if (deptType.equalsIgnoreCase("DIAG")) {
				messageTOBeVisibleToTheUser = "Sample validation Done Successfully !!";
			} else if (deptType.equalsIgnoreCase("RADIO")) {
				messageTOBeVisibleToTheUser = "Radiological Investigation Accepted Successfully!!";
			}
		} else {
			messageTOBeVisibleToTheUser = "Some Problem Occured! Try Again.";
		}
		url = "/hms/hms/lab?method=showPendingSampleValidationJsp";
		if (deptType.equalsIgnoreCase("RADIO")) {
			url1 = "/hms/hms/investigation?method=showPendingResultEntryJsp";
		} else {
			url1 = "/hms/hms/investigation?method=showPendingResultEntryLabJsp";
		}

		map.put("modalityId", modalityId);
		String jsp = DG_MESSAGE_FOR_SAMPLE + ".jsp";
		map.put("newSampleId", newSampleId);
		map.put("sampleCollectionHeaderId", sampleCollectionHeaderId);
		map.put("url", url);
		map.put("url1", url1);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView submitSampleAcceptanceForEmpanelled(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		int hospitalId = 0;
		String userName = "";
		String deptType = "";
		MasEmpaneled masEmpaneled = null;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			parameterMap.put("userName", userName);
		}
		if (session.getAttribute(RequestConstants.USERS) != null) {
			masEmpaneled = (MasEmpaneled) session.getAttribute(RequestConstants.USERS);
			parameterMap.put(RequestConstants.USERS, masEmpaneled);
		}
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}
		parameterMap.put("deptType", deptType);
		int counter = 0;
		if (request.getParameter("counter1") != null) {
			counter = Integer.parseInt(request.getParameter("counter1"));
		}
		List accepList = new ArrayList();
		List rejList = new ArrayList();
		for (int i = 1; i <= counter; i++) {
			if (request.getParameter("check" + i) != null) {
				accepList.add("y");
			} else {
				accepList.add("n");
			}
			if (request.getParameter("check1" + i) != null) {
				rejList.add("y");
			} else {
				rejList.add("n");
			}
		}
		int sampleCollectionHeaderId = 0;
		int newSampleId = 0;
		sampleCollectionHeaderId = Integer.parseInt(request
				.getParameter("sampleCollectionHeaderId"));
		List<DgSampleCollectionHeader> patientDeatilList = new ArrayList<DgSampleCollectionHeader>();

		patientDeatilList = (List<DgSampleCollectionHeader>) session
				.getAttribute("patientDeatilList");

		if (patientDeatilList.size() > 0) {
			for (Iterator iterator = patientDeatilList.iterator(); iterator
					.hasNext();) {
				DgSampleCollectionHeader dgSampleCollectionHeader = (DgSampleCollectionHeader) iterator
						.next();
				newSampleId = dgSampleCollectionHeader.getId();
				if (newSampleId == sampleCollectionHeaderId) {
					iterator.remove();
				}
			}

		}
		int orderid=0;
		Map<String, Object> patientMap = new HashMap<String, Object>();
		if (newSampleId != 0) {
			map = labHandlerService
					.getSampleValidationDetailsForNext(newSampleId,orderid);//changed by govind 3-11-2016
		}
		parameterMap.put("accepList", accepList);
		parameterMap.put("rejList", rejList);

		Box box = HMSUtil.getBox(request);
		parameterMap.put("box", box);
		boolean successfullyUpdated = false;
		successfullyUpdated = labHandlerService
				.submitSampleAcceptanceForEmpanelled(parameterMap);
		String messageTOBeVisibleToTheUser = "";
		if (successfullyUpdated) {
			if (deptType.equalsIgnoreCase("DIAG")) {
				messageTOBeVisibleToTheUser = "Sample validation Done Successfully !!";
			} else if (deptType.equalsIgnoreCase("RADIO")) {
				messageTOBeVisibleToTheUser = "Radiological Investigation Accepted Successfully!!";
			}
		} else {
			messageTOBeVisibleToTheUser = "Some Problem Occured! Try Again.";
		}
		url = "/hms/hms/lab?method=showPendingSampleValidationJsp";
		if (deptType.equalsIgnoreCase("RADIO")) {
			url1 = "/hms/hms/investigation?method=showPendingResultEntryJsp";
		} else {
			url1 = "/hms/hms/investigation?method=showPendingResultEntryLabJsp";
		}
		String jsp = DG_MESSAGE_FOR_SAMPLE + ".jsp";
		map.put("newSampleId", newSampleId);
		map.put("sampleCollectionHeaderId", sampleCollectionHeaderId);
		map.put("url", url);
		map.put("url1", url1);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// -----------------------Reports-----------------------------------
	public ModelAndView showPatientDiagnosticRegisterJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			parameters.put("deptId",deptId);
		}
		if (session.getAttribute("hospitalId") != null) {
			parameters.put("hospitalId", session.getAttribute("hospitalId"));
		}
		map = labHandlerService.showDiagnosticRegisterJsp(parameters);
		jsp = DG_PATIENT_DIAGNOSTIC_REGISTER;
		jsp += ".jsp";
		title = "Diagnostic Register Doctor Wise"; 
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showDiagnosticRegisterDoctorWise(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		Integer hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put(HOSPITAL_ID, hospitalId);
		map.put("deptId", deptId);
		map = labHandlerService.showDiagnosticRegisterDoctorWise(map);
		jsp = DG_DIAGNOSTIC_REGISTER_DOCTOR_WISE;
		jsp += ".jsp";
		title = "Diagnostic Register Doctor Wise";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showDiagnosticRegisterDiagnosisWise(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		map = labHandlerService.showDiagnosticRegisterDiagnosisWise(map);
		jsp = DG_DIAGNOSTIC_REGISTER_DIAGNOSIS_WISE;
		jsp += ".jsp";
		title = "Diagnostic Register Diagnosis Wise";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showTotalTestPerformedReport(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		map = labHandlerService.showDiagnosticRegisterDiagnosisWise(map);
		jsp = TOTAL_TEST_PERFORMED_REPORT_JSP;
		jsp += ".jsp";
		title = "Diagnostic Register Diagnosis Wise";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPackingListJsp(HttpServletRequest request,
			HttpServletResponse response) {
		map = labHandlerService.showPackingListJsp();
		jsp = PACKING_LIST;
		jsp += ".jsp";
		title = "Packing list";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------------Generates
	// reports------------------------------------------------

	// ------------------------------------ Patient Diagnostic Register
	// --------------------------
	public ModelAndView generatePatientDiagnosticRegister(
			HttpServletRequest request, HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();
		int subChargeId = 0;
		int depart = 0;
		int departmentId = 0;
		String patient = "";
		String resultType = "";
		String query = "";
		String selectedRadio = "n";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();

		try {
			if (request.getParameter(SELECTED_RADIO) != null) {
				selectedRadio = request.getParameter(SELECTED_RADIO);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}

			/*
			 * query = " where dg_result_entry_header.result_date between
			 * $P{fromDate} and $P{toDate} " + "and
			 * dg_result_entry_header.hin_id !='' or
			 * dg_result_entry_header.hin_id !=null";
			 */
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				query = query
						+ " AND dg_result_entry_header.sub_chargecode_id = "
						+ subChargeId;
			}

			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				depart = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
				query = query + " AND dg_orderhd.department_id = " + depart;
			}

			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals("0"))) {
				patient = (request.getParameter(PATIENT_TYPE));
				query = query + " AND dg_orderhd.patient_type = '" + patient
						+ "'";
			}

			if (request.getParameter("resultType") != null
					&& !(request.getParameter("resultType").equals("0"))) {
				resultType = request.getParameter("resultType");
				query = query + " AND dg_result_entry_detail.result_type = '"
						+ resultType + "'";
			}

			if (session.getAttribute("deptId") != null) {
				departmentId = Integer.parseInt(""
						+ session.getAttribute("deptId"));
				query = query
						+ " AND dg_result_entry_header.department_id = "
						+ departmentId;
			}

			query = query + " AND dg_result_entry_header.result_status = 'A'";

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = labHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("QUERY", query);
		if (selectedRadio.equals("y")) {
			try {
				if (resultType.equals("t")) {
					HMSUtil.generateReport("diagnosticRegisterTemp",
							parameters, (Connection) detailsMap.get("con"),
							response, getServletContext());
				} else {
					HMSUtil.generateReport("diagnosticRegister", parameters,
							(Connection) detailsMap.get("con"), response,
							getServletContext());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (selectedRadio.equals("n")) {
			try {
				if (resultType.equals("t")) {
					HMSUtil.generateReport("diagnosticRegisterTemp",
							parameters, (Connection) detailsMap.get("con"),
							response, getServletContext());
				} else {
					HMSUtil.generateReport("diagnosticRegisterForBilling",
							parameters, (Connection) detailsMap.get("con"),
							response, getServletContext());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// -------------------------for Diagnostic register Doctor
	// Wise-----------------------------

	public ModelAndView generateDiagnosticRegisterDoctorWise(
			HttpServletRequest request, HttpServletResponse response) {
		String fromDate = null;
		String toDate = null;
		int departmentId = 0;
		int employeeId = 0;
		int subChargeId = 0;
		String patient = "";
		StringBuilder query = new StringBuilder("");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE)));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE)));
			}

			query = query
					.append(" where dgresultentryheader.result_date between '"
							+ fromDate + "' and '" + toDate + "'");

			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				query = query
						.append(" AND dgresultentryheader.sub_chargecode_id= "
								+ subChargeId);

			}

			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals("0"))) {
				patient = (request.getParameter(PATIENT_TYPE));
				query = query.append(" AND dgorderhd.patient_type = '"
						+ patient + "'");

			}

			if (request.getParameter(EMPLOYEE_ID) != null
					&& !(request.getParameter(EMPLOYEE_ID).equals(""))) {
				employeeId = Integer
						.parseInt(request.getParameter(EMPLOYEE_ID));
				query = query
						.append(" AND dgresultentryheader.result_verified_by = "
								+ employeeId);

			}

			if (session.getAttribute("deptId") != null) {
				departmentId = Integer.parseInt(""
						+ session.getAttribute("deptId"));
				query = query
						.append(" AND dgresultentryheader.department_id = "
								+ departmentId);

			}

			query = query
					.append(" AND dgresultentryheader.result_status = 'A'");
			query = query.append(" AND dgresultentryheader.hospital_id ="
					+ session.getAttribute(HOSPITAL_ID));

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = labHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("qry", query.toString());
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));
		try {
			HMSUtil.generateReport("diagnosticRegisterDoctorWise", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	// =====================================End
	// ====================================================================

	public ModelAndView generateDiagnosticRegisterDiagnosisWise(
			HttpServletRequest request, HttpServletResponse response) {

		String fromDate = null;
		String toDate = null;
		int chargeCodeId = 0;
		int subCharge = 0;
		int departmentId = 0;
		String query = "";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE)));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE)));
			}
			query = " where dgresultentryheader.result_date between '"
					+ fromDate + "' and '" + toDate + "'";

			if (session.getAttribute("deptId") != null) {
				departmentId = Integer.parseInt(""
						+ session.getAttribute("deptId"));
				query = query + " AND dgresultentryheader.department_id = "
						+ departmentId;
			}

			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subCharge = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				query = query + " AND dgresultentryheader.sub_chargecode_id = "
						+ subCharge;
			}

			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals(""))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				query = query + " AND dgresultentrydetail.investigation_id = "
						+ chargeCodeId;
			}

			query = query + " AND dgresultentryheader.result_status = 'A'";
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = labHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("QUERY", query);
		parameters.put("SUBREPORTPATH",
				getServletContext().getRealPath("/Reports/"));

		try {
			HMSUtil.generateReport(
					"diagnosticRegisterDiagnosticregisterDaignosisWise",
					parameters, (Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	// *************************Vishal Code End for
	// Reports*******************************************

	// *************************By Tirath for Total Test Performed
	// Report*************************//

	public ModelAndView generateTotalTestPerformedReport(
			HttpServletRequest request, HttpServletResponse response) {

		Date fromDate = null;
		Date toDate = null;
		int departmentId = 0;
		int hospitalId = 0;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}

			if (session.getAttribute("deptId") != null) {
				departmentId = Integer.parseInt(""
						+ session.getAttribute("deptId"));

			}

			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = labHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("hospitalId", hospitalId);
		parameters.put("deptId", departmentId);

		try {
			HMSUtil.generateReport("totalTestPerfrmed", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	public ModelAndView generatePackingList(HttpServletRequest request,
			HttpServletResponse response) {

		String fromDate = null;
		String toDate = null;
		int mainCharge = 0;
		int subCharge = 0;
		int collectionCenter = 0;
		String patientType = null;
		String query = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE)));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE)));
			}
			if (request.getParameter(MAIN_CHARGECODE_ID) != null
					&& !(request.getParameter(MAIN_CHARGECODE_ID).equals("0"))) {
				mainCharge = Integer.parseInt(request
						.getParameter(MAIN_CHARGECODE_ID));
			}
			if (request.getParameter("subChargeCode_id") != null
					&& !(request.getParameter("subChargeCode_id").equals("0"))) {
				subCharge = Integer.parseInt(request
						.getParameter("subChargeCode_id"));
			}

			if (request.getParameter(COLLECTION_CENTER_ID) != null
					&& !(request.getParameter(COLLECTION_CENTER_ID).equals("0"))) {
				collectionCenter = Integer.parseInt(request
						.getParameter(COLLECTION_CENTER_ID));
			}
			query = " where dg_sample_collection_header.sample_collection_date between '"
					+ fromDate
					+ "' and '"
					+ toDate
					+ "' and dg_sample_collection_details.`order_status` = 'P' and  dg_sample_collection_details.`maincharge` = '"
					+ mainCharge
					+ "' and dg_sample_collection_details.`subcharge` = '"
					+ subCharge
					+ "' and  dg_sample_collection_details.`collection_center_id` = '"
					+ collectionCenter + "' ";

			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals("0"))) {
				patientType = (request.getParameter(PATIENT_TYPE));
				query = query + " AND dg_orderhd.`patient_type` = '"
						+ patientType + "'";
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = labHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("QUERY", query);
		try {
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport(PACKING_LIST_REPORT), parameters,
						(Connection) detailsMap.get("con"));

			} catch (JRException e) {

				e.printStackTrace();
			}
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = response.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------ Diagnostic Register Doctor Wise
	// --------------------------
	public ModelAndView showDepartmentWiseSummary(HttpServletRequest request,
			HttpServletResponse response) {
		map = labHandlerService.showDepartmentWiseSummary();
		// jsp = DEPARTMENR_WISE_SUMMARY;
		jsp += ".jsp";
		title = "Department Wise Summary";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateDepartmentWiseSummary(
			HttpServletRequest request, HttpServletResponse response) {
		String fromDate = null;
		String toDate = null;
		int collectionCenterId = 0;
		String query = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE)));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE)));
			}

			query = " where dg_sample_collection_header.sample_collection_date between '"
					+ fromDate
					+ "' and '"
					+ toDate
					+ "' and dg_sample_collection_header.`order_status` = 'A' ";

			if (request.getParameter(COLLECTION_CENTER_ID) != null
					&& !(request.getParameter(COLLECTION_CENTER_ID).equals("0"))) {
				collectionCenterId = Integer.parseInt(request
						.getParameter(COLLECTION_CENTER_ID));
				query = query
						+ " AND  dg_sample_collection_details.`collection_center_id` = "
						+ collectionCenterId;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = labHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("qry", query);
		try {
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("departmentWiseSummary"), parameters,
						(Connection) detailsMap.get("con"));

			} catch (JRException e) {

				e.printStackTrace();
			}
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = response.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView getLabReportList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		try {
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				detailsMap.put("serviceNo", serviceNo);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				detailsMap.put("hinNo", hinNo);
			}
			List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
			List<Object> hinNoList = new ArrayList<Object>();
			String flag = "";

			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (flag.equals("order")) {
				orderNoList = labHandlerService.getOrderNoList(detailsMap);
				map.put("orderNoList", orderNoList);
				// jsp = RESPONSE_FOR_LAB_DIAG_NO;

			} else if (flag.equals("hin")) {
				hinNoList = labHandlerService.getHinNoList(serviceNo);
				map.put("hinNoList", hinNoList);

				jsp = "responseForLabPatientName";

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView getLabOrderReportList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String hinNo = "";
		String orderNo = "";
		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				detailsMap.put("hinNo", hinNo);
			}
			if (request.getParameter(ORDER_NO) != null
					&& !(request.getParameter(ORDER_NO).equals(""))) {
				orderNo = request.getParameter(ORDER_NO);
				detailsMap.put("orderNo", orderNo);
			}
			List<Object> resultList = new ArrayList<Object>();
			List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
			String flag = "";

			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (flag.equals("result")) {
				resultList = labHandlerService.getResultList(detailsMap);
				map.put("resultList", resultList);
			} else if (flag.equals("order")) {
				orderNoList = labHandlerService.getOrderNoList(detailsMap);
				map.put("orderNoList", orderNoList);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView showResultEntryReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		// jsp = RESULT_ENTRY_REPORT_JSP+".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings({ "unchecked", "unchecked" })
	public ModelAndView showResultEntryReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String orderNo = "";
		String hinNo = "";
		if (request.getParameter(ORDER_NO) != null) {
			orderNo = request.getParameter(ORDER_NO);
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = labHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("diagNo", orderNo);
		parameters.put("hinNo", hinNo);
		try {
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("resultEntryReport"), parameters,
						(Connection) detailsMap.get("con"));

			} catch (JRException e) {

				e.printStackTrace();
			}
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = response.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView nextForSampleCollection(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		HttpSession session = request.getSession();
		String hinNo = "";
		Box box = null;
		String pType = "";
		String patientFName = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String adNo = "";
		int chargeCodeId = 0;
		int departmentId = 0;
		int subGroupId = 0;
		int inpatientId = 0;
		int sampleId = 0;
		int hinId = 0;
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		if (session.getAttribute("box") != null) {
			box = (Box) session.getAttribute("box");
		}

		if (box.getInt(INPATIENT_ID) != 0) {
			inpatientId = box.getInt(INPATIENT_ID);
			mapForDs.put("inpatientId", inpatientId);
		}
		if (box.get(PATIENT_TYPE) != null
				&& !(box.get(PATIENT_TYPE).equals(""))) {
			pType = box.get(PATIENT_TYPE);
			mapForDs.put("pType", pType);
		}
		if (box.getInt(CHARGE_CODE_ID) != 0) {
			chargeCodeId = box.getInt(request.getParameter(CHARGE_CODE_ID));
			mapForDs.put("chargeCodeId", chargeCodeId);
		}
		if (box.getInt(SUB_CHARGECODE_ID) != 0) {
			subGroupId = box.getInt(request.getParameter(SUB_CHARGECODE_ID));
			mapForDs.put("subGroupId", subGroupId);
		}
		if (box.getInt(SAMPLE_ID) != 0) {
			sampleId = box.getInt(request.getParameter(SAMPLE_ID));
			mapForDs.put("sampleId", sampleId);
		}
		if (box.get(HIN_NO) != null && !(box.get(HIN_NO).equals(""))) {
			hinNo = box.get(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}
		if (box.get(FROM_DATE) != null && !(box.get(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(box.get(FROM_DATE));
			mapForDs.put("fromDate", fromDate);
		}
		if (box.get(TO_DATE) != null && !(box.get(TO_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(box.get(TO_DATE));
			mapForDs.put("toDate", toDate);
		}
		if (box.get(P_FIRST_NAME) != null
				&& !(box.get(P_FIRST_NAME).equals(""))) {
			patientFName = box.get(P_FIRST_NAME);
			mapForDs.put("patientFName", patientFName);
		}
		if (box.get(AD_NO) != null && !(box.get(AD_NO).equals(""))) {
			adNo = box.get(AD_NO);
			mapForDs.put("adNo", adNo);
		}

		if (box.getInt(DEPARTMENT_ID) != 0) {
			departmentId = box.getInt(DEPARTMENT_ID);
			mapForDs.put("departmentId", departmentId);
		}

		if (box.getInt(HIN_ID) != 0) {
			hinId = box.getInt(HIN_ID);
			mapForDs.put("hinId", hinId);
		}
		
		String deptName = "";
		Integer hospitalId = 0;
		String patientType = null;
		int deptId;
		if (request.getParameter("flag") != null) {
			patientType = (String) request.getParameter("flag");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			mapForDs.put("departmentId", deptId);
		}
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		mapForDs.put(PATIENT_TYPE, patientType);
		mapForDs.put("hospitalId", hospitalId);
		
		
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<DgOrderhd> patientDetailList = new ArrayList<DgOrderhd>();
		patientMap = labHandlerService
				.getPatientDetailsSampleColletion(mapForDs);
		if(null != patientMap.get("patientDetailList"))
		patientDetailList = (List<DgOrderhd>) patientMap.get("patientDetailList");
		int orderHeaderId = 0;
		int newOrderId = 0;
		if (request.getParameter(ORDER_BOOKING_ID) != null) {
			orderHeaderId = Integer.parseInt(request
					.getParameter(ORDER_BOOKING_ID));
		}
		if (patientDetailList.size() > 0) {

			for (Iterator iterator = patientDetailList.iterator(); iterator
					.hasNext();) {
				DgOrderhd dgOrderhd = (DgOrderhd) iterator.next();
				newOrderId = dgOrderhd.getId();
				if (newOrderId == orderHeaderId) {
					iterator.remove();
				}
			}
		}

		Map<String, Object> map = new HashMap<String, Object>();
		Set<DgOrderdt> dgOrderDetailSet = new HashSet<DgOrderdt>();
		
		if (newOrderId != 0) {
			map = labHandlerService
					.getSampleCollectionDetailsForNext(newOrderId);
		}
		if (newOrderId == 0) {
			jsp = "diag_messageForBackCollection" + ".jsp";
			messageTOBeVisibleToTheUser = "No Records Found !!";
		} else if (patientDetailList.size() > 0) {

			jsp = DG_SAMPLE_COLLECTION + ".jsp";
		}
		map.put("newOrderId", newOrderId);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView nextForSampleValidation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		HttpSession session = request.getSession();
		String hinNo = "";
		Box box = null;
		String pType = "";
		String patientFName = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String adNo = "";
		int chargeCodeId = 0;
		int departmentId = 0;
		int subGroupId = 0;
		int inpatientId = 0;
		int sampleId = 0;
		String orderType = "";
		int hinId = 0;
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		if (session.getAttribute("box") != null) {
			box = (Box) session.getAttribute("box");
		}

		if (box.getInt(INPATIENT_ID) != 0) {
			inpatientId = box.getInt(INPATIENT_ID);
			mapForDs.put("inpatientId", inpatientId);
		}
		if (box.get(PATIENT_TYPE) != null
				&& !(box.get(PATIENT_TYPE).equals(""))) {
			pType = box.get(PATIENT_TYPE);
			mapForDs.put("pType", pType);
		}
		if (box.getInt(CHARGE_CODE_ID) != 0) {
			chargeCodeId = box.getInt(request.getParameter(CHARGE_CODE_ID));
			mapForDs.put("chargeCodeId", chargeCodeId);
		}
		if (box.getInt(SUB_CHARGECODE_ID) != 0) {
			subGroupId = box.getInt(request.getParameter(SUB_CHARGECODE_ID));
			mapForDs.put("subGroupId", subGroupId);
		}
		if (box.getInt(SAMPLE_ID) != 0) {
			sampleId = box.getInt(request.getParameter(SAMPLE_ID));
			mapForDs.put("sampleId", sampleId);
		}
		if (box.get(HIN_NO) != null && !(box.get(HIN_NO).equals(""))) {
			hinNo = box.get(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}
		if (box.get(FROM_DATE) != null && !(box.get(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(box.get(FROM_DATE));
			mapForDs.put("fromDate", fromDate);
		}
		if (box.get(TO_DATE) != null && !(box.get(TO_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(box.get(TO_DATE));
			mapForDs.put("toDate", toDate);
		}
		if (box.get(P_FIRST_NAME) != null
				&& !(box.get(P_FIRST_NAME).equals(""))) {
			patientFName = box.get(P_FIRST_NAME);
			mapForDs.put("patientFName", patientFName);
		}
		if (box.get(AD_NO) != null && !(box.get(AD_NO).equals(""))) {
			adNo = box.get(AD_NO);
			mapForDs.put("adNo", adNo);
		}

		if (box.getInt(DEPARTMENT_ID) != 0) {
			departmentId = box.getInt(DEPARTMENT_ID);
			mapForDs.put("departmentId", departmentId);
		}

		if (box.getInt(HIN_ID) != 0) {
			hinId = box.getInt(HIN_ID);
			mapForDs.put("hinId", hinId);
		}
		
		
				
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<DgSampleCollectionHeader> patientDeatilList = new ArrayList<DgSampleCollectionHeader>();
		patientMap = labHandlerService.getPatientDetailsForValidation(mapForDs);
		patientDeatilList = (List<DgSampleCollectionHeader>) session
				.getAttribute("patientDeatilList");
	
		int sampleCollectionHeaderId = 0;
		int newSampleId = 0,orderId=0,subId=0;
		if (request.getParameter("sampleCollectionHeaderId") != null) {
			sampleCollectionHeaderId = Integer.parseInt(request
					.getParameter("sampleCollectionHeaderId"));
		}
		List<Object[]> patientDeatilList1 = new ArrayList<Object[]>();
		if(session.getAttribute("patientDeatilList1") != null){
			patientDeatilList1= (List<Object[]>)session.getAttribute("patientDeatilList1");
		}
		
		if (patientDeatilList.size() > 0) {

			for (Iterator iterator = patientDeatilList.iterator(); iterator
					.hasNext();) {
				DgSampleCollectionHeader dgSampleCollectionHeader = (DgSampleCollectionHeader) iterator
						.next();
				newSampleId = dgSampleCollectionHeader.getId();
				if (newSampleId == sampleCollectionHeaderId) {
					iterator.remove();
				}
			
			}
		}
		//added by govind 3-11-2016
		if (patientDeatilList1 != null && patientDeatilList1.size() > 0) { 
				for(int ilop=0;ilop<patientDeatilList1.size();ilop++) {
					DgSampleCollectionHeader dgSampleCollectionHeader=(DgSampleCollectionHeader)patientDeatilList1.get(ilop)[0];
					if(newSampleId==dgSampleCollectionHeader.getId()){
						orderId=((MasSubChargecode)patientDeatilList1.get(ilop)[1]).getId();
					}
				}				
		}//added by govind 3-11-2016
		
		logger.info(" old newSampleId "+newSampleId);
		Map<String, Object> map = new HashMap<String, Object>();
		Set<DgSampleCollectionDetails> dgSampleDetailSet = new HashSet<DgSampleCollectionDetails>();
		
		logger.info("newSampleId "+newSampleId+" orderId "+orderId);
		
		//added by govind 03-05-2017
		int modalityId=0,pendSampleId=0,pendOrderid=0,copySampleId=0;
		if (request.getParameter("modalityId") != null) {
			modalityId = Integer.parseInt(request.getParameter("modalityId"));
			}
		
		if (request.getParameter("pendSampleId") != null) {
			pendSampleId = Integer.parseInt(request.getParameter("pendSampleId"));
			if(pendSampleId>0){
			newSampleId=pendSampleId;
			}
			
		}
		if (request.getParameter("pendOrderid") != null) {
			pendOrderid = Integer.parseInt(request.getParameter("pendOrderid"));
		}	
		String pendVar="";
		if(request.getParameter("pendVar") != null){
			pendVar=request.getParameter("pendVar");
		}
		if(pendVar.equalsIgnoreCase("N")){
			if(modalityId>0){
				orderId=modalityId;
			}
			if (newSampleId == 0) {
				map = labHandlerService
						.getSampleValidationDetailsForNext(newSampleId,orderId);
				if(map.get("copySampleId")!=null){
					copySampleId=(Integer)map.get("copySampleId");
				}
			}
		}else{
			if(pendOrderid>0){
				orderId=pendOrderid;
			}
		}
		//added by govind 03-05-2017 end
		
		if (newSampleId != 0) {
			map = labHandlerService
					.getSampleValidationDetailsForNext(newSampleId,orderId);//changed by govind 3-11-2016
		}
		
		map.put("modalityId", modalityId);		
		if(copySampleId>0){
			newSampleId=copySampleId;	
		}
		if (newSampleId == 0) {
			jsp = "diag_messageForBackValidation" + ".jsp";
			messageTOBeVisibleToTheUser = "No Records Found !!";
		} else if (patientDeatilList.size() > 0) {

			jsp = DG_SAMPLE_ACCEPTANCE + ".jsp";
		}
		map.put("newSampleId", newSampleId);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * public ModelAndView showSampleNo(HttpServletRequest
	 * request,HttpServletResponse response) { Map<String, Object> map = new
	 * HashMap<String, Object>();
	 * 
	 * String sampleSeqNo = "" ; int inc = 0; sampleSeqNo =
	 * labHandlerService.getSampleSeqForDisplay("SN");
	 * if(request.getParameter("inc")!= null){ inc =
	 * Integer.parseInt(request.getParameter("inc")); map.put("inc", inc); } jsp
	 * = RESPONCE_FOR_SAMPLE_NO; map.put("sampleSeqNo" , sampleSeqNo);
	 * map.put("contentJsp", jsp); map.put("title", title); return new
	 * ModelAndView(jsp, "map", map); }
	 */

	// -------------Jasper Compiled Report
	// --------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView updateOrderBookingForInvestigation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> detailsMapForOrder = new HashMap<String, Object>();

		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int chargeMainIdFromRequest = 0;
		int noOfRecords = 0;
		int inpatientId = 0;
		int placedBy = 0;
		int pageNo = 1;
		int hinId = 0;
		int visitId = 0;
		String provisionalDiag = "";
		String buttonFlag = "";
		String clinicalNote = "";
		String orderSeqNo = "";
		String orderStatus = "";
		String createdBy = "";
		String testType = "";
		String hinNo = "";
		String visitNo = "";
		String date = "";
		String time = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		List chargeList = new ArrayList();
		List qtyList = new ArrayList();
		List mainChargeList = new ArrayList();
		List subChargeList = new ArrayList();
		@SuppressWarnings("unused")
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Map<String, Object> creationDetailsMap = new HashMap<String, Object>();

		if (request.getParameter(HIN_ID) != null) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter("dgOrderhdId") != null) {
			chargeMainIdFromRequest = Integer.parseInt(request
					.getParameter("dgOrderhdId"));
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}
		if (request.getParameter(VISIT_NUMBER) != null) {
			visitNo = request.getParameter(VISIT_NUMBER);
		}
		if (request.getParameter(VISIT_ID) != null) {
			visitId = Integer.parseInt(request.getParameter(VISIT_ID));
		}
		if (!request.getParameter(INPATIENT_ID).equals("")) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		if (!request.getParameter(EMPLOYEE_ID).equals("0")) {

			placedBy = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(TEST_TYPE) != null
				&& !(request.getParameter(TEST_TYPE).equals(""))) {
			testType = request.getParameter(TEST_TYPE);
		}
		if (request.getParameter(CLINICAL_NOTE) != null
				&& !(request.getParameter(CLINICAL_NOTE).equals(""))) {
			clinicalNote = request.getParameter(CLINICAL_NOTE);
		}
		if (request.getParameter(CREATED_BY) != null
				&& !(request.getParameter(CREATED_BY).equals(""))) {
			createdBy = request.getParameter(CREATED_BY);
			creationDetailsMap.put("createdBy", createdBy);
		}
		if (request.getParameter(PROVISIONAL_DIAG) != null
				&& !(request.getParameter(PROVISIONAL_DIAG).equals(""))) {
			provisionalDiag = request.getParameter(PROVISIONAL_DIAG);
		}

		if (request.getParameter("buttonFlag") != null) {
			buttonFlag = request.getParameter("buttonFlag");
		}
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}
		if (request.getParameter(ORDER_NO) != null) {
			orderSeqNo = request.getParameter(ORDER_NO);
		}

		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			creationDetailsMap.put("userName", userName);
		}
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");

		}
		DgOrderhd dgOrderhd = new DgOrderhd();
		// delete all the data from the DgorderDt and DgOrderHd corresponding to
		// orderNo
		if (session.getAttribute("dgOrderhd") != null) {
			dgOrderhd = (DgOrderhd) session.getAttribute("dgOrderhd");

		}

		if (session.getAttribute("dgOrderhd") != null) {
			creationDetailsMap.put("originalDgOrderhd",
					(DgOrderhd) session.getAttribute("dgOrderhd"));
		}
		session.removeAttribute("dgOrderhd");
		creationDetailsMap.put("userName", userName);
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();

		if (pageNo == 1) {

			if (departmentId != 0) {
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				dgOrderhd.setDepartment(masDepartment);
			}

			if (placedBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(placedBy);
				dgOrderhd.setPrescribedBy(masEmployee);
			}
			dgOrderhd.setProvisionalDiag(provisionalDiag);
			dgOrderhd.setTestType(testType);
			dgOrderhd.setClinicalNote(clinicalNote);
			dgOrderhd.setLastChgTime(time);
			dgOrderhd.setLastChgBy(user);

			dgOrderhd.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));

			creationDetailsMap.put("dgOrderhd", dgOrderhd);
			creationDetailsMap.put("departmentId", departmentId);
			creationDetailsMap.put("hospitalId", hospitalId);
			creationDetailsMap.put("hinId", hinId);
		}
		try {

			Vector quantity = box.getVector(QUANTITY);
			Vector charge_code_id = box.getVector(CHARGE_CODE_ID);
			Vector main_charge_id = box.getVector("mainCharge");
			Vector sub_charge_id = box.getVector("subCharge");
			String diagnosisNo = box.getString(DIAGNOSIS_NO);
			int counter = 0;

			for (int i = 0; i < charge_code_id.size(); i++) {
				if (!charge_code_id.get(i).toString().equals("")) {
					counter++;
				}
			}
			noOfRecords = counter;
			for (int i = 0; i < noOfRecords; i++) {
				chargeList.add(charge_code_id.get(i));
				mainChargeList.add(main_charge_id.get(i));
				subChargeList.add(sub_charge_id.get(i));
				qtyList.add(quantity.get(i));
			}

			creationDetailsMap.put("chargeMainIdFromRequest",
					chargeMainIdFromRequest);
			creationDetailsMap.put("chargeList", chargeList);
			creationDetailsMap.put("qtyList", qtyList);
			creationDetailsMap.put("mainChargeList", mainChargeList);
			creationDetailsMap.put("subChargeList", subChargeList);
			creationDetailsMap.put("userId", userId);
			creationDetailsMap.put("createdBy", createdBy);
		} catch (Exception e) {
			e.printStackTrace();
		}
		creationDetailsMap.put("box", box);
		boolean success = false;
		String jsp = "";
		String message = "";
		int dgOrderhdId = 0;
		creationDetailsMap.put("newDgOrderhd", dgOrderhd);
		returnMap = labHandlerService.updateOrderDetails(creationDetailsMap);

		if (returnMap.get("success") != null) {
			success = (Boolean) returnMap.get("success");
		}

		if (success) {
			if (buttonFlag.equals("next")) {
				pageNo++;
				infoMap.put("orderId", dgOrderhd.getId());
				message = "Order Updation has been done Successfully !!Do you want to print ? ";
				detailsMapForOrder = labHandlerService.getOrderDetails(infoMap);
				detailsMap = labHandlerService.getMainAndSubCharge();
				map.put("detailsMap", detailsMap);
				map.put("pageNo", pageNo);
				if (returnMap.get("dgOrderhdId") != null) {
					dgOrderhdId = (Integer) returnMap.get("dgOrderhdId");
					map.put("dgOrderhdId", dgOrderhdId);
				}
				String includedJsp = DG_INVESTIGATION_ORDER_BOOKING + ".jsp";
				map.put("includedJsp", includedJsp);
				jsp = DG_OP_ORDER_BOOKING_SEARCH_JSP + ".jsp";
			} else {
				jsp = MSG_FOR_LAB + ".jsp";
				pageNo++;
				message = "Order Update has been done Successfully !!  Do you want to print ? ";

				map.put("visitNo", dgOrderhd.getVisit().getVisitNo().toString());
				map.put("hinNo", dgOrderhd.getHin().getHinNo());
			}
		} else {
			jsp = MSG_FOR_LAB + ".jsp";
			message = " Try Again !!";
		}
		map.put("orderSeqNo", orderSeqNo);
		map.put("pageNo", pageNo);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showTemplateHelpJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String templateFileName = "Template help";
		templateFileName = templateFileName + ".doc";
		try {
			response.setContentType("application/msword");
			response.setHeader("Content-Disposition", "inline; filename="
					+ templateFileName);
			File f = new File(getServletContext().getRealPath(
					"/templateHelp/Template help.doc"));
			InputStream in = new FileInputStream(f);
			ServletOutputStream outs = response.getOutputStream();
			int bit = 256;
			while ((bit) >= 0) {
				bit = in.read();
				outs.write(bit);
			}
			outs.flush();
			outs.close();
			in.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return null;
	}

	public ModelAndView showChargeListReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = labHandlerService.getMainChargeList();
		map.put("contentJsp", "chargeList.jsp");
		return new ModelAndView("index", "map", map);
	}

	public void getSubChargeCodeList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int mainCharge = 0;
		if (request.getParameter("mainCharge") != null
				&& !request.getParameter("mainCharge").equals("0")) {
			mainCharge = Integer.parseInt(request.getParameter("mainCharge"));
		}
		StringBuffer sb = new StringBuffer();
		List<MasSubChargecode> masSubChargecodeList = new ArrayList<MasSubChargecode>();
		map = labHandlerService.getSubChargeCodeList(mainCharge);
		if (map.get("masSubChargecodeList") != null) {
			masSubChargecodeList = (List<MasSubChargecode>) map
					.get("masSubChargecodeList");
		}
		if (map.get("masSubChargecodeList") != null
				&& masSubChargecodeList.size() > 0) {
			for (MasSubChargecode masSubChargecode : masSubChargecodeList) {
				sb.append("<item>");
				sb.append("<id>" + masSubChargecode.getId() + "</id>");
				sb.append("<pvms>" + masSubChargecode.getSubChargecodeCode()
						+ "</pvms>");

				sb.append("<name>" + masSubChargecode.getSubChargecodeName()
						+ "</name>");
				sb.append("</item>");
			}

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
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
	}

	public ModelAndView getChargeCodeList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int subCharge = 0;
		if (request.getParameter("subCharge") != null
				&& !request.getParameter("subCharge").equals("0")) {
			subCharge = Integer.parseInt(request.getParameter("subCharge"));
		}

		map = labHandlerService.getChargeCodeList(subCharge);
		return new ModelAndView("responseForChargeList", "map", map);
	}

	public ModelAndView printChargeListReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String query = "";
		String hospitalName = "";
		int hospitalId = 0;
		HttpSession session = request.getSession();
		hospitalId = (Integer) session.getAttribute("hospitalId");
		Date effectiveDate = null;

		try {

			if (request.getParameter("mainCharge") != null
					&& (!request.getParameter("mainCharge").equals("0"))) {
				query = "where  ss.main_chargecode_id = "
						+ request.getParameter("mainCharge") + " ";
			}
			if (request.getParameter("subCharge") != null
					&& (!request.getParameter("subCharge").equals("0"))) {
				query = query + "and  ss.sub_chargecode_id = "
						+ request.getParameter("subCharge") + " ";
			}
			if (request.getParameter("charge") != null
					&& (!request.getParameter("charge").equals("0"))) {
				query = query + "and  ss.charge_code_id = "
						+ request.getParameter("charge") + " ";
			}
			if (request.getParameter(TO_DATE) != null
					&& (!request.getParameter(TO_DATE).equals(""))) {
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL1 = formatterOut.format(formatterIn
						.parse(request.getParameter(TO_DATE)));

				query = query + "and ss.date_effective_to >= '" + date4MySQL1
						+ "' ";

			}
			hospitalName = labHandlerService.getHospitalName(hospitalId);
			parameters.put("effectiveDate", effectiveDate);
			parameters.put("hospitalName", hospitalName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		detailsMap = labHandlerService.getConnectionForReport();

		parameters.put("qry", query);
		try {

			HMSUtil.generateReport("chargewise_summary_report", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(getServletContext().getRealPath(
				"/Reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile);

		return jasperReport;
	}

	// ---------OrderStatus Report-(By dipali)
	public ModelAndView showOrderStatusReportDepartmentWise(
			HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		Map requestMap = new HashMap();
		requestMap.put("deptId", deptId);

		map = labHandlerService.getMainAndSubCharge();
		jsp = ORDER_STATUS_REPORT_SEARCH_JSP;
		jsp += ".jsp";
		title = "Total Order Booked";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showOrderStatusBookedReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		String query = "";
		String fromDate = null;
		String toDate = null;
		String hospitalName = "";
		String hospitalAddress = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int departmentId = 0;
		int subChargeId = 0;
		int depart = 0;
		int hospitalId = 0;
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();

		try {

			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				mapForDs.put(HOSPITAL_ID, hospitalId);
			}

			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				parameters.put("subChargeId", subChargeId);
				query = query + " AND mas_sub_chargecode.sub_chargecode_id = "
						+ subChargeId;
				mapForDs.put("subChargeId", subChargeId);
			}
			if (request.getParameter(MAIN_CHARGECODE_ID) != null
					&& !(request.getParameter(MAIN_CHARGECODE_ID).equals("0"))) {
				depart = Integer.parseInt(request
						.getParameter(MAIN_CHARGECODE_ID));
				parameters.put("depart", depart);
				parameters.put("mainChargeCodeId", depart);
				mapForDs.put("mainChargeCodeId", depart);
				query = query
						+ " AND mas_main_chargecode.main_chargecode_id = "
						+ depart;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap = labHandlerService.getTotalCountDepartmentWise(mapForDs);
		detailsMap = labHandlerService.getConnectionForReport();
		hospitalName = labHandlerService.getHospitalName(hospitalId);
		hospitalAddress = labHandlerService.getHospitalAddress(hospitalId);
		parameters.put("hospitalName", hospitalName);
		parameters.put("hospitalAddress", hospitalAddress);
		parameters.put("pendingForSampleValidationListTotal",
				dataMap.get("pendingForSampleValidationListTotal"));
		parameters.put("pendingForResultEntryListTotal",
				dataMap.get("pendingForResultEntryListTotal"));
		parameters.put("pendingForResultValidationListTotal",
				dataMap.get("pendingForResultValidationListTotal"));
		parameters.put("currentTime", utilMap.get("currentTime"));
		parameters.put("QUERY", query);
		parameters.put("hospital_id", hospitalId);
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));
		try {
			HMSUtil.generateReport("orderStatusDetailsReport", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView getOrderNoListForOrderStatus(
			HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		List<NursingcareSetup> nursingcareSetupList = new ArrayList<NursingcareSetup>();
		Box box = HMSUtil.getBox(request);

		int deptId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int inPatientId = Integer.parseInt(request.getParameter("parent"));
		String deptName = request.getParameter("deptName");

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap.put("inPatientId", inPatientId);
		detailsMap.put("deptId", deptId);

		box.put(RequestConstants.DEPT_ID, deptId);
		box.put(RequestConstants.HOSPITAL_ID, hospitalId);
		box.put(RequestConstants.INPATIENT_ID, inPatientId);

		dgOrderhdList = labHandlerService.getOrderNoList(detailsMap);
		nursingcareSetupList = labHandlerService.getNursingcareSetupList(box);

		jsp = ORDER_STATUS_FOR_WARD_MANAGEMENT;
		jsp += ".jsp";
		title = "OrderBooking";

		map.put("inPatientId", inPatientId);
		map.put("nursingcareSetupList", nursingcareSetupList);
		map.put("dgOrderhdList", dgOrderhdList);
		map.put("deptName", deptName);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView viewAllTestForOrderNo(HttpServletRequest request,
			HttpServletResponse response) {
		List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> orderDetailMap = new HashMap<String, Object>();
		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}
		HttpSession session = request.getSession();
		String deptName = "";
		String jsp = "";
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		mapForDs.put(HOSPITAL_ID, hospitalId);

		int dgOrderHdId = 0;
		int inPatientId = 0;
		if (request.getParameter("dgOrderHdId") != null) {
			dgOrderHdId = Integer.parseInt(request.getParameter("dgOrderHdId"));
			mapForDs.put("dgOrderHdId", dgOrderHdId);
		}
		if (request.getParameter(INPATIENT_ID) != null) {
			inPatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			mapForDs.put("inPatientId", inPatientId);
		}
		// orderNoList = labHandlerService.getOrderNoList(mapForDs);
		orderDetailMap = labHandlerService.getOrderDtMap(mapForDs);

		jsp = VIEW_TEST_DETAILS_FOR_ORDER_NO;
		map.put("orderDetailMap", orderDetailMap);
		map.put("orderNoList", orderNoList);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView selectViewAccOrderStatus(HttpServletRequest request,
			HttpServletResponse response) {

		List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> resultTypeDetailMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String appendedHtml = "";

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}

		HttpSession session = request.getSession();
		String deptName = "";
		String jsp = "";
		String resultType = "";
		String orderStatus = "";
		String result = "";
		Integer deptId = 0;
		String confidential = "";
		String rejectedStatus = "";
		String chargeCode = "";
		int hinId = 0;

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		int dgMasInvestigationId = 0;
		int dgOrderdtId = 0;
		int dgResultEntryDetailId = 0;
		int dgResultEntryDetailLabId = 0;
		int dgSampleCollectionDetailLabId = 0;
		int dgResultEntryHeaderLabId = 0;
		int dgResultEntryHeaderSenLabId = 0;
		String rejReason = "";

		DgResultEntryDetail dgResultEntryDetail = null;
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();

		if (request.getParameter("dgMasInvestigationId") != null) {
			dgMasInvestigationId = Integer.parseInt(request
					.getParameter("dgMasInvestigationId"));
			mapForDs.put("dgMasInvestigationId", dgMasInvestigationId);
		}
		if (request.getParameter("resultType") != null) {
			resultType = request.getParameter("resultType");
			mapForDs.put("resultType", resultType);
		}
		if (request.getParameter("dgOrderdtId") != null) {
			dgOrderdtId = Integer.parseInt(request.getParameter("dgOrderdtId"));
			mapForDs.put("dgOrderdtId", dgOrderdtId);
		}
		if (request.getParameter("dgResultEntryDetailLabId") != null) {
			dgResultEntryDetailLabId = Integer.parseInt(request
					.getParameter("dgResultEntryDetailLabId"));
			mapForDs.put("dgResultEntryDetailId", dgResultEntryDetailLabId);
		}
		if (request.getParameter("dgResultEntryHeaderLabId") != null) {
			dgResultEntryHeaderLabId = Integer.parseInt(request
					.getParameter("dgResultEntryHeaderLabId"));
			mapForDs.put("dgResultEntryHeaderLabId", dgResultEntryHeaderLabId);
		}
		if (request.getParameter("dgSampleCollectionDetailLabId") != null) {
			dgSampleCollectionDetailLabId = Integer.parseInt(request
					.getParameter("dgSampleCollectionDetailLabId"));
			mapForDs.put("dgSampleCollectionDetailLabId",
					dgSampleCollectionDetailLabId);
		}
		if (request.getParameter("dgResultEntryHeaderSenLabId") != null) {
			dgResultEntryHeaderSenLabId = Integer.parseInt(request
					.getParameter("dgResultEntryHeaderSenLabId"));
			mapForDs.put("dgResultEntryHeaderSenLabId",
					dgResultEntryHeaderSenLabId);
		}
		if (request.getParameter("orderStatus") != null) {
			orderStatus = request.getParameter("orderStatus");
			mapForDs.put("orderStatus", orderStatus);
		}
		if (request.getParameter("confidential") != null) {
			confidential = request.getParameter("confidential");
			mapForDs.put("confidential", confidential);
		}
		if (request.getParameter("rejectedStatus") != null) {
			rejectedStatus = request.getParameter("rejectedStatus");
			mapForDs.put("rejectedStatus", rejectedStatus);
		}
		if (request.getParameter("rejReason") != null) {
			rejReason = request.getParameter("rejReason");
			mapForDs.put("rejReason", rejReason);
		}
		if (request.getParameter("chargeCode") != null) {
			chargeCode = request.getParameter("chargeCode");
			mapForDs.put("chargeCode", chargeCode);
		}

		if (request.getParameter("hinId") != null) {
			hinId = Integer.parseInt(request.getParameter("hinId"));

			mapForDs.put("hinId", hinId);
		}

		if (dgMasInvestigationId != 0) {
			//
			if (orderStatus.equalsIgnoreCase("P")) {
				String[] orderStatusMsg = { "Sample is Not Collected." };

				map.put("orderStatusMsg", orderStatusMsg);
				jsp = "msgForOrderStatus";
			} else if (orderStatus.equalsIgnoreCase("C")) {
				String[] orderStatusMsg = { "Sample is Collected for This Test." };

				map.put("orderStatusMsg", orderStatusMsg);
				jsp = "msgForOrderStatus";
			} else if (orderStatus.equalsIgnoreCase("X")) {
				String[] orderStatusMsg = { "This Test is cancelled." };

				map.put("orderStatusMsg", orderStatusMsg);
				jsp = "msgForOrderStatus";
			}
		} else if (dgSampleCollectionDetailLabId != 0) {
			//
			if (orderStatus.equalsIgnoreCase("P")) {
				if (rejectedStatus != null
						&& rejectedStatus.equalsIgnoreCase("y")) {
					if (rejReason != null && !rejReason.equals("")) {
						String[] orderStatusMsg = { "Sample is rejected (Reason :"
								+ rejReason + ")" };
						map.put("orderStatusMsg", orderStatusMsg);

					} else {
						String[] orderStatusMsg = { "Sample is rejected." };
						map.put("orderStatusMsg", orderStatusMsg);
					}
				} else {
					String[] orderStatusMsg = { "Sample is pending for validation For this Test."

					};

					/*
					 * String[] orderStatusMsg = {"Sample is collected For this
					 * Test." ,"But it is still pending for validation." };
					 */
					map.put("orderStatusMsg", orderStatusMsg);
				}
				jsp = "msgForOrderStatus";
			} else if (orderStatus.equalsIgnoreCase("A")) {
				String[] orderStatusMsg = {
						"Sample is validated for this Test.",
						"Sample is still pending for result entry." };
				map.put("orderStatusMsg", orderStatusMsg);
				jsp = "msgForOrderStatus";
			} else if (orderStatus.equalsIgnoreCase("X")) {
				String[] orderStatusMsg = { "This Test is cancelled." };

				map.put("orderStatusMsg", orderStatusMsg);
				jsp = "msgForOrderStatus";
			}
		} else if (dgResultEntryHeaderLabId != 0) {
			//
			map = labHandlerService.getResultEntryDetailsForLabOrderStatus(
					dgResultEntryHeaderLabId, deptId);
			if (confidential.equalsIgnoreCase("y")) {
				// || orderStatus.equalsIgnoreCase("P")){
				jsp = "msgForOrderStatus";
			} else {
				if (resultType.equalsIgnoreCase("m")) {
					jsp = VIEW_MULTIPLE_PARAMETER_STATUS;
				}
			}
		} else if (dgResultEntryHeaderSenLabId != 0) {
			//
			map = labHandlerService.getResultEntryDetailsForLabOrderStatus(
					dgResultEntryHeaderSenLabId, deptId);
			if (confidential.equalsIgnoreCase("y")) {
				// || orderStatus.equalsIgnoreCase("P")){
				jsp = "msgForOrderStatus";
			} else {
				if (resultType.equalsIgnoreCase("v")) {
					jsp = VIEW_SENSITIVE_STATUS;
				}
			}
		} else if (dgResultEntryDetailLabId != 0) {
			//
			if (resultType.equalsIgnoreCase("s")) {
				map = labHandlerService.getResultForRadiologyTest(mapForDs);
				if (map.get("dgResultEntryDetailList") != null) {
					dgResultEntryDetailList = (List) map
							.get("dgResultEntryDetailList");
				}
				if (dgResultEntryDetailList.size() > 0) {
					dgResultEntryDetail = dgResultEntryDetailList.get(0);
					result = dgResultEntryDetail.getResult();
					map.put("dgResultEntryDetail", dgResultEntryDetail);
					map.put("result", result);
				}
				if (confidential.equalsIgnoreCase("y")) {
					// || orderStatus.equalsIgnoreCase("P")){
					jsp = "msgForOrderStatus";
				} else {
					jsp = VIEW_SINGLE_PARAMETER_STATUS;
				}
			} else if (resultType.equalsIgnoreCase("t")) {
				try {
					map = labHandlerService.getResultForRadiologyTest(mapForDs);
					if (map.get("dgResultEntryDetailList") != null) {
						dgResultEntryDetailList = (List) map
								.get("dgResultEntryDetailList");
					}
					if (dgResultEntryDetailList.size() > 0) {
						dgResultEntryDetail = dgResultEntryDetailList.get(0);
						result = dgResultEntryDetail.getResult();
						map.put("dgResultEntryDetail", dgResultEntryDetail);
						map.put("result", result);

						InputStream is = new FileInputStream(
								getServletContext().getRealPath(
										"jsp/pdf/appendingHtml.html"));
						File temprory1 = new File(getServletContext()
								.getRealPath("jsp/pdf/appendingHtml.html"));
						byte[] b3 = new byte[(int) temprory1.length()];
						int offset = 0;
						int numRead = 0;
						try {
							while ((offset < b3.length)
									&& ((numRead = is.read(b3, offset,
											b3.length - offset)) >= 0)) {
								offset += numRead;
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
						try {
							is.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						appendedHtml = new String(b3);
						new File(getServletContext().getRealPath("/temp/"))
								.mkdir();
						if (request.getAttribute("secondRequest") == null) {

							File temprory = new File(getServletContext()
									.getRealPath("/temp/" + "temp.html"));
							FileOutputStream fos = null;
							try {
								fos = new FileOutputStream(getServletContext()
										.getRealPath("/temp/" + "temp.html"));
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							} catch (IllegalStateException e1) {
								e1.printStackTrace();
							}
							try {
								fos.write(dgResultEntryDetail.getResult()
										.getBytes());
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (confidential.equalsIgnoreCase("y")) {
					// || orderStatus.equalsIgnoreCase("P")){
					jsp = "msgForOrderStatus";
				} else {
					jsp = VIEW_TEMPLATE_STATUS_FOR_LAB;
				}
			}
		}
		if ((dgResultEntryDetailLabId != 0 || dgResultEntryHeaderSenLabId != 0 || dgResultEntryHeaderLabId != 0)) {
			// && !confidential.equals("y")){
			if (orderStatus.equalsIgnoreCase("P")) {
				String[] orderStatusMsg = {
						"This Test is still Pending For Result Validation.",
						"Result is entered which is shown below" };
				// String[] orderStatusMsg = {"This Test is still Pending For
				// Result Validation."};
				map.put("orderStatusMsg", orderStatusMsg);
			}
			if (!confidential.equals("y")) {
				if (orderStatus.equalsIgnoreCase("A")) {
					String[] orderStatusMsg = {
							"Result is validated for This Test.",
							"Result entered is shown as below" };
					map.put("orderStatusMsg", orderStatusMsg);
				}
			} else if (confidential.equals("y")) {
				String[] orderStatusMsg = { "This Test result is confidential." };
				map.put("orderStatusMsg", orderStatusMsg);
			}
		}/*
		 * else if((dgResultEntryDetailLabId != 0 || dgResultEntryHeaderSenLabId
		 * != 0 || dgResultEntryHeaderLabId != 0) && confidential.equals("y")){
		 * String[] orderStatusMsg = {"This Test result is
		 * confidential."}; map.put("orderStatusMsg", orderStatusMsg); }
		 */

		map.put("orderNoList", orderNoList);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		//
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView printResultForRadiology(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}

		HttpSession session = request.getSession();
		String deptName = "";
		String jsp = "";
		String resultType = "";
		String orderStatus = "";

		String appendedHtml = "";
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();
		DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
		String result = "";

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}

		int dgMasInvestigationId = 0;
		int dgOrderdtId = 0;
		int dgResultEntryDetailId = 0;
		int dgSampleCollectionDetailId = 0;
		boolean resultEntered = false;
		String confidential = "";
		String rejectedStatus = "";
		String rejReason = "";

		if (request.getParameter("resultType") != null) {
			resultType = request.getParameter("resultType");
			mapForDs.put("resultType", resultType);
		}
		if (request.getParameter("dgResultEntryDetailId") != null) {
			dgResultEntryDetailId = Integer.parseInt(request
					.getParameter("dgResultEntryDetailId"));
			mapForDs.put("dgResultEntryDetailId", dgResultEntryDetailId);
		}
		if (request.getParameter("dgSampleCollectionDetailId") != null) {
			dgSampleCollectionDetailId = Integer.parseInt(request
					.getParameter("dgSampleCollectionDetailId"));
			mapForDs.put("dgSampleCollectionDetailId",
					dgSampleCollectionDetailId);
		}
		if (request.getParameter("orderStatus") != null) {
			orderStatus = request.getParameter("orderStatus");
			mapForDs.put("orderStatus", orderStatus);
		}
		if (request.getParameter("confidential") != null) {
			confidential = request.getParameter("confidential");
			mapForDs.put("confidential", confidential);
		}

		if (request.getParameter("rejectedStatus") != null) {
			rejectedStatus = request.getParameter("rejectedStatus");
			mapForDs.put("rejectedStatus", rejectedStatus);
		}
		if (request.getParameter("rejReason") != null) {
			rejReason = request.getParameter("rejReason");
			mapForDs.put("rejReason", rejReason);
		}

		if (dgResultEntryDetailId != 0) {
			map = labHandlerService.getResultForRadiologyTest(mapForDs);

			if (map.get("dgResultEntryDetailList") != null) {
				dgResultEntryDetailList = (List) map
						.get("dgResultEntryDetailList");
			}
			if (dgResultEntryDetailList.size() > 0) {
				dgResultEntryDetail = dgResultEntryDetailList.get(0);
				result = dgResultEntryDetail.getResult();
				map.put("dgResultEntryDetail", dgResultEntryDetail);
				map.put("result", result);

				try {
					InputStream is = new FileInputStream(getServletContext()
							.getRealPath("jsp/pdf/appendingHtml.html"));
					File temprory1 = new File(getServletContext().getRealPath(
							"jsp/pdf/appendingHtml.html"));
					byte[] b3 = new byte[(int) temprory1.length()];
					int offset = 0;
					int numRead = 0;
					try {
						while ((offset < b3.length)
								&& ((numRead = is.read(b3, offset, b3.length
										- offset)) >= 0)) {
							offset += numRead;

						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					appendedHtml = new String(b3);
					new File(getServletContext().getRealPath("/temp/")).mkdir();
					if (request.getAttribute("secondRequest") == null) {
						File temprory = new File(getServletContext()
								.getRealPath("/temp/" + "temp.html"));
						FileOutputStream fos = null;
						try {
							fos = new FileOutputStream(getServletContext()
									.getRealPath("/temp/" + "temp.html"));
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						} catch (IllegalStateException e1) {
							e1.printStackTrace();
						}
						try {
							fos.write(dgResultEntryDetail.getResult()
									.getBytes());
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (resultType.equalsIgnoreCase("t")) {
				if (orderStatus.equalsIgnoreCase("P")) {
					String[] orderStatusMsg = { "This Test is still Pending For Report Validation." };
					/*
					 * String[] orderStatusMsg = {"This Test is still Pending
					 * For Report Validation." ,"Report is entered which is
					 * shown below"};
					 */
					map.put("orderStatusMsg", orderStatusMsg);
				} else if (orderStatus.equalsIgnoreCase("A")) {
					String[] orderStatusMsg = {
							"Report is validated for This Test.",
							"Report entered is shown as below" };
					map.put("orderStatusMsg", orderStatusMsg);
				}
			}
			resultEntered = true;
		}
		if (dgSampleCollectionDetailId != 0) {
			if (resultType.equalsIgnoreCase("t")) {
				if (orderStatus.equalsIgnoreCase("P")) {
					if (rejectedStatus != null
							&& rejectedStatus.equalsIgnoreCase("y")) {
						if (rejReason != null && !rejReason.equals("")) {
							String[] orderStatusMsg = { "This test is Rejected (Reason :."
									+ rejReason + ")" };
							map.put("orderStatusMsg", orderStatusMsg);
						} else {
							String[] orderStatusMsg = { "This test is Rejected." };
							map.put("orderStatusMsg", orderStatusMsg);
						}

					} else {
						String[] orderStatusMsg = { "This test is still pending for Acceptance Of Radiological Investigation." };
						map.put("orderStatusMsg", orderStatusMsg);
					}
				} else if (orderStatus.equalsIgnoreCase("A")) {
					String[] orderStatusMsg = { "This Test is Accepted For Radiological Investigation." };
					map.put("orderStatusMsg", orderStatusMsg);
				} else if (orderStatus.equalsIgnoreCase("X")) {
					String[] orderStatusMsg = { "This Test is Cancelled." };
					map.put("orderStatusMsg", orderStatusMsg);
				}
			}
		}
		if (resultEntered) {
			if (orderStatus.equalsIgnoreCase("P")) {
				// jsp = "msgForOrderStatus";
				jsp = VIEW_TEMPLATE_STATUS;
			} else if (orderStatus.equals("A")) {
				if (confidential.equalsIgnoreCase("y")) {
					String[] orderStatusMsg = { "This Test result is Confidential." };
					map.put("orderStatusMsg", orderStatusMsg);
					jsp = "msgForOrderStatus";
				} else {
					jsp = VIEW_TEMPLATE_STATUS;
				}
			}
		} else {
			jsp = "msgForOrderStatus";
		}

		map.put("deptName", deptName);
		map.put("appendedHtml", appendedHtml);
		map.put("contentJsp", jsp);
		map.put("resultEntered", resultEntered);

		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView printOrderStatusReport(HttpServletRequest request,
			HttpServletResponse response) {
		List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> orderDetailMap = new HashMap<String, Object>();
		List<DgResultEntryHeader> dgResultEntryHeaderLabList = new ArrayList<DgResultEntryHeader>();
		Map<String, Object> resultDetailsMap = new HashMap<String, Object>();
		List<Map<String, Object>> resultDetailsMapList = new ArrayList<Map<String, Object>>();

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}

		HttpSession session = request.getSession();
		String deptName = "";
		String jsp = "";
		int deptId = 0;

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		int orderNoIdForReport = 0;
		int inPatientId = 0;
		if (request.getParameter("orderNoIdForReport") != null
				&& !(request.getParameter("orderNoIdForReport")).equals("")) {
			orderNoIdForReport = Integer.parseInt(request
					.getParameter("orderNoIdForReport"));
			mapForDs.put("orderIdForReport", orderNoIdForReport);
		}
		if (request.getParameter(INPATIENT_ID) != null) {
			inPatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			mapForDs.put("inPatientId", inPatientId);
		}
		/*
		 * if (inPatientId==0 && request.getParameter("inPatientId") != null &&
		 * !(request.getParameter("inPatientId")).equals("")) { inPatientId =
		 * Integer.parseInt(request.getParameter("inPatientId"));
		 * mapForDs.put("inPatientId", inPatientId); }
		 */

		orderDetailMap = labHandlerService.printOrderStatusReport(mapForDs);

		if (orderDetailMap.get("dgResultEntryHeaderLabList") != null) {
			dgResultEntryHeaderLabList = (List) orderDetailMap
					.get("dgResultEntryHeaderLabList");
			for (DgResultEntryHeader dgResultEntryHeader : dgResultEntryHeaderLabList) {
				resultDetailsMap = labHandlerService
						.getResultEntryDetailsForLabOrderStatus(
								dgResultEntryHeader.getId(), deptId);
				resultDetailsMapList.add(resultDetailsMap);
			}
			map.put("resultDetailsMapList", resultDetailsMapList);
		}

		jsp = VIEW_TEST_DETAILS_REPORT_ORDER_STATUS;

		map.put("orderDetailMap", orderDetailMap);
		map.put("orderNoList", orderNoList);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);

		return new ModelAndView(jsp, "map", map);

	}// --------------------------------------------------------------------------------------------------

	// ----------------------Method Written For show Department Wise Monthly
	// Summary Report---------------//
	// ------Method Written By Tirath ----------//
	public ModelAndView showDepartmentWiseMonthlySummary(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		map.put("deptId", deptId);
		map = labHandlerService.showDepartmentWiseMonthlySummary(map);
		jsp = DEPARTMENT_WISE_MONTHLY_SUMMARY_JSP;
		jsp += ".jsp";
		title = "Department wise monthly summary 	";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------------------End
	// Method-------------------------------------------------------//

	// ----------------------Method Written For show Daily Blood Collection
	// Report---------------//
	// ------Method Written By Tirath ----------//

	public ModelAndView showDailyBloodCollectionReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			map.put("deptId", deptId);
		}
		map = labHandlerService.showDailyBloodCollectionReport(map);
		jsp = DAILY_BLOOD_COLLECTION_REPORT_JSP;
		jsp += ".jsp";
		title = "Daily Blood collection centre wise report ";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------------------End
	// Method-------------------------------------------------------//

	// ----------------------Method Written For show Daily Blood Collection
	// Report---------------//
	// ------Method Written By Tirath ----------//

	public ModelAndView showPatientTestReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int deptId = 0;

		jsp = PATIENT_TEST_RESULT_PRINT_REPORT_JSP;
		jsp += ".jsp";
		title = "Patient Test Result Print";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------------------End
	// Method-------------------------------------------------------//

	public ModelAndView printDailyBloodCollectionCenterWise(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuilder query = new StringBuilder("");
		String hospitalName = "";
		int hospitalId = 0;
		String fromDate = "";
		String toDate = "";
		Date fromDate1 = null;
		Date toDate1 = null;
		HttpSession session = request.getSession();
		hospitalId = (Integer) session.getAttribute("hospitalId");
		Date effectiveDate = null;

		try {

			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& (!request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				query = query.append("where dsch.collection_center_id= "
						+ request.getParameter(SUB_CHARGECODE_ID) + " ");
			}

			if (request.getParameter(FROM_DATE) != null
					&& (!request.getParameter(FROM_DATE).equals(""))) {

				fromDate1 = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}

			if (request.getParameter(TO_DATE) != null
					&& (!request.getParameter(TO_DATE).equals(""))) {

				toDate1 = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}

			if (request.getParameter(FROM_DATE) != null
					&& (!request.getParameter(FROM_DATE).equals(""))) {

				if (request.getParameter(TO_DATE) != null
						&& (!request.getParameter(TO_DATE).equals(""))) {

					SimpleDateFormat formatterIn = new SimpleDateFormat(
							"dd/MM/yyyy");
					SimpleDateFormat formatterOut = new SimpleDateFormat(
							"yyyy-MM-dd");
					fromDate = formatterOut.format(formatterIn.parse(request
							.getParameter(FROM_DATE)));

					toDate = formatterOut.format(formatterIn.parse(request
							.getParameter(TO_DATE)));

					query = query
							.append("and dsch.sample_validation_date between'"
									+ fromDate + "'  and '" + toDate + "' ");

					query = query
							.append(" and dsch.hospital_id= " + hospitalId);

				}
			}

			hospitalName = labHandlerService.getHospitalName(hospitalId);
			parameters.put("fromDate", fromDate1);
			parameters.put("toDate", toDate1);
			parameters.put("query", query.toString());
			parameters.put("hospitalName", hospitalName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		detailsMap = labHandlerService.getConnectionForReport();

		parameters.put("qry", query);
		try {

			HMSUtil.generateReport("Daily_Blood_Collection_Center_Wise_Report",
					parameters, (Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printDepartmentWiseMonthlySummaryReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuilder query = new StringBuilder("");
		String hospitalName = "";
		int hospitalId = 0;
		String fromDate = "";
		String toDate = "";
		Date fromDate1 = null;
		Date toDate1 = null;
		HttpSession session = request.getSession();
		hospitalId = (Integer) session.getAttribute("hospitalId");
		Date effectiveDate = null;

		try {

			if (request.getParameter(FROM_DATE) != null
					&& (!request.getParameter(FROM_DATE).equals(""))) {

				fromDate1 = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}

			if (request.getParameter(TO_DATE) != null
					&& (!request.getParameter(TO_DATE).equals(""))) {

				toDate1 = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}

			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			if (request.getParameter(FROM_DATE) != null
					&& (!request.getParameter(FROM_DATE).equals(""))) {
				fromDate = formatterOut.format(formatterIn.parse(request
						.getParameter(FROM_DATE)));
			}
			if (request.getParameter(TO_DATE) != null
					&& (!request.getParameter(TO_DATE).equals(""))) {
				toDate = formatterOut.format(formatterIn.parse(request
						.getParameter(TO_DATE)));
			}
			int deptId = 0;
			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}

			query = query.append("where dreh.result_date between'" + fromDate
					+ "'  and '" + toDate + "' ");
			/*
			 * This code is done by Mukesh Narayan SIngh Date 28 Oct 2010 in
			 * Silvassa Under Guide Of Dharmendra Kumar
			 */
			if (deptId > 0) {

				query = query.append(" and dreh.department_id=" + deptId);
			}
			/*
			 * End Of COde for deptId
			 */
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& (!request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				query = query.append(" and dreh.sub_chargecode_id= "
						+ request.getParameter(SUB_CHARGECODE_ID) + " ");
			}
			query = query.append(" and dreh.hospital_id= " + hospitalId);
			hospitalName = labHandlerService.getHospitalName(hospitalId);
			parameters.put("fromDate", fromDate1);
			parameters.put("toDate", toDate1);
			parameters.put("query", query.toString());
			parameters.put("hospitalName", hospitalName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		detailsMap = labHandlerService.getConnectionForReport();
		parameters.put("qry", query);
		try {

			HMSUtil.generateReport("Department_Wise_Monthly_Summary_Report",
					parameters, (Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	// *********************************Method written For Patient Test Result
	// Print*******************************//

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientTestResultPrint(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String hinNo = "";
		String pType = "";
		String adNo = "";
		int deptId = 0;
		int hospitalId = 0;

		String userName = "";
		String orderNo = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
			mapForDs.put(HOSPITAL_ID, hospitalId);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		try {

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}

			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}

			mapForDs.put("deptId", deptId);

			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				pType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("pType", pType);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = labHandlerService.searchPatientTestResultPrint(mapForDs);
		String jsp = "";
		int id = 0;
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailsList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailsList");
		}

		jsp = PATIENT_TEST_RESULT_PRINT_REPORT_JSP + ".jsp";

		patientMap.put("patientList", patientList);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("id", id);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// ******************************************* Written By
	// Tirath**********************************//
	public ModelAndView showInvestigationReportTemplateJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		int userId = 0;
		int mainChargecodeId = 0;
		int subChargecodeId = 0;
		int chargeCodeId = 0;
		String investigationName = "";
		String deptType = "";
		int pageNoTempFromBackButton = 0;
		session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		Box box = HMSUtil.getBox(request);
		box.put("deptId", deptId);
		// box.put("deptId", deptId);
		Map<String, Object> map = new HashMap<String, Object>();

		map = labHandlerService.showInvestigationReportTemplateJsp(box);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);

		String jsp = INVESTIGATION_TEMPLATE_REPORT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public ModelAndView addInvestigationReportTemplate(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MasLionc masLionc = new MasLionc();
		String changedBy = "";
		Date currentDate = new Date();
		int investigationId = 0;
		int seqNo = 0;
		int groupSeqNo = 0;
		String reportName = "";
		String groupName = "";
		int hospitalId = 0;
		int deptId = 0;
		String status = "";
		boolean successfullyAdded = false;
		session = request.getSession();
		synchronized (session) {
			if (session.getAttribute("userName") != null) {
				userName = (String) session.getAttribute("userName");
			}
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}

			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}
		}
		Box box = HMSUtil.getBox(request);
		box.put("deptId", deptId);
		if (request.getParameter(INVESTIGATION_ID) != null) {
			investigationId = Integer.parseInt(request
					.getParameter(INVESTIGATION_ID));
		}
		if (request.getParameter(REPORT_NAME) != null) {
			reportName = (request.getParameter(REPORT_NAME));

		}
		if (request.getParameter(SEQUENCE_NO) != null) {
			seqNo = Integer.parseInt(request.getParameter(SEQUENCE_NO));
		}

		if (request.getParameter(GROUP_NAME) != null) {
			groupName = request.getParameter(GROUP_NAME);
		}

		if (request.getParameter(GROUP_SEQUENCE) != null
				&& !request.getParameter(GROUP_SEQUENCE).equals("")) {
			groupSeqNo = Integer.parseInt(request.getParameter(GROUP_SEQUENCE));
		}

		if (request.getParameter(STATUS) != null) {
			status = request.getParameter(STATUS);
		}

		DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
		DgMasInvestigationReportTemplate dgMasInvestigationReportTemplate = new DgMasInvestigationReportTemplate();
		try {

			if (investigationId != 0) {
				dgMasInvestigation.setId(investigationId);
				dgMasInvestigationReportTemplate
						.setInvestigationId(dgMasInvestigation);
			}
			dgMasInvestigationReportTemplate.setReportName(reportName);
			dgMasInvestigationReportTemplate.setGroupName(groupName);
			dgMasInvestigationReportTemplate.setSeq(seqNo);
			dgMasInvestigationReportTemplate.setGroupSeq(groupSeqNo);
			dgMasInvestigationReportTemplate.setStatus("y");
		} catch (Exception e) {
			e.printStackTrace();
		}
		successfullyAdded = labHandlerService
				.addInvestigationReportTemplate(dgMasInvestigationReportTemplate);
		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !";

		}

		try {
			map = labHandlerService.showInvestigationReportTemplateJsp(box);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = INVESTIGATION_TEMPLATE_REPORT_JSP;
		title = "Investigation Template Report Jsp";
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		map.put("investigationReportTemplateList",
				map.get("investigationReportTemplateList"));
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	/** start of edit Lion Class method * */
	public ModelAndView editInvestigationReportTemplate(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MasLionc masLionc = new MasLionc();
		String changedBy = "";
		Date currentDate = new Date();
		int investigationId = 0;
		int seqNo = 0;
		int groupSeqNo = 0;
		String reportName = "";
		String groupName = "";
		int hospitalId = 0;
		int deptId = 0;
		int classId = 0;
		String status = "";
		boolean dataUpdated = false;
		session = request.getSession();
		synchronized (session) {
			if (session.getAttribute("userName") != null) {
				userName = (String) session.getAttribute("userName");
			}
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}

			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}
		}
		Box box = HMSUtil.getBox(request);
		box.put("deptId", deptId);
		if (request.getParameter(INVESTIGATION_ID) != null) {
			investigationId = Integer.parseInt(request
					.getParameter(INVESTIGATION_ID));
		}
		if (request.getParameter(REPORT_NAME) != null) {
			reportName = (request.getParameter(REPORT_NAME));

		}
		if (request.getParameter(SEQUENCE_NO) != null) {
			seqNo = Integer.parseInt(request.getParameter(SEQUENCE_NO));
		}

		if (request.getParameter(GROUP_NAME) != null) {
			groupName = request.getParameter(GROUP_NAME);
		}

		if (request.getParameter(GROUP_SEQUENCE) != null) {
			groupSeqNo = Integer.parseInt(request.getParameter(GROUP_SEQUENCE));
		}

		if (request.getParameter(STATUS) != null) {
			status = request.getParameter(STATUS);
		}

		if (request.getParameter(COMMON_ID) != null
				&& (!request.getParameter(COMMON_ID).equals("0"))) {
			classId = Integer.parseInt(request.getParameter(COMMON_ID));
		}

		generalMap.put("investigationId", investigationId);
		generalMap.put("reportName", reportName);
		generalMap.put("seqNo", seqNo);
		generalMap.put("flag", true);
		generalMap.put("groupName", groupName);
		generalMap.put("groupSeqNo", groupSeqNo);
		generalMap.put("classId", classId);

		dataUpdated = labHandlerService
				.editInvestigationReportTemplate(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant Be Updated !!";
		}

		url = "/hms/hms/investigation?method=showLioncSubClassJsp";

		try {
			map = labHandlerService.showInvestigationReportTemplateJsp(box);

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = INVESTIGATION_TEMPLATE_REPORT_JSP;
		title = "edit Investigation Template";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("investigationReportTemplateList",
				map.get("investigationReportTemplateList"));
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("deprecation")
	public ModelAndView deleteInvestigationReportTemplate(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int classId = 0;
		String message = null;
		String flag = "";
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}

		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		box.put("deptId", deptId);

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			classId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		generalMap.put("classId", classId);
		boolean dataDeleted = false;
		dataDeleted = labHandlerService.deleteInvestigationReportTemplate(
				classId, generalMap);
		if (dataDeleted == true) {

			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/investigation?method=showInvestigationJsp";
		try {
			map = labHandlerService.showInvestigationReportTemplateJsp(box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = INVESTIGATION_TEMPLATE_REPORT_JSP;
		title = "Delete Investigation Template";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("investigationReportTemplateList",
				map.get("investigationReportTemplateList"));
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("deprecation")
	public ModelAndView searchInvestigationReportTemplate(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String investigationCode = null;
		String investigationName = null;
		String searchField = null;

		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		map = labHandlerService.searchInvestigationReportTemplate(searchField);
		jsp = INVESTIGATION_TEMPLATE_REPORT_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("investigationReportTemplateList",
				map.get("investigationReportTemplateList"));
		map.put("investigationList", map.get("investigationList"));

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showMonthlyInvestigationReport(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		// map = labHandlerService.showDiagnosticRegisterDiagnosisWise(map);
		jsp = MONTHLY_SUMMARY_REPORT;
		jsp += ".jsp";
		title = "Monthly Summary Report";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateMonthlySummaryReport(
			HttpServletRequest request, HttpServletResponse response) {

		Date fromDate = null;
		Date toDate = null;
		int chargeCodeId = 0;
		int subCharge = 0;
		int departmentId = 0;
		int hospitalId = 0;
		String query = "";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}

			if (session.getAttribute("deptId") != null) {
				departmentId = Integer.parseInt(""
						+ session.getAttribute("deptId"));
			}

			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = labHandlerService.getConnectionForReport();
		String hospitalName = labHandlerService.getHospitalName(hospitalId);
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put(HOSPITAL_ID, hospitalId);
		parameters.put("hospitalName", hospitalName);

		try {
			HMSUtil.generateReport("monthly_investigation_report", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	public ModelAndView showMonthlyTestResultReport(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		// map = labHandlerService.showDiagnosticRegisterDiagnosisWise(map);
		jsp = MONTHLY_TEST_RESULT_REPORT;
		jsp += ".jsp";
		title = "Monthly Summary Report";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateMonthlyTestResultRepor(
			HttpServletRequest request, HttpServletResponse response) {

		Date fromDate = null;
		Date toDate = null;
		int chargeCodeId = 0;
		int subCharge = 0;
		int departmentId = 0;
		int hospitalId = 0;
		String query = "";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}

			if (session.getAttribute("deptId") != null) {
				departmentId = Integer.parseInt(""
						+ session.getAttribute("deptId"));

			}

			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = labHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			HMSUtil.generateReport("formatForReportingMonthlyTestResults",
					parameters, (Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	public ModelAndView showWeeklyTestReport(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		// map = labHandlerService.showDiagnosticRegisterDiagnosisWise(map);
		jsp = WEEKLY_TEST_REPORT;
		jsp += ".jsp";
		title = "Monthly Summary Report";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateWeeklyTestReport(HttpServletRequest request,
			HttpServletResponse response) {

		Date fromDate = null;
		Date toDate = null;
		int chargeCodeId = 0;
		int subCharge = 0;
		int departmentId = 0;
		int hospitalId = 0;
		String query = "";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}

			if (session.getAttribute("deptId") != null) {
				departmentId = Integer.parseInt(""
						+ session.getAttribute("deptId"));

			}

			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = labHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put(HOSPITAL_ID, hospitalId);
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));

		try {
			HMSUtil.generateReport("WeeklyInvestigationReport", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	// ---------By Dipali -For Investigation Requisition For Ward--
	public ModelAndView showOrderBookingForWardJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String buttonFlag = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int deptId = (Integer) session.getAttribute("deptId");
		int inPatientId = Integer.parseInt(request.getParameter("parent"));
		String deptName = request.getParameter("deptName");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("inPatientId", inPatientId);
		map.put("deptId", deptId);
		map.put(HOSPITAL_ID, hospitalId);

		if (request.getParameter("buttonFlag") != null) {
			buttonFlag = request.getParameter("buttonFlag");
			int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}

		map = labHandlerService.showOrderBookingJsp(map);
		String orderSeqNo = request.getParameter("orderSeqNo");
		orderSeqNo = labHandlerService.getOrderSeqForDisplay("ON");
		if (orderSeqNo != null) {
			map.put("orderSeqNo", orderSeqNo);
		}
		detailsMap = labHandlerService.getMainAndSubCharge();
		map.put("detailsMap", detailsMap);
		jsp = ORDER_BOOKING_WARD;
		jsp += ".jsp";
		title = "OrderBookingForWard";
		map.put("deptName", deptName);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	// Lab Integration Code With Machine Start 08 Feb 2011 by Ramdular Prajapati
	// +++++
	/*
	 * Updated By Ujjwal Kashyap At Silvassa on 27122012
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView showLabTestEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";

		List<DgMasInvestigation> dgMasInvestigation = labHandlerService
				.findInvestigationName();
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		String jsp = "labMachineInvestigationJsp.jsp";
		map.put("deptName", deptName);
		map.put("dgMasInvestigation", dgMasInvestigation);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public void fillInvestigationType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<DgSubMasInvestigation> dgSubInvestigationList = new ArrayList<DgSubMasInvestigation>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		int investigationId = 0;
		try {
			if (request.getParameter("investigationIdId") != null
					&& !(request.getParameter("investigationIdId").equals(""))) {
				investigationId = Integer.parseInt(request
						.getParameter("investigationIdId"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("investigationId", investigationId);
		map = labHandlerService.fillInvestigationName(dataMap);
		if (map.get("investigationList") != null) {
			investigationList = (List) map.get("investigationList");
			// status=(Boolean)map.get("status");
		}
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			for (DgMasInvestigation dgMasInvestigation : investigationList) {
				sb.append("<item>");
				sb.append("<investigationType>"
						+ dgMasInvestigation.getInvestigationType()
						+ "</investigationType>");
				sb.append("<investigationId>" + dgMasInvestigation.getId()
						+ "</investigationId>");
				sb.append("</item>");
			}
			sb.append("</items>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<chargeCodes>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</chargeCodes>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void fillRecordCheck(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		int investigationId = 0;
		int subInvestigationId=0;
		boolean status = false;
		String parameterName = null;
		String machineName=null;
		try {
			if (request.getParameter("investigationId") != null) {
				investigationId = Integer.parseInt(request
						.getParameter("investigationId"));
			}
			if (request.getParameter("subInvestigationId") != null) {
				subInvestigationId = Integer.parseInt(request
						.getParameter("subInvestigationId"));
			}
			if (request.getParameter("machineName") != null) {
				machineName = request.getParameter("machineName");
			}
			if (request.getParameter("parameterName") != null) {
				parameterName = request.getParameter("parameterName");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}//added by govind 31-07-2017 
		/*if(investigationId>0){
		status = labHandlerService.findLabMachineDetails(investigationId);
		}*/
		logger.info("Investigation---subInvestigationId "+subInvestigationId+" investigationId "+investigationId);
		logger.info("machineName "+machineName+" parameterName "+parameterName);
		
		if(investigationId>0 && subInvestigationId>0 && machineName!=null && parameterName!=null){
			dataMap.put("subInvestigationId", subInvestigationId);
			dataMap.put("investigationId", investigationId);
			dataMap.put("machineName", machineName);
			dataMap.put("parameterName", parameterName);
			map = labHandlerService.fillInvestigationName(dataMap);
			if(map.get("status")!=null){
				status=(boolean)map.get("status");
			}
		}//added by govind 31-07-2017 end
		// if (map.get("investigationList") != null) {
		// investigationList = (List) map.get("investigationList");
		// status=(Boolean)map.get("status");
		// }
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			sb.append("<item>");
			sb.append("<status>" + status + "</status>");
			sb.append("</item>");
			sb.append("</items>");

		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<chargeCodes>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</chargeCodes>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void fillSubInvestigationType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<DgSubMasInvestigation> dgSubInvestigationList = new ArrayList<DgSubMasInvestigation>();
		int subInvestigationId = 0;
		String parameterName = null;
		boolean status = false;
		int investigationId = 0;
		String machineName=null;
		try {
			if (request.getParameter("subInvestigationName") != null) {
				subInvestigationId = Integer.parseInt(request
						.getParameter("subInvestigationName"));
			}
			if (request.getParameter("investigationId") != null) {
				investigationId = Integer.parseInt(request
						.getParameter("investigationId"));
			}
			if (request.getParameter("machineName") != null) {
				machineName = request.getParameter("machineName");
			}
			if (request.getParameter("parameterName") != null) {
				parameterName = request.getParameter("parameterName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("subInvestigation---subInvestigationId "+subInvestigationId+" investigationId "+investigationId);
        logger.info("machineName "+machineName+" parameterName "+parameterName);

		dataMap.put("subInvestigationId", subInvestigationId);
		dataMap.put("investigationId", investigationId);
		dataMap.put("machineName", machineName);
		dataMap.put("parameterName", parameterName);

		status = labHandlerService
				.findSubInvestigationDetails(dataMap);
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			sb.append("<item>");
			sb.append("<status>" + status + "</status>");
			sb.append("</item>");
			sb.append("</items>");

		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<chargeCodes>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</chargeCodes>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ModelAndView getSubinvestigationName(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgSubMasInvestigation> subInvestigationlist = new ArrayList<DgSubMasInvestigation>();
		int investigationId = 0;
		String investigationType = "";
		int rowVal = Integer.parseInt(request.getParameter("rowVal"));
		if (request.getParameter("investigationId") != null) {

			investigationId = Integer.parseInt(request
					.getParameter("investigationId"));
		}
		if (request.getParameter("investigationType") != null) {
			investigationType = request.getParameter("investigationType");
		}
		subInvestigationlist = labHandlerService.getSubinvestigationName(
				investigationId, investigationType);
		String jsp = "lab_subinvestigationName";
		map.put("rowVal", rowVal);
		map.put("subInvestigationlist", subInvestigationlist);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView addTestParameter(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		String machineParamId="";
		String message = "";
		String flag = "";
		boolean dataAdded = false;
		if(request.getParameter("flag")!=null) {
			flag=(String)request.getParameter("flag");
			box.put("flag", flag);
		}
		dataAdded = labHandlerService.addTestParameter(box);
		if (dataAdded == true) {
			message = "Test Parameter Added Successfully !!";
		} else {
			message = "Test Parameter Can't Be Added !!";
		}
		// url = "/hms/hms/lab?method=showLabTestEntryJsp";
		jsp = "msgForLabMachineJsp.jsp";
		title = "added Test Parameter";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView showLabMapDisgNoJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		String jsp = "analyzerMapToDiagNo.jsp";
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView findSampleNoDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		String machineName = "";
		String c_date = "";
		if (request.getParameter(MACHINE_NAME) != null) {

			machineName = request.getParameter(MACHINE_NAME);

		}
		if (request.getParameter(FROM_DATE) != null) {
			c_date = request.getParameter(FROM_DATE);

		}

		List<PatientMainLabInfo> patientInfo = labHandlerService
				.findPatientInfoDetails(machineName, c_date);
		List<DgSampleCollectionDetails> dgSampleCollection = labHandlerService
				.findDgSampleCollectionDetails();
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		String jsp = "sampleNoMapToDiagNo.jsp";
		map.put("deptName", deptName);
		map.put("patientInfo", patientInfo);
		map.put("sample_date", c_date);
		map.put("machineName", machineName);
		map.put("dgSampleCollection", dgSampleCollection);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addDiagnosisNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		boolean dataAdded = false;
		dataAdded = labHandlerService.addParameterDiagNo(box);
		if (dataAdded == true) {
			message = "Record Added Successfully !!";
		} else {
			message = "Record Can't Be Added !!";
		}
		jsp = "analyzerMapToDiagNo.jsp";
		title = "added Records";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public void checkDiagnosisNo(HttpServletRequest request,
			HttpServletResponse response) {
		boolean status = false;
		String diagnosisNo = null;
		int rowVal = 0;
		try {
			if (request.getParameter("diagnosisNo") != null) {
				diagnosisNo = request.getParameter("diagnosisNo");
			}
			if (request.getParameter("rowVal") != null) {
				rowVal = Integer.parseInt(request.getParameter("rowVal"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		status = labHandlerService.checkDiagnosisNoDetails(diagnosisNo);
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			sb.append("<item>");
			sb.append("<status>" + status + "</status>");
			sb.append("</item>");
			sb.append("</items>");

		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<chargeCodes>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</chargeCodes>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void fillPatientLabDetail(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<DgSampleCollectionDetails> patientList = new ArrayList<DgSampleCollectionDetails>();
		String diagnosisNo = "";

		try {
			if (request.getParameter("diagnosisNo") != null) {
				diagnosisNo = request.getParameter("diagnosisNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("diagnosisNo", diagnosisNo);
		map = labHandlerService.fillPatientLabDetail(dataMap);
		if (map.get("patientList") != null) {
			patientList = (List) map.get("patientList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			for (DgSampleCollectionDetails sampleCollectionDetails : patientList) {
				sb.append("<item>");
				// sb.append("<hinId>" +
				// sampleCollectionDetails.getSampleCollectionHeader().getHin().getId()
				// + "</hinId>");
				sb.append("<serviceNo>"
						+ sampleCollectionDetails.getSampleCollectionHeader()
								.getHin().getHinNo() + "</serviceNo>");
				String firstName = "";
				String lastName = "";
				String patientName = "";
				if(sampleCollectionDetails
						.getSampleCollectionHeader().getHin()!=null){
					if(sampleCollectionDetails
							.getSampleCollectionHeader().getHin().getPFirstName()!=null){
				firstName = sampleCollectionDetails.getSampleCollectionHeader()
						.getHin().getPFirstName();
					}
				}
				if(sampleCollectionDetails
						.getSampleCollectionHeader().getHin()!=null){
					if(sampleCollectionDetails
							.getSampleCollectionHeader().getHin().getPLastName()!=null){
				lastName = " "+sampleCollectionDetails.getSampleCollectionHeader()
						.getHin().getPLastName();
					}
				}
				
				patientName = firstName + lastName;
				/*sb.append("<rank>"
						+ sampleCollectionDetails
								.getSampleCollectionHeader()
								.getHin()
								.getPFirstName()
								.concat(" ")
								.concat(sampleCollectionDetails
										.getSampleCollectionHeader().getHin()
										.getPLastName()) + "</rank>");*/
				sb.append("<rank>"
						+ patientName + "</rank>");
				
				sb.append("<name>"
						+ sampleCollectionDetails.getSampleCollectionHeader()
								.getDepartment().getDepartmentName()
						+ "</name>");
				sb.append("</item>");
				break;
			}
			sb.append("</items>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<chargeCodes>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</chargeCodes>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Lab Machice Code Integration +++++++++++++++++++++++

	public ModelAndView showLabTestResultJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";

		List<PatientMainLabInfo> patientmainInfo = labHandlerService
				.findSampleNo();

		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		String jsp = "labMachineResultJsp.jsp";
		map.put("deptName", deptName);
		map.put("patientmainInfo", patientmainInfo);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView LabResultValidateDetails1(HttpServletRequest request,
			HttpServletResponse response) {
		boolean status = false;
		String SampleNo = null;
		String fromdate = null;
		String machineName = null;
		Map<String, Object> ShowvalidateDetails = new HashMap<String, Object>();

		try {
			if (request.getParameter("SampleNo") != null) {
				SampleNo = request.getParameter("SampleNo");
			}
			if (request.getParameter(FROM_DATE) != null) {
				fromdate = request.getParameter(FROM_DATE);
			}
			if (request.getParameter(MACHINE_NAME) != null) {
				machineName = request.getParameter(MACHINE_NAME);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		ShowvalidateDetails = labHandlerService.LabResultValidateDetails(
				SampleNo, fromdate, machineName);
		String jsp = "lab_ResultResponse.jsp";
		map.put("fromdate", fromdate);
		map.put("machineName", machineName);
		map.put("ShowvalidateDetails", ShowvalidateDetails);

		map.put("contentJsp", jsp);
		// return new ModelAndView(jsp, "map", map);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView checkSampleNo(HttpServletRequest request,
			HttpServletResponse response) {

		String machineName = null;
		String fromDate = null;
		List<PatientMainLabInfo> sampleList = new ArrayList<PatientMainLabInfo>();
		try {
			if (request.getParameter("fromDate") != null) {
				fromDate = request.getParameter("fromDate");
			}
			if (request.getParameter("machineName") != null) {
				machineName = request.getParameter("machineName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		sampleList = labHandlerService.checkSampleNo(fromDate, machineName);

		map.put("sampleList", sampleList);
		String jsp = "sampleResponseJsp";
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView addAnalyserResult(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String sampleNo = null;
		String diag_no = null;
		Box box = HMSUtil.getBox(request);

		boolean dataAdded = false;
		dataAdded = labHandlerService.addAnalyserResult(box);
		if (dataAdded == true) {
			message = "Record Added Successfully !!";
		} else {
			message = "Record Can't Be Added !!";
		}
		String jsp = "labMachineResultJsp.jsp";
		title = "added Records";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView invalidateAnalyserResult(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String sampleNo = null;
		String diag_no = null;
		if (request.getParameter(DIAGNOSIS_NO) != null) {
			diag_no = request.getParameter(DIAGNOSIS_NO);
		}
		boolean dataAdded = false;
		dataAdded = labHandlerService.invalidateAnalyserResult(diag_no);
		if (dataAdded == true) {
			message = "Record Invalidated Successfully !!";
		} else {
			message = "Record Can't Be Invalidated !!";
		}
		String jsp = "labMachineResultJsp.jsp";
		title = "added Records";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// Lab Integration Code With Machine End 08 Feb 2011 by Ramdular Prajapati
	// -----

	public ModelAndView generateReportForLabMachineBarcode(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Box box=HMSUtil.getBox(request);
		int inv_id = 0;
		int order_id = 0;
		String hinNo="";
		String subChargeCodeName="";
		String subchargeCodeCode="";
		int hinId=0;
		String invDetails="";
		String collectedBy="";
		String collectionDate="";
		String collectionTime="";
		String sampleCode="";
		String sectionCode="";
		int  sampleNumber=0;
		String containerCode="";
		String sequenceNo=""; 
		String testUrgentStatus="";
		String orderNo="";
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");
		String currentYear="";
		int visitId=0;
		int inpatientId=0;
		String departName="";
		int orderId=0;
		int dgSampleDetailId=0;
		
		String sequenceIdNo="";
		 String modalityName="";
		String barcodeDisplayText="";
		
		if(currentDate!=null ){
			currentYear=currentDate.substring(6,10);
		}
		HttpSession session = request.getSession();
		int hospitalId = 0;
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		String DiagNo="";
		String shortName="",sampleCollectionAndContainer="";
		try {

			if (request.getParameter("subChargeCodeName") != null
					&& (!request.getParameter("subChargeCodeName").equals(""))) {
				subChargeCodeName = (request.getParameter("subChargeCodeName"));// +
																			// "' ";
			}
			
			if (request.getParameter("subchargeCodeCode") != null
					&& (!request.getParameter("subchargeCodeCode").equals(""))) {
				subchargeCodeCode = (request.getParameter("subchargeCodeCode"));// +
																			// "' ";
			} 
			if(request.getParameter("hinId")!=null){
				hinId=Integer.parseInt(request.getParameter("hinId"));
			}
			if(request.getParameter("collectedBy")!=null){
				collectedBy=request.getParameter("collectedBy");
				
			}
			if(request.getParameter("collectionDate")!=null){
				collectionDate=request.getParameter("collectionDate");
				
			}
			if(request.getParameter("collectionTime")!=null){
				collectionTime=request.getParameter("collectionTime");
				
			}
			if(request.getParameter("sampleCode")!=null){
				sampleCode=request.getParameter("sampleCode"); 
			} 
			
			if(request.getParameter("sectionCode")!=null){
				sectionCode=request.getParameter("sectionCode"); 
			}
			if(request.getParameter("sampleNumber")!=null){
				sampleNumber=Integer.parseInt(request.getParameter("sampleNumber")); 
			}
			  sequenceIdNo=HMSUtil.getFiveDigitsId(sampleNumber);
			 
			if(request.getParameter("modality")!=null){
				modalityName=request.getParameter("modality"); 
			}
			
			 if(request.getParameter("orderNo")!=null && !request.getParameter("orderNo").equals("")){
				 orderNo=request.getParameter("orderNo");
				 String ord[]=orderNo.split("/");
				 orderNo=ord[0];
			 }
			 
			 if (request.getParameter("orderId") != null
						&& (!request.getParameter("orderId").equals(""))) {
					orderId =Integer.parseInt(request.getParameter("orderId"));// +
																				// "' ";
				} 
			
			 logger.info("orderNo "+orderNo);
			//barcodeDisplayText=hospitalId+"/"+sequenceIdNo+"/"+HMSUtil.getYear(new Date())+"/"+modalityName;
			 
			 barcodeDisplayText=hospitalId+"/"+orderNo+"/"+HMSUtil.getYear(new Date())+"/"+modalityName;//changed by govind 05-06-2017
			 
			if(request.getParameter("containerCode")!=null){
				containerCode=request.getParameter("containerCode"); 
			}
			if(request.getParameter("sequenceNo")!=null){
				sequenceNo=request.getParameter("sequenceNo"); 
			}
			
			 
			 if(request.getParameter("inpatient_id")!=null && !request.getParameter("inpatient_id").equals("null") && !request.getParameter("inpatient_id").equals("")){
				 inpatientId=Integer.parseInt(request.getParameter("inpatient_id"));
			 }
			 if(request.getParameter("visit_id")!=null && !request.getParameter("visit_id").equals("null") && !request.getParameter("inpatient_id").equals("") ){
				 visitId=Integer.parseInt(request.getParameter("visit_id"));
			 }
			 if(request.getParameter("routineUrgentStatus")!=null && !request.getParameter("routineUrgentStatus").equals("")){
				 testUrgentStatus=request.getParameter("routineUrgentStatus");
			 }
			 
		
				 if(request.getParameter("dgSampleDetailId")!=null && !request.getParameter("dgSampleDetailId").equals("")){
					 dgSampleDetailId=Integer.parseInt(request.getParameter("dgSampleDetailId"));
				 }
			 
			if (request.getParameter("orderId") != null
					&& (!request.getParameter("orderId").equals(""))) {
				order_id = Integer.parseInt(request.getParameter("orderId"));// +
																				// "' ";
			}
			String investIdList=null;
			if(request.getParameter("investIdList")!=null){
				investIdList=(String)request.getParameter("investIdList");
				//parameters.put("investIdList"," and scd.investigation_id in ("+investIdList+")");
			}
			
			logger.info("currentYear  ----->>"+currentYear+" investIdList  ----->>"+investIdList);
			map.put("order_id",order_id);
			map.put("inpatientId",inpatientId);
			map.put("modalityName",modalityName);
			map.put("investIdList",investIdList);
			
			//map.put()
			dataMap=labHandlerService.getHinNo(map);
			if(dataMap.get("hinNo")!=null){
				hinNo=(String)dataMap.get("hinNo");
			}
			Inpatient inpatient=null; 
			if(dataMap.get("inpatient")!=null){
				inpatient=(Inpatient)dataMap.get("inpatient");
				departName=inpatient.getDepartment().getDepartmentName();
			}
			if(dataMap.get("shortName")!=null){
				shortName=(String)dataMap.get("shortName");
			}
			if(dataMap.get("sampleCollectionAndContainer")!=null){
				sampleCollectionAndContainer=(String)dataMap.get("sampleCollectionAndContainer");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String diag_no="";
		if(request.getParameter("diag_no")!=null){
			diag_no=request.getParameter("diag_no");
		}
		
		if(request.getParameter("DiagNo")!=null){
			DiagNo=request.getParameter("DiagNo");
		}
			
		detailsMap = labHandlerService.getConnectionForReport();
		String patientType="";
		String query="";
		if(visitId!=0){
			patientType="OP";
			query=" inner join visit v on v.hin_id=pt.hin_id"
					+ "  where v.visit_id="+visitId;
		}else if(inpatientId!=0){
			patientType="IP";
			query=" inner join inpatient ip on ip.hin_id=pt.hin_id"
					+ " left outer join mas_department md on md.department_id=ip.department_id"
					+ "  where ip.inpatient_id="+inpatientId;
		}
		if("u".equalsIgnoreCase(testUrgentStatus)){
			testUrgentStatus="Urgent";
		}else{
			testUrgentStatus="Urgent";
		}
		
		
		
		if(hinNo!=null){
			
			if(hinNo.equalsIgnoreCase(RequestConstants.UHID_FOR_QUALITY_TESTING)){
				parameters.put("order_id", order_id);
				parameters.put("inv_id", inv_id);
				parameters.put("hinId",hinId);
				parameters.put("subChargeCodeName",subChargeCodeName);
				parameters.put("subchargeCodeCode",subchargeCodeCode);
				parameters.put("diag_no",diag_no);
				parameters.put("currentYear",currentYear);
				parameters.put("collectedBy",collectedBy);
				parameters.put("collectionDate",HMSUtil.convertStringTypeDateToDateType(collectionDate));
				parameters.put("collectionTime",collectionTime);
				parameters.put("sampleCode",String.valueOf(sampleCode));
				parameters.put("sectionCode",sectionCode);
				parameters.put("sampleNumber",sampleNumber);
				parameters.put("containerCode",containerCode);
				parameters.put("sequenceNo",sequenceNo);
				parameters.put("patientType",patientType);
				parameters.put("testUrgentStatus",testUrgentStatus);
				parameters.put("orderNo",orderNo);
				parameters.put("departName",departName);
			
				parameters.put("query",query);
				
				try {

					HMSUtil.generateReport("print_without_barcode", parameters,
							(Connection) detailsMap.get("con"), response,
							getServletContext());
				} catch (IllegalStateException e) {
					e.printStackTrace();
				}
			}else{
				parameters.put("year", HMSUtil.getYear(new Date()));
				parameters.put("order_id", orderId); 
				parameters.put("currentYear",currentYear); 
				parameters.put("orderNo",dgSampleDetailId); 
				parameters.put("departName",departName);
				parameters.put("barcodeDisplayText",barcodeDisplayText);
				parameters.put("DiagNo",DiagNo);
				parameters.put("shortName",shortName);
				parameters.put("sampleCollectionAndContainer",sampleCollectionAndContainer);
				try {

				/*	HMSUtil.generateReport("print_barcode2", parameters,
							(Connection) detailsMap.get("con"), response,
							getServletContext());*/
					
					//commented by amit das on 29-06-2016
					//added by amit das on 29-06-2016
					map.put("Report_Path", request.getContextPath()+"/Reports/"+"print_barcode2"+".pdf");
					HMSUtil.generateReportForDirectPrint("print_barcode2", parameters, (Connection)detailsMap.get("con"), response, getServletContext(), getServletContext().getRealPath("/Reports/"));
					
				} catch (IllegalStateException e) {
					e.printStackTrace();
				}
				}
		}
		return new ModelAndView("printReports", "map", map);
	}

	/*
	 * COde By Ujjwal For Lab Machine XL-300
	 */
	public ModelAndView showMergeDataXL300(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "xl300DataMergeJsp";
		jsp += ".jsp";
		title = "OrderBooking";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView mergeDataXl300(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String date = "";
		if (request.getParameter(FROM_DATE) != null) {
			date = request.getParameter(FROM_DATE);
		}
		String date1 = "";
		date1 = date.substring(6, 10).concat("-").concat(date.substring(3, 5))
				.concat("-").concat(date.substring(0, 2));

		boolean dataMerged = false;
		dataMerged = labHandlerService.mergeDataXl300(date, date1);
		String jsp = "xl300DataMergeJsp";
		jsp += ".jsp";
		title = "OrderBooking";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView showinvestigationForLabIntegeration(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String machineName = "";
		if (request.getParameter(MACHINE_NAME) != null) {
			machineName = request.getParameter(MACHINE_NAME);
		}
		map = labHandlerService
				.showinvestigationForLabIntegeration(machineName);
		map.put("machineName", machineName);
		String jsp = "machineInvestionInfo";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView selectViewAccOrderStatusnew(HttpServletRequest request,
			HttpServletResponse response) {

		List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> resultTypeDetailMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String appendedHtml = "";

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}

		HttpSession session = request.getSession();
		String deptName = "";
		String jsp = "";
		String resultType = "";
		String orderStatus = "";
		String result = "";
		Integer deptId = 0;
		String confidential = "";
		String rejectedStatus = "";
		String chargeCode = "";
		int hinId = 0;

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		int dgMasInvestigationId = 0;
		int dgOrderdtId = 0;
		int dgResultEntryDetailId = 0;
		int dgResultEntryDetailLabId = 0;
		int dgSampleCollectionDetailLabId = 0;
		int dgResultEntryHeaderLabId = 0;
		int dgResultEntryHeaderSenLabId = 0;
		String rejReason = "";

		DgResultEntryDetail dgResultEntryDetail = null;
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();

		if (request.getParameter("dgMasInvestigationId") != null) {
			dgMasInvestigationId = Integer.parseInt(request
					.getParameter("dgMasInvestigationId"));
			mapForDs.put("dgMasInvestigationId", dgMasInvestigationId);
		}
		if (request.getParameter("resultType") != null) {
			resultType = request.getParameter("resultType");
			mapForDs.put("resultType", resultType);
		}
		if (request.getParameter("dgOrderdtId") != null) {
			dgOrderdtId = Integer.parseInt(request.getParameter("dgOrderdtId"));
			mapForDs.put("dgOrderdtId", dgOrderdtId);
		}
		if (request.getParameter("dgResultEntryDetailLabId") != null) {
			dgResultEntryDetailLabId = Integer.parseInt(request
					.getParameter("dgResultEntryDetailLabId"));
			mapForDs.put("dgResultEntryDetailId", dgResultEntryDetailLabId);
		}
		if (request.getParameter("dgResultEntryHeaderLabId") != null) {
			dgResultEntryHeaderLabId = Integer.parseInt(request
					.getParameter("dgResultEntryHeaderLabId"));
			mapForDs.put("dgResultEntryHeaderLabId", dgResultEntryHeaderLabId);
		}
		if (request.getParameter("dgSampleCollectionDetailLabId") != null) {
			dgSampleCollectionDetailLabId = Integer.parseInt(request
					.getParameter("dgSampleCollectionDetailLabId"));
			mapForDs.put("dgSampleCollectionDetailLabId",
					dgSampleCollectionDetailLabId);
		}
		if (request.getParameter("dgResultEntryHeaderSenLabId") != null) {
			dgResultEntryHeaderSenLabId = Integer.parseInt(request
					.getParameter("dgResultEntryHeaderSenLabId"));
			mapForDs.put("dgResultEntryHeaderSenLabId",
					dgResultEntryHeaderSenLabId);
		}
		if (request.getParameter("orderStatus") != null) {
			orderStatus = request.getParameter("orderStatus");
			mapForDs.put("orderStatus", orderStatus);
		}
		if (request.getParameter("confidential") != null) {
			confidential = request.getParameter("confidential");
			mapForDs.put("confidential", confidential);
		}
		if (request.getParameter("rejectedStatus") != null) {
			rejectedStatus = request.getParameter("rejectedStatus");
			mapForDs.put("rejectedStatus", rejectedStatus);
		}
		if (request.getParameter("rejReason") != null) {
			rejReason = request.getParameter("rejReason");
			mapForDs.put("rejReason", rejReason);
		}
		if (request.getParameter("chargeCode") != null) {
			chargeCode = request.getParameter("chargeCode");
			mapForDs.put("chargeCode", chargeCode);
		}

		if (request.getParameter("hinId") != null) {
			hinId = Integer.parseInt(request.getParameter("hinId"));

			mapForDs.put("hinId", hinId);
		}

		if (dgResultEntryHeaderLabId != 0) {
			//
			map = labHandlerService.getResultEntryDetailsForLabOrderStatusNew(
					dgResultEntryHeaderLabId, deptId);
			if (confidential.equalsIgnoreCase("y")) {
				// || orderStatus.equalsIgnoreCase("P")){
				jsp = "msgForOrderStatus";
			} else {
				if (resultType.equalsIgnoreCase("m")) {
					jsp = VIEW_MULTIPLE_PARAMETER_STATUS;
				}
			}
		} else if (dgResultEntryHeaderSenLabId != 0) {
		}
		if ((dgResultEntryDetailLabId != 0 || dgResultEntryHeaderSenLabId != 0 || dgResultEntryHeaderLabId != 0)) {
			// && !confidential.equals("y")){
			if (orderStatus.equalsIgnoreCase("P")) {
				String[] orderStatusMsg = {
						"This Test is still Pending For Result Validation.",
						"Result is entered which is shown below" };
				// String[] orderStatusMsg = {"This Test is still Pending For
				// Result Validation."};
				map.put("orderStatusMsg", orderStatusMsg);
			}
			if (!confidential.equals("y")) {
				if (orderStatus.equalsIgnoreCase("A")) {
					String[] orderStatusMsg = {
							"Result is validated for This Test.",
							"Result entered is shown as below" };
					map.put("orderStatusMsg", orderStatusMsg);
				}
			} else if (confidential.equals("y")) {
				String[] orderStatusMsg = { "This Test result is confidential." };
				map.put("orderStatusMsg", orderStatusMsg);
			}
		}/*
		 * else if((dgResultEntryDetailLabId != 0 || dgResultEntryHeaderSenLabId
		 * != 0 || dgResultEntryHeaderLabId != 0) && confidential.equals("y")){
		 * String[] orderStatusMsg = {"This Test result is
		 * confidential."}; map.put("orderStatusMsg", orderStatusMsg); }
		 */
		map.put("orderNoList", orderNoList);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);

		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView bulkorderbooking(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}

		String jsp = "bulkorderbooking";
		jsp += ".jsp";
		map.put("hospitalList", labHandlerService.getAllHospital());
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView submitOrderBookingFromBulkOrder(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		Box box = HMSUtil.getBox(request); 
		String userName = (String) session.getAttribute("userName");
		Integer userId = (Integer) session.getAttribute("userId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int departmentId = (Integer) session.getAttribute("deptId");
		Users user = (Users) session.getAttribute("users");
		box.put(RequestConstants.INSTITUTION, hospitalId);
		utilMap.put(RequestConstants.USER_NAME, userName);
		utilMap.put(RequestConstants.USER_ID, userId);
		utilMap.put(HOSPITAL_ID, hospitalId);
		utilMap.put(RequestConstants.DEPT_ID, departmentId);
		utilMap.put(RequestConstants.USERS, user);
		map = labHandlerService.saveBulkOrderBooking(box, utilMap);

		if (Boolean.parseBoolean(map.get("saved").toString())) {
			message = "Order Booking has been done Successfully !!Do you want to print ? ";
		} else {
			message = "Try Again!";
		}

		map.put("message", message);

		String jsp = DG_MSG_FOR_LAB + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView getsampleforhistopatologyteststate(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = new Date();
		Date toDate = new Date();
		int chargeCodeId = 0;
		int departmentId = 0;
		int inpatientId = 0;
		int subGroupId = 0;
		int sampleId = 0;
		int hinId = 0;
		int deptId = 0;
		String patientFName = "";
		String deptName = "";
		String deptType = "";
		String hinNo = "";
		String adNo = "";
		String flag = "";
		String pType = "";
		String reason = "";
		Integer hospitalId = 0;
		String wardName = "";
		String mobileNo = "";
		Integer barCode = 0;
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
		int uid = 0;
		String orderStatus = "";
		String appId = "";
		try {
			if (session.getAttribute("deptName") != null) {
				deptName = (String) session.getAttribute("deptName");
			}
			if (session.getAttribute("deptType") != null) {
				deptType = (String) session.getAttribute("deptType");
			}
			if (session.getAttribute("users") != null) {
				Users user = (Users) session.getAttribute("users");
				uid = user.getId();
			}
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

			}
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
			}
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);

			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				pType = request.getParameter(PATIENT_TYPE);

			}
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));

			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subGroupId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
			}
			if (request.getParameter(SAMPLE_ID) != null
					&& !(request.getParameter(SAMPLE_ID).equals("0"))) {
				sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);

			}
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));

			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));

			}
			if (request.getParameter(REASON) != null
					&& !(request.getParameter(REASON).equals(""))) {
				reason = request.getParameter(REASON);

			}
			if (request.getParameter(RequestConstants.WARD_NAME) != null
					&& !(request.getParameter(RequestConstants.WARD_NAME)
							.equals(""))) {
				wardName = request.getParameter(RequestConstants.WARD_NAME);

			}
			if (request.getParameter(RequestConstants.MOBILE_NO) != null
					&& !(request.getParameter(RequestConstants.MOBILE_NO)
							.equals(""))) {
				mobileNo = request.getParameter(RequestConstants.MOBILE_NO);

			}
			if (request.getParameter(RequestConstants.BARCODE) != null
					&& !(request.getParameter(RequestConstants.BARCODE)
							.equals(""))) {
				barCode = Integer.parseInt(request
						.getParameter(RequestConstants.BARCODE));

			}
			if (request.getParameter("appId") != null
					&& "A1653".equalsIgnoreCase(request.getParameter("appId"))) {
				appId = request.getParameter("appId");
				orderStatus = "S";
			}
			if (request.getParameter("appId") != null
					&& "A1657".equalsIgnoreCase(request.getParameter("appId"))) {
				appId = request.getParameter("appId");
				orderStatus = "G";
			}
			if (request.getParameter("appId") != null
					&& "A1662".equalsIgnoreCase(request.getParameter("appId"))) {
				appId = request.getParameter("appId");
				orderStatus = "B";
			}
			if (request.getParameter("appId") != null
					&& "A1663".equalsIgnoreCase(request.getParameter("appId"))) {
				appId = request.getParameter("appId");
				orderStatus = "L";
			}
			session.setAttribute(RequestConstants.APP_ID_HISTO, appId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		mapForDs.put(HOSPITAL_ID, hospitalId);
		mapForDs.put("deptId", deptId);
		mapForDs.put("orderStatus", orderStatus);
		mapForDs.put(RequestConstants.BARCODE, barCode);
		mapForDs.put(RequestConstants.MOBILE_NO, mobileNo);
		mapForDs.put(RequestConstants.WARD_NAME, wardName);
		mapForDs.put("reason", reason);
		mapForDs.put("hinId", hinId);
		mapForDs.put("departmentId", departmentId);
		mapForDs.put("adNo", adNo);
		mapForDs.put("patientFName", patientFName);
		mapForDs.put("sampleId", sampleId);
		mapForDs.put("subGroupId", subGroupId);
		mapForDs.put("chargeCodeId", chargeCodeId);
		mapForDs.put("pType", pType);
		mapForDs.put("toDate", toDate);
		mapForDs.put("fromDate", fromDate);
		mapForDs.put("hinNo", hinNo);
		mapForDs.put("inpatientId", inpatientId);
		detailsMap = labHandlerService.getSampleValidationSearch(mapForDs);
		patientMap = labHandlerService
				.getSampleForHistopatologyTestState(mapForDs);
		jsp = RequestConstants.PENDING_FOR_SAMPLE_TEST_IN_HISTOPATOLOGY
				+ ".jsp";
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("deptType", deptType);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPatientForHistoPendingList(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = new Date();
		Date toDate = new Date();
		int chargeCodeId = 0;
		int departmentId = 0;
		int inpatientId = 0;
		int subGroupId = 0;
		int sampleId = 0;
		int hinId = 0;
		int deptId = 0;
		String patientFName = "";
		String deptName = "";
		String deptType = "";
		String hinNo = "";
		String adNo = "";
		String flag = "";
		String pType = "";
		String reason = "";
		Integer hospitalId = 0;
		String wardName = "";
		String mobileNo = "";
		Integer barCode = 0;
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
		int uid = 0;
		String appId = "";
		try {
			if (session.getAttribute("deptName") != null) {
				deptName = (String) session.getAttribute("deptName");
			}
			if (session.getAttribute("deptType") != null) {
				deptType = (String) session.getAttribute("deptType");
			}
			if (session.getAttribute("users") != null) {
				Users user = (Users) session.getAttribute("users");
				uid = user.getId();
			}
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				mapForDs.put(HOSPITAL_ID, hospitalId);

			}
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
			}
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				mapForDs.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				mapForDs.put("toDate", toDate);
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				pType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("pType", pType);
			}
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subGroupId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subGroupId", subGroupId);
			}
			if (request.getParameter(SAMPLE_ID) != null
					&& !(request.getParameter(SAMPLE_ID).equals("0"))) {
				sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
				mapForDs.put("sampleId", sampleId);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("departmentId", departmentId);
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(REASON) != null
					&& !(request.getParameter(REASON).equals(""))) {
				reason = request.getParameter(REASON);
				mapForDs.put("reason", reason);
			}
			if (request.getParameter(RequestConstants.WARD_NAME) != null
					&& !(request.getParameter(RequestConstants.WARD_NAME)
							.equals(""))) {
				wardName = request.getParameter(RequestConstants.WARD_NAME);
				mapForDs.put(RequestConstants.WARD_NAME, wardName);
			}
			if (request.getParameter(RequestConstants.MOBILE_NO) != null
					&& !(request.getParameter(RequestConstants.MOBILE_NO)
							.equals(""))) {
				mobileNo = request.getParameter(RequestConstants.MOBILE_NO);
				mapForDs.put(RequestConstants.MOBILE_NO, mobileNo);
			}
			if (request.getParameter(RequestConstants.BARCODE) != null
					&& !(request.getParameter(RequestConstants.BARCODE)
							.equals(""))) {
				barCode = Integer.parseInt(request
						.getParameter(RequestConstants.BARCODE));
				mapForDs.put(RequestConstants.BARCODE, barCode);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = labHandlerService
				.getPatientDetailsGrossingInHisto(mapForDs);
		String jsp = "";
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDeatilList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDeatilList");
		}
		int orderId = 0;
		if (request.getParameter("orderId") != null
				&& !(request.getParameter("orderId").equals("0"))) {
			orderId = new Integer(request.getParameter("orderId"));
			mapForDs.put("orderId", orderId);

		}
		if (orderId != 0) {
			map = labHandlerService.getSampleDetailsForHisto(orderId, uid,
					deptId,hospitalId);
		}
		if (map != null && map.get("samplehdList") != null) {
			if ("A1663".equalsIgnoreCase(session.getAttribute(
					RequestConstants.APP_ID_HISTO).toString())) {
				jsp = RequestConstants.SAMPLE_PROCESS_FOR_SLIDE_STAINING
						+ ".jsp";
			} else {
				jsp = RequestConstants.SAMPLE_PROCESS_OF_HISTO + ".jsp";
			}

		} else {
			detailsMap = labHandlerService.getDetailsForSearch(map);
			jsp = RequestConstants.PENDING_FOR_SAMPLE_TEST_IN_HISTOPATOLOGY
					+ ".jsp";
		}
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("deptType", deptType);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("orderId", orderId);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView submitHistopatologyDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<Integer, List<DgHistoSampleCollectionDetails>> newHistoMapForNextStep = new HashMap<Integer, List<DgHistoSampleCollectionDetails>>();
		Map<Integer, DgHistoSampleCollectionDetails> oldHistoMapOfPriviousStep = new HashMap<Integer, DgHistoSampleCollectionDetails>();
		String appId = request.getParameter("appId");
		Integer orderId = Integer.parseInt(request
				.getParameter("orderIdOfHeader"));
		boolean saveHeaderOfHisto = Boolean.parseBoolean(request
				.getParameter("saveHeader"));
		String orderStatus = "";
		// specimen goes for grossing
		if ("A1653".equalsIgnoreCase(appId)) {
			orderStatus = "G";
		}
		// grossing goes for blocking
		if ("A1657".equalsIgnoreCase(appId)) {
			orderStatus = "B";
		}
		// grossing goes for sliding
		if ("A1662".equalsIgnoreCase(appId)) {
			orderStatus = "L";
		}
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("users");
		Integer deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			 
		}
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		Box box = HMSUtil.getBox(request);
		Set<String> histoIdOfPriviousStep = new HashSet<String>(
				box.getArrayList(RequestConstants.DG_SAMPLE_DETAIL_ID));
		int totalRow = 0;
		if (request.getParameter("totalRow") != null
				&& !"".equalsIgnoreCase(request.getParameter("totalRow").trim())) {
			totalRow = Integer.parseInt(request.getParameter("totalRow"));
		}

		for (String preHistoId : histoIdOfPriviousStep) {
			Integer histoId = Integer.parseInt(preHistoId);
			DgHistoSampleCollectionDetails priviousData = labHandlerService
					.getSampleDetailsOfHistoById(histoId);
			List<DgHistoSampleCollectionDetails> histoListForMap = new ArrayList<DgHistoSampleCollectionDetails>();
			for (int i = 1; i <= totalRow; i++) {
				if (histoId == Integer.parseInt(request
						.getParameter("priviousHistoId" + i))
						&& request.getParameter("selectedChrage" + i) == null) {
					DgHistoSampleCollectionDetails newObject = new DgHistoSampleCollectionDetails();
					newObject.setIdentificationNo(request
							.getParameter("identificationNo" + i));
					newObject.setRemarks(request
							.getParameter(RequestConstants.OTHERS_REMARKS + i));
					newObject.setOrderStatus(orderStatus);
					newObject.setLabStatus("N");
					newObject.setSampleCollectionHeader(priviousData
							.getSampleCollectionHeader());
					newObject.setChargeCode(priviousData.getChargeCode());
					newObject.setSample(priviousData.getSample());
					newObject.setCollected(priviousData.getCollected());
					newObject.setCollectedBy(priviousData.getCollectedBy());
					newObject.setLastChgBy(user);
					newObject.setLastChgTime(time);
					newObject.setLastChgDate(date);
					newObject.setInvestigation(priviousData.getInvestigation());
					newObject.setMaincharge(priviousData.getMaincharge());
					newObject.setSubcharge(priviousData.getSubcharge());
					newObject.setValidated(priviousData.getValidated());
					newObject.setReason(priviousData.getReason());
					newObject.setDiagNo(priviousData.getDiagNo());
					newObject.setSampleCollDatetime(priviousData
							.getSampleCollDatetime());
					newObject.setContainer(priviousData.getContainer());

					String orderNumber = priviousData
							.getSampleCollectionHeader().getOrder()
							.getOrderNo();

					histoListForMap.add(newObject);

					priviousData.setLastChgBy(user);
					priviousData.setLastChgTime(time);
					priviousData.setLastChgDate(date);
					priviousData.setLabStatus("Y");
					oldHistoMapOfPriviousStep.put(histoId, priviousData);
					newHistoMapForNextStep.put(histoId, histoListForMap);
				}

			}

		}
		boolean loop=true;
		if (request.getParameter("loop") != null
				&& !"".equalsIgnoreCase(request.getParameter("loop").trim())) {
			loop = Boolean.parseBoolean(request.getParameter("loop"));
		}
		boolean flag = false;
		if (totalRow > 0 ||!loop) {
			flag = labHandlerService.saveDetailsOfHisto(histoIdOfPriviousStep,
					oldHistoMapOfPriviousStep, newHistoMapForNextStep);
		} 
		map = labHandlerService.getSampleDetailsForHisto(orderId, user.getId(),
				deptId,hospitalId);
		String message = "";
		String jsp = RequestConstants.SAMPLE_PROCESS_OF_HISTO + ".jsp";
		if (flag && saveHeaderOfHisto) {
			DgSampleCollectionHeader sampleCollectionHeader = ((List<DgSampleCollectionHeader>) map
					.get("samplehdList")).get(0);
			//sampleCollectionHeader.setOrderStatus(orderStatus);
			sampleCollectionHeader.setLastChgBy(user);
			sampleCollectionHeader.setLastChgDate(date);
			sampleCollectionHeader.setLastChgTime(time);
			flag = labHandlerService
					.saveOrUpdateAnyObject(sampleCollectionHeader);
			if (flag) {
				message = "Detail Saved Successfully";
				jsp = RequestConstants.SUCCESS_PAGE_FOR_HISTO + ".jsp";
			}else{
				 message = "Try Again";
				jsp = RequestConstants.SUCCESS_PAGE_FOR_HISTO + ".jsp";
			}

		}
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		map.put("orderId", orderId);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView submitForSatainingInHisto(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<Integer, List<DgHistoSampleCollectionDetails>> newHistoMapForNextStep = new HashMap<Integer, List<DgHistoSampleCollectionDetails>>();
		Map<Integer, DgHistoSampleCollectionDetails> oldHistoMapOfPriviousStep = new HashMap<Integer, DgHistoSampleCollectionDetails>();
		String appId = request.getParameter("appId");
		Integer orderId = Integer.parseInt(request
				.getParameter("orderIdOfHeader"));
		boolean saveHeaderOfHisto = Boolean.parseBoolean(request
				.getParameter("saveHeader"));
		String orderStatus = "A";
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("users");
		Integer deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			 
		}
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		Box box = HMSUtil.getBox(request);
		boolean flag = false;
		Integer histoId = 0;
		for (int i = 1; i <= Integer.parseInt(request.getParameter("counter")); i++) {
			if (request.getParameter("checkName" + i) != null) {
				histoId = Integer.parseInt(request
						.getParameter("dgSampleDetailId" + i));
				DgHistoSampleCollectionDetails priviousData = labHandlerService
						.getSampleDetailsOfHistoById(histoId);
				priviousData.setOrderStatus(request
						.getParameter("stainingComment" + i));
				priviousData.setOrderStatus(orderStatus);
				priviousData.setLastChgBy(user);
				priviousData.setLastChgTime(time);
				priviousData.setLastChgDate(date);
				priviousData.setLabStatus("Y");
				flag = labHandlerService.saveOrUpdateAnyObject(priviousData);
			}

		}
		map = labHandlerService.getSampleDetailsForHisto(orderId, user.getId(),
				deptId,hospitalId);
		String message = "Try Again";
		String jsp = RequestConstants.SAMPLE_PROCESS_FOR_SLIDE_STAINING
				+ ".jsp";
		if (flag && saveHeaderOfHisto) {
			DgSampleCollectionHeader sampleCollectionHeader = ((List<DgSampleCollectionHeader>) map
					.get("samplehdList")).get(0);
			Set<DgSampleCollectionDetails> sampleCollectionSet = sampleCollectionHeader
					.getDgSampleCollectionDetails();
			DgOrderhd dgOrderHd = sampleCollectionHeader.getOrder();
			Set<DgOrderdt> dgOrderdts = dgOrderHd.getDgOrderdts();
			for (DgOrderdt dgOrderdt : dgOrderdts) {
				dgOrderdt.setOrderStatus(orderStatus);
				dgOrderdt.setLastChgBy(user);
				dgOrderdt.setLastChgDate(date);
				dgOrderdt.setLastChgTime(time);
				flag = labHandlerService.saveOrUpdateAnyObject(dgOrderdt);
			}
			if (flag) {
				dgOrderHd.setOrderStatus(orderStatus);
				dgOrderHd.setLastChgBy(user);
				dgOrderHd.setLastChgDate(date);
				dgOrderHd.setLastChgTime(time);
				flag = labHandlerService.saveOrUpdateAnyObject(dgOrderHd);
			}
			for (DgSampleCollectionDetails sampleCollectionDetail : sampleCollectionSet) {
				// save sample collection detail for result entry
				sampleCollectionDetail.setOrderStatus(orderStatus);
				sampleCollectionDetail.setLastChgBy(user);
				sampleCollectionDetail.setLastChgDate(date);
				sampleCollectionDetail.setLastChgTime(time);
				flag = labHandlerService
						.saveOrUpdateAnyObject(sampleCollectionDetail);
			}
			sampleCollectionHeader.setOrderStatus(orderStatus);
			sampleCollectionHeader.setLastChgBy(user);
			sampleCollectionHeader.setLastChgDate(date);
			sampleCollectionHeader.setLastChgTime(time);
			if (flag) {
				flag = labHandlerService
						.saveOrUpdateAnyObject(sampleCollectionHeader);
			}

			if (flag) {
				message = "Detail Saved Successfully";
				jsp = RequestConstants.SUCCESS_PAGE_FOR_HISTO + ".jsp";
			}

		}
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		map.put("orderId", orderId);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView viewIpdTestForOrderNo(HttpServletRequest request,
			HttpServletResponse response) {
		List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> orderDetailMap = new HashMap<String, Object>();

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}

		HttpSession session = request.getSession();
		String deptName = "";
		String jsp = "";

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		int dgOrderHdId = 0;
		int inPatientId = 0;
		if (request.getParameter("dgOrderHdId") != null) {
			dgOrderHdId = Integer.parseInt(request.getParameter("dgOrderHdId"));
			mapForDs.put("dgOrderHdId", dgOrderHdId);
		}
		if (request.getParameter("hinId") != null) {
			int hinId = Integer.parseInt(request.getParameter("hinId"));
			mapForDs.put("hinId", hinId);
		}
		if (request.getParameter(INPATIENT_ID) != null) {
			inPatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			mapForDs.put("inPatientId", inPatientId);
		}
		if (request.getParameter("dischargeSummaryFlag") != null) {
			map.put("dischargeSummaryFlag",
					request.getParameter("dischargeSummaryFlag"));
		}
		// orderNoList = labHandlerService.getOrderNoList(mapForDs);

		orderDetailMap = labHandlerService.getOrderDtMap(mapForDs);

		jsp = "viewIpdTestDetailsForOrderNo";

		map.put("orderDetailMap", orderDetailMap);
		map.put("orderNoList", orderNoList);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getInvestigationDetailsForDischargeSummary(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		List<DgResultEntryDetail> invResultList = new ArrayList<DgResultEntryDetail>();

		int deptId = (Integer) session.getAttribute("deptId");
		int inPatientId = Integer.parseInt(request.getParameter("parent"));
		// String deptName = request.getParameter("deptName");

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap.put("inPatientId", inPatientId);
		detailsMap.put("deptId", deptId);

		map = labHandlerService
				.getInvestigationDetailsForDischargeSummary(detailsMap);
		map.put("inPatientId", inPatientId);
		// map.put("invResultList", invResultList);
		// map.put("deptName", deptName);
		map.put("message", message);

		jsp = "investigationForDSPopup";

		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView pendingEmpanelledLab(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = new Date();
		Date toDate = new Date();
		String patientFName = "";
		String orderStatus = "";
		String hinNo = "";
		String adNo = "";
		String patientType = null;
		int chargeCodeId = 0;
		int departmentId = 0;
		int inpatientId = 0;
		int subGroupId = 0;
		int sampleId = 0;
		int orderId = 0;
		int hinId = 0;
		String visitNumber = null;
		Integer hospitalId = 0;
		String deptName = "";
		String doctorName = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();

		try {
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				mapForDs.put(HOSPITAL_ID, hospitalId);
			}
			if (session.getAttribute("deptName") != null) {
				deptName = (String) session.getAttribute("deptName");
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				mapForDs.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				mapForDs.put("toDate", toDate);
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				patientType = request.getParameter(PATIENT_TYPE);
			}
			if (request.getParameter(RequestConstants.DOCTOR_NAME) != null
					&& !(request.getParameter(RequestConstants.DOCTOR_NAME)
							.equals(""))) {
				doctorName = request.getParameter(RequestConstants.DOCTOR_NAME);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}

			if (request.getParameter(VISIT_NUMBER) != null
					&& !(request.getParameter(VISIT_NUMBER).equals(""))) {
				visitNumber = request.getParameter(VISIT_NUMBER);
				mapForDs.put(VISIT_NUMBER, visitNumber);
			}
			if (request.getParameter(ORDER_BOOKING_ID) != null
					&& !(request.getParameter(ORDER_BOOKING_ID).equals("0"))) {
				orderId = new Integer(request.getParameter(ORDER_BOOKING_ID));
				mapForDs.put("orderId", orderId);
			}
			int deptId = 0;
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
			}
			mapForDs.put(RequestConstants.DOCTOR_NAME, doctorName);
			mapForDs.put(PATIENT_TYPE, patientType);
			mapForDs.put("deptId", deptId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = labHandlerService
				.getPatientDetailsSampleColletion(mapForDs);
		String diagSeqNo = "";
		String jsp = "";
		@SuppressWarnings("unused")
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailList");
		}
		map = labHandlerService.getSampleCollectionDetails(mapForDs);
		@SuppressWarnings("unused")
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		if (map != null && map.get("dgOrderhdList") != null) {
			dgOrderhdList = (List<DgOrderhd>) map.get("dgOrderhdList");
			diagSeqNo = (String) map.get("diagSeqNo");
			if (diagSeqNo != null) {
				map.put("diagSeqNo", diagSeqNo);
			}
			jsp = RequestConstants.DG_SAMPLE_FOR_EMPANELLED + ".jsp";
		} else {
			detailsMap = labHandlerService.getDetailsForSearch(map);
			jsp = RequestConstants.DG_PENDING_SAMPLE_COLLECTION_EMPANELLED
					+ ".jsp";
		}
		map.put("box", box);
		map.put("diagSeqNo", diagSeqNo);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("patientType", patientType);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForEmpanelled(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = new Date();
		Date toDate = new Date();
		String patientFName = "";
		String orderStatus = "";
		String hinNo = "";
		String adNo = "";
		String patientType = null;
		int chargeCodeId = 0;
		int departmentId = 0;
		int inpatientId = 0;
		int subGroupId = 0;
		int sampleId = 0;
		int orderId = 0;
		int hinId = 0;
		String visitNumber = null;
		Integer hospitalId = 0;
		String deptName = "";
		String doctorName = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();

		try {
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				mapForDs.put(HOSPITAL_ID, hospitalId);
			}
			if (session.getAttribute("deptName") != null) {
				deptName = (String) session.getAttribute("deptName");
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				mapForDs.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				mapForDs.put("toDate", toDate);
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				patientType = request.getParameter(PATIENT_TYPE);
			}
			if (request.getParameter(RequestConstants.DOCTOR_NAME) != null
					&& !(request.getParameter(RequestConstants.DOCTOR_NAME)
							.equals(""))) {
				doctorName = request.getParameter(RequestConstants.DOCTOR_NAME);
			}

			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}

			if (request.getParameter(VISIT_NUMBER) != null
					&& !(request.getParameter(VISIT_NUMBER).equals(""))) {
				visitNumber = request.getParameter(VISIT_NUMBER);
				mapForDs.put(VISIT_NUMBER, visitNumber);
			}
			if (request.getParameter(ORDER_BOOKING_ID) != null
					&& !(request.getParameter(ORDER_BOOKING_ID).equals("0"))) {
				orderId = new Integer(request.getParameter(ORDER_BOOKING_ID));
				mapForDs.put("orderId", orderId);
			}
			int deptId = 0;
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
			}
			mapForDs.put(RequestConstants.DOCTOR_NAME, doctorName);
			mapForDs.put(PATIENT_TYPE, patientType);
			mapForDs.put("deptId", deptId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = labHandlerService
				.getPatientDetailsSampleColletion(mapForDs);
		String diagSeqNo = "";
		String jsp = "";
		@SuppressWarnings("unused")
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailList");
		}
		map = labHandlerService.getSampleCollectionDetails(mapForDs);
		@SuppressWarnings("unused")
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		if (map != null && map.get("dgOrderhdList") != null) {
			dgOrderhdList = (List<DgOrderhd>) map.get("dgOrderhdList");
			diagSeqNo = (String) map.get("diagSeqNo");
			if (diagSeqNo != null) {
				map.put("diagSeqNo", diagSeqNo);
			}
			jsp = RequestConstants.DG_SAMPLE_FOR_EMPANELLED + ".jsp";
		} else {
			detailsMap = labHandlerService.getDetailsForSearch(map);
			jsp = RequestConstants.DG_PENDING_SAMPLE_COLLECTION_EMPANELLED
					+ ".jsp";
		}
		map.put("box", box);
		map.put("diagSeqNo", diagSeqNo);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("patientType", patientType);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView getAllTestsKit(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String patientType = null;
		int chargeCodeId = 0;
		int departmentId = 0;
		Integer hospitalId = 0;
		String deptName = "";
		String doctorName = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();

		try {
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				map.put(HOSPITAL_ID, hospitalId);
			}
			if (session.getAttribute("deptName") != null) {
				deptName = (String) session.getAttribute("deptName");
			}
			int deptId = 0;
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = RequestConstants.TEST_KIT + ".jsp";
		map.put("testKit", labHandlerService.getAllTestsKitLab(map));
		map.put("box", box);
		map.put("contentJsp", jsp);
		map.put("patientType", patientType);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addTestKitInLab(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String patientType = null;
		int chargeCodeId = 0;
		int departmentId = 0;
		Integer hospitalId = 0;
		String deptName = "";
		String doctorName = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();

		try {
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				map.put(HOSPITAL_ID, hospitalId);
				box.put(HOSPITAL_ID, hospitalId);
			}
			if (session.getAttribute("deptName") != null) {
				deptName = (String) session.getAttribute("deptName");
				box.put("deptName", deptName);
			}
			int deptId = 0;
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
				box.put("deptId", deptId);
			}
			if (session.getAttribute(RequestConstants.USERS) != null) {
				Users users = (Users) session
						.getAttribute(RequestConstants.USERS);
				box.put(RequestConstants.USER_ID, users.getId());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean flag = labHandlerService.addTestKitInLab(box);
		String message = "";
		if (flag) {
			message = "Testkit successfully saved";
		} else {
			message = "Test Kit already saved";
		}
		String jsp = RequestConstants.TEST_KIT + ".jsp";
		map.put("testKit", labHandlerService.getAllTestsKitLab(map));
		map.put("box", box);
		map.put("contentJsp", jsp);
		map.put("patientType", patientType);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ---------------------------------
	public LabHandlerService getLabHandlerService() {
		return labHandlerService;
	}

	public void setLabHandlerService(LabHandlerService labHandlerService) {
		this.labHandlerService = labHandlerService;
	}

	public BillingHandlerService getBillingHandlerService() {
		return billingHandlerService;
	}

	public void setBillingHandlerService(
			BillingHandlerService billingHandlerService) {
		this.billingHandlerService = billingHandlerService;
	}
	public ModelAndView showPendingSampleCollectionHistoJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		Integer hospitalId = 0;
		String patientType = null;
		if (request.getParameter("flag") != null) {
			patientType = (String) request.getParameter("flag");
		}
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		mapForDs.put(PATIENT_TYPE, patientType);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		detailsMap = labHandlerService.getDetailsForSearch(map);
		patientMap = labHandlerService.getSampleCollectionGrid(mapForDs);
		jsp = DG_PENDING_SAMPLE_COLLECTION + ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptName", deptName);
		map.put("patientType", patientType);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	} 	
	public ModelAndView showPendingSampleValidationHistoJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		String deptType = "";
		int deptId = 0;
		Integer hospitalId = 0;
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		mapForDs.put(HOSPITAL_ID, hospitalId);
		mapForDs.put("deptId", deptId);
		detailsMap = labHandlerService.getSampleValidationSearch(mapForDs);
		patientMap = labHandlerService.getSampleValidationGrid(mapForDs);
		jsp = DG_PENDING_SAMPLE_VALIDATION + ".jsp";
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("deptType", deptType);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showPopupTokenJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		List<DgOrderhd>dgList=new ArrayList<DgOrderhd>();
		HttpSession session = request.getSession();
		String deptName = "";
		Integer hospitalId = 0;
		String patientType = null;
		if (request.getParameter("flag") != null) {
			patientType = (String) request.getParameter("flag");
		}
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		mapForDs.put(PATIENT_TYPE, patientType);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		map = labHandlerService.getLabQueue(mapForDs);
		/*dgList=(List)patientMap.get("patientDetailList");
		List<Visit>dgVisitList=new ArrayList<Visit>();
		for(DgOrderhd dg:dgList){
			dgVisitList.add(dg.getVisit());
		}*/
		jsp = "window_popupLabJsp" + ".jsp";
		//map.put("visitTokenList", dgVisitList);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		//return new ModelAndView("index", "map", map);
		return new ModelAndView("window_popupLabJsp", "map", map);
	}
	public ModelAndView showDiagnosticRegisterSummaryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute("hospitalId") != null) {
			map.put("hospitalId", session.getAttribute("hospitalId"));
		}
		map = labHandlerService.showDiagnosticRegisterSummaryJsp(map);
		jsp = "diagnosticRegisterSummary";
		jsp += ".jsp";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printDiagnosticRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		String query = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		Integer subChargeId = 0;
		Integer depart = 0;
		String patient = "";
		String resultType = "";
		Integer departmentId = 0;
		int hospitalId = 0;
		String dFirst = "";
		String dMiddleName = "";
		String dLastName = "";
		String eFirst = "";
		String eMiddleName = "";
		String eLastName = "";
		String vFirst = "";
		String vMiddleName = "";
		String vLastName = "";
		String currentDate="";
		Date currentDate1 = new Date();
		

		try {

			currentDate = (String) utilMap.get("currentDate");
			
			currentDate1=HMSUtil.convertStringTypeDateToDateType(currentDate);
			
			departmentId = (Integer) session.getAttribute("deptId");
			hospitalId = (Integer) session.getAttribute("hospitalId");
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				
			}
			
			if (request.getParameter("subChargeId") != null) {
				subChargeId = Integer.parseInt(request.getParameter("subChargeId"));
			}
			if (request.getParameter("departmentId") != null) {
				depart = Integer.parseInt(request.getParameter("departmentId"));
			}
			if (request.getParameter("patient") != null) {
				patient =  request.getParameter("patient");
			}
			if (request.getParameter("resultType") != null) {
				resultType =  request.getParameter("resultType");
			}
		
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
			
		query=	"where dgh.result_date between '"+sdf.format(fromDate)+"' and '"+sdf.format(toDate)+"' " +
			//" and dgh.result_status = 'A' "+ commented by dipali
				" and dgh.result_status in ('A','R') "+
			  "and dgd.result_type = '"+resultType+"' and dgh.hospital_id="+hospitalId;
		
		if (subChargeId != 0) {
			query += " and dgh.sub_chargecode_id = "+subChargeId;
	}
	if (depart != 0) {
		query += " and dgorder.department_id = "+depart;
	}
	if(box.getInt(RequestConstants.MARITAL_STATUS_ID)!=0){
//		crit = crit.createAlias("p.MaritalStatus", "ms").add(Restrictions.eq("ms.Id", box.getInt(MARITAL_STATUS_ID)));
		query += " and p.marital_status_id = "+box.getInt(RequestConstants.MARITAL_STATUS_ID);
	}
	if(box.getInt(RequestConstants.SEX_ID)!=0 ){
//		crit = crit.createAlias("p.Sex", "sex").add(Restrictions.eq("sex.Id", box.getInt(SEX_ID)));
		query += " and p.sex_id = "+box.getInt(RequestConstants.SEX_ID);
	}
	if (!(box.getString("fromAge").equals("")) && !(box.getString("fromAgeUnit").equals(""))
			&& !(box.getString("toAge").equals("")) && !(box.getString("toAgeUnit").equals(""))) {
		float fromAge =Float.parseFloat(box.getString("fromAge"));
		float toAge = Float.parseFloat(box.getString("toAge"));
		String fromUnit=box.getString("fromAgeUnit");
		String toUnit=box.getString("toAgeUnit");
		if(box.getString("fromAgeUnit").equalsIgnoreCase("Months")){
			fromAge=fromAge/12;
		}else if(box.getString("fromAgeUnit").equalsIgnoreCase("Days")){
			fromAge=fromAge/365;
		}
		if(box.getString("toAgeUnit").equalsIgnoreCase("Months")){
			toAge=toAge/12;
		}else if(box.getString("toAgeUnit").equalsIgnoreCase("Days")){
			toAge=toAge/365;
		}
		
		
		query += " and (substr(v.age,0,STRPOS(v.age,' '))<>'') and (case when v.age like '%Years%' then cast(substr(v.age,0,STRPOS(v.age,' ')) as real) "
				+ "when  v.age like '%Months%' then (cast(substr(v.age,0,STRPOS(v.age,' ')) as real))/12 "
				+ "when  v.age like '%Days%' then (cast(substr(v.age,0,STRPOS(v.age,' ')) as real))/365 end) >="+fromAge+" " +
				" and  (case when v.age like '%Years%' then cast(substr(v.age,0,STRPOS(v.age,' ')) as real) "
				+ "when  v.age like '%Months%' then (cast(substr(v.age,0,STRPOS(v.age,' ')) as real))/12 "
				+ "when  v.age like '%Days%' then (cast(substr(v.age,0,STRPOS(v.age,' ')) as real))/365 end)<="+toAge;
	
	}
	if(box.getInt(RequestConstants.CONSULTING_DOCTOR)!=0 ){
		query += " and pb.employee_id = "+box.getInt(RequestConstants.CONSULTING_DOCTOR)+"";
	}
	if(box.getInt(INVESTIGATION_ID)!=0 ){
		query += " and dgh.investigation_id = "+box.getInt(INVESTIGATION_ID);
	}
	
	/*if ( !(box.getString("icd").equals(""))) {
		String icd = box.getString("icd");
		 int index1=icd.lastIndexOf("[");
		  int index2=icd.lastIndexOf("]");
		   index1++;
		   String icdCode =""+icd.substring(index1, index2);
		   query += " and icd.icd_code='"+icdCode+"'";
	
	}
	if (!(box.getString("icdNo").equals(""))) {
		query += " and icd.icd_code='"+box.getString("icdNo")+"'";
	}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		// detailsMap = labHandlerService.getSubCharge();
		detailsMap = labHandlerService.getConnectionForReport();
		parameters.put("query", query);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		/*parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("currentDate1", currentDate1);*/
		try {
			byte[] bytes = null;
			try {
				String reportName= "";
				if(resultType.equals("s")){
					reportName="diagnostic_register";
				}else{
					reportName= "diagnostic_register_multiple";
				}
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport(reportName),
						parameters, (Connection) detailsMap.get("con"));

			} catch (JRException e) {

				e.printStackTrace();
			}
			response.setHeader("Content-Disposition", "inline; filename="
					+ "dgInvestigationRequired" + ".pdf");
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = response.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		return null;
	}
	public ModelAndView generateDiagnosticSummary(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute("hospitalId") != null) {
			box.put("hospitalId", session.getAttribute("hospitalId"));
		}
		
		map  = labHandlerService.getDiagnosticSummary(box);
		
		map.put("contentJsp", jsp);
		return new ModelAndView("diagnosticRegisterSummaryReport", "map", map);
	}
	public ModelAndView printDiagnosticRegisterSummary(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		List<MasHospital> hospitalNameList = new ArrayList<MasHospital>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String query = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		Integer subChargeId = 0;
		Integer depart = 0;
		String patient = "";
		String resultType = "";
		Integer departmentId = 0;
		int hospitalId = 0;
		String dFirst = "";
		String dMiddleName = "";
		String dLastName = "";
		String eFirst = "";
		String eMiddleName = "";
		String eLastName = "";
		String vFirst = "";
		String vMiddleName = "";
		String vLastName = "";
		String currentDate="";
		Date currentDate1 = new Date();
		
		

		try {

			
			currentDate = (String) utilMap.get("currentDate");
			
			currentDate1=HMSUtil.convertStringTypeDateToDateType(currentDate);
			
			departmentId = (Integer) session.getAttribute("deptId");
			hospitalId = (Integer) session.getAttribute("hospitalId");
			String fromDate1 =sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
			String toDate1 = sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
			query=	"where dgh.result_date between '"+fromDate1+"' and '"+toDate1+"' and dgh.hospital_id ="+hospitalId;
			
			if(box.getInt(DEPARTMENT_ID)!=0) {
				query += " and mcc.department_id="+box.getInt(DEPARTMENT_ID);
			}
			if(box.getInt(SUB_CHARGECODE_ID)!=0) {
				query += " and inv.sub_chargecode_id="+box.getInt(SUB_CHARGECODE_ID);
			}
			if(box.getInt(INVESTIGATION_ID)!=0) {
				query += " and inv.investigation_id="+box.getInt(INVESTIGATION_ID);
			}
			
			query +=" order by mcc.main_chargecode_name,scc.sub_chargecode_name,investigation_name";
		} catch (Exception e) {
			e.printStackTrace();
		}
		// detailsMap = labHandlerService.getSubCharge();
		detailsMap = labHandlerService.getConnectionForReport();
		
		dataMap = labHandlerService.getHospName(hospitalId);
		
		String hospitalName="";
		String hospitalAddress="";
		hospitalNameList=(List)dataMap.get("hospitalNameList");
		if(hospitalNameList.size()>0)
		{
			hospitalName=hospitalNameList.get(0).getHospitalName();
			hospitalAddress=hospitalNameList.get(0).getAddress();
		}
		parameters.put("hospitalName", hospitalName);
		parameters.put("hospitalAddress", hospitalAddress);
		parameters.put("query", query);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("currentDate1", currentDate1);
		parameters.put("hospitalId", hospitalId);
		try {
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("diagnostic_register_summary"),
						parameters, (Connection) detailsMap.get("con"));

			} catch (JRException e) {

				e.printStackTrace();
			}
			response.setHeader("Content-Disposition", "inline; filename="
					+ "dgInvestigationRequired" + ".pdf");
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = response.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		return null;
	}
	public ModelAndView generatePatientDiagnosticRegisterLab(
			HttpServletRequest request, HttpServletResponse response) {
		Date fromDate = null;
		Date toDate = null;
		int subChargeId = 0;
		int depart = 0;
		int departmentId = 0;
		String patient = "";
		String resultType = "";
		String query = "";
		String toDate1="";
		String fromDate1="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();
		Map<String, Object> resultDetailsMap = new HashMap<String, Object>();
		List<Map<String, Object>> resultDetailsMapList = new ArrayList<Map<String, Object>>();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		parameters.put("hospitalId", hospitalId);
		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				// fromDate
				// =sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE)))
				// ;
				 fromDate1 =sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE)));
				
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				// mapForDs.put("toDate", toDate);

				// toDate =sdf.format(HMSUtil.convertStringTypeDateToDateType(
				// request.getParameter(TO_DATE))) ;
				
				 toDate1 = sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE)));
			}

			
			
			query = " where dg_result_entry_header.result_date between '"
					+ fromDate1 + "' and '" + toDate1 + "'";
				
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				parameters.put("subChargeId", subChargeId);
				query = query
						+ " AND dg_result_entry_header.sub_chargecode_id = "
						+ subChargeId;
			}

			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				depart = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
				parameters.put("depart", depart);
				query = query + " AND dg_orderhd.department_id = " + depart;
			}

			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals("0"))) {
				patient = (request.getParameter(PATIENT_TYPE));
				parameters.put("patient", patient);
				query = query + " AND dg_orderhd.patient_type = '" + patient
						+ "'";
			}

			if (request.getParameter("resultType") != null
					&& !(request.getParameter("resultType").equals("0"))) {
				resultType = request.getParameter("resultType");
				parameters.put("resultType", resultType);
				query = query + " AND dg_result_entry_detail.result_type = '"
						+ resultType + "'";
			}

			if (session.getAttribute("deptId") != null) {
				departmentId = Integer.parseInt(""
						+ session.getAttribute("deptId"));
				parameters.put("departmentId", departmentId);
				query = query
						+ " AND dg_result_entry_header.department_id = "
						+ departmentId;
			}

		//	query = query + " AND dg_result_entry_header.result_status = 'A'";
			
			query = query + " AND dg_result_entry_header.result_status in('A','R')";

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = labHandlerService.getConnectionForReport();

		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("QUERY", query);
		parameters.put("hospitalId",hospitalId);
		Box box = HMSUtil.getBox(request);
		parameters.put("box", box);
		String appendedHtml = "";
		String jsp="";
		try {
			if (resultType.equalsIgnoreCase("m")) {
				detailsMap1 = labHandlerService
						.getDiagnosticRegisterForMultipleTestType(parameters);
				List<DgResultEntryHeader> dgMultipleResultdetailList = new ArrayList<DgResultEntryHeader>();
				if (detailsMap1.get("dgMultipleResultdetailList") != null) {
					dgMultipleResultdetailList = (List) detailsMap1
							.get("dgMultipleResultdetailList");
					for (DgResultEntryHeader dgResultEntryHeader : dgMultipleResultdetailList) {
						resultDetailsMap = labHandlerService
								.getResultEntryDetailsForMultipleResultType(
										dgResultEntryHeader.getId(), deptId);
						resultDetailsMapList.add(resultDetailsMap);
					}
					map.put("resultDetailsMapList", resultDetailsMapList);
				}
				jsp = "diagnosticRegisterLabMultipleTestType";
			} else {
				detailsMap1 = labHandlerService
						.getDiagnosticRegister(parameters);
				jsp = "diagnosticRegisterLab";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("detailsMap1", detailsMap1);
		map.put("parameters", parameters);
		map.put("appendedHtml", appendedHtml);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	} 
	public ModelAndView showPacsListJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute("hospitalId") != null) {
			box.put("hospitalId", session.getAttribute("hospitalId"));
		}
		String jsp="pacsView.jsp";
		map  = labHandlerService.viewPacsImage(box);
		
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public void showPacsViewServer(HttpServletRequest request,HttpServletResponse response) throws ServletException {
		
		HttpSession session = request.getSession();
		Users users =null;
		String userId=null;
		if(session.getAttribute("users")!=null){
			users = (Users) session.getAttribute("users");
			userId=users.getLoginName();
		}
		
		response.setContentType("text/html");  
		PrintWriter pw;
		try {
			 String accid=request.getParameter("accId");
			 String empCode=request.getParameter("codeEmp");
			pw = response.getWriter();
			/*response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", "http://www.google.com");
			response.sendRedirect("http://www.google.com");*/
			
			//response.sendRedirect("http://localhost:8090/hms/doctorModule/");

				//response.sendRedirect("http://192.168.203.195/viewImages?an=52&user=R00128");
				URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("jktPacs.properties");
				Properties prop = new Properties(); 
				prop.load(resourcePath.openStream()); 
				String header = prop.getProperty("VIEW_PACS_IMAGE");
				//System.out.print("view pacs image url>>>"+header+accid+"&user=phy");
				//response.sendRedirect(header+accid+"&user=phy");// for JKT				
				String timeVar="&timestamp"+HMSUtil.convertDateOneFormatToAnother("yyyy-MM-dd HH:MM;SS", new Date());
				String newUrl=header+accid+"&user="+userId+timeVar;
				System.out.print("view pacs image url>>>"+newUrl);
				response.sendRedirect(newUrl);// for JKT
			
				pw.close(); 
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}   	
	}
	public ModelAndView showLabMachineBarCodeReportJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute("hospitalId") != null) {
			box.put("hospitalId", session.getAttribute("hospitalId"));
		}

		String jsp="barCode.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView getOrderListForPatient(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int deptId = 0;
		int hospitalId=0;
		HttpSession session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		String hinNo="";
		if(request.getParameter(HIN_NO)!=null && !request.getParameter(HIN_NO).equals("")){
			hinNo=request.getParameter(HIN_NO).trim();
		}
		map=labHandlerService.getOrderListForPatient(hospitalId,hinNo);

		String jsp="responseForbarCode";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getsampleListForOrder(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int deptId = 0;
		int hospitalId=0;
		HttpSession session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		int orderId=0;
		if(request.getParameter("orderName")!=null){
			orderId=Integer.parseInt(request.getParameter("orderName"));
		}
		map=labHandlerService.getsampleListForOrder(hospitalId,orderId);

		String jsp="responseForbarCodeSampleDetails";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	//print tr5 report added by lokesh
	
	public ModelAndView printtr5(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		String order_no = "";
        int hin_id=0;
		session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		if (request.getParameter("hinNo") != null
				&& !(request.getParameter("hinNo").equals(""))) {
			hin_id = Integer.parseInt(request
					.getParameter("hinNo"));
		}
		
		if (request.getParameter("orderNo") != null
				&& !(request.getParameter("orderNo").equals(""))) {
			order_no = request
					.getParameter("orderNo");
		}
		detailsMap = labHandlerService.getConnectionForReport();
		//parameters.put("hin_id", hin_id);
		parameters.put("order_no", order_no);
		

				try {
					HMSUtil.generateReport("tr5forlabbooking", parameters,
							(Connection) detailsMap.get("con"), response,
							getServletContext());
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	
		return null;
	}
	public ModelAndView getOPClinicalWaitingListLab(HttpServletRequest request,	HttpServletResponse response) {
		int deptId = 0;
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		int tokeNo=0;
		String patientName;
		String uhid;
		int opd_DepartmentId=0;
		int hospitalId=0;
		int searchFlag=0;
		String flag="";
		mapForDS.put("forOPClinnic", true);
		if(request.getParameter("flag")!=null){
			flag=request.getParameter("flag");
			mapForDS.put("flag",flag);
		}
		if(request.getParameter("searchFlag")!=null){
			searchFlag=Integer.parseInt(request.getParameter("searchFlag"));
			mapForDS.put("searchFlag",searchFlag);
		}
		
		if(request.getParameter("tokenNo")!=null && !request.getParameter("tokenNo").equals("") ){
			tokeNo = Integer.parseInt(request.getParameter("tokenNo"));
			mapForDS.put("tokenNo",tokeNo);
		}
		if(request.getParameter("patientName")!=null && !request.getParameter("patientName").equals("")){
			patientName = request.getParameter("patientName");
			mapForDS.put("patientName", patientName);
		}
		if(request.getParameter("uhid")!=null){
			uhid = request.getParameter("uhid");
			mapForDS.put("uhid", uhid);
		}
		if(session.getAttribute(HOSPITAL_ID)!=null){
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		
		Integer userId=null;
		if(session.getAttribute(USER_ID)!=null){
			userId = (Integer) session.getAttribute(USER_ID);
			mapForDS.put("userId", userId);
		}
		
		
		
		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
			session.setAttribute("deptId", deptId);
			mapForDS.put("deptId", deptId);
		} else {
			if(session.getAttribute("deptId")!=null){
			deptId = (Integer) session.getAttribute("deptId");
			mapForDS.put("deptId", deptId);
			}
		}
		
		String title = request.getParameter("title");
		mapForDS.put("hospitalId", hospitalId);
		
		mapForDS.put("opClinicalWaitinList", true);

		
		map = labHandlerService.getWaitingPatientList(mapForDS);
		String deptName =(String)map.get("deptName");
		
		session.setAttribute("deptName", deptName);
		String jsp = "op_clinical_waiting_list_lab.jsp";
		title = "Waiting Patient List";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView getPatientDetailsNew(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		String deptType = "";
		int visitNo = 0;
		int visitId = 0;
		int deptId=0;
		int hospitalId=0;
		if(session.getAttribute("deptId")!=null){
			deptId=(Integer)session.getAttribute("deptId");
		}
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}

		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}

		if (request.getParameter(VISIT_NUMBER) != null) {
			visitNo = Integer.parseInt(request.getParameter(VISIT_NUMBER));
			map.put("visitNo", visitNo);
		}
		if (request.getParameter("visitId") != null) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
			map.put("visitId", visitId);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (visitId != 0) {
			map = labHandlerService
					.showOrderBookingForInvestigationJsp(visitId,hospitalId);
			String orderSeqNo = "";
			orderSeqNo = labHandlerService.getOrderSeqForDisplay("ON");
			if (orderSeqNo != null) {
				map.put("orderSeqNo", orderSeqNo);
			}
		}
		dataMap.put("deptType", deptType);
		dataMap.put("deptId",deptId);
		detailsMap = labHandlerService.getMainAndSubChargeForLab(dataMap);
		String jsp = "diag_investigationOrderBookingNew" + ".jsp";

		//jsp = "diag_opOrderBookingSearchNew" + ".jsp";
		map.put("deptName", deptName);
		//map.put("includedJsp", includedJsp);
		map.put("detailsMap", detailsMap);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView 	getInvestigationDetailsForNewRequest(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int val=0;
		int hin=0;
		if(request.getParameter("val")!=null){
			val=Integer.parseInt(request.getParameter("val"));
		}if(request.getParameter("hin")!=null){
			hin=Integer.parseInt(request.getParameter("hin"));
		}
		//map.put("deptName", deptName);
		//map.put("includedJsp", includedJsp);
		map=labHandlerService.getInvestigationDetailsForNewRequest(val);
		jsp="responseForInvestigationNewRequest";
		map.put("hin", hin);
		map.put("detailsMap", detailsMap);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
		}
	public ModelAndView getHospitalForDistrict(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalTypeId=0;
		if(request.getParameter("hospitalTypeName")!=null){
			hospitalTypeId=Integer.parseInt(request.getParameter("hospitalTypeName"));
		}
		int districtId=0;
		if(request.getParameter("districtName")!=null){
			districtId=Integer.parseInt(request.getParameter("districtName"));
		}
		map=labHandlerService.getHospitalForDistrict(districtId,hospitalTypeId);
		jsp="responseForHospitalNameForDistrict";
		map.put("detailsMap", detailsMap);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
		}	
	public ModelAndView showPendingForSmearResultPH(HttpServletRequest request,
			HttpServletResponse response) {
		String buttonFlag = "";
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		int hospitalId=0;
		if(session.getAttribute("hospitalId")!=null){
			hospitalId=(Integer)session.getAttribute("hospitalId");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map = labHandlerService.showPendingForSmearResultPH(map);
		map.put("detailsMap", detailsMap);
		jsp = "phSampleCollection";
		jsp += ".jsp";
		title = "OrderBooking";
		//map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}
	public ModelAndView sendForSampleValidatePh(HttpServletRequest request,
			HttpServletResponse response) {
		int memberId=0;
		String[] memberStatus=null;
		if(request.getParameterValues("memBerStatus")!=null){
			memberStatus=request.getParameterValues("memBerStatus");
		}
		Map<String,Object>map=new HashMap<String,Object>();
		ArrayList<String> mem=new ArrayList<String>();
		Box box = HMSUtil.getBox(request);
		Vector memeberStatus=box.getVector("memBerStatus");
		Vector memeberId=box.getVector("checkMemBer");
		Vector referHospital=box.getVector("referHospital");
		Vector chargeCodeId=box.getVector("chargeCodeId");
		Vector mainChargeCodeId=box.getVector("mainChargeCodeId");
		Vector subChargeCodeId=box.getVector("subChargeCodeId");
		Vector investigationId=box.getVector("investigationId");
		Vector containerId=box.getVector("containerId");
		Vector sampleId=box.getVector("sampleId");
		Vector phInvestigationId=box.getVector("phInvestigationId");
		Vector smearNo=box.getVector("smearNo");
		List memberStatusList = new ArrayList();
		List membeIdList = new ArrayList();
		List referHospitalList = new ArrayList();
		List chargeCodeIdList = new ArrayList();
		List mainChargeCodeIdList = new ArrayList();
		List subChargeCodeIdList = new ArrayList();
		List investigationIdList = new ArrayList();
		List sampleIdList = new ArrayList();
		List containerIdList = new ArrayList();
		List phInvestigationIdList = new ArrayList();
		List smearNoList = new ArrayList();
		
		int phMemberId=0;
		int referId=0;
		int chargeId=0;
		int mainChargeId=0;
		int subChargeId=0;
		int masInvestigationId=0;
		int sampleContainerId=0;
		int testSampleIdId=0;
		int phInvestigationSampleId = 0;
		String smearNoValue = "";
		HttpSession session =request.getSession();
		int userId=0;
		boolean saved = false;
		if(session.getAttribute("userId")!=null){
		userId=(Integer)session.getAttribute("userId");
			box.put("userId", userId);
		}
		if(session.getAttribute("users")!=null){
			Users users=(Users)session.getAttribute("users");
			int employeeId = users.getEmployee().getId();
				box.put("employeeId", employeeId);
			}
		
		
		/*for (int i =0; i < memeberStatus.size(); i++) {
		System.out.println(i+"----memeberId.get(i)----"+memeberId.get(i));
		if(memeberStatus.get(i).equals("y")){
			
			
			if(memeberId.get(i) != null && !memeberId.get(i).equals("")){
				phMemberId=Integer.parseInt(""+memeberId.get(i));
			}else{
				phMemberId = 0;	
			}
			if(referHospital.get(i) != null && !referHospital.get(i).equals("0")){
				referId=Integer.parseInt(""+referHospital.get(i));
			}else{
				referId = 0;
			}
			if(chargeCodeId.get(i) != null && !chargeCodeId.get(i).equals("0")){
				chargeId=Integer.parseInt(""+chargeCodeId.get(i));
			}else{
				chargeId = 0;
			}
			if(mainChargeCodeId.get(i) != null && !mainChargeCodeId.get(i).equals("0")){
				mainChargeId=Integer.parseInt(""+mainChargeCodeId.get(i));
			}else{
				mainChargeId = 0;
			}
			if(subChargeCodeId.get(i) != null && !subChargeCodeId.get(i).equals("0")){
				subChargeId=Integer.parseInt(""+subChargeCodeId.get(i));
			}else{
				subChargeId = 0;
			}
			if(investigationId.get(i) != null && !investigationId.get(i).equals("0")){
				masInvestigationId=Integer.parseInt(""+investigationId.get(i));
			}else{
				masInvestigationId = 0;
			}
			if(containerId.get(i) != null && !containerId.get(i).equals("0")){
				sampleContainerId=Integer.parseInt(""+containerId.get(i));
			}else{
				sampleContainerId = 0;
			}
			if(sampleId.get(i) != null && !sampleId.get(i).equals("0")){
				testSampleIdId=Integer.parseInt(""+sampleId.get(i));
			}else{
				testSampleIdId = 0;
			}
			if(phInvestigationId.get(i) != null && !phInvestigationId.get(i).equals("0")){
				phInvestigationSampleId=Integer.parseInt(""+phInvestigationId.get(i));
			}else{
				phInvestigationSampleId = 0;
			}
			if(smearNo.get(i) != null && !smearNo.get(i).equals("0")){
				smearNoValue=smearNo.get(i).toString();
			}else{
				smearNoValue = "";
			}
			box.put("phMemberId", phMemberId);
			box.put("phInvestigationSampleId", phInvestigationSampleId);
			box.put("referId", referId);
			box.put("chargeId", chargeId);
			box.put("mainChargeId", mainChargeId);
			box.put("subChargeId", subChargeId);
			box.put("masInvestigationId", masInvestigationId);
			box.put("sampleContainerId", sampleContainerId);
			box.put("testSampleIdId", testSampleIdId);
			box.put("smearNoValue", smearNoValue);*/
			map=labHandlerService.sendForSampleValidatePh(box);
			if(map.get("saved") != null){
				saved = (Boolean)map.get("saved");
			}
			if (saved) {
				message = "Data save Successfully !!";
			} else {
				message = "Try Again!";
			}
			
			
		jsp = "phSampleCollection";
		jsp += ".jsp";
		title = "OrderBooking";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView	showLabWorksheetJsp(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
				
				String jsp="labWorksheet";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				return new ModelAndView("index", "map", map);
	}
	public ModelAndView	htmlWorksheet(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate=new Date();
		Date toDate=new Date();
		String hin_no="";
        HttpSession session=request.getSession();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		String reportName="labWorksheet";
		int hospitalId=0;
		String hospitalName="";
		if(!request.getParameter("hin_no").equals("")){
		
			hin_no =""+request.getParameter("hin_no");
			dataMap.put("hin_no",hin_no);
		}
		
		if(request.getParameter("fromDate") != null){
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("fromDate"));
			dataMap.put("fromDate",fromDate);
		}
		if(request.getParameter("toDate") != null){
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("toDate"));
			dataMap.put("toDate",toDate);
		}
		
		if(session.getAttribute("hospitalId")!=null){
			hospitalId=(Integer)session.getAttribute("hospitalId");
			hospitalName = labHandlerService.getHospitalName(hospitalId);
			dataMap.put("hospitalId",hospitalId);
		}
		
		map = labHandlerService.htmlWorksheet(dataMap);
		
		String jsp="responseLabWorksheet";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView printLabWorksheet(HttpServletRequest request, HttpServletResponse response) {
		Date fromDate=new Date();
		Date toDate=new Date();
		String hin_no="";
        HttpSession session=request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String reportName="labWorksheet";
		String query="";
		int hospitalId=0;
		String hospitalName="";
		if(!request.getParameter("hin_no").equals("")){
		
			hin_no =""+request.getParameter("hin_no");
			query+=" and pt.hin_no="+hin_no;
		}
		
		if(request.getParameter("fromDate") != null){
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate") != null){
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("toDate"));
		}
		
		if(session.getAttribute("hospitalId")!=null){
			hospitalId=(Integer)session.getAttribute("hospitalId");
			hospitalName = labHandlerService.getHospitalName(hospitalId);
		
		}

		parameters.put("hospital_name", hospitalName);
		parameters.put("hospital_id", hospitalId);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("query", query);
		
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = labHandlerService.getConnectionForReport();
		
		
		HMSUtil.generateReport(reportName, parameters, (Connection)detailsMap.get("con"), response, getServletContext());
		return null;
		}
 /** Method to populate investigation list onchange of subCharge  at the
  * time of order booking  . Added by dhananjay 27-08-2016
 * @param request
 * @param response
 * @return
 */
public ModelAndView showInvestigationBySubChargeId(HttpServletRequest request,
			HttpServletResponse response) {
	
		Map<String, Object> map = new HashMap<String, Object>();
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session= request.getSession();
		
		int subChargeId=0;
		int mainChargeCodeId=0;
		int hospitalId=0;
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			
		}
		if (request.getParameter("subChargeId") != null) {
			subChargeId = Integer.parseInt(request.getParameter("subChargeId"));
		}
		
		if (request.getParameter("mainChargeCodeId") != null) {
			mainChargeCodeId = Integer.parseInt(request.getParameter("mainChargeCodeId"));
		}
		dataMap.put("mainChargeCodeId", mainChargeCodeId);
		dataMap.put("subChargeId", subChargeId);
		dataMap.put("hospitalId", hospitalId);
		
		map = labHandlerService.showInvestigationBySubChargeId(dataMap);
		
		String jsp ="investigationBySubcharge" ;//+ ".jsp";
		map.put("contentJsp", jsp);
		
		return new ModelAndView(jsp, "map", map);
	}

public ModelAndView fillChargeCoded(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	String sdValues="";
	if (request.getParameter("sdValues") != null) {
		sdValues =request.getParameter("sdValues");
	}
	int hinIdd=0;
	if (request.getParameter("hinId") != null) {
		hinIdd =Integer.parseInt(request.getParameter("hinId"));
	}
	
	if (request.getParameter("sdValues") != null) {
		sdValues =request.getParameter("sdValues");
	}
	
	
	String rowVal = request.getParameter("rowVal");
	String chargeCodeWithId = request.getParameter("chargeCode" + rowVal);
	int hinId = 0;
	if (request.getParameter("hin") != null) {
		hinId = Integer.parseInt(request.getParameter("hin"));

	}


		map = labHandlerService.getChargeCodeRate(sdValues, hinId);
		
	map.put("rowVal", rowVal);
	map.put("contentJsp", jsp);
	
	map.put("sdValues", sdValues);
	map.put("hinIdd", hinIdd);
	String jsp ="responeForSelectedInvestigation" ;//+ ".jsp";
	map.put("contentJsp", jsp);
	
	return new ModelAndView(jsp, "map", map);
}

/*------------Sample Collection Report-------------*/

public ModelAndView	showSampleCollectionReportJsp(HttpServletRequest request,HttpServletResponse response){
	Map<String, Object> map = new HashMap<String, Object>();
	
	String jsp="diagSampleCollectionReport";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}

public ModelAndView generateSampleCollectionReport(HttpServletRequest request, HttpServletResponse response) {
	Date fromDate=new Date();
	Date toDate=new Date();
	String hin_no="";
    HttpSession session=request.getSession();
	Map<String, Object> parameters = new HashMap<String, Object>();
	String reportName="diag_sample_collection";
	String patientName="";
	int tokenNo=0;
	String doctorName="";
	String priorityId="";
	String query="";
	int hospitalId=0;
	
	if (session.getAttribute(HOSPITAL_ID) != null) {
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}
	if(request.getParameter("fromDate") != null){
		fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("fromDate"));
	}
	if(request.getParameter("toDate") != null){
		toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("toDate"));
	}
	if(!request.getParameter("hinNo").equals("")){
		hin_no =""+request.getParameter("hinNo");
		query+=" and p.hin_no='"+hin_no+"'";
	}
	if(!request.getParameter("pFirstName").equals("")){
		patientName=request.getParameter("pFirstName");
		query+=" and p.full_name like '%"+patientName+"%'";
	}
	if(!request.getParameter("visitNumber").equals("")){
		tokenNo=Integer.parseInt(request.getParameter("visitNumber"));
		query+=" and v.token_no="+tokenNo;
	}
	if(!request.getParameter("doctorName").equals("")){
		doctorName=request.getParameter("doctorName");
		query+=" and me.emp_name like '%"+doctorName+"%'";
	}
	if(!request.getParameter("priorityId").equals("0")){
		priorityId=request.getParameter("priorityId");
		query+=" and routine_urgent_status='"+priorityId+"'";
	}
	
	
	parameters.put("fromDate", fromDate);
	parameters.put("toDate", toDate);
	parameters.put("hospitalId", hospitalId);
	parameters.put("query", query);
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	detailsMap = labHandlerService.getConnectionForReport();
	
	String flag="1";
	if (request.getParameter("flag") != null) {
		flag = request.getParameter("flag");
	}
	if (flag.equals("1"))
	{
		HMSUtil.generateReport(reportName, parameters, (Connection)detailsMap.get("con"), response, getServletContext());
	}

	else if(flag.equals("2")) {
				HMSUtil.generateHTMLReport(reportName, parameters, (Connection)detailsMap.get("con"), response, getServletContext());
	}
	
	return null;
	}

/*------------Sample Validation Report-------------*/

public ModelAndView	showSampleValidationReportJsp(HttpServletRequest request,HttpServletResponse response){
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
    HttpSession session=request.getSession();
	int hospitalId = 0;
	int userId = 0;
	
	if (session.getAttribute(HOSPITAL_ID) != null) {
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}
	if (session.getAttribute("userId") != null) {
		userId = (int) session.getAttribute("userId");
	}
	
	map.put("hospitalId",hospitalId);
	map.put("userId",userId); // added by amit das on 17-07-2017
	
	detailsMap = labHandlerService.getDetailsForSearch(map);
	String jsp="diagSampleValidationReport";
	jsp += ".jsp";
	map.put("detailsMap", detailsMap);
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}

public ModelAndView generateSampleValidationReport(HttpServletRequest request, HttpServletResponse response) {
	Date fromDate=new Date();
	Date toDate=new Date();
	String hin_no="";
    HttpSession session=request.getSession();
	Map<String, Object> parameters = new HashMap<String, Object>();
	String reportName="diag_sample_validation";
	String patientName="";
	Long mobilNo=0L;
	int subChargeCodeId=0;
	String priorityId="";
	String query="";
	int hospitalId=0;
	
	if (session.getAttribute(HOSPITAL_ID) != null) {
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}
	if(request.getParameter("fromDate") != null){
		fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("fromDate"));
	}
	if(request.getParameter("toDate") != null){
		toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("toDate"));
	}
	if(!request.getParameter("hinNo").equals("")){
		hin_no =""+request.getParameter("hinNo");
		query+=" and p.hin_no='"+hin_no+"'";
	}
	if(!request.getParameter("pFirstName").equals("")){
		patientName=request.getParameter("pFirstName");
		query+=" and p.full_name like '%"+patientName+"%'";
	}
	if(!request.getParameter("mobilNo").equals("")){
		mobilNo=Long.parseLong(request.getParameter("mobilNo"));
		query+=" and cast(p.mobile_number as varchar(15)) like '"+mobilNo+"'";
	}
	if(!request.getParameter("subChargeCodeId").equals("0")){
		subChargeCodeId=Integer.parseInt(request.getParameter("subChargeCodeId"));
		query+=" and msc.sub_chargecode_id="+subChargeCodeId;
	}
	if(!request.getParameter("priorityId").equals("0")){
		priorityId=request.getParameter("priorityId");
		query+=" and routine_urgent_status='"+priorityId+"'";
	}
	
	
	parameters.put("fromDate", fromDate);
	parameters.put("toDate", toDate);
	parameters.put("hospitalId", hospitalId);
	parameters.put("query", query);
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	detailsMap = labHandlerService.getConnectionForReport();
	
	String flag="1";
	if (request.getParameter("flag") != null) {
		flag = request.getParameter("flag");
	}
	if (flag.equals("1"))
	{
		HMSUtil.generateReport(reportName, parameters, (Connection)detailsMap.get("con"), response, getServletContext());
	}

	else if(flag.equals("2")) {
				HMSUtil.generateHTMLReport(reportName, parameters, (Connection)detailsMap.get("con"), response, getServletContext());
	}
	return null;
	}

public ModelAndView showRadiologyTokenJsp(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> mapForDs = new HashMap<String, Object>();
	List<DgOrderhd>dgList=new ArrayList<DgOrderhd>();
	HttpSession session = request.getSession();
	String deptName = "";
	Integer hospitalId = 0;
	String patientType = null;
	if (request.getParameter("flag") != null) {
		patientType = (String) request.getParameter("flag");
	}
	if (session.getAttribute("deptName") != null) {
		deptName = (String) session.getAttribute("deptName");
	}
	if (session.getAttribute(HOSPITAL_ID) != null) {
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}
	mapForDs.put(PATIENT_TYPE, patientType);
	mapForDs.put(HOSPITAL_ID, hospitalId);
	map = labHandlerService.getLabQueue(mapForDs);
	
	jsp = "displayRadioQueue" + ".jsp";
	
	map.put("deptName", deptName);
	map.put("contentJsp", jsp);
	
	return new ModelAndView("window_popupLabJsp", "map", map);
}

public ModelAndView showPendingSampleValidationJspIPD(
		HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	Map<String, Object> mapForDs = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	String deptName = "";
	String deptType = "";
	int deptId = 0;
	Integer hospitalId = 0;
	if (session.getAttribute("deptName") != null) {
		deptName = (String) session.getAttribute("deptName");
	}
	if (session.getAttribute("deptType") != null) {
		deptType = (String) session.getAttribute("deptType");
	}
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
	}
	if (session.getAttribute(HOSPITAL_ID) != null) {
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}
	mapForDs.put(HOSPITAL_ID, hospitalId);
	mapForDs.put("deptId", deptId);
	mapForDs.put("hospitalId",hospitalId);
	detailsMap = labHandlerService.getSampleValidationSearch(mapForDs);
	
	
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	int labDepartmentId = Integer.parseInt(properties.getProperty("labDepartmentId"));
	int radiologyDepartmentId = Integer.parseInt(properties.getProperty("radiologyDepartmentId"));
	
	if(radiologyDepartmentId == deptId){
		patientMap = labHandlerService.getSampleValidationGridRadiologyIPD(mapForDs);
	jsp = "diag_pendingSampleValidationIPD.jsp";
	}
	 
	if(labDepartmentId == deptId){
		patientMap = labHandlerService.getSampleValidationGrid(mapForDs);
	jsp = "diag_pendingSampleValidationLab.jsp";
	}
	
	map.put("deptId", deptId);
	map.put("deptName", deptName);
	map.put("deptType", deptType);
	map.put("patientMap", patientMap);
	map.put("detailsMap", detailsMap);
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
} 

//Added by Arbind on 10-04-2017
public ModelAndView showPendingSampleCollectionSearchResult(
		HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	Map<String, Object> mapForDs = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Date fromDate = new Date();
	Date toDate = new Date();
	String patientFName = "";
	String orderStatus = "";
	String hinNo = "";
	String adNo = "";
	String patientType = null;
	int chargeCodeId = 0;
	int departmentId = 0;
	int inpatientId = 0;
	int subGroupId = 0;
	int sampleId = 0;
	int orderId = 0;
	int hinId = 0;
	int tokenNo = 0;
	Integer hospitalId = 0;
	int searchFlag=0;
	String deptName = "";
	String doctorName = "";
	Box box = HMSUtil.getBox(request);
	session.setAttribute("box", box);
	session = request.getSession();
	int deptId = 0;
	String deptType = "";
	try {
		if(request.getParameter("searchFlag")!=null){
			searchFlag=Integer.parseInt(request.getParameter("searchFlag"));
			mapForDs.put("searchFlag", searchFlag);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			mapForDs.put(HOSPITAL_ID, hospitalId);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			mapForDs.put("departmentId", deptId);
		}
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
			inpatientId = Integer.parseInt(request
					.getParameter(INPATIENT_ID));
			mapForDs.put("inpatientId", inpatientId);
		}
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
			mapForDs.put("fromDate", fromDate);
		}
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
			mapForDs.put("toDate", toDate);
		}
		if (request.getParameter("flag") != null
				&& !(request.getParameter("flag").equals(""))) {
			patientType = request.getParameter("flag");
		}
		if (request.getParameter(RequestConstants.DOCTOR_NAME) != null
				&& !(request.getParameter(RequestConstants.DOCTOR_NAME)
						.equals(""))) {
			doctorName = request.getParameter(RequestConstants.DOCTOR_NAME);
		}
		if (request.getParameter(CHARGE_CODE_ID) != null
				&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
			chargeCodeId = Integer.parseInt(request
					.getParameter(CHARGE_CODE_ID));
			mapForDs.put("chargeCodeId", chargeCodeId);
		}
		if (request.getParameter(SUB_CHARGECODE_ID) != null
				&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
			subGroupId = Integer.parseInt(request
					.getParameter(SUB_CHARGECODE_ID));
			mapForDs.put("subGroupId", subGroupId);
		}
		if (request.getParameter("sampleName") != null
				&& !(request.getParameter("sampleName").equals("0"))) {
			sampleId = Integer.parseInt(request.getParameter("sampleName"));
			mapForDs.put("sampleId", sampleId);
		}
		if (request.getParameterValues("invName") != null
				&& !(request.getParameterValues("invName").length == 0)) {
			String[] invNameId = request.getParameterValues("invName");
			mapForDs.put("invName", invNameId);
		}
		if (request.getParameter(P_FIRST_NAME) != null
				&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
			patientFName = request.getParameter(P_FIRST_NAME);
			mapForDs.put("patientFName", patientFName);
		}
		
		if (request.getParameter(VISIT_NUMBER) != null
				&& !(request.getParameter(VISIT_NUMBER).equals(""))) {
			tokenNo = Integer.parseInt(request.getParameter(VISIT_NUMBER));
			mapForDs.put("tokenNo", tokenNo);
		}
		if (request.getParameter(ORDER_BOOKING_ID) != null
				&& !(request.getParameter(ORDER_BOOKING_ID).equals("0"))) {
			orderId = new Integer(request.getParameter(ORDER_BOOKING_ID));
			mapForDs.put("orderId", orderId);
		}
		String priorityId = "";
		if (request.getParameter("priorityId") != null
				&& !(request.getParameter("priorityId").equals("0"))) {
			priorityId = request.getParameter("priorityId");
			mapForDs.put("priorityId", priorityId);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		mapForDs.put(RequestConstants.DOCTOR_NAME, doctorName);
		mapForDs.put(PATIENT_TYPE, patientType);
		mapForDs.put("deptId", deptId);
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	mapForDs.put(PATIENT_TYPE, patientType);
	mapForDs.put(HOSPITAL_ID, hospitalId);
	detailsMap = labHandlerService.getDetailsForSearch(map);
	patientMap = labHandlerService.getSampleCollectionGrid(mapForDs);
	jsp = DG_PENDING_SAMPLE_COLLECTION + ".jsp";
	map.put("detailsMap", detailsMap);
	map.put("patientMap", patientMap);
	map.put("deptName", deptName);
	map.put("patientType", patientType);
	map.put("fromDate", fromDate);
	map.put("toDate", toDate);
	map.put("hinNo", hinNo);
	map.put("patientFName", patientFName);
	map.put("tokenNo", tokenNo);
	map.put("subGroupId", subGroupId);
	map.put("doctorName", doctorName);
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}

//Added by Arbind on 10-04-2017
@SuppressWarnings("unchecked")
public ModelAndView getSampleCollectionOpListRefresh(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> mapForDs = new HashMap<String, Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	@SuppressWarnings("unused")
	Date fromDate = new Date();
	Date toDate = new Date();
	String patientFName = "";
	String orderStatus = "";
	String hinNo = "";
	String adNo = "";
	int subChargeId=0;
	String patientType = null;
	int chargeCodeId = 0;
	int departmentId = 0;
	int inpatientId = 0;
	int subGroupId = 0;
	int sampleId = 0;
	int orderId = 0;
	int hinId = 0;
	int tokenNo = 0;
	Integer hospitalId = 0;
	String deptName = "";
	String doctorName = "";
	Box box = HMSUtil.getBox(request);
	session.setAttribute("box", box);
	session = request.getSession();
	int deptId = 0;
	int searchFlag = 0;
	String deptType = "";
	try {
		if(request.getParameter("searchFlag")!=null){
			searchFlag=Integer.parseInt(request.getParameter("searchFlag"));
			mapForDs.put("searchFlag", searchFlag);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			mapForDs.put(HOSPITAL_ID, hospitalId);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			mapForDs.put("departmentId", deptId);
		}
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
			inpatientId = Integer.parseInt(request
					.getParameter(INPATIENT_ID));
			mapForDs.put("inpatientId", inpatientId);
		}
		if (request.getParameter("subChargeId") != null
				&& !(request.getParameter("subChargeId").equals("0"))) {
			subChargeId = Integer.parseInt(request
					.getParameter("subChargeId"));
			mapForDs.put("subChargeId", subChargeId);
		}
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
			mapForDs.put("fromDate", fromDate);
		}
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
			mapForDs.put("toDate", toDate);
		}
		if (request.getParameter("flag") != null
				&& !(request.getParameter("flag").equals(""))) {
			patientType = request.getParameter("flag");
		}
		if (request.getParameter(RequestConstants.DOCTOR_NAME) != null
				&& !(request.getParameter(RequestConstants.DOCTOR_NAME)
						.equals(""))) {
			doctorName = request.getParameter(RequestConstants.DOCTOR_NAME);
		}
		if (request.getParameter(CHARGE_CODE_ID) != null
				&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
			chargeCodeId = Integer.parseInt(request
					.getParameter(CHARGE_CODE_ID));
			mapForDs.put("chargeCodeId", chargeCodeId);

		}
		logger.info("chargeCodeIdchargeCodeId...."+chargeCodeId);
		if (request.getParameter(SUB_CHARGECODE_ID) != null
				&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
			subGroupId = Integer.parseInt(request
					.getParameter(SUB_CHARGECODE_ID));
			mapForDs.put("subGroupId", subGroupId);
		}
		if (request.getParameter("sampleName") != null
				&& !(request.getParameter("sampleName").equals("0"))) {
			sampleId = Integer.parseInt(request.getParameter("sampleName"));
			mapForDs.put("sampleId", sampleId);
		}
		if (request.getParameterValues("invName") != null
				&& !(request.getParameterValues("invName").length == 0)) {
			String[] invNameId = request.getParameterValues("invName");
			mapForDs.put("invName", invNameId);
		}
		if (request.getParameter(P_FIRST_NAME) != null
				&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
			patientFName = request.getParameter(P_FIRST_NAME);
			mapForDs.put("patientFName", patientFName);
		}
		
		if (request.getParameter(VISIT_NUMBER) != null
				&& !(request.getParameter(VISIT_NUMBER).equals(""))) {
			tokenNo = Integer.parseInt(request.getParameter(VISIT_NUMBER));
			mapForDs.put("tokenNo", tokenNo);
		}
		if (request.getParameter(ORDER_BOOKING_ID) != null
				&& !(request.getParameter(ORDER_BOOKING_ID).equals("0"))) {
			orderId = new Integer(request.getParameter(ORDER_BOOKING_ID));
			mapForDs.put("orderId", orderId);
		}
		String priorityId = "";
		if (request.getParameter("priorityId") != null
				&& !(request.getParameter("priorityId").equals("0"))) {
			priorityId = request.getParameter("priorityId");
			mapForDs.put("priorityId", priorityId);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		mapForDs.put(RequestConstants.DOCTOR_NAME, doctorName);
		mapForDs.put(PATIENT_TYPE, patientType);
		mapForDs.put("deptId", deptId);
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	mapForDs.put(PATIENT_TYPE, patientType);
	mapForDs.put(HOSPITAL_ID, hospitalId);

	detailsMap = labHandlerService.getDetailsForSearch(map);
	patientMap = labHandlerService.getSampleCollectionGrid(mapForDs);
	jsp = "diag_pendingSampleCollection_div";
	map.put("detailsMap", detailsMap);
	map.put("patientMap", patientMap);
	map.put("deptName", deptName);
	map.put("patientType", patientType);
	map.put("contentJsp", jsp);
	map.put("title", title);

	return new ModelAndView(jsp, "map", map);
}
//added by govind 25-04-2017 for EM360 machine data to SDC
public void getResultValueForLabInterFaceMachine(HttpServletRequest request,
		HttpServletResponse response){
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detMap = new HashMap<String, Object>();
	String value="";
	String sampleNo=request.getHeader("sampleNo");
	String parameter=request.getHeader("parameter");
	String measurementValue=request.getHeader("measurementValue");
	String unit=request.getHeader("unit");
	String tdate=request.getHeader("tdate");
	String machineCode=request.getHeader("machineCode");
	String timeStr=request.getHeader("timeStr");
	String hospitalId=request.getHeader("hospitalId");
	detMap.put("sampleNo", sampleNo);
	detMap.put("parameter", parameter);
	detMap.put("measurementValue", measurementValue);
	detMap.put("unit", unit);
	detMap.put("tdate", tdate);
	detMap.put("machineCode", machineCode);
	detMap.put("timeStr", timeStr);
	detMap.put("hospitalId", hospitalId);
	logger.info("sampleNo "+sampleNo +" parameter "+parameter+" measurementValue "+measurementValue+" hospitalId "+hospitalId);
	logger.info("unit "+unit +" date "+tdate+" machineCode "+machineCode);
	map=labHandlerService.addLabInterfaceDataToSDC(detMap);
	value=request.getParameter("dk");
	logger.info("response send successfully");
}

public void LabParameterNameCheck(HttpServletRequest request,
		HttpServletResponse response) {

	Map<String, Object> dataMap = new HashMap<String, Object>();
	List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
	int investigationId = 0;
	boolean status = false;
	String parameterName = null;
	String machineName =null;
	try {
		if (request.getParameter("parameterName") != null) {
			parameterName = request.getParameter("parameterName");
			dataMap.put("parameterName", parameterName);
		}
		if (request.getParameter("machineName") != null) {
			machineName = request.getParameter("machineName");
			dataMap.put("machineName", machineName);
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	status = labHandlerService.LabParameterNameCheck(dataMap);
	
	StringBuffer sb = new StringBuffer();
	try {
		sb.append("<items>");
		sb.append("<item>");
		sb.append("<status>" + status + "</status>");
		sb.append("</item>");
		sb.append("</items>");

	} catch (Exception e) {
		e.printStackTrace();
	}
	response.setContentType("text/xml");
	response.setHeader("Cache-Control", "no-cache");
	try {
		response.getWriter().write(
				"<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<chargeCodes>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</chargeCodes>");

	} catch (Exception e) {
		e.printStackTrace();
	}

}
public void getResultType(HttpServletRequest request,
		HttpServletResponse response) throws IOException{
	String investigationType="";
	int investigationId=Integer.parseInt(request.getParameter("investigationId"));
	investigationType=labHandlerService.getResultType(investigationId);
	PrintWriter out=response.getWriter();
	out.print(investigationType);
	
}


public ModelAndView bookLabForDoctor(HttpServletRequest request,HttpServletResponse response){
	Map<String, Object> map = new HashMap<String, Object>();
	Box box = HMSUtil.getBox(request);
	map=labHandlerService.bookLabForDoctor(box);
	
    return null;
}


public ModelAndView getPendingSampleValidationList(
		HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	Map<String, Object> mapForDs = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Date fromDate = null;
	Date toDate = null;
	String deptName = "";
	String deptType = "";
	int deptId = 0;
	Integer hospitalId = 0;
	int chargeCodeId = 0;
	int departmentId = 0;
	int inpatientId = 0;
	int subGroupId = 0;
	int sampleId = 0;
	int hinId = 0;
	String patientFName = "";
	String hinNo = "";
	String adNo = "";
	String flag = "";
	String pType = "";
	String reason = "";
	String wardName = "";
	String mobileNo = "";
	String barcodetext="";
	
	int subChargeCodeId = 0; 
	int userId = 0;  // added by amit das on 17-07-2017
	
	if (session.getAttribute("deptName") != null) {
		deptName = (String) session.getAttribute("deptName");
	}
	if (session.getAttribute("deptType") != null) {
		deptType = (String) session.getAttribute("deptType");
	}
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
	}
	if (session.getAttribute(HOSPITAL_ID) != null) {
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}
	// added by amit das on 17-07-2017
	if (session.getAttribute("userId") != null) {
		userId = (int) session.getAttribute("userId");
	}
	
	
	
	// added by amit das on 17-07-2017
		if (request.getParameter("subChargeCodeId") != null) {
			subChargeCodeId =  Integer.parseInt(request.getParameter("subChargeCodeId"));
		}
	
	
		if (request.getParameter(INPATIENT_ID) != null
				&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
			inpatientId = Integer.parseInt(request
					.getParameter(INPATIENT_ID));
			mapForDs.put("inpatientId", inpatientId);
		}
		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
			mapForDs.put("fromDate", fromDate);
		}
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
			mapForDs.put("toDate", toDate);
		}
		if (request.getParameter(PATIENT_TYPE) != null
				&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
			pType = request.getParameter(PATIENT_TYPE);
			mapForDs.put("pType", pType);
		}
		if (request.getParameter(CHARGE_CODE_ID) != null
				&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
			chargeCodeId = Integer.parseInt(request
					.getParameter(CHARGE_CODE_ID));
			mapForDs.put("chargeCodeId", chargeCodeId);
		}
		if (request.getParameter(SUB_CHARGECODE_ID) != null
				&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
			subGroupId = Integer.parseInt(request
					.getParameter(SUB_CHARGECODE_ID));
			mapForDs.put("subGroupId", subGroupId);
		}
		if (request.getParameter("sampleName") != null &&
				  !(request.getParameter("sampleName").equals("0"))) {
			  	sampleId =   Integer.parseInt(request.getParameter("sampleName"));
			  	mapForDs.put("sampleId", sampleId); 
		  }
		  
		  if (request.getParameterValues("invName") != null &&
				  !(request.getParameterValues("invName").length==0)) {
			  String[]  invNameId =   request.getParameterValues("invName");
			  mapForDs.put("invName", invNameId); 
		  }
		
		if (request.getParameter(P_FIRST_NAME) != null
				&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
			patientFName = request.getParameter(P_FIRST_NAME);
			mapForDs.put("patientFName", patientFName);
		}
		if (request.getParameter(AD_NO) != null
				&& !(request.getParameter(AD_NO).equals(""))) {
			adNo = request.getParameter(AD_NO);
			mapForDs.put("adNo", adNo);
		}
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals("0"))) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			mapForDs.put("hinId", hinId);
		}
		if (request.getParameter(REASON) != null
				&& !(request.getParameter(REASON).equals(""))) {
			reason = request.getParameter(REASON);
			mapForDs.put("reason", reason);
		}
		if (request.getParameter(RequestConstants.WARD_NAME) != null
				&& !(request.getParameter(RequestConstants.WARD_NAME)
						.equals(""))) {
			wardName = request.getParameter(RequestConstants.WARD_NAME);
			mapForDs.put(RequestConstants.WARD_NAME, wardName);
		}
		if (request.getParameter(RequestConstants.MOBILE_NO) != null
				&& !(request.getParameter(RequestConstants.MOBILE_NO)
						.equals(""))) {
			mobileNo = request.getParameter(RequestConstants.MOBILE_NO);
			mapForDs.put(RequestConstants.MOBILE_NO, mobileNo);
		}

		if (request.getParameter("barcodetext") != null
				&& !(request.getParameter("barcodetext")
						.equals(""))) {
			barcodetext =request.getParameter("barcodetext").trim();
			mapForDs.put("barcodetext", barcodetext);
		}
	
		String priorityId="";
		if (request.getParameter("priorityId") != null
				&& !(request.getParameter("priorityId").equals("0"))) {
			priorityId = request.getParameter("priorityId");
			mapForDs.put("priorityId", priorityId);
		}
	mapForDs.put(HOSPITAL_ID, hospitalId);
	mapForDs.put("deptId", deptId);
	mapForDs.put("hospitalId",hospitalId);
	mapForDs.put("userId",userId); // added by amit das on 17-07-2017
	mapForDs.put("hospitalId",hospitalId);
	mapForDs.put("subChargeCodeId",subChargeCodeId); // added by amit das on 17-07-2017
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	int labDepartmentId = Integer.parseInt(properties.getProperty("labDepartmentId"));
	int radiologyDepartmentId = Integer.parseInt(properties.getProperty("radiologyDepartmentId"));
	
	if(radiologyDepartmentId == deptId){
		patientMap = labHandlerService.getSampleValidationGridRadiology(mapForDs);
	jsp = "responseFordiag_pendingSampleValidation";
	}
	 
	if(labDepartmentId == deptId){
		map.put("hinNo", "");
		map.put("pFirstName", "");	
		patientMap = labHandlerService.getSampleValidationGrid(mapForDs);
	jsp = "responseFordiag_pendingSampleValidationLab";
	}
	
	detailsMap.put("userId",userId); // added by amit das on 17-07-2017
	
	map.put("deptId", deptId);
	map.put("deptName", deptName);
	map.put("deptType", deptType);
	map.put("patientMap", patientMap);
	map.put("detailsMap", detailsMap);
	//map.put("contentJsp", jsp);
	return new ModelAndView(jsp, "map", map);
} 

// added by amit das on 31-08-2017
public ModelAndView submitSampleCollectionForOutSideLab(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> parameterMap = new HashMap<String, Object>();
	Box box = HMSUtil.getBox(request);
	boolean saved = false;
	int hospitalId = 0;
	String hinNo = null;
	String patientType = null;
	int dgSampleCollectionDetailsId = 0;
	
	HttpSession session = request.getSession();

	if (session.getAttribute(HOSPITAL_ID) != null) {
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		parameterMap.put("hospitalId", hospitalId);
	}
		
	parameterMap.put("box", box);
	
	map = labHandlerService.submitSampleCollectionForOutSideLab(parameterMap);
	
	saved = (Boolean) map.get("saved");
	
	if(map!=null && map.get("hinNo")!=null)
		hinNo = (String)map.get("hinNo");

	if(map!=null && map.get("patientType")!=null)
		patientType = (String)map.get("patientType");
	

	if(map!=null && map.get("dgSampleCollectionDetailsId")!=null)
		dgSampleCollectionDetailsId = (Integer)map.get("dgSampleCollectionDetailsId");
	
	return new ModelAndView("redirect:/hms/investigation?method=searchPatientForLab&dgSampleDetailsId="+dgSampleCollectionDetailsId);
}

public ModelAndView showExistingOpOrderBookingJsp(HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	Box box = HMSUtil.getBox(request);
	HttpSession session = request.getSession();
	String deptName = "";
	String deptType = "";
	String billingScreen = null;
	int visitNo = 0;
	int visitId = 0;
	int hospitalId=0;
	int deptId =0;
	
	int pharmacyLabQueueId=0;
	
	if(session.getAttribute("deptId")!=null){
		deptId = (Integer)session.getAttribute("deptId");
		//mapDetails.put("deptId",deptId);
	}
	if (session.getAttribute("deptName") != null) {
		deptName = (String) session.getAttribute("deptName");
	}
	if (session.getAttribute(HOSPITAL_ID) != null) {
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
	}

	if (session.getAttribute("deptType") != null) {
		deptType = (String) session.getAttribute("deptType");
	}

	if (request.getParameter("orderId") != null) {
		int  orderId =Integer.parseInt(request.getParameter("orderId"));
		box.put("orderId", orderId);
	}
	
	if (request.getParameter("hinNo") != null) {
		String  hinNo =request.getParameter("hinNo");
		box.put("hinNo", hinNo);
	}
	map = labHandlerService.showExistingOpOrderBookingJsp(box);
	dataMap.put("deptType", deptType);
	dataMap.put("deptId",deptId);
	detailsMap = labHandlerService.getMainAndSubChargeForLab(dataMap);
	jsp ="diag_OrderBookingForExistingPatient.jsp";
	map.put("deptName", deptName);
	//map.put("includedJsp", includedJsp);
	map.put("deptId", deptId);
	map.put("detailsMap", detailsMap);
	//map.put("pharmacyLabQueueId", pharmacyLabQueueId);
	map.put("message", message);
	map.put("contentJsp", jsp);
	map.put("billingScreen", billingScreen);	//added by amit das on 11-05-2017
	map.put("title", title);
	return new ModelAndView("index", "map", map);
} 



	public void checkDuplicateInvestigation(HttpServletRequest request,HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		HttpSession session = request.getSession();
		
		if (session.getAttribute("hospitalId") != null){
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null){
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		// --------------------------------------------------------------------------------
		
		Box box = HMSUtil.getBox(request);
		int chargeCodeId = 0;
		int orderId = 0;
		if (request.getParameter("chargeCodeId") != null) {
			chargeCodeId =Integer.parseInt((request.getParameter("chargeCodeId")));
			box.put("chargeCodeId", chargeCodeId);
		}
		if (request.getParameter("orderId") != null) {
			orderId =Integer.parseInt((request.getParameter("orderId")));
			box.put("orderId", orderId);
		}
		
		map = labHandlerService.checkDuplicateInvestigation(box);
		List<DgOrderdt>existingDgOrderDtList = new ArrayList<DgOrderdt>();
		if (map.get("existingDgOrderDtList") != null) {
			existingDgOrderDtList = (List) map.get("existingDgOrderDtList");
		}

		StringBuffer sb = new StringBuffer();
		try {
			
			sb.append("<item>");
		
			/*for (MasStoreItem masStoreItem : itemList) {
				
				sb.append("<id>" + masStoreItem.getId() + "</id>");
				sb.append("<pvms>" + masStoreItem.getPvmsNo() + "</pvms>");
				sb.append("<au>"
						+ masStoreItem.getItemConversion().getPurchaseUnit()
								.getUnitName() + "</au>");*/

				
			if(existingDgOrderDtList.size()>0){
				/*sb.append("<batchs>");
				for (Object[] batch : batchList) {
					sb.append("<batch>");
					sb.append("<batchId>" + batch[2] + "</batchId>");
					sb.append("<batchName>" + batch[1]
							+ "</batchName>");
					sb.append("</batch>");
				}
				sb.append("</batchs>");

			}else{*/
				
				sb.append("<msg>" + "Investigation Already Added." + "</msg>");
			}

		//}
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
		
	public ModelAndView submitOrderBookingForExistingInvestigation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		int chargeListLength = 0;

		List chargeList = new ArrayList();
		List qtyList = new ArrayList();
		List amountList = new ArrayList();
		List mainChargeList = new ArrayList();
		List subChargeList = new ArrayList();
		List sampleDetailIdList = new ArrayList();
		List orderDetailIdList = new ArrayList();
		List deptCodeList = new ArrayList();
		List deptIdList = new ArrayList();
		
		Box box = HMSUtil.getBox(request);
		String userName = (String) session.getAttribute("userName");
		Integer userId = (Integer) session.getAttribute("userId");
		Users users = (Users) session.getAttribute(RequestConstants.USERS);
		BigDecimal totalCost = new BigDecimal(0);
		String date = "";
		String time = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		String clinicalNote = "";
		String orderSeqNo = "";
		String orderStatus = "";
		String testType = "";
		String routineUrgent = "";
		String urgentDetails = "";
		int hospitalId = 0;
		int placedBy = 0;
		int pharmacyLabQueueId=0;
		int dgOrderHdId = 0;
		String billingScreen = null;
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			infoMap.put("hospitalId", hospitalId);
		}
		int departmentId = (Integer) session.getAttribute("deptId");
		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);
		
		
		if(request.getParameter("dgOrderHdId")!=null){
			dgOrderHdId = Integer.parseInt(request.getParameter("dgOrderHdId"));
		}
		
/*		DgOrderhd dgOrderhd = new DgOrderhd();
		dgOrderhd.setHospital(hospital);
*/		Patient patient = new Patient();
		Visit visit = new Visit();

		if (request.getParameter(HIN_ID) != null) {
			patient.setId(Integer.parseInt(request.getParameter(HIN_ID)));
	//		dgOrderhd.setHin(patient);
			infoMap.put("hinId", Integer.parseInt(request.getParameter(HIN_ID)));
		}
		/*if (request.getParameter(VISIT_ID) != null) {
			visit.setId(Integer.parseInt(request.getParameter(VISIT_ID)));
			dgOrderhd.setVisit(visit);
		}
		if (null !=request.getParameter(EMPLOYEE_ID) && !request.getParameter(EMPLOYEE_ID).equals("0")) {
			placedBy = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(TEST_TYPE) != null
				&& !(request.getParameter(TEST_TYPE).equals(""))) {
			testType = request.getParameter(TEST_TYPE);
		}
		if (request.getParameter(CLINICAL_NOTE) != null
				&& !(request.getParameter(CLINICAL_NOTE).equals(""))) {
			clinicalNote = request.getParameter(CLINICAL_NOTE);
		}
		if (request.getParameter(ORDER_STATUS) != null
				&& !(request.getParameter(ORDER_STATUS).equals(""))) {
			orderStatus = request.getParameter(ORDER_STATUS);
		}

		if (request.getParameter(ROUTINE) != null
				&& !(request.getParameter(ROUTINE).equals(""))) {
			routineUrgent = request.getParameter(ROUTINE);
		}

		if (request.getParameter(URGENT_DETAILS) != null
				&& !(request.getParameter(URGENT_DETAILS).equals(""))) {
			urgentDetails = request.getParameter(URGENT_DETAILS);
		}
		if (request.getParameter(ORDER_NO) != null) {
			orderSeqNo = request.getParameter(ORDER_NO);
		}
		if (request.getParameter(TOTAL_AMOUNT) != null) {
			totalCost = new BigDecimal(request.getParameter(TOTAL_AMOUNT));
		}
		if (request.getParameter("pharmacyLabQueueId") != null) {
			pharmacyLabQueueId = Integer.parseInt(request.getParameter("pharmacyLabQueueId"));
			infoMap.put("pharmacyLabQueueId", pharmacyLabQueueId);
		}
		if (request.getParameter(INPATIENT_ID) != null) {
			Inpatient inpat=new Inpatient();
			if(Integer.parseInt(request.getParameter(INPATIENT_ID))>0){
			inpat.setId(Integer.parseInt(request.getParameter(INPATIENT_ID)));
			dgOrderhd.setInpatient(inpat);
			}
		}*/
		
		billingScreen = request.getParameter("billingScreen"); // added by amit das on 11-05-2017
		/*
		if (placedBy != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(placedBy);
			dgOrderhd.setPrescribedBy(masEmployee);
		}
		if (departmentId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			dgOrderhd.setDepartment(masDepartment);
		}
		String patientType="";
		if(request.getParameter("patientType")!=null){
			patientType=request.getParameter("patientType");
		}
		String temp = labHandlerService.generateOrderNumber();
		dgOrderhd.setOrderNo(orderSeqNo);
		dgOrderhd.setTestType(testType);
		dgOrderhd.setNetAmount(totalCost);
		dgOrderhd.setOrderStatus(orderStatus);
		dgOrderhd.setClinicalNote(clinicalNote);
		dgOrderhd.setOrderDate(HMSUtil.convertStringTypeDateToDateType(date));
		dgOrderhd.setOrderTime(time);
		if(patientType.equals("OP")){
			dgOrderhd.setPatientType("OP");
		}if(patientType.equals("IP")){
			dgOrderhd.setPatientType("IP");
		}
		dgOrderhd.setOrderStatus("P");
		
		 * Users users = new Users(); users.setId(userId);
		 
		dgOrderhd.setLastChgBy(users);
		dgOrderhd.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
		dgOrderhd.setLastChgTime(time);
		dgOrderhd.setRoutineUrgentStatus(routineUrgent);
		dgOrderhd.setUrgentRemarks(urgentDetails);
		infoMap.put("dgOrderhd", dgOrderhd);*/
		infoMap.put("dgOrderHdId", dgOrderHdId);

		if (request.getParameter("hiddenValueCharge") != null) {
			chargeListLength = Integer.parseInt(request
					.getParameter("hiddenValueCharge"));
		}
		//int i = 1;
		for (int i = 1; i <= chargeListLength; i++) {
			if (request.getParameter(CHARGE_CODE_ID + i) != null
					&& !request.getParameter(CHARGE_CODE_ID + i).equals("")) {
				chargeList.add(request.getParameter(CHARGE_CODE_ID + i));

			}
			if (request.getParameter(QUANTITY + i) != null
					&& !request.getParameter(QUANTITY + i).equals("")) {
				qtyList.add(request.getParameter(QUANTITY + i));
			} else {
				qtyList.add("1");
			}
			if (request.getParameter(AMOUNT + i) != null
					&& !request.getParameter(AMOUNT + i).equals("")) {
				amountList.add(request.getParameter(AMOUNT + i));
			} else {
				amountList.add("");
			}
			if (request.getParameter(MAIN_CHARGECODE_ID + i) != null) {
				mainChargeList
						.add(request.getParameter(MAIN_CHARGECODE_ID + i));
			} else {
				mainChargeList.add("");
			}
			
			if (request.getParameter(SUB_CHARGECODE_ID + i) != null) {
				subChargeList.add(request.getParameter(SUB_CHARGECODE_ID + i));
			} else {
				subChargeList.add("");
			}
			if (request.getParameter(SAMPLE_COLLECTION_DETAIL_ID + i) != null) {
				sampleDetailIdList.add(request
						.getParameter(SAMPLE_COLLECTION_DETAIL_ID + i));
			} else {
				sampleDetailIdList.add("");
			}
			if (request.getParameter(DG_ORDER_DETAIL_ID + i) != null) {
				orderDetailIdList.add(request.getParameter(DG_ORDER_DETAIL_ID
						+ i));
			} else {
				orderDetailIdList.add("");
			}
			if (request.getParameter(DEPARTMENT_TYPE_CODE + i) != null
					&& !request.getParameter(DEPARTMENT_TYPE_CODE + i).equals(
							"")) {
				deptCodeList
						.add(request.getParameter(DEPARTMENT_TYPE_CODE + i));
			} else {
				deptCodeList.add("");
			}
			if (request.getParameter(DEPARTMENT_ID + i) != null
					&& !request.getParameter(DEPARTMENT_ID + i).equals("0")) {
				deptIdList.add(request.getParameter(DEPARTMENT_ID + i));
			} else {
				deptIdList.add("");
			}
			//i++;
		}
		int visitId=0;
		if(request.getParameter("visitId")!=null){
			visitId=Integer.parseInt(request.getParameter("visitId"));
		}
		
		infoMap.put("visitId", visitId);
		infoMap.put("orderSeqNo", orderSeqNo);
		infoMap.put("sampleDetailIdList", sampleDetailIdList);
		infoMap.put("userName", userName);
		infoMap.put("userId", userId);
		infoMap.put("chargeList", chargeList);
		infoMap.put("mainChargeList", mainChargeList);
		infoMap.put("subChargeList", subChargeList);
		infoMap.put("qtyList", qtyList);
		infoMap.put("amountList", amountList);
		infoMap.put("orderDetailIdList", orderDetailIdList);
		infoMap.put("deptCodeList", deptCodeList);
		infoMap.put("deptIdList", deptIdList);
		infoMap.put(RequestConstants.USERS, users);

		boolean saved = false;
		String message = "";
		map = labHandlerService.submitOrderBookingForExistingInvestigation(box,
				infoMap);
		
		if(map.get("saved")!=null)
			saved = (boolean)map.get("saved");
		
		if(map.get("dgOrderHdId")!=null)
			dgOrderHdId = (int)map.get("dgOrderHdId");
		
		String adNo="",uHid="";
		if(map.get("adNo")!=null){
			adNo = (String)map.get("adNo");
		}
		if(map.get("uHid")!=null){
			uHid = (String)map.get("uHid");
		}
		
		if (saved) {
			message = "Order Booking has been done Successfully !!Do you want to print ? ";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);

		String jsp = DG_MSG_FOR_LAB + ".jsp";
		map.put("orderDetailsFlag", request.getParameter("orderDetailsFlag")!=null?request.getParameter("orderDetailsFlag"):"");
		map.put("contentJsp", jsp);
		map.put("orderSeqNo", orderSeqNo);
		map.put("dgOrderHdId", dgOrderHdId);
		
//		map.put("patientType", patientType);
	   if (request.getParameter(HIN_ID) != null) {
		map.put("orderId", Integer.parseInt(request.getParameter(HIN_ID)));
	   }
		if (request.getParameter(VISIT_ID) != null) {
		map.put("visitId", Integer.parseInt(request.getParameter(VISIT_ID)));
		}
		map.put("billingScreen", billingScreen); // added by amit das on 11-05-2017
		map.put("adNo", adNo);
		map.put("uHid", uHid);
		return new ModelAndView("index", "map", map);
		
	}

	
	public void saveSampleCollectionToLeanCentralServer(HttpServletRequest request,
			HttpServletResponse response){
		String result = null;
		Box box=HMSUtil.getBox(request);
		result = labHandlerService.saveSampleCollectionToLeanCentralServer(box);
		
		try{
			PrintWriter printWriter = response.getWriter();
			printWriter.write(result);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public ModelAndView saveMachineParamId(HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		String machineParamId = null;
		String result = null;
		if(request.getParameter("machineParamId")!=null) {
			machineParamId=(String)request.getParameter("machineParamId");
		}
		session = request.getSession();
		session.setAttribute("machineParamId", machineParamId);
		String jsp="machineInvestigationInfo.jsp";
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showLabInvestigationTracker(HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Box box=HMSUtil.getBox(request);
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String deptName = "";
		String hinNo="";
		String adNo="";
		String patientType="";
		int userId = 0;
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		 session = request.getSession();
		if(null !=request.getParameter("hinNo") && !request.getParameter("hinNo").equals("") ){
			 hinNo= request.getParameter("hinNo");
			 
		 }
		 if(null !=request.getParameter("adNo") && !request.getParameter("adNo").equals("") ){
			 adNo= request.getParameter("adNo");
			 
		 }

		String pFirstName="";  
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if(null !=request.getParameter("pFirstName") && !request.getParameter("pFirstName").equals("") ){
			pFirstName= request.getParameter("pFirstName");
		 }
		
		if(null !=request.getParameter("patientType") && !request.getParameter("patientType").equals("") ){
			patientType= request.getParameter("patientType");
		 }
		 
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		box.put("patientType", patientType);
		
		if (session.getAttribute("userId") != null) {
			userId = (int) session.getAttribute("userId");
		}
		
		logger.info("deptId "+deptId+" hospitalId "+hospitalId);
		map = labHandlerService.getLabInvestigationTracker(box);
		map.put("patientType", patientType);
		String jsp="labInvestigationTracker.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
}
