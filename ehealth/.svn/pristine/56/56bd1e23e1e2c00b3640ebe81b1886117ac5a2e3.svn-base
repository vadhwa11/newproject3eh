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
import jkt.hms.util.Box;

public interface BillingMasterHandlerService {
	// ----------------------------------------------Bill
	// Type---------------------------------------------

	Map<String, Object> showBillTypeJsp();

	Map<String, Object> searchBillType(String billTypeCode, String billTypeName);

	boolean addBillType(MasBillType masBillType);

	boolean editBillTypeToDatabase(Map<String, Object> generalMap);

	boolean deleteBillType(int billTypeId, Map<String, Object> generalMap);

	// -------------------------------------------- Account Type
	// ---------------------------------

	Map<String, Object> searchAccountType(String accountTypeCode,
			String accountTypeName);

	Map<String, Object> showAccountTypeJsp();

	boolean addAccountType(FaMasAccountType masAccountType);

	boolean editAccountTypeToDatabase(Map<String, Object> generalMap);

	boolean deleteAccountType(int accountTypeId, Map<String, Object> generalMap);

	// ---------------------------------------------Charge
	// Type------------------------------------

	Map<String, Object> searchChargeType(String chargeTypeCode,
			String chargeTypeName);

	Map<String, Object> showChargeTypeJsp();

	boolean addChargeType(MasChargeType masChargeType);

	boolean editChargeTypeToDatabase(Map<String, Object> generalMap);

	boolean deleteChargeType(int chargeTypeId, Map<String, Object> generalMap);

	// ------------------------------------ Bank master
	// ------------------------------------

	Map<String, Object> searchBank(String bankCode, String bankName);

	Map<String, Object> showBankJsp();

	boolean addBank(MasBankMaster masBank);

	boolean editBankToDatabase(Map<String, Object> generalMap);

	boolean deleteBank(int bankId, Map<String, Object> generalMap);

	// ------------------------------------ Sales Tax Type master
	// ------------------------------------

	Map<String, Object> searchSalesTaxType(String bankCode, String bankName);

	Map<String, Object> showSalesTaxTypeJsp();

	boolean addSalesTaxType(MasSalesTaxType masSalesTaxType);

	boolean editSalesTaxTypeToDatabase(Map<String, Object> generalMap);

	boolean deleteSalesTaxType(int salesTaxTypeId,
			Map<String, Object> generalMap);

	Map<String, Object> showDiscountJsp(Box box);

	Map<String, Object> saveDiscount(Box box);

	Map<String, Object> searchDiscountList(Box box);

	Map<String, Object> getDiscountDetailsForEdit(int discountId);

	Map<String, Object> editDiscountDetails(Box box);

	List<MasDiscount> checkExistingDiscountDetails(
			Map<String, Object> parameterMap,Box box);

	Map<String, Object> showAccountMasterJsp();

	Map<String, Object> addAccountMaster(FaMasAccount faMasAccount);

	Map<String, Object> editAccountMaster(Map<String, Object> generalMap);

	Map<String, Object> deleteAccountMaster(Map<String, Object> generalMap);

	Map<String, Object> searchAccountMaster(String accountCode,
			String accountName);

	Map<String, Object> showDailyChargeSetupJsp();

	Map<String, Object> addChargeForDailyChargeSetup(Box box);

	Map<String, Object> editChargeForDailyChargeSetup(Box box);

	Map<String, Object> deleteChargeForDailyChargeSetup(Box box);

	Map<String, Object> searchDailyChargeSetup(Box box);

	Map<String, Object> getDrugNamesForAutocomplete(Map<String, Object> dataMap);

	Boolean checkMasChargeCodeStatus(int chargeCodeId);

	Map<String, Object> showBillingSchemeMasterJsp();

	boolean addBillingSchemeMaster(MasBillScheme faMasAccountType);

	boolean editBillingSchemeMaster(Map<String, Object> generalMap);

	boolean deleteBillingSchemeMaster(int accountTypeId,
			Map<String, Object> generalMap);

	Map<String, Object> getItemCategoryDetails(Box box);

	Map<String, Object> getChargeForExclude(Box box);

	Map<String, Object> getItemForExclude(Box box);

	Map showScheme();

	boolean addScheme(MasScheme masScheme, Map<String, Object> objectMap);

	boolean editScheme(Map<String, Object> generalMap);

	Map<String, Object> searchScheme(String schemeCode, String schemeName);

	boolean deleteScheme(int schemeId, Map<String, Object> generalMap);

	List<MasScheme> listScheme(Box box);

	Map showLocalCharge(Map<String, Object> generalMap);

	Map checkDuplicateLocalCharge(int chargeId, int hospitalId);

	boolean addLocalCharge(MasChargeCodeRates chargeCodeRates);

	boolean editLocalCharge(Map<String, Object> generalMap);

	Map<String, Object> searchLocalCharge(String chargeCode, String chargeName,
			int hospitalId);

	boolean deleteDiscount(int schemeId, Map<String, Object> generalMap);

	Map<String, Object> showPriorityJsp();

	boolean addPriorityType(BlPriority blPriority);

	Map<String, Object> searchPriorityType(String priorityCode,
			String priorityName);

	boolean deletePriorityType(int priorityId, Map<String, Object> generalMap);

	boolean editPriorityType(Map<String, Object> generalMap);
	
	List<MasScheme> listSchemeForDiscount(Box box);

}
