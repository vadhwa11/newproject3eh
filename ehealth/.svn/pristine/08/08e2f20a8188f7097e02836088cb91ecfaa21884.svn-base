package jkt.hms.sms.handler;


import java.util.List;

import java.util.Map;

import jkt.hms.masters.business.MasBulkDetail;
import jkt.hms.masters.business.MasBulkMain;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.OneToOne;
import jkt.hms.sms.dataservice.SmsDataService;
import jkt.hms.util.Box;

public class SmsHandlerServiceImpl implements SmsHandlerService {
SmsDataService smsDataService=null;

public SmsDataService getSmsDataService() {
	return smsDataService;
}

public void setSmsDataService(SmsDataService smsDataService) {
	this.smsDataService = smsDataService;
}

@Override
public boolean saveOneToOne(OneToOne oto) {
	return smsDataService.saveOneToOne(oto);
}

@Override
public Map<String, Object> showSendBulkSmsJsp() {
	return smsDataService.showSendBulkSmsJsp();
}

@Override
public Map<String, Object> showSendonetoOneSmsJsp() {
	return smsDataService.showSendonetoOneSmsJsp();
}

@Override
public Map<String, Object> updateBulkDetails(Map<String,Object> dataMap,Box box) {
	return smsDataService.updateBulkDetails(dataMap,box);
}

@Override
public Map<String, Object> getConnectionForReport() {
	return smsDataService.getConnectionForReport();
}

@Override
public Map<String, Object> showGroupMasterJsp(int hospitalId) {
	return smsDataService.showGroupMasterJsp(hospitalId);
}

@Override
public boolean addGroupSMS(MasBulkMain masBulkMain) {
	return smsDataService.addGroupSMS(masBulkMain);
}

@Override
public boolean deletegroupSMS(int countryId, Map<String, Object> generalMap) {
	return smsDataService.deletegroupSMS(countryId,generalMap);
}

@Override
public boolean editCountryToDatabase(Map<String, Object> generalMap) {
	return smsDataService.editCountryToDatabase(generalMap);
}

@Override
public Map<String, Object> searchGroupSMS(String groupCode, String groupName) {
	return smsDataService.searchGroupSMS( groupCode,  groupName);
}

@Override
public Map<String, Object> showGroupWiseDetailJsp(int hospitalId) {
	return smsDataService.showGroupWiseDetailJsp(hospitalId);
}

@Override
public List<MasEmployee> getValForGroup(int hospitalId) {
	return smsDataService.getValForGroup(hospitalId);
}

@Override
public List<MasStoreSupplier> getValForGroup1(int hospitalId) {
	return smsDataService.getValForGroup1(hospitalId);
}

@Override
public boolean saveGroupWiseDetail(List<MasStoreSupplier> supplierList) {
	return smsDataService.saveGroupWiseDetail(supplierList);
}

@Override
public Map<String, Object> saveGroupWiseDetail(int hospitalId, MasBulkDetail mbd) {
	return smsDataService.saveGroupWiseDetail(hospitalId,mbd);
}

@Override
public int getEmployeeCategory(int employeeId) {
	return smsDataService.getEmployeeCategory(employeeId);
}

@Override
public String getEmployeeMobile(int employeeId) {
	return smsDataService.getEmployeeMobile(employeeId);
}

@Override
public boolean saveBulkSMS(Map<String, Object> generalMap) {
	return smsDataService.saveBulkSMS(generalMap);
}

	
	
}
