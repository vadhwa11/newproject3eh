package jkt.hrms.masters.dataservice;

import java.util.Map;

import jkt.hrms.masters.business.HrMasInstalment;

public interface InstalmentDataService {

	// ********************************************Start For Instalment Master
	// By Rajendra ****************************//

	Map<String, Object> showInstalmentMasterJsp();

	Map<String, Object> searchInstalmentMaster(String instalmentCode,
			String instalmentName);

	boolean addInstalmentMaster(HrMasInstalment hrMasInstalment);

	boolean editInstalmentMaster(Map<String, Object> generalMap);

	boolean deleteInstalmentMaster(int instalmentId,
			Map<String, Object> generalMap);

}
