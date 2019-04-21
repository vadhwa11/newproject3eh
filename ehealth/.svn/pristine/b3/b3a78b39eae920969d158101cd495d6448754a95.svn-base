package jkt.hms.masters.dataservice;

import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.COMMON_ID;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jkt.hms.masters.business.EmpScMapping;
import jkt.hms.masters.business.HrCommitteeHeader;
import jkt.hms.masters.business.HrInstEmpDept;
import jkt.hms.masters.business.HrInstitutionalSanctionedPost;
import jkt.hms.masters.business.HrMasSanctionedPostOrder;
import jkt.hms.masters.business.MasAccountSchedule;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAdmissionType;
import jkt.hms.masters.business.MasAnswers;
import jkt.hms.masters.business.MasBranch;
import jkt.hms.masters.business.MasCadre;
import jkt.hms.masters.business.MasCaste;
import jkt.hms.masters.business.MasCharityType;
import jkt.hms.masters.business.MasCompany;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasCurrency;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDisposal;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasDocument;
import jkt.hms.masters.business.MasEmpCategory;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasGrade;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHospitalType;
import jkt.hms.masters.business.MasInstituteDepartment;
import jkt.hms.masters.business.MasLsg;
import jkt.hms.masters.business.MasLsgType;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasOccupation;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasPostCode;
import jkt.hms.masters.business.MasQuestionAnswers;
import jkt.hms.masters.business.MasQuestions;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasReference;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasReligion;
import jkt.hms.masters.business.MasSpecialOfficial;
import jkt.hms.masters.business.MasSpecialityDeptGroup;
import jkt.hms.masters.business.MasSpecialityDeptGroupValue;
import jkt.hms.masters.business.MasSpecialityGroup;
import jkt.hms.masters.business.MasSpecialityHeading;
import jkt.hms.masters.business.MasSpecialityParameter;
import jkt.hms.masters.business.MasSpecialtyGroupParameter;
import jkt.hms.masters.business.MasSpecialtyTemplate;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasStream;
import jkt.hms.masters.business.MasTaluk;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasUnitOfMeasurement;
import jkt.hms.masters.business.MasVillage;
import jkt.hms.masters.business.MasWard;
import jkt.hms.masters.business.PhMasElectricalSection;
import jkt.hms.masters.business.PhMasLocality;
import jkt.hms.masters.business.PhMasPanchayat;
import jkt.hms.masters.business.PhMasParliyamentAssembly;
import jkt.hms.masters.business.PhMaster;
import jkt.hms.masters.business.PhMasterData;
import jkt.hms.masters.business.SpDeptGroupM;
import jkt.hms.masters.business.SpDeptGroupT;
import jkt.hms.masters.business.SpecialtyDepartmentDetails;
import jkt.hms.masters.business.UserHospital;
import jkt.hms.masters.business.UserSpecialityTemplate;
/*import jkt.hms.masters.business.SpDeptGroupM;
import jkt.hms.masters.business.SpDeptGroupT;*/
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.MasEmployeeDepartment;

import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hrms.masters.business.MasQualification;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/*import jkt.hms.masters.business.SpDeptGroupM;
import jkt.hms.masters.business.SpDeptGroupT;*/

public class GeneralMasterDataServiceImpl extends HibernateDaoSupport implements
		GeneralMasterDataService {
	Map<String, Object> map = new HashMap<String, Object>();

	// ---------------------------------------Title-------------------------
	
	private static final Logger logger = Logger.getLogger(GeneralMasterDataServiceImpl.class);
	
	
	public boolean addTitle(MasTitle masTitle) {

		boolean successfullyAdded = false;
		Transaction tnx=null;
		Session session=(Session) getSession();
		try{
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		tnx=session.beginTransaction();
		
		hbt.save(masTitle);
		tnx.commit();
		session.flush();
		successfullyAdded = true;
		}catch(Exception e){
			tnx.rollback();
			e.printStackTrace();
			
		}
		return successfullyAdded;
	}

	public boolean editTitleToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String titleName = "";
		@SuppressWarnings("unused")
		String titleCode = "";
		int titleId = 0;
		String changedBy = "";
		try {
			titleId = (Integer) generalMap.get("id");
			titleCode = (String) generalMap.get("titleCode");
			titleName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			e.printStackTrace();
		}

		MasTitle masTitle = (MasTitle) getHibernateTemplate().get(
				MasTitle.class, titleId);

		masTitle.setId(titleId);
		masTitle.setTitleName(titleName);
		//masTitle.setLastChgBy(changedBy);
		masTitle.setLastChgDate(currentDate);
		masTitle.setLastChgTime(currentTime);
		masTitle.setStatus("Y");
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masTitle);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchTitle(String titleCode, String titleName) {
		List<MasTitle> searchTitleList = new ArrayList<MasTitle>();
		Map<String, Object> titleFieldsMap = new HashMap<String, Object>();
		try {
			if ((titleName != null) || (titleCode == null)) {

				searchTitleList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasTitle imc where imc.TitleName like '"
								+ titleName + "%' order by imc.TitleName");
			} else {
				searchTitleList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasTitle imc where imc.TitleCode like '"
								+ titleCode + "%' order by imc.TitleCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		titleFieldsMap.put("searchTitleList", searchTitleList);
		return titleFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showTitleJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTitle> searchTitleList = new ArrayList<MasTitle>();
		searchTitleList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasTitle ");
		map.put("searchTitleList", searchTitleList);
		return map;
	}

	public boolean deleteTitle(int titleId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasTitle masTitle = new MasTitle();
		masTitle = (MasTitle) getHibernateTemplate().get(MasTitle.class,
				titleId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masTitle.setStatus("N");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masTitle.setStatus("Y");
				dataDeleted = false;
			}
		}
		//masTitle.setLastChgBy(changedBy);
		masTitle.setLastChgDate(currentDate);
		masTitle.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masTitle);
		return dataDeleted;
	}

	// ------------------------------------------------- Relation
	// ---------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showRelationJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRelation> searchRelationList = new ArrayList<MasRelation>();
		searchRelationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRelation ");
		map.put("searchRelationList", searchRelationList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchRelation(String relationCode,
			String relationName) {
		List<MasRelation> searchRelationList = new ArrayList<MasRelation>();
		Map<String, Object> relationFieldsMap = new HashMap<String, Object>();
		try {
			if ((relationName != null) || (relationCode == null)) {
				searchRelationList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasRelation mr where mr.RelationName like '"
								+ relationName + "%' order by mr.RelationName");
			} else {
				searchRelationList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasRelation mr where mr.RelationCode like '"
								+ relationCode + "%' order by mr.RelationCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		relationFieldsMap.put("searchRelationList", searchRelationList);
		return relationFieldsMap;
	}

	public boolean addRelation(MasRelation masRelation) {
		boolean successfullyAdded = false;
		Transaction tnx=null;
		Session session=(Session) getSession();
		try{
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		tnx=session.beginTransaction();
		hbt.save(masRelation);
		tnx.commit();
		session.flush();
		successfullyAdded = true;
		}catch(Exception e){
			tnx.rollback();
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	public boolean editRelationToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String relationName = "";
		@SuppressWarnings("unused")
		String relationCode = "";
		int relationId = 0;
		String changedBy = "";
		relationId = (Integer) generalMap.get("id");
		relationCode = (String) generalMap.get("relationCode");
		relationName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasRelation masRelation = (MasRelation) getHibernateTemplate().get(
				MasRelation.class, relationId);

		masRelation.setId(relationId);
		masRelation.setRelationName(relationName);
		//masRelation.setLastChgBy(changedBy);
		masRelation.setLastChgDate(currentDate);
		masRelation.setLastChgTime(currentTime);
		masRelation.setStatus("Y");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masRelation);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteRelation(int relationId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasRelation masRelation = new MasRelation();
		masRelation = (MasRelation) getHibernateTemplate().get(
				MasRelation.class, relationId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masRelation.setStatus("N");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masRelation.setStatus("Y");
				dataDeleted = false;
			}
		}
		//masRelation.setLastChgBy(changedBy);
		masRelation.setLastChgDate(currentDate);
		masRelation.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masRelation);
		return dataDeleted;
	}

	// ------------------------------------Religion---------------------------------------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showReligionJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasReligion> searchReligionList = new ArrayList<MasReligion>();
		searchReligionList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasReligion ");
		map.put("searchReligionList", searchReligionList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchReligion(String religionCode,
			String religionName) {
		List<MasReligion> searchReligionList = new ArrayList<MasReligion>();
		Map<String, Object> religionFieldsMap = new HashMap<String, Object>();
		try {
			if ((religionName != null) || (religionCode == null)) {
				searchReligionList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasReligion mr where mr.ReligionName like '"
								+ religionName + "%' order by mr.ReligionName");
			} else {
				searchReligionList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasReligion mr where mr.ReligionCode like '"
								+ religionCode + "%' order by mr.ReligionCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		religionFieldsMap.put("searchReligionList", searchReligionList);
		return religionFieldsMap;
	}

	public boolean addReligion(MasReligion masReligion) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masReligion);
		hbt.flush();
		hbt.refresh
		(masReligion);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteReligion(int religionId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasReligion masReligion = new MasReligion();
		masReligion = (MasReligion) getHibernateTemplate().get(
				MasReligion.class, religionId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masReligion.setStatus("N");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masReligion.setStatus("Y");
				dataDeleted = false;
			}
		}
	//	masReligion.setLastChgBy(changedBy);
		masReligion.setLastChgDate(currentDate);
		masReligion.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masReligion);
		return dataDeleted;
	}

	public boolean editReligionToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String religionName = "";
		@SuppressWarnings("unused")
		String religionCode = "";
		int religionId = 0;
		String changedBy = "";
		religionId = (Integer) generalMap.get("id");
		religionCode = (String) generalMap.get("religionCode");
		religionName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasReligion masReligion = (MasReligion) getHibernateTemplate().get(
				MasReligion.class, religionId);
		masReligion.setId(religionId);
		masReligion.setReligionName(religionName);
	//	masReligion.setLastChgBy(changedBy);
		masReligion.setLastChgDate(currentDate);
		masReligion.setLastChgTime(currentTime);
		masReligion.setStatus("Y");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masReligion);
		dataUpdated = true;
		return dataUpdated;
	}

	// ------------------------------------Marital Status
	// ---------------------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMaritalStatusJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasMaritalStatus> searchMaritalStatusList = new ArrayList<MasMaritalStatus>();
		searchMaritalStatusList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMaritalStatus");
		map.put("searchMaritalStatusList", searchMaritalStatusList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchMaritalStatus(String maritalStatusCode,
			String maritalStatusName) {
		List<MasMaritalStatus> searchMaritalStatusList = new ArrayList<MasMaritalStatus>();
		Map<String, Object> maritalStatusFieldsMap = new HashMap<String, Object>();
		try {
			if ((maritalStatusName != null) || (maritalStatusCode == null)) {
				searchMaritalStatusList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasMaritalStatus sc where sc.MaritalStatusName like '"
								+ maritalStatusName
								+ "%' order by sc.MaritalStatusName");
			} else {
				searchMaritalStatusList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasMaritalStatus sc where sc.MaritalStatusCode like '"
								+ maritalStatusCode
								+ "%' order by sc.MaritalStatusCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		maritalStatusFieldsMap.put("searchMaritalStatusList",
				searchMaritalStatusList);
		return maritalStatusFieldsMap;
	}
/*
 * 
	public boolean addTitle(MasTitle masTitle) {

		boolean successfullyAdded = false;
		Transaction tnx=null;
		Session session=(Session) getSession();
		try{
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		tnx=session.beginTransaction();
		
		hbt.save(masTitle);
		tnx.commit();
		session.flush();
		successfullyAdded = true;
		}catch(Exception e){
			tnx.rollback();
			e.printStackTrace();
			
		}
		return successfullyAdded;
	}
 * */
	public boolean addMaritalStatus(MasMaritalStatus masMaritalStatus) {
		boolean successfullyAdded = false;
		Transaction tnx=null;
		Session session=(Session) getSession();
		try{
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		tnx=session.beginTransaction();
		
		hbt.save(masMaritalStatus);
		tnx.commit();
		session.flush();
		successfullyAdded = true;
		}catch(Exception e){
			tnx.rollback();
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	public boolean deleteMaritalStatus(int maritalStatusId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasMaritalStatus masMaritalStatus = new MasMaritalStatus();
		masMaritalStatus = (MasMaritalStatus) getHibernateTemplate().get(
				MasMaritalStatus.class, maritalStatusId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masMaritalStatus.setStatus("N");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masMaritalStatus.setStatus("Y");
				dataDeleted = false;
			}
		}
		//masMaritalStatus.setLastChgBy(changedBy);
		masMaritalStatus.setLastChgDate(currentDate);
		masMaritalStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masMaritalStatus);
		return dataDeleted;
	}

	public boolean editMaritalStatusToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String maritalStatusName = "";
		@SuppressWarnings("unused")
		String maritalStatusCode = "";
		int maritalStatusId = 0;
		String changedBy = "";
		maritalStatusId = (Integer) generalMap.get("id");
		maritalStatusCode = (String) generalMap.get("maritalStatusCode");
		maritalStatusName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasMaritalStatus masMaritalStatus = (MasMaritalStatus) getHibernateTemplate()
				.get(MasMaritalStatus.class, maritalStatusId);
		masMaritalStatus.setId(maritalStatusId);
		masMaritalStatus.setMaritalStatusName(maritalStatusName);
		//masMaritalStatus.setLastChgBy(changedBy);
		masMaritalStatus.setLastChgDate(currentDate);
		masMaritalStatus.setLastChgTime(currentTime);
		masMaritalStatus.setStatus("Y");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masMaritalStatus);
		dataUpdated = true;
		return dataUpdated;
	}

	// -----------------------------------------Disposal----------------------------------------

	public Map<String, Object> showDisposalJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDisposal> searchDisposalList = new ArrayList<MasDisposal>();
		searchDisposalList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDisposal ");
		map.put("searchDisposalList", searchDisposalList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDisposal(String disposalCode,
			String disposalName) {
		List<MasDisposal> searchDisposalList = new ArrayList<MasDisposal>();
		Map disposalFieldsMap = new HashMap();
		try {
			if ((disposalName != null) || (disposalCode == null)) {
				searchDisposalList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDisposal md where md.DisposalName like '"
								+ disposalName + "%' order by md.DisposalName");
			} else {
				searchDisposalList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDisposal md where md.DisposalCode like '"
								+ disposalCode + "%' order by md.DisposalCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposalFieldsMap.put("searchDisposalList", searchDisposalList);
		return disposalFieldsMap;
	}

	public boolean addDisposal(MasDisposal masDisposal) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDisposal);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteDisposal(int disposalId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasDisposal masDisposal = new MasDisposal();
		masDisposal = (MasDisposal) getHibernateTemplate().get(
				MasDisposal.class, disposalId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDisposal.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDisposal.setStatus("y");
				dataDeleted = false;
			}
		}
		masDisposal.setLastChgBy(changedBy);
		masDisposal.setLastChgDate(currentDate);
		masDisposal.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDisposal);
		return dataDeleted;
	}

	public boolean editDisposalToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String disposalName = "";
		@SuppressWarnings("unused")
		String disposalCode = "";
		int disposalId = 0;
		String changedBy = "";
		disposalId = (Integer) generalMap.get("id");
		disposalCode = (String) generalMap.get("disposalCode");
		disposalName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasDisposal masDisposal = (MasDisposal) getHibernateTemplate().get(
				MasDisposal.class, disposalId);

		masDisposal.setId(disposalId);
		masDisposal.setDisposalName(disposalName);
		masDisposal.setLastChgBy(changedBy);
		masDisposal.setLastChgDate(currentDate);
		masDisposal.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDisposal);
		dataUpdated = true;
		return dataUpdated;
	}

	// ---------------------Admission
	// Type--------------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showAdmissionTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAdmissionType> searchAdmissionTypeList = new ArrayList<MasAdmissionType>();
		searchAdmissionTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasAdmissionType ");
		map.put("searchAdmissionTypeList", searchAdmissionTypeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchAdmissionType(String admissionTypeCode,
			String admissionTypeName) {
		List<MasAdmissionType> searchAdmissionTypeList = new ArrayList<MasAdmissionType>();
		Map admissionTypeFieldsMap = new HashMap();
		try {
			if ((admissionTypeName != null) || (admissionTypeCode == null)) {
				searchAdmissionTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasAdmissionType mat where lower(mat.AdmissionTypeName) like '"
								+ admissionTypeName.toLowerCase()
								+ "%' order by mat.AdmissionTypeName");
			} else {
				searchAdmissionTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasAdmissionType mat where lower(mat.AdmissionTypeCode) like '"
								+ admissionTypeCode.toLowerCase()
								+ "%' order by mat.AdmissionTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		admissionTypeFieldsMap.put("searchAdmissionTypeList",
				searchAdmissionTypeList);
		return admissionTypeFieldsMap;
	}

	public boolean addAdmissionType(MasAdmissionType masAdmissionType) {
		boolean dataSaved = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masAdmissionType);
		dataSaved = true;
		hbt.flush();
		hbt.clear();
		
		return dataSaved;
	}

	public boolean deleteAdmissionType(int admissionTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasAdmissionType masAdmissionType = new MasAdmissionType();
		masAdmissionType = (MasAdmissionType) getHibernateTemplate().get(
				MasAdmissionType.class, admissionTypeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=(Integer)generalMap.get(RequestConstants.USER_ID);

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masAdmissionType.setStatus("N");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masAdmissionType.setStatus("Y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(userId);
		masAdmissionType.setLastChgBy(users);
		masAdmissionType.setLastChgDate(currentDate);
		masAdmissionType.setLastChgTime(currentTime);
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAdmissionType);
		return dataDeleted;
	}

	public boolean editAdmissionTypeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String admissionTypeName = "";
		@SuppressWarnings("unused")
		String admissionTypeCode = "";
		int admissionTypeId = 0;
		String changedBy = "";
		admissionTypeId = (Integer) generalMap.get("id");
		admissionTypeCode = (String) generalMap.get("admissionTypeCode");
		admissionTypeName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=(Integer)generalMap.get(RequestConstants.USER_ID);

		MasAdmissionType masAdmissionType = (MasAdmissionType) getHibernateTemplate()
				.get(MasAdmissionType.class, admissionTypeId);

		masAdmissionType.setId(admissionTypeId);
		masAdmissionType.setAdmissionTypeName(admissionTypeName);

		Users users=new Users();
		users.setId(userId);
		masAdmissionType.setLastChgBy(users);
		masAdmissionType.setLastChgDate(currentDate);
		masAdmissionType.setLastChgTime(currentTime);
		masAdmissionType.setStatus("Y");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAdmissionType);
		dataUpdated = true;
		return dataUpdated;
	}

	// ----------------------------------Administrative
	// Sex-------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showAdministrativeSexJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAdministrativeSex> searchAdministrativeSexList = new ArrayList<MasAdministrativeSex>();
		searchAdministrativeSexList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasAdministrativeSex ");
		map.put("searchAdministrativeSexList", searchAdministrativeSexList);
		return map;
	}

	public boolean addAdministrativeSex(
			MasAdministrativeSex masAdministrativeSex) {
		boolean successfullyAdded = false;
		Transaction tnx=null;
		Session session=(Session) getSession();
		try{
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		tnx=session.beginTransaction();
		
		hbt.save(masAdministrativeSex);
		tnx.commit();
		session.flush();
		successfullyAdded = true;
		}
		catch(Exception e){
			tnx.rollback();e.printStackTrace();
		}
		return successfullyAdded;
	}

	public boolean deleteAdministrativeSex(int administrativeSexId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
		masAdministrativeSex = (MasAdministrativeSex) getHibernateTemplate()
				.get(MasAdministrativeSex.class, administrativeSexId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masAdministrativeSex.setStatus("N");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masAdministrativeSex.setStatus("Y");
				dataDeleted = false;
			}
		}
		//masAdministrativeSex.setLastChgBy(changedBy);
		masAdministrativeSex.setLastChgDate(currentDate);
		masAdministrativeSex.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAdministrativeSex);
		return dataDeleted;
	}

	public boolean editAdministrativeSexToDatabase(
			Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String administrativeSexName = "";
		@SuppressWarnings("unused")
		String administrativeSexCode = "";
		int administrativeSexId = 0;
		String changedBy = "";
		administrativeSexId = (Integer) generalMap.get("id");
		administrativeSexCode = (String) generalMap
				.get("administrativeSexCode");
		administrativeSexName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasAdministrativeSex masAdministrativeSex = (MasAdministrativeSex) getHibernateTemplate()
				.get(MasAdministrativeSex.class, administrativeSexId);

		masAdministrativeSex.setId(administrativeSexId);
		masAdministrativeSex.setAdministrativeSexName(administrativeSexName);
		//masAdministrativeSex.setLastChgBy(changedBy);
		masAdministrativeSex.setLastChgDate(currentDate);
		masAdministrativeSex.setLastChgTime(currentTime);
		masAdministrativeSex.setStatus("Y");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAdministrativeSex);
		dataUpdated = true;
		return dataUpdated;

	}

	public Map<String, Object> searchAdministrativeSex(
			String administrativeSexCode, String administrativeSexName) {
		List<MasAdministrativeSex> searchAdministrativeSexList = new ArrayList<MasAdministrativeSex>();
		Map<String, Object> administrativeSexFieldsMap = new HashMap<String, Object>();
		try {
			if ((administrativeSexName != null)
					|| (administrativeSexCode == null)) {
				searchAdministrativeSexList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasAdministrativeSex imc where imc.AdministrativeSexName like '"
								+ administrativeSexName
								+ "%' order by imc.AdministrativeSexName");
			} else {
				searchAdministrativeSexList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasAdministrativeSex imc where imc.AdministrativeSexCode like '"
								+ administrativeSexCode
								+ "%' order by imc.AdministrativeSexCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		administrativeSexFieldsMap.put("searchAdministrativeSexList",
				searchAdministrativeSexList);
		return administrativeSexFieldsMap;
	}

	// ---------------------------------------Document-------------------------

	public boolean addDocument(MasDocument masDocument) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDocument);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editDocumentToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String documentName = "";
		@SuppressWarnings("unused")
		String documentCode = "";
		int documentId = 0;
		String changedBy = "";
		try {
			documentId = (Integer) generalMap.get("id");
			documentCode = (String) generalMap.get("documentCode");
			documentName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			e.printStackTrace();
		}

		MasDocument masDocument = (MasDocument) getHibernateTemplate().get(
				MasDocument.class, documentId);

		masDocument.setId(documentId);
		masDocument.setDocumentName(documentName);
		masDocument.setStatus("Y");
		masDocument.setLastChgDate(currentDate);
		masDocument.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masDocument);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDocument(String documentCode,
			String documentName) {
		List<MasDocument> searchDocumentList = new ArrayList<MasDocument>();
		Map<String, Object> documentFieldsMap = new HashMap<String, Object>();
		try {
			if ((documentName != null) || (documentCode == null)) {

				searchDocumentList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasDocument imc where imc.DocumentName like '"
								+ documentName + "%' order by imc.DocumentName");
			} else {
				searchDocumentList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasDocument imc where imc.DocumentCode like '"
								+ documentCode + "%' order by imc.DocumentCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		documentFieldsMap.put("searchDocumentList", searchDocumentList);
		return documentFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDocumentJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDocument> searchDocumentList = new ArrayList<MasDocument>();
		searchDocumentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDocument ");
		map.put("searchDocumentList", searchDocumentList);
		return map;
	}

	public boolean deleteDocument(int documentId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasDocument masDocument = new MasDocument();
		masDocument = (MasDocument) getHibernateTemplate().get(
				MasDocument.class, documentId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDocument.setStatus("N");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDocument.setStatus("Y");
				dataDeleted = false;
			}
		}
	//	masDocument.setLastChgBy(changedBy);
		masDocument.setLastChgDate(currentDate);
		masDocument.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masDocument);
		return dataDeleted;
	}

	// ---------------------------------------Occupation-------------------------

	public boolean addOccupation(MasOccupation masOccupation) {

		boolean successfullyAdded = false;
		Transaction tnx=null;
		Session session= (Session) getSession();
		try{
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		tnx=session.beginTransaction();
		hbt.save(masOccupation);
		tnx.commit();
		session.flush();
		successfullyAdded = true;
		}catch(Exception e){
			tnx.rollback();
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	public boolean editOccupationToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String occupationName = "";
		@SuppressWarnings("unused")
		String occupationCode = "";
		int occupationId = 0;
		String changedBy = "";
		try {
			occupationId = (Integer) generalMap.get("id");
			occupationCode = (String) generalMap.get("occupationCode");
			occupationName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			e.printStackTrace();
		}

		MasOccupation masOccupation = (MasOccupation) getHibernateTemplate()
				.get(MasOccupation.class, occupationId);

		masOccupation.setId(occupationId);
		masOccupation.setOccupationName(occupationName);
		//masOccupation.setLastChgBy(changedBy);
		masOccupation.setLastChgDate(currentDate);
		masOccupation.setLastChgTime(currentTime);
		masOccupation.setStatus("Y");
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masOccupation);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchOccupation(String occupationCode,
			String occupationName) {
		List<MasOccupation> searchOccupationList = new ArrayList<MasOccupation>();
		Map<String, Object> occupationFieldsMap = new HashMap<String, Object>();
		try {
			if ((occupationName != null) || (occupationCode == null)) {

				searchOccupationList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasOccupation imc where imc.OccupationName like '"
								+ occupationName
								+ "%' order by imc.OccupationName");
			} else {
				searchOccupationList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasOccupation imc where imc.OccupationCode like '"
								+ occupationCode
								+ "%' order by imc.OccupationCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		occupationFieldsMap.put("searchOccupationList", searchOccupationList);
		return occupationFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showOccupationJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasOccupation> searchOccupationList = new ArrayList<MasOccupation>();
		searchOccupationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasOccupation ");
		map.put("searchOccupationList", searchOccupationList);
		return map;
	}

	public boolean deleteOccupation(int occupationId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasOccupation masOccupation = new MasOccupation();
		masOccupation = (MasOccupation) getHibernateTemplate().get(
				MasOccupation.class, occupationId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masOccupation.setStatus("N");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masOccupation.setStatus("Y");
				dataDeleted = false;
			}
		}
		//masOccupation.setLastChgBy(changedBy);
		masOccupation.setLastChgDate(currentDate);
		masOccupation.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masOccupation);
		return dataDeleted;
	}

	// -------------------------------------------------
	// Caste--------------------------------------

	public boolean addCaste(MasCaste masCaste) {
		boolean successfullyAdded = false;
		Transaction tnx=null;
		Session session =(Session) getSession();
		try{
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		tnx=session.beginTransaction();
		hbt.save(masCaste);
		tnx.commit();
		session.flush();
		successfullyAdded = true;
		}catch(Exception e){
			tnx.rollback();
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchCaste(String casteCode, String casteName) {

		List<MasCaste> searchCasteList = new ArrayList<MasCaste>();
		Map<String, Object> casteFieldsMap = new HashMap<String, Object>();
		try {
			if ((casteName != null) || (casteCode == null)) {
				searchCasteList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasCaste imc where imc.CasteName like '"
								+ casteName + "%' order by imc.CasteName");
			} else {
				searchCasteList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasCaste imc where imc.CasteCode like '"
								+ casteCode + "%' order by imc.CasteCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		casteFieldsMap.put("searchCasteList", searchCasteList);
		return casteFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showCasteJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasCaste> searchCasteList = new ArrayList<MasCaste>();
		searchCasteList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCaste ");
		map.put("searchCasteList", searchCasteList);
		return map;
	}

	public boolean editCasteToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String casteName = "";
		@SuppressWarnings("unused")
		String casteCode = "";
		int casteId = 0;
		String changedBy = "";
		casteId = (Integer) generalMap.get("id");
		casteCode = (String) generalMap.get("casteCode");
		casteName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasCaste masCaste = (MasCaste) getHibernateTemplate().get(
				MasCaste.class, casteId);

		masCaste.setId(casteId);
		masCaste.setCasteName(casteName);
		//masCaste.setLastChgBy(changedBy);
		masCaste.setLastChgDate(currentDate);
		masCaste.setLastChgTime(currentTime);
		masCaste.setStatus("Y");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCaste);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteCaste(int casteId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasCaste masCaste = new MasCaste();
		masCaste = (MasCaste) getHibernateTemplate().get(MasCaste.class,
				casteId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masCaste.setStatus("N");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masCaste.setStatus("Y");
				dataDeleted = false;
			}
		}
		//masCaste.setLastChgBy(changedBy);
		masCaste.setLastChgDate(currentDate);
		masCaste.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCaste);
		return dataDeleted;
	}

	// -------------------------------------------------
	// UnitOfMeasurement-------------------------------------

	public boolean addUnitOfMeasurement(
			MasUnitOfMeasurement masUnitOfMeasurement) {
		boolean successfullyAdded = false;
		Transaction tnx=null;
		Session session =(Session) getSession();
		try{
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		tnx=session.beginTransaction();
		hbt.save(masUnitOfMeasurement);
		tnx.commit();
		session.flush();
		successfullyAdded = true;
		}catch(Exception e){
			tnx.rollback();
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchUnitOfMeasurement(
			String unitOfMeasurementCode, String unitOfMeasurementName) {

		List<MasUnitOfMeasurement> searchUnitOfMeasurementList = new ArrayList<MasUnitOfMeasurement>();
		Map<String, Object> unitOfMeasurementFieldsMap = new HashMap<String, Object>();
		try {
			if ((unitOfMeasurementName != null)
					|| (unitOfMeasurementCode == null)) {
				searchUnitOfMeasurementList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasUnitOfMeasurement imc where imc.UnitOfMeasurementName like '"
								+ unitOfMeasurementName
								+ "%' order by imc.UnitOfMeasurementName");
			} else {
				searchUnitOfMeasurementList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasUnitOfMeasurement imc where imc.UnitOfMeasurementCode like '"
								+ unitOfMeasurementCode
								+ "%' order by imc.UnitOfMeasurementCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		unitOfMeasurementFieldsMap.put("searchUnitOfMeasurementList",
				searchUnitOfMeasurementList);
		return unitOfMeasurementFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showUnitOfMeasurementJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasUnitOfMeasurement> searchUnitOfMeasurementList = new ArrayList<MasUnitOfMeasurement>();
		searchUnitOfMeasurementList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasUnitOfMeasurement ");
		map.put("searchUnitOfMeasurementList", searchUnitOfMeasurementList);
		return map;
	}

	public boolean editUnitOfMeasurementToDatabase(
			Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String unitOfMeasurementName = "";
		@SuppressWarnings("unused")
		String unitOfMeasurementCode = "";
		int unitOfMeasurementId = 0;
		int changedBy = 0;
		unitOfMeasurementId = (Integer) generalMap.get("id");
		unitOfMeasurementCode = (String) generalMap
				.get("unitOfMeasurementCode");
		unitOfMeasurementName = (String) generalMap.get("name");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasUnitOfMeasurement masUnitOfMeasurement = (MasUnitOfMeasurement) getHibernateTemplate()
				.get(MasUnitOfMeasurement.class, unitOfMeasurementId);
		masUnitOfMeasurement.setId(unitOfMeasurementId);
		masUnitOfMeasurement.setUnitOfMeasurementName(unitOfMeasurementName);
		Users user=new Users();
		user.setId(changedBy);
		masUnitOfMeasurement.setLastChgBy(user);
		masUnitOfMeasurement.setLastChgDate(currentDate);
		masUnitOfMeasurement.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masUnitOfMeasurement);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteUnitOfMeasurement(int unitOfMeasurementId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasUnitOfMeasurement masUnitOfMeasurement = new MasUnitOfMeasurement();
		masUnitOfMeasurement = (MasUnitOfMeasurement) getHibernateTemplate()
				.get(MasUnitOfMeasurement.class, unitOfMeasurementId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masUnitOfMeasurement.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masUnitOfMeasurement.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user=new Users();
		user.setId(changedBy);
		masUnitOfMeasurement.setLastChgBy(user);
		masUnitOfMeasurement.setLastChgDate(currentDate);
		masUnitOfMeasurement.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masUnitOfMeasurement);
		return dataDeleted;
	}

	// -----------------------District-------------------------------------------
	//boolean addDistrict(Map<String, Object> districtMap);
	//public boolean addDistrict(MasDistrict masDistrict) {
	public boolean addDistrict(Map<String, Object> districtMap) {
		
		boolean successfullyAdded = false;
		MasDistrict masDistrict=new MasDistrict();
		if(districtMap.get("masDistrict")!=null){
			masDistrict=(MasDistrict)districtMap.get("masDistrict");
		}
		int hospitalId=0;
		if(districtMap.get("hospitalId")!=null){
			hospitalId=(Integer)districtMap.get("hospitalId");
		}
		try{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			hbt.save(masDistrict);
			/*List<HospitalParameters> hospitalParametersList=new ArrayList<HospitalParameters>();
			if(hospitalId>0){
				hospitalParametersList=getHibernateTemplate().find("from jkt.hms.masters.business.HospitalParameters as hp where hp.Hospital.Id='"+hospitalId+"'");
			}
			String talukStatus="";
			String postOfficeStatus="";
			if(hospitalParametersList.size()>0){
				for (HospitalParameters hospitalParameters : hospitalParametersList) {
					if(hospitalParameters.getTaluk()!=null){
						talukStatus=hospitalParameters.getTaluk();
						postOfficeStatus=hospitalParameters.getPostOffice();
					}
				}
			}
			
			 * if talukPOStatus='Y' means save taluk and post office same name of district
			 
			if(!talukStatus.equalsIgnoreCase("y") && !postOfficeStatus.equalsIgnoreCase("y")){
				
				 * Code Automatically save Taluk as District Name and code
				 * Code By Mukesh Narayan Singh
				 * Date 12 July 2010
				 
				MasTaluk masTaluk=new MasTaluk();
				masTaluk.setTalukCode(masDistrict.getDistrictCode());
				masTaluk.setTalukName(masDistrict.getDistrictName());
				masTaluk.setDistrict(masDistrict);
				masTaluk.setStatus("y");
				//masTaluk.setLastChgBy(masDistrict.getLastChgBy());
				masTaluk.setLastChgDate(masDistrict.getLastChgDate());
				masTaluk.setLastChgTime(masDistrict.getLastChgTime());
				//hbt.save(masTaluk);
				
				
				 * Code Automatically save post office as District Name and code
				 * Code By Mukesh Narayan Singh
				 * Date 12 July 2010
				 
				//int pinCode=000000;
				MasPostCode masPostCode=new MasPostCode();
				masPostCode.setPostCode(masDistrict.getDistrictCode());
				masPostCode.setPostCodeName(masDistrict.getDistrictName());
				//masPostCode.setTaluk(masTaluk);
				//masPostCode.setPincode(pinCode);
				masPostCode.setStatus("y");
			//	masPostCode.setLastChgBy(masDistrict.getLastChgBy());
				masPostCode.setLastChgDate(masDistrict.getLastChgDate());
				masPostCode.setLastChgTime(masDistrict.getLastChgTime());
				hbt.save(masPostCode);
			}else if(!talukStatus.equalsIgnoreCase("y") && postOfficeStatus.equalsIgnoreCase("y")){
				
				 * Code Automatically save Taluk as District Name and code
				 * Code By Mukesh Narayan Singh
				 * Date 12 July 2010
				 
				MasTaluk masTaluk=new MasTaluk();
				masTaluk.setTalukCode(masDistrict.getDistrictCode());
				masTaluk.setTalukName(masDistrict.getDistrictName());
				masTaluk.setDistrict(masDistrict);
				masTaluk.setStatus("y");
				//masTaluk.setLastChgBy(masDistrict.getLastChgBy());
				masTaluk.setLastChgDate(masDistrict.getLastChgDate());
				masTaluk.setLastChgTime(masDistrict.getLastChgTime());
				hbt.save(masTaluk);
				System.out.println("OK ADDED");
				
				int pinCode=000000;
				MasPostCode masPostCode=new MasPostCode();
				masPostCode.setPostCode(masDistrict.getDistrictCode());
				masPostCode.setPostCodeName(masDistrict.getDistrictName());
				masPostCode.setTaluk(masTaluk);
				masPostCode.setPincode(pinCode);
				masPostCode.setStatus("y");
				masPostCode.setLastChgBy(masDistrict.getLastChgBy());
				masPostCode.setLastChgDate(masDistrict.getLastChgDate());
				masPostCode.setLastChgTime(masDistrict.getLastChgTime());
				hbt.save(masPostCode);
			}*/
			
			successfullyAdded = true;
		}catch (Exception e) {
			successfullyAdded=false;
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	public boolean editDistrict(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int stateId = 0;
		String districtName = "";
		@SuppressWarnings("unused")
		String districtCode = "";
		int districtId = 0;
		districtId = (Integer) generalMap.get("id");
		districtCode = (String) generalMap.get("districtCode");
		districtName = (String) generalMap.get("name");
		stateId = (Integer) generalMap.get("stateId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=0; 
		userId = (Integer) generalMap.get("userId");
		MasDistrict masDistrict = (MasDistrict) getHibernateTemplate().get(
				MasDistrict.class, districtId);

		masDistrict.setId(districtId);
		masDistrict.setDistrictName(districtName);

		MasState masState = new MasState();
		masState.setId(stateId);
		masDistrict.setState(masState);

		masDistrict.setLastChgDate(currentDate);
		masDistrict.setLastChgTime(currentTime);
		
		
		Users users = new Users();
		users.setId(userId);
		masDistrict.setLastChgBy(users);
		
		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masDistrict);
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
	public Map<String, Object> searchDistrict(String districtCode,
			String districtName) {
		List<MasDistrict> searchDistrictList = new ArrayList<MasDistrict>();
		List<MasState> stateList = new ArrayList<MasState>();
		Map<String, Object> districtFieldsMap = new HashMap<String, Object>();
		List<MasState> gridStateList = new ArrayList<MasState>();
		try {
			if ((districtName != null) || (districtCode == null)) {
				searchDistrictList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasDistrict as dis where dis.DistrictName like '"
								+ districtName + "%' order by dis.DistrictName");
			} else {
				searchDistrictList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasDistrict as dis where dis.DistrictCode like '"
								+ districtCode + "%' order by dis.DistrictCode");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		stateList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasState as isc where isc.Status = 'y' or isc.Status='Y'");
		gridStateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasState as isc");
		districtFieldsMap.put("gridStateList", gridStateList);
		districtFieldsMap.put("searchDistrictList", searchDistrictList);
		districtFieldsMap.put("stateList", stateList);
		
		logger.info("stateList"+stateList.size());
		
		return districtFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDistrict() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDistrict> searchDistrictList = new ArrayList<MasDistrict>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasState> gridStateList = new ArrayList<MasState>();
		try{
			searchDistrictList = getHibernateTemplate().find("from jkt.hms.masters.business.MasDistrict ");
			gridStateList = getHibernateTemplate().find("from jkt.hms.masters.business.MasState as isc where isc.Status = 'y' or isc.Status = 'Y'");
			stateList = getHibernateTemplate().find("from jkt.hms.masters.business.MasState as isc where isc.Status = 'Y' or isc.Status = 'y' ");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		map.put("searchDistrictList", searchDistrictList);
		map.put("stateList", stateList);
		map.put("gridStateList", gridStateList);
		logger.info("stateList"+	stateList.size());
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteDistrict(int districtId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasDistrict masDistrict = new MasDistrict();
		masDistrict = (MasDistrict) getHibernateTemplate().get(
				MasDistrict.class, districtId);
		@SuppressWarnings("unused")
		Integer stateId = masDistrict.getState().getId();
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=0; 
		userId = (Integer) generalMap.get("userId");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			List stateList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasState as isc where isc.Id='"
							+ districtId + "' and isc.Status='y'");
			if (flag.equals("InActivate")) {
				masDistrict.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDistrict.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(userId);
		masDistrict.setLastChgBy(users);
		masDistrict.setLastChgDate(currentDate);
		masDistrict.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDistrict);
		return dataDeleted;
	}

	// ----------------------------------Taluk------------------------------------

	public boolean addTaluk(Map<String, Object>  talukMap) {
		boolean saveFlag = false;
		int hospitalId=0;
		MasTaluk masTaluk=new MasTaluk();
		if(talukMap.get("masTaluk")!=null){
			masTaluk=(MasTaluk)talukMap.get("masTaluk");
		}
		if(talukMap.get("hospitalId")!=null){
			hospitalId=(Integer)talukMap.get("hospitalId");
		}
		int districtId=0;
		districtId = (Integer) talukMap.get("districtId");
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
	
			Session ses = (Session) getSession();
			List<MasDistrict> masDistrictList = ses.createCriteria(MasDistrict.class).add(Restrictions.eq("Id", districtId)).list();
			MasDistrict obj = masDistrictList.get(0);
			int stateId = (Integer)obj.getState().getId();
			if(stateId!=0)
			{
			MasState state = new MasState();
			state.setId(stateId);
			masTaluk.setState(state);
			}else{
				MasState state = new MasState();
				state.setId(0);
				masTaluk.setState(state);
			}
			hbt.save(masTaluk);
			saveFlag = true;
			
		/*	List<HospitalParameters> hospitalParametersList=new ArrayList<HospitalParameters>();
			if(hospitalId>0){
				hospitalParametersList=getHibernateTemplate().find("from jkt.hms.masters.business.HospitalParameters as hp where hp.Hospital.Id='"+hospitalId+"'");
			}
			String talukStatus="";
			String postOfficeStatus="";
			if(hospitalParametersList.size()>0){
				for (HospitalParameters hospitalParameters : hospitalParametersList) {
					if(hospitalParameters.getTaluk()!=null){
						talukStatus=hospitalParameters.getTaluk();
						postOfficeStatus=hospitalParameters.getPostOffice();
					}
				}
			}
			if(!postOfficeStatus.equalsIgnoreCase("y")){
				MasPostCode masPostCode=new MasPostCode();
				masPostCode.setPostCode(masTaluk.getTalukCode());
				masPostCode.setPostCodeName(masTaluk.getTalukName());
				//masPostCode.setTaluk(masTaluk);
				masPostCode.setPincode(0);
				masPostCode.setStatus(masTaluk.getStatus());
		//		masPostCode.setLastChgBy(masTaluk.getLastChgBy());
				masPostCode.setLastChgDate(masTaluk.getLastChgDate());
				masPostCode.setLastChgTime(masTaluk.getLastChgTime());
				hbt.save(masPostCode);
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlag;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteTaluk(int talukId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasTaluk masTaluk = new MasTaluk();
		masTaluk = (MasTaluk) getHibernateTemplate().get(MasTaluk.class,
				talukId);
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=0; 
		userId = (Integer) generalMap.get("userId");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			
			if (flag.equals("InActivate")) {
				masTaluk.setStatus("N");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masTaluk.setStatus("Y");
				dataDeleted = false;
			}
		}
		
	
		Users users = new Users();
		users.setId(userId);
		masTaluk.setLastChgBy(users);
		masTaluk.setLastChgDate(currentDate);
		masTaluk.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masTaluk);
		return dataDeleted;
	}

	public boolean editTaluk(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int districtId = 0;
		String talukName = "";
		String talukCode = "";
		int talukId = 0;
		try {
			talukId = (Integer) generalMap.get("id");
			talukCode = (String) generalMap.get("talukCode");
			talukName = (String) generalMap.get("name");
			districtId = (Integer) generalMap.get("districtId");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			int userId=0; 
			userId = (Integer) generalMap.get("userId");
			MasTaluk masTaluk = (MasTaluk) getHibernateTemplate().get(
					MasTaluk.class, talukId);

			masTaluk.setId(talukId);
			masTaluk.setTalukName(talukName);
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtId);
			masTaluk.setDistrict(masDistrict);
			Session ses = (Session) getSession();
			List<MasDistrict> masDistrictList = ses.createCriteria(MasDistrict.class).add(Restrictions.eq("Id", districtId)).list();
			MasDistrict obj = masDistrictList.get(0);
			int stateId = (Integer)obj.getState().getId();
			
			
			if(stateId!=0)
			{
			MasState state = new MasState();
			state.setId(stateId);
			masTaluk.setState(state);
			}else{
				MasState state = new MasState();
				state.setId(0);
				masTaluk.setState(state);
			}
			
			masTaluk.setLastChgDate(currentDate);
			
			Users users = new Users();
			users.setId(userId);
			masTaluk.setLastChgBy(users);
			
			masTaluk.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masTaluk);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchTaluk(String talukCode, String talukName) {
		List masTalukList = new ArrayList();
		List masDistrictList = new ArrayList();
		Map<String, Object> talukFieldMap = new HashMap<String, Object>();
		List gridTalukList = new ArrayList();

		try {
			if ((talukName != null) || (talukCode == null)) {
				masTalukList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasTaluk sc where sc.TalukName like '"
								+ talukName + "%' order by sc.TalukName");
			} else {
				masTalukList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasTaluk sc where sc.TalukCode like '"
								+ talukCode + "%' order by sc.TalukCode");
			}
		} catch (Exception e) {
		}
		masDistrictList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDistrict as mit where mit.Status = 'Y'");
		gridTalukList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDistrict as MasDistrict");
		talukFieldMap.put("masTalukList", masTalukList);
		talukFieldMap.put("masDistrictList", masDistrictList);
		talukFieldMap.put("gridTalukList", gridTalukList);
		return talukFieldMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showTaluk() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTaluk> masTalukList = new ArrayList<MasTaluk>();
		List<MasDistrict> masDistrictList = new ArrayList<MasDistrict>();
		List<MasTaluk> gridTalukList = new ArrayList<MasTaluk>();
		masTalukList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasTaluk");
		masDistrictList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDistrict as mit where mit.Status = 'Y' or Status='y' ");
		gridTalukList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDistrict as MasDistrict");
		map.put("masTalukList", masTalukList);
		map.put("masDistrictList", masDistrictList);
		map.put("gridTalukList", gridTalukList);
		return map;
	}

	// ----------------------------Post Code---------------------------------
	/*
	 * public boolean addReference(MasReference masReference) {
		boolean successfullyAdded = false;
		Transaction tnx=null;
		Session session =(Session) getSession();
		try{
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		tnx=session.beginTransaction();
		hbt.save(masReference);
		tnx.commit();
		session.flush();
		successfullyAdded = true;
		}catch(Exception e){
			tnx.rollback();
			e.printStackTrace();
		}
		return successfullyAdded;
	}
	 * */

	public boolean addPostCode(MasPostCode masPostCode) {
		boolean successfullyAdded = false;
		Transaction tnx=null;
		Session session =(Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			tnx=session.beginTransaction();
			hbt.save(masPostCode);
			tnx.commit();
			session.flush();
			successfullyAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deletePostCode(int postCodeId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		int userId=0;
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasPostCode masPostCode = new MasPostCode();
		masPostCode = (MasPostCode) getHibernateTemplate().load(
				MasPostCode.class, postCodeId);
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
				if (flag.equals("InActivate")) {
				masPostCode.setStatus("N");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masPostCode.setStatus("Y");
				dataDeleted = false;
			}
		}

	
		Users users = new Users();
		users.setId(userId);
		masPostCode.setLastChgBy(users);
		masPostCode.setLastChgDate(currentDate);
		masPostCode.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masPostCode);
		return dataDeleted;
	}

	public boolean editPostCode(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int districtId = 0;
		String postCodeName = "";
		@SuppressWarnings("unused")
		
		int postCodeId = 0;
		int userId=0;
		int pinCode = 0;
		try {
			postCodeId = (Integer) generalMap.get("id");
			postCodeName = (String) generalMap.get("name");
			districtId = (Integer) generalMap.get("districtId");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			pinCode = (Integer) generalMap.get("pinCode");
			userId = (Integer) generalMap.get("userId");
			MasPostCode masPostCode = (MasPostCode) getHibernateTemplate()
					.load(MasPostCode.class, postCodeId);

			masPostCode.setId(postCodeId);
			masPostCode.setPostCodeName(postCodeName);
			
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtId);
			masPostCode.setDistrictId(masDistrict);
			
				masPostCode.setPinCode(pinCode);
		
			Users users = new Users();
			users.setId(userId);
			masPostCode.setLastChgBy(users);
			
			masPostCode.setLastChgDate(currentDate);
			masPostCode.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masPostCode);
			// getHibernateTemplate().update(masPostCode);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchPostCode(String postCodeCode,
			String postCodeName) {

		List masPostCodeList = new ArrayList();
		List<MasDistrict> masDistrictList = new ArrayList<MasDistrict>();
		Map<String, Object> postCodeFieldMap = new HashMap<String, Object>();
		List gridDistrictList = new ArrayList();
		try {
			if ((postCodeName != null) || (postCodeCode == null)) {
				masPostCodeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasPostCode sc where sc.PostCodeName like '"
								+ postCodeName + "%' order by sc.PostCodeName");
			} else {
				masPostCodeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasPostCode sc where sc.PostCode like '"
								+ postCodeCode + "%' order by sc.PostCode");
			}
		} catch (Exception e) {
		}
		masDistrictList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDistrict as mit");
		gridDistrictList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDistrict as mit");
		postCodeFieldMap.put("masPostCodeList", masPostCodeList);
		postCodeFieldMap.put("masDistrictList", masDistrictList);
		postCodeFieldMap.put("gridDistrictList", gridDistrictList);
		return postCodeFieldMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showPostCodeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPostCode> masPostCodeList = new ArrayList<MasPostCode>();
		List<MasDistrict> masDistrictList = new ArrayList<MasDistrict>();
		List<MasPostCode> gridDistrictList = new ArrayList<MasPostCode>();

		masPostCodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasPostCode ");
		masDistrictList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDistrict as mit where mit.Status = 'Y' OR mit.Status = 'y' ");
		gridDistrictList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDistrict as mit");
		map.put("masPostCodeList", masPostCodeList);
		map.put("masDistrictList", masDistrictList);
		map.put("gridDistrictList", gridDistrictList);
		
		return map;
	}

	// -----------------------------State ------------------------------------

	public boolean addState(MasState masState) {
		boolean saveFlag = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masState);
			saveFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlag;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteState(int stateId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasState masState = new MasState();
		masState = (MasState) getHibernateTemplate().get(MasState.class,
				stateId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		Integer countryId = masState.getCountry().getId();
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			List mainChargecodeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasCountry as mit where mit.Id='"
							+ countryId + "' and mit.Status='Y'");
			if (flag.equals("InActivate")) {
				masState.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masState.setStatus("y");
				dataDeleted = false;
			}
		}
	//	masState.setLastChgBy(changedBy);
		masState.setLastChgDate(currentDate);
		masState.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masState);
		return dataDeleted;
	}

	public boolean editState(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int countryId = 0;
		String stateName = "";
		@SuppressWarnings("unused")
		String stateCode = "";
		int stateId = 0;
		String changedBy = "";
		try {
			stateId = (Integer) generalMap.get("id");
			stateCode = (String) generalMap.get("stateCode");
			stateName = (String) generalMap.get("name");
			countryId = (Integer) generalMap.get("countryId");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			MasState masState = (MasState) getHibernateTemplate().get(
					MasState.class, stateId);
			masState.setId(stateId);
			masState.setStateName(stateName);
			MasCountry masCountry = new MasCountry();
			masCountry.setId(countryId);
			masState.setCountry(masCountry);
		//	masState.setLastChgBy(changedBy);
			masState.setLastChgDate(currentDate);
			masState.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masState);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchState(String stateCode, String stateName) {

		List masStateList = new ArrayList();
		List masCountryList = new ArrayList();
		Map<String, Object> stateFieldMap = new HashMap<String, Object>();
		List gridStateList = new ArrayList();
		try {
			if ((stateName != null) || (stateCode == null)) {
				masStateList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasState sc where sc.StateName like '"
								+ stateName + "%' order by sc.StateName");
			} else {
				masStateList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasState sc where sc.StateCode like '"
								+ stateCode + "%' order by sc.StateCode");
			}
		} catch (Exception e) {
		}
		masCountryList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasCountry as mit where mit.Status = 'Y'");
		gridStateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCountry as mit");
		stateFieldMap.put("masStateList", masStateList);
	
		stateFieldMap.put("masCountryList", masCountryList);
		stateFieldMap.put("gridStateList", gridStateList);
		return stateFieldMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showStateJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasState> masStateList = new ArrayList<MasState>();
		List<MasCountry> masCountryList = new ArrayList<MasCountry>();
		List<MasState> gridStateList = new ArrayList<MasState>();
		masStateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasState");
		masCountryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCountry as mit where mit.Status = 'y' or mit.Status = 'Y'");
		gridStateList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasCountry as mit");
		map.put("masStateList", masStateList);
		map.put("masCountryList", masCountryList);
		logger.info("masCountryList"+masCountryList.size());
		map.put("gridStateList", gridStateList);
		return map;
	}

	// ---------------------------currency--------------------------------------

	public boolean addCurrency(MasCurrency masCurrency) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masCurrency);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editCurrencyToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String currencyName = "";
		@SuppressWarnings("unused")
		String currencyCode = "";
		int currencyId = 0;
		String changedBy = "";
		currencyId = (Integer) generalMap.get("id");
		currencyCode = (String) generalMap.get("currencyCode");
		currencyName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasCurrency masCurrency = (MasCurrency) getHibernateTemplate().get(
				MasCurrency.class, currencyId);

		masCurrency.setId(currencyId);
		masCurrency.setCurrencyName(currencyName);
		int userId = (Integer)generalMap.get("userId");
		Users user = new Users();
		user.setId(userId);
		masCurrency.setLastChgBy(user);
		masCurrency.setLastChgDate(currentDate);
		masCurrency.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCurrency);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchCurrency(String currencyCode,
			String currencyName) {
		List<MasCurrency> searchCurrencyList = new ArrayList<MasCurrency>();
		Map<String, Object> currencyFieldsMap = new HashMap<String, Object>();
		try {
			if ((currencyName != null) || (currencyCode == null)) {
				searchCurrencyList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasCurrency imc where imc.CurrencyName like '"
								+ currencyName + "%' order by imc.CurrencyName");
			} else {
				searchCurrencyList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasCurrency imc where imc.CurrencyCode like '"
								+ currencyCode + "%' order by imc.CurrencyCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		currencyFieldsMap.put("searchCurrencyList", searchCurrencyList);
		return currencyFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showCurrencyJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasCurrency> searchCurrencyList = new ArrayList<MasCurrency>();
		searchCurrencyList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCurrency ");
		map.put("searchCurrencyList", searchCurrencyList);
		return map;
	}

	public boolean deleteCurrency(int currencyId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasCurrency masCurrency = new MasCurrency();
		masCurrency = (MasCurrency) getHibernateTemplate().get(
				MasCurrency.class, currencyId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masCurrency.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masCurrency.setStatus("y");
				dataDeleted = false;
			}
		}
		int userId = (Integer)generalMap.get("userId");
		Users user = new Users();
		user.setId(userId);
		masCurrency.setLastChgBy(user);
		
		masCurrency.setLastChgDate(currentDate);
		masCurrency.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCurrency);
		return dataDeleted;
	}

	// -----------------------------country----------------------------
	public boolean addCountry(MasCountry masCountry) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masCountry);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteCountry(int countryId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasCountry masCountry = new MasCountry();
		masCountry = (MasCountry) getHibernateTemplate().get(MasCountry.class,
				countryId);
		@SuppressWarnings("unused")
		Integer currencyId = masCountry.getCurrency().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			List currencyList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasCurrency as isc where isc.Id='"
							+ countryId + "' and isc.Status='Y'");
			if (flag.equals("InActivate")) {
				masCountry.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masCountry.setStatus("y");
				dataDeleted = false;
			}
		}
		int userId = (Integer)generalMap.get("userId");
		Users user = new Users();
		user.setId(userId);
		masCountry.setLastChgBy(user);
		masCountry.setLastChgDate(currentDate);
		masCountry.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCountry);
		return dataDeleted;
	}

	public boolean editCountryToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int currencyId = 0;
		String countryName = "";
		@SuppressWarnings("unused")
		String countryCode = "";
		int countryId = 0;
		String changedBy = "";
		countryId = (Integer) generalMap.get("id");
		countryCode = (String) generalMap.get("countryCode");
		countryName = (String) generalMap.get("name");
		currencyId = (Integer) generalMap.get("currencyId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasCountry masCountry = (MasCountry) getHibernateTemplate().load(
				MasCountry.class, countryId);

		masCountry.setId(countryId);
		masCountry.setCountryName(countryName);
		MasCurrency masCurrency = new MasCurrency();
		masCurrency.setId(currencyId);
		masCountry.setCurrency(masCurrency);
		int userId = (Integer)generalMap.get("userId");
		Users user = new Users();
		user.setId(userId);
		masCountry.setLastChgBy(user);
		masCountry.setLastChgDate(currentDate);
		masCountry.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		hbt.update(masCountry);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchCountry(String countryCode,
			String countryName) {
		List<MasCountry> searchCountryList = new ArrayList<MasCountry>();
		List currencyList = null;
		Map<String, Object> countryFieldsMap = new HashMap<String, Object>();
		List gridCurrencyList = null;
		try {
			if ((countryName != null) || (countryCode == null)) {
				searchCountryList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasCountry as i where i.CountryName like '"
								+ countryName + "%' order by i.CountryName");
			} else {
				searchCountryList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasCountry as i where i.CountryCode like '"
								+ countryCode + "%' order by i.CountryCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		currencyList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasCurrency as isc where isc.Status = 'Y'");
		gridCurrencyList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCurrency ");
		countryFieldsMap.put("gridCurrencyList", gridCurrencyList);
		countryFieldsMap.put("searchCountryList", searchCountryList);
		countryFieldsMap.put("currencyList", currencyList);
		return countryFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showCountryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasCountry> searchCountryList = new ArrayList<MasCountry>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		List<MasCurrency> gridCurrencyList = new ArrayList<MasCurrency>();
		searchCountryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCountry ");
		gridCurrencyList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCurrency ");
		currencyList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasCurrency as isc where upper(isc.Status) = 'Y'");
		map.put("searchCountryList", searchCountryList);
		map.put("currencyList", currencyList);
		map.put("gridCurrencyList", gridCurrencyList);
		return map;
	}

	public List<MasTaluk> getTalukList() {
		return null;
	}

	// ---------------------------------Reference----------------------------------
	public boolean addReference(MasReference masReference) {
		boolean successfullyAdded = false;
		Transaction tnx=null;
		Session session =(Session) getSession();
		try{
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		tnx=session.beginTransaction();
		hbt.save(masReference);
		tnx.commit();
		session.flush();
		successfullyAdded = true;
		}catch(Exception e){
			tnx.rollback();
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	public boolean deleteReference(int referenceId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasReference masReference = new MasReference();
		masReference = (MasReference) getHibernateTemplate().get(
				MasReference.class, referenceId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masReference.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masReference.setStatus("y");
				dataDeleted = false;
			}
		}
		//masReference.setLastChgBy(changedBy);
		masReference.setLastChgDate(currentDate);
		masReference.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masReference);
		return dataDeleted;
	}

	public boolean editReferenceToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String referenceName = "";
		@SuppressWarnings("unused")
		String referenceCode = "";
		int referenceId = 0;
		String changedBy = "";
		referenceId = (Integer) generalMap.get("id");
		referenceCode = (String) generalMap.get("referenceCode");
		referenceName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasReference masReference = (MasReference) getHibernateTemplate().load(
				MasReference.class, referenceId);

		masReference.setId(referenceId);
		masReference.setReferenceName(referenceName);
		//masReference.setLastChgBy(changedBy);
		masReference.setLastChgDate(currentDate);
		masReference.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masReference);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchReference(String referenceCode,
			String referenceName) {

		List<MasReference> searchReferenceList = new ArrayList<MasReference>();
		Map<String, Object> referenceFieldsMap = new HashMap<String, Object>();
		try {
			if ((referenceName != null) || (referenceCode == null)) {
				searchReferenceList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasReference imc where imc.ReferenceName like '"
								+ referenceName
								+ "%' order by imc.ReferenceName");
			} else {
				searchReferenceList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasReference imc where imc.ReferenceCode like '"
								+ referenceCode
								+ "%' order by imc.ReferenceCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		referenceFieldsMap.put("searchReferenceList", searchReferenceList);
		return referenceFieldsMap;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showReferenceJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasReference> searchReferenceList = new ArrayList<MasReference>();
		searchReferenceList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasReference ");
		map.put("searchReferenceList", searchReferenceList);
		return map;
	}

	public Map<String, Object> getConnection() {
		Session session = (Session) getSession();
		Connection con = (Connection) session.connection();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("conn", con);
		return map;
	}

	// ----------------------------------Village------------------------------------

	// ----------------------------------Village------------------------------------

	public boolean addVillage(MasVillage masVillage) {
		boolean saveFlag = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masVillage);
			saveFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlag;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteVillage(int villageId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasVillage masVillage = new MasVillage();
		masVillage = (MasVillage) getHibernateTemplate().load(MasVillage.class,
				villageId);
		int userId=0; 
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		//Integer postcodeId = masVillage.getPostCode().getId();

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			/*List villageList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasVillage as mit where mit.Id='"
							+ villageId + "' and mit.Status='Y'");
			*/if (flag.equals("InActivate")) {
				masVillage.setStatus("N");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masVillage.setStatus("Y");
				dataDeleted = false;
			}
		}
		
		Users users=new Users();
		users.setId(userId);
		masVillage.setLastChgBy(users);
		

		masVillage.setLastChgDate(currentDate);
		masVillage.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masVillage);
		return dataDeleted;
	}

	public boolean editVillage(Map<String, Object> generalMap) {

		boolean dataUpdated = false;

		// MasVillage masVillage=new MasVillage();
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int villageId = 0;
		String villageName = "";
		@SuppressWarnings("unused")
		String villageCode = "";
		int postcodeId = 0;
		String changedBy = "";

		try {
			villageId = (Integer) generalMap.get("id");
			villageCode = (String) generalMap.get("villageCode");
			villageName = (String) generalMap.get("name");
			postcodeId = (Integer) generalMap.get("postcodeId");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			int userId=0; 
			userId = (Integer) generalMap.get("userId");
			int hospitalId=0; 
			int talukId=0;
			hospitalId = (Integer) generalMap.get("hospitalId");
			talukId = (Integer) generalMap.get("talukId");
			MasVillage masVillage = (MasVillage) getHibernateTemplate().load(
					MasVillage.class, villageId);

			masVillage.setId(villageId);
			masVillage.setVillageName(villageName);

			/*MasPostCode masPostCode = new MasPostCode();
			masPostCode.setId(postcodeId);
			masVillage.setPostCode(masPostCode);*/

			
			Users users=new Users();
			users.setId(userId);
			masVillage.setLastChgBy(users);
			
			/*MasHospital basicSection= new MasHospital();
			basicSection.setId(hospitalId);
			masVillage.setBasicSection(basicSection);*/

			

			MasTaluk masTaluk= new MasTaluk();
			masTaluk.setId(talukId);
			masVillage.setTaluk(masTaluk);
			
			masVillage.setLastChgDate(currentDate);
			masVillage.setLastChgTime(currentTime);

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masVillage);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchVillage(String villageCode,
			String villageName) {
		List masVillageList = new ArrayList();
		List masPostCodeList = new ArrayList();
		List masHospitalList = new ArrayList();
		List<MasTaluk> masTalukList = new ArrayList<MasTaluk>();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if ((villageName != null) || (villageCode == null)) {
				masVillageList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasVillage sc where sc.VillageName like '"
								+ villageName + "%' order by sc.VillageName");
			} else if (villageCode != null) {
				masVillageList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasVillage sc where sc.VillageCode like '"
								+ villageCode + "%' order by sc.VillageCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		masPostCodeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasPostCode as mit where mit.Status = 'y'");
		masHospitalList= getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospital as b where b.Status = 'y'");
		masTalukList= getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasTaluk as b where b.Status = 'Y'");
		map.put("masVillageList", masVillageList);
		map.put("masPostCodeList", masPostCodeList);
		map.put("masTalukList", masTalukList);
		map.put("masHospitalList", masHospitalList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showVillage() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasVillage> masVillageList = new ArrayList<MasVillage>();
		List<MasPostCode> masPostCodeList = new ArrayList<MasPostCode>();
		List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
		List<MasTaluk> masTalukList = new ArrayList<MasTaluk>();
		masVillageList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasVillage as sc order by sc.VillageName");
		masPostCodeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasPostCode");
		masTalukList= getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasTaluk as b where b.Status = 'Y'");
		masHospitalList= getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospital as b where b.Status = 'y'");
		
		map.put("masVillageList", masVillageList);
		map.put("masPostCodeList", masPostCodeList);
		map.put("masTalukList", masTalukList);
		map.put("masHospitalList", masHospitalList);
		
		return map;
	}

	// -------------------------------Company------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showCompanyJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasCompany> patientTypeList = new ArrayList<MasCompany>();
		List<MasCompany> companyList = new ArrayList<MasCompany>();
		Session session = (Session) getSession();

		patientTypeList = session.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Status", "y")).list();
		companyList = session.createCriteria(MasCompany.class).list();
		if (companyList.size() > 0) {
			map.put("companyList", companyList);
		}
		logger.info("companyList"+companyList.size());
		if (patientTypeList.size() > 0) {
			map.put("patientTypeList", patientTypeList);
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchCompany(String companyCode,
			String companyName) {
		List<MasCompany> companyList = new ArrayList<MasCompany>();
		List<MasPatientType> patientTypeList = new ArrayList<MasPatientType>();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if ((companyName != null) || (companyCode == null)) {
				companyList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasCompany mc where mc.CompanyName like '"
								+ companyName + "%' order by mc.CompanyName");
			} else {
				companyList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasCompany mc where mc.CompanyCode like '"
								+ companyCode + "%' order by mc.CompanyCode");
			}
		} catch (Exception e) {
		}
		Session session = (Session) getSession();
		
		patientTypeList = session.createCriteria(MasPatientType.class).add(Restrictions.eq("Status", "y")).list();
		if (patientTypeList.size() > 0) {
			map.put("patientTypeList", patientTypeList);
		}
		map.put("companyList", companyList);
		return map;
	}

	public boolean addCompanyDetails(MasCompany masCompany) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			hbt.save(masCompany);
			successfullyAdded = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	public boolean updateCompanyDetails(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		String companyName = "";
		int companyId = 0;
		int changedBy = 0;
		int companyType = 0;
		String contactPerson = "";
		String contactNo = "";
		String address = "";
		String coordinatorCode = "";

		companyId = (Integer) generalMap.get("id");
		companyName = (String) generalMap.get("name");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			MasCompany masCompany = (MasCompany) hbt.load(MasCompany.class,
					companyId);

			masCompany.setCompanyName(companyName);
			if (generalMap.get("companyType") != null) {
				companyType = (Integer) generalMap.get("companyType");
				MasPatientType patientType = new MasPatientType();
				patientType.setId(companyType);
				masCompany.setPatientType(patientType);
			}
			if (generalMap.get("contactPerson") != null) {
				contactPerson = (String) generalMap.get("contactPerson");
				masCompany.setContactPerson(contactPerson);
			}
			if (generalMap.get("contactNo") != null) {
				contactNo = (String) generalMap.get("contactNo");
				masCompany.setContactNo(contactNo);
			}
			if (generalMap.get("address") != null) {
				address = (String) generalMap.get("address");
				masCompany.setAddress(address);
			}
			if (generalMap.get("coordinatorCode") != null) {
				coordinatorCode = (String) generalMap.get("coordinatorCode");
				masCompany.setCoordinatorCode(coordinatorCode);
			}
			//masCompany.setLastChgBy(changedBy);
			Users user = new Users();
			user.setId(changedBy);
			masCompany.setLastChgBy(user);
			masCompany.setLastChgDate(currentDate);
			masCompany.setLastChgTime(currentTime);

			try {
				hbt.update(masCompany);
				hbt.refresh(masCompany);
				dataUpdated = true;
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch taluk
			e.printStackTrace();
		}
		return dataUpdated;
	}
	public boolean deleteCompany(int companyId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		MasCompany masCompany = new MasCompany();
		masCompany = (MasCompany) getHibernateTemplate().load(MasCompany.class,companyId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masCompany.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masCompany.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user = new Users();
		user.setId(changedBy);
		masCompany.setLastChgBy(user);
		masCompany.setLastChgDate(currentDate);
		masCompany.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCompany);
		return dataDeleted;
	}

	public Map<String, Object> getHospitalName(Map<String, Object> mapForDs) {
		Map<String, Object> mapResponse = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
		Integer hospitalId = 0;
		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");
		}
		logger.info("hospitalId "+hospitalId);
		try {
			masHospitaList = session.createCriteria(MasHospital.class)
					.add(Restrictions.eq("Id", hospitalId)).add(Restrictions.eq("Status","y").ignoreCase()).list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("masHospitaList "+masHospitaList.size());
		mapResponse.put("masHospitaList", masHospitaList);
		return mapResponse;
	}
	public Map<String, Object> showBranchMasterJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBranch> searchBranchList = new ArrayList<MasBranch>();
		List<MasDepartment>departmentList = new ArrayList<MasDepartment>();
		Session session = (Session)getSession();
		searchBranchList = session.createCriteria(MasBranch.class).list();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("searchBranchList", searchBranchList);
		map.put("departmentList", departmentList);
		
		logger.info("departmentList"+departmentList.size());
		
		return map;
	}
	public boolean addBranch(MasBranch masBranch) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masBranch);
		successfullyAdded = true;
		return successfullyAdded;

	}

	public boolean editBranch(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String branchName = "";
		@SuppressWarnings("unused")
		String branchCode = "";
		int branchId = 0;
		int changedBy = 0;
		int departmentId = 0;
		try {
			branchId = (Integer) generalMap.get("id");
			branchCode = (String) generalMap.get("branchCode");
			branchName = (String) generalMap.get("name");
			changedBy = (Integer) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			departmentId = (Integer) generalMap.get("departmentId");
		} catch (Exception e) {
			e.printStackTrace();
		}

		MasBranch masBranch = (MasBranch) getHibernateTemplate().get(
				MasBranch.class, branchId);

		masBranch.setId(branchId);
		masBranch.setBranchDesc(branchName);
		Users users = new Users();
		//users.setId(changedBy);
		masBranch.setLastChgBy("admin");
		masBranch.setLastChgDate(currentDate);
		masBranch.setLastChgTime(currentTime);
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		masBranch.setDepartment(masDepartment);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masBranch);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}


	public boolean deleteBranch(int branchId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasBranch masBranch = new MasBranch();
		masBranch = (MasBranch) getHibernateTemplate().get(MasBranch.class,
				branchId);
		//changedBy = (String) generalMap.get("changedBy");
		//currentDate = (Date) generalMap.get("currentDate");
		//currentTime = (String) generalMap.get("currentTime");
		//Integer postcodeId = masVillage.getPostCode().getId();

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			List villageList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasBranch as mit where mit.Id='"
							+ branchId + "' and mit.Status='y'");
			if (flag.equals("InActivate")) {
				masBranch.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masBranch.setStatus("y");
				dataDeleted = false;
			}
		}
		//masVillage.setLastChgBy(changedBy);
		//masVillage.setLastChgDate(currentDate);
		//masVillage.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBranch);
		return dataDeleted;
	}
//------------------------------------------ Grade
	//@Override
	public boolean addGrade(MasGrade masGrade) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masGrade);
		successfullyAdded = true;
		return successfullyAdded;
	}

	//@Override
	public Map<String, Object> showGradeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasGrade> searchGradeList = new ArrayList<MasGrade>();
		Session session =(Session)getSession();
		searchGradeList = session.createCriteria(MasGrade.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("searchGradeList", searchGradeList);
		return map;
	}

	//@Override
	public boolean editGradeToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String payScaleCode = "";
		String gradeLevel = "";
		String remarks = "";
		String gradeCode="";
		Date startDate = null;
		Date endDate = null;
		int gradeId = 0;
		int userId = 0;
		gradeId = (Integer) generalMap.get("id");
		payScaleCode = (String) generalMap.get("payScaleCode");
		gradeCode = (String) generalMap.get("gradeCode");
		gradeLevel = (String) generalMap.get("name");
		remarks = (String) generalMap.get("remarks");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		startDate = (Date) generalMap.get("startDate");
		endDate = (Date) generalMap.get("endDate");
		userId = (Integer) generalMap.get("userId");
		MasGrade masGrade = (MasGrade) getHibernateTemplate().load(MasGrade.class,gradeId);

		masGrade.setId(gradeId);
		masGrade.setGradeCode(gradeCode);
		masGrade.setStatus("Y");
		masGrade.setPayScaleCode(payScaleCode);
		masGrade.setGradeLevel(gradeLevel);
		masGrade.setStartDate(startDate);
		masGrade.setEndDate(endDate);
		masGrade.setRemarks(remarks);
		Users users = new Users();
		users.setId(userId);
		masGrade.setLastChgBy(users);
		masGrade.setLastChgDate(currentDate);
		masGrade.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masGrade);
		dataUpdated = true;
		return dataUpdated;
	}

	//@Override
	public boolean deleteGrade(int gradeId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasGrade masGrade = new MasGrade();
		masGrade = (MasGrade) getHibernateTemplate().get(
				MasGrade.class,  gradeId);
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masGrade.setStatus("N");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masGrade.setStatus("Y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(userId);
		masGrade.setLastChgBy(users);
		
		masGrade.setLastChgDate(currentDate);
		masGrade.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masGrade);
		return dataDeleted;
	}

	//@Override
	public Map<String, Object> searchGrade(String gradeCode) {
		List<MasGrade> searchGradeList = new ArrayList<MasGrade>();
		Map<String, Object> unitFieldsMap = new HashMap<String, Object>();
		Session session =(Session)getSession();

		try {
			if ((gradeCode != null)) {
				
				searchGradeList = session.createCriteria(MasGrade.class).add(Restrictions.like("GradeCode", gradeCode).ignoreCase()).addOrder(Order.asc("GradeCode")).list();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		unitFieldsMap.put("searchGradeList", searchGradeList);

		return unitFieldsMap;
	}
	
	
	//@Override
	public Map<String, Object> searchStream(String streamName) {
		List<MasStream> searchStreamList = new ArrayList<MasStream>();
		Map<String, Object> unitFieldsMap = new HashMap<String, Object>();
		Session session =(Session)getSession();

		try {
			if ((streamName != null)) {
				streamName = "%"+ streamName + "%";
				searchStreamList = session.createCriteria(MasStream.class)
						.add(Restrictions.eq("Status","y").ignoreCase())
						.add(Restrictions.like("StreamName",streamName).ignoreCase()).addOrder(Order.asc("StreamName")).list();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		unitFieldsMap.put("searchStreamList", searchStreamList);

		return unitFieldsMap;
	}

	//@Override
	public Map<String, Object> showStreamJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStream> searchStreamList = new ArrayList<MasStream>();
		Session session =(Session)getSession();
		searchStreamList = session.createCriteria(MasStream.class).add(Restrictions.like("Status","y").ignoreCase()).list();
		map.put("searchStreamList", searchStreamList);
		return map;
	}

	//@Override
	public boolean deleteStream(int streamId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStream masStream = new MasStream();
		masStream = (MasStream) getHibernateTemplate().get(
				MasStream.class,  streamId);
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStream.setStatus("N");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStream.setStatus("Y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(userId);
		masStream.setLastChgBy(users);
		
		masStream.setLastChgDate(currentDate);
		masStream.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masStream);
		return dataDeleted;
	}

	//@Override
	public boolean editStreamToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String description = "";
		String streamName="";
		int streamId = 0;
		int userId = 0;
		streamId = (Integer) generalMap.get("id");
		description = (String) generalMap.get("des");
		streamName = (String) generalMap.get("name");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		userId = (Integer) generalMap.get("userId");
		MasStream masStream = (MasStream) getHibernateTemplate().load(MasStream.class,streamId);

		masStream.setId(streamId);
		masStream.setStreamName(streamName);
		masStream.setStatus("Y");
		masStream.setDescription(description);
		Users users = new Users();
		users.setId(userId);
		masStream.setLastChgBy(users);
		masStream.setLastChgDate(currentDate);
		masStream.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStream);
		dataUpdated = true;
		return dataUpdated;
	}

	//@Override
	public boolean addStream(MasStream masStream) {


		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStream);
		successfullyAdded = true;
		return successfullyAdded;
	
		
	}

	//@Override
	public Map<String, Object> searchSpecialOfficial(String specialOfficialName) {
		List<MasSpecialOfficial> searchSpecialOfficialList = new ArrayList<MasSpecialOfficial>();
		Map<String, Object> unitFieldsMap = new HashMap<String, Object>();
		Session session =(Session)getSession();

		try {
			if ((specialOfficialName != null)) {
				specialOfficialName = "%"+ specialOfficialName + "%";
				searchSpecialOfficialList = session.createCriteria(MasSpecialOfficial.class).add(Restrictions.like("SpecialOfficialName",specialOfficialName).ignoreCase()).addOrder(Order.asc("SpecialOfficialName")).list();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		unitFieldsMap.put("searchSpecialOfficialList", searchSpecialOfficialList);

		return unitFieldsMap;
	}

	//@Override
	public Map<String, Object> showSpecialOfficialJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSpecialOfficial> searchSpecialOfficialList = new ArrayList<MasSpecialOfficial>();
		Session session =(Session)getSession();
		searchSpecialOfficialList = session.createCriteria(MasSpecialOfficial.class)
				.add(Restrictions.eq("Status","y").ignoreCase()).list();
		map.put("searchSpecialOfficialList", searchSpecialOfficialList);
		return map;
	}

	//@Override
	public boolean deleteSpecialOfficial(int specialOfficialId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasSpecialOfficial masSpecialOfficial = new MasSpecialOfficial();
		masSpecialOfficial = (MasSpecialOfficial) getHibernateTemplate().get(
				MasSpecialOfficial.class,  specialOfficialId);
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masSpecialOfficial.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masSpecialOfficial.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(userId);
		masSpecialOfficial.setLastChgBy(users);
		
		masSpecialOfficial.setLastChgDate(currentDate);
		masSpecialOfficial.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masSpecialOfficial);
		return dataDeleted;
	}

	//@Override
	public boolean editSpecialOfficialToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String specialOfficialName="";
		int specialOfficialId = 0;
		int userId = 0;
		specialOfficialId = (Integer) generalMap.get("id");
		specialOfficialName = (String) generalMap.get("name");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		userId = (Integer) generalMap.get("userId");
		MasSpecialOfficial masSpecialOfficial = (MasSpecialOfficial) getHibernateTemplate().load(MasSpecialOfficial.class,specialOfficialId);

		masSpecialOfficial.setId(specialOfficialId);
		masSpecialOfficial.setSpecialOfficialName(specialOfficialName);
		masSpecialOfficial.setStatus("y");
		Users users = new Users();
		users.setId(userId);
		masSpecialOfficial.setLastChgBy(users);
		masSpecialOfficial.setLastChgDate(currentDate);
		masSpecialOfficial.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masSpecialOfficial);
		dataUpdated = true;
		return dataUpdated;
	}

	//@Override
	public boolean addSpecialOfficial(MasSpecialOfficial masSpecialOfficial) {


		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masSpecialOfficial);
		successfullyAdded = true;
		return successfullyAdded;
	
		
	}
//----------------------------- Cadre
	



	//@Override
	public Map<String, Object> searchCadre(String cadreName) {
		List<MasCadre> searchCadreList = new ArrayList<MasCadre>();
		Map<String, Object> unitFieldsMap = new HashMap<String, Object>();
		Session session =(Session)getSession();

		try {
			if ((cadreName != null)) {
				cadreName = "%"+ cadreName + "%";
				searchCadreList = session.createCriteria(MasCadre.class).add(Restrictions.like("CadreName",cadreName).ignoreCase()).addOrder(Order.asc("CadreName")).list();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		unitFieldsMap.put("searchCadreList", searchCadreList);

		return unitFieldsMap;
	}

	@SuppressWarnings("unchecked")
	//@Override
	public Map<String, Object> showCadreJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasCadre> searchCadreList = new ArrayList<MasCadre>();
		Session session =(Session)getSession();
		searchCadreList = session.createCriteria(MasCadre.class).addOrder(Order.asc("CadreName")).add(Restrictions.eq("Status","y").ignoreCase()).list();
		map.put("searchCadreList", searchCadreList);
		return map;
	}

	//@Override
	public boolean deleteCadre(int cadreId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasCadre masCadre = new MasCadre();
		masCadre = (MasCadre) getHibernateTemplate().get(
				MasCadre.class,  cadreId);
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masCadre.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masCadre.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(userId);
		masCadre.setLastChgBy(users);
		
		masCadre.setLastChgDate(currentDate);
		masCadre.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masCadre);
		return dataDeleted;
	}

	//@Override
	public boolean editCadreToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String description = "";
		String cadreName="";
		int cadreId = 0;
		int userId = 0;
		int strength=0;
		//int permaPost= 0;
		//int tempPost= 0;
		//int supernumPost=0;
		cadreId = (Integer) generalMap.get("id");
		description = (String) generalMap.get("des");
		cadreName = (String) generalMap.get("name");
		strength= (Integer) generalMap.get("strength");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		userId = (Integer) generalMap.get("userId");
		//permaPost= (Integer) generalMap.get("permaPost");
		//tempPost= (Integer) generalMap.get("tempPost");
		//supernumPost= (Integer) generalMap.get("supernumPost");
		
		MasCadre masCadre = (MasCadre) getHibernateTemplate().load(MasCadre.class,cadreId);

		masCadre.setId(cadreId);
		masCadre.setCadreName(cadreName);
		masCadre.setStatus("y");
		masCadre.setCadreStrength(strength);
		masCadre.setDescription(description);
		//masCadre.setPermanentPost(permaPost);
		//masCadre.setTempPost(tempPost);
		//masCadre.setSupernumeraryPost(supernumPost);
		Users users = new Users();
		users.setId(userId);
		masCadre.setLastChgBy(users);
		masCadre.setLastChgDate(currentDate);
		masCadre.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCadre);
		dataUpdated = true;
		return dataUpdated;
	}

	//@Override
	public boolean addCadre(MasCadre masCadre) {


		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masCadre);
		successfullyAdded = true;
		return successfullyAdded;
	
		
	}

	@SuppressWarnings("unchecked")
	//@Override
	public Map<String, Object> showSanctionPostOrderJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasCadre> cadreList = new ArrayList<MasCadre>();
		List<HrMasSanctionedPostOrder> sanctionedPostOrderList = new ArrayList<HrMasSanctionedPostOrder>();
		Session session =(Session)getSession();
		cadreList = session.createCriteria(MasCadre.class).add(Restrictions.eq("Status", 'y').ignoreCase()).addOrder(Order.asc("CadreName")).list();
		sanctionedPostOrderList = session.createCriteria(HrMasSanctionedPostOrder.class)./*add(Restrictions.eq("Status", 'y').ignoreCase()).*/list();
		map.put("CadreList", cadreList);
		map.put("sanctionedPostOrderList", sanctionedPostOrderList);
		return map;
	}

	//@Override
	public boolean addSanctionedPostOrder(HrMasSanctionedPostOrder masSanctionedPostOrder) {
			
		boolean successfullyAdded = false;
		Transaction tnx=null;
		Session session =(Session) getSession();
		try{
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		tnx=session.beginTransaction();
		hbt.save(masSanctionedPostOrder);
		hbt.refresh(masSanctionedPostOrder);
		tnx.commit();
		session.flush();
		successfullyAdded = true;
		}catch(Exception e){
			tnx.rollback();
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	//@Override
	public Map<String, Object> showSanctionPostInstitute() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> insList = new ArrayList<MasHospital>();
		List<MasEmployeeDepartment> deptList = new ArrayList<MasEmployeeDepartment>();
		List<MasCadre> cadreList = new ArrayList<MasCadre>();
		List<MasRank> designationList = new ArrayList<MasRank>();
		List<HrInstitutionalSanctionedPost> institutionalSanctionedPostList = new ArrayList<HrInstitutionalSanctionedPost>();
		List<MasSpecialOfficial> masSpecialOfficialList = new ArrayList<MasSpecialOfficial>();
		List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
		List<MasDistrict> masdistrictList = new ArrayList<MasDistrict>();
		
		Session session =(Session)getSession();
		cadreList = session.createCriteria(MasCadre.class).add(Restrictions.eq("Status", 'y').ignoreCase()).addOrder(Order.asc("CadreName")).list();
		designationList=session.createCriteria(MasRank.class).add(Restrictions.eq("Status", 'y').ignoreCase()).addOrder(Order.asc("RankName")).list();
		institutionalSanctionedPostList = session.createCriteria(HrInstitutionalSanctionedPost.class)/*.add(Restrictions.eq("Status", 'y').ignoreCase())*/.list();
		deptList = session.createCriteria(MasEmployeeDepartment.class).add(Restrictions.eq("Status", 'y').ignoreCase()).addOrder(Order.asc("EmpDeptName")).list();
		insList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", 'y').ignoreCase()).list();
		masSpecialOfficialList  = session.createCriteria(MasSpecialOfficial.class).add(Restrictions.eq("Status", 'y').ignoreCase()).addOrder(Order.asc("SpecialOfficialName")).list();
	
		mhospitalTypetList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospitalType as isc where UPPER(isc.Status) = 'Y' order by HospitalTypeName asc");
		masdistrictList = getHibernateTemplate().find("from jkt.hms.masters.business.MasDistrict as isc where UPPER(isc.Status) = 'Y' and isc.State.Id=32 order by DistrictName asc");

		map.put("CadreList", cadreList);
		map.put("designationList", designationList);
 		map.put("deptList", deptList);
		map.put("insList", insList);
		map.put("masSpecialOfficialList", masSpecialOfficialList);
		map.put("institutionalSanctionedPostList", institutionalSanctionedPostList);
		map.put("mhospitalTypetList", mhospitalTypetList);
		map.put("masdistrictList", masdistrictList);
		return map;
	}
	
	public Map<String, Object> searchOrderNo(String gradeCode) {
		List<HrMasSanctionedPostOrder> hrMasSanctionedPostOrder = new ArrayList<HrMasSanctionedPostOrder>();
		Map<String, Object> unitFieldsMap = new HashMap<String, Object>();
		Session session =(Session)getSession();
		List<MasCadre> cadreList = new ArrayList<MasCadre>();
		try {
			if ((gradeCode != null)) {
				
				hrMasSanctionedPostOrder = session.createCriteria(HrMasSanctionedPostOrder.class).add(Restrictions.like("OrderNo", gradeCode +"%").ignoreCase()).addOrder(Order.asc("Id")).list();
				
			}
			cadreList = session.createCriteria(MasCadre.class).add(Restrictions.eq("Status", 'y').ignoreCase()).addOrder(Order.asc("CadreName")).list();
			unitFieldsMap.put("CadreList", cadreList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		unitFieldsMap.put("sanctionedPostOrderList", hrMasSanctionedPostOrder);

		return unitFieldsMap;
	}
	
	
	public boolean editSanctionPostOrderToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String payScaleCode = "";
		String gradeLevel = "";
		String desc = "";
		String orderNo="";
		Date orderDate = null;
		int orderId = 0;
		int userId = 0;
		String type="";
	int noPost=0;
		int cadre=0;
		
	
		orderId = (Integer) generalMap.get("id");
		payScaleCode = (String) generalMap.get("payScaleCode");
		orderNo = (String) generalMap.get("orderNo");
		type = (String) generalMap.get("type");
		noPost = (Integer) generalMap.get("noPost");
	/*	gradeLevel = (String) generalMap.get("name");*/
		desc = (String) generalMap.get("remarks");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		orderDate = (Date) generalMap.get("orderDateId");
		/*endDate = (Date) generalMap.get("endDate");*/
		userId = (Integer) generalMap.get("userId");
		cadre = (Integer) generalMap.get("cadre");
		
		HrMasSanctionedPostOrder masSanctionedPostOrder = (HrMasSanctionedPostOrder) getHibernateTemplate().load(HrMasSanctionedPostOrder.class,orderId);

		masSanctionedPostOrder.setId(orderId);
		masSanctionedPostOrder.setOrderNo(orderNo);
		masSanctionedPostOrder.setStatus("y");
		
		masSanctionedPostOrder.setOrderDate(orderDate);
		
		masSanctionedPostOrder.setDescription(desc);
		
		MasCadre mc = new MasCadre();
		mc.setId(cadre);
		masSanctionedPostOrder.setCadre(mc);
		
		masSanctionedPostOrder.setNoOfPosts(noPost);
		masSanctionedPostOrder.setType(type);
		Users users = new Users();
		users.setId(userId);
		masSanctionedPostOrder.setLastChgBy(users);
		
		masSanctionedPostOrder.setLastChgDate(currentDate);
		masSanctionedPostOrder.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masSanctionedPostOrder);
		hbt.refresh(masSanctionedPostOrder);
		dataUpdated = true;
		return dataUpdated;
	}

	//@Override
	public boolean deleteSanctionPostOrder(int orderId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		HrMasSanctionedPostOrder masSanctionedPostOrder = new HrMasSanctionedPostOrder();
		masSanctionedPostOrder = (HrMasSanctionedPostOrder) getHibernateTemplate().get(
				HrMasSanctionedPostOrder.class,  orderId);
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masSanctionedPostOrder.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masSanctionedPostOrder.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(userId);
		masSanctionedPostOrder.setLastChgBy(users);
		
		masSanctionedPostOrder.setLastChgDate(currentDate);
		masSanctionedPostOrder.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masSanctionedPostOrder);
		hbt.refresh(masSanctionedPostOrder);
		return dataDeleted;
	}

	//@Override
	public boolean addSanctionInstitutePost(HrInstitutionalSanctionedPost hrInstitutionalSanctionedPost) {
			
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrInstitutionalSanctionedPost);
		hbt.refresh(hrInstitutionalSanctionedPost);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	//@Override
	public Map<String, Object> searchSanctionInstitutePost(String refOrder) {
		List<HrInstitutionalSanctionedPost> hrInstitutionalSanctionedPost = new ArrayList<HrInstitutionalSanctionedPost>();
		Map<String, Object> unitFieldsMap = new HashMap<String, Object>();
		Session session =(Session)getSession();
		//added govind 28-9-2016
        List<MasCadre> cadreList = new ArrayList<MasCadre>();
		List<MasRank> designationList = new ArrayList<MasRank>();
		List<HrInstitutionalSanctionedPost> institutionalSanctionedPostList = new ArrayList<HrInstitutionalSanctionedPost>();
		List<MasSpecialOfficial> masSpecialOfficialList = new ArrayList<MasSpecialOfficial>();
		List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
		List<MasDistrict> masdistrictList = new ArrayList<MasDistrict>();
		List<MasHospital> insList = new ArrayList<MasHospital>();
		List<MasEmployeeDepartment> deptList = new ArrayList<MasEmployeeDepartment>();
        //added govind 28-9-2016 end
		try {
			if ((refOrder != null)) {
				
				hrInstitutionalSanctionedPost = session.createCriteria(HrInstitutionalSanctionedPost.class)
						.add(Restrictions.like("RefOrderId", refOrder +"%").ignoreCase()).addOrder(Order.asc("Id")).list();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		  //added govind 28-9-2016 
		cadreList = session.createCriteria(MasCadre.class).add(Restrictions.eq("Status", 'y').ignoreCase()).addOrder(Order.asc("CadreName")).list();
		designationList=session.createCriteria(MasRank.class).add(Restrictions.eq("Status", 'y').ignoreCase()).addOrder(Order.asc("RankName")).list();
		institutionalSanctionedPostList = session.createCriteria(HrInstitutionalSanctionedPost.class)/*.add(Restrictions.eq("Status", 'y').ignoreCase())*/.list();
		deptList = session.createCriteria(MasEmployeeDepartment.class).add(Restrictions.eq("Status", 'y').ignoreCase()).addOrder(Order.asc("EmpDeptName")).list();
		insList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", 'y').ignoreCase()).list();
		masSpecialOfficialList  = session.createCriteria(MasSpecialOfficial.class).add(Restrictions.eq("Status", 'y').ignoreCase()).addOrder(Order.asc("SpecialOfficialName")).list();
	
		mhospitalTypetList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospitalType as isc where UPPER(isc.Status) = 'Y' order by HospitalTypeName asc");
		masdistrictList = getHibernateTemplate().find("from jkt.hms.masters.business.MasDistrict as isc where UPPER(isc.Status) = 'Y' and isc.State.Id=32 order by DistrictName asc");

		unitFieldsMap.put("CadreList", cadreList);
		unitFieldsMap.put("designationList", designationList);
		unitFieldsMap.put("deptList", deptList);
 		unitFieldsMap.put("insList", insList);
 		unitFieldsMap.put("masSpecialOfficialList", masSpecialOfficialList);
		unitFieldsMap.put("institutionalSanctionedPostList", institutionalSanctionedPostList);
		unitFieldsMap.put("mhospitalTypetList", mhospitalTypetList);
		unitFieldsMap.put("masdistrictList", masdistrictList);
		  //added govind 28-9-2016 end
		
		unitFieldsMap.put("institutionalSanctionedPostList", hrInstitutionalSanctionedPost);

		return unitFieldsMap;
	}

	//@Override
	public boolean editSanctionInstitutePostToDatabase(Map<String, Object> generalMap) {
			
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String refOrderNo = "";
		//String gradeLevel = "";
		Date fromDate = null;
		Date toDate = null;
		int orderId = 0;
		int userId = 0;
	    int dept=0;
		int cadre=0;
		int institute=0;
		int sploffName=0;
		int sanctionPostNo=0;
		orderId = (Integer) generalMap.get("id");
		refOrderNo = (String) generalMap.get("refOrderNo");
	/*	gradeLevel = (String) generalMap.get("name");*/
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		fromDate = (Date) generalMap.get("fromDate");
		toDate = (Date) generalMap.get("toDate");
		userId = (Integer) generalMap.get("userId");
		cadre = (Integer) generalMap.get("cadre");
		dept = (Integer) generalMap.get("dept");
		sanctionPostNo =(Integer)generalMap.get("sanctionPostNo");
		institute = (Integer) generalMap.get("institute");
		sploffName = (Integer) generalMap.get("sploffName");
		
		HrInstitutionalSanctionedPost hrInstitutionalSanctionedPost = (HrInstitutionalSanctionedPost) getHibernateTemplate().load(HrInstitutionalSanctionedPost.class,orderId);
		hrInstitutionalSanctionedPost.setId(orderId);
		hrInstitutionalSanctionedPost.setRefOrderId(refOrderNo);
		hrInstitutionalSanctionedPost.setStatus("y");
		hrInstitutionalSanctionedPost.setFromDate(fromDate);
		hrInstitutionalSanctionedPost.setToDate(fromDate);
		hrInstitutionalSanctionedPost.setPostNo(sanctionPostNo);
		
		MasHospital mh = new MasHospital();
		mh.setId(institute);
		hrInstitutionalSanctionedPost.setInstitution(mh);
		
		MasEmployeeDepartment md = new MasEmployeeDepartment();
		md.setId(dept);
		hrInstitutionalSanctionedPost.setDepartment(md); 
		
		MasCadre mc = new MasCadre();
		mc.setId(cadre);
		hrInstitutionalSanctionedPost.setCadre(mc);
		
		Users users = new Users();
		users.setId(userId);
		hrInstitutionalSanctionedPost.setLastChgBy(users);
	
		if(sploffName != 0){
			MasSpecialOfficial ms = new MasSpecialOfficial();
			ms.setId(sploffName);
			hrInstitutionalSanctionedPost.setSpecialOfficial(ms);
		}else{
			hrInstitutionalSanctionedPost.setSpecialOfficial(null);
		}
		hrInstitutionalSanctionedPost.setLastChgDate(currentDate);
		hrInstitutionalSanctionedPost.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrInstitutionalSanctionedPost);
		hbt.refresh(hrInstitutionalSanctionedPost);
		dataUpdated = true;
		return dataUpdated;
	}
	
	//@Override
	public boolean deleteSanctionInstitutePost(int refOrderId, Map<String, Object>  generalMap ) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		HrInstitutionalSanctionedPost hrInstitutionalSanctionedPost = new HrInstitutionalSanctionedPost();
		hrInstitutionalSanctionedPost = (HrInstitutionalSanctionedPost) getHibernateTemplate().get(HrInstitutionalSanctionedPost.class,  refOrderId);
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				hrInstitutionalSanctionedPost.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				hrInstitutionalSanctionedPost.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(userId);
		hrInstitutionalSanctionedPost.setLastChgBy(users);
		hrInstitutionalSanctionedPost.setLastChgDate(currentDate);
		hrInstitutionalSanctionedPost.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(hrInstitutionalSanctionedPost);
		hbt.refresh(hrInstitutionalSanctionedPost);
		return dataDeleted;
	}
	public Map<String, Object> showGroupJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSpecialityGroup> masGroupList = new ArrayList<MasSpecialityGroup>();
		List<Integer> maxGroupIdList = new ArrayList<Integer>();
		List<MasSpecialityGroup> maxGroupCodeList = new ArrayList<MasSpecialityGroup>();
		List<MasSpecialityHeading>headingList = new ArrayList<MasSpecialityHeading>();
		//List<MasSpecialityGroup> nameList = new ArrayList<MasSpecialityGroup>();
		Session session = (Session)getSession();
		List<MasSpecialityGroup> gridGroupList = new ArrayList<MasSpecialityGroup>();
		masGroupList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSpecialityGroup ");

		gridGroupList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasSpecialityGroup as mit where upper(mit.Status)  = upper('Y')");
		headingList = session.createCriteria(MasSpecialityHeading.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		/*nameList = session.createCriteria(MasSpecialityGroup.class).add(Restrictions.s)
		if(gridGroupList.size()>0){
			for(MasSpecialityGroup specialityGroup : gridGroupList){
				String grpName = specialityGroup.getSpGroupName();
				if(grpName.length()>5){
				String specialityGroupName =grpName.substring(0, 5);
				System.out.println("specialityGroupName=="+specialityGroupName);
				if(specialityGroupName.equalsIgnoreCase("Group")){
					String sGrpName = grpName.substring(5, grpName.length());
					System.out.println("sGrpName=="+sGrpName);
				}
					
				}
			}
		}*/
		
		/*maxGroupIdList = session.createCriteria(MasSpecialityGroup.class).setProjection(Projections.max("Id")).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		if(maxGroupIdList.size()>0){
			int maxGroupId = maxGroupIdList.get(0);
			
			maxGroupCodeList = session.createCriteria(MasSpecialityGroup.class).add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.idEq(maxGroupId)).list();
			if(maxGroupCodeList.size()>0){
			String maxGroupCode = maxGroupCodeList.get(0).getSpGroupCode();
			String grpCode = maxGroupCode.substring(1, maxGroupCode.length());
			
			int groupCode = Integer.parseInt(grpCode)+1;
			
			String sGroupCode = "G"+""+groupCode;
			
			map.put("sGroupCode", sGroupCode);
			}
		}*/
		
		map.put("masGroupList", masGroupList);
		map.put("gridGroupList", gridGroupList);
		map.put("headingList", headingList);
		return map;
	}

	public boolean addGroup(MasSpecialityGroup msGroup) {
		boolean saveFlag = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(msGroup);
			saveFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlag;
	}

	public Map<String, Object> searchGroup(String groupCode, String groupName) {
		List<MasSpecialityGroup> masGroupList = new ArrayList<MasSpecialityGroup>();
		Map groupMap = new HashMap();
		try {
			if ((groupName != null) || (groupCode == null)) {
				masGroupList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasSpecialityGroup msg where msg.SpGroupName like '"
								+ groupName + "%' order by msg.SpGroupName");
				

			} else {
				masGroupList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasSpecialityGroup msg where msg.SpGroupCode like '"
								+ groupCode + "%' order by msg.SpGroupCode");
				logger.info(masGroupList.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		groupMap.put("masGroupList", masGroupList);

		return groupMap;
	}

	public boolean editGroupToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String groupName = "";
		@SuppressWarnings("unused")
		String groupCode = "";
		int groupId = 0;
		int userId=0;
		String changedBy = "";
		String display = "";
		if(generalMap.get("display") != null){
			display = (String)generalMap.get("display");
		}
		int heading = 0;
		if(generalMap.get("heading") != null){
			heading = (Integer)generalMap.get("heading");
		}
		
		groupId = (Integer) generalMap.get("id");
		groupCode = (String) generalMap.get("groupCode");
		groupName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		userId=(Integer) generalMap.get("userId");
		currentTime = (String) generalMap.get("currentTime");
		MasSpecialityGroup masGroup = (MasSpecialityGroup) getHibernateTemplate()
				.get(MasSpecialityGroup.class, groupId);

		Users user = new Users();
		user.setId(userId);
		if(display != null && !display.equals("")){
			masGroup.setDisplay(display);
		}
		if(heading != 0){
			MasSpecialityHeading masSpecialityHeading = new MasSpecialityHeading();
			masSpecialityHeading.setId(heading);
			masGroup.setSpHeading(masSpecialityHeading);
		}
		masGroup.setSpGroupName(groupName);
		masGroup.setLastChgBy(user);
		masGroup.setLastChgDate(currentDate);
		masGroup.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masGroup);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteGroup(int groupId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		int userId=(Integer)generalMap.get("userId");

		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasSpecialityGroup masGroup = new MasSpecialityGroup();
		masGroup = (MasSpecialityGroup) getHibernateTemplate().get(
				MasSpecialityGroup.class, groupId);

		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masGroup.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masGroup.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user = new Users();
		user.setId(userId);
		masGroup.setLastChgBy(user);
		masGroup.setLastChgDate(currentDate);
		masGroup.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masGroup);
		return dataDeleted;
	}

	// -------------------- PARAMETER MASTER ----------------------------

	public Map<String, Object> showParameterJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSpecialityParameter> masParameter = new ArrayList<MasSpecialityParameter>();

		masParameter = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSpecialityParameter ");
		map.put("masParameter", masParameter);
		
		return map;
	}

	public boolean addParameter(MasSpecialityParameter masParameter) {
		boolean saveFlag = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();

			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masParameter);
			saveFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlag;
	}

	public Map<String, Object> searchParameter(String parameterCode,
			String parameterName) {
		List<MasSpecialityParameter> masParameter = new ArrayList<MasSpecialityParameter>();
		Map groupMap = new HashMap();
		try {
			logger.info(parameterCode + "    " + parameterName);
			if ((parameterName != null) || (parameterCode == null)) {
				masParameter = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasSpecialityParameter msp where msp.SpParameterName like '"
								+ parameterName
								+ "%' order by msp.SpParameterName");
				logger.info("masParameter11" + masParameter.size());

			} else {
				masParameter = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasSpecialityParameter msp where msp.SpParameterCode like '"
								+ parameterCode
								+ "%' order by msp.SpParameterCode");
				logger.info(" masParameter" + masParameter.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		groupMap.put("masParameter", masParameter);

		return groupMap;
	}

	public boolean editParameterToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String parameterCode = "";
		String parameterName = "";
		String valueType = "";
		String imageReq = "";
		String common = "";
		int id = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		id = (Integer) generalMap.get("id");
		parameterCode = (String) generalMap.get("parameterCode");
		parameterName = (String) generalMap.get("parameterName");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		common = (String) generalMap.get("common");
		valueType = (String) generalMap.get("valueType");

		MasSpecialityParameter masParameter = (MasSpecialityParameter) getHibernateTemplate()
				.get(MasSpecialityParameter.class, id);

		masParameter.setSpParameterName(parameterName);
		masParameter.setSpParameterCode(parameterCode);
		masParameter.setCommon(common);
		masParameter.setCommon(imageReq);
		masParameter.setCommon(valueType);

		masParameter.setLastChgDate(currentDate);
		masParameter.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.update(masParameter);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteParameter(int groupId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
         int userId=(Integer)generalMap.get("userId");
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasSpecialityParameter masPara = new MasSpecialityParameter();
		masPara = (MasSpecialityParameter) getHibernateTemplate().get(
				MasSpecialityParameter.class, groupId);

		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masPara.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masPara.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user = new Users();
		user.setId(userId);
		masPara.setLastChgBy(user);
		masPara.setLastChgDate(currentDate);
		masPara.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masPara);
		return dataDeleted;
	}

	// --------------------------------------IMAGE MASTER
	// ---------------------------------------

	public Map<String, Object> showImageJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSpecialityParameter> masParameter = new ArrayList<MasSpecialityParameter>();

		masParameter = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSpecialityParameter ");

		masParameter = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasSpecialityParameter as msp where msp.Status = 'y' or msp.Status = 'Y'");
		map.put("masParameter", masParameter);

		logger.info("masParameter" + masParameter.size());
		return map;
	}

	public boolean addImage(MasSpecialityGroup msGroup) {
		boolean saveFlag = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(msGroup);
			saveFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlag;
	}

	// ------------------------- -------------------------

	public Map<String, Object> showGroupParaMasterJSP(
			Map<String, Object> details) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSpecialityParameter> masSpParaList = new ArrayList<MasSpecialityParameter>();
		List<MasSpecialityGroup> masSpGrpList = new ArrayList<MasSpecialityGroup>();
		List<MasSpecialtyGroupParameter> masParameter = new ArrayList<MasSpecialtyGroupParameter>();

		masSpParaList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.	MasSpecialtyGroupParameter ");

		masSpParaList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasSpecialityParameter as msp where msp.Status = 'y' or msp.Status = 'Y' order by msp.SpParameterName asc ");
		masSpGrpList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasSpecialityGroup as msg where msg.Status = 'y' or msg.Status = 'Y' order by msg.SpGroupName asc");

		Criteria cr = getSession().createCriteria(MasSpecialtyGroupParameter.class,
				"spg").createAlias("spg.SpGroup", "gp");

		if (details.get("groupName") != null) {
			cr = cr.add(Restrictions.ilike("gp.SpGroupName",
					((String) details.get("groupName")).toLowerCase()+"%"));
		}
		masParameter = cr.list();

		map.put("masSpParaList", masSpParaList);
		map.put("masSpGrpList", masSpGrpList);
		map.put("masParameter", masParameter);
		// map.put("spGroupParameterT", spGroupParameterT);

		return map;
	}

	public boolean addGroupParaMaster(Map m) {

		MasSpecialityGroup masGroup = new MasSpecialityGroup();
		MasSpecialtyGroupParameter spParaM = new 	MasSpecialtyGroupParameter();
		MasSpecialityParameter masSpPara = new MasSpecialityParameter();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		
		List<Object> list=new ArrayList<Object>();
		generalMap= (Map<String, Object>) m.get("generalMap");
		
		String grpMaster =(String)generalMap.get("grpMaster");
		String paraMastr = (String)generalMap.get("paraMastr");
		int userId = (Integer)generalMap.get("userId");
		Date currentDate =(Date)generalMap.get("currentDate");
		String currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		
	
		boolean saveFlag = false;
		Criteria cr=getSession().createCriteria(MasSpecialtyGroupParameter.class,"mas")
				    .createAlias("mas.SpGroup", "spGroup")
				    .add(Restrictions.eq("spGroup.Id",Integer.parseInt(grpMaster))) 
				    .createAlias("mas.SpParameter", "spParameter")
				    .add(Restrictions.eq("SpParameter.Id",Integer.parseInt(paraMastr)))  ;
		list=cr.list();
		if(list.size()==0){
		
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			Users user=new Users();
			user.setId(userId);
			spParaM.setLastChgBy(user);
			spParaM.setLastChgDate(currentDate);
			spParaM.setLastChgTime(currentTime);
			spParaM.setStatus("y");
			masGroup.setId(Integer.parseInt(grpMaster));
			spParaM.setSpGroup(masGroup);
			masSpPara.setId(Integer.parseInt(paraMastr));
			spParaM.setSpParameter(masSpPara); 
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(spParaM);

			saveFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		return saveFlag;
	}

	public boolean editGroupParaMaster(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String grpMaster = "";
		String changedBy = "";
		String paraMeterVale = "";
		int id = 0;

		id = (Integer) generalMap.get("id");
		paraMeterVale = (String) generalMap.get("paraMeterVale");
		grpMaster = (String) generalMap.get("grpMaster");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId = (Integer) generalMap.get("userId");

		MasSpecialtyGroupParameter masGroupPara = (	MasSpecialtyGroupParameter) getHibernateTemplate()
				.get(MasSpecialtyGroupParameter.class, id);

		masGroupPara.setId(id);
		Users user = new Users();
		user.setId(userId);
		MasSpecialityParameter masSpPara = new MasSpecialityParameter();
		masSpPara.setId(Integer.parseInt(paraMeterVale));

		MasSpecialityGroup masGroup = new MasSpecialityGroup();
		masGroup.setId(Integer.parseInt(grpMaster));

		masGroupPara.setSpParameter(masSpPara);
		masGroupPara.setSpGroup(masGroup);
		masGroupPara.setLastChgBy(user);
		masGroupPara.setLastChgDate(currentDate);
		masGroupPara.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masGroupPara);
		dataUpdated = true;
		return dataUpdated;

	}

	public boolean deleteGroupParaMaster(int id, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";

		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasSpecialtyGroupParameter masSpGrup = new 	MasSpecialtyGroupParameter();
		masSpGrup = (MasSpecialtyGroupParameter) getHibernateTemplate().get(
				MasSpecialtyGroupParameter.class, id);

		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masSpGrup.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masSpGrup.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user = new Users();
		user.setId(id);
		// masGroup.setLastChgBy(user);
		masSpGrup.setLastChgDate(currentDate);
		masSpGrup.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masSpGrup);
		return dataDeleted;
	}

	// -------------------- -------------

	//@Override
	public Map<String, Object> showDepartWiseGrpMaster(
			Map<String, Object> details) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasSpecialityParameter> masSpParaList = new ArrayList<MasSpecialityParameter>();
		List<MasSpecialityGroup> masSpGrpList = new ArrayList<MasSpecialityGroup>();
		List<MasDepartment> masDpList = new ArrayList<MasDepartment>();

		List<SpDeptGroupM> deptGroupMs = new ArrayList<SpDeptGroupM>();
		List<SpDeptGroupT> deptGroupTs = new ArrayList<SpDeptGroupT>();

		Session ses = (Session) getSession();

		masSpParaList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasSpecialityParameter as msp where msp.Status = 'y' or msp.Status = 'Y'");
		masSpGrpList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasSpecialityGroup as msg where msg.Status = 'y' or msg.Status = 'Y'");

		masDpList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as mad where mad.Status = 'y' or mad.Status = 'Y'");

		Criteria cr = getSession().createCriteria(SpDeptGroupM.class, "sdg")
				.createAlias("sdg.DeptGroupM", "dgm")
				.createAlias("dgm.Department", "dep");

		if (details.get("depName") != null) {
			cr = cr.add(Restrictions.ilike("dep.DepartmentName", "%"
					+ (String) details.get("depName") + "%"));

		}

		/*
		 * Criteria cr=getSession().createCriteria(SpGroupParameterT.class,
		 * "spg").createAlias("spg.GroupParameterM", "gpm")
		 * .createAlias("gpm.SpGroup","gp");
		 * 
		 * if(details.get("groupName")!=null){
		 * cr=cr.add(Restrictions.like("gp.SpGroupName",
		 * "%"+(String)details.get("groupName")+"%")); }
		 * spGroupParameterT=cr.list();
		 */

		deptGroupTs = cr.list();

		// deptGroupMs=
		logger.info("deptGroupT >>>>>>>" + deptGroupTs.size());

		map.put("masSpParaList", masSpParaList);
		map.put("masSpGrpList", masSpGrpList);
		map.put("masDpList", masDpList);
		map.put("deptGroupTs", deptGroupTs);

		return map;
	}

	public boolean addDepartmentGrPara(Map m) {
		StringBuilder commaSepValueBuilder = new StringBuilder();

		MasSpecialityGroup masGroup = new MasSpecialityGroup();
		SpDeptGroupM spDeptGroupM = new SpDeptGroupM();
		MasDepartment masDepartment = new MasDepartment();

		m.put("", spDeptGroupM);

		String paraMeterVales[] = null;
		paraMeterVales = (String[]) m.get("paraMeterVales");

		spDeptGroupM = (SpDeptGroupM) m.get("deptGroupM");

		boolean saveFlag = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();

			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			hbt.save(spDeptGroupM);
			hbt.flush();
			hbt.refresh(spDeptGroupM);

			for (int j = 0; j < paraMeterVales.length; j++) {

				logger.info("commaSepValueBuilder "
						+ commaSepValueBuilder.toString());
				SpDeptGroupT spParaT = new SpDeptGroupT();

				spParaT.setDeptGroupM(spDeptGroupM);

				MasSpecialityParameter msp = new MasSpecialityParameter();
				msp.setId(Integer.parseInt("" + paraMeterVales[j]));
				spParaT.setSpParameter(msp);
				hbt.save(spParaT);
				hbt.flush();
				hbt.refresh(spParaT);

			}
			saveFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlag;
	}

	public boolean deleteDepartWiseGrpMaster(int id,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";

		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		SpDeptGroupM spDeapMe = new SpDeptGroupM();
		spDeapMe = (SpDeptGroupM) getHibernateTemplate().get(
				SpDeptGroupM.class, id);

		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				spDeapMe.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				spDeapMe.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user = new Users();
		user.setId(id);
		// masGroup.setLastChgBy(user);
		spDeapMe.setLastChgDate(currentDate);
		spDeapMe.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(spDeapMe);
		return dataDeleted;
	}

	// ------------------------------- Committee ----------------------

	public Map<String, Object> showCommitteeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrCommitteeHeader> hrComm = new ArrayList<HrCommitteeHeader>();

		hrComm = getHibernateTemplate().find(
				"from jkt.hms.masters.business.HrCommitteeHeader ");

		map.put("hrComm", hrComm);
		logger.info("hrComm" + hrComm.size());
		return map;
	}

	public boolean addCommittee(HrCommitteeHeader hrComHed) {
		boolean saveFlag = false;
		String code = " ";
		String name = " ";

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(hrComHed);
			saveFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlag;
	}

	public Map<String, Object> searchCommittee(String commCode,
			String commName) {
		List<MasSpecialityGroup> masGroupList = new ArrayList<MasSpecialityGroup>();
		Map groupMap = new HashMap();
		Session session = (Session) getSession();
		try {
			if ((commName != null) || (commCode == null)) {
				/*masGroupList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasSpecialityGroup msg where msg.SpGroupName like '%"
								+ commName + "%' order by msg.SpGroupName");
				System.out.println("ok1");*/
				masGroupList = session.createCriteria(MasSpecialityGroup.class).add(Restrictions.like("SpGroupName", commName+"%").ignoreCase()).addOrder(Order.asc("SpGroupName")).list();

			} else {
				/*masGroupList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasSpecialityGroup msg where msg.SpGroupCode like '%"
								+ commCode + "%' order by msg.SpGroupCode");*/
				masGroupList = session.createCriteria(MasSpecialityGroup.class).add(Restrictions.like("SpGroupCode", commCode+"%").ignoreCase()).addOrder(Order.asc("SpGroupCode")).list();
				logger.info(masGroupList.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		groupMap.put("masGroupList", masGroupList);

		return groupMap;
	}

	// ------------------------ ------------------------------

	public Map<String, Object> showDepartmentGroupParameter(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();

	
		List<MasSpecialtyGroupParameter> masSpGrpPara = new ArrayList<MasSpecialtyGroupParameter>();//1
		List<MasSpecialtyGroupParameter> masGridSpGrpPara = new ArrayList<MasSpecialtyGroupParameter>();
		List<MasDepartment> masDpList = new ArrayList<MasDepartment>();//2
		List<MasDepartment> masDpGridList = new ArrayList<MasDepartment>();
		List<MasSpecialtyTemplate> masTempl = new ArrayList<MasSpecialtyTemplate>();//3
		List<MasSpecialityGroup> masGroup = new ArrayList<MasSpecialityGroup>();
		List<MasSpecialityDeptGroup> masSpDepGrp = new ArrayList<MasSpecialityDeptGroup>();//4

		Session ses = (Session) getSession();
		Integer hospitalId=null;
		if (generalMap.get("hospitalId") != null) {
			hospitalId = (Integer) generalMap.get("hospitalId");
		}
		int searchDeptId = 0;
		if (generalMap.get("searchDeptId") != null) {
			searchDeptId = (Integer) generalMap.get("searchDeptId");
		}
		int searchTemplate = 0;
		if (generalMap.get("searchTemplate") != null) {
			searchTemplate = (Integer) generalMap.get("searchTemplate");
		}
		logger.info("searchDeptId==="+searchDeptId +"searchTemplate==="+searchTemplate );
		if(searchDeptId != 0){
		masSpDepGrp =ses.createCriteria(MasSpecialityDeptGroup.class).add(Restrictions.eq("Department.Id", searchDeptId)).list();
		}else if(searchTemplate != 0){
			masSpDepGrp =ses.createCriteria(MasSpecialityDeptGroup.class).add(Restrictions.eq("Template.Id", searchTemplate)).list();
		}else{
			masSpDepGrp =ses.createCriteria(MasSpecialityDeptGroup.class).list();
		}
		Criteria cr = getSession().createCriteria(MasSpecialtyGroupParameter.class,"sgp")
				.createAlias("sgp.SpGroup", "spg");
		
		masGroup=getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasSpecialityGroup as mad where mad.Status = 'y' or mad.Status = 'Y' order by mad.SpGroupName asc ");
		
		Criteria criteria = getSession().createCriteria(MasSpecialtyGroupParameter.class )
				          .createAlias("SpGroup", "spGroup")
                           .setProjection( Projections.distinct( Projections.property( "spGroup.SpGroupCode" )))
                           ;     
		
		masGridSpGrpPara=criteria.list();
		
                             /*
		
		Criteria cr = getSession().createCriteria(MasSpecialtyGroupParameter.class)
				.createAlias("SpGroup", "spGroup")
				.setProjection( 
						Projections.projectionList().add(Projections.property("spGroup.SpGroupCode"))
						.add(Projections.property("spGroup.SpGroupName"))
	                    .add( Projections.groupProperty("spGroup.Id")));*/
				      //.add(Projections.groupProperty("SpGroup"),"spg");
		// if(){
		// cr=cr.add(Restrictions.eq("spg.SpGroupName", ""));
		// }

		masSpGrpPara =getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasSpecialtyGroupParameter as mad where mad.Status = 'y' or mad.Status = 'Y' order by mad.SpGroup.SpGroupName");
		masGridSpGrpPara = cr.list();
		/*for (Iterator<Object[]> a = masSpGrpPara.iterator(); a.hasNext();) {
			Object[] asas = (Object[])a.next(); 
			
			System.out.println(a.next()+"###################"+asas[2]+"   name is "+asas[0]+" code is "+asas[1]);
			
		}*/
			
			
		masDpList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as mad where lower(mad.Status) = lower('y') order by mad.DepartmentName");

		masDpGridList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as mad where mad.Status = 'y' or mad.Status = 'Y' order by mad.DepartmentName");

		masTempl= getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasSpecialtyTemplate as mad where mad.Status = 'y' or mad.Status = 'Y' order by mad.TemplateName asc");
		
		List<MasDepartment>list=ses.createCriteria(MasDepartment.class)
				//.add(Restrictions.eq("Hospital.Id", hospitalId))
				//.add(Restrictions.eq("DepartmentType.Id", 1))
				.add(Restrictions.eq("Status", 'y').ignoreCase())
				.addOrder(Order.asc("DepartmentName")).list();

		/*
		 * masSpGrpPara = getHibernateTemplate().find(
		 * "from jkt.hms.masters.business.SpGroupParameterM as msg where msg.Status = 'y' or msg.Status = 'Y'"
		 * );
		 */

		/*
		 * Criteria
		 * cr=getSession().createCriteria(SpDeptGroupT.class,"sdg").createAlias
		 * ("sdg.DeptGroupM", "dgm") .createAlias("dgm.Department", "dep");
		 * 
		 * if(details.get("depName")!=null){
		 * cr=cr.add(Restrictions.ilike("dep.DepartmentName",
		 * "%"+(String)details.get("depName")+"%"));
		 * 
		 * }
		 * 
		 * 
		 * 
		 * 
		 * deptGroupTs=cr.list();
		 */
		// deptGroupMs=
	
		map.put("departments", list);
		map.put("masSpGrpList", masSpGrpPara);
		map.put("masDpList", masDpList);
		map.put("masSpDepGrp", masSpDepGrp);
		map.put("masDpGridList", masDpGridList);
		map.put("masGridSpGrpPara", masGridSpGrpPara);
		map.put("masTempl", masTempl);
		map.put("masSpGroup", masGroup);
		


		return map;
	}

	public boolean addDepartmentGroupParameter(Map<String, Object> generalMap) {
		boolean saveFlag = false;
		MasSpecialityDeptGroup masParameter = new MasSpecialityDeptGroup();
		MasSpecialtyGroupParameter spGrParameter = new MasSpecialtyGroupParameter();
		MasDepartment masDepartment = new MasDepartment();
		MasSpecialtyTemplate masTemp=new MasSpecialtyTemplate();
		
		List<MasSpecialityDeptGroup> masParameterList=new ArrayList<MasSpecialityDeptGroup>();
		MasHospital masHospital = new MasHospital();
		Box box = (Box) generalMap.get("box");
		Session session = (Session) getSession();
		

		int hospitalId = (Integer) generalMap.get("hospitalId");
		int id = (Integer)generalMap.get("id");
		String changedBy = "";
		/*String snoPa=(String)generalMap.get("snoPa");
		String snoGp=(String)generalMap.get("snoGp");*/
		String snoPa=(String)box.get("snoPa");
		String snoGp=(String)box.get("snoGp");
		
		String msg="";
		String valueType="";
		String checkbox=(String)generalMap.get("checkbox");
		String nadRequired = "";
		int noOfFields=0;
		String dateFields = "";
		String multipleSelection = "";
		String grid = "";
		String simpleFormType = "";
		String mediumFormType = "";
		String complexFormType = "";
		String extraLov = "";
		String textFont = "";
		String textSize = "";
		String textColor = "";
		String validationValue = "";
		
		if(generalMap.get("valueType")!=null){
		 valueType = (String) generalMap.get("valueType");
		}
		if(generalMap.get("dateFields")!=null){
			dateFields = (String) generalMap.get("dateFields");
		}
		if(generalMap.get("grid") != null){
			grid = (String)generalMap.get("grid");
		}
		if(generalMap.get("simpleFormType") != null){
			simpleFormType = (String)generalMap.get("simpleFormType");
		}

		if(generalMap.get("mediumFormType") != null){
			mediumFormType = (String)generalMap.get("mediumFormType");
		}

		if(generalMap.get("complexFormType") != null){
			complexFormType = (String)generalMap.get("complexFormType");
		}
		String  radioText1 = "";
		if(generalMap.get("radioText1") != null){
			radioText1 = (String)generalMap.get("radioText1");
		}
		String  radioDefault1 = ""; 
		if(generalMap.get("radioDefault1") != null){
			radioDefault1 = (String)generalMap.get("radioDefault1");
		}
		String  radioText2 = "";
		if(generalMap.get("radioText2") != null){
			radioText2 = (String)generalMap.get("radioText2");
		}
		String  radioDefault2 = "";
		if(generalMap.get("radioDefault2") != null){
			radioDefault2 = (String)generalMap.get("radioDefault2");
		}
		
		if(generalMap.get("extraLov") != null){
			extraLov = (String)generalMap.get("extraLov");
		}
		if(generalMap.get("textFont") != null){
			textFont = (String)generalMap.get("textFont");
		}
		if(generalMap.get("textSize") != null){
			textSize = (String)generalMap.get("textSize");
		}
		
		if(generalMap.get("textColor") != null){
			textColor = (String)generalMap.get("textColor");
		}
		
		if(generalMap.get("validationValue") != null){
			validationValue = (String)generalMap.get("validationValue");
		}

		String img = (String) generalMap.get("img");
		String dpartName = (String)box.get("dpartName");
		String grpName = (String) generalMap.get("name");
		int userId = (Integer) generalMap.get("userId");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		String template=(String) generalMap.get("template");
		int temp=(Integer.parseInt(""+template.trim()));
		if(generalMap.get("nadRequired") != null){
			nadRequired = (String)generalMap.get("nadRequired");
		}
		if(generalMap.get("multipleSelection") != null){
			multipleSelection = (String)generalMap.get("multipleSelection");
		}
		String  unitLabel = ""; 
		if(generalMap.get("unitLabel") != null){
			unitLabel = (String)generalMap.get("unitLabel");
		}
		int  maxlength = 0; 
		if(generalMap.get("maxlength") != null){
			maxlength = (Integer)generalMap.get("maxlength");
		}
		String  datatype = ""; 
		if(generalMap.get("datatype") != null){
			datatype = (String)generalMap.get("datatype");
		}
		
		noOfFields = (Integer) generalMap.get("noOfFields");
     	String parameter=(String) generalMap.get("parameter");//parameter
		
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		String uploadURL = box.getString("uploadURL");
		String fileSeparator = box.getString("fileSeparator");
		List<String> values = new ArrayList<String>();
		List<String> defaultValues = new ArrayList<String>();
		List<String> extraText = new ArrayList<String>();
		if (box.getArrayList("values") != null && !"".equals(box.get("values"))) {
				values = box.getArrayList("values");
				defaultValues = box.getArrayList("defaultValues");
				extraText = box.getArrayList("extraText");
			
		}
	
		
		 Criteria cr=session.createCriteria(MasSpecialityDeptGroup.class)
				  .createAlias("Department", "department")
				  .add(Restrictions.eq("department.Id", Integer.parseInt(dpartName))) 
				  .createAlias("SpGroup", "spGroup")
				  .add(Restrictions.eq("spGroup.Id",  Integer.parseInt(parameter)))
				   .createAlias("Template", "template")
				  .add(Restrictions.eq("template.Id",  temp));
		   masParameterList=cr.list();
		   {
				if(masParameterList.size()==0){
		
		masHospital.setId(hospitalId);
		masTemp.setId(Integer.parseInt(template.trim()));
		spGrParameter.setId(Integer.parseInt(parameter));
		masDepartment.setId(Integer.parseInt(dpartName));

		masParameter.setSpGroup(spGrParameter);

		masParameter.setDepartment(masDepartment);
		masParameter.setTemplate(masTemp);
		if(checkbox.equalsIgnoreCase("t")){
		masParameter.setTextField("t");
		}else {
			masParameter.setTextField("n");	
		}
		if(extraLov.equalsIgnoreCase("l")){
			masParameter.setExtraLov("l");
			}else {
				masParameter.setExtraLov("n");	
			}
		if(!nadRequired.equals("")){
			masParameter.setNadRequired(nadRequired);
		}
		if(noOfFields!=0){
			masParameter.setNoOfFields(noOfFields);
		}
		if(multipleSelection.equalsIgnoreCase("y")){
			masParameter.setMultipleSelection("y");
			}else {
				masParameter.setMultipleSelection("n");	
			}
		if(dateFields.equalsIgnoreCase("y")){
			masParameter.setDateField("y");
			}else {
				masParameter.setDateField("n");	
			}
		if(grid.equalsIgnoreCase("y")){
			masParameter.setGrid("y");
			}else {
				masParameter.setGrid("n");	
			}
		if(simpleFormType.equalsIgnoreCase("y")){
			masParameter.setSimpleFormType("y");
			}else {
				masParameter.setSimpleFormType("n");	
			}
		if(mediumFormType.equalsIgnoreCase("y")){
			masParameter.setMediumFormType("y");
			}else {
				masParameter.setMediumFormType("n");	
			}
		if(complexFormType.equalsIgnoreCase("y")){
			masParameter.setComplexFormType("y");
			}else {
				masParameter.setComplexFormType("n");	
			}
		masParameter.setRadioText1(radioText1);
		masParameter.setRadioDefault1(radioDefault1);
		masParameter.setRadioText2(radioText2);
		masParameter.setRadioDefault2(radioDefault2);
		masParameter.setTextMaxlength(maxlength);
		masParameter.setTextColor(textColor);
		masParameter.setTextFont(textFont);
		masParameter.setTextSize(textSize);
		masParameter.setValidationValue(validationValue);
		
		
		masParameter.setDataType(datatype);
		masParameter.setUnitLabel(unitLabel);
		
		Users user = new Users();
		user.setId(userId);

		masParameter.setImageReq(img);
		masParameter.setValueType(valueType);
		masParameter.setLastChgBy(user);
		masParameter.setLastChgDate(date);
		masParameter.setLastChgTime(time);
		masParameter.setStatus("y");
		masParameter.setGroupSeqNo(Integer.parseInt(""+snoGp.trim()));
		masParameter.setParameterSeqNo(Integer.parseInt(""+snoPa.trim()));
		

		// ------------- Adding to MasSpeciealtyDepartmentGroupValue-----------
		
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masParameter);
			logger.info("extraLov========"+extraLov.equalsIgnoreCase("l"));
			logger.info("values453========"+values.size());
     		if(valueType.equalsIgnoreCase("LOV") || extraLov.equalsIgnoreCase("l")){
			if(values.size()!= 0 && values.size()>0){
			for (int i =0; i < values.size(); i++) {
				MasSpecialityDeptGroupValue masSpDepValue = new MasSpecialityDeptGroupValue();
				
				logger.info("extraLov==== iside==="+values.get(i));
				masSpDepValue.setValue(values.get(i));
				if(defaultValues != null && defaultValues.size()>i &&  defaultValues.get(i) != null && !defaultValues.get(i).equals("")){
					masSpDepValue.setDefaultValue((String)defaultValues.get(i));
				}else{
					masSpDepValue.setDefaultValue("");
				}
				if( extraText != null && extraText.size()>i &&  extraText.get(i) != null && !extraText.get(i).equals("")){
					masSpDepValue.setExtraText((String)extraText.get(i));
				}else{
					masSpDepValue.setExtraText("");
				}
					masSpDepValue.setDeptGroup(masParameter);
					masSpDepValue.setType(valueType);
					masSpDepValue.setLastChgBy(user);
					masSpDepValue.setStatus("y");
					masSpDepValue.setHospital(masHospital);
					masSpDepValue.setLastChgDate(date);
					masSpDepValue.setLastChgTime(time);
					hbt.save(masSpDepValue);
					saveFlag=true;
					logger.info("saveFlag=="+saveFlag);
			}
			}
		//	saveFlag=true;
  }
			logger.info("img=="+img);
			if (img.equalsIgnoreCase("Yes")) {

				// masSpDepValue.setImgFile(bytes);

				/*
				 * MasDepartment masDep = (MasDepartment) hbt.get(
				 * MasDepartment.class, Integer.parseInt(dpartName));
				 */
                int i=1;
				if (!box.getString("filename" + i).equals("0")) {
					MasSpecialityDeptGroupValue masSpDepValue = new MasSpecialityDeptGroupValue();
					File file = null;
					file = new File(uploadURL + fileSeparator + dpartName
							+ fileSeparator + box.getString("filename"));

					File f = new File(uploadURL);
					try {
						if (f.exists()) {
							/*f.delete();
							f.mkdir();*/
							FileInputStream is = new FileInputStream(file);
							long length = file.length();

							if (length > Integer.MAX_VALUE) {
								// File is too large
							}
							// Create the byte array to hold the data
							byte[] bytes = new byte[(int) length];
							int offset = 0;
							int numRead = 0;
							while (offset < bytes.length
									&& (numRead = is.read(bytes, offset,
											bytes.length - offset)) >= 0) {
								offset += numRead;
							}

							if (offset < bytes.length) {
								throw new IOException(
										"Could not completely read file "
												+ file.getName());
							}

							masSpDepValue.setImgFile(bytes);
							is.close();
						} else {
							f.mkdir();
							FileInputStream is = new FileInputStream(file);
							long length = file.length();
							// ByteBuffer byteBuff=null;
							// int modLength=length/
							if (length > Integer.MAX_VALUE) {
								// File is too large
							}
							// Create the byte array to hold the data
							byte[] bytes = new byte[(int) length];
							int offset = 0;
							int numRead = 0;
							while (offset < bytes.length
									&& (numRead = is.read(bytes, offset,
											bytes.length - offset)) >= 0) {
								offset += numRead;
							}

							if (offset < bytes.length) {
								throw new IOException(
										"Could not completely read file "
												+ file.getName());
							}
							is.close();

							masSpDepValue.setImgFile(bytes);
							
						}
                       
                        
						masSpDepValue.setDeptGroup(masParameter);
						masSpDepValue.setType("img");
						masSpDepValue.setLastChgBy(user);
						masSpDepValue.setStatus("y"); 
						masSpDepValue.setHospital(masHospital);
						masSpDepValue.setLastChgDate(date);
						masSpDepValue.setLastChgTime(time); 
						hbt.save(masSpDepValue); 
						hbt.flush();
						hbt.clear();  
						saveFlag=true;

					} catch (Exception e) {
						e.printStackTrace();
                      if(transaction!=null){
                    	  transaction.rollback(); 
                      }
                     
					}

				}
			}
			transaction.commit();
			saveFlag=true;
			logger.info("saveFlag=="+saveFlag);
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();

		}

		}
				}
			
		return saveFlag;


	}
	//@Override
	public boolean editDepartmentGroupParameter(Map<String, Object> generalMap,Box box) {
		List<MasSpecialityDeptGroupValue> valueList = new ArrayList<MasSpecialityDeptGroupValue>();
		Session session = (Session)getSession();
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";

		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");

		@SuppressWarnings("unused")
		int dpartName = 0;
		String grpName = "";
		String changedBy = "";
		int id = 0;
		int userId = 0;
		String valueType = "";
		String img = "";
		String tempLate ="";
		String nadRequired = "";
		String checkbox = "";
		String dateFields = "";
		String multipleSelection = "";
		int hospitalId =0;
		int noOfFields=0;
		String grid = "";
		String simpleFormType = "";
		String mediumFormType = "";
		String complexFormType = "";
		int  maxlength = 0;
		String  datatype = "";
		String  unitLabel = "";
		String extraLov = "";
		String textFont = "";
		String textSize = "";
		String textColor = "";
		String validationValue = "";
		

		id = (Integer) generalMap.get("id");
		grpName = (String) generalMap.get("name");
		String parameter = (String) generalMap.get("parameter");
		userId = (Integer) generalMap.get("userId");
		String snoPa=(String)generalMap.get("snoPa");
		String snoGp=(String)generalMap.get("snoGp");
		
		valueType = (String) generalMap.get("valueType");
		img = (String) generalMap.get("img");
		tempLate=(String)generalMap.get("tempLate");

		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if(generalMap.get("nadRequired") != null){
			nadRequired = (String)generalMap.get("nadRequired");
		}
		if(generalMap.get("checkbox") != null){
			checkbox = (String)generalMap.get("checkbox");
		}
		if(generalMap.get("dateFields") != null){
			dateFields = (String)generalMap.get("dateFields");
		}
		if(generalMap.get("multipleSelection") != null){
			multipleSelection = (String)generalMap.get("multipleSelection");
		}
		if(generalMap.get("grid") != null){
			grid = (String)generalMap.get("grid");
		}
		if(generalMap.get("simpleFormType") != null){
			simpleFormType = (String)generalMap.get("simpleFormType");
		}

		if(generalMap.get("mediumFormType") != null){
			mediumFormType = (String)generalMap.get("mediumFormType");
		}

		if(generalMap.get("complexFormType") != null){
			complexFormType = (String)generalMap.get("complexFormType");
		}
		String  radioText1 = "";
		if(generalMap.get("radioText1") != null){
			radioText1 = (String)generalMap.get("radioText1");
		}
		String  radioDefault1 = ""; 
		if(generalMap.get("radioDefault1") != null){
			radioDefault1 = (String)generalMap.get("radioDefault1");
		}
		String  radioText2 = "";
		if(generalMap.get("radioText2") != null){
			radioText2 = (String)generalMap.get("radioText2");
		}
		String  radioDefault2 = "";
		if(generalMap.get("radioDefault2") != null){
			radioDefault2 = (String)generalMap.get("radioDefault2");
		}
		if(generalMap.get("unitLabel") != null){
			unitLabel = (String)generalMap.get("unitLabel");
		}
		if(generalMap.get("maxlength") != null){
			maxlength = (Integer)generalMap.get("maxlength");
		}
		if(generalMap.get("datatype") != null){
			datatype = (String)generalMap.get("datatype");
		}
		if(generalMap.get("extraLov") != null){
			extraLov = (String)generalMap.get("extraLov");
		}
		if(generalMap.get("textFont") != null){
			textFont = (String)generalMap.get("textFont");
		}
		if(generalMap.get("textSize") != null){
			textSize = (String)generalMap.get("textSize");
		}
		
		if(generalMap.get("textColor") != null){
			textColor = (String)generalMap.get("textColor");
		}
		if(generalMap.get("validationValue") != null){
			validationValue = (String)generalMap.get("validationValue");
		}
		logger.info("validationValue====="+validationValue);
		if(generalMap.get("hospitalId") != null){
			hospitalId = (Integer)generalMap.get("hospitalId");
		}
		List<String> values = new ArrayList<String>();
		List<String> defaultValues = new ArrayList<String>();
		List<String> extraText = new ArrayList<String>();
		if (box.getArrayList("values") != null && !"".equals(box.get("values"))) {
				values = box.getArrayList("values");
				defaultValues = box.getArrayList("defaultValues");
				extraText = box.getArrayList("extraText");
			
		}
		boolean saveFlag = false;

		noOfFields = (Integer) generalMap.get("noOfFields");
		MasSpecialtyGroupParameter spGrpParaM = new MasSpecialtyGroupParameter();
		spGrpParaM.setId(Integer.parseInt("" + parameter));
		
		
		MasSpecialtyTemplate masTemplate=new MasSpecialtyTemplate();
		masTemplate.setId(Integer.parseInt(tempLate));

		MasDepartment masDep = new MasDepartment();
		masDep.setId(dpartName);

		MasSpecialityDeptGroup masGroup = (MasSpecialityDeptGroup) getHibernateTemplate().get(MasSpecialityDeptGroup.class, id);

		//masGroup.setId(id);
		Users user = new Users();
		user.setId(userId);

		masGroup.setSpGroup(spGrpParaM);
		if(!nadRequired.equals("")){
			masGroup.setNadRequired(nadRequired);
		}
		if(noOfFields!=0){
			masGroup.setNoOfFields(noOfFields);
		}
		
		
		if(checkbox.equalsIgnoreCase("t")){
			masGroup.setTextField("t");
			}else {
				masGroup.setTextField("n");	
			}
		
		if(dateFields.equalsIgnoreCase("y")){
			masGroup.setDateField("y");
			}else {
				masGroup.setDateField("n");	
			}
		if(grid.equalsIgnoreCase("y")){
			masGroup.setGrid("y");
			}else {
				masGroup.setGrid("n");	
			}
		if(simpleFormType.equalsIgnoreCase("y")){
			masGroup.setSimpleFormType("y");
			}else {
				masGroup.setSimpleFormType("n");	
			}
		if(mediumFormType.equalsIgnoreCase("y")){
			masGroup.setMediumFormType("y");
			}else {
				masGroup.setMediumFormType("n");	
			}
		if(complexFormType.equalsIgnoreCase("y")){
			masGroup.setComplexFormType("y");
			}else {
				masGroup.setComplexFormType("n");	
			}
		
		if(multipleSelection.equalsIgnoreCase("y")){
			masGroup.setMultipleSelection("y");
			}else {
				masGroup.setMultipleSelection("n");	
			}
		
		if(extraLov.equalsIgnoreCase("l")){
			masGroup.setExtraLov("t");
			}else {
				masGroup.setExtraLov("n");	
			}
		masGroup.setRadioText1(radioText1);
		masGroup.setRadioDefault1(radioDefault1);
		masGroup.setRadioText2(radioText2);
		masGroup.setRadioDefault2(radioDefault1);
		masGroup.setTextMaxlength(maxlength);
		masGroup.setDataType(datatype);
		masGroup.setUnitLabel(unitLabel);
		masGroup.setTextColor(textColor);
		masGroup.setTextFont(textFont);
		masGroup.setTextSize(textSize);
		masGroup.setValidationValue(validationValue);
		
		
		masGroup.setGroupSeqNo(Integer.parseInt(""+snoGp.trim()));
		
		masGroup.setParameterSeqNo(Integer.parseInt(""+snoPa.trim()));
		masGroup.setImageReq(img);
		masGroup.setTemplate(masTemplate);
		masGroup.setValueType(valueType);
		masGroup.setLastChgBy(user);
		masGroup.setLastChgDate(currentDate);
		masGroup.setLastChgTime(currentTime);
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masGroup);
		
		valueList = session.createCriteria(MasSpecialityDeptGroupValue.class).add(Restrictions.eq("DeptGroup.Id",id)).list();

		
		
		if(valueType.equalsIgnoreCase("LOV") ||  extraLov.equalsIgnoreCase("l")){
			if(valueList.size()>0){
				for(MasSpecialityDeptGroupValue lastValue : valueList){
					
					hbt.delete(lastValue);
				}
				if(values.size() >0 && values.size() != 0){
					  for (int i =0; i < values.size(); i++) {
						MasSpecialityDeptGroupValue masSpDepValue = new MasSpecialityDeptGroupValue();
						
						masSpDepValue.setValue(values.get(i));
						
						if( defaultValues != null && defaultValues.size()>0 &&  defaultValues.get(i) != null && !defaultValues.get(i).equals("")){
							masSpDepValue.setDefaultValue((String)defaultValues.get(i));
						}else{
							masSpDepValue.setDefaultValue("");
						}
						if( extraText != null && extraText.size()>0 &&  extraText.get(i) != null && !extraText.get(i).equals("")){
							masSpDepValue.setExtraText((String)extraText.get(i));
						}else{
							masSpDepValue.setExtraText("");
						}
							masSpDepValue.setDeptGroup(masGroup);
							masSpDepValue.setType(valueType);
							masSpDepValue.setLastChgBy(user);
							masSpDepValue.setStatus("y");
							MasHospital masHospital = new MasHospital();
							masHospital.setId(hospitalId);
							masSpDepValue.setHospital(masHospital);
							masSpDepValue.setLastChgDate(currentDate);
							masSpDepValue.setLastChgTime(currentTime);
							hbt.save(masSpDepValue);
							saveFlag=true;
							
					}
				 }
				
		}else{
			if(values.size() >0 && values.size() != 0){
			  for (int i =0; i < values.size(); i++) {
				MasSpecialityDeptGroupValue masSpDepValue = new MasSpecialityDeptGroupValue();

				masSpDepValue.setValue(values.get(i));
				
				if( defaultValues != null && defaultValues.size()>0 &&  defaultValues.get(i) != null && !defaultValues.get(i).equals("")){
					masSpDepValue.setDefaultValue((String)defaultValues.get(i));
				}else{
					masSpDepValue.setDefaultValue("");
				}
				
				if( extraText != null && extraText.size()>0 &&  extraText.get(i) != null && !extraText.get(i).equals("")){
					masSpDepValue.setExtraText((String)extraText.get(i));
				}else{
					masSpDepValue.setExtraText("");
				}
					masSpDepValue.setDeptGroup(masGroup);
					masSpDepValue.setType(valueType);
					masSpDepValue.setLastChgBy(user);
					masSpDepValue.setStatus("y");
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					masSpDepValue.setHospital(masHospital);
					masSpDepValue.setLastChgDate(currentDate);
					masSpDepValue.setLastChgTime(currentTime);
					hbt.save(masSpDepValue);
					saveFlag=true;
					
			}
		 }
		}
		//	saveFlag=true;
  }
		//hbt.saveOrUpdate(masGroup);
		dataUpdated = true;
		return dataUpdated;
	}

	//@Override
	public boolean deleteDepartmentGroupParameter(int id,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		int userId = 0;

		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		MasSpecialityDeptGroup masGroup = new MasSpecialityDeptGroup();
		masGroup = (MasSpecialityDeptGroup) getHibernateTemplate().get(
				MasSpecialityDeptGroup.class, id);
          id=masGroup.getDepartment().getId();
          
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		Box box =(Box) generalMap.get("box");
		
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masGroup.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masGroup.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user = new Users();
		user.setId(userId);
		masGroup.setLastChgBy(user);
		masGroup.setLastChgDate(currentDate);
		masGroup.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masGroup);
		return dataDeleted;
	}

	public Map<String, Object> searchDepartmentGroupParameter(String dipartName) {

		List<MasSpecialityDeptGroup> masSpDepGrp = new ArrayList<MasSpecialityDeptGroup>();
		Map<String, Object> dipartFieldsMap = new HashMap<String, Object>();
		List<MasDepartment> masDpList = new ArrayList<MasDepartment>();
		List<MasDepartment> masDpGridList = new ArrayList<MasDepartment>();
		List<MasSpecialtyGroupParameter> masSpGrpPara = new ArrayList<MasSpecialtyGroupParameter>();
		List<MasSpecialityGroup> masSpGroup = new ArrayList<MasSpecialityGroup>();

		try {
			
			/*
			 * if ((dipartName != null)) { masSpDepartGroup =
			 * getHibernateTemplate() .find(
			 * "from jkt.hms.masters.business.MasSpecialityDeptGroup as mas where mas.Department like '"
			 * + dipartName + "%' order by mas.Department"); }
			 */

			Criteria cr1 = getSession().createCriteria(
					MasSpecialityDeptGroup.class, "mas").createAlias(
					"mas.Department", "dgm");

			if (dipartName != null) {
				//cr1 = cr1.add(Restrictions.like("dgm.DepartmentName", "%"+ dipartName + "%"));
				cr1 = cr1.add(Restrictions.eq("dgm.Id",Integer.parseInt(dipartName)));

			}

			masSpDepGrp = cr1.list();

			masDpList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasDepartment as mad where mad.Status = 'y' or mad.Status = 'Y'");

			masDpGridList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasDepartment as mad where mad.Status = 'y' or mad.Status = 'Y'");

			masSpGroup = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasSpecialityGroup as mit where mit.Status = 'y' or mit.Status = 'Y'");

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("masdplist size" + masDpList.size());
		
		dipartFieldsMap.put("masDpList", masDpList);

		dipartFieldsMap.put("masSpDepGrp", masSpDepGrp);

		dipartFieldsMap.put("masSpGrpPara", masSpGrpPara);

		dipartFieldsMap.put("masSpGroup", masSpGroup);
		dipartFieldsMap.put("masDpGridList", masDpGridList);

		return dipartFieldsMap;
	}

	
	
	// ----------------------------------Ward------------------------------------

			public boolean addWard(MasWard masWard) {
				boolean saveFlag = false;
				try {
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.save(masWard);
					saveFlag = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return saveFlag;
			}

			@SuppressWarnings("unchecked")
			public boolean deleteWard(int wardId, Map<String, Object> generalMap) {
				boolean dataDeleted = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				MasWard masWard = new MasWard();
				masWard = (MasWard) getHibernateTemplate().get(MasWard.class,
						wardId);
				int userId=0; 
				userId = (Integer) generalMap.get("userId");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");

				if (generalMap.get("flag") != null) {
					String flag = (String) generalMap.get("flag");
					
					if (flag.equals("InActivate")) {
						masWard.setStatus("N");
						dataDeleted = true;
					} else if (flag.equals("Activate")) {
						masWard.setStatus("Y");
						dataDeleted = false;
					}
				}
				
				Users users=new Users();
				users.setId(userId);
				masWard.setLastChgBy(users);
				

				masWard.setLastChgDate(currentDate);
				masWard.setLastChgTime(currentTime);
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(masWard);
				return dataDeleted;
			}

			public boolean editWard(Map<String, Object> generalMap) {

				boolean dataUpdated = false;

				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				int wardId = 0;
				String wardName = "";
				@SuppressWarnings("unused")
				String wardCode = "";
				int villageId = 0,lsgId=0,districtId=0;

				try {
					wardId = (Integer) generalMap.get("id");
					wardCode = (String) generalMap.get("wardCode");
					wardName = (String) generalMap.get("name");
					currentDate = (Date) generalMap.get("currentDate");
					currentTime = (String) generalMap.get("currentTime");
					int userId=0; 
					userId = (Integer) generalMap.get("userId");
					int hospitalId=0; 
					hospitalId = (Integer) generalMap.get("hospitalId");
					//villageId = (Integer) generalMap.get("villageId");
					lsgId=(Integer)generalMap.get("lsgId");
					
					districtId=(Integer)generalMap.get("districtId");
					
										MasWard masWard = (MasWard) getHibernateTemplate().load(
							MasWard.class, wardId);

					masWard.setId(wardId);
					masWard.setWardName(wardName);
					Users users=new Users();
					users.setId(userId);
					masWard.setLastChgBy(users);
					
					if(hospitalId>0){
					MasHospital subCenter= new MasHospital();
					subCenter.setId(hospitalId);
					masWard.setSubCenter(subCenter);
					}

//					MasVillage masVillage= new MasVillage();
//					masVillage.setId(villageId);
//					masWard.setVillage(masVillage);
					
					//govind code
					MasLsg masLsg = new MasLsg();
					masLsg.setId(lsgId);
					masWard.setLsg(masLsg);
					
					MasDistrict masDistrict = new MasDistrict();//11-7-2016
					masDistrict.setId(districtId);
					masWard.setDistrict(masDistrict);
					
					//end
					
					masWard.setLastChgDate(currentDate);
					masWard.setLastChgTime(currentTime);

					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(masWard);
					dataUpdated = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return dataUpdated;
			}

			@SuppressWarnings("unchecked")
			public Map<String, Object> searchWard(String wardCode,
					String wardName) {
				Session session=(Session)getSession();
				List masWardList = new ArrayList();
				List masVillageList = new ArrayList();
				List masLsgList = new ArrayList();//govind code
				List<MasDistrict> masDistrictList = new ArrayList<MasDistrict>();//govind code 11-7-2016
				List masHospitalList = new ArrayList();
				Map<String, Object> map = new HashMap<String, Object>();
				try {
					if ((wardName != null) || (wardCode == null)) {
						masWardList = getHibernateTemplate().find(
								"from jkt.hms.masters.business.MasWard sc where sc.WardName like '"
										+ wardName + "%' order by sc.WardName");
					} else if (wardCode != null) {
						masWardList = getHibernateTemplate().find(
								"from jkt.hms.masters.business.MasWard sc where sc.WardCode like '"
										+ wardCode + "%' order by sc.WardCode");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				masHospitalList= getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasHospital as b where b.Status = 'y'");
				masVillageList= getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasVillage as b where b.Status = 'Y'");
				masLsgList= getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasLsg as b where b.Status = 'Y'"); //govind code
				

				masDistrictList = session.createCriteria(MasDistrict.class).createAlias("State", "state")
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.add(Restrictions.eq("state.Id", 32)).list();//govind code 11-7-2016
				
				map.put("masWardList", masWardList);
				map.put("masVillageList", masVillageList);
				map.put("masLsgList", masLsgList);//govind code
				map.put("masDistrictList", masDistrictList);//govind code 11-7-2016
				map.put("masHospitalList", masHospitalList);
				return map;
			}

			@SuppressWarnings("unchecked")
			public Map<String, Object> showWard() {
				Session session = (Session) getSession();
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasWard> masWardList = new ArrayList<MasWard>();
				//List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
				List<MasVillage> masVillageList = new ArrayList<MasVillage>();
				
				
				//govind code
				List<MasLsg> masLsgList = new ArrayList<MasLsg>();
				List<MasDistrict> masDistrictList = new ArrayList<MasDistrict>();
				masLsgList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasLsg as sc order by sc.LsgTypeName");
				//masDistrictList = getHibernateTemplate().find(
					//	"from jkt.hms.masters.business.MasDistrict as d where d.order by d.DistrictName");
				
				masDistrictList = session.createCriteria(MasDistrict.class).createAlias("State", "state")
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.add(Restrictions.eq("state.Id", 32)).list();
				
				
				
				//end code 
				
				masWardList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasWard");
				masVillageList= getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasVillage as b where b.Status = 'Y'");
				/*masHospitalList= getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasHospital as b where b.Status = 'y'");*/
				
				map.put("masWardList", masWardList);
				map.put("masVillageList", masVillageList);
				//map.put("masHospitalList", masHospitalList);
				
				//govind code 5-7-2016
				map.put("masLsgList", masLsgList);
				map.put("masDistrictList", masDistrictList);
				//end code
				
				return map;
			}
			
			// -----------------------ElectricalSection-------------------------------------------
			
			public boolean addElectricalSection(Map<String, Object> electricalSectionMap) {
				
				boolean successfullyAdded = false;
				PhMasElectricalSection phMasElectricalSection=new PhMasElectricalSection();
				if(electricalSectionMap.get("phMasElectricalSection")!=null){
					phMasElectricalSection=(PhMasElectricalSection)electricalSectionMap.get("phMasElectricalSection");
				}
				
				try{
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					
					hbt.save(phMasElectricalSection);
					
					
					successfullyAdded = true;
				}catch (Exception e) {
					successfullyAdded=false;
					e.printStackTrace();
				}
				return successfullyAdded;
			}

			public boolean editElectricalSection(Map<String, Object> generalMap) {
				boolean dataUpdated = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				int villageId = 0;
				String electricalSectionName = "";
				@SuppressWarnings("unused")
				String electricalSectionCode = "";
				int electricalSectionId = 0;
				electricalSectionId = (Integer) generalMap.get("id");
				electricalSectionCode = (String) generalMap.get("electricalSectionCode");
				electricalSectionName = (String) generalMap.get("name");
				villageId = (Integer) generalMap.get("villageId");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				int userId=0; 
				userId = (Integer) generalMap.get("userId");
				PhMasElectricalSection phMasElectricalSection = (PhMasElectricalSection) getHibernateTemplate().get(
						PhMasElectricalSection.class, electricalSectionId);

				phMasElectricalSection.setId(electricalSectionId);
				phMasElectricalSection.setElectricalSectionName(electricalSectionName);

				MasVillage masVillage = new MasVillage();
				masVillage.setId(villageId);
				phMasElectricalSection.setVillage(masVillage);

				phMasElectricalSection.setLastChgDate(currentDate);
				phMasElectricalSection.setLastChgTime(currentTime);
				
				Users users = new Users();
				users.setId(userId);
				phMasElectricalSection.setLastChgBy(users);
				
				try
				{
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(phMasElectricalSection);
					dataUpdated = true;
				}
				catch (DataAccessException e)
				{
					e.printStackTrace();
				}
				return dataUpdated;
			}

			@SuppressWarnings("unchecked")
			public Map<String, Object> searchElectricalSection(String electricalSectionCode,
					String electricalSectionName) {
				List<PhMasElectricalSection> searchElectricalSectionList = new ArrayList<PhMasElectricalSection>();
				List<MasVillage> villageList = new ArrayList<MasVillage>();
				Map<String, Object> electricalSectionFieldsMap = new HashMap<String, Object>();
				List<MasVillage> gridVillageList = new ArrayList<MasVillage>();
				try {
					if ((electricalSectionName != null) || (electricalSectionCode == null)) {
						searchElectricalSectionList = getHibernateTemplate()
								.find("from jkt.hms.masters.business.PhMasElectricalSection as dis where dis.ElectricalSectionName like '"
										+ electricalSectionName + "%' order by dis.ElectricalSectionName");
					} else {
						searchElectricalSectionList = getHibernateTemplate()
								.find("from jkt.hms.masters.business.PhMasElectricalSection as dis where dis.ElectricalSectionCode like '"
										+ electricalSectionCode + "%' order by dis.ElectricalSectionCode");
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				villageList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasVillage as isc where isc.Status = 'y' or isc.Status='Y'");
				gridVillageList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasVillage as isc");
				electricalSectionFieldsMap.put("gridVillageList", gridVillageList);
				electricalSectionFieldsMap.put("searchElectricalSectionList", searchElectricalSectionList);
				electricalSectionFieldsMap.put("villageList", villageList);
				
				logger.info("villageList"+villageList.size());
				
				return electricalSectionFieldsMap;
			}

			@SuppressWarnings("unchecked")
			public Map<String, Object> showElectricalSection() {
				Map<String, Object> map = new HashMap<String, Object>();
				List<PhMasElectricalSection> searchElectricalSectionList = new ArrayList<PhMasElectricalSection>();
				List<MasVillage> villageList = new ArrayList<MasVillage>();
				List<MasVillage> gridVillageList = new ArrayList<MasVillage>();
				try{
					searchElectricalSectionList = getHibernateTemplate().find("from jkt.hms.masters.business.PhMasElectricalSection ");
					gridVillageList = getHibernateTemplate().find("from jkt.hms.masters.business.MasVillage as isc where isc.Status = 'y' or isc.Status = 'Y'");
					villageList = getHibernateTemplate().find("from jkt.hms.masters.business.MasVillage as isc where isc.Status = 'Y' or isc.Status = 'y' ");
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				map.put("searchElectricalSectionList", searchElectricalSectionList);
				map.put("villageList", villageList);
				map.put("gridVillageList", gridVillageList);
				logger.info("villageList"+	villageList.size());
				return map;
			}

			@SuppressWarnings("unchecked")
			public boolean deleteElectricalSection(int electricalSectionId, Map<String, Object> generalMap) {
				boolean dataDeleted = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				PhMasElectricalSection phMasElectricalSection = new PhMasElectricalSection();
				phMasElectricalSection = (PhMasElectricalSection) getHibernateTemplate().get(
						PhMasElectricalSection.class, electricalSectionId);
				@SuppressWarnings("unused")
				Integer villageId = phMasElectricalSection.getVillage().getId();
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				int userId=0; 
				userId = (Integer) generalMap.get("userId");
				if (generalMap.get("flag") != null) {
					String flag = (String) generalMap.get("flag");
					List villageList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.MasVillage as isc where isc.Id='"
									+ electricalSectionId + "' and isc.Status='y'");
					if (flag.equals("InActivate")) {
						phMasElectricalSection.setStatus("n");
						dataDeleted = true;
					} else if (flag.equals("Activate")) {
						phMasElectricalSection.setStatus("y");
						dataDeleted = false;
					}
				}
				Users users = new Users();
				users.setId(userId);
				phMasElectricalSection.setLastChgBy(users);
				phMasElectricalSection.setLastChgDate(currentDate);
				phMasElectricalSection.setLastChgTime(currentTime);
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(phMasElectricalSection);
				return dataDeleted;
			}

			// -----------------------Panchayat-------------------------------------------

			public boolean addPanchayat(Map<String, Object> panchayatMap) {
				
				boolean successfullyAdded = false;
				PhMasPanchayat phMasPanchayat=new PhMasPanchayat();
				if(panchayatMap.get("phMasPanchayat")!=null){
					phMasPanchayat=(PhMasPanchayat)panchayatMap.get("phMasPanchayat");
				}
				int hospitalId=0;
				if(panchayatMap.get("hospitalId")!=null){
					hospitalId=(Integer)panchayatMap.get("hospitalId");
				}
				try{
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					
					hbt.save(phMasPanchayat);
							
					successfullyAdded = true;
				}catch (Exception e) {
					successfullyAdded=false;
					e.printStackTrace();
				}
				return successfullyAdded;
			}

			public boolean editPanchayat(Map<String, Object> generalMap) {
				boolean dataUpdated = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				int assemblyId = 0;
				String panchayatName = "";
				@SuppressWarnings("unused")
				String panchayatCode = "";
				int panchayatId = 0;
				panchayatId = (Integer) generalMap.get("id");
				panchayatCode = (String) generalMap.get("panchayatCode");
				panchayatName = (String) generalMap.get("name");
				assemblyId = (Integer) generalMap.get("assemblyId");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				int userId=0; 
				userId = (Integer) generalMap.get("userId");
				PhMasPanchayat phMasPanchayat = (PhMasPanchayat) getHibernateTemplate().get(
						PhMasPanchayat.class, panchayatId);

				phMasPanchayat.setId(panchayatId);
				phMasPanchayat.setPanchayatName(panchayatName);

				PhMasParliyamentAssembly phMasParliyamentAssembly = new PhMasParliyamentAssembly();
				phMasParliyamentAssembly.setId(assemblyId);
				phMasPanchayat.setAssembly(phMasParliyamentAssembly);

				phMasPanchayat.setLastChgDate(currentDate);
				phMasPanchayat.setLastChgTime(currentTime);
				
				Users users = new Users();
				users.setId(userId);
				phMasPanchayat.setLastChgBy(users);
				
				try
				{
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(phMasPanchayat);
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
			public Map<String, Object> searchPanchayat(String panchayatCode,
					String panchayatName) {
				List<PhMasPanchayat> searchPanchayatList = new ArrayList<PhMasPanchayat>();
				List<PhMasParliyamentAssembly> assemblyList = new ArrayList<PhMasParliyamentAssembly>();
				Map<String, Object> panchayatFieldsMap = new HashMap<String, Object>();
				List<PhMasParliyamentAssembly> gridAssemblyList = new ArrayList<PhMasParliyamentAssembly>();
				try {
					if ((panchayatName != null) || (panchayatCode == null)) {
						searchPanchayatList = getHibernateTemplate()
								.find("from jkt.hms.masters.business.PhMasPanchayat as dis where dis.PanchayatName like '"
										+ panchayatName + "%' order by dis.PanchayatName");
					} else {
						searchPanchayatList = getHibernateTemplate()
								.find("from jkt.hms.masters.business.PhMasPanchayat as dis where dis.PanchayatCode like '"
										+ panchayatCode + "%' order by dis.PanchayatCode");
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				assemblyList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.PhMasParliyamentAssembly as isc where isc.Status = 'y' or isc.Status='Y'");
				gridAssemblyList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.PhMasParliyamentAssembly as isc");
				panchayatFieldsMap.put("gridAssemblyList", gridAssemblyList);
				panchayatFieldsMap.put("searchPanchayatList", searchPanchayatList);
				panchayatFieldsMap.put("assemblyList", assemblyList);
				
				logger.info("assemblyList"+assemblyList.size());
				
				return panchayatFieldsMap;
			}

			@SuppressWarnings("unchecked")
			public Map<String, Object> showPanchayat() {
				Map<String, Object> map = new HashMap<String, Object>();
				List<PhMasPanchayat> searchPanchayatList = new ArrayList<PhMasPanchayat>();
				List<PhMasParliyamentAssembly> assemblyList = new ArrayList<PhMasParliyamentAssembly>();
				List<PhMasParliyamentAssembly> gridAssemblyList = new ArrayList<PhMasParliyamentAssembly>();
				try{
					searchPanchayatList = getHibernateTemplate().find("from jkt.hms.masters.business.PhMasPanchayat ");
					gridAssemblyList = getHibernateTemplate().find("from jkt.hms.masters.business.PhMasParliyamentAssembly as isc where isc.Status = 'y' or isc.Status = 'Y'");
					assemblyList = getHibernateTemplate().find("from jkt.hms.masters.business.PhMasParliyamentAssembly as isc where isc.Status = 'Y' or isc.Status = 'y' ");
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				map.put("searchPanchayatList", searchPanchayatList);
				map.put("assemblyList", assemblyList);
				map.put("gridAssemblyList", gridAssemblyList);
				logger.info("assemblyList"+	assemblyList.size());
				return map;
			}

			@SuppressWarnings("unchecked")
			public boolean deletePanchayat(int panchayatId, Map<String, Object> generalMap) {
				boolean dataDeleted = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				PhMasPanchayat phMasPanchayat = new PhMasPanchayat();
				phMasPanchayat = (PhMasPanchayat) getHibernateTemplate().get(
						PhMasPanchayat.class, panchayatId);
				@SuppressWarnings("unused")
				Integer assemblyId = phMasPanchayat.getAssembly().getId();
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				int userId=0; 
				userId = (Integer) generalMap.get("userId");
				if (generalMap.get("flag") != null) {
					String flag = (String) generalMap.get("flag");
					List assemblyList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.PhMasParliyamentAssembly as isc where isc.Id='"
									+ panchayatId + "' and isc.Status='y'");
					if (flag.equals("InActivate")) {
						phMasPanchayat.setStatus("n");
						dataDeleted = true;
					} else if (flag.equals("Activate")) {
						phMasPanchayat.setStatus("y");
						dataDeleted = false;
					}
				}
				Users users = new Users();
				users.setId(userId);
				phMasPanchayat.setLastChgBy(users);
				phMasPanchayat.setLastChgDate(currentDate);
				phMasPanchayat.setLastChgTime(currentTime);
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(phMasPanchayat);
				return dataDeleted;
			}

			/**
			 * Methods By Ritu
			 */
			@SuppressWarnings("unchecked")
			//@Override
			public Map<String, Object> showLocalityJsp() {
				Map<String, Object> map = new HashMap<String, Object>();
				Session session = (Session) getSession();
				List<MasWard> wardList = new ArrayList<MasWard>();
				List<PhMasLocality> phMasLocalityList = new ArrayList<PhMasLocality>();
				//govind code 12-7-2016
				List<MasLsg> masLsgList = new ArrayList<MasLsg>();
				List<MasDistrict> masDistrictList = new ArrayList<MasDistrict>();
				//end code
				
				wardList= session.createCriteria(MasWard.class).add(Restrictions.eq("Status", "Y")).list();
				phMasLocalityList = session.createCriteria(PhMasLocality.class).list();
				//govind code 12-7-2016				
				masLsgList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasLsg as sc order by sc.LsgTypeName");
						
				masDistrictList = session.createCriteria(MasDistrict.class).createAlias("State", "state")
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.add(Restrictions.eq("state.Id", 32)).list();
				
				map.put("lsgList", masLsgList);
				map.put("districtList", masDistrictList);
				//end code
				
				map.put("wardList", wardList);
				map.put("phMasLocalityList", phMasLocalityList);
				return map;
			}
			
			@SuppressWarnings("unchecked")
			//@Override
			public Map<String, Object> addLocality(Box box) {
				Map<String, Object> map = new HashMap<String, Object>();
				boolean successfullyAdded = false;
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				Session session= (Session) getSession();
				String message ="";
				try {
					List<PhMasLocality> phMasLocalityList = new ArrayList<PhMasLocality>();
					phMasLocalityList = session.createCriteria(PhMasLocality.class).add(Restrictions.eq("Ward.Id", box.getInt("wardId")))
							.add(Restrictions.like("LocalityName", "%"+box.getString("localityName")+"%").ignoreCase())
							.list();
					
					
					
					if(phMasLocalityList.size()  == 0){
						PhMasLocality phMasLocality = new PhMasLocality();

						MasWard ward = new MasWard();
						ward.setId(box.getInt("wardId"));
						phMasLocality.setWard(ward);
						
						
						MasLsg lsg = new MasLsg();
						lsg.setId(box.getInt("lsgId"));
						phMasLocality.setLsg(lsg);
						
						phMasLocality.setLocalityName(box.getString("localityName"));
												
						
						phMasLocality.setStatus("Y");
						
						Users users = new Users();
						users.setId(box.getInt("userId"));
						phMasLocality.setLastChgBy(users);
						
						phMasLocality.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
						phMasLocality.setLastChgTime(box.getString(CHANGED_TIME));
						hbt.save(phMasLocality);
						successfullyAdded = true;
					}
					else{
							message = "Name and Ward already exist.";
						}
					
				 
				}catch (DataAccessException e) {
					e.printStackTrace();
				}
				map = showLocalityJsp();
				map.put("successfullyAdded", successfullyAdded);
				map.put("message", message);
				return map;
			}
			@SuppressWarnings("unchecked")
			//@Override
			public Map<String, Object> updateLocality(Box box) {
				Map<String, Object> map = new HashMap<String, Object>();
				boolean successfullyAdded = false;
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				Session session= (Session) getSession();
				String message ="";
				try {
					List<PhMasLocality> phMasLocalityList = new ArrayList<PhMasLocality>();
					phMasLocalityList = session.createCriteria(PhMasLocality.class)
							.add(Restrictions.ne("Id", box.getInt(COMMON_ID)))
							.add(Restrictions.eq("Ward.Id", box.getInt("wardId")))
							.add(Restrictions.like("LocalityName", "%"+box.getString("localityName")+"%").ignoreCase())
							.list();
					if(phMasLocalityList.size()  == 0){
						PhMasLocality phMasLocality = (PhMasLocality) hbt.load(PhMasLocality.class,box.getInt(COMMON_ID));

						MasWard ward = new MasWard();
						ward.setId(box.getInt("wardId"));
						phMasLocality.setWard(ward);
					
						MasLsg lsg = new MasLsg();
						lsg.setId(box.getInt("lsgId"));
						phMasLocality.setLsg(lsg);
						
						phMasLocality.setLocalityName(box.getString("localityName"));
												
						
						phMasLocality.setStatus("Y");
						
						Users users = new Users();
						users.setId(box.getInt("userId"));
						phMasLocality.setLastChgBy(users);
						
						phMasLocality.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
						phMasLocality.setLastChgTime(box.getString(CHANGED_TIME));
						hbt.update(phMasLocality);
						successfullyAdded = true;
					}else{
						message = "Record already exists.";
						
					}
				} catch (DataAccessException e) {
					e.printStackTrace();
				}
				map = showLocalityJsp();
				map.put("successfullyAdded", successfullyAdded);
				map.put("message", message);
				return map;
			}
			//@Override
			public boolean deleteLocality(Box box) {
				boolean dataDeleted = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				PhMasLocality phMasLocality = (PhMasLocality) hbt.load(PhMasLocality.class,box.getInt(COMMON_ID));

				if (!box.getString("flag").equals("")) {
					String flag = box.getString("flag");
					if (flag.equals("InActivate")) {
						phMasLocality.setStatus("N");
						dataDeleted = true;
					} else if (flag.equals("Activate")) {
						phMasLocality.setStatus("Y");
						dataDeleted = true;
					}
				}
				Users users = new Users();
				users.setId(box.getInt("userId"));
				phMasLocality.setLastChgBy(users);
				phMasLocality.setLastChgDate(currentDate);
				phMasLocality.setLastChgTime(currentTime);
				hbt.update(phMasLocality);
				return dataDeleted;
			}
			@SuppressWarnings("unchecked")
			//@Override
			public Map<String, Object> searchLocality(Box box) {
				Map<String, Object> map = new HashMap<String, Object>();
				List<PhMasLocality> phMasLocalityList = new ArrayList<PhMasLocality>();
				List<MasWard> wardList = new ArrayList<MasWard>();
				Session session =(Session) getSession();
				Criteria crit = null;
				crit = session.createCriteria(PhMasLocality.class);
				if(!box.getString("searchField").equals("")){
					crit = crit.add(Restrictions.like("LocalityName",box.getString("searchField")+"%").ignoreCase());
				}
				
				phMasLocalityList = crit.list();
				wardList= session.createCriteria(MasWard.class).add(Restrictions.eq("Status", "Y")).list();
				//govind code 12-7-2016
				List<MasLsg> lsgList = new ArrayList<MasLsg>();
				List<MasDistrict> districtList = new ArrayList<MasDistrict>();
				lsgList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasLsg as sc order by sc.LsgTypeName");
								
				districtList = session.createCriteria(MasDistrict.class).createAlias("State", "state")
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.add(Restrictions.eq("state.Id", 32)).list();
				
				map.put("lsgList", lsgList);
				map.put("districtList", districtList);
				//end code
				
				map.put("wardList", wardList);
				map.put("phMasLocalityList", phMasLocalityList);
				return map;
			}

			//@Override
			public Map showParliyament() {
				Map<String, Object> map = new HashMap<String, Object>();
				List<PhMasParliyamentAssembly> searchParliyamentList = new ArrayList<PhMasParliyamentAssembly>();
				List<MasDistrict> districtList = new ArrayList<MasDistrict>();
			    List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();
				try{ 
					searchParliyamentList = getHibernateTemplate().find("from jkt.hms.masters.business.PhMasParliyamentAssembly as dis where dis.Category='P'");
					 gridDistrictList = getHibernateTemplate().find("from jkt.hms.masters.business.MasDistrict");
					districtList = getHibernateTemplate().find("from jkt.hms.masters.business.MasDistrict as isc where isc.Status = 'Y' or isc.Status = 'y' ");
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				map.put("searchParliyamentList", searchParliyamentList);
				map.put("districtList", districtList);
				map.put("gridDistrictList", gridDistrictList);
				logger.info("districtList"+districtList.size());
				 
				return map;
			}

			//@Override
			public boolean addParliyament(Map<String, Object> parliyamentMap) {
				
				boolean successfullyAdded = false;
				PhMasParliyamentAssembly phMasParliyamentAssembly=new PhMasParliyamentAssembly();
				if(parliyamentMap.get("phMasParliyamentAssembly")!=null){
					phMasParliyamentAssembly=(PhMasParliyamentAssembly)parliyamentMap.get("phMasParliyamentAssembly");
				}
			
				try{
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					
					hbt.save(phMasParliyamentAssembly);
					
					
					successfullyAdded = true;
				}catch (Exception e) {
					successfullyAdded=false;
					e.printStackTrace();
				}
				return successfullyAdded;
			}

			//@Override
			public boolean editParliyament(Map<String, Object> generalMap) {
				boolean dataUpdated = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				int  districtId= 0;
				String parliyamentName = "";
				@SuppressWarnings("unused")
				String parliyamentCode = "";
				int parliyamentId = 0;
				parliyamentId = (Integer) generalMap.get("id");
				parliyamentCode = (String) generalMap.get("code");
				parliyamentName = (String) generalMap.get("name");
				districtId = (Integer) generalMap.get("districtId");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				int userId=0; 
				userId = (Integer) generalMap.get("userId");
				PhMasParliyamentAssembly phMasParliyamentAssembly = (PhMasParliyamentAssembly) getHibernateTemplate().get(
						PhMasParliyamentAssembly.class, parliyamentId);

				phMasParliyamentAssembly.setId(parliyamentId);
				phMasParliyamentAssembly.setName(parliyamentName);

				MasDistrict masDistrict = new MasDistrict();
				masDistrict.setId(districtId);
				phMasParliyamentAssembly.setDistrict(masDistrict);

				phMasParliyamentAssembly.setLastChgDate(currentDate);
				phMasParliyamentAssembly.setLastChgTime(currentTime);
				phMasParliyamentAssembly.setCategory("P");
				
				Users users = new Users();
				users.setId(userId);
				phMasParliyamentAssembly.setLastChgBy(users);
				
				try
				{
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(phMasParliyamentAssembly);
					dataUpdated = true;
				}
				catch (DataAccessException e)
				{
					dataUpdated = false;
					e.printStackTrace();
				}
				return dataUpdated;
			}

			//@Override
			public Map<String, Object> searchParliyament(String code,
					String name) {
				
				List<PhMasParliyamentAssembly> searchParliyamentList = new ArrayList<PhMasParliyamentAssembly>();
				List<MasDistrict> districtList = new ArrayList<MasDistrict>();
				List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();
				Map<String, Object> parliyamentFieldsMap = new HashMap<String, Object>();
				
				try {
					if ((name != null) || (code == null)) {
						searchParliyamentList = getHibernateTemplate()
								.find("from jkt.hms.masters.business.PhMasParliyamentAssembly as dis where dis.Name like '"
										+ name + "%' and dis isc.Category='P' by dis.Name");
					} else {
						searchParliyamentList = getHibernateTemplate()
								.find("from jkt.hms.masters.business.PhMasParliyamentAssembly as dis where dis.Code like '"
										+ code + "%' and dis.Category='P' order by dis.Code");
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				districtList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasDistrict as isc where isc.Status = 'y' or isc.Status='Y'");
				gridDistrictList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDistrict as isc");
				parliyamentFieldsMap.put("gridDistrictList", gridDistrictList);
				parliyamentFieldsMap.put("searchParliyamentList", searchParliyamentList);
				parliyamentFieldsMap.put("districtList", districtList);
				
				logger.info("districtList"+districtList.size());
				
				return parliyamentFieldsMap;
			}

			//@Override
			public boolean deleteParliyament(int parliyamentId,Map<String, Object> generalMap) {
				boolean dataDeleted = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				PhMasParliyamentAssembly phMasParliyamentAssembly = new PhMasParliyamentAssembly();
				phMasParliyamentAssembly = (PhMasParliyamentAssembly) getHibernateTemplate().get(
						PhMasParliyamentAssembly.class, parliyamentId);
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				int userId=0; 
				userId = (Integer) generalMap.get("userId");
				if (generalMap.get("flag") != null) {
					String flag = (String) generalMap.get("flag");
						if (flag.equals("InActivate")) {
						phMasParliyamentAssembly.setStatus("N");
						dataDeleted = true;
					} else if (flag.equals("Activate")) {
						phMasParliyamentAssembly.setStatus("Y");
						dataDeleted = false;
					}
				}
				Users users = new Users();
				users.setId(userId);
				phMasParliyamentAssembly.setLastChgBy(users);
				phMasParliyamentAssembly.setLastChgDate(currentDate);
				phMasParliyamentAssembly.setLastChgTime(currentTime);
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(phMasParliyamentAssembly);
				return dataDeleted;
			}

			//@Override
			public Map showAssembly() {
				Map<String, Object> map = new HashMap<String, Object>();
				List<PhMasParliyamentAssembly> searchAssemblyList = new ArrayList<PhMasParliyamentAssembly>();
				List<PhMasParliyamentAssembly> parliyamentList = new ArrayList<PhMasParliyamentAssembly>();
				List<PhMasParliyamentAssembly> gridParliyamentList = new ArrayList<PhMasParliyamentAssembly>();
				List<MasDistrict> districtList = new ArrayList<MasDistrict>();
				List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();
				try{
					searchAssemblyList = getHibernateTemplate().find("from jkt.hms.masters.business.PhMasParliyamentAssembly as dis where dis.Category='A'");
					parliyamentList= getHibernateTemplate().find("from jkt.hms.masters.business.PhMasParliyamentAssembly as isc where isc.Status = 'Y' and isc.Category='P'");
					gridParliyamentList= getHibernateTemplate().find("from jkt.hms.masters.business.PhMasParliyamentAssembly as isc where isc.Category='P'");
					gridDistrictList = getHibernateTemplate().find("from jkt.hms.masters.business.MasDistrict");
					districtList = getHibernateTemplate().find("from jkt.hms.masters.business.MasDistrict as isc where isc.Status = 'Y' or isc.Status = 'y' ");
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				map.put("searchAssemblyList", searchAssemblyList);
				map.put("districtList", districtList);
				map.put("gridDistrictList", gridDistrictList);
				
				map.put("parliyamentList", parliyamentList);
				map.put("gridParliyamentList", gridParliyamentList);
				return map;
			}

			//@Override
			public boolean addAssembly(Map<String, Object> parliyamentMap) {
				
				boolean successfullyAdded = false;
				PhMasParliyamentAssembly phMasParliyamentAssembly=new PhMasParliyamentAssembly();
				if(parliyamentMap.get("phMasParliyamentAssembly")!=null){
					phMasParliyamentAssembly=(PhMasParliyamentAssembly)parliyamentMap.get("phMasParliyamentAssembly");
				}
			
				try{
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					
					hbt.save(phMasParliyamentAssembly);
					
					
					successfullyAdded = true;
				}catch (Exception e) {
					successfullyAdded=false;
					e.printStackTrace();
				}
				return successfullyAdded;
			}

			//@Override
			public boolean editAssembly(Map<String, Object> generalMap) {
				boolean dataUpdated = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				int  districtId= 0;
				String parliyamentName = "";
				@SuppressWarnings("unused")
				String parliyamentCode = "";
				int parliyamentId = 0;
				int assemblyId = 0;
				assemblyId= (Integer) generalMap.get("id");
				parliyamentId = (Integer) generalMap.get("parliyamentId");
				parliyamentCode = (String) generalMap.get("code");
				parliyamentName = (String) generalMap.get("name");
				districtId = (Integer) generalMap.get("districtId");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				int userId=0; 
				userId = (Integer) generalMap.get("userId");
				PhMasParliyamentAssembly phMasParliyamentAssembly = (PhMasParliyamentAssembly) getHibernateTemplate().get(
						PhMasParliyamentAssembly.class, assemblyId);

				phMasParliyamentAssembly.setId(assemblyId);
				phMasParliyamentAssembly.setName(parliyamentName);

				MasDistrict masDistrict = new MasDistrict();
				masDistrict.setId(districtId);
				phMasParliyamentAssembly.setDistrict(masDistrict);

				
				if (parliyamentId != 0) {
					PhMasParliyamentAssembly parliyament = new PhMasParliyamentAssembly();
					parliyament.setId(parliyamentId);
					phMasParliyamentAssembly.setParliyament(parliyament);
				}
				
				
				phMasParliyamentAssembly.setLastChgDate(currentDate);
				phMasParliyamentAssembly.setLastChgTime(currentTime);
				phMasParliyamentAssembly.setCategory("A");
				
				Users users = new Users();
				users.setId(userId);
				phMasParliyamentAssembly.setLastChgBy(users);
				
				try
				{
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(phMasParliyamentAssembly);
					dataUpdated = true;
				}
				catch (DataAccessException e)
				{
					dataUpdated = false;
					e.printStackTrace();
				}
				return dataUpdated;
			}

			//@Override
			public Map<String, Object> searchAssembly(String code, String name) {
				
				List<PhMasParliyamentAssembly> searchAssemblyList = new ArrayList<PhMasParliyamentAssembly>();
				List<PhMasParliyamentAssembly> parliyamentList = new ArrayList<PhMasParliyamentAssembly>();
				List<PhMasParliyamentAssembly> gridParliyamentList = new ArrayList<PhMasParliyamentAssembly>();
				
				List<MasDistrict> districtList = new ArrayList<MasDistrict>();
				List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();
				Map<String, Object> parliyamentFieldsMap = new HashMap<String, Object>();
				
				try {
					if ((name != null) || (code == null)) {
						searchAssemblyList = getHibernateTemplate()
								.find("from jkt.hms.masters.business.PhMasParliyamentAssembly as dis where dis.Name like '"
										+ name + "%' and dis.Category='A' order by dis.Name");
					} else {
						searchAssemblyList = getHibernateTemplate()
								.find("from jkt.hms.masters.business.PhMasParliyamentAssembly as dis where dis.Code like '"
										+ code + "%' and dis.Category='A' order by dis.Code");
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				districtList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasDistrict as isc where isc.Status = 'y' or isc.Status='Y'");
				gridDistrictList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDistrict as isc");
				
				parliyamentList= getHibernateTemplate().find("from jkt.hms.masters.business.PhMasParliyamentAssembly as isc where isc.Status = 'Y' and isc.Category='P'");
				gridParliyamentList= getHibernateTemplate().find("from jkt.hms.masters.business.PhMasParliyamentAssembly as isc where isc.Category='P'");
				parliyamentFieldsMap.put("gridDistrictList", gridDistrictList);
				parliyamentFieldsMap.put("searchAssemblyList", searchAssemblyList);
				parliyamentFieldsMap.put("districtList", districtList);
				
				
				parliyamentFieldsMap.put("parliyamentList", parliyamentList);
				parliyamentFieldsMap.put("gridParliyamentList", gridParliyamentList);
				
				return parliyamentFieldsMap;
			}

			//@Override
			public boolean deleteAssembly(int assemblyId,
					Map<String, Object> generalMap) {
				boolean dataDeleted = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				PhMasParliyamentAssembly phMasParliyamentAssembly = new PhMasParliyamentAssembly();
				phMasParliyamentAssembly = (PhMasParliyamentAssembly) getHibernateTemplate().get(
						PhMasParliyamentAssembly.class, assemblyId);
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				int userId=0; 
				userId = (Integer) generalMap.get("userId");
				if (generalMap.get("flag") != null) {
					String flag = (String) generalMap.get("flag");
						if (flag.equals("InActivate")) {
						phMasParliyamentAssembly.setStatus("N");
						dataDeleted = true;
					} else if (flag.equals("Activate")) {
						phMasParliyamentAssembly.setStatus("Y");
						dataDeleted = false;
					}
				}
				Users users = new Users();
				users.setId(userId);
				phMasParliyamentAssembly.setLastChgBy(users);
				phMasParliyamentAssembly.setLastChgDate(currentDate);
				phMasParliyamentAssembly.setLastChgTime(currentTime);
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(phMasParliyamentAssembly);
				return dataDeleted;
			}
			
			
			/**
			 * End
			 */
			
			
			// -----------------------CharityType-------------------------------------------
			
						public boolean addCharityType(Map<String, Object> charityTypeMap) {
							
							boolean successfullyAdded = false;
							MasCharityType masCharityType=new MasCharityType();
							if(charityTypeMap.get("masCharityType")!=null){
								masCharityType=(MasCharityType)charityTypeMap.get("masCharityType");
							}
							int hospitalId=0;
							if(charityTypeMap.get("hospitalId")!=null){
								hospitalId=(Integer)charityTypeMap.get("hospitalId");
							}
							try{
								org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
								hbt.setFlushModeName("FLUSH_EAGER");
								hbt.setCheckWriteOperations(false);
								
								hbt.save(masCharityType);
								
								
								successfullyAdded = true;
							}catch (Exception e) {
								successfullyAdded=false;
								e.printStackTrace();
							}
							return successfullyAdded;
						}

						public boolean editCharityType(Map<String, Object> generalMap) {
							boolean dataUpdated = false;
							Date currentDate = new Date();
							String currentTime = "";
							currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
									"currentTime");
							int stateId = 0;
							String charityTypeName = "";
							@SuppressWarnings("unused")
							String charityTypeCode = "";
							int charityTypeId = 0;
							charityTypeId = (Integer) generalMap.get("id");
							charityTypeCode = (String) generalMap.get("charityTypeCode");
							charityTypeName = (String) generalMap.get("name");
							currentDate = (Date) generalMap.get("currentDate");
							currentTime = (String) generalMap.get("currentTime");
							int userId=0; 
							userId = (Integer) generalMap.get("userId");
							MasCharityType masCharityType = (MasCharityType) getHibernateTemplate().get(
									MasCharityType.class, charityTypeId);

							masCharityType.setId(charityTypeId);
							masCharityType.setCharityTypeName(charityTypeName);

						

							masCharityType.setLastChgDate(currentDate);
							masCharityType.setLastChgTime(currentTime);
							
							
							Users users = new Users();
							users.setId(userId);
							masCharityType.setLastChgBy(users);
							
							try
							{
								org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
								hbt.setFlushModeName("FLUSH_EAGER");
								hbt.setCheckWriteOperations(false);
								hbt.update(masCharityType);
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
						public Map<String, Object> searchCharityType(String charityTypeCode,
								String charityTypeName) {
							List<MasCharityType> searchCharityTypeList = new ArrayList<MasCharityType>();
							Map<String, Object> charityTypeFieldsMap = new HashMap<String, Object>();
							try {
								if ((charityTypeName != null) || (charityTypeCode == null)) {
									searchCharityTypeList = getHibernateTemplate()
											.find("from jkt.hms.masters.business.MasCharityType as dis where dis.CharityTypeName like '"
													+ charityTypeName + "%' order by dis.CharityTypeName");
								} else {
									searchCharityTypeList = getHibernateTemplate()
											.find("from jkt.hms.masters.business.MasCharityType as dis where dis.CharityTypeCode like '"
													+ charityTypeCode + "%' order by dis.CharityTypeCode");
									
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							charityTypeFieldsMap.put("searchCharityTypeList", searchCharityTypeList);
							
							return charityTypeFieldsMap;
						}

						@SuppressWarnings("unchecked")
						public Map<String, Object> showCharityType() {
							Map<String, Object> map = new HashMap<String, Object>();
							List<MasCharityType> searchCharityTypeList = new ArrayList<MasCharityType>();
							try{
								searchCharityTypeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasCharityType");
							}catch (Exception e) {
								e.printStackTrace();
							}
							
							map.put("searchCharityTypeList", searchCharityTypeList);
							return map;
						}

						@SuppressWarnings("unchecked")
						public boolean deleteCharityType(int charityTypeId, Map<String, Object> generalMap) {
							boolean dataDeleted = false;
							Date currentDate = new Date();
							String currentTime = "";
							currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
									"currentTime");
							MasCharityType masCharityType = new MasCharityType();
							masCharityType = (MasCharityType) getHibernateTemplate().get(
									MasCharityType.class, charityTypeId);
							
							currentDate = (Date) generalMap.get("currentDate");
							currentTime = (String) generalMap.get("currentTime");
							int userId=0; 
							userId = (Integer) generalMap.get("userId");
							if (generalMap.get("flag") != null) {
								String flag = (String) generalMap.get("flag");
								if (flag.equals("InActivate")) {
									masCharityType.setStatus("n");
									dataDeleted = true;
								} else if (flag.equals("Activate")) {
									masCharityType.setStatus("y");
									dataDeleted = false;
								}
							}
							Users users = new Users();
							users.setId(userId);
							masCharityType.setLastChgBy(users);
							masCharityType.setLastChgDate(currentDate);
							masCharityType.setLastChgTime(currentTime);
							org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
							hbt.setFlushModeName("FLUSH_EAGER");
							hbt.setCheckWriteOperations(false);
							hbt.update(masCharityType);
							return dataDeleted;
						}
			
			// -----------------------SpecialtyTemplate-------------------------------------------
			
			public boolean addSpecialtyTemplate(Map<String, Object> specialtyTemplateMap) {
				
				boolean successfullyAdded = false;
				MasSpecialtyTemplate masSpecialtyTemplate=new MasSpecialtyTemplate();
				if(specialtyTemplateMap.get("masSpecialtyTemplate")!=null){
					masSpecialtyTemplate=(MasSpecialtyTemplate)specialtyTemplateMap.get("masSpecialtyTemplate");
				}
				int hospitalId=0;
				if(specialtyTemplateMap.get("hospitalId")!=null){
					hospitalId=(Integer)specialtyTemplateMap.get("hospitalId");
					masSpecialtyTemplate.setHospital(new MasHospital(hospitalId));
				}
				try{
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					
					hbt.save(masSpecialtyTemplate);
					
					
					successfullyAdded = true;
				}catch (Exception e) {
					successfullyAdded=false;
					e.printStackTrace();
				}
				return successfullyAdded;
			}

			public boolean editSpecialtyTemplate(Map<String, Object> generalMap) {
				boolean dataUpdated = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				int stateId = 0;
				String specialtyTemplateName = "";
				@SuppressWarnings("unused")
				String specialtyTemplateCode = "";
				int specialtyTemplateId = 0;
				specialtyTemplateId = (Integer) generalMap.get("id");
				specialtyTemplateCode = (String) generalMap.get("specialtyTemplateCode");
				specialtyTemplateName = (String) generalMap.get("name");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				int userId=0; 
				String templateType = "";
				if(generalMap.get("templateType") != null){
					templateType = (String)generalMap.get("templateType");
				}
				userId = (Integer) generalMap.get("userId");
				MasSpecialtyTemplate masSpecialtyTemplate = (MasSpecialtyTemplate) getHibernateTemplate().get(
						MasSpecialtyTemplate.class, specialtyTemplateId);

				masSpecialtyTemplate.setId(specialtyTemplateId);
				masSpecialtyTemplate.setTemplateName(specialtyTemplateName);

				masSpecialtyTemplate.setTemplateType(templateType);

				masSpecialtyTemplate.setLastChgDate(currentDate);
				masSpecialtyTemplate.setLastChgTime(currentTime);
				masSpecialtyTemplate.setTemplateType(templateType);
				
				Users users = new Users();
				users.setId(userId);
				masSpecialtyTemplate.setLastChgBy(users);
				
				try
				{
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(masSpecialtyTemplate);
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
			public Map<String, Object> searchSpecialtyTemplate(String specialtyTemplateCode,
					String specialtyTemplateName) {
				List<MasSpecialtyTemplate> searchSpecialtyTemplateList = new ArrayList<MasSpecialtyTemplate>();
				Map<String, Object> specialtyTemplateFieldsMap = new HashMap<String, Object>();
				try {
					if ((specialtyTemplateName != null) || (specialtyTemplateCode == null)) {
						searchSpecialtyTemplateList = getHibernateTemplate()
								.find("from jkt.hms.masters.business.MasSpecialtyTemplate as dis where dis.TemplateName like '"
										+ specialtyTemplateName + "%' order by dis.TemplateName");
					} else {
						searchSpecialtyTemplateList = getHibernateTemplate()
								.find("from jkt.hms.masters.business.MasSpecialtyTemplate as dis where dis.TemplateCode like '"
										+ specialtyTemplateCode + "%' order by dis.TemplateCode");
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				specialtyTemplateFieldsMap.put("searchSpecialtyTemplateList", searchSpecialtyTemplateList);
				
				
				return specialtyTemplateFieldsMap;
			}

			@SuppressWarnings("unchecked")
			public Map<String, Object> showSpecialtyTemplate() {
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasSpecialtyTemplate> searchSpecialtyTemplateList = new ArrayList<MasSpecialtyTemplate>();
				try{
					searchSpecialtyTemplateList = getHibernateTemplate().find("from jkt.hms.masters.business.MasSpecialtyTemplate");
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				map.put("searchSpecialtyTemplateList", searchSpecialtyTemplateList);
				return map;
			}

			@SuppressWarnings("unchecked")
			public boolean deleteSpecialtyTemplate(int specialtyTemplateId, Map<String, Object> generalMap) {
				boolean dataDeleted = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				MasSpecialtyTemplate masSpecialtyTemplate = new MasSpecialtyTemplate();
				masSpecialtyTemplate = (MasSpecialtyTemplate) getHibernateTemplate().get(
						MasSpecialtyTemplate.class, specialtyTemplateId);
				
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				int userId=0; 
				userId = (Integer) generalMap.get("userId");
				if (generalMap.get("flag") != null) {
					String flag = (String) generalMap.get("flag");
					if (flag.equals("InActivate")) {
						masSpecialtyTemplate.setStatus("n");
						dataDeleted = true;
					} else if (flag.equals("Activate")) {
						masSpecialtyTemplate.setStatus("y");
						dataDeleted = false;
					}
				}
				Users users = new Users();
				users.setId(userId);
				masSpecialtyTemplate.setLastChgBy(users);
				masSpecialtyTemplate.setLastChgDate(currentDate);
				masSpecialtyTemplate.setLastChgTime(currentTime);
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(masSpecialtyTemplate);
				return dataDeleted;
			}
	
			// ------------------ Getting Department Name-----------------
			
			public String getDepartmentNameFromId(int deptId) {
				Session session = (Session) getSession();
				List<MasDepartment> deptList = new ArrayList<MasDepartment>();
				String deptName = null;

				try {

					Criteria crit = session.createCriteria(MasDepartment.class).add(
							Restrictions.eq("Id", deptId));
					deptList = crit.list();
					if (deptList.size() > 0) {
						MasDepartment masDepartment = deptList.get(0);
						deptName = masDepartment.getDepartmentName();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return deptName;
			}
			
			public Map<String, Object> showSpecialtyJsp(){
				
				List<MasSpecialityDeptGroup> masForGorupParameter=new ArrayList<MasSpecialityDeptGroup>();
				List<MasSpecialtyTemplate> templateList=new ArrayList<MasSpecialtyTemplate>();
				
				templateList=getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasSpecialtyTemplate as mad where mad.Status = 'y' or mad.Status = 'Y'");
				Criteria crForTemplate=getSession().createCriteria(MasSpecialityDeptGroup.class);
					
				map.put("templateList", templateList);
				map.put("masDeptGroup", masForGorupParameter);
				return map;
				
			}
			
			public Map<String, Object> showGroupAndParameterValues(Map map){
				List<MasSpecialityDeptGroup> masForGorupParameter=new ArrayList<MasSpecialityDeptGroup>();
				List<MasSpecialityDeptGroupValue> masValue=new ArrayList<MasSpecialityDeptGroupValue>();
				List<MasSpecialtyGroupParameter> groupParameterList=new ArrayList<MasSpecialtyGroupParameter>();
				
				 
				int idForValue=0;
		    	 int departId=(Integer)map.get("deptId");
		    	 String template=(String)map.get("template");
		    	 if(template!=null && !(template.equals(""))){
 				Criteria crForGroupParameter=getSession().createCriteria(MasSpecialityDeptGroup.class,"mas")
						                      .createAlias("mas.Department", "dep")
						                       .add(Restrictions.eq("dep.Id",departId))
						                      .createAlias("mas.Template", "tem")
						                     .add(Restrictions.eq("tem.Id",Integer.parseInt(template)))	
						                     .addOrder(Order.asc("GroupSeqNo"));
				masForGorupParameter=crForGroupParameter.list();
				
				 /* Set<Integer> set=new HashSet<Integer>();
				  
					for(MasSpecialityDeptGroup deptGroup:masForGorupParameter){
						if(set.add(deptGroup.getSpGroup().getSpGroup().getId())){
							System.out.println("name"+deptGroup.getSpGroup().getSpGroup().getSpGroupName());
						}*/
						
					/*	System.out.println("group Name "+deptGroup.getSpGroup().getSpGroup().getSpGroupName());
						//System.out.println("Parameter Name "+deptGroup.getS);
						System.out.println("Value Name "+deptGroup.getValueType());
					*/	
						
					/*} commented by om tripathi no use of loop only for printting values on console */
				
				
				List<Integer> groupIds=new ArrayList<Integer>();
				for (MasSpecialityDeptGroup masSpecialityDeptGroup : masForGorupParameter) {
					groupIds.add(masSpecialityDeptGroup.getSpGroup().getSpGroup().getId());
					
					idForValue=masSpecialityDeptGroup.getId();
				logger.info(masSpecialityDeptGroup.getId());
				}
				
				if(groupIds.size()>0){
				groupParameterList=getSession().createCriteria(MasSpecialtyGroupParameter.class,"mas")
	                             .createAlias("mas.SpGroup", "sgroup")
	                          .add(Restrictions.in("sgroup.Id", groupIds)).list();
				}
				
				 Criteria crForParaValues=getSession().createCriteria(MasSpecialityDeptGroupValue.class,"masVal")
		                   .createAlias("masVal.DeptGroup", "deptGroup")
		                   .add(Restrictions.eq("deptGroup.Id", idForValue));
				 masValue=crForParaValues.list();
		    	 }	
	
				map.put("masForGorupParameter",masForGorupParameter);
				map.put("groupParameterList",groupParameterList);
				map.put("masValue",masValue);
				logger.info("mas value size"+masValue.size());
			
				return map;
			}

			//@Override
			public Map<String, Object> showPopUpForValues(Map map) {
				
			List<MasSpecialityDeptGroupValue> masValue=new ArrayList<MasSpecialityDeptGroupValue>();
			Map<String, Object> detail=new HashMap<String, Object>();
			int departmentId=0;
			if (map.get("departmentId") != null
					&& !"".equals(map.get("departmentId").toString())) {
				departmentId = Integer.parseInt(map
						.get("departmentId").toString());
			}
			Criteria cr=getSession().createCriteria(MasSpecialityDeptGroupValue.class,"mas")
					.add(Restrictions.eq("DeptGroup.Id", departmentId));
			
			masValue= cr.list();
	
			detail.put("masValue", masValue);
				
				return detail;
			}
   
	//		---------------Saving Speciality ----------------
			
			
			//@Override
			public boolean saveSpeciality(Map generalMap) {
				boolean successfullyAdded = false;
				List<Object> list=new ArrayList<Object>();
				int hsId=(Integer)generalMap.get("hsId");
				int userId=(Integer)generalMap.get("userId");
				MasHospital masHsp=new MasHospital();
				MasSpecialityDeptGroupValue groupValue=new MasSpecialityDeptGroupValue();
				
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_AUTO");
				hbt.setCheckWriteOperations(false);
				Box box=(Box) generalMap.get("box");
				if(box!=null)
				{
					int total=box.getInt("totalrecord");
					for(int i=1;i<=total;i++)
					{
						MasSpecialityDeptGroup deptGroup=(MasSpecialityDeptGroup) hbt.get(MasSpecialityDeptGroup.class, box.getInt("parameterId"+i));
						SpecialtyDepartmentDetails departmentDetails=new SpecialtyDepartmentDetails();
						departmentDetails.setDeptGroup(deptGroup);
				
						
						if(deptGroup.getTextField()!=null){
						if(deptGroup.getTextField().equalsIgnoreCase("t"))
						{
							departmentDetails.setFieldValue(box.getString("textValue"+i));
					     }else{
					    }
					    } 
		  				            	
		             if(deptGroup.getValueType().equalsIgnoreCase("LOV")){ 
							departmentDetails.setFieldValue(box.getString("presentComplain"+i));
							departmentDetails.setValueId(box.getString("presentComplainId"+i));

		            }else if(deptGroup.getValueType().equalsIgnoreCase("Radio Button")){ 
						departmentDetails.setFieldValue(box.getString("checkbox"+i));

		                  
		                  }else if(deptGroup.getValueType().equalsIgnoreCase("Check Box")){ 
		                	  departmentDetails.setFieldValue(box.getString("checkbox"+i));
		             
		               }else if(deptGroup.getValueType().equalsIgnoreCase("Text Area")){ 
		            	   departmentDetails.setFieldValue(box.getString("texarea"+i));
		             
		                 }   
		            		Users user=new Users();
		            			user.setId(userId);
							departmentDetails.setLastChgBy(user);
							departmentDetails.setStatus("y");
							masHsp.setId(hsId);
							departmentDetails.setHospital(masHsp);
		             hbt.save(departmentDetails);
		             
					}
					successfullyAdded=true;
				}
		             
		              
				/*		
						
						
					}
					
					
				}
				
				map=(Map)generalMap.get("generalMap");
				String parameterId=(String) generalMap.get("parameterId");
				String textValue=(String) generalMap.get("textValue");
				String presentComplainId=(String)generalMap.get("presentComplainId");
				String[] parameter=presentComplainId.split(",");
				String checkbox=(String)generalMap.get("checkbox");
				String radiobutton=(String)generalMap.get("radiobutton");
				String presentComplain=(String)generalMap.get("presentComplain");
				int userId=(Integer)generalMap.get("userId");
		
				Criteria crlist=getSession().createCriteria(SpecialtyDepartmentDetails.class,"spDetail")
						       .createAlias("spDetail.DeptGroup", "deptGroup")
						       .add(Restrictions.eq("deptGroup",Integer.parseInt(""+parameterId.trim())));
				
				boolean successfullyAdded = false;
				
				if(list.size()==0){
					deptGroup.setId(Integer.parseInt(""+parameterId.trim()));
								
					departmentDetails.setDeptGroup(deptGroup);
					departmentDetails.setFieldValue(textValue);
					Users user=new Users();
				 	user.setId(userId);
					departmentDetails.setLastChgBy(user);
					departmentDetails.setStatus("y");
					departmentDetails.setValueId(presentComplainId);
					departmentDetails.setHospital(hospital);
			
					
					
				}
					
					
					successfullyAdded=true;*/
				hbt.flush();
				hbt.clear();
				return successfullyAdded ;
			}

			//@Override
			public boolean editQuestions(Map<String, Object> generalMap) {
				boolean dataUpdated = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				int stateId = 0;
				String question = "";
				@SuppressWarnings("unused")
				String questionno = "";
				int questionsId = 0;
				questionsId = (Integer) generalMap.get("id");
				questionno = (String) generalMap.get("questionno");
				question = (String) generalMap.get("name");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				int userId=0; 
				userId = (Integer) generalMap.get("userId");
				MasQuestions masQuestions = (MasQuestions) getHibernateTemplate().get(
						MasQuestions.class, questionsId);

				masQuestions.setId(questionsId);
				masQuestions.setQuestion(question);

			

				masQuestions.setLastChgDate(currentDate);
				masQuestions.setLastChgTime(currentTime);
				
				
				Users users = new Users();
				users.setId(userId);
				masQuestions.setLastChgBy(users);
				
				try
				{
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(masQuestions);
					dataUpdated = true;
				}
				catch (DataAccessException e)
				{
					dataUpdated = false;
					e.printStackTrace();
				}
				return dataUpdated;
			}

			//@Override
			public Map<String, Object> showQuestions() {
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasQuestions> searchQuestionsList = new ArrayList<MasQuestions>();
				try{
					searchQuestionsList = getHibernateTemplate().find("from jkt.hms.masters.business.MasQuestions");
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				map.put("searchQuestionsList", searchQuestionsList);
				return map;
			}

			//@Override
			public Map<String, Object> searchQuestions(String questionno,
					String question) {
				List<MasQuestions> searchQuestionsList = new ArrayList<MasQuestions>();
				Map<String, Object> questionsFieldsMap = new HashMap<String, Object>();
				try {
					if ((question != null) || (questionno == null)) {
						searchQuestionsList = getHibernateTemplate()
								.find("from jkt.hms.masters.business.MasQuestions as dis where dis.Question like '"
										+ question + "%' order by dis.Question");
					} else {
						searchQuestionsList = getHibernateTemplate()
								.find("from jkt.hms.masters.business.MasQuestions as dis where dis.Questionno like '"
										+ questionno + "%' order by dis.Questionno");
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				questionsFieldsMap.put("searchQuestionsList", searchQuestionsList);
				
				return questionsFieldsMap;
			}

			//@Override
			public boolean deleteQuestions(int questionsId,
					Map<String, Object> generalMap) {
				boolean dataDeleted = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				MasQuestions masQuestions = new MasQuestions();
				masQuestions = (MasQuestions) getHibernateTemplate().get(
						MasQuestions.class, questionsId);
				
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				int userId=0; 
				userId = (Integer) generalMap.get("userId");
				if (generalMap.get("flag") != null) {
					String flag = (String) generalMap.get("flag");
					if (flag.equals("InActivate")) {
						masQuestions.setStatus("N");
						dataDeleted = true;
					} else if (flag.equals("Activate")) {
						masQuestions.setStatus("Y");
						dataDeleted = false;
					}
				}
				Users users = new Users();
				users.setId(userId);
				masQuestions.setLastChgBy(users);
				masQuestions.setLastChgDate(currentDate);
				masQuestions.setLastChgTime(currentTime);
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(masQuestions);
				return dataDeleted;
			}

			//@Override
			public boolean addQuestions(Map<String, Object> questionsMap) {
				
				boolean successfullyAdded = false;
				MasQuestions masQuestions=new MasQuestions();
				if(questionsMap.get("masQuestions")!=null){
					masQuestions=(MasQuestions)questionsMap.get("masQuestions");
				}
				int hospitalId=0;
				if(questionsMap.get("hospitalId")!=null){
					hospitalId=(Integer)questionsMap.get("hospitalId");
				}
				try{
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					
					hbt.save(masQuestions);
					
					
					successfullyAdded = true;
				}catch (Exception e) {
					successfullyAdded=false;
					e.printStackTrace();
				}
				return successfullyAdded;
			}
			
			
			// ---------------------------------------------Answers
			// -------------------------------------------
			public boolean addAnswers(MasAnswers masAnswers) {
				boolean successfullyAdded = false;
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.save(masAnswers);
				successfullyAdded = true;
				return successfullyAdded;
			}

			public boolean deleteAnswers(int unitId, Map<String, Object> generalMap) {
				boolean dataDeleted = false;
				String changedBy = "";
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");

				MasAnswers masAnswers = new MasAnswers();
				masAnswers = (MasAnswers) getHibernateTemplate().load(MasAnswers.class, unitId);
				int userId=0; 
				userId = (Integer) generalMap.get("userId");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				if (generalMap.get("flag") != null) {
					String flag = (String) generalMap.get("flag");
					if (flag.equals("InActivate")) {
						masAnswers.setStatus("N");
						dataDeleted = true;
					} else if (flag.equals("Activate")) {
						masAnswers.setStatus("Y");
						dataDeleted = false;
					}
				}
				Users users = new Users();
				users.setId(userId);
				masAnswers.setLastChgBy(users);
				masAnswers.setLastChgDate(currentDate);
				masAnswers.setLastChgTime(currentTime);
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(masAnswers);
				return dataDeleted;
			}

			public boolean editAnswersToDatabase(Map<String, Object> generalMap) {

				boolean dataUpdated = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				String answersName = "";
				int answersId = 0;
				int userId=0; 
				userId = (Integer) generalMap.get("userId");
				answersId = (Integer) generalMap.get("id");
				answersName = (String) generalMap.get("name");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				MasAnswers masAnswers = (MasAnswers) getHibernateTemplate().load(MasAnswers.class,
						answersId);

				masAnswers.setId(answersId);
				masAnswers.setAnswersName(answersName);
				Users users = new Users();
				users.setId(userId);
				masAnswers.setLastChgBy(users);
				masAnswers.setLastChgDate(currentDate);
				masAnswers.setLastChgTime(currentTime);
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(masAnswers);
				dataUpdated = true;
				return dataUpdated;
			}

			@SuppressWarnings("unchecked")
			public Map<String, Object> searchAnswers(String answersName) {
				List<MasAnswers> searchAnswersList = new ArrayList<MasAnswers>();
				Map<String, Object> answersFieldsMap = new HashMap<String, Object>();
				try {
					if ((answersName != null)) {
						searchAnswersList = getHibernateTemplate().find(
								"from jkt.hms.masters.business.MasAnswers imc where imc.AnswersName like '"
										+ answersName + "%' order by imc.AnswersName");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				answersFieldsMap.put("searchAnswersList", searchAnswersList);
				return answersFieldsMap;
			}

			@SuppressWarnings("unchecked")
			public Map<String, Object> showAnswersJsp() {
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasAnswers> searchAnswersList = new ArrayList<MasAnswers>();
				searchAnswersList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasAnswers ");
				map.put("searchAnswersList", searchAnswersList);
				return map;
			}

			//@Override
			public Map<String, Object> showQuestionAnswersJsp() {
				Map<String, Object> map = new HashMap<String, Object>();
				Session session = (Session) getSession();
				List<MasQuestions> questionsList = new ArrayList<MasQuestions>();
				List<MasAnswers> answersList = new ArrayList<MasAnswers>();
				List<MasQuestionAnswers> questionAnswersList = new ArrayList<MasQuestionAnswers>();
				questionsList= session.createCriteria(MasQuestions.class).add(Restrictions.eq("Status", "Y")).list();
				answersList= session.createCriteria(MasAnswers.class).add(Restrictions.eq("Status", "Y")).list();
				questionAnswersList = session.createCriteria(MasQuestionAnswers.class).list();
				map.put("questionsList", questionsList);
				map.put("answersList", answersList);
				map.put("questionAnswersList", questionAnswersList);
				return map;
			}

			//@Override
			public Map<String, Object> addQuestionAnswers(Box box) {
				Map<String, Object> map = new HashMap<String, Object>();
				boolean successfullyAdded = false;
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				Session session = (Session) getSession();
				String message ="";
				int userId =0;
				userId=	box.getInt("userId");
				try {
					List<MasQuestionAnswers> questionAnswersList = new ArrayList<MasQuestionAnswers>();
					questionAnswersList = session.createCriteria(MasQuestionAnswers.class).add(Restrictions.eq("Question.Id", box.getInt("questionId"))).add(Restrictions.eq("Answers.Id", box.getInt("answersId"))).list();
					
					
					if(questionAnswersList.size()  == 0){
						MasQuestionAnswers questionAnswers = new MasQuestionAnswers();

						MasQuestions question = new MasQuestions();
						question.setId(box.getInt("questionId"));
						questionAnswers.setQuestion(question);
						
						MasAnswers answers = new MasAnswers();
						answers.setId(box.getInt("answersId"));
						questionAnswers.setAnswers(answers);
						
						questionAnswers.setStatus("Y");

						Users users = new Users();
						users.setId(userId);
						questionAnswers.setLastChgBy(users);
						
						questionAnswers.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
						questionAnswers.setLastChgTime(box.getString(CHANGED_TIME));
						hbt.save(questionAnswers);
						successfullyAdded = true;
					}
					else{
							message = "Depot and Unit already exist.";
						}
					
				 
				}catch (DataAccessException e) {
					e.printStackTrace();
				}
				map = showQuestionAnswersJsp();
				map.put("successfullyAdded", successfullyAdded);
				map.put("message", message);
				return map;
			}

			//@Override
			public Map<String, Object> updateQuestionAnswers(Box box) {
				Map<String, Object> map = new HashMap<String, Object>();
				boolean successfullyAdded = false;
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				Session session = (Session)getSession();
				String message ="";
				int userId =0;
				userId=	box.getInt("userId");
				try {
					
					List<MasQuestionAnswers> questionAnswersList = new ArrayList<MasQuestionAnswers>();
					questionAnswersList = session.createCriteria(MasQuestionAnswers.class).add(Restrictions.ne("Id", box.getInt(COMMON_ID))).add(Restrictions.eq("Question.Id", box.getInt("questionId"))).add(Restrictions.eq("Answers.Id", box.getInt("answersId"))).list();
					
						if(questionAnswersList.size()  == 0){
							MasQuestionAnswers depotUnit = (MasQuestionAnswers) hbt.load(MasQuestionAnswers.class,box.getInt(COMMON_ID));

							MasQuestionAnswers questionAnswers = new MasQuestionAnswers();

							MasQuestions question = new MasQuestions();
							question.setId(box.getInt("questionId"));
							questionAnswers.setQuestion(question);
							
							MasAnswers answers = new MasAnswers();
							answers.setId(box.getInt("answersId"));
							questionAnswers.setAnswers(answers);
							
							questionAnswers.setStatus("Y");

							Users users = new Users();
							users.setId(userId);
							questionAnswers.setLastChgBy(users);
							
							questionAnswers.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
							questionAnswers.setLastChgTime(box.getString(CHANGED_TIME));
						hbt.update(depotUnit);
						successfullyAdded = true;
					}else{
						message = "Record already exists.";
						
					}
				} catch (DataAccessException e) {
					e.printStackTrace();
				}
				map = showQuestionAnswersJsp();
				map.put("successfullyAdded", successfullyAdded);
				map.put("message", message);
				return map;
			}

			//@Override
			public boolean deleteQuestionAnswers(Box box) {
				boolean dataDeleted = false;
				Date currentDate = new Date();
				String currentTime = "";
				int userId =0;
				userId=	box.getInt("userId");
		
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				MasQuestionAnswers questionAnswers = (MasQuestionAnswers) hbt.load(MasQuestionAnswers.class,box.getInt(COMMON_ID));

				if (!box.getString("flag").equals("")) {
					String flag = box.getString("flag");
					if (flag.equals("InActivate")) {
						questionAnswers.setStatus("N");
						dataDeleted = true;
					} else if (flag.equals("Activate")) {
						questionAnswers.setStatus("Y");
						dataDeleted = true;
					}
				}
				Users users = new Users();
				users.setId(userId);
				questionAnswers.setLastChgBy(users);
				questionAnswers.setLastChgDate(currentDate);
				questionAnswers.setLastChgTime(currentTime);
				hbt.update(questionAnswers);
				return dataDeleted;
			}

			//@Override
			public Map<String, Object> searchQuestionAnswers(Box box) {
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasQuestionAnswers> questionAnswersList = new ArrayList<MasQuestionAnswers>();
				List<MasQuestions> questionsList = new ArrayList<MasQuestions>();
				List<MasAnswers> answersList = new ArrayList<MasAnswers>();
				Session session = (Session)getSession();
				Criteria crit = null;
				crit = session.createCriteria(MasQuestionAnswers.class);
				if(box.getInt("questionId")!=0){
					crit = crit.add(Restrictions.eq("Question.Id", box.getInt("questionId")));
				}
				if(box.getInt("answersId")!=0){
					crit = crit.add(Restrictions.eq("Answers.Id", box.getInt("answersId")));
				}
				questionAnswersList = crit.list();
				questionsList= session.createCriteria(MasQuestions.class).add(Restrictions.eq("Status", "Y")).list();
				answersList= session.createCriteria(MasAnswers.class).add(Restrictions.eq("Status", "Y")).list();
				map.put("questionsList", questionsList);
				map.put("answersList", answersList);
				map.put("questionAnswersList", questionAnswersList);
				return map;
			}
			
			
			
			// -----------------------EmpDept-------------------------------------------
			
			public boolean addEmpDept(Map<String, Object> empDeptMap) {
				
				boolean successfullyAdded = false;
				MasEmployeeDepartment masEmpDept=new MasEmployeeDepartment();
				if(empDeptMap.get("masEmpDept")!=null){
					masEmpDept=(MasEmployeeDepartment)empDeptMap.get("masEmpDept");
				}
				int hospitalId=0;
				if(empDeptMap.get("hospitalId")!=null){
					hospitalId=(Integer)empDeptMap.get("hospitalId");
				}
				try{
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					
					hbt.save(masEmpDept);
					
					
					successfullyAdded = true;
				}catch (Exception e) {
					successfullyAdded=false;
					e.printStackTrace();
				}
				return successfullyAdded;
			}

			public boolean editEmpDept(Map<String, Object> generalMap) {
				boolean dataUpdated = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				int stateId = 0;
				String empDeptName = "";
				@SuppressWarnings("unused")
				String empDeptCode = "";
				int empDeptId = 0;
				empDeptId = (Integer) generalMap.get("id");
				empDeptCode = (String) generalMap.get("empDeptCode");
				empDeptName = (String) generalMap.get("name");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				int userId=0; 
				userId = (Integer) generalMap.get("userId");
				MasEmployeeDepartment masEmpDept = (MasEmployeeDepartment) getHibernateTemplate().get(
						MasEmployeeDepartment.class, empDeptId);

				masEmpDept.setId(empDeptId);
				masEmpDept.setEmpDeptName(empDeptName);

			

				masEmpDept.setLastChgDate(currentDate);
				masEmpDept.setLastChgTime(currentTime);
				
				
				Users users = new Users();
				users.setId(userId);
				masEmpDept.setLastChgBy(users);
				
				try
				{
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(masEmpDept);
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
			public Map<String, Object> searchEmpDept(String empDeptCode,
					String empDeptName) {
				List<MasEmployeeDepartment> searchEmpDeptList = new ArrayList<MasEmployeeDepartment>();
				Map<String, Object> empDeptFieldsMap = new HashMap<String, Object>();
				try {
					if ((empDeptName != null) || (empDeptCode == null)) {
						searchEmpDeptList = getHibernateTemplate()
								.find("from jkt.hms.masters.business.MasEmployeeDepartment as dis where lower(dis.EmpDeptName) like '"
										+ empDeptName.toLowerCase() + "%' order by dis.EmpDeptName");
					} else {
						searchEmpDeptList = getHibernateTemplate()
								.find("from jkt.hms.masters.business.MasEmployeeDepartment as dis where lower(dis.EmpDeptCode) like '"
										+ empDeptCode.toLowerCase() + "%' order by dis.EmpDeptCode");
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				empDeptFieldsMap.put("searchEmpDeptList", searchEmpDeptList);
				
				return empDeptFieldsMap;
			}

			@SuppressWarnings("unchecked")
			public Map<String, Object> showEmpDept() {
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasEmployeeDepartment> searchEmpDeptList = new ArrayList<MasEmployeeDepartment>();
				try{
					searchEmpDeptList = getHibernateTemplate().find("from jkt.hms.masters.business.MasEmployeeDepartment");
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				map.put("searchEmpDeptList", searchEmpDeptList);
				return map;
			}

			@SuppressWarnings("unchecked")
			public boolean deleteEmpDept(int empDeptId, Map<String, Object> generalMap) {
				boolean dataDeleted = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				MasEmployeeDepartment masEmpDept = new MasEmployeeDepartment();
				masEmpDept = (MasEmployeeDepartment) getHibernateTemplate().get(
						MasEmployeeDepartment.class, empDeptId);
				
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				int userId=0; 
				userId = (Integer) generalMap.get("userId");
				if (generalMap.get("flag") != null) {
					String flag = (String) generalMap.get("flag");
					if (flag.equals("InActivate")) {
						masEmpDept.setStatus("n");
						dataDeleted = true;
					} else if (flag.equals("Activate")) {
						masEmpDept.setStatus("y");
						dataDeleted = false;
					}
				}
				Users users = new Users();
				users.setId(userId);
				masEmpDept.setLastChgBy(users);
				masEmpDept.setLastChgDate(currentDate);
				masEmpDept.setLastChgTime(currentTime);
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(masEmpDept);
				return dataDeleted;
			}

			//@Override
			public Map<String, Object> showInstWiseEmpDeptJsp(Map<String, Object> dataMap) {
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasEmployeeDepartment> empDeptList = new ArrayList<MasEmployeeDepartment>();
				List<MasHospital> instituteList = new ArrayList<MasHospital>();
				Session session = (Session) getSession();
				List<HrInstEmpDept> searchHrInstEmpDeptList = new ArrayList<HrInstEmpDept>();
				List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
				List<MasDistrict> mdistrictList = new ArrayList<MasDistrict>();
				int hospitalId = 0;
				
				if(dataMap.get("hospitalId")!=null){
					hospitalId = (Integer)dataMap.get("hospitalId");
				}
				
				int userType =0;
				int loginUserId = 0;
				if (dataMap.get("userType") != null) {
					userType = (Integer)dataMap.get("userType");
				}
				if (dataMap.get("userId") != null) {
					loginUserId =(Integer)dataMap.get("userId");
				}
				searchHrInstEmpDeptList = session.createCriteria(HrInstEmpDept.class)
						.add(Restrictions.eq("Status","y").ignoreCase())
						.list();
				
				 									
				empDeptList = session.createCriteria(MasEmployeeDepartment.class).add(Restrictions.eq("Status","y").ignoreCase()).list();

		 		
				instituteList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status","y").ignoreCase())
						//.add(Restrictions.eq("Id",hospitalId))
						.list();
				List<Object[]> hrInstWiseEmpDeptStringList = new ArrayList<Object[]>();
				hrInstWiseEmpDeptStringList = session.createCriteria(HrInstEmpDept.class).createAlias("Institute", "i").add(Restrictions.eq("i.Id",hospitalId))
							.setProjection(Projections.projectionList().add(Projections.property("EmployeeDepartment")).add(Projections.property("Id"))).list();
				
				List<Integer> hidList = new ArrayList<Integer>();
	
				if(hrInstWiseEmpDeptStringList.size() > 0){
					
					Object[] obj = hrInstWiseEmpDeptStringList.get(0);
					int hrInsitEmpDepId = (Integer)obj[1];
					String hIds = (String)obj[0];
					String[] houseId = hIds.split(",");
					for (int i = 0; i < houseId.length; i++) {
						hidList.add(Integer.parseInt(houseId[i].trim()));
					}
				List<MasEmployeeDepartment> employeeDepartmentList = session.createCriteria(MasEmployeeDepartment.class).add(Restrictions.in("Id", hidList)).list();
				map.put("employeeDepartmentList", employeeDepartmentList);
				map.put("hrInsitEmpDepId", hrInsitEmpDepId);
				}
				
				mhospitalTypetList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasHospitalType as isc where UPPER(isc.Status) = 'Y' order by HospitalTypeName asc");
				mdistrictList = session.createCriteria(MasDistrict.class)
						.add(Restrictions.eq("Status","y").ignoreCase())
						.createAlias("State", "State").add(Restrictions.eq("State.Id", 32))
						.list();
				

				/**
				 * For PH Admin
				 */
				if(userType==5){
					List<Object[]> bsScInstList = new ArrayList<Object[]>();
					bsScInstList  = session.createCriteria(UserHospital.class).createAlias("Hospital", "h")
							.add(Restrictions.eq("User.Id", loginUserId)).add(Restrictions.eq("Status", "y").ignoreCase())
							.setProjection(Projections.projectionList().add(Projections.property("h.Id")).add(Projections.property("h.HospitalName")).add(Projections.property("h.HospitalType.Id"))).addOrder(Order.asc("h.HospitalName")).list();
					map.put("bsScInstList", bsScInstList);
				}
				
				
				map.put("mhospitalTypetList", mhospitalTypetList);
				map.put("mdistrictList", mdistrictList);
				map.put("searchHrInstEmpDeptList", searchHrInstEmpDeptList);
				map.put("empDeptList", empDeptList);
				map.put("instituteList", instituteList);

				return map;
				}			

			
				//@Override
				public Map<String, Object> showInstWiseEmpDeptMapJsp(int Inst_id) {
					Map<String,Object>  map=new HashMap<String,Object>();
					List<MasEmployeeDepartment>   empDeptList = new ArrayList<MasEmployeeDepartment>();
					List<MasHospital>   hosList = new ArrayList<MasHospital>();;
					List<HrInstEmpDept> hrInstEmpDeptMapList = new ArrayList<HrInstEmpDept>();
					Session session = (Session) getSession();
					try {
						hosList  =getHibernateTemplate().find( "from jkt.hms.masters.business.MasHospital where UPPER(status) = 'Y'");
						empDeptList  =getHibernateTemplate().find( "from jkt.hms.masters.business.MasEmployeeDepartment where UPPER(status) = 'Y'");
						hrInstEmpDeptMapList =getHibernateTemplate().find( "from jkt.hms.masters.business.HrInstEmpDept m where m.Status='y' and  m.Institute.Id = " + Inst_id);
						//mstrTaskList    =getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrTask");
						
						
						
						
						

						
					} catch (DataAccessException e) {
						e.printStackTrace();
					}  
					map.put("hosList",hosList);
					map.put("empDeptList",empDeptList);
					map.put("hrInstEmpDeptMapList",hrInstEmpDeptMapList);
					return map;
				}
				
				public List<HrInstEmpDept> getInstituteWiseEmpDeptMap(Map parameterMap) {
					Integer insti_id = (Integer)parameterMap.get("instiId");
					String status  = (String)parameterMap.get("status");
					 List empDeptList  = new ArrayList();
					 List<HrInstEmpDept> midList= new ArrayList<HrInstEmpDept>();
					 empDeptList  = (List)parameterMap.get("empDeptList");
				    logger.info(insti_id+"--"+empDeptList);
				    if(empDeptList != null){
					Criteria criteria =  getSession().createCriteria(HrInstEmpDept.class)
													 .add(Restrictions.in("EmployeeDepartment", empDeptList))
													 .add(Restrictions.eq("Status", status))
													 .add(Restrictions.eq("Institute.Id", insti_id));
					midList = criteria.list();
				    }
					return midList;
				}

				//@Override
				public  Map<String, Object> saveInstWiseEmpDept(Map<String, Object> detailsMap) {
					Map<String, Object> map = new HashMap<String, Object>();
					boolean saved = false;
					Map<String, Object> utilMap = new HashMap<String, Object>();
					utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
					String currentDate = (String) utilMap.get("currentDate");
					String time = (String) utilMap.get("currentTime");
					Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
					HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					Session session = (Session) getSession();
					String flag=""; 
					if (detailsMap.get("flag") != null) {
						flag=(String)detailsMap.get("flag");
					}
					
					if(flag.equalsIgnoreCase("u"))
					{
						int hrInsitEmpDepId=0;
						if (detailsMap.get("hrInsitEmpDepId") != null) {
							hrInsitEmpDepId=(Integer)detailsMap.get("hrInsitEmpDepId");
						}
						
						logger.info(detailsMap.get("instId"));
						HrInstEmpDept hrInstEmpDept = (HrInstEmpDept) hbt.load(HrInstEmpDept.class, hrInsitEmpDepId);
						try {
							int instId=0;
							if (detailsMap.get("instId") != null) {
								instId = (Integer) detailsMap.get("instId");
								MasHospital hospital = new MasHospital();
								hospital.setId(instId);
								hrInstEmpDept.setInstitute(hospital);
							}
							String houseStr = "";
							if (detailsMap.get("houseStr") != null) {
								houseStr = (String) detailsMap.get("houseStr");
								hrInstEmpDept.setEmployeeDepartment(houseStr);
							}
							hrInstEmpDept.setLastChgDate(date);
							hrInstEmpDept.setLastChgTime(time);
							hrInstEmpDept.setStatus("Y");
							
							int userId=0;
							
							if (detailsMap.get("userId") != null) {
								userId= (Integer)detailsMap.get("userId");
							Users users= new Users();
							users.setId(userId);
							hrInstEmpDept.setLastChgBy(users);
							}
									
							hbt.update(hrInstEmpDept);
							saved = true;
					
							
						}
						catch (Exception e) {
							saved = false;
							e.printStackTrace();
						}
					
					}
					else{
						HrInstEmpDept hrInstEmpDept = new HrInstEmpDept();
						
						try {
							
						
							int instId=0;
							if (detailsMap.get("instId") != null) {
								instId = (Integer) detailsMap.get("instId");
								MasHospital hospital = new MasHospital();
								hospital.setId(instId);
								hrInstEmpDept.setInstitute(hospital);
							}
							String houseStr = "";
							if (detailsMap.get("houseStr") != null) {
								houseStr = (String) detailsMap.get("houseStr");
								hrInstEmpDept.setEmployeeDepartment(houseStr);
							}
							hrInstEmpDept.setLastChgDate(date);
							hrInstEmpDept.setLastChgTime(time);
							hrInstEmpDept.setStatus("Y");
							
							int userId=0;
							
							if (detailsMap.get("userId") != null) {
								userId= (Integer)detailsMap.get("userId");
							Users users= new Users();
							users.setId(userId);
							hrInstEmpDept.setLastChgBy(users);
							}
							

							hbt.save(hrInstEmpDept);
							saved = true;
							
					
							
						}
						catch (Exception e) {
							saved = false;
							e.printStackTrace();
						}
					}
					map.put("flag", flag);
					map.put("saved", saved);
					return map;
			}

				//@Override
				public Map<String, Object> fillHospital(int val,
						Map<String, Object> detailsMap) {
					Map<String, Object> map = new HashMap<String, Object>();
					List<MasEmployeeDepartment> empDeptHospList = new ArrayList<MasEmployeeDepartment>();
					Session session = (Session) getSession();
					
			
					 									
					empDeptHospList = session.createCriteria(MasEmployeeDepartment.class).add(Restrictions.eq("Status","y").ignoreCase())
							//.add(Restrictions.eq("Id",val))
							.list();

			 	
					List<Object[]> hrInstWiseEmpDeptStringList = new ArrayList<Object[]>();
					hrInstWiseEmpDeptStringList = session.createCriteria(HrInstEmpDept.class).createAlias("Institute", "i").add(Restrictions.eq("i.Id",val))
								.setProjection(Projections.projectionList().add(Projections.property("EmployeeDepartment")).add(Projections.property("Id"))).list();
					
					
					List<Integer> hidList = new ArrayList<Integer>();
		
					if(hrInstWiseEmpDeptStringList.size() > 0){
						
						Object[] obj = hrInstWiseEmpDeptStringList.get(0);
						int hrInsitEmpDepId = (Integer)obj[1];
						String hIds = (String)obj[0];
						String[] houseId = hIds.split(",");
						for (int i = 0; i < houseId.length; i++) {
							hidList.add(Integer.parseInt(houseId[i].trim()));
						}
						
						logger.info("hid list size"+hidList.size() +" hrInsitEmpDepId"+ hrInsitEmpDepId);
						
					List<MasEmployeeDepartment> employeeDepartmentHosList = session.createCriteria(MasEmployeeDepartment.class).add(Restrictions.in("Id", hidList)).list();
					logger.info(employeeDepartmentHosList.size()+"-----------------");
					map.put("employeeDepartmentHosList", employeeDepartmentHosList);
					map.put("hrInsitEmpDepId", hrInsitEmpDepId);
					}
					map.put("empDeptHospList", empDeptHospList);

					return map;
					}
				
				
				
				//@Override
				public Map<String, Object> showEmpSCMappingJsp(int hospitalId) {
					Map<String, Object> map = new HashMap<String, Object>();
					List<MasInstituteDepartment> masInstituteDepartmentList = new ArrayList<MasInstituteDepartment>();
					List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
					
					List<MasEmpCategory> employeeCategoryList = new ArrayList<MasEmpCategory>();
					
					Session session = (Session) getSession();
					List<EmpScMapping> searchEmpScMappingList = new ArrayList<EmpScMapping>();
					
					
			/*		searchEmpScMappingList = session.createCriteria(EmpScMapping.class)
							//.add(Restrictions.eq("Status","y").ignoreCase())
							.list();
					*/
					 									
					masInstituteDepartmentList = session.createCriteria(MasInstituteDepartment.class).createAlias("Department", "dept")
							.add(Restrictions.eq("Institute.Id", hospitalId)).add(Restrictions.eq("Status","y").ignoreCase()).addOrder(Order.asc("dept.DepartmentName")).list();

			 		
				/*	employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status","y").ignoreCase())
							.add(Restrictions.eq("Hospital.Id",hospitalId)).addOrder(Order.asc("EmployeeName"))
							.list();
					*/
					employeeCategoryList = session.createCriteria(MasEmpCategory.class).add(Restrictions.eq("Status","y").ignoreCase())
							.addOrder(Order.asc("EmpCategoryName"))
							.list();
					
					
				/*	List<Object[]> empSCMappingStringList = new ArrayList<Object[]>();
					empSCMappingStringList = session.createCriteria(EmpScMapping.class).createAlias("Employee", "i").createAlias("i.Hospital", "h").add(Restrictions.eq("h.Id",hospitalId))
								.setProjection(Projections.projectionList().add(Projections.property("ServiceCentreId")).add(Projections.property("Id"))).list();
					
					List<Integer> hidList = new ArrayList<Integer>();
		
					if(empSCMappingStringList.size() > 0){
						
						Object[] obj = empSCMappingStringList.get(0);
						int scId = (Integer)obj[1];
						String hIds = (String)obj[0];
						String[] houseId = hIds.split(",");
						for (int i = 0; i < houseId.length; i++) {
							hidList.add(Integer.parseInt(houseId[i].trim()));
						}
					List<MasInstituteDepartment> instituteDepartmentList = session.createCriteria(MasInstituteDepartment.class).createAlias("Department", "dept").add(Restrictions.in("Id", hidList))
							.addOrder(Order.asc("dept.DepartmentName")).add(Restrictions.eq("Status","y").ignoreCase()).list();
					map.put("instituteDepartmentList", instituteDepartmentList);
					map.put("scId", scId);
					}
					map.put("searchEmpScMappingList", searchEmpScMappingList);*/
					map.put("employeeList", employeeList);
					map.put("masInstituteDepartmentList", masInstituteDepartmentList);
					map.put("employeeCategoryList", employeeCategoryList);
					return map;
					}
				
				
				//@Override
				public  Map<String, Object> saveEmpSCMapping(Map<String, Object> detailsMap) {
					Map<String, Object> map = new HashMap<String, Object>();
					List<EmpScMapping> existingEmpScMappingList = new ArrayList<EmpScMapping>();
					boolean saved = false;
					Map<String, Object> utilMap = new HashMap<String, Object>();
					utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
					String currentDate = (String) utilMap.get("currentDate");
					String time = (String) utilMap.get("currentTime");
					Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
					HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					Session session = (Session) getSession();
					
					String flag=""; 
					int empId = 0;
					
					int seviceCenterrId=0,empcategoryId=0;
					int userId=0;
					int hospitalId = 0;
					if (detailsMap.get("userId") != null) {
						userId= (Integer)detailsMap.get("userId");
					}
					//List<Integer>serviceCenterList = new ArrayList<Integer>();
					List<Integer> employeeList = new ArrayList<Integer>();
					/*if (detailsMap.get("empId") != null) {
						empId=(Integer)detailsMap.get("empId");
					}*/
					if (detailsMap.get("seviceCenterrId") != null) {
						seviceCenterrId=(Integer)detailsMap.get("seviceCenterrId");
					}
					if (detailsMap.get("hospitalId") != null) {
						hospitalId=(Integer)detailsMap.get("hospitalId");
					}
					logger.info("hospitalId=in ds==="+hospitalId);
					if (detailsMap.get("employeeList") != null) {
						employeeList=(List)detailsMap.get("employeeList");
					}
					if (detailsMap.get("flag") != null) {
						flag=(String)detailsMap.get("flag");
					}
					
					//govind code 13-12-2016 
					if (detailsMap.get("empcategoryId") != null) {
						empcategoryId=(Integer)detailsMap.get("empcategoryId");
					}
					logger.info("hospitalId "+hospitalId+" seviceCenterrId "+seviceCenterrId+" empcategoryId "+empcategoryId);
					existingEmpScMappingList = session.createCriteria(EmpScMapping.class)
							.createAlias("Department", "Department")
							.createAlias("Employee", "emp")
							.add(Restrictions.eq("emp.EmpCategory.Id", empcategoryId))
							.add(Restrictions.eq("Department.Id", seviceCenterrId))
							.add(Restrictions.eq("Hospital.Id", hospitalId))
										//.add(Restrictions.in("Department.Id", serviceCenterList))
							.list();
					logger.info("old existingEmpScMappingList--"+existingEmpScMappingList.size());
					if(existingEmpScMappingList.size()>0){
						for(EmpScMapping scMapping : existingEmpScMappingList){
							hbt.delete(scMapping);
							saved = true;
						}
					}
					//govind code 13-12-2016 end
					for(int i=0;i<employeeList.size();i++){
						empId=employeeList.get(i);
					/*existingEmpScMappingList = session.createCriteria(EmpScMapping.class).createAlias("Department", "Department")
							.add(Restrictions.eq("Employee.Id", empId))
							.add(Restrictions.eq("Department.Id", seviceCenterrId))
										//.add(Restrictions.in("Department.Id", serviceCenterList))
							.list();*/
					
					/*if(existingEmpScMappingList.size()>0){
						for(EmpScMapping scMapping : existingEmpScMappingList){
							hbt.delete(scMapping);
						}
						//for(int i=0;i<employeeList.size();i++){
							
							 EmpScMapping empScMapping = new EmpScMapping();
							/*MasDepartment masDepartment = new MasDepartment();
						 	masDepartment.setId(serviceCenterList.get(i));
						 	empScMapping.setDepartment(masDepartment);*/
						/*	 MasEmployee masEmployee=new MasEmployee();
							 masEmployee.setId(employeeList.get(i));
							 empScMapping.setEmployee(masEmployee);*/
						 	/*if(empId != 0){
						 		MasEmployee masEmployee = new MasEmployee();
								masEmployee.setId(empId);
								empScMapping.setEmployee(masEmployee);
						 	}*/
						/*	 if(seviceCenterrId != 0){
								 MasDepartment masDepartment = new MasDepartment();
								 masDepartment.setId(seviceCenterrId);
									empScMapping.setDepartment(masDepartment);
							 	}
							 
						 	if(hospitalId != 0){
						 		MasHospital masHospital = new MasHospital();
						 		masHospital.setId(hospitalId);
						 		empScMapping.setHospital(masHospital);
						 	}
							empScMapping.setLastChgDate(date);
							empScMapping.setLastChgTime(time);
							
							Users users= new Users();
							users.setId(userId);
							empScMapping.setLastChgBy(users);
							hbt.save(empScMapping);
						//}
						saved = true;
					}else{*/
						//for(int i=0;i<employeeList.size();i++){
							 EmpScMapping empScMap = new EmpScMapping();
							/*MasDepartment masDepartment = new MasDepartment();
						 	masDepartment.setId(serviceCenterList.get(i));
						 	empScMap.setDepartment(masDepartment);*/
							 
							 MasEmployee masEmployee=new MasEmployee();
							 masEmployee.setId(employeeList.get(i));
							 empScMap.setEmployee(masEmployee);
						 	/*
						 	if(empId != 0){
						 		MasEmployee masEmployee = new MasEmployee();
								masEmployee.setId(empId);
								empScMap.setEmployee(masEmployee);
						 	}*/
							 
							 if(seviceCenterrId != 0){
								 MasDepartment masDepartment = new MasDepartment();
								 masDepartment.setId(seviceCenterrId);
								 empScMap.setDepartment(masDepartment);
							 	}
						 	if(hospitalId != 0){
						 		MasHospital masHospital = new MasHospital();
						 		masHospital.setId(hospitalId);
						 		empScMap.setHospital(masHospital);
						 	}
						 	empScMap.setLastChgDate(date);
						 	empScMap.setLastChgTime(time);
							
							Users users= new Users();
							users.setId(userId);
							empScMap.setLastChgBy(users);
							hbt.save(empScMap);
						//}
						saved = true;
					//}
					}//changed by govind 13-12-2016
					
				/*	if(flag.equalsIgnoreCase("u"))
					{
						int scId=0;
						if (detailsMap.get("scId") != null) {
							scId=(Integer)detailsMap.get("scId");
						}
						
						System.out.println(detailsMap.get("empId"));
						EmpScMapping empScMapping = (EmpScMapping) hbt.load(EmpScMapping.class, scId);
						try {
							int empId=0;
							if (detailsMap.get("empId") != null) {
								empId = (Integer) detailsMap.get("empId");
								MasEmployee emp = new MasEmployee();
								emp.setId(empId);
								empScMapping.setEmployee(emp);
							}
							String houseStr = "";
							if (detailsMap.get("houseStr") != null) {
								houseStr = (String) detailsMap.get("houseStr");
								empScMapping.setServiceCentreId(houseStr);
							}
							empScMapping.setLastChgDate(date);
							empScMapping.setLastChgTime(time);
							//empScMapping.setStatus("Y");
							
							int userId=0;
							
							if (detailsMap.get("userId") != null) {
								userId= (Integer)detailsMap.get("userId");
							Users users= new Users();
							users.setId(userId);
							empScMapping.setLastChgBy(users);
							}
									
							hbt.update(empScMapping);
							saved = true;
					
							
						}
						catch (Exception e) {
							saved = false;
							e.printStackTrace();
						}
					
					}
					else{
						EmpScMapping empScMapping = new EmpScMapping();
						
						try {
							
						
							int empId=0;
							if (detailsMap.get("empId") != null) {
								empId = (Integer) detailsMap.get("empId");
								MasEmployee emp = new MasEmployee();
								emp.setId(empId);
								empScMapping.setEmployee(emp);
							}
							String houseStr = "";
							if (detailsMap.get("houseStr") != null) {
								houseStr = (String) detailsMap.get("houseStr");
								empScMapping.setServiceCentreId(houseStr);
							}
							empScMapping.setLastChgDate(date);
							empScMapping.setLastChgTime(time);
							//empScMapping.setStatus("Y");
							
							int userId=0;
							
							if (detailsMap.get("userId") != null) {
								userId= (Integer)detailsMap.get("userId");
							Users users= new Users();
							users.setId(userId);
							empScMapping.setLastChgBy(users);
							}
							

							hbt.save(empScMapping);
							saved = true;
							
					
							
						}
						catch (Exception e) {
							saved = false;
							e.printStackTrace();
						}
					}*/
					map.put("flag", flag);
					map.put("saved", saved);
					return map;
			}

				//@Override
				public Map<String, Object> fillEmployee(int val,
						Map<String, Object> detailsMap) {
					Map<String, Object> map = new HashMap<String, Object>();
					List<MasInstituteDepartment> instDeptList = new ArrayList<MasInstituteDepartment>();
					Session session = (Session) getSession();
					int hospitalId = (Integer)detailsMap.get("hospitalId");
					int empcategoryId = (Integer)detailsMap.get("empcategoryId");
			logger.info("empcategoryId "+empcategoryId +"val "+val + "hospitalId "+hospitalId);
					 									
					instDeptList = session.createCriteria(MasInstituteDepartment.class).
							createAlias("Department", "dept").add(Restrictions.eq("Status","y").ignoreCase())
							.add(Restrictions.eq("Institute.Id",hospitalId)).addOrder(Order.asc("dept.DepartmentName"))
							.list();

			 	
					/*List<Object[]> empSCMappingStringList = new ArrayList<Object[]>();
					empSCMappingStringList = session.createCriteria(EmpScMapping.class).createAlias("Employee", "i")
							.createAlias("Department", "dept").add(Restrictions.eq("i.Id",val))
							.addOrder(Order.asc("dept.DepartmentName"))
								.setProjection(Projections.projectionList().add(Projections.property("dept.Id")).add(Projections.property("Id"))
										.add(Projections.property("dept.DepartmentName"))).list();*/
					
					List<Object[]> empSCMappingStringList = new ArrayList<Object[]>();
					if(val>0){
					empSCMappingStringList = session.createCriteria(EmpScMapping.class).createAlias("Employee", "i").createAlias("Hospital", "hospital")
							.createAlias("Department", "dept").add(Restrictions.eq("dept.Id",val)).add(Restrictions.eq("i.EmpCategory.Id",empcategoryId))
							.addOrder(Order.asc("i.EmployeeName")).add(Restrictions.eq("hospital.Id", hospitalId))
								.setProjection(Projections.projectionList().add(Projections.property("i.Id")).add(Projections.property("Id"))
										.add(Projections.property("i.EmployeeName"))).list();
					}
					
					List<MasEmployee> employeeByCategoryList = new ArrayList<MasEmployee>();
					employeeByCategoryList = session.createCriteria(MasEmployee.class)
							.createAlias("EmpCategory", "EmpCategory")
							//.createAlias("Department", "department")
							.add(Restrictions.eq("EmpCategory.Id",empcategoryId))
							//.add(Restrictions.eq("Department.Id",val))
							.add(Restrictions.eq("Status","y").ignoreCase())
							.add(Restrictions.eq("Hospital.Id",hospitalId)).addOrder(Order.asc("EmployeeName"))
							.list();
					
					
					map.put("employeeByCategoryList", employeeByCategoryList);
					/*int scId  = 0;
					List<Integer> hidList = new ArrayList<Integer>();
		
					if(empSCMappingStringList.size() > 0){
						for(Object[] obj:empSCMappingStringList){
						//Object[] obj = empSCMappingStringList.get(0);
						 scId = (Integer)obj[1];
						int hIds = (Integer)obj[0];
						System.out.println("hIds==department=="+hIds);
						//String[] houseId = hIds.split(",");
						//for (int i = 0; i < houseId.length; i++) {
							hidList.add(hIds);
						}
						List<MasInstituteDepartment> masInstituteDepartmentEmpList = session.createCriteria(MasInstituteDepartment.class).createAlias("Department", "dept")
								.add(Restrictions.eq("Status","y").ignoreCase()).add(Restrictions.in("dept.Id", hidList)).addOrder(Order.asc("dept.DepartmentName")).list();
						System.out.println("masInstituteDepartmentEmpList=="+masInstituteDepartmentEmpList.size());
					map.put("masInstituteDepartmentEmpList", masInstituteDepartmentEmpList);
					map.put("scId", scId);
					}*/
					map.put("instDeptList", instDeptList);
					map.put("empSCMappingStringList", empSCMappingStringList);

					return map;
					}

				//@Override
				public Map showAccountSchedule() {
					Map<String, Object> map = new HashMap<String, Object>();
					List<MasAccountSchedule> masAccountScheduleList = new ArrayList<MasAccountSchedule>();
					Session session = (Session) getSession();
					masAccountScheduleList =session.createCriteria(MasAccountSchedule.class)
											.addOrder(Order.asc("ScheduleName")).list(); 
							
							
							
					
					map.put("masAccountScheduleList", masAccountScheduleList);
					
					
					return map;
				}

				//@Override
				public boolean addAccountSchedule(
						MasAccountSchedule masAccountSchedule) {
					boolean saveFlag = false;
					try {
						org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
						hbt.setFlushModeName("FLUSH_EAGER");
						hbt.setCheckWriteOperations(false);
						hbt.save(masAccountSchedule);
						saveFlag = true;
					} catch (Exception e) {
						e.printStackTrace();
					}
					return saveFlag;
				}

				//@Override
				public boolean editAccountSchedule(
						Map<String, Object> generalMap) {

					boolean dataUpdated = false;


					Date currentDate = new Date();
					String currentTime = "";
					currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
							"currentTime");
					int scheduleId = 0;
					String scheduleName = "";
					
					int scheduleCode = 0;
					int orderNo = 0;
					String scheduleNo = "";

					try {
						scheduleId = (Integer) generalMap.get("id");
						scheduleCode = (Integer) generalMap.get("scheduleCode");
						scheduleName = (String) generalMap.get("name");
						orderNo = (Integer) generalMap.get("orderNo");
						scheduleNo = (String) generalMap.get("scheduleNo");
						currentDate = (Date) generalMap.get("currentDate");
						currentTime = (String) generalMap.get("currentTime");
						int userId=0; 
						userId = (Integer) generalMap.get("userId");
						int hospitalId=0; 
						hospitalId = (Integer) generalMap.get("hospitalId");
						MasAccountSchedule masAccountSchedule = (MasAccountSchedule) getHibernateTemplate().load(
								MasAccountSchedule.class, scheduleId);

						masAccountSchedule.setId(scheduleId);
						masAccountSchedule.setScheduleName(scheduleName);
						masAccountSchedule.setOrderNo(orderNo);
						masAccountSchedule.setScheduleNo(scheduleNo);
												
						Users users=new Users();
						users.setId(userId);
						masAccountSchedule.setLastChgBy(users);

						masAccountSchedule.setLastChgDate(currentDate);
						masAccountSchedule.setLastChgTime(currentTime);

						org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
						hbt.setFlushModeName("FLUSH_EAGER");
						hbt.setCheckWriteOperations(false);
						hbt.update(masAccountSchedule);
						dataUpdated = true;
					} catch (Exception e) {
						e.printStackTrace();
					}
					return dataUpdated;
				}

				//@Override
				public Map<String, Object> searchAccountSchedule(
						int scheduleCode, String scheduleName) {
					List masAccountScheduleList = new ArrayList();
					Map<String, Object> map = new HashMap<String, Object>();
					Session session = (Session) getSession();
					try {
						if ((scheduleName != null) || (scheduleCode == 0)) {
							
							masAccountScheduleList = session.createCriteria(MasAccountSchedule.class).add(Restrictions.like("ScheduleName","%"+scheduleName+"%").ignoreCase()).addOrder(Order.asc("ScheduleName")).list();
							
						} else if (scheduleCode != 0) {
											
							masAccountScheduleList = session.createCriteria(MasAccountSchedule.class).add(Restrictions.eq("ScheduleCode",scheduleCode)).addOrder(Order.asc("ScheduleCode")).list();
					}
					} catch (Exception e) {
						e.printStackTrace();
					}
			
				
					map.put("masAccountScheduleList", masAccountScheduleList);
					return map;
				}

				//@Override
				public boolean deleteAccountSchedule(int scheduleId,
						Map<String, Object> generalMap) {
					boolean dataDeleted = false;
					Date currentDate = new Date();
					String currentTime = "";
					currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
							"currentTime");
					MasAccountSchedule masAccountSchedule = new MasAccountSchedule();
					masAccountSchedule = (MasAccountSchedule) getHibernateTemplate().load(MasAccountSchedule.class,
							scheduleId);
					int userId=0; 
					userId = (Integer) generalMap.get("userId");
					currentDate = (Date) generalMap.get("currentDate");
					currentTime = (String) generalMap.get("currentTime");

					if (generalMap.get("flag") != null) {
						String flag = (String) generalMap.get("flag");
						if (flag.equals("InActivate")) {
							masAccountSchedule.setStatus("N");
							dataDeleted = true;
						} else if (flag.equals("Activate")) {
							masAccountSchedule.setStatus("Y");
							dataDeleted = false;
						}
					}
					
					Users users=new Users();
					users.setId(userId);
					masAccountSchedule.setLastChgBy(users);
					

					masAccountSchedule.setLastChgDate(currentDate);
					masAccountSchedule.setLastChgTime(currentTime);
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(masAccountSchedule);
					return dataDeleted;
				}

				//@Override
				public List<MasAccountSchedule> checkExistingAccountSchedule(Box box) {
					List<MasAccountSchedule> existingMasAccountScheduleList = new ArrayList<MasAccountSchedule>();
					Session session = (Session) getSession();
					
					existingMasAccountScheduleList = session.createCriteria(MasAccountSchedule.class).add(Restrictions.eq("ScheduleCode",box.getInt("codeS")))
							.add(Restrictions.eq("ScheduleName", box.getString("nameS"))).list();
				
					return existingMasAccountScheduleList;
				}

				//@Override
				public List<Object[]> getDataForExcelReportServicing(
						String queryForBillServicing) {
					logger.info(queryForBillServicing);
					Session session=(Session)getSession();
					List<Object[]> aList1=new ArrayList<Object[]>();
					aList1=session.createSQLQuery(queryForBillServicing).list();
					return aList1;
					
				}
				
				//@Override
				public List<Object[]> getDataForExcelReportCashRefund(
						String queryForCashRefund) {
					logger.info(queryForCashRefund);
					Session session=(Session)getSession();
					List<Object[]> aList1=new ArrayList<Object[]>();
					aList1=session.createSQLQuery(queryForCashRefund).list();
					return aList1;
					
				}
				
				//@Override
				public List<Object[]> getDataForExcelReportChargeSlip(
						String queryForChargeSlip) {
					
					logger.info(queryForChargeSlip);
					Session session=(Session)getSession();
					List<Object[]> aList1=new ArrayList<Object[]>();
					aList1=session.createSQLQuery(queryForChargeSlip).list();
					return aList1;
					
				}
				
				//@Override
				public List<Object[]> getDataForExcelReportDailyCash(
						String querydailyCashReport) {
					
					logger.info(querydailyCashReport);
					Session session=(Session)getSession();
					List<Object[]> aList=new ArrayList<Object[]>();
					aList=session.createSQLQuery(querydailyCashReport).list();
					return aList;
					
				}
				
				//@Override
				public List<Object[]> getDataForCashCollectionReport(
						String queryCashCollectionReport) {
					
					logger.info(queryCashCollectionReport);
					Session session=(Session)getSession();
					List<Object[]> aList=new ArrayList<Object[]>();
					aList=session.createSQLQuery(queryCashCollectionReport).list();
					return aList;
					
				}

				//@Override
				public Map<String, Object> populateEmployeeByCategory(
						int employeeCategoryId, Map<String, Object> detailsMap) {
					
					Map<String, Object> map = new HashMap<String, Object>();
					
				//	List<MasInstituteDepartment> instDeptList = new ArrayList<MasInstituteDepartment>();
					
					List<MasEmployee> employeeByCategoryList = new ArrayList<MasEmployee>();
					
					Session session = (Session) getSession();
					int hospitalId = (Integer)detailsMap.get("hospitalId");
					
					int seviceCenterrId = (Integer)detailsMap.get("seviceCenterrId");
					
					
					employeeByCategoryList = session.createCriteria(MasEmployee.class)
							.createAlias("EmpCategory", "EmpCategory")
							.createAlias("Department", "Department")
							.add(Restrictions.eq("EmpCategory.Id",employeeCategoryId))
							.add(Restrictions.eq("Department.Id",seviceCenterrId))
							.add(Restrictions.eq("Status","y").ignoreCase())
							.add(Restrictions.eq("Hospital.Id",hospitalId)).addOrder(Order.asc("EmployeeName"))
							.list();
					map.put("employeeByCategoryList", employeeByCategoryList);
					
					return map;
				}

				// ----------------------------------Lsg------------------------------------

				public boolean addLsg(MasLsg masLsg) {
					boolean saveFlag = false;
					try {
						org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
						hbt.setFlushModeName("FLUSH_EAGER");
						hbt.setCheckWriteOperations(false);
						hbt.save(masLsg);
						saveFlag = true;
					} catch (Exception e) {
						e.printStackTrace();
					}
					return saveFlag;
				}

				@SuppressWarnings("unchecked")
				public boolean deleteLsg(int lsgId, Map<String, Object> generalMap) {
					boolean dataDeleted = false;
					Date currentDate = new Date();
					String currentTime = "";
					currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
							"currentTime");
					MasLsg masLsg = new MasLsg();
					masLsg = (MasLsg) getHibernateTemplate().load(MasLsg.class,
							lsgId);
					int userId=0; 
					userId = (Integer) generalMap.get("userId");
					currentDate = (Date) generalMap.get("currentDate");
					currentTime = (String) generalMap.get("currentTime");

					if (generalMap.get("flag") != null) {
						String flag = (String) generalMap.get("flag");
					if (flag.equals("InActivate")) {
							masLsg.setStatus("N");
							dataDeleted = true;
						} else if (flag.equals("Activate")) {
							masLsg.setStatus("Y");
							dataDeleted = false;
						}
					}
					
					Users users=new Users();
					users.setId(userId);
					masLsg.setLastChgBy(users);
					

					masLsg.setLastChgDate(currentDate);
					masLsg.setLastChgTime(currentTime);
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(masLsg);
					return dataDeleted;
				}

				public boolean editLsg(Map<String, Object> generalMap) {

					boolean dataUpdated = false;

					// MasLsg masLsg=new MasLsg();
					Date currentDate = new Date();
					String currentTime = "";
					currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
							"currentTime");
					int lsgId = 0;
					String lsgTypeName = "";
					@SuppressWarnings("unused")
					String lsgTypeCode = "";
					int lsgTypeId = 0;
					String changedBy = "";

					try {
						lsgId = (Integer) generalMap.get("id");
						lsgTypeCode = (String) generalMap.get("lsgTypeCode");
						lsgTypeName = (String) generalMap.get("name");
						lsgTypeId = (Integer) generalMap.get("lsgTypeId");
						changedBy = (String) generalMap.get("changedBy");
						currentDate = (Date) generalMap.get("currentDate");
						currentTime = (String) generalMap.get("currentTime");
						int userId=0; 
						userId = (Integer) generalMap.get("userId");
						int districtId=0;
						districtId = (Integer) generalMap.get("districtId");
						MasLsg masLsg = (MasLsg) getHibernateTemplate().load(
								MasLsg.class, lsgId);

						masLsg.setId(lsgId);
						masLsg.setLsgTypeName(lsgTypeName);

						  MasLsgType lsgType = new MasLsgType();
						  lsgType.setId(lsgTypeId);
						  masLsg.setLsgType(lsgType);
						 
						  

						
						Users users=new Users();
						users.setId(userId);
						masLsg.setLastChgBy(users);
						

						
						
						MasDistrict district = new MasDistrict();
						district.setId(districtId);
						masLsg.setDistrict(district);
						

						
						masLsg.setLastChgDate(currentDate);
						masLsg.setLastChgTime(currentTime);

						org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
						hbt.setFlushModeName("FLUSH_EAGER");
						hbt.setCheckWriteOperations(false);
						hbt.update(masLsg);
						dataUpdated = true;
					} catch (Exception e) {
						e.printStackTrace();
					}
					return dataUpdated;
				}

				@SuppressWarnings("unchecked")
				public Map<String, Object> searchLsg(String lsgTypeCode,
						String lsgTypeName) {
					List masLsgList = new ArrayList();
					List masLsgTypeList = new ArrayList();
					List masHospitalList = new ArrayList();
					List<MasDistrict> masDistrictList = new ArrayList<MasDistrict>();
					Map<String, Object> map = new HashMap<String, Object>();
					try {
						if ((lsgTypeName != null) || (lsgTypeCode == null)) {
							masLsgList = getHibernateTemplate().find(
									"from jkt.hms.masters.business.MasLsg sc where sc.LsgTypeName like '"
											+ lsgTypeName + "%' order by sc.LsgTypeName");
						} else if (lsgTypeCode != null) {
							masLsgList = getHibernateTemplate().find(
									"from jkt.hms.masters.business.MasLsg sc where sc.LsgTypeCode like '"
											+ lsgTypeCode + "%' order by sc.LsgTypeCode");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					masLsgTypeList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasLsgType as mit where mit.Status = 'Y'");
					masHospitalList= getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasHospital as b where b.Status = 'Y'");
					masDistrictList= getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasDistrict as b where b.Status = 'Y'");
					map.put("masLsgList", masLsgList);
					map.put("masLsgTypeList", masLsgTypeList);
					map.put("masDistrictList", masDistrictList);
					map.put("masHospitalList", masHospitalList);
					return map;
				}

				@SuppressWarnings("unchecked")
				public Map<String, Object> showLsg() {
					Map<String, Object> map = new HashMap<String, Object>();
					List<MasLsg> masLsgList = new ArrayList<MasLsg>();
					List<MasLsgType> masLsgTypeList = new ArrayList<MasLsgType>();
					List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
					List<MasDistrict> masDistrictList = new ArrayList<MasDistrict>();
					masLsgList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.MasLsg as sc order by sc.LsgTypeName");
					masLsgTypeList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasLsgType");
					masDistrictList= getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasDistrict as b where b.Status = 'Y'");
					masHospitalList= getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasHospital as b where b.Status = 'Y'");
					
					map.put("masLsgList", masLsgList);
					map.put("masLsgTypeList", masLsgTypeList);
					map.put("masDistrictList", masDistrictList);
					map.put("masHospitalList", masHospitalList);
					
					return map;
				}

				@Override
				public Map<String, Object> showMaster() {
					Map<String, Object> map = new HashMap<String, Object>();
					List<PhMaster> phMasterList = new ArrayList<PhMaster>();
					phMasterList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.PhMaster as sc order by sc.MasterName");
					
					map.put("phMasterList", phMasterList);
					
					return map;
				}

				@Override
				public boolean editMaster(Map<String, Object> generalMap) {

					boolean dataUpdated = false;
					Date currentDate = new Date();
					String currentTime = "";
					currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
					int masterId = 0;
					String masterName = "";
					String masterCode = "";
					String changedBy = "";

					try {
						masterId = (Integer) generalMap.get("id");
						masterCode = (String) generalMap.get("masterCode");
						masterName = (String) generalMap.get("name");
						changedBy = (String) generalMap.get("changedBy");
						currentDate = (Date) generalMap.get("currentDate");
						currentTime = (String) generalMap.get("currentTime");
						int userId=0; 
						userId = (Integer) generalMap.get("userId");
						PhMaster phMaster = (PhMaster) getHibernateTemplate().load(
								PhMaster.class, masterId);

						phMaster.setId(masterId);
						phMaster.setMasterName(masterName);
						Users users=new Users();
						users.setId(userId);
						phMaster.setLastChgBy(users);
						
						phMaster.setLastChgDate(currentDate);
						phMaster.setLastChgTime(currentTime);

						org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
						hbt.setFlushModeName("FLUSH_EAGER");
						hbt.setCheckWriteOperations(false);
						hbt.update(phMaster);
						dataUpdated = true;
					} catch (Exception e) {
						e.printStackTrace();
					}
					return dataUpdated;
				}

				@Override
				public boolean addMaster(PhMaster phMaster) {
					boolean saveFlag = false;
					try {
						org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
						hbt.setFlushModeName("FLUSH_EAGER");
						hbt.setCheckWriteOperations(false);
						hbt.save(phMaster);
						saveFlag = true;
					} catch (Exception e) {
						e.printStackTrace();
					}
					return saveFlag;
				}

				@Override
				public Map<String, Object> searchMaster(String masterCode,
						String masterName) {
					List phMasterList = new ArrayList();
					
					Map<String, Object> map = new HashMap<String, Object>();
					try {
						if ((masterName != null) || (masterCode == null)) {
							phMasterList = getHibernateTemplate().find(
									"from jkt.hms.masters.business.PhMaster sc where sc.MasterName like '"
											+ masterName + "%' order by sc.MasterName");
						} else if (masterCode != null) {
							phMasterList = getHibernateTemplate().find(
									"from jkt.hms.masters.business.PhMaster sc where sc.MasterCode like '"
											+ masterCode + "%' order by sc.MasterCode");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					map.put("phMasterList", phMasterList);
				
					return map;
				}

				@Override
				public boolean deleteMaster(int masterId,
						Map<String, Object> generalMap) {
					boolean dataDeleted = false;
					Date currentDate = new Date();
					String currentTime = "";
					currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
							"currentTime");
					PhMaster phMaster = new PhMaster();
					phMaster = (PhMaster) getHibernateTemplate().load(PhMaster.class,
							masterId);
					int userId=0; 
					userId = (Integer) generalMap.get("userId");
					currentDate = (Date) generalMap.get("currentDate");
					currentTime = (String) generalMap.get("currentTime");

					if (generalMap.get("flag") != null) {
						String flag = (String) generalMap.get("flag");
							if (flag.equals("InActivate")) {
								phMaster.setStatus("N");
							dataDeleted = true;
						} else if (flag.equals("Activate")) {
							phMaster.setStatus("Y");
							dataDeleted = false;
						}
					}
					
					Users users=new Users();
					users.setId(userId);
					phMaster.setLastChgBy(users);
					

					phMaster.setLastChgDate(currentDate);
					phMaster.setLastChgTime(currentTime);
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(phMaster);
					return dataDeleted;
				}

				@Override
				public Map<String, Object> showPhMasterDataJsp() {
					Map<String, Object> map = new HashMap<String, Object>();
					List<PhMasterData> phMasterDataList = new ArrayList<PhMasterData>();
					List<PhMaster> phMasterList = new ArrayList<PhMaster>();
					phMasterDataList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.PhMasterData as sc order by sc.DataName");
					phMasterList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.PhMaster");
					
					map.put("phMasterDataList", phMasterDataList);
					map.put("phMasterList", phMasterList);
					
					return map;
				}

				@Override
				public boolean deletePhMasterData(int dataId,
						Map<String, Object> generalMap) {
					boolean dataDeleted = false;
					Date currentDate = new Date();
					String currentTime = "";
					currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
							"currentTime");
					PhMasterData phMasterData = new PhMasterData();
					phMasterData = (PhMasterData) getHibernateTemplate().load(PhMasterData.class,
							dataId);
					int userId=0; 
					userId = (Integer) generalMap.get("userId");
					currentDate = (Date) generalMap.get("currentDate");
					currentTime = (String) generalMap.get("currentTime");

					if (generalMap.get("flag") != null) {
						String flag = (String) generalMap.get("flag");
							if (flag.equals("InActivate")) {
								phMasterData.setStatus("N");
							dataDeleted = true;
						} else if (flag.equals("Activate")) {
							phMasterData.setStatus("Y");
							dataDeleted = false;
						}
					}
					
					Users users=new Users();
					users.setId(userId);
					phMasterData.setLastChgBy(users);
					

					phMasterData.setLastChgDate(currentDate);
					phMasterData.setLastChgTime(currentTime);
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(phMasterData);
					return dataDeleted;
				}

				@Override
				public boolean editPhMasterData(Map<String, Object> generalMap) {

					boolean dataUpdated = false;
					Date currentDate = new Date();
					String currentTime = "";
					currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
					int masterId = 0;
					int dataId=0;
					String dataName = "";
					Session session = (Session) getSession();
					String changedBy = "";

					try {
						dataId = (Integer) generalMap.get("id");
						masterId = (Integer) generalMap.get("masterId");
						dataName = (String) generalMap.get("name");
						changedBy = (String) generalMap.get("changedBy");
						currentDate = (Date) generalMap.get("currentDate");
						currentTime = (String) generalMap.get("currentTime");
						int userId=0; 
						userId = (Integer) generalMap.get("userId");
						PhMasterData phMasterData = (PhMasterData) getHibernateTemplate().load(
								PhMasterData.class, dataId);

						phMasterData.setId(dataId);
						phMasterData.setDataName(dataName);
						
						
						if(masterId!=0){
							
							PhMaster phMaster = new PhMaster();
							phMaster.setId(masterId);
							phMasterData.setMaster(phMaster);
							
							List<PhMaster> phMasterList = new ArrayList<PhMaster>();
							phMasterList = session.createCriteria(PhMaster.class).add(Restrictions.eq("Id",masterId)).list();
				 			if(phMasterList.size()>0){
				            PhMaster phMasterObj = (PhMaster) phMasterList.get(0);
				 			String masterCode = phMasterObj.getMasterCode();
				 			phMasterData.setDataCode(masterCode);
				 			}
							
						}
						
						Users users=new Users();
						users.setId(userId);
						phMasterData.setLastChgBy(users);
						
						phMasterData.setLastChgDate(currentDate);
						phMasterData.setLastChgTime(currentTime);
						phMasterData.setMasterType("RT");
						org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
						hbt.setFlushModeName("FLUSH_EAGER");
						hbt.setCheckWriteOperations(false);
						hbt.update(phMasterData);
						dataUpdated = true;
					} catch (Exception e) {
						e.printStackTrace();
					}
					return dataUpdated;
				}

				@Override
				public Map<String, Object> searchPhMasterData(
						String phMasterDataName) {
					List phMasterDataList = new ArrayList();
					List<PhMaster> phMasterList = new ArrayList<PhMaster>();
					Map<String, Object> map = new HashMap<String, Object>();
					try {
						if (phMasterDataName != null) {
							phMasterDataList = getHibernateTemplate().find(
									"from jkt.hms.masters.business.PhMasterData sc where sc.DataName like '"
											+ phMasterDataName + "%' order by sc.DataName");
						} 
					} catch (Exception e) {
						e.printStackTrace();
					}
					phMasterList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.PhMaster");
					map.put("phMasterDataList", phMasterDataList);
					map.put("phMasterList", phMasterList);
				
					return map;
				}

				@Override
				public boolean addPhMasterData(PhMasterData phMasterData,
						int masterId) {
					boolean saveFlag = false;
					try {
						Session session = (Session) getSession();
					
						org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
						List<PhMaster> phMasterList = new ArrayList<PhMaster>();
						phMasterList = session.createCriteria(PhMaster.class).add(Restrictions.eq("Id",masterId)).list();
			 			if(phMasterList.size()>0){
			            PhMaster phMaster = (PhMaster) phMasterList.get(0);
			 			String masterCode = phMaster.getMasterCode();
			 			phMasterData.setDataCode(masterCode);
			 			}
						hbt.setFlushModeName("FLUSH_EAGER");
						hbt.setCheckWriteOperations(false);
						hbt.save(phMasterData);
						saveFlag = true;
					} catch (Exception e) {
						e.printStackTrace();
					}
					return saveFlag;
				}

				@Override
				public Map<String, Object> existRecord(	Map<String, Object> generalMap) {
					int masterId=0; 
					String dataName="";
					List existRecordList = new ArrayList();
					
					Map<String, Object> listMap = new HashMap<String, Object>();
					masterId = (Integer) generalMap.get("masterId");
					dataName = (String) generalMap.get("name");
					try {
						Session session = (Session) getSession();
						if(masterId!=0 && !dataName.equalsIgnoreCase("")){
							existRecordList = session.createCriteria(PhMasterData.class).createAlias("Master", "m").add(Restrictions.eq("m.Id",masterId)).add(Restrictions.like("DataName","%"+dataName+"%").ignoreCase()).list();
						
						}
			 			
						listMap.put("existRecordList", existRecordList);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return listMap;
				}

				//govind code 11-7-2016
				@Override
				public Map<String, Object> populateLsgByDistrictId(int districtId) { 
					logger.info("district Id "+districtId);
					List<MasLsg> lsgList=new ArrayList<MasLsg>();
					Map<String,Object> map=new HashMap<String,Object>();
					Session session=(Session)getSession();
					Criteria crt=null;
					crt=session.createCriteria(MasLsg.class).createAlias("District", "district")
							.add(Restrictions.eq("district.Id", districtId));
					
					lsgList=crt.list();
					logger.info("district list size "+lsgList.size());
					map.put("lsgList", lsgList);
					// TODO Auto-generated method stub
					return map;
				}				
			//govind end
				
				//govind code 12-7-2016
				@Override
				public Map<String, Object> populateWardByLsgId(int lsgId) { 
					logger.info("lsg Id "+lsgId);
					List<MasWard> wardList=new ArrayList<MasWard>();
					Map<String,Object> map=new HashMap<String,Object>();
					Session session=(Session)getSession();
					Criteria crt=null;
					crt=session.createCriteria(MasWard.class).createAlias("Lsg", "lsg")
							.add(Restrictions.eq("lsg.Id", lsgId));
					
					wardList=crt.list();
					logger.info("ward list size "+wardList.size());
					map.put("wardList", wardList);
					// TODO Auto-generated method stub
					return map;
				}				
			//govind end

				
				//--------------------------------------- Heading Master 
				@Override
				public Map<String, Object> showHeadingJsp() {

					Map<String, Object> map = new HashMap<String, Object>();
					List<MasSpecialityHeading> masHeadingList = new ArrayList<MasSpecialityHeading>();

					List<MasSpecialityHeading> gridHeadingList = new ArrayList<MasSpecialityHeading>();
					masHeadingList = getHibernateTemplate().find("from jkt.hms.masters.business.MasSpecialityHeading ");

					gridHeadingList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasSpecialityHeading as mit where mit.Status = 'y' or mit.Status = 'Y'");
					map.put("masHeadingList", masHeadingList);

					map.put("gridHeadingList", gridHeadingList);
					logger.info("gridHeadingList" + gridHeadingList.size());
					return map;
				
				}

				@Override
				public boolean deleteHeading(int headingId,
						Map<String, Object> generalMap) {
					boolean dataDeleted = false;
					int userId=(Integer)generalMap.get("userId");

					Date currentDate = new Date();
					String currentTime = "";
					currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
							"currentTime");
					MasSpecialityHeading masHeading = new MasSpecialityHeading();
					masHeading = (MasSpecialityHeading) getHibernateTemplate().get(
							MasSpecialityHeading.class, headingId);

					currentDate = (Date) generalMap.get("currentDate");
					currentTime = (String) generalMap.get("currentTime");

					if (generalMap.get("flag") != null) {
						String flag = (String) generalMap.get("flag");
						if (flag.equals("InActivate")) {
							masHeading.setStatus("N");
							dataDeleted = true;
						} else if (flag.equals("Activate")) {
							masHeading.setStatus("Y");
							dataDeleted = false;
						}
					}
					Users user = new Users();
					user.setId(userId);
					masHeading.setLastChgBy(user);
					masHeading.setLastChgDate(currentDate);
					masHeading.setLastChgTime(currentTime);
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(masHeading);
					return dataDeleted;
				}

				@Override
				public boolean editHeadingToDatabase(
						Map<String, Object> generalMap) {
					boolean dataUpdated = false;
					Date currentDate = new Date();
					String currentTime = "";
					currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
							"currentTime");
					String headingTwo = "";
					String headingOne = "";
					String commonHeading = "";
					
					int headingId = 0;
					int userId=0;
					String changedBy = "";
										
					headingId = (Integer) generalMap.get("id");
					headingOne = (String) generalMap.get("headingOne");
					headingTwo = (String) generalMap.get("name");
					changedBy = (String) generalMap.get("changedBy");
					currentDate = (Date) generalMap.get("currentDate");
					userId=(Integer) generalMap.get("userId");
					currentTime = (String) generalMap.get("currentTime");
					if(generalMap.get("commonHeading") != null){
						commonHeading = (String)generalMap.get("commonHeading");
					}
					MasSpecialityHeading masHeading = (MasSpecialityHeading) getHibernateTemplate()
							.get(MasSpecialityHeading.class, headingId);

					Users user = new Users();
					user.setId(userId);
					masHeading.setSpHeadingOne(headingOne);
					masHeading.setSpHeadingTwo(headingTwo);
					masHeading.setLastChgBy(user);
					masHeading.setLastChgDate(currentDate);
					masHeading.setLastChgTime(currentTime);
					masHeading.setSpCommonHeading(commonHeading);
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(masHeading);
					dataUpdated = true;
					return dataUpdated;
				}

				@Override
				public Map<String, Object> searchHeading(String headingOne,	String headingTwo) {
					List<MasSpecialityHeading> masHeadingList = new ArrayList<MasSpecialityHeading>();
					Map groupMap = new HashMap();
					try {
						if ((headingTwo != null) || (headingOne == null)) {
							masHeadingList = getHibernateTemplate()
									.find("from jkt.hms.masters.business.MasSpecialityHeading msg where msg.SpHeadingTwo like '"
											+ headingTwo + "%' order by msg.SpHeadingTwo");

						} else {
							masHeadingList = getHibernateTemplate()
									.find("from jkt.hms.masters.business.MasSpecialityHeading msg where msg.SpHeadingOne like '"
											+ headingOne + "%' order by msg.SpHeadingOne");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					groupMap.put("masHeadingList", masHeadingList);

					return groupMap;
				}

				@Override
				public boolean addHeading(MasSpecialityHeading masHeading) {
					boolean saveFlag = false;
					try {
						org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
						hbt.setFlushModeName("FLUSH_EAGER");
						hbt.setCheckWriteOperations(false);
						hbt.save(masHeading);
						saveFlag = true;
					} catch (Exception e) {
						e.printStackTrace();
					}
					return saveFlag;
				}

				@Override
				public Map<String, Object> getHospitalListForAutoCompleteItem(
						Map<String, Object> map1) {
					List<MasHospital> instituteList = new ArrayList<MasHospital>();
					Map<String, Object> map = new HashMap<String, Object>();
					Session session=(Session)getSession();
					Criteria cr=null;
					String instName=null;
					int districtId=0,instType=0;
					String variableName="N";
					if (map1.get("instName") != null) {
						instName=(String)map1.get("instName");
						instName=instName.toUpperCase();
					}
					if (map1.get("districtId") != null) {
						
						districtId =(Integer)(map1.get("districtId"));
					}
					if (map1.get("instType") != null) {
						instType =(Integer)(map1.get("instType"));
					}
					if (map1.get("variableName") != null) {
						variableName =(String) map1.get("variableName");
					
					}
					logger.info("instName impl "+instName);
					
					cr=session.createCriteria(MasHospital.class);
					if(variableName.equalsIgnoreCase("Y")){
						cr.add(Restrictions.eq("ShortName",instName));
				     }else{
				    	 cr.add(Restrictions.like("ShortName","%"+instName+"%"));
				     }
					if(districtId>0){
							cr.add(Restrictions.eq("District.Id", districtId));
					}
					if(instType>0){
							cr.add(Restrictions.eq("HospitalType.Id",instType));
					}
			        cr.setFirstResult(0);
					cr.setMaxResults(10);
			
					instituteList=	cr.list();
					logger.info("instituteList "+instituteList.size());
					map.put("instituteList",instituteList);
					return map;
				}

				@Override
				public Map<String, Object> viewSpecialityTemplate(Box box) {
					Session session = (Session)getSession();
					int hospitalId=0;
					int deptId=0;
					int template = 0;
					if(box.getInt("hospitalId")!=0){
						hospitalId=(Integer)box.getInt("hospitalId");
					}
					if( box.getInt("deptId")!=0){
						deptId=(Integer) box.getInt("deptId");
					}
					if( box.getInt("template")!=0){
						template=(Integer) box.getInt("template");
					}
					
					List<MasSpecialityDeptGroup> masForGorupParameter=new ArrayList<MasSpecialityDeptGroup>();
					List<MasSpecialityDeptGroupValue> masValue=new ArrayList<MasSpecialityDeptGroupValue>();
					List<MasSpecialtyGroupParameter> groupParameterList=new ArrayList<MasSpecialtyGroupParameter>();
					List<MasMaritalStatus>maritalStatusList = new ArrayList<MasMaritalStatus>();
					List<MasQualification>educationList = new ArrayList<MasQualification>();
					List<MasReligion>religionList = new ArrayList<MasReligion>();
					List<MasOccupation>occupationList = new ArrayList<MasOccupation>();
					int idForValue=0;
					logger.info("templatetemplate "+template);
			    	 if(template!=0){
						Criteria crForGroupParameter=getSession().createCriteria(MasSpecialityDeptGroup.class,"mas")
							                      .createAlias("mas.Department", "dep")
							                       .add(Restrictions.eq("dep.Id",deptId))
							                      .createAlias("mas.Template", "tem")
							                     .add(Restrictions.eq("tem.Id",template))	
							                     .addOrder(Order.asc("GroupSeqNo")).addOrder(Order.asc("ParameterSeqNo")).add(Restrictions.eq("Status", "y").ignoreCase());
					masForGorupParameter=crForGroupParameter.list();
					
					List<Integer> groupIds=new ArrayList<Integer>();
					for (MasSpecialityDeptGroup masSpecialityDeptGroup : masForGorupParameter) {
						groupIds.add(masSpecialityDeptGroup.getSpGroup().getSpGroup().getId());
						//idForValue=masSpecialityDeptGroup.getId();
					}
					
					if(groupIds.size()>0){
					groupParameterList=getSession().createCriteria(MasSpecialtyGroupParameter.class,"mas").createAlias("mas.SpGroup", "sgroup")
			                      .add(Restrictions.in("sgroup.Id", groupIds)).add(Restrictions.eq("Status", "y").ignoreCase()).list();
					}
					
					if(masForGorupParameter.size()>0){
						Criteria crForParaValues=getSession().createCriteria(MasSpecialityDeptGroupValue.class,"masVal")
				                   .createAlias("masVal.DeptGroup", "deptGroup")
				                   .add(Restrictions.eq("deptGroup.ValueType", "LOV").ignoreCase())
				                   .add(Restrictions.in("masVal.DeptGroup",masForGorupParameter));
						 masValue=crForParaValues.list();
					}
			      }	
			    	 maritalStatusList = session.createCriteria(MasMaritalStatus.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			    	 educationList = session.createCriteria(MasQualification.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			    	 religionList = session.createCriteria(MasReligion.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			    	 occupationList = session.createCriteria(MasOccupation.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
					map.put("masForGorupParameter",masForGorupParameter);
					map.put("groupParameterList",groupParameterList);
					map.put("masValue",masValue);
					map.put("maritalStatusList",maritalStatusList);
					map.put("educationList",educationList);
					map.put("religionList",religionList);
					map.put("occupationList",occupationList);
					return map;
				}

				@Override
				public Map<String, Object> showUserSpecilaityTemplateJsp(Box box) {
					Map<String, Object> map = new HashMap<String, Object>();
					List<MasSpecialtyTemplate> specialityTemplateList = new ArrayList<MasSpecialtyTemplate>();
					List<UserSpecialityTemplate> userSpecialityTemplateList = new ArrayList<UserSpecialityTemplate>();
					List<Users> userList = new ArrayList<Users>();
					Session session = (Session)getSession();
					specialityTemplateList = session.createCriteria(MasSpecialtyTemplate.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
					userList = session.createCriteria(Users.class).createAlias("Employee", "emp").createAlias("emp.EmpCategory","category")
							.add(Restrictions.eq("category.Id", 4)).add(Restrictions.eq("Status", "y").ignoreCase())
								//.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
								.add(Restrictions.or(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")), Restrictions.isNull("Hospital.Id"))).list();
					userSpecialityTemplateList = session.createCriteria(UserSpecialityTemplate.class).add(Restrictions.eq("Status","y").ignoreCase())
							.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).list();
					map.put("specialityTemplateList", specialityTemplateList);
					map.put("userList", userList);
					map.put("userSpecialityTemplateList", userSpecialityTemplateList);
					return map;
				}

				@Override
				public Map<String, Object> saveUserSpecialityTemplate(Map<String, Object> dataMap) {
					Map<String, Object> map = new HashMap<String, Object>();
					List<UserSpecialityTemplate> userSpecialityTemplateList = new ArrayList<UserSpecialityTemplate>();
					List<MasSpecialtyTemplate> specialityTemplateList = new ArrayList<MasSpecialtyTemplate>();
					List<Users> userList = new ArrayList<Users>();
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					boolean successfullyAdded = false;
					List<Object> usrGrpHospList = new ArrayList<Object>();
					List<Object> grpAppList = new ArrayList<Object>();
					usrGrpHospList = (List<Object>) dataMap.get("usrGrpHospList");
					grpAppList = (List<Object>) dataMap.get("grpAppList");
					int templateId = (Integer) dataMap.get("templateId");
					int hospitalId = (Integer) dataMap.get("hospitalId");
					int userId=0;
					int sessionUserId = 0;
					if(dataMap.get("sessionUserId")!=null){
						sessionUserId = (Integer) dataMap.get("sessionUserId");
					}
					if(dataMap.get("userId")!=null){
						userId = (Integer) dataMap.get("userId");
					}
					Session session = (Session)getSession();
					Date currentDate = new Date();
					String currentTime = "";
					currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
					
					if (userId > 0) {
						
							try {
								if(templateId>0){
								
									//if(userTemplateList.size() == 0){
									UserSpecialityTemplate userTemplate = new UserSpecialityTemplate();
									
									Users user = new Users();
									user.setId(userId);
									userTemplate.setUser(user);
									
									if(templateId>0){
										MasSpecialtyTemplate masTemplate = new MasSpecialtyTemplate();
										masTemplate.setId(templateId);
										userTemplate.setTemplate(masTemplate);
									}
									
									MasHospital masHospital = new MasHospital();
									masHospital.setId(hospitalId);
									userTemplate.setHospital(masHospital);
									
									
									userTemplate.setStatus("y");
									
									Users users = new Users();
									users.setId(sessionUserId);
									userTemplate.setLastChgBy(users);
									
									userTemplate.setLastChgDate(currentDate);
									userTemplate.setLastChgTime(currentTime);
									hbt.save(userTemplate);
									}
									successfullyAdded = true;
							//	}
							} catch (NumberFormatException e) {
								successfullyAdded = false;
								e.printStackTrace();
							} catch (DataAccessException e) {
								successfullyAdded = false;
								e.printStackTrace();
							}
						
					}
					specialityTemplateList = session.createCriteria(MasSpecialtyTemplate.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
					userSpecialityTemplateList = session.createCriteria(UserSpecialityTemplate.class).add(Restrictions.eq("Status","y").ignoreCase())
							.add(Restrictions.eq("Hospital.Id",hospitalId)).list();
					userList = session.createCriteria(Users.class).createAlias("Employee", "emp").createAlias("emp.EmpCategory","category")
													.add(Restrictions.eq("category.Id", 4)).add(Restrictions.eq("Status", "y").ignoreCase())
													.add(Restrictions.or(Restrictions.eq("Hospital.Id", hospitalId), Restrictions.isNull("Hospital.Id"))).list();
					map.put("specialityTemplateList", specialityTemplateList);
					map.put("userList", userList);
					map.put("userSpecialityTemplateList", userSpecialityTemplateList);
					map.put("successfullyAdded", successfullyAdded);
					return map;
				}

				@Override
				public Map<String, Object> removeSpecialityTemplateApplicationList(Map<String, Object> removeTemplateMap) {
					Map<String, Object> map = new HashMap<String, Object>();
					List<Integer> preTempletIdList=new ArrayList<Integer>();
					List<Integer> preUserIdList=new ArrayList<Integer>();
					Session session = (Session) getSession();	
					List<UserSpecialityTemplate> userSpecialityTemplateList = new ArrayList<UserSpecialityTemplate>();
					List<MasSpecialtyTemplate> specialityTemplateList = new ArrayList<MasSpecialtyTemplate>();
					List<Users> userList = new ArrayList<Users>();
					int hospitalId=0;
					if (removeTemplateMap.get("hospitalId") != null) {
						hospitalId = (Integer) removeTemplateMap.get("hospitalId");
					}
					
					if (removeTemplateMap.get("preTempletIdList") != null) {
						preTempletIdList = (List) removeTemplateMap.get("preTempletIdList");
					}
					if (removeTemplateMap.get("preUserIdList") != null) {
						preUserIdList = (List) removeTemplateMap.get("preUserIdList");
					}
					try {
					if(preTempletIdList.size()>0){
							int index=0;
							//int userId=0;
							for(Integer userId:preUserIdList){
								int templateId = preTempletIdList.get(index);
								String hqlUserTemplate = "delete from UserSpecialityTemplate as ut where ut.User.Id = "+ userId+ " and ut.Template.Id="+templateId+" and ut.Hospital.Id="+hospitalId;
							Query queryUserTemplate = session.createQuery(hqlUserTemplate);
							@SuppressWarnings("unused")
							int rowUserTemplate = queryUserTemplate.executeUpdate();
							++index;
							}
						}
						} catch (DataAccessException e) {
							e.printStackTrace();
						} catch (HibernateException e) {
							e.printStackTrace();
						}
						//session.flush();
					specialityTemplateList = session.createCriteria(MasSpecialtyTemplate.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
					userSpecialityTemplateList = session.createCriteria(UserSpecialityTemplate.class).add(Restrictions.eq("Status","y").ignoreCase())
							.add(Restrictions.eq("Hospital.Id",hospitalId)).list();
					userList = session.createCriteria(Users.class).createAlias("Employee", "emp").createAlias("emp.EmpCategory","category")
													.add(Restrictions.eq("category.Id", 4)).add(Restrictions.eq("Status", "y").ignoreCase())
													.add(Restrictions.or(Restrictions.eq("Hospital.Id", hospitalId), Restrictions.isNull("Hospital.Id"))).list();
					map.put("specialityTemplateList", specialityTemplateList);
					map.put("userList", userList);
					map.put("userSpecialityTemplateList", userSpecialityTemplateList);
					return map;
				}

				@Override
				public Map<String, Object> displayGroupSequence(Box box) {
					Map<String, Object> map = new HashMap<String, Object>();
					List<Integer> maxGroupIdList=new ArrayList<Integer>();
					List<MasSpecialityDeptGroup> groupSeqList=new ArrayList<MasSpecialityDeptGroup>();
					Session session = (Session) getSession();
					
					maxGroupIdList = session.createCriteria(MasSpecialityDeptGroup.class).createAlias("SpGroup", "grpPram")
											.createAlias("grpPram.SpGroup", "grp").add(Restrictions.eq("grp.Id", box.getInt("groupId")))
												.add(Restrictions.eq("Template.Id", box.getInt("templateId")))
												.setProjection(Projections.max("Id")).list();
					
					if(maxGroupIdList.size()>0){
						int masDeptGrpId = 0;
						if(maxGroupIdList.get(0) != null){
						 masDeptGrpId = maxGroupIdList.get(0);
						groupSeqList = session.createCriteria(MasSpecialityDeptGroup.class).add(Restrictions.idEq(masDeptGrpId)).list();
						}
						
					}
					
					map.put("groupSeqList", groupSeqList);
					
					return map;
				}

				@Override
				public Map<String, Object> showDeparmentGroupValue(Box box) {
					Map<String, Object> map = new HashMap<String, Object>();
					List<MasSpecialityDeptGroupValue> valueList = new ArrayList<MasSpecialityDeptGroupValue>();
					Session session = (Session) getSession();
					logger.info("deptGroupId==========="+box.getInt("deptGroupId"));
					valueList = session.createCriteria(MasSpecialityDeptGroupValue.class).createAlias("DeptGroup", "deptGrp")
								.add(Restrictions.eq("deptGrp.Id", box.getInt("deptGroupId")))//.add(Restrictions.eq("deptGrp.ValueType", "LOV"))
												.list();
					map.put("valueList", valueList);
					return map;
				}

				@Override
				public Map<String, Object> importLocality(Map<String, Object> utilMap) {
					Session session = (Session) getSession();
					Map<String, Object> map = new HashMap<String, Object>();

					List<String> localityNameList = new ArrayList<String>();
					List<Integer> wardIdList = new ArrayList<Integer>();
					List<Integer> lsgIdList = new ArrayList<Integer>();
				
					localityNameList = (List) utilMap.get("localityNameList");
					wardIdList = (List) utilMap.get("wardIdList");
					lsgIdList = (List) utilMap.get("lsgIdList");
					
					int deptId = (Integer) utilMap.get("deptId");
					int hospitalId = (Integer) utilMap.get("hospitalId");
					int userId = (Integer) utilMap.get("userId");
					List<PhMasLocality> phMasLocalityList = new ArrayList<PhMasLocality>();
					
					String userName = (String) utilMap.get("utilMap");
					
					Map dateMap = (Map) HMSUtil.getCurrentDateAndTime();
					String date = (String) dateMap.get("currentDate");
					String time = (String) dateMap.get("currentTime");
					org.springframework.orm.hibernate3.HibernateTemplate hbt1 = getHibernateTemplate();
					hbt1.setFlushModeName("FLUSH_EAGER");
					hbt1.setCheckWriteOperations(false);
					Transaction tx = null;
					String msg = "";
					boolean succesfullyAdded = false;
					Set<String> itemsNotAvailable = new HashSet<String>();
					//String itemsNotAvailable="";
					try {
						tx = session.beginTransaction();

						String localityName = "";
						int wardId=0;
						int lsgId=0;
						int i = 0;
						
						logger.info(localityNameList.size());
						if (localityNameList.size() > 0) {
								

							for (i = 0; i < localityNameList.size(); i++) {
								int localityId = 0;
								
								localityName = localityNameList.get(i);
								wardId = wardIdList.get(i);
								lsgId = lsgIdList.get(i);
								if(!localityName.equals("")){
									List<Integer> localityIdList = session.createCriteria(PhMasLocality.class).add(Restrictions.eq("LocalityName", localityName))
											.add(Restrictions.eq("Ward.Id", wardId))
											.add(Restrictions.eq("Lsg.Id", lsgId))
											.add(Restrictions.eq("Status", "y").ignoreCase()).setProjection(Projections.property("Id")).list();
									if(localityIdList.size()==0){

										
									PhMasLocality phMasLocality = new PhMasLocality();
									phMasLocality.setId(localityId);
									
									if (!localityNameList.get(i).toString().equals("")) {
										
										
										phMasLocality.setLocalityName(localityNameList.get(i).toString());
										
										if (wardId!=0) {
											MasWard ward=new MasWard();
											ward.setId(wardId);
											phMasLocality.setWard(ward);
										}
										if (lsgId!=0) {
											MasLsg lsg=new MasLsg();
											lsg.setId(lsgId);
											phMasLocality.setLsg(lsg);
										}
											
																		
										Users user = new Users();
										user.setId(userId);
										phMasLocality.setLastChgBy(user);
										phMasLocality.setLastChgDate(new Date());
										phMasLocality.setLastChgTime(time);
										phMasLocality.setStatus("Y");
										hbt1.save(phMasLocality);
									}
									succesfullyAdded = true;
									logger.info("Record saved successfully");
									msg = "Record Added Sucessfully..";
								}
									
							}
						
						}
						
						}
						else{
							itemsNotAvailable.add(localityName);
							//itemsNotAvailable += itemCode+",\n";
							
						}
					
						
						tx.commit();
					} catch (Exception e) {
						msg = "Try Again..";
						tx.rollback();
						e.printStackTrace();
					}
					

					map.put("succesfullyAdded", succesfullyAdded);
					map.put("msg", msg);
					map.put("itemsNotAvailable", itemsNotAvailable);
					return map;
				}
			
}