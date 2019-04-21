package jkt.hms.sms.dataservice;

import java.util.List;

import java.util.Map;

import jkt.hms.masters.business.MasBulkDetail;
import jkt.hms.masters.business.MasBulkMain;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.OneToOne;
import jkt.hms.util.Box;

public interface SmsDataService {

	boolean saveOneToOne(OneToOne oto);

	Map<String, Object> showSendBulkSmsJsp();

	Map<String, Object> showSendonetoOneSmsJsp();

	Map<String, Object> updateBulkDetails(Map<String,Object> dataMap,Box box);

	Map<String, Object> getConnectionForReport();

	Map<String, Object> showGroupMasterJsp(int hospitalId);

	boolean addGroupSMS(MasBulkMain masBulkMain);

	boolean deletegroupSMS(int countryId, Map<String, Object> generalMap);

	boolean editCountryToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchGroupSMS(String groupCode, String groupName);

	Map<String, Object> showGroupWiseDetailJsp(int hospitalId);

	List<MasEmployee> getValForGroup(int hospitalId);

	List<MasStoreSupplier> getValForGroup1(int hospitalId);

	boolean saveGroupWiseDetail(List<MasStoreSupplier> supplierList);

	Map<String, Object> saveGroupWiseDetail(int hospitalId, MasBulkDetail mbd);

	int getEmployeeCategory(int employeeId);

	String getEmployeeMobile(int employeeId);

	boolean saveBulkSMS(Map<String, Object> generalMap);

}
