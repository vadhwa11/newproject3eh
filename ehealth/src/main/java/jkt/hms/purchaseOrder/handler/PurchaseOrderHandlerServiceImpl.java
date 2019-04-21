package jkt.hms.purchaseOrder.handler;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasStoreBudget;
import jkt.hms.masters.business.MasStorePoDeliveryTerms;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.StorePoDetail;
import jkt.hms.masters.business.StorePoHeader;
import jkt.hms.purchaseOrder.dataservice.PurchaseOrderDataService;
import jkt.hms.util.Box;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class PurchaseOrderHandlerServiceImpl implements
		PurchaseOrderHandlerService {

	PurchaseOrderDataService purchaseOrderDataService = null;

	public Map<String, Object> showPurchaseOrderJsp(int deptId,int hospitalId) {
		return purchaseOrderDataService.showPurchaseOrderJsp(deptId,hospitalId);
	}

	public Map<String, Object> submitPurchaseOrder(Map<String, Object> infoMap) {
		return purchaseOrderDataService.submitPurchaseOrder(infoMap);
	}

	public Map<String, Object> getDetailsForMoreInfoPurchase() {
		return purchaseOrderDataService.getDetailsForMoreInfoPurchase();
	}

	public int getPurchaseOrderId(String poNumber) {
		return purchaseOrderDataService.getPurchaseOrderId(poNumber);
	}

	public List<StorePoHeader> getPoHeader(int poId) {
		return purchaseOrderDataService.getPoHeader(poId);
	}

	public List<StorePoHeader> getPoNumberList(int deptId,int hospitalId) {
		return purchaseOrderDataService.getPoNumberList(deptId,hospitalId);
	}

	public List<MasStoreBudget> getBudgetStatusList() {
		return purchaseOrderDataService.getBudgetStatusList();
	}

	public Map<String, Object> getViewAllMap() {
		return purchaseOrderDataService.getViewAllMap();
	}

	public Map<String, Object> searchPO(Map<String, Object> searchMap)
			 {
		return purchaseOrderDataService.searchPO(searchMap);
	}

	public Map<String, Object> poModifyMap(int id, int pageNo) {
		return purchaseOrderDataService.poModifyMap(id, pageNo);
	}

	public List<StorePoDetail> getPoDetailListForMoreInfoPurchase(int poDetailId) {
		return purchaseOrderDataService
				.getPoDetailListForMoreInfoPurchase(poDetailId);
	}

	public List<MasAuthorizer> getApprovalAuthoritiesList() {
		return purchaseOrderDataService.getApprovalAuthoritiesList();
	}

	public boolean updatePurchaseOrder(Map<String, Object> infoMap) {
		return purchaseOrderDataService.updatePurchaseOrder(infoMap);
	}

	public Map<String, Object> getConnectionForReport() {
		return purchaseOrderDataService.getConnectionForReport();
	}

	public boolean submitApprovalAuthority(String approvalIds, int poId) {
		return purchaseOrderDataService.submitApprovalAuthority(approvalIds,
				poId);
	}

	public List<MasStoreSupplier> getSupplierList() {
		return purchaseOrderDataService.getSupplierList();
	}

	public Map<String, Object> getStockDetails(Map<String, Object> costMap) {
		return purchaseOrderDataService.getStockDetails(costMap);
	}

	public Map<String, Object> getStoreSetUpDetails() {
		return purchaseOrderDataService.getStoreSetUpDetails();
	}

	public List<MasStorePoDeliveryTerms> getPaymentDetails() {
		return purchaseOrderDataService.getPaymentDetails();
	}

	public List<MasStorePoDeliveryTerms> getDeliveryDetails() {
		return purchaseOrderDataService.getDeliveryDetails();
	}

	public List<MasStorePoDeliveryTerms> getDescriptionForDeliveryTermId(
			int poDeliveryTermId) {
		return purchaseOrderDataService
				.getDescriptionForDeliveryTermId(poDeliveryTermId);
	}

	public Map<String, Object> getItemListForPurchaseOrder(
			Map<String, Object> dataMap) {
		return purchaseOrderDataService.getItemListForPurchaseOrder(dataMap);
	}

	public Map<String, Object> getPoListForPurchaseOrder(
			Map<String, Object> dataMap) {
		return purchaseOrderDataService.getPoListForPurchaseOrder(dataMap);
	}

	// Setters & Getters........

	public PurchaseOrderDataService getPurchaseOrderDataService() {
		return purchaseOrderDataService;
	}

	public void setPurchaseOrderDataService(
			PurchaseOrderDataService purchaseOrderDataService) {
		this.purchaseOrderDataService = purchaseOrderDataService;
	}

	public String getHospitalName(int i) {
		return purchaseOrderDataService.getHospitalName(i);
	}

	@Override
	public Map<String, Object> submitPurchaseOrderBelowReorder(Box box,int departmentId, String loginName,int hospitalId)
	{
		return purchaseOrderDataService.submitPurchaseOrderBelowReorder(box,departmentId,loginName,hospitalId);
	}

	@Override
	public Map<String, Object> showPOGenerationBelowReorderJsp(int deptId,int hospitalId) {
		return purchaseOrderDataService.showPOGenerationBelowReorderJsp(deptId,hospitalId);
	
	}
	public Map<String, Object> showROLJsp(int deptId) {
		return purchaseOrderDataService.showROLJsp(deptId);
	}
	public Map<String, Object> showROLJsp(int deptId,int groupId) {
	
		return purchaseOrderDataService.showROLJsp(deptId,groupId);
	}
	
	public Map<String, Object> submitReorderLevel(Box box,int departmentId, String loginName)
	{
		return purchaseOrderDataService.submitReorderLevel(box,departmentId,loginName);
	}

	@Override
	public Map<String, Object> runAbcProcedure(int deptId,String newFromDate,String newToDate,int itemCatId) {
		return purchaseOrderDataService.runAbcProcedure(deptId,newFromDate,newToDate,itemCatId);
	}

	@Override
	public Map<String, Object> showABCJsp() {
		return purchaseOrderDataService.showABCJsp();
	}

	@Override
	public Map<String, Object> runFsnProcedure(int deptId, Date startDate,
			Date endDate, int itemCatId) {
		return purchaseOrderDataService.runFsnProcedure(deptId,startDate,endDate,itemCatId);
	}

	@Override
	public Map<String, Object> getPoNumberAgainstVendorList(
			Map<String, Object> dataMap) {
		return purchaseOrderDataService.getPoNumberAgainstVendorList(dataMap);
	}

}
