/**   * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Class LoginController.java 
 * Purpose of the class - This is for Login. 
 * Tables Used: mas_hospital, mas_application, users 
 * @author  Create Date: July 2007  Name: Ritu Sahu 
 * Revision Date:      		Revision By: 
 * @version 1.0  
 **/

package jkt.hms.login.controller;

import static jkt.hms.util.RequestConstants.HOSPITAL;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.LOGIN_NAME;
import static jkt.hms.util.RequestConstants.PASSWORD;
import static jkt.hms.util.RequestConstants.logins;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.login.handler.LoginHandlerService;
import jkt.hms.masters.business.CommunicationMessages;
import jkt.hms.masters.business.HmsNoticeBoard;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmpaneled;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.UserHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.ViewMasApplication;
import jkt.hms.masters.handler.PersonnelMasterHandlerService;
import jkt.hms.stores.handler.StoresHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hms.util.User;
import jkt.hrms.attendance.handler.AttendanceHandlerService;
import jkt.hrms.leave.handler.LeaveDetailsHandlerService;
import jkt.hrms.masters.business.HrLeaveDetails;
import jkt.hrms.masters.business.HrMasFinancialYear;
import jkt.hrms.masters.business.HrNoticeBoardData;
import jkt.hrms.noticeBoard.handler.NoticeBoardHandlerService;
import jkt.hrms.payroll.handler.LoanHandlerService;
import jkt.hrms.recruitment.handler.RecruitmentHandlerService;
import jkt.hrms.recruitment.handler.ResumeHandlerService;
import jkt.hrms.recruitment.masters.business.ResourceRequisition;
import jkt.hrms.training.handler.TrainingHandlerService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
//commented for maven
/*import org.apache.poi.hssf.record.formula.functions.Cell;*/
public class LoginController extends MultiActionController {

	private LoginHandlerService loginHandlerService = null;

	private LeaveDetailsHandlerService leaveHandlerService = null;
	private PersonnelMasterHandlerService personnelMasterHandlerService = null;
	private RecruitmentHandlerService recruitmentHandlerService = null;
	private AttendanceHandlerService attendanceHandlerService = null;
	private LoanHandlerService loanHandlerService = null;
	private TrainingHandlerService trainingHandlerService = null;
	private ResumeHandlerService resumeHandlerService = null;
	private NoticeBoardHandlerService noticeBoardHandlerService = null;
	private StoresHandlerService storesHandlerService = null;
	

	public ResumeHandlerService getResumeHandlerService() {
		return resumeHandlerService;
	}

	public void setResumeHandlerService(
			ResumeHandlerService resumeHandlerService) {
		this.resumeHandlerService = resumeHandlerService;
	}
	
	public StoresHandlerService getStoresHandlerService() {
		return storesHandlerService;
	}

	public void setStoresHandlerService(StoresHandlerService storesHandlerService) {
		this.storesHandlerService = storesHandlerService;
	}

	// Method for getting hospital list
	@SuppressWarnings("unchecked")
	public ModelAndView getHospitalName(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		String loginName = request.getParameter(LOGIN_NAME);
		String password = request.getParameter(PASSWORD);
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		List<UserHospital> hospitalList = new ArrayList<UserHospital>();
		boolean isBlocked = false; // added by amit das on 05-12-2016
	
		String ipAddress = "";
		ipAddress = request.getRemoteAddr();
		
		map = loginHandlerService.getHospitalName(loginName, password,ipAddress);
		int userId=0;
		if(map.get("hospitalList")!=null){
			hospitalList=(List<UserHospital>)map.get("hospitalList");
		}
		if(map.get("userId")!=null){
			userId=(Integer)map.get("userId");
		}
		if(map.get("isBlocked")!=null){
			isBlocked=(Boolean)map.get("isBlocked");
		}
		
		
		
		
		map.put("loginName", loginName);
		map.put("userId",userId);
		if(hospitalList.size() > 0)
			deptList = loginHandlerService.getDepartmentList(map);

		String jsp = "";
		String title = "";
		String message = "";
		if (hospitalList.size() > 0 && deptList.size() > 0) {
			session.setAttribute("loginName", loginName);
			session.setAttribute("password", password);
			map.put("loginName", loginName);
			map.put("password", password);
			map.put("hospitalList", hospitalList);
			map.put("deptList", deptList);
		} else if(isBlocked) { // added by amit das on 05-12-2016
			message = "Account has been blocked for multiple invalid logins. Contact System Administrator.";
			map.put("error", message);
		} else {
			message = "Wrong User name or Password";
			map.put("error", message);
		}

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); 
		
		jsp = "responseForHospital";
		map.put("jsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}
	
	
	// added by amit das on 17-04-2017
	// Method for checking blocked account
	@SuppressWarnings("unchecked")
	public ModelAndView checkForBlockedAccount(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String loginName = request.getParameter(LOGIN_NAME);
		boolean isBlocked = false; 
	
		map = loginHandlerService.checkForBlockedAccount(loginName);
		
		if(map.get("isBlocked")!=null){
			isBlocked=(Boolean)map.get("isBlocked");
		}

		try{
			response.getWriter().write(""+isBlocked);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public ModelAndView getBranchList(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int departmentId = 0;
		if(request.getParameter(RequestConstants.DEPARTMENT_ID)!= null){
			departmentId = Integer.parseInt(request.getParameter(RequestConstants.DEPARTMENT_ID));
		}
		String userName = "";
		if(request.getParameter(LOGIN_NAME)!= null){
			userName = request.getParameter(LOGIN_NAME);
		}
		map = loginHandlerService.getBranchList(departmentId,userName);
		String jsp = "";
		String title = "";
		jsp = "responseForBranch";
		map.put("jsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView homePage(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapCom = new HashMap<String, Object>();
		String jsp = "";

	
		Users users = (Users) session.getAttribute("users");

		MasEmployee employee = users.getEmployee();

		List<HrLeaveDetails> waitingLeavesList = new ArrayList<HrLeaveDetails>();
		List<HrLeaveDetails> todayApprovedLeavesList = new ArrayList<HrLeaveDetails>();

		todayApprovedLeavesList = leaveHandlerService
				.getTodayApprovedLeavesList(employee);

		Users userForRecruitment = null;
		Integer userIdForRecruitment = 0;
		Integer hospitalIdForRecruitment = 0;

		if (session.getAttribute(RequestConstants.USERS) != null) {
			userForRecruitment = (Users) session
					.getAttribute(RequestConstants.USERS);
			userIdForRecruitment = userForRecruitment.getId();
			
			int empId=0;
		    	
			empId = userForRecruitment.getEmployee().getId();
		    	mapCom.put("empId", empId);
			map.put("userId", userIdForRecruitment);
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalIdForRecruitment = (Integer) session
					.getAttribute("hospitalId");
			map.put("hospitalId", hospitalIdForRecruitment);
		}

		Map<String, Object> recruitmentMap = new HashMap<String, Object>();

		recruitmentMap.put("userId", userIdForRecruitment);
		recruitmentMap.put("hospitalId", hospitalIdForRecruitment);

		recruitmentMap = recruitmentHandlerService
				.getRequistionListForUser(recruitmentMap);

		List<ResourceRequisition> resourceRequisitionList = (List) recruitmentMap
				.get("resourceRequisitionList");

	
		List approvedRequestStatusMasterList = recruitmentHandlerService
				.getAllApprovedRequests();

		List joinedCandidates = resumeHandlerService.getJoinedCandidates();

		List lateCandidates = attendanceHandlerService
				.getLateEmployeeList(employee);

		List<HrNoticeBoardData> hrNoticeBoardList = noticeBoardHandlerService
				.getNoticeBoardList();

		map.put("waitingLeavesListSize", waitingLeavesList.size());
		map.put("todayApprovedLeavesListSize", todayApprovedLeavesList.size());
		if (resourceRequisitionList != null
				&& resourceRequisitionList.size() > 0) {
			map.put("resourceRequisitionListSize",
					resourceRequisitionList.size());
		}
		
		mapCom = loginHandlerService.showCommunicationJsp(mapCom);
		List<CommunicationMessages> communicationMessagesList=new ArrayList<CommunicationMessages>();
		int totalMsg=0;
		if (mapCom.get("communicationMessagesList") != null) {
			communicationMessagesList = (List<CommunicationMessages>) mapCom
					.get("communicationMessagesList");
			totalMsg=communicationMessagesList.size();
		}
		map.put("totalMsg",
				totalMsg);
		map.put("approvedRequestStatusMasterListSize",
				approvedRequestStatusMasterList.size());
		map.put("joinedCandidatesSize", joinedCandidates.size());
		map.put("lateCandidatesSize", lateCandidates.size());
		map.put("hrNoticeBoardList", hrNoticeBoardList);

		jsp = "defaultClinirx";
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	// Method for authenticate user at login

	@SuppressWarnings("unchecked")
	public ModelAndView validate(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		try{
		Map<String, Object> map = new HashMap<String, Object>();


			int hospitalId = 0;
			Set<ViewMasApplication> applicationSet = null;
			if (request.getParameter(HOSPITAL) != null) {
				hospitalId = (Integer.parseInt(request.getParameter(HOSPITAL)));
			}


			int deptId = 0;
			if (request.getParameter(RequestConstants.DEPARTMENT_ID) != null) {
				deptId = Integer.parseInt(request
						.getParameter(RequestConstants.DEPARTMENT_ID));
			}
			int branchId = 0;
			if (request.getParameter("branchId") != null) {
				branchId = Integer.parseInt(request.getParameter("branchId"));
			}

			String loginName = "";
			if(request.getParameter(LOGIN_NAME) != null)
			{
				loginName = request.getParameter(LOGIN_NAME);
			}
			String password = "";
			if(request.getParameter(PASSWORD) != null)
			{
				password = request.getParameter(PASSWORD);
			}
			String jsp = "";
			String title = "";
			String message = "";

			if (loginName.equalsIgnoreCase("superadmin")) {
				jsp = "SuperAdminMenu";
				title = "Admin Creation Page";

			} else {

				List<Object> existingUserList = new ArrayList<Object>();
				/**
				 * For LDAP Authentication
				 */


				/*boolean ldapValidate = false;
			if(!loginName.equalsIgnoreCase("jktuser")){
				ldapValidate = LDAPAuthAndSearch.getAuthentcateUserAndPwd(loginName, password);
			}else if(loginName.equalsIgnoreCase("jktuser")){
				ldapValidate = true;
			}
			if(ldapValidate){*/
				
				if(session!=null){
				existingUserList = loginHandlerService.getExistingUser(loginName,
						password);
				session.setAttribute("masHospital", ((Users) existingUserList
						.get(0)).getEmployee().getHospital());

				if (existingUserList.size() > 0) {
					Map<String, Object> mapCom = new HashMap<String, Object>();

					Users users = (Users) existingUserList.get(0);
					int userId = users.getId();
					String loginUser = users.getLoginName();
					String userName = users.getUserName();
					String empName= "";
					int empId=0;
					empId = users.getEmployee().getId();
					empName = users.getEmployee().getEmployeeName();
					mapCom.put("empId", empId);		        

					session.setAttribute("userName", loginUser);
					session.setAttribute("users", users);
					session.setAttribute("userId4DotNet", users.getId());
					session.setAttribute("deptId", deptId);
					session.setAttribute("branchId", branchId);
					session.setAttribute("empId", empId);
					session.setAttribute("empName", empName);
					session.setAttribute("empName1", new User(loginUser));
					
					
					List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
					financialYearList = loginHandlerService.getCurrentFinancialYear();
					if(financialYearList.size() > 0){
						session.setAttribute("financialYear", financialYearList.get(0).getId());
						session.setAttribute("fYearDesc", financialYearList.get(0).getYearDescription());
					}

					/*
					 *  set current financial year in session for accounts
					 */

					List<MasStoreFinancial> financialYearList1 = new ArrayList<MasStoreFinancial>();
					financialYearList1 = loginHandlerService.getCurrentFinancialYearForAccount();

					if(financialYearList1.size() > 0){
						session.setAttribute("financialYear1", financialYearList1.get(0).getId());
						session.setAttribute("fYearDesc1", financialYearList1.get(0).getYearDescription());
					}



					session.setAttribute("loginUser", loginUser);
					session.setAttribute("userId", userId);
					int employeeLevel=0;
					employeeLevel=loginHandlerService.employeeLevel(userId);
					session.setAttribute("employeeLevel", employeeLevel);
					
					Map<String, Object> deptMap = new HashMap<String, Object>();
					deptMap.put("deptId", deptId);
					deptMap.put("empId", empId);
					deptMap=loginHandlerService.getDepartmentDetails(deptMap);


					List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
					if(deptMap.get("masDepartmentList")!=null){
						masDepartmentList=(List<MasDepartment>)deptMap.get("masDepartmentList");
					}
					if(masDepartmentList.size()>0){
						MasDepartment masDepartment=new MasDepartment();
						masDepartment=(MasDepartment)masDepartmentList.get(0);
						session.setAttribute("deptName",masDepartment.getDepartmentName());
						session.setAttribute("deptCode",masDepartment.getDepartmentCode());
					
						if(masDepartment.getDepartmentType()!=null){
							session.setAttribute("deptType",masDepartment.getDepartmentType().getDepartmentTypeCode());
							session.setAttribute("empDeptId",masDepartment.getEmpDept()!=null?masDepartment.getEmpDept().getId():0);
							session.setAttribute("empDeptCode",masDepartment.getEmpDept()!=null?masDepartment.getEmpDept().getEmpDeptCode():"");
						}
					}
					Map<String,Object> dataMap =new HashMap<String, Object>();
					dataMap = loginHandlerService.getLoginHospitalName(hospitalId);
					String hospitalName = "";
					if(dataMap.get("hospitalName")!=null){
						hospitalName = (String)dataMap.get("hospitalName");
					}
					int districtId = 0;
					if(dataMap.get("districtId")!=null){
						districtId = (Integer)dataMap.get("districtId");
					}
					String hospitalCode = "";
					if(dataMap.get("hospitalCode")!=null){
						hospitalCode = (String)dataMap.get("hospitalCode");
					}
					String specialtyType = "";
					if(dataMap.get("specialtyType")!=null){
						specialtyType = (String)dataMap.get("specialtyType");
					}
					session.setAttribute("hospitalName", hospitalName);
					session.setAttribute("districtId", districtId);
					session.setAttribute("hospitalCode", hospitalCode);
					session.setAttribute("specialtyType", specialtyType);
					
					jsp="loginDetails";
				
					title = "Home Page";
					session.setAttribute(HOSPITAL_ID, hospitalId);
					int authLevel=0;
					authLevel=loginHandlerService.getAuthLevel(hospitalId);
					session.setAttribute("authLevel", authLevel);
					int hospitalTypeId=0;
					hospitalTypeId=loginHandlerService.getHospitalType(hospitalId);
					session.setAttribute("hospitalTypeId", hospitalTypeId);
					applicationSet = loginHandlerService.getApplications(users,
							hospitalId);

					session.setAttribute("applicationSet", applicationSet);

					List<Object[]> lastLoginDetailsList = new ArrayList<Object[]>();


					lastLoginDetailsList = (List<Object[]>) loginHandlerService.getLastLoginDetails(userId);
					map.put("lastLoginDetailsList", lastLoginDetailsList);
					map.put("successLoginDate", users.getLastSuccessfulLoginDate());
					map.put("successLoginTime", users.getLastSuccessfulLoginTime());
					Box box = HMSUtil.getBox(request);
					box.put("userId", userId);
				  	box.put("deptId", deptId);
				  	box.put("empId", empId);
				  	box.put("hospitalId", hospitalId);
				  	box.put("status", "y");
					loginHandlerService.updateLogoutDetail(box);
					loginHandlerService.reassignPatientsToDoctor(box);
					boolean updated = loginHandlerService.updateLoginDateTime(userId);



				} else {
					message = "Wrong User name or Password";
					map.put("error", message);
					jsp = "loginClinirx";
					title = "Login";
				}
				/*	} else {
				message = "LDAP Authentication Failed.";
				map.put("error", message);
				jsp = "login";
				title = "Login";
			}*/// LDAP LOOP
			}
			}
			map.put("jsp", jsp);
			map.put("title", title);
			map.put("applicationSet", applicationSet);
			 return new ModelAndView(jsp, "map", map);
	
		
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	
	
		
		
	}
	
	
	@SuppressWarnings("unchecked")
	public ModelAndView validate1(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		try{

		
			

			String loginName = "";
			if(request.getParameter(LOGIN_NAME) != null)
			{
				loginName = request.getParameter(LOGIN_NAME);
			}
			String password = "";
			if(request.getParameter(PASSWORD) != null)
			{
				password = request.getParameter(PASSWORD);
			}
			String jsp = "";
			String title = "";
			if (loginName.equalsIgnoreCase("superadmin")) {
				
				jsp = "SuperAdminMenu";
				title = "Admin Creation Page";

			} else {

				List<Object> existingUserList = new ArrayList<Object>();
				/**
				 * For LDAP Authentication
				 */


				/*boolean ldapValidate = false;
			if(!loginName.equalsIgnoreCase("jktuser")){
				ldapValidate = LDAPAuthAndSearch.getAuthentcateUserAndPwd(loginName, password);
			}else if(loginName.equalsIgnoreCase("jktuser")){
				ldapValidate = true;
			}
			if(ldapValidate){*/
				existingUserList = loginHandlerService.getExistingUser(loginName,
						password);

				if (existingUserList.size() > 0) {
					session.setAttribute("masHospital", ((Users) existingUserList
							.get(0)).getEmployee().getHospital());
					Map<String, Object> mapCom = new HashMap<String, Object>();

					Users users = (Users) existingUserList.get(0);
				
					String loginUser = users.getLoginName();
				
					int empId=0;
					empId = users.getEmployee().getId();
			
					mapCom.put("empId", empId);
					
					 HttpSession session1 = logins.get(loginUser);
			         PrintWriter pw = response.getWriter();	
			         pw.write("[");
			        if(session1 != null)
			        {
			        	 pw.write("{\"Session\": \"yes\"}");
			        }
			        else
			        {
			        	pw.write("{\"Session\": \"no\"}");
			        }

			        pw.write("]");
				} 
			}

		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	
		return null;	
		
	}
	
	@SuppressWarnings("unchecked")
public ModelAndView validateEmpanelledLogin(HttpServletRequest request,HttpServletResponse response) {
		
		HttpSession session = request.getSession(true);
		String csrfToken = UUID.randomUUID().toString();
	    session.setAttribute("csrfToken", csrfToken);
		
		Map<String, Object> map = new HashMap<String, Object>();		

	
		String loginName = request.getParameter(LOGIN_NAME);
		String password = request.getParameter(PASSWORD);
		String jsp = "";
		String title = "";
		String message = "";
		
		
			List<Object> existingUserList = new ArrayList<Object>();
			String UserType="Empanelled";
			
			existingUserList= loginHandlerService.getExistingOtherUser(loginName,password, UserType);
			
			boolean st = true;
			if (existingUserList.size() > 0) 
			{
						
		
				MasEmpaneled users = (MasEmpaneled) existingUserList.get(0);
				if(users != null)
				{
					if(users.getStatus() != null)
					{
						if(users.getStatus().equals("n"))
							st = false;
					}
				}
				if(st)
				{
					String userName = "";
					String storesName = "";
					
					int empanelledId = 0;
					userName = users.getContactPerson();
					storesName = users.getEmpaneledName();
					empanelledId= users.getId();
					
					session.setAttribute("userName", userName);
					session.setAttribute("users", users);
					session.setAttribute("userId", users.getId());
					session.setAttribute("storesName", storesName);
					session.setAttribute("empanelledId", empanelledId);
					session.setAttribute("empName2", new User(userName));
					if(users.getDepartment()!=null 
							&& users.getDepartment().getDepartmentType()!=null 
							&& users.getDepartment().getDepartmentType().getDepartmentTypeCode()!=null){
						session.setAttribute("deptType", users.getDepartment().getDepartmentType().getDepartmentTypeCode());
					} 
					if(users.getDepartment()!=null){
						session.setAttribute("deptId", users.getDepartment().getId());
					} 
					//empaneled user logind not define as hospital type there 
					//for i am adding hard coded hospital id for testing by rajat
					session.setAttribute(HOSPITAL_ID, 1);
					

					Box box = HMSUtil.getBox(request);
					box.put("empanelledId", empanelledId);
					if(users.getDepartment()!=null && users.getDepartment().getDepartmentCode()!=null){
						session.setAttribute("empaneledAccessDepartmentCode", users.getDepartment().getDepartmentCode());
						session.setAttribute("empanelledDashBoard", "empanelledDashBoard");
					}
					
					jsp = "dashboardEmpaneled";
					
					jsp = jsp + ".jsp";
					title = "GRN";
					map.put("contentJsp", jsp);
					map.put("title", title);
					return new ModelAndView("index", "map", map);
	
	
					
				}
				else
				{
					message = "Users are not active";
					map.put("error", message);
					jsp = "login_empanel";
					title = "welcome";
					map.put("jsp", jsp);
					map.put("title", title);
					
					return new ModelAndView(jsp, "map", map);
				}
			} 
			
			else
			{
				message = "Wrong User name or Password";
				map.put("error", message);
				jsp = "login_empanel";
				title = "welcome";
				map.put("jsp", jsp);
				map.put("title", title);
				
				return new ModelAndView(jsp, "map", map);
			}
			
		
	}

	public ModelAndView logout(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		if (session != null) {
			session.invalidate();
		}

		String message = "Your Session has expired";
		map.put("message", message);
		return new ModelAndView("framesetpopup", "map", map);
	}
	
	public ModelAndView logoutOtherUser(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}
		return new ModelAndView("login_empanel");
	}
	public ModelAndView showLoginJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (session.getAttribute("csrfURL").equals(request.getParameter("secure"))) {
			return new ModelAndView("login");
		}else{
			if(session!=null)
				session.invalidate();
			return new ModelAndView("error1");
		}
		
	}

	public void getNoticeData(HttpServletRequest request,
			HttpServletResponse response) {
		List<HmsNoticeBoard> noticeBoardList = new ArrayList<HmsNoticeBoard>();
		noticeBoardList = (List) loginHandlerService.getNoticeMessage();

		StringBuffer sb = new StringBuffer();
		if (noticeBoardList != null && noticeBoardList.size() > 0) {
			String notice = noticeBoardList.get(0).getDesc();
			if (notice != null && !notice.equals("")) {
				sb.append("<desc>" + notice + "</desc>");
			} else {
				sb.append("<desc>" + "nodesc" + "</desc>");
			}
		} else {
			sb.append("<desc>" + "nodesc" + "</desc>");
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<notice>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</notice>");
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ModelAndView showCalculator(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "calculator";
		return new ModelAndView(jsp, "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView showHomeJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView getTelephoneDirectory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		map=loginHandlerService.getTelephoneDirectory();
		List<Object[]> employeeTeleDirec=new ArrayList<Object[]>();
		if (map.get("alist") != null) {
			employeeTeleDirec = (List<Object[]>) map
					.get("alist");
		}
		map.put("alist",employeeTeleDirec);
		String jsp = "messageForTele";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	  public ModelAndView showModuleDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
	    	Map<String,Object> map = new HashMap<String,Object>();
	    	map.put("moduleName", request.getParameter("moduleName"));
	    	HttpSession session = request.getSession();
	    	session.removeAttribute("appId");
			session.setAttribute("appId", request.getParameter("appId"));
	    	String jsp = "moduleDefault";
	    	
	    	return new ModelAndView(jsp, "map", map);
	        
		}
	  
	  public ModelAndView updateLastLoginDetails(HttpServletRequest request , HttpServletResponse response) {
		  	Map<String,Object> map = new HashMap<String,Object>();
		  	Set<ViewMasApplication> applicationSet = null;
		  	HttpSession session  = request.getSession();
		  	int userId =0;
		  	int hospitalId =0;int deptId=0;
		  	if(session.getAttribute("userId") != null)
		  	{
		  		userId = (Integer)session.getAttribute("userId");
		  		hospitalId = (Integer)session.getAttribute("hospitalId");
		  	}
		  	if(session.getAttribute("deptId")!=null){
		  		deptId =(Integer) session.getAttribute("deptId");
		  	}
		  	
		  	Users users = (Users)session.getAttribute("users");
		
		  	Box box = HMSUtil.getBox(request);
		  	box.put("userId", userId);
		  	box.put("deptId", deptId);
		  	box.put("status", "y");
	  		map = loginHandlerService.updateLastLoginDetails(box);
	  		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	  		if (map.get("deptList")!=null){
	  			deptList  = (List)map.get("deptList");
	  			session.setAttribute("deptList", deptList);
	  		}
	  		
	  		applicationSet = loginHandlerService.getApplications(users,
					hospitalId);
			session.setAttribute("applicationSet", applicationSet);
			return new ModelAndView("index","map",map);
	}
	  
	  
	  public ModelAndView showReceptionDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
          Map<String,Object> map = new HashMap<String,Object>();
          map.put("moduleName", "Reception");
          HttpSession session = request.getSession();
              session.setAttribute("appId", "A3");
          String jsp = "moduleDefault";
          return new ModelAndView(jsp, "map", map);
      
      }


	  public ModelAndView showOPClinicDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
          Map<String,Object> map = new HashMap<String,Object>();
          map.put("moduleName", "OPClinic");
          HttpSession session = request.getSession();
              session.setAttribute("appId", "A332");
          String jsp = "moduleDefault";
          return new ModelAndView(jsp, "map", map);
      
      }
	  public ModelAndView showLaboratoryDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
          Map<String,Object> map = new HashMap<String,Object>();
          map.put("moduleName", "Lab");
          HttpSession session = request.getSession();
              session.setAttribute("appId", "A328");
          String jsp = "moduleDefault";
          return new ModelAndView(jsp, "map", map);
      
      }
	  public ModelAndView showRadiologyDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
          Map<String,Object> map = new HashMap<String,Object>();
          map.put("moduleName", "Radiology");
          HttpSession session = request.getSession();
              session.setAttribute("appId", "A504");
          String jsp = "moduleDefault";
          return new ModelAndView(jsp, "map", map);
      
      }
	  public ModelAndView showPharmacyDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
          Map<String,Object> map = new HashMap<String,Object>();
          int departmentId = 0;
	       	int hospitalId = 0;
	       	Box box = HMSUtil.getBox(request);
	        HttpSession session = request.getSession();
	       	if(session.getAttribute("deptId")!=null){
	       		departmentId = Integer.parseInt((session.getAttribute("deptId")).toString());
	       		box.put("departmentId", departmentId);
	       	}
	       	if(session.getAttribute("hospitalId")!=null){
	       		hospitalId = Integer.parseInt((session.getAttribute("hospitalId")).toString());
	       		box.put("hospitalId", hospitalId);
	       	}
	       	map = 	storesHandlerService.displaySlowMovingDrugsJsp(box);
	       	map.put("moduleName", "Pharmacy");
              session.setAttribute("appId", "A1017");
          String jsp = "moduleDefault";
          return new ModelAndView(jsp, "map", map);
      
      }
	  public ModelAndView showLaboratoryDefaultJspForEmpaneled(HttpServletRequest request , HttpServletResponse response) {
          Map<String,Object> map = new HashMap<String,Object>();
          map.put("moduleName", "Lab");
          HttpSession session = request.getSession();
              session.setAttribute("appId", "E328");
          String jsp = "moduleDefault";
          return new ModelAndView(jsp, "map", map);
      
      }
	  public ModelAndView showRadiologyDefaultJspForEmpaneled(HttpServletRequest request , HttpServletResponse response) {
          Map<String,Object> map = new HashMap<String,Object>();
          map.put("moduleName", "Radiology");
          HttpSession session = request.getSession();
              session.setAttribute("appId", "E504");
          String jsp = "moduleDefault";
          return new ModelAndView(jsp, "map", map);
      
      }
	  public ModelAndView showPharmacyDefaultJspForEmpaneled(HttpServletRequest request , HttpServletResponse response) {
          Map<String,Object> map = new HashMap<String,Object>();
          map.put("moduleName", "Pharmacy");
          HttpSession session = request.getSession();
              session.setAttribute("appId", "E1017");
          String jsp = "moduleDefault";
          return new ModelAndView(jsp, "map", map);
      
      } 
	  public ModelAndView showWardDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
          Map<String,Object> map = new HashMap<String,Object>();
          map.put("moduleName", "Ward");
          HttpSession session = request.getSession();
              session.setAttribute("appId", "A105");
          String jsp = "moduleDefault";
          return new ModelAndView(jsp, "map", map);
      
      }
	  public ModelAndView showStoresDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
          Map<String,Object> map = new HashMap<String,Object>();
          HttpSession session = request.getSession();
	        int departmentId = 0;
	       	int hospitalId = 0;
	       	Box box = HMSUtil.getBox(request);
	       	if(session.getAttribute("deptId")!=null){
	       		departmentId = Integer.parseInt((session.getAttribute("deptId")).toString());
	       		box.put("departmentId", departmentId);
	       	}
	       	if(session.getAttribute("hospitalId")!=null){
	       		hospitalId = Integer.parseInt((session.getAttribute("hospitalId")).toString());
	       		box.put("hospitalId", hospitalId);
	       	}
	       	map = 	storesHandlerService.displaySlowMovingDrugsJsp(box);
	        map.put("moduleName", "Stores");
            session.setAttribute("appId", "A89");
           String jsp = "moduleDefault";
	          return new ModelAndView(jsp, "map", map);
	      
      }
	  public ModelAndView showBillingDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
          Map<String,Object> map = new HashMap<String,Object>();
          map.put("moduleName", "Billing");
          HttpSession session = request.getSession();
              session.setAttribute("appId", "A1");
          String jsp = "moduleDefault";
          return new ModelAndView(jsp, "map", map);
      
      }
	
	  public ModelAndView showOTDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
          Map<String,Object> map = new HashMap<String,Object>();
          map.put("moduleName", "OT");
          HttpSession session = request.getSession();
              session.setAttribute("appId", "A376");
          String jsp = "moduleDefault";
          return new ModelAndView(jsp, "map", map);
      
      }
	  public ModelAndView showBloodBankDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
          Map<String,Object> map = new HashMap<String,Object>();
          map.put("moduleName", "Blood Bank");
          HttpSession session = request.getSession();
              session.setAttribute("appId", "A1174");
          String jsp = "moduleDefault";
          return new ModelAndView(jsp, "map", map);
      
      }
	  public ModelAndView showProcurementDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
          Map<String,Object> map = new HashMap<String,Object>();
          map.put("moduleName", "Procurement");
          HttpSession session = request.getSession();
              session.setAttribute("appId", "A1576");
          String jsp = "moduleDefault";
          return new ModelAndView(jsp, "map", map);
      
      }
	  public ModelAndView showMaintenanceDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
          Map<String,Object> map = new HashMap<String,Object>();
          map.put("moduleName", "Maintenance");
          HttpSession session = request.getSession();
              session.setAttribute("appId", "A1548");
          String jsp = "moduleDefault";
          return new ModelAndView(jsp, "map", map);
      
      }
	  public ModelAndView showHRMSDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
          Map<String,Object> map = new HashMap<String,Object>();
          map.put("moduleName", "HRMS");
          HttpSession session = request.getSession();
              session.setAttribute("appId", "A402");
          String jsp = "moduleDefault";
          return new ModelAndView(jsp, "map", map);
      
      }
	  public ModelAndView showAccountsDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
          Map<String,Object> map = new HashMap<String,Object>();
          map.put("moduleName", "Accounts");
          HttpSession session = request.getSession();
              session.setAttribute("appId", "A522");
          String jsp = "moduleDefault";
          return new ModelAndView(jsp, "map", map);
      
      }
	  public ModelAndView showPublicHealthDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
          Map<String,Object> map = new HashMap<String,Object>();
          map.put("moduleName", "Public Health");
          HttpSession session = request.getSession();
              session.setAttribute("appId", "A1667");
          String jsp = "moduleDefault";
          return new ModelAndView(jsp, "map", map);
      
      }
	  public ModelAndView showSMSDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
          Map<String,Object> map = new HashMap<String,Object>();
          map.put("moduleName", "SMS");
          HttpSession session = request.getSession();
              session.setAttribute("appId", "A1793");
          String jsp = "moduleDefault";
          return new ModelAndView(jsp, "map", map);
      
      }
	  public ModelAndView showMastersDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
          Map<String,Object> map = new HashMap<String,Object>();
          map.put("moduleName", "Masters");
          HttpSession session = request.getSession();
              session.setAttribute("appId", "A2");
          String jsp = "moduleDefault";
          return new ModelAndView(jsp, "map", map);
      
      }
	  public ModelAndView showAdminDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
          Map<String,Object> map = new HashMap<String,Object>();
          map.put("moduleName", "Admin");
          HttpSession session = request.getSession();
              session.setAttribute("appId", "A324");
          String jsp = "moduleDefault";
          return new ModelAndView(jsp, "map", map);
      
      }
	  public ModelAndView showMISDefaultJsp(HttpServletRequest request , HttpServletResponse response) {
          Map<String,Object> map = new HashMap<String,Object>();
          map.put("moduleName", "MIS");
          
          HttpSession session = request.getSession();
              session.setAttribute("appId", "A112");
          String jsp = "moduleDefault";
          return new ModelAndView(jsp, "map", map);
      
      }
	  
	  
	 
	  
	  public ModelAndView showEmpanelLogin(HttpServletRequest request,
				HttpServletResponse response) {
			return new ModelAndView("login_empanel");		
			
		}
	  
	  
	  
	public LoginHandlerService getLoginHandlerService() {
		return loginHandlerService;
	}

	public void setLoginHandlerService(LoginHandlerService loginHandlerService) {
		this.loginHandlerService = loginHandlerService;
	}

	public PersonnelMasterHandlerService getPersonnelMasterHandlerService() {
		return personnelMasterHandlerService;
	}

	public void setPersonnelMasterHandlerService(
			PersonnelMasterHandlerService personnelMasterHandlerService) {
		this.personnelMasterHandlerService = personnelMasterHandlerService;
	}

	public RecruitmentHandlerService getRecruitmentHandlerService() {
		return recruitmentHandlerService;
	}

	public void setRecruitmentHandlerService(
			RecruitmentHandlerService recruitmentHandlerService) {
		this.recruitmentHandlerService = recruitmentHandlerService;
	}

	public AttendanceHandlerService getAttendanceHandlerService() {
		return attendanceHandlerService;
	}

	public void setAttendanceHandlerService(
			AttendanceHandlerService attendanceHandlerService) {
		this.attendanceHandlerService = attendanceHandlerService;
	}

	public LoanHandlerService getLoanHandlerService() {
		return loanHandlerService;
	}

	public void setLoanHandlerService(LoanHandlerService loanHandlerService) {
		this.loanHandlerService = loanHandlerService;
	}

	public TrainingHandlerService getTrainingHandlerService() {
		return trainingHandlerService;
	}

	public void setTrainingHandlerService(
			TrainingHandlerService trainingHandlerService) {
		this.trainingHandlerService = trainingHandlerService;
	}

	public LeaveDetailsHandlerService getLeaveHandlerService() {
		return leaveHandlerService;
	}

	public void setLeaveHandlerService(
			LeaveDetailsHandlerService leaveHandlerService) {
		this.leaveHandlerService = leaveHandlerService;
	}

	public NoticeBoardHandlerService getNoticeBoardHandlerService() {
		return noticeBoardHandlerService;
	}

	public void setNoticeBoardHandlerService(
			NoticeBoardHandlerService noticeBoardHandlerService) {
		this.noticeBoardHandlerService = noticeBoardHandlerService;
	}

}