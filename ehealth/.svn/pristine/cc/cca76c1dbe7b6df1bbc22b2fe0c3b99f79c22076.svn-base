package jkt.hms.masters.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.CssdInstrumentMaster;
import jkt.hms.masters.business.MasEmpaneled;
import jkt.hms.masters.business.MasItemCategory;
import jkt.hms.masters.business.MasItemClass;
import jkt.hms.masters.business.MasItemType;
import jkt.hms.masters.business.MasManufacturer;
import jkt.hms.masters.business.MasSalesType;
import jkt.hms.masters.business.MasStoreAirForceDepot;
import jkt.hms.masters.business.MasStoreBudget;
import jkt.hms.masters.business.MasStoreBudgetT;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.MasStoreGroup;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreItemConversion;
import jkt.hms.masters.business.MasStoreItemGeneric;
import jkt.hms.masters.business.MasStoreMeScale;
import jkt.hms.masters.business.MasStorePharmaIndex;
import jkt.hms.masters.business.MasStorePoDeliveryTerms;
import jkt.hms.masters.business.MasStoreSection;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.MasStoreSupplierType;
import jkt.hms.masters.business.MasStoreUnit;
import jkt.hms.masters.business.MasStoreVendorWiseManufacturer;
import jkt.hms.masters.dataservice.PharmacyMasterDataService;
import jkt.hms.util.Box;

public class PharmacyMasterHandlerServiceImpl implements
		PharmacyMasterHandlerService {
	PharmacyMasterDataService pharmacyMasterDataService = null;

	// ------------------------------Item
	// Type-----------------------------------
	public Map<String, Object> showItemTypeJsp() {
		return pharmacyMasterDataService.showItemTypeJsp();
	}

	public Map<String, Object> searchItemType(String itemTypeCode,
			String itemTypeName) {
		return pharmacyMasterDataService.searchItemType(itemTypeCode,
				itemTypeName);
	}

	public boolean addItemType(MasItemType masItemType) {
		return pharmacyMasterDataService.addItemType(masItemType);
	}

	public boolean deleteItemType(int itemTypeId, Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteItemType(itemTypeId, generalMap);
	}

	public boolean editItemTypeToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editItemTypeToDatabase(generalMap);
	}

	// ---------------------------------
	// Manufacturer-------------------------------

	public Map<String, Object> showManufacturerJsp() {
		return pharmacyMasterDataService.showManufacturerJsp();
	}

	public boolean addManufacturer(MasManufacturer masManufacturer) {
		return pharmacyMasterDataService.addManufacturer(masManufacturer);
	}

	public boolean deleteManufacturer(int manufacturerId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteManufacturer(manufacturerId,
				generalMap);
	}

	public boolean editManufacturerToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editManufacturerToDatabase(generalMap);
	}

	public Map<String, Object> searchManufacturer(String manufacturerCode,
			String manufacturerName) {
		return pharmacyMasterDataService.searchManufacturer(manufacturerCode,
				manufacturerName);
	}

	// ------------------------------ Sales
	// Type-----------------------------------
	public boolean addSalesType(MasSalesType masSalesType) {
		return pharmacyMasterDataService.addSalesType(masSalesType);
	}

	public boolean deleteSalesType(Integer salesTypeId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteSalesType(salesTypeId,
				generalMap);
	}

	public boolean editSalesType(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editSalesType(generalMap);
	}

	public Map<String, Object> showSalesTypeJsp() {
		return pharmacyMasterDataService.showSalesTypeJsp();
	}

	public Map<String, Object> searchSalesType(String salesTypeCode,
			String salesTypeName) {
		return pharmacyMasterDataService.searchSalesType(salesTypeCode,
				salesTypeName);
	}

	// -----------------------Item Category
	// --------------------------------------

	public boolean addItemCategory(MasItemCategory masItemCategory) {
		return pharmacyMasterDataService.addItemCategory(masItemCategory);
	}

	public Map searchItemCategory(String itemCategoryCode,
			String itemCategoryName) {
		return pharmacyMasterDataService.searchItemCategory(itemCategoryCode,
				itemCategoryName);
	}

	public Map showItemCategoryJsp() {
		return pharmacyMasterDataService.showItemCategoryJsp();
	}

	public boolean deleteItemCategory(int itemCategoryId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteItemCategory(itemCategoryId,
				generalMap);
	}

	public boolean editItemCategoryToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editItemCategoryToDatabase(generalMap);
	}

	// ---------------------------------------Item
	// Class-----------------------------------

	
	  public Map<String, Object> showItemClassJsp() {
		  return  pharmacyMasterDataService.showItemClassJsp();
		 }
	  public boolean addItemClass(MasItemClass masItemClass) {
		  return pharmacyMasterDataService.addItemClass(masItemClass); }
	  
	  public boolean deleteItemClass(int itemClassId,Map<String, Object> generalMap)
	  {
		  return pharmacyMasterDataService.deleteItemClass(itemClassId,generalMap);
		 }
	  
	  public boolean editItemClassToDatabase(Map<String, Object> generalMap) {
		  return pharmacyMasterDataService.editItemClassToDatabase(generalMap); 
	  }
	  
	  public Map<String, Object> searchItemClass(String itemClassCode,String itemClassName) {
		  return pharmacyMasterDataService.searchItemClass(itemClassCode,itemClassName); 
		  }
	 
	// ------------------------------- Store Supplier Type
	// --------------------------------
	public boolean addStoreSupplierType(
			MasStoreSupplierType masStoreSupplierType) {
		return pharmacyMasterDataService
				.addStoreSupplierType(masStoreSupplierType);
	}

	public boolean deleteStoreSupplierType(int storeSupplierTypeId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteStoreSupplierType(
				storeSupplierTypeId, generalMap);
	}

	public boolean editStoreSupplierTypeToDatabase(
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService
				.editStoreSupplierTypeToDatabase(generalMap);
	}

	public Map<String, Object> showStoreSupplierTypeJsp() {
		return pharmacyMasterDataService.showStoreSupplierTypeJsp();
	}

	public Map<String, Object> searchStoreSupplierType(
			String storeSupplierTypeCode, String storeSupplierTypeName) {
		return pharmacyMasterDataService.searchStoreSupplierType(
				storeSupplierTypeCode, storeSupplierTypeName);
	}

	// ------------------------------Store
	// Supplier-----------------------------------
	public boolean addStoreSupplier(MasStoreSupplier masStoreSupplier,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.addStoreSupplier(masStoreSupplier,
				generalMap);
	}

	public boolean deleteStoreSupplier(Integer storeSupplierId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteStoreSupplier(storeSupplierId,
				generalMap);
	}

	public boolean editStoreSupplierToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService
				.editStoreSupplierToDatabase(generalMap);
	}

	public Map<String, Object> showStoreSupplierJsp() {
		return pharmacyMasterDataService.showStoreSupplierJsp();
	}

	public Map<String, Object> searchStoreSupplier(String storeSupplierCode,
			String storeSupplierName) {
		return pharmacyMasterDataService.searchStoreSupplier(storeSupplierCode,
				storeSupplierName);
	}

	// -----------------------------Item Type
	// Supplier-----------------------------------
	/*
	 * public boolean addItemWiseSupplier(MasItemWiseSupplier
	 * masItemWiseSupplier) { return
	 * pharmacyMasterDataService.addItemWiseSupplier(masItemWiseSupplier); }
	 * public boolean deleteItemWiseSupplier(Integer
	 * itemWiseSupplierId,Map<String, Object> generalMap) { return
	 * pharmacyMasterDataService
	 * .deleteItemWiseSupplier(itemWiseSupplierId,generalMap); } public boolean
	 * editItemWiseSupplier(Map<String, Object> generalMap) { return
	 * pharmacyMasterDataService.editItemWiseSupplier(generalMap); } public
	 * Map<String, Object> getItemWiseSupplier() { return
	 * pharmacyMasterDataService.getItemWiseSupplier(); }
	 * 
	 * @SuppressWarnings("unchecked") public Map<String,Object>
	 * searchItemWiseSupplier(String itemWiseSupplierCode,String
	 * itemWiseSupplierName) { return
	 * pharmacyMasterDataService.searchItemWiseSupplier(itemWiseSupplierCode,
	 * itemWiseSupplierName); } public boolean checkItem(int itemId) { return
	 * pharmacyMasterDataService.checkItem(itemId); }
	 */

	// ---------------------------Item generic--------------------
	public Map<String, Object> showItemGenericJsp() {
		return pharmacyMasterDataService.showItemGenericJsp();
	}

	public Map<String, Object> searchItemGeneric(String genericName) {
		return pharmacyMasterDataService.searchItemGeneric(genericName);
	}

	public boolean addItemGeneric(MasStoreItemGeneric masStoreItemGeneric) {
		return pharmacyMasterDataService.addItemGeneric(masStoreItemGeneric);
	}

	public boolean deleteItemGeneric(int itemGenericId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteItemGeneric(itemGenericId,
				generalMap);
	}

	public boolean editItemGeneric(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editItemGeneric(generalMap);
	}

	// ----------------------------------ITEM--------------------------------------------
	public Map<String, Object> showItemJsp(int deptId) {
		return pharmacyMasterDataService.showItemJsp(deptId);
	}

	public boolean addItem(MasStoreItem masStoreItem,Map<String, Object> map) {
		return pharmacyMasterDataService.addItem(masStoreItem, map);
	}

	public boolean editItem(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editItem(generalMap);
	}

	public boolean deleteItem(Integer itemId, Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteItem(itemId, generalMap);
	}

	public Map<String, Object> getGroupDepartmentWise(
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.getGroupDepartmentWise(generalMap);
	}

	// -----------------------------Section-----------------------
	public boolean addStoreSection(MasStoreSection masStoreSection) {
		return pharmacyMasterDataService.addStoreSection(masStoreSection);
	}

	public boolean deleteStoreSection(int sectionId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteStoreSection(sectionId,
				generalMap);
	}

	public boolean editStoreSectionToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editStoreSectionToDatabase(generalMap);
	}

	public Map<String, Object> searchStoreSection(String sectionCode,
			String sectionName) {
		return pharmacyMasterDataService.searchStoreSection(sectionCode,
				sectionName);
	}

	public Map<String, Object> showStoreSectionJsp() {
		return pharmacyMasterDataService.showStoreSectionJsp();
	}

	// ------------------------------------------StoreVendorWiseManufacturer----------------------------
	public boolean addStoreVendorWiseManufacturer(
			MasStoreVendorWiseManufacturer masStoreVendorWiseManufacturer) {
		return pharmacyMasterDataService
				.addStoreVendorWiseManufacturer(masStoreVendorWiseManufacturer);
	}

	public boolean deleteStoreVendorWiseManufacturer(
			int storeVendorWiseManufacturerId, Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteStoreVendorWiseManufacturer(
				storeVendorWiseManufacturerId, generalMap);
	}

	public Map<String, Object> searchStoreVendorWiseManufacturer(
			String storeVendorWiseManufacturerCode) {
		return pharmacyMasterDataService
				.searchStoreVendorWiseManufacturer(storeVendorWiseManufacturerCode);
	}

	public Map<String, Object> showStoreVendorWiseManufacturerJsp() {
		return pharmacyMasterDataService.showStoreVendorWiseManufacturerJsp();
	}

	public boolean editStoreVendorWiseManufacturerToDatabase(
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService
				.editStoreVendorWiseManufacturerToDatabase(generalMap);
	}

	// ---------------------Financial----------------------------------------------

	public boolean addFinancial(MasStoreFinancial masStoreFinancial) {
		return pharmacyMasterDataService.addFinancial(masStoreFinancial);
	}

	public boolean deleteFinancial(int financialId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteFinancial(financialId,
				generalMap);
	}

	public boolean editFinancialToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editFinancialToDatabase(generalMap);
	}

	public Map<String, Object> searchFinancial(Date startDate, Date endDate) {
		return pharmacyMasterDataService.searchFinancial(startDate, endDate);
	}

	public Map<String, Object> showFinancialJsp() {
		return pharmacyMasterDataService.showFinancialJsp();
	}

	// ----------------------------Pharma Index------------------------

	public boolean addPharmaIndex(MasStorePharmaIndex masStorePharmaIndex) {
		return pharmacyMasterDataService.addPharmaIndex(masStorePharmaIndex);
	}

	public boolean editPharmaIndexToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editPharmaIndexToDatabase(generalMap);
	}

	public Map<String, Object> searchPharmaIndex(String pharmaIndexName) {
		return pharmacyMasterDataService.searchPharmaIndex(pharmaIndexName);
	}

	public Map<String, Object> showPharmaIndexJsp() {
		return pharmacyMasterDataService.showPharmaIndexJsp();
	}

	public boolean deletePharmaIndex(int pharmaIndexId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deletePharmaIndex(pharmaIndexId,
				generalMap);
	}

	// ----------------------------------Item
	// Unit-----------------------------------------

	public boolean addItemUnit(MasStoreUnit masStoreUnit) {
		return pharmacyMasterDataService.addItemUnit(masStoreUnit);
	}

	public boolean editItemUnitToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editItemUnitToDatabase(generalMap);
	}

	public Map<String, Object> searchItemUnit(String unitName) {
		return pharmacyMasterDataService.searchItemUnit(unitName);
	}

	public Map<String, Object> showItemUnitJsp() {
		return pharmacyMasterDataService.showItemUnitJsp();
	}

	public boolean deleteItemUnit(int itemUnitId, Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteItemUnit(itemUnitId, generalMap);
	}

	// --------------------------Item
	// Conversion----------------------------------------

	public Map<String, Object> showItemConversionJsp() {
		return pharmacyMasterDataService.showItemConversionJsp();
	}

	public Map<String, Object> searchItemConversion(String itemUnitName) {
		return pharmacyMasterDataService.searchItemConversion(itemUnitName);
	}

	public boolean addItemConversion(
			MasStoreItemConversion masStoreItemConversion) {
		return pharmacyMasterDataService
				.addItemConversion(masStoreItemConversion);
	}

	public boolean editItemConversionToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService
				.editItemConversionToDatabase(generalMap);
	}

	public boolean deleteItemConversion(int itemConversionId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteItemConversion(itemConversionId,
				generalMap);
	}

	// ------------------------------PO
	// Delivery---------------------------------------
	public Map<String, Object> showPoDeliveryTermsJsp() {
		return pharmacyMasterDataService.showPoDeliveryTermsJsp();
	}

	public Map<String, Object> searchPoDeliveryTerms(String poDeliveryType) {
		return pharmacyMasterDataService.searchPoDeliveryTerms(poDeliveryType);
	}

	public boolean addPoDeliveryTerms(
			MasStorePoDeliveryTerms masStorePoDeliveryTerms) {
		return pharmacyMasterDataService
				.addPoDeliveryTerms(masStorePoDeliveryTerms);
	}

	public boolean deletePoDeliveryTerms(int poDeliveryTermsId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deletePoDeliveryTerms(
				poDeliveryTermsId, generalMap);
	}

	public boolean editPoDeliveryTermsToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService
				.editPoDeliveryTermsToDatabase(generalMap);
	}

	// ------------------------Budget Entry
	// Master-------------------------------------------
	public Map<String, Object> showBudgetJsp() {
		return pharmacyMasterDataService.showBudgetJsp();
	}

	/*
	 * public Map<String, Object> searchBudget(String code) { return
	 * pharmacyMasterDataService.searchBudget(code); } public boolean
	 * addBudget(MasStoreBudget masStoreBudget) { return
	 * pharmacyMasterDataService.addBudget(masStoreBudget); } public boolean
	 * deleteBudget(int budgetId,Map<String, Object> generalMap) { return
	 * pharmacyMasterDataService.deleteBudget(budgetId,generalMap); } public
	 * boolean editBudgetToDatabase(Map<String, Object> generalMap) { return
	 * pharmacyMasterDataService.editBudgetToDatabase(generalMap); }
	 */
	public Map<String, Object> getFinancialYearDetails(int financialId) {
		return pharmacyMasterDataService.getFinancialYearDetails(financialId);
	}

	public boolean addBudgetDetails(Map<String, Object> budgetMap) {
		return pharmacyMasterDataService.addBudgetDetails(budgetMap);
	}

	public boolean addBudgetEntry(MasStoreBudget masStoreBudget,
			List<MasStoreBudgetT> masStoreBudgetTList,
			Map<String, Object> infoMap) {
		return pharmacyMasterDataService.addBudgetEntry(masStoreBudget,
				masStoreBudgetTList, infoMap);
	}

	public int getMasStoreBudgetId(int budgetCode) {
		return pharmacyMasterDataService.getMasStoreBudgetId(budgetCode);
	}

	public Map<String, Object> searchMasStoreBudget(
			Map<String, Object> searchFieldMap) {
		return pharmacyMasterDataService.searchMasStoreBudget(searchFieldMap);
	}

	public Map<String, Object> getBudgetEntryModifyMap(int radio_str) {
		return pharmacyMasterDataService.getBudgetEntryModifyMap(radio_str);
	}

	public Map<String, Object> getBudgetAndTUpdate(int budgetId) {
		return pharmacyMasterDataService.getBudgetAndTUpdate(budgetId);
	}

	public boolean updateBudgetEntry(MasStoreBudget masStoreBudget,
			List<MasStoreBudgetT> masStoreBudgetTList) {
		return pharmacyMasterDataService.updateBudgetEntry(masStoreBudget,
				masStoreBudgetTList);
	}

	// ----------------------------Me Scale----------------------------------
	public boolean addMeScale(MasStoreMeScale masStoreMeScale) {
		return pharmacyMasterDataService.addMeScale(masStoreMeScale);
	}

	public boolean deleteMeScale(int meScaleId, Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteMeScale(meScaleId, generalMap);
	}

	public boolean editMeScaleToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editMeScaleToDatabase(generalMap);
	}

	public Map<String, Object> showMeScaleJsp() {
		return pharmacyMasterDataService.showMeScaleJsp();
	}

	// ------------------------AirForceUnitDepot--------------------------------

	public boolean addAirForceUnitDepot(
			MasStoreAirForceDepot masStoreAirForceDepot) {
		return pharmacyMasterDataService
				.addAirForceUnitDepot(masStoreAirForceDepot);
	}

	public boolean deleteAirForceUnitDepot(int airForceDepotId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteAirForceUnitDepot(
				airForceDepotId, generalMap);
	}

	public boolean editAirForceUnitDepotToDatabase(
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService
				.editAirForceUnitDepotToDatabase(generalMap);
	}

	public Map<String, Object> searchAirForceUnitDepot(String airForceDepotName) {
		return pharmacyMasterDataService
				.searchAirForceUnitDepot(airForceDepotName);
	}

	public Map<String, Object> showAirForceUnitDepotJsp() {
		return pharmacyMasterDataService.showAirForceUnitDepotJsp();
	}

	// -------------------------------------------------------------------------------------
	public PharmacyMasterDataService getPharmacyMasterDataService() {
		return pharmacyMasterDataService;
	}

	public void setPharmacyMasterDataService(
			PharmacyMasterDataService pharmacyMasterDataService) {
		this.pharmacyMasterDataService = pharmacyMasterDataService;
	}

	public Map<String, Object> searchMeScale1(int meScaleNumber) {
		return pharmacyMasterDataService.searchMeScale1(meScaleNumber);
	}

	public Map<String, Object> searchItem(String pvmsNo, String nomenclature) {
		return pharmacyMasterDataService.searchItem(pvmsNo, nomenclature);
	}

	public Map<String, Object> getConnection() {
		return pharmacyMasterDataService.getConnection();
	}

	/*
	 * public Map<String, Object> searchItem(String nomenclature) { // TODO
	 * Auto-generated method stub return null; }
	 */

	// ---------------------------Mas Store
	// Group---------------------------------
	public boolean addStoreGroup(MasStoreGroup masStoreGroup) {
		return pharmacyMasterDataService.addStoreGroup(masStoreGroup);
	}

	public boolean deleteStoreGroup(int groupId, Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteStoreGroup(groupId, generalMap);
	}

	public boolean editGroupToDatabase(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editGroupToDatabase(generalMap);
	}

	public Map<String, Object> searchStoreGroup(String groupCode,
			String groupName) {
		return pharmacyMasterDataService.searchStoreGroup(groupCode, groupName);
	}

	public Map<String, Object> showStoreGroupJsp() {
		return pharmacyMasterDataService.showStoreGroupJsp();
	}

	public List<MasStoreItem> checkForExistingPvmsNo(String pvmsNo) {
		return pharmacyMasterDataService.checkForExistingPvmsNo(pvmsNo);
	}

	public Map<String, Object> getSubAccountList(Box box) {
		return pharmacyMasterDataService.getSubAccountList(box);
	}

	@Override
	public Map<String, Object> getItemTypeList(Map<String, Object> dataMap) {
		return pharmacyMasterDataService.getItemTypeList(dataMap);
	}

	@Override
	public Map<String, Object> getSectionList(Map<String, Object> dataMap) {
		return pharmacyMasterDataService.getSectionList(dataMap);
	}

	// ----------------------------------ITEM--------------------------------------------
	public Map<String, Object> showItemGlobalMedJsp(int deptId) {
		return pharmacyMasterDataService.showItemGlobalMedJsp(deptId);
	}

	public boolean addItemGlobalMed(MasStoreItem masStoreItem,Map<String, Object> map) {
		return pharmacyMasterDataService.addItemGlobalMed(masStoreItem, map);
	}

	public boolean editItemGlobalMed(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editItemGlobalMed(generalMap);
	}

	public boolean deleteItemGlobalMed(Integer itemId, Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteItemGlobalMed(itemId, generalMap);
	}
	
	public Map<String, Object> searchItemGlobalMed(String pvmsNo, String nomenclature) {
		return pharmacyMasterDataService.searchItemGlobalMed(pvmsNo, nomenclature);
	}
	// ----------------------------------ITEM--------------------------------------------
	public Map<String, Object> showItemGlobalNonMedJsp(int deptId) {
		return pharmacyMasterDataService.showItemGlobalNonMedJsp(deptId);
	}

	public Map<String, Object> addOutsideMedicineJsp(Map map) {
		return pharmacyMasterDataService.addOutsideMedicineJsp(map); 
	}
	
	public boolean addItemGlobalNonMed(MasStoreItem masStoreItem,Map<String, Object> map) {
		return pharmacyMasterDataService.addItemGlobalNonMed(masStoreItem, map);
	}

	public boolean editItemGlobalNonMed(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editItemGlobalNonMed(generalMap);
	}

	public boolean deleteItemGlobalNonMed(Integer itemId, Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteItemGlobalNonMed(itemId, generalMap);
	}
	
	public Map<String, Object> searchItemGlobalNonMed(String pvmsNo, String nomenclature) {
		return pharmacyMasterDataService.searchItemGlobalNonMed(pvmsNo, nomenclature);
	}

	@Override
	public boolean editItemLocalMed(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editItemLocalMed(generalMap);
	}
	
	public boolean deleteItemLocalMed(Integer itemId, Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteItemLocalMed(itemId, generalMap);
	}
	
	public Map<String, Object> searchItemLocalMed(String pvmsNo, String nomenclature) {
		return pharmacyMasterDataService.searchItemLocalMed(pvmsNo, nomenclature);
	}
	
	public Map<String, Object> showItemLocalMedJsp(int deptId) {
		return pharmacyMasterDataService.showItemLocalMedJsp(deptId);
	}

	
	
	@Override
	public boolean editItemLocalNonMed(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editItemLocalNonMed(generalMap);
	}
	
	public boolean deleteItemLocalNonMed(Integer itemId, Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteItemLocalNonMed(itemId, generalMap);
	}
	
	public Map<String, Object> searchItemLocalNonMed(String pvmsNo, String nomenclature) {
		return pharmacyMasterDataService.searchItemLocalNonMed(pvmsNo, nomenclature);
	}
	
	public Map<String, Object> showItemLocalNonMedJsp(int deptId) {
		return pharmacyMasterDataService.showItemLocalNonMedJsp(deptId);
	}
	@Override
	public Map<String, Object> getItemTypeGLList(Map<String, Object> dataMap) {
		return pharmacyMasterDataService.getItemTypeGLList(dataMap);
	}

	@Override
	public Map<String, Object> getSectionGLList(Map<String, Object> dataMap) {
		return pharmacyMasterDataService.getSectionGLList(dataMap);
	}

	@Override
	public Map<String, Object> getCategoryList(Box box) {
		
		return pharmacyMasterDataService.getCategoryList(box);
	}

	@Override
	public Map<String, Object> showHospitalWiseItemDetails(Box box) {
		return pharmacyMasterDataService.showHospitalWiseItemDetails(box);
	}
	
	@Override
	public Map showEmpaneled() {
		return pharmacyMasterDataService.showEmpaneled();
	}

	@Override
	public boolean deleteEmpaneled(int empaneledId,
			Map<String, Object> generalMap) {
		return pharmacyMasterDataService.deleteEmpaneled(empaneledId, generalMap);
	}

	@Override
	public Map<String, Object> searchEmpaneled(String empaneledCode,
			String empaneledName) {
		return pharmacyMasterDataService.searchEmpaneled(empaneledCode, empaneledName);
	}

	@Override
	public boolean editEmpaneled(Map<String, Object> generalMap) {
		return pharmacyMasterDataService.editEmpaneled(generalMap);
	}

	@Override
	public boolean addEmpaneled(MasEmpaneled masEmpaneled,Map<String, Object> objectMap) {
		return pharmacyMasterDataService.addEmpaneled(masEmpaneled,objectMap);
	}
}
