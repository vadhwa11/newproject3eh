package jkt.hms.masters.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.BlPriority;
import jkt.hms.masters.business.FaMasAccount;
import jkt.hms.masters.business.FaMasAccountType;
import jkt.hms.masters.business.MasBankMaster;
import jkt.hms.masters.business.MasBillScheme;
import jkt.hms.masters.business.MasBillType;
import jkt.hms.masters.business.MasChargeCodeRates;
import jkt.hms.masters.business.MasChargeType;
import jkt.hms.masters.business.MasDiscount;
import jkt.hms.masters.business.MasSalesTaxType;
import jkt.hms.masters.business.MasScheme;
import jkt.hms.masters.dataservice.BillingMasterDataService;
import jkt.hms.util.Box;

public class BillingMasterHandlerServiceImpl implements
		BillingMasterHandlerService {
	BillingMasterDataService billingMasterDataService = null;

	// ------------------------------------------AccountType
	// -----------------------------------

	public boolean addAccountType(FaMasAccountType faMasAccountType) {
		return billingMasterDataService.addAccountType(faMasAccountType);
	}

	public boolean editAccountTypeToDatabase(Map<String, Object> generalMap) {
		return billingMasterDataService.editAccountTypeToDatabase(generalMap);
	}

	public Map<String, Object> searchAccountType(String accountTypeCode,
			String accountTypeName) {
		return billingMasterDataService.searchAccountType(accountTypeCode,
				accountTypeName);
	}

	public Map<String, Object> showAccountTypeJsp() {
		return billingMasterDataService.showAccountTypeJsp();
	}

	public boolean deleteAccountType(int accountTypeId,
			Map<String, Object> generalMap) {
		return billingMasterDataService.deleteAccountType(accountTypeId,
				generalMap);
	}

	// -------------------------------------------- Charge
	// Type-----------------------------------

	public boolean addChargeType(MasChargeType masChargeType) {
		return billingMasterDataService.addChargeType(masChargeType);
	}

	public boolean editChargeTypeToDatabase(Map<String, Object> generalMap) {
		return billingMasterDataService.editChargeTypeToDatabase(generalMap);
	}

	public Map<String, Object> searchChargeType(String chargeTypeCode,
			String chargeTypeName) {
		return billingMasterDataService.searchChargeType(chargeTypeCode,
				chargeTypeName);
	}

	public Map<String, Object> showChargeTypeJsp() {
		return billingMasterDataService.showChargeTypeJsp();
	}

	public boolean deleteChargeType(int chargeTypeId,
			Map<String, Object> generalMap) {
		return billingMasterDataService.deleteChargeType(chargeTypeId,
				generalMap);
	}

	// --------------------------------------------Bill
	// Type------------------------------------------------------

	public Map<String, Object> showBillTypeJsp() {
		return billingMasterDataService.showBillTypeJsp();
	}

	public Map<String, Object> searchBillType(String billTypeCode,
			String billTypeName) {
		return billingMasterDataService.searchBillType(billTypeCode,
				billTypeName);
	}

	public boolean addBillType(MasBillType masBillType) {
		return billingMasterDataService.addBillType(masBillType);
	}

	public boolean deleteBillType(int billTypeId, Map<String, Object> generalMap) {
		return billingMasterDataService.deleteBillType(billTypeId, generalMap);
	}

	public boolean editBillTypeToDatabase(Map<String, Object> generalMap) {
		return billingMasterDataService.editBillTypeToDatabase(generalMap);
	}

	// -------------------------- Bank Master----------------------------------

	public Map<String, Object> searchBank(String bankCode, String bankName) {
		return billingMasterDataService.searchBank(bankCode, bankName);
	}

	public Map<String, Object> showBankJsp() {
		return billingMasterDataService.showBankJsp();
	}

	public boolean addBank(MasBankMaster masBank) {
		return billingMasterDataService.addBank(masBank);
	}

	public boolean editBankToDatabase(Map<String, Object> generalMap) {
		return billingMasterDataService.editBankToDatabase(generalMap);
	}

	public boolean deleteBank(int bankId, Map<String, Object> generalMap) {
		return billingMasterDataService.deleteBank(bankId, generalMap);
	}

	// -------------------------- Sales Tax Type
	// Master----------------------------------

	public Map<String, Object> searchSalesTaxType(String salesTaxTypeCode,
			String salesTaxTypeName) {
		return billingMasterDataService.searchSalesTaxType(salesTaxTypeCode,
				salesTaxTypeName);
	}

	public Map<String, Object> showSalesTaxTypeJsp() {
		return billingMasterDataService.showSalesTaxTypeJsp();
	}

	public boolean addSalesTaxType(MasSalesTaxType masSalesTaxType) {
		return billingMasterDataService.addSalesTaxType(masSalesTaxType);
	}

	public boolean editSalesTaxTypeToDatabase(Map<String, Object> generalMap) {
		return billingMasterDataService.editSalesTaxTypeToDatabase(generalMap);
	}

	public boolean deleteSalesTaxType(int salesTaxTypeId,
			Map<String, Object> generalMap) {
		return billingMasterDataService.deleteSalesTaxType(salesTaxTypeId,
				generalMap);
	}

	public Map<String, Object> showDiscountJsp(Box box) {

		return billingMasterDataService.showDiscountJsp(box);
	}

	public Map<String, Object> saveDiscount(Box box) {
		return billingMasterDataService.saveDiscount(box);
	}

	public Map<String, Object> searchDiscountList(Box box) {
		return billingMasterDataService.searchDiscountList(box);
	}

	public Map<String, Object> getDiscountDetailsForEdit(int discountId) {
		return billingMasterDataService.getDiscountDetailsForEdit(discountId);
	}

	public Map<String, Object> editDiscountDetails(Box box) {
		return billingMasterDataService.editDiscountDetails(box);
	}

	@Override
	public List<MasDiscount> checkExistingDiscountDetails(
			Map<String, Object> parameterMap,Box box) {
		return billingMasterDataService
				.checkExistingDiscountDetails(parameterMap,box);
	}

	public Map<String, Object> addAccountMaster(FaMasAccount faMasAccount) {

		return billingMasterDataService.addAccountMaster(faMasAccount);
	}

	public Map<String, Object> showAccountMasterJsp() {

		return billingMasterDataService.showAccountMasterJsp();
	}

	public Map<String, Object> editAccountMaster(Map<String, Object> generalMap) {

		return billingMasterDataService.editAccountMaster(generalMap);
	}

	public Map<String, Object> deleteAccountMaster(
			Map<String, Object> generalMap) {

		return billingMasterDataService.deleteAccountMaster(generalMap);
	}

	public Map<String, Object> searchAccountMaster(String accountCode,
			String accountName) {

		return billingMasterDataService.searchAccountMaster(accountCode,
				accountName);
	}

	public Map<String, Object> showDailyChargeSetupJsp() {
		return billingMasterDataService.showDailyChargeSetupJsp();
	}

	public Map<String, Object> addChargeForDailyChargeSetup(Box box) {
		return billingMasterDataService.addChargeForDailyChargeSetup(box);
	}

	public Map<String, Object> editChargeForDailyChargeSetup(Box box) {
		return billingMasterDataService.editChargeForDailyChargeSetup(box);
	}

	public Map<String, Object> deleteChargeForDailyChargeSetup(Box box) {
		return billingMasterDataService.deleteChargeForDailyChargeSetup(box);
	}

	public Map<String, Object> searchDailyChargeSetup(Box box) {
		return billingMasterDataService.searchDailyChargeSetup(box);
	}

	// ---------------------------------------------------------------------
	public BillingMasterDataService getBillingMasterDataService() {
		return billingMasterDataService;
	}

	public void setBillingMasterDataService(
			BillingMasterDataService billingMasterDataService) {
		this.billingMasterDataService = billingMasterDataService;
	}

	@Override
	public Map<String, Object> getDrugNamesForAutocomplete(Map<String, Object> dataMap) {
		return billingMasterDataService.getDrugNamesForAutocomplete(dataMap);
	}

	@Override
	public Boolean checkMasChargeCodeStatus(int chargeCodeId) {
		return billingMasterDataService.checkMasChargeCodeStatus(chargeCodeId);
	}

	@Override
	public Map<String, Object> showBillingSchemeMasterJsp() {
		return billingMasterDataService.showBillingSchemeMasterJsp();
	}

	@Override
	public boolean addBillingSchemeMaster(MasBillScheme faMasAccountType) {
		return billingMasterDataService.addBillingSchemeMaster(faMasAccountType);
	}

	@Override
	public boolean editBillingSchemeMaster(Map<String, Object> generalMap) {
		return billingMasterDataService.editBillingSchemeMaster(generalMap);
	}

	@Override
	public boolean deleteBillingSchemeMaster(int accountTypeId,
			Map<String, Object> generalMap) {
		return billingMasterDataService.deleteBillingSchemeMaster(accountTypeId,generalMap);
	}
	
	@Override
	public Map<String, Object> getItemCategoryDetails(Box box) {
		return billingMasterDataService.getItemCategoryDetails(box);
	}
	
	@Override
	public Map<String, Object> getChargeForExclude(Box box) {
		return billingMasterDataService.getChargeForExclude(box);
	}
	
	@Override
	public Map<String, Object> getItemForExclude(Box box) {
		return billingMasterDataService.getItemForExclude(box);
	}

	@Override
	public Map showScheme() {
		// TODO Auto-generated method stub
		return billingMasterDataService.showScheme();
	}

	@Override
	public boolean addScheme(MasScheme masScheme,Map<String, Object> objectMap) {
		// TODO Auto-generated method stub
		return billingMasterDataService.addScheme(masScheme,objectMap);
	}

	@Override
	public boolean editScheme(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return billingMasterDataService.editScheme(generalMap);
	}

	@Override
	public Map<String, Object> searchScheme(String schemeCode, String schemeName) {
		// TODO Auto-generated method stub
		return billingMasterDataService.searchScheme(schemeCode, schemeName);
	}

	@Override
	public boolean deleteScheme(int schemeId, Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return billingMasterDataService.deleteScheme(schemeId, generalMap);
	}
	
	@Override
	public List<MasScheme> listScheme(Box box)
	{
		// TODO Auto-generated method stub
		return billingMasterDataService.listScheme(box);
	}
	
	@Override
	public Map showLocalCharge(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return billingMasterDataService.showLocalCharge(generalMap);
	}
	
	@Override
	public Map checkDuplicateLocalCharge(int chargeId,int hospitalId) {
		return billingMasterDataService.checkDuplicateLocalCharge(chargeId,hospitalId);
	}
	
	@Override
	public boolean addLocalCharge(MasChargeCodeRates chargeCodeRates) {
		// TODO Auto-generated method stub
		return billingMasterDataService.LocalCharge(chargeCodeRates);
	}
	
	@Override
	public boolean editLocalCharge(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return billingMasterDataService.editLocalCharge(generalMap);
	}
	
	@Override
	public Map<String, Object> searchLocalCharge(String chargeCode, String chargeName,int hospitalId) {
		// TODO Auto-generated method stub
		return billingMasterDataService.searchLocalCharge(chargeCode, chargeName,hospitalId);
	}

	@Override
	public boolean deleteDiscount(int discountId, Map<String, Object> generalMap) {
		return billingMasterDataService.deleteDiscount(discountId, generalMap);
	}

	@Override
	public Map<String, Object> showPriorityJsp() {
		// TODO Auto-generated method stub
		return billingMasterDataService.showPriorityJsp();
	}

	@Override
	public boolean addPriorityType(BlPriority blPriority) {
		// TODO Auto-generated method stub
		return billingMasterDataService.addPriorityType(blPriority);
	}

	@Override
	public Map<String, Object> searchPriorityType(String priorityCode,
			String priorityName) {
		// TODO Auto-generated method stub
		return  billingMasterDataService.searchPriorityType(priorityCode,
				priorityName);
	}

	@Override
	public boolean deletePriorityType(int priorityId,
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return billingMasterDataService.deletePriorityType(priorityId,generalMap);
	}

	@Override
	public boolean editPriorityType(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return billingMasterDataService.editPriorityType(generalMap);
	}
	
	// Added by Amit Das on 29-02-2016
	@Override
	public List<MasScheme> listSchemeForDiscount(Box box)
	{
		// TODO Auto-generated method stub
		return billingMasterDataService.listSchemeForDiscount(box);
	}
	
	
}
