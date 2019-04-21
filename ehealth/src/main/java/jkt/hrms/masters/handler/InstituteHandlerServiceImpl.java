package jkt.hrms.masters.handler;

import java.util.Map;

import jkt.hrms.masters.business.HrMasInstitute;
import jkt.hrms.masters.dataservice.InstituteDataService;

public class InstituteHandlerServiceImpl implements InstituteHandlerService {

	InstituteDataService instituteDataService = null;

	public InstituteDataService getInstituteDataService() {
		return instituteDataService;
	}

	public void setInstituteDataService(
			InstituteDataService instituteDataService) {
		this.instituteDataService = instituteDataService;
	}

	// ****************************************** Start Of Institute Master by
	// Rajendra ****************************//
	public Map<String, Object> showInstituteMasterJsp() {
		return instituteDataService.showInstituteMasterJsp();
	}

	public boolean addInstituteMaster(HrMasInstitute hrmasInstitute) {
		return instituteDataService.addInstituteMaster(hrmasInstitute);
	}

	public Map<String, Object> searchInstituteMaster(String instituteCode,
			String instituteName) {
		return instituteDataService.searchInstituteMaster(instituteCode,
				instituteName);
	}

	public boolean editInstituteMaster(Map<String, Object> generalMap) {
		return instituteDataService.editInstituteMaster(generalMap);
	}

	public boolean deleteInstituteMaster(int instituteId,
			Map<String, Object> generalMap) {
		return instituteDataService.deleteInstituteMaster(instituteId,
				generalMap);
	}
}
