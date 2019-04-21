package jkt.hrms.masters.dataservice;

import java.util.Map;

import jkt.hrms.masters.business.HrMasInstitute;

public interface InstituteDataService {

	// ****************************************** Start Of Institute Master by
	// Rajendra ****************************//
	Map<String, Object> showInstituteMasterJsp();

	boolean addInstituteMaster(HrMasInstitute hrmasInstitute);

	Map<String, Object> searchInstituteMaster(String instituteCode,
			String instituteName);

	boolean editInstituteMaster(Map<String, Object> generalMap);

	boolean deleteInstituteMaster(int instituteId,
			Map<String, Object> generalMap);

}
