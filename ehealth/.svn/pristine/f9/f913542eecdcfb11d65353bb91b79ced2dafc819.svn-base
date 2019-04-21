package jkt.hrms.reports.controller;

import static jkt.hrms.util.HrmsRequestConstants.HR_LOAN_STATEMENT_JSP;

import static jkt.hrms.util.HrmsRequestConstants.DEPARTMENT_ID;
import static jkt.hrms.util.HrmsRequestConstants.EMPLOYEE_ID;
import static jkt.hrms.util.HrmsRequestConstants.HOSPITAL_ID;
import static jkt.hrms.util.HrmsRequestConstants.HR_PAY_SCALE_JSP;
import static jkt.hrms.util.HrmsRequestConstants.SPONSOR_WISE_PROJECT;
import static jkt.hrms.util.HrmsRequestConstants.SPONSOR_ID;
import static jkt.hrms.util.HrmsRequestConstants.PROJECT_PER_RESOURCE;
import static jkt.hrms.util.HrmsRequestConstants.TOTAL_RESOURCE_TIME_PER_PROJECT;
import static jkt.hrms.util.HrmsRequestConstants.RESOURCE_COST_PER_PROJECT;
import static jkt.hrms.util.HrmsRequestConstants.PROJECT_VENDOR_WISE;
import static jkt.hrms.util.HrmsRequestConstants.PROJECT_ID;
import static jkt.hrms.util.HrmsRequestConstants.SITE_VITALS;
import static jkt.hrms.util.HrmsRequestConstants.SITE_STATUS;
import static jkt.hrms.util.HrmsRequestConstants.PATIENT_VISIT_STATUS_PER_PROJECT;
import static jkt.hrms.util.HrmsRequestConstants.PATIENT_STATUS_PER_PROJECT;
import static jkt.hrms.util.HrmsRequestConstants.SITE_CALENDAR;
import static jkt.hrms.util.HrmsRequestConstants.VISIT_MONITORING_STATUS_PER_PROJECT;
import static jkt.hrms.util.HrmsRequestConstants.SITE_PROJECT_WISE;
import static jkt.hrms.util.HrmsRequestConstants.SITE_PI;
import static jkt.hrms.util.HrmsRequestConstants.SITE_ID;
import static jkt.hrms.util.HrmsRequestConstants.EMP_LEAVE_REPORT_JSP;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hrms.util.HrmsRequestConstants.FROM_DATE;
import static jkt.hrms.util.HrmsRequestConstants.TO_DATE;
import static jkt.hrms.util.HrmsRequestConstants.USERS;
import static jkt.hrms.util.HrmsRequestConstants.SITE_PAYMENT_REPORT_JSP;
import static jkt.hrms.util.HrmsRequestConstants.PROJECT_DETAIL_REPORT_JSP;
import static jkt.hrms.util.HrmsRequestConstants.PATIENT_WISE_VISIT_REPORT_JSP;
import static jkt.hrms.util.HrmsRequestConstants.EMP_FOR_DEPART_JSP;
import static jkt.hrms.util.HrmsRequestConstants.PATIENT_ENROLLMENT_JSP;
import static jkt.hrms.util.HrmsRequestConstants.DEPART_FOR_COMPANY_JSP;
import static jkt.hrms.util.HrmsRequestConstants.SITE_PER_PROJECT;
import static jkt.hrms.util.HrmsRequestConstants.DEPARTMENT_RESOURCE_WISE_SITE;
import static jkt.hrms.util.HrmsRequestConstants.PROJECT_WISE_TASK_TIME_COST;
import static jkt.hrms.util.HrmsRequestConstants.DEPARTMENT_PROJECT_SITE_ALLOCATION;
import static jkt.hrms.util.HrmsRequestConstants.PROJECT_TASK_TIME;
import static jkt.hrms.util.HrmsRequestConstants.PROJECT_TASK_TIME_COST;
import static jkt.hrms.util.HrmsRequestConstants.PROJECT_RESOURCE_COST;
import static jkt.hrms.util.HrmsRequestConstants.PROJECT_RESOURCE_TIME;
import static jkt.hrms.util.HrmsRequestConstants.PIREPORT;
import static jkt.hrms.util.HrmsRequestConstants.TASK_ID;
import static jkt.hrms.util.HrmsRequestConstants.HR_EMPLOYEE_LEAVE_TYPE_JSP;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hrms.masters.business.HrMasFinancialYear;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hrms.reports.handler.ReportHandlerService;
import jkt.hrms.util.HrmsRequestConstants;
import jkt.hrms.util.LeaveManagementUtil;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ReportController extends MultiActionController {
	private ReportHandlerService reportHandlerService = null;

	public ReportHandlerService getReportHandlerService() {
		return reportHandlerService;
	}

	public void setReportHandlerService(
			ReportHandlerService reportHandlerService) {
		this.reportHandlerService = reportHandlerService;
	}

	public ModelAndView showPrintHrEmployeeExpirience(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "printHrEmolyeeExpirienceReport.jsp";
		Map<String, Object> map = new HashMap<String, Object>();

		map = reportHandlerService.showPrintHrEmployeeExpirience();
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

 public ModelAndView printEmployeeLeaveCard(HttpServletRequest request,
			HttpServletResponse response) {

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			int empId = Integer.parseInt(request.getParameter("empcode"));
			parameters.put("EmpId", empId);
			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();

			HMSUtil.generateReport("EmpLeaveCard", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
//added by Ramdular from Clinirx 02/02/2011 ++++++++++++++++++++++++++++
	public ModelAndView showEmpExpSummary(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "employeeExperienceSummary.jsp";
		Map<String, Object> map = new HashMap<String, Object>();

		map = reportHandlerService.showEmpExpSummary();
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showEmpServiceCard(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "employeeServiceCard.jsp";
		Map<String, Object> map = new HashMap<String, Object>();

		map = reportHandlerService.showEmpServiceCard();
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showEmployeeWiseTaskList(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map= reportHandlerService.showEmployeeWiseTaskList();
		String jsp = "employeeWiseTaskList";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printEmployeeWiseTaskListReport(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map parameters = new HashMap();
		HttpSession session = request.getSession();
		try {
			String querySql = "";
			boolean status = false;
			int departmentId = 0;
			
			if(request.getParameter("empstatus")!= null ){
				 status = true;
				 querySql = "where mas_employee.employee_status_id = 1 ";
			}
			else{
					status = false;
				 querySql = "where mas_employee.employee_status_id <> 0 ";
			}
			if(!request.getParameter(DEPARTMENT_ID).equals("0") ){
				departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
				querySql = querySql + " and  mas_department.department_id = " + departmentId  ;
			}
			
			int employeeId = 0;
			if(!request.getParameter(EMPLOYEE_ID).equals("0") ){
				employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
					querySql = querySql + " and mas_employee.employee_id = "+employeeId;
				
			}
		//	parameters.put("departmentId", departmentId);
			parameters.put("employeeId", employeeId);
			parameters.put("querySql", querySql);
	
			/*Map<String, Object> connectionMap = reportHandlerService.getConnectionForReport();
			HMSUtil.generateReport("employeeWiseTask", parameters,(Connection) connectionMap.get("conn"), response,getServletContext());*/
			
			Map<String, Object> connectionMap = reportHandlerService.getConnectionForReport();
			HMSUtil.generateReport("employeeWiseTask", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
				} catch (Exception e) {
		e.printStackTrace();
	}
		return null;		
	}
	public ModelAndView showRoleWiseTaskList(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map= reportHandlerService.showRoleWiseTaskList();
		String jsp = "roleWiseTaskList";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}	
	public ModelAndView printRoleWiseTaskListReport(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map parameters = new HashMap();
		HttpSession session = request.getSession();
		
		String querySql = "";
		boolean status = false;
		int departmentId = 0;
		
		try {
			querySql = "Where mstr_role_task_map.status = 'y' ";
			
			if(!request.getParameter(DEPARTMENT_ID).equals("0") ){
				departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
				querySql = querySql + " and   mstr_role_task_map.department_id = " + departmentId  ;
			}
			int roleId = 0;
			if(!request.getParameter("roleId").equals("0") ){
				roleId = Integer.parseInt(request.getParameter("roleId"));
					querySql = querySql + " and mstr_role_task_map.rank_id = "+roleId;
				
			}
			parameters.put("querySql", querySql);
					
			//parameters.put("departmentId", departmentId);
			// parameters.put("roleId", roleId);
			
			Map<String, Object> connectionMap = reportHandlerService.getConnectionForReport();
			HMSUtil.generateReport("roleWiseTaskReport", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
			/*Map<String, Object> connectionMap = reportHandlerService.getConnectionForReport();
			HMSUtil.generateReport("roleWiseTaskReport", parameters,(Connection) connectionMap.get("conn"), response,getServletContext());*/
		} catch (Exception e) {
		e.printStackTrace();
	}
		return null;		
	}
	public ModelAndView showEmpPerformanceReviewCard(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "employeePerformanceReview.jsp";
		Map<String, Object> map = new HashMap<String, Object>();

		map = reportHandlerService.showEmpPerformanceReviewCard();
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printEmpPerformanceReviewCard(
			HttpServletRequest request, HttpServletResponse response) {

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		Integer fromEmpCode = 0;

		try {
			if (request.getParameter("frmEmpCode") != null
					&& !request.getParameter("frmEmpCode").equals(0)) {
				fromEmpCode = Integer.parseInt(request
						.getParameter("frmEmpCode"));
			}
			parameters.put("empID", fromEmpCode);
			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("emp_performance_review", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public ModelAndView showEmployeeListReport(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map= reportHandlerService.showEmployeeListReport();
		String jsp = "employeeListReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printEmployeeListReport(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map parameters = new HashMap();
		HttpSession session = request.getSession();
		try {
			int hospitalId = 0;
			int departmentId = 0;
			String querySql = "";
			String reportName = "";
			// String status = false;
			
			if(!request.getParameter(HOSPITAL_ID).equals("0") ){
				hospitalId = Integer.parseInt(request.getParameter(HOSPITAL_ID));
				querySql = "Where mas_hospital.hospital_id = " + hospitalId;
			}
			
			if(!request.getParameter(DEPARTMENT_ID).equals("0") ){
				departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
				querySql = querySql + " and mas_department.department_id = "+departmentId;
				
			}
			
			if(request.getParameter("workingStatus") != null ){
				querySql = querySql + " and mas_employee.`status` = 'y' and mas_employee.`employee_status_id` = 1";
				
			}
			if(request.getParameter("dateWise") != null ){
				reportName = "employeeListJoinDate";
			}
			else{
				reportName = "employeeList";
			}
				
			parameters.put("departmentId", departmentId);
			parameters.put("hospitalId", hospitalId);
			parameters.put("querySql", querySql);
	
		//	Map<String, Object> connectionMap = reportHandlerService.getConnectionForReport();
		//	HMSUtil.generateReport(reportName, parameters,(Connection) connectionMap.get("conn"), response,getServletContext());
			
			Map<String, Object> connectionMap = reportHandlerService.getConnectionForReport();
			HMSUtil.generateReport(reportName, parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
		e.printStackTrace();
	}
			
		return null;
	}
	public ModelAndView showEmpSalaryComp(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "employeeSallaryComparison.jsp";
		Map<String, Object> map = new HashMap<String, Object>();

		map = reportHandlerService.showEmpSalaryComp();
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printEmpSalComp(HttpServletRequest request,
			HttpServletResponse response) {

		Map parameters = new HashMap();
		Integer year1 = 0;
		Integer year2 = 0;
		Integer month1 = 0;
		Integer month2 = 0;
		Integer departmentID = 0;
		Map<String, Object> map = new HashMap();
		Map<String, Object> mapForDs = new HashMap();
		HttpSession session = request.getSession();

		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			mapForDs.put("hospitalId", hospitalId);
		}

		try {
			if (request.getParameter("department") != null
					&& !request.getParameter("department").equals(0)) {
				departmentID = Integer.parseInt(request
						.getParameter("department"));
			}
			if (request.getParameter("period1") != null) {
				Date d = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter("period1"));
				year1 = d.getYear();
			}
			if (request.getParameter("period2") != null) {
				Date d = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter("period2"));
				year2 = d.getYear();
			}
			if (request.getParameter("period1") != null) {
				Date d = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter("period1"));
				month1 = d.getMonth();
			}
			if (request.getParameter("period2") != null) {
				Date d = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter("period2"));
				month2 = d.getMonth();
			}
			year1 = year1 + 1900;
			year2 = year2 + 1900;
			month1 = month1 + 1;
			month2 = month2 + 1;
			List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
			String companyname = "";
			map = reportHandlerService.getHospitalName(mapForDs);
			if(map.get("masHospitalList") != null){
				masHospitalList = (List)map.get("masHospitalList");
			}
			if(masHospitalList.size() > 0){
				companyname = masHospitalList.get(0).getHospitalName();
			}

			parameters.put("companyname", companyname);
			parameters.put("departmentID", departmentID);
			parameters.put("year1", year1);
			parameters.put("year2", year2);
			parameters.put("month1", month1);
			parameters.put("month2", month2);

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("EmpSalaryComp", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public ModelAndView showEmployeeTypeReport(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "employeeTypeWiseReport.jsp";
		Map<String, Object> map = new HashMap<String, Object>();

		map = reportHandlerService.showEmployeeTypeReport();
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printEmployeeTypeWiseReport(HttpServletRequest request,
			HttpServletResponse response) {

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		Integer empType = 0;

		try {
			if (request.getParameter("empType") != null
					&& !request.getParameter("empType").equals(0)) {
				empType = Integer.parseInt(request.getParameter("empType"));
			}

			parameters.put("empTypeId", empType);

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("appointment_wise_employee_report",
					parameters, (Connection) connectionMap.get("conn"),
					response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public ModelAndView showTDSStatement(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "tdsStatement.jsp";
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showTDSStatement();
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printTDSStatement(HttpServletRequest request,
			HttpServletResponse response) {

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		int f_year = 0;
		int month = 0;
		String monthStr = "";
		String myMonth[] = { "January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October", "November",
				"December" };
		try {
			if (request.getParameter("invYear") != null
					&& request.getParameter("invYear") != "") {
				f_year = Integer.parseInt(request.getParameter("invYear"));
			}

			if (request.getParameter("month") != null
					&& request.getParameter("month") != "") {
				month = Integer.parseInt(request.getParameter("month"));
			}

			monthStr = myMonth[month];


			parameters.put("year", f_year);
			parameters.put("monthInt", month);
			parameters.put("monthStr", monthStr);

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("TDSStatement", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment;filename="
				+ "TDS Statement");

		return null;

	}
	
	public ModelAndView showIncomeTaxSheet(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "incomeTaxSheet.jsp";
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showIncomeTaxSheet();
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printIncomeTaxSheet(HttpServletRequest request,
			HttpServletResponse response) {

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasFinancialYear> hrMasFinancialYearList = new ArrayList<HrMasFinancialYear>();
		String querySql = "";
		int year = 0;
		int emp_id = 0;
		Date fDate = null; 
		Date tDate = null;
		try {
			
			if (!request.getParameter("invYear").equals("0") 
					&& request.getParameter("invYear") != null) {
				year = Integer.parseInt(request.getParameter("invYear"));
				map = reportHandlerService.getFinancialYearDate(year);
				// querySql = "Where hr_payroll_process_header.`year` = "+ year;
				if(map.get("hrMasFinancialYearList") != null){
					hrMasFinancialYearList = (List)map.get("hrMasFinancialYearList");
				}
				
				if(hrMasFinancialYearList.size() > 0){
					fDate = hrMasFinancialYearList.get(0).getYearFromDate();
					tDate = hrMasFinancialYearList.get(0).getYearToDate();
				
				//querySql  = "Where hr_payroll_process_header.last_chg_date between '" +fDate +"' and '" +tDate +"' ";
				}
			}

			if (!request.getParameter("empcode").equals("0")
					&& request.getParameter("empcode") != null) {
				emp_id = Integer.parseInt(request.getParameter("empcode"));
			//querySql = querySql + " and  mas_employee.`employee_id` = "+ emp_id;
			}

			parameters.put("tDate", tDate);
			parameters.put("fDate", fDate);
			parameters.put("emp_id", emp_id);
			parameters.put("year", year);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
					"//Reports//"));

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("ITSheet", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Income Tax Sheet");

		return null;

	}
	public ModelAndView showCompanyHoliday(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "companyHoliday.jsp";
		Map<String, Object> map = new HashMap<String, Object>();

		// map=reportHandlerService.showPrintHrEmployeeExpirience();

		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printCompanyHoliday(HttpServletRequest request,
			HttpServletResponse response) {

		Map parameters = new HashMap();
		Map<String, Object> map = new HashMap();
		Map<String, Object> mapForDs = new HashMap();
		HttpSession session = request.getSession();
		
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			mapForDs.put("hospitalId", hospitalId);
		}

		Integer year = 0;
		try {
			if (request.getParameter("year") != null
					&& !request.getParameter("year").equals(0)) {
				year = Integer.parseInt(request.getParameter("year"));
			}
			
			parameters.put("holidayYear", year);
			List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
			String companyname = "";

			map = reportHandlerService.getHospitalName(mapForDs);
			if(map.get("masHospitalList") != null){
				masHospitalList = (List)map.get("masHospitalList");
			}
			if(masHospitalList.size() > 0){
				companyname = masHospitalList.get(0).getHospitalName();
			}
			parameters.put("companyname", companyname);
			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("HolidayList", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
			response.setHeader("Content-Disposition", "inline; filename="+"HolidayList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView showEmployeeLeaveTypeReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showEmployeeLeaveTypeReport();
		String jsp = HR_EMPLOYEE_LEAVE_TYPE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printEmployeeLeaveType(HttpServletRequest request,
			HttpServletResponse response) {
		String qry = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			mapForDs.put("hospitalId", hospitalId);
		}

		try {
			String empcode = "";
			if (!request.getParameter("empcode").equals("")) {
				empcode = request.getParameter("empcode");
				qry += " where main.employee_code = '" + empcode + "'";
			}
			if (request.getParameter(RequestConstants.FROM_DATE) != null
					&& !request.getParameter(RequestConstants.FROM_DATE)
							.equals("")) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.FROM_DATE));
			}
			if (request.getParameter(RequestConstants.TO_DATE) != null
					&& !request.getParameter(RequestConstants.TO_DATE).equals(
							"")) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.TO_DATE));
			}
			List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
			String companyname = "";
			map = reportHandlerService.getHospitalName(mapForDs);
			if(map.get("masHospitalList") != null){
				masHospitalList = (List)map.get("masHospitalList");
			}
			if(masHospitalList.size() > 0){
				companyname = masHospitalList.get(0).getHospitalName();
			}

			parameters.put("companyname", companyname);
			parameters.put("fromdate", fromDate);
			parameters.put("todate", toDate);
			parameters.put("paraempcode", qry);
			// parameters.put("fromDate", fromDate);
			// parameters.put("toDate", toDate);
			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("EmployeeLeaveType", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

 
	public ModelAndView printEmployeeExpirience(HttpServletRequest request,
			HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("hr_employee_experience_report", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public ModelAndView showPrintReimbursement(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "printReimbursement.jsp";
		Map<String, Object> map = new HashMap<String, Object>();

		map = reportHandlerService.showPrintHrEmployeeExpirience();
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printReimbursement(HttpServletRequest request,
			HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			// int empId=Integer.parseInt(request.getParameter("empId"));

			// parameters.put("EmpId", empId);
			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("ReimbursementReport", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public ModelAndView showPrintLeaveStatement(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "LeaveStatement.jsp";
		Map<String, Object> map = new HashMap<String, Object>();

		map = reportHandlerService.showPrintLeaveStatement();
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printLeaveStatement(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			mapForDs.put("hospitalId", hospitalId);
		}
		try {
			int empid1 = 0;
			if(request.getParameter("empcode1")!=null && request.getParameter("empcode1")!=""){
				empid1=Integer.parseInt(request.getParameter("empcode1"));
			}
			int empid2 = 0;
			if(request.getParameter("empcode2")!=null && request.getParameter("empcode2")!=""){
				empid2=Integer.parseInt(request.getParameter("empcode2"));
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date1 = "";
			String date2 = "";
			try {
				date1 = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter("fromDate")));
				date2 = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter("toDate")));
			} catch (Exception e) {
				e.printStackTrace();
			}
			List<MasEmployee> employeeListFirstEmp = new ArrayList<MasEmployee>();
			List<MasEmployee> employeeListSecondEmp = new ArrayList<MasEmployee>();
			mapForDs.put("fromEmpCode", empid1);
			mapForDs.put("toEmpCode", empid2);
			
			map = reportHandlerService.getEmpCodeSelectedEmployees(mapForDs);
			String empCodeFirst = "";
			String empCodeSecond = "";
			
			if(map.get("employeeListFirstEmp") != null){
				employeeListFirstEmp = (List)map.get("employeeListFirstEmp");
				if(employeeListFirstEmp.size()>0){
				empCodeFirst = employeeListFirstEmp.get(0).getEmployeeCode();
				}
			}
			if(map.get("employeeListSecondEmp") != null){
				employeeListSecondEmp = (List)map.get("employeeListSecondEmp");
				if(employeeListSecondEmp.size()>0){
				empCodeSecond = employeeListSecondEmp.get(0).getEmployeeCode();
				}
			}

			int leave = Integer.parseInt(request.getParameter("leavetype"));
			List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
			String companyname = "";
			map = reportHandlerService.getHospitalName(mapForDs);
			if(map.get("masHospitalList") != null){
				masHospitalList = (List)map.get("masHospitalList");
			}
			if(masHospitalList.size() > 0){
				companyname = masHospitalList.get(0).getHospitalName();
			}

			parameters.put("companyname", companyname);
			parameters.put("empid1", empid1);
			parameters.put("empid2", empid2);
			parameters.put("empCodeFirst", empCodeFirst);
			parameters.put("empCodeSecond", empCodeSecond);
			parameters.put("date1", date1);
			parameters.put("date2", date2);
			parameters.put("leave", leave);

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("LeaveStatement", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public ModelAndView showloanstatement(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showloanstatement();
		String jsp = HR_LOAN_STATEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView printloanstatement(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int fromEmpCode = 0;
		int departmentId = 0;
		String querySql = "";
		if(! request.getParameter("department").equals("0")){
			departmentId = Integer.parseInt(request.getParameter("department"));
			querySql = querySql + " WHERE mas_department.department_id = "+ departmentId;
		}
		if (!request.getParameter("fromempcode").equals("0")) {
			fromEmpCode = Integer.parseInt(request.getParameter("fromempcode"));
			querySql = querySql + " AND   mas_employee.employee_id = "+fromEmpCode;
		}
		detailsMap = reportHandlerService.getConnectionForReport();
	//	parameters.put("fromEmpCode", fromEmpCode);
		//parameters.put("departmentId", departmentId);
		parameters.put("querySql", querySql);
		//parameters.put("toEmpCode", toEmpCode);

		HMSUtil.generateReport("loanstatment", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView showpayscale(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showpayscale();
		String jsp = HR_PAY_SCALE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printpayscale(HttpServletRequest request,
		HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		int fromEmpId = 0;
		int toEmpId = 0;
		int departmentId = 0;
		String querySql = "";
		
		if (!request.getParameter("department").equals("0")) {
			departmentId = Integer.parseInt(request.getParameter("department"));
			querySql = "Where mas_employee.`department_id` = "+departmentId;
		}
		if (!request.getParameter("toEmpCode").equals("0") && !request.getParameter("fromEmpCode").equals("0")) {
			fromEmpId = Integer.parseInt(request.getParameter("fromEmpCode"));
			toEmpId = Integer.parseInt(request.getParameter("toEmpCode"));
			if (!request.getParameter("department").equals("0")) {
				departmentId = Integer.parseInt(request.getParameter("department"));
				querySql = querySql + " and  mas_employee.`employee_id` Between "+ fromEmpId + " and " +  toEmpId;
			}
			else{
				querySql = " where  mas_employee.`employee_id` Between "+ fromEmpId + " and " +  toEmpId;
			}
				
			
		}
		

		
		detailsMap = reportHandlerService.getConnectionForReport();

		parameters.put("querySql", querySql);
		//parameters.put("toEmpId", toEmpId);
				
		HMSUtil.generateReport("payscale", parameters, (Connection) detailsMap
				.get("conn"), response, getServletContext());
		return null;
	}

	public ModelAndView showEmployeeLeaveStatus(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "employeeLeaveStatus.jsp";
		Map<String, Object> map = new HashMap<String, Object>();

		map = reportHandlerService.showPrintLeaveStatement();
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printEmployeeLeaveStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map <String, Object> mapForDs= new HashMap<String, Object>();
		Map <String, Object> map= new HashMap<String, Object>();

		try {
			int pen1 = 0;
			if(request.getParameter("pen1")!=null && request.getParameter("pen1")!=""){
				pen1=Integer.parseInt(request.getParameter("pen1"));
			}
			int pen2 = 0;
			if(request.getParameter("pen2")!=null && request.getParameter("pen2")!=""){
				pen2=Integer.parseInt(request.getParameter("pen2"));
			}
			List<MasEmployee> employeeListFirstEmp = new ArrayList<MasEmployee>();
			List<MasEmployee> employeeListSecondEmp = new ArrayList<MasEmployee>();

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String formattedDate = sdf.format(new Date());
			
			mapForDs.put("frompen", pen1);
			mapForDs.put("topen", pen2);
			
			map = reportHandlerService.getEmpCodeSelectedEmployees(mapForDs);
			String penFirst = "";
			String penSecond = "";
			
			if(map.get("employeeListFirstEmp") != null){
				employeeListFirstEmp = (List)map.get("employeeListFirstEmp");
				if(employeeListFirstEmp.size()>0){
				penFirst = employeeListFirstEmp.get(0).getPEN();
				}
			}
			if(map.get("employeeListSecondEmp") != null){
				employeeListSecondEmp = (List)map.get("employeeListSecondEmp");
				if(employeeListSecondEmp.size()>0){
				penSecond = employeeListSecondEmp.get(0).getPEN();
				}
			}
			String subHeadingReport = "Employee Leave Status as on " + formattedDate;

			parameters.put("subHeadingReport", subHeadingReport);
			parameters.put("penFirst", penFirst);
			parameters.put("penSecond", penSecond);

			parameters.put("pen1", pen1);
			parameters.put("pen2", pen2);

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("LeaveStatus", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public ModelAndView showEmployeeLeaveCard(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "printEmployeeLeaveCard.jsp";
		Map<String, Object> map = new HashMap<String, Object>();

		map = reportHandlerService.showEmployeeLeaveCard();
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

 

	public ModelAndView generateReportForRecruitmentRequisition(
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		Map map = (Map) session.getAttribute("mapresourceRequisition");
		List<MasEmployee> searchresourceRequisitionList = new ArrayList<MasEmployee>();
		if (map.get("searchresourceRequisitionList") != null) {
			searchresourceRequisitionList = (List) map
					.get("searchresourceRequisitionList");
		}

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		try {
			JasperReport jasperReport = HMSUtil.getCompiledReport(context,
					"manpowerRequisitions");
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(
					searchresourceRequisitionList);
			bytes = JasperRunManager.runReportToPdf(jasperReport, parameters,
					ds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String fileName = "manPowerRequisition_" + new Date();
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ fileName);

		int b = bytes.length;
		response.setContentLength(b);
		try {
			ServletOutputStream ouputStream = response.getOutputStream();

			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public ModelAndView showEmployeeList(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "EmployeeList.jsp";
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showEmployeeList();
		map.put("contentJsp", jsp);
		Integer i = 0;

		Calendar c = Calendar.getInstance();

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printEmployeeList(HttpServletRequest request,
			HttpServletResponse response) {

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		// Map parameters = new HashMap();
		Map<String, Object> parameters = new HashMap();

		try {
			String query = "Where mas_employee.status = 'y' ";

			if ((request.getParameter(EMPLOYEE_ID) != null)
					&& !(request.getParameter(EMPLOYEE_ID).equals("0"))) {
				Integer EmpId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
				query = query + " and  mas_employee.employee_id = " + EmpId;
			}

			if ((request.getParameter(DEPARTMENT_ID) != null)
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				Integer Dept = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
				query = query + " and mas_employee.department_id = " + Dept;
			}

			if ((request.getParameter("DesignationId") != null)
					&& !(request.getParameter("DesignationId").equals("0"))) {
				Integer DesignationId = Integer.parseInt(request
						.getParameter("DesignationId"));
				query = query + " and mas_employee.rank_id = " + DesignationId;
			}

			if ((request.getParameter("LocationId") != null)
					&& !(request.getParameter("LocationId").equals("0"))) {
				Integer LocationId = Integer.parseInt(request
						.getParameter("LocationId"));
				query = query + " and  mas_employee.location_id = "
						+ LocationId;
			}

			parameters.put("query", query);

			/*
			 * parameters.put("EmpId", EmpId); parameters.put("Dept",Dept);
			 * parameters.put("DesignationId",DesignationId);
			 * parameters.put("LocationId", LocationId);
			 */

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("mas_employee_report", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView showTimeSheetTaskWiseJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map map = new HashMap();
		map = reportHandlerService.showTimeSheetTaskWiseJsp();
		String jsp = "timeSheetTaskWise";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		// map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showTimeSheetProjectWiseJsp(HttpServletRequest request,HttpServletResponse response) {

		Map map = new HashMap();
		HttpSession session = request.getSession(true);
		int employeeId = 0;
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		 employeeId = users.getEmployee().getId();
		}
		
		map = reportHandlerService.showTimeSheetProjectWiseJsp(employeeId);
		String jsp = "timeSheetProjectwise";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		// map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getTasks(HttpServletRequest request,
			HttpServletResponse response) {
		Integer projectId = new Integer(request.getParameter("projectId"));

	//	List taskList = reportHandlerService.getTaskList(projectId);

		Map map = new HashMap();
	//	map.put("taskList", taskList);

		String jsp = "responseForTaskList";
		map.put("jsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView printTimeSheetProjectWiseReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		int projectId = 0;
		Date fromDate = null;
		Date toDate = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			mapForDs.put("hospitalId", hospitalId);
		}

		try {
			if (request.getParameter("prj_Id") != null) {
				projectId = Integer.parseInt(request.getParameter("prj_Id"));
			}

			if (request.getParameter("fromDate") != null) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter("fromDate"));
			}

			if (request.getParameter("toDate") != null) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter("toDate"));
			}
			List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
			String companyname = "";
			map = reportHandlerService.getHospitalName(mapForDs);
			if(map.get("masHospitalList") != null){
				masHospitalList = (List)map.get("masHospitalList");
			}
			if(masHospitalList.size() > 0){
				companyname = masHospitalList.get(0).getHospitalName();
			}

			parameters.put("companyname", companyname);
			parameters.put("ProjectId", projectId);
			parameters.put("StartDate", fromDate);
			parameters.put("EndDate", toDate);

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();

			HMSUtil.generateReport("ProjectWiseTimeSheet", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView exportToExcelTimeSheetProjectWiseReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map parameters = new HashMap();
		int projectId = 0;
		Date fromDate = null;
		Date toDate = null;
		Map<String, Object> map = new HashMap();
		Map<String, Object> mapForDs = new HashMap();
		HttpSession session = request.getSession();

		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			mapForDs.put("hospitalId", hospitalId);
		}

		try {
			if (request.getParameter("prj_Id") != null) {
				projectId = Integer.parseInt(request.getParameter("prj_Id"));
			}

			if (request.getParameter("fromDate") != null) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter("fromDate"));
			}

			if (request.getParameter("toDate") != null) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter("toDate"));
			}
			List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
			String companyname = "";
			map = reportHandlerService.getHospitalName(mapForDs);
			if(map.get("masHospitalList") != null){
				masHospitalList = (List)map.get("masHospitalList");
			}
			if(masHospitalList.size() > 0){
				companyname = masHospitalList.get(0).getHospitalName();
			}

			parameters.put("companyname", companyname);
			parameters.put("ProjectId", projectId);
			parameters.put("StartDate", fromDate);
			parameters.put("EndDate", toDate);

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("ProjectWiseTimeSheet", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printTimeSheetTaskWiseReport(
			HttpServletRequest request, HttpServletResponse response) {

		int projectId = 0;
		int taskId = 0;
		Date fromDate = null;
		Date toDate = null;
		HttpSession session = request.getSession();

		Map<String, Object> parameters = new HashMap();
		Map<String, Object> map = new HashMap();
		Map<String, Object> mapForDs = new HashMap();
		String sqlQuery = "";
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			mapForDs.put("hospitalId", hospitalId);
		}

		try {
			if (request.getParameter("prj_Id") != null) {
				projectId = Integer.parseInt(request.getParameter("prj_Id"));
			}
			if (request.getParameter(TASK_ID) != null&& !request.getParameter(TASK_ID).equals("")) {
				taskId = Integer.parseInt(request.getParameter(TASK_ID));
				//sqlQuery = "where mstr_task.`task_id` ="+ taskId;
			}
			if (request.getParameter("fromDate") != null) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter("fromDate"));
			}

			if (request.getParameter("toDate") != null) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter("toDate"));
			}
			List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
			String companyname = "";
			map = reportHandlerService.getHospitalName(mapForDs);
			if(map.get("masHospitalList") != null){
				masHospitalList = (List)map.get("masHospitalList");
			}
			if(masHospitalList.size() > 0){
				companyname = masHospitalList.get(0).getHospitalName();
			}
			parameters.put("companyname", companyname);
			parameters.put("ProjectId", projectId);
			parameters.put("TaskId", taskId);
			parameters.put("StartDate", fromDate);
			parameters.put("EndDate", toDate);

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("TaskWiseTimeSheet", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView exportToExcelTimeSheetTaskWiseReport(
			HttpServletRequest request, HttpServletResponse response) {

		int projectId = 0;
		int taskId = 0;
		Date fromDate = null;
		Date toDate = null;
		HttpSession session = request.getSession();

		Map<String, Object> parameters = new HashMap();
		Map<String, Object> map = new HashMap();
		Map<String, Object> mapForDs = new HashMap();

		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			mapForDs.put("hospitalId", hospitalId);
		}

		try {
			if (request.getParameter("prj_Id") != null) {
				projectId = Integer.parseInt(request.getParameter("prj_Id"));
			}
			if (request.getParameter(TASK_ID) != null
					&& !request.getParameter(TASK_ID).equals("")) {
				taskId = Integer.parseInt(request.getParameter(TASK_ID));
			}
			if (request.getParameter("fromDate") != null) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter("fromDate"));
			}

			if (request.getParameter("toDate") != null) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter("toDate"));
			}
			List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
			String companyname = "";
			map = reportHandlerService.getHospitalName(mapForDs);
			if(map.get("masHospitalList") != null){
				masHospitalList = (List)map.get("masHospitalList");
			}
			if(masHospitalList.size() > 0){
				companyname = masHospitalList.get(0).getHospitalName();
			}
			parameters.put("companyname", companyname);
			parameters.put("ProjectId", projectId);
			parameters.put("TaskId", taskId);
			parameters.put("StartDate", fromDate);
			parameters.put("EndDate", toDate);

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("TaskWiseTimeSheet", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	 
	public ModelAndView printEmpExpSummary(HttpServletRequest request,
			HttpServletResponse response) {

		Map <String, Object>parameters = new HashMap<String, Object>();
		Map <String, Object> mapForDs= new HashMap<String, Object>();
		Map <String, Object> map= new HashMap<String, Object>();
		
		Integer fromEmpCode = 0;
		Integer toEmpCode = 0;
		int departmentId = 0;
		int locationId = 0;
		String query = "";
		
		List<MasEmployee> employeeListFirstEmp = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeListSecondEmp = new ArrayList<MasEmployee>();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		try {
			if (request.getParameter("frmEmpCode") != null
					&& !request.getParameter("frmEmpCode").equals(0)) {
				fromEmpCode = Integer.parseInt(request
						.getParameter("frmEmpCode"));
			}
			if (request.getParameter("toEmpCode") != null
					&& !request.getParameter("toEmpCode").equals(0)) {
				toEmpCode = Integer.parseInt(request.getParameter("toEmpCode"));
			}
			if (request.getParameter(RequestConstants.DEPARTMENT_ID) != null
					&& !request.getParameter(RequestConstants.DEPARTMENT_ID).equals("")) {
				departmentId = Integer.parseInt(request.getParameter(RequestConstants.DEPARTMENT_ID));
				query = " and mas_employee.`department_id` =" + departmentId;
			}
			if (request.getParameter(RequestConstants.LOCATION) != null
					&& !request.getParameter(RequestConstants.LOCATION).equals("")) {
				locationId = Integer.parseInt(request.getParameter(RequestConstants.LOCATION));
					query += " and mas_employee.`location_id` =" + locationId;	
			}

			mapForDs.put("fromEmpCode", fromEmpCode);
			mapForDs.put("toEmpCode", toEmpCode);
			
			map = reportHandlerService.getEmpCodeSelectedEmployees(mapForDs);
			String empCodeFirst = "";
			String empCodeSecond = "";
			
			if(map.get("employeeListFirstEmp") != null){
				employeeListFirstEmp = (List)map.get("employeeListFirstEmp");
				empCodeFirst = employeeListFirstEmp.get(0).getEmployeeCode();
			}
			if(map.get("employeeListSecondEmp") != null){
				employeeListSecondEmp = (List)map.get("employeeListSecondEmp");
				empCodeSecond = employeeListSecondEmp.get(0).getEmployeeCode();
			}
			
			parameters.put("query", query);
			parameters.put("fromEmpId", fromEmpCode);
			parameters.put("toEmpId", toEmpCode);
			parameters.put("empCodeFirst", empCodeFirst);
			parameters.put("empCodeSecond", empCodeSecond);
			parameters.put("subHeadingReport", new String("Employee Experience Summary as on " + sdf.format(new Date())));

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("EmployeeExperienceSummary", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

 

	public ModelAndView printEmpServiceCard(HttpServletRequest request,
			HttpServletResponse response) {

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		Integer fromEmpCode = 0;

		try {
			if (request.getParameter("frmEmpCode") != null
					&& !request.getParameter("frmEmpCode").equals(0)) {
				fromEmpCode = Integer.parseInt(request
						.getParameter("frmEmpCode"));
			}

			parameters.put("empId", fromEmpCode);


			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("employeeServiceCard", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	 
	public ModelAndView showTimeSheetComplianceReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map map = new HashMap();
		map = reportHandlerService.showDepartmentJsp();
		String jsp = "ts_compliance_repo_jsp";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		// map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printTimeSheetComplianceReport(
			HttpServletRequest request, HttpServletResponse response) {

		byte[] bytes = null;
		//ServletContext context = request.getSession().getServletContext();
		HttpSession session = request.getSession();

		Map<String, Object> parameters = new HashMap();
		Map<String, Object> map = new HashMap();
		Map<String, Object> mapForDs = new HashMap();

		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			mapForDs.put("hospitalId", hospitalId);
		}
		
		try {

			Integer Dept = Integer.parseInt(request
					.getParameter("departmentId"));
			Date fromDate = null;
			if (request.getParameter(RequestConstants.FROM_DATE) != null
					&& !request.getParameter(RequestConstants.FROM_DATE)
							.equals("")) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.FROM_DATE));
			}
			Date toDate = new Date();
			if (request.getParameter(RequestConstants.TO_DATE) != null
					&& !request.getParameter(RequestConstants.TO_DATE).equals(
							"")) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.TO_DATE));
			}
			List listOfHolidays=null;
			listOfHolidays=reportHandlerService.getHolidays();
			int noOfDays = new Integer(LeaveManagementUtil
					.getNumberOfDaysBetweenTwoDates(fromDate, toDate,listOfHolidays));

			Integer minHrs = reportHandlerService.getMinHrsForTimeSheet(
					noOfDays, 2, fromDate, toDate);
			
			List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
			String companyname = "";
			map = reportHandlerService.getHospitalName(mapForDs);
			if(map.get("masHospitalList") != null){
				masHospitalList = (List)map.get("masHospitalList");
			}
			if(masHospitalList.size() > 0){
				companyname = masHospitalList.get(0).getHospitalName();
			}
			parameters.put("toDate", toDate);
			parameters.put("companyname", companyname);
			parameters.put("fromDate", fromDate);
			parameters.put("minHrs", minHrs);
			parameters.put("companyid", hospitalId);
			if(Dept == 999){
				Map<String, Object> connectionMap = reportHandlerService.getConnectionForReport();
				HMSUtil.generateReport("TimeSheetComplianceReportAllEmp", parameters,
						(Connection) connectionMap.get("conn"), response,
						getServletContext());
				
			}
			else if ((Dept > 0) && (Dept < 999)) {
				parameters.put("dept", Dept);
				Map<String, Object> connectionMap = reportHandlerService
						.getConnectionForReport();
				HMSUtil.generateReport("TimeSheetComplianceReportNewDept", parameters,
						(Connection) connectionMap.get("conn"), response,
						getServletContext());
			} else if (Dept == 0) {
				Map<String, Object> connectionMap = reportHandlerService
						.getConnectionForReport();
				/*HMSUtil.generateReport("TimeSheetComplianceReportNew",
						parameters, (Connection) connectionMap.get("conn"),
						response, getServletContext());*/
				
				HMSUtil.generateReport("TimeSheetComplianceReportAllDepartment",
						parameters, (Connection) connectionMap.get("conn"),
						response, getServletContext());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView exportToExcelTimeSheetComplianceReport(
			HttpServletRequest request, HttpServletResponse response) {

		byte[] bytes = null;
		//ServletContext context = request.getSession().getServletContext();
		// Map parameters = new HashMap();
		HttpSession session = request.getSession();

		Map<String, Object> parameters = new HashMap();
		Map<String, Object> map = new HashMap();
		Map<String, Object> mapForDs = new HashMap();

		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			mapForDs.put("hospitalId", hospitalId);
		}

		try {
			// Integer EmpId=Integer.parseInt(request.getParameter("EmpId"));
			Integer Dept = Integer.parseInt(request
					.getParameter("departmentId"));
			Date fromDate = null;
			if (request.getParameter(RequestConstants.FROM_DATE) != null
					&& !request.getParameter(RequestConstants.FROM_DATE)
							.equals("")) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.FROM_DATE));
			}
			Date toDate = new Date();
			if (request.getParameter(RequestConstants.TO_DATE) != null
					&& !request.getParameter(RequestConstants.TO_DATE).equals(
							"")) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.TO_DATE));
			}
			// Integer
			// LocationId=Integer.parseInt(request.getParameter("LocationId"));
			List listOfHolidays=null;
			listOfHolidays=reportHandlerService.getHolidays();
			int noOfDays = new Integer(LeaveManagementUtil
					.getNumberOfDaysBetweenTwoDates(fromDate, toDate,listOfHolidays));

			Integer minHrs = reportHandlerService.getMinHrsForTimeSheet(
					noOfDays, 2, fromDate, toDate);

			// parameters.put("dept",Dept);

			List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
			String companyname = "";
			map = reportHandlerService.getHospitalName(mapForDs);
			if(map.get("masHospitalList") != null){
				masHospitalList = (List)map.get("masHospitalList");
			}
			if(masHospitalList.size() > 0){
				companyname = masHospitalList.get(0).getHospitalName();
			}
			parameters.put("companyname", companyname);
			if(Dept == 999){
				Map<String, Object> connectionMap = reportHandlerService.getConnectionForReport();
				HMSUtil.generateReport("TimeSheetComplianceReportAllEmp", parameters,
						(Connection) connectionMap.get("conn"), response,
						getServletContext());
				
				 
			}
			else if ((Dept > 0) && (Dept < 999) ) {
				parameters.put("toDate", toDate);
				parameters.put("fromDate", fromDate);
				parameters.put("minHrs", minHrs);
				parameters.put("dept", Dept);

				Map<String, Object> connectionMap = reportHandlerService
						.getConnectionForReport();
				HMSUtil.generateReport("timeComplianceDeptWise", parameters,
						(Connection) connectionMap.get("conn"), response,
						getServletContext());
				
				 
			} else if (Dept < 0) {
				parameters.put("toDate", toDate);
				parameters.put("fromDate", fromDate);
				parameters.put("minHrs", minHrs);
				Map<String, Object> connectionMap = reportHandlerService
						.getConnectionForReport();
				HMSUtil.generateReport("TimeSheetComplianceReportNew", parameters,
						(Connection) connectionMap.get("conn"), response,
						getServletContext());
				
		 

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printWeeklyTimeSheetComplianceReport(
			HttpServletRequest request, HttpServletResponse response) {

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		// Map parameters = new HashMap();
		Map<String, Object> parameters = new HashMap();

		try {
			// Integer EmpId=Integer.parseInt(request.getParameter("EmpId"));
			// Integer Dept=
			// Integer.parseInt(request.getParameter("departmentId"));
			Date fromDate = null;
			if (request.getParameter(RequestConstants.FROM_DATE) != null
					&& !request.getParameter(RequestConstants.FROM_DATE)
							.equals("")) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.FROM_DATE));
			}
			// Date toDate = new Date() ;
			// if(request.getParameter(RequestConstants.TO_DATE) != null &&
			// !request.getParameter(RequestConstants.TO_DATE).equals(""))
			// {
			// toDate=
			// HMSUtil.convertStringTypeDateToDateType(request.getParameter(RequestConstants.TO_DATE));
			// }
			// Integer
			// LocationId=Integer.parseInt(request.getParameter("LocationId"));


			parameters.put("DatePara", fromDate);

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("WeeklyTimeSheetCompliance", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView exportToExcelWeeklyTimeSheetComplianceReport(
			HttpServletRequest request, HttpServletResponse response) {

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		// Map parameters = new HashMap();
		Map<String, Object> parameters = new HashMap();

		try {
			// Integer EmpId=Integer.parseInt(request.getParameter("EmpId"));
			// Integer Dept=
			// Integer.parseInt(request.getParameter("departmentId"));
			Date fromDate = null;
			if (request.getParameter(RequestConstants.FROM_DATE) != null
					&& !request.getParameter(RequestConstants.FROM_DATE)
							.equals("")) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.FROM_DATE));
			}
			// Date toDate = new Date() ;
			// if(request.getParameter(RequestConstants.TO_DATE) != null &&
			// !request.getParameter(RequestConstants.TO_DATE).equals(""))
			// {
			// toDate=
			// HMSUtil.convertStringTypeDateToDateType(request.getParameter(RequestConstants.TO_DATE));
			// }
			// Integer
			// LocationId=Integer.parseInt(request.getParameter("LocationId"));

			parameters.put("DatePara", fromDate);

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("WeeklyTimeSheetCompliance", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
			
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ModelAndView printOrgTimeSheetComplianceReport(
			HttpServletRequest request, HttpServletResponse response) {

		byte[] bytes = null;
		//ServletContext context = request.getSession().getServletContext();
		HttpSession session = request.getSession();

		Map<String, Object> parameters = new HashMap();
		Map<String, Object> map = new HashMap();
		Map<String, Object> mapForDs = new HashMap();

		int companyId = 0;
		String companyname ="";
		
		try {

			 companyId = Integer.parseInt(request
					.getParameter("companyId"));
			mapForDs.put("hospitalId", companyId);
			Date fromDate = null;
			if (request.getParameter(RequestConstants.FROM_DATE) != null
					&& !request.getParameter(RequestConstants.FROM_DATE)
							.equals("")) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.FROM_DATE));
			}
			
			Date toDate = new Date();
			if (request.getParameter(RequestConstants.TO_DATE) != null
					&& !request.getParameter(RequestConstants.TO_DATE).equals(
							"")) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.TO_DATE));
			}
			List listOfHolidays=null;
			listOfHolidays=reportHandlerService.getHolidays();
			int noOfDays = new Integer(LeaveManagementUtil
					.getNumberOfDaysBetweenTwoDates(fromDate, toDate,listOfHolidays));
			Integer minHrs = reportHandlerService.getMinHrsForTimeSheet(
					noOfDays, 2, fromDate, toDate);
			
			
			List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
			map = reportHandlerService.getHospitalName(mapForDs);
			if(map.get("masHospitalList") != null){
				masHospitalList = (List)map.get("masHospitalList");
			}
			if(masHospitalList.size() > 0){
				companyname = masHospitalList.get(0).getHospitalName();
			}
			parameters.put("toDate", toDate);
			parameters.put("companyid", companyId);
			parameters.put("fromDate", fromDate);
			parameters.put("companyname", companyname);
			parameters.put("minHrs", minHrs);
			
			Map<String, Object> connectionMap = reportHandlerService
			.getConnectionForReport();
			HMSUtil.generateReport("TimeSheetComplianceReportOrganization", parameters,
			(Connection) connectionMap.get("conn"), response,
			getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public ModelAndView showDepartmentJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map map = new HashMap();
		map = reportHandlerService.showDepartmentJsp();
		String jsp = "ts_DepWiseTimeSheetReport";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		// map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printTimeSheetsDepartmentWise(
			HttpServletRequest request, HttpServletResponse response) {

		byte[] bytes = null;
		Map<String, Object> map = new HashMap();
		Map<String, Object> mapForDs = new HashMap();
		HttpSession session = request.getSession();
		
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			mapForDs.put("hospitalId", hospitalId);
		}

		//ServletContext context = request.getSession().getServletContext();
		// Map parameters = new HashMap();
		Map<String, Object> parameters = new HashMap();

		try {
			// Integer EmpId=Integer.parseInt(request.getParameter("EmpId"));
			Integer Dept = Integer.parseInt(request
					.getParameter("departmentId"));
			Date fromDate = null;
			if (request.getParameter(RequestConstants.FROM_DATE) != null
					&& !request.getParameter(RequestConstants.FROM_DATE)
							.equals("")) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.FROM_DATE));
			}
			Date toDate = new Date();
			if (request.getParameter(RequestConstants.TO_DATE) != null
					&& !request.getParameter(RequestConstants.TO_DATE).equals(
							"")) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.TO_DATE));
			}
			List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
			String companyname = "";
			map = reportHandlerService.getHospitalName(mapForDs);
			if(map.get("masHospitalList") != null){
				masHospitalList = (List)map.get("masHospitalList");
			}
			if(masHospitalList.size() > 0){
				companyname = masHospitalList.get(0).getHospitalName();
			}
			
			// Integer
			// LocationId=Integer.parseInt(request.getParameter("LocationId"));

			parameters.put("department_id", Dept);
			parameters.put("companyname", companyname);
			parameters.put("Pin_End_Date", toDate);
			parameters.put("Pin_Start_Date", fromDate);

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("DepartmentWiseTimesheet", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView exportToExcelTimeSheetsDepartmentWise(
			HttpServletRequest request, HttpServletResponse response) {

		byte[] bytes = null;
		Map<String, Object> map = new HashMap();
		Map<String, Object> mapForDs = new HashMap();
		HttpSession session = request.getSession();
		
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			mapForDs.put("hospitalId", hospitalId);
		}

		//ServletContext context = request.getSession().getServletContext();
		// Map parameters = new HashMap();
		Map<String, Object> parameters = new HashMap();

		try {
			// Integer EmpId=Integer.parseInt(request.getParameter("EmpId"));
			Integer Dept = Integer.parseInt(request
					.getParameter("departmentId"));
			Date fromDate = null;
			if (request.getParameter(RequestConstants.FROM_DATE) != null
					&& !request.getParameter(RequestConstants.FROM_DATE)
							.equals("")) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.FROM_DATE));
			}
			Date toDate = new Date();
			if (request.getParameter(RequestConstants.TO_DATE) != null
					&& !request.getParameter(RequestConstants.TO_DATE).equals(
							"")) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.TO_DATE));
			}
			List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
			String companyname = "";
			map = reportHandlerService.getHospitalName(mapForDs);
			if(map.get("masHospitalList") != null){
				masHospitalList = (List)map.get("masHospitalList");
			}
			if(masHospitalList.size() > 0){
				companyname = masHospitalList.get(0).getHospitalName();
			}
			
			// Integer
			// LocationId=Integer.parseInt(request.getParameter("LocationId"));
			parameters.put("companyname", companyname);
			parameters.put("department_id", Dept);
			parameters.put("Pin_End_Date", toDate);
			parameters.put("Pin_Start_Date", fromDate);

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("DepartmentWiseTimesheet", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
			
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView showEmployeeWiseSheetJsp(HttpServletRequest request,HttpServletResponse response) {
		Map map = new HashMap();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		int employeeId = 0;
		if(session.getAttribute("users")!= null){
			users = (Users)session.getAttribute("users");
			employeeId= users.getEmployee().getId();
		}
		map = reportHandlerService.showEmployeeWiseSheetJsp(employeeId);
		String jsp = "ts_EmployeeWiseTimeSheetReport";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		// map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printEmployeeWiseSheetReport(
			HttpServletRequest request, HttpServletResponse response) {

		byte[] bytes = null;
		
		//ServletContext context = request.getSession().getServletContext();
		// Map parameters = new HashMap();
		Map<String, Object> parameters = new HashMap();
		Map<String, Object> map = new HashMap();
		Map<String, Object> mapForDs = new HashMap();
		HttpSession session = request.getSession();
		
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			mapForDs.put("hospitalId", hospitalId);
		}

		Users user = null;
		if (session.getAttribute(USERS) != null) {
			user = (Users) session.getAttribute(USERS);
		}
		try {
			// Integer EmpId=Integer.parseInt(request.getParameter("EmpId"));

			String status = request.getParameter("status");
			Date fromDate = null;
			if (request.getParameter(RequestConstants.FROM_DATE) != null
					&& !request.getParameter(RequestConstants.FROM_DATE)
							.equals("")) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.FROM_DATE));
			}
			Date toDate = new Date();
			if (request.getParameter(RequestConstants.TO_DATE) != null
					&& !request.getParameter(RequestConstants.TO_DATE).equals(
							"")) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.TO_DATE));
			}

			Integer employeeId = null;
			if (request.getParameter("employeeId") != null
					&& !request.getParameter("employeeId").equals("")) {
				employeeId = new Integer(request.getParameter("employeeId"));
			}
			Integer departmentId = null;
			if (request.getParameter("departmentId") != null
					&& !request.getParameter("departmentId").equals("")) {
				departmentId = new Integer(request.getParameter("departmentId"));
			}

			List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
			String companyname = "";
			map = reportHandlerService.getHospitalName(mapForDs);
			if(map.get("masHospitalList") != null){
				masHospitalList = (List)map.get("masHospitalList");
			}
			if(masHospitalList.size() > 0){
				companyname = masHospitalList.get(0).getHospitalName();
			}
			
			parameters.put("companyname", companyname);
			parameters.put("Pin_End_Date", toDate);
			parameters.put("Pin_Start_Date", fromDate);
			parameters.put("status", status);
			parameters.put("employee_id", employeeId);
			parameters.put("department_id", departmentId);
			
			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			if(status.equals("%")){
				HMSUtil.generateReport("EmployeeWiseTimesheetALLStatus", parameters,
						(Connection) connectionMap.get("conn"), response,
						getServletContext());
			}else{
				HMSUtil.generateReport("EmployeeWiseTimesheet", parameters,
						(Connection) connectionMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView exportToExcelEmployeeWiseSheetReport(
			HttpServletRequest request, HttpServletResponse response) {

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		// Map parameters = new HashMap();
		Map<String, Object> parameters = new HashMap();
		Map<String, Object> map = new HashMap();
		Map<String, Object> mapForDs = new HashMap();
		HttpSession session = request.getSession();
		
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			mapForDs.put("hospitalId", hospitalId);
		}

		Users user = null;
		if (session.getAttribute(USERS) != null) {
			user = (Users) session.getAttribute(USERS);
		}
		try {
			String status = request.getParameter("status");
			Date fromDate = null;
			if (request.getParameter(RequestConstants.FROM_DATE) != null
					&& !request.getParameter(RequestConstants.FROM_DATE).equals("")) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(RequestConstants.FROM_DATE));
			}
			Date toDate = new Date();
			if (request.getParameter(RequestConstants.TO_DATE) != null
					&& !request.getParameter(RequestConstants.TO_DATE).equals("")) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(RequestConstants.TO_DATE));
			}
			Integer employeeId = null;
			if (request.getParameter("employeeId") != null
					&& !request.getParameter("employeeId").equals("")) {
				employeeId = new Integer(request.getParameter("employeeId"));
			}
			Integer departmentId = null;
			if (request.getParameter("departmentId") != null
					&& !request.getParameter("departmentId").equals("")) {
				departmentId = new Integer(request.getParameter("departmentId"));
			}

			List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
			String companyname = "";
			map = reportHandlerService.getHospitalName(mapForDs);
			if(map.get("masHospitalList") != null){
				masHospitalList = (List)map.get("masHospitalList");
			}
			if(masHospitalList.size() > 0){
				companyname = masHospitalList.get(0).getHospitalName();
			}
			
			parameters.put("companyname", companyname);
			parameters.put("Pin_End_Date", toDate);
			parameters.put("Pin_Start_Date", fromDate);
			parameters.put("status", status);
			parameters.put("employee_id", employeeId);
			parameters.put("department_id", departmentId);
			
			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			if(status.equals("%")){
				HMSUtil.generateReport("EmployeeWiseTimesheetALLStatus", parameters,
						(Connection) connectionMap.get("conn"), response,
						getServletContext());
			}else{
				HMSUtil.generateReport("EmployeeWiseTimesheet", parameters,
						(Connection) connectionMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView showMyTimeSheetJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map map = new HashMap();
		// map = reportHandlerService.showDepartmentJsp();
		String jsp = "ts_MyTimeSheetReport";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		// map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printMyTimeSheetReport(HttpServletRequest request,
			HttpServletResponse response) {

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		// Map parameters = new HashMap();
		Map<String, Object> parameters = new HashMap();
		HttpSession session = request.getSession();

		Users user = null;
		if (session.getAttribute(USERS) != null) {
			user = (Users) session.getAttribute(USERS);
		}
		try {
			// Integer EmpId=Integer.parseInt(request.getParameter("EmpId"));

			String status = request.getParameter("status");
			Date fromDate = null;
			if (request.getParameter(RequestConstants.FROM_DATE) != null
					&& !request.getParameter(RequestConstants.FROM_DATE)
							.equals("")) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.FROM_DATE));
			}
			Date toDate = new Date();
			if (request.getParameter(RequestConstants.TO_DATE) != null
					&& !request.getParameter(RequestConstants.TO_DATE).equals(
							"")) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.TO_DATE));
			}
			// Integer
			// LocationId=Integer.parseInt(request.getParameter("LocationId"));

			parameters.put("Pin_End_Date", toDate);
			parameters.put("Pin_Start_Date", fromDate);
			parameters.put("status", status);
			parameters.put("employee_id", user.getEmployee().getId());

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("MyTimesheet", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView exportToExcelMyTimeSheetReport(
			HttpServletRequest request, HttpServletResponse response) {

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		// Map parameters = new HashMap();
		Map<String, Object> parameters = new HashMap();
		HttpSession session = request.getSession();

		Users user = null;
		if (session.getAttribute(USERS) != null) {
			user = (Users) session.getAttribute(USERS);
		}
		try {
			// Integer EmpId=Integer.parseInt(request.getParameter("EmpId"));

			String status = request.getParameter("status");
			Date fromDate = null;
			if (request.getParameter(RequestConstants.FROM_DATE) != null
					&& !request.getParameter(RequestConstants.FROM_DATE)
							.equals("")) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.FROM_DATE));
			}
			Date toDate = new Date();
			if (request.getParameter(RequestConstants.TO_DATE) != null
					&& !request.getParameter(RequestConstants.TO_DATE).equals(
							"")) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.TO_DATE));
			}
			// Integer
			// LocationId=Integer.parseInt(request.getParameter("LocationId"));

			parameters.put("Pin_End_Date", toDate);
			parameters.put("Pin_Start_Date", fromDate);
			parameters.put("status", status);
			parameters.put("employee_id", user.getEmployee().getId());

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("MyTimesheetWithComments", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
			
		 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	public ModelAndView showStatusWiseTimeSheetReportJsp(
			HttpServletRequest request, HttpServletResponse response) {

		Map map = new HashMap();
		map = reportHandlerService.showDepartmentJsp();
		String jsp = "ts_StatusWiseTimeSheetReport";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		// map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printStatusWiseTimeSheetReport(
			HttpServletRequest request, HttpServletResponse response) {

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map<String, Object> parameters = new HashMap();
		Map<String, Object> map = new HashMap();
		Map<String, Object> mapForDs = new HashMap();
		HttpSession session = request.getSession();

		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			mapForDs.put("hospitalId", hospitalId);
		}

		try {

			Integer Dept = Integer.parseInt(request.getParameter("departmentId"));
			String status = request.getParameter("status");
			
			Date fromDate = null;
			if (request.getParameter(RequestConstants.FROM_DATE) != null
					&& !request.getParameter(RequestConstants.FROM_DATE).equals("")) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.FROM_DATE));
			}
			Date toDate = new Date();
			if (request.getParameter(RequestConstants.TO_DATE) != null
					&& !request.getParameter(RequestConstants.TO_DATE).equals("")) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.TO_DATE));
			}
			List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
			String companyname = "";
			map = reportHandlerService.getHospitalName(mapForDs);
			if(map.get("masHospitalList") != null){
				masHospitalList = (List)map.get("masHospitalList");
			}
			if(masHospitalList.size() > 0){
				companyname = masHospitalList.get(0).getHospitalName();
			}
			
			parameters.put("companyname", companyname);
			parameters.put("department_id", Dept);
			parameters.put("Pin_End_Date", toDate);
			parameters.put("Pin_Start_Date", fromDate);
			parameters.put("status", status);

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("StatusWiseTimesheet", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView exportToExcelStatusWiseTimeSheetReport(
			HttpServletRequest request, HttpServletResponse response) {

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map<String, Object> parameters = new HashMap();
		Map<String, Object> map = new HashMap();
		Map<String, Object> mapForDs = new HashMap();
		HttpSession session = request.getSession();

		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			mapForDs.put("hospitalId", hospitalId);
		}

		try {

			Integer Dept = Integer.parseInt(request.getParameter("departmentId"));
			String status = request.getParameter("status");
			
			Date fromDate = null;
			if (request.getParameter(RequestConstants.FROM_DATE) != null
					&& !request.getParameter(RequestConstants.FROM_DATE).equals("")) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.FROM_DATE));
			}
			Date toDate = new Date();
			if (request.getParameter(RequestConstants.TO_DATE) != null
					&& !request.getParameter(RequestConstants.TO_DATE).equals("")) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(RequestConstants.TO_DATE));
			}
			List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
			String companyname = "";
			map = reportHandlerService.getHospitalName(mapForDs);
			if(map.get("masHospitalList") != null){
				masHospitalList = (List)map.get("masHospitalList");
			}
			if(masHospitalList.size() > 0){
				companyname = masHospitalList.get(0).getHospitalName();
			}
			
			parameters.put("companyname", companyname);
			parameters.put("department_id", Dept);
			parameters.put("Pin_End_Date", toDate);
			parameters.put("Pin_Start_Date", fromDate);
			parameters.put("status", status);

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			
			HMSUtil.generateReport("StatusWiseTimesheet", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
 

	public ModelAndView showEmpCTCAnnexure(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "employeeCTCAnnexure.jsp";
		Map<String, Object> map = new HashMap<String, Object>();

		map = reportHandlerService.showEmpCTCAnnexure();
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printEmpCTCAnnexure(HttpServletRequest request,
			HttpServletResponse response) {

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		Integer EmpCode = 0;

		try {
			if (request.getParameter("frmEmpCode") != null
					&& !request.getParameter("frmEmpCode").equals(0)) {
				EmpCode = Integer.parseInt(request.getParameter("frmEmpCode"));
			}

			parameters.put("empID", EmpCode);


			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("employeeCTCAnnexture", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	 
	// -----------------------------employee Investment Proof---------

	public ModelAndView showEmployeeInvestment(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "printEmployeeInvestment.jsp";
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showEmployeeInvestment();
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printEmployeeInvestmentProof(
			HttpServletRequest request, HttpServletResponse response) {

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		String query = "";
		int f_year = 0;
		int empId = 0;
		try {
			if (request.getParameter("invYear") != null
					&& request.getParameter("invYear") != "") {
				f_year = Integer.parseInt(request.getParameter("invYear"));
			}

			if (request.getParameter("empcode") != null
					&& request.getParameter("empcode") != "") {
				empId = Integer.parseInt(request.getParameter("empcode"));
				query = "where mas_employee.`employee_id` =" + empId;
			}

			parameters.put("f_year", f_year);
			parameters.put("sqlString", query);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
					"//Reports//"));

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("TDSReportMain", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Employee Investment");

		return null;

	}

	 
	
	// /--------------------------Form 3A ---------------------------

	public ModelAndView showForm3A(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "Form3A.jsp";
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showIncomeTaxSheet();
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printForm3A(HttpServletRequest request,
			HttpServletResponse response) {

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		String query = "";
		int year = 0;
		int emp_id = 0;
		try {
			if (request.getParameter("invYear") != null
					&& request.getParameter("invYear") != "") {
				year = Integer.parseInt(request.getParameter("invYear"));
			}

			if (request.getParameter("empcode") != null
					&& request.getParameter("empcode") != "") {
				emp_id = Integer.parseInt(request.getParameter("empcode"));
				query = "where mas_employee.`employee_id` =" + emp_id;
			}

			parameters.put("year", year);
			parameters.put("query", query);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
					"//Reports//"));

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Form3AMain", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Form 3A");

		return null;

	}

	// /--------------------------Form 6A ---------------------------

	public ModelAndView showForm6A(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "Form6A.jsp";
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showForm6A();
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printForm6A(HttpServletRequest request,
			HttpServletResponse response) {

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		int year = 0;
		try {
			if (request.getParameter("invYear") != null
					&& request.getParameter("invYear") != "") {
				year = Integer.parseInt(request.getParameter("invYear"));
			}

			parameters.put("year", year);
			// parameters.put("SUBREPORT_DIR",getServletContext().getRealPath("//Reports//"));

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Form6A", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Form 3A");

		return null;

	}

	// /--------------------------TDS Deposit ---------------------------

	public ModelAndView showTDSDeposit(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "TDSDeposit.jsp";
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		map = reportHandlerService.showTDSDeposit();
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printTDSDeposit(HttpServletRequest request,
			HttpServletResponse response) {

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		String year = new String("");
		try {
			if (request.getParameter("invYear") != null
					&& request.getParameter("invYear") != "") {
				year = request.getParameter("invYear");
			}

			parameters.put("FYear", year);
			// parameters.put("SUBREPORT_DIR",getServletContext().getRealPath("//Reports//"));

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("TDSDepositReport", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment;filename="
				+ "TDS Deposit");

		return null;

	}

	// /--------------------------PF Statement ---------------------------

	public ModelAndView showPFStatement(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "PFStatement.jsp";
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		map = reportHandlerService.showPFStatement();
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printPFStatement(HttpServletRequest request,
			HttpServletResponse response) {

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		int year = 0;
		int intMonth = 0;
		String strMonth = "";
		String myMonth[] = { "select", "January", "February", "March", "April",
				"May", "June", "July", "August", "September", "October",
				"November", "December" };
		try {
			if (request.getParameter("invYear") != null
					&& request.getParameter("invYear") != "") {
				year = Integer.parseInt(request.getParameter("invYear"));
			}

			if (request.getParameter("month") != null
					&& request.getParameter("month") != "") {
				intMonth = Integer.parseInt(request.getParameter("month"));
			}

			strMonth = myMonth[intMonth];


			parameters.put("year", year);
			parameters.put("intMonth", intMonth);
			parameters.put("strMonth", strMonth);

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("PFStatement", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment;filename="
				+ "PF Statement");

		return null;

	}

	// /--------------------------Form 5 ---------------------------

	public ModelAndView showFrom5(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "Form5.jsp";
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		map = reportHandlerService.showPFStatement();
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printForm5(HttpServletRequest request,
			HttpServletResponse response) {

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		int year = 0;
		int intMonth = 0;
		String strMonth = "";
		String myMonth[] = { "select", "January", "February", "March", "April",
				"May", "June", "July", "August", "September", "October",
				"November", "December" };
		try {
			if (request.getParameter("invYear") != null
					&& request.getParameter("invYear") != "") {
				year = Integer.parseInt(request.getParameter("invYear"));
			}

			if (request.getParameter("month") != null
					&& request.getParameter("month") != "0") {
				intMonth = Integer.parseInt(request.getParameter("month"));
			}

			strMonth = myMonth[intMonth];

			parameters.put("year", year);
			parameters.put("intMonth", intMonth);
			parameters.put("strMonth", strMonth);

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Form5", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Form5");

		return null;

	}

	// /--------------------------Form 6A(2) ---------------------------

	public ModelAndView showForm6a2(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "Form6A2.jsp";
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		map = reportHandlerService.showPFStatement();
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printForm6a2(HttpServletRequest request,
			HttpServletResponse response) {

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		int year = 0;
		try {
			if (request.getParameter("invYear") != null
					&& request.getParameter("invYear") != "") {
				year = Integer.parseInt(request.getParameter("invYear"));
			}
			parameters.put("year", year);

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Form6A2", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Form6A(2)");

		return null;

	}

	// ================================Project Tracking Report Start By	 Vishal======================================
	public ModelAndView showPIReport(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showPIReport();
		String jsp = PIREPORT;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printPIReport(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		HttpSession session = request.getSession();
		int hospitalId =0;
		if (session.getAttribute("hospitalId")!= null) {
			hospitalId = (Integer)session.getAttribute("hospitalId");
			mapForDs.put("hospitalId", hospitalId);
	
		}
		List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
		String companyname = "";
		map = reportHandlerService.getHospitalName(mapForDs);
		if(map.get("masHospitalList") != null){
			masHospitalList = (List)map.get("masHospitalList");
		}
		if(masHospitalList.size() > 0){
			companyname = masHospitalList.get(0).getHospitalName();
		}
		parameters.put("companyname", companyname);
		String selectedOption = "";
		String type ="" ;
		String reportName = "";
		try {
			if (request.getParameter("selectOption") != null && !request.getParameter("selectOption").equals("")) {
				selectedOption = request.getParameter("selectOption");
				type = request.getParameter("selectOption");
			}
			if(selectedOption.equalsIgnoreCase("all")){
				parameters.put("type", type);
				reportName = "PI_All";
			}else if(selectedOption.equalsIgnoreCase("therapeutic")){
				if (request.getParameter("therapeuticSelect") != null && !request.getParameter("therapeuticSelect").equals("")) {
					int therapeuticId = Integer.parseInt(request.getParameter("therapeuticSelect"));
					parameters.put("TheId", therapeuticId);
				}
				reportName = "PI_TherapeuticWise";
			}else if(selectedOption.equalsIgnoreCase("project")){
				if (request.getParameter("allProjectCheck") != null && !request.getParameter("allProjectCheck").equals("")) {
					String allProject = request.getParameter("allProjectCheck");
					reportName = "PI_All_Project_Wise";
				} else {
					if (request.getParameter("projectSelect") != null && !request.getParameter("projectSelect").equals("")) {
						int projectId = Integer.parseInt(request.getParameter("projectSelect"));
						parameters.put("Project_id", projectId);
						reportName = "PI_Project_Wise";
					}						
				} 	
			}
			Map<String, Object> connectionMap = reportHandlerService.getConnectionForReport();
			HMSUtil.generateReport(reportName, parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment;filename="
				+ reportName);

		return null;

	}
	public ModelAndView showAllProjectReport(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		String jsp = "hr_allProject";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printAllProjectReport(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap();
		byte[] bytes = null;
		Map parameters = new HashMap();
		ServletContext context = request.getSession().getServletContext();
		HttpSession session = request.getSession();
		String querySql = "";
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			mapForDs.put("hospitalId", hospitalId);
		}
		
		String billableType = "";
		if(!request.getParameter("billable").equals("all")){
			billableType = request.getParameter("billable");
			querySql = querySql + " and p1.Billable = "+"'"+billableType+"'";
		}
		String billable = "";
		if(billableType.equals("y")){
			billable = "Billable";
		}else if(billableType.equals("n")){
			billable = "Non-Billable";
		}else{
			billable = "All";
		}
		Date fromdate = null;
		if(request.getParameter(HrmsRequestConstants.FROM_DATE)!=null && !(request.getParameter(HrmsRequestConstants.FROM_DATE).equals(""))){
			fromdate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(HrmsRequestConstants.FROM_DATE));
			
		} 
		Date todate = null;
		if(request.getParameter(HrmsRequestConstants.TO_DATE)!=null && !(request.getParameter(HrmsRequestConstants.TO_DATE).equals(""))) {
			todate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(HrmsRequestConstants.TO_DATE));
		}
		parameters.put("todate", todate);
		parameters.put("fromdate", fromdate);
		parameters.put("companyid", hospitalId);
		parameters.put("sqlquery", querySql);
		parameters.put("billable", billable);
		
		try {

			Map<String, Object> connectionMap = reportHandlerService.getConnectionForReport();
			HMSUtil.generateReport("Project_All_Project", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Project_All_Project");

		return null;

	}
	
	public ModelAndView showTimeReport(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "hr_timeReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printTimeReport(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		HttpSession session = request.getSession();
		String querySql = "";
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		String billableType = "";
		if(!request.getParameter("billable").equals("all")){
			billableType = request.getParameter("billable");
			querySql = querySql + " and p.billable = "+"'"+billableType+"'";
		}
		String billable = "";
		if(billableType.equals("y")){
			billable = "Billable";
		}else if(billableType.equals("n")){
			billable = "Non-Billable";
		}else{
			billable = "All";
		}
		parameters.put("companyid", hospitalId);
		parameters.put("sqlquery", querySql);
		parameters.put("billable", billable);
		Map<String, Object> connectionMap = reportHandlerService.getConnectionForReport();
		try {

			HMSUtil.generateReport("Project_Time", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Project_Time");

		return null;

	}
	public ModelAndView showProjectResourceTimeJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showProjectResourceTimeReport();
		String jsp = PROJECT_RESOURCE_TIME;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printProjectResourceTime(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap();
		byte[] bytes = null;
		Map parameters = new HashMap();
		ServletContext context = request.getSession().getServletContext();
		HttpSession session = request.getSession();
		String querySql = "";
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			mapForDs.put("hospitalId", hospitalId);
		}
		int projectId = 0;
		if(request.getParameter("projectId")!= null ){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}
		String billableType = "";
		if(!request.getParameter("billable").equals("all")){
			billableType = request.getParameter("billable");
			querySql = querySql + " and p1.Billable = "+"'"+billableType+"'";
		}
		String billable = "";
		if(billableType.equals("y")){
			billable = "Billable";
		}else if(billableType.equals("n")){
			billable = "Non-Billable";
		}else{
			billable = "All";
		}
		Date fromdate = null;
		if(request.getParameter(HrmsRequestConstants.FROM_DATE)!=null && !(request.getParameter(HrmsRequestConstants.FROM_DATE).equals(""))){
			fromdate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(HrmsRequestConstants.FROM_DATE));
			
		} 
		Date todate = null;
		if(request.getParameter(HrmsRequestConstants.TO_DATE)!=null && !(request.getParameter(HrmsRequestConstants.TO_DATE).equals(""))) {
			todate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(HrmsRequestConstants.TO_DATE));
		}
		
	
		Map<String, Object> connectionMap = reportHandlerService.getConnectionForReport();
		parameters.put("todate", todate);
		parameters.put("fromdate", fromdate);
		parameters.put("companyid", hospitalId);
		parameters.put("sqlquery", querySql);
		parameters.put("billable", billable);
		parameters.put("Project_id", projectId);
		
			
	try {
			HMSUtil.generateReport("Project_Resource_time", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Project_Resource_time");

		return null;

	}
	public ModelAndView showProjectResourceCostJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showProjectResourceTimeReport();
		String jsp = PROJECT_RESOURCE_COST;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printProjectResourceCost(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap();
		byte[] bytes = null;
		Map parameters = new HashMap();
		ServletContext context = request.getSession().getServletContext();
		HttpSession session = request.getSession();
		String querySql = "";
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		int projectId = 0;
		if(request.getParameter("projectId")!= null ){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}
		String billableType = "";
		if(!request.getParameter("billable").equals("")){
			billableType = request.getParameter("billable");
			querySql = querySql + " and p1.Billable = "+"'"+billableType+"'";
		}
		String billable = "";
		if(billableType.equals("y")){
			billable = "Billable";
		}else if(billableType.equals("n")){
			billable = "Non-Billable";
		}else{
			billable = "All";
		}
		Date fromdate = null;
		if(request.getParameter(FROM_DATE)!=null && !(request.getParameter(FROM_DATE).equals(""))){
			fromdate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			
		} 
		Date todate = null;
		if(request.getParameter(TO_DATE)!=null && !(request.getParameter(TO_DATE).equals(""))) {
			todate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
	
		Map<String, Object> connectionMap = reportHandlerService.getConnectionForReport();
		parameters.put("todate", todate);
		parameters.put("fromdate", fromdate);
		parameters.put("companyid", hospitalId);
		parameters.put("sqlquery", querySql);
		parameters.put("billable", billable);
		parameters.put("Project_id", projectId);
		
		try {
								
			
			HMSUtil.generateReport("Project_Resource_Cost", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Project_Resource_Cost");

		return null;

	}
	public ModelAndView showProjectTaskTimeJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showProjectResourceTimeReport();
		String jsp = PROJECT_TASK_TIME;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printProjectTaskTimeReport(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap();
		byte[] bytes = null;
		Map parameters = new HashMap();
		ServletContext context = request.getSession().getServletContext();
		HttpSession session = request.getSession();
		String querySql = "";
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		int projectId = 0;
		if(request.getParameter(PROJECT_ID)!= null ){
			projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
		}
		String billableType = "";
		if(!request.getParameter("billable").equals("all")){
			billableType = request.getParameter("billable");
			querySql = querySql + " and p1.Billable = "+"'"+billableType+"'";
		}
		String billable = "";
		if(billableType.equals("y")){
			billable = "Billable";
		}else if(billableType.equals("n")){
			billable = "Non-Billable";
		}else{
			billable = "All";
		}
		Date fromdate = null;
		if(request.getParameter(FROM_DATE)!=null && !(request.getParameter(FROM_DATE).equals(""))){
			fromdate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			
		} 
		Date todate = null;
		if(request.getParameter(TO_DATE)!=null && !(request.getParameter(TO_DATE).equals(""))) {
			todate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
	
		Map<String, Object> connectionMap = reportHandlerService.getConnectionForReport();
		parameters.put("todate", todate);
		parameters.put("fromdate", fromdate);
		parameters.put("companyid", hospitalId);
		parameters.put("sqlquery", querySql);
		parameters.put("billable", billable);
		parameters.put("Project_id", projectId);
		
			try {
			HMSUtil.generateReport("Project_Wise_Task_Time", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Project_Wise_Task_Time");

		return null;

	}
	public ModelAndView showProjectTaskTimeCostJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showProjectResourceTimeReport();
		String jsp = PROJECT_TASK_TIME_COST;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printProjectTaskTimeCostReport(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap();
		byte[] bytes = null;
		Map parameters = new HashMap();
		ServletContext context = request.getSession().getServletContext();
		HttpSession session = request.getSession();
		String querySql = "";
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			mapForDs.put("hospitalId", hospitalId);
		}
		int projectId = 0;
		if(request.getParameter("projectId")!= null ){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}
		String billableType = "";
		if(!request.getParameter("billable").equals("all")){
			billableType = request.getParameter("billable");
			querySql = querySql + " and p1.Billable = "+"'"+billableType+"'";
		}
		String billable = "";
		if(billableType.equals("y")){
			billable = "Billable";
		}else if(billableType.equals("n")){
			billable = "Non-Billable";
		}else{
			billable = "All";
		}
		Date fromdate = null;
		if(request.getParameter(FROM_DATE)!=null && !(request.getParameter(FROM_DATE).equals(""))){
			fromdate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			
		} 
		Date todate = null;
		if(request.getParameter(TO_DATE)!=null && !(request.getParameter(TO_DATE).equals(""))) {
			todate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
	
		Map<String, Object> connectionMap = reportHandlerService.getConnectionForReport();
		parameters.put("todate", todate);
		parameters.put("fromdate", fromdate);
		parameters.put("companyid", hospitalId);
		parameters.put("sqlquery", querySql);
		parameters.put("billable", billable);
		parameters.put("Project_id", projectId);
		

		try {

			
			HMSUtil.generateReport("Project_Wise_Task_Time_Cost", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Project_Wise_Task_Time_Cost");

		return null;

	}
	public ModelAndView printProjectVitalReport(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Project_AllVitals", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Project_AllVitals");

		return null;

	}
	public ModelAndView printProjectCalendar(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Project_Calender", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Project_Calender");

		return null;

	}
	public ModelAndView printResourceWiseTimeSheet(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Department_ All_ Resource_Wise_Time_Site", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Department_ All_ Resource_Wise_Time_Site");

		return null;

	}
	public ModelAndView showProjectSiteAllocationJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showProjectSiteAllocationReport();
		String jsp = DEPARTMENT_PROJECT_SITE_ALLOCATION;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printProjectSiteAllocationJsp(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !request.getParameter(DEPARTMENT_ID).equals("")) {
				int deptId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
				parameters.put("Dept_id", deptId);
			}						

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Department_ Project_and_Site_Allocation", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Department_ Project_and_Site_Allocation");

		return null;

	}
	public ModelAndView printProjectResourceAllocation(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Department_Prj_Resource_allocation", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Department_Prj_Resource_allocation");

		return null;

	}
	public ModelAndView showProjectWiseTaskTimeCost(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showProjectResourceTimeReport();
		String jsp = PROJECT_WISE_TASK_TIME_COST;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printProjectWiseTaskTimeCost(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			if (request.getParameter(PROJECT_ID) != null
					&& !request.getParameter(PROJECT_ID).equals("")) {
				int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
				parameters.put("Project_id", projectId);
			}						

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Department_Project_Wise_ Task_Time_Cost", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Department_Project_Wise_ Task_Time_Cost");

		return null;

	}
	public ModelAndView showProjectWiseCostReport(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map = reportHandlerService.showProjectWiseCostReport();
		
		String jsp = "hr_projectWiseCost";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printProjectWiseCost(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap();
		byte[] bytes = null;
		Map parameters = new HashMap();
		ServletContext context = request.getSession().getServletContext();
		HttpSession session = request.getSession();
		String querySql = "";
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			mapForDs.put("hospitalId", hospitalId);
		}
		int projectId = 0;
		if( !request.getParameter(PROJECT_ID).equals("0")){
			projectId = Integer.parseInt(request.getParameter(PROJECT_ID).toString());
			querySql = querySql + " and p.prj_id = "+projectId;
		}
		String billableType = "";
		if(!request.getParameter("billable").equals("all")){
			billableType = request.getParameter("billable");
			querySql = querySql + " and p.Billable = "+"'"+billableType+"'";
		}
		String billable = "";
		if(billableType.equals("y")){
			billable = "Billable";
		}else if(billableType.equals("n")){
			billable = "Non-Billable";
		}else{
			billable = "All";
		}
		Date fromdate = null;
		if(request.getParameter(HrmsRequestConstants.FROM_DATE)!=null && !(request.getParameter(HrmsRequestConstants.FROM_DATE).equals(""))){
			fromdate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(HrmsRequestConstants.FROM_DATE));
			
		} 
		Date todate = null;
		if(request.getParameter(HrmsRequestConstants.TO_DATE)!=null && !(request.getParameter(HrmsRequestConstants.TO_DATE).equals(""))) {
			todate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(HrmsRequestConstants.TO_DATE));
		}
		
	
		Map<String, Object> connectionMap = reportHandlerService.getConnectionForReport();
		parameters.put("todate", todate);
		parameters.put("fromdate", fromdate);
		parameters.put("companyid", hospitalId);
		parameters.put("sqlquery", querySql);
		parameters.put("billable", billable);
		
		try {
			HMSUtil.generateReport("Department_Project_Wise_Cost", parameters,(Connection) connectionMap.get("conn"), response,getServletContext());
			//if (projectId > 0 && billableType.equals("Billable") ) {
			
			/*}else if(projectId > 0 && billableType.equals("NonBillable")){
				HMSUtil.generateReport("Department_Project_Wise_Cost", parameters,(Connection) connectionMap.get("conn"), response,getServletContext());
			
			}else if(projectId > 0 && billableType.equals("All")){
					HMSUtil.generateReport("Department_Project_Wise_Cost", parameters,(Connection) connectionMap.get("conn"), response,getServletContext());
				
			}else if(projectId == 0 && billableType.equals("Billable")){
				HMSUtil.generateReport("Department_Project_Wise_Cost", parameters,(Connection) connectionMap.get("conn"), response,getServletContext());
			
			}else if(projectId == 0 && billableType.equals("NonBillable")){
				HMSUtil.generateReport("Department_Project_Wise_Cost", parameters,(Connection) connectionMap.get("conn"), response,getServletContext());
			}
			else if(projectId == 0 && billableType.equals("All")){
				HMSUtil.generateReport("Department_Project_Wise_Cost", parameters,(Connection) connectionMap.get("conn"), response,getServletContext());
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Department_Project_Wise_Cost");

		return null;

	}
	public ModelAndView printResourceTimePerTaskPerProjectPerSite(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Department_Resource_Time_Per_Task_Per_project_Per_Site", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Department_Resource_Time_Per_Task_Per_project_Per_Site");

		return null;

	}
	public ModelAndView showDepartmentResourceWiseSiteJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showProjectResourceTimeReport();
		String jsp = DEPARTMENT_RESOURCE_WISE_SITE;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printDepartmentResourceWiseSiteJsp(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			if (request.getParameter(EMPLOYEE_ID) != null
					&& !request.getParameter(EMPLOYEE_ID).equals("")) {
				int empId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
				parameters.put("emp_id", empId);
			}						

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Department_Resource_Wise_Site", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Department_Resource_Wise_Site");

		return null;

	}
	public ModelAndView printAllSponsor(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Sponsor_ALL", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Sponsor_ALL");

		return null;

	}
	public ModelAndView showSponsorWiseProjectJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showProjectResourceTimeReport();
		String jsp = SPONSOR_WISE_PROJECT;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printSponsorWiseProject(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			if (request.getParameter(SPONSOR_ID) != null
					&& !request.getParameter(SPONSOR_ID).equals("")) {
				int sponsorId = Integer.parseInt(request.getParameter(SPONSOR_ID));
				parameters.put("Sponser_id", sponsorId);
			}						

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Sponser_Wise_Project", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Sponser_Wise_Project");

		return null;

	}
	public ModelAndView showProjectPerResourceJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showProjectResourceTimeReport();
		String jsp = PROJECT_PER_RESOURCE;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printProjectPerResource(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			if (request.getParameter(EMPLOYEE_ID) != null
					&& !request.getParameter(EMPLOYEE_ID).equals("")) {
				int empId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
				parameters.put("emp_id", empId);
			}						

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Resource_Project_per_Resource", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Resource_Project_per_Resource");

		return null;

	}
	public ModelAndView showTotalResourceTimePerProjectJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showProjectResourceTimeReport();
		String jsp = TOTAL_RESOURCE_TIME_PER_PROJECT;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printTotalResourceTimePerProject(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			if (request.getParameter(EMPLOYEE_ID) != null
					&& !request.getParameter(EMPLOYEE_ID).equals("")) {
				int empId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
				parameters.put("emp_id", empId);
			}						

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Resource_Total_Time_Resource", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Resource_Total_Time_Resource");

		return null;

	}
	public ModelAndView printTotalResourceTimePerTaskPerProject(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Resource_Time_Task_project_Site", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Resource_Time_Task_project_Site");

		return null;

	}
	public ModelAndView showResourceCostPerProjectJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showProjectResourceTimeReport();
		String jsp = RESOURCE_COST_PER_PROJECT;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printResourceCostPerProject(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			if (request.getParameter(EMPLOYEE_ID) != null
					&& !request.getParameter(EMPLOYEE_ID).equals("")) {
				int empId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
				parameters.put("emp_id", empId);
			}						

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Resource_cost", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Resource_cost");

		return null;

	}
	public ModelAndView printResourceCostPerTaskSiteWise(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Resource_Cost_Task_project_Site", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Resource_Cost_Task_project_Site");

		return null;

	}
	public ModelAndView printAllVendors(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Vender_All", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Vender_All");

		return null;

	}
	public ModelAndView showProjectVendorWiseJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showProjectResourceTimeReport();
		String jsp = PROJECT_VENDOR_WISE;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printProjectVendorWise(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			if (request.getParameter(PROJECT_ID) != null
					&& !request.getParameter(PROJECT_ID).equals("")) {
				int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
				parameters.put("Project_id", projectId);
			}						

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Vendor_Project_wise", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Vendor_Project_wise");

		return null;

	}
	public ModelAndView showSitePerProjectJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showProjectResourceTimeReport();
		String jsp = SITE_PER_PROJECT;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printSitePerProject(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			if (request.getParameter(PROJECT_ID) != null
					&& !request.getParameter(PROJECT_ID).equals("")) {
				int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
				parameters.put("Project_id", projectId);
			}						

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Site_Per_Project", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Site_Per_Project");

		return null;

	}
	public ModelAndView printAllSites(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Sites_All", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Sites_All");

		return null;

	}
	public ModelAndView showSiteVitalsJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showProjectResourceTimeReport();
		String jsp = SITE_VITALS;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printSiteVitals(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			if (request.getParameter(PROJECT_ID) != null
					&& !request.getParameter(PROJECT_ID).equals("")) {
				int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
				parameters.put("Project_id", projectId);
			}						

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Site_Vitals", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Site_Vitals");

		return null;

	}
	public ModelAndView showSiteStatusJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showProjectResourceTimeReport();
		String jsp = SITE_STATUS;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printSiteStatus(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			if (request.getParameter(PROJECT_ID) != null
					&& !request.getParameter(PROJECT_ID).equals("")) {
				int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
				parameters.put("Project_id", projectId);
			}						

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Site_status", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Site_status");

		return null;

	}
	public ModelAndView showPatientVisitStatusPerProjectJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showProjectResourceTimeReport();
		String jsp = PATIENT_VISIT_STATUS_PER_PROJECT;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showPatientStatusPerProjectJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showProjectResourceTimeReport();
		String jsp = PATIENT_STATUS_PER_PROJECT;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printPatientVisitStatusPerProject(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			if (request.getParameter(PROJECT_ID) != null
					&& !request.getParameter(PROJECT_ID).equals("")) {
				int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
				parameters.put("Project_id", projectId);
			}						

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Sites_Patient_visit_status_per_project", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Sites_Patient_visit_status_per_project");

		return null;

	}
	public ModelAndView showSiteCalendarJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showProjectResourceTimeReport();
		String jsp = SITE_CALENDAR;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printSiteCalendar(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			if (request.getParameter(PROJECT_ID) != null
					&& !request.getParameter(PROJECT_ID).equals("")) {
				int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
				parameters.put("Project_id", projectId);
			}						

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Site_Calendar", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Site_Calendar");

		return null;

	}
	public ModelAndView showVisitMonitoringStatusPerProjectJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showProjectResourceTimeReport();
		String jsp = VISIT_MONITORING_STATUS_PER_PROJECT;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printVisitMonitoringStatusPerProject(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			if (request.getParameter(PROJECT_ID) != null
					&& !request.getParameter(PROJECT_ID).equals("")) {
				int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
				parameters.put("Project_id", projectId);
			}						

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Sites_visit_monitor_Per_project", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Sites_visit_monitor_Per_project");

		return null;

	}
	public ModelAndView printVisitMonitoringStatusAllProject(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Sites_visit_monitor_all_project", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Sites_visit_monitor_all_project");

		return null;

	}
	public ModelAndView printSitePatientVisitAllProject(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Sites_Patient_visit_all_project", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Sites_Patient_visit_all_project");

		return null;

	}
	public ModelAndView showSiteProjectWiseJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showProjectResourceTimeReport();
		String jsp = SITE_PROJECT_WISE;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printSiteProjectWise(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			if (request.getParameter(PROJECT_ID) != null
					&& !request.getParameter(PROJECT_ID).equals("")) {
				int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
				parameters.put("Project_id", projectId);
			}						

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Site_Project_Wise", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Site_Project_Wise");

		return null;

	}
	public ModelAndView showSitePIJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showProjectResourceTimeReport();
		String jsp = SITE_PI;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printSitePI(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			if (request.getParameter(SITE_ID) != null
					&& !request.getParameter(SITE_ID).equals("")) {
				int siteId = Integer.parseInt(request.getParameter(SITE_ID));
				parameters.put("Site_id", siteId);
			}						

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Site_PI", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Site_PI");

		return null;

	}
	public ModelAndView printProjectStatus(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Project_Patient_Status", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Project_Patient_Status");

		return null;

	}

	public ModelAndView printSitesPatientStatusAllProject(HttpServletRequest request,HttpServletResponse response) {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();

		try {
			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("Sites_Patient_status_all_project", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Sites_Patient_status_all_project");

		return null;

	}
	public ModelAndView showEmpLeaveReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showEmployeeLeaveTypeReport();
		String jsp = EMP_LEAVE_REPORT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printEmpLeaveReport(HttpServletRequest request,
			HttpServletResponse response) {
		byte[] bytes = null;
		Map<String, Object> parameters = new HashMap();
		String selRadio = "";
		
		Date fromDate = null;
		Date toDate = null;
		String fromDateString = "";
		String toDateString = "";
		String query = "";
		String query_depart = "";
		String query_emp = "";
		String query_from_to_date = "";
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			mapForDs.put("hospitalId", hospitalId);
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Map<String, Object> connectionMap = reportHandlerService.getConnectionForReport();

			if(request.getParameter(SELECTED_RADIO) != null){
				selRadio = request.getParameter(SELECTED_RADIO);
			}
			if(request.getParameter(FROM_DATE) != null
					&& !request.getParameter(FROM_DATE).equals("")){
				fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
				fromDateString = sdf.format(fromDate);
				parameters.put("fromDate", fromDate);
			}
			if(request.getParameter(TO_DATE) != null
					&& !request.getParameter(FROM_DATE).equals("")){
				toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
				toDateString = sdf.format(toDate);
				parameters.put("toDate", toDate);
			}
			if(!fromDateString.equals("") && !toDateString.equals("")){
				query_from_to_date = " and hr_leave_details.`applied_on` between '"+ fromDateString +"' and '" +toDateString+"'";				
			}
			List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
			String companyname = "";
			map = reportHandlerService.getHospitalName(mapForDs);
			if(map.get("masHospitalList") != null){
				masHospitalList = (List)map.get("masHospitalList");
			}
			if(masHospitalList.size() > 0){
				companyname = masHospitalList.get(0).getHospitalName();
			}

			parameters.put("companyname", companyname);
			
			parameters.put("SUBREPORT_DIR",getServletContext().getRealPath("//Reports//"));
			parameters.put("QUERY_FROMDATE_TODATE", query_from_to_date);
			
			if(selRadio.equals("empWise")){
				int empId = 0;
				if(request.getParameter("empcode") != null
						&& !request.getParameter("empcode").equals("")){
					empId = Integer.parseInt(request.getParameter("empcode"));
					parameters.put("empID", empId);
				}
				if(empId == 0){
					HMSUtil.generateReport("emp_leave_report", parameters, (Connection)connectionMap.get("conn"), response, getServletContext());					
				}else{
					HMSUtil.generateReport("emp_individual_leave_report", parameters, (Connection)connectionMap.get("conn"), response, getServletContext());
				}
			}else{
				int companyId = 0;
				int deptId = 0;
				int empId = 0;
				if(request.getParameter(RequestConstants.COMPANY) != null
						&& !request.getParameter(RequestConstants.COMPANY).equals("")){
					companyId = Integer.parseInt(request.getParameter(RequestConstants.COMPANY));
					query = " and m.`hospital_id`="+companyId;
					parameters.put("companyId", companyId);
					parameters.put("QUERY", query);
				}
				if(request.getParameter(RequestConstants.DEPARTMENT_ID) != null
						&& !request.getParameter(RequestConstants.DEPARTMENT_ID).equals("")){
					deptId = Integer.parseInt(request.getParameter(RequestConstants.DEPARTMENT_ID));
					query_depart = " and m.`department_id`="+deptId;
					parameters.put("deptId", deptId);
					parameters.put("QUERY_DEPART", query_depart);
				}
				if(request.getParameter(RequestConstants.EMPLOYEE_ID) != null
						&& !request.getParameter(RequestConstants.EMPLOYEE_ID).equals("")){
					empId = Integer.parseInt(request.getParameter(RequestConstants.EMPLOYEE_ID));
					query_emp = " and employee_id="+empId;
					parameters.put("empId", empId);
					parameters.put("QUERY_EMP", query_emp);
				}
				HMSUtil.generateReport("emp_leave_report", parameters, (Connection)connectionMap.get("conn"), response, getServletContext());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ModelAndView getDepartmentForCompany(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		int hospitalId = 0;
		if(request.getParameter(RequestConstants.COMPANY) != null
				&& !request.getParameter(RequestConstants.COMPANY).equals("")){
			hospitalId = Integer.parseInt(request.getParameter(RequestConstants.COMPANY));
			mapForDs.put("hospitalId", hospitalId);
		}
		
		map = reportHandlerService.getDepartmentForCompany(mapForDs);
		String jsp = DEPART_FOR_COMPANY_JSP;
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView getEmpForDepartment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		int departId = 0;
		if(request.getParameter(DEPARTMENT_ID) != null
				&& !request.getParameter(DEPARTMENT_ID).equals("")){
			departId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			mapForDs.put("departId", departId);
		}
		
		map = reportHandlerService.getEmpForDepartment(mapForDs);
		String jsp = EMP_FOR_DEPART_JSP;
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	
	// ================================Project Tracking Report End=====================================
	// ================================Project Tracking Excel Report =====================================
	public ModelAndView showPatientEnrollmentJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Users user = null;
		HttpSession session = request.getSession();
		
		if (session.getAttribute(USERS) != null) {
			user = (Users) session.getAttribute(USERS);
		}
		map = reportHandlerService.showPatientEnrollmentJsp(mapForDs);
		
		String jsp = PATIENT_ENROLLMENT_JSP;
		jsp += ".jsp";
		
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView printPatientEnrollmentReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		
		
		if(request.getParameter(PROJECT_ID) != null && !request.getParameter(PROJECT_ID).equals("")){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID).toString());
			mapForDs.put("projectId", projectId);
		}
		if(request.getParameter(SITE_ID) != null && !request.getParameter(SITE_ID).equals("")){
			int siteId = Integer.parseInt(request.getParameter(SITE_ID).toString());
			mapForDs.put("siteId", siteId);
		}
		if(request.getParameter(HrmsRequestConstants.FROM_DATE)!=null && !(request.getParameter(HrmsRequestConstants.FROM_DATE).equals(""))){
			Date fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(HrmsRequestConstants.FROM_DATE));
			mapForDs.put("fromDate", fromDate);
		} 
		if(request.getParameter(HrmsRequestConstants.TO_DATE)!=null && !(request.getParameter(HrmsRequestConstants.TO_DATE).equals(""))) {
			Date toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(HrmsRequestConstants.TO_DATE));
			mapForDs.put("toDate", toDate);
		}
		
		
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HttpSession session = request.getSession(true);
		
		map = reportHandlerService.printPatientEnrollmentReportExcel(mapForDs);
		wb = (HSSFWorkbook)map.get("wb");
		try{
			String file = "PatientEnrollmentReport.xls";
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment; filename="+ file);
			
			wb.write(response.getOutputStream());
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
			
		}
		return null;
	}
	public ModelAndView showPatientWiseVisitJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Users user = null;
		HttpSession session = request.getSession();
		
		if (session.getAttribute(USERS) != null) {
			user = (Users) session.getAttribute(USERS);
		}
		map = reportHandlerService.showPatientEnrollmentJsp(mapForDs);
		
		String jsp = PATIENT_WISE_VISIT_REPORT_JSP;
		jsp += ".jsp";
		
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printPatientWiseVisitReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		
		
		if(request.getParameter(PROJECT_ID) != null && !request.getParameter(PROJECT_ID).equals("")){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID).toString());
			mapForDs.put("projectId", projectId);
		}
		if(request.getParameter(SITE_ID) != null && !request.getParameter(SITE_ID).equals("")){
			int siteId = Integer.parseInt(request.getParameter(SITE_ID).toString());
			mapForDs.put("siteId", siteId);
		}
		if(request.getParameter(HrmsRequestConstants.FROM_DATE)!=null && !(request.getParameter(HrmsRequestConstants.FROM_DATE).equals(""))){
			Date fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(HrmsRequestConstants.FROM_DATE));
			mapForDs.put("fromDate", fromDate);
		} 
		if(request.getParameter(HrmsRequestConstants.TO_DATE)!=null && !(request.getParameter(HrmsRequestConstants.TO_DATE).equals(""))) {
			Date toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(HrmsRequestConstants.TO_DATE));
			mapForDs.put("toDate", toDate);
		}
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HttpSession session = request.getSession(true);
		
		map = reportHandlerService.printPatientWiseVisitReport(mapForDs);
		wb = (HSSFWorkbook)map.get("wb");
		try{
			String file = "PatientWiseVisitReport.xls";
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment; filename="+ file);
			
			wb.write(response.getOutputStream());
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
			
		}
		return null;
	}
	
	public ModelAndView showSitePaymentReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Users user = null;
		HttpSession session = request.getSession();
		
		if (session.getAttribute(USERS) != null) {
			user = (Users) session.getAttribute(USERS);
		}
		map = reportHandlerService.showPatientEnrollmentJsp(mapForDs);
		
		String jsp = SITE_PAYMENT_REPORT_JSP;
		jsp += ".jsp";
		
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printSitePaymentReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		
		if(request.getParameter(PROJECT_ID) != null && !request.getParameter(PROJECT_ID).equals("")){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID).toString());
			mapForDs.put("projectId", projectId);
		}
		if(request.getParameter(SITE_ID) != null && !request.getParameter(SITE_ID).equals("")){
			int siteId = Integer.parseInt(request.getParameter(SITE_ID).toString());
			mapForDs.put("siteId", siteId);
		}
		if(request.getParameter(HrmsRequestConstants.FROM_DATE)!=null && !(request.getParameter(HrmsRequestConstants.FROM_DATE).equals(""))){
			Date fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(HrmsRequestConstants.FROM_DATE));
			mapForDs.put("fromDate", fromDate);
		} 
		if(request.getParameter(HrmsRequestConstants.TO_DATE)!=null && !(request.getParameter(HrmsRequestConstants.TO_DATE).equals(""))) {
			Date toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(HrmsRequestConstants.TO_DATE));
			mapForDs.put("toDate", toDate);
		}
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HttpSession session = request.getSession(true);
		
		map = reportHandlerService.printSitePaymentReport(mapForDs);
		wb = (HSSFWorkbook)map.get("wb");
		try{
			String file = "SitePaymentReport.xls";
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment; filename="+ file);
			
			wb.write(response.getOutputStream());
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
			
		}
		return null;
	}
	public ModelAndView showProjectDetailReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Users user = null;
		HttpSession session = request.getSession();
		
		if (session.getAttribute(USERS) != null) {
			user = (Users) session.getAttribute(USERS);
		}
		map = reportHandlerService.showPatientEnrollmentJsp(mapForDs);
		
		String jsp = PROJECT_DETAIL_REPORT_JSP;
		jsp += ".jsp";
		
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printProjectDetailReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		if(request.getParameter(PROJECT_ID) != null && !request.getParameter(PROJECT_ID).equals("")){
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID).toString());
			mapForDs.put("projectId", projectId);
		}
		
		HSSFWorkbook wb = new HSSFWorkbook();
		
		map = reportHandlerService.printProjectDetailReport(mapForDs);
		wb = (HSSFWorkbook)map.get("wb");
		try{
			String file = "ProjectDetailReport.xls";
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment; filename="+ file);
			
			wb.write(response.getOutputStream());
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
			
		}
		return null;
	}
	public ModelAndView showDepartmentWiseProjectTimeReport(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showDepartmentWiseProjectTimeReport();
		String jsp = "hr_departmentWiseProjectTimeReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printDepartmentWiseProjectTimeReport(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		byte[] bytes = null;
		Map parameters = new HashMap();
		ServletContext context = request.getSession().getServletContext();
		HttpSession session = request.getSession();
		String querySql = "";
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		int projectId = 0;
		if(request.getParameter("projectId")!= null ){
			projectId = Integer.parseInt(request.getParameter("projectId"));
		}
		int employeeId = 0;
		if(!request.getParameter(EMPLOYEE_ID).equals("0")){
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			querySql = querySql + " and emp.employee_id = "+employeeId;
		}
		int departmentId = 0;
		if(!request.getParameter(DEPARTMENT_ID).equals("0") ){
			departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			querySql = querySql + " and dep.department_id = "+departmentId;
		}
		String billableType = "";
		if(!request.getParameter("billable").equals("0")){
			billableType = request.getParameter("billable");
			querySql = querySql + " and p1.Billable = "+"'"+billableType+"'";
		}
		String billable = "";
		if(billableType.equals("y")){
			billable = "Billable";
		}else if(billableType.equals("n")){
			billable = "Non-Billable";
		}else{
			billable = "All";
		}
		Date fromdate = null;
		if(request.getParameter(HrmsRequestConstants.FROM_DATE)!=null && !(request.getParameter(HrmsRequestConstants.FROM_DATE).equals(""))){
			fromdate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(HrmsRequestConstants.FROM_DATE));
			
		} 
		Date todate = null;
		if(request.getParameter(HrmsRequestConstants.TO_DATE)!=null && !(request.getParameter(HrmsRequestConstants.TO_DATE).equals(""))) {
			todate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(HrmsRequestConstants.TO_DATE));
		}
		
	
		Map<String, Object> connectionMap = reportHandlerService.getConnectionForReport();
		parameters.put("todate", todate);
		parameters.put("fromdate", fromdate);
		parameters.put("sqlquery", querySql);
		parameters.put("billable", billable);
		parameters.put("Project_id", projectId);
		parameters.put("companyid", hospitalId);
		
			
			
	try {
			HMSUtil.generateReport("department_wise_project_time", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "department_wise_project_time");
		return null;
}
	public ModelAndView showDepartmentWiseProjectCostReport(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showDepartmentWiseProjectCostReport();
		String jsp = "hr_departmentWiseProjectCostReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printDepartmentWiseProjectCostReport(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		byte[] bytes = null;
		Map parameters = new HashMap();
		ServletContext context = request.getSession().getServletContext();
		HttpSession session = request.getSession();
		String querySql = "";
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		int projectId = 0;
		if(request.getParameter("projectId")!= null ){
			projectId = Integer.parseInt(request.getParameter("projectId"));
			querySql = querySql + " and p.prj_id = "+projectId;
		}
		int employeeId = 0;
		if(!request.getParameter(EMPLOYEE_ID).equals("0")){
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			querySql = querySql + " and e.employee_id = "+employeeId;
		}
		int departmentId = 0;
		if(!request.getParameter(DEPARTMENT_ID).equals("0") ){
			departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			querySql = querySql + " and d.department_id = "+departmentId;
		}
		String billableType = "";
		if(!request.getParameter("billable").equals("0")){
			billableType = request.getParameter("billable");
			querySql = querySql + " and p.Billable = "+"'"+billableType+"'";
		}
		String billable = "";
		if(billableType.equals("y")){
			billable = "Billable";
		}else if(billableType.equals("n")){
			billable = "Non-Billable";
		}else{
			billable = "All";
		}
		Date fromdate = null;
		if(request.getParameter(HrmsRequestConstants.FROM_DATE)!=null && !(request.getParameter(HrmsRequestConstants.FROM_DATE).equals(""))){
			fromdate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(HrmsRequestConstants.FROM_DATE));
			
		} 
		Date todate = null;
		if(request.getParameter(HrmsRequestConstants.TO_DATE)!=null && !(request.getParameter(HrmsRequestConstants.TO_DATE).equals(""))) {
			todate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(HrmsRequestConstants.TO_DATE));
		}
		
	
		Map<String, Object> connectionMap = reportHandlerService.getConnectionForReport();
		parameters.put("todate", todate);
		parameters.put("fromdate", fromdate);
		parameters.put("sqlquery", querySql);
		parameters.put("billable", billable);
		parameters.put("Project_id", projectId);
		parameters.put("companyid", hospitalId);
		
			
	try {
			HMSUtil.generateReport("Department_Project_Wise_Cost and_time", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "Department_Project_Wise_Cost and_time");
		return null;
	}
	public ModelAndView showRecruitmentStatusReportJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String jsp = "recruitment_status";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printRecruitmentStatusReport(HttpServletRequest request,HttpServletResponse response) {
		Map parameters = new HashMap();
		Date fromDate = null;
		Date toDate = null;
		Map<String, Object> map = new HashMap();
		Map<String, Object> mapForDs = new HashMap();
		HttpSession session = request.getSession();

		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			mapForDs.put("hospitalId", hospitalId);
		}
		try {
			if (request.getParameter(FROM_DATE) != null) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			}
			if (request.getParameter(TO_DATE) != null) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			}
			parameters.put("FDate", fromDate);
			parameters.put("TDate", toDate);
			Map<String, Object> connectionMap = reportHandlerService.getConnectionForReport();
			HMSUtil.generateReport("RecruitmentStatus", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
		
	//added by Ramdular from Clinirx 02/02/2011 --------------------------
}
