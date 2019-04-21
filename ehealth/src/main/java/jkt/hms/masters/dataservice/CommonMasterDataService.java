package jkt.hms.masters.dataservice;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasApplication;

public interface CommonMasterDataService {

	// -----------------General Methods for All Masters By Deepti
	// Tevatia-------------------

	Map checkForExistingMasters(Map<String, Object> generalMap);

	List getMastersList(Map<String, Object> generalMap);

	List getMastersInformationOnChange(Map<String, Object> generalMap);

	List getMastersListByName(Map<String, Object> mastersEnquiryMap,
			String status);

	List getTableRecords(Map<String, Object> mapForDs);

	List getAllMasterRecords(String masterName);

	MasApplication getAppIdObject(String appId);

	Map<String, Object> getBreadCrumbs(String appId);

	public Map<String, Object> checkForExistingMastersForHrms(
			Map<String, Object> generalMap);

	Map<String, Object> getVillegeListForAutoComplete(
			Map<String, Object> mapForDs);

	Map<String, Object> getUserButtonRights(Map<String, Object> dataMap);

	

	String getMaxCode(String pojoName, String pojoPropertyCode);
	
	Map<String, Object> getVisitPendingListForPatientGrid(Map<String, Object> dataMap);

}
