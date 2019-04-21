package jkt.hrms.masters.controller;

import static jkt.hrms.util.HrmsRequestConstants.CHANGED_BY;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_DATE;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_TIME;
import static jkt.hrms.util.HrmsRequestConstants.CODE;
import static jkt.hrms.util.HrmsRequestConstants.COMMON_ID;
import static jkt.hrms.util.HrmsRequestConstants.HR_INSURANCE_MASTER_JSP;
import static jkt.hrms.util.HrmsRequestConstants.INSURANCE_TYPE;
import static jkt.hrms.util.HrmsRequestConstants.SEARCH_FIELD;
import static jkt.hrms.util.HrmsRequestConstants.SEARCH_NAME;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasHospital;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.HrMasInsurance;
import jkt.hrms.masters.handler.HrmsCommonMasterHandlerService;
import jkt.hrms.masters.handler.InsuranceHandlerService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class InsuranceController extends MultiActionController {

	InsuranceHandlerService insuranceHandlerService = null;
	HrmsCommonMasterHandlerService hrmscommonMasterHandlerService = null;

	public InsuranceHandlerService getInsuranceHandlerService() {
		return insuranceHandlerService;
	}

	public void setInsuranceHandlerService(
			InsuranceHandlerService insuranceHandlerService) {
		this.insuranceHandlerService = insuranceHandlerService;
	}

	public HrmsCommonMasterHandlerService getHrmsCommonMasterHandlerService() {
		return hrmscommonMasterHandlerService;
	}

	public void setHrmsCommonMasterHandlerService(
			HrmsCommonMasterHandlerService hrmscommonMasterHandlerService) {
		this.hrmscommonMasterHandlerService = hrmscommonMasterHandlerService;
	}

	HttpSession session = null;
	Map<String, Object> map = new HashMap<String, Object>();
	String jsp = "";
	String title = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String userName = "";
	String currentDate = "";
	String currentTime = "";
	String message = "";
	String code = "";
	String name = "";
	String changedBy = "";
	String jspName = "";
	String url = "";

	// ****************************************** Start Of Insurance Master by
	// Rajendra ****************************//

	@SuppressWarnings("unchecked")
	public ModelAndView showInsuranceMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map map = new HashMap();
		map = insuranceHandlerService.showInsuranceMasterJsp();
		String jsp = HR_INSURANCE_MASTER_JSP;
		jsp += ".jsp";
		title = "Insurance Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addInsuranceMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HrMasInsurance hrMasInsurance = new HrMasInsurance();

		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		String insuranceType = "";
		int hospitalId = 0;

		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}

		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}

		if (request.getParameter(INSURANCE_TYPE) != null
				&& (!(request.getParameter(INSURANCE_TYPE).equals("")))) {
			insuranceType = request.getParameter(INSURANCE_TYPE);
		}

		if (request.getParameter(CHANGED_BY) != null
				&& (!(request.getParameter(CHANGED_BY).equals("")))) {
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
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("insuranceType", insuranceType);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		listMap = hrmscommonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List insuranceCodeList = new ArrayList();
		List insuranceNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			insuranceCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			insuranceNameList = (List) listMap.get("duplicateGeneralNameList");
		}

		boolean successfullyAdded = false;

		if ((insuranceCodeList.size() == 0 || insuranceCodeList == null)) {
			hrMasInsurance.setInsuranceCode(code);
			hrMasInsurance.setInsuranceName(name);
			hrMasInsurance.setInsuranceType(insuranceType);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasInsurance.setCompany(masHospital);

			hrMasInsurance.setStatus("y");
			hrMasInsurance.setLastChgBy(changedBy);
			hrMasInsurance.setLastChgDate(currentDate);
			hrMasInsurance.setLastChgTime(currentTime);
			successfullyAdded = insuranceHandlerService
					.addInsuranceMaster(hrMasInsurance);

			if (successfullyAdded) {

				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((insuranceCodeList.size() != 0 || insuranceCodeList != null)
				|| (insuranceNameList.size() != 0) || insuranceNameList != null) {
			if ((insuranceCodeList.size() != 0 || insuranceCodeList != null)
					&& (insuranceNameList.size() == 0 || insuranceNameList == null)) {

				message = "Insurance Code already exists.";
			} else if ((insuranceNameList.size() != 0 || insuranceNameList != null)
					&& (insuranceCodeList.size() == 0 || insuranceCodeList == null)) {

				message = "Insurance Name  already exists.";
			} else if ((insuranceCodeList.size() != 0 || insuranceCodeList != null)
					&& (insuranceNameList.size() != 0 || insuranceNameList != null)) {
				message = "Insurance Code and Insurance Description already exist.";
			}
		}
		url = "hms/hrms/insuranceMaster?method=showInsuranceMasterJsp";
		try {
			map = insuranceHandlerService.showInsuranceMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsp = HR_INSURANCE_MASTER_JSP;
		jsp += ".jsp";
		title = "Add Insurance Master";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editInsuranceMaster(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();

		String insuranceCode = "";
		String insuranceName = "";
		String insuranceType = "";
		int hospitalId = 0;
		int insuranceId = 0;

		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			insuranceId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			insuranceCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			insuranceName = request.getParameter(SEARCH_NAME);
		}

		if (request.getParameter(INSURANCE_TYPE) != null
				&& !(request.getParameter(INSURANCE_TYPE).equals(""))) {
			insuranceType = request.getParameter(INSURANCE_TYPE);
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", insuranceId);
		generalMap.put("code", insuranceCode);
		generalMap.put("name", insuranceName);
		generalMap.put("insuranceType", insuranceType);

		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);
		listMap = hrmscommonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingInsuranceMasterList = (List) listMap
				.get("duplicateGeneralCodeList");
		boolean dataUpdated = false;
		if (existingInsuranceMasterList.size() == 0) {
			dataUpdated = insuranceHandlerService
					.editInsuranceMaster(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingInsuranceMasterList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hrms/insuranceMaster?method=showInsuranceMasterJsp";
		try {
			map = insuranceHandlerService.showInsuranceMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = HR_INSURANCE_MASTER_JSP;
		title = "Edit Insurance Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchInsuranceMaster(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		String insuranceCode = "";
		String insuranceName = "";
		String searchField = "";
		int searchRadio = 1;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			insuranceCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			insuranceName = request.getParameter(SEARCH_NAME);
		}
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchRadio == 1) {
			insuranceCode = searchField;
			insuranceName = null;
		} else {
			insuranceName = searchField;
			insuranceCode = null;
		}
		map = insuranceHandlerService.searchInsuranceMaster(insuranceCode,
				insuranceName);

		jsp = HR_INSURANCE_MASTER_JSP;
		jsp += ".jsp";
		title = "Insurance Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("search", "search");
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteInsuranceMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int insuranceId = 0;
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
			insuranceId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = insuranceHandlerService.deleteInsuranceMaster(
				insuranceId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hrms/insuranceMaster?method=showInsuranceMasterJsp";

		try {
			map = insuranceHandlerService.showInsuranceMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = HR_INSURANCE_MASTER_JSP;
		title = "Delete Insurance Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

}
