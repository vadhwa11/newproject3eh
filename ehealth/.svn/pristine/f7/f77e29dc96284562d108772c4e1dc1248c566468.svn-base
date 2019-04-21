package jkt.hrms.masters.dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasHospital;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.HrMasInsurance;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class InsuranceDataServiceImpl extends HibernateDaoSupport implements
		InsuranceDataService {

	// ******************************************* Start For Insurance Master By
	// Rajendra ****************************************//
	@SuppressWarnings("unchecked")
	public Map<String, Object> showInsuranceMasterJsp() {
		List<HrMasInsurance> searchInsuranceMasterList = new ArrayList<HrMasInsurance>();
		Map<String, Object> insuranceMasterFieldList = new HashMap<String, Object>();
		searchInsuranceMasterList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasInsurance");
		insuranceMasterFieldList.put("searchInsuranceMasterList",
				searchInsuranceMasterList);
		return insuranceMasterFieldList;
	}

	@SuppressWarnings("unchecked")
	public boolean addInsuranceMaster(HrMasInsurance hrmasInsurance) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrmasInsurance);
		successfullyAdded = true;
		return successfullyAdded;

	}

	@SuppressWarnings("unchecked")
	public boolean editInsuranceMaster(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String insuranceCode = "";
		String insuranceName = "";
		String insuranceType = "";
		int hospitalId = 0;
		int insuranceId = 0;

		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		try {
			insuranceId = (Integer) generalMap.get("id");
			hospitalId = (Integer) generalMap.get("hospitalId");
			insuranceCode = (String) generalMap.get("code");
			insuranceName = (String) generalMap.get("name");
			insuranceType = (String) generalMap.get("insuranceType");

			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			HrMasInsurance hrMasInsurance = (HrMasInsurance) getHibernateTemplate()
					.load(HrMasInsurance.class, insuranceId);

			hrMasInsurance.setId(insuranceId);
			hrMasInsurance.setInsuranceCode(insuranceCode);
			hrMasInsurance.setInsuranceName(insuranceName);
			hrMasInsurance.setInsuranceType(insuranceType);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasInsurance.setCompany(masHospital);

			hrMasInsurance.setLastChgBy(changedBy);
			hrMasInsurance.setLastChgDate(currentDate);
			hrMasInsurance.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasInsurance);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchInsuranceMaster(String insuranceCode,
			String insuranceName) {
		List<HrMasInsurance> searchInsuranceMasterList = new ArrayList<HrMasInsurance>();
		Map<String, Object> insuranceMasterFieldMap = new HashMap<String, Object>();
		try {
			if (insuranceCode != null || insuranceName == null) {
				searchInsuranceMasterList = getHibernateTemplate()
						.find("from jkt.hrms.masters.business.HrMasInsurance mi where mi.InsuranceCode like '"
								+ insuranceCode
								+ "%' order by mi.InsuranceCode");
			} else {
				searchInsuranceMasterList = getHibernateTemplate()
						.find("from jkt.hrms.masters.business.HrMasInsurance mi where mi.InsuranceName like '"
								+ insuranceName
								+ "%' order by mi.InsuranceName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		insuranceMasterFieldMap.put("searchInsuranceMasterList",
				searchInsuranceMasterList);
		return insuranceMasterFieldMap;

	}

	@SuppressWarnings("unchecked")
	public boolean deleteInsuranceMaster(int insuranceId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			HrMasInsurance hrmasInsurance = new HrMasInsurance();
			hrmasInsurance = (HrMasInsurance) getHibernateTemplate().load(
					HrMasInsurance.class, insuranceId);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (hrmasInsurance.getStatus().equals("y")) {
				hrmasInsurance.setStatus("n");
				dataDeleted = true;
			} else {
				hrmasInsurance.setStatus("y");
				dataDeleted = false;
			}
			hrmasInsurance.setLastChgBy(changedBy);
			hrmasInsurance.setLastChgDate(currentDate);
			hrmasInsurance.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrmasInsurance);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;

	}

}
