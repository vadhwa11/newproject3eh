package jkt.hrms.masters.dataservice;

import java.util.Map;

import jkt.hrms.masters.business.HrMasSection;

public interface SectionMasterDataService {

	// ****************************************** Start Of Section Master by
	// Rajendra ****************************//
	Map<String, Object> showSectionMasterJsp();

	Map<String, Object> searchSectionMaster(String sectionCode,
			String sectionName);

	boolean addSectionMaster(HrMasSection hrMasSection);

	boolean editSectionMaster(Map<String, Object> geneMap);

	boolean deleteSectionMaster(int sectionId, Map<String, Object> generalMap);

}
