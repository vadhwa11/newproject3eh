package jkt.hms.masters.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasApplication;
import jkt.hms.masters.dataservice.CommonMasterDataService;

public class CommonMasterHandlerServiceImpl implements
		CommonMasterHandlerService {
	CommonMasterDataService commonMasterDataService = null;

	// -----------------General Methods for All Masters By Deepti
	// Tevatia-----------------------------

	public Map checkForExistingMasters(Map<String, Object> generalMap) {
		return commonMasterDataService.checkForExistingMasters(generalMap);
	}

	public List getMastersList(Map<String, Object> generalMap) {
		List mastersList = commonMasterDataService.getMastersList(generalMap);
		return mastersList;
	}

	public List getMastersListByName(Map<String, Object> mastersEnquiryMap,
			String status) {
		return commonMasterDataService.getMastersListByName(mastersEnquiryMap,
				status);

	}

	public List getMastersInformationOnChange(Map<String, Object> generalMap) {
		List onChangeMastersList = commonMasterDataService
				.getMastersInformationOnChange(generalMap);
		return onChangeMastersList;
	}

	public List getTableRecords(Map<String, Object> mapForDs) {
		return commonMasterDataService.getTableRecords(mapForDs);
	}

	public MasApplication getAppIdObject(String appId) {
		return commonMasterDataService.getAppIdObject(appId);
	}

	public Map<String, Object> getBreadCrumbs(String appId) {
		return commonMasterDataService.getBreadCrumbs(appId);
	}

	public CommonMasterDataService getCommonMasterDataService() {
		return commonMasterDataService;
	}

	public void setCommonMasterDataService(
			CommonMasterDataService commonMasterDataService) {
		this.commonMasterDataService = commonMasterDataService;
	}

	public List getAllMasterRecords(String masterName) {
		return commonMasterDataService.getAllMasterRecords(masterName);
	}

	public Map<String, Object> checkForExistingMastersForHrms(
			Map<String, Object> generalMap) {
		return commonMasterDataService
				.checkForExistingMastersForHrms(generalMap);
	}

	public Map<String, Object> getVillegeListForAutoComplete(
			Map<String, Object> mapForDs) {
		return commonMasterDataService.getVillegeListForAutoComplete(mapForDs);
	}

	@Override
	public Map<String, Object> getUserButtonRights(Map<String, Object> dataMap) {
		return commonMasterDataService.getUserButtonRights(dataMap);
	}

	@Override
	public String getMaxCode(String pojoName,String pojoPropertyCode) {
		return commonMasterDataService.getMaxCode(pojoName,pojoPropertyCode);
	}
	@Override
	public Map<String, Object> getVisitPendingListForPatientGrid(Map<String, Object> dataMap){
		return commonMasterDataService.getVisitPendingListForPatientGrid(dataMap);
	}


}
