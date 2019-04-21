package jkt.hrms.reports.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hrms.reports.dataservice.ReportDataService;

public class ReportHandlerServiceImpl implements ReportHandlerService {
	private ReportDataService reportDataService = null;

	public ReportDataService getReportDataService() {
		return reportDataService;
	}

	public void setReportDataService(ReportDataService reportDataService) {
		this.reportDataService = reportDataService;
	}

	public Map<String, Object> getConnectionForReport() {
		return reportDataService.getConnectionForReport();
	}

	public Map<String, Object> showPrintEmpDetail() {
		 
		return null;
	}

	public Map<String, Object> pvgetConnectionReport() {
		 
		return null;
	}

	public Map<String, Object> showPrintHrEmployeeExpirience() {
		 
		return null;
	}

	public Map<String, Object> showPrintReimbursement() {
		 
		return reportDataService.showPrintReimbursement();
	}

	public Map<String, Object> showEmployeeLeaveCard() {
		 
		return reportDataService.showEmployeeLeaveCard();
	}

	public Map<String, Object> showPrintLeaveStatement() {
		 
		return reportDataService.showPrintLeaveStatement();
	}

	public Map<String, Object> showEmployeeLeaveStatus() {
		 
		return reportDataService.showEmployeeLeaveStatus();
	}

	public Map<String, Object> showpayscale() {
	 
		return reportDataService.showpayscale();
	}

	// added by Ramdular from Clinirx 02/02/2011 ++++++++++++++++++++++++++++
	public Map<String, Object> showloanstatement() {
		 
		return reportDataService.showloanstatement();
	}

	public Map<String, Object> showDepartmentJsp() {
		return reportDataService.showDepartmentJsp();
	}

	public Map<String, Object> showEmployeeList() {
		return reportDataService.showEmployeeList();
	}

	public Map<String, Object> showStatusWiseTimeSheetReportJsp() {
		return reportDataService.showStatusWiseTimeSheetReportJsp();
	}

	public Map<String, Object> showTimeSheetProjectWiseJsp(int employeeId) {
		return reportDataService.showTimeSheetProjectWiseJsp(employeeId);
	}

	public Map<String, Object> showTimeSheetTaskWiseJsp() {
		return reportDataService.showTimeSheetTaskWiseJsp();
	}

//	public List<MstrTask> getTaskList(Integer projectId) {
//		return reportDataService.getTaskList(projectId);
//	}

	public Map<String, Object> showEmpExpSummary() {
		 
		return reportDataService.showEmpExpSummary();
	}

	public Map<String, Object> showEmpServiceCard() {
		 
		return reportDataService.showEmpExpSummary();
	}

	public Map<String, Object> showEmployeeTypeReport() {
		 
		return reportDataService.showEmployeeTypeReport();
	}

	public Map<String, Object> showEmpPerformanceReviewCard() {
		 
		return reportDataService.showEmpPerformanceReviewCard();
	}

	public Map<String, Object> showEmpCTCAnnexure() {
	 
		return reportDataService.showEmpCTCAnnexure();
	}

	public Map<String, Object> showEmpSalaryComp() {
		 
		return reportDataService.showEmpSalaryComp();
	}

	public int getMinHrsForTimeSheet(int noOfDays, int countOfSatSun,
			Date fromDate, Date toDate) {
		 
		return reportDataService.getMinHrsForTimeSheet(noOfDays, countOfSatSun,
				fromDate, toDate);
	}

	public Map<String, Object> showEmployeeInvestment() {
		 
		return reportDataService.showEmployeeInvestment();
	}

	public Map<String, Object> showTDSStatement() {
	 
		return reportDataService.showEmployeeInvestment();
	}

	public Map<String, Object> showIncomeTaxSheet() {
		 
		return reportDataService.showIncomeTaxSheet();
	}

	public Map<String, Object> showForm6A() {
		 
		return reportDataService.showIncomeTaxSheet();
	}

	public Map<String, Object> showTDSDeposit() {
	 
		return reportDataService.showTDSDeposit();
	}

	public Map<String, Object> showPFStatement() {
		 
		return reportDataService.showTDSDeposit();
	}

	public Map<String, Object> showEmployeeLeaveTypeReport() {

		return reportDataService.showEmployeeLeaveTypeReport();
	}

	public Map<String, Object> showPIReport() {
		 
		return reportDataService.showPIReport();
	}

	public Map<String, Object> showProjectResourceTimeReport() {
		return reportDataService.showProjectResourceTimeReport();
	}

	public Map<String, Object> showProjectSiteAllocationReport() {
		return reportDataService.showProjectSiteAllocationReport();
	}

	public Map<String, Object> getDepartmentForCompany(
			Map<String, Object> mapForDs) {
		return reportDataService.getDepartmentForCompany(mapForDs);
	}

	public Map<String, Object> getEmpForDepartment(Map<String, Object> mapForDs) {
		return reportDataService.getEmpForDepartment(mapForDs);
	}

	public Map<String, Object> showPatientEnrollmentJsp(
			Map<String, Object> mapForDs) {
		return reportDataService.showPatientEnrollmentJsp(mapForDs);
	}

	public Map<String, Object> printPatientEnrollmentReportExcel(
			Map<String, Object> mapForDs) {
		return reportDataService.printPatientEnrollmentReportExcel(mapForDs);
	}

	public Map<String, Object> printPatientWiseVisitReport(
			Map<String, Object> mapForDs) {
		return reportDataService.printPatientWiseVisitReport(mapForDs);
	}

	public Map<String, Object> printSitePaymentReport(
			Map<String, Object> mapForDs) {
		return reportDataService.printSitePaymentReport(mapForDs);
	}

	public Map<String, Object> printProjectDetailReport(
			Map<String, Object> mapForDs) {
		return reportDataService.printProjectDetailReport(mapForDs);
	}

	public Map<String, Object> getHospitalName(Map<String, Object> mapForDs) {
		return reportDataService.getHospitalName(mapForDs);
	}

	public Map<String, Object> getEmpCodeSelectedEmployees(
			Map<String, Object> mapForDs) {
		return reportDataService.getEmpCodeSelectedEmployees(mapForDs);
	}

	public Map<String, Object> showProjectWiseCostReport() {

		return reportDataService.showProjectWiseCostReport();
	}

	public Map<String, Object> showDepartmentWiseProjectTimeReport() {

		return reportDataService.showDepartmentWiseProjectTimeReport();
	}

	public Map<String, Object> showDepartmentWiseProjectCostReport() {

		return reportDataService.showDepartmentWiseProjectCostReport();
	}

	public Map showEmployeeWiseSheetJsp(int employeeId) {

		return reportDataService.showEmployeeWiseSheetJsp(employeeId);
	}

	public List getHolidays() {

		return reportDataService.getHolidays();
	}

	public Map<String, Object> showEmployeeListReport() {

		return reportDataService.showEmployeeListReport();
	}

	public Map<String, Object> showEmployeeWiseTaskList() {

		return reportDataService.showEmployeeWiseTaskList();
	}

	public Map<String, Object> showRoleWiseTaskList() {

		return reportDataService.showRoleWiseTaskList();
	}

	public Map<String, Object> getFinancialYearDate(int year) {

		return reportDataService.getFinancialYearDate(year);
	}

	// added by Ramdular from Clinirx 02/02/2011 ---------------------
}
