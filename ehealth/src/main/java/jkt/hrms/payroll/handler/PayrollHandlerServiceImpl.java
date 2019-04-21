package jkt.hrms.payroll.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hrms.payroll.dataservice.PayrollDataService;

public class PayrollHandlerServiceImpl implements PayrollHandlerService {
	PayrollDataService payrollDataService = null;

	public PayrollDataService getPayrollDataService() {
		return payrollDataService;
	}

	public void setPayrollDataService(PayrollDataService payrollDataService) {
		this.payrollDataService = payrollDataService;
	}

	public Map<String, Object> showPrePayrollProcessJsp() {

		return payrollDataService.showPrePayrollProcessJsp();
	}

	public Map<String, Object> processPrePayrollDetail(
			Map<String, Object> generlMap) {

		return payrollDataService.processPrePayrollDetail(generlMap);
	}

	public Map<String, Object> showSearchPrePayrollProcessJsp() {

		return payrollDataService.showSearchPrePayrollProcessJsp();
	}

	public Map<String, Object> searchPrePayrollDetail(
			Map<String, Object> generalMap) {

		return payrollDataService.searchPrePayrollDetail(generalMap);
	}

	public Map<String, Object> editPrePayrollDetail(int prePayrollProcessId) {

		return payrollDataService.editPrePayrollDetail(prePayrollProcessId);
	}

	public Map<String, Object> updateProcessPrePayrollDetail(
			Map<String, Object> generalMap) {

		return payrollDataService.updateProcessPrePayrollDetail(generalMap);
	}

	public Map<String, Object> showPostPayrollProcessJsp() {

		return payrollDataService.showPostPayrollProcessJsp();
	}

	public Map<String, Object> processPostPayrollDetail(
			Map<String, Object> generalMap) {

		return payrollDataService.processPostPayrollDetail(generalMap);
	}

	public Map<String, Object> getConnectionForReport() {

		return payrollDataService.getConnectionForReport();
	}

	public Map<String, Object> showIncrementMonthStatementJsp() {

		return payrollDataService.showIncrementMonthStatementJsp();
	}

	public Map<String, Object> showStaffPersonnelDetailsJsp() {

		return payrollDataService.showStaffPersonnelDetailsJsp();
	}

	public Map<String, Object> showServiceStatementJsp() {

		return payrollDataService.showServiceStatementJsp();
	}

	public Map<String, Object> showPaySlipJsp() {

		return payrollDataService.showPaySlipJsp();
	}

	public Map<String, Object> showEarningAndDeductionJsp() {

		return payrollDataService.showEarningAndDeductionJsp();
	}

	public Map<String, Object> showMonthlyBankAdviceReportJsp() {

		return payrollDataService.showMonthlyBankAdviceReportJsp();
	}

	public Map<String, Object> showIndividualPayJsp() {

		return payrollDataService.showIndividualPayJsp();
	}

	public Map<String, Object> showSalaryRegisterJsp() {

		return payrollDataService.showSalaryRegisterJsp();
	}

	public List<MasEmployee> getAllEmployeeList() {
		return payrollDataService.getAllEmployeeList();
	}

	public MasDepartment getDepartment(Integer departmentId) {
		return payrollDataService.getDepartment(departmentId);
	}
}
