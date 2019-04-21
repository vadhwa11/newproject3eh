package jkt.hms.masters.controller;

import static jkt.hms.util.RequestConstants.ANTIBIOTIC_ID;
import static jkt.hms.util.RequestConstants.ANTIBIOTIC_LAB_JSP;
import static jkt.hms.util.RequestConstants.ANTIBIOTIC_NAME;
import static jkt.hms.util.RequestConstants.BIOPSY_LAB_JSP;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.CRITERIA;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DG_COLLECTION_CENTER;
import static jkt.hms.util.RequestConstants.DG_UOM_ID;
import static jkt.hms.util.RequestConstants.DG_UOM_JSP;
import static jkt.hms.util.RequestConstants.DIAGNOSIS_CONCLUSION_JSP;
import static jkt.hms.util.RequestConstants.DIAG_ID;
import static jkt.hms.util.RequestConstants.DIAG_PARAM_JSP;
import static jkt.hms.util.RequestConstants.JASPER_FILE_NAME;
import static jkt.hms.util.RequestConstants.MAIN_CHARGECODE_ID;
import static jkt.hms.util.RequestConstants.ORGANISM_GROUP_ID;
import static jkt.hms.util.RequestConstants.ORGANISM_GROUP_JSP;
import static jkt.hms.util.RequestConstants.ORGANISM_ID;
import static jkt.hms.util.RequestConstants.ORGANISM_JSP;
import static jkt.hms.util.RequestConstants.ORG_DETAIL;
import static jkt.hms.util.RequestConstants.ORG_GRP_DETAIL;
import static jkt.hms.util.RequestConstants.ORG_GRP_FOR_SELECTED_ORG;
import static jkt.hms.util.RequestConstants.PREFIX;
import static jkt.hms.util.RequestConstants.SAMPLE_COLLECTION_ID;
import static jkt.hms.util.RequestConstants.SAMPLE_COLLECTION_MASTER;
import static jkt.hms.util.RequestConstants.SAMPLE_JSP;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.SENSITIVITY_FOR_SELECTED_ORG;
import static jkt.hms.util.RequestConstants.SEQUENCE_NO;
import static jkt.hms.util.RequestConstants.SUB_CHARGECODE_ID;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.DgCollectionCenter;
import jkt.hms.masters.business.DgMasCollection;
import jkt.hms.masters.business.DgMasOrganism;
import jkt.hms.masters.business.DgMasOrganismGroup;
import jkt.hms.masters.business.DgOrgDtl;
import jkt.hms.masters.business.DgOrgGrpDtl;
import jkt.hms.masters.business.DgUom;
import jkt.hms.masters.business.DiagParam;
import jkt.hms.masters.business.MasAnalyzerParameter;
import jkt.hms.masters.business.MasAntibioticLab;
import jkt.hms.masters.business.MasBiopsyLab;
import jkt.hms.masters.business.MasDiagnosisConclusion;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasSample;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.LaboratoryMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class LaboratoryMasterController extends MultiActionController {

	LaboratoryMasterHandlerService laboratoryMasterHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = null;
	String code = "";
	String name = "";
	String jspName = "";
	String pojoPropertyCode = "";
	String jsp = "";
	String title = "";
	String message = " ";
	String url = "";
	String viewPage = "";
	String pojoName = "";
	String pojoPropertyName = "";
	String currentTime = "";

	// -----------------------------------Diagnosis------------------------------------------
	public ModelAndView searchDiagnosisConclusion(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String diagnosisConclusionCode = null;
		String diagnosisConclusionName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			diagnosisConclusionCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			diagnosisConclusionName = request.getParameter(SEARCH_NAME);
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
			diagnosisConclusionCode = searchField;
			diagnosisConclusionName = null;
		} else {
			diagnosisConclusionCode = null;
			diagnosisConclusionName = searchField;
		}
		map = laboratoryMasterHandlerService.searchDiagnosisConclusion(
				diagnosisConclusionCode, diagnosisConclusionName);
		jsp = DIAGNOSIS_CONCLUSION_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("diagnosisConclusionCode", diagnosisConclusionCode);
		map.put("diagnosisConclusionName", diagnosisConclusionName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showDiagnosisConclusionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = laboratoryMasterHandlerService.showDiagnosisConclusionJsp();
		@SuppressWarnings("unused")
		ArrayList searchDiagnosisConclusionList = (ArrayList) map
				.get("searchDiagnosisConclusionList");
		jsp = DIAGNOSIS_CONCLUSION_JSP;
		jsp += ".jsp";
		title = "Diagnosis Conclusion";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDiagnosisConclusion(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasDiagnosisConclusion masDiagnosisConclusion = new MasDiagnosisConclusion();
		int changedBy = 0;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session=request.getSession();
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
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

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List diagnosisConclusionCodeList = new ArrayList();
		List diagnosisConclusionNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			diagnosisConclusionCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			diagnosisConclusionNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((diagnosisConclusionCodeList.size() == 0 || diagnosisConclusionCodeList == null)
				&& (diagnosisConclusionNameList.size() == 0 || diagnosisConclusionNameList == null)) {
			masDiagnosisConclusion.setDiagnosisConclusionCode(code);
			masDiagnosisConclusion.setDiagnosisConclusionName(name);
			masDiagnosisConclusion.setStatus("y");
			masDiagnosisConclusion.setLastChgby("");
			masDiagnosisConclusion.setLastchgdate(currentDate);
			masDiagnosisConclusion.setLastchgtime(currentTime);
			successfullyAdded = laboratoryMasterHandlerService
					.addDiagnosisConclusion(masDiagnosisConclusion);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((diagnosisConclusionCodeList.size() != 0 || diagnosisConclusionCodeList != null)
				|| (diagnosisConclusionNameList.size() != 0)
				|| diagnosisConclusionNameList != null) {

			if ((diagnosisConclusionCodeList.size() != 0 || diagnosisConclusionCodeList != null)
					&& (diagnosisConclusionNameList.size() == 0 || diagnosisConclusionNameList == null)) {
				message = "DC Code  already exists.";
			} else if ((diagnosisConclusionNameList.size() != 0 || diagnosisConclusionNameList != null)
					&& (diagnosisConclusionCodeList.size() == 0 || diagnosisConclusionCodeList == null)) {

				message = "DC Name already exists.";
			} else if ((diagnosisConclusionCodeList.size() != 0 || diagnosisConclusionCodeList != null)
					&& (diagnosisConclusionNameList.size() != 0 || diagnosisConclusionNameList != null)) {

				message = "DC Code and DC Name already exist.";
			}
		}

		url = "/hms/hms/laboratory?method=showDiagnosisConclusionJsp";
		try {
			map = laboratoryMasterHandlerService.showDiagnosisConclusionJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIAGNOSIS_CONCLUSION_JSP;
		title = "Add Diagnosis Conclusion";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editDiagnosisConclusion(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String diagnosisConclusionCode = "";
		String diagnosisConclusionName = "";
		int diagnosisConclusionId = 0;
		int changedBy = 0;
		String changedTime = "";
		Date changedDate = null;
		HttpSession session=request.getSession();
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			diagnosisConclusionId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			diagnosisConclusionCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			diagnosisConclusionName = request.getParameter(SEARCH_NAME);
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
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

		generalMap.put("id", diagnosisConclusionId);
		generalMap.put("diagnosisConclusionCode", diagnosisConclusionCode);
		generalMap.put("name", diagnosisConclusionName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingDiagnosisConclusionNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingDiagnosisConclusionNameList.size() == 0) {
			dataUpdated = laboratoryMasterHandlerService
					.editDiagnosisConclusionToDatabase(generalMap);
			if (dataUpdated) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated!!";
			}
		} else if (existingDiagnosisConclusionNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/laboratory?method=showDiagnosisConclusionJsp";
		try {
			map = laboratoryMasterHandlerService.showDiagnosisConclusionJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIAGNOSIS_CONCLUSION_JSP;
		title = "Edit Diagnosis Conclusion";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteDiagnosisConclusion(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int diagnosisConclusionId = 0;
		String message = null;
		int changedBy = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session=request.getSession();
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			diagnosisConclusionId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = laboratoryMasterHandlerService.deleteDiagnosisConclusion(
				diagnosisConclusionId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/laboratory?method=showDiagnosisConclusionJsp";
		try {
			map = laboratoryMasterHandlerService.showDiagnosisConclusionJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIAGNOSIS_CONCLUSION_JSP;
		title = "Delete Diagnosis Conclusion";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------------ BiopsyLab
	// Type-------------------------------------------

	public ModelAndView searchBiopsyLab(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String biopsyLabCode = null;
		String biopsyLabName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			biopsyLabCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			biopsyLabName = request.getParameter(SEARCH_NAME);
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
			biopsyLabCode = searchField;
			biopsyLabName = null;

		} else {
			biopsyLabCode = null;
			biopsyLabName = searchField;
		}

		map = laboratoryMasterHandlerService.searchBiopsyLab(biopsyLabCode,
				biopsyLabName);
		jsp = BIOPSY_LAB_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);

		map.put("biopsyLabCode", biopsyLabCode);
		map.put("biopsyLabName", biopsyLabName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showBiopsyLabJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = laboratoryMasterHandlerService.showBiopsyLabJsp();
		@SuppressWarnings("unused")
		ArrayList searchBiopsyLabList = (ArrayList) map
				.get("searchBiopsyLabList");
		jsp = BIOPSY_LAB_JSP;
		jsp += ".jsp";
		title = "BiopsyLab";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addBiopsyLab(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasBiopsyLab masBiopsyLab = new MasBiopsyLab();
		int changedBy = 0;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		
		Date currentDate = new Date();
		HttpSession session=request.getSession();
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
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

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List biopsyLabCodeList = new ArrayList();
		List biopsyLabNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			biopsyLabCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			biopsyLabNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((biopsyLabCodeList.size() == 0 || biopsyLabCodeList == null)
				&& (biopsyLabNameList.size() == 0 || biopsyLabNameList == null)) {
			masBiopsyLab.setBiopsyLabCode(code);
			masBiopsyLab.setBiopsyLabName(name);
			masBiopsyLab.setStatus("y");
			Users user=new Users();
			user.setId(changedBy);
			masBiopsyLab.setLastChgBy(user);
			masBiopsyLab.setLastChgDate(currentDate);
			masBiopsyLab.setLastChgTime(currentTime);
			successfullyAdded = laboratoryMasterHandlerService
					.addBiopsyLab(masBiopsyLab);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((biopsyLabCodeList.size() != 0 || biopsyLabCodeList != null)
				|| (biopsyLabNameList.size() != 0) || biopsyLabNameList != null) {

			if ((biopsyLabCodeList.size() != 0 || biopsyLabCodeList != null)
					&& (biopsyLabNameList.size() == 0 || biopsyLabNameList == null)) {
				message = "BiopsyLab Code  already exists.";
			} else if ((biopsyLabNameList.size() != 0 || biopsyLabNameList != null)
					&& (biopsyLabCodeList.size() == 0 || biopsyLabCodeList == null)) {

				message = "BiopsyLab Name already exists.";
			} else if ((biopsyLabCodeList.size() != 0 || biopsyLabCodeList != null)
					&& (biopsyLabNameList.size() != 0 || biopsyLabNameList != null)) {
				message = "BiopsyLab Code and BiopsyLab Name already exist.";
			}
		}

		url = "/hms/hms/laboratory?method=showBiopsyLabJsp";
		try {
			map = laboratoryMasterHandlerService.showBiopsyLabJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BIOPSY_LAB_JSP;
		title = "Add Biopsy Lab";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editBiopsyLab(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();

		String biopsyLabCode = "";
		String biopsyLabName = "";
		int biopsyLabId = 0;
		int changedBy = 0;
		Date changedDate = null;
		String changedTime = "";
		HttpSession session=request.getSession();
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			biopsyLabId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			biopsyLabCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			biopsyLabName = request.getParameter(SEARCH_NAME);
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
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

		generalMap.put("id", biopsyLabId);
		generalMap.put("biopsyLabCode", biopsyLabCode);
		generalMap.put("name", biopsyLabName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingBiopsyLabNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingBiopsyLabNameList.size() == 0) {
			dataUpdated = laboratoryMasterHandlerService
					.editBiopsyLabToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingBiopsyLabNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/laboratory?method=showBiopsyLabJsp";
		try {
			map = laboratoryMasterHandlerService.showBiopsyLabJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BIOPSY_LAB_JSP;
		title = "Edit Biopsy Lab";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteBiopsyLab(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int biopsyLabId = 0;
		String message = null;
		int changedBy = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session=request.getSession();
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			biopsyLabId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
		}
		
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("changedBy", changedBy);
		boolean dataDeleted = false;
		dataDeleted = laboratoryMasterHandlerService.deleteBiopsyLab(
				biopsyLabId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/laboratory?method=showBiopsyLabJsp";
		try {
			map = laboratoryMasterHandlerService.showBiopsyLabJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BIOPSY_LAB_JSP;
		title = "Delete Biopsy Lab";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ----------------------------------Sample
	// Master-------------------------------------
	public ModelAndView searchSample(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String sampleCode = null;
		String sampleName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			sampleCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			sampleName = request.getParameter(SEARCH_NAME);
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
			sampleCode = searchField;
			sampleName = null;
		} else {
			sampleCode = null;
			sampleName = searchField;
		}

		map = laboratoryMasterHandlerService.searchSample(sampleCode,
				sampleName);

		jsp = SAMPLE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("sampleCode", sampleCode);
		map.put("sampleName", sampleName);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------Sample Master------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showSampleJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = laboratoryMasterHandlerService.showSampleJsp();
		jsp = SAMPLE_JSP;
		jsp += ".jsp";
		title = "Sample";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addSample(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasSample masSample = new MasSample();
		int changedBy = 0;
		int collectionId = 0;
		int uomId = 0;
		HttpSession session=request.getSession();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (!request.getParameter(SAMPLE_COLLECTION_ID).equals("0")) {
			collectionId = Integer.parseInt(request
					.getParameter(SAMPLE_COLLECTION_ID));
		}
		if (!request.getParameter(DG_UOM_ID).equals("0")) {
			uomId = Integer.parseInt(request.getParameter(DG_UOM_ID));
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
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

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List sampleCodeList = new ArrayList();
		List sampleNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			sampleCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			sampleNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((sampleCodeList.size() == 0 || sampleCodeList == null)
				&& (sampleNameList.size() == 0 || sampleNameList == null)) {
			masSample.setSampleCode(code);
			masSample.setSampleDescription(name);

			if (collectionId != 0) {
				DgMasCollection dgMasCollection = new DgMasCollection();
				dgMasCollection.setId(collectionId);
				masSample.setCollection(dgMasCollection);
			}

			if (uomId != 0) {
				DgUom dgUom = new DgUom();
				dgUom.setId(uomId);
				masSample.setUom(dgUom);
			}
			masSample.setStatus("y");
			Users users=new Users(changedBy);
			masSample.setLastChgBy(users);
			masSample.setLastChgDate(currentDate);
			masSample.setLastChgTime(currentTime);
			successfullyAdded = laboratoryMasterHandlerService
					.addSample(masSample);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if ((sampleCodeList.size() != 0 || sampleCodeList != null)
				|| (sampleNameList.size() != 0) || sampleNameList != null) {

			if ((sampleCodeList.size() != 0 || sampleCodeList != null)
					&& (sampleNameList.size() == 0 || sampleNameList == null)) {
				message = "Sample Code  already exists.";
			} else if ((sampleNameList.size() != 0 || sampleNameList != null)
					&& (sampleCodeList.size() == 0 || sampleCodeList == null)) {
				message = "Sample Name already exists.";
			} else if ((sampleCodeList.size() != 0 || sampleCodeList != null)
					&& (sampleNameList.size() != 0 || sampleNameList != null)) {
				message = "Sample Code and Sample Name already exist.";
			}
		}
		url = "/hms/hms/laboratory?method=showSampleJsp";

		try {
			map = laboratoryMasterHandlerService.showSampleJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SAMPLE_JSP;
		title = "Add Sample";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editSample(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String sampleCode = "";
		String sampleName = "";
		int sampleId = 0;
		int collectionId = 0;
		int uomId = 0;
		int changedBy = 0;
		Date changedDate = null;
		String changedTime = "";
		HttpSession session=request.getSession();
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			sampleId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			sampleCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			sampleName = request.getParameter(SEARCH_NAME);
		}
		if (!request.getParameter(SAMPLE_COLLECTION_ID).equals("0")) {
			collectionId = Integer.parseInt(request
					.getParameter(SAMPLE_COLLECTION_ID));
		}
		if (!request.getParameter(DG_UOM_ID).equals("0")) {
			uomId = Integer.parseInt(request.getParameter(DG_UOM_ID));
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
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

		generalMap.put("id", sampleId);
		generalMap.put("sampleCode", sampleCode);
		generalMap.put("name", sampleName);
		generalMap.put("collectionId", collectionId);
		generalMap.put("uomId", uomId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingSampleNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingSampleNameList.size() == 0) {
			dataUpdated = laboratoryMasterHandlerService
					.editSampleToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingSampleNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/laboratory?method=showSampleJsp";
		try {
			map = laboratoryMasterHandlerService.showSampleJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SAMPLE_JSP;
		title = "Edit Sample";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteSample(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int sampleId = 0;
		String message = null;
		int changedBy = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session=request.getSession();
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			sampleId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = laboratoryMasterHandlerService.deleteSample(sampleId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/laboratory?method=showSampleJsp";
		try {
			map = laboratoryMasterHandlerService.showSampleJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SAMPLE_JSP;
		title = "Delete Sample";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ----------------------------Sample Collection
	// Master--------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showSampleCollectionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		@SuppressWarnings("unused")
		HttpSession session = request.getSession();
		map = laboratoryMasterHandlerService.showSampleCollectionJsp();
		jsp = SAMPLE_COLLECTION_MASTER;
		jsp += ".jsp";
		title = "sampleCollectionJsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchSampleCollection(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String collectionCode = null;
		String collectionName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			collectionCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			collectionName = request.getParameter(SEARCH_NAME);
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
			collectionCode = searchField;
			collectionName = null;
		} else {
			collectionCode = null;
			collectionName = searchField;
		}

		map = laboratoryMasterHandlerService.searchSampleCollection(
				collectionCode, collectionName);

		jsp = SAMPLE_COLLECTION_MASTER;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("collectionCode", collectionCode);
		map.put("collectionName", collectionName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addSampleCollection(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		DgMasCollection dgMasCollection = new DgMasCollection();
		int changedBy = 0;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session=request.getSession();
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
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

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List collectionCodeList = new ArrayList();
		List collectionNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			collectionCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			collectionNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((collectionCodeList.size() == 0 || collectionCodeList == null)
				&& (collectionNameList.size() == 0 || collectionNameList == null)) {
			dgMasCollection.setCollectionCode(code);
			dgMasCollection.setCollectionName(name);
			dgMasCollection.setStatus("y");
			Users users=new Users(changedBy);
			dgMasCollection.setLastChgBy(users);
			dgMasCollection.setLastChgDate(currentDate);
			dgMasCollection.setLastChgTime(currentTime);
			successfullyAdded = laboratoryMasterHandlerService
					.addSampleCollection(dgMasCollection);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((collectionCodeList.size() != 0 || collectionCodeList != null)
				|| (collectionNameList.size() != 0)
				|| collectionNameList != null) {

			if ((collectionCodeList.size() != 0 || collectionCodeList != null)
					&& (collectionNameList.size() == 0 || collectionNameList == null)) {
				message = "Collection Code  already exists.";
			} else if ((collectionNameList.size() != 0 || collectionNameList != null)
					&& (collectionCodeList.size() == 0 || collectionCodeList == null)) {
				message = "Collection Name already exists.";
			} else if ((collectionCodeList.size() != 0 || collectionCodeList != null)
					&& (collectionNameList.size() != 0 || collectionNameList != null)) {
				message = "Collection Code and Collection Name already exist.";
			}
		}
		url = "/hms/hms/laboratory?method=showSampleCollectionJsp";

		try {
			map = laboratoryMasterHandlerService.showSampleCollectionJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SAMPLE_COLLECTION_MASTER;
		title = "Add SampleCollection";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editSampleCollection(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String collectionCode = "";
		String collectionName = "";
		int collectionId = 0;
		int changedBy = 0;
		Date changedDate = null;
		String changedTime = "";
		HttpSession session=request.getSession();
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			collectionId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			collectionCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			collectionName = request.getParameter(SEARCH_NAME);
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
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

		generalMap.put("id", collectionId);
		generalMap.put("sampleCode", collectionCode);
		generalMap.put("name", collectionName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCollectionNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingCollectionNameList.size() == 0) {
			dataUpdated = laboratoryMasterHandlerService
					.editSampleCollectionToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingCollectionNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/laboratory?method=showSampleCollectionJsp";
		try {
			map = laboratoryMasterHandlerService.showSampleCollectionJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SAMPLE_COLLECTION_MASTER;
		title = "Edit SampleCollection";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteSampleCollection(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int collectionId = 0;
		String message = null;
		int changedBy = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session=request.getSession();
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			collectionId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = laboratoryMasterHandlerService.deleteSampleCollection(
				collectionId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/laboratory?method=showSampleCollectionJsp";
		try {
			map = laboratoryMasterHandlerService.showSampleCollectionJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SAMPLE_COLLECTION_MASTER;
		title = "Delete SampleCollection";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ----------------------------Investigation UOM
	// Master--------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showInvestigationUomJsp(HttpServletRequest request,
			HttpServletResponse response) {
		@SuppressWarnings("unused")
		HttpSession session = request.getSession();
		map = laboratoryMasterHandlerService.showInvestigationUomJsp();
		jsp = DG_UOM_JSP;
		jsp += ".jsp";
		title = "dgUOM";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchInvestigationUom(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String uomCode = null;
		String uomName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			uomCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			uomName = request.getParameter(SEARCH_NAME);
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
			uomCode = searchField;
			uomName = null;
		} else {
			uomCode = null;
			uomName = searchField;
		}

		map = laboratoryMasterHandlerService.searchInvestigationUom(uomCode,
				uomName);

		jsp = DG_UOM_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("uomCode", uomCode);
		map.put("uomName", uomName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addInvestigationUom(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		DgUom dgUom = new DgUom();
		int changedBy = 0;
		HttpSession session=request.getSession();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
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

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List uomCodeList = new ArrayList();
		List uomNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			uomCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			uomNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((uomCodeList.size() == 0 || uomCodeList == null)
				&& (uomNameList.size() == 0 || uomNameList == null)) {
			dgUom.setUomCode(code);
			dgUom.setUomName(name);
			dgUom.setStatus("y");
			Users users=new Users(changedBy);
			dgUom.setLastChgBy(users);
			dgUom.setLastChgDate(currentDate);
			dgUom.setLastChgTime(currentTime);
			successfullyAdded = laboratoryMasterHandlerService
					.addInvestigationUom(dgUom);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((uomCodeList.size() != 0 || uomCodeList != null)
				|| (uomNameList.size() != 0) || uomNameList != null) {

			if ((uomCodeList.size() != 0 || uomCodeList != null)
					&& (uomNameList.size() == 0 || uomNameList == null)) {
				message = "UOM Code  already exists.";
			} else if ((uomNameList.size() != 0 || uomNameList != null)
					&& (uomCodeList.size() == 0 || uomCodeList == null)) {
				message = "UOM Name already exists.";
			} else if ((uomCodeList.size() != 0 || uomCodeList != null)
					&& (uomNameList.size() != 0 || uomNameList != null)) {
				message = "UOM Code and UOM Name already exist.";
			}
		}
		url = "/hms/hms/laboratory?method=showInvestigationUomJsp";

		try {
			map = laboratoryMasterHandlerService.showInvestigationUomJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DG_UOM_JSP;
		title = "Add InvestigationUom";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editInvestigationUom(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String uomCode = "";
		String uomName = "";
		int uomId = 0;
		int changedBy = 0;
		Date changedDate = null;
		String changedTime = "";
		HttpSession session=request.getSession();
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			uomId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			uomCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			uomName = request.getParameter(SEARCH_NAME);
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
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

		generalMap.put("id", uomId);
		generalMap.put("uomCode", uomCode);
		generalMap.put("name", uomName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingUomNameList = (List) listMap.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingUomNameList.size() == 0) {
			dataUpdated = laboratoryMasterHandlerService
					.editInvestigationUomToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingUomNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/laboratory?method=showInvestigationUomJsp";
		try {
			map = laboratoryMasterHandlerService.showInvestigationUomJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DG_UOM_JSP;
		title = "Edit InvestigationUom";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteInvestigationUom(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int uomId = 0;
		String message = null;
		int changedBy = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session=request.getSession();
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			uomId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = laboratoryMasterHandlerService.deleteInvestigationUom(
				uomId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/laboratory?method=showInvestigationUomJsp";
		try {
			map = laboratoryMasterHandlerService.showInvestigationUomJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DG_UOM_JSP;
		title = "Delete InvestigationUom";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ----------------------------------Dg Collection
	// Center----------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showCollectionCenterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = laboratoryMasterHandlerService.showCollectionCenterJsp();
		@SuppressWarnings("unused")
		ArrayList searchCollectionCenterList = (ArrayList) map
				.get("searchCollectionCenterList");
		jsp = DG_COLLECTION_CENTER;
		jsp += ".jsp";
		title = "CollectionCenter";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchCollectionCenter(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String collectionCenterCode = null;
		String collectionCenterName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			collectionCenterCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			collectionCenterName = request.getParameter(SEARCH_NAME);
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
			collectionCenterCode = searchField;
			collectionCenterName = null;

		} else {
			collectionCenterCode = null;
			collectionCenterName = searchField;
		}

		map = laboratoryMasterHandlerService.searchCollectionCenter(
				collectionCenterCode, collectionCenterName);
		jsp = DG_COLLECTION_CENTER;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);

		map.put("collectionCenterCode", collectionCenterCode);
		map.put("collectionCenterName", collectionCenterName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addCollectionCenter(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		DgCollectionCenter dgCollectionCenter = new DgCollectionCenter();
		int changedBy = 0;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session=request.getSession();
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
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

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List collectionCenterCodeList = new ArrayList();
		List collectionCenterNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			collectionCenterCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			collectionCenterNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((collectionCenterCodeList.size() == 0 || collectionCenterCodeList == null)
				&& (collectionCenterNameList.size() == 0 || collectionCenterNameList == null)) {
			dgCollectionCenter.setCollectionCenterCode(code);
			dgCollectionCenter.setCollectionCenterName(name);
			dgCollectionCenter.setStatus("y");
			Users users=new Users(changedBy);
			dgCollectionCenter.setLastChgBy(users);
			
			dgCollectionCenter.setLastChgDate(currentDate);
			dgCollectionCenter.setLastChgTime(currentTime);
			successfullyAdded = laboratoryMasterHandlerService
					.addCollectionCenter(dgCollectionCenter);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((collectionCenterCodeList.size() != 0 || collectionCenterCodeList != null)
				|| (collectionCenterNameList.size() != 0)
				|| collectionCenterNameList != null) {

			if ((collectionCenterCodeList.size() != 0 || collectionCenterCodeList != null)
					&& (collectionCenterNameList.size() == 0 || collectionCenterNameList == null)) {
				message = "CollectionCenter Code  already exists.";
			} else if ((collectionCenterNameList.size() != 0 || collectionCenterNameList != null)
					&& (collectionCenterCodeList.size() == 0 || collectionCenterCodeList == null)) {

				message = "CollectionCenter Name already exists.";
			} else if ((collectionCenterCodeList.size() != 0 || collectionCenterCodeList != null)
					&& (collectionCenterNameList.size() != 0 || collectionCenterNameList != null)) {
				message = "CollectionCenter Code and CollectionCenter Name already exist.";
			}
		}

		url = "/hms/hms/laboratory?method=showCollectionCenterJsp";
		try {
			map = laboratoryMasterHandlerService.showCollectionCenterJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DG_COLLECTION_CENTER;
		title = "Add CollectionCenter";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editCollectionCenter(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();

		String collectionCenterCode = "";
		String collectionCenterName = "";
		int collectionCenterId = 0;
		int changedBy = 0;
		Date changedDate = null;
		String changedTime = "";
		HttpSession session=request.getSession();
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			collectionCenterId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			collectionCenterCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			collectionCenterName = request.getParameter(SEARCH_NAME);
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
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

		generalMap.put("id", collectionCenterId);
		generalMap.put("collectionCenterCode", collectionCenterCode);
		generalMap.put("name", collectionCenterName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCollectionCenterNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingCollectionCenterNameList.size() == 0) {
			dataUpdated = laboratoryMasterHandlerService
					.editCollectionCenterToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingCollectionCenterNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/laboratory?method=showCollectionCenterJsp";
		try {
			map = laboratoryMasterHandlerService.showCollectionCenterJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DG_COLLECTION_CENTER;
		title = "Edit CollectionCenter";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteCollectionCenter(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int collectionCenterId = 0;
		String message = null;
		int changedBy = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session=request.getSession();
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			collectionCenterId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = laboratoryMasterHandlerService.deleteCollectionCenter(
				collectionCenterId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/laboratory?method=showCollectionCenterJsp";
		try {
			map = laboratoryMasterHandlerService.showCollectionCenterJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DG_COLLECTION_CENTER;
		title = "Delete CollectionCenter";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ********************************--start-- Organism Master
	// **********************************

	@SuppressWarnings("unchecked")
	public ModelAndView showOrganismGroupJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = laboratoryMasterHandlerService.showOrganismGroupJsp();

		jsp = ORGANISM_GROUP_JSP;
		jsp += ".jsp";
		title = "OrganismGroup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchOrganismGroup(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {

		Map<String, Object> map = new HashMap<String, Object>();
		String organismGroupCode = null;
		String organismGroupName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			organismGroupCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			organismGroupName = request.getParameter(SEARCH_NAME);
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
			organismGroupCode = searchField;
			organismGroupName = null;

		} else {
			organismGroupCode = null;
			organismGroupName = searchField;
		}

		map = laboratoryMasterHandlerService.searchOrganismGroup(
				organismGroupCode, organismGroupName);
		jsp = ORGANISM_GROUP_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("organismGroupCode", organismGroupCode);
		map.put("organismGroupName", organismGroupName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addOrganismGroup(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		DgMasOrganismGroup dgMasOrganismGroup = new DgMasOrganismGroup();
		int changedBy = 0;
		HttpSession session=request.getSession();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int organismId = 0;

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(ORGANISM_GROUP_ID) != null) {
			organismId = Integer.parseInt(request
					.getParameter(ORGANISM_GROUP_ID));
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
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

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List organismGroupCodeList = new ArrayList();
		List organismGroupNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			organismGroupCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			organismGroupNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((organismGroupCodeList.size() == 0 || organismGroupCodeList == null)
				&& (organismGroupNameList.size() == 0 || organismGroupNameList == null)) {
			dgMasOrganismGroup.setOrganismGroupCode(code);
			dgMasOrganismGroup.setOrganismGroupName(name);
			dgMasOrganismGroup.setStatus("y");
			Users users=new Users(changedBy);
			dgMasOrganismGroup.setLastChgBy(users);
			dgMasOrganismGroup.setLastChgDate(currentDate);
			dgMasOrganismGroup.setLastChgTime(currentTime);
			successfullyAdded = laboratoryMasterHandlerService
					.addOrganismGroup(dgMasOrganismGroup);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((organismGroupCodeList.size() != 0 || organismGroupCodeList != null)
				|| (organismGroupNameList.size() != 0)
				|| organismGroupNameList != null) {

			if ((organismGroupCodeList.size() != 0 || organismGroupCodeList != null)
					&& (organismGroupNameList.size() == 0 || organismGroupNameList == null)) {
				message = "OrganismGroup Code  already exists.";
			} else if ((organismGroupNameList.size() != 0 || organismGroupNameList != null)
					&& (organismGroupCodeList.size() == 0 || organismGroupCodeList == null)) {

				message = "OrganismGroup Name already exists.";
			} else if ((organismGroupCodeList.size() != 0 || organismGroupCodeList != null)
					&& (organismGroupNameList.size() != 0 || organismGroupNameList != null)) {
				message = "OrganismGroup Code and OrganismGroup Name already exist.";
			}
		}

		url = "/hms/hms/laboratory?method=showOrganismGroupJsp";
		try {
			map = laboratoryMasterHandlerService.showOrganismGroupJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ORGANISM_GROUP_JSP;
		title = "Add Organism Group";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editOrganismGroupToDatabase(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();

		String organismGroupCode = "";
		String organismGroupName = "";
		int organismGroupId = 0;
		int changedBy = 0;
		Date changedDate = null;
		String changedTime = "";
		HttpSession session=request.getSession();
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			organismGroupId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			organismGroupCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			organismGroupName = request.getParameter(SEARCH_NAME);
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
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

		generalMap.put("id", organismGroupId);
		generalMap.put("organismGroupCode", organismGroupCode);
		generalMap.put("name", organismGroupName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingOrganismGroupNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingOrganismGroupNameList.size() == 0) {
			dataUpdated = laboratoryMasterHandlerService
					.editOrganismGroupToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingOrganismGroupNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/laboratory?method=showOrganismGroupJsp";
		try {
			map = laboratoryMasterHandlerService.showOrganismGroupJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ORGANISM_GROUP_JSP;
		title = "Edit Oragnism Group";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteOrganismGroup(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int organismGroupId = 0;
		String message = null;
		int changedBy = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session=request.getSession();
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			organismGroupId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = laboratoryMasterHandlerService.deleteOrganismGroup(
				organismGroupId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/laboratory?method=showOrganismGroupJsp";
		try {
			map = laboratoryMasterHandlerService.showOrganismGroupJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ORGANISM_GROUP_JSP;
		title = "Delete Organism Group";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ********************************--start-- Organism Group Master by Vishal
	// Jain--**********************************

	public ModelAndView searchOrganism(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {

		Map<String, Object> map = new HashMap<String, Object>();
		String organismCode = null;
		String organismName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			organismCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			organismName = request.getParameter(SEARCH_NAME);
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
			organismCode = searchField;
			organismName = null;

		} else {
			organismCode = null;
			organismName = searchField;
		}

		map = laboratoryMasterHandlerService.searchOrganism(organismCode,
				organismName);
		jsp = ORGANISM_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);

		map.put("organismCode", organismCode);
		map.put("organismName", organismName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showOrganismJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = laboratoryMasterHandlerService.showOrganismJsp();
		jsp = ORGANISM_JSP;
		jsp += ".jsp";
		title = "Organism";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addOrganism(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		DgMasOrganism dgMasOrganism = new DgMasOrganism();
		int changedBy = 0;
		HttpSession session=request.getSession();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
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

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List organismCodeList = new ArrayList();
		List organismNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			organismCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			organismNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((organismCodeList.size() == 0 || organismCodeList == null)
				&& (organismNameList.size() == 0 || organismNameList == null)) {
			dgMasOrganism.setOrganismCode(code);
			dgMasOrganism.setOrganismName(name);
			dgMasOrganism.setStatus("y");
			Users users=new Users(changedBy);
			dgMasOrganism.setLastChgBy(users);
			dgMasOrganism.setLastChgDate(currentDate);
			dgMasOrganism.setLastChgTime(currentTime);
			successfullyAdded = laboratoryMasterHandlerService
					.addOrganism(dgMasOrganism);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((organismCodeList.size() != 0 || organismCodeList != null)
				|| (organismNameList.size() != 0) || organismNameList != null) {

			if ((organismCodeList.size() != 0 || organismCodeList != null)
					&& (organismNameList.size() == 0 || organismNameList == null)) {
				message = "Organism Code  already exists.";
			} else if ((organismNameList.size() != 0 || organismNameList != null)
					&& (organismCodeList.size() == 0 || organismCodeList == null)) {

				message = "Organism Name already exists.";
			} else if ((organismCodeList.size() != 0 || organismCodeList != null)
					&& (organismNameList.size() != 0 || organismNameList != null)) {
				message = "Organism Code and Organism Name already exist.";
			}
		}

		url = "/hms/hms/laboratory?method=showOrganismJsp";
		try {
			map = laboratoryMasterHandlerService.showOrganismJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ORGANISM_JSP;
		title = "Add Organism";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editOrganism(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();

		String organismCode = "";
		String organismName = "";
		int organismId = 0;
		int changedBy = 0;
		Date changedDate = null;
		String changedTime = "";
		HttpSession session=request.getSession();
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			organismId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			organismCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			organismName = request.getParameter(SEARCH_NAME);
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
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

		generalMap.put("id", organismId);
		generalMap.put("organismCode", organismCode);
		generalMap.put("name", organismName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingOrganismNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingOrganismNameList.size() == 0) {
			dataUpdated = laboratoryMasterHandlerService
					.editOrganism(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingOrganismNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/laboratory?method=showOrganismJsp";
		try {
			map = laboratoryMasterHandlerService.showOrganismJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ORGANISM_JSP;
		title = "Edit Organism";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteOrganism(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int organismId = 0;
		String message = null;
		int changedBy = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session=request.getSession();
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			organismId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = laboratoryMasterHandlerService.deleteOrganism(organismId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/laboratory?method=showOrganismJsp";
		try {
			map = laboratoryMasterHandlerService.showOrganismJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ORGANISM_JSP;
		title = "Delete Organism";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateReportForLabOrganism(
			HttpServletRequest request, HttpServletResponse response) {
		String jasper = null;
		int hospitalId = 0;
		String hospitalName = null;

		if (request.getParameter(JASPER_FILE_NAME) != null) {
			jasper = request.getParameter(JASPER_FILE_NAME);
		}

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		parameters = laboratoryMasterHandlerService.getConnection();
		HMSUtil.generateReport(jasper, parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);
	}

	// ********************************--End-- Organism Group Master by Vishal
	// Jain**********************************

	public ModelAndView generateReportForLabOrganismDesc(
			HttpServletRequest request, HttpServletResponse response) {
		String jasper = null;
		int hospitalId = 0;
		String hospitalName = null;

		if (request.getParameter(JASPER_FILE_NAME) != null) {
			jasper = request.getParameter(JASPER_FILE_NAME);
		}

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		parameters = laboratoryMasterHandlerService.getConnection();
		HMSUtil.generateReport(jasper, parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);
	}

	// ********************************--End-- Organism Master by Vishal
	// Jain**********************************

	// ********************************--start--Antibiotic Master by Vishal
	// Jain--**********************************

	public ModelAndView searchAntibioticLab(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {

		Map<String, Object> map = new HashMap<String, Object>();
		String antibioticCode = null;
		String antibioticName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			antibioticCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			antibioticName = request.getParameter(SEARCH_NAME);
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
			antibioticCode = searchField;
			antibioticName = null;

		} else {
			antibioticCode = null;
			antibioticName = searchField;
		}

		map = laboratoryMasterHandlerService.searchAntibioticLab(
				antibioticCode, antibioticName);
		jsp = ANTIBIOTIC_LAB_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);

		map.put("antibioticCode", antibioticCode);
		map.put("antibioticName", antibioticName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showAntibioticLabJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = laboratoryMasterHandlerService.showAntibioticLabJsp();

		// @SuppressWarnings("unused")
		ArrayList searchAntibioticList = (ArrayList) map
				.get("searchAntibioticList");
		jsp = ANTIBIOTIC_LAB_JSP;
		jsp += ".jsp";
		title = "AntibioticLab";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addAntibioticLab(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasAntibioticLab masAntibioticLab = new MasAntibioticLab();
		int changedBy = 0;
		int hospitalId=0;
		HttpSession session=request.getSession();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
		}
		
		if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null
				&& !(session.getAttribute(RequestConstants.HOSPITAL_ID).equals(""))) {
			hospitalId =Integer.parseInt(session.getAttribute(RequestConstants.HOSPITAL_ID).toString());
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

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		generalMap.put("hospitalId", hospitalId);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List antibioticLabCodeList = new ArrayList();
		List antibioticLabNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			antibioticLabCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			antibioticLabNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((antibioticLabCodeList.size() == 0 || antibioticLabCodeList == null)
				&& (antibioticLabNameList.size() == 0 || antibioticLabNameList == null)) {
			masAntibioticLab.setAntibioticLabCode(code);
			masAntibioticLab.setAntibioticLabName(name);
			masAntibioticLab.setStatus("y");
			Users users=new Users(changedBy);
			masAntibioticLab.setLastChgBy(users);
			masAntibioticLab.setLastChgDate(currentDate);
			masAntibioticLab.setLastChgTime(currentTime);
			successfullyAdded = laboratoryMasterHandlerService
					.addAntibioticLab(masAntibioticLab);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((antibioticLabCodeList.size() != 0 || antibioticLabCodeList != null)
				|| (antibioticLabNameList.size() != 0)
				|| antibioticLabNameList != null) {

			if ((antibioticLabCodeList.size() != 0 || antibioticLabCodeList != null)
					&& (antibioticLabNameList.size() == 0 || antibioticLabNameList == null)) {
				message = "Antibiotic Lab Code  already exists.";
			} else if ((antibioticLabNameList.size() != 0 || antibioticLabNameList != null)
					&& (antibioticLabCodeList.size() == 0 || antibioticLabCodeList == null)) {

				message = "Antibiotic Lab Name already exists.";
			} else if ((antibioticLabCodeList.size() != 0 || antibioticLabCodeList != null)
					&& (antibioticLabNameList.size() != 0 || antibioticLabNameList != null)) {
				message = "Antibiotic Lab Code and Antibiotic Lab Name already exist.";
			}
		}

		url = "/hms/hms/laboratory?method=showOrganismLabJsp";
		try {
			map = laboratoryMasterHandlerService.showAntibioticLabJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ANTIBIOTIC_LAB_JSP;
		title = "Add Antibiotic Lab";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editAntibioticLab(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();

		String antibioticLabCode = "";
		String antiobioticLabName = "";
		int antibioticLabId = 0;
		int changedBy = 0;
		Date changedDate = null;
		String changedTime = "";
		HttpSession session=request.getSession();
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			antibioticLabId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			antibioticLabCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			antiobioticLabName = request.getParameter(SEARCH_NAME);
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
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

		generalMap.put("id", antibioticLabId);
		generalMap.put("biopsyLabCode", antibioticLabCode);
		generalMap.put("name", antiobioticLabName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingAntibioticLabNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingAntibioticLabNameList.size() == 0) {
			dataUpdated = laboratoryMasterHandlerService
					.editAntibioticLabToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingAntibioticLabNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/laboratory?method=showAntibioticLabJsp";
		try {
			map = laboratoryMasterHandlerService.showAntibioticLabJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ANTIBIOTIC_LAB_JSP;
		title = "Edit Antibiotic Lab";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteAntibioticLab(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int antibioticLabId = 0;
		String message = null;
		int changedBy = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session=request.getSession();
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			antibioticLabId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = laboratoryMasterHandlerService.deleteAntibioticLab(
				antibioticLabId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/laboratory?method=showAntibioticLabJsp";
		try {
			map = laboratoryMasterHandlerService.showAntibioticLabJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ANTIBIOTIC_LAB_JSP;
		title = "Delete Antibiotic Lab";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateReportForLabAntibiotic(
			HttpServletRequest request, HttpServletResponse response) {
		String jasper = null;
		int hospitalId = 0;
		String hospitalName = null;

		if (request.getParameter(JASPER_FILE_NAME) != null) {
			jasper = request.getParameter(JASPER_FILE_NAME);
		}

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		parameters = laboratoryMasterHandlerService.getConnection();
		HMSUtil.generateReport(jasper, parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showOrganismGroupDetailJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		int hospitalId=0;
		if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null
				&& !(session.getAttribute(RequestConstants.HOSPITAL_ID).equals(""))) {
			hospitalId =Integer.parseInt(session.getAttribute(RequestConstants.HOSPITAL_ID).toString());
		}
		map = laboratoryMasterHandlerService.showOrganismGroupDetailJsp(hospitalId);
		jsp = ORG_GRP_DETAIL;
		jsp += ".jsp";
		title = "OrganismGroupDetail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addOrganismGroupDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		DgOrgGrpDtl dgOrgGrpDtl = new DgOrgGrpDtl();
		int organismGroupId = 0;
		int organismId = 0;
		int changedBy = 0;
		int hospitalId=0;
		HttpSession session=request.getSession();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(ORGANISM_GROUP_ID) != null) {
			organismGroupId = Integer.parseInt(request
					.getParameter(ORGANISM_GROUP_ID));
		}
		if (request.getParameter(ORGANISM_ID) != null) {
			organismId = Integer.parseInt(request.getParameter(ORGANISM_ID));
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
		}
		if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null
				&& !(session.getAttribute(RequestConstants.HOSPITAL_ID).equals(""))) {
			hospitalId =Integer.parseInt(session.getAttribute(RequestConstants.HOSPITAL_ID).toString());
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
		generalMap.put("organismGroupId", organismGroupId);
		generalMap.put("organismId", organismId);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoName", pojoName);

		List<DgOrgGrpDtl> orgGrpDtList = new ArrayList<DgOrgGrpDtl>();
		orgGrpDtList = laboratoryMasterHandlerService
				.checkExisitingOrgGrpDt(generalMap);
		if (orgGrpDtList != null && orgGrpDtList.size() > 0) {
			message = "Record Already Exist!!";
		} else {

			boolean successfullyAdded = false;

			DgMasOrganismGroup dgMasOrganismGroup = new DgMasOrganismGroup();
			dgMasOrganismGroup.setId(organismGroupId);
			dgOrgGrpDtl.setOrganismGroup(dgMasOrganismGroup);

			DgMasOrganism dgMasOrganism = new DgMasOrganism();
			dgMasOrganism.setId(organismId);
			dgOrgGrpDtl.setOrganism(dgMasOrganism);

			dgOrgGrpDtl.setStatus("y");
			Users users=new Users(changedBy);
			MasHospital hospital=new MasHospital(hospitalId);
			dgOrgGrpDtl.setLastChgBy(users);
			dgOrgGrpDtl.setHospital(hospital);
			dgOrgGrpDtl.setLastChgDate(currentDate);
			dgOrgGrpDtl.setLastChgTime(currentTime);
			successfullyAdded = laboratoryMasterHandlerService
					.addOrganismGroupDetail(dgOrgGrpDtl);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}
		try {
			map = laboratoryMasterHandlerService.showOrganismGroupDetailJsp(hospitalId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ORG_GRP_DETAIL;
		title = "Add OrganismGroupDetail";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editOrganismGroupDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int groupDetailId = 0;
		int organismGroupId = 0;
		int organismId = 0;
		int changedBy = 0;
		int hospitalId=0;
		Date changedDate = null;
		String changedTime = "";
		String dietCategoryName = "";
		String demandDisplay = "";
		HttpSession session=request.getSession();
		if (request.getParameter(COMMON_ID) != null) {
			groupDetailId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(ORGANISM_GROUP_ID) != null) {
			organismGroupId = Integer.parseInt(request
					.getParameter(ORGANISM_GROUP_ID));
		}
		if (request.getParameter(ORGANISM_ID) != null) {
			organismId = Integer.parseInt(request.getParameter(ORGANISM_ID));
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
		}
		if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null
				&& !(session.getAttribute(RequestConstants.HOSPITAL_ID).equals(""))) {
			hospitalId =Integer.parseInt(session.getAttribute(RequestConstants.HOSPITAL_ID).toString());
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", groupDetailId);
		generalMap.put("organismGroupId", organismGroupId);
		generalMap.put("organismId", organismId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("flag", true);
		boolean dataUpdated = false;
		dataUpdated = laboratoryMasterHandlerService
				.editOrganismGroupDetail(generalMap);
		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant be updated !!";
		}
		try {
			map = laboratoryMasterHandlerService.showOrganismGroupDetailJsp(hospitalId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ORG_GRP_DETAIL;
		title = "Edit OrganismGroupDetail";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteOrganismGroupDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int groupDetailId = 0;
		String message = null;
		int changedBy = 0;
		int hospitalId=0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session=request.getSession();
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			groupDetailId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
		}
		if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null
				&& !(session.getAttribute(RequestConstants.HOSPITAL_ID).equals(""))) {
			hospitalId =Integer.parseInt(session.getAttribute(RequestConstants.HOSPITAL_ID).toString());
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = laboratoryMasterHandlerService.deleteOrganismGroupDetail(
				groupDetailId, generalMap);

		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		try {
			map = laboratoryMasterHandlerService.showOrganismGroupDetailJsp(hospitalId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ORG_GRP_DETAIL;
		title = "Delete OrganismGroupDetail";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchOrganismGroupDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		String organismGroup = "";
		int hospitalId=0;
		if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null
				&& !(session.getAttribute(RequestConstants.HOSPITAL_ID).equals(""))) {
			hospitalId =Integer.parseInt(session.getAttribute(RequestConstants.HOSPITAL_ID).toString());
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			organismGroup = request.getParameter(SEARCH_NAME);
		}

		map = laboratoryMasterHandlerService
				.searchOrganismGroupDetail(organismGroup,hospitalId);

		jsp = ORG_GRP_DETAIL;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("organismGroup", organismGroup);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showOrganismDetailJsp(HttpServletRequest request,
			HttpServletResponse response) {
		map = laboratoryMasterHandlerService.showOrganismDetailJsp();
		jsp = ORG_DETAIL;
		jsp += ".jsp";
		title = "OrganismDetail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchOrganismDetailAjax(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		String organismId = "";
		int hospitalId=0;
		HttpSession session=request.getSession();
		if (request.getParameter(ORGANISM_ID) != null
				&& !(request.getParameter(ORGANISM_ID).equals(""))) {
			organismId = request.getParameter(ORGANISM_ID);
			mapForDs.put("organismId", organismId);
		}
		if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null
				&& !(session.getAttribute(RequestConstants.HOSPITAL_ID).equals(""))) {
			hospitalId =Integer.parseInt(session.getAttribute(RequestConstants.HOSPITAL_ID).toString());
			mapForDs.put(RequestConstants.HOSPITAL_ID, hospitalId);
		}
		map = laboratoryMasterHandlerService.searchOrganismDetail(mapForDs);

		jsp = ORG_GRP_FOR_SELECTED_ORG;
		// jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("organismId", organismId);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView searchOrganismDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		String organismId = "";
		if (request.getParameter(ORGANISM_ID) != null
				&& !(request.getParameter(ORGANISM_ID).equals(""))) {
			organismId = request.getParameter(ORGANISM_ID);
			mapForDs.put("organismId", organismId);
		}

		map = laboratoryMasterHandlerService.searchOrganismDetail(mapForDs);

		jsp = ORG_DETAIL;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("organismId", organismId);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchSensitivityDetailAjax(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		String organismId = "";
		String organismGroupId = "";
		int hospitalId=0;
		HttpSession session=request.getSession();
		if (request.getParameter(ORGANISM_ID) != null
				&& !(request.getParameter(ORGANISM_ID).equals(""))) {
			organismId = request.getParameter(ORGANISM_ID);
			mapForDs.put("organismId", organismId);
		}
		if (request.getParameter(ORGANISM_GROUP_ID) != null
				&& !(request.getParameter(ORGANISM_GROUP_ID).equals(""))) {
			organismGroupId = request.getParameter(ORGANISM_GROUP_ID);
			mapForDs.put("organismGroupId", organismGroupId);
		}
		if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null
				&& !(session.getAttribute(RequestConstants.HOSPITAL_ID).equals(""))) {
			hospitalId =Integer.parseInt(session.getAttribute(RequestConstants.HOSPITAL_ID).toString());
			mapForDs.put(RequestConstants.HOSPITAL_ID, hospitalId);
		}

		map = laboratoryMasterHandlerService.searchOrganismDetail(mapForDs);
		jsp = SENSITIVITY_FOR_SELECTED_ORG;
		// jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("organismId", organismId);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getSensitivityListAutoComplete(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		String nameField = "";
		String autoHint = "";
		if (request.getParameter("requiredField") != null) {
			nameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(nameField) != null) {
			autoHint = (request.getParameter(nameField));
		}

		parameterMap.put("autoHint", autoHint);

		map = laboratoryMasterHandlerService
				.getSensitivityListAutoComplete(parameterMap);
		String jsp = "";
		jsp = "responseForSensitivityGrid";
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addOrganismDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		DgOrgDtl dgOrgDtl = new DgOrgDtl();
		int antiId = 0;
		int organismId = 0;
		int changedBy = 0;
		HttpSession session=request.getSession();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(ANTIBIOTIC_ID) != null) {
			antiId = Integer.parseInt(request.getParameter(ANTIBIOTIC_ID));
		}
		if (request.getParameter(ORGANISM_ID) != null) {
			organismId = Integer.parseInt(request.getParameter(ORGANISM_ID));
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
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
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoName", pojoName);

		boolean successfullyAdded = false;

		MasAntibioticLab masAntibioticLab = new MasAntibioticLab();
		masAntibioticLab.setId(antiId);
		dgOrgDtl.setAntibioticLab(masAntibioticLab);

		DgMasOrganism dgMasOrganism = new DgMasOrganism();
		dgMasOrganism.setId(organismId);
		dgOrgDtl.setOrganism(dgMasOrganism);

		dgOrgDtl.setStatus("y");
		Users users=new Users(changedBy);
		dgOrgDtl.setLastChgBy(users);
		dgOrgDtl.setLastChgDate(currentDate);
		dgOrgDtl.setLastChgTime(currentTime);
		successfullyAdded = laboratoryMasterHandlerService
				.addOrganismDetail(dgOrgDtl);
		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}

		try {
			map = laboratoryMasterHandlerService.showOrganismDetailJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ORG_DETAIL;
		title = "Add OrganismDetail";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editOrganismDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int totalRowsCount = 0;
		int organismId = 0;
		int organismGroupId = 0;
		int changedBy = 0;
		Date changedDate = null;
		String changedTime = "";
		int hospitalId=0;
		HttpSession session=request.getSession();
		List<Integer> antibiaticIds = new ArrayList<Integer>();
		if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null
				&& !(session.getAttribute(RequestConstants.HOSPITAL_ID).equals(""))) {
			hospitalId =Integer.parseInt(session.getAttribute(RequestConstants.HOSPITAL_ID).toString());
			generalMap.put(RequestConstants.HOSPITAL_ID, hospitalId);
		}
		if (request.getParameter(ORGANISM_ID) != null
				&& !request.getParameter(ORGANISM_ID).equals("")) {
			organismId = Integer.parseInt(request.getParameter(ORGANISM_ID));
		}
		if (request.getParameter(ORGANISM_GROUP_ID) != null
				&& !request.getParameter(ORGANISM_GROUP_ID).equals("")) {
			organismGroupId = Integer.parseInt(request
					.getParameter(ORGANISM_GROUP_ID));
		}

		if (request.getParameter("totalRowsCount") != null) {
			totalRowsCount = Integer.parseInt(request
					.getParameter("totalRowsCount"));
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
			generalMap.put(RequestConstants.USER_ID, changedBy);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		for (int i = 1; i <= totalRowsCount; i++) {
			if (request.getParameter(ANTIBIOTIC_NAME + i) != null
					&& !request.getParameter(ANTIBIOTIC_NAME + i).equals("")) {

				int index1 = ((String) request
						.getParameter(ANTIBIOTIC_NAME + i)).lastIndexOf("[");
				int index2 = ((String) request
						.getParameter(ANTIBIOTIC_NAME + i)).lastIndexOf("]");
				index1++;
				String organismIdString = ((String) request
						.getParameter(ANTIBIOTIC_NAME + i)).substring(index1,
						index2);
				antibiaticIds.add(Integer.parseInt(organismIdString));
			}
		}

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("organismId", organismId);
		generalMap.put("organismGroupId", organismGroupId);
		generalMap.put("antibiaticIds", antibiaticIds);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("flag", true);
		boolean dataUpdated = false;
		dataUpdated = laboratoryMasterHandlerService
				.editOrganismDetail(generalMap);
		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant be updated !!";
		}
		try {
			map = laboratoryMasterHandlerService.showOrganismDetailJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ORG_DETAIL;
		title = "Edit OrganismDetail";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteOrganismDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int detailId = 0;
		String message = null;
		int changedBy = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session=request.getSession();
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			detailId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = laboratoryMasterHandlerService.deleteOrganismDetail(
				detailId, generalMap);

		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		try {
			map = laboratoryMasterHandlerService.showOrganismDetailJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ORG_DETAIL;
		title = "Delete OrganismDetail";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	/** methods for diagnostic parameter * */
	@SuppressWarnings("unchecked")
	public ModelAndView showParamJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		map = laboratoryMasterHandlerService.showParamJsp();
		@SuppressWarnings("unused")
		ArrayList searchParamList = (ArrayList) map.get("searchParamList");
		jsp = DIAG_PARAM_JSP;
		jsp += ".jsp";
		title = "Parameter";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView addDiagParam(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		DiagParam diagParam = new DiagParam();
		int mainChargecodeId = 0;
		int changedBy = 0;
		Map listMap = new HashMap();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int deptId = 0;
		int sequenceNo = 0;
		String prefix = "";
		String criteria = "";
		int subChargecodeId = 0;
		Users users=new Users();
		HttpSession session=request.getSession();
		if (request.getParameter(SEQUENCE_NO) != null) {
			sequenceNo = Integer.parseInt(request.getParameter(SEQUENCE_NO));
		}
		if (request.getParameter(PREFIX) != null) {
			prefix = request.getParameter(PREFIX);
		}
		if (request.getParameter(CRITERIA) != null) {
			criteria = request.getParameter(CRITERIA);
		}
		if (request.getParameter(MAIN_CHARGECODE_ID) != null) {
			mainChargecodeId = Integer.valueOf(request
					.getParameter(MAIN_CHARGECODE_ID));
		}
		if (request.getParameter(SUB_CHARGECODE_ID) != null) {
			subChargecodeId = Integer.valueOf(request
					.getParameter(SUB_CHARGECODE_ID));
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			deptId = Integer.valueOf(request.getParameter(DEPARTMENT_ID));
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
			users.setId(changedBy);
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
		generalMap.put("sequenceNo", sequenceNo);
		generalMap.put("prefix", prefix);
		generalMap.put("criteria", criteria);
		generalMap.put("mainChargecodeId", mainChargecodeId);
		generalMap.put("subChargecodeId", subChargecodeId);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		List subChargecodeList = new ArrayList();
		Box box = HMSUtil.getBox(request);
		map = laboratoryMasterHandlerService.getSubchargeList(box);
		if (map.get("subChargecodeList") != null) {
			subChargecodeList = (List) map.get("subChargecodeList");
		}

		boolean successfullyAdded = false;
		if (subChargecodeList.size() == 0 || subChargecodeList == null) {
			diagParam.setSeqNo(sequenceNo);
			diagParam.setCriteria(criteria);
			diagParam.setPrefix(prefix);

			MasMainChargecode masMainChargecode = new MasMainChargecode();
			masMainChargecode.setId(mainChargecodeId);
			diagParam.setMainCharge(masMainChargecode);

			MasSubChargecode masSubChargecode = new MasSubChargecode();
			masSubChargecode.setId(subChargecodeId);
			diagParam.setSubCharge(masSubChargecode);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(1);
			diagParam.setHospital(masHospital);

			diagParam.setStatus("y");
			diagParam.setLastChgBy(users);
			diagParam.setLastChgDate(currentDate);
			diagParam.setLastChgTime(currentTime);
			successfullyAdded = laboratoryMasterHandlerService
					.addDiagParam(diagParam);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if (subChargecodeList.size() != 0 || subChargecodeList != null) {

			message = "Sub Charge already exists.";

		}

		try {
			map = laboratoryMasterHandlerService.showParamJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIAG_PARAM_JSP;
		title = "add Diagnostic Param";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editDiagParam(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int changedBy = 0;
		Date changedDate = null;
		String changedTime = "";

		int sequenceNo = 0;
		String prefix = "";
		String criteria = "";
		int diagId = 0;
		HttpSession session=request.getSession();
		if (request.getParameter(SEQUENCE_NO) != null
				&& !(request.getParameter(SEQUENCE_NO).equals(""))) {
			sequenceNo = Integer.parseInt(request.getParameter(SEQUENCE_NO));
		}
		if (request.getParameter(DIAG_ID) != null) {
			diagId = Integer.parseInt(request.getParameter(DIAG_ID));
		}
		if (request.getParameter(PREFIX) != null
				&& !(request.getParameter(PREFIX).equals(""))) {
			prefix = request.getParameter(PREFIX);
		}
		if (request.getParameter(CRITERIA) != null
				&& !(request.getParameter(CRITERIA).equals(""))) {
			criteria = request.getParameter(CRITERIA);
		}

		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
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
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("id", diagId);
		generalMap.put("sequenceNo", sequenceNo);
		generalMap.put("prefix", prefix);
		generalMap.put("criteria", criteria);

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		// listMap =
		// commonMasterHandlerService.checkForExistingMasters(generalMap);
		// List existingSubChargeNameList =
		// (List)listMap.get("duplicateMastersList");

		boolean dataUpdated = false;

		dataUpdated = laboratoryMasterHandlerService.editDiagParam(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant Be Updated !!";
		}

		url = "/hms/hms/?method=showParamJsp";
		try {
			map = laboratoryMasterHandlerService.showParamJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIAG_PARAM_JSP;
		title = "edit Diag Param";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteDiagParam(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int diagId = 0;
		String message = null;
		int changedBy = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session=request.getSession();
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(DIAG_ID) != null
				&& !(request.getParameter(DIAG_ID).equals(""))) {
			diagId = Integer.parseInt(request.getParameter(DIAG_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =Integer.parseInt(session.getAttribute(RequestConstants.USER_ID).toString());
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = laboratoryMasterHandlerService.deleteDiagParam(diagId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/laboratory?method=showParamJsp";
		try {
			map = laboratoryMasterHandlerService.showParamJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIAG_PARAM_JSP;
		title = "delete Diag Param";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchDiagParam(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String subChargecodeCode = null;
		String subChargecodeName = null;
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
			subChargecodeCode = searchField;
			subChargecodeName = null;

		} else {
			subChargecodeCode = null;
			subChargecodeName = searchField;
		}

		map = laboratoryMasterHandlerService.searchSubChargeInDiagParam(
				subChargecodeCode, subChargecodeName);

		jsp = DIAG_PARAM_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("subChargecodeCode", subChargecodeCode);
		map.put("subChargecodeName", subChargecodeName);
		return new ModelAndView("index", "map", map);
	}
	

@SuppressWarnings("unchecked")
public ModelAndView showAnalyzerParameterJsp(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session=request.getSession();
	int hospitalId=(Integer)session.getAttribute(RequestConstants.HOSPITAL_ID);
	map = laboratoryMasterHandlerService.showAnalyzerParameterJsp(hospitalId);
	String jsp = "analyzerParameter";
	jsp += ".jsp";
	title = "Ot Charge Details";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}

@SuppressWarnings("unchecked")
public ModelAndView addAnalyzerParameter(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session=request.getSession();
	MasAnalyzerParameter masAnalyzerParameter = new MasAnalyzerParameter();
	int hospitalId=(Integer)session.getAttribute(RequestConstants.HOSPITAL_ID);
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Date currentDate = new Date();
	String parameterName = "";
	String machineName = "";
	String currentTime = "";
	int changedBy = 0;
	if (request.getParameter("machineName") != null) {
		machineName = request.getParameter("machineName");
	}
	if (request.getParameter("parameterName") != null) {
		parameterName = request.getParameter("parameterName");
	}

	changedBy = (Integer) session.getAttribute("userId");
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

	generalMap.put("currentDate", currentDate);
	generalMap.put("currentTime", currentTime);
	generalMap.put("machineName", machineName);
	generalMap.put("parameterName", parameterName);

	
	Map<String, Object> listMap = new HashMap<String, Object>();
	listMap = laboratoryMasterHandlerService.checkForExistingAnalyzerParameter(generalMap);
	List duplicateChargeCodeIdList = new ArrayList();

	if (listMap.get("duplicateChargeCodeIdList") != null) {
		duplicateChargeCodeIdList = (List) listMap
				.get("duplicateChargeCodeIdList");
	}
	if ((duplicateChargeCodeIdList.size() == 0 || duplicateChargeCodeIdList == null))

	{
		boolean successfullyAdded = false;
		
		
	

		masAnalyzerParameter.setMachineName(machineName);
		masAnalyzerParameter.setParameterName(parameterName);
		
		masAnalyzerParameter.setStatus("y");
		Users users = new Users();
		users.setId(changedBy);
		masAnalyzerParameter.setLastChgBy(users);
		masAnalyzerParameter.setLastChgDate(currentDate);
		masAnalyzerParameter.setLastChgTime(currentTime);
		
		
		successfullyAdded = laboratoryMasterHandlerService.addAnalyzerParameter(masAnalyzerParameter);

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}

	} else if (duplicateChargeCodeIdList.size() != 0) {

		message = "Machine Name and Parameter Name exist.";
	}
	try {
		map = laboratoryMasterHandlerService.showAnalyzerParameterJsp(hospitalId);

	} catch (Exception e) {
		e.printStackTrace();
	}

	jsp = "analyzerParameter";
	title = "Add Service Centre Counter";
	jsp += ".jsp";

	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
}

public ModelAndView editAnalyzerParameter(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	int changedBy = 0;
	Date changedDate = null;
	String changedTime = "";
	HttpSession session=request.getSession();
	int hospitalId=(Integer)session.getAttribute(RequestConstants.HOSPITAL_ID);
	int analyzerParameterId = 0;
	String counterNo = "";
	String parameterName = "";
	String machineName = "";
	

	if (request.getParameter("machineName") != null) {
		machineName = request.getParameter("machineName");
	}
	if (request.getParameter("parameterName") != null) {
		parameterName = request.getParameter("parameterName");
	}
	if (request.getParameter(COMMON_ID) != null) {
		analyzerParameterId = Integer.parseInt(request
				.getParameter(COMMON_ID));
	}
	changedBy = (Integer) session.getAttribute("userId");

	changedDate = new Date();
	changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
			"currentTime");

	generalMap.put("id", analyzerParameterId);
	generalMap.put("machineName", machineName);
	generalMap.put("parameterName", parameterName);
	generalMap.put("changedBy", changedBy);
	generalMap.put("currentDate", changedDate);
	generalMap.put("currentTime", changedTime);
	generalMap.put("hospitalId", hospitalId);
	generalMap.put("flag", true);

	Map<String, Object> listMap = new HashMap<String, Object>();
	listMap = laboratoryMasterHandlerService
			.checkForExistingAnalyzerParameterId(generalMap);
	List duplicateChargeCodeNameList = (List) listMap
			.get("duplicateChargeCodeNameList");
	boolean dataUpdated = false;
	if (duplicateChargeCodeNameList.size() == 0) {
		dataUpdated = laboratoryMasterHandlerService
				.editAnalyzerParameter(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant Be Updated !!";
		}
	} else if (duplicateChargeCodeNameList.size() > 0) {
		message = "Machine Name and Parameter Name exist.";
	}

	try {
		map = laboratoryMasterHandlerService.showAnalyzerParameterJsp(hospitalId);

	} catch (Exception e) {
		e.printStackTrace();
	}
	jsp = "analyzerParameter";
	title = "Edit Service Centre Counter";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
}

public ModelAndView deleteAnalyzerParameter(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
	int analyzerParameterId = 0;
	String message = null;
	int changedBy = 0;
	String changedTime = "";
	Date changedDate = null;
	String flag = "";
	HttpSession session=request.getSession();
	int hospitalId=(Integer)session.getAttribute(RequestConstants.HOSPITAL_ID);
	if (request.getParameter("flag") != null) {
		flag = request.getParameter("flag");
		generalMap.put("flag", flag);
	}
	if (request.getParameter(COMMON_ID) != null
			&& !(request.getParameter(COMMON_ID).equals(""))) {
		analyzerParameterId = Integer.parseInt(request
				.getParameter(COMMON_ID));
	}
	if (request.getParameter("title") != null) {
		title = request.getParameter("title");
	}
	changedBy = (Integer) session.getAttribute("userId");
	changedDate = new Date();
	changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
			"currentTime");
	generalMap.put("changedBy", changedBy);
	generalMap.put("currentDate", changedDate);
	generalMap.put("currentTime", changedTime);
	boolean dataDeleted = false;
	dataDeleted = laboratoryMasterHandlerService.deleteAnalyzerParameter(
			analyzerParameterId, generalMap);

	if (dataDeleted == true) {
		message = "Record is InActivated successfully !!";
	} else {
		message = "Record is Activated successfully !!";
	}
	try {
		map = laboratoryMasterHandlerService.showAnalyzerParameterJsp(hospitalId);
	} catch (Exception e) {
		e.printStackTrace();
	}
	jsp = "analyzerParameter";
	title = "Delete Service Centre Counter";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
}

public ModelAndView searchAnalyzerParameter(HttpServletRequest request,
		HttpServletResponse response) throws ServletRequestBindingException {
	Map<String, Object> map = new HashMap<String, Object>();
	String parameterName = "";
	String machineName = "";
	
HttpSession session=request.getSession();
int hospitalId=(Integer)session.getAttribute(RequestConstants.HOSPITAL_ID);
	try {
		
	
		if (request.getParameter("machineNames") != null) {
			machineName = request.getParameter("machineNames");
		}
		if (request.getParameter("parameterNames") != null) {
			parameterName = request.getParameter("parameterNames");
		}
		/*System.out.println(machineName);
		System.out.println(parameterName);*/
		int searchRadio = 1;
		try {
				if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			machineName = machineName;
			parameterName = null;

		} else {
			parameterName = parameterName;
			machineName = null;
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	map = laboratoryMasterHandlerService.searchAnalyzerParameter(parameterName,machineName,hospitalId);

	jsp = "analyzerParameter";
	jsp += ".jsp";
	map.put("search", "search");
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("parameterName", parameterName);
	map.put("machineName", machineName);
	return new ModelAndView("index", "map", map);
}


	/** end of methods * */
	// -----------------------------------------------------------------------------------------------------
	public LaboratoryMasterHandlerService getLaboratoryMasterHandlerService() {
		return laboratoryMasterHandlerService;
	}

	public void setLaboratoryMasterHandlerService(
			LaboratoryMasterHandlerService laboratoryMasterHandlerService) {
		this.laboratoryMasterHandlerService = laboratoryMasterHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}
