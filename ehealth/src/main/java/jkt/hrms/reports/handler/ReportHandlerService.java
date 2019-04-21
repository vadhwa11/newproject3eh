package jkt.hrms.reports.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hrms.masters.business.MstrTask;

public interface ReportHandlerService {
	public Map<String, Object> showPrintHrEmployeeExpirience();

	public Map<String, Object> getConnectionForReport();

	public Map<String, Object> showPrintReimbursement();

	public Map<String, Object> pvgetConnectionReport();

	public Map<String, Object> showPrintEmpDetail();

	public Map<String, Object> showPrintLeaveStatement();

	public Map<String, Object> showEmployeeLeaveCard();

	public Map<String, Object> showloanstatement();

	public Map<String, Object> showpayscale();
	
//added by Ramdular from Clinirx 02/02/2011 ++++++++++++++++++
	public Map<String, Object> showEmployeeList();

	public Map<String, Object> showDepartmentJsp();

	Map<String, Object> showStatusWiseTimeSheetReportJsp();

	public Map<String, Object> showTimeSheetProjectWiseJsp(int employeeId);

	public Map<String, Object> showTimeSheetTaskWiseJsp();

	public Map<String, Object> showEmpExpSummary();

	public Map<String, Object> showEmpServiceCard();

  // public List<MstrTask> getTaskList(Integer projectId);
	
	public Map<String, Object> showEmployeeTypeReport();

	public Map<String, Object> showEmpPerformanceReviewCard();

	public Map<String, Object> showEmpCTCAnnexure();

	public Map<String, Object> showEmpSalaryComp();

	public Map<String, Object> showEmployeeInvestment();

	public Map<String, Object> showTDSStatement();

	public Map<String, Object> showIncomeTaxSheet();

	public Map<String, Object> showForm6A();

	public Map<String, Object> showTDSDeposit();

	public Map<String, Object> showPFStatement();

	public int getMinHrsForTimeSheet(int noOfDays, int countOfSatSun,
			Date fromDate, Date toDate);

	public Map<String, Object> showEmployeeLeaveTypeReport();

	public Map<String, Object> showPIReport();

	Map<String, Object> showProjectResourceTimeReport();

	public Map<String, Object> showProjectSiteAllocationReport();

	public Map<String, Object> getDepartmentForCompany(
			Map<String, Object> mapForDs);

	public Map<String, Object> getEmpForDepartment(Map<String, Object> mapForDs);

	public Map<String, Object> showPatientEnrollmentJsp(
			Map<String, Object> mapForDs);

	public Map<String, Object> printPatientEnrollmentReportExcel(
			Map<String, Object> mapForDs);

	public Map<String, Object> printPatientWiseVisitReport(
			Map<String, Object> mapForDs);

	public Map<String, Object> printSitePaymentReport(
			Map<String, Object> mapForDs);

	public Map<String, Object> printProjectDetailReport(
			Map<String, Object> mapForDs);

	public Map<String, Object> getHospitalName(Map<String, Object> mapForDs);

	public Map<String, Object> getEmpCodeSelectedEmployees(
			Map<String, Object> mapForDs);

	public Map<String, Object> showProjectWiseCostReport();

	public Map<String, Object> showDepartmentWiseProjectTimeReport();

	public Map<String, Object> showDepartmentWiseProjectCostReport();

	public Map showEmployeeWiseSheetJsp(int employeeId);

	public List getHolidays();

	public Map<String, Object> showEmployeeListReport();

	public Map<String, Object> showEmployeeWiseTaskList();

	public Map<String, Object> showRoleWiseTaskList();

	public Map<String, Object> getFinancialYearDate(int year);
//added by Ramdular from Clinirx 02/02/2011 ---------------------
}
