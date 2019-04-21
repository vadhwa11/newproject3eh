package jkt.hms.mis.controller;

/**
 * @author Priyanka Garg
 *
 */

import static jkt.hms.util.RequestConstants.*;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.Birthdeathreg;
import jkt.hms.masters.business.DeliveryDetails;
import jkt.hms.masters.business.EmpAfmsfDet;
import jkt.hms.masters.business.ExpiryDetails;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.MisFrw;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.mis.handler.MISHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MISController extends MultiActionController {

	MISHandlerService misHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	HttpSession session = null;
	String jsp = "";
	String title = "";
	String url = "";
	String message = "";
	String currentTime = "";

	// -------------------- ED Returns Form -----------------
	public ModelAndView showEDReturnsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		@SuppressWarnings("unused")
		Date edDate = null;
		Date currentDate = new Date();

		map = misHandlerService.showEDReturnsJsp();

		jsp = EDRETURNS_JSP;
		jsp += ".jsp";
		title = "EDReturnForm";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showEDReturns(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		// session = request.getSession();
		String toDate = null;
		String fromDate = null;
		String category = null;
		String edStatus = null;
		try {
			if (request.getParameter("toDate") != null
					&& !(request.getParameter("toDate").equals(""))) {
				toDate = request.getParameter("toDate");
			}
			if (request.getParameter("fromDate") != null
					&& !(request.getParameter("fromDate").equals(""))) {
				fromDate = (request.getParameter("fromDate"));
			}
			if (request.getParameter("category") != null
					&& !(request.getParameter("category").equals(""))) {
				category = request.getParameter("category");
			}
			/*
			 * if (request.getParameter("edStatus") != null &&
			 * !(request.getParameter("edStatus").equals(""))) { edStatus =
			 * request.getParameter("edStatus"); } else { edStatus="n"; }
			 */
			edStatus = "n";
		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.showEDReturns(toDate, fromDate, category,
				edStatus);
		jsp = EDRETURNS_DETAILS_JSP;
		map.put("title", title);
		map.put("toDate", HMSUtil.convertStringTypeDateToDateType(toDate));
		map.put("fromDate", HMSUtil.convertStringTypeDateToDateType(fromDate));
		map.put("category", category);
		map.put("edStatus", edStatus);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView editEDReturns(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		Date currentDate = new Date();
		int visitId = 0;
		int edDays = 0;
		String dispose = null;

		String edDate = null;
		Date toDate = null;
		Date fromDate = null;
		Date edDate1 = new Date();
		Date edDate2 = new Date();
		Date edDate3 = new Date();
		Date ldDate = new Date();
		String category = null;
		String ed = null;
		String ld = null;
		String diagnosis = "";
		int ldDays = 0;

		Date edDateTemp = new Date();
		if (request.getParameter("visitId") != null
				&& !(request.getParameter("visitId").equals(""))) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}

		if (request.getParameter("edDays") != null
				&& !(request.getParameter("edDays").equals(""))) {
			edDays = Integer.parseInt(request.getParameter("edDays"));
		}
		if (request.getParameter("edDate") != null
				&& !(request.getParameter("edDate").equals(""))) {
			edDateTemp = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter("edDate"));
		}
		if (request.getParameter("edDispose") != null
				&& !(request.getParameter("edDispose").equals(""))) {
			dispose = request.getParameter("edDispose");
		}
		if (request.getParameter("edDate1") != null
				&& !(request.getParameter("edDate1").equals(""))) {
			edDate1 = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter("edDate1"));
		}
		if (request.getParameter("edDate2") != null
				&& !(request.getParameter("edDate2").equals(""))) {
			edDate2 = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter("edDate2"));
		}
		if (request.getParameter("edDate3") != null
				&& !(request.getParameter("edDate3").equals(""))) {
			edDate3 = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter("edDate3"));
		}

		if (request.getParameter(DIAGNOSIS_ID) != null
				&& !(request.getParameter(DIAGNOSIS_ID).equals(""))) {
			diagnosis = request.getParameter(DIAGNOSIS_ID);
		}
		/*
		 * if (request.getParameter("ldDate") != null &&
		 * !(request.getParameter("ldDate").equals(""))) { ldDate =
		 * HMSUtil.convertStringTypeDateToDateType
		 * (request.getParameter("ldDate")); } if
		 * (request.getParameter("ldDays") != null &&
		 * !(request.getParameter("ldDays").equals(""))) { ldDays =
		 * Integer.parseInt(request.getParameter("ldDays")); }
		 */
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(ED) != null
				&& !(request.getParameter(ED).equals(""))) {
			ed = request.getParameter(ED);
		}
		/*
		 * if (request.getParameter(LD) != null &&
		 * !(request.getParameter(LD).equals(""))) { ld =
		 * request.getParameter(LD); }
		 */

		generalMap.put("id", visitId);
		generalMap.put("edDate", edDateTemp);
		generalMap.put("edDays", new Integer(edDays));
		generalMap.put("dispose", dispose);
		generalMap.put("edStatus", "y");
		generalMap.put("edDate1", edDate1);
		generalMap.put("edDate2", edDate2);
		generalMap.put("edDate3", edDate3);
		generalMap.put("diagnosis", diagnosis);

		boolean dataUpdated = false;

		dataUpdated = misHandlerService.editEDReturnsToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully";

		} else {
			message = "Data Cant be updated";

		}
		map.put("message", message);
		url = "/hms/hms/mis?method=showEDReturnsJsp";

		try {
			map = misHandlerService.showEDReturnsJsp();

		} catch (Exception e) {

		}

		jsp = EDRETURNS_JSP;

		title = "update ED Returns";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);

		return new ModelAndView("index", "map", map);

	}

	// ----------------------------- ED Reports Form
	// --------------------------------
	public ModelAndView showEDreportsjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = misHandlerService.showEDreportsjsp();
		jsp = EDREPORT_JSP;
		jsp += ".jsp";
		title = "edReport";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showEDreports(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Date toDate = null;
		Date fromDate = null;
		String category = "";
		int service_type_id = 0;
		String dispose = "";
		String rankCategory = "";
		List<MasRankCategory> masRankCategoryList = new ArrayList<MasRankCategory>();
		map = misHandlerService.showEDreports(map);
		masRankCategoryList = (List<MasRankCategory>) map
				.get("masRankCategoryList");
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			try {
				String[] rankCategoryIdArray = null;

				if (request.getParameterValues(CATEGORY_ID) != null
						&& !request.getParameterValues(CATEGORY_ID).equals("0")) {
					rankCategoryIdArray = (String[]) (request
							.getParameterValues(CATEGORY_ID));
					for (int i = 0; i < rankCategoryIdArray.length; i++) {
						rankCategory = rankCategory + rankCategoryIdArray[i];
						rankCategory = rankCategory + ",";
						for (MasRankCategory masRankCategory : masRankCategoryList) {
							if (("" + masRankCategory.getId())
									.equals(rankCategoryIdArray[i])) {
								category = category
										+ masRankCategory.getRankCategoryName()
										+ ",";
							}

						}
					}
					rankCategory = rankCategory.substring(0,
							rankCategory.length() - 1);
					category = category.substring(0, category.length() - 1);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			if (request.getParameter(DISPOSAL) != null
					&& !(request.getParameter(DISPOSAL).equals(""))) {
				dispose = ("" + request.getParameter(DISPOSAL));
			}
			if (request.getParameter(SERVICE_TYPE_ID) != null
					&& !(request.getParameter(SERVICE_TYPE_ID).equals(""))) {
				service_type_id = Integer.parseInt(""
						+ request.getParameter(SERVICE_TYPE_ID));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		String criteria = "";
		if (rankCategory.equals("") && dispose.equals("0")
				&& service_type_id == 0) {
			criteria = "";
			category = "All";
		} else {
			if (!rankCategory.equals("")) {
				criteria = " and mas_rank_category.rank_category_id in("
						+ rankCategory + ")";
			}
			if (!dispose.equals("0")) {
				criteria = criteria + " and visit.ed_dispose='" + dispose + "'";
			}
			if (service_type_id != 0) {
				criteria = criteria + " and patient.service_type_id="
						+ service_type_id;
			}

		}

		map.put("criteria", criteria);
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("rankCategory", category);
		HMSUtil.generateReport("EDReturns", map, (Connection) map.get("conn"),
				response, getServletContext());
		return null;
	}

	// ----------------------------- Patient Movement Order Reports Form
	// --------------------------------
	public ModelAndView showPatientMovementOrderjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = misHandlerService.showPatientMovementOrderjsp();
		jsp = PATIENTMOVEMENTORDER_JSP;
		jsp += ".jsp";
		title = "patientMovementOrder";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printFRW(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String frwSlno = null;
		String fromTo = null;
		int disposal = 0;
		String disposalName = "";
		int hinId = 0;

		try {
			if (request.getParameter(DISPOSAL_ID) != null
					&& !(request.getParameter(DISPOSAL_ID).equals(""))) {
				disposal = Integer.parseInt(request.getParameter(DISPOSAL_ID));
			}

			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals(""))) {
				hinId = Integer.parseInt("" + request.getParameter(HIN_ID));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();

		if (disposal != 0) {
			disposalName = " and mas_disposal.disposal_id=" + disposal;
			map.put("disposalName", disposal);
		} else {
			disposalName = "";
		}
		map.put("hinId", hinId);
		map.put("disposalName", disposalName);
		HMSUtil.generateReport("RequisitionForIssueOfForward", map,
				(Connection) map.get("conn"), response, getServletContext());
		return null;
	}

	// ------------------- Afmsf-1 Def ---------------------------

	public ModelAndView showAfmsfDefjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = misHandlerService.showAfmsfDefjsp();
		jsp = AFMSFDEF_JSP;
		jsp += ".jsp";
		title = "Deficient Afmsf-1";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAfmsfDef(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = null;

		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		map.put("serviceNo", serviceNo);
		map = misHandlerService.showAfmsfDef(map);
		jsp = AFMSFDEF_JSP;
		jsp += ".jsp";
		title = "Deficient Afmsf-1";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editAfmsfDef(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String currentDate = null;
		String currentDatetoStr = null;
		int hospitalId = 0;
		int rankId = 0;
		int empId = 0;
		int tradeId = 0;
		int medicalcategory = 0;
		String letterNo = "";
		String disletterNo = "";
		String remarks = "";
		String disRemarks = "";
		String suffix = "";
		String serviceNo = null;
		String changedBy = "";
		int presentUnit = 0;
		String employeeName = null;
		Date receiptDate = null;
		Date dispatchDate = null;
		Date nextreviewDate = null;
		String status = "";
		String datePostingIn = null;
		String datePostingOut = null;
		String diagnosis = null;
		String lastName = null;
		String unitName = null;
		String unitAddress = null;
		String localUnit = null;

		hospitalId = (Integer) session.getAttribute("hospitalId");
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter(EMPLOYEE_ID) != null
				&& !(request.getParameter(EMPLOYEE_ID).equals(""))) {
			empId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(RECEIPTDATE) != null
				&& !(request.getParameter(RECEIPTDATE).equals(""))) {
			receiptDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(RECEIPTDATE));
		}

		if (request.getParameter(DISPATCHDATE) != null
				&& !(request.getParameter(DISPATCHDATE).equals(""))) {
			dispatchDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DISPATCHDATE));
		}
		if (request.getParameter(NEXT_REVIEW_DATE) != null
				&& !(request.getParameter(NEXT_REVIEW_DATE).equals(""))) {
			nextreviewDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(NEXT_REVIEW_DATE));
		}

		if (request.getParameter(EMPLOYEE_FIRST_NAME) != null
				&& !(request.getParameter(EMPLOYEE_FIRST_NAME).equals(""))) {
			employeeName = request.getParameter(EMPLOYEE_FIRST_NAME);
		}
		if (request.getParameter(EMPLOYEE_LAST_NAME) != null
				&& !(request.getParameter(EMPLOYEE_LAST_NAME).equals(""))) {
			lastName = request.getParameter(EMPLOYEE_LAST_NAME);
		}

		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals(""))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
		}

		if (request.getParameter(PRESENT_UNIT) != null
				&& !(request.getParameter(PRESENT_UNIT).equals(""))) {
			presentUnit = Integer.parseInt(request.getParameter(PRESENT_UNIT));
		}

		if (request.getParameter(RECEIPT_LETTER_NO) != null
				&& !(request.getParameter(RECEIPT_LETTER_NO).equals(""))) {
			letterNo = request.getParameter(RECEIPT_LETTER_NO);
		}
		if (request.getParameter(DISPATCH_LETTER_NO) != null
				&& !(request.getParameter(DISPATCH_LETTER_NO).equals(""))) {
			disletterNo = request.getParameter(DISPATCH_LETTER_NO);
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = request.getParameter(CHANGED_DATE);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("status") != null
				&& !(request.getParameter("status").equals(""))) {
			status = request.getParameter("status");
		}

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
		}

		if (request.getParameter(DIS_REMARKS) != null) {
			disRemarks = request.getParameter(DIS_REMARKS);
		}

		if (request.getParameter(TRADE) != null
				&& !(request.getParameter(TRADE).equals(""))) {
			tradeId = Integer.parseInt(request.getParameter(TRADE));
		}

		if (request.getParameter(MEDICAL_CATEGORY) != null
				&& !(request.getParameter(MEDICAL_CATEGORY).equals(""))) {
			medicalcategory = Integer.parseInt(request
					.getParameter(MEDICAL_CATEGORY));
		}

		if (request.getParameter(POST_IN_DATE) != null
				&& !(request.getParameter(POST_IN_DATE).equals(""))) {
			datePostingIn = request.getParameter(POST_IN_DATE);
		}

		if (request.getParameter(POST_OUT_DATE) != null
				&& !(request.getParameter(POST_OUT_DATE).equals(""))) {
			datePostingOut = request.getParameter(POST_OUT_DATE);
		}

		if (request.getParameter(DIAGNOSIS) != null) {
			diagnosis = request.getParameter(DIAGNOSIS);
		}

		/*
		 * if (request.getParameter(RADIO_FOR_TABLE) != null &&
		 * !(request.getParameter(RADIO_FOR_TABLE).equals(""))) { status =
		 * request.getParameter(RADIO_FOR_TABLE); }
		 */
		@SuppressWarnings("unused")
		String postedFromId = null;
		@SuppressWarnings("unused")
		String postedToId = null;
		String auth = "";
		String authpostingOut = "";
		int empAfmsId = 0;
		String docStatus = "";

		if (request.getParameter(POSTED_FROM) != null
				&& !(request.getParameter(POSTED_FROM).equals(""))) {
			postedFromId = (request.getParameter(POSTED_FROM));
		}
		if (request.getParameter(POSTED_TO) != null
				&& !(request.getParameter(POSTED_TO).equals(""))) {
			postedToId = (request.getParameter(POSTED_TO));
		}
		if (request.getParameter(AUTHORITY) != null
				&& !(request.getParameter(AUTHORITY).equals(""))) {
			auth = request.getParameter(AUTHORITY);
		}

		if (request.getParameter(AUTHORITY_POSTED_OUT) != null
				&& !(request.getParameter(AUTHORITY_POSTED_OUT).equals(""))) {
			authpostingOut = request.getParameter(AUTHORITY_POSTED_OUT);
		}

		if (request.getParameter("docStatus") != null
				&& !(request.getParameter("docStatus").equals(""))) {
			docStatus = request.getParameter("docStatus");
		}
		if (request.getParameter(EMP_AFMS_ID) != null
				&& !(request.getParameter(EMP_AFMS_ID).equals(""))) {
			empAfmsId = Integer.parseInt(request.getParameter(EMP_AFMS_ID));
		}
		if (request.getParameter("suffix") != null) {
			suffix = request.getParameter("suffix");
		}

		if (request.getParameter(UNIT_NAME) != null) {
			unitName = request.getParameter(UNIT_NAME);
		}

		if (request.getParameter(UNIT_ADDRESS) != null) {
			unitAddress = request.getParameter(UNIT_ADDRESS);
		}

		if (request.getParameter(LOCAL_UNIT) != null) {
			localUnit = request.getParameter(LOCAL_UNIT);
		}

		generalMap.put("empAfmsId", empAfmsId);
		generalMap.put("status", status);
		generalMap.put("employeeName", employeeName);
		generalMap.put("employeeId", empId);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("serviceNo", serviceNo);
		generalMap.put("receiptdate", receiptDate);
		generalMap.put("rankId", rankId);
		generalMap.put("letterNo", letterNo);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("auth", auth);
		generalMap.put("postedToId", postedToId);
		generalMap.put("postedFromId", postedFromId);
		generalMap.put("tradeId", tradeId);
		generalMap.put("medicalcategory", medicalcategory);
		generalMap.put("remarks", remarks);
		generalMap.put("docStatus", docStatus);
		generalMap.put("disRemarks", disRemarks);
		generalMap.put("disletterNo", disletterNo);
		generalMap.put("dispatchdate", dispatchDate);
		generalMap.put("presentUnit", presentUnit);
		generalMap.put("datePostingIn", datePostingIn);
		generalMap.put("datePostingOut", datePostingOut);
		generalMap.put("authpostingOut", authpostingOut);
		generalMap.put("suffix", suffix);
		generalMap.put("nextreviewDate", nextreviewDate);
		generalMap.put("diagnosis", diagnosis);
		generalMap.put("lastName", lastName);
		generalMap.put("unitName", unitName);
		generalMap.put("unitAddress", unitAddress);
		generalMap.put("localUnit", localUnit);
		boolean dataUpdated = false;
		boolean duplicateRecord = false;

		dataUpdated = misHandlerService.editAfmsfDef(generalMap);

		if (dataUpdated == true) {
			message = "Data Saved Successfully";
		} else {
			message = "Data Updated Successfully";

		}

		/***********************************************************************
		 * when record is updated, it will show the MasEmployee table records
		 * for fetching from MasEmployee the value of receiptStatusRadio is set
		 * to constant 2
		 **********************************************************************/

		url = "/hms/hms/mis?method=showAfmsfDefjsp";
		map = misHandlerService.showAfmsfDef(generalMap);

		if (status != null) {
			if (status.equals("arrival")) {
				jsp = "arrivalEntry";
				title = "update AFMSF-1 ArrivalEntry";
			} else if (status.equals("receipt")) {
				jsp = "receiptEntryJsp";
				title = "update AFMSF-1 ReceiptEntry";
			} else if (status.equals("clearance")) {
				jsp = "clearanceFormJsp";
				title = "update AFMSF-1 ClearanceForm";
			} else if (status.equals("dispatch")) {
				jsp = "dispatchDetailsJsp";
				title = "update AFMSF-1 DispatchDetails";
			}
		}
		title = "update AFMSF-1 Def";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);

		return new ModelAndView("index", "map", map);

	}

	// -------------------------- Afmsf-1 Surplus
	// -------------------------------

	public ModelAndView showAfmsfSurplusjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = misHandlerService.showAfmsfSurplusjsp();
		jsp = AFMSFSURPLUS_JSP;
		jsp += ".jsp";
		title = "Surplus Afmsf-1";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAfmsfSurplus(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = null;

		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		map.put("serviceNo", serviceNo);
		map = misHandlerService.showAfmsfSurplus(map);
		jsp = AFMSFSURPLUS_JSP;
		jsp += ".jsp";
		title = "Surplus Afmsf-1";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editAfmsfSurplus(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String currentDate = null;
		String currentDatetoStr = null;
		int hospitalId = 0;
		int rankId = 0;
		int empId = 0;
		String letterNo = "0";

		String serviceNo = null;
		String changedBy = "";
		int LastUnit = 0;
		String employeeName = null;
		Date receiptDate = new Date();
		String status = "";
		hospitalId = (Integer) session.getAttribute("hospitalId");
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter(EMPLOYEE_ID) != null
				&& !(request.getParameter(EMPLOYEE_ID).equals(""))) {
			empId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(RECEIPT_DATE) != null
				&& !(request.getParameter(RECEIPT_DATE).equals(""))) {
			receiptDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(RECEIPT_DATE));
		}
		if (request.getParameter(EMPLOYEE_FIRST_NAME) != null
				&& !(request.getParameter(EMPLOYEE_FIRST_NAME).equals(""))) {
			employeeName = request.getParameter(EMPLOYEE_FIRST_NAME);
		}
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals(""))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
		}

		if (request.getParameter(LAST_UNIT) != null
				&& !(request.getParameter(LAST_UNIT).equals(""))) {
			LastUnit = Integer.parseInt(request.getParameter(LAST_UNIT));
		}

		if (request.getParameter(LETTER_NO) != null
				&& !(request.getParameter(LETTER_NO).equals(""))) {
			letterNo = request.getParameter(LETTER_NO);
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = request.getParameter(CHANGED_DATE);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(RADIO_FOR_TABLE) != null
				&& !(request.getParameter(RADIO_FOR_TABLE).equals(""))) {
			status = request.getParameter(RADIO_FOR_TABLE);
		}
		@SuppressWarnings("unused")
		int postedFromId = 0;
		@SuppressWarnings("unused")
		int postedToId = 0;
		String auth = "";
		String medicalCat = "";
		int empAfmsId = 0;
		int tradeId = 0;
		String description = "";
		if (request.getParameter(TRADE_ID) != null
				&& !(request.getParameter(TRADE_ID).equals(""))) {
			tradeId = Integer.parseInt(request.getParameter(TRADE_ID));
		}
		if (request.getParameter(POSTED_FROM) != null
				&& !(request.getParameter(POSTED_FROM).equals(""))) {
			postedFromId = Integer.parseInt(request.getParameter(POSTED_FROM));
		}
		if (request.getParameter(POSTED_TO) != null
				&& !(request.getParameter(POSTED_TO).equals(""))) {
			postedToId = Integer.parseInt(request.getParameter(POSTED_TO));
		}
		if (request.getParameter(DESCRIPTION) != null
				&& !(request.getParameter(DESCRIPTION).equals(""))) {
			description = request.getParameter(DESCRIPTION);
		}
		if (request.getParameter(MEDICAL_CATEGORY) != null
				&& !(request.getParameter(MEDICAL_CATEGORY).equals(""))) {
			medicalCat = request.getParameter(MEDICAL_CATEGORY);
		}
		if (request.getParameter(EMP_AFMS_ID) != null
				&& !(request.getParameter(EMP_AFMS_ID).equals(""))) {
			empAfmsId = Integer.parseInt(request.getParameter(EMP_AFMS_ID));
		}
		generalMap.put("empAfmsId", empAfmsId);
		generalMap.put("description", description);
		generalMap.put("status", status);
		generalMap.put("tradeId", tradeId);
		generalMap.put("employeeName", employeeName);
		generalMap.put("employeeId", empId);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("serviceNo", serviceNo);
		generalMap.put("receiptDate", receiptDate);
		generalMap.put("rankId", rankId);
		generalMap.put("LastUnit", LastUnit);
		generalMap.put("letterNo", letterNo);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("medicalCat", medicalCat);
		generalMap.put("postedToId", postedToId);
		generalMap.put("postedFromId", postedFromId);

		boolean dataUpdated = false;
		boolean duplicateRecord = false;
		dataUpdated = misHandlerService.editAfmsfSurplus(generalMap);
		if (dataUpdated == true) {
			message = "Data Saved Successfully";
		} else {
			message = "Data Updated Successfully";

		}

		/***********************************************************************
		 * when record is updated, it will show the MasEmployee table records
		 * for fetching from MasEmployee the value of receiptStatusRadio is set
		 * to constant 2
		 **********************************************************************/

		url = "/hms/hms/mis?method=showAfmsfDefjsp";
		map = misHandlerService.showAfmsfDef(generalMap);

		jsp = AFMSFSURPLUS_JSP;
		title = "update AFMSF-1 Def";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);

		return new ModelAndView("index", "map", map);

	}

	/**
	 * --------------------- AfmsfAnnualMedicalExamination
	 * -------------------------*
	 */
	public ModelAndView showAfmsfAnnualMedicalExaminationjsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		// map = misHandlerService.showAfmsfAnnualMedicalExaminationjsp();
		jsp = AFMSFANNUALMEDICALEXAMINATION_JSP;
		jsp += ".jsp";
		title = "Annual Medical Examination Afmsf-1";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAfmsfAnnualMedicalExamination(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = null;
		session = request.getSession();
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
		}

		session.setAttribute("serviceNo", serviceNo);

		map = misHandlerService.showAfmsfAnnualMedicalExamination(serviceNo);
		jsp = AFMSFANNUALMEDICALEXAMINATION_JSP;
		jsp += ".jsp";
		title = "Annual Medical Examination Afmsf-1";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editAfmsfAnnualMedicalExamination(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		Date ameDate = null;
		Date nextReviewDate = null;
		int empAfmsfDetId = 0;
		int ameId = 0;
		if (request.getParameter(AME_ID) != null
				&& !(request.getParameter(AME_ID).equals(""))) {
			ameId = Integer.parseInt(request.getParameter(AME_ID));
		}
		if (request.getParameter(EMP_AFMS_ID) != null
				&& !(request.getParameter(EMP_AFMS_ID).equals(""))) {
			empAfmsfDetId = Integer.parseInt(request.getParameter(EMP_AFMS_ID));
		}
		if (request.getParameter(AME_DATE) != null
				&& !(request.getParameter(AME_DATE).equals(""))) {
			ameDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(AME_DATE));
			generalMap.put("ameDate",
					HMSUtil.convertDateToStringWithoutTime(ameDate));
		}
		if (request.getParameter(NEXT_REVIEW_DATE) != null
				&& !(request.getParameter(NEXT_REVIEW_DATE).equals(""))) {
			nextReviewDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(NEXT_REVIEW_DATE));
			generalMap.put("nextReviewDate",
					HMSUtil.convertDateToStringWithoutTime(nextReviewDate));
		}
		String currentDate = null;
		String currentTime = "";
		String changedBy = "";
		int categoryId = 0;
		String period = "";
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = request.getParameter(CHANGED_DATE);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter(CATEGORY_ID) != null
				&& !(request.getParameter(CATEGORY_ID).equals(""))) {
			categoryId = Integer.parseInt(request.getParameter(CATEGORY_ID));
		}
		if (request.getParameter(PERIOD) != null
				&& !(request.getParameter(PERIOD).equals(""))) {
			period = request.getParameter(PERIOD);
		}

		generalMap.put("empAfmsfDetId", empAfmsfDetId);
		generalMap.put("categoryId", categoryId);
		generalMap.put("period", period);
		generalMap.put("ameId", ameId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		map = misHandlerService.editAfmsfAnnualMedicalExamination(generalMap);
		/***********************************************************************
		 * when record is updated, it will show the MasEmployee table records
		 * for fetching from MasEmployee the value of surplusStatus is set to
		 * constant 2
		 **********************************************************************/

		url = "/hms/hms/mis?method=showAfmsfAnnualMedicalexaminationjsp";
		// map = misHandlerService.showAfmsfAnnualMedicalExamination(serviceNo);

		jsp = AFMSFANNUALMEDICALEXAMINATION_JSP;

		title = "Annual Medical Examination Afmsf-1";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);

		return new ModelAndView("index", "map", map);

	}

	// --------------------- Fatal Case Document -------------------------

	public ModelAndView showFatalCasejsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = null;
		int inpatientId = 0;
		session = request.getSession();
		if (request.getParameter(AD_NO) != null
				&& !(request.getParameter(AD_NO).equals(""))) {
			inpatientId = Integer.parseInt(request.getParameter(AD_NO));
		}
		session.setAttribute("hinNo", hinNo);

		map = misHandlerService.showFatalCasejsp(inpatientId);
		jsp = FATALCASE_JSP;
		jsp += ".jsp";
		title = "Fatal Case Document";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showFatalCase(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int inpatientid = 0;

		session = request.getSession();
		if (request.getParameter(AD_NO) != null
				&& !(request.getParameter(AD_NO).equals(""))) {
			inpatientid = Integer.parseInt(request.getParameter(AD_NO));
		}
		map = misHandlerService.showFatalCasejsp(inpatientid);
		jsp = FATALCASE_DETAILS_JSP;
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView editFatalCase(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String currentDate = null;
		String currentDatetoStr = null;
		int hospitalId = 0;
		int hinId = 0;
		int inpatientId = 0;
		int misFatalId = 0;
		String changedBy = "";
		String adNo = null;
		String postmortem = null;

		Date dateOfDeath = null;
		Date dateOfPostmortem = null;
		Date dateOfConcerned = null;
		Date dateOfOpinion = null;
		Date dateOfWardMaster = null;
		Date dateOfMoWard = null;
		Date dateOfHOD = null;
		Date dateOfStats = null;
		Date dateOfCommandant = null;
		Date dateOfPathology = null;
		Date dateOfSA1 = null;
		Date dateOfSA2 = null;
		Date dateOfSA3 = null;
		Date dateOfSA4 = null;
		Date dateOfConcernedCommand = null;

		String deathRemark = null;
		String postmortemRemark = null;
		String postmortemDateRemark = null;
		String concernedDateRemark = null;
		String opinionDateRemark = null;
		String wardMasterDateRemark = null;
		String wardDateRemark = null;
		String hodDateRemark = null;
		String statsDateRemark = null;
		String commandantDateRemark = null;
		String pathologyDateRemark = null;
		String sa1DateRemark = null;
		String sa2DateRemark = null;
		String sa3DateRemark = null;
		String sa4DateRemark = null;
		String concernedCommandDateRemark = null;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

		if (request.getParameter("hinId") != null
				&& !(request.getParameter("hinId").equals(""))) {
			hinId = Integer.parseInt("" + request.getParameter("hinId"));
		}
		if (request.getParameter(DATE_OF_DEATH) != null
				&& !(request.getParameter(DATE_OF_DEATH).equals(""))) {
			dateOfDeath = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_DEATH));
		}
		if (request.getParameter(DEATH_REMARK) != null
				&& !(request.getParameter(DEATH_REMARK).equals(""))) {
			deathRemark = request.getParameter(DEATH_REMARK);
		}
		if (request.getParameter(DATE_OF_POSTMORTEM) != null
				&& !(request.getParameter(DATE_OF_POSTMORTEM).equals(""))) {
			dateOfPostmortem = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_POSTMORTEM));
		}
		if (request.getParameter(POSTMORTEM_DATE_REMARK) != null
				&& !(request.getParameter(POSTMORTEM_DATE_REMARK).equals(""))) {
			postmortemDateRemark = request.getParameter(POSTMORTEM_DATE_REMARK);
		}
		if (request.getParameter(DATE_OF_CONCERNED) != null
				&& !(request.getParameter(DATE_OF_CONCERNED).equals(""))) {
			dateOfConcerned = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_CONCERNED));
		}
		if (request.getParameter(CONCERNED_DATE_REMARK) != null
				&& !(request.getParameter(CONCERNED_DATE_REMARK).equals(""))) {
			concernedDateRemark = request.getParameter(CONCERNED_DATE_REMARK);
		}
		if (request.getParameter(DATE_OF_OPINION) != null
				&& !(request.getParameter(DATE_OF_OPINION).equals(""))) {
			dateOfOpinion = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_OPINION));
		}
		if (request.getParameter(OPINION_DATE_REMARK) != null
				&& !(request.getParameter(OPINION_DATE_REMARK).equals(""))) {
			opinionDateRemark = request.getParameter(OPINION_DATE_REMARK);
		}
		if (request.getParameter(DATE_OF_WARD_MASTER) != null
				&& !(request.getParameter(DATE_OF_WARD_MASTER).equals(""))) {
			dateOfWardMaster = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_WARD_MASTER));
		}
		if (request.getParameter(WARD_MASTER_DATE_REMARK) != null
				&& !(request.getParameter(WARD_MASTER_DATE_REMARK).equals(""))) {
			wardMasterDateRemark = request
					.getParameter(WARD_MASTER_DATE_REMARK);
		}
		if (request.getParameter(DATE_OF_MO_WARD) != null
				&& !(request.getParameter(DATE_OF_MO_WARD).equals(""))) {
			dateOfMoWard = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_MO_WARD));
		}
		if (request.getParameter(WARD_REMARK) != null
				&& !(request.getParameter(WARD_REMARK).equals(""))) {
			wardDateRemark = request.getParameter(WARD_REMARK);
		}
		if (request.getParameter(DATE_OF_HOD) != null
				&& !(request.getParameter(DATE_OF_HOD).equals(""))) {
			dateOfHOD = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_HOD));
		}
		if (request.getParameter(HOD_DATE_REMARK) != null
				&& !(request.getParameter(HOD_DATE_REMARK).equals(""))) {
			hodDateRemark = request.getParameter(HOD_DATE_REMARK);
		}
		if (request.getParameter(DATE_OF_STATS) != null
				&& !(request.getParameter(DATE_OF_STATS).equals(""))) {
			dateOfStats = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_STATS));
		}
		if (request.getParameter(STATS_DATE_REMARK) != null
				&& !(request.getParameter(STATS_DATE_REMARK).equals(""))) {
			statsDateRemark = request.getParameter(STATS_DATE_REMARK);
		}
		if (request.getParameter(DATE_OF_COMMANDANT) != null
				&& !(request.getParameter(DATE_OF_COMMANDANT).equals(""))) {
			dateOfCommandant = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_COMMANDANT));
		}
		if (request.getParameter(COMMANDANT_DATE_REMARK) != null
				&& !(request.getParameter(COMMANDANT_DATE_REMARK).equals(""))) {
			commandantDateRemark = request.getParameter(COMMANDANT_DATE_REMARK);
		}

		if (request.getParameter(DATE_OF_PATHOLOGY) != null
				&& !(request.getParameter(DATE_OF_PATHOLOGY).equals(""))) {
			dateOfPathology = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_PATHOLOGY));
		}
		if (request.getParameter(PATHOLOGY_DATE_REMARK) != null
				&& !(request.getParameter(PATHOLOGY_DATE_REMARK).equals(""))) {
			pathologyDateRemark = request.getParameter(PATHOLOGY_DATE_REMARK);
		}
		if (request.getParameter(DATE_OF_SENIOR_ADVISOR_1) != null
				&& !(request.getParameter(DATE_OF_SENIOR_ADVISOR_1).equals(""))) {
			dateOfSA1 = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_SENIOR_ADVISOR_1));
		}
		if (request.getParameter(SA1_DATE_REMARK) != null
				&& !(request.getParameter(SA1_DATE_REMARK).equals(""))) {
			sa1DateRemark = request.getParameter(SA1_DATE_REMARK);
		}
		if (request.getParameter(DATE_OF_SENIOR_ADVISOR_2) != null
				&& !(request.getParameter(DATE_OF_SENIOR_ADVISOR_2).equals(""))) {
			dateOfSA2 = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_SENIOR_ADVISOR_2));
		}
		if (request.getParameter(SA2_DATE_REMARK) != null
				&& !(request.getParameter(SA2_DATE_REMARK).equals(""))) {
			sa2DateRemark = request.getParameter(SA2_DATE_REMARK);
		}
		if (request.getParameter(DATE_OF_SENIOR_ADVISOR_3) != null
				&& !(request.getParameter(DATE_OF_SENIOR_ADVISOR_3).equals(""))) {
			dateOfSA3 = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_SENIOR_ADVISOR_3));
		}
		if (request.getParameter(SA3_DATE_REMARK) != null
				&& !(request.getParameter(SA3_DATE_REMARK).equals(""))) {
			sa3DateRemark = request.getParameter(SA3_DATE_REMARK);
		}
		if (request.getParameter(DATE_OF_SENIOR_ADVISOR_4) != null
				&& !(request.getParameter(DATE_OF_SENIOR_ADVISOR_4).equals(""))) {
			dateOfSA4 = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_SENIOR_ADVISOR_4));
		}
		if (request.getParameter(SA4_DATE_REMARK) != null
				&& !(request.getParameter(SA4_DATE_REMARK).equals(""))) {
			sa4DateRemark = request.getParameter(SA4_DATE_REMARK);
		}

		if (request.getParameter(DATE_OF_CONCERNED_COMMAND) != null
				&& !(request.getParameter(DATE_OF_CONCERNED_COMMAND).equals(""))) {
			dateOfConcernedCommand = HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter(DATE_OF_CONCERNED_COMMAND));
		}
		if (request.getParameter(CONCERNED_COMMAND_DATE_REMARK) != null
				&& !(request.getParameter(CONCERNED_COMMAND_DATE_REMARK)
						.equals(""))) {
			concernedCommandDateRemark = request
					.getParameter(CONCERNED_COMMAND_DATE_REMARK);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = request.getParameter(CHANGED_DATE);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		if (request.getParameter(POSTMORTEM) != null
				&& !(request.getParameter(POSTMORTEM).equals(""))) {
			postmortem = request.getParameter(POSTMORTEM);
		}
		if (request.getParameter(POSTMORTEM_REMARK) != null
				&& !(request.getParameter(POSTMORTEM_REMARK).equals(""))) {
			postmortemRemark = request.getParameter(POSTMORTEM_REMARK);
		}
		if (request.getParameter(AD_NO) != null
				&& !(request.getParameter(AD_NO).equals(""))) {
			inpatientId = Integer.parseInt(request.getParameter(AD_NO));
		}
		if (request.getParameter(MIS_FATAL_ID) != null
				&& !(request.getParameter(MIS_FATAL_ID).equals(""))) {
			misFatalId = Integer.parseInt(request.getParameter(MIS_FATAL_ID));
		}

		generalMap.put("adNo", adNo);
		if (dateOfDeath != null) {
			generalMap.put("dateOfDeath",
					HMSUtil.convertDateToStringWithoutTime(dateOfDeath));
		}
		if (dateOfPostmortem != null) {
			generalMap.put("dateOfPostmortem",
					HMSUtil.convertDateToStringWithoutTime(dateOfPostmortem));
		}
		if (dateOfConcerned != null) {
			generalMap.put("dateOfConcerned",
					HMSUtil.convertDateToStringWithoutTime(dateOfConcerned));
		}
		if (dateOfOpinion != null) {
			generalMap.put("dateOfOpinion",
					HMSUtil.convertDateToStringWithoutTime(dateOfOpinion));
		}
		if (dateOfWardMaster != null) {
			generalMap.put("dateOfWardMaster",
					HMSUtil.convertDateToStringWithoutTime(dateOfWardMaster));
		}
		if (dateOfMoWard != null) {
			generalMap.put("dateOfMoWard",
					HMSUtil.convertDateToStringWithoutTime(dateOfMoWard));
		}
		if (dateOfHOD != null) {
			generalMap.put("dateOfHOD",
					HMSUtil.convertDateToStringWithoutTime(dateOfHOD));
		}
		if (dateOfStats != null) {
			generalMap.put("dateOfStats",
					HMSUtil.convertDateToStringWithoutTime(dateOfStats));
		}
		if (dateOfCommandant != null) {
			generalMap.put("dateOfCommandant",
					HMSUtil.convertDateToStringWithoutTime(dateOfCommandant));
		}
		if (dateOfPathology != null) {
			generalMap.put("dateOfPathology",
					HMSUtil.convertDateToStringWithoutTime(dateOfPathology));
		}
		if (dateOfSA1 != null) {
			generalMap.put("dateOfSA1",
					HMSUtil.convertDateToStringWithoutTime(dateOfSA1));
		}
		if (dateOfSA2 != null) {
			generalMap.put("dateOfSA2",
					HMSUtil.convertDateToStringWithoutTime(dateOfSA2));
		}
		if (dateOfSA3 != null) {
			generalMap.put("dateOfSA3",
					HMSUtil.convertDateToStringWithoutTime(dateOfSA3));
		}
		if (dateOfSA4 != null) {
			generalMap.put("dateOfSA4",
					HMSUtil.convertDateToStringWithoutTime(dateOfSA4));
		}
		if (dateOfConcernedCommand != null) {
			generalMap.put("dateOfConcernedCommand", HMSUtil
					.convertDateToStringWithoutTime(dateOfConcernedCommand));
		}
		if (postmortem != null) {
			generalMap.put("postmortem", postmortem);
		}

		generalMap.put("hospitalId", hospitalId);
		generalMap.put("hinId", hinId);
		generalMap.put("adNo", adNo);

		generalMap.put("postmortem", postmortem);

		generalMap.put("deathRemark", deathRemark);
		generalMap.put("postmortemRemark", postmortemRemark);
		generalMap.put("postmortemDateRemark", postmortemDateRemark);
		generalMap.put("concernedDateRemark", concernedDateRemark);
		generalMap.put("opinionDateRemark", opinionDateRemark);
		generalMap.put("wardMasterDateRemark", wardMasterDateRemark);
		generalMap.put("wardDateRemark", wardDateRemark);
		generalMap.put("hodDateRemark", hodDateRemark);
		generalMap.put("statsDateRemark", statsDateRemark);
		generalMap.put("commandantDateRemark", commandantDateRemark);
		generalMap.put("pathologyDateRemark", pathologyDateRemark);
		generalMap.put("sa1DateRemark", sa1DateRemark);
		generalMap.put("sa2DateRemark", sa2DateRemark);
		generalMap.put("sa3DateRemark", sa3DateRemark);
		generalMap.put("sa4DateRemark", sa4DateRemark);
		generalMap
				.put("concernedCommandDateRemark", concernedCommandDateRemark);
		generalMap.put("inpatientId", inpatientId);

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("misFatalId", misFatalId);
		boolean dataUpdated = false;

		dataUpdated = misHandlerService.editFatalcase(generalMap);
		String messageType = "";
		if (dataUpdated == true) {
			message = "Data updated Successfully.Do you want to print ?";
			messageType = "success";
		} else {
			message = "Data Can not be updated";
			messageType = "failure";
		}

		/***********************************************************************
		 * when record is updated, it will show the MasEmployee table records
		 * for fetching from MasEmployee the value of surplusStatus is set to
		 * constant 2
		 **********************************************************************/

		url = "/hms/hms/mis?method=showAfmsfAnnualMedicalexaminationjsp";
		map = misHandlerService.showFatalCasejsp(inpatientId);

		jsp = MESSAGE_FOR_FDT;
		title = "update Fatal Case Document";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		map.put("messageType", messageType);
		map.put("inpatientId", inpatientId);
		return new ModelAndView("index", "map", map);

	}

	// ----------------------------Total Admissions Date Wise
	// --------------------------------------
	public ModelAndView showTotalAdmissionjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = null;
		session = request.getSession();
		map = misHandlerService.showTotalAdmissionjsp();
		jsp = TOTALADMISSION_JSP;
		jsp += ".jsp";
		title = "Total Admission";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchTotalAdmission(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate1 = null;
		Date toDate1 = null;
		String serviceType = "";
		String serviceTypeId = "";
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate1 = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate1 = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(SERVICE_TYPE_NAME) != null
					&& !(request.getParameter(SERVICE_TYPE_NAME).equals(""))) {
				serviceTypeId = request.getParameter(SERVICE_TYPE_NAME);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!serviceTypeId.equals("0")) {
			serviceType = " and  mas_service_type.service_type_id="
					+ serviceTypeId;
		}

		map = misHandlerService.getDBConnection();

		map.put("fromDate", fromDate1);
		map.put("toDate", toDate1);
		String stName = "All";
		if (request.getParameter("stName") != null
				&& !(request.getParameter("stName").equals(""))) {
			stName = request.getParameter("stName");
		}
		map.put("serviceType", serviceType);
		map.put("formCode", stName + " Personal in CHAF Bangalore -7");
		map.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));

		// byte[] bytes = null;
		// try {

		// bytes = JasperRunManager.runReportToPdf(
		// getCompiledReport("TotalAdmissionDateWise1"), map,
		// (Connection) map.get("conn"));
		// HMSUtil.generateReport("TotalAdmissionDateWise1", map,
		// (Connection)map.get("conn"), response, getServletContext());
		// } catch (JRException e) {

		// e.printStackTrace();
		// }
		// response.setContentType("application/pdf");
		// response.setContentLength(bytes.length);
		// ServletOutputStream ouputStream;
		// try {
		// ouputStream = response.getOutputStream();
		// ouputStream.write(bytes, 0, bytes.length);
		// ouputStream.flush();
		// ouputStream.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		try {
			HMSUtil.generateReport("TotalAdmissionDateWise1", map,
					(Connection) map.get("conn"), response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ------------------------ Total Discharge Date Wise
	// --------------------------------------
	public ModelAndView showTotalDischargejsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		String hinNo = null;
		session = request.getSession();
		map = misHandlerService.showTotalDischargejsp();
		jsp = TOTALDISCHARGEREPORT_JSP;
		jsp += ".jsp";
		title = "Total Admission";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchTotalDischarge(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String subPath = "";
		File reportFile = new File(getServletContext().getRealPath("/Reports/"));
		String toDate = null;
		String fromDate = null;
		String criteria = "";
		Date fromDateDate = null;
		Date toDateDate = null;
		String serviceType = "";
		String serviceTypeName = "All";
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = request.getParameter(TO_DATE);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = request.getParameter(FROM_DATE);
			}
			if (request.getParameter(SERVICE_TYPE_ID) != null
					&& !(request.getParameter(SERVICE_TYPE_ID).equals(""))) {
				serviceType = request.getParameter(SERVICE_TYPE_ID);
			}
			if (request.getParameter(SERVICE_TYPE_NAME) != null
					&& !(request.getParameter(SERVICE_TYPE_NAME).equals(""))) {
				serviceTypeName = request.getParameter(SERVICE_TYPE_NAME);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		fromDateDate = HMSUtil.convertStringTypeDateToDateType(fromDate);
		toDateDate = HMSUtil.convertStringTypeDateToDateType(toDate);
		map.put(fromDate, fromDateDate);
		map.put(toDate, toDateDate);

		if (!serviceType.equals("0")) {
			criteria = " and mas_service_type.service_type_id=" + serviceType;
		}
		map = misHandlerService.getDBConnection();
		byte[] bytes = null;
		subPath = reportFile.toString();
		map.put("SUBREPORT_DIR", subPath);
		map.put("toDate", toDateDate);
		map.put("fromDate", fromDateDate);
		map.put("criteria", criteria);
		map.put("formCode", serviceTypeName
				+ " Personnel in CHAF Bangalore - 7");
		// try {
		// bytes =
		// JasperRunManager.runReportToPdf(getCompiledReport("TotalDischargeDateWise"),
		// map,(Connection) map.get("conn"));

		// } catch (Exception e) {

		// e.printStackTrace();
		// }
		// response.setContentType("application/pdf");
		// response.setContentLength(bytes.length);
		// ServletOutputStream ouputStream;
		// try {
		// ouputStream = response.getOutputStream();
		// ouputStream.write(bytes, 0, bytes.length);
		// ouputStream.flush();
		// ouputStream.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		HMSUtil.generateReport("TotalDischargeDateWise", map,
				(Connection) map.get("conn"), response, getServletContext());
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ---------------------------------- Monthly Sick for Admissions
	 * -------------------------------
	 */
	public ModelAndView showMonthlySickReportsjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = misHandlerService.showMonthlySickReportsjsp();
		jsp = MONTHLYSICKREPORT_JSP;
		jsp += ".jsp";
		title = "monthlySick";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchMonthlySickReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		Date toDate = null;
		Date fromDate = null;
		String outputType = null;
		String category_ids = null;
		String temp = "";
		StringBuffer category_queryString = new StringBuffer();
		StringBuffer unit_queryString = new StringBuffer();
		byte[] bytes = null;
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}

			if (request.getParameter("outputType") != null
					&& !(request.getParameter("outputType").equals(""))) {
				outputType = request.getParameter("outputType");
			}
			if (request.getParameter("nc") != null
					&& !(request.getParameter("nc").equals(""))) {
				if (request.getParameter("nc").equalsIgnoreCase("nc")) {
					temp = "and c.rank_id =19";
				} else {
					temp = "and c.rank_id !=19";
				}
			}
			// category_ids = box.getVector(CATEGORY_ID).toString();
			// unit_ids = box.getVector("unit").toString();
			// if (category_ids.length() > 0)
			// {
			// category_ids = category_ids.substring(1,category_ids.length()-1);
			// category_queryString.append("and i.rank_category_id in (");
			// category_queryString.append(category_ids);
			// category_queryString.append(")");
			// }
			// if (unit_ids.length() > 0)
			// {
			// unit_ids = unit_ids.substring(1,unit_ids.length()-1);
			// unit_queryString.append("and f.unit_id in (");
			// unit_queryString.append(unit_ids);
			// unit_queryString.append(")");
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("temp", temp);
		map.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));

		if (outputType.equals("Excel")) {
			try

			{

				JRXlsExporter exporter = new JRXlsExporter();
				JasperPrint jasperPrint = JasperFillManager.fillReport(
						getCompiledReport("MonthlySickReport"), map,
						(Connection) map.get("conn"));
				ByteArrayOutputStream xlsReport = new ByteArrayOutputStream();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT,
						jasperPrint);
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,
						xlsReport);
				exporter.setParameter(
						JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,
						Boolean.TRUE);
				exporter.setParameter(
						JRXlsExporterParameter.IS_DETECT_CELL_TYPE,
						Boolean.TRUE);
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE,
						getServletContext().getRealPath("/Reports/"));
				exporter.exportReport();
				bytes = xlsReport.toByteArray();
				response.setContentType("application/vnd.ms-excel");
				response.setContentLength(bytes.length);
				xlsReport.close();

			} catch (JRException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (outputType.equals("Pdf")) {

			try {

				HMSUtil.generateReport("MonthlySickReport", map,
						(Connection) map.get("conn"), response,
						getServletContext());
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * ----------------------------------- Monthly Sick For Discharge
	 * ----------------------------
	 */
	public ModelAndView showMonthlySickDischargeReportjsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = misHandlerService.showMonthlySickDischargeReportjsp();
		jsp = MONTHLYSICKDISCHARGEREPORT_JSP;
		jsp += ".jsp";
		title = "monthlySickDischarge";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchMonthlySickDischargeReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		Date toDate = null;
		Date fromDate = null;
		String category = null;
		String outputType = null;
		byte[] bytes = null;
		String temp = "";
		String unit_ids = null;
		StringBuffer category_queryString = new StringBuffer();
		StringBuffer unit_queryString = new StringBuffer();
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(CATEGORY_ID) != null
					&& !(request.getParameter(CATEGORY_ID).equals(""))) {
				category = request.getParameter(CATEGORY_ID);
			}
			if (request.getParameter("outputType") != null
					&& !(request.getParameter("outputType").equals(""))) {
				outputType = request.getParameter("outputType");
			}
			if (request.getParameter("nc") != null
					&& !(request.getParameter("nc").equals(""))) {
				if (request.getParameter("nc").equalsIgnoreCase("nc")) {
					temp = "and c.rank_id =19";
				} else {
					temp = "and c.rank_id !=19";
				}
			}
			// category_ids = box.getVector(CATEGORY_ID).toString();
			// unit_ids = box.getVector("unit").toString();
			// if (category_ids.length() > 0)
			// {
			// category_ids = category_ids.substring(1,category_ids.length()-1);
			// category_queryString.append("and i.rank_category_id in (");
			// category_queryString.append(category_ids);
			// category_queryString.append(")");
			// }
			// if (unit_ids.length() > 0)
			// {
			// unit_ids = unit_ids.substring(1,unit_ids.length()-1);
			// unit_queryString.append("and f.unit_id in (");
			// unit_queryString.append(unit_ids);
			// unit_queryString.append(")");
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.showMonthlySickDischargeReportjsp();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("temp", temp);
		map.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));

		if (outputType.equals("Excel")) {
			try

			{

				JRXlsExporter exporter = new JRXlsExporter();
				JasperPrint jasperPrint = JasperFillManager.fillReport(
						getCompiledReport("MonthlySickDischargeReport"), map,
						(Connection) map.get("conn"));

				ByteArrayOutputStream xlsReport = new ByteArrayOutputStream();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT,
						jasperPrint);
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,
						xlsReport);
				exporter.setParameter(
						JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,
						Boolean.TRUE);
				exporter.setParameter(
						JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN,
						Boolean.TRUE);
				exporter.setParameter(
						JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
						Boolean.TRUE);
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE,
						getServletContext().getRealPath("/Reports/"));
				exporter.exportReport();
				bytes = xlsReport.toByteArray();
				response.setContentType("application/vnd.ms-excel");
				response.setContentLength(bytes.length);
				xlsReport.close();

			} catch (JRException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (outputType.equals("Pdf")) {

			try {

				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("MonthlySickDischargeReport"), map,
						(Connection) map.get("conn"));

			} catch (JRException e) {

				e.printStackTrace();
			}
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
		}
		ServletOutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ModelAndView("index", "map", map);
	}

	/**
	 * ------------------------ Fatal Document Panchnama Report
	 * --------------------------
	 */
	public ModelAndView showFatalDocumentPanchnamaReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = FATAL_DOCUMENT_PANCHNAMA + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showFatalDocumentPanchnamaReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int inpatient_id = 0;

		if (request.getParameter(AD_NO) != null) {
			inpatient_id = Integer.parseInt("" + request.getParameter(AD_NO));
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("inpatient_id", inpatient_id);
		HMSUtil.generateReport("FatalDocumentPanchnama", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getAdmissionNoList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String hinNo = "";

		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			detailsMap.put("hinNo", hinNo);
		}
		List<Object> admissionNoList = new ArrayList<Object>();
		List<Object> hinNoList = new ArrayList<Object>();
		String flag = "";
		String fatalCase = "";
		String onlyReport = "";

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}
		if (request.getParameter("fatalCase") != null) {
			fatalCase = request.getParameter("fatalCase");
			map.put("fatalCase", fatalCase);
			detailsMap.put("fatalCase", "fatalCase");
		}
		if (request.getParameter("onlyReport") != null) {
			onlyReport = request.getParameter("onlyReport");
			map.put("onlyReport", onlyReport);
			detailsMap.put("onlyReport", "yes");
		}
		if (flag.equals("admission")) {
			admissionNoList = misHandlerService.getAdmissionNoList(detailsMap);
			map.put("admissionNoList", admissionNoList);
			jsp = MIS_RESPONSE_FOR_ADMISSION_NO;
		} else if (flag.equals("hin")) {
			hinNoList = misHandlerService.getHinNoList(hinNo);
			map.put("onlyReport", onlyReport);
			map.put("hinNoList", hinNoList);
			jsp = MIS_RESPONSE_FOR_HIN_NO;
		} else if (fatalCase.equals("yes")) {
			admissionNoList = misHandlerService.getAdmissionNoList(detailsMap);
			map.put("admissionNoList", admissionNoList);
			jsp = MIS_RESPONSE_FOR_ADNO_FATALCASE;
		} else if (onlyReport.equals("yes")) {
			admissionNoList = misHandlerService.getAdmissionNoList(detailsMap);
			map.put("admissionNoList", admissionNoList);
			map.put("onlyReport", onlyReport);
			jsp = MIS_RESPONSE_FOR_ADNO_BIRTH_DEATH_REPORT;
		}
		return new ModelAndView(jsp, "map", map);
	}

	/**
	 * ------------------------------ DEATH INFORMATION
	 * REPORT----------------------------
	 *
	 */
	public ModelAndView showDeathInformationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = DEATH_INFORMATION + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showDeathInformation(HttpServletRequest request,
			HttpServletResponse response) {
		int inpatientId = 0;
		String radioValue = null;
		String to = null;
		String info1 = "";
		String info2 = "";
		String info3 = "";

		String channel1 = "";
		String channel2 = "";
		String channel3 = "";
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		if (request.getParameter(AD_NO) != null) {
			inpatientId = Integer.parseInt("" + request.getParameter(AD_NO));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			radioValue = request.getParameter(SELECTED_RADIO);
		}
		if (request.getParameter(TO) != null) {
			to = request.getParameter(TO);
		}
		if (request.getParameter(INFO1) != null) {
			info1 = request.getParameter(INFO1);
		}
		if (request.getParameter(INFO2) != null) {
			info2 = request.getParameter(INFO2);
		}
		if (request.getParameter(INFO3) != null) {
			info3 = request.getParameter(TO);
		}

		if (request.getParameter(CHANNEL1) != null) {
			channel1 = request.getParameter(CHANNEL1);
		}
		if (request.getParameter(CHANNEL2) != null) {
			channel2 = request.getParameter(CHANNEL2);
		}
		if (request.getParameter(CHANNEL3) != null) {
			channel3 = request.getParameter(CHANNEL3);
		}
		String drafterName = "";
		String rank = "";
		String name = "";
		String nok = "";
		if (request.getParameter(RANK) != null) {
			rank = request.getParameter(RANK);
		}
		if (request.getParameter(NAME) != null) {
			name = request.getParameter(NAME);
		}
		if (request.getParameter(DRAFTER_NAME) != null) {
			drafterName = request.getParameter(DRAFTER_NAME);
		}
		if (request.getParameter("nok") != null) {
			nok = request.getParameter("nok");
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap.put("inpatientId", inpatientId);
		detailsMap = misHandlerService.showDeathInformation(detailsMap);
		inpatientList = (List<Inpatient>) detailsMap.get("inpatientList");
		@SuppressWarnings("unused")
		List<ExpiryDetails> expiryDetailsList = new ArrayList<ExpiryDetails>();
		expiryDetailsList = (List<ExpiryDetails>) detailsMap
				.get("expiryDetailsList");
		String ptName = "";
		String serviceNo = "";
		String age = "";
		String doa = "";
		String toa = "";
		String expDate = "";
		String expTime = "";
		String diagnosisConclusionName = "";
		String relation = "";
		String serName = "";
		String address = "";
		if (inpatientList.size() > 0) {
			for (Inpatient inpatient : inpatientList) {
				ptName = inpatient.getHin().getPFirstName() + " "
						+ inpatient.getHin().getPMiddleName() + " "
						+ inpatient.getHin().getPLastName();
				serviceNo = inpatient.getHin().getServiceNo();
				age = inpatient.getHin().getAge();
				doa = "" + inpatient.getDateOfAddmission();
				toa = inpatient.getTimeOfAddmission();
				relation = inpatient.getHin().getRelation().getRelationName();
				serName = inpatient.getHin().getSFirstName() + " "
						+ inpatient.getHin().getSMiddleName() + " "
						+ inpatient.getHin().getSLastName();
				diagnosisConclusionName = inpatient.getInitDiagnosis();
			}
		}
		if (expiryDetailsList.size() > 0) {
			for (ExpiryDetails expiryDetails : expiryDetailsList) {
				expDate = "" + expiryDetails.getExpiryDate();
				expTime = expiryDetails.getExpiryTime();

			}
		}
		@SuppressWarnings("unused")
		String information = "DEATH INFORMATION: SERVING PERSONNEL (.) REGRET TO INFORM  "
				+ ptName
				+ " ("
				+ serviceNo
				+ ") AGED"
				+ age
				+ " YRS OF FIRST ADDRESSE ADMITTED TO ORIG ON "
				+ doa
				+ " AT "
				+ toa
				+ " HRS (.) EXPIRED ON "
				+ expDate
				+ " AT "
				+ expTime
				+ " HRS (.) DIAGNOSIS (.) "
				+ diagnosisConclusionName
				+ " NOK (.) "
				+ relation
				+ " (.) "
				+ " (.) ADDRESS(.) "
				+ address
				+ " NOK "
				+ nok
				+ " (.) ORIG TELEPHONE NO 080-25369030 EXTN 203 CMA FAX NO 080-25514406";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("information", information);
		parameters.put("info1", info1);
		parameters.put("info2", info2);
		parameters.put("info3", info3);

		parameters.put("channel1", channel1);
		parameters.put("channel2", channel2);
		parameters.put("channel3", channel3);

		if (radioValue.equals("Navy")) {
			parameters.put("line1", to);
			parameters.put("line2", "NAVAL HQ (DGMS)");
			parameters.put("line3", "AIR HQ RK PURAM, DGMS(AIR)");
			parameters.put("line4", "NAVAL HQ (DPO)");
			parameters.put("line5", "AIR HQ RK PURAM, (MED-7)");
			parameters.put("line6", "HQ SOUTHERN NAVAL COMMAND");
			parameters.put("line7", "NAVAL GROUP INSURANCE SCHEME");
			parameters.put("line8", "(SENA BHAVAN)");
			parameters.put("line7", "HQ TC IAF (Dy PMO)");
			parameters.put("line9", "NAVAL DETACHMENT IST MAIN ROAD");
			parameters.put("line10", "SK GARDENS BENSON TOWN B'LORE 46");
			parameters.put("line12", "BY D/R (BY ORIG)");
			parameters.put("line21", "BY ARMY CHANNEL");
			parameters.put("line31", "BY ARMY CHANNEL");
			parameters.put("line41", "BY ARMY CHANNEL");
			parameters.put("line51", "BY ARMY CHANNEL");
			parameters.put("line61", "BY ARMY CHANNEL");
			parameters.put("line71", "BY ARMY CHANNEL");
			parameters.put("line81", "BY D/R");
			parameters.put("line91", "BY D/R (ORIG)");
			parameters.put("line101", "");
			parameters.put("line111", "");
			parameters.put("param", "MWO KPG ILLAI");
		} else if (radioValue.equals("Army")) {
			parameters.put("line1", to);
			parameters.put("line2", "ARMY HQ (DGMS) MED DTE");
			parameters.put("line3", "AIR HQ RK RURAM, DGMS (AIR)");
			parameters.put("line4", "AIR HQ RK PURAM, (MED-7)");
			parameters.put("line5", "AGI ARMY HQ NEW DELHI");
			parameters.put("line6", "HQ TC IAF (PMO)");
			parameters.put("line7", "HQ SC PUNE(MED)");
			parameters.put("line8", "HQ ATN K & K AREA (MED)");
			parameters.put("line9", "HQ SUB AREA K & K  (COL A)");
			parameters.put("line10", "ARTY DEPOT & RECORDS NASIK RD");

			parameters.put("line12", "BY ARMY CHANNEL");

			parameters.put("line21", "BY ARMY CHANNEL");
			parameters.put("line31", "BY AF CHANNEL");
			parameters.put("line41", "BY AF CHANNEL");
			parameters.put("line51", "BY ARMY CHANNEL");
			parameters.put("line61", "BY D/R (ORIG)");
			parameters.put("line71", "BY ARMY CHANNEL");
			parameters.put("line81", "BY ARMY CHANNEL");
			parameters.put("line91", "BY D/R (ORIG)");
			parameters.put("line101", "BY ARMY CHANNEL");
			parameters.put("param", "MWO KPG PILLAI");
		} else if (radioValue.equals("airForce")) {
			parameters.put("line1", to);
			parameters.put("line2", "AIR HQ RK RURAM, DGMS (AIR)");
			parameters.put("line3", "AIR HQ RK RURAM (MED-7)");
			parameters.put("line4", "AFRO (MED WING)");
			parameters.put("line5", "AFRO (RW)");
			parameters.put("line6", "AFCAO");
			parameters.put("line7", "AFGIS");
			parameters.put("line8", "IAFBA");
			parameters.put("line9", "AFWWA (C)");
			parameters.put("line10", "HQ TC (DY PMO)");
			parameters.put("line11", "IAM");
			parameters.put("line12", "BY D/R");
			parameters.put("line21", "BY AF CHANNEL");
			parameters.put("line31", "BY AF CHANNEL");
			parameters.put("line41", "BY AF CHANNEL");
			parameters.put("line51", "BY AF CHANNEL");
			parameters.put("line61", "BY AF CHANNEL");
			parameters.put("line71", "BY AF CHANNEL");
			parameters.put("line81", "BY AF CHANNEL");
			parameters.put("line91", "BY AF CHANNEL");
			parameters.put("line101", "BY D/R");
			parameters.put("line111", "BY D/R");
			parameters.put("param", "MWO (HONY FG OFFR) KPG PILLAI");

		}
		parameters.put("name", name);
		parameters.put("rank", rank);
		parameters.put("drafterName", drafterName);
		HMSUtil.generateReport("DeathInformationReport", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	/**
	 * -------------------------- DEFICIENT / SURPLUS / ANNUAL
	 * REPORT----------------------------
	 *
	 */
	public ModelAndView showDeficientSurplusAnnualJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = DEFICIENT_SURPLUS_ANNUAL + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showDeficientSurplusAnnual(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date toDate = null;
		Date fromDate = null;
		String selectedRadio = null;
		String selectedStatus = null;
		byte[] bytes = null;
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				selectedRadio = request.getParameter(SELECTED_RADIO);
			}

			if (request.getParameter(SELECTED_STATUS) != null
					&& !(request.getParameter(SELECTED_STATUS).equals(""))) {
				selectedStatus = request.getParameter(SELECTED_STATUS);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		map = misHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("afmsfType", selectedRadio);
		map.put("status", selectedStatus);

		if (selectedRadio.equals("R")) {
			map.put("deficient_surplus", "Deficient Employee");
		} else if (selectedRadio.equals("D")) {
			map.put("deficient_surplus", "Surplus Employee");
		}
		try {
			if (selectedRadio.equals("R")) {
				HMSUtil.generateReport("deficientSurplusAnnualReport", map,
						(Connection) map.get("conn"), response,
						getServletContext());
			} else if (selectedRadio.equals("D")) {
				HMSUtil.generateReport("deficientSurplusAnnualReportStatusNo",
						map, (Connection) map.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * -------------------------- DEFICIENT / SURPLUS / ANNUAL
	 * REPORT----------------------------
	 *
	 */
	public ModelAndView showSilDilReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = SIL_DIL_REPORT + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showSilDilReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date toDate = null;
		Date fromDate = null;
		String to = null;
		String to2 = null;
		String rank = null;
		String name = null;
		String drafterName = null;
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter("to") != null
					&& !(request.getParameter("to").equals(""))) {
				to = request.getParameter("to");
			}
			if (request.getParameter("to2") != null
					&& !(request.getParameter("to2").equals(""))) {
				to2 = request.getParameter("to2");
			}
			if (request.getParameter("rank") != null
					&& !(request.getParameter("rank").equals(""))) {
				rank = request.getParameter("rank");
			}
			if (request.getParameter("name") != null
					&& !(request.getParameter("name").equals(""))) {
				name = request.getParameter("name");
			}
			if (request.getParameter("drafterName") != null
					&& !(request.getParameter("drafterName").equals(""))) {
				drafterName = request.getParameter("drafterName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("rank", rank);
		map.put("name", name);
		map.put("drafterName", drafterName);
		map.put("to", to);
		map.put("to2", to2);
		map.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		HMSUtil.generateReport("silDilReport", map,
				(Connection) map.get("conn"), response, getServletContext());
		return null;
	}

	/**
	 * -------------------------- FATAL CASE DOCUMENT
	 * REPORT----------------------------
	 *
	 */
	public ModelAndView showFatalCaseReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = FATAL_CASE_REPORT + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showFatalCaseReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date toDate = null;
		Date fromDate = null;
		String to = null;
		String discharge = null;
		byte[] bytes = null;
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(TO) != null
					&& !(request.getParameter(TO).equals(""))) {
				to = request.getParameter(TO);
			}

			if (request.getParameter(DISCHARGE_STATUS_ID) != null
					&& !(request.getParameter(DISCHARGE_STATUS_ID).equals(""))) {
				discharge = request.getParameter(DISCHARGE_STATUS_ID);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		map = misHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("discharge", discharge);
		map.put("to", to);
		try {

			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport("fatalCaseReport"), map,
					(Connection) map.get("conn"));

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

		return new ModelAndView("index", "map", map);
	}

	/**
	 * -------------------------- FRW CASES SCREEN ----------------------------
	 *
	 */
	public ModelAndView showFrwCasesJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = misHandlerService.showFrwCases();
		jsp = FRW_CASES + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitFrwCases(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		int hinId = 0;
		int disposalId = 0;
		Date frwDate = null;
		String to = null;
		String toClass = null;
		String frwSerialNo = "";
		String por = null;
		String serviceNo = "";
		String sickLeave = null;
		String review = null;
		Date fromDate = null;
		Date toDate = null;

		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals(""))) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter(DISPOSAL_ID) != null
				&& !(request.getParameter(DISPOSAL_ID).equals(""))) {
			disposalId = Integer.parseInt(request.getParameter(DISPOSAL_ID));
		}
		String otherHospital = "";
		if (disposalId == 12) {
			if (request.getParameter(HOSPITAL_NAME) != null
					&& !(request.getParameter(HOSPITAL_NAME).equals(""))) {
				otherHospital = (request.getParameter(HOSPITAL_NAME));
			}
		}
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			frwDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}

		if (request.getParameter(SICK_FROM_DATE) != null
				&& !(request.getParameter(SICK_FROM_DATE).equals(""))) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(SICK_FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}

		if (request.getParameter(REVIEW_AT) != null
				&& !(request.getParameter(REVIEW_AT).equals(""))) {
			review = request.getParameter(REVIEW_AT);
		}

		if (request.getParameter(TO) != null
				&& !(request.getParameter(TO).equals(""))) {
			to = request.getParameter(TO);
		}
		if (request.getParameter(CLASS) != null
				&& !(request.getParameter(CLASS).equals(""))) {
			toClass = request.getParameter(CLASS);
		}
		if (request.getParameter(FRW_SR_NO) != null
				&& !(request.getParameter(FRW_SR_NO).equals(""))) {
			frwSerialNo = (request.getParameter(FRW_SR_NO));
		}
		if (request.getParameter(POR) != null
				&& !(request.getParameter(POR).equals(""))) {
			por = request.getParameter(POR);
		}

		if (request.getParameter(SICK_LEAVE) != null
				&& !(request.getParameter(SICK_LEAVE).equals(""))) {
			sickLeave = request.getParameter(SICK_LEAVE);
		}

		generalMap.put("hinId", hinId);
		generalMap.put("disposalId", disposalId);
		generalMap.put("frwDate", frwDate);
		generalMap.put("to", to);
		generalMap.put("toClass", toClass);
		generalMap.put("frwSerialNo", frwSerialNo);
		generalMap.put("por", por);
		generalMap.put("otherHospital", otherHospital);
		generalMap.put("sickLeave", sickLeave);
		generalMap.put("review", review);
		generalMap.put("fromDate", fromDate);
		generalMap.put("toDate", toDate);

		boolean dataUpdated = false;

		map = misHandlerService.submitFrwCases(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully";

		} else {
			message = "Data Cant be updated";

		}
		map.put("hinId", hinId);
		map.put("serviceNo", serviceNo);
		map.put("disposalId", disposalId);
		jsp = "messageForMisFrw";
		title = "updateF-1 Def";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);

		return new ModelAndView("index", "map", map);

	}

	// ---------- Common Method for Report ---------------------------

	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(getServletContext().getRealPath(
				"/Reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile);

		return jasperReport;
	}

	/**
	 * -------------------------- Notifiable Disease entry Form ----------------
	 *
	 * @return
	 */

	public ModelAndView showNotifiableDiseaseJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		map = misHandlerService.showNotifiableDiseaseJsp(generalMap);
		jsp = NOTIFIABLE_DISEASE_JSP;
		jsp += ".jsp";
		title = "Notifiable Disease";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showNotifiableDisease(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		String adNo = null;
		int inpatientId = 0;
		session = request.getSession();
		if (request.getParameter(AD_NO) != null
				&& !(request.getParameter(AD_NO).equals(""))) {
			inpatientId = Integer.parseInt(request.getParameter(AD_NO));
		}
		session.setAttribute("adNo", adNo);
		generalMap.put("inpatientId", inpatientId);

		map = misHandlerService.showNotifiableDisease(generalMap);

		jsp = SUBMIT_NOTIFIABLE_DISEASE_JSP;
		title = "Notifiable Disease";
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView editNotifiableDisease(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String currentDate = null;
		String currentDatetoStr = null;
		int hospitalId = 0;
		int inpatientId = 0;
		int basisOfDiagnosis = 0;
		int hinId = 0;

		String changedBy = "";
		String postmortem = null;

		Date dateOfOnset = new Date();
		Date dateOfReportingSick = new Date();
		Date dateOfPreventive = new Date();
		Date dateOfNotifiable = new Date();

		String designation = null;
		String suspectedSource = null;
		String measuresOfControl = null;
		String contact = null;
		String generalRemarks = null;
		String station = null;

		// inpatientId = (Integer) session.getAttribute("inpatientId");
		hospitalId = (Integer) session.getAttribute("hospitalId");
		hinId = (Integer) session.getAttribute("hinId");

		if (request.getParameter(NOTIFIABLE_DATE) != null
				&& !(request.getParameter(NOTIFIABLE_DATE).equals(""))) {
			dateOfNotifiable = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(NOTIFIABLE_DATE));
		}

		if (request.getParameter(DATE_OF_ONSET) != null
				&& !(request.getParameter(DATE_OF_ONSET).equals(""))) {
			dateOfOnset = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_ONSET));
		}

		if (request.getParameter(DATE_OF_REPORTING_SICK) != null
				&& !(request.getParameter(DATE_OF_REPORTING_SICK).equals(""))) {
			dateOfReportingSick = HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter(DATE_OF_REPORTING_SICK));
		}

		if (request.getParameter(DATE_OF_PREVENTIVE) != null
				&& !(request.getParameter(DATE_OF_PREVENTIVE).equals(""))) {
			dateOfPreventive = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_PREVENTIVE));
		}
		if (request.getParameter(DESIGNATION) != null
				&& !(request.getParameter(DESIGNATION).equals(""))) {
			designation = request.getParameter(DESIGNATION);
		}
		if (request.getParameter(BASIS_OF_DIAGNOSIS) != null
				&& !(request.getParameter(BASIS_OF_DIAGNOSIS).equals(""))) {
			basisOfDiagnosis = Integer.parseInt(request
					.getParameter(BASIS_OF_DIAGNOSIS));
		}
		if (request.getParameter(SUSPECTED_SOURCE_OF_INFECTION) != null
				&& !(request.getParameter(SUSPECTED_SOURCE_OF_INFECTION)
						.equals(""))) {
			suspectedSource = request
					.getParameter(SUSPECTED_SOURCE_OF_INFECTION);
		}
		if (request.getParameter(MEASURES_OF_CONTROL) != null
				&& !(request.getParameter(MEASURES_OF_CONTROL).equals(""))) {
			measuresOfControl = request.getParameter(MEASURES_OF_CONTROL);
		}
		if (request.getParameter(CONTACT) != null
				&& !(request.getParameter(CONTACT).equals(""))) {
			contact = request.getParameter(CONTACT);
		}
		if (request.getParameter(GENERAL_REMARKS) != null
				&& !(request.getParameter(GENERAL_REMARKS).equals(""))) {
			generalRemarks = request.getParameter(GENERAL_REMARKS);
		}
		if (request.getParameter(STATION) != null
				&& !(request.getParameter(STATION).equals(""))) {
			station = request.getParameter(STATION);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = request.getParameter(CHANGED_DATE);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter(AD_NO) != null
				&& !(request.getParameter(AD_NO).equals(""))) {
			inpatientId = Integer.parseInt(request.getParameter(AD_NO));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		generalMap.put("dateOfOnset", dateOfOnset);
		generalMap.put("dateOfReportingSick", dateOfReportingSick);
		generalMap.put("dateOfPreventive", dateOfPreventive);
		generalMap.put("dateOfNotifiable", dateOfNotifiable);

		generalMap.put("hospitalId", hospitalId);
		generalMap.put("hinId", hinId);
		generalMap.put("inpatientId", inpatientId);
		generalMap.put("basisOfDiagnosis", basisOfDiagnosis);
		generalMap.put("suspectedSource", suspectedSource);
		generalMap.put("measuresOfControl", measuresOfControl);
		generalMap.put("contact", contact);
		generalMap.put("generalRemarks", generalRemarks);
		generalMap.put("station", station);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("designation", designation);

		boolean dataUpdated = false;

		dataUpdated = misHandlerService.editNotifiableDisease(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully";
		} else {
			message = "Data Cant be updated";

		}
		// url = "/hms/hms/mis?method=showAfmsfAnnualMedicalexaminationjsp";
		map = misHandlerService.showNotifiableDiseaseJsp(generalMap);

		jsp = NOTIFIABLE_DISEASE_JSP;
		title = "update Notifiable Disease";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);

		return new ModelAndView("index", "map", map);

	}

	/**
	 * ----------------------------------- NOTIFIABLE DISEASE REPORT
	 * --------------------------
	 *
	 * @return
	 */

	public ModelAndView showNotifiableDiseaseReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = misHandlerService.showNotifiableDiseaseReportJsp();
		jsp = NOTIFIABLE_DISEASE_REPORT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showNotifiableDiseaseReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int inpatientId = 0;
		int icdCode = 0;
		String to = null;

		if (request.getParameter(AD_NO) != null) {
			inpatientId = Integer.parseInt(request.getParameter(AD_NO));
		}
		if (request.getParameter(BASIS_OF_DIAGNOSIS) != null) {
			icdCode = Integer
					.parseInt(request.getParameter(BASIS_OF_DIAGNOSIS));
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		byte[] bytes = null;
		parameters.put("inpatientId", inpatientId);
		parameters.put("icdId", icdCode);

		try {
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport("notifiable_report"), parameters,
					(Connection) detailsMap.get("conn"));
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JRException e) {

			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ------------------------------ MALARIA CASES REPORT
	 * -----------------------
	 *
	 * @return
	 */
	public ModelAndView showMalariaCaseReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = misHandlerService.showMalariaCaseReportJsp();
		jsp = MALARIA_CASE_REPORT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showMalariaCaseReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date toDate = null;
		Date fromDate = null;
		String icdName = null;

		byte[] bytes = null;
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(ICD_CODE) != null
					&& !(request.getParameter(ICD_CODE).equals(""))) {
				icdName = request.getParameter(ICD_CODE);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("icdName", icdName);
		try {
			map.put("SUBREPORT_DIR",
					getServletContext().getRealPath("/Reports/"));
			HMSUtil.generateReport("malaria_cases_report", map,
					(Connection) map.get("conn"), response, getServletContext());

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView showUploadJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		// map = misHandlerService.showBedStatisticsSummary();
		jsp = "upload";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showUploadFile(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		// map = misHandlerService.showBedStatisticsSummary();
		String contentType = request.getContentType();
		try {
			if ((contentType != null)
					&& (contentType.indexOf("multipart/form-data") >= 0)) {
				DataInputStream in = new DataInputStream(
						request.getInputStream());
				int formDataLength = request.getContentLength();
				byte dataBytes[] = new byte[formDataLength];
				int byteRead = 0;
				int totalBytesRead = 0;

				while (totalBytesRead < formDataLength) {
					byteRead = in.read(dataBytes, totalBytesRead,
							formDataLength);
					totalBytesRead += byteRead;
				}
				String file = new String(dataBytes);
				String saveFile = file
						.substring(file.indexOf("filename=\"") + 10);
				saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
				saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,
						saveFile.indexOf("\""));
				// out.print(dataBytes);

				int lastIndex = contentType.lastIndexOf("=");
				String boundary = contentType.substring(lastIndex + 1,
						contentType.length());
				// out.println(boundary);
				int pos;
				pos = file.indexOf("filename=\"");

				pos = file.indexOf("\n", pos) + 1;

				pos = file.indexOf("\n", pos) + 1;

				pos = file.indexOf("\n", pos) + 1;

				int boundaryLocation = file.indexOf(boundary, pos) - 4;
				int startPos = ((file.substring(0, pos)).getBytes()).length;
				int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;

				FileOutputStream fileOut = new FileOutputStream(saveFile);

				// fileOut.write(dataBytes);
				fileOut.write(dataBytes, startPos, (endPos - startPos));
				fileOut.flush();
				fileOut.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// out.println("File saved as " +saveFile);

		jsp = "upload";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * -------------------------------------- BIRTH DEATH REGISTER
	 * --------------------------
	 *
	 * @param request
	 * @param response
	 * @return
	 */

	public ModelAndView showBirthDeathRegisterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		jsp = "birthDeathRegister";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showBirthDeathRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		String radioValue = null;
		int inpatientId = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			if (flag.equals("birth")) {
				HMSUtil.generateReport("BirthDeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (flag.equals("death")) {
				HMSUtil.generateReport("DeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * -------------------------------------- MIS DAILY
	 * REPORT--------------------------
	 *
	 * @param request
	 * @param response
	 * @return
	 */

	public ModelAndView showMisDailyReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = misHandlerService.showMisDailyReportJsp();
		jsp = MIS_DAILY_REPORT;
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showMisDailyReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date toDate = null;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		byte[] bytes = null;
		parameters.put("toDate", toDate);
		map.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));

		try {

			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport("BedStatusReport"), parameters,
					(Connection) detailsMap.get("conn"));

			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	// ---------------------------II Bed State-----------------------
	public ModelAndView showIIBedStateJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		// session = request.getSession();
		// map = misHandlerService.showBedStatisticsSummary();
		jsp = II_BED_STATE_JSP;
		jsp += ".jsp";
		title = "IIBedStateReport";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showIIBedStateReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		Map<String, Object> map1 = new HashMap<String, Object>();

		Date toDate = null;
		Date fromDate = null;
		byte[] bytes = null;
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();

		map.put("fromDate", fromDate);
		map.put("toDate", toDate);

		try {
			map = misHandlerService.showIIBedStateReport(map);
			map.put("PATH_TO_SUBREPORTS",
					getServletContext().getRealPath("/Reports/"));
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport("IIBedState"), map,
					(Connection) map.get("conn"));
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
		return new ModelAndView("index", "map", map);
	}

	// ---------------------------Bed Statistics Summary-----------------------
	public ModelAndView showBedStatisticsReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = misHandlerService.showBedStatisticsSummary();
		jsp = BED_STATISTICS_SUMMARY_REPORT_JSP;
		jsp += ".jsp";
		title = "bedsStatisticsStatisticsReport";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchBedStatisticsReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Date toDate = null;
		Date fromDate = null;
		int searchRadio = 1;
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				dataMap.put("toDate", request.getParameter(TO_DATE));
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				dataMap.put("fromDate", request.getParameter(FROM_DATE));
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));
		try {
			if (searchRadio == 1) {
				parameters = misHandlerService.bedStatisticsSummary(dataMap);

				HMSUtil.generateReport("subBedStatisticsDetail4", parameters,
						(Connection) map.get("conn"), response,
						getServletContext());
			} else if (searchRadio == 2) {
				HMSUtil.generateReport("BedStatisticsDetailNew", parameters,
						(Connection) map.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// --------------------------Daily Ward Wise Bed -/
	// Status---------------------------------
	public ModelAndView showDailyBedStatusReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = misHandlerService.showDailyBedStatusReport();
		jsp = DAILY_BED_STATUS_JSP;
		jsp += ".jsp";
		title = "dailyBedStatus";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchDailyBedStatusReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date toDate = null;
		Date fromDate = null;
		String dept = null;
		byte[] bytes = null;
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			// if (request.getParameter(FROM_DATE) != null &&
			// !(request.getParameter(FROM_DATE).equals(""))) {
			// fromDate =
			// HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			// }
			// if (request.getParameter(DEPARTMENT_ID) != null &&
			// !(request.getParameter(DEPARTMENT_ID).equals(""))) {
			// dept = request.getParameter(DEPARTMENT_ID);
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		// map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		// map.put("Ward", dept);
		HMSUtil.generateReport("DailyBedStatus", map,
				(Connection) map.get("conn"), response, getServletContext());
		return null;
	}

	// -------------------------Birth
	// Certificate------------------------------------------
	public ModelAndView showBirthCertificateJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = misHandlerService.showBirthCertificateJsp();
		String jsp = BIRTH_CERTIFICATE;
		jsp += ".jsp";
		title = "birth Certificate";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showBirth(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> tempMap = new HashMap<String, Object>();
		int hintId = 0;
		int inpatientId = 0;
		session = request.getSession();
		if (request.getParameter(INPATIENT_ID) != null
				&& !(request.getParameter(INPATIENT_ID).equals(""))) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals(""))) {
			hintId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		List<EmpAfmsfDet> empAfmsfDetList = new ArrayList<EmpAfmsfDet>();
		map = misHandlerService.showBirth(inpatientId);
		if (map.get("empAfmsfDetList") != null) {
			empAfmsfDetList = (List<EmpAfmsfDet>) map.get("empAfmsfDetList");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String year = date.substring(date.lastIndexOf("/") + 1);
		Map<String, Object> regMap = new HashMap<String, Object>();
		regMap.put("year", year);
		regMap.put("bOrD", "birth");
		String regNo = "";
		int serNo = 0;
		if (empAfmsfDetList.size() == 0) {
			// ------------------- don't delete this for Birth Auto generation

			// tempMap = misHandlerService.generateRegNumber(regMap);
			// if(tempMap.get("regNo") !=null){
			// regNo =""+tempMap.get("regNo");
			// }
			// if(tempMap.get("serNo") !=null){
			// serNo =Integer.parseInt(""+tempMap.get("serNo"));
			// }
		} else {
			message = "Already added";
		}
		jsp = BIRTH;
		map.put("contentJsp", jsp);
		map.put("regNo", regNo);
		map.put("serNo", serNo);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitBirthCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Birthdeathreg birthdeathreg = new Birthdeathreg();
		session = request.getSession();
		String regNo = "";
		int inpatientId = 0;
		String hintNo = "";
		String patientName = "";
		String motherName = "";
		String fatherName = "";
		int sexId = 0;
		Date dob = new Date();
		Date dor = new Date();
		String lastChgBy = "";
		String lastChgTime = "";
		int noOfCopies = 0;
		int amount = 0;
		Date lastChgDate = new Date();
		int hintId = 0;
		int employeeId = 0;

		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter(INPATIENT_ID) != null) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		if (request.getParameter(PATIENT_NAME) != null) {
			patientName = request.getParameter(PATIENT_NAME);
		}
		String address="";
		if (request.getParameter(ADDRESS) != null
				&& !(request.getParameter(ADDRESS).equals(""))) {
			address = request.getParameter(ADDRESS);
		}
		if (request.getParameter(MOTHER_NAME) != null) {
			motherName = request.getParameter(MOTHER_NAME);
		}
		if (request.getParameter(FATHER_NAME) != null) {
			fatherName = request.getParameter(FATHER_NAME);
		}
		/*if (request.getParameter(DATE_OF_BIRTH) != null
				&& !(request.getParameter(DATE_OF_BIRTH).equals(""))) {
			dob = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DATE_OF_BIRTH));
		}*/
		if (request.getParameter(REG_DATE) != null
				&& !(request.getParameter(REG_DATE).equals(""))) {
			dor = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(REG_DATE));
		}
		if (request.getParameter(REG_NO) != null) {
			regNo = request.getParameter(REG_NO);
			birthdeathreg.setRegno(regNo);
		}
		String birthCirtificateNo="";
		if (request.getParameter(BIRTH_CERTIFICATE_NO) != null) {
			birthCirtificateNo = request.getParameter(BIRTH_CERTIFICATE_NO);
			birthdeathreg.setBirthCertificateNo(Integer.parseInt(birthCirtificateNo));
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			lastChgBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			lastChgDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			lastChgTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hintNo = request.getParameter(HIN_NO);
		}
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals(""))) {
			hintId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter(SEX_ID) != null
				&& !(request.getParameter(SEX_ID).equals(""))) {
			sexId = Integer.parseInt(request.getParameter(SEX_ID));
		}
		/*if (request.getParameter("serNo") != null
				&& !(request.getParameter("serNo").equals(""))) {
			serNo = Integer.parseInt(request.getParameter("serNo"));
		}*/
		/*if (request.getParameter(EMPLOYEE_ID) != null
				&& !(request.getParameter(EMPLOYEE_ID).equals(""))) {
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}*/
		if (request.getParameter(NO_OF_COPIES) != null
				&& !request.getParameter(NO_OF_COPIES).equals("")) {
			noOfCopies = Integer.parseInt(""
					+ request.getParameter(NO_OF_COPIES));
		}
		if (request.getParameter(AMOUNT) != null
				&& !request.getParameter(AMOUNT).equals("")) {
			amount = Integer.parseInt("" + request.getParameter(AMOUNT));
		}
		String time = "";
		if (request.getParameter(TIME) != null
				&& !request.getParameter(TIME).equals("")) {
			time = ("" + request.getParameter(TIME));
			birthdeathreg.setTime(time);
		}
		//------------------------
		String antenatalCheckup="";
		if (request.getParameter(ANTENATAL_CHECKUP) != null
				&& !(request.getParameter(ANTENATAL_CHECKUP).equals(""))) {
			antenatalCheckup = request.getParameter(ANTENATAL_CHECKUP);
			birthdeathreg.setAntenatalCheckup(antenatalCheckup);
		}
		String motherIpdDate="";
		if (request.getParameter(MOTHER_IPD_DATE) != null
				&& !(request.getParameter(MOTHER_IPD_DATE).equals(""))) {
			motherIpdDate = request.getParameter(MOTHER_IPD_DATE);
			birthdeathreg.setDateOfAdmOfMother(HMSUtil.dateFormatterDDMMYYYY(motherIpdDate));
		}
		String birthDateId="";
		if (request.getParameter(DATE_OF_BIRTH) != null
				&& !(request.getParameter(DATE_OF_BIRTH).equals(""))) {
			birthDateId = request.getParameter(DATE_OF_BIRTH);
			birthdeathreg.setBabyDeliveryDate(HMSUtil.dateFormatterDDMMYYYY(birthDateId));
		}
		String timeOfBirth="";
		if (request.getParameter(TIME_OF_BIRTH) != null
				&& !(request.getParameter(TIME_OF_BIRTH).equals(""))) {
			timeOfBirth = request.getParameter(TIME_OF_BIRTH);
			birthdeathreg.setBabyDeliveryTime(timeOfBirth);
		}
		String deliveryType="";
		if (request.getParameter(DELIVERY_TYPE) != null
				&& !(request.getParameter(DELIVERY_TYPE).equals(""))) {
			deliveryType = request.getParameter(DELIVERY_TYPE);
			birthdeathreg.setDeliveryType(deliveryType);
		}
		String babyStatus="";
		if (request.getParameter(BABY_STATUS) != null
				&& !(request.getParameter(BABY_STATUS).equals(""))) {
			babyStatus = request.getParameter(BABY_STATUS);
			birthdeathreg.setBabyStatus(babyStatus);
		}
		String cry="";
		if (request.getParameter(CRY) != null
				&& !(request.getParameter(CRY).equals(""))) {
			cry = request.getParameter(CRY);
			birthdeathreg.setCry(cry);
		}
		String babyColor="";
		if (request.getParameter(BABY_COLOR) != null
				&& !(request.getParameter(BABY_COLOR).equals(""))) {
			babyColor = request.getParameter(BABY_COLOR);
			birthdeathreg.setColor(babyColor);
		}
		String resuscitatino="";
		if (request.getParameter(RESUSCITATINO) != null
				&& !(request.getParameter(RESUSCITATINO).equals(""))) {
			resuscitatino = request.getParameter(RESUSCITATINO);
			birthdeathreg.setResuscitatino(resuscitatino);
		}
		String anyCongAbnormality="";
		if (request.getParameter(ANY_CONG_ABNORMALITY) != null
				&& !(request.getParameter(ANY_CONG_ABNORMALITY).equals(""))) {
			anyCongAbnormality = request.getParameter(ANY_CONG_ABNORMALITY);
			birthdeathreg.setAnyCongAbnormality(anyCongAbnormality);
		}

		String apgarScoreAtBirth="";
		if (request.getParameter(APGAR_ACORE_AT_BIRTH) != null
				&& !(request.getParameter(APGAR_ACORE_AT_BIRTH).equals(""))) {
			apgarScoreAtBirth = request.getParameter(APGAR_ACORE_AT_BIRTH);
			birthdeathreg.setApgarScoreAtBirth(apgarScoreAtBirth);
		}
		String birthWeight="";
		if (request.getParameter(BIRTH_WEIGHT) != null
				&& !(request.getParameter(BIRTH_WEIGHT).equals(""))) {
			birthWeight = request.getParameter(BIRTH_WEIGHT);
		//	birthdeathreg.setBirthWeight(Integer.parseInt( birthWeight));
		}
		String finalDiagnosis="";
		if (request.getParameter(FINAL_DIAGNOSIS) != null
				&& !(request.getParameter(FINAL_DIAGNOSIS).equals(""))) {
			finalDiagnosis = request.getParameter(FINAL_DIAGNOSIS);
			birthdeathreg.setFinalDiagnosis(finalDiagnosis);
		}
		String dischargeDate="";
		if (request.getParameter(DISCHARGE_DATE) != null
				&& !(request.getParameter(DISCHARGE_DATE).equals(""))) {
			dischargeDate = request.getParameter(DISCHARGE_DATE);
			birthdeathreg.setDischargeDate(HMSUtil.dateFormatterDDMMYYYY(dischargeDate));
		}
		String conditionAtDischarge="";
		if (request.getParameter(CONDITION_AT_DISCHARGE) != null
				&& !(request.getParameter(CONDITION_AT_DISCHARGE).equals(""))) {
			conditionAtDischarge = request.getParameter(CONDITION_AT_DISCHARGE);
			birthdeathreg.setConditionAtdischarge(conditionAtDischarge);
		}
		birthdeathreg.setBdtype("b");
		birthdeathreg.setDob(dob);
		birthdeathreg.setDor(dor);
		birthdeathreg.setName(patientName);
		birthdeathreg.setFname(fatherName);
		birthdeathreg.setMname(motherName);
		birthdeathreg.setRegno(birthCirtificateNo);
	//	birthdeathreg.setLastChgBy(lastChgBy);
		birthdeathreg.setDateOfIssue(lastChgDate);
		birthdeathreg.setLastChgDate(lastChgDate);
		birthdeathreg.setLastChgTime(lastChgTime);
		birthdeathreg.setAmount(amount);
		birthdeathreg.setNoOfCopies(noOfCopies);
		birthdeathreg.setTime(time);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		birthdeathreg.setHospital(masHospital);
		if (employeeId != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			birthdeathreg.setEmp(masEmployee);
		}

		Inpatient inpatient = new Inpatient();
		inpatient.setId(inpatientId);
		birthdeathreg.setInpatient(inpatient);

		Patient patient = new Patient();
		patient.setHinNo(hintNo);
		patient.setId(hintId);
		birthdeathreg.setHin(patient);
		birthdeathreg.setAddressPermanent(address);
		MasAdministrativeSex masAdministrativeSex1 = new MasAdministrativeSex();
		masAdministrativeSex1.setId(sexId);
		birthdeathreg.setAdministrativeSex(masAdministrativeSex1);

		generalMap.put("birthdeathreg",birthdeathreg);
		/*
		generalMap.put("time", time);
		generalMap.put("serNo", serNo);
		generalMap.put("noOfCopies", noOfCopies);
		generalMap.put("amount", amount);
		generalMap.put("patientName", patientName);
		generalMap.put("motherName", motherName);
		generalMap.put("fatherName", fatherName);
		//generalMap.put("gender", gender);
		generalMap.put("regNo", regNo);
		generalMap.put("dob", dob);
		generalMap.put("dor", dor);
		generalMap.put("gender", gender);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("lastChgBy", lastChgBy);
		generalMap.put("currentDate", lastChgDate);
		generalMap.put("currentTime", lastChgTime);
		generalMap.put("hintNo", hintNo);
		generalMap.put("hintId", hintId);
		generalMap.put("sexId", sexId);
		generalMap.put("employeeId", employeeId);*/
		generalMap.put("inpatientId", inpatientId);
		String message;
		String messageType = "";
		generalMap = misHandlerService.addBirthCertificate(generalMap);
		message = (String) generalMap.get("isRecordAlreadyExists");
		messageType = (String) generalMap.get("messageType");
		jsp = MESSAGE_FOR_MIS_JSP;
		title = "Add birthCertificate";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("flag", "birth");
		map.put("message", message);
		map.put("messageType", messageType);
		map.put("inpatientId", inpatientId);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getMotherAdmissionNumberList(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
			detailsMap.put("serviceNo", serviceNo);
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			detailsMap.put("hinNo", hinNo);
		}
		List<Object> admissionNoList = new ArrayList<Object>();
		List<Object> motherHinList = new ArrayList<Object>();
		String flag = "";
		String fatalCase = "";

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}
		if (request.getParameter("fatalCase") != null) {
			fatalCase = request.getParameter("fatalCase");
			map.put("fatalCase", fatalCase);
		}
		if (flag.equals("admission")) {

			admissionNoList = misHandlerService.getAdmissionNoList(detailsMap);
			map.put("admissionNoList", admissionNoList);
			jsp = MIS_RESPONSE_FOR_ADNO_BIRTH;
		} else if (flag.equals("hin")) {
			motherHinList = misHandlerService.getMotherHin(serviceNo);
			map.put("hinNoList", motherHinList);
			map.put("birthJsp", "birthJsp");
			jsp = MIS_RESPONSE_FOR_HIN_NO;
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView updateBirthCertificateJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = UPDATE_BIRTH_CERTIFICATE_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showUpdateBirthCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String birthCertificateNo = null;
		if (request.getParameter(BIRTH_CERTIFICATE_NO) != null) {
			birthCertificateNo = request.getParameter(BIRTH_CERTIFICATE_NO);
		}
		map.put("birthCertificateNo", birthCertificateNo);
		map = misHandlerService.showUpdateBirthCertificate(map);
		jsp = MIS_RESPONSE_FOR_UPDATE_BIRTH;
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView submitUpdateBirthCertificate(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int birthDeathId = 0;
		String patientName = "";
		String motherName = "";
		String fatherName = "";
		int inpatientId = 0;
		Date dor = new Date();
		String lastChgBy = "";
		String lastChgTime = "";
		Date lastChgDate = new Date();
		session = request.getSession();
		String addressDeath = "";
		String addressPermanent = "";
		String remarks = "";

		if (request.getParameter(PATIENT_NAME) != null) {
			patientName = request.getParameter(PATIENT_NAME);
		}
		if (request.getParameter(MOTHER_NAME) != null) {
			motherName = request.getParameter(MOTHER_NAME);
		}
		if (request.getParameter(FATHER_NAME) != null) {
			fatherName = request.getParameter(FATHER_NAME);
		}
		if (request.getParameter(REG_DATE) != null
				&& !(request.getParameter(REG_DATE).equals(""))) {
			dor = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(REG_DATE));
		}
		if (request.getParameter(BIRTHDEATHID) != null) {
			birthDeathId = Integer.parseInt(request.getParameter(BIRTHDEATHID));
		}
		if (request.getParameter(ADDRESS1) != null) {
			addressDeath = request.getParameter(ADDRESS1);
		}
		if (request.getParameter(ADDRESS) != null) {
			addressPermanent = request.getParameter(ADDRESS);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			lastChgBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			lastChgDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			lastChgTime = request.getParameter(CHANGED_TIME);
		}
		String time = "";
		if (request.getParameter(TIME_OF_BIRTH) != null
				&& !(request.getParameter(TIME_OF_BIRTH).equals(""))) {
			time = request.getParameter(TIME_OF_BIRTH);
		}

		int noOfCopies = 0;
		int amount = 0;
		if (request.getParameter(NO_OF_COPIES) != null
				&& !request.getParameter(NO_OF_COPIES).equals("")) {
			noOfCopies = Integer.parseInt(""
					+ request.getParameter(NO_OF_COPIES));
		}
		if (request.getParameter(AMOUNT) != null
				&& !request.getParameter(AMOUNT).equals("")) {
			amount = Integer.parseInt("" + request.getParameter(AMOUNT));
		}

		if (request.getParameter("ipId") != null) {
			inpatientId = Integer.parseInt("" + request.getParameter("ipId"));
		}
		//-----------------------
		// Date 24 Sep 2010 Code By Mukesh
		Birthdeathreg birthdeathregBackup=new Birthdeathreg();

		String antenatalCheckup="";
		if (request.getParameter(ANTENATAL_CHECKUP) != null
				&& !(request.getParameter(ANTENATAL_CHECKUP).equals(""))) {
			antenatalCheckup = request.getParameter(ANTENATAL_CHECKUP);
			birthdeathregBackup.setAntenatalCheckup(antenatalCheckup);
		}
		String motherIpdDate="";
		if (request.getParameter(MOTHER_IPD_DATE) != null
				&& !(request.getParameter(MOTHER_IPD_DATE).equals(""))) {
			motherIpdDate = request.getParameter(MOTHER_IPD_DATE);
			birthdeathregBackup.setDateOfAdmOfMother(HMSUtil.dateFormatterDDMMYYYY(motherIpdDate));
		}
		String birthDateId="";
		if (request.getParameter(DATE_OF_BIRTH) != null
				&& !(request.getParameter(DATE_OF_BIRTH).equals(""))) {
			birthDateId = request.getParameter(DATE_OF_BIRTH);
			birthdeathregBackup.setBabyDeliveryDate(HMSUtil.dateFormatterDDMMYYYY(birthDateId));
		}
		String timeOfBirth="";
		if (request.getParameter(TIME_OF_BIRTH) != null
				&& !(request.getParameter(TIME_OF_BIRTH).equals(""))) {
			timeOfBirth = request.getParameter(TIME_OF_BIRTH);
			birthdeathregBackup.setBabyDeliveryTime(timeOfBirth);
		}
		String deliveryType="";
		if (request.getParameter(DELIVERY_TYPE) != null
				&& !(request.getParameter(DELIVERY_TYPE).equals(""))) {
			deliveryType = request.getParameter(DELIVERY_TYPE);
			birthdeathregBackup.setDeliveryType(deliveryType);
		}
		String babyStatus="";
		if (request.getParameter(BABY_STATUS) != null
				&& !(request.getParameter(BABY_STATUS).equals(""))) {
			babyStatus = request.getParameter(BABY_STATUS);
			birthdeathregBackup.setBabyStatus(babyStatus);
		}
		String cry="";
		if (request.getParameter(CRY) != null
				&& !(request.getParameter(CRY).equals(""))) {
			cry = request.getParameter(CRY);
			birthdeathregBackup.setCry(cry);
		}
		String babyColor="";
		if (request.getParameter(BABY_COLOR) != null
				&& !(request.getParameter(BABY_COLOR).equals(""))) {
			babyColor = request.getParameter(BABY_COLOR);
			birthdeathregBackup.setColor(babyColor);
		}
		String resuscitatino="";
		if (request.getParameter(RESUSCITATINO) != null
				&& !(request.getParameter(RESUSCITATINO).equals(""))) {
			resuscitatino = request.getParameter(RESUSCITATINO);
			birthdeathregBackup.setResuscitatino(resuscitatino);
		}
		String anyCongAbnormality="";
		if (request.getParameter(ANY_CONG_ABNORMALITY) != null
				&& !(request.getParameter(ANY_CONG_ABNORMALITY).equals(""))) {
			anyCongAbnormality = request.getParameter(ANY_CONG_ABNORMALITY);
			birthdeathregBackup.setAnyCongAbnormality(anyCongAbnormality);
		}

		String apgarScoreAtBirth="";
		if (request.getParameter(APGAR_ACORE_AT_BIRTH) != null
				&& !(request.getParameter(APGAR_ACORE_AT_BIRTH).equals(""))) {
			apgarScoreAtBirth = request.getParameter(APGAR_ACORE_AT_BIRTH);
			birthdeathregBackup.setApgarScoreAtBirth(apgarScoreAtBirth);
		}
		String birthWeight="";
		if (request.getParameter(BIRTH_WEIGHT) != null
				&& !(request.getParameter(BIRTH_WEIGHT).equals(""))) {
			birthWeight = request.getParameter(BIRTH_WEIGHT);
	//		birthdeathregBackup.setBirthWeight(Integer.parseInt( birthWeight));
		}
		String finalDiagnosis="";
		if (request.getParameter(FINAL_DIAGNOSIS) != null
				&& !(request.getParameter(FINAL_DIAGNOSIS).equals(""))) {
			finalDiagnosis = request.getParameter(FINAL_DIAGNOSIS);
			birthdeathregBackup.setFinalDiagnosis(finalDiagnosis);
		}
		String dischargeDate="";
		if (request.getParameter(DISCHARGE_DATE) != null
				&& !(request.getParameter(DISCHARGE_DATE).equals(""))) {
			dischargeDate = request.getParameter(DISCHARGE_DATE);
			birthdeathregBackup.setDischargeDate(HMSUtil.dateFormatterDDMMYYYY(dischargeDate));
		}
		String conditionAtDischarge="";
		if (request.getParameter(CONDITION_AT_DISCHARGE) != null
				&& !(request.getParameter(CONDITION_AT_DISCHARGE).equals(""))) {
			conditionAtDischarge = request.getParameter(CONDITION_AT_DISCHARGE);
			birthdeathregBackup.setConditionAtdischarge(conditionAtDischarge);
		}

		generalMap.put("birthdeathregBackup", birthdeathregBackup);

		generalMap.put("time", time);

		generalMap.put("amount", amount);
		generalMap.put("noOfCopies", noOfCopies);
		generalMap.put("patientName", patientName);
		generalMap.put("motherName", motherName);
		generalMap.put("fatherName", fatherName);
		generalMap.put("remarks", remarks);
		generalMap.put("dor", dor);
		generalMap.put("lastChgBy", lastChgBy);
		generalMap.put("currentDate", lastChgDate);
		generalMap.put("currentTime", lastChgTime);
		generalMap.put("birthDeathId", birthDeathId);
		generalMap.put("addressDeath", addressDeath);
		generalMap.put("addressPermanent", addressPermanent);
		String message;

		boolean dataUpdated = false;
		dataUpdated = misHandlerService
				.submitUpdateBirthCertificate(generalMap);
		String messageType = "";
		if (dataUpdated == true) {
			messageType = "success";
			message = "Updated Birth Certificate  Successfully";
			map.put("flag", "birth");
			map.put("inpatientId", inpatientId);

		} else {
			messageType = "failure";
			message = "Data not Saved";

		}
		map.put("message", message);
		jsp = MESSAGE_FOR_MIS_JSP;
		title = "Update Birth Cerificate";
		jsp += ".jsp";
		map.put("message", message);
		map.put("messageType", messageType);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);

		return new ModelAndView("index", "map", map);
	}

	// ----------------------------Death
	// Certificate----------------------------------------
	public ModelAndView showDeathCertificateJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = misHandlerService.showDeathCertificateJsp();
		String jsp = DEATH_CERTIFICATE;
		jsp += ".jsp";
		title = "death Certificate";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getExpiredAdmissionNumberList(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
			detailsMap.put("serviceNo", serviceNo);
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			detailsMap.put("hinNo", hinNo);
		}
		List<Object> admissionNoList = new ArrayList<Object>();
		List<Object> expiredHinNo = new ArrayList<Object>();
		String flag = "";
		String fatalCase = "";

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}
		if (request.getParameter("fatalCase") != null) {
			fatalCase = request.getParameter("fatalCase");
			map.put("fatalCase", fatalCase);
		}
		if (flag.equals("admission")) {
			admissionNoList = misHandlerService
					.getExpiredAdmissionNumberList(detailsMap);
			map.put("admissionNoList", admissionNoList);
			jsp = MIS_RESPONSE_FOR_ADNO_DEATH;
		} else if (flag.equals("hin")) {
			expiredHinNo = misHandlerService.getExpiredHin(hinNo);
			map.put("hinNoList", expiredHinNo);
			map.put("deathJsp", "deathJsp");
			jsp = MIS_RESPONSE_FOR_HIN_NO;
		}

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showDeath(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> tempMap = new HashMap<String, Object>();
		int hintId = 0;
		int inpatientId = 0;
		List<EmpAfmsfDet> empAfmsfDetList = new ArrayList<EmpAfmsfDet>();
		session = request.getSession();
		if (request.getParameter(INPATIENT_ID) != null
				&& !(request.getParameter(INPATIENT_ID).equals(""))) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals(""))) {
			hintId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		map = misHandlerService.showDeath(inpatientId);
		if (map.get("empAfmsfDetList") != null) {
			empAfmsfDetList = (List<EmpAfmsfDet>) map.get("empAfmsfDetList");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String year = date.substring(date.lastIndexOf("/") + 1);
		Map<String, Object> regMap = new HashMap<String, Object>();
		regMap.put("year", year);
		regMap.put("bOrD", "death");
		String regNo = "";
		int serNo = 0;
		if (empAfmsfDetList.size() == 0) {
			// tempMap = misHandlerService.generateRegNumber(regMap);
			// if(tempMap.get("regNo") !=null){
			// regNo =""+tempMap.get("regNo");
			// }
			// if(tempMap.get("serNo") !=null){
			// serNo =Integer.parseInt(""+tempMap.get("serNo"));
			// }
		}
		if (regNo != null) {
			map.put("regNo", regNo);
		}
		jsp = DEATH;
		map.put("contentJsp", jsp);
		map.put("regNo", regNo);
		map.put("serNo", serNo);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitDeathCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Birthdeathreg birthdeathreg = new Birthdeathreg();
		String patientName = "";
		String motherName = "";
		String fatherName = "";
		int inpatientId = 0;
		String hintNo = "";
		int sexId = 0;
		Date dod = new Date();
		Date dor = new Date();
		//String gender = "";
		String lastChgBy = "";
		String lastChgTime = "";
		Date lastChgDate = new Date();
		session = request.getSession();
		/*String addressDeath = "";
		String addressPermanent = "";
		String remarks = "";
		Date issueDate = new Date();*/
		int hintId = 0;
		int employeeId = 0;
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		/*if (request.getParameter(REG_NO) != null) {
			regNo = request.getParameter(REG_NO);
		}*/
		if (request.getParameter(INPATIENT_ID) != null) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		if (request.getParameter(PATIENT_NAME) != null) {
			patientName = request.getParameter(PATIENT_NAME);
		}
		if (request.getParameter(MOTHER_NAME) != null) {
			motherName = request.getParameter(MOTHER_NAME);
		}
		if (request.getParameter(FATHER_NAME) != null) {
			fatherName = request.getParameter(FATHER_NAME);
		}
		if (request.getParameter(DATE_OF_DEATH) != null
				&& !(request.getParameter(DATE_OF_DEATH).equals(""))) {
			dod = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DATE_OF_DEATH));
		}
		if (request.getParameter(REG_DATE) != null
				&& !(request.getParameter(REG_DATE).equals(""))) {
			dor = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(REG_DATE));
		}
		/*if (request.getParameter(ADDRESS1) != null) {
			addressDeath = request.getParameter(ADDRESS1);
		}
		if (request.getParameter(ADDRESS2) != null) {
			addressPermanent = request.getParameter(ADDRESS2);
		}
		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
		}*/
		/*if (request.getParameter(ISSUE_DATE) != null
				&& !(request.getParameter(ISSUE_DATE).equals(""))) {
			issueDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(ISSUE_DATE));
		}*/
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			lastChgBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			lastChgDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			lastChgTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hintNo = request.getParameter(HIN_NO);
		}
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals(""))) {
			hintId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter(SEX_ID) != null
				&& !(request.getParameter(SEX_ID).equals(""))) {
			sexId = Integer.parseInt(request.getParameter(SEX_ID));
		}
		if (request.getParameter(EMPLOYEE_ID) != null
				&& !(request.getParameter(EMPLOYEE_ID).equals(""))) {
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		int noOfCopies = 0;
		int amount = 0;
		if (request.getParameter(NO_OF_COPIES) != null
				&& !(request.getParameter(NO_OF_COPIES).equals(""))) {
			noOfCopies = Integer.parseInt(request.getParameter(NO_OF_COPIES));
		}
		if (request.getParameter(AMOUNT) != null
				&& !(request.getParameter(AMOUNT).equals(""))) {
			amount = Integer.parseInt(request.getParameter(AMOUNT));
		}
		String time = "";
		if (request.getParameter(TIME) != null
				&& !(request.getParameter(TIME).equals(""))) {
			time = (request.getParameter(TIME).trim());
		}
		if (request.getParameter(TIME_AM) != null
				&& !(request.getParameter(TIME_AM).equals(""))) {
			time +=" "+ (request.getParameter(TIME_AM));
		}
		String birthCirtificateNo="";
		if (request.getParameter(BIRTH_CERTIFICATE_NO) != null) {
			birthCirtificateNo = request.getParameter(BIRTH_CERTIFICATE_NO);
			birthdeathreg.setBirthCertificateNo(Integer.parseInt(birthCirtificateNo));
		}
		String immediateCause="";
		if (request.getParameter(IMMEDIATE_CAUSE) != null) {
			immediateCause = request.getParameter(IMMEDIATE_CAUSE).trim();
			birthdeathreg.setImmediateCause(immediateCause);
		}
		String antecedentCause="";
		if (request.getParameter(ANTECEDENT_CAUSE) != null) {
			antecedentCause = request.getParameter(ANTECEDENT_CAUSE).trim();
			birthdeathreg.setAntecedentCause(antecedentCause);
		}
		String otherSignificantCondition="";
		if (request.getParameter(OTHER_SIGNIFICANT_CONDITION) != null) {
			otherSignificantCondition = request.getParameter(OTHER_SIGNIFICANT_CONDITION).trim();
			birthdeathreg.setOtherSignificantCondition(otherSignificantCondition);
		}
		String deliveryType="";
		if (request.getParameter(MANNER_OF_DEATH) != null) {
			deliveryType = request.getParameter(MANNER_OF_DEATH).trim();
			/*
			 * if bdType=d then delivery type = death type
			 * if bdType=b then delivery type = delivery type
			 * code by mukesh 28 sep 2010
			 */
			birthdeathreg.setDeliveryType(deliveryType);
		}
		String injuryOccur="";
		if (request.getParameter(INJURY_OCCUR) != null) {
			injuryOccur = request.getParameter(INJURY_OCCUR).trim();
			birthdeathreg.setInjuryOccur(injuryOccur);
		}
		String deceasedFemalePregnancyDelivery="";
		if (request.getParameter(DECEASED_FEMALE_PREGNANCY_DELIVERY) != null) {
			deceasedFemalePregnancyDelivery = request.getParameter(DECEASED_FEMALE_PREGNANCY_DELIVERY).trim();
			birthdeathreg.setDeceasedFemalePregnancyDelivery(deceasedFemalePregnancyDelivery);
		}
		String deceasedFemalePregnancyDeath="";
		if (request.getParameter(DECEASED_FEMALE_PREGNANCY_DEATH) != null) {
			deceasedFemalePregnancyDeath = request.getParameter(DECEASED_FEMALE_PREGNANCY_DEATH).trim();
			birthdeathreg.setDeceasedFemalePregnancyDeath(deceasedFemalePregnancyDeath);
		}
		birthdeathreg.setRemarks("");
		birthdeathreg.setBdtype("d");
		birthdeathreg.setDob(dod);
		birthdeathreg.setDor(dor);
		birthdeathreg.setName(patientName);
		birthdeathreg.setFname(fatherName);
		birthdeathreg.setMname(motherName);
		birthdeathreg.setDateOfIssue(lastChgDate);
//		birthdeathreg.setLastChgBy(lastChgBy);
		birthdeathreg.setLastChgDate(lastChgDate);
		birthdeathreg.setLastChgTime(lastChgTime);
		birthdeathreg.setAmount(amount);
		birthdeathreg.setNoOfCopies(noOfCopies);
		birthdeathreg.setTime(lastChgTime);
		birthdeathreg.setBabyDeliveryTime(time);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		birthdeathreg.setHospital(masHospital);
		if (employeeId != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			birthdeathreg.setEmp(masEmployee);
		}

		Inpatient inpatient = new Inpatient();
		inpatient.setId(inpatientId);
		birthdeathreg.setInpatient(inpatient);

		Patient patient = new Patient();
		patient.setHinNo(hintNo);
		patient.setId(hintId);
		birthdeathreg.setHin(patient);
		//birthdeathreg.setAddressPermanent(address);
		MasAdministrativeSex masAdministrativeSex1 = new MasAdministrativeSex();
		masAdministrativeSex1.setId(sexId);
		birthdeathreg.setAdministrativeSex(masAdministrativeSex1);

		generalMap.put("birthdeathreg",birthdeathreg);








		generalMap.put("inpatientId", inpatientId);
		/*generalMap.put("time", time);
		generalMap.put("serNo", serNo);
		generalMap.put("noOfCopies", noOfCopies);
		generalMap.put("amount", amount);
		generalMap.put("patientName", patientName);
		generalMap.put("motherName", motherName);
		generalMap.put("fatherName", fatherName);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("dod", dod);
		generalMap.put("gender", gender);
		generalMap.put("regNo", regNo);
		generalMap.put("addressDeath", addressDeath);
		generalMap.put("addressPermanent", addressPermanent);
		generalMap.put("remarks", remarks);
		generalMap.put("issueDate", issueDate);
		generalMap.put("dor", dor);
		generalMap.put("lastChgBy", lastChgBy);
		generalMap.put("currentDate", lastChgDate);
		generalMap.put("currentTime", lastChgTime);
		generalMap.put("hintNo", hintNo);
		generalMap.put("hintId", hintId);
		generalMap.put("sexId", sexId);
		generalMap.put("employeeId", employeeId);
		String message;
		*/
		String messageType = "";
		generalMap = misHandlerService.addDeathCertificate(generalMap);
		message = (String) generalMap.get("isRecordAlreadyExists");
		messageType = (String) generalMap.get("messageType");
		jsp = MESSAGE_FOR_MIS_JSP;
		title = "Add deathCertificate";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("flag", "death");
		map.put("message", message);
		map.put("messageType", messageType);
		map.put("inpatientId", inpatientId);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showUpdateDeathCertificateJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = UPDATE_DEATH_CERTIFICATE_JSP + ".jsp";
		// map = misHandlerService.showUpdateBirthCertificate(map);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showUpdateDeathCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String regNo = null;
		//int inpatientId = 0;
		if (request.getParameter(BIRTH_CERTIFICATE_NO) != null) {
			regNo = request.getParameter(BIRTH_CERTIFICATE_NO);
		}
		map.put("regNo", regNo);
		map = misHandlerService.showUpdateDeathCertificate(map);
		jsp = MIS_RESPONSE_FOR_UPDATE_DEATH;
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView submitUpdateDeathCertificate(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int birthDeathId = 0;
		String patientName = "";
		/*String motherName = "";
		String fatherName = "";*/
		int inpatientId = 0;
		Date dod = new Date();
		//Date dor = new Date();
		String lastChgBy = "";
		String lastChgTime = "";
		Date lastChgDate = new Date();
		session = request.getSession();
		/*String addressDeath = "";
		String addressPermanent = "";
		String remarks = "";*/
		String time = "";
		if (request.getParameter(TIME) != null
				&& !(request.getParameter(TIME).equals(""))) {
			time = (request.getParameter(TIME).trim());
		}
		if (request.getParameter(TIME_AM) != null
				&& !(request.getParameter(TIME_AM).equals(""))) {
			time +=" "+ (request.getParameter(TIME_AM));
		}
		if (request.getParameter(PATIENT_NAME) != null) {
			patientName = request.getParameter(PATIENT_NAME);
		}
		/*if (request.getParameter(MOTHER_NAME) != null) {
			motherName = request.getParameter(MOTHER_NAME);
		}
		if (request.getParameter(FATHER_NAME) != null) {
			fatherName = request.getParameter(FATHER_NAME);
		}
		if (request.getParameter(REG_DATE) != null
				&& !(request.getParameter(REG_DATE).equals(""))) {
			dor = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(REG_DATE));
		}*/
		if (request.getParameter(BIRTHDEATHID) != null) {
			birthDeathId = Integer.parseInt(request.getParameter(BIRTHDEATHID));
		}
		/*if (request.getParameter(ADDRESS1) != null) {
			addressDeath = request.getParameter(ADDRESS1);
		}
		if (request.getParameter(ADDRESS2) != null) {
			addressPermanent = request.getParameter(ADDRESS2);
		}*/
		if (request.getParameter(DATE_OF_DEATH) != null
				&& !(request.getParameter(DATE_OF_DEATH).equals(""))) {
			dod = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DATE_OF_DEATH));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			lastChgBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			lastChgDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			lastChgTime = request.getParameter(CHANGED_TIME);
		}
		/*int amount = 0;
		int noOfCopies = 0;
		if (request.getParameter(AMOUNT) != null) {
			amount = Integer.parseInt(request.getParameter(AMOUNT));
		}
		if (request.getParameter(NO_OF_COPIES) != null) {
			noOfCopies = Integer.parseInt(request.getParameter(NO_OF_COPIES));
		}*/

		if (request.getParameter("ipId") != null) {
			inpatientId = Integer.parseInt(request.getParameter("ipId"));
		}
		String immediateCause="";
		String antecedentCause="";
		String otherSignificantCondition="";
		String deliveryType="";
		String injuryOccur="";
		String deceasedFemalePregnancyDelivery="";
		String deceasedFemalePregnancyDeath="";
		if (request.getParameter(IMMEDIATE_CAUSE) != null) {
			immediateCause = request.getParameter(IMMEDIATE_CAUSE).trim();
		}
		if (request.getParameter(ANTECEDENT_CAUSE) != null) {
			antecedentCause = request.getParameter(ANTECEDENT_CAUSE).trim();
		}
		if (request.getParameter(OTHER_SIGNIFICANT_CONDITION) != null) {
			otherSignificantCondition = request.getParameter(OTHER_SIGNIFICANT_CONDITION).trim();
		}
		if (request.getParameter(MANNER_OF_DEATH) != null) {
			deliveryType = request.getParameter(MANNER_OF_DEATH).trim();
			/*
			 * if bdType=d then delivery type = death type
			 * if bdType=b then delivery type = delivery type
			 * code by mukesh 28 sep 2010
			 */
		}
		if (request.getParameter(INJURY_OCCUR) != null) {
			injuryOccur = request.getParameter(INJURY_OCCUR).trim();
		}
		if (request.getParameter(DECEASED_FEMALE_PREGNANCY_DELIVERY) != null) {
			deceasedFemalePregnancyDelivery = request.getParameter(DECEASED_FEMALE_PREGNANCY_DELIVERY).trim();
		}
		if (request.getParameter(DECEASED_FEMALE_PREGNANCY_DEATH) != null) {
			deceasedFemalePregnancyDeath = request.getParameter(DECEASED_FEMALE_PREGNANCY_DEATH).trim();
		}
		generalMap.put("immediateCause", immediateCause);
		generalMap.put("antecedentCause", antecedentCause);
		generalMap.put("otherSignificantCondition", otherSignificantCondition);
		generalMap.put("deliveryType", deliveryType);
		generalMap.put("injuryOccur", injuryOccur);
		generalMap.put("deceasedFemalePregnancyDelivery", deceasedFemalePregnancyDelivery);
		generalMap.put("deceasedFemalePregnancyDeath", deceasedFemalePregnancyDeath);

		/*generalMap.put("inpatientId", inpatientId);
		generalMap.put("noOfCopies", noOfCopies);*/
		generalMap.put("time", time);
		generalMap.put("patientName", patientName);
		/*generalMap.put("motherName", motherName);
		generalMap.put("fatherName", fatherName);
		generalMap.put("remarks", remarks);
		generalMap.put("dor", dor);*/
		generalMap.put("dod", dod);
		generalMap.put("lastChgBy", lastChgBy);
		generalMap.put("currentDate", lastChgDate);
		generalMap.put("currentTime", lastChgTime);
		generalMap.put("birthDeathId", birthDeathId);
		/*generalMap.put("addressDeath", addressDeath);
		generalMap.put("addressPermanent", addressPermanent);*/
		String message;

		boolean dataUpdated = false;

		dataUpdated = misHandlerService
				.submitUpdateDeathCertificate(generalMap);
		String messageType = "";
		if (dataUpdated == true) {
			messageType = "success";
			message = "Updated Death Certificate Successfully";
			map.put("inpatientId", inpatientId);
			map.put("flag", "death");
		} else {
			messageType = "failure";
			message = "Data not Saved";

		}
		map.put("message", message);
		jsp = MESSAGE_FOR_MIS_JSP;
		title = "Update Birth Cerificate";
		jsp += ".jsp";
		map.put("messageType", messageType);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);

		return new ModelAndView("index", "map", map);
	}

	/**
	 * ------------------------ Birth/Death Certificate Report*
	 * --------------------------
	 */
	public ModelAndView showBirthDeathCertificateJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = BIRTH_DEATH_CERTIFICATE + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showBirthDeathCertificate2(HttpServletRequest request,
			HttpServletResponse response) {
		String flag = "";
		int inpatientId = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(AD_NO) != null) {
			inpatientId = Integer.parseInt(request.getParameter(AD_NO));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("inpatientId", inpatientId);

		try {
			if (flag.equals("birth")) {
				HMSUtil.generateReport("birth_certificate", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (flag.equals("death")) {
				HMSUtil.generateReport("death_certificate", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// =====================Added at bangalore===================
	public ModelAndView showDailyBedStats(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = null;
		session = request.getSession();
		// map = misHandlerService.showTotalAdmissionjsp();
		jsp = DAILY_BED_STATS;
		jsp += ".jsp";
		title = "Total Admission";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printDailyBedStats(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date toDate = null;
		Map<String, Object> parameters = new HashMap<String, Object>();
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		parameters.put("toDate", toDate);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = misHandlerService.getConnectionForReport();
		try {
			byte bytes[] = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("DailyBedStatus"), parameters,
						(Connection) detailsMap.get("conn"));
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

	public void checkRegNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String regNo = "";
		String exists = "no";
		String type = "";
		if (request.getParameter("regNo") != null) {
			regNo = (request.getParameter("regNo"));
		}
		if (request.getParameter("type") != null) {
			type = (request.getParameter("type"));
		}
		dataMap.put("regNo", regNo);
		dataMap.put("type", type);
		map = misHandlerService.chechBed(dataMap);
		if (map.get("exists") != null) {
			exists = "" + map.get("exists");
		}
		StringBuffer sb = new StringBuffer();

		sb.append("<item>");
		sb.append("<exists>" + exists + "</exists>");
		sb.append("</item>");

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

		// return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView printBirthDeathCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int ipId = 0;
		String flag = "";
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			ipId = Integer.parseInt("" + request.getParameter(FROM_DATE));
		}

		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		byte[] bytes = null;
		parameters.put("inpatientId", ipId);
		try {
			if (flag.equals("birth")) {

				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("birth_certificate"), parameters,
						(Connection) detailsMap.get("conn"));

			} else if (flag.equals("death")) {

				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("death_certificate"), parameters,
						(Connection) detailsMap.get("conn"));
			}

			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JRException e) {

			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printBDCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int inpatientId = 0;
		int dischargeId = 0;
		String bOrD = "";
		try {
			if (request.getParameter(AD_NO) != null) {
				inpatientId = Integer.parseInt(request.getParameter(AD_NO));
			}
			if (request.getParameter("selectedRadio") != null) {
				bOrD = (request.getParameter("selectedRadio"));
			}
			parameters.put("inpatientId", inpatientId);
			parameters.put("IMAGE_DIR", getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT", getServletContext().getRealPath("/jsp/images/svbLft.jpg"));

			detailsMap = misHandlerService.getConnectionForReport();

			if (bOrD.equalsIgnoreCase("birth")) {
				HMSUtil.generateReport("b_certificate", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (bOrD.equalsIgnoreCase("death")) {
				HMSUtil.generateReport("d_certificate", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView getHinAdNoDetailsFatalCase(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		int hinId = 0;
		try {
			if (request.getParameter(SERVICE_NO) != null) {
				serviceNo = request.getParameter(SERVICE_NO);
				detailsMap.put("serviceNo", serviceNo);
			}
			if (request.getParameter(HIN_ID) != null
					&& !request.getParameter(HIN_ID).equals("")) {

				hinId = Integer.parseInt("" + request.getParameter(HIN_ID));
				detailsMap.put("hinId", hinId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String flag = "";

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}
		if (flag.equals("admission")) {
			map = misHandlerService.getHinAdNoDetailsFatalCase(detailsMap);
			map.put("flag", flag);
			jsp = MIS_RESPONSE_FOR_FATAl_HIN_ADNO;
		} else if (flag.equals("hin")) {
			map = misHandlerService.getHinAdNoDetailsFatalCase(detailsMap);
			map.put("flag", flag);
			jsp = MIS_RESPONSE_FOR_FATAl_HIN_ADNO;
		}

		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unchecked")
	public void populateHinNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		List objectList = new ArrayList();
		String serviceNo = "";
		if (request.getParameter("serviceNo") != null) {
			serviceNo = (request.getParameter("serviceNo"));
		}
		dataMap.put("serviceNo", serviceNo);
		@SuppressWarnings("unused")
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		map = misHandlerService.populateHinNo(dataMap);
		inpatientList = (List) map.get("inpatientList");

		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<hinLists>");
		try {
			if (inpatientList.size() > 0) {
				// for(Inpatient inpatient :inpatientList){
				Inpatient inpatient = (Inpatient) inpatientList.get(0);
				sb.append("<hinList>");
				sb.append("<hinId>" + inpatient.getHin().getId() + "</hinId>");
				sb.append("<hinNo>" + inpatient.getHin().getHinNo()
						+ "</hinNo>");
				sb.append("</hinList>");
				// }
			} else {
				sb.append("<hinId>" + "no" + "</hinId>");
				sb.append("<hinNo>" + "no" + "</hinNo>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sb.append("</hinLists>");
		sb.append("</item>");
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

	@SuppressWarnings("unchecked")
	public void getFRWDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int hinId = 0;
		if (request.getParameter("hinId") != null) {
			hinId = Integer.parseInt("" + request.getParameter("hinId"));
		}
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		@SuppressWarnings("unused")
		List<MisFrw> misFrwList = new ArrayList<MisFrw>();
		dataMap.put("hinId", hinId);
		map = misHandlerService.getFRWDetails(dataMap);

		inpatientList = (List<Inpatient>) map.get("inpatientList");
		misFrwList = (List<MisFrw>) map.get("misFrwList");
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		for (Inpatient inpatient : inpatientList) {
			if (inpatient.getHin().getRank() != null) {
				sb.append("<rank>" + inpatient.getHin().getRank().getRankName()
						+ "</rank>");
			} else {
				sb.append("<rank>" + "-" + "</rank>");
			}

			sb.append("<pName>" + inpatient.getHin().getPFirstName() + " "
					+ inpatient.getHin().getPMiddleName() + " "
					+ inpatient.getHin().getPLastName() + "</pName>");
			if (inpatient.getHin().getTrade() != null) {
				sb.append("<trade>"
						+ inpatient.getHin().getTrade().getTradeName()
						+ "</trade>");
			} else {
				sb.append("<trade>" + "-" + "</trade>");
			}
			sb.append("<age>" + inpatient.getAge() + "</age>");
			if (inpatient.getHin().getSex() != null) {
				sb.append("<sex>"
						+ inpatient.getHin().getSex()
								.getAdministrativeSexName() + "</sex>");
			} else {
				sb.append("<sex>" + "-" + "</sex>");
			}
			if (inpatient.getHin().getUnit() != null) {
				sb.append("<unit>" + inpatient.getHin().getUnit().getUnitName()
						+ "</unit>");
			} else {
				sb.append("<unit>" + "-" + "</unit>");
			}
			sb.append("<hinId>" + inpatient.getHin().getId() + "</hinId>");
		}

		sb.append("</item>");
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

	public ModelAndView getHinAdNoFatalPanchanama(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		int hinId = 0;
		try {
			if (request.getParameter(SERVICE_NO) != null) {
				serviceNo = request.getParameter(SERVICE_NO);
				detailsMap.put("serviceNo", serviceNo);
			}
			if (request.getParameter(HIN_ID) != null
					&& !request.getParameter(HIN_ID).equals("")) {

				hinId = Integer.parseInt("" + request.getParameter(HIN_ID));
				detailsMap.put("hinId", hinId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String flag = "";

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}
		if (flag.equals("admission")) {
			map = misHandlerService.getHinAdNoFatalPanchanama(detailsMap);
			map.put("flag", flag);
			jsp = MIS_RESPONSE_FOR_FATAl_PANCHANAMA;
		} else if (flag.equals("hin")) {
			map = misHandlerService.getHinAdNoFatalPanchanama(detailsMap);
			map.put("flag", flag);
			jsp = MIS_RESPONSE_FOR_FATAl_PANCHANAMA;
		}

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getHinNoForDeficient(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		List objectList = new ArrayList();
		String serviceNo = "";
		String respForm = "";
		if (request.getParameter("serviceNo") != null) {
			serviceNo = (request.getParameter("serviceNo"));
		}
		if (request.getParameter("respForm") != null) {
			respForm = (request.getParameter("respForm"));
		}

		dataMap.put("serviceNo", serviceNo);
		dataMap.put("respForm", respForm);

		@SuppressWarnings("unused")
		List<Patient> patientList = new ArrayList<Patient>();
		map = misHandlerService.getHinNoForDeficient(dataMap);
		if (respForm != null) {
			if (respForm.equals("arrival")) {
				jsp = "responceForDeficient";
			} else if (respForm.equals("receipt")) {
				jsp = "responceForReceiptEntry";
			} else if (respForm.equals("clearance")) {
				jsp = "responceForClearanceForm";
			} else if (respForm.equals("dispatch")) {
				jsp = "responceForDispatchDetails";
			}
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getHinNoForSurplus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		List objectList = new ArrayList();
		String serviceNo = "";
		if (request.getParameter("serviceNo") != null) {
			serviceNo = (request.getParameter("serviceNo"));
		}
		dataMap.put("serviceNo", serviceNo);
		@SuppressWarnings("unused")
		List<Patient> patientList = new ArrayList<Patient>();
		map = misHandlerService.getHinNoForSurplus(dataMap);
		jsp = "responceForSurplus";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showReportForDocuments(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = misHandlerService.showFrwCases();
		jsp = REPORT_FOR_DOCUMENTS + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView primtReportForDocuments(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		try {
			if (request.getParameter(SERVICE_NO) != null) {
				serviceNo = (request.getParameter(SERVICE_NO));
			}
			parameters.put("serviceNo", serviceNo);
			detailsMap = misHandlerService.getConnectionForReport();
			HMSUtil.generateReport("receiptForDocuments", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printMisDailyReport(HttpServletRequest request,
			HttpServletResponse response) throws ParseException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Date toDate = null;
		Date toDate1 = null;
		int Dept_ID = 0;
		String date4MySQL = "";
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			date4MySQL = formatterOut.format(formatterIn.parse(request
					.getParameter(TO_DATE)));
			dataMap.put("Date", date4MySQL);
		}
		if (request.getParameter(DEPARTMENT_ID) != null
				&& !(request.getParameter(DEPARTMENT_ID).equals(""))) {
			Dept_ID = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
		}

		map = misHandlerService.getDBConnection();
		// dataMap.put("Date", toDate);
		dataMap.put("Dept_ID", Dept_ID);
		// parameters = misHandlerService.getTotalMisDailyReport(dataMap);
		parameters.put("toDate", toDate);
		parameters.put("Dept_ID", Dept_ID);
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));
		HMSUtil.generateReport("misDailyReport", parameters,
				(Connection) map.get("conn"), response, getServletContext());
		return null;
	}

	public ModelAndView showCommandentReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = COMMANDENT_REPORT + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printCommandentReport(HttpServletRequest request,
			HttpServletResponse response) throws ParseException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		Date toDate = null;
		int Dept_ID = 0;
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		map = misHandlerService.getDBConnection();
		parameters.put("toDate", toDate);
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));
		HMSUtil.generateReport("BedStatusReport", parameters,
				(Connection) map.get("conn"), response, getServletContext());
		return null;
	}

	public ModelAndView getHinAdNoForND(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		int hinId = 0;
		try {
			if (request.getParameter(SERVICE_NO) != null) {
				serviceNo = request.getParameter(SERVICE_NO);
				detailsMap.put("serviceNo", serviceNo);
			}
			if (request.getParameter(HIN_ID) != null
					&& !request.getParameter(HIN_ID).equals("")) {

				hinId = Integer.parseInt("" + request.getParameter(HIN_ID));
				detailsMap.put("hinId", hinId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String flag = "";

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}
		if (flag.equals("admission")) {
			map = misHandlerService.getHinAdNoForND(detailsMap);
			map.put("flag", flag);
			jsp = MIS_RESPONSE_FOR_ND;
		} else if (flag.equals("hin")) {
			map = misHandlerService.getHinAdNoForND(detailsMap);
			map.put("flag", flag);
			jsp = MIS_RESPONSE_FOR_ND;
		}

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getResponceForAME(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		if (request.getParameter("serviceNo") != null) {
			serviceNo = (request.getParameter("serviceNo"));
		}
		dataMap.put("serviceNo", serviceNo);
		map = misHandlerService.getResponceForAME(dataMap);
		jsp = "responceForAME";
		return new ModelAndView(jsp, "map", map);
	}

	// Start... AFMSF-1 forms Add by kalyan
	public ModelAndView showAfmsfArrivalEntryjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = misHandlerService.showAfmsfDefjsp();
		jsp = "arrivalEntry";
		jsp += ".jsp";
		title = "Afmsf-1 ArrivalEntry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAfmsfReceiptEntryjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = misHandlerService.showAfmsfDefjsp();
		jsp = "receiptEntryJsp";
		jsp += ".jsp";
		title = "Afmsf-1 ReceiptEntry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAfmsfClearanceFormjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = misHandlerService.showAfmsfDefjsp();
		jsp = "clearanceFormJsp";
		jsp += ".jsp";
		title = "Afmsf-1 Clearance Form";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAfmsfDispatchDetailsjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = misHandlerService.showAfmsfDefjsp();
		jsp = "dispatchDetailsJsp";
		jsp += ".jsp";
		title = "Afmsf-1 Dispatch Details";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAMEReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = "AMEReport";
		jsp += ".jsp";
		title = "Afmsf-1 Dispatch Details";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printAMEReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int inpatientId = 0;
		int dischargeId = 0;
		String aOrO = "";
		try {
			Date toDate = null;
			int Dept_ID = 0;
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(RADIO_FOR_TABLE) != null) {
				aOrO = (request.getParameter(RADIO_FOR_TABLE));
			}
			detailsMap = misHandlerService.getConnectionForReport();
			parameters.put("asOnDate", toDate);
			if (aOrO.equalsIgnoreCase("a")) {
				HMSUtil.generateReport("annualReport", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (aOrO.equalsIgnoreCase("o")) {
				HMSUtil.generateReport("annualReport2", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView showPMOReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = "PMOReport";
		jsp += ".jsp";
		title = "Afmsf-1 Dispatch Details";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showFatalDocumentTrackingReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = FATAL_DOCUMENT_TRACKING_REPORT;
		jsp += ".jsp";
		title = FATAL_DOCUMENT_TRACKING_REPORT;
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printPMO(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int hin_id = 0;
		String seviceNo = null;
		int disposed_to_id = 0;
		try {
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals(""))) {
				hin_id = Integer.parseInt(request.getParameter(HIN_ID));
				detailsMap.put("hin_id", hin_id);
			}
			if (request.getParameter("serviceNo") != null
					&& !(request.getParameter("serviceNo").equals(""))) {
				seviceNo = (request.getParameter("serviceNo"));
				detailsMap.put("serviceNo", seviceNo);
			}
			List<MisFrw> misFrwList = new ArrayList<MisFrw>();
			detailsMap = misHandlerService.printPMO(detailsMap);
			if (detailsMap.get("misFrwList") != null) {
				misFrwList = (List<MisFrw>) detailsMap.get("misFrwList");
			}

			if (seviceNo != null) {
				if (detailsMap.get("hinId") != null) {
					hin_id = Integer.parseInt("" + detailsMap.get("hinId"));
				}
			}
			for (MisFrw misFrw : misFrwList) {
				disposed_to_id = misFrw.getDisposedTo().getId();
			}

			parameters.put("hin_id", hin_id);
			if (disposed_to_id == 13) {
				HMSUtil.generateReport("sick_leave_movement_order", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else {
				HMSUtil.generateReport("Patient_Movement_Order", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView showAfmsfReports(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String form = "";
		Date toDate = null;
		Date fromDate = null;
		try {
			if (request.getParameter("form") != null
					&& !(request.getParameter("form").equals(""))) {
				form = request.getParameter("form");
			}

			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}

			map = misHandlerService.getDBConnection();
			map.put("fromDate", fromDate);
			map.put("toDate", toDate);

			if (!form.equals("") && form.equals("Deficient")) {
				HMSUtil.generateReport("afmsf_deficient_report", map,
						(Connection) map.get("conn"), response,
						getServletContext());
			}
			if (!form.equals("") && form.equals("Equal")) {
				HMSUtil.generateReport("afmsf_equal_report", map,
						(Connection) map.get("conn"), response,
						getServletContext());
			}
			if (!form.equals("") && form.equals("Surplus")) {
				HMSUtil.generateReport("afmsf_surplus_report", map,
						(Connection) map.get("conn"), response,
						getServletContext());
			}

			if (!form.equals("") && form.equals("Dispatch")) {
				HMSUtil.generateReport("Dispatch_details_report", map,
						(Connection) map.get("conn"), response,
						getServletContext());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView showAfmsfDispatchDetailsReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = DEFICIENT_SURPLUS_ANNUAL + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// End AFMSF-1
	public ModelAndView getHiAdListForBD(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		int hinId = 0;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}
		if (flag.equals("hin")) {
			if (request.getParameter(SERVICE_NO) != null) {
				serviceNo = request.getParameter(SERVICE_NO);
				detailsMap.put("serviceNo", serviceNo);
			}
		}
		if (flag.equals("ad")) {
			if (request.getParameter("hinId") != null) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				detailsMap.put("hinId", hinId);
			}
		}
		detailsMap.put("flag", flag);
		map = misHandlerService.getHiAdListForBD(detailsMap);
		if (flag.equals("hin")) {
			jsp = RESPONSE_BD;
		} else if (flag.equals("ad")) {
			jsp = RESPONSE_BD2;
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView printFDTReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int inpatientId = 0;
		String aOrO = "";
		try {
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				inpatientId = Integer.parseInt(request.getParameter(AD_NO));
			}
			detailsMap = misHandlerService.getConnectionForReport();
			parameters.put("inpatient_id", inpatientId);
			HMSUtil.generateReport("FDT", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printFRWForCurrentDate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Date frw_date = HMSUtil
				.convertStringTypeDateToDateType((String) utilMap
						.get("currentDate"));
		map = misHandlerService.getDBConnection();
		parameters.put("frw_date", frw_date);
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));
		HMSUtil.generateReport("FRWForCurrentDate", parameters,
				(Connection) map.get("conn"), response, getServletContext());
		return null;
	}

	// **Kalyan** for Excel Formate Report

	public ModelAndView totalAdmissionExcelSoftCopy(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		box.put("download_path", getServletContext().getRealPath("/download/"));
		map = misHandlerService.totalAdmissionExcelSoftCopy(box);
		if (map.get("flag") != null
				&& map.get("flag").toString().equalsIgnoreCase("NoData")) {
			map.put("message", "No Data Found!....");
		} else {
			try {
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition",
						"attachment; filename="
								+ map.get("download_path").toString());
				File f = new File(map.get("download_path").toString());
				InputStream in = new FileInputStream(f);
				ServletOutputStream outs = response.getOutputStream();
				int bit = 256;
				int i = 0;
				while ((bit) >= 0) {
					bit = in.read();
					outs.write(bit);
				}
				outs.flush();
				outs.close();
				in.close();
				if (f.exists()) {
					f.delete();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

		title = "Export CD";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return null;
	}

	public ModelAndView totalDischargeExcelSoftCopy(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		box.put("download_path", getServletContext().getRealPath("/download/"));
		map = misHandlerService.totalDischargeExcelSoftCopy(box);
		if (map.get("flag") != null
				&& map.get("flag").toString().equalsIgnoreCase("NoData")) {
			map.put("message", "No Data Found!....");
		} else {
			try {
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition",
						"attachment; filename="
								+ map.get("download_path").toString());
				File f = new File(map.get("download_path").toString());
				InputStream in = new FileInputStream(f);
				ServletOutputStream outs = response.getOutputStream();
				int bit = 256;
				int i = 0;
				while ((bit) >= 0) {
					bit = in.read();
					outs.write(bit);
				}
				outs.flush();
				outs.close();
				in.close();
				if (f.exists()) {
					f.delete();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

		title = "Export CD";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return null;
	}

	// **End T.A Excel**

	public ModelAndView showDeliveryDetailsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = misHandlerService.getDeliveryDetailsForSearch();
		jsp = DELIVERY_DETAILS_SEARCH_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchDeliveryDetails(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientDiagnosisMap = new HashMap<String, Object>();

		String hinNo = "";
		int wardId = 0;
		String adNo = "";
		int inpatientId = 0;
		String serviceNo = "";

		try {

			/*
			 * if(request.getParameter(SERVICE_NO) != null &&
			 * !(request.getParameter(SERVICE_NO).equals(""))){ serviceNo =
			 * request.getParameter(SERVICE_NO); mapForDs.put("serviceNo",
			 * serviceNo); }
			 */
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
			if (request.getParameter(WARD_ID) != null
					&& !(request.getParameter(WARD_ID).equals("0"))) {
				wardId = Integer.parseInt(request.getParameter(WARD_ID));
				mapForDs.put("wardId", wardId);
			}
			if (request.getParameter("inpatientId") != null) {
				inpatientId = Integer.parseInt(request
						.getParameter("inpatientId"));
				mapForDs.put("inpatientId", inpatientId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = misHandlerService.getPatientDeliveryDetails(mapForDs);

		String jsp = "";
		String message = "";
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Inpatient> inpatientTempList = new ArrayList<Inpatient>();

		if (patientMap.get("inpatientList") != null) {
			inpatientList = (List<Inpatient>) patientMap.get("inpatientList");
		}
		/*
		 * if((!adNo.equals("") && inpatientList.size() > 0 ) || inpatientId !=
		 * 0){ detailsMap = adtHandlerService.getDischargeDetails();
		 * patientDiagnosisMap = adtHandlerService.getPatientDiagnosis(adNo,
		 * inpatientId); map.put("patientDiagnosisMap", patientDiagnosisMap);
		 * jsp = DISCHARGE_BY_HIN_NO_JSP+".jsp"; else{
		 */map = misHandlerService.getDeliveryDetailsForSearch();
		jsp = DELIVERY_DETAILS_SEARCH_JSP + ".jsp";
		// }

		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showMotherBabyDetailsForUpdate(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientDiagnosisMap = new HashMap<String, Object>();

		String hinNo = "";
		int wardId = 0;
		String adNo = "";
		int inpatientId = 0;
		String serviceNo = "";

		try {
			if (request.getParameter("inpatientId") != null
					&& !(request.getParameter("inpatientId").equals(""))) {
				inpatientId = Integer.parseInt(request
						.getParameter("inpatientId"));
				mapForDs.put("inpatientId", inpatientId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = misHandlerService.getMotherAndBabyDetails(mapForDs);

		String jsp = "";
		String message = "";
		List<DeliveryDetails> deliveryDetailsList = new ArrayList<DeliveryDetails>();

		if (patientMap.get("deliveryDetailsList") != null) {
			deliveryDetailsList = (List<DeliveryDetails>) patientMap
					.get("deliveryDetailsList");
		}
		if ((!adNo.equals("") && deliveryDetailsList.size() > 0)
				|| inpatientId != 0) {
			jsp = EDIT_MOTHER_BABY_DETAILS + ".jsp";
		} else {
			map = misHandlerService.getDeliveryDetailsForSearch();
			jsp = DELIVERY_DETAILS_SEARCH_JSP + ".jsp";
		}

		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getInpatientDetails(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientDiagnosisMap = new HashMap<String, Object>();

		String hinNo = "";
		int wardId = 0;
		String adNo = "";
		int inpatientId = 0;
		String serviceNo = "";

		try {
			if (request.getParameter("inpatientId") != null
					&& !(request.getParameter("inpatientId").equals(""))) {
				inpatientId = Integer.parseInt(request
						.getParameter("inpatientId"));
				mapForDs.put("inpatientId", inpatientId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = misHandlerService.getMotherBabyDeatils(mapForDs);

		String jsp = "";
		String message = "";

		jsp = ADD_MOTHER_BABY_DETAILS_INFORMATION + ".jsp";

		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView fillPatinetDetailsAjax(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String hinNo = "";
		if (request.getParameter("hinNo") != null) {
			hinNo = request.getParameter("hinNo");

		}

		map = misHandlerService.getPatinetDetails(hinNo);
		String jsp = "";
		jsp = RESPONSE_PATINET_DETAILS;

		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getBabyDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		map = misHandlerService.getBabyDetails(mapForDs);
		String jsp = "";
		jsp = ADD_BABY_DETAILS_INFORMATION + ".jsp";
		;

		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addMotherBabyDetails(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		session = request.getSession();
		int hinId = 0;
		int inpatientId = 0;
		String bloodLoss = "";
		String placenta = "";
		String treatment = "";
		Date dateOnSet = new Date();
		String timeOnSet = "";
		String purperium = "";
		String motherCondition = "";
		int pulse = 0;
		int perineum = 0;
		int bP = 0;
		int masEmpIdConductedBy = 0;
		int masEmpIdAssistedBy = 0;
		int hospitalId = 0;
		String additionalNotes = "";
		String complications = "";
		try {

			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				mapForDs.put("hospitalId", hospitalId);
			}
			if (request.getParameter(CONDUCTED_BY) != null
					&& !(request.getParameter(CONDUCTED_BY).equals(""))) {
				masEmpIdConductedBy = Integer.parseInt(request
						.getParameter(CONDUCTED_BY));
				mapForDs.put("masEmpIdConductedBy", masEmpIdConductedBy);
			}
			if (request.getParameter(ASSISTED_BY) != null
					&& !(request.getParameter(ASSISTED_BY).equals(""))) {
				masEmpIdAssistedBy = Integer.parseInt(request
						.getParameter(ASSISTED_BY));
				mapForDs.put("masEmpIdAssistedBy", masEmpIdAssistedBy);
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals(""))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(INPATIENT_ID) != null) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter(BLOOD_LOSS) != null
					&& !(request.getParameter(BLOOD_LOSS).equals(""))) {
				bloodLoss = request.getParameter(BLOOD_LOSS);
				mapForDs.put("bloodLoss", bloodLoss);
			}
			if (request.getParameter(PLACENTA) != null
					&& !(request.getParameter(PLACENTA).equals(""))) {
				placenta = request.getParameter(PLACENTA);
				mapForDs.put("placenta", placenta);
			}
			if (request.getParameter(TREATMENT) != null
					&& !(request.getParameter(TREATMENT).equals(""))) {
				treatment = request.getParameter(TREATMENT);
				mapForDs.put("treatment", treatment);
			}
			if (request.getParameter(DATE_ON_SET) != null
					&& !(request.getParameter(DATE_ON_SET).equals(""))) {
				dateOnSet = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(DATE_ON_SET));
				mapForDs.put("dateOnSet", dateOnSet);
			}
			if (request.getParameter(TIME_ON_SET) != null
					&& !(request.getParameter(TIME_ON_SET).equals(""))) {
				timeOnSet = request.getParameter(TIME_ON_SET);
				mapForDs.put("timeOnSet", timeOnSet);
			}
			if (request.getParameter(PUERPERIUM) != null
					&& !(request.getParameter(PUERPERIUM).equals(""))) {
				purperium = request.getParameter(PUERPERIUM);
				mapForDs.put("purperium", purperium);
			}
			if (request.getParameter(MOTHER_CONDITION) != null
					&& !(request.getParameter(MOTHER_CONDITION).equals(""))) {
				motherCondition = request.getParameter(MOTHER_CONDITION);
				mapForDs.put("motherCondition", motherCondition);
			}
			if (request.getParameter(PULSE) != null
					&& !(request.getParameter(PULSE).equals(""))) {
				pulse = Integer.parseInt(request.getParameter(PULSE));
				mapForDs.put("pulse", pulse);
			}
			if (request.getParameter(PERINEUM) != null
					&& !(request.getParameter(PERINEUM).equals(""))) {
				perineum = Integer.parseInt(request.getParameter(PERINEUM));
				mapForDs.put("perineum", perineum);
			}
			if (request.getParameter(BP) != null
					&& !(request.getParameter(BP).equals(""))) {
				bP = Integer.parseInt(request.getParameter(BP));
				mapForDs.put("bP", bP);
			}
			if (request.getParameter(ADDITIONAL_NOTES) != null
					&& !(request.getParameter(ADDITIONAL_NOTES).equals(""))) {
				additionalNotes = request.getParameter(ADDITIONAL_NOTES);
				mapForDs.put("additionalNotes", additionalNotes);
			}
			if (request.getParameter(COMPLICATIONS) != null
					&& !(request.getParameter(COMPLICATIONS).equals(""))) {
				complications = request.getParameter(COMPLICATIONS);
				mapForDs.put("complications", complications);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		misHandlerService.addMotherDetails(mapForDs);
		map = misHandlerService.getBabyDetails(mapForDs);
		String jsp = "";
		jsp = ADD_BABY_DETAILS_INFORMATION + ".jsp";
		;
		String message = "";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addBabyDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		session = request.getSession();

		int deliveryType = 0;
		int babyNo = 0;
		Date dateOfBirth = new Date();
		String timeOfBirth = "";
		String birthCertificationNo = "";
		Date birthCertificationDate = new Date();
		int babySex = 0;
		int csIndication = 0;
		int gestation = 0;
		double headCircumferance = 0.0;
		String csNo = "";
		String gestationAge = "";
		double lenght = 0.0;
		double apgarScore = 0.0;
		String estGestAge = "";
		String weight = "";
		int neonatalProblems = 0;
		int babyStatus = 0;
		String outCome = "";

		try {

			if (request.getParameter(DELIVERY_TYPE) != null
					&& !(request.getParameter(DELIVERY_TYPE).equals(""))) {
				deliveryType = Integer.parseInt(request
						.getParameter(DELIVERY_TYPE));
				mapForDs.put("deliveryType", deliveryType);
			}
			if (request.getParameter(BABY_NO) != null
					&& !(request.getParameter(BABY_NO).equals(""))) {
				babyNo = Integer.parseInt(request.getParameter(BABY_NO));
				mapForDs.put("babyNo", babyNo);
			}
			if (request.getParameter(DATE_OF_BIRTH) != null
					&& !(request.getParameter(DATE_OF_BIRTH).equals(""))) {
				dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(DATE_OF_BIRTH));
				mapForDs.put("dateOfBirth", dateOfBirth);
			}
			if (request.getParameter(TIME_OF_BIRTH) != null
					&& !(request.getParameter(TIME_OF_BIRTH).equals(""))) {
				timeOfBirth = request.getParameter(TIME_OF_BIRTH);
				mapForDs.put("timeOfBirth", timeOfBirth);
			}
			if (request.getParameter(BIRTH_CERTIFICATE_NO) != null
					&& !(request.getParameter(BIRTH_CERTIFICATE_NO).equals(""))) {
				birthCertificationNo = request
						.getParameter(BIRTH_CERTIFICATE_NO);
				mapForDs.put("birthCertificationNo", birthCertificationNo);
			}
			if (request.getParameter(BIRTH_CERTIFICATE_DATE) != null
					&& !(request.getParameter(BIRTH_CERTIFICATE_DATE)
							.equals(""))) {
				birthCertificationDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(BIRTH_CERTIFICATE_DATE));
				mapForDs.put("birthCertificationDate", birthCertificationDate);
			}
			if (request.getParameter(SEX) != null
					&& !(request.getParameter(SEX).equals(""))) {
				babySex = Integer.parseInt(request.getParameter(SEX));
				mapForDs.put("babySex", babySex);
			}
			if (request.getParameter(CS_INDICATION) != null
					&& !(request.getParameter(CS_INDICATION).equals(""))) {
				csIndication = Integer.parseInt(request
						.getParameter(CS_INDICATION));
				mapForDs.put("csIndication", csIndication);
			}
			if (request.getParameter(GESTATION) != null
					&& !(request.getParameter(GESTATION).equals(""))) {
				gestation = Integer.parseInt(request.getParameter(GESTATION));
				mapForDs.put("gestation", gestation);
			}
			if (request.getParameter(HEAD_CIRCUMFERANCE) != null
					&& !(request.getParameter(HEAD_CIRCUMFERANCE).equals(""))) {
				headCircumferance = Double.parseDouble(request
						.getParameter(HEAD_CIRCUMFERANCE));
				mapForDs.put("headCircumferance", headCircumferance);
			}
			if (request.getParameter(CS_No) != null
					&& !(request.getParameter(CS_No).equals(""))) {
				csNo = request.getParameter(CS_No);
				mapForDs.put("csNo", csNo);
			}
			if (request.getParameter(GESTATION_AGE) != null
					&& !(request.getParameter(GESTATION_AGE).equals(""))) {
				gestationAge = request.getParameter(GESTATION_AGE);
				mapForDs.put("gestationAge", gestationAge);
			}
			if (request.getParameter(LENGTH) != null
					&& !(request.getParameter(LENGTH).equals(""))) {
				lenght = Double.parseDouble(request.getParameter(LENGTH));
				mapForDs.put("lenght", lenght);
			}
			if (request.getParameter(APGAR_SCORE) != null
					&& !(request.getParameter(APGAR_SCORE).equals(""))) {
				apgarScore = Double.parseDouble(request
						.getParameter(APGAR_SCORE));
				mapForDs.put("apgarScore", apgarScore);
			}
			if (request.getParameter(EST_GEST_AGE) != null
					&& !(request.getParameter(EST_GEST_AGE).equals(""))) {
				estGestAge = request.getParameter(EST_GEST_AGE);
				mapForDs.put("estGestAge", estGestAge);
			}
			if (request.getParameter(WEIGHT) != null
					&& !(request.getParameter(WEIGHT).equals(""))) {
				weight = request.getParameter(WEIGHT);
				mapForDs.put("weight", weight);
			}
			if (request.getParameter(NEONATAL_PROBLEMS) != null
					&& !(request.getParameter(NEONATAL_PROBLEMS).equals(""))) {
				neonatalProblems = Integer.parseInt(request
						.getParameter(NEONATAL_PROBLEMS));
				mapForDs.put("neonatalProblems", neonatalProblems);
			}
			if (request.getParameter(BABY_STATUS) != null
					&& !(request.getParameter(BABY_STATUS).equals(""))) {
				babyStatus = Integer
						.parseInt(request.getParameter(BABY_STATUS));
				mapForDs.put("babyStatus", babyStatus);
			}
			if (request.getParameter(OUT_COME) != null
					&& !(request.getParameter(OUT_COME).equals(""))) {
				outCome = request.getParameter(OUT_COME);
				mapForDs.put("outCome", outCome);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		misHandlerService.addBabyDetails(mapForDs);

		String jsp = "";
		jsp = DELIVERY_DETAILS_SEARCH_JSP + ".jsp";
		;
		String message = "";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	/**
	 * ----------------------- CONTROLLER METHODS --------------------
	 *
	 * @return
	 */
	public MISHandlerService getMisHandlerService() {
		return misHandlerService;
	}

	public void setMisHandlerService(MISHandlerService misHandlerService) {
		this.misHandlerService = misHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}
}
