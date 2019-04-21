package jkt.hms.stores.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.StoreAmcM;
import jkt.hms.masters.business.StoreAmcT;
import jkt.hms.masters.business.StoreGrnM;
import jkt.hms.masters.business.StoreGrnT;
import jkt.hms.masters.business.StoreLoaninM;
import jkt.hms.masters.business.StoreLoaninT;
import jkt.hms.masters.business.StoreRepairCivilFirm;
import jkt.hms.masters.business.StoreWorkOrderM;
import jkt.hms.stores.dataservice.NonExpendableStoresDataService;
import jkt.hms.stores.dataservice.StoresDataService;
import jkt.hms.util.Box;

public class NonExpendableStoresHandlerServiceImpl implements
		NonExpendableStoresHandlerService {
	NonExpendableStoresDataService nonExpendableStoresDataService = null;
	StoresDataService storesDataService = null;

	public NonExpendableStoresDataService getNonExpendableStoresDataService() {
		return nonExpendableStoresDataService;
	}

	public void setNonExpendableStoresDataService(
			NonExpendableStoresDataService nonExpendableStoresDataService) {
		this.nonExpendableStoresDataService = nonExpendableStoresDataService;
	}

	public StoresDataService getStoresDataService() {
		return storesDataService;
	}

	public void setStoresDataService(StoresDataService storesDataService) {
		this.storesDataService = storesDataService;
	}

	// ============== methods by abha ===============
	public Map showNeGrnJsp(Box box, Map<String, Object> dataMap) {
		return nonExpendableStoresDataService.showNeGrnJsp(box, dataMap);
	}

	public boolean addGrns(Map<String, Object> infoMap) {
		return nonExpendableStoresDataService.addGrns(infoMap);
	}

	public Map<String, Object> getListForNeGrn(String choice) {
		return nonExpendableStoresDataService.getListForNeGrn(choice);
	}

	public Map<String, Object> showGridJsp(Box box) {
		return nonExpendableStoresDataService.showGridJsp(box);
	}

	public Map showNeLoanInJsp(Box box, Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.showNeLoanInJsp(box, dataMap);
	}

	public boolean addLoanIn(Map<String, Object> infoMap) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.addLoanIn(infoMap);
	}

	public Map getResponseIndentList(Box box) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.getResponseIndentList(box);
	}

	public Map<String, Object> fillItemsForGrn(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.fillItemsForGrn(dataMap);
	}

	public Map<String, Object> getItemListForGrnByAutocomplete(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService
				.getItemListForGrnByAutocomplete(dataMap);
	}

	public Map<String, Object> fillItemsForLoanIn(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.fillItemsForLoanIn(dataMap);
	}

	public Map<String, Object> getItemListForLoanInByAutocomplete(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService
				.getItemListForLoanInByAutocomplete(dataMap);
	}

	public Map showWorkOrderJsp(Box box, Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.showWorkOrderJsp(box, dataMap);
	}

	public Map<String, Object> fillItemsForWorkOrder(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.fillItemsForWorkOrder(dataMap);
	}

	public Map<String, Object> getItemListForWorkOrderByAutocomplete(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService
				.getItemListForWorkOrderByAutocomplete(dataMap);
	}

	public boolean addWorkOrder(Map<String, Object> infoMap) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.addWorkOrder(infoMap);
	}

	public Map<String, Object> getWorkOrderModify(int workOrderId, int pageNo) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.getWorkOrderModify(workOrderId,
				pageNo);
	}

	// ===================================================
	// ============= end of methods by abha =================
	// ==========================================================

	public Map showAmcMaintenanceJsp(Box box) {

		return nonExpendableStoresDataService.showAmcMaintenanceJsp(box);
	}

	public Map getNomenclature(int departmentId) {

		return nonExpendableStoresDataService.getNomenclature(departmentId);
	}

	public Map getPvmsNoAndGetSerialNo(int nomenclatureId) {

		return nonExpendableStoresDataService
				.getPvmsNoAndGetSerialNo(nomenclatureId);
	}

	public Map getSerialNoDetails(String serialNo, int itemId) {

		return nonExpendableStoresDataService.getSerialNoDetails(serialNo,
				itemId);
	}

	public List getSupplierList() {

		return nonExpendableStoresDataService.getSupplierList();
	}

	public boolean addAmcMDetailsandaddAmcTDetails(StoreAmcM storeAmcM,
			List<StoreAmcT> storeList) throws Exception {
		return nonExpendableStoresDataService.addAmcMDetailsandaddAmcTDetails(
				storeAmcM, storeList);
	}

	public List getAmcMList() {

		return nonExpendableStoresDataService.getAmcMList();
	}

	public List getRepairNoList() {

		return nonExpendableStoresDataService.getRepairNoList();
	}

	public Map addStoreRepairCivilFirm(StoreRepairCivilFirm storeRepairCivilFirm)
			throws Exception {

		return nonExpendableStoresDataService
				.addStoreRepairCivilFirm(storeRepairCivilFirm);
	}

	public List getRepairNo() {
		return nonExpendableStoresDataService.getRepairNo();
	}

	public Map getAmcRepairDetails(int nomenclatureId, String repairNO) {

		return nonExpendableStoresDataService.getAmcRepairDetails(
				nomenclatureId, repairNO);

	}

	public List getDocEntryNo() {

		return nonExpendableStoresDataService.getDocEntryNo();
	}

	public Map updateStoreRepairCivilFirm(
			StoreRepairCivilFirm storeRepairCivilFirm) throws Exception {

		return nonExpendableStoresDataService
				.updateStoreRepairCivilFirm(storeRepairCivilFirm);

	}

	public Map getAmcSearchResult(Map searchFieldMap) {

		return nonExpendableStoresDataService
				.getAmcSearchResult(searchFieldMap);
	}

	public List getStoreAmcT(int id) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.getStoreAmcT(id);
	}

	public Map<String, Object> modifyGrn(int id, int pageNo) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.modifyGrn(id, pageNo);
	}

	public Map searchGrn(Map searchFieldMap) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.searchGrn(searchFieldMap);
	}

	public List<StoreWorkOrderM> getWorkOrderList() {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.getWorkOrderList();
	}

	public Map<String, Object> getConnectionForReport() {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.getConnectionForReport();
	}

	public Map<String, Object> modifyLoanin(int id, int pageNo) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.modifyLoanin(id, pageNo);
	}

	public Map searchLoanin(Map searchFieldMap) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.searchLoanin(searchFieldMap);
	}

	public Map showBoardOfSurvey() {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.showBoardOfSurvey();
	}

	public Map createAndImportBosData(Box box) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.createAndImportBosData(box);
	}

	public Map updateGridItemsBos(Box box) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.updateGridItemsBos(box);
	}

	public Map searchBosData(String BosNo, Box box) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.searchBosData(BosNo, box);
	}

	public Map updateSearchGridItemsBos(Box box) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.updateSearchGridItemsBos(box);
	}

	public List<StoreGrnM> getCrvNumberList(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.getCrvNumberList(dataMap);
	}

	public List<StoreLoaninM> getloanList(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.getloanList(dataMap);
	}

	public List<StoreLoaninT> getLoanInListForMoreInfo(int loaninDetailId) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService
				.getLoanInListForMoreInfo(loaninDetailId);
	}

	public List<StoreGrnT> getStoreGrnTListForMoreInfo(int storeGrnTId) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService
				.getStoreGrnTListForMoreInfo(storeGrnTId);
	}

	public Map getBosData(Box box) {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.getBosData(box);
	}

	// *********************************************************************************************************************
	// ------------------------------------Start of Methods Written By Anand &
	// Vivek ------------------------------------------
	// ****************************************************************************************************************

	// ============================Start of ME Scale Equipment
	// Details==============================

	public Map<String, Object> getMeScaleData(Box box) {
		return nonExpendableStoresDataService.getMeScaleData(box);
	}

	public Map<String, Object> searchItemsForMEScale(Box box) {
		return nonExpendableStoresDataService.searchItemsForMEScale(box);
	}

	public Map<String, Object> addItemToMeScale(Box box) {
		return nonExpendableStoresDataService.addItemToMeScale(box);
	}

	public Map<String, Object> deleteMeScaleItems(Box box) {
		return nonExpendableStoresDataService.deleteMeScaleItems(box);
	}

	public Map<String, Object> getMeScaleDescription(int meScaleNumber, Box box) {
		return nonExpendableStoresDataService.getMeScaleDescription(
				meScaleNumber, box);
	}

	public Map<String, Object> updateGridItemsInViewMeScale(Box box) {
		return nonExpendableStoresDataService.updateGridItemsInViewMeScale(box);
	}

	public Map<String, Object> viewMeScaleJsp() {
		return nonExpendableStoresDataService.viewMeScaleJsp();
	}

	// ============================End of ME Scale Equipment
	// Details==============================
	// *********************************************************************************************************************
	// ------------------------------------Start of Methods Written By Anand &
	// Vivek------------------------------------------
	// ****************************************************************************************************************

	public Map<String, Object> showWorkRegisterReportJsp() {
		// TODO Auto-generated method stub
		return nonExpendableStoresDataService.showWorkRegisterReportJsp();
	}
}
