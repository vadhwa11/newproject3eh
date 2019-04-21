package jkt.hrms.payroll.controller;

import static jkt.hrms.util.HrmsRequestConstants.ADVANCE_AMOUNT;
import static jkt.hrms.util.HrmsRequestConstants.BONUS_AMOUNT;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_BY;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_DATE;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_TIME;
import static jkt.hrms.util.HrmsRequestConstants.DEPARTMENT_ID;
import static jkt.hrms.util.HrmsRequestConstants.EMPLOYEE_ID;
import static jkt.hrms.util.HrmsRequestConstants.EMP_CATEGORY_ID;
import static jkt.hrms.util.HrmsRequestConstants.FLAG;
import static jkt.hrms.util.HrmsRequestConstants.HR_EARNING_DEDUCTION_JSP;
import static jkt.hrms.util.HrmsRequestConstants.HR_EMPLOYEE_HOLD_SALARY_JSP;
import static jkt.hrms.util.HrmsRequestConstants.HR_INCREMENT_MONTH_STATEMENT_JSP;
import static jkt.hrms.util.HrmsRequestConstants.HR_INDIVIDUAL_PAY_REPORT_JSP;
import static jkt.hrms.util.HrmsRequestConstants.HR_MONTHLY_BANK_ADVICE;
import static jkt.hrms.util.HrmsRequestConstants.HR_PAY_SLIP_JSP;
import static jkt.hrms.util.HrmsRequestConstants.HR_POST_PAYROLL_JSP;
import static jkt.hrms.util.HrmsRequestConstants.HR_PRE_PAYROLL_JSP;
import static jkt.hrms.util.HrmsRequestConstants.HR_SALARY_REGISTER_REPORT_JSP;
import static jkt.hrms.util.HrmsRequestConstants.HR_SEARCH_PRE_PAYROLL_PROCESS_JSP;
import static jkt.hrms.util.HrmsRequestConstants.HR_SERVICE_STATEMENT_JSP;
import static jkt.hrms.util.HrmsRequestConstants.HR_STAFF_PERSONNEL_DETAILS_JSP;
import static jkt.hrms.util.HrmsRequestConstants.HR_UPDATE_PRE_PAYROLL_PROCESS_JSP;
import static jkt.hrms.util.HrmsRequestConstants.LWP;
import static jkt.hrms.util.HrmsRequestConstants.MONTH;
import static jkt.hrms.util.HrmsRequestConstants.MONTHLY_INSTALLMENT;
import static jkt.hrms.util.HrmsRequestConstants.PAY_ELEMENT_AMOUNT;
import static jkt.hrms.util.HrmsRequestConstants.PAY_ELEMENT_CODE;
import static jkt.hrms.util.HrmsRequestConstants.PAY_ELEMENT_ID;
import static jkt.hrms.util.HrmsRequestConstants.PAY_ELEMENT_TYPE;
import static jkt.hrms.util.HrmsRequestConstants.PRE_PAYROLL_PROCESS_ID;
import static jkt.hrms.util.HrmsRequestConstants.SALARY_DAYS;
import static jkt.hrms.util.HrmsRequestConstants.TOTAL_DAYS;
import static jkt.hrms.util.HrmsRequestConstants.YEAR;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.util.EmployeeComparator;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.HrPayrollProcessHeader;
import jkt.hrms.payroll.handler.PayrollHandlerService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class PayrollController extends MultiActionController {
	PayrollHandlerService payrollHandlerService = null;

	public PayrollHandlerService getPayrollHandlerService() {
		return payrollHandlerService;
	}

	public void setPayrollHandlerService(
			PayrollHandlerService payrollHandlerService) {
		this.payrollHandlerService = payrollHandlerService;
	}

	public ModelAndView showPrePayrollProcessJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = payrollHandlerService.showPrePayrollProcessJsp();
		String jsp = HR_PRE_PAYROLL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView processPrePayrollDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HrPayrollProcessHeader hrPayrollProcessHeader = new HrPayrollProcessHeader();
		HttpSession session = request.getSession();
		List<HrPayrollProcessHeader> hrPayRollProcessHeaderList = new ArrayList();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrPayrollProcessHeader.setHospital(masHospital);

		}

		List<MasEmployee> employeeList = null;
		int departmentId = 0;
		int employeeId = 0;
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(EMPLOYEE_ID) != null) {
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}

		if (departmentId == 0 && employeeId == 0) {
			employeeList = payrollHandlerService.getAllEmployeeList();
		} else if (departmentId != 0 && employeeId == 0) {
			MasDepartment department = payrollHandlerService
					.getDepartment(departmentId);
			Set employeeSet = department.getMasEmployees();
			if (employeeSet != null && employeeSet.size() > 0) {
				employeeList = new ArrayList<MasEmployee>(employeeSet);
				Collections.sort(employeeList, new EmployeeComparator());
			}
		} else if ((departmentId != 0 && employeeId != 0)
				|| (departmentId == 0 && employeeId != 0)) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			hrPayrollProcessHeader.setEmployee(masEmployee);
			// hrPayrollProcessHeader.setDepartment(masEmployee.getDepartment());

		}

		/*
		 * if (request.getParameter(DEPARTMENT_ID)!= null &&
		 * !request.getParameter(DEPARTMENT_ID).equalsIgnoreCase("0")) { int
		 * departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
		 * MasDepartment masDepartment = new MasDepartment();
		 * masDepartment.setId(departmentId); //
		 * hrPayrollProcessHeader.setDepartment(masDepartment); } else {
		 * employeeList = payrollHandlerService.getAllEmployeeList(); }
		 * 
		 * if (request.getParameter(EMPLOYEE_ID)!= null &&
		 * !request.getParameter(EMPLOYEE_ID).equalsIgnoreCase("0")) { int
		 * employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		 * MasEmployee masEmployee = new MasEmployee();
		 * masEmployee.setId(employeeId);
		 * hrPayrollProcessHeader.setEmployee(masEmployee);
		 * hrPayrollProcessHeader.setDepartment(masEmployee.getDepartment()); }
		 * else if(request.getParameter(EMPLOYEE_ID) == null &&
		 * request.getParameter(EMPLOYEE_ID).equals("0") &&
		 * !request.getParameter(DEPARTMENT_ID).equalsIgnoreCase("0")) { Integer
		 * departmentId = new Integer(request.getParameter(DEPARTMENT_ID));
		 * MasDepartment department =
		 * payrollHandlerService.getDepartment(departmentId); Set employeeSet =
		 * department.getMasEmployees(); if(employeeSet!=null &&
		 * employeeSet.size()>0){ employeeList = new
		 * ArrayList<MasEmployee>(employeeSet); Collections.sort(employeeList,
		 * new EmployeeComparator()); } }
		 */

		int month = 0;
		if (request.getParameter(MONTH) != null) {
			month = Integer.parseInt(request.getParameter(MONTH));
			hrPayrollProcessHeader.setMonth(month);
		}
		int year = 0;
		if (request.getParameter(YEAR) != null) {
			year = Integer.parseInt(request.getParameter(YEAR));
			hrPayrollProcessHeader.setYear(year);
		}

		String changedBy = "";
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
			hrPayrollProcessHeader.setLastChgBy(changedBy);
		}

		Date currentDate = new Date();
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
			hrPayrollProcessHeader.setLastChgDate(currentDate);
		}

		String currentTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
			hrPayrollProcessHeader.setLastChgTime(currentTime);
		}
		int count = 0;
		if (employeeList != null && employeeList.size() > 0) {
			for (MasEmployee employee : employeeList) {
				HrPayrollProcessHeader hrPayrollProcessHeader1 = new HrPayrollProcessHeader();
				hrPayrollProcessHeader1.setEmployee(employee);
				hrPayrollProcessHeader1.setDepartment(employee.getDepartment());
				hrPayrollProcessHeader1.setMonth(month);
				hrPayrollProcessHeader1.setYear(year);
				hrPayrollProcessHeader1.setLastChgBy(changedBy);
				hrPayrollProcessHeader1.setLastChgDate(currentDate);
				hrPayrollProcessHeader1.setLastChgTime(currentTime);
				hrPayRollProcessHeaderList.add(hrPayrollProcessHeader1);
				count++;
			}

		} else {
			hrPayRollProcessHeaderList.add(hrPayrollProcessHeader);
		}
		String message = "<b>Salary processed for :</b><br />";
		List<HrPayrollProcessHeader> processedPayrollList = new ArrayList();
		List<HrPayrollProcessHeader> unprocessedPayrollList = new ArrayList();
		try {
			for (HrPayrollProcessHeader hrPayrollProcessHeader2 : hrPayRollProcessHeaderList) {
				generalMap.put("hrPayrollProcessHeader",
						hrPayrollProcessHeader2);
				map = payrollHandlerService.processPrePayrollDetail(generalMap);
				message = message + (String) map.get("message");

				if (map.get("processed") != null) {
					processedPayrollList.add((HrPayrollProcessHeader) map
							.get("processed"));
				}
				if (map.get("unprocessed") != null) {
					unprocessedPayrollList.add((HrPayrollProcessHeader) map
							.get("unprocessed"));
				}
			}
			message = message
					+ "<br /><br /><b> Total no. of employees for which salary processed is"
					+ count + "</b>";
		} catch (Exception e) {
			message = message + "\n\n Problem Occured!!";
			e.printStackTrace();
		}

		map.put("message", message);
		String jsp = HR_PRE_PAYROLL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("year", year);
		map.put("month", month);
		map.put("processedPayrollList", processedPayrollList);
		map.put("unprocessedPayrollList", unprocessedPayrollList);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showSearchPrePayrollProcessJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = payrollHandlerService.showSearchPrePayrollProcessJsp();
		String jsp = HR_SEARCH_PRE_PAYROLL_PROCESS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPrePayrollDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Map<String, Object> generalMap = new HashMap<String, Object>();
		if (request.getParameter(EMPLOYEE_ID) != null) {
			int employeeId = Integer
					.parseInt(request.getParameter(EMPLOYEE_ID));
			generalMap.put("employeeId", employeeId);
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			int departmentId = Integer.parseInt(request
					.getParameter(DEPARTMENT_ID));
			generalMap.put("departmentId", departmentId);
		}
		if (request.getParameter(MONTH) != null) {
			int month = Integer.parseInt(request.getParameter(MONTH));
			generalMap.put("month", month);
		}
		if (request.getParameter(YEAR) != null) {
			int year = Integer.parseInt(request.getParameter(YEAR));
			generalMap.put("year", year);
		}
		map = payrollHandlerService.searchPrePayrollDetail(generalMap);
		String jsp = HR_SEARCH_PRE_PAYROLL_PROCESS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editPrePayrollDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		// HrPayrollProcessHeader hrPayrollProcessHeader = new
		// HrPayrollProcessHeader();
		// List<HrPayrollProcessHeader> prePayrollProcessList = new
		// ArrayList<HrPayrollProcessHeader>();
		String message = "";
		int prePayrollProcessId = 0;
		if (request.getParameter(PRE_PAYROLL_PROCESS_ID) != null) {
			prePayrollProcessId = Integer.parseInt(request
					.getParameter(PRE_PAYROLL_PROCESS_ID));
		}
		String salaryStatus = "";
		if (request.getParameter(FLAG) != null) {
			salaryStatus = request.getParameter(FLAG);
		}
		String jsp = "";

		if (salaryStatus.equals("C")) {
			message = "Data can't be updated Salary Fixed .";
			map.put("message", message);
			jsp = HR_SEARCH_PRE_PAYROLL_PROCESS_JSP;
			jsp += ".jsp";
		} else if (salaryStatus.equals("P")) {
			map = payrollHandlerService
					.editPrePayrollDetail(prePayrollProcessId);
			jsp = HR_UPDATE_PRE_PAYROLL_PROCESS_JSP;
			jsp += ".jsp";
		}
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView updateProcessPrePayrollDetail(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List payElementIdList = new ArrayList();
		List payElementCodeList = new ArrayList();
		List payElementAmountList = new ArrayList();
		List payElementTypeList = new ArrayList();
		if (request.getParameter(PRE_PAYROLL_PROCESS_ID) != null) {
			int prePayrollProcessId = Integer.parseInt(request
					.getParameter(PRE_PAYROLL_PROCESS_ID));
			generalMap.put("prePayrollProcessId", prePayrollProcessId);
		}
		if (request.getParameter(EMPLOYEE_ID) != null) {
			int employeeId = Integer
					.parseInt(request.getParameter(EMPLOYEE_ID));
			generalMap.put("employeeId", employeeId);
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			int departmentId = Integer.parseInt(request
					.getParameter(DEPARTMENT_ID));
			generalMap.put("departmentId", departmentId);
		}
		if (request.getParameter(MONTH) != null) {
			int month = Integer.parseInt(request.getParameter(MONTH));
			generalMap.put("month", month);
		}
		if (request.getParameter(YEAR) != null) {
			int year = Integer.parseInt(request.getParameter(YEAR));
			generalMap.put("year", year);
		}
		if (request.getParameter(LWP) != null) {
			int lwp = Integer.parseInt(request.getParameter(LWP));
			generalMap.put("lwp", lwp);
		}
		if (request.getParameter(TOTAL_DAYS) != null) {
			int totalDays = Integer.parseInt(request.getParameter(TOTAL_DAYS));
			generalMap.put("totalDays", totalDays);
		}
		if (request.getParameter(SALARY_DAYS) != null) {
			int salaryDays = Integer
					.parseInt(request.getParameter(SALARY_DAYS));
			generalMap.put("salaryDays", salaryDays);
		}
		if (request.getParameter(MONTHLY_INSTALLMENT) != null) {
			BigDecimal loanMonthlyInstallment = new BigDecimal(
					request.getParameter(MONTHLY_INSTALLMENT));
			generalMap.put("loanMonthlyInstallment", loanMonthlyInstallment);
		}
		if (request.getParameter(ADVANCE_AMOUNT) != null) {
			BigDecimal advanceAmount = new BigDecimal(
					request.getParameter(ADVANCE_AMOUNT));
			generalMap.put("advanceAmount", advanceAmount);
		}
		if (request.getParameter(BONUS_AMOUNT) != null) {
			BigDecimal bonusAmount = new BigDecimal(
					request.getParameter(BONUS_AMOUNT));
			generalMap.put("bonusAmount", bonusAmount);
		}
		int noOfPayElement = 0;
		if (request.getParameter("counter") != null) {
			noOfPayElement = Integer.parseInt(request.getParameter("counter"));
		}
		for (int j = 0; j < noOfPayElement; j++) {
			if (request.getParameter(PAY_ELEMENT_ID + j) != null) {
				payElementIdList.add(Integer.parseInt(request
						.getParameter(PAY_ELEMENT_ID + j)));
				if (request.getParameter(PAY_ELEMENT_CODE + j) != null) {
					payElementCodeList.add(request
							.getParameter(PAY_ELEMENT_CODE + j));
				}
				if (request.getParameter(PAY_ELEMENT_AMOUNT + j) != null) {
					payElementAmountList.add(new BigDecimal(request
							.getParameter(PAY_ELEMENT_AMOUNT + j)));
				}
				if (request.getParameter(PAY_ELEMENT_TYPE + j) != null) {
					payElementTypeList.add(request
							.getParameter(PAY_ELEMENT_TYPE + j));
				}
			}
		}

		generalMap.put("payElementIdList", payElementIdList);
		generalMap.put("payElementCodeList", payElementCodeList);
		generalMap.put("payElementAmountList", payElementAmountList);
		generalMap.put("payElementTypeList", payElementTypeList);

		map = payrollHandlerService.updateProcessPrePayrollDetail(generalMap);

		String jsp = HR_SEARCH_PRE_PAYROLL_PROCESS_JSP;

		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPostPayrollProcessJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = payrollHandlerService.showPostPayrollProcessJsp();
		String jsp = HR_POST_PAYROLL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView processPostPayrollDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		if (request.getParameter(DEPARTMENT_ID) != null) {
			int departmentId = Integer.parseInt(request
					.getParameter(DEPARTMENT_ID));
			generalMap.put("departmentId", departmentId);
		}
		if (request.getParameter(MONTH) != null) {
			int month = Integer.parseInt(request.getParameter(MONTH));
			generalMap.put("month", month);
		}
		if (request.getParameter(YEAR) != null) {
			int year = Integer.parseInt(request.getParameter(YEAR));
			generalMap.put("year", year);
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			String changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}

		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}

		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			String currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}

		map = payrollHandlerService.processPostPayrollDetail(generalMap);
		String jsp = HR_POST_PAYROLL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showEmployeeHoldSalaryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = HR_EMPLOYEE_HOLD_SALARY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printEmployeeHoldSalaryReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int month = 0;
		if (request.getParameter(MONTH) != null) {
			month = Integer.parseInt(request.getParameter(MONTH));
		}
		int year = 0;
		if (request.getParameter(YEAR) != null) {
			year = Integer.parseInt(request.getParameter(YEAR));
		}
		detailsMap = payrollHandlerService.getConnectionForReport();
		parameters.put("month", month);
		parameters.put("year", year);

		HMSUtil.generateReport("EmployeeHoldSalary", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView showIncrementMonthStatementJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = payrollHandlerService.showIncrementMonthStatementJsp();
		String jsp = HR_INCREMENT_MONTH_STATEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printIncrementMonthStatementReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int month = 0;
		if (request.getParameter(MONTH) != null) {
			month = Integer.parseInt(request.getParameter(MONTH));
		}
		String fromEmpCode = "";
		if (request.getParameter("fromEmpCode") != null) {
			fromEmpCode = request.getParameter("fromEmpCode");
		}

		String toEmpCode = "";
		if (request.getParameter("toEmpCode") != null) {
			toEmpCode = request.getParameter("toEmpCode");
		}
		detailsMap = payrollHandlerService.getConnectionForReport();
		parameters.put("month", month);
		parameters.put("fromEmpCode", fromEmpCode);
		parameters.put("toEmpCode", toEmpCode);

		HMSUtil.generateReport("IncrementMonthStatement", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView showStaffPersonnelDetailsJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = payrollHandlerService.showStaffPersonnelDetailsJsp();
		String jsp = HR_STAFF_PERSONNEL_DETAILS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printStaffPersonnelDetailReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int empStatusId = 0;
		if (request.getParameter("empStatus") != null) {
			empStatusId = Integer.parseInt(request.getParameter("empStatus"));
		}
		String fromEmpCode = "";
		if (request.getParameter("fromEmpCode") != null) {
			fromEmpCode = request.getParameter("fromEmpCode");
		}

		String toEmpCode = "";
		if (request.getParameter("toEmpCode") != null) {
			toEmpCode = request.getParameter("toEmpCode");
		}
		detailsMap = payrollHandlerService.getConnectionForReport();
		parameters.put("empStatusId", empStatusId);
		parameters.put("fromEmpCode", fromEmpCode);
		parameters.put("toEmpCode", toEmpCode);

		HMSUtil.generateReport("StaffPersonalDetail", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView showServiceStatementJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = payrollHandlerService.showServiceStatementJsp();
		String jsp = HR_SERVICE_STATEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printServiceStatementReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String fromEmpCode = "";
		if (request.getParameter("fromEmpCode") != null) {
			fromEmpCode = request.getParameter("fromEmpCode");
		}

		String toEmpCode = "";
		if (request.getParameter("toEmpCode") != null) {
			toEmpCode = request.getParameter("toEmpCode");
		}
		detailsMap = payrollHandlerService.getConnectionForReport();
		parameters.put("fromEmpCode", fromEmpCode);
		parameters.put("toEmpCode", toEmpCode);

		HMSUtil.generateReport("ServiceStatement", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView showPaySlipJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = payrollHandlerService.showPaySlipJsp();
		String jsp = HR_PAY_SLIP_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printPaySlipReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		int empId = 0;
		int month = 0;
		int year = 0;
		String monthInString = "";
		try {
			if (request.getParameter("fromEmpId") != null) {
				empId = Integer.parseInt(request.getParameter("fromEmpId"));
			}

			if (request.getParameter(MONTH) != null) {
				month = Integer.parseInt(request.getParameter(MONTH));
			}

			if (request.getParameter("monthString") != null) {
				monthInString = request.getParameter("monthString");
			}

			if (request.getParameter(YEAR) != null) {
				year = Integer.parseInt(request.getParameter(YEAR));
			}

			detailsMap = payrollHandlerService.getConnectionForReport();

			parameters.put("month", month);
			parameters.put("year", year);
			parameters.put("empId", empId);

			HMSUtil.generateReport("paySlip", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView showEarningAndDeductionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = payrollHandlerService.showEarningAndDeductionJsp();
		String jsp = HR_EARNING_DEDUCTION_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printEarningAndDeductionReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int empId = 0;
		if (request.getParameter(EMPLOYEE_ID) != null
				&& !request.getParameter(EMPLOYEE_ID).equals("")) {
			empId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		int empCategoryId = 0;
		if (request.getParameter(EMP_CATEGORY_ID) != null
				&& !request.getParameter(EMP_CATEGORY_ID).equals("")) {
			empCategoryId = Integer.parseInt(request
					.getParameter(EMP_CATEGORY_ID));
		}
		int month = 0;
		if (request.getParameter(MONTH) != null) {
			month = Integer.parseInt(request.getParameter(MONTH));
		}
		String monthInString = "";
		if (request.getParameter("monthString") != null) {
			monthInString = request.getParameter("monthString");
		}
		int year = 0;
		if (request.getParameter(YEAR) != null) {
			year = Integer.parseInt(request.getParameter(YEAR));
		}

		detailsMap = payrollHandlerService.getConnectionForReport();

		parameters.put("empId", empId);
		parameters.put("month", month);
		parameters.put("year", year);
		parameters.put("monthInString", monthInString);
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));

		HMSUtil.generateReport("earningAndDeduction", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView showMonthlyBankAdviceReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = payrollHandlerService.showMonthlyBankAdviceReportJsp();
		String jsp = HR_MONTHLY_BANK_ADVICE;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printMonthlyBankAdvice(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String fromEmpCode = "";
		if (request.getParameter("fromEmpCode") != null) {
			fromEmpCode = request.getParameter("fromEmpCode");
		}

		String toEmpCode = "";
		if (request.getParameter("toEmpCode") != null) {
			toEmpCode = request.getParameter("toEmpCode");
		}
		int month = 0;
		if (request.getParameter(MONTH) != null) {
			month = Integer.parseInt(request.getParameter(MONTH));
		}
		int year = 0;
		if (request.getParameter(YEAR) != null) {
			year = Integer.parseInt(request.getParameter(YEAR));
		}

		detailsMap = payrollHandlerService.getConnectionForReport();
		parameters.put("fromempcode", fromEmpCode);
		parameters.put("toempcode", toEmpCode);
		parameters.put("month", month);
		parameters.put("year", year);

		HMSUtil.generateReport("monthly_bank_advice", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView showIndividualPayJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = payrollHandlerService.showIndividualPayJsp();
		String jsp = HR_INDIVIDUAL_PAY_REPORT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printIndividualPayReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int empId = 0;
		if (request.getParameter(EMPLOYEE_ID) != null) {
			empId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		int year = 0;
		if (request.getParameter(YEAR) != null) {
			year = Integer.parseInt(request.getParameter(YEAR));
		}

		detailsMap = payrollHandlerService.getConnectionForReport();
		parameters.put("empId", empId);
		parameters.put("year", year);
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));
		HMSUtil.generateReport("IndividualPayRecord", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView showSalaryRegisterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = payrollHandlerService.showSalaryRegisterJsp();
		String jsp = HR_SALARY_REGISTER_REPORT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printSalaryRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String fromEmpCode = "";
		if (request.getParameter("fromEmpCode") != null) {
			fromEmpCode = request.getParameter("fromEmpCode");
		}
		String toEmpCode = "";
		if (request.getParameter("toEmpCode") != null) {
			toEmpCode = request.getParameter("toEmpCode");
		}
		int month = 0;
		if (request.getParameter(MONTH) != null) {
			month = Integer.parseInt(request.getParameter(MONTH));
		}
		int year = 0;
		if (request.getParameter(YEAR) != null) {
			year = Integer.parseInt(request.getParameter(YEAR));
		}

		detailsMap = payrollHandlerService.getConnectionForReport();
		parameters.put("fromEmpCode", fromEmpCode);
		parameters.put("toEmpCode", toEmpCode);
		parameters.put("year", year);
		parameters.put("month", month);
		HMSUtil.generateReport("SalaryRegisterReport", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

}
