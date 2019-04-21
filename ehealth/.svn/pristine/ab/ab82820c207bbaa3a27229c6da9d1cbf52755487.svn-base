package jkt.hms.sysparam.controller;
import static jkt.hms.util.RequestConstants.ADDRESS;
import static jkt.hms.util.RequestConstants.PURCHASE_ORDER_CODE_VBCH;
import static jkt.hms.util.RequestConstants.PURCHASE_ORDER_CODE_RKS;
import static jkt.hms.util.RequestConstants.PURCHASE_ORDER_CODE_NURSING_COLLEGE;
import static jkt.hms.util.RequestConstants.ALLOW_DISCHRG_WITHOUT_CLRNC;
import static jkt.hms.util.RequestConstants.ALLOW_REG_FEE;
import static jkt.hms.util.RequestConstants.BILL_PRINT_TYPE;
import static jkt.hms.util.RequestConstants.BLOCK;
import static jkt.hms.util.RequestConstants.BLOOD_DON_GAP;
import static jkt.hms.util.RequestConstants.CASTE;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CITY;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.COUNTRY;
import static jkt.hms.util.RequestConstants.COUNTRY_ID;
import static jkt.hms.util.RequestConstants.CURRENCY_ID;
import static jkt.hms.util.RequestConstants.EMAIL_ID;
import static jkt.hms.util.RequestConstants.FAX_NO;
import static jkt.hms.util.RequestConstants.GRAMOPHONE_NUMBER;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.HOS_CURRENT_PARAM_JSP;
import static jkt.hms.util.RequestConstants.IDGENSEQ;
import static jkt.hms.util.RequestConstants.INCLUDE_ST;
import static jkt.hms.util.RequestConstants.IP_PAY_TYPE;
import static jkt.hms.util.RequestConstants.LANGUAGE;
import static jkt.hms.util.RequestConstants.LICENSE_CODE;
import static jkt.hms.util.RequestConstants.MAX_AGE;
import static jkt.hms.util.RequestConstants.MIN_AGE;
import static jkt.hms.util.RequestConstants.MOBILE_NO;
import static jkt.hms.util.RequestConstants.MONTH_OF_ROL;
import static jkt.hms.util.RequestConstants.OP_ON_ACCT;
import static jkt.hms.util.RequestConstants.OP_PAY_TYPE;
import static jkt.hms.util.RequestConstants.PHONE_NO;
import static jkt.hms.util.RequestConstants.PINCODE;
import static jkt.hms.util.RequestConstants.POST_OFFICE;
import static jkt.hms.util.RequestConstants.PROVISIONAL_DIAG;
import static jkt.hms.util.RequestConstants.REFERENCE;
import static jkt.hms.util.RequestConstants.REFRESH_TIME;
import static jkt.hms.util.RequestConstants.REGISTRATION_DATE;
import static jkt.hms.util.RequestConstants.REGISTRATION_NUMBER;
import static jkt.hms.util.RequestConstants.REG_CHARGE_CODE;
import static jkt.hms.util.RequestConstants.RELATION;
import static jkt.hms.util.RequestConstants.RELIGION;
import static jkt.hms.util.RequestConstants.ROL_DIVISION_FACTOR;
import static jkt.hms.util.RequestConstants.ROQ_DIVISION_FACTOR;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.SERVER_PORT_NUMBER;
import static jkt.hms.util.RequestConstants.STATE;
import static jkt.hms.util.RequestConstants.STATE_ID;
import static jkt.hms.util.RequestConstants.STD_CODE;
import static jkt.hms.util.RequestConstants.SYS_CURRENT_PARAM_JSP;
import static jkt.hms.util.RequestConstants.TRANSACTION_SEQUENCE_NUMBER;
import static jkt.hms.util.RequestConstants.TRANS_SEQ_SETUP;
import static jkt.hms.util.RequestConstants.TRANS_TABLENAME;
import static jkt.hms.util.RequestConstants.URL;
import static jkt.hms.util.RequestConstants.VERSION;
import static jkt.hms.util.RequestConstants.VISIT_CHARGE_CODE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.HospitalParameters;
import jkt.hms.masters.business.MasBlock;
import jkt.hms.masters.business.MasCaste;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasCurrency;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasLanguage;
import jkt.hms.masters.business.MasReference;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasReligion;
import jkt.hms.masters.business.MasSetupParameterMaintaince;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.Users;
import jkt.hms.sysparam.handler.SysCurrentParamHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class SysParamController extends MultiActionController {
	SysCurrentParamHandlerService sysCurrentParamHandlerService = null;

	String code = "";
	String name = "";
	int number = 0;
	String currentDate = "";
	String currentTime = "";
	String tableName = "";
	String jsp = "";
	String title = "";
	String message = " ";
	String url = "";
	String viewPage = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String revision = "";
	int id = 0;

	public void setSysCurrentParamHandlerService(
			SysCurrentParamHandlerService sysCurrentParamHandlerService) {
		this.sysCurrentParamHandlerService = sysCurrentParamHandlerService;
	}

	public ModelAndView showSysCurrentParamJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = sysCurrentParamHandlerService.getSysCurrentParamJsp();
		String jsp = SYS_CURRENT_PARAM_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showSubmitModifiedParamJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		MasSetupParameterMaintaince sysParam = new MasSetupParameterMaintaince();
		sysParam.setId(1);

		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		Users userObj = new Users();
		userObj.setId(userId);
		int fast = 0;
		int slow = 0;
		int non = 0;
		sysParam.setLastChgBy(userObj);
		Map<String, Object> valueMap = new HashMap<String, Object>();

		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);

		sysParam.setHospital(masHospital);

		Date lastChgDate = null;
		if (request.getParameter(CHANGED_DATE) != null) {
			lastChgDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
			sysParam.setLastChgDate(lastChgDate);
		}

		String lastChgTime = "";
		if (request.getParameter(CHANGED_TIME) != null) {
			lastChgTime = request.getParameter(CHANGED_TIME);
			sysParam.setLastChgTime(lastChgTime);
		}

		if ((request.getParameter(VERSION)) != " ") {
			sysParam.setVersion(request.getParameter(VERSION));
		}

		int serverPort;

		if ((serverPort = new Integer(request.getParameter(SERVER_PORT_NUMBER))) != 0) {
			sysParam.setServerPortNumber(serverPort);
		}

		int refreshTime;

		if ((refreshTime = new Integer(request.getParameter(REFRESH_TIME))) != 0) {
			sysParam.setRefreshTime(refreshTime);
		}

		int languageId;

		if ((languageId = new Integer(request.getParameter(LANGUAGE))) != 0) {
			MasLanguage language = new MasLanguage();
			language.setId(languageId);
			sysParam.setLanguage(language);
		}

		int religionId;

		if ((religionId = new Integer(request.getParameter(RELIGION))) != 0) {
			MasReligion religion = new MasReligion();
			religion.setId(religionId);
			sysParam.setReligion(religion);
		}
		int relationId;

		if ((relationId = new Integer(request.getParameter(RELATION))) != 0) {
			MasRelation relation = new MasRelation();
			relation.setId(relationId);
			sysParam.setRelation(relation);
		}
		int referenceId;

		if ((referenceId = new Integer(request.getParameter(REFERENCE))) != 0) {
			MasReference reference = new MasReference();
			reference.setId(referenceId);
			sysParam.setReference(reference);
		}
		int regChrgId;

		if ((regChrgId = new Integer(request.getParameter(REG_CHARGE_CODE))) != 0) {
			MasChargeCode regChargeCode = new MasChargeCode();
			regChargeCode.setId(regChrgId);
			sysParam.setRegChargeCode(regChargeCode);
		}
		int visitChrgId;

		if ((visitChrgId = new Integer(request.getParameter(VISIT_CHARGE_CODE))) != 0) {
			MasChargeCode visitChargeCode = new MasChargeCode();
			visitChargeCode.setId(visitChrgId);
			sysParam.setVisitChargeCode(visitChargeCode);
		}
		int minAge;

		if ((minAge = new Integer(request.getParameter(MIN_AGE))) != 0) {
			sysParam.setMinAge(minAge);
		}

		int maxAge;

		if ((maxAge = new Integer(request.getParameter(MAX_AGE))) != 0) {
			sysParam.setMaxAge(maxAge);
		}

		int bloodDonGap;
		if ((bloodDonGap = new Integer(request.getParameter(BLOOD_DON_GAP))) != 0) {
			sysParam.setBloodDonGap(bloodDonGap);
		}
		if (request.getParameter("fast") != null
				&& !request.getParameter("fast").equals("")) {
			sysParam.setFastMovingPercent(Integer.parseInt(request
					.getParameter("fast")));
		}
		if (request.getParameter("slow") != null
				&& !request.getParameter("slow").equals("")) {
			sysParam.setSlowMovingPercent(Integer.parseInt(request
					.getParameter("slow")));
		}
		if (request.getParameter("non") != null
				&& !request.getParameter("non").equals("")) {
			sysParam.setNonMovingPercent(Integer.parseInt(request
					.getParameter("non")));
		}
		{
			sysParam.setBloodDonGap(bloodDonGap);
		}
		int casteId;

		if ((casteId = new Integer(request.getParameter(CASTE))) != 0) {
			MasCaste caste = new MasCaste();
			caste.setId(casteId);
			sysParam.setCaste(caste);
		}
		int countryId;

		if ((countryId = new Integer(request.getParameter(COUNTRY))) != 0) {
			MasCountry country = new MasCountry();
			country.setId(countryId);
			sysParam.setCountry(country);
		}
		int stateId;

		if ((stateId = new Integer(request.getParameter(STATE))) != 0) {
			MasState state = new MasState();
			state.setId(stateId);
			sysParam.setState(state);
		}
		String licenseCode;
		String poAuthoritySignatory = "";
		if (request.getParameter("poAuthoritySignatory") != null
				&& !request.getParameter("poAuthoritySignatory").equals("0")) {
			poAuthoritySignatory = request.getParameter("poAuthoritySignatory");
			sysParam.setPoSignatoryOfficer(poAuthoritySignatory);
		}
		if ((licenseCode = request.getParameter(LICENSE_CODE)) != " ") {
			sysParam.setLicenseCode(licenseCode);
		}

		int monthOfRol;

		if ((monthOfRol = new Integer(request.getParameter(MONTH_OF_ROL))) != 0) {
			sysParam.setMonthOfRol(monthOfRol);
		}
		int roqDivisionFactor;

		if ((roqDivisionFactor = new Integer(
				request.getParameter(ROQ_DIVISION_FACTOR))) != 0) {
			sysParam.setRoqDivisionFactor(roqDivisionFactor);
		}

		int rolDivisionFactor;

		if ((rolDivisionFactor = new Integer(
				request.getParameter(ROL_DIVISION_FACTOR))) != 0) {
			sysParam.setRolDivisionFactor(rolDivisionFactor);
		}

		int blockId;

		if ((blockId = new Integer(request.getParameter(BLOCK))) != 0) {
			MasBlock block = new MasBlock();
			block.setId(blockId);
		 	sysParam.setBlock(block);
		}
		FileInputStream fis;
		try {
			String url = "";

			if (request.getParameter("photoUrl") != null) {
				url = request.getParameter("photoUrl");
				fis = new FileInputStream(url);
				String str = "\\";
				String fileName = url.substring(url.lastIndexOf(str) + 1);

				byte[] img = new byte[fis.available()];
				fis.read(img);
				if ((img != null) && (fis != null)) {
					sysParam.setLoginImgName(fileName);
					sysParam.setLoginImage(img);
				}
				fis.close();

			}

		} catch (FileNotFoundException e) {
			sysParam.setLoginImgName((String) session.getAttribute("imgName"));
			sysParam.setLoginImage((byte[]) session.getAttribute("image"));
		} catch (IllegalStateException e) {
			sysParam.setLoginImgName((String) session.getAttribute("imgName"));
			sysParam.setLoginImage((byte[]) session.getAttribute("image"));
		} catch (IOException e) {
			sysParam.setLoginImgName((String) session.getAttribute("imgName"));
			sysParam.setLoginImage((byte[]) session.getAttribute("image"));
		}

		valueMap.put("sysParam", sysParam);
		boolean successfullyUpdated = false;
		String message = "";
		successfullyUpdated = sysCurrentParamHandlerService
				.saveChangedSysParam(valueMap);
		if (successfullyUpdated) {
			message = " System Information Updated Successfully.";
			// JOptionPane.showMessageDialog(null, message);

		} else {
			message = "Some problem Occured! Try Again.";
		}
		String backUrl = "";
		backUrl = "/hms/hms/registration?method=showSysCurrentParamJsp";
		map.put("backUrl", backUrl);
		map = sysCurrentParamHandlerService.getSysCurrentParamJsp();
		String jsp = SYS_CURRENT_PARAM_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showHospitalParamJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = null;
		session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(session.getAttribute("hospitalId")
					.toString());
		box.put("hospitalId", hospitalId);
		map = sysCurrentParamHandlerService.getHospitalParamJsp(box);
		String jsp = HOS_CURRENT_PARAM_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitHospitalParamJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		HospitalParameters hospParam = new HospitalParameters();
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		Users userObj = new Users();
		userObj.setId(userId);
		hospParam.setLastChangedBy(userObj);
		Map<String, Object> valueMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(session.getAttribute("hospitalId")
					.toString());
		box.put("hospitalId", hospitalId);


		if (request.getParameter("DA") != null
				&& !request.getParameter("DA").equals("0")) {
			int hospId = Integer.parseInt(request.getParameter("DA"));
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospId);
			hospParam.setHospital(masHospital);
			valueMap.put("hospId", hospId);
		}
		Date lastChgDate = null;
		if (request.getParameter(CHANGED_DATE) != null
				&& !request.getParameter(CHANGED_DATE).equals("")) {
			lastChgDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
			hospParam.setLastChangedDate(lastChgDate);
		}

		String lastChgTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !request.getParameter(CHANGED_TIME).equals("")) {
			lastChgTime = request.getParameter(CHANGED_TIME);
			hospParam.setLastChangedTime(lastChgTime);
		}
		String address = "";
		if (request.getParameter(ADDRESS) != ""
				&& request.getParameter(ADDRESS) != null) {
			address = request.getParameter(ADDRESS);

		}
		hospParam.setAddressLine1(address);
		String cityId = "";
		if (request.getParameter(CITY) != null
				&& !request.getParameter(CITY).equals("0")
				&& !request.getParameter(CITY).equals("")) {
			cityId = request.getParameter(CITY);
			MasDistrict district = new MasDistrict();
			district.setId(new Integer(cityId));
			hospParam.setCity(district);
		}
		String stateId = "";
		if (request.getParameter(STATE_ID) != null
				&& !request.getParameter(STATE_ID).equals("")
				&& !request.getParameter(STATE_ID).equals("0")) {
			stateId = request.getParameter(STATE_ID);
			MasState state = new MasState();
			state.setId(new Integer(stateId));
			hospParam.setState(state);
		}
		String countryId = "";
		if (request.getParameter(COUNTRY_ID) != null
				&& !request.getParameter(COUNTRY_ID).equals("")
				&& !request.getParameter(COUNTRY_ID).equals("0")) {
			countryId = request.getParameter(COUNTRY_ID);

			MasCountry country = new MasCountry();
			country.setId(new Integer(countryId));
			hospParam.setCountry(country);
		}
		String pincode = "";
		if (request.getParameter(PINCODE) != ""
				&& request.getParameter(PINCODE) != null) {
			pincode = request.getParameter(PINCODE);

		}
		hospParam.setPinCode(pincode);
		String currencyId = "";
		if (request.getParameter(CURRENCY_ID) != null
				&& !(request.getParameter(CURRENCY_ID).equals("0"))
				&& !request.getParameter(CURRENCY_ID).equals("")) {
			currencyId = request.getParameter(CURRENCY_ID);
			MasCurrency currency = new MasCurrency();
			currency.setId(new Integer(currencyId));
			hospParam.setCurrency(currency);
		}
		String mobileNo = "";
		if (request.getParameter(MOBILE_NO) != null
				&& !request.getParameter(MOBILE_NO).equals("")) {
			mobileNo = request.getParameter(MOBILE_NO);

		}
		hospParam.setMobileNumber(mobileNo);
		String stdCode = "";
		if (request.getParameter(STD_CODE) != null
				&& !request.getParameter(STD_CODE).equals("")) {
			stdCode = request.getParameter(STD_CODE);

		}
		hospParam.setStdCode(stdCode);
		String faxNo = "";
		if (request.getParameter(FAX_NO) != null
				&& !request.getParameter(FAX_NO).equals("")) {
			faxNo = request.getParameter(FAX_NO);

		}
		hospParam.setFaxNumber(faxNo);
		String emailId = "";
		if (request.getParameter(EMAIL_ID) != null
				&& !request.getParameter(EMAIL_ID).equals("")) {
			emailId = request.getParameter(EMAIL_ID);

		}
		hospParam.setEMail(emailId);
		String gramPh = "";
		if (request.getParameter(GRAMOPHONE_NUMBER) != null
				&& !request.getParameter(GRAMOPHONE_NUMBER).equals("")) {
			gramPh = request.getParameter(GRAMOPHONE_NUMBER);

		}
		hospParam.setGramophoneNumber(gramPh);
		String url = "";
		if (request.getParameter(URL) != null
				&& !request.getParameter(URL).equals("")) {
			url = request.getParameter(URL);

		}
		hospParam.setUrl(url);
		String phoneNo = "";
		if (request.getParameter(PHONE_NO) != null
				&& !request.getParameter(PHONE_NO).equals("")) {
			phoneNo = request.getParameter(PHONE_NO);

		}
		hospParam.setPhoneNumber(phoneNo);
		String alowOpOnAcc = "";
		if ((alowOpOnAcc = request.getParameter(OP_ON_ACCT)) != null) {
			hospParam.setOpOnAcct(1);
		} else {
			hospParam.setOpOnAcct(0);
		}

		String alowDetlBilPrint = "";

		if ((alowDetlBilPrint = request.getParameter(BILL_PRINT_TYPE)) != null) {
			hospParam.setBillPrintType(1);
		} else {
			hospParam.setBillPrintType(0);
		}

		String provDiagMust = "";
		if ((provDiagMust = request.getParameter(PROVISIONAL_DIAG)) != null) {
			hospParam.setProvDiagMust(1);
		} else {
			hospParam.setProvDiagMust(0);
		}

		String alowRegFee = "";
		if ((alowRegFee = request.getParameter(ALLOW_REG_FEE)) != null) {
			hospParam.setAllowRegFee(1);
		} else {
			hospParam.setAllowRegFee(0);
		}

		String alowDischrg = "";
		if ((alowDischrg = request.getParameter(ALLOW_DISCHRG_WITHOUT_CLRNC)) != null) {
			hospParam.setAllowDischrgWithoutClrnc(1);
		} else {
			hospParam.setAllowDischrgWithoutClrnc(0);
		}

		String alowSalTx = "";
		if ((alowSalTx = request.getParameter(INCLUDE_ST)) != null) {
			hospParam.setIncludeSt(1);
		} else {
			hospParam.setIncludeSt(0);
		}

		String regNo = "";
		if ((regNo = request.getParameter(REGISTRATION_NUMBER)) != null) {
			hospParam.setRegistrationNumber(regNo);
		}

		String regDate = "";
		if (request.getParameter(REGISTRATION_DATE) != null
				&& !request.getParameter(REGISTRATION_DATE).equals("")) {
			regDate = request.getParameter(REGISTRATION_DATE);
			Date frmDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(REGISTRATION_DATE));
			hospParam.setRegistrationDate(frmDate);
		}

		if (((request.getParameter(IP_PAY_TYPE)) != null)
				&& ((request.getParameter(IP_PAY_TYPE)).equals("y"))) {
			hospParam.setIpPayType(1);
		} else {
			hospParam.setIpPayType(0);
		}

		if (((request.getParameter(OP_PAY_TYPE)) != null)
				&& ((request.getParameter(OP_PAY_TYPE)).equals("y"))) {
			hospParam.setOpPayType(1);
		} else {
			hospParam.setOpPayType(0);
		}
		//String blockAndPostOffice="";
		if (((request.getParameter(BLOCK)) != null)
				&& ((request.getParameter(BLOCK)).equalsIgnoreCase("on"))) {
			hospParam.setBlock("Y");
		} else {
			hospParam.setBlock("N");
		}
		if (((request.getParameter(POST_OFFICE)) != null)
				&& ((request.getParameter(POST_OFFICE)).equalsIgnoreCase("on"))) {
			hospParam.setPostOffice("Y");
		} else {
			hospParam.setPostOffice("N");
		}
		int deptIdStoreCodeVBCH=0;
		if (request.getParameter(PURCHASE_ORDER_CODE_VBCH) != null
				&& !request.getParameter(PURCHASE_ORDER_CODE_VBCH).equals("")) {

			deptIdStoreCodeVBCH= Integer.parseInt(request.getParameter(PURCHASE_ORDER_CODE_VBCH));
		}
		hospParam.setDeptIdStoreCodeVBCH(deptIdStoreCodeVBCH);
		
		/*
		 * Added By Ujjwal For New Stores for  Nursing College Silvassa
		 */
		int deptIdStoreCodeNursingCollege=0;
		if (request.getParameter(PURCHASE_ORDER_CODE_NURSING_COLLEGE) != null
				&& !request.getParameter(PURCHASE_ORDER_CODE_NURSING_COLLEGE).equals("")) {

			deptIdStoreCodeNursingCollege= Integer.parseInt(request.getParameter(PURCHASE_ORDER_CODE_NURSING_COLLEGE));
		}
		hospParam.setDeptIdStoreCodeNursingCollege(deptIdStoreCodeNursingCollege);

		/*
		 * Ended By Ujjwal
		 */
		
		int deptIdStoreCodeRKS=0;
		if (request.getParameter(PURCHASE_ORDER_CODE_RKS) != null
				&& !request.getParameter(PURCHASE_ORDER_CODE_RKS).equals("")) {
			deptIdStoreCodeRKS= Integer.parseInt(request.getParameter(PURCHASE_ORDER_CODE_RKS));
		}
		hospParam.setDeptIdStoreCodeRKS(deptIdStoreCodeRKS);
		if (request.getParameter("hospitalParamId") != null
				&& !request.getParameter("hospitalParamId").equals("")) {
			hospParam.setId(Integer.parseInt(request
					.getParameter("hospitalParamId")));
		}

		if (request.getParameter("allowOpAdvance") != null) {
			hospParam.setAllowOpAdvance(1);
		} else {
			hospParam.setAllowOpAdvance(0);
		}

		if (request.getParameter("nursingCareCalculation") != null) {
			hospParam.setNursingCareCalculation("y");
		} else {
			hospParam.setNursingCareCalculation("n");
		}

		if (request.getParameter("dailyChargeCalculation") != null) {
			hospParam.setDailyChargeCalculation("y");
		} else {
			hospParam.setDailyChargeCalculation("n");
		}

		if (request.getParameter("calcType") != null) {
			hospParam.setChargeCalculationType(request.getParameter("calcType"));
		}
		if (request.getParameter("calculationTime") != null) {
			hospParam.setCalculationTime(request.getParameter("calculationTime"));
		}
		if (request.getParameter("dietScheduling") != null) {
			hospParam.setDietScheduling("y");
		} else {
			hospParam.setDietScheduling("n");
		}

		valueMap.put("hospParam", hospParam);
		boolean successfullyUpdated = false;
		String message = "";
		map = sysCurrentParamHandlerService
				.saveHospitalParam(valueMap);
		if(map.get("updatedSuccessfully")!= null){
			successfullyUpdated = (Boolean)map.get("updatedSuccessfully");
		}
		if (request.getParameter("hospitalParamId") != null
				&& !request.getParameter("hospitalParamId").equals("")) {
			message = " Hospital Information Updated Successfully.";
		} else {
			message = "Hospital Information Saved Successfully.";
		}
		// String backUrl = "";
		// backUrl = "/hms/hms/registration?method=showSysCurrentParamJsp";
		// map.put("backUrl", backUrl);

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		if (request.getParameter("DA") != null
				&& !request.getParameter("DA").equals("0")) {
			map.put("masHospitalId",
					Integer.parseInt(request.getParameter("DA")));
		}
		try {
			map = sysCurrentParamHandlerService.getHospitalParamJsp(box);
			map.putAll(sysCurrentParamHandlerService.getHospitalDetails(box));

		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = HOS_CURRENT_PARAM_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);

		return new ModelAndView("index", "map", map);

	}

	public ModelAndView getHospitalDetails(HttpServletRequest request,
			HttpServletResponse respomse) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int deptId = 0;
		int hospitalId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		Box box = HMSUtil.getBox(request);

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		if (request.getParameter("DA") != null
				&& !request.getParameter("DA").equals("0")) {
			map.put("masHospitalId",
					Integer.parseInt(request.getParameter("DA")));
		}
		try {
			map = sysCurrentParamHandlerService.getHospitalParamJsp(box);
			map.putAll(sysCurrentParamHandlerService.getHospitalDetails(box));

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (request.getParameter("DA") != null
				&& !request.getParameter("DA").equals("0")) {
			map.put("masHospitalId",
					Integer.parseInt(request.getParameter("DA")));
		}
		String jsp = "hospitalParam.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showTransactionSeqSetupJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = sysCurrentParamHandlerService.getTransactionSeqSetupJsp();
		String jsp = TRANS_SEQ_SETUP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchTransSeqSetupList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String transactionSqName = null;
		String transactionPrefix = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			transactionSqName = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			transactionPrefix = request.getParameter(SEARCH_NAME);
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
			transactionPrefix = searchField;
			transactionSqName = null;

		} else {
			transactionPrefix = null;
			transactionSqName = searchField;
		}
		map = sysCurrentParamHandlerService.getSearchTransSeqSetupJSP(
				transactionSqName, transactionPrefix);
		String jsp = TRANS_SEQ_SETUP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("search", "search");
		// map.put("contentJsp",jsp);
		// map.put("title", title);
		map.put("transactionSqName", transactionSqName);
		map.put("transactionPrefix", transactionPrefix);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addTransactionSq(HttpServletRequest request,
			HttpServletResponse respomse) {
		Map<String, Object> map = new HashMap<String, Object>();
		TransactionSequence transactionSequence = new TransactionSequence();
		String changedBy = "";
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		Users userObj = new Users();
		userObj.setId(userId);

		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(TRANSACTION_SEQUENCE_NUMBER) != null) {
			number = new Integer(
					request.getParameter(TRANSACTION_SEQUENCE_NUMBER));
		}
		if (request.getParameter(TRANS_TABLENAME) != null) {
			tableName = request.getParameter(TRANS_TABLENAME);
		}
		if (request.getParameter(IDGENSEQ) != null) {
			revision = request.getParameter(IDGENSEQ);
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

		generalMap.put("name", name);
		generalMap.put("code", code);
		generalMap.put("tableName", tableName);
		generalMap.put("number", number);
		generalMap.put("revision", revision);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = sysCurrentParamHandlerService
				.checkForExistingTransSq(generalMap);

		List transactionSeqPrefixList = new ArrayList();
		List transactionSeqNameList = new ArrayList();

		if (listMap.get("duplicateTransPrefixList") != null) {
			transactionSeqPrefixList = (List) listMap
					.get("duplicateTransPrefixList");
		}
		if (listMap.get("duplicateTransNameList") != null) {
			transactionSeqNameList = (List) listMap
					.get("duplicateTransNameList");
		}
		boolean successfullyAdded = false;

		if ((transactionSeqPrefixList.size() == 0 || transactionSeqPrefixList == null)
				&& (transactionSeqNameList.size() == 0 || transactionSeqNameList == null)) {
			transactionSequence.setTransactionPrefix(code);
			transactionSequence.setTransactionSequenceName(name);
			transactionSequence.setTransactionSequenceNumber(number);
			transactionSequence.setTablename(tableName);
			transactionSequence.setStatus("y");
			//commented for maven
			/*transactionSequence.setCreatedbyId(new Integer(userId));*/
			transactionSequence.setLastChgDate(currentDate);
			transactionSequence.setLastChgTime(currentTime);
			transactionSequence.setIdGenSeq(revision);
			successfullyAdded = sysCurrentParamHandlerService
					.addTransactionSeq(transactionSequence);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((transactionSeqPrefixList.size() != 0 || transactionSeqPrefixList != null)
				|| (transactionSeqNameList.size() != 0)
				|| transactionSeqNameList != null) {
			if ((transactionSeqPrefixList.size() != 0 || transactionSeqPrefixList != null)
					&& (transactionSeqNameList.size() == 0 || transactionSeqNameList == null)) {
				message = "Already exists.";
			} else if ((transactionSeqNameList.size() != 0 || transactionSeqNameList != null)
					&& (transactionSeqPrefixList.size() == 0 || transactionSeqPrefixList == null)) {
				message = "Name already exists.";
			} else if ((transactionSeqPrefixList.size() != 0 || transactionSeqPrefixList != null)
					&& (transactionSeqNameList.size() != 0 || transactionSeqNameList != null)) {
				message = "Code and Name already exist.";
			}
		}
		url = "/hms/eha/sysParam?method=showTransactionSeqSetupJsp";
		try {
			map = sysCurrentParamHandlerService.getTransactionSeqSetupJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = TRANS_SEQ_SETUP;
		title = "Add Transaction Sequence No";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editTransactionSq(HttpServletRequest request,
			HttpServletResponse respomse) {
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		session = request.getSession();

		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		String userName = user.getUserName();
		Users userObj = new Users();
		userObj.setId(userId);

		String transactionSqPrefix = "";
		String transactionSqName = "";
		int transactionSqId = 0;
		int changedBy = 0;
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			transactionSqId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			transactionSqPrefix = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			transactionSqName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(TRANSACTION_SEQUENCE_NUMBER) != null) {
			number = new Integer(
					request.getParameter(TRANSACTION_SEQUENCE_NUMBER));
		}
		if (request.getParameter(TRANS_TABLENAME) != null) {
			tableName = request.getParameter(TRANS_TABLENAME);
		}
		if (request.getParameter(IDGENSEQ) != null) {
			revision = request.getParameter(IDGENSEQ);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			if (request.getParameter(CHANGED_BY).equals(userName)) {
				changedBy = userId;
			}
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
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
		generalMap.put("id", transactionSqId);
		generalMap.put("transactionSqPrefix", transactionSqPrefix);
		generalMap.put("transactionSqName", transactionSqName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("tableName", tableName);
		generalMap.put("number", number);
		generalMap.put("revision", revision);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		// Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = sysCurrentParamHandlerService
				.checkForExistingTransSq(generalMap);
		List existingTransactionSqNoList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingTransactionSqNoList.size() == 0) {

			dataUpdated = sysCurrentParamHandlerService
					.editTransactionNoToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingTransactionSqNoList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/sysParam?method=showTransactionSeqSetupJsp";
		try {
			map = sysCurrentParamHandlerService.getTransactionSeqSetupJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = TRANS_SEQ_SETUP;
		title = "Update Transaction Seq No";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteTransactionSq(HttpServletRequest request,
			HttpServletResponse respomse) {
		return null;
	}
}
