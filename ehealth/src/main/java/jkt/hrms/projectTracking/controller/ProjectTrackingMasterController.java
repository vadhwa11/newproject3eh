package jkt.hrms.projectTracking.controller;

import static jkt.hrms.util.HrmsRequestConstants.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasBankMaster;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.HrMasVisitType;
import jkt.hrms.masters.business.MstrBudgetSubhead;
import jkt.hrms.masters.business.MstrBudgetType;
import jkt.hrms.masters.business.MstrCalendar;
import jkt.hrms.masters.business.MstrDeptTaskMap;
import jkt.hrms.masters.business.MstrDoctype;
import jkt.hrms.masters.business.MstrDocument;
import jkt.hrms.masters.business.MstrPiHeader;
import jkt.hrms.masters.business.MstrProjectStatus;
import jkt.hrms.masters.business.MstrProjectrole;
import jkt.hrms.masters.business.MstrProjecttype;
import jkt.hrms.masters.business.MstrPtvisit;
import jkt.hrms.masters.business.MstrRating;
import jkt.hrms.masters.business.MstrRoleTaskMap;
import jkt.hrms.masters.business.MstrSiteHeader;
import jkt.hrms.masters.business.MstrSponsor;
import jkt.hrms.masters.business.MstrSponsortype;
import jkt.hrms.masters.business.MstrTask;
import jkt.hrms.masters.business.MstrTaskType;
import jkt.hrms.masters.business.MstrTherapeutic;
import jkt.hrms.masters.business.MstrTrialphase;
import jkt.hrms.masters.business.MstrVendor;
import jkt.hrms.masters.business.MstrVitals;
import jkt.hrms.masters.business.VendorServiceType;
import jkt.hrms.projectTracking.handler.ProjectTrackingMasterHandlerService;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ProjectTrackingMasterController  extends MultiActionController{
	ProjectTrackingMasterHandlerService projectTrackingMasterHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	
	Map<String, Object> map = new HashMap<String, Object>();	
	Map<String, Object> generalMap = new HashMap<String, Object>();
	String jsp = "";
	String title = "";
	String message= " ";
	String url = "";
	String code = "";
	String name = "";
	String jspName = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	HttpSession session = null;
	String viewPage = "";
	String currentTime = "";
	
	//------------------------------------------Getter / Setter Method------------------------------
	public ProjectTrackingMasterHandlerService getProjectTrackingMasterHandlerService() {
		return projectTrackingMasterHandlerService;
	}

	public void setProjectTrackingMasterHandlerService(
			ProjectTrackingMasterHandlerService projectTrackingMasterHandlerService) {
		this.projectTrackingMasterHandlerService = projectTrackingMasterHandlerService;
	}
	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}
	//------------------------------------------Therapeutic Master------------------------------
	public ModelAndView searchTherapeutic(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String thpCode  = null;
		String thpDesc = null;
		String searchField= null;
		
		if(request.getParameter(THP_CODE) != null && !(request.getParameter(THP_CODE).equals(""))){
			thpCode = request.getParameter(THP_CODE);
		}

		if(request.getParameter(THP_DESC) != null && !(request.getParameter(THP_DESC).equals(""))){
			thpDesc = request.getParameter(THP_DESC);
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
			thpCode=searchField;
			thpDesc=null;
		}else{
			thpCode=null;
			thpDesc=searchField;
		}
		map = projectTrackingMasterHandlerService.searchTherapeutic(thpCode, thpDesc);
		jsp = THERAPEUTIC_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("thpCode",thpCode);
		map.put("thpDesc",thpDesc);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showTherapeuticJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		map = projectTrackingMasterHandlerService.showTherapeuticJsp();
		@SuppressWarnings("unused")
		ArrayList  searchTherapeuticList = (ArrayList)map.get("searchTherapeuticList");
		jsp = THERAPEUTIC_JSP;
		jsp += ".jsp";
		title = "Therapeutic";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addTherapeutic(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MstrTherapeutic mstrTherapeutic=new MstrTherapeutic();
		String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
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

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);

		List therapeuticCodeList = new ArrayList();
		List therapeuticNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			therapeuticCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			therapeuticNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((therapeuticCodeList.size() == 0 || therapeuticCodeList == null) && (therapeuticNameList.size() == 0 || therapeuticNameList == null))
		{
			mstrTherapeutic.setThpCode(code);
			mstrTherapeutic.setThpDesc(name);
			mstrTherapeutic.setStatus("y");
			mstrTherapeutic.setLastChgBy(changedBy);
			mstrTherapeutic.setLastChgDate(currentDate);
			mstrTherapeutic.setLastChgTime(currentTime);
			successfullyAdded = projectTrackingMasterHandlerService.addTherapeutic(mstrTherapeutic);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((therapeuticCodeList.size() != 0 || therapeuticCodeList != null) || (therapeuticNameList.size() != 0) || therapeuticNameList != null){

			if((therapeuticCodeList.size() != 0 || therapeuticCodeList != null) && (therapeuticNameList.size() == 0 || therapeuticNameList == null)){

				message = "Therapeutic Code  already exists.";
			}
			else if((therapeuticNameList.size() != 0 || therapeuticNameList != null) && (therapeuticCodeList.size() == 0 || therapeuticCodeList == null) ){

				message = "Therapeutic Name already exists.";
			}
			else if((therapeuticCodeList.size() != 0 || therapeuticCodeList != null) && (therapeuticNameList.size() != 0 || therapeuticNameList != null)){

				message = "Therapeutic Code and Therapeutic Name already exist.";
			}
		}

		url = "/hms/hrms/projectTrackingMaster?method=showTherapeuticJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showTherapeuticJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=THERAPEUTIC_JSP;
		  title="Add Therapeutic";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}

	public ModelAndView editTherapeutic(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession();
		String therapeuticCode="";
		String therapeuticName="";
		int therapeuticId=0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		therapeuticCode=(String )session.getAttribute("therapeuticCode");
		therapeuticName=(String )session.getAttribute("therapeuticName");
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			therapeuticId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			therapeuticCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			therapeuticName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", therapeuticId);
		generalMap.put("therapeuticCode", therapeuticCode);
		generalMap.put("name", therapeuticName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);
		
		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);
		List existingTherapeuticNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingTherapeuticNameList.size() == 0)
		{
		dataUpdated = projectTrackingMasterHandlerService.editTherapeuticToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
	}else if(existingTherapeuticNameList.size() > 0){

		message = "Name already exists.";

	}
		url = "hms/hrms/projectTrackingMaster?method=showTherapeuticJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showTherapeuticJsp();		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=THERAPEUTIC_JSP;
		  title="Edit Therapeutic";
		  jsp += ".jsp";
		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteTherapeutic(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int therapeuticId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			therapeuticId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=projectTrackingMasterHandlerService.deleteTherapeutic(therapeuticId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hrms/projectTrackingMaster?method=showTherapeuticJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showTherapeuticJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=THERAPEUTIC_JSP;
		  title="Delete Therapeutic";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);

	}

  //----------------------------Project Role ------------------------------------------
	public ModelAndView searchProjectRole(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String prjCode  = null;
		String prjName = null;
		String searchField= null;
		
		if(request.getParameter(PRJ_CODE) != null && !(request.getParameter(PRJ_CODE).equals(""))){
			prjCode = request.getParameter(PRJ_CODE);
		}
		if(request.getParameter(PRJ_NAME) != null && !(request.getParameter(PRJ_NAME).equals(""))){
			prjName = request.getParameter(PRJ_NAME);
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
			prjCode=searchField;
			prjName=null;
		}else{
			prjCode=null;
			prjName=searchField;
		}
		map = projectTrackingMasterHandlerService.searchProjectRole(prjCode, prjName);
		jsp = PROJECT_ROLE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("prjCode",prjCode);
		map.put("prjName",prjName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showProjectRoleJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		map = projectTrackingMasterHandlerService.showProjectRoleJsp();
		@SuppressWarnings("unused")
		ArrayList  searchProjectRoleList = (ArrayList)map.get("searchProjectRoleList");
		jsp = PROJECT_ROLE_JSP;
		jsp += ".jsp";
		title = "Project Role";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addProjectRole(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MstrProjectrole mstrProjectrole = new MstrProjectrole();
		String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
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

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);

		List projectRoleCodeList = new ArrayList();
		List projectRoleNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			projectRoleCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			projectRoleNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((projectRoleCodeList.size() == 0 || projectRoleCodeList == null) && (projectRoleNameList.size() == 0 || projectRoleNameList == null))
		{
			mstrProjectrole.setPjrCode(code);
			mstrProjectrole.setPjrName(name);
			mstrProjectrole.setStatus("y");
			mstrProjectrole.setLastChgBy(changedBy);
			mstrProjectrole.setLastChgDate(currentDate);
			mstrProjectrole.setLastChgTime(currentTime);
			successfullyAdded = projectTrackingMasterHandlerService.addProjectRole(mstrProjectrole);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((projectRoleCodeList.size() != 0 || projectRoleCodeList != null) || (projectRoleNameList.size() != 0) || projectRoleNameList != null){

			if((projectRoleCodeList.size() != 0 || projectRoleCodeList != null) && (projectRoleNameList.size() == 0 || projectRoleNameList == null)){

				message = "Project Role Code  already exists.";
			}
			else if((projectRoleNameList.size() != 0 || projectRoleNameList != null) && (projectRoleCodeList.size() == 0 || projectRoleCodeList == null) ){

				message = "Project Role Name already exists.";
			}
			else if((projectRoleCodeList.size() != 0 || projectRoleCodeList != null) && (projectRoleNameList.size() != 0 || projectRoleNameList != null)){

				message = "Project Role Code and Project Role Name already exist.";
			}
		}

		url = "/hms/hrms/projectTrackingMaster?method=showProjectRoleJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showProjectRoleJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=PROJECT_ROLE_JSP;
		  title="Add PROJECT ROLE";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}

	public ModelAndView editProjectRole(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession();
		String projectRoleCode="";
		String projectRoleName="";
		int projectRoleId=0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		projectRoleCode=(String )session.getAttribute("projectRoleCode");
		projectRoleName=(String )session.getAttribute("projectRoleName");
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			projectRoleId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			projectRoleCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			projectRoleName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", projectRoleId);
		generalMap.put("projectRoleCode", projectRoleCode);
		generalMap.put("name", projectRoleName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);
		List existingProjectRoleNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingProjectRoleNameList.size() == 0)
		{
		dataUpdated = projectTrackingMasterHandlerService.editProjectRoleToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
	}else if(existingProjectRoleNameList.size() > 0){

		message = "Name already exists.";

	}
		url = "hms/hrms/projectTrackingMaster?method=showProjectroleJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showProjectRoleJsp();		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=PROJECT_ROLE_JSP;
		  title="Edit Project Role";
		  jsp += ".jsp";
		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteProjectRole(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int projectRoleId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			projectRoleId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=projectTrackingMasterHandlerService.deleteProjectRole(projectRoleId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hrms/projectTrackingMaster?method=showProjectRoleJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showProjectRoleJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=PROJECT_ROLE_JSP;
		  title="Delete Project Role";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);

	}

	//----------------------------Project Type Master ------------------------------------------
	public ModelAndView searchProjectType(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String prjTypeCode  = null;
		String prjTypeName = null;
		String searchField= null;
		
		if(request.getParameter(PRJ_TYPE_CODE) != null && !(request.getParameter(PRJ_TYPE_CODE).equals(""))){
			prjTypeCode = request.getParameter(PRJ_TYPE_CODE);
		}
		if(request.getParameter(PRJ_TYPE_NAME) != null && !(request.getParameter(PRJ_TYPE_NAME).equals(""))){
			prjTypeName = request.getParameter(PRJ_TYPE_NAME);
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
			prjTypeCode=searchField;
			prjTypeName=null;
		}else{
			prjTypeCode=null;
			prjTypeName=searchField;
		}
		map = projectTrackingMasterHandlerService.searchProjectType(prjTypeCode, prjTypeName);
		jsp = PROJECT_TYPE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("prjTypeCode",prjTypeCode);
		map.put("prjTypeName",prjTypeName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showProjectTypeJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		map = projectTrackingMasterHandlerService.showProjectTypeJsp();
		@SuppressWarnings("unused")
		ArrayList  searchProjectTypeList = (ArrayList)map.get("searchProjectTypeList");
		jsp = PROJECT_TYPE_JSP;
		jsp += ".jsp";
		title = "Project Role";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editProjectType(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession();
		String projectTypeCode="";
		String projectTypeName="";
		int projectTypeId=0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		projectTypeCode=(String )session.getAttribute("projectTypeCode");
		projectTypeName=(String )session.getAttribute("projectTypeName");
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			projectTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			projectTypeCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			projectTypeName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", projectTypeId);
		generalMap.put("projectTypeCode", projectTypeCode);
		generalMap.put("name", projectTypeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);
		List existingProjectTypeNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingProjectTypeNameList.size() == 0)
		{
		dataUpdated = projectTrackingMasterHandlerService.editProjectTypeToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
	}else if(existingProjectTypeNameList.size() > 0){

		message = "Name already exists.";

	}
		url = "hms/hrms/projectTrackingMaster?method=showProjectTypeJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showProjectTypeJsp();		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=PROJECT_TYPE_JSP;
		  title="Edit Project Type";
		  jsp += ".jsp";
		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addProjectType(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MstrProjecttype mstrProjectType = new MstrProjecttype();
		String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if(session.getAttribute("hospitalId") != null){
			hospitalId  = (Integer)session.getAttribute("hospitalId");
		}

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
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

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);

		List projectTypeCodeList = new ArrayList();
		List projectTypeNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			projectTypeCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			projectTypeNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((projectTypeCodeList.size() == 0 || projectTypeCodeList == null) && (projectTypeNameList.size() == 0 || projectTypeNameList == null))
		{
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			mstrProjectType.setHospital(hospital);
			mstrProjectType.setProjectCode(code);
			mstrProjectType.setProjectName(name);
			mstrProjectType.setStatus("y");
			mstrProjectType.setLastChgBy(changedBy);
			mstrProjectType.setLastChgDate(currentDate);
			mstrProjectType.setLastChgTime(currentTime);
			successfullyAdded = projectTrackingMasterHandlerService.addProjectType(mstrProjectType);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((projectTypeCodeList.size() != 0 || projectTypeCodeList != null) || (projectTypeNameList.size() != 0) || projectTypeNameList != null){

			if((projectTypeCodeList.size() != 0 || projectTypeCodeList != null) && (projectTypeNameList.size() == 0 || projectTypeNameList == null)){

				message = "Project Role Code  already exists.";
			}
			else if((projectTypeNameList.size() != 0 || projectTypeNameList != null) && (projectTypeCodeList.size() == 0 || projectTypeCodeList == null) ){

				message = "Project Role Name already exists.";
			}
			else if((projectTypeCodeList.size() != 0 || projectTypeCodeList != null) && (projectTypeNameList.size() != 0 || projectTypeNameList != null)){

				message = "Project Role Code and Project Role Name already exist.";
			}
		}

		url = "/hms/hrms/projectTrackingMaster?method=showProjectTypeJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showProjectTypeJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=PROJECT_TYPE_JSP;
		  title="Add Project Type";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteProjectType(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int projectTypeId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			projectTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=projectTrackingMasterHandlerService.deleteProjectType(projectTypeId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hrms/projectTrackingMaster?method=showProjectTypeJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showProjectTypeJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=PROJECT_TYPE_JSP;
		  title="Delete Project Type";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);

	}

	
	//----------------------------Trial Phase Master ------------------------------------------
	public ModelAndView searchTrialPhase(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String trialPhaseCode  = null;
		String trialPhaseName = null;
		String searchField= null;
		
		if(request.getParameter(SPONSER_TYPE_CODE) != null && !(request.getParameter(SPONSER_TYPE_CODE).equals(""))){
			trialPhaseCode = request.getParameter(SPONSER_TYPE_CODE);
		}
		if(request.getParameter(SPONSER_TYPE_NAME) != null && !(request.getParameter(SPONSER_TYPE_NAME).equals(""))){
			trialPhaseName = request.getParameter(SPONSER_TYPE_NAME);
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
			trialPhaseCode=searchField;
			trialPhaseName=null;
		}else{
			trialPhaseCode=null;
			trialPhaseName=searchField;
		}
		

		map = projectTrackingMasterHandlerService.searchTrialPhase(trialPhaseCode, trialPhaseName);

		jsp = TRIAL_PHASE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("trialPhaseCode",trialPhaseCode);
		map.put("trialPhaseName",trialPhaseName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showTrialPhaseJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		map = projectTrackingMasterHandlerService.showTrialPhaseJsp();
		@SuppressWarnings("unused")
		ArrayList  searchTrialPhaseList = (ArrayList)map.get("searchTrialPhaseList");
		jsp = TRIAL_PHASE_JSP;
		jsp += ".jsp";
		title = "Trial Phase";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editTrialPhase(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession();
		String trialPhaseCode="";
		String trialPhaseName="";
		int trialPhaseId=0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		trialPhaseCode=(String )session.getAttribute("trialPhaseCode");
		trialPhaseName=(String )session.getAttribute("trialPhaseName");
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			trialPhaseId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			trialPhaseCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			trialPhaseName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", trialPhaseId);
		generalMap.put("trialPhaseCode", trialPhaseCode);
		generalMap.put("name", trialPhaseName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);
		List existingTrialPhaseNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingTrialPhaseNameList.size() == 0)
		{
		dataUpdated = projectTrackingMasterHandlerService.editTrialPhaseToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
	}else if(existingTrialPhaseNameList.size() > 0){

		message = "Name already exists.";

	}
		url = "hms/hrms/projectTrackingMaster?method=showTrialPhaseJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showTrialPhaseJsp();		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=TRIAL_PHASE_JSP;
		  title="Edit Trial Phase";
		  jsp += ".jsp";
		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addTrialPhase(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MstrTrialphase mstrTrialphase = new MstrTrialphase();
		String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		
		if(session.getAttribute("hospitalId") != null){
			hospitalId  = (Integer)session.getAttribute("hospitalId");
		}
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
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

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);

		List trialPhaseCodeList = new ArrayList();
		List trialPhaseNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			trialPhaseCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			trialPhaseNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((trialPhaseCodeList.size() == 0 || trialPhaseCodeList == null) && (trialPhaseNameList.size() == 0 || trialPhaseNameList == null))
		{
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			mstrTrialphase.setHospital(hospital);
			mstrTrialphase.setTrialPhaseCode(code);
			mstrTrialphase.setTrialPhaseName(name);
			mstrTrialphase.setStatus("y");
			mstrTrialphase.setLastChgBy(changedBy);
			mstrTrialphase.setLastChgDate(currentDate);
			mstrTrialphase.setLastChgTime(currentTime);
			successfullyAdded = projectTrackingMasterHandlerService.addTrialPhase(mstrTrialphase);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((trialPhaseCodeList.size() != 0 || trialPhaseCodeList != null) || (trialPhaseNameList.size() != 0) || trialPhaseNameList != null){

			if((trialPhaseCodeList.size() != 0 || trialPhaseCodeList != null) && (trialPhaseNameList.size() == 0 || trialPhaseNameList == null)){

				message = "Trial Phase Code  already exists.";
			}
			else if((trialPhaseNameList.size() != 0 || trialPhaseNameList != null) && (trialPhaseCodeList.size() == 0 || trialPhaseCodeList == null) ){

				message = "Trial Phase Name already exists.";
			}
			else if((trialPhaseCodeList.size() != 0 || trialPhaseCodeList != null) && (trialPhaseNameList.size() != 0 || trialPhaseNameList != null)){

				message = "Trial Phase Code and Trial Phase Name already exist.";
			}
		}

		url = "/hms/hrms/projectTrackingMaster?method=showTrialPhaseJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showTrialPhaseJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=TRIAL_PHASE_JSP;
		  title="Add Trial Phase";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteTrialPhase(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int trialPhaseId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			trialPhaseId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=projectTrackingMasterHandlerService.deleteTrialPhase(trialPhaseId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hrms/projectTrackingMaster?method=showTrialPhaseJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showTrialPhaseJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=TRIAL_PHASE_JSP;
		  title="Delete Trial Phase";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);

	}

	//----------------------------Sponser Type Master ------------------------------------------
	public ModelAndView searchSponserType(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String sponserTypeCode  = null;
		String sponserTypeName = null;
		String searchField= null;
		
		if(request.getParameter(SPONSER_TYPE_CODE) != null && !(request.getParameter(SPONSER_TYPE_CODE).equals(""))){
			sponserTypeCode = request.getParameter(SPONSER_TYPE_CODE);
		}
		if(request.getParameter(SPONSER_TYPE_NAME) != null && !(request.getParameter(SPONSER_TYPE_NAME).equals(""))){
			sponserTypeName = request.getParameter(SPONSER_TYPE_NAME);
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
			sponserTypeCode=searchField;
			sponserTypeName=null;
		}else{
			sponserTypeCode=null;
			sponserTypeName=searchField;
		}
		

		map = projectTrackingMasterHandlerService.searchSponserType(sponserTypeCode, sponserTypeName);

		jsp = SPONSER_TYPE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("sponserTypeCode",sponserTypeCode);
		map.put("sponserTypeName",sponserTypeName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showSponserTypeJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		map = projectTrackingMasterHandlerService.showSponserTypeJsp();
		@SuppressWarnings("unused")
		ArrayList  searchSponserTypeList = (ArrayList)map.get("searchSponserTypeList");
		jsp = SPONSER_TYPE_JSP;
		jsp += ".jsp";
		title = "SponserType";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editSponserType(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession();
		String sponserTypeCode="";
		String sponserTypeName="";
		int sponserTypeId=0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		sponserTypeCode=(String )session.getAttribute("sponserTypeCode");
		sponserTypeName=(String )session.getAttribute("sponserTypeName");
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			sponserTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			sponserTypeCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			sponserTypeName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", sponserTypeId);
		generalMap.put("sponserTypeCode", sponserTypeCode);
		generalMap.put("name", sponserTypeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);
		List existingSponserTypeNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingSponserTypeNameList.size() == 0)
		{
		dataUpdated = projectTrackingMasterHandlerService.editSponserTypeToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
	}else if(existingSponserTypeNameList.size() > 0){

		message = "Name already exists.";

	}
		url = "hms/hrms/projectTrackingMaster?method=showSponserTypeJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showSponserTypeJsp();		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=SPONSER_TYPE_JSP;
		  title="Edit Sponser Type";
		  jsp += ".jsp";
		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addSponserType(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MstrSponsortype mstrSponsortype = new MstrSponsortype();
		String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		
		if(session.getAttribute("hospitalId") != null){
			hospitalId  = (Integer)session.getAttribute("hospitalId");
		}
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
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

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);

		List sponserTypeCodeList = new ArrayList();
		List sponserTypeNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			sponserTypeCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			sponserTypeNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((sponserTypeCodeList.size() == 0 || sponserTypeCodeList == null) && (sponserTypeNameList.size() == 0 || sponserTypeNameList == null))
		{
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			mstrSponsortype.setHospital(hospital);
			mstrSponsortype.setSponserTypeCode(code);
			mstrSponsortype.setSponserTypeName(name);
			mstrSponsortype.setStatus("y");
			mstrSponsortype.setLastChgBy(changedBy);
			mstrSponsortype.setLastChgDate(currentDate);
			mstrSponsortype.setLastChgTime(currentTime);
			successfullyAdded = projectTrackingMasterHandlerService.addSponserType(mstrSponsortype);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((sponserTypeCodeList.size() != 0 || sponserTypeCodeList != null) || (sponserTypeNameList.size() != 0) || sponserTypeNameList != null){

			if((sponserTypeCodeList.size() != 0 || sponserTypeCodeList != null) && (sponserTypeNameList.size() == 0 || sponserTypeNameList == null)){

				message = "sponser Type Code  already exists.";
			}
			else if((sponserTypeNameList.size() != 0 || sponserTypeNameList != null) && (sponserTypeCodeList.size() == 0 || sponserTypeCodeList == null) ){

				message = "Sponser Type Name already exists.";
			}
			else if((sponserTypeCodeList.size() != 0 || sponserTypeCodeList != null) && (sponserTypeNameList.size() != 0 || sponserTypeNameList != null)){

				message = "Sponser Type Code and Sposer Type Name already exist.";
			}
		}

		url = "/hms/hrms/projectTrackingMaster?method=showSponserTypeJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showSponserTypeJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=SPONSER_TYPE_JSP;
		  title="Add Sponser Type";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteSponserType(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int sponserTypeId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			sponserTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=projectTrackingMasterHandlerService.deleteSponserType(sponserTypeId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hrms/projectTrackingMaster?method=showSponserTypeJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showSponserTypeJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=SPONSER_TYPE_JSP;
		  title="Delete Sponser Type";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);

	}

//	----------------------------Budget Sub-Heading Master ------------------------------------------
	public ModelAndView searchBudgetSubHeading(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String budgetSubHeadingCode  = null;
		String budgetSubHeadingName = null;
		String searchField= null;
		
		if(request.getParameter(BUD_SUBHEAD_CODE) != null && !(request.getParameter(BUD_SUBHEAD_CODE).equals(""))){
			budgetSubHeadingCode = request.getParameter(BUD_SUBHEAD_CODE);
		}
		if(request.getParameter(BUD_NAME) != null && !(request.getParameter(BUD_NAME).equals(""))){
			budgetSubHeadingName = request.getParameter(BUD_NAME);
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
			budgetSubHeadingCode=searchField;
			budgetSubHeadingName=null;
		}else{
			budgetSubHeadingCode=null;
			budgetSubHeadingName=searchField;
		}
		
		map = projectTrackingMasterHandlerService.searchBudgetSubHeading(budgetSubHeadingCode, budgetSubHeadingName);
		jsp = BUDGET_SUB_HEADING;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("budgetSubHeadingCode",budgetSubHeadingCode);
		map.put("budgetSubHeadingName",budgetSubHeadingName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showBudgetSubHeadingJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		map = projectTrackingMasterHandlerService.showBudgetSubHeadingJsp();
		@SuppressWarnings("unused")
		ArrayList  searchBudgetSubHeadingList = (ArrayList)map.get("searchBudgetSubHeadingList");
		jsp = BUDGET_SUB_HEADING;
		jsp += ".jsp";
		title = "SponserType";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editBudgetSubHeading(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession();
		String budgetSubHeadingCode="";
		String budgetSubHeadingName="";
		int budgetSubHeadingId=0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		budgetSubHeadingCode=(String )session.getAttribute("budgetSubHeadingCode");
		budgetSubHeadingName=(String )session.getAttribute("budgetSubHeadingName");
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			budgetSubHeadingId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			budgetSubHeadingCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			budgetSubHeadingName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", budgetSubHeadingId);
		generalMap.put("budgetSubHeadingCode", budgetSubHeadingCode);
		generalMap.put("name", budgetSubHeadingName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);
		List existingBudgetSubHeadingNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingBudgetSubHeadingNameList.size() == 0)
		{
		dataUpdated = projectTrackingMasterHandlerService.editBudgetSubHeadingToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
	}else if(existingBudgetSubHeadingNameList.size() > 0){

		message = "Name already exists.";

	}
		url = "hms/hrms/projectTrackingMaster?method=showBudgetSubHeadingJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showBudgetSubHeadingJsp();		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=BUDGET_SUB_HEADING;
		  title="Edit Budget Sub-Heading";
		  jsp += ".jsp";
		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addBudgetSubHeading(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MstrBudgetSubhead mstrBudgetSubhead = new MstrBudgetSubhead();
		String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		
		if(session.getAttribute("hospitalId") != null){
			hospitalId  = (Integer)session.getAttribute("hospitalId");
		}
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
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

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);

		List budgetSubHeadingCodeList = new ArrayList();
		List budgetSubHeadingNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			budgetSubHeadingCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			budgetSubHeadingNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((budgetSubHeadingCodeList.size() == 0 || budgetSubHeadingCodeList == null) && (budgetSubHeadingNameList.size() == 0 || budgetSubHeadingNameList == null))
		{
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			mstrBudgetSubhead.setHospital(hospital);
			mstrBudgetSubhead. setBudSubheadCode(code);
			mstrBudgetSubhead.setBudName(name);
			mstrBudgetSubhead.setStatus("y");
			mstrBudgetSubhead.setLastChgBy(changedBy);
			mstrBudgetSubhead.setLastChgDate(currentDate);
			mstrBudgetSubhead.setLastChgTime(currentTime);
			successfullyAdded = projectTrackingMasterHandlerService.addBudgetSubHeading(mstrBudgetSubhead);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((budgetSubHeadingCodeList.size() != 0 || budgetSubHeadingCodeList != null) || (budgetSubHeadingNameList.size() != 0) || budgetSubHeadingNameList != null){

			if((budgetSubHeadingCodeList.size() != 0 || budgetSubHeadingCodeList != null) && (budgetSubHeadingNameList.size() == 0 || budgetSubHeadingNameList == null)){

				message = "Budget Sub-Heading Code  already exists.";
			}
			else if((budgetSubHeadingNameList.size() != 0 || budgetSubHeadingNameList != null) && (budgetSubHeadingCodeList.size() == 0 || budgetSubHeadingCodeList == null) ){

				message = "Budget Sub-Heading Name already exists.";
			}
			else if((budgetSubHeadingCodeList.size() != 0 || budgetSubHeadingCodeList != null) && (budgetSubHeadingNameList.size() != 0 || budgetSubHeadingNameList != null)){

				message = "Budget Sub-Heading Code and Budget Sub-Heading Name already exist.";
			}
		}

		url = "/hms/hrms/projectTrackingMaster?method=showBudgetSubHeadingJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showBudgetSubHeadingJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=BUDGET_SUB_HEADING;
		  title="Add Budget Sub-Heading";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteBudgetSubHeading(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int budgetSubHeadingId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			budgetSubHeadingId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=projectTrackingMasterHandlerService.deleteBudgetSubHeading(budgetSubHeadingId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hrms/projectTrackingMaster?method=showBudgetSubHeadingJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showBudgetSubHeadingJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=BUDGET_SUB_HEADING;
		  title="Delete budget Sub-Heading";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);

	}

//	----------------------------Task Type Master ------------------------------------------
	public ModelAndView searchTaskType(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String taskTypeCode  = null;
		String taskTypeName = null;
		String searchField= null;
		
		if(request.getParameter(TASK_TYPE_CODE) != null && !(request.getParameter(TASK_TYPE_CODE).equals(""))){
			taskTypeCode = request.getParameter(TASK_TYPE_CODE);
		}
		if(request.getParameter(TASK_TYPE_NAME) != null && !(request.getParameter(TASK_TYPE_NAME).equals(""))){
			taskTypeName = request.getParameter(TASK_TYPE_NAME);
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
			taskTypeCode=searchField;
			taskTypeName=null;
		}else{
			taskTypeCode=null;
			taskTypeName=searchField;
		}
		

		map = projectTrackingMasterHandlerService.searchTaskType(taskTypeCode, taskTypeName);

		jsp = TASK_TYPE;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("taskTypeCode",taskTypeCode);
		map.put("taskTypeName",taskTypeName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showTaskTypeJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		map = projectTrackingMasterHandlerService.showTaskTypeJsp();
		@SuppressWarnings("unused")
		ArrayList  searchTaskTypeList = (ArrayList)map.get("searchTaskTypeList");
		jsp = TASK_TYPE;
		jsp += ".jsp";
		title = "TaskType";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editTaskType(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession();
		String taskTypeCode="";
		String taskTypeName="";
		int taskTypeId=0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		taskTypeCode=(String )session.getAttribute("taskTypeCode");
		taskTypeName=(String )session.getAttribute("taskTypeName");
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			taskTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			taskTypeCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			taskTypeName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", taskTypeId);
		generalMap.put("taskTypeCode", taskTypeCode);
		generalMap.put("name", taskTypeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);
		List existingtaskTypeNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingtaskTypeNameList.size() == 0)
		{
		dataUpdated = projectTrackingMasterHandlerService.editTaskTypeToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
	}else if(existingtaskTypeNameList.size() > 0){

		message = "Name already exists.";

	}
		url = "hms/hrms/projectTrackingMaster?method=showTaskTypeJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showTaskTypeJsp();		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=TASK_TYPE;
		  title="Edit Task Type";
		  jsp += ".jsp";
		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addTaskType(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MstrTaskType mstrTaskType = new MstrTaskType();
		String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		
		if(session.getAttribute("hospitalId") != null){
			hospitalId  = (Integer)session.getAttribute("hospitalId");
		}
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
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

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);

		List taskTypeCodeList = new ArrayList();
		List taskTypeNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			taskTypeCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			taskTypeNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((taskTypeCodeList.size() == 0 || taskTypeCodeList == null) && (taskTypeNameList.size() == 0 || taskTypeNameList == null))
		{
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			mstrTaskType.setHospital(hospital);
			mstrTaskType.setTaskTypeCode(code);
			mstrTaskType.setTaskTypeName(name);
			mstrTaskType.setStatus("y");
			mstrTaskType.setLastChgBy(changedBy);
			mstrTaskType.setLastChgDate(currentDate);
			mstrTaskType.setLastChgTime(currentTime);
			successfullyAdded = projectTrackingMasterHandlerService.addTaskType(mstrTaskType);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((taskTypeCodeList.size() != 0 || taskTypeCodeList != null) || (taskTypeNameList.size() != 0) || taskTypeNameList != null){

			if((taskTypeCodeList.size() != 0 || taskTypeCodeList != null) && (taskTypeNameList.size() == 0 || taskTypeNameList == null)){

				message = "Task Type Code  already exists.";
			}
			else if((taskTypeNameList.size() != 0 || taskTypeNameList != null) && (taskTypeCodeList.size() == 0 || taskTypeCodeList == null) ){

				message = "Task Type Name already exists.";
			}
			else if((taskTypeCodeList.size() != 0 || taskTypeCodeList != null) && (taskTypeNameList.size() != 0 || taskTypeNameList != null)){

				message = "Task Type Code and Task Type Name already exist.";
			}
		}

		url = "/hms/hrms/projectTrackingMaster?method=showTaskTypeJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showTaskTypeJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=TASK_TYPE;
		  title="Add Task Type";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteTaskType(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int taskTypeId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			taskTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=projectTrackingMasterHandlerService.deleteTaskType(taskTypeId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hrms/projectTrackingMaster?method=showTaskTypeJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showTaskTypeJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=TASK_TYPE;
		  title="Delete Task Type";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);

	}
	//-------------------------Task Master ------------------------------------------
	public ModelAndView showTaskMasterJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		map = projectTrackingMasterHandlerService.showTaskMasterJsp();
		@SuppressWarnings("unused")
		ArrayList  searchTaskList = (ArrayList)map.get("searchTaskList");
		ArrayList  taskTypeList = (ArrayList)map.get("TaskTypeList");
		ArrayList  budgetSubHeadingList = (ArrayList)map.get("BudgetSubHeadingList");
		
		

		jsp = TASK_MASTER;
		jsp += ".jsp";
		title = "TaskType";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchTask(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String taskCode  = null;
		String taskName = null;
		String searchField= null;
		
		if(request.getParameter(TASK_CODE) != null && !(request.getParameter(TASK_CODE).equals(""))){
			taskCode = request.getParameter(TASK_CODE);
		}
		if(request.getParameter(TASK_MAS_NAME) != null && !(request.getParameter(TASK_MAS_NAME).equals(""))){
			taskName = request.getParameter(TASK_MAS_NAME);
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
			taskCode=searchField;
			taskName=null;
		}else{
			taskCode=null;
			taskName=searchField;
		}
		

		map = projectTrackingMasterHandlerService.searchTask(taskCode, taskName);

		jsp = TASK_MASTER;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("taskCode",taskCode);
		map.put("taskName",taskName);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView deleteTask(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int taskId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			taskId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=projectTrackingMasterHandlerService.deleteTask(taskId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hrms/projectTrackingMaster?method=showTaskMasterJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showTaskMasterJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=TASK_MASTER;
		  title="Delete Task Type";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);

	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addTask(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		//MstrTask mstrTask = new MstrTask();
		String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int taskType = 0;
		int BudgetSubHeading = 0;
		MstrTask mstrTask = new MstrTask();
		if(session.getAttribute("hospitalId") != null){
			hospitalId  = (Integer)session.getAttribute("hospitalId");
		}
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(TASK_TYPE_ID) != null  && !(request.getParameter(TASK_TYPE_ID).equals(""))) {
			taskType = Integer.parseInt(request.getParameter(TASK_TYPE_ID));
		}
		if (!(request.getParameter(BUDGET_SUBHEADING).equals("0"))) {
			BudgetSubHeading = Integer.parseInt(request.getParameter(BUDGET_SUBHEADING));
			MstrBudgetSubhead mstrBudgetSubhead = new MstrBudgetSubhead();
			mstrBudgetSubhead.setId(BudgetSubHeading);
			mstrTask.setBudid(mstrBudgetSubhead);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
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

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);

		List taskCodeList = new ArrayList();
		List taskNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			taskCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			taskNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((taskCodeList.size() == 0 || taskCodeList == null) && (taskNameList.size() == 0 || taskNameList == null))
		{
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			
			MstrTaskType mstrTaskType = new MstrTaskType();
			mstrTaskType.setId(taskType);
			mstrTask.setHospital(hospital);
			mstrTask.setTaskCode(code);
			mstrTask.setTaskName(name);
			mstrTask.setTaskType(mstrTaskType);
			mstrTask.setStatus("y");
			mstrTask.setLastChgBy(changedBy);
			mstrTask.setLastChgDate(currentDate);
			mstrTask.setLastChgTime(currentTime);
			successfullyAdded = projectTrackingMasterHandlerService.addTask(mstrTask);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((taskCodeList.size() != 0 || taskCodeList != null) || (taskNameList.size() != 0) || taskNameList != null){

			if((taskCodeList.size() != 0 || taskCodeList != null) && (taskNameList.size() == 0 || taskNameList == null)){

				message = "Task  Code  already exists.";
			}
			else if((taskNameList.size() != 0 || taskNameList != null) && (taskCodeList.size() == 0 || taskCodeList == null) ){

				message = "Task  Name already exists.";
			}
			else if((taskCodeList.size() != 0 || taskCodeList != null) && (taskNameList.size() != 0 || taskNameList != null)){

				message = "Task  Code and Task  Name already exist.";
			}
		}

		url = "/hms/hrms/projectTrackingMaster?method=showTaskMasterJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showTaskMasterJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=TASK_MASTER;
		  title="Add Task ";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView editTask(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession();
		String taskCode="";
		String taskName="";
		int taskId = 0;
		int budgetSubHeadingId = 0;
		int taskTypeId=0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		taskCode=(String )session.getAttribute("taskCode");
		taskName=(String )session.getAttribute("taskName");
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			taskId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			taskCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			taskName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(TASK_TYPE_ID) != null && !(request.getParameter(TASK_TYPE_ID).equals(""))){
			taskTypeId = Integer.parseInt(request.getParameter(TASK_TYPE_ID));
		}
		if (request.getParameter(BUDGET_SUBHEADING) != null && !(request.getParameter(BUDGET_SUBHEADING).equals("0")) ) {
			budgetSubHeadingId = Integer.parseInt(request.getParameter(BUDGET_SUBHEADING));
		}
		
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", taskId);
		generalMap.put("taskCode", taskCode);
		generalMap.put("name", taskName);
		generalMap.put("taskTypeId", taskTypeId);
		generalMap.put("budgetSubHeadingId", budgetSubHeadingId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);
		List existingtaskNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingtaskNameList.size() == 0)
		{
		dataUpdated = projectTrackingMasterHandlerService.editTaskToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
	}else if(existingtaskNameList.size() > 0){

		message = "Name already exists.";

	}
		url = "hms/hrms/projectTrackingMaster?method=showTaskMasterJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showTaskMasterJsp();		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=TASK_MASTER;
		  title="Edit Task Master";
		  jsp += ".jsp";
		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	
	
//	----------------------------Budget Type Master ------------------------------------------
	public ModelAndView searchBudgetType(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String budgetTypeCode  = null;
		String budgetTypeName = null;
		String searchField= null;
		
		if(request.getParameter(BUDGET_TYPE_CODE) != null && !(request.getParameter(BUDGET_TYPE_CODE).equals(""))){
			budgetTypeCode = request.getParameter(BUDGET_TYPE_CODE);
		}
		if(request.getParameter(BUDGET_TYPE_NAME) != null && !(request.getParameter(BUDGET_TYPE_NAME).equals(""))){
			budgetTypeName = request.getParameter(BUDGET_TYPE_NAME);
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
			budgetTypeCode=searchField;
			budgetTypeName=null;
		}else{
			budgetTypeCode=null;
			budgetTypeName=searchField;
		}
		

		map = projectTrackingMasterHandlerService.searchBudgetType(budgetTypeCode, budgetTypeName);

		jsp = BUDGET_TYPE;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("budgetTypeCode",budgetTypeCode);
		map.put("budgetTypeName",budgetTypeName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showBudgetTypeJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		map = projectTrackingMasterHandlerService.showBudgetTypeJsp();
		@SuppressWarnings("unused")
		ArrayList  searchBudgetTypeList = (ArrayList)map.get("searchBudgetTypeList");

		jsp = BUDGET_TYPE;
		jsp += ".jsp";
		title = "BudgetType";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editBudgetType(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession();
		String budgetTypeCode="";
		String budgetTypeName="";
		int budgetTypeId=0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		budgetTypeCode=(String )session.getAttribute("budgetTypeCode");
		budgetTypeName=(String )session.getAttribute("budgetTypeName");
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			budgetTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			budgetTypeCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			budgetTypeName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", budgetTypeId);
		generalMap.put("budgetTypeCode", budgetTypeCode);
		generalMap.put("name", budgetTypeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);
		List existingBudgetTypeNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingBudgetTypeNameList.size() == 0)
		{
		dataUpdated = projectTrackingMasterHandlerService.editBudgetTypeToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
	}else if(existingBudgetTypeNameList.size() > 0){

		message = "Name already exists.";

	}
		url = "hms/hrms/projectTrackingMaster?method=showBudgetTypeJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showBudgetTypeJsp();		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=BUDGET_TYPE;
		  title="Edit Budget Type";
		  jsp += ".jsp";
		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addBudgetType(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MstrBudgetType mstrBudgetType = new MstrBudgetType();
		String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		
		if(session.getAttribute("hospitalId") != null){
			hospitalId  = (Integer)session.getAttribute("hospitalId");
		}
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
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

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);

		List budgetTypeCodeList = new ArrayList();
		List budgetTypeNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			budgetTypeCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			budgetTypeNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((budgetTypeCodeList.size() == 0 || budgetTypeCodeList == null) && (budgetTypeNameList.size() == 0 || budgetTypeNameList == null))
		{
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			mstrBudgetType.setHospital(hospital);
			mstrBudgetType.setBudgetTypeCode(code);
			mstrBudgetType.setBudgetTypeName(name);
			mstrBudgetType.setStatus("y");
			mstrBudgetType.setLastChgBy(changedBy);
			mstrBudgetType.setLastChgDate(currentDate);
			mstrBudgetType.setLastChgTime(currentTime);
			successfullyAdded = projectTrackingMasterHandlerService.addBudgetType(mstrBudgetType);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((budgetTypeCodeList.size() != 0 || budgetTypeCodeList != null) || (budgetTypeNameList.size() != 0) || budgetTypeNameList != null){

			if((budgetTypeCodeList.size() != 0 || budgetTypeCodeList != null) && (budgetTypeNameList.size() == 0 || budgetTypeNameList == null)){

				message = "Budget Type Code  already exists.";
			}
			else if((budgetTypeNameList.size() != 0 || budgetTypeNameList != null) && (budgetTypeCodeList.size() == 0 || budgetTypeCodeList == null) ){

				message = "Budget Type Name already exists.";
			}
			else if((budgetTypeCodeList.size() != 0 || budgetTypeCodeList != null) && (budgetTypeNameList.size() != 0 || budgetTypeNameList != null)){

				message = "Budget Type Code and Budget Type Name already exist.";
			}
		}

		url = "/hms/hrms/projectTrackingMaster?method=showBudgetTypeJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showBudgetTypeJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=BUDGET_TYPE;
		  title="Add Budget Type";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView deleteBudgetType(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int budgetTypeId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			budgetTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=projectTrackingMasterHandlerService.deleteBudgetType(budgetTypeId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hrms/projectTrackingMaster?method=showBudgetTypeJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showBudgetTypeJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=BUDGET_TYPE;
		  title="Delete Budget Type";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);

	}

	
	//=============================Patient Visit here=======================================
	public ModelAndView searchPatientVisit(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String patientVisitCode  = null;
		String patientVisitName = null;
		String searchField= null;
		
		if(request.getParameter(PATIENT_VISIT_CODE) != null && !(request.getParameter(PATIENT_VISIT_CODE).equals(""))){
			patientVisitCode = request.getParameter(PATIENT_VISIT_CODE);
		}
		if(request.getParameter(PATIENT_VISIT_NAME) != null && !(request.getParameter(PATIENT_VISIT_NAME).equals(""))){
			patientVisitName = request.getParameter(PATIENT_VISIT_NAME);
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
			patientVisitCode=searchField;
			patientVisitName=null;
		}else{
			patientVisitCode=null;
			patientVisitName=searchField;
		}
		

		map = projectTrackingMasterHandlerService.searchPatientVisit(patientVisitCode, patientVisitName);

		jsp = PATIENT_VISIT_MASTER;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("patientVisitCode",patientVisitCode);
		map.put("patientVisitName",patientVisitName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showPatientVisitJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		map = projectTrackingMasterHandlerService.showPatientVisitJsp();
		@SuppressWarnings("unused")
		ArrayList  searchPatientVisitList = (ArrayList)map.get("searchPatientVisitList");

		jsp = PATIENT_VISIT_MASTER;
		jsp += ".jsp";
		title = "PatientVisit";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editPatientVisit(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession();
		String patientVisitCode="";
		String patientVisitName="";
		int patientVisitId=0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		patientVisitCode=(String )session.getAttribute("patientVisitCode");
		patientVisitName=(String )session.getAttribute("patientVisitName");
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			patientVisitId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			patientVisitCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			patientVisitName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", patientVisitId);
		generalMap.put("patientVisitCode", patientVisitCode);
		generalMap.put("name", patientVisitName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);
		List existingPatientVisitNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingPatientVisitNameList.size() == 0)
		{
		dataUpdated = projectTrackingMasterHandlerService.editPatientVisitToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
	}else if(existingPatientVisitNameList.size() > 0){

		message = "Name already exists.";

	}
		url = "hms/hrms/projectTrackingMaster?method=showPatientVisitJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showPatientVisitJsp();		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=PATIENT_VISIT_MASTER;
		  title="Edit Visit Master";
		  jsp += ".jsp";
		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addPatientVisit(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MstrPtvisit mstrPtvisit = new MstrPtvisit();
		String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		
		if(session.getAttribute("hospitalId") != null){
			hospitalId  = (Integer)session.getAttribute("hospitalId");
		}
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
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

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);

		List patientVisitCodeList = new ArrayList();
		List patientVisitNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			patientVisitCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			patientVisitNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((patientVisitCodeList.size() == 0 || patientVisitCodeList == null) && (patientVisitNameList.size() == 0 || patientVisitNameList == null))
		{
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			mstrPtvisit.setHospital(hospital);
			mstrPtvisit.setPatientVisitCode(code);
			mstrPtvisit.setPatientVisitName(name);
			mstrPtvisit.setStatus("y");
			mstrPtvisit.setLastChgBy(changedBy);
			mstrPtvisit.setLastChgDate(currentDate);
			mstrPtvisit.setLastChgTime(currentTime);
			successfullyAdded = projectTrackingMasterHandlerService.addPatientVisit(mstrPtvisit);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((patientVisitCodeList.size() != 0 || patientVisitCodeList != null) || (patientVisitNameList.size() != 0) || patientVisitNameList != null){

			if((patientVisitCodeList.size() != 0 || patientVisitCodeList != null) && (patientVisitNameList.size() == 0 || patientVisitNameList == null)){

				message = "PAtient Visit Code  already exists.";
			}
			else if((patientVisitNameList.size() != 0 || patientVisitNameList != null) && (patientVisitCodeList.size() == 0 || patientVisitCodeList == null) ){

				message = "PAtient Visit Name already exists.";
			}
			else if((patientVisitCodeList.size() != 0 || patientVisitCodeList != null) && (patientVisitNameList.size() != 0 || patientVisitNameList != null)){

				message = "PAtient Visit Code and PAtient Visit Name already exist.";
			}
		}

		url = "/hms/hrms/projectTrackingMaster?method=showPatientVisitJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showPatientVisitJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=PATIENT_VISIT_MASTER;
		  title="Add Patient Visit";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}


	public ModelAndView deletePatientVisit(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int patientVisitId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			patientVisitId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=projectTrackingMasterHandlerService.deletePatientVisit(patientVisitId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hrms/projectTrackingMaster?method=showPatientVisitJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showPatientVisitJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=PATIENT_VISIT_MASTER;
		  title="Delete Patient Visit";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);

	}

//	----------------------------Document Type Master ------------------------------------------
	public ModelAndView searchDocumentType(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String documentTypeCode  = null;
		String documentTypeName = null;
		String searchField= null;
		
		if(request.getParameter(DOCUMENT_TYPE_CODE) != null && !(request.getParameter(DOCUMENT_TYPE_CODE).equals(""))){
			documentTypeCode = request.getParameter(DOCUMENT_TYPE_CODE);
		}
		if(request.getParameter(BUDGET_TYPE_NAME) != null && !(request.getParameter(BUDGET_TYPE_NAME).equals(""))){
			documentTypeName = request.getParameter(BUDGET_TYPE_NAME);
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
			documentTypeCode=searchField;
			documentTypeName=null;
		}else{
			documentTypeCode=null;
			documentTypeName=searchField;
		}
		

		map = projectTrackingMasterHandlerService.searchDocumentType(documentTypeCode,documentTypeName);

		jsp = DOCUMENT_TYPE;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("documentTypeCode",documentTypeCode);
		map.put("documentTypeName",documentTypeName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showDocumentTypeJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		map = projectTrackingMasterHandlerService.showDocumentTypeJsp();
		@SuppressWarnings("unused")
		ArrayList  searchDocumentTypeList = (ArrayList)map.get("searchDocumentTypeList");


		jsp = DOCUMENT_TYPE;
		jsp += ".jsp";
		title = "BudgetType";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editDocumentType(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession();
		String documentTypeCode="";
		String documentTypeName="";
		int documentTypeId=0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		documentTypeCode=(String )session.getAttribute("documentTypeCode");
		documentTypeName=(String )session.getAttribute("documentTypeName");
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			documentTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			documentTypeCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			documentTypeName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", documentTypeId);
		generalMap.put("documentTypeCode",documentTypeCode);
		generalMap.put("name", documentTypeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);
		List existingDocumentTypeNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingDocumentTypeNameList.size() == 0)
		{
		dataUpdated = projectTrackingMasterHandlerService.editDocumentTypeToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
	}else if(existingDocumentTypeNameList.size() > 0){

		message = "Name already exists.";

	}
		url = "hms/hrms/projectTrackingMaster?method=showDocumentTypeJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showDocumentTypeJsp();		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=DOCUMENT_TYPE;
		  title="Edit Budget Type";
		  jsp += ".jsp";
		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addDocumentType(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MstrDoctype mstrDoctype = new MstrDoctype();
		String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		
		if(session.getAttribute("hospitalId") != null){
			hospitalId  = (Integer)session.getAttribute("hospitalId");
		}
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
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

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);

		List documentTypeCodeList = new ArrayList();
		List documentTypeNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			documentTypeCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			documentTypeNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((documentTypeCodeList.size() == 0 || documentTypeCodeList == null) && (documentTypeNameList.size() == 0 || documentTypeNameList == null))
		{
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			mstrDoctype.setHospital(hospital);
			mstrDoctype.setDocTypeCode(code);
			mstrDoctype.setDocTypeName(name);
			mstrDoctype.setStatus("y");
			mstrDoctype.setLastChgBy(changedBy);
			mstrDoctype.setLastChgDate(currentDate);
			mstrDoctype.setLastChgTime(currentTime);
			successfullyAdded = projectTrackingMasterHandlerService.addDocumentType(mstrDoctype);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((documentTypeCodeList.size() != 0 || documentTypeCodeList != null) || (documentTypeNameList.size() != 0) || documentTypeNameList != null){

			if((documentTypeCodeList.size() != 0 || documentTypeCodeList != null) && (documentTypeNameList.size() == 0 || documentTypeNameList == null)){

				message = "Document Type Code  already exists.";
			}
			else if((documentTypeNameList.size() != 0 || documentTypeNameList != null) && (documentTypeCodeList.size() == 0 ||documentTypeCodeList == null) ){

				message = "Document Type Name already exists.";
			}
			else if((documentTypeCodeList.size() != 0 || documentTypeCodeList != null) && (documentTypeNameList.size() != 0 || documentTypeNameList != null)){

				message = "Document Type Code and Document Type Name already exist.";
			}
		}

		url = "/hms/hrms/projectTrackingMaster?method=showDocumentTypeJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showDocumentTypeJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=DOCUMENT_TYPE;
		  title="Add Document Type";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView deleteDocumentType(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int documentTypeId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			documentTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=projectTrackingMasterHandlerService.deleteDocumentType(documentTypeId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hrms/projectTrackingMaster?method=showBudgetTypeJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showDocumentTypeJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=DOCUMENT_TYPE;
		  title="Delete Document Type";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);

	}
	//-------------------------Doument Master ------------------------------------------
	public ModelAndView showDocumentJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		map = projectTrackingMasterHandlerService.showDocumentJsp();
		@SuppressWarnings("unused")
		ArrayList  searchDocumentList = (ArrayList)map.get("searchDocumentList");
		ArrayList  documentTypeList = (ArrayList)map.get("documentTypeList");

		jsp = DOCUMENT_MASTER;
		jsp += ".jsp";
		title = "Document";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView searchDocument(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String documentCode  = null;
		String documentName = null;
		String searchField= null;
		
		if(request.getParameter(DOCUMENT_CODE) != null && !(request.getParameter(DOCUMENT_CODE).equals(""))){
			documentCode = request.getParameter(DOCUMENT_CODE);
		}
		if(request.getParameter(DOCUMENT_NAME) != null && !(request.getParameter(DOCUMENT_NAME).equals(""))){
			documentName = request.getParameter(DOCUMENT_NAME);
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
			documentCode=searchField;
			documentName=null;
		}else{
			documentCode=null;
			documentName=searchField;
		}
		

		map = projectTrackingMasterHandlerService.searchDocument(documentCode, documentName);

		jsp = DOCUMENT_MASTER;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("documentCode",documentCode);
		map.put("documentName",documentName);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView deleteDocument(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int documentId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			documentId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=projectTrackingMasterHandlerService.deleteDocument(documentId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hrms/projectTrackingMaster?method=showDocumentJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showDocumentJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=DOCUMENT_MASTER;
		  title="Delete Document Type";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);

	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addDocument(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		//MstrTask mstrTask = new MstrTask();
		String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int documentType = 0;
		MstrDocument mstrDocument = new MstrDocument();
		
		if(session.getAttribute("hospitalId") != null){
			hospitalId  = (Integer)session.getAttribute("hospitalId");
		}
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (!(request.getParameter(DOCUMENT_TYPE_ID).equals("")) && (request.getParameter(DOCUMENT_TYPE_ID) != null)) {
			documentType = Integer.parseInt(request.getParameter(DOCUMENT_TYPE_ID));
			MstrDoctype mstrDoctype = new MstrDoctype();
			mstrDoctype.setId(documentType);
			mstrDocument.setDocType(mstrDoctype);
		}
		
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
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

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);

		List documentCodeList = new ArrayList();
		List documentNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			documentCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			documentNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((documentCodeList.size() == 0 || documentCodeList == null) && (documentNameList.size() == 0 || documentNameList == null))
		{
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			
			
			mstrDocument.setHospital(hospital);
			mstrDocument.setDocCode(code);
			mstrDocument.setDocName(name);
			mstrDocument.setStatus("y");
			mstrDocument.setLastChgBy(changedBy);
			mstrDocument.setLastChgDate(currentDate);
			mstrDocument.setLastChgTime(currentTime);
			successfullyAdded = projectTrackingMasterHandlerService.addDocument(mstrDocument);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((documentCodeList.size() != 0 || documentCodeList != null) || (documentNameList.size() != 0) || documentNameList != null){

			if((documentCodeList.size() != 0 || documentCodeList != null) && (documentNameList.size() == 0 || documentNameList == null)){

				message = "Document  Code  already exists.";
			}
			else if((documentNameList.size() != 0 || documentNameList != null) && (documentCodeList.size() == 0 || documentCodeList == null) ){

				message = "Document  Name already exists.";
			}
			else if((documentCodeList.size() != 0 || documentCodeList != null) && (documentNameList.size() != 0 || documentNameList != null)){

				message = "Document  Code and Document  Name already exist.";
			}
		}

		url = "/hms/hrms/projectTrackingMaster?method=showDocumentJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showDocumentJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=DOCUMENT_MASTER;
		  title="Add Document ";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView editDocument(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession();
		String documentCode="";
		String documentName="";
		int documentId = 0;
		int documentTypeId=0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		documentCode=(String )session.getAttribute("documentCode");
		documentName=(String )session.getAttribute("documentName");
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			documentId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			documentCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			documentName = request.getParameter(SEARCH_NAME);
		}
		if(!(request.getParameter(DOCUMENT_TYPE_ID).equals(""))  && (request.getParameter(DOCUMENT_TYPE_ID) != null)){
			documentTypeId = Integer.parseInt(request.getParameter(DOCUMENT_TYPE_ID));
			generalMap.put("documentTypeId", documentTypeId);
		}
				
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", documentId);
		generalMap.put("documentCode", documentCode);
		generalMap.put("name", documentName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);
		List existingDocumentNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingDocumentNameList.size() == 0)
		{
		dataUpdated = projectTrackingMasterHandlerService.editDocumentToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
	}else if(existingDocumentNameList.size() > 0){

		message = "Name already exists.";

	}
		url = "hms/hrms/projectTrackingMaster?method=showDocumentJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showDocumentJsp();		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=DOCUMENT_MASTER;
		  title="Edit Document Master";
		  jsp += ".jsp";
		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}

//	----------------------------Rating Master ------------------------------------------
	public ModelAndView searchRating(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String ratingCode  = null;
		String ratingName = null;
		String searchField= null;
		
		if(request.getParameter(RATING_CODE) != null && !(request.getParameter(RATING_CODE).equals(""))){
			ratingCode = request.getParameter(RATING_CODE);
		}
		if(request.getParameter(RATING_NAME) != null && !(request.getParameter(RATING_NAME).equals(""))){
			ratingName = request.getParameter(RATING_NAME);
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
			ratingCode=searchField;
			ratingName=null;
		}else{
			ratingCode=null;
			ratingName=searchField;
		}
		

		map = projectTrackingMasterHandlerService.searchRating(ratingCode, ratingName);

		jsp = RATING_MASTER;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("ratingCode",ratingCode);
		map.put("ratingName",ratingName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showRatingJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		map = projectTrackingMasterHandlerService.showRatingJsp();
		@SuppressWarnings("unused")
		ArrayList  searchRatingList = (ArrayList)map.get("searchRatingList");

		jsp = RATING_MASTER;
		jsp += ".jsp";
		title = "Rating";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editRating(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession();
		String ratingCode="";
		String ratingName="";
		int ratingId=0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		ratingCode=(String )session.getAttribute("ratingCode");
		ratingName=(String )session.getAttribute("ratingName");
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			ratingId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			ratingCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			ratingName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", ratingId);
		generalMap.put("ratingCode", ratingCode);
		generalMap.put("name", ratingName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);
		List existingRatingNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingRatingNameList.size() == 0)
		{
		dataUpdated = projectTrackingMasterHandlerService.editRatingToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
	}else if(existingRatingNameList.size() > 0){

		message = "Name already exists.";

	}
		url = "hms/hrms/projectTrackingMaster?method=showRatingJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showRatingJsp();		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=RATING_MASTER;
		  title="Edit Rating";
		  jsp += ".jsp";
		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addRating(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MstrRating mstrRating = new MstrRating();
		String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		
		if(session.getAttribute("hospitalId") != null){
			hospitalId  = (Integer)session.getAttribute("hospitalId");
		}
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
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

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);

		List ratingCodeList = new ArrayList();
		List ratingNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			ratingCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			ratingNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((ratingCodeList.size() == 0 || ratingCodeList == null) && (ratingNameList.size() == 0 || ratingNameList == null))
		{
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			mstrRating.setHospital(hospital);
			mstrRating.setRatingCode(code);
			mstrRating.setRatingName(name);
			mstrRating.setStatus("y");
			mstrRating.setLastChgBy(changedBy);
			mstrRating.setLastChgDate(currentDate);
			mstrRating.setLastChgTime(currentTime);
			successfullyAdded = projectTrackingMasterHandlerService.addRating(mstrRating);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((ratingCodeList.size() != 0 || ratingCodeList != null) || (ratingNameList.size() != 0) || ratingNameList != null){

			if((ratingCodeList.size() != 0 || ratingCodeList != null) && (ratingNameList.size() == 0 || ratingNameList == null)){

				message = "Rating  Code  already exists.";
			}
			else if((ratingNameList.size() != 0 || ratingNameList != null) && (ratingCodeList.size() == 0 || ratingCodeList == null) ){

				message = "Rating Name already exists.";
			}
			else if((ratingCodeList.size() != 0 || ratingCodeList != null) && (ratingNameList.size() != 0 || ratingNameList != null)){

				message = "Rating Code and Rating Name already exist.";
			}
		}

		url = "/hms/hrms/projectTrackingMaster?method=showRatingJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showRatingJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=RATING_MASTER;
		  title="Add Rating";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteRating(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int ratingId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			ratingId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=projectTrackingMasterHandlerService.deleteRating(ratingId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hrms/projectTrackingMaster?method=showRatingJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showRatingJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=RATING_MASTER;
		  title="Delete Rating";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);

	}
	//-------------------------Department Task Mapping------------------------
	
	public ModelAndView showDeptTaskMapJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		map = projectTrackingMasterHandlerService.showDeptTaskMapJsp();
		@SuppressWarnings("unused")
		ArrayList  departmentList = (ArrayList)map.get("departmentList");
		ArrayList  deptTaskMapList = (ArrayList)map.get("deptTaskMapList");
		ArrayList  mstrTaskList = (ArrayList)map.get("mstrTaskList");

		jsp = "departmentTaskMap";
		jsp += ".jsp";
		title = "DepartmentTaskMap";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView saveDeptTasks(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		
		MasHospital hospital = new MasHospital();
		MasDepartment department = new MasDepartment();
		if(session.getAttribute(HOSPITAL_ID)!=null)
		{
			hospital.setId((Integer)session.getAttribute(HOSPITAL_ID));
		}
		if(request.getParameter(DEPARTMENT_TYPE)!=null && !request.getParameter(DEPARTMENT_TYPE).equals(""))
		{
			department.setId(new Integer(request.getParameter(DEPARTMENT_TYPE)));
		}
		
		map = projectTrackingMasterHandlerService.showDeptTaskMapJsp(department.getId());
		
		@SuppressWarnings("unused")
		
		ArrayList<MstrDeptTaskMap> alreadyAssignedTasksList = (ArrayList)map.get("deptTaskMapList");
		
		String [] toBeAssignedTasksIdsList = {"0"};
		List<Integer> toBeAssignedList = new ArrayList();
		List<Integer> alreadyAssignesdTaskIdList = new ArrayList<Integer>();
		if(request.getParameterValues("tempId")!=null && request.getParameterValues("tempId").length !=0)
		{
			toBeAssignedTasksIdsList = request.getParameterValues("tempId");
		}
		
		for(int i = 0 ; i< toBeAssignedTasksIdsList.length ; i++)
		{
			toBeAssignedList.add(new Integer(toBeAssignedTasksIdsList[i]));
		}
		for(MstrDeptTaskMap o : alreadyAssignedTasksList)
		{
			alreadyAssignesdTaskIdList.add(o.getTask().getId());
		}
		
		
		
		List duplicateToBeAssignedList = new ArrayList();
		List<Integer> duplicateAlreadyAssignedTasksList = new ArrayList<Integer>();
		
				
		for(Integer o : toBeAssignedList)
		{
			duplicateToBeAssignedList.add(o);
		}
		for(Integer o:  alreadyAssignesdTaskIdList)
		{
			duplicateAlreadyAssignedTasksList.add(o);
		}
		duplicateToBeAssignedList.removeAll(alreadyAssignesdTaskIdList);
		duplicateAlreadyAssignedTasksList.removeAll(toBeAssignedList);
		
		Map parameterMap = new HashMap();
		
		if(duplicateToBeAssignedList.size()>0){
		parameterMap.put("taskList", duplicateToBeAssignedList);
		parameterMap.put("deptId", department.getId());
		parameterMap.put("status", "n");
		
		
		List<MstrDeptTaskMap> inactiveDeptTaskMap = projectTrackingMasterHandlerService.getDeptTaskMap(parameterMap); 
		
		//checking first in Db and activating them
		for(MstrDeptTaskMap o: inactiveDeptTaskMap)
		{
			o.setStatus("y");
			projectTrackingMasterHandlerService.saveDeptTaskMapDB(o);
			duplicateToBeAssignedList.remove(o.getTask().getId());
		}
		}
		
		if(duplicateToBeAssignedList.size()>0){
		List<MstrTask> duplicateToBeAssignedList2 = projectTrackingMasterHandlerService.getDeptTaskMapFromDB(duplicateToBeAssignedList);
		// creating new
		for(MstrTask task : duplicateToBeAssignedList2)
		{
			MstrDeptTaskMap deptTaskMap = new MstrDeptTaskMap();
			deptTaskMap.setDepartment(department);
			deptTaskMap.setTask(task);
			deptTaskMap.setHospital(hospital);
			deptTaskMap.setStatus("y");
			boolean save = false;
			save = projectTrackingMasterHandlerService.saveDeptTaskMapDB(deptTaskMap);
		}
		}
		
		if(duplicateAlreadyAssignedTasksList.size()>0){
		parameterMap.put("taskList", duplicateAlreadyAssignedTasksList);
		parameterMap.put("deptId", department.getId());
		parameterMap.put("status", "y");
		List<MstrDeptTaskMap> deptTaskMapTaskWise = projectTrackingMasterHandlerService.getDeptTaskMap(parameterMap); 
		// inactivating 
		for(MstrDeptTaskMap o : deptTaskMapTaskWise)
		{
			o.setStatus("n");
			projectTrackingMasterHandlerService.saveDeptTaskMapDB(o);
		}
		}
		jsp = "departmentTaskMap";
		jsp += ".jsp";
		title = "DepartmentTaskMap";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
//-------------------------Role Department Task Mapping------------------------
	
	public ModelAndView showRoleDeptTaskMapJsp(HttpServletRequest request,HttpServletResponse response)
	{

		session = request.getSession(true);
		map = projectTrackingMasterHandlerService.showRoleDeptTaskMapJsp();
		jsp = ROLE_DEPT_TASK_MAP;
		jsp += ".jsp";
		title = "RoleDepartmentTaskMap";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView saveRoleDeptTasks(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		
		MasHospital hospital = new MasHospital();
		MasDepartment department = new MasDepartment();
		MasRank masRank = new MasRank();
		if(session.getAttribute(HOSPITAL_ID)!=null)
		{
			hospital.setId((Integer)session.getAttribute(HOSPITAL_ID));
		}
		if(request.getParameter(DEPARTMENT_TYPE)!=null && !request.getParameter(DEPARTMENT_TYPE).equals("0"))
		{
			department.setId(new Integer(request.getParameter(DEPARTMENT_TYPE)));
		}
		if(request.getParameter(ROLE_TYPE)!=null && !request.getParameter(ROLE_TYPE).equals(""))
		{
			masRank.setId(new Integer(request.getParameter(ROLE_TYPE)));
		}
		
		map = projectTrackingMasterHandlerService.showRoleDeptTaskMapJsp(department.getId(), masRank.getId());
		
		@SuppressWarnings("unused")
		
		ArrayList<MstrRoleTaskMap> alreadyAssignedTasksList = (ArrayList)map.get("roleTaskMapList");
		
		String [] toBeAssignedTasksIdsList = {"0"};
		List<Integer> toBeAssignedList = new ArrayList();
		List<Integer> alreadyAssignesdTaskIdList = new ArrayList<Integer>();
		if(request.getParameterValues("tempId")!=null && request.getParameterValues("tempId").length !=0)
		{
			toBeAssignedTasksIdsList = request.getParameterValues("tempId");
		}
		
		for(int i = 0 ; i< toBeAssignedTasksIdsList.length ; i++)
		{
			toBeAssignedList.add(new Integer(toBeAssignedTasksIdsList[i]));
		}
		
		
		if(alreadyAssignedTasksList != null){
		for(MstrRoleTaskMap o : alreadyAssignedTasksList)
		{
			alreadyAssignesdTaskIdList.add(o.getTask().getId());
		}
		
		}
		
		
		List duplicateToBeAssignedList = new ArrayList();
		List<Integer> duplicateAlreadyAssignedTasksList = new ArrayList<Integer>();
		
				
		for(Integer o : toBeAssignedList)
		{
			duplicateToBeAssignedList.add(o);
		}
		for(Integer o:  alreadyAssignesdTaskIdList)
		{
			duplicateAlreadyAssignedTasksList.add(o);
		}
		duplicateToBeAssignedList.removeAll(alreadyAssignesdTaskIdList);
		duplicateAlreadyAssignedTasksList.removeAll(toBeAssignedList);
		
		Map parameterMap = new HashMap();
		
		if(duplicateToBeAssignedList.size()>0){
		parameterMap.put("taskList", duplicateToBeAssignedList);
		parameterMap.put("deptId", department.getId());
		parameterMap.put("rankId", masRank.getId());
		parameterMap.put("status", "n");
		
		
		List<MstrRoleTaskMap> inactiveDeptTaskMap = projectTrackingMasterHandlerService.getRoleDeptTaskMap(parameterMap); 
		
		//checking first in Db and activating them
		for(MstrRoleTaskMap o: inactiveDeptTaskMap)
		{
			o.setStatus("y");
			projectTrackingMasterHandlerService.saveRoleDeptTaskMapDB(o);
			duplicateToBeAssignedList.remove(o.getTask().getId());
		}
		}
		
		if(duplicateToBeAssignedList.size()>0){
			
		List<MstrTask> duplicateToBeAssignedList2 = projectTrackingMasterHandlerService.getRoleDeptTaskMapFromDB(duplicateToBeAssignedList);
		// creating new
		for(MstrTask task : duplicateToBeAssignedList2)
		{
			MstrRoleTaskMap roleTaskMap = new MstrRoleTaskMap();
			roleTaskMap.setDepartment(department);
			roleTaskMap.setTask(task);
			// roleTaskMap.setHospital(hospital);
			roleTaskMap.setRank(masRank);
			roleTaskMap.setStatus("y");
			boolean save = false;
			save = projectTrackingMasterHandlerService.saveRoleDeptTaskMapDB(roleTaskMap);
		}
		}
		
		if(duplicateAlreadyAssignedTasksList.size()>0){
			
		parameterMap.put("taskList", duplicateAlreadyAssignedTasksList);
		parameterMap.put("deptId", department.getId());
		parameterMap.put("rankId",masRank.getId());
		parameterMap.put("status", "y");
		List<MstrRoleTaskMap> roleDeptTaskMapTaskWise = projectTrackingMasterHandlerService.getRoleDeptTaskMap(parameterMap); 
		// inactivating 
		for(MstrRoleTaskMap o : roleDeptTaskMapTaskWise)
		{
			o.setStatus("n");
			projectTrackingMasterHandlerService.saveRoleDeptTaskMapDB(o);
		}
		}
	//	map = projectTrackingMasterHandlerService.showRoleDeptTaskMapJsp();;
		jsp = "roleDeptTaskMap";
		jsp += ".jsp";
		title = "Role-DepartmentTaskMap";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
//	----------------------------Vendor Master ------------------------------------------
	public ModelAndView searchVendor(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String vendorCode  = null;
		String vendorName = null;
		String searchField= null;
		
		if(request.getParameter(VENDOR_CODE) != null && !(request.getParameter(VENDOR_CODE).equals(""))){
			vendorCode = request.getParameter(VENDOR_CODE);
		}
		
		if(request.getParameter(VENDOR_NAME) != null && !(request.getParameter(VENDOR_NAME).equals(""))){
			vendorName = request.getParameter(VENDOR_NAME);
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
			vendorCode=searchField;
			vendorName=null;
		}else{
			vendorCode=null;
			vendorName=searchField;
		}
		

		map = projectTrackingMasterHandlerService.searchVendor(vendorCode, vendorName);

		jsp = VENDOR;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("vendorCode",vendorCode);
		map.put("vendorName",vendorName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showVendorJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		map = projectTrackingMasterHandlerService.showVendorJsp();
		@SuppressWarnings("unused")
		ArrayList  searchVendorList = (ArrayList)map.get("searchVendorList");
		ArrayList  mstrRatingList = (ArrayList)map.get("mstrRatingList");
		ArrayList  masBankMasterList = (ArrayList)map.get("masBankMasterList");
		ArrayList  vendorServiceTypeList = (ArrayList)map.get("vendorServiceTypeList");
		jsp = VENDOR;
		jsp += ".jsp";
		title = "Vendor";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView editVendor(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession();
		
		Integer vendorId = 0;
		String vendorCode="";
		String vendorName="";
		String VendorAddress = "";
		String contactNo = "";
		String faxNo = "";
		String emailId  = "";
		String webSite = "";
		String custServNo = "";
		int vendorService = 0;
		String vendorPanNo = "";
		Integer vendorbank = 0;
		String vendorBranch = "";
		String accountNo = "";
		String previousAssociate = "";
		Integer ratingId =0;
		String comments = "";
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

//		vendorCode=(String )session.getAttribute("vendorCode");
//		vendorName=(String )session.getAttribute("vendorName");
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			vendorId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			vendorCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			vendorName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(VENDOR_ADDRESS) != null && !(request.getParameter(VENDOR_ADDRESS).equals(""))) {
			VendorAddress = request.getParameter(VENDOR_ADDRESS);
		}
		if (request.getParameter(VENDOR_CONTACT_NO) != null && !(request.getParameter(VENDOR_CONTACT_NO).equals(""))) {
			contactNo = request.getParameter(VENDOR_CONTACT_NO);
		}
		if (request.getParameter(VENDOR_FAX_NO) != null && !(request.getParameter(VENDOR_FAX_NO).equals(""))) {
			faxNo = request.getParameter(VENDOR_FAX_NO);
		}
		if (request.getParameter(VENDOR_EMAIL_ID) != null && !(request.getParameter(VENDOR_EMAIL_ID).equals(""))) {
			emailId = request.getParameter(VENDOR_EMAIL_ID);
		}
		if (request.getParameter(VENDOR_WEB_SITE) != null && !(request.getParameter(VENDOR_WEB_SITE).equals(""))) {
			webSite = request.getParameter(VENDOR_WEB_SITE);
		}
		if (request.getParameter(VENDOR_CUST_SERV_NO) != null && !(request.getParameter(VENDOR_CUST_SERV_NO).equals(""))) {
			custServNo = request.getParameter(VENDOR_CUST_SERV_NO);
		}
		if (request.getParameter(VENDOR_SERVICE) != null && !(request.getParameter(VENDOR_SERVICE).equals(""))) {
			vendorService = Integer.parseInt(request.getParameter(VENDOR_SERVICE));
		}
		if (request.getParameter(VENDOR_PAN_NO) != null && !(request.getParameter(VENDOR_PAN_NO).equals(""))) {
			vendorPanNo = request.getParameter(VENDOR_PAN_NO);
		}
		if (request.getParameter(VENDOR_BANK) != null && !(request.getParameter(VENDOR_BANK).equals("0"))) {
			vendorbank = Integer.parseInt(request.getParameter(VENDOR_BANK));
			generalMap.put("vendorbank", vendorbank);
		}
		if (request.getParameter(VENDOR_BRANCH) != null && !(request.getParameter(VENDOR_BRANCH).equals(""))) {
			vendorBranch = request.getParameter(VENDOR_BRANCH);
		}
		if (request.getParameter(VENDOR_ACC_NO) != null && !(request.getParameter(VENDOR_ACC_NO).equals(""))) {
			accountNo = request.getParameter(VENDOR_ACC_NO);
		}
		if (request.getParameter(PEREVIOUS_ASSOCIATE) != null && !(request.getParameter(PEREVIOUS_ASSOCIATE).equals(""))) {
			previousAssociate = request.getParameter(PEREVIOUS_ASSOCIATE);
		}
		if (request.getParameter(VENDOR_RATING) != null && !(request.getParameter(VENDOR_RATING).equals("0"))) {
			ratingId = Integer.parseInt(request.getParameter(VENDOR_RATING));
			generalMap.put("ratingId",ratingId);
		}
		if (request.getParameter(COMMENTS) != null && !(request.getParameter(COMMENTS).equals(""))) {
			comments = request.getParameter(COMMENTS);
		}
				
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("vendorId", vendorId);
		generalMap.put("vendorCode", vendorCode);
		generalMap.put("vendorName", vendorName);
		generalMap.put("VendorAddress",VendorAddress);
		generalMap.put("contactNo", contactNo);
		generalMap.put("faxNo", faxNo);
		generalMap.put("emailId", emailId);
		generalMap.put("webSite", webSite);
		generalMap.put("custServNo",custServNo);
		generalMap.put("vendorService",vendorService);
		generalMap.put("vendorPanNo",vendorPanNo);
		
		generalMap.put("vendorBranch", vendorBranch);
		generalMap.put("accountNo", accountNo);
		generalMap.put("previousAssociate",previousAssociate);
		
		generalMap.put("comments",comments);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);
		List existingtaskNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingtaskNameList.size() == 0)
		{
		dataUpdated = projectTrackingMasterHandlerService.editVendorToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
	}else if(existingtaskNameList.size() > 0){

		message = "Name already exists.";

	}
		url = "hms/hrms/projectTrackingMaster?method=showVendorJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showVendorJsp();		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=VENDOR;
		  title="Edit Task Master";
		  jsp += ".jsp";
		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView addVendor(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MstrVendor mstrVendor = new MstrVendor();
		
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		String VendorAddress = "";
		String contactNo = "";
		String faxNo = "";
		String emailId  ="";
		String webSite = "";
		String custServNo = "";
		int vendorService = 0;
		String vendorPanNo = "";
		Integer vendorbank = 0;
		String vendorBranch = "";
		String accountNo = "";
		String previousAssociate = "";
		
		String comments = "";
		String changedBy = "";
		Date currentDate = new Date();
		int hospitalId = 0;
		
		
		if(session.getAttribute("hospitalId") != null){
			hospitalId  = (Integer)session.getAttribute("hospitalId");
		}
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(VENDOR_ADDRESS) != null) {
			VendorAddress = request.getParameter(VENDOR_ADDRESS);
		}
		if (request.getParameter(VENDOR_CONTACT_NO) != null) {
			contactNo = request.getParameter(VENDOR_CONTACT_NO);
		}
		if (!(request.getParameter(VENDOR_FAX_NO).equals("")) &&  request.getParameter(VENDOR_FAX_NO) != null ) {
			faxNo = request.getParameter(VENDOR_FAX_NO);
		}
		if (request.getParameter(VENDOR_EMAIL_ID) != null) {
			emailId = request.getParameter(VENDOR_EMAIL_ID);
		}
		if (request.getParameter(VENDOR_WEB_SITE) != null) {
			webSite = request.getParameter(VENDOR_WEB_SITE);
		}
		if (request.getParameter(VENDOR_CUST_SERV_NO) != null) {
			custServNo = request.getParameter(VENDOR_CUST_SERV_NO);
		}
		if (request.getParameter(VENDOR_SERVICE) != null) {
			vendorService = Integer.parseInt(request.getParameter(VENDOR_SERVICE));
		}
		if (request.getParameter(VENDOR_PAN_NO) != null) {
			vendorPanNo = request.getParameter(VENDOR_PAN_NO);
		}
		if (!(request.getParameter(VENDOR_BANK).equals("0"))) {
			vendorbank = Integer.parseInt(request.getParameter(VENDOR_BANK));
			MasBankMaster  masBankMaster = new MasBankMaster();
			masBankMaster.setId(vendorbank);
			mstrVendor.setBank(masBankMaster);
		}
		if (request.getParameter(VENDOR_BRANCH) != null) {
			vendorBranch = request.getParameter(VENDOR_BRANCH);
		}
		if (request.getParameter(VENDOR_ACC_NO) != null) {
			accountNo = request.getParameter(VENDOR_ACC_NO);
		}
		if (request.getParameter(PEREVIOUS_ASSOCIATE) != null) {
			previousAssociate = request.getParameter(PEREVIOUS_ASSOCIATE);
		}
		if (!(request.getParameter(VENDOR_RATING).equals("0"))) {
			int ratingId = Integer.parseInt(request.getParameter(VENDOR_RATING));
			MstrRating mstrRating = new MstrRating();
			mstrRating.setId(ratingId);
			mstrVendor.setRating(mstrRating);
		}
		if (request.getParameter(COMMENTS) != null) {
			comments = request.getParameter(COMMENTS);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
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

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);

		List vendorCodeList = new ArrayList();
		List vendorNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			vendorCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			vendorNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((vendorCodeList.size() == 0 || vendorCodeList == null) && (vendorNameList.size() == 0 || vendorNameList == null))
		{
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			mstrVendor.setCompany(hospital);
			mstrVendor.setVendorCode(code);
			mstrVendor.setVendorName(name);
			mstrVendor.setVendorAddress(VendorAddress);
			mstrVendor.setVendorContactNo(contactNo);
			mstrVendor.setVendorFaxNo(faxNo);
			mstrVendor.setVendorEmailId(emailId);
			mstrVendor.setVendorWebSite(webSite);
			mstrVendor.setVendorCustServNo(custServNo);
			VendorServiceType vendorServiceType = new VendorServiceType();
			vendorServiceType.setId(vendorService);
			mstrVendor.setVendorService(vendorServiceType);
			mstrVendor.setVendorPanNo(vendorPanNo);
			
			mstrVendor.setVendorBranch(vendorBranch);
			mstrVendor.setVendorAccNo(accountNo);
			mstrVendor.setPereviousAssociate(previousAssociate);
			
			mstrVendor.setComments(comments);
			mstrVendor.setStatus("y");
			mstrVendor.setLastChgBy(changedBy);
			mstrVendor.setLastChgDate(currentDate);
			mstrVendor.setLastChgTime(currentTime);
			successfullyAdded = projectTrackingMasterHandlerService.addVendor(mstrVendor);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((vendorCodeList.size() != 0 || vendorCodeList != null) || (vendorNameList.size() != 0) || vendorNameList != null){

			if((vendorCodeList.size() != 0 || vendorCodeList != null) && (vendorNameList.size() == 0 || vendorNameList == null)){

				message = "Vendor  Code  already exists.";
			}
			else if((vendorNameList.size() != 0 || vendorNameList != null) && (vendorCodeList.size() == 0 || vendorCodeList == null) ){

				message = "Vendor  Name already exists.";
			}
			else if((vendorCodeList.size() != 0 || vendorCodeList != null) && (vendorNameList.size() != 0 || vendorNameList != null)){

				message = "Vendor Code and Task Type Name already exist.";
			}
		}

		url = "/hms/hrms/projectTrackingMaster?method=showVendorJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showVendorJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=VENDOR;
		  title="Add Task Type";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteVendor(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int vendorId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			vendorId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=projectTrackingMasterHandlerService.deleteVendor(vendorId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hrms/projectTrackingMaster?method=showVendorJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showVendorJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=VENDOR;
		  title="Delete Vendor";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);

	}
	
	//-----------------------------Pi Master----------------------------------
	public ModelAndView showPiJsp(HttpServletRequest request,HttpServletResponse response)
	{Map<String, Object> map= new HashMap<String, Object>();		
		session = request.getSession(true);
		map = projectTrackingMasterHandlerService.showPiJsp();
	
		jsp = PI;
		jsp += ".jsp";
		title = "PI";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView searchPi(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String piCode  = null;
		String piName = null;
		String searchField= null;
		
		if(request.getParameter(PI_CODE) != null && !(request.getParameter(PI_CODE).equals(""))){
			piCode = request.getParameter(PI_CODE);
		}
		
		if(request.getParameter(PI_NAME) != null && !(request.getParameter(PI_NAME).equals(""))){
			piName = request.getParameter(PI_NAME);
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
			piCode=searchField;
			piName=null;
		}else{
			piCode=null;
			piName=searchField;
		}
		

		map = projectTrackingMasterHandlerService.searchPi(piCode, piName);

		jsp = PI;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("piCode",piCode);
		map.put("piName",piName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addPi(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MstrPiHeader mstrPiHeader = new MstrPiHeader();
		Map<String, Object>	newMap = new HashMap<String, Object>();
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		String address   = null;
		String contactNo = null;
		String mobileNo  = null;
		String emailId   = null;
		String faxNo     = null;
		String medRegNo  = null;
		String panNo     = null;
		Integer piBank   = 0;
		String branch    = null;
		String previousAssociate = null;
		String accountNo = null;
		Integer ratingId = 0;
		String comments = null;
		String designation = null;
		String changedBy = null;
		Date currentDate = new Date();
		String changeTime = null;
		String thpId = null;
		String siteId = null;
		int hospitalId = 0;
		
		
		if(session.getAttribute("hospitalId") != null){
			hospitalId  = (Integer)session.getAttribute("hospitalId");
		}
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(PI_ADDRESS) != null) {
			address = request.getParameter(PI_ADDRESS);
		}
		if (request.getParameter(PI_CONTACT_NO) != null) {
			contactNo = request.getParameter(PI_CONTACT_NO);
		}
		if (request.getParameter(PI_MOBILE_NO) != null) {
			mobileNo = request.getParameter(PI_MOBILE_NO);
		}
		if (request.getParameter(PI_EMAIL_ID) != null) {
			emailId = request.getParameter(PI_EMAIL_ID);
		}
		if (request.getParameter(PI_FAX_NO) != null) {
			faxNo = request.getParameter(PI_FAX_NO);
		}
		if (request.getParameter(PI_MED_REG_NO) != null) {
			medRegNo = request.getParameter(PI_MED_REG_NO);
		}
		if (request.getParameter(PI_PAN_NO) != null) {
			panNo = request.getParameter(PI_PAN_NO);
		}
		if (!request.getParameter(PI_BANK).equals("0")) {
			piBank = Integer.parseInt(request.getParameter(PI_BANK));
			MasBankMaster  masBankMaster = new MasBankMaster();
			masBankMaster.setId(piBank);
			mstrPiHeader.setBank(masBankMaster);
		}
		if (request.getParameter(PI_BRANCH) != null) {
			branch = request.getParameter(PI_BRANCH);
		}
		if (request.getParameter(PI_PEREVIOUS_ASSOCIATE) != null) {
			previousAssociate = request.getParameter(PI_PEREVIOUS_ASSOCIATE);
		}
		if (request.getParameter(PI_ACC_NO) != null) {
			accountNo = request.getParameter(PI_ACC_NO);
		}
		if (!request.getParameter(PI_RATING).equals("0")) {
			ratingId = Integer.parseInt(request.getParameter(PI_RATING));
			MstrRating mstrRating = new MstrRating();
			mstrRating.setId(ratingId);
			mstrPiHeader.setRating(mstrRating);
		}
		if (request.getParameter(PI_COMMENTS) != null) {
			comments = request.getParameter(PI_COMMENTS);
		}
		if (request.getParameter(PI_DESIGNATION) != null) {
			designation = request.getParameter(PI_DESIGNATION);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
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
		String[] toBeAssignedIdsList = {"0"};
		if(request.getParameterValues("thpId")!=null)
		{
			toBeAssignedIdsList = request.getParameterValues("thpId");
			newMap.put("toBeAssignedIdsList", toBeAssignedIdsList);
		}
		String[] toBeAssignedSiteList = {"0"};
		if(request.getParameterValues("siteId")!=null)
		{
			toBeAssignedSiteList = request.getParameterValues("siteId");
			newMap.put("toBeAssignedSiteList", toBeAssignedSiteList);
		}

		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);

		List piCodeList = new ArrayList();
		List piNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			piCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			piNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((piCodeList.size() == 0 || piCodeList == null) && (piNameList.size() == 0 || piNameList == null))
		{
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			mstrPiHeader.setHospital(hospital);
			mstrPiHeader.setPiCode(code);
			mstrPiHeader.setPiName(name);
			mstrPiHeader.setPiAddress(address);
			mstrPiHeader.setPiContactNo(contactNo);
			mstrPiHeader.setPiMobileNo(mobileNo);
			mstrPiHeader.setPiEmailId(emailId);
			mstrPiHeader.setPiFaxNo(faxNo);
			mstrPiHeader.setPiMedRegNo(medRegNo);
			mstrPiHeader.setPiPanNo(panNo);
			
			mstrPiHeader.setPiBranch(branch);
			mstrPiHeader.setPiPreviousAssociation(previousAssociate);
			mstrPiHeader.setPiAccNo(accountNo);
			
			mstrPiHeader.setComments(comments);
			mstrPiHeader.setDesignation(designation);
			mstrPiHeader.setStatus("y");
			mstrPiHeader.setLastChgBy(changedBy);
			mstrPiHeader.setLastChgDate(currentDate);
			mstrPiHeader.setLastChgTime(currentTime);
			
			newMap.put("mstrPiHeader", mstrPiHeader);
			
			successfullyAdded = projectTrackingMasterHandlerService.addPi(newMap);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((piCodeList.size() != 0 || piCodeList != null) || (piNameList.size() != 0) || piNameList != null){

			if((piCodeList.size() != 0 || piCodeList != null) && (piNameList.size() == 0 || piNameList == null)){

				message = "PI  Code  already exists.";
			}
			else if((piNameList.size() != 0 || piNameList != null) && (piCodeList.size() == 0 || piCodeList == null) ){

				message = "Pi  Name already exists.";
			}
			else if((piCodeList.size() != 0 || piCodeList != null) && (piNameList.size() != 0 || piNameList != null)){

				message = "Pi Code and Task Type Name already exist.";
			}
		}

		url = "/hms/hrms/projectTrackingMaster?method=showPiJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showPiJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=PI;
		  title="Add PI";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView editPi(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession();
		
		Integer piId     = 0;
		String  piCode    = null;
		String  piName    = null;
		String  address   = null;
		String  contactNo = null;
		String  mobileNo  = null;
		String  emailId   = null;
		String  faxNo     = null;
		String  medRegNo  = null;
		String  panNo     = null;
		
		String  branch    = null;
		String  previousAssociate = null;
		String  accountNo = null;
		
		String  comments = null;
		String  designation = null;
		String  changedBy = null;
		Date    changedDate = null;
		String  changedTime = null;
		String  thpId = null;
		String  siteId = null;
		int     hospitalId = 0;


		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			piId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			piCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			piName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(PI_ADDRESS) != null) {
			address = request.getParameter(PI_ADDRESS);
		}
		if (request.getParameter(PI_CONTACT_NO) != null) {
			contactNo = request.getParameter(PI_CONTACT_NO);
		}
		if (request.getParameter(PI_MOBILE_NO) != null) {
			mobileNo = request.getParameter(PI_MOBILE_NO);
		}
		if (request.getParameter(PI_EMAIL_ID) != null) {
			emailId = request.getParameter(PI_EMAIL_ID);
		}
		if (request.getParameter(PI_FAX_NO) != null) {
			faxNo = request.getParameter(PI_FAX_NO);
		}
		if (request.getParameter(PI_MED_REG_NO) != null) {
			medRegNo = request.getParameter(PI_MED_REG_NO);
		}
		if (request.getParameter(PI_PAN_NO) != null) {
			panNo = request.getParameter(PI_PAN_NO);
		}
		if (!(request.getParameter(PI_BANK).equals("0"))) {
			int piBank = Integer.parseInt(request.getParameter(PI_BANK));
			generalMap.put("piBank", piBank);
		}
		if (request.getParameter(PI_BRANCH) != null) {
			branch = request.getParameter(PI_BRANCH);
		}
		if (request.getParameter(PI_PEREVIOUS_ASSOCIATE) != null) {
			previousAssociate = request.getParameter(PI_PEREVIOUS_ASSOCIATE);
		}
		if (request.getParameter(PI_ACC_NO) != null) {
			accountNo = request.getParameter(PI_ACC_NO);
		}
		if (!(request.getParameter(PI_RATING).equals("0"))) {
			int ratingId = Integer.parseInt(request.getParameter(PI_RATING));
			generalMap.put("ratingId",ratingId);
		}
		if (request.getParameter(PI_COMMENTS) != null) {
			comments = request.getParameter(PI_COMMENTS);
		}
		if (request.getParameter(PI_DESIGNATION) != null) {
			designation = request.getParameter(PI_DESIGNATION);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		
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
		String[] toBeAssignedIdsList = {"0"};
		if(request.getParameterValues("thpId")!=null)
		{
			toBeAssignedIdsList = request.getParameterValues("thpId");
			generalMap.put("toBeAssignedIdsList", toBeAssignedIdsList);
		}
		String[] toBeAssignedSiteList = {"0"};
		if(request.getParameterValues("siteId")!=null)
		{
			toBeAssignedSiteList = request.getParameterValues("siteId");
			generalMap.put("toBeAssignedSiteList", toBeAssignedSiteList);
		}
		
		changedDate = new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("piId", piId);
		generalMap.put("piCode", piCode);
		generalMap.put("piName", piName);
		generalMap.put("address",address);
		generalMap.put("contactNo", contactNo);
		generalMap.put("mobileNo", mobileNo);
		generalMap.put("emailId", emailId);
		generalMap.put("faxNo", faxNo);
		generalMap.put("medRegNo",medRegNo);
		generalMap.put("panNo",panNo);
		
		generalMap.put("branch", branch);
		generalMap.put("previousAssociate",previousAssociate);
		generalMap.put("accountNo", accountNo);
		
		generalMap.put("comments",comments);
		generalMap.put("designation", designation);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		
		
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);
		List existingtaskNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingtaskNameList.size() == 0)
		{
		dataUpdated = projectTrackingMasterHandlerService.editPiToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
	}else if(existingtaskNameList.size() > 0){

		message = "Name already exists.";

	}
		url = "hms/hrms/projectTrackingMaster?method=showPiJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showPiJsp();		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=PI;
		  title="Edit PI Master";
		  jsp += ".jsp";
		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	public ModelAndView deletePi(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int piId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			piId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=projectTrackingMasterHandlerService.deletePi(piId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hrms/projectTrackingMaster?method=showPiJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showPiJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=PI;
		  title="Delete PI";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);

	}
	
	//-----------------------------Site Master----------------------------------
	public ModelAndView showSiteJsp(HttpServletRequest request,HttpServletResponse response)
	{Map<String, Object> map= new HashMap<String, Object>();		
		session = request.getSession(true);
		map = projectTrackingMasterHandlerService.showSiteJsp();
	
		jsp = SITE;
		jsp += ".jsp";
		title = "PI";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView searchSite(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String siteCode  = null;
		String siteName = null;
		String searchField= null;
		
		if(request.getParameter(SITE_CODE) != null && !(request.getParameter(SITE_CODE).equals(""))){
			siteCode = request.getParameter(SITE_CODE);
		}
		
		if(request.getParameter(SITE_NAME) != null && !(request.getParameter(SITE_NAME).equals(""))){
			siteName = request.getParameter(SITE_NAME);
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
			siteCode=searchField;
			siteName=null;
		}else{
			siteCode=null;
			siteName=searchField;
		}
		

		map = projectTrackingMasterHandlerService.searchSite(siteCode, siteName);

		jsp = SITE;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("siteCode",siteCode);
		map.put("siteName",siteName);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addSite(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MstrSiteHeader mstrSiteHeader = new MstrSiteHeader();
		Map<String, Object>	newMap = new HashMap<String, Object>();
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		String address     = null;
		String accountNo   = null;
		String contactNo   = null;
		String faxNo       = null;
		String emailId     = null;
		String webSite     = null;
		String previousAssociate = null;
		Integer ratingId   = 0;
		String panNo       = null;
		Integer bankId     = 0;
		String branch      = null;
		String ecName      = null;
		String ecConvName  = null;
		String ecContactNo = null;
		String ecEmailId   = null;
		String ecFaxNo     = null;
		Integer ecBankId   = 0;
		String ecBranch    = null;
		String ecAccountNo = null;
		String ecPanNo     = null;
		String comments    = null;
		String changedBy   = null;
		Date   currentDate   = new Date();
		String changeTime  = null;
		String thpId       = null;
		int hospitalId     = 0;
		
		
		if(session.getAttribute("hospitalId") != null){
			hospitalId  = (Integer)session.getAttribute("hospitalId");
		}
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(SITE_ADDRESS) != null) {
			address = request.getParameter(SITE_ADDRESS);
		}
		if (request.getParameter(SITE_ACC_NO) != null) {
			accountNo = request.getParameter(SITE_ACC_NO);
		}
		if (request.getParameter(SITE_CONTACT_NO) != null) {
			contactNo = request.getParameter(SITE_CONTACT_NO);
		}
		if (request.getParameter(SITE_FAX_NO) != null) {
			faxNo = request.getParameter(SITE_FAX_NO);
		}
		if (request.getParameter(SITE_EMAIL_ID) != null) {
			emailId = request.getParameter(SITE_EMAIL_ID);
		}
		if (request.getParameter(SITE_WEB_SITE) != null) {
			webSite = request.getParameter(SITE_WEB_SITE);
		}
		if (request.getParameter(SITE_PEREVIOUS_ASSOCIATE) != null) {
			previousAssociate = request.getParameter(SITE_PEREVIOUS_ASSOCIATE);
		}
		if (!(request.getParameter(SITE_RATING_ID).equals("0"))  && (request.getParameter(SITE_RATING_ID) != null)) {
			ratingId = Integer.parseInt(request.getParameter(SITE_RATING_ID));
			MstrRating mstrRating = new MstrRating();
			mstrRating.setId(ratingId);
			mstrSiteHeader.setRating(mstrRating);
		}
		if (request.getParameter(SITE_PAN_NO) != null) {
			panNo = request.getParameter(SITE_PAN_NO);
		}
		if (!(request.getParameter(SITE_BANK_ID).equals("0")) && (request.getParameter(SITE_BANK_ID) != null)) {
			bankId = Integer.parseInt(request.getParameter(SITE_BANK_ID));
			MasBankMaster  masBankMaster = new MasBankMaster();
			masBankMaster.setId(bankId);
			mstrSiteHeader.setBank(masBankMaster);
		}
		if (request.getParameter(SITE_BRANCH) != null) {
			branch = request.getParameter(SITE_BRANCH);
		}
		if (request.getParameter(EC_NAME) != null) {
			ecName = request.getParameter(EC_NAME);
		}
		if (request.getParameter(EC_CONV_NAME) != null) {
			ecConvName = request.getParameter(EC_CONV_NAME);
		}
		if (request.getParameter(EC_CONTACT_NO) != null) {
			ecContactNo = request.getParameter(EC_CONTACT_NO);
		}
		if (request.getParameter(EC_EMAIL_ID) != null) {
			ecEmailId = request.getParameter(EC_EMAIL_ID);
		}
		if (request.getParameter(EC_FAX_NO) != null) {
			ecFaxNo = request.getParameter(EC_FAX_NO);
		}
		
		if (!(request.getParameter(EC_BANK_ID).equals("0"))) {
			ecBankId = Integer.parseInt(request.getParameter(EC_BANK_ID));
			MasBankMaster  masBankMaster1 = new MasBankMaster();
			masBankMaster1.setId(ecBankId);
			mstrSiteHeader.setEcBank(masBankMaster1);
		}
		if (request.getParameter(EC_BRANCH) != null) {
			ecBranch = request.getParameter(EC_BRANCH);
		}
		if (request.getParameter(EC_ACC_NO) != null) {
			ecAccountNo = request.getParameter(EC_ACC_NO);
		}
		if (request.getParameter(EC_PAN_NO) != null) {
			ecBranch = request.getParameter(EC_PAN_NO);
		}
		if (request.getParameter(EC_ACC_NO) != null) {
			ecPanNo = request.getParameter(EC_ACC_NO);
		}
		if (request.getParameter(COMMENTS) != null) {
			comments = request.getParameter(COMMENTS);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
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

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);

		List siteCodeList = new ArrayList();
		List siteNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			siteCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			siteNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((siteCodeList.size() == 0 || siteCodeList == null) && (siteNameList.size() == 0 || siteNameList == null))
		{
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			mstrSiteHeader.setHospital(hospital);
			mstrSiteHeader.setSiteCode(code);
			mstrSiteHeader.setSiteName(name);
			mstrSiteHeader.setSiteAddress(address);
			mstrSiteHeader.setSiteAccountNo(accountNo);
			mstrSiteHeader.setSiteContactNo(contactNo);
			mstrSiteHeader.setSiteFaxNo(faxNo);
			mstrSiteHeader.setSiteEmailId(emailId);
			mstrSiteHeader.setSiteWebsite(webSite);
			mstrSiteHeader.setPereviousAssociate(previousAssociate);
			mstrSiteHeader.setSitePanNo(panNo);
			
			
						
			
			
			mstrSiteHeader.setSiteBranch(branch);
			mstrSiteHeader.setEcName(ecName);
			mstrSiteHeader.setEcConvrName(ecConvName);
			mstrSiteHeader.setEcContactNo(ecContactNo);
			mstrSiteHeader.setEcEmailId(ecEmailId);
			mstrSiteHeader.setEcFaxNo(ecFaxNo);
			
			
			
			mstrSiteHeader.setEcBranch(ecBranch);
			mstrSiteHeader.setEcAcNo(ecAccountNo);
			mstrSiteHeader.setEcPanNo(ecPanNo);
			mstrSiteHeader.setComments(comments);
			mstrSiteHeader.setStatus("y");
			mstrSiteHeader.setLastChgBy(changedBy);
			mstrSiteHeader.setLastChgDate(currentDate);
			mstrSiteHeader.setLastChgTime(currentTime);
			newMap.put("mstrSiteHeader", mstrSiteHeader);
						
			String[] toBeAssignedThpList = {"0"};
			if(request.getParameterValues("thpId")!=null)
			{
				toBeAssignedThpList = request.getParameterValues("thpId");
			}
			newMap.put("toBeAssignedThpList", toBeAssignedThpList);
			
			successfullyAdded = projectTrackingMasterHandlerService.addSite(newMap);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((siteCodeList.size() != 0 || siteCodeList != null) || (siteNameList.size() != 0) || siteNameList != null){

			if((siteCodeList.size() != 0 || siteCodeList != null) && (siteNameList.size() == 0 || siteNameList == null)){

				message = "Site  Code  already exists.";
			}
			else if((siteNameList.size() != 0 || siteNameList != null) && (siteCodeList.size() == 0 || siteCodeList == null) ){

				message = "Site  Name already exists.";
			}
			else if((siteCodeList.size() != 0 || siteCodeList != null) && (siteNameList.size() != 0 || siteNameList != null)){

				message = "Site Code and Task Type Name already exist.";
			}
		}

		url = "/hms/hrms/projectTrackingMaster?method=showSiteJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showSiteJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=SITE;
		  title="Add Site";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView editSite(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession();
		
		Integer siteId     =0;
		String  siteCode   = null;
		String  siteName   = null;
		String address     = null;
		String accountNo   = null;
		String contactNo   = null;
		String faxNo       = null;
		String emailId     = null;
		String webSite     = null;
		String previousAssociate = null;
		
		String panNo       = null;
		Integer bankId     = 0;
		String branch      = null;
		String ecName      = null;
		String ecConvName  = null;
		String ecContactNo = null;
		String ecEmailId   = null;
		String ecFaxNo     = null;
		Integer ecBankId   = 0;
		String ecBranch    = null;
		String ecAccountNo = null;
		String ecPanNo     = null;
		String comments    = null;
		String changedBy   = null;
		Date   changedDate   = new Date();
		String changedTime  = null;
		String thpId       = null;
		int hospitalId     = 0;
		//***************
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			siteId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			siteCode = request.getParameter(CODE);
		}		
		
		if (request.getParameter(SEARCH_NAME) != null) {
			siteName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(SITE_ADDRESS) != null) {
			address = request.getParameter(SITE_ADDRESS);
		}
		if (request.getParameter(SITE_ACC_NO) != null) {
			accountNo = request.getParameter(SITE_ACC_NO);
		}
		if (request.getParameter(SITE_CONTACT_NO) != null) {
			contactNo = request.getParameter(SITE_CONTACT_NO);
		}
		if (request.getParameter(SITE_FAX_NO) != null) {
			faxNo = request.getParameter(SITE_FAX_NO);
		}
		if (request.getParameter(SITE_EMAIL_ID) != null) {
			emailId = request.getParameter(SITE_EMAIL_ID);
		}
		if (request.getParameter(SITE_WEB_SITE) != null) {
			webSite = request.getParameter(SITE_WEB_SITE);
		}
		if (request.getParameter(SITE_PEREVIOUS_ASSOCIATE) != null) {
			previousAssociate = request.getParameter(SITE_PEREVIOUS_ASSOCIATE);
		}
		if (!(request.getParameter(SITE_RATING_ID).equals("0")) && (request.getParameter(SITE_RATING_ID)) != null) {
			int ratingId = Integer.parseInt(request.getParameter(SITE_RATING_ID));
			generalMap.put("ratingId",ratingId);
		}
		if (request.getParameter(SITE_PAN_NO) != null) {
			panNo = request.getParameter(SITE_PAN_NO);
		}
		if (!(request.getParameter(SITE_BANK_ID).equals("0"))  &&  (request.getParameter(SITE_BANK_ID) != null)){
			bankId = Integer.parseInt(request.getParameter(SITE_BANK_ID));
			generalMap.put("bankId", bankId);
		}
		if (request.getParameter(SITE_BRANCH) != null) {
			branch = request.getParameter(SITE_BRANCH);
		}
		if (request.getParameter(EC_NAME) != null) {
			ecName = request.getParameter(EC_NAME);
		}
		if (request.getParameter(EC_CONV_NAME) != null) {
			ecConvName = request.getParameter(EC_CONV_NAME);
		}
		if (request.getParameter(EC_CONTACT_NO) != null) {
			ecContactNo = request.getParameter(EC_CONTACT_NO);
		}
		if (request.getParameter(EC_EMAIL_ID) != null) {
			ecEmailId = request.getParameter(EC_EMAIL_ID);
		}
		if (request.getParameter(EC_FAX_NO) != null) {
			ecFaxNo = request.getParameter(EC_FAX_NO);
		}
		if (!(request.getParameter(EC_BANK_ID).equals("0"))  && (request.getParameter(EC_BANK_ID) != null)) {
			ecBankId = Integer.parseInt(request.getParameter(EC_BANK_ID));
			generalMap.put("ecBankId", ecBankId);
		}
		if (request.getParameter(EC_BRANCH) != null) {
			ecBranch = request.getParameter(EC_BRANCH);
		}
		if (request.getParameter(EC_ACC_NO) != null) {
			ecAccountNo = request.getParameter(EC_ACC_NO);
		}
		if (request.getParameter(EC_PAN_NO) != null) {
			ecBranch = request.getParameter(EC_PAN_NO);
		}
		if (request.getParameter(EC_ACC_NO) != null) {
			ecPanNo = request.getParameter(EC_ACC_NO);
		}
		if (request.getParameter(COMMENTS) != null) {
			comments = request.getParameter(COMMENTS);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
//		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
//			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
//		}
//		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
//			currentTime = request.getParameter(CHANGED_TIME);
//		}
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
		String[] toBeAssignedThpList = {"0"};
		if(request.getParameterValues("thpId")!=null)
		{
			toBeAssignedThpList = request.getParameterValues("thpId");
		}
		
			
		changedDate = new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("siteId", siteId);
		generalMap.put("siteCode", siteCode);
		generalMap.put("siteName", siteName);
		generalMap.put("address",address);
		generalMap.put("accountNo", accountNo);
		generalMap.put("contactNo", contactNo);
		generalMap.put("faxNo", faxNo);
		generalMap.put("emailId", emailId);
		generalMap.put("webSite",webSite);
		generalMap.put("previousAssociate",previousAssociate);
		
		generalMap.put("panNo",panNo);
		
		generalMap.put("branch", branch);
		generalMap.put("ecName", ecName);
		generalMap.put("ecConvName",ecConvName);
		generalMap.put("ecContactNo", ecContactNo);
		generalMap.put("ecEmailId", ecEmailId);
		generalMap.put("ecFaxNo", ecFaxNo);
		
		generalMap.put("ecBranch", ecBranch);
		generalMap.put("ecAccountNo", ecAccountNo);
		generalMap.put("ecPanNo",ecPanNo);
		generalMap.put("comments",comments);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("toBeAssignedThpList", toBeAssignedThpList);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);
		List existingtaskNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingtaskNameList.size() == 0)
		{
		dataUpdated = projectTrackingMasterHandlerService.editSiteToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
	}else if(existingtaskNameList.size() > 0){

		message = "Name already exists.";

	}
		url = "hms/hrms/projectTrackingMaster?method=showSiteJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showSiteJsp();		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=SITE;
		  title="Edit Site Master";
		  jsp += ".jsp";
		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	public ModelAndView deleteSite(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int siteId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			siteId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=projectTrackingMasterHandlerService.deleteSite(siteId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hrms/projectTrackingMaster?method=showSiteJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showSiteJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=SITE;
		  title="Delete Site";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);

	}
	
	//================Calendar Master ---------------------------------------------
	public ModelAndView searchCalendar(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String calendarCode  = null;
		String calendarName = null;
		String searchField= null;
		
		if(request.getParameter(CALENDAR_CODE) != null && !(request.getParameter(CALENDAR_CODE).equals(""))){
			calendarCode = request.getParameter(CALENDAR_CODE);
		}
		if(request.getParameter(CALENDAR_NAME) != null && !(request.getParameter(CALENDAR_NAME).equals(""))){
			calendarName = request.getParameter(CALENDAR_NAME);
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
			calendarCode=searchField;
			calendarName=null;
		}else{
			calendarCode=null;
			calendarName=searchField;
		}
		

		map = projectTrackingMasterHandlerService.searchCalendar(calendarCode, calendarName);

		jsp = CALENDAR;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("calendarCode",calendarCode);
		map.put("calendarName",calendarName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showCalendarJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		map = projectTrackingMasterHandlerService.showCalendarJsp();
		@SuppressWarnings("unused")
		ArrayList  searchCalendarList = (ArrayList)map.get("searchCalendarList");
		jsp = CALENDAR;
		jsp += ".jsp";
		title = "Calendar";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addCalendar(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MstrCalendar mstrCalendar = new MstrCalendar();
		String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		
		if(session.getAttribute("hospitalId") != null){
			hospitalId  = (Integer)session.getAttribute("hospitalId");
		}
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
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

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);

		List calendarCodeList = new ArrayList();
		List calendarNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			calendarCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			calendarNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((calendarCodeList.size() == 0 || calendarCodeList == null) && (calendarNameList.size() == 0 || calendarNameList == null))
		{
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			mstrCalendar.setHospital(hospital);
			mstrCalendar.setCalendarCode(code);
			mstrCalendar.setCalendarName(name);
			mstrCalendar.setStatus("y");
			mstrCalendar.setLastChgBy(changedBy);
			mstrCalendar.setLastChgDate(currentDate);
			mstrCalendar.setLastChgTime(currentTime);
			successfullyAdded = projectTrackingMasterHandlerService.addCalendar(mstrCalendar);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((calendarCodeList.size() != 0 || calendarCodeList != null) || (calendarNameList.size() != 0) || calendarNameList != null){

			if((calendarCodeList.size() != 0 || calendarCodeList != null) && (calendarNameList.size() == 0 || calendarNameList == null)){

				message = "Calendar Code  already exists.";
			}
			else if((calendarNameList.size() != 0 || calendarNameList != null) && (calendarCodeList.size() == 0 || calendarCodeList == null) ){

				message = "Calendar Name already exists.";
			}
			else if((calendarCodeList.size() != 0 || calendarCodeList != null) && (calendarNameList.size() != 0 || calendarNameList != null)){

				message = "Calendar Code and Task Type Name already exist.";
			}
		}

		url = "/hms/hrms/projectTrackingMaster?method=showCalendarJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showCalendarJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=CALENDAR;
		  title="Add Calendar";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	public ModelAndView editCalendar(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession();
		String calendarCode="";
		String calendarName="";
		int calendarId=0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		calendarCode=(String )session.getAttribute("calendarCode");
		calendarName=(String )session.getAttribute("calendarName");
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			calendarId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			calendarCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			calendarName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", calendarId);
		generalMap.put("calendarCode",calendarCode);
		generalMap.put("name", calendarName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);
		List existingtaskTypeNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingtaskTypeNameList.size() == 0)
		{
		dataUpdated = projectTrackingMasterHandlerService.editCalendarToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
	}else if(existingtaskTypeNameList.size() > 0){

		message = "Name already exists.";

	}
		url = "hms/hrms/projectTrackingMaster?method=showCalendarJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showCalendarJsp();		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=CALENDAR;
		  title="Edit calendar";
		  jsp += ".jsp";
		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView deleteCalendar(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int calendarId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			calendarId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=projectTrackingMasterHandlerService.deleteCalendar(calendarId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hrms/projectTrackingMaster?method=showCalendarJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showCalendarJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=CALENDAR;
		  title="Delete calendar";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);

	}
	
	//================Project Status Master ---------------------------------------------
	public ModelAndView searchProjectStatus(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String projectStatusCode  = null;
		String projectStatusName = null;
		String searchField= null;
		
		if(request.getParameter(PROJECT_STATUS_CODE) != null && !(request.getParameter(PROJECT_STATUS_CODE).equals(""))){
			projectStatusCode = request.getParameter(PROJECT_STATUS_CODE);
		}
		if(request.getParameter(PROJECT_STATUS_NAME) != null && !(request.getParameter(PROJECT_STATUS_NAME).equals(""))){
			projectStatusName = request.getParameter(PROJECT_STATUS_NAME);
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
			projectStatusCode=searchField;
			projectStatusName=null;
		}else{
			projectStatusCode=null;
			projectStatusName=searchField;
		}
		

		map = projectTrackingMasterHandlerService.searchProjectStatus(projectStatusCode, projectStatusName);

		jsp = PROJECT_STATUS;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("projectStatusCode",projectStatusCode);
		map.put("projectStatusName",projectStatusName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showProjectStatusJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		map = projectTrackingMasterHandlerService.showProjectStatusJsp();
		@SuppressWarnings("unused")
		ArrayList  searchProjectStatusList = (ArrayList)map.get("searchProjectStatusList");
		jsp = PROJECT_STATUS;
		jsp += ".jsp";
		title = "Project Status";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addProjectStatus(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MstrProjectStatus mstrProjectStatus = new MstrProjectStatus();
		String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		
		if(session.getAttribute("hospitalId") != null){
			hospitalId  = (Integer)session.getAttribute("hospitalId");
		}
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
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

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);

		List projectStatusCodeList = new ArrayList();
		List projectStatusNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			projectStatusCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			projectStatusNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((projectStatusCodeList.size() == 0 || projectStatusCodeList == null) && (projectStatusNameList.size() == 0 || projectStatusNameList == null))
		{
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			mstrProjectStatus.setHospital(hospital);
			mstrProjectStatus.setPrjsCode(code);
			mstrProjectStatus.setPrjsName(name);
			mstrProjectStatus.setStatus("y");
			mstrProjectStatus.setLastChgBy(changedBy);
			mstrProjectStatus.setLastChgDate(currentDate);
			mstrProjectStatus.setLastChgTime(currentTime);
			successfullyAdded = projectTrackingMasterHandlerService.addProjectStatus(mstrProjectStatus);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((projectStatusCodeList.size() != 0 || projectStatusCodeList != null) || (projectStatusNameList.size() != 0) || projectStatusNameList != null){

			if((projectStatusCodeList.size() != 0 || projectStatusCodeList != null) && (projectStatusNameList.size() == 0 || projectStatusNameList == null)){

				message = "Project Status Code  already exists.";
			}
			else if((projectStatusNameList.size() != 0 || projectStatusNameList != null) && (projectStatusCodeList.size() == 0 || projectStatusCodeList == null) ){

				message = "Project Status Name already exists.";
			}
			else if((projectStatusCodeList.size() != 0 || projectStatusCodeList != null) && (projectStatusNameList.size() != 0 || projectStatusNameList != null)){

				message = "Project Status Code and Project Status Name already exist.";
			}
		}

		url = "/hms/hrms/projectTrackingMaster?method=showProjectStstusJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showProjectStatusJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=PROJECT_STATUS;
		  title="Add Project Ststus";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	public ModelAndView editProjectStatus(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession();
		String projectStatusCode="";
		String projectStatusName="";
		int projectStatusId=0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		projectStatusCode=(String )session.getAttribute("projectStatusCode");
		projectStatusName=(String )session.getAttribute("projectStatusName");
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			projectStatusId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			projectStatusCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			projectStatusName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", projectStatusId);
		generalMap.put("projectStatusCode",projectStatusCode);
		generalMap.put("name", projectStatusName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);
		List existingtaskTypeNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingtaskTypeNameList.size() == 0)
		{
		dataUpdated = projectTrackingMasterHandlerService.editProjectStatusToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
	}else if(existingtaskTypeNameList.size() > 0){

		message = "Name already exists.";

	}
		url = "hms/hrms/projectTrackingMaster?method=showProjectStatusJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showProjectStatusJsp();		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=PROJECT_STATUS;
		  title="Edit calendar";
		  jsp += ".jsp";
		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView deleteProjectStatus(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int projectStatusId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			projectStatusId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=projectTrackingMasterHandlerService.deleteProjectStatus(projectStatusId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hrms/projectTrackingMaster?method=showProjectStatusJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showProjectStatusJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=PROJECT_STATUS;
		  title="Delete Project Status";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);

	} 
	
	//================Vendor Service Type Master ---------------------------------------------
	public ModelAndView searchVendorServiceType(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String vendorServiceTypeCode  = null;
		String vendorServiceTypeName = null;
		String searchField= null;
		
		if(request.getParameter(VENDOR_SERVICE_CODE) != null && !(request.getParameter(VENDOR_SERVICE_CODE).equals(""))){
			vendorServiceTypeCode = request.getParameter(VENDOR_SERVICE_CODE);
		}
		if(request.getParameter(VENDOR_SERVICE_NAME) != null && !(request.getParameter(VENDOR_SERVICE_NAME).equals(""))){
			vendorServiceTypeName = request.getParameter(VENDOR_SERVICE_NAME);
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
			vendorServiceTypeCode=searchField;
			vendorServiceTypeName=null;
		}else{
			vendorServiceTypeCode=null;
			vendorServiceTypeName=searchField;
		}
		

		map = projectTrackingMasterHandlerService.searchVendorServiceType(vendorServiceTypeCode, vendorServiceTypeName);

		jsp = VENDOR_SERVICE_TYPE;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("vendorServiceTypeCode",vendorServiceTypeCode);
		map.put("vendorServiceTypeName",vendorServiceTypeName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showVendorServiceTypeJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		map = projectTrackingMasterHandlerService.showVendorServiceTypeJsp();
		@SuppressWarnings("unused")
		ArrayList  searchVendorServiceTypeList = (ArrayList)map.get("searchVendorServiceTypeList");
		jsp = VENDOR_SERVICE_TYPE;
		jsp += ".jsp";
		title = "Vendor Service Type";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addVendorServiceType(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		VendorServiceType vendorServiceType = new VendorServiceType();
		String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		
		if(session.getAttribute("hospitalId") != null){
			hospitalId  = (Integer)session.getAttribute("hospitalId");
		}
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
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

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);

		List vendorServiceTypeCodeList = new ArrayList();
		List vendorServiceTypeNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			vendorServiceTypeCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			vendorServiceTypeNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((vendorServiceTypeCodeList.size() == 0 || vendorServiceTypeCodeList == null) && (vendorServiceTypeNameList.size() == 0 || vendorServiceTypeNameList == null))
		{
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			vendorServiceType.setHospital(hospital);
			vendorServiceType.setVendorServiceCode(code);
			vendorServiceType.setVendorServiceName(name);
			vendorServiceType.setStatus("y");
			vendorServiceType.setLastChgBy(changedBy);
			vendorServiceType.setLastChgDate(currentDate);
			vendorServiceType.setLastChgTime(currentTime);
			successfullyAdded = projectTrackingMasterHandlerService.addVendorServiceType(vendorServiceType);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((vendorServiceTypeCodeList.size() != 0 || vendorServiceTypeCodeList != null) || (vendorServiceTypeNameList.size() != 0) || vendorServiceTypeNameList != null){

			if((vendorServiceTypeCodeList.size() != 0 || vendorServiceTypeCodeList != null) && (vendorServiceTypeNameList.size() == 0 || vendorServiceTypeNameList == null)){

				message = "Vendor Service Type Code  already exists.";
			}
			else if((vendorServiceTypeNameList.size() != 0 || vendorServiceTypeNameList != null) && (vendorServiceTypeCodeList.size() == 0 || vendorServiceTypeCodeList == null) ){

				message = "Vendor Service Type Name already exists.";
			}
			else if((vendorServiceTypeCodeList.size() != 0 || vendorServiceTypeCodeList != null) && (vendorServiceTypeNameList.size() != 0 || vendorServiceTypeNameList != null)){

				message = "Vendor Service Type Code and Vendor Service Type Name already exist.";
			}
		}

		url = "/hms/hrms/projectTrackingMaster?method=showVendorServiceTypeJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showVendorServiceTypeJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=VENDOR_SERVICE_TYPE;
		  title="Add Vendor Service Type";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	public ModelAndView editVendorServiceType(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession();
		String vendorServiceTypeCode="";
		String vendorServiceTypeName="";
		int vendorServiceTypeId=0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		vendorServiceTypeCode=(String )session.getAttribute("vendorServiceTypeCode");
		vendorServiceTypeName=(String )session.getAttribute("vendorServiceTypeName");
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			vendorServiceTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			vendorServiceTypeCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			vendorServiceTypeName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", vendorServiceTypeId);
		generalMap.put("vendorServiceTypeCode",vendorServiceTypeCode);
		generalMap.put("name", vendorServiceTypeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);
		List existingtaskTypeNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingtaskTypeNameList.size() == 0)
		{
		dataUpdated = projectTrackingMasterHandlerService.editVendorServiceTypeToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
	}else if(existingtaskTypeNameList.size() > 0){

		message = "Name already exists.";

	}
		url = "hms/hrms/projectTrackingMaster?method=showVendorServiceTypeJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showVendorServiceTypeJsp();		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=VENDOR_SERVICE_TYPE;
		  title="Edit Vendor Service Type";
		  jsp += ".jsp";
		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView deleteVendorServiceType(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int vendorServiceTypeId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			vendorServiceTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=projectTrackingMasterHandlerService.deleteVendorServiceType(vendorServiceTypeId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hrms/projectTrackingMaster?method=showVendorServiceTypeJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showVendorServiceTypeJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=VENDOR_SERVICE_TYPE;
		  title="Delete Vendor Service Type";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);

	} 
	
	public ModelAndView showSponsorJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		map = projectTrackingMasterHandlerService.showSponsorJsp();
		@SuppressWarnings("unused")
		ArrayList  searchSponsorList = (ArrayList)map.get("searchSponsorList");
		ArrayList  sponsorTypeList = (ArrayList)map.get("sponsorTypeList");
		ArrayList  therapetuicList = (ArrayList)map.get("therapetuicList");
		jsp = SPONSOR;
		jsp += ".jsp";
		title = "BudgetType";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchSponsor(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String sponsorCode  = null;
		String sponsorName = null;
		String searchField= null;
		
		if(request.getParameter(SPONSOR_CODE) != null && !(request.getParameter(SPONSOR_CODE).equals(""))){
			sponsorCode = request.getParameter(SPONSOR_CODE);
		}
		if(request.getParameter(SPONSOR_NAME) != null && !(request.getParameter(SPONSOR_NAME).equals(""))){
			sponsorName = request.getParameter(SPONSOR_NAME);
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
			sponsorCode=searchField;
			sponsorName=null;
		}else{
			sponsorCode=null;
			sponsorName=searchField;
		}
		

		map = projectTrackingMasterHandlerService.searchSponsor(sponsorCode, sponsorName);

		jsp = SPONSOR;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("sponsorCode",sponsorCode);
		map.put("sponsorName",sponsorName);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView addSponsor(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
	
		String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		
		String sponsorGroup = null;
		String accountNo    = null;
		String cntNo    = null;
		String emailId    = null;
		String website    = null;
		String faxNo    = null;
		String address    = null;
		String comments    = null;
		String annualRevenue    = null;
		String othGrpCom    = null;
		int totNoEmp    = 0;
		//int therapeuticId= 0;
		String[] therapeuticIds = new String[0];
		String othOnGoingPrj    = null;
		String annualTurnOver    = null;
		
		MstrSponsor mstrSponsor = new MstrSponsor();
		
		if(session.getAttribute("hospitalId") != null){
			hospitalId  = (Integer)session.getAttribute("hospitalId");
		}
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(SPONSOR_GROUP) != null) {
			sponsorGroup = request.getParameter(SPONSOR_GROUP);
		}
		if (!request.getParameter(SPONSOR_TYPE_ID).equals("") && (request.getParameter(SPONSOR_TYPE_ID) != null)) {
			int sponsorTypeId = Integer.parseInt(request.getParameter(SPONSOR_TYPE_ID));
			MstrSponsortype mstrSponsortype = new MstrSponsortype();
			mstrSponsortype.setId(sponsorTypeId);
			mstrSponsor.setSponserType(mstrSponsortype);
		}
		if (request.getParameter(SPONSOR_ACCOUNT_NO) != null) {
			accountNo = request.getParameter(SPONSOR_ACCOUNT_NO);
		}
		if (request.getParameter(SPONSOR_CNT_NO) != null) {
			accountNo = request.getParameter(SPONSOR_CNT_NO);
		}
		if (request.getParameter(SPONSOR_EMAIL_ID) != null) {
			emailId = request.getParameter(SPONSOR_EMAIL_ID);
		}
		if (request.getParameter(SPONSOR_WEBSITE) != null) {
			website = request.getParameter(SPONSOR_WEBSITE);
		}
		if (request.getParameter(SPONSOR_FAX_NO) != null) {
			faxNo = request.getParameter(SPONSOR_FAX_NO);
		}
		if (request.getParameter(SPONSOR_ADDRESS) != null) {
			address = request.getParameter(SPONSOR_ADDRESS);
		}
		if (request.getParameter(SPONSOR_COMMENTS) != null) {
			comments = request.getParameter(SPONSOR_COMMENTS);
		}
		if (request.getParameter(SPONSOR_ANN_REV) != null) {
			annualRevenue = request.getParameter(SPONSOR_ANN_REV);
		}
		if (request.getParameter(SPONSOR_OTHGRPCOM) != null) {
			othGrpCom = request.getParameter(SPONSOR_OTHGRPCOM);
		}
		if (request.getParameter(SPONSOR_TOT_NO_EMP) != null
				&& !request.getParameter(SPONSOR_TOT_NO_EMP).equals("")) {
			totNoEmp = Integer.parseInt(request.getParameter(SPONSOR_TOT_NO_EMP));
		}
		if (request.getParameterValues(SPONSOR_THP_ID) != null) {
			therapeuticIds = request.getParameterValues(SPONSOR_THP_ID);
		}
		if (request.getParameter(SPONSOR_OTHONGOINGPRJ) != null) {
			othOnGoingPrj = request.getParameter(SPONSOR_OTHONGOINGPRJ);
		}
		if (request.getParameter(SPONSOR_ANNTURNOVER) != null) {
			annualTurnOver = request.getParameter(SPONSOR_ANNTURNOVER);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
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

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);

		List sponsorCodeList = new ArrayList();
		List sponsorNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			sponsorCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			sponsorNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((sponsorCodeList.size() == 0 || sponsorCodeList == null) && (sponsorNameList.size() == 0 || sponsorNameList == null))
		{
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			
			//MstrTherapeutic mstrTherapeutic = new MstrTherapeutic();
			//mstrTherapeutic.setId(therapeuticId);
			
			
			
			mstrSponsor.setHospital(hospital);
			mstrSponsor.setSponsorCode(code);
			mstrSponsor.setSponsorName(name);
			mstrSponsor.setSponsorGroup(sponsorGroup);
			mstrSponsor.setSponsorAccountno(accountNo);
			mstrSponsor.setSponsorCntNo(cntNo);
			mstrSponsor.setSponsorEmailId(emailId);
			mstrSponsor.setSponsorWebsite(website);
			mstrSponsor.setSponsorFaxNo(faxNo);
			mstrSponsor.setSponsorAddress(address);
			mstrSponsor.setSponsorComments(comments);
			mstrSponsor.setSponsorAnnRev(annualRevenue);
			mstrSponsor.setSponsorOthgrpcom(othGrpCom);
			mstrSponsor.setSponsorTotNoEmp(totNoEmp);
			
			Set<MstrTherapeutic> thpSet = new HashSet<MstrTherapeutic>();
			for(String thpId : therapeuticIds){
				if(!thpId.equals("")){
					MstrTherapeutic mstrTherapeutic = new MstrTherapeutic();
					mstrTherapeutic.setId(Integer.parseInt(thpId));
					thpSet.add(mstrTherapeutic);
				}
			}
			mstrSponsor.setThp(thpSet);
			
			mstrSponsor.setSponsorOthongoingprj(othOnGoingPrj);
			mstrSponsor.setSponsorAnntrunover(annualTurnOver);
			mstrSponsor.setStatus("y");
			mstrSponsor.setLastChgBy(changedBy);
			mstrSponsor.setLastChgDate(currentDate);
			mstrSponsor.setLastChgTime(currentTime);
			successfullyAdded = projectTrackingMasterHandlerService.addSponsor(mstrSponsor);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((sponsorCodeList.size() != 0 || sponsorCodeList != null) || (sponsorNameList.size() != 0) || sponsorNameList != null){

			if((sponsorCodeList.size() != 0 || sponsorCodeList != null) && (sponsorNameList.size() == 0 || sponsorNameList == null)){

				message = "Sponsor  Code  already exists.";
			}
			else if((sponsorNameList.size() != 0 || sponsorNameList != null) && (sponsorCodeList.size() == 0 || sponsorCodeList == null) ){

				message = "Sponsor  Name already exists.";
			}
			else if((sponsorCodeList.size() != 0 || sponsorCodeList != null) && (sponsorNameList.size() != 0 || sponsorNameList != null)){

				message = "Sponsor  Code and Sponsor  Name already exist.";
			}
		}

		url = "/hms/hrms/projectTrackingMaster?method=showsponsorJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showSponsorJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=SPONSOR;
		  title="Add Sponsor ";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView editSponsor(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession();
		String sponsorCode="";
		String sponsorName="";
		int sponsorId = 0;
		int sponsorTypeId = 0;
		String sponsorGroup = null;
		String accountNo    = null;
		String cntNo    = null;
		String emailId    = null;
		String website    = null;
		String faxNo    = null;
		String address    = null;
		String comments    = null;
		String annualRevenue    = null;
		String othGrpCom    = null;
		int totNoEmp    = 0;
		
		String othOnGoingPrj    = null;
		String annualTurnOver    = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String[] therapeuticIds = new String[0];
		
		sponsorCode=(String )session.getAttribute(SPONSOR_CODE);
		sponsorName=(String )session.getAttribute(SPONSOR_NAME);
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			sponsorId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			sponsorCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			sponsorName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(SPONSOR_GROUP) != null && !(request.getParameter(SPONSOR_GROUP).equals(""))){
			sponsorGroup = request.getParameter(SPONSOR_GROUP);
		}
		if(!(request.getParameter(SPONSOR_TYPE_ID).equals(""))  && (request.getParameter(SPONSOR_TYPE_ID) != null)){
			sponsorTypeId = Integer.parseInt(request.getParameter(SPONSOR_TYPE_ID));
			generalMap.put("sponsorTypeId", sponsorTypeId);
		}
		if(request.getParameter(SPONSOR_ACCOUNT_NO) != null && !(request.getParameter(SPONSOR_ACCOUNT_NO).equals(""))){
			accountNo = request.getParameter(SPONSOR_ACCOUNT_NO);
		}
		if(request.getParameter(SPONSOR_CNT_NO) != null && !(request.getParameter(SPONSOR_CNT_NO).equals(""))){
			cntNo = request.getParameter(SPONSOR_CNT_NO);
		}
		if(request.getParameter(SPONSOR_EMAIL_ID) != null && !(request.getParameter(SPONSOR_EMAIL_ID).equals(""))){
			emailId = request.getParameter(SPONSOR_EMAIL_ID);
		}
		if(request.getParameter(SPONSOR_WEBSITE) != null && !(request.getParameter(SPONSOR_WEBSITE).equals(""))){
			website = request.getParameter(SPONSOR_WEBSITE);
		}
		if(request.getParameter(SPONSOR_FAX_NO) != null && !(request.getParameter(SPONSOR_FAX_NO).equals(""))){
			faxNo = request.getParameter(SPONSOR_FAX_NO);
		}
		if(request.getParameter(SPONSOR_ADDRESS) != null && !(request.getParameter(SPONSOR_ADDRESS).equals(""))){
			address = request.getParameter(SPONSOR_ADDRESS);
		}
		if(request.getParameter(SPONSOR_COMMENTS) != null && !(request.getParameter(SPONSOR_COMMENTS).equals(""))){
			comments = request.getParameter(SPONSOR_COMMENTS);
		}
		if(request.getParameter(SPONSOR_ANN_REV) != null && !(request.getParameter(SPONSOR_ANN_REV).equals(""))){
			annualRevenue = request.getParameter(SPONSOR_ANN_REV);
		}
		if(request.getParameter(SPONSOR_OTHGRPCOM) != null && !(request.getParameter(SPONSOR_OTHGRPCOM).equals(""))){
			othGrpCom = request.getParameter(SPONSOR_OTHGRPCOM);
		}
		if(request.getParameter(SPONSOR_TOT_NO_EMP) != null && !(request.getParameter(SPONSOR_TOT_NO_EMP).equals(""))){
			totNoEmp = Integer.parseInt(request.getParameter(SPONSOR_TOT_NO_EMP));
		}
		if (request.getParameterValues(SPONSOR_THP_ID) != null) {
			therapeuticIds = request.getParameterValues(SPONSOR_THP_ID);
		}
		if(request.getParameter(SPONSOR_OTHONGOINGPRJ) != null && !(request.getParameter(SPONSOR_OTHONGOINGPRJ).equals(""))){
			othOnGoingPrj = request.getParameter(SPONSOR_OTHONGOINGPRJ);
		}
		if(request.getParameter(SPONSOR_ANNTURNOVER) != null && !(request.getParameter(SPONSOR_ANNTURNOVER).equals(""))){
			annualTurnOver = request.getParameter(SPONSOR_ANNTURNOVER);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", sponsorId);
		generalMap.put("sponsorCode", sponsorCode);
		generalMap.put("sponsorName", sponsorName);
		generalMap.put("sponsorGroup", sponsorGroup);
		
		generalMap.put("accountNo", accountNo);
		generalMap.put("cntNo", cntNo);
		generalMap.put("emailId", emailId);
		generalMap.put("website", website);
		generalMap.put("faxNo", faxNo);
		generalMap.put("address", address);
		generalMap.put("comments", comments);
		generalMap.put("annualRevenue", annualRevenue);
		generalMap.put("othGrpCom", othGrpCom);
		generalMap.put("totNoEmp", totNoEmp);
		generalMap.put("therapeuticIds", therapeuticIds);
		generalMap.put("othOnGoingPrj", othOnGoingPrj);
		generalMap.put("annualTurnOver", annualTurnOver);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);
		List existingtaskNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingtaskNameList.size() == 0)
		{
		dataUpdated = projectTrackingMasterHandlerService.editSponsorToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
	}else if(existingtaskNameList.size() > 0){

		message = "Name already exists.";

	}
		url = "hms/hrms/projectTrackingMaster?method=showSponsorJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showSponsorJsp();		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=SPONSOR;
		  title="Edit Sponsor";
		  jsp += ".jsp";
		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView deleteSponsor(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int sponsorId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			sponsorId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=projectTrackingMasterHandlerService.deleteSponsor(sponsorId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hrms/projectTrackingMaster?method=showSponsorJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showSponsorJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=SPONSOR;
		  title="Delete Sponsor";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);

	}
	
	public ModelAndView showVitalsJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		map = projectTrackingMasterHandlerService.showVitalsJsp();
		@SuppressWarnings("unused")
		ArrayList  searchVitalsList = (ArrayList)map.get("searchVitalsList");
		jsp = VITALS;
		jsp += ".jsp";
		title = "Vitals";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
//	----------------------------Task Type Master ------------------------------------------
	public ModelAndView searchVitals(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String vitalsCode  = null;
		String vitalsName = null;
		String searchField= null;
		
		if(request.getParameter(VITALS_CODE) != null && !(request.getParameter(VITALS_CODE).equals(""))){
			vitalsCode = request.getParameter(VITALS_CODE);
		}
		if(request.getParameter(VITALS_NAME) != null && !(request.getParameter(VITALS_NAME).equals(""))){
			vitalsName = request.getParameter(VITALS_NAME);
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
			vitalsCode=searchField;
			vitalsName=null;
		}else{
			vitalsCode=null;
			vitalsName=searchField;
		}
		

		map = projectTrackingMasterHandlerService.searchVitals(vitalsCode,vitalsName);

		jsp = VITALS;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("vitalsCode",vitalsCode);
		map.put("vitalsName",vitalsName);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addVitals(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		MstrVitals mstrVitals = new MstrVitals();
		String changedBy = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		String vitalsFlag = null;
		String amountFlag = null;
		
		
		if(session.getAttribute("hospitalId") != null){
			hospitalId  = (Integer)session.getAttribute("hospitalId");
		}
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if ((request.getParameter(VITALS_FLAG) != null) && request.getParameter(VITALS_FLAG) != "") {
			vitalsFlag = request.getParameter(VITALS_FLAG);
		}
		if (request.getParameter(AMOUNT_FLAG) != null) {
			amountFlag = request.getParameter(AMOUNT_FLAG);
		}
		
		
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
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

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);

		List vitalsCodeList = new ArrayList();
		List vitalsNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			vitalsCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			vitalsNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((vitalsCodeList.size() == 0 || vitalsCodeList == null) && (vitalsNameList.size() == 0 || vitalsNameList == null))
		{
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			mstrVitals.setCompany(hospital);
			mstrVitals.setVitalCode(code);
			mstrVitals.setVitalDescription(name);
			mstrVitals.setFlag(vitalsFlag);
			mstrVitals.setAmountFlag(amountFlag);
			mstrVitals.setStatus("y");
			mstrVitals.setLastChgBy(changedBy);
			mstrVitals.setLastChgDate(currentDate);
			mstrVitals.setLastChgTime(currentTime);
			successfullyAdded = projectTrackingMasterHandlerService.addVitals(mstrVitals);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((vitalsCodeList.size() != 0 || vitalsCodeList != null) || (vitalsNameList.size() != 0) || vitalsNameList != null){

			if((vitalsCodeList.size() != 0 || vitalsCodeList != null) && (vitalsNameList.size() == 0 || vitalsNameList == null)){

				message = "Vitals Code  already exists.";
			}
			else if((vitalsNameList.size() != 0 || vitalsNameList != null) && (vitalsCodeList.size() == 0 || vitalsCodeList == null) ){

				message = "Vitals Name already exists.";
			}
			else if((vitalsCodeList.size() != 0 || vitalsCodeList != null) && (vitalsNameList.size() != 0 || vitalsNameList != null)){

				message = "Vitals Code and Vitals Name already exist.";
			}
		}

		url = "/hms/hrms/projectTrackingMaster?method=showVitalsJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showVitalsJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=VITALS;
		  title="Add Vitals";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	public ModelAndView editVitals(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession();
		String vitalsCode="";
		String vitalsName="";
		int vitalsId=0;
		String vitalsFlag =null;
		String amountFlag = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		vitalsCode=(String )session.getAttribute("vitalsCode");
		vitalsName=(String )session.getAttribute("vitalsName");
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			vitalsId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			vitalsCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			vitalsName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(VITALS_FLAG) !=  null && !(request.getParameter(VITALS_FLAG).equals(""))){
			vitalsFlag = request.getParameter(VITALS_FLAG);
		}
		if(vitalsFlag.equals("D")){
			amountFlag = null;
		}
		else{
			if(request.getParameter(AMOUNT_FLAG) != null && !(request.getParameter(AMOUNT_FLAG).equals(""))){
				amountFlag = request.getParameter(AMOUNT_FLAG);
			}
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
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
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", vitalsId);
		generalMap.put("vitalsCode", vitalsCode);
		generalMap.put("name", vitalsName);
		generalMap.put("vitalsFlag", vitalsFlag);
		generalMap.put("amountFlag", amountFlag);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);
		List existingVitalsNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingVitalsNameList.size() == 0)
		{
		dataUpdated = projectTrackingMasterHandlerService.editVitalsToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
	}else if(existingVitalsNameList.size() > 0){

		message = "Name already exists.";

	}
		url = "hms/hrms/projectTrackingMaster?method=showVitalsJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showVitalsJsp();		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=VITALS;
		  title="Edit Vitals";
		  jsp += ".jsp";
		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView deleteVitals(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int vitalsId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			vitalsId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=projectTrackingMasterHandlerService.deleteVitals(vitalsId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hrms/projectTrackingMaster?method=showVitalsJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showVitalsJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=VITALS;
		  title="Delete Vitals";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);

	}
	

//==========================The End=============================================================
	//==========================Code Added By Naresh =====================================
	public ModelAndView showVisitTypeJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		map = projectTrackingMasterHandlerService.showVisitTypeJsp();
		ArrayList  searchMasVisitTypeList = (ArrayList)map.get("searchMasVisitTypeList");
		jsp = VISIT_TYPE_JSP;
		jsp += ".jsp";
		title = "Visit Type";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView addVisitType(HttpServletRequest request, HttpServletResponse response) 
	{

		Map<String,Object> map=new HashMap<String,Object>();
		HrMasVisitType hrMasVisitType = new HrMasVisitType();
		String changedBy = "";
		String dependency = "";
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if(session.getAttribute("hospitalId") != null){
			hospitalId  = (Integer)session.getAttribute("hospitalId");
		}

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if(request.getParameter(DEPENDENCY) != null && !(request.getParameter(DEPENDENCY).equals(""))){
			dependency = request.getParameter(DEPENDENCY);
		}
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
		generalMap.put("dependency", dependency);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);

		List visitTypeCodeList = new ArrayList();
		List visitTypeNameList = new  ArrayList();

		if(listMap.get("duplicateGeneralCodeList") != null){
			visitTypeCodeList = (List)listMap.get("duplicateGeneralCodeList");
		}
		if(listMap.get("duplicateGeneralNameList") != null){
			visitTypeNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if((visitTypeCodeList.size() == 0 || visitTypeCodeList == null) && (visitTypeNameList.size() == 0 || visitTypeNameList == null))
		{
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			hrMasVisitType.setCompany(hospital);
			hrMasVisitType.setVisitCode(code);
			hrMasVisitType.setVisitType(name);
			hrMasVisitType.setDependency(dependency);
			hrMasVisitType.setStatus("y");
			hrMasVisitType.setLastChgBy(changedBy);
			hrMasVisitType.setLastChgDate(currentDate);
			hrMasVisitType.setLastChgTime(currentTime);
			successfullyAdded = projectTrackingMasterHandlerService.addVisitType(hrMasVisitType);		

			if(successfullyAdded)
			{				
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((visitTypeCodeList.size() != 0 || visitTypeCodeList != null) || (visitTypeNameList.size() != 0) || visitTypeNameList != null){

			if((visitTypeCodeList.size() != 0 || visitTypeCodeList != null) && (visitTypeNameList.size() == 0 || visitTypeNameList == null)){

				message = "Visit Code  already exists.";
			}
			else if((visitTypeNameList.size() != 0 || visitTypeNameList != null) && (visitTypeCodeList.size() == 0 || visitTypeCodeList == null) ){

				message = "Visit Name already exists.";
			}
			else if((visitTypeCodeList.size() != 0 || visitTypeCodeList != null) && (visitTypeNameList.size() != 0 || visitTypeNameList != null)){

				message = "Visit Code and Visit Name already exist.";
			}
		}

		url = "/hms/hrms/projectTrackingMaster?method=showVisitTypeJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showVisitTypeJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=VISIT_TYPE_JSP;
		  title="Add Visit Type";
		  jsp += ".jsp";		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchVisitType(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String visitTypeCode  = null;
		String visitTypeName = null;
		String searchField= null;
		
		if(request.getParameter(VISIT_TYPE_CODE) != null && !(request.getParameter(VISIT_TYPE_CODE).equals(""))){
			visitTypeCode = request.getParameter(VISIT_TYPE_CODE);
		}
		if(request.getParameter(VISIT_TYPE_NAME) != null && !(request.getParameter(VISIT_TYPE_NAME).equals(""))){
			visitTypeName = request.getParameter(VISIT_TYPE_NAME);
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
			visitTypeCode=searchField;
			visitTypeName=null;
		}else{
			visitTypeCode=null;
			visitTypeName=searchField;
		}
		map = projectTrackingMasterHandlerService.searchVisitType(visitTypeCode, visitTypeName);
		jsp = VISIT_TYPE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("prjTypeCode",visitTypeCode);
		map.put("prjTypeName",visitTypeName);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView editVisitType(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session=request.getSession();
		String visitTypeCode="";
		String visitTypeName="";
		int visitTypeId=0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String dependency = "";

		visitTypeCode=(String )session.getAttribute("visitTypeCode");
		visitTypeName=(String )session.getAttribute("visitTypeName");
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			visitTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))){
			visitTypeCode = request.getParameter(CODE);
		}
		if(request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))){
			visitTypeName = request.getParameter(SEARCH_NAME);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(DEPENDENCY) != null && !(request.getParameter(DEPENDENCY).equals(""))){
			dependency = request.getParameter(DEPENDENCY);
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
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", visitTypeId);
		generalMap.put("visitTypeCode", visitTypeCode);
		generalMap.put("name", visitTypeName);
		generalMap.put("dependency", dependency);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = projectTrackingMasterHandlerService.checkForExistingMasters(generalMap);
		List existingVisitTypeNameList = (List)listMap.get("duplicateMastersList");
	
		boolean dataUpdated=false;
		if(existingVisitTypeNameList.size() == 0)
		{
		dataUpdated = projectTrackingMasterHandlerService.editVisitTypeToDatabase(generalMap);

		if(dataUpdated==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}
	}else if(existingVisitTypeNameList.size() > 0){

		message = "Name already exists.";

	}
		url = "hms/hrms/projectTrackingMaster?method=showVisitTypeJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showVisitTypeJsp();		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=VISIT_TYPE_JSP;
		  title="Edit Visit Type";
		  jsp += ".jsp";
		  
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
	}
	public ModelAndView deleteVisitType(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int visitTypeId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			visitTypeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=projectTrackingMasterHandlerService.deleteVisitType(visitTypeId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hrms/projectTrackingMaster?method=showVisitTypeJsp";
		
		try{
			map = projectTrackingMasterHandlerService.showVisitTypeJsp();
		   
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  jsp=VISIT_TYPE_JSP;
		  title="Delete Visit Type";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);

	}
	
	//==========================Code By Naresh End =====================================
}