package jkt.hrms.payroll.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasBranch;
import jkt.hrms.masters.business.HrAdvance;
import jkt.hrms.masters.business.HrAdvanceDetail;
import jkt.hrms.masters.business.HrArrear;
import jkt.hrms.masters.business.HrArrearSalary;
import jkt.hrms.masters.business.HrBonusDetail;
import jkt.hrms.masters.business.HrLoanDetail;
import jkt.hrms.masters.business.HrLoanHeader;
import jkt.hrms.masters.business.HrReimbHeader;

public interface LoanHandlerService {

	Map<String, Object> showLoanHeaderJsp();

	Map<String, Object> saveLoanHeader(HrLoanHeader hrLoanHeader);

	Map<String, Object> showLoanDetailJsp();

	Map<String, Object> saveLoanDetail(HrLoanDetail hrLoanDetail);

	Map<String, Object> updateLoanHeader(Map<String, Object> generalMap);

	Map<String, Object> getLoanDetailFromAjax(int loanHeaderId);

	Map<String, Object> editLoanDetail(Map<String, Object> generalMap);

	Map<String, Object> showReimbHeaderJsp();

	Map<String, Object> saveReimbHeader(HrReimbHeader hrReimbHeader);

	Map<String, Object> updateReimbHeader(Map<String, Object> generalMap);

	Map<String, Object> showReimbDetailJsp();

	Map<String, Object> saveReimbDetail(Map<String, Object> generalMap);

	Map<String, Object> updateReimbDetail(Map<String, Object> generalMap);

	Map<String, Object> showBonusDetailJsp();

	Map<String, Object> saveBonusDetail(HrBonusDetail hrBonusDetail);

	Map<String, Object> updateBonusDetail(Map<String, Object> generalMap);

	Map<String, Object> showAdvanceJsp();

	Map<String, Object> saveAdvance(HrAdvance hrAdvance);

	Map<String, Object> showAdvanceDetailJsp();

	Map<String, Object> saveAdvanceDetail(HrAdvanceDetail hrAdvanceDetail);

	Map<String, Object> updateAdvance(Map<String, Object> generalMap);

	Map<String, Object> updateAdvanceDetail(Map<String, Object> generalMap);

	Map<String, Object> showArrearJsp();

	Map<String, Object> saveArrear(HrArrear hrArrear);

	Map<String, Object> updateArrear(Map<String, Object> generalMap);

	Map<String, Object> showArrearSalaryJsp();

	Map<String, Object> saveArrearSalary(HrArrearSalary hrArrearSalary);

	Map<String, Object> updateArrearSalary(Map<String, Object> generalMap);

	Map<String, Object> showAdvanceStatementJsp();

	Map<String, Object> getConnectionForReport();

	
}
