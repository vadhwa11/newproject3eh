package jkt.hrms.payroll.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;

public interface PayrollHandlerService {

	Map<String, Object> showPrePayrollProcessJsp();

	Map<String, Object> processPrePayrollDetail(Map<String, Object> generlMap);

	Map<String, Object> showSearchPrePayrollProcessJsp();

	Map<String, Object> searchPrePayrollDetail(Map<String, Object> generalMap);

	Map<String, Object> editPrePayrollDetail(int prePayrollProcessId);

	Map<String, Object> updateProcessPrePayrollDetail(
			Map<String, Object> generalMap);

	Map<String, Object> showPostPayrollProcessJsp();

	Map<String, Object> processPostPayrollDetail(Map<String, Object> generalMap);

	Map<String, Object> getConnectionForReport();

	Map<String, Object> showIncrementMonthStatementJsp();

	Map<String, Object> showStaffPersonnelDetailsJsp();

	Map<String, Object> showServiceStatementJsp();

	Map<String, Object> showPaySlipJsp();

	Map<String, Object> showEarningAndDeductionJsp();

	Map<String, Object> showMonthlyBankAdviceReportJsp();

	Map<String, Object> showIndividualPayJsp();

	Map<String, Object> showSalaryRegisterJsp();

	List<MasEmployee> getAllEmployeeList();

	MasDepartment getDepartment(Integer departmentId);

}
