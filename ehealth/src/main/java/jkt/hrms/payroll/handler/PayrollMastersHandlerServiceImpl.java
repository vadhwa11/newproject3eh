package jkt.hrms.payroll.handler;

import java.util.Map;

import jkt.hrms.masters.business.HrMasBonus;
import jkt.hrms.masters.business.HrMasLoan;
import jkt.hrms.masters.business.HrMasPayElement;
import jkt.hrms.masters.business.HrMasPayroll;
import jkt.hrms.masters.business.HrMasReimbersement;
import jkt.hrms.payroll.dataservice.PayrollMastersDataService;

public class PayrollMastersHandlerServiceImpl implements
		PayrollMastersHandlerService {
	PayrollMastersDataService payrollMastersDataService = null;

	public PayrollMastersDataService getPayrollMastersDataService() {
		return payrollMastersDataService;
	}

	public void setPayrollMastersDataService(
			PayrollMastersDataService payrollMastersDataService) {
		this.payrollMastersDataService = payrollMastersDataService;
	}

	public Map<String, Object> saveBonus(HrMasBonus hrMasBonus) {

		return payrollMastersDataService.saveBonus(hrMasBonus);
	}

	public Map<String, Object> showBonusJsp() {

		return payrollMastersDataService.showBonusJsp();
	}

	public Map<String, Object> editBonus(Map<String, Object> generalMap) {

		return payrollMastersDataService.editBonus(generalMap);
	}

	public Map<String, Object> deleteBonus(Map<String, Object> generalMap) {

		return payrollMastersDataService.deleteBonus(generalMap);
	}

	public Map<String, Object> searchBonus(String bonusCode,
			String bonusDescription) {

		return payrollMastersDataService.searchBonus(bonusCode,
				bonusDescription);
	}

	public Map<String, Object> showLoanJsp() {

		return payrollMastersDataService.showLoanJsp();
	}

	public Map<String, Object> saveLoan(HrMasLoan hrMasLoan) {

		return payrollMastersDataService.saveLoan(hrMasLoan);
	}

	public Map<String, Object> editLoan(Map<String, Object> generalMap) {

		return payrollMastersDataService.editLoan(generalMap);
	}

	public Map<String, Object> deleteLoan(Map<String, Object> generalMap) {

		return payrollMastersDataService.deleteLoan(generalMap);
	}

	public Map<String, Object> searchLoan(String loanCode,
			String loanDescription) {

		return payrollMastersDataService.searchLoan(loanCode, loanDescription);
	}

	public Map<String, Object> savePayroll(HrMasPayroll hrMasPayroll) {

		return payrollMastersDataService.savePayroll(hrMasPayroll);
	}

	public Map<String, Object> editPayroll(Map<String, Object> generalMap) {

		return payrollMastersDataService.editPayroll(generalMap);
	}

	public Map<String, Object> showPayrollJsp() {

		return payrollMastersDataService.showPayrollJsp();
	}

	public Map<String, Object> deletePayroll(Map<String, Object> generalMap) {

		return payrollMastersDataService.deletePayroll(generalMap);
	}

	public Map<String, Object> searchPayroll(String payrollCode,
			String payrollDescription) {

		return payrollMastersDataService.searchPayroll(payrollCode,
				payrollDescription);
	}

	public Map<String, Object> savePayElement(HrMasPayElement hrMasPayElement) {

		return payrollMastersDataService.savePayElement(hrMasPayElement);
	}

	public Map<String, Object> showPayElementJsp() {

		return payrollMastersDataService.showPayElementJsp();
	}

	public Map<String, Object> editPayElement(Map<String, Object> generalMap) {

		return payrollMastersDataService.editPayElement(generalMap);
	}

	public Map<String, Object> deletePayElement(Map<String, Object> generalMap) {

		return payrollMastersDataService.deletePayElement(generalMap);
	}

	public Map<String, Object> searchPayElement(String payElementCode,
			String payElementDescription) {

		return payrollMastersDataService.searchPayElement(payElementCode,
				payElementDescription);
	}

	public Map<String, Object> saveReimbersement(
			HrMasReimbersement hrMasReimbersement) {

		return payrollMastersDataService.saveReimbersement(hrMasReimbersement);
	}

	public Map<String, Object> showReimbersementJsp() {

		return payrollMastersDataService.showReimbersementJsp();
	}

	public Map<String, Object> editReimbersement(Map<String, Object> generalMap) {

		return payrollMastersDataService.editReimbersement(generalMap);
	}

	public Map<String, Object> deleteReimbersement(
			Map<String, Object> generalMap) {

		return payrollMastersDataService.deleteReimbersement(generalMap);
	}

	public Map<String, Object> searchReimbersement(String reimbCode,
			String reimbDescription) {

		return payrollMastersDataService.searchReimbersement(reimbCode,
				reimbDescription);
	}

}
