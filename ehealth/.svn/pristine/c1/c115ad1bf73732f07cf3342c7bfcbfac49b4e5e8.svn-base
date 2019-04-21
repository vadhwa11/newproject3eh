package jkt.hrms.masters.handler;

import java.util.Map;

import jkt.hrms.masters.business.HrMasInsurance;
import jkt.hrms.masters.dataservice.InsuranceDataService;

public class InsuranceHandlerServiceImpl implements InsuranceHandlerService {
	InsuranceDataService insuranceDataService = null;

	public InsuranceDataService getInsuranceDataService() {
		return insuranceDataService;
	}

	public void setInsuranceDataService(
			InsuranceDataService insuranceDataService) {
		this.insuranceDataService = insuranceDataService;
	}

	// ***************************************** Start For Insurance Master By
	// Rajendra ************************************//

	public Map<String, Object> showInsuranceMasterJsp() {
		return insuranceDataService.showInsuranceMasterJsp();
	}

	public boolean addInsuranceMaster(HrMasInsurance hrmasInsurance) {
		return insuranceDataService.addInsuranceMaster(hrmasInsurance);
	}

	public boolean editInsuranceMaster(Map<String, Object> generalMap) {
		return insuranceDataService.editInsuranceMaster(generalMap);
	}

	public Map<String, Object> searchInsuranceMaster(String insuranceCode,
			String insuranceName) {
		return insuranceDataService.searchInsuranceMaster(insuranceCode,
				insuranceName);
	}

	public boolean deleteInsuranceMaster(int insuranceId,
			Map<String, Object> generalMap) {
		return insuranceDataService.deleteInsuranceMaster(insuranceId,
				generalMap);
	}

}
