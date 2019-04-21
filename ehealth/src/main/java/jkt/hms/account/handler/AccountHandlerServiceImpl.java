package jkt.hms.account.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.account.dataservice.AccountDataService;
import jkt.hms.masters.business.FaMasAccount;
import jkt.hms.masters.business.FaMasNarration;
import jkt.hms.masters.business.FaMasSubLed;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.util.Box;
import jkt.hrms.masters.business.HrMasFinancialYear;

public class AccountHandlerServiceImpl implements AccountHandlerService {
	AccountDataService accountDataService = null;

	public Map<String, Object> showAccountsGroupMasterJsp(Map<String, Object> generalMap) {

		return accountDataService.showAccountsGroupMasterJsp(generalMap);
	}

	public Map<String, Object> showAccountSubGroup(Map<String, Object> generalMap) {
		return accountDataService.showAccountSubGroup(generalMap);
	}

	public Map<String, Object> searchAccountSubGroup(Box box) {
		return accountDataService.searchAccountSubGroup(box);
	}

	public Map<String, Object> addAccountMaster(Map<String, Object> generalMap) {

		return accountDataService.addAccountMaster(generalMap);
	}

	public Map<String, Object> showAccountMasterJsp(Map<String, Object> generalMap) {

		return accountDataService.showAccountMasterJsp(generalMap);
	}

	public Map<String, Object> searchAccountMaster(Box box) {

		return accountDataService. searchAccountMaster(box);
	}

	public Map<String, Object> showAccountSubLedgerJsp(Map<String, Object> detailsMap) {
		return accountDataService.showAccountSubLedgerJsp(detailsMap);
	}

	public Map<String, Object> getAccCodeForAccSubGrp(Box box) {
		return accountDataService.getAccCodeForAccSubGrp(box);
	}

	public Map<String, Object> searchAccountGroup(Box box) {
		return accountDataService.searchAccountGroup(box);
	}

	public Map<String, Object> addAccountSubLedger(Map<String, Object> generalMap) {
		return accountDataService.addAccountSubLedger(generalMap) ;
	}
	public Map<String, Object> showCashVoucherJsp() {
		return accountDataService.showCashVoucherJsp();
	}
	public Map<String, Object> getAccountCodeForAutoComplete(Map<String, Object> parameterMap) {
		return accountDataService.getAccountCodeForAutoComplete(parameterMap) ;
	}
	public Map<String, Object> getSubLedgerForAccount(Map<String, Object> parameterMap) {
		return accountDataService.getSubLedgerForAccount(parameterMap);
	}

	public Map<String, Object> addVoucherNarration(FaMasNarration faMasNarration) {
		return accountDataService.addVoucherNarration(faMasNarration);
	}
	public Map<String, Object> getNarrationForAutoComplete(Map<String, Object> parameterMap) {
		return accountDataService.getNarrationForAutoComplete(parameterMap);
	}
	public Map<String, Object> showAccountBalance(int accountId) {
		return accountDataService.showAccountBalance(accountId);
	}
	public Map<String, Object> getAccountNarrationForAutoComplete(Map<String, Object> parameterMap) {
		return accountDataService.getAccountNarrationForAutoComplete(parameterMap);
	}

	public Map<String, Object> submitReceiptVoucher(Box box) {
		return accountDataService.submitReceiptVoucher(box);
	}
	public Map<String, Object> showPaymentVoucherJsp(Box box) {

		return accountDataService.showPaymentVoucherJsp(box);
	}

	public Map<String, Object> submitPaymentVoucher(Box box) {
		return accountDataService.submitPaymentVoucher(box);
		}
	public Map<String, Object> showSalesVoucherJsp(Map<String, Object> generalMap) {
		return accountDataService.showSalesVoucherJsp(generalMap);
	}
	public Map<String, Object> submitSalesVoucher(Box box) {
		return accountDataService.submitSalesVoucher(box);
	}
	public Map<String, Object> showSalesReturnVoucherJsp(Map<String, Object> generalMap) {

		return accountDataService.showSalesReturnVoucherJsp(generalMap) ;
	}
	public Map<String, Object> submitSalesReturnVoucher(Box box) {

		return accountDataService.submitSalesReturnVoucher(box);
	}


	public Map<String, Object> showBankReconciliationJsp(int fYear) {
		return accountDataService.showBankReconciliationJsp(fYear);
	}

	public Map<String, Object> getBankAccountDetailsForReconciliation(Box box) {
		return accountDataService.getBankAccountDetailsForReconciliation(box);
	}

	public boolean saveBankReconciliationDetails(Box box) {
		return accountDataService.saveBankReconciliationDetails(box) ;
	}

	
	public Map<String, Object> showJournalVoucherJsp(Box box) {
		
		return accountDataService.showJournalVoucherJsp(box);
	}


	public Map<String, Object> submitJournalVoucher(Box box) {
		return accountDataService.submitJournalVoucher(box);
	}

	public Map<String, Object> showTrialBalanceReportJsp() {

		return accountDataService.showTrialBalanceReportJsp();
	}
	/**
	 * Getter And Setter of BillingDataService
	 */
	public AccountDataService getAccountDataService() {
		return accountDataService;
	}

	public void setAccountDataService(AccountDataService accountDataService) {
		this.accountDataService = accountDataService;
	}

	public Map<String, Object> getConnectionForReport() {

		return accountDataService.getConnectionForReport();
	}

	public Map<String, Object> showPurchaseVoucherJsp(Map<String, Object> generalMap) {

		return accountDataService.showPurchaseVoucherJsp(generalMap);
	}

	public Map<String, Object> submitPurchaseVoucher(Box box) {

		return accountDataService.submitPurchaseVoucher(box);
	}

	public Map<String, Object> showPurchaseReturnVoucherJsp(Map<String, Object> generalMap) {

		return accountDataService.showPurchaseReturnVoucherJsp(generalMap);
	}

	public Map<String, Object> submitPurchaseReturnVoucher(Box box) {

		return accountDataService.submitPurchaseReturnVoucher(box);
	}
	
	public Map<String, Object> updateAccountMaster(Box box) {

		return accountDataService.updateAccountMaster(box);
	}

	public Map<String, Object> updateAccountSubLedger(Box box) {

		return accountDataService.updateAccountSubLedger(box);
	}
	/*public Map<String, Object> submitAccountsParameter(Box box) {

			return accountDataService.submitAccountsParameter(box);
		}*/

public Map<String, Object> searchAccountSubLedger(Box box) {

		return accountDataService.searchAccountSubLedger(box);
	}


	//------------------- Sub Led Repory By Mansi

	public Map<String, Object> showSubLedJsp() {
		return accountDataService.showSubLedJsp();
	}

	/*public Map<String, Object> showAccountParameterJsp(int fYear) {

		return accountDataService.showAccountParameterJsp(fYear);
	}*/

	public List<HrMasFinancialYear> getFinancialYearDate(int fYearId) {

		return accountDataService.getFinancialYearDate(fYearId);
	}

	public Map<String, Object> getOpeningBalance(Map<String, Object> generalMap) {

		return accountDataService.getOpeningBalance(generalMap);
	}

	public Map<String, Object> showCashRegisterJsp() {

		return accountDataService.showCashRegisterJsp();
	}

	public Map<String, Object> getBillingAmountForAccounts() {

		return accountDataService.getBillingAmountForAccounts();
	}

	public Map<String, Object> showBranchBalancePopupJsp() {

		return accountDataService.showBranchBalancePopupJsp();
	}

	public Map<String, Object> showBranchSubLedBalancePopupJsp() {

		return accountDataService.showBranchSubLedBalancePopupJsp();
	}

	public Map<String, Object> showVoucherMappingJsp(Box box) {

		return accountDataService.showVoucherMappingJsp(box);
	}

	public Map<String, Object> getVoucherList(Map<String, Object> generalMap) {

		return accountDataService.getVoucherList(generalMap);
	}

	public Map<String, Object> showBankRegisterJsp() {


		return accountDataService.showBankRegisterJsp();
	}

	public Map<String, Object> dispalySalesBillingAmount(Box box) {

		return accountDataService.dispalySalesBillingAmount(box);
	}

	public Map<String, Object> postSalesVoucherMapping(Box box) {

		return accountDataService.postSalesVoucherMapping(box);
	}

	public Map<String, Object> showIpSalesVoucherMappingJsp(Box box) {

		return accountDataService.showIpSalesVoucherMappingJsp(box);
	}

	public Map<String, Object> dispalyIpSalesBillingAmount(Box box) {

		return accountDataService.dispalyIpSalesBillingAmount(box);
	}

	public Map<String, Object> postSalesIpVoucherMapping(Box box) {

		return accountDataService.postSalesIpVoucherMapping(box);
	}

	public Map<String, Object> dispalyRefundBillingAmount(Box box) {

		return accountDataService.dispalyRefundBillingAmount(box) ;
	}

	public Map<String, Object> showLedgerAnalysisJsp() {


		return accountDataService.showLedgerAnalysisJsp();
	}

	public Map<String, Object> postRefundVoucherMapping(Box box) {

		return accountDataService.postRefundVoucherMapping(box);
	}

	public Map<String, Object> displayAdvanceVoucherBillingAmount(Box box) {

		return accountDataService.displayAdvanceVoucherBillingAmount(box);
	}

	public Map<String, Object> postAdvanceVoucherMapping(Box box) {

		return accountDataService.postAdvanceVoucherMapping(box);
	}

	public Map<String, Object> dispalyFinalSettlementVoucherAmount(Box box) {

		return accountDataService.dispalyFinalSettlementVoucherAmount(box);
	}

	public Map<String, Object> postFinalSettlementVoucherMapping(Box box) {

		return accountDataService.postFinalSettlementVoucherMapping(box);
	}

	public Map<String, Object> showfavoucherJsp(int fYearId) {

		return accountDataService.showfavoucherJsp(fYearId);
	}

	public Map<String, Object> closingFinancialYear(Box box) {

		return accountDataService.closingFinancialYear(box);
	}

		
	public Map<String, Object> showVoucherReportJsp() {
		// TODO Auto-generated method stub
		return accountDataService.showVoucherReportJsp();
	}

	
	public Map<String, Object> showAccountOpeningJsp(int branchId) {
		
		return accountDataService.showAccountOpeningJsp(branchId);
	}

	
	public Map<String, Object> saveAccountOpening(Box box) {
		
		return accountDataService.saveAccountOpening( box);
	}

	
	public Map<String, Object> updateAccountOpening(Box box) {
		
		return accountDataService.updateAccountOpening(box);
	}

	
	public Map<String, Object> deleteAccountOpening(Box box) {
		
		return accountDataService.deleteAccountOpening(box);
	}


	public int getFinancialYearList(Map<String, Object> generalMap) {
		
		return accountDataService.getFinancialYearList(generalMap);
	}


	
	public Map<String, Object>getOpeningBalanceFromOpeningEntry(Map<String, Object> generalMap) {
		
		return accountDataService.getOpeningBalanceFromOpeningEntry(generalMap);
	}

	
	public Map<String, Object> showLedgerBookJsp() {
		
		return accountDataService.showLedgerBookJsp();
	}

	
	public Map<String, Object> showAccountGroupBalance(Map<String, Object> generalMap) {
		
		return accountDataService.showAccountGroupBalance(generalMap);
	}

	
	public Map<String, Object> showAccountSubGroupBalance(Map<String, Object> generalMap) {
	
		return accountDataService.showAccountSubGroupBalance(generalMap);
	}


	public Map<String, Object> showAccountSubLedgerBalance(Map<String, Object> generalMap) {
		
		return accountDataService.showAccountSubLedgerBalance(generalMap) ;
	}

	
	public Map<String, Object> showAccountMasterBalance(
			Map<String, Object> generalMap) {
		
		return accountDataService.showAccountMasterBalance(generalMap);
	}

	
	public Map<String, Object> showAccountParameterJsp(int fYear) {
		
		return accountDataService.showAccountParameterJsp(fYear);
	}

	
	public Map<String, Object> submitAccountsParameter(Box box) {
		
		return accountDataService.submitAccountsParameter(box);
	}

	@Override
	public int getFinancialYearId(Date voucherDate) {
		return accountDataService.getFinancialYearId(voucherDate);
	}

	@Override
	public Map<String, Object> getAccountId(Map<String, Object> remap) {
		return accountDataService.getAccountId(remap);
	}
/*
	@Override
	public Map<String, Object> showAccountBalanceall(Map<String, Object> remap) {
		return accountDataService.showAccountBalanceall(remap);
	}*/

	@Override
	public Map<String, Object> editAccountMaster(Box box) {
		
		return accountDataService.editAccountMaster(box);
	}

	@Override
	public Map<String, Object> editAccountSubLedger(Box box) {
		
		return accountDataService.editAccountSubLedger(box);
	}

	@Override
	public Map<String, Object> addAccountSubGroup(Map<String, Object> generalMap) {
		
		return accountDataService.addAccountSubGroup(generalMap);
	}

	@Override
	public Map<String, Object> editAccountSubGroup(Map<String, Object> generalMap) {
		
		return accountDataService.editAccountSubGroup(generalMap);
	}

	@Override
	public Map<String, Object> updateAccountSubGroup(Map<String, Object> generalMap) {
		
		return accountDataService.updateAccountSubGroup(generalMap);
	}

	@Override
	public Map<String, Object> getHospitalName(Map<String, Object> mapForDs) {
		return accountDataService.getHospitalName(mapForDs);
	}

	@Override
	public Map<String, Object> showCashRegisterJsp(Box box) {
		
		return accountDataService.showCashRegisterJsp(box);
	}

	@Override
	public Map<String, Object> displayCashBook(Box box) {
		
		return accountDataService.displayCashBook(box);
	}
	
	@Override
	public Map<String, Object> showAccountSubGroupNew(Map<String, Object> generalMap) {
		return accountDataService.showAccountSubGroupNew(generalMap);
	}
	
	@Override
	public Map<String, Object> showAccountMasterNew(Map<String, Object> generalMap) {
		return accountDataService.showAccountMasterNew(generalMap) ;
	}
	
	@Override
	public Map<String, Object> showChequeDetailJsp(Box box) {
		
		return accountDataService.showChequeDetailJsp(box);
	}
	
	@Override
	public Map<String, Object> showChequePrintingJsp(Box box) {
		
		return accountDataService.showChequePrintingJsp(box);
	}
	
	@Override
	public Map<String, Object> showFixedDepositRegisterJsp(Box box) {
	
		return accountDataService.showFixedDepositRegisterJsp(box);
	}
	
	@Override
	public Map<String, Object> showHrInsuranceDetailsJsp(
			Map<String, Object> generalMap) {
		return accountDataService.showHrInsuranceDetailsJsp(generalMap);
	}
	
	@Override
	public Map<String, Object> searchAccountGroupNew(Map<String, Object> generalMap) {
		return accountDataService.searchAccountGroupNew(generalMap);
	}
	
	@Override
	public Map<String, Object> addAccountGroupNew(Map<String, Object> generalMap) {
		return accountDataService.addAccountGroupNew( generalMap);
	}
	
	@Override
	public Map<String, Object> searchAccountSubGroup(Map<String, Object> generalMap) {
		return accountDataService.searchAccountSubGroup(generalMap);
	}
	
	@Override
	public Map<String, Object> updateAccountGroupNew(Box box) {
		return accountDataService.updateAccountGroupNew(box);
	}

	@Override
	public Map<String, Object> deleteAccountGroupNew(Box box) {
		return accountDataService.deleteAccountGroupNew(box);
	}
	
	@Override
	public Map<String, Object> addAccountSubGroupNew(Map<String, Object> generalMap) {
		return accountDataService.addAccountSubGroupNew(generalMap);
	}

	
	@Override
	public boolean updateAccountSubGroupNew(Map<String, Object> generalMap) {
		return accountDataService.updateAccountSubGroupNew(generalMap);
	}

	@Override
	public boolean deleteAccountSubGroupNew(int accountGroupId,Map<String, Object> generalMap) {
		return accountDataService.deleteAccountSubGroupNew(accountGroupId,generalMap);
		}
	
	@Override
	public boolean editAccountMaster(Map<String, Object> generalMap) {
		return accountDataService.editAccountMaster(generalMap);
	}

	@Override
	public Map<String, Object> showCashVoucherJsp(Box box) {
		return accountDataService.showCashVoucherJsp(box);
	}
	
	@Override
	public Map<String, Object> showLedgerJsp(Box box) {
		
		return accountDataService.showLedgerJsp(box);
	}
	
	@Override
	public Map<String, Object> displayLedgerBook(Box box) {
		
		return accountDataService.displayLedgerBook(box);
	}

	@Override
	public Map<String, Object> showSubLedgerPopupJsp(Map<String, Object> generalMap) {
		
		return accountDataService.showSubLedgerPopupJsp(generalMap);
	}
	
	@Override
	public Map<String, Object> getTrialBalance(Box box) {
		
		return accountDataService.getTrialBalance(box);
	}

	@Override
	public Map<String, Object> getSubGroupWiseTrialBalance(Box box) {
		
		return accountDataService.getSubGroupWiseTrialBalance(box);
	}

	@Override
	public Map<String, Object> getAccountWiseTrialBalance(Box box) {
		
		return accountDataService.getAccountWiseTrialBalance(box);
	}

	@Override
	public Map<String, Object> getVoucherWiseWiseTrialBalance(Box box) {
		
		return accountDataService.getVoucherWiseWiseTrialBalance(box);
	}
	
	@Override
	public Map<String, Object> showBalanceSheet(Box box) {
		
		return accountDataService.showBalanceSheet(box);
	}
	
	@Override
	public Map<String, Object> generateBalanceSheetJsp(Box box) {
		return accountDataService.generateBalanceSheetJsp(box);
	}

	
	@Override
	public Map<String, Object> displayScheduleDetail(Box box) {
		
		return accountDataService.displayScheduleDetail(box);
	}

	@Override
	public Map<String, Object> deleteAccountSubLedger(Box box) {
		return accountDataService.deleteAccountSubLedger(box);
	}

	@Override
	public Map<String, Object> showAccountBalance(Box box) {
		return accountDataService.showAccountBalance(box);
	}

	@Override
	public Map<String, Object> submitOpeningBalance(Box box) {
		return accountDataService.submitOpeningBalance(box);
	}

	@Override
	public int getAccountSubGroup(int accountId) {
		return accountDataService.getAccountSubGroup(accountId);
	}

	@Override
	public List<Object[]> getCentreList() {
		return accountDataService.getCentreList();
	}

	@Override
	public List<Object[]> getAccountList(Box box) {
		return accountDataService.getAccountList(box);
	}

	@Override
	public List<Object[]> getSubledgerList(Box box) {
		return accountDataService.getSubledgerList(box);
	}

	@Override
	public Map<String, Object> getConsolidatedTransactionDetails(Box box) {
		// TODO Auto-generated method stub
		return accountDataService.getConsolidatedTransactionDetails(box);
	}

	@Override
	public Map<String, Object> getTransactionHistory(Box box) {
		return accountDataService.getTransactionHistory(box);
	}

	@Override
	public Map<String, Object> showBankReconcillationReportJsp(Box box) {
		return accountDataService.showBankReconcillationReportJsp(box);
	}

	@Override
	public Map<String, Object> showIncomeExpenditureReportJsp(Box box) {
		return accountDataService.showIncomeExpenditureReportJsp(box);
	}

	@Override
	public String getFinancialYear(int financialYearId) {
		return accountDataService.getFinancialYear(financialYearId);
	}

	@Override
	public Map<String, Object> showFixedAssetReportJsp(Box box) {
		return accountDataService.showFixedAssetReportJsp(box);
	}

	@Override
	public Map<String, Object> showSchemeWiseFundAllocateJsp() {
		return accountDataService.showSchemeWiseFundAllocateJsp();
	}

	@Override
	public Map<String, Object> addSchemeWiseFundAllocate(Box box) {
		return accountDataService.addSchemeWiseFundAllocate(box);
	}

	@Override
	public Map<String, Object> updateSchemeWiseFundAllocate(Box box) {
		return accountDataService.updateSchemeWiseFundAllocate(box);
	}

	@Override
	public boolean deleteSchemeWiseFundAllocate(Box box) {
		return accountDataService.deleteSchemeWiseFundAllocate(box);
	}

	@Override
	public Map<String, Object> searchSchemeWiseFundAllocate(Box box) {
		return accountDataService.searchSchemeWiseFundAllocate(box);
	}

	@Override
	public String getAccountSubGroupFlag(int accountId) {
		return accountDataService.getAccountSubGroupFlag(accountId);
	}

	@Override
	public Map<String, Object> submitAccountsParameterMainCharge(Box box) {
		return accountDataService.submitAccountsParameterMainCharge(box);
	}

	@Override
	public String getEmployeeName(int empId) {
		return accountDataService.getEmployeeName(empId);
	}

	@Override
	public Map<String, Object> showIncomeExpenditureReportWardLevelJsp(Box box) {
		return accountDataService.showIncomeExpenditureReportWardLevelJsp(box);
	}

	@Override
	public Map<String, Object> getSubLedgerForAccount1(
			Map<String, Object> parameterMap) {
		return accountDataService.getSubLedgerForAccount1(parameterMap);
	}

	@Override
	public Map<String, Object> showFundReceiveAndExpenseReport(Map<String, Object> map) {
		return accountDataService.showFundReceiveAndExpenseReport(map);
	}

	@Override
	public Map<String, Object> getValueForchequeNo(int chqueId) {
		return accountDataService.getValueForchequeNo(chqueId);
	}

	@Override
	public Map<String, Object> getDataForExcel(Map<String, Object> generalMap) {
		return accountDataService.getDataForExcel(generalMap);
	}

	@Override
	public Map<String, Object> getDataForReport(Date fromDate, Date toDate) {
		return accountDataService.getDataForReport(fromDate,fromDate);
	}

	@Override
	public Map<String, Object> printPettyCashVoucherVHNSCExcel(
			Map<String, Object> generalMap) {
		return accountDataService.printPettyCashVoucherVHNSCExcel(generalMap);
	}

	@Override
	public Map<String, Object> printDoubleColumnCashBook(Map<String, Object> generalMap) {
		return accountDataService.printDoubleColumnCashBook(generalMap);
	}

	@Override
	public Map<String, Object> getWaitingListForVoucherApproval(int employeeLevel,int hospitalId) {
		return accountDataService.getWaitingListForVoucherApproval(employeeLevel,hospitalId);
	}

	@Override
	public Map<String, Object> getDetailsForVoucherApproval(int voucherId) {
		return accountDataService.getDetailsForVoucherApproval(voucherId);
	}

	@Override
	public boolean aproveVoucher(int employeeLevel, int voucherId) {
		return accountDataService.aproveVoucher( employeeLevel,  voucherId);
	}

	@Override
	public boolean rejectVoucher(int employeeLevel, int voucherId,String remarksForReject) {
		return accountDataService.rejectVoucher( employeeLevel,  voucherId,remarksForReject);
	}

	@Override
	public List<MasStoreFinancial> getmasStoreFinancialList(int fYearId) {
		return accountDataService.getmasStoreFinancialList(fYearId);
	}

	@Override
	public Map<String, Object> getSchemeDetails() {
		return accountDataService.getSchemeDetails();
	}

	@Override
	public Map<String, Object> showEMDRegisterJsp(Box box) {
		return accountDataService.showEMDRegisterJsp(box);
	}

	@Override
	public Map<String, Object> submitEMDRegister(Box box) {
		// TODO Auto-generated method stub
		return accountDataService.submitEMDRegister(box);
	}

	@Override
	public Map<String, Object> editEMDRegister(Box box) {
		// TODO Auto-generated method stub
		return accountDataService.editEMDRegister(box);
	}


}