package jkt.hms.masters.dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasNursingCare;
import jkt.hms.masters.business.MasProcedureItemMapping;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.Users;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.hibernate.classic.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class NursingCareMasterDataServiceImpl extends HibernateDaoSupport
		implements NursingCareMasterDataService {

	public boolean addNursingCare(Map<String, Object> map) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		MasNursingCare masNursingCare=(MasNursingCare)map.get("masNursingCare");
		hbt.save(masNursingCare);
		List<String>itemList=(List<String>)map.get("itemList");
		for(String PvmsNo:itemList){
			MasProcedureItemMapping  mapping=new MasProcedureItemMapping();
			MasStoreItem masStoreItem=(MasStoreItem)session.createCriteria(MasStoreItem.class).add(Restrictions.eq("PvmsNo", PvmsNo)).list().get(0);
			mapping.setItem(masStoreItem);
			mapping.setProcedure(masNursingCare);
			hbt.save(mapping);
		}
		hbt.flush();
		hbt.clear();
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteNursingCare(int nursingCareId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasNursingCare masNursingCare = new MasNursingCare();
		masNursingCare = (MasNursingCare) getHibernateTemplate().load(
				MasNursingCare.class, nursingCareId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId = (Integer) generalMap.get(RequestConstants.USER_ID);

		if (masNursingCare.getStatus().equals("y")) {
			masNursingCare.setStatus("n");
			dataDeleted = true;
		} else {
			masNursingCare.setStatus("y");
			dataDeleted = false;
		}
		Users users=new Users();
		users.setId(userId);
		masNursingCare.setLastChgBy(users);
		masNursingCare.setLastChgDate(currentDate);
		masNursingCare.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masNursingCare);
		return dataDeleted;
	}

	public boolean editNursingCareToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String nursingCareName = "";
		@SuppressWarnings("unused")
		String nursingCareCode = "";
		String defaultStatus = "";
		int nursingCareId = 0;
		String changedBy = "";
		nursingCareId = (Integer) generalMap.get("id");
		nursingCareCode = (String) generalMap.get("nursingCareCode");
		nursingCareName = (String) generalMap.get("nursingCareName");
		defaultStatus = (String) generalMap.get("defaultStatus");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId = (Integer) generalMap.get(RequestConstants.USER_ID);
		
		int chargeCodeId =0;
		if(generalMap.get("chargeCodeId")!=null){
			chargeCodeId = (Integer) generalMap.get("chargeCodeId");
		}
		

		
		MasNursingCare masNursingCare = (MasNursingCare) getHibernateTemplate()
				.load(MasNursingCare.class, nursingCareId);

		masNursingCare.setId(nursingCareId);
		masNursingCare.setNursingName(nursingCareName);
		masNursingCare.setDefaultstatus(defaultStatus);
		Users users=new Users();
		users.setId(userId);
		masNursingCare.setLastChgBy(users);
		masNursingCare.setLastChgDate(currentDate);
		masNursingCare.setLastChgTime(currentTime);
		
		
		if(chargeCodeId!=0){
			MasChargeCode chargeCode = new MasChargeCode();
			chargeCode.setId(chargeCodeId);
			masNursingCare.setChargeCode(chargeCode);
		}

		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masNursingCare);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> searchNursingCare(String nursingCareCode,
			String nursingCareName) {
		List<MasNursingCare> searchNursingCareList = new ArrayList<MasNursingCare>();
		Map<String, Object> nursingCareFieldsMap = new HashMap<String, Object>();
		try {
			if ((nursingCareName != null) || (nursingCareCode == null)) {

				searchNursingCareList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasNursingCare sc where lower(sc.NursingName) like '"
								+ nursingCareName.toLowerCase()
								+ "%' order by sc.NursingName");
			} else {

				searchNursingCareList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasNursingCare sc where lower(sc.NursingCode) like '"
								+ nursingCareCode.toLowerCase()
								+ "%' order by sc.NursingCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		nursingCareFieldsMap
				.put("searchNursingCareList", searchNursingCareList);
		return nursingCareFieldsMap;
	}

	public Map<String, Object> showNursingCareJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasNursingCare> searchNursingCareList = new ArrayList<MasNursingCare>();
		searchNursingCareList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasNursingCare ");
		
		Session session = (Session) getSession();
		List<Object[]> chargeCodeList = new ArrayList<Object[]>();
		chargeCodeList = session
				.createCriteria(MasChargeCode.class).createAlias("ChargeType", "ct")
				.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("ChargeCodeName")))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("ct.ChargeTypeName", "Nursing Procedures").ignoreCase())
				.list();
		map.put("chargeCodeList", chargeCodeList);

		map.put("searchNursingCareList", searchNursingCareList);
		return map;
	}

}
