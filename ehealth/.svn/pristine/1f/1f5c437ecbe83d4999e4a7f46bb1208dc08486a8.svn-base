package jkt.hrms.masters.dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasHospital;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.HrMasInstalment;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class InstalmentDataServiceImpl extends HibernateDaoSupport implements
		InstalmentDataService {

	// **********************************Strat For Instalment Master By Rajendra
	// **************************************//

	@SuppressWarnings("unchecked")
	public Map<String, Object> showInstalmentMasterJsp() {
		List<HrMasInstalment> searchInstalmentMasterList = new ArrayList<HrMasInstalment>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		searchInstalmentMasterList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasInstalment");
		generalMap
				.put("searchInstalmentMasterList", searchInstalmentMasterList);
		return generalMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchInstalmentMaster(String instalmentCode,
			String instalmentName) {
		List<HrMasInstalment> searchInstalmentMasterList = new ArrayList<HrMasInstalment>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		try {
			if (instalmentCode != null || instalmentName == null) {

				searchInstalmentMasterList = getHibernateTemplate()
						.find("from jkt.hrms.masters.business.HrMasInstalment mis where mis.InstalmentCode like '"
								+ instalmentCode
								+ "%' order by mis.InstalmentCode");
			} else {
				searchInstalmentMasterList = getHibernateTemplate()
						.find("from jkt.hrms.masters.business.HrMasInstalment mis where mis.InstalmentName like '"
								+ instalmentName
								+ "%' order by mis.InstalmentName");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		generalMap
				.put("searchInstalmentMasterList", searchInstalmentMasterList);
		return generalMap;

	}

	@SuppressWarnings("unchecked")
	public boolean addInstalmentMaster(HrMasInstalment hrMasInstalment) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrMasInstalment);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean editInstalmentMaster(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String instalmentCode = "";
		String instalmentName = "";
		int hospitalId = 0;
		int instalmentId = 0;

		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		try {
			instalmentId = (Integer) generalMap.get("id");
			hospitalId = (Integer) generalMap.get("hospitalId");
			instalmentCode = (String) generalMap.get("code");
			instalmentName = (String) generalMap.get("name");

			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			HrMasInstalment hrMasInstalment = (HrMasInstalment) getHibernateTemplate()
					.load(HrMasInstalment.class, instalmentId);

			hrMasInstalment.setId(instalmentId);
			hrMasInstalment.setInstalmentCode(instalmentCode);
			hrMasInstalment.setInstalmentName(instalmentName);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasInstalment.setCompany(masHospital);

			hrMasInstalment.setLastChgBy(changedBy);
			hrMasInstalment.setLastChgDate(currentDate);
			hrMasInstalment.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasInstalment);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteInstalmentMaster(int instalmentId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			HrMasInstalment hrMasInstalment = new HrMasInstalment();
			hrMasInstalment = (HrMasInstalment) getHibernateTemplate().load(
					HrMasInstalment.class, instalmentId);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (hrMasInstalment.getStatus().equals("y")) {
				hrMasInstalment.setStatus("n");
				dataDeleted = true;
			} else {
				hrMasInstalment.setStatus("y");
				dataDeleted = false;
			}
			hrMasInstalment.setLastChgBy(changedBy);
			hrMasInstalment.setLastChgDate(currentDate);
			hrMasInstalment.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasInstalment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;

	}

}
