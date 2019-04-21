package jkt.hms.sysparam.dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.HospitalParameters;
import jkt.hms.masters.business.MasBlock;
import jkt.hms.masters.business.MasCaste;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasCurrency;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasLanguage;
import jkt.hms.masters.business.MasReference;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasReligion;
import jkt.hms.masters.business.MasSetupParameterMaintaince;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.DataException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class SysCurrentParamDataServiceImpl extends HibernateDaoSupport
		implements SysCurrentParamDataService {

	@SuppressWarnings("unchecked")
	public Map<String, Object> getSysCurrentParamJsp() {

		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();

		List<MasRelation> relationList = new ArrayList<MasRelation>();
		List<MasReligion> religionList = new ArrayList<MasReligion>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasBlock> blockList = new ArrayList<MasBlock>();
		List<MasReference> referenceList = new ArrayList<MasReference>();
		List<MasCaste> casteList = new ArrayList<MasCaste>();
		List<MasChargeCode> regChargeList = new ArrayList<MasChargeCode>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<MasSetupParameterMaintaince> setupParamList = new ArrayList<MasSetupParameterMaintaince>();
		List<MasChargeCode> visitChargeList = new ArrayList<MasChargeCode>();
		List<MasLanguage> langList = new ArrayList<MasLanguage>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		try {
			countryList = session.createCriteria(MasCountry.class)
					.add(Restrictions.eq("Status", "y")).list();
			stateList = session.createCriteria(MasState.class)
					.add(Restrictions.eq("Status", "y")).list();
			langList = session.createCriteria(MasLanguage.class).list();
			setupParamList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasSetupParameterMaintaince");
			districtList = session
					.createQuery(
							"select dist from MasDistrict as dist order by dist.DistrictName ")
					.list();
			blockList = session.createCriteria(MasBlock.class)
					.add(Restrictions.eq("Status", "y")).list();
			religionList = session.createCriteria(MasReligion.class)
					.add(Restrictions.eq("Status", "y")).list();
			relationList = session.createCriteria(MasRelation.class)
					.add(Restrictions.eq("Status", "y")).list();
			casteList = session.createCriteria(MasCaste.class)
					.add(Restrictions.eq("Status", "y")).list();
			referenceList = session.createCriteria(MasReference.class)
					.add(Restrictions.eq("Status", "y")).list();
			hospitalList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasHospital as mh where mh.Id = 1");
			regChargeList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasChargeCode as chrg where chrg.ChargeType.Id=6 ");
			visitChargeList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasChargeCode as chrg where chrg.ChargeType.Id=9");
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Status", "y")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("employeeList", employeeList);
		map.put("langList", langList);
		map.put("countryList", countryList);
		map.put("stateList", stateList);
		map.put("districtList", districtList);
		map.put("blockList", blockList);
		map.put("religionList", religionList);
		map.put("relationList", relationList);
		map.put("referenceList", referenceList);
		map.put("casteList", casteList);
		map.put("regChargeList", regChargeList);
		map.put("visitChargeList", visitChargeList);
		map.put("setupParamList", setupParamList);
		map.put("hospitalList", hospitalList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getHospitalParamJsp(Box box)
	{
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		// List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasBlock> blockList = new ArrayList<MasBlock>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<HospitalParameters> hospitalParamList = new ArrayList<HospitalParameters>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		try
		{
			currencyList = session.createCriteria(MasCurrency.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			stateList = session.createCriteria(MasState.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			districtList = session
					.createQuery(
							"select dist from MasDistrict as dist where dist.Status='y' order by dist.DistrictName ")
					.list();
			hospitalList = session.createCriteria(MasHospital.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			blockList = session.createCriteria(MasBlock.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			countryList = session.createCriteria(MasCountry.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			hospitalParamList= session.createCriteria(HospitalParameters.class).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
			.list();
			masDepartmentList= session.createCriteria(MasDepartment.class)
			.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			// hospitalParamList = getHibernateTemplate().find("from
			// jkt.hms.masters.business.HospitalParameters as mh where mh.id =
			// 1");

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("masDepartmentList", masDepartmentList);
		map.put("hospitalList", hospitalList);
		map.put("countryList", countryList);
		map.put("stateList", stateList);
		map.put("districtList", districtList);
		map.put("blockList", blockList);
		map.put("currencyList", currencyList);
		map.put("hospitalParamList", hospitalParamList);
		return map;
	}

	public boolean saveChangedSysParam(Map valueMap) throws DataException {

		boolean updatedSuccessfully = false;
		Session session = (Session) getSession();
		List<MasSetupParameterMaintaince> sysParamList = new ArrayList<MasSetupParameterMaintaince>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction transaction = null;
		try {
			if (valueMap.get("sysParam") != null) {
				MasSetupParameterMaintaince sysParam = (MasSetupParameterMaintaince) valueMap
						.get("sysParam");
			    transaction = session.beginTransaction();
				transaction.begin();
				hbt.update(sysParam);
				transaction.commit();
				updatedSuccessfully = true;
			}

		} catch (DataException e) {

			if (transaction != null) {
				transaction.rollback();
				e.printStackTrace();
				throw e;
			}

		} catch (Exception e) {
			updatedSuccessfully = false;
			e.printStackTrace();
		}
		return updatedSuccessfully;
	}

	public Map<String, Object> saveHospitalParam(Map valueMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean updatedSuccessfully = false;
		Session session = (Session) getSession();
		List<HospitalParameters> existingHospParamList = new ArrayList<HospitalParameters>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction transaction = null;
		int hospId = 0;
		if(valueMap.get("hospId") != null){
			hospId = (Integer)valueMap.get("hospId");
		}
		existingHospParamList = session.createCriteria(HospitalParameters.class).add(Restrictions.eq("Hospital.Id", hospId)).list();
		System.out.println(hospId+"===hospId====existingHospParamList=="+existingHospParamList.size());
		try {
			HospitalParameters hospParam = null;
		if(existingHospParamList.size()>0){
			if (valueMap.get("hospParam") != null) {
				hospParam = (HospitalParameters) valueMap.get("hospParam");
				transaction = session.beginTransaction();
				transaction.begin();
				hbt.saveOrUpdate(hospParam);
				transaction.commit();
				updatedSuccessfully = true;
			}
		}else{
			if (valueMap.get("hospParam") != null) {
				hospParam = (HospitalParameters) valueMap.get("hospParam");
				transaction = session.beginTransaction();
				transaction.begin();
				hbt.save(hospParam);
				transaction.commit();
				updatedSuccessfully = true;
			}
			
		}
		} catch (DataException e) {

			if (transaction != null) {
				transaction.rollback();
				e.printStackTrace();
				throw e;
			}

		} catch (Exception e) {
			updatedSuccessfully = false;
			e.printStackTrace();
		}
		map.put("updatedSuccessfully", updatedSuccessfully);
		map.put("existingHospParamList", existingHospParamList);
		return map;
	}

	public Map<String, Object> getTransactionSeqSetupJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<TransactionSequence> searchTransSeqSetupList = new ArrayList<TransactionSequence>();
		try {
			searchTransSeqSetupList = (List<TransactionSequence>) session
					.createCriteria(TransactionSequence.class).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("searchTransSeqSetupList", searchTransSeqSetupList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getSearchTransSeqSetupJSP(
			String transactionSqName, String transactionPrefix) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<TransactionSequence> searchTransSeqSetupList = new ArrayList<TransactionSequence>();

		try {
			if ((transactionSqName != null) || (transactionPrefix == null)) {

				searchTransSeqSetupList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.TransactionSequence tSq where tSq.TransactionSequenceName like '"
								+ transactionSqName
								+ "%' order by tSq.TransactionSequenceName");

			} else {
				searchTransSeqSetupList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.TransactionSequence tSq where tSq.TransactionPrefix like '"
								+ transactionPrefix
								+ "%' order by tSq.TransactionPrefix");

			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("searchTransSeqSetupList", searchTransSeqSetupList);
		return map;
	}

	public Map<String, Object> checkForExistingTransSq(Map generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List duplicateMastersList = new ArrayList();
		List duplicateTransNameList = new ArrayList();
		List duplicateTransPrefixList = new ArrayList();

		int id = 0;
		String pojoPropertyCode = "";
		String pojoPropertyName = "";
		if (generalMap.get("id") != null) {
			id = (Integer) generalMap.get("id");
		}

		String name = (String) generalMap.get("name");
		String pojoName = (String) generalMap.get("pojoName");
		if (generalMap.get("pojoPropertyName") != null) {
			pojoPropertyName = (String) generalMap.get("pojoPropertyName");
		}

		if (generalMap.get("pojoPropertyCode") != null) {
			pojoPropertyCode = (String) generalMap.get("pojoPropertyCode");
		}

		if (generalMap.get("flag") == null) {
			String code = (String) generalMap.get("code");

			if (!pojoPropertyCode.equals("")) {
				duplicateTransPrefixList = getHibernateTemplate().find(
						"from jkt.hms.masters.business." + pojoName
								+ " as g where g." + pojoPropertyCode + " ='"
								+ code + "'");
			}
			if (!pojoPropertyName.equals("")) {
				duplicateTransNameList = getHibernateTemplate().find(
						"from jkt.hms.masters.business." + pojoName
								+ " as g where g." + pojoPropertyName + " = '"
								+ name + "'");
			}

		} else if (generalMap.get("flag") != null) {
			boolean flag = (Boolean) generalMap.get("flag");
			duplicateMastersList = getHibernateTemplate().find(
					"from jkt.hms.masters.business." + pojoName
							+ " as g where g." + pojoPropertyName + " = '"
							+ name + "' and g.Id != " + id);
		}
		map.put("duplicateGeneralNameList", duplicateTransNameList);
		map.put("duplicateGeneralCodeList", duplicateTransPrefixList);
		map.put("duplicateMastersList", duplicateMastersList);

		return map;
	}

	public boolean addTransactionSeq(TransactionSequence transactionSequence) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(transactionSequence);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editTransactionNoToDatabase(Map generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String transactionSqName = "";
		String transactionSeqPrefix = "";
		String tableName = "";
		int transactionSqNumber = 0;
		int transactionSqId = 0;
		int changedBy = 0;
		transactionSqId = (Integer) generalMap.get("id");
		transactionSeqPrefix = (String) generalMap.get("transactionSeqPrefix");
		transactionSqName = (String) generalMap.get("transactionSqName");
		tableName = (String) generalMap.get("tableName");
		transactionSqNumber = (Integer) generalMap.get("number");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		TransactionSequence transactionSequence = (TransactionSequence) getHibernateTemplate()
				.get(TransactionSequence.class, transactionSqId);

		transactionSequence.setId(transactionSqId);
		transactionSequence.setTransactionSequenceName(transactionSqName);
		transactionSequence.setTransactionPrefix(transactionSeqPrefix);
		transactionSequence.setTransactionSequenceNumber(transactionSqNumber);
		transactionSequence.setTablename(tableName);
		//commented for maven
		/*transactionSequence.setCreatedbyId(changedBy);*/
		transactionSequence.setLastChgDate(currentDate);
		transactionSequence.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(transactionSequence);
		dataUpdated = true;
		return dataUpdated;

	}

	public Map<String, Object> getHospitalDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<HospitalParameters> hospitalParametersList = new ArrayList<HospitalParameters>();
		try {
			hospitalParametersList = session
					.createCriteria(HospitalParameters.class)
					.add(Restrictions.eq("Hospital.Id", box.getInt("DA")))
					.list();
			if (hospitalParametersList != null
					&& hospitalParametersList.size() > 0) {
				map.put("hospitalParamList", hospitalParametersList);
			} else {
				map.put("hospitalParameters",
						hospitalParametersList.add(new HospitalParameters()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

}
