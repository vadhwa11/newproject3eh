package jkt.security.masters.controller;

import static jkt.hms.util.RequestConstants.ADDRESS;
import static jkt.hms.util.RequestConstants.APPLICATION_ID;
import static jkt.hms.util.RequestConstants.APPLICATION_NAME;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.CONTACT_NUMBER;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DEPARTMENT_NAME;
import static jkt.hms.util.RequestConstants.EMAIL_ID;
import static jkt.hms.util.RequestConstants.GROUP_APP_ID;
import static jkt.hms.util.RequestConstants.GROUP_ID;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.HOSPITAL_MASTER_JSP;
import static jkt.hms.util.RequestConstants.HOSPITAL_NAME;
import static jkt.hms.util.RequestConstants.LOGIN_NAME;
import static jkt.hms.util.RequestConstants.MODULE_MANAGEMENT_JSP;
import static jkt.hms.util.RequestConstants.SEARCH_AND_EDIT_APPLICATION;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.STATUS;
import static jkt.hms.util.RequestConstants.TEMPLATE;
import static jkt.hms.util.RequestConstants.URL;
import static jkt.hms.util.RequestConstants.USER_APPLICATION_JSP;
import static jkt.hms.util.RequestConstants.USER_DEPARTMENT_JSP;
import static jkt.hms.util.RequestConstants.USER_GROUP_HOSPITAL_JSP;
import static jkt.hms.util.RequestConstants.USER_GROUP_ID;
import static jkt.hms.util.RequestConstants.USER_GROUP_JSP;
import static jkt.hms.util.RequestConstants.USER_GROUP_NAME;
import static jkt.hms.util.RequestConstants.USER_HOSPITAL_MAINTENANCE_JSP;
import static jkt.hms.util.RequestConstants.USER_ID;
import static jkt.hms.util.RequestConstants.USER_JSP;
import static jkt.hms.util.RequestConstants.USER_NAME;
import static jkt.hms.util.RequestConstants.VALID_DATE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.wsdl.Input;

import jkt.hms.account.handler.AccountHandlerService;
import jkt.hms.masters.business.EmpGroups;
import jkt.hms.masters.business.MasApplication;
import jkt.hms.masters.business.MasButtonForm;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHospitalType;
import jkt.hms.masters.business.MasPostCode;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasTaluk;
import jkt.hms.masters.business.MasTemplate;
import jkt.hms.masters.business.MasVillage;
import jkt.hms.masters.business.MasWard;
import jkt.hms.masters.business.PhMasElectricalSection;
import jkt.hms.masters.business.PhMasLocality;
import jkt.hms.masters.business.PhMasParliyamentAssembly;
import jkt.hms.masters.business.TemplateApplication;
import jkt.hms.masters.business.UserApplications;
import jkt.hms.masters.business.UserDepartment;
import jkt.hms.masters.business.UserEmpGroup;
import jkt.hms.masters.business.UserGroups;
import jkt.hms.masters.business.UserHospital;
import jkt.hms.masters.business.UserTemplate;
import jkt.hms.masters.business.UserUsergroupHospital;
import jkt.hms.masters.business.UsergroupHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.security.masters.handler.SuperAdminMasterHandlerService;
import jkt.security.masters.handler.UserMasterHandlerService;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@SuppressWarnings("unchecked")
public class UserMasterController extends MultiActionController {

	String jsp = "";
	List hospitalList = null;
	List employeeList = null;
	List userList = null;
	Map map = null;
	HttpSession session = null;
	String title = "";
	String message = "";
	String url = "";
	UserMasterHandlerService userMasterHandlerService = null;

	String code = "";
	String name = "";
	String currentDate = "";
	String currentTime = "";
	String changedBy = "";
	String jspName = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";

	CommonMasterHandlerService commonMasterHandlerService = null;
	SuperAdminMasterHandlerService superAdminMasterHandlerService = null;
	static final Logger LOGGER = Logger.getLogger(UserMasterController.class);
	Map<String, Object> generalMap = new HashMap<String, Object>();

	@SuppressWarnings("unchecked")
	// ---------------------------------------User By Mansi
	// ---------------------------------//
	public ModelAndView searchUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		String loginName = null;
		if (request.getParameter(LOGIN_NAME) != null
				&& !(request.getParameter(LOGIN_NAME).equals(""))) {
			loginName = request.getParameter(LOGIN_NAME).trim();
		}
		session = request.getSession(true);
		int userType = 0;
		int userId = 0;
		if(session.getAttribute("users") != null){
			 Users user = (Users)session.getAttribute("users");
			 userType = user.getUserType()!=null?user.getUserType():4;
			 userId = user.getId();
		}
		int hospitalId = 0;
		if(request.getParameter("bsScInst")!=null){
			hospitalId = Integer.parseInt(request.getParameter("bsScInst"));
		}else {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		datamap.put("districtId", (Integer)session.getAttribute("districtId"));
		datamap.put("loginName", loginName);
		datamap.put("hospitalId", hospitalId);
		datamap.put("userType", userType);
		datamap.put("userId", userId);
		map = userMasterHandlerService.searchUser(datamap);
		
		
		
		jsp = USER_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("loginName", loginName);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView showUserJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		String userName =  (String)session.getAttribute("userName");
		map.put("districtId", (Integer)session.getAttribute("districtId"));
		map.put("userName", userName);
		map.put("hospitalId", hospitalId);
		int userType = 0;
		int userId = 0;
		if(session.getAttribute("users") != null){
			 Users user = (Users)session.getAttribute("users");
			 userType = user.getUserType()!=null?user.getUserType():4;
			 userId = user.getId();
		}
		map.put("userType", userType);
		map = userMasterHandlerService.showUserJsp(map);
		if(userType == 5){ // PH admin
			List<Object[]> bsScInstList = new ArrayList<Object[]>();
			bsScInstList = userMasterHandlerService.getBsScInstList(userId);
			map.put("bsScInstList", bsScInstList);
		}
		String jsp = USER_JSP;
		jsp += ".jsp";
		title = "User";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public void getHospitalWiseEmpList(HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		int hospitalId = 0;
		
		if(request.getParameter("hospitalId")!=null){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));

		}else{
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		List<MasEmployee> empList = new ArrayList<MasEmployee>();

		Box box  = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = userMasterHandlerService.getEmployeeCodeDetails(box);
		empList = (List) map.get("existingMasEmployeeList");
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<emp>");
		for (MasEmployee emp : empList) {
			sb.append("<e>");
			sb.append("<employeeName>" + emp.getEmployeeName() + "</employeeName>");
			
			sb.append("<employeeId>" + emp.getId() + "</employeeId>");
			sb.append("</e>");
		}
		sb.append("</emp>");
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
	public ModelAndView getEmployeeCodeDetails(HttpServletRequest request, HttpServletResponse response)
	{
		List<MasEmployee> existingMasEmployeeList = new ArrayList<MasEmployee>();
		HttpSession session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		Box box  = HMSUtil.getBox(request);
		box.put("hospitalId", (Integer)session.getAttribute("hospitalId"));
		String userName =  (String)session.getAttribute("userName");
		box.put("userName",userName);
		
		int userType = 0;
		if(session.getAttribute("users") != null){
			 Users user = (Users)session.getAttribute("users");
			 userType = user.getUserType()!=null?user.getUserType():4;
			 
		}
		box.put("userType", userType);
		map = userMasterHandlerService.getEmployeeCodeDetails(box);
		List<Users> existingUserList = new ArrayList<Users>();
		if(map.get("existingUserList") != null)
		{
			existingUserList = (List<Users>)map.get("existingUserList");
		}
		try
		{
		PrintWriter pw = response.getWriter();
		
		if(existingUserList.size() > 0){
			pw.write("success,UserExists");
		}else{
			if(map.get("existingMasEmployeeList") != null)
			{
				existingMasEmployeeList = (List<MasEmployee>) map.get("existingMasEmployeeList");
				if(existingMasEmployeeList.size() >0)
				{
					for(MasEmployee list: existingMasEmployeeList)
					{
						pw.write("success,Exist,"+(list.getId()!=null?list.getId():"0")+","+(list.getPEN()!=null?list.getPEN():"")+","+(list.getEmployeeName()!=null?list.getEmployeeName():"")+","+(list.getHospital()!=null?list.getHospital().getId():"0")+","+(list.getHospital()!=null?list.getHospital().getHospitalName():"")+","+(list.getHospital()!=null?list.getHospital().getSimNo():"")+","+(list.getHospital()!=null?list.getHospital().getImeiNo():""));
					}
					
				}
				else
				{
					pw.write("success,NotExist");
				}
			}
		}
		}catch(Exception e)
		{
			
		}
		
		return null;
	}
	
	public ModelAndView encryptAllPassword(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			boolean flag = userMasterHandlerService.encryptAllPassword();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addUser(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Users users = new Users();
		int employeeId = 0;
		int savedUserId = 0;
		String password = "";
		String passwordDecoded = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String,Object>();
		Date currentDate = new Date();
		String loginName = "";
		String userName = "";
		int hospitalId = 0;
		Long imeiNo=0l;
		String simNo="";
		String wipseStatus="";
		String pacsUserName="";
		String pacsPassword="";
		String pacsDesignation="";
		String empName="";
		boolean isPacsUser=false;
		if(request.getParameter("hospitalId")!=null)
		{
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		int userId = 0;
		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");
		}

		if (request.getParameter(LOGIN_NAME) != null) {
			loginName = request.getParameter(LOGIN_NAME);
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
		if (request.getParameter(RequestConstants.EMPLOYEE_ID) != null && !request.getParameter(RequestConstants.EMPLOYEE_ID).equals("0")) {
			employeeId = Integer.parseInt(request
					.getParameter(RequestConstants.EMPLOYEE_ID));

		}else if(request.getParameter("empId")!=null){
			employeeId = Integer.parseInt(request
					.getParameter("empId"));
		}
		if (request.getParameter(RequestConstants.PASSWORD) != null) {
			password = request.getParameter(RequestConstants.PASSWORD);
		}
		if (request.getParameter("pacsUserName") != null) {
			pacsUserName = request.getParameter("pacsUserName");
			isPacsUser=true;
		}
		if (request.getParameter("pacsPassword") != null) {
			pacsPassword = request.getParameter("pacsPassword");
			isPacsUser=true;
		}if (request.getParameter("pacsDesignation") != null) {
			pacsDesignation = request.getParameter("pacsDesignation");
			isPacsUser=true;
		} 
		if (request.getParameter("employeeName") != null) {
			empName = request.getParameter("employeeName");
			isPacsUser=true;
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
		if (request.getParameter("imeiNo") != null && !"".equals(request.getParameter("imeiNo").trim())) {
			imeiNo =Long.parseLong(request.getParameter("imeiNo"));
		}
		if (request.getParameter("simNo") != null && !"".equals(request.getParameter("simNo").trim())) {
			simNo =request.getParameter("simNo");
		}
		if (request.getParameter("wipseStatus") != null && !request.getParameter("wipseStatus").equals("")) {
			wipseStatus =request.getParameter("wipseStatus");
			LOGGER.info("wipseStatus wipseStatus "+wipseStatus);
		}
		generalMap.put("code", loginName);
		generalMap.put("name", loginName);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List userLoginNameList = new ArrayList();
		List userNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			userLoginNameList = (List) listMap.get("duplicateGeneralCodeList");
		}
		/*
		 * if(listMap.get("duplicateGeneralNameList") != null){ userNameList =
		 * (List)listMap.get("duplicateGeneralNameList"); }
		 */
		int counterMenu=0;
		if (request.getParameter("counterMenu") != null	&& !(request.getParameter("counterMenu").equals(""))) 
		{
			counterMenu= Integer.parseInt(""+request.getParameter("counterMenu"));
		}
		List<Integer> templetIdList=new ArrayList<Integer>();
		try 
		{
			if(counterMenu>0)
			{
				for (int ct = 1; ct <=counterMenu; ct++) 
				{
					int templetId=0;
					if (request.getParameter("templetId"+ct) != null) 
					{
						templetId= Integer.parseInt(""+request.getParameter("templetId"+ct));
					}
					if(templetId>0)
					{
						templetIdList.add(templetId);
					}
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		map.put("hospitalId", hospitalId);
		map.put("templetIdList", templetIdList);
		
		boolean successfullyAdded = false;
		if ((userLoginNameList.size() == 0 || userLoginNameList == null)
				&& (userNameList.size() == 0 || userNameList == null)) {
			users.setLoginName(loginName);
			users.setUserName(userName);
			users.setStatus("y");
			Users user = new Users();
			user.setId(userId);
			users.setLastChgBy(user);
			users.setLastChgDate(currentDate);
			users.setLastChgTime(currentTime);
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			users.setEmployee(masEmployee);
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			users.setHospital(hospital);
			users.setImeiNo(imeiNo);
			users.setSimSerialNo(simNo+""); 
			users.setPassword(HMSUtil.encryptPassword(password));
			if(request.getParameter("wipseStatus")!=null){
				users.setWipseStatus("n");
			}else{
				users.setWipseStatus("y");
			}
			
			if(request.getParameter("superuser")!=null){
				users.setSuperuser("y");
			}else{
				users.setSuperuser("n");
			}
			if(request.getParameter("userType")!=null){
				users.setUserType(Integer.parseInt(request.getParameter("userType")));
			}
			boolean isPacsUserCreated=false;
			String PACSMessage="";
			if(isPacsUser && !pacsUserName.equals("") && !pacsPassword.equals("") && 
					!pacsDesignation.equals("") && !pacsDesignation.equals("")){
				
				 PACSMessage=saveUserNameAndPasswordToPacs(request,response);
				isPacsUserCreated=true;
				 if(PACSMessage.contains("PACS user created successfully")){
					 	users.setPacsUsername(pacsUserName);
						users.setPacsPassword(pacsPassword);
						users.setPacsDesignation(pacsDesignation);
				 } 
				
			}
			map.put("employeeId", employeeId);
			map.put("users", users);
			map.put("loginName", loginName);
			
			UserHospital userHospital = new UserHospital();
			
			userHospital.setHospital(hospital);
			userHospital.setStatus("y");
			
			userHospital.setLastChgBy(user);
			
			userHospital.setLastChgDate(currentDate);
			userHospital.setLastChgTime(currentTime);
			
			map.put("userHospital", userHospital); 
			map.put("userId", userId);
			resultMap = userMasterHandlerService.addUser(map);
			
			if(resultMap.get("userId")!=null)
				savedUserId = (Integer) resultMap.get("userId");
			
			
			if ((Boolean)resultMap.get("successfullyAdded")) {
				message = "Record Added Successfully !!";
				if(isPacsUserCreated){
					message=message.concat("\r"+PACSMessage);
				}
			} else {
				message = "Try Again !!";
			}
		}

		else if ((userLoginNameList.size() != 0 || userLoginNameList != null)
				|| (userNameList.size() != 0) || userNameList != null) {
			if ((userLoginNameList.size() != 0 || userLoginNameList != null)
					&& (userNameList.size() == 0 || userNameList == null)) {

				message = "Login Name already exists.";
			}
			/*
			 * else if((userNameList.size() != 0 || userNameList != null) &&
			 * (userLoginNameList.size() == 0 || userLoginNameList == null) ){
			 * 
			 * message = "User Name already exists."; } else
			 * if((userLoginNameList.size() != 0 || userLoginNameList != null)
			 * && (userLoginNameList.size() != 0 || userLoginNameList != null)){
			 * 
			 * message = "Login Name and User Name already exist."; }
			 */
		}

		try {
			Map<String,Object> dataMap = new HashMap<String, Object>();
			String logUserName =  (String)session.getAttribute("userName");
			dataMap.put("districtId", (Integer)session.getAttribute("districtId"));
			dataMap.put("userName", logUserName);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("userId", savedUserId);
			int userType = 0;
			if(session.getAttribute("users") != null){
				 Users user = (Users)session.getAttribute("users");
				 userType = user.getUserType()!=null?user.getUserType():4;
				 
			}
			dataMap.put("userType", userType);
			map = userMasterHandlerService.showUserJsp(dataMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_JSP;
		title = "Add User ";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editUser(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession(true);
		int hospitalId = 0;
		if(request.getParameter("hospitalId")!=null)
		{
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		String loginName = "";
		int userId = 0;
		String changedTime = "";
		Date changedDate = null;
		int employeeId = 0;
		int chgById = 0;
		String pacsUserName="";
		String pacsPassword="";
		String pacsDesignation="";
		String empName="";
		boolean isPacsUser=false;
		if (session.getAttribute("userId") != null) {
			chgById = (Integer) session.getAttribute("userId");
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			userId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(LOGIN_NAME) != null
				&& !(request.getParameter(LOGIN_NAME).equals(""))) {
			loginName = request.getParameter(LOGIN_NAME);
		}
		/*if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			userName = request.getParameter(SEARCH_NAME);
		}*/
		String password = "";
		if (request.getParameter(RequestConstants.PASSWORD) != null) {
			password = request.getParameter(RequestConstants.PASSWORD);
		}
		if (request.getParameter("pacsUserName") != null) {
			pacsUserName = request.getParameter("pacsUserName");
		}
		if (request.getParameter("pacsPassword") != null) {
			pacsPassword = request.getParameter("pacsPassword");
		}
		if (request.getParameter("pacsUserName") != null) {
			pacsUserName = request.getParameter("pacsUserName");
			isPacsUser=true;
		}
		if (request.getParameter("pacsPassword") != null) {
			pacsPassword = request.getParameter("pacsPassword");
			isPacsUser=true;
		}if (request.getParameter("pacsDesignation") != null) {
			pacsDesignation = request.getParameter("pacsDesignation");
			isPacsUser=true;
		} 
		if (request.getParameter("employeeName") != null) {
			empName = request.getParameter("employeeName");
			isPacsUser=true;
		} 
		String superUser = "";
		if(request.getParameter("superuser")!=null){
			superUser = "y";
		}else{
			superUser = "n";
		}
		
		String wipseStatus="";
		if(request.getParameter("wipseStatus")!=null ){
			if(request.getParameter("wipseStatus").equalsIgnoreCase("y")){
			wipseStatus = "y";
			}
			else{
				wipseStatus = "n";
			}
		}else{
			wipseStatus = "n";
		}
		
		LOGGER.info("wipseStatus    >>>"+wipseStatus);
		int userType = 0;
		if(request.getParameter("userType")!=null){
			userType = Integer.parseInt(request.getParameter("userType"));
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
		if (request.getParameter(RequestConstants.EMPLOYEE_ID) != null && !request.getParameter(RequestConstants.EMPLOYEE_ID).equals("0")) {
			employeeId = Integer.parseInt(request
					.getParameter(RequestConstants.EMPLOYEE_ID));

		}else if(request.getParameter("empId")!=null){
			employeeId = Integer.parseInt(request
					.getParameter("empId"));
		}
		Long imeiNo=0l;
		String simNo="";
		if (request.getParameter("imeiNo") != null && !"".equals(request.getParameter("imeiNo").trim())) {
			imeiNo =Long.parseLong(request.getParameter("imeiNo"));
		}
		if (request.getParameter("simNo") != null && !"".equals(request.getParameter("simNo").trim())) {
			simNo =request.getParameter("simNo");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", userId);
		generalMap.put("loginName", loginName);
//		generalMap.put("name", userName);
		generalMap.put("chgById", chgById);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("password", password); 
		generalMap.put("employeeId", employeeId);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("superUser", superUser);
		generalMap.put("userType",userType);
		generalMap.put("imeiNo",imeiNo);
		generalMap.put("simNo",simNo); 
		generalMap.put("wipseStatus", wipseStatus);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		boolean dataUpdated = false;
		boolean isPacsUserCreated=false;
		String PACSMessage="";
		if(isPacsUser && !pacsUserName.equals("") && !pacsPassword.equals("") && 
				!pacsDesignation.equals("-1") && !empName.equals("")){ 
			 PACSMessage=saveUserNameAndPasswordToPacs(request,response); 
			 isPacsUserCreated=true;
			 if(PACSMessage.contains("PACS user created successfully")){
				 generalMap.put("pacsUserName",pacsUserName);
				 generalMap.put("pacsPassword",pacsPassword);
				 generalMap.put("pacsDesignation",pacsDesignation);
			 } 
		}
		dataUpdated = userMasterHandlerService.editUserToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
			if(isPacsUserCreated){
				message=message.concat("\r"+PACSMessage);
			}
		} else {
			message = "Data Cant be updated !!";
		}/*
		 * List existingUserNameList =
		 * (List)listMap.get("duplicateMastersList"); boolean dataUpdated=false;
		 * if(existingUserNameList.size() == 0) {
		 * dataUpdated=userMasterHandlerService.editUserToDatabase(generalMap);
		 * 
		 * if(dataUpdated==true){ message="Data updated Successfully !!"; }
		 * else{ message="Data Cant Be Updated !!"; } } else
		 * if(existingUserNameList.size() > 0){ message = "Name already
		 * exists."; }
		 */
		url = "/security/security/user?method=showUserJsp";

		try {
			Map<String,Object> dataMap = new HashMap<String, Object>();
			String logUserName =  (String)session.getAttribute("userName");
			dataMap.put("districtId", (Integer)session.getAttribute("districtId"));
			dataMap.put("userName", logUserName);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("userType", userType);
			map = userMasterHandlerService.showUserJsp(dataMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_JSP;
		title = "update User";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteUser(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int userId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		int hospitalId = 0;
		hospitalId = (Integer) session.getAttribute("hospitalId");
		int chgById = 0;
		chgById = (Integer) session.getAttribute("userId");
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			userId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("chgById", chgById);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = userMasterHandlerService.deleteUser(userId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/security/security/user?method=showUserJsp";

		try {
			String userName =  (String)session.getAttribute("userName");
			Map<String,Object> dataMap = new HashMap<String, Object>();
			dataMap.put("districtId", (Integer)session.getAttribute("districtId"));
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			int userType = 0;
			if(session.getAttribute("users") != null){
				 Users user = (Users)session.getAttribute("users");
				 userType = user.getUserType()!=null?user.getUserType():4;
				 
			}
			dataMap.put("userType", userType);
			map = userMasterHandlerService.showUserJsp(dataMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_JSP;
		title = "delete UserGroups";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * public ModelAndView showUserJsp(HttpServletRequest request,
	 * HttpServletResponse response) { Map map = new HashMap();
	 * 
	 * hospitalList = new ArrayList(); employeeList = new ArrayList();
	 * 
	 * employeeList = (List) userMasterHandlerService.getEmployeeList();
	 * hospitalList = (List) userMasterHandlerService.getHospitalList();
	 * userList=(List)userMasterHandlerService.getUserList();
	 * 
	 * map = userMasterHandlerService.showUserJsp();
	 * 
	 * 
	 * String jsp=USER_JSP; jsp += ".jsp"; title = "User";
	 * map.put("hospitalList", hospitalList); map.put("employeeList",
	 * employeeList); map.put("userList", userList); map.put("contentJsp", jsp);
	 * map.put("title", title); return new
	 * ModelAndView("SuperAdminMenu","map",map); }
	 * 
	 * 
	 * 
	 * 
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * addUser(HttpServletRequest request, HttpServletResponse response) throws
	 * ParseException { String message=null; @SuppressWarnings("unused")
	 * 
	 * String loginName = null; String userName = null; String employeeCode
	 * =null; String password = null; String loginNameTemp=null; String
	 * employeeCodeTemp=null; Date currentDate = new Date(); jsp = USER_JSP;
	 * title="User Master"; Users users=new Users();
	 * 
	 * 
	 * if (request.getParameter(RequestConstants.LOGIN_NAME) != null) {
	 * loginName = request.getParameter(RequestConstants.LOGIN_NAME);
	 * loginName=loginName.trim(); } if
	 * (request.getParameter(RequestConstants.USER_NAME) != null) { userName =
	 * request.getParameter(RequestConstants.USER_NAME); } if
	 * (request.getParameter(RequestConstants.EMPLOYEE_CODE) != null) {
	 * employeeCode = request.getParameter(RequestConstants.EMPLOYEE_CODE); } if
	 * (request.getParameter(RequestConstants.PASSWORD) != null) { password =
	 * request.getParameter(RequestConstants.PASSWORD); }
	 * if(request.getParameter(CHANGED_BY) != null &&
	 * !(request.getParameter(CHANGED_BY).equals(""))){ changedBy =
	 * request.getParameter(CHANGED_BY); }
	 * if(request.getParameter(CHANGED_DATE) != null &&
	 * !(request.getParameter(CHANGED_DATE).equals(""))){ currentDate =
	 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE)); }
	 * if(request.getParameter(CHANGED_TIME) != null &&
	 * !(request.getParameter(CHANGED_TIME).equals(""))){ currentTime =
	 * request.getParameter(CHANGED_TIME); }
	 * 
	 * 
	 * userList=new ArrayList();
	 * userList=(List)userMasterHandlerService.getUserList(); String
	 * loginNameUpper=null; if(userList.size() != 0 || userList != null) for
	 * (Iterator iter = userList.iterator(); iter.hasNext();) { Users
	 * userListObj = (Users) iter.next();
	 * loginNameTemp=(String)userListObj.getLoginName();
	 * loginNameTemp=loginNameTemp.toUpperCase();
	 * loginNameUpper=loginName.toUpperCase();
	 * employeeCodeTemp=(String)userListObj.getEmployeeCode();
	 * 
	 * if(loginNameTemp!=null) if(loginNameUpper.equals(loginNameTemp) ||
	 * loginNameUpper==loginNameTemp) { map =
	 * userMasterHandlerService.showUserJsp();
	 * //url="/security/security/user?method=showUserJsp"; //map.put("url",
	 * url); message="Login Name Already Exists"; map.put("message", message);
	 * title="User Master"; map.put("title", title); jsp += ".jsp";
	 * map.put("contentJsp", jsp); return new ModelAndView("SuperAdminMenu",
	 * "map", map); } if(!employeeCode.equals("select"))
	 * if(employeeCode.equals(employeeCodeTemp)||
	 * employeeCode==employeeCodeTemp) { map =
	 * userMasterHandlerService.showUserJsp();
	 * //url="/security/security/user?method=showUserJsp"; //map.put("url",
	 * url); message="Employee Code Already Mapped"; map.put("message",
	 * message); title="User Master"; map.put("title", title); jsp += ".jsp";
	 * map.put("contentJsp", jsp); return new ModelAndView("SuperAdminMenu",
	 * "map", map); } }
	 * 
	 * users.setLoginName(loginName); users.setUserName(userName);
	 * if(!employeeCode.equals("select")) users.setEmployeeCode(employeeCode);
	 * users.setPassword(password); users.setStatus("y");
	 * 
	 * users.setLastChgBy(changedBy); users.setLastChgDate(currentDate);
	 * users.setLastChgTime(currentTime); Boolean flag=false;
	 * flag=userMasterHandlerService.addUser(users); if(flag==true) { map =
	 * userMasterHandlerService.showUserJsp();
	 * //url="/security/security/user?method=showUserJsp"; //map.put("url",
	 * url); message="Record Added Successfully"; map.put("message", message);
	 * title="User Master"; map.put("title", title); jsp += ".jsp";
	 * map.put("contentJsp", jsp); return new ModelAndView("SuperAdminMenu",
	 * "map", map);
	 * 
	 * }else{ map = userMasterHandlerService.showUserJsp();
	 * //url="/security/security/user?method=showUserJsp"; //map.put("url",
	 * url); message="Record Not Added "; title="User Master";
	 * map.put("message", message); map.put("title", title); jsp += ".jsp";
	 * map.put("contentJsp", jsp); return new ModelAndView("SuperAdminMenu",
	 * "map", map); } }
	 */

	/*
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * showUpdateUser(HttpServletRequest request,HttpServletResponse response) {
	 * 
	 * 
	 * 
	 * Map<String, Object> map = new HashMap<String, Object>(); Map<String,
	 * Object> generalMap = new HashMap<String, Object>();
	 * 
	 * session=request.getSession(true); String userGroupsCode=""; String
	 * userGroupsName=""; int userGroupsId=0; String changedBy = ""; String
	 * changedTime = ""; Date changedDate = null; String userName = null; String
	 * employeeCode =null; String password = null; String loginNameTemp=null;
	 * String employeeCodeTemp=null; Date currentDate = new Date(); String
	 * loginName=null; jsp = USER_JSP; title="User Master"; Users users=new
	 * Users();
	 * 
	 * 
	 * if (request.getParameter(RequestConstants.LOGIN_NAME) != null) {
	 * loginName = request.getParameter(RequestConstants.LOGIN_NAME);
	 * loginName=loginName.trim(); } if
	 * (request.getParameter(RequestConstants.USER_NAME) != null) { userName =
	 * request.getParameter(RequestConstants.USER_NAME); } if
	 * (request.getParameter(RequestConstants.EMPLOYEE_CODE) != null) {
	 * employeeCode = request.getParameter(RequestConstants.EMPLOYEE_CODE); } if
	 * (request.getParameter(RequestConstants.PASSWORD) != null) { password =
	 * request.getParameter(RequestConstants.PASSWORD); }
	 * if(request.getParameter(CHANGED_BY) != null &&
	 * !(request.getParameter(CHANGED_BY).equals(""))){ changedBy =
	 * request.getParameter(CHANGED_BY); }
	 * 
	 * changedDate = new Date(); changedTime =
	 * (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	 * 
	 * 
	 * userList=new ArrayList();
	 * userList=(List)userMasterHandlerService.getUserList(); String
	 * loginNameUpper=null; if(userList.size() != 0 || userList != null) for
	 * (Iterator iter = userList.iterator(); iter.hasNext();) { Users
	 * userListObj = (Users) iter.next();
	 * loginNameTemp=(String)userListObj.getLoginName();
	 * loginNameTemp=loginNameTemp.toUpperCase();
	 * loginNameUpper=loginName.toUpperCase();
	 * employeeCodeTemp=(String)userListObj.getEmployeeCode();
	 * 
	 * if(loginNameTemp!=null) if(loginNameUpper.equals(loginNameTemp) ||
	 * loginNameUpper==loginNameTemp) { map =
	 * userMasterHandlerService.showUserJsp();
	 * //url="/security/security/user?method=showUserJsp"; //map.put("url",
	 * url); message="Login Name Already Exists"; map.put("message", message);
	 * title="User Master"; map.put("title", title); jsp += ".jsp";
	 * map.put("contentJsp", jsp); return new ModelAndView("SuperAdminMenu",
	 * "map", map); } if(!employeeCode.equals("select"))
	 * if(employeeCode.equals(employeeCodeTemp)||
	 * employeeCode==employeeCodeTemp) { map =
	 * userMasterHandlerService.showUserJsp();
	 * //url="/security/security/user?method=showUserJsp"; //map.put("url",
	 * url); message="Employee Code Already Mapped"; map.put("message",
	 * message); title="User Master"; map.put("title", title); jsp += ".jsp";
	 * map.put("contentJsp", jsp); return new ModelAndView("SuperAdminMenu",
	 * "map", map); } }
	 * 
	 * users.setLoginName(loginName); users.setUserName(userName);
	 * if(!employeeCode.equals("select")) users.setEmployeeCode(employeeCode);
	 * users.setPassword(password); users.setStatus("y");
	 * 
	 * users.setLastChgBy(changedBy); users.setLastChgDate(currentDate);
	 * users.setLastChgTime(currentTime); Boolean flag=false;
	 * flag=userMasterHandlerService.updateUser(users); if(flag==true) { map =
	 * userMasterHandlerService.showUserJsp();
	 * //url="/security/security/user?method=showUserJsp"; //map.put("url",
	 * url); message="Data updated Successfully "; map.put("message", message);
	 * title="User Master"; map.put("title", title); jsp += ".jsp";
	 * map.put("contentJsp", jsp); return new ModelAndView("SuperAdminMenu",
	 * "map", map);
	 * 
	 * }else{ map = userMasterHandlerService.showUserJsp();
	 * //url="/security/security/user?method=showUserJsp"; //map.put("url",
	 * url); message="Data Cant Be Updated "; title="User Master";
	 * map.put("message", message); map.put("title", title); jsp += ".jsp";
	 * map.put("contentJsp", jsp); return new ModelAndView("SuperAdminMenu",
	 * "map", map); }
	 * 
	 * }
	 * 
	 * 
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * showUpdateUserWithDetails(HttpServletRequest request, HttpServletResponse
	 * response) { @SuppressWarnings("unused") //HttpSession session =
	 * request.getSession(true); Map map=new HashMap();
	 * 
	 * @SuppressWarnings("unused") List<Users> selectedList=new
	 * ArrayList<Users>(); List updateList=new ArrayList(); String jsp =
	 * RequestConstants.UPDATE_USER_JSP; @SuppressWarnings("unused") String
	 * loginName=null; String loginNameString=null; if
	 * (request.getParameter(RequestConstants.LOGIN_NAME) != null)
	 * loginName=(String) request.getParameter(RequestConstants.LOGIN_NAME);
	 * 
	 * if(session.getAttribute("loginNameString")!=null)
	 * loginNameString=(String)session.getAttribute("loginNameString");
	 * 
	 * updateList=userMasterHandlerService.getLoginList(loginNameString);
	 * 
	 * map.put("updateList", updateList);
	 * 
	 * url="/security/security/user?method=showUserJsp"; map.put("url", url);
	 * jsp += ".jsp"; map.put("contentJsp", jsp); return new
	 * ModelAndView("SuperAdminMenu", "map", map); }
	 * 
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * updateUser(HttpServletRequest request, HttpServletResponse response)
	 * throws ParseException {
	 * 
	 * String message=null; int id = 0; String loginName = null; String userName
	 * = null; String employeeCode =null; String password = null; String
	 * lastChgBy=null; String lastChgTime = null; Date lastChgDate = null;
	 * String status=""; @SuppressWarnings("unused") String loginNameTemp=null;
	 * 
	 * @SuppressWarnings("unused") String employeeCodeTemp=null; jsp =
	 * RequestConstants.MESSAGE_FOR_MASTERS_JSP;
	 * 
	 * 
	 * 
	 * if (request.getParameter("userId") != null) { id =
	 * Integer.parseInt(request.getParameter("userId")); } if
	 * (request.getParameter(RequestConstants.LOGIN_NAME) != null) { loginName =
	 * request.getParameter(RequestConstants.LOGIN_NAME);
	 * loginName=loginName.trim(); } if
	 * (request.getParameter(RequestConstants.USER_NAME) != null) { userName =
	 * request.getParameter(RequestConstants.USER_NAME); } if
	 * (request.getParameter(RequestConstants.EMPLOYEE_CODE) != null) {
	 * employeeCode = request.getParameter(RequestConstants.EMPLOYEE_CODE); } if
	 * (request.getParameter(RequestConstants.PASSWORD) != null) { password =
	 * request.getParameter(RequestConstants.PASSWORD); } if
	 * (request.getParameter(RequestConstants.STATUS) != null) { status =
	 * (request.getParameter(RequestConstants.STATUS)); } if
	 * (request.getParameter(RequestConstants.CHANGED_BY) != null) { lastChgBy =
	 * request.getParameter(RequestConstants.CHANGED_BY); } if
	 * (request.getParameter(RequestConstants.CHANGED_DATE_HIDDEN) != null) {
	 * SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
	 * SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
	 * String
	 * date4MySQL=formatterOut.format(formatterIn.parse(request.getParameter
	 * (RequestConstants.CHANGED_DATE_HIDDEN))); lastChgDate =
	 * java.sql.Date.valueOf(date4MySQL); } if
	 * (request.getParameter(RequestConstants.CHANGED_TIME_HIDDEN) != null) {
	 * lastChgTime = request.getParameter(RequestConstants.CHANGED_TIME_HIDDEN);
	 * } Users users=new Users(); userList=new ArrayList();
	 * userList=(List)userMasterHandlerService.getUserList();
	 * 
	 * @SuppressWarnings("unused") String loginNameUpper=null; users.setId(id);
	 * users.setLoginName(loginName); users.setUserName(userName);
	 * if(!employeeCode.equals("select")) users.setEmployeeCode(employeeCode);
	 * users.setPassword(password); users.setStatus(status);
	 * users.setLastChgBy(lastChgBy); users.setLastChgDate(lastChgDate);
	 * users.setLastChgTime(lastChgTime);
	 * 
	 * Boolean flag=false; flag=userMasterHandlerService.updateUser(users);
	 * if(flag==true) { url="/security/security/user?method=showUserJsp";
	 * map.put("url", url); title="User Master"; message="Record Updated
	 * Successfully"; map.put("message", message); map.put("title", title); jsp
	 * += ".jsp"; map.put("contentJsp", jsp); return new
	 * ModelAndView("SuperAdminMenu", "map", map);
	 * 
	 * }else{ url="/security/security/user?method=showUserJsp"; map.put("url",
	 * url); message="Record Not Updated "; title="User Master";
	 * map.put("message", message); map.put("title", title); jsp += ".jsp";
	 * map.put("contentJsp", jsp); return new ModelAndView("SuperAdminMenu",
	 * "map", map); }
	 * 
	 * 
	 * }
	 * 
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * showDeleteUser(HttpServletRequest request, HttpServletResponse response)
	 * { String loginName=null;
	 * 
	 * String jsp = RequestConstants.DELETE_USER_JSP; List deleteList=new
	 * ArrayList(); Map map=new HashMap(); if
	 * (request.getParameter(RequestConstants.LOGIN_NAME) != null) { loginName =
	 * request.getParameter(RequestConstants.LOGIN_NAME);
	 * loginName=loginName.trim(); }
	 * 
	 * deleteList=userMasterHandlerService.getLoginList(loginName);
	 * if(deleteList.size()==0){ jsp=RequestConstants.MESSAGE_FOR_MASTERS_JSP;
	 * message="Records Not found ";
	 * 
	 * map.put("message", message); }
	 * url="/security/security/user?method=showUserJsp"; map.put("url", url);
	 * title="User Master"; map.put("title", title); map.put("deleteList",
	 * deleteList); jsp += ".jsp"; map.put("contentJsp", jsp); return new
	 * ModelAndView("SuperAdminMenu", "map", map); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * deleteUser(HttpServletRequest request, HttpServletResponse response)
	 * throws ParseException { String jsp =
	 * RequestConstants.MESSAGE_FOR_MASTERS_JSP; Map map=new HashMap();
	 * 
	 * 
	 * 
	 * int id = 0; String loginName = null; String userName = null; String
	 * employeeCode =null; String password = null; String lastChgBy=null; String
	 * lastChgTime = null; @SuppressWarnings("unused") Date lastChgDate = null;
	 * String status=""; String message=null;
	 * 
	 * 
	 * try{
	 * 
	 * if (request.getParameter(RequestConstants.USER_ID) != null) {
	 * 
	 * id = Integer.parseInt(request.getParameter(RequestConstants.USER_ID));
	 * 
	 * } if (request.getParameter(RequestConstants.LOGIN_NAME) != null) {
	 * loginName = request.getParameter(RequestConstants.LOGIN_NAME);
	 * loginName=loginName.trim(); } if
	 * (request.getParameter(RequestConstants.USER_NAME) != null) { userName =
	 * request.getParameter(RequestConstants.USER_NAME); } if
	 * (request.getParameter(RequestConstants.EMPLOYEE_CODE) != null) {
	 * employeeCode = request.getParameter(RequestConstants.EMPLOYEE_CODE); } if
	 * (request.getParameter(RequestConstants.PASSWORD) != null) { password =
	 * request.getParameter(RequestConstants.PASSWORD); }
	 * 
	 * if (request.getParameter(RequestConstants.CHANGED_BY) != null) {
	 * lastChgBy = request.getParameter(RequestConstants.CHANGED_BY); } if
	 * (request.getParameter(RequestConstants.CHANGED_DATE_HIDDEN) != null) {
	 * SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
	 * SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
	 * 
	 * String
	 * date4MySQL=formatterOut.format(formatterIn.parse(request.getParameter
	 * (RequestConstants.CHANGED_DATE_HIDDEN)));
	 * 
	 * lastChgDate = java.sql.Date.valueOf(date4MySQL);
	 * 
	 * } if (request.getParameter(RequestConstants.CHANGED_TIME_HIDDEN) != null)
	 * { lastChgTime =
	 * request.getParameter(RequestConstants.CHANGED_TIME_HIDDEN); }
	 * 
	 * 
	 * }catch (Exception e) { } try{ Users
	 * users=new Users(); users.setId(id); users.setLoginName(loginName);
	 * users.setUserName(userName); users.setEmployeeCode(employeeCode);
	 * users.setPassword(password); users.setLastChgBy(lastChgBy);
	 * users.setLastChgDate(lastChgDate); users.setLastChgTime(lastChgTime);
	 * users.setStatus("n"); Boolean flag=false;
	 * flag=userMasterHandlerService.updateUser(users); if(flag==true) {
	 * url="/security/security/user?method=showUserJsp"; map.put("url", url);
	 * title="User Master"; map.put("title", title); message="Record Deleted
	 * Successfully"; map.put("message", message); jsp += ".jsp";
	 * map.put("contentJsp", jsp); return new ModelAndView("SuperAdminMenu",
	 * "map", map);
	 * 
	 * }else{ url="/security/security/user?method=showUserJsp"; map.put("url",
	 * url); title="User Master"; map.put("title", title); message="Record Not
	 * Deleted "; map.put("message", message); jsp += ".jsp";
	 * map.put("contentJsp", jsp); return new ModelAndView("SuperAdminMenu",
	 * "map", map); } }catch (Exception e) {  }
	 * 
	 * jsp += ".jsp"; map.put("contentJsp", jsp); return new
	 * ModelAndView("SuperAdminMenu", "map", map); }
	 * 
	 * 
	 * 
	 * 
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * showEnquiryUser(HttpServletRequest request, HttpServletResponse response)
	 * { String loginName=null; String message=""; String jsp =
	 * RequestConstants.ENQUIRY_USER_JSP; Map map=new HashMap(); List
	 * enquiryList=new ArrayList();
	 * 
	 * if (request.getParameter(RequestConstants.LOGIN_NAME) != null) {
	 * loginName = request.getParameter(RequestConstants.LOGIN_NAME);
	 * loginName=loginName.trim(); }
	 * 
	 * enquiryList=userMasterHandlerService.getLoginList(loginName);
	 * if(enquiryList.size()==0){
	 * url="/security/security/user?method=showUserJsp"; map.put("url", url);
	 * jsp = RequestConstants.MESSAGE_FOR_MASTERS_JSP; title="User Master";
	 * map.put("title", title); message="Records not found"; map.put("message",
	 * message); jsp += ".jsp"; map.put("contentJsp", jsp); return new
	 * ModelAndView("SuperAdminMenu", "map", map); } map.put("enquiryList",
	 * enquiryList); map.put("loginString", loginName);
	 * 
	 * url="/security/security/user?method=showUserJsp"; map.put("url", url);
	 * jsp += ".jsp"; map.put("contentJsp", jsp); return new
	 * ModelAndView("SuperAdminMenu", "map", map); }
	 */
	public UserMasterHandlerService getUserMasterHandlerService() {
		return userMasterHandlerService;
	}

	public void setUserMasterHandlerService(
			UserMasterHandlerService userMasterHandlerService) {
		this.userMasterHandlerService = userMasterHandlerService;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView next(HttpServletRequest request,
			HttpServletResponse response) {
		@SuppressWarnings("unused")
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession(false);
		String nextState = "enable";
		String previousState = "enable";
		String min;
		String max;
		@SuppressWarnings("unused")
		String searchName = "";
		List enquiryList = new ArrayList();
		String jsp = RequestConstants.ENQUIRY_USER_JSP;

		String x = (String) session.getAttribute("min");
		String y = (String) session.getAttribute("max");
		String loginString = (String) session.getAttribute("loginString");

		enquiryList = userMasterHandlerService.getLoginList(loginString);

		int temp1 = Integer.parseInt(x);
		int temp2 = Integer.parseInt(y);
		temp1 = temp1 + 5;
		temp2 = temp2 + 5;

		int sizeOfList = enquiryList.size();

		if ((temp2 + 1 >= sizeOfList)) {
			nextState = "disable";
		}

		min = temp1 + "";
		max = temp2 + "";
		map.put("enquiryList", enquiryList);
		map.put("loginString", loginString);
		map.put("min", min);
		map.put("max", max);
		map.put("nextState", nextState);
		map.put("previousState", previousState);
		url = "/security/security/user?method=showUserJsp";
		map.put("url", url);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView previous(HttpServletRequest request,
			HttpServletResponse response) {
		@SuppressWarnings("unused")
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		String nextState = "enable";
		String previousState = "enable";
		HttpSession session = request.getSession(false);
		String min;
		String max;

		String jsp = RequestConstants.ENQUIRY_USER_JSP;

		String x = (String) session.getAttribute("min");
		String y = (String) session.getAttribute("max");
		String loginString = (String) session.getAttribute("loginString");

		int temp1 = Integer.parseInt(x);
		int temp2 = Integer.parseInt(y);
		temp1 = temp1 - 5;
		temp2 = temp2 - 5;

		Map<String, Object> map = new HashMap<String, Object>();
		List enquiryList = new ArrayList();

		enquiryList = userMasterHandlerService.getLoginList(loginString);

		if ((temp1 <= 0)) {
			previousState = "disable";
		} else {
			previousState = "enable";
		}
		url = "/security/security/user?method=showUserJsp";
		map.put("url", url);
		min = temp1 + "";
		max = temp2 + "";
		map.put("enquiryList", enquiryList);
		map.put("loginString", loginString);
		map.put("min", min);
		map.put("max", max);
		map.put("nextState", nextState);
		map.put("previousState", previousState);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	// Hospital User Maintenance Methods

	@SuppressWarnings("unchecked")
	public ModelAndView showUserHospMaintenanceJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map map = new HashMap();
		userList = new ArrayList();
		hospitalList = new ArrayList();
		userList = (List) userMasterHandlerService.getUserList();
		hospitalList = (List) userMasterHandlerService.getHospitalList();

		map.put("userList", userList);
		map.put("hospitalList", hospitalList);

		jsp = RequestConstants.USER_HOSPITAL_MAINTENENCE;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addUserHospMaintenance(HttpServletRequest request,
			HttpServletResponse response) throws ParseException {

		jsp = RequestConstants.MESSAGE_FOR_MASTERS_JSP;
		@SuppressWarnings("unused")
		List hospitalList = new ArrayList();
		List list = new ArrayList();
		int loginId = 0;
		int hospitalId = 0;
		int groupId = 1;
		int groupHospitalId = 0;
		String status = "";
		String message = "";
		String lastChgBy = null;
		String lastChgTime = null;
		Date lastChgDate = null;
		Date validDate = null;

		if (request.getParameter(RequestConstants.LOGIN_NAME) != null) {
			loginId = Integer.parseInt(request
					.getParameter(RequestConstants.LOGIN_NAME));
		}

		if (request.getParameter(RequestConstants.HOSPITAL_NAME) != null) {
			hospitalId = Integer.parseInt(request
					.getParameter(RequestConstants.HOSPITAL_NAME));
		}

		if (request.getParameter(RequestConstants.GROUP_NAME) != null) {
			groupId = Integer.parseInt(request
					.getParameter(RequestConstants.GROUP_NAME));
		}
		try {
			if (request.getParameter(RequestConstants.VALID_DATE) != null) {
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(request
								.getParameter(RequestConstants.VALID_DATE)));
				validDate = java.sql.Date.valueOf(date4MySQL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (request.getParameter(RequestConstants.CHANGED_BY) != null) {
			lastChgBy = request.getParameter(RequestConstants.CHANGED_BY);
		}

		try {
			if (request.getParameter(RequestConstants.CHANGED_DATE) != null) {
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(request
								.getParameter(RequestConstants.CHANGED_DATE)));
				lastChgDate = java.sql.Date.valueOf(date4MySQL);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (request.getParameter(RequestConstants.CHANGED_TIME) != null) {

			lastChgTime = request.getParameter(RequestConstants.CHANGED_TIME);
		}

		if (request.getParameter(RequestConstants.STATUS) != null) {
			status = (request.getParameter(RequestConstants.STATUS));
		}

		list = userMasterHandlerService.getGroupHospitalId(groupId, hospitalId);
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			UsergroupHospital listObj = (UsergroupHospital) iter.next();

			if (list.size() != 0 && list != null) {

				groupHospitalId = listObj.getId();

			}

		}
		map = new HashMap();
		@SuppressWarnings("unused")
		UserUsergroupHospital userUsergroupHospital = new UserUsergroupHospital();
		userUsergroupHospital.getUser().setId(loginId);
		userUsergroupHospital.getGroupHospital().setId(groupHospitalId);
		userUsergroupHospital.setStatus(status);
		userUsergroupHospital.setValidUpto(validDate);
		userUsergroupHospital.setLastChgBy(lastChgBy);
		userUsergroupHospital.setLastChgDate(lastChgDate);
		userUsergroupHospital.setLastChgTime(lastChgTime);

		list = userMasterHandlerService.checkExistOfUserHospMapping(loginId,
				groupHospitalId);
		if (list.size() != 0 && list != null) {
			url = "/security/security/user?method=showUserHospMaintenanceJsp";
			map.put("url", url);
			message = "Recorn already mapped";
			map.put("message", message);
			title = "User Hospital Maintenence";
			map.put("title", title);
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		} else {
			boolean flag = userMasterHandlerService
					.addUserHosp(userUsergroupHospital);

			if (flag) {
				message = "Record mapped successfully ";
			} else {
				message = "Record not mapped";
			}
		}
		url = "/security/security/user?method=showUserHospMaintenanceJsp";
		map.put("url", url);
		map.put("message", message);
		jsp += ".jsp";
		title = "User Hospital Maintenence";
		map.put("title", title);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showUpdateUserHospMaintenance(
			HttpServletRequest request, HttpServletResponse response)
			throws ParseException {

		String jsp = RequestConstants.UPDATE_USER_HOSPITAL_MAINTENENCE;

		int loginId = 0;
		int hospitalId = 0;
		int groupId = 1;
		int groupHospitalId = 0;
		@SuppressWarnings("unused")
		int status = 0;
		@SuppressWarnings("unused")
		String message = "";
		@SuppressWarnings("unused")
		String lastChgBy = null;
		@SuppressWarnings("unused")
		String lastChgTime = null;
		@SuppressWarnings("unused")
		Date lastChgDate;
		@SuppressWarnings("unused")
		Date validDate;

		Map map = new HashMap();
		List list = new ArrayList();
		List userList = new ArrayList();
		@SuppressWarnings("unused")
		List userGroupHospList = new ArrayList();
		List userUserGroupHospList = new ArrayList();
		@SuppressWarnings("unused")
		List hospList = new ArrayList();

		try {
			if (request.getParameter(RequestConstants.LOGIN_NAME) != null) {
				loginId = Integer.parseInt(request
						.getParameter(RequestConstants.LOGIN_NAME));

			}

			if (request.getParameter(RequestConstants.HOSPITAL_NAME) != null) {
				hospitalId = Integer.parseInt(request
						.getParameter(RequestConstants.HOSPITAL_NAME));

			}

			if (request.getParameter(RequestConstants.GROUP_NAME) != null) {
				groupId = Integer.parseInt(request
						.getParameter(RequestConstants.GROUP_NAME));

			}

			if (request.getParameter(RequestConstants.CHANGED_BY) != null) {
				lastChgBy = request.getParameter(RequestConstants.CHANGED_BY);

			}

			if (request.getParameter(RequestConstants.CHANGED_TIME) != null) {

				lastChgTime = request
						.getParameter(RequestConstants.CHANGED_TIME);

			}

			if (request.getParameter(RequestConstants.STATUS) != null) {
				status = Integer.parseInt(request
						.getParameter(RequestConstants.STATUS));
			}

		} catch (Exception e3) {
			e3.printStackTrace();
		}

		try {

			list = userMasterHandlerService.getGroupHospitalId(groupId,
					hospitalId);

			for (Iterator iter = list.iterator(); iter.hasNext();) {
				UsergroupHospital listObj = (UsergroupHospital) iter.next();

				if (list.size() != 0 && list != null) {

					groupHospitalId = listObj.getId();

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

			userList = (List) userMasterHandlerService.getUserList();

			userUserGroupHospList = (List) userMasterHandlerService
					.getUserUserGroupHospList(loginId, groupHospitalId);

		} catch (Exception e2) {
			e2.printStackTrace();
		}

		try {

			map.put("userUserGroupHospList", userUserGroupHospList);

			map.put("userList", userList);
		} catch (Exception e4) {
			e4.printStackTrace();
		}
		url = "/security/security/user?method=showUserHospMaintenanceJsp";
		map.put("url", url);
		jsp += ".jsp";
		title = "User Hospital Maintenence";
		map.put("title", title);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView updateUserHospMaintenance(HttpServletRequest request,
			HttpServletResponse response) throws ParseException {
		jsp = RequestConstants.MESSAGE_FOR_MASTERS_JSP;
		boolean flag = false;

		int groupHospitalId = 0;
		String status = "";
		String message = "";
		String lastChgBy = null;
		String lastChgTime = null;
		Date lastChgDate = null;
		Date validDate = null;

		UserUsergroupHospital userUsergroupHospital = new UserUsergroupHospital();
		List userUsergroupHospitalList = new ArrayList();
		Map map = new HashMap();

		if (request.getParameter(RequestConstants.VALID_DATE) != null) {
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String date4MySQL = formatterOut.format(formatterIn.parse(request
					.getParameter(RequestConstants.VALID_DATE)));
			validDate = java.sql.Date.valueOf(date4MySQL);
		}

		if (request.getParameter(RequestConstants.CHANGED_BY) != null) {
			lastChgBy = request.getParameter(RequestConstants.CHANGED_BY);
		}

		if (request.getParameter(RequestConstants.CHANGED_DATE) != null) {
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String date4MySQL = formatterOut.format(formatterIn.parse(request
					.getParameter(RequestConstants.CHANGED_DATE)));
			lastChgDate = java.sql.Date.valueOf(date4MySQL);
		}

		if (request.getParameter(RequestConstants.CHANGED_TIME) != null) {

			lastChgTime = request.getParameter(RequestConstants.CHANGED_TIME);

		}

		if (request.getParameter(RequestConstants.STATUS) != null) {
			status = (request.getParameter(RequestConstants.STATUS));
		}
		try {
			if (request.getParameter("groupHospitalIdField") != null) {
				groupHospitalId = Integer.parseInt(request
						.getParameter("groupHospitalIdField"));

			}

			userUsergroupHospitalList = userMasterHandlerService
					.getUserUserGroupHospListWithGHID(groupHospitalId);

			if (userUsergroupHospitalList.size() != 0
					&& userUsergroupHospitalList != null) {
				Iterator iter = userUsergroupHospitalList.iterator();

				UserUsergroupHospital listObj = (UserUsergroupHospital) iter
						.next();
				userUsergroupHospital.setId(listObj.getId());
				userUsergroupHospital.setUser(listObj.getUser());
				userUsergroupHospital.setGroupHospital(listObj
						.getGroupHospital());
				userUsergroupHospital.setStatus(status);
				userUsergroupHospital.setValidUpto(validDate);
				userUsergroupHospital.setLastChgBy(lastChgBy);
				userUsergroupHospital.setLastChgDate(lastChgDate);
				userUsergroupHospital.setLastChgTime(lastChgTime);
			}

			flag = userMasterHandlerService
					.updateUserUsergroupHospital(userUsergroupHospital);

			if (flag) {
				message = "Updated";
			} else {
				message = "Not Updated";
			}

		} catch (Exception e3) {
			e3.printStackTrace();
		}
		url = "/security/security/user?method=showUserHospMaintenanceJsp";
		map.put("url", url);
		title = "User Hospital Maintenence";
		map.put("title", title);
		map.put("message", message);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showDeleteUserHospMaintenance(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = RequestConstants.DELETE_USER_HOSPITAL_MAINTENENCE;

		int loginId = 0;
		@SuppressWarnings("unused")
		int hospitalId = 0;
		@SuppressWarnings("unused")
		int groupId = 1;
		@SuppressWarnings("unused")
		int id = 0;
		@SuppressWarnings("unused")
		int groupHospitalId = 0;
		int userGroupHospitalId = 0;
		map = new HashMap();
		List listWithUserId = new ArrayList();
		List userGroupHospList = new ArrayList();
		List userList = new ArrayList();
		List hospitalList = new ArrayList();

		@SuppressWarnings("unused")
		List userGroupHospListForDelete = new ArrayList();
		List deleteList = new ArrayList();

		if (request.getParameter(RequestConstants.LOGIN_NAME) != null) {
			loginId = Integer.parseInt(request
					.getParameter(RequestConstants.LOGIN_NAME));

		}
		@SuppressWarnings("unused")
		List loginNameList = new ArrayList();
		loginNameList = (List) userMasterHandlerService.getUserName(loginId);

		@SuppressWarnings("unused")
		String userName = "";
		for (Iterator iter3 = loginNameList.iterator(); iter3.hasNext();) {
			Users usersObj = (Users) iter3.next();

			if (loginNameList.size() != 0 && loginNameList != null) {

				userName = usersObj.getLoginName();

			}
		}

		listWithUserId = (List) userMasterHandlerService
				.getListWithUserId(loginId);

		userGroupHospList = (List) userMasterHandlerService
				.getUserGroupHospList();

		try {
			for (Iterator iter1 = listWithUserId.iterator(); iter1.hasNext();) {
				UserUsergroupHospital listObj1 = (UserUsergroupHospital) iter1
						.next();

				if (listWithUserId.size() != 0 && listWithUserId != null) {

					userGroupHospitalId = listObj1.getGroupHospital().getId();

					for (Iterator iter2 = userGroupHospList.iterator(); iter2
							.hasNext();) {
						@SuppressWarnings("unused")
						UsergroupHospital listObj2 = (UsergroupHospital) iter2
								.next();
						if (userGroupHospList.size() != 0
								&& userGroupHospList != null) {
							id = listObj2.getId();

						}
						if (userGroupHospitalId == id) {
							deleteList.add(listObj2);
						}

					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		userList = (List) userMasterHandlerService.getUserList();
		hospitalList = (List) userMasterHandlerService.getHospitalList();

		url = "/security/security/user?method=showUserHospMaintenanceJsp";
		map.put("url", url);
		map.put("listWithUserId", listWithUserId);
		map.put("userId", loginId);
		map.put("loginNameList", loginNameList);
		map.put("deleteList", deleteList);
		map.put("userList", userList);
		map.put("hospitalList", hospitalList);
		title = "User Hospital Maintenence";
		map.put("title", title);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteUserHospMaintenance(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = RequestConstants.MESSAGE_FOR_MASTERS_JSP;
		int userUserGroupHospId = 0;
		String message = "";
		List list = new ArrayList();
		int id = 0;
		int userId = 0;
		int groupHospitalId = 0;
		String status = "";
		boolean flag = false;

		@SuppressWarnings("unused")
		String lastChgBy = null;
		@SuppressWarnings("unused")
		String lastChgTime = null;
		@SuppressWarnings("unused")
		Date lastChgDate = null;
		@SuppressWarnings("unused")
		Date validDate = null;
		UserUsergroupHospital userUsergroupHospital = new UserUsergroupHospital();
		try {
			if (request.getParameter("userUserGroupHospId") != null) {

				userUserGroupHospId = Integer.parseInt(request
						.getParameter("userUserGroupHospId"));

			}

			list = userMasterHandlerService
					.getUserUserGroupHospListWithID(userUserGroupHospId);

			Iterator iter1 = list.iterator();

			UserUsergroupHospital listObj1 = (UserUsergroupHospital) iter1
					.next();
			if (list.size() != 0 && list != null) {

				id = listObj1.getId();
				userId = listObj1.getUser().getId();
				groupHospitalId = listObj1.getGroupHospital().getId();
				status = "n";
				validDate = (Date) listObj1.getValidUpto();
				lastChgBy = listObj1.getLastChgBy();
				lastChgTime = listObj1.getLastChgTime();
				lastChgDate = (Date) listObj1.getLastChgDate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		userUsergroupHospital.setId(id);
		userUsergroupHospital.getUser().setId(userId);
		userUsergroupHospital.getGroupHospital().setId(groupHospitalId);
		userUsergroupHospital.setStatus(status);
		userUsergroupHospital.setValidUpto(validDate);
		userUsergroupHospital.setLastChgBy(lastChgBy);
		userUsergroupHospital.setLastChgDate(lastChgDate);
		userUsergroupHospital.setLastChgTime(lastChgTime);

		flag = userMasterHandlerService
				.updateUserUsergroupHospital(userUsergroupHospital);
		if (flag) {
			message = "Record Deleted";
		} else {
			message = "Record not Deleted";
		}
		url = "/security/security/user?method=showUserHospMaintenanceJsp";
		map.put("url", url);
		title = "User Hospital Maintenence";
		map.put("title", title);
		map.put("message", message);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showEnquiryUserHospMaintenance(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = RequestConstants.ENQUIRY_USER_HOSPITAL_MAINTENENCE;
		@SuppressWarnings("unused")
		int loginId = 0;
		List userUsergroupHospitalList = new ArrayList();
		List userList = new ArrayList();
		List hospitalList = new ArrayList();
		List userGroupList = new ArrayList();
		Map map = new HashMap();
		String message = "";
		if (request.getParameter(RequestConstants.LOGIN_NAME) != null) {
			loginId = Integer.parseInt(request
					.getParameter(RequestConstants.LOGIN_NAME));

		}
		try {
			userUsergroupHospitalList = userMasterHandlerService
					.getListWithUserId(loginId);
			userGroupList = userMasterHandlerService.getUserGroupHospList();
			userList = userMasterHandlerService.getUserList();
			hospitalList = userMasterHandlerService.getHospitalList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (userUsergroupHospitalList.size() == 0) {

			title = "User Hospital Maintenence";
			map.put("title", title);
			url = "/security/security/user?method=showUserHospMaintenanceJsp";
			map.put("url", url);
			message = "Records Not Found with LoginName";
			map.put("message", message);
			jsp = RequestConstants.MESSAGE_FOR_MASTERS_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		map.put("userGroupList", userGroupList);
		map.put("userList", userList);
		map.put("hospitalList", hospitalList);
		map.put("userUsergroupHospitalList", userUsergroupHospitalList);
		map.put("loginIdTemp", loginId + "");

		title = "User Hospital Maintenence";
		map.put("title", title);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView nextForUserHosp(HttpServletRequest request,
			HttpServletResponse response) {
		Map map = new HashMap();

		HttpSession session = request.getSession(false);
		String nextState = "enable";
		String previousState = "enable";
		String min;
		String max;
		String x = "";
		String y = "";
		int temp1 = 0;
		int temp2 = 0;
		String loginIdTemp = "";

		@SuppressWarnings("unused")
		String searchName = "";
		@SuppressWarnings("unused")
		List enquiryList = new ArrayList();
		String jsp = RequestConstants.ENQUIRY_USER_HOSPITAL_MAINTENENCE;
		List userUsergroupHospitalList = new ArrayList();
		List userList = new ArrayList();
		if (session.getAttribute("min") != null) {
			x = (String) session.getAttribute("min");
		}

		if (session.getAttribute("max") != null) {
			y = (String) session.getAttribute("max");
		}
		if (session.getAttribute("loginIdTemp") != null) {
			loginIdTemp = (String) session.getAttribute("loginIdTemp");
		}

		int loginIdTemp2 = Integer.parseInt(""
				+ session.getAttribute("loginIdTemp"));
		try {
			userUsergroupHospitalList = (List) userMasterHandlerService
					.getListWithUserId(loginIdTemp2);
			userList = userMasterHandlerService.getUserList();
			temp1 = Integer.parseInt(x);
			temp2 = Integer.parseInt(y);
			temp1 = temp1 + 5;
			temp2 = temp2 + 5;

			int sizeOfList = userUsergroupHospitalList.size();

			if ((temp2 + 1 >= sizeOfList)) {
				nextState = "disable";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			min = temp1 + "";
			max = temp2 + "";
			map.put("userUsergroupHospitalList", userUsergroupHospitalList);
			map.put("userList", userList);
			map.put("loginIdTemp", loginIdTemp);
			map.put("min", min);
			map.put("max", max);
			map.put("nextState", nextState);
			map.put("previousState", previousState);

		} catch (Exception e) {
			e.printStackTrace();
		}
		url = "/security/security/user?method=showUserHospMaintenanceJsp";
		map.put("url", url);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView previousForUserHosp(HttpServletRequest request,
			HttpServletResponse response) {
		Map map = new HashMap();

		HttpSession session = request.getSession(false);
		String nextState = "enable";
		String previousState = "enable";
		String min;
		String max;
		String x = "";
		String y = "";
		int temp1 = 0;
		int temp2 = 0;
		String loginIdTemp = "";

		@SuppressWarnings("unused")
		String searchName = "";
		@SuppressWarnings("unused")
		List enquiryList = new ArrayList();
		String jsp = RequestConstants.ENQUIRY_USER_HOSPITAL_MAINTENENCE;
		List userUsergroupHospitalList = new ArrayList();
		List userList = new ArrayList();
		if (session.getAttribute("min") != null) {
			x = (String) session.getAttribute("min");
		}

		if (session.getAttribute("max") != null) {
			y = (String) session.getAttribute("max");
		}
		if (session.getAttribute("loginIdTemp") != null) {
			loginIdTemp = (String) session.getAttribute("loginIdTemp");
		}

		int loginIdTemp2 = Integer.parseInt(""
				+ session.getAttribute("loginIdTemp"));
		try {
			userUsergroupHospitalList = (List) userMasterHandlerService
					.getListWithUserId(loginIdTemp2);
			userList = userMasterHandlerService.getUserList();
			temp1 = Integer.parseInt(x);
			temp2 = Integer.parseInt(y);
			temp1 = temp1 - 5;
			temp2 = temp2 - 5;

			@SuppressWarnings("unused")
			int sizeOfList = userUsergroupHospitalList.size();

			if ((temp1 <= 0)) {
				previousState = "disable";
			} else {
				previousState = "enable";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			min = temp1 + "";
			max = temp2 + "";
			map.put("userUsergroupHospitalList", userUsergroupHospitalList);
			map.put("userList", userList);
			map.put("loginIdTemp", loginIdTemp);
			map.put("min", min);
			map.put("max", max);
			map.put("nextState", nextState);
			map.put("previousState", previousState);

		} catch (Exception e) {
		}
		url = "/security/security/user?method=showUserHospMaintenanceJsp";
		map.put("url", url);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	// ********************************************************************************//
	// ***************************** Start Modules Written By
	// Mansi********************//
	// ********************************************************************************//

	// ------------------------------------------User Groups
	// --------------------------

	public ModelAndView searchUserGroups(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String userGroupsCode = null;
		String userGroupsName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			userGroupsCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			userGroupsName = request.getParameter(SEARCH_NAME);
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
			userGroupsCode = searchField;
			userGroupsName = null;

		} else {
			userGroupsCode = null;
			userGroupsName = searchField;
		}
		map = userMasterHandlerService.searchUserGroups(userGroupsCode,
				userGroupsName);

		jsp = USER_GROUP_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("userGroupsCode", userGroupsCode);
		map.put("userGroupsName", userGroupsName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showUserGroupsJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map map = new HashMap();
		map = userMasterHandlerService.showUserGroupsJsp();
		String jsp = USER_GROUP_JSP;
		jsp += ".jsp";
		title = "User Groups";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addUserGroups(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		UserGroups masUserGroups = new UserGroups();

		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
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
		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List userGroupsCodeList = new ArrayList();
		List userGroupsNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			userGroupsCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			userGroupsNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((userGroupsCodeList.size() == 0 || userGroupsCodeList == null)
				&& (userGroupsNameList.size() == 0 || userGroupsNameList == null)) {
			masUserGroups.setCode(code);
			masUserGroups.setGroupName(name);
			masUserGroups.setStatus("y");
			masUserGroups.setLastChgBy(changedBy);
			masUserGroups.setLastChgDate(currentDate);
			masUserGroups.setLastChgTime(currentTime);
			successfullyAdded = userMasterHandlerService
					.addUserGroups(masUserGroups);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((userGroupsCodeList.size() != 0 || userGroupsCodeList != null)
				|| (userGroupsNameList.size() != 0)
				|| userGroupsNameList != null) {
			if ((userGroupsCodeList.size() != 0 || userGroupsCodeList != null)
					&& (userGroupsNameList.size() == 0 || userGroupsNameList == null)) {

				message = "User Groups Code  already exists.";
			} else if ((userGroupsNameList.size() != 0 || userGroupsNameList != null)
					&& (userGroupsCodeList.size() == 0 || userGroupsCodeList == null)) {

				message = "User Groups Name already exists.";
			} else if ((userGroupsCodeList.size() != 0 || userGroupsCodeList != null)
					&& (userGroupsNameList.size() != 0 || userGroupsNameList != null)) {

				message = "User Groups Code and User Groups Name already exist.";
			}
		}

		try {
			map = userMasterHandlerService.showUserGroupsJsp();

		} catch (Exception e) {
		}
		jsp = USER_GROUP_JSP;
		title = "Add User Groups";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editUserGroups(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession(true);
		String userGroupsCode = "";
		String userGroupsName = "";
		int userGroupsId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			userGroupsId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			userGroupsCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			userGroupsName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", userGroupsId);
		generalMap.put("userGroupsCode", userGroupsCode);
		generalMap.put("name", userGroupsName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingUserGroupsNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingUserGroupsNameList.size() == 0) {
			dataUpdated = userMasterHandlerService
					.editUserGroupsToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingUserGroupsNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/security/security/user?method=showUserGroupsJsp";

		try {
			map = userMasterHandlerService.showUserGroupsJsp();

		} catch (Exception e) {
		}
		jsp = USER_GROUP_JSP;
		title = "update User Groups";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteUserGroups(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int userGroupsId = 0;
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
			userGroupsId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = userMasterHandlerService.deleteUserGroups(userGroupsId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/security/security/user?method=showUserGroupsJsp";

		try {
			map = userMasterHandlerService.showUserGroupsJsp();

		} catch (Exception e) {
		}
		jsp = USER_GROUP_JSP;
		title = "delete UserGroups";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------------------------User Group Hospital
	// --------------------------------------------------
	public ModelAndView showUsergroupHospitalJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = userMasterHandlerService.showUsergroupHospitalJsp();
		jsp = USER_GROUP_HOSPITAL_JSP;
		jsp += ".jsp";
		title = "User Group Hospital";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addUsergroupHospital(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		UsergroupHospital masUsergroupHospital = new UsergroupHospital();
		int userGroupId = 0;
		int hospitalId = 0;
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(USER_GROUP_ID) != null) {
			userGroupId = Integer.parseInt(request.getParameter(USER_GROUP_ID));
		}
		if (request.getParameter(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt(request.getParameter(HOSPITAL_ID));
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
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("userGroupId", userGroupId);
		generalMap.put("hospitalId", hospitalId);
		listMap = userMasterHandlerService
				.checkForExistingGroupHospital(generalMap);
		List duplicateGroupHospitalList = new ArrayList();

		if (listMap.get("duplicateGroupHospitalList") != null) {
			duplicateGroupHospitalList = (List) listMap
					.get("duplicateGroupHospitalList");
		}

		boolean successfullyAdded = false;
		if ((duplicateGroupHospitalList.size() == 0 || duplicateGroupHospitalList == null))

		{
			UserGroups masUserGroups = new UserGroups();
			masUserGroups.setId(userGroupId);
			masUsergroupHospital.setGroup(masUserGroups);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			masUsergroupHospital.setHospital(masHospital);

			masUsergroupHospital.setStatus("y");
			masUsergroupHospital.setLastChgBy(changedBy);
			masUsergroupHospital.setLastChgDate(currentDate);
			masUsergroupHospital.setLastChgTime(currentTime);
			successfullyAdded = userMasterHandlerService
					.addUsergroupHospital(masUsergroupHospital);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if (duplicateGroupHospitalList.size() != 0) {

			message = "User Group Name and Hospital Name already exist.";
		}

		try {
			map = userMasterHandlerService.showUsergroupHospitalJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_GROUP_HOSPITAL_JSP;
		title = "Add User Group Hospital";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editUsergroupHospital(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		int usergroupHospitalId = 0;
		int userGroupId = 0;
		int hospitalId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null) {
			usergroupHospitalId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(USER_GROUP_ID) != null) {
			userGroupId = Integer.parseInt(request.getParameter(USER_GROUP_ID));
		}
		if (request.getParameter(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt(request.getParameter(HOSPITAL_ID));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", usergroupHospitalId);
		generalMap.put("userGroupId", userGroupId);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("flag", true);

		Map<String, Object> listMap = new HashMap<String, Object>();
		listMap = userMasterHandlerService
				.checkForExistingGroupHospital(generalMap);
		List duplicateGroupHospitalList = new ArrayList();

		if (listMap.get("duplicateGroupHospitalList") != null) {
			duplicateGroupHospitalList = (List) listMap
					.get("duplicateGroupHospitalList");
		}

		boolean dataUpdated = false;
		if ((duplicateGroupHospitalList.size() == 0 || duplicateGroupHospitalList == null)) {
			dataUpdated = userMasterHandlerService
					.editUsergroupHospital(generalMap);
			if (dataUpdated == true) {
				message = "Record Updated Successfully !!";
			} else {
				message = "Record Cant be updated !!";
			}
		} else if (duplicateGroupHospitalList.size() != 0) {

			message = "User Group Name and Hospital Name already exist.";
		}

		try {
			map = userMasterHandlerService.showUsergroupHospitalJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_GROUP_HOSPITAL_JSP;
		title = "Edit User Group Hospital";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteUsergroupHospital(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int usergroupHospitalId = 0;
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
			usergroupHospitalId = Integer.parseInt(request
					.getParameter(COMMON_ID));
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
		dataDeleted = userMasterHandlerService.deleteUsergroupHospital(
				usergroupHospitalId, generalMap);

		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		try {
			map = userMasterHandlerService.showUsergroupHospitalJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_GROUP_HOSPITAL_JSP;
		title = "Delete User Group Hospital";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchUsergroupHospital(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String groupName = "";
		String hospitalName = "";
		String searchField = null;

		if (request.getParameter(USER_GROUP_NAME) != null
				&& !(request.getParameter(USER_GROUP_NAME).equals(""))) {
			groupName = request.getParameter(USER_GROUP_NAME);
		}
		if (request.getParameter(HOSPITAL_NAME) != null
				&& !(request.getParameter(HOSPITAL_NAME).equals(""))) {
			hospitalName = request.getParameter(HOSPITAL_NAME);
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
			groupName = searchField;
			hospitalName = null;
		} else {
			groupName = null;
			hospitalName = searchField;
		}
		map = userMasterHandlerService.searchUsergroupHospital(groupName,
				hospitalName);

		jsp = USER_GROUP_HOSPITAL_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("groupName", groupName);
		map.put("hospitalName", hospitalName);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------------Hospital
	// Master--------------------------

	public ModelAndView searchHospital(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String hospitalCode = null;
		String hospitalName = null;
		String searchField = null;
		String searchField1 = null;
		String searchField2 = null;
		int disId=0;
		int instiType=0;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			hospitalCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			hospitalName = request.getParameter(SEARCH_NAME);
		}
		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}
			if (request.getParameter(SEARCH_FIELD+"1") != null
					&& !(request.getParameter(SEARCH_FIELD+"1").equals(""))) {
				searchField1 = request.getParameter(SEARCH_FIELD+"1");
			}
			if (request.getParameter(SEARCH_FIELD+"2") != null
					&& !(request.getParameter(SEARCH_FIELD+"2").equals(""))) {
				searchField2 = request.getParameter(SEARCH_FIELD+"2");
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
			hospitalCode = searchField;
			hospitalName = null;

		} else if (searchRadio == 2){
			hospitalCode = null;
			hospitalName = searchField;
		} else if (searchRadio == 3){
			hospitalCode = null;
			hospitalName = null;
			disId=Integer.parseInt(searchField1);
		} else if (searchRadio == 4){
			hospitalCode = null;
			hospitalName = null;
			instiType=Integer.parseInt(searchField2);
		}
		
		map = userMasterHandlerService.searchHospital(hospitalCode,	hospitalName,disId,instiType);
				

		jsp = HOSPITAL_MASTER_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("hospitalCode", hospitalCode);
		map.put("hospitalName", hospitalName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showHospitalJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map map = new HashMap();
		map = userMasterHandlerService.showHospitalJsp();
		String jsp = "hospital";
		jsp += ".jsp";
		title = "Hospital";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addHospital(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasHospital masHospital = new MasHospital();
		int userId=0;
		int hospitalTypeId=0;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
		session = request.getSession();
	
		
		String contactNumber = "";
		String hospitalAddress = "";
		String sparkId="";
		String street="";
		int locality=0;
		String institutionShortName="";
		int districtId=0;
		int electricalSectionId=0;
		int talukId=0;
		int pincode=0;
		String  landLine="";
		int assembly=0;
		int parliament=0;
		int ward=0;
		int village=0;
		int panchayat=0;
		int parentInstitutionId=0;
		int hoi=0;
		int postOffice=0;
		String lsgType="";
		String lsgName="";
		String emailId="";
		int sanctionBed=0;
		int rank=0;
		String longitude="";
		String latitude="";
		String bBAvailability="";
		String counterWiseTokenDisplay="";
		String multiLab=""; // added by amit das on 17-07-2017
		//if ip an port not present then it should be null
		String serverIp=null;
		String serverPort=null;
		String clientIp=null;
		String clientPort=null;
		String imeiNo=null;
		String specialityType="";
		if (request.getParameter("specialityType") != null) {
			specialityType = request.getParameter("specialityType");
		}
		if (request.getParameter("headInst") != null && !(request.getParameter("headInst").equals(""))) {
			rank = Integer.parseInt(request.getParameter("headInst").toString().trim());
		}
		if (request.getParameter("bbAvailability2") != null) {
			bBAvailability = request.getParameter("bbAvailability2");
		}
		if (request.getParameter("counterWiseTokenDisplay") != null) {
			counterWiseTokenDisplay = request.getParameter("counterWiseTokenDisplay");
		}
		
		// added by amit das on 17-07-2017
		if (request.getParameter("multiLab") != null) {
			multiLab = request.getParameter("multiLab");
		}
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(ADDRESS) != null) {
			hospitalAddress = request.getParameter(ADDRESS);
		}
		if (request.getParameter(CONTACT_NUMBER) != null) {
			contactNumber = request.getParameter(CONTACT_NUMBER);
		}
		if (request.getParameter("sanctionBed") != null && !(request.getParameter("sanctionBed").equals("0"))  && !(request.getParameter("sanctionBed").equals(""))) {
			
			sanctionBed =Integer.parseInt(request.getParameter("sanctionBed"));
		}
		
		if (request.getParameter("hospitalTypeId") != null && !(request.getParameter("hospitalTypeId").equals("0"))) {
		
			hospitalTypeId =Integer.parseInt(request.getParameter("hospitalTypeId"));
		}
		
		if (request.getParameter("districtId") != null && !(request.getParameter("districtId").equals("0"))) {
				
			districtId =Integer.parseInt(request.getParameter("districtId"));
				}
		
		if ((!request.getParameter("electricalSectionId").equals("0")) && request.getParameter("electricalSectionId") != null && !(request.getParameter("electricalSectionId").equals(""))) {
				electricalSectionId =Integer.parseInt(request.getParameter("electricalSectionId"));
				}
		
		if (request.getParameter("talukId") != null && !(request.getParameter("talukId").equals("0"))) {
			
			talukId =Integer.parseInt(request.getParameter("talukId"));
				}
		
if (request.getParameter("village") != null && !(request.getParameter("village").equals("0"))) {
			
	village =Integer.parseInt(request.getParameter("village"));
				}
		
		
if (request.getParameter("parentInstitute") != null && !(request.getParameter("parentInstitute").equals("0"))) {
			
	parentInstitutionId =Integer.parseInt(request.getParameter("parentInstitute"));
				}
if (request.getParameter("hoi") != null && !(request.getParameter("hoi").equals("0"))) {
	
	hoi =Integer.parseInt(request.getParameter("hoi"));
				}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}

		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		
		
		if (request.getParameter(CHANGED_DATE) != null	&& !(request.getParameter(CHANGED_DATE).equals(""))) {
				currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));			
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("sparkId") != null  && !(request.getParameter("sparkId").equals("0"))) { 
			sparkId = request.getParameter("sparkId");
		}
		if (request.getParameter("street") != null  && !(request.getParameter("street").equals(""))) { 
			street = request.getParameter("street");
		}
		if (request.getParameter("landLine") != null  && !(request.getParameter("landLine").equals(""))) { 
			landLine = request.getParameter("landLine");
		}
		if (request.getParameter("locality") != null && !(request.getParameter("locality").equals(""))) {
			locality = Integer.parseInt(request.getParameter("locality"));
		}
		

		if (request.getParameter("lsg") != null && !(request.getParameter("lsg").equals(""))) {
			lsgType = request.getParameter("lsg");
		}
		if (request.getParameter("lsgName") != null && !(request.getParameter("lsgName").equals(""))) {
			lsgName = request.getParameter("lsgName");
		}
		if (request.getParameter("pincode") != null && !(request.getParameter("pincode").equals(""))) {
			pincode = Integer.parseInt(request.getParameter("pincode"));
		}
		if (request.getParameter("assembly") != null && !(request.getParameter("assembly").equals(""))) {
			assembly = Integer.parseInt(request.getParameter("assembly"));
		}
		if (request.getParameter("panchayat") != null && !(request.getParameter("panchayat").equals(""))) {
			panchayat = Integer.parseInt(request.getParameter("panchayat"));
		}
		
		
		if (request.getParameter("email") != null && !(request.getParameter("email").equals(""))) {
			emailId =request.getParameter("email");
		}
		if (request.getParameter("parliament") != null && !(request.getParameter("parliament").equals(""))) {
			parliament =Integer.parseInt(request.getParameter("parliament"));
		}
		if (request.getParameter("wardId") != null && !(request.getParameter("wardId").equals(""))) {
			ward =Integer.parseInt(request.getParameter("wardId"));
		}
		if (request.getParameter("postOfficeId") != null && !(request.getParameter("postOfficeId").equals(""))) {
			postOffice =Integer.parseInt(request.getParameter("postOfficeId"));
		}
		if (request.getParameter("institutionShortName") != null && !(request.getParameter("institutionShortName").equals(""))) {
			institutionShortName = request.getParameter("institutionShortName");
		}
		String kmsclInstituteCode = "";
		String kmsclCategory = "";
		if (request.getParameter("kmsclInstituteCode") != null && !(request.getParameter("kmsclInstituteCode").equals(""))) {
			kmsclInstituteCode = request.getParameter("kmsclInstituteCode");
		}
	
		if (request.getParameter("kmsclCategory") != null && !(request.getParameter("kmsclCategory").equals(""))) {
			kmsclCategory = request.getParameter("kmsclCategory");
		}
	
		if (request.getParameter("longitude") != null && !(request.getParameter("longitude").equals(""))) {
			longitude = request.getParameter("longitude");

		} 
		if (request.getParameter("latitude") != null && !(request.getParameter("latitude").equals(""))) {
			latitude = request.getParameter("latitude");
	
		}
		if (request.getParameter("serverIp") != null && !(request.getParameter("serverIp").equals(""))) {
			serverIp = request.getParameter("serverIp");
			masHospital.setServerIp(serverIp);
	
		}	
		if (request.getParameter("serverPort") != null && !(request.getParameter("serverPort").equals(""))) {
			serverPort = request.getParameter("serverPort");
			masHospital.setServerPort(serverPort);
	
		}
		if (request.getParameter("clientIp") != null && !(request.getParameter("clientIp").equals(""))) {
			clientIp = request.getParameter("clientIp");
			masHospital.setClientIp(clientIp);
		}
		if (request.getParameter("clientPort") != null && !(request.getParameter("clientPort").equals(""))) {
			clientPort = request.getParameter("clientPort");
			masHospital.setClientPort(clientPort);
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
		if (request.getParameter("imeiNo") != null && !request.getParameter("imeiNo").equals("")) {
			imeiNo = request.getParameter("imeiNo");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);
		// generalMap.put("hospitalAddress", hospitalAddress);
		// generalMap.put("contactNumber", contactNumber);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List hospitalCodeList = new ArrayList();
		List hospitalNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			hospitalCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			hospitalNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((hospitalCodeList.size() == 0 || hospitalCodeList == null)
				&& (hospitalNameList.size() == 0 || hospitalNameList == null)) {
			masHospital.setHospitalCode(code);
			masHospital.setHospitalName(name);
			masHospital.setHospitalNameChangeCount(0);
			masHospital.setAddress(hospitalAddress);
			masHospital.setContactNumber(contactNumber);
			masHospital.setStatus("y");
			masHospital.setImergencyNumber(landLine);
			masHospital.setHospitalTypeChangeCount(0);
			MasHospitalType hospitalType = new MasHospitalType();
			hospitalType.setId(hospitalTypeId);
			masHospital.setHospitalType(hospitalType);
			masHospital.setLongitude(longitude);
			masHospital.setLatitude(latitude);
			masHospital.setShortName(institutionShortName);
			masHospital.setAdd2Street(street);
			masHospital.setSanctionBed(sanctionBed);
			if(locality>0){
			PhMasLocality l = new PhMasLocality();
			l.setId(locality);
			masHospital.setAdd3Locality(l);
			}
			if(districtId>0){
			MasDistrict md = new MasDistrict();
			md.setId(districtId);
			masHospital.setDistrict(md);
			}
			if(electricalSectionId!=0){
			PhMasElectricalSection es = new PhMasElectricalSection();
			es.setId(electricalSectionId);
			masHospital.setElectricalSection(es);
			}
			masHospital.setSparkId(sparkId);
			
			masHospital.setEmailId(emailId);
			
			if(talukId>0){
			MasTaluk mt = new MasTaluk();
			mt.setId(talukId);
			masHospital.setTaluk(mt);
			masHospital.setPinCode(pincode);
			}
			if(assembly>0){
			PhMasParliyamentAssembly a = new PhMasParliyamentAssembly();
			a.setId(assembly);
			masHospital.setAssembly(a);
			}
			
			if(parliament>0){
			PhMasParliyamentAssembly p = new PhMasParliyamentAssembly();
			p.setId(parliament);
			masHospital.setParliament(p);
			}
			if(postOffice>0){
			MasPostCode po = new MasPostCode();
			po.setId(postOffice);
			masHospital.setPostOffice(po);
			}
			if(ward>0){
			MasWard w = new MasWard();
			w.setId(ward);
			masHospital.setWard(w);
			}
			if(village>0){
			MasVillage v= new MasVillage();
			v.setId(village);
			masHospital.setVillage(v);
			}
			Users users = new Users();
			users.setId(userId);
			masHospital.setLastChgBy(users);
			masHospital.setBbAvailable(bBAvailability);
			
			if(counterWiseTokenDisplay!=null){
				masHospital.setCounterWiseTokenDisplay("y");
			}else{
				masHospital.setCounterWiseTokenDisplay("n");
			}
			
			if(multiLab!=null){
				masHospital.setMultiLab("y");
			}else{
				masHospital.setMultiLab("n");
			}
			
		// Added New Field
			
		if(rank != 0){
			MasRank masRank=new MasRank();
			masRank.setId(rank);
			masHospital.setInstitutionRank(masRank);
		}
			
			if(parentInstitutionId!=0){
			MasHospital parentIns = new MasHospital();
			parentIns.setId(parentInstitutionId);
			masHospital.setParentInstitute(parentIns);
			}
			if(hoi !=0){
				MasEmployee headOfIns = new MasEmployee();
				headOfIns.setId(hoi);
				masHospital.setHod(headOfIns);
			}else{
				masHospital.setHod(null);
			}
			if(kmsclCategory != null){
				masHospital.setKmsclCategory(kmsclCategory);
			}
			if(kmsclInstituteCode != null){
				masHospital.setKmsclInstituteCode(kmsclInstituteCode);
			}
			masHospital.setSpecialityType(specialityType);
			masHospital.setLsgType(lsgType);
			masHospital.setLsgName(lsgName);
			masHospital.setLastChgDate(currentDate);
			masHospital.setLastChgTime(currentTime);
			if(null !=imeiNo && !imeiNo.equals(""))
			masHospital.setImeiNo(Long.parseLong(imeiNo));
			successfullyAdded = userMasterHandlerService
					.addHospital(masHospital);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((hospitalCodeList.size() != 0 || hospitalCodeList != null)
				|| (hospitalNameList.size() != 0) || hospitalNameList != null) {
			if ((hospitalCodeList.size() != 0 || hospitalCodeList != null)
					&& (hospitalNameList.size() == 0 || hospitalNameList == null)) {

				message = "Institution Code  already exists.";
			} else if ((hospitalNameList.size() != 0 || hospitalNameList != null)
					&& (hospitalCodeList.size() == 0 || hospitalCodeList == null)) {

				message = "Institution Name already exists.";
			} else if ((hospitalCodeList.size() != 0 || hospitalCodeList != null)
					&& (hospitalNameList.size() != 0 || hospitalNameList != null)) {

				message = "Institution Code and Institution Name already exist.";
			}
		}

		try {
			map = userMasterHandlerService.showHospitalJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "hospital";
		title = "Add Hospital";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editHospital(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		session = request.getSession();
		String multiLab=""; 
		String hospitalCode = "";
		String hospitalName = "";
		int userGroupsId = 0;
		String hospitalAddress = "";
		String contactNumber = "";
		String changedTime = "";
		Date changedDate = null;
		int hospitalTypeId=0;
		String sparkId="";
		String street="";
		int locality=0;
		String institutionShortName="";
		int districtId=0;
		int talukId=0;
		int pincode=0;
		int assembly=0;
		int parliament=0;
		int ward=0;
		int village=0;
		int panchayat=0;
		int postOffice=0;
		int parentInstitutionId=0;
		int hoi=0;
		int userId=0;
		String lsgType="";
		String lsgName="";
		String emailId="";
		String landLine="";
		int sanctionBed=0;
		int electricalSectionId=0;
		String longitude="";
		String latitude="";
		String bbAvailability2="";
		//if ip an port not present then it should be null
		String serverIp=null;
		String serverPort=null;
		String clientIp=null;
		String clientPort=null;
		String imeiNo=null;
		String counterWiseTokenDisplay=null;
		String specialityType="";
		String utid="";
		String mac="";
		String sim="";
		if (request.getParameter("specialityType") != null) {
			specialityType = request.getParameter("specialityType");
		}
		if(request.getParameter("bbAvailability2")!=null){
			bbAvailability2=request.getParameter("bbAvailability2");
		}
		if(request.getParameter("counterWiseTokenDisplay")!=null){
			counterWiseTokenDisplay=request.getParameter("counterWiseTokenDisplay");
		}
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			userGroupsId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			hospitalCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			hospitalName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(ADDRESS) != null) {
			hospitalAddress = request.getParameter(ADDRESS);
		}
		if (request.getParameter(CONTACT_NUMBER) != null) {
			contactNumber = request.getParameter(CONTACT_NUMBER);
		}
		if (request.getParameter("multiLab") != null) {
			multiLab = request.getParameter("multiLab");
		}
		if (request.getParameter("landLine") != null  && !(request.getParameter("landLine").equals(""))) { 
			landLine = request.getParameter("landLine");
		}
		
		if (request.getParameter("sanctionBed") != null && !(request.getParameter("sanctionBed").equals("0"))  && !(request.getParameter("sanctionBed").equals(""))) {
			
			sanctionBed =Integer.parseInt(request.getParameter("sanctionBed"));
		}
		if (!(request.getParameter("electricalSectionId").equals("0")) && request.getParameter("electricalSectionId") != null && !(request.getParameter("electricalSectionId").equals(""))) {
			
			electricalSectionId =Integer.parseInt(request.getParameter("electricalSectionId"));
				}
		/*if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}*/
		if (request.getParameter("village") != null && !(request.getParameter("village").equals("0"))) {
			
			village =Integer.parseInt(request.getParameter("village"));
						}
				
		if (request.getParameter("hospitalTypeId") != null && !(request.getParameter("hospitalTypeId").equals("0"))) {
		
			hospitalTypeId =Integer.parseInt(request.getParameter("hospitalTypeId"));
		}

		if (request.getParameter("lsg") != null && !(request.getParameter("lsg").equals(""))) {
			lsgType = request.getParameter("lsg");
		}
		if (request.getParameter("lsgName") != null && !(request.getParameter("lsgName").equals(""))) {
			lsgName = request.getParameter("lsgName");
		}
		
		if (request.getParameter("sparkId") != null  && !(request.getParameter("sparkId").equals("0"))) { 
			sparkId = request.getParameter("sparkId");
		}

		if (request.getParameter("email") != null && !(request.getParameter("email").equals(""))) {
			emailId =request.getParameter("email");
		}
		if (request.getParameter("street") != null  && !(request.getParameter("street").equals(""))) { 
			street = request.getParameter("street");
		}
		if (request.getParameter("locality") != null && !(request.getParameter("locality").equals("")) && !(request.getParameter("locality").equals("0"))) {
			locality = Integer.parseInt(request.getParameter("locality"));
		}
		
		if (request.getParameter("pincode") != null && !(request.getParameter("pincode").equals(""))) {
			pincode = Integer.parseInt(request.getParameter("pincode"));
		}
		if (request.getParameter("assembly") != null && !(request.getParameter("assembly").equals("")) && !(request.getParameter("assembly").equals("0"))) {
			assembly = Integer.parseInt(request.getParameter("assembly"));
		}
		if (request.getParameter("panchayat") != null && !(request.getParameter("panchayat").equals("")) && !(request.getParameter("panchayat").equals("0"))) {
			panchayat = Integer.parseInt(request.getParameter("panchayat"));
		}
		if (request.getParameter("parliament") != null && !(request.getParameter("parliament").equals("")) && !(request.getParameter("parliament").equals("0"))) {
			parliament =Integer.parseInt(request.getParameter("parliament"));
		}
		if (request.getParameter("wardId") != null && !(request.getParameter("wardId").equals("")) && !(request.getParameter("wardId").equals("0"))) {
			ward =Integer.parseInt(request.getParameter("wardId"));
		}
		if (request.getParameter("postOfficeId") != null && !(request.getParameter("postOfficeId").equals("")) && !(request.getParameter("postOfficeId").equals("0"))) {
			postOffice =Integer.parseInt(request.getParameter("postOfficeId"));
		}
		if (request.getParameter("districtId") != null && !(request.getParameter("districtId").equals("0"))) {
			
			districtId =Integer.parseInt(request.getParameter("districtId"));
				}
		if (request.getParameter("talukId") != null && !(request.getParameter("talukId").equals("0"))) {
			
			talukId =Integer.parseInt(request.getParameter("talukId"));
				}
		if (request.getParameter("parentInstitute") != null && !(request.getParameter("parentInstitute").equals("0"))) {
			
			parentInstitutionId =Integer.parseInt(request.getParameter("parentInstitute"));
						}
		if (request.getParameter("hoi") != null && !(request.getParameter("hoi").equals("0"))) {
			
			hoi =Integer.parseInt(request.getParameter("hoi"));
						}
		if (request.getParameter("institutionShortName") != null && !(request.getParameter("institutionShortName").equals(""))) {
			institutionShortName = request.getParameter("institutionShortName");
		}
		String kmsclInstituteCode = "";
		String kmsclCategory = "";
		if (request.getParameter("kmsclInstituteCode") != null && !(request.getParameter("kmsclInstituteCode").equals(""))) {
			kmsclInstituteCode = request.getParameter("kmsclInstituteCode");
		}
		if (request.getParameter("kmsclCategory") != null && !(request.getParameter("kmsclCategory").equals(""))) {
			kmsclCategory = request.getParameter("kmsclCategory");
		}
		if (request.getParameter("longitude") != null && !(request.getParameter("longitude").equals(""))) {
			longitude = request.getParameter("longitude");
		}
		if (request.getParameter("latitude") != null && !(request.getParameter("latitude").equals(""))) {
			latitude = request.getParameter("latitude");
		}
		if (request.getParameter("serverIp") != null && !(request.getParameter("serverIp").equals(""))) {
			serverIp = request.getParameter("serverIp"); 
	
		}	
		if (request.getParameter("serverPort") != null && !(request.getParameter("serverPort").equals(""))) {
			serverPort = request.getParameter("serverPort"); 
	
		}
		if (request.getParameter("clientIp") != null && !(request.getParameter("clientIp").equals(""))) {
			clientIp = request.getParameter("clientIp"); 
		}
		if (request.getParameter("clientPort") != null && !(request.getParameter("clientPort").equals(""))) {
			clientPort = request.getParameter("clientPort"); 
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
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("sim") != null) {
			sim = request.getParameter("sim");
		}
		if (request.getParameter("mac") != null) {
			mac = request.getParameter("mac");
		}
		if (request.getParameter("utid") != null) {
			utid = request.getParameter("utid");
		}
		if (request.getParameter("imeiNo") != null) {
			imeiNo = request.getParameter("imeiNo");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		
		generalMap.put("utid", utid);
		generalMap.put("sim", sim);
		generalMap.put("mac", mac);
		generalMap.put("imeiNo", imeiNo);
		generalMap.put("id", userGroupsId);
		generalMap.put("hospitalCode", hospitalCode);
		generalMap.put("name", hospitalName);
		generalMap.put("hospitalAddress", hospitalAddress);
		generalMap.put("contactNumber", contactNumber);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("specialityType", specialityType);
		
		generalMap.put("lsgType", lsgType);
		generalMap.put("lsgName", lsgName);
		generalMap.put("landLine", landLine);
		generalMap.put("sparkId", sparkId);
		generalMap.put("electricalSectionId", electricalSectionId);
		generalMap.put("sanctionBed",sanctionBed);
		generalMap.put("emailId", emailId);
		generalMap.put("locality", locality);
		generalMap.put("ward", ward);
		generalMap.put("postOffice", postOffice);
		generalMap.put("panchayat", panchayat);
		generalMap.put("village", village);
		generalMap.put("street", street);
		generalMap.put("pincode", pincode);
		generalMap.put("assembly", assembly);
		generalMap.put("parliament", parliament);
		generalMap.put("districtId", districtId);
		generalMap.put("hospitalTypeId", hospitalTypeId);
		generalMap.put("talukId", talukId);
		generalMap.put("institutionShortName", institutionShortName);
		generalMap.put("parentInstitutionId", parentInstitutionId);
		generalMap.put("kmsclInstituteCode", kmsclInstituteCode);
		generalMap.put("kmsclCategory", kmsclCategory);
		generalMap.put("longitude", longitude);
		generalMap.put("latitude", latitude);
		generalMap.put("hoi", hoi);
		generalMap.put("multiLab", multiLab);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		generalMap.put("bbAvailability2", bbAvailability2);
		generalMap.put("counterWiseTokenDisplay", counterWiseTokenDisplay);
		generalMap.put("serverIp", serverIp);
		generalMap.put("serverPort", serverPort);
		generalMap.put("clientIp", clientIp);
		generalMap.put("clientPort", clientPort);
		
		
		listMap = userMasterHandlerService.checkForExistingMasters(generalMap);
		
		

		List hospitalCodeList = new ArrayList();
		List hospitalNameList = new ArrayList();

		if (listMap.get("hospitalCodeList") != null) {
			hospitalCodeList = (List) listMap.get("hospitalCodeList");
		}
		if (listMap.get("hospitalNameList") != null) {
			hospitalNameList = (List) listMap.get("hospitalNameList");
		}
		
		//List existingHospitalNameList = (List) listMap	.get("duplicateMastersList");
		boolean dataUpdated = false;
		
		if ((hospitalCodeList.size() == 0 || hospitalCodeList == null)
				&& (hospitalNameList.size() == 0 || hospitalNameList == null)) {
		//if (existingHospitalNameList.size() == 0) {
			dataUpdated = userMasterHandlerService.editHospitalToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		}else if ((hospitalCodeList.size() != 0 || hospitalCodeList != null)
				|| (hospitalNameList.size() != 0) || hospitalNameList != null) {
			if ((hospitalCodeList.size() != 0 || hospitalCodeList != null)
					&& (hospitalNameList.size() == 0 || hospitalNameList == null)) {

				message = "Institution Code  already exists.";
			} else if ((hospitalNameList.size() != 0 || hospitalNameList != null)
					&& (hospitalCodeList.size() == 0 || hospitalCodeList == null)) {

				/*message = "Institution Name already exists.";*/
				dataUpdated = userMasterHandlerService.editHospitalToDatabase(generalMap);

				if (dataUpdated == true) {
					message = "Data updated Successfully !!";
				} else {
					message = "Data Cant Be Updated !!";
				}
				
			} else if ((hospitalCodeList.size() != 0 || hospitalCodeList != null)
					&& (hospitalNameList.size() != 0 || hospitalNameList != null)) {

				message = "Institution Code and Institution Name already exist.";
			}
		}
		url = "/security/security/user?method=showHospitalJsp";

		try {
			map = userMasterHandlerService.showHospitalJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "hospital";
		title = "update Hospital";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteHospital(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int hospitalId = 0;
		String message = null;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session = request.getSession();
		session = request.getSession();
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			hospitalId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		/*if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}*/
		int userId=0;
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		
		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = userMasterHandlerService.deleteHospital(hospitalId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/security/security/user?method=showHospitalJsp";

		try {
			map = userMasterHandlerService.showHospitalJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "hospital";
		title = "delete Hospital";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------------------------User Group Maintenance
	// --------------------------------------------------
	public ModelAndView showUserHospitalMaintenanceJsp(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession(true);
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		generalMap.put("hospitalId", hospitalId);
		map = userMasterHandlerService
				.showUserHospitalMaintenanceJsp(generalMap);
		jsp = USER_HOSPITAL_MAINTENANCE_JSP;
		jsp += ".jsp";
		title = "User Hospital Maintenance";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * addUserHospitalMaintenance(HttpServletRequest request,
	 * HttpServletResponse response) { Map<String,Object> map = new
	 * HashMap<String,Object>(); UserUsergroupHospital masUserUsergroupHospital
	 * = new UserUsergroupHospital(); int usersId=0; int hospitalId=0; int
	 * groupId=0; String changedBy = ""; Map<String, Object> listMap=new
	 * HashMap<String, Object>(); Map<String, Object> generalMap = new
	 * HashMap<String, Object>(); Date currentDate = new Date(); Date validUpto
	 * = new Date(); if (request.getParameter(USER_ID) != null) { usersId =
	 * Integer.parseInt(request.getParameter(USER_ID));
	 * } if
	 * (request.getParameter(HOSPITAL_ID) != null) { hospitalId =
	 * Integer.parseInt(request.getParameter(HOSPITAL_ID)); } if
	 * (request.getParameter(GROUP_ID) != null) { groupId =
	 * Integer.parseInt(request.getParameter(GROUP_ID)); }
	 * if(request.getParameter(CHANGED_BY) != null &&
	 * !(request.getParameter(CHANGED_BY).equals(""))){ changedBy =
	 * request.getParameter(CHANGED_BY); } if(request.getParameter(CHANGED_DATE)
	 * != null && !(request.getParameter(CHANGED_DATE).equals(""))){ currentDate
	 * = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE)); }
	 * if(request.getParameter(CHANGED_TIME) != null &&
	 * !(request.getParameter(CHANGED_TIME).equals(""))){ currentTime =
	 * request.getParameter(CHANGED_TIME); } if(request.getParameter(VALID_DATE)
	 * != null && !(request.getParameter(VALID_DATE).equals(""))){ validUpto =
	 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter(VALID_DATE)); }
	 * 
	 * 
	 * 
	 * map=userMasterHandlerService.getGroupHospitalIdFromUsergroupHospital(groupId
	 * , hospitalId);
	 * 
	 * List userGroupList= new ArrayList();
	 * 
	 * userGroupList=(List)map.get("groupHospitalIdList");
	 * 
	 * UsergroupHospital
	 * usergroupHospital=(UsergroupHospital)userGroupList.get(0);
	 * 
	 * int groupHospitalId=usergroupHospital.getId();
	 * 
	 * generalMap.put("changedBy", changedBy); generalMap.put("currentDate",
	 * currentDate); generalMap.put("currentTime", currentTime);
	 * generalMap.put("usersId", usersId); /*generalMap.put("hospitalId",
	 * hospitalId); generalMap.put("groupId", groupId);
	 */
	/*
	 * generalMap.put("groupHospitalId", groupHospitalId); listMap =
	 * userMasterHandlerService.checkForExistingHospital(generalMap); List
	 * duplicateHospitalList = new ArrayList();
	 * 
	 * if(listMap.get("duplicateHospitalList") != null){ duplicateHospitalList =
	 * (List)listMap.get("duplicateHospitalList"); } Users users = new Users();
	 * users.setId(usersId); masUserUsergroupHospital.setUser(users);
	 * boolean
	 * successfullyAdded = false; if((duplicateHospitalList.size() == 0 ||
	 * duplicateHospitalList == null)) {
	 * 
	 * 
	 * 
	 * usergroupHospital.setId(groupHospitalId);
	 * masUserUsergroupHospital.setGroupHospital(usergroupHospital);
	 * 
	 * masUserUsergroupHospital.setValidUpto(validUpto);
	 * masUserUsergroupHospital.setStatus("y");
	 * masUserUsergroupHospital.setLastChgBy(changedBy);
	 * masUserUsergroupHospital.setLastChgDate(currentDate);
	 * masUserUsergroupHospital.setLastChgTime(currentTime);
	 * 
	 * successfullyAdded =
	 * userMasterHandlerService.addUserHospitalMaintenance(masUserUsergroupHospital
	 * ); if(successfullyAdded){ message="Record Added Successfully !!"; }else{
	 * message="Try Again !!"; } } else if(duplicateHospitalList.size() != 0 ){
	 * 
	 * 
	 * message = "User Name and Hospital Name and Group Name already exist."; }
	 * 
	 * try{ map = userMasterHandlerService.showUserHospitalMaintenanceJsp();
	 * 
	 * }catch (Exception e) { e.printStackTrace(); }
	 * jsp=USER_HOSPITAL_MAINTENANCE_JSP; title="Add User Hospital Maintenance";
	 * jsp += ".jsp"; map.put("contentJsp", jsp); map.put("title", title);
	 * map.put("message", message); return new ModelAndView("index", "map",
	 * map); }
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView addUserHospitalMaintenance(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		UserHospital userHospital = new UserHospital();
		List<Integer> hospitalIdList = new ArrayList<Integer>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int changedBy = 0;
		int userId=0;
		boolean successfullyAdded = false;
		HttpSession session = request.getSession();
		session = request.getSession();
		int count=box.getInt("count");
		if(count>=0){
			for(int i=0;i<=count;i++){
				if(box.getInt("hospitalId"+i)!=0){
					hospitalIdList.add(box.getInt("hospitalId"+i));
				}
			}
		}
		
		userId=box.getInt("userId");
		changedBy=box.getInt("changed_by");
		String loginName=box.getString("loginName");
		Date currentDate = new Date();
		String currentTime="";
		if(box.getString("changed_date")!=null && box.getString("changed_date")!=""){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(box.getString("changed_date"));
		}
		if(box.getString("changed_time")!=null && box.getString("changed_time")!=""){
			currentTime = box.getString("changed_time");
		}
		
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("userId", userId);
		generalMap.put("loginName", loginName);
		
		
		List<Integer> userhospList=new ArrayList<Integer>();
		
		
		if(hospitalIdList.size()>0){
			
			Map<String,Object> hospMap=userMasterHandlerService.getUserHospitalByUserId(userId);
			if(hospMap.get("userHospitals")!=null){
				userhospList=(List<Integer>)hospMap.get("userHospitals");
			}
			if(userhospList.size()>0){
				userhospList.removeAll(hospitalIdList);
			}
			
			for(Integer hospitalId:hospitalIdList){
				if(hospitalId>0){
					generalMap.put("hospitalId", hospitalId);
					successfullyAdded=userMasterHandlerService.addUserHospitalMaintenance(generalMap);
				}
			}
			
		}else {
			generalMap.put("removeAll","yes");
			successfullyAdded=userMasterHandlerService.addUserHospitalMaintenance(generalMap);
		}
		
		if(userhospList.size()>0){
			for(Integer hospId:userhospList){
				generalMap.put("hospitalId", 0);
				generalMap.put("removeHosp", hospId);
				successfullyAdded=userMasterHandlerService.addUserHospitalMaintenance(generalMap);
			}
			
		}
		
		String message="";
		if(successfullyAdded){
			message="Data Submitted Successfully !";
		}else{
			message="Error Occured While Submitting Data !";
		}
		
		map.put("message", message);
		map.put("loginName", loginName);
		
		map2=userMasterHandlerService.searchUserHospitalMaintenance(loginName);
 
		map.putAll(map2);
		
		jsp = USER_HOSPITAL_MAINTENANCE_JSP;
		title = "Add User Hospital Maintenance";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editUserHospitalMaintenance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		//int groupId = 0;
		int usersId = 0;
		int hospitalId = 0;
			
		HttpSession session = request.getSession();
		session = request.getSession(true);
		int userId = (Integer)session.getAttribute("userId");
		Date changedDate = null;
		String changedTime = "";
		//Date validUpto = null;
		int userHospitalMaintenanceId = 0;
		if (request.getParameter(COMMON_ID) != null) {
			userHospitalMaintenanceId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(USER_ID) != null) {
			usersId = Integer.parseInt(request.getParameter(USER_ID));
		}
		if (request.getParameter(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt(request.getParameter(HOSPITAL_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		/*if (request.getParameter(VALID_DATE) != null
				&& !(request.getParameter(VALID_DATE).equals(""))) {
			validUpto = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(VALID_DATE));
		}
		if (request.getParameter(GROUP_ID) != null) {
			groupId = Integer.parseInt(request.getParameter(GROUP_ID));
		}*/
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		/*map = userMasterHandlerService.getGroupHospitalIdFromUsergroupHospital(groupId, hospitalId);
		List userGroupList = (List) map.get("groupHospitalIdList");
		UsergroupHospital usergroupHospital = (UsergroupHospital) userGroupList.get(0);
		int groupHospitalId = usergroupHospital.getId();*/

		generalMap.put("id", userHospitalMaintenanceId);
		generalMap.put("userId", userId);
		//generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("usersId", usersId);
		generalMap.put("flag", true);
		//generalMap.put("validUpto", validUpto);
		//generalMap.put("groupHospitalId", groupHospitalId);
		generalMap.put("hospitalId", hospitalId);
		

		Map<String, Object> listMap = new HashMap<String, Object>();
		listMap = userMasterHandlerService.checkForExistingHospital(generalMap);
		List duplicateHospitalList = new ArrayList();

		if (listMap.get("duplicateHospitalList") != null) {
			duplicateHospitalList = (List) listMap.get("duplicateHospitalList");
		}

		boolean dataUpdated = false;
		if ((duplicateHospitalList.size() == 0 || duplicateHospitalList == null)) {
			dataUpdated = userMasterHandlerService
					.editUserHospitalMaintenance(generalMap);
			if (dataUpdated == true) {
				message = "Record Updated Successfully !!";
			} else {
				message = "Record Cant be updated !!";
			}
		} else if (duplicateHospitalList.size() != 0) {

			message = "User Name and Hospital Name and Group Name already exist.";
		}

		try {
			map = userMasterHandlerService.showUserHospitalMaintenanceJsp(generalMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_HOSPITAL_MAINTENANCE_JSP;
		title = "Edit User Hospital Maintenance";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteUserHospitalMaintenance(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int userHospitalMaintenanceId = 0;
		String message = null;
		//String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session = request.getSession();
		session = request.getSession(true);
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		int userId= (Integer) session.getAttribute("userId");
		Map<String, Object> generalMap = new HashMap<String, Object>();
		generalMap.put("hospitalId", hospitalId);

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			userHospitalMaintenanceId = Integer.parseInt(request
					.getParameter(COMMON_ID));
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
		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = userMasterHandlerService.deleteUserHospitalMaintenance(
				userHospitalMaintenanceId, generalMap);

		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		try {
			map = userMasterHandlerService
					.showUserHospitalMaintenanceJsp(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_HOSPITAL_MAINTENANCE_JSP;
		title = "Delete User Hospital Maintenance";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchUserHospitalMaintenance(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = "";
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				userName = request.getParameter(SEARCH_FIELD);
				map = userMasterHandlerService.searchUserHospitalMaintenance(userName);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		

		jsp = USER_HOSPITAL_MAINTENANCE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("userName", userName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getUserGroupForHospital(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = Integer.parseInt(request.getParameter(HOSPITAL_ID));
		List<Object> userGroupForHospitalList = new ArrayList<Object>();
		userGroupForHospitalList = userMasterHandlerService
				.getUserGroupForHospital(hospitalId);
		map.put("hospitalId", hospitalId);

		String jsp = "";
		String title = "";
		String message = "";

		if (userGroupForHospitalList.size() > 0) {
			session.setAttribute("hospitalId", hospitalId);
			map.put("hospitalId", hospitalId);
			map.put("userGroupForHospitalList", userGroupForHospitalList);

		} else {
			message = "Group is not available !!";
			map.put("error", message);
		}

		jsp = "responseForGroup";
		map.put("jsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	// ********************************************************************************//
	// ***************************** End Modules Written By
	// Mansi********************//
	// ********************************************************************************//

	// ==================================================================================================
	// ======================= start of application module by abha
	// =======================
	// ========================================================================================================
	public ModelAndView showApplicationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "";
		String title = "";
		String applicationId = "";
		String parentId = "";
		String parentName = "";
		if (request.getParameter(APPLICATION_ID) != null
				&& !(request.getParameter(APPLICATION_ID).equals(""))) {
			applicationId = request.getParameter(APPLICATION_ID);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasApplication> applicationList = new ArrayList<MasApplication>();
		List<UserGroups> groupList = new ArrayList<UserGroups>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List objectList = new ArrayList();
		applicationList = userMasterHandlerService.getApplicationList();
		groupList = userMasterHandlerService.getGroupList();
		hospitalList = userMasterHandlerService.getHospitallistList();
		objectList = userMasterHandlerService.getApplicationIdList();
		jsp = RequestConstants.APPLICATION_JSP;
		jsp += ".jsp";
		// map.put("parentName", parentName);
		map.put("objectList", objectList);
		map.put("applicationList", applicationList);
		map.put("groupList", groupList);
		map.put("hospitalList", hospitalList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	// method to add application in masApplication and GroupApplication and
	// userGroupHospital
	@SuppressWarnings("unchecked")
	public ModelAndView addApplication(HttpServletRequest request,
			HttpServletResponse response) {
		@SuppressWarnings("unused")
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		boolean successfullyAdded = false;

		infoMap.put("box", box);
		successfullyAdded = userMasterHandlerService.addApplication(infoMap);
		if (successfullyAdded == true) {
			message = "Applications Added Successfully !!";
			map = userMasterHandlerService.showUserList();
		} else {
			message = "Try Again !!";
		}
		jsp = MODULE_MANAGEMENT_JSP;
		url = "/hms/hms/user?method=showApplicationJsp";
		title = "Applications";
		jsp += ".jsp";
		map.put("url", url);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * public ModelAndView responseGroupList(HttpServletRequest request,
	 * HttpServletResponse response) {  Box box = HMSUtil.getBox(request); Map<String, Object> map = new
	 * HashMap<String, Object>();
	 * map=userMasterHandlerService.getGroupList(box); jsp="responseGroupList";
	 * return new ModelAndView(jsp,"map", map); }
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView searchAndEditApplication(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = SEARCH_AND_EDIT_APPLICATION;
		jsp += ".jsp";
		title = "Search Application";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getApplicationListByAutocomplete(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		String itemNameField = "";
		String autoHint = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(itemNameField) != null) {
			autoHint = (request.getParameter(itemNameField));

		}
		dataMap.put("autoHint", autoHint);
		map = userMasterHandlerService
				.getApplicationListByAutocomplete(dataMap);
		jsp = "resultForApplication";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView searchApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
	//	List<UsergroupHospital> groupList = new ArrayList<UsergroupHospital>();
		List<MasApplication> applicationList = new ArrayList<MasApplication>();
		String applicationName = "";
		String applicationId = "";
		if (request.getParameter(APPLICATION_ID) != null
				&& !(request.getParameter(APPLICATION_ID).equals(""))) {
			applicationId = request.getParameter(APPLICATION_ID);
		}
		int index1 = applicationId.indexOf("[");
		index1 = index1 + 1;
		int index2 = applicationId.indexOf("]");
		String appId = applicationId.substring(index1, index2);
		map = userMasterHandlerService.searchApplication(appId);
	//	groupList = userMasterHandlerService.getGroupList();
		applicationList = userMasterHandlerService.getApplicationList();
		jsp = SEARCH_AND_EDIT_APPLICATION;
		jsp += ".jsp";
		map.put("applicationList", applicationList);
	//	map.put("groupList", groupList);
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("applicationName", applicationName);
		map.put("applicationId", applicationId);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateApplication(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		MasApplication masApplication = new MasApplication();
		// GroupApplication groupApplication = new GroupApplication();
		String applicationId = "";
		String applicationName = "";
		String url = "";
		int orderNo = 0;
		String parentId = "";
		String status = "";
		int groupId = 0;
		int groupApplicationId = 0;
		String messageTOBeVisibleToTheUser = "";

		if (request.getParameter("app") != null) {
			applicationId = request.getParameter("app");
		}

		if (request.getParameter("appName") != null) {
			applicationName = request.getParameter("appName");
		}
		if ((request.getParameter("url") != null)) {
			url = request.getParameter("url");
		}
		if (request.getParameter("orderNo") != null) {
			orderNo = Integer.parseInt(request.getParameter("orderNo"));
		}
		if ((box.get("aaaa") != null)) {
			parentId = request.getParameter("aaaa");

		}
		if ((request.getParameter(GROUP_ID) != null)) {
			groupId = Integer.parseInt(request.getParameter(GROUP_ID));
		}

		if ((request.getParameter(GROUP_APP_ID) != null)) {
			groupApplicationId = Integer.parseInt(request
					.getParameter(GROUP_APP_ID));
		}
		if (request.getParameter(STATUS) != null) {
			status = (request.getParameter(STATUS));
		}

		map.put("groupApplicationId", groupApplicationId);
		map.put("masApplication", masApplication);
		map.put("applicationId", applicationId);
		map.put("applicationName", applicationName);
		map.put("url", url);
		map.put("orderNo", orderNo);
		map.put("parentId", parentId);
		map.put("groupId", groupId);
		map.put("status", status);
		map.put("flag", true);
		boolean dataUpdated = false;
		dataUpdated = userMasterHandlerService.updateApplication(map);

		if (dataUpdated == true) {
			message = "Application Updated Successfully !!";
		} else {
			message = "Application Cant Be Updated !!";
		}
		jsp = SEARCH_AND_EDIT_APPLICATION;
		// jsp=MODULE_MANAGEMENT_JSP;
		// url="/hms/hms/user?method=showApplicationJsp";
		title = "update Application";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// ========================== USER DEPARTMENT MASTER by
	// ABHA==========================================
	// -------------------------------------------User Group Hospital
	// --------------------------------------------------
	public ModelAndView showUserDepartmentJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = userMasterHandlerService.showUserDepartmentJsp();
		jsp = USER_DEPARTMENT_JSP;
		jsp += ".jsp";
		title = "User Department";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addUserDepartment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		UserDepartment masUserDepartment = new UserDepartment();
		int userId = 0;
		int departmentId = 0;
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String[] deptIdArray = null;
		StringBuffer deptStr = new StringBuffer();

		if (request.getParameter(USER_ID) != null) {
			userId = Integer.parseInt(request.getParameter(USER_ID));
		}

		if (request.getParameterValues(DEPARTMENT_ID) != null
				&& !request.getParameterValues(DEPARTMENT_ID).equals("0")) {
			deptIdArray = (String[]) (request.getParameterValues(DEPARTMENT_ID));
			for (int i = 0; i < deptIdArray.length; i++) {
				deptStr.append(deptIdArray[i]);
				deptStr.append(",");
			}
			deptStr.deleteCharAt(deptStr.length() - 1);
			generalMap.put("deptStr", deptStr.toString());
		}

		generalMap.put("userId", userId);
		listMap = userMasterHandlerService
				.checkForExistingUserDepartment(generalMap);
		List duplicateUserDepartmentList = new ArrayList();

		if (listMap.get("duplicateUserDepartmentList") != null) {
			duplicateUserDepartmentList = (List) listMap
					.get("duplicateUserDepartmentList");
		}

		boolean successfullyAdded = false;
		if ((duplicateUserDepartmentList == null || duplicateUserDepartmentList
				.size() == 0)) {
			successfullyAdded = userMasterHandlerService
					.addUserDepartment(generalMap);
			if (successfullyAdded) {
				message = "Record(s) Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if (duplicateUserDepartmentList.size() != 0) {
			message = "User Name already exists. Select the User and Edit the Details!......";
		}

		try {
			map = userMasterHandlerService.showUserDepartmentJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_DEPARTMENT_JSP;
		title = "Add User Department";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editUserDepartment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		int userDepartmentId = 0;
		int userId = 0;
		int departmentId = 0;

		if (request.getParameter(COMMON_ID) != null
				&& !request.getParameter(COMMON_ID).equals("")) {
			userDepartmentId = Integer
					.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(USER_ID) != null) {
			userId = Integer.parseInt(request.getParameter(USER_ID));
		}

		String[] departmentIdArray = null;
		StringBuffer departmentStr = new StringBuffer();

		if (request.getParameterValues(DEPARTMENT_ID) != null
				&& request.getParameterValues(DEPARTMENT_ID).length > 0) {
			departmentIdArray = (String[]) (request
					.getParameterValues(DEPARTMENT_ID));

			for (int i = 0; i < departmentIdArray.length; i++) {
				departmentStr.append(departmentIdArray[i]);
				departmentStr.append(",");
			}
			departmentStr.deleteCharAt(departmentStr.length() - 1);
		}

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		generalMap.put("id", userDepartmentId);
		generalMap.put("userId", userId);
		generalMap.put("departmentStr", departmentStr.toString());
		generalMap.put("flag", true);

		Map<String, Object> listMap = new HashMap<String, Object>();
		listMap = userMasterHandlerService
				.checkForExistingUserDepartment(generalMap);
		List duplicateUserDepartmentList = new ArrayList();

		if (listMap.get("duplicateUserDepartmentList") != null) {
			duplicateUserDepartmentList = (List) listMap
					.get("duplicateUserDepartmentList");
		}

		boolean dataUpdated = false;
		if ((duplicateUserDepartmentList == null || duplicateUserDepartmentList
				.size() == 0)) {
			message = "User Name and Department Name not exist.";
		} else if (duplicateUserDepartmentList.size() != 0) {
			dataUpdated = userMasterHandlerService
					.editUserDepartment(generalMap);
			if (dataUpdated == true) {
				message = "Record Updated Successfully !!";
			} else {
				message = "Record Cant be updated !!";
			}
		}

		try {
			map = userMasterHandlerService.showUserDepartmentJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_DEPARTMENT_JSP;
		title = "Edit User Department";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteUserDepartment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int userDepartmentId = 0;
		int userId = 0;
		String message = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			userDepartmentId = Integer
					.parseInt(request.getParameter(COMMON_ID));
		}

		if (request.getParameter(USER_ID) != null) {
			userId = Integer.parseInt(request.getParameter(USER_ID));
			generalMap.put("userId", userId);
		}

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		boolean dataDeleted = false;
		dataDeleted = userMasterHandlerService.deleteUserDepartment(
				userDepartmentId, generalMap);

		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		try {
			map = userMasterHandlerService.showUserDepartmentJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_DEPARTMENT_JSP;
		title = "Delete User Department";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchUserDepartment(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = userMasterHandlerService.searchUserDepartment(box);
		List users = (List) map.get("users");
		map.put("users", users);
		jsp = RequestConstants.USER_DEPARTMENT_JSP;
		jsp += ".jsp";
		title = "Module Management";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", "");
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchUserDepartment1(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = "";
		String loginName = "";
		String departmentName = "";
		String searchField = null;

		if (request.getParameter(USER_NAME) != null
				&& !(request.getParameter(USER_NAME).equals(""))) {
			userName = request.getParameter(USER_NAME);
		}
		if (request.getParameter(LOGIN_NAME) != null
				&& !(request.getParameter(LOGIN_NAME).equals(""))) {
			loginName = request.getParameter(LOGIN_NAME);
		}
		if (request.getParameter(DEPARTMENT_NAME) != null
				&& !(request.getParameter(DEPARTMENT_NAME).equals(""))) {
			departmentName = request.getParameter(DEPARTMENT_NAME);
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
			userName = searchField;
			departmentName = null;
		} else {
			userName = null;
			departmentName = searchField;
		}
		map = userMasterHandlerService.searchUserDepartment(userName,
				departmentName);

		jsp = USER_DEPARTMENT_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("userName", userName);
		map.put("departmentName", departmentName);
		return new ModelAndView("index", "map", map);
	}

	// added by kalyan
	@SuppressWarnings("unchecked")
	public void getEmpName(HttpServletRequest request,
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
		List<MasEmployee> empList = new ArrayList<MasEmployee>();

		if (!serviceNo.equals("") && serviceNo != null) {
			map = userMasterHandlerService.getEmpName(dataMap);
		}
		empList = (List) map.get("empList");
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		for (MasEmployee emp : empList) {
			if (emp.getFirstName() != null && emp.getLastName() != null
					&& emp.getMiddleName() != null) {
				sb.append("<employeeName>" + emp.getFirstName() + " "
						+ emp.getMiddleName() + " " + emp.getLastName()
						+ "</employeeName>");
			} else if (emp.getFirstName() != null && emp.getLastName() != null
					&& emp.getMiddleName() == null) {
				sb.append("<employeeName>" + emp.getFirstName() + " "
						+ emp.getLastName() + "</employeeName>");
			} else if (emp.getFirstName() != null && emp.getLastName() == null
					&& emp.getMiddleName() == null) {
				sb.append("<employeeName>" + emp.getFirstName()
						+ "</employeeName>");
			} else {
				sb.append("<employeeName>" + "" + "</employeeName>");
			}
			if (emp.getId() != null) {
				sb.append("<employeeId>" + emp.getId() + "</employeeId>");
				sb.append("<departmentId>" + emp.getDepartment().getId()
						+ "</departmentId>");

			}
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

	// end kalyan

	// ===================== end of user department
	// ==========================================================

	// ===================== Methods Written by Vivek
	// =========================Start========================
	public ModelAndView getApplicationForAutoComplete(
			HttpServletRequest request, HttpServletResponse response) {

		String appName = "";
		if (request.getParameter(APPLICATION_NAME) != null) {
			appName = (request.getParameter(APPLICATION_NAME));
		}
		String jsp = "";
		String title = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("appName", appName);
		map = userMasterHandlerService.getApplicationForAutoComplete(map);
		jsp = "responceApplication";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", "");
		return new ModelAndView(jsp, "map", map);
	}

	public void getUrl(HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		List objectList = new ArrayList();
		int appId = 0;
		if (request.getParameter("appId") != null) {
			appId = Integer.parseInt("" + request.getParameter("appId"));
		}
		dataMap.put("appId", appId);
		@SuppressWarnings("unused")
		List<UserApplications> userApplicationsList = new ArrayList<UserApplications>();

		if (appId != 0) {
			map = userMasterHandlerService.getUrl(dataMap);
		}
		userApplicationsList = (List<UserApplications>) map
				.get("userApplicationsList");
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		for (UserApplications userApplications : userApplicationsList) {
			StringBuffer output_str = new StringBuffer();
			StringTokenizer s = new StringTokenizer(userApplications.getUrl()
					.toString(), "&");
			while (s.hasMoreTokens()) {
				output_str.append(s.nextToken());
				if (s.hasMoreTokens()) {
					output_str.append("\'");
				}
			}
			sb.append("<url>" + output_str.toString() + "</url>");
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

	public ModelAndView getParentApplication(HttpServletRequest request,
			HttpServletResponse response) {

		String prAppName = "a";
		if (request.getParameter("prId") != null) {
			prAppName = ("" + request.getParameter("prId"));
		}
		String jsp = "";
		String title = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("prAppName", prAppName);
		map = userMasterHandlerService.getParentApplication(map);
		jsp = "responceParentApplication";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", "");
		return new ModelAndView(jsp, "map", map);
	}

	public void getSubParentApplication(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<MasApplication> masApplicationList = new ArrayList<MasApplication>();

		String parentId = "";
		if (request.getParameter("parentId") != null) {
			parentId = request.getParameter("parentId");
		}
		dataMap.put("parentId", parentId);

		if (parentId != "") {
			map = userMasterHandlerService.getSubParentApplication(dataMap);
		}
		masApplicationList = (List) map.get("masApplicationList");
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<masApplicationLists>");
		try {
			for (Iterator iterator = masApplicationList.iterator(); iterator
					.hasNext();) {
				MasApplication masApplication = (MasApplication) iterator
						.next();

				sb.append("<masApplicationList>");
				sb.append("<masApplicationId>" + masApplication.getId()
						+ "</masApplicationId>");

				StringBuffer output_str = new StringBuffer();
				StringTokenizer s = new StringTokenizer(masApplication
						.getName().toString(), "&");

				while (s.hasMoreTokens()) {
					output_str.append(s.nextToken());
				}
				sb.append("<masApplicationName>" + output_str.toString()
						+ "</masApplicationName>");
				sb.append("</masApplicationList>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sb.append("</masApplicationLists>");
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

	// ------------------------User Application----------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showUserApplicationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = userMasterHandlerService.showUserApplicationJsp();
		jsp = USER_APPLICATION_JSP;
		jsp += ".jsp";
		title = "UserApplication";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchUserApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String applicationName = null;
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			applicationName = request.getParameter(SEARCH_NAME);
		}

		map = userMasterHandlerService.searchUserApplication(applicationName);
		jsp = USER_APPLICATION_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("applicationName", applicationName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addUserApplication(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		UserApplications userApplications = new UserApplications();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(URL) != null) {
			url = request.getParameter(URL);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
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
		generalMap.put("url", url);
		generalMap.put("name", name);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List urlList = new ArrayList();
		List applicationNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			urlList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			applicationNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((urlList.size() == 0 || urlList == null)
				&& (applicationNameList.size() == 0 || applicationNameList == null)) {
			userApplications.setUrl(url);
			userApplications.setAppName(name);
			userApplications.setStatus("y");
			userApplications.setLastChgBy(changedBy);
			userApplications.setLastChgDate(currentDate);
			userApplications.setLastChgTime(currentTime);
			successfullyAdded = userMasterHandlerService
					.addUserApplication(userApplications);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((urlList.size() != 0 || urlList != null)
				|| (applicationNameList.size() != 0)
				|| applicationNameList != null) {
			if ((urlList.size() != 0 || urlList != null)
					&& (applicationNameList.size() == 0 || applicationNameList == null)) {
				message = "Url already exists.";
			} else if ((applicationNameList.size() != 0 || applicationNameList != null)
					&& (urlList.size() == 0 || urlList == null)) {
				message = "Application Name already exists.";
			} else if ((urlList.size() != 0 || urlList != null)
					&& (applicationNameList.size() != 0 || applicationNameList != null)) {
				message = "Url and Application Name already exist.";
			}
		}
		url = "/hms/hms/generalMaster?method=showUserApplicationJsp";
		try {
			map = userMasterHandlerService.showUserApplicationJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_APPLICATION_JSP;
		title = "Add UserApplication";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editUserApplication(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String url = "";
		String applicationName = "";
		int userApplicationId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			userApplicationId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(URL) != null
				&& !(request.getParameter(URL).equals(""))) {
			url = request.getParameter(URL);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			applicationName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
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
		generalMap.put("id", userApplicationId);
		generalMap.put("url", url);
		generalMap.put("name", applicationName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingApplicationNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingApplicationNameList.size() == 0) {

			dataUpdated = userMasterHandlerService
					.editUserApplication(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingApplicationNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showUserApplicationJsp";
		try {
			map = userMasterHandlerService.showUserApplicationJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_APPLICATION_JSP;
		title = "Update User Application";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteUserApplication(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int userApplicationId = 0;
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
			userApplicationId = Integer.parseInt(request
					.getParameter(COMMON_ID));
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
		dataDeleted = userMasterHandlerService.deleteUserApplication(
				userApplicationId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showUserApplicationJsp";
		try {
			map = userMasterHandlerService.showUserApplicationJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = USER_APPLICATION_JSP;
		title = "Delete User Application";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ===================== Methods Written by Vivek
	// =========================End==========================
	// ------------------code for adding emp groups---------------
	// ===================== Methods Written by
	// Vikas=====================================

	@SuppressWarnings("unchecked")
	public ModelAndView showGroupsJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map map = new HashMap();
		map = userMasterHandlerService.showGroupsJsp();
		String jsp = "empGroups";
		jsp += ".jsp";
		title = "User Groups";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchEmpGroups(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String empGroupsCode = null;
		String empGroupsName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			empGroupsCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			empGroupsName = request.getParameter(SEARCH_NAME);
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
			empGroupsCode = searchField;
			empGroupsName = null;

		} else {
			empGroupsCode = null;
			empGroupsName = searchField;
		}
		map = userMasterHandlerService.searchEmpGroups(empGroupsCode,
				empGroupsName);

		jsp = "empGroups";

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("empGroupsCode", empGroupsCode);
		map.put("empGroupsName", empGroupsName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addEmpGroups(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		EmpGroups masUserGroups = new EmpGroups();

		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
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
		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List userGroupsCodeList = new ArrayList();
		List userGroupsNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			userGroupsCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			userGroupsNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((userGroupsCodeList.size() == 0 || userGroupsCodeList == null)
				&& (userGroupsNameList.size() == 0 || userGroupsNameList == null)) {
			masUserGroups.setEmpGroupCode(code);
			masUserGroups.setEmpGroupName(name);
			masUserGroups.setStatus("y");
			masUserGroups.setLastChgBy(changedBy);
			masUserGroups.setLastChgDate(currentDate);
			masUserGroups.setLastChgTime(currentTime);
			successfullyAdded = userMasterHandlerService
					.addEmpGroups(masUserGroups);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((userGroupsCodeList.size() != 0 || userGroupsCodeList != null)
				|| (userGroupsNameList.size() != 0)
				|| userGroupsNameList != null) {
			if ((userGroupsCodeList.size() != 0 || userGroupsCodeList != null)
					&& (userGroupsNameList.size() == 0 || userGroupsNameList == null)) {

				message = "Employee Groups Code  already exists.";
			} else if ((userGroupsNameList.size() != 0 || userGroupsNameList != null)
					&& (userGroupsCodeList.size() == 0 || userGroupsCodeList == null)) {

				message = "Employee Groups Name already exists.";
			} else if ((userGroupsCodeList.size() != 0 || userGroupsCodeList != null)
					&& (userGroupsNameList.size() != 0 || userGroupsNameList != null)) {

				message = "Employee Groups Code and Employee Groups Name already exist.";
			}
		}

		try {
			map = userMasterHandlerService.showGroupsJsp();

		} catch (Exception e) {
		}
		jsp = "empGroups";
		title = "Add User Groups";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editEmpGroups(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession(true);
		String empGroupsCode = "";
		String empGroupsName = "";
		int userGroupsId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			userGroupsId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			empGroupsCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			empGroupsName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", userGroupsId);
		generalMap.put("empGroupsCode", empGroupsCode);
		generalMap.put("name", empGroupsName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingUserGroupsNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingUserGroupsNameList.size() == 0) {
			dataUpdated = userMasterHandlerService
					.editEmpGroupsToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingUserGroupsNameList.size() > 0) {
			message = "Name already exists.";
		}
		// url = "/security/security/user?method=showUserGroupsJsp";

		try {
			map = userMasterHandlerService.showGroupsJsp();

		} catch (Exception e) {
		}
		jsp = "empGroups";
		title = "update User Groups";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteEmpGroups(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int empGroupsId = 0;
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
			empGroupsId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = userMasterHandlerService.deleteEmpGroups(empGroupsId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		// url = "/security/security/user?method=showUserGroupsJsp";

		try {
			map = userMasterHandlerService.showGroupsJsp();

		} catch (Exception e) {
		}
		jsp = "empGroups";
		title = "delete UserGroups";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// --------------------End of code for adding emp groups-----------------

	public ModelAndView showButtonMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		map = userMasterHandlerService.showButtonMasterJsp();
		jsp = "buttonForm";
		title = "Button Details";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addButtonDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasButtonForm masButtonForm = new MasButtonForm();

		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String url = "";
		String formName = "";
		String cssClass = "";
		String formulaUsed = "";
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			formName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter("url") != null) {
			url = request.getParameter("url");
		}
		if (request.getParameter("cssClass") != null) {
			cssClass = request.getParameter("cssClass");
		}
		if (request.getParameter("formulaUsed") != null) {
			formulaUsed = request.getParameter("formulaUsed");
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
		generalMap.put("code", code);
		generalMap.put("formName", formName);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List userGroupsCodeList = new ArrayList();
		List userGroupsNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			userGroupsCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			userGroupsNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((userGroupsCodeList.size() == 0 || userGroupsCodeList == null)
				&& (userGroupsNameList.size() == 0 || userGroupsNameList == null)) {
			masButtonForm.setButtonName(code);
			masButtonForm.setFormName(formName);
			masButtonForm.setUrl(url);
			masButtonForm.setStatus("y");
			masButtonForm.setLastChgBy(changedBy);
			masButtonForm.setLastChgDate(currentDate);
			masButtonForm.setLastChgTime(currentTime);
			masButtonForm.setClassName(cssClass);
			masButtonForm.setFormulaUsed(formulaUsed);
			successfullyAdded = userMasterHandlerService
					.addButtonDetails(masButtonForm);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((userGroupsCodeList.size() != 0 || userGroupsCodeList != null)
				|| (userGroupsNameList.size() != 0)
				|| userGroupsNameList != null) {
			if ((userGroupsCodeList.size() != 0 || userGroupsCodeList != null)
					&& (userGroupsNameList.size() == 0 || userGroupsNameList == null)) {

				message = "Button Name  already exists.";
			} else if ((userGroupsNameList.size() != 0 || userGroupsNameList != null)
					&& (userGroupsCodeList.size() == 0 || userGroupsCodeList == null)) {

				message = "Form Name already exists.";
			} else if ((userGroupsCodeList.size() != 0 || userGroupsCodeList != null)
					&& (userGroupsNameList.size() != 0 || userGroupsNameList != null)) {

				message = "Button Name and Form Name already exist.";
			}
		}
		try {
			map = userMasterHandlerService.showButtonMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "buttonForm";
		title = "Add Button Details";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editButtonDetails(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession(true);
		String buttonName = "";
		String formName = "";
		int masButtonId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String url = "";
		String cssClass = "";
		String formulaUsed = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			masButtonId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			buttonName = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			formName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter("url") != null
				&& !(request.getParameter("url").equals(""))) {
			url = request.getParameter("url");
		}
		if (request.getParameter("cssClass") != null) {
			cssClass = request.getParameter("cssClass");
		}
		if (request.getParameter("formulaUsed") != null) {
			formulaUsed = request.getParameter("formulaUsed");
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

		generalMap.put("id", masButtonId);
		generalMap.put("buttonName", buttonName);
		generalMap.put("name", formName);
		generalMap.put("url", url);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("cssClass", cssClass);
		generalMap.put("formulaUsed", formulaUsed);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		// listMap =
		// commonMasterHandlerService.checkForExistingMasters(generalMap);
		// List existingUserGroupsNameList =
		// (List)listMap.get("duplicateMastersList");

		boolean dataUpdated = userMasterHandlerService
				.editButtonDetails(generalMap);
		;

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant Be Updated !!";
		}

		/*
		 * else if(existingUserGroupsNameList.size() > 0){ message = "Name
		 * already exists."; }
		 */
		// url = "/security/security/user?method=showUserGroupsJsp";
		try {
			map = userMasterHandlerService.showButtonMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "buttonForm";
		title = "update Button Details";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteButtonDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int buttonId = 0;
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
			buttonId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = userMasterHandlerService.deleteButtonDetails(buttonId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		// url = "/security/security/user?method=showHospitalJsp";
		try {
			map = userMasterHandlerService.showButtonMasterJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "buttonForm";
		title = "Delete Button Details";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getUserGroups(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		map = userMasterHandlerService.getUerGroupDetails(box);

		jsp = "userGroupPopUp";
		title = "User Group Details";
		// jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	/**
	 * ---------------------------- Template---------------------
	 * 
	 * @return
	 */

	public ModelAndView showTemplateMaster(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "";
		String title = "";
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession(true);
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		String superAdmin = "";
		String userName = "";
		int userType = 4;
		if(session.getAttribute("users") != null){
			 Users user = (Users)session.getAttribute("users");
			 superAdmin = user.getSuperuser()!=null?user.getSuperuser():"n";
			 userName = (String)session.getAttribute("userName");
			 userType = user.getUserType()!=null?user.getUserType():4;
					 
		}
	//	int deptId = (Integer) session.getAttribute("deptId");
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("superAdmin", superAdmin);
		dataMap.put("userType", userType);
		map = userMasterHandlerService.showTemplateJsp(dataMap);
		jsp = "masTemplate";
		jsp += ".jsp";
		title = "Template";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", "");
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addTemplate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasTemplate masTemplate = new MasTemplate();
		session = request.getSession(true);
		int hospitalId = 0;
		int templateInstituteId=0;
		int deptId = 0;
		int userId = (Integer)session.getAttribute("userId");
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		if (((Integer)session.getAttribute("deptId"))!= null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.convertStringTypeDateToDateType(request
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
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0") )
		{
			templateInstituteId = Integer.parseInt(request.getParameter("hospitalId"));
		}else if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("hospitalId", hospitalId);
		List templateCodeList = new ArrayList();

	/*	listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);


		*/
		boolean successfullyAdded = false;

	/*	if ((templateCodeList.size() == 0 || templateCodeList == null)
				&& (templateNameList.size() == 0 || templateNameList == null)) {*/
			masTemplate.setTemplateCode(code);
			masTemplate.setTemplateName(name);
			masTemplate.setStatus("y");
			Users user = new Users();
			user.setId(userId);
			masTemplate.setLastChgBy(user);
			masTemplate.setLastChgDate(currentDate);
			masTemplate.setLastChgTime(currentTime);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			masTemplate.setDept(masDepartment);
			
			if(templateInstituteId>0){
			MasHospital masHosp = new MasHospital();
			masHosp.setId(templateInstituteId);
			masTemplate.setHospital(masHosp);
			}
			
			map = userMasterHandlerService.addTemplate(masTemplate,generalMap);
			if (map.get("templateCodeList") != null) {
				templateCodeList = (List) map.get("templateCodeList");
			}
			
			successfullyAdded = (Boolean)map.get("successfullyAdded");
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				  if ((templateCodeList.size() != 0 || templateCodeList != null)) {

							message = "Template Code and Template Name already exist.";
						
					}else{
						message = "Try Again !!";
					}
			}
		//}

		 Map<String, Object> dataMap = new HashMap<String, Object>();
		 String superAdmin = "";
		 String userName = "";
		 int userType = 4;
			if(session.getAttribute("users") != null){
				 Users users = (Users)session.getAttribute("users");
				 userName = (String)session.getAttribute("userName");
				 superAdmin = users.getSuperuser()!=null?users.getSuperuser():"n";
				 userType = users.getUserType()!=null?users.getUserType():4;
			}
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("superAdmin", superAdmin);
			dataMap.put("userName", userName);
			dataMap.put("userType",userType);
		try {
			map = userMasterHandlerService.showTemplateJsp(dataMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "masTemplate";
		title = "Add Template";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView showRolMappingJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String,Object> map = new HashMap<String,Object>();
		
		int hospitalId=0;
		session = request.getSession(true);
		
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		Map<String,Object> dataMap = new HashMap<String,Object>();
		Users users=null;
		int userType=0;
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			userType=users.getUserType();
			dataMap.put("userId", users.getId());
		}
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userType", userType);
		map = userMasterHandlerService.showRolMappingJsp(dataMap);
		String jsp = "InstituteTemplateMapping";
		jsp += ".jsp";
		title = "User Groups";
		map.put("contentJsp", jsp);
		map.put("hospitalId", hospitalId);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	/**Method  for assign the common role for Institute
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView addRoleTemplate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		session = request.getSession(true);
		int hospitalId = 0;
		int deptId=0;	
		 
/*		String[] roll=request.getParameterValues("tempId"); 
*/		
		String[] roll={"0"};
		//String[] roll=request.getParameterValues("mainGroupId");
		if(request.getParameterValues("tempId")!=null)
		{
			//LOGGER.info("javed"+request.getParameterValues("tempId"));
			roll = request.getParameterValues("tempId");
		}
		//ArrayList<String> rollList=new ArrayList<String>();
		Set<String> rollSet = new HashSet<String>();
		for(String s:roll){
			//LOGGER.info("roll "+s);
			//rollList.add(s);
			rollSet.add(s);
		}
		
		int userId = (Integer)session.getAttribute("userId");
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		if (((Integer)session.getAttribute("deptId"))!= null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		/*if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}*/
		/*if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}*/
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
		}
		
	String	changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		/*if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}*/
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		/*if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}*/
		/*if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0") )
		{
			templateInstituteId = Integer.parseInt(request.getParameter("hospitalId"));
		}*/
		if(request.getParameter("hospitalId")!=null)
		{
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else if(session.getAttribute("hospitalId") != null){
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("userId", userId);
		
		generalMap.put("deptId", deptId);
		//generalMap.put("rollList", rollList);
		generalMap.put("rollSet", rollSet);
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("hospitalId", hospitalId);
		List templateCodeList = new ArrayList();

	/*	listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);


		*/
		Users users=null;
		int userType=0;
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			userType=users.getUserType();
		}
		generalMap.put("userType", userType);
		
		boolean successfullyAdded = false;

	/*	if ((templateCodeList.size() == 0 || templateCodeList == null)
				&& (templateNameList.size() == 0 || templateNameList == null)) {*/
		
			map = userMasterHandlerService.addRoleTemplate(generalMap);
			if (map.get("templateCodeList") != null) {
				templateCodeList = (List) map.get("templateCodeList");
			}
			
			successfullyAdded = (Boolean)map.get("successfullyAdded");
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				  if ((templateCodeList.size() != 0 || templateCodeList != null)) {

							message = "Template Code and Template Name already exist.";
						
					}else{
						message = "Try Again !!";
					}
			}
			
			
		jsp = "InstituteTemplateMapping";
		title = "Add Template";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView editTemplate(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession(true);
		String templateCode = "";
		String templateName = "";
		int userGroupsId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			userGroupsId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			templateCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			templateName = request.getParameter(SEARCH_NAME);
		}
		int deptId = (Integer) session.getAttribute("deptId");
		int userId = (Integer)session.getAttribute("userId");
		int hospitalId = 0;
		String hospStr = request.getParameter("hospitalId");
		if(hospStr!=null && !hospStr.trim().equals(""))
		{
			hospitalId = Integer.parseInt(hospStr);
		}else if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
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

		generalMap.put("id", userGroupsId);
		generalMap.put("templateCode", templateCode);
		generalMap.put("templateName", templateName);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("deptId", deptId);

		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
	/*	listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);*/
	/*	List existingHospitalNameList = (List) listMap
				.get("duplicateMastersList");*/
		boolean dataUpdated = false;
		map = userMasterHandlerService.editTemplate(generalMap);
		dataUpdated = (Boolean)map.get("dataUpdated");
		List existingHospitalNameList = (List) map.get("templateCodeList");
		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			if (existingHospitalNameList.size() == 0) {
				message = "Data Cant Be Updated !!";
			} else if (existingHospitalNameList.size() > 0) {
				message = "Name already exists.";
			}
		}
		
		url = "/hms/hms/user?method=showTemplateMaster";
		
		 Map<String, Object> dataMap = new HashMap<String, Object>();
		 String superAdmin = "";
		 String userName = "";
		 int userType = 4;
			if(session.getAttribute("users") != null){
				 Users user = (Users)session.getAttribute("users");
				 superAdmin = user.getSuperuser()!=null?user.getSuperuser():"n";
				 userName = (String)session.getAttribute("userName");
				 userType = user.getUserType()!=null?user.getUserType():4;
			}
			dataMap.put("userType",userType);
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("superAdmin", superAdmin);
		try {
			map = userMasterHandlerService.showTemplateJsp(dataMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "masTemplate";
		title = "update Template";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchTemplate(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String templateCode = null;
		String templateName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			templateCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			templateName = request.getParameter(SEARCH_NAME);
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
			templateCode = searchField;
			templateName = null;

		} else {
			templateCode = null;
			templateName = searchField;
		}
		int hospitalId = 0;
		if(request.getParameter("hospitalId")!=null)
		{
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("templateCode", templateCode);
		dataMap.put("templateName", templateName);
		dataMap.put("hospitalId", hospitalId);
		int userType = 4;
		 String superAdmin = "";
		 String userName = "";
			if(session.getAttribute("users") != null){
				 Users user = (Users)session.getAttribute("users");
				 superAdmin = user.getSuperuser()!=null?user.getSuperuser():"n";
				 userName = (String)session.getAttribute("userName");
				 userType = user.getUserType()!=null?user.getUserType():4;
			}
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("superAdmin", superAdmin);
		dataMap.put("userType",userType);
		map = userMasterHandlerService.searchTemplate(dataMap);

		jsp = "masTemplate";

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("templateCode", templateCode);
		map.put("templateName", templateName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteTemplate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int templateId = 0;
		String message = null;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			templateId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = userMasterHandlerService.deleteTemplate(templateId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/user?method=showTemplateMaster";

		 Map<String, Object> dataMap = new HashMap<String, Object>();
		 String superAdmin = "";
		 String userName = "";
			if(session.getAttribute("users") != null){
				 Users user = (Users)session.getAttribute("users");
				 superAdmin = user.getSuperuser()!=null?user.getSuperuser():"n";
				 userName = (String)session.getAttribute("userName");
			}
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("superAdmin", superAdmin);
		try {
			map = userMasterHandlerService.showTemplateJsp(dataMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "masTemplate";
		title = "delete template";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView showTemplateJsp(HttpServletRequest request,
			HttpServletResponse response) {

		String jsp = "";
		String title = "";
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		String superAdmin = "";
		int userType = 0; /* user type 4 for general user */
		int userId = 0;
		if(session.getAttribute("users") != null){
			 Users user = (Users)session.getAttribute("users");
			 superAdmin = user.getSuperuser()!=null?user.getSuperuser():"n";
			 userType = user.getUserType()!=null?user.getUserType():4;
			 userId = user.getId();
		}
		List<MasApplication> moduleList = new ArrayList<MasApplication>();
		moduleList = userMasterHandlerService.getModuleListForTemplate();
		List<MasTemplate> templateList = new ArrayList<MasTemplate>();
		templateList = userMasterHandlerService.getTemplateList(hospitalId,userType);
		
	/*	map = userMasterHandlerService.getHospitalWiseTemplate(hospitalId);
		if(map.get("masTemplateList")!=null){
			templateList = (List<MasTemplate>)map.get("masTemplateList");
		}*/

		//List<MasButtonForm> formList = new ArrayList<MasButtonForm>();
		//formList = userMasterHandlerService.getFormList();
		List<Object[]> departmentList = new ArrayList<Object[]>();
		departmentList = userMasterHandlerService.getDepartmentList(hospitalId);
		
		
		
		String userName = "";
		if(session.getAttribute("userName") != null){
		 userName = (String)session.getAttribute("userName");
		}
		
		MasHospital hospital = new MasHospital();
		int sessionDistrictId = 0;
		if(session.getAttribute("districtId")!=null){
			sessionDistrictId = (Integer)session.getAttribute("districtId");
		}
	
		if(superAdmin.equalsIgnoreCase("y") || session.getAttribute("userName").equals("admin") || userType<3){ 
			List<Object[]> districtList = new ArrayList<Object[]>();
			districtList = userMasterHandlerService.getDistrictList();
			
			List<Object[]> hospitalList = new ArrayList<Object[]>();
			hospitalList = userMasterHandlerService.getHospitalListForTemplateApplication(sessionDistrictId);
			
			List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
			mhospitalTypetList = userMasterHandlerService.getHospitalTypeListForTemplateApplication();
			map.put("mhospitalTypetList", mhospitalTypetList);
			map.put("hospitalList", hospitalList);
			map.put("districtList", districtList);
		}else if(userType == 5){ // PH admin
			List<Object[]> bsScInstList = new ArrayList<Object[]>();
			bsScInstList = userMasterHandlerService.getBsScInstList(userId);
			map.put("bsScInstList", bsScInstList);
		}
		
		map.put("departmentList", departmentList);
		map.put("moduleList", moduleList);
		map.put("templateList", templateList);
		//map.put("formList", formList);
		jsp = "templateCreation";
		jsp += ".jsp";
		title = "Template";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", "");

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView getUsersList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int empGroup = (Integer.parseInt(request.getParameter("empGroup")));
		map = userMasterHandlerService.getUserList(empGroup);
		List<UserEmpGroup> empGrpList = new ArrayList<UserEmpGroup>();
		empGrpList = (List<UserEmpGroup>) map.get("empGrpList");
		int templateId = 0;
		if (request.getParameter("template") != null) {
			templateId = Integer.parseInt(request.getParameter("template"));
		}
		int empGroupId = 0;
		if (request.getParameter("empGroup") != null) {
			empGroupId = Integer.parseInt(request.getParameter("empGroup"));
		}
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		map = userMasterHandlerService.getTemplateApplicationList(templateId,
				hospitalId);
		List<TemplateApplication> tempAppList = new ArrayList<TemplateApplication>();
		tempAppList = (List) map.get("tempAppList");

		List<Integer> buttonTemplateList = new ArrayList<Integer>();
		buttonTemplateList = (List<Integer>) map.get("buttonTemplateList");

		List<UserTemplate> userTemplateList = new ArrayList<UserTemplate>();
		userTemplateList = userMasterHandlerService
				.getUsersListFromUserTemplate(templateId, empGroupId);

		jsp = "userListForTemplate";
		title = "User Management";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("empGrpList", empGrpList);
		map.put("userTemplateList", userTemplateList);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView assignTemplateToUser(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String message = null;
		String[] arr = request.getParameterValues("userId");
		int templateId = 0;
		if (request.getParameter("template") != null) {
			templateId = Integer.parseInt(request.getParameter("template"));
		}

		int empGroupId = 0;
		if (request.getParameter("empGroup") != null) {
			empGroupId = Integer.parseInt(request.getParameter("empGroup"));
		}
		int hospitalId = (Integer) session.getAttribute("hospitalId");

		map = userMasterHandlerService.getTemplateApplicationList(templateId,
				hospitalId);

		List<Object> grpAppList = new ArrayList<Object>();
		grpAppList = (List<Object>) map.get("grpAppList");
		List<Object> usrGrpHospList = new ArrayList<Object>();
		usrGrpHospList = (List<Object>) map.get("usrGrpHospList");
		List<Integer> buttonTemplateList = new ArrayList<Integer>();
		buttonTemplateList = (List<Integer>) map.get("buttonTemplateList");

		List<Integer> userIdList = new ArrayList<Integer>();
		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				int userId1 = Integer.parseInt(arr[i]);
				userIdList.add(userId1);
				dataMap.put("userIdList", userIdList);
			}
		}

		String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		dataMap.put("userName", userName);
		dataMap.put("templateId", templateId);
		dataMap.put("grpAppList", grpAppList);
		dataMap.put("usrGrpHospList", usrGrpHospList);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("empGroupId", empGroupId);
		dataMap.put("buttonTemplateList", buttonTemplateList);
		List empGroupList = new ArrayList();
		List<MasTemplate> templateList = new ArrayList<MasTemplate>();
		int userType = 0; /* user type 4 for general user */
		if(session.getAttribute("users") != null){
			 Users user = (Users)session.getAttribute("users");
			 userType = user.getUserType()!=null?user.getUserType():4;
		}
		
		boolean successfullyAdded = userMasterHandlerService
				.addUserWiseTemplate(dataMap);
		empGroupList = userMasterHandlerService.getEmpGroupForTemplate();
		templateList = userMasterHandlerService.getTemplateList(hospitalId,userType);
		if (successfullyAdded) {
			message = "Template Has Been Assigned To The User";
			jsp = "showAssignTemplateToUser";
		} else {
			message = "Error Ocurred Please Try Again";
			jsp = "showAssignTemplateToUser";
		}

		jsp += ".jsp";
		map.put("empGroupList", empGroupList);
		map.put("templateList", templateList);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView viewAssignTemplateToUser(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		String jsp = "";
		String title = "";
		Map<String, Object> map = new HashMap<String, Object>();
		int templateId = 0;
		int empGroupId = 0;
		if (request.getParameter("template") != null) {
			templateId = Integer.parseInt(request.getParameter("template"));
		}
		if (request.getParameter("empGroup") != null) {
			empGroupId = Integer.parseInt(request.getParameter("empGroup"));
		}
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		int userType = 0; /* user type 4 for general user */
		if(session.getAttribute("users") != null){
			 Users user = (Users)session.getAttribute("users");
			 userType = user.getUserType()!=null?user.getUserType():4;
		}
		List<EmpGroups> empGroupList = new ArrayList<EmpGroups>();
		empGroupList = userMasterHandlerService.getEmpGroupForTemplate();
		List<MasTemplate> templateList = new ArrayList<MasTemplate>();
		templateList = userMasterHandlerService.getTemplateList(hospitalId,userType);

		List<UserTemplate> userTemplateList = new ArrayList<UserTemplate>();
		userTemplateList = userMasterHandlerService
				.getUsersListFromUserTemplate(templateId, empGroupId);

		map = userMasterHandlerService.getTemplateApplicationList(templateId,
				hospitalId);
		List<Object> grpAppList = new ArrayList<Object>();
		grpAppList = (List<Object>) map.get("grpAppList");
		List<Integer> buttonTemplateList = new ArrayList<Integer>();
		buttonTemplateList = (List<Integer>) map.get("buttonTemplateList");

		map.put("empGroupList", empGroupList);
		map.put("templateList", templateList);
		map.put("templateId", templateId);
		map.put("empGroupId", empGroupId);
		map.put("userTemplateList", userTemplateList);
		map.put("buttonTemplateList", buttonTemplateList);
		jsp = "viewAssignTemplateTouser";
		jsp += ".jsp";
		title = "Template";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", "");

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showTemplateModulesJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		int userType = 0; /* user type 4 for general user */
		if(session.getAttribute("users") != null){
			 Users user = (Users)session.getAttribute("users");
			 userType = user.getUserType()!=null?user.getUserType():4;
		}
		
		//int hospitalId = (Integer) session.getAttribute("hospitalId");
		int hospitalId = (Integer.parseInt(request.getParameter("hospitalId")));
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<MasApplication> moduleList = new ArrayList<MasApplication>();
		moduleList = userMasterHandlerService.getModuleListForTemplate();
		
		String templateId = request.getParameter(TEMPLATE);
		List<MasTemplate> templateList = new ArrayList<MasTemplate>();
		box.put("userType",userType);
		//map = userMasterHandlerService.getTemplateModuleList(templateId,hospitalId,userType);
		map = userMasterHandlerService.getTemplateModuleList(box);
		
		List<Object[]> departmentList = new ArrayList<Object[]>();
		departmentList = userMasterHandlerService.getDepartmentList(hospitalId);
		
		MasHospital hospital = new MasHospital();
		int districtId = 0;
		if(request.getParameter("districtId")!=null){
			districtId = (Integer.parseInt(request.getParameter("districtId")));
		}else if(session.getAttribute("districtId")!=null){
			districtId = (Integer)session.getAttribute("districtId");
		}
		
		
		int instType=0;
		if (request.getParameter("districtId") != null) {
			districtId =Integer.parseInt(request.getParameter("districtId"));
		}
		if (request.getParameter("instType") != null) {
			instType = Integer.parseInt(request.getParameter("instType"));
		}
		String superAdmin = "";
		int userId = 0;
		if(session.getAttribute("users") != null){
			 Users user = (Users)session.getAttribute("users");
			 superAdmin = user.getSuperuser()!=null?user.getSuperuser():"n";
			 userId = user.getId();
		}
		
		String shortName="";
		if(request.getParameter("instName")!=null){
			shortName = (String)request.getParameter("instName");
		}
		LOGGER.info("shortName "+shortName);
		
		if(superAdmin.equalsIgnoreCase("y") || session.getAttribute("userName").equals("admin")  || userType<3){ 
			List<Object[]> districtList = new ArrayList<Object[]>();
			districtList = userMasterHandlerService.getDistrictList();
			
			List<Object[]> hospitalList = new ArrayList<Object[]>();
			hospitalList = userMasterHandlerService.getHospitalListForTemplateApplication(districtId);
			List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
			mhospitalTypetList = userMasterHandlerService.getHospitalTypeListForTemplateApplication();
			map.put("mhospitalTypetList", mhospitalTypetList);
			map.put("hospitalList", hospitalList);
			map.put("districtList", districtList);
		}else if(userType == 5){ // PH admin
			List<Object[]> bsScInstList = new ArrayList<Object[]>();
			bsScInstList = userMasterHandlerService.getBsScInstList(userId);
			map.put("bsScInstList", bsScInstList);
		}
		map.put("departmentList", departmentList);
		map.put("moduleList", moduleList);
		map.put("hospitalId", hospitalId);
		map.put("districtId", districtId);
		map.put("instType", instType);
		map.put("shortName", shortName);
		jsp = "templateCreation";
		jsp += ".jsp";
		title = "Template";
		map.put("templateId", templateId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", "");

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getApplicationListForTemplate(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		String parentId = request.getParameter("parentId");
		String templateId = request.getParameter(TEMPLATE);
		map = userMasterHandlerService.populateApplications(parentId,
				templateId);
		jsp = "applicationListForTemplate";
		title = "Template";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	
	public void checkAppOrderNo(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String appOrderNo = request.getParameter("appOrderNo");
		map = userMasterHandlerService.checkAppOrderNo(appOrderNo);
		List<MasApplication> appList = new ArrayList<MasApplication>();
		if(map.get("appList")!=null){
			appList = (List<MasApplication>)map.get("appList");
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		if(appList.size()>0) {
			
			sb.append("<msg>" + "Order No. already exist." + "</msg>");
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

	public ModelAndView submitApplicationWiseTemplate(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId =0;
		if(request.getParameter("hospitalId")!=null){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else{
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		String message = null;
		int templateId = Integer.parseInt(request.getParameter("template"));
		String template = (String) request.getParameter("template");
		String[] str = request.getParameterValues("appId");
		String[] strDept = request.getParameterValues("departmentId");
		String parentId = request.getParameter("parentId");
		int userId = 0;
		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");
		}

		int userType = 0; /* user type 4 for general user */
		if(session.getAttribute("users") != null){
			 Users user = (Users)session.getAttribute("users");
			 userType = user.getUserType()!=null?user.getUserType():4;
		}
		
		String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		Box box = HMSUtil.getBox(request);
	//	String[] button = request.getParameterValues("buttonName");

		List groupApplicationList = new ArrayList();
		List appOrderNoList = new ArrayList();
		groupApplicationList.add(parentId);
		if (str != null) {
			for (int j = 0; j < str.length; j++) {

				String appId = (str[j]);
				datamap.put("appId", appId);
				groupApplicationList.add(appId);
			}
		}
		/*List buttonList = new ArrayList();
		if (button != null) {
			for (int k = 0; k < button.length; k++) {

				Integer buttonId = Integer.parseInt(button[k].toString());
				datamap.put("buttonId", buttonId);

				buttonList.add(buttonId);
			}
		}*/
		List deptList = new ArrayList();
		if (strDept != null) {
			for (int j = 0; j < strDept.length; j++) {

				String deptId = (strDept[j]);
				datamap.put("deptId", deptId);
				deptList.add(deptId);
			}
		}
		datamap.put("deptList", deptList);
		datamap.put("templateId", templateId);
		datamap.put("groupApplicationList", groupApplicationList);
		datamap.put("appOrderNoList", appOrderNoList);
		datamap.put("parentId", parentId);
		datamap.put("userName", userName);
		datamap.put("userId", userId);
		datamap.put("box", box);

		boolean successfullyAdded = userMasterHandlerService
				.submitTemplateWiseApplication(datamap);
		List<MasApplication> moduleList = new ArrayList<MasApplication>();
		moduleList = userMasterHandlerService.getModuleListForTemplate();
		List<MasTemplate> templateList = new ArrayList<MasTemplate>();
		//map = userMasterHandlerService.getTemplateModuleList(template,hospitalId,userType);
		map = userMasterHandlerService.getTemplateModuleList(box);
		List<Object[]> departmentList = new ArrayList<Object[]>();
		departmentList = userMasterHandlerService.getDepartmentList(hospitalId);
		map.put("departmentList", departmentList);
		List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
		mhospitalTypetList = userMasterHandlerService.getHospitalTypeListForTemplateApplication();
		map.put("mhospitalTypetList", mhospitalTypetList);
		String superAdmin = "";
		if(session.getAttribute("users") != null){
			 Users user = (Users)session.getAttribute("users");
			 superAdmin = user.getSuperuser()!=null?user.getSuperuser():"n";
		}
		MasHospital hospital = new MasHospital();
		int districtId = 0;
		if(session.getAttribute("districtId")!=null){
			districtId = (Integer)session.getAttribute("districtId");
		}
		
		if(superAdmin.equalsIgnoreCase("y") || session.getAttribute("userName").equals("admin")){ 
			List<Object[]> districtList = new ArrayList<Object[]>();
			districtList = userMasterHandlerService.getDistrictList();
			
			List<Object[]> hospitalList = new ArrayList<Object[]>();
			hospitalList = userMasterHandlerService.getHospitalListForTemplateApplication(districtId);
			map.put("hospitalList", hospitalList);
			map.put("districtList", districtList);
		}
		map.put("hospitalId", hospitalId);
		
		if (successfullyAdded) {
			message = "Module has been Assigned to the template";
			jsp = "templateCreation";
		} else {
			message = "Error Ocurred Please Try Again";
			jsp = "templateCreation";
		}
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("moduleList", moduleList);
		map.put("templateId", templateId);
		// map.put("templateList", templateList);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAssignTemplateToUser(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		int userType = 0; /* user type 4 for general user */
		if(session.getAttribute("users") != null){
			 Users user = (Users)session.getAttribute("users");
			 userType = user.getUserType()!=null?user.getUserType():4;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		List empGroupList = new ArrayList();
		empGroupList = userMasterHandlerService.getEmpGroupForTemplate();
		List<MasTemplate> templateList = new ArrayList<MasTemplate>();
		templateList = userMasterHandlerService.getTemplateList(hospitalId,userType);

		map.put("empGroupList", empGroupList);
		map.put("templateList", templateList);
		jsp = "showAssignTemplateToUser";
		jsp += ".jsp";
		title = "Template";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", "");

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getButtonListForForm(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		String parentId = request.getParameter("parentId");
		String templateId = request.getParameter(TEMPLATE);
		String formName = request.getParameter("formName");
		map = userMasterHandlerService.getButtonList(formName);
		jsp = "buttonListForForm";
		title = "Template";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView editAssignTemplateToUser(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();
		String message = null;
		int templateId = 0;
		if (request.getParameter("template") != null) {
			templateId = Integer.parseInt(request.getParameter("template"));
		}

		int empGroupId = 0;
		if (request.getParameter("empGroup") != null) {
			empGroupId = Integer.parseInt(request.getParameter("empGroup"));
		}

		List<UserTemplate> userTemplateList = new ArrayList<UserTemplate>();
		userTemplateList = userMasterHandlerService
				.getUsersListFromUserTemplate(templateId, empGroupId);

		int userTempUserid = 0;
		if (userTemplateList.size() > 0) {
			for (UserTemplate userTemplate : userTemplateList) {
				userTempUserid = userTemplate.getUser().getId();
				dataMap.put("userTempUserid", userTempUserid);
			}
		}

		int hospitalId = (Integer) session.getAttribute("hospitalId");
		map = userMasterHandlerService.getTemplateApplicationList(templateId,
				hospitalId);

		List<Object> grpAppList = new ArrayList<Object>();
		grpAppList = (List<Object>) map.get("grpAppList");

		List<Object> usrGrpHospList = new ArrayList<Object>();
		usrGrpHospList = (List<Object>) map.get("usrGrpHospList");

		List<Integer> buttonTemplateList = new ArrayList<Integer>();
		buttonTemplateList = (List<Integer>) map.get("buttonTemplateList");

		String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		dataMap.put("userName", userName);
		dataMap.put("templateId", templateId);
		dataMap.put("grpAppList", grpAppList);
		dataMap.put("usrGrpHospList", usrGrpHospList);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("empGroupId", empGroupId);
		dataMap.put("userTemplateList", userTemplateList);
		dataMap.put("buttonTemplateList", buttonTemplateList);

		boolean successfullyAdded = userMasterHandlerService
				.editUserWiseTemplate(dataMap);

		List empGroupList = new ArrayList();
		empGroupList = userMasterHandlerService.getEmpGroupForTemplate();
		
		int userType = 0; /* user type 4 for general user */
		if(session.getAttribute("users") != null){
			 Users user = (Users)session.getAttribute("users");
			 userType = user.getUserType()!=null?user.getUserType():4;
		}
		
		List<MasTemplate> templateList = new ArrayList<MasTemplate>();
		templateList = userMasterHandlerService.getTemplateList(hospitalId,userType);
		if (successfullyAdded) {
			message = "Template has been removed ";
			jsp = "showAssignTemplateToUser";
		} else {
			message = "Error Ocurred Please Try Again";
			jsp = "showAssignTemplateToUser";
		}
		jsp += ".jsp";
		map.put("empGroupList", empGroupList);
		map.put("templateList", templateList);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	
	 
	 public ModelAndView getTalukList(HttpServletRequest request, HttpServletResponse response) {
		 	Map<String, Object> map = new HashMap<String, Object>();
			int district = 0;
			try {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				if (request.getParameter("district") != null) {
					district = Integer.parseInt(request.getParameter("district"));
				}
				dataMap.put("district", district);
				map = userMasterHandlerService.getTalukList(dataMap);
				jsp = "responseTaluk";
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ModelAndView(jsp, "map", map);
		}
	 
	 
	 public ModelAndView getVillageList(HttpServletRequest request, HttpServletResponse response) {
		 	Map<String, Object> map = new HashMap<String, Object>();
			int taluk = 0;
			try {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				if (request.getParameter("taluk") != null) {
					taluk = Integer.parseInt(request.getParameter("taluk"));
				}
				dataMap.put("taluk", taluk);
				map = userMasterHandlerService.getVillageList(dataMap);
				jsp = "responseVillage";
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ModelAndView(jsp, "map", map);
		}
	 
	 
	 public ModelAndView getAssemblyList(HttpServletRequest request, HttpServletResponse response) {
		 	Map<String, Object> map = new HashMap<String, Object>();
			int parliamentId = 0;
			try {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				if (request.getParameter("parliamentId") != null) {
					parliamentId = Integer.parseInt(request.getParameter("parliamentId"));
				}
				dataMap.put("parliamentId", parliamentId);
				map = userMasterHandlerService.getAssemblyList(dataMap);
				jsp = "responseAssembly";
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ModelAndView(jsp, "map", map);
		}
	 

	 public ModelAndView getWardList(HttpServletRequest request, HttpServletResponse response) {
		 	Map<String, Object> map = new HashMap<String, Object>();
			int villageId = 0;
			int districtId=0;
			try {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				if (request.getParameter("districtId") != null) {
					districtId = Integer.parseInt(request.getParameter("districtId"));
				}
			//	LOGGER.info("districtId "+districtId);
				/*if (request.getParameter("villageId") != null) {
					villageId = Integer.parseInt(request.getParameter("villageId"));
				}*/
				dataMap.put("villageId", villageId);
				dataMap.put("districtId", districtId);
				map = userMasterHandlerService.getWardList(dataMap);
				jsp = "responseWard";
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ModelAndView(jsp, "map", map);
		}
	 public ModelAndView getPanchayatList(HttpServletRequest request, HttpServletResponse response) {
		 	Map<String, Object> map = new HashMap<String, Object>();
			int assemblyId = 0;
			try {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				if (request.getParameter("assemblyId") != null) {
					assemblyId = Integer.parseInt(request.getParameter("assemblyId"));
				}
				dataMap.put("assemblyId", assemblyId);
				map = userMasterHandlerService.getPanchayatList(dataMap);
				jsp = "responsePanchayat";
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ModelAndView(jsp, "map", map);
		}
	 
	 public ModelAndView getLocalityList(HttpServletRequest request, HttpServletResponse response) {
		 	Map<String, Object> map = new HashMap<String, Object>();
			int ward = 0;
			try {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				if (request.getParameter("wards") != null) {
					ward = Integer.parseInt(request.getParameter("wards"));
				}
				dataMap.put("ward",ward);
				
				map = userMasterHandlerService.getLocalityList(dataMap);
				jsp = "responseLocality";
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ModelAndView(jsp, "map", map);
		}
	 public ModelAndView showUserAssignedTemplet(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> mapDetails = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospitalId = 0;
			if(request.getParameter("hospitalId")!=null){
				hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
			}else{
				hospitalId = (Integer) session.getAttribute("hospitalId");
			}
			int districtId = 0;
			if(request.getParameter("districtId")!=null){
				districtId = Integer.parseInt(request.getParameter("districtId"));
			}else{
				districtId = (Integer) session.getAttribute("districtId");
			}
			mapDetails.put("hospitalId", hospitalId);
			mapDetails.put("districtId", districtId);
			mapDetails.put("userName", (String) session.getAttribute("userName"));
			 String superAdmin = "";
			 int userType = 0;
			 int userId = 0;
				if(session.getAttribute("users") != null){
					Users user = (Users)session.getAttribute("users");
					 superAdmin = user.getSuperuser()!=null?user.getSuperuser():"n";
					 userType = user.getUserType()!=null?user.getUserType():4; /* usertype=4 is general user*/
					 userId = user.getId();
				}
			mapDetails.put("superAdmin", superAdmin);
			mapDetails.put("userType", userType);
			mapDetails.put("userId", userId);
			map = userMasterHandlerService.showUserAssignedTemplet(mapDetails);
			List<Object[]> districtList = new ArrayList<Object[]>();
			districtList = userMasterHandlerService.getDistrictList();
			map.put("districtList", districtList);
			
			String jsp = "showUserAssinedTemplet.jsp";
			map.put("contentJsp", jsp);
			map.put("hospitalId", hospitalId);
			map.put("districtId", districtId);
			return new ModelAndView("index", "map", map);
		}
	 
	 public ModelAndView searchEmployeeForUserRights(HttpServletRequest request, HttpServletResponse response) {
		 Map<String, Object> map = new HashMap<String, Object>();
		 HttpSession session = request.getSession();
		 Box box = HMSUtil.getBox(request);
		 
		 int hospitalId = 0;
			if(request.getParameter("hospitalId")!=null){
				hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
			}else{
				hospitalId = (Integer) session.getAttribute("hospitalId");
			}
			int districtId = 0;
			if(request.getParameter("districtId")!=null){
				districtId = Integer.parseInt(request.getParameter("districtId"));
			}else{
				districtId = (Integer) session.getAttribute("districtId");
			}
			int insType = 0;
			if(request.getParameter("instType")!=null){
				insType = Integer.parseInt(request.getParameter("instType"));
			}
			LOGGER.info("insType "+insType);
			 box.put("hospitalId", hospitalId);
			 box.put("districtId", districtId);
		 box.put("userId", (Integer) session.getAttribute("userId"));
		 
		 int userType = 0;
			if(session.getAttribute("users") != null){
				Users user = (Users)session.getAttribute("users");
				 userType = user.getUserType()!=null?user.getUserType():4; /* usertype=4 is general user*/
			}
		box.put("userType", userType);
		
		 map = userMasterHandlerService.searchEmployeeForUserRights(box);
		 List<Object[]> districtList = new ArrayList<Object[]>();
		 districtList = userMasterHandlerService.getDistrictList();
		 map.put("districtList", districtList);
		 String jsp = "showUserAssinedTemplet.jsp";
		 map.put("contentJsp", jsp);
		 map.put("insType", insType);
		 map.put("hospitalId", hospitalId);
		 map.put("districtId", districtId);
		 return new ModelAndView("index", "map", map);
	 }
	 
	 public ModelAndView saveUserAssignedTemplet(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			String message = null;

			int empGroupId = 0;
			if (request.getParameter("empGroup") != null) {
				empGroupId = Integer.parseInt(request.getParameter("empGroup"));
			}
			int hospitalId = 0;
			if(request.getParameter("hospitalId")!=null){
				hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
			}else{
				hospitalId = (Integer) session.getAttribute("hospitalId");
			}
			int districtId = 0;
			if(request.getParameter("districtId")!=null){
				districtId = Integer.parseInt(request.getParameter("districtId"));
			}else{
				districtId = (Integer) session.getAttribute("districtId");
			}
			/*
			 * Code for get Dynamic data
			 */
			int counter=0;
			if (request.getParameter("counter") != null
					&& !(request.getParameter("counter").equals(""))) {
				counter= Integer.parseInt(""+request.getParameter("counter"));
				
			}
			int templetCnt=0;
			if (request.getParameter("templetCnt") != null
					&& !(request.getParameter("templetCnt").equals(""))) {
				templetCnt= Integer.parseInt(""+request.getParameter("templetCnt"));
				
			}
			List<Integer> templetIdList=new ArrayList<Integer>();
			List<Integer> userIdList=new ArrayList<Integer>();
			List<Integer> preTempletIdList=new ArrayList<Integer>();
			List<Integer> preUserIdList=new ArrayList<Integer>();
			try {
				Box box = HMSUtil.getBox(request);
				if(counter>0){
					for (int ct = 1; ct <=counter; ct++) {
						int empId=0;
						if (request.getParameter("empId"+ct) != null
								&& !(request.getParameter("empId"+ct).equals(""))) {
							empId= Integer.parseInt(""+request.getParameter("empId"+ct));
							
						}
						int userId=0;
						if (request.getParameter("userId"+ct) != null
								&& !(request.getParameter("userId"+ct).equals(""))) {
							userId= Integer.parseInt(""+request.getParameter("userId"+ct));
							
						}
						Vector<String> tempId = box.getVector("templetIdHidden"+ct);
						Vector<String> preTempletIdVec = box.getVector("preTempletId"+ct);
						Vector<String> changeFlagVec = box.getVector("changeFlag"+ct);
						
						for(int templet=0;templet<tempId.size();templet++){
					

							String changeFlag = "";
							if(changeFlagVec.size()>0){
							changeFlag = changeFlagVec.get(templet);
							}
							if(changeFlag.equalsIgnoreCase("yes")){
								int templetId=0;
								
								if(!tempId.get(templet).equals("0") && !tempId.get(templet).equals("") )
									templetId = Integer.parseInt(tempId.get(templet).toString());
								
							
								if(templetId>0){
									templetIdList.add(templetId);
									userIdList.add(userId);
								}
								int preTempletId=0;

								if(!preTempletIdVec.get(templet).equals("") )
									preTempletId = Integer.parseInt(preTempletIdVec.get(templet).toString());
								
								if(preTempletId>0){
									preTempletIdList.add(preTempletId);
									preUserIdList.add(userId);	
								}
							}
						
						}
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			String userName = "";
			if (session.getAttribute("userName") != null) {
				userName = (String) session.getAttribute("userName");
			}
			int employeeCategoryId=0;
			if (request.getParameter("employeeCategoryId") != null
					&& !(request.getParameter("employeeCategoryId").equals(""))) {
				employeeCategoryId= Integer.parseInt(""+request.getParameter("employeeCategoryId"));
				
			}
			/*
			 * Code for remove rights 
			 */
			Map<String, Object> removeTemplateMap = new HashMap<String, Object>();
			removeTemplateMap.put("preTempletIdList", preTempletIdList);
			removeTemplateMap.put("preUserIdList", preUserIdList);
			removeTemplateMap.put("hospitalId", hospitalId);
			map = userMasterHandlerService.removeTemplateApplicationList(removeTemplateMap);
			/*
			 * Code for remove rights 
			 */
			boolean successfullyAdded=true;
			if(templetIdList.size()>0){
				int index=0;
				for (Integer templateIdInt : templetIdList) {
					
					Map<String, Object> mapDetails = new HashMap<String, Object>();
					mapDetails.put("employeeCategoryId", employeeCategoryId);
					mapDetails.put("templateId", templateIdInt);
			
				    dataMap.put("userName", userName);
					dataMap.put("templateId", templateIdInt);
				
					dataMap.put("hospitalId", hospitalId);
					dataMap.put("empGroupId", empGroupId);
					dataMap.put("userIdList", userIdList);
					dataMap.put("userId", userIdList.get(index));				

					Map<String, Object> mapTempletOnly = new HashMap<String, Object>();
					mapTempletOnly = userMasterHandlerService.addUserWiseTemplateOnly(dataMap);
					if(mapTempletOnly.get("successfullyAdded")!=null){
						successfullyAdded=(Boolean)mapTempletOnly.get("successfullyAdded");
					}
					if(!successfullyAdded){
						message="Error Ocurred Please Try Again";
						break;
					}
					++index;
					
				}
			}
			
			if(successfullyAdded){
				message="User Rights assigned successfully.";
			}

			Box box = HMSUtil.getBox(request);
			Map<String, Object> mapDetails = new HashMap<String, Object>();
			mapDetails.put("employeeCategoryId", employeeCategoryId);
			box.put("hospitalId", hospitalId);
			box.put("districtId", districtId);
			box.put("userName", (String) session.getAttribute("userName"));
		//	map = userMasterHandlerService.showUserAssignedTemplet(mapDetails);
			 int userType = 0;
				if(session.getAttribute("users") != null){
					Users user = (Users)session.getAttribute("users");
					 userType = user.getUserType()!=null?user.getUserType():4; /* usertype=4 is general user*/
				}
			box.put("userType", userType);
			 box.put("userId", (Integer) session.getAttribute("userId"));
			map = userMasterHandlerService.searchEmployeeForUserRights(box);
			List<Object[]> districtList = new ArrayList<Object[]>();
			districtList = userMasterHandlerService.getDistrictList();
			map.put("districtList", districtList);
			map.put("hospitalId", hospitalId);
			map.put("message", message);
			String jsp = "showUserAssinedTemplet.jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
	 
	 
		public ModelAndView getHospitalForDisplay(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			int hospitalId = box.getInt("hospitalId");
			map = userMasterHandlerService.getHospitalForDisplay(hospitalId);
			String jsp = "responseForHospitalDetails";
			return new ModelAndView(jsp, "map", map);
		}
		public ModelAndView getHospitalWiseTemplate(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			int hospitalId = box.getInt("hospitalId");
			map = userMasterHandlerService.getHospitalWiseTemplate(hospitalId);
			String jsp = "responseForHospitalTemplate";
			return new ModelAndView(jsp, "map", map);
		}

		public ModelAndView getTemplateForHospital(HttpServletRequest request,
				HttpServletResponse response) {

			Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			int hospitalId = box.getInt("hospitalId");
			LOGGER.info("hospitalId "+hospitalId);
			map = userMasterHandlerService.getHospitalWiseTemplate(hospitalId);
			String jsp = "responseTemplateList";
			return new ModelAndView(jsp, "map", map);
		
		}

		public ModelAndView getDistrictWiseHospital(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			int districtId = box.getInt("districtId");
			
			List<Object[]> hospitalList = new ArrayList<Object[]>();
			hospitalList = userMasterHandlerService.getHospitalListForTemplateApplication(districtId);
			map.put("hospitalList", hospitalList);
			map.put("formName", box.getString("formName"));
			String jsp = "responseDistrictWiseHospital";
			return new ModelAndView(jsp, "map", map);
		}
		
		
		
	// / for future this method can be used to encrypt all the passwords in the
	// database at one call of this method

	/*
	 * public ModelAndView encryptAllUserPassword(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletRequestBindingException { int
	 * hospitalId=0; hospitalId=(Integer)session.getAttribute("hospitalId");
	 * Map<String, Object> map = new HashMap<String, Object>(); boolean bool =
	 * userMasterHandlerService.encryptAllUserPassword(); if(bool){ map =
	 * userMasterHandlerService.showUserJsp(hospitalId); } jsp=USER_JSP; jsp +=
	 * ".jsp"; title="delete UserGroups"; map.put("contentJsp",jsp);
	 * map.put("title", title);
	 * 
	 * return new ModelAndView("index", "map", map); }
	 */

	// =========================End==========================
		public ModelAndView showInstituteWiseAuthorityLevel(HttpServletRequest request,HttpServletResponse response){
			Map<String,Object>map=new HashMap<String,Object>();
			int hospitalId=0;
			HttpSession session =request.getSession();
			if(session.getAttribute("hospitalId")!=null){
				hospitalId=Integer.parseInt(""+session.getAttribute("hospitalId"));
			}
			map=userMasterHandlerService.showInstituteWiseAuthorityLevel(hospitalId);
			String jsp = "showInstituteWiaseAuthority.jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		public ModelAndView		saveAuthLevelDetails(HttpServletRequest request,HttpServletResponse response){
			Map<String,Object>map=new HashMap<String,Object>();
			
			HttpSession session =request.getSession();
			int userId=0;
			if(session.getAttribute("userId")!=null){
				userId=(Integer)session.getAttribute("userId");
			}
			int authLevel=0;
			int hospitalId=0;
			if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")) {
				hospitalId=Integer.parseInt(request.getParameter("hospital"));
			}
			if(request.getParameter("authLevel")!=null && !request.getParameter("authLevel").equals("0")) {
				authLevel=Integer.parseInt(request.getParameter("authLevel"));
			}
			
			Box box=HMSUtil.getBox(request);
			box.put("userId", userId);
			map=userMasterHandlerService.saveAuthLevelDetails(hospitalId,authLevel,box);
			String jsp = "showInstituteWiaseAuthority.jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView		getResponeValueForAuhorizationLevel(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object>map=new HashMap<String,Object>();
		int val=0;
		if(request.getParameter("authLevel")!=null && !request.getParameter("authLevel").equals("")){
			val=Integer.parseInt(request.getParameter("authLevel"));
		}
		int hospitalId=0;
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("")){
			hospitalId=Integer.parseInt(request.getParameter("hospital"));
		}
		map=userMasterHandlerService.getResponeValueForAuhorizationLevel(val,hospitalId);
		String jsp = "responseForAuthLevel";
		
		return new ModelAndView(jsp, "map", map);
	}
		
		public ModelAndView updateDataForAuthLeve(HttpServletRequest request,HttpServletResponse response){
			Map<String,Object>map=new HashMap<String,Object>();
			HttpSession session =request.getSession();
			int srNo=0;
			if(request.getParameter("srNo")!=null){
				srNo=Integer.parseInt(request.getParameter("srNo"));
			}
			String designation="";
			if(request.getParameter("designation")!=null){
				designation=(request.getParameter("designation"));
			}
			int empId=0;
			if(request.getParameter("empId")!=null){
				empId=Integer.parseInt(request.getParameter("empId"));
			}
			int headerId=0;
			if(request.getParameter("headerId")!=null){
				headerId=Integer.parseInt(request.getParameter("headerId"));
			}
			int userId=0;
			if(session.getAttribute("userId")!=null){
				userId=(Integer)session.getAttribute("userId");
			}
			map=userMasterHandlerService.updateDataForAuthLevel(srNo,designation,empId,headerId,userId);
			String jsp = "messageForDataUpdeInsertForAuth.jsp";
			
			return new ModelAndView("index", "map", map);
		}
		
		
		public ModelAndView saveDataForAuthLeve(HttpServletRequest request,HttpServletResponse response){
			Map<String,Object>map=new HashMap<String,Object>();
			HttpSession session =request.getSession();
			int srNo=0;
			if(request.getParameter("srNo")!=null){
				srNo=Integer.parseInt(request.getParameter("srNo"));
			}
			String designation="";
			if(request.getParameter("designation")!=null){
				designation=(request.getParameter("designation"));
			}
			int empId=0;
			if(request.getParameter("empId")!=null){
				empId=Integer.parseInt(request.getParameter("empId"));
			}
			int headerId=0;
			if(request.getParameter("headerId")!=null){
				headerId=Integer.parseInt(request.getParameter("headerId"));
			}
			int userId=0;
			if(session.getAttribute("userId")!=null){
				userId=(Integer)session.getAttribute("userId");
			}
			map=userMasterHandlerService.saveDataForAuthLeve(srNo,designation,empId,headerId,userId);
			String jsp = "messageForDataUpdeInsertForAuth.jsp";
			
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView showChangePacsPasswordJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			 
			String jsp = "changePacsPassword.jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
	public ModelAndView changePasswordInPacs(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			String message="Pacs user not exist";
			Box box=HMSUtil.getBox(request);
			map = userMasterHandlerService.changePasswordForPACS(box);
			Users users=null; 
			if(map.get("user")!=null){
				users=(Users)map.get("user");
				if(users!=null && users.getPacsUsername()!=null && users.getPacsPassword()!=null){
					String pacsMessage=changePasswordToPacs(users,box);
					if("1".equalsIgnoreCase(pacsMessage)){
						message="Current password is wrong";
					}else if("2".equalsIgnoreCase(pacsMessage)){
						if (request.getParameter("pacsNewPassword") != null) {
							String pacsNewPassword = box.get("pacsNewPassword");
							 users.setPacsPassword(pacsNewPassword);
							 userMasterHandlerService.saveChangePasswordFromPACSToEhealth(users);
						} 
						message="Successfully changed the password";
					}else if("3".equalsIgnoreCase(pacsMessage)){
						message="User is incorrect";
					}else{
						message="Please Try Again!";
					}
				}
			} 
			map.put("message", message);
			String jsp = "changePacsPassword.jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}

		private String saveUserNameAndPasswordToPacs(HttpServletRequest request,
				HttpServletResponse response) {
			String pacsUserName = "";
			String pacsPassword = "";
			String pacsDesignation = "";
			String empName = "";
			boolean isPacsUser = false;
			String message = "";
			if (request.getParameter("pacsUserName") != null) {
				pacsUserName = request.getParameter("pacsUserName");
				isPacsUser = true;
			}
			if (request.getParameter("pacsPassword") != null) {
				pacsPassword = request.getParameter("pacsPassword");
				isPacsUser = true;
			}
			if (request.getParameter("pacsDesignation") != null) {
				pacsDesignation = request.getParameter("pacsDesignation");
				isPacsUser = true;
			}
			if (request.getParameter("employeeName") != null) {
				empName = request.getParameter("employeeName");
				empName = empName.replace(" ", "+");
				isPacsUser = true;
			}
			StringBuilder sb = new StringBuilder();
			URLConnection connection = null;
			InputStreamReader in = null;
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("jktPacs.properties");
			Properties prop = new Properties();
			try {
				prop.load(resourcePath.openStream());
				String pacsUri = prop.getProperty("PACS_URL");
				String pacsPort = prop.getProperty("PACS_PORT");
				String header = prop.getProperty("PACS_CREATE_USER");
				// String
				// testUrl="http://104.211.226.154/createLogin?login=rajat&password=rajat&name=rajat&mobile=&email=&designation=Radiologist&submit+value%3D=Submit+Query";
				String urlVal = header + "login=" + pacsUserName + "&password="
						+ pacsPassword + "&name=" + empName
						+ "&mobile=&email=&designation=" + pacsDesignation;
				LOGGER.info("Url is>>>"+urlVal);
				URL url = new URL(urlVal);
				connection = url.openConnection();
				if (connection != null && connection.getInputStream() != null) {
					in = new InputStreamReader(connection.getInputStream(),
							Charset.defaultCharset());
					BufferedReader bufferedReader = new BufferedReader(in);
					if (bufferedReader != null) {
						int cp;
						while ((cp = bufferedReader.read()) != -1) {
							sb.append((char) cp);
						}
						bufferedReader.close();
					}
					in.close();
				}
				String responseMsg = sb.toString();
				if (responseMsg
						.contains("Success you have created the login successfully")) {
					message = "PACS user created successfully";
				} else if (responseMsg
						.contains("duplicate entry user already exists")) {
					message = "Duplicate entry user already exists in PACS";
				} else if (responseMsg
						.contains("Please enter the mandatory fields")) {
					message = "Mandatory fields is not present in PACS";
				}
				LOGGER.info("Input Stream: " + sb.toString());

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return message;

		}

		private String changePasswordToPacs(Users users,Box box) {
			String pacsUserName = "";
			String pacsOldPassword = "";
			String pacsNewPassword = "";
			String pacsConfirmPassword = ""; 
			boolean isPacsUser = false;
			String message = ""; 
			pacsUserName = users.getPacsUsername();
			pacsOldPassword=users.getPacsPassword();	 
			 
			if (box.get("pacsNewPassword") != null) {
				pacsNewPassword = box.get("pacsNewPassword");
				isPacsUser = true;
			}
			if (box.get("pacsConfirmPassword") != null) {
				pacsConfirmPassword = box.get("pacsConfirmPassword");
				isPacsUser = true;
			} 
			StringBuilder sb = new StringBuilder();
			URLConnection connection = null;
			InputStreamReader in = null;
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("jktPacs.properties");
			Properties prop = new Properties();
			try {
				prop.load(resourcePath.openStream());
				String pacsUri = prop.getProperty("PACS_URL");
				String pacsPort = prop.getProperty("PACS_PORT");
				String header = prop.getProperty("PACS_CHANGE_PASSWORD");
				// String
				// testUrl="http://104.211.226.154/createLogin?login=rajat&password=rajat&name=rajat&mobile=&email=&designation=Radiologist&submit+value%3D=Submit+Query";
				String urlVal = header + "user=" + pacsUserName + "&CurrentPassword="
						+ pacsOldPassword + "&password=" + pacsNewPassword
						+ "&confirmPassword=" + pacsConfirmPassword;
				LOGGER.info("Url is>>>"+urlVal);
				URL url = new URL(urlVal);
				connection = url.openConnection();
				if (connection != null && connection.getInputStream() != null) {
					in = new InputStreamReader(connection.getInputStream(),
							Charset.defaultCharset());
					BufferedReader bufferedReader = new BufferedReader(in);
					if (bufferedReader != null) {
						int cp;
						while ((cp = bufferedReader.read()) != -1) {
							sb.append((char) cp);
						}
						bufferedReader.close();
					}
					in.close();
				}
				String responseMsg = sb.toString();
				if (responseMsg
						.contains("wrong password entered")) {
					message = "1";
				}else if(responseMsg
						.contains("successfully changed the password")){
					message = "2";
				}else if(responseMsg
						.contains("500")){
					message = "3";
				}
				LOGGER.info("Input Stream: " + sb.toString());

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return message;

		}
		
		 public ModelAndView populateLocalityByWardId(HttpServletRequest request, HttpServletResponse response) {
			 	Map<String, Object> map = new HashMap<String, Object>();
				int district = 0;
				
				int wardId=0;
				try {
					Map<String, Object> dataMap = new HashMap<String, Object>();
					if (request.getParameter("districtId") != null) {
						district = Integer.parseInt(request.getParameter("districtId"));
					}
					if (request.getParameter("ward") != null) {
						wardId = Integer.parseInt(request.getParameter("ward"));
					}
					dataMap.put("district", district);
					dataMap.put("wardId", wardId);
					
					map = userMasterHandlerService.populateLocalityByWardId(dataMap);
					jsp = "responseWardForLocality";
				} catch (Exception e) {
					e.printStackTrace();
				}
				return new ModelAndView(jsp, "map", map);
			}
		 
		
		
	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	public SuperAdminMasterHandlerService getSuperAdminMasterHandlerService() {
		return superAdminMasterHandlerService;
	}

	public void setSuperAdminMasterHandlerService(
			SuperAdminMasterHandlerService superAdminMasterHandlerService) {
		this.superAdminMasterHandlerService = superAdminMasterHandlerService;
	}
	
	public void getEmployeeNameById(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		session = request.getSession();
		Integer employeeId=0;
		List<Users> usersList = new ArrayList<Users>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		if (request.getParameter("employeeId") != null) {
			//employeeId = Integer.parseInt(request.getParameter("employeeId"));
			//map1.put("employeeId", employeeId);	
			map1.put("userIdStr",(String)request.getParameter("employeeId"));
		}
		LOGGER.info("employeeId contrl "+employeeId);
		map = userMasterHandlerService.getEmployeeNameById(map1);
		if (map.get("usersList") != null) {
			usersList = (List) map.get("usersList");
		}
LOGGER.info("usersList "+usersList.size());
		StringBuffer sb = new StringBuffer();
		try {
			for (Users user : usersList) {
				String name="";
				if(user.getEmployee().getFirstName()!=null){
					name=name+user.getEmployee().getFirstName()+" ";
				}
				if(user.getEmployee().getLastName()!=null){
					name=name+user.getEmployee().getLastName();
				}
				sb.append("<item>");
				sb.append("<employeeId>" + user.getId()
						+ "</employeeId>");
				sb.append("<employeeName>" + name
						+ "</employeeName>");
				sb.append("<loginName>" + user.getLoginName()
						+ "</loginName>");
				sb.append("</item>");
				
			}

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
	
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
LOGGER.info(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	public ModelAndView getUserListForAutoCompleteItem(
						HttpServletRequest request, HttpServletResponse response) {
			LOGGER.info("call getUserListForAutoCompleteItem");
			HttpSession session = request.getSession();
			session = request.getSession();
			Integer employeeId=0;
			List<Users> usersList = new ArrayList<Users>();
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> map1 = new HashMap<String, Object>();
			String requiredField = "",userIdStr=null;
			if (request.getParameter("requiredField") != null) {
				requiredField = request.getParameter("requiredField");
			}
			LOGGER.info("requiredField "+requiredField);
			if (request.getParameter(requiredField) != null) {
				userIdStr = request.getParameter(requiredField);
				map1.put("userIdStr",userIdStr);
			}
			LOGGER.info("userIdStr contrl "+userIdStr);
			map = userMasterHandlerService.getEmployeeNameById(map1);

		jsp = "userListDiv";
       return new ModelAndView(jsp, "map", map);
	 }
	
	public ModelAndView getRoleTemplateList(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int hospitalId=0;
		if(request.getParameter("hospitalId")!=null){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		detailsMap.put("hospitalId", hospitalId);
		map = userMasterHandlerService.getRoleTemplateList(detailsMap);
		jsp = "roleTemplateDiv";
		title = "Template";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}
	
	public void checkForAlreadyAvailableInstituteCode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String hospitalCode="";
		if(request.getParameter("val")!=null){
			hospitalCode=request.getParameter("val");
		}
		dataMap.put("hospitalCode", hospitalCode);
		HttpSession session=request.getSession();
		map = userMasterHandlerService.checkForAlreadyAvailableInstituteCode(hospitalCode);
		boolean matched=false;
		
		if(map.get("matched")!=null){
			matched=(Boolean)map.get("matched");
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<val>" + matched + "</val>");
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
}
