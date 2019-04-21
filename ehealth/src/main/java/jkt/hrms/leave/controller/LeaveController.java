package jkt.hrms.leave.controller;

/*import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
 import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
 import static jkt.hrms.util.HrmsRequestConstants.*; */

import static jkt.hrms.util.HrmsRequestConstants.ALLOWED_DAYS;
import static jkt.hrms.util.HrmsRequestConstants.APPLY_LEAVES_JSP;
import static jkt.hrms.util.HrmsRequestConstants.APPLY_SHORT_LEAVES_JSP;
import static jkt.hrms.util.HrmsRequestConstants.APPROVED_BY;
import static jkt.hrms.util.HrmsRequestConstants.APPROVED_BY_OTHER;
import static jkt.hrms.util.HrmsRequestConstants.APPROVED_LEAVES_JSP;
import static jkt.hrms.util.HrmsRequestConstants.CARRY_FORWARD;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_BY;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_DATE;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_TIME;
import static jkt.hrms.util.HrmsRequestConstants.CONTACT_ADDRESS;
import static jkt.hrms.util.HrmsRequestConstants.CONTACT_DETAILS_JSP;
import static jkt.hrms.util.HrmsRequestConstants.CONTACT_PHONE;
import static jkt.hrms.util.HrmsRequestConstants.DEPARTMENT_ID;
import static jkt.hrms.util.HrmsRequestConstants.DISAPPROVED_LEAVES_JSP;
import static jkt.hrms.util.HrmsRequestConstants.EMAIL;
import static jkt.hrms.util.HrmsRequestConstants.EMP_NAME;
import static jkt.hrms.util.HrmsRequestConstants.ENCASHMENT_LEAVE_FORM;
import static jkt.hrms.util.HrmsRequestConstants.ENCHASHMENT;
import static jkt.hrms.util.HrmsRequestConstants.ENCHASHMENT_CHECK;
import static jkt.hrms.util.HrmsRequestConstants.FROM_DATE;
import static jkt.hrms.util.HrmsRequestConstants.HALF_DAY;
import static jkt.hrms.util.HrmsRequestConstants.HR_EMP_ACC_DEPART;
import static jkt.hrms.util.HrmsRequestConstants.HR_MESSAGE_JSP;
import static jkt.hrms.util.HrmsRequestConstants.JOINING_DATE;
import static jkt.hrms.util.HrmsRequestConstants.LEAVE_BALANCE;
import static jkt.hrms.util.HrmsRequestConstants.LEAVE_DETAILS_HISTORY_JSP;
import static jkt.hrms.util.HrmsRequestConstants.LEAVE_DETAILS_JSP;
import static jkt.hrms.util.HrmsRequestConstants.LEAVE_STATUS;
import static jkt.hrms.util.HrmsRequestConstants.LEAVE_STATUS_JSP;
import static jkt.hrms.util.HrmsRequestConstants.LEAVE_TO_ENCASH;
import static jkt.hrms.util.HrmsRequestConstants.LEAVE_TYPE;
import static jkt.hrms.util.HrmsRequestConstants.LEAVE_TYPE_ID;
import static jkt.hrms.util.HrmsRequestConstants.MANAGER_TYPE;
import static jkt.hrms.util.HrmsRequestConstants.MONTHLY_OR_YEARLY;
import static jkt.hrms.util.HrmsRequestConstants.MY_DETAILS_JSP;
import static jkt.hrms.util.HrmsRequestConstants.NO_OF_WORKING_DAYS;
import static jkt.hrms.util.HrmsRequestConstants.OLD_LEAVE_BALANCE;
import static jkt.hrms.util.HrmsRequestConstants.REASON;
import static jkt.hrms.util.HrmsRequestConstants.REMARKS;
import static jkt.hrms.util.HrmsRequestConstants.SEARCH_LEAVE_BALANCE_JSP;
import static jkt.hrms.util.HrmsRequestConstants.SHORT_LEAVE_HALF_DAY;
import static jkt.hrms.util.HrmsRequestConstants.SHOW_LEAVE_BALANCE_JSP;
import static jkt.hrms.util.HrmsRequestConstants.SHOW_LEAVE_TYPE_MASTER_JSP;
import static jkt.hrms.util.HrmsRequestConstants.TEAM_DETAILS_JSP;
import static jkt.hrms.util.HrmsRequestConstants.TITLE;
import static jkt.hrms.util.HrmsRequestConstants.TO_DATE;
import static jkt.hrms.util.HrmsRequestConstants.TYPE;
import static jkt.hrms.util.HrmsRequestConstants.USERS;
import static jkt.hrms.util.HrmsRequestConstants.WAITING_LEAVES_ENCASHMENT_JSP;
import static jkt.hrms.util.HrmsRequestConstants.WAITING_LEAVES_FOR_HR_JSP;
import static jkt.hrms.util.HrmsRequestConstants.WAITING_LEAVES_JSP;
import static jkt.hms.util.RequestConstants.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hrms.leave.handler.LeaveDetailsHandlerService;
import jkt.hrms.masters.business.Holidaycalendar;
import jkt.hrms.masters.business.HrEmployeeBalance;
import jkt.hrms.masters.business.HrEmployeeBalanceNew;
import jkt.hrms.masters.business.HrEmployeePersonelDetails;
import jkt.hrms.masters.business.HrEncashmentDetails;
import jkt.hrms.masters.business.HrLeaveDetails;
import jkt.hrms.masters.business.HrMasLeave;
import jkt.hrms.masters.business.HrMasLeaveStatus;
import jkt.hrms.masters.business.HrMasLeaveTypeMediator;
import jkt.hrms.masters.business.HrMasLeaveTypeNew;
import jkt.hrms.masters.business.HrUpdateLeaveBalanceHistory;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hrms.masters.business.UserManager;
import jkt.hrms.util.LeaveManagementUtil;
import jkt.security.masters.handler.UserMasterHandlerService;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class LeaveController extends MultiActionController {

	private LeaveDetailsHandlerService leaveHandlerService = null;
	private UserMasterHandlerService userMasterHandlerService = null;
	public String s = "";
	HttpSession session = null;
    String jsp="";
    String title="";
	@SuppressWarnings("unchecked")
	public ModelAndView showLeaveApplicationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		List listOfLeaveApprovingAuthorities = null;
		List listOfTypesOfLeaves = null;
		List listOfRestrictedHolidays = null;
		List listOfManagers = null;
		List listOfHolidays = null;
		List listOfRhAvailed = null;
		List birthdayLeaveList = null;
		List anniversaryLeaveList = null;
		List paternityLeaveList = null;
		List encashmentLeaveWaiting = null;
		//
		// HrEmployeeBalance leaveBalance=null;

		List<HrEmployeeBalanceNew> leaveBalance = null;

		List<MasEmployee> userList = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		
		
		// session = request.getSession();

		Users user = (Users) session.getAttribute(USERS);
		MasEmployee employee = user.getEmployee();
		//int desig_order = user.getEmployee().getRank().getDesignationOrder();
		mapForDs.put("employeeId", employee.getId());
		//mapForDs.put("desig_order", desig_order);
		
		if(employee.getEmployeeDepartment()!=null && employee.getEmployeeDepartment().getId()!=null && !employee.getEmployeeDepartment().getId().equals("")){
				mapForDs.put("deptId", employee.getEmployeeDepartment().getId());}
		

		List manager = leaveHandlerService.getManager(employee.getId());
		
		
		List<MasEmployee> userDepartmentEmployeeList = new ArrayList<MasEmployee>();
		
		if(employee.getEmployeeDepartment()!=null)
		userDepartmentEmployeeList=leaveHandlerService.getEmployeeOfSameDepartment(employee.getId(), employee.getEmployeeDepartment().getId());
		// userList = userMasterHandlerService.getEmployeeList();

		// listOfLeaveApprovingAuthorities =
		// userMasterHandlerService.getEmployeeList();

		// changes
		// listOfTypesOfLeaves=leaveHandlerService.getLeaveTypeList();
		// listOfTypesOfLeaves = leaveHandlerService.getMasLeaveTypeNewList();
		listOfTypesOfLeaves = leaveHandlerService.getMasLeaveTypeMediatorList();

		listOfRestrictedHolidays = leaveHandlerService.getRestrictedHolidays();

		listOfHolidays = leaveHandlerService.getHolidays();

		// listOfManagers = leaveHandlerService.getManagers();
		listOfRhAvailed = leaveHandlerService.getRhAvailed(employee);
		birthdayLeaveList = leaveHandlerService.getBirthdayLeave(employee
				.getId());
		anniversaryLeaveList = leaveHandlerService.getAnniversaryLeave(employee
				.getId());
		paternityLeaveList = leaveHandlerService.getPaternityLeave(employee
				.getId());

		leaveBalance = leaveHandlerService.getLeaveBalance(employee.getId());
		List<HrMasLeaveTypeNew> masLeaveTypeList = leaveHandlerService.getMasLeaveTypeNewList();
		// encashmentLeaveWaiting =
		// leaveHandlerService.getWaitingEncashmentLeave(employee);

		map = leaveHandlerService.getUserDetails(mapForDs);

		map.put("listOfLeaveApprovingAuthorities",
				listOfLeaveApprovingAuthorities);
		map.put("listOfTypesOfLeaves", listOfTypesOfLeaves);
		map.put("manager", manager);
		map.put("bday", new Date());
		map.put("anniversary", new Date());
		map.put("listOfManagers", listOfManagers);
		map.put("listOfRestrictedHolidays", listOfRestrictedHolidays);
		map.put("listOfHolidays", listOfHolidays);
		map.put("listOfRhAvailed", listOfRhAvailed);
		map.put("birthdayLeaveList", birthdayLeaveList);
		map.put("anniversaryLeaveList", anniversaryLeaveList);
		map.put("paternityLeaveList", paternityLeaveList);
		map.put("leaveBalance", leaveBalance);
		map.put("encashmentLeaveWaiting", encashmentLeaveWaiting);
		map.put("userList", userList);
		map.put("userDepartmentEmployeeList", userDepartmentEmployeeList);
		map.put("masLeaveTypeList", masLeaveTypeList);
		

		// map.put(MAIN,APPLY_LEAVES_JSP);
		String jsp = APPLY_LEAVES_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		// map.put(TITLE,"Apply Leave" );
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showShortLeaveApplicationForm(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		List listOfLeaveApprovingAuthorities = null;
		List listOfTypesOfLeaves = null;
		List listOfRestrictedHolidays = null;
		List listOfManagers = null;
		List listOfHolidays = null;
		List listOfRhAvailed = null;
		List birthdayLeaveList = null;
		List anniversaryLeaveList = null;
		List paternityLeaveList = null;
		List encashmentLeaveWaiting = null;
		//
		// HrEmployeeBalance leaveBalance=null;

		List<HrEmployeeBalanceNew> leaveBalance = null;

		List<MasEmployee> userList = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		// session = request.getSession();

		Users user = (Users) session.getAttribute(USERS);
		MasEmployee employee = user.getEmployee();

		mapForDs.put("employeeId", employee.getId());

		List manager = leaveHandlerService.getManager(employee.getId());
		// userList = userMasterHandlerService.getEmployeeList();

		// listOfLeaveApprovingAuthorities =
		// userMasterHandlerService.getEmployeeList();

		// changes
		// listOfTypesOfLeaves=leaveHandlerService.getLeaveTypeList();
		// listOfTypesOfLeaves = leaveHandlerService.getMasLeaveTypeNewList();
		// listOfTypesOfLeaves =
		// leaveHandlerService.getMasLeaveTypeMediatorList();

		// listOfRestrictedHolidays
		// =leaveHandlerService.getRestrictedHolidays();

		// listOfHolidays=leaveHandlerService.getHolidays();

		// listOfManagers = leaveHandlerService.getManagers();
		// listOfRhAvailed=leaveHandlerService.getRhAvailed(employee);
		// birthdayLeaveList =
		// leaveHandlerService.getBirthdayLeave(employee.getId());
		// anniversaryLeaveList =
		// leaveHandlerService.getAnniversaryLeave(employee.getId());
		// paternityLeaveList =
		// leaveHandlerService.getPaternityLeave(employee.getId());

		leaveBalance = leaveHandlerService.getLeaveBalance(employee.getId());
		// encashmentLeaveWaiting =
		// leaveHandlerService.getWaitingEncashmentLeave(employee);

		map = leaveHandlerService.getUserDetails(mapForDs);

		map.put("listOfLeaveApprovingAuthorities",
				listOfLeaveApprovingAuthorities);
		map.put("listOfTypesOfLeaves", listOfTypesOfLeaves);
		map.put("manager", manager);
		map.put("bday", new Date());
		map.put("anniversary", new Date());
		map.put("listOfManagers", listOfManagers);
		map.put("listOfRestrictedHolidays", listOfRestrictedHolidays);
		map.put("listOfHolidays", listOfHolidays);
		map.put("listOfRhAvailed", listOfRhAvailed);
		map.put("birthdayLeaveList", birthdayLeaveList);
		map.put("anniversaryLeaveList", anniversaryLeaveList);
		map.put("paternityLeaveList", paternityLeaveList);
		map.put("leaveBalance", leaveBalance);
		map.put("encashmentLeaveWaiting", encashmentLeaveWaiting);
		map.put("userList", userList);

		// map.put(MAIN,APPLY_LEAVES_JSP);
		String jsp = APPLY_SHORT_LEAVES_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		// map.put(TITLE,"Apply Leave" );
		return new ModelAndView("index", "map", map);
	}

	/*public ModelAndView getNoOfWorkingDays(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Date fromDate = HMSUtil.dateFormatterDDMMYYYY(request
				.getParameter("fromDate"));
		Date toDate = HMSUtil.dateFormatterDDMMYYYY(request
				.getParameter("toDate"));
		List listOfHolidays = null;
		listOfHolidays = leaveHandlerService.getHolidays();
		session = request.getSession(true);
		Users user = (Users) session.getAttribute(USERS);
		HrEmployeePersonelDetails psDetail = leaveHandlerService
				.getEmpPersonalDeatil(user.getId());
		System.out.println("psDetail>>."+psDetail);
		System.out.println("psDetail>>."+psDetail.getId());
		// changes
		Date dobFromDB = psDetail.getDateOfBirth();
		// Date dobFromDB=new Date();
		System.out.println("dobFromDB>>."+dobFromDB);
		// changes
		Date anniversary = psDetail.getMarriageDate();
		// Date anniversary =new Date();

		Map<String, String> dayswithoutDobMap = LeaveManagementUtil
				.getNumberOfDaysWithoutDateOfBirthOrHolidays(fromDate, toDate,
						dobFromDB, listOfHolidays, anniversary);
		String noOfWorkingDays = dayswithoutDobMap.get("days");
		String holidayFlag = dayswithoutDobMap.get("holidayFlag");
		String typeFlag = dayswithoutDobMap.get("typeFlag");
		StringBuffer responseString = new StringBuffer();
		if (noOfWorkingDays != null) {
			responseString.append(noOfWorkingDays);
		}
		if (holidayFlag != null) {
			responseString.append("$" + holidayFlag + "$");
		}
		if (typeFlag != null) {
			responseString.append(typeFlag);
		}

		try {
			response.getWriter().write(responseString.toString());

		} catch (Exception e) {
		}
		return null;
	}
*/
	
	
	
	/*public ModelAndView getNoOfWorkingDays(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> generalMap = new HashMap<String, Object>();
		//System.out.println("in get no of working days");
		
		HttpSession session = request.getSession(false);
		if ( session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Date fromDate=HMSUtil.dateFormatterDDMMYYYY(request.getParameter("fromDate"));
		Date toDate=HMSUtil.dateFormatterDDMMYYYY(request.getParameter("toDate"));
		List listOfHolidays=null;
		listOfHolidays=leaveHandlerService.getHolidays();
		session=request.getSession(true);
		Users user=(Users)session.getAttribute(USERS);
	
		generalMap= leaveHandlerService.getEmpPersonalDeatil(user.getId());
		//changes
		 Date dobFromDB = null;
		if(generalMap.get("dob")!= null){
			 dobFromDB =(Date)generalMap.get("dob");
		}
		//Date dobFromDB=psDetail.getDateOfBirth();
		//Date dobFromDB=new Date();
		//System.out.println("dobFromDB==== "+dobFromDB);
		//changes
		//Date anniversary = psDetail.getMarriageDate();
		Date anniversary =null;
		if(generalMap.get("anniversery")!= null){
			anniversary =(Date)generalMap.get("anniversery");
		}
		Map<String,String> dayswithoutDobMap=LeaveManagementUtil.getNumberOfDaysWithoutDateOfBirthOrHolidays(fromDate,toDate,dobFromDB,listOfHolidays,anniversary);
		
     
       
		String noOfWorkingDays = dayswithoutDobMap.get("days");
		String  holidayFlag = dayswithoutDobMap.get("holidayFlag");
		String typeFlag=dayswithoutDobMap.get("typeFlag");
		
		
        StringBuffer responseString = new StringBuffer();
        if(noOfWorkingDays != null){
        	responseString.append(noOfWorkingDays);
        }
        if(holidayFlag != null){
        	responseString.append("$"+holidayFlag+"$");
        }
        if(typeFlag != null){
        	responseString.append(typeFlag);
        }
        //System.out.println("responseString====="+responseString);
		try{
			response.getWriter().write(responseString.toString());

		}
		catch(Exception e){}
		return null;
	}*/
	
	
	public ModelAndView getNoOfWorkingDays(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> generalMap = new HashMap<String, Object>();
		//System.out.println("in get no of working days");
		
		HttpSession session = request.getSession(false);
		if ( session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Date fromDate=HMSUtil.dateFormatterDDMMYYYY(request.getParameter("fromDate"));
		Date toDate=HMSUtil.dateFormatterDDMMYYYY(request.getParameter("toDate"));
		List listOfHolidays=null;
		listOfHolidays=leaveHandlerService.getHolidays();
		session=request.getSession(true);
		Users user=(Users)session.getAttribute(USERS);
		generalMap= leaveHandlerService.getEmpPersonalDeatil(user.getId());
		//changes
		 Date dobFromDB = null;
		if(generalMap.get("dob")!= null){
			 dobFromDB =(Date)generalMap.get("dob");
		}
		//Date dobFromDB=psDetail.getDateOfBirth();
		//Date dobFromDB=new Date();
		//System.out.println("dobFromDB==== "+dobFromDB);
		//changes
		//Date anniversary = psDetail.getMarriageDate();
		Date anniversary =null;
		if(generalMap.get("anniversery")!= null){
			anniversary =(Date)generalMap.get("anniversery");
		}
		Map<String,String> dayswithoutDobMap=LeaveManagementUtil.getNumberOfDaysWithoutDateOfBirthOrHolidays(fromDate,toDate,dobFromDB,listOfHolidays,anniversary);
		String noOfWorkingDays = dayswithoutDobMap.get("days");
		String  holidayFlag = dayswithoutDobMap.get("holidayFlag");
		String typeFlag=dayswithoutDobMap.get("typeFlag");
		
		
        StringBuffer responseString = new StringBuffer();
        if(noOfWorkingDays != null){
        	responseString.append(noOfWorkingDays);
        }
        if(holidayFlag != null){
        	responseString.append("$"+holidayFlag+"$");
        }
        if(typeFlag != null){
        	responseString.append(typeFlag);
        }
        //System.out.println("responseString====="+responseString);
		try{
			response.getWriter().write(responseString.toString());

		}
		catch(Exception e){}
		return null;
	}
	
	public ModelAndView submitLeaveForm(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = null;

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		if (session.getAttribute("save") != null) {
			flag = true;
		}
		if (flag) {
			Users emp = (Users) session.getAttribute(USERS);
			MasEmployee user = emp.getEmployee();
			HrLeaveDetails leave = new HrLeaveDetails();
			Date currentDate = new Date();
			Date jspFromDate = new Date();
			Date jspToDate = new Date();
			Date prevAppFromDate = new Date();
			Date prevAppToDate = new Date();
			Boolean againSameLeaveRecord = false;
			List<HrLeaveDetails> optionalleaveList = new ArrayList<HrLeaveDetails>();
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				jspFromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				jspToDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				leave.setFromDate(jspFromDate);
				leave.setToDate(jspToDate);
			} else if (request.getParameter(FROM_DATE) != null
					&& (request.getParameter(TO_DATE).equals(""))) {
				jspFromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				jspToDate = jspFromDate;
				leave.setFromDate(jspFromDate);
				leave.setToDate(jspToDate);
			}
			/*
			 * int leaveId=0;
			 * if(request.getParameter("leaveIdForDatabase")!=null
			 * &&!request.getParameter("leaveIdForDatabase").equals("")){
			 * leaveId =
			 * Integer.parseInt(request.getParameter("leaveIdForDatabase")); }
			 */

			List<HrLeaveDetails> leaveList = leaveHandlerService
					.getLeavesList(user.getId());
			if (request.getParameter(FROM_DATE) != null
					&& !"".equals(request.getParameter(FROM_DATE))) {
				for (HrLeaveDetails leaveRecord : leaveList) {
					if (leaveRecord.getFromDate() != null) {
						if ((leaveRecord.getLeaveStatus().getId() == 3 || leaveRecord
								.getLeaveStatus().getId() == 2)) {
							if (jspFromDate
									.compareTo(leaveRecord.getFromDate()) > 0
									&& jspFromDate.compareTo(leaveRecord
											.getToDate()) <= 0) {
								prevAppFromDate = leaveRecord.getFromDate();
								prevAppToDate = leaveRecord.getToDate();

								againSameLeaveRecord = true;
								// date checking for already exists or
								// not>>>>>>"+leaveRecord.getFromDate());
							} else if (jspFromDate.compareTo(leaveRecord
									.getFromDate()) <= 0) {
								if (jspToDate.compareTo(leaveRecord
										.getFromDate()) >= 0) {
									prevAppFromDate = leaveRecord.getFromDate();
									prevAppToDate = leaveRecord.getToDate();
									againSameLeaveRecord = true;
									// checking for already exists or
									// not>>>>>>"+leaveRecord.getFromDate());
								}
							} else if (jspFromDate.compareTo(leaveRecord
									.getFromDate()) == 0
									&& jspToDate.compareTo(leaveRecord
											.getToDate()) == 0) {
								prevAppFromDate = leaveRecord.getFromDate();
								prevAppToDate = leaveRecord.getToDate();
								againSameLeaveRecord = true;
							} else if (jspFromDate.compareTo(leaveRecord
									.getFromDate()) < 0
									&& jspToDate.compareTo(leaveRecord
											.getFromDate()) >= 0
									&& jspToDate.compareTo(leaveRecord
											.getToDate()) <= 0) {
								prevAppFromDate = leaveRecord.getFromDate();
								prevAppToDate = leaveRecord.getToDate();
								againSameLeaveRecord = true;
							} else if (jspFromDate.compareTo(leaveRecord
									.getFromDate()) >= 0
									&& jspToDate.compareTo(leaveRecord
											.getToDate()) >= 0
									&& jspFromDate.compareTo(leaveRecord
											.getToDate()) <= 0) {
								prevAppFromDate = leaveRecord.getFromDate();
								prevAppToDate = leaveRecord.getToDate();
								againSameLeaveRecord = true;
							}
						}
					}
				}
			}
			// Date
			// displayDate=DateFormat.getDateInstance(DateFormat.SHORT).format(currentDate);
			if (!againSameLeaveRecord) {
		
				leave.setAppliedOn(currentDate);
				// changes
				// leave.setEmpid(user.getId());
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(user.getId());
				leave.setEmpId(masEmployee);

				leave.setNoOfWorkingDays(request
						.getParameter(NO_OF_WORKING_DAYS));

				// changes
				String managerType = "";
				if (request.getParameter(MANAGER_TYPE) != null) {
					managerType = request.getParameter(MANAGER_TYPE);
				}
				int approvedById = 0;
				/*if (managerType.equalsIgnoreCase("m")) {
					approvedById = Integer.parseInt(request
							.getParameter(APPROVED_BY));
				} else if (managerType.equalsIgnoreCase("o")) {
					approvedById = Integer.parseInt(request
							.getParameter(APPROVED_BY_OTHER));
				}*/
		
				approvedById = Integer.parseInt(request.getParameter(APPROVED_BY));
						
				MasEmployee approvedBy = new MasEmployee();
				approvedBy.setId(approvedById);
				leave.setLeaveApprovedBy(approvedBy);

				// code added by shailesh
				if (request.getParameter("hrMasLeaveTypeNewId") != null
						&& !request.getParameter("hrMasLeaveTypeNewId").equals(
								"")) {
					int hrMasLeaveTypeNewId = Integer.parseInt(request
							.getParameter("hrMasLeaveTypeNewId"));
					HrMasLeaveTypeNew hrMasLeaveTypeNew = new HrMasLeaveTypeNew(
							hrMasLeaveTypeNewId);
					leave.setHrMasLeaveTypeNew(hrMasLeaveTypeNew);
				}
				/*if (request.getParameter("leaveIdForDatabase") != null && !request.getParameter("leaveIdForDatabase").equals("")) {
					HrMasLeaveTypeMediator leaveType = new HrMasLeaveTypeMediator();
					leaveType.setId(Integer.parseInt(request
							.getParameter("leaveIdForDatabase")));
					leave.setLeaveType(leaveType);
				}*/
				
				if (request.getParameter(TYPE) != null && !request.getParameter(TYPE).equals("")) {
					HrMasLeaveTypeMediator leaveType = new HrMasLeaveTypeMediator();
					leaveType.setId(Integer.parseInt(request
							.getParameter(TYPE)));
					leave.setLeaveType(leaveType);
				}
				if (request.getParameter(CONTACT_ADDRESS) != null
						&& !request.getParameter(CONTACT_ADDRESS).equals("")) {
					leave.setContactAddress(request
							.getParameter(CONTACT_ADDRESS));
				}
				if (request.getParameter("typeFlagForJoiningDate") != null
						&& request.getParameter("typeFlagForJoiningDate")
								.equalsIgnoreCase("shortLeave")) {
					leave.setJoiningDate(jspFromDate);
					leave.setShortLeaveHalfDay(request
							.getParameter(SHORT_LEAVE_HALF_DAY));
				} else {
					leave.setJoiningDate(HMSUtil.dateFormatterDDMMYYYY(request
							.getParameter(JOINING_DATE)));
				}

				leave.setReason(request.getParameter(REASON));
				leave.setContactPhone(request.getParameter(CONTACT_PHONE));
				leave.setModifiedBy(user.getId());
				leave.setModifiedOn(currentDate);

				HrMasLeaveStatus leaveStatus = new HrMasLeaveStatus();
				leaveStatus.setId(3);
				leave.setLeaveStatus(leaveStatus);

				/*HrEmployeeBalanceNew hrUserLeavebalance = new HrEmployeeBalanceNew();
				hrUserLeavebalance.setId(Integer.parseInt(request
						.getParameter("balanceIdForDatabase")));
				leave.setEmpIdBal(hrUserLeavebalance);*/


				if(request.getParameter("balanceIdForDatabase")!=null  && !request.getParameter("balanceIdForDatabase").equals("")){
					HrEmployeeBalanceNew hrUserLeavebalance =new HrEmployeeBalanceNew();
					hrUserLeavebalance.setId(Integer.parseInt(request.getParameter("balanceIdForDatabase")));
					leave.setEmpIdBal(hrUserLeavebalance);
				}

				if (request.getParameter(HALF_DAY) != null) {
					leave.setHalfDay(request.getParameter(HALF_DAY));
				}
				if (request.getParameter(EMAIL) != null) {
					leave.setAlternateEmailId(request.getParameter(EMAIL));
				}
				optionalleaveList.add(leave);
				/*
				 * if((request.getParameter("typeFlag")!=null) &&
				 * !(request.getParameter("typeFlag").equals(""))){
				 * HrLeaveDetails optionalLeave=new HrLeaveDetails();
				 * optionalLeave.setFromDate(jspFromDate);
				 * optionalLeave.setToDate(jspToDate);
				 * optionalLeave.setAppliedOn(currentDate);
				 *
				 * //MasEmployee masEmployee1 =new MasEmployee();
				 * //masEmployee1.setId(user.getId());
				 * optionalLeave.setEmpId(masEmployee);
				 *
				 * //optionalLeave.setEmpid(user.getId());
				 *
				 * optionalLeave.setNoOfWorkingDays(request.getParameter(
				 * NO_OF_WORKING_DAYS));
				 *
				 * //changes optionalLeave.setLeaveApprovedBy(approvedBy);
				 *
				 * if(request.getParameter("typeFlag").equals("dob")) {
				 * HrMasLeaveTypeMediator leaveTypeDOB =new
				 * HrMasLeaveTypeMediator();
				 * leaveTypeDOB.setId(Integer.parseInt(
				 * request.getParameter("leaveId")));
				 * optionalLeave.setLeaveType(leaveTypeDOB);
				 *
				 * //optionalLeave.setType(5); } else
				 * if(request.getParameter("typeFlag").equals("anvsy")) {
				 *
				 * HrMasLeaveTypeMediator leaveTypeAnvsy =new
				 * HrMasLeaveTypeMediator();
				 * leaveTypeAnvsy.setId(Integer.parseInt
				 * (request.getParameter("leaveId"))); //changes //HrMasLeave
				 * leaveTypeAnvsy =new HrMasLeave(); //leaveTypeAnvsy.setId(6);
				 * optionalLeave.setLeaveType(leaveTypeAnvsy);
				 *
				 * //optionalLeave.setType(6); }
				 * optionalLeave.setJoiningDate(HMSUtil
				 * .dateFormatterDDMMYYYY(request.getParameter(JOINING_DATE)));
				 * optionalLeave.setReason(request.getParameter(REASON));
				 * if(request.getParameter(CONTACT_ADDRESS)!=null) {
				 * optionalLeave
				 * .setContactAddress(request.getParameter(CONTACT_ADDRESS)); }
				 * optionalLeave
				 * .setContactPhone(request.getParameter(CONTACT_PHONE));
				 * optionalLeave.setModifiedBy(user.getId());
				 * optionalLeave.setModifiedOn(currentDate);
				 *
				 * //changes optionalLeave.setLeaveStatus(leaveStatus);
				 *
				 * optionalLeave.setEmpIdBal(hrUserLeavebalance);
				 *
				 * if(request.getParameter(HALF_DAY)!=null) {
				 * optionalLeave.setHalfDay(request.getParameter(HALF_DAY)); }
				 * if(request.getParameter(EMAIL)!=null) {
				 * optionalLeave.setAlternateEmailId
				 * (request.getParameter(EMAIL)); }
				 * optionalleaveList.add(optionalLeave); }
				 */

				// leaveHandlerService.submitLeaveForm(leave,user.getId(),user.getEmailId());
				leaveHandlerService.submitLeaveForm(optionalleaveList,
						user.getId(), user.getEmail());

				String message[] = {
						"You have successfully applied for the leave.",
						"javascript:history.back()"
				// "/jktintranet/jkt/login?method=showPage&jspPage=home"
				};
				map.put("message", message);
			} else {
				String message[] = {
						"You have already applied for leave from "
								+ LeaveManagementUtil
										.convertDateToStringWithoutTime(prevAppFromDate)
								+ " to "
								+ LeaveManagementUtil
										.convertDateToStringWithoutTime(prevAppToDate)
								+ " Please apply again !",
						"javascript:history.back()"
				// "/jktintranet/jkt/login?method=showPage&jspPage=home"
				};
				map.put("message", message);
			}

			// changes
			// map.put(MAIN, "message.jsp");
			// map.put(TITLE,"Leave Application");
			String jsp = HR_MESSAGE_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);

			mav = new ModelAndView("index", "map", map);
			session.setAttribute("save", null);
			return mav;
		} else {

			String message[] = {
					"You have already applied for the leave. Go to Apply Leave option to apply again",
					"leave?method=showLeaveApplicationJsp"
			// chnages
			// "/jktintranet/jkt/login?method=showPage&jspPage=home"
			};

			// changes
			map.put("message", message);
			// map.put(MAIN, "message.jsp");
			// map.put(TITLE,"Leave Application");

			String jsp = HR_MESSAGE_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);

			mav = new ModelAndView("index", "map", map);
			return mav;
		}
	}
	
	
	public ModelAndView submitLeaveForm1(HttpServletRequest request,HttpServletResponse response) throws ParseException
	{
		ModelAndView mav=null;
		String employeeName="";
		Date empDob=null;
		Date empDoj=null;
		int empId=0;
		Date jspFromDate = null;
		Date jspToDate = null;
		 String sfromDate = "";
		  String stodate = "";
		  String postheld="";
		  String department="";
		  
		  long suffixDaysNo=0;
		  

			 String pfromDate = "";
			  String ptodate = "";
			  long prefixDaysNo=0;
			  String LeaveTypeName="";
			  
		boolean messagestatus=false;

		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

		Map<String,Object> map=new HashMap<String,Object>();
		boolean flag = false;
		if(session.getAttribute("save") != null){
			flag = true;
		}
		if(flag){
			Users emp =(Users)session.getAttribute(USERS);
			MasEmployee user=emp.getEmployee();
			employeeName=user.getEmployeeName();
			empId=user.getId();
			System.out.println("empId "+empId);
			
			if(null !=user.getDateOfBirth()){
				empDob=user.getDateOfBirth() ;
			}
			if(null !=user.getJoinDate()){
				empDoj=user.getJoinDate() ;
			}
			HrLeaveDetails leave=new HrLeaveDetails();
			Date currentDate = new Date();
			 jspFromDate = new Date();
			 jspToDate = new Date();
			Date prevAppFromDate = new Date();
			Date prevAppToDate = new Date();
			Boolean againSameLeaveRecord=false;
			List<HrLeaveDetails> optionalleaveList=new ArrayList<HrLeaveDetails>();
			if(request.getParameter("LeaveTypeName")!=null && !(request.getParameter("LeaveTypeName").equals(""))){
				LeaveTypeName=request.getParameter("LeaveTypeName");
				System.out.println("LeaveTypeName +"+LeaveTypeName);
			}
			if(request.getParameter(FROM_DATE)!=null && !(request.getParameter(TO_DATE).equals(""))){
				jspFromDate=HMSUtil.dateFormatterDDMMYYYY(request.getParameter(FROM_DATE));
				jspToDate=HMSUtil.dateFormatterDDMMYYYY(request.getParameter(TO_DATE));
				leave.setFromDate(jspFromDate);
				leave.setToDate(jspToDate);
			} else if(request.getParameter(FROM_DATE)!=null && (request.getParameter(TO_DATE).equals(""))) {
				jspFromDate=HMSUtil.dateFormatterDDMMYYYY(request.getParameter(FROM_DATE));
				jspToDate=jspFromDate;
				leave.setFromDate(jspFromDate);
				leave.setToDate(jspToDate);
			}
/*			int leaveId=0;
			if(request.getParameter("leaveIdForDatabase")!=null&&!request.getParameter("leaveIdForDatabase").equals("")){
				leaveId = Integer.parseInt(request.getParameter("leaveIdForDatabase"));
			}*/

		List<HrLeaveDetails> leaveList=leaveHandlerService.getLeavesList(user.getId());
		if(request.getParameter(FROM_DATE)!=null && !"".equals(request.getParameter(FROM_DATE))){
			for (HrLeaveDetails leaveRecord : leaveList) {
				if(leaveRecord.getFromDate()!=null)
					if((leaveRecord.getLeaveStatus().getId()==3 || leaveRecord.getLeaveStatus().getId()==2)){
							if(jspFromDate.compareTo(leaveRecord.getFromDate())> 0 && jspFromDate.compareTo(leaveRecord.getToDate())<= 0)
							{	
								prevAppFromDate = leaveRecord.getFromDate();
								prevAppToDate = leaveRecord.getToDate();
								
								againSameLeaveRecord=true;
							//	System.out.println("\n\n\nleave First If from date checking for already exists or not>>>>>>"+leaveRecord.getFromDate());
							}else if(jspFromDate.compareTo(leaveRecord.getFromDate())<= 0) {
								if(jspToDate.compareTo(leaveRecord.getFromDate())>= 0 ){
									prevAppFromDate = leaveRecord.getFromDate();
									prevAppToDate = leaveRecord.getToDate();
									againSameLeaveRecord=true;
								//	System.out.println("\n\n\nleave from date checking for already exists or not>>>>>>"+leaveRecord.getFromDate());
								}
							}else if(jspFromDate.compareTo(leaveRecord.getFromDate())== 0 && jspToDate.compareTo(leaveRecord.getToDate())==0){
									prevAppFromDate = leaveRecord.getFromDate();
									prevAppToDate = leaveRecord.getToDate();
									againSameLeaveRecord=true;
							}else if(jspFromDate.compareTo(leaveRecord.getFromDate())< 0 && jspToDate.compareTo(leaveRecord.getFromDate()) >= 0 && jspToDate.compareTo(leaveRecord.getToDate())<=0){
								prevAppFromDate = leaveRecord.getFromDate();
								prevAppToDate = leaveRecord.getToDate();
								againSameLeaveRecord=true;
							}else if(jspFromDate.compareTo(leaveRecord.getFromDate()) >= 0 && jspToDate.compareTo(leaveRecord.getToDate()) >= 0 && jspFromDate.compareTo(leaveRecord.getToDate())<=0){
								prevAppFromDate = leaveRecord.getFromDate();
								prevAppToDate = leaveRecord.getToDate();
								againSameLeaveRecord=true;
							}
						}
				}
			}
			//Date displayDate=DateFormat.getDateInstance(DateFormat.SHORT).format(currentDate);
		
			if(!againSameLeaveRecord){
				
				leave.setAppliedOn(currentDate);
				//changes
				//leave.setEmpid(user.getId());
				MasEmployee masEmployee =new MasEmployee();
				masEmployee.setId(user.getId());
				leave.setEmpId(masEmployee);

				leave.setNoOfWorkingDays(request.getParameter(NO_OF_WORKING_DAYS));
				
				//changes
				String managerType = "";
				if(request.getParameter(MANAGER_TYPE)!=null) {
					 managerType = request.getParameter(MANAGER_TYPE);
				}
				int approvedById = 0;
				/*if(managerType.equalsIgnoreCase("m")){
					approvedById = Integer.parseInt(request.getParameter(APPROVED_BY));
				}else if(managerType.equalsIgnoreCase("o")){
					approvedById = Integer.parseInt(request.getParameter(APPROVED_BY_OTHER));
				}*/
				if(request.getParameter(APPROVED_BY)!=null)
				{
				approvedById = Integer.parseInt(request.getParameter(APPROVED_BY));
				
				}
				MasEmployee approvedBy =new MasEmployee();
				approvedBy.setId(approvedById);
				leave.setLeaveApprovedBy(approvedBy);

				//code added by shailesh
				/*if(request.getParameter("hrMasLeaveTypeNewId") != null && (!request.getParameter("hrMasLeaveTypeNewId").equals(""))){
					int hrMasLeaveTypeNewId=Integer.parseInt(request.getParameter("hrMasLeaveTypeNewId"));
					HrMasLeaveTypeNew hrMasLeaveTypeNew=new HrMasLeaveTypeNew(hrMasLeaveTypeNewId);
					leave.setHrMasLeaveTypeNew(hrMasLeaveTypeNew);
				}
				
				
				if(request.getParameter("leaveIdForDatabase")!=null  && !request.getParameter("leaveIdForDatabase").equals("")){
					HrMasLeaveTypeMediator leaveType =new HrMasLeaveTypeMediator();
					leaveType.setId(Integer.parseInt(request.getParameter("leaveIdForDatabase")));
					leave.setLeaveType(leaveType);
				}*/
				
				if (request.getParameter(TYPE) != null && !request.getParameter(TYPE).equals("")) {
					HrMasLeaveTypeMediator leaveType = new HrMasLeaveTypeMediator();
					leaveType.setId(Integer.parseInt(request
							.getParameter(TYPE)));
					leave.setLeaveType(leaveType);
				}
				
				
				if(request.getParameter(CONTACT_ADDRESS)!=null && !request.getParameter(CONTACT_ADDRESS).equals("")){
					leave.setContactAddress(request.getParameter(CONTACT_ADDRESS));
				}
				if(request.getParameter("typeFlagForJoiningDate")!=null 
						&& request.getParameter("typeFlagForJoiningDate").equalsIgnoreCase("shortLeave")){
					leave.setJoiningDate(jspFromDate);
					leave.setShortLeaveHalfDay(request.getParameter(SHORT_LEAVE_HALF_DAY));
				} else {
					leave.setJoiningDate(HMSUtil.dateFormatterDDMMYYYY(request.getParameter(JOINING_DATE)));
				}
				
				leave.setReason(request.getParameter(REASON));
				leave.setContactPhone(request.getParameter(CONTACT_PHONE));
				leave.setModifiedBy(user.getId()); 
				leave.setModifiedOn(currentDate);
				
				HrMasLeaveStatus leaveStatus =new HrMasLeaveStatus();
				leaveStatus.setId(3);
				leave.setLeaveStatus(leaveStatus);
	
				if(request.getParameter("balanceIdForDatabase")!=null  && !request.getParameter("balanceIdForDatabase").equals("")){
					HrEmployeeBalanceNew hrUserLeavebalance =new HrEmployeeBalanceNew();
					hrUserLeavebalance.setId(Integer.parseInt(request.getParameter("balanceIdForDatabase")));
					leave.setEmpIdBal(hrUserLeavebalance);
				}
				if(request.getParameter("checkbox")!=null 
						&& request.getParameter("checkbox").equals("half day")
						&& request.getParameter(HALF_DAY)!=null){
						leave.setHalfDay(request.getParameter(HALF_DAY));
				}
				if(request.getParameter(EMAIL)!=null){
					leave.setAlternateEmailId(request.getParameter(EMAIL));
				}
				optionalleaveList.add(leave);
				
				
				 
				if(request.getParameter("sFdate")!=null && !request.getParameter("sFdate").equals("")){
					sfromDate=request.getParameter("sFdate");
					leave.setSuffixFromDate(HMSUtil.convertStringTypeDateToDateType(sfromDate) );
					
				}
				if(request.getParameter("sTdate")!=null && !request.getParameter("sTdate").equals("")){
					stodate=request.getParameter("sTdate");
					leave.setSuffixToDate(HMSUtil.convertStringTypeDateToDateType(stodate) );
					
				}
				

				if(!sfromDate.equals("")&& !stodate.equals("")){
					suffixDaysNo=calculateNoOfDays(sfromDate,stodate);
					
				}
				else{
					String toDate="";
					if(null !=request.getParameter(TO_DATE) && !(request.getParameter(TO_DATE).equals("")) && stodate.equals("")){
						toDate=request.getParameter(TO_DATE);
						
						suffixDaysNo=calculateNoOfDays(toDate,sfromDate);
						

					}
				}
				
				if(request.getParameter("prefixFDate")!=null && !request.getParameter("prefixFDate").equals("")){
					pfromDate=request.getParameter("prefixFDate");
					leave.setPrefixFromDate(HMSUtil.convertStringTypeDateToDateType(pfromDate) );

				}
				if(request.getParameter("prefixTDate")!=null && !request.getParameter("prefixTDate").equals("")){
					ptodate=request.getParameter("prefixTDate");
					leave.setPrefixToDate(HMSUtil.convertStringTypeDateToDateType(ptodate) );

				}
				if(!pfromDate.equals("")&& !ptodate.equals("")){
					prefixDaysNo=calculateNoOfDays(pfromDate,ptodate);
					
					

				}
				else{
					String fromDate="";
					if(null !=request.getParameter(FROM_DATE) && !(request.getParameter(FROM_DATE).equals("")) && ptodate.equals("")){
						fromDate=request.getParameter(FROM_DATE);
						
						prefixDaysNo=calculateNoOfDays(pfromDate,fromDate);
						
						System.out.println("SSS prefixDaysNo "+prefixDaysNo);

					}
				}
			if(hospitalId>0){
				MasHospital hosp=new MasHospital();
				hosp.setId(hospitalId);
				leave.setCompany(hosp);
			}
				
				
				
				/*if((request.getParameter("typeFlag")!=null) && !(request.getParameter("typeFlag").equals(""))){
					HrLeaveDetails optionalLeave=new HrLeaveDetails();
					optionalLeave.setFromDate(jspFromDate);
					optionalLeave.setToDate(jspToDate);
					optionalLeave.setAppliedOn(currentDate);
					
					//MasEmployee masEmployee1 =new MasEmployee();
					//masEmployee1.setId(user.getId());
					optionalLeave.setEmpId(masEmployee);

					//optionalLeave.setEmpid(user.getId());
					
					optionalLeave.setNoOfWorkingDays(request.getParameter(NO_OF_WORKING_DAYS));
					
					//changes
					optionalLeave.setLeaveApprovedBy(approvedBy);
					
					if(request.getParameter("typeFlag").equals("dob"))
					{
						HrMasLeaveTypeMediator leaveTypeDOB =new HrMasLeaveTypeMediator();
							leaveTypeDOB.setId(Integer.parseInt(request.getParameter("leaveId")));
						optionalLeave.setLeaveType(leaveTypeDOB);

						//optionalLeave.setType(5);
					}
					else if(request.getParameter("typeFlag").equals("anvsy")) 
					{
						
						HrMasLeaveTypeMediator leaveTypeAnvsy =new HrMasLeaveTypeMediator();
						leaveTypeAnvsy.setId(Integer.parseInt(request.getParameter("leaveId")));				
						//changes
						//HrMasLeave leaveTypeAnvsy =new HrMasLeave();
						//leaveTypeAnvsy.setId(6);
						optionalLeave.setLeaveType(leaveTypeAnvsy);

						//optionalLeave.setType(6);	
					}
					optionalLeave.setJoiningDate(HMSUtil.dateFormatterDDMMYYYY(request.getParameter(JOINING_DATE)));
					optionalLeave.setReason(request.getParameter(REASON));
					if(request.getParameter(CONTACT_ADDRESS)!=null)
					{
						optionalLeave.setContactAddress(request.getParameter(CONTACT_ADDRESS));
					}
					optionalLeave.setContactPhone(request.getParameter(CONTACT_PHONE));
					optionalLeave.setModifiedBy(user.getId()); 
					optionalLeave.setModifiedOn(currentDate);
					
					//changes
					optionalLeave.setLeaveStatus(leaveStatus);
					
					optionalLeave.setEmpIdBal(hrUserLeavebalance);
		
					if(request.getParameter(HALF_DAY)!=null)
					{
						optionalLeave.setHalfDay(request.getParameter(HALF_DAY));
					}
					if(request.getParameter(EMAIL)!=null)
					{
						optionalLeave.setAlternateEmailId(request.getParameter(EMAIL));
					}
					optionalleaveList.add(optionalLeave);
				} */

				//leaveHandlerService.submitLeaveForm(leave,user.getId(),user.getEmailId());
				leaveHandlerService.submitLeaveForm(optionalleaveList,user.getId(),user.getEmail());
				Map<String,Object> empmap=new HashMap<String,Object>();
				empmap=leaveHandlerService.getUserDetails(user.getId());
				
				if(null !=empmap.get("postheld")){
					postheld=(String)empmap.get("postheld");
				}
				if(null !=empmap.get("department")){
					department=(String)empmap.get("department");
				}
				
				String message[]={"You have successfully applied for the leave. Do you want to print ?",
						"javascript:history.back()"
						//"/jktintranet/jkt/login?method=showPage&jspPage=home"
				};
				map.put("message",message);
			} else {
				//System.out.println("again same record ");
				messagestatus=true;
				String	message[]={"You have already applied for leave from "+LeaveManagementUtil.convertDateToStringWithoutTime(prevAppFromDate)+" to "+LeaveManagementUtil.convertDateToStringWithoutTime(prevAppToDate)+" Please apply again !",
						"javascript:history.back()"
						//"/jktintranet/jkt/login?method=showPage&jspPage=home"
				};
				map.put("message",message);
				map.put("messagestatus",messagestatus);
			}
			
			System.out.println(request.getParameter(CONTACT_ADDRESS));
			map.put("AddressOnLeave", request.getParameter(CONTACT_ADDRESS));
			map.put("reason", request.getParameter(REASON));
			//parameters.put("currentDate", currentDate);
			map.put("dateOfBirth",empDob );
			map.put("dateOfJoin", empDoj);
			map.put("employeeName", employeeName);
			map.put("suffixDaysNo", suffixDaysNo);
			map.put("prefixDaysNo", prefixDaysNo);
			map.put("empId", empId);
			map.put("department", department);
			map.put("postheld", postheld);
			map.put("jspFromDate", jspFromDate);
			map.put("jspToDate", jspToDate);
			map.put("LeaveTypeName", LeaveTypeName);
			
			
			//changes
			//map.put(MAIN, "message.jsp");
			//map.put(TITLE,"Leave Application");
			String jsp = HR_MESSAGE_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			/*printLeaveForm(request,response);*/
			mav=new ModelAndView("index","map",map);
			session.setAttribute("save", null);
			return mav;
		}else{

			String message[]={"You have already applied for the leave. Go to Apply Leave option to apply again",
					"leave?method=showLeaveApplicationJsp"
					//chnages
					//"/jktintranet/jkt/login?method=showPage&jspPage=home"
			};
			
			//changes
			map.put("message",message);
		//	map.put(MAIN, "message.jsp");
		//	map.put(TITLE,"Leave Application");
			
			String jsp = HR_MESSAGE_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("contentJsp", jsp);
			
			mav=new ModelAndView("index","map",map);
			
			/*printLeaveForm(request,response);*/
			return mav;
		}
		
	}

	public ModelAndView printLeaveForm(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		String AddressOnLeave="";
	    String reason="";
	    String dateOfBirth="";
	    String dateOfJoin="";
	    int empId=0;
	    String employeeName="";
	    String doj="";
	    String dob="";
	    
	    String postheld="";
		  String department="";
		  
		  String jspFromDate="";
		    String jspToDate="";
		    String LeaveTypeName="";
		    String recommandFlag = "";
	    
	    if(null !=request.getParameter("dateOfBirth") && !request.getParameter("dateOfBirth").equals("") && !request.getParameter("dateOfBirth").equals("null")){
	    	
	    dateOfBirth=request.getParameter("dateOfBirth");
    	String d[]=dateOfBirth.split("-");
    	dob=d[2]+"-"+d[1]+"-"+d[0];
	   
	   
	    }
	    if(null !=request.getParameter("dateOfJoin") && !request.getParameter("dateOfJoin").equals("")&& !request.getParameter("dateOfJoin").equals("null")){
	    	dateOfJoin=request.getParameter("dateOfJoin");
	    	String d[]=dateOfJoin.split("-");
	    	doj=d[2]+"-"+d[1]+"-"+d[0];
		    }
	    
	    if(null !=request.getParameter("empId") && !request.getParameter("empId").equals("")){
	    	empId=Integer.parseInt(request.getParameter("empId"));
		    }
	    
	    if(null !=request.getParameter("postheld") && !request.getParameter("postheld").equals("")){
	    	postheld=request.getParameter("postheld");
		    }
	    
	    if(null !=request.getParameter("department") && !request.getParameter("department").equals("")){
	    	department=request.getParameter("department");
		    }
	    
	    
	    if(null !=request.getParameter("jspFromDate") && !request.getParameter("jspFromDate").equals("")){
	    	jspFromDate=request.getParameter("jspFromDate");
		    }
	    
	    if(null !=request.getParameter("jspToDate") && !request.getParameter("jspToDate").equals("")){
	    	jspToDate=request.getParameter("jspToDate");
		    }
	    
	    if(null !=request.getParameter("LeaveTypeName") && !request.getParameter("LeaveTypeName").equals("")){
	    	LeaveTypeName=request.getParameter("LeaveTypeName");
		    }
	    
	    
	    if(null !=request.getParameter("recommandFlag") && request.getParameter("recommandFlag").equalsIgnoreCase("y")){
	    	recommandFlag=request.getParameter("recommandFlag");
	    	parameters.put("recommandFlag",  "Recommanded by State Admin");
		    }
	    
	   
	    
	   
	    long suffixDaysNo=0;
	    long prefixDaysNo=0;
	    
	    if(null !=request.getParameter("AddressOnLeave") && !request.getParameter("AddressOnLeave").equals("")){
	    	AddressOnLeave=request.getParameter("AddressOnLeave");
	    	
	    }
	   
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = leaveHandlerService.getConnectionForReport();
		
		parameters.put("AddressOnLeave", AddressOnLeave);
		parameters.put("reason", request.getParameter("reason"));
		//parameters.put("currentDate", currentDate);
		parameters.put("dateOfBirth",  dob);
		parameters.put("dateOfJoin",  doj);
		parameters.put("employeeName",  request.getParameter("employeeName"));
		parameters.put("suffixDaysNo",  request.getParameter("suffixDaysNo"));
		parameters.put("prefixDaysNo",  request.getParameter("prefixDaysNo"));
		parameters.put("empId",  empId);
		parameters.put("postheld",  postheld);
		parameters.put("department",  department);
		parameters.put("jspFromDate",  jspFromDate);
		parameters.put("jspToDate",  jspToDate);
		parameters.put("LeaveTypeName",  LeaveTypeName);
		 
		
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		
		HMSUtil.generateReport("Live_Form13", parameters,(Connection) detailsMap.get("con"), response,getServletContext());
		
		try{
			((Connection) detailsMap.get("con")).close();
			}catch(Exception e){
				e.printStackTrace();
			}
	return null;
	}
	public ModelAndView showLeaveStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		// changes
		// map.put(MAIN,LEAVE_STATUS_JSP);
		// map.put(TITLE ,"Leave Status");

		String jsp = LEAVE_STATUS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showLeaveDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map addOrEdit = new HashMap();
		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		// changes
		// map.put(MAIN,LEAVE_DETAILS_JSP);
		// map.put(TITLE,"Leave Details");
		// session=request.getSession(true);
		Users user = (Users) session.getAttribute(USERS);
		MasEmployee employee = user.getEmployee();

		addOrEdit = leaveHandlerService.getAddOrEdit(employee);
		String jsp = LEAVE_DETAILS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("addOrEdit", addOrEdit);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showWaitingLeaves(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		int userId = 0;
		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");
		}
		int userType = 0;
		Users user = (Users) session.getAttribute(USERS);
		MasEmployee employee = user.getEmployee();
		if(user.getUserType() != null){
			userType = (Integer)user.getUserType();
		}
		List waitingLeavesList = new ArrayList();
		waitingLeavesList = leaveHandlerService.getWaitingLeavesList(employee,hospitalId);
		Map<String, Object> map = new HashMap<String, Object>();

		// map.put(MAIN,WAITING_LEAVES_JSP);
		// map.put(TITLE,"Leaves Waiting for approval");
		map.put("waitingLeavesList", waitingLeavesList);

		String jsp = WAITING_LEAVES_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("userType", userType);
		map.put("userId", userId);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showWaitingLeavesEncashment(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user = (Users) session.getAttribute(USERS);
		MasEmployee employee = user.getEmployee();

		List waitingLeavesList = new ArrayList();
		waitingLeavesList = leaveHandlerService
				.getWaitingEncashmentLeave(employee);

		Map<String, Object> map = new HashMap<String, Object>();

		// map.put(MAIN,WAITING_LEAVES_JSP);
		// map.put(TITLE,"Leaves Waiting for approval");
		map.put("waitingLeavesList", waitingLeavesList);

		String jsp = WAITING_LEAVES_ENCASHMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showApprovedLeaves(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user = (Users) session.getAttribute(USERS);
		MasEmployee employee = user.getEmployee();
		List approvedLeavesList = leaveHandlerService
				.getApprovedLeavesList(employee);

		List<HrEncashmentDetails> approvedLeavesEncashment = leaveHandlerService
				.getApprovedLeavesEncashment(employee);
		Map<String, Object> map = new HashMap<String, Object>();

		// map.put(MAIN,APPROVED_LEAVES_JSP);
		// map.put(TITLE,"Approved Leaves");

		map.put("approvedLeavesList", approvedLeavesList);
		map.put("approvedLeavesEncashment", approvedLeavesEncashment);

		String jsp = APPROVED_LEAVES_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showApprovedLeavesInCurrentDate(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user = (Users) session.getAttribute(USERS);
		MasEmployee employee = user.getEmployee();
		List approvedLeavesList = leaveHandlerService
				.getTodayApprovedLeavesList(employee);

		List<HrEncashmentDetails> approvedLeavesEncashment = new ArrayList<HrEncashmentDetails>();
		Map<String, Object> map = new HashMap<String, Object>();

		// map.put(MAIN,APPROVED_LEAVES_JSP);
		// map.put(TITLE,"Approved Leaves");

		map.put("approvedLeavesList", approvedLeavesList);
		map.put("approvedLeavesEncashment", approvedLeavesEncashment);

		String jsp = APPROVED_LEAVES_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showDisapprovedLeaves(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user = (Users) session.getAttribute(USERS);
		MasEmployee employee = user.getEmployee();
		List disapprovedLeavesList = leaveHandlerService
				.getDisapprovedLeavesList(employee);

		List<HrEncashmentDetails> disapprovedLeavesEncashment = leaveHandlerService
				.getDisapprovedLeavesEncashment(employee);
		Map<String, Object> map = new HashMap<String, Object>();
		// map.put(MAIN,DISAPPROVED_LEAVES_JSP);
		// map.put(TITLE,"Disapproved Leaves");
		map.put("disapprovedLeavesList", disapprovedLeavesList);
		map.put("disapprovedLeavesEncashment", disapprovedLeavesEncashment);

		String jsp = DISAPPROVED_LEAVES_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showMyDetails(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ParseException {
		String leaveType = "";
		String leaveStatus = "";
		String fromDate = "";
		String toDate = "";
		String encashmentYOrN = "";
		boolean encashmentListOnly = false;

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		List<HrLeaveDetails> leaveList = new ArrayList<HrLeaveDetails>();
		List<Object[]>uploadViewDataList = new ArrayList<Object[]>();
		List<HrEncashmentDetails> leaveEncashmentList = new ArrayList<HrEncashmentDetails>();

		if (request.getParameter(FROM_DATE) != null
				&& !request.getParameter(FROM_DATE).trim().equals("")) {
			fromDate = request.getParameter(FROM_DATE);
		}
		if (request.getParameter(TO_DATE) != null
				&& !request.getParameter(TO_DATE).trim().equals("")) {
			toDate = request.getParameter(TO_DATE);
		}

		if (request.getParameter(LEAVE_TYPE) != null) {
			leaveType = request.getParameter("leaveType");
		}
		if (request.getParameter(LEAVE_STATUS) != null) {
			leaveStatus = request.getParameter("leaveStatus");
		}
		int hospitalId = 0;
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Users user = (Users) session.getAttribute(USERS);
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			mapForDs.put("hospitalId", hospitalId);
		}

		mapForDs.put("employeeId", user.getEmployee().getId());
		Map<String, Object> map = new HashMap<String, Object>();

		map = leaveHandlerService.getPersonalDetailsPatMatDetails(mapForDs);

		leaveEncashmentList = leaveHandlerService.getLeavesEncashmentList(user
				.getEmployee().getId(), fromDate, toDate, leaveType,
				leaveStatus);
		leaveList = leaveHandlerService.getLeavesList(user.getEmployee()
				.getId(), fromDate, toDate, leaveType, leaveStatus);
		uploadViewDataList = leaveHandlerService.getUploadDataList(mapForDs);

		if (request.getParameter(ENCHASHMENT_CHECK) != null) {
			leaveList = new ArrayList<HrLeaveDetails>();
			encashmentListOnly = true;
		}

		map.put("encashmentListOnly", encashmentListOnly);
		map.put("leaveEncashmentList", leaveEncashmentList);
		map.put("leaveList", leaveList);

		List<HrEmployeeBalanceNew> leaveBalance = leaveHandlerService
				.getLeaveBalance(user.getEmployee().getId());

		List leaveTypeList = leaveHandlerService.getMasLeaveTypeMediatorList();
		List leaveStatusList = leaveHandlerService.getLeaveStatusList();

		// int rhFirstHalf =
		// leaveHandlerService.getRH(leaveList,FIRST_HALF_START,FIRST_HALF_END);
		// int rhSecondHalf =
		// leaveHandlerService.getRH(leaveList,SECOND_HALF_START,SECOND_HALF_END);

		// map.put("rhFirstHalf", rhFirstHalf);
		// map.put("rhSecondHalf", rhSecondHalf);
		map.put("leaveBalance", leaveBalance);
		// changes
		// map.put("locationId", user.getLocationId());
		// map.put("locationId", 10);

		map.put("leaveTypeList", leaveTypeList);
		map.put("leaveStatusList", leaveStatusList);
		map.put("uploadViewDataList", uploadViewDataList);

		// map.put(MAIN,MY_DETAILS_JSP);
		// map.put(TITLE,"My Leave Details");
		String jsp = MY_DETAILS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showTeamDetails(HttpServletRequest request,
			HttpServletResponse response) {
		/*--------------------------------*/
		String leaveType = "";
		String leaveStatus = "";
		String fromDate = "";
		String toDate = "";
		boolean encashmentListOnly = false;

		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		if (request.getParameter(FROM_DATE) != null
				&& !request.getParameter(FROM_DATE).trim().equals("")) {
			fromDate = request.getParameter(FROM_DATE);
		}
		if (request.getParameter(TO_DATE) != null
				&& !request.getParameter(TO_DATE).trim().equals("")) {
			toDate = request.getParameter(TO_DATE);
		}

		if (request.getParameter(LEAVE_TYPE) != null) {
			leaveType = request.getParameter("leaveType");
		}
		if (request.getParameter(LEAVE_STATUS) != null) {
			leaveStatus = request.getParameter("leaveStatus");
		}

		/*--------------------------------*/
		// session=request.getSession(true);
		// List leaveList=null;
		Users users = (Users) session.getAttribute(USERS);
		MasEmployee user = users.getEmployee();
		mapForDs.put("employeeId", user.getId());

		List empNames = leaveHandlerService.getEmpNamesList(user.getId());
		/*--------------------------------*/
		// changes
		// List<HrLeaveDetails>
		// leaveList=leaveHandlerService.getLeavesList(user.getId(),fromDate,toDate,leaveType,leaveStatus);
		List<HrLeaveDetails> leaveList = null;
		List<HrEncashmentDetails> leaveEncashmentList = new ArrayList<HrEncashmentDetails>();

		List leaveTypeList = leaveHandlerService.getMasLeaveTypeMediatorList();
		List leaveStatusList = leaveHandlerService.getLeaveStatusList();
		/*--------------------------------*/
		Boolean flag = false;

		Map<String, Object> map = new HashMap<String, Object>();
		map = leaveHandlerService.getPersonalDetailsPatMatDetails(mapForDs);

		map.put("encashmentListOnly", encashmentListOnly);
		map.put("leaveList", leaveList);
		map.put("leaveEncashmentList", leaveEncashmentList);

		map.put("empNames", empNames);
		/*--------------------------------*/
		map.put("leaveTypeList", leaveTypeList);
		map.put("leaveStatusList", leaveStatusList);
		map.put("flag", flag);
		/*--------------------------------*/
		// map.put(MAIN,TEAM_DETAILS_JSP);
		// map.put(TITLE,"Team Details");
		String jsp = TEAM_DETAILS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView sendSuggestion(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		Box box = HMSUtil.getBox(request);
		// session=request.getSession(true);
		Users user = (Users) session.getAttribute(USERS);
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
			int count = Integer.parseInt(mrequest.getParameter("hdb"));
			box.put("count", count);
			int i = 1;
			for (i = 1; i <= count; i++) {
				if(mrequest.getParameter("checkbox"+i)!=null){
					box.put("checkboxVal" + i, mrequest.getParameter("checkbox"+i));
				}
			}
		String suggestionMessage = "";
		if (mrequest.getParameter("remarks") != null) {
			suggestionMessage = mrequest.getParameter("remarks");
		}
		/*String suggestion[] = request.getParameterValues("checkbox");

		String suggestionMessage = "";
		if (request.getParameter("remarks") != null) {
			suggestionMessage = request.getParameter("remarks");
		}*/

		MasEmployee employee = user.getEmployee();

		leaveHandlerService.sendSuggestion(employee,
				suggestionMessage,box);
		List waitingLeavesList = leaveHandlerService
				.getWaitingLeavesList(employee,hospitalId);
		Map<String, Object> map = new HashMap<String, Object>();

		// map.put(MAIN,WAITING_LEAVES_JSP);
		// map.put(TITLE,"Leaves Waiting for approval");

		map.put("waitingLeavesList", waitingLeavesList);

		String jsp = WAITING_LEAVES_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView onHoldEncashment(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		// session=request.getSession(true);
		Users user = (Users) session.getAttribute(USERS);
		String suggestion[] = request.getParameterValues("checkbox");

		String suggestionMessage = "";
		if (request.getParameter("remarks") != null) {
			suggestionMessage = request.getParameter("remarks");
		}

		MasEmployee employee = user.getEmployee();

		leaveHandlerService.onHoldEncashment(suggestion, employee,
				suggestionMessage);
		List waitingLeavesList = leaveHandlerService
				.getWaitingEncashmentLeave(employee);
		Map<String, Object> map = new HashMap<String, Object>();

		// map.put(MAIN,WAITING_LEAVES_JSP);
		// map.put(TITLE,"Leaves Waiting for approval");

		map.put("waitingLeavesList", waitingLeavesList);

		String jsp = WAITING_LEAVES_ENCASHMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView approveLeaves(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		// session=request.getSession(true);
		Users user = (Users) session.getAttribute(USERS);
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
			int count = Integer.parseInt(mrequest.getParameter("hdb"));
			box.put("count", count);
			int i = 1;
			for (i = 1; i <= count; i++) {
				if(mrequest.getParameter("checkbox"+i)!=null){
					box.put("checkboxVal" + i, mrequest.getParameter("checkbox"+i));
				}
			}
		String remarks = "";
		if (mrequest.getParameter("remarks") != null) {
			remarks = mrequest.getParameter("remarks");
		}

		/*String recommend = "";
		if (request.getParameter("recommend") != null && request.getParameter("recommend").equalsIgnoreCase("y")) {
			recommend = "y";
		}
		else{
			recommend = "n";
		}
*/
		MasEmployee employee = user.getEmployee();

		leaveHandlerService.approveLeaves(employee, remarks,box);

		List waitingLeavesList = leaveHandlerService
				.getWaitingLeavesList(employee,hospitalId);
		Map<String, Object> map = new HashMap<String, Object>();

		// map.put(MAIN,WAITING_LEAVES_JSP);
		// map.put(TITLE,"Leaves Waiting for approval");
		map.put("waitingLeavesList", waitingLeavesList);

		String jsp = WAITING_LEAVES_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView recomendLeaves(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		Map<String, Object> map  = null;
		HrLeaveDetails leaveDetails = null;
		String jsp = null;
		Box box = HMSUtil.getBox(request);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}
		int userId = 0;
		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");
			box.put("userId", userId);
		}
		String fileName = null;
		String fileExtension = null;
		// session=request.getSession(true);
		Users user = (Users) session.getAttribute(USERS);
		int userType = 0;
		String empName = null; 
		if(user.getUserType() != null){
			userType = (Integer)user.getUserType();
			empName = user.getEmployee().getEmployeeName();
			box.put("userType", userType);
		}
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
			Map<String, Object> uploadFileMap = new HashMap<String, Object>();
			String userHome = getServletContext().getRealPath("");
			String fileSeparator = System.getProperty("file.separator");
			
			String uploadURL = userHome.substring(0, userHome
					.lastIndexOf(fileSeparator))
					+ fileSeparator
					+ "HMSDocumentFolder"
					+ fileSeparator
					+ "upload" + fileSeparator;
			
			
			HMSUtil.createFolderFroDocument("LeaveDoc", uploadURL);
			List fileUploadedList = null;
			int uploadCount = Integer.parseInt(mrequest.getParameter("hdb"));
			box.put("uploadCount", uploadCount);
			Hashtable files = mrequest.getFiles();
			
			System.out.println("uploadCount-----"+uploadCount);
			System.out.println("files-----"+files);
			
			int i = 1;
			for (i = 1; i <= uploadCount; i++) {
				if(mrequest.getParameter("checkbox"+i)!=null){
					box.put("checkboxVal" + i, mrequest.getParameter("checkbox"+i));
					System.out.println("uploadfile name===="+(UploadFile) files.get(RequestConstants.UPLOAD_FILENAME + i));
					UploadFile file = (UploadFile) files.get(RequestConstants.UPLOAD_FILENAME + i);
					if (file!=null) // && fileSize <= 2097152 )
					{

						String fileName1 = file.getFileName();
						System.out.println("fileName1==="+fileName1);
						if(fileName1 != null){
							StringTokenizer strToken = new StringTokenizer(fileName1, ".");

							fileName = strToken.nextToken();
							fileExtension = strToken.nextToken();

							String whiteList = "*." + fileExtension;

							fileUploadedList = HMSUtil.uploadFile(mrequest, uploadURL
									+ "LeaveDoc" + fileSeparator, whiteList,fileName1, i);
							box.put("filename" + i, fileName1);
							//box.put("description" + i, mrequest.getParameter(DESCRIPTION+ i));
							box.put("fileExtension" + i, fileExtension);
							box.put("fileSeparator", fileSeparator);
							box.put("uploadURL", uploadURL);
						}
					} else {
						//box.put("filename" + i, "0");
					}
				}else{
					box.put("checkboxVal" + i, 0);
				}
			}	
		String approve[] = mrequest.getParameterValues("checkbox");
		String remarks = "";
		if (mrequest.getParameter("remarks") != null) {
			remarks = mrequest.getParameter("remarks");
		}

		String recommend ="";
		if (mrequest.getParameter("recommend") != null && mrequest.getParameter("recommend").equalsIgnoreCase("recomedYes")) {
			recommend = "y";
		}
		else{
			recommend = "n";
		}
		
		String recommendRemarks ="";
		System.out.println("recommended  remarks===="+mrequest.getParameter("recomendRemarks"));
		if (mrequest.getParameter("recomendRemarks") != null && !mrequest.getParameter("recomendRemarks").equalsIgnoreCase("")) {
			recommendRemarks = mrequest.getParameter("recomendRemarks");
		}
		else{
			recommendRemarks = "";
		}

		MasEmployee employee = user.getEmployee();

		map = leaveHandlerService.recomendLeaves(approve, employee, remarks,recommend,recommendRemarks,box);

		if(map!=null && map.get("leaveDetails")!=null)
			leaveDetails = (HrLeaveDetails)map.get("leaveDetails");
		
		List waitingLeavesList = leaveHandlerService
				.getWaitingLeavesList(employee,hospitalId);
		map = new HashMap<String, Object>();

		// map.put(MAIN,WAITING_LEAVES_JSP);
		// map.put(TITLE,"Leaves Waiting for approval");
		map.put("waitingLeavesList", waitingLeavesList);

		
		if( (recommend.equalsIgnoreCase("y") && leaveDetails!=null) && (userType==1 || empName.equalsIgnoreCase("State Admin"))){
			map.put("AddressOnLeave", leaveDetails.getContactAddress());
			map.put("reason", leaveDetails.getReason());
			map.put("dateOfBirth", leaveDetails.getEmpId().getDateOfBirth() );
			map.put("dateOfJoin", leaveDetails.getJoiningDate());
			map.put("employeeName", leaveDetails.getEmpId().getEmployeeName());
			map.put("suffixDaysNo", 0);
			map.put("prefixDaysNo", 0);
			map.put("empId", leaveDetails.getEmpId().getId());
			map.put("department", leaveDetails.getEmpId().getDepartment());
			//map.put("postheld", leaveDetails);
			map.put("jspFromDate", leaveDetails.getFromDate());
			map.put("jspToDate", leaveDetails.getToDate());
			map.put("LeaveTypeName", leaveDetails.getLeaveType().getLeaveType().getLeaveType().getDescription());
			map.put("recommandFlag", "y");
			map.put("message2", "message2");
			map.put("message1", "YOU HAVE SUCCESSFULLY RECOMMANDED THE LEAVE. DO YOU WANT TO PRINT ?");
		  jsp = HR_MESSAGE_JSP ;
		}else {
		  jsp = WAITING_LEAVES_JSP;
		}
		
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView approveLeavesEncashment(HttpServletRequest request,
			HttpServletResponse response) {
		// session=request.getSession(true);
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user = (Users) session.getAttribute(USERS);
		String approve[] = request.getParameterValues("checkbox");
		String remarks = "";
		if (request.getParameter("remarks") != null) {
			remarks = request.getParameter("remarks");
		}

		MasEmployee employee = user.getEmployee();

		leaveHandlerService.approveLeavesEncashment(approve, employee, remarks);

		List waitingLeavesList = leaveHandlerService
				.getWaitingEncashmentLeave(employee);
		Map<String, Object> map = new HashMap<String, Object>();

		// map.put(MAIN,WAITING_LEAVES_JSP);
		// map.put(TITLE,"Leaves Waiting for approval");
		map.put("waitingLeavesList", waitingLeavesList);

		String jsp = WAITING_LEAVES_ENCASHMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView disapproveLeaves(HttpServletRequest request,
			HttpServletResponse response) {
		// session=request.getSession(true);
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		String disapproveMessage = "";
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		Users user = (Users) session.getAttribute(USERS);
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
			int count = Integer.parseInt(mrequest.getParameter("hdb"));
			box.put("count", count);
			int i = 1;
			for (i = 1; i <= count; i++) {
				if(mrequest.getParameter("checkbox"+i)!=null){
					box.put("checkboxVal" + i, mrequest.getParameter("checkbox"+i));
				}
			}
		String remarks = "";
		if (mrequest.getParameter("remarks") != null) {
			disapproveMessage = mrequest.getParameter("remarks");
		}
		
		/*String disapprove[] = request.getParameterValues("checkbox");*/
	
		
		MasEmployee employee = user.getEmployee();

		leaveHandlerService.disapproveLeaves(employee,
				disapproveMessage,box);
		List waitingLeavesList = leaveHandlerService
				.getWaitingLeavesList(employee,hospitalId);
		Map<String, Object> map = new HashMap<String, Object>();

		// map.put(MAIN,WAITING_LEAVES_JSP);
		// map.put(TITLE,"Leaves Waiting for approval");
		map.put("waitingLeavesList", waitingLeavesList);

		String jsp = WAITING_LEAVES_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView disapproveLeavesEncashment(HttpServletRequest request,
			HttpServletResponse response) {
		// session=request.getSession(true);
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user = (Users) session.getAttribute(USERS);
		String disapprove[] = request.getParameterValues("checkbox");
		String disapproveMessage = "";
		if (request.getParameter("remarks") != null) {
			disapproveMessage = request.getParameter("remarks");
		}

		MasEmployee employee = user.getEmployee();

		leaveHandlerService.disapproveLeavesEncashment(disapprove, employee,
				disapproveMessage);
		List waitingLeavesList = leaveHandlerService
				.getWaitingEncashmentLeave(employee);
		Map<String, Object> map = new HashMap<String, Object>();

		// map.put(MAIN,WAITING_LEAVES_JSP);
		// map.put(TITLE,"Leaves Waiting for approval");
		map.put("waitingLeavesList", waitingLeavesList);

		String jsp = WAITING_LEAVES_ENCASHMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteLeaves(HttpServletRequest request,
			HttpServletResponse response) {
		// session=request.getSession(true);
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user = (Users) session.getAttribute(USERS);
		String delete[] = request.getParameterValues("checkbox");
		String deleteForEncashment[] = request
				.getParameterValues("checkboxEncashment");

		String deleteMessage = request.getParameter("deleteMessage");

		MasEmployee employee = user.getEmployee();

		leaveHandlerService.deleteLeaves(delete, employee, deleteMessage);
		leaveHandlerService.deleteLeavesEncashment(deleteForEncashment,
				employee, deleteMessage);

		ModelAndView mv = new ModelAndView();
		try {
			mv = showMyDetails(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return mv;
	}

	public ModelAndView showTeamMemberDetail(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ParseException {
		/*--------------------------------*/
		String leaveType = "";
		String leaveStatus = "";
		String fromDate = "";
		String toDate = "";
		boolean encashmentListOnly = false;

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		List<HrLeaveDetails> leaveList = new ArrayList<HrLeaveDetails>();
		List<HrEncashmentDetails> leaveEncashmentList = new ArrayList<HrEncashmentDetails>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		if (request.getParameter(FROM_DATE) != null
				&& !request.getParameter(FROM_DATE).trim().equals("")) {
			fromDate = request.getParameter(FROM_DATE);
		}
		if (request.getParameter(TO_DATE) != null
				&& !request.getParameter(TO_DATE).trim().equals("")) {
			toDate = request.getParameter(TO_DATE);
		}

		if (request.getParameter(LEAVE_TYPE) != null) {
			leaveType = request.getParameter("leaveType");
		}
		if (request.getParameter(LEAVE_STATUS) != null) {
			leaveStatus = request.getParameter("leaveStatus");
		}

		/*--------------------------------*/
		// session=request.getSession(true);
		Users users = (Users) session.getAttribute(USERS);
		MasEmployee emp = users.getEmployee();
		mapForDs.put("employeeId", emp.getId());

		int memberId = Integer.parseInt(request.getParameter("memberId"));

		leaveEncashmentList = leaveHandlerService.getLeavesEncashmentList(
				memberId, fromDate, toDate, leaveType, leaveStatus);
		leaveList = leaveHandlerService.getLeavesList(memberId, fromDate,
				toDate, leaveType, leaveStatus);

		if (request.getParameter(ENCHASHMENT_CHECK) != null) {
			leaveList = new ArrayList<HrLeaveDetails>();
			encashmentListOnly = true;

		}
		Map<String, Object> map = new HashMap<String, Object>();
		map = leaveHandlerService.getPersonalDetailsPatMatDetails(mapForDs);
		map.put("encashmentListOnly", encashmentListOnly);

		List<HrEmployeeBalanceNew> leaveBalance = leaveHandlerService
				.getLeaveBalance(memberId, leaveType);
		MasEmployee memberDetail = leaveHandlerService
				.getMemberDetails(memberId);

		List empNames = leaveHandlerService.getEmpNamesList(emp.getId());

		/*--------------------------------*/
		List leaveTypeList = leaveHandlerService.getMasLeaveTypeMediatorList();
		List leaveStatusList = leaveHandlerService.getLeaveStatusList();
		Boolean flag = true;
		/*--------------------------------*/
		map.put("leaveList", leaveList);
		map.put("leaveEncashmentList", leaveEncashmentList);

		// map.put("rhFirstHalf", rhFirstHalf);
		// map.put("rhSecondHalf", rhSecondHalf);

		map.put("leaveBalance", leaveBalance);
		map.put("empNames", empNames);
		// map.put("locationId", memberDetail.getLocationId());
		/*--------------------------------*/
		map.put("leaveTypeList", leaveTypeList);
		map.put("leaveStatusList", leaveStatusList);
		map.put("flag", flag);
		/*--------------------------------*/
		// map.put(MAIN,TEAM_DETAILS_JSP);
		// map.put(TITLE,"Team Details");
		String jsp = TEAM_DETAILS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView contactDetails(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Map detailsMap = leaveHandlerService.leaveRecord(Integer
				.parseInt(request.getParameter("leaveId")));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("detailsMap", detailsMap);

		// map.put("main",CONTACT_DETAILS_JSP);
		// map.put("title","Details");

		String jsp = CONTACT_DETAILS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView contactDetailsEncashment(HttpServletRequest request,
			HttpServletResponse response) {

		Map detailsMap = new HashMap();
		// Map detailsMap =
		// leaveHandlerService.leaveRecord(Integer.parseInt(request.getParameter("leaveId")));
		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		map.put("detailsMap", detailsMap);

		// map.put("main",CONTACT_DETAILS_JSP);
		// map.put("title","Details");

		String jsp = CONTACT_DETAILS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchLeaveBalance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		List employeeList = userMasterHandlerService.getEmployeeList();
		map.put("employeeList", employeeList);

		// map.put(MAIN,SEARCH_LEAVE_BALANCE_JSP);
		// map.put(TITLE,"Search Leave Balance");

		String jsp = SEARCH_LEAVE_BALANCE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView viewLeaveBalance(HttpServletRequest request,
			HttpServletResponse response) {
		// session=request.getSession(true);
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Map<String, Object> map = new HashMap<String, Object>();
		List<HrEncashmentDetails> leaveEncashmentList = new ArrayList<HrEncashmentDetails>();

		int empId = 0;
		Map<String, Object> empDetailsMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Users user = (Users) session.getAttribute(USERS);

		mapForDs.put("employeeId", user.getEmployee().getId());

		if ((!(request.getParameter(EMP_NAME)).equals(""))
				|| request.getParameter(EMP_NAME) != null) {
			empId = Integer.parseInt(request.getParameter(EMP_NAME));
		}

		map = leaveHandlerService.getPersonalDetailsPatMatDetails(mapForDs);
		empDetailsMap = leaveHandlerService.getEmpLeaveDetails(empId);
		leaveEncashmentList = leaveHandlerService.getLeavesEncashmentList(
				empId, "", "", "", "");
		map.put("empDetailsMap", empDetailsMap);
		map.put("leaveEncashmentList", leaveEncashmentList);
		// map.put(MAIN,SHOW_LEAVE_BALANCE_JSP);
		// map.put(TITLE,"Show Leave Balance");

		String jsp = SHOW_LEAVE_BALANCE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateLeaveBalance(HttpServletRequest request,
			HttpServletResponse response) {
		// session=request.getSession(true);
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user = (Users) session.getAttribute(USERS);
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

		Map<String, Object> map = new HashMap<String, Object>();

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = "";
		String currentTime = "";
		currentDate = (String) utilMap.get("currentDate");
		currentTime = (String) utilMap.get("currentTime");

		Date modifiedDate = new Date();

		String newLeaveBalance = "";
		String newOnsiteLeaveBalance = "";
		String remarks = "";
		/*
		 * String fromDate = ""; String toDate = "";
		 */
		String recepientAddress = "";
		/*
		 * String senderEmailId = ""; String emailMessage = ""; String subject =
		 * "";
		 */String oldLeaveBalance = "";
		double updatedLeaves = 0.0;
		boolean flag = false;
		if (session.getAttribute("update") != null) {
			flag = true;
		}

		if (flag) {
			oldLeaveBalance = request.getParameter(OLD_LEAVE_BALANCE);
			newLeaveBalance = request.getParameter(LEAVE_BALANCE);

			updatedLeaves = Double.parseDouble(newLeaveBalance)
					- Double.parseDouble(oldLeaveBalance);
			String balanceAdjustedBy = new DecimalFormat("0.##")
					.format((double) updatedLeaves);

			remarks = request.getParameter(REMARKS);
			/*
			 * fromDate = request.getParameter(FROM_DATE); toDate =
			 * request.getParameter(TO_DATE);
			 */

			Integer leaveTypeId = Integer.parseInt(request
					.getParameter(LEAVE_TYPE_ID));
			int empId = Integer.parseInt(request.getParameter(EMP_NAME));
			int hrId = user.getEmployee().getId();

			HrUpdateLeaveBalanceHistory leaveHistory = new HrUpdateLeaveBalanceHistory();
			leaveHistory.setHrId(hrId);
			leaveHistory.setEmpId(empId);
			leaveHistory.setNewLeaveBalance(newLeaveBalance);

			MasEmployee updatedFor = new MasEmployee();
			updatedFor.setId(empId);
			leaveHistory.setEmployeeUpdated(updatedFor);

			MasEmployee updatedBy = new MasEmployee();
			updatedBy.setId(hrId);
			leaveHistory.setUsers(updatedBy);

			leaveHistory.setModifiedAt(modifiedDate);
			leaveHistory.setRemarks(remarks);
			leaveHistory.setBalanceAdjustBy(balanceAdjustedBy);

			leaveHistory.setLastChgBy(user);
			leaveHistory.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(currentDate));
			leaveHistory.setLastChgTime(currentTime);

			MasHospital company = new MasHospital();
			company.setId(hospitalId);
			leaveHistory.setCompany(company);

			/*
			 * if( fromDate!=null && !(fromDate.equals(""))){ Date
			 * jspFromDate=HMSUtil.dateFormatterDDMMYYYY(fromDate);
			 * leaveHistory.setFromdate(jspFromDate); } if( toDate!=null &&
			 * !(toDate.equals(""))){ Date
			 * jspToDate=HMSUtil.dateFormatterDDMMYYYY(toDate);
			 * leaveHistory.setFromdate(jspToDate); }
			 */
			HrMasLeaveTypeMediator leaveType = new HrMasLeaveTypeMediator();
			leaveType.setId(leaveTypeId);
			leaveHistory.setLeaveType(leaveType);

			leaveHandlerService.updateLeaveBalance(leaveHistory,
					newLeaveBalance, newOnsiteLeaveBalance, empId,
					balanceAdjustedBy);

			/*
			 * Map emailIdMap = leaveHandlerService.getEmailId(hrId,empId);
			 *
			 * String empEmailId = (String)emailIdMap.get("empEmailId"); String
			 * userManagerEmailId =
			 * (String)emailIdMap.get("userManagerEmailId"); String
			 * hrManagerEmailId = (String)emailIdMap.get("hrManagerEmailId");
			 *
			 * recepientAddress =
			 * (recepientAddress.concat(empEmailId)).concat(",").trim();
			 * recepientAddress =
			 * (recepientAddress.concat(userManagerEmailId)).concat(",").trim();
			 * recepientAddress =
			 * (recepientAddress.concat(hrManagerEmailId)).concat(",").trim();
			 */

			// changes
			// Users employee = getUserMasterHandlerService().getUser(empId);
			/*
			 * List<MasEmployee> employeeList =
			 * getUserMasterHandlerService().getEmployeeList(); MasEmployee
			 * employee = employeeList.get(0);
			 *
			 *
			 * if(recepientAddress != "") { recepientAddress =
			 * recepientAddress.substring(0,recepientAddress.length()-1); }
			 */
			/*
			 * if(updatedLeaves>0) { emailMessage = " Leave balance of
			 * "+employee.getFirstName()+"("+employee.getEmployeeCode()+") has
			 * been updated by "+user.getEmployee().getFirstName()+"
			 * "+user.getEmployee().getLastName()+".\n"+ " Previous leave
			 * balance was "+oldLeaveBalance+"."+ " Current leave balance is
			 * "+newLeaveBalance+".\n"+ " Its increased by "+updatedLeaves+"
			 * leaves.\n"+ " Remarks:"+remarks+".\n"; } else { emailMessage = "
			 * Leave balance of
			 * "+employee.getFirstName()+"("+employee.getEmployeeCode()+") has
			 * been updated by "+user.getEmployee().getFirstName()+"
			 * "+user.getEmployee().getLastName()+".\n"+ " Your previous leave
			 * balance was "+oldLeaveBalance+"."+ " Your current leave balance
			 * is "+newLeaveBalance+".\n"+ " Its decreased by
			 * "+(-updatedLeaves)+" leaves.\n"+ " Remarks:"+remarks+".\n"; }
			 * Balance";
			 *
			 * senderEmailId = user.getEmailAddress();
			 */

			// changes
			// RequestTrackerUtil.intranetEmailFunction(recepientAddress,
			// senderEmailId, emailMessage, subject);
			String message[] = { "Leave Balance Updated Successfully." };

			List<String> link = new ArrayList<String>();

			link.add("Click Here to Update record again ");
			link.add("leave?method=searchLeaveBalance");

			map.put("message", message);
			map.put("link", link);

			// map.put("message",message);
			// map.put(MAIN, "message.jsp");
			String jsp = HR_MESSAGE_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put(TITLE, "Leave Balance Updated");

			session.setAttribute("update", null);
			return new ModelAndView("index", "map", map);

		} else {

			String message[] = {
					"You have already update the leave balance. Go to Update Leave Balance option to update again",
					"/jktintranet/jkt/leave?method=searchLeaveBalance",
					"/jktintranet/jkt/login?method=showPage&jspPage=home" };
			map.put("message", message);

			// map.put(MAIN, "message.jsp");
			// map.put(TITLE,"Leave Application");
			String jsp = HR_MESSAGE_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put(TITLE, "Leave Application");

			return new ModelAndView("index", "map", map);
		}

	}

	public ModelAndView searchLeaveHistory(HttpServletRequest request,
			HttpServletResponse response) {
		// session = request.getSession(true);
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user = (Users) session.getAttribute(USERS);
		Map<String, Object> map = new HashMap<String, Object>();
		String userRole = "";
		String userName = "";
		List employeeList = new ArrayList();
		// Set userRoleMapSet = (Set)user.getRoles();
		// for (Iterator iter = userRoleMapSet.iterator(); iter.hasNext();) {
		// UserRoleMap userRoleMap = (UserRoleMap) iter.next();
		// userRole = userRoleMap.getRoleId();
		// if(userRole.equals("R00017"))
		// {
		// employeeList = userMasterHandlerService.getEmployeeList();
		// map.put("employeeList", employeeList);

		// }
		// else{
		userName = user.getEmployee().getFirstName();
		List leaveHistoryList = leaveHandlerService.viewLeaveHistory(user
				.getEmployee().getId());
		map.put("leaveHistoryList", leaveHistoryList);
		map.put("userName", userName);

		// }
		// }
		session.setAttribute("firstTime", "firstTime");

		String jsp = LEAVE_DETAILS_HISTORY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		// map.put("main",LEAVE_DETAILS_HISTORY_JSP);
		// map.put("title","Leave Details History");

		return new ModelAndView("index", "map", map);

	}

	public ModelAndView viewLeaveHistory(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		session.setAttribute("firstTime", "secondTime");
		Map<String, Object> map = new HashMap<String, Object>();
		int empId = Integer.parseInt(request.getParameter(EMP_NAME));
		List employeeList = userMasterHandlerService.getEmployeeList();
		List leaveHistoryList = leaveHandlerService.viewLeaveHistory(empId);
		map.put("employeeList", employeeList);
		map.put("leaveHistoryList", leaveHistoryList);

		// map.put(MAIN, LEAVE_DETAILS_HISTORY_JSP);
		// map.put(TITLE, "Leave Deatils History");

		String jsp = LEAVE_DETAILS_HISTORY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	/*
	 * public ModelAndView helpForLeaveManagement(HttpServletRequest request,
	 * HttpServletResponse response){ HttpSession session =
	 * request.getSession(false); if(session == null ||
	 * session.getAttribute(USERS) == null){ return new ModelAndView("index"); }
	 * Users user=(Users)session.getAttribute("user"); Set roleSet =
	 * user.getRoles(); Boolean userIsManager = false; Boolean userIsHR = false;
	 * Boolean userIsUser = false; for (Iterator roleSetIter =
	 * roleSet.iterator(); roleSetIter.hasNext();) { UserRoleMap userRoleMap =
	 * (UserRoleMap) roleSetIter.next();
	 * if(userRoleMap.getRoleId().equals("R00004")) { userIsUser = true; } else
	 * if(userRoleMap.getRoleId().equals("R00016")) { userIsManager = true; }
	 * else if(userRoleMap.getRoleId().equals("R00005")) { userIsHR = true; } }
	 * Map<String,Object> map=new HashMap<String,Object>(); String main = null;
	 * String title = null; if(userIsUser && !userIsManager && !userIsHR ){
	 * String jsp = USER_LEAVE_HELP_GUIDE_HTM; //jsp += ".jsp"; // map.put(MAIN,
	 * USER_LEAVE_HELP_GUIDE_HTM); // map.put(TITLE, "User Help Guide"); } else
	 * if(userIsManager && !userIsHR){ String jsp =
	 * MANAGER_LEAVE_HELP_GUIDE_HTM; // map.put(MAIN,
	 * MANAGER_LEAVE_HELP_GUIDE_HTM); // map.put(TITLE, "Manager Help Guide"); }
	 * else if(userIsHR && !userIsManager){ String jsp =
	 * HR_LEAVE_HELP_GUIDE_HTM; // map.put(MAIN, HR_LEAVE_HELP_GUIDE_HTM); //
	 * map.put(TITLE, "HR Help Guide"); }
	 *
	 * String jsp = WAITING_LEAVES_FOR_HR_JSP; jsp += ".jsp";
	 * map.put("contentJsp", jsp);
	 *
	 * return new ModelAndView("index", "map", map); }
	 */

	public ModelAndView waitingLeavesForHR(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		Users user = (Users) session.getAttribute(USERS);
		int empId = user.getEmployee().getId();
		List<HrEncashmentDetails> leaveEncashmentList = new ArrayList<HrEncashmentDetails>();
		List waitingLeavesList = leaveHandlerService
				.getAllWaitingLeavesForHR(empId);
		// -1 means for all employee
		leaveEncashmentList = leaveHandlerService.getLeavesEncashmentList(
				empId, "", "", "", "3");

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("waitingLeavesList", waitingLeavesList);
		map.put("leaveEncashmentList", leaveEncashmentList);

		// map.put(MAIN,WAITING_LEAVES_FOR_HR_JSP);
		// map.put(TITLE,"Waiting Leaves");

		String jsp = WAITING_LEAVES_FOR_HR_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showLeaveTypeMaster(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession(false);
		List<HrMasLeaveTypeNew> masLeaveTypeList = null; // added by amit das on 05-10-2016
		
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasLeaveTypeNew> leaveTypeForEdit = new ArrayList<HrMasLeaveTypeNew>();
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		// map.put(MAIN,WAITING_LEAVES_FOR_HR_JSP);
		// map.put(TITLE,"Waiting Leaves");
		int leaveMasTypeId = 0;
		if (request.getParameter("leaveTypeId") != null) {
			leaveMasTypeId = Integer.parseInt(request
					.getParameter("leaveTypeId"));
			leaveTypeForEdit = leaveHandlerService
					.getMasLeaveTypeListForId(leaveMasTypeId);
		}

		List<HrMasLeave> leaveTypeList = leaveHandlerService.getLeaveTypeList();
		masLeaveTypeList = leaveHandlerService.getMasLeaveTypeNewList();
		// List<HrMasLeaveTypeNew> minDateList =
		// leaveHandlerService.getMasLeaveTypeNewMinFromDateForLeaveType(20);

		// List<HrMasLeaveType> leaveTypeForEdit =
		// leaveHandlerService.getMasLeaveTypeListForId(leaveMasTypeId);	
		map.put("leaveTypeList", leaveTypeList);
		map.put("masLeaveTypeList", masLeaveTypeList); // added by amit das on 05-10-2016
		map.put("leaveTypeForEdit", leaveTypeForEdit);
		// map.put("minDateList",minDateList);

		String jsp = SHOW_LEAVE_TYPE_MASTER_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView submitTypeMaster(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();

		HrMasLeave hrMasLeave = new HrMasLeave();

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		// HrMasLeaveType hrMasLeaveType = new HrMasLeaveType();
		// List<HrMasLeaveType> hrMasLeaveTypeList = new
		// ArrayList<HrMasLeaveType>();
		// HttpSession session = request.getSession();
		HrMasLeaveTypeNew hrMasLeaveType = new HrMasLeaveTypeNew();

		List<HrMasLeaveTypeNew> hrMasLeaveTypeNewForMaxDate = new ArrayList<HrMasLeaveTypeNew>();
		List<HrMasLeaveTypeNew> hrMasLeaveTypeNewList = new ArrayList<HrMasLeaveTypeNew>();

		List<MasEmployee> employeeList = null;

		// List<HrMasLeaveType> hrMasLeaveTypeAllRec = new
		// ArrayList<HrMasLeaveType>();

		Date fromDate = null;
		// Date toDate = null;

		int leaveType = 0;
		// int allowedDays = 0;
		String encashmentYOrN = "";
		String carryForward = "";
		String recommendApprove = "";
		String halfDayAllow = "";
		int encashmentPercentage = 0;
		String remarks = "";
		int bufferRequired = 0;
		Date currentDate = new Date();
		Date jspFromDate = new Date();
		Date jspToDate = new Date();
		Boolean againSameLeaveRecord = false;
		Boolean defineAtleastOneForCurrentDate = false;
		Boolean jspFromDateLessThanLeastFromDate = false;
		Boolean insertInFirstPosition = false;
		// Logic for same record

		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			jspFromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
		}

		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			jspToDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
		}

		/*
		 * else if(request.getParameter(FROM_DATE)!=null &&
		 * (request.getParameter(TO_DATE).equals(""))){
		 * jspFromDate=HMSUtil.dateFormatterDDMMYYYY
		 * (request.getParameter(FROM_DATE)); jspToDate=jspFromDate; }
		 */


		/*
		 * if(request.getParameter(TYPE) != null &&
		 * !request.getParameter(TYPE).trim().equals("")){ leaveType =
		 * Integer.parseInt(request.getParameter(TYPE)); }
		 *
		 * hrMasLeaveTypeList =
		 * leaveHandlerService.getMasLeaveTypeList(leaveType);
		 *
		 *
		 * if(request.getParameter(FROM_DATE)!=null &&
		 * !"".equals(request.getParameter(FROM_DATE))){
		 *
		 * for (Iterator leaveListIterator = hrMasLeaveTypeList.iterator();
		 * leaveListIterator.hasNext();) { HrMasLeaveType leaveRecord =
		 * (HrMasLeaveType) leaveListIterator.next();
		 * if(leaveRecord.getValidFromDate()!=null) {
		 * if(jspFromDate.compareTo(leaveRecord.getValidFromDate())>=0 &&
		 * jspFromDate.compareTo(leaveRecord.getValidToDate())<= 0) {
		 * againSameLeaveRecord=true; break; }else
		 * if(jspFromDate.compareTo(leaveRecord.getValidFromDate())<= 0) {
		 * if(jspToDate.compareTo(leaveRecord.getValidFromDate())>= 0 ){
		 * againSameLeaveRecord=true; break; }
		 *
		 * }else if(jspFromDate.compareTo(leaveRecord.getValidFromDate())== 0 &&
		 * jspToDate.compareTo(leaveRecord.getValidToDate())==0){
		 * againSameLeaveRecord=true; break; } } } } //Date
		 * displayDate=DateFormat
		 * .getDateInstance(DateFormat.SHORT).format(currentDate);
		 * if(!againSameLeaveRecord){ HECK));
		 *
		 * if(request.getParameter(TYPE) != null &&
		 * !request.getParameter(TYPE).trim().equals("")){ leaveType =
		 * Integer.parseInt(request.getParameter(TYPE));
		 * hrMasLeave.setId(leaveType); hrMasLeaveType.setLeaveType(hrMasLeave);
		 * }
		 *
		 * if(request.getParameter(MONTHLY_OR_YEARLY)!=null) {
		 * if(request.getParameter(MONTHLY_OR_YEARLY).equals("monthly"))
		 * hrMasLeaveType.setMonthlyOrYearly("m"); else
		 * hrMasLeaveType.setMonthlyOrYearly("y"); }
		 *
		 * if(request.getParameter(ALLOWED_DAYS) != null &&
		 * !request.getParameter(ALLOWED_DAYS).trim().equals("")){ //allowedDays
		 * = Integer.parseInt(request.getParameter(ALLOWED_DAYS));
		 * hrMasLeaveType.setAllowedDays(request.getParameter(ALLOWED_DAYS)); }
		 *
		 * if(request.getParameter(ENCHASHMENT_CHECK) != null){ encashmentYOrN =
		 * request.getParameter(ENCHASHMENT_CHECK);
		 * hrMasLeaveType.setEncashable(encashmentYOrN);
		 *
		 * encashmentPercentage =
		 * Integer.parseInt(request.getParameter(ENCHASHMENT));
		 * hrMasLeaveType.setEncashablePercent(encashmentPercentage); } else {
		 * encashmentYOrN = "n"; hrMasLeaveType.setEncashable(encashmentYOrN);
		 * hrMasLeaveType.setEncashablePercent(0); }
		 *
		 * if(request.getParameter(CARRY_FORWARD) != null){ carryForward =
		 * request.getParameter(CARRY_FORWARD);
		 * hrMasLeaveType.setCrFrdable(carryForward); } else { carryForward =
		 * "n"; hrMasLeaveType.setCrFrdable(carryForward); }
		 *
		 * if(request.getParameter(FROM_DATE) != null &&
		 * !request.getParameter(FROM_DATE).trim().equals("")){ fromDate =
		 * HMSUtil
		 * .convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		 * hrMasLeaveType.setValidFromDate(fromDate);}
		 * if(request.getParameter(TO_DATE) != null &&
		 * !request.getParameter(TO_DATE).trim().equals("")){ toDate =
		 * HMSUtil.convertStringTypeDateToDateType
		 * (request.getParameter(TO_DATE));
		 * hrMasLeaveType.setValidToDate(toDate);}
		 *
		 * if(request.getParameter(REMARKS) != null){ remarks =
		 * request.getParameter(REMARKS); hrMasLeaveType.setRemarks(remarks); }
		 * String lastchangeBy = ""; if (request.getParameter(CHANGED_BY)!=
		 * null) { lastchangeBy = request.getParameter(CHANGED_BY);
		 * hrMasLeaveType.setLastChgBy(lastchangeBy); } Date changedDate = null;
		 * if(request.getParameter(CHANGED_DATE) != null &&
		 * !(request.getParameter(CHANGED_DATE).equals(""))){ changedDate =
		 * HMSUtil
		 * .convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
		 * hrMasLeaveType.setLastChgDate(changedDate); } String changedTime =
		 * ""; if(request.getParameter(CHANGED_TIME) != null &&
		 * !(request.getParameter(CHANGED_TIME).equals(""))){ changedTime =
		 * request.getParameter(CHANGED_TIME);
		 * hrMasLeaveType.setLastChgTime(changedTime); }
		 *
		 * leaveHandlerService.submitTypeMaster(hrMasLeaveType); // To be done
		 * later
		 *
		 *
		 * employeeList = userMasterHandlerService.getEmployeeList();
		 *
		 * for(MasEmployee employee :employeeList) { HrEmployeeBalance
		 * employeeBalance =new HrEmployeeBalance();
		 *
		 * employeeBalance.setEmp(employee);
		 * employeeBalance.setLeaveType(hrMasLeaveType);
		 * //employeeBalance.setOpeningBalance(hrMasLeaveType.getAllowedDays());
		 * employeeBalance.setTaken("0");
		 * //employeeBalance.setEarned(hrMasLeaveType.getAllowedDays());
		 * employeeBalance.setClosingBalance("0");
		 * employeeBalance.setStatus("y");
		 * employeeBalance.setLastChgBy(hrMasLeaveType.getLastChgBy());
		 * employeeBalance.setLastChgDate(hrMasLeaveType.getLastChgDate());
		 * employeeBalance.setLastChgTime(hrMasLeaveType.getLastChgTime());
		 *
		 * leaveHandlerService.saveEmployeeLeaveBalance(employeeBalance); }
		 */

		// Added for Only Trial
		if (request.getParameter(TYPE) != null
				&& !request.getParameter(TYPE).trim().equals("")) {
			leaveType = Integer.parseInt(request.getParameter(TYPE));
		}

		// hrMasLeaveTypeList =
		// leaveHandlerService.getMasLeaveTypeList(leaveType);
		Calendar calendar = Calendar.getInstance();
		calendar.set(9999, 11, 31);
		int userId=0;
		Date maxDate = calendar.getTime();
		if (session.getAttribute("userId") != null){
			userId = Integer.parseInt(session.getAttribute("userId").toString());
		}			

		hrMasLeaveTypeNewList = leaveHandlerService.getMasLeaveTypeNewList(leaveType);
		System.out.println("hrMasLeaveTypeNewList=in ocon==="+hrMasLeaveTypeNewList.size());
		
		hrMasLeaveTypeNewForMaxDate = leaveHandlerService.getMasLeaveTypeNewForMaxDate(leaveType, maxDate);
		
		System.out.println("hrMasLeaveTypeNewForMaxDate==in con ==="+hrMasLeaveTypeNewForMaxDate);
		
		List<Date> minDateList = leaveHandlerService.getMasLeaveTypeNewMinFromDateForLeaveType(leaveType);
		
		System.out.println("minDateList=="+minDateList);

		Date savedToDate = null;
		Date savedFromDate = null;

		if (hrMasLeaveTypeNewList.size() == 0) {
			// defineAtleastOneForCurrentDate = true;
		}

		if (request.getParameter(FROM_DATE) != null
				&& !"".equals(request.getParameter(FROM_DATE))) {
			if (minDateList.size() > 0) {
				Date hrMasLeaveRecordColumn = (Date)minDateList.get(0);
				Date fromDateMinRecord =hrMasLeaveRecordColumn;
				// Date
				// minDate=HMSUtil.dateFormatterDDMMYYYY(fromDateMinRecord);

				if (jspFromDate.compareTo(fromDateMinRecord) >= 0) {

					for (HrMasLeaveTypeNew leaveRecord : hrMasLeaveTypeNewList) {

						if (leaveRecord.getValidFromDate() != null) {
							String maxDate1 = LeaveManagementUtil
									.convertDateToStringWithoutTime(maxDate);
							Date maxDate2 = HMSUtil
									.dateFormatterDDMMYYYY(maxDate1);

							if ((leaveRecord.getValidToDate())
									.compareTo(maxDate2) != 0) {
								if (jspFromDate.compareTo(leaveRecord
										.getValidFromDate()) >= 0
										&& jspFromDate.compareTo(leaveRecord
												.getValidToDate()) <= 0) {

									savedFromDate = leaveRecord
											.getValidFromDate();
									savedToDate = leaveRecord.getValidToDate();

									againSameLeaveRecord = true;
									break;
								} else if (jspFromDate.compareTo(leaveRecord
										.getValidFromDate()) <= 0) {
									savedFromDate = leaveRecord
											.getValidFromDate();
									jspFromDateLessThanLeastFromDate = true;
									break;
								}
							} else {
								if (jspFromDate.compareTo(leaveRecord
										.getValidFromDate()) <= 0) {
									savedFromDate = leaveRecord
											.getValidFromDate();
									jspFromDateLessThanLeastFromDate = true;
									break;
								}
							}
						}
					}
				} else {
					insertInFirstPosition = true;
				}
			}

		}
		// Date
		// displayDate=DateFormat.getDateInstance(DateFormat.SHORT).format(currentDate);
		if (!againSameLeaveRecord && !defineAtleastOneForCurrentDate
				&& !jspFromDateLessThanLeastFromDate) {

			if (request.getParameter(TYPE) != null
					&& !request.getParameter(TYPE).trim().equals("")) {
				leaveType = Integer.parseInt(request.getParameter(TYPE));
				hrMasLeave.setId(leaveType);
				hrMasLeaveType.setLeaveType(hrMasLeave);

			}

			if (request.getParameter("halfDayAllow") != null) {
				halfDayAllow = request.getParameter("halfDayAllow");
				hrMasLeaveType.setHalfDayAllow(halfDayAllow);
			} else {
				halfDayAllow = "n";
				hrMasLeaveType.setHalfDayAllow(halfDayAllow);
			}

			if (request.getParameter(MONTHLY_OR_YEARLY) != null) {
				if (request.getParameter(MONTHLY_OR_YEARLY).equals("monthly")) {
					hrMasLeaveType.setMonthlyOrYearly("m");
				} else {
					hrMasLeaveType.setMonthlyOrYearly("y");
				}
			} else {
				hrMasLeaveType.setMonthlyOrYearly("u");
			}

			if (request.getParameter(ALLOWED_DAYS) != null
					&& !request.getParameter(ALLOWED_DAYS).trim().equals("")) {
				// allowedDays =
				// Integer.parseInt(request.getParameter(ALLOWED_DAYS));
				hrMasLeaveType.setAllowedDays(request
						.getParameter(ALLOWED_DAYS));
			}

			if (request.getParameter(ENCHASHMENT_CHECK) != null) {
				encashmentYOrN = request.getParameter(ENCHASHMENT_CHECK);
				hrMasLeaveType.setEncashable(encashmentYOrN);
				if (request.getParameter(ENCHASHMENT) != null
						&& !request.getParameter(ENCHASHMENT).equals("")) {
					encashmentPercentage = Integer.parseInt(request
							.getParameter(ENCHASHMENT));
					hrMasLeaveType.setEncashablePercent(encashmentPercentage);
					hrMasLeaveType.setBufferRequired(0);
				}
				if (request.getParameter("bufferRequired") != null
						&& !request.getParameter("bufferRequired").equals("")) {

					bufferRequired = new Integer(
							request.getParameter("bufferRequired"));
					hrMasLeaveType.setBufferRequired(bufferRequired);
					hrMasLeaveType.setEncashablePercent(0);
				}

			} else {
				encashmentYOrN = "n";
				hrMasLeaveType.setEncashable(encashmentYOrN);
				hrMasLeaveType.setEncashablePercent(0);
			}

			if (request.getParameter(CARRY_FORWARD) != null) {
				carryForward = request.getParameter(CARRY_FORWARD);
				hrMasLeaveType.setCrFrdable(carryForward);
			} else {
				carryForward = "n";
				hrMasLeaveType.setCrFrdable(carryForward);
			}
			if (request.getParameter(RECOMENDED) != null) {
				recommendApprove = request.getParameter(RECOMENDED);
				hrMasLeaveType.setRecommendApprove(recommendApprove);
			} else {
				recommendApprove = "a";
				hrMasLeaveType.setRecommendApprove(recommendApprove);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !request.getParameter(FROM_DATE).trim().equals("")) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				hrMasLeaveType.setValidFromDate(fromDate);
			}
			/*
			 * if(request.getParameter(TO_DATE) != null &&
			 * !request.getParameter(TO_DATE).trim().equals("")){ toDate =
			 * HMSUtil
			 * .convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			 * hrMasLeaveType.setValidToDate(toDate);  }
			 */

			if (insertInFirstPosition) {

				Date hrMasLeaveRecordColumn = (Date)minDateList.get(0);
				Date fromDateMinRecord1 = hrMasLeaveRecordColumn;
				// Date  minDate1=HMSUtil.dateFormatterDDMMYYYY(fromDateMinRecord1);

				Calendar calendar2 = Calendar.getInstance();
				calendar2.setTime(fromDateMinRecord1);
				calendar2.add(Calendar.DAY_OF_MONTH, -1);
				Date toDateForFirstRecord = calendar2.getTime();

				hrMasLeaveType.setValidToDate(toDateForFirstRecord);
			} else {
				hrMasLeaveType.setValidToDate(maxDate);
			}

			if (request.getParameter(REMARKS) != null) {
				remarks = request.getParameter(REMARKS);
				hrMasLeaveType.setRemarks(remarks);
			}
		/*	String lastchangeBy = "";
			if (request.getParameter(CHANGED_BY) != null) {
				lastchangeBy = request.getParameter(CHANGED_BY);
				hrMasLeaveType.setLastChgBy(lastchangeBy);
			}*/
			Users u = new Users();
			u.setId(userId);
			hrMasLeaveType.setLastChgBy(u);
			Date changedDate = null;
			if (request.getParameter(CHANGED_DATE) != null
					&& !(request.getParameter(CHANGED_DATE).equals(""))) {
				changedDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(CHANGED_DATE));
				hrMasLeaveType.setLastChgDate(changedDate);
			}
			String changedTime = "";
			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				changedTime = request.getParameter(CHANGED_TIME);
				hrMasLeaveType.setLastChgTime(changedTime);
			}

			int hospitalId = 0;

			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
			}

			MasHospital company = new MasHospital();
			company.setId(hospitalId);

			hrMasLeaveType.setCompany(company);
			hrMasLeaveType.setStatus("y");

			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(fromDate);
			calendar2.add(Calendar.DAY_OF_MONTH, -1);

			Date toDateInPlaceOfMaxDate = calendar2.getTime();

			if (!insertInFirstPosition) {
				if (hrMasLeaveTypeNewForMaxDate.size() > 0) {
					HrMasLeaveTypeNew hrMasLeaveTypeNew = hrMasLeaveTypeNewForMaxDate
							.get(0);
					hrMasLeaveTypeNew.setValidToDate(toDateInPlaceOfMaxDate);
					leaveHandlerService
							.updateLeaveTypeMasterNew(hrMasLeaveTypeNew);
				}
			}

			leaveHandlerService.submitTypeMasterNew(hrMasLeaveType);

			String message = "Leave Type record added successfully.";

			List<HrMasLeaveTypeNew> hrMasLeaveTypeNewAllList = new ArrayList<HrMasLeaveTypeNew>();
			List<HrMasLeaveTypeNew> hrMasLeaveTypeNewRecords = new ArrayList<HrMasLeaveTypeNew>();

			hrMasLeaveTypeNewAllList = leaveHandlerService
					.getMasLeaveTypeNewList();

			List<HrMasLeaveTypeMediator> hrMasLeaveTypeMediator = new ArrayList<HrMasLeaveTypeMediator>();
			hrMasLeaveTypeMediator = leaveHandlerService
					.getMasLeaveTypeMediatorList();

			boolean newRecordFound = true;
			if (hrMasLeaveTypeMediator.size() > 0) {
				for (HrMasLeaveTypeNew hrMasLeaveTypeNewAll : hrMasLeaveTypeNewAllList) {
					newRecordFound = true;
					for (HrMasLeaveTypeMediator hrMasLeaveTypeMediator2 : hrMasLeaveTypeMediator) {
						if (hrMasLeaveTypeMediator2.getLeaveType()
								.getLeaveType().getId() == hrMasLeaveTypeNewAll
								.getLeaveType().getId()) {
							newRecordFound = false;
							if (hrMasLeaveTypeMediator2.getLeaveType().getId() != hrMasLeaveTypeNewAll
									.getId()) {
								// update mediator link
								// save mediator to history

								hrMasLeaveTypeMediator2
										.setLeaveType(hrMasLeaveTypeNewAll);
								leaveHandlerService
										.updateToHrMasLeaveTypeMediator(hrMasLeaveTypeMediator2);
								break;
							}
						}

					}
					if (newRecordFound) {
						// add to the new record to be added list
						hrMasLeaveTypeNewRecords.add(hrMasLeaveTypeNewAll);
						newRecordFound = true;
					}
				}
			} else {
				// add to the mediator;
				// save mediator to histroy
				System.out.println("hrMasLeaveTypeNewAllList===="+hrMasLeaveTypeNewAllList.size());
				for (HrMasLeaveTypeNew hrMasLeaveTypeNew : hrMasLeaveTypeNewAllList) {
					HrMasLeaveTypeMediator hrMasLeaveTypeMediator2 = new HrMasLeaveTypeMediator();
					System.out.println("hrMasLeaveTypeNewId==="+hrMasLeaveTypeNew.getId());
					hrMasLeaveTypeMediator2.setLeaveType(hrMasLeaveTypeNew);
					leaveHandlerService
							.saveToHrMasLeaveTypeMediator(hrMasLeaveTypeMediator2);
					// add new leave type to employee leave balance table

					employeeList = userMasterHandlerService.getEmployeeList();
					for (MasEmployee employee : employeeList) {
						HrEmployeeBalanceNew employeeBalance = new HrEmployeeBalanceNew();

						employeeBalance.setEmp(employee);
						employeeBalance.setLeaveType(hrMasLeaveTypeMediator2);
						employeeBalance.setOpeningBalance("0");
						employeeBalance.setTaken("0");
						Float currentMonthEarn = 0.0f;
						if (hrMasLeaveTypeMediator2.getLeaveType()
								.getLeaveType().getId() != 3
								|| hrMasLeaveTypeMediator2.getLeaveType()
										.getLeaveType().getId() != 4
								|| hrMasLeaveTypeMediator2.getLeaveType()
										.getLeaveType().getId() != 20) {
							currentMonthEarn = new Float(
									hrMasLeaveType.getAllowedDays());
						} else {
							currentMonthEarn = new Float(
									hrMasLeaveType.getAllowedDays()) / 12;
						}
						employeeBalance.setEarned(new DecimalFormat("0.##")
								.format((double) currentMonthEarn));
						employeeBalance.setClosingBalance(new DecimalFormat(
								"0.##").format((double) currentMonthEarn));
						employeeBalance.setBalanceAdjustedBy("0");
						employeeBalance.setAlreadyAvailedPatMat("n");
						employeeBalance.setTotalLeaveTaken("0");

						employeeBalance.setStatus("y");
						employeeBalance.setLastChgBy(hrMasLeaveType
								.getLastChgBy());
						employeeBalance.setLastChgDate(hrMasLeaveType
								.getLastChgDate());
						employeeBalance.setLastChgTime(hrMasLeaveType
								.getLastChgTime());

						leaveHandlerService
								.saveEmployeeLeaveBalanceNew(employeeBalance);
					}

				}

			}

			if (hrMasLeaveTypeNewRecords.size() > 0) {
				// add all record to mediator
				// save mediator to history
				for (HrMasLeaveTypeNew hrMasLeaveTypeNew : hrMasLeaveTypeNewRecords) {
					HrMasLeaveTypeMediator hrMasLeaveTypeMediator3 = new HrMasLeaveTypeMediator();
					hrMasLeaveTypeMediator3.setLeaveType(hrMasLeaveTypeNew);
					leaveHandlerService
							.saveToHrMasLeaveTypeMediator(hrMasLeaveTypeMediator3);
					// add new leave type to employee leave balance table

					employeeList = userMasterHandlerService.getEmployeeList();
					for (MasEmployee employee : employeeList) {
						HrEmployeeBalanceNew employeeBalance = new HrEmployeeBalanceNew();

						employeeBalance.setEmp(employee);
						employeeBalance.setLeaveType(hrMasLeaveTypeMediator3);
						employeeBalance.setOpeningBalance(hrMasLeaveType
								.getAllowedDays());
						employeeBalance.setTaken("0");
						Float currentMonthEarn = 0.0f;

						if (hrMasLeaveTypeMediator3.getLeaveType()
								.getLeaveType().getId() != 3
								|| hrMasLeaveTypeMediator3.getLeaveType()
										.getLeaveType().getId() != 4
								|| hrMasLeaveTypeMediator3.getLeaveType()
										.getLeaveType().getId() != 20) {
							currentMonthEarn = new Float(
									hrMasLeaveType.getAllowedDays());
						} else {
							if (hrMasLeaveTypeMediator3.getLeaveType()
									.getMonthlyOrYearly().equals("y")) {
								currentMonthEarn = new Float(
										hrMasLeaveType.getAllowedDays()) / 12;
							} else {
								currentMonthEarn = new Float(
										hrMasLeaveType.getAllowedDays());
							}
						}
						employeeBalance.setEarned(new DecimalFormat("0.##")
								.format((double) currentMonthEarn));
						employeeBalance.setClosingBalance(new DecimalFormat(
								"0.##").format((double) currentMonthEarn));
						employeeBalance.setBalanceAdjustedBy("0");
						employeeBalance.setAlreadyAvailedPatMat("n");
						employeeBalance.setTotalLeaveTaken("0");

						employeeBalance.setBalanceAdjustedBy("0");
						employeeBalance.setStatus("y");
						employeeBalance.setLastChgBy(hrMasLeaveType
								.getLastChgBy());
						employeeBalance.setLastChgDate(hrMasLeaveType
								.getLastChgDate());
						employeeBalance.setLastChgTime(hrMasLeaveType
								.getLastChgTime());

						leaveHandlerService
								.saveEmployeeLeaveBalanceNew(employeeBalance);
					}

				}

			}

			List<HrMasLeave> leaveTypeList = leaveHandlerService
					.getLeaveTypeList();

			map.put("masLeaveTypeList", hrMasLeaveTypeNewAllList);
			map.put("leaveTypeList", leaveTypeList);

			map.put("message", message);

			String jsp = SHOW_LEAVE_TYPE_MASTER_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);

		} else {
			String message[] = new String[1];
			if (againSameLeaveRecord) {
				message[0] = "You already have this leave type i.e between "
						+ savedFromDate + " To " + savedToDate
						+ " Please apply again !";
				// "javascript:history.back()",
				// "login?method=validate"
				// };
			}
			if (defineAtleastOneForCurrentDate) {
				message[0] = "Define Atleast one record for current Date";
			}
			if (jspFromDateLessThanLeastFromDate) {

				message[0] = "From Date can't be less than " + savedFromDate;
			}

			List<String> link = new ArrayList<String>();

			link.add("Click Here to add record again ");
			link.add("leave?method=showLeaveTypeMaster");

			map.put("message", message);
			map.put("link", link);

			String jsp = HR_MESSAGE_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);
		}
		// changes
		// map.put(MAIN, "message.jsp");

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView activateInActivateTypeMaster(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HrMasLeaveTypeNew hrMasLeaveType = new HrMasLeaveTypeNew();
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		int leaveMasTypeId = 0;

		if (request.getParameter("leaveTypeId") != null) {
			leaveMasTypeId = Integer.parseInt(request
					.getParameter("leaveTypeId"));
		}

		List<HrMasLeaveTypeNew> leaveTypeForEdit = leaveHandlerService
				.getMasLeaveTypeListForId(leaveMasTypeId);

		List<HrMasLeave> leaveTypeList = leaveHandlerService.getLeaveTypeList();
		List<HrMasLeaveTypeNew> masLeaveTypeList = leaveHandlerService
				.getMasLeaveTypeNewList();

		hrMasLeaveType = leaveTypeForEdit.get(0);
		String status = hrMasLeaveType.getStatus();

		if (status.equals("y")) {
			hrMasLeaveType.setStatus("n");
		} else {
			hrMasLeaveType.setStatus("y");
		}

		leaveHandlerService.updateLeaveTypeMasterNew(hrMasLeaveType);

		leaveTypeForEdit = new ArrayList<HrMasLeaveTypeNew>();

		String message = "Leave Type record updated successfully.";

		map.put("leaveTypeList", leaveTypeList);
		map.put("masLeaveTypeList", masLeaveTypeList);
		map.put("leaveTypeForEdit", leaveTypeForEdit);

		// map.put("link",link);

		String jsp = SHOW_LEAVE_TYPE_MASTER_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);

		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView updateTypeMaster(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();

		HrMasLeaveTypeNew hrMasLeaveType = new HrMasLeaveTypeNew();
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		// List<HrMasLeaveType> hrMasLeaveTypeList = new
		// ArrayList<HrMasLeaveType>();

		List<HrMasLeaveTypeNew> hrMasLeaveTypeNewList = new ArrayList<HrMasLeaveTypeNew>();
		// List<HrMasLeaveType> hrMasLeaveTypeAllRec = new
		// ArrayList<HrMasLeaveType>();

		Date fromDate = null;
		// Date toDate = null;
		int userId=0;
		int leaveType = 0;
		// int allowedDays = 0;
		String encashmentYOrN = "";
		String carryForward = "";
		String recommendApprove=""; 
		int encashmentPercentage = 0;
		int leaveMasTypeId = 0;
		String remarks = "";
		if (session.getAttribute("userId") != null){
			userId = Integer.parseInt(session.getAttribute("userId").toString());
		}			
		Date currentDate = new Date();
		Date jspFromDate = new Date();
		// Date jspToDate = new Date();
		Boolean againSameLeaveRecord = false;
		// Logic for same record

		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			jspFromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
		}

		/*
		 * else if(request.getParameter(FROM_DATE)!=null &&
		 * (request.getParameter(TO_DATE).equals(""))){
		 * jspFromDate=HMSUtil.dateFormatterDDMMYYYY
		 * (request.getParameter(FROM_DATE)); jspToDate=jspFromDate; }
		 */

		if (request.getParameter("leaveTypeIdBaseMas") != null
				&& !request.getParameter("leaveTypeIdBaseMas").trim()
						.equals("")) {
			leaveType = Integer.parseInt(request
					.getParameter("leaveTypeIdBaseMas"));
		}

		// hrMasLeaveTypeList =
		// leaveHandlerService.getMasLeaveTypeList(leaveType);
		hrMasLeaveTypeNewList = leaveHandlerService
				.getMasLeaveTypeNewList(leaveType);

		if (request.getParameter("leaveTypeId") != null) {
			leaveMasTypeId = Integer.parseInt(request
					.getParameter("leaveTypeId"));
		}

		List<HrMasLeaveTypeNew> hrMasLeaveTypeNewForPrevDate = new ArrayList<HrMasLeaveTypeNew>();
		List<HrMasLeaveTypeNew> leaveTypeForEdit = leaveHandlerService
				.getMasLeaveTypeListForId(leaveMasTypeId);
		hrMasLeaveType = leaveTypeForEdit.get(0);

		Date validFromDate = hrMasLeaveType.getValidFromDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(validFromDate);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date prevDate = calendar.getTime();

		hrMasLeaveTypeNewForPrevDate = leaveHandlerService
				.getMasLeaveTypeNewForMaxDate(leaveType, prevDate);

		Date savedToDate = null;
		Date savedFromDate = null;

		Boolean defineAtleastOneForCurrentDate = false;
		Boolean recordOverlappingOwnToDate = false;
		if (jspFromDate.compareTo(hrMasLeaveType.getValidToDate()) > 0) {
			savedToDate = hrMasLeaveType.getValidToDate();
			recordOverlappingOwnToDate = true;
		}
		if (hrMasLeaveTypeNewForPrevDate.size() == 0) {
			if (jspFromDate.compareTo(currentDate) > 0) {
				defineAtleastOneForCurrentDate = true;

			}
		}
		// id from jsp;

		if (request.getParameter(FROM_DATE) != null
				&& !"".equals(request.getParameter(FROM_DATE))
				&& !againSameLeaveRecord) {
			for (HrMasLeaveTypeNew leaveRecord : hrMasLeaveTypeNewList) {
				if (leaveRecord.getValidFromDate() != null) // &&
				// leaveRecord.getId()!=leaveMasTypeId)
				{
					if (leaveRecord.getValidFromDate().compareTo(
							hrMasLeaveType.getValidFromDate()) < 0) {
						if (jspFromDate.compareTo(leaveRecord
								.getValidFromDate()) <= 0) {
							savedFromDate = leaveRecord.getValidFromDate();
							againSameLeaveRecord = true;
							break;
						}
					}
				}
			}
		}

		if (!againSameLeaveRecord && !recordOverlappingOwnToDate
				&& !defineAtleastOneForCurrentDate) {
			// List<HrMasLeaveTypeNew> leaveTypeForEdit =
			// leaveHandlerService.getMasLeaveTypeListForId(leaveMasTypeId);
			// hrMasLeaveType=leaveTypeForEdit.get(0);

			if (request.getParameter(TYPE) != null
					&& !request.getParameter(TYPE).trim().equals("")) {
				leaveType = Integer.parseInt(request.getParameter(TYPE));
				HrMasLeave hrMasLeave = new HrMasLeave();
				hrMasLeave.setId(leaveType);
				hrMasLeaveType.setLeaveType(hrMasLeave);

			}

			if (request.getParameter(ALLOWED_DAYS) != null
					&& !request.getParameter(ALLOWED_DAYS).trim().equals("")) {
				// allowedDays =
				// Integer.parseInt(request.getParameter(ALLOWED_DAYS));
				hrMasLeaveType.setAllowedDays(request
						.getParameter(ALLOWED_DAYS));
			}
			int bufferRequired = 0;
			if (request.getParameter(ENCHASHMENT_CHECK) != null) {
				encashmentYOrN = request.getParameter(ENCHASHMENT_CHECK);
				hrMasLeaveType.setEncashable(encashmentYOrN);
				if (request.getParameter(ENCHASHMENT) != null
						&& !request.getParameter(ENCHASHMENT).equals("")) {
					encashmentPercentage = Integer.parseInt(request
							.getParameter(ENCHASHMENT));
					hrMasLeaveType.setEncashablePercent(encashmentPercentage);
					hrMasLeaveType.setBufferRequired(0);
				}
				if (request.getParameter("bufferRequired") != null
						&& !request.getParameter("bufferRequired").equals("")) {

					bufferRequired = new Integer(
							request.getParameter("bufferRequired"));
					hrMasLeaveType.setBufferRequired(bufferRequired);
					hrMasLeaveType.setEncashablePercent(0);
				}
			} else {
				encashmentYOrN = "n";
				hrMasLeaveType.setEncashable(encashmentYOrN);
			}

			if (request.getParameter(CARRY_FORWARD) != null) {
				carryForward = request.getParameter(CARRY_FORWARD);
				hrMasLeaveType.setCrFrdable(carryForward);
			} else {
				carryForward = "n";
				hrMasLeaveType.setCrFrdable(carryForward);
			}
			if (request.getParameter(RECOMENDED) != null) {
				recommendApprove = request.getParameter(RECOMENDED);
				hrMasLeaveType.setRecommendApprove(recommendApprove);
			} else {
				recommendApprove = "a";
				hrMasLeaveType.setRecommendApprove(recommendApprove);
			}
			String halfDayAllow = "";
			if (request.getParameter("halfDayAllow") != null) {
				halfDayAllow = request.getParameter("halfDayAllow");
				hrMasLeaveType.setHalfDayAllow(halfDayAllow);
			} else {
				halfDayAllow = "n";
				hrMasLeaveType.setHalfDayAllow(halfDayAllow);
			}

			if (request.getParameter(MONTHLY_OR_YEARLY) != null) {
				if (request.getParameter(MONTHLY_OR_YEARLY).equals("monthly")) {
					hrMasLeaveType.setMonthlyOrYearly("m");
				} else {
					hrMasLeaveType.setMonthlyOrYearly("y");
				}
			} else {
				hrMasLeaveType.setMonthlyOrYearly("u");
			}

			if (request.getParameter(FROM_DATE) != null
					&& !request.getParameter(FROM_DATE).trim().equals("")) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				hrMasLeaveType.setValidFromDate(fromDate);
			}

			/*
			 * if(request.getParameter(TO_DATE) != null &&
			 * !request.getParameter(TO_DATE).trim().equals("")){ toDate =
			 * HMSUtil
			 * .convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			 * hrMasLeaveType.setValidToDate(toDate);  }
			 */

			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(jspFromDate);
			calendar2.add(Calendar.DAY_OF_MONTH, -1);

			Date toDateInPlaceOfCurrentToDate = calendar2.getTime();

			if (hrMasLeaveTypeNewForPrevDate.size() > 0) {
				HrMasLeaveTypeNew hrMasLeaveTypeNew = hrMasLeaveTypeNewForPrevDate
						.get(0);
				hrMasLeaveTypeNew.setValidToDate(toDateInPlaceOfCurrentToDate);
				leaveHandlerService.updateLeaveTypeMasterNew(hrMasLeaveTypeNew);
			}

			if (request.getParameter(REMARKS) != null) {
				remarks = request.getParameter(REMARKS);
				hrMasLeaveType.setRemarks(remarks);
			}
			/*String lastchangeBy = "";
			if (request.getParameter(CHANGED_BY) != null) {
				lastchangeBy = request.getParameter(CHANGED_BY);*/
			
				Users u = new Users();
				u.setId(userId);
				hrMasLeaveType.setLastChgBy(u);
			//}
			Date changedDate = null;
			if (request.getParameter(CHANGED_DATE) != null
					&& !(request.getParameter(CHANGED_DATE).equals(""))) {
				changedDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(CHANGED_DATE));
				hrMasLeaveType.setLastChgDate(changedDate);
			}
			String changedTime = "";
			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				changedTime = request.getParameter(CHANGED_TIME);
				hrMasLeaveType.setLastChgTime(changedTime);
			}

			// leaveHandlerService.updateTypeMaster(hrMasLeaveType);
			leaveHandlerService.updateLeaveTypeMasterNew(hrMasLeaveType);

			String message = "Leave Type record updated successfully.";
			// "javascript:history.back()",
			// "login?method=validate"

			map.put("message", message);

			// int leaveMasTypeId = 0;
			// if (request.getParameter("leaveTypeId")!= null ) {
			// leaveMasTypeId =
			// Integer.parseInt(request.getParameter("leaveTypeId"));
			// }

			List<HrMasLeave> leaveTypeList = leaveHandlerService
					.getLeaveTypeList();

			List<HrMasLeaveTypeNew> masLeaveTypeList = leaveHandlerService
					.getMasLeaveTypeNewList();

			List<HrMasLeaveTypeNew> hrMasLeaveTypeNewAllList = new ArrayList<HrMasLeaveTypeNew>();
			List<HrMasLeaveTypeMediator> hrMasLeaveTypeMediator = new ArrayList<HrMasLeaveTypeMediator>();

			hrMasLeaveTypeNewAllList = leaveHandlerService
					.getMasLeaveTypeNewList();
			hrMasLeaveTypeMediator = leaveHandlerService
					.getMasLeaveTypeMediatorList();

			boolean newRecordFound = true;
			if (hrMasLeaveTypeMediator.size() > 0) {
				for (HrMasLeaveTypeNew hrMasLeaveTypeNewAll : hrMasLeaveTypeNewAllList) {
					for (HrMasLeaveTypeMediator hrMasLeaveTypeMediator2 : hrMasLeaveTypeMediator) {
						if (hrMasLeaveTypeMediator2.getLeaveType()
								.getLeaveType().getId() == hrMasLeaveTypeNewAll
								.getLeaveType().getId()) {
							newRecordFound = false;
							if (hrMasLeaveTypeMediator2.getLeaveType().getId() != hrMasLeaveTypeNewAll
									.getId()) {
								// update mediator link
								// save mediator to history

								hrMasLeaveTypeMediator2
										.setLeaveType(hrMasLeaveTypeNewAll);
								leaveHandlerService
										.updateToHrMasLeaveTypeMediator(hrMasLeaveTypeMediator2);

							}
						}

					}
					if (newRecordFound) {
						// add to the new record to be added list
						// hrMasLeaveTypeNewRecords.add(hrMasLeaveTypeNewAll);
						newRecordFound = true;
					}
				}
			} else {
				// add to the mediator;
				// save mediator to histroy
			}

			// if(hrMasLeaveTypeNewRecords.size()>0) {
			// add all record to mediator
			// save mediator to history
			// }

			leaveTypeForEdit = new ArrayList<HrMasLeaveTypeNew>();

			// leaveTypeForEdit =
			// leaveHandlerService.getMasLeaveTypeListForId(leaveMasTypeId);
			// List<String> link=new ArrayList<String>();

			// link.add("Click on the link below to update or to view the
			// records ");
			// link.add("leave?method=showLeaveTypeMaster");

			map.put("leaveTypeList", leaveTypeList);
			map.put("masLeaveTypeList", masLeaveTypeList);
			map.put("leaveTypeForEdit", leaveTypeForEdit);

			// map.put("link",link);

			String jsp = SHOW_LEAVE_TYPE_MASTER_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("message", message);

		} else {

			String message[] = new String[1];

			if (defineAtleastOneForCurrentDate) {
				message[0] = "Define Atleast one record for current Date";
			}
			if (againSameLeaveRecord) {
				message[0] = "Applied From Date can't be Less than or Equal to  "
						+ savedFromDate;
			}
			if (recordOverlappingOwnToDate) {
				message[0] = "Applied From Date can't be greater than "
						+ savedToDate;
			}
			// "javascript:history.back()",
			// "login?method=validate"
			// };
			List<String> link = new ArrayList<String>();

			link.add("Click Here to Try Update again ");
			link.add("leave?method=showLeaveTypeMaster&leaveTypeId="
					+ leaveMasTypeId);

			map.put("message", message);
			map.put("link", link);

			String jsp = HR_MESSAGE_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);

		}

		// changes
		// map.put(MAIN, "message.jsp");

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView encashLeaves(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		// session=request.getSession(true);

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		Users user = (Users) session.getAttribute(USERS);
		MasEmployee employee = user.getEmployee();

		List<HrEmployeeBalanceNew> encashableMasLeaveType = leaveHandlerService
				.getEncashableMasLeaveType(employee.getId());
		List<UserManager> managers = leaveHandlerService.getManager(employee
				.getId());

		map.put("encashableMasLeaveType", encashableMasLeaveType);
		map.put("managers", managers);

		String jsp = ENCASHMENT_LEAVE_FORM;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView applyForEncashment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HrLeaveDetails hrLeaveDetails = new HrLeaveDetails();

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		HrEncashmentDetails encashmentDetails = new HrEncashmentDetails();

		// session=request.getSession(true);
		Users user = (Users) session.getAttribute(USERS);
		MasEmployee employee = user.getEmployee();

		HrMasLeaveTypeMediator leaveType = new HrMasLeaveTypeMediator();
		leaveType.setId(Integer.parseInt(request
				.getParameter("leaveIdForDatabase")));
		encashmentDetails.setLeaveType(leaveType);

		HrEmployeeBalanceNew hrUserLeavebalance = new HrEmployeeBalanceNew();
		hrUserLeavebalance.setId(Integer.parseInt(request
				.getParameter("balanceIdForDatabase")));
		encashmentDetails.setEmpIdBal(hrUserLeavebalance);

		Date currentDate = new Date();

		encashmentDetails.setAppliedOn(currentDate);

		if (request.getParameter(LEAVE_TO_ENCASH) != null
				&& !request.getParameter(LEAVE_TO_ENCASH).equals("")) {
			encashmentDetails.setLeaveToEncash(request
					.getParameter(LEAVE_TO_ENCASH));
		}
		if (request.getParameter(APPROVED_BY) != null
				&& !request.getParameter(APPROVED_BY).equals("")) {
			MasEmployee approvedBy = new MasEmployee();
			approvedBy
					.setId(Integer.parseInt(request.getParameter(APPROVED_BY)));
			encashmentDetails.setApprovedBy(approvedBy);
		}
		encashmentDetails.setReason(request.getParameter(REASON));

		HrMasLeaveStatus leaveStatus = new HrMasLeaveStatus();
		leaveStatus.setId(3);
		encashmentDetails.setLeaveStatus(leaveStatus);

		MasEmployee masEmployee = new MasEmployee();
		masEmployee.setId(employee.getId());
		encashmentDetails.setEmp(masEmployee);

		String lastchangeBy = "";
		if (request.getParameter(CHANGED_BY) != null) {
			lastchangeBy = request.getParameter(CHANGED_BY);
			encashmentDetails.setLastChgBy(lastchangeBy);
		}
		Date changedDate = null;
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
			encashmentDetails.setLastChgDate(changedDate);
		}
		String changedTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			changedTime = request.getParameter(CHANGED_TIME);
			encashmentDetails.setLastChgTime(changedTime);
		}
		encashmentDetails.setStatus("y");

		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);
		encashmentDetails.setCompany(hospital);

		leaveHandlerService.applyForEncashment(encashmentDetails);

		String message = "You have successfully applied for the leave encashment.";
		// "javascript:history.back()"
		// "/jktintranet/jkt/login?method=showPage&jspPage=home"

		map.put("message", message);

		List<HrEmployeeBalance> encashableMasLeaveType = leaveHandlerService
				.getEncashableMasLeaveType(employee.getId());
		List<UserManager> managers = leaveHandlerService.getManager(employee
				.getId());

		map.put("encashableMasLeaveType", encashableMasLeaveType);
		map.put("managers", managers);

		String jsp = ENCASHMENT_LEAVE_FORM;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printEmployeeLeaveCard(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession(false);
		Users user = (Users) session.getAttribute(USERS);
		MasEmployee employee = user.getEmployee();
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			int empId = employee.getId();

			parameters.put("EmpId", empId);

			Map<String, Object> connectionMap = leaveHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("EmpLeaveCard", parameters,
					(Connection) connectionMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public ModelAndView getLeaveListJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		session = request.getSession();
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		Users user = (Users) session.getAttribute(USERS);
		MasEmployee employee = user.getEmployee();

		mapForDs.put("employeeId", employee.getId());

		String halfday = "";
		if (request.getParameter("half") != null
				&& !(request.getParameter("half").equalsIgnoreCase(""))) {
			halfday = (request.getParameter("half"));
			mapForDs.put("halfday", halfday);
		}

		map = leaveHandlerService.getLeaveListJsp(mapForDs);

		String jsp = "hr_leaveTypeList";

		String title = "";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showEmpForDept(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		session = request.getSession();
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		Users user = (Users) session.getAttribute(USERS);
		MasEmployee employee = user.getEmployee();
		mapForDs.put("employeeId", employee.getId());

		Integer departmentId = 0;
		if (request.getParameter(DEPARTMENT_ID) != null
				&& !(request.getParameter(DEPARTMENT_ID).equalsIgnoreCase(""))) {
			departmentId = Integer.parseInt((String) (request
					.getParameter(DEPARTMENT_ID)));
			mapForDs.put("departmentId", departmentId);
		}

		map = leaveHandlerService.showEmpForDept(mapForDs);

		String jsp = HR_EMP_ACC_DEPART;

		String title = "";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView(jsp, "map", map);
	}

	public UserMasterHandlerService getUserMasterHandlerService() {
		return userMasterHandlerService;
	}

	public void setUserMasterHandlerService(
			UserMasterHandlerService userMasterHandlerService) {
		this.userMasterHandlerService = userMasterHandlerService;
	}

	public LeaveDetailsHandlerService getLeaveHandlerService() {
		return leaveHandlerService;
	}

	public void setLeaveHandlerService(
			LeaveDetailsHandlerService leaveHandlerService) {
		this.leaveHandlerService = leaveHandlerService;
	}

	
	
	//Started by Ramdular 14/04/2011 ++++++++++++++++++++++++++++++++++++++
	
	public ModelAndView showLeaveJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map= new HashMap<String, Object>();
		session = request.getSession(true);
		map = leaveHandlerService.showLeaveJsp();
		jsp = LEAVE_JSP;
		jsp += ".jsp";
		title = "Leave";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addLeave(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object> map= new HashMap<String, Object>();
		Date currentDate = new Date(); 
		String description = "";
		int changedBy = 0;
		String currentTime = "";
		int hospitalId=0;
		
		// added by amit das on 04-10-2016
		if(session.getAttribute("userId")!=null){
		  changedBy =(Integer) session.getAttribute("userId");
		   map.put("changedBy", changedBy);
		 }
		
		// added by amit das on 04-10-2016
		if(session.getAttribute(HOSPITAL_ID)!=null){
			hospitalId =(Integer) session.getAttribute(HOSPITAL_ID);
			   map.put("hospitalId", hospitalId);
			 }
		
		if (request.getParameter(DESCRIPTION) != null ) {
			description = request.getParameter(DESCRIPTION);
		}
		
		// commented by amit das on 04-10-2016
		/*if (request.getParameter(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt(request.getParameter(HOSPITAL_ID));
		}*/
		
		// commented by amit das on 04-10-2016
		/*if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}*/
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		HrMasLeave hrMasLeave = new HrMasLeave();
		hrMasLeave.setDescription(description);
		
		MasHospital masHospital= new MasHospital();
		masHospital.setId(hospitalId);
		hrMasLeave.setCompany(masHospital);
		hrMasLeave.setLastChgBy(changedBy);
		hrMasLeave.setLastChgDate(currentDate);
		hrMasLeave.setLastChgTime(currentTime);
		hrMasLeave.setStatus("y");
		
		map = leaveHandlerService.addLeave(hrMasLeave);
		String jsp = LEAVE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView editLeave(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int leaveId = 0;
		String description = "";
		String changedBy ="";
		String changedTime = "";
		Date changedDate = null;
		int hospitalId=0;
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			leaveId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter(DESCRIPTION) != null && !(request.getParameter(DESCRIPTION).equals(""))){
			description = request.getParameter(DESCRIPTION);
		}
		if (request.getParameter(HOSPITAL_ID) != null && !(request.getParameter(DESCRIPTION).equals("0"))) {
			hospitalId = 	Integer.parseInt(request.getParameter(HOSPITAL_ID));
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		generalMap.put("leaveId", leaveId);
		generalMap.put("description", description);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		
	
		Map map1 = leaveHandlerService.editLeave(generalMap);
		
		String message=(String)map1.get("message");
		map=leaveHandlerService.showLeaveJsp();
		String jsp = LEAVE_JSP;
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView deleteLeave(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int leaveId=0;
		String message="";
		String changedTime = "";
		String changedBy = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			leaveId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter("changed_by") != null && !(request.getParameter("changed_by").equals(""))){
			changedBy = request.getParameter("changed_by");
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("leaveId", leaveId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
	
		Map map1 = leaveHandlerService.deleteLeave(generalMap);
		message=(String)map1.get("message");
		map=leaveHandlerService.showLeaveJsp();
		String jsp = LEAVE_JSP;
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
		
	}
	public ModelAndView searchLeave(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();		
		String description  = "";
		if(request.getParameter(DESCRIPTION) != null && !(request.getParameter(DESCRIPTION).equals(""))){
			description = request.getParameter(DESCRIPTION);
		}
		map = leaveHandlerService.searchLeave(description);

		jsp=LEAVE_JSP;
		jsp += ".jsp";
		map.put("search","search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("description",description);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showHolidayMasterJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map= new HashMap<String, Object>();	
		map = leaveHandlerService.showHolidayMasterJsp();
		String jsp = HOLIDAY_MASTER_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
		
	}
	public ModelAndView addHolidayMaster(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map= new HashMap<String, Object>();
		Holidaycalendar holidaycalendar = new Holidaycalendar();
		if(request.getParameter(YEAR)!= null){
			String year = request.getParameter(YEAR); 
			holidaycalendar.setHolidayListYear(year);
		}
		if(request.getParameter(DESCRIPTION)!= null){
			String description = request.getParameter(DESCRIPTION); 
			holidaycalendar.setTitle(description);
		}
		if(request.getParameter(HOLIDAY_DATE)!= null){
			Date holidayDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(HOLIDAY_DATE)); 
			holidaycalendar.setHolidayDate(holidayDate);
		}
		if(request.getParameter(RH)!= null){
			String rh = request.getParameter(RH); 
			holidaycalendar.setRh(rh);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			String changedBy = request.getParameter(CHANGED_BY);
			holidaycalendar.setLastChgBy(changedBy);
		}
		Date changedDate= new Date();
		holidaycalendar.setLastChgDate(changedDate);
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			String changedTime = request.getParameter(CHANGED_TIME);
			holidaycalendar.setLastChgTime(changedTime);
		}
		holidaycalendar.setStatus("y");
		map = leaveHandlerService.addHolidayMaster(holidaycalendar);
		String jsp = HOLIDAY_MASTER_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
		
	}
	public ModelAndView editHolidayMaster(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map= new HashMap<String, Object>();
		Map<String, Object> generalMap= new HashMap<String, Object>();
		if(request.getParameter(HOLIDAY_MASTER_ID)!= null){
			int holidayMasterId = Integer.parseInt(request.getParameter(HOLIDAY_MASTER_ID));
			generalMap.put("holidayMasterId", holidayMasterId);
		}
		if(request.getParameter(YEAR)!= null){
			String year = request.getParameter(YEAR); 
			generalMap.put("year", year);
		}
		if(request.getParameter(DESCRIPTION)!= null){
			String description = request.getParameter(DESCRIPTION); 
			generalMap.put("description", description);
		}
		if(request.getParameter(HOLIDAY_DATE)!= null){
			Date holidayDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(HOLIDAY_DATE)); 
			generalMap.put("holidayDate", holidayDate);
		}
		if(request.getParameter(RH)!= null){
			String rh = request.getParameter(RH); 
			generalMap.put("rh", rh);
		}
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			String changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}
		Date changedDate= new Date();
		generalMap.put("changedDate", changedDate);
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			String changedTime = request.getParameter(CHANGED_TIME);
			generalMap.put("changedTime", changedTime);
		}
		map = leaveHandlerService.editHolidayMaster(generalMap);
		String jsp = HOLIDAY_MASTER_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
		
	}
	public ModelAndView deleteHolidayMaster(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map= new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(HOLIDAY_MASTER_ID)!= null){
			int holidayMasterId = Integer.parseInt(request.getParameter(HOLIDAY_MASTER_ID));
			generalMap.put("holidayMasterId", holidayMasterId);
		}
		
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			String changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}
		Date changedDate= new Date();
		generalMap.put("changedDate", changedDate);
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			String changedTime = request.getParameter(CHANGED_TIME);
			generalMap.put("changedTime", changedTime);
		}
	    map = leaveHandlerService.deleteHolidayMaster(generalMap);
		String jsp = HOLIDAY_MASTER_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
		
	}
	public ModelAndView searchHolidayMaster(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map= new HashMap<String, Object>();
		String name = "";
		if(request.getParameter(DESCRIPTION) != null && !(request.getParameter(DESCRIPTION).equals(""))){
			name = request.getParameter(DESCRIPTION);
		}
		String year = "";
		if(request.getParameter(YEAR) != null && !(request.getParameter(YEAR).equals(""))){
			year = request.getParameter(YEAR);
		}
		int searchRadio=1;
		String searchField= "";
		try{
			if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
				searchField = request.getParameter(SEARCH_FIELD);			}

			if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))){
				searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ;	
				}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(searchRadio==1){
			name=searchField;
			year=null;

		}else{
			name=null;
			year=searchField;
		}
		map = leaveHandlerService.searchHolidayMaster(name,year);
		String jsp = HOLIDAY_MASTER_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("search","search");
		return new ModelAndView("index", "map", map);
		
	}
	 public  long  calculateNoOfDays(String fromDate,String todate){
		  long diff=0;
		  Date date1 =null;
		Date date2 =null;
		  SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		  try {
			  if(null !=fromDate && !fromDate.equals("") && null !=todate && !todate.equals("")){
		     date1 = myFormat.parse(fromDate);
		      date2 = myFormat.parse(todate);
			  }
			  if(null !=date1 && null !=date2)
		       diff = date2.getTime() - date1.getTime();
		      System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		  } catch (ParseException e) {
		      e.printStackTrace();
		  }
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		  
	  }
	 
	 public ModelAndView viewUploadLeaveDocuments(HttpServletRequest request ,HttpServletResponse response) throws SQLException {
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
	    	    
	    	    
	    	    uploadDocuments = leaveHandlerService.getDocumentList(uploadedDocumentId);
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
	    		   System.out.println("uploadDocuments=obj===="+uploadDocuments.size());
	    		   for(UploadDocuments doc: uploadDocuments)
	    		   {
	    			  
	    			   System.out.println("file==="+doc.getFileName());
	    			   System.out.println("doc==="+doc.getPatientDocument());
	    			 
	    			   byte[] bytes =doc.getPatientDocument();
	    			   System.out.println("bytes==="+bytes);
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
}
