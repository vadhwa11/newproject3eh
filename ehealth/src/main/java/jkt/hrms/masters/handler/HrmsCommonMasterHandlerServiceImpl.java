package jkt.hrms.masters.handler;

import java.util.List;
import java.util.Map;

import jkt.hrms.masters.dataservice.HrmsCommonMasterDataService;

public class HrmsCommonMasterHandlerServiceImpl implements
		HrmsCommonMasterHandlerService {
	HrmsCommonMasterDataService hrmsCommonMasterDataService = null;

	// -----------------General Methods for All Masters By Rajendra
	// Kumar-----------------------------

	public Map checkForExistingMasters(Map<String, Object> generalMap) {
		return hrmsCommonMasterDataService.checkForExistingMasters(generalMap);
	}

	public List getMastersList(Map<String, Object> generalMap) {
		List mastersList = hrmsCommonMasterDataService
				.getMastersList(generalMap);
		return mastersList;
	}

	public List getMastersListByName(Map<String, Object> mastersEnquiryMap,
			String status) {
		return hrmsCommonMasterDataService.getMastersListByName(
				mastersEnquiryMap, status);

	}

	public List getMastersInformationOnChange(Map<String, Object> generalMap) {
		List onChangeMastersList = hrmsCommonMasterDataService
				.getMastersInformationOnChange(generalMap);
		return onChangeMastersList;
	}

	public List getTableRecords(Map<String, Object> mapForDs) {
		return hrmsCommonMasterDataService.getTableRecords(mapForDs);
	}

	public HrmsCommonMasterDataService getHrmsCommonMasterDataService() {
		return hrmsCommonMasterDataService;
	}

	public void setHrmsCommonMasterDataService(
			HrmsCommonMasterDataService hrmsCommonMasterDataService) {
		this.hrmsCommonMasterDataService = hrmsCommonMasterDataService;
	}

	public List getAllMasterRecords(String masterName) {
		return hrmsCommonMasterDataService.getAllMasterRecords(masterName);
	}

}
