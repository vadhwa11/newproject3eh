/**
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * OpBillingConroller.java
 * Purpose of the class - This is for OP Billing.
 * @author  Ritu Sahu
 * Create Date: 12th Jan,2009
 * Revision Date:
 * Revision By: Purpose
 * @version 1.0
 **/

package jkt.hms.billing.controller;

import static jkt.hms.util.RequestConstants.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.account.handler.AccountHandlerService;
import jkt.hms.billing.handler.BillingHandlerService;
import jkt.hms.billing.handler.OpBillingHandlerService;
import jkt.hms.lab.handler.LabHandlerService;
import jkt.hms.masters.business.BlChargeSlipMain;
import jkt.hms.masters.business.BlDispensingHeader;
import jkt.hms.masters.business.BlOpBillHeader;
import jkt.hms.masters.business.BlPaymentAdviceHeader;
import jkt.hms.masters.business.BlPymntAdviceDispHeader;
import jkt.hms.masters.business.BlReceiptHeader;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.IpWardConsumptionDetails;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasCaseType;
import jkt.hms.masters.business.MasCompany;
import jkt.hms.masters.business.MasComplaint;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDiscount;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasScheme;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasVillage;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.hibernate.criterion.Restrictions;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class OpBillingController extends MultiActionController {

	OpBillingHandlerService opBillingHandlerService = null;
	LabHandlerService labHandlerService = null;
	AccountHandlerService accountHandlerService = null;
	BillingHandlerService billingHandlerService = null;
	int tokenNo=0;
	
	/*
	 * Search Bill Servicing;;;;;
	 * 
	 */
	
	
	//searchAdviceSerciving for billPaymentAdviceSearchForServercing
	
	public ModelAndView searchAdviceSerciving(HttpServletRequest request,
			HttpServletResponse response) {
	
		Map<String, Object> map1 = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		
		int sessionHospitalId = 0;
		sessionHospitalId = (Integer)session.getAttribute("hospitalId");
		
		Box box = HMSUtil.getBox(request);
		
		box.put("sessionHospitalId",sessionHospitalId);
		map1= opBillingHandlerService.searchAdviceSerciving(box);
		
		String jsp = "billPaymentAdviceSearchForServercing" + ".jsp";
		map1.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map1);
	}
	
	public void getBillNosByUhid(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> billList = new ArrayList<Object[]>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		
		Box box = HMSUtil.getBox(request);
		if(box!=null){
		map= opBillingHandlerService.getBillNosByUhid(box);
		}
		billList=(List<Object[]>)map.get("billList");
		StringBuffer sb=new StringBuffer();
		sb.append("<item>");
		sb.append("<bills>");
		for (Object[] obj : billList) {
			
			sb.append("<bill>");
			sb.append("<BillId>" +obj[0]+ "</BillId>");
			sb.append("<BillNos>" + obj[1]+ "</BillNos>");
			sb.append("</bill>");
		}
		sb.append("</bills>");
		sb.append("</item>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(
				"<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");	
	}
	
/*	public ModelAndView showOPBillServecing(HttpServletRequest request,
			HttpServletResponse response) {
	
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int sessionHospitalId = 0;
		sessionHospitalId = (Integer)session.getAttribute("hospitalId");
		
		
		Box box = HMSUtil.getBox(request);
		box.put("sessionHospitalId",sessionHospitalId);
		map= opBillingHandlerService.searchOPBillServicing(box);
		
		String jsp = BILL_SERVICING_SEARCH_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}*/
	public ModelAndView showBillServicingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		Box box=HMSUtil.getBox(request);
		box.put(HOSPITAL_ID, hospitalId);
		map = opBillingHandlerService.getReferedPatient(box);
		String jsp = BILL_SERVICING_SEARCH_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	/**
	 * Method to Show Billing Servicing Jsp
	 *
	 */
	/*public ModelAndView showBillServicingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		
		
		Map<String, Object> map = new HashMap<String, Object>();

		map= opBillingHandlerService.showBillServicingJsp(map);
		
		String jsp = BILL_SERVICING_SEARCH_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}*/
/*
 * ShowBillDispensing
 * */
	
	public ModelAndView getOrderNoTempBillNoForBilling(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		String hin = "";
		hin = box.getString(HIN_NO);
		map = opBillingHandlerService.getOrderNoTempBillNoForBilling(hin);
		String jsp = "";
		jsp = BILLING_RESPONSE_FOR_ORDER_TEMP_BILL_NO_JSP;
		return new ModelAndView(jsp, "map", map);
	}

	/**
	 * Method to get patient details for Billing Servicing
	 *
	 */
	public ModelAndView getPatientDetailsForOpBilling(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		HttpSession  session=request.getSession();
		String hinNo = "";
		String orderNo = "";
		String tempBillNo = "";
		int orderId=0;
		/*if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			parameterMap.put("hinNo", hinNo);
			System.out.println("hinNo  "+hinNo);
		}*/
		if (request.getParameter("orderId") != null && !request.getParameter("orderId").trim().equals("")) {
			orderId = Integer.parseInt(request.getParameter("orderId"));
			parameterMap.put("orderId", orderId);
		}
		/*if (request.getParameter("tempBillNo") != null) {
			tempBillNo = request.getParameter("tempBillNo");
			parameterMap.put("tempBillNo", tempBillNo);
		}*/
		
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		
		String registered = request.getParameter("registered");
		parameterMap.put(HOSPITAL_ID, hospitalId);
		String billService = "lab";
		if(request.getParameter("billType")!=null && !request.getParameter("billType").equals("")){
			billService = request.getParameter("billType");
			parameterMap.put("billService", billService);	
		}

		map = opBillingHandlerService
				.getPatientDetailsForOpBilling(parameterMap);
		map.put("registered", registered);
		
		
		String jsp = "";
		
		if ((registered.equals("yes") && map.get("patientList") != null)
				|| registered.equals("no")) {
		/*	if (!orderNo.equals("")) {
				if (map.get("orderHdList") != null) {
					jsp = BILL_SERVICING_JSP + ".jsp";
				} else {
					String msg = "No Record Found.";
					map.put("msg", msg);
					jsp = BILL_SERVICING_SEARCH_JSP + ".jsp";
				}
			} 		
			else {*/
				if(billService.equalsIgnoreCase("lab"))
					jsp = BILL_SERVICING_JSP + ".jsp";
				else
					jsp = "billServicingProcedure.jsp";
			//}
			map.put("orderNo", orderNo);
		} else {
			String msg = "No Record Found.";
			map.put("message", msg);
			jsp = BILL_SERVICING_SEARCH_JSP + ".jsp";
		}
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

/*	public ModelAndView getPatientDetailsForOpBilling(
			HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		String uhid=request.getParameter("uhid");
		System.out.println("uhid>>>>>>>>"+uhid);
	
		Box box = HMSUtil.getBox(request);
		map = opBillingHandlerService
				.getPatientDetailsForOpBilling(box);
	
		String jsp = "";
		
		jsp = BILL_SERVICING_JSP + ".jsp";
				
			
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}*/

	/**
	 * Method to get Charge Code for Auto complete in Billing Servicing
	 *
	 */
	public ModelAndView getChargeCodeForAutoComplete(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		int subChargeCodeId = 0;
		int mainChargeCodeId = 0;
		String nameField = "";
		String autoHint = "";
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

		parameterMap.put("subChargeCodeId", subChargeCodeId);
		parameterMap.put("mainChargeCodeId", mainChargeCodeId);
		parameterMap.put("autoHint", autoHint);

		map = opBillingHandlerService
				.getChargeCodeForAutoComplete(parameterMap);

		String jsp = "";
		jsp = BILLING_RESPONSE_FOR_CHARGE_CODE_GRID_JSP;

		return new ModelAndView(jsp, "map", map);
	}

	/**
	 * Method to get Charge Code details for Billing Servicing
	 *
	 */
	public ModelAndView fillChargeCode(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession(); 
		Map<String, Object> map = new HashMap<String, Object>();
		String rowVal = request.getParameter("rowVal");
		int hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		int hinId = 0;
		int schemeId=0;
		String chargeDiscription = "";
		if (request.getParameter("hin") != null) {
			hinId = Integer.parseInt(request.getParameter("hin"));
		}
		if (request.getParameter("schemeList") != null) {
			schemeId = Integer.parseInt(request.getParameter("schemeList"));
		}
		if (request.getParameter("charge" + rowVal) != null) {
			chargeDiscription = request.getParameter("charge" + rowVal);
		}
		//commented & added by govind 20-07-2017
		/*Integer index1 = 0;
		index1 = chargeDiscription.lastIndexOf("[") + 1;
		int index2 = chargeDiscription.lastIndexOf("]");
		String chargeCode = chargeDiscription.substring(index1, index2);
		map = opBillingHandlerService.getChargeCodeDetails(chargeCode, hinId,schemeId,hospitalId);	
        */
		int index1 = chargeDiscription.lastIndexOf("[");
		String chargeCodeName = chargeDiscription.substring(0, index1);
		map = opBillingHandlerService.getChargeCodeDetails(chargeCodeName, hinId,schemeId,hospitalId);
		//commented & added by govind 20-07-2017 end
		String jsp = "";
		jsp = BILLING_RESPONSE_FOR_CHARGE_CODE_DETAIL_JSP;

		map.put("rowVal", rowVal);
		map.put("contentJsp", jsp);
		map.put("type", request.getParameter("type"));
		return new ModelAndView(jsp, "map", map);

	}

	/**
	 * Method to save Details of Billing Servicing
	 *
	 */

	@SuppressWarnings("unchecked")
	public  ModelAndView submitBillServicingDetails(HttpServletRequest request,
			HttpServletResponse response) {
		 String remarks="";
		 if(request.getParameter("remarks")!=null){
			 remarks=request.getParameter("remarks");
		 }
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int chargeListLength = 0;
		int payListLength = 0;
		String discount = "";
		String proportionalDiscount = "";
		String hinNo="";
		int visitNo=0;
		int deptId=0;
		List chargeList = new ArrayList();
		List qtyList = new ArrayList();
		List rateList = new ArrayList();
		List standardDeductionList = new ArrayList();
		List amountList = new ArrayList();
		List discountList = new ArrayList();
		List disPercentList = new ArrayList();
		List proportionalDiscountList = new ArrayList();
		List netAmountList = new ArrayList();
		List mainChargeList = new ArrayList();
		List subChargeList = new ArrayList();
		List orderDetailIdList = new ArrayList();
		List accountIdList = new ArrayList();
		List subAccountIdList = new ArrayList();
		List deptCodeList = new ArrayList();
		List deptIdList = new ArrayList();
		List prcDtIdList = new ArrayList();
		List surgeryDtIdList = new ArrayList();
		
		
		List payModeList = new ArrayList();
		List amtReceivedList = new ArrayList();
		List chqNoList = new ArrayList();
		List chqDateList = new ArrayList();
		List bankNameList = new ArrayList();
		String orderNo = "";
		int orderId = 0;
		int visitIdNew=0;
		String flag="";
		String uhid="";
		
		String userName = (String) session.getAttribute("userName");
		if(session.getAttribute("deptId")!=null){
			deptId=(Integer)session.getAttribute("deptId");
		}
		//
		int hospitalId = 0;
		int departmentId = 0;
		Users user = new Users();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			dataMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");
			dataMap.put("userId", user.getId());
		}
		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);

		BlOpBillHeader opBillHeader = new BlOpBillHeader();
		opBillHeader.setRemarks(remarks);
		opBillHeader.setHospital(hospital);
		Patient patient = new Patient();
		Visit visit = new Visit();

		if (request.getParameter(HIN_ID) != null) {
			patient.setId(Integer.parseInt(request.getParameter(HIN_ID)));
			opBillHeader.setHin(patient);
			dataMap.put("hinId", Integer.parseInt(request.getParameter(HIN_ID)));
			opBillHeader.setPatientStatus("r");
		} else {
			opBillHeader.setPatientStatus("u");
		}
		if (request.getParameter(HIN_NO) != null) {
			opBillHeader.setHinNo(request.getParameter(HIN_NO));
			hinNo=request.getParameter(HIN_NO);
		}
		if (request.getParameter("paymentMethod") != null) {
			 flag=request.getParameter("paymentMethod");
			dataMap.put("flag", flag);
			System.out.println("flag"+flag);
		}
		
		if (request.getParameter(VISIT_ID) != null) {
			visit.setId(Integer.parseInt(request.getParameter(VISIT_ID)));
			opBillHeader.setVisit(visit);
		}
		if (request.getParameter(TOKEN_NO) != null && !request.getParameter(TOKEN_NO).equalsIgnoreCase("")) {
			opBillHeader.setTokenNo(Integer.parseInt(request.getParameter(TOKEN_NO)));
		}
		if (request.getParameter(RELATIVE_NAME) != null) {
			opBillHeader.setRelativeName(request.getParameter(RELATIVE_NAME));
		}
		if (request.getParameter(REGISTRATION_TYPE) != null) {
			opBillHeader.setRegType(request.getParameter(REGISTRATION_TYPE));
		}
		
		if (request.getParameter("visitIdNew") != null &&  !request.getParameter("visitIdNew").equalsIgnoreCase("") &&  !request.getParameter("visitIdNew").equalsIgnoreCase("0")) {
			visitIdNew=Integer.parseInt(request.getParameter("visitIdNew"));
		}
		
		if (request.getParameter("patientUhid") != null) {
			uhid=request.getParameter("patientUhid");
		}
		//
		if (request.getParameter(EMPLOYEE_ID) != null
				&& !(request.getParameter(EMPLOYEE_ID).equals("0")) &&  !request.getParameter(EMPLOYEE_ID).equalsIgnoreCase("")) {
			int empId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			MasEmployee employee = new MasEmployee();
			employee.setId(empId);
			opBillHeader.setConsultant(employee);
		}
		if (request.getParameter("compDiscount") != null
				&& !request.getParameter("compDiscount").equals("")) {
			opBillHeader.setDiscount(new BigDecimal(request
					.getParameter("compDiscount")));
		}
		if (request.getParameter("charity") != null
				&& !request.getParameter("charity").equals("")) {
			opBillHeader.setCharity(new BigDecimal(request
					.getParameter("charity")));
		}
		if (request.getParameter(PATIENT_TYPE_ID) != null
				&& !(request.getParameter(PATIENT_TYPE_ID).equals("0")) && !(request.getParameter(PATIENT_TYPE_ID).equals(""))) {
			MasPatientType patientType = new MasPatientType();
			patientType.setId(Integer.parseInt(request
					.getParameter(PATIENT_TYPE_ID)));
			opBillHeader.setPatientType(patientType);
		}
		if (request.getParameter("companyId") != null
				&& !(request.getParameter("companyId").equals("0")) && !(request.getParameter("companyId").equals("0"))) {
			MasCompany company = new MasCompany();
			company.setId(Integer.parseInt(request.getParameter("companyId")));
			opBillHeader.setCompany(company);
		}
		
		// Added By Amit Das on 03-03-2016
		if (request.getParameter("authorizerIdForScheme") != null
				&& !(request.getParameter("authorizerIdForScheme").equals("0"))) {
			MasAuthorizer schemeAuthorizer = new MasAuthorizer();
			schemeAuthorizer.setId(Integer.parseInt(request.getParameter("authorizerIdForScheme")));
			opBillHeader.setSchemeAuthorizer(schemeAuthorizer);
		}
		
		
		if (request.getParameter(ORDER_NO) != null) {
			orderNo = request.getParameter(ORDER_NO);
			dataMap.put("orderNo", orderNo);
		}
		if (request.getParameter(ORDER_BOOKING_ID) != null && !request.getParameter(ORDER_BOOKING_ID) .equals("")) {
			orderId = Integer.parseInt(request.getParameter(ORDER_BOOKING_ID));
			dataMap.put("orderId", orderId);
		}
		/**
		 * For Procedure Billing
		 */
		int procHdId = 0;
		if (request.getParameter("procHdId") != null && !request.getParameter("procHdId").equals("")) {
			procHdId = Integer.parseInt(request.getParameter("procHdId"));
			dataMap.put("procHdId", procHdId);
		}
		/**
		 * 
		 */
		if (request.getParameter(ORDER_NO) == null) {
			DgOrderhd orderhd = new DgOrderhd();
			orderhd.setHospital(hospital);
			MasDepartment dept = new MasDepartment();
			dept.setId(departmentId);
			orderhd.setDepartment(dept);
			orderhd.setTestType("Regular");
			orderhd.setOrderStatus("P");
			orderhd.setPatientType("OP");
			orderhd.setOrderDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter(CHANGED_DATE)));
			orderhd.setOrderTime(request.getParameter(CHANGED_TIME));
			
			Users user1 = new Users();
			user1.setId(user.getId());
			orderhd.setLastChgBy(user1);
			orderhd.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter(CHANGED_DATE)));
			orderhd.setLastChgTime(request.getParameter(CHANGED_TIME));
			orderNo = labHandlerService.generateOrderNumber();
			orderhd.setOrderNo(orderNo);
			if (request.getParameter(HIN_ID) != null) {
				orderhd.setHin(patient);
			}
			if (request.getParameter(EMPLOYEE_ID) != null
					&& !(request.getParameter(EMPLOYEE_ID).equals("0")) && !(request.getParameter(EMPLOYEE_ID).equals(""))) {
				int empId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
				MasEmployee employee = new MasEmployee();
				employee.setId(empId);
				orderhd.setPrescribedBy(employee);
			}
			if (request.getParameter(TOTAL_AMOUNT) != null
					&& !(request.getParameter(TOTAL_AMOUNT).equals(""))) {
				orderhd.setNetAmount(new BigDecimal(request
						.getParameter(TOTAL_AMOUNT)));
			}
			dataMap.put("orderhd", orderhd);
		}
		if (request.getParameter(PATIENT_NAME) != null) {
			opBillHeader.setPatientName(request.getParameter(PATIENT_NAME));
		}
		if (request.getParameter(AGE) != null) {
			opBillHeader.setAge(request.getParameter(AGE));
		}
		if (request.getParameter(GENDER) != null && !(request.getParameter(GENDER).equals("")) && !(request.getParameter(GENDER).equals("0"))) {
			MasAdministrativeSex administrativeSex = new MasAdministrativeSex();
			administrativeSex.setId(Integer.parseInt(request
					.getParameter(GENDER)));
			opBillHeader.setSex(administrativeSex);
		}
		if (request.getParameter(CONSULTING_DOCTOR) != null && !(request.getParameter(CONSULTING_DOCTOR).equals("")) && !(request.getParameter(CONSULTING_DOCTOR).equals("0"))) {
			opBillHeader.setConsultantName(request
					.getParameter(CONSULTING_DOCTOR));
		}
		if(request
				.getParameter(BILL_AMOUNT)!=null){
		opBillHeader.setBillAmt(new BigDecimal(request
				.getParameter(BILL_AMOUNT)));
		}else{
			opBillHeader.setBillAmt(new BigDecimal(0));
			}
		
		if(request.getParameter("schemeList")!=null && !request.getParameter("schemeList").equals("0")){
			MasScheme msc=new MasScheme();
			msc.setId(Integer.parseInt(request.getParameter("schemeList")));
			opBillHeader.setScheme(msc);
		}else{
			//opBillHeader.setBillAmt(new BigDecimal(0));
			}
		
		/*if (request.getParameter(DISCOUNT_AMOUNT) != null
				&& !(request.getParameter(DISCOUNT_AMOUNT).equals(""))) {
			BigDecimal totalDiscount = new BigDecimal("0");
			totalDiscount = new BigDecimal(request
					.getParameter(DISCOUNT_AMOUNT));
			opBillHeader.setDiscountOnBill(totalDiscount);
			dataMap.put("totalDiscount", totalDiscount);
			
			 totalDiscount = new BigDecimal("0");
			totalDiscount = new BigDecimal(request
					.getParameter("discountAmtBillId"));
			opBillHeader.setDiscountAmt(totalDiscount);
		}*/
		if (request.getParameter(ROUND_OF_VALUE) != null
				&& !(request.getParameter(ROUND_OF_VALUE).equals(""))) {
			opBillHeader.setRoundOff(new BigDecimal(request
					.getParameter(ROUND_OF_VALUE)));
		}
		if (request.getParameter(TOTAL_AMOUNT) != null
				&& !(request.getParameter(TOTAL_AMOUNT).equals(""))) {
			opBillHeader.setNetAmt(new BigDecimal(request
					.getParameter(TOTAL_AMOUNT)));
		}
//		if (request.getParameter(ADVANCE_ADJUSTMENT) != null
//				&& !(request.getParameter(ADVANCE_ADJUSTMENT).equals(""))) {
//			opBillHeader.setAdvanceAdjustment(new BigDecimal(request
//					.getParameter(ADVANCE_ADJUSTMENT)));
//			dataMap.put("advAdj", request.getParameter(ADVANCE_ADJUSTMENT));
//		}
//		if (request.getParameter(OUTSTANDING) != null
//				&& !(request.getParameter(OUTSTANDING).equals(""))) {
//			opBillHeader.setOutstanding(new BigDecimal(request
//					.getParameter(OUTSTANDING)));
//			dataMap.put("outstanding", request.getParameter(OUTSTANDING));
//		}
		if (request.getParameter("registrationType") != null) {
			String registrationType = request.getParameter("registrationType");
			dataMap.put("registrationType", registrationType);
		}
		if (request.getParameter("hiddenValueCharge") != null) {
			chargeListLength = Integer.parseInt(request
					.getParameter("hiddenValueCharge"));
		}
		if (request.getParameter("hiddenValuePayment") != null) {
			payListLength = Integer.parseInt(request
					.getParameter("hiddenValuePayment"));
		}
		for (int i = 1; i <= chargeListLength; i++) {
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
				qtyList.add("");
			}
			if (request.getParameter(AMOUNT + i) != null
					&& !request.getParameter(AMOUNT + i).equals("")) {
				amountList.add(request.getParameter(AMOUNT + i));
			} else {
				amountList.add("");
			}
			if (request.getParameter(RATE + i) != null
					&& !request.getParameter(RATE + i).equals("")) {
				rateList.add(request.getParameter(RATE + i));
			} else {
				rateList.add("");
			}
			if (request.getParameter(STANDARD_DEDUCTION + i) != null
					&& !request.getParameter(STANDARD_DEDUCTION + i).equals("")) {
				standardDeductionList.add(request
						.getParameter(STANDARD_DEDUCTION + i));
			} else {
				standardDeductionList.add("");
			}
			if (request.getParameter(DISCOUNT_PERCENTAGE + i) != null
					&& !request.getParameter(DISCOUNT_PERCENTAGE + i)
							.equals("")) {
				disPercentList.add(request
						.getParameter(DISCOUNT_PERCENTAGE + i));
			} else {
				disPercentList.add("0");
			}
			dataMap.put("disPercentList", disPercentList);
			if (request.getParameter(DISCOUNT + i) != null
					&& !request.getParameter(DISCOUNT + i).equals("")) {
				discount = request.getParameter(DISCOUNT + i);
			} else {
				discount = "0";
			}
			discountList.add(discount);
			if (request.getParameter(PROPORTIONAL_DISCOUNT + i) != null
					&& !request.getParameter(PROPORTIONAL_DISCOUNT + i).equals(
							"")) {
				proportionalDiscount = request
						.getParameter(PROPORTIONAL_DISCOUNT + i);
			} else {
				proportionalDiscount = "0";
			}
			proportionalDiscountList.add(proportionalDiscount);
			if (request.getParameter(NET_AMOUNT + i) != null
					&& !request.getParameter(NET_AMOUNT + i).equals("")) {
				netAmountList.add(request.getParameter(NET_AMOUNT + i));
			} else {
				netAmountList.add("");
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
			if (request.getParameter(DG_ORDER_DETAIL_ID + i) != null) {
				orderDetailIdList.add(request.getParameter(DG_ORDER_DETAIL_ID
						+ i));
			} else {
				orderDetailIdList.add("");
			}
			if (request.getParameter(FA_ACCOUNT_ID + i) != null) {
				accountIdList.add(request.getParameter(FA_ACCOUNT_ID + i));
			} else {
				accountIdList.add("");
			}
			if (request.getParameter(FA_SUB_LED_ID + i) != null
					&& !request.getParameter(FA_SUB_LED_ID + i).equals("0")) {
				subAccountIdList.add(request.getParameter(FA_SUB_LED_ID + i));
			} else {
				subAccountIdList.add("");
			}
			System.out.println("DEPARTMENT_TYPE_CODE--"+request.getParameter(DEPARTMENT_TYPE_CODE + i));
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
			
			if (request.getParameter("procDtId" + i) != null) {
				prcDtIdList.add(request.getParameter("procDtId"+ i));
			} else {
				prcDtIdList.add("");
			}
			if (request.getParameter("surgeryDtId" + i) != null) {
				surgeryDtIdList.add(request.getParameter("surgeryDtId"+ i));
			} else {
				surgeryDtIdList.add("");
			}
			
		}
		dataMap.put("prcDtIdList",prcDtIdList);
		dataMap.put("surgeryDtIdList", surgeryDtIdList);
		
		int surgeryHdId = 0;
		if(request.getParameter("surgeryHdId") != null){
			surgeryHdId = Integer.parseInt(request.getParameter("surgeryHdId") );
			dataMap.put("surgeryHdId", surgeryHdId);
		}
		
		if(flag.equalsIgnoreCase("p")){
		if (request.getParameter("avAdvAmtId") != null
				&& !(request.getParameter("avAdvAmtId").equals(""))) {
			opBillHeader.setAdvanceAdjustment(new BigDecimal(request
					.getParameter("avAdvAmtId")));
			dataMap.put("avAdvAmtId", request.getParameter("avAdvAmtId"));
		}
		opBillHeader.setPayStatus("P");
		if (request.getParameter("remainCId") != null
				&& !(request.getParameter("remainCId").equals(""))) {
			/*opBillHeader.setAdvanceAdjustment(new BigDecimal(request
					.getParameter("remainCId")));*/
			dataMap.put("remainCId", request.getParameter("remainCId"));
		}
		
		
		
		if (request.getParameter(DISCOUNT_ON_BILL) != null
				&& !(request.getParameter(DISCOUNT_ON_BILL).equals(""))) {
			opBillHeader.setDiscountOnBill(new BigDecimal(request
					.getParameter(DISCOUNT_ON_BILL)));
		}
		if (request.getParameter("balToBePiadId") != null
				&& !(request.getParameter("balToBePiadId").equals(""))) {
			opBillHeader.setPayableAmt(new BigDecimal(request
					.getParameter("balToBePiadId")));
			dataMap.put("payAmt", request.getParameter("balToBePiadId"));
		}
		if (request.getParameter(AUTHORIZER_ID) != null
				&& !(request.getParameter(AUTHORIZER_ID).equals("0"))) {
			MasAuthorizer authorizer = new MasAuthorizer();
			authorizer.setId(Integer.parseInt(request
					.getParameter(AUTHORIZER_ID)));
			opBillHeader.setAuthorizer(authorizer);
		}
		System.out.println("bal"+request.getParameter("balToBeRId"));
		if (request.getParameter("actualColAmtId") != null
				&& !(request.getParameter("actualColAmtId").equals("")) && 
				request.getParameter("balToBeRId")!=null && !(request.getParameter("balToBeRId").equals(""))) {
			/*if(request.getParameter("balToBeRId")!=null && request.getParameter("balToBeRId").equals(""))
			{
				*/opBillHeader.setActualCollectedAmt(new BigDecimal(request
						.getParameter("actualColAmtId")));}
			/*else
			{
				opBillHeader.setActualCollectedAmt(new BigDecimal(request
						.getParameter("actualColAmtId")).subtract(new BigDecimal(request.getParameter("balToBeRId"))));}
			}*/
			
		
		if (request.getParameter("adjusetCreditId") != null
				&& !(request.getParameter("adjusetCreditId").equals(""))) {
			opBillHeader.setAdvanceAdjustment(new BigDecimal(request
					.getParameter("adjusetCreditId")));
		}
		
		if (request.getParameter("charityTransferId") != null
				&& !(request.getParameter("charityTransferId").equals(""))) {
			opBillHeader.setCharityRcvd(new BigDecimal(request
					.getParameter("charityTransferId")));
		}
		
//		if (request.getParameter("charityIdd") != null
//				&& !(request.getParameter("charityIdd").equals("") ) && !(request.getParameter("charityIdd").equals("0") )) {
//			
//			opBillHeader.setCharity(new BigDecimal(request
//					.getParameter("charityTransferId")));
//		}
		
		
	/*	opBillHeader.setBillDate(HMSUtil
				.convertStringTypeDateToDateType(request
						.getParameter(CHANGED_DATE)));
		opBillHeader.setBillTime(request.getParameter(CHANGED_TIME));
		int userId = user.getId();
		Users userObj = new Users();
		userObj.setId(userId);

		opBillHeader.setChangedBy(userObj);
		opBillHeader.setStatus("y");
		
		dataMap.put("opBillHeader", opBillHeader);*/
		int userId = user.getId();
		Users userObj = new Users();
		userObj.setId(userId);
/*
		if (request.getParameter("registrationType") != null) {
			String registrationType = request.getParameter("registrationType");
			dataMap.put("registrationType", registrationType);
		}

		if (request.getParameter("hiddenValueCharge") != null) {
			chargeListLength = Integer.parseInt(request
					.getParameter("hiddenValueCharge"));
		}
		if (request.getParameter("hiddenValuePayment") != null) {
			payListLength = Integer.parseInt(request
					.getParameter("hiddenValuePayment"));
		}*/

		/*for (int i = 1; i <= chargeListLength; i++) {
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
				qtyList.add("");
			}
			if (request.getParameter(AMOUNT + i) != null
					&& !request.getParameter(AMOUNT + i).equals("")) {
				amountList.add(request.getParameter(AMOUNT + i));
			} else {
				amountList.add("");
			}
			if (request.getParameter(RATE + i) != null
					&& !request.getParameter(RATE + i).equals("")) {
				rateList.add(request.getParameter(RATE + i));
			} else {
				rateList.add("");
			}
			if (request.getParameter(STANDARD_DEDUCTION + i) != null
					&& !request.getParameter(STANDARD_DEDUCTION + i).equals("")) {
				standardDeductionList.add(request
						.getParameter(STANDARD_DEDUCTION + i));
			} else {
				standardDeductionList.add("");
			}
			if (request.getParameter(DISCOUNT_PERCENTAGE + i) != null
					&& !request.getParameter(DISCOUNT_PERCENTAGE + i)
							.equals("")) {
				disPercentList.add(request
						.getParameter(DISCOUNT_PERCENTAGE + i));
			} else {
				disPercentList.add("0");
			}
			dataMap.put("disPercentList", disPercentList);
			if (request.getParameter(DISCOUNT + i) != null
					&& !request.getParameter(DISCOUNT + i).equals("")) {
				discount = request.getParameter(DISCOUNT + i);
			} else {
				discount = "0";
			}
			discountList.add(discount);
			if (request.getParameter(PROPORTIONAL_DISCOUNT + i) != null
					&& !request.getParameter(PROPORTIONAL_DISCOUNT + i).equals(
							"")) {
				proportionalDiscount = request
						.getParameter(PROPORTIONAL_DISCOUNT + i);
			} else {
				proportionalDiscount = "0";
			}
			proportionalDiscountList.add(proportionalDiscount);
			if (request.getParameter(NET_AMOUNT + i) != null
					&& !request.getParameter(NET_AMOUNT + i).equals("")) {
				netAmountList.add(request.getParameter(NET_AMOUNT + i));
			} else {
				netAmountList.add("");
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
			if (request.getParameter(DG_ORDER_DETAIL_ID + i) != null) {
				orderDetailIdList.add(request.getParameter(DG_ORDER_DETAIL_ID
						+ i));
			} else {
				orderDetailIdList.add("");
			}
			if (request.getParameter(FA_ACCOUNT_ID + i) != null) {
				accountIdList.add(request.getParameter(FA_ACCOUNT_ID + i));
			} else {
				accountIdList.add("");
			}
			if (request.getParameter(FA_SUB_LED_ID + i) != null
					&& !request.getParameter(FA_SUB_LED_ID + i).equals("0")) {
				subAccountIdList.add(request.getParameter(FA_SUB_LED_ID + i));
			} else {
				subAccountIdList.add("");
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
		}*/
		for (int j = 1; j <= payListLength; j++) {
			if (request.getParameter(PAYMENT_MODE + j) != null
					&& !request.getParameter(PAYMENT_MODE + j).equals("")) {
				payModeList.add(request.getParameter(PAYMENT_MODE + j));
			} else {
				payModeList.add("");
			}
			if (request.getParameter(AMOUNT_RECEIVED + j) != null
					&& !request.getParameter(AMOUNT_RECEIVED + j).equals("")) {
				amtReceivedList.add(request.getParameter(AMOUNT_RECEIVED + j));
			} else {
				amtReceivedList.add("");
			}
			if (request.getParameter(CHEQUE_NO + j) != null
					&& !request.getParameter(CHEQUE_NO + j).equals("")) {
				chqNoList.add(request.getParameter(CHEQUE_NO + j));
			} else {
				chqNoList.add("");
			}
			if (request.getParameter(CHEQUE_DATE + j) != null
					&& !request.getParameter(CHEQUE_DATE + j).equals("")) {
				chqDateList.add(request.getParameter(CHEQUE_DATE + j));
			} else {
				chqDateList.add("");
			}
			if (request.getParameter(BANK_NAME + j) != null
					&& !request.getParameter(BANK_NAME + j).equals("")) {
				bankNameList.add(request.getParameter(BANK_NAME + j));
			} else {
				bankNameList.add("");
			}
		}
		BigDecimal payableAmt = new BigDecimal(0);
		BigDecimal remainingCredit = new BigDecimal(0);
		if (request.getParameter(PAYABLE_AMOUNT) != null
				&& !(request.getParameter(PAYABLE_AMOUNT).equals(""))) {
			payableAmt = new BigDecimal(request.getParameter(PAYABLE_AMOUNT));

		}
		if (request.getParameter("remainCId") != null
				&& !(request.getParameter("remainCId").equals(""))) {
			remainingCredit = new BigDecimal(request.getParameter("remainCId"));

		}
		if (payableAmt.compareTo(new BigDecimal(0)) > 0) {
			BlReceiptHeader receiptHeader = new BlReceiptHeader();
			if (request.getParameter(HIN_ID) != null) {
				patient.setId(Integer.parseInt(request.getParameter(HIN_ID)));
				receiptHeader.setHin(patient);
			}
			if (request.getParameter(PAYABLE_AMOUNT) != null
					&& !(request.getParameter(PAYABLE_AMOUNT).equals(""))) {
				receiptHeader.setAmount(new BigDecimal(request
						.getParameter(PAYABLE_AMOUNT)));
			}
			if (request.getParameter(DISCOUNT_AMOUNT) != null
					&& !(request.getParameter(DISCOUNT_AMOUNT).equals(""))) {
				BigDecimal totalDiscount = new BigDecimal("0");
				totalDiscount = new BigDecimal(request
						.getParameter(DISCOUNT_AMOUNT));
				receiptHeader.setCharityAmt(totalDiscount);

			}
			if (request.getParameter(ROUND_OF_VALUE) != null
					&& !(request.getParameter(ROUND_OF_VALUE).equals(""))) {
				receiptHeader.setRoundOff(new BigDecimal(request
						.getParameter(ROUND_OF_VALUE)));
			}
			receiptHeader.setReceiptType("opb");
			receiptHeader.setReceiptDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter(CHANGED_DATE)));
			receiptHeader.setReceiptTime(request.getParameter(CHANGED_TIME));
			receiptHeader.setHospital(hospital);
			receiptHeader.setRemainingCredit(remainingCredit);
			receiptHeader.setTotalRcdAmt(payableAmt.add(remainingCredit));

			receiptHeader.setChangedBy(userObj);
			dataMap.put("receiptHeader", receiptHeader);
		}}
		
		else if(flag.equalsIgnoreCase("W")){
			if (request.getParameter("waiveAmt") != null
					&& !(request.getParameter("waiveAmt").equals(""))) {
				opBillHeader.setCharity(new BigDecimal(request
						.getParameter("waiveAmt")));
				dataMap.put("waiveAmt", request.getParameter("waiveAmt"));
				opBillHeader.setPayStatus("W");
			}
			
		}
		else
		{
			if (request.getParameter("outstadAmt") != null
					&& !(request.getParameter("outstadAmt").equals(""))) {
				opBillHeader.setOutstanding(new BigDecimal(request
						.getParameter("outstadAmt")));
				dataMap.put("outstadAmt", request.getParameter("outstadAmt"));
				opBillHeader.setPayStatus("PL");
			}
		}
		/*FaVoucherHeader voucherHeader = new FaVoucherHeader();
		String voucherNo = accountHandlerService.generateVoucherNo("RES",
				"save");
		voucherHeader.setVoucherNo(voucherNo);
		FaMasVoucherType voucherType = new FaMasVoucherType();
		voucherType.setId(2);
		voucherHeader.setVoucherType(voucherType);
		voucherHeader.setLastChgBy(userName);
		voucherHeader.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(request
						.getParameter(CHANGED_DATE)));
		voucherHeader.setLastChgTime(request.getParameter(CHANGED_TIME));
		voucherHeader.setCrBalance(new BigDecimal(request
				.getParameter(BILL_AMOUNT)));
		voucherHeader.setDrBalance(new BigDecimal(request
				.getParameter(BILL_AMOUNT)));
		voucherHeader.setHospital(hospital);
		voucherHeader.setNaration("Being Cash Sales");
		voucherHeader.setStatus("y");
		voucherHeader.setLastChgBy(userName);
		voucherHeader.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(request
						.getParameter(CHANGED_DATE)));
		voucherHeader.setLastChgTime(request.getParameter(CHANGED_TIME));
		voucherHeader.setVoucherDate(HMSUtil
				.convertStringTypeDateToDateType(request
						.getParameter(CHANGED_DATE)));
		voucherHeader.setVoucherTime(request.getParameter(CHANGED_TIME));*/

		//dataMap.put("voucherHeader", voucherHeader);
		opBillHeader.setBillDate(HMSUtil
				.convertStringTypeDateToDateType(request
						.getParameter(CHANGED_DATE)));
		opBillHeader.setBillTime(request.getParameter(CHANGED_TIME));
		int userId = user.getId();
		Users userObj = new Users();
		userObj.setId(userId);

		opBillHeader.setChangedBy(userObj);
		opBillHeader.setStatus("y");
		
		dataMap.put("opBillHeader", opBillHeader);

		dataMap.put("userName", userName);
		dataMap.put("chargeList", chargeList);
		dataMap.put("mainChargeList", mainChargeList);
		dataMap.put("subChargeList", subChargeList);
		dataMap.put("discountList", discountList);
		dataMap.put("proportionalDiscountList", proportionalDiscountList);
		dataMap.put("qtyList", qtyList);
		dataMap.put("rateList", rateList);
		dataMap.put("standardDeductionList", standardDeductionList);
		dataMap.put("amountList", amountList);
		dataMap.put("netAmountList", netAmountList);
		dataMap.put("payModeList", payModeList);
		dataMap.put("amtReceivedList", amtReceivedList);
		dataMap.put("chqNoList", chqNoList);
		dataMap.put("chqDateList", chqDateList);
		dataMap.put("bankNameList", bankNameList);
		dataMap.put("orderDetailIdList", orderDetailIdList);
		dataMap.put("accountIdList", accountIdList);
		dataMap.put("subAccountIdList", subAccountIdList);
		dataMap.put("deptCodeList", deptCodeList);
		dataMap.put("deptIdList", deptIdList);
		dataMap.put("visitIdNew",visitIdNew);
		dataMap.put("deptIdNew11",81);
		
		if (request.getParameter("tempBillHdId") != null) {
			int tempBillHdId = Integer.parseInt(request
					.getParameter("tempBillHdId"));
			dataMap.put("tempBillHdId", tempBillHdId);
		}
   dataMap.put("patientuhid", uhid);
		boolean saved = false;
		String message = "";
		map = opBillingHandlerService.submitBillServicingDetails(dataMap);
		if(deptId==81){
			synchronized (this) {
			Visit v=new Visit();
			int maxTokenNo = 0;
			
			maxTokenNo = opBillingHandlerService.getTokenNoForDepartment(departmentId);
			
			visitNo=opBillingHandlerService.getVisitNo(hinNo);
			tokenNo = maxTokenNo + 1;
			v.setVisitDate(new Date());
			/*v.setVisitNo(visitNo);*/
			Patient pt=new Patient();
			pt.setId(Integer.parseInt(request.getParameter(HIN_ID)));
			v.setHin(pt);
			
			MasEmployee emp=new MasEmployee();
			emp.setId(Integer.parseInt(request.getParameter(EMPLOYEE_ID)));
			v.setDoctor(emp);
			
			MasCaseType ct=new MasCaseType();
			ct.setId(17);
			v.setCaseType(ct);

			MasComplaint comp=new MasComplaint();
			comp.setId(16);
			v.setComplaint(comp);
			
			/*v.setTokenNo(tokenNo);*/
			String age=opBillingHandlerService.getage(hinNo);
			v.setAge(age);

			MasDepartment md=new MasDepartment();
			md.setId(81);
			v.setDepartment(md);
			
			v.setStatus("y");
			v.setVisitStatus("w");
			
			v.setAppointmentType("D");
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");
			String time = (String)utilMap.get("currentTime");
			v.setVisitTime(time);
			dataMap=opBillingHandlerService.submitvisit(v);
			map.put("tokenNo", tokenNo);
			map.put("hinNo", hinNo);
			}
		}
		String printUrl = "";
		String url = "";
		String billNo = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (map.get("billNo") != null) {
			billNo = (String) map.get("billNo");
		}
		if (saved) {
			message = "Billing has been done successfully!! Bill No is "
					+ billNo + ". Do you want to print?";
			printUrl = "submitForm('messageBilling','/hms/hms/billing?method=printBillPrintingServicingReport&billNo="
					+ billNo + "')";
			url = "submitForm('messageBilling','/hms/hms/opBilling?method=showBillServicingJsp')";
			map.put("printUrl", printUrl);
			map.put("url", url);

		} else {
			message = "Try Again!";
		}
		map.put("message", message);

		String jsp = MESSAGE_FOR_BILLING_JSP + ".jsp";
		map.put("contentJsp", jsp);
		map.put("billtype", "servicing");
		map.put("billNo", billNo);
		map.put("tokenNo", tokenNo);
		map.put("hinNo", hinNo);
		return new ModelAndView("index", "map", map);
	}

	
	
	/**
	 * Pharmacy Billing Methods
	 *
	 */

	

	public ModelAndView getPrescriptionAndTempBillNo(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hin = "";
		Box box = HMSUtil.getBox(request);
		hin = box.getString(HIN_NO);
		map = opBillingHandlerService.getPrescriptionAndTempBillNo(hin);
		String jsp = "";
		jsp = BILLING_RESPONSE_FOR_PRESCRIPTION_NO_JSP;
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView searchPatientForBillDispensing(HttpServletRequest request,
			HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		String jsp = SEARCH_PATIENT_BILL_DISPENSING_JSP + ".jsp";
			map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	//searchPatientForBillDispensing
	
	public ModelAndView showBillDispensingJsp(HttpServletRequest request,
			HttpServletResponse response) {
	
		Map<String, Object> map = new HashMap<String, Object>();
		String uhid=request.getParameter("uhid");
		System.out.println("uhid------------->"+uhid);
		HttpSession session = request.getSession();
		int sessionHospitalId = 0;
		sessionHospitalId = (Integer)session.getAttribute("hospitalId");
		
		Box box = HMSUtil.getBox(request);
		box.put("sessionHospitalId",sessionHospitalId);
		map= opBillingHandlerService.showBillDispensingJsp(box);
		
		String jsp = SEARCH_PATIENT_BILL_DISPENSING_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	//BillDispensingDetials Method for BIll Dispensing
	//
	/*public ModelAndView getPatientDetailsForBillDispensing(
			HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		String uhid=request.getParameter("uhid");
		String consult=request.getParameter("consult");
		String visitId=request.getParameter("visitId");
		String phinNumer=request.getParameter("phinNumer");
		
		Box box = HMSUtil.getBox(request);
		box.put("uhid", uhid);
		box.put("visitId", visitId);
		box.put("phinNumer", phinNumer);
		map = opBillingHandlerService
				.getPatientDetailsForBillDispensing(box);
	
		String jsp = "";
		
		jsp = BILL_DISPENSING_JSP + ".jsp";
	
		
		map.put("consult", consult);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	*/
	public ModelAndView getPatientDetailsForBillDispensing(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
  HttpSession session=request.getSession();
  int hospitalId=(Integer.parseInt(request.getParameter(HOSPITAL_ID)));
		
		Box box = HMSUtil.getBox(request);
			String prescriptionNo = "";
		prescriptionNo = box.getString(PRESCRIPTION_NO);
		String uhid=request.getParameter("uhid");
		System.out.println("uhid>>>>>>>>>>>>>>>>>>>>>>>."+uhid);
		String tempBillNo = box.getString("tempBillNo");
		String registered = request.getParameter("registered");
		box.put(HOSPITAL_ID, hospitalId);

		map = opBillingHandlerService.getPatientDetailsForBillDispensing(box);
		map.put("registered", registered);

		String jsp = "";
		String msg = "";
		/*
		 * if((registered.equals("yes") && map.get("patientList") != null &&
		 * prescriptionNo.equals("")) || registered.equals("no")){ detailsMap =
		 * opBillingHandlerService.getDetailsForBillDispensing();
		 * map.put("detailsMap", detailsMap); jsp= BILL_DISPENSING_JSP+".jsp";
		 * }else if((registered.equals("yes") && map.get("patientList") != null &&
		 * map.get("presHdList") != null) || registered.equals("no")){
		 * detailsMap = opBillingHandlerService.getDetailsForBillDispensing();
		 * map.put("detailsMap", detailsMap); map.put("prescriptionNo",
		 * prescriptionNo); jsp= BILL_DISPENSING_JSP+".jsp"; }else
		 * if(!tempBillNo.equals("")){ if(map.get("tempBillList") !=null){ jsp =
		 * BILL_DISPENSING_JSP + ".jsp"; }else{ String msg = "No Record Found.";
		 * map.put("msg", msg); jsp = SEARCH_PATIENT_BILL_DISPENSING_JSP +
		 * ".jsp"; } }else{ message = "No Record Found!"; map.put("message",
		 * message); jsp = SEARCH_PATIENT_BILL_DISPENSING_JSP+".jsp"; }
		 */
		detailsMap = opBillingHandlerService.getDetailsForBillDispensing();
		map.put("detailsMap", detailsMap);
	/*	if ((!registered.equals("yes") && map.get("patientList") != null)
				|| registered.equals("no")) {*/
			if (!prescriptionNo.equals("")) {
				if (map.get("presHdList") != null) {
					jsp = BILL_DISPENSING_JSP + ".jsp";
				} else {
					msg = "No Record Found.";
					jsp = SEARCH_PATIENT_BILL_DISPENSING_JSP + ".jsp";
				}
				map.put("prescriptionNo", prescriptionNo);
			} else if (!tempBillNo.equals("")) {
				if (map.get("tempBillList") != null) {
					jsp = BILL_DISPENSING_JSP + ".jsp";
				} else {
					msg = "No Record Found.";
					jsp = SEARCH_PATIENT_BILL_DISPENSING_JSP + ".jsp";
				}
			} else {
				jsp = BILL_DISPENSING_JSP + ".jsp";
			}
			map.put("prescriptionNo", prescriptionNo);
			/*} else {
			msg = "No Record Found.";
			jsp = SEARCH_PATIENT_BILL_DISPENSING_JSP + ".jsp";
		}*/
	msg = "No Record Found.";
	jsp = BILL_DISPENSING_JSP + ".jsp";
		map.put("message", msg);

		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}


	public ModelAndView getItemCodeForAutoComplete(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = opBillingHandlerService.getItemCodeForAutoComplete(box);
		String jsp = "";
		jsp = BILLING_RESPONSE_FOR_ITEM_CODE_GRID_JSP;

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showItemBatchNoPopUp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> itemDiscMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int rowVal = 0;
		rowVal = box.getInt("rowVal");
		map = opBillingHandlerService.getItemBatchNo(box);
		itemDiscMap = opBillingHandlerService.getItemDiscount(box);
		String jsp = "";
		if (box.getString("flag").equals("pkg")) {
			if (!box.getString("dispPrice").equals("")) {
				
				map.put("dispPrice", new BigDecimal(box
								.getString("dispPrice")));
			}
			jsp = "billBatchDetailsPopUpForPkg";
		} else {
			jsp = BILL_ITEM_BATCH_DETAILS_POP_UP_JSP;
		}
		map.put("itemDiscMap", itemDiscMap);
		map.put("rowVal", rowVal);
		System.out.println(request.getParameter("patientTypeId"));
		map.put("patientTypeId", Integer.parseInt(request.getParameter("patientTypeId")));
		return new ModelAndView(jsp, "map", map);
	}

	public  ModelAndView submitBillDispensingDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		Users user = new Users();
		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);
		BlDispensingHeader dispensingHeader = new BlDispensingHeader();
		String billNo = "";
		String billType = "OD";
		billNo = opBillingHandlerService.generateBillNo(billType, "save",hospitalId);
		dispensingHeader.setBillNo(billNo);

		dispensingHeader.setHospital(hospital);
		Patient patient = new Patient();
		if (request.getParameter(HIN_ID) != null) {
			patient.setId(Integer.parseInt(request.getParameter(HIN_ID)));
			dispensingHeader.setHin(patient);
			dispensingHeader.setPatientStatus("r");
		} else {
			dispensingHeader.setPatientStatus("u");
		}
		if (request.getParameter(HIN_NO) != null) {
			dispensingHeader.setHinNo(request.getParameter(HIN_NO));
		}
		if (request.getParameter(PATIENT_NAME) != null) {
			dispensingHeader.setPatientName(request.getParameter(PATIENT_NAME));
		}
		if (request.getParameter(AGE) != null) {
			dispensingHeader.setAge(request.getParameter(AGE));
		}
		if (request.getParameter(SEX_ID) != null) {
			MasAdministrativeSex administrativeSex = new MasAdministrativeSex();
			administrativeSex.setId(Integer.parseInt(request
					.getParameter(SEX_ID)));
			dispensingHeader.setSex(administrativeSex);
		}
		if (request.getParameter(CONSULTING_DOCTOR) != null) {
			dispensingHeader.setConsultantName(request
					.getParameter(CONSULTING_DOCTOR));
		}
		if(request.getParameter(BILL_AMOUNT)!=null){
			dispensingHeader.setConsultantName(request
					.getParameter(BILL_AMOUNT));
		}
	/*	dispensingHeader.setBillAmt(new BigDecimal(request
				.getParameter(BILL_AMOUNT)));*/
		if (request.getParameter(DISCOUNT_AMOUNT) != null
				&& !(request.getParameter(DISCOUNT_AMOUNT).equals(""))) {
			BigDecimal totalDiscount = new BigDecimal("0");
			totalDiscount = new BigDecimal(request
					.getParameter(DISCOUNT_AMOUNT));
			dispensingHeader.setDiscountAmt(totalDiscount);
			detailsMap.put("totalDiscount", totalDiscount);
		}
		if (request.getParameter(ROUND_OF_VALUE) != null
				&& !(request.getParameter(ROUND_OF_VALUE).equals(""))) {
			dispensingHeader.setRoundOff(new BigDecimal(request
					.getParameter(ROUND_OF_VALUE)));
		}
		if (request.getParameter(TOTAL_AMOUNT) != null
				&& !(request.getParameter(TOTAL_AMOUNT).equals(""))) {
			dispensingHeader.setNetAmt(new BigDecimal(request
					.getParameter(TOTAL_AMOUNT)));
		}
		if (request.getParameter(ADVANCE_ADJUSTMENT) != null
				&& !(request.getParameter(ADVANCE_ADJUSTMENT).equals(""))) {
			dispensingHeader.setAdvAdjustment(new BigDecimal(request
					.getParameter(ADVANCE_ADJUSTMENT)));
			detailsMap.put("advAdj", request.getParameter(ADVANCE_ADJUSTMENT));
		}
		if (request.getParameter(OUTSTANDING) != null
				&& !(request.getParameter(OUTSTANDING).equals(""))) {
			dispensingHeader.setOutstanding(new BigDecimal(request
					.getParameter(OUTSTANDING)));
			detailsMap.put("outstanding", request.getParameter(OUTSTANDING));
		}
		if (request.getParameter(DISCOUNT_ON_BILL) != null
				&& !(request.getParameter(DISCOUNT_ON_BILL).equals(""))) {
			dispensingHeader.setDiscountOnBill(new BigDecimal(request
					.getParameter(DISCOUNT_ON_BILL)));
		}
		if (request.getParameter(PAYABLE_AMOUNT) != null
				&& !(request.getParameter(PAYABLE_AMOUNT).equals(""))) {
			dispensingHeader.setPayableAmt(new BigDecimal(request
					.getParameter(PAYABLE_AMOUNT)));
		}
		if (request.getParameter(AUTHORIZER_ID) != null
				&& !(request.getParameter(AUTHORIZER_ID).equals("0"))) {
			MasAuthorizer authorizer = new MasAuthorizer();
			authorizer.setId(Integer.parseInt(request
					.getParameter(AUTHORIZER_ID)));
			dispensingHeader.setAuthorizer(authorizer);
		}
		if (request.getParameter(EMPLOYEE_ID) != null
				&& !(request.getParameter(EMPLOYEE_ID).equals("0"))) {
			int empId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			MasEmployee employee = new MasEmployee();
			employee.setId(empId);
			dispensingHeader.setConsultant(employee);
		}
		if (request.getParameter("actualCollectedAmt") != null
				&& !(request.getParameter("actualCollectedAmt").equals(""))) {
			dispensingHeader.setActualCollectedAmt(new BigDecimal(request
					.getParameter("actualCollectedAmt")));
		}
		if (request.getParameter("compDiscount") != null
				&& !request.getParameter("compDiscount").equals("")) {
			dispensingHeader.setDiscount(new BigDecimal(request
					.getParameter("compDiscount")));
		}
		if (request.getParameter("charity") != null
				&& !request.getParameter("charity").equals("")) {
			dispensingHeader.setCharity(new BigDecimal(request
					.getParameter("charity")));
		}
		if (request.getParameter(PATIENT_TYPE_ID) != null) {
			MasPatientType patientType = new MasPatientType();
			patientType.setId(Integer.parseInt(request
					.getParameter(PATIENT_TYPE_ID)));
			dispensingHeader.setPatientType(patientType);
		}
		if (request.getParameter("companyId") != null
				&& !(request.getParameter("companyId").equals("0"))) {
			MasCompany company = new MasCompany();
			company.setId(Integer.parseInt(request.getParameter("companyId")));
			dispensingHeader.setCompany(company);
		}
		dispensingHeader.setBillDate(HMSUtil
				.convertStringTypeDateToDateType(request
						.getParameter(CHANGED_DATE)));
		dispensingHeader.setBillTime(request.getParameter(CHANGED_TIME));
		int userId = user.getId();
		Users userObj = new Users();
		userObj.setId(userId);
		dispensingHeader.setChangedBy(userObj);
		dispensingHeader.setStatus("y");
		detailsMap.put("dispensingHeader", dispensingHeader);

		BigDecimal payableAmt = new BigDecimal(0);
		if (request.getParameter(PAYABLE_AMOUNT) != null
				&& !(request.getParameter(PAYABLE_AMOUNT).equals(""))) {
			payableAmt = new BigDecimal(request.getParameter(PAYABLE_AMOUNT));

		}
		if (payableAmt.compareTo(new BigDecimal(0)) > 0) {
			BlReceiptHeader receiptHeader = new BlReceiptHeader();
			if (request.getParameter(HIN_ID) != null) {
				patient.setId(Integer.parseInt(request.getParameter(HIN_ID)));
				receiptHeader.setHin(patient);
			}
			if (request.getParameter(PAYABLE_AMOUNT) != null
					&& !(request.getParameter(PAYABLE_AMOUNT).equals(""))) {
				receiptHeader.setAmount(new BigDecimal(request
						.getParameter(PAYABLE_AMOUNT)));
			}
			if (request.getParameter(DISCOUNT_AMOUNT) != null
					&& !(request.getParameter(DISCOUNT_AMOUNT).equals(""))) {
				BigDecimal totalDiscount = new BigDecimal("0");
				totalDiscount = new BigDecimal(request
						.getParameter(DISCOUNT_AMOUNT));
				receiptHeader.setCharityAmt(totalDiscount);
			}
			if (request.getParameter(ROUND_OF_VALUE) != null
					&& !(request.getParameter(ROUND_OF_VALUE).equals(""))) {
				receiptHeader.setRoundOff(new BigDecimal(request
						.getParameter(ROUND_OF_VALUE)));
			}
			receiptHeader.setReceiptType("bld");
			receiptHeader.setReceiptDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter(CHANGED_DATE)));
			receiptHeader.setReceiptTime(request.getParameter(CHANGED_TIME));
			receiptHeader.setHospital(hospital);
			receiptHeader.setChangedBy(userObj);
			detailsMap.put("receiptHeader", receiptHeader);
		}

		/*FaVoucherHeader voucherHeader = new FaVoucherHeader();
		String voucherNo = accountHandlerService.generateVoucherNo("RES",
				"Display");
		voucherHeader.setVoucherNo(voucherNo);
		FaMasVoucherType voucherType = new FaMasVoucherType();
		voucherType.setId(2);
		voucherHeader.setVoucherType(voucherType);
		voucherHeader.setLastChgBy(userName);
		voucherHeader.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(request
						.getParameter(CHANGED_DATE)));
		voucherHeader.setLastChgTime(request.getParameter(CHANGED_TIME));
		voucherHeader.setCrBalance(new BigDecimal(request
				.getParameter(BILL_AMOUNT)));
		voucherHeader.setDrBalance(new BigDecimal(request
				.getParameter(BILL_AMOUNT)));
		voucherHeader.setHospital(hospital);
		voucherHeader.setNaration("Being Cash Sales");
		voucherHeader.setStatus("y");
		voucherHeader.setLastChgBy(userName);
		voucherHeader.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(request
						.getParameter(CHANGED_DATE)));
		voucherHeader.setLastChgTime(request.getParameter(CHANGED_TIME));
		voucherHeader.setVoucherDate(HMSUtil
				.convertStringTypeDateToDateType(request
						.getParameter(CHANGED_DATE)));
		voucherHeader.setVoucherTime(request.getParameter(CHANGED_TIME));

		detailsMap.put("voucherHeader", voucherHeader);*/

		map = opBillingHandlerService.submitBillDispensingDetails(box,
				detailsMap);
		boolean flag = false;
		String message = "";
		flag = (Boolean) map.get("flag");

		String printUrl = "";
		String url = "";
		if (map.get("flag") != null) {
			flag = (Boolean) map.get("flag");
		}
		if (flag) {
			message = "Billing has been done successfully!!\n Bill No is "
					+ billNo + ". Do you want to print?";
			printUrl = "submitForm('messageBilling','/hms/hms/billing?method=printBillPrintingDispencingReport&textfield="
					+ billNo + "')";
			url = "submitForm('messageBilling','/hms/hms/opBilling?method=showBillDispensingJsp')";
			map.put("printUrl", printUrl);
			map.put("url", url);

		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		String jsp = "";
		jsp = MESSAGE_FOR_BILLING_JSP + ".jsp";
		map.put("contentJsp", jsp);
		map.put("billtype", "dispensing");
		map.put("billNo", billNo);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPaymentAdviceSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = BILL_PAYMENT_ADVICE_SEARCH_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPaymentAdviceForServercingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = BILL_PAYMENT_ADVICE_SEARCH_For_Service_JSP+ ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}


	public ModelAndView getBillNoForPaymentAdvice(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String billType = "";
		String flag = "";
		
		HttpSession session = null;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		billType = box.getString(BILL_TYPE);
		flag = box.getString("flag");
		String patientType = box.getString(PATIENT_TYPE);
		
		box.put(HOSPITAL_ID, session.getAttribute(HOSPITAL_ID));

		map = opBillingHandlerService.getBillNoForPaymentAdvice(box);

		String jsp = "";
		jsp = BILLING_RESPONSE_FOR_BILL_NO_JSP;
		map.put("billType", billType);
		map.put("flag", flag);
		map.put("patientType", patientType);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getPatientDetailsForPaymentAdvice(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		String billType = "";
		int uhid=0;
		Box box = HMSUtil.getBox(request);
		
	
		box.put("hospitalId", hospitalId);
		if (request.getParameter(BILL_TYPE) != null)
			billType = request.getParameter(BILL_TYPE);

		if (billType.equals("servicing")) {
			map = opBillingHandlerService
					.getPatientDetailsForPaymentAdviceServicing(box);
		} else if (billType.equals("dispensing")) {
			map = opBillingHandlerService
					.getPatientDetailsForPaymentAdviceDispensing(box);
		}
		String paymentAdviceNo = "";
		paymentAdviceNo = opBillingHandlerService
				.generatePaymentAdviceNo("display",hospitalId);
		map.put("paymentAdviceNo", paymentAdviceNo);

		String jsp = "";
		String message = "";
		if (map.get("billList") != null) {
			jsp = BILL_PAYMENT_ADVICE_SERVICING_JSP + ".jsp";
		} else if (map.get("dispensingHeaderList") != null) {
			jsp = BILL_PAYMENT_ADVICE_DISPENSING_JSP + ".jsp";

		} else {
			if(map.get("orderList")!=null){
				message = (String)map.get("msg");
			}else{
			message = "No Record Found!";
			}
			jsp = BILL_PAYMENT_ADVICE_SEARCH_For_Service_JSP+ ".jsp";
			map.put("message", message);
		}
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView submitPaymentAdviceServicingDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();

		List chargeCodeIdList = new ArrayList();
		List qtyList = new ArrayList();
		List adviceAmtList = new ArrayList();
		List billDtIdList = new ArrayList();
		List chargeSlipDtIdList = new ArrayList();
		List adviceCharityAmtList = new ArrayList();

		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (session.getAttribute(USER_ID) != null) {
			userId = (Integer) session.getAttribute(USER_ID);
		}
		BlPaymentAdviceHeader adviceHeader = new BlPaymentAdviceHeader();
		if (request.getParameter(HIN_ID) != null) {
			Patient patient = new Patient();
			patient.setId(Integer.parseInt(request.getParameter(HIN_ID)));
			adviceHeader.setHin(patient);
			dataMap
					.put("hinId", Integer
							.parseInt(request.getParameter(HIN_ID)));
		}
		if (request.getParameter(INPATIENT_ID) != null) {
			Inpatient inpatient = new Inpatient();
			inpatient.setId(Integer
					.parseInt(request.getParameter(INPATIENT_ID)));
			adviceHeader.setInpatient(inpatient);
		}
		if (hospitalId != 0) {
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			adviceHeader.setHospital(hospital);
		}
		if (request.getParameter(BILL_ID) != null) {
			BlOpBillHeader opBillHeader = new BlOpBillHeader();
			opBillHeader.setId(Integer.parseInt(request.getParameter(BILL_ID)));
			adviceHeader.setBill(opBillHeader);
			dataMap.put("billId", Integer.parseInt(request
					.getParameter(BILL_ID)));
		}
		if (request.getParameter(CHARGE_SLIP_ID) != null) {
			BlChargeSlipMain chargeSlipMain = new BlChargeSlipMain();
			chargeSlipMain.setId(Integer.parseInt(request
					.getParameter(CHARGE_SLIP_ID)));
			adviceHeader.setChargeSlipMain(chargeSlipMain);
		}
		if (request.getParameter(TOTAL_ADVICE_AMOUNT) != null) {
			adviceHeader.setTotalAdviceAmt(new BigDecimal(request
					.getParameter(TOTAL_ADVICE_AMOUNT)));
			dataMap.put("adviceAmt", new BigDecimal(request
					.getParameter(TOTAL_ADVICE_AMOUNT)));
		}
		if (request.getParameter(CASH_ADVICE_AMOUNT) != null
				&& !(request.getParameter(CASH_ADVICE_AMOUNT).equals(""))) {
			adviceHeader.setCashAdviceAmt(new BigDecimal(request
					.getParameter(CASH_ADVICE_AMOUNT)));
		}
		if (request.getParameter(PAST_DUE_ADJUSTED) != null
				&& !(request.getParameter(PAST_DUE_ADJUSTED).equals(""))) {
			adviceHeader.setOnAccountAmt(new BigDecimal(request
					.getParameter(PAST_DUE_ADJUSTED)));
		}
		if (request.getParameter(TOTAL_CHARITY_AMOUNT) != null
				&& !(request.getParameter(TOTAL_CHARITY_AMOUNT).equals(""))) {
			adviceHeader.setTotalAdviceCharityAmt(new BigDecimal(request
					.getParameter(TOTAL_CHARITY_AMOUNT)));
		}
		if (request.getParameter(CHANGED_DATE) != null) {
			adviceHeader.setPaymentAdviceDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter(CHANGED_DATE)));
		}

		adviceHeader.setPaymentAdviceTime(request.getParameter(CHANGED_TIME));
		Users user = new Users();
		user.setId(userId);
		adviceHeader.setLastChgBy(user);
		dataMap.put("adviceHeader", adviceHeader);
		BigDecimal pastDues = new BigDecimal(0);
		if (request.getParameter(PAST_DUE_ADJUSTED) != null
				&& !(request.getParameter(PAST_DUE_ADJUSTED).equals(""))) {
			pastDues = new BigDecimal(request.getParameter(PAST_DUE_ADJUSTED));
			dataMap.put("pastDues", pastDues);
		}
		int chargeListLength = 0;
		if (request.getParameter("chargeListLength") != null) {
			chargeListLength = Integer.parseInt(request
					.getParameter("chargeListLength"));
		}
		for (int i = 1; i < chargeListLength; i++) {
			if (request.getParameter(CHARGE_CODE_ID + i) != null) {
				chargeCodeIdList.add(request.getParameter(CHARGE_CODE_ID + i));
				if (request.getParameter(QUANTITY + i) != null) {
					qtyList.add(request.getParameter(QUANTITY + i));
				}
				if (request.getParameter(ADVICE_AMOUNT + i) != null) {
					adviceAmtList.add(request.getParameter(ADVICE_AMOUNT + i));
				}
				if (request.getParameter("billDtId" + i) != null) {
					billDtIdList.add(Integer.parseInt(request
							.getParameter("billDtId" + i)));
				}
				if (request.getParameter("adviceCharity" + i) != null) {
					adviceCharityAmtList.add(request
							.getParameter("adviceCharity" + i));
				} else {
					adviceCharityAmtList.add("");
				}
				if (request.getParameter("chargeSlipDtId" + i) != null) {
					chargeSlipDtIdList.add(Integer.parseInt(request
							.getParameter("chargeSlipDtId" + i)));
				}
				dataMap.put("chargeCodeIdList", chargeCodeIdList);
				dataMap.put("qtyList", qtyList);
				dataMap.put("adviceAmtList", adviceAmtList);
				dataMap.put("adviceCharityAmtList", adviceCharityAmtList);
				dataMap.put("chargeSlipDtIdList", chargeSlipDtIdList);
				dataMap.put("billDtIdList", billDtIdList);
			}
		}
		map = opBillingHandlerService
				.submitPaymentAdviceServicingDetails(dataMap);
		boolean flag = false;
		String message = "";
		flag = (Boolean) map.get("flag");
		if (flag) {
			message = "Record Saved Successfully!";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		String jsp = "";
		jsp = BILL_PAYMENT_ADVICE_SEARCH_For_Service_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView submitPaymentAdviceDispensingDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);
		List itemIdList = new ArrayList();
		List batchIdList = new ArrayList();
		List qtyList = new ArrayList();
		List adviceAmtList = new ArrayList();
		List billDtIdList = new ArrayList();
		List adviceCharityAmtList = new ArrayList();

		HttpSession session = request.getSession();

		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		BlPymntAdviceDispHeader adviceDispHeader = new BlPymntAdviceDispHeader();
		int hinId = box.getInt(HIN_ID);
		if (hinId != 0) {
			Patient patient = new Patient();
			patient.setId(hinId);
			adviceDispHeader.setHin(patient);
			dataMap.put("hinId", hinId);
		}
		if (hospitalId != 0) {
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			adviceDispHeader.setHospital(hospital);
		}
		if (request.getParameter(INPATIENT_ID) != null) {
			Inpatient inpatient = new Inpatient();
			inpatient.setId(Integer
					.parseInt(request.getParameter(INPATIENT_ID)));
			adviceDispHeader.setInpatient(inpatient);
		}
		BlDispensingHeader dispensingHeader = new BlDispensingHeader();
		dispensingHeader.setId(box.getInt(BILL_ID));
		adviceDispHeader.setBillDispensing(dispensingHeader);
		dataMap.put("billId", box.getInt(BILL_ID));
//later I will Add
		/*BigDecimal totalAdvAmt = new BigDecimal(box
				.getString(TOTAL_ADVICE_AMOUNT));
		adviceDispHeader.setTotalAdviceAmt(totalAdvAmt);
		dataMap.put("adviceAmt", totalAdvAmt);*/
		dataMap.put("adviceAmt", new BigDecimal(100.00));
		
		// end
		
		String cashAdvAmt = box.getString(CASH_ADVICE_AMOUNT);

		if (!cashAdvAmt.equals("")) {
			adviceDispHeader.setCashAdviceAmt(new BigDecimal(cashAdvAmt));
		}
		String onAccAmt = box.getString(PAST_DUE_ADJUSTED);
		if (!onAccAmt.equals("")) {
			adviceDispHeader.setOnAccountAmt(new BigDecimal(onAccAmt));
		}
		String charityAmt = box.getString(TOTAL_CHARITY_AMOUNT);
		if (!charityAmt.equals("")) {
			adviceDispHeader
					.setTotalAdviceCharityAmt(new BigDecimal(charityAmt));
		}
		adviceDispHeader.setPaymentAdviceDate(HMSUtil
				.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));

		adviceDispHeader.setPaymentAdviceTime(box.getString(CHANGED_TIME));
		
		/*adviceDispHeader.setLastChgBy(box.getString(CHANGED_BY));*/

		dataMap.put("adviceDispHeader", adviceDispHeader);

		BigDecimal pastDues = new BigDecimal(0);
		String pastDueStr = box.getString(PAST_DUE_ADJUSTED);
		if (!pastDueStr.equals("")) {
			pastDues = new BigDecimal(pastDueStr);
			dataMap.put("pastDues", pastDues);
		}

		int chargeListLength = 0;
		chargeListLength = box.getInt("chargeListLength");

		for (int i = 1; i < chargeListLength; i++) {
			int batchId = box.getInt(BATCH_ID + i);
			if (batchId != 0) {
				batchIdList.add(batchId);
				itemIdList.add(box.getInt(ITEM_ID + i));
				qtyList.add(box.getString(QUANTITY + i));
				adviceAmtList.add(box.getString(ADVICE_AMOUNT + i));
				adviceCharityAmtList.add(box.getString("adviceCharity" + i));
				billDtIdList.add(box.getInt("dispensingDtId" + i));

				dataMap.put("batchIdList", batchIdList);
				dataMap.put("itemIdList", itemIdList);
				dataMap.put("qtyList", qtyList);
				dataMap.put("adviceAmtList", adviceAmtList);
				dataMap.put("adviceCharityAmtList", adviceCharityAmtList);
				dataMap.put("billDtIdList", billDtIdList);
			}
		}
		map = opBillingHandlerService
				.submitPaymentAdviceDispensingDetails(dataMap);

		boolean flag = false;
		String message = "";
		flag = (Boolean) map.get("flag");
		if (flag) {
			message = "Record Saved Successfully!";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		String jsp = "";
		jsp = "searchBillPaymentAdviceDispensing" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showCashRefundSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = opBillingHandlerService.getHospitalParameterForDispensing();
		String jsp = BILL_CASH_REFUND_PATIENT_SEARCH_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAdviceRepJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = opBillingHandlerService.getHospitalParameterForDispensing();
		String jsp = BILL_CASH_ADVICE_PATIENT_SEARCH_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getBillNoForRefund(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String billType = "";
		String flag = "";
		Box box = HMSUtil.getBox(request);
		billType = box.getString(BILL_TYPE);
		flag = box.getString("flag");
		String patientType = box.getString(PATIENT_TYPE);
		map = opBillingHandlerService.getBillNoForRefund(box);
		String jsp = "";
		jsp = BILLING_RESPONSE_FOR_BILL_NO_JSP;
		map.put("billType", billType);
		map.put("flag", flag);
		map.put("patientType", patientType);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getPaymentAdviceNoForCashRefund(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		String billType = "";
		String hin = "";
		String billNo = "";
		Box box = HMSUtil.getBox(request);
		billType = box.getString(BILL_TYPE);
		hin = box.getString(HIN_NO);
		billNo = box.getString(BILL_NO);
		parameterMap.put("billType", billType);
		parameterMap.put("hin", hin);
		parameterMap.put("billNo", billNo);
		map = opBillingHandlerService
				.getPaymentAdviceNoForCashRefund(parameterMap);
		String jsp = "";
		jsp = BILLING_RESPONSE_FOR_PYMT_ADVICE_NO_JSP;
		map.put("billType", billType);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getPaymentAdviceNoForAdviceRep(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		String jsp = "";
		String billType = "";
		String hin = "";
		String billNo = "";
		Box box = HMSUtil.getBox(request);
		billType = box.getString(BILL_TYPE);
		hin = box.getString(HIN_NO);
		billNo = box.getString(BILL_NO);
		parameterMap.put("billType", billType);
		parameterMap.put("hin", hin);
		/*parameterMap.put("billNo", billNo);*/
		map = opBillingHandlerService.getPaymentAdviceNoForAdviceRep(parameterMap);
		
		jsp = BILLING_RESPONSE_FOR_PYMT_ADVICE_REP_JSP;
		map.put("billType", billType);
		return new ModelAndView(jsp, "map", map);
	}

	/**
	 * Methods for report printing
	 */
	public ModelAndView printBillReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String billNo = "";
		String billType = "";
		String loginName = "";
		HttpSession session = request.getSession();

		Users user = new Users();
		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");
			loginName = user.getLoginName();
		}
		if (request.getParameter("billNo") != null) {
			billNo = request.getParameter("billNo");
		}
		if (request.getParameter("billType") != null) {
			billType = request.getParameter("billType");
		}
		detailsMap = opBillingHandlerService.getConnectionForReport();
		parameters.put("billNo", billNo);
		parameters.put("loginname", loginName);
		String reportName = "";
		if (billType.equals("servicing")) {
			reportName = "Servicing_Bill";
		} else if (billType.equals("dispensing")) {
			reportName = "Bill_Printing_Dispensing";
		}
		HMSUtil.generateReport(reportName, parameters, (Connection) detailsMap
				.get("conn"), response, getServletContext());
		return null;
	}

	public ModelAndView getDetailsForCashRefund(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);
		String refundNo = billingHandlerService.generateRefundNo("display",hospitalId);
		System.out.println("---"+refundNo);
		map = opBillingHandlerService.getDetailsForCashRefund(box);
		map.put("refundNo", refundNo);
		String jsp = "";
		if (map.get("message") == null) {
			jsp = "billCashRefund.jsp";
		} else {
			jsp = "billCashRefund"+ ".jsp";
		}
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/*public ModelAndView printPaymentAdviceRep(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String advice_no = "";
		String billType = "";
		String loginName = "";
		HttpSession session = request.getSession();

		Users user = new Users();
		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");
			loginName = user.getLoginName();
		}
		if (request.getParameter(PAYMENT_ADVICE_NO) != null) {
			advice_no = request.getParameter(PAYMENT_ADVICE_NO);
		}

		if (request.getParameter("billType") != null) {
			billType = request.getParameter("billType");
		}

		detailsMap = opBillingHandlerService.getConnectionForReport();
		parameters.put("advice_no", advice_no);
		parameters.put("loginname", loginName);
		String reportName = "";
		if (billType.equals("servicing")) {
			reportName = "service_advice_rep";


		} else if (billType.equals("dispensing")) {
			reportName = "disp_advice_rep";

		}

		HMSUtil.generateReport(reportName, parameters, (Connection) detailsMap
				.get("conn"), response, getServletContext());
		return null;
	}*/

	/*public ModelAndView printPaymentAdviceRep(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String advice_no = "";
		String billType="";
		String reportName="";

		if (request.getParameter(PAYMENT_ADVICE_NO) != null) {
			advice_no = request.getParameter(PAYMENT_ADVICE_NO);
		}

		if (request.getParameter("billType") != null) {
			billType = request.getParameter("billType");
		}
		HttpSession session = request.getSession();
		String loginName = "";
		Users user = new Users();
		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");
			loginName = user.getLoginName();
		}

		detailsMap = opBillingHandlerService.getConnectionForReport();


		if(billType.equals("servicing"))
		{
			reportName="service_advice_rep";
			parameters.put("advice_no", advice_no);
			parameters.put("loginname", loginName);
		}else if(billType.equals("servicing"))
		{
			reportName="disp_advice_rep";
		parameters.put("advice_no", advice_no);
		parameters.put("loginname", loginName);
		}

		try {
			HMSUtil.generateReport(reportName, parameters, (Connection) detailsMap
					.get("conn"), response, getServletContext());
		} catch (IllegalStateException e) {

			e.printStackTrace();
		}
		return null;

	}
*/
	public ModelAndView submitCashRefundDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		String charityTransferId="";
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}

       if (request.getParameter("charityTransferId") != null) {
			charityTransferId = request
					.getParameter("charityTransferId");
		}
		System.out.println("box"+charityTransferId);
		box.put("charityTransferId", charityTransferId);

		String refundNo = billingHandlerService.generateRefundNo("save", hospitalId);
		box.put("refundNo", refundNo);
		boolean flag = false;
		flag = opBillingHandlerService.submitCashRefundDetails(box);
		String message = "";
		String printUrl = "";
		if (flag == true) {
			printUrl = "submitForm('messageBilling','billing?method=printRefundReport&textfield="
					+ refundNo + "')";
			map.put("printUrl", printUrl);
			message = "Record saved successfully! Do you want to print?";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		String jsp = MESSAGE_FOR_BILLING_JSP + ".jsp";
		map.put("billtype", "refunds");
		map.put("billNo", refundNo);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// Reports-------------------------------

	public ModelAndView showPatientBillingReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "patientBillingReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getVisitNoForReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = opBillingHandlerService.getVisitNo(box);
		String jsp = "responseForVisitNo";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showCashCollectionStatisticsReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String requiredPara = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapHP = new HashMap<String, Object>();
		map = opBillingHandlerService.getDetailsForCashStatisticsReport();
		mapHP = opBillingHandlerService.getHospitalParameterForDispensing();
		if(mapHP.get("dispensingRequired") != null)
		{
			requiredPara = (String)mapHP.get("dispensingRequired");
		}
		map.put("dispensingRequired", requiredPara);
		String jsp = "cashCollectionStatisticsReport.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printPatientBillingReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		detailsMap = billingHandlerService.getConnectionForReport();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		parameters.put("hospitalId",hospitalId);
		String reportName = "";
		if (!box.getString(AD_NO).equals("")) {
			reportName = "IPPatientDetailedBilling";
			parameters.put("adNo", box.getString(AD_NO));
		} else {
			
			reportName = "OPPatientDetailedBilling";
			parameters.put("hinNo", box.getString(HIN_NO));
		}
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/Reports/"));
		HMSUtil.generateReport(reportName, parameters, (Connection) detailsMap
				.get("conn"), response, getServletContext());
		return null;

	}

	public ModelAndView printCashCollectionStatisticsReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		String hospitalName = billingHandlerService.getHospitalName(hospitalId);
		detailsMap = billingHandlerService.getConnectionForReport();
		String fromDate = "";
		String toDate = "";
		String criteria = "";
		String reportName = "";
		int fromYear = 0;
		int toYear = 0;

		if (box.getString("reportType").equals("1")) {
			fromDate = box.getString(FROM_DATE);
			toDate = box.getString(TO_DATE);
			String splitDate[] = fromDate.split("/");
			fromDate = splitDate[0] + "" + splitDate[1] + "" + splitDate[2];
			int cashColFromMonth = Integer.parseInt(fromDate.substring(2, 4));
			int cashColFromYear = Integer.parseInt(fromDate.substring(4, 8));

			String cashColFromDate = "01/" + cashColFromMonth + "/"
					+ cashColFromYear;

			String splitDate1[] = toDate.split("/");
			toDate = splitDate1[0] + "" + splitDate1[1] + "" + splitDate1[2];
			int cashColToMonth = Integer.parseInt(toDate.substring(2, 4));
			int cashColToYear = Integer.parseInt(toDate.substring(4, 8));

			String cashColToDate = "";
			if (cashColToMonth == 1 || cashColToMonth == 3
					|| cashColToMonth == 5 || cashColToMonth == 7
					|| cashColToMonth == 8 || cashColToMonth == 10
					|| cashColToMonth == 12) {
				cashColToDate = "31/" + cashColToMonth + "/" + cashColToYear;
			} else if (cashColToMonth == 4 || cashColToMonth == 6
					|| cashColToMonth == 9 || cashColToMonth == 11) {
				cashColToDate = "30/" + cashColToMonth + "/" + cashColToYear;
			} else if (cashColToMonth == 2) {
				cashColToDate = "28/" + cashColToMonth + "/" + cashColToYear;
			}
			criteria="";
			if (box.getString("billType").equals("1")) {
				if (box.getInt(MAIN_CHARGECODE_ID) != 0) {
					criteria = "where  scnd.mainChargeId = "
							+ box.getInt(MAIN_CHARGECODE_ID);
				}
				reportName = "CashCollectionStatisticsMonthlyServicing";

			} else if (box.getString("billType").equals("2")) {
				if (box.getInt(ITEM_CATEGORY_ID) != 0) {
					criteria = " where  scnd.itemCatId = "
							+ box.getInt(ITEM_CATEGORY_ID);
				}
				reportName = "CashCollectionStatisticsMonthly";
			}
			parameters.put("fmonthyear", HMSUtil
					.convertStringTypeDateToDateType(cashColFromDate));
			parameters.put("tmonthyear", HMSUtil
					.convertStringTypeDateToDateType(cashColToDate));

		} else if (box.getString("reportType").equals("2")) {

			fromYear = box.getInt("fromYear");
			toYear = box.getInt("toYear");

			if (box.getString("billType").equals("1")) {
				if (box.getInt(MAIN_CHARGECODE_ID) != 0) {
					criteria = " and scnd.mainChargeId = "
							+ box.getInt(MAIN_CHARGECODE_ID);
				}
				reportName = "CashCollectionStatisticsYearlyServicing";

			} else if (box.getString("billType").equals("2")) {
				if (box.getInt(ITEM_CATEGORY_ID) != 0) {
					criteria = " and scnd.itemCatId = "
							+ box.getInt(ITEM_CATEGORY_ID);
				}
				reportName = "CashCollectionStatisticsYearly";
			}
			parameters.put("fyear", fromYear);
			parameters.put("tyear", toYear);
			
		}
		parameters.put("criteria", criteria);
		parameters.put("Hname", hospitalName);
		parameters.put("hospitalId", hospitalId);
		HMSUtil.generateReport(reportName, parameters, (Connection) detailsMap
				.get("conn"), response, getServletContext());

		return null;
	}

	public void checkBatchNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String message = "";
		StringBuffer sb = new StringBuffer();
		map = opBillingHandlerService.checkBatchNoForIssue(box);
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}
		try {
			sb.append("<item>");
			if (map.get("message") != null) {
				sb.append("<message>" + message + "</message>");
			} else {
				sb.append("<message>" + " " + "</message>");
			}
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

	public ModelAndView issueItemBatchFromPharmacy(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		map = opBillingHandlerService.issueItemBatchFromPharmacy(box);
		box.put("dispensType", "pending");
		String msg = "";
		if ((Boolean) map.get("flag") == true) {
			msg = "Item Issued.";
		} else {
			msg = "Try Again!";
		}
		map.put("message", msg);
		detailsMap = billingHandlerService.getPharmacySalesDetails(box);
		if (detailsMap.get("dispensingDetailsList") != null) {
			map.put("dispensingDetailsList", detailsMap
					.get("dispensingDetailsList"));
		}
		String jsp = "pharmacySalesViewSearch.jsp";
		map.put("includedJsp", "pharmacySalesView.jsp");
		map.put("contentJsp", jsp);
		map.put("pageNo", Integer.parseInt(request.getParameter("pageEditNo")));
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitTemporaryBillServicingDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();

		int hospitalId = 0;
		Users user = new Users();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}

		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
			box.put("userName", userName);
		}

		map = opBillingHandlerService.submitTemporaryBillServicingDetails(box);
		boolean saved = false;
		String tempBillNo = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (map.get("tempBillNo") != null) {
			tempBillNo = (String) map.get("tempBillNo");
		}
		String message = "";
		if (saved) {
			message = "Temporary Billing has been done successfully!! Temporary Bill No is "
					+ tempBillNo + ".";

		} else {
			message = "Try Again!";
		}
		map.put("message", message);

		String jsp = MESSAGE_FOR_BILLING_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitTemporaryBillDispensingDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();

		int hospitalId = 0;
		Users user = new Users();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}

		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
			box.put("userName", userName);
		}

		map = opBillingHandlerService.submitTemporaryBillDispensingDetails(box);
		boolean saved = false;
		String tempBillNo = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (map.get("tempBillNo") != null) {
			tempBillNo = (String) map.get("tempBillNo");
		}
		String message = "";
		if (saved) {
			message = "Temporary Billing has been done successfully!! Temporary Bill No is "
					+ tempBillNo + ".";

		} else {
			message = "Try Again!";
		}
		map.put("message", message);

		String jsp = MESSAGE_FOR_BILLING_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showCompanySettlementJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		map = billingHandlerService.getCompanyList();
		String jsp = "billCompanySettlement.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getCompanyPatientListForSettlement(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> compMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		compMap = billingHandlerService.getCompanyList();
		map = opBillingHandlerService.getCompanyPatientListForSettlement(box);
		if (compMap.get("companyList") != null) {
			map.put("companyList", compMap.get("companyList"));
		}
		String jsp = "billResponseForCompSettlement";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitCompanySettlementDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> compMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Box box = HMSUtil.getBox(request);
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			box.put("userId", users.getId());
		}
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}

		map = opBillingHandlerService.submitCompanySettlementDetails(box);
		boolean saved = false;
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		String message = "";
		if (saved) {
			message = "Record saved successfully.";
		} else {
			message = "Try Again.";
		}
		map.put("message", message);
		compMap = billingHandlerService.getCompanyList();
		if (compMap.get("companyList") != null) {
			map.put("companyList", compMap.get("companyList"));
		}
		String jsp = "billCompanySettlement.jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPopUpForReportApplet(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String billNo = box.getString("billNo");
		String billtype = box.getString("billtype");
		map.put("billNo", billNo);
		map.put("billtype", billtype);
		String jsp = "appletJsp";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getTemplateDetailsForBilling(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		map = opBillingHandlerService.getTemplateDetailsForBilling(box);
		String jsp = "";
		jsp = "billingResponseForTemplate";
		map.put("registrationType", box.getString("registrationType"));
		map.put("hin", box.getInt(HIN_ID));
		map.put("type", box.getString("type"));
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showDailyChargeProcessJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		map = opBillingHandlerService.showDailyChargeProcessJsp();
		String jsp = "dailyChargeProcess.jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView scheduledBillDetail(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map = opBillingHandlerService.scheduledBillDetail();
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView scheduledDailyChargeEntry(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			dataMap.put("userId", users.getId());
		}
		Date processDate = null;
		if(request.getParameter("processDate") != null){
			processDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("processDate"));
			dataMap.put("processDate", processDate);
		}
		String userName = (String) session.getAttribute("userName");
		dataMap.put("userName", userName);

		map = opBillingHandlerService.scheduledDailyChargeEntry(dataMap);

		return new ModelAndView("index","map",map);
	}

	
	public ModelAndView fillChargeCodeForOtPostAnethisia(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String rowVal = request.getParameter("rowVal");
		int hinId = 0;
		String chargeDiscription = "";
		if (request.getParameter("hin") != null) {
			hinId = Integer.parseInt(request.getParameter("hin"));
		}
		if (request.getParameter("charge" + rowVal) != null) {
			chargeDiscription = request.getParameter("charge" + rowVal);
		}
		Integer index1 = 0;
		index1 = chargeDiscription.lastIndexOf("[") + 1;

		int index2 = chargeDiscription.lastIndexOf("]");
		String chargeCode = chargeDiscription.substring(index1, index2);
		map = opBillingHandlerService.getChargeCodeDetailsForOTPostAnethisia(chargeCode, hinId);

		String jsp = "";
		jsp = OT_POST_ANETHISIA_BILLING_RESPONSE_JSP;
		
		map.put("rowVal", rowVal);
		map.put("contentJsp", jsp);
		map.put("type", request.getParameter("type"));
		return new ModelAndView(jsp, "map", map);

	}
	public ModelAndView searchAdviceDispensing(HttpServletRequest request,
			HttpServletResponse response) {
	
		Map<String, Object> map1 = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		
		int sessionHospitalId = 0;
		
		sessionHospitalId = (Integer)session.getAttribute("hospitalId");
		
		Box box = HMSUtil.getBox(request);
	
		box.put("sessionHospitalId",sessionHospitalId);
		map1= opBillingHandlerService.searchAdviceDispensing(box);
		
		String jsp = "billPaymentAdviceDispensing" + ".jsp";
		
		map1.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map1);
	}
	
	public ModelAndView getBillDispensingDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
//		List<IpWardConsumptionDetails> ipWardConsumptionDetailList=new ArrayList<IpWardConsumptionDetails>();
		List<Object[]> ipWardConsumptionDetailList=new ArrayList<Object[]>();
		List<Object[]> consumptionDetailList=new ArrayList<Object[]>();
		boolean saved = false;
		int hospitalId = 0;
		int schemeId = 0;
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		if (request.getParameter(HIN_ID) != null && !request.getParameter(HIN_ID).equals("")) {
			box.put(HIN_ID,  Integer.parseInt(request.getParameter(HIN_ID)));
		}
		
		if (request.getParameter(INPATIENT_ID) != null && !request.getParameter(INPATIENT_ID).equals("")) {
			box.put(INPATIENT_ID,  Integer.parseInt(request.getParameter(INPATIENT_ID)));
		}
		
		if (request.getParameter(RequestConstants.ITEM_ID) != null && !request.getParameter(RequestConstants.ITEM_ID).equals("")) {
			box.put(RequestConstants.ITEM_ID,  Integer.parseInt(request.getParameter(RequestConstants.ITEM_ID)));
		}
		
		if (request.getParameter("schemeList") != null && !request.getParameter("schemeList").equals("")) {
			box.put("schemeId",  Integer.parseInt(request.getParameter("schemeList")));
		}
		

		map = opBillingHandlerService.getInpatientBilDispensingDetail(box);
		if(map.get("ipWardConsumptionDetailList")!=null)
			{
			ipWardConsumptionDetailList=(List<Object[]>) map.get("ipWardConsumptionDetailList");
			}
		Iterator<Object[]> iterator=ipWardConsumptionDetailList.iterator();
		while (iterator.hasNext()) {
			Object[] ipWardConsumptionDetails = (Object[]) iterator
					.next();
			box.put("itemCode", ipWardConsumptionDetails[1]);
			Map<String,Object> discounts=new HashMap<String,Object>();
			discounts=opBillingHandlerService.getItemDiscount(box);
			BigDecimal discAmt = new BigDecimal(0);
			BigDecimal discPercnt = new BigDecimal(0);
			BigDecimal fixedAmount = new BigDecimal(0);
			String discountType="";
			if(discounts.get("discountType")!=null)
			{
				discountType=(String)discounts.get("discountType");
				discAmt=(BigDecimal) discounts.get("discAmt");
				discPercnt=(BigDecimal) discounts.get("discPercnt");
				fixedAmount=(BigDecimal) discounts.get("fixedAmount");
				if(discountType.equalsIgnoreCase("t"))
				{
					BigDecimal discount=new BigDecimal(0.00);
					discount=(new BigDecimal(ipWardConsumptionDetails[4].toString()).multiply(discPercnt)).divide(new BigDecimal(100));
					ipWardConsumptionDetails[5]=new BigDecimal(ipWardConsumptionDetails[4].toString()).subtract(discount);
				}
				else if(discountType.equalsIgnoreCase("d"))
				{
					BigDecimal discount=new BigDecimal(0.00);
					if(discAmt.compareTo(BigDecimal.ZERO)>0)
					{
					discount=new BigDecimal(ipWardConsumptionDetails[3].toString()).multiply(discAmt);
					if(discount.compareTo(new BigDecimal(ipWardConsumptionDetails[4].toString()))>=0)
					{
						ipWardConsumptionDetails[5]=new BigDecimal(0.00);
						ipWardConsumptionDetails[6]=100;
						ipWardConsumptionDetails[7]=ipWardConsumptionDetails[4];
					}
					else
					{
						ipWardConsumptionDetails[5]=new BigDecimal(ipWardConsumptionDetails[4].toString()).subtract(discount);
						ipWardConsumptionDetails[6]=(discount.multiply(new BigDecimal(0.00))).divide(new BigDecimal(ipWardConsumptionDetails[4].toString()));
						ipWardConsumptionDetails[7]=discount;
					}
					}
					else if(discPercnt.compareTo(BigDecimal.ZERO)>0){
						discount=(new BigDecimal(ipWardConsumptionDetails[4].toString()).multiply(discPercnt)).divide(new BigDecimal(100));
						ipWardConsumptionDetails[5]=new BigDecimal(ipWardConsumptionDetails[4].toString()).subtract(discount);
						ipWardConsumptionDetails[6]=discPercnt;
						ipWardConsumptionDetails[7]=discount;


					}
				}
				else if(discountType.equalsIgnoreCase("f"))
				{
					ipWardConsumptionDetails[5]=new BigDecimal(ipWardConsumptionDetails[3].toString()).multiply(fixedAmount);
				}
			}
			//map.put("item"+ipWardConsumptionDetails[0], opBillingHandlerService.getItemDiscount(box));
		}
		String jsp = "getBillDispensingDetail";
		
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView searchPatientForAdvanceTransfer(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		hospitalId = (Integer) session.getAttribute("hospitalId");
		Box box = HMSUtil.getBox(request);
		box.put(RequestConstants.HOSPITAL_ID, hospitalId);
		map = opBillingHandlerService.searchPatientForAdvanceTransfer(box); 
		String jsp = "patientAdvanceTransfer" + ".jsp"; 
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	//-----------------------code by anamika---------------------------------------------------
	public ModelAndView showPatientAdvanceJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		hospitalId = (Integer) session.getAttribute("hospitalId");
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = opBillingHandlerService.searchPatientForAdvance(box); 
		String jsp = "searchForPatientAdvance" + ".jsp"; 
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView getPatientDetailsForPatientAdvance(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		hospitalId = (Integer) session.getAttribute("hospitalId");
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = opBillingHandlerService.getPatientDetailsForPatientAdvance(box);
		String jsp = "patientAdvanceMemberDetail" + ".jsp"; 
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView getMemberDetailsForPatientAdvance(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		hospitalId = (Integer) session.getAttribute("hospitalId");
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = opBillingHandlerService.getMemberDetailsForPatientAdvance(box);
		String jsp = "patientAdvance" + ".jsp"; 
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView getPatientTransferDetail(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		hospitalId = (Integer) session.getAttribute("hospitalId");
		Box box = HMSUtil.getBox(request);
		box.put(RequestConstants.HOSPITAL_ID, hospitalId);
		map = opBillingHandlerService.searchPatientForAdvanceTransfer(box); 
		String jsp = "patientAdvanceFamilyNCharity" + ".jsp"; 
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView submitPatientAdvanceFamilyNCahrity(
			HttpServletRequest request, HttpServletResponse response) { 
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId=0;
		
		hospitalId = (Integer) session.getAttribute("hospitalId");
		userId = (Integer) session.getAttribute(RequestConstants.USER_ID);
		Box box = HMSUtil.getBox(request);
		box.put(RequestConstants.HOSPITAL_ID, hospitalId);
		box.put(RequestConstants.USER_ID, userId);
		boolean flag=false;
		
		flag=opBillingHandlerService.submitPatientAdvanceFamilyNCahrity(box);
		map = opBillingHandlerService.searchPatientForAdvanceTransfer(box); 
		if(flag){
			map.put("message", "Transfer Done Successfully");
		}else{
			map.put("message", "Tray Again");
		}
		String jsp = "patientAdvanceTransfer" + ".jsp"; 
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	} 
	
	/*
	 * By Ujjwal For Unserviced Service Report
	 * 
	 */
	public ModelAndView showUnsevicedServiceReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "bl_Unserviced_Service_Report";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView	printUnservicedServiceReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		detailsMap = accountHandlerService.getConnectionForReport();
		Date fromDate=new Date();
		int hospitalId=0;
		HttpSession session=request.getSession();
		if(session.getAttribute("hospitalId")!=null){
			hospitalId=(Integer)session.getAttribute("hospitalId");
		}
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));

		}
		
		Date toDate=new Date();
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));

		}
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("hospitalId", hospitalId);
		HMSUtil.generateReport("unserviced_Service_Report", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}
	public ModelAndView showSchemeWiseStatisticsJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String requiredPara = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapHP = new HashMap<String, Object>();
		map = opBillingHandlerService.getSchemeWiseStatisticsJsp();

		map.put("dispensingRequired", requiredPara);
		String jsp = "schemeWiseBillingStatistics.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printReportForSchemeWiseBillingStat(
			HttpServletRequest request, HttpServletResponse response) {
		int schemeId=0;
		int patientCategoryId=0;
		Date fromDate=new Date();
		Date toDate=new Date();
		int hospitalId=0;
		String hinNo="";
		if(request.getParameter(HIN_NO)!=null && !request.getParameter(HIN_NO).equals(""))
		{
			hinNo=(request.getParameter(HIN_NO));
		}
		int hinId=0;
		if(hinNo!=null && !"".equals(hinNo)){
		hinId=opBillingHandlerService.gewtHinId(hinNo);
		}
		
		HttpSession session=request.getSession();
		if(session.getAttribute("hospitalId")!=null){
			hospitalId=Integer.parseInt(""+session.getAttribute("hospitalId"));
		}
		if(request.getParameter("schemeName")!=null && !request.getParameter("schemeName").equals("0"))
		{
			schemeId=Integer.parseInt(request.getParameter("schemeName"));
		}
		if(request.getParameter("")!=null && !request.getParameter("").equals(""))
		{
			
		}
		if(request.getParameter(FROM_DATE)!=null )
		{
			fromDate=HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if(request.getParameter(TO_DATE)!=null )
		{
			toDate=HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = accountHandlerService.getConnectionForReport();
		
		if(hinId!=0){
			parameters.put("fromDate", fromDate);
			parameters.put("toDate", toDate);
			parameters.put("hospitalId", hospitalId);
			parameters.put("hinId", hinId);
			//parameters.put("schemeId", schemeId);
			HMSUtil.generateReport("scheme_Wise_Billing_statistics_patient", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		}else{
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("hospitalId", hospitalId);
		parameters.put("schemeId", schemeId);
		HMSUtil.generateReport("scheme_Wise_Billing_statistics", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		}
		return null;
		
	}
	
	
	
	// added by amit das on 11-05-2017
	public ModelAndView showOpOrderBookingSearchJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = null;
		String patientType="OP";
		String ipNumber=null;
		Integer hospitalId = 0;
		String uhid=null;
		
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		
		if(request.getParameter("uhid")!=null){
			 uhid=(String) request.getParameter("uhid");
		}
		if(request.getParameter("labType")!=null){
			patientType=(String) request.getParameter("labType");
		}
		if(request.getParameter("ipNo")!=null){
			ipNumber=(String) request.getParameter("ipNo");
		}
		System.out.println("patientType "+patientType);
		map.put("uhid", uhid);
		map.put("hospitalId", hospitalId);
		map.put("billingScreen", "y");
		map.put("patientType", patientType);
		map.put("ipNumber", ipNumber);
		
		map=labHandlerService.getPatientDetailGrid(map);
		String jsp = DG_OP_ORDER_BOOKING_SEARCH_JSP;
		jsp += ".jsp";
		
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("billingScreen", "y");
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView displayOrderNoWithOutResultEntry(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		
		
		if(request.getParameter("hinNo") != null){
			String hinNo = request.getParameter("hinNo");
			box.put("hinNo", hinNo);
		}
		map = opBillingHandlerService.displayOrderNoWithOutResultEntry(box);
	
		String jsp = "responseForOrderNo";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getPatientName(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		
		
		if(request.getParameter("hinNo") != null){
			String hinNo = request.getParameter("hinNo");
			box.put("hinNo", hinNo);
		}
		map = opBillingHandlerService.getPatientName(box);
	
		String jsp = "patient";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	
	/**
	 * Getters & Setters of OpBillingHandlerService
	 *
	 */

	public OpBillingHandlerService getOpBillingHandlerService() {
		return opBillingHandlerService;
	}

	public void setOpBillingHandlerService(
			OpBillingHandlerService opBillingHandlerService) {
		this.opBillingHandlerService = opBillingHandlerService;
	}

	public LabHandlerService getLabHandlerService() {
		return labHandlerService;
	}

	public void setLabHandlerService(LabHandlerService labHandlerService) {
		this.labHandlerService = labHandlerService;
	}

	public AccountHandlerService getAccountHandlerService() {
		return accountHandlerService;
	}

	public void setAccountHandlerService(
			AccountHandlerService accountHandlerService) {
		this.accountHandlerService = accountHandlerService;
	}

	public BillingHandlerService getBillingHandlerService() {
		return billingHandlerService;
	}

	public void setBillingHandlerService(
			BillingHandlerService billingHandlerService) {
		this.billingHandlerService = billingHandlerService;
	}

	

}
