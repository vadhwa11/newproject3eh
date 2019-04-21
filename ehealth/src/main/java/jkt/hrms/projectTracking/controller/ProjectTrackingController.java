package jkt.hrms.projectTracking.controller;

import static jkt.hrms.util.HrmsRequestConstants.*;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasCurrency;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.UserButtonRights;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hrms.masters.business.CntrReqPat;
import jkt.hrms.masters.business.HrMasVisitType;
import jkt.hrms.masters.business.MstrDoctype;
import jkt.hrms.masters.business.MstrDocument;
import jkt.hrms.masters.business.MstrProject;
import jkt.hrms.masters.business.MstrPtvisit;
import jkt.hrms.masters.business.MstrQueryStatus;
import jkt.hrms.masters.business.MstrRegulatoryStatus;
import jkt.hrms.masters.business.MstrSiteHeader;
import jkt.hrms.masters.business.MstrVendor;
import jkt.hrms.masters.business.MstrVitals;
import jkt.hrms.masters.business.PrjAddPtHeader;
import jkt.hrms.masters.business.PrjAnsEntry;
import jkt.hrms.masters.business.PrjOthervitals;
import jkt.hrms.masters.business.PrjPatvisitsch;
import jkt.hrms.masters.business.PrjQueryEntry;
import jkt.hrms.masters.business.PrjQueryFlwEntry;
import jkt.hrms.masters.business.PrjReglSub;
import jkt.hrms.masters.business.PrjSiteOthervitals;
import jkt.hrms.masters.business.PrjVendorcontract;
import jkt.hrms.masters.business.ProjectVitals;
import jkt.hrms.masters.business.VendorServiceType;
import jkt.hrms.projectTracking.handler.ProjectTrackingHandlerService;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ProjectTrackingController extends MultiActionController {
	ProjectTrackingHandlerService projectTrackingHandlerService = null;
	private CommonMasterHandlerService commonMasterHandlerService= null;

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	public ProjectTrackingHandlerService getProjectTrackingHandlerService() {
		return projectTrackingHandlerService;
	}

	public void setProjectTrackingHandlerService(
			ProjectTrackingHandlerService projectTrackingHandlerService) {
		this.projectTrackingHandlerService = projectTrackingHandlerService;
	}

	public ModelAndView showProjectCreationJsp(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		Map<String,Object> mapForDs=new HashMap<String,Object>();
		Map<String, Object> map = new HashMap<String, Object>();

		Users user=(Users)session.getAttribute(USERS);
		MasEmployee employee= user.getEmployee();

		mapForDs.put("employeeId", employee.getId());
		mapForDs.put("users", user);

		map = projectTrackingHandlerService.showProjectCreationJsp();
		Map<String ,Object> newMap=commonMasterHandlerService.getUserButtonRights(mapForDs);
		List<UserButtonRights> userRightsList=(List<UserButtonRights>)newMap.get("userRightsList");
		map.put("userRightsList", userRightsList);

		String jsp = PROJECT_CREATION_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveProjectCreation(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		if (session.getAttribute("hospitalId")!= null) {
			int	hospitalId = (Integer)session.getAttribute("hospitalId");
			generalMap.put("hospitalId", hospitalId);
		}
		if(request.getParameter(PROJECT_NAME)!= null){
			String projectName = request.getParameter(PROJECT_NAME);
			generalMap.put("projectName", projectName);
		}
		if(request.getParameter(SPONSOR_ID)!= null && ! request.getParameter(SPONSOR_ID).equals("0")){
			int sponserId =Integer.parseInt(request.getParameter(SPONSOR_ID));
			generalMap.put("sponserId", sponserId);
		}
		if(request.getParameter(DESCRIPTION)!= null){
			String description = request.getParameter(DESCRIPTION);
			generalMap.put("description", description);
		}
		if(request.getParameter(THP_ID)!= null && ! request.getParameter(THP_ID).equals("0")){
			int therapeuticId =Integer.parseInt(request.getParameter(THP_ID));
			generalMap.put("therapeuticId", therapeuticId);
		}
		if(request.getParameter(PROJECT_CODE)!= null){
			String projectCode = request.getParameter(PROJECT_CODE);
			generalMap.put("projectCode", projectCode);
		}
		if(request.getParameter(PROTOCOL_NO)!= null){
			String protocolNo = request.getParameter(PROTOCOL_NO);
			generalMap.put("protocolNo", protocolNo);
		}
		if(request.getParameter(LOI_NO)!= null){
			String loiNo = request.getParameter(LOI_NO);
			generalMap.put("loiNo", loiNo);
		}
		if(request.getParameter(PROJECT_TYPE_ID)!= null && ! request.getParameter(PROJECT_TYPE_ID).equals("0")){
			int projectTypeId =Integer.parseInt(request.getParameter(PROJECT_TYPE_ID));
			generalMap.put("projectTypeId", projectTypeId);
		}
		if(request.getParameter(PROJECT_TRIAL_PHASE_ID)!= null && ! request.getParameter(PROJECT_TRIAL_PHASE_ID).equals("0")){
			int projectTrialPhaseId =Integer.parseInt(request.getParameter(PROJECT_TRIAL_PHASE_ID));
			generalMap.put("projectTrialPhaseId", projectTrialPhaseId);
		}
		if(request.getParameter(PROJECT_STATUS_ID)!= null && ! request.getParameter(PROJECT_STATUS_ID).equals("0")){
			int projectStatusId =Integer.parseInt(request.getParameter(PROJECT_STATUS_ID));
			generalMap.put("projectStatusId", projectStatusId);
		}
		if (request.getParameter(BUDGET)!= null && !(request.getParameter(BUDGET).equals(""))) {
			BigDecimal budget =new BigDecimal(request.getParameter(BUDGET));
			generalMap.put("budget", budget);
		}
		if(request.getParameter(START_DATE)!= null){
			Date startDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(START_DATE));
			generalMap.put("startDate", startDate);
		}
		if(request.getParameter(END_DATE)!= null){
			Date endDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(END_DATE));
			generalMap.put("endDate", endDate);
		}
		if(request.getParameter(LOI_DATE)!= null && !(request.getParameter(LOI_DATE).equals(""))){
			Date loiDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(LOI_DATE));
			generalMap.put("loiDate", loiDate);
		}
		if(request.getParameter(BILLABLE)!= null){
			String billable = "y";
			generalMap.put("billable", billable);
		}else{
			String billable = "n";
			generalMap.put("billable", billable);
		}
		if(request.getParameter(EXTENSION)!= null){
			String extension = "y";
			generalMap.put("extension", extension);
		}else{
			String extension = "n";
			generalMap.put("extension", extension);
		}
		if( request.getParameter(PROJECT_ID)!= null && !(request.getParameter(PROJECT_ID).equals(""))){
			int projectExtensionId =Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectExtensionId", projectExtensionId);
		}
		if(request.getParameter(PURCHASE_ORDER_NO)!= null){
			String purchaseOrderNo = request.getParameter(PURCHASE_ORDER_NO);
			generalMap.put("purchaseOrderNo", purchaseOrderNo);
		}
		if(request.getParameter(PURCHASE_ORDER_DATE)!= null && !(request.getParameter(PURCHASE_ORDER_DATE).equals(""))){
			Date purchaseOrderDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(PURCHASE_ORDER_DATE));
			generalMap.put("purchaseOrderDate", purchaseOrderDate);
		}
		if(request.getParameter(CONTRACT_DATE)!= null  && !(request.getParameter(CONTRACT_DATE).equals(""))){
			Date contractDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(CONTRACT_DATE));
			generalMap.put("contractDate", contractDate);
		}
		if(request.getParameter(CONTRACT_NO)!= null){
			String contractNo = request.getParameter(CONTRACT_NO);
			generalMap.put("contractNo", contractNo);
		}
		if(request.getParameter(CURRENCY_ID)!= null && ! request.getParameter(CURRENCY_ID).equals("0")){
			int currencyId =Integer.parseInt(request.getParameter(CURRENCY_ID));
			generalMap.put("currencyId", currencyId);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			String changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}

		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			String	currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		map = projectTrackingHandlerService.saveProjectCreation(generalMap);
		String jsp = PROJECT_CREATION_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView updateProjectCreation(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		if(request.getParameter(PROJECT_ID)!= null ){
			int projectId =Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		if(request.getParameter(PROJECT_NAME)!= null){
			String projectName = request.getParameter(PROJECT_NAME);
			generalMap.put("projectName", projectName);
		}
		if(request.getParameter(SPONSOR_ID)!= null && ! request.getParameter(SPONSOR_ID).equals("0")){
			int sponserId =Integer.parseInt(request.getParameter(SPONSOR_ID));
			generalMap.put("sponserId", sponserId);
		}
		if(request.getParameter(DESCRIPTION)!= null){
			String description = request.getParameter(DESCRIPTION);
			generalMap.put("description", description);
		}
		if(request.getParameter(THP_ID)!= null && ! request.getParameter(THP_ID).equals("0")){
			int therapeuticId =Integer.parseInt(request.getParameter(THP_ID));
			generalMap.put("therapeuticId", therapeuticId);
		}
		if(request.getParameter(PROJECT_CODE)!= null){
			String projectCode = request.getParameter(PROJECT_CODE);
			generalMap.put("projectCode", projectCode);
		}
		if(request.getParameter(PROTOCOL_NO)!= null){
			String protocolNo = request.getParameter(PROTOCOL_NO);
			generalMap.put("protocolNo", protocolNo);
		}
		if(request.getParameter(LOI_NO)!= null){
			String loiNo = request.getParameter(LOI_NO);
			generalMap.put("loiNo", loiNo);
		}
		if(request.getParameter(PROJECT_TYPE_ID)!= null && ! request.getParameter(PROJECT_TYPE_ID).equals("0")){
			int projectTypeId =Integer.parseInt(request.getParameter(PROJECT_TYPE_ID));
			generalMap.put("projectTypeId", projectTypeId);
		}
		if(request.getParameter(PROJECT_TRIAL_PHASE_ID)!= null && ! request.getParameter(PROJECT_TRIAL_PHASE_ID).equals("0")){
			int projectTrialPhaseId =Integer.parseInt(request.getParameter(PROJECT_TRIAL_PHASE_ID));
			generalMap.put("projectTrialPhaseId", projectTrialPhaseId);
		}
		if(request.getParameter(PROJECT_STATUS_ID)!= null && ! request.getParameter(PROJECT_STATUS_ID).equals("0")){
			int projectStatusId =Integer.parseInt(request.getParameter(PROJECT_STATUS_ID));
			generalMap.put("projectStatusId", projectStatusId);
		}
		if (request.getParameter(BUDGET)!= null && !(request.getParameter(BUDGET).equals(""))) {
			BigDecimal budget =new BigDecimal(request.getParameter(BUDGET));
			generalMap.put("budget", budget);
		}
		if(request.getParameter(START_DATE)!= null){
			Date startDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(START_DATE));
			generalMap.put("startDate", startDate);
		}
		if(request.getParameter(END_DATE)!= null){
			Date endDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(END_DATE));
			generalMap.put("endDate", endDate);
		}
		if(request.getParameter(LOI_DATE)!= null && !(request.getParameter(LOI_DATE).equals(""))){
			Date loiDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(LOI_DATE));
			generalMap.put("loiDate", loiDate);
		}
		if(request.getParameter(BILLABLE)!= null){
			String billable = "y";
			generalMap.put("billable", billable);
		}else{
			String billable = "n";
			generalMap.put("billable", billable);
		}

		if(request.getParameter(EXTENSION)!= null){
			String extension = "y";
			generalMap.put("extension", extension);
		}else{
			String extension = "n";
			generalMap.put("extension", extension);
		}
		if(request.getParameter(PURCHASE_ORDER_NO)!= null){
			String purchaseOrderNo = request.getParameter(PURCHASE_ORDER_NO);
			generalMap.put("purchaseOrderNo", purchaseOrderNo);
		}
		if(request.getParameter(PURCHASE_ORDER_DATE)!= null && !(request.getParameter(PURCHASE_ORDER_DATE).equals(""))){
			Date purchaseOrderDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(PURCHASE_ORDER_DATE));
			generalMap.put("purchaseOrderDate", purchaseOrderDate);
		}
		if(request.getParameter(CONTRACT_DATE)!= null  && !(request.getParameter(CONTRACT_DATE).equals(""))){
			Date contractDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(CONTRACT_DATE));
			generalMap.put("contractDate", contractDate);
		}
		if(request.getParameter(CONTRACT_NO)!= null){
			String contractNo = request.getParameter(CONTRACT_NO);
			generalMap.put("contractNo", contractNo);
		}
		if(request.getParameter(CURRENCY_ID)!= null && ! request.getParameter(CURRENCY_ID).equals("0")){
			int currencyId =Integer.parseInt(request.getParameter(CURRENCY_ID));
			generalMap.put("currencyId", currencyId);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			String changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}

		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			String	currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		map = projectTrackingHandlerService.updateProjectCreation(generalMap);
		String jsp = PROJECT_CREATION_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchProjectCreation(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int searchProjectStatusId = 0;
		if(request.getParameter(SEARCH_PROJECT_STATUS_ID)!= null ){
			 searchProjectStatusId =Integer.parseInt(request.getParameter(SEARCH_PROJECT_STATUS_ID));
			generalMap.put("searchProjectStatusId", searchProjectStatusId);
		}
		String searchProjectName = "";
		if(request.getParameter(SEARCH_PROJECT_NAME)!= null ){
			 searchProjectName = request.getParameter(SEARCH_PROJECT_NAME);
			generalMap.put("searchProjectName", searchProjectName);
		}
		String searchProtocolNo = "";
		if(request.getParameter(SEARCH_PROTOCOL_NO)!= null ){
			 searchProtocolNo = request.getParameter(SEARCH_PROTOCOL_NO);
			generalMap.put("searchProtocolNo", searchProtocolNo);
		}
		String searchProjectCode = "";
		if(request.getParameter(SEARCH_PROJECT_CODE)!= null ){
			searchProjectCode = request.getParameter(SEARCH_PROJECT_CODE);
			generalMap.put("searchProjectCode", searchProjectCode);
		}
		map = projectTrackingHandlerService.searchProjectCreation(generalMap);
		String jsp = PROJECT_CREATION_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("search","search");
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView getExistingProjectListForAjax(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		map = projectTrackingHandlerService.getExistingProjectListForAjax();
			return new ModelAndView("hr_responseForExistingProjectList", "map", map);
		}
	public ModelAndView insertNewProjectForAjax(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//map = projectTrackingHandlerService.insertNewProjectForAjax();
		return new ModelAndView("hr_responseForNewProject", "map", map);
	}

	public ModelAndView showProjectVitalsJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = projectTrackingHandlerService.showProjectVitalsJsp();
		String jsp = PROJECT_VITALS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showSitePaymentScheduleJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int projectId = 0;

		if(request.getParameter("projectId")!= null){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}
		map = projectTrackingHandlerService.showSitePaymentScheduleJsp(projectId);
		String jsp = SITE_PAYMENT_SCHEDULE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveSitePaymentSchedule(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		if (session.getAttribute("hospitalId")!= null) {
			int	hospitalId = (Integer)session.getAttribute("hospitalId");
			generalMap.put("hospitalId", hospitalId);
		}
		int projectId = 0;
		if(request.getParameter(PROJECT_ID)!= null){
			projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		if(request.getParameter(PATIENT_VISIT_ID)!= null){
		   int	visitId = Integer.parseInt(request.getParameter(PATIENT_VISIT_ID));
		   generalMap.put("visitId", visitId);
		}
		if(request.getParameter(AMOUNT_PER_PATIENT)!= null){
			   BigDecimal amountPerPatient = new BigDecimal(request.getParameter(AMOUNT_PER_PATIENT));
			   generalMap.put("amountPerPatient", amountPerPatient);
		}
		if(request.getParameter(PAYMENT)!= null){
			   BigDecimal paymentInPercentage = new BigDecimal(request.getParameter(PAYMENT));
			   generalMap.put("paymentInPercentage", paymentInPercentage);
		}
		if(request.getParameter(AMOUNT)!= null){
			   BigDecimal paymentInAmount = new BigDecimal(request.getParameter(AMOUNT));
			   generalMap.put("paymentInAmount", paymentInAmount);
		}
		if(request.getParameter(CUT_OFF_DATE)!= null  && !(request.getParameter(CUT_OFF_DATE).equals(""))){
			Date cutOffDateDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(CUT_OFF_DATE));
			generalMap.put("cutOffDateDate", cutOffDateDate);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			String changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}

		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			String	currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		map = projectTrackingHandlerService.saveSitePaymentSchedule(generalMap);
		String jsp = SITE_PAYMENT_SCHEDULE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView updateSitePaymentSchedule(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		if(request.getParameter(SITE_PAYMENT_SCHEDULE_ID)!= null){
			int	sitePaymentScheduleId = Integer.parseInt(request.getParameter(SITE_PAYMENT_SCHEDULE_ID));
			generalMap.put("sitePaymentScheduleId", sitePaymentScheduleId);
		}

		if(request.getParameter(PROJECT_ID)!= null){
			int	projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		if(request.getParameter(PATIENT_VISIT_ID)!= null){
		   int	visitId = Integer.parseInt(request.getParameter(PATIENT_VISIT_ID));
		   generalMap.put("visitId", visitId);
		}
		if(request.getParameter(AMOUNT_PER_PATIENT)!= null){
			   BigDecimal amountPerPatient = new BigDecimal(request.getParameter(AMOUNT_PER_PATIENT));
			   generalMap.put("amountPerPatient", amountPerPatient);
		}
		if(request.getParameter(PAYMENT)!= null){
			   BigDecimal paymentInPercentage = new BigDecimal(request.getParameter(PAYMENT));
			   generalMap.put("paymentInPercentage", paymentInPercentage);
		}
		if(request.getParameter(AMOUNT)!= null){
			   BigDecimal paymentInAmount = new BigDecimal(request.getParameter(AMOUNT));
			   generalMap.put("paymentInAmount", paymentInAmount);
		}
		if(request.getParameter(CUT_OFF_DATE)!= null  && !(request.getParameter(CUT_OFF_DATE).equals(""))){
			Date cutOffDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(CUT_OFF_DATE));
			generalMap.put("cutOffDate", cutOffDate);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			String changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}

		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			String	currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		map = projectTrackingHandlerService.updateSitePaymentSchedule(generalMap);
		String jsp = SITE_PAYMENT_SCHEDULE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showRoleWiseResourceReuiredJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int projectId = 0;
		if(request.getParameter("projectId")!= null){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}
		map = projectTrackingHandlerService.showRoleWiseResourceReuiredJsp(projectId);
		String jsp = ROLE_WISE_RESOURCE_REQUIRED_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveRoleWiseResourceRequired(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		if (session.getAttribute("hospitalId")!= null) {
			int	hospitalId = (Integer)session.getAttribute("hospitalId");
			generalMap.put("hospitalId", hospitalId);
		}
		if(request.getParameter(PROJECT_ID)!= null){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		if(request.getParameter(PROJECT_ROLE_ID)!= null){
			int projectRoleId = Integer.parseInt(request.getParameter(PROJECT_ROLE_ID));
			generalMap.put("projectRoleId", projectRoleId);
		}
		if(request.getParameter(REQUIRED_NO)!= null){
			int reqNo = Integer.parseInt(request.getParameter(REQUIRED_NO));
			generalMap.put("reqNo", reqNo);
		}
		if(request.getParameter(COST_PER_HOUR)!= null){
			   BigDecimal costPerHour = new BigDecimal(request.getParameter(COST_PER_HOUR));
			   generalMap.put("costPerHour", costPerHour);
		}

		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			String changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}

		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			String	currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		map = projectTrackingHandlerService.saveRoleWiseResourceRequired(generalMap);
		String jsp = ROLE_WISE_RESOURCE_REQUIRED_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView updateRoleWiseResourceRequired(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		if(request.getParameter(ROLE_WISE_RESOURCE_REQ_ID)!= null){
			int roleWiseresourceRequiredId = Integer.parseInt(request.getParameter(ROLE_WISE_RESOURCE_REQ_ID));
			generalMap.put("roleWiseresourceRequiredId", roleWiseresourceRequiredId);
		}

		if(request.getParameter(PROJECT_ID)!= null){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		if(request.getParameter(PROJECT_ROLE_ID)!= null){
			int projectRoleId = Integer.parseInt(request.getParameter(PROJECT_ROLE_ID));
			generalMap.put("projectRoleId", projectRoleId);
		}
		if(request.getParameter(REQUIRED_NO)!= null){
			int reqNo = Integer.parseInt(request.getParameter(REQUIRED_NO));
			generalMap.put("reqNo", reqNo);
		}
		if(request.getParameter(COST_PER_HOUR)!= null){
			   BigDecimal costPerHour = new BigDecimal(request.getParameter(COST_PER_HOUR));
			   generalMap.put("costPerHour", costPerHour);
		}

		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			String changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}

		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			String	currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		map = projectTrackingHandlerService.updateRoleWiseResourceRequired(generalMap);
		String jsp = ROLE_WISE_RESOURCE_REQUIRED_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showProjectCalendarJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int projectId = 0;
		if(request.getParameter("projectId")!= null){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}
		map = projectTrackingHandlerService.showProjectCalendarJsp(projectId);
		String jsp = PROJECT_CALENDAR_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveProjectCalendar(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		if (session.getAttribute("hospitalId")!= null) {
			int	hospitalId = (Integer)session.getAttribute("hospitalId");
			generalMap.put("hospitalId", hospitalId);
		}
		if(request.getParameter(PROJECT_ID)!= null){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		if(request.getParameter(CALENDAR_ID)!= null){
			int calendarId = Integer.parseInt(request.getParameter(CALENDAR_ID));
			generalMap.put("calendarId", calendarId);
		}
		if(request.getParameter(PLANNED_DATE) != null && !(request.getParameter(PLANNED_DATE).equals(""))){
			Date plannedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(PLANNED_DATE));
			generalMap.put("plannedDate", plannedDate);
		}
		if(request.getParameter(PLANNED_REMARK)!= null){
			String plannedRemark = request.getParameter(PLANNED_REMARK);
			generalMap.put("plannedRemark", plannedRemark);
		}
		if(request.getParameter(REVISED_DATE) != null && !(request.getParameter(REVISED_DATE).equals(""))){
			Date revisedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(REVISED_DATE));
			generalMap.put("revisedDate", revisedDate);
		}
		if(request.getParameter(REVISED_REMARK)!= null){
			String revisedRemark = request.getParameter(REVISED_REMARK);
			generalMap.put("revisedRemark", revisedRemark);
		}
		if(request.getParameter(ACTUAL_DATE) != null && !(request.getParameter(ACTUAL_DATE).equals(""))){
			Date actualDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(ACTUAL_DATE));
			generalMap.put("actualDate", actualDate);
		}
		if(request.getParameter(ACTUAL_REMARK)!= null){
			String actualRemark = request.getParameter(ACTUAL_REMARK);
			generalMap.put("actualRemark", actualRemark);
		}
		if(request.getParameter(NO_OF_DAYS)!= null  &&  ! (request.getParameter(NO_OF_DAYS)).equals("")){
			int noOfDays = Integer.parseInt(request.getParameter(NO_OF_DAYS));
			generalMap.put("noOfDays", noOfDays);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			String changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}

		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			String	currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		map = projectTrackingHandlerService.saveProjectCalendar(generalMap);
		String jsp = PROJECT_CALENDAR_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView updateProjectCalendar(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		if(request.getParameter(PROJECT_CALENDAR_ID)!= null){
			int projectCalenderId = Integer.parseInt(request.getParameter(PROJECT_CALENDAR_ID));
			generalMap.put("projectCalenderId", projectCalenderId);
		}

		if(request.getParameter(PROJECT_ID)!= null){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		if(request.getParameter(CALENDAR_ID)!= null){
			int calendarId = Integer.parseInt(request.getParameter(CALENDAR_ID));
			generalMap.put("calendarId", calendarId);
		}
		if(request.getParameter(PLANNED_DATE) != null && !(request.getParameter(PLANNED_DATE).equals(""))){
			Date plannedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(PLANNED_DATE));
			generalMap.put("plannedDate", plannedDate);
		}
		if(request.getParameter(PLANNED_REMARK)!= null){
			String plannedRemark = request.getParameter(PLANNED_REMARK);
			generalMap.put("plannedRemark", plannedRemark);
		}
		if(request.getParameter(REVISED_DATE) != null && !(request.getParameter(REVISED_DATE).equals(""))){
			Date revisedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(REVISED_DATE));
			generalMap.put("revisedDate", revisedDate);
		}
		if(request.getParameter(REVISED_REMARK)!= null){
			String revisedRemark = request.getParameter(REVISED_REMARK);
			generalMap.put("revisedRemark", revisedRemark);
		}
		if(request.getParameter(ACTUAL_DATE) != null && !(request.getParameter(ACTUAL_DATE).equals(""))){
			Date actualDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(ACTUAL_DATE));
			generalMap.put("actualDate", actualDate);
		}
		if(request.getParameter(ACTUAL_REMARK)!= null){
			String actualRemark = request.getParameter(ACTUAL_REMARK);
			generalMap.put("actualRemark", actualRemark);
		}
		if(request.getParameter(NO_OF_DAYS)!= null  &&  ! (request.getParameter(NO_OF_DAYS)).equals("")){
			int noOfDays = Integer.parseInt(request.getParameter(NO_OF_DAYS));
			generalMap.put("noOfDays", noOfDays);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			String changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}

		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			String	currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		map = projectTrackingHandlerService.updateProjectCalendar(generalMap);
		String jsp = PROJECT_CALENDAR_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showBudgetSettingJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int projectId = 0;
		if(request.getParameter("projectId")!= null){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}
		map = projectTrackingHandlerService.showBudgetSettingJsp(projectId);
		String jsp = BUDGET_SETTING_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveBudgetSetting(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		if (session.getAttribute("hospitalId")!= null) {
			int	hospitalId = (Integer)session.getAttribute("hospitalId");
			generalMap.put("hospitalId", hospitalId);
		}
		if(request.getParameter(PROJECT_ID)!= null){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		if(request.getParameter(BUDGET_TYPE_ID)!= null){
			int budgetTypeId = Integer.parseInt(request.getParameter(BUDGET_TYPE_ID));
			generalMap.put("budgetTypeId", budgetTypeId);
		}
		if(request.getParameter(BUDGET_SUBHEADING_ID)!= null){
			int budgetSubHeadId = Integer.parseInt(request.getParameter(BUDGET_SUBHEADING_ID));
			generalMap.put("budgetSubHeadId", budgetSubHeadId);
		}
		if(request.getParameter(TASK_TYPE_ID)!= null){
			int taskTypeId = Integer.parseInt(request.getParameter(TASK_TYPE_ID));
			generalMap.put("taskTypeId", taskTypeId);
		}
		if(request.getParameter(TASK_ID)!= null){
			int taskId = Integer.parseInt(request.getParameter(TASK_ID));
			generalMap.put("taskId", taskId);
		}
		if(request.getParameter(PROJECT_ROLE_ID)!= null){
			int projectRoleId = Integer.parseInt(request.getParameter(PROJECT_ROLE_ID));
			generalMap.put("projectRoleId", projectRoleId);
		}
		if(request.getParameter(REQUIRED_NO)!= null){
			int requiredResource = Integer.parseInt(request.getParameter(REQUIRED_NO));
			generalMap.put("requiredResource", requiredResource);
		}
		if(request.getParameter(HR_REQ)!= null){
			BigDecimal hrRequired = new BigDecimal(request.getParameter(HR_REQ));
			generalMap.put("hrRequired", hrRequired);
		}

		if(request.getParameter(COST_PER_HOUR)!= null){
			BigDecimal costPerHr = new BigDecimal(request.getParameter(COST_PER_HOUR));
			generalMap.put("costPerHr", costPerHr);
		}
		if(request.getParameter(TOTAL_COST)!= null){
			BigDecimal totalCost = new BigDecimal(request.getParameter(TOTAL_COST));
			generalMap.put("totalCost", totalCost);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			String changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}

		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			String	currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		map = projectTrackingHandlerService.saveBudgetSetting(generalMap);
		String jsp = BUDGET_SETTING_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView updateBudgetSetting(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		if(request.getParameter(BUDGET_SETTING_ID)!= null){
			int budgetSettingId = Integer.parseInt(request.getParameter(BUDGET_SETTING_ID));
			generalMap.put("budgetSettingId", budgetSettingId);
		}
		if(request.getParameter(PROJECT_ID)!= null){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		if(request.getParameter(BUDGET_TYPE_ID)!= null){
			int budgetTypeId = Integer.parseInt(request.getParameter(BUDGET_TYPE_ID));
			generalMap.put("budgetTypeId", budgetTypeId);
		}
		if(request.getParameter(BUDGET_SUBHEADING_ID)!= null){
			int budgetSubHeadId = Integer.parseInt(request.getParameter(BUDGET_SUBHEADING_ID));
			generalMap.put("budgetSubHeadId", budgetSubHeadId);
		}
		if(request.getParameter(TASK_TYPE_ID)!= null){
			int taskTypeId = Integer.parseInt(request.getParameter(TASK_TYPE_ID));
			generalMap.put("taskTypeId", taskTypeId);
		}
		if(request.getParameter(TASK_ID)!= null){
			int taskId = Integer.parseInt(request.getParameter(TASK_ID));
			generalMap.put("taskId", taskId);
		}
		if(request.getParameter(PROJECT_ROLE_ID)!= null){
			int projectRoleId = Integer.parseInt(request.getParameter(PROJECT_ROLE_ID));
			generalMap.put("projectRoleId", projectRoleId);
		}
		if(request.getParameter(REQUIRED_NO)!= null){
			int requiredResource = Integer.parseInt(request.getParameter(REQUIRED_NO));
			generalMap.put("requiredResource", requiredResource);
		}
		if(request.getParameter(HR_REQ)!= null){
			BigDecimal hrRequired = new BigDecimal(request.getParameter(HR_REQ));
			generalMap.put("hrRequired", hrRequired);
		}
		if(request.getParameter(REQ_RESOURCE_INTO_COST_PER_HOUR)!= null){
			BigDecimal reqResourceIntoCostperHr = new BigDecimal(request.getParameter(REQ_RESOURCE_INTO_COST_PER_HOUR));
			generalMap.put("reqResourceIntoCostperHr", reqResourceIntoCostperHr);
		}
		if(request.getParameter(COST_PER_HOUR)!= null  && !(request.getParameter(COST_PER_HOUR).equals(""))){
			BigDecimal costPerHr = new BigDecimal(request.getParameter(COST_PER_HOUR));
			generalMap.put("costPerHr", costPerHr);
		}
		if(request.getParameter(TOTAL_COST)!= null){
			BigDecimal totalCost = new BigDecimal(request.getParameter(TOTAL_COST));
			generalMap.put("totalCost", totalCost);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			String changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}

		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			String	currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		map = projectTrackingHandlerService.updateBudgetSetting(generalMap);
		String jsp = BUDGET_SETTING_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showRoleResourceMappingJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int projectId = 0;
		if(request.getParameter("projectId")!= null){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}
		map = projectTrackingHandlerService.showRoleResourceMappingJsp(projectId);
		String jsp = HR_ROLE_RESOURCE_MAPPING_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveRoleResourceMapping(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int projectId =0;
		if (session.getAttribute("hospitalId")!= null) {
			int	hospitalId = (Integer)session.getAttribute("hospitalId");
			generalMap.put("hospitalId", hospitalId);
		}
		if(request.getParameter(PROJECT_ROLE_ID)!= null){
			int projectRoleId = Integer.parseInt(request.getParameter(PROJECT_ROLE_ID));
			generalMap.put("projectRoleId", projectRoleId);
		}
		if(request.getParameter(PROJECT_ID)!= null){
			projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		if(request.getParameter(DEPARTMENT_ID)!= null){
			int departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			generalMap.put("departmentId", departmentId);
		}
		if(request.getParameter(EMPLOYEE_ID)!= null){
			int employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			generalMap.put("employeeId", employeeId);
		}
		if(request.getParameter(REQUIRED_NO)!= null){
			int requiredResource = Integer.parseInt(request.getParameter(REQUIRED_NO));
			generalMap.put("requiredResource", requiredResource);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			String changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}

		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			String	currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		/*float hrWorked= 0f;
		if(request.getParameter("hrWorked")!=null)
		{
			hrWorked = new Float(request.getParameter("hrWorked"));
		}
		float minWorked= 0f;
		if(request.getParameter("minWorked")!=null && !(request.getParameter("minWorked").equals("")))
		{
			minWorked = new Float(request.getParameter("minWorked"));
			if(minWorked==60)
			{
				hrWorked++;
			}else{
			minWorked= minWorked/100;
			hrWorked=hrWorked+minWorked;
			}
		}
		generalMap.put("hrWorked", hrWorked);*/
		 map = projectTrackingHandlerService.saveRoleResourceMapping(generalMap);
		 map = projectTrackingHandlerService.showRoleResourceMappingJsp(projectId);
		String jsp = HR_ROLE_RESOURCE_MAPPING_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView updateRoleResourceMapping(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		if(request.getParameter(ROLE_RESOURCE_MAPPING_HEADER_ID)!= null){
			int roleResourceMappingHeaderId = Integer.parseInt(request.getParameter(ROLE_RESOURCE_MAPPING_HEADER_ID));
			generalMap.put("roleResourceMappingHeaderId", roleResourceMappingHeaderId);
		}
		if(request.getParameter(PROJECT_ROLE_ID)!= null){
			int projectRoleId = Integer.parseInt(request.getParameter(PROJECT_ROLE_ID));
			generalMap.put("projectRoleId", projectRoleId);
		}
		if(request.getParameter(PROJECT_ID)!= null){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}

		if(request.getParameter(EMPLOYEE_ID)!= null){
			int employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			generalMap.put("employeeId", employeeId);
		}
		if(request.getParameter(DEPARTMENT_ID)!= null){
			int departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			generalMap.put("departmentId", departmentId);
		}
		if(request.getParameter(REQUIRED_NO)!= null){
			int requiredResource = Integer.parseInt(request.getParameter(REQUIRED_NO));
			generalMap.put("requiredResource", requiredResource);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			String changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}

		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			String	currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		/*float hrWorked= 0f;
		if(request.getParameter("hrWorked")!=null)
		{
			hrWorked = new Float(request.getParameter("hrWorked"));
		}
		float minWorked= 0f;
		if(request.getParameter("minWorked")!=null && !(request.getParameter("minWorked").equals("")))
		{
			minWorked = new Float(request.getParameter("minWorked"));
			if(minWorked==60)
			{
				hrWorked++;
			}else{
			minWorked= minWorked/100;
			hrWorked=hrWorked+minWorked;
			}
		}
		generalMap.put("hrWorked", hrWorked);*/
		map = projectTrackingHandlerService.updateRoleResourceMapping(generalMap);
		String jsp = HR_ROLE_RESOURCE_MAPPING_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showTaskSettingForProjectRole(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		if(request.getParameter("aaa")!= null){
			int roleResourceHeaderId = Integer.parseInt(request.getParameter("aaa"));
			generalMap.put("roleResourceHeaderId", roleResourceHeaderId);
		}
		if(request.getParameter("projectId")!= null){
			int projectId = Integer.parseInt(request.getParameter("projectId"));
			generalMap.put("projectId", projectId);
		}
		map = projectTrackingHandlerService.showTaskSettingForProjectRole(generalMap);
		String jsp = TASK_SETTING_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveAssignTaskToRoleResourceHeader(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		if(request.getParameter("roleResourceHeaderId")!= null){
			int roleResourceHeaderId = Integer.parseInt(request.getParameter("roleResourceHeaderId"));
			generalMap.put("roleResourceHeaderId", roleResourceHeaderId);
		}
		if(request.getParameter("projectId")!= null){
			int projectId = Integer.parseInt(request.getParameter("projectId"));
			generalMap.put("projectId", projectId);
		}
		map = projectTrackingHandlerService.saveAssignTaskToRoleResourceHeader(generalMap);
		String jsp = TASK_SETTING_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveTaskInRoleResourceMappingDetail(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		if(request.getParameter(ROLE_RESOURCE_MAPPING_HEADER_ID)!= null){
			int roleResourceHeaderId = Integer.parseInt(request.getParameter(ROLE_RESOURCE_MAPPING_HEADER_ID));
			generalMap.put("roleResourceHeaderId", roleResourceHeaderId);
		}
		if(request.getParameter(PROJECT_ID)!= null){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		if(request.getParameter(TASK_ID)!= null){
			int taskId = Integer.parseInt(request.getParameter(TASK_ID));
			generalMap.put("taskId", taskId);
		}
		if(request.getParameter(TASK_TYPE_ID)!= null){
			int taskTypeId = Integer.parseInt(request.getParameter(TASK_TYPE_ID));
			generalMap.put("taskTypeId", taskTypeId);
		}
		if(request.getParameter(BILLABLE)!= null){
			String billable = "y";
			generalMap.put("billable", billable);
		}else{
			String billable = "n";
			generalMap.put("billable", billable);
		}
		map = projectTrackingHandlerService.saveTaskInRoleResourceMappingDetail(generalMap);
		String jsp = TASK_SETTING_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView updateTaskInRoleResourceMappingDetail(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		if(request.getParameter(ROLE_RESOURCE_MAPPING_DETAIL_ID)!= null){
			int roleResourceDetailId = Integer.parseInt(request.getParameter(ROLE_RESOURCE_MAPPING_DETAIL_ID));
			generalMap.put("roleResourceDetailId", roleResourceDetailId);
		}

		if(request.getParameter(ROLE_RESOURCE_MAPPING_HEADER_ID)!= null){
			int roleResourceHeaderId = Integer.parseInt(request.getParameter(ROLE_RESOURCE_MAPPING_HEADER_ID));
			generalMap.put("roleResourceHeaderId", roleResourceHeaderId);
		}
		if(request.getParameter(PROJECT_ID)!= null){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		if(request.getParameter(TASK_ID)!= null){
			int taskId = Integer.parseInt(request.getParameter(TASK_ID));
			generalMap.put("taskId", taskId);
		}
		if(request.getParameter(TASK_TYPE_ID)!= null){
			int taskTypeId = Integer.parseInt(request.getParameter(TASK_TYPE_ID));
			generalMap.put("taskTypeId", taskTypeId);
		}
		if(request.getParameter(BILLABLE)!= null){
			String billable = "y";
			generalMap.put("billable", billable);
		}else{
			String billable = "n";
			generalMap.put("billable", billable);
		}
		map =projectTrackingHandlerService.updateTaskInRoleResourceMappingDetail(generalMap);
		String jsp = TASK_SETTING_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showFeasibilityStudyJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int projectId = 0;
		if(request.getParameter("projectId")!= null){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}
		map = projectTrackingHandlerService.showFeasibilityStudyJsp(projectId);
		String jsp = FEASIBILITY_STUDY;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveSelectedDoctors(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		if(request.getParameter(PROJECT_ID)!= null){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		if(request.getParameter(PI_HEADER_ID)!= null){
			int piHeaderId = Integer.parseInt(request.getParameter(PI_HEADER_ID));
			generalMap.put("piHeaderId", piHeaderId);
		}
		if(request.getParameter("piStatus")!= null){
			String piStatus = request.getParameter("piStatus");
			generalMap.put("piStatus", piStatus);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			String changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}

		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			String	currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		map = projectTrackingHandlerService.saveSelectedDoctors(generalMap);
		String jsp = FEASIBILITY_STUDY;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView updateSelectedPi(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		if(request.getParameter(FEASIBILITY_STUDY_ID)!= null){
			int feasibilityStudyHeaderId =Integer.parseInt(request.getParameter(FEASIBILITY_STUDY_ID));
			generalMap.put("feasibilityStudyHeaderId", feasibilityStudyHeaderId);
		}

		if(request.getParameter(PROJECT_ID)!= null){
			int projectId =Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}

		if(request.getParameter(PI_HEADER_ID)!= null){
			int piHeaderId = Integer.parseInt(request.getParameter(PI_HEADER_ID));
			generalMap.put("piHeaderId", piHeaderId);
		}
		if(request.getParameter("piStatus")!= null){
			String piStatus = request.getParameter("piStatus");
			generalMap.put("piStatus", piStatus);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			String changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}

		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			String	currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		map = projectTrackingHandlerService.updateSelectedPi(generalMap);
		String jsp = FEASIBILITY_STUDY;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getCallPiDetailForAjax(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int feasibiltyStudyId = 0;
		if(request.getParameter("feasibiltyStudyId")!= null){
			feasibiltyStudyId = Integer.parseInt(request.getParameter("feasibiltyStudyId"));
			generalMap.put("feasibiltyStudyId", feasibiltyStudyId);
		}
		int projectId = 0;
		if(request.getParameter(PROJECT_ID)!= null){
			projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		map = projectTrackingHandlerService.getCallPiDetailForAjax(generalMap);
		return new ModelAndView("hr_responseForPiDetail", "map", map);
	}
	public ModelAndView saveDoctorsCallDetail(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		if(request.getParameter("feasibilityStuduId")!= null){
			int feasibilityStudyHeaderId =Integer.parseInt(request.getParameter("feasibilityStuduId"));
			generalMap.put("feasibilityStudyHeaderId", feasibilityStudyHeaderId);
		}

		if(request.getParameter("projectId")!= null){
			int projectId =Integer.parseInt(request.getParameter("projectId"));
			generalMap.put("projectId", projectId);
		}

		if(request.getParameter(CALL_DATE) != null && !(request.getParameter(CALL_DATE).equals(""))){
			Date calDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CALL_DATE));
			generalMap.put("calDate", calDate);
		}
		if(request.getParameter(COMMENTS)!= null){
			String comments = request.getParameter(COMMENTS);
			generalMap.put("comments", comments);
		}
		map = projectTrackingHandlerService.saveDoctorsCallDetail(generalMap);
		String jsp = FEASIBILITY_STUDY;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addSiteDetailForPi(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		if(request.getParameter("feasibilityStuduId")!= null){
			int feasibilityStudyHeaderId =Integer.parseInt(request.getParameter("feasibilityStuduId"));
			generalMap.put("feasibilityStudyHeaderId", feasibilityStudyHeaderId);
		}

		if(request.getParameter("projectId")!= null){
			int projectId =Integer.parseInt(request.getParameter("projectId"));
			generalMap.put("projectId", projectId);
		}
		map = projectTrackingHandlerService.addSiteDetailForPi(generalMap);
		String jsp = ASSIGN_SITE_FOR_PI;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveAssignSiteDetails(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		if(request.getParameter(PROJECT_ID)!= null){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		if(request.getParameter(FES_STUDY_HEADER_ID)!= null){
			int feasibilityStudyHeaderId = Integer.parseInt(request.getParameter(FES_STUDY_HEADER_ID));
			generalMap.put("feasibilityStudyHeaderId", feasibilityStudyHeaderId);
		}
		if(request.getParameter(SITE_HEADER_ID)!= null){
			int siteHeaderId = Integer.parseInt(request.getParameter(SITE_HEADER_ID));
			generalMap.put("siteHeaderId", siteHeaderId);
		}
		if(request.getParameter(SQ_VISIT)!= null){
			String sqVisit = request.getParameter(SQ_VISIT);
			generalMap.put("sqVisit", sqVisit);
		}
		if(request.getParameter(SQ_VISIT_STATUS)!= null){
			String sqVisitStatus = request.getParameter(SQ_VISIT_STATUS);
			generalMap.put("sqVisitStatus", sqVisitStatus);
		}
		if(! request.getParameter(EMPLOYEE_ID).equals("0")){
			int delegateId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			generalMap.put("delegateId", delegateId);
		}
		if(request.getParameter(SQ_VISIT_STATUS)!= null){
			String sqVisitStatus = request.getParameter(SQ_VISIT_STATUS);
			generalMap.put("sqVisitStatus", sqVisitStatus);
		}
		if(request.getParameter(PLANNED_DATE) != null && !(request.getParameter(PLANNED_DATE).equals(""))){
			Date plannedVisitDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(PLANNED_DATE));
			generalMap.put("plannedVisitDate", plannedVisitDate);
		}
		map = projectTrackingHandlerService.saveAssignSiteDetails(generalMap);
		String jsp = ASSIGN_SITE_FOR_PI;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showSqVisitUpdateJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int projectId = 0;
		if(request.getParameter("projectId")!= null){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}
		map = projectTrackingHandlerService.showSqVisitUpdateJsp(projectId);
		String jsp = SQ_VISIT_UPDATE;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveSQVisitUpdateDetails(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		if(request.getParameter(PROJECT_ID)!= null){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		if(request.getParameter(FES_STUDY_HEADER_ID)!= null){
			int feasibilityStudyHeaderId = Integer.parseInt(request.getParameter(FES_STUDY_HEADER_ID));
			generalMap.put("feasibilityStudyHeaderId", feasibilityStudyHeaderId);
		}
		if(request.getParameter(ACTUAL_DATE) != null && !(request.getParameter(ACTUAL_DATE).equals(""))){
			Date actualVisitDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(ACTUAL_DATE));
			generalMap.put("actualVisitDate", actualVisitDate);
		}
		if(request.getParameter(COMMENTS)!= null){
			String comments = request.getParameter(COMMENTS);
			generalMap.put("comments", comments);
		}
		map = projectTrackingHandlerService.saveSQVisitUpdateDetails(generalMap);
		String jsp = SQ_VISIT_UPDATE;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView updateSQVisitUpdateDetails(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		if(request.getParameter(PROJECT_ID)!= null){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		if(request.getParameter(FES_STUDY_HEADER_ID)!= null){
			int feasibilityStudyHeaderId = Integer.parseInt(request.getParameter(FES_STUDY_HEADER_ID));
			generalMap.put("feasibilityStudyHeaderId", feasibilityStudyHeaderId);
		}
		if(request.getParameter(ACTUAL_DATE) != null && !(request.getParameter(ACTUAL_DATE).equals(""))){
			Date actualVisitDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(ACTUAL_DATE));
			generalMap.put("actualVisitDate", actualVisitDate);
		}
		if(request.getParameter(COMMENTS)!= null){
			String comments = request.getParameter(COMMENTS);
			generalMap.put("comments", comments);
		}
		map = projectTrackingHandlerService.updateSQVisitUpdateDetails(generalMap);
		String jsp = SQ_VISIT_UPDATE;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView displaySqVisitUpdateAttachment(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		if(request.getParameter(PROJECT_ID)!= null){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		int feasibilityHeaderId = 0;
		if(request.getParameter("fesbilitystudyId")!= null){
			feasibilityHeaderId = Integer.parseInt(request.getParameter("fesbilitystudyId"));
			generalMap.put("feasibilityHeaderId", feasibilityHeaderId);
		}
		map = projectTrackingHandlerService.displaySqVisitUpdateAttachment(generalMap);
		String jsp = UPLOAD_SQ_VISIT_UPDATE_POPUP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView addSqVisitUpdateFile(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MultipartFormDataRequest mrequest = null;
		if (MultipartFormDataRequest.isMultipartFormData(request))
		   {
				try
				{
					mrequest = new MultipartFormDataRequest(request);
				}
				catch (UploadException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
		   }
		String fileExtension=null;
		String uploadURL = getServletContext().getRealPath("/Attendance/");
		String filename = "";
		List fileUploadedList = null;
			if(request.getParameter("filename")!= null){
				filename = request.getParameter("filename");
			}
			generalMap.put("filename", filename);
			StringTokenizer strToken=new StringTokenizer(filename,".");

			filename=strToken.nextToken();
		   	fileExtension=strToken.nextToken();
		   	String whiteList = "*."+fileExtension;

		   	fileUploadedList = HMSUtil.uploadTicketFile(mrequest,uploadURL, whiteList,filename);

			String comments = "";
			if( mrequest.getParameter("comments")!= null){
				comments = mrequest.getParameter("comments");
				generalMap.put("comments", comments);
			}
			int feasibilityHeaderId = 0;
			if(mrequest.getParameter(FES_STUDY_HEADER_ID)!= null){
				feasibilityHeaderId = Integer.parseInt(mrequest.getParameter(FES_STUDY_HEADER_ID));
				generalMap.put("feasibilityHeaderId", feasibilityHeaderId);
			}

			generalMap.put("uploadURL", uploadURL);
		map = projectTrackingHandlerService.addSqVisitUpdateFile(generalMap);
		String jsp = UPLOAD_SQ_VISIT_UPDATE_POPUP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showRequlatoryMenuJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = projectTrackingHandlerService.showRequlatoryMenuJsp();
		String jsp = REQULATORY_MENU_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showSiteSettingJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = projectTrackingHandlerService.showSiteSettingJsp();
		String jsp = SITE_SETTING_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showProjectSitesList(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int projectId = 0;
		if(request.getParameter(PROJECT_ID)!= null){
			projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
		}
		map = projectTrackingHandlerService.showProjectSitesList(projectId);
		String jsp = SITE_SETTING_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showSiteVitalsJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		Map<String,Object> mapForDs=new HashMap<String,Object>();

		Users user=(Users)session.getAttribute(USERS);
		MasEmployee employee= user.getEmployee();

		mapForDs.put("employeeId", employee.getId());
		mapForDs.put("users", user);

		int projectId = 0;
		if(request.getParameter(PROJECT_ID)!= null){
			projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
		}

		int siteId = 0;
		if(request.getParameter("siteId")!= null){
			siteId = Integer.parseInt(request.getParameter("siteId"));
		}

		map = projectTrackingHandlerService.showSiteVitalsJsp(projectId,siteId);

		Map<String ,Object> newMap=commonMasterHandlerService.getUserButtonRights(mapForDs);
		List<UserButtonRights> userRightsList=(List<UserButtonRights>)newMap.get("userRightsList");
		map.put("userRightsList", userRightsList);

		String jsp = SITE_VITALS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveSiteVitals(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		Map<String,Object> mapForDs=new HashMap<String,Object>();

		Users user=(Users)session.getAttribute(USERS);
		MasEmployee employee= user.getEmployee();

		mapForDs.put("employeeId", employee.getId());
		mapForDs.put("users", user);

		if (session.getAttribute("hospitalId")!= null) {
			int	hospitalId = (Integer)session.getAttribute("hospitalId");
			generalMap.put("hospitalId", hospitalId);
		}
		if(request.getParameter("projectId")!= null){
			int projectId = Integer.parseInt(request.getParameter("projectId"));
			generalMap.put("projectId", projectId);
		}

		if(request.getParameter(SITE_ID)!= null){
			int siteId = Integer.parseInt(request.getParameter(SITE_ID));
			generalMap.put("siteId", siteId);
		}
		if(request.getParameter(VITAL_ID)!= null){
			int vitalId = Integer.parseInt(request.getParameter(VITAL_ID));
			generalMap.put("vitalId", vitalId);
		}
		if(request.getParameter(PLANNED_DATE) !=null && !(request.getParameter(PLANNED_DATE).equals(""))) {
			String plannedDate =request.getParameter(PLANNED_DATE);
			generalMap.put("plannedDate", plannedDate);
		}
		if(!request.getParameter(CURRENCY_ID).equals("0")){
			int currencyId = Integer.parseInt(request.getParameter(CURRENCY_ID));
			generalMap.put("currencyId", currencyId);
		}
		if(request.getParameter(FLAG) != null){
			String flag = request.getParameter(FLAG);
			generalMap.put("flag", flag);
		}
		if(request.getParameter(AMOUNT_FLAG) != null){
			String amountFlag = request.getParameter(AMOUNT_FLAG);
			generalMap.put("amountFlag", amountFlag);
		}
		if(request.getParameter(PLANNED_REMARK) != null){
			String plannedRemark = request.getParameter(PLANNED_REMARK);
			generalMap.put("plannedRemark", plannedRemark);

		}

		if(request.getParameter(REVISED_DATE) !=null && !(request.getParameter(REVISED_DATE).equals(""))) {
			String revisedDate =request.getParameter(REVISED_DATE);
			generalMap.put("revisedDate", revisedDate);
		}

		if(request.getParameter(REVISED_REMARK) != null){
			String revisedRemark = request.getParameter(REVISED_REMARK);
			generalMap.put("revisedRemark", revisedRemark);
		}

		if(request.getParameter(ACTUAL_DATE) !=null && !(request.getParameter(ACTUAL_DATE).equals(""))) {
			String actualDate =request.getParameter(ACTUAL_DATE);
			generalMap.put("actualDate", actualDate);
		}

		if(request.getParameter(ACTUAL_REMARK) != null ){
			String actualRemark = request.getParameter(ACTUAL_REMARK);
			generalMap.put("actualRemark", actualRemark);
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			 String changedBy =request.getParameter(CHANGED_BY);
			 generalMap.put("changedBy", changedBy);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			Date currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			 generalMap.put("currentDate", currentDate);
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
		   String	currentTime =request.getParameter(CHANGED_TIME);
		   generalMap.put("currentTime", currentTime);
		}
		map = projectTrackingHandlerService.saveSiteVitals(generalMap);

		Map<String ,Object> newMap=commonMasterHandlerService.getUserButtonRights(mapForDs);
		List<UserButtonRights> userRightsList=(List<UserButtonRights>)newMap.get("userRightsList");
		map.put("userRightsList", userRightsList);

		String jsp = SITE_VITALS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	 return new ModelAndView("index", "map", map);
}
	public ModelAndView updateSiteVitals(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		Map<String,Object> mapForDs=new HashMap<String,Object>();

		Users user=(Users)session.getAttribute(USERS);
		MasEmployee employee= user.getEmployee();

		mapForDs.put("employeeId", employee.getId());
		mapForDs.put("users", user);

		if(request.getParameter(COMMON_ID)!= null){
			int siteVitalsId = Integer.parseInt(request.getParameter(COMMON_ID));
			generalMap.put("siteVitalsId", siteVitalsId);
		}
		if(request.getParameter("projectId")!= null){
			int projectId = Integer.parseInt(request.getParameter("projectId"));
			generalMap.put("projectId", projectId);
		}

		if(request.getParameter(SITE_ID)!= null){
			int siteId = Integer.parseInt(request.getParameter(SITE_ID));
			generalMap.put("siteId", siteId);
		}
		if(request.getParameter(VITAL_ID)!= null){
			int vitalId = Integer.parseInt(request.getParameter(VITAL_ID));
			generalMap.put("vitalId", vitalId);
		}
		if(request.getParameter(PLANNED_DATE) !=null && !(request.getParameter(PLANNED_DATE).equals(""))) {
			String plannedDate =request.getParameter(PLANNED_DATE);
			generalMap.put("plannedDate", plannedDate);
		}
		if(!request.getParameter(CURRENCY_ID).equals("0")){
			int currencyId = Integer.parseInt(request.getParameter(CURRENCY_ID));
			generalMap.put("currencyId", currencyId);
		}
		if(request.getParameter(FLAG) != null){
			String flag = request.getParameter(FLAG);
			generalMap.put("flag", flag);
		}
		if(request.getParameter(AMOUNT_FLAG) != null){
			String amountFlag = request.getParameter(AMOUNT_FLAG);
			generalMap.put("amountFlag", amountFlag);
		}
		if(request.getParameter(PLANNED_REMARK) != null){
			String plannedRemark = request.getParameter(PLANNED_REMARK);
			generalMap.put("plannedRemark", plannedRemark);

		}

		if(request.getParameter(REVISED_DATE) !=null && !(request.getParameter(REVISED_DATE).equals(""))) {
			String revisedDate =request.getParameter(REVISED_DATE);
			generalMap.put("revisedDate", revisedDate);
		}

		if(request.getParameter(REVISED_REMARK) != null){
			String revisedRemark = request.getParameter(REVISED_REMARK);
			generalMap.put("revisedRemark", revisedRemark);
		}

		if(request.getParameter(ACTUAL_DATE) !=null && !(request.getParameter(ACTUAL_DATE).equals(""))) {
			String actualDate =request.getParameter(ACTUAL_DATE);
			generalMap.put("actualDate", actualDate);
		}

		if(request.getParameter(ACTUAL_REMARK) != null ){
			String actualRemark = request.getParameter(ACTUAL_REMARK);
			generalMap.put("actualRemark", actualRemark);
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			 String changedBy =request.getParameter(CHANGED_BY);
			 generalMap.put("changedBy", changedBy);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			Date currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			 generalMap.put("currentDate", currentDate);
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
		   String	currentTime =request.getParameter(CHANGED_TIME);
		   generalMap.put("currentTime", currentTime);
		}
		map = projectTrackingHandlerService.updateSiteVitals(generalMap);
		Map<String ,Object> newMap=commonMasterHandlerService.getUserButtonRights(mapForDs);
		List<UserButtonRights> userRightsList=(List<UserButtonRights>)newMap.get("userRightsList");
		map.put("userRightsList", userRightsList);
		String jsp = SITE_VITALS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	 return new ModelAndView("index", "map", map);
}
	public ModelAndView showSiteResourceMappingJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object> mapForDs=new HashMap<String,Object>();

		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user=(Users)session.getAttribute(USERS);
		MasEmployee employee= user.getEmployee();

		mapForDs.put("employeeId", employee.getId());
		mapForDs.put("users", user);

		int projectId = 0;
		if(request.getParameter(PROJECT_ID)!= null){
			projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
		}
		int siteId = 0;
		if(request.getParameter("siteId")!= null){
			siteId = Integer.parseInt(request.getParameter("siteId"));
		}
		map = projectTrackingHandlerService.showSiteResourceMappingJsp(projectId,siteId);

		Map<String ,Object> newMap=commonMasterHandlerService.getUserButtonRights(mapForDs);
		List<UserButtonRights> userRightsList=(List<UserButtonRights>)newMap.get("userRightsList");
		map.put("userRightsList", userRightsList);

		String jsp = SITE_RESOURCE_MAPPINF;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	 return new ModelAndView("index", "map", map);
}
	public ModelAndView getResourceListFromAjax(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		if(request.getParameter(PROJECT_ROLE_ID)!= null){
			int projectRoleId = Integer.parseInt(request.getParameter(PROJECT_ROLE_ID));
			generalMap.put("projectRoleId", projectRoleId);
		}
		if(request.getParameter(PROJECT_ID)!= null){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		map = projectTrackingHandlerService.getResourceListFromAjax(generalMap);
		return new ModelAndView("hr_responseForResourceMapping", "map", map);
	}
	public ModelAndView saveSiteResourceMapping(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String,Object> mapForDs=new HashMap<String,Object>();
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		int projectId = 0;
		int siteId = 0;
		Users user=(Users)session.getAttribute(USERS);
		MasEmployee employee= user.getEmployee();

		mapForDs.put("employeeId", employee.getId());
		mapForDs.put("users", user);

		if(request.getParameter(PROJECT_ROLE_ID)!= null){
			int projectRoleId = Integer.parseInt(request.getParameter(PROJECT_ROLE_ID));
			generalMap.put("projectRoleId", projectRoleId);
		}
		if(request.getParameter(PROJECT_ID)!= null){
			projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		if(request.getParameter(SITE_ID)!= null){
			siteId = Integer.parseInt(request.getParameter(SITE_ID));
			generalMap.put("siteId", siteId);
		}
		String[] selectedResourceList = {"0"};
		if(request.getParameterValues(EMPLOYEE_ID)!=null)
		{
			selectedResourceList = request.getParameterValues(EMPLOYEE_ID);
		}
		generalMap.put("selectedResourceList", selectedResourceList);
		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			 String changedBy =request.getParameter(CHANGED_BY);
			 generalMap.put("changedBy", changedBy);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			Date currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			 generalMap.put("currentDate", currentDate);
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
		   String	currentTime =request.getParameter(CHANGED_TIME);
		   generalMap.put("currentTime", currentTime);
		}
		map = projectTrackingHandlerService.saveSiteResourceMapping(generalMap);
		Map<String ,Object> newMap=commonMasterHandlerService.getUserButtonRights(mapForDs);
		List<UserButtonRights> userRightsList=(List<UserButtonRights>)newMap.get("userRightsList");
		map.put("userRightsList", userRightsList);
		//map = projectTrackingHandlerService.showSiteResourceMappingJsp(projectId,siteId);
		map = projectTrackingHandlerService.showSiteResourceMappingJsp(projectId,siteId);
		String jsp = SITE_RESOURCE_MAPPINF;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	 return new ModelAndView("index", "map", map);
}
	public ModelAndView showApprovalSettingJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = projectTrackingHandlerService.showApprovalSettingJsp();
		String jsp = APPROVAL_SETTING;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	 return new ModelAndView("index", "map", map);
}
	public ModelAndView showProjectApproval(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int projectId = 0;
		if(request.getParameter("projectId")!= null){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}
		map = projectTrackingHandlerService.showProjectApproval(projectId);
		String jsp = PROJECT_APPROVAL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	 return new ModelAndView("index", "map", map);
}
	public ModelAndView showProjectTrackingMenuJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		map = projectTrackingHandlerService.showProjectTrackingMenuJsp(users);
		String jsp = PROJECT_TRACKING_MENU_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	 return new ModelAndView("index", "map", map);
}
	public ModelAndView showSitesListForProjectTracking(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		generalMap.put("users", users);
		int projectId = 0;
		if(request.getParameter(PROJECT_ID)!= null){
		 projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
		 generalMap.put("projectId", projectId);
		}

		map = projectTrackingHandlerService.showSitesListForProjectTracking(generalMap);
		String jsp = PROJECT_TRACKING_MENU_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	 return new ModelAndView("index", "map", map);
}

	public ModelAndView showAddPatient(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int projectId = 0;
		if(request.getParameter(PROJECT_ID)!= null){
		 projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
		}
		int siteId = 0;
		if(request.getParameter("siteId")!= null){
			siteId = Integer.parseInt(request.getParameter("siteId"));
		}
		map = projectTrackingHandlerService.showAddPatient(projectId,siteId);
		String jsp = ADD_PATIENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	 return new ModelAndView("index", "map", map);
}

	public ModelAndView saveAddPatientDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		if(request.getParameter(PROJECT_ID)!= null){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		if(request.getParameter(SITE_ID)!= null){
			int siteId = Integer.parseInt(request.getParameter(SITE_ID));
			generalMap.put("siteId", siteId);
		}
		if(request.getParameter(ENROLLMENT_NO)!= null){
			String enrollmentNo = request.getParameter(ENROLLMENT_NO);
			generalMap.put("enrollmentNo", enrollmentNo);
		}
		if(request.getParameter(SCREENING_NO)!= null){
			String screeningNo = request.getParameter(SCREENING_NO);
			generalMap.put("screeningNo", screeningNo);
		}
		if(request.getParameter(RANDOMIZATION_NO)!= null){
			String randomizationNo = request.getParameter(RANDOMIZATION_NO);
			generalMap.put("randomizationNo", randomizationNo);
		}
		if(request.getParameter(PATIENT_INITIALS)!= null){
			String patientInititals = request.getParameter(PATIENT_INITIALS);
			generalMap.put("patientInititals", patientInititals);
		}
		if(request.getParameter(SCREENING_DATE)!= null){
			Date screeningDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(SCREENING_DATE));
			generalMap.put("screeningDate", screeningDate);
		}
		if(request.getParameter(RANDOMIZATION_DATE)!= null){
			Date randomizationdate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(RANDOMIZATION_DATE));
			generalMap.put("randomizationdate", randomizationdate);
		}
		if(request.getParameter(INITIALIZATION_DATE)!= null){
			Date initializationDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(INITIALIZATION_DATE));
			generalMap.put("initializationDate", initializationDate);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			String changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}

		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			String	currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		map =projectTrackingHandlerService.saveAddPatientDetails(generalMap);
		String jsp = ADD_PATIENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	 return new ModelAndView("index", "map", map);
}
	public ModelAndView showPatientSchedule(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int projectId = 0;
		if(request.getParameter(PROJECT_ID)!= null){
			projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		int siteId = 0;
		if(request.getParameter(SITE_ID)!= null){
			siteId = Integer.parseInt(request.getParameter(SITE_ID));
			generalMap.put("siteId", siteId);
		}
		int addPatientHeaderId = 0;
		if(request.getParameter(ADD_PATIENT_HEADER_ID)!= null){
			addPatientHeaderId = Integer.parseInt(request.getParameter(ADD_PATIENT_HEADER_ID));
			generalMap.put("addPatientHeaderId", addPatientHeaderId);
		}
		map = projectTrackingHandlerService.showPatientSchedule(generalMap);
		String jsp = ADD_PATIENT_SCHEDULE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	 return new ModelAndView("index", "map", map);
}

	public ModelAndView updateAddPatientSchedule(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List actualDateList =new ArrayList();
		List addPatientDetailIdList =new ArrayList();
		List variationList =new ArrayList();
		List statusList =new ArrayList();
		List commentList =new ArrayList();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String date = sdf.format(new Date());
		int projectId = 0;
		if(request.getParameter(PROJECT_ID)!= null){
			projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		int siteId = 0;
		if(request.getParameter(SITE_ID)!= null){
			siteId = Integer.parseInt(request.getParameter(SITE_ID));
			generalMap.put("siteId", siteId);
		}
		int addPatientHeaderId = 0;
		if(request.getParameter(ADD_PATIENT_HEADER_ID)!= null){
			addPatientHeaderId = Integer.parseInt(request.getParameter(ADD_PATIENT_HEADER_ID));
			generalMap.put("addPatientHeaderId", addPatientHeaderId);
		}
		int noOfSchedule = 0;
		if(request.getParameter("counter")!= null){
			noOfSchedule = Integer.parseInt(request.getParameter("counter"));
		}


		for(int j=0;j<noOfSchedule;j++)
		{
			if(request.getParameter(ADD_PATIENT_DETAIL_ID+j)!= null && !(request.getParameter(ADD_PATIENT_DETAIL_ID+j).equals(""))){
				addPatientDetailIdList.add(request.getParameter(ADD_PATIENT_DETAIL_ID+j));
			}
			if(request.getParameter(ACTUAL_DATE+j)!= null && !(request.getParameter(ACTUAL_DATE+j).equals(""))){
				actualDateList.add(request.getParameter(ACTUAL_DATE+j));
			}
			if(request.getParameter(VARIATION+j)!= null && !(request.getParameter(VARIATION+j).equals(""))){
				variationList.add(request.getParameter(VARIATION+j));
			}
			if(request.getParameter(STATUS+j)!= null && !(request.getParameter(STATUS+j).equals(""))){
				statusList.add(request.getParameter(STATUS+j));
			}
			if(request.getParameter(COMMENTS+j)!= null && !(request.getParameter(COMMENTS+j).equals(""))){
				commentList.add(request.getParameter(COMMENTS+j));
			}


		}

		generalMap.put("actualDateList", actualDateList);
		generalMap.put("variationList", variationList);
		generalMap.put("statusList", statusList);
		generalMap.put("commentList", commentList);
		generalMap.put("addPatientDetailIdList", addPatientDetailIdList);


		map = projectTrackingHandlerService.updateAddPatientSchedule(generalMap);
		String jsp = ADD_PATIENT_SCHEDULE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	 return new ModelAndView("index", "map", map);
}
	public ModelAndView ModifyPatientSchedule(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		 generalMap.put("users", users);
		}
		int projectId = 0;
		if(request.getParameter(PROJECT_ID)!= null){
		 projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
		 generalMap.put("projectId", projectId);
		}
		int siteId = 0;
		if(request.getParameter("siteId")!= null){
			siteId = Integer.parseInt(request.getParameter("siteId"));
			generalMap.put("siteId", siteId);
		}
		map = projectTrackingHandlerService.ModifyPatientSchedule(generalMap);
		String jsp = MODIFY_PATIENT_SCHEDULE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	 return new ModelAndView("index", "map", map);
}
	public ModelAndView saveModifyPatientSchedule(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int projectId = 0;
		if(request.getParameter(PROJECT_ID)!= null){
		 projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
		 generalMap.put("projectId", projectId);
		}
		int siteId = 0;
		if(request.getParameter(SITE_ID)!= null){
			siteId = Integer.parseInt(request.getParameter(SITE_ID));
			generalMap.put("siteId", siteId);
		}
		int addPatientHeaderId = 0;
		if(request.getParameter(ADD_PATIENT_HEADER_ID)!= null){
			addPatientHeaderId = Integer.parseInt(request.getParameter(ADD_PATIENT_HEADER_ID));
			generalMap.put("addPatientHeaderId", addPatientHeaderId);
		}
		map = projectTrackingHandlerService.saveModifyPatientSchedule(generalMap);
		String jsp = MODIFY_PATIENT_SCHEDULE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);	 return new ModelAndView("index", "map", map);
}
	public ModelAndView updateModifyPatientScheduleByPL(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List addPatientDetailIdList = new ArrayList();
		List revisedDateList = new ArrayList();
		int projectId = 0;
		if(request.getParameter(PROJECT_ID)!= null){
		 projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
		 generalMap.put("projectId", projectId);
		}
		int siteId = 0;
		if(request.getParameter(SITE_ID)!= null){
			siteId = Integer.parseInt(request.getParameter(SITE_ID));
			generalMap.put("siteId", siteId);
		}
		int addPatientHeaderId = 0;
		if(request.getParameter(ADD_PATIENT_HEADER_ID)!= null){
			addPatientHeaderId = Integer.parseInt(request.getParameter(ADD_PATIENT_HEADER_ID));
			generalMap.put("addPatientHeaderId", addPatientHeaderId);
		}
		int noOfSchedule = 0;
		if(request.getParameter("counter")!= null){
			noOfSchedule = Integer.parseInt(request.getParameter("counter"));
		}
		for(int j=0;j<noOfSchedule;j++)
		{
			if(request.getParameter(ADD_PATIENT_DETAIL_ID+j)!= null && !(request.getParameter(ADD_PATIENT_DETAIL_ID+j).equals(""))){
				addPatientDetailIdList.add(request.getParameter(ADD_PATIENT_DETAIL_ID+j));
			}
			if(request.getParameter(REVISED_DATE+j)!= null && !(request.getParameter(REVISED_DATE+j).equals(""))){
				revisedDateList.add(request.getParameter(REVISED_DATE+j));
			}
		}
		generalMap.put("addPatientDetailIdList", addPatientDetailIdList);
		generalMap.put("revisedDateList", revisedDateList);
		map= projectTrackingHandlerService.updateModifyPatientScheduleByPL(generalMap);
		String jsp = MODIFY_PATIENT_SCHEDULE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);	 return new ModelAndView("index", "map", map);
}
//===================================Code By Rajendra=================================================================//


	/**************************** Methods For Country Wise Patient JSP Start **********************************************/

	public ModelAndView showCountryWisePatientJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int projectId = 0;

		if(request.getParameter("projectId")!= null){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}
		map = projectTrackingHandlerService.showCountryWisePatientJsp(projectId);
		String jsp = COUNTRY_WISE_PATIENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addPatientRequired(HttpServletRequest request ,HttpServletResponse response) {
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url = "";
		int projectId = 0;
		int countryId = 0;
		int patientRequired =0;


		CntrReqPat cntrReqPat = new CntrReqPat();
		Map<String, Object> map =new HashMap<String, Object>();
		Map<String, Object> generalMap =new HashMap<String, Object>();


		session = request.getSession();

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}
		if(request.getParameter("projectId") !=null && !(request.getParameter("projectId").equals(""))){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		if(request.getParameter(COUNTRY) !=null && !(request.getParameter(COUNTRY).equals(""))) {
			countryId =Integer.parseInt(request.getParameter(COUNTRY));
		}

		if(request.getParameter(PATIENT_REQUIRED) !=null && !(request.getParameter(PATIENT_REQUIRED).equals(""))) {
			patientRequired =Integer.parseInt(request.getParameter(PATIENT_REQUIRED));
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		boolean successfullyAdded =false;
			if(projectId != 0){
			    MstrProject mstrProject = new MstrProject();
			    mstrProject.setId(projectId);
			    cntrReqPat.setPrj(mstrProject);
			}

			if(countryId != 0){
			    MasCountry masCountry =new MasCountry();
			    masCountry.setId(countryId);
			    cntrReqPat.setCountry(masCountry);
			}

			if(hospitalId != 0){
			    MasHospital masHospital =new MasHospital();
			    masHospital.setId(hospitalId);
			    cntrReqPat.setCompany(masHospital);
			}

		    cntrReqPat.setPatientRequired(patientRequired);
		    cntrReqPat.setStatus("y");
		    cntrReqPat.setLastChgBy(changedBy);
		    cntrReqPat.setLastChgDate(currentDate);
		    cntrReqPat.setLastChgTime(currentTime);

			successfullyAdded =projectTrackingHandlerService.addPatientRequired(cntrReqPat);

			if(successfullyAdded) {
				message ="Record Added Successfully  !!";
			}else {
				message ="Try Again  !!";
			}

			url = "hms/hrms/projectTracking?method=showCountryWisePatientJsp";
			try{
				map = projectTrackingHandlerService.showCountryWisePatientJsp(projectId);
			}catch(Exception e) {
				e.printStackTrace();
			}

			String jsp= COUNTRY_WISE_PATIENT_JSP;
			jsp += ".jsp";
			title = "Add Country Wise Patient";
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index" ,"map",map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editPatientRequired(HttpServletRequest request, HttpServletResponse response){
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url="";
		int countryPatientId = 0;
		int projectId = 0;
		int countryId = 0;
		int patientRequired =0;

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		CntrReqPat cntrReqPat =new CntrReqPat();

		session = request.getSession();

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			countryPatientId =Integer.parseInt( request.getParameter(COMMON_ID));
		}

		if(request.getParameter("projectId") !=null && !(request.getParameter("projectId").equals(""))){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		if(request.getParameter(COUNTRY) !=null && !(request.getParameter(COUNTRY).equals(""))) {
			countryId =Integer.parseInt(request.getParameter(COUNTRY));
		}

		if(request.getParameter(PATIENT_REQUIRED) !=null && !(request.getParameter(PATIENT_REQUIRED).equals(""))) {
			patientRequired =Integer.parseInt(request.getParameter(PATIENT_REQUIRED));
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		boolean successfullyUpdated =false;

		generalMap.put("id", countryPatientId);
		generalMap.put("countryId", countryId);
		generalMap.put("patientRequired", patientRequired);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		successfullyUpdated = projectTrackingHandlerService.editPatientRequired(generalMap);
		if(successfullyUpdated ==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}

		url = "hms/hrms/projectTracking?method=showCountryWisePatientJsp";
		try{
			map = projectTrackingHandlerService.showCountryWisePatientJsp(projectId);
		}catch(Exception e) {
			e.printStackTrace();
		}

		String jsp= COUNTRY_WISE_PATIENT_JSP;
		jsp += ".jsp";
		title = "Update Country Wise Patient";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index" ,"map",map);
	}

	public ModelAndView deletePatientRequired(HttpServletRequest request, HttpServletResponse response){
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		String message = "";
		String title="";
		String url ="";

		int countryPatientId = 0;
		int projectId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		CntrReqPat cntrReqPat =new CntrReqPat();

		session = request.getSession();

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			countryPatientId =Integer.parseInt( request.getParameter(COMMON_ID));
		}

		if(request.getParameter("projectId") != null && !(request.getParameter("projectId").equals(""))){
			projectId =Integer.parseInt( request.getParameter("projectId"));
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		boolean successfullyDeleted =false;

		generalMap.put("id", countryPatientId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		successfullyDeleted = projectTrackingHandlerService.deletePatientRequired(generalMap);
		if(successfullyDeleted ==true){
			message="Data deleted Successfully !!";
		}
		else{
			message="Data Cant be deleted !!";
		}

		url = "hms/hrms/projectTracking?method=showCountryWisePatientJsp";
		try{
			map = projectTrackingHandlerService.showCountryWisePatientJsp(projectId);
		}catch(Exception e) {
			e.printStackTrace();
		}

		String jsp= COUNTRY_WISE_PATIENT_JSP;
		jsp += ".jsp";
		title = "Delete Country Wise Patient";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index" ,"map",map);

	}


/**************************** Methods For Other Vitals JSP Start **********************************************/

	public ModelAndView showOtherVitalsJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int projectId = 0;

		if(request.getParameter("projectId")!= null){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}
		map = projectTrackingHandlerService.showOtherVitalsJsp(projectId);
		String jsp = OTHER_VITALS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addOtherVitals(HttpServletRequest request ,HttpServletResponse response) {
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url = "";
		int projectId = 0;
		String vitalDescription = "";
		String vitalValue = "";


		PrjOthervitals prjOthervitals = new PrjOthervitals();
		Map<String, Object> map =new HashMap<String, Object>();
		Map<String, Object> generalMap =new HashMap<String, Object>();


		session = request.getSession();

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}
		if(request.getParameter("projectId") !=null && !(request.getParameter("projectId").equals(""))){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		if(request.getParameter(VITAL_DESCRIPTION) !=null && !(request.getParameter(VITAL_DESCRIPTION).equals(""))) {
			vitalDescription =request.getParameter(VITAL_DESCRIPTION);
		}

		if(request.getParameter(VITAL_VALUE) !=null && !(request.getParameter(VITAL_VALUE).equals(""))) {
			vitalValue =request.getParameter(VITAL_VALUE);
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		boolean successfullyAdded =false;
			if(projectId != 0){
			    MstrProject mstrProject = new MstrProject();
			    mstrProject.setId(projectId);
			    prjOthervitals.setPrj(mstrProject);
			}

			if(hospitalId != 0){
			    MasHospital masHospital =new MasHospital();
			    masHospital.setId(hospitalId);
			    prjOthervitals.setCompany(masHospital);
			}

		    prjOthervitals.setOvtDesc(vitalDescription);
		    prjOthervitals.setOvtVal(vitalValue);
		    prjOthervitals.setStatus("y");
		    prjOthervitals.setLastChgBy(changedBy);
		    prjOthervitals.setLastChgDate(currentDate);
		    prjOthervitals.setLastChgTime(currentTime);

			successfullyAdded =projectTrackingHandlerService.addOtherVitals(prjOthervitals);

			if(successfullyAdded) {
				message ="Record Added Successfully  !!";
			}else {
				message ="Try Again  !!";
			}

			url = "hms/hrms/projectTracking?method=showOtherVitalsJsp";
			try{
				map = projectTrackingHandlerService.showOtherVitalsJsp(projectId);
			}catch(Exception e) {
				e.printStackTrace();
			}

			String jsp= OTHER_VITALS_JSP;
			jsp += ".jsp";
			title = "Add Other Vitals";
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index" ,"map",map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editOtherVitals(HttpServletRequest request, HttpServletResponse response){
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url="";
		int countryPatientId = 0;
		int projectId = 0;
		String vitalDescription ="";
		String vitalValue = "";

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		CntrReqPat cntrReqPat =new CntrReqPat();

		session = request.getSession();

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			countryPatientId =Integer.parseInt( request.getParameter(COMMON_ID));
		}

		if(request.getParameter("projectId") !=null && !(request.getParameter("projectId").equals(""))){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		if(request.getParameter(VITAL_DESCRIPTION) !=null && !(request.getParameter(VITAL_DESCRIPTION).equals(""))) {
			vitalDescription =request.getParameter(VITAL_DESCRIPTION);
		}

		if(request.getParameter(VITAL_VALUE) !=null && !(request.getParameter(VITAL_VALUE).equals(""))) {
			vitalValue = request.getParameter(VITAL_VALUE);
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		boolean successfullyUpdated =false;

		generalMap.put("id", countryPatientId);
		generalMap.put("vitalDescription", vitalDescription);
		generalMap.put("vitalValue", vitalValue);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		successfullyUpdated = projectTrackingHandlerService.editOtherVitals(generalMap);
		if(successfullyUpdated ==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}

		url = "hms/hrms/projectTracking?method=showOtherVitalsJsp";
		try{
			map = projectTrackingHandlerService.showOtherVitalsJsp(projectId);
		}catch(Exception e) {
			e.printStackTrace();
		}

		String jsp= OTHER_VITALS_JSP;
		jsp += ".jsp";
		title = "Update Other Vitals";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index" ,"map",map);
	}

	public ModelAndView deleteOtherVitals(HttpServletRequest request, HttpServletResponse response){
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		String message = "";
		String title="";
		String url ="";

		int otherVitalsId = 0;
		int projectId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		CntrReqPat cntrReqPat =new CntrReqPat();

		session = request.getSession();

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			otherVitalsId =Integer.parseInt( request.getParameter(COMMON_ID));
		}

		if(request.getParameter("projectId") != null && !(request.getParameter("projectId").equals(""))){
			projectId =Integer.parseInt( request.getParameter("projectId"));
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		boolean successfullyDeleted =false;

		generalMap.put("id", otherVitalsId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		successfullyDeleted = projectTrackingHandlerService.deleteOtherVitals(generalMap);
		if(successfullyDeleted ==true){
			message="Data deleted Successfully !!";
		}
		else{
			message="Data Cant be deleted !!";
		}

		url = "hms/hrms/projectTracking?method=showOtherVitalsJsp";
		try{
			map = projectTrackingHandlerService.showOtherVitalsJsp(projectId);
		}catch(Exception e) {
			e.printStackTrace();
		}

		String jsp= OTHER_VITALS_JSP;
		jsp += ".jsp";
		title = "Delete Other Vital";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index" ,"map",map);

	}

/**************************** Methods For Patient Visit Schedule JSP Start **********************************************/

	public ModelAndView showPatientVisitScheduleJsp(HttpServletRequest request ,HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		Map<String,Object> mapForDs=new HashMap<String,Object>();
		Map<String, Object> map = new HashMap<String, Object>();

		Users user=(Users)session.getAttribute(USERS);
		MasEmployee employee= user.getEmployee();

		mapForDs.put("employeeId", employee.getId());
		mapForDs.put("users", user);

		int projectId = 0;

		if(request.getParameter("projectId")!= null){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}
		map = projectTrackingHandlerService.showPatientVisitScheduleJsp(projectId);

		Map<String ,Object> newMap=commonMasterHandlerService.getUserButtonRights(mapForDs);
		List<UserButtonRights> userRightsList=(List<UserButtonRights>)newMap.get("userRightsList");
		map.put("userRightsList", userRightsList);

		String jsp = PATIENT_VISIT_SCHEDULE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addVendorContract(HttpServletRequest request ,HttpServletResponse response) {
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url = "";
		int projectId = 0;
		int vendorId = 0;
		int vendorServiceId = 0;
		Date contractDate = new Date();

		PrjVendorcontract prjVendorcontract = new PrjVendorcontract();
		Map<String, Object> map =new HashMap<String, Object>();
		Map<String, Object> generalMap =new HashMap<String, Object>();


		session = request.getSession();

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}
		if(request.getParameter("projectId") !=null && !(request.getParameter("projectId").equals(""))){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		if(request.getParameter(VENDOR_ID) !=null && !(request.getParameter(VENDOR_ID).equals(""))) {
			vendorId =Integer.parseInt(request.getParameter(VENDOR_ID));
		}

		if(request.getParameter(VENDOR_SERVICE) !=null && !(request.getParameter(VENDOR_SERVICE).equals(""))) {
			vendorServiceId =Integer.parseInt(request.getParameter(VENDOR_SERVICE));
		}

		if(request.getParameter(VENDOR_CONTRACT_DATE) !=null && !(request.getParameter(VENDOR_CONTRACT_DATE).equals(""))) {
			contractDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(VENDOR_CONTRACT_DATE));
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		boolean successfullyAdded =false;
			if(projectId != 0){
			    MstrProject mstrProject = new MstrProject();
			    mstrProject.setId(projectId);
			    prjVendorcontract.setPrj(mstrProject);
			}

			if(vendorId != 0){
				MstrVendor mstrVendor = new MstrVendor();
				mstrVendor.setId(vendorId);
				prjVendorcontract.setVendor(mstrVendor);
			}
			if(vendorServiceId != 0){
				VendorServiceType vendorServiceType = new VendorServiceType();
				vendorServiceType.setId(vendorServiceId);
				prjVendorcontract.setVendorServiceType(vendorServiceType);
			}
			if(hospitalId != 0){
			    MasHospital masHospital =new MasHospital();
			    masHospital.setId(hospitalId);
			    prjVendorcontract.setCompany(masHospital);
			}

			prjVendorcontract.setVcDate(contractDate);
			prjVendorcontract.setStatus("y");
			prjVendorcontract.setLastChgBy(changedBy);
			prjVendorcontract.setLastChgDate(currentDate);
			prjVendorcontract.setLastChgTime(currentTime);

			successfullyAdded =projectTrackingHandlerService.addVendorContract(prjVendorcontract);

			if(successfullyAdded) {
				message ="Record Added Successfully  !!";
			}else {
				message ="Try Again  !!";
			}

			url = "hms/hrms/projectTracking?method=showVendorContractJsp";
			try{
				map = projectTrackingHandlerService.showVendorContractJsp(projectId);
			}catch(Exception e) {
				e.printStackTrace();
			}

			String jsp= VENDOR_CONTRACT_JSP;
			jsp += ".jsp";
			title = "Add Vendor Contract";
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index" ,"map",map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editVendorContract(HttpServletRequest request, HttpServletResponse response){
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url="";
	    int vendorContractId = 0;
		int projectId = 0;
		int vendorId = 0;
		int vendorServiceId =0;
		Date contractDate = new Date();

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		CntrReqPat cntrReqPat =new CntrReqPat();

		session = request.getSession();

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			vendorContractId =Integer.parseInt( request.getParameter(COMMON_ID));
		}

		if(request.getParameter("projectId") !=null && !(request.getParameter("projectId").equals(""))){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		if(request.getParameter(VENDOR_ID) !=null && !(request.getParameter(VENDOR_ID).equals(""))){
			vendorId = Integer.parseInt(request.getParameter(VENDOR_ID));
		}
		if(request.getParameter(VENDOR_SERVICE) !=null && !(request.getParameter(VENDOR_SERVICE).equals(""))) {
			vendorServiceId =Integer.parseInt(request.getParameter(VENDOR_SERVICE));
		}

		if(request.getParameter(VENDOR_CONTRACT_DATE) !=null && !(request.getParameter(VENDOR_CONTRACT_DATE).equals(""))) {
			contractDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(VENDOR_CONTRACT_DATE));
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		boolean successfullyUpdated =false;

		generalMap.put("id", vendorContractId);
		generalMap.put("vendorId", vendorId);
		generalMap.put("vendorServiceId", vendorServiceId);
		generalMap.put("contractDate", contractDate);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		successfullyUpdated = projectTrackingHandlerService.editVendorContract(generalMap);
		if(successfullyUpdated ==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}

		url = "hms/hrms/projectTracking?method=showVendorContractJsp";
		try{
			map = projectTrackingHandlerService.showVendorContractJsp(projectId);
		}catch(Exception e) {
			e.printStackTrace();
		}

		String jsp= VENDOR_CONTRACT_JSP;
		jsp += ".jsp";
		title = "Update Vendor Contract";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index" ,"map",map);
	}

	public ModelAndView deleteVendorContract(HttpServletRequest request, HttpServletResponse response){
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		String message = "";
		String title="";
		String url ="";

		int vendorContractId = 0;
		int projectId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		CntrReqPat cntrReqPat =new CntrReqPat();

		session = request.getSession();

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			vendorContractId =Integer.parseInt( request.getParameter(COMMON_ID));
		}

		if(request.getParameter("projectId") != null && !(request.getParameter("projectId").equals(""))){
			projectId =Integer.parseInt( request.getParameter("projectId"));
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		boolean successfullyDeleted =false;

		generalMap.put("id", vendorContractId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		successfullyDeleted = projectTrackingHandlerService.deleteVendorContract(generalMap);
		if(successfullyDeleted ==true){
			message="Data deleted Successfully !!";
		}
		else{
			message="Data Cant be deleted !!";
		}

		url = "hms/hrms/projectTracking?method=showVendorContractJsp";
		try{
			map = projectTrackingHandlerService.showVendorContractJsp(projectId);
		}catch(Exception e) {
			e.printStackTrace();
		}

		String jsp= VENDOR_CONTRACT_JSP;
		jsp += ".jsp";
		title = "Delete Vendor Contract";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index" ,"map",map);

	}

/**************************** Methods For Vendor Contract JSP Start **********************************************/

	public ModelAndView showVendorContractJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int projectId = 0;

		if(request.getParameter("projectId")!= null){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}
		map = projectTrackingHandlerService.showVendorContractJsp(projectId);
		String jsp = VENDOR_CONTRACT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addPatientVisitSchedule(HttpServletRequest request ,HttpServletResponse response) {
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url = "";
		int projectId = 0;
		int patientVisitId = 0;
		int visitInterval = 0;
		int betweenVisit = 0;
		int entireSchedule =0;
		int visitTypeId = 0;

		PrjPatvisitsch prjPatvisitsch = new PrjPatvisitsch();
		Map<String, Object> map =new HashMap<String, Object>();
		Map<String, Object> generalMap =new HashMap<String, Object>();


		session = request.getSession();

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}
		if(request.getParameter("projectId") !=null && !(request.getParameter("projectId").equals(""))){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}
		if(request.getParameter(PATIENT_VISIT_TYPE) !=null && !(request.getParameter(PATIENT_VISIT_TYPE).equals(""))){
			visitTypeId = Integer.parseInt(request.getParameter(PATIENT_VISIT_TYPE));
		}

		if(request.getParameter(PATIENT_VISIT_NAME) !=null && !(request.getParameter(PATIENT_VISIT_NAME).equals(""))) {
			patientVisitId = Integer.parseInt(request.getParameter(PATIENT_VISIT_NAME));
		}

		if(request.getParameter(VISIT_INTERVAL) !=null && !(request.getParameter(VISIT_INTERVAL).equals(""))) {
			visitInterval =Integer.parseInt(request.getParameter(VISIT_INTERVAL));
		}

		if(request.getParameter(BETWEEN_VISIT) != null && !(request.getParameter(BETWEEN_VISIT).equals(""))){
			betweenVisit = Integer.parseInt(request.getParameter(BETWEEN_VISIT));
		}

		if(request.getParameter(ENTIRE_SCHEDULE) != null && !(request.getParameter(ENTIRE_SCHEDULE).equals(""))){
			entireSchedule = Integer.parseInt(request.getParameter(ENTIRE_SCHEDULE));
		}
		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		boolean successfullyAdded =false;
			if(projectId != 0){
			    MstrProject mstrProject = new MstrProject();
			    mstrProject.setId(projectId);
			    prjPatvisitsch.setPrj(mstrProject);
			}

			if(patientVisitId != 0){
				MstrPtvisit mstrPtvisit = new MstrPtvisit();
				mstrPtvisit.setId(patientVisitId);
				prjPatvisitsch.setPatientVisit(mstrPtvisit);
			}
			if(hospitalId != 0){
			    MasHospital masHospital =new MasHospital();
			    masHospital.setId(hospitalId);
			    prjPatvisitsch.setCompany(masHospital);
			}
			if(visitTypeId != 0){
				HrMasVisitType hrMasVisitType =new HrMasVisitType();
				hrMasVisitType.setId(visitTypeId);
				prjPatvisitsch.setVisitType(hrMasVisitType);
			}


			prjPatvisitsch.setPvInt(visitInterval);
			prjPatvisitsch.setBetweenVisit(betweenVisit);
			prjPatvisitsch.setEntireSchedule(entireSchedule);
			prjPatvisitsch.setStatus("y");
			prjPatvisitsch.setLastChgBy(changedBy);
			prjPatvisitsch.setLastChgDate(currentDate);
			prjPatvisitsch.setLastChgTime(currentTime);

			successfullyAdded =projectTrackingHandlerService.addPatientVisitSchedule(prjPatvisitsch);

			if(successfullyAdded) {
				message ="Record Added Successfully  !!";
			}else {
				message ="Try Again  !!";
			}

			url = "hms/hrms/projectTracking?method=showPatientVisitScheduleJsp";
			try{
				map = projectTrackingHandlerService.showPatientVisitScheduleJsp(projectId);
			}catch(Exception e) {
				e.printStackTrace();
			}

			String jsp= PATIENT_VISIT_SCHEDULE_JSP;
			jsp += ".jsp";
			title = "Add Patient Visit Schedule";
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index" ,"map",map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editPatientVisitSchedule(HttpServletRequest request, HttpServletResponse response){
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url="";
		int patientVisitScheduleId = 0;
		int projectId = 0;
		int patientVisitId = 0;
		int visitInterval = 0;
		int betweenVisit = 0;
		int entireSchedule = 0;
		int visitTypeId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		CntrReqPat cntrReqPat =new CntrReqPat();

		session = request.getSession();

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			patientVisitScheduleId =Integer.parseInt( request.getParameter(COMMON_ID));
		}

		if(request.getParameter("projectId") !=null && !(request.getParameter("projectId").equals(""))){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		if(request.getParameter(PATIENT_VISIT_TYPE) !=null && !(request.getParameter(PATIENT_VISIT_TYPE).equals(""))){
			visitTypeId = Integer.parseInt(request.getParameter(PATIENT_VISIT_TYPE));
		}

		if(request.getParameter(PATIENT_VISIT_NAME) !=null && !(request.getParameter(PATIENT_VISIT_NAME).equals(""))) {
			patientVisitId = Integer.parseInt(request.getParameter(PATIENT_VISIT_NAME));
		}

		if(request.getParameter(VISIT_INTERVAL) !=null && !(request.getParameter(VISIT_INTERVAL).equals(""))) {
			visitInterval = Integer.parseInt(request.getParameter(VISIT_INTERVAL));
		}

		if(request.getParameter(BETWEEN_VISIT) != null && !(request.getParameter(BETWEEN_VISIT).equals(""))){
			betweenVisit = Integer.parseInt(request.getParameter(BETWEEN_VISIT));
		}

		if(request.getParameter(ENTIRE_SCHEDULE) != null && !(request.getParameter(ENTIRE_SCHEDULE).equals(""))){
			entireSchedule = Integer.parseInt(request.getParameter(ENTIRE_SCHEDULE));
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		boolean successfullyUpdated =false;

		generalMap.put("id", patientVisitScheduleId);
		generalMap.put("patientVisitId", patientVisitId);
		generalMap.put("visitTypeId", visitTypeId);
		generalMap.put("visitInterval", visitInterval);
		generalMap.put("betweenVisit", betweenVisit);
		generalMap.put("entireSchedule", entireSchedule);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		successfullyUpdated = projectTrackingHandlerService.editPatientVisitSchedule(generalMap);
		if(successfullyUpdated ==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}

		url = "hms/hrms/projectTracking?method=showPatientVisitScheduleJsp";
		try{
			map = projectTrackingHandlerService.showPatientVisitScheduleJsp(projectId);
		}catch(Exception e) {
			e.printStackTrace();
		}

		String jsp= PATIENT_VISIT_SCHEDULE_JSP;
		jsp += ".jsp";
		title = "Update Patient Visit Schedule";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index" ,"map",map);
	}


	public ModelAndView deletePatientVisitSchedule(HttpServletRequest request, HttpServletResponse response){
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		String message = "";
		String title="";
		String url ="";

		int patientVisitScheduleId = 0;
		int projectId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		CntrReqPat cntrReqPat =new CntrReqPat();

		session = request.getSession();

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			patientVisitScheduleId =Integer.parseInt( request.getParameter(COMMON_ID));
		}

		if(request.getParameter("projectId") != null && !(request.getParameter("projectId").equals(""))){
			projectId =Integer.parseInt( request.getParameter("projectId"));
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		boolean successfullyDeleted =false;

		generalMap.put("id", patientVisitScheduleId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		successfullyDeleted = projectTrackingHandlerService.deletePatientVisitSchedule(generalMap);
		if(successfullyDeleted ==true){
			message="Data deleted Successfully !!";
		}
		else{
			message="Data Cant be deleted !!";
		}

		url = "hms/hrms/projectTracking?method=showPatientVisitScheduleJsp";
		try{
			map = projectTrackingHandlerService.showPatientVisitScheduleJsp(projectId);
		}catch(Exception e) {
			e.printStackTrace();
		}

		String jsp= PATIENT_VISIT_SCHEDULE_JSP;
		jsp += ".jsp";
		title = "Delete Patient Visit Schedule";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index" ,"map",map);
	}



	/**************************** Methods For Project Vitals JSP Start **********************************************/

	public ModelAndView showAddProjectVitals(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int projectId = 0;

		if(request.getParameter("projectId")!= null){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}
		map = projectTrackingHandlerService.showAddProjectVitals(projectId);
		String jsp = ADD_PROJECT_VITALS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}


	@SuppressWarnings("unchecked")
	public ModelAndView addProjectVital(HttpServletRequest request ,HttpServletResponse response) {
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url = "";
		int projectId = 0;
		int vitalId = 0;
		String plannedDate   = "";
		String remarkOne   = "";
		String revisedDate   = "";
		String remarkTwo   = "";
		String actualDate    = "";
		String remarkThree = "";

		ProjectVitals projectVitals = new ProjectVitals();
		Map<String, Object> map =new HashMap<String, Object>();
		Map<String, Object> generalMap =new HashMap<String, Object>();


		session = request.getSession();

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}
		if(request.getParameter("projectId") !=null && !(request.getParameter("projectId").equals(""))){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		if(request.getParameter(VITAL_ID) !=null && !(request.getParameter(VITAL_ID).equals(""))) {
			vitalId =Integer.parseInt(request.getParameter(VITAL_ID));
		}
		int currencyId = 0;
		if(request.getParameter(CURRENCY_ID) !=null && !(request.getParameter(CURRENCY_ID).equals("0"))) {
			currencyId = Integer.parseInt(request.getParameter(CURRENCY_ID));
			MasCurrency masCurrency = new MasCurrency();
			masCurrency.setId(currencyId);
			projectVitals.setCurrency(masCurrency);
		}
		String flag = "";
		if(request.getParameter(FLAG) != null){
			 flag = request.getParameter(FLAG);
			projectVitals.setFlag(flag);
		}


		String amountFlag = "";
		if(request.getParameter("amountFlag") != null){
			 amountFlag = request.getParameter("amountFlag");
			projectVitals.setAmountFlag(amountFlag);
		}


		if(request.getParameter(PLANNED_DATE) !=null && !(request.getParameter(PLANNED_DATE).equals(""))) {
			plannedDate =request.getParameter(PLANNED_DATE);
		}

		if(request.getParameter(REMARK_ONE) != null && !(request.getParameter(REMARK_ONE).equals(""))){
			remarkOne = request.getParameter(REMARK_ONE);
		}

		if(request.getParameter(REVISED_DATE) !=null && !(request.getParameter(REVISED_DATE).equals(""))) {
			revisedDate =request.getParameter(REVISED_DATE);
		}

		if(request.getParameter(REMARK_TWO) != null && !(request.getParameter(REMARK_TWO).equals(""))){
			remarkTwo = request.getParameter(REMARK_TWO);
		}

		if(request.getParameter(ACTUAL_DATE) !=null && !(request.getParameter(ACTUAL_DATE).equals(""))) {
			actualDate =request.getParameter(ACTUAL_DATE);
		}

		if(request.getParameter(REMARK_THREE) != null && !(request.getParameter(REMARK_THREE).equals(""))){
			remarkThree = request.getParameter(REMARK_THREE);
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		boolean successfullyAdded =false;
			if(projectId != 0){
			    MstrProject mstrProject = new MstrProject();
			    mstrProject.setId(projectId);
			    projectVitals.setPrj(mstrProject);
			}
			if(vitalId != 0){
				MstrVitals mstrVitals = new MstrVitals();
				mstrVitals.setId(vitalId);
				projectVitals.setVital(mstrVitals);
			}

			if(hospitalId != 0){
			    MasHospital masHospital =new MasHospital();
			    masHospital.setId(hospitalId);
			    projectVitals.setCompany(masHospital);
			}
			if(flag.equals("D")){
				projectVitals.setPlannedDate(HMSUtil.convertStringTypeDateToDateType(plannedDate));
				projectVitals.setRevisedDate(HMSUtil.convertStringTypeDateToDateType(revisedDate));
				projectVitals.setActualDate(HMSUtil.convertStringTypeDateToDateType(actualDate));
			}else if(flag.equals("V")){
				if(amountFlag.equals("yes")){
					projectVitals.setPlannedValue(new BigDecimal(plannedDate));
					projectVitals.setRevisedValue(new BigDecimal(revisedDate));
					projectVitals.setActualValue(new BigDecimal(actualDate));
					MasCurrency masCurrency = new MasCurrency();
					masCurrency.setId(currencyId);
					projectVitals.setCurrency(masCurrency);
				}else if(amountFlag.equals("no")){
					projectVitals.setPlannedValue(new BigDecimal(plannedDate));
					projectVitals.setRevisedValue(new BigDecimal(revisedDate));
					projectVitals.setActualValue(new BigDecimal(actualDate));
				}
			}


			projectVitals.setRemarkOne(remarkOne);
			projectVitals.setRemarkTwo(remarkTwo);
			projectVitals.setRemarkThree(remarkThree);
			projectVitals.setStatus("y");
			projectVitals.setLastChgBy(changedBy);
			projectVitals.setLastChgDate(currentDate);
			projectVitals.setLastChgTime(currentTime);

			successfullyAdded =projectTrackingHandlerService.addProjectVital(projectVitals);

			if(successfullyAdded) {
				message ="Record Added Successfully  !!";
			}else {
				message ="Try Again  !!";
			}

			url = "hms/hrms/projectTracking?method=showAddProjectVitals";
			try{
				map = projectTrackingHandlerService.showAddProjectVitals(projectId);
			}catch(Exception e) {
				e.printStackTrace();
			}

			String jsp= ADD_PROJECT_VITALS_JSP;
			jsp += ".jsp";
			title = "Add Project Vitals";
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index" ,"map",map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editProjectVital(HttpServletRequest request, HttpServletResponse response){
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url = "";
		int projectId = 0;
		int vitalId = 0;
		int projectVitalId = 0;
		String plannedDate   = "";
		String remarkOne   = "";
		String revisedDate   = "";
		String remarkTwo   = "";
		String actualDate    = "";
		String remarkThree = "";


		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		CntrReqPat cntrReqPat =new CntrReqPat();

		session = request.getSession();

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			projectVitalId =Integer.parseInt( request.getParameter(COMMON_ID));
		}

		if(request.getParameter("projectId") !=null && !(request.getParameter("projectId").equals(""))){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		if(request.getParameter(VITAL_ID) !=null && !(request.getParameter(VITAL_ID).equals(""))) {
			vitalId =Integer.parseInt(request.getParameter(VITAL_ID));
		}

		int currencyId = 0;
		if(request.getParameter(CURRENCY_ID) !=null && !(request.getParameter(CURRENCY_ID).equals("0"))) {
			currencyId = Integer.parseInt(request.getParameter(CURRENCY_ID));
			generalMap.put("currencyId", currencyId);
		}
		String flag = "";
		if(request.getParameter(FLAG) != null){
			 flag = request.getParameter(FLAG);
			 generalMap.put("flag", flag);
		}


		String amountFlag = "";
		if(request.getParameter("amountFlag") != null){
			 amountFlag = request.getParameter("amountFlag");
			 generalMap.put("amountFlag", amountFlag);
		}


		if(request.getParameter(PLANNED_DATE) !=null && !(request.getParameter(PLANNED_DATE).equals(""))) {
			plannedDate =request.getParameter(PLANNED_DATE);
		}

		if(request.getParameter(REMARK_ONE) != null && !(request.getParameter(REMARK_ONE).equals(""))){
			remarkOne = request.getParameter(REMARK_ONE);
		}

		if(request.getParameter(REVISED_DATE) !=null && !(request.getParameter(REVISED_DATE).equals(""))) {
			revisedDate =request.getParameter(REVISED_DATE);
		}

		if(request.getParameter(REMARK_TWO) != null && !(request.getParameter(REMARK_TWO).equals(""))){
			remarkTwo = request.getParameter(REMARK_TWO);
		}

		if(request.getParameter(ACTUAL_DATE) !=null && !(request.getParameter(ACTUAL_DATE).equals(""))) {
			actualDate =request.getParameter(ACTUAL_DATE);
		}

		if(request.getParameter(REMARK_THREE) != null && !(request.getParameter(REMARK_THREE).equals(""))){
			remarkThree = request.getParameter(REMARK_THREE);
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		boolean successfullyUpdated =false;

		generalMap.put("id", projectVitalId);
		generalMap.put("vitalId", vitalId);
		generalMap.put("plannedDate", plannedDate);
		generalMap.put("remarkOne", remarkOne);
		generalMap.put("revisedDate", revisedDate);
		generalMap.put("remarkTwo", remarkTwo);
		generalMap.put("actualDate", actualDate);
		generalMap.put("remarkThree", remarkThree);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		successfullyUpdated = projectTrackingHandlerService.editProjectVital(generalMap);
		if(successfullyUpdated ==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}

		url = "hms/hrms/projectTracking?method=showAddProjectVitals";
		try{
			map = projectTrackingHandlerService.showAddProjectVitals(projectId);
		}catch(Exception e) {
			e.printStackTrace();
		}

		String jsp= ADD_PROJECT_VITALS_JSP;
		jsp += ".jsp";
		title = "Update Project Vital";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index" ,"map",map);
	}

	public ModelAndView deleteProjectVital(HttpServletRequest request, HttpServletResponse response){
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		String message = "";
		String title="";
		String url ="";

		int projectVitalId = 0;
		int projectId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		CntrReqPat cntrReqPat =new CntrReqPat();

		session = request.getSession();

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			projectVitalId =Integer.parseInt( request.getParameter(COMMON_ID));
		}

		if(request.getParameter("projectId") != null && !(request.getParameter("projectId").equals(""))){
			projectId =Integer.parseInt( request.getParameter("projectId"));
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		boolean successfullyDeleted =false;

		generalMap.put("id", projectVitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		successfullyDeleted = projectTrackingHandlerService.deleteProjectVital(generalMap);
		if(successfullyDeleted ==true){
			message="Data deleted Successfully !!";
		}
		else{
			message="Data Cant be deleted !!";
		}

		url = "hms/hrms/projectTracking?method=showAddProjectVitals";
		try{
			map = projectTrackingHandlerService.showAddProjectVitals(projectId);
		}catch(Exception e) {
			e.printStackTrace();
		}

		String jsp= ADD_PROJECT_VITALS_JSP;
		jsp += ".jsp";
		title = "Delete Project Vital";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index" ,"map",map);

	}

/**************************** Methods For Regulatory Submission JSP Start **********************************************/

	public ModelAndView showRegulatorSubmissionJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int projectId = 0;

		if(request.getParameter("projectId")!= null){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		map = projectTrackingHandlerService.showRegulatorSubmissionJsp(projectId);
		String jsp = REGULATORY_SUBMISSION_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView displayAttachment(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int regulatorySubId = 0;
		if(request.getParameter(COMMON_ID)!= null){
			regulatorySubId = Integer.parseInt(request.getParameter(COMMON_ID));
		}

		map = projectTrackingHandlerService.displayAttachment(regulatorySubId);
		String jsp = ATTACH_REGULATORY_SUB_DOC_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView AttachReglSubDocFile(HttpServletRequest request ,HttpServletResponse response) {
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int hospitalId =0;
		int projectId = 0;
		int regulatorySubId = 0;

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MultipartFormDataRequest mrequest = null;


		session = request.getSession();

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}
		if (MultipartFormDataRequest.isMultipartFormData(request))
		   {
				try
				{
					mrequest = new MultipartFormDataRequest(request);
				}
				catch (UploadException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
		   }

		if(mrequest.getParameter("projectId") != null && !(mrequest.getParameter("projectId").equals(""))){
			projectId =Integer.parseInt( mrequest.getParameter("projectId"));
		}

		if(mrequest.getParameter("regulatorySubId") != null && !(mrequest.getParameter("regulatorySubId").equals(""))){
			regulatorySubId =Integer.parseInt( mrequest.getParameter("regulatorySubId"));
		}

		if(mrequest.getParameter(CHANGED_BY) !=null && !(mrequest.getParameter(CHANGED_BY).equals(""))) {
			changedBy =mrequest.getParameter(CHANGED_BY);
		}
		if(mrequest.getParameter(CHANGED_DATE) !=null && !(mrequest.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(mrequest.getParameter(CHANGED_DATE));
		}
		if(mrequest.getParameter(CHANGED_TIME) !=null && !(mrequest.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =mrequest.getParameter(CHANGED_TIME);
		}
		generalMap.put("projectId", projectId);
		generalMap.put("regulatorySubId", regulatorySubId);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);


		String fileExtension=null;
		String uploadURL = getServletContext().getRealPath("/ProjectDocuments/");
		String filename = "";
		List fileUploadedList = null;
			if(request.getParameter("filename")!= null){
				filename = request.getParameter("filename");
			}
			generalMap.put("filename", filename);
			StringTokenizer strToken=new StringTokenizer(filename,".");

			filename=strToken.nextToken();
		   	fileExtension=strToken.nextToken();
		   	String whiteList = "*."+fileExtension;
		   	try{
		   		fileUploadedList = HMSUtil.uploadTicketFile(mrequest,uploadURL, whiteList,filename);
		   	}
		   	catch (Exception e) {
			e.printStackTrace();
			}
			String comments = "";
			if( mrequest.getParameter(REGULATORY_DOC_COMMENTS)!= null){
				comments = mrequest.getParameter(REGULATORY_DOC_COMMENTS);
				generalMap.put("comments", comments);
			}

			generalMap.put("uploadURL", uploadURL);


		map = projectTrackingHandlerService.AttachReglSubDocFile(generalMap);
		String jsp = ATTACH_REGULATORY_SUB_DOC_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteAttachReglSubDocFile(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List uploadFileNameList = new ArrayList();
		List regulatorySubDocIdList = new ArrayList();

		MultipartFormDataRequest mrequest = null;
		if (MultipartFormDataRequest.isMultipartFormData(request))
		   {
				try
				{
					mrequest = new MultipartFormDataRequest(request);
				}
				catch (UploadException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
		   }
		int noOfFiles = 0;
		int regulatorySubId = 0;
		if(mrequest.getParameter("counter")!= null){
			noOfFiles = Integer.parseInt(mrequest.getParameter("counter"));
		}

		if(mrequest.getParameter("regulatorySubId") != null && !(mrequest.getParameter("regulatorySubId").equals(""))){
			regulatorySubId =Integer.parseInt( mrequest.getParameter("regulatorySubId"));
		}

		for(int j=0;j<noOfFiles;j++)
		{
			if (mrequest.getParameter(REGULATORY_SUB_DOC_ID+j)!= null && !(mrequest.getParameter(REGULATORY_SUB_DOC_ID+j).equals(""))) {
				regulatorySubDocIdList .add(Integer.parseInt(mrequest.getParameter(REGULATORY_SUB_DOC_ID+j)));
			}

		}
		generalMap.put("regulatorySubId", regulatorySubId);
		generalMap.put("regulatorySubDocIdList", regulatorySubDocIdList);
		generalMap.put("uploadFileNameList", uploadFileNameList);

		map = projectTrackingHandlerService.deleteAttachReglSubDocFile(generalMap);
		String jsp = ATTACH_REGULATORY_SUB_DOC_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}


	@SuppressWarnings("unchecked")
	public ModelAndView addRegulatorySubmission(HttpServletRequest request, HttpServletResponse response){
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url = "";
		int projectId = 0;
		int vitalId = 0;
		int projectVitalId = 0;
		Date submissionDate = null;
		Date approvalDate   = null;
		int regulatoryStatusId = 0;
		String regulatoryComments = "";
		int docTypeId = 0;
		String referenceCode = "";
		String[] documentIds = new String[0];
		String remarks = "";

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		PrjReglSub prjreglSub = new PrjReglSub();

		session = request.getSession();

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}


		if(request.getParameter("projectId") !=null && !(request.getParameter("projectId").equals(""))){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		if(request.getParameter(SUBMISSION_DATE) !=null && !(request.getParameter(SUBMISSION_DATE).equals(""))) {
			submissionDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(SUBMISSION_DATE));
		}

		if(request.getParameter(APPROVAL_DATE) !=null && !(request.getParameter(APPROVAL_DATE).equals(""))) {
			approvalDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(APPROVAL_DATE));
		}

		if(request.getParameter(REGULATORY_STATUST_ID) !=null && !(request.getParameter(REGULATORY_STATUST_ID).equals(""))){
			regulatoryStatusId = Integer.parseInt(request.getParameter(REGULATORY_STATUST_ID));
		}

		if(request.getParameter(REGULATORY_COMMENTS) != null && !(request.getParameter(REGULATORY_COMMENTS).equals(""))){
			regulatoryComments = request.getParameter(REGULATORY_COMMENTS);
		}

		if(request.getParameter(DOCUMENT_TYPE_ID) !=null && !(request.getParameter(DOCUMENT_TYPE_ID).equals(""))){
			docTypeId = Integer.parseInt(request.getParameter(DOCUMENT_TYPE_ID));
		}

		if(request.getParameter(REFERENCE_CODE) != null && !(request.getParameter(REFERENCE_CODE).equals(""))){
			referenceCode = request.getParameter(REFERENCE_CODE);
		}

		if(request.getParameter(DOCUMENT_ID) !=null && !(request.getParameter(DOCUMENT_ID).equals(""))){
			documentIds = request.getParameterValues(DOCUMENT_ID);
		}

		if(request.getParameter(REMARKS) != null && !(request.getParameter(REMARKS).equals(""))){
			remarks = request.getParameter(REMARKS);
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}


		prjreglSub.setSubDate(submissionDate);
		prjreglSub.setApprDate(approvalDate);

		if(projectId != 0){
			MstrProject mstrProject = new MstrProject();
			mstrProject.setId(projectId);
			prjreglSub.setPrj(mstrProject);
		}
		if(regulatoryStatusId !=0){
			MstrRegulatoryStatus mstrRegulatoryStatus = new MstrRegulatoryStatus();
			mstrRegulatoryStatus.setId(regulatoryStatusId);
			prjreglSub.setRegulatoryStatus(mstrRegulatoryStatus);
		}
		prjreglSub.setComments(regulatoryComments);

		if(docTypeId != 0){
			MstrDoctype mstrDoctype = new MstrDoctype();
			mstrDoctype.setId(docTypeId);
			prjreglSub.setDocType(mstrDoctype);
		}
		prjreglSub.setReferenceCode(referenceCode);

		Set<MstrDocument> documentSet = new HashSet<MstrDocument>();
		for(String docId : documentIds){
			if(!docId.equals("")){
				MstrDocument document = new MstrDocument();
				document.setId(Integer.parseInt(docId));
				documentSet.add(document);
			}
		}
		prjreglSub.setDoc(documentSet);

		prjreglSub.setRemark(remarks);

		if(hospitalId != 0){
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			prjreglSub.setCompany(masHospital);
		}
		prjreglSub.setStatus("y");
		prjreglSub.setLastChgBy(changedBy);
		prjreglSub.setLastChgDate(currentDate);
		prjreglSub.setLastChgTime(currentTime);

		boolean successfullyAdded =projectTrackingHandlerService.addRegulatorySubmission(prjreglSub);

		if(successfullyAdded) {
			message ="Record Added Successfully  !!";
		}else {
			message ="Try Again  !!";
		}

		url = "hms/hrms/projectTracking?method=showRegulatorSubmissionJsp";
		try{
			map = projectTrackingHandlerService.showRegulatorSubmissionJsp(projectId);
		}catch(Exception e) {
			e.printStackTrace();
		}

		String jsp= REGULATORY_SUBMISSION_JSP;
		jsp += ".jsp";
		title = "Add Regulatory Submission";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index" ,"map",map);
	}


	@SuppressWarnings("unchecked")
	public ModelAndView editRegulatorySubmission(HttpServletRequest request, HttpServletResponse response){
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url = "";

		int regulatorySubId =0;
		int projectId = 0;
		Date submissionDate = null;
		Date approvalDate   = null;
		int regulatoryStatusId = 0;
		String regulatoryComments = "";
		int docTypeId = 0;
		String referenceCode = "";
		String[] documentIds = new String[0];
		String remarks = "";

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		PrjReglSub prjreglSub = new PrjReglSub();

		session = request.getSession();

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}

		if(request.getParameter(COMMON_ID) !=null && !(request.getParameter(COMMON_ID).equals(""))){
			regulatorySubId = Integer.parseInt(request.getParameter(COMMON_ID));
		}

		if(request.getParameter("projectId") !=null && !(request.getParameter("projectId").equals(""))){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		if(request.getParameter(SUBMISSION_DATE) !=null && !(request.getParameter(SUBMISSION_DATE).equals(""))) {
			submissionDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(SUBMISSION_DATE));
		}

		if(request.getParameter(APPROVAL_DATE) !=null && !(request.getParameter(APPROVAL_DATE).equals(""))) {
			approvalDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(APPROVAL_DATE));
		}

		if(request.getParameter(REGULATORY_STATUST_ID) !=null && !(request.getParameter(REGULATORY_STATUST_ID).equals(""))){
			regulatoryStatusId = Integer.parseInt(request.getParameter(REGULATORY_STATUST_ID));
		}

		if(request.getParameter(REGULATORY_COMMENTS) != null && !(request.getParameter(REGULATORY_COMMENTS).equals(""))){
			regulatoryComments = request.getParameter(REGULATORY_COMMENTS);
		}

		if(request.getParameter(DOCUMENT_TYPE_ID) !=null && !(request.getParameter(DOCUMENT_TYPE_ID).equals(""))){
			docTypeId = Integer.parseInt(request.getParameter(DOCUMENT_TYPE_ID));
		}

		if(request.getParameter(REFERENCE_CODE) != null && !(request.getParameter(REFERENCE_CODE).equals(""))){
			referenceCode = request.getParameter(REFERENCE_CODE);
		}

		if(request.getParameter(DOCUMENT_ID) !=null && !(request.getParameter(DOCUMENT_ID).equals(""))){
			documentIds = request.getParameterValues(DOCUMENT_ID);
		}

		if(request.getParameter(REMARKS) != null && !(request.getParameter(REMARKS).equals(""))){
			remarks = request.getParameter(REMARKS);
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		generalMap.put("id", regulatorySubId);
		generalMap.put("submissionDate", submissionDate);
		generalMap.put("approvalDate", approvalDate);
		generalMap.put("regulatoryStatusId", regulatoryStatusId);
		generalMap.put("regulatoryComments", regulatoryComments);
		generalMap.put("docTypeId", docTypeId);
		generalMap.put("referenceCode", referenceCode);
		generalMap.put("documentIds", documentIds);
		generalMap.put("remarks", remarks);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		boolean successfullyAdded =projectTrackingHandlerService.editRegulatorySubmission(generalMap);

		if(successfullyAdded) {
			message ="Record Updated Successfully  !!";
		}else {
			message ="Try Again  !!";
		}

		url = "hms/hrms/projectTracking?method=showRegulatorSubmissionJsp";
		try{
			map = projectTrackingHandlerService.showRegulatorSubmissionJsp(projectId);
		}catch(Exception e) {
			e.printStackTrace();
		}

		String jsp= REGULATORY_SUBMISSION_JSP;
		jsp += ".jsp";
		title = "Update Regulatory Submission";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index" ,"map",map);
	}


/**************************** Methods For Query Entry JSP Start **********************************************/

	public ModelAndView showQueryEntryJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int projectId = 0;

		if(request.getParameter("projectId")!= null){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		map = projectTrackingHandlerService.showQueryEntryJsp(projectId);
		String jsp = QUERY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
		}


	public ModelAndView displayQueryEntryAttachment(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int queryEntryId = 0;
		if(request.getParameter(COMMON_ID)!= null){
			queryEntryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}

		map = projectTrackingHandlerService.displayQueryEntryAttachment(queryEntryId);
		String jsp = ATTACH_QUERY_ENTRY_DOC_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}



	@SuppressWarnings("unchecked")
	public ModelAndView addQueryEntry(HttpServletRequest request, HttpServletResponse response){
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url = "";

		int projectId = 0;
		int regulatorySubId = 0;
		Date queryDate = null;
		Date plannedAnsDate = null;
		String queryDescription = "";
		String referenceCode = "";
		String queryCode = "";

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		PrjQueryEntry prjQueryEntry = new PrjQueryEntry();

		session = request.getSession();

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}

		if(request.getParameter("projectId") !=null && !(request.getParameter("projectId").equals(""))){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		if(request.getParameter("referenceCode") !=null && !(request.getParameter("referenceCode").equals(""))){
			referenceCode = request.getParameter("referenceCode");
		}

		if(request.getParameter(REGULATORY_SUB_ID) != null && !(request.getParameter(REGULATORY_SUB_ID).equals(""))){
			regulatorySubId = Integer.parseInt(request.getParameter(REGULATORY_SUB_ID));
		}


		if(request.getParameter(QUERY_DATE) !=null && !(request.getParameter(QUERY_DATE).equals(""))) {
			queryDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(QUERY_DATE));
		}

		if(request.getParameter(PLANNED_ANS_DATE) !=null && !(request.getParameter(PLANNED_ANS_DATE).equals(""))) {
			plannedAnsDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(PLANNED_ANS_DATE));
		}


		if(request.getParameter(QUERY_DESCRIPTION) != null && !(request.getParameter(QUERY_DESCRIPTION).equals(""))){
			queryDescription = request.getParameter(QUERY_DESCRIPTION);
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		queryCode = "QRY" + projectId + referenceCode;

		if(projectId != 0){
			MstrProject mstrProject = new MstrProject();
			mstrProject.setId(projectId);
			prjQueryEntry.setProject(mstrProject);
		}

		if(regulatorySubId != 0){
			PrjReglSub prjreglSub = new PrjReglSub();
			prjreglSub.setId(regulatorySubId);
			prjQueryEntry.setReglSub(prjreglSub);
		}

		prjQueryEntry.setQueryCode(queryCode);
		prjQueryEntry.setQueryDate(queryDate);
		prjQueryEntry.setPlannedAnsDate(plannedAnsDate);


		prjQueryEntry.setQueryDesc(queryDescription);


		if(hospitalId != 0){
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			prjQueryEntry.setCompany(masHospital);
		}
		prjQueryEntry.setStatus("y");
		prjQueryEntry.setLastChgBy(changedBy);
		prjQueryEntry.setLastChgDate(currentDate);
		prjQueryEntry.setLastChgTime(currentTime);

		boolean successfullyAdded =projectTrackingHandlerService.addQueryEntry(prjQueryEntry);

		if(successfullyAdded) {
			message ="Record Added Successfully  !!";
		}else {
			message ="Try Again  !!";
		}

		url = "hms/hrms/projectTracking?method=showQueryEntryJsp";
		try{
			map = projectTrackingHandlerService.showQueryEntryJsp(projectId);
		}catch(Exception e) {
			e.printStackTrace();
		}

		String jsp= QUERY_ENTRY_JSP;
		jsp += ".jsp";
		title = "Add Query Entry";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index" ,"map",map);
	}




	@SuppressWarnings("unchecked")
	public ModelAndView editQueryEntry(HttpServletRequest request, HttpServletResponse response){
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url = "";

		int queryEntryId = 0;
		int projectId = 0;
		int regulatorySubId = 0;
		Date queryDate = null;
		Date plannedAnsDate = null;
		String queryDescription = "";


		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		PrjReglSub prjreglSub = new PrjReglSub();

		session = request.getSession();

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}

		if(request.getParameter(COMMON_ID) !=null && !(request.getParameter(COMMON_ID).equals(""))){
			queryEntryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}

		if(request.getParameter("projectId") !=null && !(request.getParameter("projectId").equals(""))){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		if(request.getParameter(REGULATORY_SUB_ID) != null && !(request.getParameter(REGULATORY_SUB_ID).equals(""))){
			regulatorySubId = Integer.parseInt(request.getParameter(REGULATORY_SUB_ID));
		}

		if(request.getParameter(QUERY_DATE) !=null && !(request.getParameter(QUERY_DATE).equals(""))) {
			queryDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(QUERY_DATE));
		}

		if(request.getParameter(PLANNED_ANS_DATE) !=null && !(request.getParameter(PLANNED_ANS_DATE).equals(""))) {
			plannedAnsDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(PLANNED_ANS_DATE));
		}


		if(request.getParameter(QUERY_DESCRIPTION) != null && !(request.getParameter(QUERY_DESCRIPTION).equals(""))){
			queryDescription = request.getParameter(QUERY_DESCRIPTION);
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		generalMap.put("id", queryEntryId);
		generalMap.put("regulatorySubId", regulatorySubId);
		generalMap.put("queryDate", queryDate);
		generalMap.put("plannedAnsDate", plannedAnsDate);
		generalMap.put("queryDescription", queryDescription);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		boolean successfullyAdded =projectTrackingHandlerService.editQueryEntry(generalMap);

		if(successfullyAdded) {
			message ="Record Updated Successfully  !!";
		}else {
			message ="Try Again  !!";
		}

		url = "hms/hrms/projectTracking?method=showQueryEntryJsp";
		try{
			map = projectTrackingHandlerService.showQueryEntryJsp(projectId);
		}catch(Exception e) {
			e.printStackTrace();
		}

		String jsp= QUERY_ENTRY_JSP;
		jsp += ".jsp";
		title = "Update Query Entry";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index" ,"map",map);
	}


	public ModelAndView attachQueryEntryDocFile(HttpServletRequest request ,HttpServletResponse response) {
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;

		int hospitalId =0;
		int projectId = 0;
		int queryEntryId = 0;
		String filename = "";
		String queryEntryDocComments = "";

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MultipartFormDataRequest mrequest = null;


		session = request.getSession();

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}
		if (MultipartFormDataRequest.isMultipartFormData(request))
		   {
				try
				{
					mrequest = new MultipartFormDataRequest(request);
				}
				catch (UploadException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
		   }

		if(mrequest.getParameter("projectId") != null && !(mrequest.getParameter("projectId").equals(""))){
			projectId =Integer.parseInt( mrequest.getParameter("projectId"));
		}

		if(mrequest.getParameter("queryEntryId") != null && !(mrequest.getParameter("queryEntryId").equals(""))){
			queryEntryId =Integer.parseInt( mrequest.getParameter("queryEntryId"));
		}

		if(mrequest.getParameter(CHANGED_BY) !=null && !(mrequest.getParameter(CHANGED_BY).equals(""))) {
			changedBy =mrequest.getParameter(CHANGED_BY);
		}
		if(mrequest.getParameter(CHANGED_DATE) !=null && !(mrequest.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(mrequest.getParameter(CHANGED_DATE));
		}
		if(mrequest.getParameter(CHANGED_TIME) !=null && !(mrequest.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =mrequest.getParameter(CHANGED_TIME);
		}
		generalMap.put("projectId", projectId);
		generalMap.put("queryEntryId", queryEntryId);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);


		String fileExtension=null;
		String uploadURL = getServletContext().getRealPath("/ProjectDocuments/");

		List fileUploadedList = null;
			if(request.getParameter("filename")!= null){
				filename = request.getParameter("filename");
			}
			generalMap.put("filename", filename);
			StringTokenizer strToken=new StringTokenizer(filename,".");

			filename=strToken.nextToken();
		   	fileExtension=strToken.nextToken();
		   	String whiteList = "*."+fileExtension;
		   	try{
		   		fileUploadedList = HMSUtil.uploadTicketFile(mrequest,uploadURL, whiteList,filename);
		   	}
		   	catch (Exception e) {
			e.printStackTrace();
			}

			if( mrequest.getParameter(QUERY_ENTRY_DOC_COMMENTS)!= null){
				queryEntryDocComments = mrequest.getParameter(QUERY_ENTRY_DOC_COMMENTS);
				generalMap.put("queryEntryDocComments", queryEntryDocComments);
			}

			generalMap.put("uploadURL", uploadURL);


		map = projectTrackingHandlerService.attachQueryEntryDocFile(generalMap);
		String jsp = ATTACH_QUERY_ENTRY_DOC_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}


	public ModelAndView deleteAttachQueryEntryDocFile(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List queryEntryDocIdList = new ArrayList();
		int noOfFiles = 0;
		int queryEntryId = 0;

		MultipartFormDataRequest mrequest = null;
		if (MultipartFormDataRequest.isMultipartFormData(request))
		   {
				try
				{
					mrequest = new MultipartFormDataRequest(request);
				}
				catch (UploadException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
		   }

		if(mrequest.getParameter("counter")!= null){
			noOfFiles = Integer.parseInt(mrequest.getParameter("counter"));
		}

		if(mrequest.getParameter("queryEntryId") != null && !(mrequest.getParameter("queryEntryId").equals(""))){
			queryEntryId =Integer.parseInt( mrequest.getParameter("queryEntryId"));
		}

		for(int j=0;j<noOfFiles;j++)
		{
			if (mrequest.getParameter(QUERY_ENTRY_DOC_ID+j)!= null && !(mrequest.getParameter(QUERY_ENTRY_DOC_ID+j).equals(""))) {
				queryEntryDocIdList .add(Integer.parseInt(mrequest.getParameter(QUERY_ENTRY_DOC_ID+j)));
			}

		}
		generalMap.put("queryEntryId", queryEntryId);
		generalMap.put("queryEntryDocIdList", queryEntryDocIdList);

		map = projectTrackingHandlerService.deleteAttachQueryEntryDocFile(generalMap);
		String jsp = ATTACH_QUERY_ENTRY_DOC_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

/**************************** Methods For Ans Entry JSP Start **********************************************/

	public ModelAndView showAnsEntryJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int projectId = 0;

		if(request.getParameter("projectId")!= null){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		map = projectTrackingHandlerService.showAnsEntryJsp(projectId);
		String jsp = ANS_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
		}

	public ModelAndView displayAnsEntryAttachment(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int ansEntryId = 0;
		if(request.getParameter(COMMON_ID)!= null){
			ansEntryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}

		map = projectTrackingHandlerService.displayAnsEntryAttachment(ansEntryId);
		String jsp = ATTACH_ANS_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}


	@SuppressWarnings("unchecked")
	public ModelAndView addAnsEntry(HttpServletRequest request, HttpServletResponse response){
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url = "";

		int projectId = 0;
		int queryEntryId = 0;
		Date actualAnsDate    = null;
		Date plannedFlwDate   = null;
		String ansDescription = "";
		String queryCode = "";
		String ansCode = "";

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		PrjAnsEntry prjAnsEntry = new PrjAnsEntry();

		session = request.getSession();

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}

		if(request.getParameter("projectId") !=null && !(request.getParameter("projectId").equals(""))){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		if(request.getParameter("queryCode") !=null && !(request.getParameter("queryCode").equals(""))){
			queryCode = request.getParameter("queryCode");
		}

		if(request.getParameter(QUERY_ENTRY_ID) != null && !(request.getParameter(QUERY_ENTRY_ID).equals(""))){
			queryEntryId = Integer.parseInt(request.getParameter(QUERY_ENTRY_ID));
		}


		if(request.getParameter(ACTUAL_ANS_DATE) !=null && !(request.getParameter(ACTUAL_ANS_DATE).equals(""))) {
			actualAnsDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(ACTUAL_ANS_DATE));
		}


		if(request.getParameter(PLANNED_FLW_DATE) !=null && !(request.getParameter(PLANNED_FLW_DATE).equals(""))) {
			plannedFlwDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(PLANNED_FLW_DATE));
		}

		if(request.getParameter(ANS_DESCRIPTION) != null && !(request.getParameter(ANS_DESCRIPTION).equals(""))){
			ansDescription = request.getParameter(ANS_DESCRIPTION);
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		ansCode = queryCode + "ANS";

		if(projectId != 0){
			MstrProject mstrProject = new MstrProject();
			mstrProject.setId(projectId);
			prjAnsEntry.setProject(mstrProject);
		}

		if(queryEntryId != 0){
			PrjQueryEntry prjQueryEntry = new PrjQueryEntry();
			prjQueryEntry.setId(queryEntryId);
			prjAnsEntry.setQueryEntry(prjQueryEntry);
		}

		prjAnsEntry.setAnsCode(ansCode);
		prjAnsEntry.setActualAnsDate(actualAnsDate);
		prjAnsEntry.setPlannedFlwDate(plannedFlwDate);
		prjAnsEntry.setAnsDescription(ansDescription);

		if(hospitalId != 0){
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			prjAnsEntry.setCompany(masHospital);
		}
		prjAnsEntry.setStatus("y");
		prjAnsEntry.setLastChgBy(changedBy);
		prjAnsEntry.setLastChgDate(currentDate);
		prjAnsEntry.setLastChgTime(currentTime);

		boolean successfullyAdded =projectTrackingHandlerService.addAnsEntry(prjAnsEntry);

		if(successfullyAdded) {
			message ="Record Added Successfully  !!";
		}else {
			message ="Try Again  !!";
		}

		url = "hms/hrms/projectTracking?method=showAnsEntryJsp";
		try{
			map = projectTrackingHandlerService.showAnsEntryJsp(projectId);
		}catch(Exception e) {
			e.printStackTrace();
		}

		String jsp= ANS_ENTRY_JSP;
		jsp += ".jsp";
		title = "Add Answer Entry";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index" ,"map",map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editAnsEntry(HttpServletRequest request, HttpServletResponse response){
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url = "";

		int ansEntryId = 0;
		int projectId = 0;
		int queryEntryId = 0;
		Date actualAnsDate    = null;
		Date plannedFlwDate   = null;
		String ansDescription = "";

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		PrjReglSub prjreglSub = new PrjReglSub();

		session = request.getSession();

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}

		if(request.getParameter(COMMON_ID) !=null && !(request.getParameter(COMMON_ID).equals(""))){
			ansEntryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}


		if(request.getParameter("projectId") !=null && !(request.getParameter("projectId").equals(""))){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		if(request.getParameter(QUERY_ENTRY_ID) != null && !(request.getParameter(QUERY_ENTRY_ID).equals(""))){
			queryEntryId = Integer.parseInt(request.getParameter(QUERY_ENTRY_ID));
		}

		if(request.getParameter(ACTUAL_ANS_DATE) !=null && !(request.getParameter(ACTUAL_ANS_DATE).equals(""))) {
			actualAnsDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(ACTUAL_ANS_DATE));
		}

		if(request.getParameter(PLANNED_FLW_DATE) !=null && !(request.getParameter(PLANNED_FLW_DATE).equals(""))) {
			plannedFlwDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(PLANNED_FLW_DATE));
		}

		if(request.getParameter(ANS_DESCRIPTION) != null && !(request.getParameter(ANS_DESCRIPTION).equals(""))){
			ansDescription = request.getParameter(ANS_DESCRIPTION);
		}
		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		generalMap.put("id", ansEntryId);
		generalMap.put("queryEntryId", queryEntryId);
		generalMap.put("actualAnsDate", actualAnsDate);
		generalMap.put("plannedFlwDate", plannedFlwDate);
		generalMap.put("ansDescription", ansDescription);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		boolean successfullyAdded =projectTrackingHandlerService.editAnsEntry(generalMap);

		if(successfullyAdded) {
			message ="Record Updated Successfully  !!";
		}else {
			message ="Try Again  !!";
		}

		url = "hms/hrms/projectTracking?method=showAnsEntryJsp";
		try{
			map = projectTrackingHandlerService.showAnsEntryJsp(projectId);
		}catch(Exception e) {
			e.printStackTrace();
		}

		String jsp= ANS_ENTRY_JSP;
		jsp += ".jsp";
		title = "Update Answer Entry";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index" ,"map",map);
	}

	public ModelAndView attachAnsEntryDocFile(HttpServletRequest request ,HttpServletResponse response) {
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;

		int hospitalId =0;
		int projectId = 0;
		int ansEntryId = 0;
		String filename = "";
		String ansEntryDocComments = "";

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MultipartFormDataRequest mrequest = null;


		session = request.getSession();

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}
		if (MultipartFormDataRequest.isMultipartFormData(request))
		   {
				try
				{
					mrequest = new MultipartFormDataRequest(request);
				}
				catch (UploadException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
		   }

		if(mrequest.getParameter("projectId") != null && !(mrequest.getParameter("projectId").equals(""))){
			projectId =Integer.parseInt( mrequest.getParameter("projectId"));
		}

		if(mrequest.getParameter("ansEntryId") != null && !(mrequest.getParameter("ansEntryId").equals(""))){
			ansEntryId =Integer.parseInt( mrequest.getParameter("ansEntryId"));
		}

		if(mrequest.getParameter(CHANGED_BY) !=null && !(mrequest.getParameter(CHANGED_BY).equals(""))) {
			changedBy =mrequest.getParameter(CHANGED_BY);
		}
		if(mrequest.getParameter(CHANGED_DATE) !=null && !(mrequest.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(mrequest.getParameter(CHANGED_DATE));
		}
		if(mrequest.getParameter(CHANGED_TIME) !=null && !(mrequest.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =mrequest.getParameter(CHANGED_TIME);
		}
		generalMap.put("projectId", projectId);
		generalMap.put("ansEntryId", ansEntryId);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);


		String fileExtension=null;
		String uploadURL = getServletContext().getRealPath("/ProjectDocuments/");

		List fileUploadedList = null;
			if(request.getParameter("filename")!= null){
				filename = request.getParameter("filename");
			}
			generalMap.put("filename", filename);
			StringTokenizer strToken=new StringTokenizer(filename,".");

			filename=strToken.nextToken();
		   	fileExtension=strToken.nextToken();
		   	String whiteList = "*."+fileExtension;
		   	try{
		   		fileUploadedList = HMSUtil.uploadTicketFile(mrequest,uploadURL, whiteList,filename);
		   	}
		   	catch (Exception e) {
			e.printStackTrace();
			}

			if( mrequest.getParameter(ANS_ENTRY_DOC_COMMENTS)!= null){
				ansEntryDocComments = mrequest.getParameter(ANS_ENTRY_DOC_COMMENTS);
				generalMap.put("ansEntryDocComments", ansEntryDocComments);
			}

			generalMap.put("uploadURL", uploadURL);


		map = projectTrackingHandlerService.attachAnsEntryDocFile(generalMap);
		String jsp = ATTACH_ANS_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteAttachAnsEntryDocFile(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		List ansEntryDocIdList = new ArrayList();
		int noOfFiles = 0;
		int ansEntryId = 0;

		MultipartFormDataRequest mrequest = null;
		if (MultipartFormDataRequest.isMultipartFormData(request))
		   {
				try
				{
					mrequest = new MultipartFormDataRequest(request);
				}
				catch (UploadException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
		   }

		if(mrequest.getParameter("counter")!= null){
			noOfFiles = Integer.parseInt(mrequest.getParameter("counter"));
		}

		if(mrequest.getParameter("ansEntryId") != null && !(mrequest.getParameter("ansEntryId").equals(""))){
			ansEntryId =Integer.parseInt( mrequest.getParameter("ansEntryId"));
		}

		for(int j=0;j<noOfFiles;j++)
		{
			if (mrequest.getParameter(ANS_ENTRY_DOC_ID+j)!= null && !(mrequest.getParameter(ANS_ENTRY_DOC_ID+j).equals(""))) {
				ansEntryDocIdList .add(Integer.parseInt(mrequest.getParameter(ANS_ENTRY_DOC_ID+j)));
			}

		}
		generalMap.put("ansEntryId", ansEntryId);
		generalMap.put("ansEntryDocIdList", ansEntryDocIdList);

		map = projectTrackingHandlerService.deleteAttachAnsEntryDocFile(generalMap);
		String jsp = ATTACH_ANS_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

/**************************** Methods For Query Flw Entry JSP Start **********************************************/

	public ModelAndView showQueryFlwEntryJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int projectId = 0;

		if(request.getParameter("projectId")!= null){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		map = projectTrackingHandlerService.showQueryFlwEntryJsp(projectId);
		String jsp = QUERY_FLW_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
		}

	public ModelAndView displayQueryFlwEntryAttachment(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int queryFlwEntryId = 0;
		if(request.getParameter(COMMON_ID)!= null){
			queryFlwEntryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}

		map = projectTrackingHandlerService.displayQueryFlwEntryAttachment(queryFlwEntryId);
		String jsp = ATTACH_QUERY_FLW_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addQueryFlwEntry(HttpServletRequest request, HttpServletResponse response){
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url = "";

		int projectId = 0;
		int queryEntryId = 0;
		int ansEntryId = 0;
		int queryStatusId =0;
		Date actualFlwDate    = null;
		Date nextFlwDate   = null;
		String queryFlwComments = "";


		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		PrjQueryFlwEntry prjQueryFlwEntry = new PrjQueryFlwEntry();

		session = request.getSession();

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}

		if(request.getParameter("projectId") !=null && !(request.getParameter("projectId").equals(""))){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		if(request.getParameter(QUERY_ENTRY_ID) != null && !(request.getParameter(QUERY_ENTRY_ID).equals(""))){
			queryEntryId = Integer.parseInt(request.getParameter(QUERY_ENTRY_ID));
		}

		if(request.getParameter(ANS_ENTRY_ID) != null && !(request.getParameter(ANS_ENTRY_ID).equals(""))){
			ansEntryId = Integer.parseInt(request.getParameter(ANS_ENTRY_ID));
		}

		if(request.getParameter(QUERY_STATUS_ID) != null && !(request.getParameter(QUERY_STATUS_ID).equals(""))){
			queryStatusId = Integer.parseInt(request.getParameter(QUERY_STATUS_ID));
		}

		if(request.getParameter(ACTUAL_FLW_DATE) !=null && !(request.getParameter(ACTUAL_FLW_DATE).equals(""))) {
			actualFlwDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(ACTUAL_FLW_DATE));
		}


		if(request.getParameter(NEXT_FLW_DATE) !=null && !(request.getParameter(NEXT_FLW_DATE).equals(""))) {
			nextFlwDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(NEXT_FLW_DATE));
		}

		if(request.getParameter(QUERY_FLW_COMMENTS) != null && !(request.getParameter(QUERY_FLW_COMMENTS).equals(""))){
			queryFlwComments = request.getParameter(QUERY_FLW_COMMENTS);
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}



		if(projectId != 0){
			MstrProject mstrProject = new MstrProject();
			mstrProject.setId(projectId);
			prjQueryFlwEntry.setProject(mstrProject);
		}

		if(queryEntryId != 0){
			PrjQueryEntry prjQueryEntry = new PrjQueryEntry();
			prjQueryEntry.setId(queryEntryId);
			prjQueryFlwEntry.setQueryEntry(prjQueryEntry);
		}

		if(ansEntryId != 0){
			PrjAnsEntry prjAnsEntry = new PrjAnsEntry();
			prjAnsEntry.setId(ansEntryId);
			prjQueryFlwEntry.setAnsEntry(prjAnsEntry);
		}

		if(queryStatusId != 0){
			MstrQueryStatus mstrQueryStatus = new MstrQueryStatus();
			mstrQueryStatus.setId(queryStatusId);
			prjQueryFlwEntry.setQueryStatus(mstrQueryStatus);
		}
		prjQueryFlwEntry.setActualFlwDate(actualFlwDate);
		prjQueryFlwEntry.setNextFlwDate(nextFlwDate);
		prjQueryFlwEntry.setQueryFlwComments(queryFlwComments);

		if(hospitalId != 0){
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			prjQueryFlwEntry.setCompany(masHospital);
		}
		prjQueryFlwEntry.setStatus("y");
		prjQueryFlwEntry.setLastChgBy(changedBy);
		prjQueryFlwEntry.setLastChgDate(currentDate);
		prjQueryFlwEntry.setLastChgTime(currentTime);

		boolean successfullyAdded =projectTrackingHandlerService.addQueryFlwEntry(prjQueryFlwEntry);

		if(successfullyAdded) {
			message ="Record Added Successfully  !!";
		}else {
			message ="Try Again  !!";
		}

		url = "hms/hrms/projectTracking?method=showQueryFlwEntryJsp";
		try{
			map = projectTrackingHandlerService.showQueryFlwEntryJsp(projectId);
		}catch(Exception e) {
			e.printStackTrace();
		}

		String jsp= QUERY_FLW_ENTRY_JSP;
		jsp += ".jsp";
		title = "Add Query Follow Up Entry";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index" ,"map",map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editQueryFlwEntry(HttpServletRequest request, HttpServletResponse response){
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url = "";

		int queryFlwEntryId = 0;
		int projectId = 0;
		int queryEntryId = 0;
		int ansEntryId = 0;
		int queryStatusId =0;
		Date actualFlwDate    = null;
		Date nextFlwDate   = null;
		String queryFlwComments = "";

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		PrjReglSub prjreglSub = new PrjReglSub();

		session = request.getSession();

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}

		if(request.getParameter(COMMON_ID) !=null && !(request.getParameter(COMMON_ID).equals(""))){
			queryFlwEntryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}


		if(request.getParameter("projectId") !=null && !(request.getParameter("projectId").equals(""))){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		if(request.getParameter(QUERY_ENTRY_ID) != null && !(request.getParameter(QUERY_ENTRY_ID).equals(""))){
			queryEntryId = Integer.parseInt(request.getParameter(QUERY_ENTRY_ID));
		}

		if(request.getParameter(ANS_ENTRY_ID) != null && !(request.getParameter(ANS_ENTRY_ID).equals(""))){
			ansEntryId = Integer.parseInt(request.getParameter(ANS_ENTRY_ID));
		}

		if(request.getParameter(QUERY_STATUS_ID) != null && !(request.getParameter(QUERY_STATUS_ID).equals(""))){
			queryStatusId = Integer.parseInt(request.getParameter(QUERY_STATUS_ID));
		}

		if(request.getParameter(ACTUAL_FLW_DATE) !=null && !(request.getParameter(ACTUAL_FLW_DATE).equals(""))) {
			actualFlwDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(ACTUAL_FLW_DATE));
		}


		if(request.getParameter(NEXT_FLW_DATE) !=null && !(request.getParameter(NEXT_FLW_DATE).equals(""))) {
			nextFlwDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(NEXT_FLW_DATE));
		}

		if(request.getParameter(QUERY_FLW_COMMENTS) != null && !(request.getParameter(QUERY_FLW_COMMENTS).equals(""))){
			queryFlwComments = request.getParameter(QUERY_FLW_COMMENTS);
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		generalMap.put("id", queryFlwEntryId);
		generalMap.put("queryEntryId", queryEntryId);
		generalMap.put("ansEntryId", ansEntryId);
		generalMap.put("queryStatusId", queryStatusId);
		generalMap.put("actualFlwDate", actualFlwDate);
		generalMap.put("nextFlwDate", nextFlwDate);
		generalMap.put("queryFlwComments", queryFlwComments);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		boolean successfullyAdded =projectTrackingHandlerService.editQueryFlwEntry(generalMap);

		if(successfullyAdded) {
			message ="Record Updated Successfully  !!";
		}else {
			message ="Try Again  !!";
		}

		url = "hms/hrms/projectTracking?method=showQueryFlwEntryJsp";
		try{
			map = projectTrackingHandlerService.showQueryFlwEntryJsp(projectId);
		}catch(Exception e) {
			e.printStackTrace();
		}

		String jsp= QUERY_FLW_ENTRY_JSP;
		jsp += ".jsp";
		title = "Update Query Follow Up Entry";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index" ,"map",map);
	}


	public ModelAndView attachQueryFlwEntryDocFile(HttpServletRequest request ,HttpServletResponse response) {
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;

		int hospitalId =0;
		int projectId = 0;
		int queryFlwEntryId = 0;
		String filename = "";
		String queryFlwEntryComments = "";

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MultipartFormDataRequest mrequest = null;


		session = request.getSession();

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}
		if (MultipartFormDataRequest.isMultipartFormData(request))
		   {
				try
				{
					mrequest = new MultipartFormDataRequest(request);
				}
				catch (UploadException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
		   }

		if(mrequest.getParameter("projectId") != null && !(mrequest.getParameter("projectId").equals(""))){
			projectId =Integer.parseInt( mrequest.getParameter("projectId"));
		}

		if(mrequest.getParameter("queryFlwEntryId") != null && !(mrequest.getParameter("queryFlwEntryId").equals(""))){
			queryFlwEntryId =Integer.parseInt( mrequest.getParameter("queryFlwEntryId"));
		}

		if(mrequest.getParameter(CHANGED_BY) !=null && !(mrequest.getParameter(CHANGED_BY).equals(""))) {
			changedBy =mrequest.getParameter(CHANGED_BY);
		}
		if(mrequest.getParameter(CHANGED_DATE) !=null && !(mrequest.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(mrequest.getParameter(CHANGED_DATE));
		}
		if(mrequest.getParameter(CHANGED_TIME) !=null && !(mrequest.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =mrequest.getParameter(CHANGED_TIME);
		}
		generalMap.put("projectId", projectId);
		generalMap.put("queryFlwEntryId", queryFlwEntryId);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);


		String fileExtension=null;
		String uploadURL = getServletContext().getRealPath("/ProjectDocuments/");

		List fileUploadedList = null;
			if(request.getParameter("filename")!= null){
				filename = request.getParameter("filename");
			}
			generalMap.put("filename", filename);
			StringTokenizer strToken=new StringTokenizer(filename,".");

			filename=strToken.nextToken();
		   	fileExtension=strToken.nextToken();
		   	String whiteList = "*."+fileExtension;
		   	try{
		   		fileUploadedList = HMSUtil.uploadTicketFile(mrequest,uploadURL, whiteList,filename);
		   	}
		   	catch (Exception e) {
			e.printStackTrace();
			}

			if( mrequest.getParameter(QUERY_FLW_ENTRY_DOC_COMMENTS)!= null){
				queryFlwEntryComments = mrequest.getParameter(QUERY_FLW_ENTRY_DOC_COMMENTS);
				generalMap.put("queryFlwEntryComments", queryFlwEntryComments);
			}

			generalMap.put("uploadURL", uploadURL);


		map = projectTrackingHandlerService.attachQueryFlwEntryDocFile(generalMap);
		String jsp = ATTACH_QUERY_FLW_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}


	public ModelAndView deleteAttachQueryFlwEntryDocFile(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		List queryFlwEntryDocIdList = new ArrayList();
		int noOfFiles = 0;
		int queryFlwEntryId = 0;

		MultipartFormDataRequest mrequest = null;
		if (MultipartFormDataRequest.isMultipartFormData(request))
		   {
				try
				{
					mrequest = new MultipartFormDataRequest(request);
				}
				catch (UploadException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
		   }

		if(mrequest.getParameter("counter")!= null){
			noOfFiles = Integer.parseInt(mrequest.getParameter("counter"));
		}

		if(mrequest.getParameter("queryFlwEntryId") != null && !(mrequest.getParameter("queryFlwEntryId").equals(""))){
			queryFlwEntryId =Integer.parseInt( mrequest.getParameter("queryFlwEntryId"));
		}

		for(int j=0;j<noOfFiles;j++)
		{
			if (mrequest.getParameter(QUERY_FLW_ENTRY_DOC_ID+j)!= null && !(mrequest.getParameter(QUERY_FLW_ENTRY_DOC_ID+j).equals(""))) {
				queryFlwEntryDocIdList .add(Integer.parseInt(mrequest.getParameter(QUERY_FLW_ENTRY_DOC_ID+j)));
			}

		}
		generalMap.put("queryFlwEntryId", queryFlwEntryId);
		generalMap.put("queryFlwEntryDocIdList", queryFlwEntryDocIdList);

		map = projectTrackingHandlerService.deleteAttachQueryFlwEntryDocFile(generalMap);
		String jsp = ATTACH_QUERY_FLW_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

/**************************** Methods For SQ Approval JSP Start **********************************************/

	public ModelAndView showSQApprovalStatus(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int projectId = 0;

		if(request.getParameter("projectId")!= null){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		map = projectTrackingHandlerService.showSQApprovalStatus(projectId);
		String jsp = HR_SQ_APPROVAL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
		}


	@SuppressWarnings("unchecked")
	public ModelAndView updateSQApprovalStatus(HttpServletRequest request, HttpServletResponse response){
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url = "";

		Users currentUser =null;
		int currentUserId=0;

		int feasibilityStudyId = 0;
		int projectId = 0;
		String sqApprovalStatus = "";
		Date sqApprovalDate = null;
		String sqApprovalComments = "";


		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		PrjReglSub prjreglSub = new PrjReglSub();

		session = request.getSession();

		if(session.getAttribute("users") !=null) {
			currentUser =(Users)session.getAttribute("users");
			currentUserId =currentUser.getEmployee().getId();
		}

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}

		if(request.getParameter(COMMON_ID) !=null && !(request.getParameter(COMMON_ID).equals(""))){
			feasibilityStudyId = Integer.parseInt(request.getParameter(COMMON_ID));
		}

		if(request.getParameter("projectId") !=null && !(request.getParameter("projectId").equals(""))){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		if(request.getParameter(SQ_APPROVAL_STATUS) != null && !(request.getParameter(SQ_APPROVAL_STATUS).equals(""))){
			sqApprovalStatus = request.getParameter(SQ_APPROVAL_STATUS);
		}

		if(request.getParameter(SQ_APPROVAL_DATE) !=null && !(request.getParameter(SQ_APPROVAL_DATE).equals(""))) {
			sqApprovalDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(SQ_APPROVAL_DATE));
		}

		if(request.getParameter(SQ_APPROVAL_COMMENTS) != null && !(request.getParameter(SQ_APPROVAL_COMMENTS).equals(""))){
			sqApprovalComments = request.getParameter(SQ_APPROVAL_COMMENTS);
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		generalMap.put("id", feasibilityStudyId);
		generalMap.put("currentUserId", currentUserId);
		generalMap.put("sqApprovalStatus", sqApprovalStatus);
		generalMap.put("sqApprovalDate", sqApprovalDate);
		generalMap.put("sqApprovalComments", sqApprovalComments);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		boolean successfullyAdded =projectTrackingHandlerService.updateSQApprovalStatus(generalMap);

		if(successfullyAdded) {
			message ="Record Updated Successfully  !!";
		}else {
			message ="Try Again  !!";
		}

		url = "hms/hrms/projectTracking?method=showSQApprovalStatus";
		try{
			map = projectTrackingHandlerService.showSQApprovalStatus(projectId);
		}catch(Exception e) {
			e.printStackTrace();
		}

		String jsp= HR_SQ_APPROVAL_JSP;
		jsp += ".jsp";
		title = "Update SQ Approval";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index" ,"map",map);
	}
	public ModelAndView viewSqApprovalDocument(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int feasibilityHeaderId = 0;
		if(request.getParameter("fesbilitystudyId")!= null){
			feasibilityHeaderId = Integer.parseInt(request.getParameter("fesbilitystudyId"));
			generalMap.put("feasibilityHeaderId", feasibilityHeaderId);
		}
		map = projectTrackingHandlerService.viewSqApprovalDocument(generalMap);
		String jsp = "hr_viewSqApprovalDocument";
		//jsp += ".jsp";
		//map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView ShowSqApprovalDocument(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//Box box = HMSUtil.getBox(request);
		String filename=null;
		String fileExtension=null;
		   MultipartFormDataRequest mrequest = null;

		   if (MultipartFormDataRequest.isMultipartFormData(request))
		   {
				try
				{
					mrequest = new MultipartFormDataRequest(request);
				}
				catch (UploadException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
		   }

		   if(request.getParameter("filename")!= null){
				filename = request.getParameter("filename");
			}
		    Map<String, Object> uploadFileMap = new HashMap<String, Object>();

		   	String uploadURL = getServletContext().getRealPath("/Attendance/");

		  // box.put("uploadURL", uploadURL);
		   StringTokenizer st1=new StringTokenizer(filename,".");
			filename=st1.nextToken();
			fileExtension=st1.nextToken();

		   //box.put("filename", box.getString("filename"));
		   //map = mrdHandlerService.viewUploadDocuments(box);
		   try
		   {
			   if (fileExtension== "doc" || fileExtension == "docx")
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
			   //set the header and also the Name by which user will be prompted to save
			   response.setHeader ("Content-Disposition", "attachment;filename="+java.net.URLEncoder.encode(request.getParameter("filename"))+"");
	          // response.setContentType("image/"+fileExtension);
	          // response.setHeader("Content-Disposition", "attachment; filename="+filename+"."+fileExtension);

		       File f = new File(uploadURL+"/"+filename+"."+fileExtension);
		       InputStream in = new FileInputStream(f);
		       response.getOutputStream().flush();
		       ServletOutputStream outs = response.getOutputStream();


		       long length = f.length();

	    	     if (length > Integer.MAX_VALUE) {
	            // File is too large
	    	     }

	    	     // Create the byte array to hold the data
	    	     byte[] bytes = new byte[(int)length];

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
		   catch (IOException ioe)
		   {
			   ioe.printStackTrace();
		   }

		   String jsp = "hr_viewSqApprovalDocument";
			//jsp += ".jsp";
			//map.put("contentJsp", jsp);

			return new ModelAndView(jsp, "map", map);
		}
 /**************************** Methods For SQ Approval JSP Start **********************************************/

	public ModelAndView showQAApprovalStatus(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int projectId = 0;

		if(request.getParameter("projectId")!= null){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		map = projectTrackingHandlerService.showQAApprovalStatus(projectId);
		String jsp = HR_QA_APPROVAL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
		}

	@SuppressWarnings("unchecked")
	public ModelAndView updateQAApprovalStatus(HttpServletRequest request, HttpServletResponse response){
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url = "";

		Users currentUser =null;
		int currentUserId=0;

		int feasibilityStudyId = 0;
		int projectId = 0;
		String qaApprovalStatus = "";
		Date qaApprovalDate = null;
		String qaApprovalComments = "";


		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		PrjReglSub prjreglSub = new PrjReglSub();

		session = request.getSession();

		if(session.getAttribute("users") !=null) {
			currentUser =(Users)session.getAttribute("users");
			currentUserId =currentUser.getEmployee().getId();
		}

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}

		if(request.getParameter(COMMON_ID) !=null && !(request.getParameter(COMMON_ID).equals(""))){
			feasibilityStudyId = Integer.parseInt(request.getParameter(COMMON_ID));
		}

		if(request.getParameter("projectId") !=null && !(request.getParameter("projectId").equals(""))){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		if(request.getParameter(QA_APPROVAL_STATUS) != null && !(request.getParameter(QA_APPROVAL_STATUS).equals(""))){
			qaApprovalStatus = request.getParameter(QA_APPROVAL_STATUS);
		}

		if(request.getParameter(QA_APPROVAL_DATE) !=null && !(request.getParameter(QA_APPROVAL_DATE).equals(""))) {
			qaApprovalDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(QA_APPROVAL_DATE));
		}

		if(request.getParameter(QA_APPROVAL_COMMENTS) != null && !(request.getParameter(QA_APPROVAL_COMMENTS).equals(""))){
			qaApprovalComments = request.getParameter(QA_APPROVAL_COMMENTS);
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		generalMap.put("id", feasibilityStudyId);
		generalMap.put("currentUserId", currentUserId);
		generalMap.put("qaApprovalStatus", qaApprovalStatus);
		generalMap.put("qaApprovalDate", qaApprovalDate);
		generalMap.put("qaApprovalComments", qaApprovalComments);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		boolean successfullyAdded =projectTrackingHandlerService.updateQAApprovalStatus(generalMap);

		if(successfullyAdded) {
			message ="Record Updated Successfully  !!";
		}else {
			message ="Try Again  !!";
		}

		url = "hms/hrms/projectTracking?method=showQAApprovalStatus";
		try{
			map = projectTrackingHandlerService.showQAApprovalStatus(projectId);
		}catch(Exception e) {
			e.printStackTrace();
		}

		String jsp= HR_QA_APPROVAL_JSP;
		jsp += ".jsp";
		title = "Update SQ Approval";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index" ,"map",map);
	}
	public ModelAndView viewQaApprovalDocument(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int feasibilityHeaderId = 0;
		if(request.getParameter("fesbilitystudyId")!= null){
			feasibilityHeaderId = Integer.parseInt(request.getParameter("fesbilitystudyId"));
			generalMap.put("feasibilityHeaderId", feasibilityHeaderId);
		}
		map = projectTrackingHandlerService.viewQaApprovalDocument(generalMap);
		String jsp = "hr_viewQaApprovalDocument";
		//jsp += ".jsp";
		//map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView ShowQaApprovalDocument(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//Box box = HMSUtil.getBox(request);
		String filename=null;
		String fileExtension=null;
		   MultipartFormDataRequest mrequest = null;

		   if (MultipartFormDataRequest.isMultipartFormData(request))
		   {
				try
				{
					mrequest = new MultipartFormDataRequest(request);
				}
				catch (UploadException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
		   }

		   if(request.getParameter("filename")!= null){
				filename = request.getParameter("filename");
			}
		    Map<String, Object> uploadFileMap = new HashMap<String, Object>();

		   	String uploadURL = getServletContext().getRealPath("/Attendance/");

		  // box.put("uploadURL", uploadURL);
		   StringTokenizer st1=new StringTokenizer(filename,".");
			filename=st1.nextToken();
			fileExtension=st1.nextToken();

		   //box.put("filename", box.getString("filename"));
		   //map = mrdHandlerService.viewUploadDocuments(box);
		   try
		   {
			   if (fileExtension== "doc" || fileExtension == "docx")
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
			   //set the header and also the Name by which user will be prompted to save
			   response.setHeader ("Content-Disposition", "attachment;filename="+java.net.URLEncoder.encode(request.getParameter("filename"))+"");
	          // response.setContentType("image/"+fileExtension);
	          // response.setHeader("Content-Disposition", "attachment; filename="+filename+"."+fileExtension);

		       File f = new File(uploadURL+"/"+filename+"."+fileExtension);
		       InputStream in = new FileInputStream(f);
		       response.getOutputStream().flush();
		       ServletOutputStream outs = response.getOutputStream();


		       long length = f.length();

	    	     if (length > Integer.MAX_VALUE) {
	            // File is too large
	    	     }

	    	     // Create the byte array to hold the data
	    	     byte[] bytes = new byte[(int)length];

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
		   catch (IOException ioe)
		   {
			   ioe.printStackTrace();
		   }

		   String jsp = "hr_viewSqApprovalDocument";
			//jsp += ".jsp";
			//map.put("contentJsp", jsp);

			return new ModelAndView(jsp, "map", map);
		}
	public ModelAndView searchVisitDetails(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException
	{
		Map<String, Object> map= new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		String visitType  = null;
		String visitName = null;
		String searchField= null;
		int projectIdWithSearch = 0;
		String jsp= "";

		int searchRadio=1;
		try{
			if(request.getParameter("projectIdWithSearch")!= null){
				projectIdWithSearch = Integer.parseInt(request.getParameter("projectIdWithSearch"));
				mapForDs.put("projectIdWithSearch", projectIdWithSearch);
			}
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
			visitType=searchField;
			visitName=null;
		}else{
			visitType=null;
			visitName=searchField;
		}
		mapForDs.put("visitType", visitType);
		mapForDs.put("visitName", visitName);

		map = projectTrackingHandlerService.searchVisitDetails(mapForDs);
		jsp = PATIENT_VISIT_SCHEDULE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		return new ModelAndView("index", "map", map);
	}

	//===================== by Vishal============================================
/**************************** Methods For Site Other Vitals JSP Start **********************************************/

	public ModelAndView showSiteOtherVitalsJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		Map<String,Object> mapForDs=new HashMap<String,Object>();

		Users user=(Users)session.getAttribute(USERS);
		MasEmployee employee= user.getEmployee();

		mapForDs.put("employeeId", employee.getId());
		mapForDs.put("users", user);

		int projectId = 0;
		if(request.getParameter("projectId")!= null){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}
		int siteId = 0;
		if(request.getParameter("siteId")!= null){
			siteId = Integer.parseInt(request.getParameter("siteId"));
		}

		map = projectTrackingHandlerService.showSiteOtherVitalsJsp(projectId,siteId );

		Map<String ,Object> newMap=commonMasterHandlerService.getUserButtonRights(mapForDs);
		List<UserButtonRights> userRightsList=(List<UserButtonRights>)newMap.get("userRightsList");
		map.put("userRightsList", userRightsList);

		String jsp = SITE_OTH_VITAL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addSiteOtherVitals(HttpServletRequest request ,HttpServletResponse response) {
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url = "";
		int projectId = 0;
		int siteId  =0;
		String vitalCode = "";
		String vitalName = "";


		PrjSiteOthervitals prjSiteOthervitals = new PrjSiteOthervitals();
		Map<String, Object> map =new HashMap<String, Object>();
		Map<String, Object> generalMap =new HashMap<String, Object>();


		session = request.getSession();

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}
		if(request.getParameter("projectId") !=null && !(request.getParameter("projectId").equals(""))){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		if(request.getParameter(SITE_OVT_CODE) !=null && !(request.getParameter(SITE_OVT_CODE).equals(""))) {
			vitalCode =request.getParameter(SITE_OVT_CODE);
		}

		if(request.getParameter("siteId") !=null && !(request.getParameter("siteId").equals(""))) {
			siteId =Integer.parseInt(request.getParameter("siteId"));
		}

		if(request.getParameter(SITE_OVT_NAME) !=null && !(request.getParameter(SITE_OVT_NAME).equals(""))) {
			vitalName =request.getParameter(SITE_OVT_NAME);
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		boolean successfullyAdded =false;
			if(projectId != 0){
			    MstrProject mstrProject = new MstrProject();
			    mstrProject.setId(projectId);
			    prjSiteOthervitals.setProject(mstrProject);
			}

			if(hospitalId != 0){
			    MasHospital masHospital =new MasHospital();
			    masHospital.setId(hospitalId);
			    prjSiteOthervitals.setHospital(masHospital);
			}
			if(siteId != 0){
			    MstrSiteHeader mstrSiteHeader =new MstrSiteHeader();
			    mstrSiteHeader.setId(siteId);
			    prjSiteOthervitals.setSiteHeader(mstrSiteHeader);
			}

			prjSiteOthervitals.setOvtCode(vitalCode);
			prjSiteOthervitals.setOvtName(vitalName);
			prjSiteOthervitals.setStatus("y");
			prjSiteOthervitals.setLastChgBy(changedBy);
			prjSiteOthervitals.setLastChgDate(currentDate);
		    prjSiteOthervitals.setLastChgTime(currentTime);

			successfullyAdded =projectTrackingHandlerService.addSiteOtherVitals(prjSiteOthervitals);

			if(successfullyAdded) {
				message ="Record Added Successfully  !!";
			}else {
				message ="Try Again  !!";
			}

			url = "hms/hrms/projectTracking?method=showSiteOtherVitalsJsp";
			try{
				map = projectTrackingHandlerService.showSiteOtherVitalsJsp(projectId, siteId);
			}catch(Exception e) {
				e.printStackTrace();
			}

			String jsp= SITE_OTH_VITAL_JSP;
			jsp += ".jsp";
			title = "Add Site Other Vitals";
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index" ,"map",map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editSiteOtherVitals(HttpServletRequest request, HttpServletResponse response){
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url="";
		int siteOtherVitalsId = 0;
		int projectId = 0;
		int siteId =0;
		String vitalsCode ="";
		String vitalsName = "";

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		PrjSiteOthervitals prjSiteOthervitals =new PrjSiteOthervitals();

		session = request.getSession();

		if(session.getAttribute("hospitalId") !=null) {
			hospitalId =Integer.parseInt("" + session.getAttribute("hospitalId"));
		}

		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			siteOtherVitalsId =Integer.parseInt( request.getParameter(COMMON_ID));
		}

		if(request.getParameter("projectId") !=null && !(request.getParameter("projectId").equals(""))){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}

		if(request.getParameter("siteId") !=null && !(request.getParameter("siteId").equals(""))){
			siteId = Integer.parseInt(request.getParameter("siteId"));
		}


		if(request.getParameter(SITE_OVT_CODE) !=null && !(request.getParameter(SITE_OVT_CODE).equals(""))) {
			vitalsCode =request.getParameter(SITE_OVT_CODE);
		}

		if(request.getParameter(SITE_OVT_NAME) !=null && !(request.getParameter(SITE_OVT_NAME).equals(""))) {
			vitalsName= request.getParameter(SITE_OVT_NAME);
		}

		if(request.getParameter(CHANGED_BY) !=null && !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy =request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(CHANGED_DATE) !=null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) !=null && !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime =request.getParameter(CHANGED_TIME);
		}

		boolean successfullyUpdated =false;

		generalMap.put("id", siteOtherVitalsId);
		generalMap.put("vitalsCode", vitalsCode);
		generalMap.put("vitalsName", vitalsName);
		//generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		successfullyUpdated = projectTrackingHandlerService.editSiteOtherVitals(generalMap);
		if(successfullyUpdated ==true){
			message="Data updated Successfully !!";
		}
		else{
			message="Data Cant be updated !!";
		}

		url = "hms/hrms/projectTracking?method=showSiteOtherVitalsJsp";
		try{
			map = projectTrackingHandlerService.showSiteOtherVitalsJsp(projectId, siteId);
		}catch(Exception e) {
			e.printStackTrace();
		}

		String jsp= SITE_OTH_VITAL_JSP;
		jsp += ".jsp";
		title = "Update Site Other Vitals";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index" ,"map",map);
	}
	//-------------------------------------Site Miles Stone---------------------------------------------

	public ModelAndView showSiteMilesStoneJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		Map<String,Object> mapForDs=new HashMap<String,Object>();

		Users user=(Users)session.getAttribute(USERS);
		MasEmployee employee= user.getEmployee();

		mapForDs.put("employeeId", employee.getId());
		mapForDs.put("users", user);


		int projectId = 0;
		if(request.getParameter("projectId")!= null){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}
		int siteId = 0;
		if(request.getParameter("siteId")!= null){
			siteId = Integer.parseInt(request.getParameter("siteId"));
		}

		map = projectTrackingHandlerService.showSiteMilesStoneJsp(projectId, siteId);

		Map<String ,Object> newMap=commonMasterHandlerService.getUserButtonRights(mapForDs);
		List<UserButtonRights> userRightsList=(List<UserButtonRights>)newMap.get("userRightsList");
		map.put("userRightsList", userRightsList);

		String jsp = SITE_MILES_STONE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addSiteMilesStone(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		if (session.getAttribute("hospitalId")!= null) {
			int	hospitalId = (Integer)session.getAttribute("hospitalId");
			generalMap.put("hospitalId", hospitalId);
		}

		if(request.getParameter(PROJECT_ID)!= null){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}

		if(request.getParameter(SITE_ID)!= null){
			int siteId = Integer.parseInt(request.getParameter(SITE_ID));
			generalMap.put("siteId", siteId);
		}
		if(request.getParameter(PATIENT_VISIT_ID)!= null){
		   int	visitId = Integer.parseInt(request.getParameter(PATIENT_VISIT_ID));
		   generalMap.put("visitId", visitId);
		}
		if(request.getParameter(SITE_MILES_STONE_AMOUNT)!= null){
			   BigDecimal siteAmount = new BigDecimal(request.getParameter(SITE_MILES_STONE_AMOUNT));
			   generalMap.put("siteAmount", siteAmount);
		}
		if(request.getParameter(SITE_MILES_STONE_PERCENTAGE)!= null){
			   BigDecimal amountPercentage = new BigDecimal(request.getParameter(SITE_MILES_STONE_PERCENTAGE));
			   generalMap.put("amountPercentage", amountPercentage);
		}
		if(request.getParameter(SITE_TOTAL_AMOUNT_PER_PATIENT)!= null){
			   BigDecimal paymentInAmountPerPatient = new BigDecimal(request.getParameter(SITE_TOTAL_AMOUNT_PER_PATIENT));
			   generalMap.put("paymentInAmountPerPatient", paymentInAmountPerPatient);
		}
		if(request.getParameter(SITE_CUT_OF_DATE)!= null  && !(request.getParameter(SITE_CUT_OF_DATE).equals(""))){
			Date cutOffDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(SITE_CUT_OF_DATE));
			generalMap.put("cutOffDate", cutOffDate);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			String changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}

		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			String	currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		map = projectTrackingHandlerService.addSiteMilesStone(generalMap);
		String jsp = SITE_MILES_STONE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView editSiteMilesStone(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		if(request.getParameter(SITE_MILES_STONE_ID)!= null){
			int	siteMilesStoneId = Integer.parseInt(request.getParameter(SITE_MILES_STONE_ID));
			generalMap.put("siteMilesStoneId", siteMilesStoneId);
		}

		if(request.getParameter(PROJECT_ID)!= null){
			int	projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		if(request.getParameter(PATIENT_VISIT_ID)!= null){
		   int	visitId = Integer.parseInt(request.getParameter(PATIENT_VISIT_ID));
		   generalMap.put("visitId", visitId);
		}
		if(request.getParameter(SITE_ID)!= null){
			   int siteId = Integer.parseInt(request.getParameter(SITE_ID));
			   generalMap.put("siteId", siteId);
		}
		if(request.getParameter(SITE_MILES_STONE_AMOUNT)!= null){
			   BigDecimal siteAmount = new BigDecimal(request.getParameter(SITE_MILES_STONE_AMOUNT));
			   generalMap.put("siteAmount", siteAmount);
		}
		if(request.getParameter(SITE_MILES_STONE_PERCENTAGE)!= null){
			   BigDecimal sitePercentage = new BigDecimal(request.getParameter(SITE_MILES_STONE_PERCENTAGE));
			   generalMap.put("sitePercentage", sitePercentage);
		}
		if(request.getParameter(SITE_TOTAL_AMOUNT_PER_PATIENT)!= null){
			   BigDecimal amountPerPatient = new BigDecimal(request.getParameter(SITE_TOTAL_AMOUNT_PER_PATIENT));
			   generalMap.put("amountPerPatient", amountPerPatient);
		}
		if(request.getParameter(SITE_CUT_OF_DATE)!= null  && !(request.getParameter(SITE_CUT_OF_DATE).equals(""))){
			Date cutOffDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(SITE_CUT_OF_DATE));
			generalMap.put("cutOffDate", cutOffDate);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			String changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}

		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			String	currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		map = projectTrackingHandlerService.editSiteMileStone(generalMap);
		String jsp = SITE_MILES_STONE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showSiteCalendarJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object> mapForDs=new HashMap<String,Object>();

		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user=(Users)session.getAttribute(USERS);
		MasEmployee employee= user.getEmployee();

		mapForDs.put("employeeId", employee.getId());
		mapForDs.put("users", user);

		int projectId = 0;
		if(request.getParameter(PROJECT_ID)!= null){
			projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
		}
		int siteId = 0;
		if(request.getParameter("siteId")!= null){
			siteId = Integer.parseInt(request.getParameter("siteId"));
		}
		map = projectTrackingHandlerService.showSiteCalendarJsp(projectId,siteId);

		Map<String ,Object> newMap=commonMasterHandlerService.getUserButtonRights(mapForDs);
		List<UserButtonRights> userRightsList=(List<UserButtonRights>)newMap.get("userRightsList");
		map.put("userRightsList", userRightsList);

		String jsp = SITE_CALENDAR_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveSiteCalendar(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Map<String,Object> mapForDs=new HashMap<String,Object>();

		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user=(Users)session.getAttribute(USERS);
		MasEmployee employee= user.getEmployee();

		mapForDs.put("employeeId", employee.getId());
		mapForDs.put("users", user);


		if (session.getAttribute("hospitalId")!= null) {
			int	hospitalId = (Integer)session.getAttribute("hospitalId");
			generalMap.put("hospitalId", hospitalId);
		}
		if(request.getParameter(PROJECT_ID)!= null){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		if(request.getParameter(SITE_ID)!= null){
			int siteId = Integer.parseInt(request.getParameter(SITE_ID));
			generalMap.put("siteId", siteId);
		}
		if(request.getParameter(CALENDAR_ID)!= null){
			int calendarId = Integer.parseInt(request.getParameter(CALENDAR_ID));
			generalMap.put("calendarId", calendarId);
		}
		if(request.getParameter(PLANNED_DATE) != null && !(request.getParameter(PLANNED_DATE).equals(""))){
			Date plannedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(PLANNED_DATE));
			generalMap.put("plannedDate", plannedDate);
		}
		if(request.getParameter(PLANNED_REMARK)!= null){
			String plannedRemark = request.getParameter(PLANNED_REMARK);
			generalMap.put("plannedRemark", plannedRemark);
		}
		if(request.getParameter(REVISED_DATE) != null && !(request.getParameter(REVISED_DATE).equals(""))){
			Date revisedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(REVISED_DATE));
			generalMap.put("revisedDate", revisedDate);
		}
		if(request.getParameter(REVISED_REMARK)!= null){
			String revisedRemark = request.getParameter(REVISED_REMARK);
			generalMap.put("revisedRemark", revisedRemark);
		}
		if(request.getParameter(ACTUAL_DATE) != null && !(request.getParameter(ACTUAL_DATE).equals(""))){
			Date actualDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(ACTUAL_DATE));
			generalMap.put("actualDate", actualDate);
		}
		if(request.getParameter(ACTUAL_REMARK)!= null){
			String actualRemark = request.getParameter(ACTUAL_REMARK);
			generalMap.put("actualRemark", actualRemark);
		}
		if(request.getParameter(NO_OF_DAYS)!= null){
			int noOfDays = Integer.parseInt(request.getParameter(NO_OF_DAYS));
			generalMap.put("noOfDays", noOfDays);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			String changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}

		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			String	currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		map = projectTrackingHandlerService.saveSiteCalendar(generalMap);

		Map<String ,Object> newMap=commonMasterHandlerService.getUserButtonRights(mapForDs);
		List<UserButtonRights> userRightsList=(List<UserButtonRights>)newMap.get("userRightsList");
		map.put("userRightsList", userRightsList);

		String jsp = SITE_CALENDAR_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView updateSiteCalendar(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Map<String,Object> mapForDs=new HashMap<String,Object>();

		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user=(Users)session.getAttribute(USERS);
		MasEmployee employee= user.getEmployee();

		mapForDs.put("employeeId", employee.getId());
		mapForDs.put("users", user);
		if(request.getParameter(SITE_CALENDAR_ID)!= null){
			int siteCalenderId = Integer.parseInt(request.getParameter(SITE_CALENDAR_ID));
			generalMap.put("siteCalenderId", siteCalenderId);
		}
		if(request.getParameter(SITE_ID)!= null){
			int siteId = Integer.parseInt(request.getParameter(SITE_ID));
			generalMap.put("siteId", siteId);
		}
		if(request.getParameter(PROJECT_ID)!= null){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		if(request.getParameter(CALENDAR_ID)!= null){
			int calendarId = Integer.parseInt(request.getParameter(CALENDAR_ID));
			generalMap.put("calendarId", calendarId);
		}
		if(request.getParameter(PLANNED_DATE) != null && !(request.getParameter(PLANNED_DATE).equals(""))){
			Date plannedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(PLANNED_DATE));
			generalMap.put("plannedDate", plannedDate);
		}
		if(request.getParameter(PLANNED_REMARK)!= null){
			String plannedRemark = request.getParameter(PLANNED_REMARK);
			generalMap.put("plannedRemark", plannedRemark);
		}
		if(request.getParameter(REVISED_DATE) != null && !(request.getParameter(REVISED_DATE).equals(""))){
			Date revisedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(REVISED_DATE));
			generalMap.put("revisedDate", revisedDate);
		}
		if(request.getParameter(REVISED_REMARK)!= null){
			String revisedRemark = request.getParameter(REVISED_REMARK);
			generalMap.put("revisedRemark", revisedRemark);
		}
		if(request.getParameter(ACTUAL_DATE) != null && !(request.getParameter(ACTUAL_DATE).equals(""))){
			Date actualDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(ACTUAL_DATE));
			generalMap.put("actualDate", actualDate);
		}
		if(request.getParameter(ACTUAL_REMARK)!= null){
			String actualRemark = request.getParameter(ACTUAL_REMARK);
			generalMap.put("actualRemark", actualRemark);
		}
		if(request.getParameter(NO_OF_DAYS)!= null){
			int noOfDays = Integer.parseInt(request.getParameter(NO_OF_DAYS));
			generalMap.put("noOfDays", noOfDays);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			String changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			String	currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		map = projectTrackingHandlerService.updateSiteCalendar(generalMap);

		Map<String ,Object> newMap=commonMasterHandlerService.getUserButtonRights(mapForDs);
		List<UserButtonRights> userRightsList=(List<UserButtonRights>)newMap.get("userRightsList");
		map.put("userRightsList", userRightsList);

		String jsp = SITE_CALENDAR_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView deleteSiteCalendar(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int siteCalendarId=0;
		String message=null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag ="";

		Map<String, Object> generalMap = new HashMap<String, Object>();

		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if(request.getParameter(SITE_CALENDAR_ID) != null && !(request.getParameter(SITE_CALENDAR_ID).equals(""))){
			siteCalendarId =Integer.parseInt( request.getParameter(SITE_CALENDAR_ID));
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		if(request.getParameter(SITE_ID)!= null){
			int siteId = Integer.parseInt(request.getParameter(SITE_ID));
			generalMap.put("siteId", siteId);
		}
		if(request.getParameter(PROJECT_ID)!= null){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}

		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		map=projectTrackingHandlerService.deleteSiteCalendar(siteCalendarId,generalMap);

		String jsp = SITE_CALENDAR_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	//==================DCF by Vishal==============================================================================================
	/*public ModelAndView showDCFEntryJsp(HttpServletRequest request ,HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();

		Users users = new Users();
		if(session.getAttribute("users")!= null){
			users =(Users)session.getAttribute("users");
		}
		generalMap.put("users", users);

		map = projectTrackingHandlerService.showDCFEntryJsp(generalMap);
		String jsp = DCF_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchSiteForProject(HttpServletRequest request ,HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();

		Users users = new Users();
		if(session.getAttribute("users")!= null){
			users =(Users)session.getAttribute("users");
		}
		generalMap.put("users", users);

		int projectId = 0;
		if(request.getParameter(SEARCH_PROJECT_NAME)!= null){
				projectId = Integer.parseInt(request.getParameter(SEARCH_PROJECT_NAME));
			generalMap.put("projectId", projectId);
		}

		map = projectTrackingHandlerService.searchSiteForProject(generalMap);
		map.put("projectId",projectId);
		String jsp = DCF_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}*/
	public ModelAndView searchPatientForSite(HttpServletRequest request ,HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Users users = new Users();
		if(session.getAttribute("users")!= null){
			users =(Users)session.getAttribute("users");
			generalMap.put("users", users);
//			String emp_code = "";
//			emp_code = users.getEmployee().getEmployeeCode();
//			generalMap.put("emp_code", emp_code);
		}
		int projectId = 0;
		if(request.getParameter(PROJECT_ID)!= null){
				projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}

		int siteId = 0;
		if(request.getParameter("siteId")!= null){
				siteId = Integer.parseInt(request.getParameter("siteId"));
			generalMap.put("siteId", siteId);
		}

		map = projectTrackingHandlerService.searchPatientForSite(generalMap);
		map.put("projectId",projectId);
		map.put("siteId",siteId);
		String jsp = DCF_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}



	public ModelAndView uploadDCF(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String,Object> map=new HashMap<String,Object>();
		Users user = null;
		int projectId = 0;
		int siteId = 0;

		String siteCode  = "";
		String protocolNo = "";
		String emp_code = "";
		String message= "";


		MasEmployee employee = null;
		HttpSession session = request.getSession();
		if(session.getAttribute("users")!=null)
		{
			user = (Users)session.getAttribute("users");
			employee = user.getEmployee();
		}
		emp_code = employee.getEmployeeCode();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String date = sdf.format(new Date());

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
		if(mrequest.getParameter("projectId") !=null && !(mrequest.getParameter("projectId").equals(""))) {
			projectId =new Integer(mrequest.getParameter("projectId"));
		}
		if(mrequest.getParameter("siteId") !=null && !(mrequest.getParameter("siteId").equals(""))) {
			siteId =new Integer(mrequest.getParameter("siteId"));
		}

		if(mrequest.getParameter("siteCode") !=null && !(mrequest.getParameter("siteCode").equals(""))) {
			siteCode = (mrequest.getParameter("siteCode"));
		}
		if(mrequest.getParameter("protocolNo") !=null && !(mrequest.getParameter("protocolNo").equals(""))) {
			protocolNo = (mrequest.getParameter("protocolNo"));
		}


				//upload proofs

				try {
					String uploadURL = getServletContext().getRealPath("/docDCFEntry");

					String whiteList = "*.xls";
					Long fileSizeLimit = RequestConstants.MAX_FILE_SIZE;


					String fileNameToBeAssigned = protocolNo+"_"+siteCode+"_"+"_"+date;

					List fileUploadedList = null;
					Connection connection = projectTrackingHandlerService.getDBConnection();




					fileUploadedList = HMSUtil.uploadDCFEntry(mrequest, uploadURL, whiteList, fileSizeLimit, fileNameToBeAssigned, connection,RequestConstants.UPLOAD);
					Boolean fileUploaded=false;
					if(fileUploadedList != null && fileUploadedList.size()!=0){
						fileUploaded = (Boolean) fileUploadedList.get(0);
					}
					if(fileUploaded)
					{
						map.put("projectId", projectId);
						map.put("siteId", siteId);
						map.put("file_name", fileNameToBeAssigned);
						map = projectTrackingHandlerService.saveDCFEntry(map);
						message = "file & Data Save sucessfully";
						map.put("message", message);
					}
				} catch (IllegalStateException e) {
				   message = "file should be Excel";
				   map.put("message", message);
					e.printStackTrace();
				}


				//map.put("fileName",fileNameToBeAssigned);
				String jsp = DCF_ENTRY_JSP;
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				return new ModelAndView("index", "map", map);
	}


//	public ModelAndView	getExcelDCFDocument(HttpServletRequest request,HttpServletResponse response) throws IOException{
//		String fileNames="";
//		if(request.getParameter("fileNames")!=null){
//		fileNames=	request.getParameter("fileNames");
//		}
//				 response.setContentType( "application/vnd.ms-excel" );
//
//		 File f = new File(getServletContext().getRealPath("/docDCFEntry/"+fileNames));
//	       InputStream in = new FileInputStream(f);
//	       response.getOutputStream().flush();
//	       ServletOutputStream outs = response.getOutputStream();
//
//
//	       long length = f.length();
//
//  	     if (length > Integer.MAX_VALUE) {
//          // File is too large
//  	     }
//
//  	     // Create the byte array to hold the data
//  	     byte[] bytes = new byte[(int)length];
//
//  	     int offset = 0;
//  	     int numRead = 0;
//  	     while (offset < bytes.length
//  	    		 && (numRead=in.read(bytes, offset, bytes.length-offset)) >= 0) {
//  	    	 offset += numRead;
//  	     }
//
//  	     if (offset < bytes.length) {
//  	     }
//  	     outs.write(bytes);
//  	     in.close();
//	  return null;
//	}

	public ModelAndView showDCFViewJsp(HttpServletRequest request ,HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Users users = new Users();
		if(session.getAttribute("users")!= null){
			users =(Users)session.getAttribute("users");
			generalMap.put("users", users);
		}
		int projectId = 0;
		if(request.getParameter(PROJECT_ID)!= null){
				projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}

		int siteId = 0;
		if(request.getParameter("siteId")!= null){
				siteId = Integer.parseInt(request.getParameter("siteId"));
			generalMap.put("siteId", siteId);
		}

		map = projectTrackingHandlerService.showDCFViewJsp(generalMap);
		map.put("projectId",projectId);
		map.put("siteId",siteId);
		String jsp = DCF_VIEW_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView approveProject(HttpServletRequest request ,HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Users users = new Users();
		String status = "";
		if(session.getAttribute("users")!= null){
			users =(Users)session.getAttribute("users");
		}
		generalMap.put("users", users);

		int projectId = 0;
		Date approveDate = new Date();
		String comments = new String();

		if(request.getParameter(PROJECT_ID)!= null
				&& !request.getParameter(PROJECT_ID).equals("")){
			projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		if(request.getParameter(STATUS_DESC)!= null && !request.getParameter(STATUS_DESC).equals("")){
			status = request.getParameter(STATUS_DESC);
			generalMap.put("status", status);
		}
		if(request.getParameter(APPROVAL_DATE)!= null
				&& !request.getParameter(APPROVAL_DATE).equals("")){
			approveDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(APPROVAL_DATE));
			generalMap.put("approveDate", approveDate);
		}
		if(request.getParameter(COMMENTS)!= null && !request.getParameter(COMMENTS).equals("")){
			comments = request.getParameter(COMMENTS);
			generalMap.put("comments", comments);
		}

		map = projectTrackingHandlerService.approveProject(generalMap);
		map.put("projectId",projectId);
		String jsp = MSG_APPROVE_PROJECT;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showScheduleSettingJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int projectId = 0;
		if(request.getParameter(PROJECT_ID)!= null){
			projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}

		int siteId = 0;
		if(request.getParameter("siteId")!= null){
			siteId = Integer.parseInt(request.getParameter("siteId"));
			generalMap.put("siteId", siteId);
		}

		map = projectTrackingHandlerService.showScheduleSettingJsp(generalMap);

		String jsp = "hr_scheduleSetting";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView createSchedule(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		if (session.getAttribute("hospitalId")!= null) {
			int	hospitalId = (Integer)session.getAttribute("hospitalId");
			generalMap.put("hospitalId", hospitalId);
		}

		int projectId = 0;
		if(request.getParameter(PROJECT_ID)!= null){
			projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		if(request.getParameter("siteInitiationDate")!= null){
			Date siteInitiationDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("siteInitiationDate"));
			generalMap.put("siteInitiationDate", siteInitiationDate);
		}

		int siteId = 0;
		if(request.getParameter(SITE_ID)!= null){
			siteId = Integer.parseInt(request.getParameter(SITE_ID));
			generalMap.put("siteId", siteId);
		}
		int visitTypeId = 0;
		if(request.getParameter(PATIENT_VISIT_TYPE)!= null){
			visitTypeId = Integer.parseInt(request.getParameter(PATIENT_VISIT_TYPE));
			generalMap.put("visitTypeId", visitTypeId);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			String changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}

		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			String	currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		map = projectTrackingHandlerService.createSchedule(generalMap);
		String jsp = "hr_scheduleSetting";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView editScheduleDetails(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List actualDateList =new ArrayList();
		List revisedDateList =new ArrayList();
		List scheduleDetailIdList =new ArrayList();
		List variationList =new ArrayList();
		List statusList =new ArrayList();
		List commentList =new ArrayList();
		int projectId = 0;
		if(request.getParameter(PROJECT_ID)!= null){
			projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		if(request.getParameter("siteInitiationDate")!= null){
			Date siteInitiationDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("siteInitiationDate"));
			generalMap.put("siteInitiationDate", siteInitiationDate);
		}

		int siteId = 0;
		if(request.getParameter(SITE_ID)!= null){
			siteId = Integer.parseInt(request.getParameter(SITE_ID));
			generalMap.put("siteId", siteId);
		}
		int visitTypeId = 0;
		if(request.getParameter(PATIENT_VISIT_TYPE)!= null){
			visitTypeId = Integer.parseInt(request.getParameter(PATIENT_VISIT_TYPE));
			generalMap.put("visitTypeId", visitTypeId);
		}
		int noOfSchedule = 0;
		if(request.getParameter("counter")!= null){
			noOfSchedule = Integer.parseInt(request.getParameter("counter"));
		}

		for(int j=0;j<noOfSchedule;j++)
		{
			if(request.getParameter("scheduleDetailId"+j)!= null && !(request.getParameter("scheduleDetailId"+j).equals(""))){
				scheduleDetailIdList.add(request.getParameter("scheduleDetailId"+j));
			}else{
				scheduleDetailIdList.add("");
			}
			if(request.getParameter(REVISED_DATE+j)!= null && !(request.getParameter(REVISED_DATE+j).equals(""))){
				revisedDateList.add(request.getParameter(REVISED_DATE+j));
			}else{
				revisedDateList.add("");
			}
			if(request.getParameter(ACTUAL_DATE+j)!= null && !(request.getParameter(ACTUAL_DATE+j).equals(""))){
				actualDateList.add(request.getParameter(ACTUAL_DATE+j));
			}else{
				actualDateList.add("");
			}
			if(request.getParameter(VARIATION+j)!= null && !(request.getParameter(VARIATION+j).equals(""))){
				variationList.add(request.getParameter(VARIATION+j));
			}else{
				variationList.add("");
			}
			if(request.getParameter(STATUS+j)!= null && !(request.getParameter(STATUS+j).equals(""))){
				statusList.add(request.getParameter(STATUS+j));
			}else{
				statusList.add("");
			}
			if(request.getParameter(COMMENTS+j)!= null && !(request.getParameter(COMMENTS+j).equals(""))){
				commentList.add(request.getParameter(COMMENTS+j));
			}else{
				commentList.add("");
			}


		}

		generalMap.put("actualDateList", actualDateList);
		generalMap.put("revisedDateList", revisedDateList);
		generalMap.put("variationList", variationList);
		generalMap.put("statusList", statusList);
		generalMap.put("commentList", commentList);
		generalMap.put("scheduleDetailIdList", scheduleDetailIdList);


		map = projectTrackingHandlerService.editScheduleDetails(generalMap);
		String jsp = "hr_scheduleSetting";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView attachScheduleDocument(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		if(request.getParameter(PROJECT_ID)!= null){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		int scheduleDetailId = 0;
		if(request.getParameter("scheduleDetailId")!= null){
			scheduleDetailId = Integer.parseInt(request.getParameter("scheduleDetailId"));
			generalMap.put("scheduleDetailId", scheduleDetailId);
		}
		map = projectTrackingHandlerService.attachScheduleDocument(generalMap);
		String jsp = "hr_schduleDocument";
		//jsp += ".jsp";
		//map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView addCreateScheduleFile(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MultipartFormDataRequest mrequest = null;
		if (MultipartFormDataRequest.isMultipartFormData(request))
		   {
				try
				{
					mrequest = new MultipartFormDataRequest(request);
				}
				catch (UploadException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
		   }
		String fileExtension=null;
		String uploadURL = getServletContext().getRealPath("/Attendance/");
		String filename = "";
		List fileUploadedList = null;
			if(request.getParameter("filename")!= null){
				filename = request.getParameter("filename");
			}
			generalMap.put("filename", filename);
			StringTokenizer strToken=new StringTokenizer(filename,".");

			filename=strToken.nextToken();
		   	fileExtension=strToken.nextToken();
		   	String whiteList = "*."+fileExtension;

		   	fileUploadedList = HMSUtil.uploadTicketFile(mrequest,uploadURL, whiteList,filename);

			String comments = "";
			if( mrequest.getParameter("comments")!= null){
				comments = mrequest.getParameter("comments");
				generalMap.put("comments", comments);
			}
			int scheduleDetailId = 0;
			if(mrequest.getParameter("scheduleDetailId")!= null){
				scheduleDetailId = Integer.parseInt(mrequest.getParameter("scheduleDetailId"));
				generalMap.put("scheduleDetailId", scheduleDetailId);
			}

			generalMap.put("uploadURL", uploadURL);
		map = projectTrackingHandlerService.addCreateScheduleFile(generalMap);
		String jsp = "hr_schduleDocument";
		//jsp += ".jsp";
		//map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView viewCreateScheduleDocument(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int scheduleDetailId = 0;
		if(request.getParameter("scheduleDetailId")!= null){
			scheduleDetailId = Integer.parseInt(request.getParameter("scheduleDetailId"));
			generalMap.put("scheduleDetailId", scheduleDetailId);
		}
		map = projectTrackingHandlerService.viewCreateScheduleDocument(generalMap);
		String jsp = "hr_viewScheduelDocument";
		//jsp += ".jsp";
		//map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView ShowScheduleDocument(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String filename=null;
		String fileExtension=null;
		   MultipartFormDataRequest mrequest = null;

		   if (MultipartFormDataRequest.isMultipartFormData(request))
		   {
				try
				{
					mrequest = new MultipartFormDataRequest(request);
				}
				catch (UploadException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
		   }

		   if(request.getParameter("filename")!= null){
				filename = request.getParameter("filename");
			}
		    Map<String, Object> uploadFileMap = new HashMap<String, Object>();

		   	String uploadURL = getServletContext().getRealPath("/Attendance/");

		  // box.put("uploadURL", uploadURL);
		   StringTokenizer st1=new StringTokenizer(filename,".");
			filename=st1.nextToken();
			fileExtension=st1.nextToken();

		   //box.put("filename", box.getString("filename"));
		   //map = mrdHandlerService.viewUploadDocuments(box);
		   try
		   {
			   if (fileExtension== "doc" || fileExtension == "docx")
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
			   //set the header and also the Name by which user will be prompted to save
			   response.setHeader ("Content-Disposition", "attachment;filename="+java.net.URLEncoder.encode(request.getParameter("filename"))+"");
	          // response.setContentType("image/"+fileExtension);
	          // response.setHeader("Content-Disposition", "attachment; filename="+filename+"."+fileExtension);

		       File f = new File(uploadURL+"/"+filename+"."+fileExtension);
		       InputStream in = new FileInputStream(f);
		       response.getOutputStream().flush();
		       ServletOutputStream outs = response.getOutputStream();


		       long length = f.length();

	    	     if (length > Integer.MAX_VALUE) {
	            // File is too large
	    	     }

	    	     // Create the byte array to hold the data
	    	     byte[] bytes = new byte[(int)length];

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
		   catch (IOException ioe)
		   {
			   ioe.printStackTrace();
		   }

		String jsp = "hr_viewScheduelDocument";
		//jsp += ".jsp";
		//map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView updateScheduleSettingJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int projectId = 0;
		if(request.getParameter(PROJECT_ID)!= null){
			projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}

		int siteId = 0;
		if(request.getParameter("siteId")!= null){
			siteId = Integer.parseInt(request.getParameter("siteId"));
			generalMap.put("siteId", siteId);
		}

		map = projectTrackingHandlerService.updateScheduleSettingJsp(generalMap);

		String jsp = "hr_updateScheduleSetting";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveUpdateSchedule(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int visitTypeId = 0;
		if(request.getParameter(PATIENT_VISIT_TYPE)!= null){
			visitTypeId = Integer.parseInt(request.getParameter(PATIENT_VISIT_TYPE));
			generalMap.put("visitTypeId", visitTypeId);
		}
		int projectId = 0;
		if(request.getParameter(PROJECT_ID)!= null){
			projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}
		int siteId = 0;
		if(request.getParameter(SITE_ID)!= null){
			siteId = Integer.parseInt(request.getParameter(SITE_ID));
			generalMap.put("siteId", siteId);
		}
		map = projectTrackingHandlerService.saveUpdateSchedule(generalMap);
		String jsp = "hr_updateScheduleSetting";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView updateScheduleDetails(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List actualDateList =new ArrayList();
		List revisedDateList =new ArrayList();
		List scheduleDetailIdList =new ArrayList();
		List variationList =new ArrayList();
		List statusList =new ArrayList();
		List commentList =new ArrayList();
		int projectId = 0;
		if(request.getParameter(PROJECT_ID)!= null){
			projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			generalMap.put("projectId", projectId);
		}

		int siteId = 0;
		if(request.getParameter(SITE_ID)!= null){
			siteId = Integer.parseInt(request.getParameter(SITE_ID));
			generalMap.put("siteId", siteId);
		}
		int visitTypeId = 0;
		if(request.getParameter(PATIENT_VISIT_TYPE)!= null){
			visitTypeId = Integer.parseInt(request.getParameter(PATIENT_VISIT_TYPE));
			generalMap.put("visitTypeId", visitTypeId);
		}
		int noOfSchedule = 0;
		if(request.getParameter("counter")!= null){
			noOfSchedule = Integer.parseInt(request.getParameter("counter"));
		}

		for(int j=0;j<noOfSchedule;j++)
		{
			if(request.getParameter("scheduleDetailId"+j)!= null && !(request.getParameter("scheduleDetailId"+j).equals(""))){
				scheduleDetailIdList.add(request.getParameter("scheduleDetailId"+j));
			}else{
				scheduleDetailIdList.add("");
			}

			if(request.getParameter(ACTUAL_DATE+j)!= null && !(request.getParameter(ACTUAL_DATE+j).equals(""))){
				actualDateList.add(request.getParameter(ACTUAL_DATE+j));
			}else{
				actualDateList.add("");
			}
			if(request.getParameter(VARIATION+j)!= null && !(request.getParameter(VARIATION+j).equals(""))){
				variationList.add(request.getParameter(VARIATION+j));
			}else{
				variationList.add("");
			}
			if(request.getParameter(STATUS+j)!= null && !(request.getParameter(STATUS+j).equals(""))){
				statusList.add(request.getParameter(STATUS+j));
			}else{
				statusList.add("");
			}
			if(request.getParameter(COMMENTS+j)!= null && !(request.getParameter(COMMENTS+j).equals(""))){
				commentList.add(request.getParameter(COMMENTS+j));
			}else{
				commentList.add("");
			}

		}
		generalMap.put("actualDateList", actualDateList);
		generalMap.put("variationList", variationList);
		generalMap.put("statusList", statusList);
		generalMap.put("commentList", commentList);
		generalMap.put("scheduleDetailIdList", scheduleDetailIdList);
		map = projectTrackingHandlerService.updateScheduleDetails(generalMap);
		String jsp = "hr_updateScheduleSetting";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

}

