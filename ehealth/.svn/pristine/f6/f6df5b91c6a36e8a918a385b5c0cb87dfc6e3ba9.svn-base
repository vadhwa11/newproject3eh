package jkt.hms.stores.dataservice;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.SystemException;

import jkt.hms.masters.business.CentralServerMedicineDispenseData;
import jkt.hms.masters.business.LeanServerFinalDischargeData;
import jkt.hms.masters.business.LeanServerMedicineDispenseData;
import jkt.hms.masters.business.LeanServerStockData;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.StoreBalanceM;
import jkt.hms.masters.business.StoreBalanceT;
import jkt.hms.masters.business.StoreBoo;
import jkt.hms.masters.business.StoreDefectiveDrugM;
import jkt.hms.masters.business.StoreGrnM;
import jkt.hms.masters.business.StoreGrnT;
import jkt.hms.masters.business.StoreIndentM;
import jkt.hms.masters.business.StoreIndentSocTracker;
import jkt.hms.masters.business.StoreInternalIndentM;
import jkt.hms.masters.business.StoreIssueM;
import jkt.hms.masters.business.StoreIssueT;
import jkt.hms.masters.business.StoreLoaninM;
import jkt.hms.masters.business.StoreLoaninT;
import jkt.hms.masters.business.StoreStockTakingM;
import jkt.hms.masters.business.StoreStockTakingT;
import jkt.hms.masters.business.StoreSupplyOrderEntry;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.util.Box;
import jkt.hms.util.MmfItemDetails;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public interface StoresDataService {
	// ===================== START OF GRN,LOANIN,BOO,DEFECTIVE ENTRY BY ABHA
	Map showGrnJsp(Box box, Map<String, Object> dataMap);

	public Map<String, Object> modifyGrn(int grnId, int pageNo, int spoId,
			String items);

	Map<String, Object> getDetailsForMoreInfoGrn();

	Map showLoanInJsp(Map<String, Object> dataMap);

	Map searchGrn(Map searchFieldMap) throws ParseException;

	// Map getGrnModifyMap(int radio_str);
	// Map getLoanInModifyMap(int radio_str);
	public boolean addGrns(Map<String, Object> infoMap,
			Map<String, Object> dataMap);

	boolean updateGrn(StoreGrnM storeGrnM, List list);

	boolean addLoanIn(Map<String, Object> infoMap, Map<String, Object> dataMap);

	List<StoreGrnM> getCrvNumberList();

	Map<String, Object> getIndentList(String choice);

	Map<String, Object> getVendorList(String vendor);

	Map<String, Object> getLoanInList(int poId);

	Map getBarcodeList(int grnId);

	public Map<String, Object> getGrnNoListForAutoComplete(Box box);

	List<StoreGrnT> getStoreGrnTListForMoreInfo(int storeGrnTId);

	Map getViewAllMap();

	Map searchLoanin(Map searchFieldMap) throws ParseException;

	Map<String, Object> modifyLoanin(int id, int pageNo);

	List<StoreLoaninT> getLoanInListForMoreInfo(int loaninDetailId);

	boolean updateLoanIn(Map<String, Object> infoMap);

	Map<String, Object> getDetailsForLoanIn();

	List<StoreGrnM> getGrn(int grnId);

	// Map<String, Object> grnModifyMap(int id, int pageNo);
	List<StoreLoaninM> getloanList();

	boolean submitAdjustLoanIn(int loaninId, StoreGrnM storeGrnM, int poId,
			List list, Map<String, Object> infoMap);

	Map<String, Object> getExpiryDateInAjax(Map<String, Object> dataMap);

	// Map<String, Object> modifyGrn(int id, int pageNo);
	public Map<String, Object> updateCrv(Box box);

	public Map getSOItemDetails(Box box);
	
	 Map<String,Object>  getDataForStockTransferForLeanServer();
	 
	 Map<String,Object>  getDataForMedicinePresForLeanServer();
	 
	 Map<String,Object> getDataForMedicinePresForCentralServer();
	 
	 String updateLeanServerStockData(LeanServerStockData leanServerStockData);
	 
	 String updateLeanServerMedicinePresData(LeanServerMedicineDispenseData leanServerMedicineDispenseData);
	 
	 String updateCentralServerMedicinePresData(CentralServerMedicineDispenseData centralServerMedicineDispenseData);

	List<StoreGrnM> getGrnList();

	Map<String, Object> getAdjustmentList(int workOrderId, int pageNo,
			String items);

	// ---------------------------- BOO ENTRY---------------------
	Map<String, Object> showBooJsp(Map<String, Object> infoMap);

	boolean addBoo(Map<String, Object> infoMap);

	Map searchBoo(Map searchFieldMap) throws ParseException,
			java.text.ParseException;

	Map<String, Object> getBooModifyMap(int radio_str);

	boolean updateBoo(StoreBoo storeBoo, List list);

	// -------------- connection-----
	Map<String, Object> getGrnPrintMap(int grnId);

	Map<String, Object> getContingentBillPrintMap(int grnId);

	Map<String, Object> getProformaPrintMap(int grnId);

	Map<String, Object> showGridJsp(Box box);

	Map<String, Object> showGridLoanInJsp(Box box);

	Map<String, Object> showDefectiveDrugJsp(Map<String, Object> dataMap);

	Map<String, Object> fillItemsForDefectiveDrugs(Map<String, Object> dataMap);

	Map<String, Object> getItemListForDefectiveDrugsByAutocomplete(
			Map<String, Object> dataMap);

	public Map<String, Object> addDefectiveDrugs(Map<String, Object> infoMap,
			Map<String, Object> dataMap);

	Map searchDefectiveDrug(Map searchFieldMap) throws ParseException;

	Map getDefectiveDrugModifyMap(int id, int pageNo);

	List<StoreDefectiveDrugM> getDefectDrug(int entryId);

	List<StoreDefectiveDrugM> getDefectiveList();

	Map<String, Object> defectiveDrugModifyMap(int id);

	boolean createAdjustment(Map<String, Object> infoMap);

	public Map<String, Object> findGrnLedgeraction(Map<String, Object> dataMap);

	Map getResponseIndentList(Box box);

	Map<String, Object> fillItemsForGrn(Map<String, Object> dataMap);

	Map<String, Object> fillItemsForGrnForGrnWithoutPo(
			Map<String, Object> dataMap);;

	Map<String, Object> getItemListForGrnByAutocomplete(
			Map<String, Object> dataMap);

	Map getResponsePoList(Box box);

	Map<String, Object> fillItemsForLoanIn(Map<String, Object> dataMap);

	Map<String, Object> getItemListForLoanInByAutocomplete(
			Map<String, Object> dataMap);

	List<StoreDefectiveDrugM> getDefectiveDrugsList();

	List<StoreBoo> getBooList();

	// ==========================================================================================
	// =======================END OF METHODS BY ABHA==========================
	// =================================================================================================

	// *********************************************************************************************************************
	// ------------------------------------Start of Methods Written By
	// Vivek------------------------------------------
	// ****************************************************************************************************************

	// ---------Indent To Depot------------------

	public Map<String, Object> showPrintIndentDepotJsp(
			Map<String, Object> dataMap);

	Map<String, Object> getItemListForIndentToDepot(Map<String, Object> dataMap);

	Map<String, Object> fillItemsForIndentToDepot(Map<String, Object> dataMap);

	Map<String, Object> getItemListForMMFIndentModify(
			Map<String, Object> dataMap);

	Map<String, Object> fillItemsCommon(Map<String, Object> dataMap);

	Map<String, Object> showIndentJspDepot(Map<String, Object> dataMap);

	Map<String, Object> addNextOrSubmitIndentToDepot(Map<String, Object> dataMap);

	Map<String, Object> getIndentModifyMapForDepot(int indentId, int pageNo);

	boolean updateNextIndentToDepot(Map<String, Object> masterAndDetailMap);

	Map<String, Object> getIndentDepotPrintMap(int indentId);

	// ---------End of Indent To Depot------------------
	// ---------Indent To SOC ------------------

	Map<String, Object> getItemListForIndentToSOC(Map<String, Object> dataMap);

	Map<String, Object> showIndentJspSOC(Map<String, Object> dataMap);

	Map<String, Object> addNextOrSubmitIndentToSOC(Map<String, Object> dataMap);

	Map<String, Object> getIndentModifyMapForSOC(int indentId, int pageNo);

	boolean updateNextIndentToSOC(Map<String, Object> masterAndDetailMap);

	Map getBrandListForSOC(int itemId);

	Map getBrandListForSOC(int itemId, int detailId);

	Map<String, Object> fillItemsForIndentToSOC(Map<String, Object> dataMap);

	Map<String, Object> getManufacturerNameInAjax(Map<String, Object> dataMap);

	// ---------End of Indent To SOC------------------

	// ------------------------------------Start of MMF
	// Indent-----------------------------------------------------------
	Map printMmfIndent(int indentId);

	Map<String, Object> getItemListForMMFIndent(Map<String, Object> dataMap);

	Map showIndent(int deptId);

	Map searchIndent(Map searchFieldMap) throws ParseException,
			java.text.ParseException;

	boolean addIndent(StoreIndentM storeIndentM) throws IllegalStateException,
			SystemException;

	boolean addIndents(StoreIndentM storeIndentM, List list, Map map);

	Map getIndentModifyMap(int indentId, int pageNo);

	boolean updateIndent(StoreIndentM storeIndentM, List list);

	StoreIndentM getStoresIndentMObject(int indentId);

	int getIndentId(int mmfForTheYear);

	public Map getIndentMAndTUpdate(int indentId);

	Map getIndentMAndT(int indentId);

	public Map getIndentSocPrintMap(int indentId);

	boolean updateNextIndent(Map<String, Object> masterAndDetailMap)
			throws java.text.ParseException;

	Map<String, Object> checkExistenceOfCuurentYearIndent(int year);

	Map<String, Object> showImportMMFIndentJsp(Map<String, Object> dataMap);;

	Map<String, Object> importMMFIndent(Map<String, Object> dataMap)
			throws java.text.ParseException;

	Map<String, Object> showLockMMFIndent();

	Map<String, Object> lockMMFIndent(int year);

	// ------------------------------------End of MMF
	// Indent-----------------------------------------------------------

	// ----------------------------Start Of Issues To Dispensary (CIV)
	// ----------------------

	public Map<String, Object> getIssueDetailPageByPage(
			Map<String, Object> pageMap);

	Map openDeletePopupForIssueciv(Map<String, Object> dataMap);

	Map<String, Object> showIssueDispensaryJsp(Map<String, Object> dataMap);

	Map<String, Object> getBrandMap(Map<String, Object> dataMap)
			throws java.text.ParseException;

	boolean addBrandDetails(Map<String, Object> dataMap);

	int getIssueId(String issueNo);

	Map<String, Object> getAdjustLoanOutMap(Map<String, Object> dataMap);

	Map<String, Object> showPrintIssueToDispensary();

	Map<String, Object> getIssuePrintMap(int issue_m_id);

	Map<String, Object> getIssueIndentMap(String demandNo);

	Map showDeleteIsuueCiv(Box box);

	Map deleteIssueCivItems(Box box);

	Map searchIssueCiv(Box box);

	List<MasStoreItem> getItemList();

	Map<String, Object> getDemandList(Map dataMap);

	// -------mthod added by vikas on 20/04/09-------

	Map<String, Object> getIssueList(Map dataMap);

	// -------mthod added by vikas on 20/04/09-------

	Map<String, Object> adjustLoanOut(Map<String, Object> dataMap);

	Map<String, Object> searchInternalIndentDetails(Map<String, Object> dataMap);

	Map<String, Object> checkYearExists(Map<String, Object> dataMap);

	Map<String, Object> getItemListForIssueToDispensary(
			Map<String, Object> dataMap);

	Map<String, Object> fillItemsForIssueToDispensary(
			Map<String, Object> dataMap);

	// ----------------------------End Of Issues To Dispensary (CIV)
	// ----------------------

	// -------------------------------------- Start of Indent Soc Tracker
	// ------------------------------------------

	public Map<String, Object> showIndentSocTracker(Map<String, Object> dataMap);

	public Map<String, Object> getIndentSocTracker(Map<String, Object> idsMap);

	public boolean addOrUpdateIndentSocTracker(
			StoreIndentSocTracker indentSocTracker, int indentSocTrackerId);

	public Map<String, Object> getItemMapForAutoComplete();

	Map<String, Object> getIndentListForSocTracker(Map<String, Object> dataMap);

	Map<String, Object> getItemListForSocTracker(Map<String, Object> dataMap);

	// -------------------------------------- End of Indent Soc Tracker
	// ------------------------------------------

	// ----------------------------Start Of Issues To Dispensary Loan Out
	// ----------------------

	Map<String, Object> checkHinExistence(Map<String, Object> dataMap);

	Map<String, Object> getHinNo(Map<String, Object> dataMap);

	Map addBrandDetailsForLoanOut(Box box) throws java.text.ParseException;

	Map<String, Object> openDeletePopupForIssueLoanOut(Map dataMap);

	Map showDeleteIsuueLoanout(Box box);

	Map deleteIssueLoanoutItems(Box box);

	Map showIssueDispensaryManualJsp(Map<String, Object> dataMap);

	Map searchIssueLoanout(Box box);

	Map<String, Object> getItemListForLoanoutByAutocomplete(
			Map<String, Object> dataMap);

	// ----------------------------End Of Issues To Dispensary Loan Out
	// ----------------------

	// ----------------------------Start Of Issues To Other Units on Surplus
	// (CIV) ----------------------

	Map printIssueToOtherUnits(int issue_m_id);

	Map addBrandDetailsToOtherUnits(Box box) throws java.text.ParseException;

	Map<String, Object> openDeletePopupForIssueToOtherUnits(Map dataMap);

	Map showDeleteIsuueToOtherUnits(Box box);

	Map deleteIssueToOtherUnitsItems(Box box);

	Map showIssueToOtherUnitsJsp(Map<String, Object> dataMap);

	Map searchIssueToOtherUnits(Box box);

	Map<String, Object> getItemListThroughAjax(Map<String, Object> dataMap);

	Map<String, Object> fillItemsForIssueToDepot(Map<String, Object> dataMap);

	Map<String, Object> getItemListForIssueToOTAFU(Map<String, Object> dataMap);

	// ----------------------------End Of Issues To Other Units on Surplus (CIV)
	// ----------------------

	// ----------------------------Start Of Issues To Other Than Airforce Units
	// ----------------------

	Map addBrandDetailsToOTAFU(Box box) throws java.text.ParseException;

	Map<String, Object> openDeletePopupForIssueToOTAFU(Map dataMap);

	Map showDeleteIsuueToOTAFU(Box box);

	Map deleteIssueToOTAFU(Box box);

	Map showIssueToOTAFUJsp(Map<String, Object> dataMap);

	Map searchIssueToOTAFU(Box box);

	Map<String, Object> getItemListThroughAjaxToOTAFU(
			Map<String, Object> dataMap);

	Map<String, Object> fillItemsForIssueToOTAFU(Map<String, Object> dataMap);

	boolean addNextOrSubmitIndentToMMF(StoreIndentM storeIndentM, List list,
			Map map);

	Map<String, Object> fillIssueToOTAFUBasedOnLotNo(Map<String, Object> dataMap);

	// ----------------------------End Of Issues To Other Than Airforce Units
	// ----------------------

	// ----------------------------Start Of Vendor Return ----------------------

	Map<String, Object> fillItemsForIndentToVendorReturn(
			Map<String, Object> dataMap);

	Map<String, Object> getItemListForVendorReturn(Map<String, Object> dataMap);

	Map<String, Object> showVendorReturnJsp(Map<String, Object> map);

	Map<String, Object> showStockDetailsForVendorReturn(Map<String, Object> map);

	Map<String, Object> submitVendorReturnDetails(Map<String, Object> dataMap);

	Map<String, Object> showDeleteVendorReturn(Map<String, Object> map);

	boolean deleteStockDetailsVendorReturn(Map<String, Object> map);

	Map<String, Object> searchVendorReturn(Map<String, Object> searchFieldMap);

	// ----------------------------End Of Vendor Return ----------------------
	// *********************************************************************************************************************
	// ------------------------------------End of Methods Written By
	// Vivek------------------------------------------
	// ****************************************************************************************************************
	// ****************************************************************************************************************
	// ------------------------------------ Methods Written By
	// Vikas------------------------------------------
	// ****************************************************************************************************************

	Map<String, Object> showOPDPatientIssue();

	Map<String, Object> getHinNoList(String serviceNumber);

	Map<String, Object> showOPDPatientIssueGrid(Map map);

	Map<String, Object> showOPDStockDetailsJsp(Map map);

	boolean submitOPDPatientStockDetails(Map map);

	Map<String, Object> showModifyOPDPatientIssueJsp(Map map);

	boolean deleteStockDetails(Map map);

	Map<String, Object> showStockDetailsForLotNo(Map map);

	Map<String, Object> getItemListForOPD(Map map);

	Map<String, Object> fillItemsInGridForOPD(Map map);

	Map<String, Object> fillItemsInGridForLotNo(Map map);

	// *********************************************************************************************************************
	// ------------------------------------End of Methods Written By
	// Vikas------------------------------------------
	// ****************************************************************************************************************

	// *************************START BY DEEPTI
	// TEVATIA********************************************

	// -------------------------------Return from
	// Dispensary------------------------------

	Map<String, Object> showReturnFromDispensaryJsp(Map<String, Object> map);

	Map<String, Object> showStockDetailsForReturnDispensary(
			Map<String, Object> map);

	Map<String, Object>  submitReturnDispensaryDetails(Map<String, Object> map);

	Map<String, Object> showDeleteReturnFromDispensary(Map<String, Object> map);

	boolean deleteStockDetailsReturnToDispensary(Map<String, Object> map);

	Map<String, Object> searchReturnToDispensary(
			Map<String, Object> searchFieldMap);

	Map<String, Object> getItemListForDepartmentReturn(
			Map<String, Object> dataMap);

	// -------------------------------Store
	// MMF-------------------------------------

	Map<String, Object> showMmfDepartment(int deptId);

	Map<String, Object> createAndImportMmfDepartmentData(Box box);

	Map<String, Object> getMmfDepartmentData(Box box);

	Map<String, Object> getItemDetails(Box box);

	Map<String, Object> getItemDetailsForMmfDepartmentJspForNextRecord(Box box);

	Map<String, Object> doAddMmfItems(Box box);

	Map<String, Object> updateGridItemsInMmf(Box box);

	Map<String, Object> getCurrentYearMmf(Box box);

	Map<String, Object> deleteGridItemsForMmf(Box box);

	Map<String, Object> resetMmfDepartmentData(Box box);

	Map<String, Object> showMmfDepartmentApproval(Box box);

	Map<String, Object> getCurrentYearMmfByItem(Box box);

	Map<String, Object> updateGridItemsInMmfDepartmentApproval(Box box);

	Map<String, Object> getItemListForNomenclature(Box box);

	public Map<String, Object> getItemObject(Box box);

	public Map<String, Object> getItemObjectFromPvms(Box box);

	// ---------------------------------- Physical
	// Stock----------------------------------------

	Map<String, Object> searchPhysicalStock(int departmentId);

	boolean addPhysicalStock(StoreStockTakingM storeStockTakingM,
			List<StoreStockTakingT> storeStockTakingTlist);

	boolean updatePhysicalStock(StoreStockTakingM storeStockTakingM,
			List<StoreStockTakingT> storeStockTakingTlist);

	int getStoreMmfDepartmentId(String docNo);

	Map<String, Object> getBalance1ModifyMap(int balanceId, int pageNo,
			Map<String, Object> dataMap);

	boolean updateNextBalance1(Map<String, Object> masterAndDetailMap);

	Map<String, Object> addNextOrSubmitBalance(Map<String, Object> dataMap,Box box);

	boolean addAdjustment(Box box);

	Map<String, Object> showAdjustment1(Box box);

	// boolean storeItemBatch(Map<String, Object> map);

	Map getMmfDepartmentModifyMapForDepot(int mmfDepartmentId, int pageNo);

	boolean updateNextMmfDepartment(Map<String, Object> masterAndDetailMap);

	Map<String, Object> addNextOrSubmitMmfDepartment(Map<String, Object> dataMap);

	// --------------------------------New Grid For Department
	// Indent----------------------

	Map<String, Object> showDepartmentIndent(int deptId, int hospitalId);

	Map<String, Object> createAndImportDepartmentIndentData(Box box);

	Map<String, Object> getDepartmentIndentData(Box box);

	Map<String, Object> getItemDetailsForDepartmentIndent(Box box);

	Map<String, Object> getItemDetailsForDepartmentIndentForNextRecord(Box box);

	Map<String, Object> doAddInternalIndentItems(Box box);

	Map<String, Object> updateGridItemsInDepartmentIndent(Box box);

	Map<String, Object> deleteGridItemsForDepartmentIndent(Box box);

	Map<String, Object> searchMmfDepartmentData(Box box);

	String getMmfNo(int docId);

	// New Grid For Physical Stock

	Map<String, Object> showPhysicalStock(int deptId, int hospitalId);

	Map<String, Object> createGridForPhysicalStockData(Box box);

	Map<String, Object> updateGridItemsInPhysicalStock(Box box);

	Map<String, Object> getGridDataForPhysicalStock(Box box);

	// *************************END BY DEEPTI
	// TEVATIA********************************************

	// -----------------------------------------------------------------------------------------------------------------
	// -------------------------------------Start of Functions Written By K.R.
	// Othivadivel------------------------------
	// -----------------------------------------------------------------------------------------------------------------

	Map<String, Object> showMMFDepartmentWiseSplitup(Box box);

	Map<String, Object> getIndentNosForSupplyOrderEntry(Box box);

	Map<String, Object> getItemsForSupplyOrderEntryJsp(Box box);

	Map<String, Object> doAddSupplyOrderEntryItems(Box box);

	// -----------------------------------------------------------------------------------------------------------------
	// -------------------------------------End of Functions Written By K.R.
	// Othivadivel------------------------------
	// -----------------------------------------------------------------------------------------------------------------

	// -----------------------------------------------------------------------------------------------------------------
	// -------------------------------------Start of Functions Written By
	// Mansi-------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------

	// --------------------------------------- Balance--------------------------

	Map<String, Object> showBalance(Map<String, Object> dataMap);

	Map<String, Object> searchBalance(Map<String, Object> searchFieldMap);

	boolean addBalance(StoreBalanceM storeBalanceM,
			List<StoreBalanceT> storeBalanceTlist, Map<String, Object> infoMap);

	Map<String, Object> getBalanceModifyMap(int radio_str);

	Map<String, Object> getBalanceMAndTUpdate(int balanceId);

	boolean updateBalance(StoreBalanceM storeBalanceM,
			List<StoreBalanceT> storeBalanceTlist);

	int getBalanceId(int balanceNo);

	Map<String, Object> showLastDemandNo(int pageNo);

	Map<String, Object> showLastDocNo(int pageNo);

	// -----------------------------------------------
	// Ack---------------------------------------
	Map<String, Object> showAckJsp(int deptId, int hospitalId);
	
	Map<String, Object> getAcknowledgementDetails(int deptId, int hospitalId);

	Map<String, Object> createGridIssueData(Box box);

	Map<String, Object> doAddAckItems(Box box);

	// ------------------------------------------- Supply Order Entry
	// --------------------------------

	Map<String, Object> showSupplyOrderEntryJsp();

	Map<String, Object> searchSupplyOrderEntry(int indentId);

	boolean addStoreSupplyOrderEntry(int indentId,
			List<StoreSupplyOrderEntry> storeSupplyOrderEntrylist);

	boolean updateSupplyOrderEnter(int indentId,
			List<StoreSupplyOrderEntry> storeSupplyOrderEntrylist);

	Map<String, Object> createGridSupplyOrderEntryData(Box box);

	Map<String, Object> getItemDetailsForSupplyOrderEntry(Box box);

	Map<String, Object> getItemDetailsForUpdateSupplyOrderEntry(Box box);

	Map<String, Object> fillItemsForBalance(Map<String, Object> dataMap);

	Map<String, Object> getItemListForLoanoutByAutocompleteBalance(
			Map<String, Object> dataMap);

	Map<String, Object> getConnectionForReport();

	Map<String, Object> getLPOList(int indentId);

	// -----------------------------------------------------------------------------------------------------------------
	// -------------------------------------End of Functions Written By
	// Mansi-------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------

	// -----------------------------------------------------------------------------------------------------------------
	// -------------------------------------Start of Reports Functions Written
	// By Mansi-------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------

	String getHospitalName(int hospitalId);

	Map<String, Object> showItemCatalogueJsp(int departmentId);

	Map<String, Object> showVendorReportJsp();

	Map<String, Object> showBrandReportJsp();

	Map<String, Object> showDrugListBodySystemWiseReportJsp();

	Map<String, Object> showVendorTurnoverEnquiryReportJsp();

	Map<String, Object> showExternalIssueReportJsp();

	Map<String, Object> showDMConsumDrugWiseReportJsp();

	// -----------------------------------------------------------------------------------------------------------------
	// -------------------------------------End of Reports Functions Written By
	// Mansi-------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	// ---------------------------start--methods written by vikas at
	// banglore-----------------------

	Map<String, Object> getItemListForCompleteStockNomenclatureByAutocomplete(
			Map dataMap);

	Map<String, Object> getStockDetails(Box box);

	Map<String, Object> getStockDetailsForNextRecord(Box box);

	Map<String, Object> submitLoanIn(Box box);

	Map<String, Object> getLoanOutPrintMap(Map dataMap);

	// ---------------------------End of--methods written by vikas at
	// banglore-----------------------

	/**
	 * added by Priyanka on 13 May 2008
	 */
	Map<String, Object> getDBConnection();

	Map<String, Object> getATSODate(int indentId);

	Map<String, Object> getActualQtyAsPerAU(Map<String, Object> paramMap);

	Map<String, Object> submitGrn(Box box);

	Map<String, Object> getBudgetDetails(Box box);

	List<MmfItemDetails> getDataForItemMmfReport(int date, String storeType);

	Map<String, Object> getSectionList();

	public Map<String, Object> getEcelSheetDataForMMf(Box box);

	public Map<String, Object> getOtherItemsForIndent(Box box);

	public Map<String, Object> showAddDepartmentIndentJsp(Box box);

	public Map<String, Object> getItemListForVendorReturnJsp(Box box);

	boolean deleteDefectiveItems(int id);

	public boolean updateDefectiveDrugs(Map<String, Object> infoMap,
			Map<String, Object> dataMap);

	public boolean deleteDefectiveDrug(Box box);

	public Map<String, Object> updateGridItemsInVendorReturn(
			Map<String, Object> dataMap);

	public Map<String, Object> updateGridItemsInDepartmentReturn(
			Map<String, Object> dataMap);

	public List<MasStoreItem> getItemsNotUsed(Box box);

	public Map<String, Object> getReportDataForStockRegister(
			Map<String, Object> dataMap);

	public Map<String, Object> getReportDataForBinRegister(
			Map<String, Object> dataMap);

	public Map<String, Object> getReportDataForStockValuation(
			Map<String, Object> dataMap);

	public MasStoreItem getItemForItemCode(String itemCode);

	public Map<String, Object> getItemListForIndent(Box box);

	public Map<String, Object> getPoList(Box box);

	public Map<String, Object> getDataForBarcode(Box box);

	public Map<String, Object> addBrandDetailsForBarcode(Box box);

	public Map<String, Object> getItemDetailsForStockTakingAdd(Box box);

	public Map<String, Object> doAddStockTakingItems(Box box);

	public Map<String, Object> getAutoCompleteForPriceList(Box box);

	public Map<String, Object> showPriceListReportJsp();

	public Map<String, Object> getListForFsNReportData();

	public Map<String, Object> getDataForVendorAnalysis();

	List<StoreInternalIndentM> printDepartmentIndent(int deptId);

	Map<String, Object> showSupplierWisePurchaseReport();

	Map<String, Object> getItemsForItemGroup(int groupId);

	Map<String, Object> showPharamacyStaticsJsp(int departmentId);

	Map<String, Object> getDetailsForPharmacyConsumptionReport();

	Map<String, Object> showDeptIssueWithoutIndentJsp(Map<String, Object> dataMap);

	Map<String, Object> addIssueWithoutIndentDetails(Box box);

 	Map<String, Object> getPatientForDrugIssue(Map<String, Object> mapForDs);

	Map<String, Object> showPatientForDrugIssue(Map<String, Object> mapForDs);

	Map<String, Object> viewIssuedDrug(Map<String, Object> parameterMap);

	Map<String, Object> addPatientDrugIssue(Box box);

	Map<String, Object> searchPOList(Map<String, Object> map);

	Map<String, Object> showPoTrackingDetails(Map<String, Object> dataMap);

	Map<String, Object> searchButtonPOTrackingList(Map<String, Object> map);

	Map<String, Object> showAdjustmentForSearchJsp(Box box);

	Map<String, Object> getItemListForBINCardByAutocomplete(Map map);

 	Map<String, Object> searchIndentDetails(Box box);

	Map<String, Object> addBrandIssueDetails(Box box);

	Map<String, Object> getUserName(int empId);

	Map<String, Object> addBrandItemIssueDetails(Map<String, Object> detailsMap);

	Map<String, Object> correctDepartmentIssueToAcknowledgement(

	Map<String, Object> detailsMap);

	Map<String, Object> checkPreviousImport(Box box);

	Map<String, Object>  insertIssueForIndent(Map<String, Object> utilMap,Box box);


	Map<String, Object> showInternalIssueReportJsp(Map<String, Object> mapDetail);

	Map<String, Object> getIssueNoListForAutoComplete(Box box);

	Map<String, Object> showStockRegisterReportJsp(Map<String, Object> mapDetail);

	Map<String, Object> getItemId(Box box);

	Map<String, Object> stockRegisterReportDateWiseDetails(
			Map<String, Object> mapDetail);

	Map<String, Object> submitDepartmentIssueWithoutIndent(
			Map<String, Object> utilMap, Box box);
	
	Map<String, Object> submitDepartmentIssueWithoutIndent(Box box);
	
	Map<String, Object> medicineDispencingToServer(Box box);

	Map<String, Object> setStoreStockRegisterCronJob(Map<String, Object> mapDetail);

	Map<String, Object> printStockRegisterCentralStoreReport(
			Map<String, Object> requestParameters);

	Map<String, Object> showPatientDrugIssueReportDateWise();

	Map<String, Object> getResponceForGroup(Map<String, Object> dataMap);

	Map<String, Object> getBatchForItem(int itemId,int deptId);

	Map<String, Object> getInvoice(int supplierId,int deptId);

	Map<String, Object> getitemGroup();

	Map<String, Object> getItemListForIndent1(Box box);
	
	boolean submitReorderLevelPharmacy(Box box,int deptId);
/*	Map<String, Object> checkIssueNo(Map<String, Object> dataMap);*/

	Map<String, Object> showDepartmentWiseReorderLevelJsp(int deptId, int hospitalId);

	Map<String, Object> searchReorderLevelPharmacy(Map<String, Object> searchFieldMap);

	//boolean updateROl(int reId);

	boolean updateROl(int reId, BigDecimal max, BigDecimal min, BigDecimal rol);

	Map<String, Object> showPrescriptionWisePharmacyConsumptionJsp();

	Map<String, Object> getItemListForVendorByAutocomplete(Map<String, Object> dataMap);

	Map<String, Object> createPvmsItemExcelList(Box box);

	Map<String, Object> importPvmsMaster(Map<String, Object> utilMap);

	Map<String, Object> showIndentCreationbyDepartmentsJsp(Box box);

	Map<String, Object> showPendingListForApproval(Box box);

	Map<String, Object> showPendingIndentApproval(Box box); 
	
	Map<String, Object> getDetailsPendingIndentApproval(Box box);

	Map<String, Object> displayOpeningBalanceData(Box box);

	Map<String, Object> submitOpeningBalanceEntryApproval(Box box);

	Map<String, Object> getItemListForAnnualDepartmentIndent(Box box);
	
	Map<String, Object> showAnnualIndentAdminSetupJsp(int hospitalId);

	Map<String, Object> addAnnualIndentAdminSetup(Box box);

	Map<String, Object> updateAnnualIndentAdminSetup(Box box);

	boolean deleteAnnualIndentAdminSetup(Box box);

	Map<String, Object> searchAnnualIndentAdminSetup(Box box);

	Map<String, Object> submitAnnualDepartmentIndentData(Box box);

	Map<String, Object> showInstitutionAnnualIndentCreationJsp(Box box);

	Map<String, Object> showInstituteWisePendingList(Box box);

	Map<String, Object> submitInstituteWiseIndent(Box box);

	Map<String, Object> showDistrictAnnualIndentCreationJsp(Box box);

	Map<String, Object> submitDistrictWiseIndent(Box box);

	Map<String, Object> showStateAnnualIndentCreationJsp(Box box);

	Map<String, Object> submitStateWiseIndent(Box box);

	Map<String, Object> showDepartmentPopupJsp(Box box);

	Map<String, Object> updateDepartmentDemandedQty(Box box);

	Map<String, Object> showInstituteIndentPopupJsp(Box box);

	Map<String, Object> showAnnualDepartmentIndentCreationApproval(Box box);

	Map<String, Object> showPendingListForDepartmentIndentAnnualApproval(Box box);

	Map<String, Object> submitAnnualDepartmentApproval(Box box);
	
	Map<String, Object> showUnservicedDispensingJsp(Box box);
	
	Map<String, Object> showPendingListForInstituteAnnualIndentApprovalJsp(
			Box box);

	Map<String, Object> showInstituteAnnualIndentApprovalJsp(Box box);

	Map<String, Object> submitAnnualInstituteApproval(Box box);

	Map<String, Object> showPendingListForDistrictWiseIndentApproval(Box box);

	Map<String, Object> showPendingListForStateWiseIndentApproval(Box box);

	Map<String, Object> showDistrictAnnualIndentApprovalJsp(Box box);

	Map<String, Object> showStateAnnualIndentApprovalJsp(Box box);

	Map<String, Object> submitAnnualDistrictApproval(Box box);

	Map<String, Object> submitAnnualStateApproval(Box box);

	Map<String, Object> showAnnualIndentTransferToKMSCLJsp(Box box);

	Map<String, Object> showPendingListAnnualIndentTransferToKMSCLJsp(Box box);

	Map<String, Object> transferAnnualIndentDataToKMSCL(Box box);

	Map<String, Object> showPendingListForAnnualIndentProcessingbyKMSCL(Box box);

	Map<String, Object> showAnnualIndentProcessingbyKMSCL(Box box);

	Map<String, Object> submitAnnualIndentProcessingByKMSCL(Map<String, Object> generalMap, Box box);

	Map<String, Object> showEnquiryBroadCastJsp(Box box);

	Map<String, Object> getItemTypeList(Box box);

	Map<String, Object> getSectionList(Box box);

	Map<String, Object> getCategoryList(Box box);

	Map<String, Object> displayEnquiryBroadCastList(Box box);

	Map<String, Object> submitEnquiryBroadCast(Box box);

	Map<String, Object> showEnquiryBroadCastPendingList(Box box);

	Map<String, Object> showEmergentIndentAcknowledgementJsp(Box box);

	Map<String, Object> submitEnquiryBroadCastAcknowledgement(Box box);

	Map<String, Object> showEmergentIndentJsp(Box box);

	Map<String, Object> submitEmergencyIndent(Box box);

	Map<String, Object> showPendingDispensingJsp(Map<String, Object> mapForDs);

	Map<String, Object> empanelled(Box box);
	
	Map<String, Object> empanelledBilling(Box box);
	
	Map<String, Object> getAllPrescription(Box box);

	Map<String, Object> empanelledDetails(Map<String, Object> mapForDs);

	Map<String, Object> dirDispLastPresBased(Map<String, Object> mapForDs);

	Map<String, Object> showDistrictIndentPopupJsp(Box box);

	Map<String, Object> updateInstituteDemandedQty(Box box);

	Map<String, Object> responseForIndentWithinInstitue(Box box);

	Map<String, Object> responseForIndentGrid(Box box);

	Map<String, Object> showIndentWithinInstitute(Box box);

	Map<String, Object> submitIndentWithinInstitute(Box box);

	Map<String, Object> searchIndentTrackingList(Box box);

	Map<String, Object> updateDistrictDemandedQty(Box box);

	Map<String, Object> getItemForAutoComplete(Box box);

	Map<String, Object> displayIndentTrackingList(Map<String, Object> dataMap);

	Map<String, Object> showIssueToOtherInstituteJsp(Map<String, Object> dataMap);

	Map getIndentListForIssueToOtherInstitute(Map<String, Object> dataMap);

	Map<String, Object> searchIndentDetailsForOtherInstitute(Box box);

	Map<String, Object> getDemandListForOtherInstitute(Map<String, Object> dataMap);
	
	Map<String, Object> setNotAvailable(Map<String, Object> mapForDs);
	
	Map<String, Object> setForEmpanelled(Map<String, Object> mapForDs);

    Map<String, Object> changeCurVisitStatus(Box box);
	
	Map<String, Object> getPatientVisitInfo(Map<String, Object> details);
	
	Map<String, Object> createTransferToKMSCLIndentExcelList(Box box);

	Map<String, Object> showPendingListForAdjustmentApproval(Box box);

	Map<String, Object> showAdjustmentApprovalJsp(Box box);

	Map<String, Object> showBlockingOfBatchAndBrandJsp(Box box);

	Map<String, Object> updateBatch(Box box,Map<String, Object> generalMap);

	Map<String, Object> submitAdjustmentApproval(Box box);

	
	Map<String, Object> changePendingVisitStatus(Box box);
	
	Map<String, Object> intraIndentApproval(Box box);
	
	Map<String, Object> intraIndentReject(Box box);

	Map<String, Object> responseForLocalPurchase(Box box);

	Map<String, Object> responseForPoNo(Box box);

	Map<String, Object> showStockReservationJsp(Box box);

	Map<String, Object> submitResrvedStock(Box box);

	Map<String, Object> showUnReservedItems(Box box);

	Map<String, Object> responseForUnReservedItems(Box box);

	Map<String, Object> submitUnResrvedStock(Box box);

	Map<String, Object> showDefectiveItemApprovalJsp(Box box);

	Map<String, Object> showPendingListForDefectiveApproval(Box box);

	Map<String, Object> submitDefectiveItemApproval(Box box);

	Map<String, Object> showBroadCastDashBoardForDMO(Box box);

	Map<String, Object> showBroadCastItemDetail(Box box);

	Map<String, Object> showDmoBroadStatus(Box box);

	Map<String, Object> submitDmoDashboardBroadData(Box box);
	
	Map<String, Object> empanellBilling(Box box);

	Map<String, Object> responseForPoGrid(Box box);

	Map<String, Object> showBroadCastDashBoardForInstitute(Box box);

	Map<String, Object> showBroadCastItemDetailInstitute(Box box);

	Map<String, Object> showInstituteBroadStatus(Box box);

	Map<String, Object> submitInstituteDashboardBroadData(Box box);

	Map<String, Object> showEmergencyIndentProcessingByKMSCL(Box box);

	Map<String, Object> showPendingListForEmergencyIndentProcessingByKMSCL(
			Box box);

	Map<String, Object> submitEmergencyIndentProcessingByKMSCL(Box box);
	
	Map<String, Object> empanelledSave(Box box);

	Map<String, Object> submitIndentTracking(Box box);

	Map<String, Object> getEmployeeName(Box box);
	
	public Map<String, Object> getItemUnitDetail(Box box);
	
	public Map<String, Object> submitDirectDispensing(Box box);
	
	public Map<String, Object> submitOTCDirectDispensing(Box box);

	Map<String, Object> showPendingListAgainstIssuedItems(Box box);

	Map<String, Object> viewBroadCastStatusData(Box box);

	Map<String, Object> getItemListForGrp(Map<String, Object> dataMap);

	Map<String, Object> getItemListBelowROL(Box box);
	
	Map<String, Object> getIssueNo(Box box,String name,String mobNo);
	
	Map<String, Object> getPatientDrugDetail(Box box);
	
	Map<String, Object> retrunDrug(Box box);

	Map<String, Object> showPendingListForDepartmentReturnAcknowledgement(
			Box box);

	Map<String, Object> showDepartemntReturnAcknowledgementJsp(Box box);

	Map<String, Object> submitDepartmentReturnApproval(Box box);

	Map<String, Object> showUnBlockItem(Box box);

	Map<String, Object> getInstituteList();
 //VK
	Map<String, Object> viewNacItemJsp(Map<String, Object> dataMap);

	

	Map<String, Object> deleteBroadCast(Box box);

	Map<String, Object> showSubstandardFreezedItemJsp();

	Map<String, Object> getDepartmentList();

	Map<String, Object> getDailyIssueItem(Map<String, Object> requestParameters);

	List<StoreIssueT> getIssueList(int issueTId);

	Map<String, Object> getPopupValueForItemReplacement(int itemId, int deptId);

	Map<String, Object> addPatientDrugIssueReplace(Box box);

	List<Object> getVisitNoList(Map<String, Object> detailsMap);
	
	List<Object> getPrescriptionList(Map<String, Object> detailsMap);

	Map<String, Object> getDetailsForMedicineIssue(int issueTId);
	
	Map<String, Object> uploadAndViewDocuments(Box box,Map<String, Object> details);

	Map<String, Object> submitIssueForOtherInstituteIndent(
			Map<String, Object> utilMap, Box box);

	Map<String, Object> getAutoCompleteForItemList(Map<String, Object> map);

	Map<String, Object> getItemListForOtc(Box box);

	Map<String, Object> fillItemsForOtcDrugs(Map<String, Object> dataMap);

	Map<String, Object> getclosingStock(Map<String, Object> dataMap);
	
	Map<String, Object> printStockStatusJsp();
	
	Map<String, Object> showDetailedStockRegisterReportJsp(Map<String, Object> mapDetail);
	
	Map<String, Object> printDetailedStockRegisterCentralStoreReport(
			Map<String, Object> requestParameters);


	Map<String, Object> getOpeningData(Box box);

	void schedulerForSlowMovingDrugs(Map<String, Object> dataMap);

	Map<String, Object> displaySlowMovingDrugsJsp(Box box);

	Map<String, Object> addPHColums(Map<String, Object> map);
	
	Map<String, Object> getHospitalList(Map<String, Object> map);
	
	Map<String, Object> getsearchPatientReturnDrug(Box box);//added by govind 30-09-2016

	Map<String, Object> searchDirectDispensing(Box box);

	Map<String, Object> getdrugStock(Map<String, Object> datamap);

	Map<String, Object> getMasItemId(Box box);
	
	Map<String, Object> getItemListForAutoCompleteForStockRegister(Map<String, Object> map);

	Map<String, Object> getItemStockValue(Box box);
	
	 Map<String, Object> pharmacyIssuePatientDrug(Box box);

	Map<String, Object> getInstituteWiseStock(Box box);
	
	 Map<String, Object> getHospitalData(Map<String, Object> objectMap);

	Map<String, Object> importKMSCLStock(Map<String, Object> utilMap);

	Map<String, Object> showCtJsp(Box box);

	Map<String, Object> getPatientDetailsForCT(Box box);

	Map<String, Object> saveCtDetails(Box box);

	String generatePrecriptionNo(int hinId);

	boolean checkDuplicateVisit(int hospitalId, int departmentId, int uhid);

	Map<String, Object> getTotalVistByHospital(int hospitalId,
			int departmentId, Date vdate, int pHinId, int opsessionId,
			String hospitalCode);
	
	
}