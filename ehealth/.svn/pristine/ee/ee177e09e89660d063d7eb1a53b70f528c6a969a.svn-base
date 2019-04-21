package jkt.hms.budget.controller;

import static jkt.hms.util.RequestConstants.BILL_DATE;
import static jkt.hms.util.RequestConstants.*;
import static jkt.hms.util.RequestConstants.BUGD_ESTIMATE_ENTRY_JSP;
import static jkt.hms.util.RequestConstants.BUGD_ESTIMATE_ENTRY_JSP_SEARCH;
import static jkt.hms.util.RequestConstants.BUGD_FINANCIAL_YEAR_JSP;
import static jkt.hms.util.RequestConstants.BUGD_MAJOR_HEAD_JSP;
import static jkt.hms.util.RequestConstants.BUGD_MINOR_SUB_HEAD_JSP;
import static jkt.hms.util.RequestConstants.BUGD_OBJECT_HEAD_JSP;
import static jkt.hms.util.RequestConstants.BUGD_SUB_MAJOR_HEAD_JSP;
import static jkt.hms.util.RequestConstants.BUGD_VOUCHER_BILL_ENTRY;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.ENCASH_DATE;
import static jkt.hms.util.RequestConstants.FINANCIAL_ID;
import static jkt.hms.util.RequestConstants.FINANCIAL_YEAR;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.LPO_REGISTER_REPORT;
import static jkt.hms.util.RequestConstants.MAJOR_HEAD_ID;
import static jkt.hms.util.RequestConstants.MAJOR_SUB_HEAD_ID;
import static jkt.hms.util.RequestConstants.MESSAGE_FOR_BILLING_JSP;
import static jkt.hms.util.RequestConstants.MINOR_SUB_HEAD_ID;
import static jkt.hms.util.RequestConstants.OBJECT_HEAD_ID;
import static jkt.hms.util.RequestConstants.OPD_PHYSIOTHERAPY_MSG_JSP;
import static jkt.hms.util.RequestConstants.PAYABLE_AMOUNT;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SEARCH_PATIENT_FOR_ADVANCE_JSP;
import static jkt.hms.util.RequestConstants.SEARCH_PATIENT_FOR_FINAL_SETTLEMENT_JSP;
import static jkt.hms.util.RequestConstants.SECTOR_TYPE;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.SEQUENCE_NO;
import static jkt.hms.util.RequestConstants.SUB_MAJOR_HEAD_ID;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.VENDOR_NAME;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.budget.dataservice.BudgetDataService;
import jkt.hms.budget.dataservice.BudgetDataServiceImpl;
import jkt.hms.budget.handler.BudgetHandlerService;
import jkt.hms.masters.business.BudEstimateEntry;
import jkt.hms.masters.business.BudMajorHead;
import jkt.hms.masters.business.BudMinorHead;
import jkt.hms.masters.business.BudMinorSubHead;
import jkt.hms.masters.business.BudObjectHead;
import jkt.hms.masters.business.BudReAppropEntry;
import jkt.hms.masters.business.BudSubMajorHead;
import jkt.hms.masters.business.BudVoucherDetail;
import jkt.hms.masters.business.BudVoucherHeader;
import jkt.hms.masters.business.BudVoucherReceiptEntry;
import jkt.hms.masters.business.FaMasAccount;
import jkt.hms.masters.business.FaVoucherDetails;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasSetupParameterMaintaince;
import jkt.hms.masters.business.StoreGrnM;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.HospitalDetailsMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.PojoForMasStoreItem;
import jkt.hms.util.RequestConstants;
import jkt.hrms.masters.business.HrMasFinancialYear;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@SuppressWarnings("unused")
public class BudgetController extends MultiActionController {
	private static final String FINANCIAL_YEAR_JSP = null;
	BudgetHandlerService budgetHandlerService = null;
	HospitalDetailsMasterHandlerService hospitalDetailsMasterHandlerService = null;

	public HospitalDetailsMasterHandlerService getHospitalDetailsMasterHandlerService() {
		return hospitalDetailsMasterHandlerService;
	}

	public void setHospitalDetailsMasterHandlerService(
			HospitalDetailsMasterHandlerService hospitalDetailsMasterHandlerService) {
		this.hospitalDetailsMasterHandlerService = hospitalDetailsMasterHandlerService;
	}

	public BudgetHandlerService getBudgetHandlerService() {
		return budgetHandlerService;
	}

	public void setBudgetHandlerService(
			BudgetHandlerService budgetHandlerService) {
		this.budgetHandlerService = budgetHandlerService;
	}

	CommonMasterHandlerService commonMasterHandlerService = null;
	private HttpSession session;
	private Object map;
	private String jsp;
	private String title;
	String YEAR_DESCRIPTION = "";
	String FROM_DATE = "";
	String TO_DATE = "";
	String url = "";
	String message = "";
	String code = "";
	String name = "";
	String Date = "";
	String Year = "";
	String currentDate = "";
	String currentTime = "";
	private Object pojoPropertyName;
	private Object pojoPropertyCode;
	private Object pojoName;

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	// --------------------------Financial Master--------------------------//
	// ---------------------Code By:Ujjwal---------------------------------//

	public ModelAndView showFinancialyearMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = budgetHandlerService.showFinancialyearMaster();
		String jsp = BUGD_FINANCIAL_YEAR_JSP;
		jsp += ".jsp";
		title = "financialyear";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addfinancialyear(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HrMasFinancialYear masFinancialYear = new HrMasFinancialYear();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date toDate = null;
		Date fromDate = null;
		String financialYear = null;
		String description = null;
		Date changedByDate= null;
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter("toDate") != null
				&& !(request.getParameter("toDate").equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("toDate"));
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter("fromDate") != null
				&& !(request.getParameter("fromDate").equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("fromDate"));
			masFinancialYear.setYearFromDate(fromDate);
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedByDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("fromDate", fromDate);
		generalMap.put("toDate", toDate);
		generalMap.put("changedBy", changedBy);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = budgetHandlerService.checkForExistingMasters(generalMap);
		List financialCodeList = new ArrayList();
		List financialNameList = new ArrayList();
		if (listMap.get("duplicateGeneralCodeList") != null) {
			financialCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			financialNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((financialCodeList.size() == 0 || financialCodeList == null)
				&& (financialNameList.size() == 0 || financialNameList == null))

		{
			masFinancialYear.setYearDescription(code);
			masFinancialYear.setFinancialYear(name);
			masFinancialYear.setYearFromDate(fromDate);
			masFinancialYear.setYearToDate(toDate);
			masFinancialYear.setStatus("y");
			//commented for maven
		/*	masFinancialYear.setLastChgBy(changedBy);*/
			masFinancialYear.setLastChgDate(changedByDate);
			masFinancialYear.setLastChgTime(currentTime);
			successfullyAdded = budgetHandlerService
					.addfinancialyear(masFinancialYear);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";

			}
		} else if ((financialCodeList.size() != 0 || financialCodeList != null)
				|| (financialNameList.size() != 0) || financialNameList != null) {

			if ((financialCodeList.size() != 0 || financialCodeList != null)
					&& (financialNameList.size() == 0 || financialNameList == null)) {

				message = "Financial Code  already exists.";
			} else if ((financialNameList.size() != 0 || financialNameList != null)
					&& (financialCodeList.size() == 0 || financialCodeList == null)) {

				message = "Financial Name  already exists.";
			} else if ((financialCodeList.size() != 0 || financialCodeList != null)
					&& (financialNameList.size() != 0 || financialNameList != null)) {

				message = "Financial Code and Financial Name already exist.";
			}
		}

		url = "/hms/hms/accountMaster?method=showFinancialyearMaster";

		try {
			map = budgetHandlerService.showFinancialyearMaster();

		} catch (Exception e) {
			e.printStackTrace();

		}
		String jsp = BUGD_FINANCIAL_YEAR_JSP;
		title = "Add Financial Year";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editfinancialyear(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String financialCode = "";
		String financialName = "";
		Date fromDate = null;
		Date toDate = null;
		Date changedByDate=null;
		int financialId = 0;
		String changedBy = "";
		boolean dataUpdated = false;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			financialId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			financialCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			financialName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedByDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		
		 if (request.getParameter(CHANGED_BY) != null &&
		 !(request.getParameter(CHANGED_BY).equals(""))) { changedBy =
		 request.getParameter(CHANGED_BY); }
		if (request.getParameter("fromDate") != null
				&& !(request.getParameter("fromDate").equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("fromDate"));

		}
		if (request.getParameter("toDate") != null
				&& !(request.getParameter("toDate").equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("toDate"));

		}

		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		generalMap.put("id", financialId);
		generalMap.put("code", financialCode);
		generalMap.put("name", financialName);
		generalMap.put("fromDate", fromDate);
		generalMap.put("toDate", toDate);
		generalMap.put("changedBy", changedBy);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		generalMap.put("changedByDate", changedByDate);
		listMap = budgetHandlerService.checkForExistingMasters(generalMap);
		List existingWorkNameList = (List) listMap.get("duplicateMastersList");

		if (existingWorkNameList.size() == 0) {
			dataUpdated = budgetHandlerService.editfinancialyear(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
				
			}

			else {
				message = "Try Again   !!";
			}
		} else if (existingWorkNameList.size() > 0) {
			message = "Name already exists.";
		}

		url = "/hms/hms/budget?method=showFinancialyearMaster";

		try {
			map = budgetHandlerService.showFinancialyearMaster();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BUGD_FINANCIAL_YEAR_JSP;
		title = "Edit financial year Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchfinancialyear(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String financialCode = null;
		String financialName = null;
		String searchField = null;
		int searchRadio = 1;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			financialCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			financialName = request.getParameter(SEARCH_NAME);
		}

		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			financialCode = searchField;
			financialName = null;
		} else {
			financialCode = null;
			financialName = searchField;
		}

		map = budgetHandlerService.searchfinancialyear(financialCode,
				financialName);

		jsp = "FinancialYearMaster";
		jsp += ".jsp";

		
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("financialCode", financialCode);
		map.put("financialName", financialName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deletefinancialyear(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		Map<String, Object> listMap = new HashMap<String, Object>();

		int financilId = 0;
		String changedTime = "";
		Date changedDate = null;
		String changedBy = "";
		boolean dataDeleted = false;
		String flag = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			financilId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("flag") != null
				&& !(request.getParameter("flag").equals(""))) {
			flag = request.getParameter("flag");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("flag", flag);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		dataDeleted = budgetHandlerService.deletefinancialyear(financilId,
				generalMap);

		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}

		try {
			map = budgetHandlerService.showFinancialyearMaster();

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = "FinancialYearMaster";
		title = "Delete FinancialYearMaster";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);

		return new ModelAndView("index", "map", map);
	}

	// -----------------------MajorHead Master By:
	// Ujjwal------------------------//
	public ModelAndView showBudgetMajorHead(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = budgetHandlerService.showBudgetMajorHead();
		String jsp = BUGD_MAJOR_HEAD_JSP;
		jsp += ".jsp";
		title = "majorhead";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView addMajorHead(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		BudMajorHead majorHead = new BudMajorHead();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		Date toDate = null;
		Date fromDate = null;
		String majorheadCode = null;
		String majorheadName = null;
		int	sequenceNo=0;
		String financialYear = null;
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}

		if (request.getParameter(SEQUENCE_NO) != null
				&& !(request.getParameter(SEQUENCE_NO).equals(""))) {
			sequenceNo = Integer.parseInt(request.getParameter(SEQUENCE_NO));
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter(FINANCIAL_YEAR) != null
				&& !(request.getParameter("FINANCIAL_YEAR").equals(""))) {
			financialYear = request.getParameter(FINANCIAL_YEAR);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		int hospitalId = 0;
		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("sequenceNo", sequenceNo);
		generalMap.put("changedBy", changedBy);
		generalMap.put("financialYear", financialYear);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = budgetHandlerService.checkForExistingMasters(generalMap);
		List majorheadCodeList = new ArrayList();
		List majorheadNameList = new ArrayList();
		if (listMap.get("duplicateGeneralCodeList") != null) {
			majorheadCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			majorheadNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((majorheadCodeList.size() == 0 || majorheadCodeList == null)
				&& (majorheadNameList.size() == 0 || majorheadNameList == null))

		{
			majorHead.setMajorHeadCode(code);
			majorHead.setMajorHeadName(name);
			majorHead.setSequenceNo(sequenceNo);
			majorHead.setStatus("y");
			majorHead.setLastChgeBy(changedBy);
			majorHead.setLastChgDate(currentDate);
			majorHead.setLastChgTime(currentTime);
			majorHead.setHospitalId(hospitalId);
			successfullyAdded = budgetHandlerService.addMajorHead(majorHead);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";

			}
		} else if ((majorheadCodeList.size() != 0 || majorheadCodeList != null)
				|| (majorheadNameList.size() != 0) || majorheadNameList != null) {

			if ((majorheadCodeList.size() != 0 || majorheadCodeList != null)
					&& (majorheadNameList.size() == 0 || majorheadNameList == null)) {

				message = "Major Head Code  already exists.";
			} else if ((majorheadCodeList.size() != 0 || majorheadCodeList != null)
					&& (majorheadNameList.size() == 0 || majorheadNameList == null)) {

				message = "Major Head Name  already exists.";
			} else if ((majorheadCodeList.size() != 0 || majorheadCodeList != null)
					&& (majorheadNameList.size() != 0 || majorheadNameList != null)) {

				message = "Major Head Code and Major Head Name already exist.";
			}
		}

		url = "/hms/hms/accountMaster?method=showBudgetMajorHead";

		try {
			map = budgetHandlerService.showBudgetMajorHead();

		} catch (Exception e) {
			e.printStackTrace();

		}
		String jsp = BUGD_MAJOR_HEAD_JSP;
		title = "Add major Head";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteMajorHead(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		Map<String, Object> listMap = new HashMap<String, Object>();
		int majorheadId = 0;
		String changedTime = "";
		Date changedDate = null;
		String changedBy = "";
		boolean dataDeleted = false;
		String flag = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			majorheadId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("flag") != null
				&& !(request.getParameter("flag").equals(""))) {
			flag = request.getParameter("flag");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("flag", flag);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		dataDeleted = budgetHandlerService.deleteMajorHead(majorheadId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}

		try {
			map = budgetHandlerService.showBudgetMajorHead();

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = "majorHeadJsp";
		title = "Delete Major Head Jsp";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editmajorhead(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String majorheadCode = "";
		String majorheadName = "";
		int majorheadId = 0;
		int sequenceNo = 0;
		String changedBy = "";
		boolean dataUpdated = false;
				if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			majorheadId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			majorheadCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			majorheadName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(SEQUENCE_NO) != null
				&& !(request.getParameter(SEQUENCE_NO).equals(""))) {
			sequenceNo = Integer.parseInt(request.getParameter(SEQUENCE_NO));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		generalMap.put("id", majorheadId);
		generalMap.put("code", majorheadCode);
		generalMap.put("name", majorheadName);
		generalMap.put("sequenceNo", sequenceNo);
		generalMap.put("changedBy", changedBy);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = budgetHandlerService.checkForExistingMasters(generalMap);
		List existingWorkNameList = (List) listMap.get("duplicateMastersList");

		if (existingWorkNameList.size() == 0) {
			dataUpdated = budgetHandlerService.editmajorhead(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
				
			}

			else {
				message = "Try Again   !!";
			}
		} else if (existingWorkNameList.size() > 0) {
			message = "Name already exists.";
		}

		url = "/hms/hms/account?method=showBudgetMajorHead";

		try {
			map = budgetHandlerService.showBudgetMajorHead();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "majorHeadJsp";
		title = "Edit financial year Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchmajorhead(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String MajorHeadCode = null;
		String MajorHeadName = null;
		String searchField = null;
		int searchRadio = 1;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			MajorHeadCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			MajorHeadName = request.getParameter(SEARCH_NAME);
		}

		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			MajorHeadCode = searchField;
			MajorHeadName = null;
		} else {
			MajorHeadCode = null;
			MajorHeadName = searchField;
		}

		map = budgetHandlerService
				.searchmajorhead(MajorHeadCode, MajorHeadName);

		jsp = "majorHeadJsp";
		jsp += ".jsp";

		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("workCode", MajorHeadCode);
		map.put("workName", MajorHeadName);
		return new ModelAndView("index", "map", map);
	}

	// ---------------Sub Major Head---------------------------//
	public ModelAndView showSubMajorHead(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();

		map = budgetHandlerService.showSubMajorHead();
		String jsp = "subMajorHead";
		jsp += ".jsp";
		title = "submajorhead";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addSubMajorHead(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		BudSubMajorHead subMajorHead = new BudSubMajorHead();
		BudMajorHead majorhead = new BudMajorHead();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		Date toDate = null;
		Date fromDate = null;
		String submajorheadCode = null;
		String submajorheadName = null;
		int majorheadId = 0;
		int sequenceNo = 0;
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}

		if (request.getParameter(MAJOR_HEAD_ID) != null
				&& !(request.getParameter(MAJOR_HEAD_ID).equals(""))) {
			majorheadId = Integer.parseInt(request.getParameter(MAJOR_HEAD_ID));
			
		}
		if (request.getParameter(SEQUENCE_NO) != null
				&& !(request.getParameter(SEQUENCE_NO).equals(""))) {
		sequenceNo = Integer.parseInt(request.getParameter(SEQUENCE_NO));

		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));

		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		int hospitalId = 0;
		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("majorheadId", majorheadId);
		
		generalMap.put("changedBy", changedBy);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		listMap = budgetHandlerService.checkForExistingMasters(generalMap);
		List submajorheadCodeList = new ArrayList();
		List submajorheadNameList = new ArrayList();
		if (listMap.get("duplicateGeneralCodeList") != null) {
			submajorheadCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			submajorheadNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((submajorheadCodeList.size() == 0 || submajorheadCodeList == null)
				&& (submajorheadNameList.size() == 0 || submajorheadNameList == null))

		{
			subMajorHead.setSubMajorHeadCode(code);
			subMajorHead.setSubMajorHeadName(name);
			majorhead.setId(majorheadId);
			subMajorHead.setMajorHeadId(majorhead);
			subMajorHead.setHospitalId(hospitalId);
			subMajorHead.setSequenceNo(sequenceNo);
			subMajorHead.setStatus("y");
			subMajorHead.setLastChgBy(changedBy);
			subMajorHead.setLastChgTime(currentTime);
			successfullyAdded = budgetHandlerService
					.addSubMajorHead(subMajorHead);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";

			}
		} else if ((submajorheadCodeList.size() != 0 || submajorheadCodeList != null)
				|| (submajorheadNameList.size() != 0)
				|| submajorheadNameList != null) {

			if ((submajorheadCodeList.size() != 0 || submajorheadCodeList != null)
					&& (submajorheadNameList.size() == 0 || submajorheadNameList == null)) {

				message = "Major Head Code  already exists.";
			} else if ((submajorheadCodeList.size() != 0 || submajorheadCodeList != null)
					&& (submajorheadNameList.size() == 0 || submajorheadNameList == null)) {

				message = "Major Head Name  already exists.";
			} else if ((submajorheadCodeList.size() != 0 || submajorheadCodeList != null)
					&& (submajorheadNameList.size() != 0 || submajorheadNameList != null)) {

				message = "Major Head Code and Major Head Name already exist.";
			}
		}

		url = "/hms/hms/accountMaster?method=showSubMajorHead";

		try {
			map = budgetHandlerService.showSubMajorHead();

		} catch (Exception e) {
			e.printStackTrace();

		}
		String jsp = BUGD_SUB_MAJOR_HEAD_JSP;
		title = "Add Sub major Head";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editSubMajorHead(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String subMajorHeadCode = "";
		String subMajorHeadName = "";
		int subMajorHeadId = 0;
		int majorHeadId = 0;
		String changedBy = "";
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			subMajorHeadId = Integer.parseInt(request.getParameter(COMMON_ID));
			
		}
		if (request.getParameter(MAJOR_HEAD_ID) != null
				&& !(request.getParameter(MAJOR_HEAD_ID).equals(""))) {
			majorHeadId = Integer.parseInt(request.getParameter(MAJOR_HEAD_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			subMajorHeadCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			subMajorHeadName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("subMajorHeadId", subMajorHeadId);
		generalMap.put("majorHeadId", majorHeadId);
		
		generalMap.put("subMajorHeadCode", subMajorHeadCode);
		generalMap.put("name", subMajorHeadName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCurrencyNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingCurrencyNameList.size() == 0) {
			dataUpdated = budgetHandlerService.editSubMajorHead(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingCurrencyNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/budget?method=showSubMajorHead";
		try {
			map = budgetHandlerService.showSubMajorHead();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BUGD_SUB_MAJOR_HEAD_JSP;
		title = "Edit Sub Major Head";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteSubMajorHead(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int submajorheadId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			submajorheadId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		
		boolean dataDeleted = false;
		dataDeleted = budgetHandlerService.deleteSubMajorHead(submajorheadId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showSubMajorHead";
		try {
			map = budgetHandlerService.showSubMajorHead();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BUGD_SUB_MAJOR_HEAD_JSP;
		title = "delete sub major head";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ---------------Minor Sub Head------------------------//
	public ModelAndView showMinorSubHead(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		@SuppressWarnings("unused")
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = budgetHandlerService.showMinorSubHead();
		String jsp = "minorSubHead";
		jsp += ".jsp";
		title = "minorSubHead";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addMinorSubHead(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		BudMinorSubHead minorSubHead = new BudMinorSubHead();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		Date toDate = null;
		Date fromDate = null;
		String minorSubheadCode = null;
		String minorSubheadName = null;
		int minorHeadId=0;
		//int minorHeadId = 0;
		int sequenceNo = 0;
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}

		if (request.getParameter(MINOR_HEAD_ID) != null
				&& !(request.getParameter(MINOR_HEAD_ID).equals(""))) {
			minorHeadId = Integer.parseInt(request
					.getParameter(MINOR_HEAD_ID));
		}
		if (request.getParameter(SEQUENCE_NO) != null
				&& !(request.getParameter(SEQUENCE_NO).equals(""))) {
			sequenceNo = Integer.parseInt(request.getParameter(SEQUENCE_NO));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));

		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		int hospitalId = 0;
		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		generalMap.put("code", code);
		generalMap.put("name", name);
		//generalMap.put("majorheadId", submajorheadId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		listMap = budgetHandlerService.checkForExistingMasters(generalMap);
		List minorsubheadCodeList = new ArrayList();
		List minorsubheadNameList = new ArrayList();
		if (listMap.get("duplicateGeneralCodeList") != null) {
			minorsubheadCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			minorsubheadNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((minorsubheadCodeList.size() == 0 || minorsubheadCodeList == null)
				&& (minorsubheadNameList.size() == 0 || minorsubheadNameList == null))

		{
			minorSubHead.setMinorSubHeadCode(code);
			minorSubHead.setMinorSubHeadName(name);
/*			BudSubMajorHead subMajorHead = new BudSubMajorHead();
			subMajorHead.setId(submajorheadId);
*/			BudMinorHead minorHead=new BudMinorHead();
			minorHead.setId(minorHeadId);
			minorSubHead.setMinorHeadId(minorHead);
			minorSubHead.setSequenceNo(sequenceNo);
			minorSubHead.setStatus("y");
			minorSubHead.setLastChgBy(changedBy);
			minorSubHead.setLastChgTime(currentTime);
			MasHospital masHospital=new MasHospital();
			masHospital.setId(hospitalId);
			minorSubHead.setHospitalId(masHospital);
			successfullyAdded = budgetHandlerService
					.addMinorSubHead(minorSubHead);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";

			}
		} else if ((minorsubheadCodeList.size() != 0 || minorsubheadCodeList != null)
				|| (minorsubheadNameList.size() != 0)
				|| minorsubheadNameList != null) {

			if ((minorsubheadCodeList.size() != 0 || minorsubheadCodeList != null)
					&& (minorsubheadNameList.size() == 0 || minorsubheadNameList == null)) {

				message = "Minor Sub Head Code  already exists.";
			} else if ((minorsubheadCodeList.size() != 0 || minorsubheadCodeList != null)
					&& (minorsubheadNameList.size() == 0 || minorsubheadNameList == null)) {

				message = "Minor Sub Head Name  already exists.";
			} else if ((minorsubheadCodeList.size() != 0 || minorsubheadCodeList != null)
					&& (minorsubheadNameList.size() != 0 || minorsubheadNameList != null)) {

				message = "Minor Sub Head Code and Minor Sub Head Name already exist.";
			}
		}

		url = "/hms/hms/accountMaster?method=showMinorSubHead";

		try {
			map = budgetHandlerService.showMinorSubHead();

		} catch (Exception e) {
			e.printStackTrace();

		}
		String jsp = BUGD_MINOR_SUB_HEAD_JSP;
		title = "Add Minor Sub Head";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteMinorSubHead(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int minorsubheadId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			minorsubheadId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		
		boolean dataDeleted = false;
		dataDeleted = budgetHandlerService.deleteMinorSubHead(minorsubheadId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showMinorSubHead";
		try {
			map = budgetHandlerService.showMinorSubHead();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BUGD_MINOR_SUB_HEAD_JSP;
		title = "delete minor sub head";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editObjectHead(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String objectheadCode = "";
		String objectheadName = "";
		int submajorheadId = 0;
		int objectheadId = 0;
		String changedBy = "";
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			objectheadId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(SUB_MAJOR_HEAD_ID) != null
				&& !(request.getParameter(SUB_MAJOR_HEAD_ID).equals(""))) {
			submajorheadId = Integer.parseInt(request
					.getParameter(SUB_MAJOR_HEAD_ID));
		}
		

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			objectheadCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			objectheadName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}

		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", objectheadId);
		generalMap.put("countryCode", objectheadCode);
		generalMap.put("name", objectheadName);
		generalMap.put("currencyId", submajorheadId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
				listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCountryNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingCountryNameList.size() == 0) {
			dataUpdated = budgetHandlerService.editObjectHead(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingCountryNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/budget?method=showObjectHead";
		try {
			map = budgetHandlerService.showObjectHead();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BUGD_OBJECT_HEAD_JSP;
		title = "Edit Object Head";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchMinorSubHead(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		String MinorSubHeadCode = null;
		String MinorSubHeadName = null;
		String searchfield = null;
		int searchradio = 1;

		if (request.getParameter(code) != null
				&& !(request.getParameter(CODE).equals(""))) {
			MinorSubHeadCode = request.getParameter(code);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			MinorSubHeadName = request.getParameter(SEARCH_NAME);
		}
		try {

			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchfield = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchradio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchradio == 1) {
			MinorSubHeadCode = searchfield;
			MinorSubHeadName = null;
		} else {
			MinorSubHeadCode = null;
			MinorSubHeadName = searchfield;
		}
		map = budgetHandlerService.searchMinorSubHead(MinorSubHeadCode,
				MinorSubHeadName);
		jsp = "minorSubHead";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("MinorSubHeadCode", MinorSubHeadCode);
		map.put("MinorSubHeadName", MinorSubHeadName);
		return new ModelAndView("index", "map", map);

	}

	// -------------object Head----------------------------//
	public ModelAndView showObjectHead(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		map = budgetHandlerService.showObjectHead();
		String jsp = "objectHead";
		jsp += ".jsp";
		title = "objecthead";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addObjectHead(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		BudObjectHead objecthead = new BudObjectHead();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		Date toDate = null;
		Date fromDate = null;
		String objectheadCode = null;
		String objectheadName = null;
		String fundAllocated = null;
		int majorheadId = 0;
		int submajorheadId = 0;
		int minorsubheadId = 0;
		int minorheadId=0;
		int Sequenceno = 0;
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(MAJOR_HEAD_ID) != null
				&& !(request.getParameter(MAJOR_HEAD_ID).equals(""))) {
			majorheadId = Integer.parseInt(request.getParameter(MAJOR_HEAD_ID));
		}
		
		if (request.getParameter(MAJOR_SUB_HEAD_ID) != null
				&& !(request.getParameter(MAJOR_SUB_HEAD_ID).equals(""))) {
			submajorheadId = Integer.parseInt(request
					.getParameter(MAJOR_SUB_HEAD_ID));
		}
		if (request.getParameter("minorHeadId1") != null
				&& !(request.getParameter("minorHeadId1").equals(""))) {
			minorheadId = Integer.parseInt(request
					.getParameter("minorHeadId1"));
		}
		
		if (request.getParameter(MINOR_SUB_HEAD_ID) != null
				&& !(request.getParameter(MINOR_SUB_HEAD_ID).equals(""))) {
			minorsubheadId = Integer.parseInt(request
					.getParameter(MINOR_SUB_HEAD_ID));
		}
		
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));

		}
		if (request.getParameter(SEQUENCE_NO) != null
				&& !(request.getParameter(SEQUENCE_NO).equals(""))) {
			Sequenceno = Integer.parseInt(request.getParameter(SEQUENCE_NO));

		}
		if (request.getParameter(FUND_ALLOCATED) != null
				&& !(request.getParameter(FUND_ALLOCATED).equals(""))) {
			fundAllocated = request.getParameter(FUND_ALLOCATED);

		}

		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		int hospitalId = 0;
		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("majorheadId", majorheadId);
		generalMap.put("submajorheadId", submajorheadId);
		generalMap.put("minorsubheadId", minorsubheadId);
		generalMap.put("minorheadId", minorheadId);		
		generalMap.put("Sequenceno", Sequenceno);
		generalMap.put("fundAllocated", fundAllocated);
		generalMap.put("changedBy", changedBy);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		listMap = budgetHandlerService.checkForExistingMasters(generalMap);
		List objectheadCodeList = new ArrayList();
		List objectheadNameList = new ArrayList();
		if (listMap.get("duplicateGeneralCodeList") != null) {
			objectheadCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			objectheadNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((objectheadCodeList.size() == 0 || objectheadCodeList == null)
				&& (objectheadNameList.size() == 0 || objectheadNameList == null))

		{
			objecthead.setObjectHeadCode(code);
			objecthead.setObjectHeadName(name);
			BudMajorHead majorHead = new BudMajorHead();
			majorHead.setId(majorheadId);
			objecthead.setMajorHeadId(majorHead);
			BudSubMajorHead subHead = new BudSubMajorHead();
			subHead.setId(submajorheadId);
			objecthead.setMajorSubHeadId(subHead);
			BudMinorSubHead minorSubHead1 = new BudMinorSubHead();
			minorSubHead1.setId(minorsubheadId);
			objecthead.setMinorSubHeadId(minorSubHead1);
			BudMinorHead minorHead=new BudMinorHead();
			minorHead.setId(minorheadId);
			objecthead.setMinorHeadId(minorHead);
			objecthead.setSequenceNo(Sequenceno);
			objecthead.setFundAllocatedOfficer(fundAllocated);
			objecthead.setHospitalId(hospitalId);
			objecthead.setStatus("y");
			objecthead.setLastChgDate(currentDate);
			objecthead.setLastChgBy(changedBy);
			objecthead.setLastChgTime(currentTime);
			successfullyAdded = budgetHandlerService.addObjectHead(objecthead);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";

			}
		} else if ((objectheadCodeList.size() != 0 || objectheadCodeList != null)
				|| (objectheadNameList.size() != 0)
				|| objectheadNameList != null) {

			if ((objectheadCodeList.size() != 0 || objectheadCodeList != null)
					&& (objectheadNameList.size() == 0 || objectheadNameList == null)) {

				message = "Object Head Code  already exists.";
			} else if ((objectheadCodeList.size() != 0 || objectheadCodeList != null)
					&& (objectheadNameList.size() == 0 || objectheadNameList == null)) {

				message = "ObjectHead Name  already exists.";
			} else if ((objectheadCodeList.size() != 0 || objectheadCodeList != null)
					&& (objectheadNameList.size() != 0 || objectheadNameList != null)) {

				message = "ObjectHead Code and Object Head Name already exist.";
			}
		}

		url = "/hms/hms/budget?method=showObjectHead";

		try {
			map = budgetHandlerService.showObjectHead();

		} catch (Exception e) {
			e.printStackTrace();

		}
		String jsp = BUGD_OBJECT_HEAD_JSP;
		title = "Add object Head";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editMinorSubHead(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String minorsubheadCode = "";
		String minorsubheadName = "";
		int submajorheadId = 0;
		int minorsubheadId = 0;
		String changedBy = "";

		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		if (request.getParameter(MINOR_HEAD_ID) != null
				&& !(request.getParameter(MINOR_HEAD_ID).equals("0"))) {
			submajorheadId = Integer.parseInt(request
					.getParameter(MINOR_HEAD_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			minorsubheadId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			minorsubheadCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			minorsubheadName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", minorsubheadId);
		generalMap.put("countryCode", minorsubheadCode);
		generalMap.put("name", minorsubheadName);
		generalMap.put("currencyId", submajorheadId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCountryNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingCountryNameList.size() == 0) {
			dataUpdated = budgetHandlerService.editMinorSubHead(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingCountryNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/account?method=showMinorSubHead";
		try {
			map = budgetHandlerService.showMinorSubHead();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BUGD_MINOR_SUB_HEAD_JSP;
		title = "Edit Minor Sub Head";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteObjectHead(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int objectheadId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			objectheadId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		
		boolean dataDeleted = false;
		dataDeleted = budgetHandlerService.deleteObjectHead(objectheadId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/account?method=showObjectHead";
		try {
			map = budgetHandlerService.showObjectHead();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BUGD_OBJECT_HEAD_JSP;
		title = "delete object major head";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchsubmajorHead(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String submajorheadCode = null;
		String submajorheadName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			submajorheadCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			submajorheadName = request.getParameter(SEARCH_NAME);
		}

		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}
			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchRadio == 1) {
			submajorheadCode = searchField;
			submajorheadName = null;
		} else {
			submajorheadCode = null;
			submajorheadName = searchField;
		}
		map = budgetHandlerService.searchsubmajorHead(submajorheadCode,
				submajorheadName);

		jsp = BUGD_SUB_MAJOR_HEAD_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("submajorheadCode", submajorheadCode);
		map.put("submajorheadName", submajorheadName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchObjectHead(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String objectheadCode = null;
		String objectheadName = null;
		String searchField = null;
		int searchRadio = 1;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			objectheadCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			objectheadName = request.getParameter(SEARCH_NAME);
		}

		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			objectheadCode = searchField;
			objectheadName = null;
		} else {
			objectheadCode = null;
			objectheadName = searchField;
		}

		map = budgetHandlerService.searchObjectHead(objectheadCode,
				objectheadName);

		jsp = "objectHead";
		jsp += ".jsp";

		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("objectheadCode", objectheadCode);
		map.put("objectheadName", objectheadName);
		return new ModelAndView("index", "map", map);
	}

	// ----------Budget Estimate Entry--------------------//
	// -----------By: Ujjwal-------------------------------//
	public ModelAndView showBudgetEstimateEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String sectorType=null;
		if(request.getParameter(SECTOR_TYPE)!=null){
			sectorType=request.getParameter(SECTOR_TYPE);
		}
		map = budgetHandlerService.showBudgetEstimateEntry();
		String jsp = BUGD_ESTIMATE_ENTRY_JSP;
		jsp += ".jsp";
		title = "Estimate Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addBudget(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<BudEstimateEntry> searchEstimateEntryList = new ArrayList();
		BudEstimateEntry estimate = new BudEstimateEntry();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		Date encashDate = new Date();
		Date fromDate = null;
		String objectheadCode = null;
		String objectheadName = null;
		String sectorType = null;
		String financialYear = null;
		int majorheadId = 0;
		int submajorheadId = 0;
		int minorsubheadId = 0;
		int minorheadId = 0;
		int objectheadId = 0;
		BigDecimal excessAmount = new BigDecimal(0);
		BigDecimal savingAmount = new BigDecimal(0);
		BigDecimal Name = new BigDecimal(0);

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			Name = new BigDecimal(request.getParameter(SEARCH_NAME));
		}
		if (request.getParameter(ENCASH_DATE) != null
				&& !(request.getParameter(ENCASH_DATE).equals(""))) {
			encashDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(ENCASH_DATE));

		}
		
		if (request.getParameter(MAJOR_HEAD_ID) != null
				&& !(request.getParameter(MAJOR_HEAD_ID).equals(""))) {
			majorheadId = Integer.parseInt(request.getParameter(MAJOR_HEAD_ID));
		}
		if (request.getParameter(MAJOR_SUB_HEAD_ID) != null
				&& !(request.getParameter(MAJOR_SUB_HEAD_ID).equals(""))) {
			submajorheadId = Integer.parseInt(request
					.getParameter(MAJOR_SUB_HEAD_ID));
		}
		if (request.getParameter("minorHeadId1") != null
				&& !(request.getParameter("minorHeadId1").equals(""))) {
			minorheadId = Integer.parseInt(request
					.getParameter("minorHeadId1"));
		}

		if (request.getParameter(MINOR_SUB_HEAD_ID) != null
				&& !(request.getParameter(MINOR_SUB_HEAD_ID).equals(""))) {
			minorsubheadId = Integer.parseInt(request
					.getParameter(MINOR_SUB_HEAD_ID));
		}
		if (request.getParameter(OBJECT_HEAD_ID) != null
				&& !(request.getParameter(OBJECT_HEAD_ID).equals(""))) {
			objectheadId = Integer.parseInt(request
					.getParameter(OBJECT_HEAD_ID));
		}
		if (request.getParameter(SECTOR_TYPE) != null
				&& !(request.getParameter(SECTOR_TYPE).equals(""))) {

			sectorType = request.getParameter(SECTOR_TYPE);
		}
		
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));

		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		int hospitalId = 0;
		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("majorheadId", majorheadId);
		generalMap.put("submajorheadId", submajorheadId);
		generalMap.put("minorheadId", minorheadId);
		generalMap.put("minorsubheadId", minorsubheadId);
		generalMap.put("objectheadId", objectheadId);
		generalMap.put("sectorType", sectorType);
		generalMap.put("changedBy", changedBy);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		generalMap.put("encashDate", encashDate);
		
		
		// generalMap.put("hospitalId", hospitalId);
		listMap = budgetHandlerService.checkForExistingMasters(generalMap);
		List demandnoList = new ArrayList();
		List amountList = new ArrayList();
		if (listMap.get("duplicateGeneralCodeList") != null) {
			demandnoList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			amountList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((demandnoList.size() == 0 || demandnoList == null)
				&& (amountList.size() == 0 || amountList == null))

		{
			estimate.setDemandNo(code);
			estimate.setAmount(Name);
			BudMajorHead majorHead = new BudMajorHead();
			majorHead.setId(majorheadId);
			estimate.setMajorHeadId(majorHead);
			BudSubMajorHead subMajorHead = new BudSubMajorHead();
			subMajorHead.setId(submajorheadId);
			estimate.setMajorSubHeadId(subMajorHead);
			BudMinorHead minor=new BudMinorHead();
			minor.setId(minorheadId);
			estimate.setMinorHeadId(minor);
			BudMinorSubHead minorHead = new BudMinorSubHead();
			minorHead.setId(minorsubheadId);
			estimate.setMinorSubHeadId(minorHead);

			/*BudObjectHead objectHead = new BudObjectHead();
			objectHead.setId(objectheadId);
			estimate.setObjectHeadId(objectHead);
			estimate.setSectorType(sectorType);*/
			estimate.setStatus("y");
			estimate.setLastChgDate(currentDate);
			estimate.setLastChgBy(changedBy);
			estimate.setLastChgTime(currentTime);
			estimate.setHospitalId(hospitalId);
			estimate.setEstimetionDate(encashDate);
			// estimate.setFYear(masFinancialYear);
			estimate.setExcessAmount(excessAmount);
			estimate.setSavingAmount(savingAmount);
			estimate.setStartingEstimetionAmount(Name);
			successfullyAdded = budgetHandlerService.addBudget(estimate ,encashDate,objectheadId,sectorType);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Already Exist !!";

			}
		} else if ((demandnoList.size() != 0 || demandnoList != null)
				|| (amountList.size() != 0) || amountList != null) {

			if ((demandnoList.size() != 0 || demandnoList != null)
					&& (amountList.size() == 0 || amountList == null)) {

				message = "Object Head Code  already exists.";
			} else if ((demandnoList.size() != 0 || demandnoList != null)
					&& (amountList.size() == 0 || amountList == null)) {

				message = "ObjectHead Name  already exists.";
			} else if ((demandnoList.size() != 0 || demandnoList != null)
					&& (amountList.size() != 0 || amountList != null)) {

				message = "ObjectHead Code and Object Head Name already exist.";
			}
		}

		url = "/hms/hms/budget?method=showBudgetEstimateEntry";

		try {
			map = budgetHandlerService.showBudgetEstimateEntry();

		} catch (Exception e) {
			e.printStackTrace();

		}
		String jsp = BUGD_ESTIMATE_ENTRY_JSP;
		title = "Add Budget";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showsearchBudgetEstimateEntry(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BudEstimateEntry> searchEstimateEntryList = new ArrayList();
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		map = budgetHandlerService.showsearchBudgetEstimateEntry(code);
		String jsp = BUGD_ESTIMATE_ENTRY_JSP_SEARCH;
		jsp += ".jsp";
		title = "Estimate Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchBudgetEstimateEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int code1 = 0;
		List<BudEstimateEntry> searchEstimateEntryList = new ArrayList();
		if (request.getParameter(CODE) != null) {
			code1 = Integer.parseInt(request.getParameter(CODE));
		}
		
		map = budgetHandlerService.searchBudgetEstimateEntry(code1);
		String jsp = "searchDemandNo";
		jsp += ".jsp";
		title = "Estimate Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);

	}

	public ModelAndView showListOfNewItemsIntroduced(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String jsp = "listOfNewItemsIntroduced" + ".jsp";
		map.put("contentJsp", jsp);
		return (new ModelAndView("index", "map", map));

	}

	public ModelAndView showVoucherContingentBill(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		map = budgetHandlerService.showVoucherContingentBill();
		String jsp = BUGD_VOUCHER_BILL_ENTRY;
		jsp += ".jsp";
		title = "Estimate Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addVoucher(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		boolean b = budgetHandlerService.addVoucher(box);
		url = "/hms/hms/budget?method=showVoucherContingentBill";
		String message = "Budget Details have been Submitted !";
		map.put("message", message);
		jsp = "messageForVoucher";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	/*
	 * public ModelAndView submitVoucher(HttpServletRequest request,
	 * HttpServletResponse response) { Map<String, Object> map = new
	 * HashMap<String, Object>();
	 * 
	 * HttpSession session = request.getSession();
	 * 
	 * Box box = HMSUtil.getBox(request);
	 * 
	 * int hospitalId = 0; int departmentId = 0; if
	 * (session.getAttribute(HOSPITAL_ID) != null) { hospitalId = (Integer)
	 * session.getAttribute(HOSPITAL_ID); box.put("hospitalId", hospitalId); }
	 * if (session.getAttribute("deptId") != null) { departmentId = (Integer)
	 * session.getAttribute("deptId"); box.put("departmentId", departmentId); }
	 * if (session.getAttribute("users") != null) { Users user = (Users)
	 * session.getAttribute("users"); box.put("userId", user.getId()); } String
	 * billNo = budgetHandlerService.generateOrderNumber(); box.put("orderNo",
	 * billNo); String jsp = ""; String printUrl = ""; String url = ""; String
	 * message = ""; boolean saved = false; saved =
	 * budgetHandlerService.submitVoucher(box);
	 * 
	 * 
	 * if (saved) { message ="Record Saved Successfully!! Bill No Is "+billNo+
	 * "  Do you want to print Charge Slip?";
	 * 
	 * } else { message = "Try Again!"; } map.put("message", message); jsp =
	 * "message"; jsp +=".jsp"; map.put("contentJsp", jsp); map.put("billNo",
	 * billNo); return new ModelAndView("index", "map", map); }
	 */

	public ModelAndView showFinancialyearReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "financialReport";
		jsp += ".jsp";
		title = "financialyear";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView generatefinancialyearReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		String fromDate = null;
		String toDate = null;
		String reportName = "";

		if (request.getParameter(START_DATE) != null) {
			fromDate = request.getParameter(START_DATE);
		}
		
		if (request.getParameter(END_DATE) != null) {
			toDate = request.getParameter(END_DATE);

		}
		
		if (request.getParameter("JASPER_FILE_NAME") != null && !(request.getParameter("JASPER_FILE_NAME").equals("")))
		{
			reportName = (request.getParameter("JASPER_FILE_NAME"));
		}
		
		parameters.put("fromDate", HMSUtil
				.convertStringTypeDateToDateType(fromDate));
		parameters.put("toDate", HMSUtil
				.convertStringTypeDateToDateType(toDate));
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		// billingHandlerService.executeProcedureForReport(parameters);

		parameters.put("HOSPITAL_ID", hospitalId);
		detailsMap = budgetHandlerService.getConnectionForReport();
		// parameters.put("toRefundDate",
		// HMSUtil.convertStringTypeDateToDateType(toDate));

		HMSUtil.generateReport("Bud_financial_year_report", parameters, (Connection) detailsMap
				.get("con"), response, getServletContext());


		return null;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getHospitalParameterDetails(
			HttpServletRequest request) {
		int hospitalId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<MasSetupParameterMaintaince> masSetupParameterMaintainceList = new ArrayList<MasSetupParameterMaintaince>();
		hospitalId = Integer.parseInt(request.getSession().getAttribute(
				HOSPITAL_ID).toString());
		dataMap.put(HOSPITAL_ID, hospitalId);
		dataMap = hospitalDetailsMasterHandlerService
				.getSetupParameterMap(dataMap);
		if (dataMap.get("masSetupParameterMaintainceList") != null) {
			masSetupParameterMaintainceList = (List<MasSetupParameterMaintaince>) dataMap
					.get("masSetupParameterMaintainceList");
			dataMap.put("hospitalName", masSetupParameterMaintainceList.get(0)
					.getHospital().getHospitalName());
			dataMap.put("hospitalAddress", masSetupParameterMaintainceList.get(
					0).getHospital().getAddress());
		}
		return dataMap;
	}

	public ModelAndView searchEstimation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int demandNo = 0;
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			demandNo = Integer.parseInt(request.getParameter(CODE));
		}
		map = budgetHandlerService.searchEstimation(demandNo);

		String jsp = SEARCH_DEMAND_NO_JSP;
		jsp += ".jsp";
		title = "Student Certificate Admission";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showBudgetReappropEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int financialId=0;
		if(request.getParameter("financialId")!=null  ){
			financialId=Integer.parseInt(request.getParameter("financialId"));
			}
		
		map = budgetHandlerService.showBudgetReappropEntry(financialId);
		String jsp = BUGD_REAPPROP_ENTRY_JSP;
		jsp += ".jsp";
		title = "Reapprop Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addBudgetreapprop(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		BudReAppropEntry reAppropEntry = new BudReAppropEntry();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		Date toDate = null;
		Date fromDate = null;
		String appropriationType = null;
		BigDecimal appropriationAmount = new BigDecimal(0);
		int majorheadId = 0;
		int submajorheadId = 0;
		int minorsubheadId = 0;
		int objectheadId = 0;
		int financialId = 0;
		String sectorType = null;
		int budgetId = 0;
		int	minorheadId=0;
		BigDecimal excessAmount = new BigDecimal(0);
		String reApp = "";
		if (request.getParameter(CODE) != null) {
			appropriationType = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			appropriationAmount = new BigDecimal(request
					.getParameter(SEARCH_NAME));
		}
		if (request.getParameter("MajorHeadId1") != null) {

			
			majorheadId = Integer
					.parseInt(request.getParameter("MajorHeadId1"));
		}
		
		if (request.getParameter("subMajorHeadId1") != null) {
			submajorheadId = Integer.parseInt(request
					.getParameter("subMajorHeadId1"));
		}
		if (request.getParameter("subMinorHeadId1") != null) {
			minorsubheadId = Integer.parseInt(request
					.getParameter("subMinorHeadId1"));
		}
		if (request.getParameter("objectHeadId1") != null) {
			objectheadId = Integer.parseInt(request
					.getParameter("objectHeadId1"));
		}
		if (request.getParameter("budgetId") != null) {
			budgetId = Integer.parseInt(request.getParameter("budgetId"));
		}
		if (request.getParameter("financialHeadId1") != null) {
			financialId = Integer.parseInt(request
					.getParameter("financialHeadId1"));
		}
		if (request.getParameter(SECTOR_TYPE) != null
				&& !(request.getParameter(SECTOR_TYPE).equals(""))) {
			sectorType = request.getParameter(SECTOR_TYPE);
		}
		if (request.getParameter("excessAmount") != null
				&& !(request.getParameter("excessAmount").equals(""))) {
			excessAmount = new BigDecimal(request.getParameter("excessAmount"));
		}
		if (request.getParameter("minorHeadId1") != null
				&& !(request.getParameter("minorHeadId1").equals(""))) {
			minorheadId = Integer.parseInt(request
					.getParameter("minorHeadId1"));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));

		}

		if (request.getParameter(REAPP_NO) != null
				&& !(request.getParameter(REAPP_NO).equals(""))) {
			reApp = request.getParameter(REAPP_NO);

		}

		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		int hospitalId = 0;
		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		map.put("appropriationType", appropriationType);
		map.put("appropriationAmount", appropriationAmount);
		map.put("majorheadId", majorheadId);
		map.put("submajorheadId", submajorheadId);
		map.put("minorsubheadId", minorsubheadId);
		map.put("objectheadId", objectheadId);
		map.put("sectorType", sectorType);
		map.put("reApp", reApp);
		map.put("financialId", financialId);
		map.put("budgetId", budgetId);
		map.put("excessAmount", excessAmount);
		map.put("changedBy", changedBy);
		map.put("currentDate", currentDate);
		map.put("pojoPropertyCode", pojoPropertyCode);
		map.put("pojoName", pojoName);
		map.put("minorheadId", minorheadId);		
		
		reAppropEntry.setType(appropriationType);

		reAppropEntry.setReappamount(appropriationAmount);

		BudMajorHead majorHead = new BudMajorHead();
		majorHead.setId(majorheadId);
		
		reAppropEntry.setMajorHead(majorHead);

		BudSubMajorHead subHead = new BudSubMajorHead();
		subHead.setId(submajorheadId);
		reAppropEntry.setMajorSubHead(subHead);

		BudMinorSubHead minorSubHead = new BudMinorSubHead();
		minorSubHead.setId(minorsubheadId);
		reAppropEntry.setMinorSubHead(minorSubHead);

		BudObjectHead objectHead = new BudObjectHead();
		objectHead.setId(objectheadId);
		reAppropEntry.setObjectHead(objectHead);
		BudMinorHead minorHead=new BudMinorHead();
		minorHead.setId(minorheadId);
		reAppropEntry.setMinorHead(minorHead);

		/*
		 * HrMasFinancialYear financial=new HrMasFinancialYear();
		 * financial.setId(financialId);
		 * reAppropEntry.setFinancial(financial)(financial);
		 */
		reAppropEntry.setReAppropNo(reApp);
		HrMasFinancialYear masfinancial=new HrMasFinancialYear();
		masfinancial.setId(financialId);
		reAppropEntry.setFinancial(masfinancial);

		BudEstimateEntry estimate = new BudEstimateEntry();
		estimate.setId(budgetId);
		reAppropEntry.setBudget(estimate);
		reAppropEntry.setStatus("y");
		reAppropEntry.setLastChgDate(currentDate);
		reAppropEntry.setLastChgBy(changedBy);
		reAppropEntry.setLastChgTime(currentTime);

			
		boolean successfullyAdded = false;
		successfullyAdded = budgetHandlerService
				.addBudgetreapprop(reAppropEntry,budgetId);
		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";

		}

		url = "/hms/hms/budget?method=showResponse";

		try {
			map = budgetHandlerService.showResponse(objectheadId,financialId,sectorType);

		} catch (Exception e) {
			e.printStackTrace();

		}
		String jsp = BUGD_RESPONSE;
		title = "Add ReApp";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public void fillHeadNames(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String objectHead = "";
		if (request.getParameter("objectHead") != null
				&& !request.getParameter("objectHead").equals(""))
			;
		{
			objectHead = request.getParameter("objectHead");
			
		}
		map = budgetHandlerService.getNameTitle(objectHead);

		List<BudEstimateEntry> estimateList = new ArrayList<BudEstimateEntry>();

		if (map.get("estimateList") != null) {
			estimateList = (List) map.get("estimateList");
		}

		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			for (BudEstimateEntry estimateentry : estimateList) {
				
				sb.append("<item>");
				String majorHeadName = "";
				String lastName = "";
				if (estimateentry.getMajorHeadId().getMajorHeadName() != null) {
					majorHeadName = estimateentry.getMajorHeadId()
							.getMajorHeadName();
				}
				majorHeadName = estimateentry.getMajorHeadId()
						.getMajorHeadName();

				if (estimateentry.getMajorHeadId().getMajorHeadName() != null) {
					sb.append("<majorname>" + majorHeadName + "</majorname>");
				}
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
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public ModelAndView updateEstimateEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String demandNo = "";
		BigDecimal amount = new BigDecimal(0);
		int submajorheadId = 0;
		int budgetId = 0;
		String changedBy = "";
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			budgetId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(SUB_MAJOR_HEAD_ID) != null
				&& !(request.getParameter(SUB_MAJOR_HEAD_ID).equals(""))) {
			submajorheadId = Integer.parseInt(request
					.getParameter(SUB_MAJOR_HEAD_ID));
		}
		

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			demandNo = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			amount = new BigDecimal(request.getParameter(SEARCH_NAME));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}

		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", budgetId);
		generalMap.put("countryCode", demandNo);
		generalMap.put("Name", amount);
		generalMap.put("currencyId", submajorheadId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCountryNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingCountryNameList.size() == 0) {
			dataUpdated = budgetHandlerService.updateEstimateEntry(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingCountryNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/budget?method=showBudgetEstimateEntry";
		try {
			map = budgetHandlerService.showBudgetEstimateEntry();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BUGD_OBJECT_HEAD_JSP;
		title = "Edit Object Head";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showResponse(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int objectheadId = 0;
		int financialId=0;
		String sectorType=null;
		List<BudReAppropEntry> searchBudReAppropEntry = new ArrayList();
		if (request.getParameter(OBJECT_HEAD_ID) != null) {
			objectheadId = Integer.parseInt(request
					.getParameter(OBJECT_HEAD_ID));
		}
		if (request.getParameter(FINANCIAL_ID) != null) {
			financialId = Integer.parseInt(request
					.getParameter(FINANCIAL_ID));
		}	
		if (request.getParameter(SECTOR_TYPE) != null) {
			sectorType = request.getParameter(SECTOR_TYPE);
		}
		
		map = budgetHandlerService.showResponse(objectheadId,financialId,sectorType);
		String jsp = BUGD_RESPONSE;
		jsp += ".jsp";
		title = "Reappro ";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);

	}
	public ModelAndView searchBudgetReAppropEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int code1 = 0;
		List<BudReAppropEntry> searchReAppropEntryList = new ArrayList();
		if (request.getParameter(CODE) != null) {
			code1 = Integer.parseInt(request.getParameter(CODE));
		}
		
		map = budgetHandlerService.searchBudgetReAppropEntry(code1);
		String jsp = "searchReapprop";
		jsp += ".jsp";
		title = "Estimate Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);

	}
	@SuppressWarnings({ "unchecked", "unchecked", "unchecked" })
	public ModelAndView	getMaxEquipmentDate(HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		int financialId = 0;
		List<BudEstimateEntry> searchEstimaetEntryList = new ArrayList();
		if (request.getParameter(FINANCIAL_ID) != null) {
			financialId = Integer.parseInt(request.getParameter(FINANCIAL_ID));
		}
		
		String jsp="budgetEstimateEntryJsp";
		map = budgetHandlerService.getMaxEquipmentDate(financialId);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showVoucherReceiptEntry(HttpServletRequest request,
			HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			map = budgetHandlerService.showVoucherReceiptEntry();
			String jsp = "voucherReceiptEntry";
			jsp += ".jsp";
			title = "Reapprop Entry";
			map.put("contentJsp", jsp);
			map.put("title", title);

			return new ModelAndView("index", "map", map);

			}
	
	public ModelAndView showReceipt(HttpServletRequest request,
			HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			int financialId=0;
			int objectheadId = 0;
			String sectorType=null;
			List<BudReAppropEntry> searchBudReAppropEntry = new ArrayList();
			if (request.getParameter(OBJECT_HEAD_ID) != null) {
			objectheadId = Integer.parseInt(request
			.getParameter(OBJECT_HEAD_ID));
			}
			if (request.getParameter(SECTOR_TYPE) != null) {
			sectorType = request.getParameter(SECTOR_TYPE);
			}
			if (request.getParameter(FINANCIAL_ID) != null) {
			financialId = Integer.parseInt(request
			.getParameter(FINANCIAL_ID));
			}

			map = budgetHandlerService.showReceipt(objectheadId,sectorType,financialId);
			String jsp = BUGD_REECEIPT;
			jsp += ".jsp";
			title = "Reappro ";
			map.put("contentJsp", jsp);
			map.put("title", title);

			return new ModelAndView("index", "map", map);

			}
	@SuppressWarnings("unchecked")
	public ModelAndView addReceiptVoucher(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<BudEstimateEntry> searchEstimateEntryList = new ArrayList();
		BudVoucherReceiptEntry estimate = new BudVoucherReceiptEntry();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String receiptDate = null;
		Date newReceiptDate =null;
		Date fromDate = null;
		String objectheadCode = null;
		String objectheadName = null;
		String sectorType = null;
		String financialYear = null;
		int majorheadId = 0;
		int submajorheadId = 0;
		int minorsubheadId = 0;
		int objectheadId = 0;
		int budgetId=0;
		int financialId = 0;
		int minorheadId=0;
		BigDecimal excessAmount = new BigDecimal(0);
		BigDecimal savingAmount = new BigDecimal(0);
		BigDecimal Name = new BigDecimal(0);

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			Name = new BigDecimal(request.getParameter(SEARCH_NAME));
		}
		
		if (request.getParameter(RECEIPT_DATE) != null
				&& !(request.getParameter(RECEIPT_DATE).equals(""))) {
			receiptDate = request.getParameter(RECEIPT_DATE);
			newReceiptDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(RECEIPT_DATE));

		}

				
		if (request.getParameter(SECTOR_TYPE) != null
				&& !(request.getParameter(SECTOR_TYPE).equals(""))) {
			sectorType = request.getParameter(SECTOR_TYPE);
		}
		if (request.getParameter("MajorHeadId1") != null
				&& !(request.getParameter("MajorHeadId1").equals(""))) {
			majorheadId = Integer.parseInt(request.getParameter("MajorHeadId1"));
		}
		if (request.getParameter("subMajorHeadId1") != null
				&& !(request.getParameter("subMajorHeadId1").equals(""))) {
			submajorheadId = Integer.parseInt(request
					.getParameter("subMajorHeadId1"));
		}
			if (request.getParameter("minorHeadId1") != null
					&& !(request.getParameter("minorHeadId1").equals(""))) {
				minorheadId = Integer.parseInt(request
						.getParameter("minorHeadId1"));
			}
			
			if (request.getParameter("subMinorHeadId1") != null
					&& !(request.getParameter("subMinorHeadId1").equals(""))) {
				minorsubheadId = Integer.parseInt(request
						.getParameter("subMinorHeadId1"));
			}
			if (request.getParameter("budgetId") != null
				&& !(request.getParameter("budgetId").equals(""))) {
			objectheadId = Integer.parseInt(request.getParameter("budgetId"));
		}
		
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));

		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		if (request.getParameter("objectHeadId1") != null) {
			budgetId = Integer.parseInt(request.getParameter("objectHeadId1"));
		}
		int hospitalId = 0;
		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("budgetId", budgetId);
		generalMap.put("majorheadId", majorheadId);
		generalMap.put("submajorheadId", submajorheadId);
		generalMap.put("minorsubheadId", minorsubheadId);
		generalMap.put("objectheadId", objectheadId);
		generalMap.put("sectorType", sectorType);
		generalMap.put("changedBy", changedBy);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		generalMap.put("receiptDate", receiptDate);
		generalMap.put("currentDate", currentDate);
		boolean successfullyAdded = false;
		
		{
			estimate.setReceiptNo(code);
			estimate.setAmount(Name);
			estimate.setReceiptDate(newReceiptDate);
			BudMajorHead majorHead = new BudMajorHead();
			majorHead.setId(majorheadId);
			estimate.setMajorHead(majorHead);
			BudSubMajorHead subMajorHead = new BudSubMajorHead();
			subMajorHead.setId(submajorheadId);
			estimate.setMajorSubHead(subMajorHead);
			BudMinorHead mhead=new BudMinorHead();
			mhead.setId(minorheadId);
			estimate.setMinorbHead(mhead);
			BudMinorSubHead minorHead = new BudMinorSubHead();
			minorHead.setId(minorsubheadId);
			estimate.setMinorSubHead(minorHead);
			BudObjectHead objectHead = new BudObjectHead();
			objectHead.setId(objectheadId);
			estimate.setObjectHead(objectHead);
			estimate.setSectorType(sectorType);
			estimate.setStatus("y");
			estimate.setLastChgDate(currentDate);
			estimate.setLastChgBy(changedBy);
			
			estimate.setLastChgTime(currentTime);
			MasHospital hospital= new MasHospital(); 
			hospital.setId(hospitalId);
			estimate.setHospital(hospital);
			BudEstimateEntry budEstimateEntry=new BudEstimateEntry();
			budEstimateEntry.setId(budgetId);
			estimate.setBudgetEstimate(budEstimateEntry);
			successfullyAdded = budgetHandlerService.addReceiptVoucher(estimate,receiptDate);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";

			}
		} 
		url = "/hms/hms/budget?method=showReceipt";

		try {
			map = budgetHandlerService.showReceipt(objectheadId,sectorType,financialId);

		} catch (Exception e) {
			e.printStackTrace();

		}
		String jsp = "voucherReceiptEntry";
		title = "Add Budget";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchReceiptNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int code1 = 0;
		List<BudVoucherReceiptEntry> searchBudVoucherReceiptEntryList = new ArrayList();
		if (request.getParameter(CODE) != null) {
			code1 = Integer.parseInt(request.getParameter(CODE));
		}
		try{
		map = budgetHandlerService.searchReceiptNo(code1);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		String jsp = "searchReceiptNo";
		jsp += ".jsp";
		title = "Estimate Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);

	}
	public ModelAndView showMinorHead(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		@SuppressWarnings("unused")
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = budgetHandlerService.showMinorHead();
		String jsp = "minorHead";
		jsp += ".jsp";
		title = "minorSubHead";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView addMinorHead(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		BudMinorHead minorHead = new BudMinorHead();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		Date toDate = null;
		Date fromDate = null;
		String minorSubheadCode = null;
		String minorSubheadName = null;
		int submajorheadId = 0;
		int sequenceNo = 0;
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}

		if (request.getParameter(SUB_MAJOR_HEAD_ID) != null
				&& !(request.getParameter(SUB_MAJOR_HEAD_ID).equals(""))) {
			submajorheadId = Integer.parseInt(request
					.getParameter(SUB_MAJOR_HEAD_ID));
		}
		if (request.getParameter(SEQUENCE_NO) != null
				&& !(request.getParameter(SEQUENCE_NO).equals(""))) {
			sequenceNo = Integer.parseInt(request.getParameter(SEQUENCE_NO));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));

		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		int hospitalId = 0;
		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("majorheadId", submajorheadId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		listMap = budgetHandlerService.checkForExistingMasters(generalMap);
		List minorsubheadCodeList = new ArrayList();
		List minorsubheadNameList = new ArrayList();
		if (listMap.get("duplicateGeneralCodeList") != null) {
			minorsubheadCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			minorsubheadNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((minorsubheadCodeList.size() == 0 || minorsubheadCodeList == null)
				&& (minorsubheadNameList.size() == 0 || minorsubheadNameList == null))

		{
			minorHead.setMinorHeadCode(code);
			minorHead.setMinorHeadName(name);
			BudSubMajorHead subMajorHead = new BudSubMajorHead();
			subMajorHead.setId(submajorheadId);
			minorHead.setSubMajorHeadId(subMajorHead);
			minorHead.setSequenceNo(sequenceNo);
			minorHead.setStatus("y");
			minorHead.setLastChgBy(changedBy);
			minorHead.setLastChgTime(currentTime);
			minorHead.setLastChgDate(currentDate);
			MasHospital hospital=new MasHospital();
			hospital.setId(hospitalId);
			minorHead.setHospitalId(hospital);
			successfullyAdded = budgetHandlerService.addMinorHead(minorHead);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";

			}
		} else if ((minorsubheadCodeList.size() != 0 || minorsubheadCodeList != null)
				|| (minorsubheadNameList.size() != 0)
				|| minorsubheadNameList != null) {

			if ((minorsubheadCodeList.size() != 0 || minorsubheadCodeList != null)
					&& (minorsubheadNameList.size() == 0 || minorsubheadNameList == null)) {

				message = "Minor Head Code  already exists.";
			} else if ((minorsubheadCodeList.size() != 0 || minorsubheadCodeList != null)
					&& (minorsubheadNameList.size() == 0 || minorsubheadNameList == null)) {

				message = "Minor Head Name  already exists.";
			} else if ((minorsubheadCodeList.size() != 0 || minorsubheadCodeList != null)
					&& (minorsubheadNameList.size() != 0 || minorsubheadNameList != null)) {

				message = "Minor Head Code and Minor Sub Head Name already exist.";
			}
		}

		url = "/hms/hms/accountMaster?method=showMinorHead";

		try {
			map = budgetHandlerService.showMinorHead();

		} catch (Exception e) {
			e.printStackTrace();

		}
		String jsp = "minorHead";
		title = "Add Minor Sub Head";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView editMinorHead(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String minorsubheadCode = "";
		String minorsubheadName = "";
		int submajorheadId = 0;
		int minorsubheadId = 0;
		String changedBy = "";

		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		if (request.getParameter(SUB_MAJOR_HEAD_ID) != null
				&& !(request.getParameter(SUB_MAJOR_HEAD_ID).equals(""))) {
			submajorheadId = Integer.parseInt(request
					.getParameter(SUB_MAJOR_HEAD_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			minorsubheadId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			minorsubheadCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			minorsubheadName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", minorsubheadId);
		generalMap.put("countryCode", minorsubheadCode);
		generalMap.put("name", minorsubheadName);
		generalMap.put("currencyId", submajorheadId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCountryNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingCountryNameList.size() == 0) {
			dataUpdated = budgetHandlerService.editMinorHead(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingCountryNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/account?method=showMinorHead";
		try {
			map = budgetHandlerService.showMinorHead();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "minorHead";
		title = "Edit Minor  Head";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView deleteMinorHead(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int minorsubheadId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			minorsubheadId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		boolean dataDeleted = false;
		dataDeleted = budgetHandlerService.deleteMinorHead(minorsubheadId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showMinorHead";
		try {
			map = budgetHandlerService.showMinorHead();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "minorHead";
		title = "delete minor sub head";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editBudget(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String demandNo = "";
		String objectheadName = "";
		int submajorheadId = 0;
		int objectheadId = 0;
		String changedBy = "";
		Date changedDate = null;
		int financialId=0;
		int majorheadId=0;
		int minorheadId=0;
		int minorSubheadId=0;
		int objectHeadId=0;
		int estimateId=0;
		BigDecimal amount=new BigDecimal(0.0);
		@SuppressWarnings("unused")
		String changedTime = "";

		if (request.getParameter(FINANCIAL_ID) != null
				&& !(request.getParameter(FINANCIAL_ID).equals(""))) {
			financialId = Integer.parseInt(request
					.getParameter(FINANCIAL_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			estimateId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(MAJOR_SUB_HEAD_ID) != null
				&& !(request.getParameter(MAJOR_SUB_HEAD_ID).equals(""))) {
			submajorheadId = Integer.parseInt(request
					.getParameter(MAJOR_SUB_HEAD_ID));
		}
		if (request.getParameter(MAJOR_HEAD_ID) != null
				&& !(request.getParameter(MAJOR_HEAD_ID).equals(""))) {
			majorheadId = Integer.parseInt(request
					.getParameter(MAJOR_HEAD_ID));
		}
		if (request.getParameter("minorHeadId1") != null
				&& !(request.getParameter("minorHeadId1").equals(""))) {
			minorheadId = Integer.parseInt(request
					.getParameter("minorHeadId1"));
		}
		if (request.getParameter(MINOR_SUB_HEAD_ID) != null
				&& !(request.getParameter(MINOR_SUB_HEAD_ID).equals(""))) {
			minorSubheadId = Integer.parseInt(request
					.getParameter(MINOR_SUB_HEAD_ID));
		}
		if (request.getParameter(OBJECT_HEAD_ID) != null
				&& !(request.getParameter(OBJECT_HEAD_ID).equals(""))) {
			objectHeadId = Integer.parseInt(request
					.getParameter(OBJECT_HEAD_ID));
		}
			
		if (request.getParameter("code") != null
				&& !(request.getParameter("code").equals(""))) {
			demandNo = request.getParameter("code");
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			amount =new BigDecimal(request.getParameter(SEARCH_NAME)) ;
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}

		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", objectheadId);
		generalMap.put("countryCode", demandNo);
		generalMap.put("Name", amount);
		generalMap.put("financialId", financialId);
		generalMap.put("submajorheadId", submajorheadId);
		generalMap.put("majorheadId", majorheadId);
		generalMap.put("estimateId", estimateId);
		//generalMap.put("minorheadId", minorheadId);
		generalMap.put("minorSubheadId", minorSubheadId);
		generalMap.put("objectHeadId", objectHeadId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		
		boolean dataUpdated = false;
		
			dataUpdated = budgetHandlerService.editBudget(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		 
		url = "/hms/hms/budget?method=showBudgetEstimateEntry";
		try {
			map = budgetHandlerService.showBudgetEstimateEntry();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BUGD_ESTIMATE_ENTRY_JSP;
		title = "Edit Estimate Entry";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView	showReceipts(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		String sectorType=null;
		if(request.getParameter(SECTOR_TYPE)!=null){
			sectorType=request.getParameter(SECTOR_TYPE);
		}
		try{
		map = budgetHandlerService.showReceipts(sectorType);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = "rceiptss";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView generateReportForBudgetMasters(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> mapResponse = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
		int hospitalId = 0;
		String hospitalName = "";
		String jasper = null;
		if (request.getParameter(JASPER_FILE_NAME) != null) {
			jasper = request.getParameter(JASPER_FILE_NAME);
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			mapForDs.put("hospitalId", hospitalId);
			mapResponse = budgetHandlerService.getHospitalName(mapForDs);
		}

		if (mapResponse.get("masHospitaList") != null) {
			masHospitaList = (List) mapResponse.get("masHospitaList");
			hospitalName = masHospitaList.get(0).getHospitalName();
		}


		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("hospitalName", hospitalName);
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));
		Map<String, Object> connectionMap = budgetHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport(jasper, parameters,
				(Connection) connectionMap.get("conn"), response,
				getServletContext());
		return null;
	}
	public ModelAndView	showVoucherReportJsp(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
				try{
				map = budgetHandlerService.showVoucherReportJsp();
				}
				catch(Exception e){
					e.printStackTrace();
				}
				String jsp="voucherReportJsp";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				return new ModelAndView("index", "map", map);
	}
	public ModelAndView	generateReportForReappropritaion(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		Map<String, Object> mapResponse = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
		int hospitalId = 0;
		String hospitalName = "";
		String jasper = null;

		if (request.getParameter(JASPER_FILE_NAME) != null) {
			jasper = request.getParameter(JASPER_FILE_NAME);
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			mapForDs.put("hospitalId", hospitalId);
			mapResponse = budgetHandlerService.getHospitalName(mapForDs);
		}

		if (mapResponse.get("masHospitaList") != null) {
			masHospitaList = (List) mapResponse.get("masHospitaList");
			hospitalName = masHospitaList.get(0).getHospitalName();
		}


		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("hospitalName", hospitalName);
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));
		Map<String, Object> connectionMap = budgetHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport(jasper, parameters,
				(Connection) connectionMap.get("conn"), response,
				getServletContext());
		return null;
		
	}
	public ModelAndView editReceipt(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String demandNo = "";
		String objectheadName = "";
		int submajorheadId = 0;
		int objectheadId = 0;
		String changedBy = "";
		Date changedDate = null;
		int financialId=0;
		int majorheadId=0;
		int minorheadId=0;
		int minorSubheadId=0;
		int objectHeadId=0;
		int estimateId=0;
		BigDecimal amount=new BigDecimal(0.0);
		@SuppressWarnings("unused")
		String changedTime = "";

		if (request.getParameter(FINANCIAL_ID) != null
				&& !(request.getParameter(FINANCIAL_ID).equals(""))) {
			financialId = Integer.parseInt(request
					.getParameter(FINANCIAL_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			estimateId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(MAJOR_SUB_HEAD_ID) != null
				&& !(request.getParameter(MAJOR_SUB_HEAD_ID).equals(""))) {
			submajorheadId = Integer.parseInt(request
					.getParameter(MAJOR_SUB_HEAD_ID));
		}
		if (request.getParameter(MAJOR_HEAD_ID) != null
				&& !(request.getParameter(MAJOR_HEAD_ID).equals(""))) {
			majorheadId = Integer.parseInt(request
					.getParameter(MAJOR_HEAD_ID));
		}
		if (request.getParameter("minorHeadId1") != null
				&& !(request.getParameter("minorHeadId1").equals(""))) {
			minorheadId = Integer.parseInt(request
					.getParameter("minorHeadId1"));
		}
		if (request.getParameter(MINOR_SUB_HEAD_ID) != null
				&& !(request.getParameter(MINOR_SUB_HEAD_ID).equals(""))) {
			minorSubheadId = Integer.parseInt(request
					.getParameter(MINOR_SUB_HEAD_ID));
		}
		if (request.getParameter(OBJECT_HEAD_ID) != null
				&& !(request.getParameter(OBJECT_HEAD_ID).equals(""))) {
			objectHeadId = Integer.parseInt(request
					.getParameter(OBJECT_HEAD_ID));
		}
			
		if (request.getParameter("code") != null
				&& !(request.getParameter("code").equals(""))) {
			demandNo = request.getParameter("code");
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			amount =new BigDecimal(request.getParameter(SEARCH_NAME)) ;
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}

		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", objectheadId);
		generalMap.put("countryCode", demandNo);
		generalMap.put("Name", amount);
		generalMap.put("financialId", financialId);
		generalMap.put("submajorheadId", submajorheadId);
		generalMap.put("majorheadId", majorheadId);
		generalMap.put("estimateId", estimateId);
		//generalMap.put("minorheadId", minorheadId);
		generalMap.put("minorSubheadId", minorSubheadId);
		generalMap.put("objectHeadId", objectHeadId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		
		boolean dataUpdated = false;
		
			dataUpdated = budgetHandlerService.editReceipt(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		 
		url = "/hms/hms/budget?method=showVoucherReceiptEntry";
		try {
			map = budgetHandlerService.showVoucherReceiptEntry();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "voucherReceiptEntry";
		title = "Edit Estimate Entry";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView editReApprop(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String demandNo = "";
		String objectheadName = "";
		int submajorheadId = 0;
		int objectheadId = 0;
		String changedBy = "";
		Date changedDate = null;
		int financialId=0;
		int majorheadId=0;
		int minorheadId=0;
		int minorSubheadId=0;
		int objectHeadId=0;
		int estimateId=0;
		BigDecimal amount=new BigDecimal(0.0);
		String changedTime = "";
		
		if (request.getParameter(FINANCIAL_ID) != null
				&& !(request.getParameter(FINANCIAL_ID).equals(""))) {
			financialId = Integer.parseInt(request
					.getParameter(FINANCIAL_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			estimateId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(MAJOR_SUB_HEAD_ID) != null
				&& !(request.getParameter(MAJOR_SUB_HEAD_ID).equals(""))) {
			submajorheadId = Integer.parseInt(request
					.getParameter(MAJOR_SUB_HEAD_ID));
		}
		if (request.getParameter(MAJOR_HEAD_ID) != null
				&& !(request.getParameter(MAJOR_HEAD_ID).equals(""))) {
			majorheadId = Integer.parseInt(request
					.getParameter(MAJOR_HEAD_ID));
		}
		if (request.getParameter("minorHeadId1") != null
				&& !(request.getParameter("minorHeadId1").equals(""))) {
			minorheadId = Integer.parseInt(request
					.getParameter("minorHeadId1"));
		}
		if (request.getParameter(MINOR_SUB_HEAD_ID) != null
				&& !(request.getParameter(MINOR_SUB_HEAD_ID).equals(""))) {
			minorSubheadId = Integer.parseInt(request
					.getParameter(MINOR_SUB_HEAD_ID));
		}
		if (request.getParameter(OBJECT_HEAD_ID) != null
				&& !(request.getParameter(OBJECT_HEAD_ID).equals(""))) {
			objectHeadId = Integer.parseInt(request
					.getParameter(OBJECT_HEAD_ID));
		}
			
		if (request.getParameter("code") != null
				&& !(request.getParameter("code").equals(""))) {
			demandNo = request.getParameter("code");
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			amount =new BigDecimal(request.getParameter(SEARCH_NAME)) ;
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}

		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", objectheadId);
		generalMap.put("countryCode", demandNo);
		generalMap.put("Name", amount);
		generalMap.put("financialId", financialId);
		generalMap.put("submajorheadId", submajorheadId);
		generalMap.put("majorheadId", majorheadId);
		generalMap.put("estimateId", estimateId);
		//generalMap.put("minorheadId", minorheadId);
		generalMap.put("minorSubheadId", minorSubheadId);
		generalMap.put("objectHeadId", objectHeadId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		
		boolean dataUpdated = false;
		
			dataUpdated = budgetHandlerService.editReApprop(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		 
		url = "/hms/hms/budget?method=showBudgetReappropEntry";
		try {
			map = budgetHandlerService.showBudgetReappropEntry(financialId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "budget_reappropriation";
		title = "Edit ReAppprop Entry";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView	showVoucherReport(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		Map<String, Object> mapResponse = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
		int hospitalId = 0;
		String hospitalName = "";
		String jasper = null;
		String billNo = null;
		
		if (request.getParameter(JASPER_FILE_NAME) != null) {
			jasper = request.getParameter(JASPER_FILE_NAME);
		}
		if(request.getParameter(CODE)!=null)
		{
			billNo=request.getParameter(CODE);
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			mapForDs.put("hospitalId", hospitalId);
			mapResponse = budgetHandlerService.getHospitalName(mapForDs);
		}

		if (mapResponse.get("masHospitaList") != null) {
			masHospitaList = (List) mapResponse.get("masHospitaList");
			hospitalName = masHospitaList.get(0).getHospitalName();
		}


		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("hospitalName", hospitalName);
		//parameters.put("hospitalName", hospitalName);
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));
		Map<String, Object> connectionMap = budgetHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport(jasper, parameters,
				(Connection) connectionMap.get("conn"), response,
				getServletContext());
		return null;
		
		
	}
	public ModelAndView searchBillNo(HttpServletRequest request,
			HttpServletResponse response) {	
		Map<String, Object> map = new HashMap<String, Object>();
		int code1 = 0;
		List<BudVoucherHeader> searchBudVoucherHeaderList = new ArrayList();
		if (request.getParameter(CODE).trim()!= null) {
			code1 = Integer.parseInt(request.getParameter(CODE).trim());
		}
		try{
		map = budgetHandlerService.searchBillNo(code1);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		String jsp = "searchBillNo";
		jsp += ".jsp";
		title = "Estimate Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);

	}
	public ModelAndView printVoucherReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		/*Date fromDate = null;
		Date toDate = null;
		@SuppressWarnings("unused")
		Date currDate = null;
		String query="";*/
		String bill_no=null;
		Map<String, Object> parameters = new HashMap<String, Object>();
		String reportName="fully_voucher_report";

		if(request.getParameter(MAJOR_HEAD_ID) != null){
			bill_no = request.getParameter(MAJOR_HEAD_ID);
		}
		parameters.put("bill_no", bill_no);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = budgetHandlerService.getConnectionForReport();
		// parameters.put("stringVariable", stringVariable);
		HMSUtil.generateReport(reportName, parameters, (Connection)detailsMap.get("con"), response, getServletContext());
		return null;
		}	
	public ModelAndView	showAdviceJsp(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
				try{
				map = budgetHandlerService.showAdviceJsp();
				}
				catch(Exception e){
					e.printStackTrace();
				}
				String jsp="adviceJsp";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				return new ModelAndView("index", "map", map);
	}
	public ModelAndView printAdviceReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		@SuppressWarnings("unused")
		Date currDate = null;
		String query="";
		String bill_no=null;
		String objectHeadName=null;
		Map<String, Object> parameters = new HashMap<String, Object>();
		String reportName="advice_report";

		if(request.getParameter("bill_no") != null){
			bill_no = request.getParameter("bill_no");
		}

		if(request.getParameter("objectHeadName") != null){
			objectHeadName = request.getParameter("objectHeadName");
		}
		parameters.put("bill_no", bill_no);
		parameters.put("objectHeadName", objectHeadName);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = budgetHandlerService.getConnectionForReport();
		// parameters.put("stringVariable", stringVariable);
		HMSUtil.generateReport(reportName, parameters, (Connection)detailsMap.get("con"), response, getServletContext());
		return null;
		}	
	public ModelAndView	showDetailMonthlyExpenditure(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
				try{
				map = budgetHandlerService.showDetailMonthlyExpenditure();
				}
				catch(Exception e){
					e.printStackTrace();
				}
				String jsp="detailMonthlyExpenditure";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				return new ModelAndView("index", "map", map);
	}
	public ModelAndView printMonthlyExpenditure(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		@SuppressWarnings("unused")
		Date currDate = null;
		String query="";
		int minor_head_name=0;
		String sectorType=null;
		Map<String, Object> parameters = new HashMap<String, Object>();
		String reportName="VoucherWiseExpenditureReport";
		if(request.getParameter("sectorType") != null){
			sectorType = request.getParameter("sectorType");
		}

		if(request.getParameter("minor_head_name") != null){
			minor_head_name = Integer.parseInt(request.getParameter("minor_head_name"));
		}

		parameters.put("minor_head_name", minor_head_name);
		parameters.put("sectorType", sectorType);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = budgetHandlerService.getConnectionForReport();
		// parameters.put("stringVariable", stringVariable);
		HMSUtil.generateReport(reportName, parameters, (Connection)detailsMap.get("con"), response, getServletContext());
		return null;
		}	
	public ModelAndView	showApproprationRegister(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
				try{
				map = budgetHandlerService.showApproprationRegister(); 
				}
				catch(Exception e){
					e.printStackTrace();
				}
				String jsp="appropriationRegisterJsp";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				return new ModelAndView("index", "map", map);
	}	
	public ModelAndView printApproprationRegister(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		@SuppressWarnings("unused")
		Date currDate = null;
		String query="";
		int minor_head_name=0;
		String sectorType=null;
		Map<String, Object> parameters = new HashMap<String, Object>();
		String reportName="appropriation_register";
		if(request.getParameter("fromDate") != null){
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate") != null){
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("toDate"));
		}
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = budgetHandlerService.getConnectionForReport();
		// parameters.put("stringVariable", stringVariable);
		HMSUtil.generateReport(reportName, parameters, (Connection)detailsMap.get("con"), response, getServletContext());
		return null;
		}	
	public ModelAndView	showoMnthlyObjectWiseExpenditure(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
				try{
				map = budgetHandlerService.showoMnthlyObjectWiseExpenditure();
				}
				catch(Exception e){
					e.printStackTrace();
				}
				String jsp="monthlyObjectWiseExpenditureJsp";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				return new ModelAndView("index", "map", map);
	}
	public ModelAndView printMonthlyObjectWiseVoucherExpenditure(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		@SuppressWarnings("unused")
		Date currDate = null;
		String query="";
		int minor_head_name=0;
		String sectorType=null;
		Map<String, Object> parameters = new HashMap<String, Object>();
		String reportName="monthly_objectwise_voucher_expenditure_report";
		if(request.getParameter("fromDate") != null){
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("fromDate"));
		}
		
		if(request.getParameter("toDate") != null){
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("toDate"));
		}
		if(request.getParameter("sectorType") != null){
			sectorType = request.getParameter("sectorType");
		}

		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("sectorType", sectorType);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = budgetHandlerService.getConnectionForReport();
		HMSUtil.generateReport(reportName, parameters, (Connection)detailsMap.get("con"), response, getServletContext());
		return null;
		}	
	
	public ModelAndView	showoMnthlyMinorWiseExpenditure(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
				try{
				map = budgetHandlerService.showoMnthlyMinorWiseExpenditure();
				}
				catch(Exception e){
					e.printStackTrace();
				}
				String jsp="monthlyMinorWiseExpenditureJsp";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				return new ModelAndView("index", "map", map);
	}
	public ModelAndView printMonthlyMinorWiseVoucherExpenditure(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		Date currDate = null;
		String query="";
		int minor_head_name=0;
		String sectorType=null;
		Map<String, Object> parameters = new HashMap<String, Object>();
		String reportName="monthly_minorwise_voucher_expenditure_report";
		if(request.getParameter("fromDate") != null){
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("fromDate"));
		}
		
		if(request.getParameter("toDate") != null){
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("toDate"));
		}
		if(request.getParameter("sectorType") != null){
			sectorType = request.getParameter("sectorType");
		}

		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("sectorType", sectorType);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = budgetHandlerService.getConnectionForReport();
		HMSUtil.generateReport(reportName, parameters, (Connection)detailsMap.get("con"), response, getServletContext());
		return null;
		}
	public ModelAndView	showoReceiptVoucher(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
				try{
				map = budgetHandlerService.showoReceiptVoucher();
				}
				catch(Exception e){
					e.printStackTrace();
				}
				String jsp="receiptVoucherReportJsp";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				return new ModelAndView("index", "map", map);
	}
	public ModelAndView printVoucherReceipt(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<PojoForMasStoreItem> pojoParentList = new ArrayList<PojoForMasStoreItem>();
		Box box = HMSUtil.getBox(request);
		String fromDate="";
		String toDate="";
		Date date1 = new Date();
		Date date2 = new Date();
		session = request.getSession();
		try {

			if (request.getParameter("fromDate") != null
					&& !(request.getParameter("fromDate").equals(""))) {
				fromDate =(String)request.getParameter("fromDate");
				date1=HMSUtil.convertStringTypeDateToDateType(fromDate);
				requestParameters.put("date1", date1);
			}
			if (request.getParameter("toDate") != null
					&& !(request.getParameter("toDate").equals(""))) {
				toDate = (request.getParameter("toDate"));
				date2=HMSUtil.convertStringTypeDateToDateType(toDate);
				requestParameters.put("date2", date2);
			}
			int objectId=0;
			if (request.getParameter("object_id") != null
					&& !(request.getParameter("object_id").equals(""))) {
				objectId =Integer.parseInt(""+request.getParameter("object_id"));
				requestParameters.put("objectId", objectId);
			}
			dataMap = budgetHandlerService.getConnectionForReport();
			
			map=budgetHandlerService.printVoucherReceipt(requestParameters);
			String reportName="";
			reportName="receipt_voucher_report";
			HMSUtil.generateReport(reportName, requestParameters, (Connection)dataMap.get("con"), response, getServletContext());
		}	catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	public ModelAndView generateReceiptReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		try{
		dataMap = budgetHandlerService.getConnectionForReport();
		String reportName="";
		reportName="voucher_receipt";
		HMSUtil.generateReport(reportName, requestParameters, (Connection)dataMap.get("con"), response, getServletContext());
	}	catch (Exception e) {
			e.printStackTrace();
		}
	return null;
	}
		

	public ModelAndView	showPrintReceiptReport(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
				List<BudVoucherReceiptEntry> budVoucherReceiptEntryList = budgetHandlerService.getReceiptNumberList();
				String jsp="printReceiptReportJsp";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				return new ModelAndView("index", "map", map);
	}
	public ModelAndView showPrintVoucherReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = budgetHandlerService.showPrintVoucherReport();
				String jsp="printVoucherReportJsp";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				return new ModelAndView("index", "map", map);
	}

}
