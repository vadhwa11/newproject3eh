package jkt.hrms.masters.controller;

import static jkt.hrms.util.HrmsRequestConstants.*;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_DATE;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_TIME;
import static jkt.hrms.util.HrmsRequestConstants.CODE;
import static jkt.hrms.util.HrmsRequestConstants.COMMON_ID;
import static jkt.hrms.util.HrmsRequestConstants.HR_ETRAVEL_MASTER_JSP;
import static jkt.hrms.util.HrmsRequestConstants.SEARCH_NAME;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasCurrency;
import jkt.hms.masters.business.MasGrade;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.Users;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.MstrCode;
import jkt.hrms.masters.business.MstrStandardAllowance;
import jkt.hrms.masters.handler.EtravelMasterHandlerService;
import jkt.hrms.masters.handler.HrmsCommonMasterHandlerService;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ETravelMasterController extends MultiActionController {
	EtravelMasterHandlerService etravelMasterHandlerService = null;
	HrmsCommonMasterHandlerService hrmsCommonMasterHandlerService=null;
	
	public EtravelMasterHandlerService getEtravelMasterHandlerService() {
		return etravelMasterHandlerService;
	}

	public void setEtravelMasterHandlerService(EtravelMasterHandlerService etravelHandlerService) {
		this.etravelMasterHandlerService = etravelHandlerService;
	}

	public HrmsCommonMasterHandlerService getHrmsCommonMasterHandlerService() {
		return hrmsCommonMasterHandlerService;
	}
	public void setHrmsCommonMasterHandlerService(HrmsCommonMasterHandlerService hrmsCommonMasterHandlerService) {
		this.hrmsCommonMasterHandlerService = hrmsCommonMasterHandlerService;
	}

	HttpSession session = null;
	Map<String, Object> map = new HashMap<String, Object>();
	String jsp="";
	String title="";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String userName = "";
	String currentDate = "";
	String currentTime = "";
	String message = "";
	String code = "";
	String name = "";
	String changedBy =""; 
	String jspName = "";
	String url="";
	
	@SuppressWarnings("unchecked")
	public ModelAndView showExpenseHeadMasterJsp(HttpServletRequest request,HttpServletResponse response) {
		Map map = new HashMap();
		map = etravelMasterHandlerService.showETravelMasterJsp();
		String jsp=HR_ETRAVEL_MASTER_JSP;
		jsp += ".jsp";
		title = "ETravel Master";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index","map",map);
	}

	public ModelAndView searchExpenseHead(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String expenseCode  = null;
		String expenseDesc = null;

		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			expenseCode = request.getParameter(CODE);
		}

		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			expenseDesc = request.getParameter(SEARCH_NAME);
		}

		int searchRadio=1;
		try{
			if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))){
				searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

		if(searchRadio==1){
			expenseCode = searchField;
			expenseDesc = null;

		}else{
			expenseCode=null;
			expenseDesc=searchField;
		}
		map = etravelMasterHandlerService.searchExpenseHead(expenseCode, expenseDesc);

		String jsp=HR_ETRAVEL_MASTER_JSP;
		jsp += ".jsp";
		map.put("search","search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("expenseCode",expenseCode);
		map.put("expenseDesc",expenseDesc);
		return new ModelAndView("index","map",map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView addExpenseHead(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MstrCode mstrCode = new MstrCode();
		session=request.getSession(true);
		
		String comments ="";
		Integer changedBy = 0;
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		
		if(session.getAttribute("userId") != null){
			changedBy = (Integer)session.getAttribute("userId");
		}

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(COMMENTS) != null) {
			comments = request.getParameter(COMMENTS);
		}
		String fiftyPercentExpnse = "";
		if (request.getParameter("fiftyPercentExpnse")!= null) {
			fiftyPercentExpnse = "y";
		}else {
			fiftyPercentExpnse = "n";
		}
/*		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = Integer.parseInt(request.getParameter(CHANGED_BY));
		}*/
/*		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}*/
/*		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}*/
		
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter("pojoName") != null){
			pojoName = request.getParameter("pojoName"); 
		}
		if(request.getParameter("pojoPropertyName") != null){
			pojoPropertyName = request.getParameter("pojoPropertyName"); 
		}
		if(request.getParameter("pojoPropertyCode") != null){
			pojoPropertyCode = request.getParameter("pojoPropertyCode"); 
		}
		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = hrmsCommonMasterHandlerService.checkForExistingMasters(generalMap);
		List expenseCodeList = new ArrayList();
		List expenseHeadList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			expenseCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			expenseHeadList = (List)listMap.get("duplicateGeneralNameList");
		}
		
		boolean successfullyAdded = false;
		if((expenseCodeList.size() == 0 || expenseCodeList == null) && (expenseHeadList.size() == 0 || expenseHeadList== null)) {
			
			mstrCode.setExpenseCode(code);
			mstrCode.setCodeType("ExpType");
			mstrCode.setCodeDesc(name);
			mstrCode.setCodeRemarks(comments);
			mstrCode.setFiftyPercentExpensePaid(fiftyPercentExpnse);
			
			mstrCode.setStatus("y");

			Users users = new Users();
			users.setId(changedBy);
			mstrCode.setLastChgBy(users);

			mstrCode.setLastChgDate(currentDate);
			mstrCode.setLastChgTime(currentTime);
			successfullyAdded = etravelMasterHandlerService.addExpenseHead(mstrCode);		

			if(successfullyAdded) {
				message="Record Added Successfully !!";
			} else {
     			message="Try Again !!";
			}
		}

		else if((expenseCodeList.size() != 0 || expenseCodeList != null) || (expenseHeadList.size() != 0) || expenseHeadList != null){

			if((expenseCodeList.size() != 0 || expenseCodeList != null) && (expenseHeadList.size() == 0 ||	expenseHeadList == null)){
				message = "Expense Code  already exists.";
			} else if((expenseHeadList.size() != 0 || expenseHeadList != null) && (expenseCodeList.size() == 0 || expenseCodeList == null) ){
				message = "Expense Head  already exists.";
			} else if((expenseCodeList.size() != 0 || expenseCodeList != null) && (expenseHeadList.size() != 0 || expenseHeadList != null)){
				message = "Expense Code and Expense Head already exist.";
			}
		}

		url = "/hms/hrms/eTravelMaster?method=showExpenseHeadMasterJsp";
		
			try{
				map = etravelMasterHandlerService.showETravelMasterJsp();
			}catch (Exception e) {
				   e.printStackTrace();
			}
			map = etravelMasterHandlerService.showETravelMasterJsp();
			String jsp=HR_ETRAVEL_MASTER_JSP;
			jsp += ".jsp";
			title = "ETravel Master";		
			map.put("contentJsp", jsp);
			map.put("message", message);
			map.put("title", title);
			return new ModelAndView("index","map",map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView editExpenseHead(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession(true);
		
		String expenseCode="";
		String expenseHead="";
		int mstrCodeId=0;
		int changedBy = 0;
		String comments = "";
		Date changedDate = null;
		String changedTime = "";
		if(session.getAttribute("userId") != null){
			changedBy = (Integer)session.getAttribute("userId");
		}

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			mstrCodeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			expenseCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			expenseHead = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(COMMENTS) != null) {
			comments = request.getParameter(COMMENTS);
		}
		String fiftyPercentExpnse = "";
		if (request.getParameter("fiftyPercentExpnse")!= null) {
			fiftyPercentExpnse = "y";
		}else {
			fiftyPercentExpnse = "n";
		}
/*		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = Integer.parseInt(request.getParameter(CHANGED_BY));
		}*/
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter("pojoPropertyName") != null){
			pojoPropertyName = request.getParameter("pojoPropertyName"); 
		}
		if(request.getParameter("pojoName") != null){
			pojoName = request.getParameter("pojoName"); 
		}
		changedDate = new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", mstrCodeId);
		generalMap.put("expenseCode", expenseCode);
		generalMap.put("name", expenseHead);
		generalMap.put("comments", comments);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		generalMap.put("fiftyPercentExpnse", fiftyPercentExpnse);

		listMap = hrmsCommonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingExpenseHeadList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingExpenseHeadList.size() == 0)
		{

		dataUpdated=etravelMasterHandlerService.editExpenseHead(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
		} 
		else if(existingExpenseHeadList.size() > 0){

			message = "Name already exists.";
		}
		
		url = "/hms/hrms/eTravelMaster?method=showExpenseHeadMasterJsp";
		
		try{
			map = etravelMasterHandlerService.showETravelMasterJsp();
		}catch (Exception e) {
			   e.printStackTrace();
		}
		map = etravelMasterHandlerService.showETravelMasterJsp();
		String jsp=HR_ETRAVEL_MASTER_JSP;
		jsp += ".jsp";
		title = "ETravel Master";		
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("title", title);
		return new ModelAndView("index","map",map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView deleteExpenseHead(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		
		session=request.getSession(true);
		int mstrCodeId=0;
		String message=null;
		int changedBy = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(session.getAttribute("userId") != null){
			changedBy = (Integer)session.getAttribute("userId");
		}

		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			mstrCodeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
/*		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = Integer.parseInt(request.getParameter(CHANGED_BY));
		}*/
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=etravelMasterHandlerService.deleteExpenseHead(mstrCodeId,generalMap);
		if (dataDeleted==true) {
			message="Record is InActivated successfully !!";
		} else {
			message="Record is Activated successfully !!";
		}
		url = "/hms/hrms/eTravelMaster?method=showExpenseHeadMasterJsp";
		
		try{
			map = etravelMasterHandlerService.showETravelMasterJsp();
		}catch (Exception e) {
			   e.printStackTrace();
		}
		map = etravelMasterHandlerService.showETravelMasterJsp();
		String jsp=HR_ETRAVEL_MASTER_JSP;
		jsp += ".jsp";
		title = "ETravel Master";		
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("url", url);
		map.put("title", title);
		return new ModelAndView("index","map",map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView showStandardAllowanceMasterJsp(HttpServletRequest request,HttpServletResponse response) {
		Map map = new HashMap();
		map = etravelMasterHandlerService.showStandardAllowanceMasterJsp();
		String jsp=HR_STANDARD_ALLOWANCE_MASTER;
		jsp += ".jsp";
		title = "standard Allowance Master";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index","map",map);
	}
	public ModelAndView searchStandardAllowance(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String standardAllowanceCode  = null;
		String standardAllowanceDesc = null;

		String searchField= null;

		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			standardAllowanceCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			standardAllowanceDesc = request.getParameter(SEARCH_NAME);
		}
		int searchRadio=1;
		try{
			if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))){
				searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

		if(searchRadio==1){
			standardAllowanceCode = searchField;
			standardAllowanceDesc = null;

		}else{
			standardAllowanceCode=null;
			standardAllowanceDesc=searchField;
		}
		map = etravelMasterHandlerService.searchStandardAllowance(standardAllowanceCode, standardAllowanceDesc);

		String jsp=HR_STANDARD_ALLOWANCE_MASTER;
		jsp += ".jsp";
		map.put("search","search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("standardAllowanceCode",standardAllowanceCode);
		map.put("standardAllowanceDesc",standardAllowanceDesc);
		return new ModelAndView("index","map",map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView addStandardAllowance(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map=new HashMap<String,Object>();
		MstrStandardAllowance mstrStandardAllowance = new MstrStandardAllowance();
		session=request.getSession(true);
		
		Integer changedBy = 0;
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int rankId = 0;
		int expenseType = 0;
		int trip = 0;
		int currency = 0;
		String districtType = "";
		BigDecimal amount = BigDecimal.ZERO;
		
		if(session.getAttribute("userId") != null){
			changedBy = (Integer)session.getAttribute("userId");
		}
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DESIGNATION_ID) != null && !request.getParameter(DESIGNATION_ID).equals("")) {
			rankId = Integer.parseInt(request.getParameter(DESIGNATION_ID));
		}
		if (request.getParameter(EXPENSE_TYPE) != null && !request.getParameter(EXPENSE_TYPE).equals("")) {
			expenseType = Integer.parseInt(request.getParameter(EXPENSE_TYPE));
		}
		if (request.getParameter(TRIP) != null && !request.getParameter(TRIP).equals("")) {
			trip = Integer.parseInt(request.getParameter(TRIP));
		}
		if (request.getParameter(DISTRICT_TYPE) != null && !request.getParameter(DISTRICT_TYPE).equals("")) {
			districtType = request.getParameter(DISTRICT_TYPE);
		}
		if (request.getParameter(CURRENCY_ID) != null && !request.getParameter(CURRENCY_ID).equals("")) {
			currency = Integer.parseInt(request.getParameter(CURRENCY_ID));
		}
		if (request.getParameter(AMOUNT) != null && !request.getParameter(AMOUNT).equals("")) {
			amount = new BigDecimal(request.getParameter(AMOUNT));
		}

		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter("pojoName") != null){
			pojoName = request.getParameter("pojoName"); 
		}
		if(request.getParameter("pojoPropertyName") != null){
			pojoPropertyName = request.getParameter("pojoPropertyName"); 
		}
		if(request.getParameter("pojoPropertyCode") != null){
			pojoPropertyCode = request.getParameter("pojoPropertyCode"); 
		}
		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = hrmsCommonMasterHandlerService.checkForExistingMasters(generalMap);
		List standardAllowanceCodeList = new ArrayList();
		List expenseHeadList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			standardAllowanceCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			expenseHeadList = (List)listMap.get("duplicateGeneralNameList");
		}
		
		boolean successfullyAdded = false;
		if((standardAllowanceCodeList.size() == 0 || standardAllowanceCodeList == null) && (expenseHeadList.size() == 0 || expenseHeadList== null)) {
			mstrStandardAllowance.setAllowanceCode(code);
			mstrStandardAllowance.setAllowanceDesc(name);
			
			MasRank masRank = new MasRank();
			masRank.setId(rankId);
			mstrStandardAllowance.setRank(masRank);
			
			MstrCode mstrCode = new MstrCode();
			mstrCode.setId(expenseType);
			mstrStandardAllowance.setExpenseType(mstrCode);
			
			MstrCode mstrCodeForTrip = new MstrCode();
			mstrCodeForTrip.setId(trip);
			mstrStandardAllowance.setTrip(mstrCodeForTrip);

			MasCurrency masCurrency = new MasCurrency();
			masCurrency.setId(currency);
			mstrStandardAllowance.setCurrency(masCurrency);
			
			mstrStandardAllowance.setAmount(amount);
			mstrStandardAllowance.setCityTypeFlag(districtType);
			mstrStandardAllowance.setStatus("y");

			Users users = new Users();
			users.setId(changedBy);
			mstrStandardAllowance.setLastChgBy(users);

			mstrStandardAllowance.setLastChgDate(currentDate);
			mstrStandardAllowance.setLastChgTime(currentTime);
			
			successfullyAdded = etravelMasterHandlerService.addStandardAllowance(mstrStandardAllowance);		

			if(successfullyAdded) {
				message="Record Added Successfully !!";
			} else {
     			message="Try Again !!";
			}
		}

		else if((standardAllowanceCodeList.size() != 0 || standardAllowanceCodeList != null) || (expenseHeadList.size() != 0) || expenseHeadList != null){
			if((standardAllowanceCodeList.size() != 0 || standardAllowanceCodeList != null) && (expenseHeadList.size() == 0 ||	expenseHeadList == null)){
				message = "Standard Allowance Code  already exists.";
			} else if((expenseHeadList.size() != 0 || expenseHeadList != null) && (standardAllowanceCodeList.size() == 0 || standardAllowanceCodeList == null) ){
				message = "Standard Allowance Desc already exists.";
			} else if((standardAllowanceCodeList.size() != 0 || standardAllowanceCodeList != null) && (expenseHeadList.size() != 0 || expenseHeadList != null)){
				message = "Standard Allowance Code and Standard Allowance Desc already exist.";
			}
		}

		url = "/hms/hrms/eTravelMaster?method=showStandardAllowanceMasterJsp";
		
			try{
				map = etravelMasterHandlerService.showStandardAllowanceMasterJsp();
			}catch (Exception e) {
				   e.printStackTrace();
			}
			String jsp=HR_STANDARD_ALLOWANCE_MASTER;
			jsp += ".jsp";
			title = "Standard Allowance Master";		
			map.put("contentJsp", jsp);
			map.put("message", message);
			map.put("title", title);
			return new ModelAndView("index","map",map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView editStandardAllowance(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession(true);
		
		int mstrStandardAllowanceId=0;
		int changedBy = 0;
		Date changedDate = new Date();
		String changedTime = "";

		int rankId = 0;
		int expenseType = 0;
		int trip = 0;
		int currency = 0;
		BigDecimal amount = BigDecimal.ZERO;
		String districtType = "";
		if(session.getAttribute("userId") != null){
			changedBy = (Integer)session.getAttribute("userId");
		}

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			mstrStandardAllowanceId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DESIGNATION_ID) != null && !request.getParameter(DESIGNATION_ID).equals("")) {
			rankId = Integer.parseInt(request.getParameter(DESIGNATION_ID));
		}
		if (request.getParameter(EXPENSE_TYPE) != null && !request.getParameter(EXPENSE_TYPE).equals("")) {
			expenseType = Integer.parseInt(request.getParameter(EXPENSE_TYPE));
		}
		if (request.getParameter(TRIP) != null && !request.getParameter(TRIP).equals("")) {
			trip = Integer.parseInt(request.getParameter(TRIP));
		}
		if (request.getParameter(CURRENCY_ID) != null && !request.getParameter(CURRENCY_ID).equals("")) {
			currency = Integer.parseInt(request.getParameter(CURRENCY_ID));
		}
		if (request.getParameter(DISTRICT_TYPE) != null && !request.getParameter(DISTRICT_TYPE).equals("")) {
			districtType = request.getParameter(DISTRICT_TYPE);
		}
		if (request.getParameter(AMOUNT) != null && !request.getParameter(AMOUNT).equals("")) {
			amount = new BigDecimal(request.getParameter(AMOUNT));
		}

		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter("pojoPropertyName") != null){
			pojoPropertyName = request.getParameter("pojoPropertyName"); 
		}
		if(request.getParameter("pojoName") != null){
			pojoName = request.getParameter("pojoName"); 
		}
		
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", mstrStandardAllowanceId);
		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("rankId", rankId);
		generalMap.put("expenseType", expenseType);
		generalMap.put("trip", trip);
		generalMap.put("currency", currency);
		generalMap.put("amount", amount);
		generalMap.put("districtType", districtType);
		
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = hrmsCommonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingExpenseHeadList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingExpenseHeadList.size() == 0)
		{
			dataUpdated=etravelMasterHandlerService.editStandardAllowance(generalMap);
			if(dataUpdated==true){
				message="Data updated Successfully !!";
			} else {
				message="Data Cant be updated !!";
			}
		} else if(existingExpenseHeadList.size() > 0){
			message = "Name already exists.";
		}
		
		url = "/hms/hrms/eTravelMaster?method=showStandardAllowanceMasterJsp";
		
		try{
			map = etravelMasterHandlerService.showStandardAllowanceMasterJsp();
		}catch (Exception e) {
			   e.printStackTrace();
		}
		String jsp=HR_STANDARD_ALLOWANCE_MASTER;
		jsp += ".jsp";
		title = "Standard Allowance Master";		
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("title", title);
		return new ModelAndView("index","map",map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView deleteStandardAllowance(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		
		session=request.getSession(true);
		int mstrStandardAllowanceId=0;
		String message=null;
		int changedBy = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(session.getAttribute("userId") != null){
			changedBy = (Integer)session.getAttribute("userId");
		}

		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			mstrStandardAllowanceId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
/*		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = Integer.parseInt(request.getParameter(CHANGED_BY));
		}*/
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=etravelMasterHandlerService.deleteStandardAllowance(mstrStandardAllowanceId,generalMap);
		if (dataDeleted==true) {
			message="Record is InActivated successfully !!";
		} else {
			message="Record is Activated successfully !!";
		}
		url = "/hms/hrms/eTravelMaster?method=showStandardAllowanceMasterJsp";
		
		try{
			map = etravelMasterHandlerService.showStandardAllowanceMasterJsp();
		}catch (Exception e) {
			   e.printStackTrace();
		}
		String jsp=HR_STANDARD_ALLOWANCE_MASTER;
		jsp += ".jsp";
		title = "Standard Allowance Master";		
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("title", title);
		return new ModelAndView("index","map",map);
	}

}
