package jkt.hms.masters.dataservice;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.DgCollectionCenter;
import jkt.hms.masters.business.DgMasCollection;
import jkt.hms.masters.business.DgMasOrganism;
import jkt.hms.masters.business.DgMasOrganismGroup;
import jkt.hms.masters.business.DgOrgDtl;
import jkt.hms.masters.business.DgOrgGrpDtl;
import jkt.hms.masters.business.DgUom;
import jkt.hms.masters.business.DiagParam;
import jkt.hms.masters.business.MasAnalyzerParameter;
import jkt.hms.masters.business.MasAntibioticLab;
import jkt.hms.masters.business.MasBiopsyLab;
import jkt.hms.masters.business.MasDiagnosisConclusion;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasSample;
import jkt.hms.masters.business.MasServiceCentreCounter;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hms.util.User;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class LaboratoryMasterDataServiceImpl extends HibernateDaoSupport
		implements LaboratoryMasterDataService {

	// -------------------------------- Diagnosis Conclusion
	// -----------------------------------

	public boolean addDiagnosisConclusion(
			MasDiagnosisConclusion masDiagnosisConclusion) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDiagnosisConclusion);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editDiagnosisConclusionToDatabase(
			Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String diagnosisConclusionName = "";
		@SuppressWarnings("unused")
		String diagnosisConclusionCode = "";
		int diagnosisConclusionId = 0;
		String changedBy = "";
		diagnosisConclusionId = (Integer) generalMap.get("id");
		diagnosisConclusionCode = (String) generalMap
				.get("diagnosisConclusionCode");
		diagnosisConclusionName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasDiagnosisConclusion masDiagnosisConclusion = (MasDiagnosisConclusion) getHibernateTemplate()
				.load(MasDiagnosisConclusion.class, diagnosisConclusionId);

		masDiagnosisConclusion.setId(diagnosisConclusionId);
		masDiagnosisConclusion
				.setDiagnosisConclusionName(diagnosisConclusionName);
		masDiagnosisConclusion.setLastChgby(changedBy);
		masDiagnosisConclusion.setLastchgdate(currentDate);
		masDiagnosisConclusion.setLastchgtime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDiagnosisConclusion);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDiagnosisConclusionJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDiagnosisConclusion> searchDiagnosisConclusionList = new ArrayList<MasDiagnosisConclusion>();
		searchDiagnosisConclusionList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDiagnosisConclusion ");
		map.put("searchDiagnosisConclusionList", searchDiagnosisConclusionList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDiagnosisConclusion(
			String diagnosisConclusionCode, String diagnosisConclusionName) {
		List<MasDiagnosisConclusion> searchDiagnosisConclusionList = new ArrayList<MasDiagnosisConclusion>();
		Map<String, Object> diagnosisConclusionFieldsMap = new HashMap<String, Object>();
		try {
			if ((diagnosisConclusionName != null)
					|| (diagnosisConclusionCode == null)) {
				searchDiagnosisConclusionList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasDiagnosisConclusion imc where imc.DiagnosisConclusionName like '"
								+ diagnosisConclusionName
								+ "%' order by imc.DiagnosisConclusionName");
			} else {
				searchDiagnosisConclusionList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasDiagnosisConclusion imc where imc.DiagnosisConclusionCode like '"
								+ diagnosisConclusionCode
								+ "%' order by imc.DiagnosisConclusionCode");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		diagnosisConclusionFieldsMap.put("searchDiagnosisConclusionList",
				searchDiagnosisConclusionList);
		return diagnosisConclusionFieldsMap;
	}

	public boolean deleteDiagnosisConclusion(int diagnosisConclusionId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasDiagnosisConclusion masDiagnosisConclusion = new MasDiagnosisConclusion();
		masDiagnosisConclusion = (MasDiagnosisConclusion) getHibernateTemplate()
				.load(MasDiagnosisConclusion.class, diagnosisConclusionId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDiagnosisConclusion.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDiagnosisConclusion.setStatus("y");
				dataDeleted = false;
			}
		}
		masDiagnosisConclusion.setLastChgby(changedBy);
		masDiagnosisConclusion.setLastchgdate(currentDate);
		masDiagnosisConclusion.setLastchgtime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDiagnosisConclusion);
		return dataDeleted;
	}

	// ---------------------------------- Biopsy Lab
	// ------------------------------------
	/* public boolean addAntibioticLab(MasAntibioticLab masAntibioticLab) {
		boolean successfullyAdded = false;
		try{
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masAntibioticLab);
		hbt.flush();
		hbt.clear();
		successfullyAdded = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}
	 * */
	public boolean addBiopsyLab(MasBiopsyLab masBiopsyLab) {
		boolean successfullyAdded = false;
		try{
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masBiopsyLab);
		hbt.flush();
		hbt.clear();
		successfullyAdded = true;
		}catch (DataAccessException e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBiopsyLab(String biopsyLabCode,
			String biopsyLabName) {
		List<MasBiopsyLab> searchBiopsyLabList = new ArrayList<MasBiopsyLab>();
		Map<String, Object> biopsyLabFieldsMap = new HashMap<String, Object>();
		try {
			if ((biopsyLabName != null) || (biopsyLabCode == null)) {
				searchBiopsyLabList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasBiopsyLab imc where imc.BiopsyLabName like '"
								+ biopsyLabName
								+ "%' order by imc.BiopsyLabName");
			} else {
				searchBiopsyLabList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasBiopsyLab imc where imc.BiopsyLabCode like '"
								+ biopsyLabCode
								+ "%' order by imc.BiopsyLabCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		biopsyLabFieldsMap.put("searchBiopsyLabList", searchBiopsyLabList);
		return biopsyLabFieldsMap;
	}

	public boolean editBiopsyLabToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String biopsyLabName = "";
		@SuppressWarnings("unused")
		String biopsyLabCode = "";
		int biopsyLabId = 0;
		int changedBy = 0;
		biopsyLabId = (Integer) generalMap.get("id");
		biopsyLabCode = (String) generalMap.get("biopsyLabCode");
		biopsyLabName = (String) generalMap.get("name");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasBiopsyLab masBiopsyLab = (MasBiopsyLab) getHibernateTemplate().load(
				MasBiopsyLab.class, biopsyLabId);

		masBiopsyLab.setId(biopsyLabId);
		masBiopsyLab.setBiopsyLabName(biopsyLabName);
		Users user=new Users();
		user.setId(changedBy);
		masBiopsyLab.setLastChgBy(user);
		masBiopsyLab.setLastChgDate(currentDate);
		masBiopsyLab.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBiopsyLab);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBiopsyLabJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBiopsyLab> searchBiopsyLabList = new ArrayList<MasBiopsyLab>();
		searchBiopsyLabList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBiopsyLab ");
		map.put("searchBiopsyLabList", searchBiopsyLabList);
		return map;
	}

	public boolean deleteBiopsyLab(int biopsyLabId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasBiopsyLab masBiopsyLab = new MasBiopsyLab();
		masBiopsyLab = (MasBiopsyLab) getHibernateTemplate().load(
				MasBiopsyLab.class, biopsyLabId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masBiopsyLab.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masBiopsyLab.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user=new Users();
		user.setId(changedBy);
		masBiopsyLab.setLastChgBy(user);
		masBiopsyLab.setLastChgDate(currentDate);
		masBiopsyLab.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBiopsyLab);
		return dataDeleted;
	}

	// ---------------------------------------- Sample
	// --------------------------------

	public boolean addSample(MasSample masSample) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masSample);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteSample(int sampleId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasSample masSample = new MasSample();
		masSample = (MasSample) getHibernateTemplate().load(MasSample.class,
				sampleId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masSample.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masSample.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users(changedBy);
		masSample.setLastChgBy(users);
		masSample.setLastChgDate(currentDate);
		masSample.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masSample);
		return dataDeleted;
	}

	public boolean editSampleToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		int collectionId = 0;
		int uomId = 0;
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String sampleName = "";
		@SuppressWarnings("unused")
		String sampleCode = "";
		int sampleId = 0;
		int changedBy = 0;
		sampleId = (Integer) generalMap.get("id");
		sampleCode = (String) generalMap.get("sampleCode");
		sampleName = (String) generalMap.get("name");
		collectionId = (Integer) generalMap.get("collectionId");
		uomId = (Integer) generalMap.get("uomId");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasSample masSample = (MasSample) getHibernateTemplate().load(
				MasSample.class, sampleId);

		masSample.setId(sampleId);
		masSample.setSampleDescription(sampleName);

		if (collectionId != 0) {
			DgMasCollection dgMasCollection = new DgMasCollection();
			dgMasCollection.setId(collectionId);
			masSample.setCollection(dgMasCollection);
		}

		if (uomId != 0) {
			DgUom dgUom = new DgUom();
			dgUom.setId(uomId);
			masSample.setUom(dgUom);
		}
		Users users=new Users(changedBy);
		masSample.setLastChgBy(users);
		masSample.setLastChgDate(currentDate);
		masSample.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masSample);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchSample(String sampleCode, String sampleName) {
		List<MasSample> searchSampleList = new ArrayList<MasSample>();
		Map<String, Object> sampleFieldsMap = new HashMap<String, Object>();
		try {
			if ((sampleName != null) || (sampleCode == null)) {
				searchSampleList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasSample imc where imc.SampleDescription like '"
								+ sampleName
								+ "%' order by imc.SampleDescription");
			} else {
				searchSampleList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasSample imc where imc.SampleCode like '"
								+ sampleCode + "%' order by imc.SampleCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sampleFieldsMap.put("searchSampleList", searchSampleList);
		return sampleFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showSampleJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSample> searchSampleList = new ArrayList<MasSample>();
		List<DgMasCollection> searchCollectionList = new ArrayList<DgMasCollection>();
		List<DgUom> searchInvestigationUomList = new ArrayList<DgUom>();
		searchSampleList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSample ");
		searchCollectionList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.DgMasCollection as dmc where dmc.Status = 'y' order by dmc.CollectionName");
		searchInvestigationUomList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.DgUom as du where du.Status = 'y' order by du.UomName");
		map.put("searchSampleList", searchSampleList);
		map.put("searchCollectionList", searchCollectionList);
		map.put("searchInvestigationUomList", searchInvestigationUomList);
		return map;
	}

	// --------------------------------Sample
	// Collection-----------------------------

	public Map<String, Object> showSampleCollectionJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgMasCollection> searchCollectionList = new ArrayList<DgMasCollection>();
		searchCollectionList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DgMasCollection ");
		map.put("searchCollectionList", searchCollectionList);
		return map;
	}

	public Map<String, Object> searchSampleCollection(String collectionCode,
			String collectionName) {
		List<DgMasCollection> searchCollectionList = new ArrayList<DgMasCollection>();
		Map<String, Object> sampleFieldsMap = new HashMap<String, Object>();
		try {
			if ((collectionName != null) || (collectionCode == null)) {
				searchCollectionList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.DgMasCollection dmc where upper(dmc.CollectionName) like upper('"
								+ collectionName
								+ "%') order by dmc.CollectionName");
			} else {
				searchCollectionList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.DgMasCollection dmc where dmc.CollectionCode like '"
								+ collectionCode
								+ "%' order by dmc.CollectionCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sampleFieldsMap.put("searchCollectionList", searchCollectionList);
		return sampleFieldsMap;
	}

	public boolean addSampleCollection(DgMasCollection dgMasCollection) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(dgMasCollection);
		hbt.flush();
		hbt.clear();
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editSampleCollectionToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String collectionName = "";
		@SuppressWarnings("unused")
		String collectionCode = "";
		int collectionId = 0;
		int changedBy = 0;
		collectionId = (Integer) generalMap.get("id");
		collectionCode = (String) generalMap.get("collectionCode");
		collectionName = (String) generalMap.get("name");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		DgMasCollection dgMasCollection = (DgMasCollection) getHibernateTemplate()
				.load(DgMasCollection.class, collectionId);

		dgMasCollection.setId(collectionId);
		dgMasCollection.setCollectionName(collectionName);
		Users users=new Users(changedBy);
		dgMasCollection.setLastChgBy(users);
		dgMasCollection.setLastChgDate(currentDate);
		dgMasCollection.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(dgMasCollection);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteSampleCollection(int collectionId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		DgMasCollection dgMasCollection = new DgMasCollection();
		dgMasCollection = (DgMasCollection) getHibernateTemplate().load(
				DgMasCollection.class, collectionId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				dgMasCollection.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				dgMasCollection.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users(changedBy);
		dgMasCollection.setLastChgBy(users);
		dgMasCollection.setLastChgDate(currentDate);
		dgMasCollection.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(dgMasCollection);
		return dataDeleted;
	}

	// -------------------------------InvestigationUom-----------------------------------
	public Map<String, Object> showInvestigationUomJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgUom> searchInvestigationUomList = new ArrayList<DgUom>();
		searchInvestigationUomList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DgUom ");
		map.put("searchInvestigationUomList", searchInvestigationUomList);
		return map;
	}

	public Map<String, Object> searchInvestigationUom(String uomCode,
			String uomName) {
		List<DgUom> searchInvestigationUomList = new ArrayList<DgUom>();
		Map<String, Object> investigationUomFieldsMap = new HashMap<String, Object>();
		try {
			if ((uomName != null) || (uomCode == null)) {
				searchInvestigationUomList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.DgUom imc where upper(imc.UomName) like upper('"
								+ uomName + "%') order by imc.UomName");
			} else {
				searchInvestigationUomList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.DgUom imc where imc.UomCode like '"
								+ uomCode + "%' order by imc.UomCode");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		investigationUomFieldsMap.put("searchInvestigationUomList",
				searchInvestigationUomList);
		return investigationUomFieldsMap;
	}

	public boolean addInvestigationUom(DgUom dgUom) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(dgUom);
		hbt.flush();
		hbt.clear();
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editInvestigationUomToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String uomName = "";
		@SuppressWarnings("unused")
		String uomCode = "";
		int uomId = 0;
		int changedBy =0;
		uomId = (Integer) generalMap.get("id");
		uomCode = (String) generalMap.get("uomCode");
		uomName = (String) generalMap.get("name");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		DgUom dgUom = (DgUom) getHibernateTemplate().load(DgUom.class, uomId);

		dgUom.setId(uomId);
		dgUom.setUomName(uomName);
		Users users=new Users(changedBy);
		dgUom.setLastChgBy(users);
		dgUom.setLastChgDate(currentDate);
		dgUom.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(dgUom);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteInvestigationUom(int uomId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		DgUom dgUom = (DgUom) getHibernateTemplate().load(DgUom.class, uomId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				dgUom.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				dgUom.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users(changedBy);
		dgUom.setLastChgBy(users);
		dgUom.setLastChgDate(currentDate);
		dgUom.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(dgUom);
		return dataDeleted;
	}

	// ------------------------------CollectionCenter----------------------------------
	public Map<String, Object> showCollectionCenterJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgCollectionCenter> searchCollectionCenterList = new ArrayList<DgCollectionCenter>();
		searchCollectionCenterList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DgCollectionCenter ");
		map.put("searchCollectionCenterList", searchCollectionCenterList);
		return map;
	}

	public Map<String, Object> searchCollectionCenter(
			String collectionCenterCode, String collectionCenterName) {
		List<DgCollectionCenter> searchCollectionCenterList = new ArrayList<DgCollectionCenter>();
		Map<String, Object> biopsyLabFieldsMap = new HashMap<String, Object>();
		try {
			if ((collectionCenterName != null)
					|| (collectionCenterCode == null)) {
				searchCollectionCenterList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.DgCollectionCenter imc where imc.CollectionCenterName like '"
								+ collectionCenterName
								+ "%' order by imc.CollectionCenterName");
			} else {
				searchCollectionCenterList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.DgCollectionCenter imc where imc.CollectionCenterCode like '"
								+ collectionCenterCode
								+ "%' order by imc.CollectionCenterCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		biopsyLabFieldsMap.put("searchCollectionCenterList",
				searchCollectionCenterList);
		return biopsyLabFieldsMap;
	}

	public boolean addCollectionCenter(DgCollectionCenter dgCollectionCenter) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(dgCollectionCenter);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editCollectionCenterToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String collectionCenterName = "";
		@SuppressWarnings("unused")
		String collectionCenterCode = "";
		int collectionCenterId = 0;
		int changedBy = 0;
		collectionCenterId = (Integer) generalMap.get("id");
		collectionCenterCode = (String) generalMap.get("collectionCenterCode");
		collectionCenterName = (String) generalMap.get("name");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		DgCollectionCenter dgCollectionCenter = (DgCollectionCenter) getHibernateTemplate()
				.load(DgCollectionCenter.class, collectionCenterId);

		dgCollectionCenter.setId(collectionCenterId);
		dgCollectionCenter.setCollectionCenterName(collectionCenterName);
		Users users=new Users(changedBy);
		dgCollectionCenter.setLastChgBy(users);
		dgCollectionCenter.setLastChgDate(currentDate);
		dgCollectionCenter.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(dgCollectionCenter);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteCollectionCenter(int collectionCenterId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		DgCollectionCenter dgCollectionCenter = new DgCollectionCenter();
		dgCollectionCenter = (DgCollectionCenter) getHibernateTemplate().load(
				DgCollectionCenter.class, collectionCenterId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				dgCollectionCenter.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				dgCollectionCenter.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users(changedBy);
		dgCollectionCenter.setLastChgBy(users);
		dgCollectionCenter.setLastChgDate(currentDate);
		dgCollectionCenter.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(dgCollectionCenter);
		return dataDeleted;
	}

	// ---------------------------------- Organism Group start by Vishal
	// ------------------------------------

	public Map<String, Object> showOrganismJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgMasOrganism> searchOrganismList = new ArrayList<DgMasOrganism>();
		searchOrganismList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DgMasOrganism ");
		map.put("searchOrganismList", searchOrganismList);
		return map;
	}

	public Map<String, Object> searchOrganism(String organismCode,
			String organismName) {
		List<DgMasOrganism> searchOrganismList = new ArrayList<DgMasOrganism>();
		Map<String, Object> OrganismFieldsMap = new HashMap<String, Object>();
		try {
			if ((organismName != null) || (organismCode == null)) {
				searchOrganismList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.DgMasOrganism mo where mo.OrganismName like '"
								+ organismName + "%' order by mo.OrganismName");
			} else {
				searchOrganismList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.DgMasOrganism mo where mo.OrganismCode like '"
								+ organismCode + "%' order by mo.OrganismCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		OrganismFieldsMap.put("searchOrganismList", searchOrganismList);
		return OrganismFieldsMap;
	}

	public boolean addOrganism(DgMasOrganism dgMasOrganism) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(dgMasOrganism);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean editOrganism(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String organismName = "";
		@SuppressWarnings("unused")
		String organismCode = "";
		int organismId = 0;
		int changedBy = 0;
		organismId = (Integer) generalMap.get("id");
		organismCode = (String) generalMap.get("organismLabCode");
		organismName = (String) generalMap.get("name");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		DgMasOrganism dgMasOrganism = (DgMasOrganism) getHibernateTemplate()
				.load(DgMasOrganism.class, organismId);

		dgMasOrganism.setId(organismId);
		dgMasOrganism.setOrganismName(organismName);
		Users users=new Users(changedBy);
		dgMasOrganism.setLastChgBy(users);
		dgMasOrganism.setLastChgDate(currentDate);
		dgMasOrganism.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(dgMasOrganism);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteOrganism(int organismId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy =0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		DgMasOrganism dgMasOrganism = new DgMasOrganism();
		dgMasOrganism = (DgMasOrganism) getHibernateTemplate().load(
				DgMasOrganism.class, organismId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				dgMasOrganism.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				dgMasOrganism.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users(changedBy);
		dgMasOrganism.setLastChgBy(users);
		dgMasOrganism.setLastChgDate(currentDate);
		dgMasOrganism.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(dgMasOrganism);
		return dataDeleted;
	}

	public Map<String, Object> getConnection() {
		Session session = (Session) getSession();
		Connection con = (Connection) session.connection();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("conn", con);
		return map;
	}

	// -------------------Organism Group--------------------
	public Map<String, Object> showOrganismGroupJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgMasOrganismGroup> searchOrganismGroupList = new ArrayList<DgMasOrganismGroup>();
		searchOrganismGroupList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DgMasOrganismGroup ");
		map.put("searchOrganismGroupList", searchOrganismGroupList);
		return map;
	}

	public Map<String, Object> searchOrganismGroup(String organismGroupCode,
			String organismGroupName) {

		List<DgMasOrganismGroup> searchOrganismGroupList = new ArrayList<DgMasOrganismGroup>();
		Map<String, Object> organismDescFieldsMap = new HashMap<String, Object>();
		try {
			if ((organismGroupName != null) || (organismGroupCode == null)) {
				searchOrganismGroupList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.DgMasOrganismGroup imc where imc.OrganismGroupName like '"
								+ organismGroupName
								+ "%' order by imc.OrganismGroupName");
			} else {
				searchOrganismGroupList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.DgMasOrganismGroup imc where imc.OrganismGroupCode like '"
								+ organismGroupCode
								+ "%' order by imc.OrganismGroupCode");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		organismDescFieldsMap.put("searchOrganismGroupList",
				searchOrganismGroupList);
		return organismDescFieldsMap;
	}

	public boolean addOrganismGroup(DgMasOrganismGroup dgMasOrganismGroup) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(dgMasOrganismGroup);
		successfullyAdded = true;
		return successfullyAdded;
	}

	// -------------------------------------------------------------
	@SuppressWarnings("unchecked")
	public boolean editOrganismGroupToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String organismGroupName = "";
		@SuppressWarnings("unused")
		String organismGroupCode = "";
		int organismGroupId = 0;
		int changedBy = 0;
		organismGroupId = (Integer) generalMap.get("id");
		organismGroupCode = (String) generalMap.get("organismGroupCode");
		organismGroupName = (String) generalMap.get("name");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		DgMasOrganismGroup organismGroup = (DgMasOrganismGroup) getHibernateTemplate()
				.load(DgMasOrganismGroup.class, organismGroupId);

		organismGroup.setId(organismGroupId);
		organismGroup.setOrganismGroupName(organismGroupName);
		Users users=new Users(changedBy);
		organismGroup.setLastChgBy(users);
		organismGroup.setLastChgDate(currentDate);
		organismGroup.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(organismGroup);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteOrganismGroup(int organismGroupId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		DgMasOrganismGroup dgMasOrganismGroup = new DgMasOrganismGroup();
		dgMasOrganismGroup = (DgMasOrganismGroup) getHibernateTemplate().load(
				DgMasOrganismGroup.class, organismGroupId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				dgMasOrganismGroup.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				dgMasOrganismGroup.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users(changedBy);
		dgMasOrganismGroup.setLastChgBy(users);
		dgMasOrganismGroup.setLastChgDate(currentDate);
		dgMasOrganismGroup.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(dgMasOrganismGroup);
		return dataDeleted;
	}

	// ---------------------------------- Antibiotic Group start by Vishal
	// ------------------------------------

	public Map<String, Object> showAntibioticLabJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAntibioticLab> searchAntibioticList = new ArrayList<MasAntibioticLab>();
		searchAntibioticList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasAntibioticLab ");
		map.put("searchAntibioticList", searchAntibioticList);
		return map;
	}

	public Map<String, Object> searchAntibioticLab(String antibioticCode,
			String antibioticName) {
		List<MasAntibioticLab> searchAntibioticList = new ArrayList<MasAntibioticLab>();
		Map<String, Object> AntibioticFieldsMap = new HashMap<String, Object>();
		try {
			if ((antibioticName != null) || (antibioticCode == null)) {
				searchAntibioticList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasAntibioticLab mal where mal.AntibioticLabName like '"
								+ antibioticName
								+ "%' order by mal.AntibioticLabName");
			} else {
				searchAntibioticList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasAntibioticLab mal where mal.AntibioticLabCode like '"
								+ antibioticCode
								+ "%' order by mal.AntibioticLabCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		AntibioticFieldsMap.put("searchAntibioticList", searchAntibioticList);
		return AntibioticFieldsMap;
	}
	
	 public boolean addAntibioticLab(MasAntibioticLab masAntibioticLab) {
		boolean successfullyAdded = false;
		try{
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masAntibioticLab);
		hbt.flush();
		hbt.clear();
		successfullyAdded = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	

	@SuppressWarnings("unchecked")
	public boolean editAntibioticLabToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String antibioticLabName = "";
		@SuppressWarnings("unused")
		String antibioticLabCode = "";
		int antibioticLabId = 0;
		int changedBy = 0;
		antibioticLabId = (Integer) generalMap.get("id");
		antibioticLabCode = (String) generalMap.get("antibioticLabCode");
		antibioticLabName = (String) generalMap.get("name");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasAntibioticLab masAntibioticLab = (MasAntibioticLab) getHibernateTemplate()
				.load(MasAntibioticLab.class, antibioticLabId);

		masAntibioticLab.setId(antibioticLabId);
		masAntibioticLab.setAntibioticLabName(antibioticLabName);
		Users users=new Users(changedBy);
		masAntibioticLab.setLastChgBy(users);
		masAntibioticLab.setLastChgDate(currentDate);
		masAntibioticLab.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAntibioticLab);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteAntibioticLab(int antibioticLabId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasAntibioticLab masAntibioticLab = new MasAntibioticLab();
		masAntibioticLab = (MasAntibioticLab) getHibernateTemplate().load(
				MasAntibioticLab.class, antibioticLabId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masAntibioticLab.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masAntibioticLab.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users(changedBy);
		masAntibioticLab.setLastChgBy(users);
		masAntibioticLab.setLastChgDate(currentDate);
		masAntibioticLab.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAntibioticLab);
		return dataDeleted;
	}

	// ---------------------------------- Code end by Vishal
	// ------------------------------------

	public boolean deleteOrganismGroupDetail(int groupDetailId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		try {
			Users users=new Users((Integer)generalMap.get("changedBy"));
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");

			DgOrgGrpDtl dgOrgGrpDtl = new DgOrgGrpDtl();
			dgOrgGrpDtl = (DgOrgGrpDtl) getHibernateTemplate().get(
					DgOrgGrpDtl.class, groupDetailId); 
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

			if (generalMap.get("flag") != null) {
				String flag = (String) generalMap.get("flag");
				if (flag.equals("InActivate")) {
					dgOrgGrpDtl.setStatus("n");
					dataDeleted = true;
				} else if (flag.equals("Activate")) {
					dgOrgGrpDtl.setStatus("y");
					dataDeleted = false;
				}
			}

			dgOrgGrpDtl.setLastChgBy(users);
			dgOrgGrpDtl.setLastChgDate(currentDate);
			dgOrgGrpDtl.setLastChgTime(currentTime);

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			try {
				hbt.update(dgOrgGrpDtl);
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return dataDeleted;
	}

	public boolean editOrganismGroupDetail(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		int groupDetailId = 0;
		int organismId = 0;
		int organismGroupId = 0;
		@SuppressWarnings("unused")
		String dietCategoryName = "";
		int changedBy = 0;
		String currentTime = "";
		String demandDisplay = "";

		Date changedDate = new Date();
		groupDetailId = (Integer) generalMap.get("id");
		organismId = (Integer) generalMap.get("organismId");
		organismGroupId = (Integer) generalMap.get("organismGroupId");
		changedBy = (Integer) generalMap.get("changedBy");
		changedDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		DgOrgGrpDtl mgOrgGrpDtl = (DgOrgGrpDtl) getHibernateTemplate().get(
				DgOrgGrpDtl.class, groupDetailId);

		mgOrgGrpDtl.setId(groupDetailId);

		DgMasOrganismGroup dgMasOrganismGroup = new DgMasOrganismGroup();
		dgMasOrganismGroup.setId(organismGroupId);
		mgOrgGrpDtl.setOrganismGroup(dgMasOrganismGroup);

		DgMasOrganism dgMasOrganism = new DgMasOrganism();
		dgMasOrganism.setId(organismId);
		mgOrgGrpDtl.setOrganism(dgMasOrganism);

		mgOrgGrpDtl.setStatus("y");
		Users users=new Users(changedBy);
		mgOrgGrpDtl.setLastChgBy(users);
		mgOrgGrpDtl.setLastChgDate(changedDate);
		mgOrgGrpDtl.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(mgOrgGrpDtl);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public boolean addOrganismGroupDetail(DgOrgGrpDtl dgOrgGrpDtl) {
		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(dgOrgGrpDtl);
			hbt.flush();
			hbt.clear();
			successfullyAdded = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	public Map<String, Object> showOrganismGroupDetailJsp(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgOrgGrpDtl> searchOrganismGroupDetailList = new ArrayList<DgOrgGrpDtl>();
		List<DgMasOrganismGroup> organismGroupList = new ArrayList<DgMasOrganismGroup>();
		List<DgMasOrganism> organismList = new ArrayList<DgMasOrganism>();
		 
		searchOrganismGroupDetailList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DgOrgGrpDtl as mc where mc.Hospital.Id="+hospitalId);
		organismGroupList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DgMasOrganismGroup as mc");
		organismList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.DgMasOrganism as mc where mc.Status = 'y'");
		map.put("searchOrganismGroupDetailList", searchOrganismGroupDetailList);
		map.put("organismGroupList", organismGroupList);
		map.put("organismList", organismList);
		return map;
	}

	public boolean addOrganismDetail(DgOrgDtl dgOrgDtl) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(dgOrgDtl);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editOrganismDetail(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		int organismId = 0;
		int organismGroupId = 0;
		int changedBy = 0;
		String currentTime = "";
		Date changedDate = new Date();
		List<Integer> antibiaticIds = new ArrayList<Integer>();
		antibiaticIds = (List) generalMap.get("antibiaticIds");
		organismId = (Integer) generalMap.get("organismId");
		organismGroupId = (Integer) generalMap.get("organismGroupId");
		changedBy = (Integer) generalMap.get(RequestConstants.HOSPITAL_ID);
		changedDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int hospitalId=(Integer) generalMap.get(RequestConstants.HOSPITAL_ID);
		Session session = (Session) getSession();

		Query deleteQuery = session
				.createQuery("delete from DgOrgDtl where Organism.Id="
						+ organismId + "and OrgGrp.Id="
						+ organismGroupId);
		int row = deleteQuery.executeUpdate();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			for (Integer antibiaticId : antibiaticIds) {
				DgOrgDtl dgOrgDtl = new DgOrgDtl();

				DgMasOrganism dgMasOrganism = new DgMasOrganism();
				dgMasOrganism.setId(organismId);
				dgOrgDtl.setOrganism(dgMasOrganism);

				DgMasOrganismGroup dgMasOrganismGroup = new DgMasOrganismGroup();
				dgMasOrganismGroup.setId(organismGroupId);
				dgOrgDtl.setOrgGrp(dgMasOrganismGroup);

				MasAntibioticLab antibioticLab = new MasAntibioticLab();
				antibioticLab.setId(antibiaticId);
				dgOrgDtl.setAntibioticLab(antibioticLab);

				dgOrgDtl.setStatus("y");
				Users users=new Users(changedBy);
				dgOrgDtl.setLastChgBy(users);
				MasHospital masHospital=new MasHospital(hospitalId);
				dgOrgDtl.setHospital(masHospital);
				dgOrgDtl.setLastChgDate(changedDate);
				dgOrgDtl.setLastChgTime(currentTime);

				hbt.save(dgOrgDtl);
				hbt.refresh(dgOrgDtl);
			}
			dataUpdated = true;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return dataUpdated;
	}

	public Map<String, Object> showOrganismDetailJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		// List<DgOrgDtl> searchOrganismDetailList = new ArrayList<DgOrgDtl>();
		// List<MasAntibioticLab> antibioticList = new
		// ArrayList<MasAntibioticLab>();
		List<DgMasOrganism> organismList = new ArrayList<DgMasOrganism>();

		// searchOrganismDetailList = getHibernateTemplate().find( "from
		// jkt.hms.masters.business.DgOrgDtl ");
		// antibioticList = getHibernateTemplate().find( "from
		// jkt.hms.masters.business.MasAntibioticLab as mc where mc.Status =
		// 'y'");
		organismList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.DgMasOrganism as mc where mc.Status = 'y'");
		// map.put("searchOrganismDetailList",searchOrganismDetailList);
		// map.put("antibioticList",antibioticList);
		map.put("organismList", organismList);
		return map;
	}

	public Map<String, Object> searchOrganismDetail(Map<String, Object> mapForDs) {
		List<DgOrgDtl> organismDetailList = new ArrayList<DgOrgDtl>();
		List<DgOrgGrpDtl> organismGrpDetailList = new ArrayList<DgOrgGrpDtl>();

		List<DgMasOrganism> organismList = new ArrayList<DgMasOrganism>();
		Map<String, Object> returnFieldsMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int organismId = 0;
		int organismGroupId = 0;
		int hospitalId=0;
		

		if (mapForDs.get("organismId") != null) {
			organismId = Integer.parseInt((String) mapForDs.get("organismId"));
		}
		if (mapForDs.get("organismGroupId") != null) {
			organismGroupId = Integer.parseInt((String) mapForDs
					.get("organismGroupId"));
		}
		if (mapForDs.get(RequestConstants.HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt(mapForDs
					.get(RequestConstants.HOSPITAL_ID).toString());
		}

		try {
			if (organismId != 0) {
				Criteria criteria = session.createCriteria(DgOrgDtl.class)
						.createAlias("Organism", "Org")
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("Org.Id", organismId))
						.add(Restrictions.eq("Status", "y"));
				if (organismGroupId != 0) {
					criteria = criteria.add(Restrictions.eq("OrgGrp.Id", organismGroupId));
				}
				organismDetailList = criteria.list();

				criteria = session.createCriteria(DgOrgGrpDtl.class)
						.createAlias("Organism", "Org")
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("Org.Id", organismId))
						.add(Restrictions.eq("Status", "y"));
				organismGrpDetailList = criteria.list();
			}
			Criteria criteria = session.createCriteria(DgMasOrganism.class)
					.add(Restrictions.eq("Status", "y"));
			organismList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		returnFieldsMap.put("organismDetailList", organismDetailList);
		returnFieldsMap.put("organismGrpDetailList", organismGrpDetailList);
		returnFieldsMap.put("organismList", organismList);
		return returnFieldsMap;
	}

	public Map<String, Object> getSensitivityListAutoComplete(
			Map<String, Object> parameterMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<DgMasOrganism> antibioticList = new ArrayList<DgMasOrganism>();

		String str = "";
		if (parameterMap.get("autoHint") != null) {
			str = (String) parameterMap.get("autoHint");
		}
		try {
			Session session = (Session) getSession();
			antibioticList = session
					.createCriteria(MasAntibioticLab.class)
					.add(Restrictions.like("AntibioticLabName", str,
							MatchMode.ANYWHERE).ignoreCase()).list();
			if (antibioticList.size() > 0) {
				detailsMap.put("antibioticList", antibioticList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public boolean deleteOrganismDetail(int detailId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		try {
			int changedBy = 0;
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");

			DgOrgDtl dgOrgDtl = new DgOrgDtl();
			dgOrgDtl = (DgOrgDtl) getHibernateTemplate().get(DgOrgDtl.class,
					detailId);

			changedBy = (Integer) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

			if (generalMap.get("flag") != null) {
				String flag = (String) generalMap.get("flag");
				if (flag.equals("InActivate")) {
					dgOrgDtl.setStatus("n");
					dataDeleted = true;
				} else if (flag.equals("Activate")) {
					dgOrgDtl.setStatus("y");
					dataDeleted = false;
				}
			}
			Users users=new Users(changedBy);
			dgOrgDtl.setLastChgBy(users);
			dgOrgDtl.setLastChgDate(currentDate);
			dgOrgDtl.setLastChgTime(currentTime);

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			try {
				hbt.update(dgOrgDtl);
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return dataDeleted;
	}

	public Map<String, Object> searchOrganismGroupDetail(String organismGroup,int hospitalId) {

		@SuppressWarnings("unchecked")
		List<DgOrgGrpDtl> searchOrganismGroupDetailList = new ArrayList<DgOrgGrpDtl>();
		List<DgMasOrganismGroup> organismGroupList = new ArrayList<DgMasOrganismGroup>();
		List<DgMasOrganism> organismList = new ArrayList<DgMasOrganism>();
		Map<String, Object> dietFieldsMap = new HashMap<String, Object>();
		try {
			if (organismGroup != "") {
				searchOrganismGroupDetailList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.DgOrgGrpDtl as i where upper(i.OrganismGroup.OrganismGroupName) like upper('"
								+ organismGroup
								+ "%') and i.Hospital.Id='"+hospitalId+"' order by i.OrganismGroup.OrganismGroupName ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		organismGroupList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DgMasOrganismGroup as mc");
		organismList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DgMasOrganism as mc ");

		dietFieldsMap.put("searchOrganismGroupDetailList",
				searchOrganismGroupDetailList);
		dietFieldsMap.put("organismGroupList", organismGroupList);
		dietFieldsMap.put("organismList", organismList);

		return dietFieldsMap;

	}

	// --------------------------- methods for diag
	// param-------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showParamJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DiagParam> searchParamList = new ArrayList<DiagParam>();
		List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		List<MasMainChargecode> gridMainChargeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasSubChargecode> gridSubChargeList = new ArrayList<MasSubChargecode>();

		searchParamList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DiagParam ");
		gridMainChargeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMainChargecode as id");
		mainChargeCodeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasMainChargecode as mc where mc.Status = UPPER('y') order by mc.MainChargecodeName");
		gridSubChargeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSubChargecode as id");
		subChargeCodeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasSubChargecode as mc where mc.Status = UPPER('y') order by mc.SubChargecodeName");
		map.put("searchParamList", searchParamList);
		map.put("mainChargeCodeList", mainChargeCodeList);
		map.put("gridMainChargeList", gridMainChargeList);

		map.put("gridSubChargeList", gridSubChargeList);
		map.put("subChargeCodeList", subChargeCodeList);
		return map;
	}

	public boolean addDiagParam(DiagParam diagParam) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(diagParam);
		successfullyAdded = true;
		return successfullyAdded;

	}

	@SuppressWarnings("unchecked")
	public boolean editDiagParam(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		@SuppressWarnings("unused")
		int changedBy = 0;
		int diagId = 0;
		int sequenceNo = 0;
		String prefix = "";
		String criteria = "";

		diagId = (Integer) generalMap.get("id");
		sequenceNo = (Integer) generalMap.get("sequenceNo");
		prefix = (String) generalMap.get("prefix");
		criteria = (String) generalMap.get("criteria");

		changedBy =Integer.parseInt((String) generalMap.get("changedBy")) ;
		Users users=new Users();
		users.setId(changedBy);
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		DiagParam diagParam = (DiagParam) getHibernateTemplate().get(
				DiagParam.class, diagId);
		
		diagParam.setId(diagId);
		diagParam.setSeqNo(sequenceNo);
		diagParam.setPrefix(prefix);
		diagParam.setCriteria(criteria);
		diagParam.setLastChgBy(users);
		diagParam.setLastChgDate(currentDate);
		diagParam.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(diagParam);
		dataUpdated = true;
		return dataUpdated;

	}

	@SuppressWarnings("unchecked")
	public boolean deleteDiagParam(Integer diagId,
			Map<String, Object> generalMap) {

		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		DiagParam diagParam = new DiagParam();
		diagParam = (DiagParam) getHibernateTemplate().get(DiagParam.class,
				diagId);
		@SuppressWarnings("unused")
		Integer mainChargeCodeId = diagParam.getMainCharge().getId();
		Integer subChargeId = diagParam.getSubCharge().getId();
		changedBy = Integer.parseInt(generalMap.get("changedBy").toString());
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		Users users=new Users();
		users.setId(changedBy);
		if (generalMap.get("flag") != null) {
			@SuppressWarnings("unused")
			List mainChargeCodeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasMainChargecode as isc where isc.Id='"
							+ diagId + "' and isc.Status='y'");
			List subChargeCodeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasSubChargecode as isc where isc.Id='"
							+ diagId + "' and isc.Status='y'");
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				diagParam.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				diagParam.setStatus("y");
				dataDeleted = false;
			}
		}
		diagParam.setLastChgBy(users);
		diagParam.setLastChgDate(currentDate);
		diagParam.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(diagParam);
		return dataDeleted;
	}

	public Map<String, Object> getSubchargeList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSubChargecode> subChargecodeList = new ArrayList<MasSubChargecode>();
		subChargecodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DiagParam as mi where  mi.SubCharge.Id = "
						+ box.getInt(RequestConstants.SUB_CHARGECODE_ID)
						+ " and mi.SubCharge.Status ='y'");
		map.put("subChargecodeList", subChargecodeList);
		return map;
	}

	@SuppressWarnings({ "unchecked", "unchecked" })
	public Map searchSubChargeInDiagParam(String subChargecodeCode,
			String subChargecodeName) {

		List<DiagParam> searchParamList = new ArrayList<DiagParam>();
		List mainChargeCodeList = null;
		Map subChargeFieldsMap = new HashMap();
		List gridMainChargeList = null;
		List<MasSubChargecode> subChargeCodeList = null;
		List<MasSubChargecode> gridSubChargeList = null;
		try {
			if ((subChargecodeName != null) || (subChargecodeCode == null)) {

				searchParamList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.DiagParam sc where sc.SubCharge.SubChargecodeName like '"
								+ subChargecodeName
								+ "%' order by sc.SubCharge.SubChargecodeName");
			} else {

				searchParamList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.DiagParam sc where sc.SubCharge.SubChargecodeCode like '"
								+ subChargecodeCode
								+ "%' order by sc.SubCharge.SubChargecodeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		mainChargeCodeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasMainChargecode as mc where mc.Status = 'y'");
		gridMainChargeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasMainChargecode as mainChargecodeCode");
		gridSubChargeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSubChargecode as id");
		subChargeCodeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasSubChargecode as mc where mc.Status = 'y'");
		subChargeFieldsMap.put("gridMainChargeList", gridMainChargeList);
		subChargeFieldsMap.put("searchParamList", searchParamList);
		subChargeFieldsMap.put("mainChargeCodeList", mainChargeCodeList);
		subChargeFieldsMap.put("gridSubChargeList", gridSubChargeList);
		subChargeFieldsMap.put("subChargeCodeList", subChargeCodeList);
		return subChargeFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public List<DgOrgGrpDtl> checkExisitingOrgGrpDt(
			Map<String, Object> generalMap) {
		List<DgOrgGrpDtl> orgGrpDtList = new ArrayList<DgOrgGrpDtl>();
		int organismGroupId = 0;
		int organismId = 0;
		if (generalMap.get("organismGroupId") != null) {
			organismGroupId = (Integer) generalMap.get("organismGroupId");
		}
		if (generalMap.get("organismId") != null) {
			organismId = (Integer) generalMap.get("organismId");
		}
		Session session = (Session) getSession();
		orgGrpDtList = session.createCriteria(DgOrgGrpDtl.class)
				.createAlias("Organism", "org")
				.add(Restrictions.eq("org.Id", organismId))
				.createAlias("OrganismGroup", "orgGrp")
				.add(Restrictions.eq("orgGrp.Id", organismGroupId)).list();

		return orgGrpDtList;
	}

	@Override
	public Map<String, Object> showAnalyzerParameterJsp(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session=(Session)getSession();
		List<MasAnalyzerParameter> searchAnalyzerParameterList = new ArrayList<MasAnalyzerParameter>();
		searchAnalyzerParameterList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasAnalyzerParameter ");
		map.put("searchAnalyzerParameterList", searchAnalyzerParameterList);
		
		return map;
	}

	@Override
	public Map<String, Object> checkForExistingAnalyzerParameterId(
			Map<String, Object> generalMap) {
		Session session=(Session)getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List duplicateChargeCodeNameList = new ArrayList();
		String machineName = (String) generalMap.get("machineName");
		String parameterName = (String) generalMap.get("parameterName");
		int analyzerParameterId= (Integer) generalMap.get("id");
		try {
			
			
			
			duplicateChargeCodeNameList = 
					session.createCriteria(MasAnalyzerParameter.class).add(Restrictions.eq("MachineName", machineName))
					.add(Restrictions.eq("ParameterName", parameterName))
					.add(Restrictions.ne("Id", analyzerParameterId))
					.list();
			map.put("duplicateChargeCodeNameList", duplicateChargeCodeNameList);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return map;}

	@Override
	public boolean editAnalyzerParameter(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		
		int analyzerParameterId = 0;
		int changedBy = 0;
		analyzerParameterId = (Integer) generalMap.get("id");
		String machineName = (String) generalMap.get("machineName");
		String parameterName = (String) generalMap.get("parameterName");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasAnalyzerParameter masAnalyzerParameter = (MasAnalyzerParameter) getHibernateTemplate().get(
				MasAnalyzerParameter.class, analyzerParameterId);

		


		masAnalyzerParameter.setMachineName(machineName);
		masAnalyzerParameter.setParameterName(parameterName);
		
		masAnalyzerParameter.setStatus("y");
		Users users = new Users();
		users.setId(changedBy);
		masAnalyzerParameter.setLastChgBy(users);
		masAnalyzerParameter.setLastChgDate(currentDate);
		masAnalyzerParameter.setLastChgTime(currentTime);
		
		
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAnalyzerParameter);
		dataUpdated = true;
		return dataUpdated;
	}

	@Override
	public boolean deleteAnalyzerParameter(int analyzerParameterId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasAnalyzerParameter masAnalyzerParameter = new MasAnalyzerParameter();
		masAnalyzerParameter = (MasAnalyzerParameter) getHibernateTemplate().get(
				MasAnalyzerParameter.class, analyzerParameterId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masAnalyzerParameter.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masAnalyzerParameter.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user= new Users();
		user.setId(changedBy);
		masAnalyzerParameter.setLastChgBy(user);
		masAnalyzerParameter.setLastChgDate(currentDate);
		masAnalyzerParameter.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAnalyzerParameter);
		return dataDeleted;
	}

	@Override
	public Map<String, Object> searchAnalyzerParameter(String parameterName,
			String machineName, int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<MasAnalyzerParameter> searchAnalyzerParameterList = new ArrayList<MasAnalyzerParameter>();
		Session session=(Session)getSession();
		try {
			if ((parameterName != null) || (machineName == null)) {
				searchAnalyzerParameterList = session.createCriteria(MasServiceCentreCounter.class)
						.add(Restrictions.like("ParameterName", parameterName)).list();
			} else {
				searchAnalyzerParameterList = session.createCriteria(MasAnalyzerParameter.class).add(Restrictions.like("MachineName", machineName))
						.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		map.put("searchAnalyzerParameterList", searchAnalyzerParameterList);
		return map;
	}

	@Override
	public Map<String, Object> checkForExistingAnalyzerParameter(
			Map<String, Object> generalMap) {
		

		Session session=(Session)getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List duplicateChargeCodeNameList = new ArrayList();
		String machineName = (String) generalMap.get("machineName");
		String parameterName = (String) generalMap.get("parameterName");
		try {
			
			
			
			duplicateChargeCodeNameList = 
					session.createCriteria(MasAnalyzerParameter.class).add(Restrictions.eq("MachineName", machineName))
					.add(Restrictions.eq("ParameterName", parameterName))
					.list();
			map.put("duplicateChargeCodeNameList", duplicateChargeCodeNameList);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return map;

	
		

	}

	@Override
	public boolean addAnalyzerParameter(
			MasAnalyzerParameter masAnalyzerParameter) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masAnalyzerParameter);
		successfullyAdded = true;
		return successfullyAdded;
	
		
	
	}


}
