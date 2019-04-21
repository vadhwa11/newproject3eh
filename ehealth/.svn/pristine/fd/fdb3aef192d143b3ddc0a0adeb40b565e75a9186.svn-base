package jkt.hrms.setup.handler;

import java.util.Map;

import jkt.hrms.masters.business.HrMasParameterMaintenance;
import jkt.hrms.setup.dataservice.SetupDataService;

public class SetupHandlerServiceImpl implements SetupHandlerService {
	SetupDataService setupDataService = null;

	public SetupDataService getSetupDataService() {
		return setupDataService;
	}

	public void setSetupDataService(SetupDataService setupDataService) {
		this.setupDataService = setupDataService;
	}

	public Map<String, Object> saveParameterMaintenance(
			HrMasParameterMaintenance hrMasParameterMaintenance) {

		return setupDataService
				.saveParameterMaintenance(hrMasParameterMaintenance);
	}

	public Map<String, Object> showParameterMaintenanceJsp(int hospitalId) {

		return setupDataService.showParameterMaintenanceJsp(hospitalId);
	}

	public Map<String, Object> upDateParameterMaintenance(
			Map<String, Object> generalMap) {

		return setupDataService.upDateParameterMaintenance(generalMap);
	}

}
