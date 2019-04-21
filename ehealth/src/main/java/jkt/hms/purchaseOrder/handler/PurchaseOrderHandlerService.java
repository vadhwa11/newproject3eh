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
import jkt.hms.util.Box;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public interface PurchaseOrderHandlerService {

	Map<String, Object> showPurchaseOrderJsp(int deptId, int hospitalId);

	Map<String, Object> submitPurchaseOrder(Map<String, Object> infoMap);

	Map<String, Object> getDetailsForMoreInfoPurchase();

	int getPurchaseOrderId(String poNumber);

	List<StorePoHeader> getPoHeader(int poId);

	List<StorePoHeader> getPoNumberList(int deptId, int hospitalId);

	List<MasStoreBudget> getBudgetStatusList();

	Map<String, Object> getViewAllMap();

	Map<String, Object> searchPO(Map<String, Object> searchMap)
			throws ParseException;

	public Map<String, Object> poModifyMap(int radio_str, int pageNo);

	List<StorePoDetail> getPoDetailListForMoreInfoPurchase(int poDetailId);

	boolean updatePurchaseOrder(Map<String, Object> infoMap);

	List<MasAuthorizer> getApprovalAuthoritiesList();

	Map<String, Object> getConnectionForReport();

	boolean submitApprovalAuthority(String string, int poId);

	List<MasStoreSupplier> getSupplierList();

	Map<String, Object> getStockDetails(Map<String, Object> costMap);

	Map<String, Object> getStoreSetUpDetails();

	List<MasStorePoDeliveryTerms> getPaymentDetails();

	List<MasStorePoDeliveryTerms> getDeliveryDetails();

	List<MasStorePoDeliveryTerms> getDescriptionForDeliveryTermId(
			int poDeliveryTermId);

	String getHospitalName(int i);

	Map<String, Object> getItemListForPurchaseOrder(Map<String, Object> dataMap);

	Map<String, Object> getPoListForPurchaseOrder(Map<String, Object> dataMap);
	
	Map<String, Object> submitPurchaseOrderBelowReorder(Box box, int departmentId, String loginName, int hospitalId);

	Map<String, Object> showPOGenerationBelowReorderJsp(int deptId,int hospitalId);
	
	Map<String, Object> showROLJsp(int deptId);
	
	Map<String, Object> showROLJsp(int deptId,int groupId);
	
	Map<String, Object> submitReorderLevel(Box box, int departmentId, String loginName);

	Map<String, Object> runAbcProcedure(int deptId, String newFromDate, String newToDate, int itemCatId);

	Map<String, Object> showABCJsp();

	Map<String, Object> runFsnProcedure(int deptId, Date startDate,Date endDate, int itemCatId);

	Map<String, Object> getPoNumberAgainstVendorList(Map<String, Object> dataMap);

		
}
