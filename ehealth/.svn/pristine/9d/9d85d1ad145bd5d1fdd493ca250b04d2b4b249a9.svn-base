package jkt.hms.purchaseOrder.handler;

import java.util.Map;

import javazoom.upload.MultipartFormDataRequest;
import jkt.hms.masters.business.MasAssetCategory;
import jkt.hms.util.Box;



public interface ProcurementHandlerService {

	Map<String, Object> showPendingitemsforLocalPurchaseJsp(Box box,Map<String, Object> dataMap);

	Map<String, Object> showQuotationRequisitionJsp(Box box,Map<String, Object> dataMap);
	Map<String, Object> saveQuotationRequisitionJsp(Box box,Map<String, Object> dataMap);

	Map<String, Object> showPendingListForApprovalOfQuotationRequisitionJsp(
			Box box, Map<String, Object> dataMap);

	Map<String, Object> showQuotationRequisitionApprovalJsp(Box box,
			Map<String, Object> dataMap);

	Map<String, Object> saveQuotationRequisitionApprovalJsp(Box box,
			Map<String, Object> dataMap);

	Map<String, Object> showPendingListForSubmittingQuotationJsp(Box box,
			Map<String, Object> dataMap);

	Map<String, Object> showQuotationSubmissionJsp(Box box,
			Map<String, Object> dataMap);

	Map<String, Object> showAccessoryDetailsJsp(Box box,Map<String, Object> dataMap);
	Map<String, Object> saveAccessoryDetailsJsp(Box box,Map<String, Object> dataMap);
	//Map<String, Object> saveItemQuotationSubmissionJsp(Box box,Map<String, Object> dataMap);


	Map<String, Object> showTechnicalApprovalJsp(Box box,
			Map<String, Object> dataMap);

	Map<String, Object> showCommercialApprovalJsp(Box box,
			Map<String, Object> dataMap);

	Map<String, Object> showPendingListForCreatingPOWOJsp(Box box,
			Map<String, Object> dataMap);
	
	Map<String, Object> showPendingTechnicalApprovalJsp(Box box,
			Map<String, Object> dataMap);
	Map<String, Object> showPendingCommercialApprovalJsp(Box box,
			Map<String, Object> dataMap);

	Map<String, Object> showPOCreationJsp(Box box, Map<String, Object> dataMap);

	Map<String, Object> showPendingForPOApprovalJsp(Box box,
			Map<String, Object> dataMap);

	Map<String, Object> showPOApprovalJsp(Box box, Map<String, Object> dataMap);

	Map<String, Object> showPendingListForEnterEquipmentDetailJsp(Box box,
			Map<String, Object> dataMap);

	Map<String, Object> showEquipmentDetailJsp(Box box,
			Map<String, Object> dataMap);

	Map<String, Object> showManufactureDetailJsp(Box box);

	Map<String, Object> showCategoryMasterJsp();

	Map<String, Object> showSubCategoryMasterJsp();

	Map<String, Object> showAssetDetailsJsp(Map<String, Object> details);

	Map<String, Object> showPendingListForAuctionJsp(Box box,
			Map<String, Object> dataMap);

	Map<String, Object> showAuctionDetailJsp(Box box,
			Map<String, Object> dataMap);

	Map<String, Object> showInsuranceDetailJsp(Box box,
			Map<String, Object> dataMap);

	Map<String, Object> showInsuranceClaimAndTrackingJsp(Box box,
			Map<String, Object> dataMap);

	Map<String, Object> showPhysicalInventoryDetailsJsp(Map<String, Object> dataMap,Box box);


	Map<String, Object> searchCategory(String categoryCode, String categoryName);

	boolean addCategory(MasAssetCategory masCategory);

	boolean deleteCategory(int categoryId, Map<String, Object> generalMap);

	boolean editCategoryToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchSubCategory(String subCategoryCode,String subCategoryName);

	boolean editSubCategoryToDatabase(Map<String, Object> generalMap);

	boolean deleteSubCategory(int subCategoryId, Map<String, Object> generalMap);

	
	Map<String, Object> openVendorListJsp(Box box, Map<String, Object> dataMap);
	//Map<String, Object> showVendorListJsp(Box box, Map<String, Object> dataMap);

	Map<String, Object> getItemTypeGLList(Map<String, Object> dataMap);

	//Map<String, Object> getSectionGLList(Map<String, Object> dataMap);
	//Map<String, Object> responseQuotationRequisition(Map<String, Object> dataMap);
	Map<String, Object> responseTechnicalApproval(Box box,Map<String, Object> dataMap);
	Map<String, Object> vendorListCommercialJsp(Box box,Map<String, Object> dataMap);


	Map<String, Object> saveTechnicalApproval(Box box,Map<String, Object> dataMap);

	Map<String, Object> getItemListForCommercial(Map<String, Object> dataMap);
	Map<String, Object> saveCommercialApproval(Box box ,Map<String, Object> dataMap);
   Map<String, Object> showNegotiationJsp(Box box, Map<String, Object> dataMap);
   Map<String, Object> vendorListNegotiation(Box box,Map<String, Object> dataMap);

    Map<String, Object> getItemListForNegotiation(Box box,Map<String, Object> dataMap);
	Map<String, Object> saveNegotiation(Box box ,Map<String, Object> dataMap);

	Map<String, Object> submitPoCreation(Box box, Map<String, Object> dataMap);
	Map<String, Object> submitEquipmentDetails(Box box, Map<String, Object> dataMap);
	Map<String, Object> poApproval(Box box, Map<String, Object> dataMap);
	Map<String, Object> addImmuableAssets(MultipartFormDataRequest mRequest, Map<String, Object> dataMap);

	Map<String, Object> showMarkForAuctionJsp(Box box);

	Map<String, Object> searchAssetsMarkForAuction(Box box);

	Map<String, Object> submitMarkForAuction(Box box);

	Map<String, Object> showPendingListForAuctionJsp(Box box);

	Map<String, Object> searchPendingListForAuction(Box box);

	Map<String, Object> showAuctionApprovalJsp(Box box);

	Map<String, Object> submitAuctionApproval(Box box);
	
	Map<String, Object> directPoCreation(Box box, Map<String, Object> dataMap);

	Map<String, Object> getItemList(Map<String, Object> map);
	Map<String, Object>  showPendingListNegotiation(Map<String, Object> details);

	Map<String, Object> submitPoCreationDirect(Box box,Map<String, Object> dataMap);

	Map<String, Object> submitInsuranceDetails(Box box,
			  Map<String, Object> dataMap);

	Map<String, Object> showPendingRenewalInsurance(Box box,
			Map<String, Object> dataMap);

	Map<String, Object> showRenewaljsp(Box box, Map<String, Object> dataMap);

	Map<String, Object> showPendingListForAuctionDetailJsp(Box box);
	public Map<String, Object> showAssetDetailsMovableJsp(
			Map<String, Object> details);

	Map<String, Object> submitrenewalInsuranceDetails(Box box,
			Map<String, Object> dataMap);

	Map<String, Object> searchPendingListForAuctionDetail(Box box);

	Map<String, Object> showAuctionDetailJsp(Box box);

	Map<String, Object> submitAuctionDetail(Box box);

	Map<String, Object> addMuableAssets(MultipartFormDataRequest mrequest,
			Map<String, Object> generalMap);
	
	public Map<String, Object> getMasStoreItemList(Box box);

	Map<String, Object> submitPhysicalInventoryDetails(Box box);

	Map<String, Object> showPhysicalInventoryApprovalListJsp(Box box);

	Map<String, Object> showPhysicalInventoryApprovalJsp(Box box);

	Map<String, Object> submitPhysicalInventoryApproval(Box box);

	Map<String, Object> submitInsuranceClaimTracking(Box box);
	
	Map<String,Object> populateStoreItemNameByCode(int itemCode);
	
	Map<String,Object> populateStoreItemCategory(int storeSectionId);
	
	Map<String,Object> populateCodeByItemName(int itemNameId);
	
	Map<String,Object> populateImmovableStoreItemCategory(int storeSectionId);
	
	Map<String,Object> populateImmovableCodeByItemName(int itemNameId);

	Map<String, Object> showLocalPurchaseItemTracking(int hospitalId);

	Map<String, Object> getConnectionForReport();

	Map<String, Object> printForLocalPurchaseItemTrackingScreen(int hospitalId,	int poId, Box box);

	Map<String, Object> showPendingCondemnationJsp(Box box,
			Map<String, Object> dataMap);

	Map<String, Object> showCondemAuctionJsp(Box box,
			Map<String, Object> dataMap);

	Map<String, Object> getItemListForEquipDetail(Map<String, Object> dataMap);

	Map<String, Object> getFromDateAndToDate(Map<String, Object> detailsMap);
}
