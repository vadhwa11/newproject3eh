package jkt.hrms.masters.handler;

import java.util.Map;

import jkt.hrms.masters.business.HrMasInstalment;
import jkt.hrms.masters.dataservice.InstalmentDataService;

public class InstalmentHandlerServiceImpl implements InstalmentHandlerService {
	InstalmentDataService instalmentDataService = null;

	public InstalmentDataService getInstalmentDataService() {
		return instalmentDataService;
	}

	public void setInstalmentDataService(
			InstalmentDataService instalmentDataService) {
		this.instalmentDataService = instalmentDataService;
	}

	// **************************************Start For Instalment Master By
	// Rajendra ****************************************//

	public Map<String, Object> showInstalmentMasterJsp() {
		return instalmentDataService.showInstalmentMasterJsp();
	}

	public Map<String, Object> searchInstalmentMaster(String instalmentCode,
			String instalmentName) {
		return instalmentDataService.searchInstalmentMaster(instalmentCode,
				instalmentName);
	}

	public boolean addInstalmentMaster(HrMasInstalment hrMasInstalment) {
		return instalmentDataService.addInstalmentMaster(hrMasInstalment);
	}

	public boolean editInstalmentMaster(Map<String, Object> generalMap) {
		return instalmentDataService.editInstalmentMaster(generalMap);
	}

	public boolean deleteInstalmentMaster(int instalmentId,
			Map<String, Object> generalMap) {
		return instalmentDataService.deleteInstalmentMaster(instalmentId,
				generalMap);
	}

}
