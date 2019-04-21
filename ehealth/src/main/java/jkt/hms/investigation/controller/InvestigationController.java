package jkt.hms.investigation.controller;

import static jkt.hms.util.RequestConstants.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;
import jkt.hms.investigation.handler.InvestigationHandlerService;
import jkt.hms.masters.business.DgFixedValue;
import jkt.hms.masters.business.DgMasCollection;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgNormalValue;
import jkt.hms.masters.business.DgResultEntryDetail;
import jkt.hms.masters.business.DgResultEntryHeader;
import jkt.hms.masters.business.DgSampleCollectionDetails;
import jkt.hms.masters.business.DgSampleCollectionHeader;
import jkt.hms.masters.business.DgSubMasInvestigation;
import jkt.hms.masters.business.DgTemplate;
import jkt.hms.masters.business.DgUom;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmpaneled;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasLionc;
import jkt.hms.masters.business.MasLioncSubClass;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasSample;
import jkt.hms.masters.business.MasSetupParameterMaintaince;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.HospitalDetailsMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


public class InvestigationController extends MultiActionController {
	InvestigationHandlerService investigationHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;

	HospitalDetailsMasterHandlerService hospitalDetailsMasterHandlerService = null;

	// -------------------------------------------------------------------------------------------------------------
	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	public InvestigationHandlerService getInvestigationHandlerService() {
		return investigationHandlerService;
	}

	public void setInvestigationHandlerService(
			InvestigationHandlerService investigationHandlerService) {
		this.investigationHandlerService = investigationHandlerService;
	}

	public void setHospitalDetailsMasterHandlerService(
			HospitalDetailsMasterHandlerService hospitalDetailsMasterHandlerService) {
		this.hospitalDetailsMasterHandlerService = hospitalDetailsMasterHandlerService;
	}

	// -------------------------------------------------------------------------------------------------------------------
	String jsp = "";
	String title = "";
	String url = "";
	String currentTime = "";
	String pojoName = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String message = "";
	HttpSession session = null;
	Map<String, Object> map = new HashMap<String, Object>();
	static final Logger logger = Logger.getLogger(InvestigationController.class);
	public ModelAndView showInvestigationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in showInvestigationJsp");
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
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}
		Box box = HMSUtil.getBox(request);
		box.put("deptId", deptId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		if (request.getParameter(MAIN_CHARGECODE_ID) != null
				&& request.getParameter(MAIN_CHARGECODE_ID) != "") {
			mainChargecodeId = Integer.parseInt(request
					.getParameter(MAIN_CHARGECODE_ID));
		}
		if (request.getParameter(SUB_CHARGECODE_ID) != null
				&& request.getParameter(SUB_CHARGECODE_ID) != "") {
			subChargecodeId = Integer.parseInt(request
					.getParameter(SUB_CHARGECODE_ID));
		}
		if (request.getParameter(CHARGE_CODE_ID) != null) {
			chargeCodeId = Integer.parseInt(request
					.getParameter(CHARGE_CODE_ID));
		}
		if (request.getParameter(INVESTIGATION_NAME) != null) {
			investigationName = request.getParameter(INVESTIGATION_NAME);
		}
		if (request.getParameter("pageNoTempFromBackButton") != null) {
			pageNoTempFromBackButton = Integer.parseInt(request
					.getParameter("pageNoTempFromBackButton"));
		}
		map = investigationHandlerService.showInvestigationJsp(box);
		map.put("deptId", deptId);
		map.put("pageNoTempFromBackButton", pageNoTempFromBackButton);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("investigationName", investigationName);
		map.put("subChargecodeId", subChargecodeId);
		map.put("mainChargecodeId", mainChargecodeId);
		map.put("chargeCodeId", chargeCodeId);
		//String jsp = INVESTIGATION_JSP;
		if (deptType.equalsIgnoreCase("radio")) {
			jsp = INVESTIGATION_DIAGNOSTICS_JSP;
		} else {
			jsp = INVESTIGATION_JSP;
		}
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// /***** **Diagonstic Master***/

	public ModelAndView printDiagonstics(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in printDiagonstics");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String hospitalname = "";
		String investigationType = "";

		session = request.getSession();
		int hospitalId = 0;
		int deptId = 0;

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (request.getParameter("investigationTypeSearch") != null
				&& !(request.getParameter("investigationTypeSearch").equals(""))) {
			investigationType = (request
					.getParameter("investigationTypeSearch"));
		}
		detailsMap = investigationHandlerService.getConnectionForReport();
		parameters.put("hospital_id", hospitalId);
		parameters.put("deptId", deptId);
		parameters.put("investigationType", investigationType);
		try {

			HMSUtil.generateReport("dg_mas_investigation", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean checkInvestigationExsist(String investigationCode,
			String investigationName) {
		logger.info("in checkInvestigationExsist");
		boolean investigationExsist = investigationHandlerService
				.checkInvestigationExsist(investigationCode, investigationName);
		return investigationExsist;
	}

	/** method to add investigations * */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public ModelAndView addInvestigation(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in addInvestigation");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		DgMasInvestigation dgmasInvestigation = new DgMasInvestigation();
		MasMainChargecode masMainChargecode = new MasMainChargecode();
		String checkBoxConfidence = null, checkBoxDischargeSummary = null, subTestRecords = null;
		String changedBy = "";
		Date currentDate = new Date();
		int mainChargecodeId = 0;
		int subChargecodeId = 0;
		int sampleId = 0;
		int unitOfMeasurementId = 0;
		String name = "";
		int chargeCodeId = 0;
		String rareCommon = "";
		String normalValue = "";
		String investigationType = "";
		String quantity = "";
		Box box = HMSUtil.getBox(request);
		String minNormalValue = "";
		String maxNormalValue = "";
		int collectionId = 0;
		int investigationId1 = 0;
		String variation = "n";
		String lioncCodeId = "";
		String deptType = "";
		String invShortCode  = "";
		Users users = null;
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}
		if (request.getParameter(NORMAL_VALUE) != null) {
			normalValue = request.getParameter(NORMAL_VALUE);
		}
		if (request.getParameter(MIN_NORMAL_VALUE) != null) {
			minNormalValue = request.getParameter(MIN_NORMAL_VALUE);
		}
		if (request.getParameter(MAX_NORMAL_VALUE) != null) {
			maxNormalValue = request.getParameter(MAX_NORMAL_VALUE);
		}
		String phInvestigation = "n";
		if (request.getParameter("phInvestigation") != null) {
			phInvestigation = (request.getParameter("phInvestigation"));
		}
		if (request.getParameter(INVESTIGATION_NAME) != null) {
			name = request.getParameter(INVESTIGATION_NAME);
		}
		if (session.getAttribute(USERS) != null) {
			users = (Users) session.getAttribute(USERS);
		}

		if (request.getParameter(INVESTIGATION_TYPE) != null) {
			investigationType = request.getParameter(INVESTIGATION_TYPE);
		}

		if (request.getParameter(QUANTITY) != null) {
			quantity = request.getParameter(QUANTITY);
		}
		if (request.getParameter(MAIN_CHARGECODE_ID) != null) {
			mainChargecodeId = Integer.parseInt(request
					.getParameter(MAIN_CHARGECODE_ID));
		}
		if (request.getParameter(SUB_CHARGECODE_ID) != null) {
			subChargecodeId = Integer.parseInt(request
					.getParameter(SUB_CHARGECODE_ID));

		}
		if (request.getParameter("investigationId1") != null
				&& (!request.getParameter("investigationId1").equals("0"))) {
			investigationId1 = Integer.parseInt(request
					.getParameter("investigationId1"));
		}
		if (request.getParameter("variation") != null
				&& (request.getParameter("variation").equals("y"))) {
			variation = (request.getParameter("variation"));
		}

		if (request.getParameter(SAMPLE_ID) != null
				&& (!request.getParameter(SAMPLE_ID).equals("0"))) {
			sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
		}
		if (request.getParameter(CHARGE_CODE_ID) != null) {
			chargeCodeId = Integer.parseInt(request
					.getParameter(CHARGE_CODE_ID));

		}
		if (request.getParameter(COLLECTION_CENTER_ID) != null
				&& (!request.getParameter(COLLECTION_CENTER_ID).equals("0"))) {
			collectionId = Integer.parseInt(request
					.getParameter(COLLECTION_CENTER_ID));
		}
		if (request.getParameter(UNIT_OF_MEASUREMENT_ID) != null
				&& (!request.getParameter(UNIT_OF_MEASUREMENT_ID).equals("0"))) {
			unitOfMeasurementId = Integer.parseInt(request
					.getParameter(UNIT_OF_MEASUREMENT_ID));
		}

		if (request.getParameter(LIONC_CODE) != null
				&& (!request.getParameter(LIONC_CODE).equals(""))) {
			lioncCodeId = request.getParameter(LIONC_CODE);
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
		if (request.getParameter("currentTime") != null
				&& !(request.getParameter("currentTime").equals(""))) {
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
		}
		if (request.getParameter(RARE_COMMON) != null
				&& !(request.getParameter(RARE_COMMON).equals(""))) {
			rareCommon = request.getParameter(RARE_COMMON);
		}
		if (request.getParameter("invShortCode") != null
				&& !(request.getParameter("invShortCode").equals(""))) {
			invShortCode = request.getParameter("invShortCode");
		}

		checkBoxConfidence = ServletRequestUtils.getStringParameter(request,
				CONFIDENTIAL, null);
		checkBoxDischargeSummary = ServletRequestUtils.getStringParameter(request,
				DSICHARGE_SUMMARY, null);
		if (checkBoxConfidence == null) {
			dgmasInvestigation.setConfidential("n");
		} else {
			try {
				dgmasInvestigation.setConfidential(ServletRequestUtils
						.getStringParameter(request, CONFIDENTIAL));
			} catch (ServletRequestBindingException e) {
				e.printStackTrace();
			}
		}
		if (checkBoxDischargeSummary == null) {
			dgmasInvestigation.setAppearInDischargeSummary("n");
		} else {
			try {
				dgmasInvestigation.setAppearInDischargeSummary(ServletRequestUtils
						.getStringParameter(request, DSICHARGE_SUMMARY));
			} catch (ServletRequestBindingException e) {
				e.printStackTrace();
			}
		}
		String screenTest = "n";
		if (request.getParameter("bloodBankScreen") != null
				&& (request.getParameter("bloodBankScreen").equals("y"))) {
			screenTest = (request.getParameter("bloodBankScreen"));
		}
		dgmasInvestigation.setBloodBankScreenTest(screenTest);
		String reactionTest = "n";
		if (request.getParameter("bloodReactionTest") != null
				&& (request.getParameter("bloodReactionTest").equals("y"))) {
			reactionTest = (request.getParameter("bloodReactionTest"));
		}
		dgmasInvestigation.setBloodReactionTest(reactionTest);
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");

		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		generalMap.put("invShortCode", invShortCode);
		generalMap.put("name", name);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List chargeNameList = new ArrayList();
		List duplicateShortCodeList = new ArrayList();
		
		if (listMap.get("duplicateGeneralNameList") != null) {
			chargeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		if (listMap.get("duplicateShortCodeList") != null) {
			duplicateShortCodeList = (List) listMap.get("duplicateShortCodeList");
		}
		boolean successfullyAdded = false;
		if (chargeNameList.size() == 0 || chargeNameList == null) {
			if( duplicateShortCodeList.size() ==0 || duplicateShortCodeList==null){
			dgmasInvestigation.setId(investigationId1);
			dgmasInvestigation.setInvestigationName(name);
			dgmasInvestigation.setNormalValue(normalValue);
			dgmasInvestigation.setPhLab(phInvestigation);
			dgmasInvestigation.setMinNormalValue(minNormalValue);
			dgmasInvestigation.setMaxNormalValue(maxNormalValue);
			if (unitOfMeasurementId != 0) {
				DgUom dgUom = new DgUom();
				dgUom.setId(unitOfMeasurementId);
				dgmasInvestigation.setUom(dgUom);
			}
			if (collectionId != 0) {
				DgMasCollection dgCollection = new DgMasCollection();
				dgCollection.setId(collectionId);
				dgmasInvestigation.setCollection(dgCollection);
			}

			masMainChargecode.setId(mainChargecodeId);
			dgmasInvestigation.setMainChargecode(masMainChargecode);
			dgmasInvestigation.setInvestigationType(investigationType);

			MasChargeCode masChargeCode = new MasChargeCode();
			masChargeCode.setId(chargeCodeId);
			dgmasInvestigation.setChargeCode(masChargeCode);

			MasSubChargecode massubChargecode = new MasSubChargecode();
			massubChargecode.setId(subChargecodeId);
			dgmasInvestigation.setSubChargecode(massubChargecode);
			if(!invShortCode.equals(""))
				dgmasInvestigation.setInvestigationShortCode(invShortCode);
			if (sampleId != 0) {
				MasSample masSample = new MasSample();
				masSample.setId(sampleId);
				dgmasInvestigation.setSample(masSample);
			}
			dgmasInvestigation.setRareCommon(rareCommon);
			dgmasInvestigation.setVariationRequired(variation);
			dgmasInvestigation.setQuantity(quantity);
			dgmasInvestigation.setStatus("y");
			dgmasInvestigation.setLastChgBy(users);
			dgmasInvestigation.setLastChgDate(currentDate);
			dgmasInvestigation.setLastChgTime(currentTime);
			if (lioncCodeId != null && !(lioncCodeId).equals("")) {
				MasLionc masLionc = new MasLionc();
				masLionc.setId(lioncCodeId);
				dgmasInvestigation.setLoincNum(masLionc);
			}
			String remarks = "";
			if (request.getParameter(REMARKS) != null) {
				remarks = request.getParameter(REMARKS).trim();
			}
			dgmasInvestigation.setRemark(remarks);
			successfullyAdded = investigationHandlerService
					.addInvestigation(dgmasInvestigation);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !";
			}
			}else if(duplicateShortCodeList.size() !=0 || duplicateShortCodeList !=null){
				if (duplicateShortCodeList.size() != 0 || duplicateShortCodeList != null) {
					message = "Investigation short code already exists.";
				}
			}
		} else if (chargeNameList.size() != 0 || chargeNameList != null) {
			if (chargeNameList.size() != 0 || chargeNameList != null) {
				message = "Charge Name already exists.";
			}
		}
		try {
			map = investigationHandlerService.showInvestigationJsp(box);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (deptType.equalsIgnoreCase("radio")) {
			jsp = INVESTIGATION_DIAGNOSTICS_JSP;
		} else {
			jsp = INVESTIGATION_JSP;
		}
		title = "Investigation";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	/** end of add investigation method * */

	/** start of search investigation method * */
	@SuppressWarnings("deprecation")
	public ModelAndView searchInvestigation(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in searchInvestigation");
		Map<String, Object> map = new HashMap<String, Object>();
		String investigationCode = null;
		String investigationType = null;
		String searchField = null;
		if (request.getParameter("investigationTypeSearch") != null
				&& !(request.getParameter("investigationTypeSearch").equals(""))) {
			investigationType = request.getParameter("investigationTypeSearch");
		}
		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		investigationCode = null;
		// investigationName = searchField;
		map = investigationHandlerService.searchInvestigation(searchField,
				investigationType);
		jsp = INVESTIGATION_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("investigationCode", searchField);
		map.put("investigationName", investigationType);
		return new ModelAndView("index", "map", map);
	}

	/** end of search investigation method * */

	/** start of edit investigation method * */
	public ModelAndView editInvestigation(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in editInvestigation");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		DgMasInvestigation dgmasInvestigation = new DgMasInvestigation();
		String changedBy = "";
		String checkBoxConfidence = "", checkBoxDischargeSummary = "";
		String investigationName = "";
		int investigationId = 0;
		int chargeCodeId = 0;
		int mainChargeId = 0;
		int subChargeId = 0;
		int sampleId = 0;
		int unitOfResult = 0;
		int collectionId = 0;
		String normalValue = "";
		String minNormalValue = "";
		String maxNormalValue = "";
		String quantity = "";
		String rareCommon = "";
		String variation = "n";
		String lioncCodeId = "";
		String investigationType = "";
		String changedTime = "";
		String deptType = "";
		String remarks = "";
		Date changedDate = null;
		String invShortCode=null;
		Users users = null;
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}

		if (request.getParameter(INVESTIGATION_ID) != null
				&& (!request.getParameter(INVESTIGATION_ID).equals("0"))) {
			investigationId = Integer.parseInt(request
					.getParameter(INVESTIGATION_ID));
		}
		if (request.getParameter(MAIN_CHARGECODE_ID) != null
				&& (!request.getParameter(MAIN_CHARGECODE_ID).equals("0"))) {
			mainChargeId = Integer.parseInt(request
					.getParameter(MAIN_CHARGECODE_ID));
		}

		if (request.getParameter(LIONC_CODE) != null) {
			lioncCodeId = request.getParameter(LIONC_CODE);
		}
		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS).trim();
		}
		if (request.getParameter(SUB_CHARGECODE_ID) != null
				&& (!request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
			subChargeId = Integer.parseInt(request
					.getParameter(SUB_CHARGECODE_ID));
		}
		if (request.getParameter(CHARGE_CODE_ID) != null
				&& (!request.getParameter(CHARGE_CODE_ID).equals("0"))) {
			chargeCodeId = Integer.parseInt(request
					.getParameter(CHARGE_CODE_ID));
		}
		if (request.getParameter(INVESTIGATION_NAME) != null
				&& !(request.getParameter(INVESTIGATION_NAME).equals(""))) {
			investigationName = (request.getParameter(INVESTIGATION_NAME));
		}
		if (request.getParameter(SAMPLE_ID) != null
				&& (!request.getParameter(SAMPLE_ID).equals("0"))) {
			sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
		}
		if (request.getParameter("variation") != null
				&& (request.getParameter("variation").equals("y"))) {
			variation = (request.getParameter("variation"));
		}
		if (request.getParameter(COLLECTION_CENTER_ID) != null
				&& (!request.getParameter(COLLECTION_CENTER_ID).equals("0"))) {
			collectionId = Integer.parseInt(request
					.getParameter(COLLECTION_CENTER_ID));
		}
		if (request.getParameter(UNIT_OF_MEASUREMENT_ID) != null
				&& (!request.getParameter(UNIT_OF_MEASUREMENT_ID).equals("0"))) {
			unitOfResult = Integer.parseInt(request
					.getParameter(UNIT_OF_MEASUREMENT_ID));
		}
		if (request.getParameter(QUANTITY) != null
				&& !(request.getParameter(QUANTITY).equals(""))) {
			quantity = (request.getParameter(QUANTITY));
		}
		if (request.getParameter(NORMAL_VALUE) != null
				&& !(request.getParameter(NORMAL_VALUE).equals(""))) {
			normalValue = (request.getParameter(NORMAL_VALUE));
		}
		if (request.getParameter(MIN_NORMAL_VALUE) != null
				&& !(request.getParameter(MIN_NORMAL_VALUE).equals(""))) {
			minNormalValue = (request.getParameter(MIN_NORMAL_VALUE));
		}
		if (request.getParameter(MAX_NORMAL_VALUE) != null
				&& !(request.getParameter(MAX_NORMAL_VALUE).equals(""))) {
			maxNormalValue = (request.getParameter(MAX_NORMAL_VALUE));
		}
		if (request.getParameter(INVESTIGATION_TYPE) != null
				&& !(request.getParameter(INVESTIGATION_TYPE).equals(""))) {
			investigationType = (request.getParameter(INVESTIGATION_TYPE));
		}
		if (request.getParameter(CONFIDENTIAL) != null
				&& !(request.getParameter(CONFIDENTIAL).equals(""))) {
			checkBoxConfidence = (request.getParameter(CONFIDENTIAL));
		}
		if (request.getParameter(DSICHARGE_SUMMARY) != null
				&& !(request.getParameter(DSICHARGE_SUMMARY).equals(""))) {
			checkBoxDischargeSummary = (request.getParameter(DSICHARGE_SUMMARY));
		}
		String screenTest = "n";
		if (request.getParameter("bloodBankScreen") != null) {
			screenTest = (request.getParameter("bloodBankScreen"));
		}
		String reactionTest = "n";
		if (request.getParameter("bloodReactionTest") != null) {
			reactionTest = (request.getParameter("bloodReactionTest"));
		}
		
		String submittedByOPD = "n";
		if (request.getParameter("submittedByOPD") != null) {
			submittedByOPD = (request.getParameter("submittedByOPD"));
		}
		String phInvestigation = "n";
		if (request.getParameter("phInvestigation") != null) {
			phInvestigation = (request.getParameter("phInvestigation"));
		}
		if (request.getParameter(RARE_COMMON) != null) {
			rareCommon = request.getParameter(RARE_COMMON);
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
		if (request.getParameter("invShortCode") != null) {
			invShortCode = request.getParameter("invShortCode");
		}
		users = (Users) session.getAttribute(USERS);
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("invShortCode", invShortCode);
		generalMap.put("investigationId", investigationId);
		generalMap.put("lioncCodeId", lioncCodeId);
		generalMap.put("mainChargeId", mainChargeId);
		generalMap.put("variation", variation);
		generalMap.put("subChargeId", subChargeId);
		generalMap.put("chargeCodeId", chargeCodeId);
		generalMap.put("investigationName", investigationName);
		generalMap.put("minNormalValue", minNormalValue);
		generalMap.put("maxNormalValue", maxNormalValue);
		generalMap.put("investigationType", investigationType);
		generalMap.put("checkBoxConfidence", checkBoxConfidence);
		generalMap.put("checkBoxDischargeSummary", checkBoxDischargeSummary);
		generalMap.put("normalValue", normalValue);
		generalMap.put("quantity", quantity);
		generalMap.put("unitOfResult", unitOfResult);
		generalMap.put("collectionId", collectionId);
		generalMap.put("sampleId", sampleId);
		generalMap.put("rareCommon", rareCommon);
		generalMap.put("changedBy", changedBy);
		generalMap.put(USERS, users);
		generalMap.put("screenTest", screenTest);
		generalMap.put("reactionTest", reactionTest);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("remarks", remarks);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		
		generalMap.put("submittedByOPD", submittedByOPD);
		generalMap.put("phInvestigation", phInvestigation);
		
		logger.info("submittedByOPD in con="+submittedByOPD);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingInvestigationNameList = (List) listMap
				.get("duplicateMastersList");
		List existingInvestigationShortCodeList = (List) listMap.get("duplicateShortCodeList");
				
		boolean dataUpdated = false;
		if (existingInvestigationNameList.size() == 0 && existingInvestigationShortCodeList.size()==0) {
			dataUpdated = investigationHandlerService
					.editInvestigation(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingInvestigationNameList.size() > 0) {
			message = "Name already exists.";
		}
		else if (existingInvestigationShortCodeList.size() > 0) {
			message = "Investigation short code already exists.";
		}
		url = "/hms/hms/investigation?method=showInvestigationJsp";
		Box box = HMSUtil.getBox(request);
		try {
			map = investigationHandlerService.showInvestigationJsp(box);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (deptType.equalsIgnoreCase("radio")) {
			jsp = INVESTIGATION_DIAGNOSTICS_JSP;
		} else {
			jsp = INVESTIGATION_JSP;
		}
		title = "edit Investigation";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	/** end of edit investigation method * */

	/** start of delete investigation method * */
	@SuppressWarnings("deprecation")
	public ModelAndView deleteInvestigation(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in deleteInvestigation");
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int investigationId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		Box box = HMSUtil.getBox(request);
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}

		if (request.getParameter(INVESTIGATION_ID) != null
				&& !(request.getParameter(INVESTIGATION_ID).equals(""))) {
			investigationId = Integer.parseInt(request
					.getParameter(INVESTIGATION_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		Users users = (Users) request.getSession().getAttribute(USERS);
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put(USERS, users);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = investigationHandlerService.deleteInvestigation(
				investigationId, generalMap);
		if (dataDeleted == true) {

			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/investigation?method=showInvestigationJsp";
		try {
			map = investigationHandlerService.showInvestigationJsp(box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = INVESTIGATION_JSP;
		title = "Delete Investigation";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	/** end of delete investigation method * */

	/** method for subInvestigation screen * */
	public ModelAndView showSubInvestigationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in showSubInvestigationJsp");
		Map<String, Object> map = new HashMap<String, Object>();
		Map dataMap = new HashMap<String, Object>();
		int collectionCenterId = 0;
		int mainChargecodeId = 0;
		int subChargeCodeId = 0;
		int chargeCodeId = 0;
		int sampleId = 0;
		String investigationName = "";
		String confidential = "";
		String investigationType = "";
		String dischargeSummary = "";
		String rareCommon = "";
		String quantity = "";
		int pageNoTemp = 0;

		Box box = HMSUtil.getBox(request);
		map = investigationHandlerService.showInvestigationJsp(box);
		int pageNo = 1;

		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (request.getParameter(MAIN_CHARGECODE_ID) != null
				&& request.getParameter(MAIN_CHARGECODE_ID) != "") {
			mainChargecodeId = Integer.parseInt(request
					.getParameter(MAIN_CHARGECODE_ID));
		}
		if (request.getParameter(SUB_CHARGECODE_ID) != null) {
			subChargeCodeId = Integer.parseInt(request
					.getParameter(SUB_CHARGECODE_ID));
		}
		if (request.getParameter(CHARGE_CODE_ID) != null) {
			chargeCodeId = Integer.parseInt(request
					.getParameter(CHARGE_CODE_ID));
		}
		if (request.getParameter(INVESTIGATION_NAME) != null) {
			investigationName = request.getParameter(INVESTIGATION_NAME);
		}
		if (request.getParameter(CONFIDENTIAL) != null) {
			confidential = request.getParameter(CONFIDENTIAL);
		}
		if (request.getParameter("pageNoTemp") != null) {
			pageNoTemp = Integer.parseInt(request.getParameter("pageNoTemp"));
		}
		if (request.getParameter(QUANTITY) != null) {
			quantity = request.getParameter(QUANTITY);
		}
		if (request.getParameter(INVESTIGATION_TYPE) != null) {
			investigationType = request.getParameter(INVESTIGATION_TYPE);
		}
		if (request.getParameter(DSICHARGE_SUMMARY) != null) {
			dischargeSummary = request.getParameter(DSICHARGE_SUMMARY);
		}
		if (request.getParameter(SAMPLE_ID) != null) {
			sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
		}
		if (request.getParameter(COLLECTION_CENTER_ID) != null) {
			collectionCenterId = Integer.parseInt(request
					.getParameter(COLLECTION_CENTER_ID));
		}
		if (request.getParameter(RARE_COMMON) != null) {
			rareCommon = request.getParameter(RARE_COMMON);
		}
		List investigationList = new ArrayList();
		investigationList = investigationHandlerService.getChargeList(box);
		String jsp = "";
		if (investigationList.size() > 0) {
			jsp = "updateSubTest";
			map.put("investigationList", investigationList);
		} else {
			jsp = "investigationSubTest";
		}
		jsp += ".jsp";
		map.put("pageNoTemp", pageNoTemp);
		map.put("mainChargecodeId", mainChargecodeId);
		map.put("subChargeCodeId", subChargeCodeId);
		map.put("chargeCodeId", chargeCodeId);
		map.put("investigationName", investigationName);
		map.put("confidential", confidential);
		map.put("investigationType", investigationType);
		map.put("dischargeSummary", dischargeSummary);
		map.put("sampleId", sampleId);
		map.put("collectionCenterId", collectionCenterId);
		map.put("rareCommon", rareCommon);
		map.put("dataMap", dataMap);
		map.put("pageNo", pageNo);
		map.put("contentJsp", jsp);
		map.put("quantity", quantity);

		return new ModelAndView("index", "map", map);
	}

	/** end of method of subinvestigation screen * */

	/*
	 * public ModelAndView responseForSubCharge(HttpServletRequest request,
	 * HttpServletResponse response) { Map<String, Object> map = new
	 * HashMap<String, Object>(); Box box = HMSUtil.getBox(request);
	 * map=(Map<String
	 * ,Object>)investigationHandlerService.getResponseSubchargeList(box);
	 * jsp="responseForSubCharge"; return new ModelAndView(jsp,"map", map); }
	 */

	/*
	 * public ModelAndView responseForCharge(HttpServletRequest request,
	 * HttpServletResponse response) { Box box = HMSUtil.getBox(request);
	 * Map<String, Object> map = new HashMap<String, Object>(); map =
	 * investigationHandlerService.getChargeDetails(box);
	 * jsp=INVESTIGATION_CHARGE_JSP; return new ModelAndView(jsp,"map", map); }
	 */
	/*
	 * public ModelAndView showParameterJsp(HttpServletRequest request,
	 * HttpServletResponse response) { Box box = HMSUtil.getBox(request);
	 * Map<String, Object> map = new HashMap<String, Object>();
	 * map=investigationHandlerService.getParameterDetails(box); jsp =
	 * INVESTIGATION_SUBTEST_JSP; //jsp += ".jsp"; //map.put("contentJsp", jsp);
	 * return new ModelAndView(jsp, "map", map); }
	 */
	/*
	 * method to add the subtest
	 */
	/** method to add subTest * */
	public ModelAndView submitSubTest(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in submitSubTest");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String message = null;
		String name = "";
		String addOnlyInSubMasInvesrigation = "";
		int multiTestSize = 0;
		boolean dataSaved = false;
		Box box = HMSUtil.getBox(request);
		Users users = null;
		if (request.getSession().getAttribute(USERS) != null) {
			users = (Users) request.getSession().getAttribute(USERS);
			dataMap.put(USERS, users);
		}
		map = investigationHandlerService.showInvestigationJsp(box);
		if (map != null) {
			map.put("uomList", map.get("uomList"));
		}
		if (request.getParameter(INVESTIGATION_NAME) != null) {
			name = request.getParameter(INVESTIGATION_NAME);

		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");

		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("amcTDetailsListSize") != null) {
			multiTestSize = Integer.parseInt(request
					.getParameter("amcTDetailsListSize"));
		}
		dataMap.put("multiTestSize", multiTestSize);

		generalMap.put("name", name);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List chargeNameList = new ArrayList();
		if (listMap.get("duplicateGeneralNameList") != null) {
			chargeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		if (chargeNameList == null || chargeNameList.size() == 0) {
			infoMap = investigationHandlerService.addSubTest(box, dataMap);
			if ((Boolean) infoMap.get("dataSaved") == true) {
				message = "Data Successfully Saved !!";
			} else {
				message = "Data cannot be saved !!";
			}
			jsp = "investigationSubTest";
		} else if (chargeNameList.size() != 0 || chargeNameList != null) {
			if (request.getParameter("addInSubMas") != null) {
				addOnlyInSubMasInvesrigation = request
						.getParameter("addInSubMas");

				dataMap.put("dgMasInvestigationListForUpdateList",
						chargeNameList);
				infoMap = investigationHandlerService
						.addSubTestWithoutAddingInMasInvestigation(box, dataMap);
				if ((Boolean) infoMap.get("dataSaved") == true) {
					message = "Data Successfully Saved !!";
				} else {
					message = "Data cannot be saved !!";
				}
				jsp = "investigationSubTest";

			} else {
				message = "Charge Name already exists.";
				jsp = "investigation";
			}
		}

		jsp += ".jsp";
		map.put("message", message);
		map.put("dataSaved", infoMap.get("dataSaved"));
		map.put("contentJsp", jsp);
		map.put("title", title);
		if (infoMap != null) {
			map.put("subInvestigationlist", infoMap.get("subInvestigationlist"));
		}
		return new ModelAndView("index", "map", map);
	}

	/** end of method to add subtest * */

	/** method to submit normal values * */
	public ModelAndView submitNormalValues(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in submitNormalValues");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String message = null;
		boolean dataSaved = false;
		Box box = HMSUtil.getBox(request);
		int amcTDetailsListSize = Integer.parseInt(request
				.getParameter("amcTDetailsListSize"));
		box.put("amcTDetailsListSize", amcTDetailsListSize);
		dataSaved = investigationHandlerService.submitNormalValues(box);
		if (dataSaved == true) {
			message = "Data Successfully Saved !!";
		} else {
			message = "Data cannot be saved !!";
		}
		jsp = "normalValue";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/** end of method to submit normal values * */

	/** method to submit fixed values * */
	public ModelAndView submitFixedValues(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in submitFixedValues");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String message = null;
		boolean dataSaved = false;
		Box box = HMSUtil.getBox(request);
		dataSaved = investigationHandlerService.submitFixedValues(box);
		if (dataSaved == true) {
			message = "Data Successfully Saved !!";
		} else {
			message = "Data cannot be saved !!";
		}
		jsp = "fixedValue";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/** end of method to submit fixed values * */

	/***************************************************************************
	 * start of method to submit template
	 * 
	 * @throws IOException
	 */
	public ModelAndView submitTemplate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		logger.info("in submitTemplate");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		DgMasInvestigation dgMasInv = new DgMasInvestigation();
		DgTemplate dgTemp = new DgTemplate();

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		InputStream in = null;
		String message = null;
		boolean dataSaved = false;
		if (map != null) {
			map = (Map) session.getAttribute("map");
		}
		int mainChargecodeId = 0;
		int chargeCodeId = 0;
		int subChargeCodeId = 0;
		int sampleId = 0;
		int collectionCenterId = 0;
		int unitOfMeasurementId = 0;
		String investigationName = "";
		String confidential = "";
		String investigationType = "";
		String dischargeSummary = "";
		String quantity = "";
		String minNormalValue = "";
		String maxNormalValue = "";
		String normalValue = "";
		String rareCommon = "c";
		String variation = "n";
		String screenTest = "y";
		String reactionTest = "y";
		String deptType = "";
		Users users = null;
		mainChargecodeId = (Integer) map.get("mainChargecodeId");
		chargeCodeId = (Integer) map.get("chargeCodeId");
		subChargeCodeId = (Integer) map.get("subChargeCodeId");
		sampleId = (Integer) map.get("sampleId");
		collectionCenterId = (Integer) map.get("collectionCenterId");
		unitOfMeasurementId = (Integer) map.get("unitOfMeasurementId");
		investigationName = (String) map.get("investigationName");
		confidential = (String) map.get("confidential");
		investigationType = (String) map.get("investigationType");
		dischargeSummary = (String) map.get("dischargeSummary");
		quantity = (String) map.get("quantity");
		minNormalValue = (String) map.get("minNormalValue");
		maxNormalValue = (String) map.get("maxNormalValue");
		normalValue = (String) map.get("normalValue");
		if (map.get("variation") != null && (map.get("variation").equals("y"))) {
			variation = (String) map.get("rareCommon");
		}
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}
		if (map.get("bloodBankScreen") != null
				&& (map.get("bloodBankScreen").equals("n"))) {
			screenTest = (String) map.get("bloodBankScreen");
		}
		if (map.get("bloodReactionTest") != null
				&& (map.get("bloodReactionTest").equals("n"))) {
			reactionTest = (String) map.get("bloodReactionTest");
		}
		if (map.get("rareCommon") != null
				&& (map.get("rareCommon").equals("c"))) {
			rareCommon = (String) map.get("rareCommon");
		}
		if (session.getAttribute(USERS) != null) {
			users = (Users) session.getAttribute(USERS);
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		dgMasInv.setId(chargeCodeId);
		dgMasInv.setVariationRequired(variation);
		dgMasInv.setInvestigationName(investigationName);
		dgMasInv.setAppearInDischargeSummary(dischargeSummary);
		dgMasInv.setInvestigationType(investigationType);
		dgMasInv.setConfidential(confidential);

		if (normalValue != null && !(normalValue).equals("")) {
			dgMasInv.setNormalValue(normalValue);
		}
		if (minNormalValue != null && !(minNormalValue).equals("")) {
			dgMasInv.setMinNormalValue(minNormalValue);
		}
		if (minNormalValue != null && !(minNormalValue).equals("")) {
			dgMasInv.setMaxNormalValue(maxNormalValue);
		}
		if (screenTest != null && !(screenTest).equals("")) {
			dgMasInv.setBloodBankScreenTest(screenTest);
		}
		if (reactionTest != null && !(reactionTest).equals("")) {
			dgMasInv.setBloodReactionTest(reactionTest);
		}
		if (rareCommon != null && !(rareCommon).equals("")) {
			dgMasInv.setRareCommon(rareCommon);
		}
		if (subChargeCodeId != 0) {
			MasSubChargecode masSubChargecode = new MasSubChargecode();
			masSubChargecode.setId(subChargeCodeId);
			dgMasInv.setSubChargecode(masSubChargecode);
		}
		MasChargeCode masChargeCode = new MasChargeCode();
		if (chargeCodeId != 0) {
			masChargeCode.setId(chargeCodeId);
			dgMasInv.setChargeCode(masChargeCode);
		}
		if (mainChargecodeId != 0) {
			MasMainChargecode masMainChargecode = new MasMainChargecode();
			masMainChargecode.setId(mainChargecodeId);
			dgMasInv.setMainChargecode(masMainChargecode);
		}
		if (sampleId != 0) {
			MasSample masSample = new MasSample();
			masSample.setId(sampleId);
			dgMasInv.setSample(masSample);
		}

		if (collectionCenterId != 0) {
			DgMasCollection dgMasCollection = new DgMasCollection();
			dgMasCollection.setId(collectionCenterId);
			dgMasInv.setCollection(dgMasCollection);
		}
		if (unitOfMeasurementId != 0) {
			DgUom dgUom = new DgUom();
			dgUom.setId(unitOfMeasurementId);
			dgMasInv.setUom(dgUom);
		}
		dgMasInv.setStatus("y");
		if (quantity != null && !(quantity).equals("")) {
			dgMasInv.setQuantity(quantity);
		}
		dgMasInv.setLastChgBy(users);
		dgMasInv.setLastChgDate(date);
		dgMasInv.setLastChgTime(time);
		/*
		 * if(investigationType.equalsIgnoreCase("m")){
		 * dgMasInv.setMultipleResults("y"); }else{
		 * dgMasInv.setMultipleResults("n"); }
		 */
		try {

			// File temprory=new
			// File(getServletContext().getRealPath("/temp/"+"temp.html") );
			// long length=temprory.length();
			// FileInputStream fis=new
			// FileInputStream(getServletContext().getRealPath("/temp/"+"temp.html"));
			// byte[] bytes = new byte[(int)length];
			//
			// // Read in the bytes
			// int offset = 0;
			// int numRead = 0;
			// while ( (offset < bytes.length)
			// &&
			// ( (numRead=fis.read(bytes, offset, bytes.length-offset)) >= 0) )
			// {
			//
			// offset += numRead;
			//
			// }
			//
			// // Ensure all the bytes have been read in
			// if (offset < bytes.length) {
			// throw new IOException("Could not completely read file " +
			// temprory.getName());
			// }
			//
			// fis.close();

			MultipartFormDataRequest mrequest = null;

			if (MultipartFormDataRequest.isMultipartFormData(request)) {
				try {
					mrequest = new MultipartFormDataRequest(request);
				} catch (UploadException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			String tepmlateData = mrequest.getParameter("test2");
			InputStream fis1 = new FileInputStream(getServletContext()
					.getRealPath("jsp/pdf/appendingHtml.html"));
			File temprory2 = new File(getServletContext().getRealPath(
					"jsp/pdf/appendingHtml.html"));

			byte[] b1 = new byte[(int) temprory2.length()];
			int offset1 = 0;
			int numRead1 = 0;
			try {
				while ((offset1 < b1.length)
						&& ((numRead1 = fis1.read(b1, offset1, b1.length
								- offset1)) >= 0)) {
					offset1 += numRead1;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fis1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String appendedHtml = new String(b1);
			// String finalFile = appendedHtml + tepmlateData +
			// "</body></html>";
			String finalFile = tepmlateData;

			byte[] bytes = finalFile.getBytes();
			bytes = Base64.encodeBase64(finalFile.getBytes());
			dgTemp.setResult(bytes);
			dgTemp.setInvestigation(dgMasInv);
			dgTemp.setChargeCode(masChargeCode);
			// dataMap.put("investigationType",investigationType);
			dataMap.put("dgMasInv", dgMasInv);
			dataMap.put("dgTemp", dgTemp);
			dataMap.put("chargeCodeId", chargeCodeId);

			/* validation for not duplicate entry of charge name */
			String name = "";
			if (request.getParameter(INVESTIGATION_NAME) != null) {
				name = request.getParameter(INVESTIGATION_NAME);
			}
			if (request.getParameter("pojoName") != null) {
				pojoName = request.getParameter("pojoName");
			}
			if (request.getParameter("pojoPropertyName") != null) {
				pojoPropertyName = request.getParameter("pojoPropertyName");
			}
			generalMap.put("investigationType", investigationType);
			generalMap.put("name", name);
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);

			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
			List chargeNameList = new ArrayList();
			if (listMap.get("duplicateGeneralNameList") != null) {
				chargeNameList = (List) listMap.get("duplicateGeneralNameList");
			}
			if (chargeNameList.size() == 0 || chargeNameList == null) {
				dataSaved = investigationHandlerService.submitTemplate(dataMap);
				if (dataSaved == true) {
					message = "Template Successfully Saved !!";
					List<DgTemplate> templateList = new ArrayList<DgTemplate>();
					templateList = investigationHandlerService
							.getTemplateList(chargeCodeId);
					map.put("templateList", templateList);
				} else {
					message = "Template cannot be saved !!";
				}
				jsp = "template";
			} else if (chargeNameList.size() != 0 || chargeNameList != null) {
				message = "Charge Name already exists.";
				if (deptType.equalsIgnoreCase("radio")) {
					jsp = INVESTIGATION_DIAGNOSTICS_JSP;
				} else {
					jsp = "investigation";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp += ".jsp";
		// map.put("investigationType",investigationType);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/** method to submit template * */

	/** start of method to show normal value screen * */
	public ModelAndView showNormalValue(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in showNormalValue");
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int rowNo = 0;
		int subTestId = 0;
		int chargeCodeId = 0;
		if (request.getParameter("rowNo") != null) {
			rowNo = Integer.parseInt(request.getParameter("rowNo"));
		}
		if (request.getParameter("subTestId") != null) {
			subTestId = Integer.parseInt(request.getParameter("subTestId"));
		}
		if (request.getParameter("chargeCodeId") != null) {
			chargeCodeId = Integer.parseInt(request
					.getParameter("chargeCodeId"));
		}
		List<DgNormalValue> normalValueList = new ArrayList<DgNormalValue>();
		map = investigationHandlerService.getNormalValueDetails(box);
		if (map.get("normalValueList") != null) {
			normalValueList = (List<DgNormalValue>) map.get("normalValueList");
		}
		if (normalValueList.size() > 0) {
			jsp = UPDATE_NORMAL_VALUE_JSP;
		} else {
			jsp = NORMAL_VALUE_JSP;
		}
		title = "Normal Value";
		map.put("title", title);
		map.put("rowNo", rowNo);
		map.put("subTestId", subTestId);
		map.put("chargeCodeId", chargeCodeId);
		map.put("normalValueList", normalValueList);
		return new ModelAndView(jsp, "map", map);
	}

	/** end of method to show normal value screen* */

	/** start of method to show fixed value jsp * */
	public ModelAndView showFixedValue(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in showFixedValue");
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int rowNo = 0;
		int subTestId = 0;
		int chargeCodeId = 0;
		if (request.getParameter("rowNo") != null) {
			rowNo = Integer.parseInt(request.getParameter("rowNo"));
		}
		if (request.getParameter("subTestId") != null) {
			subTestId = Integer.parseInt(request.getParameter("subTestId"));
		}
		if (request.getParameter("chargeCodeId") != null) {
			chargeCodeId = Integer.parseInt(request
					.getParameter("chargeCodeId"));
		}
		List<DgFixedValue> fixedList = new ArrayList<DgFixedValue>();
		map = investigationHandlerService.getFixedList(box);
		if (map.get("fixedList") != null) {
			fixedList = (List<DgFixedValue>) map.get("fixedList");
		}
		if (fixedList.size() > 0) {
			jsp = UPDATE_FIXED_VALUE_JSP;
		} else {
			jsp = FIXED_VALUE_JSP;
		}
		title = "Fixed Value";
		map.put("title", title);
		map.put("rowNo", rowNo);
		map.put("subTestId", subTestId);
		map.put("chargeCodeId", chargeCodeId);
		map.put("fixedList", fixedList);
		return new ModelAndView(jsp, "map", map);
	}

	/** end of method to show fixed value jsp * */

	public ModelAndView viewSubTest(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in viewSubTest");
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = investigationHandlerService.getParameterDetails(box);
		jsp = VIEW_SUBTEST_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showUpdateSubTest(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in showUpdateSubTest");
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int chargeCodeId = 0;
		int subTestId = 0;
		int mainChargecodeId = 0;
		int subChargeCodeId = 0;
		if (request.getParameter(CHARGE_CODE_ID) != null) {
			chargeCodeId = Integer.parseInt(request
					.getParameter(CHARGE_CODE_ID));
		}
		if (request.getParameter(SUBTEST_ID) != null) {
			subTestId = Integer.parseInt(request.getParameter(SUBTEST_ID));
		}
		if (request.getParameter(MAIN_CHARGECODE_ID) != null) {
			mainChargecodeId = Integer.parseInt(request
					.getParameter(MAIN_CHARGECODE_ID));
		}

		if (request.getParameter(SUB_CHARGECODE_ID) != null) {
			subChargeCodeId = Integer.parseInt(request
					.getParameter(SUB_CHARGECODE_ID));
		}
		map = investigationHandlerService.showInvestigationJsp(box);
		List investigationList = new ArrayList();
		investigationList = investigationHandlerService.getChargeList(box);
		jsp = "updateSubTest";
		title = "update SubTest";
		jsp += ".jsp";
		map.put("investigationList", investigationList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("chargeCodeId", chargeCodeId);
		map.put("mainChargecodeId", mainChargecodeId);
		map.put("subChargeCodeId", subChargeCodeId);
		map.put("subTestId", subTestId);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateSubTest(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in updateSubTest");
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		String messageTOBeVisibleToTheUser = "";
		boolean dataUpdated = false;
		dataUpdated = investigationHandlerService.updateSubTest(box);
		if (dataUpdated == false) {
			messageTOBeVisibleToTheUser = "Sub Test Updated Successfully !!";
		} else {
			messageTOBeVisibleToTheUser = "Sub Test Cant Be Updated !!";
		}
		url = "/hms/hms/investigation?method=showInvestigationJsp";
		jsp = "message";
		title = "update SubTest";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("url", url);
		return new ModelAndView("index", "map", map);
	}

	// =============== for template ==================
	public ModelAndView showTemplateJsp(HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException,
			IOException {
		logger.info("in showTemplateJsp");
		Map<String, Object> map = new HashMap<String, Object>();
		int mainChargecodeId = 0;
		int subChargeCodeId = 0;
		int chargeCodeId = 0;
		String investigationName = "";
		String confidential = "";
		String investigationType = "";
		String dischargeSummary = "";
		String quantity = "";
		String rareCommon = "";
		String screenTest = "";
		String reactionTest = "";
		String deptType = "";
		int sampleId = 0;
		int collectionCenterId = 0;
		int unitOfMeasurementId = 0;
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}
		Box box = HMSUtil.getBox(request);
		map = investigationHandlerService.showInvestigationJsp(box);
		if (request.getParameter(MAIN_CHARGECODE_ID) != null
				&& request.getParameter(MAIN_CHARGECODE_ID) != "") {
			mainChargecodeId = Integer.parseInt(request
					.getParameter(MAIN_CHARGECODE_ID));
		}
		if (request.getParameter(SUB_CHARGECODE_ID) != null) {
			subChargeCodeId = Integer.parseInt(request
					.getParameter(SUB_CHARGECODE_ID));
		}
		if (request.getParameter(CHARGE_CODE_ID) != null) {
			chargeCodeId = Integer.parseInt(request
					.getParameter(CHARGE_CODE_ID));
		}
		if (request.getParameter(UNIT_OF_MEASUREMENT_ID) != null) {
			unitOfMeasurementId = Integer.parseInt(request
					.getParameter(UNIT_OF_MEASUREMENT_ID));
		}
		if (request.getParameter(SAMPLE_ID) != null) {
			sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
		}
		if (request.getParameter(COLLECTION_CENTER_ID) != null) {
			collectionCenterId = Integer.parseInt(request
					.getParameter(COLLECTION_CENTER_ID));
		}
		if (request.getParameter(QUANTITY) != null) {
			quantity = request.getParameter(QUANTITY);
		}
		if (request.getParameter(INVESTIGATION_NAME) != null) {
			investigationName = request.getParameter(INVESTIGATION_NAME);
		}
		if (request.getParameter(CONFIDENTIAL) != null) {
			confidential = request.getParameter(CONFIDENTIAL);
		}
		if (request.getParameter(RARE_COMMON) != null) {
			rareCommon = request.getParameter(RARE_COMMON);
		}
		if (request.getParameter(BLOOD_BANK_SCREEN) != null) {
			screenTest = request.getParameter(BLOOD_BANK_SCREEN);
		}
		if (request.getParameter(BLOOD_REACTION_TEST) != null) {
			reactionTest = request.getParameter(BLOOD_REACTION_TEST);
		}
		if (request.getParameter(INVESTIGATION_TYPE) != null) {
			investigationType = request.getParameter(INVESTIGATION_TYPE);
		}
		if (request.getParameter(DSICHARGE_SUMMARY) != null) {
			dischargeSummary = request.getParameter(DSICHARGE_SUMMARY);
		}
		List<DgTemplate> templateList = new ArrayList<DgTemplate>();
		templateList = investigationHandlerService
				.getTemplateList(chargeCodeId);
		String jsp = "";
		String format = "";
		new File(getServletContext().getRealPath("/temp/")).mkdir();
		File tempFile = new File(getServletContext().getRealPath(
				"/temp/" + "temp.html"));
		if (!tempFile.exists()) {
			tempFile.createNewFile();

		}
		if (templateList.size() > 0) {
			jsp = "updateTemplate";
			// code for saving template to server path
			map.put("templateList", templateList);
			// codde for adding appended html
			String appendingHtml = "";
			String templatedata = "";
			// String templateData = new String(templateList.get(0).getResult());
			String templateData = new String(Base64.decodeBase64(templateList.get(0).getResult()));
			
			if (!templateData.contains("<html xmlns:")) {
				InputStream is = new FileInputStream(getServletContext()
						.getRealPath("jsp/pdf/appendingHtml.html"));
				File temprory1 = new File(getServletContext().getRealPath(
						"jsp/pdf/appendingHtml.html"));

				byte[] b3 = new byte[(int) temprory1.length()];
				int offset = 0;
				int numRead = 0;
				while ((offset < b3.length)
						&& ((numRead = is.read(b3, offset, b3.length - offset)) >= 0)) {

					offset += numRead;
				}

				File temprory = new File(getServletContext().getRealPath(
						"/temp/" + "temp.html"));
				appendingHtml = new String(b3);
				templatedata = new String(Base64.decodeBase64(templateList.get(0).getResult()));
				// templatedata = appendingHtml + templatedata + "</body></html>";
				templatedata = appendingHtml + templatedata;
				FileOutputStream fos = new FileOutputStream(getServletContext()
						.getRealPath("/temp/" + "temp.html"));
				fos.write(templatedata.getBytes());
				// map.put("appendedHtml", appendingHtml);
				map.put("appendedHtml", templatedata);
				fos.close();

				is.close();
			} else {
				FileOutputStream fos = new FileOutputStream(getServletContext()
						.getRealPath("/temp/" + "temp.html"));
				fos.write(templateList.get(0).getResult());
				fos.close();
			}
		} else {
			jsp = TEMPLATE_JSP;
		}
		title = "Template";
		jsp += ".jsp";
		map.put("mainChargecodeId", mainChargecodeId);
		map.put("subChargeCodeId", subChargeCodeId);
		map.put("chargeCodeId", chargeCodeId);
		map.put("investigationName", investigationName);
		map.put("screenTest", screenTest);
		map.put("reactionTest", reactionTest);
		map.put("confidential", confidential);
		map.put("investigationType", investigationType);
		map.put("dischargeSummary", dischargeSummary);
		map.put("sampleId", sampleId);
		map.put("collectionCenterId", collectionCenterId);
		map.put("contentJsp", jsp);
		map.put("quantity", quantity);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("unitOfMeasurementId", unitOfMeasurementId);
		map.put("deptType", deptType);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateTemplate(HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException,
			IOException {
		logger.info("in updateTemplate");
		Map<String, Object> map = new HashMap<String, Object>();
		int templateId = 0;
		String result = "";
		String deptType = "";
		MultipartFormDataRequest mrequest = null;
		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String tepmlateData = mrequest.getParameter("test2");
		InputStream fis1 = new FileInputStream(getServletContext().getRealPath(
				"jsp/pdf/appendingHtml.html"));
		File temprory2 = new File(getServletContext().getRealPath(
				"jsp/pdf/appendingHtml.html"));
		byte[] b1 = new byte[(int) temprory2.length()];
		int offset1 = 0;
		int numRead1 = 0;

		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}
		try {
			while ((offset1 < b1.length)
					&& ((numRead1 = fis1.read(b1, offset1, b1.length - offset1)) >= 0)) {
				offset1 += numRead1;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fis1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String appendedHtml = new String(b1);
		String finalFile = "";
			
			if(tepmlateData!=null && tepmlateData.indexOf("<html>")>-1)
				finalFile = appendedHtml + tepmlateData;
			else
				finalFile = appendedHtml + tepmlateData;
			
		byte[] bytes = finalFile.getBytes();
		
		bytes = Base64.encodeBase64(finalFile.getBytes());

		// File temprory=new
		// File(getServletContext().getRealPath("/temp/"+"temp.html") );
		// long length=temprory.length();
		// FileInputStream fis=new
		// FileInputStream(getServletContext().getRealPath("/temp/"+"temp.html"));
		// byte[] bytes = new byte[(int)length];
		//
		// // Read in the bytes
		// int offset = 0;
		// int numRead = 0;
		// while ( (offset < bytes.length)
		// &&
		// ( (numRead=fis.read(bytes, offset, bytes.length-offset)) >= 0) ) {
		//
		// offset += numRead;
		//
		// }
		//
		// // Ensure all the bytes have been read in
		// if (offset < bytes.length) {
		// throw new IOException("Could not completely read file " +
		// temprory.getName());
		// }
		//
		// fis.close();
		map.put("result", bytes);
		if (mrequest.getParameter(TEMPLATE_ID) != null) {
			templateId = Integer.parseInt(mrequest.getParameter(TEMPLATE_ID));
		}

		map.put("templateId", templateId);
		map.put("result", bytes);
		String messageTOBeVisibleToTheUser = "";
		boolean dataUpdated = false;
		dataUpdated = investigationHandlerService.updateTemplate(map);
		if (dataUpdated == true) {
			messageTOBeVisibleToTheUser = "Template Updated Successfully !!";
		} else {
			messageTOBeVisibleToTheUser = "Template Cant Be Updated !!";
		}
		if (deptType.equalsIgnoreCase("radio")) {
			url = "/hms/hms/investigation?method=showInvestigationForRadiologyJsp";
		} else {
			url = "/hms/hms/investigation?method=showInvestigationJsp";
		}
		jsp = "message";
		title = "update Template";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("url", url);
		map.put("deptType", deptType);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView showUpdateTemplateInMsword(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		logger.info("in showUpdateTemplateInMsword");
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			Box box = HMSUtil.getBox(request);

			// Runtime rt = Runtime.getRuntime();
			// try{
			// Process p = rt.exec("\"c:\\Program Files\\Microsoft
			// Office\\Office\\WINWORD.exe\"
			// E:\\shailesh\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\HMS\\templates\\masterTemplates\\1-8-22.doc");
			// }
			// catch(Exception e){
			// e.printStackTrace();
			// }

			if (session.getAttribute("url") != null) {

				File tempFile = new File((String) session.getAttribute("url"));

				int lenght = (int) tempFile.length();
				byte data[] = new byte[lenght];

				ServletOutputStream out = response.getOutputStream();
				response.setContentLength(lenght);
				response.setContentType("application/msword");
				response.setHeader("Content-disposition",
						"attachment; filename=" + "Example.doc");
				// out.write(data, 0, lenght);
				InputStream in = new FileInputStream(tempFile);

				// File file=new File(box.getString("url"));
				bis = new BufferedInputStream(in);

				bos = new BufferedOutputStream(out);
				byte[] buff = new byte[2048];
				int bytesRead;
				// Simple read/write loop.
				while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
					bos.write(buff, 0, bytesRead);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				bis.close();
			}
			if (bos != null) {
				bos.close();
			}
		}

		return null;

	}

	// ================================ methods for pending result entry
	// =============
	public ModelAndView showPendingResultEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in showPendingResultEntryJsp");
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		int userId = 0;  // added by amit das on 17-07-2017
		
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

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		
		// added by amit das on 17-07-2017
		if (session.getAttribute("userId") != null) {
			userId = (int) session.getAttribute("userId");
		}
		
		int hinId = box.getInt("hinId");
		String RequisitionFrom = box.getString("RequisitionFrom");
		
		
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		mapForDs.put(RequestConstants.HOSPITAL_ID, hospitalId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		
		mapForDs.put("hinId", hinId);
		mapForDs.put("RequisitionFrom", RequisitionFrom);
		dataMap.put("userId", userId); // added by amit das on 17-07-2017
		mapForDs.put("userId",userId); // added by amit das on 17-07-2017
		
		
		detailsMap = investigationHandlerService.getDetailsForSearch(dataMap);
		patientMap = investigationHandlerService.getResultGrid(mapForDs);
		String jsp = DG_PENDING_RESULT_ENTRY;
		jsp += ".jsp";
		
		detailsMap.put("userId",userId); // added by amit das on 17-07-2017

		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showPendingResultEntryJspForQC(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in showPendingResultEntryJspForQC");
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
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

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		mapForDs.put(RequestConstants.HOSPITAL_ID, hospitalId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		detailsMap = investigationHandlerService.getDetailsForSearch(dataMap);
		patientMap = investigationHandlerService.getResultGrid(mapForDs);
		String jsp =RequestConstants.DG_PENDING_RESULT_ENTRY_FOR_QC;
		jsp += ".jsp";

		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatient(HttpServletRequest request,
			HttpServletResponse response) {
       logger.info("in searchPatient");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String patientFName = "";
		String orderStatus = "";
		String adNo = "";
		String hinNo = "";
		int inpatientId = 0;
		int subChargeCodeId = 0;
		int hinId = 0;
		String orderType = "";

		int sampleCollectionDetailId = 0;
		
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		String deptName = "";
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);

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
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}

		Map<String, Object> dataMap = new HashMap<String, Object>(); 

		try {

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !request.getParameter(INPATIENT_ID).equals("")
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
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
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
			if (request.getParameter(ORDER_STATUS) != null
					&& !(request.getParameter(ORDER_STATUS).equals("0"))) {
				orderStatus = request.getParameter(ORDER_STATUS);
				mapForDs.put("orderStatus", orderStatus);
			}
			if (request.getParameter(SAMPLE_COLLECTION_DETAIL_ID) != null
					&& !(request.getParameter(SAMPLE_COLLECTION_DETAIL_ID)
							.equals("0"))) {
				sampleCollectionDetailId = Integer.parseInt(request
						.getParameter(SAMPLE_COLLECTION_DETAIL_ID));
				mapForDs.put("sampleCollectionDetailId",
						sampleCollectionDetailId);
			}
			mapForDs.put("deptId", deptId);
			mapForDs.put("hospitalId", hospitalId);
			dataMap.put("deptId", deptId);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("userName", userName);
			dataMap.put("deptName", deptName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = investigationHandlerService.getPatientDetails(mapForDs);

		String jsp = "";
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailsList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailsList");

		}
		Map<String, Object> diagMap = new HashMap<String, Object>();
		if (sampleCollectionDetailId != 0) {

			map = investigationHandlerService.getSampleCollectionDetails(
					sampleCollectionDetailId, deptId);
			List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
			if (map.get("sampleCollectionList") != null) {
				sampleCollectionList = (List<DgSampleCollectionDetails>) map
						.get("sampleCollectionList");
			}
			DgMasInvestigation dgmasInvestigation = new DgMasInvestigation();
			Set<DgSubMasInvestigation> dgSubSet = new HashSet<DgSubMasInvestigation>();
			int invForDetail = 0;
			int inv = 0;
			String result = "";
			String resultType = "";
			String normalValue = "";
			for (DgSampleCollectionDetails dgSampleDetail : sampleCollectionList) {
				invForDetail = dgSampleDetail.getInvestigation().getId();
				normalValue = dgSampleDetail.getInvestigation()
						.getNormalValue();
				resultType = dgSampleDetail.getInvestigation()
						.getInvestigationType();
				dgSubSet = dgSampleDetail.getInvestigation().getChargeCode()
						.getDgSubMasInvestigations();
				for (DgSubMasInvestigation dgMas : dgSubSet) {
					inv = dgMas.getInvestigation().getId();
					result = dgMas.getResultType();
				}
				if (resultType.equalsIgnoreCase("m")) {
					jsp = DG_RESULT_ENTRY_MULTIPLE_PARAMETER + ".jsp";
				} else if (resultType.equalsIgnoreCase("s")) {
					jsp = DG_RESULT_ENTRY_SINGLE_PARAMETER_WITH_NORMAL_VALUE
							+ ".jsp";
				} else if (resultType.equalsIgnoreCase("t")) {
					jsp = DG_RESULT_ENTRY_TEMPLATE + ".jsp";
				} else if (resultType.equalsIgnoreCase("v")) {
					detailsMap = investigationHandlerService
							.getDetails(dataMap);
					jsp = DG_RESULT_ENTRY_SENSITIVE + ".jsp";
				}
			}
			String resultSeqNo = "";
			resultSeqNo = investigationHandlerService
					.generateResultNumber(diagMap);
			if (resultSeqNo != "") {
				map.put("resultSeqNo", resultSeqNo);
			}
		} else {
			detailsMap = investigationHandlerService.getDetails(dataMap);
			jsp = DG_PENDING_RESULT_ENTRY + ".jsp";
		}
		if (request.getParameter("browse") != null
				&& !request.getParameter("browse").equals("")) {
			map.put("browse", request.getParameter("browse"));
		}
		//System.out.println(jsp);
		patientMap.put("patientList", patientList);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("dataMap", dataMap);
		map.put("deptName", deptName);
		map.put("sampleCollectionDetailId",sampleCollectionDetailId);
		return new ModelAndView("index", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForQC(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in searchPatientForQC");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String patientFName = "";
		String orderStatus = "";
		String adNo = "";
		String hinNo = "";
		int departmentId = 0;
		int inpatientId = 0;
		int subChargeCodeId = 0;
		int hinId = 0;
		String orderType = "";

		int sampleCollectionDetailId = 0;
		String diagnosisNo = "";

		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		String deptName = "";
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);

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
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}

		Map<String, Object> dataMap = new HashMap<String, Object>(); 

		try {

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !request.getParameter(INPATIENT_ID).equals("")
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
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
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
			if (request.getParameter(ORDER_STATUS) != null
					&& !(request.getParameter(ORDER_STATUS).equals("0"))) {
				orderStatus = request.getParameter(ORDER_STATUS);
				mapForDs.put("orderStatus", orderStatus);
			}
			if (request.getParameter(SAMPLE_COLLECTION_DETAIL_ID) != null
					&& !(request.getParameter(SAMPLE_COLLECTION_DETAIL_ID)
							.equals("0"))) {
				sampleCollectionDetailId = Integer.parseInt(request
						.getParameter(SAMPLE_COLLECTION_DETAIL_ID));
				mapForDs.put("sampleCollectionDetailId",
						sampleCollectionDetailId);
			}
			mapForDs.put("deptId", deptId);
			mapForDs.put("hospitalId", hospitalId);
			dataMap.put("deptId", deptId);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("userName", userName);
			dataMap.put("deptName", deptName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = investigationHandlerService.getPatientDetails(mapForDs);

		String jsp = "";
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailsList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailsList");

		}
		Map<String, Object> diagMap = new HashMap<String, Object>();
		if (sampleCollectionDetailId != 0) {

			map = investigationHandlerService.getSampleCollectionDetails(
					sampleCollectionDetailId, deptId);
			List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
			if (map.get("sampleCollectionList") != null) {
				sampleCollectionList = (List<DgSampleCollectionDetails>) map
						.get("sampleCollectionList");
			}
			DgMasInvestigation dgmasInvestigation = new DgMasInvestigation();
			Set<DgSubMasInvestigation> dgSubSet = new HashSet<DgSubMasInvestigation>();
			String resultType = "";
			for (DgSampleCollectionDetails dgSampleDetail : sampleCollectionList) {
				resultType = dgSampleDetail.getInvestigation()
						.getInvestigationType();
				dgSubSet = dgSampleDetail.getInvestigation().getChargeCode()
						.getDgSubMasInvestigations();
				
				if (resultType.equalsIgnoreCase("m")) {
					jsp = DG_RESULT_ENTRY_MULTIPLE_PARAMETER + ".jsp";
				} else if (resultType.equalsIgnoreCase("s")) {
					jsp = DG_RESULT_ENTRY_SINGLE_PARAMETER_WITH_NORMAL_VALUE
							+ ".jsp";
				} else if (resultType.equalsIgnoreCase("t")) {
					jsp = DG_RESULT_ENTRY_TEMPLATE + ".jsp";
				} else if (resultType.equalsIgnoreCase("v")) {
					detailsMap = investigationHandlerService
							.getDetails(dataMap);
					jsp = DG_RESULT_ENTRY_SENSITIVE + ".jsp";
				}
			}
			String resultSeqNo = "";
			resultSeqNo = investigationHandlerService
					.generateResultNumber(diagMap);
			if (resultSeqNo != "") {
				map.put("resultSeqNo", resultSeqNo);
			}
		} else {
			detailsMap = investigationHandlerService.getDetails(dataMap);
			jsp =RequestConstants.DG_PENDING_RESULT_ENTRY_FOR_QC + ".jsp";
		}
		if (request.getParameter("browse") != null
				&& !request.getParameter("browse").equals("")) {
			map.put("browse", request.getParameter("browse"));
		}
		patientMap.put("patientList", patientList);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("dataMap", dataMap);
		map.put("deptName", deptName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchForTemplateDetailsLab(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {
		logger.info("in searchForTemplateDetailsLab");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<DgResultEntryDetail> dgResultEntryDetailListForResult = new ArrayList<DgResultEntryDetail>();
		String CombinedIds = "";
		int sampleCollectionDetailId = 0;
		String jsp = "";
		int resultEnteredBy = 0;
		String userName = "";
		String resultSeqNo = "";
		int hospitalId = 0;
		String appendedHtml = "";
		int deptId = 0;
		String deptName = "";
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);

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
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();

		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		if (request.getParameter(DG_SAMPLE_DETAIL_ID_TEMPLATE) != null
				&& !(request.getParameter(DG_SAMPLE_DETAIL_ID_TEMPLATE)
						.equals("0"))) {
			sampleCollectionDetailId = Integer.parseInt(request
					.getParameter(DG_SAMPLE_DETAIL_ID_TEMPLATE));
			mapForDs.put("sampleCollectionDetailId", sampleCollectionDetailId);
			detailsMap
					.put("sampleCollectionDetailId", sampleCollectionDetailId);

		}
		if (request.getParameter(RESULT_NO_TEMPLATE) != null
				&& !(request.getParameter(RESULT_NO_TEMPLATE).equals("0"))) {
			resultSeqNo = (String) request.getParameter(RESULT_NO_TEMPLATE);
			mapForDs.put("resultSeqNo", resultSeqNo);
			detailsMap.put("resultSeqNo", resultSeqNo);
		}
		if (request.getParameter(RESULT_ENTERED_BY) != null
				&& !(request.getParameter(RESULT_ENTERED_BY).equals("0"))) {
			resultEnteredBy = Integer.parseInt(request
					.getParameter(RESULT_ENTERED_BY));
			mapForDs.put("resultEnteredBy", resultEnteredBy);
			detailsMap.put("resultEnteredBy", resultEnteredBy);
		}
		if (request.getParameter("CombinedIds") != null
				&& !(request.getParameter("CombinedIds").equals("0"))) {
			CombinedIds = (String) request.getParameter("CombinedIds");
			mapForDs.put("CombinedIds", CombinedIds);
			detailsMap.put("CombinedIds", CombinedIds);
		}

		mapForDs.put("deptId", deptId);

		if (sampleCollectionDetailId != 0) {
			map = investigationHandlerService.getSampleCollectionDetails(
					sampleCollectionDetailId, deptId);
			List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
			if (map.get("sampleCollectionList") != null) {
				sampleCollectionList = (List<DgSampleCollectionDetails>) map
						.get("sampleCollectionList");
			}
			if (map.get("dgResultEntryDetailListForResult") != null) {
				dgResultEntryDetailListForResult = (List<DgResultEntryDetail>) map
						.get("dgResultEntryDetailListForResult");
			}

			String resultType = "";

			for (DgSampleCollectionDetails dgSampleDetail : sampleCollectionList) {
				resultType = dgSampleDetail.getInvestigation()
						.getInvestigationType();

				if (resultType.equalsIgnoreCase("t")) {
					new File(getServletContext().getRealPath("/temp/")).mkdir();
					try {
						File tempFile = new File(getServletContext()
								.getRealPath("/temp/" + "temp.html"));
						if (!tempFile.exists()) {
							tempFile.createNewFile();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}

					DgTemplate dgTemplate = new DgTemplate();
					if (sampleCollectionList.get(0).getInvestigation()
							.getDgTemplates() != null
							&& sampleCollectionList.get(0).getInvestigation()
									.getDgTemplates().size() > 0) {
						/*
						 * for (DgTemplate dgTemplate1 : sampleCollectionList
						 * .get(0).getInvestigation().getDgTemplates()) {
						 * dgTemplate = dgTemplate1; }
						 */
					}
					if (dgTemplate != null
							|| dgResultEntryDetailListForResult.size() > 0) {
						// String result1=new String(dgTemplate.getResult());
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
					}

					jsp = PENDING_RESULT_ENTRY_TEMPLATE + ".jsp";
				}

			}
		}

		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("dataMap", dataMap);
		map.put("deptName", deptName);
		map.put("appendedHtml", appendedHtml);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getFileNameForLab(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in getFileNameForLab");
		String uploadURL = "";
		MultipartFormDataRequest mrequest = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if ((Map) request.getSession().getAttribute("map") != null) {
				map = (Map) request.getSession().getAttribute("map");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		String filePath = "";
		String fileContent = "";
		UploadFile file = null;
		InputStream is = null;
		String Format = "";
		Properties properties = new Properties();
		FileOutputStream fos = null;
		ModelAndView mv1 = null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("file.properties");

		try {
			properties.load(resourcePath.openStream());
			uploadURL = properties.getProperty("uploadinvestigationfile");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			new File(getServletContext().getRealPath("/temp/")).mkdir();
			if (MultipartFormDataRequest.isMultipartFormData(request)) {
				try {
					if (request.getParameter("browse") != null
							&& !request.getParameter("browse").equals("")) {

						map.put("browse", "browse");
					}
					if (request.getParameter("browseInResultEntry") != null
							&& !request.getParameter("browseInResultEntry")
									.equals("")) {
						session.setAttribute("browseInResultEntry",
								"browseInResultEntry");
						map.put("browse", "browse");
					}

					mrequest = new MultipartFormDataRequest(request);
					String temlateData = "";

					if (mrequest.getParameter("test2") != null
							&& !(mrequest.getParameter("test2").equals(""))) {
						temlateData = (mrequest.getParameter("test2")).trim();
						// code added for persisting the removed html code by
						// wysiwyg

						fos = new FileOutputStream(getServletContext()
								.getRealPath("/temp/" + "temp.html"));
						fos.write(temlateData.getBytes());

						fos.close();
						request.setAttribute("secondRequest", "secondRequest");
						if (request.getParameter("formName") != null) {

							if (request.getParameter("formName").equals(
									"sampleCollection")) {
								mv1 = searchForTemplateDetailsLab(request,
										response);
							} else {

								mv1 = searchPatientForResultValidation(request,
										response);
							}
						}

					}

					java.util.Hashtable files = mrequest.getFiles();

					if ((files != null) && (!files.isEmpty())) {

						file = (UploadFile) files.get(UPLOAD_FILENAME);

						// file.setContentType("text/html");

						try {
							is = file.getInpuStream();
						} catch (Exception e) {
							e.printStackTrace();
						}
						if (is != null) {
							File temprory = new File(getServletContext()
									.getRealPath("/temp/" + "temp.html"));

							fos = new FileOutputStream(temprory);
							byte[] buf = new byte[1024];
							int len;

							while ((len = is.read(buf)) > 0) {

								fos.write(buf, 0, len);

							}
							fos.close();
							is.close();
							// code for parseing html contents from the file
							File temprory1 = new File(getServletContext()
									.getRealPath("/temp/" + "temp.html"));
							InputStream fis = new FileInputStream(
									getServletContext().getRealPath(
											"/temp/" + "temp.html"));

							byte[] b3 = new byte[(int) temprory1.length()];
							int offset = 0;
							int numRead = 0;
							while ((offset < b3.length)
									&& ((numRead = fis.read(b3, offset,
											b3.length - offset)) >= 0)) {

								offset += numRead;

							}
							fis.close();

							// String appendedHtml=new String(b3);
							// if(appendedHtml.contains("<div class=")){
							// int index=appendedHtml.indexOf("<div class=");
							// appendedHtml=appendedHtml.substring(0, index);
							//
							// map.put("appendedHtml", appendedHtml);
							//
							// }
							InputStream fis1 = new FileInputStream(
									getServletContext().getRealPath(
											"jsp/pdf/appendingHtml.html"));
							File temprory2 = new File(getServletContext()
									.getRealPath("jsp/pdf/appendingHtml.html"));

							byte[] b1 = new byte[(int) temprory2.length()];
							int offset1 = 0;
							int numRead1 = 0;
							try {
								while ((offset1 < b1.length)
										&& ((numRead1 = fis1.read(b1, offset1,
												b1.length - offset1)) >= 0)) {

									offset1 += numRead1;

								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								fis1.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							String appendedHtml = new String(b1);
							map.put("appendedHtml", appendedHtml);
							is.close();

							if (request.getParameter("parameterName") != null) {
								String parameterValue = request
										.getParameter("parameterName");
								if (parameterValue
										.equalsIgnoreCase("fromResultEntry")) {
									mv1 = searchForTemplateDetailsLab(request,
											response);
								} else {
									mv1 = searchPatient(request, response);
								}
							}
							fileContent = HMSUtil
									.getContent(getServletContext()
											.getRealPath("/temp/" + "temp.html"));

							// "+fileContent.length());

						} else {

							//String parser = MultipartFormDataRequest.DEFAULTPARSER;
							//Vector listeners = null;
							//String encoding = "iso-8859-1";
							//int uploadlimit = 1024 * 1024 * 1024;

							// try{
							// mrequest = new
							// MultipartFormDataRequest(request,listeners,
							// uploadlimit,parser, encoding);
							// }
							// catch(Exception e){
							// e.printStackTrace();
							// }
							String template = (mrequest.getParameter("test2"))
									.trim();

							fos = new FileOutputStream(getServletContext()
									.getRealPath("/temp/" + "temp.html"));
							fos.write(template.getBytes());
							fos.close();

						}

					}
					// else
					// {
					//
					//
					// String parser = MultipartFormDataRequest.DEFAULTPARSER;
					// Vector listeners = null;
					// String encoding = "iso-8859-1";
					// int uploadlimit = 1024*1024*1024;
					//
					// try{//MultipartRequest mr = new
					// MultipartRequest(request,getServletContext().getRealPath("/temp/"));
					// mrequest = new MultipartFormDataRequest(request);
					// }
					// catch(Exception e){
					// e.printStackTrace();
					//
					// }
					// String template=mrequest.getParameter("test2");
					//
					// FileOutputStream fos=new
					// FileOutputStream(getServletContext().getRealPath("/temp/"+"temp.html"));
					// fos.write( template.getBytes());
					//
					//
					//
					// }
				}

				catch (Exception e) {
					e.printStackTrace();
				}
			}

			fileContent = HMSUtil.getContent(getServletContext().getRealPath(
					"/temp/" + "temp.html"));

			map.put("content", fileContent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ///////////////////////// Finally added By Naresh
		finally {
			try {
				if (is != null) {
					is.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		// ///////////////////////////////////////
		// code added for persisting the removed html code by wysiwyg
		String appendedHtml1 = "";
		boolean flag = false;

		if (mrequest.getParameter("appendedHtml") != null
				&& !mrequest.getParameter("appendedHtml").equals("")) {
			if (mrequest.getParameter("browse").equals("")) {
				appendedHtml1 = mrequest.getParameter("appendedHtml");

				String template = mrequest.getParameter("test2");
				if (appendedHtml1 != null && !appendedHtml1.equals("")) {
					map.put("appendedHtml", appendedHtml1);
					try {
						fos = new FileOutputStream(getServletContext()
								.getRealPath("/temp/" + "temp.html"));
						template = appendedHtml1 + template + "</body></html>";

						fos.write(template.getBytes());
						fos.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		if (mv1 != null && request.getParameter("formName") != null) {

			return mv1;
		} else {
			return new ModelAndView("index", "map", map);
		}
	}
	
	public ModelAndView submitResultEntryForTempelateLab(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in submitResultEntryForTempelateLab");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		boolean saved = false;
		int hospitalId = 0;
		String userName = "";
		MultipartFormDataRequest mrequest = null;
		String result = "";
		Box box = HMSUtil.getBox(request);
		String jsp = "";
		String messageTOBeVisibleToTheUser = "";
		String resultNo = "";
		String CombinedIds = "";
		HttpSession session = request.getSession();
		int sampleCollectionId = 0;
		int newSampleCollectionId = 0;
		String resultType = "";
		int deptId = 0;
		byte[] bytes = null;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("hospitalId", hospitalId);
		}
		try {

			if (MultipartFormDataRequest.isMultipartFormData(request)) {
				try {

					mrequest = new MultipartFormDataRequest(request);
					if (mrequest.getParameter("test2") != null) {
						String tepmlateData = mrequest.getParameter("test2");
						InputStream fis1 = new FileInputStream(
								getServletContext().getRealPath(
										"jsp/pdf/appendingHtml.html"));
						File temprory2 = new File(getServletContext()
								.getRealPath("jsp/pdf/appendingHtml.html"));

						byte[] b1 = new byte[(int) temprory2.length()];
						int offset1 = 0;
						int numRead1 = 0;
						try {
							while ((offset1 < b1.length)
									&& ((numRead1 = fis1.read(b1, offset1,
											b1.length - offset1)) >= 0)) {

								offset1 += numRead1;

							}
						} catch (IOException e) {
							e.printStackTrace();
						}
						try {
							fis1.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						String appendedHtml = new String(b1);
						// String finalFile = appendedHtml + tepmlateData
						// + "</body></html>";

						String finalFile = tepmlateData + "</body></html>";
						bytes = finalFile.getBytes();
						result = new String(bytes);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}

			sampleCollectionId = box.getInt(DG_SAMPLE_DETAIL_ID);
			List<DgSampleCollectionDetails> patientList = new ArrayList<DgSampleCollectionDetails>();

			String reportEnteredFinally = "";

			if (request.getParameter("reportEnteredFinally") != null) {
				reportEnteredFinally = request
						.getParameter("reportEnteredFinally");
			}
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				parameterMap.put("hospitalId", hospitalId);
			}
			if (session.getAttribute(LOGIN_NAME) != null) {
				userName = (String) session.getAttribute(LOGIN_NAME);
				parameterMap.put("userName", userName);
			}
			if (request.getParameter(RESULT_NO) != null) {
				resultNo = request.getParameter(RESULT_NO);
			}
			if (request.getParameter("combinedIds") != null) {
				CombinedIds = request.getParameter("combinedIds");
			}

			String filmSizeUsed = "";
			if (request.getParameter("filmSizeUsed") != null
					&& request.getParameter("filmSizeUsed") != "") {
				filmSizeUsed = request.getParameter("filmSizeUsed");
			}
			int filmUsed = 0;
			if (request.getParameter("filmUsed") != null
					&& !(request.getParameter("filmUsed").equals(""))) {
				filmUsed = new Integer(request.getParameter("filmUsed"));
			}

			String remarks = "";
			if (request.getParameter(REMARKS) != null) {
				remarks = request.getParameter(REMARKS);
			}

			int subchargeId = 0;
			int mainChargeId = 0;

			int hinId = 0;
			int investigationId = 0;
			int inpatientId = 0;
			int testOrderNoForTemplate = 0;
			int employeeId = 0;
			int resultEnteredId = 0;
			int departId = 0;
			Users users = null;
			if (session.getAttribute(USERS) != null) {
				users = (Users) session.getAttribute(USERS);
			}
			if (request.getParameter(MAIN_CHARGECODE_ID) != null && !request.getParameter(MAIN_CHARGECODE_ID) .equals("")) {
				mainChargeId = Integer.valueOf(request
						.getParameter(MAIN_CHARGECODE_ID));
			}
			if (request.getParameter(DEPARTMENT_ID) != null  && !request.getParameter(DEPARTMENT_ID) .equals("")) {
				departId = Integer.valueOf(request.getParameter(DEPARTMENT_ID));
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null && !request.getParameter(SUB_CHARGECODE_ID) .equals("")) {
				subchargeId = Integer.valueOf(request
						.getParameter(SUB_CHARGECODE_ID));
			}
			if (request.getParameter(HIN_ID) != null) {
				hinId = Integer.valueOf(request.getParameter(HIN_ID));
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals(""))) {
				inpatientId = Integer.valueOf(request
						.getParameter(INPATIENT_ID));
			}
			/*
			 * if (request.getParameter("testOrderNoForTemplate") != null &&
			 * !(request.getParameter("testOrderNoForTemplate").equals(""))) {
			 * testOrderNoForTemplate =
			 * Integer.valueOf(request.getParameter("testOrderNoForTemplate"));
			 * }
			 */
			if (request.getParameter(SAMPLE_COLLECTION_ID) != null) {
				sampleCollectionId = Integer.valueOf(request
						.getParameter(SAMPLE_COLLECTION_ID));
			}
			if (request.getParameter(EMPLOYEE_ID) != null
					&& !("").equals(request.getParameter(EMPLOYEE_ID))) {
				employeeId = Integer.valueOf(request.getParameter(EMPLOYEE_ID));

			}
			if ( request.getParameter(RESULT_ENTERED_BY) != null && !request.getParameter(RESULT_ENTERED_BY).equals("")) {
				resultEnteredId = Integer.valueOf(request
						.getParameter(RESULT_ENTERED_BY));
			}
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
			DgResultEntryHeader dgResultEntryHeader = new DgResultEntryHeader();
			dgResultEntryHeader.setResultNo(resultNo);
			dgResultEntryHeader.setLastChgdBy(users);
			dgResultEntryHeader.setLastChgdDate(date);
			dgResultEntryHeader.setLastChgdTime(time);
			dgResultEntryHeader.setRemarks(remarks);
			dgResultEntryHeader.setResultDate(date);
			// if (reportEnteredFinally != null
			// && reportEnteredFinally.equals("true")) {
			dgResultEntryHeader.setResultStatus("P");
			// } else {
			// dgResultEntryHeader.setResultStatus("W");
			// }
			// dgResultEntryHeader.setResultStatus("P");
			dgResultEntryHeader.setResultTime(time);
			dgResultEntryHeader.setVerified("Y");
			dgResultEntryHeader.setVerifiedOn(date);
			dgResultEntryHeader.setVerifiedTime(time);

			MasMainChargecode masMainChargecode = new MasMainChargecode();
			masMainChargecode.setId(mainChargeId);
			dgResultEntryHeader.setMainChargecode(masMainChargecode);

			MasSubChargecode masSubChargecode = new MasSubChargecode();
			masSubChargecode.setId(subchargeId);
			dgResultEntryHeader.setSubChargecode(masSubChargecode);

			dgResultEntryHeader.setTestOrderNo(testOrderNoForTemplate);
			DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
			dgSampleCollectionHeader.setId(sampleCollectionId);
			dgResultEntryHeader
					.setSampleCollectionHeader(dgSampleCollectionHeader);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departId);
			dgResultEntryHeader.setDepartment(masDepartment);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			dgResultEntryHeader.setHospital(masHospital);
			Patient patient = new Patient();
			patient.setId(hinId);
			dgResultEntryHeader.setHin(patient);
			if (inpatientId != 0) {
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				dgResultEntryHeader.setInpatient(inpatient);
			}
			if (employeeId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(employeeId);
				dgResultEntryHeader.setEmployee(masEmployee);
			}
			if (resultEnteredId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(resultEnteredId);
				dgResultEntryHeader.setEmployee(masEmployee);
				dgResultEntryHeader.setResultVerifiedBy(masEmployee);
			}
			if (request.getParameter(INVESTIGATION_ID) != null
					&& (!request.getParameter(INVESTIGATION_ID).equals("0"))) {
				investigationId = Integer.parseInt(request
						.getParameter(INVESTIGATION_ID));
				DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
				dgMasInvestigation.setId(investigationId);
				dgResultEntryHeader.setInvestigation(dgMasInvestigation);
			}

			parameterMap.put("dgResultEntryHeader", dgResultEntryHeader);
			// result = "";
			String additionalRemarks = "";
			int sample_Id = 0;

			int uomId = 0;
			// resultType= "";
			int sampleDetailId = 0;

			if (request.getParameter(RESULT_TYPE) != null) {
				resultType = request.getParameter(RESULT_TYPE);
			}
			dgResultEntryHeader.setResultType(resultType);
			if (request.getParameter(ADDITIONAL_REMARKS) != null) {
				additionalRemarks = request.getParameter(ADDITIONAL_REMARKS);
			}

			if (request.getParameter(INVESTIGATION_ID) != null
					&& (!request.getParameter(INVESTIGATION_ID).equals("0"))) {
				investigationId = Integer.parseInt(request
						.getParameter(INVESTIGATION_ID));
			}

			if (request.getParameter(DG_SAMPLE_DETAIL_ID) != null
					&& (!request.getParameter(DG_SAMPLE_DETAIL_ID).equals(""))) {
				sampleDetailId = Integer.parseInt(request
						.getParameter(DG_SAMPLE_DETAIL_ID));
			}
			DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
			if (investigationId != 0) {

				if (investigationId != 0) {
					DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
					dgMasInvestigation.setId(investigationId);
					dgResultEntryDetail.setInvestigation(dgMasInvestigation);
				}
				if (investigationId != 0) {
					MasChargeCode masChargeCode = new MasChargeCode();
					masChargeCode.setId(investigationId);
					dgResultEntryDetail.setChargeCode(masChargeCode);
				}
				if (sampleDetailId != 0) {
					DgSampleCollectionDetails dgSample = new DgSampleCollectionDetails();
					dgSample.setId(sampleDetailId);
					dgResultEntryDetail.setSampleCollectionDetails(dgSample);
				}

				dgResultEntryDetail.setResult(result);
				dgResultEntryDetail.setResultEntry(dgResultEntryHeader);
				dgResultEntryDetail.setRemarks(additionalRemarks);
				dgResultEntryDetail.setResultType(resultType);
				// if (reportEnteredFinally != null
				// && reportEnteredFinally.equals("true")) {
				dgResultEntryDetail.setResultDetailStatus("A");
				// } else {
				// dgResultEntryDetail.setResultDetailStatus("W");
				// }
				dgResultEntryDetail.setValidated("Y");
				// dgResultEntryDetail.setFilmUsed(filmUsed);
				// dgResultEntryDetail.setFilmSize(filmSizeUsed);
			}
			parameterMap.put("dgResultEntryDetail", dgResultEntryDetail);
			parameterMap.put("sampleDetailId", sampleDetailId);
			if (reportEnteredFinally != null
					&& reportEnteredFinally.equals("true")) {
				map = investigationHandlerService
						.submitResultEntryForTemplate(parameterMap);
			} else {
				map = investigationHandlerService
						.submitResultEntryForTemplateTemparory(parameterMap);
			}

			saved = (Boolean) map.get("saved");
			if (reportEnteredFinally != null
					&& reportEnteredFinally.equals("true")) {
				if (saved == true) {
					messageTOBeVisibleToTheUser = "Result Entry done Successfully.";
				} else {
					messageTOBeVisibleToTheUser = "Some Problem Occured.";
				}
				jsp = MESSAGE_FOR_RESULT_ENTRY + ".jsp";
			} else {
				if (saved == true) {
					messageTOBeVisibleToTheUser = "Result Entry done Successfully.";
				} else {
					messageTOBeVisibleToTheUser = "Some Problem Occured.";
				}
				jsp = MESSAGE_FOR_WAITING_RESULT_ENTRY + ".jsp";
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		int dgSampleHeaderId = 0;
		int subChargeId = 0;
		String[] idsArray = new String[0];
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();

		mapForDs.put("deptId", deptId);
		if (!CombinedIds.equals("")) {

			idsArray = CombinedIds.split(",");
			dgSampleHeaderId = Integer.parseInt(idsArray[0]);
			mapForDs.put("dgSampleHeaderId", dgSampleHeaderId);

			subChargeId = Integer.parseInt(idsArray[1]);
			mapForDs.put("subChargeId", subChargeId);

		}

		if (!CombinedIds.equals("")) {
			// //////////////////////////////////////////////////////
			map = investigationHandlerService
					.getSampleCollectionDetailsForLab(mapForDs);

			// /////////////////////////////////////////////////////
			// map =
			// investigationHandlerService.getSampleCollectionDetails(sampleCollectionDetailId,
			// deptId);

			List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
			if (map.get("sampleCollectionList") != null) {
				sampleCollectionList = (List<DgSampleCollectionDetails>) map
						.get("sampleCollectionList");
			}
			if (sampleCollectionList.size() > 0) {
				jsp = RESULT_ENTRY_SINGLE_PARAMETER_LAB + ".jsp";
				List<String> resultSeqNoList = new ArrayList<String>();
				for (int i = 0; i < sampleCollectionList.size(); i++) {
					String resultSeqNo = "";
					resultSeqNo = investigationHandlerService
							.generateResultNumberForLab(diagMap);
					resultSeqNoList.add(resultSeqNo);
				}

				if (resultSeqNoList.size() > 0) {
					map.put("resultSeqNoList", resultSeqNoList);
				}
				map.put("CombinedIds", CombinedIds);
			} else {
				String nextCombinedIds = "";
				if (!CombinedIds.equals("")) {
					String[] idArrString = new String[0];
					idArrString = CombinedIds.split(",");

					int subChargeIdTemp = Integer.parseInt(idArrString[1]);

					List<String> combinedListAll = new ArrayList<String>();
					combinedListAll = (List<String>) session
							.getAttribute("combinedListAll");

					if (combinedListAll.size() > 0) {
						combinedListAll.remove(CombinedIds);
					}
					for (String combinedIdsFromList : combinedListAll) {
						String[] idArray = new String[0];
						idArray = combinedIdsFromList.split(",");

						int subChargeIdFromList = Integer.parseInt(idArray[1]);
						if (subChargeIdFromList == subChargeIdTemp) {
							nextCombinedIds = combinedIdsFromList;
							break;
						}
					}
				}

				String url = "";
				url = "/hms/hms/investigation?method=searchPatientByBackButtonLab";
				map.put("messageTOBeVisibleToTheUser",
						messageTOBeVisibleToTheUser);
				map.put("url", url);

				map.put("nextCombinedIds", nextCombinedIds);
				map.put("CombinedIds", CombinedIds);
				map.put("newSampleCollectionId", newSampleCollectionId);
				map.put("sampleCollectionId", sampleCollectionId);
				jsp = MESSAGE_FOR_RESULT_ENTRY_LAB + ".jsp";

			}
		}
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitResultEntryForMultiple(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in submitResultEntryForMultiple");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		boolean saved = false;
		int hospitalId = 0;
		String userName = "";
		String messageTOBeVisibleToTheUser = "";
		HttpSession session = request.getSession();
		int sampleCollectionId = 0;
		int newSampleCollectionId = 0;
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		sampleCollectionId = Integer.parseInt(request
				.getParameter(DG_SAMPLE_DETAIL_ID));
		List<DgSampleCollectionDetails> patientList = new ArrayList<DgSampleCollectionDetails>();

		patientList = (List<DgSampleCollectionDetails>) session
				.getAttribute("patientList");

		if (patientList.size() > 0) {
			for (Iterator iterator = patientList.iterator(); iterator.hasNext();) {
				DgSampleCollectionDetails dgSampleDetail = (DgSampleCollectionDetails) iterator
						.next();
				newSampleCollectionId = dgSampleDetail.getId();
				if (newSampleCollectionId == sampleCollectionId) {
					iterator.remove();
				}
			}
		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		if (newSampleCollectionId != 0) {
			map = investigationHandlerService.getResultEntryForNext(
					newSampleCollectionId, deptId);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			parameterMap.put("userName", userName);
		}
		parameterMap.put(USERS, session.getAttribute(USERS));
		Box box = HMSUtil.getBox(request);
		parameterMap.put("box", box);
		map = investigationHandlerService
				.submitResultEntryForMultiple(parameterMap);
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			messageTOBeVisibleToTheUser = "Result Entry done Successfully !! Do You Want To print The Result?";
		} else {
			messageTOBeVisibleToTheUser = "Some Problem Occured !!";
		}
		String resultNo = "";
		if (map.get("resultNo") != null) {
			resultNo = (String) map.get("resultNo");
		}
		String resultType = "";
		if (map.get("resultType") != null) {
			resultType = (String) map.get("resultType");
		}
		String url = "";
		url = "/hms/hms/investigation?method=searchPatient";
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("resultType", resultType);
		map.put("resultNo", resultNo);
		map.put("url", url);
		map.put("sampleCollectionId", sampleCollectionId);
		map.put("newSampleCollectionId", newSampleCollectionId);
		String jsp = MESSAGE_FOR_RESULT_ENTRY + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// ====================== result entry for single parameter
	// =====================
	public ModelAndView submitResultEntryForSingleParameterWithNormalValue(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in submitResultEntryForSingleParameterWithNormalValue");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		boolean saved = false;
		int hospitalId = 0;
		String userName = "";
		String messageTOBeVisibleToTheUser = "";
		HttpSession session = request.getSession();
		int sampleCollectionId = 0;
		int newSampleCollectionId = 0;
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		sampleCollectionId = Integer.parseInt(request
				.getParameter(DG_SAMPLE_DETAIL_ID));
		List<DgSampleCollectionDetails> patientList = new ArrayList<DgSampleCollectionDetails>();
		patientList = (List<DgSampleCollectionDetails>) session
				.getAttribute("patientList");
		if (patientList.size() > 0) {
			for (Iterator iterator = patientList.iterator(); iterator.hasNext();) {
				DgSampleCollectionDetails dgSampleDetail = (DgSampleCollectionDetails) iterator
						.next();
				newSampleCollectionId = dgSampleDetail.getId();
				if (newSampleCollectionId == sampleCollectionId) {
					iterator.remove();
				}
			}
		}
		if (newSampleCollectionId != 0) {
			map = investigationHandlerService.getResultEntryForNext(
					newSampleCollectionId, deptId);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			parameterMap.put("userName", userName);
		}
		Users users = (Users) session.getAttribute(USERS);
		Box box = HMSUtil.getBox(request);
		parameterMap.put(USERS, users);
		parameterMap.put("box", box);
		map = investigationHandlerService
				.submitResultEntryForSingleParameterWithNormalValue(parameterMap);
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			messageTOBeVisibleToTheUser = "Result Entry done Successfully !! Do You Want To print The Result?";
		} else {
			messageTOBeVisibleToTheUser = "Some Problem Occured !!";
		}
		String resultNo = "";
		if (map.get("resultNo") != null) {
			resultNo = (String) map.get("resultNo");
		}
		String resultType = "";
		if (map.get("resultType") != null) {
			resultType = (String) map.get("resultType");
		}
		String url = "";
		url = "/hms/hms/investigation?method=searchPatient";
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("url", url);
		map.put("resultNo", resultNo);
		map.put("resultType", resultType);
		map.put("newSampleCollectionId", newSampleCollectionId);
		map.put("sampleCollectionId", sampleCollectionId);
		String jsp = MESSAGE_FOR_RESULT_ENTRY + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitResultEntryForAllInvestigationTypeForEmpanelled(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in submitResultEntryForAllInvestigationTypeForEmpanelled");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		boolean saved = false;
		int hospitalId = 0;
		String userName = "";
		String CombinedIds = "";
		String messageTOBeVisibleToTheUser = "";
		MasEmpaneled masEmpaneled = null;
		HttpSession session = request.getSession();

		if (request.getParameter("CombinedIds") != null) {
			CombinedIds = request.getParameter("CombinedIds");
		}

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			parameterMap.put("userName", userName);
		}
		if (session.getAttribute(USERS) != null) {
			masEmpaneled = (MasEmpaneled) session.getAttribute(USERS);
			parameterMap.put(USERS, masEmpaneled);
		}
		Box box = HMSUtil.getBox(request);
		parameterMap.put("box", box);
		// /////////////////// Submit For Investigation Type Single
		// /////////////////////////////
		map = investigationHandlerService
				.submitResultEntryForSingleParameterOnlyForEmpanelled(parameterMap);
		map = investigationHandlerService
				.submitResultEntryForMultipleInvestigationTypeForEmpanelled(parameterMap);

		/*
		 * map = investigationHandlerService
		 * .submitResultEntryForTemplate(parameterMap);
		 */
		// /////////////////// Submit For Investigation Type Multiple

		map = investigationHandlerService
				.submitResultEntryForSensitiveForEmpanelled(parameterMap);

		saved = (Boolean) map.get("saved");
		if (saved == true) {
			messageTOBeVisibleToTheUser = "Result Entry done Successfully.Do You Want To print The Result.";
		} else {
			messageTOBeVisibleToTheUser = "Some Problem Occured.";
		}

		String nextCombinedIds = "";
		if (!CombinedIds.equals("")) {
						
			List<String> combinedListAll = new ArrayList<String>();
			combinedListAll = (List<String>) session
					.getAttribute("combinedListAll");

			if (combinedListAll.size() > 0) {
				combinedListAll.remove(CombinedIds);
			}
			for (String combinedIdsFromList : combinedListAll) {
				// if (subChargeIdFromList == subChargeId) {
				nextCombinedIds = combinedIdsFromList;

				break;
				// }
			}
		}

		String url = "";
		url = "/hms/hms/investigation?method=searchPatientByBackButtonLab";
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("url", url);
		// map.put("resultType", resultType);
		map.put("CombinedIds", CombinedIds);
		map.put("nextCombinedIds", nextCombinedIds);
		String jsp = MESSAGE_FOR_RESULT_ENTRY_LAB + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView submitResultEntryForAllInvestigationType(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in submitResultEntryForAllInvestigationType");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		boolean saved = false;
		int hospitalId = 0;
		int modalityId = 0;
		String userName = "";
		String CombinedIds = "";
		String forOutSideLab = null;
		String messageTOBeVisibleToTheUser = "";
		String modalityStr="";
		modalityStr = request.getParameter("modalityId");
		if(Integer.parseInt(modalityStr)<=0){
			modalityStr=request.getParameter("modalityIdSpecific");	
		}
		String[] idArray = new String[0];
		Users users = null;
		HttpSession session = request.getSession();

		if (request.getParameter("CombinedIds") != null) {
			CombinedIds = request.getParameter("CombinedIds");
		}
		
		if (modalityStr != null && !modalityStr.equals("")) {
			modalityId = Integer.parseInt(modalityStr);
		}
		
		if (request.getParameter("forOutSideLab") != null && !request.getParameter("forOutSideLab").trim().equals("")) {
			forOutSideLab = request.getParameter("forOutSideLab");
		}

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			parameterMap.put("userName", userName);
		}
		if (session.getAttribute(USERS) != null) {
			users = (Users) session.getAttribute(USERS);
			parameterMap.put(USERS, users);
		}
		Box box = HMSUtil.getBox(request);
		parameterMap.put("box", box);
		// /////////////////// Submit For Investigation Type Single
		// /////////////////////////////
		map.put("forOutSideLab", forOutSideLab);
		parameterMap.put("modalityId", modalityId);
		
		map = investigationHandlerService
				.submitResultEntryForSingleParameterOnly(parameterMap);
		map = investigationHandlerService
				.submitResultEntryForMultipleInvestigationType(parameterMap);

		/*
		 * map = investigationHandlerService
		 * .submitResultEntryForTemplate(parameterMap);
		 */
		// /////////////////// Submit For Investigation Type Multiple

		map = investigationHandlerService
				.submitResultEntryForSensitive(parameterMap);

		saved = (Boolean) map.get("saved");
		if (saved == true) {
			messageTOBeVisibleToTheUser = "Result Entry done Successfully.Do You Want To print The Result.";
		} else {
			messageTOBeVisibleToTheUser = "Some Problem Occured.";
		}

		String nextCombinedIds = "";
		if (!CombinedIds.equals("")) {
			String[] idArrString = new String[0];
			idArrString = CombinedIds.split(",");

			int subChargeId = Integer.parseInt(idArrString[1]);

			List<String> combinedListAll = new ArrayList<String>();
			combinedListAll = (List<String>) session
					.getAttribute("combinedListAll");

			if (combinedListAll.size() > 0) {
				combinedListAll.remove(CombinedIds);
			}
			
			if(modalityId!=0 && combinedListAll.size()>0){
			
				for (String combinedIdsFromList : combinedListAll) {
				idArray = combinedIdsFromList.split(",");
				int subChargeIdFromList = Integer.parseInt(idArray[1]);
					if (subChargeIdFromList == modalityId){
						nextCombinedIds = combinedIdsFromList;
						break;
					}
				}
			}else if(combinedListAll.size()>0){
					nextCombinedIds = combinedListAll.get(0);
			}
		}

		String url = "";
		url = "/hms/hms/investigation?method=searchPatientByBackButtonLab";
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("url", url);
		// map.put("resultType", resultType);
		map.put("CombinedIds", CombinedIds);
		map.put("nextCombinedIds", nextCombinedIds);
		String jsp = null;
		map.put("forOutSideLab", forOutSideLab);
		ModelAndView modelAndView = null;
		map.put("modalityId", modalityId);
		
		if(forOutSideLab!=null && forOutSideLab.equalsIgnoreCase("Y")){
			jsp = MESSAGE_FOR_RESULT_ENTRY_LAB;
			modelAndView =  new ModelAndView(jsp, "map", map);
		}else{
			jsp = MESSAGE_FOR_RESULT_ENTRY_LAB + ".jsp";
			modelAndView = new ModelAndView("index", "map", map);
		}
		map.put("contentJsp", jsp);
		
		return modelAndView;
	}
	
	public ModelAndView submitResultEntryForAllInvestigationTypeQC(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in submitResultEntryForAllInvestigationTypeQC");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		boolean saved = false;
		int hospitalId = 0;
		String userName = "";
		String CombinedIds = "";
		String messageTOBeVisibleToTheUser = "";
		Users users = null;
		HttpSession session = request.getSession();

		if (request.getParameter("CombinedIds") != null) {
			CombinedIds = request.getParameter("CombinedIds");
		}

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			parameterMap.put("userName", userName);
		}
		if (session.getAttribute(USERS) != null) {
			users = (Users) session.getAttribute(USERS);
			parameterMap.put(USERS, users);
		}
		Box box = HMSUtil.getBox(request);
		parameterMap.put("box", box);
		parameterMap.put("QCType", "QCType");
		// /////////////////// Submit For Investigation Type Single
		// /////////////////////////////
		map = investigationHandlerService
				.submitResultEntryForSingleParameterOnly(parameterMap);
		map = investigationHandlerService
				.submitResultEntryForMultipleInvestigationType(parameterMap);

		/*
		 * map = investigationHandlerService
		 * .submitResultEntryForTemplate(parameterMap);
		 */
		// /////////////////// Submit For Investigation Type Multiple

		map = investigationHandlerService
				.submitResultEntryForSensitive(parameterMap);

		saved = (Boolean) map.get("saved");
		if (saved == true) {
			messageTOBeVisibleToTheUser = "Result Entry done Successfully.Do You Want To print The Result.";
		} else {
			messageTOBeVisibleToTheUser = "Some Problem Occured.";
		}

		String nextCombinedIds = "";
		if (!CombinedIds.equals("")) {
			String[] idArrString = new String[0];
			idArrString = CombinedIds.split(",");

			int subChargeId = Integer.parseInt(idArrString[1]);

			List<String> combinedListAll = new ArrayList<String>();
			combinedListAll = (List<String>) session
					.getAttribute("combinedListAll");

			if (combinedListAll.size() > 0) {
				combinedListAll.remove(CombinedIds);
			}
			for (String combinedIdsFromList : combinedListAll) {
				String[] idArray = new String[0];
				idArray = combinedIdsFromList.split(",");

				int subChargeIdFromList = Integer.parseInt(idArray[1]);
				// if (subChargeIdFromList == subChargeId) {
				nextCombinedIds = combinedIdsFromList;

				break;
				// }
			}
		}

		String url = "";
		url = "/hms/hms/investigation?method=searchPatientByBackButtonLab";
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("url", url);
		// map.put("resultType", resultType);
		map.put("CombinedIds", CombinedIds);
		map.put("nextCombinedIds", nextCombinedIds);
		String jsp = MESSAGE_FOR_RESULT_ENTRY_LAB + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// ------------------- methods for pending for result validation
	// -----------------------------

	public ModelAndView showPendingForResultValidationJsp(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in showPendingForResultValidationJsp");
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String deptName = "";
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
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		dataMap.put("deptId", deptId);
		mapForDs.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		detailsMap = investigationHandlerService
				.getDetailsForResultValidation(dataMap);
		patientMap = investigationHandlerService
				.getResultValidationGrid(mapForDs);
		String jsp = DG_PENDING_RESULT_VALIDATION;
		jsp += ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showPendingForResultValidationJspForQC(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in showPendingForResultValidationJspForQC");
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String deptName = "";
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
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		dataMap.put("deptId", deptId);
		mapForDs.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		detailsMap = investigationHandlerService
				.getDetailsForResultValidation(dataMap);
		patientMap = investigationHandlerService
				.getResultValidationGrid(mapForDs);
		String jsp = DG_PENDING_RESULT_VALIDATION_FOR_QC;
		jsp += ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showPendingForResultEntryLabJspForPostQC(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in showPendingForResultEntryLabJspForPostQC");
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String deptName = "";
		String deptType = "";
		Users users = null;
		Box box=HMSUtil.getBox(request);
		session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute(USERS) != null) {
			users = (Users) session.getAttribute(USERS);
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
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		dataMap.put("deptId", deptId);
		mapForDs.put("deptId", deptId);
		mapForDs.put("deptType", deptType);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		mapForDs.put("box", box);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put(USERS, users);
		detailsMap = investigationHandlerService
				.getDetailsForResultValidation(dataMap);

		patientMap = investigationHandlerService
				.getResultEntryLabGridForPostQC(mapForDs);
		String jsp =RequestConstants.PENDING_RESULT_ENTRY_LAB_FOR_POST_QC;
		jsp += ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPendingForResultValidationLabJsp(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in showPendingForResultValidationLabJsp");
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String deptName = "";
		String deptType = "";
		Users users = null;
		int userId = 0;
		session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute(USERS) != null) {
			users = (Users) session.getAttribute(USERS);
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
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}
		
		// added by amit das on 17-07-2017
		if (session.getAttribute("userId") != null) {
			userId = (int) session.getAttribute("userId");
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		dataMap.put("deptId", deptId);
		dataMap.put("userId",userId);
		
		mapForDs.put("deptId", deptId);
		mapForDs.put("deptType", deptType);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put(USERS, users);
		detailsMap = investigationHandlerService
				.getDetailsForResultValidation(dataMap);

		patientMap = investigationHandlerService
				.getResultValidationLabGrid(mapForDs);
		String jsp = PENDING_RESULT_VALIDATION_LAB;
		jsp += ".jsp";
		logger.info(jsp);
		
		detailsMap.put("userId", userId);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("hinNo", "");
		map.put("pFirstName", "");		
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showPendingForResultValidationLabJspForEmpanelled(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in showPendingForResultValidationLabJspForEmpanelled");
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String deptName = "";
		String deptType = "";
		MasEmpaneled masEmpaneled = null;
		session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute(USERS) != null) {
			masEmpaneled = (MasEmpaneled) session.getAttribute(USERS);
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
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		dataMap.put("deptId", deptId);
		mapForDs.put("deptId", deptId);
		mapForDs.put("deptType", deptType);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put(USERS, masEmpaneled);
		mapForDs.put(USERS, masEmpaneled);
		detailsMap = investigationHandlerService
				.getDetailsForResultValidation(dataMap);

		patientMap = investigationHandlerService
				.getResultValidationLabGridForEmpanelled(mapForDs);
		String jsp = "pendingResultValidationLabForEmpanelled";
		jsp += ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showPendingForResultValidationLabJspForQC(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in showPendingForResultValidationLabJspForQC");
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String deptName = "";
		String deptType = "";
		Users users = null;
		session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute(USERS) != null) {
			users = (Users) session.getAttribute(USERS);
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
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		dataMap.put("deptId", deptId);
		mapForDs.put("deptId", deptId);
		mapForDs.put("deptType", deptType);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put(USERS, users);
		detailsMap = investigationHandlerService
				.getDetailsForResultValidation(dataMap);

		patientMap = investigationHandlerService
				.getResultValidationLabGrid(mapForDs);
		String jsp =RequestConstants.PENDING_RESULT_VALIDATION_LAB_FOR_QC;
		jsp += ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPendingResultValidationForCorrectionLabJsp(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in showPendingResultValidationForCorrectionLabJsp");
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String deptName = "";
		String deptType = "";
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
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		dataMap.put("deptId", deptId);
		mapForDs.put("deptId", deptId);
		mapForDs.put("deptType", deptType);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		detailsMap = investigationHandlerService
				.getDetailsForResultValidation(dataMap);

		patientMap = investigationHandlerService
				.getResultEntryCorrectionLabGrid(mapForDs);
		String jsp = RESULT_ENTRY_LIST_FOR_CORRECTION_LAB;
		jsp += ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForResultValidation(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in searchPatientForResultValidation");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String hinNo = "";
		int chargeCodeId = 0;
		String patientFName = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String adNo = "";
		int departmentId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		int hinId = 0;
		int resultId = 0;
		int resultEnteredByForTemplate = 0;
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		String appendedHtml = "";
		String userName = "";
		String deptType = "";

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
		mapForDs.put("deptId", deptId);
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
			mapForDs.put("deptType", deptType);
		}
		int dgresultDetailIdTemplate=0;
		if (request.getParameter("dgresultDetailIdTemplate") != null
				&& !(request.getParameter("dgresultDetailIdTemplate").equals(""))) {
			dgresultDetailIdTemplate =Integer.parseInt( request.getParameter("dgresultDetailIdTemplate"));
			
		}
		
		
		String flagForLab = "";
		String resultIdStringForTemplate = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		try {

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter("flagForLab") != null
					&& !(request.getParameter("flagForLab").equals(""))) {
				flagForLab = request.getParameter("flagForLab");
				// mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter("resultIdStringForTemplate") != null
					&& !(request.getParameter("resultIdStringForTemplate")
							.equals(""))) {
				resultIdStringForTemplate = request
						.getParameter("resultIdStringForTemplate");
				// mapForDs.put("hinNo", hinNo);
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

			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
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
			
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
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
			if (request.getParameter(RESULT_ID) != null
					&& !(request.getParameter(RESULT_ID).equals("0"))) {
				resultId = Integer.parseInt(request.getParameter(RESULT_ID));
				mapForDs.put("resultId", resultId);
			}
			if (request.getParameter("resultEnteredByForTemplate") != null
					&& !(request.getParameter("resultEnteredByForTemplate")
							.equals(""))) {
				resultEnteredByForTemplate = Integer.parseInt(request
						.getParameter("resultEnteredByForTemplate"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = "";
		int id = 0;
		List<Patient> patientList = new ArrayList<Patient>();
		if (resultId != 0) {
			map = investigationHandlerService.getResultEntryDetails(mapForDs);
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			if (map.get("resultList") != null) {
				resultList = (List<DgResultEntryHeader>) map.get("resultList");
			}
			Set<DgResultEntryDetail> dgDetailSet = new HashSet<DgResultEntryDetail>();
			for (DgResultEntryHeader dgHeader : resultList) {
				dgDetailSet = dgHeader.getDgResultEntryDetails();
				id = dgHeader.getId();
			}
			if (resultList != null && resultList.get(0).getResultType() != null
					&& resultList.get(0).getResultType().equalsIgnoreCase("v")) {
				jsp = "sensitiveResultValidation.jsp";
			} else {
				for (DgResultEntryDetail dgResEntry : dgDetailSet) {
					if (dgResEntry.getInvestigation().getInvestigationType()
							.equalsIgnoreCase("s")) {
						jsp = DG_RESULT_VALIDATION_ENTRY_SINGLE_PARAMETER
								+ ".jsp";
					} else if (dgResEntry.getInvestigation()
							.getInvestigationType().equalsIgnoreCase("m")) {
						jsp = RESULT_VALIDATION_ENTRY + ".jsp";
					} else if (dgResEntry.getInvestigation()
							.getInvestigationType().equalsIgnoreCase("t")) {
						// code for coping template contents to server path
						new File(getServletContext().getRealPath("/temp/"))
								.mkdir();

						try {
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
							if (request.getAttribute("secondRequest") == null) {
								
								FileOutputStream fos = null;
								try {
									fos = new FileOutputStream(
											getServletContext().getRealPath(
													"/temp/" + "temp.html"));
								} catch (FileNotFoundException e1) {
									e1.printStackTrace();
								} catch (IllegalStateException e1) {
									e1.printStackTrace();
								}
								try {
									fos.write(dgResEntry.getResult().getBytes());
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						if (!flagForLab.equals("")
								&& flagForLab.equals("fromLab")) {
							jsp = RESULT_VALIDATION_ENTRY_TEMPLATE_LAB + ".jsp";
						} else {
							jsp = RESULT_VALIDATION_ENTRY_TEMPLATE + ".jsp";
						}
					}
				}
			}
		} else {
			patientMap = investigationHandlerService
					.getPatientDetailsForResultValidation(mapForDs);
			if (patientMap.get("patientDetailsList") != null) {
				patientList = (List<Patient>) patientMap
						.get("patientDetailsList");
			}
			detailsMap = investigationHandlerService
					.getDetailsForResultValidation(dataMap);
			jsp = DG_PENDING_RESULT_VALIDATION + ".jsp";
		}
		logger.info("jsp @#@# "+jsp);
		patientMap.put("patientList", patientList);
		map.put("resultId", resultId);
		map.put("dgresultDetailIdTemplate", dgresultDetailIdTemplate);
		map.put("resultIdStringForTemplate", resultIdStringForTemplate);
		map.put("resultEnteredByForTemplate", resultEnteredByForTemplate);
		map.put("appendedHtml", appendedHtml);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("id", id);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForResultValidationForQC(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in searchPatientForResultValidationForQC");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String hinNo = "";
		int chargeCodeId = 0;
		String patientFName = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String adNo = "";
		int departmentId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		int hinId = 0;
		int resultId = 0;
		int resultEnteredByForTemplate = 0;
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		String appendedHtml = "";
		String userName = "";
		String deptType = "";

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
		mapForDs.put("deptId", deptId);
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
			mapForDs.put("deptType", deptType);
		}
		String flagForLab = "";
		String resultIdStringForTemplate = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		try {

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter("flagForLab") != null
					&& !(request.getParameter("flagForLab").equals(""))) {
				flagForLab = request.getParameter("flagForLab");
				// mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter("resultIdStringForTemplate") != null
					&& !(request.getParameter("resultIdStringForTemplate")
							.equals(""))) {
				resultIdStringForTemplate = request
						.getParameter("resultIdStringForTemplate");
				// mapForDs.put("hinNo", hinNo);
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

			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
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
			
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
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
			if (request.getParameter(RESULT_ID) != null
					&& !(request.getParameter(RESULT_ID).equals("0"))) {
				resultId = Integer.parseInt(request.getParameter(RESULT_ID));
				mapForDs.put("resultId", resultId);
			}
			if (request.getParameter("resultEnteredByForTemplate") != null
					&& !(request.getParameter("resultEnteredByForTemplate")
							.equals(""))) {
				resultEnteredByForTemplate = Integer.parseInt(request
						.getParameter("resultEnteredByForTemplate"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = "";
		int id = 0;
		List<Patient> patientList = new ArrayList<Patient>();
		if (resultId != 0) {
			map = investigationHandlerService.getResultEntryDetails(mapForDs);
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			if (map.get("resultList") != null) {
				resultList = (List<DgResultEntryHeader>) map.get("resultList");
			}
			Set<DgResultEntryDetail> dgDetailSet = new HashSet<DgResultEntryDetail>();
			for (DgResultEntryHeader dgHeader : resultList) {
				dgDetailSet = dgHeader.getDgResultEntryDetails();
				id = dgHeader.getId();
			}
			if (resultList != null && resultList.get(0).getResultType() != null
					&& resultList.get(0).getResultType().equalsIgnoreCase("v")) {
				jsp = "sensitiveResultValidation.jsp";
			} else {
				for (DgResultEntryDetail dgResEntry : dgDetailSet) {
					if (dgResEntry.getInvestigation().getInvestigationType()
							.equalsIgnoreCase("s")) {
						jsp = DG_RESULT_VALIDATION_ENTRY_SINGLE_PARAMETER
								+ ".jsp";
					} else if (dgResEntry.getInvestigation()
							.getInvestigationType().equalsIgnoreCase("m")) {
						jsp = RESULT_VALIDATION_ENTRY + ".jsp";
					} else if (dgResEntry.getInvestigation()
							.getInvestigationType().equalsIgnoreCase("t")) {
						// code for coping template contents to server path
						new File(getServletContext().getRealPath("/temp/"))
								.mkdir();

						try {
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
							if (request.getAttribute("secondRequest") == null) {
							
								FileOutputStream fos = null;
								try {
									fos = new FileOutputStream(
											getServletContext().getRealPath(
													"/temp/" + "temp.html"));
								} catch (FileNotFoundException e1) {
									e1.printStackTrace();
								} catch (IllegalStateException e1) {
									e1.printStackTrace();
								}
								try {
									fos.write(dgResEntry.getResult().getBytes());
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						if (!flagForLab.equals("")
								&& flagForLab.equals("fromLab")) {
							jsp = RESULT_VALIDATION_ENTRY_TEMPLATE_LAB + ".jsp";
						} else {
							jsp = RESULT_VALIDATION_ENTRY_TEMPLATE + ".jsp";
						}
					}
				}
			}
		} else {
			patientMap = investigationHandlerService
					.getPatientDetailsForResultValidation(mapForDs);
			if (patientMap.get("patientDetailsList") != null) {
				patientList = (List<Patient>) patientMap
						.get("patientDetailsList");
			}
			detailsMap = investigationHandlerService
					.getDetailsForResultValidation(dataMap);
			jsp =RequestConstants.DG_PENDING_RESULT_VALIDATION_FOR_QC + ".jsp";
		}

		patientMap.put("patientList", patientList);
		map.put("resultId", resultId);
		map.put("resultIdStringForTemplate", resultIdStringForTemplate);
		map.put("resultEnteredByForTemplate", resultEnteredByForTemplate);
		map.put("appendedHtml", appendedHtml);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("id", id);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPatientForResultValidationLab(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in searchPatientForResultValidationLab");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String hinNo = "";
		int chargeCodeId = 0;
		int departmentId = 0;
		int subChargeCodeId = 0;
		int hinId = 0;
		int deptId = 0;
		int hospitalId = 0;

		String patientFName = "";
		Date fromDate = new Date();
		;
		Date toDate = new Date();
		String adNo = "";
		String orderType = "";
		String resultId = "";
		String deptName = "";
		String appendedHtml = "";
		String userName = "";
		String deptType = "";
		String wardName = "";
		String mobileNo = "";
		int userId = 0;
		String fromDates="",toDates="";
		session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
			mapForDs.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		mapForDs.put("deptId", deptId);
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
			mapForDs.put("deptType", deptType);
		}
		
		// added by amit das on 17-07-2017
		if (session.getAttribute("userId") != null) {
			userId = (int) session.getAttribute("userId");
		}
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		try {

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
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
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
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
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
			if (request.getParameter(RESULT_ID) != null
					&& !(request.getParameter(RESULT_ID).equals("0"))) {
				resultId = (String) request.getParameter(RESULT_ID);
				mapForDs.put("resultId", resultId);
				dataMap.put("resultId", resultId);
			}
			if (request.getParameter(WARD_NAME) != null
					&& !(request.getParameter(WARD_NAME).equals("0"))) {
				wardName = (String) request.getParameter(WARD_NAME);
				mapForDs.put(WARD_NAME, wardName);
				dataMap.put(WARD_NAME, wardName);
			}
			if (request.getParameter(MOBILE_NO) != null
					&& !(request.getParameter(MOBILE_NO).equals("0"))) {
				mobileNo = (String) request.getParameter(MOBILE_NO);
				mapForDs.put(MOBILE_NO, mobileNo);
				dataMap.put(MOBILE_NO, mobileNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = "";
		List<Patient> patientList = new ArrayList<Patient>();

		Map<String, Object> diagMap = new HashMap<String, Object>();
		if (!resultId.equals("")) {
			map = investigationHandlerService.getResultEntryDetailsLab(dataMap);
			map.put("resultId", resultId);
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			if (map.get("resultList") != null) {
				resultList = (List<DgResultEntryHeader>) map.get("resultList");
			}
			jsp =RESULT_VALIDATION_ENTRY_SINGLE_PARAMETER_LAB + ".jsp";
		} else {
			String barcodetext="";
			if (request.getParameter("barcodetext") != null
					&& !(request.getParameter("barcodetext")
							.equals(""))) {
				barcodetext =request.getParameter("barcodetext").trim();
				mapForDs.put("barcodetext", barcodetext);
			}
			String sampleIdSearch=null;
			
			if (request.getParameter("sampleId") != null
				&& !(request.getParameter("sampleId")
						.equals(""))) {
			sampleIdSearch =request.getParameter("sampleId").trim();
			mapForDs.put("sampleIdSearch", sampleIdSearch);
		}
			
			patientMap = investigationHandlerService
					.getPatientDetailsForResultValidationLab(mapForDs);
			if (patientMap.get("patientDetailsList") != null) {
				patientList = (List<Patient>) patientMap
						.get("patientDetailsList");
			}
			detailsMap = investigationHandlerService
					.getDetailsForResultValidation(dataMap);
			map.put("pFirstName", patientFName);
			map.put("barcodetext", barcodetext);
			map.put("deptName", deptName);
			map.put("fromDate",fromDates);
			map.put("toDate",toDates);
			map.put("hinNo", hinNo);
			map.put("sampleIdSearch", sampleIdSearch);
			jsp = PENDING_RESULT_VALIDATION_LAB + ".jsp";
		}

		detailsMap.put("currentLabId", subChargeCodeId);
		detailsMap.put("userId",userId);
		
		patientMap.put("patientList", patientList);
		map.put("resultId", resultId);
		map.put("appendedHtml", appendedHtml);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView searchPatientForResultValidationLabForEmpanelled(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in searchPatientForResultValidationLabForEmpanelled");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String hinNo = "";
		int chargeCodeId = 0;
		int departmentId = 0;
		int subChargeCodeId = 0;
		int hinId = 0;
		int deptId = 0;
		int hospitalId = 0;

		String pType = "";
		String patientFName = "";
		Date fromDate = new Date();
		;
		Date toDate = new Date();
		String adNo = "";
		String orderType = "";
		String resultId = "";
		String deptName = "";
		String appendedHtml = "";
		String userName = "";
		String deptType = "";
		String wardName = "";
		String mobileNo = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
			mapForDs.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		mapForDs.put("deptId", deptId);
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
			mapForDs.put("deptType", deptType);
		}
		if (session.getAttribute(USERS) != null) {
			MasEmpaneled empaneled = (MasEmpaneled) session.getAttribute(USERS);
			mapForDs.put(USERS, empaneled);
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		try {

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
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
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
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
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
			if (request.getParameter(RESULT_ID) != null
					&& !(request.getParameter(RESULT_ID).equals("0"))) {
				resultId = (String) request.getParameter(RESULT_ID);
				mapForDs.put("resultId", resultId);
				dataMap.put("resultId", resultId);
			}
			if (request.getParameter(WARD_NAME) != null
					&& !(request.getParameter(WARD_NAME).equals("0"))) {
				wardName = (String) request.getParameter(WARD_NAME);
				mapForDs.put(WARD_NAME, wardName);
				dataMap.put(WARD_NAME, wardName);
			}
			if (request.getParameter(MOBILE_NO) != null
					&& !(request.getParameter(MOBILE_NO).equals("0"))) {
				mobileNo = (String) request.getParameter(MOBILE_NO);
				mapForDs.put(MOBILE_NO, mobileNo);
				dataMap.put(MOBILE_NO, mobileNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = "";
		List<Patient> patientList = new ArrayList<Patient>();

		Map<String, Object> diagMap = new HashMap<String, Object>();
		if (!resultId.equals("")) {
			map = investigationHandlerService.getResultEntryDetailsLab(dataMap);
			map.put("resultId", resultId);
			
			jsp =  "resultValidationEntryForSingleParameterLabForEmpanelled" + ".jsp";
		} else {
			patientMap = investigationHandlerService
					.getPatientDetailsForResultValidationLabForEmpanelled(mapForDs);
			if (patientMap.get("patientDetailsList") != null) {
				patientList = (List<Patient>) patientMap
						.get("patientDetailsList");
			}
			detailsMap = investigationHandlerService
					.getDetailsForResultValidation(dataMap);
			jsp = "pendingResultValidationLabForEmpanelled" + ".jsp";
		}

		patientMap.put("patientList", patientList);
		map.put("resultId", resultId);
		map.put("appendedHtml", appendedHtml);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView searchPatientForResultEntryLabForPostQC(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in searchPatientForResultEntryLabForPostQC");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String hinNo = "";
		int chargeCodeId = 0;
		int departmentId = 0;
		int subChargeCodeId = 0;
		int hinId = 0;
		int deptId = 0;
		int hospitalId = 0;

		String pType = "";
		String patientFName = "";
		Date fromDate = new Date();
		;
		Date toDate = new Date();
		String adNo = "";
		String orderType = "";
		String resultId = "";
		String deptName = "";
		String appendedHtml = "";
		String userName = "";
		String deptType = "";
		String wardName = "";
		String mobileNo = "";
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
			mapForDs.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		mapForDs.put("deptId", deptId);
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
			mapForDs.put("deptType", deptType);
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		try {

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
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
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
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
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
			if (request.getParameter(RESULT_ID) != null
					&& !(request.getParameter(RESULT_ID).equals("0"))) {
				resultId = (String) request.getParameter(RESULT_ID);
				mapForDs.put("resultId", resultId);
				dataMap.put("resultId", resultId);
			}
			if (request.getParameter(WARD_NAME) != null
					&& !(request.getParameter(WARD_NAME).equals("0"))) {
				wardName = (String) request.getParameter(WARD_NAME);
				mapForDs.put(WARD_NAME, wardName);
				dataMap.put(WARD_NAME, wardName);
			}
			if (request.getParameter(MOBILE_NO) != null
					&& !(request.getParameter(MOBILE_NO).equals("0"))) {
				mobileNo = (String) request.getParameter(MOBILE_NO);
				mapForDs.put(MOBILE_NO, mobileNo);
				dataMap.put(MOBILE_NO, mobileNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = "";
		List<Patient> patientList = new ArrayList<Patient>();

		Map<String, Object> diagMap = new HashMap<String, Object>();
		if (!resultId.equals("")) {
			//map = investigationHandlerService.getResultEntryDetailsLab(dataMap);
			map = investigationHandlerService.getResultEntryDetailsLabForPostQC(dataMap);
			map.put("resultId", resultId);
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			if (map.get("resultList") != null) {
				resultList = (List<DgResultEntryHeader>) map.get("resultList");
			}
			//jsp=RESULT_VALIDATION_ENTRY_SINGLE_PARAMETER_LAB+".jsp";
			jsp = RESULT_ENTRY_SINGLE_PARAMETER_LAB_FOR_POST_QC + ".jsp";
		} else {
			patientMap = investigationHandlerService
					.getPatientDetailsForResultValidationLab(mapForDs);
			if (patientMap.get("patientDetailsList") != null) {
				patientList = (List<Patient>) patientMap
						.get("patientDetailsList");
			}
			detailsMap = investigationHandlerService
					.getDetailsForResultValidation(dataMap);
			jsp =RequestConstants.PENDING_RESULT_VALIDATION_LAB_FOR_QC + ".jsp";
		}

		patientMap.put("patientList", patientList);
		map.put("resultId", resultId);
		map.put("appendedHtml", appendedHtml);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	
	
	public ModelAndView searchPatientForResultValidationLabForQC(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in searchPatientForResultValidationLabForQC");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String hinNo = "";
		int chargeCodeId = 0;
		int departmentId = 0;
		int subChargeCodeId = 0;
		int hinId = 0;
		int deptId = 0;
		int hospitalId = 0;

		String pType = "";
		String patientFName = "";
		Date fromDate = new Date();
		;
		Date toDate = new Date();
		String adNo = "";
		String orderType = "";
		String resultId = "";
		String deptName = "";
		String appendedHtml = "";
		String userName = "";
		String deptType = "";
		String wardName = "";
		String mobileNo = "";
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
			mapForDs.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		mapForDs.put("deptId", deptId);
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
			mapForDs.put("deptType", deptType);
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		try {

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
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
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
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
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
			if (request.getParameter(RESULT_ID) != null
					&& !(request.getParameter(RESULT_ID).equals("0"))) {
				resultId = (String) request.getParameter(RESULT_ID);
				mapForDs.put("resultId", resultId);
				dataMap.put("resultId", resultId);
			}
			if (request.getParameter(WARD_NAME) != null
					&& !(request.getParameter(WARD_NAME).equals("0"))) {
				wardName = (String) request.getParameter(WARD_NAME);
				mapForDs.put(WARD_NAME, wardName);
				dataMap.put(WARD_NAME, wardName);
			}
			if (request.getParameter(MOBILE_NO) != null
					&& !(request.getParameter(MOBILE_NO).equals("0"))) {
				mobileNo = (String) request.getParameter(MOBILE_NO);
				mapForDs.put(MOBILE_NO, mobileNo);
				dataMap.put(MOBILE_NO, mobileNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = "";
		List<Patient> patientList = new ArrayList<Patient>();

		Map<String, Object> diagMap = new HashMap<String, Object>();
		if (!resultId.equals("")) {
			map = investigationHandlerService.getResultEntryDetailsLab(dataMap);
			map.put("resultId", resultId);
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			if (map.get("resultList") != null) {
				resultList = (List<DgResultEntryHeader>) map.get("resultList");
			}
			jsp = RESULT_VALIDATION_ENTRY_SINGLE_PARAMETER_LAB + ".jsp";
		} else {
			patientMap = investigationHandlerService
					.getPatientDetailsForResultValidationLab(mapForDs);
			if (patientMap.get("patientDetailsList") != null) {
				patientList = (List<Patient>) patientMap
						.get("patientDetailsList");
			}
			detailsMap = investigationHandlerService
					.getDetailsForResultValidation(dataMap);
			jsp =RequestConstants.PENDING_RESULT_VALIDATION_LAB_FOR_QC + ".jsp";
		}

		patientMap.put("patientList", patientList);
		map.put("resultId", resultId);
		map.put("appendedHtml", appendedHtml);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitResultValidationForMultiple(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in submitResultValidationForMultiple");
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		String url = "";
		int resultId = 0;
		int resultValidatedBy = 0;
		int newResultId = 0;
		String resultNo = "";
		String resultType = "";
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		if (request.getParameter("resultNo") != null) {
			resultNo = request.getParameter("resultNo");
		}

		if (request.getParameter("resultType") != null) {
			resultType = request.getParameter("resultType");
		}

		resultId = Integer.parseInt(request.getParameter(RESULT_ID));
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		patientList = (List<DgResultEntryHeader>) session
				.getAttribute("patientList");

		if (patientList.size() > 0) {
			for (Iterator iterator = patientList.iterator(); iterator.hasNext();) {
				DgResultEntryHeader dgResultEntryHeader = (DgResultEntryHeader) iterator
						.next();
				newResultId = dgResultEntryHeader.getId();
				if (newResultId == resultId) {
					iterator.remove();
				}
			}

		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		if (newResultId != 0) {
			map = investigationHandlerService.getResultEntryDetailsForNext(
					newResultId, deptId);
		}

		if (request.getParameter(RESULT_VALIDATED_BY) != null
				&& !request.getParameter(RESULT_VALIDATED_BY).equals("")) {
			resultValidatedBy = Integer.parseInt(request
					.getParameter(RESULT_VALIDATED_BY));
		}
		map = investigationHandlerService.getResultList(resultId);
		infoMap.put("box", box);

		infoMap.put("resultId", resultId);
		infoMap.put("resultValidatedBy", resultValidatedBy);
		boolean flag = false;
		try {
			flag = investigationHandlerService
					.submitResultValidationForMultiple(infoMap);

			if (flag == false) {
				messageTOBeVisibleToTheUser = "Successfully Validated The Result. Do You want to Print. ";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsp = MESSAGE_FOR_RESULT_JSP + ".jsp";
		url = "/hms/hms/investigation?method=searchPatientForResultValidation";
		map.put("resultNo", resultNo);
		map.put("resultType", resultType);
		map.put("url", url);
		map.put("resultId", resultId);
		map.put("newResultId", newResultId);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// /================== validation for single parameter ===========

	public ModelAndView submitResultValidationForSingleParameter(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in submitResultValidationForSingleParameter");
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String url = "";
		int resultId = 0;
		int newResultId = 0;
		int resultValidatedBy = 0;
		String messageTOBeVisibleToTheUser = "";
		String resultNo = "";
		String resultType = "";
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (request.getParameter("resultNo") != null) {
			resultNo = request.getParameter("resultNo");
		}

		if (request.getParameter("resultType") != null) {
			resultType = request.getParameter("resultType");
		}
		resultId = Integer.parseInt(request.getParameter(RESULT_ID));
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();

		patientList = (List<DgResultEntryHeader>) session
				.getAttribute("patientList");

		if (patientList.size() > 0) {
			for (Iterator iterator = patientList.iterator(); iterator.hasNext();) {
				DgResultEntryHeader dgResultEntryHeader = (DgResultEntryHeader) iterator
						.next();
				newResultId = dgResultEntryHeader.getId();
				if (newResultId == resultId) {
					iterator.remove();
				}
			}

		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		if (newResultId != 0) {
			map = investigationHandlerService.getResultEntryDetailsForNext(
					newResultId, deptId);
		}
		if (request.getParameter(RESULT_VALIDATED_BY) != null
				&& !request.getParameter(RESULT_VALIDATED_BY).equals("")) {
			resultValidatedBy = Integer.parseInt(request
					.getParameter(RESULT_VALIDATED_BY));
		}
		map = investigationHandlerService.getResultList(resultId);
		infoMap.put("box", box);

		infoMap.put("resultId", resultId);
		infoMap.put("resultValidatedBy", resultValidatedBy);
		boolean flag = false;
		try {
			flag = investigationHandlerService
					.submitResultValidationForSingleParameter(infoMap);
			if (flag == false) {
				messageTOBeVisibleToTheUser = "Successfully Validated the result.Do you want to print.";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = MESSAGE_FOR_RESULT_JSP + ".jsp";
		url = "/hms/hms/investigation?method=searchPatientForResultValidation";
		map.put("resultNo", resultNo);
		map.put("resultType", resultType);
		map.put("url", url);
		map.put("resultId", resultId);
		map.put("newResultId", newResultId);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitResultValidationForAllInvestigationTypeLab(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in submitResultValidationForAllInvestigationTypeLab");
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String url = "";
		int resultId = 0;
		int newResultId = 0;
		int resultValidatedBy = 0;
		String messageTOBeVisibleToTheUser = "";
		String resultIdStringForTemplate = "";
		int validatedCheckBoxCountMultiple = 0;
		int validatedCheckBoxCountSingle = 0;
		String checkId1 = "";
		int deptId = 0;
		int hospitalId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		
		// added by amit das on 15-09-2017
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
		}

		if (request.getParameter("validatedCheckBoxCountSingle") != null
				&& !request.getParameter("validatedCheckBoxCountSingle")
						.equals("")) {
			validatedCheckBoxCountSingle = Integer.parseInt(request
					.getParameter("validatedCheckBoxCountSingle"));
		}
		if (request.getParameter("validatedCheckBoxCountMultiple") != null
				&& !request.getParameter("validatedCheckBoxCountMultiple")
						.equals("")) {
			validatedCheckBoxCountMultiple = Integer.parseInt(request
					.getParameter("validatedCheckBoxCountMultiple"));
		}
		if (request.getParameter("resultIdStringForTemplate") != null) {
			resultIdStringForTemplate = (String) request
					.getParameter("resultIdStringForTemplate");
		}

		List<String> validatedListSingleType = new ArrayList<String>();
		List<String> validatedListMultipleType = new ArrayList<String>();
		int retestCountS=0;
		int multTest=0;
		int singleTes=0;
		List<Integer> retestIdListS=new ArrayList<Integer>();
		for (int x = 0; x < validatedCheckBoxCountSingle; x++) {
			if (request.getParameter("checkIdSingleValue" + x) != null) {
				if(request.getParameter("checkIdSingleValue" + x).equalsIgnoreCase("y")){
				validatedListSingleType.add("y");
				singleTes++;
				}
			} else if (request.getParameter("checkIdSingleValueRetest" + x) != null) {
				if(request.getParameter("checkIdSingleValueRetest" + x).equalsIgnoreCase("y")){
				validatedListSingleType.add("RT");
				singleTes++;
				retestCountS++;
				if(box.get("collectionId" + x)!=null){
					retestIdListS.add((Integer)box.getInt("collectionId" + x));
					//System.out.println("collectionId "+box.getInt("collectionId" + x));
				}
				}
			} else if (request.getParameter("checkIdSingleValueRecollect" + x) != null) {
				if(request.getParameter("checkIdSingleValueRecollect" + x).equalsIgnoreCase("y")){
				validatedListSingleType.add("RC");
				singleTes++;
				}
			} else {
				validatedListSingleType.add("n");
			}
		}
		//added by govind 17-06-2017
		int retestCount=0;
		List<Integer> retestIdList=new ArrayList<Integer>();
		List<Integer> acceptIdList=new ArrayList<Integer>();
		List<Integer> acceptEntryIdList=new ArrayList<Integer>();
		List<Integer> recolHIdList=new ArrayList<Integer>();
		List<Integer> recolEntryIdList=new ArrayList<Integer>();
		Vector resultIdList = box.getVector(RESULT_ID);
		logger.info("validatedCheckBoxCountMultiple "+validatedCheckBoxCountMultiple);
		for (int x = 0; x < validatedCheckBoxCountMultiple; x++) {
			if (request.getParameter("checkId" + x) != null) {
				if(request.getParameter("checkId" + x).equalsIgnoreCase("y")){
				validatedListMultipleType.add("y");
				multTest++;
				//acceptIdList.add((Integer)resultIdList.get(x));
				if(box.get("acceptedId" + x)!=null){
					if((Integer)box.getInt("acceptedId" + x)>0){
					acceptIdList.add((Integer)box.getInt("acceptedId" + x));
					}
					if(box.get("collectionId" + x)!=null){
						acceptEntryIdList.add((Integer)box.getInt("collectionId" + x));
					}
				}
				}
			} else if (request.getParameter("checkIdRetest" + x) != null) {
				if(request.getParameter("checkIdRetest" + x).equalsIgnoreCase("y")){
				validatedListMultipleType.add("RT");
				retestCount++;
				multTest++;
				if(box.get("collectionId" + x)!=null){
					retestIdList.add((Integer)box.getInt("collectionId" + x));
				}
				}
			} else if (request.getParameter("checkIdRecollect" + x) != null) {
				if(request.getParameter("checkIdRecollect" + x).equalsIgnoreCase("y")){
				validatedListMultipleType.add("RC");
				multTest++;
				if((Integer)box.getInt("acceptedId" + x)>0){
					recolHIdList.add((Integer)box.getInt("acceptedId" + x));
					}
					if(box.get("collectionId" + x)!=null){
						recolEntryIdList.add((Integer)box.getInt("collectionId" + x));
					}
					
				}
			} else {
				validatedListMultipleType.add("n");
			}
		}

		if (request.getParameter(RESULT_VALIDATED_BY) != null
				&& !request.getParameter(RESULT_VALIDATED_BY).equals("")) {
			resultValidatedBy = Integer.parseInt(request
					.getParameter(RESULT_VALIDATED_BY));
		}

		infoMap.put("box", box);
		infoMap.put("validatedListSingleType", validatedListSingleType);
		infoMap.put("validatedListMultipleType", validatedListMultipleType);
		//added by govind 01-07-2017 
		infoMap.put("retestCount", retestCount);
		infoMap.put("retestIdList", retestIdList);
		infoMap.put("retestCountS", retestCountS);
		infoMap.put("retestIdListS", retestIdListS);
		infoMap.put("acceptIdList", acceptIdList);
		infoMap.put("acceptEntryIdList", acceptEntryIdList);
		infoMap.put("recolHIdList", recolHIdList);
		infoMap.put("recolEntryIdList", recolEntryIdList);
		//added by govind 01-07-2017 end
		infoMap.put("resultValidatedBy", resultValidatedBy);
		infoMap.put("hospitalId", hospitalId);  // added by amit das on 15-09-2017
		boolean flag = false;
//		try {
			// Method To Submit Single Value Type Investigation
			if(singleTes>0){
				logger.info("singleTes "+singleTes);//added by govind 01-07-2017 
			flag = investigationHandlerService
					.submitResultValidationForSingleParameterOnly(infoMap);
			}
			// Method To Submit Multiple Value Type Investigation
			if(multTest>0){
				logger.info("multTest "+multTest);//added by govind 01-07-2017 
			flag = investigationHandlerService
					.submitResultValidationLab(infoMap);
			}

			if (flag == true) {
				messageTOBeVisibleToTheUser = "Successfully Validated the result.Do you want to print.";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured.";
			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		String nextCombinedValidationIds = "";
		if (!resultIdStringForTemplate.equals("")) {
			String[] idArrString = new String[0];
			idArrString = resultIdStringForTemplate.split("@");

			int subChargeId = Integer.parseInt(idArrString[1]);

			List<String> pendingValidationListLabAll = new ArrayList<String>();
			pendingValidationListLabAll = (List<String>) session
					.getAttribute("pendingValidationListLabAll");

			if (pendingValidationListLabAll.size() > 0 && resultIdStringForTemplate != null) {
				pendingValidationListLabAll.remove(resultIdStringForTemplate);
			}
			for (String combinedIdsFromList : pendingValidationListLabAll) {
				String[] idArray = new String[0];
				idArray = combinedIdsFromList.split("@");

				int subChargeIdFromList = Integer.parseInt(idArray[1]);
				if (subChargeIdFromList == subChargeId) {
					nextCombinedValidationIds = combinedIdsFromList;
					break;
				}
			}
		}

		String jsp = MESSAGE_FOR_RESULT_VALIDATION_LAB + ".jsp";

		map.put("resultIdStringForTemplate", resultIdStringForTemplate);
		map.put("nextCombinedValidationIds", nextCombinedValidationIds);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView submitResultValidationForAllInvestigationTypeLabForEmpanelled(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in submitResultValidationForAllInvestigationTypeLabForEmpanelled");
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String url = "";
		int resultId = 0;
		int newResultId = 0;
		int resultValidatedBy = 0;
		String messageTOBeVisibleToTheUser = "";
		String resultIdStringForTemplate = "";
		int validatedCheckBoxCountMultiple = 0;
		int validatedCheckBoxCountSingle = 0;
		String checkId1 = "";
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		if (request.getParameter("validatedCheckBoxCountSingle") != null
				&& !request.getParameter("validatedCheckBoxCountSingle")
						.equals("")) {
			validatedCheckBoxCountSingle = Integer.parseInt(request
					.getParameter("validatedCheckBoxCountSingle"));
		}
		if (request.getParameter("validatedCheckBoxCountMultiple") != null
				&& !request.getParameter("validatedCheckBoxCountMultiple")
						.equals("")) {
			validatedCheckBoxCountMultiple = Integer.parseInt(request
					.getParameter("validatedCheckBoxCountMultiple"));
		}
		if (request.getParameter("resultIdStringForTemplate") != null) {
			resultIdStringForTemplate = (String) request
					.getParameter("resultIdStringForTemplate");
		}

		List<String> validatedListSingleType = new ArrayList<String>();
		List<String> validatedListMultipleType = new ArrayList<String>();

		for (int x = 0; x < validatedCheckBoxCountSingle; x++) {
			if (request.getParameter("checkIdSingleValue" + x) != null) {
				validatedListSingleType.add("y");
			} else if (request.getParameter("checkIdSingleValueRetest" + x) != null) {
				validatedListSingleType.add("RT");
			} else if (request.getParameter("checkIdSingleValueRecollect" + x) != null) {
				validatedListSingleType.add("RC");
			} else {
				validatedListSingleType.add("n");
			}
		}
		for (int x = 0; x < validatedCheckBoxCountMultiple; x++) {
			if (request.getParameter("checkId" + x) != null) {
				validatedListMultipleType.add("y");
			} else if (request.getParameter("checkIdRetest" + x) != null) {
				validatedListMultipleType.add("RT");
			} else if (request.getParameter("checkIdRecollect" + x) != null) {
				validatedListMultipleType.add("RC");
			} else {
				validatedListMultipleType.add("n");
			}
		}

		if (request.getParameter(RESULT_VALIDATED_BY) != null
				&& !request.getParameter(RESULT_VALIDATED_BY).equals("")) {
			resultValidatedBy = Integer.parseInt(request
					.getParameter(RESULT_VALIDATED_BY));
		}

		infoMap.put("box", box);
		infoMap.put("validatedListSingleType", validatedListSingleType);
		infoMap.put("validatedListMultipleType", validatedListMultipleType);

		infoMap.put("resultValidatedBy", resultValidatedBy);
		boolean flag = false;
		try {
			// Method To Submit Single Value Type Investigation
			flag = investigationHandlerService
					.submitResultValidationForSingleParameterOnlyForEmpanelled(infoMap);

			// Method To Submit Multiple Value Type Investigation
			flag = investigationHandlerService
					.submitResultValidationLabForEmpanelled(infoMap);

			if (flag == true) {
				messageTOBeVisibleToTheUser = "Successfully Validated the result.Do you want to print.";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String nextCombinedValidationIds = "";
		if (!resultIdStringForTemplate.equals("")) {
			String[] idArrString = new String[0];
			idArrString = resultIdStringForTemplate.split("@");

			int subChargeId = Integer.parseInt(idArrString[1]);

			List<String> pendingValidationListLabAll = new ArrayList<String>();
			pendingValidationListLabAll = (List<String>) session
					.getAttribute("pendingValidationListLabAll");

			if (pendingValidationListLabAll.size() > 0) {
				pendingValidationListLabAll.remove(resultIdStringForTemplate);
			}
			for (String combinedIdsFromList : pendingValidationListLabAll) {
				String[] idArray = new String[0];
				idArray = combinedIdsFromList.split("@");

				int subChargeIdFromList = Integer.parseInt(idArray[1]);
				if (subChargeIdFromList == subChargeId) {
					nextCombinedValidationIds = combinedIdsFromList;
					break;
				}
			}
		}

		String jsp = MESSAGE_FOR_RESULT_VALIDATION_LAB + ".jsp";

		map.put("resultIdStringForTemplate", resultIdStringForTemplate);
		map.put("nextCombinedValidationIds", nextCombinedValidationIds);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView submitResultEntryForAllInvestigationTypeLabForPostQC(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in submitResultEntryForAllInvestigationTypeLabForPostQC");
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String url = "";
		int resultId = 0;
		int newResultId = 0;
		int resultValidatedBy = 0;
		String messageTOBeVisibleToTheUser = "";
		String resultIdStringForTemplate = ""; 
		String checkId1 = "";
		int deptId = 0;
		int userId=0;
		int postResultEntryCheckBoxCountMultiple = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		} 
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt("" + session.getAttribute("userId"));
			box.put("userId", userId);
		}
		 

		if (request.getParameter(RESULT_VALIDATED_BY) != null
				&& !request.getParameter(RESULT_VALIDATED_BY).equals("")) {
			resultValidatedBy = Integer.parseInt(request
					.getParameter(RESULT_VALIDATED_BY));
		}
		List<String> postResultEntryListMultipleType = new ArrayList<String>();
		if (request.getParameter("validatedCheckBoxCountMultiple") != null
				&& !request.getParameter("validatedCheckBoxCountMultiple")
						.equals("")) {
			postResultEntryCheckBoxCountMultiple = Integer.parseInt(request
					.getParameter("validatedCheckBoxCountMultiple"));
		}
		for (int x = 0; x < postResultEntryCheckBoxCountMultiple; x++) { 
			postResultEntryListMultipleType.add("y"); 	 
		}
		infoMap.put("box", box); 
		infoMap.put("postResultEntryListMultipleType", postResultEntryListMultipleType);
		infoMap.put("resultValidatedBy", resultValidatedBy);
		boolean flag = false;
		try {
			// Method To Submit Single Value Type Investigation
			//submitResultEntryForSingleParameterOnly
			map = investigationHandlerService
					.submitResultEntryForSingleParameterOnlyPostQC(infoMap);
			
			// Method To Submit Multiple Value Type Investigation
			flag = investigationHandlerService
					.submitResultEntryForMultipleParameterOnlyPostQC(infoMap);
			if(map.get("saved")!=null){
				flag= (Boolean)map.get("saved");
			}
			if (flag == true) {
				messageTOBeVisibleToTheUser = "Successfully Validated the result.Do you want to print.";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String nextCombinedValidationIds = "";
		if (!resultIdStringForTemplate.equals("")) {
			String[] idArrString = new String[0];
			idArrString = resultIdStringForTemplate.split("@");

			int subChargeId = Integer.parseInt(idArrString[1]);

			List<String> pendingValidationListLabAll = new ArrayList<String>();
			pendingValidationListLabAll = (List<String>) session
					.getAttribute("pendingValidationListLabAll");

			if (pendingValidationListLabAll.size() > 0) {
				pendingValidationListLabAll.remove(resultIdStringForTemplate);
			}
			for (String combinedIdsFromList : pendingValidationListLabAll) {
				String[] idArray = new String[0];
				idArray = combinedIdsFromList.split("@");

				int subChargeIdFromList = Integer.parseInt(idArray[1]);
				if (subChargeIdFromList == subChargeId) {
					nextCombinedValidationIds = combinedIdsFromList;
					break;
				}
			}
		}

		String jsp = MESSAGE_FOR_RESULT_VALIDATION_LAB + ".jsp";

		map.put("resultIdStringForTemplate", resultIdStringForTemplate);
		map.put("nextCombinedValidationIds", nextCombinedValidationIds);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// ======================== submit result validation for template
	// ================
	public ModelAndView submitResultValidationForTemplate(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in submitResultValidationForTemplate");
		MultipartFormDataRequest mrequest = null;
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		String url = "";
		String resultNo = "";
		String resultType = "";
		String result = "";
		String additionalRemarks = "";
		String validated = "";

		int resultId = 0;
		int newResultId = 0;
		int resultValidatedBy = 0;
		int deptId = 0;
		String tepmlateData ="";
		try {
			if (MultipartFormDataRequest.isMultipartFormData(request)) {
				mrequest = new MultipartFormDataRequest(request);
				// result=mrequest.getParameter("test2");
				 tepmlateData =  mrequest.getParameter("test2"); //mrequest.getParameter(TEMP_RESULT);
				InputStream fis1 = new FileInputStream(getServletContext()
						.getRealPath("jsp/pdf/appendingHtml.html"));
				File temprory2 = new File(getServletContext().getRealPath(
						"jsp/pdf/appendingHtml.html"));
				byte[] b1 = new byte[(int) temprory2.length()];
				int offset1 = 0;
				int numRead1 = 0;
				try {
					while ((offset1 < b1.length)
							&& ((numRead1 = fis1.read(b1, offset1, b1.length
									- offset1)) >= 0)) {

						offset1 += numRead1;

					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					fis1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				String appendedHtml = new String(b1);
				String finalFile = appendedHtml + tepmlateData
						+ "</body></html>";

				byte[] bytes = finalFile.getBytes();
				result = new String(bytes);

			}else{
				result = request.getParameter("test2");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (request.getParameter("resultNo") != null) {

			resultNo = request.getParameter("resultNo");
		}
		if (mrequest!=null && mrequest.getParameter("sms") != null) {

			String sms = mrequest.getParameter("sms");
			box.put("sms", sms);
		}else if(request.getParameter("sms") != null){
			String sms = mrequest.getParameter("sms");
			box.put("sms", sms);
		}

		if (request.getParameter("resultType") != null) {
			resultType = request.getParameter("resultType");
		}

		resultId = Integer.parseInt(request.getParameter("resultId"));
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();

		patientList = (List<DgResultEntryHeader>) session
				.getAttribute("patientList");
		if (patientList.size() > 0) {
			for (Iterator iterator = patientList.iterator(); iterator.hasNext();) {
				DgResultEntryHeader dgResultEntryHeader = (DgResultEntryHeader) iterator
						.next();
				newResultId = dgResultEntryHeader.getId();
				if (newResultId == resultId) {
					iterator.remove();
				}
			}
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("resultNo", resultNo);
		dataMap.put("deptId", deptId);
		dataMap.put("templateData", result);
		boolean flag1 = investigationHandlerService
				.updateResultTemplateForValidation(dataMap);
		Map<String, Object> patientMap = new HashMap<String, Object>();
		if (newResultId != 0) {
			map = investigationHandlerService.getResultEntryDetailsForNext(
					newResultId, deptId);
		}

		if (request.getParameter(RESULT_VALIDATED_BY) != null
				&& !request.getParameter(RESULT_VALIDATED_BY).equals("")) {
			resultValidatedBy = Integer.parseInt(request
					.getParameter(RESULT_VALIDATED_BY));
		}
		if (request.getParameter(ADDITIONAL_REMARKS) != null
				&& !request.getParameter(ADDITIONAL_REMARKS).equals("")) {
			additionalRemarks = request.getParameter(ADDITIONAL_REMARKS);
		}
		if (request.getParameter(VALIDATED) != null
				&& !request.getParameter(VALIDATED).equals("")) {
			validated = request.getParameter(VALIDATED);
		}

		map = investigationHandlerService.getResultList(resultId);
		infoMap.put("box", box);
		String jsp = MESSAGE_FOR_RESULT_JSP + ".jsp";

		infoMap.put("resultId", resultId);
		infoMap.put("resultValidatedBy", resultValidatedBy);
		infoMap.put("additionalRemarks", additionalRemarks);
		infoMap.put("validated", validated);

		boolean flag = false;
		try {
			flag = investigationHandlerService
					.submitResultValidationForTemplate(infoMap);
			if (flag == false) {
				messageTOBeVisibleToTheUser = "Successfully Validated the result.Do you want to print.";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		url = "/hms/hms/investigation?method=searchPatientForResultValidation";
		map.put("resultNo", resultNo);
		map.put("resultType", resultType);
		map.put("resultId", resultId);
		map.put("newResultId", newResultId);
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showReportCollectionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in showReportCollectionJsp");
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String deptName = "";
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
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = investigationHandlerService
				.getDetailsForReportCollection(dataMap);
		patientMap = investigationHandlerService.getResultViewGrid(mapForDs);
		String jsp = DG_REPORT_COLLECTION;
		jsp += ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("patientMap", patientMap);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showReportCollectionJspForQC(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in showReportCollectionJspForQC");
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String deptName = "";
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
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = investigationHandlerService
				.getDetailsForReportCollection(dataMap);
		patientMap = investigationHandlerService.getResultViewGrid(mapForDs);
		String jsp =RequestConstants.DG_REPORT_COLLECTION_FOR_QC;
		jsp += ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("patientMap", patientMap);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForReportCollection(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in searchPatientForReportCollection");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String hinNo = "";
		int chargeCodeId = 0;
		String pType = "";
		String patientFName = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String adNo = "";
		String orderType = "";
		String userName = "";
		String deptName = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		int hinId = 0;
		int resultId = 0;
		int deptId = 0;
		int hospitalId = 0;
		int userId = 0;
		String mobileNo = "";
		String wardName = "";
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
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("userId", userId);
		try {
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
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
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
			if (request.getParameter(SAMPLE_ID) != null
					&& !(request.getParameter(SAMPLE_ID).equals("0"))) {
				sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
			}

			if (request.getParameter(RESULT_ID) != null
					&& !(request.getParameter(RESULT_ID).equals("0"))) {
				resultId = Integer.parseInt(request.getParameter(RESULT_ID));
				mapForDs.put("resultId", resultId);
			}
			if (request.getParameter(WARD_NAME) != null
					&& !(request.getParameter(WARD_NAME).equals("0"))) {
				wardName = request.getParameter(WARD_NAME);
				mapForDs.put(WARD_NAME, wardName);
			}
			if (request.getParameter(MOBILE_NO) != null
					&& !(request.getParameter(MOBILE_NO).equals("0"))) {
				mobileNo = request.getParameter(MOBILE_NO);
				mapForDs.put(MOBILE_NO, mobileNo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = investigationHandlerService
				.getPatientDetailsForReportCollection(mapForDs);
		String jsp = "";
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailsList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailsList");
		}
		Map<String, Object> diagMap = new HashMap<String, Object>();
		if (resultId != 0) {
			map = investigationHandlerService.getResultDetails(resultId);
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			if (map.get("resultList") != null) {
				resultList = (List<DgResultEntryHeader>) map.get("resultList");
			}
			Set<DgResultEntryDetail> dgDetailSet = new HashSet<DgResultEntryDetail>();

			for (DgResultEntryHeader dgHeader : resultList) {
				dgDetailSet = dgHeader.getDgResultEntryDetails();
			}
			for (DgResultEntryDetail dgResEntry : dgDetailSet) {
				if (dgResEntry.getInvestigation().getInvestigationType()
						.equals("s")) {
					jsp = DG_VIEW_REPORT_FOR_SINGLE_PARAMETER + ".jsp";
				} else if (dgResEntry.getInvestigation().getInvestigationType()
						.equals("m")) {
					jsp = DG_VIEW_REPORT_COLLECTION + ".jsp";
				} else if (dgResEntry.getInvestigation().getInvestigationType()
						.equals("t")) {
					jsp = DG_VIEW_REPORT_COLLECTION_FOR_TEMPLATE + ".jsp";

				}
			}
			/*
			 * List<DgResultEntryDetailSen> dgResultdetailSenList = new
			 * ArrayList<DgResultEntryDetailSen>(); //
			 * if(map.get("dgResultdetailSenList") != null) // {
			 * dgResultdetailSenList = (List<DgResultEntryDetailSen>)
			 * map.get("dgResultdetailSenList");
			 * map.put("dgResultdetailSenList", dgResultdetailSenList); jsp =
			 * "viewReportCollectionForSen.jsp"; // }
			 */}

		else {
			detailsMap = investigationHandlerService
					.getDetailsForReportCollection(dataMap);
			jsp = DG_REPORT_COLLECTION + ".jsp";
		}
		patientMap.put("patientList", patientList);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("dataMap", dataMap);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForReportCollectionForQC(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in searchPatientForReportCollectionForQC");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String hinNo = "";
		int chargeCodeId = 0;
		String pType = "";
		String patientFName = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String adNo = "";
		String orderType = "";
		String userName = "";
		String deptName = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		int hinId = 0;
		int resultId = 0;
		int deptId = 0;
		int hospitalId = 0;
		int userId = 0;
		String mobileNo = "";
		String wardName = "";
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
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("userId", userId);
		try {
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
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
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
			if (request.getParameter(SAMPLE_ID) != null
					&& !(request.getParameter(SAMPLE_ID).equals("0"))) {
				sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
			}

			if (request.getParameter(RESULT_ID) != null
					&& !(request.getParameter(RESULT_ID).equals("0"))) {
				resultId = Integer.parseInt(request.getParameter(RESULT_ID));
				mapForDs.put("resultId", resultId);
			}
			if (request.getParameter(WARD_NAME) != null
					&& !(request.getParameter(WARD_NAME).equals("0"))) {
				wardName = request.getParameter(WARD_NAME);
				mapForDs.put(WARD_NAME, wardName);
			}
			if (request.getParameter(MOBILE_NO) != null
					&& !(request.getParameter(MOBILE_NO).equals("0"))) {
				mobileNo = request.getParameter(MOBILE_NO);
				mapForDs.put(MOBILE_NO, mobileNo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = investigationHandlerService
				.getPatientDetailsForReportCollection(mapForDs);
		String jsp = "";
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailsList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailsList");
		}
		Map<String, Object> diagMap = new HashMap<String, Object>();
		if (resultId != 0) {
			map = investigationHandlerService.getResultDetails(resultId);
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			if (map.get("resultList") != null) {
				resultList = (List<DgResultEntryHeader>) map.get("resultList");
			}
			Set<DgResultEntryDetail> dgDetailSet = new HashSet<DgResultEntryDetail>();

			for (DgResultEntryHeader dgHeader : resultList) {
				dgDetailSet = dgHeader.getDgResultEntryDetails();
			}
			for (DgResultEntryDetail dgResEntry : dgDetailSet) {
				if (dgResEntry.getInvestigation().getInvestigationType()
						.equals("s")) {
					jsp = DG_VIEW_REPORT_FOR_SINGLE_PARAMETER + ".jsp";
				} else if (dgResEntry.getInvestigation().getInvestigationType()
						.equals("m")) {
					jsp = DG_VIEW_REPORT_COLLECTION + ".jsp";
				} else if (dgResEntry.getInvestigation().getInvestigationType()
						.equals("t")) {
					jsp = DG_VIEW_REPORT_COLLECTION_FOR_TEMPLATE + ".jsp";

				}
			}
			/*
			 * List<DgResultEntryDetailSen> dgResultdetailSenList = new
			 * ArrayList<DgResultEntryDetailSen>(); //
			 * if(map.get("dgResultdetailSenList") != null) // {
			 * dgResultdetailSenList = (List<DgResultEntryDetailSen>)
			 * map.get("dgResultdetailSenList");
			 * map.put("dgResultdetailSenList", dgResultdetailSenList); jsp =
			 * "viewReportCollectionForSen.jsp"; // }
			 */}

		else {
			detailsMap = investigationHandlerService
					.getDetailsForReportCollection(dataMap);
			jsp =RequestConstants.DG_REPORT_COLLECTION_FOR_QC + ".jsp";
		}
		patientMap.put("patientList", patientList);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("dataMap", dataMap);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getFileName(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in getFileName");
		String uploadURL = "";
		MultipartFormDataRequest mrequest = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if ((Map) request.getSession().getAttribute("map") != null) {
				map = (Map) request.getSession().getAttribute("map");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String filePath = "";
		String fileContent = "";
		UploadFile file = null;
		InputStream is = null;
		String Format = "";
		Properties properties = new Properties();
		FileOutputStream fos = null;
		ModelAndView mv1 = null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("file.properties");

		try {
			properties.load(resourcePath.openStream());
			uploadURL = properties.getProperty("uploadinvestigationfile");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			new File(getServletContext().getRealPath("/temp/")).mkdir();
			if (MultipartFormDataRequest.isMultipartFormData(request)) {
				try {
					if (request.getParameter("browse") != null
							&& !request.getParameter("browse").equals("")) {
						map.put("browse", "browse");
					}
					if (request.getParameter("browseInResultEntry") != null
							&& !request.getParameter("browseInResultEntry")
									.equals("")) {
						session.setAttribute("browseInResultEntry",
								"browseInResultEntry");
						map.put("browse", "browse");
					}

					mrequest = new MultipartFormDataRequest(request);
					String temlateData = "";

					if (mrequest.getParameter("test2") != null
							&& !(mrequest.getParameter("test2").equals(""))) {
						temlateData = (mrequest.getParameter("test2")).trim();
						// code added for persisting the removed html code by
						// wysiwyg

						fos = new FileOutputStream(getServletContext()
								.getRealPath("/temp/" + "temp.html"));
						fos.write(temlateData.getBytes());
						fos.close();
						request.setAttribute("secondRequest", "secondRequest");
						if (request.getParameter("formName") != null) {
							if (request.getParameter("formName").equals(
									"sampleCollection")) {
								mv1 = searchPatient(request, response);
							} else {
								mv1 = searchPatientForResultValidation(request,
										response);
							}
						}
					}
					java.util.Hashtable files = mrequest.getFiles();

					if ((files != null) && (!files.isEmpty())) {
						file = (UploadFile) files.get(UPLOAD_FILENAME);

						try {
							is = file.getInpuStream();
						} catch (Exception e) {
							e.printStackTrace();
						}
						if (is != null) {
							if (request.getParameter("browse") != null
									&& !request.getParameter("browse").equals(
											"")) {
								map.put("browse",
										request.getParameter("browse"));
							}
							File temprory = new File(getServletContext()
									.getRealPath("/temp/" + "temp.html"));

							fos = new FileOutputStream(temprory);
							byte[] buf = new byte[1024];
							int len;

							while ((len = is.read(buf)) > 0) {

								fos.write(buf, 0, len);

							}
							fos.close();
							is.close();
							// code for parseing html contents from the file
							File temprory1 = new File(getServletContext()
									.getRealPath("/temp/" + "temp.html"));
							InputStream fis = new FileInputStream(
									getServletContext().getRealPath(
											"/temp/" + "temp.html"));

							byte[] b3 = new byte[(int) temprory1.length()];
							int offset = 0;
							int numRead = 0;
							while ((offset < b3.length)
									&& ((numRead = fis.read(b3, offset,
											b3.length - offset)) >= 0)) {

								offset += numRead;

							}
							fis.close();
							// String appendedHtml=new String(b3);
							// if(appendedHtml.contains("<div class=")){
							// int index=appendedHtml.indexOf("<div class=");
							// appendedHtml=appendedHtml.substring(0, index);
							//
							// map.put("appendedHtml", appendedHtml);
							//
							// }
							InputStream fis1 = new FileInputStream(
									getServletContext().getRealPath(
											"jsp/pdf/appendingHtml.html"));
							File temprory2 = new File(getServletContext()
									.getRealPath("jsp/pdf/appendingHtml.html"));
							byte[] b1 = new byte[(int) temprory2.length()];
							int offset1 = 0;
							int numRead1 = 0;
							try {
								while ((offset1 < b1.length)
										&& ((numRead1 = fis1.read(b1, offset1,
												b1.length - offset1)) >= 0)) {

									offset1 += numRead1;

								}
							} catch (IOException e) {
								e.printStackTrace();
							}
							try {
								fis1.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
							String appendedHtml = new String(b1);
							map.put("appendedHtml", appendedHtml);
							is.close();
							if (request.getParameter("parameterName") != null) {
								mv1 = searchPatient(request, response);
							}
							fileContent = HMSUtil
									.getContent(getServletContext()
											.getRealPath("/temp/" + "temp.html"));
						} else {
							String parser = MultipartFormDataRequest.DEFAULTPARSER;
							Vector listeners = null;
							String encoding = "iso-8859-1";
							int uploadlimit = 1024 * 1024 * 1024;
							// try{
							// mrequest = new
							// MultipartFormDataRequest(request,listeners,
							// uploadlimit,parser, encoding);
							// }
							// catch(Exception e){
							// e.printStackTrace();
							// }
							String template = (mrequest.getParameter("test2"))
									.trim();

							fos = new FileOutputStream(getServletContext()
									.getRealPath("/temp/" + "temp.html"));
							fos.write(template.getBytes());
							fos.close();

						}
					}
					// else
					// {
					//
					//
					// String parser = MultipartFormDataRequest.DEFAULTPARSER;
					// Vector listeners = null;
					// String encoding = "iso-8859-1";
					// int uploadlimit = 1024*1024*1024;
					//
					// try{//MultipartRequest mr = new
					// MultipartRequest(request,getServletContext().getRealPath("/temp/"));
					// mrequest = new MultipartFormDataRequest(request);
					// }
					// catch(Exception e){
					// e.printStackTrace();
					//
					// }
					// String template=mrequest.getParameter("test2");
					//
					// FileOutputStream fos=new
					// FileOutputStream(getServletContext().getRealPath("/temp/"+"temp.html"));
					// fos.write( template.getBytes());
					//
					//
					//
					// }
				}

				catch (Exception e) {
					e.printStackTrace();
				}
			}
			fileContent = HMSUtil.getContent(getServletContext().getRealPath(
					"/temp/" + "temp.html"));

			map.put("content", fileContent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ///////////////////////// Finally added By Naresh
		finally {
			try {
				if (is != null) {
					is.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// code added for persisting the removed html code by wysiwyg
		String appendedHtml1 = "";
		boolean flag = false;

		if (mrequest.getParameter("appendedHtml") != null
				&& !mrequest.getParameter("appendedHtml").equals("")) {
			if (mrequest.getParameter("browse").equals("")) {
				appendedHtml1 = mrequest.getParameter("appendedHtml");

				String template = mrequest.getParameter("test2");
				if (appendedHtml1 != null && !appendedHtml1.equals("")) {
					map.put("appendedHtml", appendedHtml1);
					try {
						fos = new FileOutputStream(getServletContext()
								.getRealPath("/temp/" + "temp.html"));
						template = appendedHtml1 + template + "</body></html>";

						fos.write(template.getBytes());
						fos.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		if (mv1 != null && request.getParameter("formName") != null) {
			map = (Map<String, Object>) mv1.getModelMap().get("map");
			map.put("appendedHtml", fileContent);
			return mv1;
		} else {
			return new ModelAndView("index", "map", map);
		}
	}

	public ModelAndView getFileNameForController(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in getFileNameForController");
		String uploadURL = "";
		MultipartFormDataRequest mrequest = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if ((Map) request.getSession().getAttribute("map") != null) {
				map = (Map) request.getSession().getAttribute("map");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String filePath = "";
		String fileContent = "";
		UploadFile file = null;
		InputStream is = null;
		String Format = "";
		Properties properties = new Properties();
		FileOutputStream fos = null;
		ModelAndView mv1 = null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("file.properties");

		try {
			properties.load(resourcePath.openStream());
			uploadURL = properties.getProperty("uploadinvestigationfile");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			new File(getServletContext().getRealPath("/temp/")).mkdir();
			if (MultipartFormDataRequest.isMultipartFormData(request)) {
				try {
					mrequest = new MultipartFormDataRequest(request);
					String temlateData = "";
					if (mrequest.getParameter("test2") != null
							&& !(mrequest.getParameter("test2").equals(""))) {
						temlateData = (mrequest.getParameter("test2")).trim();
						// code added for persisting the removed html code by
						// wysiwyg
						fos = new FileOutputStream(getServletContext()
								.getRealPath("/temp/" + "temp.html"));
						fos.write(temlateData.getBytes());
						fos.close();
						request.setAttribute("secondRequest", "secondRequest");
						if (request.getParameter("formName") != null) {
							if (request.getParameter("formName").equals(
									"sampleCollection")) {
								mv1 = searchPatient(request, response);
							} else {
								mv1 = searchPatientForResultValidation(request,
										response);
							}
						}
					}

					java.util.Hashtable files = mrequest.getFiles();
					if ((files != null) && (!files.isEmpty())) {
						file = (UploadFile) files.get(UPLOAD_FILENAME);
						try {
							is = file.getInpuStream();
						} catch (Exception e) {
							e.printStackTrace();
						}
						if (is != null) {
							File temprory = new File(getServletContext()
									.getRealPath("/temp/" + "temp.html"));
							fos = new FileOutputStream(temprory);
							byte[] buf = new byte[1024];
							int len;
							while ((len = is.read(buf)) > 0) {
								fos.write(buf, 0, len);
							}
							fos.close();
							is.close();
							// code for parseing html contents from the file
							File temprory1 = new File(getServletContext()
									.getRealPath("/temp/" + "temp.html"));
							InputStream fis = new FileInputStream(
									getServletContext().getRealPath(
											"/temp/" + "temp.html"));
							byte[] b3 = new byte[(int) temprory1.length()];
							int offset = 0;
							int numRead = 0;
							while ((offset < b3.length)
									&& ((numRead = fis.read(b3, offset,
											b3.length - offset)) >= 0)) {
								offset += numRead;
							}
							fis.close();
							InputStream fis1 = new FileInputStream(
									getServletContext().getRealPath(
											"jsp/pdf/appendingHtml.html"));
							File temprory2 = new File(getServletContext()
									.getRealPath("jsp/pdf/appendingHtml.html"));
							byte[] b1 = new byte[(int) temprory2.length()];
							int offset1 = 0;
							int numRead1 = 0;
							try {
								while ((offset1 < b1.length)
										&& ((numRead1 = fis1.read(b1, offset1,
												b1.length - offset1)) >= 0)) {
									offset1 += numRead1;
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
							try {
								fis1.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
							String appendedHtml = new String(b1);
							map.put("appendedHtml", appendedHtml);
							is.close();
							if (request.getParameter("parameterName") != null) {
								mv1 = searchPatient(request, response);
							}
							fileContent = HMSUtil
									.getContent(getServletContext()
											.getRealPath("/temp/" + "temp.html"));
						} else {
							String parser = MultipartFormDataRequest.DEFAULTPARSER;
							Vector listeners = null;
							String encoding = "iso-8859-1";
							int uploadlimit = 1024 * 1024 * 1024;
							String template = (mrequest.getParameter("test2"))
									.trim();

							fos = new FileOutputStream(getServletContext()
									.getRealPath("/temp/" + "temp.html"));
							fos.write(template.getBytes());
							fos.close();
						}

					}
					// else
					// {
					//
					//
					// String parser = MultipartFormDataRequest.DEFAULTPARSER;
					// Vector listeners = null;
					// String encoding = "iso-8859-1";
					// int uploadlimit = 1024*1024*1024;
					//
					// try{//MultipartRequest mr = new
					// MultipartRequest(request,getServletContext().getRealPath("/temp/"));
					// mrequest = new MultipartFormDataRequest(request);
					// }
					// catch(Exception e){
					// e.printStackTrace();
					//
					// }
					// String template=mrequest.getParameter("test2");
					//
					// FileOutputStream fos=new
					// FileOutputStream(getServletContext().getRealPath("/temp/"+"temp.html"));
					// fos.write( template.getBytes());
					//
					//
					//
					// }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			fileContent = HMSUtil.getContent(getServletContext().getRealPath(
					"/temp/" + "temp.html"));
			map.put("content", fileContent);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ///////////////////////////////////////
		// code added for persisting the removed html code by wysiwyg
		String appendedHtml1 = "";
		boolean flag = false;

		if (mrequest.getParameter("appendedHtml") != null
				&& !mrequest.getParameter("appendedHtml").equals("")) {
			if (mrequest.getParameter("browse").equals("")) {
				appendedHtml1 = mrequest.getParameter("appendedHtml");

				String template = mrequest.getParameter("test2");
				if (appendedHtml1 != null && !appendedHtml1.equals("")) {
					map.put("appendedHtml", appendedHtml1);
					try {
						fos = new FileOutputStream(getServletContext()
								.getRealPath("/temp/" + "temp.html"));
						template = appendedHtml1 + template + "</body></html>";

						fos.write(template.getBytes());
						fos.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		if (mv1 != null && request.getParameter("formName") != null) {
			return mv1;
		} else {
			return new ModelAndView("index", "map", map);
		}
	}

	// /////////////////////////////////
	public ModelAndView saveIncrementlyTemplate(HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException,
			IOException {
		logger.info("in saveIncrementlyTemplate");
		Map<String, Object> map = new HashMap<String, Object>();
		String updatedTemplate = request.getParameter("test2");

		// File template=new
		// File(getServletContext().getRealPath("/temp/"+"temp.html"));
		FileOutputStream fos = new FileOutputStream(getServletContext()
				.getRealPath("/temp/" + "temp.html"));
		fos.write(updatedTemplate.getBytes());
		return null;
	}

	public ModelAndView showPrintResultEntry(HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException,
			IOException {
		logger.info("in showPrintResultEntry");
		Map<String, Object> map = new HashMap<String, Object>();
		String resultNo = "";
		String resultType = "";
		String userName = "";
		String deptType = "";
		int hospitalId = 0;
		int deptId = 0;
		int userId = 0;
		String deptName = "";
		try {

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
			if (session.getAttribute("deptType") != null) {
				deptType = (String) session.getAttribute("deptType");
			}
			if (session.getAttribute("userId") != null) {
				userId = Integer.parseInt("" + session.getAttribute("userId"));
			}
			if (request.getParameter(RESULT_NO) != null) {
				resultNo = request.getParameter(RESULT_NO);
			}
			if (request.getParameter(RESULT_TYPE) != null) {
				resultType = request.getParameter(RESULT_TYPE);
			}
			Map<String, Object> detailsMap1 = new HashMap<String, Object>();
			List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();

			detailsMap1 = investigationHandlerService
					.getResultEntryDetailsForTemplate(resultNo, deptId);
			Map<String, Object> dataMap = getHospitalParameterDetails(request);
			if (dataMap.get("hospitalAddress") != null) {
				map.put("hospitalAddress",
						(String) dataMap.get("hospitalAddress"));
			}
			if (dataMap.get("hospitalName") != null) {
				map.put("hospitalName", (String) dataMap.get("hospitalName"));
			}
			dgResultdetailList = (List<DgResultEntryDetail>) detailsMap1
					.get("resultList");
			map.put("dgResultdetailList", dgResultdetailList);
			map.put("detailsMap1", detailsMap1);
			map.put("deptName", deptName);
			map.put("deptType", deptType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("resultEntryPrint", "map", map);

	}

	// ============== submit result entry for template
	// ==============================================================
	// ** start of method of submit result entry for template **/
	public ModelAndView submitResultEntryForTempelate(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in submitResultEntryForTempelate");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		boolean saved = false;
		int hospitalId = 0;
		Users users = null;
		String userName = "";
		MultipartFormDataRequest mrequest = null;
		String result = "";
		Box box = HMSUtil.getBox(request);
		String messageTOBeVisibleToTheUser = "";
		String resultNo = "";
		HttpSession session = request.getSession();
		int sampleCollectionId = 0;
		int newSampleCollectionId = 0;
		String resultType = "t";
		int deptId = 0;
		int investigationHeaderId = 0;
		int hinId_OPD =0;
		String RequisitionFrom = "NA"; 
		
		
		
		try {

			if (MultipartFormDataRequest.isMultipartFormData(request)) {
				try {
					mrequest = new MultipartFormDataRequest(request);
					//System.out.println(mrequest);
					if (mrequest.getParameter(TEMP_RESULT) != null) {
						result = mrequest.getParameter(TEMP_RESULT);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				if (request.getParameter(TEMP_RESULT) != null) {
					result = request.getParameter(TEMP_RESULT);
				}
			}
			
			 String fileExtension=null;
	            
	            String uploadURL = getServletContext().getRealPath("/");
	           
	            String filename = "";
	            List fileUploadedList = null;
	                if(mrequest!=null && mrequest.getParameter("fileName")!= null){
	                    filename = mrequest.getParameter("fileName");
	                }
                     if(filename.length()>0)
                     {
                    	 parameterMap.put("filename", filename);
     	                StringTokenizer strToken=new StringTokenizer(filename,".");
     	                Long fileSizeLimit = RequestConstants.MAX_FILE_SIZE;
     	                filename=strToken.nextToken();
     	                   fileExtension=strToken.nextToken();
     	                   String whiteList = "*."+fileExtension;
     	                  
     	                   fileUploadedList = HMSUtil.uploadFileMaintenance(mrequest,uploadURL, whiteList,fileSizeLimit,filename);
     	                
     	               
     	                   parameterMap.put("uploadURL", uploadURL);
                     }
	               
	                
	                
			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}

			sampleCollectionId = box.getInt(DG_SAMPLE_DETAIL_ID);
			List<DgSampleCollectionDetails> patientList = new ArrayList<DgSampleCollectionDetails>();

			patientList = (List<DgSampleCollectionDetails>) session
					.getAttribute("patientList");

			if (patientList.size() > 0) {
				for (Iterator iterator = patientList.iterator(); iterator
						.hasNext();) {
					DgSampleCollectionDetails dgSampleDetail = (DgSampleCollectionDetails) iterator
							.next();
					newSampleCollectionId = dgSampleDetail.getId();
					if (newSampleCollectionId == sampleCollectionId) {
						iterator.remove();
					}
				}

			}
			Map<String, Object> patientMap = new HashMap<String, Object>();
			if (newSampleCollectionId != 0) {
				map = investigationHandlerService.getResultEntryForNext(
						newSampleCollectionId, deptId);
			}
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				parameterMap.put("hospitalId", hospitalId);
			}
			if (session.getAttribute(LOGIN_NAME) != null) {
				userName = (String) session.getAttribute(LOGIN_NAME);
				parameterMap.put("userName", userName);
			}
			if (session.getAttribute(USERS) != null) {
				users = (Users) session.getAttribute(USERS);
				parameterMap.put("userName", userName);
			}
			if (request.getParameter(RESULT_NO) != null) {
				resultNo = request.getParameter(RESULT_NO);
			}
			int filmSizeUsed = 0;
			if (request.getParameter("filmSizeUsedResponse") != null
					&& request.getParameter("filmSizeUsedResponse") != "") {
				filmSizeUsed = Integer.parseInt(request
						.getParameter("filmSizeUsedResponse"));
			}
			int filmUsed = 0;
			if (request.getParameter("filmUsed") != null
					&& !request.getParameter("filmUsed").equals("")) {
				filmUsed = new Integer(request.getParameter("filmUsed"));
			}
			int hinId = 0;
			if (request.getParameter(HIN_ID) != null) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
			}
			String remarks = "";
			if (request.getParameter(REMARKS) != null) {
				resultNo = request.getParameter(REMARKS);
			}
			int subchargeId = 0;
			int mainChargeId = 0;

			int inpatientId = 0;
			int employeeId = 0;
			int resultEnteredId = 0;
			int departId = 0;
			
			// Added bY vinay
			
			
			if(mrequest!=null && mrequest.getParameter("hinId_OPD") != null)
			{
				hinId_OPD = Integer.parseInt(mrequest.getParameter("hinId_OPD"));
			}else if(request.getParameter("hinId_OPD") != null){
				hinId_OPD = Integer.parseInt(request.getParameter("hinId_OPD"));
			}
			if(mrequest!=null && mrequest.getParameter("RequisitionFrom") != null)
			{
				RequisitionFrom = mrequest.getParameter("RequisitionFrom");
			}else if(request.getParameter("RequisitionFrom") != null){
				RequisitionFrom = request.getParameter("RequisitionFrom");
			}
			
			
			
			
			
			if (request.getParameter(MAIN_CHARGECODE_ID) != null) {
				mainChargeId = Integer.parseInt(request
						.getParameter(MAIN_CHARGECODE_ID));
			}
			if (request.getParameter(DEPARTMENT_ID) != null) {
				departId = Integer
						.parseInt(request.getParameter(DEPARTMENT_ID));
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null) {
				subchargeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
			}

			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals(""))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
			}
			if (request.getParameter(SAMPLE_COLLECTION_ID) != null) {
				sampleCollectionId = Integer.parseInt(request
						.getParameter(SAMPLE_COLLECTION_ID));
			}
			if (request.getParameter(EMPLOYEE_ID) != null
					&& !("").equals(request.getParameter(EMPLOYEE_ID))) {
				employeeId = Integer
						.parseInt(request.getParameter(EMPLOYEE_ID));

			}
			
			if (!(request.getParameter(RESULT_ENTERED_BY).equals(""))
					&& request.getParameter(RESULT_ENTERED_BY) != null) {
				resultEnteredId = Integer.parseInt(request
						.getParameter(RESULT_ENTERED_BY));
			}

			if (request.getParameter(INVESTIGATION_ID) != null
					&& (!request.getParameter(INVESTIGATION_ID).equals("0"))) {
				investigationHeaderId = Integer.parseInt(request
						.getParameter(INVESTIGATION_ID));
			}

			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
			DgResultEntryHeader dgResultEntryHeader = new DgResultEntryHeader();
			dgResultEntryHeader.setResultNo(resultNo);
			dgResultEntryHeader.setLastChgdBy(users);
			dgResultEntryHeader.setLastChgdDate(date);
			dgResultEntryHeader.setLastChgdTime(time);
			dgResultEntryHeader.setRemarks(remarks);
			dgResultEntryHeader.setResultDate(date);
			dgResultEntryHeader.setResultStatus("P");
			
			if(hinId_OPD != 0)
			{
				dgResultEntryHeader.setResultStatus("E");
				dgResultEntryHeader.setVerified("V");
				dgResultEntryHeader.setVerifiedOn(date);
				dgResultEntryHeader.setVerifiedTime(time);
				if (employeeId != 0) 
				{
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(employeeId);
					dgResultEntryHeader.setResultVerifiedBy(masEmployee);
				}
				
			}
			
			dgResultEntryHeader.setResultTime(time);

			MasMainChargecode masMainChargecode = new MasMainChargecode();
			masMainChargecode.setId(mainChargeId);
			dgResultEntryHeader.setMainChargecode(masMainChargecode);

			MasSubChargecode masSubChargecode = new MasSubChargecode();
			masSubChargecode.setId(subchargeId);
			dgResultEntryHeader.setSubChargecode(masSubChargecode);

			DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
			dgSampleCollectionHeader.setId(sampleCollectionId);
			dgResultEntryHeader
					.setSampleCollectionHeader(dgSampleCollectionHeader);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departId);
			dgResultEntryHeader.setDepartment(masDepartment);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			dgResultEntryHeader.setHospital(masHospital);

			if (investigationHeaderId != 0) {
				DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
				dgMasInvestigation.setId(investigationHeaderId);
				dgResultEntryHeader.setInvestigation(dgMasInvestigation);

			}

			if (hinId != 0) {
				Patient patient = new Patient();
				patient.setId(hinId);
				dgResultEntryHeader.setHin(patient);
			}
			if (inpatientId != 0) {
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				dgResultEntryHeader.setInpatient(inpatient);
			}
			
			if (resultEnteredId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(resultEnteredId);
				dgResultEntryHeader.setEmployee(masEmployee);
			}
			dgResultEntryHeader.setResultType(resultType);
			parameterMap.put("dgResultEntryHeader", dgResultEntryHeader);

			String additionalRemarks = "";
			int sample_Id = 0;
			int investigationId = 0;
			int uomId = 0;

			int sampleDetailId = 0;

			if (request.getParameter(RESULT_TYPE) != null) {
				resultType = request.getParameter(RESULT_TYPE);
			}

			if (request.getParameter(ADDITIONAL_REMARKS) != null) {
				additionalRemarks = request.getParameter(ADDITIONAL_REMARKS);
			}

			if (request.getParameter(INVESTIGATION_ID) != null
					&& (!request.getParameter(INVESTIGATION_ID).equals("0"))) {
				investigationId = Integer.parseInt(request
						.getParameter(INVESTIGATION_ID));
			}

			if (request.getParameter(DG_SAMPLE_DETAIL_ID) != null
					&& (!request.getParameter(DG_SAMPLE_DETAIL_ID).equals(""))) {
				sampleDetailId = Integer.parseInt(request
						.getParameter(DG_SAMPLE_DETAIL_ID));
			}
			DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
			if (investigationId != 0) {

				if (investigationId != 0) {
					DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
					dgMasInvestigation.setId(investigationId);
					dgResultEntryDetail.setInvestigation(dgMasInvestigation);
				}
				if (investigationId != 0) {
					MasChargeCode masChargeCode = new MasChargeCode();
					masChargeCode.setId(investigationId);
					dgResultEntryDetail.setChargeCode(masChargeCode);
				}
				if (sampleDetailId != 0) {
					DgSampleCollectionDetails dgSample = new DgSampleCollectionDetails();
					dgSample.setId(sampleDetailId);
					dgResultEntryDetail.setSampleCollectionDetails(dgSample);
				}

				dgResultEntryDetail.setResult(result);
				dgResultEntryDetail.setResultEntry(dgResultEntryHeader);
				dgResultEntryDetail.setRemarks(additionalRemarks);
				dgResultEntryDetail.setResultType(resultType);
				dgResultEntryDetail.setResultDetailStatus("P");
				if(hinId_OPD != 0)
				{
					dgResultEntryDetail.setValidated("V");
					dgResultEntryDetail.setResultDetailStatus("E");
										
				}
				
				dgResultEntryDetail.setFilmUsed(filmUsed);
				if (filmSizeUsed != 0) {
					MasStoreItem masStoreItem = new MasStoreItem();
					masStoreItem.setId(filmSizeUsed);
					dgResultEntryDetail.setItem(masStoreItem);
				}
			}
			parameterMap.put("dgResultEntryDetail", dgResultEntryDetail);
			parameterMap.put("sampleDetailId", sampleDetailId);
			parameterMap.put("itemId", filmSizeUsed);
			parameterMap.put("filmUsed", filmUsed);
			//Upload Documents
			
			
			
			
			map = investigationHandlerService
					.submitResultEntryForTemplate(parameterMap);
			saved = (Boolean) map.get("saved");
			if (saved == true) {
				if(hinId_OPD != 0)
				{
					messageTOBeVisibleToTheUser = "Result Entry and Validated Successfully !! Do You Want To print The Result?";
				}
				else
				{
					messageTOBeVisibleToTheUser = "Result Entry done Successfully !! Do You Want To print The Result?";
				}
				
			} else {
				messageTOBeVisibleToTheUser = "Some Problem Occured !!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String url = "";
		url = "/hms/hms/investigation?method=searchPatient";
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("url", url);
		map.put("resultType", resultType);
		map.put("hinId_OPD", hinId_OPD);
		map.put("resultNo", resultNo);
		map.put("sampleCollectionId", sampleCollectionId);
		map.put("newSampleCollectionId", newSampleCollectionId);
		String jsp = MESSAGE_FOR_RESULT_ENTRY + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/** end of method of submit result entry for template * */

	/** new method of next functionality* */
	public ModelAndView nextForResultValidation(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in nextForResultValidation");
		Map<String, Object> detailMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		Box box = null;
		String hinNo = "";

		String pType = "";
		String patientFName = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String adNo = "";
		String orderType = "";
		int hinId = 0;
		int deptId = 0;
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		box = (Box) session.getAttribute("box");
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		mapForDs.put("deptId", deptId);
		if (box.get(FROM_DATE) != null && !(box.get(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(box.get(FROM_DATE));
			mapForDs.put("fromDate", fromDate);
		}
		if (box.get(TO_DATE) != null && !(box.get(TO_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(box.get(TO_DATE));
			mapForDs.put("toDate", toDate);
		}
		if (box.getInt(SUB_CHARGECODE_ID) != 0) {
			subChargeCodeId = box.getInt(SUB_CHARGECODE_ID);
			mapForDs.put("subChargeCodeId", subChargeCodeId);
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
		if (box.getInt(SAMPLE_ID) != 0) {
			sampleId = box.getInt(SAMPLE_ID);
		}
		if (box.get(PATIENT_TYPE) != null
				&& !(box.get(PATIENT_TYPE).equals(""))) {
			orderType = box.get(PATIENT_TYPE);
			mapForDs.put("orderType", orderType);
		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientDetailsList = new ArrayList<DgResultEntryHeader>();
		patientMap = investigationHandlerService
				.getPatientDetailsForResultValidation(mapForDs);
		patientDetailsList = (List<DgResultEntryHeader>) patientMap
				.get("patientDetailsList");
		int resultId = 0;
		int newResultId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (request.getParameter(RESULT_ID) != null) {
			resultId = Integer.parseInt(request.getParameter(RESULT_ID));
		}
		if (patientDetailsList.size() > 0) {

			for (Iterator iterator = patientDetailsList.iterator(); iterator
					.hasNext();) {
				DgResultEntryHeader dgResultEntryHeader = (DgResultEntryHeader) iterator
						.next();
				newResultId = dgResultEntryHeader.getId();
				if (newResultId == resultId) {
					iterator.remove();
				}
			}
		}

		Map<String, Object> map = new HashMap<String, Object>();
		Set<DgResultEntryDetail> dgDetailSet = new HashSet<DgResultEntryDetail>();
		if (newResultId != 0) {
			map = investigationHandlerService.getResultEntryDetailsForNext(
					newResultId, deptId);
		}
		if (newResultId == 0) {
			jsp = "messageForNewResult" + ".jsp";
			messageTOBeVisibleToTheUser = "No Records Found.";
		} else if (patientDetailsList.size() > 0) {
			for (DgResultEntryHeader dgHeader : patientDetailsList) {
				dgDetailSet = dgHeader.getDgResultEntryDetails();
			}
			for (DgResultEntryDetail dgResEntry : dgDetailSet) {

				if (dgResEntry.getResultType().equals("s")) {
					jsp = DG_RESULT_VALIDATION_ENTRY_SINGLE_PARAMETER + ".jsp";
				} else if (dgResEntry.getResultType().equals("m")) {
					jsp = DG_RESULT_VALIDATION_MULTIPLE + ".jsp";
				} else if (dgResEntry.getResultType().equals("t")) {
					jsp = DG_RESULT_VALIDATION_ENTRY_TEMPLATE + ".jsp";
				} else if (dgResEntry.getResultType().equals("v")) {
					jsp = DG_RESULT_VALIDATION_ENTRY_SENSITIVITY + ".jsp";
				}
			}
		}
		map.put("newResultId", newResultId);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView nextForResultValidationLab(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in nextForResultValidationLab");
		Map<String, Object> detailMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		Box box = null;
		String hinNo = "";
		String pType = "";
		String patientFName = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String adNo = "";
		String orderType = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		int hinId = 0;
		int deptId = 0;
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();

		String nextCombinedValidationIds = "";
		String[] idsArray = new String[0];
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			mapForDs.put("deptId", deptId);
		}
		if (request.getParameter("nextCombinedValidationIds") != null) {
			nextCombinedValidationIds = request
					.getParameter("nextCombinedValidationIds");
			mapForDs.put("resultId", nextCombinedValidationIds);
		}
		if (!nextCombinedValidationIds.equals("")) {
			map = investigationHandlerService
					.getResultEntryDetailsLab(mapForDs);
			map.put("resultId", nextCombinedValidationIds);
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			if (map.get("resultList") != null) {
				resultList = (List<DgResultEntryHeader>) map.get("resultList");
			}
			jsp = RESULT_VALIDATION_ENTRY_SINGLE_PARAMETER_LAB + ".jsp";
		} else {
			jsp = "messageForNewResultValidation" + ".jsp";
			messageTOBeVisibleToTheUser = "No Records Found.";
		}
		map.put("resultId", nextCombinedValidationIds);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/** for update Normal Value Screen * */
	public ModelAndView updateNormalValue(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in updateNormalValue");
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String message = "";
		boolean dataUpdated = false;
		dataUpdated = investigationHandlerService.updateNormalValue(box);
		if (dataUpdated == false) {
			message = "Normal Value Updated Successfully !!";
		} else {
			message = "Normal Value Cant Be Updated !!";
		}
		url = "/hms/hms/investigation?method=showInvestigationJsp";
		jsp = "updateNormalValue";

		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/** for update fixed values * */
	public ModelAndView updateFixedValues(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in updateFixedValues");
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String message = "";
		boolean dataUpdated = false;
		dataUpdated = investigationHandlerService.updateFixedValues(box);
		if (dataUpdated == false) {
			message = "Fixed Value Updated Successfully !!";
		} else {
			message = "Fixed Value Cant Be Updated !!";
		}
		url = "/hms/hms/investigation?method=showInvestigationJsp";
		jsp = "updateFixedValue";

		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/**
	 * For updating reports received records
	 * 
	 */
	public ModelAndView updateReceivedDetails(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in updateReceivedDetails");
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String url = "";
		int resultId = 0;
		int dispatchedId = 0;
		int relationId = 0;
		String receivedBy = "";
		String messageTOBeVisibleToTheUser = "";
		resultId = Integer.parseInt(request.getParameter(RESULT_ID));
		if (request.getParameter(DISPATCHED_BY) != null
				&& (!request.getParameter(DISPATCHED_BY).equals("0"))) {
			dispatchedId = Integer
					.parseInt(request.getParameter(DISPATCHED_BY));
		}
		if (request.getParameter(RELATION_ID) != null
				&& (!request.getParameter(RELATION_ID).equals("0"))) {
			relationId = Integer.parseInt(request.getParameter(RELATION_ID));
		}
		if (request.getParameter(RECEIVED_FROM) != null) {
			receivedBy = request.getParameter(RECEIVED_FROM);
		}
		map = investigationHandlerService.getResultList(resultId);
		infoMap.put("box", box);
		infoMap.put("resultId", resultId);
		infoMap.put("dispatchedId", dispatchedId);
		infoMap.put("relationId", relationId);
		infoMap.put("receivedBy", receivedBy);
		boolean flag = false;
		try {
			flag = investigationHandlerService.updateReceivedDetails(infoMap);
			if (flag == false) {
				messageTOBeVisibleToTheUser = "Report Collection Details Entered..";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = MESSAGE_JSP + ".jsp";
		url = "/hms/hms/investigation?method=searchPatientForReportCollection";
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showResultOrderNoJsp(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in showResultOrderNoJsp");
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String deptName = "";
		String hinNo="";
		String adNo="";
		String patientType=null;
		String modality=null;
		int userId = 0;
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		 session = request.getSession();
		
		 if(null !=request.getParameter(RequestConstants.SUB_CHARGECODE_ID) && !request.getParameter(RequestConstants.SUB_CHARGECODE_ID).equals("") ){
			 modality= request.getParameter(RequestConstants.SUB_CHARGECODE_ID);
			 
		 }
		 if(null !=request.getParameter(RequestConstants.PATIENT_TYPE) && !request.getParameter(RequestConstants.PATIENT_TYPE).equals("") ){
			 patientType= request.getParameter(RequestConstants.PATIENT_TYPE);
			 
		 }
		 if(null !=request.getParameter("hinNo") && !request.getParameter("hinNo").equals("") ){
			 hinNo= request.getParameter("hinNo");
			 
		 }
		 if(null !=request.getParameter(RequestConstants.AD_NO) && !request.getParameter(RequestConstants.AD_NO).equals("") ){
			 adNo= request.getParameter(RequestConstants.AD_NO);
			 
		 }

		String pFirstName="";  
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if(null !=request.getParameter("pFirstName") && !request.getParameter("pFirstName").equals("") ){
			pFirstName= request.getParameter("pFirstName");
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
		
		String barcodetext="",fromDate="",toDate="";
		if (request.getParameter("barcodetext") != null
				&& !(request.getParameter("barcodetext")
						.equals(""))) {
			barcodetext =request.getParameter("barcodetext").trim();
			mapForDs.put("barcodetext", barcodetext);
		}
		if (request.getParameter("fromDate") != null) {
			fromDate =request.getParameter("fromDate");
		}
		if (request.getParameter("toDate") != null) {
			toDate =request.getParameter("toDate");
		}
		String fromAge=null;
		if (request.getParameter("fromAge") != null) {
			fromAge =request.getParameter("fromAge");
		}
		String toAge=null;
		if (request.getParameter("toAge") != null) {
			toAge =request.getParameter("toAge");
		}
		
		// added by amit das on 17-07-2017
		if (session.getAttribute("userId") != null) {
			userId = (int) session.getAttribute("userId");
		}
		String mobilNo =null;
		if (request.getParameter("mobilNo") != null) {
			mobilNo =request.getParameter("mobilNo");
		}
		
	
		String wardName =null;
		if (request.getParameter(RequestConstants.WARD_NAME) != null) {
			wardName =request.getParameter(RequestConstants.WARD_NAME);
		}
		
		
		mapForDs.put("fromDate", fromDate);
		mapForDs.put("toDate", toDate);
		mapForDs.put("hospitalId", hospitalId);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("hinNo", hinNo);
		dataMap.put("adNo", adNo);
		mapForDs.put("patientFName", pFirstName);
		mapForDs.put("fromAge", fromAge);
		mapForDs.put("toAge", toAge);
		mapForDs.put("hinNo", hinNo);
		mapForDs.put("adNo", adNo);
		mapForDs.put(RequestConstants.MOBILE_NO, mobilNo);
		mapForDs.put(RequestConstants.AD_NO, adNo);
		mapForDs.put(RequestConstants.WARD_NAME, wardName);
		
		
		
		dataMap.put("userId", userId);
		patientMap = investigationHandlerService
				.getPatientDetailsForResultValidationOrderNo(mapForDs);
		
		 List<DgResultEntryHeader> patientListResult = new ArrayList<DgResultEntryHeader>();
		 if (patientMap.get("patientListResult") != null) {
			 patientListResult = (List<DgResultEntryHeader>) patientMap.get("patientListResult");
			}

		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailsList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailsList");
		}
		detailsMap = investigationHandlerService
				.getDetailsForResultValidation(dataMap);
		
		String jsp = DG_PENDING_RESULT_VALIDATION_ORDER_NO;
		jsp += ".jsp";
		
		patientMap.put("patientListResult", patientListResult);
		patientMap.put("patientList", patientList);
		
		detailsMap.put("userId", userId);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("pFirstName", pFirstName);
		map.put("barcodetext", barcodetext);
		map.put("deptName", deptName);
		map.put("fromDate",fromDate);
		map.put("toDate",toDate);
		map.put("hinNo", hinNo);
		map.put("fromAge",fromAge);
		map.put("toAge", toAge);
		map.put(RequestConstants.MOBILE_NO, mobilNo);
		map.put(RequestConstants.AD_NO, adNo);
		map.put(RequestConstants.WARD_NAME, wardName);
		map.put(RequestConstants.PATIENT_TYPE, patientType);
		map.put(RequestConstants.SUB_CHARGECODE_ID, modality);
		
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showResultOrderNoJspForQC(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in showResultOrderNoJspForQC");
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String deptName = "";
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
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
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		mapForDs.put("fromDate", new Date());
		mapForDs.put("toDate", new Date());
		mapForDs.put("hospitalId", hospitalId);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		patientMap = investigationHandlerService
				.getPatientDetailsForResultValidationOrderNo(mapForDs);
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailsList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailsList");
		}
		detailsMap = investigationHandlerService
				.getDetailsForResultValidation(dataMap);
		String jsp =RequestConstants.DG_PENDING_RESULT_VALIDATION_ORDER_NO_FOR_QC;
		jsp += ".jsp";
		patientMap.put("patientList", patientList);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForResultValidationOrderNo(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in searchPatientForResultValidationOrderNo");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String hinNo = "";
		int chargeCodeId = 0;
		String pType = "";
		String patientFName = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String adNo = "";
		String orderType = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		int hinId = 0;
		int resultId = 0;
		int deptId = 0;
		int hospitalId = 0;
		String mobileNo = "";
		String wardName = "";
		String userName = "";
		String orderNo = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
			mapForDs.put("hospitalId", hospitalId);
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
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
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
			if (request.getParameter(SAMPLE_ID) != null
					&& !(request.getParameter(SAMPLE_ID).equals("0"))) {
				sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				pType = request.getParameter(PATIENT_TYPE);
				mapForDs.put(PATIENT_TYPE, pType);
			}
			if (request.getParameter(RESULT_ID) != null
					&& !(request.getParameter(RESULT_ID).equals("0"))) {
				resultId = Integer.parseInt(request.getParameter(RESULT_ID));
				mapForDs.put("resultId", resultId);
			}
			if (request.getParameter(ORDER_NO) != null
					&& !(request.getParameter(ORDER_NO).equals(""))) {
				orderNo = request.getParameter(ORDER_NO);
				mapForDs.put("orderNo", orderNo);
			}
			if (request.getParameter(MOBILE_NO) != null
					&& !(request.getParameter(MOBILE_NO).equals(""))) {
				mobileNo = request.getParameter(MOBILE_NO);
				mapForDs.put(MOBILE_NO, mobileNo);
			}
			if (request.getParameter(WARD_NAME) != null
					&& !(request.getParameter(WARD_NAME).equals(""))) {
				wardName = request.getParameter(WARD_NAME);
				mapForDs.put(WARD_NAME, wardName);
			}
			mapForDs.put("deptId", deptId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * patientMap = investigationHandlerService
		 * .getPatientDetailsForResultValidationOrderNo(mapForDs);
		 */
		patientMap = investigationHandlerService
				.getPatientDetailsForResultPrinting(mapForDs);
		String jsp = "";
		int id = 0;
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailsList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailsList");
		}
		detailsMap = investigationHandlerService
				.getDetailsForResultValidation(dataMap);
		jsp = DG_PENDING_RESULT_VALIDATION_ORDER_NO + ".jsp";

		patientMap.put("patientList", patientList);

		map.put("patientDetailsList", patientMap.get("patientDetailsList"));
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("id", id);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForResultValidationOrderNoForQC(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in searchPatientForResultValidationOrderNoForQC");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String hinNo = "";
		int chargeCodeId = 0;
		String pType = "";
		String patientFName = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String adNo = "";
		String orderType = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		int hinId = 0;
		int resultId = 0;
		int deptId = 0;
		int hospitalId = 0;
		String mobileNo = "";
		String wardName = "";
		String userName = "";
		String orderNo = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
			mapForDs.put("hospitalId", hospitalId);
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
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
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
			if (request.getParameter(SAMPLE_ID) != null
					&& !(request.getParameter(SAMPLE_ID).equals("0"))) {
				sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				pType = request.getParameter(PATIENT_TYPE);
				mapForDs.put(PATIENT_TYPE, pType);
			}
			if (request.getParameter(RESULT_ID) != null
					&& !(request.getParameter(RESULT_ID).equals("0"))) {
				resultId = Integer.parseInt(request.getParameter(RESULT_ID));
				mapForDs.put("resultId", resultId);
			}
			if (request.getParameter(ORDER_NO) != null
					&& !(request.getParameter(ORDER_NO).equals(""))) {
				orderNo = request.getParameter(ORDER_NO);
				mapForDs.put("orderNo", orderNo);
			}
			if (request.getParameter(MOBILE_NO) != null
					&& !(request.getParameter(MOBILE_NO).equals(""))) {
				mobileNo = request.getParameter(MOBILE_NO);
				mapForDs.put(MOBILE_NO, mobileNo);
			}
			if (request.getParameter(WARD_NAME) != null
					&& !(request.getParameter(WARD_NAME).equals(""))) {
				wardName = request.getParameter(WARD_NAME);
				mapForDs.put(WARD_NAME, wardName);
			}
			mapForDs.put("deptId", deptId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * patientMap = investigationHandlerService
		 * .getPatientDetailsForResultValidationOrderNo(mapForDs);
		 */
		patientMap = investigationHandlerService
				.getPatientDetailsForResultPrinting(mapForDs);
		String jsp = "";
		int id = 0;
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailsList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailsList");
		}
		detailsMap = investigationHandlerService
				.getDetailsForResultValidation(dataMap);
		jsp =RequestConstants.DG_PENDING_RESULT_VALIDATION_ORDER_NO_FOR_QC + ".jsp";

		patientMap.put("patientList", patientList);

		map.put("patientDetailsList", patientMap.get("patientDetailsList"));
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("id", id);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitResultValidationForSingleParameterOrderNo(
			HttpServletRequest request, HttpServletResponse response) {
        logger.info("in submitResultValidationForSingleParameterOrderNo");
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String url = "";
		int resultId = 0;
		int resultValidatedBy = 0;
		String messageTOBeVisibleToTheUser = "";
		resultId = Integer.parseInt(request.getParameter(RESULT_ID));
		if (request.getParameter(RESULT_VALIDATED_BY) != null
				&& !request.getParameter(RESULT_VALIDATED_BY).equals("")) {
			resultValidatedBy = Integer.parseInt(request
					.getParameter(RESULT_VALIDATED_BY));
		}
		map = investigationHandlerService.getResultList(resultId);
		infoMap.put("box", box);

		infoMap.put("resultId", resultId);
		infoMap.put("resultValidatedBy", resultValidatedBy);
		boolean flag = false;
		try {
			flag = investigationHandlerService
					.submitResultValidationForSingleParameter(infoMap);
			if (flag == false) {
				messageTOBeVisibleToTheUser = "Successfully Validated the result!! Do you want to print?";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured !!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = MESSAGE_FOR_RESULT_ORDER_NO_JSP + ".jsp";
		url = "/hms/hms/investigation?method=searchPatientForResultValidationOrderNo";
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitResultValidationOrderNo(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in submitResultValidationOrderNo");
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		String url = "";
		int deptId = 0;
		int resultId = 0;
		int resultValidatedBy = 0;
		int newResultId = 0;
		resultId = Integer.parseInt(request.getParameter(RESULT_ID));
		List<DgResultEntryHeader> list = new ArrayList<DgResultEntryHeader>();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		String listType = "";
		if (!(session.getAttribute("listType").equals(""))) {
			listType = session.getAttribute("listType").toString();
			if (listType.equals("currentTypeList")) {
				list = (List<DgResultEntryHeader>) session
						.getAttribute("ResultValidationList");
			} else if (listType.equals("searchTypeList")) {
				list = (List<DgResultEntryHeader>) session
						.getAttribute("patientList");
			}
			if (list.size() > 0) {
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					DgResultEntryHeader dgResultEntryHeader = (DgResultEntryHeader) iterator
							.next();
					newResultId = dgResultEntryHeader.getId();
					if (newResultId == resultId) {
						iterator.remove();
					}
				}
			}
		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		if (newResultId != 0) {
			map = investigationHandlerService.getResultEntryDetailsForNext(
					newResultId, deptId);
		}

		if (request.getParameter(RESULT_VALIDATED_BY) != null
				&& !request.getParameter(RESULT_VALIDATED_BY).equals("")) {
			resultValidatedBy = Integer.parseInt(request
					.getParameter(RESULT_VALIDATED_BY));
		}
		map = investigationHandlerService.getResultList(resultId);
		infoMap.put("box", box);

		infoMap.put("resultId", resultId);
		infoMap.put("resultValidatedBy", resultValidatedBy);
		boolean flag = false;
		try {
			flag = investigationHandlerService
					.submitResultValidationForMultiple(infoMap);

			if (flag == false) {
				messageTOBeVisibleToTheUser = "Successfully Validated The Result. Do You want to Print. ";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsp = MESSAGE_FOR_RESULT_ORDER_NO_JSP + ".jsp";
		url = "/hms/hms/investigation?method=searchPatientForResultValidationOrderNo";
		map.put("url", url);
		map.put("resultId", resultId);
		map.put("newResultId", newResultId);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitResultValidationForTemplateOrderNo(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in submitResultValidationForTemplateOrderNo");
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		String url = "";
		int resultId = 0;
		int resultValidatedBy = 0;
		resultId = Integer.parseInt(request.getParameter(RESULT_ID));
		if (request.getParameter(RESULT_VALIDATED_BY) != null
				&& !request.getParameter(RESULT_VALIDATED_BY).equals("")) {
			resultValidatedBy = Integer.parseInt(request
					.getParameter(RESULT_VALIDATED_BY));
		}
		map = investigationHandlerService.getResultList(resultId);
		infoMap.put("box", box);
		String jsp = MESSAGE_FOR_RESULT_ORDER_NO_JSP + ".jsp";
		infoMap.put("resultId", resultId);
		map.put("resultValidatedBy", resultValidatedBy);
		boolean flag = false;
		try {
			flag = investigationHandlerService
					.submitResultValidationForTemplate(infoMap);

			if (flag == false) {
				messageTOBeVisibleToTheUser = "Successfully Validated the result!! Do you want to print.";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured !!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		url = "/hms/hms/investigation?method=searchPatientForResultValidationOrderNo";
		map.put("resultId", resultId);
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/** Report printing method */

	public ModelAndView printResultEntryReport(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in printResultEntryReport");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String resultNo = "";
		String resultType = "";
		session = request.getSession();

		if (request.getParameter(RESULT_NO) != null) {
			resultNo = request.getParameter(RESULT_NO);
		}
		if (request.getParameter(RESULT_TYPE) != null) {
			resultType = request.getParameter(RESULT_TYPE);
		}
		detailsMap = investigationHandlerService.getConnectionForReport();
		parameters.put("resultNo", resultNo);
		parameters.put("resultType", resultType);
		parameters.put("dept_id", session.getAttribute("deptId"));
		try {
			if (resultType.equalsIgnoreCase("s")) {
				HMSUtil.generateReport("inv_Result_Single", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (resultType.equalsIgnoreCase("m")) {
				HMSUtil.generateReport("inv_Result_Mul", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (resultType.equalsIgnoreCase("t")) {
				HMSUtil.generateReport("inv_Result_Tem", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ==========================Result Entry Report
	// Print======================================
	/*
	 * public ModelAndView printResultValidation(HttpServletRequest request,
	 * HttpServletResponse response){ Map<String, Object> requestParameters =
	 * new HashMap<String, Object>(); String query = "" ; int srn = 0; String
	 * src = ""; int id = 0; String crit = ""; try{
	 * if(request.getParameter("counta") != null){ srn =
	 * Integer.parseInt(request.getParameter("counta")); } src = ("chk");
	 * if((request.getParameter(src) != null) &&
	 * !(request.getParameter(src).equals("0"))){
	 * 
	 * query =
	 * "where dg_orderhd.`order_no` = '"+(request.getParameter(src))+"'";
	 * 
	 * requestParameters.put("QUERY",query);
	 * 
	 * Map<String, Object> connectionMap =
	 * investigationHandlerService.getConnectionForReport();
	 * HMSUtil.generateReport(DG_RESULT_SINGLE, requestParameters,
	 * (Connection)connectionMap.get("conn"), response, getServletContext()); }
	 * //} } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * return null; }
	 */
	// -----------------in controller...
	// ==========================Result Entry Report
	// Print======================================
	public ModelAndView printResultValidation(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in printResultValidation");
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		String query = "";
		int srn = 0;
		String src = "";
		int id = 0;
		String crit = "";
		String deptName = "";
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}

		try {
			if (request.getParameter("counta") != null) {
				srn = Integer.parseInt(request.getParameter("counta"));
			}

			// for(id = 0; id < srn; id++){ //for loop start
			src = ("parent");
			if ((request.getParameter(src) != null)
					&& !(request.getParameter(src).equals("0"))) {
				requestParameters.put("orderNo", request.getParameter(src));
				query = "where dg_orderhd.order_no = '"
						+ (request.getParameter(src)) + "'";

map = investigationHandlerService
						.getAllValidatedTestForOrder(requestParameters);
/*			
				dgResultdetailList = (List<DgResultEntryDetail>) detailsMap1.get("resultList");
				System.out.println(dgResultdetailList.size()+"---------dgResultdetailListdgResultdetailList");
				map.put("dgResultdetailList", dgResultdetailList);
				map.put("detailsMap1", detailsMap1);*/
				map.put("deptName", deptName);

				/*
				 * //Made Commented requestParameters.put("SUBREPORT_DIR",
				 * getServletContext().getRealPath("/reports/"));
				 * requestParameters.put("QUERY",query);
				 * 
				 * 
				 * Map<String, Object> connectionMap =
				 * investigationHandlerService.getConnectionForReport();
				 * HMSUtil.generateReport(DG_RESULT_SINGLE, requestParameters,
				 * (Connection)connectionMap.get("conn"), response,
				 * getServletContext());
				 */
			}
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("finalResultPrintForRadio", "map", map);
	}

	public synchronized ModelAndView printResultValidationLab(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in printResultValidationLab");
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
		session = request.getSession();
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if(session.getAttribute(HOSPITAL_ID)!=null){
			requestParameters.put(HOSPITAL_ID, Integer.parseInt(""+session.getAttribute(HOSPITAL_ID)));
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap=hospitalDetailsMasterHandlerService.getHospitalList(requestParameters);
		 //dataMap = getHospitalParameterDetails(request);
		 List<MasHospital> masHospitalList=(List<MasHospital>)dataMap.get("masHospitalList");
		 if(masHospitalList.size()>0){
			 map.put("hospitalAddress", (String) masHospitalList.get(0).getAddress());
			 map.put("hospitalName", (String) masHospitalList.get(0).getHospitalName());
			  
		 }  

		try {
			if (request.getParameter("counta") != null) {
				srn = Integer.parseInt(request.getParameter("counta"));
			}
			src = ("parent");
			if ((request.getParameter(src) != null)
					&& !(request.getParameter(src).equals(""))) {
				requestParameters.put("orderNo", request.getParameter(src));
				detailsMap1 = investigationHandlerService
						.getAllValidatedTestForLabOrderNoWise(requestParameters);

				map.put("detailsMap1", detailsMap1);
				map.put("deptName", deptName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("finalResultPrintForLab", "map", map);
	}

	// -------------Jasper Compiled Report
	// --------------------------------------
	private JasperReport getCompiledReport(String fileName) throws JRException {
		logger.info("in getCompiledReport");
		File reportFile = new File(getServletContext().getRealPath(
				"/Reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile);

		return jasperReport;
	}

	/** NEW METHOD FOR RESULT ENTRY NEXT PATIENT SCREEN * */

	public ModelAndView nextForResultEntry(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in nextForResultEntry");
		Map<String, Object> detailMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		Box box = null;
		String hinNo = "";
		String patientFName = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String orderType = "";
		String orderStatus = "";
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		int hinId = 0;
		int inpatientId = 0;
		Map<String, Object> diagMap = new HashMap<String, Object>();
		String resultSeqNo = "";
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		int deptId = 0;
		box = (Box) session.getAttribute("box");
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		mapForDs.put("deptId", deptId);

		if (box.get(HIN_NO) != null && !(box.get(HIN_NO).equals(""))) {
			hinNo = box.get(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}
		if (box.getInt(INPATIENT_ID) != 0) {
			inpatientId = box.getInt(INPATIENT_ID);
			mapForDs.put("inpatientId", inpatientId);
		}
		if (box.get(FROM_DATE) != null && !(box.get(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(box.get(FROM_DATE));
			mapForDs.put("fromDate", fromDate);
		}
		if (box.get(TO_DATE) != null && !(box.get(TO_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(box.get(TO_DATE));
			mapForDs.put("toDate", toDate);
		}
		if (box.get(ORDER_STATUS) != null
				&& !(box.get(ORDER_STATUS).equals(""))) {
			orderStatus = box.get(ORDER_STATUS);
			mapForDs.put("orderStatus", orderStatus);
		}
		if (box.getInt(SUB_CHARGECODE_ID) != 0) {
			subChargeCodeId = box.getInt(SUB_CHARGECODE_ID);
			mapForDs.put("subChargeCodeId", subChargeCodeId);
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
		if (box.getInt(SAMPLE_ID) != 0) {
			sampleId = box.getInt(SAMPLE_ID);
		}
		if (box.get(PATIENT_TYPE) != null
				&& !(box.get(PATIENT_TYPE).equals(""))) {
			orderType = box.get(PATIENT_TYPE);
			mapForDs.put("orderType", orderType);
		}
		int sampleCollectionDetailId = 0;
		if (box.getInt(SAMPLE_COLLECTION_DETAIL_ID) != 0) {
			sampleCollectionDetailId = box.getInt(SAMPLE_COLLECTION_DETAIL_ID);
			mapForDs.put("sampleCollectionDetailId", sampleCollectionDetailId);
		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<DgSampleCollectionDetails> patientDetailsList = new ArrayList<DgSampleCollectionDetails>();
		patientMap = investigationHandlerService.getPatientDetails(mapForDs);
		patientDetailsList = (List<DgSampleCollectionDetails>) patientMap
				.get("patientDetailsList");
		int sampleCollectionId = 0;
		int newSampleCollectionId = 0;
		if (request.getParameter(DG_SAMPLE_DETAIL_ID) != null) {
			sampleCollectionId = Integer.parseInt(request
					.getParameter(DG_SAMPLE_DETAIL_ID));
		}
		if (patientDetailsList.size() > 0) {

			for (Iterator iterator = patientDetailsList.iterator(); iterator
					.hasNext();) {
				DgSampleCollectionDetails dgSampleDetail = (DgSampleCollectionDetails) iterator
						.next();
				newSampleCollectionId = dgSampleDetail.getId();
				if (newSampleCollectionId == sampleCollectionId) {
					iterator.remove();
				}
			}
		}

		resultSeqNo = investigationHandlerService.generateResultNumber(diagMap);

		Map<String, Object> map = new HashMap<String, Object>();
		Set<DgResultEntryDetail> dgDetailSet = new HashSet<DgResultEntryDetail>();
		if (newSampleCollectionId != 0) {
			map = investigationHandlerService.getResultEntryForNext(
					newSampleCollectionId, deptId);
		}
		if (newSampleCollectionId == 0) {
			jsp = "messageForNewresultEntry" + ".jsp";
			messageTOBeVisibleToTheUser = "No Records Found.";
		} else if (patientDetailsList.size() > 0) {
			for (DgSampleCollectionDetails dgDet : patientDetailsList) {
				if (dgDet.getInvestigation().getInvestigationType()
						.equalsIgnoreCase("s")) {
					jsp = DG_RESULT_ENTRY_SINGLE_PARAMETER_WITH_NORMAL_VALUE
							+ ".jsp";
				} else if (dgDet.getInvestigation().getInvestigationType()
						.equalsIgnoreCase("m")) {
					jsp = DG_RESULT_ENTRY_MULTIPLE_PARAMETER + ".jsp";
				} else if (dgDet.getInvestigation().getInvestigationType()
						.equalsIgnoreCase("t")) {
					jsp = DG_RESULT_ENTRY_TEMPLATE + ".jsp";
				}
			}
		}
		if (resultSeqNo != "") {
			map.put("resultSeqNo", resultSeqNo);
		}
		map.put("newSampleCollectionId", newSampleCollectionId);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/** print report for result validation * */
	/** print report for result validation * */
	/** print report for result validation * */
	public synchronized ModelAndView printResultValidationReport(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in printResultValidationReport");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();

		int srn = 0;
		String src = "";
		int id = 0;
		String crit = "";
		String deptName = "";
		int deptId = 0;
		String resultNo = "";
		String resultType = "";

		session = request.getSession();

		/*
		 * if (request.getParameter(RESULT_NO) != null) { resultNo =
		 * request.getParameter(RESULT_NO); }
		 */
		if (request.getParameter(RESULT_TYPE) != null) {
			resultType = request.getParameter(RESULT_TYPE);
		}

		/*
		 * if (session.getAttribute("deptId") != null) { deptId =
		 * Integer.parseInt("" + session.getAttribute("deptId")); }
		 */

		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		try {
			if (request.getParameter("counta") != null) {
				srn = Integer.parseInt(request.getParameter("counta"));
			}
			src = ("parent");
			if ((request.getParameter(src) != null)
					&& !(request.getParameter(src).equals(""))) {
				resultNo = request.getParameter(src);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		Integer hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		//Map<String, Object> requestParameters = new HashMap<String, Object>();
		requestParameters.put("orderNo", resultNo);
		
		requestParameters = investigationHandlerService
				.getAllValidatedTestForLabOrderNoWise(requestParameters);
		String verifiedPersonName="";
		String entryPersonName="";
		String entryPersonNameDesignation="";
		String verifiedPersonNameDesignation="";
		if (requestParameters.get("verifiedPersonName") != null) {
					verifiedPersonName = (String)requestParameters.get("verifiedPersonName");
					
		}if (requestParameters.get("entryPersonName") != null) {
					entryPersonName = (String)requestParameters.get("entryPersonName");

		}
		if (requestParameters.get("entryPersonNameDesignation") != null
						&& !requestParameters.get("entryPersonNameDesignation").equals("")) {
					entryPersonNameDesignation = (String)requestParameters.get("entryPersonNameDesignation");

		}
		if (requestParameters.get("verifiedPersonNameDesignation") != null) {
					verifiedPersonNameDesignation = (String)requestParameters.get("verifiedPersonNameDesignation");

		}
		detailsMap = investigationHandlerService.getConnectionForReport();
		parameters.put("verifiedPersonName", verifiedPersonName);
		parameters.put("entryPersonName", entryPersonName);
		parameters.put("entryPersonNameDesignation", entryPersonNameDesignation);
		parameters.put("verifiedPersonNameDesignation", verifiedPersonNameDesignation);
		parameters.put("order_no", Integer.parseInt(resultNo));
		parameters.put("hospital_id", hospitalId);
		parameters.put("resultType", resultType);
		parameters.put("dept_id", deptId);
		HMSUtil.generateReport("print_report", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		/*
		 * try { if (resultType.equalsIgnoreCase("s")) {
		 * 
		 * HMSUtil.generateReport("inv_Result_Single_val", parameters,
		 * (Connection) detailsMap.get("conn"), response, getServletContext());
		 * } else if (resultType.equalsIgnoreCase("m")) {
		 * HMSUtil.generateReport("inv_Result_Mul_val", parameters, (Connection)
		 * detailsMap.get("conn"), response, getServletContext()); } else if
		 * (resultType.equalsIgnoreCase("t")) {
		 * HMSUtil.generateReport("inv_Result_Tem_val", parameters, (Connection)
		 * detailsMap.get("conn"), response, getServletContext()); }
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */
		return null;
	}

	// -------------------------------Start Methods
	// developed--------------------------------------

	public ModelAndView getOrganismList(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in getOrganismList");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String orGroupId = "";
		if (request.getParameter("orGroupId") != null) {
			orGroupId = (request.getParameter("orGroupId"));
			dataMap.put("orGroupId", orGroupId);
		}
		map = investigationHandlerService.getOrganismList(dataMap);
		String jsp = ORGANISM_RESPONCE_JSP;
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getResultOrganismList(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in getResultOrganismList");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int resultId = 0;
		if (request.getParameter("resultId") != null) {
			resultId = new Integer(request.getParameter("resultId"));
			dataMap.put("resultId", resultId);
		}
		map = investigationHandlerService.getResultOrganismList(dataMap);
		String jsp = "resultValidationOrganism";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getSensitivityList(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in getSensitivityList");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String orIds = "";
		if (request.getParameter("orIds") != null) {
			orIds = request.getParameter("orIds");
			dataMap.put("orIds", orIds);
		}
		map = investigationHandlerService.getSensitivityList(dataMap);
		String jsp = SENSITIVITY_RESPONCE_JSP;
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getResultSensitivityList(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in getResultSensitivityList");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int resultId = 0;
		if (request.getParameter("resultId") != null) {
			resultId = new Integer(request.getParameter("resultId"));
			dataMap.put("resultId", resultId);
		}
		map = investigationHandlerService.getResultSensitivityList(dataMap);
		String jsp = "resultValidationSenstivity";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView saveSensitivity(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in saveSensitivity");
		// Map<String, Object> dataMap = new HashMap<String, Object>();
		// map = investigationHandlerService.saveSensitivity(dataMap);
		// return new ModelAndView(jsp, "map", map);

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		boolean saved = false;
		int hospitalId = 0;
		Users users = null;
		String userName = "";
		String messageTOBeVisibleToTheUser = "";
		String resultNo = "";
		String CombinedIds = "";
		HttpSession session = request.getSession();
		int sampleCollectionId = 0;
		int newSampleCollectionId = 0;
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		sampleCollectionId = Integer.parseInt(request
				.getParameter(DG_SAMPLE_DETAIL_ID));
		Map<String, Object> patientMap = new HashMap<String, Object>();
		if (newSampleCollectionId != 0) {
			map = investigationHandlerService.getResultEntryForNext(
					newSampleCollectionId, deptId);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(USERS) != null) {
			users = (Users) session.getAttribute(USERS);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			parameterMap.put("userName", userName);
		}
		if (request.getParameter(RESULT_NO) != null) {
			resultNo = request.getParameter(RESULT_NO);
		}
		if (request.getParameter("CombinedIds") != null) {
			CombinedIds = request.getParameter("CombinedIds");
		}

		String remarks = "";
		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
		}
		String testOrderNoSensitive = "";
		if (request.getParameter(TEST_ORDER_NO_SENSITIVE_VALUE) != null) {
			testOrderNoSensitive = request
					.getParameter(TEST_ORDER_NO_SENSITIVE_VALUE);
		}

		int subchargeId = 0;
		int mainChargeId = 0;

		int hinId = 0;
		int inpatientId = 0;
		int employeeId = 0;
		int resultEnteredId = 0;
		int departId = 0;
		int investigationId = 0;

		if (request.getParameter(MAIN_CHARGECODE_ID) != null) {
			mainChargeId = Integer.valueOf(request
					.getParameter(MAIN_CHARGECODE_ID));
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departId = Integer.valueOf(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(SUB_CHARGECODE_ID) != null) {
			subchargeId = Integer.valueOf(request
					.getParameter(SUB_CHARGECODE_ID));
		}
		if (request.getParameter(HIN_ID) != null) {
			hinId = Integer.valueOf(request.getParameter(HIN_ID));
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& !(request.getParameter(INPATIENT_ID).equals(""))) {
			inpatientId = Integer.valueOf(request.getParameter(INPATIENT_ID));
		}
		if (request.getParameter(SAMPLE_COLLECTION_ID) != null) {
			sampleCollectionId = Integer.valueOf(request
					.getParameter(SAMPLE_COLLECTION_ID));
		}
		if (!(request.getParameter(EMPLOYEE_ID).equals(""))
				&& request.getParameter(EMPLOYEE_ID) != null) {
			employeeId = Integer.valueOf(request.getParameter(EMPLOYEE_ID));

		}
		if (!(request.getParameter(RESULT_ENTERED_BY).equals(""))
				&& request.getParameter(RESULT_ENTERED_BY) != null) {
			resultEnteredId = Integer.valueOf(request
					.getParameter(RESULT_ENTERED_BY));
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		DgResultEntryHeader dgResultEntryHeader = new DgResultEntryHeader();
		dgResultEntryHeader.setResultNo(resultNo);
		dgResultEntryHeader.setLastChgdBy(users);
		dgResultEntryHeader.setLastChgdDate(date);
		dgResultEntryHeader.setLastChgdTime(time);
		dgResultEntryHeader.setRemarks(remarks);
		dgResultEntryHeader.setResultDate(date);
		dgResultEntryHeader.setResultStatus("P");
		dgResultEntryHeader.setResultTime(time);

		/*
		 * if(testOrderNoSensitive != null && !testOrderNoSensitive.equals("")){
		 * dgResultEntryHeader
		 * .setTestOrderNo(Integer.parseInt(testOrderNoSensitive)); }
		 */
		dgResultEntryHeader.setResultType("v");
		MasMainChargecode masMainChargecode = new MasMainChargecode();
		masMainChargecode.setId(mainChargeId);
		dgResultEntryHeader.setMainChargecode(masMainChargecode);

		MasSubChargecode masSubChargecode = new MasSubChargecode();
		masSubChargecode.setId(subchargeId);
		dgResultEntryHeader.setSubChargecode(masSubChargecode);

		DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
		dgSampleCollectionHeader.setId(sampleCollectionId);
		dgResultEntryHeader.setSampleCollectionHeader(dgSampleCollectionHeader);

		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departId);
		dgResultEntryHeader.setDepartment(masDepartment);

		MasHospital masHospital = new MasHospital();
		masHospital.setId(1);
		dgResultEntryHeader.setHospital(masHospital);
		Patient patient = new Patient();
		patient.setId(hinId);
		dgResultEntryHeader.setHin(patient);
		if (inpatientId != 0) {
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			dgResultEntryHeader.setInpatient(inpatient);
		}
		if (employeeId != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			dgResultEntryHeader.setEmployee(masEmployee);
		}
		if (resultEnteredId != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(resultEnteredId);
			dgResultEntryHeader.setEmployee(masEmployee);
		}
		if (request.getParameter(INVESTIGATION_ID) != null
				&& (!request.getParameter(INVESTIGATION_ID).equals("0"))) {
			investigationId = Integer.parseInt(request
					.getParameter(INVESTIGATION_ID));
			DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
			dgMasInvestigation.setId(investigationId);
			dgResultEntryHeader.setInvestigation(dgMasInvestigation);

		}

		parameterMap.put("dgResultEntryHeader", dgResultEntryHeader);
		String result = "";
		String additionalRemarks = "";
		int sample_Id = 0;

		int uomId = 0;
		String resultType = "";
		String sensitivity = "";
		int sampleDetailId = 0;

		String growthOption = "";
		if (request.getParameter("screenSens") != null) {
			growthOption = request.getParameter("screenSens");
			parameterMap.put("growthOption", growthOption);
		}
		if (request.getParameter(RESULT_TYPE) != null) {
			resultType = request.getParameter(RESULT_TYPE);
			parameterMap.put("resultType", resultType);
		}
		if (request.getParameter("result") != null) {
			result = request.getParameter("result");
			parameterMap.put("result", result);
		}

		String result2 = "";
		if (request.getParameter("result2") != null) {
			result2 = request.getParameter("result2");
			parameterMap.put("result2", result2);
		}
		String result1 = "";
		if (request.getParameter("result1") != null) {
			result1 = request.getParameter("result1");
			parameterMap.put("result1", result1);
		}
		String nosoc = "";
		if (request.getParameter("NOSOCOMIAL") != null) {
			nosoc = request.getParameter("NOSOCOMIAL");
			parameterMap.put("nosoc", nosoc);
		}
		if (request.getParameter(ADDITIONAL_REMARKS) != null) {
			additionalRemarks = request.getParameter(ADDITIONAL_REMARKS);
			parameterMap.put("additionalRemarks", additionalRemarks);
		}

		if (request.getParameter(INVESTIGATION_ID) != null
				&& (!request.getParameter(INVESTIGATION_ID).equals("0"))) {
			investigationId = Integer.parseInt(request
					.getParameter(INVESTIGATION_ID));
			parameterMap.put("investigationId", investigationId);
		}

		if (request.getParameter(DG_SAMPLE_DETAIL_ID) != null
				&& (!request.getParameter(DG_SAMPLE_DETAIL_ID).equals(""))) {
			sampleDetailId = Integer.parseInt(request
					.getParameter(DG_SAMPLE_DETAIL_ID));
			parameterMap.put("sampleDetailId", sampleDetailId);

		}
		if (request.getParameter("noOfSensitivity") != null) {

			Integer sq = new Integer(request.getParameter("noOfSensitivity"));
			String[] senArray = new String[sq];
			for (int ilop = 0; ilop < sq; ilop++) {
				if (request.getParameter("chkBoxSensitive" + (ilop + 1)) != null
						&& !request
								.getParameter("chkBoxSensitive" + (ilop + 1))
								.equals("")) {
					senArray[ilop] = (String) request
							.getParameter("chkBoxSensitive" + (ilop + 1));

				}
			}
			parameterMap.put("senArray", senArray);
			String[] resArray = new String[sq];
			for (int ilop = 0; ilop < sq; ilop++) {
				if (request.getParameter("res" + (ilop + 1)) != null
						&& !request.getParameter("res" + (ilop + 1)).equals("")) {
					resArray[ilop] = (String) request.getParameter("res"
							+ (ilop + 1));
				}
			}
			parameterMap.put("resArray", resArray);
		}
		map = investigationHandlerService.saveSensitivity(parameterMap);
		saved = (Boolean) map.get("saved");
		if (saved == false) {
			messageTOBeVisibleToTheUser = "Result Entry done Successfully.Do You Want To print The Result.";
		} else {
			messageTOBeVisibleToTheUser = "Some Problem Occured.";
		}

		/*
		 * 
		 * String url=""; url="/hms/hms/investigation?method=searchPatient";
		 * map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		 * map.put("url", url); map.put("result", result); map.put("result2",
		 * result2); map.put("resultNo", resultNo); map.put("resultType",
		 * resultType); map.put("sampleCollectionId", sampleCollectionId);
		 * map.put("newSampleCollectionId", newSampleCollectionId); String jsp =
		 * MESSAGE_FOR_RESULT_ENTRY+".jsp";
		 */

		int dgSampleHeaderId = 0;
		int subChargeId = 0;
		String[] idsArray = new String[0];
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();

		mapForDs.put("deptId", deptId);
		if (!CombinedIds.equals("")) {

			idsArray = CombinedIds.split(",");
			dgSampleHeaderId = Integer.parseInt(idsArray[0]);
			mapForDs.put("dgSampleHeaderId", dgSampleHeaderId);

			subChargeId = Integer.parseInt(idsArray[1]);
			mapForDs.put("subChargeId", subChargeId);

		}

		if (!CombinedIds.equals("")) {
			// //////////////////////////////////////////////////////
			map = investigationHandlerService
					.getSampleCollectionDetailsForLab(mapForDs);

			// /////////////////////////////////////////////////////
			// map =
			// investigationHandlerService.getSampleCollectionDetails(sampleCollectionDetailId,
			// deptId);

			List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
			if (map.get("sampleCollectionList") != null) {
				sampleCollectionList = (List<DgSampleCollectionDetails>) map
						.get("sampleCollectionList");
			}
			if (sampleCollectionList.size() > 0) {
				jsp = RESULT_ENTRY_SINGLE_PARAMETER_LAB + ".jsp";
				List<String> resultSeqNoList = new ArrayList<String>();
				for (int i = 0; i < sampleCollectionList.size(); i++) {
					String resultSeqNo = "";
					resultSeqNo = investigationHandlerService
							.generateResultNumberForLab(diagMap);
					resultSeqNoList.add(resultSeqNo);
				}

				if (resultSeqNoList.size() > 0) {
					map.put("resultSeqNoList", resultSeqNoList);
				}
				map.put("CombinedIds", CombinedIds);
			} else {
				String nextCombinedIds = "";
				if (!CombinedIds.equals("")) {
					String[] idArrString = new String[0];
					idArrString = CombinedIds.split(",");

					int subChargeIdTemp = Integer.parseInt(idArrString[1]);

					List<String> combinedListAll = new ArrayList<String>();
					combinedListAll = (List<String>) session
							.getAttribute("combinedListAll");

					if (combinedListAll.size() > 0) {
						combinedListAll.remove(CombinedIds);
					}
					for (String combinedIdsFromList : combinedListAll) {
						String[] idArray = new String[0];
						idArray = combinedIdsFromList.split(",");

						int subChargeIdFromList = Integer.parseInt(idArray[1]);
						if (subChargeIdFromList == subChargeIdTemp) {
							nextCombinedIds = combinedIdsFromList;
							break;
						}
					}
				}

				String url = "";
				url = "/hms/hms/investigation?method=searchPatientByBackButtonLab";
				map.put("messageTOBeVisibleToTheUser",
						messageTOBeVisibleToTheUser);
				map.put("url", url);

				map.put("nextCombinedIds", nextCombinedIds);
				map.put("CombinedIds", CombinedIds);
				map.put("newSampleCollectionId", newSampleCollectionId);
				map.put("sampleCollectionId", sampleCollectionId);
				jsp = MESSAGE_FOR_RESULT_ENTRY_LAB + ".jsp";

			}
		}

		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitResultValidationForSensitivity(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in submitResultValidationForSensitivity");
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		boolean saved = false;
		int hospitalId = 0;
		String userName = "";
		String messageTOBeVisibleToTheUser = "";
		String resultNo = "";
		String resultIdStringForTemplate = "";
		HttpSession session = request.getSession();
		int sampleCollectionId = 0;
		int newSampleCollectionId = 0;
		int deptId = 0;
		int resultId = 0;
		int sampleDetailId = 0;
		int investigationId = 0;
		int resultValidatedBy = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		resultId = Integer.parseInt(request.getParameter(RESULT_ID));
		if (request.getParameter(RESULT_VALIDATED_BY) != null
				&& !request.getParameter(RESULT_VALIDATED_BY).equals("")) {
			resultValidatedBy = Integer.parseInt(request
					.getParameter(RESULT_VALIDATED_BY));
		}
		if (request.getParameter(INVESTIGATION_ID) != null
				&& !request.getParameter(INVESTIGATION_ID).equals("")) {
			investigationId = Integer.parseInt(request
					.getParameter(INVESTIGATION_ID));
			infoMap.put("investigationId", investigationId);
		}
		if (request.getParameter(SAMPLE_COLLECTION_DETAIL_ID) != null
				&& !request.getParameter(SAMPLE_COLLECTION_DETAIL_ID)
						.equals("")) {
			sampleDetailId = Integer.parseInt(request
					.getParameter(SAMPLE_COLLECTION_DETAIL_ID));
			infoMap.put("sampleDetailId", sampleDetailId);
		}

		infoMap.put("box", box);
		String remarks = "";

		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
		}
		infoMap.put("remarks", remarks);

		String result1 = "";
		if (request.getParameter("result1") != null) {
			result1 = request.getParameter("result1");
		}
		infoMap.put("result1", result1);
		String result2 = "";
		if (request.getParameter("result2") != null) {
			result2 = request.getParameter("result2");
		}
		infoMap.put("result2", result2);

		String growthOption = "";
		if (request.getParameter("growthOption") != null) {
			growthOption = (String) request.getParameter("growthOption");

		}
		if (request.getParameter("resultIdStringForTemplate") != null) {
			resultIdStringForTemplate = (String) request
					.getParameter("resultIdStringForTemplate");

		}

		String nosoc = "";
		if (request.getParameter("NOSOCOMIAL") != null) {
			nosoc = request.getParameter("NOSOCOMIAL");
			infoMap.put("nosoc", nosoc);
		}
		infoMap.put("growthOption", growthOption);
		infoMap.put("resultId", resultId);
		infoMap.put("resultValidatedBy", resultValidatedBy);
		if (request.getParameter("noOfSensitivity") != null) {

			Integer sq = new Integer(request.getParameter("noOfSensitivity"));
			String[] senArray = new String[sq];
			for (int ilop = 0; ilop < sq; ilop++) {
				if (request.getParameter("chkBoxSensitive" + (ilop + 1)) != null
						&& !request
								.getParameter("chkBoxSensitive" + (ilop + 1))
								.equals("")) {
					senArray[ilop] = request.getParameter("chkBoxSensitive"
							+ (ilop + 1));

				}
			}
			infoMap.put("senArray", senArray);
			String[] resArray = new String[sq];
			for (int ilop = 0; ilop < sq; ilop++) {
				if (request.getParameter("res" + (ilop + 1)) != null
						&& !request.getParameter("res" + (ilop + 1)).equals("")) {
					resArray[ilop] = (String) request.getParameter("res"
							+ (ilop + 1));
				}
			}
			infoMap.put("resArray", resArray);
		}
		/*
		 * if (request.getParameter("noOfOrg") != null) { Integer sq=new
		 * Integer(request.getParameter("noOfOrg")); Integer [] grpArray= new
		 * Integer[sq]; for(int ilop=0;ilop<sq;ilop++) { if
		 * (request.getParameter("OrganismGpName"+(ilop+1)) != null &&
		 * !request.getParameter("OrganismGpName"+(ilop+1)).equals("")) {
		 * grpArray[ilop] = new
		 * Integer(request.getParameter("OrganismGpName"+(ilop+1))); } }
		 * infoMap.put("grpArray",grpArray);
		 * 
		 * Integer [] orgArray= new Integer[sq]; for(int ilop=0;ilop<sq;ilop++)
		 * { if (request.getParameter("OrganismName"+(ilop+1)) != null &&
		 * !request.getParameter("OrganismName"+(ilop+1)).equals("")) {
		 * orgArray[ilop] = new
		 * Integer(request.getParameter("OrganismName"+(ilop+1))); } }
		 * infoMap.put("orgArray",orgArray);
		 * 
		 * Integer [] senArray= new Integer[sq]; for(int ilop=0;ilop<sq;ilop++)
		 * { if (request.getParameter("antibioId"+(ilop+1)) != null &&
		 * !request.getParameter("antibioId"+(ilop+1)).equals("")) {
		 * senArray[ilop] = new
		 * Integer(request.getParameter("antibioId"+(ilop+1))); } }
		 * infoMap.put("senArray",senArray);
		 * 
		 * String [] resArray= new String[sq]; for(int ilop=0;ilop<sq;ilop++) {
		 * if (request.getParameter("sensitivityResult"+(ilop+1)) != null &&
		 * !request.getParameter("sensitivityResult"+(ilop+1)).equals("")) {
		 * resArray[ilop]
		 * =(String)request.getParameter("sensitivityResult"+(ilop+1)); } }
		 * infoMap.put("resArray",resArray); }ssas
		 */
		boolean flag = false;
		try {
			flag = investigationHandlerService
					.submitResultValidationForSensitivity(infoMap);
			if (flag == false) {
				messageTOBeVisibleToTheUser = "Successfully Validated the result.Do you want to print.";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();

		dataMap.put("deptId", deptId);
		dataMap.put("resultId", resultIdStringForTemplate);

		if (!resultIdStringForTemplate.equals("")) {
			map = investigationHandlerService.getResultEntryDetailsLab(dataMap);
			map.put("resultId", resultIdStringForTemplate);
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			if (map.get("resultList") != null) {
				resultList = (List<DgResultEntryHeader>) map.get("resultList");
				if (resultList.size() > 0) {
					jsp = RESULT_VALIDATION_ENTRY_SINGLE_PARAMETER_LAB + ".jsp";
				} else {
					String nextCombinedValidationIds = "";
					if (!resultIdStringForTemplate.equals("")) {
						String[] idArrString = new String[0];
						idArrString = resultIdStringForTemplate.split("@");

						int subChargeId = Integer.parseInt(idArrString[1]);

						List<String> pendingValidationListLabAll = new ArrayList<String>();
						pendingValidationListLabAll = (List<String>) session
								.getAttribute("pendingValidationListLabAll");

						if (pendingValidationListLabAll.size() > 0) {
							pendingValidationListLabAll
									.remove(resultIdStringForTemplate);
						}
						for (String combinedIdsFromList : pendingValidationListLabAll) {
							String[] idArray = new String[0];
							idArray = combinedIdsFromList.split("@");

							int subChargeIdFromList = Integer
									.parseInt(idArray[1]);
							if (subChargeIdFromList == subChargeId) {
								nextCombinedValidationIds = combinedIdsFromList;
								break;
							}
						}
					}

					map.put("nextCombinedValidationIds",
							nextCombinedValidationIds);
					jsp = MESSAGE_FOR_RESULT_VALIDATION_LAB + ".jsp";
				}
			}
		}
		map.put("resultIdStringForTemplate", resultIdStringForTemplate);

		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public boolean saveDatabaseContentToTheServerPath(int chargeCodeId)
			throws FileNotFoundException, IllegalStateException {
		logger.info("in saveDatabaseContentToTheServerPath");
		boolean flag = false;
		List<DgTemplate> templateList = investigationHandlerService
				.getTemplateList(chargeCodeId);

		File temprory = new File(getServletContext().getRealPath(
				"/temp/" + "temp.html"));

		FileOutputStream fos = new FileOutputStream(getServletContext()
				.getRealPath("/temp/" + "temp.html"));
		try {
			fos.write(templateList.get(0).getResult());
			flag = true;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return flag;

	}

	public ModelAndView showPendingResultEntryLabJsp(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in showPendingResultEntryLabJsp");
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		int userId = 0;
		String deptName = "";
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

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		// added by amit das on 17-07-2017
				if (session.getAttribute("userId") != null) {
					userId = (int) session.getAttribute("userId");
				}
		
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		dataMap.put("userId",userId);
		
		detailsMap = investigationHandlerService.getDetailsForSearch(dataMap);
		patientMap = investigationHandlerService.getResultGridLab(mapForDs);
		String jsp = PENDING_RESULT_ENTRY_LAB;
		jsp += ".jsp";
		
		detailsMap.put("userId", userId);
		
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("hinNo", "");
		map.put("pFirstName", "");	
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showPendingResultEntryLabJspForEmpanelled(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in showPendingResultEntryLabJspForEmpanelled");
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
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

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		detailsMap = investigationHandlerService.getDetailsForSearch(dataMap);
		patientMap = investigationHandlerService.getResultGridLabForEmpanelled(mapForDs);
		String jsp = "pendingResultEntryLabForEmpanelled";
		jsp += ".jsp";
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showPendingResultEntryLabJspForQC(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in showPendingResultEntryLabJspForQC");
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
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

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		detailsMap = investigationHandlerService.getDetailsForSearch(dataMap);
		patientMap = investigationHandlerService.getResultGridLab(mapForDs);
		String jsp =RequestConstants.PENDING_RESULT_ENTRY_LAB_FOR_QC;
		jsp += ".jsp";
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPatientForLab(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {
		logger.info("in searchPatientForLab");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String patientFName = "";
		String orderStatus = "";
		String adNo = "";
		String hinNo = "";
		String orderType = "";
		String flag = "";
		String CombinedIds = "";
		String[] idsArray = new String[0];
		String diagnosisNo = "";
		String userName = "";
		String appendedHtml = "";
		String deptName = "";

		int departmentId = 0;
		int inpatientId = 0;
		int subChargeCodeId = 0;
		int hinId = 0;
		int sampleCollectionDetailId = 0;
		int dgSampleHeaderId = 0;
		int subChargeId = 0;
		int hospitalId = 0;
		int deptId = 0;
		String billNo = "";
		String mobileNo = "";
		String wardName = "";
		Integer barCode = 0;
		int userId = 0;
		int dgSampleDetailsId = 0;
		String fromDates="",toDates="";
		int sampleId=0;
		String modalityStr = null;
		int modalityId= 0;
/*		System.out.println(""+);
*/		session = request.getSession();
		Box box = HMSUtil.getBox(request);

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
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}	
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		
		try {
			String[] investigationList =null;
			ArrayList<String> invList=new ArrayList<String>();
			 
			if (request.getParameterValues("invName")!=null &&!request.getParameterValues("invName").equals("0")) {
				
				investigationList = request.getParameterValues("invName");
				for(String s:investigationList){
					invList.add(s);
				}
				
			}
			
			List<Integer>invFinalList=new ArrayList<Integer>();
			for(String inv:invList){
				invFinalList.add(Integer.parseInt(inv));
			}
			mapForDs.put("invFinalList",invFinalList);
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))
					&& !(request.getParameter(INPATIENT_ID).equals(""))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
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
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
			}
			if (request.getParameter(DIAGNOSIS_NO) != null
					&& !(request.getParameter(DIAGNOSIS_NO).equals(""))) {
				diagnosisNo = request.getParameter(DIAGNOSIS_NO);
				mapForDs.put("diagnosisNo", diagnosisNo);
			}

			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
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
			if (request.getParameter(ORDER_STATUS) != null
					&& !(request.getParameter(ORDER_STATUS).equals("0"))) {
				orderStatus = request.getParameter(ORDER_STATUS);
				mapForDs.put("orderStatus", orderStatus);
			}
			if (request.getParameter(SAMPLE_COLLECTION_DETAIL_ID) != null
					&& !(request.getParameter(SAMPLE_COLLECTION_DETAIL_ID)
							.equals("0"))) {
				CombinedIds = request.getParameter(SAMPLE_COLLECTION_DETAIL_ID);
				mapForDs.put("sampleCollectionDetailId",
						sampleCollectionDetailId);
			}
			
			if (request.getParameter("dgSampleDetailsId") != null
					&& !(request.getParameter("dgSampleDetailsId").trim()
							.equals(""))) {
				dgSampleDetailsId = Integer.parseInt(request.getParameter("dgSampleDetailsId"));
				mapForDs.put("dgSampleDetailsId",
						dgSampleDetailsId);
			}
			
			if (request.getParameter(BILL_NO) != null
					&& !(request.getParameter(BILL_NO).equals(""))) {
				billNo = request.getParameter(BILL_NO);
				mapForDs.put("billNo", billNo);
			}
			if (request.getParameter(MOBILE_NO) != null
					&& !(request.getParameter(MOBILE_NO).equals(""))) {
				mobileNo = request.getParameter(MOBILE_NO);
				mapForDs.put(MOBILE_NO, mobileNo);
			}
			if (request.getParameter(WARD_NAME) != null
					&& !(request.getParameter(WARD_NAME).equals(""))) {
				wardName = request.getParameter(WARD_NAME);
				mapForDs.put(WARD_NAME, wardName);
			}
			if (request.getParameter(RequestConstants.BARCODE) != null
					&& !(request.getParameter(RequestConstants.BARCODE)
							.equals(""))) {
				barCode = Integer.parseInt(request
						.getParameter(RequestConstants.BARCODE));
				mapForDs.put(RequestConstants.BARCODE, barCode);
			}
			if(request.getParameter("sampleName")!=null && !request.getParameter("sampleName").equals("0")){
				sampleId=Integer.parseInt(request.getParameter("sampleName"));
				mapForDs.put("sampleId", sampleId);
			}
			
			modalityStr = request.getParameter("modalityId");
			if(modalityStr!=null && !modalityStr.equals("")){
				modalityId = Integer.parseInt(modalityStr);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> diagMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();

		String jsp = "";
		if (!CombinedIds.equals("")) {

			idsArray = CombinedIds.split(",");
			
			if(idsArray.length>1){ // added by amit das on 20-06-2016
			dgSampleHeaderId = Integer.parseInt(idsArray[0]);
			mapForDs.put("dgSampleHeaderId", dgSampleHeaderId);

			subChargeId = Integer.parseInt(idsArray[1]);
			mapForDs.put("subChargeId", subChargeId);
			}
		}

		if (!CombinedIds.equals("") || dgSampleDetailsId!=0) {
			map = investigationHandlerService
					.getSampleCollectionDetailsForLab(mapForDs);
			// /////////////////////////////////////////////////////
			// map =
			// investigationHandlerService.getSampleCollectionDetails(sampleCollectionDetailId,
			// deptId);

			List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
			if (map.get("sampleCollectionList") != null) {
				sampleCollectionList = (List<DgSampleCollectionDetails>) map
						.get("sampleCollectionList");
			}
			if (sampleCollectionList.size() > 0) {
				if(dgSampleDetailsId==0){
					jsp = RESULT_ENTRY_SINGLE_PARAMETER_LAB + ".jsp";
				}else{
					jsp = RESULT_ENTRY_SINGLE_PARAMETER_LAB;
				}
				List<String> resultSeqNoList = new ArrayList<String>();
				for (int i = 0; i < sampleCollectionList.size(); i++) {
					String resultSeqNo = "";
					resultSeqNo = investigationHandlerService
							.generateResultNumberForLab(diagMap);
					resultSeqNoList.add(resultSeqNo);
				}
				if (resultSeqNoList.size() > 0) {
					map.put("resultSeqNoList", resultSeqNoList);
				}
				map.put("CombinedIds", CombinedIds);
			}
		} else {
			/*
			 * if(session.getAttribute("boxForResultEntry") != null){
			 * session.removeAttribute("boxForResultEntry");
			 * session.setAttribute("boxForResultEntry",box); }else{
			 * session.setAttribute("boxForResultEntry",box); }
			 */
			String barcodetext="";
			if (request.getParameter("barcodetext") != null
					&& !(request.getParameter("barcodetext")
							.equals(""))) {
				barcodetext =request.getParameter("barcodetext").trim();
				mapForDs.put("barcodetext", barcodetext);
			}
			String sampleIdSearch=null;
			
			if (request.getParameter("sampleId") != null
				&& !(request.getParameter("sampleId")
						.equals(""))) {
			sampleIdSearch =request.getParameter("sampleId").trim();
			mapForDs.put("sampleIdSearch", sampleIdSearch);
		}
			
			patientMap = investigationHandlerService
					.getPatientDetailsForLab(mapForDs);
			if (patientMap.get("patientDetailsList") != null) {
				patientList = (List<Patient>) patientMap
						.get("patientDetailsList");

			}
			detailsMap = investigationHandlerService
					.getDetailsForSearch(dataMap);
			List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
			if (null !=detailsMap.get("subChargeCodeList") ) {
				 subChargeCodeList=(List<MasSubChargecode>) detailsMap.get("subChargeCodeList");
			}
			//added by govind 02-06-2017 for result entry search slow
			String search="Y";
			if(request.getParameter("search")!=null){
				search=request.getParameter("search");
			}
			dataMap.put("search", search);
			detailsMap = investigationHandlerService.getDetailsForLab(dataMap);
			detailsMap.put("subChargeCodeList", subChargeCodeList);
			
			map.put("pFirstName", patientFName);
			map.put("barcodetext", barcodetext);
			map.put("deptName", deptName);
			map.put("fromDate",fromDates);
			map.put("toDate",toDates);
			map.put("hinNo", hinNo);
			map.put("sampleIdSearch", sampleIdSearch);
			map.put("subGroupId", subChargeCodeId);
			
			detailsMap.put("currentLabId", subChargeCodeId);
			detailsMap.put("userId",userId);
			
			if(dgSampleDetailsId==0)
				jsp = PENDING_RESULT_ENTRY_LAB + ".jsp";
			else
				jsp = PENDING_RESULT_ENTRY_LAB;
		}
		int hinId_OPD = box.getInt("hinId_OPD");
		String RequisitionFrom ="NA";
		RequisitionFrom = box.getString("RequisitionFrom");
		
		if(hinId_OPD != 0)
		{
			map.put("hinId_OPD", hinId_OPD);
			map.put("RequisitionFrom", RequisitionFrom);
		}
		else
		{
			map.put("hinId_OPD", hinId_OPD);
			map.put("RequisitionFrom", "NA");
		}
		
		patientMap.put("patientList", patientList);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		
		map.put("contentJsp", jsp);
	
		map.put("dataMap", dataMap);
		map.put("deptName", deptName);
		
		map.put("appendedHtml", appendedHtml);
		map.put("modalityId", modalityId);
		ModelAndView modelAndView = null;
		if(dgSampleDetailsId!=0){
			map.put("forOutSideLab", "Y");
			modelAndView = new ModelAndView(jsp, "map", map);
		}else{
			modelAndView =	new ModelAndView("index", "map", map);
		}
		
		return modelAndView;
	}
	
	public ModelAndView searchPatientForLabForEmpanelled(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {
		logger.info("in searchPatientForLabForEmpanelled");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String patientFName = "";
		String orderStatus = "";
		String adNo = "";
		String hinNo = "";
		String orderType = "";
		String flag = "";
		String CombinedIds = "";
		String[] idsArray = new String[0];
		String diagnosisNo = "";
		String userName = "";
		String appendedHtml = "";
		String deptName = "";

		int departmentId = 0;
		int inpatientId = 0;
		int subChargeCodeId = 0;
		int hinId = 0;
		int sampleCollectionDetailId = 0;
		int dgSampleHeaderId = 0;
		int subChargeId = 0;
		int hospitalId = 0;
		int deptId = 0;
		String billNo = "";
		String mobileNo = "";
		String wardName = "";
		Integer barCode = 0;
		int sampleId=0;
/*		System.out.println(""+);
*/		session = request.getSession();
		Box box = HMSUtil.getBox(request);

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
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		
		

		try {
			String[] investigationList =null;
			ArrayList<String> invList=new ArrayList<String>();
			 
			if (request.getParameterValues("invName")!=null &&!request.getParameterValues("invName").equals("0")) {
				
				investigationList = request.getParameterValues("invName");
				for(String s:investigationList){
					invList.add(s);
				}
				
			}
			
			List<Integer>invFinalList=new ArrayList<Integer>();
			for(String inv:invList){
				invFinalList.add(Integer.parseInt(inv));
			}
			mapForDs.put("invFinalList",invFinalList);
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))
					&& !(request.getParameter(INPATIENT_ID).equals(""))) {
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
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
			}
			if (request.getParameter(DIAGNOSIS_NO) != null
					&& !(request.getParameter(DIAGNOSIS_NO).equals(""))) {
				diagnosisNo = request.getParameter(DIAGNOSIS_NO);
				mapForDs.put("diagnosisNo", diagnosisNo);
			}

			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
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
			if (request.getParameter(ORDER_STATUS) != null
					&& !(request.getParameter(ORDER_STATUS).equals("0"))) {
				orderStatus = request.getParameter(ORDER_STATUS);
				mapForDs.put("orderStatus", orderStatus);
			}
			if (request.getParameter(SAMPLE_COLLECTION_DETAIL_ID) != null
					&& !(request.getParameter(SAMPLE_COLLECTION_DETAIL_ID)
							.equals("0"))) {
				CombinedIds = request.getParameter(SAMPLE_COLLECTION_DETAIL_ID);
				mapForDs.put("sampleCollectionDetailId",
						sampleCollectionDetailId);
			}
			if (request.getParameter(BILL_NO) != null
					&& !(request.getParameter(BILL_NO).equals(""))) {
				billNo = request.getParameter(BILL_NO);
				mapForDs.put("billNo", billNo);
			}
			if (request.getParameter(MOBILE_NO) != null
					&& !(request.getParameter(MOBILE_NO).equals(""))) {
				mobileNo = request.getParameter(MOBILE_NO);
				mapForDs.put(MOBILE_NO, mobileNo);
			}
			if (request.getParameter(WARD_NAME) != null
					&& !(request.getParameter(WARD_NAME).equals(""))) {
				wardName = request.getParameter(WARD_NAME);
				mapForDs.put(WARD_NAME, wardName);
			}
			if (request.getParameter(RequestConstants.BARCODE) != null
					&& !(request.getParameter(RequestConstants.BARCODE)
							.equals(""))) {
				barCode = Integer.parseInt(request
						.getParameter(RequestConstants.BARCODE));
				mapForDs.put(RequestConstants.BARCODE, barCode);
			}
			if(request.getParameter("sampleName")!=null && !request.getParameter("sampleName").equals("0")){
				sampleId=Integer.parseInt(request.getParameter("sampleName"));
				mapForDs.put("sampleId", sampleId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> diagMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();

		String jsp = "";
		if (!CombinedIds.equals("")) {

			idsArray = CombinedIds.split(",");
			dgSampleHeaderId = Integer.parseInt(idsArray[0]);
			mapForDs.put("dgSampleHeaderId", dgSampleHeaderId);

			subChargeId = Integer.parseInt(idsArray[1]);
			mapForDs.put("subChargeId", subChargeId);
		}

		if (!CombinedIds.equals("")) {
			map = investigationHandlerService
					.getSampleCollectionDetailsForLabForEmpanelled(mapForDs);
			// /////////////////////////////////////////////////////
			// map =
			// investigationHandlerService.getSampleCollectionDetails(sampleCollectionDetailId,
			// deptId);

			List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
			if (map.get("sampleCollectionList") != null) {
				sampleCollectionList = (List<DgSampleCollectionDetails>) map
						.get("sampleCollectionList");
			}
			if (sampleCollectionList.size() > 0) {
				jsp = "resultEntryForSingleParameterLabForEmpanelled" + ".jsp";
				List<String> resultSeqNoList = new ArrayList<String>();
				for (int i = 0; i < sampleCollectionList.size(); i++) {
					String resultSeqNo = "";
					resultSeqNo = investigationHandlerService
							.generateResultNumberForLab(diagMap);
					resultSeqNoList.add(resultSeqNo);
				}
				if (resultSeqNoList.size() > 0) {
					map.put("resultSeqNoList", resultSeqNoList);
				}
				map.put("CombinedIds", CombinedIds);
			}
		} else {
			/*
			 * if(session.getAttribute("boxForResultEntry") != null){
			 * session.removeAttribute("boxForResultEntry");
			 * session.setAttribute("boxForResultEntry",box); }else{
			 * session.setAttribute("boxForResultEntry",box); }
			 */
			patientMap = investigationHandlerService
					.getPatientDetailsForLabForEmpanelled(mapForDs);
			if (patientMap.get("patientDetailsList") != null) {
				patientList = (List<Patient>) patientMap
						.get("patientDetailsList");

			}
			detailsMap = investigationHandlerService
					.getDetailsForSearch(dataMap);
			detailsMap = investigationHandlerService.getDetailsForLab(dataMap);
			jsp = "pendingResultEntryLabForEmpanelled" + ".jsp";
		}
		int hinId_OPD = box.getInt("hinId_OPD");
		String RequisitionFrom ="NA";
		RequisitionFrom = box.getString("RequisitionFrom");
		
		if(hinId_OPD != 0)
		{
			map.put("hinId_OPD", hinId_OPD);
			map.put("RequisitionFrom", RequisitionFrom);
		}
		else
		{
			map.put("hinId_OPD", hinId_OPD);
			map.put("RequisitionFrom", "NA");
		}
		
		patientMap.put("patientList", patientList);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("dataMap", dataMap);
		map.put("deptName", deptName);
		map.put("appendedHtml", appendedHtml);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchPatientForLabForQC(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {
		logger.info("in searchPatientForLabForQC");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String patientFName = "";
		String orderStatus = "";
		String adNo = "";
		String hinNo = "";
		String orderType = "";
		String flag = "";
		String CombinedIds = "";
		String[] idsArray = new String[0];
		String diagnosisNo = "";
		String userName = "";
		String appendedHtml = "";
		String deptName = "";

		int departmentId = 0;
		int inpatientId = 0;
		int subChargeCodeId = 0;
		int hinId = 0;
		int sampleCollectionDetailId = 0;
		int dgSampleHeaderId = 0;
		int subChargeId = 0;
		int hospitalId = 0;
		int deptId = 0;
		String billNo = "";
		String mobileNo = "";
		String wardName = "";
		Integer barCode = 0;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);

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
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		try {

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))
					&& !(request.getParameter(INPATIENT_ID).equals(""))) {
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
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
			}
			if (request.getParameter(DIAGNOSIS_NO) != null
					&& !(request.getParameter(DIAGNOSIS_NO).equals(""))) {
				diagnosisNo = request.getParameter(DIAGNOSIS_NO);
				mapForDs.put("diagnosisNo", diagnosisNo);
			}

			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
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
			if (request.getParameter(ORDER_STATUS) != null
					&& !(request.getParameter(ORDER_STATUS).equals("0"))) {
				orderStatus = request.getParameter(ORDER_STATUS);
				mapForDs.put("orderStatus", orderStatus);
			}
			if (request.getParameter(SAMPLE_COLLECTION_DETAIL_ID) != null
					&& !(request.getParameter(SAMPLE_COLLECTION_DETAIL_ID)
							.equals("0"))) {
				CombinedIds = request.getParameter(SAMPLE_COLLECTION_DETAIL_ID);
				mapForDs.put("sampleCollectionDetailId",
						sampleCollectionDetailId);
			}
			if (request.getParameter(BILL_NO) != null
					&& !(request.getParameter(BILL_NO).equals(""))) {
				billNo = request.getParameter(BILL_NO);
				mapForDs.put("billNo", billNo);
			}
			if (request.getParameter(MOBILE_NO) != null
					&& !(request.getParameter(MOBILE_NO).equals(""))) {
				mobileNo = request.getParameter(MOBILE_NO);
				mapForDs.put(MOBILE_NO, mobileNo);
			}
			if (request.getParameter(WARD_NAME) != null
					&& !(request.getParameter(WARD_NAME).equals(""))) {
				wardName = request.getParameter(WARD_NAME);
				mapForDs.put(WARD_NAME, wardName);
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

		Map<String, Object> diagMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();

		String jsp = "";
		if (!CombinedIds.equals("")) {

			idsArray = CombinedIds.split(",");
			dgSampleHeaderId = Integer.parseInt(idsArray[0]);
			mapForDs.put("dgSampleHeaderId", dgSampleHeaderId);

			subChargeId = Integer.parseInt(idsArray[1]);
			mapForDs.put("subChargeId", subChargeId);
		}

		if (!CombinedIds.equals("")) {
			map = investigationHandlerService
					.getSampleCollectionDetailsForLab(mapForDs);
			// /////////////////////////////////////////////////////
			// map =
			// investigationHandlerService.getSampleCollectionDetails(sampleCollectionDetailId,
			// deptId);

			List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
			if (map.get("sampleCollectionList") != null) {
				sampleCollectionList = (List<DgSampleCollectionDetails>) map
						.get("sampleCollectionList");
			}
			if (sampleCollectionList.size() > 0) {
				//jsp=RESULT_ENTRY_SINGLE_PARAMETER_LAB+".jsp";
				jsp = RESULT_ENTRY_SINGLE_PARAMETER_LAB_FOR_QC + ".jsp";
				List<String> resultSeqNoList = new ArrayList<String>();
				for (int i = 0; i < sampleCollectionList.size(); i++) {
					String resultSeqNo = "";
					resultSeqNo = investigationHandlerService
							.generateResultNumberForLab(diagMap);
					resultSeqNoList.add(resultSeqNo);
				}
				if (resultSeqNoList.size() > 0) {
					map.put("resultSeqNoList", resultSeqNoList);
				}
				map.put("CombinedIds", CombinedIds);
			}
		} else {
			/*
			 * if(session.getAttribute("boxForResultEntry") != null){
			 * session.removeAttribute("boxForResultEntry");
			 * session.setAttribute("boxForResultEntry",box); }else{
			 * session.setAttribute("boxForResultEntry",box); }
			 */
			patientMap = investigationHandlerService
					.getPatientDetailsForLab(mapForDs);
			if (patientMap.get("patientDetailsList") != null) {
				patientList = (List<Patient>) patientMap
						.get("patientDetailsList");

			}
			detailsMap = investigationHandlerService
					.getDetailsForSearch(dataMap);
			detailsMap = investigationHandlerService.getDetailsForLab(dataMap);
			jsp =RequestConstants.PENDING_RESULT_ENTRY_LAB_FOR_QC + ".jsp";
		}
		patientMap.put("patientList", patientList);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("dataMap", dataMap);
		map.put("deptName", deptName);
		map.put("appendedHtml", appendedHtml);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPatientByBackButtonLab(
			HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, IllegalStateException {
		logger.info("in searchPatientByBackButtonLab");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String orderType = "";
		String flag = "";
		String CombinedIds = "";
		String[] idsArray = new String[0];
		String patientFName = "";
		String orderStatus = "";
		String adNo = "";
		String hinNo = "";
		String appendedHtml = "";
		String userName = "";
		String deptName = "";
		int departmentId = 0;
		int inpatientId = 0;
		int subChargeCodeId = 0;
		int hinId = 0;
		int sampleCollectionDetailId = 0;
		int sampleHeaderId = 0;
		int dgSampleHeaderId = 0;
		int subChargeId = 0;

		int userId = 0;
		int hospitalId = 0;
		int deptId = 0;
		session = request.getSession();
		Box box = null;

		/*
		 * if(session.getAttribute("boxForResultEntry") != null){ box =
		 * (Box)session.getAttribute("boxForResultEntry"); }
		 */

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
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		}
		try {
			if (box != null) {
				if (box.getString(HIN_NO) != null
						&& !(box.getString(HIN_NO).equals(""))) {
					hinNo = box.getString(HIN_NO);
					mapForDs.put("hinNo", hinNo);
				}
				if (box.getString(INPATIENT_ID) != null
						&& !(box.getString(INPATIENT_ID).equals("0"))
						&& !(box.getString(INPATIENT_ID).equals(""))) {
					inpatientId = Integer.parseInt(box.getString(INPATIENT_ID));
					mapForDs.put("inpatientId", inpatientId);
				}
				if (box.getString(FROM_DATE) != null
						&& !(box.getString(FROM_DATE).equals(""))) {
					fromDate = HMSUtil.dateFormatterDDMMYYYY(box
							.getString(FROM_DATE));
					mapForDs.put("fromDate", fromDate);
				}
				if (box.getString(TO_DATE) != null
						&& !(box.getString(TO_DATE).equals(""))) {
					toDate = HMSUtil.dateFormatterDDMMYYYY(box
							.getString(TO_DATE));
					mapForDs.put("toDate", toDate);
				}
				if (box.getString(PATIENT_TYPE) != null
						&& !(box.getString(PATIENT_TYPE).equals(""))) {
					orderType = box.getString(PATIENT_TYPE);
					mapForDs.put("orderType", orderType);
				}

				if (box.getString(SUB_CHARGECODE_ID) != null
						&& !(box.getString(SUB_CHARGECODE_ID).equals(""))
						&& !(box.getString(SUB_CHARGECODE_ID).equals("0"))) {
					subChargeCodeId = Integer.parseInt(box
							.getString(SUB_CHARGECODE_ID));
					mapForDs.put("subChargeCodeId", subChargeCodeId);
				}
				if (box.getString(P_FIRST_NAME) != null
						&& !(box.getString(P_FIRST_NAME).equals(""))) {
					patientFName = box.getString(P_FIRST_NAME);
					mapForDs.put("patientFName", patientFName);
				}
				if (box.getString(AD_NO) != null
						&& !(box.getString(AD_NO).equals(""))) {
					adNo = box.getString(AD_NO);
					mapForDs.put("adNo", adNo);
				}
				if (box.getString(DEPARTMENT_ID) != null
						&& !(box.getString(DEPARTMENT_ID).equals(""))
						&& !(box.getString(DEPARTMENT_ID).equals("0"))) {
					departmentId = Integer.parseInt(box
							.getString(DEPARTMENT_ID));
					mapForDs.put("departmentId", departmentId);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = investigationHandlerService
				.getPatientDetailsForLab(mapForDs);

		String jsp = "";
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailsList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailsList");
		}

		detailsMap = investigationHandlerService.getDetailsForLab(dataMap);
		jsp = PENDING_RESULT_ENTRY_LAB + ".jsp";

		patientMap.put("patientList", patientList);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("dataMap", dataMap);
		map.put("deptName", deptName);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPatientHistory(HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException,
			IOException {
		logger.info("in showPatientHistory");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		String resultNo = "";
		String resultType = "";
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		int userId = 0;

		int investigationId = 0;
		int hinId = 0;
		String backUrl="";
		String deptName = "";
		int resultIdForReport = 0;

		session = request.getSession();
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
				mapForDs.put("hospitalId", hospitalId);
			}
			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
				mapForDs.put("deptId", deptId);
			}
			if (session.getAttribute("deptName") != null) {
				deptName = (String) session.getAttribute("deptName");
				mapForDs.put("deptName", deptName);
			}
			if (session.getAttribute("userId") != null) {
				userId = Integer.parseInt("" + session.getAttribute("userId"));
				mapForDs.put("userId", userId);
			}
			if (request.getParameter("investigationIdSingleValueSingleTest") != null) {
				investigationId = Integer.parseInt(request
						.getParameter("investigationIdSingleValueSingleTest"));
				mapForDs.put("investigationId", investigationId);
			}
			if (request.getParameter(HIN_ID) != null) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if(request.getParameter("backUrl")!=null){
				backUrl=request.getParameter("backUrl");
			}

			Map<String, Object> detailsMap = new HashMap<String, Object>();
			List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();

			detailsMap = investigationHandlerService
					.getPatientHistory(mapForDs);
			jsp = "patientHistoryPrint";
			jsp = jsp + ".jsp";
			map.put("backUrl", backUrl);
			map.put("detailsMap", detailsMap);
			map.put("investigationId", investigationId);
			map.put("hinId", hinId);
			map.put("contentJsp", jsp);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPrintResultEntryForLab(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in showPrintResultEntryForLab");
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		Map<String, Object> resultDetailsMap = new HashMap<String, Object>();
		List<Map<String, Object>> resultDetailsMapList = new ArrayList<Map<String, Object>>();

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}

		HttpSession session = request.getSession();
		String[] idsArray = new String[0];
		String deptName = "";
		String jsp = "";
		String combinedIds = "";
		int deptId = 0;
		Integer dgSampleHeaderId = 0;
		Integer subChargeId = 0;

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (request.getParameter("combinedIds") != null) {
			combinedIds = request.getParameter("combinedIds");
			requestParameters.put("combinedIds", combinedIds);
		}
		if (!combinedIds.equals("")) {
			idsArray = combinedIds.split(",");

			dgSampleHeaderId = Integer.parseInt(idsArray[0]);
			requestParameters.put("dgSampleHeaderId", dgSampleHeaderId);
			subChargeId = Integer.parseInt(idsArray[1]);
			requestParameters.put("subChargeId", subChargeId);
		}
		requestParameters.put("resultStatus", "P");

		detailsMap1 = investigationHandlerService
				.getProvisionalReportDetailsOrderNoWiseLab(requestParameters);
		int hospitalId = 0;
		Map<String, Object> dataMap2 = new HashMap<String, Object>();
		List<MasSetupParameterMaintaince> masSetupParameterMaintainceList = new ArrayList<MasSetupParameterMaintaince>();
		if (session.getAttribute(HOSPITAL_ID) != null) { 
			dataMap2.put(HOSPITAL_ID, Integer.parseInt("" + session.getAttribute(HOSPITAL_ID)));
		}
		hospitalId = Integer.parseInt(request.getSession()
				.getAttribute(HOSPITAL_ID).toString());

		dataMap = hospitalDetailsMasterHandlerService
				.getHospitalList(dataMap2);
		 List<MasHospital> masHospitalList=(List<MasHospital>)dataMap.get("masHospitalList");
		 if(masHospitalList.size()>0){
			 map.put("hospitalAddress", (String) masHospitalList.get(0).getAddress());
			 map.put("hospitalName", (String) masHospitalList.get(0).getHospitalName());
			  
		 }
		
		/*if (dataMap.get("masSetupParameterMaintainceList") != null) {
			masSetupParameterMaintainceList = (List<MasSetupParameterMaintaince>) dataMap
					.get("masSetupParameterMaintainceList");
			map.put("hospitalName", masSetupParameterMaintainceList.get(0)
					.getHospital().getHospitalName());
			map.put("hospitalAddress", masSetupParameterMaintainceList.get(0)
					.getHospital().getAddress());
		}*/
		/*
		 * dataMap = getHospitalParameterDetails(request); if
		 * (dataMap.get("hospitalAddress") != null) { map.put("hospitalAddress",
		 * (String) dataMap.get("hospitalAddress")); } if
		 * (dataMap.get("hospitalName") != null) { map.put("hospitalName",
		 * (String) dataMap.get("hospitalName")); }
		 */
		detailsMap1.put("flagForConfidential", "y");
		map.put("detailsMap1", detailsMap1);
		map.put("deptName", deptName);
		return new ModelAndView(VIEW_RESULT_ENTRY_PRINT_ORDER_NO_WISE_LAB,
				"map", map);
	}

	public ModelAndView nextForResultEntryLab(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in nextForResultEntryLab");
		Map<String, Object> detailMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		Box box = null;
		String hinNo = "";
		String orderStatus = "";
		String orderType = "";
		String pType = "";
		String patientFName = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		int hinId = 0;
		int inpatientId = 0;

		Map<String, Object> diagMap = new HashMap<String, Object>();

		Map<String, Object> mapForDs = new HashMap<String, Object>();
		List<DgResultEntryDetail> dgResultEntryDetailListForResult = new ArrayList<DgResultEntryDetail>();
		int deptId = 0;
		Integer hospitalId = 0;
		String nextCombinedIds = "";
		String[] idsArray = new String[0];
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			mapForDs.put("deptId", deptId);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute(HOSPITAL_ID));
			mapForDs.put(HOSPITAL_ID, hospitalId);
		}

		if (request.getParameter("nextCombinedIds") != null) {
			nextCombinedIds = request.getParameter("nextCombinedIds");
		}

		if (!nextCombinedIds.equals("")) {
			idsArray = nextCombinedIds.split(",");
			int dgSampleHeaderId = Integer.parseInt(idsArray[0]);
			mapForDs.put("dgSampleHeaderId", dgSampleHeaderId);

			int subChargeId = Integer.parseInt(idsArray[1]);
			mapForDs.put("subChargeId", subChargeId);
			map = investigationHandlerService
					.getSampleCollectionDetailsForLab(mapForDs);

			List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
			if (map.get("sampleCollectionList") != null) {
				sampleCollectionList = (List<DgSampleCollectionDetails>) map
						.get("sampleCollectionList");
			}
			if (map.get("dgResultEntryDetailListForResult") != null) {
				dgResultEntryDetailListForResult = (List<DgResultEntryDetail>) map
						.get("dgResultEntryDetailListForResult");
			}
			if (sampleCollectionList.size() > 0) {
				jsp = RESULT_ENTRY_SINGLE_PARAMETER_LAB + ".jsp";
				List<String> resultSeqNoList = new ArrayList<String>();
				for (int i = 0; i < sampleCollectionList.size(); i++) {
					String resultSeqNo = "";
					resultSeqNo = investigationHandlerService
							.generateResultNumberForLab(diagMap);
					resultSeqNoList.add(resultSeqNo);
				}
				if (resultSeqNoList.size() > 0) {
					map.put("resultSeqNoList", resultSeqNoList);
				}
				map.put("CombinedIds", nextCombinedIds);
			}
		} else {
			jsp = "messageForNewresultEntry" + ".jsp";
			messageTOBeVisibleToTheUser = "No Records Found.";
		}
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPrintResultValidation(HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException,
			IOException {
		logger.info("in showPrintResultValidation");
		Map<String, Object> map = new HashMap<String, Object>();
		String resultNo = "";
		String resultType = "";
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		int userId = 0;
		String deptName = "";

		try {

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
			if (session.getAttribute("userId") != null) {
				userId = Integer.parseInt("" + session.getAttribute("userId"));
			}
			if (request.getParameter(RESULT_NO) != null) {
				resultNo = request.getParameter(RESULT_NO);
			}
			if (request.getParameter(RESULT_TYPE) != null) {
				resultType = request.getParameter(RESULT_TYPE);
			}

			Map<String, Object> detailsMap1 = new HashMap<String, Object>();
			List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();

			detailsMap1 = investigationHandlerService
					.getResultEntryDetailsForTemplate(resultNo, deptId);
			dgResultdetailList = (List<DgResultEntryDetail>) detailsMap1
					.get("resultList");
			Map<String, Object> dataMap = getHospitalParameterDetails(request);
			if (dataMap.get("hospitalAddress") != null) {
				map.put("hospitalAddress",
						(String) dataMap.get("hospitalAddress"));
			}
			if (dataMap.get("hospitalName") != null) {
				map.put("hospitalName", (String) dataMap.get("hospitalName"));
			}
			map.put("dgResultdetailList", dgResultdetailList);
			map.put("detailsMap1", detailsMap1);
			map.put("deptName", deptName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("resultValidationPrint", "map", map);
	}

	public ModelAndView showPrintResultValidationLab(
			HttpServletRequest request, HttpServletResponse response)
			throws IllegalStateException, IOException {
		logger.info("in showPrintResultValidationLab");
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();

		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		Map<String, Object> resultDetailsMap = new HashMap<String, Object>();
		List<Map<String, Object>> resultDetailsMapList = new ArrayList<Map<String, Object>>();

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}

		HttpSession session = request.getSession();
		String[] idsArray = new String[0];
		String deptName = "";
		String jsp = "";
		String combinedIds = "";
		int deptId = 0;
		String resultId = "";
		Integer dgSampleHeaderId = 0;
		Integer subChargeId = 0;

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			requestParameters.put(HOSPITAL_ID, Integer.parseInt("" + session.getAttribute(HOSPITAL_ID)));
		}
		if (request.getParameter("resultIdStringForTemplate") != null) {
			resultId = request.getParameter("resultIdStringForTemplate");
			requestParameters.put("resultId", resultId);
		}

		detailsMap1 = investigationHandlerService
				.getDetailsForFinalReportByOrderNoLab(requestParameters);
		
		detailsMap1.put("flagForConfidential", "y");
		dataMap=hospitalDetailsMasterHandlerService.getHospitalList(requestParameters);
		 //dataMap = getHospitalParameterDetails(request);
		 List<MasHospital> masHospitalList=(List<MasHospital>)dataMap.get("masHospitalList");
		 if(masHospitalList.size()>0){
			 map.put("hospitalAddress", (String) masHospitalList.get(0).getAddress());
			 map.put("hospitalName", (String) masHospitalList.get(0).getHospitalName());
			  
		 } 
		map.put("detailsMap1", detailsMap1);
		map.put("deptName", deptName);
		return new ModelAndView(VIEW_RESULT_ENTRY_PRINT_ORDER_NO_WISE_LAB,
				"map", map);
	}

	public Map<String, Object> getHospitalParameterDetails(
			HttpServletRequest request) {
		logger.info("in getHospitalParameterDetails");
		int hospitalId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<MasSetupParameterMaintaince> masSetupParameterMaintainceList = new ArrayList<MasSetupParameterMaintaince>();
		hospitalId = Integer.parseInt(request.getSession()
				.getAttribute(HOSPITAL_ID).toString());
		dataMap.put(HOSPITAL_ID, hospitalId);
		dataMap = hospitalDetailsMasterHandlerService
				.getSetupParameterMap(dataMap);
		if (dataMap.get("masSetupParameterMaintainceList") != null) {
			masSetupParameterMaintainceList = (List<MasSetupParameterMaintaince>) dataMap
					.get("masSetupParameterMaintainceList");
			if(masSetupParameterMaintainceList.get(0)
					.getHospital()!=null){
				dataMap.put("hospitalName", masSetupParameterMaintainceList.get(0)
						.getHospital().getHospitalName());
				dataMap.put("hospitalAddress",
						masSetupParameterMaintainceList.get(0).getHospital()
								.getAddress());
			}
			
		}
		return dataMap;
	}

	public ModelAndView searchForSensitiveDetailsLab(
			HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, IllegalStateException {
		logger.info("in searchForSensitiveDetailsLab");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();

		String CombinedIds = "";
		int sampleCollectionDetailId = 0;
		String jsp = "";
		int resultEnteredBy = 0;
		String userName = "";
		String resultSeqNo = "";
		int hospitalId = 0;

		int deptId = 0;
		String deptName = "";
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);

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
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();

		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		if (request.getParameter(DG_SAMPLE_DETAIL_ID_SENSITIVE) != null
				&& !(request.getParameter(DG_SAMPLE_DETAIL_ID_SENSITIVE)
						.equals("0"))) {
			sampleCollectionDetailId = Integer.parseInt(request
					.getParameter(DG_SAMPLE_DETAIL_ID_SENSITIVE));
			mapForDs.put("sampleCollectionDetailId", sampleCollectionDetailId);
			detailsMap1.put("sampleCollectionDetailId",
					sampleCollectionDetailId);

		}
		if (request.getParameter(RESULT_NO_SENSITIVE) != null
				&& !(request.getParameter(RESULT_NO_SENSITIVE).equals("0"))) {
			resultSeqNo = (String) request.getParameter(RESULT_NO_SENSITIVE);
			mapForDs.put("resultSeqNo", resultSeqNo);
			detailsMap1.put("resultSeqNo", resultSeqNo);
		}
		if (request.getParameter(RESULT_ENTERED_BY) != null
				&& !(request.getParameter(RESULT_ENTERED_BY).equals("0"))) {
			resultEnteredBy = Integer.parseInt(request
					.getParameter(RESULT_ENTERED_BY));
			mapForDs.put("resultEnteredBy", resultEnteredBy);
			detailsMap1.put("resultEnteredBy", resultEnteredBy);
		}
		if (request.getParameter("CombinedIds") != null
				&& !(request.getParameter("CombinedIds").equals("0"))) {
			CombinedIds = (String) request.getParameter("CombinedIds");
			mapForDs.put("CombinedIds", CombinedIds);
			detailsMap1.put("CombinedIds", CombinedIds);
		}

		mapForDs.put("deptId", deptId);

		if (sampleCollectionDetailId != 0) {
			map = investigationHandlerService.getSampleCollectionDetails(
					sampleCollectionDetailId, deptId);
			List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
			if (map.get("sampleCollectionList") != null) {
				sampleCollectionList = (List<DgSampleCollectionDetails>) map
						.get("sampleCollectionList");
			}

			String resultType = "";

			for (DgSampleCollectionDetails dgSampleDetail : sampleCollectionList) {
				resultType = dgSampleDetail.getInvestigation()
						.getInvestigationType();
				if (resultType.equalsIgnoreCase("v")) {
					detailsMap = investigationHandlerService
							.getDetails(dataMap);
					jsp = RESULT_ENTRY_SENSITIVE + ".jsp";
				}
			}
		}
		map.put("detailsMap", detailsMap);
		map.put("detailsMap1", detailsMap1);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("dataMap", dataMap);
		map.put("deptName", deptName);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAbcAnalysisJsp(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in showAbcAnalysisJsp");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		int deptId = 0;
		session = request.getSession();

		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		dataMap.put("deptId", deptId);
		// map=storesHandlerService.getDataForVendorAnalysis();
		map = investigationHandlerService.getDepartmentList(dataMap);

		jsp += "abcAnalysisForLab";
		jsp += ".jsp";
		title = "abcAnalysisForLab";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printAbcAnalysisReport(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in printAbcAnalysisReport");
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		byte[] bytes = null;
		session = request.getSession();
		String reportName = "";
		int mainDepartmentId = 0;
		String fromDate = "";
		String toDate = "";
		try {

			dataMap = getHospitalParameterDetails(request);
			if (request.getParameter("reportName") != null
					&& !(request.getParameter("reportName").equals(""))) {
				reportName = (request.getParameter("reportName"));

			}
			if (request.getParameter("mainChargeId") != null
					&& !(request.getParameter("mainDepartmentId").equals(""))) {
				mainDepartmentId = Integer.parseInt(request
						.getParameter("mainDepartmentId"));
			}
			if (request.getParameter("fromDate") != null
					&& !(request.getParameter("fromDate").equals(""))) {
				fromDate = request.getParameter("fromDate");

				requestParameters.put("fromDate",
						HMSUtil.dateFormatterDDMMYYYY(fromDate));

			}
			if (request.getParameter("toDate") != null
					&& !(request.getParameter("toDate").equals(""))) {
				toDate = request.getParameter("toDate");

				requestParameters.put("toDate",
						HMSUtil.dateFormatterDDMMYYYY(toDate));

			}
			if (request.getParameter("mainDepartmentId") != null
					&& !(request.getParameter("mainDepartmentId").equals(""))) {
				mainDepartmentId = Integer.parseInt(request
						.getParameter("mainDepartmentId"));
			}

			requestParameters.put("departmentId",
					(Integer) session.getAttribute("deptId"));
			requestParameters.put("mainchargecode", mainDepartmentId);
			requestParameters.put(HOSPITAL_ID,
					(Integer) session.getAttribute(HOSPITAL_ID));
			Map<String, Object> connectionMap = investigationHandlerService
					.getConnectionForReport();
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

	public ModelAndView submitResultValidationForTemplateLab(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in submitResultValidationForTemplateLab");
		MultipartFormDataRequest mrequest = null;
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		String url = "";
		String resultNo = "";
		String resultType = "";
		String result = "";
		String additionalRemarks = "";
		String validated = "";
		String resultIdStringForTemplate = "";

		int resultId = 0;
		int newResultId = 0;
		int resultValidatedBy = 0;
		int deptId = 0;
		try {
			if (MultipartFormDataRequest.isMultipartFormData(request)) {
				mrequest = new MultipartFormDataRequest(request);
				// result=mrequest.getParameter("test2");
				String tepmlateData = mrequest.getParameter("test2");
				InputStream fis1 = new FileInputStream(getServletContext()
						.getRealPath("jsp/pdf/appendingHtml.html"));
				File temprory2 = new File(getServletContext().getRealPath(
						"jsp/pdf/appendingHtml.html"));

				byte[] b1 = new byte[(int) temprory2.length()];
				int offset1 = 0;
				int numRead1 = 0;
				try {
					while ((offset1 < b1.length)
							&& ((numRead1 = fis1.read(b1, offset1, b1.length
									- offset1)) >= 0)) {

						offset1 += numRead1;

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fis1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String appendedHtml = new String(b1);
				String finalFile = appendedHtml + tepmlateData
						+ "</body></html>";

				byte[] bytes = finalFile.getBytes();
				result = new String(bytes);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (request.getParameter("resultNo") != null) {
			resultNo = request.getParameter("resultNo");
		}

		if (request.getParameter("resultType") != null) {
			resultType = request.getParameter("resultType");
		}
		if (request.getParameter("resultIdStringForTemplate") != null) {
			resultIdStringForTemplate = request
					.getParameter("resultIdStringForTemplate");
		}

		if (request.getParameter("resultId") != null) {
			resultId = Integer.parseInt(request.getParameter("resultId"));
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("resultNo", resultNo);
		dataMap.put("deptId", deptId);
		// String templateData="";
		// if(request.getParameter("test2")!=null){
		// templateData=request.getParameter("test2");
		// }
		dataMap.put("templateData", result);
		dataMap.put("resultId", resultIdStringForTemplate);
		dataMap.put("resultIdToRemove", resultId);

		boolean flag1 = investigationHandlerService
				.updateResultTemplateForValidation(dataMap);
		Map<String, Object> patientMap = new HashMap<String, Object>();
		/*
		 * if( newResultId != 0){ map =
		 * investigationHandlerService.getResultEntryDetailsForNext
		 * (newResultId,deptId); }
		 */

		if (request.getParameter(RESULT_VALIDATED_BY) != null
				&& !request.getParameter(RESULT_VALIDATED_BY).equals("")) {
			resultValidatedBy = Integer.parseInt(request
					.getParameter(RESULT_VALIDATED_BY));
		}
		if (request.getParameter(ADDITIONAL_REMARKS) != null
				&& !request.getParameter(ADDITIONAL_REMARKS).equals("")) {
			additionalRemarks = request.getParameter(ADDITIONAL_REMARKS);
		}
		if (request.getParameter(VALIDATED) != null
				&& !request.getParameter(VALIDATED).equals("")) {
			validated = request.getParameter(VALIDATED);
		}

		// map=investigationHandlerService.getResultList(resultId);
		infoMap.put("box", box);
		String jsp = MESSAGE_FOR_RESULT_JSP + ".jsp";

		infoMap.put("resultId", resultId);
		infoMap.put("resultValidatedBy", resultValidatedBy);
		infoMap.put("additionalRemarks", additionalRemarks);
		infoMap.put("validated", validated);

		boolean flag = false;
		try {
			flag = investigationHandlerService
					.submitResultValidationForTemplate(infoMap);
			if (flag == false) {
				messageTOBeVisibleToTheUser = "Successfully Validated the result.Do you want to print.";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!resultIdStringForTemplate.equals("")) {
			map = investigationHandlerService.getResultEntryDetailsLab(dataMap);
			map.put("resultId", resultIdStringForTemplate);
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			if (map.get("resultList") != null) {
				resultList = (List<DgResultEntryHeader>) map.get("resultList");
				if (resultList.size() > 0) {
					jsp = RESULT_VALIDATION_ENTRY_SINGLE_PARAMETER_LAB + ".jsp";
				} else {
					String nextCombinedValidationIds = "";
					if (!resultIdStringForTemplate.equals("")) {
						String[] idArrString = new String[0];
						idArrString = resultIdStringForTemplate.split("@");

						int subChargeId = Integer.parseInt(idArrString[1]);

						List<String> pendingValidationListLabAll = new ArrayList<String>();
						pendingValidationListLabAll = (List<String>) session
								.getAttribute("pendingValidationListLabAll");

						if (pendingValidationListLabAll.size() > 0) {
							pendingValidationListLabAll
									.remove(resultIdStringForTemplate);
						}
						for (String combinedIdsFromList : pendingValidationListLabAll) {
							String[] idArray = new String[0];
							idArray = combinedIdsFromList.split("@");

							int subChargeIdFromList = Integer
									.parseInt(idArray[1]);
							if (subChargeIdFromList == subChargeId) {
								nextCombinedValidationIds = combinedIdsFromList;
								break;
							}
						}
					}

					map.put("nextCombinedValidationIds",
							nextCombinedValidationIds);
					jsp = MESSAGE_FOR_RESULT_VALIDATION_LAB + ".jsp";
				}
			}
		}
		map.put("resultNo", resultNo);
		map.put("resultType", resultType);
		map.put("resultIdStringForTemplate", resultIdStringForTemplate);

		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitResultEntryModificationForTemplateLab(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in submitResultEntryModificationForTemplateLab");
		MultipartFormDataRequest mrequest = null;
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		String url = "";
		String resultNo = "";
		String resultType = "";
		String result = "";
		String additionalRemarks = "";
		String validated = "";
		String resultIdStringForTemplate = "";

		int resultId = 0;
		int newResultId = 0;
		int resultEnteredBy = 0;
		int deptId = 0;
		try {
			if (MultipartFormDataRequest.isMultipartFormData(request)) {
				mrequest = new MultipartFormDataRequest(request);
				// result=mrequest.getParameter("test2");
				String tepmlateData = mrequest.getParameter("test2");
				InputStream fis1 = new FileInputStream(getServletContext()
						.getRealPath("jsp/pdf/appendingHtml.html"));
				File temprory2 = new File(getServletContext().getRealPath(
						"jsp/pdf/appendingHtml.html"));

				byte[] b1 = new byte[(int) temprory2.length()];
				int offset1 = 0;
				int numRead1 = 0;
				try {
					while ((offset1 < b1.length)
							&& ((numRead1 = fis1.read(b1, offset1, b1.length
									- offset1)) >= 0)) {

						offset1 += numRead1;

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fis1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				String appendedHtml = new String(b1);
				String finalFile = appendedHtml + tepmlateData
						+ "</body></html>";

				byte[] bytes = finalFile.getBytes();
				result = new String(bytes);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (request.getParameter("resultNo") != null) {
			resultNo = request.getParameter("resultNo");
		}

		if (request.getParameter("resultType") != null) {
			resultType = request.getParameter("resultType");
		}
		if (request.getParameter("resultIdStringForTemplate") != null) {
			resultIdStringForTemplate = request
					.getParameter("resultIdStringForTemplate");
		}

		if (request.getParameter("resultId") != null) {
			resultId = Integer.parseInt(request.getParameter("resultId"));
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("resultNo", resultNo);
		dataMap.put("deptId", deptId);
		// String templateData="";
		// if(request.getParameter("test2")!=null){
		// templateData=request.getParameter("test2");
		// }
		dataMap.put("templateData", result);
		dataMap.put("resultId", resultIdStringForTemplate);
		dataMap.put("resultIdToRemove", resultId);

		boolean flag1 = investigationHandlerService
				.updateResultTemplateForValidation(dataMap);
		Map<String, Object> patientMap = new HashMap<String, Object>();
		/*
		 * if( newResultId != 0){ map =
		 * investigationHandlerService.getResultEntryDetailsForNext
		 * (newResultId,deptId); }
		 */

		if (request.getParameter(RESULT_ENTERED_BY) != null
				&& !request.getParameter(RESULT_ENTERED_BY).equals("")) {
			resultEnteredBy = Integer.parseInt(request
					.getParameter(RESULT_ENTERED_BY));
		}
		if (request.getParameter(ADDITIONAL_REMARKS) != null
				&& !request.getParameter(ADDITIONAL_REMARKS).equals("")) {
			additionalRemarks = request.getParameter(ADDITIONAL_REMARKS);
		}
		if (request.getParameter(VALIDATED) != null
				&& !request.getParameter(VALIDATED).equals("")) {
			validated = request.getParameter(VALIDATED);
		}

		// map=investigationHandlerService.getResultList(resultId);
		infoMap.put("box", box);
		String jsp = MESSAGE_FOR_RESULT_ENTRY_CORRECTION_LAB + ".jsp";

		infoMap.put("resultId", resultId);
		infoMap.put("resultEnteredBy", resultEnteredBy);
		infoMap.put("additionalRemarks", additionalRemarks);
		infoMap.put("validated", validated);

		boolean flag = false;
		try {
			flag = investigationHandlerService
					.submitResultEntryForModificationTemplate(infoMap);
			if (flag == false) {
				messageTOBeVisibleToTheUser = "Successfully Validated the result.Do you want to print.";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!resultIdStringForTemplate.equals("")) {
			map = investigationHandlerService.getResultEntryDetailsLab(dataMap);
			map.put("resultId", resultIdStringForTemplate);
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			if (map.get("resultList") != null) {
				resultList = (List<DgResultEntryHeader>) map.get("resultList");
				if (resultList.size() > 0) {
					jsp = RESULT_ENTRY_VALUES_FOR_CORRECTION_LAB + ".jsp";
				} else {
					jsp = MESSAGE_FOR_RESULT_ENTRY_CORRECTION_LAB + ".jsp";
				}
			}
		}
		map.put("resultNo", resultNo);
		map.put("resultType", resultType);
		map.put("resultIdStringForTemplate", resultIdStringForTemplate);

		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// ******************************************* Written By
	// Tirath**********************************//
	public ModelAndView showLioncSubClassJsp(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in showLioncSubClassJsp");
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

		map = investigationHandlerService.showLioncSubClassJsp(box);
		map.put("deptId", deptId);
		map.put("pageNoTempFromBackButton", pageNoTempFromBackButton);
		map.put("hospitalId", hospitalId);

		String jsp = LIONC_SUBCLASS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public ModelAndView addLionClass(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in addLionClass");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MasLionc masLionc = new MasLionc();
		String changedBy = "";
		Date currentDate = new Date();
		int mainChargecodeId = 0;
		int subChargecodeId = 0;
		String className = "";
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		String lionNo = "";
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
		if (request.getParameter(MAIN_CHARGECODE_ID) != null) {
			mainChargecodeId = Integer.parseInt(request
					.getParameter(MAIN_CHARGECODE_ID));
		}
		if (request.getParameter(SUB_CHARGECODE_ID) != null) {
			subChargecodeId = Integer.parseInt(request
					.getParameter(SUB_CHARGECODE_ID));

		}
		if (request.getParameter(LIONC_CLASS_NAME) != null) {
			className = request.getParameter(LIONC_CLASS_NAME);
		}

		if (request.getParameter("lionNo") != null) {
			lionNo = request.getParameter("lionNo");
		}

		MasLioncSubClass masLioncSubClass = new MasLioncSubClass();
		try {

			MasMainChargecode masMainChargecode = new MasMainChargecode();
			MasSubChargecode masSubChargecode = new MasSubChargecode();

			masMainChargecode.setId(mainChargecodeId);
			masSubChargecode.setId(subChargecodeId);

			masLioncSubClass.setMainChargeCode(masMainChargecode);
			masLioncSubClass.setSubChargeCode(masSubChargecode);
			masLionc.setId(lionNo);
			masLioncSubClass.setLoincNum(masLionc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		masLioncSubClass.setLionCClass(className);

		// masLioncSubClass.setLioncNum(lionNo);
		masLioncSubClass.setStatus("y");

		successfullyAdded = investigationHandlerService
				.addLionClass(masLioncSubClass);
		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !";

		}

		try {
			map = investigationHandlerService.showLioncSubClassJsp(box);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = LIONC_SUBCLASS_JSP;
		title = "Lion Class";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	/** start of edit Lion Class method * */
	public ModelAndView editLionClass(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in editLionClass");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		DgMasInvestigation dgmasInvestigation = new DgMasInvestigation();
		String changedBy = "";
		Date currentDate = new Date();
		int mainChargeId = 0;
		int subChargeId = 0;
		String className = "";
		String userName = "";
		String lionNo = "";
		int hospitalId = 0;
		int deptId = 0;
		int classId = 0;
		boolean dataUpdated = false;

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
		Box box = HMSUtil.getBox(request);
		box.put("deptId", deptId);

		if (request.getParameter(MAIN_CHARGECODE_ID) != null
				&& (!request.getParameter(MAIN_CHARGECODE_ID).equals("0"))) {
			mainChargeId = Integer.parseInt(request
					.getParameter(MAIN_CHARGECODE_ID));
		}

		if (request.getParameter(SUB_CHARGECODE_ID) != null
				&& (!request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
			subChargeId = Integer.parseInt(request
					.getParameter(SUB_CHARGECODE_ID));
		}

		if (request.getParameter(COMMON_ID) != null
				&& (!request.getParameter(COMMON_ID).equals("0"))) {
			classId = Integer.parseInt(request.getParameter(COMMON_ID));
		}

		if (request.getParameter("lionNo") != null) {
			lionNo = request.getParameter("lionNo");
		}

		if (request.getParameter(LIONC_CLASS_NAME) != null) {
			className = request.getParameter(LIONC_CLASS_NAME);
		}

		generalMap.put("mainChargeId", mainChargeId);
		generalMap.put("subChargeId", subChargeId);
		generalMap.put("className", className);
		generalMap.put("flag", true);
		generalMap.put("classId", classId);
		generalMap.put("lionNo", lionNo);

		dataUpdated = investigationHandlerService.editLionClass(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant Be Updated !!";
		}

		url = "/hms/hms/investigation?method=showLioncSubClassJsp";

		try {
			map = investigationHandlerService.showLioncSubClassJsp(box);

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = LIONC_SUBCLASS_JSP;
		title = "edit Lion Class";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("mainChargecodeList", map.get("mainChargecodeList"));
		map.put("masLioncSubClassList", map.get("masLioncSubClassList"));
		map.put("subChargecodeList", map.get("subChargecodeList"));
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	/** end of edit LionClass method * */

	@SuppressWarnings("deprecation")
	public ModelAndView deleteLionClass(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in deleteLionClass");
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
		dataDeleted = investigationHandlerService.deleteLionClass(classId,
				generalMap);
		if (dataDeleted == true) {

			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/investigation?method=showInvestigationJsp";
		try {
			map = investigationHandlerService.showLioncSubClassJsp(box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = LIONC_SUBCLASS_JSP;
		title = "Delete Lion Class";
		jsp += ".jsp";
		map.put("mainChargecodeList", map.get("mainChargecodeList"));
		map.put("masLioncSubClassList", map.get("masLioncSubClassList"));
		map.put("subChargecodeList", map.get("subChargecodeList"));
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ********************************Start Search Method For Lion Sub Class
	// *****************************//
	@SuppressWarnings("deprecation")
	public ModelAndView searchLionSubClass(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in searchLionSubClass");
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

		map = investigationHandlerService.searchLionSubClass(searchField);
		jsp = LIONC_SUBCLASS_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("mainChargecodeList", map.get("mainChargecodeList"));
		map.put("masLioncSubClassList", map.get("masLioncSubClassList"));
		map.put("subChargecodeList", map.get("subChargecodeList"));
		return new ModelAndView("index", "map", map);
	}

	// ********************************End Search Method For Lion Sub Class
	// *****************************//

	// ********************************Start Get Class Name For LionC
	// Class*****************************//
	public ModelAndView getClassForLionC(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in getClassForLionC");
		String itemNameField = "";
		Box box = HMSUtil.getBox(request);
		String autoHint = "";
		session = request.getSession();
		box.put("deptId", session.getAttribute("deptId"));
		box.put("hospitalId", session.getAttribute("hospitalId"));
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(LIONC_CLASS_NAME) != null) {
			autoHint = (request.getParameter(LIONC_CLASS_NAME));
		}

		box.put("autoHint", autoHint);
		map = investigationHandlerService.getClassForLionC(box);
		jsp = "classNameResponseForLionC";
		return new ModelAndView(jsp, "map", map);

	}

	// ********************************End Get Class Name For LionC
	// Class*****************************//

	public ModelAndView getLionClass(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in getLionClass");
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		int hospitalId = 0;
		int poId = 0;
		String userName = "";
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		int mainChargeCodeId = box.getInt("mainChargeCode");
		int subChargeCodeId = box.getInt("subChargeCode");
		box.put("hospitalId", hospitalId);
		box.put("deptId", deptId);
		box.put("mainChargeCodeId", mainChargeCodeId);
		box.put("subChargeCodeId", subChargeCodeId);
		map = investigationHandlerService.getLionClass(box);
		jsp = "getClassNameResponseJsp";
		jsp = jsp + ".jsp";
		title = "Where House Receipt Entry";
		return new ModelAndView("getClassNameResponseJsp", "map", map);
	}

	// ********************************Method For Diagnostics Master For
	// Radiology By Tirath************************//

	public ModelAndView showInvestigationForRadiologyJsp(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in showInvestigationForRadiologyJsp");
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
		if (request.getParameter(MAIN_CHARGECODE_ID) != null
				&& request.getParameter(MAIN_CHARGECODE_ID) != "") {
			mainChargecodeId = Integer.parseInt(request
					.getParameter(MAIN_CHARGECODE_ID));
		}
		if (request.getParameter("subChargecodeId") != null
				&& request.getParameter("subChargecodeId") != "") {
			subChargecodeId = Integer.parseInt(request
					.getParameter("subChargecodeId"));
		}
		if (request.getParameter(CHARGE_CODE_ID) != null) {
			chargeCodeId = Integer.parseInt(request
					.getParameter(CHARGE_CODE_ID));
		}
		if (request.getParameter(INVESTIGATION_NAME) != null) {
			investigationName = request.getParameter(INVESTIGATION_NAME);
		}
		if (request.getParameter("pageNoTempFromBackButton") != null) {
			pageNoTempFromBackButton = Integer.parseInt(request
					.getParameter("pageNoTempFromBackButton"));
		}
		map = investigationHandlerService.showInvestigationJsp(box);
		map.put("deptId", deptId);
		map.put("pageNoTempFromBackButton", pageNoTempFromBackButton);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("investigationName", investigationName);
		map.put("subChargecodeId", subChargecodeId);
		map.put("mainChargecodeId", mainChargecodeId);
		map.put("chargeCodeId", chargeCodeId);
		String jsp = INVESTIGATION_DIAGNOSTICS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getItemList(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in getItemList");
		String itemNameField = "";
		Box box = HMSUtil.getBox(request);
		String autoHint = "";
		session = request.getSession();
		box.put("deptId", session.getAttribute("deptId"));
		box.put("hospitalId", session.getAttribute("hospitalId"));
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(itemNameField) != null) {
			autoHint = (request.getParameter(itemNameField));
		}

		box.put("autoHint", autoHint);
		map = investigationHandlerService.getItemList(box);
		jsp = "itemListResponseForRadiologyResultEntryJSP";
		return new ModelAndView(jsp, "map", map);

	}

	// ****************************** Method written For Get Item Stock oF Film
	// ***************************//

	public ModelAndView getItemStock(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in getItemStock");
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		int hospitalId = 0;
		int poId = 0;
		String userName = "";
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		int itemId = box.getInt("itemId");
		box.put("hospitalId", hospitalId);
		box.put("deptId", deptId);
		box.put("itemId", itemId);

		map = investigationHandlerService.getItemStock(box);

		jsp = "itemStockResponseJsp";
		jsp = jsp + ".jsp";
		title = "Where House Receipt Entry";
		return new ModelAndView("itemStockResponseJsp", "map", map);
	}

	/** Film Stock Report printing method */

	public ModelAndView printFilmStockReport(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in printFilmStockReport");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String resultNo = "";
		String resultType = "";
		session = request.getSession();

		if (request.getParameter(RESULT_NO) != null) {
			resultNo = request.getParameter(RESULT_NO);
		}
		if (request.getParameter(RESULT_TYPE) != null) {
			resultType = request.getParameter(RESULT_TYPE);
		}

		parameters.put("deptId", session.getAttribute("deptId"));
		try {
			dataMap = getHospitalParameterDetails(request);
			if (dataMap.get("hospitalAddress") != null) {
				parameters.put("hospitalAddress",
						(String) dataMap.get("hospitalAddress"));
			}

			if (dataMap.get("hospitalName") != null) {
				parameters.put("hospitalName",
						(String) dataMap.get("hospitalName"));
			}
			parameters.put(HOSPITAL_ID, session.getAttribute(HOSPITAL_ID));
			detailsMap = investigationHandlerService.getConnectionForReport();
			HMSUtil.generateReport("film_stock_details", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView showPatientCategoryWiseTestReport(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in showPatientCategoryWiseTestReport");
		HttpSession session = request.getSession();
		Map<String, Object> map1 = new HashMap<String, Object>();
		int deptId = 0;
		String deptType = "";
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}
		map1.put("deptType", deptType);
		map1.put("deptId", deptId);
		map = investigationHandlerService.getTestName(map1);
		jsp = "patientCategoryWiseTestJsp";
		jsp += ".jsp";
		title = "Diagnostic Register Diagnosis Wise";
		map.put("deptId", deptId);
		map.put("testList", map1.get("testList"));
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printOrderStatusReportWard(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in printOrderStatusReportWard");
		HttpSession session = request.getSession();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
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
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap = getHospitalParameterDetails(request);
		if (dataMap.get("hospitalAddress") != null) {
			map.put("hospitalAddress", (String) dataMap.get("hospitalAddress"));
		}
		if (dataMap.get("hospitalName") != null) {
			map.put("hospitalName", (String) dataMap.get("hospitalName"));
		}
		int orderNoIdForReport = 0;
		int inPatientId = 0;
		if (request.getParameter("orderNoIdForReport") != null
				&& !(request.getParameter("orderNoIdForReport")).equals("")) {
			orderNoIdForReport = Integer.parseInt(request
					.getParameter("orderNoIdForReport"));
			mapForDs.put("orderIdForReport", orderNoIdForReport);
		}
		/*
		 * if (request.getParameter(INPATIENT_ID) != null) { inPatientId =
		 * Integer.parseInt(request.getParameter(INPATIENT_ID));
		 * mapForDs.put("inPatientId", inPatientId); } if (inPatientId==0 &&
		 * request.getParameter("inPatientId") != null &&
		 * !(request.getParameter("inPatientId")).equals("")) { inPatientId =
		 * Integer.parseInt(request.getParameter("inPatientId"));
		 * mapForDs.put("inPatientId", inPatientId); }
		 */
		map1 = investigationHandlerService.printOrderStatusReportWard(mapForDs);
		try {
			if (request.getParameter("counta") != null) {
				srn = Integer.parseInt(request.getParameter("counta"));
			}
			/* src = ("parent"); */
			/*
			 * if ((request.getParameter(src) != null) &&
			 * !(request.getParameter(src).equals(""))) {
			 * requestParameters.put("orderNo", request.getParameter(src));
			 * detailsMap1 = investigationHandlerService
			 * .getAllValidatedTestForLabOrderNoWise(requestParameters);
			 * 
			 * map.put("detailsMap1", detailsMap1); map.put("deptName",
			 * deptName); }
			 */
			if (map1.get("orderNo") != null && map1.get("orderNo") != "") {
				src = (String) map1.get("orderNo");
				requestParameters.put("orderNo", src);
				detailsMap1 = investigationHandlerService
						.getAllValidatedTestForLabOrderNoWise(requestParameters);
				map.put("detailsMap1", detailsMap1);
				map.put("deptName", deptName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("finalResultPrintForLab", "map", map);
	}

	public ModelAndView showPaitentTestDetailInResultPrinting(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in showPaitentTestDetailInResultPrinting");
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		session = request.getSession();
		String orderNo = "";
		if (session.getAttribute(DEPT_ID) != null) {
			deptId = Integer.parseInt("" + session.getAttribute(DEPT_ID));
			mapForDs.put(DEPT_ID, deptId);
		}
		Integer hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (!request.getParameter(ORDER_NO).equals("")) {
			orderNo = request.getParameter(ORDER_NO);
			mapForDs.put(ORDER_NO, orderNo);
		}
		mapForDs.put(HOSPITAL_ID, hospitalId);
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		List<DgResultEntryHeader> dgResultEntryHeader = (List<DgResultEntryHeader>) investigationHandlerService
				.showPaitentTestDetailInResultPrinting(mapForDs).get(
						"dgResultEntryHeader");
		if (dgResultEntryHeader.size() > 0) {
			for (DgResultEntryHeader dgResultEntry : dgResultEntryHeader) {
				Set<DgResultEntryDetail> detail = (Set<DgResultEntryDetail>) dgResultEntry
						.getDgResultEntryDetails();
				for (DgResultEntryDetail dgResultEntryDetail : detail) {

					dgResultEntryDetail.getChargeCode().getChargeCodeName();
					if (dgResultEntryDetail.getUom() != null) {
						dgResultEntryDetail.getUom().getUomName();
					}

					String status = "";
					if ("V".equalsIgnoreCase(dgResultEntryDetail.getValidated())) {
						status = "Result Validated";
					} else {
						status = "Result Entered";
					}
					String testType = "";
					String val = dgResultEntryDetail.getInvestigation()
							.getInvestigationType();
					if ("m".equalsIgnoreCase(val)) {
						testType = "Multiple Parameter";
					} else if ("t".equalsIgnoreCase(val)) {
						testType = "Template";
					} else if ("v".equalsIgnoreCase(val)) {
						testType = "Sensitive";
					} else {
						testType = "Single Parameter";
					}

				}
			}
		}

		String jsp = "populatedPatientTestDetails";
		map.put("dgResultEntryHeader", dgResultEntryHeader);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView bulkSearchPatientForLab(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {
		logger.info("in bulkSearchPatientForLab");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String fromDate = null;
		String toDate =null;
		String patientFName = "";
		String orderStatus = "";
		String adNo = "";
		String hinNo = "";
		String orderType = "";
		String flag = "";
		String CombinedIds = "";
		String[] idsArray = new String[0];
		String diagnosisNo = "";
		String userName = "";
		String appendedHtml = "";
		String deptName = "";
		int departmentId = 0;
		int inpatientId = 0;
		int subChargeCodeId = 0;
		int hinId = 0;
		int sampleCollectionDetailId = 0;
		int dgSampleHeaderId = 0;
		int subChargeId = 0;
		int hospitalId = 0;
		int deptId = 0;
		String billNo = "";
		String mobileNo = "";
		String wardName = "";
		Integer barCode = 0;
		String nameOfChargeCode = null;
		
		session = request.getSession();
		Box box = HMSUtil.getBox(request);

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
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		try {

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))
					&& !(request.getParameter(INPATIENT_ID).equals(""))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = request.getParameter(FROM_DATE);
				mapForDs.put("fromDate", HMSUtil.dateFormatterDDMMYYYY(fromDate));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = request.getParameter(TO_DATE);
				mapForDs.put("toDate", HMSUtil.dateFormatterDDMMYYYY(toDate));
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
			}
			if (request.getParameter(DIAGNOSIS_NO) != null
					&& !(request.getParameter(DIAGNOSIS_NO).equals(""))) {
				diagnosisNo = request.getParameter(DIAGNOSIS_NO);
				mapForDs.put("diagnosisNo", diagnosisNo);
			}

			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
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
			if (request.getParameter(ORDER_STATUS) != null
					&& !(request.getParameter(ORDER_STATUS).equals("0"))) {
				orderStatus = request.getParameter(ORDER_STATUS);
				mapForDs.put("orderStatus", orderStatus);
			}
			if (request.getParameter(SAMPLE_COLLECTION_DETAIL_ID) != null
					&& !(request.getParameter(SAMPLE_COLLECTION_DETAIL_ID)
							.equals("0"))) {
				CombinedIds = request.getParameter(SAMPLE_COLLECTION_DETAIL_ID);
				mapForDs.put("sampleCollectionDetailId",
						sampleCollectionDetailId);
			}
			if (request.getParameter(BILL_NO) != null
					&& !(request.getParameter(BILL_NO).equals(""))) {
				billNo = request.getParameter(BILL_NO);
				mapForDs.put("billNo", billNo);
			}
			if (request.getParameter(MOBILE_NO) != null
					&& !(request.getParameter(MOBILE_NO).equals(""))) {
				mobileNo = request.getParameter(MOBILE_NO);
				mapForDs.put(MOBILE_NO, mobileNo);
			}
			if (request.getParameter(WARD_NAME) != null
					&& !(request.getParameter(WARD_NAME).equals(""))) {
				wardName = request.getParameter(WARD_NAME);
				mapForDs.put(WARD_NAME, wardName);
			}
			if (request.getParameter(RequestConstants.BARCODE) != null
					&& !(request.getParameter(RequestConstants.BARCODE)
							.equals(""))) {
				barCode = Integer.parseInt(request
						.getParameter(RequestConstants.BARCODE));
				mapForDs.put(RequestConstants.BARCODE, barCode);
			}

			if (request.getParameter(RequestConstants.CHARGE_CODE) != null
					&& !(request.getParameter(RequestConstants.CHARGE_CODE)
							.equals(""))) {
				 nameOfChargeCode = request
						.getParameter(RequestConstants.CHARGE_CODE);
				int index1 = nameOfChargeCode.lastIndexOf("[");
				int index2 = nameOfChargeCode.lastIndexOf("]");
				Integer chargeCodeId = Integer.parseInt(nameOfChargeCode
						.substring(index1 + 1, index2));
				mapForDs.put(RequestConstants.CHARGE_CODE, chargeCodeId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> diagMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		String jsp = "";
		patientMap = investigationHandlerService
				.getBulkPatientDetailsForResultEntry(mapForDs);

		if (patientMap.get("patientDetailsList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailsList");

		}
		detailsMap = investigationHandlerService.getDetailsForSearch(dataMap);
		detailsMap = investigationHandlerService.getDetailsForLab(dataMap);
		jsp = "bulkResultEntryForLab" + ".jsp";

		patientMap.put("patientList", patientList);
		
		detailsMap.put("fromDate",fromDate );
		detailsMap.put("toDate",toDate );
		detailsMap.put("hinNo",hinNo );
		detailsMap.put("orderType", orderType);
		detailsMap.put("adNo", adNo);
		detailsMap.put("patientFName",patientFName );
		detailsMap.put("mobileNo",mobileNo );
		detailsMap.put("wardName",wardName );
		detailsMap.put("nameOfChargeCode",nameOfChargeCode );
		
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("dataMap", dataMap);
		map.put("deptName", deptName);
		map.put("appendedHtml", appendedHtml);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchResultForBulk(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {
		logger.info("in searchResultForBulk");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String patientFName = "";
		String orderStatus = "";
		String adNo = "";
		String hinNo = "";
		String orderType = "";
		String flag = "";
		String CombinedIds = "";
		String[] idsArray = new String[0];
		String diagnosisNo = "";
		String userName = "";
		String appendedHtml = "";
		String deptName = "";

		int departmentId = 0;
		int inpatientId = 0;
		int subChargeCodeId = 0;
		int hinId = 0;
		int sampleCollectionDetailId = 0;
		int dgSampleHeaderId = 0;
		int subChargeId = 0;
		int hospitalId = 0;
		int deptId = 0;
		String billNo = "";
		String mobileNo = "";
		String wardName = "";
		Integer barCode = 0;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);

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
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		try {

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))
					&& !(request.getParameter(INPATIENT_ID).equals(""))) {
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
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
			}
			if (request.getParameter(DIAGNOSIS_NO) != null
					&& !(request.getParameter(DIAGNOSIS_NO).equals(""))) {
				diagnosisNo = request.getParameter(DIAGNOSIS_NO);
				mapForDs.put("diagnosisNo", diagnosisNo);
			}

			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
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
			if (request.getParameter(ORDER_STATUS) != null
					&& !(request.getParameter(ORDER_STATUS).equals("0"))) {
				orderStatus = request.getParameter(ORDER_STATUS);
				mapForDs.put("orderStatus", orderStatus);
			}
			if (request.getParameter(SAMPLE_COLLECTION_DETAIL_ID) != null
					&& !(request.getParameter(SAMPLE_COLLECTION_DETAIL_ID)
							.equals("0"))) {
				CombinedIds = request.getParameter(SAMPLE_COLLECTION_DETAIL_ID);
				mapForDs.put("sampleCollectionDetailId",
						sampleCollectionDetailId);
			}
			if (request.getParameter(BILL_NO) != null
					&& !(request.getParameter(BILL_NO).equals(""))) {
				billNo = request.getParameter(BILL_NO);
				mapForDs.put("billNo", billNo);
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

		Map<String, Object> diagMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		if (!CombinedIds.equals("")) {

			idsArray = CombinedIds.split(",");
			dgSampleHeaderId = Integer.parseInt(idsArray[0]);
			mapForDs.put("dgSampleHeaderId", dgSampleHeaderId);

			subChargeId = Integer.parseInt(idsArray[1]);
			mapForDs.put("subChargeId", subChargeId);
		}

		if (!CombinedIds.equals("")) {
			map = investigationHandlerService
					.getSampleCollectionDetailsForLab(mapForDs);
			// /////////////////////////////////////////////////////
			// map =
			// investigationHandlerService.getSampleCollectionDetails(sampleCollectionDetailId,
			// deptId);

			List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
			if (map.get("sampleCollectionList") != null) {
				sampleCollectionList = (List<DgSampleCollectionDetails>) map
						.get("sampleCollectionList");
			}
			if (sampleCollectionList.size() > 0) {
				jsp = "resultEntryForPopupBulk";
				List<String> resultSeqNoList = new ArrayList<String>();
				for (int i = 0; i < sampleCollectionList.size(); i++) {
					String resultSeqNo = "";
					resultSeqNo = investigationHandlerService
							.generateResultNumberForLab(diagMap);
					resultSeqNoList.add(resultSeqNo);
				}
				if (resultSeqNoList.size() > 0) {
					map.put("resultSeqNoList", resultSeqNoList);
				}
				map.put("CombinedIds", CombinedIds);
			}
		}
		patientMap.put("patientList", patientList);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		// map.put("contentJsp", jsp);
		map.put("dataMap", dataMap);
		map.put("deptName", deptName);
		// map.put("appendedHtml", appendedHtml);
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView viewUploadDocuments(HttpServletRequest request ,HttpServletResponse response) throws SQLException {
		logger.info("in viewUploadDocuments");
    	Map<String, Object> map = new HashMap<String, Object>();
    	List<UploadDocuments> uploadDocuments = new ArrayList<UploadDocuments>();
    	
    	String filename=null;
    	String fileExtension=null;
    	String viewFrom="";
    	int hinId=0;
    	int uploadedDocumentId =0;
    
    	    Map<String, Object> uploadFileMap = new HashMap<String, Object>();
    	   
    	    if(request.getParameter("uploadedDocumentId")!= null){
    	    	uploadedDocumentId = Integer.parseInt(request.getParameter("uploadedDocumentId"));
    		}
    	    
    	    
    	    uploadDocuments = investigationHandlerService.getDocumentList(uploadedDocumentId);
    	    if(request.getParameter("filename")!= null){
    			filename = request.getParameter("filename");
    		}
    	    /*
    		if(request.getParameter("filename")!= null){
    			filename = request.getParameter("filename");
    		}
    		
    		if(request.getParameter("viewFrom")!= null){
    			viewFrom = request.getParameter("viewFrom");
    		}
    		if(request.getParameter("hinId")!= null){
    			hinId = Integer.parseInt(request.getParameter("hinId"));
    		}  	
    		
    		String uploadURL = getServletContext().getRealPath("/"); // general case
    		
    		if(viewFrom.equalsIgnoreCase("OPD"))
    		{
    			uploadURL = uploadURL+"/UploadedDocuments/OPD/"+hinId+"/"; 
    		}
    		if(viewFrom.equalsIgnoreCase("IP"))
    		{
    			uploadURL = uploadURL+"/UploadedDocuments/IP/"+hinId+"/"; 
    		}*/
    		
    		//System.out.println("uploadURL="+uploadURL);
    		
    		
    		
    	    StringTokenizer st1=new StringTokenizer(filename,".");
    		filename=st1.nextToken();
    		fileExtension=st1.nextToken();
    	   
    		try
    		   {
    			   if (fileExtension =="doc" || fileExtension =="docx" )
    			   {
    			   response.setContentType( "application/vnd.ms-word" );
    			   }
    			   else if (fileExtension == "xls" || fileExtension == "xlsx")
    				   
    			   {
    			   response.setContentType( "application/vnd.ms-excel" );
    			   }
    			   else if (fileExtension == "pdf")
    			   {
    			   response.setContentType( "application/pdf" );
    			   }else if (fileExtension.trim().equalsIgnoreCase("txt"))
    			   {
    			   response.setContentType( "text/plain" );
    			   }else if (fileExtension.trim().equalsIgnoreCase("ppt"))
    			   {
    			   response.setContentType( "application/ppt" );
    			   }else if (fileExtension == "png" )
    			   {
    			   response.setContentType( "image/png" );
    			   }else if (fileExtension == "jpeg" )
    			   {
    				   
    			   response.setContentType( "image/jpeg" );
    			   }else if (fileExtension == "wbmp" )
    			   {
    			   response.setContentType( "image/vnd.wap.wbmp" );
    			   }else if (fileExtension == "gif" )
    			   {
    			   response.setContentType( "image/gif");
    			   }else if (fileExtension == "jpg" )
    			   {
    			   response.setContentType( "image/jpg" );
    			   }
    			   else
    			   {
    			   response.setContentType( "application/octet-stream" );
    			   }
    		   
    		   response.setHeader ("Content-Disposition", "attachment;filename="+java.net.URLEncoder.encode(request.getParameter("filename"))+"");
    		   //File f = new File(uploadURL+""+filename+"."+fileExtension);
    		   for(UploadDocuments doc: uploadDocuments)
    		   {
    			   byte[] bytes = doc.getPatientDocument();
    			   Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
    			   InputStream in = blob.getBinaryStream();
                 
    	       
    	       response.getOutputStream().flush();
    	      ServletOutputStream outs = response.getOutputStream();
    	      
    	      // Create the byte array to hold the data
        	 
        
        	     int offset = 0;
        	     int numRead = 0;
        	     while (offset < bytes.length
        	    		 && (numRead=in.read(bytes, offset, bytes.length-offset)) >= 0) {
        	    	 offset += numRead;
        	     }
        
        	     if (offset < bytes.length) {
        	     }
        	     outs.write(bytes);
        	     in.close();
    	   } 
    		   }
    	   catch (IOException ioe) 
    	   {
    		   ioe.printStackTrace();
    	   }
       
    	 
    	
    		return null;
    	}
	public ModelAndView rejectSampleHisto(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in rejectSampleHisto");
		int sampleDetailsId=0;
		int sampleHisoDetailsId=0;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		String userName="";
		int hospitalId=0;
		int deptId=0;
		String deptName="";
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
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		
		if(request.getParameter("sampleHeaderId")!=null){
			sampleDetailsId=Integer.parseInt(request.getParameter("sampleHeaderId"));
		}
		if(request.getParameter("sampleDetailsId")!=null){
			sampleHisoDetailsId=Integer.parseInt(request.getParameter("sampleDetailsId"));
		}
		Map<String,Object>map=new HashMap<String,Object>();
		Map<String,Object>mapForDs=new HashMap<String,Object>();
		Map<String,Object>patientMap=new HashMap<String,Object>();
		boolean updated=false;
		updated=investigationHandlerService.rejectSampleHisto(sampleDetailsId,sampleHisoDetailsId);
		
		
		jsp="MessageForRejectHisto.jsp";
		map.put("deptName", deptName);
		map.put("sampleCollectionDetailId",sampleDetailsId);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showPendingResultEntryOPDJsp(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in showPendingResultEntryOPDJsp");
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		Box box= HMSUtil.getBox(request);
		
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

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		
		int hinId = box.getInt("hinId");
		String RequisitionFrom = box.getString("RequisitionFrom");
		
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		mapForDs.put("hinId", hinId);
		mapForDs.put("RequisitionFrom", RequisitionFrom);
		
		detailsMap = investigationHandlerService.getDetailsForSearch(dataMap);
		patientMap = investigationHandlerService.getResultGridLab(mapForDs);
		String jsp = "pendingResultEntryOPD";
		jsp += ".jsp";
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("pendingResultEntryOPD", "map", map);
	}
	
	public ModelAndView showPendingResultEntryTemplateOPD(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in showPendingResultEntryTemplateOPD");
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		Box box= HMSUtil.getBox(request);
		
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

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		
		int hinId = box.getInt("hinId");
		String RequisitionFrom = box.getString("RequisitionFrom");
		Map<String, Object> pendingMap = new HashMap<String, Object>();
		Map<String, Object> pDataMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		pDataMap.put("deptId", deptId);
		pDataMap.put("hinId", hinId);
		pDataMap.put("hospitalId", hospitalId);
		pDataMap.put("userName", userName);
		pDataMap.put("deptName", deptName);
		pDataMap.put("hinId", hinId);
		pDataMap.put("RequisitionFrom", RequisitionFrom);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		mapForDs.put("hinId", hinId);
		mapForDs.put("RequisitionFrom", RequisitionFrom);
		pendingMap=  investigationHandlerService.getResultPendingResult(pDataMap);
		detailsMap = investigationHandlerService.getDetailsForSearch(dataMap);
		patientMap = investigationHandlerService.getResultGrid(mapForDs);
		
		
		
		String jsp = "diag_pendingResultEntryOPD.jsp";
		jsp += ".jsp";
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("pendingMap", pendingMap);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("diag_pendingResultEntryOPD", "map", map);
	}
	
	
	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForTemplteOPD(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in searchPatientForTemplteOPD");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String patientFName = "";
		String orderStatus = "";
		String adNo = "";
		String hinNo = "";
		int departmentId = 0;
		int inpatientId = 0;
		int subChargeCodeId = 0;
		int hinId = 0;
		String orderType = "";
		String RequisitionFrom="";
		int sampleCollectionDetailId = 0;
		String diagnosisNo = "";

		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		String deptName = "";
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);

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
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}

		Map<String, Object> dataMap = new HashMap<String, Object>(); 

		try {

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if(request.getParameter("RequisitionFrom")!=null && !request.getParameter("RequisitionFrom").equals("")){
				RequisitionFrom=request.getParameter("RequisitionFrom");
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !request.getParameter(INPATIENT_ID).equals("")
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
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
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
			if (request.getParameter(ORDER_STATUS) != null
					&& !(request.getParameter(ORDER_STATUS).equals("0"))) {
				orderStatus = request.getParameter(ORDER_STATUS);
				mapForDs.put("orderStatus", orderStatus);
			}
			if (request.getParameter(SAMPLE_COLLECTION_DETAIL_ID) != null
					&& !(request.getParameter(SAMPLE_COLLECTION_DETAIL_ID)
							.equals("0"))) {
				sampleCollectionDetailId = Integer.parseInt(request
						.getParameter(SAMPLE_COLLECTION_DETAIL_ID));
				mapForDs.put("sampleCollectionDetailId",
						sampleCollectionDetailId);
			}
			mapForDs.put("deptId", deptId);
			mapForDs.put("hospitalId", hospitalId);
			dataMap.put("deptId", deptId);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("userName", userName);
			dataMap.put("deptName", deptName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = investigationHandlerService.getPatientDetails(mapForDs);

		String jsp = "";
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailsList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailsList");

		}
		Map<String, Object> diagMap = new HashMap<String, Object>();
		if (sampleCollectionDetailId != 0) {

			map = investigationHandlerService.getSampleCollectionDetails(
					sampleCollectionDetailId, deptId);
			List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
			if (map.get("sampleCollectionList") != null) {
				sampleCollectionList = (List<DgSampleCollectionDetails>) map
						.get("sampleCollectionList");
			}
			DgMasInvestigation dgmasInvestigation = new DgMasInvestigation();
			Set<DgSubMasInvestigation> dgSubSet = new HashSet<DgSubMasInvestigation>();
			int invForDetail = 0;
			int inv = 0;
			String result = "";
			String resultType = "";
			String normalValue = "";
			for (DgSampleCollectionDetails dgSampleDetail : sampleCollectionList) {
				invForDetail = dgSampleDetail.getInvestigation().getId();
				normalValue = dgSampleDetail.getInvestigation()
						.getNormalValue();
				resultType = dgSampleDetail.getInvestigation()
						.getInvestigationType();
				dgSubSet = dgSampleDetail.getInvestigation().getChargeCode()
						.getDgSubMasInvestigations();
				for (DgSubMasInvestigation dgMas : dgSubSet) {
					inv = dgMas.getInvestigation().getId();
					result = dgMas.getResultType();
				}
				if (resultType.equalsIgnoreCase("m")) {
					jsp = DG_RESULT_ENTRY_MULTIPLE_PARAMETER;
				} else if (resultType.equalsIgnoreCase("s")) {
					jsp = DG_RESULT_ENTRY_SINGLE_PARAMETER_WITH_NORMAL_VALUE;
				} else if (resultType.equalsIgnoreCase("t")) {
					jsp = "diag_resultEntryForTemplateOPD";
				} else if (resultType.equalsIgnoreCase("v")) {
					detailsMap = investigationHandlerService
							.getDetails(dataMap);
					jsp = DG_RESULT_ENTRY_SENSITIVE ;
				}
			}
			String resultSeqNo = "";
			resultSeqNo = investigationHandlerService
					.generateResultNumber(diagMap);
			if (resultSeqNo != "") {
				map.put("resultSeqNo", resultSeqNo);
			}
		} else {
			detailsMap = investigationHandlerService.getDetails(dataMap);
			jsp = DG_PENDING_RESULT_ENTRY;
		}
		if (request.getParameter("browse") != null
				&& !request.getParameter("browse").equals("")) {
			map.put("browse", request.getParameter("browse"));
		}
		patientMap.put("patientList", patientList);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("dataMap", dataMap);
		map.put("deptName", deptName);
		map.put("sampleCollectionDetailId",sampleCollectionDetailId);
		map.put("RequisitionFrom",RequisitionFrom);
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView showReportForBarCodeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in showReportForBarCodeJsp");
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String deptName = "";
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
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		
		String jsp = "reportForBarCodeJsp";
		jsp += ".jsp";
		
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("patientMap", patientMap);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView  getVisitDetails(HttpServletRequest request,
	HttpServletResponse response) {
		logger.info("in getVisitDetails");
		Map<String,Object>map=new HashMap<String,Object>();
		String uhID="";
		if(request.getParameter("uhId")!=null  && !request.getParameter("uhId").equals("")){
			uhID=request.getParameter("uhId");
		}
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String deptName = "";
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
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		String jsp = "responseForVisitForBarCodePrint";
		
		map=investigationHandlerService.getVisitDetails(hospitalId,uhID);
		return new ModelAndView(jsp, "map", map);
	}
	
	
	public ModelAndView  getOrderDetails(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("in getOrderDetails");
				Map<String,Object>map=new HashMap<String,Object>();
				int visitId=0;
				if(request.getParameter("visitId")!=null  && !request.getParameter("visitId").equals("")){
					visitId=Integer.parseInt(request.getParameter("visitId"));
				}
				int deptId = 0;
				int hospitalId = 0;
				String userName = "";
				String deptName = "";
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
				if (session.getAttribute("deptName") != null) {
					deptName = (String) session.getAttribute("deptName");
				}
				int hinId=0;
				if(request.getParameter("hinId")!=null){
					hinId=(Integer.parseInt(request.getParameter("hinId")));
				}
				String jsp = "responseForVisitForBarCodePrintOrder";
				
				map=investigationHandlerService.getOrderDetails(hinId);
				return new ModelAndView(jsp, "map", map);
			}
	
	
	public ModelAndView  getSamepleDetails(HttpServletRequest request,
			HttpServletResponse response) {
		        logger.info("in getSamepleDetails");
				Map<String,Object>map=new HashMap<String,Object>();
				int orderId=0;
				if(request.getParameter("orderId")!=null  && !request.getParameter("orderId").equals("")){
					orderId=Integer.parseInt(request.getParameter("orderId"));
				}
				int deptId = 0;
				int hospitalId = 0;
				String userName = "";
				String deptName = "";
				int hinId=0;
				
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
				if (session.getAttribute("deptName") != null) {
					deptName = (String) session.getAttribute("deptName");
				}
				if(request.getParameter("hinId")!=null){
					hinId=(Integer.parseInt(request.getParameter("hinId")));
				}
				String jsp = "responseForVisitForBarCodePrintSample";
				
				map=investigationHandlerService.getSamepleDetails(orderId);
				map.put("hinId",hinId);
				map.put("orderId", orderId);
				return new ModelAndView(jsp, "map", map);
			}
	/*------------Result Entry Report-------------*/

	public ModelAndView	showResultEntryLabReportJsp(HttpServletRequest request,HttpServletResponse response){
		logger.info("in showResultEntryLabReportJsp");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session=request.getSession();
			int hospitalId = 0;
			int userId = 0;
			
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			if (session.getAttribute("userId") != null) {
				userId = (int) session.getAttribute("userId");
			}
			
			dataMap.put("hospitalId",hospitalId);
			dataMap.put("userId",userId); // added by amit das on 17-07-2017
		
		
		detailsMap = investigationHandlerService.getDetailsForSearch(dataMap);
		String jsp="resultEntryLabReport" + ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateResultEntryLabReport(HttpServletRequest request, HttpServletResponse response) {
		logger.info("in generateResultEntryLabReport");
		Date fromDate=new Date();
		Date toDate=new Date();
		String hin_no="";
	    HttpSession session=request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String reportName="diag_reslut_entry_lab";
		String patientName="";
		int mobilNo=0;
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
			mobilNo=Integer.parseInt(request.getParameter("mobilNo"));
			query+=" and cast(p.mobile_number as varchar(15)) like '"+mobilNo+"'";
		}
		if(!request.getParameter("subChargeCodeId").equals("0")){
			subChargeCodeId=Integer.parseInt(request.getParameter("subChargeCodeId"));
			query+=" and msc.sub_chargecode_id=" + subChargeCodeId;
		}
		/*if(!request.getParameter("priorityId").equals("0")){
			priorityId=request.getParameter("priorityId");
			query+=" and routine_urgent_status='"+priorityId+"'";
		}*/
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("hospitalId", hospitalId);
		parameters.put("query", query);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = investigationHandlerService.getConnectionForReport();
		
		String flag="1";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}
		if (flag.equals("1"))
		{
			HMSUtil.generateReport(reportName, parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
			
		}

		else if(flag.equals("2")) {
					HMSUtil.generateHTMLReport(reportName, parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
					
		}
		return null;
		}

	/*------------Result Validation Report-------------*/
	
	public ModelAndView	showResultValidationLabReportJsp(HttpServletRequest request,HttpServletResponse response){
		logger.info("in showResultValidationLabReportJsp");
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
		
			detailsMap = investigationHandlerService.getDetailsForSearch(map);
		String jsp="resultValidationLabReport" + ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateResultValidationLabReport(HttpServletRequest request, HttpServletResponse response) {
		logger.info("in generateResultValidationLabReport");
		Date fromDate=new Date();
		Date toDate=new Date();
		String hin_no="";
	    HttpSession session=request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String reportName="diag_reslut_validation_lab";
		String patientName="";
		Long mobilNo=0L;
		String query="";
		int hospitalId=0;
		int subChargeCodeId = 0;
		String subChargeCodeIdStr = request.getParameter("subChargeCodeId");
		
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
		
		if(subChargeCodeIdStr!=null && subChargeCodeIdStr.equals("0")){
			subChargeCodeId=Integer.parseInt(subChargeCodeIdStr);
			query+=" and msc.sub_chargecode_id=" + subChargeCodeId;
		}
	
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("hospitalId", hospitalId);
		parameters.put("query", query);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = investigationHandlerService.getConnectionForReport();
		
				
		String flag="1";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}
		if (flag.equals("1"))
		{
			HMSUtil.generateReport(reportName, parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		}

		else if(flag.equals("2")) {
					HMSUtil.generateHTMLReport(reportName, parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		}
		
		return null;
		}
	
	
	//added by govind 15-11-2016
	public ModelAndView	showLabWorkSheetReportJsp(HttpServletRequest request,HttpServletResponse response){
		logger.info("in showLabWorkSheetReportJsp");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int hospitalId = 0;
		int userId = 0;
		HttpSession session = request.getSession();
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (session.getAttribute("userId") != null) {
			userId = (int) session.getAttribute("userId");
		}
		
		dataMap.put("hospitalId",hospitalId);
		dataMap.put("userId",userId); // added by amit das on 17-07-2017
		
		detailsMap = investigationHandlerService.getDetailsForSearch(dataMap);
		String jsp="labWorkSheetReport" + ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView generateLabWorkSheetReport(HttpServletRequest request, HttpServletResponse response) {
		logger.info("in generateLabWorkSheetReport");
		Date fromDate=new Date();
		Date toDate=new Date();
		String toTime="";
		String fromTime="";
		String hin_no="";
	    HttpSession session=request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String reportName="LabWorkSheetReport";
		String patientName="";
		int mobilNo=0;
		int subChargeCodeId=0;
		String priorityId="";
		String query="";
		int hospitalId=0;
		int investId=0;
		
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
		// Added by Om Tripathi
		if(!request.getParameter(PATIENT_TYPE).equals("")){
			 String patientType=request.getParameter(PATIENT_TYPE); 
			if(patientType.equals("In Patient")){
				query+=" and p.patient_status like '%"+"In Patient"+"%'"; 
			}else if(patientType.equals("Out Patient")) {
				query+=" and p.patient_status like '%"+"Out Patient"+"%'";
			}
		}
		if(!request.getParameter("mobilNo").equals("")){
			mobilNo=Integer.parseInt(request.getParameter("mobilNo"));
			query+=" and cast(p.mobile_number as varchar(15)) like '"+mobilNo+"'";
		}
		if(!request.getParameter("subChargeCodeId").equals("0")){
			subChargeCodeId=Integer.parseInt(request.getParameter("subChargeCodeId"));
			query+=" and msc.sub_chargecode_id=" + subChargeCodeId;
		}
		
				if(!request.getParameter("investId").equals("0")){
					investId=Integer.parseInt(request.getParameter("investId"));
					query+=" and dscd.investigation_id=" + investId;
				}
				//Added by OM Tripathi 
				if(request.getParameter("fromTime") != null){
					fromTime = request.getParameter("fromTime");
				}
				if(request.getParameter("toTime") != null){
					toTime = request.getParameter("toTime");
				}
				String fDate=HMSUtil.convertDateToStringTypeDate(fromDate).substring(6,10).concat("-").concat(HMSUtil.convertDateToStringTypeDate(fromDate).substring(3,5)).concat("-").concat(HMSUtil.convertDateToStringTypeDate(fromDate).substring(0,2));
				
				String tDate=HMSUtil.convertDateToStringTypeDate(toDate).substring(6,10).concat("-").concat(HMSUtil.convertDateToStringTypeDate(toDate).substring(3,5)).concat("-").concat(HMSUtil.convertDateToStringTypeDate(toDate).substring(0,2));
				
				if(!request.getParameter("fromDate").equals("") && !request.getParameter("toTime").equals("")&&!request.getParameter("fromTime").equals("") && !request.getParameter("toTime").equals("")){
				query +="and dsch.sample_validation_date + cast(dsch.sample_validation_time as time) between (cast('"+fDate+"' as date) + cast('"+fromTime+"' as time)) and (cast('"+tDate+"' as date) + cast('"+toTime+"' as time))";
			}
		parameters.put("fromDate", HMSUtil.convertStringyyyyMMddTypeToDateType(fDate));//Added By Om Tripathi
		parameters.put("toDate", HMSUtil.convertStringyyyyMMddTypeToDateType(tDate)); 
		parameters.put("fromTime", fromTime);
		parameters.put("toTime", toTime);
		parameters.put("hospitalId", hospitalId);
		parameters.put("query", query);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = investigationHandlerService.getConnectionForReport();
		String flag="1";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}
		if (flag.equals("1"))
		{
			HMSUtil.generateReport(reportName, parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		}

		else if(flag.equals("2")) {
					HMSUtil.generateHTMLReport(reportName, parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
					
		}
		
		
		return null;
		}
	
	//added by govind 15-11-2016 end
	
	public ModelAndView validateResultEntryForTempelateLab(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("in validateResultEntryForTempelateLab");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		boolean saved = false;
		int hospitalId = 0;
		String userName = "";
		MultipartFormDataRequest mrequest = null;
		String result = "";
		Box box = HMSUtil.getBox(request);
		String jsp = "";
		String messageTOBeVisibleToTheUser = "";
		String resultNo = "";
		String CombinedIds = "";
		int sampleCollectionId = 0;
		int newSampleCollectionId = 0;
		String resultType = "";
		int deptId = 0;
		byte[] bytes = null;
		
		HttpSession session = request.getSession();

		Users users = null;
		if (session.getAttribute(USERS) != null) {
			users = (Users) session.getAttribute(USERS);
		}
	
	
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("hospitalId", hospitalId);
		}
		
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			parameterMap.put("deptId", deptId);
		}

		try {

			if (MultipartFormDataRequest.isMultipartFormData(request)) {
			

					mrequest = new MultipartFormDataRequest(request);
					if (mrequest.getParameter("test2") != null) {
						String tepmlateData = mrequest.getParameter("test2");
						InputStream fis1 = new FileInputStream(
								getServletContext().getRealPath(
										"jsp/pdf/appendingHtml.html"));
						File temprory2 = new File(getServletContext()
								.getRealPath("jsp/pdf/appendingHtml.html"));

						byte[] b1 = new byte[(int) temprory2.length()];
						int offset1 = 0;
						int numRead1 = 0;
					
							while ((offset1 < b1.length)
									&& ((numRead1 = fis1.read(b1, offset1,
											b1.length - offset1)) >= 0)) {

								offset1 += numRead1;

							}
						
						
							fis1.close();
						
						String appendedHtml = new String(b1);
						
						String finalFile = tepmlateData + "</body></html>";
						bytes = finalFile.getBytes();
						result = new String(bytes);
					}}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			int resultId=0;
			int dgresultDetailIdTemplate=0;
			
			if(null != request.getParameter("resultId")){
				resultId=Integer.parseInt(request.getParameter("resultId").trim());
			}
		
			if(null != request.getParameter("dgresultDetailIdTemplate")){
				dgresultDetailIdTemplate=Integer.parseInt(request.getParameter("dgresultDetailIdTemplate").trim());
	
			}
		
			parameterMap.put("result", result);
			parameterMap.put("resultId", resultId);
			parameterMap.put("dgresultDetailIdTemplate", dgresultDetailIdTemplate);
			map = investigationHandlerService.validateResultEntryForTempelateLab(parameterMap);

				String nextCombinedIds = "";
				
				String url = "";
				url = "/hms/hms/investigation?method=searchPatientByBackButtonLab";
				/*map.put("messageTOBeVisibleToTheUser",
						messageTOBeVisibleToTheUser);*/
				map.put("url", url);

				map.put("nextCombinedIds", nextCombinedIds);
				map.put("CombinedIds", CombinedIds);
				map.put("newSampleCollectionId", newSampleCollectionId);
				map.put("sampleCollectionId", sampleCollectionId);
				jsp = MESSAGE_FOR_RESULT_ENTRY_LAB + ".jsp";

			
		
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	

		}
	
	public void saveResultEntryToLeanCentralServer(HttpServletRequest request,
			HttpServletResponse response){
		logger.info("in saveResultEntryToLeanCentralServer");
		String result = null;
		Box box=HMSUtil.getBox(request);
		result = investigationHandlerService.saveResultEntryToLeanCentralServer(box);
		
		try{
			PrintWriter printWriter = response.getWriter();
			printWriter.write(result);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	

public ModelAndView getPendingResultEntryList(
		HttpServletRequest request, HttpServletResponse response) {
	logger.info("in getPendingResultEntryList");
	String userName = "";
	int deptId = 0;
	int hospitalId = 0;
	String deptName = "";
	int userId = 0;
	int subChargeCodeId = 0;
	int inpatientId = 0;
	int hinId = 0;
	int sampleCollectionDetailId = 0;
	int dgSampleHeaderId = 0;
	int subChargeId = 0;
	String billNo = "";
	String mobileNo = "";
	String wardName = "";
	Integer barCode = 0;
	String hinNo = null;
	Date fromDate = new Date();
	Date toDate = new Date();
	String patientFName = "";
	String orderStatus = "";
	String adNo = "";
	String patientType = "";
	String orderType = "";
	String flag = "";
	String CombinedIds = "";
	String diagnosisNo = "";
	String appendedHtml = "";
	int sampleId=0;
	String barcodetext = null;
	
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	Map<String, Object> mapForDs = new HashMap<String, Object>();
	
	
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

	if (session.getAttribute("deptName") != null) {
		deptName = (String) session.getAttribute("deptName");
	}
	
	// added by amit das on 17-07-2017
	if (session.getAttribute("userId") != null) {
		userId = (int) session.getAttribute("userId");
	}
		
	// added by amit das on 17-07-2017
	if (request.getParameter("subChargeCodeId") != null) {
		subChargeCodeId =  Integer.parseInt(request.getParameter("subChargeCodeId"));
	}
	
	
	if (request.getParameter(HIN_NO) != null
			&& !(request.getParameter(HIN_NO).equals(""))) {
		hinNo = request.getParameter(HIN_NO);
		mapForDs.put("hinNo", hinNo);
	}
	
	if (request.getParameter("patientType") != null
			&& !(request.getParameter("patientType").equals(""))) {
		patientType = request.getParameter("patientType");
		mapForDs.put("patientType", patientType);
	}
	
	
	if (request.getParameter(INPATIENT_ID) != null
			&& !(request.getParameter(INPATIENT_ID).equals("0"))
			&& !(request.getParameter(INPATIENT_ID).equals(""))) {
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
	
	if (request.getParameter(DIAGNOSIS_NO) != null
			&& !(request.getParameter(DIAGNOSIS_NO).equals(""))) {
		diagnosisNo = request.getParameter(DIAGNOSIS_NO);
		mapForDs.put("diagnosisNo", diagnosisNo);
	}

	if (request.getParameter(SUB_CHARGECODE_ID) != null
			&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
		subChargeCodeId = Integer.parseInt(request
				.getParameter(SUB_CHARGECODE_ID));
		mapForDs.put("subChargeCodeId", subChargeCodeId);
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
	if (request.getParameter(ORDER_STATUS) != null
			&& !(request.getParameter(ORDER_STATUS).equals("0"))) {
		orderStatus = request.getParameter(ORDER_STATUS);
		mapForDs.put("orderStatus", orderStatus);
	}
	if (request.getParameter(SAMPLE_COLLECTION_DETAIL_ID) != null
			&& !(request.getParameter(SAMPLE_COLLECTION_DETAIL_ID)
					.equals("0"))) {
		CombinedIds = request.getParameter(SAMPLE_COLLECTION_DETAIL_ID);
		mapForDs.put("sampleCollectionDetailId",
				sampleCollectionDetailId);
	}
	
	
	
	if (request.getParameter(BILL_NO) != null
			&& !(request.getParameter(BILL_NO).equals(""))) {
		billNo = request.getParameter(BILL_NO);
		mapForDs.put("billNo", billNo);
	}
	if (request.getParameter(MOBILE_NO) != null
			&& !(request.getParameter(MOBILE_NO).equals(""))) {
		mobileNo = request.getParameter(MOBILE_NO);
		mapForDs.put(MOBILE_NO, mobileNo);
	}
	if (request.getParameter(WARD_NAME) != null
			&& !(request.getParameter(WARD_NAME).equals(""))) {
		wardName = request.getParameter(WARD_NAME);
		mapForDs.put(WARD_NAME, wardName);
	}
	if (request.getParameter("barcodetext") != null
			&& !(request.getParameter("barcodetext")
					.equals(""))) {
		barcodetext = request.getParameter("barcodetext");
		mapForDs.put("barcodetext", barcodetext);
	}
	if(request.getParameter("sampleName")!=null && !request.getParameter("sampleName").equals("0")){
		sampleId=Integer.parseInt(request.getParameter("sampleName"));
		mapForDs.put("sampleId", sampleId);
	}
	
	hinId = box.getInt("hinId");
	String RequisitionFrom = box.getString("RequisitionFrom");
	
	
	mapForDs.put("deptId", deptId);
	dataMap.put("deptId", deptId);
	mapForDs.put(RequestConstants.HOSPITAL_ID, hospitalId);
	mapForDs.put("userId",userId); // added by amit das on 17-07-2017
	mapForDs.put("hospitalId",hospitalId);
	mapForDs.put("subChargeCodeId",subChargeCodeId); // added by amit das on 17-07-2017
	
	dataMap.put("userName", userName);
	dataMap.put("deptName", deptName);
	
	mapForDs.put("hinId", hinId);
	mapForDs.put("RequisitionFrom", RequisitionFrom);
	
	patientMap = investigationHandlerService.getResultGridLab(mapForDs);
	jsp = "responseFordiag_pendingResultEntryLab";
	
	detailsMap.put("userId",userId); // added by amit das on 17-07-2017


	map.put("deptId", deptId);
	map.put("hospitalId", hospitalId);
	map.put("userName", userName);
	map.put("deptName", deptName);
	map.put("detailsMap", detailsMap);
	map.put("patientMap", patientMap);
	// map.put("contentJsp", jsp);
	return new ModelAndView(jsp, "map", map);
	} 

public ModelAndView getPendingResultValidationList(
		HttpServletRequest request, HttpServletResponse response) {
	logger.info("in getPendingResultValidationList");
	int deptId = 0;
	int hospitalId = 0;
	String userName = "";
	String deptName = "";
	String deptType = "";
	int userId = 0;
	int subChargeCodeId = 0;
	int inpatientId = 0;
	int hinId = 0;
	int sampleCollectionDetailId = 0;
	int dgSampleHeaderId = 0;
	int subChargeId = 0;
	String billNo = "";
	String mobileNo = "";
	String wardName = "";
	Integer barCode = 0;
	String hinNo = null;
	Date fromDate = new Date();
	Date toDate = new Date();
	String patientFName = "";
	String orderStatus = "";
	String adNo = "";
	String patientType = "";
	String orderType = "";
	String flag = "";
	String CombinedIds = "";
	String diagnosisNo = "";
	String appendedHtml = "";
	int sampleId=0;
	String barcodetext = null;
	String sampleIdNo = null;
	
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	Map<String, Object> mapForDs = new HashMap<String, Object>();

	Users users = null;
	session = request.getSession();
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if (session.getAttribute(USERS) != null) {
		users = (Users) session.getAttribute(USERS);
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
	if (session.getAttribute("deptType") != null) {
		deptType = (String) session.getAttribute("deptType");
	}
	
	// added by amit das on 17-07-2017
		if (session.getAttribute("userId") != null) {
			userId = (int) session.getAttribute("userId");
		}
			
		// added by amit das on 17-07-2017
		if (request.getParameter("subChargeCodeId") != null) {
			subChargeCodeId =  Integer.parseInt(request.getParameter("subChargeCodeId"));
		}


		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}
		
		if (request.getParameter("patientType") != null
				&& !(request.getParameter("patientType").equals(""))) {
			patientType = request.getParameter("patientType");
			mapForDs.put("patientType", patientType);
		}
		
		
		if (request.getParameter(INPATIENT_ID) != null
				&& !(request.getParameter(INPATIENT_ID).equals("0"))
				&& !(request.getParameter(INPATIENT_ID).equals(""))) {
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
		
		if (request.getParameter(DIAGNOSIS_NO) != null
				&& !(request.getParameter(DIAGNOSIS_NO).equals(""))) {
			diagnosisNo = request.getParameter(DIAGNOSIS_NO);
			mapForDs.put("diagnosisNo", diagnosisNo);
		}

		if (request.getParameter(SUB_CHARGECODE_ID) != null
				&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
			subChargeCodeId = Integer.parseInt(request
					.getParameter(SUB_CHARGECODE_ID));
			mapForDs.put("subChargeCodeId", subChargeCodeId);
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
		if (request.getParameter(ORDER_STATUS) != null
				&& !(request.getParameter(ORDER_STATUS).equals("0"))) {
			orderStatus = request.getParameter(ORDER_STATUS);
			mapForDs.put("orderStatus", orderStatus);
		}
		if (request.getParameter(SAMPLE_COLLECTION_DETAIL_ID) != null
				&& !(request.getParameter(SAMPLE_COLLECTION_DETAIL_ID)
						.equals("0"))) {
			CombinedIds = request.getParameter(SAMPLE_COLLECTION_DETAIL_ID);
			mapForDs.put("sampleCollectionDetailId",
					sampleCollectionDetailId);
		}
		
		
		
		if (request.getParameter(BILL_NO) != null
				&& !(request.getParameter(BILL_NO).equals(""))) {
			billNo = request.getParameter(BILL_NO);
			mapForDs.put("billNo", billNo);
		}
		if (request.getParameter(MOBILE_NO) != null
				&& !(request.getParameter(MOBILE_NO).equals(""))) {
			mobileNo = request.getParameter(MOBILE_NO);
			mapForDs.put(MOBILE_NO, mobileNo);
		}
		if (request.getParameter(WARD_NAME) != null
				&& !(request.getParameter(WARD_NAME).equals(""))) {
			wardName = request.getParameter(WARD_NAME);
			mapForDs.put(WARD_NAME, wardName);
		}
		if (request.getParameter("barcodetext") != null
				&& !(request.getParameter("barcodetext")
						.equals(""))) {
			barcodetext = request.getParameter("barcodetext");
			mapForDs.put("barcodetext", barcodetext);
		}
		if(request.getParameter("sampleName")!=null && !request.getParameter("sampleName").equals("0")){
			sampleId=Integer.parseInt(request.getParameter("sampleName"));
			mapForDs.put("sampleId", sampleId);
		}
			
		sampleIdNo = request.getParameter("sampleId");
		if(sampleIdNo!=null && !sampleIdNo.trim().equals("")){
			mapForDs.put("sampleIdNo", sampleIdNo);
		}
	
	dataMap.put("deptId", deptId);
	mapForDs.put("deptId", deptId);
	mapForDs.put("deptType", deptType);
	mapForDs.put(HOSPITAL_ID, hospitalId);
	mapForDs.put("userId",userId); // added by amit das on 17-07-2017
	mapForDs.put("hospitalId",hospitalId);
	mapForDs.put("subChargeCodeId",subChargeCodeId); // added by amit das on 17-07-2017
	
	dataMap.put("userName", userName);
	dataMap.put(USERS, users);
	
	patientMap = investigationHandlerService
			.getResultValidationLabGrid(mapForDs);
	String jsp = "responseFordiag_pendingResultValidationLab";

	detailsMap.put("userId",userId); // added by amit das on 17-07-2017


	
	map.put("detailsMap", detailsMap);
	map.put("patientMap", patientMap);
	map.put("deptId", deptId);
	map.put("hospitalId", hospitalId);
	map.put("userName", userName);
	map.put("deptName", deptName);
	map.put("hinNo", "");
	map.put("pFirstName", "");		
	// map.put("contentJsp", jsp);
	return new ModelAndView(jsp, "map", map);
	}

public ModelAndView getResultPrintingList(HttpServletRequest request,
		HttpServletResponse response) {
	logger.info("in getResultPrintingList");
	int deptId = 0;
	int hospitalId = 0;
	String userName = "";
	String deptName = "";
	String hinNo="";
	String adNo="";
	String mobileNo = "";
	String wardName = "";
	int userId = 0;
	String toAge="";
	String fromAge="";
	String patientType = "";
	int subChargeCodeId = 0;
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
	 
	if(null !=request.getParameter("toAge") && !request.getParameter("toAge").equals("") ){
		toAge= request.getParameter("toAge");
	 }
	
	if(null !=request.getParameter("fromAge") && !request.getParameter("fromAge").equals("") ){
		fromAge= request.getParameter("fromAge");
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
	
	String barcodetext="",fromDate="",toDate="";
	if (request.getParameter("barcodetext") != null
			&& !(request.getParameter("barcodetext")
					.equals(""))) {
		barcodetext =request.getParameter("barcodetext").trim();
		mapForDs.put("barcodetext", barcodetext);
	}
	if (request.getParameter("fromDate") != null) {
		fromDate =request.getParameter("fromDate");
	}
	if (request.getParameter("toDate") != null) {
		toDate =request.getParameter("toDate");
	}
	
	// added by amit das on 17-07-2017
	if (session.getAttribute("userId") != null) {
		userId = (int) session.getAttribute("userId");
	}
		
	// added by amit das on 17-07-2017
	if (request.getParameter("subChargeCodeId") != null) {
		subChargeCodeId =  Integer.parseInt(request.getParameter("subChargeCodeId"));
	}
	
	if (request.getParameter(HIN_NO) != null
			&& !(request.getParameter(HIN_NO).equals(""))) {
		hinNo = request.getParameter(HIN_NO);
	}
	
	if (request.getParameter("patientType") != null
			&& !(request.getParameter("patientType").equals(""))) {
		patientType = request.getParameter("patientType");
	}
	
	if (request.getParameter(MOBILE_NO) != null
			&& !(request.getParameter(MOBILE_NO).equals(""))) {
		mobileNo = request.getParameter(MOBILE_NO);
	}
	if (request.getParameter(WARD_NAME) != null
			&& !(request.getParameter(WARD_NAME).equals(""))) {
		wardName = request.getParameter(WARD_NAME);
		
	}
	
	mapForDs.put("fromDate", fromDate);
	mapForDs.put("toDate", toDate);
	mapForDs.put("hospitalId", hospitalId);
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	dataMap.put("deptId", deptId);
	dataMap.put("hospitalId", hospitalId);
	dataMap.put("userName", userName);
	dataMap.put("hinNo", hinNo);
	dataMap.put("adNo", adNo);
	mapForDs.put(MOBILE_NO, mobileNo);
	mapForDs.put(WARD_NAME, wardName);
	mapForDs.put("patientType", patientType);
	

	mapForDs.put("userId",userId); // added by amit das on 17-07-2017
	mapForDs.put("subChargeCodeId",subChargeCodeId); // added by amit das on 17-07-2017
	mapForDs.put("patientFName", pFirstName);
	mapForDs.put("hinNo", hinNo);
	mapForDs.put("adNo", adNo);
	mapForDs.put("fromAge", fromAge);
	mapForDs.put("toAge", toAge);
	dataMap.put("userId", userId);
	
	
	
	patientMap = investigationHandlerService
			.getPatientDetailsForResultValidationOrderNo(mapForDs);
	
	
	String jsp = "responseFordiag_pendingResultPrintingLab";
	
	detailsMap.put("userId",userId); // added by amit das on 17-07-2017

	
	patientMap.put("userId", userId);
	detailsMap.put("userId", userId);
	map.put("patientMap", patientMap);
	map.put("detailsMap", detailsMap);
	map.put("deptId", deptId);
	map.put("hospitalId", hospitalId);
	map.put("userName", userName);
	map.put("pFirstName", pFirstName);
	map.put("barcodetext", barcodetext);
	map.put("deptName", deptName);
	map.put("fromDate",fromDate);
	map.put("toDate",toDate);
	map.put("hinNo", hinNo);
	// map.put("contentJsp", jsp);
	return new ModelAndView(jsp, "map", map);
	}
public ModelAndView showLabResultDetail(HttpServletRequest request,
		HttpServletResponse response) {
	logger.info("in showLabResultDetail");
	int deptId = 0;
	int hospitalId = 0;
	int doctorId=0;
	String userName = "";
	String deptName = "";
	String hinNo="";
	String adNo="";
	int userId = 0;
	String pFirstName="";
	HttpSession session = request.getSession(true);
	String barcodetext="",fromDate="",toDate="";
	Map<String, Object> mapForDs = new HashMap<String, Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	 if(null !=request.getParameter("deptId") && !request.getParameter("deptId").equals("") ){
		 deptId= Integer.parseInt(request.getParameter("deptId"));
		 patientMap.put("deptId", deptId);
	 }
	 if(null !=request.getParameter("hospitalId") && !request.getParameter("hospitalId").equals("") ){
		 hospitalId= Integer.parseInt(request.getParameter("hospitalId"));
		 patientMap.put("hospitalId", hospitalId);
	 }
	 if(null !=request.getParameter("doctorId") && !request.getParameter("doctorId").equals("") ){
		 doctorId= Integer.parseInt(request.getParameter("doctorId"));
		 patientMap.put("doctorId", doctorId);
	 }
	 map = investigationHandlerService
	             .getPatientDetailsForResultPrintingOnOpd(patientMap);
	 int alertSize=0;
	 if(map.get("alertSize")!=null){
		 Integer listSize=(Integer)map.get("alertSize");
		 
	 if(!listSize.equals(null)){
			 alertSize=listSize;
			 session.setAttribute("alertSize", alertSize);
	     }else{
	    	 session.setAttribute("alertSize",0);
	     }
	 }
	 List<DgResultEntryHeader> patientListResult = new ArrayList<DgResultEntryHeader>();
	 if (map.get("patientListResult") != null) {
		 patientListResult = (List<DgResultEntryHeader>) map.get("patientListResult");
		 for(DgResultEntryHeader plr:patientListResult){
			//userId= plr.getEmployee().getId();
			//patientMap.put("userId", userId);
		 }
		}
	 
	
	 
	 detailsMap = investigationHandlerService
				.getDetailsForResultValidationOnOpd(patientMap);
	 /*
	List<Patient> patientList = new ArrayList<Patient>();
	if (patientMap.get("patientDetailsList") != null) {
		patientList = (List<Patient>) patientMap.get("patientDetailsList");
	}
	detailsMap = investigationHandlerService
			.getDetailsForResultValidation(dataMap);
	
	
	
	patientMap.put("patientListResult", patientListResult);
	patientMap.put("patientList", patientList);
	
	detailsMap.put("userId", userId);
	map.put("patientMap", patientMap);
	map.put("detailsMap", detailsMap);
	map.put("deptId", deptId);
	map.put("hospitalId", hospitalId);
	map.put("userName", userName);
	map.put("pFirstName", pFirstName);
	map.put("barcodetext", barcodetext);
	map.put("deptName", deptName);
	map.put("fromDate",fromDate);
	map.put("toDate",toDate);
	map.put("hinNo", hinNo);*/
	    patientMap.put("patientListResult", patientListResult);
	    detailsMap.put("userId", userId);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("deptId", deptId);
		map.put("doctorId", doctorId);
		map.put("hospitalId", hospitalId);
	    map.put("patientListResult", patientListResult);
	    String jsp = "labPatientAlert";
	    map.put("contentJsp", jsp);
	return new ModelAndView(jsp, "map", map);	
}


public ModelAndView getResultPrintingListOnOpd(HttpServletRequest request,
		HttpServletResponse response) {
	logger.info("in getResultPrintingListOnOpd");
	int deptId = 0;
	int hospitalId = 0;
	int doctorId=0;
	String userName = "";
	String deptName = "";
	String hinNo="";
	String adNo="";
	int userId = 0;
	String pFirstName="";
	String barcodetext="",fromDate="",toDate="";
	Map<String, Object> mapForDs = new HashMap<String, Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	 if(null !=request.getParameter("deptId") && !request.getParameter("deptId").equals("") ){
		 deptId= Integer.parseInt(request.getParameter("deptId"));
		 patientMap.put("deptId", deptId);
	 }
	 if(null !=request.getParameter("hospitalId") && !request.getParameter("hospitalId").equals("") ){
		 hospitalId= Integer.parseInt(request.getParameter("hospitalId"));
		 patientMap.put("hospitalId", hospitalId);
	 }
	 if(null !=request.getParameter("doctorId") && !request.getParameter("doctorId").equals("") ){
		 doctorId= Integer.parseInt(request.getParameter("doctorId"));
		 patientMap.put("doctorId", doctorId);
	 }
	 map = investigationHandlerService
	             .getPatientDetailsForResultPrintingOnOpd(patientMap);
	 List<DgResultEntryHeader> patientListResult = new ArrayList<DgResultEntryHeader>();
	 if (map.get("patientListResult") != null) {
		 patientListResult = (List<DgResultEntryHeader>) map.get("patientListResult");
		 for(DgResultEntryHeader plr:patientListResult){
			//userId= plr.getEmployee().getId();
			//patientMap.put("userId", userId);
		 }
		}
	 
	
	 
	 detailsMap = investigationHandlerService
				.getDetailsForResultValidationOnOpd(patientMap);
	 /*
	List<Patient> patientList = new ArrayList<Patient>();
	if (patientMap.get("patientDetailsList") != null) {
		patientList = (List<Patient>) patientMap.get("patientDetailsList");
	}
	detailsMap = investigationHandlerService
			.getDetailsForResultValidation(dataMap);
	
	
	
	patientMap.put("patientListResult", patientListResult);
	patientMap.put("patientList", patientList);
	
	detailsMap.put("userId", userId);
	map.put("patientMap", patientMap);
	map.put("detailsMap", detailsMap);
	map.put("deptId", deptId);
	map.put("hospitalId", hospitalId);
	map.put("userName", userName);
	map.put("pFirstName", pFirstName);
	map.put("barcodetext", barcodetext);
	map.put("deptName", deptName);
	map.put("fromDate",fromDate);
	map.put("toDate",toDate);
	map.put("hinNo", hinNo);*/
	   patientMap.put("patientListResult", patientListResult);
	   detailsMap.put("userId", userId);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
	    map.put("patientListResult", patientListResult);
	 String jsp = "responseLabNotificationAlert";
	return new ModelAndView(jsp, "map", map);	
}
public void showLabResultDetailAlert(HttpServletRequest request,
		HttpServletResponse response) {
	logger.info("in showLabResultDetailAlert");
	int deptId = 0;
	int hospitalId = 0;
	int doctorId=0;
	String userName = "";
	String deptName = "";
	String hinNo="";
	String adNo="";
	int userId = 0;
	String pFirstName="";
	HttpSession session = request.getSession(true);
	
	Map<String, Object> mapForDs = new HashMap<String, Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	 if(null !=request.getParameter("deptId") && !request.getParameter("deptId").equals("") ){
		 deptId= Integer.parseInt(request.getParameter("deptId"));
		 patientMap.put("deptId", deptId);
	 }
	 if(null !=request.getParameter("hospitalId") && !request.getParameter("hospitalId").equals("") ){
		 hospitalId= Integer.parseInt(request.getParameter("hospitalId"));
		 patientMap.put("hospitalId", hospitalId);
	 }
	 if(null !=request.getParameter("doctorId") && !request.getParameter("doctorId").equals("") ){
		 doctorId= Integer.parseInt(request.getParameter("doctorId"));
		 patientMap.put("doctorId", doctorId);
	 }
	 map = investigationHandlerService
	             .getPatientDetailsForResultPrintingOnOpd(patientMap);
	 int alertCount=0;
	 if(map.get("alertCount")!=null){
		 Integer listSize=(Integer)map.get("alertCount");
		 
	 if(listSize!=0){
		 alertCount=listSize;
			 session.setAttribute("alertCount", alertCount);
	     }else{
	    	 session.setAttribute("alertCount",0);
	     }
	 }
	 List<DgResultEntryHeader> patientListResult = new ArrayList<DgResultEntryHeader>();
	 if (map.get("patientListResult") != null) {
		 patientListResult = (List<DgResultEntryHeader>) map.get("patientListResult");
		
		}
	    patientMap.put("alertCount", alertCount);
	    PrintWriter printWriter = null;
	    try {
		printWriter = response.getWriter();
		printWriter.print(alertCount);
	    }catch(Exception e) {
	    	logger.error(e);
	    }finally {
			if(printWriter!=null)
				printWriter.close();
		}
	    
}

}
