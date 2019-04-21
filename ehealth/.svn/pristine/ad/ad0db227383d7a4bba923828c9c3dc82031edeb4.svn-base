package jkt.hrms.masters.handler;

import java.util.Map;

import jkt.hrms.masters.business.HrMasSection;
import jkt.hrms.masters.dataservice.SectionMasterDataService;

public class SectionMasterHandlerServiceImpl implements
		SectionMasterHandlerService {

	SectionMasterDataService sectionMasterDataService = null;

	public void setSectionMasterDataService(
			SectionMasterDataService sectionMasterDataService) {
		this.sectionMasterDataService = sectionMasterDataService;
	}

	public SectionMasterDataService getSectionMasterDataService() {
		return sectionMasterDataService;
	}

	// ****************************************** Start Of Section Master by
	// Rajendra ****************************//
	public Map<String, Object> showSectionMasterJsp() {
		return sectionMasterDataService.showSectionMasterJsp();
	}

	public Map<String, Object> searchSectionMaster(String sectionCode,
			String sectionName) {
		return sectionMasterDataService.searchSectionMaster(sectionCode,
				sectionName);
	}

	public boolean addSectionMaster(HrMasSection hrMasSection) {
		return sectionMasterDataService.addSectionMaster(hrMasSection);
	}

	public boolean editSectionMaster(Map<String, Object> generalMap) {
		return sectionMasterDataService.editSectionMaster(generalMap);
	}

	public boolean deleteSectionMaster(int sectionId,
			Map<String, Object> generalMap) {
		return sectionMasterDataService.deleteSectionMaster(sectionId,
				generalMap);
	}

}
