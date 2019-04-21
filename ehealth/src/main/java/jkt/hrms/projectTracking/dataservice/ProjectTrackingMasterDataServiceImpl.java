package jkt.hrms.projectTracking.dataservice;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jkt.hms.masters.business.MasBankMaster;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasRank;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.HrMasVisitType;
import jkt.hrms.masters.business.MstrBudgetSubhead;
import jkt.hrms.masters.business.MstrBudgetType;
import jkt.hrms.masters.business.MstrCalendar;
import jkt.hrms.masters.business.MstrDeptTaskMap;
import jkt.hrms.masters.business.MstrDoctype;
import jkt.hrms.masters.business.MstrDocument;
import jkt.hrms.masters.business.MstrPiDetail;
import jkt.hrms.masters.business.MstrPiHeader;
import jkt.hrms.masters.business.MstrProjectStatus;
import jkt.hrms.masters.business.MstrProjectrole;
import jkt.hrms.masters.business.MstrProjecttype;
import jkt.hrms.masters.business.MstrPtvisit;
import jkt.hrms.masters.business.MstrRating;
import jkt.hrms.masters.business.MstrRoleTaskMap;
import jkt.hrms.masters.business.MstrSiteDetail;
import jkt.hrms.masters.business.MstrSiteHeader;
import jkt.hrms.masters.business.MstrSponsor;
import jkt.hrms.masters.business.MstrSponsortype;
import jkt.hrms.masters.business.MstrTask;
import jkt.hrms.masters.business.MstrTaskType;
import jkt.hrms.masters.business.MstrTherapeutic;
import jkt.hrms.masters.business.MstrTrialphase;
import jkt.hrms.masters.business.MstrVendor;
import jkt.hrms.masters.business.MstrVitals;
import jkt.hrms.masters.business.VendorServiceType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ProjectTrackingMasterDataServiceImpl extends HibernateDaoSupport implements ProjectTrackingMasterDataService {
	
//-----------------------------------------------------------------------------------------
	public Map checkForExistingMasters(Map<String, Object> generalMap) {

		Map<String,Object> map = new HashMap<String, Object>();
		List duplicateMastersList = new ArrayList();
		List duplicateGeneralNameList = new ArrayList();
		List duplicateGeneralCodeList = new ArrayList();
		List duplicateGeneralAddressList = new ArrayList();
		int id = 0;
		String pojoPropertyCode = "";
		String pojoPropertyAddress = "";
		String pojoPropertyName = "";
		if(generalMap.get("id") != null){
			id = (Integer)generalMap.get("id");
		}
		
		String name = (String)generalMap.get("name");
		String pojoName = (String)generalMap.get("pojoName");
		if(generalMap.get("pojoPropertyName") != null)
			pojoPropertyName = (String)generalMap.get("pojoPropertyName");

		if(generalMap.get("pojoPropertyCode") != null){
			pojoPropertyCode = (String)generalMap.get("pojoPropertyCode");
		}
		if(generalMap.get("pojoPropertyAddress") != null){
			pojoPropertyAddress = (String)generalMap.get("pojoPropertyAddress");
		}

		if(generalMap.get("flag") == null){
			String code = (String)generalMap.get("code");
			String address = (String)generalMap.get("address");
			if(!pojoPropertyCode.equals("")){
				duplicateGeneralCodeList = getHibernateTemplate().find("from jkt.hrms.masters.business."+pojoName+" as g where g."+pojoPropertyCode+" ='"+code+"'");
			}
			if(!pojoPropertyName.equals("")){
				duplicateGeneralNameList = getHibernateTemplate().find("from jkt.hrms.masters.business."+pojoName+" as g where g."+pojoPropertyName+" = '"+name+"'");
			}
			if(!pojoPropertyAddress.equals("")){
				duplicateGeneralAddressList = getHibernateTemplate().find("from jkt.hrms.masters.business."+pojoName+" as g where g."+pojoPropertyAddress+" ='"+address+"'");
			}
			
		}
		else if(generalMap.get("flag") != null){
			boolean flag = (Boolean)generalMap.get("flag");
			duplicateMastersList = getHibernateTemplate().find("from jkt.hrms.masters.business."+pojoName+" as g where g."+pojoPropertyName+" = '"+name+"' and g.Id != "+id);
		}
		map.put("duplicateGeneralNameList", duplicateGeneralNameList);
		map.put("duplicateGeneralCodeList", duplicateGeneralCodeList);
		map.put("duplicateGeneralAddressList", duplicateGeneralAddressList);
		map.put("duplicateMastersList", duplicateMastersList);

		return map;
	}
	
//-------------------------------------Therapeutic Master-------------------------
	
//	@SuppressWarnings("unchecked")
	public Map<String, Object> searchTherapeutic(String thpCode, String thpDesc) 
	{
		List<MstrTherapeutic> searchTherapeuticList = new ArrayList<MstrTherapeutic>();
		
		Map<String,Object>  therapeuticFieldsMap = new HashMap<String,Object>();
		try{
			if((thpDesc!=null) || (thpCode==null)){
				searchTherapeuticList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrTherapeutic mth where mth.ThpDesc like '"+ thpDesc +"%' order by mth.ThpDesc");
			}
			else{
				searchTherapeuticList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrTherapeutic mth where mth.ThpCode like '"+ thpCode+"%' order by mth.ThpCode");}
			}catch (Exception e) {
				e.printStackTrace();
			}
			therapeuticFieldsMap.put("searchTherapeuticList",searchTherapeuticList);
		return therapeuticFieldsMap;	
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showTherapeuticJsp() {

		Map<String,Object>  map=new HashMap<String,Object>();
		List<MstrTherapeutic>  searchTherapeuticList=new ArrayList<MstrTherapeutic>();
		searchTherapeuticList=getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrTherapeutic"); // where MstrTherapeutic.status = 'y'
		map.put("searchTherapeuticList",searchTherapeuticList);
		return map;
	}

	public boolean addTherapeutic(MstrTherapeutic mstrTherapeutic) {
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(mstrTherapeutic);
		successfullyAdded = true;
		return successfullyAdded;
	}
	
	public boolean editTherapeuticToDatabase(Map<String, Object> generalMap) {
		
		boolean dataUpdated=false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		String therapeuticName="";
		@SuppressWarnings("unused")
		String therapeuticCode="";
		int therapeuticId=0;
		String changedBy = "";
		
		therapeuticId=(Integer)generalMap.get("id");
		therapeuticCode=(String)generalMap.get("therapeuticCode");
		therapeuticName=(String)generalMap.get("name");
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		MstrTherapeutic mstrTherapeutic=(MstrTherapeutic)getHibernateTemplate().load(MstrTherapeutic.class,therapeuticId);
		
		mstrTherapeutic.setId(therapeuticId);
		mstrTherapeutic.setThpDesc(therapeuticName);
		mstrTherapeutic.setLastChgBy(changedBy);
		mstrTherapeutic.setLastChgDate(currentDate);
		mstrTherapeutic.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrTherapeutic);
		dataUpdated = true;
		return dataUpdated;
	}
	
	public boolean deleteTherapeutic(int therapeuticId,Map<String, Object> generalMap) {
		boolean dataDeleted=false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		MstrTherapeutic mstrTherapeutic = new MstrTherapeutic();
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		mstrTherapeutic =(MstrTherapeutic)getHibernateTemplate().load(MstrTherapeutic.class,therapeuticId);
		  if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  mstrTherapeutic.setStatus("n");
				  dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  mstrTherapeutic.setStatus("y");
				  dataDeleted=false;
			  }
		  }
		  mstrTherapeutic.setLastChgBy(changedBy);
		  mstrTherapeutic.setLastChgDate(currentDate);
		  mstrTherapeutic.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrTherapeutic);
		return dataDeleted;
	} 
//-------------------------------------Project Role Master-------------------------
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchProjectRole(String prjCode, String prjName) 
	{
		List<MstrProjectrole> searchProjectRoleList = new ArrayList<MstrProjectrole>();
		
		Map<String,Object>  projectRoleFieldsMap = new HashMap<String,Object>();
		try{
			if((prjName!=null) || (prjCode==null)){
				searchProjectRoleList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrProjectrole mpr where mpr.PjrName like '"+ prjName +"%' order by mpr.PjrName");
			}
			else{
				searchProjectRoleList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrProjectrole mpr where mpr.PjrCode like '"+ prjCode+"%' order by mpr.PjrCode");}
			}catch (Exception e) {
				e.printStackTrace();
			}
			projectRoleFieldsMap.put("searchProjectRoleList",searchProjectRoleList);
			return projectRoleFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showProjectRoleJsp() {

		Map<String,Object>  map=new HashMap<String,Object>();
		List<MstrProjectrole>  searchProjectRoleList=new ArrayList<MstrProjectrole>();
		searchProjectRoleList=getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrProjectrole"); // 
		map.put("searchProjectRoleList",searchProjectRoleList);
		return map;
	}

	public boolean addProjectRole(MstrProjectrole mstrProjectrole) {
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(mstrProjectrole);
		successfullyAdded = true;
		return successfullyAdded;
	}
	
	public boolean editProjectRoleToDatabase(Map<String, Object> generalMap) {
		
		boolean dataUpdated=false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		String projectRoleName="";
		@SuppressWarnings("unused")
		String projectRoleCode="";
		int projectRoleId=0;
		String changedBy = "";
		
		projectRoleId=(Integer)generalMap.get("id");
		projectRoleCode=(String)generalMap.get("projectRoleCode");
		projectRoleName=(String)generalMap.get("name");
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		MstrProjectrole mstrProjectrole=(MstrProjectrole)getHibernateTemplate().load(MstrProjectrole.class,projectRoleId);
		
		mstrProjectrole.setId(projectRoleId);
		mstrProjectrole.setPjrCode(projectRoleCode);
		mstrProjectrole.setPjrName(projectRoleName);
		mstrProjectrole.setLastChgBy(changedBy);
		mstrProjectrole.setLastChgDate(currentDate);
		mstrProjectrole.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrProjectrole	);
		dataUpdated = true;
		return dataUpdated;
	}
	public boolean deleteProjectRole(int projectRoleId,Map<String, Object> generalMap) {
		boolean dataDeleted=false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		MstrProjectrole mstrProjectrole = new MstrProjectrole();
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		mstrProjectrole =(MstrProjectrole)getHibernateTemplate().load(MstrProjectrole.class,projectRoleId);
		  if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  mstrProjectrole.setStatus("n");
				  dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  mstrProjectrole.setStatus("y");
				  dataDeleted=false;
			  }
		  }
		  mstrProjectrole.setLastChgBy(changedBy);
		  mstrProjectrole.setLastChgDate(currentDate);
		  mstrProjectrole.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrProjectrole);
		return dataDeleted;
	} 
	
//-------------------------------------Project Type Master-------------------------
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchProjectType(String prjTypeCode, String prjTypeName) 
	{
		List<MstrProjecttype> searchProjectTypeList = new ArrayList<MstrProjecttype>();
		
		Map<String,Object>  projectTypeFieldsMap = new HashMap<String,Object>();
		try{
			if((prjTypeName!=null) || (prjTypeCode==null)){
				searchProjectTypeList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrProjecttype mpt where mpt.ProjectName like '"+ prjTypeName +"%' order by mpt.ProjectName");
			}
			else{
				searchProjectTypeList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrProjecttype mpt where mpt.ProjectCode like '"+ prjTypeCode+"%' order by mpt.ProjectCode");}
			}catch (Exception e) {
				e.printStackTrace();
			}
			projectTypeFieldsMap.put("searchProjectTypeList",searchProjectTypeList);
		
		return projectTypeFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showProjectTypeJsp() {

		Map<String,Object>  map=new HashMap<String,Object>();
		List<MstrProjecttype>  searchProjectTypeList=new ArrayList<MstrProjecttype>();
		searchProjectTypeList=getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrProjecttype"); // 
		map.put("searchProjectTypeList",searchProjectTypeList);
		return map;
	}
	
	public boolean addProjectType(MstrProjecttype mstrProjecttype) {
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(mstrProjecttype);
		successfullyAdded = true;
		return successfullyAdded;
	}
	
	public boolean editProjectTypeToDatabase(Map<String, Object> generalMap) {
		
		boolean dataUpdated=false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		String projectTypeName="";
		@SuppressWarnings("unused")
		String projectTypeCode="";
		int projectTypeId=0;
		String changedBy = "";
		
		projectTypeId=(Integer)generalMap.get("id");
		projectTypeCode=(String)generalMap.get("projectTypeCode");
		projectTypeName=(String)generalMap.get("name");
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		MstrProjecttype mstrProjecttype=(MstrProjecttype)getHibernateTemplate().load(MstrProjecttype.class,projectTypeId);
		
		mstrProjecttype.setId(projectTypeId);
		mstrProjecttype.setProjectName(projectTypeName);
		mstrProjecttype.setLastChgBy(changedBy);
		mstrProjecttype.setLastChgDate(currentDate);
		mstrProjecttype.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrProjecttype);
		dataUpdated = true;
		return dataUpdated;
	}
	
	public boolean deleteProjectType(int projectTypeId,Map<String, Object> generalMap) {
		boolean dataDeleted=false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		MstrProjecttype mstrProjectType = new MstrProjecttype();
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		mstrProjectType =(MstrProjecttype)getHibernateTemplate().load(MstrProjecttype.class,projectTypeId);
		  if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  mstrProjectType.setStatus("n");
				  dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  mstrProjectType.setStatus("y");
				  dataDeleted=false;
			  }
		  }
		  mstrProjectType.setLastChgBy(changedBy);
		  mstrProjectType.setLastChgDate(currentDate);
		  mstrProjectType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrProjectType);
		return dataDeleted;
	}
	
//-------------------------------------Trial Phase Master-------------------------
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchTrialPhase(String trialPhaseCode, String trialPhaseName) 
	{
		List<MstrTrialphase> searchTrialPhaseList = new ArrayList<MstrTrialphase>();
		
		Map<String,Object>  trialphaseFieldsMap = new HashMap<String,Object>();
		try{
			if((trialPhaseName!=null) || (trialPhaseCode==null)){
				searchTrialPhaseList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrTrialphase mtp where mtp.TrialPhaseName like '"+ trialPhaseName +"%' order by mtp.TrialPhaseName");
			}
			else{
				searchTrialPhaseList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrTrialphase mtp where mtp.TrialPhaseCode like '"+ trialPhaseCode+"%' order by mtp.TrialPhaseCode");}
			}catch (Exception e) {
				e.printStackTrace();
			}
			trialphaseFieldsMap.put("searchTrialPhaseList",searchTrialPhaseList);

		
		return trialphaseFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showTrialPhaseJsp() {

		Map<String,Object>  map=new HashMap<String,Object>();
		List<MstrTrialphase>  searchTrialPhaseList=new ArrayList<MstrTrialphase>();
		searchTrialPhaseList=getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrTrialphase"); // 
		map.put("searchTrialPhaseList",searchTrialPhaseList);
		return map;
	}
	
	public boolean addTrialPhase(MstrTrialphase mstrTrialphase) {
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(mstrTrialphase);
		successfullyAdded = true;
		return successfullyAdded;
	}
	
	public boolean editTrialPhaseToDatabase(Map<String, Object> generalMap) {
		
		boolean dataUpdated=false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		String trialPhaseName="";
		@SuppressWarnings("unused")
		String trialPhaseCode="";
		int trialPhaseId=0;
		String changedBy = "";
		
		trialPhaseId=(Integer)generalMap.get("id");
		trialPhaseCode=(String)generalMap.get("projectTypeCode");
		trialPhaseName=(String)generalMap.get("name");
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		MstrTrialphase mstrTrialphase=(MstrTrialphase)getHibernateTemplate().load(MstrTrialphase.class,trialPhaseId);
		
		mstrTrialphase.setId(trialPhaseId);
		mstrTrialphase.setTrialPhaseName(trialPhaseName);
		mstrTrialphase.setLastChgBy(changedBy);
		mstrTrialphase.setLastChgDate(currentDate);
		mstrTrialphase.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrTrialphase);
		dataUpdated = true;
		return dataUpdated;
	}
	
	public boolean deleteTrialPhase(int trialPhaseId,Map<String, Object> generalMap) {
		boolean dataDeleted=false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		MstrTrialphase mstrTrialphase = new MstrTrialphase();
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		mstrTrialphase =(MstrTrialphase)getHibernateTemplate().load(MstrTrialphase.class,trialPhaseId);
		  if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  mstrTrialphase.setStatus("n");
				  dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  mstrTrialphase.setStatus("y");
				  dataDeleted=false;
			  }
		  }
		  mstrTrialphase.setLastChgBy(changedBy);
		  mstrTrialphase.setLastChgDate(currentDate);
		  mstrTrialphase.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrTrialphase);
		return dataDeleted;
	}
	
// -------------------------------------Sponser Type Master-------------------------
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchSponserType(String sponserTypeCode, String sponserTypeName) 
	{
		List<MstrSponsortype> searchSponserTypeList = new ArrayList<MstrSponsortype>();
		
		Map<String,Object>  sponserTypeFieldsMap = new HashMap<String,Object>();
		try{
			if((sponserTypeName!=null) || (sponserTypeCode==null)){
				searchSponserTypeList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrSponsortype mst where mst.SponserTypeName like '"+ sponserTypeName +"%' order by mst.SponserTypeName");
			}
			else{
				searchSponserTypeList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrSponsortype mst where mst.SponserTypeCode like '"+ sponserTypeCode+"%' order by mst.SponserTypeCode");}
			}catch (Exception e) {
				e.printStackTrace();
			}
			sponserTypeFieldsMap.put("searchSponserTypeList",searchSponserTypeList);

		
		return sponserTypeFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showSponserTypeJsp() {

		Map<String,Object>  map=new HashMap<String,Object>();
		List<MstrSponsortype>  searchSponserTypeList=new ArrayList<MstrSponsortype>();
		searchSponserTypeList=getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrSponsortype"); // 
		map.put("searchSponserTypeList",searchSponserTypeList);
		return map;
	}
	
	public boolean addSponserType(MstrSponsortype mstrSponsortype) {
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(mstrSponsortype);
		successfullyAdded = true;
		return successfullyAdded;
	}
	
	public boolean editSponserTypeToDatabase(Map<String, Object> generalMap) {
		
		boolean dataUpdated=false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		String sponserTypeName="";
		@SuppressWarnings("unused")
		String sponserTypeCode="";
		int sponserTypeId=0;
		String changedBy = "";
		
		sponserTypeId=(Integer)generalMap.get("id");
		sponserTypeCode=(String)generalMap.get("projectTypeCode");
		sponserTypeName=(String)generalMap.get("name");
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		MstrSponsortype mstrSponsortype=(MstrSponsortype)getHibernateTemplate().load(MstrSponsortype.class,sponserTypeId);
		
		mstrSponsortype.setId(sponserTypeId);
		mstrSponsortype.setSponserTypeName(sponserTypeName);
		mstrSponsortype.setLastChgBy(changedBy);
		mstrSponsortype.setLastChgDate(currentDate);
		mstrSponsortype.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrSponsortype);
		dataUpdated = true;
		return dataUpdated;
	}
	
	public boolean deleteSponserType(int sponserTypeId,Map<String, Object> generalMap) {
		boolean dataDeleted=false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		MstrSponsortype mstrSponsortype = new MstrSponsortype();
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		mstrSponsortype =(MstrSponsortype)getHibernateTemplate().load(MstrSponsortype.class,sponserTypeId);
		  if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  mstrSponsortype.setStatus("n");
				  dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  mstrSponsortype.setStatus("y");
				  dataDeleted=false;
			  }
		  }
		  mstrSponsortype.setLastChgBy(changedBy);
		  mstrSponsortype.setLastChgDate(currentDate);
		  mstrSponsortype.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrSponsortype);
		return dataDeleted;
	}
	
// -------------------------------------Budget Sub-Heading Master-------------------------
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBudgetSubHeading(String budgetSubHeadingCode, String budgetSubHeadingName) 
	{
		List<MstrBudgetSubhead> searchBudgetSubHeadingList = new ArrayList<MstrBudgetSubhead>();
		
		Map<String,Object>  budgetSubHeadingFieldsMap = new HashMap<String,Object>();
		try{
			if((budgetSubHeadingName!=null) || (budgetSubHeadingCode==null)){
				searchBudgetSubHeadingList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrBudgetSubhead mbs where mbs.BudName like '"+ budgetSubHeadingName +"%' order by mbs.BudName");
			}
			else{
				searchBudgetSubHeadingList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrBudgetSubhead mbs where mbs.BudSubheadCode like '"+ budgetSubHeadingCode+"%' order by mbs.BudSubheadCode");}
			}catch (Exception e) {
				e.printStackTrace();
			}
			budgetSubHeadingFieldsMap.put("searchBudgetSubHeadingList",searchBudgetSubHeadingList);

		
		return budgetSubHeadingFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBudgetSubHeadingJsp() {

		Map<String,Object>  map=new HashMap<String,Object>();
		List<MstrBudgetSubhead>  searchBudgetSubHeadingList=new ArrayList<MstrBudgetSubhead>();
		searchBudgetSubHeadingList=getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrBudgetSubhead"); // 
		map.put("searchBudgetSubHeadingList",searchBudgetSubHeadingList);
		return map;
	}
	

	public boolean editBudgetSubHeadingToDatabase(Map<String, Object> generalMap) {
		
		boolean dataUpdated=false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		String budgetSubHeadingName="";
		@SuppressWarnings("unused")
		String budgetSubHeadingCode="";
		int budgetSubHeadingId=0;
		String changedBy = "";
		
		budgetSubHeadingId=(Integer)generalMap.get("id");
		budgetSubHeadingCode=(String)generalMap.get("budgetSubHeadingCode");
		budgetSubHeadingName=(String)generalMap.get("name");
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		MstrBudgetSubhead mstrBudgetSubhead=(MstrBudgetSubhead)getHibernateTemplate().load(MstrBudgetSubhead.class,budgetSubHeadingId);
		
		mstrBudgetSubhead.setId(budgetSubHeadingId);
		mstrBudgetSubhead.setBudName(budgetSubHeadingName);
		mstrBudgetSubhead.setLastChgBy(changedBy);
		mstrBudgetSubhead.setLastChgDate(currentDate);
		mstrBudgetSubhead.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrBudgetSubhead);
		dataUpdated = true;
		return dataUpdated;
	}
	
	public boolean addBudgetSubHeading(MstrBudgetSubhead mstrBudgetSubhead) {
	boolean successfullyAdded=false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_AUTO");
	hbt.setCheckWriteOperations(false);
	hbt.save(mstrBudgetSubhead);
	successfullyAdded = true;
	return successfullyAdded;
}
	
	
	public boolean deleteBudgetSubHeading(int budgetSubHeadingId,Map<String, Object> generalMap) {
		boolean dataDeleted=false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		MstrBudgetSubhead mstrBudgetSubhead = new MstrBudgetSubhead();
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		mstrBudgetSubhead =(MstrBudgetSubhead)getHibernateTemplate().load(MstrBudgetSubhead.class,budgetSubHeadingId);
		  if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  mstrBudgetSubhead.setStatus("n");
				  dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  mstrBudgetSubhead.setStatus("y");
				  dataDeleted=false;
			  }
		  }
		  mstrBudgetSubhead.setLastChgBy(changedBy);
		  mstrBudgetSubhead.setLastChgDate(currentDate);
		  mstrBudgetSubhead.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrBudgetSubhead);
		return dataDeleted;
	}
	
// -------------------------------------Task Type Master-------------------------
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchTaskType(String taskTypeCode, String taskTypeName) 
	{
		List<MstrTaskType> searchTaskTypeList = new ArrayList<MstrTaskType>();
		
		Map<String,Object>  taskTypeFieldsMap = new HashMap<String,Object>();
		try{
			if((taskTypeName!=null) || (taskTypeCode==null)){
				searchTaskTypeList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrTaskType mtt where mtt.TaskTypeName like '"+ taskTypeName +"%' order by mtt.TaskTypeName");
			}
			else{
				searchTaskTypeList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrTaskType mtt where mtt.TaskTypeCode like '"+ taskTypeCode+"%' order by mtt.TaskTypeCode");}
			}catch (Exception e) {
				e.printStackTrace();
			}
			taskTypeFieldsMap.put("searchTaskTypeList",searchTaskTypeList);

		
		return taskTypeFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showTaskTypeJsp() {
	
		Map<String,Object>  map=new HashMap<String,Object>();
		List<MstrTaskType>  searchTaskTypeList=new ArrayList<MstrTaskType>();
		try {
			searchTaskTypeList=getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrTaskType");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}  
		map.put("searchTaskTypeList",searchTaskTypeList);
		return map;
	}
	

	public boolean editTaskTypeToDatabase(Map<String, Object> generalMap) {
		
		boolean dataUpdated=false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		String taskTypeName="";
		@SuppressWarnings("unused")
		String taskTypeCode="";
		int taskTypeId=0;
		String changedBy = "";
		
		taskTypeId=(Integer)generalMap.get("id");
		taskTypeCode=(String)generalMap.get("taskTypeCode");
		taskTypeName=(String)generalMap.get("name");
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		MstrTaskType mstrTaskType=(MstrTaskType)getHibernateTemplate().load(MstrTaskType.class,taskTypeId);
		
		mstrTaskType.setId(taskTypeId);
		mstrTaskType.setTaskTypeName(taskTypeName);
		mstrTaskType.setLastChgBy(changedBy);
		mstrTaskType.setLastChgDate(currentDate);
		mstrTaskType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrTaskType);
		dataUpdated = true;
		return dataUpdated;
	}
	
	public boolean addTaskType(MstrTaskType mstrTaskType) {
	boolean successfullyAdded=false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_AUTO");
	hbt.setCheckWriteOperations(false);
	hbt.save(mstrTaskType);
	successfullyAdded = true;
	return successfullyAdded;
}
	
	
	public boolean deleteTaskType(int taskTypeId,Map<String, Object> generalMap) {
		boolean dataDeleted=false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		MstrTaskType mstrTaskType = new MstrTaskType();
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		mstrTaskType =(MstrTaskType)getHibernateTemplate().load(MstrTaskType.class,taskTypeId);
		  if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  mstrTaskType.setStatus("n");
				  dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  mstrTaskType.setStatus("y");
				  dataDeleted=false;
			  }
		  }
		  mstrTaskType.setLastChgBy(changedBy);
		  mstrTaskType.setLastChgDate(currentDate);
		  mstrTaskType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrTaskType);
		return dataDeleted;
	}
	
	
	//--------------------------------------------Task Master---------------------------------------
	
	public Map<String, Object> showTaskMasterJsp() {

		Map<String,Object>  map=new HashMap<String,Object>();
		List<MstrTask>  searchTaskList=new ArrayList<MstrTask>();
		List<MstrTaskType> taskTypeList=new ArrayList<MstrTaskType>();
		List<MstrBudgetSubhead>  budgetSubHeadingList=new ArrayList<MstrBudgetSubhead>();
		try {
			searchTaskList=getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrTask order by TaskName");
			taskTypeList =getHibernateTemplate().find("from jkt.hrms.masters.business.MstrTaskType");
			budgetSubHeadingList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrBudgetSubhead");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}  

		map.put("searchTaskList",searchTaskList);
		map.put("taskTypeList", taskTypeList);
		map.put("budgetSubHeadingList", budgetSubHeadingList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchTask(String taskCode, String taskName) 
	{

		List<MstrTask> searchTaskList = new ArrayList<MstrTask>();
		List<MstrTaskType> taskTypeList=new ArrayList<MstrTaskType>();
		List<MstrBudgetSubhead>  budgetSubHeadingList=new ArrayList<MstrBudgetSubhead>();
		
		Map<String,Object>  taskFieldsMap = new HashMap<String,Object>();
		try{
			taskTypeList =getHibernateTemplate().find("from jkt.hrms.masters.business.MstrTaskType");
			budgetSubHeadingList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrBudgetSubhead");
			if((taskName!=null) || (taskCode==null)){
				searchTaskList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrTask mt where mt.TaskName like '"+ taskName +"%' order by mt.TaskName");
			}
			else{
				searchTaskList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrTask mt where mt.TaskCode like '"+ taskCode+"%' order by mt.TaskCode");}
			}catch (Exception e) {
				e.printStackTrace();
			}
			taskFieldsMap.put("searchTaskList",searchTaskList);
			taskFieldsMap.put("taskTypeList", taskTypeList);
			taskFieldsMap.put("budgetSubHeadingList", budgetSubHeadingList);

		
		return taskFieldsMap;
	}
	
	public boolean deleteTask(int taskId,Map<String, Object> generalMap) {
		boolean dataDeleted=false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		MstrTask mstrTask = new MstrTask();
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		mstrTask =(MstrTask)getHibernateTemplate().load(MstrTask.class,taskId);
		  if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  mstrTask.setStatus("n");
				  dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  mstrTask.setStatus("y");
				  dataDeleted=false;
			  }
		  }
		  mstrTask.setLastChgBy(changedBy);
		  mstrTask.setLastChgDate(currentDate);
		  mstrTask.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrTask);
		return dataDeleted;
	}
	
	public boolean addTask(MstrTask mstrTask) {
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(mstrTask);
		hbt.flush();
		hbt.refresh(mstrTask);
		successfullyAdded = true;
		return successfullyAdded;
	}
	
	public boolean editTaskToDatabase(Map<String, Object> generalMap) {
			
			boolean dataUpdated=false;
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
			String taskName="";
			int taskTypeId = 0;
			int budgetsubHeadingId = 0;
			@SuppressWarnings("unused")
			String taskCode="";
			int taskId=0;
			String changedBy = "";
			
			taskId=(Integer)generalMap.get("id");
			taskCode=(String)generalMap.get("taskTypeCode");
			taskName=(String)generalMap.get("name");
			taskTypeId =(Integer)generalMap.get("taskTypeId");
			changedBy = (String)generalMap.get("changedBy");
			currentDate=(Date)generalMap.get("currentDate");
			currentTime=(String)generalMap.get("currentTime");
			MstrTask mstrTask=(MstrTask)getHibernateTemplate().load(MstrTask.class,taskId);
			
			if(!generalMap.get("budgetSubHeadingId").equals(0)){
				budgetsubHeadingId = (Integer)generalMap.get("budgetSubHeadingId");
				MstrBudgetSubhead mstrBudgetSubhead = new MstrBudgetSubhead();
				mstrBudgetSubhead.setId(budgetsubHeadingId);
				mstrTask.setBudid(mstrBudgetSubhead);
			}
			MstrTaskType mstrTaskType = new MstrTaskType();
			mstrTaskType.setId(taskTypeId);
			mstrTask.setTaskType(mstrTaskType);
			
			mstrTask.setId(taskId);
			mstrTask.setTaskName(taskName);
			mstrTask.setLastChgBy(changedBy);
			mstrTask.setLastChgDate(currentDate);
			mstrTask.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(mstrTask);
			dataUpdated = true;
			return dataUpdated;
		}
	
	//-------------------------------------Budget Type Master-------------------------
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBudgetType(String budgetTypeCode, String budgetTypeName) 
	{

		List<MstrBudgetType> searchBudgetTypeList = new ArrayList<MstrBudgetType>();
		
		Map<String,Object>  budgetTypeFieldsMap = new HashMap<String,Object>();
		try{
			if((budgetTypeName!=null) || (budgetTypeCode==null)){
				searchBudgetTypeList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrBudgetType mbt where mbt.BudgetTypeName like '"+ budgetTypeName +"%' order by mbt.BudgetTypeName");
			}
			else{
				searchBudgetTypeList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrBudgetType mbt where mbt.BudgetTypeCode like '"+ budgetTypeCode+"%' order by mbt.BudgetTypeCode");}
			}catch (Exception e) {
				e.printStackTrace();
			}
			budgetTypeFieldsMap.put("searchBudgetTypeList",searchBudgetTypeList);
		
		return budgetTypeFieldsMap;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> showBudgetTypeJsp() {

		Map<String,Object>  map=new HashMap<String,Object>();
		List<MstrBudgetType>  searchBudgetTypeList=new ArrayList<MstrBudgetType>();
		try {
			searchBudgetTypeList=getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrBudgetType");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}  
		map.put("searchBudgetTypeList",searchBudgetTypeList);
		return map;
	}
	
	
	public boolean editBudgetTypeToDatabase(Map<String, Object> generalMap) {
		
		boolean dataUpdated=false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		String budgetTypeName="";
		@SuppressWarnings("unused")
		String budgetTypeCode="";
		int budgetTypeId=0;
		String changedBy = "";
		
		budgetTypeId=(Integer)generalMap.get("id");
		budgetTypeCode=(String)generalMap.get("budgetTypeCode");
		budgetTypeName=(String)generalMap.get("name");
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		MstrBudgetType mstrBudgetType=(MstrBudgetType)getHibernateTemplate().load(MstrBudgetType.class,budgetTypeId);
		
		mstrBudgetType.setId(budgetTypeId);
		mstrBudgetType.setBudgetTypeName(budgetTypeName);
		mstrBudgetType.setLastChgBy(changedBy);
		mstrBudgetType.setLastChgDate(currentDate);
		mstrBudgetType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrBudgetType);
		dataUpdated = true;
		return dataUpdated;
	}
	
	public boolean addBudgetType(MstrBudgetType mstrBudgetType) {
	boolean successfullyAdded=false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_AUTO");
	hbt.setCheckWriteOperations(false);
	hbt.save(mstrBudgetType);
	successfullyAdded = true;
	return successfullyAdded;
	}
	
	
	public boolean deleteBudgetType(int budgetTypeId,Map<String, Object> generalMap) {
		boolean dataDeleted=false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		MstrBudgetType mstrBudgetType = new MstrBudgetType();
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		mstrBudgetType =(MstrBudgetType)getHibernateTemplate().load(MstrBudgetType.class,budgetTypeId);
		  if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  mstrBudgetType.setStatus("n");
				  dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  mstrBudgetType.setStatus("y");
				  dataDeleted=false;
			  }
		  }
		  mstrBudgetType.setLastChgBy(changedBy);
		  mstrBudgetType.setLastChgDate(currentDate);
		  mstrBudgetType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrBudgetType);
		return dataDeleted;
	}

	//-------------------------------------Patient Visit Master-------------------------
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchPatientVisit(String patientVisitCode, String patientVisitName) 
	{

		List<MstrPtvisit> searchPatientVisitList = new ArrayList<MstrPtvisit>();
		
		Map<String,Object>  patientVisitFieldsMap = new HashMap<String,Object>();
		try{
			if((patientVisitName!=null) || (patientVisitCode==null)){
				searchPatientVisitList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrPtvisit mpv where mpv.PatientVisitName like '"+ patientVisitName +"%' order by mpv.PatientVisitName");
			}
			else{
				searchPatientVisitList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrPtvisit mpv where mpv.PatientVisitCode like '"+ patientVisitCode+"%' order by mpv.PatientVisitCode");}
			}catch (Exception e) {
				e.printStackTrace();
			}
			patientVisitFieldsMap.put("searchPatientVisitList",searchPatientVisitList);
		
		return patientVisitFieldsMap;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> showPatientVisitJsp() {

		Map<String,Object>  map=new HashMap<String,Object>();
		List<MstrPtvisit>  searchPatientVisitList=new ArrayList<MstrPtvisit>();
		try {
			searchPatientVisitList=getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrPtvisit");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}  

		map.put("searchPatientVisitList",searchPatientVisitList);
		return map;
	}
	
	
	public boolean editPatientVisitToDatabase(Map<String, Object> generalMap) {
		
		boolean dataUpdated=false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		String patientVisitName="";
		@SuppressWarnings("unused")
		String patientVisitCode="";
		int patientVisitId=0;
		String changedBy = "";
		
		patientVisitId=(Integer)generalMap.get("id");
		patientVisitCode=(String)generalMap.get("patientVisitCode");
		patientVisitName=(String)generalMap.get("name");
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		MstrPtvisit mstrPtvisit=(MstrPtvisit)getHibernateTemplate().load(MstrPtvisit.class,patientVisitId);
		
		mstrPtvisit.setId(patientVisitId);
		mstrPtvisit.setPatientVisitName(patientVisitName);
		mstrPtvisit.setLastChgBy(changedBy);
		mstrPtvisit.setLastChgDate(currentDate);
		mstrPtvisit.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrPtvisit);
		dataUpdated = true;
		return dataUpdated;
	}
	
	public boolean addPatientVisit(MstrPtvisit mstrPtvisit) {
	boolean successfullyAdded=false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_AUTO");
	hbt.setCheckWriteOperations(false);
	hbt.save(mstrPtvisit);
	successfullyAdded = true;
	return successfullyAdded;
	}
	
	
	public boolean deletePatientVisit(int patientVisitId,Map<String, Object> generalMap) {
		boolean dataDeleted=false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		MstrPtvisit mstrPtvisit = new MstrPtvisit();
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		mstrPtvisit =(MstrPtvisit)getHibernateTemplate().load(MstrPtvisit.class,patientVisitId);
		  if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  mstrPtvisit.setStatus("n");
				  dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  mstrPtvisit.setStatus("y");
				  dataDeleted=false;
			  }
		  }
		  mstrPtvisit.setLastChgBy(changedBy);
		  mstrPtvisit.setLastChgDate(currentDate);
		  mstrPtvisit.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrPtvisit);
		return dataDeleted;
	}
	
	//-------------------------------------Document Type Master-------------------------
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDocumentType(String documentTypeCode, String documentTypeName) 
	{

		List<MstrDoctype> searchDocumentTypeList = new ArrayList<MstrDoctype>();
		
		Map<String,Object>  documentTypeFieldsMap = new HashMap<String,Object>();
		try{
			if((documentTypeName!=null) || (documentTypeCode==null)){
				searchDocumentTypeList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrDoctype mdt where mdt.DocTypeName like '"+ documentTypeName +"%' order by mdt.DocTypeName");
			}
			else{
				searchDocumentTypeList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrDoctype mdt where mdt.DocTypeCode like '"+ documentTypeCode+"%' order by mdt.DocTypeCode");}
			}catch (Exception e) {
				e.printStackTrace();
			}
			documentTypeFieldsMap.put("searchDocumentTypeList",searchDocumentTypeList);
		
		return documentTypeFieldsMap;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> showDocumentTypeJsp() {

		Map<String,Object>  map=new HashMap<String,Object>();
		List<MstrDoctype>  searchDocumentTypeList=new ArrayList<MstrDoctype>();
		try {
			searchDocumentTypeList=getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrDoctype");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}  

		map.put("searchDocumentTypeList",searchDocumentTypeList);
		return map;
	}
	
	
	public boolean editDocumentTypeToDatabase(Map<String, Object> generalMap) {
		
		boolean dataUpdated=false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		String documentTypeName="";
		@SuppressWarnings("unused")
		String documentTypeCode="";
		int documentTypeId=0;
		String changedBy = "";
		
		documentTypeId=(Integer)generalMap.get("id");
		documentTypeCode=(String)generalMap.get("documentTypeCode");
		documentTypeName=(String)generalMap.get("name");
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		MstrDoctype mstrDoctype=(MstrDoctype)getHibernateTemplate().load(MstrDoctype.class,documentTypeId);
		
		mstrDoctype.setId(documentTypeId);
		mstrDoctype.setDocTypeName(documentTypeName);
		mstrDoctype.setLastChgBy(changedBy);
		mstrDoctype.setLastChgDate(currentDate);
		mstrDoctype.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrDoctype);
		dataUpdated = true;
		return dataUpdated;
	}
	
	public boolean addDocumentType(MstrDoctype mstrDoctype) {
	boolean successfullyAdded=false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_AUTO");
	hbt.setCheckWriteOperations(false);
	hbt.save(mstrDoctype);
	successfullyAdded = true;
	return successfullyAdded;
	}
	
	
	public boolean deleteDocumentType(int documentTypeId,Map<String, Object> generalMap) {
		boolean dataDeleted=false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		MstrDoctype mstrDoctype = new MstrDoctype();
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		mstrDoctype =(MstrDoctype)getHibernateTemplate().load(MstrDoctype.class,documentTypeId);
		  if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  mstrDoctype.setStatus("n");
				  dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  mstrDoctype.setStatus("y");
				  dataDeleted=false;
			  }
		  }
		  mstrDoctype.setLastChgBy(changedBy);
		  mstrDoctype.setLastChgDate(currentDate);
		  mstrDoctype.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrDoctype);
		return dataDeleted;
	}
	
//--------------------------------------------Document Master---------------------------------------
	
	public Map<String, Object> showDocumentJsp() {

		Map<String,Object>  map=new HashMap<String,Object>();
		List<MstrDocument>  searchDocumentList=new ArrayList<MstrDocument>();
		List<MstrDoctype> documentTypeList=new ArrayList<MstrDoctype>();
		try {
			searchDocumentList=getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrDocument");
			documentTypeList =getHibernateTemplate().find("from jkt.hrms.masters.business.MstrDoctype");
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}  

		map.put("searchDocumentList",searchDocumentList);
		map.put("documentTypeList", documentTypeList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDocument(String documentCode, String documentName) 
	{

		List<MstrDocument> searchDocumentList = new ArrayList<MstrDocument>();
		
		Map<String,Object>  documentFieldsMap = new HashMap<String,Object>();
		try{
			if((documentName!=null) || (documentCode==null)){
				searchDocumentList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrDocument mtd where mtd.DocName like '"+ documentName +"%' order by mtd.DocName");
			}
			else{
				searchDocumentList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrDocument mtd where mtd.DocCode like '"+ documentCode+"%' order by mtd.DocCode");}
			}catch (Exception e) {
				e.printStackTrace();
			}
			documentFieldsMap.put("searchDocumentList",searchDocumentList);

		
		return documentFieldsMap;
	}
	
	public boolean deleteDocument(int documentId,Map<String, Object> generalMap) {
		boolean dataDeleted=false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		MstrDocument mstrDocument = new MstrDocument();
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		mstrDocument =(MstrDocument)getHibernateTemplate().load(MstrDocument.class,documentId);
		  if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  mstrDocument.setStatus("n");
				  dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  mstrDocument.setStatus("y");
				  dataDeleted=false;
			  }
		  }
		  mstrDocument.setLastChgBy(changedBy);
		  mstrDocument.setLastChgDate(currentDate);
		  mstrDocument.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrDocument);
		return dataDeleted;
	}
	
	public boolean addDocument(MstrDocument mstrDocument) {
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(mstrDocument);
		hbt.flush();
		hbt.refresh(mstrDocument);
		successfullyAdded = true;
		return successfullyAdded;
	}
	
	public boolean editDocumentToDatabase(Map<String, Object> generalMap) {
			
			boolean dataUpdated=false;
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
			String documentName="";
			int documentTypeId = 0;
			@SuppressWarnings("unused")
			String documentCode="";
			int documentId=0;
			String changedBy = "";
			
			documentId=(Integer)generalMap.get("id");
			documentCode=(String)generalMap.get("documentCode");
			documentName=(String)generalMap.get("name");

			changedBy = (String)generalMap.get("changedBy");
			currentDate=(Date)generalMap.get("currentDate");
			currentTime=(String)generalMap.get("currentTime");
			MstrDocument mstrDocument=(MstrDocument)getHibernateTemplate().load(MstrDocument.class,documentId);
			if(generalMap.get("documentTypeId")!= null){
				documentTypeId =(Integer)generalMap.get("documentTypeId");
				MstrDoctype mstrDoctype = new MstrDoctype();
				mstrDoctype.setId(documentTypeId);
				mstrDocument.setDocType(mstrDoctype);
			}
			
			mstrDocument.setId(documentId);
			mstrDocument.setDocName(documentName);
			mstrDocument.setLastChgBy(changedBy);
			mstrDocument.setLastChgDate(currentDate);
			mstrDocument.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(mstrDocument);
			dataUpdated = true;
			return dataUpdated;
		}
//-------------------------------------Rating Master-------------------------
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchRating(String ratingCode, String ratingName) 
	{

		List<MstrRating> searchRatingList = new ArrayList<MstrRating>();
		
		Map<String,Object>  ratingFieldsMap = new HashMap<String,Object>();
		try{
			if((ratingName!=null) || (ratingCode==null)){
				searchRatingList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrRating msr where msr.RatingName like '"+ ratingName +"%' order by msr.RatingName");
			}
			else{
				searchRatingList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrRating msr where msr.RatingCode like '"+ ratingCode+"%' order by msr.RatingCode");}
			}catch (Exception e) {
				e.printStackTrace();
			}
			ratingFieldsMap.put("searchRatingList",searchRatingList);

		
		return ratingFieldsMap;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> showRatingJsp() {

		Map<String,Object>  map=new HashMap<String,Object>();
		List<MstrRating>  searchRatingList=new ArrayList<MstrRating>();
		try {
			searchRatingList =getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrRating");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}  

		map.put("searchRatingList",searchRatingList);
		return map;
	}
	
	
	public boolean editRatingToDatabase(Map<String, Object> generalMap) {
		
		boolean dataUpdated=false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		String ratingName="";
		@SuppressWarnings("unused")
		String ratingCode="";
		int ratingId=0;
		String changedBy = "";
		
		ratingId=(Integer)generalMap.get("id");
		ratingCode=(String)generalMap.get("ratingCode");
		ratingName=(String)generalMap.get("name");
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		MstrRating mstrRating=(MstrRating)getHibernateTemplate().load(MstrRating.class,ratingId);
		
		mstrRating.setId(ratingId);
		mstrRating.setRatingName(ratingName);
		mstrRating.setLastChgBy(changedBy);
		mstrRating.setLastChgDate(currentDate);
		mstrRating.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrRating);
		dataUpdated = true;
		return dataUpdated;
	}
	
	public boolean addRating(MstrRating mstrRating) {
	boolean successfullyAdded=false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_AUTO");
	hbt.setCheckWriteOperations(false);
	hbt.save(mstrRating);
	successfullyAdded = true;
	return successfullyAdded;
	}
	
	
	public boolean deleteRating(int ratingId,Map<String, Object> generalMap) {
		boolean dataDeleted=false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		MstrRating mstrRating = new MstrRating();
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		mstrRating =(MstrRating)getHibernateTemplate().load(MstrRating.class,ratingId);
		  if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  mstrRating.setStatus("n");
				  dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  mstrRating.setStatus("y");
				  dataDeleted=false;
			  }
		  }
		  mstrRating.setLastChgBy(changedBy);
		  mstrRating.setLastChgDate(currentDate);
		  mstrRating.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrRating);
		return dataDeleted;
	}
	
	//------------------------- Department Task Map  -----------------
	
	public Map<String, Object> showDeptTaskMapJsp() {

		Map<String,Object>  map=new HashMap<String,Object>();
		List<MasDepartment>   departmentList = new ArrayList<MasDepartment>();
		List<MstrDeptTaskMap> deptTaskMapList = new ArrayList<MstrDeptTaskMap>();
		List<MstrTask>   mstrTaskList = new ArrayList<MstrTask>();;
		try {
			departmentList  =getHibernateTemplate().find( "from jkt.hms.masters.business.MasDepartment where status = 'y' ");
			deptTaskMapList =getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrDeptTaskMap");
			mstrTaskList    =getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrTask");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}  

		map.put("departmentList",departmentList);
		map.put("deptTaskMapList",deptTaskMapList);
		map.put("mstrTaskList",mstrTaskList);
		return map;
	}
	
	public Map<String, Object> showDeptTaskMapJsp(Integer deptId) {

		Map<String,Object>  map=new HashMap<String,Object>();
		List<MasDepartment>   departmentList = new ArrayList<MasDepartment>();
		List<MstrDeptTaskMap> deptTaskMapList = new ArrayList<MstrDeptTaskMap>();
		List<MstrTask>   mstrTaskList = new ArrayList<MstrTask>();;
		try {
			departmentList  =getHibernateTemplate().find( "from jkt.hms.masters.business.MasDepartment where status = 'y'");
			deptTaskMapList =getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrDeptTaskMap m where m.Status='y' and  m.Department.Id = " + deptId);
			mstrTaskList    =getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrTask");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}  

		map.put("departmentList",departmentList);
		map.put("deptTaskMapList",deptTaskMapList);
		map.put("mstrTaskList",mstrTaskList);
		return map;
	}
	
	public List getDeptTaskMapFromDB(List toBeassignedList)
	{
		Criteria criteria = getSession().createCriteria(MstrTask.class)
										.add(Restrictions.in("Id", toBeassignedList));
		return criteria.list();
	}
	public boolean saveDeptTaskMapDB(MstrDeptTaskMap deptTaskMap) {
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(deptTaskMap);
		hbt.flush();
		hbt.refresh(deptTaskMap);
		successfullyAdded = true;
		return successfullyAdded;
		}
	
	public List getDeptTaskMap(Map map)
	{
		Integer deptId = (Integer)map.get("deptId");
		String status  = (String)map.get("status");
	    List taskList  = (List)map.get("taskList");
		Criteria criteria =  getSession().createCriteria(MstrDeptTaskMap.class)
										 .add(Restrictions.in("Task.Id", taskList))
										 .add(Restrictions.eq("Status", status))
										 .add(Restrictions.eq("Department.Id", deptId));
		return criteria.list();
	}
	
//-------------------------Role-Department Task Map  -----------------
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> showRoleDeptTaskMapJsp() {
		
		Map<String,Object>  map=new HashMap<String,Object>();
		List<MasDepartment>   departmentList = new ArrayList<MasDepartment>();
		List<MstrDeptTaskMap> deptTaskMapList = new ArrayList<MstrDeptTaskMap>();
		List<MstrTask>   mstrTaskList = new ArrayList<MstrTask>();
		List<MasRank>  masRankList   = new ArrayList<MasRank>();
		List<MstrRoleTaskMap> roleTaskMapList = new ArrayList<MstrRoleTaskMap>();
		Session session = (Session)getSession();
		try {
		//	departmentList   = getHibernateTemplate().find("from jkt.hms.masters.business.MasDepartment m where m.Status = 'y' order by md.DepartmentName" );
			
			departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DepartmentName")).list();
			deptTaskMapList  = getHibernateTemplate().find("from jkt.hrms.masters.business.MstrDeptTaskMap m where m.Status = 'y'" );
			mstrTaskList     = getHibernateTemplate().find("from jkt.hrms.masters.business.MstrTask m where m.Status= 'y' " );
			masRankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
			//masRankList      = getHibernateTemplate().find("from jkt.hms.masters.business.MasRank m where m.Status='y'" );
			roleTaskMapList  = getHibernateTemplate().find("from jkt.hrms.masters.business.MstrRoleTaskMap m where m.Status='y'" );
			
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}  
		map.put("departmentList",departmentList);
		map.put("deptTaskMapList",deptTaskMapList);
		map.put("mstrTaskList",mstrTaskList);
		map.put("masRankList",masRankList);
		map.put("roleTaskMapList",roleTaskMapList);
		
		return map;
	}
	public Map<String, Object> showRoleDeptTaskMapJsp(Integer deptId, Integer rankId) {
		
		Map<String,Object>    map=new HashMap<String,Object>();
		List<MasDepartment>   departmentList = new ArrayList<MasDepartment>();
		List<MstrRoleTaskMap> roleTaskMapList = new ArrayList<MstrRoleTaskMap>();
		List<MstrTask>        mstrTaskList = new ArrayList<MstrTask>();
		List<MasRank>         masRankList  = new ArrayList<MasRank>();
		try {
			departmentList      =getHibernateTemplate().find( "from jkt.hms.masters.business.MasDepartment md where md.Status='y' order by md.DepartmentName");
			masRankList         =getHibernateTemplate().find("from jkt.hms.masters.business.MasRank mr where mr.Status='y'" );
			roleTaskMapList     =getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrRoleTaskMap mrt where mrt.Status = 'y' and mrt.Department = "+deptId + " and mrt.Rank = "+rankId );
			mstrTaskList        =getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrTask m where m.Status='y'" );
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}  
		map.put("departmentList",departmentList);
		map.put("roleTaskMapList",roleTaskMapList);
		map.put("mstrTaskList",mstrTaskList);
		map.put("masRankList",masRankList);
		return map;
	}
	public List getRoleDeptTaskMap(Map map)
	{
		Integer deptId = (Integer)map.get("deptId");
		Integer rankId = (Integer)map.get("rankId");
		String status  = (String)map.get("status");
	    List taskList  = (List)map.get("taskList");
		Criteria criteria =  getSession().createCriteria(MstrRoleTaskMap.class)
										 .add(Restrictions.in("Task.Id", taskList))
										 .add(Restrictions.eq("Rank.Id", rankId))
										 .add(Restrictions.eq("Status", status))
										 .add(Restrictions.eq("Department.Id", deptId));
		return criteria.list();
	}
	
	public boolean saveRoleDeptTaskMapDB(MstrRoleTaskMap roleTaskMap) {
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(roleTaskMap);
		hbt.flush();
		hbt.refresh(roleTaskMap);
		successfullyAdded = true;
		return successfullyAdded;
		}
	public List getRoleDeptTaskMapFromDB(List toBeassignedList)
	{
		Criteria criteria = getSession().createCriteria(MstrTask.class)
										.add(Restrictions.in("Id", toBeassignedList));
		return criteria.list();
	}
	//-------------------------Vendor Master  -----------------	
	public Map<String, Object> showVendorJsp() {

		Map<String,Object>  map=new HashMap<String,Object>();
		List<MstrVendor>  searchVendorList=new ArrayList<MstrVendor>();
		List<MstrRating>  mstrRatingList=new ArrayList<MstrRating>();
		List<VendorServiceType>  vendorServiceTypeList = new ArrayList<VendorServiceType>();
		List<MasBankMaster>  masBankMasterList=new ArrayList<MasBankMaster>();
		try {
			searchVendorList =getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrVendor");
			mstrRatingList   =getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrRating   mr where mr.Status = 'y'");
			masBankMasterList=getHibernateTemplate().find( "from jkt.hms.masters.business.MasBankMaster mb where mb.Status = 'y'");
			vendorServiceTypeList=getHibernateTemplate().find( "from jkt.hrms.masters.business.VendorServiceType vendorType where vendorType.Status = 'y'");
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}  
       
		map.put("searchVendorList",searchVendorList);
		map.put("masBankMasterList",masBankMasterList);
		map.put("mstrRatingList",mstrRatingList);
		map.put("vendorServiceTypeList", vendorServiceTypeList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchVendor(String vendorCode, String vendorName)
	{

		List<MstrVendor> searchVendorList = new ArrayList<MstrVendor>();
		
		Map<String,Object>  vandorFieldsMap = new HashMap<String,Object>();
		try{
			if((vendorName!=null) || (vendorCode==null)){
				searchVendorList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrVendor mv where mv.VendorName like '"+ vendorName +"%' order by mv.VendorName");
			}
			else{
				searchVendorList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrVendor mv where mv.VendorCode like '"+ vendorCode+"%' order by mv.VendorCode");}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			vandorFieldsMap.put("searchVendorList",searchVendorList);

		
		return vandorFieldsMap;
	}
	public boolean addVendor(MstrVendor mstrVendor) {
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(mstrVendor);
		hbt.flush();
		hbt.refresh(mstrVendor);
		successfullyAdded = true;
		return successfullyAdded;
	}
	public boolean editVendorToDatabase(Map<String, Object> generalMap) {
		
		boolean dataUpdated=false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		Integer vendorId = 0;
		String vendorCode="";
		String vendorName="";
		String VendorAddress = "";
		String contactNo = "";
		String faxNo = "";
		String emailId  = "";
		String webSite = "";
		String custServNo = "";
		int vendorService = 0;
		String vendorPanNo = "";
		Integer vendorbank = 0;
		String vendorBranch = "";
		String accountNo = "";
		String previousAssociate = "";
		Integer ratingId =0;
		String comments = "";
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
//		String taskName="";
//		int taskTypeId = 0;
//		int budgetsubHeadingId = 0;
//		@SuppressWarnings("unused")
//		String taskCode="";
//		int taskId=0;
		
		vendorId      = (Integer)generalMap.get("vendorId");
		vendorCode    = (String)generalMap.get("vendorCode");
		vendorName    = (String)generalMap.get("vendorName");
		VendorAddress = (String)generalMap.get("VendorAddress");
		contactNo     = (String)generalMap.get("contactNo");
		if(generalMap.get("faxNo")!= ""){
			faxNo         = (String)generalMap.get("faxNo");
		}
		if(generalMap.get("emailId")!= null){
			emailId = (String)generalMap.get("emailId");
		}
		if(generalMap.get("webSite")!= null){
			webSite 	  = (String)generalMap.get("webSite");
		}
		
		custServNo 	  = (String)generalMap.get("custServNo");
		vendorPanNo   = (String)generalMap.get("vendorPanNo");
		if(generalMap.get("vendorService") != null){
			vendorService = (Integer)generalMap.get("vendorService");
		}
		
		vendorBranch  = (String)generalMap.get("vendorBranch");
		accountNo     = (String)generalMap.get("accountNo");
		previousAssociate = (String)generalMap.get("previousAssociate");
		
		comments      = (String)generalMap.get("comments");
		changedBy     = (String)generalMap.get("changedBy");
		currentDate   = (Date)generalMap.get("currentDate");
		currentTime   = (String)generalMap.get("currentTime");
		
		
		MstrVendor mstrVendor = (MstrVendor)getHibernateTemplate().load(MstrVendor.class, vendorId);
		
		
		
		if(generalMap.get("vendorbank") != null){
			vendorbank    = (Integer)generalMap.get("vendorbank");
			MasBankMaster masBankMaster = new MasBankMaster();
			masBankMaster.setId(vendorbank);
			mstrVendor.setBank(masBankMaster);
		}
		if(generalMap.get("ratingId") != null){
			ratingId      = (Integer)generalMap.get("ratingId");
			MstrRating mstrRating = new MstrRating();
			mstrRating.setId(ratingId);
			mstrVendor.setRating(mstrRating);
		}
		mstrVendor.setVendorCode(vendorCode);
		mstrVendor.setVendorName(vendorName);
		mstrVendor.setVendorAddress(VendorAddress);
		mstrVendor.setVendorContactNo(contactNo);
		mstrVendor.setVendorFaxNo(faxNo);
		mstrVendor.setVendorEmailId(emailId);
		mstrVendor.setVendorWebSite(webSite);
		mstrVendor.setVendorCustServNo(custServNo);
		VendorServiceType vendorServiceType = new VendorServiceType();
		vendorServiceType.setId(vendorService);
		mstrVendor.setVendorService(vendorServiceType);
		mstrVendor.setVendorPanNo(vendorPanNo);
		
		mstrVendor.setVendorBranch(vendorBranch);
		mstrVendor.setVendorAccNo(accountNo);
		mstrVendor.setPereviousAssociate(previousAssociate);
		
		mstrVendor.setComments(comments);
		mstrVendor.setStatus("y");
		mstrVendor.setLastChgBy(changedBy);
		mstrVendor.setLastChgDate(currentDate);
		mstrVendor.setLastChgTime(currentTime);
			
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrVendor);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteVendor(int vendorId,Map<String, Object> generalMap) {
		boolean dataDeleted=false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		MstrVendor mstrVendor = new MstrVendor();
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		mstrVendor =(MstrVendor)getHibernateTemplate().load(MstrVendor.class,vendorId);
		  if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  mstrVendor.setStatus("n");
				  dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  mstrVendor.setStatus("y");
				  dataDeleted=false;
			  }
		  }
		  mstrVendor.setLastChgBy(changedBy);
		  mstrVendor.setLastChgDate(currentDate);
		  mstrVendor.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrVendor);
		return dataDeleted;
	}
	
	//-------------------------PI Master  -----------------	
	public Map<String, Object> showPiJsp() {

		Map<String,Object>  map=new HashMap<String,Object>();
		List<MstrPiHeader>  searchPiList=new ArrayList<MstrPiHeader>();
		List<MstrRating>  mstrRatingList=new ArrayList<MstrRating>();
		List<MasBankMaster>  masBankMasterList=new ArrayList<MasBankMaster>();
		List<MstrTherapeutic> mstrTherapeuticList = new ArrayList<MstrTherapeutic>();
		List<MstrSiteHeader> mstrSiteHeaderList = new ArrayList<MstrSiteHeader>();
		try {
			searchPiList =getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrPiHeader");
			mstrRatingList   =getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrRating   mr where mr.Status = 'y'");
			masBankMasterList=getHibernateTemplate().find( "from jkt.hms.masters.business.MasBankMaster mb where mb.Status = 'y'");
			mstrTherapeuticList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrTherapeutic mt where mt.Status = 'y'");
			mstrSiteHeaderList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrSiteHeader msh where msh.Status = 'y'");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}  
       
		map.put("searchPiList",searchPiList);
		map.put("mstrRatingList",mstrRatingList);
		map.put("masBankMasterList", masBankMasterList);
		map.put("mstrTherapeuticList",mstrTherapeuticList);
		map.put("mstrSiteHeaderList",mstrSiteHeaderList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchPi(String piCode, String piName)
	{

		List<MstrPiHeader> searchPiList = new ArrayList<MstrPiHeader>();
		
		Map<String,Object>  ipFieldsMap = new HashMap<String,Object>();
		try{
			if((piName!=null) || (piCode==null)){
				searchPiList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrPiHeader mph where mph.PiName like '"+ piName +"%' order by mph.PiName");
			}
			else{
				searchPiList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrPiHeader mph where mph.PiCode like '"+ piCode+"%' order by mph.PiCode");}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			ipFieldsMap.put("searchPiList",searchPiList);

		
		return ipFieldsMap;
	}
	
	public boolean addPi(Map<String, Object> newMap) {
		MstrPiHeader mstrPiHeader = new MstrPiHeader();
		MstrPiHeader newMstrPiHeader = new MstrPiHeader();
		//MstrS
		boolean successfullyAdded=false;
		org.hibernate.Session session=getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		List<MstrPiDetail>mstrPiDetail=new ArrayList<MstrPiDetail>();
		
		String[] arr = {"0"};
		String[] arr1 = {"0"};
		hbt.setCheckWriteOperations(false);
		if(newMap.get("mstrPiHeader")!=null){
			mstrPiHeader =(MstrPiHeader)newMap.get("mstrPiHeader");
		}
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.save(mstrPiHeader);
		hbt.flush();
		hbt.refresh(mstrPiHeader);
		Criteria c=session.createCriteria(MstrPiHeader.class).addOrder(Order.desc("Id"));
		c.setFirstResult(0);
		c.setMaxResults(1);
		List<MstrPiHeader>mstrPiHeaderList=c.list();
		if(mstrPiHeaderList!=null&&mstrPiHeaderList.size()>0)
		{
			newMstrPiHeader=mstrPiHeaderList.get(0);
		}
		
		
		if(newMap.get("toBeAssignedIdsList")!=null){
			arr=(String[])newMap.get("toBeAssignedIdsList");
		if(arr.length!=0){
			for(int cnt=0;cnt<arr.length;cnt++){
				MstrPiDetail mstrPiDetail1=new MstrPiDetail();
				mstrPiDetail1.setPiHeader(new MstrPiHeader(newMstrPiHeader.getId()));
				mstrPiDetail1.setThp(new MstrTherapeutic((Integer.parseInt(arr[cnt]))));
			//	mstrPiDetail1.setSiteHeader(new MstrSiteHeader((Integer.parseInt(arr1[cnt]))));
				hbt.save(mstrPiDetail1);
			}
		}}
		if(newMap.get("toBeAssignedSiteList")!=null){
			arr1 =(String[])newMap.get("toBeAssignedSiteList");
		if(arr1.length!=0){
			for(int cnt=0;cnt<arr1.length;cnt++){
				MstrPiDetail mstrPiDetail2=new MstrPiDetail();
				mstrPiDetail2.setPiHeader(new MstrPiHeader(newMstrPiHeader.getId()));
				//mstrPiDetail2.setThp(new MstrTherapeutic((Integer.parseInt(arr[cnt]))));
				mstrPiDetail2.setSiteHeader(new MstrSiteHeader((Integer.parseInt(arr1[cnt]))));
				hbt.save(mstrPiDetail2);
			}
		}}
		successfullyAdded = true;
		return successfullyAdded;
	}
	
public boolean editPiToDatabase(Map<String, Object> generalMap) {
	org.hibernate.Session session=getSession();
		boolean dataUpdated=false;
		Date currentDate = new Date();
		String  currentTime = null;
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		Integer piId     = 0;
		String  piCode    = null;
		String  piName    = null;
		String  address   = null;
		String  contactNo = null;
		String  mobileNo  = null;
		String  emailId   = null;
		String  faxNo     = null;
		String  medRegNo  = null;
		String  panNo     = null;
		
		String  branch    = null;
		String  previousAssociate = null;
		String  accountNo = null;
		
		String  comments = null;
		String  designation = null;
		String  changedBy = null;
		String  thpId = null;
		String  siteId = null;
		int     hospitalId = 0;
		String[] arr = {"0"};
		String[] arr1 = {"0"};
		
		
		piId      = (Integer)generalMap.get("piId");
		piCode    = (String)generalMap.get("piCode");
		piName    = (String)generalMap.get("piName");
		address   = (String)generalMap.get("address");
		contactNo     = (String)generalMap.get("contactNo");
		mobileNo      = (String)generalMap.get("mobileNo");
		emailId 	  = (String)generalMap.get("emailId");
		faxNo         = (String)generalMap.get("faxNo");
		medRegNo 	  = (String)generalMap.get("medRegNo");
		panNo         = (String)generalMap.get("panNo");
		
		branch        = (String)generalMap.get("branch");
		accountNo     = (String)generalMap.get("accountNo");
		previousAssociate = (String)generalMap.get("previousAssociate");
		
		comments      = (String)generalMap.get("comments");
		designation   = (String)generalMap.get("designation");
		changedBy     = (String)generalMap.get("changedBy");
		currentDate   = (Date)generalMap.get("currentDate");
		currentTime   = (String)generalMap.get("currentTime");
		
		
		MstrPiHeader mstrPiHeader = (MstrPiHeader)getHibernateTemplate().load(MstrPiHeader.class, piId);
		if(generalMap.get("piBank")!= null){
			int piBank  = (Integer)generalMap.get("piBank");
			MasBankMaster masBankMaster = new MasBankMaster();
			masBankMaster.setId(piBank);
			mstrPiHeader.setBank(masBankMaster);
		}
		if(generalMap.get("ratingId")!= null){
			int ratingId = ratingId = (Integer)generalMap.get("ratingId");
			MstrRating mstrRating = new MstrRating();
			mstrRating.setId(ratingId);
			mstrPiHeader.setRating(mstrRating);
		}
		mstrPiHeader.setPiCode(piCode);
		mstrPiHeader.setPiName(piName);
		mstrPiHeader.setPiAddress(address);
		mstrPiHeader.setPiContactNo(contactNo);
		mstrPiHeader.setPiMobileNo(mobileNo);
		mstrPiHeader.setPiEmailId(emailId);
		mstrPiHeader.setPiFaxNo(faxNo);
     	mstrPiHeader.setPiMedRegNo(medRegNo);
		mstrPiHeader.setPiPanNo(panNo);
		mstrPiHeader.setPiBranch(branch);
		mstrPiHeader.setPiPreviousAssociation(previousAssociate);
		mstrPiHeader.setPiAccNo(accountNo);
		mstrPiHeader.setComments(comments);
		mstrPiHeader.setDesignation(designation);
		mstrPiHeader.setStatus("y");
		mstrPiHeader.setLastChgBy(changedBy);
		mstrPiHeader.setLastChgDate(currentDate);
		mstrPiHeader.setLastChgTime(currentTime);
			
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrPiHeader);
		
		List<MstrPiDetail> mstrPiDetaiList = new ArrayList<MstrPiDetail>();
		mstrPiDetaiList =getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrPiDetail mpd where mpd.PiHeader.Id = "+piId);
		if(mstrPiDetaiList.size()>0){
			hbt.deleteAll(mstrPiDetaiList);
		}
		
		if(generalMap.get("toBeAssignedIdsList")!=null){
			arr=(String[])generalMap.get("toBeAssignedIdsList");
		if(arr.length!=0){
			for(int cnt=0;cnt<arr.length;cnt++){
				MstrPiDetail mstrPiDetail1=new MstrPiDetail();
				MstrPiHeader newMstrPiHeader = new MstrPiHeader();
				newMstrPiHeader.setId(piId);
				mstrPiDetail1.setPiHeader(new MstrPiHeader(newMstrPiHeader.getId()));
				mstrPiDetail1.setThp(new MstrTherapeutic((Integer.parseInt(arr[cnt]))));
				hbt.save(mstrPiDetail1);
			}
		 }
		}
		if(generalMap.get("toBeAssignedSiteList")!=null){
			arr1 =(String[])generalMap.get("toBeAssignedSiteList");
		if(arr1.length!=0){
			for(int cnt=0;cnt<arr1.length;cnt++){
				MstrPiDetail mstrPiDetail2=new MstrPiDetail();
				MstrPiHeader newMstrPiHeader = new MstrPiHeader();
				newMstrPiHeader.setId(piId);
				mstrPiDetail2.setPiHeader(new MstrPiHeader(newMstrPiHeader.getId()));
				mstrPiDetail2.setSiteHeader(new MstrSiteHeader((Integer.parseInt(arr1[cnt]))));
				hbt.save(mstrPiDetail2);
			}
		}
		}
		
		dataUpdated = true;
		return dataUpdated;
	}

public boolean deletePi(int piId,Map<String, Object> generalMap) {
	boolean dataDeleted=false;
	String changedBy = "";
	Date currentDate = new Date();
	String currentTime = "";
	currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	MstrPiHeader mstrPiHeader = new MstrPiHeader();
	changedBy = (String)generalMap.get("changedBy");
	currentDate=(Date)generalMap.get("currentDate");
	currentTime=(String)generalMap.get("currentTime");
	mstrPiHeader =(MstrPiHeader)getHibernateTemplate().load(MstrPiHeader.class,piId);
	  if(generalMap.get("flag") != null){
		  String flag = (String)generalMap.get("flag");
		  if (flag.equals("InActivate")){
			  mstrPiHeader.setStatus("n");
			  dataDeleted=true;
		  }else if(flag.equals("Activate")){
			  mstrPiHeader.setStatus("y");
			  dataDeleted=false;
		  }
	  }
	  mstrPiHeader.setLastChgBy(changedBy);
	  mstrPiHeader.setLastChgDate(currentDate);
	  mstrPiHeader.setLastChgTime(currentTime);
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(mstrPiHeader);
	return dataDeleted;
}

//-------------------------Site Master  -----------------	
public Map<String, Object> showSiteJsp() {

	Map<String,Object>   map=new HashMap<String,Object>();
	List<MstrSiteHeader>   searchSiteList=new ArrayList<MstrSiteHeader>();
	List<MstrRating>     mstrRatingList=new ArrayList<MstrRating>();
	List<MasBankMaster>  masBankMasterList=new ArrayList<MasBankMaster>();
	List<MstrTherapeutic> mstrTherapeuticList = new ArrayList<MstrTherapeutic>();
	
	try {
		searchSiteList =getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrSiteHeader");
		mstrRatingList   =getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrRating   mr where mr.Status = 'y'");
		masBankMasterList=getHibernateTemplate().find( "from jkt.hms.masters.business.MasBankMaster mb where mb.Status = 'y'");
		mstrTherapeuticList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrTherapeutic mt where mt.Status = 'y'");
	} catch (DataAccessException e) {
		e.printStackTrace();
	}  
   
	map.put("searchSiteList",searchSiteList);
	map.put("mstrRatingList",mstrRatingList);
	map.put("masBankMasterList", masBankMasterList);
	map.put("mstrTherapeuticList", mstrTherapeuticList);
	return map;
}
	
@SuppressWarnings("unchecked")
public Map<String, Object> searchSite(String siteCode, String siteName)
{

	List<MstrSiteHeader> searchSiteList = new ArrayList<MstrSiteHeader>();
	
	Map<String,Object>  siteFieldsMap = new HashMap<String,Object>();
	try{
		if((siteName!=null) || (siteCode==null)){
			searchSiteList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrSiteHeader msh where msh.SiteName like '"+ siteName +"%' order by msh.SiteName");
		}
		else{
			searchSiteList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrSiteHeader msh where msh.SiteCode like '"+ siteCode+"%' order by msh.SiteCode");}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		siteFieldsMap.put("searchSiteList",searchSiteList);

	
	return siteFieldsMap;
}

public boolean addSite(Map<String, Object> newMap) {
	MstrSiteHeader mstrSiteHeader = new MstrSiteHeader();
	MstrSiteHeader newMstrSiteHeader = new MstrSiteHeader();
	
	boolean successfullyAdded=false;
	org.hibernate.Session session=getSession();
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	List<MstrSiteDetail>mstrSiteDetaiList = new ArrayList<MstrSiteDetail>();
	
	String[] arr = {"0"};
	
	hbt.setCheckWriteOperations(false);
	if(newMap.get("mstrSiteHeader")!=null){
		mstrSiteHeader =(MstrSiteHeader)newMap.get("mstrSiteHeader");
	}
	hbt.setFlushModeName("FLUSH_AUTO");
	hbt.save(mstrSiteHeader);
	hbt.flush();
	hbt.refresh(mstrSiteHeader);
	Criteria c=session.createCriteria(MstrSiteHeader.class).addOrder(Order.desc("Id"));
	c.setFirstResult(0);
	c.setMaxResults(1);
	List<MstrSiteHeader>mstrSiteHeaderList=c.list();
	if(mstrSiteHeaderList!=null&&mstrSiteHeaderList.size()>0)
	{
		newMstrSiteHeader=mstrSiteHeaderList.get(0);
	}
	
	if(newMap.get("toBeAssignedThpList")!=null){
		arr=(String[])newMap.get("toBeAssignedThpList");
	}
	if(arr.length!=0){
		for(int cnt=0;cnt<arr.length;cnt++){
			MstrSiteDetail mstrSiteDetail1=new MstrSiteDetail();
			mstrSiteDetail1.setSiteHeader(new MstrSiteHeader(newMstrSiteHeader.getId()));
			mstrSiteDetail1.setThp(new MstrTherapeutic((Integer.parseInt(arr[cnt]))));
			mstrSiteDetail1.setStatus("y");
			hbt.save(mstrSiteDetail1);
		}
	}
	
	successfullyAdded = true;
	return successfullyAdded;
}

public boolean editSiteToDatabase(Map<String, Object> generalMap) {
	org.hibernate.Session session=getSession();
		boolean dataUpdated=false;
		Date    currentDate = new Date();
		String  currentTime = null;
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		
		Integer siteId     =0;
		String  siteCode   = null;
		String  siteName   = null;
		String address     = null;
		String accountNo   = null;
		String contactNo   = null;
		String faxNo       = null;
		String emailId     = null;
		String webSite     = null;
		String previousAssociate = null;
		
		String panNo       = null;
		Integer bankId     = 0;
		String branch      = null;
		String ecName      = null;
		String ecConvName  = null;
		String ecContactNo = null;
		String ecEmailId   = null;
		String ecFaxNo     = null;
		Integer ecBankId   = 0;
		String ecBranch    = null;
		String ecAccountNo = null;
		String ecPanNo     = null;
		String comments    = null;
		String changedBy   = null;
		Date   changedDate   = new Date();
		String changedTime  = null;
		String thpId       = null;
		int hospitalId     = 0;
		String[] arr = {"0"};
	
		
		
		siteId          = (Integer)generalMap.get("siteId");
		siteCode        = (String)generalMap.get("siteCode");
		siteName        = (String)generalMap.get("siteName");
		address         = (String)generalMap.get("address");
		accountNo       = (String)generalMap.get("accountNo");
		contactNo       = (String)generalMap.get("contactNo");
		faxNo           = (String)generalMap.get("faxNo");
		emailId 	    = (String)generalMap.get("emailId");
		webSite 	    = (String)generalMap.get("webSite");
		previousAssociate = (String)generalMap.get("previousAssociate");
		
		panNo           = (String)generalMap.get("panNo");
		
		branch          = (String)generalMap.get("branch");
		ecName          = (String)generalMap.get("ecName");
		ecConvName        = (String)generalMap.get("ecConvName");
		ecContactNo       = (String)generalMap.get("ecContactNo");
		ecEmailId 	    = (String)generalMap.get("ecEmailId");
		ecFaxNo           = (String)generalMap.get("ecFaxNo");
		
		ecBranch          = (String)generalMap.get("ecBranch");
		ecAccountNo       = (String)generalMap.get("ecAccountNo");
		ecPanNo           = (String)generalMap.get("ecPanNo");
		comments      = (String)generalMap.get("comments");
		changedBy     = (String)generalMap.get("changedBy");
		currentDate   = (Date)generalMap.get("currentDate");
		currentTime   = (String)generalMap.get("currentTime");
		
	
		MstrSiteHeader mstrSiteHeader = (MstrSiteHeader)getHibernateTemplate().load(MstrSiteHeader.class, siteId);
		if(generalMap.get("bankId")!= null){
			bankId = (Integer)generalMap.get("bankId");
			MasBankMaster masBankMaster = new MasBankMaster();
			masBankMaster.setId(bankId);
			mstrSiteHeader.setBank(masBankMaster);
		}
		if(generalMap.get("ratingId")!= null){
			int ratingId = (Integer)generalMap.get("ratingId");
			MstrRating mstrRating = new MstrRating();
			mstrRating.setId(ratingId);
			mstrSiteHeader.setRating(mstrRating);
		}
		if(generalMap.get("ecBankId")!= null){
			ecBankId = (Integer)generalMap.get("ecBankId");
			MasBankMaster ecMasBankMaster = new MasBankMaster();
			ecMasBankMaster.setId(ecBankId);
			mstrSiteHeader.setEcBank(ecMasBankMaster);
		}
		mstrSiteHeader.setSiteName(siteName);
		mstrSiteHeader.setSiteAddress(address);
		mstrSiteHeader.setSiteAccountNo(accountNo);
		mstrSiteHeader.setSiteContactNo(contactNo);
		mstrSiteHeader.setSiteFaxNo(faxNo);
		mstrSiteHeader.setSiteEmailId(emailId);
		mstrSiteHeader.setSiteWebsite(webSite);
		mstrSiteHeader.setPereviousAssociate(previousAssociate);
		mstrSiteHeader.setSitePanNo(panNo);
		mstrSiteHeader.setSiteBranch(branch);
		mstrSiteHeader.setEcName(ecName);
		mstrSiteHeader.setEcConvrName(ecConvName);
		mstrSiteHeader.setEcContactNo(ecContactNo);
		mstrSiteHeader.setEcEmailId(ecEmailId);
		mstrSiteHeader.setEcFaxNo(ecFaxNo);
		mstrSiteHeader.setEcBranch(ecBranch);
		mstrSiteHeader.setEcAcNo(ecAccountNo);
		mstrSiteHeader.setEcPanNo(ecPanNo);
		mstrSiteHeader.setComments(comments);
		mstrSiteHeader.setStatus("y");
		mstrSiteHeader.setLastChgBy(changedBy);
		mstrSiteHeader.setLastChgDate(currentDate);
		mstrSiteHeader.setLastChgTime(currentTime);
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrSiteHeader);
		
		List<MstrSiteDetail> mstrSiteDetaiList = new ArrayList<MstrSiteDetail>();
		mstrSiteDetaiList =getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrSiteDetail msd where msd.SiteHeader.Id = "+siteId);
		if(mstrSiteDetaiList != null){
			hbt.deleteAll(mstrSiteDetaiList);
		}
		
		if(generalMap.get("toBeAssignedThpList")!=null){
			arr=(String[])generalMap.get("toBeAssignedThpList");
		}
		
		
		if(arr.length!=0){
			for(int cnt=0;cnt<arr.length;cnt++){
				MstrSiteDetail mstrSiteDetail1=new MstrSiteDetail();
				MstrSiteHeader newMstrSiteHeader = new MstrSiteHeader();
				newMstrSiteHeader.setId(siteId);
				mstrSiteDetail1.setSiteHeader(new MstrSiteHeader(newMstrSiteHeader.getId()));
				mstrSiteDetail1.setThp(new MstrTherapeutic((Integer.parseInt(arr[cnt]))));
				mstrSiteDetail1.setStatus("y");
				hbt.save(mstrSiteDetail1);
			}
		}
		
		dataUpdated = true;
		return dataUpdated;
	}

public boolean deleteSite(int siteId,Map<String, Object> generalMap) {
	boolean dataDeleted=false;
	String changedBy = "";
	Date currentDate = new Date();
	String currentTime = "";
	currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	MstrSiteHeader mstrSiteHeader = new MstrSiteHeader();
	changedBy = (String)generalMap.get("changedBy");
	currentDate=(Date)generalMap.get("currentDate");
	currentTime=(String)generalMap.get("currentTime");
	mstrSiteHeader =(MstrSiteHeader)getHibernateTemplate().load(MstrSiteHeader.class,siteId);
	  if(generalMap.get("flag") != null){
		  String flag = (String)generalMap.get("flag");
		  if (flag.equals("InActivate")){
			  mstrSiteHeader.setStatus("n");
			  dataDeleted=true;
		  }else if(flag.equals("Activate")){
			  mstrSiteHeader.setStatus("y");
			  dataDeleted=false;
		  }
	  }
	  mstrSiteHeader.setLastChgBy(changedBy);
	  mstrSiteHeader.setLastChgDate(currentDate);
	  mstrSiteHeader.setLastChgTime(currentTime);
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(mstrSiteHeader);
	return dataDeleted;
}

//=================Calendar Master======================

@SuppressWarnings("unchecked")
public Map<String, Object> searchCalendar(String calendarCode, String calendarName) 
{
	List<MstrCalendar> searchCalendarList = new ArrayList<MstrCalendar>();
	
	Map<String,Object>  calendarFieldsMap = new HashMap<String,Object>();
	try{
		if((calendarName!=null) || (calendarCode==null)){
			searchCalendarList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrCalendar mc where mc.CalendarName like '"+ calendarName +"%' order by mc.CalendarName");
		}
		else{
			searchCalendarList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrCalendar mc where mc.CalendarCode like '"+ calendarCode+"%' order by mc.CalendarCode");}
		}catch (Exception e) {
			e.printStackTrace();
		}
		calendarFieldsMap.put("searchCalendarList",searchCalendarList);

	
	return calendarFieldsMap;
}

@SuppressWarnings("unchecked")

public Map<String, Object> showCalendarJsp() {
	
	Map<String,Object>  map=new HashMap<String,Object>();
	List<MstrTaskType>  searchCalendarList=new ArrayList<MstrTaskType>();
	try {
		searchCalendarList=getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrCalendar");
	} catch (DataAccessException e) {
		e.printStackTrace();
	}  
	map.put("searchCalendarList",searchCalendarList);
	return map;
}

public boolean addCalendar(MstrCalendar mstrCalendar) {
	boolean successfullyAdded=false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_AUTO");
	hbt.setCheckWriteOperations(false);
	hbt.save(mstrCalendar);
	successfullyAdded = true;
	return successfullyAdded;
}

public boolean editCalendarToDatabase(Map<String, Object> generalMap) {
	
	boolean dataUpdated=false;
	Date currentDate = new Date();
	String currentTime = "";
	currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	String calendarName="";
	@SuppressWarnings("unused")
	String calendarCode="";
	int calendarId=0;
	String changedBy = "";
	
	calendarId=(Integer)generalMap.get("id");
	calendarCode=(String)generalMap.get("calendarCode");
	calendarName=(String)generalMap.get("name");
	changedBy = (String)generalMap.get("changedBy");
	currentDate=(Date)generalMap.get("currentDate");
	currentTime=(String)generalMap.get("currentTime");
	MstrCalendar mstrCalendar=(MstrCalendar)getHibernateTemplate().load(MstrCalendar.class,calendarId);
	
	mstrCalendar.setId(calendarId);
	mstrCalendar.setCalendarName(calendarName);
	mstrCalendar.setLastChgBy(changedBy);
	mstrCalendar.setLastChgDate(currentDate);
	mstrCalendar.setLastChgTime(currentTime);
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(mstrCalendar);
	dataUpdated = true;
	return dataUpdated;
}
public boolean deleteCalendar(int calendarId,Map<String, Object> generalMap) {
	boolean dataDeleted=false;
	String changedBy = "";
	Date currentDate = new Date();
	String currentTime = "";
	currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	MstrCalendar mstrCalendar = new MstrCalendar();
	changedBy = (String)generalMap.get("changedBy");
	currentDate=(Date)generalMap.get("currentDate");
	currentTime=(String)generalMap.get("currentTime");
	mstrCalendar =(MstrCalendar)getHibernateTemplate().load(MstrCalendar.class,calendarId);
	  if(generalMap.get("flag") != null){
		  String flag = (String)generalMap.get("flag");
		  if (flag.equals("InActivate")){
			  mstrCalendar.setStatus("n");
			  dataDeleted=true;
		  }else if(flag.equals("Activate")){
			  mstrCalendar.setStatus("y");
			  dataDeleted=false;
		  }
	  }
	  mstrCalendar.setLastChgBy(changedBy);
	  mstrCalendar.setLastChgDate(currentDate);
	  mstrCalendar.setLastChgTime(currentTime);
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(mstrCalendar);
	return dataDeleted;
}

//=================Calendar Master======================

@SuppressWarnings("unchecked")
public Map<String, Object> searchProjectStatus(String projectStatusCode, String projectStatusName) 
{
	List<MstrProjectStatus> searchProjectStatusList = new ArrayList<MstrProjectStatus>();
	
	Map<String,Object>  calendarFieldsMap = new HashMap<String,Object>();
	try{
		if((projectStatusName!=null) || (projectStatusCode==null)){
			searchProjectStatusList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrProjectStatus mps where mps.PrjsName like '"+ projectStatusName +"%' order by mps.PrjsName");
		}
		else{
			searchProjectStatusList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrProjectStatus mps where mps.PrjsCode like '"+ projectStatusCode+"%' order by mps.PrjsCode");}
		}catch (Exception e) {
			e.printStackTrace();
		}
		calendarFieldsMap.put("searchProjectStatusList",searchProjectStatusList);

	
	return calendarFieldsMap;
}

@SuppressWarnings("unchecked")

public Map<String, Object> showProjectStatusJsp() {
	
	Map<String,Object>  map=new HashMap<String,Object>();
	List<MstrProjectStatus>  searchProjectStatusList=new ArrayList<MstrProjectStatus>();
	try {
		searchProjectStatusList=getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrProjectStatus");
	} catch (DataAccessException e) {
		e.printStackTrace();
	}  
	map.put("searchProjectStatusList",searchProjectStatusList);
	return map;
}

public boolean addProjectStatus(MstrProjectStatus mstrProjectStatus) {
	boolean successfullyAdded=false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_AUTO");
	hbt.setCheckWriteOperations(false);
	hbt.save(mstrProjectStatus);
	successfullyAdded = true;
	return successfullyAdded;
}

public boolean editProjectStatusToDatabase(Map<String, Object> generalMap) {
	
	boolean dataUpdated=false;
	Date currentDate = new Date();
	String currentTime = "";
	currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	String projectStatusName="";
	@SuppressWarnings("unused")
	String projectStatusCode="";
	int projectStatusId=0;
	String changedBy = "";
	
	projectStatusId=(Integer)generalMap.get("id");
	projectStatusCode=(String)generalMap.get("projectStatusCode");
	projectStatusName=(String)generalMap.get("name");
	changedBy = (String)generalMap.get("changedBy");
	currentDate=(Date)generalMap.get("currentDate");
	currentTime=(String)generalMap.get("currentTime");
	MstrProjectStatus mstrProjectStatus=(MstrProjectStatus)getHibernateTemplate().load(MstrProjectStatus.class,projectStatusId);
	
	mstrProjectStatus.setId(projectStatusId);
	mstrProjectStatus.setPrjsName(projectStatusName);
	mstrProjectStatus.setLastChgBy(changedBy);
	mstrProjectStatus.setLastChgDate(currentDate);
	mstrProjectStatus.setLastChgTime(currentTime);
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(mstrProjectStatus);
	dataUpdated = true;
	return dataUpdated;
}
public boolean deleteProjectStatus(int projectStatusId,Map<String, Object> generalMap) {
	boolean dataDeleted=false;
	String changedBy = "";
	Date currentDate = new Date();
	String currentTime = "";
	currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	MstrProjectStatus mstrProjectStatus = new MstrProjectStatus();
	changedBy = (String)generalMap.get("changedBy");
	currentDate=(Date)generalMap.get("currentDate");
	currentTime=(String)generalMap.get("currentTime");
	mstrProjectStatus =(MstrProjectStatus)getHibernateTemplate().load(MstrProjectStatus.class,projectStatusId);
	  if(generalMap.get("flag") != null){
		  String flag = (String)generalMap.get("flag");
		  if (flag.equals("InActivate")){
			  mstrProjectStatus.setStatus("n");
			  dataDeleted=true;
		  }else if(flag.equals("Activate")){
			  mstrProjectStatus.setStatus("y");
			  dataDeleted=false;
		  }
	  }
	  mstrProjectStatus.setLastChgBy(changedBy);
	  mstrProjectStatus.setLastChgDate(currentDate);
	  mstrProjectStatus.setLastChgTime(currentTime);
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(mstrProjectStatus);
	return dataDeleted;
}

//=================Vendor Service Type Master======================

@SuppressWarnings("unchecked")
public Map<String, Object> searchVendorServiceType(String vendorServiceTypeCode, String vendorServiceTypeName) 
{
	List<VendorServiceType> searchVendorServiceTypeList = new ArrayList<VendorServiceType>();
	
	Map<String,Object>  calendarFieldsMap = new HashMap<String,Object>();
	try{
		if((vendorServiceTypeName!=null) || (vendorServiceTypeCode==null)){
			searchVendorServiceTypeList=getHibernateTemplate().find("from jkt.hrms.masters.business.VendorServiceType vst where vst.VendorServiceName like '"+ vendorServiceTypeName +"%' order by vst.VendorServiceName");
		}
		else{
			searchVendorServiceTypeList=getHibernateTemplate().find("from jkt.hrms.masters.business.VendorServiceType vst where vst.VendorServiceCode like '"+ vendorServiceTypeCode+"%' order by vst.VendorServiceCode");}
		}catch (Exception e) {
			e.printStackTrace();
		}
		calendarFieldsMap.put("searchVendorServiceTypeList",searchVendorServiceTypeList);

	
	return calendarFieldsMap;
}

@SuppressWarnings("unchecked")

public Map<String, Object> showVendorServiceTypeJsp() {
	
	Map<String,Object>  map=new HashMap<String,Object>();
	List<VendorServiceType>  searchVendorServiceTypeList=new ArrayList<VendorServiceType>();
	try {
		searchVendorServiceTypeList=getHibernateTemplate().find( "from jkt.hrms.masters.business.VendorServiceType");
	} catch (DataAccessException e) {
		e.printStackTrace();
	}  
	map.put("searchVendorServiceTypeList",searchVendorServiceTypeList);
	return map;
}

public boolean addVendorServiceType(VendorServiceType vendorServiceType) {
	boolean successfullyAdded=false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_AUTO");
	hbt.setCheckWriteOperations(false);
	hbt.save(vendorServiceType);
	successfullyAdded = true;
	return successfullyAdded;
}

public boolean editVendorServiceTypeToDatabase(Map<String, Object> generalMap) {
	
	boolean dataUpdated=false;
	Date currentDate = new Date();
	String currentTime = "";
	currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	String vendorServiceTypeName="";
	@SuppressWarnings("unused")
	String vendorServiceTypeCode="";
	int vendorServiceTypeId=0;
	String changedBy = "";
	
	vendorServiceTypeId=(Integer)generalMap.get("id");
	vendorServiceTypeCode=(String)generalMap.get("vendorServiceTypeCode");
	vendorServiceTypeName=(String)generalMap.get("name");
	changedBy = (String)generalMap.get("changedBy");
	currentDate=(Date)generalMap.get("currentDate");
	currentTime=(String)generalMap.get("currentTime");
	VendorServiceType vendorServiceType=(VendorServiceType)getHibernateTemplate().load(VendorServiceType.class,vendorServiceTypeId);
	
	vendorServiceType.setId(vendorServiceTypeId);
	vendorServiceType.setVendorServiceName(vendorServiceTypeName);
	vendorServiceType.setLastChgBy(changedBy);
	vendorServiceType.setLastChgDate(currentDate);
	vendorServiceType.setLastChgTime(currentTime);
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(vendorServiceType);
	dataUpdated = true;
	return dataUpdated;
}
public boolean deleteVendorServiceType(int vendorServiceTypeId,Map<String, Object> generalMap) {
	boolean dataDeleted=false;
	String changedBy = "";
	Date currentDate = new Date();
	String currentTime = "";
	currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	VendorServiceType vendorServiceType = new VendorServiceType();
	changedBy = (String)generalMap.get("changedBy");
	currentDate=(Date)generalMap.get("currentDate");
	currentTime=(String)generalMap.get("currentTime");
	vendorServiceType =(VendorServiceType)getHibernateTemplate().load(VendorServiceType.class,vendorServiceTypeId);
	  if(generalMap.get("flag") != null){
		  String flag = (String)generalMap.get("flag");
		  if (flag.equals("InActivate")){
			  vendorServiceType.setStatus("n");
			  dataDeleted=true;
		  }else if(flag.equals("Activate")){
			  vendorServiceType.setStatus("y");
			  dataDeleted=false;
		  }
	  }
	  vendorServiceType.setLastChgBy(changedBy);
	  vendorServiceType.setLastChgDate(currentDate);
	  vendorServiceType.setLastChgTime(currentTime);
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(vendorServiceType);
	return dataDeleted;
}


public Map<String, Object> showSponsorJsp() {

	Map<String,Object>  map=new HashMap<String,Object>();
	List<MstrSponsor>  searchSponsorList=new ArrayList<MstrSponsor>();
	List<MstrSponsortype>  sponsorTypeList=new ArrayList<MstrSponsortype>();
	List<MstrTherapeutic>  therapetuicList=new ArrayList<MstrTherapeutic>();
	
	searchSponsorList=getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrSponsor");
	sponsorTypeList=getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrSponsortype");
	therapetuicList=getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrTherapeutic");
	map.put("searchSponsorList",searchSponsorList);
	map.put("sponsorTypeList", sponsorTypeList);
	map.put("therapetuicList", therapetuicList);
	return map;
}

public boolean addSponsor(MstrSponsor mstrSponsor) {
	boolean successfullyAdded=false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_AUTO");
	hbt.setCheckWriteOperations(false);
	hbt.save(mstrSponsor);
	hbt.flush();
	hbt.refresh(mstrSponsor);
	successfullyAdded = true;
	return successfullyAdded;
}

@SuppressWarnings("unchecked")
public Map<String, Object> searchSponsor(String sponsorCode, String sponsorName) 
{

	List<MstrSponsor> searchSponsorList = new ArrayList<MstrSponsor>();
	
	Map<String,Object>  sponsorFieldsMap = new HashMap<String,Object>();
	try{
		if((sponsorName!=null) || (sponsorCode==null)){
			searchSponsorList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrSponsor ms where ms.SponsorName like '"+ sponsorName +"%' order by ms.SponsorName");
		}
		else{
			searchSponsorList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrSponsor ms where ms.SponsorCode like '"+ sponsorCode+"%' order by ms.SponsorCode");}
		}catch (Exception e) {
			e.printStackTrace();
		}
		sponsorFieldsMap.put("searchSponsorList",searchSponsorList);

	return sponsorFieldsMap;
}

public boolean editSponsorToDatabase(Map<String, Object> generalMap) {
	
	boolean dataUpdated=false;
	Date currentDate = new Date();
	String currentTime = "";
	currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	String sponsorCode="";
	String sponsorName="";
	int sponsorId = 0;
	int sponsorTypeId = 0;
	String sponsorGroup = null;
	String accountNo    = null;
	String cntNo    = null;
	String emailId    = null;
	String website    = null;
	String faxNo    = null;
	String address    = null;
	String comments    = null;
	String annualRevenue    = null;
	String othGrpCom    = null;
	int totNoEmp    = 0;
	String[] therapeuticIds = new String[0];
	String othOnGoingPrj    = null;
	String annualTurnOver    = null;
	String changedBy = "";
	String changedTime = "";
	Date changedDate = null;
	

	
	sponsorId =(Integer)generalMap.get("id");
	sponsorCode=(String)generalMap.get("sponsorCode");
	sponsorName=(String)generalMap.get("sponsorName");
	sponsorGroup=(String)generalMap.get("sponsorGroup");
	
	cntNo=(String)generalMap.get("cntNo");
	emailId=(String)generalMap.get("emailId");
	website=(String)generalMap.get("website");
	faxNo=(String)generalMap.get("faxNo");
	address=(String)generalMap.get("address");
	comments=(String)generalMap.get("comments");
	annualRevenue=(String)generalMap.get("annualRevenue");
	othGrpCom=(String)generalMap.get("othGrpCom");
	totNoEmp=(Integer)generalMap.get("totNoEmp");
	therapeuticIds=(String[])generalMap.get("therapeuticIds");
	othOnGoingPrj=(String)generalMap.get("othOnGoingPrj");
	annualTurnOver=(String)generalMap.get("annualTurnOver");
	changedBy = (String)generalMap.get("changedBy");
	currentDate=(Date)generalMap.get("currentDate");
	currentTime=(String)generalMap.get("currentTime");
	MstrSponsor mstrSponsor=(MstrSponsor)getHibernateTemplate().load(MstrSponsor.class,sponsorId);
	
	if(generalMap.get("sponsorTypeId")!= null){
		sponsorTypeId =(Integer)generalMap.get("sponsorTypeId");
		MstrSponsortype mstrSponsortype = new MstrSponsortype();
		mstrSponsortype.setId(sponsorTypeId);
		mstrSponsor.setSponserType(mstrSponsortype);
	}

	Set<MstrTherapeutic> thpSet = new HashSet<MstrTherapeutic>();
	for(String thpId : therapeuticIds){
		if(!thpId.equals("")){
			MstrTherapeutic mstrTherapeutic = new MstrTherapeutic();
			mstrTherapeutic.setId(Integer.parseInt(thpId));
			thpSet.add(mstrTherapeutic);
		}
	}
	mstrSponsor.setThp(thpSet);
	
	mstrSponsor.setId(sponsorId);
	mstrSponsor.setSponsorName(sponsorName);
	mstrSponsor.setSponsorGroup(sponsorGroup);
	mstrSponsor.setSponsorAccountno(accountNo);
	mstrSponsor.setSponsorEmailId(emailId);
	mstrSponsor.setSponsorWebsite(website);
	mstrSponsor.setSponsorFaxNo(faxNo);
	mstrSponsor.setSponsorAddress(address);
	mstrSponsor.setSponsorComments(comments);
	mstrSponsor.setSponsorAnnRev(annualRevenue);
	mstrSponsor.setSponsorOthgrpcom(othGrpCom);
	mstrSponsor.setSponsorTotNoEmp(totNoEmp);
	mstrSponsor.setSponsorOthongoingprj(othOnGoingPrj);
	mstrSponsor.setSponsorAnntrunover(annualTurnOver);
	mstrSponsor.setLastChgBy(changedBy);
	mstrSponsor.setLastChgDate(currentDate);
	mstrSponsor.setLastChgTime(currentTime);
	
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(mstrSponsor);
	
	dataUpdated = true;
	return dataUpdated;
}
public boolean deleteSponsor(int sponsorId,Map<String, Object> generalMap) {
	boolean dataDeleted=false;
	String changedBy = "";
	Date currentDate = new Date();
	String currentTime = "";
	currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	MstrSponsor mstrSponsor = new MstrSponsor();
	changedBy = (String)generalMap.get("changedBy");
	currentDate=(Date)generalMap.get("currentDate");
	currentTime=(String)generalMap.get("currentTime");
	mstrSponsor =(MstrSponsor)getHibernateTemplate().load(MstrSponsor.class,sponsorId);
	  if(generalMap.get("flag") != null){
		  String flag = (String)generalMap.get("flag");
		  if (flag.equals("InActivate")){
			  mstrSponsor.setStatus("n");
			  dataDeleted=true;
		  }else if(flag.equals("Activate")){
			  mstrSponsor.setStatus("y");
			  dataDeleted=false;
		  }
	  }
	  mstrSponsor.setLastChgBy(changedBy);
	  mstrSponsor.setLastChgDate(currentDate);
	  mstrSponsor.setLastChgTime(currentTime);
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(mstrSponsor);
	return dataDeleted;
}

/* Code By Naresh */
	@SuppressWarnings("unchecked")
	public Map<String, Object> showVisitTypeJsp() {
	
		Map<String,Object>  map=new HashMap<String,Object>();
		List<HrMasVisitType>  searchMasVisitTypeList = new ArrayList<HrMasVisitType>();
		searchMasVisitTypeList = getHibernateTemplate().find( "from jkt.hrms.masters.business.HrMasVisitType"); // 
		map.put("searchMasVisitTypeList",searchMasVisitTypeList);
		return map;
	}
	public boolean addVisitType(HrMasVisitType hrMasVisitType) {
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrMasVisitType);
		hbt.refresh(hrMasVisitType);
		successfullyAdded = true;
		return successfullyAdded;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchVisitType(String visitTypeCode, String visitTypeName) 
	{
		List<HrMasVisitType> searchVisitTypeList = new ArrayList<HrMasVisitType>();
		
		Map<String,Object>  visitTypeFieldsMap = new HashMap<String,Object>();
		try{
			if((visitTypeName!=null) || (visitTypeCode==null)){
				searchVisitTypeList=getHibernateTemplate().find("from jkt.hrms.masters.business.HrMasVisitType mvt where mvt.VisitType like '"+ visitTypeName +"%' order by mvt.VisitType");
			}
			else{
				searchVisitTypeList=getHibernateTemplate().find("from jkt.hrms.masters.business.HrMasVisitType mvt where mvt.VisitCode like '"+ visitTypeCode+"%' order by mvt.VisitCode");}
			}catch (Exception e) {
				e.printStackTrace();
			}
			visitTypeFieldsMap.put("searchVisitTypeList",searchVisitTypeList);
		
		return visitTypeFieldsMap;
	}
	public boolean editVisitTypeToDatabase(Map<String, Object> generalMap) {
		
		boolean dataUpdated=false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		String visitTypeName="";
		
		int visitTypeId=0;
		String changedBy = "";
		String dependency = "";
		
		visitTypeId=(Integer)generalMap.get("id");
		visitTypeName=(String)generalMap.get("name");
		dependency=(String)generalMap.get("dependency");
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		HrMasVisitType hrMasVisitType=(HrMasVisitType)getHibernateTemplate().load(HrMasVisitType.class,visitTypeId);
		
		hrMasVisitType.setVisitType(visitTypeName);
		hrMasVisitType.setDependency(dependency);
		hrMasVisitType.setLastChgBy(changedBy);
		hrMasVisitType.setLastChgDate(currentDate);
		hrMasVisitType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrMasVisitType);
		hbt.refresh(hrMasVisitType);
		dataUpdated = true;
		return dataUpdated;
	}
	public boolean deleteVisitType(int visitTypeId,Map<String, Object> generalMap) {
		boolean dataDeleted=false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		HrMasVisitType hrMasVisitType = new HrMasVisitType();
		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		hrMasVisitType =(HrMasVisitType)getHibernateTemplate().load(HrMasVisitType.class,visitTypeId);
		  if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  hrMasVisitType.setStatus("n");
				  dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  hrMasVisitType.setStatus("y");
				  dataDeleted=false;
			  }
		  }
		  hrMasVisitType.setLastChgBy(changedBy);
		  hrMasVisitType.setLastChgDate(currentDate);
		  hrMasVisitType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrMasVisitType);
		hbt.refresh(hrMasVisitType);
		return dataDeleted;
	}
	
	/* Code By Naresh End */
	
	
//---------------------Vitals------------------------------------------------------------------------
public Map<String, Object> showVitalsJsp() {
	
	Map<String,Object>  map=new HashMap<String,Object>();
	List<MstrVitals>  searchVitalsList=new ArrayList<MstrVitals>();
	try {
		searchVitalsList=getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrVitals");
	} catch (DataAccessException e) {
		e.printStackTrace();
	}  
	map.put("searchVitalsList",searchVitalsList);
	return map;
}
@SuppressWarnings("unchecked")
public Map<String, Object> searchVitals(String vitalsCode, String vitalsName) 
{
	List<MstrVitals> searchVitalsList = new ArrayList<MstrVitals>();
	
	Map<String,Object>  vitalsFieldsMap = new HashMap<String,Object>();
	try{
		if((vitalsName!=null) || (vitalsCode==null)){
			searchVitalsList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrVitals mv where mv.VitalDescription like '"+ vitalsName +"%' order by mv.VitalDescription");
		}
		else{
			searchVitalsList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrVitals mv where mv.VitalCode like '"+ vitalsCode+"%' order by mv.VitalCode");}
		}catch (Exception e) {
			e.printStackTrace();
		}
		vitalsFieldsMap.put("searchVitalsList",searchVitalsList);

	
	return vitalsFieldsMap;
}

public boolean addVitals(MstrVitals mstrVitals) {
	boolean successfullyAdded=false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_AUTO");
	hbt.setCheckWriteOperations(false);
	hbt.save(mstrVitals);
	hbt.flush();
	hbt.refresh(mstrVitals);
	successfullyAdded = true;
	return successfullyAdded;
}


public boolean editVitalsToDatabase(Map<String, Object> generalMap) {
	
	boolean dataUpdated=false;
	Date currentDate = new Date();
	String currentTime = "";
	currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	String vitalsName="";
	String vitalsFlag = null;
	String amountFlag = null;
	@SuppressWarnings("unused")
	String vitalsCode="";
	int vitalsId=0;
	String changedBy = "";
	
	vitalsId=(Integer)generalMap.get("id");
	vitalsCode=(String)generalMap.get("vitalsCode");
	vitalsName=(String)generalMap.get("name");
	vitalsFlag=(String)generalMap.get("vitalsFlag");
	amountFlag=(String)generalMap.get("amountFlag");
	changedBy = (String)generalMap.get("changedBy");
	currentDate=(Date)generalMap.get("currentDate");
	currentTime=(String)generalMap.get("currentTime");
	MstrVitals mstrVitals=(MstrVitals)getHibernateTemplate().load(MstrVitals.class,vitalsId);
	
	mstrVitals.setId(vitalsId);
	mstrVitals.setVitalDescription(vitalsName);
	mstrVitals.setFlag(vitalsFlag);
	mstrVitals.setAmountFlag(amountFlag);
	mstrVitals.setLastChgBy(changedBy);
	mstrVitals.setLastChgDate(currentDate);
	mstrVitals.setLastChgTime(currentTime);
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(mstrVitals);
	dataUpdated = true;
	return dataUpdated;
}
public boolean deleteVitals(int vitalsId,Map<String, Object> generalMap) {
	boolean dataDeleted=false;
	String changedBy = "";
	Date currentDate = new Date();
	String currentTime = "";
	currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	MstrVitals mstrVitals = new MstrVitals();
	changedBy = (String)generalMap.get("changedBy");
	currentDate=(Date)generalMap.get("currentDate");
	currentTime=(String)generalMap.get("currentTime");
	mstrVitals =(MstrVitals)getHibernateTemplate().load(MstrVitals.class,vitalsId);
	  if(generalMap.get("flag") != null){
		  String flag = (String)generalMap.get("flag");
		  if (flag.equals("InActivate")){
			  mstrVitals.setStatus("n");
			  dataDeleted=true;
		  }else if(flag.equals("Activate")){
			  mstrVitals.setStatus("y");
			  dataDeleted=false;
		  }
	  }
	  mstrVitals.setLastChgBy(changedBy);
	  mstrVitals.setLastChgDate(currentDate);
	  mstrVitals.setLastChgTime(currentTime);
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(mstrVitals);
	return dataDeleted;
}

	//=================================All Methods end here================================Thanks
	
}