package jkt.hrms.masters.dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasHospital;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.HrMasInstitute;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class InstituteDataServiceImpl extends HibernateDaoSupport implements
		InstituteDataService {

	// ****************************************** Start Of Institute Master by
	// Rajendra ****************************//
	@SuppressWarnings("unchecked")
	public Map<String, Object> showInstituteMasterJsp() {
		List<HrMasInstitute> searchInstituteMasterList = new ArrayList<HrMasInstitute>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		searchInstituteMasterList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasInstitute");
		generalMap.put("searchInstituteMasterList", searchInstituteMasterList);
		return generalMap;
	}

	@SuppressWarnings("unchecked")
	public boolean addInstituteMaster(HrMasInstitute hrmasInstitute) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrmasInstitute);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public Map<String, Object> searchInstituteMaster(String instituteCode,
			String instituteName) {
		List<HrMasInstitute> searchInstituteMasterList = new ArrayList<HrMasInstitute>();
		Map<String, Object> instituteMasterFieldMap = new HashMap<String, Object>();
		try {
			if ((instituteCode != null) || (instituteName == null)) {
				searchInstituteMasterList = getHibernateTemplate()
						.find("from jkt.hrms.masters.business.HrMasInstitute mi where mi.InstituteCode like '"
								+ instituteCode
								+ "%' order by mi.InstituteCode");
			} else {
				searchInstituteMasterList = getHibernateTemplate()
						.find("from jkt.hrms.masters.business.HrMasInstitute mi where mi.InstituteName like '"
								+ instituteName
								+ "%' order by mi.InstituteName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		instituteMasterFieldMap.put("searchInstituteMasterList",
				searchInstituteMasterList);
		return instituteMasterFieldMap;
	}

	@SuppressWarnings("unchecked")
	public boolean editInstituteMaster(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String instituteCode = "";
		String instituteName = "";
		int hospitalId = 0;
		int instituteId = 0;

		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		try {
			instituteId = (Integer) generalMap.get("id");
			hospitalId = (Integer) generalMap.get("hospitalId");
			instituteCode = (String) generalMap.get("code");
			instituteName = (String) generalMap.get("name");

			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			HrMasInstitute hrMasInstitute = (HrMasInstitute) getHibernateTemplate()
					.load(HrMasInstitute.class, instituteId);

			hrMasInstitute.setId(instituteId);
			hrMasInstitute.setInstituteCode(instituteCode);
			hrMasInstitute.setInstituteName(instituteName);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasInstitute.setCompany(masHospital);

			hrMasInstitute.setLastChgBy(changedBy);
			hrMasInstitute.setLastChgDate(currentDate);
			hrMasInstitute.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasInstitute);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteInstituteMaster(int instituteId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			HrMasInstitute hrMasInstitute = new HrMasInstitute();
			hrMasInstitute = (HrMasInstitute) getHibernateTemplate().load(
					HrMasInstitute.class, instituteId);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (hrMasInstitute.getStatus().equals("y")) {
				hrMasInstitute.setStatus("n");
				dataDeleted = true;
			} else {
				hrMasInstitute.setStatus("y");
				dataDeleted = false;
			}
			hrMasInstitute.setLastChgBy(changedBy);
			hrMasInstitute.setLastChgDate(currentDate);
			hrMasInstitute.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasInstitute);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;

	}

}
