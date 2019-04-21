package jkt.hrms.masters.dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.HrMasSection;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class SectionMasterDataServiceImpl extends HibernateDaoSupport implements
		SectionMasterDataService {

	// ****************************************** Start Of OPD Template by
	// Rajendra ****************************//

	@SuppressWarnings("unchecked")
	public Map<String, Object> showSectionMasterJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasSection> searchSectionMasterList = new ArrayList<HrMasSection>();

		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();

		searchSectionMasterList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasSection");
		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment as md");
		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y'");
		map.put("searchSectionMasterList", searchSectionMasterList);
		map.put("departmentList", departmentList);
		map.put("gridDepartmentList", gridDepartmentList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchSectionMaster(String sectionCode,
			String sectionName) {
		List<HrMasSection> searchSectionMasterList = new ArrayList<HrMasSection>();
		Map<String, Object> sectionMasterFieldsMap = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();
		try {
			if ((sectionCode != null) || (sectionName == null)) {
				searchSectionMasterList = getHibernateTemplate().find(
						"from jkt.hrms.masters.business.HrMasSection ms where ms.SectionCode like '"
								+ sectionCode + "%' order by ms.SectionCode");
			} else {
				searchSectionMasterList = getHibernateTemplate().find(
						"from jkt.hrms.masters.business.HrMasSection ms where ms.SectionName like '"
								+ sectionName + "%' order by ms.SectionName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y'");
		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment as md");
		sectionMasterFieldsMap.put("searchSectionMasterList",
				searchSectionMasterList);
		sectionMasterFieldsMap.put("departmentList", departmentList);
		sectionMasterFieldsMap.put("gridDepartmentList", gridDepartmentList);
		return sectionMasterFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public boolean addSectionMaster(HrMasSection hrMasSection) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrMasSection);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean editSectionMaster(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String sectionCode = "";
		String sectionName = "";
		int departmentId = 0;
		int hospitalId = 0;
		int sectionId = 0;

		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		try {
			sectionId = (Integer) generalMap.get("id");
			departmentId = (Integer) generalMap.get("departmentId");
			hospitalId = (Integer) generalMap.get("hospitalId");
			sectionCode = (String) generalMap.get("jobCode");
			sectionName = (String) generalMap.get("name");

			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

			HrMasSection hrMasSection = (HrMasSection) getHibernateTemplate()
					.load(HrMasSection.class, sectionId);

			hrMasSection.setId(sectionId);
			hrMasSection.setSectionCode(sectionCode);
			hrMasSection.setSectionName(sectionName);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			hrMasSection.setDepartment(masDepartment);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasSection.setCompany(masHospital);

			hrMasSection.setLastChgBy(changedBy);
			hrMasSection.setLastChgDate(currentDate);
			hrMasSection.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasSection);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteSectionMaster(int sectionId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			HrMasSection hrMasSection = new HrMasSection();
			hrMasSection = (HrMasSection) getHibernateTemplate().load(
					HrMasSection.class, sectionId);
			Integer deparmentId = hrMasSection.getDepartment().getId();
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (hrMasSection.getStatus().equals("y")) {

				@SuppressWarnings("unused")
				List departmentList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDepartment as deparment where deparment.Id='"
								+ deparmentId + "' and deparment.Status='y'");
				hrMasSection.setStatus("n");
				dataDeleted = true;
			} else {
				hrMasSection.setStatus("y");
				dataDeleted = false;
			}
			hrMasSection.setLastChgBy(changedBy);
			hrMasSection.setLastChgDate(currentDate);
			hrMasSection.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasSection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}

}
