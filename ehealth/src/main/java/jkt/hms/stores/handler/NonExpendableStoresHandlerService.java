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
import jkt.hms.util.Box;

public interface NonExpendableStoresHandlerService {

	// ========== methods by abha===============

	Map<String, Object> showNeGrnJsp(Box box, Map<String, Object> dataMap);

	boolean addGrns(Map<String, Object> infoMap);

	Map<String, Object> getListForNeGrn(String choice);

	Map<String, Object> getResponseIndentList(Box box);

	Map<String, Object> showGridJsp(Box box);

	Map<String, Object> fillItemsForGrn(Map<String, Object> dataMap);

	Map<String, Object> getItemListForGrnByAutocomplete(
			Map<String, Object> dataMap);

	Map<String, Object> showNeLoanInJsp(Box box, Map<String, Object> dataMap);

	Map<String, Object> searchGrn(Map<String, Object> searchFieldMap);

	Map<String, Object> modifyGrn(int id, int pageNo);

	List<StoreGrnM> getCrvNumberList(Map<String, Object> dataMap);

	Map<String, Object> fillItemsForLoanIn(Map<String, Object> dataMap);

	Map<String, Object> getItemListForLoanInByAutocomplete(
			Map<String, Object> dataMap);

	boolean addLoanIn(Map<String, Object> infoMap);

	Map<String, Object> showWorkOrderJsp(Box box, Map<String, Object> dataMap);

	Map<String, Object> fillItemsForWorkOrder(Map<String, Object> dataMap);

	Map<String, Object> getItemListForWorkOrderByAutocomplete(
			Map<String, Object> dataMap);

	boolean addWorkOrder(Map<String, Object> infoMap);

	Map<String, Object> getWorkOrderModify(int workOrderId, int pageNo);

	List<StoreWorkOrderM> getWorkOrderList();

	Map<String, Object> getConnectionForReport();

	Map<String, Object> searchLoanin(Map<String, Object> searchFieldMap);

	Map<String, Object> modifyLoanin(int id, int pageNo);

	List<StoreLoaninM> getloanList(Map<String, Object> dataMap);

	List<StoreGrnT> getStoreGrnTListForMoreInfo(int storeGrnTId);

	List<StoreLoaninT> getLoanInListForMoreInfo(int loaninDetailId);

	Map<String, Object> showWorkRegisterReportJsp();

	// ======= end of methods by abha===============
	// ============================================================
	Map<String, Object> showAmcMaintenanceJsp(Box box);

	List getSupplierList();

	List getAmcMList();

	List getRepairNoList();

	Map getNomenclature(int departmentId);

	Map getPvmsNoAndGetSerialNo(int nomenclatureId);

	Map getSerialNoDetails(String serialNo, int itemid);

	Map getAmcRepairDetails(int nomenclatureId, String repairNO);

	Map getAmcSearchResult(Map searchFieldMap);

	public List getRepairNo();

	public List getDocEntryNo();

	public List getStoreAmcT(int id);

	boolean addAmcMDetailsandaddAmcTDetails(StoreAmcM storeAmcM,
			List<StoreAmcT> storeList) throws Exception;

	Map addStoreRepairCivilFirm(StoreRepairCivilFirm storeRepairCivilFirm)
			throws Exception;

	Map updateStoreRepairCivilFirm(StoreRepairCivilFirm storeRepairCivilFirm)
			throws Exception;

	Map showBoardOfSurvey();

	Map createAndImportBosData(Box box);

	Map<String, Object> updateGridItemsBos(Box box);

	Map searchBosData(String BosNo, Box box);

	Map updateSearchGridItemsBos(Box box);

	Map getBosData(Box box);

	// *********************************************************************************************************************
	// ------------------------------------Start of Methods Written By Anand &
	// Vivek ------------------------------------------
	// ****************************************************************************************************************

	// ============================Start of ME Scale Equipment
	// Details==============================

	Map<String, Object> getMeScaleDescription(int meScaleNumber, Box box);

	Map<String, Object> updateGridItemsInViewMeScale(Box box);

	Map<String, Object> getMeScaleData(Box box);

	Map<String, Object> searchItemsForMEScale(Box box);

	Map<String, Object> addItemToMeScale(Box box);

	Map<String, Object> deleteMeScaleItems(Box box);

	Map<String, Object> viewMeScaleJsp();

	// ============================End of ME Scale Equipment
	// Details==============================
	// *********************************************************************************************************************
	// ------------------------------------Start of Methods Written By Anand &
	// Vivek------------------------------------------
	// ****************************************************************************************************************

}
