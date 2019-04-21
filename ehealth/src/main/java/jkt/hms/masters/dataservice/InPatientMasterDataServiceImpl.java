package jkt.hms.masters.dataservice;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.DischargeItems;
import jkt.hms.masters.business.DischargeItemsCategory;
import jkt.hms.masters.business.HospitalDoctorUnitM;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.IpdKitIssueMasterTemplateM;
import jkt.hms.masters.business.IpdKitIssueMasterTemplateT;
import jkt.hms.masters.business.MasAmbulance;
import jkt.hms.masters.business.MasBabyStatus;
import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasBedStatus;
import jkt.hms.masters.business.MasBodyPart;
import jkt.hms.masters.business.MasCareType;
import jkt.hms.masters.business.MasEmployeeDepartment;
import jkt.hms.masters.business.MasInstituteDepartment;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MasWasteCategory;
import jkt.hms.masters.business.MasWasteContainer;
import jkt.hms.masters.business.MasDelivery;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDischargeStatus;
import jkt.hms.masters.business.MasDisposedTo;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHouseKeeping;
import jkt.hms.masters.business.MasHouseKeepingFrequency;
import jkt.hms.masters.business.MasInjuryNature;
import jkt.hms.masters.business.MasNeonatalProblem;
import jkt.hms.masters.business.MasOpdFrequency;
import jkt.hms.masters.business.MasOutsideTreatment;
import jkt.hms.masters.business.MasPerineumMaintenance;
import jkt.hms.masters.business.MasPostCode;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasTaluk;
import jkt.hms.masters.business.MasHouseKeeping;
import jkt.hms.masters.business.OtMasUnitDay;
import jkt.hms.masters.business.StoreBalanceT;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class InPatientMasterDataServiceImpl extends HibernateDaoSupport
		implements InPatientMasterDataService {

	// ------------------------------------------------ Bed Status
	// ---------------------------------------------
	public boolean editBedStatusToDat(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String bedStatusName = "";
		@SuppressWarnings("unused")
		String bedStatusCode = "";
		int bedStatusId = 0;
		String changedBy = "";

		bedStatusId = (Integer) generalMap.get("id");
		bedStatusCode = (String) generalMap.get("bedStatusCode");
		bedStatusName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId= (Integer) generalMap.get(RequestConstants.USER_ID);

		MasBedStatus masBedStatus = (MasBedStatus) getHibernateTemplate().load(
				MasBedStatus.class, bedStatusId);
		masBedStatus.setId(bedStatusId);
		masBedStatus.setBedStatusName(bedStatusName);
		Users users=new Users();
		users.setId(userId);
		masBedStatus.setLastChgBy(users);
		masBedStatus.setLastChgDate(currentDate);
		masBedStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBedStatus);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBedStatus(String bedStatusCode,
			String bedStatusName) {
		List<MasBedStatus> searchBedStatusList = new ArrayList<MasBedStatus>();
		Map bedStatusFieldsMap = new HashMap();
		try {
			if ((bedStatusName != null) || (bedStatusCode == null)) {
				searchBedStatusList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasBedStatus mbs where lower(mbs.BedStatusName) like '"
								+ bedStatusName.toLowerCase()
								+ "%' order by mbs.BedStatusName");
			} else {
				searchBedStatusList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasBedStatus mbs where lower(mbs.BedStatusCode) like '"
								+ bedStatusCode.toLowerCase()
								+ "%' order by mbs.BedStatusCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		bedStatusFieldsMap.put("searchBedStatusList", searchBedStatusList);
		return bedStatusFieldsMap;
	}

	public Map<String, Object> showBedStatusJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBedStatus> searchBedStatusList = new ArrayList<MasBedStatus>();
		try {
			searchBedStatusList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasBedStatus ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchBedStatusList", searchBedStatusList);
		return map;
	}

	public boolean addBedStatus(MasBedStatus masBedStatus) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masBedStatus);
		hbt.flush();
		hbt.clear();
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteBedStatus(int bedStatusId,
			Map<String, Object> generalMap) {
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		boolean dataDeleted = false;
		MasBedStatus masBedStatus = new MasBedStatus();
		masBedStatus = (MasBedStatus) getHibernateTemplate().load(
				MasBedStatus.class, bedStatusId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=(Integer) generalMap.get(RequestConstants.USER_ID);
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masBedStatus.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masBedStatus.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(userId);
		masBedStatus.setLastChgBy(users);
		masBedStatus.setLastChgDate(currentDate);
		masBedStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBedStatus);
		return dataDeleted;
	}

	// --------------------------Injury Nature
	// --------------------------------------

	public boolean addInjuryNature(MasInjuryNature masInjuryNature) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masInjuryNature);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editInjuryNatureToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String injuryNatureName = "";
		@SuppressWarnings("unused")
		String injuryNatureCode = "";
		int injuryNatureId = 0;
		int changedBy = 0;
		injuryNatureId = (Integer) generalMap.get("id");
		injuryNatureCode = (String) generalMap.get("injuryNatureCode");
		injuryNatureName = (String) generalMap.get("name");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasInjuryNature masInjuryNature = (MasInjuryNature) getHibernateTemplate()
				.load(MasInjuryNature.class, injuryNatureId);

		masInjuryNature.setId(injuryNatureId);
		masInjuryNature.setInjuryNatureName(injuryNatureName);
		Users users=new Users();
		users.setId(changedBy);
		masInjuryNature.setLastChgBy(users);
		masInjuryNature.setLastChgDate(currentDate);
		masInjuryNature.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masInjuryNature);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> searchInjuryNature(String injuryNatureCode,
			String injuryNatureName) {
		List<MasInjuryNature> searchInjuryNatureList = new ArrayList<MasInjuryNature>();
		Map<String, Object> injuryNatureFieldsMap = new HashMap<String, Object>();
		try {
			if ((injuryNatureName != null) || (injuryNatureCode == null)) {
				searchInjuryNatureList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasInjuryNature imc where imc.InjuryNatureName like '"
								+ injuryNatureName
								+ "%' order by imc.InjuryNatureName");
			} else {
				searchInjuryNatureList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasInjuryNature imc where imc.InjuryNatureCode like '"
								+ injuryNatureCode
								+ "%' order by imc.InjuryNatureCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		injuryNatureFieldsMap.put("searchInjuryNatureList",
				searchInjuryNatureList);
		return injuryNatureFieldsMap;
	}

	public Map<String, Object> showInjuryNatureJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasInjuryNature> searchInjuryNatureList = new ArrayList<MasInjuryNature>();
		searchInjuryNatureList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasInjuryNature ");
		map.put("searchInjuryNatureList", searchInjuryNatureList);
		return map;
	}

	public boolean deleteInjuryNature(int injuryNatureId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		MasInjuryNature masInjuryNature = new MasInjuryNature();
		masInjuryNature = (MasInjuryNature) getHibernateTemplate().load(
				MasInjuryNature.class, injuryNatureId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masInjuryNature.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masInjuryNature.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(changedBy);
		masInjuryNature.setLastChgBy(users);
		masInjuryNature.setLastChgDate(currentDate);
		masInjuryNature.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masInjuryNature);
		return dataDeleted;
	}

	// ------------------------------- Baby
	// Status--------------------------------------

	public boolean addBabyStatus(MasBabyStatus masBabyStatus) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masBabyStatus);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editBabyStatusToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String babyStatusName = "";
		@SuppressWarnings("unused")
		String babyStatusCode = "";
		int babyStatusId = 0;
		String changedBy = "";
		babyStatusId = (Integer) generalMap.get("id");
		babyStatusCode = (String) generalMap.get("babyStatusCode");
		babyStatusName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasBabyStatus masBabyStatus = (MasBabyStatus) getHibernateTemplate()
				.load(MasBabyStatus.class, babyStatusId);

		masBabyStatus.setId(babyStatusId);
		masBabyStatus.setBabyStatusName(babyStatusName);
		masBabyStatus.setLastChgBy(changedBy);
		masBabyStatus.setLastChgDate(currentDate);
		masBabyStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBabyStatus);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBabyStatus(String babyStatusCode,
			String babyStatusName) {
		List<MasBabyStatus> searchBabyStatusList = new ArrayList<MasBabyStatus>();
		Map<String, Object> babyStatusFieldsMap = new HashMap<String, Object>();
		try {
			if ((babyStatusName != null) || (babyStatusCode == null)) {
				searchBabyStatusList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasBabyStatus imc where imc.BabyStatusName like '"
								+ babyStatusName
								+ "%' order by imc.BabyStatusName");
			} else {
				searchBabyStatusList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasBabyStatus imc where imc.BabyStatusCode like '"
								+ babyStatusCode
								+ "%' order by imc.BabyStatusCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		babyStatusFieldsMap.put("searchBabyStatusList", searchBabyStatusList);
		return babyStatusFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBabyStatusJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBabyStatus> searchBabyStatusList = new ArrayList<MasBabyStatus>();
		searchBabyStatusList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBabyStatus ");
		map.put("searchBabyStatusList", searchBabyStatusList);
		return map;
	}

	public boolean deleteBabyStatus(int babyStatusId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		MasBabyStatus masBabyStatus = new MasBabyStatus();
		masBabyStatus = (MasBabyStatus) getHibernateTemplate().load(
				MasBabyStatus.class, babyStatusId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masBabyStatus.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masBabyStatus.setStatus("y");
				dataDeleted = false;
			}
		}
		masBabyStatus.setLastChgBy(changedBy);
		masBabyStatus.setLastChgDate(currentDate);
		masBabyStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBabyStatus);
		return dataDeleted;
	}

	// ------------------------delivery------------------------
	public boolean addDelivery(MasDelivery masDelivery) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDelivery);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteDelivery(int deliveryId, Map<String, Object> generalMap) {
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		boolean dataDeleted = false;
		MasDelivery masDelivery = new MasDelivery();
		masDelivery = (MasDelivery) getHibernateTemplate().load(
				MasDelivery.class, deliveryId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDelivery.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDelivery.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(changedBy);
		masDelivery.setLastChgBy(users);
		masDelivery.setLastChgDate(currentDate);
		masDelivery.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDelivery);
		return dataDeleted;

	}

	public boolean editDeliveryToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String deliveryName = "";
		@SuppressWarnings("unused")
		String deliveryCode = "";
		int deliveryId = 0;
		int changedBy = 0;
		deliveryId = (Integer) generalMap.get("id");
		deliveryCode = (String) generalMap.get("deliveryCode");
		deliveryName = (String) generalMap.get("name");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasDelivery masDelivery = (MasDelivery) getHibernateTemplate().load(
				MasDelivery.class, deliveryId);

		masDelivery.setId(deliveryId);
		masDelivery.setDeliveryName(deliveryName);
		Users users=new Users();
		users.setId(changedBy);
		masDelivery.setLastChgBy(users);
		masDelivery.setLastChgDate(currentDate);
		masDelivery.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDelivery);
		dataUpdated = true;
		return dataUpdated;

	}

	public Map<String, Object> searchDelivery(String deliveryCode,
			String deliveryName) {
		List<MasDelivery> searchDeliveryList = new ArrayList<MasDelivery>();
		Map<String, Object> deliveryFieldsMap = new HashMap<String, Object>();
		try {
			if ((deliveryName != null) || (deliveryCode == null)) {
				searchDeliveryList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasDelivery imc where imc.DeliveryName like '"
								+ deliveryName + "%' order by imc.DeliveryName");
			} else {
				searchDeliveryList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasDelivery imc where imc.DeliveryCode like '"
								+ deliveryCode + "%' order by imc.DeliveryCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		deliveryFieldsMap.put("searchDeliveryList", searchDeliveryList);
		return deliveryFieldsMap;
	}

	public Map<String, Object> showDeliveryJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDelivery> searchDeliveryList = new ArrayList<MasDelivery>();
		searchDeliveryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDelivery ");
		map.put("searchDeliveryList", searchDeliveryList);
		return map;
	}

	// -----------------------------Care Type--------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showCareTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasCareType> searchCareTypeList = new ArrayList<MasCareType>();
		searchCareTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCareType ");
		map.put("searchCareTypeList", searchCareTypeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchCareType(String careTypeCode,
			String careTypeName) {
		List<MasCareType> searchCareTypeList = new ArrayList<MasCareType>();
		Map<String, Object> careTypeFieldsMap = new HashMap<String, Object>();
		try {
			if ((careTypeName != null) || (careTypeCode == null)) {
				searchCareTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasCareType mcr where mcr.CareTypeName like '"
								+ careTypeName + "%' order by mcr.CareTypeName");
			} else {
				searchCareTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasCareType mcr where mcr.CareTypeCode like '"
								+ careTypeCode + "%' order by mcr.CareTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		careTypeFieldsMap.put("searchCareTypeList", searchCareTypeList);
		return careTypeFieldsMap;
	}

	public boolean addCareType(MasCareType masCareType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masCareType);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editCareTypeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String careTypeName = "";
		@SuppressWarnings("unused")
		String careTypeCode = "";
		int careTypeId = 0;
		int changedBy = 0;
		careTypeId = (Integer) generalMap.get("id");
		careTypeCode = (String) generalMap.get("careTypeCode");
		careTypeName = (String) generalMap.get("name");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasCareType masCareType = (MasCareType) getHibernateTemplate().get(
				MasCareType.class, careTypeId);

		masCareType.setId(careTypeId);
		masCareType.setCareTypeName(careTypeName);
		Users users=new Users();
		users.setId(changedBy);
		masCareType.setLastChgBy(users);
		masCareType.setLastChgDate(currentDate);
		masCareType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCareType);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteCareType(int careTypeId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		MasCareType masCareType = new MasCareType();
		masCareType = (MasCareType) getHibernateTemplate().get(
				MasCareType.class, careTypeId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masCareType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masCareType.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(changedBy);
		masCareType.setLastChgBy(users);
		masCareType.setLastChgDate(currentDate);
		masCareType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCareType);
		return dataDeleted;
	}

	// -----------------------------Disposed
	// To--------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDisposedToJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDisposedTo> searchDisposedToList = new ArrayList<MasDisposedTo>();
		searchDisposedToList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDisposedTo ");
		map.put("searchDisposedToList", searchDisposedToList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDisposedTo(String disposedToCode,
			String disposedToName) {
		List<MasDisposedTo> searchDisposedToList = new ArrayList<MasDisposedTo>();
		Map<String, Object> disposedToFieldsMap = new HashMap<String, Object>();
		try {
			if ((disposedToName != null) || (disposedToCode == null)) {
				searchDisposedToList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasDisposedTo mdt where mdt.DisposedToName like '"
								+ disposedToName
								+ "%' order by mdt.DisposedToName");
			} else {
				searchDisposedToList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasDisposedTo mdt where mdt.DisposedToCode like '"
								+ disposedToCode
								+ "%' order by mdt.DisposedToCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposedToFieldsMap.put("searchDisposedToList", searchDisposedToList);
		return disposedToFieldsMap;
	}

	public boolean addDisposedTo(MasDisposedTo masDisposedTo) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDisposedTo);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editDisposedToToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String disposedToName = "";
		@SuppressWarnings("unused")
		String disposedToCode = "";
		int disposedToId = 0;
		int changedBy = 0;
		disposedToId = (Integer) generalMap.get("id");
		disposedToCode = (String) generalMap.get("disposedToCode");
		disposedToName = (String) generalMap.get("name");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasDisposedTo masDisposedTo = (MasDisposedTo) getHibernateTemplate()
				.get(MasDisposedTo.class, disposedToId);

		masDisposedTo.setId(disposedToId);
		masDisposedTo.setDisposedToName(disposedToName);
		Users users = new Users();
		users.setId(changedBy);
		masDisposedTo.setLastChgBy(users);
		masDisposedTo.setLastChgDate(currentDate);
		masDisposedTo.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDisposedTo);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteDisposedTo(int disposedToId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		MasDisposedTo masDisposedTo = new MasDisposedTo();
		masDisposedTo = (MasDisposedTo) getHibernateTemplate().get(
				MasDisposedTo.class, disposedToId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDisposedTo.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDisposedTo.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(changedBy);
		masDisposedTo.setLastChgBy(users);
		masDisposedTo.setLastChgDate(currentDate);
		masDisposedTo.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDisposedTo);
		return dataDeleted;
	}

	// ----------------------------------------Body
	// Part------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBodyPartJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBodyPart> searchBodyPartList = new ArrayList<MasBodyPart>();
		searchBodyPartList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBodyPart");
		map.put("searchBodyPartList", searchBodyPartList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBodyPart(String bodyPartCode,
			String bodyPartName) {
		List<MasBodyPart> searchBodyPartList = new ArrayList<MasBodyPart>();
		Map<String, Object> bodyPartFieldsMap = new HashMap<String, Object>();
		try {
			if ((bodyPartName != null) || (bodyPartCode == null)) {
				searchBodyPartList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasBodyPart mbp where mbp.BodyPartName like '"
								+ bodyPartName + "%' order by mbp.BodyPartName");
			} else {
				searchBodyPartList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasBodyPart mbp where mbp.BodyPartCode like '"
								+ bodyPartCode + "%' order by mbp.BodyPartCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		bodyPartFieldsMap.put("searchBodyPartList", searchBodyPartList);
		return bodyPartFieldsMap;
	}

	public boolean addBodyPart(MasBodyPart masBodyPart) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masBodyPart);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editBodyPartToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String bodyPartName = "";
		@SuppressWarnings("unused")
		String bodyPartCode = "";
		int bodyPartId = 0;
		int changedBy = 0;
		bodyPartId = (Integer) generalMap.get("id");
		bodyPartCode = (String) generalMap.get("bodyPartCode");
		bodyPartName = (String) generalMap.get("name");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasBodyPart masBodyPart = (MasBodyPart) getHibernateTemplate().get(
				MasBodyPart.class, bodyPartId);

		masBodyPart.setId(bodyPartId);
		masBodyPart.setBodyPartName(bodyPartName);
		Users users=new Users();
		users.setId(changedBy);
		masBodyPart.setLastChgBy(users);
		masBodyPart.setLastChgDate(currentDate);
		masBodyPart.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBodyPart);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteBodyPart(int bodyPartId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		MasBodyPart masBodyPart = new MasBodyPart();
		masBodyPart = (MasBodyPart) getHibernateTemplate().get(
				MasBodyPart.class, bodyPartId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masBodyPart.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masBodyPart.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(changedBy);
		masBodyPart.setLastChgBy(users);
		masBodyPart.setLastChgDate(currentDate);
		masBodyPart.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBodyPart);
		return dataDeleted;
	}

	// ---------------------------------------Discharge
	// Status------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDischargeStatusJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDischargeStatus> searchDischargeStatusList = new ArrayList<MasDischargeStatus>();
		searchDischargeStatusList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDischargeStatus ");
		map.put("searchDischargeStatusList", searchDischargeStatusList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDischargeStatus(
			String dischargeStatusCode, String dischargeStatusName) {
		List<MasDischargeStatus> searchDischargeStatusList = new ArrayList<MasDischargeStatus>();
		Map<String, Object> dischargeStatusFieldsMap = new HashMap<String, Object>();
		try {
			if ((dischargeStatusName != null) || (dischargeStatusCode == null)) {
				searchDischargeStatusList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasDischargeStatus mr where lower(mr.DischargeStatusName) like '"
								+ dischargeStatusName.toLowerCase()
								+ "%' order by mr.DischargeStatusName");
			} else {
				searchDischargeStatusList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasDischargeStatus mr where lower(mr.DischargeStatusCode) like '"
								+ dischargeStatusCode.toLowerCase()
								+ "%' order by mr.DischargeStatusCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dischargeStatusFieldsMap.put("searchDischargeStatusList",
				searchDischargeStatusList);
		return dischargeStatusFieldsMap;
	}

	public boolean addDischargeStatus(MasDischargeStatus masDischargeStatus) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDischargeStatus);
		successfullyAdded = true;
		hbt.flush();
		hbt.clear();
		return successfullyAdded;
	}

	public boolean editDischargeStatusToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String dischargeStatusName = "";
		@SuppressWarnings("unused")
		String dischargeStatusCode = "";
		int dischargeStatusId = 0;
		String changedBy = "";
		dischargeStatusId = (Integer) generalMap.get("id");
		dischargeStatusCode = (String) generalMap.get("dischargeStatusCode");
		dischargeStatusName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId = (Integer) generalMap.get(RequestConstants.USER_ID);
		MasDischargeStatus masDischargeStatus = (MasDischargeStatus) getHibernateTemplate()
				.get(MasDischargeStatus.class, dischargeStatusId);

		masDischargeStatus.setId(dischargeStatusId);
		masDischargeStatus.setDischargeStatusName(dischargeStatusName);
		Users users=new Users();
		users.setId(userId);
		masDischargeStatus.setLastChgBy(users);
		masDischargeStatus.setLastChgDate(currentDate);
		masDischargeStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDischargeStatus);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteDischargeStatus(int dischargeStatusId,
			Map<String, Object> generalMap) {
		
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		
		int userId = (Integer) generalMap.get(RequestConstants.USER_ID);


		MasDischargeStatus masDischargeStatus = new MasDischargeStatus();
		masDischargeStatus = (MasDischargeStatus) getHibernateTemplate().get(
				MasDischargeStatus.class, dischargeStatusId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDischargeStatus.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDischargeStatus.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(userId);
		masDischargeStatus.setLastChgBy(users);
		masDischargeStatus.setLastChgDate(currentDate);
		masDischargeStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDischargeStatus);
		return dataDeleted;
	}

	// ------------------------------Discharge Items---------------------------

	public Map<String, Object> showDischargeItemsJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DischargeItems> searchDischargeItemsList = new ArrayList<DischargeItems>();
		searchDischargeItemsList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DischargeItems ");
		map.put("searchDischargeItemsList", searchDischargeItemsList);
		return map;
	}

	public Map<String, Object> searchDischargeItems(String itemCode,
			String itemDescription) {
		List<DischargeItems> searchDischargeItemsList = new ArrayList<DischargeItems>();
		Map<String, Object> dischargeItemsFieldsMap = new HashMap<String, Object>();
		try {
			if ((itemDescription != null) || (itemCode == null)) {
				searchDischargeItemsList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.DischargeItems sc where lower(sc.ItemDesc) like '"
								+ itemDescription.toLowerCase() + "%' order by sc.ItemDesc");
			} else {
				searchDischargeItemsList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.DischargeItems sc where lower(sc.ItemCode) like '"
								+ itemCode.toLowerCase() + "%' order by sc.ItemCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dischargeItemsFieldsMap.put("searchDischargeItemsList",
				searchDischargeItemsList);
		return dischargeItemsFieldsMap;
	}

	public boolean editDischargeItemsToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String itemName = "";
		@SuppressWarnings("unused")
		String itemCode = "";
		int itemId = 0;
		String changedBy = "";
		itemId = (Integer) generalMap.get("id");
		itemCode = (String) generalMap.get("itemCode");
		itemName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId = (Integer) generalMap.get(RequestConstants.USER_ID);

		DischargeItems dischargeItems = (DischargeItems) getHibernateTemplate()
				.get(DischargeItems.class, itemId);

		dischargeItems.setId(itemId);
		dischargeItems.setItemDesc(itemName);
		Users users=new Users();
		users.setId(userId);
		dischargeItems.setLastChgBy(users);
		dischargeItems.setLastChgDate(currentDate);
		dischargeItems.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(dischargeItems);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean addDischargeItems(DischargeItems dischargeItems) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(dischargeItems);
		successfullyAdded = true;
		hbt.flush();
		hbt.clear();
		return successfullyAdded;
	}

	public boolean deleteDischargeItems(int dischargeItemsId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		int userId = (Integer) generalMap.get(RequestConstants.USER_ID);

		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		DischargeItems dischargeItems = new DischargeItems();
		dischargeItems = (DischargeItems) getHibernateTemplate().get(
				DischargeItems.class, dischargeItemsId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				dischargeItems.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				dischargeItems.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(userId);
		dischargeItems.setLastChgBy(users);
		dischargeItems.setLastChgDate(currentDate);
		dischargeItems.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(dischargeItems);
		hbt.flush();
		hbt.clear();
		return dataDeleted;
	}

	// ------------------------------Discharge Items
	// Category---------------------------
	public Map<String, Object> showDischargeCategoryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DischargeItemsCategory> searchDischargeItemsCategoryList = new ArrayList<DischargeItemsCategory>();
		List<DischargeItems> dischargeItemsList = new ArrayList<DischargeItems>();
		searchDischargeItemsCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DischargeItemsCategory ");
		dischargeItemsList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DischargeItems ");
		map.put("searchDischargeItemsCategoryList",
				searchDischargeItemsCategoryList);
		map.put("dischargeItemsList", dischargeItemsList);
		return map;
	}

	public boolean addDischargeItemsCategory(
			DischargeItemsCategory dischargeItemsCategory) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(dischargeItemsCategory);
		hbt.flush();
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteDischargeItemsCategory(int dischargeCateogryId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		int userId=(Integer)generalMap.get(RequestConstants.USER_ID);
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		DischargeItemsCategory dischargeItemsCategory= new DischargeItemsCategory();
		dischargeItemsCategory = (DischargeItemsCategory) getHibernateTemplate().get(DischargeItemsCategory.class, dischargeCateogryId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				dischargeItemsCategory.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				dischargeItemsCategory.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(userId);
		dischargeItemsCategory.setLastChgBy(users);
		dischargeItemsCategory.setLastChgDate(currentDate);
		dischargeItemsCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(dischargeItemsCategory);
		return dataDeleted;
	}

	public boolean editDischargeItemsCategory(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		String bedNumber = "";
		int itemCode = 0;
		int dischargeCateogryId = 0;
		Integer orderNo = 0;
		String dischargeCategory = null;
		String description = null;
		String labelDataType = null;
		String changedBy = "";
		String currentTime = "";
		int userId=(Integer)generalMap.get(RequestConstants.USER_ID);
		Date changedDate = new Date();
		dischargeCateogryId = (Integer) generalMap.get("id");
		itemCode = (Integer) generalMap.get("itemCode");
		orderNo = (Integer) generalMap.get("orderNo");
		dischargeCategory = (String) generalMap.get("dischargeCategory");
		description = (String) generalMap.get("description");
		labelDataType = (String) generalMap.get("labelDataType");
		changedBy = (String) generalMap.get("changedBy");
		changedDate = (Date) generalMap.get("changedDate");
		currentTime = (String) generalMap.get("currentTime");

		DischargeItemsCategory dischargeItemsCategory = (DischargeItemsCategory) getHibernateTemplate()
				.get(DischargeItemsCategory.class, dischargeCateogryId);

		dischargeItemsCategory.setId(dischargeCateogryId);
		dischargeItemsCategory.setOrderno(orderNo);
		dischargeItemsCategory.setCategoryName(dischargeCategory);
		dischargeItemsCategory.setLabel(description);
		dischargeItemsCategory.setLabelDataType(labelDataType);

		DischargeItems dischargeItems = new DischargeItems();
		dischargeItems.setId(itemCode);
		dischargeItemsCategory.setItemCode(dischargeItems);

		dischargeItemsCategory.setStatus("y");
		Users users=new Users();
		users.setId(userId);
		dischargeItemsCategory.setLastChgBy(users);
		dischargeItemsCategory.setLastChgDate(changedDate);
		dischargeItemsCategory.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(dischargeItemsCategory);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public Map<String, Object> searchDischargeItemsCategory(String dischargeItem) {
		List<DischargeItemsCategory> searchDischargeItemsCategoryList = new ArrayList<DischargeItemsCategory>();
		List<DischargeItems> dischargeItemsList = new ArrayList<DischargeItems>();
		Map<String, Object> dischargeItemsCategoryFieldsMap = new HashMap<String, Object>();

		try {
			if (dischargeItem != "") {
				searchDischargeItemsCategoryList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.DischargeItemsCategory as i where i.Label like '"
										+ dischargeItem
										+ "%' order by i.Label ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		dischargeItemsList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.DischargeItems as mc where mc.Status = 'y'");

		dischargeItemsCategoryFieldsMap.put("searchDischargeItemsCategoryList",searchDischargeItemsCategoryList);
		dischargeItemsCategoryFieldsMap.put("dischargeItemsList",
				dischargeItemsList);

		return dischargeItemsCategoryFieldsMap;
	}


	public boolean editNeonatalProblem(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String neonatalProblemName = "";
		@SuppressWarnings("unused")
		String neonatalProblemCode = "";
		int neonatalProblemId = 0;
		int changedBy = 0;

		neonatalProblemId = (Integer) generalMap.get("neonatalProblemId");
		neonatalProblemCode = (String) generalMap.get("neonatalProblemCode");
		neonatalProblemName = (String) generalMap.get("neonatalProblemName");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		MasNeonatalProblem masNeonatalProblem = (MasNeonatalProblem) getHibernateTemplate()
				.load(MasNeonatalProblem.class, neonatalProblemId);
		// masNeonatalProblem.setId(neonatalProblemId);
		masNeonatalProblem.setNeonatalProblemCode(neonatalProblemCode);
		masNeonatalProblem.setNeonatalProblemName(neonatalProblemName);
		Users users=new Users();
		users.setId(changedBy);
		masNeonatalProblem.setLastChgBy(users);
		masNeonatalProblem.setLastChgDate(currentDate);
		masNeonatalProblem.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masNeonatalProblem);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchNeonatalProblem(
			String neonatalProblemCode, String neonatalProblemName) {
		List<MasNeonatalProblem> neonatalProblemList = new ArrayList<MasNeonatalProblem>();
		Map neonatalProblemFieldsMap = new HashMap();

		try {
			if ((neonatalProblemName != null) || (neonatalProblemCode == null)) {
				neonatalProblemList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasNeonatalProblem mbs where mbs.NeonatalProblemName like '"
								+ neonatalProblemName
								+ "%' order by mbs.NeonatalProblemName");
			} else {
				neonatalProblemList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasNeonatalProblem mbs where mbs.NeonatalProblemCode like '"
								+ neonatalProblemCode
								+ "%' order by mbs.NeonatalProblemCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		neonatalProblemFieldsMap
				.put("neonatalProblemList", neonatalProblemList);
		return neonatalProblemFieldsMap;
	}

	public Map<String, Object> showNeonatalProblemJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasNeonatalProblem> neonatalProblemList = new ArrayList<MasNeonatalProblem>();
		try {
			// neonatalProblemList =(List<MasNeonatalProblem>)
			// getHibernateTemplate().find( "from
			// jkt.hms.masters.business.MasNeonatalProblem ");
			neonatalProblemList = getSession().createCriteria(
					MasNeonatalProblem.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("neonatalProblemList", neonatalProblemList);
		return map;
	}

	public boolean addNeonatalProblem(MasNeonatalProblem masNeonatalProblem) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masNeonatalProblem);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteNeonatalProblem(int neonatalProblemId,
			Map<String, Object> generalMap) {
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		boolean dataDeleted = false;
		MasNeonatalProblem masNeonatalProblem = new MasNeonatalProblem();
		masNeonatalProblem = (MasNeonatalProblem) getHibernateTemplate().load(
				MasNeonatalProblem.class, neonatalProblemId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masNeonatalProblem.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masNeonatalProblem.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(changedBy);
		masNeonatalProblem.setLastChgBy(users);
		masNeonatalProblem.setLastChgDate(currentDate);
		masNeonatalProblem.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masNeonatalProblem);
		return dataDeleted;
	}

	public boolean editOutsideTreatment(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String outsideTreatmentName = "";
		@SuppressWarnings("unused")
		String outsideTreatmentCode = "";
		int outsideTreatmentId = 0;
		int changedBy = 0;

		outsideTreatmentId = (Integer) generalMap.get("id");
		outsideTreatmentCode = (String) generalMap.get("outsideTreatmentCode");
		outsideTreatmentName = (String) generalMap.get("name");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		MasOutsideTreatment masOutsideTreatment = (MasOutsideTreatment) getHibernateTemplate()
				.load(MasOutsideTreatment.class, outsideTreatmentId);
		masOutsideTreatment.setId(outsideTreatmentId);
		masOutsideTreatment.setOutsideTreatmentName(outsideTreatmentName);
		Users users=new Users();
		users.setId(changedBy);
		masOutsideTreatment.setLastChgBy(users);
		masOutsideTreatment.setLastChgDate(currentDate);
		masOutsideTreatment.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masOutsideTreatment);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchOutsideTreatment(
			String outsideTreatmentCode, String outsideTreatmentName) {
		List<MasOutsideTreatment> searchOutsideTreatmentList = new ArrayList<MasOutsideTreatment>();
		Map outsideTreatmentFieldsMap = new HashMap();
		try {
			if ((outsideTreatmentName != null)
					|| (outsideTreatmentCode == null)) {
				searchOutsideTreatmentList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasOutsideTreatment mbs where mbs.OutsideTreatmentName like '"
								+ outsideTreatmentName
								+ "%' order by mbs.OutsideTreatmentName");
			} else {
				searchOutsideTreatmentList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasOutsideTreatment mbs where mbs.OutsideTreatmentCode like '"
								+ outsideTreatmentCode
								+ "%' order by mbs.OutsideTreatmentCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		outsideTreatmentFieldsMap.put("searchOutsideTreatmentList",
				searchOutsideTreatmentList);
		return outsideTreatmentFieldsMap;
	}

	public Map<String, Object> showOutsideTreatmentJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasOutsideTreatment> searchOutsideTreatmentList = new ArrayList<MasOutsideTreatment>();
		try {
			searchOutsideTreatmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasOutsideTreatment ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchOutsideTreatmentList", searchOutsideTreatmentList);
		return map;
	}

	public boolean addOutsideTreatment(MasOutsideTreatment masOutsideTreatement) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masOutsideTreatement);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteOutsideTreatment(int outsideTreatmentId,
			Map<String, Object> generalMap) {
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		boolean dataDeleted = false;
		MasOutsideTreatment masOutsideTreatment = new MasOutsideTreatment();
		masOutsideTreatment = (MasOutsideTreatment) getHibernateTemplate()
				.load(MasOutsideTreatment.class, outsideTreatmentId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masOutsideTreatment.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masOutsideTreatment.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(changedBy);
		masOutsideTreatment.setLastChgBy(users);
		masOutsideTreatment.setLastChgDate(currentDate);
		masOutsideTreatment.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masOutsideTreatment);
		return dataDeleted;
	}

	public boolean editPerineumMaintenance(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String perineumMaintenanceName = "";
		@SuppressWarnings("unused")
		String perineumMaintenanceCode = "";
		int perineumMaintenanceId = 0;
		int changedBy = 0;
		perineumMaintenanceId = (Integer) generalMap
				.get("perineumMaintenanceId");
		perineumMaintenanceCode = (String) generalMap
				.get("perineumMaintenanceCode");
		perineumMaintenanceName = (String) generalMap
				.get("perineumMaintenanceName");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		MasPerineumMaintenance masPerineumMaintenance = (MasPerineumMaintenance) hbt
				.load(MasPerineumMaintenance.class, perineumMaintenanceId);
		// masPerineumMaintenance.setId(perineumMaintenanceId);
		masPerineumMaintenance
				.setPerineumMaintenanceCode(perineumMaintenanceCode);
		masPerineumMaintenance
				.setPerineumMaintenanceName(perineumMaintenanceName);
		Users users=new Users();
		users.setId(changedBy);
		masPerineumMaintenance.setLastChgBy(users);
		masPerineumMaintenance.setLastChgDate(currentDate);
		masPerineumMaintenance.setLastChgTime(currentTime);

		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masPerineumMaintenance);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchPerineumMaintenance(
			String perineumMaintenanceCode, String perineumMaintenanceName) {
		List<MasPerineumMaintenance> perineumMaintenanceList = new ArrayList<MasPerineumMaintenance>();
		Map perineumMaintenanceFieldsMap = new HashMap();
		try {
			if ((perineumMaintenanceName != null)
					|| (perineumMaintenanceCode == null)) {
				perineumMaintenanceList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasPerineumMaintenance mbs where mbs.PerineumMaintenanceName like '"
								+ perineumMaintenanceName
								+ "%' order by mbs.PerineumMaintenanceName");
			} else {
				perineumMaintenanceList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasPerineumMaintenance mbs where mbs.PerineumMaintenanceCode like '"
								+ perineumMaintenanceCode
								+ "%' order by mbs.PerineumMaintenanceCode");
				// perineumMaintenanceList=
				// getSession().createCriteria(MasPerineumMaintenance.class).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		perineumMaintenanceFieldsMap.put("perineumMaintenanceList",
				perineumMaintenanceList);
		return perineumMaintenanceFieldsMap;
	}

	public Map<String, Object> showPerineumMaintenanceJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPerineumMaintenance> perineumMaintenanceList = new ArrayList<MasPerineumMaintenance>();
		try {
			// neonatalProblemList =(List<MasNeonatalProblem>)
			// getHibernateTemplate().find( "from
			// jkt.hms.masters.business.MasNeonatalProblem ");
			perineumMaintenanceList = getSession().createCriteria(
					MasPerineumMaintenance.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("perineumMaintenanceList", perineumMaintenanceList);
		return map;
	}

	public boolean addPerineumMaintenance(
			MasPerineumMaintenance masPerineumMaintenance) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masPerineumMaintenance);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deletePerineumMaintenance(int perineumMaintenanceId,
			Map<String, Object> generalMap) {
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		boolean dataDeleted = false;
		MasPerineumMaintenance masPerineumMaintenance = new MasPerineumMaintenance();
		masPerineumMaintenance = (MasPerineumMaintenance) getHibernateTemplate()
				.load(MasPerineumMaintenance.class, perineumMaintenanceId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masPerineumMaintenance.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masPerineumMaintenance.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(changedBy);
		masPerineumMaintenance.setLastChgBy(users);
		masPerineumMaintenance.setLastChgDate(currentDate);
		masPerineumMaintenance.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masPerineumMaintenance);
		return dataDeleted;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getKitTemplateList(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<IpdKitIssueMasterTemplateM> kitIssueList = new ArrayList<IpdKitIssueMasterTemplateM>();
		Session session = (Session) getSession();
		kitIssueList = session.createCriteria(IpdKitIssueMasterTemplateM.class).createAlias("Hospital", "h")
				.add(Restrictions.eq("h.Id", hospitalId)).list();
		map.put("kitIssueList", kitIssueList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getItemListForAutoComplete(Map<String, Object> map) {
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String itemCategoryCodeLaundry = properties.getProperty("itemCategoryCodeLaundry");
		
		try {
			String str =  map.get("autoHint") + "%";
       /*			String query = "select mst from MasStoreItem as mst join mst.ItemCategory as mic where upper(mst.Nomenclature) like upper('"
					+ str + "') and mic.ItemCategoryCode = '"+itemCategoryCodeLaundry+"'";
			
			Query q = session.createQuery(query);
			itemList = q.list();*/
			itemList=session.createCriteria(MasStoreItem.class)
					.createAlias("ItemCategory", "ic")
					.add(Restrictions.like("Nomenclature","%"+str.toLowerCase()+"%").ignoreCase())
					.add(Restrictions.eq("ic.ItemCategoryCode", itemCategoryCodeLaundry.toLowerCase()).ignoreCase()).list();
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		datamap.put("itemList", itemList);
		return datamap;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getItemListForKitIssueAutoComplete(Map<String, Object> map) {
		List<StoreBalanceT> itemList = new ArrayList<StoreBalanceT>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String itemCategoryCodeName =(String)properties.getProperty("itemCategoryCodeName");
		int deptId=0;
		try {
			deptId=(Integer) map.get("deptId");
			String str =  map.get("autoHint") + "%";
       /*			String query = "select mst from MasStoreItem as mst join mst.ItemCategory as mic where upper(mst.Nomenclature) like upper('"
					+ str + "') and mic.ItemCategoryCode = '"+itemCategoryCodeLaundry+"'";
			
			Query q = session.createQuery(query);
			itemList = q.list();*/
			itemList=session.createCriteria(StoreBalanceT.class)
					.createAlias("StoreBalanceM", "sbm")
					.createAlias("sbm.Department", "dept")
					.createAlias("Item", "itm")
					.createAlias("itm.Section", "sec")
					.add(Restrictions.like("itm.Nomenclature",str.toLowerCase()+"%").ignoreCase())
					.add(Restrictions.eq("dept.Id",deptId))
					.add(Restrictions.like("sec.SectionName",itemCategoryCodeName.toUpperCase()).ignoreCase())
					.add(Restrictions.eq("sbm.Status", "A".toLowerCase()).ignoreCase()).list();
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("list size is......."+itemList.size());
		for(StoreBalanceT sbt:itemList){
			System.out.println("Nomencalture Name......"+sbt.getItem().getNomenclature());
			System.out.println("PvmsNo Number......"+sbt.getItem().getPvmsNo());
		}
		datamap.put("itemList", itemList);
		return datamap;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> submitKitIssueMasterDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		List<IpdKitIssueMasterTemplateM> existingTemplateList = new ArrayList<IpdKitIssueMasterTemplateM>();
		Session session = (Session)getSession();
		existingTemplateList = session.createCriteria(IpdKitIssueMasterTemplateM.class)
				.add(Restrictions.eq("TemplateName",box.getString("templateName").toLowerCase() ).ignoreCase()).list();
		Transaction tx = null;
		try {
			if(existingTemplateList.size() == 0) {
				Map<String, Object> datemap=HMSUtil.getCurrentDateAndTime();
				tx = session.beginTransaction();
				IpdKitIssueMasterTemplateM kitIssueMasterTemplateM = new IpdKitIssueMasterTemplateM();
				kitIssueMasterTemplateM.setTemplateName(box.getString("templateName"));
				kitIssueMasterTemplateM.setStatus("y");
				MasHospital hospital = new MasHospital();
				hospital.setId(box.getInt("hospitalId"));
				kitIssueMasterTemplateM.setHospital(hospital);
				Users user = new Users();
				user.setId(box.getInt("userId"));
				kitIssueMasterTemplateM.setLastChgBy(user);
				kitIssueMasterTemplateM.setLastChgDate(HMSUtil.convertStringTypeDateToDateType((String)datemap.get("currentDate")));
				kitIssueMasterTemplateM.setLastChgTime((String)datemap.get("currentTime"));
				hbt.save(kitIssueMasterTemplateM);
				
				int counter = box.getInt("hdb");
				if(counter >0) {
					for (int i = 1; i <= counter; i++) {
						if(box.getString("nomenclature"+i)!=null && !box.getString("nomenclature"+i).equals("")) {
							IpdKitIssueMasterTemplateT kitIssueMasterTemplateT = new IpdKitIssueMasterTemplateT();
							MasStoreItem item=new MasStoreItem();
							item.setId(box.getInt("itemId"+i));
							kitIssueMasterTemplateT.setItem(item);
							kitIssueMasterTemplateT.setAuthQuantity(box.getInt("authQuantity"+i));
							kitIssueMasterTemplateT.setItemName(box.getString("nomenclature"+i));
							kitIssueMasterTemplateT.setTemplate(kitIssueMasterTemplateM);
							kitIssueMasterTemplateT.setStatus("y");
							hbt.save(kitIssueMasterTemplateT);
						}
					} 
					
				}
				map.put("message", "Record saved successfully.");
				tx.commit();
			}else {
				map.put("message", "Template Name already exists.");
			}
		} catch (DataAccessException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			map.put("message", "Some Error Occured.Try Again.");
		}
		return map;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showKitIssueTemplateDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<IpdKitIssueMasterTemplateT> kitIssueDetailsList = new ArrayList<IpdKitIssueMasterTemplateT>();
		Session session = (Session) getSession();
		kitIssueDetailsList = session.createCriteria(IpdKitIssueMasterTemplateT.class).createAlias("Template", "t").add(Restrictions.eq("t.Id", box.getInt("kitIssueMasterId"))).list();
		map.put("kitIssueDetailsList", kitIssueDetailsList);
		return map;
	}

	@Override
	public Map<String, Object> updateKitIssueMasterDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		List<IpdKitIssueMasterTemplateM> existingTemplateList = new ArrayList<IpdKitIssueMasterTemplateM>();
		Session session = (Session)getSession();
		existingTemplateList = session.createCriteria(IpdKitIssueMasterTemplateM.class).add(Restrictions.eq("TemplateName",box.getString("templateName") )).list();
		Transaction tx = null;
		String deleteKitId = box.getString("deleteKitId");
		
		try {
			tx = session.beginTransaction();
			if(existingTemplateList.size() == 0) {
				IpdKitIssueMasterTemplateM kitIssueMasterTemplateM = new IpdKitIssueMasterTemplateM();
				kitIssueMasterTemplateM.setTemplateName(box.getString("templateName"));
				kitIssueMasterTemplateM.setStatus("y");
				MasHospital hospital = new MasHospital();
				hospital.setId(box.getInt("hospitalId"));
				kitIssueMasterTemplateM.setHospital(hospital);
				Users user = new Users();
				user.setId(box.getInt("userId"));
				kitIssueMasterTemplateM.setLastChgBy(user);
				kitIssueMasterTemplateM.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(RequestConstants.CHANGED_DATE)));
				kitIssueMasterTemplateM.setLastChgTime(box.getString(RequestConstants.CHANGED_TIME));
				hbt.save(kitIssueMasterTemplateM);
				
				int counter = box.getInt("hdb");
				if(counter >0) {
					for (int i = 1; i <= counter; i++) {
						if(!box.getString("nomenclature"+i).equals("")) {
							IpdKitIssueMasterTemplateT kitIssueMasterTemplateT = new IpdKitIssueMasterTemplateT();
							kitIssueMasterTemplateT.setAuthQuantity(box.getInt("authQuantity"+i));
							kitIssueMasterTemplateT.setItemName(box.getString("nomenclature"+i));
							kitIssueMasterTemplateT.setTemplate(kitIssueMasterTemplateM);
							kitIssueMasterTemplateT.setStatus("y");
							hbt.save(kitIssueMasterTemplateT);
						}
					} 
					
				}
				
			
			}else {
				int counter = box.getInt("hdb");
				if(counter >0) {
					for (int i = 1; i <= counter; i++) {
						int kitIssueDetailsId = box.getInt("kitIssueDetailsId"+i);
						
						if(kitIssueDetailsId==0 && !box.getString("nomenclature"+i).equals("")) {
							IpdKitIssueMasterTemplateT kitIssueMasterTemplateT = new IpdKitIssueMasterTemplateT();
							kitIssueMasterTemplateT.setAuthQuantity(box.getInt("authQuantity"+i));
							kitIssueMasterTemplateT.setItemName(box.getString("nomenclature"+i));
							IpdKitIssueMasterTemplateM kitIssueMasterTemplateM = new IpdKitIssueMasterTemplateM();
							kitIssueMasterTemplateM.setId(box.getInt("kitIssueMasterId"));
							kitIssueMasterTemplateT.setTemplate(kitIssueMasterTemplateM);
							kitIssueMasterTemplateT.setStatus("y");
							hbt.save(kitIssueMasterTemplateT);
						}else if(kitIssueDetailsId!=0 && !box.getString("nomenclature"+i).equals("")) {
							IpdKitIssueMasterTemplateT kitIssueMasterTemplateT = (IpdKitIssueMasterTemplateT) hbt.load(IpdKitIssueMasterTemplateT.class, kitIssueDetailsId);
							kitIssueMasterTemplateT.setAuthQuantity(box.getInt("authQuantity"+i));
							kitIssueMasterTemplateT.setItemName(box.getString("nomenclature"+i));
							hbt.update(kitIssueMasterTemplateT);
						}
					} 
					
				}
				
				if(!deleteKitId.equals("")) {
					String arr[]=deleteKitId.split(",");
					for(int i=0;i<arr.length;i++) {
						if(!arr[i].equals("") && Integer.parseInt(arr[i].toString())!=0) {
							IpdKitIssueMasterTemplateT kitIssueMasterTemplateT = (IpdKitIssueMasterTemplateT) hbt.load(IpdKitIssueMasterTemplateT.class, Integer.parseInt(arr[i].toString()));
							kitIssueMasterTemplateT.setStatus("n");
							hbt.update(kitIssueMasterTemplateT);
						}
					}
					
				}
				
			}
			map.put("message", "Record saved successfully.");
			tx.commit();
		} catch (DataAccessException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			map.put("message", "Some Error Occured.Try Again.");
		}
		return map;
	}

	@Override
	public Map<String, Object> deleteKitIssueTemplate(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean flag = false;
		try {
			IpdKitIssueMasterTemplateM kitIssueMasterTemplateM = (IpdKitIssueMasterTemplateM)hbt.load(IpdKitIssueMasterTemplateM.class, box.getInt("kitIssueMasterId"));
			if(box.getString("flag").equals("inactive")) {
				kitIssueMasterTemplateM.setStatus("n");
			}else {
				kitIssueMasterTemplateM.setStatus("y");
			}
			hbt.update(kitIssueMasterTemplateM);
			flag=true;
			map.put("message", "Record saved successfully.");
		} catch (DataAccessException e) {
			map.put("message", "Some Error Occured.Try Again.");
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}

	@Override
	public Map<String, Object> getPatientDetailsForKitIssue(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		/*Session session = (Session) getSession();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<IpdKitIssueMasterTemplateM> templateList = new ArrayList<IpdKitIssueMasterTemplateM>();
		List<IpdIpdKitIssueHeader> ipdKitIssueList = new ArrayList<IpdKitIssueHeader>();
		inpatientList =  session.createCriteria(Inpatient.class).add(Restrictions.idEq(box.getInt("inpatientId"))).list();
		templateList = session.createCriteria(KitIssueMasterTemplateM.class).add(Restrictions.eq("Status", "y")).list();
		ipdKitIssueList = session.createCriteria(IpdKitIssueHeader.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.Id", box.getInt("parent"))).list();
		map.put("inpatientList", inpatientList);
		map.put("templateList", templateList);
		map.put("ipdKitIssueList", ipdKitIssueList);*/
		return map;
	}

	@Override
	public Map showHouseKeeping() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHouseKeeping> masHouseKeepingList = new ArrayList<MasHouseKeeping>();
		masHouseKeepingList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasHouseKeeping as sc order by sc.HouseKeepingName");
		
		map.put("masHouseKeepingList", masHouseKeepingList);
		
		return map;
	}

	@Override
	public boolean addHouseKeeping(MasHouseKeeping masHouseKeeping) {
		boolean saveFlag = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masHouseKeeping);
			saveFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlag;
	}

	@Override
	public boolean editHouseKeeping(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int houseKeepingId = 0;
		String houseKeepingName = "";
		String houseKeepingCode = "";
	

		try {
			houseKeepingId = (Integer) generalMap.get("id");
			houseKeepingCode = (String) generalMap.get("houseKeepingCode");
			houseKeepingName = (String) generalMap.get("name");
			
			
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			int userId=0; 
			userId = (Integer) generalMap.get("userId");
		
			MasHouseKeeping masHouseKeeping = (MasHouseKeeping) getHibernateTemplate().load(
					MasHouseKeeping.class, houseKeepingId);

			masHouseKeeping.setId(houseKeepingId);
			masHouseKeeping.setHouseKeepingName(houseKeepingName);

			Users users=new Users();
			users.setId(userId);
			masHouseKeeping.setLastChgBy(users);
			
	
			masHouseKeeping.setLastChgDate(currentDate);
			masHouseKeeping.setLastChgTime(currentTime);

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masHouseKeeping);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@Override
	public Map<String, Object> searchHouseKeeping(String houseKeepingCode,
			String houseKeepingName) {
		List masHouseKeepingList = new ArrayList();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if ((houseKeepingName != null) || (houseKeepingCode == null)) {
				masHouseKeepingList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasHouseKeeping sc where sc.HouseKeepingName like '"
								+ houseKeepingName + "%' order by sc.HouseKeepingName");
			} else if (houseKeepingCode != null) {
				masHouseKeepingList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasHouseKeeping sc where sc.HouseKeepingCode like '"
								+ houseKeepingCode + "%' order by sc.HouseKeepingCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("masHouseKeepingList", masHouseKeepingList);

		return map;
	}

	@Override
	public boolean deleteHouseKeeping(int houseKeepingId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasHouseKeeping masHouseKeeping = new MasHouseKeeping();
		masHouseKeeping = (MasHouseKeeping) getHibernateTemplate().load(MasHouseKeeping.class,
				houseKeepingId);
		int userId=0; 
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		//Integer postcodeId = masHouseKeeping.getPostCode().getId();

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			/*List houseKeepingList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasHouseKeeping as mit where mit.Id='"
							+ houseKeepingId + "' and mit.Status='Y'");
			*/if (flag.equals("InActivate")) {
				masHouseKeeping.setStatus("N");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masHouseKeeping.setStatus("Y");
				dataDeleted = false;
			}
		}
		
		Users users=new Users();
		users.setId(userId);
		masHouseKeeping.setLastChgBy(users);
		

		masHouseKeeping.setLastChgDate(currentDate);
		masHouseKeeping.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masHouseKeeping);
		return dataDeleted;
	}
	
	@Override
	public boolean addHouseKeepingFrequency(MasHouseKeepingFrequency masHouseKeepingFrequency) {
		boolean saveFlag = false;
		
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masHouseKeepingFrequency);
			saveFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlag;
	}

	@Override
	public Map<String, Object> showHouseKeepingFrequencyJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHouseKeepingFrequency> searchFrequencyList = new ArrayList<MasHouseKeepingFrequency>();
		try{
			searchFrequencyList = getHibernateTemplate().find("from jkt.hms.masters.business.MasHouseKeepingFrequency");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		map.put("searchFrequencyList", searchFrequencyList);
		return map;
	}

	@Override
	public Map<String, Object> searchHouseKeepingFrequency(String frequencyCode,
			String frequencyName) {
		List<MasHouseKeepingFrequency> searchFrequencyList = new ArrayList<MasHouseKeepingFrequency>();
		Map<String, Object> frequencyFieldsMap = new HashMap<String, Object>();
		try {
			if ((frequencyName != null) || (frequencyCode == null)) {
				searchFrequencyList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasHouseKeepingFrequency as dis where dis.FrequencyName like '"
								+ frequencyName + "%' order by dis.FrequencyName");
			} else {
				searchFrequencyList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasHouseKeepingFrequency as dis where dis.FrequencyCode like '"
								+ frequencyCode + "%' order by dis.FrequencyCode");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		frequencyFieldsMap.put("searchFrequencyList", searchFrequencyList);
		
		return frequencyFieldsMap;
	}

	@Override
	public boolean editHouseKeepingFrequency(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String frequencyName = "";
		String frequencyCode = "";
		int frequencyCount=0;
		int frequencyId = 0;
		frequencyId = (Integer) generalMap.get("id");
		frequencyCount = (Integer) generalMap.get("frequencyCount");
		frequencyCode = (String) generalMap.get("frequencyCode");
		frequencyName = (String) generalMap.get("name");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=0; 
		userId = (Integer) generalMap.get("userId");
		MasHouseKeepingFrequency masHouseKeepingFrequency = (MasHouseKeepingFrequency) getHibernateTemplate().get(
				MasHouseKeepingFrequency.class, frequencyId);

		masHouseKeepingFrequency.setId(frequencyId);
		masHouseKeepingFrequency.setFrequencyName(frequencyName);
		masHouseKeepingFrequency.setFrequencyCount(frequencyCount);
	

		masHouseKeepingFrequency.setLastChgDate(currentDate);
		masHouseKeepingFrequency.setLastChgTime(currentTime);
		
		
		Users users = new Users();
		users.setId(userId);
		masHouseKeepingFrequency.setLastChgBy(users);
		
		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masHouseKeepingFrequency);
			dataUpdated = true;
		}
		catch (DataAccessException e)
		{
			dataUpdated = false;
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@Override
	public boolean deleteHouseKeepingFrequency(int frequencyId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasHouseKeepingFrequency masHouseKeepingFrequency = new MasHouseKeepingFrequency();
		masHouseKeepingFrequency = (MasHouseKeepingFrequency) getHibernateTemplate().get(
				MasHouseKeepingFrequency.class, frequencyId);
		
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=0; 
		userId = (Integer) generalMap.get("userId");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masHouseKeepingFrequency.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masHouseKeepingFrequency.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(userId);
		masHouseKeepingFrequency.setLastChgBy(users);
		masHouseKeepingFrequency.setLastChgDate(currentDate);
		masHouseKeepingFrequency.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masHouseKeepingFrequency);
		return dataDeleted;
	}

	@Override
	public Map<String, Object> showUnitWiseTableJsp(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		Session session=(Session)getSession();
		try {
			departmentList = getHibernateTemplate()
					.find("select md from jkt.hms.masters.business.MasDepartment md left join md.DepartmentType as dt where lower(md.Status) = 'y' and upper(dt.DepartmentTypeCode) ='OPR'");
		
			wardList=session.createCriteria(MasInstituteDepartment.class)
					.add(Restrictions.eq("Status","y").ignoreCase())
					.add(Restrictions.eq("Institute.Id",hospitalId))
					.createAlias("Department", "dept")
					.createAlias("dept.DepartmentType","DepartmentType")
					.add(Restrictions.eq("DepartmentType.DepartmentTypeCode","WARD"))
					.addOrder(Order.asc("dept.DepartmentName"))
					.list();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("departmentList", departmentList);
		map.put("wardList",wardList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getTableList(int departmentId,int hospitalId) {
		Map<String,Object>map=new HashMap<String,Object>();
		List<MasBed>bedList=new ArrayList<MasBed>();
		List<HospitalDoctorUnitM>hospitalDoctorUnitMList=new ArrayList<HospitalDoctorUnitM>();
		Session session=(Session)getSession();
		System.out.println("departmentId==="+departmentId);
		
		bedList=session.createCriteria(MasBed.class).add(Restrictions.eq("Department.Id",departmentId)).add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("BedType", "p").ignoreCase()).list();
		
		List<Integer> deptList = new ArrayList<Integer>();
		
		deptList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Id", departmentId)).setProjection(Projections.property("EmpDept.Id")).list();
		System.out.println("deptList==="+deptList.size());
		System.out.println("deptList==="+deptList.get(0));
		if(deptList.size() > 0)
			hospitalDoctorUnitMList=session.createCriteria(HospitalDoctorUnitM.class).add(Restrictions.eq("Status","y").ignoreCase())
			.add(Restrictions.eq("Hospital.Id", hospitalId))
			.add(Restrictions.eq("EmpDept.Id", deptList.get(0))).list();
		else{
			hospitalDoctorUnitMList=session.createCriteria(HospitalDoctorUnitM.class)
										   .add(Restrictions.eq("Status","y").ignoreCase())
										   .add(Restrictions.eq("Hospital.Id", hospitalId))
										   .list();
		}
		map.put("bedList",bedList);
		map.put("hospitalDoctorUnitMList",hospitalDoctorUnitMList);
		return map;
	}



	@Override
	public boolean saveUnitWiseTable(OtMasUnitDay omud) {
		boolean successfullyAdded = false;
		Transaction tnx=null;
		Session session =(Session) getSession();
		try{
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		tnx=session.beginTransaction();
		hbt.save(omud);
		hbt.flush();
		tnx.commit();
		session.flush();
		successfullyAdded = true;
		}catch(Exception e){
			tnx.rollback();
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	@Override
	public boolean editBedStatusToDatabase(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<OtMasUnitDay> checkForExistingData(int bedId, int unitId,
			String dayName,int hospitalId) {
		List<OtMasUnitDay>omudList=new ArrayList<OtMasUnitDay>();
		Session session=(Session)getSession();
		omudList=session.createCriteria(OtMasUnitDay.class)
				.add(Restrictions.eq("Hospital.Id",hospitalId))
				.add(Restrictions.eq("DayName",dayName))
				.add(Restrictions.eq("MasBed.Id",bedId))
				.add(Restrictions.eq("UnitM.Id",unitId)).list();
				
		return omudList;
	}
	
	// -----------------------WasteCategory-------------------------------------------
	
		public boolean addWasteCategory(Map<String, Object> wasteCategoryMap) {
			
			boolean successfullyAdded = false;
			MasWasteCategory masWasteCategory=new MasWasteCategory();
			if(wasteCategoryMap.get("masWasteCategory")!=null){
				masWasteCategory=(MasWasteCategory)wasteCategoryMap.get("masWasteCategory");
			}
			int hospitalId=0;
			if(wasteCategoryMap.get("hospitalId")!=null){
				hospitalId=(Integer)wasteCategoryMap.get("hospitalId");
			}
			try{
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				
				hbt.save(masWasteCategory);
				
				
				successfullyAdded = true;
			}catch (Exception e) {
				successfullyAdded=false;
				e.printStackTrace();
			}
			return successfullyAdded;
		}

		public boolean editWasteCategory(Map<String, Object> generalMap) {
			boolean dataUpdated = false;
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			int stateId = 0;
			String wasteCategoryName = "";
			@SuppressWarnings("unused")
			String wasteCategoryCode = "";
			int wasteCategoryId = 0;
			wasteCategoryId = (Integer) generalMap.get("id");
			wasteCategoryCode = (String) generalMap.get("wasteCategoryCode");
			wasteCategoryName = (String) generalMap.get("name");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			int userId=0; 
			userId = (Integer) generalMap.get("userId");
			MasWasteCategory masWasteCategory = (MasWasteCategory) getHibernateTemplate().get(
					MasWasteCategory.class, wasteCategoryId);

			masWasteCategory.setId(wasteCategoryId);
			masWasteCategory.setWasteCategoryName(wasteCategoryName);

		

			masWasteCategory.setLastChgDate(currentDate);
			masWasteCategory.setLastChgTime(currentTime);
			
			
			Users users = new Users();
			users.setId(userId);
			masWasteCategory.setLastChgBy(users);
			
			try
			{
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(masWasteCategory);
				dataUpdated = true;
			}
			catch (DataAccessException e)
			{
				dataUpdated = false;
				e.printStackTrace();
			}
			return dataUpdated;
		}

		@SuppressWarnings("unchecked")
		public Map<String, Object> searchWasteCategory(String wasteCategoryCode,
				String wasteCategoryName) {
			List<MasWasteCategory> searchWasteCategoryList = new ArrayList<MasWasteCategory>();
			Map<String, Object> wasteCategoryFieldsMap = new HashMap<String, Object>();
			try {
				if ((wasteCategoryName != null) || (wasteCategoryCode == null)) {
					searchWasteCategoryList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasWasteCategory as dis where dis.WasteCategoryName like '"
									+ wasteCategoryName + "%' order by dis.WasteCategoryName");
				} else {
					searchWasteCategoryList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasWasteCategory as dis where dis.WasteCategoryCode like '"
									+ wasteCategoryCode + "%' order by dis.WasteCategoryCode");
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			wasteCategoryFieldsMap.put("searchWasteCategoryList", searchWasteCategoryList);
			
			return wasteCategoryFieldsMap;
		}

		@SuppressWarnings("unchecked")
		public Map<String, Object> showWasteCategory() {
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasWasteCategory> searchWasteCategoryList = new ArrayList<MasWasteCategory>();
			try{
				searchWasteCategoryList = getHibernateTemplate().find("from jkt.hms.masters.business.MasWasteCategory");
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			map.put("searchWasteCategoryList", searchWasteCategoryList);
			return map;
		}

		@SuppressWarnings("unchecked")
		public boolean deleteWasteCategory(int wasteCategoryId, Map<String, Object> generalMap) {
			boolean dataDeleted = false;
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			MasWasteCategory masWasteCategory = new MasWasteCategory();
			masWasteCategory = (MasWasteCategory) getHibernateTemplate().get(
					MasWasteCategory.class, wasteCategoryId);
			
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			int userId=0; 
			userId = (Integer) generalMap.get("userId");
			if (generalMap.get("flag") != null) {
				String flag = (String) generalMap.get("flag");
				if (flag.equals("InActivate")) {
					masWasteCategory.setStatus("N");
					dataDeleted = true;
				} else if (flag.equals("Activate")) {
					masWasteCategory.setStatus("Y");
					dataDeleted = false;
				}
			}
			Users users = new Users();
			users.setId(userId);
			masWasteCategory.setLastChgBy(users);
			masWasteCategory.setLastChgDate(currentDate);
			masWasteCategory.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masWasteCategory);
			return dataDeleted;
		}
		
	// -----------------------WasteContainer-------------------------------------------
	
	public boolean addWasteContainer(Map<String, Object> wasteContainerMap) {
		
		boolean successfullyAdded = false;
		MasWasteContainer masWasteContainer=new MasWasteContainer();
		if(wasteContainerMap.get("masWasteContainer")!=null){
			masWasteContainer=(MasWasteContainer)wasteContainerMap.get("masWasteContainer");
		}
		int hospitalId=0;
		if(wasteContainerMap.get("hospitalId")!=null){
			hospitalId=(Integer)wasteContainerMap.get("hospitalId");
		}
		try{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			hbt.save(masWasteContainer);
			
			
			successfullyAdded = true;
		}catch (Exception e) {
			successfullyAdded=false;
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	public boolean editWasteContainer(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int stateId = 0;
		String wasteContainerName = "";
		@SuppressWarnings("unused")
		String wasteContainerCode = "";
		int wasteContainerId = 0;
		wasteContainerId = (Integer) generalMap.get("id");
		wasteContainerCode = (String) generalMap.get("wasteContainerCode");
		wasteContainerName = (String) generalMap.get("name");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=0; 
		userId = (Integer) generalMap.get("userId");
		MasWasteContainer masWasteContainer = (MasWasteContainer) getHibernateTemplate().get(
				MasWasteContainer.class, wasteContainerId);

		masWasteContainer.setId(wasteContainerId);
		masWasteContainer.setWasteContainerName(wasteContainerName);

	

		masWasteContainer.setLastChgDate(currentDate);
		masWasteContainer.setLastChgTime(currentTime);
		
		
		Users users = new Users();
		users.setId(userId);
		masWasteContainer.setLastChgBy(users);
		
		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masWasteContainer);
			dataUpdated = true;
		}
		catch (DataAccessException e)
		{
			dataUpdated = false;
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchWasteContainer(String wasteContainerCode,
			String wasteContainerName) {
		List<MasWasteContainer> searchWasteContainerList = new ArrayList<MasWasteContainer>();
		Map<String, Object> wasteContainerFieldsMap = new HashMap<String, Object>();
		try {
			if ((wasteContainerName != null) || (wasteContainerCode == null)) {
				searchWasteContainerList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasWasteContainer as dis where dis.WasteContainerName like '"
								+ wasteContainerName + "%' order by dis.WasteContainerName");
			} else {
				searchWasteContainerList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasWasteContainer as dis where dis.WasteContainerCode like '"
								+ wasteContainerCode + "%' order by dis.WasteContainerCode");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		wasteContainerFieldsMap.put("searchWasteContainerList", searchWasteContainerList);
		
		return wasteContainerFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showWasteContainer() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasWasteContainer> searchWasteContainerList = new ArrayList<MasWasteContainer>();
		try{
			searchWasteContainerList = getHibernateTemplate().find("from jkt.hms.masters.business.MasWasteContainer");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		map.put("searchWasteContainerList", searchWasteContainerList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteWasteContainer(int wasteContainerId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasWasteContainer masWasteContainer = new MasWasteContainer();
		masWasteContainer = (MasWasteContainer) getHibernateTemplate().get(
				MasWasteContainer.class, wasteContainerId);
		
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=0; 
		userId = (Integer) generalMap.get("userId");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masWasteContainer.setStatus("N");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masWasteContainer.setStatus("Y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(userId);
		masWasteContainer.setLastChgBy(users);
		masWasteContainer.setLastChgDate(currentDate);
		masWasteContainer.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masWasteContainer);
		return dataDeleted;
	}

	@Override
	public Map<String, Object> showAmbulanceJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAmbulance> searchAmbulanceList = new ArrayList<MasAmbulance>();
		try{
			searchAmbulanceList = getHibernateTemplate().find("from jkt.hms.masters.business.MasAmbulance");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		map.put("searchAmbulanceList", searchAmbulanceList);
		return map;
	}

	@Override
	public boolean deleteAmbulance(int ambulanceId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;

		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		int userId=0;
		MasAmbulance masAmbulance = (MasAmbulance) getHibernateTemplate().load(MasAmbulance.class,
				ambulanceId);
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		userId = (Integer) generalMap.get("userId");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masAmbulance.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masAmbulance.setStatus("y");
				dataDeleted = false;
			}
		}
		masAmbulance.setId(ambulanceId);
		Users users = new Users();
		users.setId(userId);
		masAmbulance.setLastChgDate(currentDate);
		masAmbulance.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAmbulance);
		return dataDeleted;
	}

	@Override
	public boolean editAmbulanceToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String ambulanceNo = "";
		@SuppressWarnings("unused")
		String description = "";
		int ambulanceId = 0;
		int userId=0;
		String available = "";
		ambulanceId = (Integer) generalMap.get("id");
		userId = (Integer) generalMap.get("userId");
		description = (String) generalMap.get("description");
		ambulanceNo = (String) generalMap.get("name");
		available = (String) generalMap.get("available");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasAmbulance masAmbulance = (MasAmbulance) getHibernateTemplate().load(MasAmbulance.class,
				ambulanceId);

		masAmbulance.setId(ambulanceId);
		Users users = new Users();
		users.setId(userId);
		masAmbulance.setLastChgBy(users);
		masAmbulance.setAmbulanceNo(ambulanceNo);
		masAmbulance.setDescription(description);
		masAmbulance.setAvailable(available);
		masAmbulance.setLastChgDate(currentDate);
		masAmbulance.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAmbulance);
		dataUpdated = true;
		return dataUpdated;
	}

	@Override
	public boolean addAmbulance(MasAmbulance masAmbulance) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masAmbulance);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@Override
	public Map<String, Object> searchAmbulance(String ambulanceNo) {
		List<MasAmbulance> searchAmbulanceList = new ArrayList<MasAmbulance>();
		Map<String, Object> ambulanceFieldsMap = new HashMap<String, Object>();
		try {
			if ((ambulanceNo != null)) {
				searchAmbulanceList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasAmbulance imc where lower(imc.AmbulanceNo) like '"
								+ ambulanceNo.toLowerCase()
								+ "%' order by imc.AmbulanceNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ambulanceFieldsMap.put("searchAmbulanceList", searchAmbulanceList);
		return ambulanceFieldsMap;
	}
	
	
}