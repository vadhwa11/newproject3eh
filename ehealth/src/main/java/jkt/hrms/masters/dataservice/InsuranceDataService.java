package jkt.hrms.masters.dataservice;

import java.util.Map;

import jkt.hrms.masters.business.HrMasInsurance;

public interface InsuranceDataService {

	// ******************************************** Strat Fot Insurance Master
	// By Rajendra ***************************************//

	Map<String, Object> showInsuranceMasterJsp();

	boolean addInsuranceMaster(HrMasInsurance hrmasInsurance);

	boolean editInsuranceMaster(Map<String, Object> generalMap);

	Map<String, Object> searchInsuranceMaster(String insuranceCode,
			String insuranceName);

	boolean deleteInsuranceMaster(int insuranceId,
			Map<String, Object> generalMap);

}
