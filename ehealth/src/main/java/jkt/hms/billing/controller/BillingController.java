/*** Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * BillingController.java �
 * Purpose of the class - This is for OP Billing.
 * @author  Ritu Sahu
 * Create Date: 1st Apr,2008
 * Revision Date:
 * Revision By: Purpose
 * @version 1.0
 **/

package jkt.hms.billing.controller;

import static jkt.hms.util.RequestConstants.ACCOUNT_TYPE;
import static jkt.hms.util.RequestConstants.ADVANCE_ADJUSTMENT;
import static jkt.hms.util.RequestConstants.ADVANCE_ADJUSTMENT_REPORT_JSP;
import static jkt.hms.util.RequestConstants.AD_NO;
import static jkt.hms.util.RequestConstants.AGE;
import static jkt.hms.util.RequestConstants.AUTHORIZER_ID;
import static jkt.hms.util.RequestConstants.AUTHORIZER_WISE_REPORT_JSP;
import static jkt.hms.util.RequestConstants.BILLING_FINAL_SETTLEMENT_JSP;
import static jkt.hms.util.RequestConstants.BILLING_REGISTER_JSP;
import static jkt.hms.util.RequestConstants.BILLING_RESPONSE_FOR_CHARGE_CODE_GRID_JSP;
import static jkt.hms.util.RequestConstants.BILLING_RESPONSE_FOR_ORDER_NO_JSP;
import static jkt.hms.util.RequestConstants.BILL_AMOUNT;
import static jkt.hms.util.RequestConstants.BILL_CHARGE_CODE_DETAILS_POP_UP_JSP;
import static jkt.hms.util.RequestConstants.BILL_DISPENSING_FOR_IP_JSP;
import static jkt.hms.util.RequestConstants.BILL_PAYMENT_ADVICE_CHARGESLIP_JSP;
import static jkt.hms.util.RequestConstants.BILL_PAYMENT_ADVICE_DISPENSING_JSP;
import static jkt.hms.util.RequestConstants.BILL_PAYMENT_ADVICE_SEARCH_For_Service_JSP;
import static jkt.hms.util.RequestConstants.BILL_TYPE;
import static jkt.hms.util.RequestConstants.CASH_COLLECTION_REPORT_JSP;
import static jkt.hms.util.RequestConstants.CASH_SALE_REPORT_JSP;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CHARITY_REGISTER_IP_OP_REPORT_JSP;
import static jkt.hms.util.RequestConstants.COMPANY_WISE_REPORT_JSP;
import static jkt.hms.util.RequestConstants.Charity_Details_jsp;
import static jkt.hms.util.RequestConstants.DAILY_CASH_REPORT_JSP;
import static jkt.hms.util.RequestConstants.DAILY_SHIFT_CHANGE_CASH_REPORT_SUMMARY_JSP;
import static jkt.hms.util.RequestConstants.DAY_END_REPORT_JSP;
import static jkt.hms.util.RequestConstants.DEPARTMENT;
import static jkt.hms.util.RequestConstants.DEPARTMENT_WISE_CASH;
import static jkt.hms.util.RequestConstants.DEPOSITS_JSP;
import static jkt.hms.util.RequestConstants.DETAILED_OP_BILLING_REPORT_JSP;
import static jkt.hms.util.RequestConstants.DISCOUNT_AMOUNT;
import static jkt.hms.util.RequestConstants.DISCOUNT_ON_BILL;
import static jkt.hms.util.RequestConstants.DOCTOR_PERFORMANCE_JSP;
import static jkt.hms.util.RequestConstants.EMPLOYEE_ID;
import static jkt.hms.util.RequestConstants.EMPLOYEE_WISE_BILLING_REPORT_JSP;
import static jkt.hms.util.RequestConstants.FINAL_BILL_PATIENT_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.FROM_TIME;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.IP_BILLING_PATIENT_DETAILS_JSP;
import static jkt.hms.util.RequestConstants.IP_BILLING_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.IP_FINAL_BILL_JSP;
import static jkt.hms.util.RequestConstants.LOGIN_NAME;
import static jkt.hms.util.RequestConstants.MESSAGE_FOR_BILLING_JSP;
import static jkt.hms.util.RequestConstants.MIN_AMOUNT;
import static jkt.hms.util.RequestConstants.OPD_Statistical_Data;
import static jkt.hms.util.RequestConstants.OUTSTANDING;
import static jkt.hms.util.RequestConstants.PAST_DUES_JSP;
import static jkt.hms.util.RequestConstants.PATIENT_LIST_JSP;
import static jkt.hms.util.RequestConstants.PATIENT_NAME;
import static jkt.hms.util.RequestConstants.PATIENT_TYPE;
import static jkt.hms.util.RequestConstants.PATIENT_TYPE_ID;
import static jkt.hms.util.RequestConstants.PAYABLE_AMOUNT;
import static jkt.hms.util.RequestConstants.PAYMENT_ADVICE_NO;
import static jkt.hms.util.RequestConstants.PROJECT_BILLING_BOTH_SUMMARY_REPORT_JSP;
import static jkt.hms.util.RequestConstants.PROJECT_ID;
import static jkt.hms.util.RequestConstants.P_FIRST_NAME;
import static jkt.hms.util.RequestConstants.P_LAST_NAME;
import static jkt.hms.util.RequestConstants.P_MIDDLE_NAME;
import static jkt.hms.util.RequestConstants.RETRIVE_PAST_DUE;
import static jkt.hms.util.RequestConstants.ROUND_OF_VALUE;
import static jkt.hms.util.RequestConstants.SEARCH_PATIENT_FOR_ADVANCE_JSP;
import static jkt.hms.util.RequestConstants.SEARCH_PATIENT_FOR_FINAL_SETTLEMENT_JSP;
import static jkt.hms.util.RequestConstants.SEARCH_PATIENT_FOR_IP_BILL_DISPENSING_JSP;
import static jkt.hms.util.RequestConstants.SEX_ID;
import static jkt.hms.util.RequestConstants.SHIFT_CHANGE_OVER_REPORT_DETAIL_JSP;
import static jkt.hms.util.RequestConstants.TOTAL_AMOUNT;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.TO_TIME;
import static jkt.hms.util.RequestConstants.VIEW_PRESCRIPTION_FOR_ORDER_BOOKING;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.account.handler.AccountHandlerService;
import jkt.hms.billing.handler.BillingHandlerService;
import jkt.hms.billing.handler.OpBillingHandlerService;
import jkt.hms.ipd.handler.IPDHandlerService;
import jkt.hms.lab.handler.LabHandlerService;
import jkt.hms.masters.business.BlChargeSlipDetail;
import jkt.hms.masters.business.BlDispensingHeader;
import jkt.hms.masters.business.BlFinalBillDetails;
import jkt.hms.masters.business.BlReceiptHeader;
import jkt.hms.masters.business.HospitalParameters;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasCompany;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasScheme;
import jkt.hms.masters.business.MasSetupParameterMaintaince;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientPrescriptionDetails;
import jkt.hms.masters.business.PrinterCofiguration;
import jkt.hms.masters.business.StoreIssueT;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.HospitalDetailsMasterHandlerService;
import jkt.hms.stores.handler.StoresHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * @author jkt
 *
 */
/**
 * @author jkt
 *
 */
/**
 * @author jkt
 * 
 */
public class BillingController extends MultiActionController {

	BillingHandlerService billingHandlerService = null;
	OpBillingHandlerService opBillingHandlerService = null;
	HospitalDetailsMasterHandlerService hospitalDetailsMasterHandlerService = null;
	AccountHandlerService accountHandlerService = null;
	LabHandlerService labHandlerService = null;
	IPDHandlerService ipdHandlerService = null;
	StoresHandlerService storesHandlerService = null;
	public StoresHandlerService getStoresHandlerService() {
		return storesHandlerService;
	}

	public void setStoresHandlerService(StoresHandlerService storesHandlerService) {
		this.storesHandlerService = storesHandlerService;
	}

	String jsp = "";
	String title = "";

	/**
	 * Method for Display the Payment Billing Dispensing pafe
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showPaymentAdviceDispensingJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		/*
		 * if (request.getParameter("flag").equals("chargeSlip")) { jsp =
		 * IP_BILLING_SEARCH_JSP; } else if
		 * (request.getParameter("flag").equals("finalBill")) { jsp =
		 * FINAL_BILL_PATIENT_SEARCH_JSP; }
		 */
		jsp = "billPaymentAdviceSearch";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showSearchPaymentAdviceDispensingJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		/*
		 * if (request.getParameter("flag").equals("chargeSlip")) { jsp =
		 * IP_BILLING_SEARCH_JSP; } else if
		 * (request.getParameter("flag").equals("finalBill")) { jsp =
		 * FINAL_BILL_PATIENT_SEARCH_JSP; }
		 */
		jsp = "billPaymentAdviceSearch";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public void getSubChargeCode(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		StringBuffer sb = new StringBuffer();
		List<Object[]> subChargeList = new ArrayList<Object[]>();

		map = billingHandlerService.getSubChargeCode(box);
		if (map.get("subChargeList") != null) {
			subChargeList = (List<Object[]>) map.get("subChargeList");
		}
		try {
			sb.append("<item>");
			sb.append("<sc>");
			for (Object[] obj : subChargeList) {
				sb.append("<subCharge>");
				sb.append("<subChargeId>" + obj[0] + "</subChargeId>");
				sb.append("<subChargeName>" + obj[1] + "</subChargeName>");
				sb.append("</subCharge>");
			}
			sb.append("</sc>");
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

	/**
	 * Method for showBillPatientAdvanceTransferJsp
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showBillPatientAdvanceTransferJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		/*
		 * if (request.getParameter("flag").equals("chargeSlip")) { jsp =
		 * IP_BILLING_SEARCH_JSP; } else if
		 * (request.getParameter("flag").equals("finalBill")) { jsp =
		 * FINAL_BILL_PATIENT_SEARCH_JSP; }
		 */
		jsp = "billPatientAdvanceTransfer";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * Method for Display the Payment Billing Dispensing pafe
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showBillingPaymentDispensingJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		/*
		 * if (request.getParameter("flag").equals("chargeSlip")) { jsp =
		 * IP_BILLING_SEARCH_JSP; } else if
		 * (request.getParameter("flag").equals("finalBill")) { jsp =
		 * FINAL_BILL_PATIENT_SEARCH_JSP; }
		 */
		jsp = "bill_PaymentBillingDispensing";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * --------------------------- Method to show Charge slip search jsp
	 * -----------------------------------
	 * 
	 */
	public ModelAndView showIPBillingSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int sessionHospitalId = 0;
		sessionHospitalId = (Integer) session.getAttribute("hospitalId");
		Box box = HMSUtil.getBox(request);
		box.put("sessionHospitalId", sessionHospitalId);
		if (request.getParameter("flag").equals("chargeSlip")) {
			map = billingHandlerService.showIPBillingSearchJsp(box);
			jsp = IP_BILLING_SEARCH_JSP;
		} else if (request.getParameter("flag").equals("chargeSlipAd")) {
			jsp = "ipPatientBillingAD";
		} else if (request.getParameter("flag").equals("finalBill")) {
			jsp = FINAL_BILL_PATIENT_SEARCH_JSP;
		} else if (request.getParameter("flag").equals("finalBillAd")) {
			jsp = "billFinalBillPatientAd";
		}
		jsp += ".jsp";

		// String jsp = "";

		// jsp = IP_BILLING_SEARCH_JSP;

		// jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * --------------------------- Method to get Admission no for charge slip
	 * search
	 * 
	 */
	// search post paid service-----
	public ModelAndView showPostPaidStatus(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String uhid = "";
		int department = 0;
		int ward = 0;
		HttpSession session = request.getSession();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();

		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}

		if (request.getParameter("uhid") != null) {
			uhid = request.getParameter("uhid");
		}
		if (request.getParameter("department") != null) {
			department = Integer.parseInt(""
					+ request.getParameter("department"));
		}
		if (request.getParameter("ward") != null) {
			ward = Integer.parseInt("" + request.getParameter("ward"));
		}
		dataMap.put("ward", ward);
		dataMap.put("department", department);
		dataMap.put("uhid", uhid);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = billingHandlerService.showPostPaidStatus(box, dataMap);
		jsp = "postPaidStatus";
		jsp = jsp + ".jsp";
		title = "Patient Post Paid Status ";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	//
	public ModelAndView getAdNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hin = "";
		String flag = "";
		int hospitalId = 0;

		HttpSession session = (HttpSession) request.getSession();
		List<Inpatient> adNoList = new ArrayList<Inpatient>();
		if (request.getParameter(HIN_NO) != null) {
			hin = request.getParameter(HIN_NO);
		}
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			map.put("flag", flag);
		}
		if (request.getParameter(BILL_TYPE) != null) {
			map.put("billType", request.getParameter(BILL_TYPE));
		}

		if (session.getAttribute(HOSPITAL_ID) != null)
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		adNoList = billingHandlerService.getAdNo(hin, hospitalId);
		if (adNoList.size() > 0) {
			map.put("adNoList", adNoList);
		}
		String jsp = "billingResponseForAdNo";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getAdNoForReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hin = "";
		String flag = "";
		List<Inpatient> adNoList = new ArrayList<Inpatient>();
		if (request.getParameter(HIN_NO) != null) {
			hin = request.getParameter(HIN_NO);
		}
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			map.put("flag", flag);
		}
		if (request.getParameter(BILL_TYPE) != null) {
			map.put("billType", request.getParameter(BILL_TYPE));
		}
		String message = "";
		adNoList = billingHandlerService.getAdNoForReport(hin);
		if (adNoList.size() > 0) {
			map.put("adNoList", adNoList);
			String jsp = "billingResponseForAdNo";
		} else {
			message = "No Record Found!";
			map.put("message", message);
		}
		String jsp = "billingResponseForAdNo";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getOrderNoForChargeSlip(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		map = billingHandlerService.getOrderNoForChargeSlip(box);
		String jsp = "";
		jsp = BILLING_RESPONSE_FOR_ORDER_NO_JSP;
		return new ModelAndView(jsp, "map", map);
	}

	/**
	 * --------------------------- Method to get patient details for charge slip
	 * 
	 */

	public ModelAndView getPatientDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
	
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;

		HttpSession session = (HttpSession) request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
	
		map = billingHandlerService.getPatientDetails(box);


		String jsp = "";
		jsp = IP_BILLING_PATIENT_DETAILS_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * --------------------------- Method to get charge code for auto complete
	 * 
	 */

	/** -----------OPD CHARITY DETAIL-------------------------------------* */
	public ModelAndView showCharityDetailsSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		jsp = Charity_Details_jsp;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/** ---CharityDetails method----- */
	public ModelAndView printCharityDetails(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		String fromDate = null;
		String toDate = null;
		String reportName = "";

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = request.getParameter(FROM_DATE);
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = request.getParameter(TO_DATE);

		}

		if (request.getParameter("reportName") != null
				&& !(request.getParameter("reportName").equals(""))) {
			reportName = (request.getParameter("reportName"));
		}

		parameters.put("fromDate",
				HMSUtil.convertStringTypeDateToDateType(fromDate));
		parameters.put("toDate",
				HMSUtil.convertStringTypeDateToDateType(toDate));
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		// billingHandlerService.executeProcedureForReport(parameters);

		parameters.put("HOSPITAL_ID", hospitalId);
		detailsMap = billingHandlerService.getConnectionForReport();
		// parameters.put("toRefundDate",
		// HMSUtil.convertStringTypeDateToDateType(toDate));

		HMSUtil.generateReport(reportName, parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView printAdmitPatientDetails(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		String reportName = "IpAdmitPatient";

		// billingHandlerService.executeProcedureForReport(parameters);

		detailsMap = billingHandlerService.getConnectionForReport();
		// parameters.put("toRefundDate",
		// HMSUtil.convertStringTypeDateToDateType(toDate));

		HMSUtil.generateReport(reportName, parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	/** *0-------------------------------------- */

	public ModelAndView getChargeCode(HttpServletRequest request,
			HttpServletResponse response) {
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

		map = billingHandlerService.getChargeCode(parameterMap);

		String jsp = "";
		jsp = BILLING_RESPONSE_FOR_CHARGE_CODE_GRID_JSP;

		return new ModelAndView(jsp, "map", map);
	}

	/**
	 * --------------------------- Method to fill details in grid for Charge
	 * code
	 * 
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView fillItemsForChargeCode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();

		String rowVal = request.getParameter("rowVal");
		String chargeCodeWithId = request.getParameter("chargeCode" + rowVal);
		int index1 = chargeCodeWithId.lastIndexOf("[");
		String chargeName = chargeCodeWithId.substring(0, index1);

		dataMap.put("chargeName", chargeName);

		map = billingHandlerService.fillItemsForChargeCode(dataMap);

		String jsp = "";
		jsp = "billingResponseForChargeCodeDetail";

		map.put("rowVal", rowVal);
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);

	}

	/**
	 * --------------------------- Method to submit charge slip details of a
	 * patient
	 * 
	 */

	public ModelAndView submitChargeSlipDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession();

		Box box = HMSUtil.getBox(request);

		int hospitalId = 0;
		int departmentId = 0;
		String flag = "";
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
			box.put("departmentId", departmentId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		if (!box.getString(PAYABLE_AMOUNT).equals("")) {
			String receiptNo = opBillingHandlerService.generateReceiptNo(
					"save", hospitalId);
			box.put("receiptNo", receiptNo);
		}
		System.out.println("paymentMethod---"
				+ request.getParameter("paymentMethod"));
		if (request.getParameter("paymentMethod") != null) {
			flag = request.getParameter("paymentMethod");
			box.put("flag", flag);
			System.out.println("flag" + flag);
		}
		String orderNo = labHandlerService.generateOrderNumber();
		box.put("orderNo", orderNo);

		String jsp = "";
		String printUrl = "";
		String url = "";
		String message = "";
		boolean saved = false;
		box.put("chargeSlip", "chargeSlip");
		int chargeSlipNo = 0;
		chargeSlipNo = billingHandlerService
				.getChargeSlipNo("save", hospitalId);
		box.put("chargeSlipNo", chargeSlipNo);
		String billNo = String.valueOf(chargeSlipNo);
		saved = billingHandlerService.submitChargeSlipDetails(box);
		if (saved) {
			message = "Record Saved Successfully!! Charge Slip No Is "
					+ chargeSlipNo + "  Do you want to print Charge Slip?";
			printUrl = "submitForm('messageBilling','/hms/hms/billing?method=printChargeSlipReport&chargeSlipNo="
					+ chargeSlipNo + "')";
			url = "submitForm('messageBilling','/hms/hms/billing?method=showIPBillingSearchJsp')";
			map.put("printUrl", printUrl);
			map.put("url", url);
		} else {
			message = "Try Again!";
		}
		map.put("message", message);

		jsp = MESSAGE_FOR_BILLING_JSP + ".jsp";
		map.put("contentJsp", jsp);
		map.put("billtype", "chargeSlip");
		map.put("billNo", billNo);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * Method for Show page Final Bill Detail
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showBillFinalBillJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String flag = "";
		/*
		 * if (request.getParameter("flag") != null) { flag =
		 * request.getParameter("flag"); } if (flag.equals("searchDeposit")) {
		 * jsp = SEARCH_PATIENT_FOR_ADVANCE_JSP + ".jsp"; } else if
		 * (flag.equals("searchFinalSettlement")) { jsp =
		 * SEARCH_PATIENT_FOR_FINAL_SETTLEMENT_JSP + ".jsp"; }
		 */
		jsp = "bill_IPFinalBill" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/* show Bill Wise Institute the method is showBillInstituteWiseServices */

	public ModelAndView showBillInstituteWiseServices(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String flag = "";
		/*
		 * if (request.getParameter("flag") != null) { flag =
		 * request.getParameter("flag"); } if (flag.equals("searchDeposit")) {
		 * jsp = SEARCH_PATIENT_FOR_ADVANCE_JSP + ".jsp"; } else if
		 * (flag.equals("searchFinalSettlement")) { jsp =
		 * SEARCH_PATIENT_FOR_FINAL_SETTLEMENT_JSP + ".jsp"; }
		 */
		jsp = "showBillInstituteWiseServices" + ".jsp";
		map.put("instituteWiseServices", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * Method for Bill Settelment showBillSettlementJsp
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showBillSettlementJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String flag = "";
		/*
		 * if (request.getParameter("flag") != null) { flag =
		 * request.getParameter("flag"); } if (flag.equals("searchDeposit")) {
		 * jsp = SEARCH_PATIENT_FOR_ADVANCE_JSP + ".jsp"; } else if
		 * (flag.equals("searchFinalSettlement")) { jsp =
		 * SEARCH_PATIENT_FOR_FINAL_SETTLEMENT_JSP + ".jsp"; }
		 */
		jsp = "bill_billSettlement" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * --------------------------- Method to Show Search jsp for Patient Advance
	 * and Patient Final Settlement
	 * 
	 */

	/*
	 * public ModelAndView showSearchJspForDepositAndSettlement(
	 * HttpServletRequest request, HttpServletResponse response) { Map<String,
	 * Object> map = new HashMap<String, Object>(); String jsp = ""; String flag
	 * = ""; if (request.getParameter("flag") != null) { flag =
	 * request.getParameter("flag"); } if (flag.equals("searchDeposit")) { jsp =
	 * SEARCH_PATIENT_FOR_ADVANCE_JSP + ".jsp"; } else if
	 * (flag.equals("searchFinalSettlement")) { jsp =
	 * SEARCH_PATIENT_FOR_FINAL_SETTLEMENT_JSP + ".jsp"; } map.put("contentJsp",
	 * jsp); return new ModelAndView("index", "map", map); }
	 */
	public ModelAndView showSearchJspForDepositAndSettlement(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}
		if (flag.equals("searchDeposit")) {
			jsp = SEARCH_PATIENT_FOR_ADVANCE_JSP + ".jsp";
		} else if (flag.equals("searchFinalSettlement")) {
			jsp = SEARCH_PATIENT_FOR_FINAL_SETTLEMENT_JSP + ".jsp";
		} else if (flag.equals("searchFinalSettlementAd")) {
			jsp = "searchPatientFinalSetlmentAd.jsp";
		}
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * --------------------------- Method to search patient for advance
	 * 
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatient(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		String hinNo = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		int hinId = 0;
		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
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
			if (request.getParameter("hinId") != null) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				mapForDs.put("hinId", hinId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		HospitalParameters hospitalParameters = new HospitalParameters();

		map = billingHandlerService.getSystemParamDetails();
		if (map.get("hospitalParameters") != null) {
			hospitalParameters = (HospitalParameters) map
					.get("hospitalParameters");
		}
		int allowAdvForOp = 0;
		if (hospitalParameters != null) {
			if (hospitalParameters.getAllowOpAdvance() != null) {
				allowAdvForOp = hospitalParameters.getAllowOpAdvance();
			}
		}
		String jsp = "";
		patientMap = billingHandlerService
				.getPatientDetailsForAdvance(mapForDs);

		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailsList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailsList");
		}
		if ((!hinNo.equals("") && patientList.size() > 0) || hinId != 0) {
			if (patientList.get(0).getPatientStatus().equals("Out Patient")
					&& allowAdvForOp == 0) {
				String message = "Advance not allowed for OP Patients.";
				map.put("message", message);
				jsp = SEARCH_PATIENT_FOR_ADVANCE_JSP + ".jsp";
			} else {
				String receiptNo = "";
				receiptNo = opBillingHandlerService.generateReceiptNo(
						"display", hospitalId);
				map.put("receiptNo", receiptNo);
				jsp = DEPOSITS_JSP + ".jsp";
			}
		} else {
			jsp = SEARCH_PATIENT_FOR_ADVANCE_JSP + ".jsp";
		}

		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * --------------------------- Method to submit Deposit details of a patient
	 * 
	 */

	public ModelAndView submitDepositDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		boolean saved = false;
		int hospitalId = 0;

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
		String receiptNo = "";
		receiptNo = opBillingHandlerService.generateReceiptNo("save",
				hospitalId);
		box.put("receiptNo", receiptNo);

		parameterMap.put("box", box);

		map = billingHandlerService.submitDepositDetails(parameterMap);
		saved = (Boolean) map.get("saved");
		String message = "";
		String printUrl = "";
		// String url = "";
		if (saved) {
			printUrl = "submitForm('messageBilling','billing?method=printReceiptReport&textfield="
					+ receiptNo + "')";
			map.put("printUrl", printUrl);
			message = "Deposit Information Saved Successfully.Do you want to print receipt?";
		} else {
			message = "Some Problem Occured.";
		}
		map.put("message", message);
		String jsp = MESSAGE_FOR_BILLING_JSP + ".jsp";
		map.put("contentJsp", jsp);
		map.put("billtype", "receipt");
		map.put("billNo", receiptNo);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * public ModelAndView getPatientDetailsForFinalBill( HttpServletRequest
	 * request, HttpServletResponse response) { Map<String, Object> map = new
	 * HashMap<String, Object>(); String adNo = ""; String hin = ""; Integer
	 * hin_id = 0; String distype = "";
	 * 
	 * if (request.getParameter(AD_NO) != null) { adNo =
	 * request.getParameter(AD_NO); } if (request.getParameter(HIN_NO) != null)
	 * { hin = request.getParameter(HIN_NO); } if
	 * (request.getParameter("distype") != null &&
	 * !request.getParameter("distype").equals("")) { distype =
	 * request.getParameter("distype"); } // String jsp = ""; if
	 * (request.getParameter(HIN_ID) != null) { hin_id =
	 * Integer.parseInt(request.getParameter(HIN_ID)); } int inpatientId = 0;
	 * inpatientId = billingHandlerService.getInpatientId(adNo); Date admDate =
	 * null; admDate = billingHandlerService.getAdmDate(inpatientId); String
	 * nextToAdmDate = null; if (admDate != null) { nextToAdmDate =
	 * HMSUtil.getNexAndPreciousDate(admDate); } map =
	 * billingHandlerService.updateDates(inpatientId, nextToAdmDate); // int
	 * patientTypeId = 0; int sexId = 0; sexId =
	 * billingHandlerService.getGenderId(hin_id); patientTypeId =
	 * billingHandlerService.getPatientTypeId(hin_id); // // boolean updadted =
	 * false; // if (sexId == 2 && distype.equals("j")) { // updadted =
	 * billingHandlerService.updateBills(inpatientId); } else if (patientTypeId
	 * == 14 && distype.equals("m")) { // updadted =
	 * billingHandlerService.updateBillsForMLC(inpatientId); } map =
	 * billingHandlerService.getPatientDetailsForFinalBill(adNo, hin, hin_id);
	 * String message = ""; // if (map.get("adStatus") != null &&
	 * map.get("adStatus").equals("A")) { message =
	 * "Proceed to Discharge First!"; map.put("message", message); jsp =
	 * FINAL_BILL_PATIENT_SEARCH_JSP + ".jsp"; // jsp = "billIPFinalBill" +
	 * ".jsp"; } else {
	 * 
	 * 
	 * if (map.get("chargeSlipList") != null || map.get("dispenseDetailsList")
	 * != null) {
	 * 
	 * String includedJsp = "billIPFinalBill" + ".jsp"; map.put("includedJsp",
	 * includedJsp);
	 * 
	 * }else if (map.get("chargeSlipList") == null &&
	 * map.get("dispenseDetailsList") == null && map.get("message") == null) {
	 * message = "No Record Found."; map.put("message", message); }
	 * 
	 * jsp = "billIPFinalBill" + ".jsp"; } // map.put("distype", distype);
	 * 
	 * map.put("contentJsp", jsp); return new ModelAndView("index", "map", map);
	 * }
	 */

	public ModelAndView getPatientDetailsForFinalBill(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String adNo = "";
		String hin = "";
		Integer hin_id = 0;
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		if (request.getParameter(AD_NO) != null) {
			adNo = request.getParameter(AD_NO);
		}
		if (request.getParameter(HIN_NO) != null) {
			hin = request.getParameter(HIN_NO);
		}
		// -hin_id added by dipali
		if (request.getParameter(HIN_ID) != null) {
			hin_id = Integer.parseInt(request.getParameter(HIN_ID));
		}
		map = billingHandlerService.getPatientDetailsForFinalBill(adNo, hin,
				hin_id,hospitalId);
		String jsp = "";
		String message = "";
		/*
		 * if (map.get("chargeSlipList") != null ||
		 * map.get("dispenseDetailsList") != null) {
		 */
		String includedJsp = IP_FINAL_BILL_JSP + ".jsp";
		map.put("includedJsp", includedJsp);
		/*
		 * }else if (map.get("chargeSlipList") == null &&
		 * map.get("dispenseDetailsList") == null && map.get("message") == null)
		 * { message = "No Record Found."; map.put("message", message); }
		 */
		jsp = FINAL_BILL_PATIENT_SEARCH_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showChargeCodeInPopUp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int mainChargeId = 0;
		int inpatientId = 0;
		int rowVal = 0;
		if (request.getParameter("mainChargeId") != null) {
			mainChargeId = Integer.parseInt(request
					.getParameter("mainChargeId"));
		}
		if (request.getParameter("inpatientId") != null) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		}
		if (request.getParameter("rowVal") != null) {
			rowVal = Integer.parseInt(request.getParameter("rowVal"));
		}
		map = billingHandlerService.getChargeCodeForMainCharge(mainChargeId,
				inpatientId);
		String jsp = "";
		jsp = BILL_CHARGE_CODE_DETAILS_POP_UP_JSP;
		map.put("inpatientId", inpatientId);
		map.put("rowVal", rowVal);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showReceiptDetailsInPopUp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int inpatientId = 0;

		if (request.getParameter("inpatientId") != null) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		}
		map = billingHandlerService.getReceiptDetailsForPatient(inpatientId);
		String jsp = "";
		jsp = "billReceiptDetailsPopUp";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitFinalBillDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		String userName = "";
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}
		String distype = "";
		if (request.getParameter("distype") != null) {
			distype = request.getParameter("distype");
		}
		box.put("distype", distype);
		int bookingId = 0;
		if (request.getParameter("bookingId") != null) {
			bookingId =Integer.parseInt(request.getParameter("bookingId"));
		}
		map = billingHandlerService.submitFinalBillDetails(box);
		boolean saved = (Boolean) map.get("flag");
		String message = "";
		if (saved) {
			message = "Final Bill Details Saved Successfully FINAL SETTLEMENT IS NOT COMPLETE. Do you want to print final bill.";
			String printUrl = "submitForm('messageBilling','billing?method=printIPFinalBillReport&reportType=summary&"
					+ AD_NO + "=" + box.getString(AD_NO) + "')";
			map.put("printUrl", printUrl);
		} else {
			message = "Some Problem Occured.";
		}
		map.put("message", message);
		map.put("bookingId", bookingId);
		String jsp = MESSAGE_FOR_BILLING_JSP + ".jsp";
		map.put("contentJsp", jsp);

		String pathin = getServletContext().getRealPath("/Reports/");
		map.put("SUBREPORT_DIR", pathin);

		/*
		 * HMSUtil.generateReport(reportName, parameters, (Connection)
		 * detailsMap .get("conn"), response, getServletContext());
		 */
		map.put("billtype", "detail");
		// map.put("billtype", "finalBill");
		map.put("inpatientId", box.getInt(INPATIENT_ID));
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getFinalBillNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String adNo = "";
		if (request.getParameter(AD_NO) != null) {
			adNo = request.getParameter(AD_NO);
		}
		map = billingHandlerService.getFinalBillNo(adNo);
		String message = "";
		String jsp = "";
		if (map.get("finalBillList") == null) {
			message = "No Record Found";
			map.put("message", message);
		}

		jsp = "billingResponseForFinalBillNo";
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * public ModelAndView getBillingDetailsForSettlement( HttpServletRequest
	 * request, HttpServletResponse response) { Map<String, Object> map = new
	 * HashMap<String, Object>(); BigDecimal diffAmt = new BigDecimal(0);
	 * BigDecimal netAmt = new BigDecimal(0); String finalBillNo = ""; String
	 * adNo = ""; String receiptNo = ""; String refundNo = "";
	 * 
	 * HttpSession session=request.getSession(); int
	 * hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
	 * 
	 * Box box = HMSUtil.getBox(request);
	 * 
	 * finalBillNo = box.getString("finalBillNo"); adNo = box.getString(AD_NO);
	 * 
	 * map = billingHandlerService.getBillingDetailsForSettlement(finalBillNo,
	 * adNo);
	 * 
	 * if (map.get("diffAmt") != null) { diffAmt = (BigDecimal)
	 * map.get("diffAmt"); if (diffAmt.intValue() < 0) { refundNo =
	 * billingHandlerService.generateRefundNo("display"); map.put("refundNo",
	 * refundNo); } else if (diffAmt.intValue() >= 0) { receiptNo =
	 * opBillingHandlerService .generateReceiptNo("display");
	 * map.put("receiptNo", receiptNo); } }
	 * 
	 * if (map.get("netAmt") != null) { netAmt = (BigDecimal) map.get("netAmt");
	 * if (netAmt.intValue() < 0) { refundNo =
	 * billingHandlerService.generateRefundNo("display", hospitalId);
	 * map.put("refundNo", refundNo); } else if (netAmt.intValue() >= 0) {
	 * receiptNo = opBillingHandlerService
	 * .generateReceiptNo("display",hospitalId); map.put("receiptNo",
	 * receiptNo); } } String jsp = ""; String message = ""; if
	 * (map.get("finalBillList") == null) { message = "No Record Found!"; jsp =
	 * SEARCH_PATIENT_FOR_FINAL_SETTLEMENT_JSP + ".jsp"; map.put("message",
	 * message); } else { jsp = BILLING_FINAL_SETTLEMENT_JSP + ".jsp"; }
	 * map.put("contentJsp", jsp); return new ModelAndView("index", "map", map);
	 * }
	 */

	public ModelAndView getBillingDetailsForSettlement(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		BigDecimal diffAmt = new BigDecimal(0);
		BigDecimal netAmt = new BigDecimal(0);
		String finalBillNo = "";
		String adNo = "";
		String receiptNo = "";
		String refundNo = "";

		Box box = HMSUtil.getBox(request);

		finalBillNo = box.getString("finalBillNo");
		adNo = box.getString(AD_NO);

		map = billingHandlerService.getBillingDetailsForSettlement(finalBillNo,
				adNo);
		if (map.get("diffAmt") != null) {
			diffAmt = (BigDecimal) map.get("diffAmt");
			if (diffAmt.intValue() < 0) {
				refundNo = billingHandlerService.generateRefundNo("display");
				map.put("refundNo", refundNo);
			} else if (diffAmt.intValue() >= 0) {
				receiptNo = opBillingHandlerService
						.generateReceiptNo("display");
				map.put("receiptNo", receiptNo);
			}
		}
		/*
		 * /***uncomment upper code and comment this code becuse vishal sir
		 * change in final bill so that net amt not work properly this is
		 * through anand**
		 * 
		 * 
		 * if (map.get("netAmt") != null) { netAmt = (BigDecimal)
		 * map.get("netAmt"); if (netAmt.intValue() < 0) { refundNo =
		 * billingHandlerService.generateRefundNo("display");
		 * map.put("refundNo", refundNo); } else if (netAmt.intValue() >= 0) {
		 * receiptNo = opBillingHandlerService .generateReceiptNo("display");
		 * map.put("receiptNo", receiptNo); } }
		 */String jsp = "";
		String message = "";
		if (map.get("finalBillList") == null) {
			message = "No Record Found!";
			jsp = SEARCH_PATIENT_FOR_FINAL_SETTLEMENT_JSP + ".jsp";
			map.put("message", message);
		} else {
			jsp = BILLING_FINAL_SETTLEMENT_JSP + ".jsp";
		}
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * --------------------------- Method to submit Deposit details of a
	 * patient-----------------------------------
	 * 
	 */

	public ModelAndView submitBillingFinalSettlementDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		int hospitalId = 0;
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		int inpatientId = box.getInt(INPATIENT_ID);
		int finalBillId = box.getInt("finalBillId");
		map = billingHandlerService.submitBillingFinalSettlementDetails(box);
		if (request.getParameter("transType").equals("Receipt")) {
			opBillingHandlerService.generateReceiptNo("save", hospitalId);
		} else if (request.getParameter("transType").equals("Refund")) {
			billingHandlerService.generateRefundNo("save", hospitalId);
		}
		saved = (Boolean) map.get("saved");
		String message = "";
		String adNo = "";
		if (saved) {
			message = "Patient Final Settlement Information Saved Successfully.\n Do you want to print final settlement summary?";
			String printUrl = "";
			adNo = box.getString(AD_NO);
			printUrl = "submitForm('messageBilling','/hms/hms/billing?method=printIPFinalSetlementBillReport&reportType=summary&"
					+ AD_NO + "=" + adNo + "')";
			map.put("printUrl", printUrl);
		} else {
			message = "Some Problem Occured.";
		}
		map.put("message", message);
		// String jsp = MESSAGE_FOR_BILLING_JSP + ".jsp";
		String jsp = "messageForBillingIp" + ".jsp";
		map.put("contentJsp", jsp);
		String pathin = getServletContext().getRealPath("/Reports/");
		map.put("SUBREPORT_DIR", pathin);
		// int
		//
		System.out.println("inpatientId0000000000000000000000=================="+inpatientId);
		map.put("inpatientId", inpatientId);
		if (!adNo.equals("")) {
			inpatientId = billingHandlerService.getInpatientId(adNo);
		}
		//
		map.put("finalBillId", finalBillId);
		map.put("billtype", "patientDetail");
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showIPBillDispensingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int sessionHospitalId = 0;
		sessionHospitalId = (Integer) session.getAttribute("hospitalId");

		Box box = HMSUtil.getBox(request);
		box.put("sessionHospitalId", sessionHospitalId);
		map = billingHandlerService.showIPBillDispensingJsp(box);
		String jsp = "";

		jsp = SEARCH_PATIENT_FOR_IP_BILL_DISPENSING_JSP;

		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPatientForIPBillDispensing(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Box box = HMSUtil.getBox(request);

		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);

		map = billingHandlerService.getPatientDetailsForBillDispensing(box);

		String jsp = "";
		String message = "";
		String maxBlNo = "";
		String billType = "OD";
		maxBlNo = opBillingHandlerService.generateBillNo(billType, "display",
				hospitalId);
		map.put("maxBlNo", maxBlNo);
		if (map.get("patientList") != null) {
			List<Inpatient> patientList = new ArrayList<Inpatient>();
			if (map.get("patientList") != null) {
				patientList = (List<Inpatient>) map.get("patientList");
			}
			if (patientList.size() > 0) {
				Inpatient inpatient = patientList.get(0);
				box.put("inpatientId", inpatient.getId());
			}
			//detailsMap = billingHandlerService.getDetailsForBillDispensing();
			detailsMap = billingHandlerService.getHighLevelDrugsForIPBilling(box);
			map.put("detailsMap", detailsMap);
			jsp = BILL_DISPENSING_FOR_IP_JSP + ".jsp";
		} else {
			message = "No Record Found!";
			map.put("message", message);
			jsp = SEARCH_PATIENT_FOR_IP_BILL_DISPENSING_JSP + ".jsp";
		}
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitIPBillDispensingDetails(
			HttpServletRequest request, HttpServletResponse response) {
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
		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);

		Users user = new Users();
		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}

		BlDispensingHeader dispensingHeader = new BlDispensingHeader();

		String billNo = "";
		String billType = "OD";
		billNo = opBillingHandlerService.generateBillNo(billType, "save",
				hospitalId);
		dispensingHeader.setBillNo(billNo);

		dispensingHeader.setHospital(hospital);
		Patient patient = new Patient();
		if (request.getParameter(HIN_ID) != null) {
			patient.setId(Integer.parseInt(request.getParameter(HIN_ID)));
			dispensingHeader.setHin(patient);
			dispensingHeader.setPatientStatus("r");
		}
		if (request.getParameter(HIN_NO) != null) {
			dispensingHeader.setHinNo(request.getParameter(HIN_NO));
		}

		Inpatient inpatient = new Inpatient();
		if (request.getParameter(INPATIENT_ID) != null) {
			inpatient
					.setId(Integer.parseInt(request.getParameter(INPATIENT_ID)));
			dispensingHeader.setInpatient(inpatient);
		}
		if (request.getParameter(AD_NO) != null) {
			dispensingHeader.setAdNo(request.getParameter(AD_NO));
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
		/*if (request.getParameter(CONSULTING_DOCTOR) != null) {
			dispensingHeader.setConsultantName(request
					.getParameter(CONSULTING_DOCTOR));
		}*/
		dispensingHeader.setBillAmt(new BigDecimal(request
				.getParameter(BILL_AMOUNT)));
		if (request.getParameter(DISCOUNT_AMOUNT) != null
				&& !(request.getParameter(DISCOUNT_AMOUNT).equals(""))) {
			BigDecimal totalDiscount = new BigDecimal("0");
			totalDiscount = new BigDecimal(
					request.getParameter(DISCOUNT_AMOUNT));
			dispensingHeader.setDiscountAmt(totalDiscount);
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
		if (request.getParameter(PATIENT_TYPE_ID) != null && !request.getParameter(PATIENT_TYPE_ID).equals("")) {
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
			receiptHeader.setInpatient(inpatient);
			if (request.getParameter(PAYABLE_AMOUNT) != null
					&& !(request.getParameter(PAYABLE_AMOUNT).equals(""))) {
				receiptHeader.setAmount(new BigDecimal(request
						.getParameter(PAYABLE_AMOUNT)));
			}
			if (request.getParameter(DISCOUNT_AMOUNT) != null
					&& !(request.getParameter(DISCOUNT_AMOUNT).equals(""))) {
				BigDecimal totalDiscount = new BigDecimal("0");
				totalDiscount = new BigDecimal(
						request.getParameter(DISCOUNT_AMOUNT));
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
		// ==============Code commented by
		// anamika===============================//
		// FaVoucherHeader voucherHeader = new FaVoucherHeader();
		// String voucherNo =
		// accountHandlerService.generateVoucherNo("RES","Display");
		// voucherHeader.setVoucherNo(voucherNo);
		// FaMasVoucherType voucherType = new FaMasVoucherType();
		// voucherType.setId(2);
		// voucherHeader.setVoucherType(voucherType);
		// voucherHeader.setLastChgBy(userName);
		// voucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE)));
		// voucherHeader.setLastChgTime(request.getParameter(CHANGED_TIME));
		// voucherHeader.setCrAmount(new
		// BigDecimal(request.getParameter(BILL_AMOUNT)));
		// voucherHeader.setDrAmount(new
		// BigDecimal(request.getParameter(BILL_AMOUNT)));
		// voucherHeader.setHospital(hospital);
		// voucherHeader.setNarration(("Being Cash Sales");
		// voucherHeader.setStatus("y");
		// voucherHeader.setLastChgBy(userName);
		// voucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE)));
		// voucherHeader.setLastChgTime(request.getParameter(CHANGED_TIME));
		// voucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE)));
		// voucherHeader.setVoucherTime(request.getParameter(CHANGED_TIME));

		// detailsMap.put("voucherHeader", voucherHeader);

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
			// message = "Billing has been done successfully!!";
			message = "Billing has been done successfully!!\n Bill No is "
					+ billNo + ". Do you want to print?";
			printUrl = "submitForm('messageBilling','/hms/hms/billing?method=printBillPrintingDispencingReport&textfield="
					+ billNo + "')";
			url = "submitForm('messageBilling','/hms/hms/opBilling?method=showIPBillDispensingJsp')";
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

	public ModelAndView showCancelBillJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String jsp = "billSearchChargeSlipForCancel.jsp";
		map.put("contentJsp", jsp);
		map.put("flag", box.getString("flag"));
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchChargeSlipForCancellation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		box.put(HOSPITAL_ID, session.getAttribute(HOSPITAL_ID));
		map = billingHandlerService.searchChargeSlipForCancellation(box);

		String jsp = "billingResponseForChargeSlipForCancel";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getChargeSlipDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = billingHandlerService.getChargeSlipDetails(box);

		return new ModelAndView("billResponseForChargeSlipDetails", "map", map);
	}

	public ModelAndView cancelChargeSlip(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		boolean cancelFlag = false;
		cancelFlag = billingHandlerService.cancelChargeSlip(box);
		String message = "";
		if (cancelFlag) {
			message = "Charge Slip has been canceled.";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		String jsp = MESSAGE_FOR_BILLING_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchChargeSlipNoForPymntAdv(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		map = billingHandlerService.searchChargeSlipNoForPymntAdv(box);
		map.put("billType", box.getString(BILL_TYPE));
		String jsp = "billingResponseForChargeSlipNo";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getPatientDetailsForIPPaymentAdvice(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String billType = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Box box = HMSUtil.getBox(request);
		if (request.getParameter(BILL_TYPE) != null)
			billType = request.getParameter(BILL_TYPE);

		if (billType.equals("servicing")) {
			map = billingHandlerService
					.getPatientDetailsForPaymentAdviceChargeSlip(box);
		} else if (billType.equals("dispensing")) {
			map = opBillingHandlerService
					.getPatientDetailsForPaymentAdviceDispensing(box);
		}

		String paymentAdviceNo = "";
		paymentAdviceNo = opBillingHandlerService.generatePaymentAdviceNo(
				"display", hospitalId);
		map.put("paymentAdviceNo", paymentAdviceNo);

		String jsp = "";
		String message = "";
		if (map.get("chargeSlipList") != null) {
			jsp = BILL_PAYMENT_ADVICE_CHARGESLIP_JSP + ".jsp";
		} else if (map.get("dispensingHeaderList") != null) {
			jsp = BILL_PAYMENT_ADVICE_DISPENSING_JSP + ".jsp";

		} else {
			message = "No Record Found!";
			jsp = BILL_PAYMENT_ADVICE_SEARCH_For_Service_JSP + ".jsp";
			map.put("message", message);
		}
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchBillForCancellation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		map = billingHandlerService.searchBillForCancellation(box);

		String jsp = "billingResponseForIPDispBillForCancel";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView cancelBillDispensing(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		boolean cancelFlag = false;
		cancelFlag = billingHandlerService.cancelBillDispensing(box);
		String message = "";
		if (cancelFlag) {
			message = "Dispensing Bill has been cancelled.";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		String jsp = MESSAGE_FOR_BILLING_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPharmacySalesViewJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		
		int deptId = 0;
		int hospitalId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer
					.parseInt(session.getAttribute("deptId").toString());
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt(session.getAttribute(HOSPITAL_ID)
					.toString());
		}
		box.put("deptId", deptId);
		box.put(HOSPITAL_ID, hospitalId);
		
		map = billingHandlerService.getPharmacySalesDetails(box);
		jsp = "pharmacySalesViewSearch" + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);

	}

	/* by Rahul showPendingDispensingJsp */
	public ModelAndView showDetailPendingDispensing(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int presId = 0;
		int hinId = 0;
		int hospitalId = 0;
		if (request.getParameter("presId") != null
				&& !(request.getParameter("presId").equals("0"))) {
			String[] presArr = request.getParameter("presId").toString().trim()
					.split(",");
			presId = Integer.parseInt(presArr[0]);
			hinId = Integer.parseInt(presArr[1]);
			mapForDS.put("presId", presId);
			mapForDS.put("hinId", hinId);
		}

		HttpSession session = request.getSession();
		String deptType = "";
		if (session.getAttribute("deptType") != null){
			deptType = "" + session.getAttribute("deptType");
		}
		mapForDS.put("deptType", deptType);
		if (session.getAttribute("hospitalId") != null){
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		mapForDS.put("hospitalId", hospitalId);
		
		if(session.getAttribute("deptId") != null){
			mapForDS.put("deptId", (Integer)session.getAttribute("deptId"));
		}
		
		List<PatientPrescriptionDetails> prescriptionDetailsList = new ArrayList<PatientPrescriptionDetails>();
		List<PatientPrescriptionDetails> patientPrescriptionDetailsOut = new ArrayList<PatientPrescriptionDetails>();
		List<Object[]> nonInsulineprescriptionDetailsList = new ArrayList<Object[]>();

		if (presId != 0) {
			map = billingHandlerService.showDetailPendingDispensing(mapForDS);
			List<StoreIssueT> alreadyissuedDrugList = new ArrayList<StoreIssueT>();
			alreadyissuedDrugList = (List) map.get("alreadyissuedDrugList");
			if(map.get("prescriptionDetailsList")!=null){
				prescriptionDetailsList = (List<PatientPrescriptionDetails>)map.get("prescriptionDetailsList");
			}
			
			if(map.get("nonInsulineprescriptionDetailsList")!=null){
				nonInsulineprescriptionDetailsList = (List<Object[]>)map.get("nonInsulineprescriptionDetailsList");
			}
			if(map.get("patientPrescriptionDetailsOut")!=null){
				patientPrescriptionDetailsOut = (List<PatientPrescriptionDetails>)map.get("patientPrescriptionDetailsOut");
			}
		}
		// jsp = STRS_PATIENT_DRUG_ISSUE + ".jsp";
		if(prescriptionDetailsList.size()>0 ||nonInsulineprescriptionDetailsList.size()>0 ){
			jsp = "showDetailPendingDispensing" + ".jsp";
		}
		else if(patientPrescriptionDetailsOut.size()>0){
			jsp = "showDetailPendingDispensing" + ".jsp";
		}
		else{
			map = storesHandlerService.getPatientVisitInfo(mapForDS);
			jsp = "patientDispense" + ".jsp";
		}
		map.put("mapForDS", mapForDS);
		map.put("presId", presId);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView getPharmacySalesDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = billingHandlerService.getPharmacySalesDetails(box);

		String jsp = "pharmacySalesViewSearch.jsp";
		map.put("includedJsp", "pharmacySalesView.jsp");
		map.put("contentJsp", jsp);
		map.put("pageNo", 1);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getItemWiseDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = billingHandlerService.getItemWiseDetails(box);

		String jsp = "responseForItemBatchDetails";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showItemBatchInPopUp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int itemId = 0;
		int inpatientId = 0;

		if (request.getParameter("itemId") != null) {
			itemId = Integer.parseInt(request.getParameter("itemId"));
		}
		if (request.getParameter("inpatientId") != null) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		}
		map = billingHandlerService.getItemBatchDetails(itemId, inpatientId);
		String jsp = "";
		jsp = "billingItemBatchDetailsPopup";
		return new ModelAndView(jsp, "map", map);
	}

	// ----------------- Billing Report Methods------------------

	public ModelAndView showBillPrintingServicingReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "billServicingReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getOpBillNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		if (request.getParameter("hinNoId") != null) {
			hinNo = request.getParameter("hinNoId");
		}
		map = billingHandlerService.getOpBillNo(hinNo);
		String message = "";
		String jsp = "";
		if (map.get("billList") == null) {
			message = "No Record Found";
			map.put("message", message);
		}

		jsp = "Opbilljsp";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getDisBillNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		String tablename = "";
		String type = "";
		String dateField = "";
		if (request.getParameter("hinNoId") != null) {
			hinNo = request.getParameter("hinNoId");
		}
		tablename = "bl_dispensing_header";
		type = "bill_no";
		dateField = "bill_date";
		map = billingHandlerService.getDisBillNo(hinNo, tablename, type,
				dateField);
		String message = "";
		String jsp = "";
		if (map.get("billList") == null) {
			message = "No Record Found";
			map.put("message", message);
		}

		jsp = "disBillJsp";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getChargeSlipNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		String tablename = "";
		String type = "";
		String dateField = "";
		if (request.getParameter("hinNoId") != null) {
			hinNo = request.getParameter("hinNoId");
		}
		tablename = "bl_charge_slip_main";
		type = "charge_slip_no";
		dateField = "chg_slp_date";
		map = billingHandlerService.getDisBillNo(hinNo, tablename, type,
				dateField);
		String message = "";
		String jsp = "";

		if (map.get("billList") == null) {
			message = "No Record Found";
			map.put("message", message);
		}

		jsp = "disBillJsp";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getRecieptNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		String tablename = "";
		String type = "";
		String billType = "";
		if (request.getParameter("hinNoId") != null) {
			hinNo = request.getParameter("hinNoId");
		}
		tablename = "bl_receipt_header";
		type = "receipt_no";
		Box box = HMSUtil.getBox(request);
		/* billType = box.getString("billType"); */
		if (box.getString("radioType").equals("adv")) {
			billType = "adv";
		} else if (box.getString("radioType").equals("fs")) {
			billType = "fs";
		}

		map = billingHandlerService.getReceiptNo(hinNo, billType);
		String message = "";
		String jsp = "";

		if (map.get("billList") == null) {
			message = "No Record Found";
			map.put("message", message);
		}
		jsp = "disBillJsp";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getRefund(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		String tablename = "";
		String dateField = "";
		if (request.getParameter("hinNoId") != null) {
			hinNo = request.getParameter("hinNoId");
		}
		tablename = "bl_refund_header";
		String type = "refund_no";
		dateField = "refund_date";
		map = billingHandlerService.getDisBillNo(hinNo, tablename, type,
				dateField);
		String message = "";
		String jsp = "";
		if (map.get("billList") == null) {
			message = "No Record Found";
			map.put("message", message);
		}

		jsp = "disBillJsp";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showBillPrintingDuplicateLabelJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "duplicateBillCard";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showBillPrintingDispencingReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "billDispencingReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showChargeSlipPrintingReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "billChargeSlip";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showRefundJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "billRefundReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showReceiptReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "billReceiptRegisterReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showCashRefundAdviceRegisterJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "cashRefundAdviceRegister";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public void printBillPrintingDuplicateLabel(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String hin_no = "";

		if (request.getParameter("textfield") != null) {
			hin_no = (String) request.getParameter("textfield");
		}
		HttpSession session = request.getSession();
		String loginName = "";
		Users user = new Users();
		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");
			loginName = user.getLoginName();
		}

		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("hinNo", hin_no);
		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));

		// parameters.put("loginname", loginName);

		/*
		 * try { JasperReport jasperReport = JasperCompileManager
		 * .compileReport(getServletContext().getRealPath(
		 * "/Reports/RegistrationCard.jrxml.jrxml")); JasperPrint jasperPrint =
		 * JasperFillManager.fillReport( jasperReport, parameters, (Connection)
		 * detailsMap .get("conn")); JasperPrintManager.printReport(jasperPrint,
		 * true);
		 * 
		 * } catch (JRException e) { e.printStackTrace(); }
		 */
		HMSUtil.generateReport("RegistrationCard", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
	}

	public void printBillPrintingServicingReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String billNo = "";

		if (request.getParameter("billNo") != null) {
			billNo = request.getParameter("billNo");
		}
		String duplicate = "";

		if (request.getParameter("duplicate") != null) {
			duplicate = request.getParameter("duplicate");
		}
		HttpSession session = request.getSession();
		String loginName = "";
		Users user = new Users();
		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");
			loginName = user.getLoginName();
		}

		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("billNo", billNo);
		parameters.put("loginname", loginName);
		parameters.put("Duplicate", duplicate);
		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));
		String reportName = "Servicing_Bill";
		String reportType = "bill";

		String clientIP = request.getRemoteAddr();

		Map<String, Object> printerDtMap = new HashMap<String, Object>();
		printerDtMap.put("reportName", reportName);
		printerDtMap.put("clientIP", clientIP);
		printerDtMap.put("reportType", reportType);
		printerDtMap.put("parameters", parameters);

		directPrintToPrinter(printerDtMap);

		HMSUtil.generateReport("Servicing_Bill", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

	}

	public ModelAndView printPaymentAdviceRep(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String advice_no = "";
		String billType = "";
		String loginName = "";
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		}
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

		detailsMap = billingHandlerService.getConnectionForReport();

		String reportName = "";
		if (billType.equals("servicing")) {
			reportName = "service_advice_rep";

		} else if (billType.equals("dispensing")) {
			reportName = "disp_advice_rep";

		}
		parameters.put("hospitalId", hospitalId);
		parameters.put("advice_no", advice_no);
		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));

		HMSUtil.generateReport(reportName, parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView printBillPrintingDispencingReport(
			HttpServletRequest request, HttpServletResponse response) {
		/*
		 * Map<String, Object> map = new HashMap<String, Object>(); Map<String,
		 * Object> detailsMap = new HashMap<String, Object>(); Map<String,
		 * Object> parameters = new HashMap<String, Object>(); String billNo =
		 * ""; String loginName = "";
		 * 
		 * if (request.getParameter("textfield") != null) { billNo =
		 * request.getParameter("textfield"); } String duplicate = "";
		 * 
		 * if (request.getParameter("duplicate") != null) { duplicate =
		 * request.getParameter("duplicate"); } HttpSession session =
		 * request.getSession();
		 * 
		 * Users user = new Users(); if (session.getAttribute("users") != null)
		 * { user = (Users) session.getAttribute("users"); loginName =
		 * user.getLoginName(); } detailsMap =
		 * billingHandlerService.getConnectionForReport();
		 * parameters.put("billNo", billNo); parameters.put("loginname",
		 * loginName); parameters.put("Duplicate", duplicate);
		 * parameters.put("IMAGE_DIR",
		 * getServletContext().getRealPath("/jsp/images/svb.jpg"));
		 * parameters.put("IMAGE_DIR_LFT",
		 * getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		 * parameters.put("IMAGE_VN_BHAVE",
		 * getServletContext().getRealPath("/jsp/images/vn-bhave.jpg")); String
		 * reportName = "";
		 * 
		 * HospitalParameters hospitalParameters = new HospitalParameters();
		 * 
		 * map = billingHandlerService.getSystemParamDetails(); if
		 * (map.get("hospitalParameters") != null) { hospitalParameters =
		 * (HospitalParameters) map .get("hospitalParameters"); } if
		 * (hospitalParameters != null) { if
		 * (hospitalParameters.getBillPrintType() == 0) { reportName =
		 * "BillDispensingsummary"; } else { reportName = "BillDispensing"; } }
		 * else { reportName = "BillDispensingsummary"; }
		 * 
		 * String reportType = "bill"; String clientIP =
		 * request.getRemoteAddr();
		 * 
		 * Map<String, Object> printerDtMap = new HashMap<String, Object>();
		 * printerDtMap.put("reportName", reportName);
		 * printerDtMap.put("clientIP", clientIP);
		 * printerDtMap.put("reportType", reportType);
		 * printerDtMap.put("parameters", parameters);
		 * 
		 * directPrintToPrinter(printerDtMap);
		 * 
		 * HMSUtil.generateReport(reportName, parameters, (Connection)
		 * detailsMap.get("conn"), response, getServletContext());
		 * 
		 * return null;
		 */
		Map<String, Object> map = new HashMap<String, Object>();
		String billNo = "";
		String hinNo = "";
		if (request.getParameter(HIN_NO) == null) {
			if (request.getParameter("hinNoId") != null
					&& !(request.getParameter("hinNoId").equals(""))) {
				hinNo = request.getParameter("hinNoId");
			}
		}

		if (request.getParameter("billNo") != null
				&& !(request.getParameter("billNo").equals(""))) {
			billNo = request.getParameter("billNo");
		}
		System.out.println("billno." + billNo);
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = billingHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("billNo", billNo);
		parameters.put("hinNo", hinNo);
		try {

			HMSUtil.generateReport("opDispendingBillDetail", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printBillPrintingIpdReceiptReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String billNo = "";

		if (request.getParameter("textfield") != null) {
			billNo = request.getParameter("textfield");
		}

		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("receiptNo", billNo);
		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));

		HMSUtil.generateReport("Receipt", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView printRefundReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String refundNo = "";

		if (request.getParameter("billNo") != null) {
			refundNo = request.getParameter("billNo");
		}
		String duplicate = "";

		if (request.getParameter("duplicate") != null) {
			duplicate = request.getParameter("duplicate");
		}
		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("refundno", refundNo);
		parameters.put("Duplicate", duplicate);
		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));

		String clientIP = request.getRemoteAddr();

		Map<String, Object> printerDtMap = new HashMap<String, Object>();
		printerDtMap.put("reportName", "CashRefund");
		printerDtMap.put("clientIP", clientIP);
		printerDtMap.put("reportType", "bill");
		printerDtMap.put("parameters", parameters);

		directPrintToPrinter(printerDtMap);

		HMSUtil.generateReport("CashRefund", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView printCondomnation(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Integer request_no = 0;

		if (request.getParameter("requestId") != null) {
			request_no = Integer.parseInt(request.getParameter("requestId"));
		}
		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("request_no", request_no);
		HMSUtil.generateReport("kfc_form", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}
	
	
	public ModelAndView printCondomnationByCommitee(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String kfcFormNo = "";

		if (request.getParameter("kfcFormNo") != null) {
			kfcFormNo = request.getParameter("kfcFormNo");
		}
		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("kfcFormNo", kfcFormNo);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		
		HMSUtil.generateReport("kfc_form_final", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}
	
	
	

	public ModelAndView printReceiptReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String receiptNo = "";

		if (request.getParameter("billNo") != null) {
			receiptNo = request.getParameter("billNo");
		}
		String duplicate = "";

		if (request.getParameter("duplicate") != null) {
			duplicate = request.getParameter("duplicate");
		}

		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("receiptNo", receiptNo);
		parameters.put("Duplicate", duplicate);
		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));

		detailsMap = billingHandlerService.getConnectionForReport();

		String clientIP = request.getRemoteAddr();

		Map<String, Object> printerDtMap = new HashMap<String, Object>();
		printerDtMap.put("reportName", "Receipt");
		printerDtMap.put("clientIP", clientIP);
		printerDtMap.put("reportType", "bill");
		printerDtMap.put("parameters", parameters);

		directPrintToPrinter(printerDtMap);

		HMSUtil.generateReport("Receipt", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView printCashRefundRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		String fromDate = null;
		String toDate = null;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int hospitalId = 0;
		dataMap = getHospitalParameterDetails(request);
		hospitalId = (Integer) dataMap.get("hospitalId");

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = request.getParameter(FROM_DATE);
		}
		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("fromDate",
				HMSUtil.convertStringTypeDateToDateType(fromDate));
		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));

		if (request.getParameter(TO_DATE) != null) {
			toDate = request.getParameter(TO_DATE);
		}
		parameters.put("hospitalId", hospitalId);
		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("toRefundDate", HMSUtil // parameters.put("toDate",
												// HMSUtil) replace if there is
												// some problem
				.convertStringTypeDateToDateType(toDate));

		HMSUtil.generateReport("CashRefundAdviceRegisterDate", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	/* opd statistical data */
	public ModelAndView printOPDStatisticalData(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		String fromDate = null;
		String toDate = null;

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = request.getParameter(FROM_DATE);
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = request.getParameter(TO_DATE);

		}
		parameters.put("fromDate",
				HMSUtil.convertStringTypeDateToDateType(fromDate));
		parameters.put("toDate",
				HMSUtil.convertStringTypeDateToDateType(toDate));
		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));

		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		// billingHandlerService.executeProcedureForReport(parameters);

		parameters.put("HOSPITAL_ID", hospitalId);
		detailsMap = billingHandlerService.getConnectionForReport();
		// parameters.put("toRefundDate",
		// HMSUtil.convertStringTypeDateToDateType(toDate));

		HMSUtil.generateReport("OPDStatisticalData", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView printReportForBilling(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Date fromDate;
		Date toDate;
		byte[] bytes = null;
		HttpSession session = request.getSession();
		String reportName = "";

		try {
			Map<String, Object> connectionMap = billingHandlerService
					.getConnectionForReport();
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			dataMap = getHospitalParameterDetails(request);
			requestParameters.put("hospitalName",
					(String) dataMap.get("hospitalName"));
			requestParameters.put("hospitalAddress",
					(String) dataMap.get("hospitalAddress"));
			if (request.getParameter("reportName") != null
					&& !(request.getParameter("reportName").equals(""))) {
				reportName = (request.getParameter("reportName"));

			}

			requestParameters.put("deptId",
					(Integer) session.getAttribute("deptId"));
			requestParameters.put("deptName",
					(String) session.getAttribute("deptName"));

			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport(reportName), requestParameters,
					(Connection) connectionMap.get("conn"));
		} catch (JRException e) {
			e.printStackTrace();
		}

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ reportName + "");

		int b = bytes.length;
		response.setContentLength(b);
		try {
			ServletOutputStream outputStream = response.getOutputStream();

			outputStream.write(bytes, 0, bytes.length);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
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

	@SuppressWarnings("unchecked")
	public Map<String, Object> getHospitalParameterDetails(
			HttpServletRequest request) {
		int hospitalId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<MasSetupParameterMaintaince> masSetupParameterMaintainceList = new ArrayList<MasSetupParameterMaintaince>();
		hospitalId = Integer.parseInt(request.getSession()
				.getAttribute(HOSPITAL_ID).toString());
		dataMap.put(HOSPITAL_ID, hospitalId);
		dataMap = hospitalDetailsMasterHandlerService
				.getSetupParameterMap(dataMap);
		if (dataMap.get("masSetupParameterMaintainceList") != null) {
			masSetupParameterMaintainceList = (List<MasSetupParameterMaintaince>) dataMap.get("masSetupParameterMaintainceList");
			if(null !=masSetupParameterMaintainceList.get(0) && null !=masSetupParameterMaintainceList.get(0).getHospital()){
			dataMap.put("hospitalName", masSetupParameterMaintainceList.get(0).getHospital().getHospitalName());
			dataMap.put("hospitalAddress",masSetupParameterMaintainceList.get(0).getHospital().getAddress());
			}
			dataMap.put("hospitalId", hospitalId);
		}
		return dataMap;
	}

	public ModelAndView showCashSaleListReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String title = "Cash Sale List Report";

		String jsp = CASH_SALE_REPORT_JSP + ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showCashColectionReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String title = "Cash collection Report";

		String jsp = CASH_COLLECTION_REPORT_JSP + ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	/* Show OPD Statistical Data */
	public ModelAndView showOPDStatisticalData(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String title = "OPD Statistical Data Report";
		String jsp = OPD_Statistical_Data + ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showReceiptlRegisterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "receiptRegister";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showCharityRegisterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "CharityRegister";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printCharityRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		String fromDate = null;
		String toDate = null;

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = request.getParameter(FROM_DATE);
		}

		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("fromDate",
				HMSUtil.convertStringTypeDateToDateType(fromDate));

		if (request.getParameter(TO_DATE) != null) {
			toDate = request.getParameter(TO_DATE);

		}
		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("toDate",
				HMSUtil.convertStringTypeDateToDateType(toDate));
		parameters.put("deptName", (String) session.getAttribute("deptName"));
		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));

		HMSUtil.generateReport("CharityRegister", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView printReceiptRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		String fromDate = null;
		String toDate = null;

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = request.getParameter(FROM_DATE);
		}
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("hospitalId", hospitalId);
		parameters.put("fromDate",
				HMSUtil.convertStringTypeDateToDateType(fromDate));
		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));

		if (request.getParameter(TO_DATE) != null) {
			toDate = request.getParameter(TO_DATE);

		}
		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("toDate",
				HMSUtil.convertStringTypeDateToDateType(toDate));

		HMSUtil.generateReport("ReceiptRegister", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView showDailyShiftChangeCashReportSummaryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		map = billingHandlerService.showUserList();
		jsp += DAILY_SHIFT_CHANGE_CASH_REPORT_SUMMARY_JSP;
		jsp += ".jsp";
		title = "DailyShiftChangeCashReportSummary";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printDailyShiftChangeCashReportSummary(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String fromDate = null;
		String toDate = null;
		String fromTime = "";
		String toTime = "";
		int userId = 0;
		int userId1 = 0;
		HttpSession session = request.getSession();

		Users user = new Users();
		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");
			userId = user.getId();
		}
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");

		}
		Box box = HMSUtil.getBox(request);
		if (box.getInt("userName") != 0) {
			userId1 = box.getInt("userName");
		}

		// Time fromTime = Time.valueOf("00:00:00");
		// Time toTime = Time.valueOf("00:00:00");

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = request.getParameter(FROM_DATE);
		}
		parameters.put("fromDate",
				HMSUtil.convertStringTypeDateToDateType(fromDate));

		if (request.getParameter(TO_DATE) != null) {
			toDate = request.getParameter(TO_DATE);
		}
		parameters.put("toDate",
				HMSUtil.convertStringTypeDateToDateType(toDate));
		/*
		 * if (request.getParameter(FROM_TIME) != null) { fromTime =
		 * Time.valueOf(request.getParameter(FROM_TIME)); }
		 * parameters.put("FromTime", fromTime); if
		 * (request.getParameter(TO_TIME) != null) { toTime =
		 * Time.valueOf(request.getParameter(TO_TIME)); }
		 */
		parameters.put("hospitalId", hospitalId);

		if (request.getParameter(FROM_TIME) != null) {
			fromTime = request.getParameter(FROM_TIME);
		}
		parameters.put("FromTime", fromTime);
		if (request.getParameter(TO_TIME) != null) {
			toTime = request.getParameter(TO_TIME);
		}

		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("ToTime", toTime);

		parameters.put("ChangedBy", userId1);
		HMSUtil.generateReport("DailyShiftChangeCashReportSummary", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView showShiftChangeOverReportDetailJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = billingHandlerService.showUserList();
		String jsp = "";
		String title = "";

		jsp += SHIFT_CHANGE_OVER_REPORT_DETAIL_JSP;
		jsp += ".jsp";
		title = "ShiftChangeOverReportDetailReport";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printShiftChangeOverReportDetailReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String fromDate = null;
		String toDate = null;

		String fromTime = null;
		String toTime = null;

		/*
		 * Time fromTime = Time.valueOf("00:00:00"); Time toTime =
		 * Time.valueOf("00:00:00");
		 */
		int userId1 = 0;
		int userId = 0;
		HttpSession session = request.getSession();

		Users user = new Users();
		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");
			userId = user.getId();
		}

		if (box.getInt("userName") != 0) {
			userId1 = box.getInt("userName");
		}

		/*
		 * Time fromTime = Time.valueOf("00:00:00"); Time toTime =
		 * Time.valueOf("00:00:00");
		 */

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = request.getParameter(FROM_DATE);
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = request.getParameter(TO_DATE);
		}

		if (request.getParameter(FROM_TIME) != null) {
			fromTime = request.getParameter(FROM_TIME);
		}

		if (request.getParameter(TO_TIME) != null) {
			toTime = request.getParameter(TO_TIME);
		}

		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		}
		parameters.put("hospitalId", hospitalId);

		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("fromDate",
				HMSUtil.convertStringTypeDateToDateType(fromDate));
		parameters.put("toDate",
				HMSUtil.convertStringTypeDateToDateType(toDate));
		parameters.put("fromTime", fromTime);
		parameters.put("toTime", toTime);
		parameters.put("changedBy", userId1);

		HMSUtil.generateReport("ShiftChangeOverReportDetail", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView showDailyCashReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasScheme> schemeList=billingHandlerService.getAllSchemeList();
		String jsp = "";
		String title = "";
		jsp += DAILY_CASH_REPORT_JSP;
		jsp += ".jsp";
		title = "Daily Cash Report";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("schemeList", schemeList);

		return new ModelAndView("index", "map", map);
	}

	/*public ModelAndView printDailyCashReport(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String reportName = "";
		String fromDate = null;
		String toDate = null;
		String hospitalName = null;
		int hospitalId = 0;
		detailsMap = getHospitalParameterDetails(request);
		hospitalName = (String) detailsMap.get("hospitalName") + ","
				+ (String) detailsMap.get("hospitalAddress");
		hospitalId = (Integer) detailsMap.get("hospitalId");
		System.out.println("hospitalName"+hospitalName);
		System.out.println("hospitalId"+hospitalId);
		
		 * Time fromTime = Time.valueOf("00:00:00"); Time toTime =
		 * Time.valueOf("00:00:00");
		 

		String fromTime = "";
		String toTime = "";

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = request.getParameter(FROM_DATE);
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = request.getParameter(TO_DATE);
		}

		if (request.getParameter(FROM_TIME) != null) {
			fromTime = request.getParameter(FROM_TIME);
		}

		if (request.getParameter("reportType") != null) {
			reportName = request.getParameter("reportType");
		}
		if (request.getParameter(TO_TIME) != null) {
			toTime = request.getParameter(TO_TIME);
		}

		parameters.put("fromTime1", fromTime);
		parameters.put("toTime1", toTime);
		parameters.put("fromDate",
				HMSUtil.convertStringTypeDateToDateType(fromDate));
		parameters.put("toDate",
				HMSUtil.convertStringTypeDateToDateType(toDate));
		parameters.put("hospital_name", hospitalName);
		parameters.put("hospitalId", hospitalId);

		if (reportName.equalsIgnoreCase("deatils")) {
			billingHandlerService
					.executeProcedureForDailyCashReport(parameters);

			reportName = "daliy_cash_report_new";
		} else {
			reportName = "DailyCashReport";
		}
System.out.println("reportName  "+reportName);
		detailsMap = billingHandlerService.getConnectionForReport();

		HMSUtil.generateReport(reportName, parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}*/
   /*Changes by Srikanth*/
	public ModelAndView printDailyCashReport(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String reportName = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		//String hospitalName = null;
		int hospitalId = 0;
		detailsMap = getHospitalParameterDetails(request);
		/*hospitalName = (String) detailsMap.get("hospitalName") + ","
				+ (String) detailsMap.get("hospitalAddress");*/
		hospitalId = (Integer) detailsMap.get("hospitalId");
		//System.out.println("hospitalName"+hospitalName);
		System.out.println("hospitalId"+hospitalId);
		/*
		 * Time fromTime = Time.valueOf("00:00:00"); Time toTime =
		 * Time.valueOf("00:00:00");
		 */
		String scheme="";
		if(null != request.getParameter("scheme") && !request.getParameter("scheme").equals("0")){
			scheme=request.getParameter("scheme");
			parameters.put("schemeParam", "and ms.scheme_id = " + Integer.parseInt(scheme));
		}
		System.out.println("Scheme "+scheme);
		String fromTime = "";
		String toTime = "";

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}

		if (request.getParameter(FROM_TIME) != null) {
			fromTime = request.getParameter(FROM_TIME);
		}
    
    
		if (request.getParameter("reportType") != null) {
			reportName = request.getParameter("reportType");
		}
		if (request.getParameter(TO_TIME) != null) {
			toTime = request.getParameter(TO_TIME);
		}

		parameters.put("fromTime", fromTime);
		parameters.put("toTime", toTime);
		
		parameters.put("fromDate", fromDate);
				//HMSUtil.convertStringTypeDateToDateType(fromDate));
		parameters.put("toDate", toDate);
				//HMSUtil.convertStringTypeDateToDateType(toDate));
		//parameters.put("hospital_name", hospitalName);
		parameters.put("hospitalId", hospitalId);
		
		System.out.println(fromTime);
	    System.out.println(toTime);
	    System.out.println(fromDate);
	    System.out.println(toDate);
	   /* System.out.println(HMSUtil.convertStringTypeDateToDateType(fromDate));
	    System.out.println(HMSUtil.convertStringTypeDateToDateType(toDate));*/
		/*if (reportName.equalsIgnoreCase("deatils")) {
			billingHandlerService
					.executeProcedureForDailyCashReport(parameters);

			reportName = "daliy_cash_report_new";
		} else {
			reportName = "DailyCashReport";
		}*/
		reportName = "DailyCashReport2";
System.out.println("reportName  "+reportName);
		detailsMap = billingHandlerService.getConnectionForReport();

		HMSUtil.generateReport(reportName, parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	/*** Past Due JSp ****/

	public ModelAndView showPastDuesJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		jsp = PAST_DUES_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView retrivePastDue(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		String pastDue = "";
		if (request.getParameter("pastDue") != null) {
			pastDue = request.getParameter("pastDue");
		}
		parameters.put("pastDue", pastDue);
		billingHandlerService.executeProcedureForRetrivePastDue(parameters);

		String jsp = "";
		jsp = RETRIVE_PAST_DUE;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printPastDuesReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Integer minAmount = new Integer(0);
		String fromDate = "";
		String toDate = "";
		String hin = "";
		String query = "";
		String query1 = "";
		java.sql.Date startDate = null;
		java.sql.Date endDate = null;

		if (request.getParameter(MIN_AMOUNT) != null) {
			minAmount = new Integer(request.getParameter(MIN_AMOUNT));
		}
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = request.getParameter(FROM_DATE);

		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = request.getParameter(TO_DATE);

		}

		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hin = request.getParameter(HIN_NO);
		}

		if (!(fromDate.equals("")) && !(toDate.equals(""))) {
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String date4MySQL1 = formatterOut.format(HMSUtil
					.convertStringTypeDateToDateType(fromDate));
			String date4MySQL2 = formatterOut.format(HMSUtil
					.convertStringTypeDateToDateType(toDate));
			startDate = java.sql.Date.valueOf(date4MySQL1);
			endDate = java.sql.Date.valueOf(date4MySQL2);
		}
		/*
		 * 
		 * 
		 * if(!startDate.equals("") && !startDate.equals(null)) {
		 * parameters.put("startDate", startDate); } else {
		 * 
		 * parameters.put("startDate",null); }
		 * 
		 * !endDate.equals(null)) { parameters.put("endDate", endDate); } else {
		 * 
		 * parameters.put("endDate",null); }
		 */

		if (endDate != null && hin != "") {
			query = " where main.vsdate between '" + startDate + "' and '"
					+ endDate + "' and main.hin_no = '" + hin + "'";
			parameters.put("query", query);
		} else if (endDate != null) {

			query = " where main.vsdate between '" + startDate + "' and '"
					+ endDate + "'";
			parameters.put("query", query);
		}

		else if (!(hin.equals(""))) {
			query = " where main.hin_no = '" + hin + "'";
			parameters.put("query", query);

		}

		query1 = "where patient_type_id not in (1,4) and past_due  !='0' and past_due >=  '"
				+ minAmount + "'";

		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("minAmount", minAmount);
		parameters.put("query1", query1);
		// parameters.put("startDate", startDate);
		//
		/*
		 * parameters.put("endDate", endDate);
		 */
		// parameters.put("hin", hin);
		HMSUtil.generateReport("PastDuesReport", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView showDoctorPerformanceJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		jsp = DOCTOR_PERFORMANCE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printDoctorPerformanceReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String fromDate = null;
		String toDate = null;

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = request.getParameter(FROM_DATE);
		}
		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("fromDate",
				HMSUtil.convertStringTypeDateToDateType(fromDate));

		if (request.getParameter(TO_DATE) != null) {
			toDate = request.getParameter(TO_DATE);

		}
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		}
		parameters.put("hospitalId", hospitalId);
		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("toDate",
				HMSUtil.convertStringTypeDateToDateType(toDate));

		HMSUtil.generateReport("DoctorPerformanceReport", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView showDateWiseReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String flag = "";
		flag = box.getString("flag");
		String jsp = "dateSearchForReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("flag", flag);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printCashCollectionReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String flag = "";
		String reportName = "";
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		}
		fromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(FROM_DATE));
		toDate = HMSUtil
				.convertStringTypeDateToDateType(box.getString(TO_DATE));
		flag = box.getString("flag");

		detailsMap = billingHandlerService.getConnectionForReport();

		if (flag.equals("mainCharge")) {
			reportName = "CashCollectionReport(MainChargeWise)";
		} else if (flag.equals("subCharge")) {
			reportName = "CashCollectionReport(SubChargeWise)";
		} else if (flag.equals("charge")) {
			reportName = "CashCollectionReport(ChargeWise)";
		}
		parameters.put("hospitalId", hospitalId);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("flag", flag);

		boolean procStatus = billingHandlerService
				.printCashCollectionReport(parameters);

		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));

		if (procStatus) {
			HMSUtil.generateReport(reportName, parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		}

		return null;
	}

	public ModelAndView printCashCollectionIPChargeWiseReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		Box box = HMSUtil.getBox(request);

		fromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(FROM_DATE));
		toDate = HMSUtil
				.convertStringTypeDateToDateType(box.getString(TO_DATE));

		detailsMap = billingHandlerService.getConnectionForReport();

		parameters.put("flag", "ipCharge");
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		boolean procStatus = billingHandlerService
				.printCashCollectionReport(parameters);

		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));

		if (procStatus) {
			HMSUtil.generateReport("CashCollectionReport_IP_Patient",
					parameters, (Connection) detailsMap.get("conn"), response,
					getServletContext());
		}

		return null;

	}

	public ModelAndView showBillRegisterReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String flag = "";
		flag = box.getString("flag");
		String jsp = "billRegisterReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("flag", flag);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printBillRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String flag = "";
		Box box = HMSUtil.getBox(request);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int hospitalId = 0;
		dataMap = getHospitalParameterDetails(request);
		hospitalId = (Integer) dataMap.get("hospitalId");

		fromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(FROM_DATE));
		toDate = HMSUtil
				.convertStringTypeDateToDateType(box.getString(TO_DATE));
		flag = box.getString("flag");

		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("hospitalId", hospitalId);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));

		String reportName = "";
		String criteria = "";
		if (flag.equals("ipFinalBillRegister")) {
			reportName = "IPFinalBillRegister";

		} else if (flag.equals("billServicingRegister")) {
			reportName = "BillRegisterOPServicing";
			if (!box.getString(PATIENT_TYPE).equals("")) {
				criteria = " and patient_status = '"
						+ box.getString(PATIENT_TYPE) + "'";
			}
			parameters.put("criteria", criteria);

		} else if (flag.equals("billDispensingRegister")) {
			reportName = "BillRegisterDispensing";
			if (!box.getString(PATIENT_TYPE).equals("")) {
				criteria = " and patient_status = '"
						+ box.getString(PATIENT_TYPE) + "'";
			}
			parameters.put("criteria", criteria);

		} else if (flag.equals("ipBillDispensingRegister")) {
			reportName = "BillRegisterIPDispensing";

		} else if (flag.equals("chargeSlipRegister")) {
			reportName = "ChargeSlipRegister";
		}

		HMSUtil.generateReport(reportName, parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView showPatientTypeWiseCashCollection(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = billingHandlerService.getEmployeeList();
		String jsp = "patientTypeEmpCashCollectionReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printPatientTypeWiseCashCollectionReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();

		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		fromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(FROM_DATE));
		toDate = HMSUtil
				.convertStringTypeDateToDateType(box.getString(TO_DATE));

		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		}
		detailsMap = billingHandlerService.getConnectionForReport();

		parameters.put("hospitalId", hospitalId);

		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));

		String criteria = "";
		String reportName = "";

		if (box.getInt(PATIENT_TYPE) != 0
				&& box.getString(BILL_TYPE).equals("all")) {
			criteria = criteria.concat(" where patient_type_id = "
					+ box.getInt(PATIENT_TYPE) + "and billtype is not null");
		} else if (box.getInt(PATIENT_TYPE) != 0
				&& box.getString(BILL_TYPE).equals("Servicing")) {
			criteria = criteria.concat(" where patient_type_id = "
					+ box.getInt(PATIENT_TYPE) + " and billtype = '"
					+ box.getString(BILL_TYPE) + "'");
		} else if (box.getInt(PATIENT_TYPE) != 0
				&& box.getString(BILL_TYPE).equals("")) {
			criteria = criteria.concat(" where patient_type_id = "
					+ box.getInt(PATIENT_TYPE));
		} else if (box.getInt(PATIENT_TYPE) == 0
				&& box.getString(BILL_TYPE).equals("all")) {
			criteria = criteria
					.concat(" where patient_type_id != 0 and billtype is not null");
		} else if (box.getInt(PATIENT_TYPE) == 0
				&& box.getString(BILL_TYPE).equals("Servicing")) {
			criteria = criteria
					.concat("  where patient_type_id != 0 and billtype = '"
							+ box.getString(BILL_TYPE) + "'");
		} else if (box.getInt(PATIENT_TYPE) == 0
				&& box.getString(BILL_TYPE).equals("")) {
			criteria = criteria.concat(" where patient_type_id != 0");
		}

		/*
		 * if (box.getInt(PATIENT_TYPE) != 0) { criteria =
		 * criteria.concat(" where patient_type_id = " +
		 * box.getInt(PATIENT_TYPE)); } else { criteria =
		 * criteria.concat(" where patient_type_id != 0"); } if
		 * (box.getString(BILL_TYPE).equals("all")) { criteria =
		 * criteria.concat(" and billtype is not null"); } else { criteria =
		 * criteria.concat(" and billtype = '" + box.getString(BILL_TYPE) +
		 * "'"); }
		 */
		parameters.put("sqlString", criteria);
		/*
		 * 
		 * 
		 * Box box = HMSUtil.getBox(request); HttpSession session =
		 * request.getSession();
		 * 
		 * fromDate =
		 * HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE));
		 * toDate =
		 * HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)); int
		 * projectId = box.getInt(PROJECT_ID); String qry = ""; if(projectId !=
		 * 0){ qry = " and company_id = "+projectId; } detailsMap =
		 * billingHandlerService.getConnectionForReport();
		 * 
		 * int hospitalId = 0; if (session.getAttribute(HOSPITAL_ID) != null) {
		 * hospitalId = (Integer) session.getAttribute(HOSPITAL_ID); } String
		 * hName = billingHandlerService.getHospitalName(hospitalId);
		 * 
		 * parameters.put("fromdate", fromDate); parameters.put("todate",
		 * toDate); parameters.put("Hname", hName); parameters.put("qry", qry);
		 * if(box.getString("reportType").equals("1")) { reportName =
		 * "ProjectBillingBothSummary"; } else{ reportName =
		 * "ProjectWiseBillingReportBoth"; }
		 * 
		 * HMSUtil.generateReport(reportName, parameters,
		 * (Connection)detailsMap.get("conn"), response, getServletContext());
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * if(box.getString("flag").equals("patientType")){
		 * if(box.getString(BILL_TYPE).equals("all")){ reportName =
		 * "EmployeePatientTypeCashCollection"; }else
		 * if(box.getString(BILL_TYPE).equals("servicing")){ reportName =
		 * "EmployeePatientTypeServCashCollection"; }else
		 * if(box.getString(BILL_TYPE).equals("dispensing")){ reportName =
		 * "EmployeePatientTypeDispCashCollection"; } }else{
		 * if(box.getString(BILL_TYPE).equals("all")){ reportName =
		 * "EmployeeCashCollection"; }else
		 * if(box.getString(BILL_TYPE).equals("servicing")){ reportName =
		 * "EmployeeServicingCashCollection"; }else
		 * if(box.getString(BILL_TYPE).equals("dispensing")){ reportName =
		 * "EmployeeDispensingCashCollection"; } }
		 */
		if (box.getString("reportType").equals("1")) {
			reportName = "PatientTypeWiseCashCollectionReport";
		} else {
			reportName = "PatientTypeWiseCashCollectionReportBoth";
		}
		HMSUtil.generateReport(reportName, parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView showAuthorizorWiseBillingJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String title = "Authorizor Wise Billing Report";
		map = billingHandlerService.getAuthorizrList();
		String jsp = AUTHORIZER_WISE_REPORT_JSP + ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showCompanyWiseBillingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		/* Map<String, Object> map = new HashMap<String, Object>(); */
		map = billingHandlerService.getCompanyList();
		String title = "Company Wise Billing Report";

		String jsp = COMPANY_WISE_REPORT_JSP + ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printAuthorizorWiseBillingReport(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		Box box = HMSUtil.getBox(request);

		fromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(FROM_DATE));
		toDate = HMSUtil
				.convertStringTypeDateToDateType(box.getString(TO_DATE));
		int authorizerId = box.getInt(AUTHORIZER_ID);
		String qry = "";
		String reportName = "";
		if (authorizerId != 0) {
			qry = " and authorizer_id = " + authorizerId;
		}
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		}
		detailsMap = billingHandlerService.getConnectionForReport();

		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("hospitalId", hospitalId);
		parameters.put("qry", qry);
		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));
		if (box.getString("reportType").equals("1")) {
			reportName = "authorizorWiseBillingReport_Ip";
		} else if (box.getString("reportType").equals("2")) {
			reportName = "authorizorWiseBillingReport_op";
		} else {
			reportName = "authorizorWiseBillingReport";
		}

		HMSUtil.generateReport(reportName, parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView printCompanyWiseBillingReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String reportName = "";
		Integer company_id = 0;
		String hinNo = "";
		Box box = HMSUtil.getBox(request);

		fromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(FROM_DATE));
		toDate = HMSUtil
				.convertStringTypeDateToDateType(box.getString(TO_DATE));
		if (box.getInt("companyname") != 0) {
			company_id = box.getInt("companyname");
		}
		if (box.getString("Hin") != null) {
			hinNo = box.getString("Hin");
		}
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		}

		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("hospitalId", hospitalId);
		parameters.put("fromBillDate", fromDate);
		parameters.put("toBillDate", toDate);
		parameters.put("company_id", company_id);
		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));

		parameters.put("hin_no", hinNo);

		if (box.getString("reportType").equals("1")) {
			reportName = "companyWiseBillingReport";
		} else {
			reportName = "CompanyWiseBillDetals";
			parameters.put("SUBREPORT_DIR",
					getServletContext().getRealPath("/Reports/"));

		}
		/* String reportName = "companyWiseBillingReport"; */

		HMSUtil.generateReport(reportName, parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView showEmployeeWiseBillingReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String title = "Employee Wise Billing Report";

		String jsp = EMPLOYEE_WISE_BILLING_REPORT_JSP + ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printEmployeeWiseBillingReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String reportName = "";
		String hin = "";
		Box box = HMSUtil.getBox(request);

		fromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(FROM_DATE));
		toDate = HMSUtil
				.convertStringTypeDateToDateType(box.getString(TO_DATE));
		hin = box.getString("hin");

		detailsMap = billingHandlerService.getConnectionForReport();

		parameters.put("fromdate", fromDate);
		parameters.put("todate", toDate);
		parameters.put("hinno", hin);
		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));

		reportName = "EmployeeWiseBillingReport";

		HMSUtil.generateReport(reportName, parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView showProjectBillingBothSummaryReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		map = billingHandlerService.getCompanyList();

		String title = "Project Billing Both Summary Report";

		String jsp = PROJECT_BILLING_BOTH_SUMMARY_REPORT_JSP + ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printProjectBillingReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String reportName = "";
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();

		fromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(FROM_DATE));
		toDate = HMSUtil
				.convertStringTypeDateToDateType(box.getString(TO_DATE));
		int projectId = box.getInt(PROJECT_ID);
		String qry = "";
		if (projectId != 0) {
			qry = " and company_id = " + projectId;
		}
		detailsMap = billingHandlerService.getConnectionForReport();

		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		String hName = billingHandlerService.getHospitalName(hospitalId);

		parameters.put("fromBillDate", fromDate);
		parameters.put("toBillDate", toDate);
		parameters.put("Hname", hName);
		parameters.put("qry", qry);
		parameters.put("company_id", projectId);
		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));

		if (box.getString("reportType").equals("1")) {
			reportName = "projectWiseBillingReport";
		} else {
			reportName = "ProjectWiseBillDetals";
			parameters.put("SUBREPORT_DIR",
					getServletContext().getRealPath("/Reports/"));
		}

		HMSUtil.generateReport(reportName, parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView showAdvanceAdjustmentReortJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String title = "Advance Adjustment Report";

		String jsp = ADVANCE_ADJUSTMENT_REPORT_JSP + ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printAdvanceAdjustmentReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();

		String hospitalName = "";
		int hospitalId = 0;
		dataMap = getHospitalParameterDetails(request);
		hospitalName = (String) dataMap.get("hospitalName") + ","
				+ (String) dataMap.get("hospitalAddress");
		hospitalId = (Integer) dataMap.get("hospitalId");

		fromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(FROM_DATE));
		toDate = HMSUtil
				.convertStringTypeDateToDateType(box.getString(TO_DATE));

		detailsMap = billingHandlerService.getConnectionForReport();

		parameters.put("hospitalId", hospitalId);
		parameters.put("fromdate", fromDate);
		parameters.put("todate", toDate);
		parameters.put("Hname", hospitalName);
		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));

		String reportName = "AdvanceAdjustmentReport";

		HMSUtil.generateReport(reportName, parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView showCharityRegisterReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String title = "Charity Register Report";

		String jsp = CHARITY_REGISTER_IP_OP_REPORT_JSP + ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printCharityRegisterReportIP(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String reportName = "";
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		String hospitalName = billingHandlerService.getHospitalName(hospitalId);

		fromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(FROM_DATE));
		toDate = HMSUtil
				.convertStringTypeDateToDateType(box.getString(TO_DATE));

		detailsMap = billingHandlerService.getConnectionForReport();

		parameters.put("fromdate", fromDate);
		parameters.put("todate", toDate);
		parameters.put("Hname", hospitalName);
		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));

		if (request.getParameter("patientType").equals("1")) {
			reportName = "CharityRegisterIP";
		} else {
			reportName = "CharityRegisterOP";
		}

		HMSUtil.generateReport(reportName, parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView printAccountStatusOfIPReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		Box box = HMSUtil.getBox(request);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		String hospitalName = null;
		int hospitalId = 0;
		dataMap = getHospitalParameterDetails(request);

		hospitalName = (String) dataMap.get("hospitalName");
		hospitalId = (Integer) dataMap.get("hospitalId");

		fromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(FROM_DATE));
		toDate = HMSUtil
				.convertStringTypeDateToDateType(box.getString(TO_DATE));

		detailsMap = billingHandlerService.getConnectionForReport();

		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("Hname", hospitalName);
		parameters.put("hospitalId", hospitalId);

		String reportName = "";
		reportName = "AccountStatusIp";

		HMSUtil.generateReport(reportName, parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	/**** Past Due Details **/
	public ModelAndView showRetrivePastDueJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		jsp = RETRIVE_PAST_DUE;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAccountRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String title = "Account Register Reports";
		map = billingHandlerService.showAccountRegister();
		String jsp = "";
		jsp = BILLING_REGISTER_JSP + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printAccountRegisterReports(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String accountType = "";

		Map<String, Object> dataMap = new HashMap<String, Object>();
		String hospitalName = null;
		int hospitalId = 0;
		dataMap = getHospitalParameterDetails(request);

		hospitalName = (String) dataMap.get("hospitalName");
		hospitalId = (Integer) dataMap.get("hospitalId");

		String reportName = "";
		Box box = HMSUtil.getBox(request);

		fromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(FROM_DATE));
		toDate = HMSUtil
				.convertStringTypeDateToDateType(box.getString(TO_DATE));
		accountType = box.getString(ACCOUNT_TYPE);

		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("hospitalId", hospitalId);
		parameters.put("fromdate", fromDate);
		parameters.put("todate", toDate);
		parameters.put("accounttype", accountType);
		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));

		if (accountType.equals("Bank Account")) {
			reportName = "AccountRegister_BankAccount";
		} else if (accountType.equals("Cash Account")) {
			reportName = "AccountRegister_CashAccount";
		} else if (accountType.equals("Charity")) {
			reportName = "AccountRegister_CharityAccount";
		}/*
		 * else if (accountType.equals("Expenditure")) { reportName = ""; }
		 */else if (accountType.equals("On Account")) {
			reportName = "AccountRegister_ONAccount";
		}/*
		 * else if (accountType.equals("A/c Payable")) { reportName = ""; } else
		 * if (accountType.equals("A/c Receivalbe")) { reportName = ""; }
		 */else if (accountType.equals("Receipt")) {
			reportName = "AccountRegister_ReceiptAccount";
		} else if (accountType.equals("Advance/Adjustment")) {
			reportName = "AccountRegister_AdvanceAdjAccount";
		} else if (accountType.equals("Refund")) {
			reportName = "AccountRegister_RefundAccount";
		} else if (accountType.equals("Rounded Off")) {
			reportName = "AccountRegister_RountoffAccount";
		}

		HMSUtil.generateReport(reportName, parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView showDepartmentWiseCash(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String title = "Account Register Reports";
		map = billingHandlerService.showDepartmentWiseCash();
		String jsp = "";
		jsp = DEPARTMENT_WISE_CASH + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printDepartmentWiseCashReports(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String patient = "";
		String summary = "";
		int deptId = 0;
		String reportName = "";
		String qry = "";
		Box box = HMSUtil.getBox(request);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		String hospitalName = null;
		int hospitalId = 0;
		dataMap = getHospitalParameterDetails(request);

		hospitalName = (String) dataMap.get("hospitalName");
		hospitalId = (Integer) dataMap.get("hospitalId");

		fromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(FROM_DATE));
		toDate = HMSUtil
				.convertStringTypeDateToDateType(box.getString(TO_DATE));
		patient = box.getString("patient");
		summary = box.getString("summary");

		if (box.getInt(DEPARTMENT) != 0) {
			deptId = box.getInt(DEPARTMENT);

		}
		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("hospitalId", hospitalId);
		parameters.put("fromdate", fromDate);
		parameters.put("todate", toDate);
		parameters.put("department_id", deptId);
		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));

		/* parameters.put("", value) */
		if (patient.equals("inPatient") && summary.equals("summary")) {
			reportName = "DepartmentwiseCash_IP_Summary";
		}
		if (patient.equals("outPatient") && summary.equals("summary")) {
			reportName = "DepartmentwiseCash_OP_Summary";
		}
		if (patient.equals("both") && summary.equals("summary")) {
			reportName = "DepartmentwiseCash_Both_Summary";
		}
		if (patient.equals("inPatient") && summary.equals("detail")) {
			reportName = "DepartmentwiseCash_IP_Details";
		}
		if (patient.equals("outPatient") && summary.equals("detail")) {
			reportName = "DepartmentwiseCash_OP_Details";
		}
		if (patient.equals("both") && summary.equals("detail")) {
			reportName = "DepartmentwiseCash_Both_Details";
		}
		HMSUtil.generateReport(reportName, parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView showFinalBillReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "ipFinalBillReport.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printIPFinalBillReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		Box box = HMSUtil.getBox(request);

		String adNo = box.getString(AD_NO);

		int inpatientId = 0;
		inpatientId = billingHandlerService.getInpatientId(adNo);
		detailsMap = billingHandlerService.getConnectionForReport();

		/*
		 * parameters.put("fromDate", fromDate); parameters.put("toDate",
		 * toDate);
		 */
		String reportName = "";
		if (box.getString("reportType").equals("summary")) {
			reportName = "finalsettlementSummary";
		} else if (box.getString("reportType").equals("detail")) {
			reportName = "finalsettlementDetail";
		} else if (box.getString("reportType").equals("patientDetail")) {
			reportName = "patientFinalsettlementDetail";
		}
		//
		parameters.put("inpatientId", inpatientId);
		/*
		 * parameters.put("IMAGE_DIR",
		 * getServletContext().getRealPath("/jsp/images/svb.jpg"));
		 * parameters.put("IMAGE_DIR_LFT",
		 * getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		 * parameters.put("IMAGE_VN_RKS",
		 * getServletContext().getRealPath("/jsp/images/rks.gif"));
		 * parameters.put("IMAGE_VN_BHAVE",
		 * getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));
		 */
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));

		HMSUtil.generateReport(reportName, parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView printIPFinalSetlementBillReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		Box box = HMSUtil.getBox(request);

		String adNo = box.getString(AD_NO);

		int inpatientId = 0;
		inpatientId = billingHandlerService.getInpatientId(adNo);
		detailsMap = billingHandlerService.getConnectionForReport();

		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		String reportName = "";
		if (box.getString("reportType").equals("summary")) {
			reportName = "finalBillSettlementSummary";
		} else if (box.getString("reportType").equals("detail")) {
			// reportName = "finalBillSettlementSummary";
			reportName = "finalBillsettlementDetail";
		}
		System.out.println("reportName     " + reportName);
		parameters.put("inpatientId", inpatientId);
		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));

		HMSUtil.generateReport(reportName, parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView showChargeSlipReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "chargeSlipReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printChargeSlipReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("chargeSlipNo", box.getInt("chargeSlipNo"));
		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));

		HMSUtil.generateReport("ChargeSlip", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView getPatientDetailsForOrderBooking(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = (HttpSession) request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = (Integer) session.getAttribute("deptId");
		int hospitalid = (Integer) session.getAttribute(HOSPITAL_ID);

		Box box = HMSUtil.getBox(request);
		box.put("deptId", deptId);
		box.put(HOSPITAL_ID, hospitalid);
		map = billingHandlerService.getPatientDetailsForOrderBooking(box);

		String jsp = "";
		jsp = "ipInvestigationPharmacyBooking" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView viewPrescriptionForOrderBooking(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = (HttpSession) request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = (Integer) session.getAttribute("deptId");

		Box box = HMSUtil.getBox(request);
		box.put("deptId", deptId);
		map = billingHandlerService.viewPrescriptionForOrderBooking(box);

		jsp = VIEW_PRESCRIPTION_FOR_ORDER_BOOKING;
		// jsp +=".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitOrderBookingDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = (HttpSession) request.getSession();
		int departmentId = 0;
		int hospitalId = 0;
		if (session.getAttribute("deptId") != null)
			departmentId = (Integer) session.getAttribute("deptId");

		if (session.getAttribute("hospitalId") != null)
			hospitalId = (Integer) session.getAttribute("hospitalId");
		int userId = 0;

		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			userId = user.getId();
			box.put("userId", user.getId());
			box.put("requestById", user.getEmployee().getId());
		}
		box.put("departmentId", departmentId);
		box.put("hospitalId", hospitalId);

		int chargeSlipNo = 0;
		chargeSlipNo = billingHandlerService
				.getChargeSlipNo("save", hospitalId);
		box.put("chargeSlipNo", chargeSlipNo);
		String orderNo = labHandlerService.generateOrderNumber();
		box.put("orderNo", orderNo);

		returnMap = billingHandlerService.submitOrderBookingDetails(box);

		String jsp = "";
		map = ipdHandlerService
				.getPatientList(departmentId, hospitalId, userId);
		List set = (List) map.get("inpatientSet");
		map.put("inPatientSet", set);
		jsp = PATIENT_LIST_JSP;
		jsp += ".jsp";
		String title = "Admitted Patient List";
		map.put("deptId", departmentId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPatientDrugIssueJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int deptId = 0;
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));

		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);

		map = billingHandlerService.getPatientListForDrugIssue(box);
		String jsp = "patientDrugIssueSearch.jsp";
		String includedJsp = "responseGridForPatientDrugIssue.jsp";
		map.put("includedJsp", includedJsp);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getPatientDrugIssueDetails(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		int deptId = 0;
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));

		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		String deptCode = "";
		deptList = billingHandlerService.getDepartmentDetails(deptId);
		MasDepartment department = new MasDepartment();
		department = deptList.get(0);
		deptCode = department.getDepartmentCode();

		map = billingHandlerService.getPatientDrugIssueDetails(box);
		String jsp = "";
		jsp = "patientDrugIssue.jsp";
		map.put("contentJsp", jsp);
		map.put("deptCode", deptCode);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitPatientDrugIssueAndBillingDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();

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
		String billNo = "";
		String billType = "OD";
		billNo = opBillingHandlerService.generateBillNo(billType, "save",
				hospitalId);
		box.put("billNo", billNo);
		returnMap = billingHandlerService
				.submitPatientDrugIssueAndBillingDetails(box);
		boolean flag = false;
		if (returnMap.get("flag") != null) {
			flag = (Boolean) returnMap.get("flag");
		}
		String message = "";
		if (flag) {
			message = "Drugs issued to Patient.";
		} else {
			message = "Try Again!";
		}

		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		box.put("deptId", deptId);

		map = billingHandlerService.getPatientListForDrugIssue(box);
		String jsp = "patientDrugIssueSearch.jsp";
		String includedJsp = "responseGridForPatientDrugIssue.jsp";
		map.put("message", message);
		map.put("includedJsp", includedJsp);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showDayEndReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";

		jsp += DAY_END_REPORT_JSP;
		jsp += ".jsp";
		title = "Day End Report";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printDayEndReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String fromDate = null;
		String toDate = null;
		String fromTime = "";
		String toTime = "";
		int userId = 0;
		HttpSession session = request.getSession();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String hospitalName = null;
		String hospitalAdd = null;
		int hospitalId = 0;
		/*
		 * Users user = new Users(); if(session.getAttribute("users") != null){
		 * user = (Users)session.getAttribute("users"); userId = user.getId(); }
		 */

		/*
		 * Time fromTime = Time.valueOf("00:00:00"); Time toTime =
		 * Time.valueOf("00:00:00");
		 */

		dataMap = getHospitalParameterDetails(request);
		hospitalName = (String) dataMap.get("hospitalName");
		hospitalAdd = (String) dataMap.get("hospitalAddress");
		hospitalId = (Integer) dataMap.get("hospitalId");
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = request.getParameter(FROM_DATE);
		}
		if (request.getParameter(FROM_TIME) != null) {
			fromTime = request.getParameter(FROM_TIME);
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = request.getParameter(TO_DATE);
		}
		if (request.getParameter(TO_TIME) != null) {
			toTime = request.getParameter(TO_TIME);
		}

		parameters.put("fromDate",
				HMSUtil.convertStringTypeDateToDateType(fromDate));
		parameters.put("toDate",
				HMSUtil.convertStringTypeDateToDateType(toDate));
		parameters.put("fromTime", fromTime);
		parameters.put("toTime", toTime);
		parameters.put("hospital_name", hospitalName);
		parameters.put("hospital_add", hospitalAdd);
		parameters.put("hospitalId", hospitalId);
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));

		detailsMap = billingHandlerService.getConnectionForReport();
		// parameters.put("changedBy", userId);
		HMSUtil.generateReport("day_end_report", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView getInpatientId(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String adNo = box.getString("adNo");

		int inpatientId = 0;
		inpatientId = billingHandlerService.getInpatientId(adNo);

		map.put("inpatientId", inpatientId);
		return new ModelAndView("billingResponseForInpatientId", "map", map);
	}

	@SuppressWarnings("unchecked")
	public void directPrintToPrinter(Map<String, Object> printerDtMap) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String reportName = "";
		String clientIP = "";
		String reportType = "";
		if (printerDtMap.get("reportName") != null) {
			reportName = (String) printerDtMap.get("reportName");
		}
		if (printerDtMap.get("clientIP") != null) {
			clientIP = (String) printerDtMap.get("clientIP");
		}
		if (printerDtMap.get("reportType") != null) {
			reportType = (String) printerDtMap.get("reportType");
		}
		if (printerDtMap.get("parameters") != null) {
			parameters = (Map<String, Object>) printerDtMap.get("parameters");
		}
		try {

			detailsMap = billingHandlerService.getConnectionForReport();

			List<PrinterCofiguration> printerList = new ArrayList<PrinterCofiguration>();
			Map<String, Object> generalmap = new HashMap<String, Object>();
			generalmap.put("reportType", reportType);
			generalmap.put("clientIP", clientIP);
			printerList = billingHandlerService
					.getPrinterConfigurationList(generalmap);
			JasperReport jasperReport = JasperCompileManager
					.compileReport(getServletContext().getRealPath(
							"/Reports/" + reportName + ".jrxml"));
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					jasperReport, parameters,
					(Connection) detailsMap.get("conn"));

			PrinterJob job = PrinterJob.getPrinterJob();
			PrintService[] services = PrintServiceLookup.lookupPrintServices(
					null, null);
			int selectedService = 0;
			for (PrinterCofiguration printerCofiguration : printerList) {
				for (int i = 0; i < services.length; i++) {
					if (services[i].getName().equals(
							printerCofiguration.getPrinterName())) {
						selectedService = i;
						break;
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
		}

	}

	// Added By Manjul for Particular wise Discount-------

	public ModelAndView updateFinalBill(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int inpatientId = 0;
		int hospitalId = 0;
		int departmentId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
			box.put("departmentId", departmentId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		if (request.getParameter("inpatientId") != null) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
			box.put("inpatientId", inpatientId);
		}
		String jsp = "";
		String message = "";
		boolean saved = false;
		saved = billingHandlerService.updateFinalBill(box);
		if (saved) {
			message = "Record Saved Successfully!!";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);

		jsp = MESSAGE_FOR_BILLING_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showCashCollectionStatisticsReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String requiredPara = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapHP = new HashMap<String, Object>();
		map = opBillingHandlerService.getDetailsForCashStatisticsReport();
		mapHP = opBillingHandlerService.getHospitalParameterForDispensing();
		if (mapHP.get("dispensingRequired") != null) {
			requiredPara = (String) mapHP.get("dispensingRequired");
		}
		map.put("dispensingRequired", requiredPara);
		String jsp = "billRegisterPatientTypeWiseReport.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printPatientTyprWiseReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String reportName = "Patient_PType_Wise_Bill_Register";
		int mainChargeId = 0;
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(RequestConstants.MAIN_CHARGECODE_ID) != null) {
			mainChargeId = Integer.parseInt(request
					.getParameter(RequestConstants.MAIN_CHARGECODE_ID));
		}
		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("mainChargeId", mainChargeId);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		//
		HMSUtil.generateReport(reportName, parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView showIPFinalBillJSP(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		/*
		 * if (request.getParameter("flag").equals("chargeSlip")) { jsp =
		 * "bill_IPFinalBill"; } else if
		 * (request.getParameter("flag").equals("finalBill")) { jsp =
		 * FINAL_BILL_PATIENT_SEARCH_JSP; }
		 */
		jsp = "bill_IPFinalBill";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * public ModelAndView showIPFinalBillJSP(HttpServletRequest request,
	 * HttpServletResponse response) { Map<String, Object> map = new
	 * HashMap<String, Object>(); String jsp = ""; if
	 * (request.getParameter("flag").equals("chargeSlip")) { jsp =
	 * IP_BILLING_SEARCH_JSP; } else if
	 * (request.getParameter("flag").equals("finalBill")) { jsp =
	 * FINAL_BILL_PATIENT_SEARCH_JSP; } jsp = "bill_IPFinalBill"; jsp += ".jsp";
	 * map.put("contentJsp", jsp); return new ModelAndView("index", "map", map);
	 * }
	 */

	// ======================Payward=====================

	/*
	 * showBillWaitingListBookingPaywardJsp For method of Payward
	 */
	public ModelAndView showBillWaitingListBookingPawardJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int sessionHospitalId = 0;
		sessionHospitalId = (Integer) session.getAttribute("hospitalId");
		Box box = HMSUtil.getBox(request);
		box.put(HOSPITAL_ID, sessionHospitalId);
		map = billingHandlerService.waitingListBookingPaward(box);
		String jsp = "";
		jsp = "bill_WaitingListBookingPayward";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView bookingPayward(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		String ddd = request.getParameter("uhid");
		System.out.println("ddd>>>>>>>>>>" + ddd);
		box.put("hospitalId", hospitalId);
		map = billingHandlerService.bookingPayward(box);
		String jsp = "";
		jsp = "bookingPayward";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * public ModelAndView OPWaitingListPayward(HttpServletRequest request,
	 * HttpServletResponse response) { Map<String, Object> map = new
	 * HashMap<String, Object>(); HttpSession session = request.getSession();
	 * 
	 * int sessionHospitalId = 0; sessionHospitalId =
	 * (Integer)session.getAttribute("hospitalId");
	 * 
	 * Box box = HMSUtil.getBox(request);
	 * map=billingHandlerService.waitingListBookingPaward(box); String jsp = "";
	 * 
	 * jsp = "bill_WaitingListBookingPayward";
	 * 
	 * jsp += ".jsp"; map.put("contentJsp", jsp); return new
	 * ModelAndView("index", "map", map); }
	 */

	public ModelAndView showBillWaitingListAllotmentPaywardJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		System.out
				.println("==============Payward Controller========================");
		int sessionHospitalId = 0;
		sessionHospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		Box box = HMSUtil.getBox(request);
		box.put(HOSPITAL_ID, sessionHospitalId);
		map = billingHandlerService.waitingListAllotmentPayward(box);
		String jsp = "";

		jsp = "paywardAllotmentSearch";

		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView allotmentPayward(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int sessionHospitalId = 0;
		sessionHospitalId = (Integer) session.getAttribute("hospitalId");
		Box box = HMSUtil.getBox(request);
		box.put(HOSPITAL_ID, sessionHospitalId);

		map = billingHandlerService.allotmentPayward(box);
		String jsp = "";
		jsp = "allotmentPayward";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showBillWaitingListRenewalPaywardJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int sessionHospitalId = 0;
		sessionHospitalId = (Integer) session.getAttribute("hospitalId");
		Box box = HMSUtil.getBox(request);
		box.put(HOSPITAL_ID, sessionHospitalId);
		map = billingHandlerService.billWaitingListRenewalSearch(box);
		String jsp = "";
		/* HMSUtil.getDaysDiffBetweenDate(parameterMap) */
		jsp = "paywardRenewalSearch";

		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView renewalPayward(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int sessionHospitalId = 0;
		sessionHospitalId = (Integer) session.getAttribute("hospitalId");
		Box box = HMSUtil.getBox(request);
		box.put(HOSPITAL_ID, sessionHospitalId);

		map = billingHandlerService.renewalPayward(box);
		String jsp = "";
		jsp = "renewalPayward";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * @param request
	 * @param response
	 * @return
	 */

	public ModelAndView submitPaywardDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		boolean saved = false;

		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int userId = (Integer) session.getAttribute(RequestConstants.USER_ID);
		int empId = (Integer) session.getAttribute("empId");

		box.put(HOSPITAL_ID, hospitalId);
		box.put(RequestConstants.USER_ID, userId);
		box.put("empId", empId);

		String receiptNo = "";
		receiptNo = opBillingHandlerService.generateReceiptNo("save",
				hospitalId);
		box.put("receiptNo", receiptNo);

		parameterMap.put("box", box);

		map = billingHandlerService.submitPaywardDetails(parameterMap);
		saved = (Boolean) map.get("saved");
		String message = "";
		String printUrl = "";
		// String url = "";
		if (saved) {
			printUrl = "submitForm('messageBilling','billing?method=printReceiptReport&textfield="
					+ receiptNo + "')";

			/*
			 * String roomTypeCode=(String)map.get("roomType"); Integer
			 * bookingId=(Integer)map.get("bookingId"); printUrl =
			 * "submitForm('messageBilling','billing?method=printReceiptReport&roomtype="
			 * +roomTypeCode+"&boolingId=" + bookingId + "')";
			 */
			map.put("printUrl", printUrl);
			message = "Deposit Information Saved Successfully.Do you want to print receipt?";
		} else {
			message = "Some Problem Occured.";
		}
		map.put("message", message);
		String jsp = MESSAGE_FOR_BILLING_JSP + ".jsp";
		map.put("contentJsp", jsp);
		map.put("billtype", "receipt");
		map.put("billNo", receiptNo);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitAllotmentDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		boolean saved = false;
		int hospitalId = 0;

		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int userId = (Integer) session.getAttribute(RequestConstants.USER_ID);
		int empId = (Integer) session.getAttribute("empId");

		box.put(HOSPITAL_ID, hospitalId);
		box.put(RequestConstants.USER_ID, userId);
		box.put("empId", empId);

		String receiptNo = "";
		receiptNo = opBillingHandlerService.generateReceiptNo("save",
				hospitalId);
		box.put("receiptNo", receiptNo);

		parameterMap.put("box", box);

		map = billingHandlerService.submitAllotmentDetails(parameterMap);
		saved = (Boolean) map.get("saved");
		String message = "";
		String printUrl = "";
		// String url = "";
		if (saved) {
			printUrl = "submitForm('messageBilling','billing?method=printReceiptReport&textfield="
					+ receiptNo + "')";
			map.put("printUrl", printUrl);
			message = "Deposit Information Saved Successfully.Do you want to print receipt?";
		} else {
			message = "Some Problem Occured.";
		}
		map.put("message", message);
		String jsp = MESSAGE_FOR_BILLING_JSP + ".jsp";
		map.put("contentJsp", jsp);
		map.put("billtype", "receipt");
		map.put("billNo", receiptNo);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitRenewaltDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		boolean saved = false;
		int hospitalId = 0;

		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int userId = (Integer) session.getAttribute(RequestConstants.USER_ID);
		int empId = (Integer) session.getAttribute("empId");

		box.put(HOSPITAL_ID, hospitalId);
		box.put(RequestConstants.USER_ID, userId);
		box.put("empId", empId);

		String receiptNo = "";
		receiptNo = opBillingHandlerService.generateReceiptNo("save",
				hospitalId);
		box.put("receiptNo", receiptNo);

		parameterMap.put("box", box);

		map = billingHandlerService.submitRenewaltDetails(parameterMap);
		saved = (Boolean) map.get("saved");
		String message = "";
		String printUrl = "";
		// String url = "";
		if (saved) {
			printUrl = "submitForm('messageBilling','billing?method=printReceiptReport&textfield="
					+ receiptNo + "')";
			map.put("printUrl", printUrl);
			message = "Deposit Information Saved Successfully.Do you want to print receipt?";
		} else {
			message = "Some Problem Occured.";
		}
		map.put("message", message);
		String jsp = MESSAGE_FOR_BILLING_JSP + ".jsp";
		map.put("contentJsp", jsp);
		map.put("billtype", "receipt");
		map.put("billNo", receiptNo);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView calculateRoomChargeForPayWard(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		boolean saved = false;
		int hospitalId = 0;

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
		if (request.getParameter(HIN_ID) != null
				&& !request.getParameter(HIN_ID).equals("")) {
			parameterMap.put(HIN_ID,
					Integer.parseInt(request.getParameter(HIN_ID)));
		}

		if (request.getParameter(INPATIENT_ID) != null
				&& !request.getParameter(INPATIENT_ID).equals("")) {
			parameterMap.put(INPATIENT_ID,
					Integer.parseInt(request.getParameter(INPATIENT_ID)));
		}

		if (request.getParameter(RequestConstants.CHARGE_ID) != null
				&& !request.getParameter(RequestConstants.CHARGE_ID).equals("")) {
			parameterMap
					.put(RequestConstants.CHARGE_ID, Integer.parseInt(request
							.getParameter(RequestConstants.CHARGE_ID)));
		}
		System.out.println("chargeId===="+request.getParameter(RequestConstants.CHARGE_ID));
		if (request.getParameter("payward") != null
				&& !request.getParameter("payward").equals("")) {
			parameterMap.put("payward",
					Integer.parseInt(request.getParameter("payward")));
		}
		if (request.getParameter("roomtypeId") != null
				&& !request.getParameter("roomtypeId").equals("")) {
			parameterMap.put("roomtypeId",
					Integer.parseInt(request.getParameter("roomtypeId")));
		}
		System.out.println("roomType===="+Integer.parseInt(request.getParameter("roomtypeId")));
		map = opBillingHandlerService
				.getChargeAmountAfterDiscount(parameterMap);
		String jsp = "calculateRoomChargeForPayWard";

		return new ModelAndView(jsp, "map", map);
	}

	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public void printfinalBillSettlementSummary(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int inpatientId = 0;
		int finalBillId = 0;

		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			detailsMap.put("hospitalId", hospitalId);
		}

		if (request.getParameter("inpatientId") != null) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
			detailsMap.put("inpatientId",
					Integer.parseInt(request.getParameter("inpatientId")));
		}

		if (request.getParameter("finalBillId") != null) {
			finalBillId = Integer.parseInt(request.getParameter("finalBillId"));
			detailsMap.put("finalBillId",
					Integer.parseInt(request.getParameter("finalBillId")));
		}

		/*
		 * parameters.put("fromDate",
		 * HMSUtil.convertStringTypeDateToDateType(fromDate));
		 * parameters.put("toDate",
		 * HMSUtil.convertStringTypeDateToDateType(toDate));
		 */

		map = billingHandlerService.getFinalBillDetails(detailsMap);
		BlFinalBillDetails blFinalBillDetails = null;
		if (null != map.get("blFinalBillDetails")) {
			blFinalBillDetails = (BlFinalBillDetails) map
					.get("blFinalBillDetails");
		}

		BlChargeSlipDetail blChargeSlipDetail = null;
		if (null != map.get("blChargeSlipDetail")) {
			blChargeSlipDetail = (BlChargeSlipDetail) map
					.get("blChargeSlipDetail");
		}
		String cancle_charge_ammount = "";
		if (null != blChargeSlipDetail)
			cancle_charge_ammount = blChargeSlipDetail.getAmt()
					.setScale(0, RoundingMode.HALF_UP).toString();

		String gross_amt = "";
		String paid_amt = "";
		String adv_amt = "";
		String net_amt = "";
		String net_amtt = "";
		if (null != blFinalBillDetails) {
			net_amtt = blFinalBillDetails.getGrossAmt()
					.setScale(0, RoundingMode.HALF_UP).toString();
			if (null != blChargeSlipDetail) {
				gross_amt = (blFinalBillDetails.getGrossAmt().add(
						blChargeSlipDetail.getAmt()).setScale(0,
						RoundingMode.HALF_UP)).toString();
			} else {
				gross_amt = blFinalBillDetails.getGrossAmt()
						.setScale(0, RoundingMode.HALF_UP).toString();

			}
			paid_amt = blFinalBillDetails.getPaidAmt()
					.setScale(0, RoundingMode.HALF_UP).toString();
			adv_amt = blFinalBillDetails.getAdvAmt()
					.setScale(0, RoundingMode.HALF_UP).toString();
			net_amt = blFinalBillDetails.getNetAmt()
					.setScale(0, RoundingMode.HALF_UP).toString();
		}
		System.out.println("cancel " + cancle_charge_ammount);
		System.out.println("net_amtt " + net_amtt);
		System.out.println("gross_amt " + gross_amt);
		System.out.println("adv_amt " + adv_amt);
		System.out.println("net_amt " + net_amt);
		System.out.println("net_amt " + net_amt);
		System.out.println("inpatientId=== " + inpatientId);
		System.out.println("finalBillId=== " + finalBillId);
		// jasper = "finalBillSettlementSummary";
		parameters.put("net_amtt", net_amtt);
		parameters.put("cancel", cancle_charge_ammount);
		parameters.put("gross_amt", gross_amt);
		parameters.put("paid_amt", paid_amt);
		parameters.put("adv_amt", adv_amt);
		parameters.put("net_amt", net_amt);
		parameters.put("inpatientId", inpatientId);
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));
		parameters.put("HOSPITAL_ID", hospitalId);
		detailsMap = billingHandlerService.getConnectionForReport();
		// parameters.put("toRefundDate",
		// HMSUtil.convertStringTypeDateToDateType(toDate));

		HMSUtil.generateReport("finalBillSettlementSummary", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

	}

	public ModelAndView showConsolidateReportForWaiveOffPayLaterJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		map = billingHandlerService
				.showConsolidateReportForWaiveOffPayLaterJsp(hospitalId);
		String jsp = "consolidatedWaivedOffPayLaterReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printConsolidateReportForWaiveOffPayLaterJsp(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		String fromDate = null;
		String toDate = null;
		String reportName = "";

		if (request.getParameter("fromDate") != null) {
			fromDate = request.getParameter("fromDate");
		}
		if (request.getParameter("toDate") != null) {
			toDate = request.getParameter("toDate");

		}
		String type = "";
		if (request.getParameter("cawr") != null) {
			type = request.getParameter("cawr");

		}
		int authId = 0;
		if (request.getParameter("authId") != null) {
			authId = Integer.parseInt(request.getParameter("authId"));

		}
		if (authId != 0 && type.equals("PL")) {
			parameters.put("fromDate",
					HMSUtil.convertStringTypeDateToDateType(fromDate));
			parameters.put("toDate",
					HMSUtil.convertStringTypeDateToDateType(toDate));
			parameters.put("authId", authId);

			int hospitalId = 0;
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}

			// billingHandlerService.executeProcedureForReport(parameters);

			parameters.put("HOSPITAL_ID", hospitalId);
			detailsMap = billingHandlerService.getConnectionForReport();
			// parameters.put("toRefundDate",
			// HMSUtil.convertStringTypeDateToDateType(toDate));

			HMSUtil.generateReport(
					"consolidated_authoriser_Wise_Pay_LaterAuthorizer",
					parameters, (Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else if (authId == 0 && type.equals("PL")) {
			parameters.put("fromDate",
					HMSUtil.convertStringTypeDateToDateType(fromDate));
			parameters.put("toDate",
					HMSUtil.convertStringTypeDateToDateType(toDate));
			parameters.put("authId", authId);

			int hospitalId = 0;
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}

			// billingHandlerService.executeProcedureForReport(parameters);

			parameters.put("HOSPITAL_ID", hospitalId);
			detailsMap = billingHandlerService.getConnectionForReport();
			// parameters.put("toRefundDate",
			// HMSUtil.convertStringTypeDateToDateType(toDate));

			HMSUtil.generateReport("consolidated_authoriser_Wise_Pay_Later",
					parameters, (Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else if (authId != 0 && type.equals("W")) {
			parameters.put("fromDate",
					HMSUtil.convertStringTypeDateToDateType(fromDate));
			parameters.put("toDate",
					HMSUtil.convertStringTypeDateToDateType(toDate));
			parameters.put("authId", authId);

			int hospitalId = 0;
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}

			// billingHandlerService.executeProcedureForReport(parameters);

			parameters.put("HOSPITAL_ID", hospitalId);
			detailsMap = billingHandlerService.getConnectionForReport();
			// parameters.put("toRefundDate",
			// HMSUtil.convertStringTypeDateToDateType(toDate));

			HMSUtil.generateReport("consolidated_authoriser_Wise_WaivedOfAuth",
					parameters, (Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else if (authId == 0 && type.equals("W")) {
			parameters.put("fromDate",
					HMSUtil.convertStringTypeDateToDateType(fromDate));
			parameters.put("toDate",
					HMSUtil.convertStringTypeDateToDateType(toDate));
			parameters.put("authId", authId);

			int hospitalId = 0;
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}

			// billingHandlerService.executeProcedureForReport(parameters);

			parameters.put("HOSPITAL_ID", hospitalId);
			detailsMap = billingHandlerService.getConnectionForReport();
			// parameters.put("toRefundDate",
			// HMSUtil.convertStringTypeDateToDateType(toDate));

			HMSUtil.generateReport("consolidated_authoriser_Wise_WaivedOf",
					parameters, (Connection) detailsMap.get("conn"), response,
					getServletContext());
		}

		return null;
	}

	public ModelAndView showOtherItemForFinalBill(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int itemId = 0;
		int inpatientId = 0;
		String adNo = "";
		int hinId = 0;

		/*
		 * if (request.getParameter("itemId") != null) { itemId =
		 * Integer.parseInt(request.getParameter("itemId")); }
		 */
		if (request.getParameter("inpatientId") != null) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		}
		mapForDs.put("inpatientId", inpatientId);
		map = billingHandlerService.getItemBatchDetailsFinal(mapForDs, box);
		String jsp = "";
		jsp = "bl_OthrItemForFinalBill";
		map.put("inpatientId", inpatientId);
		return new ModelAndView(jsp, "map", map);
	}

	/** Method for get the item expiry date based on item id and batch number 
	 * @param request
	 * @param response
	 * @return
	 * 
	 * Added by dhananjay 18-10-2016
	 */
	public ModelAndView populateExpiryDateByBatchNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int itemId = 0;
		String batchNo ="";
		int inc = 0;
		int hinId = 0;
		int hospitalId = 0;
		int depId=0;
		
		if(null !=request.getParameter("itemId")){
			itemId=Integer.parseInt(request.getParameter("itemId"));
		}
		if(null !=request.getParameter("batchNo")){
			batchNo=request.getParameter("batchNo");
			

		}
		if(null !=request.getParameter("inc")){
			inc=Integer.parseInt(request.getParameter("inc"));
		}
		if(null !=request.getParameter("depId")){
			depId=Integer.parseInt(request.getParameter("depId"));
		}
		
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		mapForDs.put("itemId", itemId);
		mapForDs.put("hospitalId", hospitalId);
		mapForDs.put("batchNo", batchNo);
		mapForDs.put("depId", depId);
		List<StoreItemBatchStock> masStoreBrandItemList = null;
		masStoreBrandItemList=new ArrayList<StoreItemBatchStock>();
		map = billingHandlerService.populateExpiryDateByBatchNo(mapForDs);
		
		if(null !=map.get("masStoreBrandItemList")){
			masStoreBrandItemList=(List<StoreItemBatchStock>)map.get("masStoreBrandItemList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<item>");
			
			for (StoreItemBatchStock batchStock : masStoreBrandItemList) {
				
				sb.append("<stock>" +batchStock.getClosingStock()+ "</stock>");
				sb.append("<expiryDate>" +HMSUtil.convertDateToStringWithoutTime(batchStock.getExpiryDate())  + "</expiryDate>");
				
				
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
		return null;
	}

	
	/**
	 * ------------------------Setters & Getters-----------------------
	 */

	public BillingHandlerService getBillingHandlerService() {
		return billingHandlerService;
	}

	public void setBillingHandlerService(
			BillingHandlerService billingHandlerService) {
		this.billingHandlerService = billingHandlerService;
	}

	public OpBillingHandlerService getOpBillingHandlerService() {
		return opBillingHandlerService;
	}

	public void setOpBillingHandlerService(
			OpBillingHandlerService opBillingHandlerService) {
		this.opBillingHandlerService = opBillingHandlerService;
	}

	public void setHospitalDetailsMasterHandlerService(
			HospitalDetailsMasterHandlerService hospitalDetailsMasterHandlerService) {
		this.hospitalDetailsMasterHandlerService = hospitalDetailsMasterHandlerService;
	}

	public AccountHandlerService getAccountHandlerService() {
		return accountHandlerService;
	}

	public void setAccountHandlerService(
			AccountHandlerService accountHandlerService) {
		this.accountHandlerService = accountHandlerService;
	}

	public LabHandlerService getLabHandlerService() {
		return labHandlerService;
	}

	public void setLabHandlerService(LabHandlerService labHandlerService) {
		this.labHandlerService = labHandlerService;
	}

	public IPDHandlerService getIpdHandlerService() {
		return ipdHandlerService;
	}

	public void setIpdHandlerService(IPDHandlerService ipdHandlerService) {
		this.ipdHandlerService = ipdHandlerService;
	}

	public ModelAndView getPharmacyDispencingListRefresh(HttpServletRequest request,
			HttpServletResponse response) {
	//System.out.println("getPharmacyDispencingListRefresh calling");
		HttpSession session;
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int deptId = 0;
		int hospitalId = 0;
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer
					.parseInt(session.getAttribute("deptId").toString());
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt(session.getAttribute(HOSPITAL_ID)
					.toString());
		}
		//System.out.println("Refresh controller hospitalId "+hospitalId+" deptId "+deptId);
		box.put("deptId", deptId);
		box.put(HOSPITAL_ID, hospitalId);
		map = billingHandlerService.getPharmacySalesDetails(box);
		jsp = "pharmacySalesViewSearch_div";
		title = "Pending Dispencing List";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}
	
	// added by amit das on 17-06-2017
		public ModelAndView showDetailedOPBillingReportJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasScheme> schemeList=billingHandlerService.getAllSchemeList();
			String jsp = "";
			String title = "";
			jsp += DETAILED_OP_BILLING_REPORT_JSP;
			jsp += ".jsp";
			title = "Detailed Billing Report";
			map.put("schemeList", schemeList);
			map.put("contentJsp", jsp);
			map.put("title", title);

			return new ModelAndView("index", "map", map);
		}
		
		
		// added by amit das on 17-06-2017
		public ModelAndView printDetailedOPBillingReport(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			List<MasHospital> hospitalList = null;
			String reportName = "";
			String fromDate = null;
			String toDate = null;
			String hospitalName = null;
			String patientType = null;
			String schemeStr = request.getParameter("scheme");
			int schemeId = 0;
			int hospitalId = (Integer)request.getSession().getAttribute("hospitalId");
			
			if(schemeStr!=null && !schemeStr.equals(""))
				schemeId = Integer.parseInt(schemeStr);
			
			patientType = request.getParameter("patientType");
			
			detailsMap.put("hospitalId", hospitalId);
			
			detailsMap = hospitalDetailsMasterHandlerService.getHospitalList(detailsMap);
			
			hospitalList =	(List<MasHospital>)detailsMap.get("masHospitalList");
						
			hospitalName = hospitalList.get(0).getHospitalName();
			
			String fromTime = "";
			String toTime = "";

			if (request.getParameter(FROM_DATE) != null) {
				fromDate = request.getParameter(FROM_DATE);
			}
			if (request.getParameter(TO_DATE) != null) {
				toDate = request.getParameter(TO_DATE);
			}

			if (request.getParameter(FROM_TIME) != null && !request.getParameter(FROM_TIME).trim().equals("")) {
				fromTime = request.getParameter(FROM_TIME);
			}

			if (request.getParameter(TO_TIME) != null && !request.getParameter(TO_TIME).trim().equals("")) {
				toTime = request.getParameter(TO_TIME);
			}

			String pathin = getServletContext().getRealPath("/Reports/");
			parameters.put("SUBREPORT_DIR", pathin+"/");
			
			 
			
			parameters.put("schemeId", schemeId);
			parameters.put("fromTime1", fromTime);
			parameters.put("toTime1", toTime);
			parameters.put("fromDate",
					HMSUtil.convertStringTypeDateToDateType(fromDate));
			parameters.put("toDate",
					HMSUtil.convertStringTypeDateToDateType(toDate));
			parameters.put("hospitalName", hospitalName);
			parameters.put("hospitalId", hospitalId);
			
			if(patientType!=null && patientType.equalsIgnoreCase("OP"))
				reportName = "DetailedBillingReport";
			else if(patientType!=null && patientType.equalsIgnoreCase("IP"))
				reportName = "DetailedBillingReportIP";
			
			detailsMap = billingHandlerService.getConnectionForReport();
			
			String flag="1";
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (flag.equals("1"))
			{
				HMSUtil.generateReport(reportName, parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());

			}

			else if(flag.equals("2")) {
						HMSUtil.generateHTMLReport(reportName, parameters,
								(Connection) detailsMap.get("conn"), response,
								getServletContext());
			}
			
			return null;
		}
		
		public void getKmsclIntegrationXML(HttpServletRequest request,
				HttpServletResponse response) throws IOException {
			System.out.println("getKmsclIntegrationXML calling");
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> mapForDS = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int userId=0; 
			int hospitalId=0;
			String flag = null;
			String displayName = null;
			
			String displayDepartmentTypeName = null;
			int deptId=0;
			if(request.getParameter("displayName")!=null){
				displayName = request.getParameter("displayName");
				mapForDS.put("displayName",displayName);
				
			}
			//System.out.println("displayName controller "+displayName);
			int empId =0;
		    if(session.getAttribute("userId")!=null){
		      empId =(Integer) session.getAttribute("userId");
		      map.put("docId", empId);
		    }
			if(session.getAttribute("deptId")!=null){
				deptId = (Integer) session.getAttribute("deptId");
				mapForDS.put("deptId", deptId);
				}
			String kmsclInstcode=null;
			if(request.getParameter("kmsclInstcode")!=null && !request.getParameter("kmsclInstcode").equals("")){
				kmsclInstcode =request.getParameter("kmsclInstcode");
				mapForDS.put("kmsclInstcode", kmsclInstcode);	
			}
			if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("")){
				hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
				mapForDS.put("hospitalId", hospitalId);	
			}
			if (session.getAttribute("userId") != null) {
				userId = (Integer)session.getAttribute("userId");
				mapForDS.put("userId", userId);	
			}
			
			if(request.getParameter("flag")!=null){
				flag =	request.getParameter("flag");
				mapForDS.put("flag", flag);
			}
			
			Users users = (Users)session.getAttribute("users");
		    if(users!=null){
		    	empId=users.getEmployee().getId();
		    	mapForDS.put("docId", empId);
		    }
		    String filePath="";
		    if(request.getParameter("filePath")!=null){
		    	filePath =	request.getParameter("filePath");
			}	
			/*List<MasStoreItem> mStorList=new ArrayList<MasStoreItem>();
			List<StoreItemBatchStock> storeBatchList=new ArrayList<StoreItemBatchStock>();*/
			List<Object[]> storeBatchList = new ArrayList<Object[]>();
		    map = billingHandlerService.getKmsclIntegrationXMLData(mapForDS);
		    
		    if(map.get("storeBatchList")!=null){
		    	storeBatchList=(List<Object[]>)map.get("storeBatchList");
		    }
		    
		    StringBuffer sb = new StringBuffer();
		    for(Object[] obj:storeBatchList){
							sb.append("<item>\n");
										sb.append("<kmscl_code>" + obj[0]+ "</kmscl_code>\n");
										sb.append("<batch_no>" + obj[2]+ "</batch_no>\n");
										sb.append("<item_id>" + obj[3]+ "</item_id>\n");
										sb.append("<store_stock>" +obj[4]+ "</store_stock>\n");
										sb.append("<sub_stock>" +obj[5]+ "</sub_stock>\n");
						    sb.append("</item>\n");											
		    }
			//System.out.println(sb.toString());	
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			try {
				response.getWriter().write(
						"<?xml version='1.0' encoding='ISO-8859-1'?>");
				response.getWriter().write("\n<items>\n");
				response.getWriter().write(sb.toString());
				response.getWriter().write("</items>");
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Added by Arbind on 16-01-2018
		public ModelAndView showBillingCashRegisterJsp(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();

			String jsp = "billingCashRegister.jsp";
			map.put("contentJsp", jsp);

			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView printBillingCashRegisterReport(HttpServletRequest request, HttpServletResponse response) {
			String userName = "";
			int hospitalId = 0;
			Date fromDate = new Date();
			Date toDate = new Date();
			String uhid = "";
			String name = "";
			String mobileNo = "";
			HttpSession session = request.getSession();
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> requestParameter = new HashMap<String, Object>();
			session = request.getSession();

			if (session.getAttribute("empName") != null) {
				userName = (String) session.getAttribute("empName");
			}
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
			}
			if (request.getParameter(FROM_DATE) != null) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			}
			if (request.getParameter(TO_DATE) != null) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			}
			if (request.getParameter("uhid") != null && !request.getParameter("uhid").equals("")) {
				uhid = request.getParameter("uhid");
			}
			if (request.getParameter("name") != null && !request.getParameter("name").equals("")) {
				name = request.getParameter("name");
			}
			if (request.getParameter("mobileNo") != null && !request.getParameter("mobileNo").equals("")) {
				mobileNo = request.getParameter("mobileNo");
			}
			try {
				detailsMap = billingHandlerService.getConnectionForReport();
				requestParameter.put("userName", userName);
				requestParameter.put("hospitalId", hospitalId);
				requestParameter.put("fromDate", fromDate);
				requestParameter.put("toDate", toDate);
				requestParameter.put("uhid", uhid);
				requestParameter.put("name", name);
				requestParameter.put("mobileNo", mobileNo);
				requestParameter.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));

				HMSUtil.generateReport("BillingCashRegister", requestParameter, (Connection) detailsMap.get("conn"), response,
						getServletContext());

			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public void getKmsclAddedXML(HttpServletRequest request,
				HttpServletResponse response) throws IOException {
			System.out.println("getKmsclIntegrationXML calling");
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> mapForDS = new HashMap<String, Object>();
			int hospitalId=0;
			String kmsclInstcode=null;

			if(request.getParameter("kmsclInstcode")!=null && !request.getParameter("kmsclInstcode").equals("")){
				kmsclInstcode =request.getParameter("kmsclInstcode");
				mapForDS.put("kmsclInstcode", kmsclInstcode);	
			}
			if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("")){
				hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
				mapForDS.put("hospitalId", hospitalId);	
			}
			List<Object[]> storeBatchList = new ArrayList<Object[]>();
		    map = billingHandlerService.getKmsclAddedXMLData(mapForDS);

		    if(map.get("storeBatchList")!=null){
		    	storeBatchList=(List<Object[]>)map.get("storeBatchList");
		    }

		    StringBuffer sb = new StringBuffer();
		    for(Object[] obj:storeBatchList){
							sb.append("<item>\n");
										sb.append("<kmscl_code>" + obj[0]+ "</kmscl_code>\n");
										sb.append("<batch_no>" + obj[2]+ "</batch_no>\n");
										sb.append("<item_id>" + obj[3]+ "</item_id>\n");
										sb.append("<out_tw_no>" +obj[4]+ "</out_tw_no>\n");
						    sb.append("</item>\n");											
		    }
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			try {
				response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
				response.getWriter().write("\n<items>\n");
				response.getWriter().write(sb.toString());
				response.getWriter().write("</items>");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
