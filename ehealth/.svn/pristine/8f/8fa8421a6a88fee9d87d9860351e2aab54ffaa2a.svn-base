package jkt.hms.stores.handler;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.xerces.impl.xpath.regex.ParseException;

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
import jkt.hms.masters.business.StoreIssueT;
import jkt.hms.masters.business.StoreLoaninM;
import jkt.hms.masters.business.StoreLoaninT;
import jkt.hms.masters.business.StoreStockTakingM;
import jkt.hms.masters.business.StoreStockTakingT;
import jkt.hms.masters.business.StoreSupplyOrderEntry;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.stores.dataservice.StoresDataService;
import jkt.hms.util.Box;
import jkt.hms.util.MmfItemDetails;


public class StoresHandlerServiceImpl implements StoresHandlerService {
	StoresDataService storesDataService = null;

	public StoresDataService getStoresDataService() {
		return storesDataService;
	}

	public void setStoresDataService(StoresDataService storesDataService) {
		this.storesDataService = storesDataService;
	}

	public Map<String, Object> getBarcodeList(int grnId) {
		return storesDataService.getBarcodeList(grnId);
	}

	public Map<String, Object> getBooModifyMap(int radio_str) {
		return storesDataService.getBooModifyMap(radio_str);
	}

	public Map<String, Object> getContingentBillPrintMap(int grnId) {
		return storesDataService.getContingentBillPrintMap(grnId);

	}

	public List<StoreGrnM> getCrvNumberList() {
		return storesDataService.getCrvNumberList();
	}

	public Map<String, Object> getGrnPrintMap(int grnId) {
		return storesDataService.getGrnPrintMap(grnId);
	}

	public Map<String, Object> getGrnNoListForAutoComplete(Box box) {
		return storesDataService.getGrnNoListForAutoComplete(box);
	}

	public Map<String, Object> getProformaPrintMap(int grnId) {
		return storesDataService.getProformaPrintMap(grnId);
	}

	public Map searchBoo(Map searchFieldMap) throws ParseException,
			java.text.ParseException {
		return storesDataService.searchBoo(searchFieldMap);
	}

	public Map<String, Object> showBooJsp(Map<String, Object> infoMap) {

		return storesDataService.showBooJsp(infoMap);
	}

	public boolean addBoo(Map<String, Object> infoMap) {
		return storesDataService.addBoo(infoMap);
	}

	public Map<String, Object> addDefectiveDrugs(Map<String, Object> infoMap,
			Map<String, Object> dataMap) {
		return storesDataService.addDefectiveDrugs(infoMap, dataMap);
	}

	public boolean addGrns(Map<String, Object> infoMap,
			Map<String, Object> dataMap) {
		return storesDataService.addGrns(infoMap, dataMap);
	}

	public boolean addLoanIn(Map<String, Object> infoMap,
			Map<String, Object> dataMap) {
		return storesDataService.addLoanIn(infoMap, dataMap);
	}

	public List<StoreDefectiveDrugM> getDefectDrug(int entryId) {
		return storesDataService.getDefectDrug(entryId);
	}

	public Map getDefectiveDrugModifyMap(int id, int pageNo) {
		return storesDataService.getDefectiveDrugModifyMap(id, pageNo);
	}

	public Map<String, Object> getDetailsForLoanIn() {
		return storesDataService.getDetailsForLoanIn();
	}

	public Map<String, Object> getDetailsForMoreInfoGrn() {
		return storesDataService.getDetailsForMoreInfoGrn();
	}

	public List<StoreGrnM> getGrn(int grnId) {
		return storesDataService.getGrn(grnId);
	}

	// public Map getGrnModifyMap(int radio_str) {
	// return storesDataService.getGrnModifyMap(radio_str);
	// }

	public Map<String, Object> getIndentList(String choice) {
		return storesDataService.getIndentList(choice);
	}

	public Map<String, Object> getLoanInList(int poId) {
		return storesDataService.getLoanInList(poId);
	}

	public List<StoreLoaninT> getLoanInListForMoreInfo(int loaninDetailId) {
		return storesDataService.getLoanInListForMoreInfo(loaninDetailId);
	}

	public List<StoreGrnT> getStoreGrnTListForMoreInfo(int storeGrnTId) {
		return storesDataService.getStoreGrnTListForMoreInfo(storeGrnTId);
	}

	public Map<String, Object> getVendorList(String vendor) {
		return storesDataService.getVendorList(vendor);
	}

	public Map getViewAllMap() {
		return storesDataService.getViewAllMap();
	}

	public List<StoreLoaninM> getloanList() {
		return storesDataService.getloanList();
	}

	// public Map<String, Object> grnModifyMap(int id, int pageNo) {
	// return storesDataService.grnModifyMap(id, pageNo);
	// }

	public Map<String, Object> modifyLoanin(int id, int pageNo) {
		return storesDataService.modifyLoanin(id, pageNo);
	}

	public Map searchDefectiveDrug(Map searchFieldMap) throws ParseException {
		return storesDataService.searchDefectiveDrug(searchFieldMap);
	}

	public Map searchGrn(Map searchFieldMap) throws ParseException {
		return storesDataService.searchGrn(searchFieldMap);
	}

	public Map searchLoanin(Map searchFieldMap) throws ParseException {
		return storesDataService.searchLoanin(searchFieldMap);
	}

	public Map<String, Object> showDefectiveDrugJsp(Map<String, Object> dataMap) {
		return storesDataService.showDefectiveDrugJsp(dataMap);
	}

	public Map<String, Object> showGridJsp(Box box) {
		return storesDataService.showGridJsp(box);
	}

	public Map<String, Object> showGridLoanInJsp(Box box) {
		return storesDataService.showGridLoanInJsp(box);
	}

	public Map showGrnJsp(Box box, Map<String, Object> dataMap) {
		return storesDataService.showGrnJsp(box, dataMap);
	}

	public Map showLoanInJsp(Map<String, Object> dataMap) {
		return storesDataService.showLoanInJsp(dataMap);
	}

	public boolean submitAdjustLoanIn(int loaninId, StoreGrnM storeGrnM,
			int poId, List list, Map<String, Object> infoMap) {
		return storesDataService.submitAdjustLoanIn(loaninId, storeGrnM, poId,
				list, infoMap);
	}

	public boolean updateBoo(StoreBoo storeBoo, List list) {
		return storesDataService.updateBoo(storeBoo, list);
	}

	public boolean updateGrn(StoreGrnM storeGrnM, List list) {
		return storesDataService.updateGrn(storeGrnM, list);
	}

	public boolean updateLoanIn(Map<String, Object> infoMap) {
		return storesDataService.updateLoanIn(infoMap);
	}

	public Map<String, Object> fillItemsForGrn(Map<String, Object> dataMap) {
		return storesDataService.fillItemsForGrn(dataMap);
	}

	public Map<String, Object> getItemListForGrnByAutocomplete(
			Map<String, Object> dataMap) {
		return storesDataService.getItemListForGrnByAutocomplete(dataMap);
	}

	public Map getResponseIndentList(Box box) {
		return storesDataService.getResponseIndentList(box);
	}

	public Map getResponsePoList(Box box) {
		return storesDataService.getResponsePoList(box);
	}

	public Map<String, Object> fillItemsForLoanIn(Map<String, Object> dataMap) {
		return storesDataService.fillItemsForLoanIn(dataMap);
	}

	public Map<String, Object> getItemListForLoanInByAutocomplete(
			Map<String, Object> dataMap) {
		return storesDataService.getItemListForLoanInByAutocomplete(dataMap);
	}

	public Map<String, Object> getItemListForDefectiveDrugsByAutocomplete(
			Map<String, Object> dataMap) {
		return storesDataService
				.getItemListForDefectiveDrugsByAutocomplete(dataMap);
	}

	public Map<String, Object> fillItemsForDefectiveDrug(
			Map<String, Object> dataMap) {
		return storesDataService.fillItemsForDefectiveDrugs(dataMap);
	}

	public Map<String, Object> fillItemsForDefectiveDrugs(
			Map<String, Object> dataMap) {
		return storesDataService.fillItemsForDefectiveDrugs(dataMap);
	}

	// public Map getLoanInModifyMap(int radio_str) {
	// return storesDataService.getLoanInModifyMap(radio_str);
	// }

	public Map<String, Object> getExpiryDateInAjax(Map<String, Object> dataMap) {
		return storesDataService.getExpiryDateInAjax(dataMap);
	}

	public Map<String, Object> defectiveDrugModifyMap(int id) {
		return storesDataService.defectiveDrugModifyMap(id);
	}

	public List<StoreDefectiveDrugM> getDefectiveList() {
		return storesDataService.getDefectiveList();
	}

	public List<StoreGrnM> getGrnList() {
		return storesDataService.getGrnList();
	}

	public Map<String, Object> getAdjustmentList(int workOrderId, int pageNo,
			String items) {
		return storesDataService.getAdjustmentList(workOrderId, pageNo, items);
	}

	public boolean createAdjustment(Map<String, Object> infoMap) {
		return storesDataService.createAdjustment(infoMap);
	}

	public List<StoreDefectiveDrugM> getDefectiveDrugsList() {
		return storesDataService.getDefectiveDrugsList();
	}

	public List<StoreBoo> getBooList() {
		return storesDataService.getBooList();
	}

	// ==========================END OF ABHA METHOD================


	// ------------------------------Indent----------------------------

	public Map printMmfIndent(int indentId) {
		return storesDataService.printMmfIndent(indentId);
	}

	public Map<String, Object> getItemListForMMFIndentModify(
			Map<String, Object> dataMap) {

		return storesDataService.getItemListForMMFIndentModify(dataMap);
	}

	public Map<String, Object> fillItemsCommon(Map<String, Object> dataMap) {
		return storesDataService.fillItemsCommon(dataMap);
	}

	public Map<String, Object> getItemListForMMFIndent(
			Map<String, Object> dataMap) {
		return storesDataService.getItemListForMMFIndent(dataMap);
	}

	public Map<String, Object> checkYearExists(Map<String, Object> dataMap) {
		return storesDataService.checkYearExists(dataMap);
	}

	public Map getIndentModifyMapForDepot(int radio_str, int pageNo) {
		return storesDataService.getIndentModifyMapForDepot(radio_str, pageNo);
	}

	public Map<String, Object> lockMMFIndent(int year) {
		return storesDataService.lockMMFIndent(year);
	}

	public Map<String, Object> showLockMMFIndent() {
		return storesDataService.showLockMMFIndent();
	}

	public Map<String, Object> showImportMMFIndentJsp(
			Map<String, Object> dataMap) {
		return storesDataService.showImportMMFIndentJsp(dataMap);
	}

	// public Map getIndentDepotPrintMap(int indentId) {
	// //return storesDataService.getIndentDepotPrintMap(indentId);
	// }
	public Map getIndentModifyMap(int radio_str, int pageNo) {

		return storesDataService.getIndentModifyMap(radio_str, pageNo);
	}

	public Map<String, Object> importMMFIndent(Map<String, Object> dataMap)
			throws java.text.ParseException {
		return storesDataService.importMMFIndent(dataMap);
	}

	public boolean addNextOrSubmitIndentToMMF(StoreIndentM storeIndentM,
			List list, Map<String, Object> map) {
		return storesDataService.addNextOrSubmitIndentToMMF(storeIndentM, list,
				map);
	}

	@SuppressWarnings("unchecked")
	public Map showIndent(int deptId) {
		return storesDataService.showIndent(deptId);
	}

	public Map getIndentMAndTUpdate(int indentId) {
		return storesDataService.getIndentMAndTUpdate(indentId);
	}

	public Map<String, Object> searchIndent(Map<String, Object> searchFieldMap)
			throws ParseException, java.text.ParseException {
		return storesDataService.searchIndent(searchFieldMap);
	}

	public StoreIndentM getStoresIndentMObject(int indentId) {
		return storesDataService.getStoresIndentMObject(indentId);
	}

	public int getIndentId(int indentNo) {
		return storesDataService.getIndentId(indentNo);
	}

	@SuppressWarnings("unchecked")
	public Map getIndentMAndT(int indentId) {
		return storesDataService.getIndentMAndT(indentId);
	}

	public boolean updateIndent(StoreIndentM storeIndentTlist, List list) {
		return storesDataService.updateIndent(storeIndentTlist, list);
	}

	public boolean updateNextIndent(Map<String, Object> masterAndDetailMap)
			throws java.text.ParseException {
		return storesDataService.updateNextIndent(masterAndDetailMap);
	}

	public Map<String, Object> checkExistenceOfCuurentYearIndent(int year) {

		return storesDataService.checkExistenceOfCuurentYearIndent(year);
	}

	public boolean updateIndent(StoreIndentM storeIndentTlist) {
		return false;
	}

	// ---------------------End Of MMF Indent------------

	// --------------Indent To Depot ----------------
	public Map<String, Object> getItemListForIndentToDepot(
			Map<String, Object> dataMap) {
		return storesDataService.getItemListForIndentToDepot(dataMap);
	}

	public Map<String, Object> fillItemsForIndentToDepot(
			Map<String, Object> dataMap) {
		return storesDataService.fillItemsForIndentToDepot(dataMap);
	}

	public Map<String, Object> addNextOrSubmitIndentToDepot(
			Map<String, Object> dataMap) {
		return storesDataService.addNextOrSubmitIndentToDepot(dataMap);
	}

	public boolean updateNextIndentToDepot(
			Map<String, Object> masterAndDetailMap) {
		return storesDataService.updateNextIndentToDepot(masterAndDetailMap);
	}

	public Map<String, Object> showIndentJspDepot(Map<String, Object> dataMap) {
		return storesDataService.showIndentJspDepot(dataMap);
	}

	// ---------------------End Of Indent To Depot---------------

	// --------------Indent To SOC ----------------
	public Map<String, Object> showIndentJspSOC(Map<String, Object> dataMap) {
		return storesDataService.showIndentJspSOC(dataMap);
	}

	public Map<String, Object> addNextOrSubmitIndentToSOC(
			Map<String, Object> dataMap) {
		return storesDataService.addNextOrSubmitIndentToSOC(dataMap);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getIndentModifyMapForSOC(int indentId, int pageNo) {
		return storesDataService.getIndentModifyMapForSOC(indentId, pageNo);
	}

	public boolean updateNextIndentToSOC(Map<String, Object> masterAndDetailMap) {
		return storesDataService.updateNextIndentToSOC(masterAndDetailMap);
	}

	public Map getBrandListForSOC(int itemId) {
		return storesDataService.getBrandListForSOC(itemId);
	}

	public Map getBrandListForSOC(int itemId, int detailId) {
		return storesDataService.getBrandListForSOC(itemId, detailId);
	}

	public Map<String, Object> fillItemsForIndentToSOC(
			Map<String, Object> dataMap) {
		return storesDataService.fillItemsForIndentToSOC(dataMap);
	}

	public Map<String, Object> getManufacturerNameInAjax(
			Map<String, Object> dataMap) {
		return storesDataService.getManufacturerNameInAjax(dataMap);
	}

	public Map<String, Object> getItemListForIndentToSOC(
			Map<String, Object> dataMap) {
		return storesDataService.getItemListForIndentToSOC(dataMap);
	}

	// --------------End of Indent To SOC ----------------

	// -------------------------------------- Start of Indent Soc Tracker

	public Map<String, Object> showIndentSocTracker(Map<String, Object> dataMap) {
		return storesDataService.showIndentSocTracker(dataMap);
	}

	public Map<String, Object> getIndentSocTracker(Map<String, Object> idsMap) {
		return storesDataService.getIndentSocTracker(idsMap);
	}

	public boolean addOrUpdateIndentSocTracker(
			StoreIndentSocTracker indentSocTracker, int indentSocTrackerId) {

		return storesDataService.addOrUpdateIndentSocTracker(indentSocTracker,
				indentSocTrackerId);
	}

	public Map<String, Object> getItemMapForAutoComplete() {
		return storesDataService.getItemMapForAutoComplete();
	}

	public Map<String, Object> adjustLoanIn() {
		return null;
	}

	public Map<String, Object> getIndentListForSocTracker(
			Map<String, Object> dataMap) {
		return storesDataService.getIndentListForSocTracker(dataMap);
	}

	public Map<String, Object> getItemListForSocTracker(
			Map<String, Object> dataMap) {
		return storesDataService.getItemListForSocTracker(dataMap);
	}

	// -------------------------------------- End of Indent Soc Tracker

	// ----------------------------Start Of Issues To Dispensary (CIV)

	public Map<String, Object> getIssueDetailPageByPage(
			Map<String, Object> pageMap) {

		return storesDataService.getIssueDetailPageByPage(pageMap);
	}

	public Map openDeletePopupForIssueciv(Map<String, Object> dataMap) {

		return storesDataService.openDeletePopupForIssueciv(dataMap);
	}

	public Map showDeleteIsuueCiv(Box box) {

		return storesDataService.showDeleteIsuueCiv(box);

	}

	public Map deleteIssueCivItems(Box box) {
		return storesDataService.deleteIssueCivItems(box);
	}

	public Map searchIssueCiv(Box box) {
		return storesDataService.searchIssueCiv(box);
	}

	public List<MasStoreItem> getItemList() {
		return storesDataService.getItemList();
	}

	public Map<String, Object> getDemandList(Map dataMap) {
		return storesDataService.getDemandList(dataMap);
	}

	public Map<String, Object> getIssueList(Map dataMap) {
		return storesDataService.getIssueList(dataMap);
	}

	public Map<String, Object> adjustLoanOut(Map<String, Object> dataMap) {
		return storesDataService.adjustLoanOut(dataMap);
	}

	public Map showIssueDispensaryJsp(Map<String, Object> dataMap) {
		return storesDataService.showIssueDispensaryJsp(dataMap);
	}

	public Map getBrandMap(Map<String, Object> dataMap)
			throws java.text.ParseException {
		return storesDataService.getBrandMap(dataMap);
	}

	@SuppressWarnings("unchecked")
	public boolean addBrandDetails(Map<String, Object> dataMap) {
		return storesDataService.addBrandDetails(dataMap);
	}

	public int getIssueId(String issueNo) {
		return storesDataService.getIssueId(issueNo);
	}

	public Map<String, Object> getAdjustLoanOutMap(Map<String, Object> dataMap) {

		return storesDataService.getAdjustLoanOutMap(dataMap);
	}

	public Map<String, Object> getIndentSocPrintMap(int indentId) {
		return null;
	}

	public Map<String, Object> showPrintIndentDepotJsp(
			Map<String, Object> dataMap) {
		return storesDataService.showPrintIndentDepotJsp(dataMap);
	}

	public Map<String, Object> showPrintIssueToDispensary() {
		return storesDataService.showPrintIssueToDispensary();
	}

	public Map<String, Object> getIssuePrintMap(int issue_m_id) {
		return storesDataService.getIssuePrintMap(issue_m_id);
	}

	public Map<String, Object> getIssueIndentMap(String demandNo) {

		return storesDataService.getIssueIndentMap(demandNo);
	}

	public Map<String, Object> getItemListForIssueToDispensary(
			Map<String, Object> dataMap) {
		return storesDataService.getItemListForIssueToDispensary(dataMap);
	}

	public Map<String, Object> fillItemsForIssueToDispensary(
			Map<String, Object> dataMap) {
		return storesDataService.fillItemsForIssueToDispensary(dataMap);
	}

	// ----------------------------End Of Issues To Dispensary (CIV)


	// ----------------------------Start Of Issues To Dispensary Loan Out

	public Map<String, Object> getHinNo(Map<String, Object> dataMap) {

		return storesDataService.getHinNo(dataMap);
	}

	public Map addBrandDetailsForLoanOut(Box box)
			throws java.text.ParseException {
		return storesDataService.addBrandDetailsForLoanOut(box);
	}

	public Map<String, Object> openDeletePopupForIssueLoanOut(Map dataMap) {
		return storesDataService.openDeletePopupForIssueLoanOut(dataMap);
	}

	public Map showDeleteIsuueLoanout(Box box) {
		return storesDataService.showDeleteIsuueLoanout(box);
	}

	public Map deleteIssueLoanoutItems(Box box) {
		return storesDataService.deleteIssueLoanoutItems(box);
	}

	public Map<String, Object> searchInternalIndentDetails(
			Map<String, Object> dataMap) {
		return storesDataService.searchInternalIndentDetails(dataMap);
	}

	public Map showIssueDispensaryManualJsp(Map<String, Object> dataMap) {
		return storesDataService.showIssueDispensaryManualJsp(dataMap);
	}

	public Map searchIssueLoanout(Box box) {
		return storesDataService.searchIssueLoanout(box);
	}

	public Map<String, Object> getItemListForLoanoutByAutocomplete(
			Map<String, Object> dataMap) {
		return storesDataService.getItemListForLoanoutByAutocomplete(dataMap);
	}

	// ----------------------------End Of Issues To Dispensary Loan Out


	// ----------------------------Start Of Issues To Other Units on Surplus


	public Map printIssueToOtherUnits(int issue_m_id) {
		return storesDataService.printIssueToOtherUnits(issue_m_id);
	}

	public Map addBrandDetailsToOtherUnits(Box box)
			throws java.text.ParseException {
		return storesDataService.addBrandDetailsToOtherUnits(box);
	}

	public Map<String, Object> openDeletePopupForIssueToOtherUnits(Map dataMap) {
		return storesDataService.openDeletePopupForIssueToOtherUnits(dataMap);
	}

	public Map showDeleteIsuueToOtherUnits(Box box) {
		return storesDataService.showDeleteIsuueToOtherUnits(box);
	}

	public Map deleteIssueToOtherUnitsItems(Box box) {
		return storesDataService.deleteIssueToOtherUnitsItems(box);
	}

	public Map showIssueToOtherUnitsJsp(Map<String, Object> dataMap) {
		return storesDataService.showIssueToOtherUnitsJsp(dataMap);
	}

	public Map searchIssueToOtherUnits(Box box) {
		return storesDataService.searchIssueToOtherUnits(box);
	}

	public Map<String, Object> getItemListThroughAjax(
			Map<String, Object> dataMap) {

		return storesDataService.getItemListThroughAjax(dataMap);
	}

	public Map<String, Object> fillItemsForIssueToDepot(
			Map<String, Object> dataMap) {
		return storesDataService.fillItemsForIssueToDepot(dataMap);
	}

	// ----------------------------End Of Issues To Other Units on Surplus (CIV)


	// ----------------------------Start Of Issues To Other Than Airforce Units

	public Map addBrandDetailsToOTAFU(Box box) throws java.text.ParseException {
		return storesDataService.addBrandDetailsToOTAFU(box);
	}

	public Map<String, Object> openDeletePopupForIssueToOTAFU(Map dataMap) {
		return storesDataService.openDeletePopupForIssueToOTAFU(dataMap);
	}

	public Map showDeleteIsuueToOTAFU(Box box) {
		return storesDataService.showDeleteIsuueToOTAFU(box);
	}

	public Map deleteIssueToOTAFU(Box box) {
		return storesDataService.deleteIssueToOTAFU(box);
	}

	public Map showIssueToOTAFUJsp(Map<String, Object> dataMap) {
		return storesDataService.showIssueToOTAFUJsp(dataMap);
	}

	public Map searchIssueToOTAFU(Box box) {
		return storesDataService.searchIssueToOTAFU(box);
	}

	public Map<String, Object> getItemListThroughAjaxToOTAFU(
			Map<String, Object> dataMap) {

		return storesDataService.getItemListThroughAjaxToOTAFU(dataMap);
	}

	public Map<String, Object> fillItemsForIssueToOTAFU(
			Map<String, Object> dataMap) {
		return storesDataService.fillItemsForIssueToOTAFU(dataMap);
	}

	public Map<String, Object> getIndentDepotPrintMap(int indentId) {

		return storesDataService.getIndentDepotPrintMap(indentId);
	}

	public Map<String, Object> getItemListForIssueToOTAFU(
			Map<String, Object> dataMap) {
		return storesDataService.getItemListForIssueToOTAFU(dataMap);
	}

	public Map<String, Object> fillIssueToOTAFUBasedOnLotNo(
			Map<String, Object> dataMap) {
		return storesDataService.fillIssueToOTAFUBasedOnLotNo(dataMap);
	}

	// ----------------------------End Of Issues To Other Than Airforce Units

	// -------------------------------Vendor Return


	public Map<String, Object> fillItemsForIndentToVendorReturn(
			Map<String, Object> dataMap) {
		return storesDataService.fillItemsForIndentToVendorReturn(dataMap);
	}

	public Map<String, Object> getItemListForVendorReturn(
			Map<String, Object> dataMap) {
		return storesDataService.getItemListForVendorReturn(dataMap);
	}

	public Map<String, Object> showVendorReturnJsp(Map<String, Object> map) {
		return storesDataService.showVendorReturnJsp(map);
	}

	public Map<String, Object> showStockDetailsForVendorReturn(
			Map<String, Object> map) {
		return storesDataService.showStockDetailsForVendorReturn(map);
	}

	public Map<String, Object> submitVendorReturnDetails(
			Map<String, Object> dataMap) {
		return storesDataService.submitVendorReturnDetails(dataMap);
	}

	public Map<String, Object> showDeleteVendorReturn(Map<String, Object> map) {
		return storesDataService.showDeleteVendorReturn(map);
	}

	public boolean deleteStockDetailsVendorReturn(Map<String, Object> map) {
		return storesDataService.deleteStockDetailsVendorReturn(map);
	}

	public Map<String, Object> searchVendorReturn(
			Map<String, Object> searchFieldMap) {
		return storesDataService.searchVendorReturn(searchFieldMap);
	}

	// ------------------------------------End of Methods Written By

	// ------------------------------------ Methods Written By

	public Map<String, Object> showOPDPatientIssue() {

		return storesDataService.showOPDPatientIssue();
	}

	public Map<String, Object> getHinNoList(String serviceNumber) {

		return storesDataService.getHinNoList(serviceNumber);
	}

	public Map<String, Object> showOPDPatientIssueGrid(Map map) {

		return storesDataService.showOPDPatientIssueGrid(map);
	}

	public Map<String, Object> showOPDStockDetailsJsp(Map map) {

		return storesDataService.showOPDStockDetailsJsp(map);
	}

	public boolean submitOPDPatientStockDetails(Map map) {

		return storesDataService.submitOPDPatientStockDetails(map);
	}

	public Map<String, Object> showModifyOPDPatientIssueJsp(Map map) {

		return storesDataService.showModifyOPDPatientIssueJsp(map);
	}

	public boolean deleteStockDetails(Map map) {

		return storesDataService.deleteStockDetails(map);
	}

	public Map<String, Object> showStockDetailsForLotNo(Map map) {

		return storesDataService.showStockDetailsForLotNo(map);
	}

	public Map<String, Object> getItemListForOPD(Map map) {

		return storesDataService.getItemListForOPD(map);
	}

	public Map<String, Object> fillItemsInGridForOPD(Map map) {

		return storesDataService.fillItemsInGridForOPD(map);
	}

	public Map<String, Object> fillItemsInGridForLotNo(Map map) {

		return storesDataService.fillItemsInGridForLotNo(map);
	}

	// ------------------------------------End of Methods Written By

	// -----------------------Start of Modules Of Deepti Tevatia

	// Dispensary------------------------------

	public Map<String, Object> showReturnFromDispensaryJsp(
			Map<String, Object> map) {
		return storesDataService.showReturnFromDispensaryJsp(map);
	}

	public Map<String, Object> showStockDetailsForReturnDispensary(
			Map<String, Object> map) {
		return storesDataService.showStockDetailsForReturnDispensary(map);
	}

	public Map<String, Object> submitReturnDispensaryDetails(Map<String, Object> map) {
		return storesDataService.submitReturnDispensaryDetails(map);
	}

	public Map<String, Object> showDeleteReturnFromDispensary(
			Map<String, Object> map) {
		return storesDataService.showDeleteReturnFromDispensary(map);
	}

	public boolean deleteStockDetailsReturnToDispensary(Map<String, Object> map) {
		return storesDataService.deleteStockDetailsReturnToDispensary(map);
	}

	public Map<String, Object> searchReturnToDispensary(
			Map<String, Object> searchFieldMap) {
		return storesDataService.searchReturnToDispensary(searchFieldMap);
	}

	public Map<String, Object> getItemListForDepartmentReturn(
			Map<String, Object> dataMap) {
		return storesDataService.getItemListForDepartmentReturn(dataMap);
	}

	// ---------------------------------- Physical
	// Stock----------------------------------------

	public Map<String, Object> searchPhysicalStock(int departmentId) {
		return storesDataService.searchPhysicalStock(departmentId);
	}

	public boolean addPhysicalStock(StoreStockTakingM storeStockTakingM,
			List<StoreStockTakingT> storeStockTakingTlist) {
		return storesDataService.addPhysicalStock(storeStockTakingM,
				storeStockTakingTlist);
	}

	public boolean updatePhysicalStock(StoreStockTakingM storeStockTakingM,
			List<StoreStockTakingT> storeStockTakingTlist) {
		return storesDataService.updatePhysicalStock(storeStockTakingM,
				storeStockTakingTlist);
	}

	// ----------------------------------New Grid------ Department
	// Indent----------------------

	public Map<String, Object> showDepartmentIndent(int deptId,int hospitalId) {
		return storesDataService.showDepartmentIndent(deptId,hospitalId);
	}

	public Map<String, Object> createAndImportDepartmentIndentData(Box box) {
		return storesDataService.createAndImportDepartmentIndentData(box);
	}

	public Map<String, Object> getDepartmentIndentData(Box box) {
		return storesDataService.getDepartmentIndentData(box);
	}

	public Map<String, Object> getItemDetailsForDepartmentIndent(Box box) {
		return storesDataService.getItemDetailsForDepartmentIndent(box);
	}

	public Map<String, Object> getItemDetailsForDepartmentIndentForNextRecord(
			Box box) {

		return storesDataService
				.getItemDetailsForDepartmentIndentForNextRecord(box);
	}

	public Map<String, Object> doAddInternalIndentItems(Box box) {
		return storesDataService.doAddInternalIndentItems(box);
	}

	public Map<String, Object> updateGridItemsInDepartmentIndent(Box box) {
		return storesDataService.updateGridItemsInDepartmentIndent(box);
	}

	public Map<String, Object> deleteGridItemsForDepartmentIndent(Box box) {
		return storesDataService.deleteGridItemsForDepartmentIndent(box);
	}

	// -------------------------------------- MMF Department

	public Map<String, Object> showMmfDepartment(int deptId) {
		return storesDataService.showMmfDepartment(deptId);
	}

	public Map<String, Object> createAndImportMmfDepartmentData(Box box) {
		return storesDataService.createAndImportMmfDepartmentData(box);
	}

	public Map<String, Object> getMmfDepartmentData(Box box) {
		return storesDataService.getMmfDepartmentData(box);
	}

	public Map<String, Object> getItemDetails(Box box) {
		return storesDataService.getItemDetails(box);
	}

	public Map<String, Object> getItemDetailsForMmfDepartmentJspForNextRecord(
			Box box) {

		return storesDataService
				.getItemDetailsForMmfDepartmentJspForNextRecord(box);
	}

	public Map<String, Object> doAddMmfItems(Box box) {
		return storesDataService.doAddMmfItems(box);
	}

	public Map<String, Object> updateGridItemsInMmf(Box box) {
		return storesDataService.updateGridItemsInMmf(box);
	}

	public Map<String, Object> getCurrentYearMmf(Box box) {
		return storesDataService.getCurrentYearMmf(box);
	}

	public Map<String, Object> deleteGridItemsForMmf(Box box) {
		return storesDataService.deleteGridItemsForMmf(box);
	}

	public Map<String, Object> searchMmfDepartmentData(Box box) {
		return storesDataService.searchMmfDepartmentData(box);
	}

	public String getMmfNo(int docId) {
		return storesDataService.getMmfNo(docId);
	}

	public boolean addAdjustment(Box box) {
		return storesDataService.addAdjustment(box);
	}

	public Map<String, Object> showAdjustment1(Box box) {
		return storesDataService.showAdjustment1(box);
	}

	/*
	 * public boolean storeItemBatch(Map<String, Object> map) { return
	 * storesDataService.storeItemBatch(map); }
	 */

	// New Grid For Physical Stock
	public Map<String, Object> showPhysicalStock(int deptId,int hospitalId) {
		return storesDataService.showPhysicalStock(deptId,hospitalId);
	}

	public Map<String, Object> createGridForPhysicalStockData(Box box) {
		return storesDataService.createGridForPhysicalStockData(box);
	}

	public Map<String, Object> updateGridItemsInPhysicalStock(Box box) {
		return storesDataService.updateGridItemsInPhysicalStock(box);
	}

	public Map<String, Object> getGridDataForPhysicalStock(Box box) {
		return storesDataService.getGridDataForPhysicalStock(box);
	}

	// -----------------------END of Modules Of Deepti Tevatia

	// -------------------------------------Start of Functions Written By K.R.

	public Map<String, Object> showMMFDepartmentWiseSplitup(Box box) {

		return storesDataService.showMMFDepartmentWiseSplitup(box);
	}

	public Map<String, Object> getIndentNosForSupplyOrderEntry(Box box) {

		return storesDataService.getIndentNosForSupplyOrderEntry(box);
	}

	public Map<String, Object> getItemsForSupplyOrderEntryJsp(Box box) {

		return storesDataService.getItemsForSupplyOrderEntryJsp(box);
	}

	public Map<String, Object> doAddSupplyOrderEntryItems(Box box) {

		return storesDataService.doAddSupplyOrderEntryItems(box);
	}

	// -------------------------------------End of Functions Written By K.R.
	// --------------------------------------- Balance--------------------------

	public Map<String, Object> showBalance(Map<String, Object> dataMap) {
		return storesDataService.showBalance(dataMap);
	}

	public Map<String, Object> searchBalance(Map<String, Object> searchFieldMap) {
		return storesDataService.searchBalance(searchFieldMap);
	}

	public boolean addBalance(StoreBalanceM storeBalanceM,
			List<StoreBalanceT> storeBalanceTlist, Map<String, Object> infoMap) {
		return storesDataService.addBalance(storeBalanceM, storeBalanceTlist,
				infoMap);
	}

	public Map<String, Object> getBalanceModifyMap(int radio_str) {
		return storesDataService.getBalanceModifyMap(radio_str);
	}

	public Map<String, Object> getBalanceMAndTUpdate(int balanceId) {
		return storesDataService.getBalanceMAndTUpdate(balanceId);
	}

	public boolean updateBalance(StoreBalanceM storeBalanceM,
			List<StoreBalanceT> storeBalanceTlist) {
		return storesDataService
				.updateBalance(storeBalanceM, storeBalanceTlist);
	}

	public int getBalanceId(int balanceNo) {
		return storesDataService.getBalanceId(balanceNo);
	}

	public Map<String, Object> getBalance1ModifyMap(int balanceId, int pageNo,
			Map<String, Object> dataMap) {
		return storesDataService.getBalance1ModifyMap(balanceId, pageNo,
				dataMap);
	}

	public boolean updateNextBalance1(Map<String, Object> masterAndDetailMap)
			throws java.text.ParseException {
		return storesDataService.updateNextBalance1(masterAndDetailMap);
	}

	public Map<String, Object> addNextOrSubmitBalance(
			Map<String, Object> dataMap,Box box) {
		return storesDataService.addNextOrSubmitBalance(dataMap,box);
	}

	public Map<String, Object> showLastDemandNo(int pageNo) {
		return storesDataService.showLastDemandNo(pageNo);
	}

	public Map<String, Object> showLastDocNo(int pageNo) {
		return storesDataService.showLastDocNo(pageNo);
	}

	// -----------------------New Grid for
	// Ack-------------------------------------------
	public Map<String, Object> showAckJsp(int deptId, int hospitalId) {
		return storesDataService.showAckJsp(deptId, hospitalId);
	}
	
	public Map<String, Object> getAcknowledgementDetails(int deptId, int hospitalId) {
		return storesDataService.getAcknowledgementDetails(deptId, hospitalId);
	}

	public Map<String, Object> createGridIssueData(Box box) {
		return storesDataService.createGridIssueData(box);
	}

	public Map<String, Object> doAddAckItems(Box box) {
		return storesDataService.doAddAckItems(box);
	}

	public Map<String, Object> showSupplyOrderEntryJsp() {
		return storesDataService.showSupplyOrderEntryJsp();
	}

	public Map<String, Object> searchSupplyOrderEntry(int indentId) {
		return storesDataService.searchSupplyOrderEntry(indentId);
	}

	public boolean addStoreSupplyOrderEntry(int indentId,
			List<StoreSupplyOrderEntry> storeSupplyOrderEntrylist) {
		return storesDataService.addStoreSupplyOrderEntry(indentId,
				storeSupplyOrderEntrylist);
	}

	public boolean updateSupplyOrderEnter(int indentId,
			List<StoreSupplyOrderEntry> storeSupplyOrderEntrylist) {
		return storesDataService.updateSupplyOrderEnter(indentId,
				storeSupplyOrderEntrylist);
	}

	public Map<String, Object> createGridSupplyOrderEntryData(Box box) {
		return storesDataService.createGridSupplyOrderEntryData(box);
	}

	public Map<String, Object> getItemDetailsForSupplyOrderEntry(Box box) {
		return storesDataService.getItemDetailsForSupplyOrderEntry(box);
	}

	public Map<String, Object> getItemDetailsForUpdateSupplyOrderEntry(Box box) {
		return storesDataService.getItemDetailsForUpdateSupplyOrderEntry(box);
	}

	public Map<String, Object> fillItemsForBalance(Map<String, Object> dataMap) {
		return storesDataService.fillItemsForBalance(dataMap);
	}

	public Map<String, Object> getItemListForLoanoutByAutocompleteBalance(
			Map<String, Object> dataMap) {
		return storesDataService
				.getItemListForLoanoutByAutocompleteBalance(dataMap);
	}

	public Map<String, Object> getConnectionForReport() {
		return storesDataService.getConnectionForReport();
	}

	public Map<String, Object> checkHinExistence(Map<String, Object> dataMap) {
		return storesDataService.checkHinExistence(dataMap);
	}

	public Map<String, Object> getLPOList(int indentId) {
		return storesDataService.getLPOList(indentId);
	}

	// -------------------------------------End of Functions Written By

	public String getHospitalName(int hospitalId) {
		return storesDataService.getHospitalName(hospitalId);
	}

	public Map<String, Object> showItemCatalogueJsp(int departmentId) {
		return storesDataService.showItemCatalogueJsp(departmentId);
	}

	public Map<String, Object> showVendorReportJsp() {
		return storesDataService.showVendorReportJsp();
	}

	public Map<String, Object> showBrandReportJsp() {
		return storesDataService.showBrandReportJsp();
	}

	public Map<String, Object> showDrugListBodySystemWiseReportJsp() {
		return storesDataService.showDrugListBodySystemWiseReportJsp();
	}

	public Map<String, Object> showVendorTurnoverEnquiryReportJsp() {
		return storesDataService.showVendorTurnoverEnquiryReportJsp();
	}

	public Map<String, Object> showExternalIssueReportJsp() {
		return storesDataService.showExternalIssueReportJsp();
	}

	public Map<String, Object> showDMConsumDrugWiseReportJsp() {
		return storesDataService.showDMConsumDrugWiseReportJsp();
	}

	/**
	 * added by Priyanka on 13 May 2008
	 */
	public Map<String, Object> getDBConnection() {
		return storesDataService.getDBConnection();
	}

	public Map<String, Object> getATSODate(int indentId) {
		return storesDataService.getATSODate(indentId);
	}

	public Map<String, Object> getActualQtyAsPerAU(Map<String, Object> paramMap) {

		return storesDataService.getActualQtyAsPerAU(paramMap);
	}

	public Map<String, Object> submitGrn(Box box) {

		return storesDataService.submitGrn(box);
	}

	public Map<String, Object> getBudgetDetails(Box box) {

		return storesDataService.getBudgetDetails(box);
	}

	public Map<String, Object> getItemListForCompleteStockNomenclatureByAutocomplete(
			Map dataMap) {

		return storesDataService
				.getItemListForCompleteStockNomenclatureByAutocomplete(dataMap);
	}

	public Map<String, Object> getStockDetails(Box box) {

		return storesDataService.getStockDetails(box);
	}

	public Map<String, Object> getStockDetailsForNextRecord(Box box) {

		return storesDataService.getStockDetailsForNextRecord(box);
	}

	public Map<String, Object> submitLoanIn(Box box) {

		return storesDataService.submitLoanIn(box);
	}

	public Map<String, Object> resetMmfDepartmentData(Box box) {

		return storesDataService.resetMmfDepartmentData(box);
	}

	public Map<String, Object> getLoanOutPrintMap(Map dataMap) {

		return storesDataService.getLoanOutPrintMap(dataMap);
	}

	public Map<String, Object> getCurrentYearMmfByItem(Box box) {

		return storesDataService.getCurrentYearMmfByItem(box);
	}

	public Map<String, Object> getItemListForNomenclature(Box box) {

		return storesDataService.getItemListForNomenclature(box);
	}

	public Map<String, Object> showMmfDepartmentApproval(Box box) {

		return storesDataService.showMmfDepartmentApproval(box);
	}

	public Map<String, Object> updateGridItemsInMmfDepartmentApproval(Box box) {

		return storesDataService.updateGridItemsInMmfDepartmentApproval(box);
	}

	public Map<String, Object> getItemObject(Box box) {

		return storesDataService.getItemObject(box);

	}

	public Map<String, Object> getItemObjectFromPvms(Box box) {

		return storesDataService.getItemObjectFromPvms(box);
	}

	public List<MmfItemDetails> getDataForItemMmfReport(int date,
			String storeType) {

		return storesDataService.getDataForItemMmfReport(date, storeType);
	}

	public Map<String, Object> getSectionList() {
		return storesDataService.getSectionList();
	}

	public Map<String, Object> getEcelSheetDataForMMf(Box box) {

		return storesDataService.getEcelSheetDataForMMf(box);
	}

	public Map<String, Object> modifyGrn(int grnId, int pageNo, int spoId,
			String items) {

		return storesDataService.modifyGrn(grnId, pageNo, spoId, items);
	}

	public Map<String, Object> updateCrv(Box box) {

		return storesDataService.updateCrv(box);
	}

	public Map getSOItemDetails(Box box) {
		return storesDataService.getSOItemDetails(box);
	}

	public Map<String, Object> getOtherItemsForIndent(Box box) {

		return storesDataService.getOtherItemsForIndent(box);
	}

	public Map<String, Object> showAddDepartmentIndentJsp(Box box) {

		return storesDataService.showAddDepartmentIndentJsp(box);
	}

	public Map<String, Object> getItemListForVendorReturnJsp(Box box) {

		return storesDataService.getItemListForVendorReturnJsp(box);
	}

	public boolean deleteDefectiveItems(int id) {

		return storesDataService.deleteDefectiveItems(id);
	}

	public boolean updateDefectiveDrugs(Map<String, Object> infoMap,
			Map<String, Object> dataMap) {
		return storesDataService.updateDefectiveDrugs(infoMap, dataMap);
	}

	public boolean deleteDefectiveDrug(Box box) {
		return storesDataService.deleteDefectiveDrug(box);
	}

	public Map<String, Object> updateGridItemsInVendorReturn(
			Map<String, Object> dataMap) {
		return storesDataService.updateGridItemsInVendorReturn(dataMap);
	}

	public Map<String, Object> updateGridItemsInDepartmentReturn(
			Map<String, Object> dataMap) {
		return storesDataService.updateGridItemsInDepartmentReturn(dataMap);
	}

	public Map<String, Object> findGrnLedgeraction(Map<String, Object> dataMap) {
		return storesDataService.findGrnLedgeraction(dataMap);
	}

	public Map<String, Object> fillItemsForGrnForGrnWithoutPo(
			Map<String, Object> dataMap) {

		return storesDataService.fillItemsForGrnForGrnWithoutPo(dataMap);
	}

	public List<MasStoreItem> getItemsNotUsed(Box box) {
		return storesDataService.getItemsNotUsed(box);
	}

	public Map<String, Object> getReportDataForStockRegister(
			Map<String, Object> dataMap) {
		return storesDataService.getReportDataForStockRegister(dataMap);
	}

	public Map<String, Object> getReportDataForBinRegister(
			Map<String, Object> dataMap) {

		return storesDataService.getReportDataForBinRegister(dataMap);
	}

	public Map<String, Object> getReportDataForStockValuation(
			Map<String, Object> dataMap) {
		return storesDataService.getReportDataForStockValuation(dataMap);
	}

	public MasStoreItem getItemForItemCode(String itemCode) {
		return storesDataService.getItemForItemCode(itemCode);
	}

	public Map<String, Object> getItemListForIndent(Box box) {

		return storesDataService.getItemListForIndent(box);
	}

	public Map<String, Object> getPoList(Box box) {
		return storesDataService.getPoList(box);
	}

	public Map<String, Object> getDataForBarcode(Box box) {

		return storesDataService.getDataForBarcode(box);
	}

	public Map<String, Object> addBrandDetailsForBarcode(Box box) {
		return storesDataService.addBrandDetailsForBarcode(box);
	}

	public Map<String, Object> getItemDetailsForStockTakingAdd(Box box) {

		return storesDataService.getItemDetailsForStockTakingAdd(box);
	}

	public Map<String, Object> doAddStockTakingItems(Box box) {

		return storesDataService.doAddStockTakingItems(box);
	}

	public Map<String, Object> getAutoCompleteForPriceList(Box box) {

		return storesDataService.getAutoCompleteForPriceList(box);
	}

	public Map<String, Object> showPriceListReportJsp() {

		return storesDataService.showPriceListReportJsp();
	}

	public Map<String, Object> getListForFsNReportData() {

		return storesDataService.getListForFsNReportData();
	}

	public Map<String, Object> getDataForVendorAnalysis() {
		return storesDataService.getDataForVendorAnalysis();
	}

	public List<StoreInternalIndentM> printDepartmentIndent(int deptId) {
		return storesDataService.printDepartmentIndent(deptId);
	}

	public Map<String, Object> showSupplierWisePurchaseReport() {
		return storesDataService.showSupplierWisePurchaseReport();
	}

	public Map<String, Object> getItemsForItemGroup(int groupId) {
		return storesDataService.getItemsForItemGroup(groupId);
	}

	public Map<String, Object> showPharamacyStaticsJsp(int departmentId) {
		return storesDataService.showPharamacyStaticsJsp(departmentId);
	}

	public Map<String, Object> getDetailsForPharmacyConsumptionReport() {
		return storesDataService.getDetailsForPharmacyConsumptionReport();
	}

	public Map<String, Object> showDeptIssueWithoutIndentJsp(Map<String, Object> dataMap) {
		return storesDataService.showDeptIssueWithoutIndentJsp(dataMap);
	}

	public Map<String, Object> addIssueWithoutIndentDetails(Box box) {
		return storesDataService.addIssueWithoutIndentDetails(box);
	}

//----By Dipali--
	@Override
	public Map<String, Object> getPatientForDrugIssue(Map<String, Object> mapForDs) {
		return storesDataService.getPatientForDrugIssue(mapForDs);
	}

	@Override
	public Map<String, Object> showPatientForDrugIssue(Map<String, Object> mapForDs) {
		return storesDataService.showPatientForDrugIssue(mapForDs);
	}
	@Override
	public Map<String, Object> viewIssuedDrug(Map<String, Object> parameterMap) {
		return storesDataService.viewIssuedDrug(parameterMap);
	}
	@Override
	public Map<String, Object> addPatientDrugIssue(Box box) {
		return storesDataService.addPatientDrugIssue(box);
	}

 	@Override
	public Map<String, Object> searchPOList(Map<String, Object> map) {
		return storesDataService.searchPOList(map);
	}

	@Override
	public Map<String, Object> showPoTrackingDetails(Map<String, Object> dataMap) {
		return storesDataService.showPoTrackingDetails(dataMap);
	}

	@Override
	public Map<String, Object> searchButtonPOTrackingList(Map<String, Object> map) {
		return storesDataService.searchButtonPOTrackingList(map);
	}
	@Override
	public Map<String, Object> showAdjustmentForSearchJsp(Box box) {
		return storesDataService.showAdjustmentForSearchJsp(box);
	}

	public Map<String, Object> getItemListForBINCardByAutocomplete(Map map)
	{
		return storesDataService.getItemListForBINCardByAutocomplete(map);
	}

	public Map<String, Object> addBrandIssueDetails(Box box) {
		return storesDataService.addBrandIssueDetails(box);
	}

	public Map<String, Object> searchIndentDetails(Box box) {
		return storesDataService.searchIndentDetails(box);
	}

	public Map<String, Object> getUserName(int empId)
	{
		return storesDataService.getUserName(empId);
	}

	public Map<String, Object> addBrandItemIssueDetails(
			Map<String, Object> detailsMap) {
		return storesDataService.addBrandItemIssueDetails(detailsMap);
	}

	public Map<String, Object> correctDepartmentIssueToAcknowledgement(
			Map<String, Object> detailsMap) {
		return storesDataService.correctDepartmentIssueToAcknowledgement(detailsMap);
	}




	public Map<String, Object> checkPreviousImport(Box box) {
		return storesDataService.checkPreviousImport(box);
	}
	public Map<String, Object> showInternalIssueReportJsp(
			Map<String, Object> mapDetail) {
		return storesDataService.showInternalIssueReportJsp(mapDetail);
	}
	public Map<String, Object>  insertIssueForIndent(Map<String, Object> utilMap,Box box)
	{
		return storesDataService.insertIssueForIndent(utilMap,box);
	}

	public Map<String, Object> getIssueNoListForAutoComplete(Box box) {
		return storesDataService.getIssueNoListForAutoComplete(box);
	}

	public Map<String, Object> showStockRegisterReportJsp(
			Map<String, Object> mapDetail) {
		return storesDataService.showStockRegisterReportJsp(mapDetail);
	}

	public Map<String, Object> getItemId(Box box) {
		return storesDataService.getItemId(box);
	}

	public Map<String, Object> stockRegisterReportDateWiseDetails(
			Map<String, Object> mapDetail) {
		return storesDataService.stockRegisterReportDateWiseDetails(mapDetail);
	}

	public Map<String, Object> submitDepartmentIssueWithoutIndent(
			Map<String, Object> utilMap, Box box) {
		return storesDataService.submitDepartmentIssueWithoutIndent(utilMap,box);
	}
	

	public Map<String, Object> submitDepartmentIssueWithoutIndent(Box box) {
		return storesDataService.submitDepartmentIssueWithoutIndent(box);
	} 
	
	public Map<String, Object> medicineDispencingToServer(Box box) {
		return storesDataService.medicineDispencingToServer(box);
	}
	
	public Map<String, Object> printStockRegisterCentralStoreReport(
			Map<String, Object> requestParameters) {
		return storesDataService.printStockRegisterCentralStoreReport(requestParameters);
	}

	@Override
	public Map<String, Object> showPatientDrugIssueReportDateWise() {
		return storesDataService.showPatientDrugIssueReportDateWise();
	}

	@Override
	public Map<String, Object> getResponceForGroup(Map<String, Object> dataMap) {
		return storesDataService.getResponceForGroup(dataMap);
	}

	@Override
	public Map<String, Object> getBatchForItem(int itemId,int deptId) {
		return storesDataService.getBatchForItem(itemId,deptId);
	}

	@Override
	public Map<String, Object> getInvoice(int supplierId, int deptId) {
		return storesDataService.getInvoice(supplierId,deptId);
	}

	@Override
	public Map<String, Object> getitemGroup() {
		return storesDataService.getitemGroup();
	}

	@Override
	public Map<String, Object> getItemListForIndent1(Box box) {
		return storesDataService.getItemListForIndent1(box);
	}

	@Override
	public boolean submitReorderLevelPharmacy(Box box,int deptId) {
		return storesDataService.submitReorderLevelPharmacy(box,deptId);
	}

	@Override
	public Map<String, Object> showDepartmentWiseReorderLevelJsp(int deptId,int hospitalId) {
		return storesDataService.showDepartmentWiseReorderLevelJsp(deptId,hospitalId);
	}

	@Override
	public Map<String, Object> searchReorderLevelPharmacy(Map<String, Object> searchFieldMap) {
		return storesDataService.searchReorderLevelPharmacy(searchFieldMap);
	}

	@Override
	public boolean updateROl(int reId,BigDecimal max,BigDecimal min,BigDecimal rol) {
		return storesDataService.updateROl(reId,max,min,rol);
	}

	@Override
	public Map<String, Object> showPrescriptionWisePharmacyConsumptionJsp() {
		return storesDataService.showPrescriptionWisePharmacyConsumptionJsp();
	}

	@Override
	public Map<String, Object> getItemListForVendorByAutocomplete(
			Map<String, Object> dataMap) {
		return storesDataService.getItemListForVendorByAutocomplete(dataMap);
	}

	@Override
	public Map<String, Object> createPvmsItemExcelList(Box box) {
		
		return storesDataService.createPvmsItemExcelList(box);
	}

	@Override
	public Map<String, Object> importPvmsMaster(Map<String, Object> utilMap) {
		
		
		return storesDataService.importPvmsMaster(utilMap);
	}

	@Override
	public Map<String, Object> showIndentCreationbyDepartmentsJsp(Box box) {
		
		return storesDataService.showIndentCreationbyDepartmentsJsp(box);
	}

	@Override
	public Map<String, Object> showPendingListForApproval(Box box) {
		
		return storesDataService.showPendingListForApproval(box);
	}

	@Override
	public Map<String, Object> showPendingIndentApproval(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.showPendingIndentApproval(box);
	}
	
	@Override
	public Map<String, Object> getDetailsPendingIndentApproval(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getDetailsPendingIndentApproval(box);
	}

	@Override
	public Map<String, Object> displayOpeningBalanceData(Box box) {
		
		return storesDataService.displayOpeningBalanceData(box);
	}

	@Override
	public Map<String, Object> submitOpeningBalanceEntryApproval(Box box) {
		
		return storesDataService.submitOpeningBalanceEntryApproval(box);
	}

	@Override
	public Map<String, Object> getItemListForAnnualDepartmentIndent(Box box) {
		
		return storesDataService.getItemListForAnnualDepartmentIndent(box);
	}

	@Override
	public Map<String, Object> addAnnualIndentAdminSetup(Box box) {
		return storesDataService.addAnnualIndentAdminSetup(box);
	}


	@Override
	public Map<String, Object> searchAnnualIndentAdminSetup(Box box) {
		return storesDataService.searchAnnualIndentAdminSetup(box);
	}

	@Override
	public Map<String, Object> showAnnualIndentAdminSetupJsp(int hospitalId) {
		return storesDataService.showAnnualIndentAdminSetupJsp(hospitalId);
	}

	@Override
	public Map<String, Object> updateAnnualIndentAdminSetup(Box box) {
		return storesDataService.updateAnnualIndentAdminSetup(box);
	}

	@Override
	public boolean deleteAnnualIndentAdminSetup(Box box) {
		return storesDataService.deleteAnnualIndentAdminSetup(box);
	}
	
	@Override
	public Map<String, Object> showUnservicedDispensingJsp(Box box) {
		return storesDataService.showUnservicedDispensingJsp(box);
	}
	
	@Override
	public Map<String, Object> showPendingDispensingJsp(Map<String, Object> mapForDs) {
		return storesDataService.showPendingDispensingJsp(mapForDs);
	}

	@Override
	public Map<String, Object> submitAnnualDepartmentIndentData(Box box) {
		
		return storesDataService.submitAnnualDepartmentIndentData(box);
	}

	@Override
	public Map<String, Object> showInstitutionAnnualIndentCreationJsp(Box box) {
		
		return storesDataService.showInstitutionAnnualIndentCreationJsp(box);
	}

	@Override
	public Map<String, Object> showInstituteWisePendingList(Box box) {
	
		return storesDataService.showInstituteWisePendingList(box);
	}

	@Override
	public Map<String, Object> submitInstituteWiseIndent(Box box) {
	
		return storesDataService.submitInstituteWiseIndent(box);
	}

	@Override
	public Map<String, Object> showDistrictAnnualIndentCreationJsp(Box box) {
		
		return storesDataService.showDistrictAnnualIndentCreationJsp(box);
	}

	@Override
	public Map<String, Object> submitDistrictWiseIndent(Box box) {
	
		return storesDataService.submitDistrictWiseIndent(box);
	}

	@Override
	public Map<String, Object> showStateAnnualIndentCreationJsp(Box box) {
		
		return storesDataService.showStateAnnualIndentCreationJsp(box);
	}

	@Override
	public Map<String, Object> submitStateWiseIndent(Box box) {
	
		return storesDataService.submitStateWiseIndent(box);
	}

	@Override
	public Map<String, Object> showDepartmentPopupJsp(Box box) {
		
		return storesDataService.showDepartmentPopupJsp(box);
	}

	@Override
	public Map<String, Object> updateDepartmentDemandedQty(Box box) {
		
		return storesDataService.updateDepartmentDemandedQty(box);
	}

	@Override
	public Map<String, Object> showInstituteIndentPopupJsp(Box box) {
		
		return storesDataService.showInstituteIndentPopupJsp(box);
	}

	@Override
	public Map<String, Object> showAnnualDepartmentIndentCreationApproval(
			Box box) {
		
		return storesDataService. showAnnualDepartmentIndentCreationApproval(box);
	}

	@Override
	public Map<String, Object> showPendingListForDepartmentIndentAnnualApproval(Box box) {
		
		return storesDataService.showPendingListForDepartmentIndentAnnualApproval(box);
	}

	@Override
	public Map<String, Object> submitAnnualDepartmentApproval(Box box) {
		
		return storesDataService.submitAnnualDepartmentApproval(box);
	}

	@Override
	public Map<String, Object> showPendingListForInstituteAnnualIndentApprovalJsp(Box box) {
		
		return storesDataService.showPendingListForInstituteAnnualIndentApprovalJsp(box);
	}

	@Override
	public Map<String, Object> showInstituteAnnualIndentApprovalJsp(Box box) {
		
		return storesDataService.showInstituteAnnualIndentApprovalJsp(box);
	}

	@Override
	public Map<String, Object> submitAnnualInstituteApproval(Box box) {
	
		return storesDataService.submitAnnualInstituteApproval(box);
	}

	@Override
	public Map<String, Object> showPendingListForDistrictWiseIndentApproval(
			Box box) {
		
		return storesDataService.showPendingListForDistrictWiseIndentApproval(box);
	}

	@Override
	public Map<String, Object> showPendingListForStateWiseIndentApproval(Box box) {
		
		return storesDataService.showPendingListForStateWiseIndentApproval(box);
	}

	@Override
	public Map<String, Object> showDistrictAnnualIndentApprovalJsp(Box box) {
		
		return storesDataService.showDistrictAnnualIndentApprovalJsp(box);
	}

	@Override
	public Map<String, Object> showStateAnnualIndentApprovalJsp(Box box) {
	
		return storesDataService.showStateAnnualIndentApprovalJsp(box);
	}

	@Override
	public Map<String, Object> submitAnnualDistrictApproval(Box box) {
		
		return storesDataService.submitAnnualDistrictApproval(box);
	}

	@Override
	public Map<String, Object> submitAnnualStateApproval(Box box) {
		
		return storesDataService.submitAnnualStateApproval(box);
	}

	@Override
	public Map<String, Object> showAnnualIndentTransferToKMSCLJsp(Box box) {
		
		return storesDataService.showAnnualIndentTransferToKMSCLJsp(box);
	}

	@Override
	public Map<String, Object> showPendingListAnnualIndentTransferToKMSCLJsp(Box box) {
		
		return storesDataService.showPendingListAnnualIndentTransferToKMSCLJsp(box);
	}

	@Override
	public Map<String, Object> transferAnnualIndentDataToKMSCL(Box box) {
		
		return storesDataService.transferAnnualIndentDataToKMSCL(box);
	}

	@Override
	public Map<String, Object> showPendingListForAnnualIndentProcessingbyKMSCL(Box box) {
		
		return storesDataService.showPendingListForAnnualIndentProcessingbyKMSCL(box);
	}

	@Override
	public Map<String, Object> showAnnualIndentProcessingbyKMSCL(Box box) {
		
		return storesDataService.showAnnualIndentProcessingbyKMSCL(box);
	}

	@Override
	public Map<String, Object> submitAnnualIndentProcessingByKMSCL(Map<String, Object> generalMap,Box box) {
		
		return storesDataService.submitAnnualIndentProcessingByKMSCL(generalMap,box);
	}

	@Override
	public Map<String, Object> showEnquiryBroadCastJsp(Box box) {
	
		return storesDataService.showEnquiryBroadCastJsp(box);
	}

	@Override
	public Map<String, Object> getItemTypeList(Box box) {
		
		return storesDataService.getItemTypeList(box);
	}

	@Override
	public Map<String, Object> getSectionList(Box box) {
	
		return storesDataService.getSectionList(box);
	}

	@Override
	public Map<String, Object> getCategoryList(Box box) {
		
		return storesDataService.getCategoryList(box);
	}

	@Override
	public Map<String, Object> displayEnquiryBroadCastList(Box box) {
	
		return storesDataService.displayEnquiryBroadCastList(box);
	}

	@Override
	public Map<String, Object> submitEnquiryBroadCast(Box box) {
		
		return storesDataService.submitEnquiryBroadCast(box);
	}

	@Override
	public Map<String, Object> showEnquiryBroadCastPendingList(Box box) {
		
		return storesDataService.showEnquiryBroadCastPendingList(box);
	}

	@Override
	public Map<String, Object> showEmergentIndentAcknowledgementJsp(Box box) {
		
		return storesDataService.showEmergentIndentAcknowledgementJsp(box);
	}

	@Override
	public Map<String, Object> submitEnquiryBroadCastAcknowledgement(Box box) {
	
		return storesDataService.submitEnquiryBroadCastAcknowledgement(box);
	}

	@Override
	public Map<String, Object> showEmergentIndentJsp(Box box) {
	
		return storesDataService.showEmergentIndentJsp(box);
	}

	@Override
	public Map<String, Object> submitEmergencyIndent(Box box) {
		
		return storesDataService.submitEmergencyIndent(box);
	}

/*	@Override
	public Map<String, Object> checkIssueNo(Map<String, Object> dataMap) {
		return storesDataService.checkIssueNo(dataMap);
	}
*/
	
	@Override
	public Map<String, Object> empanelled(Box box) {
		return storesDataService.empanelled(box);
	}
	@Override
	public Map<String, Object> empanelledBilling(Box box) {
		return storesDataService.empanelledBilling(box);
	}
	
	@Override
	public Map<String, Object> getAllPrescription(Box box) {
		return storesDataService.getAllPrescription(box);
	}
	
	
	@Override
	public Map<String, Object> empanelledDetails(Map<String, Object> mapForDs) {
		return storesDataService.empanelledDetails(mapForDs);
	}
	
	@Override
	public Map<String, Object> dirDispLastPresBased(Map<String, Object> mapForDs) {
		return storesDataService.dirDispLastPresBased(mapForDs);
	}

	@Override
	public Map<String, Object> showDistrictIndentPopupJsp(Box box) {
		
		return storesDataService.showDistrictIndentPopupJsp(box);
	}

	@Override
	public Map<String, Object> updateInstituteDemandedQty(Box box) {
		
		return storesDataService.updateInstituteDemandedQty(box);
	}

	@Override
	public Map<String, Object> responseForIndentWithinInstitue(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.responseForIndentWithinInstitue(box);
	}

	@Override
	public Map<String, Object> responseForIndentGrid(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.responseForIndentGrid(box);
	}

	@Override
	public Map<String, Object> showIndentWithinInstitute(Box box) {
	
		return storesDataService.showIndentWithinInstitute(box);
	}

	@Override
	public Map<String, Object> submitIndentWithinInstitute(Box box) {
		
		return storesDataService.submitIndentWithinInstitute(box);
	}

	@Override
	public Map<String, Object> searchIndentTrackingList(Box box) {
		
		return storesDataService.searchIndentTrackingList(box);
	}

	@Override
	public Map<String, Object> updateDistrictDemandedQty(Box box) {
		
		return storesDataService.updateDistrictDemandedQty(box);
	}

	@Override
	public Map<String, Object> getItemForAutoComplete(Box box) {
		
		return storesDataService.getItemForAutoComplete(box);
	}

	@Override
	public Map<String, Object> displayIndentTrackingList(Map<String, Object> dataMap) {
		
		return storesDataService.displayIndentTrackingList(dataMap);
	}

	@Override
	public Map<String, Object> showIssueToOtherInstituteJsp(Map<String, Object> dataMap) {
		
		return storesDataService.showIssueToOtherInstituteJsp(dataMap);
	}

	@Override
	public Map getIndentListForIssueToOtherInstitute(Map<String, Object> dataMap) {
		
		return storesDataService.getIndentListForIssueToOtherInstitute(dataMap);
	}

	@Override
	public Map<String, Object> searchIndentDetailsForOtherInstitute(Box box) {
		
		return storesDataService.searchIndentDetailsForOtherInstitute(box);
	}

	@Override
	public Map<String, Object> getDemandListForOtherInstitute(Map<String, Object> dataMap) {
		
		return storesDataService.getDemandListForOtherInstitute(dataMap);
	}
	
	@Override
	public Map<String, Object> setNotAvailable(Map<String, Object> mapForDs) {
		return storesDataService.setNotAvailable(mapForDs);
	}
	
	@Override
	public Map<String, Object> setForEmpanelled(Map<String, Object> mapForDs) {
		return storesDataService.setForEmpanelled(mapForDs);
	}
	
  @Override
	public Map<String, Object> createTransferToKMSCLIndentExcelList(Box box) {
		
		return storesDataService.createTransferToKMSCLIndentExcelList(box);
	}

	@Override
	public Map<String, Object> showPendingListForAdjustmentApproval(Box box) {
		
		return storesDataService.showPendingListForAdjustmentApproval(box);
	}

   @Override
	public Map<String, Object> showAdjustmentApprovalJsp(Box box) {
	
		return storesDataService.showAdjustmentApprovalJsp(box);
	}

	@Override
	public Map<String, Object> showBlockingOfBatchAndBrandJsp(Box box) {
		
		return storesDataService.showBlockingOfBatchAndBrandJsp(box);
	}

	@Override
	public Map<String, Object> updateBatch(Box box, Map<String, Object> genenaralMap) {
		
		return storesDataService.updateBatch(box, genenaralMap);
	}

	@Override
	public Map<String, Object> submitAdjustmentApproval(Box box) {
	
		return storesDataService.submitAdjustmentApproval(box);
	}


	@Override
	public Map<String, Object> changeCurVisitStatus(Box box) {
		return storesDataService.changeCurVisitStatus(box);
	}
	
	@Override
	public Map<String, Object> getPatientVisitInfo(Map<String, Object> details) {
		return storesDataService.getPatientVisitInfo(details);
	}
	
	@Override
	public Map<String, Object> changePendingVisitStatus(Box box) {
		return storesDataService.changePendingVisitStatus(box);
	}
	
	@Override
	public Map<String, Object> intraIndentApproval(Box box) {
		return storesDataService.intraIndentApproval(box);
	}
	
	@Override
	public Map<String, Object> intraIndentReject(Box box) {
		return storesDataService.intraIndentReject(box);
	}

	@Override
	public Map<String, Object> responseForLocalPurchase(Box box) {
		
		return storesDataService.responseForLocalPurchase(box);
	}

	@Override
	public Map<String, Object> responseForPoNo(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.responseForPoNo(box);
	}

	@Override
	public Map<String, Object> showStockReservationJsp(Box box) {
		
		return storesDataService.showStockReservationJsp(box);
	}

	@Override
	public Map<String, Object> submitResrvedStock(Box box) {
		
		return storesDataService.submitResrvedStock(box);
	}

	@Override
	public Map<String, Object> showUnReservedItems(Box box) {
		
		return storesDataService.showUnReservedItems(box);
	}

	@Override
	public Map<String, Object> responseForUnReservedItems(Box box) {
	
		return storesDataService.responseForUnReservedItems(box);
	}

	@Override
	public Map<String, Object> submitUnResrvedStock(Box box) {
	
		return storesDataService.submitUnResrvedStock(box);
	}
	
	@Override
	public Map<String, Object> empanellBilling(Box box) {
	
		return storesDataService.empanellBilling(box);
	}

	@Override
	public Map<String, Object> showDefectiveItemApprovalJsp(Box box) {
		
		return storesDataService.showDefectiveItemApprovalJsp(box);
	}

	@Override
	public Map<String, Object> showPendingListForDefectiveApproval(Box box) {
	
		return storesDataService.showPendingListForDefectiveApproval(box);
	}

	@Override
	public Map<String, Object> submitDefectiveItemApproval(Box box) {
	
		return storesDataService.submitDefectiveItemApproval(box);
	}

	@Override
	public Map<String, Object> showBroadCastDashBoardForDMO(Box box) {
		
		return storesDataService.showBroadCastDashBoardForDMO(box);
	}

	@Override
	public Map<String, Object> showBroadCastItemDetail(Box box) {
		
		return storesDataService.showBroadCastItemDetail(box);
	}

	@Override
	public Map<String, Object> showDmoBroadStatus(Box box) {
		
		return storesDataService.showDmoBroadStatus(box);
	}

	@Override
	public Map<String, Object> submitDmoDashboardBroadData(Box box) {
		
		return storesDataService.submitDmoDashboardBroadData(box);
	}

	@Override
	public Map<String, Object> responseForPoGrid(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.responseForPoGrid(box);
	}

	@Override
	public Map<String, Object> showBroadCastDashBoardForInstitute(Box box) {
		
		return storesDataService.showBroadCastDashBoardForInstitute(box);
	}

	@Override
	public Map<String, Object> showBroadCastItemDetailInstitute(Box box) {
		
		return storesDataService.showBroadCastItemDetailInstitute(box);
	}

	

	@Override
	public Map<String, Object> showInstituteBroadStatus(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.showInstituteBroadStatus(box);
	}
	
	@Override
	public Map<String, Object> empanelledSave(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.empanelledSave(box);
	}
	@Override
	public Map<String, Object> getItemUnitDetail(Box box) {
		return storesDataService.getItemUnitDetail(box);
	}

	@Override
	public Map<String, Object> submitInstituteDashboardBroadData(Box box) {
	
		return storesDataService.submitInstituteDashboardBroadData(box);
	}

	@Override
	public Map<String, Object> showEmergencyIndentProcessingByKMSCL(Box box) {
		
		return storesDataService.showEmergencyIndentProcessingByKMSCL(box);
	}

	@Override
	public Map<String, Object> showPendingListForEmergencyIndentProcessingByKMSCL(
			Box box) {
		
		return storesDataService.showPendingListForEmergencyIndentProcessingByKMSCL(box);
	}

	@Override
	public Map<String, Object> submitEmergencyIndentProcessingByKMSCL(Box box) {
		
		return storesDataService.submitEmergencyIndentProcessingByKMSCL(box);
	}

	@Override
	public Map<String, Object> submitIndentTracking(Box box) {
	
		return storesDataService.submitIndentTracking(box);
	}

	@Override
	public Map<String, Object> getEmployeeName(Box box) {
	
		return storesDataService.getEmployeeName(box);
	}
	@Override
	public Map<String, Object> submitDirectDispensing(Box box) {
		return storesDataService.submitDirectDispensing(box);
	}
	
	@Override
	public Map<String, Object> submitOTCDirectDispensing(Box box) {
		return storesDataService.submitOTCDirectDispensing(box);
	}

	@Override
	public Map<String, Object> showPendingListAgainstIssuedItems(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.showPendingListAgainstIssuedItems(box);
	}

	@Override
	public Map<String, Object> viewBroadCastStatusData(Box box) {
		
		return storesDataService.viewBroadCastStatusData(box);
	}

	@Override
	public Map<String, Object> getItemListForGrp(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.getItemListForGrp(dataMap);
	}

	@Override
	public Map<String, Object> getItemListBelowROL(Box box) {
		
		return storesDataService.getItemListBelowROL(box);
	}
	@Override
	public Map<String, Object> getIssueNo(Box box,String name,String mobNo){
		return storesDataService.getIssueNo(box,name,mobNo);
	}
	@Override
	public Map<String, Object> getPatientDrugDetail(Box box){
		return storesDataService.getPatientDrugDetail(box);
	} 
	@Override
	public Map<String, Object> retrunDrug(Box box){
		return storesDataService.retrunDrug(box);
	}

	@Override
	public Map<String, Object> showPendingListForDepartmentReturnAcknowledgement(Box box) {
	
		return storesDataService.showPendingListForDepartmentReturnAcknowledgement(box);
	}

	@Override
	public Map<String, Object> showDepartemntReturnAcknowledgementJsp(Box box) {
		
		return storesDataService.showDepartemntReturnAcknowledgementJsp(box);
	}

	@Override
	public Map<String, Object> submitDepartmentReturnApproval(Box box) {
		
		return storesDataService.submitDepartmentReturnApproval(box);
	}

	@Override
	public Map<String, Object> showUnBlockItem(Box box) {
		
		return storesDataService.showUnBlockItem(box);
	}

	@Override
	public Map<String, Object> getInstituteList() {
		
		return storesDataService.getInstituteList();
	}

	@Override
	public Map<String, Object> deleteBroadCast(Box box) {
	
		return storesDataService.deleteBroadCast(box);
	}

	@Override
	public Map<String, Object> showSubstandardFreezedItemJsp() {
		return storesDataService.showSubstandardFreezedItemJsp();
	}

	//VK
	 
	@Override
	public Map<String, Object> viewNacItemJsp(Map<String, Object> dataMap) {
		 
		return storesDataService.viewNacItemJsp(dataMap);
	}

	@Override
	public Map<String, Object> getDepartmentList() {
		
		return storesDataService.getDepartmentList();
	}


	public Map<String, Object> getDailyIssueItem(Map<String, Object> requestParameters) {
	
		return storesDataService.getDailyIssueItem(requestParameters);
	}

	@Override
	public List<StoreIssueT> getIssueList(int issueTId) {
		return storesDataService.getIssueList(issueTId);
	}

	@Override
	public Map<String, Object> getPopupValueForItemReplacement(int itemId,int deptId) {
		return storesDataService.getPopupValueForItemReplacement(itemId,deptId);
	}

	@Override
	public Map<String, Object> addPatientDrugIssueReplace(Box box) {
		return storesDataService.addPatientDrugIssueReplace(box);
	}

	@Override
	public List<Object> getVisitNoList(Map<String, Object> detailsMap) {
		return storesDataService.getVisitNoList(detailsMap);
	}

	@Override
	public List<Object> getPrescriptionList(Map<String, Object> detailsMap) {
		return storesDataService.getPrescriptionList(detailsMap);
	}

	@Override
	public Map<String, Object> getDetailsForMedicineIssue(int issueTId) {
		return storesDataService.getDetailsForMedicineIssue(issueTId);
	}
	
	@Override
	public Map<String, Object> uploadAndViewDocuments(Box box,Map<String, Object> details) {
		return storesDataService.uploadAndViewDocuments(box,details);
	}

	@Override
	public Map<String, Object> submitIssueForOtherInstituteIndent(
			Map<String, Object> utilMap, Box box) {
		
		return storesDataService.submitIssueForOtherInstituteIndent(utilMap,box);
	}

	@Override
	public Map<String, Object> getAutoCompleteForItemList(Map<String, Object> detailsMap) {
		return storesDataService.getAutoCompleteForItemList(detailsMap);
	}

	@Override
	public Map<String, Object> getItemListForOtc(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getItemListForOtc(box);
	}

	@Override
	public Map<String, Object> fillItemsForOtcDrugs(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.fillItemsForOtcDrugs(dataMap);
	}

	@Override
	public Map<String, Object> getclosingStock(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.getclosingStock(dataMap);
	}
	
	@Override
	public Map<String, Object> showDetailedStockRegisterReportJsp(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return storesDataService.showDetailedStockRegisterReportJsp(dataMap);
	}
	
	
	@Override
	public Map<String, Object> printDetailedStockRegisterCentralStoreReport(
			Map<String, Object> requestParameters){
		// TODO Auto-generated method stub
		return storesDataService.printDetailedStockRegisterCentralStoreReport(requestParameters);
	}

	

	@Override
	public Map<String, Object> printStockStatusJsp() {
		return storesDataService.printStockStatusJsp();
	}

	@Override
	public Map<String, Object> getOpeningData(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.getOpeningData(box);
	}

	
	@Override
	public Map<String, Object> displaySlowMovingDrugsJsp(Box box) {
		// TODO Auto-generated method stub
		return storesDataService.displaySlowMovingDrugsJsp(box);
	}
	@Override
	public Map<String, Object> addPHColums(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return storesDataService.addPHColums(map);
	}
	@Override
	public Map<String, Object> getHospitalList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return storesDataService.getHospitalList(map);
	}
	
	//added by govind 30-9-2016
	public Map<String, Object> getsearchPatientReturnDrug(Box box) {
		return storesDataService.getsearchPatientReturnDrug(box);
	}
	
	@Override
	public Map<String, Object> getItemListForAutoCompleteForStockRegister(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return storesDataService.getItemListForAutoCompleteForStockRegister(map);
	}
	//added by govind 15-10-2016
	@Override
	public Map<String, Object> searchDirectDispensing(Box box) {
		return storesDataService.searchDirectDispensing(box);
	}

	@Override
	public Map<String, Object> getItemStockValue(Box box) {
		return storesDataService.getItemStockValue(box);
	}
	@Override
	public Map<String, Object> pharmacyIssuePatientDrug(Box box){
		
		return storesDataService.pharmacyIssuePatientDrug(box);
	}

	
	@Override
	public Map<String, Object> getdrugStock(Map<String, Object> datamap) {
		return storesDataService.getdrugStock(datamap);
	}

	@Override
	public Map<String, Object> getMasItemId(Box box) {
		return storesDataService.getMasItemId(box);
	}

	@Override
	public Map<String, Object> getInstituteWiseStock(Box box) {
		return storesDataService.getInstituteWiseStock(box);
	}

	@Override
	public Map<String, Object> importKMSCLStock(Map<String, Object> utilMap) {
		return storesDataService.importKMSCLStock(utilMap) ;
	}

	@Override
	public Map<String, Object> showCtJsp(Box box) {
	
		return storesDataService.showCtJsp(box);
	}

	@Override
	public Map<String, Object> getPatientDetailsForCT(Box box){
		// TODO Auto-generated method stub
		return storesDataService.getPatientDetailsForCT(box);
	}

	@Override
	public Map<String, Object> saveCtDetails(Box box) {
		
		return storesDataService.saveCtDetails(box);
	}

	@Override
	public String generatePrecriptionNo(int hinId) {
		
		return storesDataService.generatePrecriptionNo(hinId);
	}
}

