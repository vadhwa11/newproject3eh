package jkt.hms.account.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.FaMasAccount;
import jkt.hms.masters.business.FaMasNarration;
import jkt.hms.masters.business.FaMasSubLed;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.util.Box;
import jkt.hrms.masters.business.HrMasFinancialYear;

public interface AccountHandlerService {

	Map<String, Object> showAccountsGroupMasterJsp(Map<String, Object> generalMap);

	Map<String, Object> showAccountSubGroup(Map<String, Object> generalMap);

	Map<String, Object> searchAccountSubGroup(Box box);

	Map<String, Object> showAccountMasterJsp(Map<String, Object> generalMap);

	Map<String, Object> addAccountMaster(Map<String, Object> generalMap);

	Map<String, Object> searchAccountMaster(Box box);

	Map<String, Object> getAccCodeForAccSubGrp(Box box);

	Map<String, Object> showAccountSubLedgerJsp(Map<String, Object> detailsMap);

	Map<String, Object> searchAccountGroup(Box box);

	Map<String, Object> addAccountSubLedger(Map<String, Object> generalMap);

	Map<String, Object> showCashVoucherJsp();

	Map<String, Object> getAccountCodeForAutoComplete(
			Map<String, Object> parameterMap);

	Map<String, Object> getSubLedgerForAccount(Map<String, Object> parameterMap);

	Map<String, Object> addVoucherNarration(FaMasNarration faMasNarration);

	Map<String, Object> getNarrationForAutoComplete(Map<String, Object> parameterMap);

	Map<String, Object> showAccountBalance(int accountId);

	Map<String, Object> getAccountNarrationForAutoComplete(
			Map<String, Object> parameterMap);

	Map<String, Object> submitReceiptVoucher(Box box);

	Map<String, Object> showPaymentVoucherJsp(Box box);

	Map<String, Object> submitPaymentVoucher(Box box);

	Map<String, Object> showSalesVoucherJsp(Map<String, Object> generalMap);

	Map<String, Object> submitSalesVoucher(Box box);

	Map<String, Object> showSalesReturnVoucherJsp(Map<String, Object> generalMap);

	Map<String, Object> submitSalesReturnVoucher(Box box);

	Map<String, Object> showBankReconciliationJsp(int fYear);

	Map<String, Object> getBankAccountDetailsForReconciliation(Box box);

	boolean saveBankReconciliationDetails(Box box);


	Map<String, Object> showJournalVoucherJsp(Box box);

	Map<String, Object> submitJournalVoucher(Box box);

	Map<String, Object> showTrialBalanceReportJsp();

	Map<String, Object> getConnectionForReport();

	Map<String, Object> showPurchaseVoucherJsp(Map<String, Object> generalMap);

	Map<String, Object> submitPurchaseVoucher(Box box);

	Map<String, Object> showPurchaseReturnVoucherJsp(Map<String, Object> generalMap);

	Map<String, Object> submitPurchaseReturnVoucher(Box box);

	Map<String, Object> updateAccountMaster(Box box);

	Map<String, Object> updateAccountSubLedger(Box box);

	//Map<String, Object> submitAccountsParameter(Box box);
	//------------------- Sub Led Repory By Mansi

	Map<String, Object> showSubLedJsp();

	//Map<String, Object> showAccountParameterJsp(int fYear);

	Map<String, Object> searchAccountSubLedger(Box box);

	List<HrMasFinancialYear> getFinancialYearDate(int fYearId);

	Map<String, Object> getOpeningBalance(Map<String, Object> generalMap);

	Map<String, Object> showCashRegisterJsp();

	Map<String, Object> getBillingAmountForAccounts();

	Map<String, Object> getVoucherList(Map<String, Object> generalMap);

	Map<String, Object> showBankRegisterJsp();

	Map<String, Object> showBranchBalancePopupJsp();

	Map<String, Object> showBranchSubLedBalancePopupJsp();

	Map<String, Object> showLedgerAnalysisJsp();


	Map<String, Object> showVoucherMappingJsp(Box box);

	Map<String, Object> dispalySalesBillingAmount(Box box);

	Map<String, Object> postSalesVoucherMapping(Box box);

	Map<String, Object> showIpSalesVoucherMappingJsp(Box box);

	Map<String, Object> dispalyIpSalesBillingAmount(Box box);

	Map<String, Object> postSalesIpVoucherMapping(Box box);

	Map<String, Object> dispalyRefundBillingAmount(Box box);

	Map<String, Object> postRefundVoucherMapping(Box box);

	Map<String, Object> displayAdvanceVoucherBillingAmount(Box box);

	Map<String, Object> postAdvanceVoucherMapping(Box box);

	Map<String, Object> dispalyFinalSettlementVoucherAmount(Box box);

	Map<String, Object> postFinalSettlementVoucherMapping(Box box);

	Map<String, Object> showfavoucherJsp(int fYearId);

	Map<String, Object> closingFinancialYear(Box box);


	Map<String, Object> showVoucherReportJsp();

	Map<String, Object> showAccountOpeningJsp(int branchId);

	Map<String, Object> saveAccountOpening(Box box);

	Map<String, Object> updateAccountOpening(Box box);

	Map<String, Object> deleteAccountOpening(Box box);

	int getFinancialYearList(Map<String, Object> generalMap);

	Map<String, Object> getOpeningBalanceFromOpeningEntry(
			Map<String, Object> generalMap);

	Map<String, Object> showLedgerBookJsp();

	Map<String, Object> showAccountGroupBalance(Map<String, Object> generalMap);

	Map<String, Object> showAccountSubGroupBalance(
			Map<String, Object> generalMap);


	Map<String, Object> showAccountSubLedgerBalance(
			Map<String, Object> generalMap);

	Map<String, Object> showAccountMasterBalance(Map<String, Object> generalMap);

	Map<String, Object> showAccountParameterJsp(int fYear);

	Map<String, Object> submitAccountsParameter(Box box);

	int getFinancialYearId(Date voucherDate);

	Map<String, Object> getAccountId(Map<String, Object> remap);

	//Map<String, Object> showAccountBalanceall(Map<String, Object> remap);

	Map<String, Object> editAccountMaster(Box box);

	Map<String, Object> editAccountSubLedger(Box box);

	Map<String, Object> addAccountSubGroup(Map<String, Object> generalMap);

	Map<String, Object> editAccountSubGroup(Map<String, Object> generalMap);

	Map<String, Object> updateAccountSubGroup(Map<String, Object> generalMap);

	Map<String, Object> getHospitalName(Map<String, Object> mapForDs);

	Map<String, Object> showCashRegisterJsp(Box box);

	Map<String, Object> displayCashBook(Box box);
	
	Map<String, Object> showAccountSubGroupNew(Map<String, Object> generalMap);
	
	Map<String, Object> showAccountMasterNew(Map<String, Object> generalMap);
	
	Map<String, Object> showChequeDetailJsp(Box box);
	
	Map<String, Object> showChequePrintingJsp(Box box);
	
	Map<String, Object> showFixedDepositRegisterJsp(Box box);
	
	Map<String, Object> showHrInsuranceDetailsJsp(Map<String, Object> generalMap);
	
	Map<String, Object> searchAccountGroupNew(Map<String, Object> generalMap);
	
	Map<String, Object> addAccountGroupNew(Map<String, Object> generalMap);
	
	Map<String, Object> searchAccountSubGroup(Map<String, Object> generalMap);
	
	Map<String, Object> addAccountSubGroupNew(Map<String, Object> generalMap);

	Map<String, Object> updateAccountGroupNew(Box box);

	Map<String, Object> deleteAccountGroupNew(Box box);

	boolean updateAccountSubGroupNew(Map<String, Object> generalMap);

	boolean deleteAccountSubGroupNew(int accountGroupId,
			Map<String, Object> generalMap);

	boolean editAccountMaster(Map<String, Object> generalMap);

	Map<String, Object> showCashVoucherJsp(Box box);

	Map<String, Object> displayLedgerBook(Box box);

	Map<String, Object> showSubLedgerPopupJsp(Map<String, Object> generalMap);

	Map<String, Object> showLedgerJsp(Box box);

	Map<String, Object> getTrialBalance(Box box);

	Map<String, Object> getSubGroupWiseTrialBalance(Box box);

	Map<String, Object> getAccountWiseTrialBalance(Box box);

	Map<String, Object> getVoucherWiseWiseTrialBalance(Box box);

	Map<String, Object> showBalanceSheet(Box box);

	Map<String, Object> generateBalanceSheetJsp(Box box);

	Map<String, Object> displayScheduleDetail(Box box);

	Map<String, Object> deleteAccountSubLedger(Box box);

	Map<String, Object> showAccountBalance(Box box);

	Map<String, Object> submitOpeningBalance(Box box);

	int getAccountSubGroup(int accountId);

	List<Object[]> getCentreList();

	List<Object[]> getAccountList(Box box);

	List<Object[]> getSubledgerList(Box box);

	Map<String, Object> getConsolidatedTransactionDetails(Box box);

	Map<String, Object> getTransactionHistory(Box box);

	Map<String, Object> showBankReconcillationReportJsp(Box box);

	Map<String, Object> showIncomeExpenditureReportJsp(Box box);

	String getFinancialYear(int financialYearId);

	Map<String, Object> showFixedAssetReportJsp(Box box);

	Map<String, Object> showSchemeWiseFundAllocateJsp();

	Map<String, Object> addSchemeWiseFundAllocate(Box box);

	Map<String, Object> updateSchemeWiseFundAllocate(Box box);

	boolean deleteSchemeWiseFundAllocate(Box box);

	Map<String, Object> searchSchemeWiseFundAllocate(Box box);

	String getAccountSubGroupFlag(int accountId);

	Map<String, Object> submitAccountsParameterMainCharge(Box box);

	String getEmployeeName(int empId);

	Map<String, Object> showIncomeExpenditureReportWardLevelJsp(Box box);

	Map<String, Object> getSubLedgerForAccount1(Map<String, Object> parameterMap);

	Map<String, Object> showFundReceiveAndExpenseReport(Map<String, Object> map);

	Map<String, Object> getValueForchequeNo(int chqueId);

	Map<String, Object> getDataForExcel(Map<String, Object> generalMap);

	Map<String, Object> getDataForReport(Date fromDate, Date toDate);

	Map<String, Object> printPettyCashVoucherVHNSCExcel(Map<String, Object> generalMap);

	Map<String, Object> printDoubleColumnCashBook(Map<String, Object> generalMap);

	Map<String, Object> getWaitingListForVoucherApproval(int employeeLevel,int hospitalId);

	Map<String, Object> getDetailsForVoucherApproval(int voucherId);

	boolean aproveVoucher(int employeeLevel, int voucherId);

	boolean rejectVoucher(int employeeLevel, int voucherId,String remarksForReject);

	List<MasStoreFinancial> getmasStoreFinancialList(int fYearId);

	Map<String, Object> getSchemeDetails();

	Map<String, Object> showEMDRegisterJsp(Box box);

	Map<String, Object> submitEMDRegister(Box box);

	Map<String, Object> editEMDRegister(Box box);

	

	

	










}
