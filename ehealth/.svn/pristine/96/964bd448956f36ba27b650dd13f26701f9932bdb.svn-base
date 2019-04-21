package jkt.hrms.projectTracking.dataservice;

import static jkt.hrms.util.HrmsRequestConstants.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.sql.Connection;
import org.hibernate.HibernateException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasCurrency;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.CntrReqPat;
import jkt.hrms.masters.business.HrMasVisitType;
import jkt.hrms.masters.business.HrPrjSiteCalendar;
import jkt.hrms.masters.business.MstrBudgetSubhead;
import jkt.hrms.masters.business.MstrBudgetType;
import jkt.hrms.masters.business.MstrCalendar;
import jkt.hrms.masters.business.MstrDoctype;
import jkt.hrms.masters.business.MstrDocument;
import jkt.hrms.masters.business.MstrPiDetail;
import jkt.hrms.masters.business.MstrPiHeader;
import jkt.hrms.masters.business.MstrProject;
import jkt.hrms.masters.business.MstrProjectStatus;
import jkt.hrms.masters.business.MstrProjectrole;
import jkt.hrms.masters.business.MstrProjecttype;
import jkt.hrms.masters.business.MstrPtvisit;
import jkt.hrms.masters.business.MstrQueryStatus;
import jkt.hrms.masters.business.MstrRating;
import jkt.hrms.masters.business.MstrRegulatoryStatus;
import jkt.hrms.masters.business.MstrRoleTaskMap;
import jkt.hrms.masters.business.MstrSiteDetail;
import jkt.hrms.masters.business.MstrSiteHeader;
import jkt.hrms.masters.business.MstrSponsor;
import jkt.hrms.masters.business.MstrTask;
import jkt.hrms.masters.business.MstrTaskType;
import jkt.hrms.masters.business.MstrTherapeutic;
import jkt.hrms.masters.business.MstrTrialphase;
import jkt.hrms.masters.business.MstrVendor;
import jkt.hrms.masters.business.MstrVitals;
import jkt.hrms.masters.business.PrjAddPtDetail;
import jkt.hrms.masters.business.PrjAddPtHeader;
import jkt.hrms.masters.business.PrjAnsEntry;
import jkt.hrms.masters.business.PrjAnsEntryDoc;
import jkt.hrms.masters.business.PrjBudgetSetting;
import jkt.hrms.masters.business.PrjDcfEntry;
import jkt.hrms.masters.business.PrjFedoc;
import jkt.hrms.masters.business.PrjFesStudyDetail;
import jkt.hrms.masters.business.PrjFesStudyHeader;
import jkt.hrms.masters.business.PrjMilestone;
import jkt.hrms.masters.business.PrjOthervitals;
import jkt.hrms.masters.business.PrjPatvisitsch;
import jkt.hrms.masters.business.PrjQueryEntry;
import jkt.hrms.masters.business.PrjQueryEntryDoc;
import jkt.hrms.masters.business.PrjQueryFlwEntry;
import jkt.hrms.masters.business.PrjQueryFlwEntryDoc;
import jkt.hrms.masters.business.PrjReglSub;
import jkt.hrms.masters.business.PrjReglSubDoc;
import jkt.hrms.masters.business.PrjRoleResMappingDetail;
import jkt.hrms.masters.business.PrjRoleResMappingHeader;
import jkt.hrms.masters.business.PrjRolewiseResourceReq;
import jkt.hrms.masters.business.PrjScheduleDetail;
import jkt.hrms.masters.business.PrjScheduleDocument;
import jkt.hrms.masters.business.PrjScheduleHeader;
import jkt.hrms.masters.business.PrjSiteMilestone;
import jkt.hrms.masters.business.PrjSiteOthervitals;
import jkt.hrms.masters.business.PrjSiteResMap;
import jkt.hrms.masters.business.PrjSiteVital;
import jkt.hrms.masters.business.PrjVendorcontract;
import jkt.hrms.masters.business.ProjectCalendar;
import jkt.hrms.masters.business.ProjectVitals;
import jkt.hrms.masters.business.TempTickattach;
import jkt.hrms.masters.business.TempTrvsub;
import jkt.hrms.masters.business.VendorServiceType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ProjectTrackingDataServiceImpl extends HibernateDaoSupport implements
		ProjectTrackingDataService {


	@SuppressWarnings("unchecked")
	public Map<String, Object> showProjectCreationJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MstrProject>projectList = new ArrayList<MstrProject>();
		List<MstrSponsor> sponsorList = new ArrayList<MstrSponsor>();
		List<MstrTherapeutic> therapeuticAreaList = new ArrayList<MstrTherapeutic>();
		List<MstrProjecttype> projectTypeList = new ArrayList<MstrProjecttype>();
		List<MstrProjectStatus> projectStatusList = new ArrayList<MstrProjectStatus>();
		List<MstrTrialphase> trialPhaseList = new ArrayList<MstrTrialphase>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		Session session = (Session)getSession();
		projectList = session.createCriteria(MstrProject.class).list();
		sponsorList = session.createCriteria(MstrSponsor.class).add(Restrictions.eq("Status", "y")).list();
		therapeuticAreaList = session.createCriteria(MstrTherapeutic.class).add(Restrictions.eq("Status", "y")).list();
		projectTypeList = session.createCriteria(MstrProjecttype.class).add(Restrictions.eq("Status", "y")).list();
		projectStatusList = session.createCriteria(MstrProjectStatus.class).add(Restrictions.eq("Status", "y")).list();
		trialPhaseList = session.createCriteria(MstrTrialphase.class).add(Restrictions.eq("Status", "y")).list();
		currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();

		map.put("projectList", projectList);
		map.put("sponsorList", sponsorList);
		map.put("therapeuticAreaList", therapeuticAreaList);
		map.put("projectTypeList", projectTypeList);
		map.put("projectStatusList", projectStatusList);
		map.put("currencyList", currencyList);
		map.put("trialPhaseList", trialPhaseList);
		return map;
	}
	public Map<String, Object> saveProjectCreation(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MstrProject>projectList = new ArrayList<MstrProject>();
		List<MstrSponsor> sponsorList = new ArrayList<MstrSponsor>();
		List<MstrTherapeutic> therapeuticAreaList = new ArrayList<MstrTherapeutic>();
		List<MstrProjecttype> projectTypeList = new ArrayList<MstrProjecttype>();
		List<MstrProjectStatus> projectStatusList = new ArrayList<MstrProjectStatus>();
		List<MstrTrialphase> trialPhaseList = new ArrayList<MstrTrialphase>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		List<MstrProject>projectExtensionList = new ArrayList<MstrProject>();
		Session session = (Session)getSession();
		String projectName = "";
		if(generalMap.get("projectName")!= null){
			projectName =(String)generalMap.get("projectName");
		}
		int sponserId = 0;
		if(generalMap.get("sponserId")!= null){
			sponserId =(Integer)generalMap.get("sponserId");
		}
		int projectExtensionId = 0;
		if(generalMap.get("projectExtensionId")!= null){
			projectExtensionId =(Integer)generalMap.get("projectExtensionId");
		}
		String description = "";
		if(generalMap.get("description")!= null){
			description =(String)generalMap.get("description");
		}
		int therapeuticId = 0;
		if(generalMap.get("therapeuticId")!= null){
			therapeuticId =(Integer)generalMap.get("therapeuticId");
		}
		String projectCode = "";
		if(generalMap.get("projectCode")!= null){
			projectCode =(String)generalMap.get("projectCode");
		}
		String protocolNo= "";
		if(generalMap.get("protocolNo")!= null){
			protocolNo =(String)generalMap.get("protocolNo");
		}
		String loiNo = "";
		if(generalMap.get("loiNo")!= null){
			loiNo =(String)generalMap.get("loiNo");
		}
		int projectTypeId = 0;
		if(generalMap.get("projectTypeId")!= null){
			projectTypeId =(Integer)generalMap.get("projectTypeId");
		}
		int projectTrialPhaseId = 0;
		if(generalMap.get("projectTrialPhaseId")!= null){
			projectTrialPhaseId =(Integer)generalMap.get("projectTrialPhaseId");
		}
		int projectStatusId = 0;
		if(generalMap.get("projectStatusId")!= null){
			projectStatusId =(Integer)generalMap.get("projectStatusId");
		}
		BigDecimal budget = new BigDecimal("0");
		if(generalMap.get("budget")!= null){
			budget =(BigDecimal)generalMap.get("budget");
		}
		Date startDate = null;
		if(generalMap.get("startDate")!= null){
			startDate =(Date)generalMap.get("startDate");
		}
		Date endDate = null;
		if(generalMap.get("endDate")!= null){
			endDate =(Date)generalMap.get("endDate");
		}
		Date loiDate = null;
		if(generalMap.get("loiDate")!= null){
			loiDate =(Date)generalMap.get("loiDate");
		}
		String billable ="";
		if(generalMap.get("billable")!= null){
			billable =(String)generalMap.get("billable");
		}
		String extension = "";
		if(generalMap.get("extension")!= null){
			extension =(String)generalMap.get("extension");
		}
		Date purchaseOrderDate = null;
		if(generalMap.get("purchaseOrderDate")!= null){
			purchaseOrderDate =(Date)generalMap.get("purchaseOrderDate");
		}
		String purchaseOrderNo = "";
		if(generalMap.get("purchaseOrderNo")!= null){
			purchaseOrderNo =(String)generalMap.get("purchaseOrderNo");
		}
		Date contractDate = null;
		if(generalMap.get("contractDate")!= null){
			contractDate =(Date)generalMap.get("contractDate");
		}
		String contractNo = "";
		if(generalMap.get("contractNo")!= null){
			contractNo =(String)generalMap.get("contractNo");
		}
		int currencyId = 0;
		if(generalMap.get("currencyId")!= null){
			currencyId =(Integer)generalMap.get("currencyId");
		}
		String changedBy  = "";
		 if(generalMap.get("changedBy")!= null){
			 changedBy =(String)generalMap.get("changedBy");
		 }
		 Date currentDate = new Date();
		 if(generalMap.get("currentDate")!= null){
			 currentDate =(Date)generalMap.get("currentDate");
		 }
		 String	currentTime = "";
		 if(generalMap.get("currentTime")!= null){
			 currentTime =(String)generalMap.get("currentTime");
		 }
		 projectExtensionList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectExtensionId)).list();
		 String projectExtensionName = "";
		 if(projectExtensionList.size()>0){
			 for(MstrProject mstrPrj :projectExtensionList){
			 projectExtensionName =  mstrPrj.getPrjName();
		 }
	}
		MstrProject mstrProject = new MstrProject();
		//mstrProject.setPrjName(projectName);

		MstrSponsor mstrSponsor = new MstrSponsor();
		mstrSponsor.setId(sponserId);
		mstrProject.setSponsor(mstrSponsor);
		mstrProject.setPrjDesc(description);
		if(extension.equals("y")){
			mstrProject.setPrjName(projectExtensionName);
		}else{
			mstrProject.setPrjName(projectName);
		}
		mstrProject.setPrjCode(projectCode);
		mstrProject.setPrjLoino(loiNo);
		mstrProject.setPrjProtocalno(protocolNo);
		mstrProject.setPrjExpectedbudget(budget);
		mstrProject.setPrjStdt(startDate);
		mstrProject.setPrjEddt(endDate);
		mstrProject.setPrjLoidt(loiDate);
		mstrProject.setBillable(billable);
		mstrProject.setExtension(extension);
		mstrProject.setPurchaseOrderNo(purchaseOrderNo);
		mstrProject.setPurchasOrderDate(purchaseOrderDate);
		mstrProject.setContractDate(contractDate);
		mstrProject.setContractNo(contractNo);
		mstrProject.setStatus("y");
		mstrProject.setLastChgBy(changedBy);
		mstrProject.setLastChgDate(currentDate);
		mstrProject.setLastChgTime(currentTime);

		MstrTherapeutic mstrTherapeutic = new MstrTherapeutic();
		mstrTherapeutic.setId(therapeuticId);
		mstrProject.setThp(mstrTherapeutic);

		MstrProjecttype mstrProjecttype = new MstrProjecttype();
		mstrProjecttype.setId(projectTypeId);
		mstrProject.setProjectType(mstrProjecttype);

		MstrProjectStatus mstrProjectStatus = new MstrProjectStatus();
		mstrProjectStatus.setId(projectStatusId);
		mstrProject.setProjectStatus(mstrProjectStatus);

		MstrTrialphase mstrTrialphase = new MstrTrialphase();
		mstrTrialphase.setId(projectTrialPhaseId);
		mstrProject.setTrialPhase(mstrTrialphase);

		MasCurrency masCurrency = new MasCurrency();
		masCurrency.setId(currencyId);
		mstrProject.setCurrency(masCurrency);

		if(extension.equals("y")){
			MstrProject mstrProject2 = new MstrProject();
			mstrProject2.setId(projectExtensionId);
			mstrProject.setProjectExtension(mstrProject2);
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(mstrProject);
		String message = "";
		boolean saved = false;
		saved =  true;

		if(saved){
			message = "Data save Successfully.";
		}else{
			message = "Some Problem Occured.";
		}
		projectList = session.createCriteria(MstrProject.class).list();
		map.put("message", message);
		map.put("projectList", projectList);
		map = showProjectCreationJsp();
		return map;
	}
	public Map<String, Object> updateProjectCreation(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId =(Integer)generalMap.get("projectId");
		}
		String projectName = "";
		if(generalMap.get("projectName")!= null){
			projectName =(String)generalMap.get("projectName");
		}
		int sponserId = 0;
		if(generalMap.get("sponserId")!= null){
			sponserId =(Integer)generalMap.get("sponserId");
		}
		String description = "";
		if(generalMap.get("description")!= null){
			description =(String)generalMap.get("description");
		}
		int therapeuticId = 0;
		if(generalMap.get("therapeuticId")!= null){
			therapeuticId =(Integer)generalMap.get("therapeuticId");
		}
		String projectCode = "";
		if(generalMap.get("projectCode")!= null){
			projectCode =(String)generalMap.get("projectCode");
		}
		String protocolNo= "";
		if(generalMap.get("protocolNo")!= null){
			protocolNo =(String)generalMap.get("protocolNo");
		}
		String loiNo = "";
		if(generalMap.get("loiNo")!= null){
			loiNo =(String)generalMap.get("loiNo");
		}
		int projectTypeId = 0;
		if(generalMap.get("projectTypeId")!= null){
			projectTypeId =(Integer)generalMap.get("projectTypeId");
		}
		int projectTrialPhaseId = 0;
		if(generalMap.get("projectTrialPhaseId")!= null){
			projectTrialPhaseId =(Integer)generalMap.get("projectTrialPhaseId");
		}
		int projectStatusId = 0;
		if(generalMap.get("projectStatusId")!= null){
			projectStatusId =(Integer)generalMap.get("projectStatusId");
		}
		BigDecimal budget = new BigDecimal("0");
		if(generalMap.get("budget")!= null){
			budget =(BigDecimal)generalMap.get("budget");
		}
		Date startDate = null;
		if(generalMap.get("startDate")!= null){
			startDate =(Date)generalMap.get("startDate");
		}
		Date endDate = null;
		if(generalMap.get("endDate")!= null){
			endDate =(Date)generalMap.get("endDate");
		}
		Date loiDate = null;
		if(generalMap.get("loiDate")!= null){
			loiDate =(Date)generalMap.get("loiDate");
		}
		String billable ="";
		if(generalMap.get("billable")!= null){
			billable =(String)generalMap.get("billable");
		}
		String extension ="";
		if(generalMap.get("extension")!= null){
			extension =(String)generalMap.get("extension");
		}
		Date purchaseOrderDate = null;
		if(generalMap.get("purchaseOrderDate")!= null){
			purchaseOrderDate =(Date)generalMap.get("purchaseOrderDate");
		}
		String purchaseOrderNo = "";
		if(generalMap.get("purchaseOrderNo")!= null){
			purchaseOrderNo =(String)generalMap.get("purchaseOrderNo");
		}
		Date contractDate = null;
		if(generalMap.get("contractDate")!= null){
			contractDate =(Date)generalMap.get("contractDate");
		}
		String contractNo = "";
		if(generalMap.get("contractNo")!= null){
			contractNo =(String)generalMap.get("contractNo");
		}
		int currencyId = 0;
		if(generalMap.get("currencyId")!= null){
			currencyId =(Integer)generalMap.get("currencyId");
		}
		String changedBy  = "";
		 if(generalMap.get("changedBy")!= null){
			 changedBy =(String)generalMap.get("changedBy");
		 }
		 Date currentDate = new Date();
		 if(generalMap.get("currentDate")!= null){
			 currentDate =(Date)generalMap.get("currentDate");
		 }
		 String	currentTime = "";
		 if(generalMap.get("currentTime")!= null){
			 currentTime =(String)generalMap.get("currentTime");
		 }
		 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			MstrProject mstrProject = (MstrProject)hbt.load(MstrProject.class, projectId);
			mstrProject.setBillable(billable);
			mstrProject.setExtension(extension);
			mstrProject.setContractDate(contractDate);
			mstrProject.setContractNo(contractNo);
			mstrProject.setLastChgBy(changedBy);
			mstrProject.setLastChgDate(currentDate);
			mstrProject.setLastChgTime(currentTime);
			mstrProject.setPrjCode(projectCode);
			mstrProject.setPrjDesc(description);
			mstrProject.setPrjEddt(endDate);
			mstrProject.setPrjStdt(startDate);
			mstrProject.setPrjExpectedbudget(budget);
			mstrProject.setPrjLoidt(loiDate);
			mstrProject.setPrjLoino(loiNo);
			mstrProject.setPrjProtocalno(protocolNo);
			mstrProject.setPurchaseOrderNo(purchaseOrderNo);
			mstrProject.setPurchasOrderDate(purchaseOrderDate);
			mstrProject.setPrjName(projectName);

			MasCurrency masCurrency = new MasCurrency();
			masCurrency.setId(currencyId);
			mstrProject.setCurrency(masCurrency);

			MstrProjectStatus mstrProjectStatus = new MstrProjectStatus();
			mstrProjectStatus.setId(projectStatusId);
			mstrProject.setProjectStatus(mstrProjectStatus);

			MstrTrialphase mstrTrialphase = new MstrTrialphase();
			mstrTrialphase.setId(projectTrialPhaseId);
			mstrProject.setTrialPhase(mstrTrialphase);

			MstrProjecttype mstrProjecttype = new MstrProjecttype();
			mstrProjecttype.setId(projectTypeId);
			mstrProject.setProjectType(mstrProjecttype);

			MstrTherapeutic mstrTherapeutic = new MstrTherapeutic();
			mstrTherapeutic.setId(therapeuticId);
			mstrProject.setThp(mstrTherapeutic);

			MstrSponsor mstrSponsor = new MstrSponsor();
			mstrSponsor.setId(sponserId);
			mstrProject.setSponsor(mstrSponsor);
			hbt.update(mstrProject);
			String message = "";
			boolean updated = false;
			updated =  true;

			if(updated){
				message = "Data update Successfully.";
			}else{
				message = "Some Problem Occured.";
			}
			map.put("message", message);
			map = showProjectCreationJsp();
		return map;
	}
	public Map<String, Object> searchProjectCreation(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MstrSponsor> sponsorList = new ArrayList<MstrSponsor>();
		List<MstrTherapeutic> therapeuticAreaList = new ArrayList<MstrTherapeutic>();
		List<MstrProjecttype> projectTypeList = new ArrayList<MstrProjecttype>();
		List<MstrProjectStatus> projectStatusList = new ArrayList<MstrProjectStatus>();
		List<MstrTrialphase> trialPhaseList = new ArrayList<MstrTrialphase>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		Session session = (Session)getSession();
		int searchProjectStatusId = 0;
		if(generalMap.get("searchProjectStatusId")!= null){
			searchProjectStatusId =(Integer)generalMap.get("searchProjectStatusId");
		}
		String searchProjectName = "";
		if(generalMap.get("searchProjectName")!= null){
			searchProjectName =(String)generalMap.get("searchProjectName");
		}
		String searchProtocolNo = "";
		if(generalMap.get("searchProtocolNo")!= null){
			searchProtocolNo =(String)generalMap.get("searchProtocolNo");
		}
		String searchProjectCode = "";
		if(generalMap.get("searchProjectCode")!= null){
			searchProjectCode =(String)generalMap.get("searchProjectCode");
		}
		Criteria crit = null;
		crit = session.createCriteria(MstrProject.class);
		if(searchProjectStatusId != 0){
			crit = crit.createAlias("ProjectStatus", "prjStatus").add(Restrictions.eq("prjStatus.Id", searchProjectStatusId));
		}

		if(!searchProjectName.equals("")){
			crit = crit.add(Restrictions.eq("PrjName", searchProjectName));
		}
		if(!searchProtocolNo.equals("")){
			crit = crit.add(Restrictions.eq("PrjProtocalno", searchProtocolNo));
		}
		if(!searchProjectCode.equals("")){
			crit = crit.add(Restrictions.eq("PrjCode", searchProjectCode));
		}
		projectList = crit.list();

		sponsorList = session.createCriteria(MstrSponsor.class).add(Restrictions.eq("Status", "y")).list();
		therapeuticAreaList = session.createCriteria(MstrTherapeutic.class).add(Restrictions.eq("Status", "y")).list();
		projectTypeList = session.createCriteria(MstrProjecttype.class).add(Restrictions.eq("Status", "y")).list();
		projectStatusList = session.createCriteria(MstrProjectStatus.class).add(Restrictions.eq("Status", "y")).list();
		trialPhaseList = session.createCriteria(MstrTrialphase.class).add(Restrictions.eq("Status", "y")).list();
		currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();

		map.put("projectList", projectList);
		map.put("sponsorList", sponsorList);
		map.put("therapeuticAreaList", therapeuticAreaList);
		map.put("projectTypeList", projectTypeList);
		map.put("projectStatusList", projectStatusList);
		map.put("currencyList", currencyList);
		map.put("trialPhaseList", trialPhaseList);
		return map;
	}
	public Map<String, Object> getExistingProjectListForAjax() {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MstrProject> projectList = new ArrayList<MstrProject>();
		Session session = (Session)getSession();
		projectList = session.createCriteria(MstrProject.class).list();

		map.put("projectList", projectList);

		return map;
	}


	public Map<String, Object> showProjectVitalsJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		Session session = (Session)getSession();
		projectList = session.createCriteria(MstrProject.class).list();
		map.put("projectList", projectList);
		map = showProjectCreationJsp();
		return map;
	}
	@SuppressWarnings("suppress")
	public Map<String, Object> showSitePaymentScheduleJsp(int projectId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<MstrPtvisit> patientVisitList = new ArrayList<MstrPtvisit>();
		List<PrjMilestone> prjMilstoneList = new ArrayList<PrjMilestone>();
		Session session = (Session)getSession();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		patientVisitList = session.createCriteria(MstrPtvisit.class).list();
		prjMilstoneList = session.createCriteria(PrjMilestone.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
		map.put("projectList", projectList);
		map.put("patientVisitList", patientVisitList);
		map.put("prjMilstoneList", prjMilstoneList);
		return map;
	}

	public Map<String, Object> saveSitePaymentSchedule(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<MstrPtvisit> patientVisitList = new ArrayList<MstrPtvisit>();
		List<PrjMilestone> prjMilstoneList = new ArrayList<PrjMilestone>();
		Session session = (Session)getSession();
		int	hospitalId = 0;
		if(generalMap.get("hospitalId")!= null){
			hospitalId =(Integer)generalMap.get("hospitalId");
		}
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId =(Integer)generalMap.get("projectId");
		}
		 int visitId =0;
		 if(generalMap.get("visitId")!= null){
			 visitId =(Integer)generalMap.get("visitId");
		}
		 BigDecimal amountPerPatient = new BigDecimal("0");
		 if(generalMap.get("amountPerPatient")!= null){
			 amountPerPatient =(BigDecimal)generalMap.get("amountPerPatient");
		 }
		 BigDecimal paymentInPercentage = new BigDecimal("0");
		 if(generalMap.get("paymentInPercentage")!= null){
			 paymentInPercentage =(BigDecimal)generalMap.get("paymentInPercentage");
		 }
		 BigDecimal paymentInAmount = new BigDecimal("0");
		 if(generalMap.get("paymentInAmount")!= null){
			 paymentInAmount =(BigDecimal)generalMap.get("paymentInAmount");
		 }
		 Date cutOffDateDate = null;
		 if(generalMap.get("cutOffDateDate")!= null){
			 cutOffDateDate =(Date)generalMap.get("cutOffDateDate");
		 }
		 String changedBy  = "";
		 if(generalMap.get("changedBy")!= null){
			 changedBy =(String)generalMap.get("changedBy");
		 }
		 Date currentDate = new Date();
		 if(generalMap.get("currentDate")!= null){
			 currentDate =(Date)generalMap.get("currentDate");
		 }
		 String	currentTime = "";
		 if(generalMap.get("currentTime")!= null){
			 currentTime =(String)generalMap.get("currentTime");
		 }
		 PrjMilestone prjMilestone = new PrjMilestone();
		 prjMilestone.setCutOffDate(cutOffDateDate);
		 prjMilestone.setLastChgBy(changedBy);
		 prjMilestone.setLastChgDate(currentDate);
		 prjMilestone.setLastChgTime(currentTime);
		 prjMilestone.setMilestoneAmount(paymentInAmount);
		 prjMilestone.setMilestonePercentage(paymentInPercentage);
		 prjMilestone.setTotalAmtPerPatient(amountPerPatient);
		 prjMilestone.setStatus("y");

		 MasHospital masHospital = new MasHospital();
		 masHospital.setId(hospitalId);
		 prjMilestone.setHospital(masHospital);

		 MstrProject mstrProject = new MstrProject();
		 mstrProject.setId(projectId);
		 prjMilestone.setPrj(mstrProject);

		 MstrPtvisit mstrPtvisit = new MstrPtvisit();
		 mstrPtvisit.setId(visitId);
		 prjMilestone.setPatientVisit(mstrPtvisit);
		 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.save(prjMilestone);
			String message = "";
			boolean saved = false;
			saved =  true;

			if(saved){
				message = "Data save Successfully.";
			}else{
				message = "Some Problem Occured.";
			}
			prjMilstoneList = session.createCriteria(PrjMilestone.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
			projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
			patientVisitList = session.createCriteria(MstrPtvisit.class).list();
			map.put("projectList", projectList);
			map.put("patientVisitList", patientVisitList);
			map.put("prjMilstoneList", prjMilstoneList);
		return map;
	}
	public Map<String, Object> updateSitePaymentSchedule(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<MstrPtvisit> patientVisitList = new ArrayList<MstrPtvisit>();
		List<PrjMilestone> prjMilstoneList = new ArrayList<PrjMilestone>();
		Session session = (Session)getSession();
		int	sitePaymentScheduleId = 0;
		if(generalMap.get("sitePaymentScheduleId")!= null){
			sitePaymentScheduleId =(Integer)generalMap.get("sitePaymentScheduleId");
		}
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId =(Integer)generalMap.get("projectId");
		}
		 int visitId =0;
		 if(generalMap.get("visitId")!= null){
			 visitId =(Integer)generalMap.get("visitId");
		}
		 BigDecimal amountPerPatient = new BigDecimal("0");
		 if(generalMap.get("amountPerPatient")!= null){
			 amountPerPatient =(BigDecimal)generalMap.get("amountPerPatient");
		 }
		 BigDecimal paymentInPercentage = new BigDecimal("0");
		 if(generalMap.get("paymentInPercentage")!= null){
			 paymentInPercentage =(BigDecimal)generalMap.get("paymentInPercentage");
		 }
		 BigDecimal paymentInAmount = new BigDecimal("0");
		 if(generalMap.get("paymentInAmount")!= null){
			 paymentInAmount =(BigDecimal)generalMap.get("paymentInAmount");
		 }
		 Date cutOffDate = null;
		 if(generalMap.get("cutOffDate")!= null){
			 cutOffDate =(Date)generalMap.get("cutOffDate");
		 }
		 String changedBy  = "";
		 if(generalMap.get("changedBy")!= null){
			 changedBy =(String)generalMap.get("changedBy");
		 }
		 Date currentDate = new Date();
		 if(generalMap.get("currentDate")!= null){
			 currentDate =(Date)generalMap.get("currentDate");
		 }
		 String	currentTime = "";
		 if(generalMap.get("currentTime")!= null){
			 currentTime =(String)generalMap.get("currentTime");
		 }
		 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			PrjMilestone prjMilestone = (PrjMilestone)hbt.load(PrjMilestone.class, sitePaymentScheduleId);
			prjMilestone.setCutOffDate(cutOffDate);
			prjMilestone.setLastChgBy(changedBy);
			prjMilestone.setLastChgDate(currentDate);
			prjMilestone.setLastChgTime(currentTime);
			prjMilestone.setMilestoneAmount(paymentInAmount);
			prjMilestone.setMilestonePercentage(paymentInPercentage);
			prjMilestone.setTotalAmtPerPatient(amountPerPatient);

			MstrPtvisit mstrPtvisit = new MstrPtvisit();
			mstrPtvisit.setId(visitId);
			prjMilestone.setPatientVisit(mstrPtvisit);

			MstrProject mstrProject = new MstrProject();
			mstrProject.setId(projectId);
			prjMilestone.setPrj(mstrProject);
			hbt.update(prjMilestone);
			String message = "";
			boolean updated = false;
			updated =  true;

			if(updated){
				message = "Data update Successfully.";
			}else{
				message = "Some Problem Occured.";
			}
			map.put("message", message);
			prjMilstoneList = session.createCriteria(PrjMilestone.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
			projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
			patientVisitList = session.createCriteria(MstrPtvisit.class).list();
			map.put("projectList", projectList);
			map.put("patientVisitList", patientVisitList);
			map.put("prjMilstoneList", prjMilstoneList);
		return map;
	}

	public Map<String, Object> showRoleWiseResourceReuiredJsp(int projectId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<MstrProjectrole> projectRoleList = new ArrayList<MstrProjectrole>();
		List<PrjRolewiseResourceReq> prjRoleWiseResourceList = new ArrayList<PrjRolewiseResourceReq>();
		Session session = (Session)getSession();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		projectRoleList = session.createCriteria(MstrProjectrole.class).list();
		prjRoleWiseResourceList = session.createCriteria(PrjRolewiseResourceReq.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
		map.put("projectList", projectList);
		map.put("projectRoleList", projectRoleList);
		map.put("prjRoleWiseResourceList", prjRoleWiseResourceList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> saveRoleWiseResourceRequired(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<MstrProjectrole> projectRoleList = new ArrayList<MstrProjectrole>();
		List<PrjRolewiseResourceReq> prjRoleWiseResourceList = new ArrayList<PrjRolewiseResourceReq>();
		List<PrjRolewiseResourceReq> prjRoleWiseResourceToCkechList = new ArrayList<PrjRolewiseResourceReq>();
		Session session = (Session)getSession();
		int	hospitalId = 0;
		if(generalMap.get("hospitalId")!= null){
			hospitalId =(Integer)generalMap.get("hospitalId");
		}
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId =(Integer)generalMap.get("projectId");
		}
		int projectRoleId = 0;
		if(generalMap.get("projectRoleId")!= null){
			projectRoleId =(Integer)generalMap.get("projectRoleId");
		}
		int reqNo = 0;
		if(generalMap.get("reqNo")!= null){
			reqNo =(Integer)generalMap.get("reqNo");
		}
		BigDecimal costPerHour  = new BigDecimal("0");
		if(generalMap.get("costPerHour")!= null){
			costPerHour =(BigDecimal)generalMap.get("costPerHour");
		}
		String changedBy  = "";
		 if(generalMap.get("changedBy")!= null){
			 changedBy =(String)generalMap.get("changedBy");
		 }
		 Date currentDate = new Date();
		 if(generalMap.get("currentDate")!= null){
			 currentDate =(Date)generalMap.get("currentDate");
		 }
		 String	currentTime = "";
		 if(generalMap.get("currentTime")!= null){
			 currentTime =(String)generalMap.get("currentTime");
		 }

		 prjRoleWiseResourceToCkechList = session.createCriteria(PrjRolewiseResourceReq.class)
		 								.add(Restrictions.eq("Prj.Id", projectId))
		 								.add(Restrictions.eq("Pjr.Id", projectRoleId))
		 								.list();
		 String message = "";
		 boolean saved = true;
		 boolean duplicateFlag = true;
		 try{
			 if(prjRoleWiseResourceToCkechList.size() == 0){
				 PrjRolewiseResourceReq prjRolewiseResourceReq = new PrjRolewiseResourceReq();
				 prjRolewiseResourceReq.setCostPerHr(costPerHour);
				 prjRolewiseResourceReq.setResCount(reqNo);
				 prjRolewiseResourceReq.setLastChgBy(changedBy);
				 prjRolewiseResourceReq.setLastChgDate(currentDate);
				 prjRolewiseResourceReq.setLastChgTime(currentTime);
				 prjRolewiseResourceReq.setStatus("y");

				 MstrProject mstrProject = new MstrProject();
				 mstrProject.setId(projectId);
				 prjRolewiseResourceReq.setPrj(mstrProject);

				 MstrProjectrole mstrProjectrole = new MstrProjectrole();
				 mstrProjectrole.setId(projectRoleId);
				 prjRolewiseResourceReq.setPjr(mstrProjectrole);
				 MasHospital masHospital = new MasHospital();
				 masHospital.setId(hospitalId);
				 prjRolewiseResourceReq.setHospital(masHospital);

				 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				 hbt.setFlushModeName("FLUSH_AUTO");
				 hbt.setCheckWriteOperations(false);
				 hbt.save(prjRolewiseResourceReq);
				 duplicateFlag =false;
			 }
		 }catch(Exception exception){
			 saved = false;
			 exception.printStackTrace();
		 }
		if(saved){
			if(duplicateFlag){
				message = "Duplicate Entry For Role.";
			}else{
				message = "Data save Successfully.";
			}
		}else{
			message = "Some Problem Occured.";
		}
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		projectRoleList = session.createCriteria(MstrProjectrole.class).list();
		prjRoleWiseResourceList = session.createCriteria(PrjRolewiseResourceReq.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
		map.put("message", message);
		map.put("projectList", projectList);
		map.put("projectRoleList", projectRoleList);
		map.put("prjRoleWiseResourceList", prjRoleWiseResourceList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> updateRoleWiseResourceRequired(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<MstrProjectrole> projectRoleList = new ArrayList<MstrProjectrole>();
		List<PrjRolewiseResourceReq> prjRoleWiseResourceList = new ArrayList<PrjRolewiseResourceReq>();
		List<PrjRolewiseResourceReq> prjRoleWiseResourceToCkechList = new ArrayList<PrjRolewiseResourceReq>();
		Session session = (Session)getSession();
		int roleWiseresourceRequiredId = 0;
		if(generalMap.get("roleWiseresourceRequiredId")!= null){
			roleWiseresourceRequiredId =(Integer)generalMap.get("roleWiseresourceRequiredId");
		}
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId =(Integer)generalMap.get("projectId");
		}
		int projectRoleId = 0;
		if(generalMap.get("projectRoleId")!= null){
			projectRoleId =(Integer)generalMap.get("projectRoleId");
		}
		int reqNo = 0;
		if(generalMap.get("reqNo")!= null){
			reqNo =(Integer)generalMap.get("reqNo");
		}
		BigDecimal costPerHour  = new BigDecimal("0");
		if(generalMap.get("costPerHour")!= null){
			costPerHour =(BigDecimal)generalMap.get("costPerHour");
		}
		String changedBy  = "";
		 if(generalMap.get("changedBy")!= null){
			 changedBy =(String)generalMap.get("changedBy");
		 }
		 Date currentDate = new Date();
		 if(generalMap.get("currentDate")!= null){
			 currentDate =(Date)generalMap.get("currentDate");
		 }
		 String	currentTime = "";
		 if(generalMap.get("currentTime")!= null){
			 currentTime =(String)generalMap.get("currentTime");
		 }

		 prjRoleWiseResourceToCkechList = session.createCriteria(PrjRolewiseResourceReq.class)
					 				.add(Restrictions.eq("Prj.Id", projectId))
		 							.add(Restrictions.eq("Pjr.Id", projectRoleId))
		 							.list();

		 String message = "";
		 boolean updated = true;
		 boolean duplicateFlag = true;
		 try{
			 if(prjRoleWiseResourceToCkechList.size() == 0){

				 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				 hbt.setFlushModeName("FLUSH_EAGER");
				 hbt.setCheckWriteOperations(false);
				 PrjRolewiseResourceReq prjRolewiseResourceReq = (PrjRolewiseResourceReq)hbt.load(PrjRolewiseResourceReq.class, roleWiseresourceRequiredId);
				 prjRolewiseResourceReq.setCostPerHr(costPerHour);
				 prjRolewiseResourceReq.setLastChgBy(changedBy);
				 prjRolewiseResourceReq.setLastChgDate(currentDate);
				 prjRolewiseResourceReq.setLastChgTime(currentTime);
				 prjRolewiseResourceReq.setResCount(reqNo);

				 MstrProjectrole mstrProjectrole = new MstrProjectrole();
				 mstrProjectrole.setId(projectRoleId);
				 prjRolewiseResourceReq.setPjr(mstrProjectrole);

				 MstrProject mstrProject = new MstrProject();
				 mstrProject.setId(projectId);
				 prjRolewiseResourceReq.setPrj(mstrProject);
				 hbt.update(prjRolewiseResourceReq);
				 updated =  true;
				 duplicateFlag = false;
			 }
		 }catch(Exception exception){
			 updated = false;
			 exception.printStackTrace();
		 }
		if(updated){
			if(duplicateFlag){
				message = "Duplicate Entry For Role.";
			}else{
				message = "Data save Successfully.";
			}
		}else{
			message = "Some Problem Occured.";
		}
		map.put("message", message);
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		projectRoleList = session.createCriteria(MstrProjectrole.class).list();
		prjRoleWiseResourceList = session.createCriteria(PrjRolewiseResourceReq.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
		map.put("projectList", projectList);
		map.put("projectRoleList", projectRoleList);
		map.put("prjRoleWiseResourceList", prjRoleWiseResourceList);
		return map;
	}

	public Map<String, Object> showProjectCalendarJsp(int projectId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<ProjectCalendar> projectCalendarList = new ArrayList<ProjectCalendar>();
		List<MstrCalendar> calendarList = new ArrayList<MstrCalendar>();
		Session session = (Session)getSession();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		projectCalendarList = session.createCriteria(ProjectCalendar.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
		calendarList = session.createCriteria(MstrCalendar.class).add(Restrictions.eq("Status", "y")).list();
		map.put("projectList", projectList);
		map.put("projectCalendarList", projectCalendarList);
		map.put("calendarList", calendarList);
		return map;
	}
	public Map<String, Object> saveProjectCalendar(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<ProjectCalendar> projectCalendarList = new ArrayList<ProjectCalendar>();
		List<MstrCalendar> calendarList = new ArrayList<MstrCalendar>();
		Session session = (Session)getSession();
		int	hospitalId = 0;
		if(generalMap.get("hospitalId")!= null){
			hospitalId =(Integer)generalMap.get("hospitalId");
		}
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId =(Integer)generalMap.get("projectId");
		}
		int calendarId  = 0;
		if(generalMap.get("calendarId")!= null){
			calendarId =(Integer)generalMap.get("calendarId");
		}
		Date plannedDate= null;
		if(generalMap.get("plannedDate")!= null){
			plannedDate =(Date)generalMap.get("plannedDate");
		}
		String plannedRemark = "";
		if(generalMap.get("plannedRemark")!= null){
			plannedRemark =(String)generalMap.get("plannedRemark");
		}
		Date revisedDate= null;
		if(generalMap.get("revisedDate")!= null){
			revisedDate =(Date)generalMap.get("revisedDate");
		}
		String revisedRemark = "";
		if(generalMap.get("revisedRemark")!= null){
			revisedRemark =(String)generalMap.get("revisedRemark");
		}
		Date actualDate= null;
		if(generalMap.get("actualDate")!= null){
			actualDate =(Date)generalMap.get("actualDate");
		}
		String actualRemark = "";
		if(generalMap.get("actualRemark")!= null){
			actualRemark =(String)generalMap.get("actualRemark");
		}
		int noOfDays = 0;
		if(generalMap.get("noOfDays")!= null){
			noOfDays =(Integer)generalMap.get("noOfDays");
		}
		String changedBy  = "";
		 if(generalMap.get("changedBy")!= null){
			 changedBy =(String)generalMap.get("changedBy");
		 }
		 Date currentDate = new Date();
		 if(generalMap.get("currentDate")!= null){
			 currentDate =(Date)generalMap.get("currentDate");
		 }
		 String	currentTime = "";
		 if(generalMap.get("currentTime")!= null){
			 currentTime =(String)generalMap.get("currentTime");
		 }
		 ProjectCalendar projectCalendar = new ProjectCalendar();
		 projectCalendar.setPlannedDate(plannedDate);
		 projectCalendar.setPlannedRemark(plannedRemark);
		 projectCalendar.setActualDate(actualDate);
		 projectCalendar.setActualRemark(actualRemark);
		 projectCalendar.setRevisedDate(revisedDate);
		 projectCalendar.setRevisedRemark(revisedRemark);
		 projectCalendar.setNoOfDays(noOfDays);
		 projectCalendar.setLastChgBy(changedBy);
		 projectCalendar.setLastChgDate(currentDate);
		 projectCalendar.setLastChgTime(currentTime);
		 projectCalendar.setStatus("y");

		 MasHospital masHospital = new MasHospital();
		 masHospital.setId(hospitalId);
		 projectCalendar.setHospital(masHospital);

		 MstrCalendar mstrCalendar = new MstrCalendar();
		 mstrCalendar.setId(calendarId);
		 projectCalendar.setCalendar(mstrCalendar);

		 MstrProject mstrProject = new MstrProject();
		 mstrProject.setId(projectId);
		 projectCalendar.setPrj(mstrProject);
		 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.save(projectCalendar);
			String message = "";
			boolean saved = false;
			saved =  true;

			if(saved){
				message = "Data save Successfully.";
			}else{
				message = "Some Problem Occured.";
			}
			projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
			projectCalendarList = session.createCriteria(ProjectCalendar.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
			calendarList = session.createCriteria(MstrCalendar.class).add(Restrictions.eq("Status", "y")).list();
			map.put("projectList", projectList);
			map.put("projectCalendarList", projectCalendarList);
			map.put("calendarList", calendarList);
			map.put("message", message);
		return map;
	}

	public Map<String, Object> updateProjectCalendar(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<ProjectCalendar> projectCalendarList = new ArrayList<ProjectCalendar>();
		List<MstrCalendar> calendarList = new ArrayList<MstrCalendar>();
		Session session = (Session)getSession();
		int projectCalenderId = 0;
		if(generalMap.get("projectCalenderId")!= null){
			projectCalenderId =(Integer)generalMap.get("projectCalenderId");
		}
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId =(Integer)generalMap.get("projectId");
		}
		int calendarId  = 0;
		if(generalMap.get("calendarId")!= null){
			calendarId =(Integer)generalMap.get("calendarId");
		}
		Date plannedDate= null;
		if(generalMap.get("plannedDate")!= null){
			plannedDate =(Date)generalMap.get("plannedDate");
		}
		String plannedRemark = "";
		if(generalMap.get("plannedRemark")!= null){
			plannedRemark =(String)generalMap.get("plannedRemark");
		}
		Date revisedDate= null;
		if(generalMap.get("revisedDate")!= null){
			revisedDate =(Date)generalMap.get("revisedDate");
		}
		String revisedRemark = "";
		if(generalMap.get("revisedRemark")!= null){
			revisedRemark =(String)generalMap.get("revisedRemark");
		}
		Date actualDate= null;
		if(generalMap.get("actualDate")!= null){
			actualDate =(Date)generalMap.get("actualDate");
		}
		String actualRemark = "";
		if(generalMap.get("actualRemark")!= null){
			actualRemark =(String)generalMap.get("actualRemark");
		}
		int noOfDays = 0;
		if(generalMap.get("noOfDays")!= null){
			noOfDays =(Integer)generalMap.get("noOfDays");
		}
		String changedBy  = "";
		 if(generalMap.get("changedBy")!= null){
			 changedBy =(String)generalMap.get("changedBy");
		 }
		 Date currentDate = new Date();
		 if(generalMap.get("currentDate")!= null){
			 currentDate =(Date)generalMap.get("currentDate");
		 }
		 String	currentTime = "";
		 if(generalMap.get("currentTime")!= null){
			 currentTime =(String)generalMap.get("currentTime");
		 }
	 	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		 ProjectCalendar projectCalendar = (ProjectCalendar)hbt.load(ProjectCalendar.class, projectCalenderId);
		 projectCalendar.setActualDate(actualDate);
		 projectCalendar.setActualRemark(actualRemark);
		 projectCalendar.setLastChgBy(changedBy);
		 projectCalendar.setLastChgDate(currentDate);
		 projectCalendar.setLastChgTime(currentTime);
		 projectCalendar.setNoOfDays(noOfDays);
		 projectCalendar.setPlannedDate(plannedDate);
		 projectCalendar.setPlannedRemark(plannedRemark);
		 projectCalendar.setRevisedDate(revisedDate);
		 projectCalendar.setRevisedRemark(revisedRemark);

		 MstrProject mstrProject = new MstrProject();
		 mstrProject.setId(projectId);
		 projectCalendar.setPrj(mstrProject);

		 MstrCalendar mstrCalendar = new MstrCalendar();
		 mstrCalendar.setId(calendarId);
		 projectCalendar.setCalendar(mstrCalendar);
		 hbt.update(projectCalendar);
			String message = "";
			boolean updated = false;
			updated =  true;

			if(updated){
				message = "Data update Successfully.";
			}else{
				message = "Some Problem Occured.";
			}
			map.put("message", message);
			projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
			projectCalendarList = session.createCriteria(ProjectCalendar.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
			calendarList = session.createCriteria(MstrCalendar.class).add(Restrictions.eq("Status", "y")).list();
			map.put("projectList", projectList);
			map.put("projectCalendarList", projectCalendarList);
			map.put("calendarList", calendarList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showBudgetSettingJsp(int projectId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<MstrBudgetType> budgetTypeList = new ArrayList<MstrBudgetType>();
		List<MstrBudgetSubhead> budgetSubHeadList = new ArrayList<MstrBudgetSubhead>();
		List<MstrTaskType> taskTypeList = new ArrayList<MstrTaskType>();
		List<MstrTask> projectTaskList = new ArrayList<MstrTask>();
		List<MstrProjectrole> projectRoleList = new ArrayList<MstrProjectrole>();
		List<PrjBudgetSetting> prjBudgetsettingList = new ArrayList<PrjBudgetSetting>();
		List<PrjRolewiseResourceReq> prjRoleWiseResourceList = new ArrayList<PrjRolewiseResourceReq>();
		Session session = (Session)getSession();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		taskTypeList = session.createCriteria(MstrTaskType.class).add(Restrictions.eq("Status", "y")).list();
		projectTaskList = session.createCriteria(MstrTask.class).add(Restrictions.eq("Status", "y")).list();
		projectRoleList = session.createCriteria(MstrProjectrole.class).add(Restrictions.eq("Status", "y")).list();
		budgetTypeList = session.createCriteria(MstrBudgetType.class).add(Restrictions.eq("Status", "y")).list();
		budgetSubHeadList = session.createCriteria(MstrBudgetSubhead.class).add(Restrictions.eq("Status", "y")).list();
		prjBudgetsettingList = session.createCriteria(PrjBudgetSetting.class)
								.add(Restrictions.eq("Prj.Id", projectId))
								.list();
		prjRoleWiseResourceList = session.createCriteria(PrjRolewiseResourceReq.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
		projectRoleList = session.createCriteria(MstrProjectrole.class).add(Restrictions.eq("Status", "y")).list();
		map.put("projectList", projectList);
		map.put("taskTypeList", taskTypeList);
		map.put("projectTaskList", projectTaskList);
		map.put("projectRoleList", projectRoleList);
		map.put("prjBudgetsettingList", prjBudgetsettingList);
		map.put("budgetSubHeadList", budgetSubHeadList);
		map.put("budgetTypeList", budgetTypeList);
		map.put("prjRoleWiseResourceList", prjRoleWiseResourceList);
		return map;
	}
	public Map<String, Object> saveBudgetSetting(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PrjBudgetSetting> prjBudgetsettingList = new ArrayList<PrjBudgetSetting>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<MstrBudgetType> budgetTypeList = new ArrayList<MstrBudgetType>();
		List<MstrBudgetSubhead> budgetSubHeadList = new ArrayList<MstrBudgetSubhead>();
		List<MstrTaskType> taskTypeList = new ArrayList<MstrTaskType>();
		List<MstrTask> projectTaskList = new ArrayList<MstrTask>();
		List<MstrProjectrole> projectRoleList = new ArrayList<MstrProjectrole>();
		Session session = (Session)getSession();
		int	hospitalId = 0;
		if(generalMap.get("hospitalId")!= null){
			hospitalId =(Integer)generalMap.get("hospitalId");
		}
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId =(Integer)generalMap.get("projectId");
		}
		int budgetTypeId = 0;
		if(generalMap.get("budgetTypeId")!= null){
			budgetTypeId =(Integer)generalMap.get("budgetTypeId");
		}
		int budgetSubHeadId = 0;
		if(generalMap.get("budgetSubHeadId")!= null){
			budgetSubHeadId =(Integer)generalMap.get("budgetSubHeadId");
		}
		int taskTypeId = 0;
		if(generalMap.get("taskTypeId")!= null){
			taskTypeId =(Integer)generalMap.get("taskTypeId");
		}
		int taskId = 0;
		if(generalMap.get("taskId")!= null){
			taskId =(Integer)generalMap.get("taskId");
		}
		int projectRoleId = 0;
		if(generalMap.get("projectRoleId")!= null){
			projectRoleId =(Integer)generalMap.get("projectRoleId");
		}
		int requiredResource = 0;
		if(generalMap.get("requiredResource")!= null){
			requiredResource =(Integer)generalMap.get("requiredResource");
		}
		BigDecimal hrRequired = new BigDecimal("0");
		if(generalMap.get("hrRequired")!= null){
			hrRequired =(BigDecimal)generalMap.get("hrRequired");
		}

		BigDecimal costPerHr = new BigDecimal("0");
		if(generalMap.get("costPerHr")!= null){
			costPerHr =(BigDecimal)generalMap.get("costPerHr");
		}
		BigDecimal totalCost= new BigDecimal("0");
		if(generalMap.get("totalCost")!= null){
			totalCost =(BigDecimal)generalMap.get("totalCost");
		}
		String changedBy  = "";
		 if(generalMap.get("changedBy")!= null){
			 changedBy =(String)generalMap.get("changedBy");
		 }
		 Date currentDate = new Date();
		 if(generalMap.get("currentDate")!= null){
			 currentDate =(Date)generalMap.get("currentDate");
		 }
		 String	currentTime = "";
		 if(generalMap.get("currentTime")!= null){
			 currentTime =(String)generalMap.get("currentTime");
		 }
		 PrjBudgetSetting prjBudgetSetting = new PrjBudgetSetting();
		 prjBudgetSetting.setCostPerHr(costPerHr);
		 prjBudgetSetting.setLastChgBy(changedBy);
		 prjBudgetSetting.setLastChgDate(currentDate);
		 prjBudgetSetting.setLastChgTime(currentTime);
		 prjBudgetSetting.setReqHr(hrRequired);
		 prjBudgetSetting.setReqResource(requiredResource);
		 prjBudgetSetting.setTotlCost(totalCost);
		 prjBudgetSetting.setStatus("y");

		 MstrBudgetType mstrBudgetType = new MstrBudgetType();
		 mstrBudgetType.setId(budgetTypeId);
		 prjBudgetSetting.setBudtid(mstrBudgetType);

		 MstrBudgetSubhead mstrBudgetSubhead = new MstrBudgetSubhead();
		 mstrBudgetSubhead.setId(budgetSubHeadId);
		 prjBudgetSetting.setBudid(mstrBudgetSubhead);

		 MstrTaskType mstrTaskType = new MstrTaskType();
		 mstrTaskType.setId(taskTypeId);
		 prjBudgetSetting.setTaskType(mstrTaskType);

		 MstrTask mstrTask = new MstrTask();
		 mstrTask.setId(taskId);
		 prjBudgetSetting.setTask(mstrTask);

		 MstrProjectrole mstrProjectrole = new MstrProjectrole();
		 mstrProjectrole.setId(projectRoleId);
		 prjBudgetSetting.setPjr(mstrProjectrole);

		 MstrProject mstrProject = new MstrProject();
		 mstrProject.setId(projectId);
		 prjBudgetSetting.setPrj(mstrProject);

		 MasHospital masHospital = new MasHospital();
		 masHospital.setId(hospitalId);
		 prjBudgetSetting.setHospital(masHospital);
		 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.save(prjBudgetSetting);
			String message = "";
			boolean saved = false;
			saved =  true;

			if(saved){
				message = "Data save Successfully.";
			}else{
				message = "Some Problem Occured.";
			}
			projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
			taskTypeList = session.createCriteria(MstrTaskType.class).add(Restrictions.eq("Status", "y")).list();
			projectTaskList = session.createCriteria(MstrTask.class).add(Restrictions.eq("Status", "y")).list();
			projectRoleList = session.createCriteria(MstrProjectrole.class).add(Restrictions.eq("Status", "y")).list();
			budgetTypeList = session.createCriteria(MstrBudgetType.class).add(Restrictions.eq("Status", "y")).list();
			budgetSubHeadList = session.createCriteria(MstrBudgetSubhead.class).add(Restrictions.eq("Status", "y")).list();
			prjBudgetsettingList = session.createCriteria(PrjBudgetSetting.class).add(Restrictions.eq("Prj.Id", projectId)).list();
			map.put("projectList", projectList);
			map.put("taskTypeList", taskTypeList);
			map.put("projectTaskList", projectTaskList);
			map.put("projectRoleList", projectRoleList);
			map.put("prjBudgetsettingList", prjBudgetsettingList);
			map.put("budgetSubHeadList", budgetSubHeadList);
			map.put("budgetTypeList", budgetTypeList);
			map.put("message", message);
		return map;
	}
	public Map<String, Object> updateBudgetSetting(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<PrjBudgetSetting> prjBudgetsettingList = new ArrayList<PrjBudgetSetting>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<MstrBudgetType> budgetTypeList = new ArrayList<MstrBudgetType>();
		List<MstrBudgetSubhead> budgetSubHeadList = new ArrayList<MstrBudgetSubhead>();
		List<MstrTaskType> taskTypeList = new ArrayList<MstrTaskType>();
		List<MstrTask> projectTaskList = new ArrayList<MstrTask>();
		List<MstrProjectrole> projectRoleList = new ArrayList<MstrProjectrole>();
		Session session = (Session)getSession();
		int budgetSettingId = 0;
		if(generalMap.get("budgetSettingId")!= null){
			budgetSettingId =(Integer)generalMap.get("budgetSettingId");
		}

		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId =(Integer)generalMap.get("projectId");
		}
		int budgetTypeId = 0;
		if(generalMap.get("budgetTypeId")!= null){
			budgetTypeId =(Integer)generalMap.get("budgetTypeId");
		}
		int budgetSubHeadId = 0;
		if(generalMap.get("budgetSubHeadId")!= null){
			budgetSubHeadId =(Integer)generalMap.get("budgetSubHeadId");
		}
		int taskTypeId = 0;
		if(generalMap.get("taskTypeId")!= null){
			taskTypeId =(Integer)generalMap.get("taskTypeId");
		}
		int taskId = 0;
		if(generalMap.get("taskId")!= null){
			taskId =(Integer)generalMap.get("taskId");
		}
		int projectRoleId = 0;
		if(generalMap.get("projectRoleId")!= null){
			projectRoleId =(Integer)generalMap.get("projectRoleId");
		}
		int requiredResource = 0;
		if(generalMap.get("requiredResource")!= null){
			requiredResource =(Integer)generalMap.get("requiredResource");
		}
		BigDecimal hrRequired = new BigDecimal("0");
		if(generalMap.get("hrRequired")!= null){
			hrRequired =(BigDecimal)generalMap.get("hrRequired");
		}
		BigDecimal reqResourceIntoCostperHr = new BigDecimal("0");
		if(generalMap.get("reqResourceIntoCostperHr")!= null){
			reqResourceIntoCostperHr =(BigDecimal)generalMap.get("reqResourceIntoCostperHr");
		}
		BigDecimal costPerHr = new BigDecimal("0");
		if(generalMap.get("costPerHr")!= null){
			costPerHr =(BigDecimal)generalMap.get("costPerHr");
		}
		BigDecimal totalCost= new BigDecimal("0");
		if(generalMap.get("totalCost")!= null){
			totalCost =(BigDecimal)generalMap.get("totalCost");
		}
		String changedBy  = "";
		 if(generalMap.get("changedBy")!= null){
			 changedBy =(String)generalMap.get("changedBy");
		 }
		 Date currentDate = new Date();
		 if(generalMap.get("currentDate")!= null){
			 currentDate =(Date)generalMap.get("currentDate");
		 }
		 String	currentTime = "";
		 if(generalMap.get("currentTime")!= null){
			 currentTime =(String)generalMap.get("currentTime");
		 }
	 	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		PrjBudgetSetting prjBudgetSetting = (PrjBudgetSetting)hbt.load(PrjBudgetSetting.class, budgetSettingId);
		prjBudgetSetting.setCostPerHr(costPerHr);
		prjBudgetSetting.setLastChgBy(changedBy);
		prjBudgetSetting.setLastChgDate(currentDate);
		prjBudgetSetting.setLastChgTime(currentTime);
		prjBudgetSetting.setReqResource(requiredResource);
		prjBudgetSetting.setReqResourceIntoCostPerHr(reqResourceIntoCostperHr);
		prjBudgetSetting.setTotlCost(totalCost);

		MstrBudgetSubhead mstrBudgetSubhead = new MstrBudgetSubhead();
		mstrBudgetSubhead.setId(budgetSubHeadId);
		prjBudgetSetting.setBudid(mstrBudgetSubhead);

		MstrBudgetType mstrBudgetType = new MstrBudgetType();
		mstrBudgetType.setId(budgetTypeId);
		prjBudgetSetting.setBudtid(mstrBudgetType);

		MstrTask mstrTask = new MstrTask();
		mstrTask.setId(taskId);
		prjBudgetSetting.setTask(mstrTask);

		MstrTaskType mstrTaskType = new MstrTaskType();
		mstrTaskType.setId(taskTypeId);
		prjBudgetSetting.setTaskType(mstrTaskType);

		MstrProject mstrProject = new MstrProject();
		mstrProject.setId(projectId);
		prjBudgetSetting.setPrj(mstrProject);

		MstrProjectrole mstrProjectrole = new MstrProjectrole();
		mstrProjectrole.setId(projectRoleId);
		prjBudgetSetting.setPjr(mstrProjectrole);
		 hbt.update(prjBudgetSetting);
			String message = "";
			boolean updated = false;
			updated =  true;

			if(updated){
				message = "Data update Successfully.";
			}else{
				message = "Some Problem Occured.";
			}
			projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
			taskTypeList = session.createCriteria(MstrTaskType.class).add(Restrictions.eq("Status", "y")).list();
			projectTaskList = session.createCriteria(MstrTask.class).add(Restrictions.eq("Status", "y")).list();
			projectRoleList = session.createCriteria(MstrProjectrole.class).add(Restrictions.eq("Status", "y")).list();
			budgetTypeList = session.createCriteria(MstrBudgetType.class).add(Restrictions.eq("Status", "y")).list();
			budgetSubHeadList = session.createCriteria(MstrBudgetSubhead.class).add(Restrictions.eq("Status", "y")).list();
			prjBudgetsettingList = session.createCriteria(PrjBudgetSetting.class).add(Restrictions.eq("Prj.Id", projectId)).list();
			map.put("projectList", projectList);
			map.put("taskTypeList", taskTypeList);
			map.put("projectTaskList", projectTaskList);
			map.put("projectRoleList", projectRoleList);
			map.put("prjBudgetsettingList", prjBudgetsettingList);
			map.put("budgetSubHeadList", budgetSubHeadList);
			map.put("budgetTypeList", budgetTypeList);
			map.put("message", message);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showRoleResourceMappingJsp(int projectId) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjRolewiseResourceReq> prjRoleWiseResourceList = new ArrayList<PrjRolewiseResourceReq>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<PrjRoleResMappingHeader> roleResMappingHeaderList = new ArrayList<PrjRoleResMappingHeader>();
		List<MstrProjectrole> projectRoleList = new ArrayList<MstrProjectrole>();
		Session session = (Session)getSession();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		prjRoleWiseResourceList = session.createCriteria(PrjRolewiseResourceReq.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		roleResMappingHeaderList = session.createCriteria(PrjRoleResMappingHeader.class)
										.add(Restrictions.eq("Prj.Id", projectId))
										.list();
		projectRoleList = session.createCriteria(MstrProjectrole.class).add(Restrictions.eq("Status", "y")).list();
		map.put("prjRoleWiseResourceList", prjRoleWiseResourceList);
		map.put("projectList", projectList);
		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
		map.put("roleResMappingHeaderList", roleResMappingHeaderList);
		map.put("projectRoleList", projectRoleList);
		return map;
	}
	public Map<String, Object> saveRoleResourceMapping(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjRolewiseResourceReq> prjRoleWiseResourceList = new ArrayList<PrjRolewiseResourceReq>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<PrjRoleResMappingHeader> roleResMappingHeaderList = new ArrayList<PrjRoleResMappingHeader>();
		List<PrjRoleResMappingHeader> existingRoleResMappingHeaderList = new ArrayList<PrjRoleResMappingHeader>();
		List<MstrProjectrole> projectRoleList = new ArrayList<MstrProjectrole>();
		List<MstrTaskType> taskTypeList = new ArrayList<MstrTaskType>();
		List<MstrTask> projectTaskList = new ArrayList<MstrTask>();
		Session session = (Session)getSession();
		int	hospitalId = 0;
		if(generalMap.get("hospitalId")!= null){
			hospitalId =(Integer)generalMap.get("hospitalId");
		}
		int projectRoleId = 0;
		if(generalMap.get("projectRoleId")!= null){
			projectRoleId = (Integer)generalMap.get("projectRoleId");
		}
		/*float hrWorked= 0f;
		if(generalMap.get("hrWorked")!= null){
			hrWorked = (Float)generalMap.get("hrWorked");
		}*/
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId = (Integer)generalMap.get("projectId");
		}
		int employeeId= 0;
		if(generalMap.get("employeeId")!= null){
			employeeId = (Integer)generalMap.get("employeeId");
		}
		int departmentId= 0;
		if(generalMap.get("departmentId")!= null){
			departmentId = (Integer)generalMap.get("departmentId");
		}
		int requiredResource= 0;
		if(generalMap.get("requiredResource")!= null){
			requiredResource = (Integer)generalMap.get("requiredResource");
		}
		String changedBy  = "";
		 if(generalMap.get("changedBy")!= null){
			 changedBy =(String)generalMap.get("changedBy");
		 }
		 Date currentDate = new Date();
		 if(generalMap.get("currentDate")!= null){
			 currentDate =(Date)generalMap.get("currentDate");
		 }
		 String	currentTime = "";
		 if(generalMap.get("currentTime")!= null){
			 currentTime =(String)generalMap.get("currentTime");
		 }
			//====================
			existingRoleResMappingHeaderList = session.createCriteria(PrjRoleResMappingHeader.class)
				.add(Restrictions.eq("Prj.Id", projectId))
				.add(Restrictions.eq("Pjr.Id", projectRoleId))
				.add(Restrictions.eq("Employee.Id", employeeId))
				.list();

				//boolean saved = false;
				//boolean duplicateFlag = false;
				String message = "";

				if(existingRoleResMappingHeaderList.size() == 0){
					 PrjRoleResMappingHeader prjRoleResMappingHeader = new PrjRoleResMappingHeader();
					 prjRoleResMappingHeader.setLastChgBy(changedBy);
					 prjRoleResMappingHeader.setLastChgDate(currentDate);
					 prjRoleResMappingHeader.setLastChgTime(currentTime);
					 prjRoleResMappingHeader.setStatus("y");
					 prjRoleResMappingHeader.setRequiredResource(requiredResource);

					 MasDepartment masDepartment = new MasDepartment();
					 masDepartment.setId(departmentId);
					 prjRoleResMappingHeader.setDepartment(masDepartment);

					 MstrProject mstrProject = new MstrProject();
					 mstrProject.setId(projectId);
					 prjRoleResMappingHeader.setPrj(mstrProject);

					 MstrProjectrole mstrProjectrole = new MstrProjectrole();
					 mstrProjectrole.setId(projectRoleId);
					 prjRoleResMappingHeader.setPjr(mstrProjectrole);

					 MasHospital masHospital = new MasHospital();
					 masHospital.setId(hospitalId);
					 prjRoleResMappingHeader.setHospital(masHospital);

					 MasEmployee masEmployee = new MasEmployee();
					 masEmployee.setId(employeeId);
					 prjRoleResMappingHeader.setEmployee(masEmployee);
					// prjRoleResMappingHeader.setHrsWorked(new BigDecimal(hrWorked));
					 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
						hbt.setFlushModeName("FLUSH_AUTO");
						hbt.setCheckWriteOperations(false);
						hbt.save(prjRoleResMappingHeader);
						hbt.refresh(prjRoleResMappingHeader);
						message = "Record saved sucessfully!";
				}else {
					message = "Duplicate Entry of the Employee For this role!";

				}
				/*if(saved){
				if(duplicateFlag){
				message = "Duplicate Entry of the Employee For this role.";
				}else{
				message = "Data saved Successfully.";
				}
				}else{
				message = "Some Problem Occured.";
				}*/



			//============
			projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
			prjRoleWiseResourceList = session.createCriteria(PrjRolewiseResourceReq.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
			departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
			roleResMappingHeaderList = session.createCriteria(PrjRoleResMappingHeader.class).add(Restrictions.eq("Prj.Id", projectId)).list();
			projectRoleList = session.createCriteria(MstrProjectrole.class).add(Restrictions.eq("Status", "y")).list();


			map.put("prjRoleWiseResourceList", prjRoleWiseResourceList);
			map.put("projectList", projectList);
			map.put("departmentList", departmentList);
			map.put("employeeList", employeeList);
			map.put("roleResMappingHeaderList", roleResMappingHeaderList);
			map.put("projectRoleList", projectRoleList);
			map.put("message", message);

		   return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> updateRoleResourceMapping(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjRolewiseResourceReq> prjRoleWiseResourceList = new ArrayList<PrjRolewiseResourceReq>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<PrjRoleResMappingHeader> roleResMappingHeaderList = new ArrayList<PrjRoleResMappingHeader>();
		List<MstrProjectrole> projectRoleList = new ArrayList<MstrProjectrole>();
		Session session = (Session)getSession();
		int roleResourceMappingHeaderId = 0;
		if(generalMap.get("roleResourceMappingHeaderId")!= null){
			roleResourceMappingHeaderId =(Integer)generalMap.get("roleResourceMappingHeaderId");
		}
		int projectRoleId = 0;
		if(generalMap.get("projectRoleId")!= null){
			projectRoleId = (Integer)generalMap.get("projectRoleId");
		}
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId = (Integer)generalMap.get("projectId");
		}
		int employeeId= 0;
		if(generalMap.get("employeeId")!= null){
			employeeId = (Integer)generalMap.get("employeeId");
		}
		int departmentId= 0;
		if(generalMap.get("departmentId")!= null){
			departmentId = (Integer)generalMap.get("departmentId");
		}
		int requiredResource= 0;
		if(generalMap.get("requiredResource")!= null){
			requiredResource = (Integer)generalMap.get("requiredResource");
		}
		String changedBy  = "";
		 if(generalMap.get("changedBy")!= null){
			 changedBy =(String)generalMap.get("changedBy");
		 }
		 Date currentDate = new Date();
		 if(generalMap.get("currentDate")!= null){
			 currentDate =(Date)generalMap.get("currentDate");
		 }
		 String	currentTime = "";
		 if(generalMap.get("currentTime")!= null){
			 currentTime =(String)generalMap.get("currentTime");
		 }
		/* float hrWorked= 0f;
			if(generalMap.get("hrWorked")!= null){
				hrWorked = (Float)generalMap.get("hrWorked");
			}*/
		 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		 hbt.setFlushModeName("FLUSH_EAGER");
		 hbt.setCheckWriteOperations(false);
		 PrjRoleResMappingHeader prjRoleResMappingHeader = (PrjRoleResMappingHeader)hbt.load(PrjRoleResMappingHeader.class, roleResourceMappingHeaderId);
		 prjRoleResMappingHeader.setLastChgBy(changedBy);
		 prjRoleResMappingHeader.setLastChgDate(currentDate);
		 prjRoleResMappingHeader.setLastChgTime(currentTime);
		 prjRoleResMappingHeader.setStatus("y");
		 prjRoleResMappingHeader.setRequiredResource(requiredResource);
		 //prjRoleResMappingHeader.setHrsWorked(new BigDecimal(hrWorked));

		 MasDepartment masDepartment = new MasDepartment();
		 masDepartment.setId(departmentId);
		 prjRoleResMappingHeader.setDepartment(masDepartment);

		 MstrProject mstrProject = new MstrProject();
		 mstrProject.setId(projectId);
		 prjRoleResMappingHeader.setPrj(mstrProject);

		 MstrProjectrole mstrProjectrole = new MstrProjectrole();
		 mstrProjectrole.setId(projectRoleId);
		 prjRoleResMappingHeader.setPjr(mstrProjectrole);

		 MasEmployee masEmployee = new MasEmployee();
		 masEmployee.setId(employeeId);
		 prjRoleResMappingHeader.setEmployee(masEmployee);
		 hbt.update(prjRoleResMappingHeader);
			String message = "";
			boolean updated = false;
			updated =  true;

			if(updated){
				message = "Data update Successfully.";
			}else{
				message = "Some Problem Occured.";
			}

			projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
			prjRoleWiseResourceList = session.createCriteria(PrjRolewiseResourceReq.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
			departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
			roleResMappingHeaderList = session.createCriteria(PrjRoleResMappingHeader.class)
												.add(Restrictions.eq("Prj.Id", projectId))
												.list();
			projectRoleList = session.createCriteria(MstrProjectrole.class).add(Restrictions.eq("Status", "y")).list();
			map.put("prjRoleWiseResourceList", prjRoleWiseResourceList);
			map.put("projectList", projectList);
			map.put("departmentList", departmentList);
			map.put("employeeList", employeeList);
			map.put("roleResMappingHeaderList", roleResMappingHeaderList);
			map.put("projectRoleList", projectRoleList);
			map.put("message", message);
		return map;
	}
	public Map<String, Object> showTaskSettingForProjectRole(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjRoleResMappingHeader> roleResMappingHeaderList = new ArrayList<PrjRoleResMappingHeader>();
		List<MstrRoleTaskMap>roleTaskMappingList = new ArrayList<MstrRoleTaskMap>();
		List<MstrTaskType> taskTypeList = new ArrayList<MstrTaskType>();
		List<MstrTask> taskList = new ArrayList<MstrTask>();
		List<PrjRoleResMappingDetail> prjRoleResourceMappingDetailList = new ArrayList<PrjRoleResMappingDetail>();
		Session session = (Session)getSession();
		int roleResourceHeaderId = 0;
		if(generalMap.get("roleResourceHeaderId")!= null){;
		roleResourceHeaderId = (Integer)generalMap.get("roleResourceHeaderId");
		}

		int projectId = 0;
		if(generalMap.get("projectId")!= null){;
		projectId = (Integer)generalMap.get("projectId");
		}
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		roleResMappingHeaderList = session.createCriteria(PrjRoleResMappingHeader.class).add(Restrictions.idEq(roleResourceHeaderId)).list();
		int rankId = 0;
		if(roleResMappingHeaderList.size()>0){
			for(PrjRoleResMappingHeader roleResMappingHeader :roleResMappingHeaderList){
				rankId = roleResMappingHeader.getEmployee().getRank().getId();
			}
		}
		prjRoleResourceMappingDetailList = session.createCriteria(PrjRoleResMappingDetail.class).createAlias("RoleResMappingHeader", "header").add(Restrictions.eq("header.Id", roleResourceHeaderId)).list();
		roleTaskMappingList = session.createCriteria(MstrRoleTaskMap.class).createAlias("Rank", "rank").add(Restrictions.eq("rank.Id",rankId)).list();
		taskTypeList = session.createCriteria(MstrTaskType.class).add(Restrictions.eq("Status", "y")).list();
		taskList = session.createCriteria(MstrTask.class).add(Restrictions.eq("Status", "y")).list();
		map.put("projectList", projectList);
		map.put("roleTaskMappingList", roleTaskMappingList);
		map.put("roleResMappingHeaderList", roleResMappingHeaderList);
		map.put("taskTypeList", taskTypeList);
		map.put("taskList", taskList);
		map.put("prjRoleResourceMappingDetailList", prjRoleResourceMappingDetailList);
		return map;
	}
	public Map<String, Object> saveAssignTaskToRoleResourceHeader(Map<String, Object> generalMap) {
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		Map<String, Object> map =new HashMap<String, Object>();
		List<PrjRoleResMappingHeader> roleResMappingHeaderList = new ArrayList<PrjRoleResMappingHeader>();
		List<MstrRoleTaskMap>roleTaskMappingList = new ArrayList<MstrRoleTaskMap>();
		List<MstrTaskType> taskTypeList = new ArrayList<MstrTaskType>();
		List<MstrTask> taskList = new ArrayList<MstrTask>();
		List<PrjRoleResMappingDetail> prjRoleResourceMappingDetailList = new ArrayList<PrjRoleResMappingDetail>();
		List<PrjRoleResMappingDetail> duplicatePrjRoleResourceMappingDetailList = new ArrayList<PrjRoleResMappingDetail>();
		Session session = (Session)getSession();
		int roleResourceHeaderId = 0;
		if(generalMap.get("roleResourceHeaderId")!= null){;
		roleResourceHeaderId = (Integer)generalMap.get("roleResourceHeaderId");
		}
		int projectId = 0;
		if(generalMap.get("projectId")!= null){;
		projectId = (Integer)generalMap.get("projectId");
		}
		roleResMappingHeaderList = session.createCriteria(PrjRoleResMappingHeader.class).add(Restrictions.idEq(roleResourceHeaderId)).list();
		int rankId = 0;
		if(roleResMappingHeaderList.size()>0){
			for(PrjRoleResMappingHeader roleResMappingHeader :roleResMappingHeaderList){
				rankId = roleResMappingHeader.getEmployee().getRank().getId();
			}
		}
		roleTaskMappingList = session.createCriteria(MstrRoleTaskMap.class).createAlias("Rank", "rank").add(Restrictions.eq("rank.Id",rankId)).list();
		int taskId = 0;
		int taskTypeId = 0;
		String message = "";
		if(roleTaskMappingList.size()>0){
			for(MstrRoleTaskMap mstrRoleTaskMap :roleTaskMappingList ){
				 taskId = mstrRoleTaskMap.getTask().getId();
				 taskTypeId = mstrRoleTaskMap.getTask().getTaskType().getId();
				 PrjRoleResMappingDetail prjRoleResMappingDetail = new PrjRoleResMappingDetail();
				 MstrTaskType mstrTaskType = new MstrTaskType();
				 mstrTaskType.setId(taskTypeId);
				 prjRoleResMappingDetail.setTaskType(mstrTaskType);
				 MstrTask mstrTask = new MstrTask();
				 mstrTask.setId(taskId);
				 prjRoleResMappingDetail.setTask(mstrTask);
				 prjRoleResMappingDetail.setTypeOfTask("D");
				 prjRoleResMappingDetail.setStatus("y");
				 PrjRoleResMappingHeader prjRoleResMappingHeader = new PrjRoleResMappingHeader();
				 prjRoleResMappingHeader.setId(roleResourceHeaderId);
				 prjRoleResMappingDetail.setRoleResMappingHeader(prjRoleResMappingHeader);
				 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				 hbt.setFlushModeName("FLUSH_AUTO");
				 hbt.setCheckWriteOperations(false);
				 duplicatePrjRoleResourceMappingDetailList = session.createCriteria(PrjRoleResMappingDetail.class).createAlias("RoleResMappingHeader", "header").add(Restrictions.eq("header.Id", roleResourceHeaderId)).createAlias("Task", "task").add(Restrictions.eq("task.Id", taskId)).list();
				 if(duplicatePrjRoleResourceMappingDetailList.size()>0){
						message = "Task Already Assigned";
					}else{
						hbt.save(prjRoleResMappingDetail);
						message = "Record saved sucessfully!";
					}
			}

		}
		roleResMappingHeaderList = session.createCriteria(PrjRoleResMappingHeader.class).add(Restrictions.idEq(roleResourceHeaderId)).list();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		taskTypeList = session.createCriteria(MstrTaskType.class).add(Restrictions.eq("Status", "y")).list();
		taskList = session.createCriteria(MstrTask.class).add(Restrictions.eq("Status", "y")).list();
		prjRoleResourceMappingDetailList = session.createCriteria(PrjRoleResMappingDetail.class).createAlias("RoleResMappingHeader", "header").add(Restrictions.eq("header.Id", roleResourceHeaderId)).list();
		map.put("prjRoleResourceMappingDetailList", prjRoleResourceMappingDetailList);
		map.put("taskList", taskList);
		map.put("taskTypeList", taskTypeList);
		map.put("projectList", projectList);
		map.put("message", message);
		map.put("roleResMappingHeaderList", roleResMappingHeaderList);
		return map;
	}
	public Map<String, Object> saveTaskInRoleResourceMappingDetail(Map<String, Object> generalMap) {
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		Map<String, Object> map =new HashMap<String, Object>();
		List<PrjRoleResMappingHeader> roleResMappingHeaderList = new ArrayList<PrjRoleResMappingHeader>();
		List<MstrRoleTaskMap>roleTaskMappingList = new ArrayList<MstrRoleTaskMap>();
		List<MstrTaskType> taskTypeList = new ArrayList<MstrTaskType>();
		List<MstrTask> taskList = new ArrayList<MstrTask>();
		List<PrjRoleResMappingDetail> prjRoleResourceMappingDetailList = new ArrayList<PrjRoleResMappingDetail>();
		List<PrjRoleResMappingDetail> duplicatePrjRoleResourceMappingDetailList = new ArrayList<PrjRoleResMappingDetail>();
		Session session = (Session)getSession();

		int roleResourceHeaderId = 0;
		if(generalMap.get("roleResourceHeaderId")!= null){;
		roleResourceHeaderId = (Integer)generalMap.get("roleResourceHeaderId");
		}
		int projectId = 0;
		if(generalMap.get("projectId")!= null){;
		projectId = (Integer)generalMap.get("projectId");
		}
		int taskId  = 0;
		if(generalMap.get("taskId")!= null){;
		taskId = (Integer)generalMap.get("taskId");
		}
		int taskTypeId = 0;
		if(generalMap.get("taskTypeId")!= null){;
		taskTypeId = (Integer)generalMap.get("taskTypeId");
		}
		String billable = "";
		if(generalMap.get("billable")!= null){;
		billable = (String)generalMap.get("billable");
		}
		String message = "";
		 PrjRoleResMappingDetail prjRoleResMappingDetail = new PrjRoleResMappingDetail();
		 MstrTaskType mstrTaskType = new MstrTaskType();
		 mstrTaskType.setId(taskTypeId);
		 prjRoleResMappingDetail.setTaskType(mstrTaskType);
		 MstrTask mstrTask = new MstrTask();
		 mstrTask.setId(taskId);
		 prjRoleResMappingDetail.setTask(mstrTask);
		 prjRoleResMappingDetail.setTypeOfTask("A");
		 prjRoleResMappingDetail.setStatus("y");
		 prjRoleResMappingDetail.setBillable(billable);
		 PrjRoleResMappingHeader prjRoleResMappingHeader = new PrjRoleResMappingHeader();
		 prjRoleResMappingHeader.setId(roleResourceHeaderId);
		 prjRoleResMappingDetail.setRoleResMappingHeader(prjRoleResMappingHeader);
		 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		 hbt.setFlushModeName("FLUSH_AUTO");
		 hbt.setCheckWriteOperations(false);
		 duplicatePrjRoleResourceMappingDetailList = session.createCriteria(PrjRoleResMappingDetail.class).createAlias("RoleResMappingHeader", "header").add(Restrictions.eq("header.Id", roleResourceHeaderId)).createAlias("Task", "task").add(Restrictions.eq("task.Id", taskId)).list();
		 if(duplicatePrjRoleResourceMappingDetailList.size()>0){
				message = "Task Already Assigned";
			}else{
				hbt.save(prjRoleResMappingDetail);
				message = "Record saved sucessfully!";
			}
		  roleResMappingHeaderList = session.createCriteria(PrjRoleResMappingHeader.class).add(Restrictions.idEq(roleResourceHeaderId)).list();
		 	projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
			taskTypeList = session.createCriteria(MstrTaskType.class).add(Restrictions.eq("Status", "y")).list();
			taskList = session.createCriteria(MstrTask.class).add(Restrictions.eq("Status", "y")).list();
			prjRoleResourceMappingDetailList = session.createCriteria(PrjRoleResMappingDetail.class).createAlias("RoleResMappingHeader", "header").add(Restrictions.eq("header.Id", roleResourceHeaderId)).list();
			map.put("prjRoleResourceMappingDetailList", prjRoleResourceMappingDetailList);
			map.put("taskList", taskList);
			map.put("taskTypeList", taskTypeList);
			map.put("projectList", projectList);
			map.put("message", message);
			map.put("roleResMappingHeaderList", roleResMappingHeaderList);
		return map;
	}
	public Map<String, Object> updateTaskInRoleResourceMappingDetail(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjRoleResMappingHeader> roleResMappingHeaderList = new ArrayList<PrjRoleResMappingHeader>();
		List<MstrRoleTaskMap>roleTaskMappingList = new ArrayList<MstrRoleTaskMap>();
		List<MstrTaskType> taskTypeList = new ArrayList<MstrTaskType>();
		List<MstrTask> taskList = new ArrayList<MstrTask>();
		List<PrjRoleResMappingDetail> prjRoleResourceMappingDetailList = new ArrayList<PrjRoleResMappingDetail>();
		Session session = (Session)getSession();
		int roleResourceDetailId = 0;
		if(generalMap.get("roleResourceDetailId")!= null){;
		roleResourceDetailId = (Integer)generalMap.get("roleResourceDetailId");
		}
		int roleResourceHeaderId = 0;
		if(generalMap.get("roleResourceHeaderId")!= null){;
		roleResourceHeaderId = (Integer)generalMap.get("roleResourceHeaderId");
		}
		int projectId = 0;
		if(generalMap.get("projectId")!= null){;
		projectId = (Integer)generalMap.get("projectId");
		}
		int taskId  = 0;
		if(generalMap.get("taskId")!= null){;
		taskId = (Integer)generalMap.get("taskId");
		}
		int taskTypeId = 0;
		if(generalMap.get("taskTypeId")!= null){;
		taskTypeId = (Integer)generalMap.get("taskTypeId");
		}
		String billable = "";
		if(generalMap.get("billable")!= null){;
		billable = (String)generalMap.get("billable");
		}
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		 hbt.setFlushModeName("FLUSH_EAGER");
		 hbt.setCheckWriteOperations(false);
		 PrjRoleResMappingDetail prjRoleResMappingDetail = (PrjRoleResMappingDetail)hbt.load(PrjRoleResMappingDetail.class, roleResourceDetailId);
		 MstrTaskType mstrTaskType = new MstrTaskType();
		 mstrTaskType.setId(taskTypeId);
		 prjRoleResMappingDetail.setTaskType(mstrTaskType);
		 MstrTask mstrTask = new MstrTask();
		 mstrTask.setId(taskId);
		 prjRoleResMappingDetail.setTask(mstrTask);
		 prjRoleResMappingDetail.setTypeOfTask("A");
		 prjRoleResMappingDetail.setStatus("y");
		 prjRoleResMappingDetail.setBillable(billable);
		 PrjRoleResMappingHeader prjRoleResMappingHeader = new PrjRoleResMappingHeader();
		 prjRoleResMappingHeader.setId(roleResourceHeaderId);
		 prjRoleResMappingDetail.setRoleResMappingHeader(prjRoleResMappingHeader);
		 hbt.update(prjRoleResMappingDetail);
			boolean updated = false;
			updated =  true;

			if(updated){
				message = "Data update Successfully.";
			}else{
				message = "Some Problem Occured.";
			}
			roleResMappingHeaderList = session.createCriteria(PrjRoleResMappingHeader.class).add(Restrictions.idEq(roleResourceHeaderId)).list();
		 	projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
			taskTypeList = session.createCriteria(MstrTaskType.class).add(Restrictions.eq("Status", "y")).list();
			taskList = session.createCriteria(MstrTask.class).add(Restrictions.eq("Status", "y")).list();
			prjRoleResourceMappingDetailList = session.createCriteria(PrjRoleResMappingDetail.class).createAlias("RoleResMappingHeader", "header").add(Restrictions.eq("header.Id", roleResourceHeaderId)).list();

			map.put("prjRoleResourceMappingDetailList", prjRoleResourceMappingDetailList);
			map.put("taskList", taskList);
			map.put("taskTypeList", taskTypeList);
			map.put("projectList", projectList);
			map.put("message", message);
			map.put("roleResMappingHeaderList", roleResMappingHeaderList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showFeasibilityStudyJsp(int projectId) {
		Map<String, Object> map =new HashMap<String, Object>();
			List<MstrProject> projectList = new ArrayList<MstrProject>();
			List<Integer> piDetailList = new ArrayList<Integer>();
			List<MstrPiHeader> piHeaderList = new ArrayList<MstrPiHeader>();
			List<MstrPiHeader> tempList = new ArrayList<MstrPiHeader>();
			List<PrjFesStudyHeader> feasibilityHeaderList = new ArrayList<PrjFesStudyHeader>();
			List<MstrRating> ratingList = new ArrayList<MstrRating>();
			List<MstrPiHeader>mstrPiHeaderList = new ArrayList<MstrPiHeader>();
			Session session = (Session)getSession();
			projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
			int thpId = 0;
			for(MstrProject mstrProject :projectList){
				thpId = mstrProject.getThp().getId();
			}
			piDetailList = session.createCriteria(MstrPiDetail.class).createAlias("Thp", "thp").add(Restrictions.eq("thp.Id", thpId))
								.createAlias("PiHeader", "ph").setProjection( Projections.projectionList()
									      .add( Projections.distinct(Projections.property("ph.Id")) ) ).list();
			int piHeaderId = 0;

			if(piDetailList.size()>0){
				for(int i=0; i<piDetailList.size();i++){
					piHeaderId = piDetailList.get(i);
					piHeaderList = session.createCriteria(MstrPiHeader.class).add(Restrictions.idEq(piHeaderId)).list();
					tempList.add(piHeaderList.get(0));
				}
			}
			 feasibilityHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
			 ratingList = session.createCriteria(MstrRating.class).list();
			 mstrPiHeaderList = session.createCriteria(MstrPiHeader.class).add(Restrictions.eq("Status", "y")).list();
			map.put("tempList", tempList);
			map.put("projectList", projectList);
			map.put("piHeaderList", piHeaderList);
			map.put("feasibilityHeaderList", feasibilityHeaderList);
			map.put("ratingList", ratingList);
			map.put("mstrPiHeaderList", mstrPiHeaderList);
			return map;
		}

	public Map<String, Object> saveSelectedDoctors(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<PrjFesStudyHeader> feasibilityHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<PrjFesStudyHeader> duplicatFeasibilityHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<MstrRating> ratingList = new ArrayList<MstrRating>();
		List<MstrProject>projectList = new ArrayList<MstrProject>();
		List<MstrPiHeader>mstrPiHeaderList = new ArrayList<MstrPiHeader>();
		List<Integer> piDetailList = new ArrayList<Integer>();
		List<MstrPiHeader> piHeaderList = new ArrayList<MstrPiHeader>();
		List<MstrPiHeader> tempList = new ArrayList<MstrPiHeader>();
		Session session = (Session)getSession();
		int projectId = 0;
		if(generalMap.get("projectId")!= null){;
		projectId = (Integer)generalMap.get("projectId");
		}
		int piHeaderId = 0;
		if(generalMap.get("piHeaderId")!= null){;
		piHeaderId = (Integer)generalMap.get("piHeaderId");
		}
		String piStatus= "";
		 if(generalMap.get("piStatus")!= null){
			 piStatus =(String)generalMap.get("piStatus");
		 }
		String changedBy  = "";
		 if(generalMap.get("changedBy")!= null){
			 changedBy =(String)generalMap.get("changedBy");
		 }
		 Date currentDate = new Date();
		 if(generalMap.get("currentDate")!= null){
			 currentDate =(Date)generalMap.get("currentDate");
		 }
		 String	currentTime = "";
		 if(generalMap.get("currentTime")!= null){
			 currentTime =(String)generalMap.get("currentTime");
		 }
		 PrjFesStudyHeader prjFesStudyHeader = new PrjFesStudyHeader();
		 prjFesStudyHeader.setLastChgBy(changedBy);
		 prjFesStudyHeader.setLastChgDate(currentDate);
		 prjFesStudyHeader.setLastChgTime(currentTime);
		 prjFesStudyHeader.setStatus("y");
		 prjFesStudyHeader.setPiStatus(piStatus);

		 MstrPiHeader mstrPiHeader = new MstrPiHeader();
		 mstrPiHeader.setId(piHeaderId);
		 prjFesStudyHeader.setPiHeader(mstrPiHeader);

		 MstrProject mstrProject = new MstrProject();
		 mstrProject.setId(projectId);
		 prjFesStudyHeader.setPrj(mstrProject);

		 String message = "";
		 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		 hbt.setFlushModeName("FLUSH_AUTO");
		 hbt.setCheckWriteOperations(false);
		 duplicatFeasibilityHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("PiHeader", "piH").add(Restrictions.eq("piH.Id", piHeaderId)).list();
		 if(duplicatFeasibilityHeaderList.size()>0){
				message = "Pi Already Assigned";
			}else{
				hbt.save(prjFesStudyHeader);
				message = "Record saved sucessfully!";
			}
		 projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		 int thpId = 0;
			for(MstrProject mstrProject1 :projectList){
				thpId = mstrProject1.getThp().getId();
			}
			piDetailList = session.createCriteria(MstrPiDetail.class).createAlias("Thp", "thp").add(Restrictions.eq("thp.Id", thpId))
								.createAlias("PiHeader", "ph").setProjection( Projections.projectionList()
									      .add( Projections.distinct(Projections.property("ph.Id")) ) ).list();
			int piHeaderId1 = 0;

			if(piDetailList.size()>0){
				for(int i=0; i<piDetailList.size();i++){
					piHeaderId1 = piDetailList.get(i);
					piHeaderList = session.createCriteria(MstrPiHeader.class).add(Restrictions.idEq(piHeaderId1)).list();
					tempList.add(piHeaderList.get(0));
				}
			}
			feasibilityHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
		 ratingList = session.createCriteria(MstrRating.class).list();

		 mstrPiHeaderList = session.createCriteria(MstrPiHeader.class).add(Restrictions.eq("Status", "y")).list();
		 map.put("feasibilityHeaderList", feasibilityHeaderList);
		 map.put("ratingList", ratingList);
		 map.put("mstrPiHeaderList", mstrPiHeaderList);
		 map.put("projectList", projectList);
		 map.put("message", message);
		 map.put("tempList", tempList);
		map.put("piHeaderList", piHeaderList);
		return map;
	}
	public Map<String, Object> updateSelectedPi(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<PrjFesStudyHeader> feasibilityHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<PrjFesStudyHeader> duplicatFeasibilityHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<MstrRating> ratingList = new ArrayList<MstrRating>();
		List<MstrProject>projectList = new ArrayList<MstrProject>();
		List<MstrPiHeader>mstrPiHeaderList = new ArrayList<MstrPiHeader>();
		List<Integer> piDetailList = new ArrayList<Integer>();
		List<MstrPiHeader> piHeaderList = new ArrayList<MstrPiHeader>();
		List<MstrPiHeader> tempList = new ArrayList<MstrPiHeader>();
		Session session = (Session)getSession();
		int feasibilityStudyHeaderId = 0;
		if(generalMap.get("feasibilityStudyHeaderId")!= null){;
		feasibilityStudyHeaderId = (Integer)generalMap.get("feasibilityStudyHeaderId");
		}
		int projectId = 0;
		if(generalMap.get("projectId")!= null){;
		projectId = (Integer)generalMap.get("projectId");
		}
		int piHeaderId = 0;
		if(generalMap.get("piHeaderId")!= null){;
		piHeaderId = (Integer)generalMap.get("piHeaderId");
		}
		String piStatus= "";
		 if(generalMap.get("piStatus")!= null){
			 piStatus =(String)generalMap.get("piStatus");
		 }
		String changedBy  = "";
		 if(generalMap.get("changedBy")!= null){
			 changedBy =(String)generalMap.get("changedBy");
		 }
		 Date currentDate = new Date();
		 if(generalMap.get("currentDate")!= null){
			 currentDate =(Date)generalMap.get("currentDate");
		 }
		 String	currentTime = "";
		 if(generalMap.get("currentTime")!= null){
			 currentTime =(String)generalMap.get("currentTime");
		 }
		 String message = "";
		 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		 hbt.setFlushModeName("FLUSH_EAGER");
		 hbt.setCheckWriteOperations(false);
		 PrjFesStudyHeader prjFesStudyHeader= (PrjFesStudyHeader)hbt.load(PrjFesStudyHeader.class, feasibilityStudyHeaderId);
		 prjFesStudyHeader.setLastChgBy(changedBy);
		 prjFesStudyHeader.setLastChgDate(currentDate);
		 prjFesStudyHeader.setLastChgTime(currentTime);
		 prjFesStudyHeader.setPiStatus(piStatus);

		 MstrPiHeader mstrPiHeader = new MstrPiHeader();
		 mstrPiHeader.setId(piHeaderId);
		 prjFesStudyHeader.setPiHeader(mstrPiHeader);

		 MstrProject mstrProject = new MstrProject();
		 mstrProject.setId(projectId);
		 prjFesStudyHeader.setPrj(mstrProject);
		 hbt.update(prjFesStudyHeader);
		 //duplicatFeasibilityHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("PiHeader", "piH").add(Restrictions.eq("piH.Id", piHeaderId)).list();
			boolean updated = false;
			updated =  true;

			if(updated){
				message = "Data update Successfully.";
			}else{
				message = "Some Problem Occured.";
			}
		 projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		 int thpId = 0;
			for(MstrProject mstrProject1 :projectList){
				thpId = mstrProject1.getThp().getId();
			}
			piDetailList = session.createCriteria(MstrPiDetail.class).createAlias("Thp", "thp").add(Restrictions.eq("thp.Id", thpId))
								.createAlias("PiHeader", "ph").setProjection( Projections.projectionList()
									      .add( Projections.distinct(Projections.property("ph.Id")) ) ).list();
			int piHeaderId1 = 0;

			if(piDetailList.size()>0){
				for(int i=0; i<piDetailList.size();i++){
					piHeaderId1 = piDetailList.get(i);
					piHeaderList = session.createCriteria(MstrPiHeader.class).add(Restrictions.idEq(piHeaderId1)).list();
					tempList.add(piHeaderList.get(0));
				}
			}
			feasibilityHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
		 ratingList = session.createCriteria(MstrRating.class).list();

		 mstrPiHeaderList = session.createCriteria(MstrPiHeader.class).add(Restrictions.eq("Status", "y")).list();
		 map.put("feasibilityHeaderList", feasibilityHeaderList);
		 map.put("ratingList", ratingList);
		 map.put("mstrPiHeaderList", mstrPiHeaderList);
		 map.put("projectList", projectList);
		 map.put("message", message);
		 map.put("tempList", tempList);
		 map.put("piHeaderList", piHeaderList);
		return map;
	}

	public Map<String, Object> getCallPiDetailForAjax(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<PrjFesStudyHeader> feasibilityHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<PrjFesStudyDetail> feasibilityStudyDetailList = new ArrayList<PrjFesStudyDetail>();
		int feasibiltyStudyId = 0;
		if(generalMap.get("feasibiltyStudyId")!= null){
			feasibiltyStudyId = (Integer)generalMap.get("feasibiltyStudyId");
		}
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId = (Integer)generalMap.get("projectId");
		}
		Session session = (Session)getSession();
		feasibilityStudyDetailList = session.createCriteria(PrjFesStudyDetail.class).createAlias("FesStudyHeader", "fHeader").add(Restrictions.eq("fHeader.Id", feasibiltyStudyId)).list();
		feasibilityHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
		map.put("feasibilityStudyDetailList", feasibilityStudyDetailList);
		 map.put("feasibilityHeaderList", feasibilityHeaderList);
		return map;
	}

	public Map<String, Object> saveDoctorsCallDetail(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<PrjFesStudyDetail> feasibilityStudyDetailList = new ArrayList<PrjFesStudyDetail>();
		List<PrjFesStudyHeader> feasibilityHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<PrjFesStudyHeader> duplicatFeasibilityHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<MstrRating> ratingList = new ArrayList<MstrRating>();
		List<MstrProject>projectList = new ArrayList<MstrProject>();
		List<MstrPiHeader>mstrPiHeaderList = new ArrayList<MstrPiHeader>();
		List<Integer> piDetailList = new ArrayList<Integer>();
		List<MstrPiHeader> piHeaderList = new ArrayList<MstrPiHeader>();
		List<MstrPiHeader> tempList = new ArrayList<MstrPiHeader>();

		int feasibilityStudyHeaderId = 0;
		if(generalMap.get("feasibilityStudyHeaderId")!= null){;
		feasibilityStudyHeaderId = (Integer)generalMap.get("feasibilityStudyHeaderId");
		}
		int projectId = 0;
		if(generalMap.get("projectId")!= null){;
		projectId = (Integer)generalMap.get("projectId");
		}
		Date calDate = null;
		if(generalMap.get("calDate")!= null){;
		calDate = (Date)generalMap.get("calDate");
		}
		String comments  = "";
		if(generalMap.get("comments")!= null){;
		comments = (String)generalMap.get("comments");
		}
		PrjFesStudyDetail prjFesStudyDetail = new PrjFesStudyDetail();
		prjFesStudyDetail.setCallDate(calDate);
		prjFesStudyDetail.setCallResponse(comments);

		PrjFesStudyHeader prjFesStudyHeader = new PrjFesStudyHeader();
		prjFesStudyHeader.setId(feasibilityStudyHeaderId);
		prjFesStudyDetail.setFesStudyHeader(prjFesStudyHeader);
		prjFesStudyDetail.setStatus("y");
		 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.save(prjFesStudyDetail);
			String message = "";
			boolean saved = false;
			saved =  true;

			if(saved){
				message = "Data save Successfully.";
			}else{
				message = "Some Problem Occured.";
			}
			Session session = (Session)getSession();

			feasibilityStudyDetailList = session.createCriteria(PrjFesStudyDetail.class).createAlias("FesStudyHeader", "fHeader").add(Restrictions.eq("fHeader.Id", feasibilityStudyHeaderId)).list();
			feasibilityHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
			 ratingList = session.createCriteria(MstrRating.class).list();
			 projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
			 mstrPiHeaderList = session.createCriteria(MstrPiHeader.class).add(Restrictions.eq("Status", "y")).list();
				int thpId = 0;
				for(MstrProject mstrProject :projectList){
					thpId = mstrProject.getThp().getId();
				}

			 piDetailList = session.createCriteria(MstrPiDetail.class).createAlias("Thp", "thp").add(Restrictions.eq("thp.Id", thpId))
				.createAlias("PiHeader", "ph").setProjection( Projections.projectionList()
					      .add( Projections.distinct(Projections.property("ph.Id")) ) ).list();

			 int piHeaderId = 0;

				if(piDetailList.size()>0){
					for(int i=0; i<piDetailList.size();i++){
						piHeaderId = piDetailList.get(i);
						piHeaderList = session.createCriteria(MstrPiHeader.class).add(Restrictions.idEq(piHeaderId)).list();
						tempList.add(piHeaderList.get(0));
					}
				}
			map.put("tempList", tempList);
			 map.put("feasibilityHeaderList", feasibilityHeaderList);
			 map.put("ratingList", ratingList);
			 map.put("mstrPiHeaderList", mstrPiHeaderList);
			 map.put("projectList", projectList);
			 map.put("message", message);
			map.put("feasibilityStudyDetailList", feasibilityStudyDetailList);
		return map;
	}

	public Map<String, Object> addSiteDetailForPi(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PrjFesStudyHeader> feasibilityHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<MstrSiteDetail> siteDetailList = new ArrayList<MstrSiteDetail>();
		List<MstrProject>projectList = new ArrayList<MstrProject>();
		List<MstrSiteHeader> siteHeaderList = new ArrayList<MstrSiteHeader>();
		List<MstrTherapeutic> therapeuticList = new ArrayList<MstrTherapeutic>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Session session = (Session)getSession();
		int feasibilityStudyHeaderId = 0;
		if(generalMap.get("feasibilityStudyHeaderId")!= null){;
		feasibilityStudyHeaderId = (Integer)generalMap.get("feasibilityStudyHeaderId");
		}
		int projectId = 0;
		if(generalMap.get("projectId")!= null){;
		projectId = (Integer)generalMap.get("projectId");
		}
		 projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		 int thpId = 0;
			if(projectList.size()>0){
				for(MstrProject mstrProject :projectList){
					thpId = mstrProject.getThp().getId();
				}
			}
		 feasibilityHeaderList = session.createCriteria(PrjFesStudyHeader.class).add(Restrictions.idEq(feasibilityStudyHeaderId)).list();
		 siteHeaderList = session.createCriteria(MstrSiteHeader.class).list();
		 therapeuticList = session.createCriteria(MstrTherapeutic.class).add(Restrictions.eq("Status", "y")).list();
		 departmentList =session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		 employeeList =session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		 siteDetailList = session.createCriteria(MstrSiteDetail.class).createAlias("Thp", "thp").add(Restrictions.eq("thp.Id", thpId)).list();
		 map.put("departmentList", departmentList);
		 map.put("employeeList", employeeList);
		 map.put("siteHeaderList", siteHeaderList);
		 map.put("therapeuticList", therapeuticList);
		 map.put("projectList", projectList);
		 map.put("feasibilityHeaderList", feasibilityHeaderList);
		 map.put("siteDetailList", siteDetailList);
		return map;
	}

	public Map<String, Object> saveAssignSiteDetails(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<PrjFesStudyHeader> feasibilityHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<MstrProject>projectList = new ArrayList<MstrProject>();
		List<MstrSiteHeader> siteHeaderList = new ArrayList<MstrSiteHeader>();
		List<MstrTherapeutic> therapeuticList = new ArrayList<MstrTherapeutic>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MstrSiteDetail> siteDetailList = new ArrayList<MstrSiteDetail>();
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId = (Integer)generalMap.get("projectId");
		}
		int feasibilityStudyHeaderId = 0;
		if(generalMap.get("feasibilityStudyHeaderId")!= null){
			feasibilityStudyHeaderId = (Integer)generalMap.get("feasibilityStudyHeaderId");
		}
		int siteHeaderId = 0;
		if(generalMap.get("siteHeaderId")!= null){
			siteHeaderId = (Integer)generalMap.get("siteHeaderId");
		}
		String sqVisit = "";
		if(generalMap.get("sqVisit")!= null){
			sqVisit = (String)generalMap.get("sqVisit");
		}
		String sqVisitStatus = "";
		if(generalMap.get("sqVisitStatus")!= null){
			sqVisitStatus = (String)generalMap.get("sqVisitStatus");
		}
		int delegateId = 0;
		if(generalMap.get("delegateId")!= null){
			delegateId = (Integer)generalMap.get("delegateId");
		}
		Date plannedVisitDate  = new Date();
		if(generalMap.get("plannedVisitDate")!= null){
			plannedVisitDate = (Date)generalMap.get("plannedVisitDate");
		}
		String  message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		 hbt.setFlushModeName("FLUSH_EAGER");
		 hbt.setCheckWriteOperations(false);
		PrjFesStudyHeader prjFesStudyHeader = (PrjFesStudyHeader)hbt.load(PrjFesStudyHeader.class, feasibilityStudyHeaderId);
		prjFesStudyHeader.setPlannedVisitDate(plannedVisitDate);
		prjFesStudyHeader.setSqVisit(sqVisit);
		prjFesStudyHeader.setSqVisitStatus(sqVisitStatus);

		MasEmployee masEmployee = new MasEmployee();
		masEmployee.setId(delegateId);
		prjFesStudyHeader.setDelegateEmp(masEmployee);

		MstrSiteHeader mstrSiteHeader = new MstrSiteHeader();
		mstrSiteHeader.setId(siteHeaderId);
		prjFesStudyHeader.setSiteHeader(mstrSiteHeader);

		hbt.update(prjFesStudyHeader);
		boolean updated = false;
		updated =  true;

		if(updated){
			message = "Data update Successfully.";
		}else{
			message = "Some Problem Occured.";
		}
		Session session = (Session)getSession();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		int thpId = 0;
		if(projectList.size()>0){
			for(MstrProject mstrProject :projectList){
				thpId = mstrProject.getThp().getId();
			}
		}
		 feasibilityHeaderList = session.createCriteria(PrjFesStudyHeader.class).add(Restrictions.idEq(feasibilityStudyHeaderId)).list();
		 siteHeaderList = session.createCriteria(MstrSiteHeader.class).list();
		 therapeuticList = session.createCriteria(MstrTherapeutic.class).add(Restrictions.eq("Status", "y")).list();
		 departmentList =session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		 employeeList =session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		 siteDetailList = session.createCriteria(MstrSiteDetail.class).createAlias("Thp", "thp").add(Restrictions.eq("thp.Id", thpId)).list();
		 map.put("departmentList", departmentList);
		 map.put("employeeList", employeeList);
		 map.put("siteHeaderList", siteHeaderList);
		 map.put("therapeuticList", therapeuticList);
		 map.put("projectList", projectList);
		 map.put("feasibilityHeaderList", feasibilityHeaderList);
		 map.put("siteDetailList", siteDetailList);
		return map;
	}
	public Map<String, Object> showSqVisitUpdateJsp(int projectId) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjFesStudyHeader> feasibilityHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<MstrSiteHeader> siteHeaderList = new ArrayList<MstrSiteHeader>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Session session = (Session)getSession();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		feasibilityHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
		siteHeaderList = session.createCriteria(MstrSiteHeader.class).list();
		 employeeList =session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		map.put("feasibilityHeaderList", feasibilityHeaderList);
		map.put("projectList", projectList);
		map.put("employeeList", employeeList);
		map.put("siteHeaderList", siteHeaderList);
		return map;
	}
	public Map<String, Object> saveSQVisitUpdateDetails(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjFesStudyHeader> feasibilityHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<MstrSiteHeader> siteHeaderList = new ArrayList<MstrSiteHeader>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId = (Integer)generalMap.get("projectId");
		}
		int feasibilityStudyHeaderId = 0;
		if(generalMap.get("feasibilityStudyHeaderId")!= null){
			feasibilityStudyHeaderId = (Integer)generalMap.get("feasibilityStudyHeaderId");
		}
		Date actualVisitDate = null;
		if(generalMap.get("actualVisitDate")!= null){
			actualVisitDate = (Date)generalMap.get("actualVisitDate");
		}
		String comments  = "";
		if(generalMap.get("comments")!= null){
			comments = (String)generalMap.get("comments");
		}
		String  message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		 hbt.setFlushModeName("FLUSH_EAGER");
		 hbt.setCheckWriteOperations(false);
		PrjFesStudyHeader prjFesStudyHeader = (PrjFesStudyHeader)hbt.load(PrjFesStudyHeader.class, feasibilityStudyHeaderId);
		prjFesStudyHeader.setActuaVisitDate(actualVisitDate);
		prjFesStudyHeader.setComments(comments);
		hbt.update(prjFesStudyHeader);
		boolean updated = false;
		updated =  true;

		if(updated){
			message = "Data update Successfully.";
		}else{
			message = "Some Problem Occured.";
		}
		Session session = (Session)getSession();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		feasibilityHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
		siteHeaderList = session.createCriteria(MstrSiteHeader.class).list();
		employeeList =session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		map.put("feasibilityHeaderList", feasibilityHeaderList);
		map.put("projectList", projectList);
		map.put("employeeList", employeeList);
		map.put("siteHeaderList", siteHeaderList);
		map.put("message", message);
		return map;
	}

	public Map<String, Object> updateSQVisitUpdateDetails(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjFesStudyHeader> feasibilityHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<MstrSiteHeader> siteHeaderList = new ArrayList<MstrSiteHeader>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId = (Integer)generalMap.get("projectId");
		}
		int feasibilityStudyHeaderId = 0;
		if(generalMap.get("feasibilityStudyHeaderId")!= null){
			feasibilityStudyHeaderId = (Integer)generalMap.get("feasibilityStudyHeaderId");
		}
		Date actualVisitDate = null;
		if(generalMap.get("actualVisitDate")!= null){
			actualVisitDate = (Date)generalMap.get("actualVisitDate");
		}
		String comments  = "";
		if(generalMap.get("comments")!= null){
			comments = (String)generalMap.get("comments");
		}
		String  message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		 hbt.setFlushModeName("FLUSH_EAGER");
		 hbt.setCheckWriteOperations(false);
		PrjFesStudyHeader prjFesStudyHeader = (PrjFesStudyHeader)hbt.load(PrjFesStudyHeader.class, feasibilityStudyHeaderId);
		prjFesStudyHeader.setActuaVisitDate(actualVisitDate);
		prjFesStudyHeader.setComments(comments);
		hbt.update(prjFesStudyHeader);
		boolean updated = false;
		updated =  true;

		if(updated){
			message = "Data update Successfully.";
		}else{
			message = "Some Problem Occured.";
		}
		Session session = (Session)getSession();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		feasibilityHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
		siteHeaderList = session.createCriteria(MstrSiteHeader.class).list();
		employeeList =session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		map.put("feasibilityHeaderList", feasibilityHeaderList);
		map.put("projectList", projectList);
		map.put("employeeList", employeeList);
		map.put("siteHeaderList", siteHeaderList);
		map.put("message", message);
		return map;
	}
	public Map<String, Object> displaySqVisitUpdateAttachment(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PrjFesStudyHeader> feasibilityHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<PrjFedoc> sqVisitupdateList = new ArrayList<PrjFedoc>();
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId =(Integer)generalMap.get("projectId");
		}
		int feasibilityStudyHeaderId = 0;
		if(generalMap.get("feasibilityHeaderId")!= null){
			feasibilityStudyHeaderId =(Integer)generalMap.get("feasibilityHeaderId");
		}
		Session session = (Session)getSession();
		feasibilityHeaderList = session.createCriteria(PrjFesStudyHeader.class).add(Restrictions.idEq(feasibilityStudyHeaderId)).list();
		sqVisitupdateList = session.createCriteria(PrjFedoc.class).createAlias("FedFeid", "feasibility").add(Restrictions.eq("feasibility.Id", feasibilityStudyHeaderId)).list();
		map.put("feasibilityHeaderList", feasibilityHeaderList);
		map.put("sqVisitupdateList", sqVisitupdateList);
		return map;
	}
	public Map<String, Object> addSqVisitUpdateFile(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PrjFesStudyHeader> feasibilityHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<PrjFedoc> sqVisitupdateList = new ArrayList<PrjFedoc>();
		Session session = (Session)getSession();
		String filename = "";
		if(generalMap.get("filename")!= null){
			filename =(String) generalMap.get("filename");
		}
		String uploadURL = "";
		if(generalMap.get("uploadURL")!= null){
			uploadURL =(String) generalMap.get("uploadURL");
		}
		String comments = "";
		if(generalMap.get("comments")!= null){
			comments =(String) generalMap.get("comments");
		}
		int feasibilityStudyHeaderId = 0;
		if(generalMap.get("feasibilityHeaderId")!= null){
			feasibilityStudyHeaderId =(Integer) generalMap.get("feasibilityHeaderId");
		}

		String fileExtension=null;
		 File file=null;
		 try {
				HibernateTemplate hbt=getHibernateTemplate();
				//hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);

	    		 file=new File(uploadURL + "/" + filename);
	    	     FileInputStream is = new FileInputStream(file);
	    	     long length = file.length();
	    	     ByteBuffer byteBuff=null;
	    	   //  int modLength=length/
	    	     if (length > Integer.MAX_VALUE) {
	            // File is too large
	    	     }
	    	     // Create the byte array to hold the data
	    	     byte[] bytes = new byte[(int)length];
	    	     int offset = 0;
	    	     int numRead = 0;
	    	     while (offset < bytes.length
	    	    		 && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	    	    	 offset += numRead;

	    	     }

	    	     if (offset < bytes.length) {
	    	    	 throw new IOException("Could not completely read file "+file.getName());

	    	     }
	    	     is.close();
	        // Close the input stream and return bytes
	    	    // StringTokenizer strToken=new StringTokenizer( filename,".");

	    	   //  filename=strToken.nextToken();
	    	   //  fileExtension=strToken.nextToken();

	    		PrjFedoc  prjFedoc = new PrjFedoc();
	    		prjFedoc.setFedDfilename(filename);
	    		prjFedoc.setFedOfilename(filename);
	    		prjFedoc.setFedCmts(comments);
	    		PrjFesStudyHeader prjFesStudyHeader = new PrjFesStudyHeader();
	    		prjFesStudyHeader.setId(feasibilityStudyHeaderId);
	    		prjFedoc.setFedFeid(prjFesStudyHeader);

	    	     hbt.save(prjFedoc);
	    	     //file.delete();


	    }// end of 'try' loop
		catch (Exception e) {

	      System.err.println("Error: " + e.getMessage());
	      e.printStackTrace();
	    }
		sqVisitupdateList = session.createCriteria(PrjFedoc.class).createAlias("FedFeid", "feasibility").add(Restrictions.eq("FedFeid.Id", feasibilityStudyHeaderId)).list();
		feasibilityHeaderList = session.createCriteria(PrjFesStudyHeader.class).add(Restrictions.idEq(feasibilityStudyHeaderId)).list();
		map.put("feasibilityHeaderList", feasibilityHeaderList);
		map.put("sqVisitupdateList", sqVisitupdateList);
		return map;
	}

	public Map<String, Object> showRequlatoryMenuJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		Session session = (Session)getSession();
		projectList = session.createCriteria(MstrProject.class).list();
		map.put("projectList", projectList);
		map = showProjectCreationJsp();
		return map;
	}

	public Map<String, Object> showSiteSettingJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		//List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<MstrProject> allProjectList = new ArrayList<MstrProject>();
		Session session = (Session)getSession();
		allProjectList = session.createCriteria(MstrProject.class).list();
		//projectList = session.createCriteria(MstrProject.class).list();
		//map.put("projectList", projectList);
		map.put("allProjectList", allProjectList);
		return map;
	}
	public Map<String, Object> showProjectSitesList(int projectId) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<MstrProject> allProjectList = new ArrayList<MstrProject>();
		List<PrjFesStudyHeader> fesStudyHeaderList = new ArrayList<PrjFesStudyHeader>();
		Session session = (Session)getSession();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		allProjectList = session.createCriteria(MstrProject.class).list();
		fesStudyHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).add(Restrictions.eq("QaApprovalStatus", "Approved")).list();
		map.put("fesStudyHeaderList", fesStudyHeaderList);
		map.put("projectList", projectList);
		map.put("allProjectList", allProjectList);
		return map;
	}
	public Map<String, Object> showSiteVitalsJsp(int projectId, int siteId) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjFesStudyHeader> fesStudyHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<MstrVitals> vitalsMasterList = new ArrayList<MstrVitals>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		List<PrjSiteVital> siteVitalList = new ArrayList<PrjSiteVital>();
		Session session = (Session)getSession();
		fesStudyHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
		vitalsMasterList = session.createCriteria(MstrVitals.class).add(Restrictions.eq("Status", "y")).list();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
		siteVitalList = session.createCriteria(PrjSiteVital.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();

		map.put("fesStudyHeaderList", fesStudyHeaderList);
		map.put("projectList", projectList);
		map.put("vitalsMasterList", vitalsMasterList);
		map.put("currencyList", currencyList);
		map.put("siteVitalList", siteVitalList);
		return map;
	}

	public Map<String, Object> saveSiteVitals(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjFesStudyHeader> fesStudyHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<PrjSiteVital> siteVitalList = new ArrayList<PrjSiteVital>();
		List<MstrVitals> vitalsMasterList = new ArrayList<MstrVitals>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		Session session = (Session)getSession();
		int	hospitalId = 0;
		if(generalMap.get("hospitalId")!= null){
			hospitalId =(Integer)generalMap.get("hospitalId");
		}
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			 projectId = (Integer)generalMap.get("projectId");
		}
		int siteId = 0;
		if(generalMap.get("siteId")!= null){
			siteId = (Integer)generalMap.get("siteId");
		}
		int vitalId = 0;
		if(generalMap.get("vitalId")!= null){
			vitalId = (Integer)generalMap.get("vitalId");
		}
		int currencyId = 0;
		if(generalMap.get("currencyId")!= null){
			currencyId = (Integer)generalMap.get("currencyId");
		}
		String flag  = "";
		if(generalMap.get("flag")!= null){
			flag = (String)generalMap.get("flag");
		}
		String amountFlag  = "";
		if(generalMap.get("amountFlag")!= null){
			amountFlag = (String)generalMap.get("amountFlag");
		}
		String plannedDate = "";
		if(generalMap.get("plannedDate")!= null){
			plannedDate = (String)generalMap.get("plannedDate");
		}
		String revisedDate = "";
		if(generalMap.get("revisedDate")!= null){
			revisedDate = (String)generalMap.get("revisedDate");
		}
		String actualDate = "";
		if(generalMap.get("actualDate")!= null){
			actualDate = (String)generalMap.get("actualDate");
		}
		String plannedRemark = "";
		if(generalMap.get("plannedRemark")!= null){
			plannedRemark = (String)generalMap.get("plannedRemark");
		}
		String revisedRemark = "";
		if(generalMap.get("revisedRemark")!= null){
			revisedRemark = (String)generalMap.get("revisedRemark");
		}
		String actualRemark = "";
		if(generalMap.get("actualRemark")!= null){
			actualRemark = (String)generalMap.get("actualRemark");
		}
		 String changedBy  = "";
		 if(generalMap.get("changedBy")!= null){
			 changedBy =(String)generalMap.get("changedBy");
		 }
		 Date currentDate = new Date();
		 if(generalMap.get("currentDate")!= null){
			 currentDate =(Date)generalMap.get("currentDate");
		 }
		 String	currentTime = "";
		 if(generalMap.get("currentTime")!= null){
			 currentTime =(String)generalMap.get("currentTime");
		 }
		PrjSiteVital prjSiteVital = new PrjSiteVital();

		MstrVitals mstrVitals = new MstrVitals();
		mstrVitals.setId(vitalId);
		prjSiteVital.setVital(mstrVitals);
		prjSiteVital.setFlag(flag);
		prjSiteVital.setAmountFlag(amountFlag);
		prjSiteVital.setStatus("y");

		if(flag.equals("D")){
			prjSiteVital.setPlannedDate(HMSUtil.convertStringTypeDateToDateType(plannedDate));
			prjSiteVital.setRevisedDate(HMSUtil.convertStringTypeDateToDateType(revisedDate));
			prjSiteVital.setActualDate(HMSUtil.convertStringTypeDateToDateType(actualDate));
		}else if(flag.equals("V")){
			if(amountFlag.equals("yes")){
				prjSiteVital.setPlannedValue(new Integer(plannedDate));
				prjSiteVital.setRevisedValue(new Integer(revisedDate));
				prjSiteVital.setActualValue(new Integer(actualDate));
				MasCurrency masCurrency = new MasCurrency();
				masCurrency.setId(currencyId);
				prjSiteVital.setCurrency(masCurrency);
			}else if(amountFlag.equals("no")){
				prjSiteVital.setPlannedValue(Integer.parseInt(plannedDate));
				prjSiteVital.setRevisedValue(Integer.parseInt(revisedDate));
				prjSiteVital.setActualValue(Integer.parseInt(actualDate));
			}
		}
			prjSiteVital.setPlannedRemark(plannedRemark);
			prjSiteVital.setRevisedRemark(revisedRemark);
			prjSiteVital.setActualRemark(actualRemark);
			prjSiteVital.setLastChgBy(changedBy);
			prjSiteVital.setLastChgDate(currentDate);
			prjSiteVital.setLastChgTime(currentTime);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			prjSiteVital.setHospital(masHospital);
			MstrProject mstrProject = new MstrProject();
			mstrProject.setId(projectId);
			prjSiteVital.setPrj(mstrProject);

			MstrSiteHeader mstrSiteHeader = new MstrSiteHeader();
			mstrSiteHeader.setId(siteId);
			prjSiteVital.setSiteHeader(mstrSiteHeader);

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.save(prjSiteVital);
			String message = "";
			boolean saved = false;
			saved =  true;

			if(saved){
				message = "Data save Successfully.";
			}else{
				message = "Some Problem Occured.";
			}
			fesStudyHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
			vitalsMasterList = session.createCriteria(MstrVitals.class).add(Restrictions.eq("Status", "y")).list();
			projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
			currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
			siteVitalList = session.createCriteria(PrjSiteVital.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
			map.put("fesStudyHeaderList", fesStudyHeaderList);
			map.put("projectList", projectList);
			map.put("vitalsMasterList", vitalsMasterList);
			map.put("currencyList", currencyList);
			map.put("siteVitalList", siteVitalList);
		return map;
	}
	public Map<String, Object> updateSiteVitals(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjFesStudyHeader> fesStudyHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<PrjSiteVital> siteVitalList = new ArrayList<PrjSiteVital>();
		List<MstrVitals> vitalsMasterList = new ArrayList<MstrVitals>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		Session session = (Session)getSession();
		int siteVitalsId = 0;
		if(generalMap.get("siteVitalsId")!= null){
			siteVitalsId = (Integer)generalMap.get("siteVitalsId");
		}
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			 projectId = (Integer)generalMap.get("projectId");
		}
		int siteId = 0;
		if(generalMap.get("siteId")!= null){
			siteId = (Integer)generalMap.get("siteId");
		}
		int vitalId = 0;
		if(generalMap.get("vitalId")!= null){
			vitalId = (Integer)generalMap.get("vitalId");
		}
		int currencyId = 0;
		if(generalMap.get("currencyId")!= null){
			currencyId = (Integer)generalMap.get("currencyId");
		}
		String flag  = "";
		if(generalMap.get("flag")!= null){
			flag = (String)generalMap.get("flag");
		}
		String amountFlag  = "";
		if(generalMap.get("amountFlag")!= null){
			amountFlag = (String)generalMap.get("amountFlag");
		}
		String plannedDate = "";
		if(generalMap.get("plannedDate")!= null){
			plannedDate = (String)generalMap.get("plannedDate");
		}
		String revisedDate = "";
		if(generalMap.get("revisedDate")!= null){
			revisedDate = (String)generalMap.get("revisedDate");
		}
		String actualDate = "";
		if(generalMap.get("actualDate")!= null){
			actualDate = (String)generalMap.get("actualDate");
		}
		String plannedRemark = "";
		if(generalMap.get("plannedRemark")!= null){
			plannedRemark = (String)generalMap.get("plannedRemark");
		}
		String revisedRemark = "";
		if(generalMap.get("revisedRemark")!= null){
			revisedRemark = (String)generalMap.get("revisedRemark");
		}
		String actualRemark = "";
		if(generalMap.get("actualRemark")!= null){
			actualRemark = (String)generalMap.get("actualRemark");
		}
		 String changedBy  = "";
		 if(generalMap.get("changedBy")!= null){
			 changedBy =(String)generalMap.get("changedBy");
		 }
		 Date currentDate = new Date();
		 if(generalMap.get("currentDate")!= null){
			 currentDate =(Date)generalMap.get("currentDate");
		 }
		 String	currentTime = "";
		 if(generalMap.get("currentTime")!= null){
			 currentTime =(String)generalMap.get("currentTime");
		 }
		 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			PrjSiteVital prjSiteVital = (PrjSiteVital)hbt.load(PrjSiteVital.class, siteVitalsId);
		 MstrVitals mstrVitals = new MstrVitals();
			mstrVitals.setId(vitalId);
			prjSiteVital.setVital(mstrVitals);
			prjSiteVital.setFlag(flag);
			prjSiteVital.setAmountFlag(amountFlag);
			prjSiteVital.setStatus("y");

			if(flag.equals("D")){
				prjSiteVital.setPlannedDate(HMSUtil.convertStringTypeDateToDateType(plannedDate));
				prjSiteVital.setRevisedDate(HMSUtil.convertStringTypeDateToDateType(revisedDate));
				prjSiteVital.setActualDate(HMSUtil.convertStringTypeDateToDateType(actualDate));
			}else if(flag.equals("V")){
				if(amountFlag.equals("yes")){
					prjSiteVital.setPlannedValue(new Integer(plannedDate));
					prjSiteVital.setRevisedValue(new Integer(revisedDate));
					prjSiteVital.setActualValue(new Integer(actualDate));
					MasCurrency masCurrency = new MasCurrency();
					masCurrency.setId(currencyId);
					prjSiteVital.setCurrency(masCurrency);
				}else if(amountFlag.equals("no")){
					prjSiteVital.setPlannedValue(Integer.parseInt(plannedDate));
					prjSiteVital.setRevisedValue(Integer.parseInt(revisedDate));
					prjSiteVital.setActualValue(Integer.parseInt(actualDate));
				}
			}
				prjSiteVital.setPlannedRemark(plannedRemark);
				prjSiteVital.setRevisedRemark(revisedRemark);
				prjSiteVital.setActualRemark(actualRemark);
				prjSiteVital.setLastChgBy(changedBy);
				prjSiteVital.setLastChgDate(currentDate);
				prjSiteVital.setLastChgTime(currentTime);
				MstrProject mstrProject = new MstrProject();
				mstrProject.setId(projectId);
				prjSiteVital.setPrj(mstrProject);

				MstrSiteHeader mstrSiteHeader = new MstrSiteHeader();
				mstrSiteHeader.setId(siteId);
				prjSiteVital.setSiteHeader(mstrSiteHeader);

				hbt.update(prjSiteVital);
				String message = "";
				boolean updated = false;
				updated =  true;

				if(updated){
					message = "Data update Successfully.";
				}else{
					message = "Some Problem Occured.";
				}
				fesStudyHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
				vitalsMasterList = session.createCriteria(MstrVitals.class).add(Restrictions.eq("Status", "y")).list();
				projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
				currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
				siteVitalList = session.createCriteria(PrjSiteVital.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
				map.put("fesStudyHeaderList", fesStudyHeaderList);
				map.put("projectList", projectList);
				map.put("vitalsMasterList", vitalsMasterList);
				map.put("currencyList", currencyList);
				map.put("siteVitalList", siteVitalList);
		return map;
	}

	public Map<String, Object> showSiteResourceMappingJsp(int projectId,int siteId) {
		Map<String, Object> map =new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjFesStudyHeader> fesStudyHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<PrjRolewiseResourceReq> prjRoleWiseResourceList = new ArrayList<PrjRolewiseResourceReq>();
		List<PrjSiteResMap> prjSiteResMapList = new ArrayList<PrjSiteResMap>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<PrjRoleResMappingHeader> roleResourceMappingHeaderList = new ArrayList<PrjRoleResMappingHeader>();
		fesStudyHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		prjRoleWiseResourceList = session.createCriteria(PrjRolewiseResourceReq.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		roleResourceMappingHeaderList = session.createCriteria(PrjRoleResMappingHeader.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
		prjSiteResMapList = session.createCriteria(PrjSiteResMap.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
		map.put("fesStudyHeaderList", fesStudyHeaderList);
		map.put("projectList", projectList);
		map.put("prjRoleWiseResourceList", prjRoleWiseResourceList);
		map.put("employeeList", employeeList);
		map.put("roleResourceMappingHeaderList", roleResourceMappingHeaderList);
		map.put("prjSiteResMapList", prjSiteResMapList);
		return map;
	}

	public Map<String, Object> getResourceListFromAjax(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<PrjRoleResMappingHeader> roleResourceMappingHeaderList = new ArrayList<PrjRoleResMappingHeader>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Session session = (Session)getSession();
		int projectRoleId = 0;
		if(generalMap.get("projectRoleId")!= null){
			projectRoleId = (Integer)generalMap.get("projectRoleId");
		}
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId = (Integer)generalMap.get("projectId");
		}
		roleResourceMappingHeaderList = session.createCriteria(PrjRoleResMappingHeader.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("Pjr", "role").add(Restrictions.eq("role.Id", projectRoleId)).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		map.put("employeeList", employeeList);
		map.put("roleResourceMappingHeaderList", roleResourceMappingHeaderList);
		return map;
	}

	public Map<String, Object> saveSiteResourceMapping(Map<String, Object> generalMap) {
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjRolewiseResourceReq> prjRoleWiseResourceList = new ArrayList<PrjRolewiseResourceReq>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<PrjSiteResMap> prjSiteResMapList = new ArrayList<PrjSiteResMap>();
		List<PrjRoleResMappingHeader> roleResourceMappingHeaderList = new ArrayList<PrjRoleResMappingHeader>();
		Map<String, Object> map =new HashMap<String, Object>();
		List<PrjFesStudyHeader> fesStudyHeaderList = new ArrayList<PrjFesStudyHeader>();
		Session session = (Session)getSession();
		String message = "";
		boolean saved = false;
		int projectRoleId = 0;
		if(generalMap.get("projectRoleId")!= null){
			projectRoleId = (Integer)generalMap.get("projectRoleId");
		}
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId = (Integer)generalMap.get("projectId");
		}
		int siteId = 0;
		if(generalMap.get("siteId")!= null){
			siteId = (Integer)generalMap.get("siteId");
		}
		String[] selectedResourceList = {"0"};
		if(generalMap.get("selectedResourceList")!=null){
			selectedResourceList =(String[])generalMap.get("selectedResourceList");
		}

		 String changedBy  = "";
		 if(generalMap.get("changedBy")!= null){
			 changedBy =(String)generalMap.get("changedBy");
		 }
		 Date currentDate = new Date();
		 if(generalMap.get("currentDate")!= null){
			 currentDate =(Date)generalMap.get("currentDate");
		 }
		 String	currentTime = "";
		 if(generalMap.get("currentTime")!= null){
			 currentTime =(String)generalMap.get("currentTime");
		 }
		PrjSiteResMap prjSiteResMap = new PrjSiteResMap();

		MstrProject mstrProject = new MstrProject();
		mstrProject.setId(projectId);
	//	prjSiteResMap.setPrj(mstrProject);

		MstrProjectrole mstrProjectrole = new MstrProjectrole();
		mstrProjectrole.setId(projectRoleId);
	//	prjSiteResMap.setPjr(mstrProjectrole);

		MstrSiteHeader mstrSiteHeader = new MstrSiteHeader();
		mstrSiteHeader.setId(siteId);
	//	prjSiteResMap.setSiteHeader(mstrSiteHeader);

		/*prjSiteResMap.setLastChgBy(changedBy);
		prjSiteResMap.setLastChgDate(currentDate);
		prjSiteResMap.setLastChgTime(currentTime);
		prjSiteResMap.setStatus("y");*/
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		if(selectedResourceList.length!=0){
			for(int i=0;i<selectedResourceList.length;i++){

					int employee_id = 0;
					employee_id = Integer.parseInt(selectedResourceList[i]);
					List<PrjSiteResMap> dupPrjSiteResMapList = new ArrayList<PrjSiteResMap>();
					dupPrjSiteResMapList = session.createCriteria(PrjSiteResMap.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).createAlias("Pjr", "pjr").add(Restrictions.eq("pjr.Id", projectRoleId)).createAlias("Employee", "employee").add(Restrictions.eq("employee.Id", employee_id)).list();
					if(dupPrjSiteResMapList.size() != 1){
						PrjSiteResMap prjSiteResMap1 = new PrjSiteResMap();
						prjSiteResMap1.setLastChgBy(changedBy);
						prjSiteResMap1.setLastChgDate(currentDate);
						prjSiteResMap1.setLastChgTime(currentTime);
						prjSiteResMap1.setPrj(mstrProject);
						prjSiteResMap1.setSiteHeader(mstrSiteHeader);
						prjSiteResMap1.setPjr(mstrProjectrole);
						prjSiteResMap1.setEmployee(new MasEmployee((Integer.parseInt(selectedResourceList[i]))));
						prjSiteResMap1.setStatus("y");
						hbt.save(prjSiteResMap1);
						hbt.refresh(prjSiteResMap1);
						saved =  true;
				    }
			}
		}
		//	hbt.save(prjSiteResMap);
		//	hbt.refresh(prjSiteResMap);




			if(saved){
				message = "Transaction Successfully.";
			}else{
				message = "Some Problem Occured.";
			}
			projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
			prjRoleWiseResourceList = session.createCriteria(PrjRolewiseResourceReq.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
			prjSiteResMapList = session.createCriteria(PrjSiteResMap.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
			fesStudyHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
			roleResourceMappingHeaderList = session.createCriteria(PrjRoleResMappingHeader.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
			map.put("projectList", projectList);
			map.put("prjSiteResMapList", prjSiteResMapList);
			map.put("prjRoleWiseResourceList", prjRoleWiseResourceList);
			map.put("prjRoleWiseResourceList", prjRoleWiseResourceList);
			map.put("fesStudyHeaderList", fesStudyHeaderList);
			map.put("fesStudyHeaderList", fesStudyHeaderList);
			map.put("roleResourceMappingHeaderList", roleResourceMappingHeaderList);
			return map;
	}
	public Map<String, Object> showApprovalSettingJsp() {
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		Session session = (Session)getSession();
		projectList = session.createCriteria(MstrProject.class).list();
		map.put("projectList", projectList);
		map = showProjectCreationJsp();
		return map;
	}
	public Map<String, Object> showProjectApproval(int projectId) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		Session session = (Session)getSession();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		map.put("projectList", projectList);

		return map;
	}

	public Map<String, Object> showProjectTrackingMenuJsp(Users users) {
		Map<String, Object> map =new HashMap<String, Object>();
		int userId = users.getEmployee().getId();
		Session session = (Session)getSession();
		List<PrjSiteResMap> prjSiteResMapList = new ArrayList<PrjSiteResMap>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		int employeeId = users.getEmployee().getId();
		Set<Integer> prjList  = new HashSet<Integer>();
		prjSiteResMapList = session.createCriteria(PrjSiteResMap.class).createAlias("Employee", "emp").add(Restrictions.eq("emp.Id", employeeId)).list();
		for(PrjSiteResMap prjSiteMap :prjSiteResMapList  )
		{
			prjList.add(prjSiteMap.getPrj().getId());
		}
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.in("Id",prjList)).list();

		map.put("projectList", projectList);
		return map;
	}
	public Map<String, Object> showSitesListForProjectTracking(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<PrjSiteResMap> prjSiteResMapSiteList = new ArrayList<PrjSiteResMap>();
		List<PrjSiteResMap> prjSiteResMapPrjList = new ArrayList<PrjSiteResMap>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<MstrSiteHeader> siteHeaderList = new ArrayList<MstrSiteHeader>();
		Set<Integer> siteList  = new HashSet<Integer>();
		Set<Integer> prjList  = new HashSet<Integer>();
		Session session = (Session)getSession();
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId= (Integer)generalMap.get("projectId");
		}
		Users users = new Users();
		if(generalMap.get("users")!= null){
			users= (Users)generalMap.get("users");
		}
		int employeeId = users.getEmployee().getId();
		prjSiteResMapPrjList = session.createCriteria(PrjSiteResMap.class).createAlias("Employee", "emp").add(Restrictions.eq("emp.Id", employeeId)).list();
		prjSiteResMapSiteList = session.createCriteria(PrjSiteResMap.class).createAlias("Employee", "emp").add(Restrictions.eq("emp.Id", employeeId)).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).list();
		for(PrjSiteResMap prjListMap :prjSiteResMapPrjList  )
		{
			prjList.add(prjListMap.getPrj().getId());

		}
		for(PrjSiteResMap siteListMap :prjSiteResMapSiteList  )
		{
			siteList.add(siteListMap.getSiteHeader().getId());
		}
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.in("Id",prjList)).list();
		siteHeaderList = session.createCriteria(MstrSiteHeader.class).add(Restrictions.in("Id",siteList)).list();
		map.put("projectList", projectList);
		map.put("siteHeaderList", siteHeaderList);
		map.put("projectId", projectId);
		return map;
	}

	public Map<String, Object> showAddPatient(int projectId, int siteId) {
		Map<String, Object> map =new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjAddPtHeader> prjAddPatientHeaderList = new ArrayList<PrjAddPtHeader>();
		List<PrjSiteResMap> prjSiteResMapSiteList = new ArrayList<PrjSiteResMap>();
		//fesStudyHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
		prjSiteResMapSiteList = session.createCriteria(PrjSiteResMap.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader","header").add(Restrictions.eq("header.Id", siteId)).list();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		prjAddPatientHeaderList = session.createCriteria(PrjAddPtHeader.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
		map.put("prjAddPatientHeaderList", prjAddPatientHeaderList);
		map.put("prjSiteResMapSiteList", prjSiteResMapSiteList);
		map.put("projectList", projectList);
		return map;
	}

	public Map<String, Object> saveAddPatientDetails(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<PrjPatvisitsch> patienVisitScheduleList = new ArrayList<PrjPatvisitsch>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjSiteResMap> prjSiteResMapSiteList = new ArrayList<PrjSiteResMap>();
		List<PrjAddPtHeader> prjAddPatientHeaderList = new ArrayList<PrjAddPtHeader>();
		Session session = (Session)getSession();
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId = (Integer)generalMap.get("projectId");
		}
		int siteId = 0;
		if(generalMap.get("siteId")!= null){
			siteId = (Integer)generalMap.get("siteId");
		}
		String enrollmentNo = "";
		if(generalMap.get("enrollmentNo")!= null){
			enrollmentNo = (String)generalMap.get("enrollmentNo");
		}
		String screeningNo = "";
		if(generalMap.get("screeningNo")!= null){
			screeningNo = (String)generalMap.get("screeningNo");
		}
		String randomizationNo = "";
		if(generalMap.get("randomizationNo")!= null){
			randomizationNo = (String)generalMap.get("randomizationNo");
		}
		String patientInititals = "";
		if(generalMap.get("patientInititals")!= null){
			patientInititals = (String)generalMap.get("patientInititals");
		}
		Date screeningDate = null;
		if(generalMap.get("screeningDate")!= null){
			screeningDate = (Date)generalMap.get("screeningDate");
		}
		Date randomizationdate = null;
		if(generalMap.get("randomizationdate")!= null){
			randomizationdate = (Date)generalMap.get("randomizationdate");
		}
		Date initializationDate = null;
		if(generalMap.get("initializationDate")!= null){
			initializationDate = (Date)generalMap.get("initializationDate");
		}
		 String changedBy  = "";
		 if(generalMap.get("changedBy")!= null){
			 changedBy =(String)generalMap.get("changedBy");
		 }
		 Date currentDate = new Date();
		 if(generalMap.get("currentDate")!= null){
			 currentDate =(Date)generalMap.get("currentDate");
		 }
		 String	currentTime = "";
		 if(generalMap.get("currentTime")!= null){
			 currentTime =(String)generalMap.get("currentTime");
		 }
		 patienVisitScheduleList = session.createCriteria(PrjPatvisitsch.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("VisitType", "vType").add(Restrictions.eq("vType.Id", 1)).list();

		PrjAddPtHeader prjAddPatientHeader = new PrjAddPtHeader();
		prjAddPatientHeader.setEnrollmentNo(enrollmentNo);
		prjAddPatientHeader.setRandomizationNo(randomizationNo);
		prjAddPatientHeader.setScreeningNo(screeningNo);
		prjAddPatientHeader.setScreeningDate(screeningDate);
		prjAddPatientHeader.setRandomizationDate(randomizationdate);
		prjAddPatientHeader.setInitialVisitDate(initializationDate);
		prjAddPatientHeader.setPatientInitials(patientInititals);
		prjAddPatientHeader.setLastChgBy(changedBy);
		prjAddPatientHeader.setLastChgDate(currentDate);
		prjAddPatientHeader.setLastChgTime(currentTime);
		prjAddPatientHeader.setStatus("y");
		MstrProject mstrProject = new MstrProject();
		mstrProject.setId(projectId);
		prjAddPatientHeader.setPrj(mstrProject);
		MstrSiteHeader mstrSiteHeader = new MstrSiteHeader();
		mstrSiteHeader.setId(siteId);
		prjAddPatientHeader.setSiteHeader(mstrSiteHeader);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(prjAddPatientHeader);
		int interval = 0;
		Date visitDate = null;
		int patientVisitId = 0;
		 if(patienVisitScheduleList.size()>0){
			 for(PrjPatvisitsch prjPatvisitsch :patienVisitScheduleList){
				 PrjAddPtDetail prjAddPtDetail = new PrjAddPtDetail();
				 interval = prjPatvisitsch.getPvInt();
				 patientVisitId = prjPatvisitsch.getId();
				try {
					visitDate = HMSUtil.addDaysToDate(HMSUtil.convertDateToStringTypeDate(initializationDate), interval);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				prjPatvisitsch.setId(patientVisitId);
				prjAddPtDetail.setPv(prjPatvisitsch);
				prjAddPtDetail.setAddPtHeader(prjAddPatientHeader);
				prjAddPtDetail.setPlannedDate(visitDate);
				prjAddPtDetail.setVisitInterval(interval);
				prjAddPtDetail.setStatus("y");
				hbt.save(prjAddPtDetail);
			 }
		}
			projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
			prjAddPatientHeaderList = session.createCriteria(PrjAddPtHeader.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
			prjSiteResMapSiteList = session.createCriteria(PrjSiteResMap.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader","header").add(Restrictions.eq("header.Id", siteId)).list();
			map.put("prjAddPatientHeaderList", prjAddPatientHeaderList);
			map.put("prjSiteResMapSiteList", prjSiteResMapSiteList);
			map.put("projectList", projectList);


		return map;
	}

	public Map<String, Object> showPatientSchedule(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PrjAddPtHeader> prjAddPatientHeaderList = new ArrayList<PrjAddPtHeader>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjSiteResMap> prjSiteResMapSiteList = new ArrayList<PrjSiteResMap>();
		Session session = (Session)getSession();
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId = (Integer)generalMap.get("projectId");
		}
		int siteId = 0;
		if(generalMap.get("siteId")!= null){
			siteId = (Integer)generalMap.get("siteId");
		}
		int addPatientHeaderId = 0;
		if(generalMap.get("addPatientHeaderId")!= null){
			addPatientHeaderId = (Integer)generalMap.get("addPatientHeaderId");
		}
		prjSiteResMapSiteList = session.createCriteria(PrjSiteResMap.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader","header").add(Restrictions.eq("header.Id", siteId)).list();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		prjAddPatientHeaderList = session.createCriteria(PrjAddPtHeader.class).add(Restrictions.idEq(addPatientHeaderId)).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
		map.put("prjAddPatientHeaderList", prjAddPatientHeaderList);
		map.put("prjSiteResMapSiteList", prjSiteResMapSiteList);
		map.put("projectList", projectList);
		return map;
	}
	public Map<String, Object> updateAddPatientSchedule(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<PrjAddPtHeader> prjAddPatientHeaderList = new ArrayList<PrjAddPtHeader>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjSiteResMap> prjSiteResMapSiteList = new ArrayList<PrjSiteResMap>();
		List addPatientDetailIdList =new ArrayList();
		List actualDateList =new ArrayList();
		List variationList =new ArrayList();
		List statusList =new ArrayList();
		List commentList =new ArrayList();
		List fileList =new ArrayList();
		Session session = (Session)getSession();
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId = (Integer)generalMap.get("projectId");
		}
		int siteId = 0;
		if(generalMap.get("siteId")!= null){
			siteId = (Integer)generalMap.get("siteId");
		}
		int addPatientHeaderId = 0;
		if(generalMap.get("addPatientHeaderId")!= null){
			addPatientHeaderId = (Integer)generalMap.get("addPatientHeaderId");
		}
		/*if (generalMap.get("fileList")!= null) {
			fileList = (List)generalMap.get("fileList");
		}*/
		if (generalMap.get("actualDateList")!= null) {
			actualDateList = (List)generalMap.get("actualDateList");
		}
		if (generalMap.get("addPatientDetailIdList")!= null) {
			addPatientDetailIdList = (List)generalMap.get("addPatientDetailIdList");
		}
		if (generalMap.get("variationList")!= null) {
			variationList = (List)generalMap.get("variationList");
		}
		if (generalMap.get("commentList")!= null) {
			commentList = (List)generalMap.get("commentList");
		}
		if (generalMap.get("statusList")!= null) {
			statusList = (List)generalMap.get("statusList");
		}
		/*String uploadURL = "";
		if (generalMap.get("uploadURL")!= null) {
			uploadURL = (String)generalMap.get("uploadURL");
		}*/
		int detailId = 0;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		//String fileExtension=null;
		 //File file=null;

		if(addPatientDetailIdList.size()>0){
			for (int i = 0; i <addPatientDetailIdList.size(); i++) {
				PrjAddPtDetail prjAddPtDetail= (PrjAddPtDetail)hbt.load(PrjAddPtDetail.class, (new Integer(addPatientDetailIdList.get(i).toString())));
				if(actualDateList.get(i) != null){
					Date actualDate = HMSUtil.convertStringTypeDateToDateType(actualDateList.get(i).toString());
					prjAddPtDetail.setActualDate(actualDate);
				}
				if(commentList.size()>0){
				if(commentList.get(i) != null){
					String comment =(String)commentList.get(i);
					prjAddPtDetail.setComments(comment);
				}
				}
				if(statusList.get(i) != null){
					String scheduleStatus =(String)statusList.get(i);
					prjAddPtDetail.setScheduleStatus(scheduleStatus);
				}
				if(variationList.get(i) != null){
					int variation = Integer.parseInt(variationList.get(i).toString());
					prjAddPtDetail.setVariation(variation);
				}
				/*String filename = "";
				if(fileList.get(i) != null){
					 filename =(String)fileList.get(i);
				}

				 try {

					 	hbt.setCheckWriteOperations(false);
			    		 file=new File(uploadURL + "/" + filename);
			    	     FileInputStream is = new FileInputStream(file);
			    	     long length = file.length();
			    	     ByteBuffer byteBuff=null;

			    	     if (length > Integer.MAX_VALUE) {
			    	     }
			    	     // Create the byte array to hold the data
			    	     byte[] bytes = new byte[(int)length];
			    	     int offset = 0;
			    	     int numRead = 0;
			    	     while (offset < bytes.length
			    	    		 && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
			    	    	 offset += numRead;

			    	     }

			    	     if (offset < bytes.length) {
			    	    	 throw new IOException("Could not completely read file "+file.getName());

			    	     }
			    	     is.close();
			        // Close the input stream and return bytes
			    	    // StringTokenizer strToken=new StringTokenizer( filename,".");

			    	   //  filename=strToken.nextToken();
			    	   //  fileExtension=strToken.nextToken();

			    }// end of 'try' loop
				catch (Exception e) {

			      System.err.println("Error: " + e.getMessage());
			      e.printStackTrace();
			    }*/
				hbt.update(prjAddPtDetail);
			}
		}
		prjSiteResMapSiteList = session.createCriteria(PrjSiteResMap.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader","header").add(Restrictions.eq("header.Id", siteId)).list();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		prjAddPatientHeaderList = session.createCriteria(PrjAddPtHeader.class).add(Restrictions.idEq(addPatientHeaderId)).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
		map.put("prjAddPatientHeaderList", prjAddPatientHeaderList);
		map.put("prjSiteResMapSiteList", prjSiteResMapSiteList);
		map.put("projectList", projectList);
		return map;
	}
	public Map<String, Object> ModifyPatientSchedule(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjSiteResMap> prjSiteResMapList = new ArrayList<PrjSiteResMap>();
		List<PrjSiteResMap> prjSiteResMapSiteList = new ArrayList<PrjSiteResMap>();
		List<PrjAddPtHeader> prjAddPatientHeaderList1 = new ArrayList<PrjAddPtHeader>();
		Session session = (Session)getSession();
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId= (Integer)generalMap.get("projectId");
		}
		Users users = new Users();
		if(generalMap.get("users")!= null){
			users= (Users)generalMap.get("users");
		}
		int siteId = 0;
		if(generalMap.get("siteId")!= null){
			siteId= (Integer)generalMap.get("siteId");
		}
		int employeeId = users.getEmployee().getId();
		String message = "";
		prjSiteResMapList = session.createCriteria(PrjSiteResMap.class).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("Employee", "emp").add(Restrictions.eq("emp.Id", employeeId)).createAlias("Pjr", "role").add(Restrictions.eq("role.PjrCode", "PL")).list();
		if(prjSiteResMapList.size()>0){
			prjAddPatientHeaderList1 = session.createCriteria(PrjAddPtHeader.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
			map.put("prjAddPatientHeaderList1", prjAddPatientHeaderList1);
		}else{
			message = "Don't Modify Patient";
			map.put("message", message);
		}
		prjSiteResMapSiteList = session.createCriteria(PrjSiteResMap.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader","header").add(Restrictions.eq("header.Id", siteId)).list();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		map.put("prjSiteResMapSiteList", prjSiteResMapSiteList);
		map.put("projectList", projectList);
		return map;
	}
	public Map<String, Object> saveModifyPatientSchedule(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjSiteResMap> prjSiteResMapList = new ArrayList<PrjSiteResMap>();
		List<PrjSiteResMap> prjSiteResMapSiteList = new ArrayList<PrjSiteResMap>();
		List<PrjAddPtHeader> prjAddPatientHeaderList1 = new ArrayList<PrjAddPtHeader>();
		List<PrjAddPtHeader> prjAddPatientHeaderList = new ArrayList<PrjAddPtHeader>();
		Session session = (Session)getSession();
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId= (Integer)generalMap.get("projectId");
		}
		int siteId = 0;
		if(generalMap.get("siteId")!= null){
			siteId= (Integer)generalMap.get("siteId");
		}
		int addPatientHeaderId = 0;
		if(generalMap.get("addPatientHeaderId")!= null){
			addPatientHeaderId= (Integer)generalMap.get("addPatientHeaderId");
		}
		prjAddPatientHeaderList = session.createCriteria(PrjAddPtHeader.class).add(Restrictions.idEq(addPatientHeaderId)).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
		prjSiteResMapSiteList = session.createCriteria(PrjSiteResMap.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader","header").add(Restrictions.eq("header.Id", siteId)).list();
		prjAddPatientHeaderList1 = session.createCriteria(PrjAddPtHeader.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		map.put("prjSiteResMapSiteList", prjSiteResMapSiteList);
		map.put("prjAddPatientHeaderList", prjAddPatientHeaderList);
		map.put("prjAddPatientHeaderList1", prjAddPatientHeaderList1);
		map.put("projectList", projectList);
		return map;
	}
	public Map<String, Object> updateModifyPatientScheduleByPL(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjSiteResMap> prjSiteResMapList = new ArrayList<PrjSiteResMap>();
		List<PrjSiteResMap> prjSiteResMapSiteList = new ArrayList<PrjSiteResMap>();
		List<PrjAddPtHeader> prjAddPatientHeaderList1 = new ArrayList<PrjAddPtHeader>();
		List<PrjAddPtHeader> prjAddPatientHeaderList = new ArrayList<PrjAddPtHeader>();
		Session session = (Session)getSession();
		List addPatientDetailIdList = new ArrayList();
		List revisedDateList = new ArrayList();
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId= (Integer)generalMap.get("projectId");
		}
		int siteId = 0;
		if(generalMap.get("siteId")!= null){
			siteId= (Integer)generalMap.get("siteId");
		}
		int addPatientHeaderId = 0;
		if(generalMap.get("addPatientHeaderId")!= null){
			addPatientHeaderId= (Integer)generalMap.get("addPatientHeaderId");
		}
		if(generalMap.get("addPatientDetailIdList")!= null){
			addPatientDetailIdList= (List)generalMap.get("addPatientDetailIdList");
		}
		if(generalMap.get("revisedDateList")!= null){
			revisedDateList= (List)generalMap.get("revisedDateList");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);


		if(addPatientDetailIdList.size()>0){
			for (int i = 0; i <addPatientDetailIdList.size(); i++) {
				PrjAddPtDetail prjAddPtDetail= (PrjAddPtDetail)hbt.load(PrjAddPtDetail.class, (new Integer(addPatientDetailIdList.get(i).toString())));
				if(revisedDateList.get(i) != null){
					Date revisedDate = HMSUtil.convertStringTypeDateToDateType(revisedDateList.get(i).toString());
					prjAddPtDetail.setRevisedDate(revisedDate);
				}
				hbt.update(prjAddPtDetail);
			}
		}
		prjAddPatientHeaderList = session.createCriteria(PrjAddPtHeader.class).add(Restrictions.idEq(addPatientHeaderId)).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
		prjSiteResMapSiteList = session.createCriteria(PrjSiteResMap.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader","header").add(Restrictions.eq("header.Id", siteId)).list();
		prjAddPatientHeaderList1 = session.createCriteria(PrjAddPtHeader.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		map.put("prjSiteResMapSiteList", prjSiteResMapSiteList);
		map.put("prjAddPatientHeaderList", prjAddPatientHeaderList);
		map.put("prjAddPatientHeaderList1", prjAddPatientHeaderList1);
		map.put("projectList", projectList);
		return map;
	}





//======================================Code By  Rajendra=================================================================

	/********************************** Methods For Country Wise Patient JSP   Start  *************************************/
	public Map<String, Object> showCountryWisePatientJsp(int projectId){
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<MasCountry>  countryList = new ArrayList<MasCountry>();
		List<MasCountry> gridCountryList = new ArrayList<MasCountry>();
		List<CntrReqPat>  patientRequiredList = new ArrayList<CntrReqPat>();
		Session session =(Session) getSession();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		countryList = session.createCriteria(MasCountry.class).add(Restrictions.eq("Status", "y")).list();
		gridCountryList = session.createCriteria(MasCountry.class).list();
		patientRequiredList = session.createCriteria(CntrReqPat.class).add(Restrictions.eq("Status", "y")).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();



		map.put("countryList", countryList);
		map.put("gridCountryList", gridCountryList);
		map.put("patientRequiredList", patientRequiredList);
		map.put("projectList", projectList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public boolean addPatientRequired(CntrReqPat cntrReqPat){
		boolean successfullyAdded =false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(cntrReqPat);
		hbt.flush();
		hbt.refresh(cntrReqPat);
		successfullyAdded =true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean editPatientRequired(Map<String, Object> generalMap){
		boolean dataUpdated = false;

		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";

		int countryPatientId = 0;
		int countryId = 0;
		int patientRequired =0;
		try{
		countryPatientId = (Integer)generalMap.get("id");
		countryId = (Integer) generalMap.get("countryId");
		patientRequired = (Integer) generalMap.get("patientRequired");

		changedBy = (String)generalMap.get("changedBy");
		currentDate = (Date)generalMap.get("currentDate");
		currentTime = (String)generalMap.get("currentTime");

		CntrReqPat cntrReqPat = (CntrReqPat)getHibernateTemplate().load(CntrReqPat.class, countryPatientId);
		cntrReqPat.setId(countryPatientId);

		if(countryId != 0){
		    MasCountry masCountry =new MasCountry();
		    masCountry.setId(countryId);
		    cntrReqPat.setCountry(masCountry);
		}

		if(hospitalId != 0){
		    MasHospital masHospital =new MasHospital();
		    masHospital.setId(hospitalId);
		    cntrReqPat.setCompany(masHospital);
		}

	    cntrReqPat.setPatientRequired(patientRequired);
	    cntrReqPat.setLastChgBy(changedBy);
	    cntrReqPat.setLastChgDate(currentDate);
	    cntrReqPat.setLastChgTime(currentTime);

	    org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.update(cntrReqPat);
		dataUpdated = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean deletePatientRequired(Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";

		int countryPatientId = 0;
		try{
		countryPatientId = (Integer)generalMap.get("id");

		changedBy = (String)generalMap.get("changedBy");
		currentDate = (Date)generalMap.get("currentDate");
		currentTime = (String)generalMap.get("currentTime");

		CntrReqPat cntrReqPat = (CntrReqPat)getHibernateTemplate().load(CntrReqPat.class, countryPatientId);
		cntrReqPat.setId(countryPatientId);

		if (cntrReqPat.getStatus().equals("y")){
			cntrReqPat.setStatus("n");
			dataDeleted=true;
		}else{
			cntrReqPat.setStatus("y");
			dataDeleted=false;
		}

	    cntrReqPat.setLastChgBy(changedBy);
	    cntrReqPat.setLastChgDate(currentDate);
	    cntrReqPat.setLastChgTime(currentTime);
	    org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.update(cntrReqPat);
		dataDeleted = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}

	/********************************** Methods For Other Vitals JSP   Start  *************************************/
	public Map<String, Object> showOtherVitalsJsp(int projectId){
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjOthervitals> otherVitalsList = new ArrayList<PrjOthervitals>();

		Session session =(Session) getSession();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		otherVitalsList = session.createCriteria(PrjOthervitals.class).add(Restrictions.eq("Status", "y")).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();



		map.put("otherVitalsList", otherVitalsList);
		map.put("projectList", projectList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean addOtherVitals(PrjOthervitals prjOthervitals){
		boolean successfullyAdded =false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(prjOthervitals);
		hbt.flush();
		hbt.refresh(prjOthervitals);
		successfullyAdded =true;
		return successfullyAdded;
	}


	@SuppressWarnings("unchecked")
	public boolean editOtherVitals(Map<String, Object> generalMap){
		boolean dataUpdated = false;
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url="";
		int otherVitalId = 0;
		String vitalDescription ="";
		String vitalValue = "";


		try{
		otherVitalId = (Integer)generalMap.get("id");
		vitalDescription = (String) generalMap.get("vitalDescription");
		vitalValue = (String) generalMap.get("vitalValue");

		changedBy = (String)generalMap.get("changedBy");
		currentDate = (Date)generalMap.get("currentDate");
		currentTime = (String)generalMap.get("currentTime");

		PrjOthervitals prjOthervitals =(PrjOthervitals) getHibernateTemplate().load(PrjOthervitals.class, otherVitalId);
		prjOthervitals.setId(otherVitalId);

		if(hospitalId != 0){
		    MasHospital masHospital =new MasHospital();
		    masHospital.setId(hospitalId);
		    prjOthervitals.setCompany(masHospital);
		}

		prjOthervitals.setOvtDesc(vitalDescription);
		prjOthervitals.setOvtVal(vitalValue);
	    prjOthervitals.setLastChgBy(changedBy);
	    prjOthervitals.setLastChgDate(currentDate);
	    prjOthervitals.setLastChgTime(currentTime);

	    org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.update(prjOthervitals);
		dataUpdated = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteOtherVitals(Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";

		int otherVitalsId = 0;
		try{
		otherVitalsId = (Integer)generalMap.get("id");

		changedBy = (String)generalMap.get("changedBy");
		currentDate = (Date)generalMap.get("currentDate");
		currentTime = (String)generalMap.get("currentTime");

		PrjOthervitals prjOthervitals =(PrjOthervitals)getHibernateTemplate().load(PrjOthervitals.class, otherVitalsId);

		prjOthervitals.setId(otherVitalsId);

		if (prjOthervitals.getStatus().equals("y")){
			prjOthervitals.setStatus("n");
			dataDeleted=true;
		}else{
			prjOthervitals.setStatus("y");
			dataDeleted=false;
		}

	    prjOthervitals.setLastChgBy(changedBy);
	    prjOthervitals.setLastChgDate(currentDate);
	    prjOthervitals.setLastChgTime(currentTime);
	    org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.update(prjOthervitals);
		dataDeleted = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}

	/********************************** Methods For Other Vitals JSP   Start  *************************************/
	public Map<String, Object> showPatientVisitScheduleJsp(int projectId){
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjPatvisitsch> patientVisitScheduleList = new ArrayList<PrjPatvisitsch>();
		List<MstrPtvisit> patientVisitList = new ArrayList<MstrPtvisit>();
		List<HrMasVisitType> masVisitTypeList = new ArrayList<HrMasVisitType>();

		Session session =(Session) getSession();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		patientVisitScheduleList = session.createCriteria(PrjPatvisitsch.class).add(Restrictions.eq("Status", "y")).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
		patientVisitList = session.createCriteria(MstrPtvisit.class).add(Restrictions.eq("Status", "y")).list();
		masVisitTypeList = session.createCriteria(HrMasVisitType.class)
									.add(Restrictions.eq("Status", "y")).list();

		map.put("masVisitTypeList", masVisitTypeList);
		map.put("patientVisitScheduleList", patientVisitScheduleList);
		map.put("projectList", projectList);
		map.put("patientVisitList", patientVisitList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean addPatientVisitSchedule(PrjPatvisitsch prjPatvisitsch){
		boolean successfullyAdded =false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(prjPatvisitsch);
		hbt.flush();
		hbt.refresh(prjPatvisitsch);
		successfullyAdded =true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean editPatientVisitSchedule(Map<String, Object> generalMap){
		boolean dataUpdated = false;
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url="";

		int patientVisitScheduleId = 0;
		int patientVisitId =0;
		int visitInterval = 0;
		int betweenVisit = 0;
		int entireSchedule = 0;
		int visitTypeId = 0;

		try{
		patientVisitScheduleId = (Integer)generalMap.get("id");
		patientVisitId = (Integer) generalMap.get("patientVisitId");
		visitTypeId = (Integer) generalMap.get("visitTypeId");
		visitInterval = (Integer) generalMap.get("visitInterval");
		betweenVisit = (Integer) generalMap.get("betweenVisit");
		entireSchedule = (Integer) generalMap.get("entireSchedule");

		changedBy = (String)generalMap.get("changedBy");
		currentDate = (Date)generalMap.get("currentDate");
		currentTime = (String)generalMap.get("currentTime");

		PrjPatvisitsch prjPatvisitsch = (PrjPatvisitsch)getHibernateTemplate().load(PrjPatvisitsch.class, patientVisitScheduleId);
		prjPatvisitsch.setId(patientVisitScheduleId);

		if(hospitalId != 0){
		    MasHospital masHospital =new MasHospital();
		    masHospital.setId(hospitalId);
		    prjPatvisitsch.setCompany(masHospital);
		}

		if(patientVisitId != 0){
			MstrPtvisit mstrPtvisit = new MstrPtvisit();
			mstrPtvisit.setId(patientVisitId);
			prjPatvisitsch.setPatientVisit(mstrPtvisit);
		}

		if(visitTypeId != 0){
			HrMasVisitType hrMasVisitType = new HrMasVisitType();
			hrMasVisitType.setId(visitTypeId);
			prjPatvisitsch.setVisitType(hrMasVisitType);
		}

		prjPatvisitsch.setPvInt(visitInterval);
		prjPatvisitsch.setBetweenVisit(betweenVisit);
		prjPatvisitsch.setEntireSchedule(entireSchedule);
		prjPatvisitsch.setLastChgBy(changedBy);
		prjPatvisitsch.setLastChgDate(currentDate);
		prjPatvisitsch.setLastChgTime(currentTime);

	    org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.update(prjPatvisitsch);
		hbt.flush();
		hbt.refresh(prjPatvisitsch);
		dataUpdated = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean deletePatientVisitSchedule(Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";

		int patientVisitScheduleId = 0;
		try{
		patientVisitScheduleId = (Integer)generalMap.get("id");

		changedBy = (String)generalMap.get("changedBy");
		currentDate = (Date)generalMap.get("currentDate");
		currentTime = (String)generalMap.get("currentTime");

		PrjPatvisitsch prjPatvisitsch = (PrjPatvisitsch)getHibernateTemplate().load(PrjPatvisitsch.class, patientVisitScheduleId);
		prjPatvisitsch.setId(patientVisitScheduleId);

		if (prjPatvisitsch.getStatus().equals("y")){
			prjPatvisitsch.setStatus("n");
			dataDeleted=true;
		}else{
			prjPatvisitsch.setStatus("y");
			dataDeleted=false;
		}

		prjPatvisitsch.setLastChgBy(changedBy);
		prjPatvisitsch.setLastChgDate(currentDate);
		prjPatvisitsch.setLastChgTime(currentTime);
	    org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.update(prjPatvisitsch);
		dataDeleted = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}

	/************************* Methods For Vendor Contract JSP   Start  ***********************************************/
	public Map<String, Object> showVendorContractJsp(int projectId){
		List<MstrVendor> vendorMasterList = new ArrayList<MstrVendor>();
		List<PrjVendorcontract> vendorContractList = new ArrayList<PrjVendorcontract>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<VendorServiceType> vendorServiceTypeList = new ArrayList<VendorServiceType>();

		Session session = (Session)getSession();
		vendorMasterList =session.createCriteria(MstrVendor.class).list();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		vendorContractList = session.createCriteria(PrjVendorcontract.class).add(Restrictions.eq("Status", "y")).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
		vendorServiceTypeList = session.createCriteria(VendorServiceType.class).add(Restrictions.eq("Status", "y")).list();

		map.put("vendorMasterList", vendorMasterList);
		map.put("projectList", projectList);
		map.put("vendorContractList", vendorContractList);
		map.put("vendorServiceTypeList", vendorServiceTypeList);

		return map;
	}

	public boolean addVendorContract(PrjVendorcontract prjVendorcontract){
		boolean successfullyAdded =false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(prjVendorcontract);
		hbt.flush();
		hbt.refresh(prjVendorcontract);
		successfullyAdded =true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean editVendorContract(Map<String, Object> generalMap){
		boolean dataUpdated = false;
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url="";
	    int vendorContractId = 0;
		int vendorId = 0;
		int vendorServiceId =0;
		Date contractDate = new Date();

		try{
		vendorContractId = (Integer)generalMap.get("id");
		vendorId = (Integer) generalMap.get("vendorId");
		contractDate = (Date) generalMap.get("contractDate");
		vendorServiceId = (Integer) generalMap.get("vendorServiceId");
		changedBy = (String)generalMap.get("changedBy");
		currentDate = (Date)generalMap.get("currentDate");
		currentTime = (String)generalMap.get("currentTime");

		PrjVendorcontract prjVendorcontract = (PrjVendorcontract)getHibernateTemplate().load(PrjVendorcontract.class, vendorContractId);
		prjVendorcontract.setId(vendorContractId);

		if(vendorId != 0){
			MstrVendor mstrVendor = new MstrVendor();
			mstrVendor.setId(vendorId);
			prjVendorcontract.setVendor(mstrVendor);
		}

		if(vendorServiceId != 0){
			VendorServiceType vendorServiceType = new VendorServiceType();
			vendorServiceType.setId(vendorServiceId);
			prjVendorcontract.setVendorServiceType(vendorServiceType);
		}

		if(hospitalId != 0){
		    MasHospital masHospital =new MasHospital();
		    masHospital.setId(hospitalId);
		    prjVendorcontract.setCompany(masHospital);
		}

		prjVendorcontract.setVcDate(contractDate);
		prjVendorcontract.setLastChgBy(changedBy);
		prjVendorcontract.setLastChgDate(currentDate);
		prjVendorcontract.setLastChgTime(currentTime);

	    org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.update(prjVendorcontract);
		hbt.flush();
		hbt.refresh(prjVendorcontract);
		dataUpdated = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteVendorContract(Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";

		int vendorContractId = 0;
		try{
		vendorContractId = (Integer)generalMap.get("id");

		changedBy = (String)generalMap.get("changedBy");
		currentDate = (Date)generalMap.get("currentDate");
		currentTime = (String)generalMap.get("currentTime");

		PrjVendorcontract prjVendorcontract = (PrjVendorcontract)getHibernateTemplate().load(PrjVendorcontract.class, vendorContractId);
		prjVendorcontract.setId(vendorContractId);

		if (prjVendorcontract.getStatus().equals("y")){
			prjVendorcontract.setStatus("n");
			dataDeleted=true;
		}else{
			prjVendorcontract.setStatus("y");
			dataDeleted=false;
		}

		prjVendorcontract.setLastChgBy(changedBy);
		prjVendorcontract.setLastChgDate(currentDate);
		prjVendorcontract.setLastChgTime(currentTime);
	    org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.update(prjVendorcontract);
		dataDeleted = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}


	/************************* Methods For Vendor Contract JSP   Start  ***********************************************/
	public Map<String, Object> showAddProjectVitals(int projectId){
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MstrVitals> vitalsMasterList = new ArrayList<MstrVitals>();
		List<ProjectVitals> projectVitalsList = new ArrayList<ProjectVitals>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		Session session = (Session)getSession();
		vitalsMasterList = session.createCriteria(MstrVitals.class).add(Restrictions.eq("Status", "y")).list();
		projectVitalsList = session.createCriteria(ProjectVitals.class).add(Restrictions.eq("Status", "y")).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
		map.put("vitalsMasterList", vitalsMasterList);
		map.put("projectVitalsList", projectVitalsList);
		map.put("projectList", projectList);
		map.put("currencyList", currencyList);
		return map;
	}

	public boolean addProjectVital(ProjectVitals projectVitals){
		boolean successfullyAdded =false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(projectVitals);
		hbt.flush();
		hbt.refresh(projectVitals);
		successfullyAdded =true;
		return successfullyAdded;
	}


	@SuppressWarnings("unchecked")
	public boolean editProjectVital(Map<String, Object> generalMap){
		boolean dataUpdated = false;
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url = "";
		int projectId = 0;
		int vitalId = 0;
		int projectVitalId = 0;
		String plannedDate   = "";
		String remarkOne   = "";
		String revisedDate   = "";
		String remarkTwo   = "";
		String actualDate    = "";
		String remarkThree = "";

		try{
		projectVitalId = (Integer)generalMap.get("id");
		vitalId = (Integer) generalMap.get("vitalId");
		plannedDate = (String) generalMap.get("plannedDate");
		remarkOne   = (String)generalMap.get("remarkOne");
		revisedDate = (String) generalMap.get("revisedDate");
		remarkTwo   = (String)generalMap.get("remarkTwo");
		actualDate = (String) generalMap.get("actualDate");
		remarkThree   = (String)generalMap.get("remarkThree");

		changedBy = (String)generalMap.get("changedBy");
		currentDate = (Date)generalMap.get("currentDate");
		currentTime = (String)generalMap.get("currentTime");
		String flag = "";
		if(generalMap.get("flag")!= null){
			flag =(String)generalMap.get("flag");
		}
		String amountFlag = "";
		if(generalMap.get("amountFlag")!= null){
			amountFlag =(String)generalMap.get("amountFlag");
		}
		int currencyId = 0;
		if(generalMap.get("currencyId")!= null){
			currencyId =(Integer)generalMap.get("currencyId");
		}
		ProjectVitals projectVitals = (ProjectVitals)getHibernateTemplate().load(ProjectVitals.class, projectVitalId);
		projectVitals.setId(projectVitalId);

		if(vitalId != 0){
			MstrVitals mstrVitals = new MstrVitals();
			mstrVitals.setId(vitalId);
			projectVitals.setVital(mstrVitals);
		}
		if(hospitalId != 0){
		    MasHospital masHospital =new MasHospital();
		    masHospital.setId(hospitalId);
		    projectVitals.setCompany(masHospital);
		}
		if(flag.equals("D")){
			projectVitals.setPlannedDate(HMSUtil.convertStringTypeDateToDateType(plannedDate));
			projectVitals.setRevisedDate(HMSUtil.convertStringTypeDateToDateType(revisedDate));
			projectVitals.setActualDate(HMSUtil.convertStringTypeDateToDateType(actualDate));
		}else if(flag.equals("V")){
			if(amountFlag.equals("yes")){
				projectVitals.setPlannedValue(new BigDecimal(plannedDate));
				projectVitals.setRevisedValue(new BigDecimal(revisedDate));
				projectVitals.setActualValue(new BigDecimal(actualDate));
				MasCurrency masCurrency = new MasCurrency();
				masCurrency.setId(currencyId);
				projectVitals.setCurrency(masCurrency);
			}else if(amountFlag.equals("no")){
				projectVitals.setPlannedValue(new BigDecimal(plannedDate));
				projectVitals.setRevisedValue(new BigDecimal(revisedDate));
				projectVitals.setActualValue(new BigDecimal(actualDate));
			}
		}

		//projectVitals.setPlannedDate(plannedDate);
		projectVitals.setRemarkOne(remarkOne);
		//projectVitals.setRevisedDate(revisedDate);
		projectVitals.setRemarkTwo(remarkTwo);
		//projectVitals.setActualDate(actualDate);
		projectVitals.setRemarkThree(remarkThree);
		projectVitals.setStatus("y");
		projectVitals.setLastChgBy(changedBy);
		projectVitals.setLastChgDate(currentDate);
		projectVitals.setLastChgTime(currentTime);

	    org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.update(projectVitals);
		hbt.flush();
		hbt.refresh(projectVitals);
		dataUpdated = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteProjectVital(Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";

		int projectVitalId = 0;
		try{
			projectVitalId = (Integer)generalMap.get("id");

		changedBy = (String)generalMap.get("changedBy");
		currentDate = (Date)generalMap.get("currentDate");
		currentTime = (String)generalMap.get("currentTime");

		ProjectVitals projectVitals = (ProjectVitals)getHibernateTemplate().load(ProjectVitals.class, projectVitalId);
		projectVitals.setId(projectVitalId);

		if (projectVitals.getStatus().equals("y")){
			projectVitals.setStatus("n");
			dataDeleted=true;
		}else{
			projectVitals.setStatus("y");
			dataDeleted=false;
		}

		projectVitals.setLastChgBy(changedBy);
		projectVitals.setLastChgDate(currentDate);
		projectVitals.setLastChgTime(currentTime);
	    org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.update(projectVitals);
		dataDeleted = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}


 	/********* Methods For Regulatory Submission JSP   Start ********************************/

	public Map<String, Object> showRegulatorSubmissionJsp(int projectId){
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList =new ArrayList<MstrProject>();
		List<MstrRegulatoryStatus> regulatoryStatusLst =new ArrayList<MstrRegulatoryStatus>();
		List<MstrDoctype> documentTypeList =new ArrayList<MstrDoctype>();
		List<MstrDocument> documentList = new ArrayList<MstrDocument>();
		List<PrjReglSub>  regulatorySubList = new ArrayList<PrjReglSub>();
		List<PrjReglSubDoc> regulatorySubDocList = new ArrayList<PrjReglSubDoc>();
		Session session = getSession();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		regulatoryStatusLst = session.createCriteria(MstrRegulatoryStatus.class).add(Restrictions.eq("Status", "y")).list();
		documentTypeList = session.createCriteria(MstrDoctype.class).add(Restrictions.eq("Status", "y")).list();
		documentList = session.createCriteria(MstrDocument.class).add(Restrictions.eq("Status", "y")).list();
		regulatorySubList= session.createCriteria(PrjReglSub.class).list();
		regulatorySubDocList = session.createCriteria(PrjReglSubDoc.class).add(Restrictions.eq("Status", "y")).list();
		map.put("projectList", projectList);
		map.put("regulatoryStatusLst", regulatoryStatusLst);
		map.put("documentTypeList", documentTypeList);
		map.put("documentList", documentList);
		map.put("regulatorySubList", regulatorySubList);
		map.put("regulatorySubDocList", regulatorySubDocList);

		return map;
	}

public Map<String, Object> AttachReglSubDocFile(Map<String, Object> generalMap){

		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		int hospitalId =0;
		int projectId = 0;
		int regulatorySubId = 0;
		String comments = "";

		Map<String, Object> map = new HashMap<String, Object>();
		List<PrjReglSubDoc> regulatorySubDocList = new ArrayList<PrjReglSubDoc>();
		List<PrjReglSub>   regulatorySubList = new ArrayList<PrjReglSub>();
		Session session = (Session)getSession();
		String filename = "";


		if (generalMap.get("projectId") != null){
			projectId =(Integer)generalMap.get("projectId");
		}
		if(generalMap.get("regulatorySubId") != null){
			regulatorySubId = (Integer)generalMap.get("regulatorySubId");
		}
		if (generalMap.get("hospitalId") != null){
			hospitalId =(Integer)generalMap.get("hospitalId");
		}

		if(generalMap.get("changedBy")!= null){
			changedBy =(String) generalMap.get("changedBy");
		}
		if(generalMap.get("filename")!= null){
			currentDate =(Date) generalMap.get("currentDate");
		}
		if(generalMap.get("filename")!= null){
			currentTime =(String) generalMap.get("currentTime");
		}

		if(generalMap.get("filename")!= null){
			filename =(String) generalMap.get("filename");
		}
		String uploadURL = "";
		if(generalMap.get("uploadURL")!= null){
			uploadURL =(String) generalMap.get("uploadURL");
		}

		if(generalMap.get("comments")!= null){
			comments =(String) generalMap.get("comments");
		}

		String fileExtension=null;
		 File file=null;
		 try {
				HibernateTemplate hbt=getHibernateTemplate();
				hbt.setCheckWriteOperations(false);

	    		 file=new File(uploadURL + "/" + filename);
	    	     FileInputStream is = new FileInputStream(file);
	    	     long length = file.length();
	    	    // ByteBuffer byteBuff=null;

	    	     if (length > Integer.MAX_VALUE) {

	    	     }
	    	     // Create the byte array to hold the data
	    	     byte[] bytes = new byte[(int)length];
	    	     int offset = 0;
	    	     int numRead = 0;
	    	     while (offset < bytes.length
	    	    		 && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	    	    	 offset += numRead;

	    	     }

	    	     if (offset < bytes.length) {
	    	    	 throw new IOException("Could not completely read file "+file.getName());

	    	     }
	    	     is.close();

	    	     PrjReglSubDoc prjReglSubDoc = new PrjReglSubDoc();

	    	     prjReglSubDoc.setPrjReglSubFilename(filename);

	    	     if(regulatorySubId != 0){
	    	    	 PrjReglSub prjReglSub = new PrjReglSub();
	    	    	 prjReglSub.setId(regulatorySubId);
	    	    	 prjReglSubDoc.setPjrReglSub(prjReglSub);
	    	     }
	    	     if(projectId != 0){
	    	    	 MstrProject mstrProject = new MstrProject();
	    	    	 mstrProject.setId(projectId);
	    	    	 prjReglSubDoc.setProject(mstrProject);
	    	     }
	    	     if(hospitalId != 0){
	    	    	 MasHospital masHospital = new MasHospital();
	    	    	 masHospital.setId(hospitalId);
	    	    	 prjReglSubDoc.setCompany(masHospital);
	    	     }
	    	     prjReglSubDoc.setDocComments(comments);
	    	     prjReglSubDoc.setStatus("y");
	    	     prjReglSubDoc.setLastChgBy(changedBy);
	    	     prjReglSubDoc.setLastChgDate(currentDate);
	    	     prjReglSubDoc.setLastChgTime(currentTime);
	    	     hbt.save(prjReglSubDoc);




	    }catch (Exception e) {

	      e.printStackTrace();
	    }
		regulatorySubDocList = session.createCriteria(PrjReglSubDoc.class).add(Restrictions.eq("PjrReglSub.Id", regulatorySubId)).list();
		regulatorySubList = session.createCriteria(PrjReglSub.class).add(Restrictions.idEq(regulatorySubId)).list();
		map.put("regulatorySubDocList", regulatorySubDocList);
		map.put("regulatorySubList", regulatorySubList);
		return map;
	}



   public Map<String, Object> displayAttachment(int regulatorySubId){
	    Map<String, Object> map = new HashMap<String, Object>();
		List<PrjReglSubDoc> regulatorySubDocList = new ArrayList<PrjReglSubDoc>();
		List<PrjReglSub>   regulatorySubList = new ArrayList<PrjReglSub>();
		Session session = (Session)getSession();
		//Criteria crtRegDoc = session.createCriteria(PrjReglSubDoc.class);

		regulatorySubDocList = session.createCriteria(PrjReglSubDoc.class).add(Restrictions.eq("PjrReglSub.Id", regulatorySubId)).list();
		regulatorySubList = session.createCriteria(PrjReglSub.class).add(Restrictions.idEq(regulatorySubId)).list();
		map.put("regulatorySubDocList", regulatorySubDocList);
		map.put("regulatorySubList", regulatorySubList);
		return map;
   }


   public Map<String, Object> deleteAttachReglSubDocFile(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<TempTickattach> regulatorySubDocList = new ArrayList<TempTickattach>();
		List<PrjReglSub>   regulatorySubList = new ArrayList<PrjReglSub>();
		Session session = (Session)getSession();
		List uploadFileNameList = new ArrayList();
		List regulatorySubDocIdList = new ArrayList();
		int regulatorySubId =0;

		if(generalMap.get("uploadFileNameList")!= null){
			uploadFileNameList =(List)generalMap.get("uploadFileNameList");
		}

		if(generalMap.get("regulatorySubId") != null){
			regulatorySubId =(Integer)generalMap.get("regulatorySubId");
		}

		if(generalMap.get("regulatorySubDocIdList")!= null){
			regulatorySubDocIdList =(List)generalMap.get("regulatorySubDocIdList");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);


		int regulatorySubDocId = 0;
		if(regulatorySubDocIdList.size()>0){
			for (int i = 0; i < regulatorySubDocIdList.size(); i++) {
				if(regulatorySubDocIdList.get(i) != null){
					regulatorySubDocId = Integer.parseInt(regulatorySubDocIdList.get(i).toString());
					PrjReglSubDoc prjreglsubDoc = (PrjReglSubDoc)hbt.load(PrjReglSubDoc.class, regulatorySubDocId);
					hbt.delete(prjreglsubDoc);
				}
			}
		}
		regulatorySubDocList = session.createCriteria(PrjReglSubDoc.class).add(Restrictions.eq("PjrReglSub.Id", regulatorySubId)).list();
		regulatorySubList = session.createCriteria(PrjReglSub.class).add(Restrictions.idEq(regulatorySubId)).list();
		map.put("regulatorySubDocList", regulatorySubDocList);
		map.put("regulatorySubList", regulatorySubList);
		return map;
	}

    public boolean addRegulatorySubmission(PrjReglSub prjreglSub){
    	boolean successfullyAdded =false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(prjreglSub);
		hbt.flush();
		hbt.refresh(prjreglSub);
		successfullyAdded =true;
		return successfullyAdded;
    }


    public boolean editRegulatorySubmission(Map<String, Object> generalMap){
    	boolean dataUpdated = false;
    	String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		int    hospitalId =0;
		String message = "";
		String title="";
		String url = "";

    	int regulatorySubId =0;
		Date submissionDate = null;
		Date approvalDate   = null;
		int regulatoryStatusId = 0;
		String regulatoryComments = "";
		int docTypeId = 0;
		String referenceCode = "";
		String[] documentIds = new String[0];
		String remarks = "";

    	try{
    		regulatorySubId = (Integer)generalMap.get("id");
    		submissionDate = (Date) generalMap.get("submissionDate");
    		approvalDate = (Date) generalMap.get("approvalDate");
    		regulatoryStatusId = (Integer) generalMap.get("regulatoryStatusId");
    		regulatoryComments = (String) generalMap.get("regulatoryComments");
    		docTypeId = (Integer) generalMap.get("docTypeId");
    		referenceCode = (String) generalMap.get("referenceCode");
    		documentIds = (String[]) generalMap.get("documentIds");
    		remarks = (String) generalMap.get("remarks");

    		hospitalId =(Integer)generalMap.get("hospitalId");
    		changedBy = (String)generalMap.get("changedBy");
    		currentDate = (Date)generalMap.get("currentDate");
    		currentTime = (String)generalMap.get("currentTime");

    		PrjReglSub prjreglSub = (PrjReglSub)getHibernateTemplate().load(PrjReglSub.class, regulatorySubId);

    		prjreglSub.setId(regulatorySubId);

    		prjreglSub.setSubDate(submissionDate);
    		prjreglSub.setApprDate(approvalDate);

    		if(regulatoryStatusId !=0){
    			MstrRegulatoryStatus mstrRegulatoryStatus = new MstrRegulatoryStatus();
    			mstrRegulatoryStatus.setId(regulatoryStatusId);
    			prjreglSub.setRegulatoryStatus(mstrRegulatoryStatus);
    		}
    		prjreglSub.setComments(regulatoryComments);

    		if(docTypeId != 0){
    			MstrDoctype mstrDoctype = new MstrDoctype();
    			mstrDoctype.setId(docTypeId);
    			prjreglSub.setDocType(mstrDoctype);
    		}
    		prjreglSub.setReferenceCode(referenceCode);

    		Set<MstrDocument> documentSet = new HashSet<MstrDocument>();
    		for(String docId : documentIds){
    			if(!docId.equals("")){
    				MstrDocument document = new MstrDocument();
    				document.setId(Integer.parseInt(docId));
    				documentSet.add(document);
    			}
    		}
    		prjreglSub.setDoc(documentSet);

    		prjreglSub.setRemark(remarks);

    		if(hospitalId != 0){
    			MasHospital masHospital = new MasHospital();
    			masHospital.setId(hospitalId);
    			prjreglSub.setCompany(masHospital);
    		}


    		prjreglSub.setLastChgBy(changedBy);
    		prjreglSub.setLastChgDate(currentDate);
    		prjreglSub.setLastChgTime(currentTime);

    	    org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
    		hbt.setFlushModeName("FLUSH_EAGER");
    		hbt.update(prjreglSub);
    		hbt.flush();
    		hbt.refresh(prjreglSub);
    		dataUpdated = true;
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    		return dataUpdated;

    }





/********************************* Methods Start For Query Entry JSP  **************************************/

 public	Map<String, Object> showQueryEntryJsp (int projectId){
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjReglSub> regulatorySubList = new ArrayList<PrjReglSub>();
		List<PrjQueryEntry> queryEntryList = new ArrayList<PrjQueryEntry>();
		Session session = getSession();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		regulatorySubList = session.createCriteria(PrjReglSub.class).add(Restrictions.eq("Prj.Id", projectId)).list();
		queryEntryList = session.createCriteria(PrjQueryEntry.class).add(Restrictions.eq("Project.Id", projectId)).list();

		map.put("projectList", projectList);
		map.put("regulatorySubList", regulatorySubList);
		map.put("queryEntryList", queryEntryList);
		return map;
	}

  public Map<String, Object> displayQueryEntryAttachment(int queryEntryId){
	  Map<String, Object> map =new HashMap<String, Object>();
		List<PrjQueryEntry> queryEntryList = new ArrayList<PrjQueryEntry>();
		List<PrjQueryEntryDoc> queryEntryDocList = new ArrayList<PrjQueryEntryDoc>();
		Session session = getSession();
		queryEntryList = session.createCriteria(PrjQueryEntry.class).add(Restrictions.idEq(queryEntryId)).list();
		queryEntryDocList = session.createCriteria(PrjQueryEntryDoc.class).add(Restrictions.eq("QueryEntry.Id", queryEntryId)).list();

		map.put("queryEntryDocList", queryEntryDocList);
		map.put("queryEntryList", queryEntryList);
		return map;

  }

  public boolean addQueryEntry(PrjQueryEntry prjQueryEntry){
	  boolean successfullyAdded =false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(prjQueryEntry);
		hbt.flush();
		hbt.refresh(prjQueryEntry);
		successfullyAdded =true;
		return successfullyAdded;
	}


  public boolean editQueryEntry(Map<String, Object> generalMap){
  	boolean dataUpdated = false;
  	String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		int    hospitalId =0;
		String message = "";
		String title="";
		String url = "";

		int queryEntryId = 0;
		int regulatorySubId = 0;
		Date queryDate = null;
		Date plannedAnsDate   = null;
		String queryDescription = "";


  	try{
  		queryEntryId = (Integer)generalMap.get("id");
  		regulatorySubId = (Integer)generalMap.get("regulatorySubId");
  		queryDate = (Date) generalMap.get("queryDate");
  		plannedAnsDate = (Date) generalMap.get("plannedAnsDate");
  		queryDescription = (String) generalMap.get("queryDescription");

  		hospitalId =(Integer)generalMap.get("hospitalId");
  		changedBy = (String)generalMap.get("changedBy");
  		currentDate = (Date)generalMap.get("currentDate");
  		currentTime = (String)generalMap.get("currentTime");

  		PrjQueryEntry prjQueryEntry = (PrjQueryEntry)getHibernateTemplate().load(PrjQueryEntry.class, queryEntryId);
  		prjQueryEntry.setId(queryEntryId);

  		if(regulatorySubId != 0){
			PrjReglSub prjreglSub = new PrjReglSub();
			prjreglSub.setId(regulatorySubId);
			prjQueryEntry.setReglSub(prjreglSub);
		}

		prjQueryEntry.setQueryDate(queryDate);
		prjQueryEntry.setPlannedAnsDate(plannedAnsDate);


		prjQueryEntry.setQueryDesc(queryDescription);


		if(hospitalId != 0){
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			prjQueryEntry.setCompany(masHospital);
		}
		prjQueryEntry.setStatus("y");
		prjQueryEntry.setLastChgBy(changedBy);
		prjQueryEntry.setLastChgDate(currentDate);
		prjQueryEntry.setLastChgTime(currentTime);

  	    org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
  		hbt.setFlushModeName("FLUSH_EAGER");
  		hbt.update(prjQueryEntry);
  		hbt.flush();
  		hbt.refresh(prjQueryEntry);
  		dataUpdated = true;
  		}catch (Exception e) {
  			e.printStackTrace();
  		}
  		return dataUpdated;

  }

  public Map<String, Object> attachQueryEntryDocFile(Map<String, Object> generalMap){

		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";

		int hospitalId =0;
		int projectId = 0;
		int queryEntryId = 0;
		String filename = "";
		String queryEntryDocComments = "";

		Map<String, Object> map = new HashMap<String, Object>();
		List<PrjQueryEntry> queryEntryList = new ArrayList<PrjQueryEntry>();
		List<PrjQueryEntryDoc> queryEntryDocList = new ArrayList<PrjQueryEntryDoc>();
		Session session = (Session)getSession();

		if (generalMap.get("projectId") != null){
			projectId =(Integer)generalMap.get("projectId");
		}
		if(generalMap.get("queryEntryId") != null){
			queryEntryId = (Integer)generalMap.get("queryEntryId");
		}
		if (generalMap.get("hospitalId") != null){
			hospitalId =(Integer)generalMap.get("hospitalId");
		}

		if(generalMap.get("changedBy")!= null){
			changedBy =(String) generalMap.get("changedBy");
		}
		if(generalMap.get("currentDate")!= null){
			currentDate =(Date) generalMap.get("currentDate");
		}
		if(generalMap.get("currentTime")!= null){
			currentTime =(String) generalMap.get("currentTime");
		}

		if(generalMap.get("filename")!= null){
			filename =(String) generalMap.get("filename");
		}
		String uploadURL = "";
		if(generalMap.get("uploadURL")!= null){
			uploadURL =(String) generalMap.get("uploadURL");
		}

		if(generalMap.get("queryEntryDocComments")!= null){
			queryEntryDocComments =(String) generalMap.get("queryEntryDocComments");
		}

		String fileExtension=null;
		 File file=null;
		 try {
				HibernateTemplate hbt=getHibernateTemplate();
				hbt.setCheckWriteOperations(false);

	    		 file=new File(uploadURL + "/" + filename);
	    	     FileInputStream is = new FileInputStream(file);
	    	     long length = file.length();
	    	    // ByteBuffer byteBuff=null;

	    	     if (length > Integer.MAX_VALUE) {

	    	     }
	    	     // Create the byte array to hold the data
	    	     byte[] bytes = new byte[(int)length];
	    	     int offset = 0;
	    	     int numRead = 0;
	    	     while (offset < bytes.length
	    	    		 && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	    	    	 offset += numRead;

	    	     }

	    	     if (offset < bytes.length) {
	    	    	 throw new IOException("Could not completely read file "+file.getName());

	    	     }
	    	     is.close();

	    	     PrjQueryEntryDoc prjQueryEntryDoc = new PrjQueryEntryDoc();
	    	     prjQueryEntryDoc.setQueryEntryDocFilenmae(filename);

	    	     if(queryEntryId != 0){
	    	    	 PrjQueryEntry prjQueryEntry = new PrjQueryEntry();
	    	    	 prjQueryEntry.setId(queryEntryId);
	    	    	 prjQueryEntryDoc.setQueryEntry(prjQueryEntry);
	    	     }
	    	     if(projectId != 0){
	    	    	 MstrProject mstrProject = new MstrProject();
	    	    	 mstrProject.setId(projectId);
	    	    	 prjQueryEntryDoc.setProject(mstrProject);
	    	     }
	    	     if(hospitalId != 0){
	    	    	 MasHospital masHospital = new MasHospital();
	    	    	 masHospital.setId(hospitalId);
	    	    	 prjQueryEntryDoc.setComapny(masHospital);
	    	     }
	    	     prjQueryEntryDoc.setQueryEntryDocComments(queryEntryDocComments);
	    	     prjQueryEntryDoc.setStatus("y");
	    	     prjQueryEntryDoc.setLastChgBy(changedBy);
	    	     prjQueryEntryDoc.setLastChgDate(currentDate);
	    	     prjQueryEntryDoc.setLastChgTime(currentTime);
	    	     hbt.save(prjQueryEntryDoc);




	    }catch (Exception e) {

	      System.err.println("Error: " + e.getMessage());
	      e.printStackTrace();
	    }
	    queryEntryList = session.createCriteria(PrjQueryEntry.class).add(Restrictions.idEq(queryEntryId)).list();
		queryEntryDocList = session.createCriteria(PrjQueryEntryDoc.class).add(Restrictions.eq("QueryEntry.Id", queryEntryId)).list();

		map.put("queryEntryDocList", queryEntryDocList);
		map.put("queryEntryList", queryEntryList);
		return map;
	}


  public Map<String, Object> deleteAttachQueryEntryDocFile(Map<String, Object> generalMap) {

	  List<PrjQueryEntry> queryEntryList = new ArrayList<PrjQueryEntry>();
		List<PrjQueryEntryDoc> queryEntryDocList = new ArrayList<PrjQueryEntryDoc>();

		Session session = (Session)getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List queryEntryDocIdList = new ArrayList();

		int noOfFiles = 0;
		int queryEntryId = 0;
		int queryEntryDocId = 0;
		if(generalMap.get("queryEntryId") != null){
			queryEntryId =(Integer)generalMap.get("queryEntryId");
		}

		if(generalMap.get("queryEntryDocIdList")!= null){
			queryEntryDocIdList =(List)generalMap.get("queryEntryDocIdList");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);


		if(queryEntryDocIdList.size()>0){
			for (int i = 0; i < queryEntryDocIdList.size(); i++) {
				if(queryEntryDocIdList.get(i) != null){
					queryEntryDocId = Integer.parseInt(queryEntryDocIdList.get(i).toString());
					PrjQueryEntryDoc prjQueryEntryDoc =(PrjQueryEntryDoc)hbt.load(PrjQueryEntryDoc.class, queryEntryDocId);
					hbt.delete(prjQueryEntryDoc);
				}
			}
		}
		queryEntryList = session.createCriteria(PrjQueryEntry.class).add(Restrictions.idEq(queryEntryId)).list();
		queryEntryDocList = session.createCriteria(PrjQueryEntryDoc.class).add(Restrictions.eq("QueryEntry.Id", queryEntryId)).list();

		map.put("queryEntryDocList", queryEntryDocList);
		map.put("queryEntryList", queryEntryList);
		return map;
	}


  /********************************* Methods Start For Ans Entry JSP  **************************************/

  public	Map<String, Object> showAnsEntryJsp (int projectId){
 		Map<String, Object> map =new HashMap<String, Object>();
 		List<MstrProject> projectList = new ArrayList<MstrProject>();
 		List<PrjQueryEntry> queryEntryList = new ArrayList<PrjQueryEntry>();
 		List<PrjAnsEntry> ansEntryList = new ArrayList<PrjAnsEntry>();
 		Session session = getSession();
 		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
 		ansEntryList = session.createCriteria(PrjAnsEntry.class).add(Restrictions.eq("Project.Id", projectId)).list();
 		queryEntryList = session.createCriteria(PrjQueryEntry.class).add(Restrictions.eq("Project.Id", projectId)).list();

 		map.put("projectList", projectList);
 		map.put("ansEntryList", ansEntryList);
 		map.put("queryEntryList", queryEntryList);
 		return map;
 	}

  public Map<String, Object> displayAnsEntryAttachment(int ansEntryId){
	  Map<String, Object> map =new HashMap<String, Object>();
	    List<PrjAnsEntry>    ansEntryList = new ArrayList<PrjAnsEntry>();
		List<PrjAnsEntryDoc> ansEntryDocList = new ArrayList<PrjAnsEntryDoc>();
		Session session = getSession();
		ansEntryList = session.createCriteria(PrjAnsEntry.class).add(Restrictions.idEq(ansEntryId)).list();
		ansEntryDocList = session.createCriteria(PrjAnsEntryDoc.class).add(Restrictions.eq("AnsEntry.Id", ansEntryId)).list();

		map.put("ansEntryList", ansEntryList);
		map.put("ansEntryDocList", ansEntryDocList);
		return map;
  }

  public boolean addAnsEntry(PrjAnsEntry prjAnsEntry){
	  boolean successfullyAdded = false;

	  org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	  hbt.setFlushModeName("FLUSH_AUTO");
	  hbt.setCheckWriteOperations(false);
	  hbt.save(prjAnsEntry);
	  hbt.flush();
	  hbt.refresh(prjAnsEntry);
	  successfullyAdded =true;

	  return successfullyAdded;
  }

  public boolean editAnsEntry(Map<String, Object> generalMap){
	  boolean dataUpdated = false;
	  	String changedBy="";
			Date currentDate =new Date();
			String currentTime ="";
			int    hospitalId =0;
			String message = "";
			String title="";
			String url = "";

			int ansEntryId = 0;
			int queryEntryId = 0;
			Date actualAnsDate    = null;
			Date plannedFlwDate   = null;
			String ansDescription = "";

	  try{
		  ansEntryId = (Integer)generalMap.get("id");
		  queryEntryId = (Integer)generalMap.get("queryEntryId");
		  actualAnsDate = (Date) generalMap.get("actualAnsDate");
		  plannedFlwDate = (Date) generalMap.get("plannedFlwDate");
		  ansDescription = (String) generalMap.get("ansDescription");

	  		hospitalId =(Integer)generalMap.get("hospitalId");
	  		changedBy = (String)generalMap.get("changedBy");
	  		currentDate = (Date)generalMap.get("currentDate");
	  		currentTime = (String)generalMap.get("currentTime");

	  		PrjAnsEntry prjAnsEntry = (PrjAnsEntry) getHibernateTemplate().load(PrjAnsEntry.class, ansEntryId);

	  		prjAnsEntry.setId(ansEntryId);

	  		if(queryEntryId != 0){
				PrjQueryEntry prjQueryEntry = new PrjQueryEntry();
				prjQueryEntry.setId(queryEntryId);
				prjAnsEntry.setQueryEntry(prjQueryEntry);
			}

	  		prjAnsEntry.setActualAnsDate(actualAnsDate);
	  		prjAnsEntry.setPlannedFlwDate(plannedFlwDate);
	  		prjAnsEntry.setAnsDescription(ansDescription);

			if(hospitalId != 0){
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				prjAnsEntry.setCompany(masHospital);
			}
			prjAnsEntry.setStatus("y");
			prjAnsEntry.setLastChgBy(changedBy);
			prjAnsEntry.setLastChgDate(currentDate);
			prjAnsEntry.setLastChgTime(currentTime);

	  	    org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	  		hbt.setFlushModeName("FLUSH_EAGER");
	  		hbt.update(prjAnsEntry);
	  		hbt.flush();
	  		hbt.refresh(prjAnsEntry);
	  		dataUpdated = true;
	  		}catch (Exception e) {
	  			e.printStackTrace();
	  		}
	  		return dataUpdated;
  	}

  public Map<String, Object> attachAnsEntryDocFile(Map<String, Object> generalMap){

		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";

		int hospitalId =0;
		int projectId = 0;
		int ansEntryId = 0;
		String filename = "";
		String ansEntryDocComments = "";

		Map<String, Object> map = new HashMap<String, Object>();

		List<PrjAnsEntry>    ansEntryList = new ArrayList<PrjAnsEntry>();
		List<PrjAnsEntryDoc> ansEntryDocList = new ArrayList<PrjAnsEntryDoc>();

		Session session = (Session)getSession();

		if (generalMap.get("projectId") != null){
			projectId =(Integer)generalMap.get("projectId");
		}
		if(generalMap.get("ansEntryId") != null){
			ansEntryId = (Integer)generalMap.get("ansEntryId");
		}
		if (generalMap.get("hospitalId") != null){
			hospitalId =(Integer)generalMap.get("hospitalId");
		}

		if(generalMap.get("changedBy")!= null){
			changedBy =(String) generalMap.get("changedBy");
		}
		if(generalMap.get("currentDate")!= null){
			currentDate =(Date) generalMap.get("currentDate");
		}
		if(generalMap.get("currentTime")!= null){
			currentTime =(String) generalMap.get("currentTime");
		}

		if(generalMap.get("filename")!= null){
			filename =(String) generalMap.get("filename");
		}
		String uploadURL = "";
		if(generalMap.get("uploadURL")!= null){
			uploadURL =(String) generalMap.get("uploadURL");
		}

		if(generalMap.get("ansEntryDocComments")!= null){
			ansEntryDocComments =(String) generalMap.get("ansEntryDocComments");
		}

		String fileExtension=null;
		 File file=null;
		 try {
				HibernateTemplate hbt=getHibernateTemplate();
				hbt.setCheckWriteOperations(false);

	    		 file=new File(uploadURL + "/" + filename);
	    	     FileInputStream is = new FileInputStream(file);
	    	     long length = file.length();
	    	    // ByteBuffer byteBuff=null;

	    	     if (length > Integer.MAX_VALUE) {

	    	     }
	    	     // Create the byte array to hold the data
	    	     byte[] bytes = new byte[(int)length];
	    	     int offset = 0;
	    	     int numRead = 0;
	    	     while (offset < bytes.length
	    	    		 && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	    	    	 offset += numRead;

	    	     }

	    	     if (offset < bytes.length) {
	    	    	 throw new IOException("Could not completely read file "+file.getName());

	    	     }
	    	     is.close();

	    	     PrjAnsEntryDoc prjAnsEntryDoc = new PrjAnsEntryDoc();

	    	     prjAnsEntryDoc.setAnsEntryDocFilenmae(filename);

	    	     if(ansEntryId != 0){
	    	    	 PrjAnsEntry prjAnsEntry = new PrjAnsEntry();
	    	    	 prjAnsEntry.setId(ansEntryId);
	    	    	 prjAnsEntryDoc.setAnsEntry(prjAnsEntry);
	    	     }
	    	     if(projectId != 0){
	    	    	 MstrProject mstrProject = new MstrProject();
	    	    	 mstrProject.setId(projectId);
	    	    	 prjAnsEntryDoc.setProject(mstrProject);
	    	     }

	    	     if(hospitalId != 0){
	    	    	 MasHospital masHospital = new MasHospital();
	    	    	 masHospital.setId(hospitalId);
	    	    	 prjAnsEntryDoc.setCompany(masHospital);
	    	     }

	    	     prjAnsEntryDoc.setAnsEntryDocComments(ansEntryDocComments);
	    	     prjAnsEntryDoc.setStatus("y");
	    	     prjAnsEntryDoc.setLastChgBy(changedBy);
	    	     prjAnsEntryDoc.setLastChgDate(currentDate);
	    	     prjAnsEntryDoc.setLastChgTime(currentTime);
	    	     hbt.save(prjAnsEntryDoc);




	    }catch (Exception e) {

	      System.err.println("Error: " + e.getMessage());
	      e.printStackTrace();
	    }

		ansEntryList = session.createCriteria(PrjAnsEntry.class).add(Restrictions.idEq(ansEntryId)).list();
		ansEntryDocList = session.createCriteria(PrjAnsEntryDoc.class).add(Restrictions.eq("AnsEntry.Id", ansEntryId)).list();

		map.put("ansEntryList", ansEntryList);
		map.put("ansEntryDocList", ansEntryDocList);
		return map;
	}

  public Map<String, Object> deleteAttachAnsEntryDocFile(Map<String, Object> generalMap) {

	    List<PrjAnsEntry>    ansEntryList = new ArrayList<PrjAnsEntry>();
		List<PrjAnsEntryDoc> ansEntryDocList = new ArrayList<PrjAnsEntryDoc>();

		Session session = (Session)getSession();
		Map<String, Object> map = new HashMap<String, Object>();

		List ansEntryDocIdList = new ArrayList();
		int noOfFiles = 0;
		int ansEntryId = 0;

		int ansEntryDocId = 0;

		if(generalMap.get("ansEntryId") != null){
			ansEntryId =(Integer)generalMap.get("ansEntryId");
		}

		if(generalMap.get("ansEntryDocIdList")!= null){
			ansEntryDocIdList =(List)generalMap.get("ansEntryDocIdList");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);


		if(ansEntryDocIdList.size()>0){
			for (int i = 0; i < ansEntryDocIdList.size(); i++) {
				if(ansEntryDocIdList.get(i) != null){
					ansEntryDocId = Integer.parseInt(ansEntryDocIdList.get(i).toString());
					PrjAnsEntryDoc prjAnsEntryDoc = (PrjAnsEntryDoc)hbt.load(PrjAnsEntryDoc.class, ansEntryDocId);
					hbt.delete(prjAnsEntryDoc);
				}
			}
		}
		ansEntryList = session.createCriteria(PrjAnsEntry.class).add(Restrictions.idEq(ansEntryId)).list();
		ansEntryDocList = session.createCriteria(PrjAnsEntryDoc.class).add(Restrictions.eq("AnsEntry.Id", ansEntryId)).list();

		map.put("ansEntryList", ansEntryList);
		map.put("ansEntryDocList", ansEntryDocList);
		return map;
	}


  /********************************** Methods Start For Query Flw Entry JSP  ******************************************/
	public Map<String, Object> showQueryFlwEntryJsp(int projectId){
		Map<String, Object> map =new HashMap<String, Object>();

		List<MstrProject>      projectList = new ArrayList<MstrProject>();
		List<PrjQueryEntry>    queryEntryList = new ArrayList<PrjQueryEntry>();
		List<PrjAnsEntry>      ansEntryList = new ArrayList<PrjAnsEntry>();
		List<MstrQueryStatus>  queryStatusList = new ArrayList<MstrQueryStatus>();
		List<PrjQueryFlwEntry> queryFlwEntryList = new ArrayList<PrjQueryFlwEntry>();

		Session session = getSession();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		queryEntryList = session.createCriteria(PrjQueryEntry.class).add(Restrictions.eq("Project.Id", projectId)).list();
		ansEntryList = session.createCriteria(PrjAnsEntry.class).add(Restrictions.eq("Project.Id", projectId)).list();
		queryStatusList= session.createCriteria(MstrQueryStatus.class).add(Restrictions.eq("Status", "y")).list();
		queryFlwEntryList = session.createCriteria(PrjQueryFlwEntry.class).add(Restrictions.eq("Project.Id", projectId)).list();

		map.put("projectList", projectList);
		map.put("queryEntryList", queryEntryList);
		map.put("ansEntryList", ansEntryList);
		map.put("queryStatusList", queryStatusList);
		map.put("queryFlwEntryList", queryFlwEntryList);
		return map;
	}

	public Map<String, Object> displayQueryFlwEntryAttachment(int queryFlwEntryId){
		Map<String, Object> map = new HashMap<String, Object>();

		List<PrjQueryFlwEntry>    queryFlwEntryList = new ArrayList<PrjQueryFlwEntry>();
		List<PrjQueryFlwEntryDoc> queryFlwEntryDcoList = new ArrayList<PrjQueryFlwEntryDoc>();
		Session session = (Session)getSession();

		queryFlwEntryList    = session.createCriteria(PrjQueryFlwEntry.class).add(Restrictions.idEq(queryFlwEntryId)).list();
		queryFlwEntryDcoList = session.createCriteria(PrjQueryFlwEntryDoc.class).add(Restrictions.eq("QueryFlwEntry.Id", queryFlwEntryId)).list();
		map.put("queryFlwEntryList", queryFlwEntryList);
		map.put("queryFlwEntryDcoList", queryFlwEntryDcoList);
		return map;

	}

	public boolean addQueryFlwEntry(PrjQueryFlwEntry prjQueryFlwEntry){
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		  hbt.setFlushModeName("FLUSH_AUTO");
		  hbt.setCheckWriteOperations(false);
		  hbt.save(prjQueryFlwEntry);
		  hbt.flush();
		  hbt.refresh(prjQueryFlwEntry);
		  successfullyAdded =true;

		return successfullyAdded;
	}

	public boolean editQueryFlwEntry(Map<String, Object> generalMap){
		boolean dataUpdated = false;
	  	String changedBy="";
			Date currentDate =new Date();
			String currentTime ="";
			int    hospitalId =0;
			String message = "";
			String title="";
			String url = "";

			int queryFlwEntryId = 0;
			int queryEntryId = 0;
			int ansEntryId = 0;
			int queryStatusId =0;
			Date actualFlwDate    = null;
			Date nextFlwDate   = null;
			String queryFlwComments = "";

	  try{
		  queryFlwEntryId = (Integer)generalMap.get("id");
		  queryEntryId = (Integer)generalMap.get("queryEntryId");
		  ansEntryId = (Integer)generalMap.get("ansEntryId");
		  queryStatusId = (Integer)generalMap.get("queryStatusId");
		  actualFlwDate = (Date) generalMap.get("actualFlwDate");
		  nextFlwDate = (Date) generalMap.get("nextFlwDate");
		  queryFlwComments = (String) generalMap.get("queryFlwComments");

	  		hospitalId =(Integer)generalMap.get("hospitalId");
	  		changedBy = (String)generalMap.get("changedBy");
	  		currentDate = (Date)generalMap.get("currentDate");
	  		currentTime = (String)generalMap.get("currentTime");

	  		PrjQueryFlwEntry prjQueryFlwEntry = (PrjQueryFlwEntry)getHibernateTemplate().load(PrjQueryFlwEntry.class, queryFlwEntryId);
	  		prjQueryFlwEntry.setId(queryFlwEntryId);

	  		if(queryEntryId != 0){
				PrjQueryEntry prjQueryEntry = new PrjQueryEntry();
				prjQueryEntry.setId(queryEntryId);
				prjQueryFlwEntry.setQueryEntry(prjQueryEntry);
			}

			if(ansEntryId != 0){
				PrjAnsEntry prjAnsEntry = new PrjAnsEntry();
				prjAnsEntry.setId(ansEntryId);
				prjQueryFlwEntry.setAnsEntry(prjAnsEntry);
			}

			if(queryStatusId != 0){
				MstrQueryStatus mstrQueryStatus = new MstrQueryStatus();
				mstrQueryStatus.setId(queryStatusId);
				prjQueryFlwEntry.setQueryStatus(mstrQueryStatus);
			}
			prjQueryFlwEntry.setActualFlwDate(actualFlwDate);
			prjQueryFlwEntry.setNextFlwDate(nextFlwDate);
			prjQueryFlwEntry.setQueryFlwComments(queryFlwComments);

			if(hospitalId != 0){
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				prjQueryFlwEntry.setCompany(masHospital);
			}
			prjQueryFlwEntry.setLastChgBy(changedBy);
			prjQueryFlwEntry.setLastChgDate(currentDate);
			prjQueryFlwEntry.setLastChgTime(currentTime);

	  	    org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	  		hbt.setFlushModeName("FLUSH_EAGER");
	  		hbt.update(prjQueryFlwEntry);
	  		hbt.flush();
	  		hbt.refresh(prjQueryFlwEntry);
	  		dataUpdated = true;
	  		}catch (Exception e) {
	  			e.printStackTrace();
	  		}
	  		return dataUpdated;
	}

	public Map<String, Object> attachQueryFlwEntryDocFile(Map<String, Object> generalMap){
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";

		int hospitalId =0;
		int projectId = 0;
		int queryFlwEntryId = 0;
		String filename = "";
		String queryFlwEntryComments = "";

		Map<String, Object> map = new HashMap<String, Object>();

		List<PrjQueryFlwEntry>    queryFlwEntryList = new ArrayList<PrjQueryFlwEntry>();
		List<PrjQueryFlwEntryDoc> queryFlwEntryDcoList = new ArrayList<PrjQueryFlwEntryDoc>();

		Session session = (Session)getSession();

		if (generalMap.get("projectId") != null){
			projectId =(Integer)generalMap.get("projectId");
		}
		if(generalMap.get("queryFlwEntryId") != null){
			queryFlwEntryId = (Integer)generalMap.get("queryFlwEntryId");
		}
		if (generalMap.get("hospitalId") != null){
			hospitalId =(Integer)generalMap.get("hospitalId");
		}

		if(generalMap.get("changedBy")!= null){
			changedBy =(String) generalMap.get("changedBy");
		}
		if(generalMap.get("currentDate")!= null){
			currentDate =(Date) generalMap.get("currentDate");
		}
		if(generalMap.get("currentTime")!= null){
			currentTime =(String) generalMap.get("currentTime");
		}

		if(generalMap.get("filename")!= null){
			filename =(String) generalMap.get("filename");
		}
		String uploadURL = "";
		if(generalMap.get("uploadURL")!= null){
			uploadURL =(String) generalMap.get("uploadURL");
		}

		if(generalMap.get("queryFlwEntryComments")!= null){
			queryFlwEntryComments =(String) generalMap.get("queryFlwEntryComments");
		}

		String fileExtension=null;
		 File file=null;
		 try {
				HibernateTemplate hbt=getHibernateTemplate();
				hbt.setCheckWriteOperations(false);

	    		 file=new File(uploadURL + "/" + filename);
	    	     FileInputStream is = new FileInputStream(file);
	    	     long length = file.length();
	    	    // ByteBuffer byteBuff=null;

	    	     if (length > Integer.MAX_VALUE) {

	    	     }
	    	     // Create the byte array to hold the data
	    	     byte[] bytes = new byte[(int)length];
	    	     int offset = 0;
	    	     int numRead = 0;
	    	     while (offset < bytes.length
	    	    		 && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	    	    	 offset += numRead;

	    	     }

	    	     if (offset < bytes.length) {
	    	    	 throw new IOException("Could not completely read file "+file.getName());

	    	     }
	    	     is.close();

	    	     PrjQueryFlwEntryDoc prjQueryFlwEntryDoc = new PrjQueryFlwEntryDoc();

	    	     prjQueryFlwEntryDoc.setQueryFlwEntryDocFilename(filename);

	    	     if(queryFlwEntryId != 0){
	    	    	 PrjQueryFlwEntry prjQueryFlwEntry = new PrjQueryFlwEntry();
	    	    	 prjQueryFlwEntry.setId(queryFlwEntryId);
	    	    	 prjQueryFlwEntryDoc.setQueryFlwEntry(prjQueryFlwEntry);
	    	     }
	    	     if(projectId != 0){
	    	    	 MstrProject mstrProject = new MstrProject();
	    	    	 mstrProject.setId(projectId);
	    	    	 prjQueryFlwEntryDoc.setProject(mstrProject);
	    	     }

	    	     if(hospitalId != 0){
	    	    	 MasHospital masHospital = new MasHospital();
	    	    	 masHospital.setId(hospitalId);
	    	    	 prjQueryFlwEntryDoc.setCompany(masHospital);
	    	     }

	    	     prjQueryFlwEntryDoc.setQueryFlwEntryDocComments(queryFlwEntryComments);
	    	     prjQueryFlwEntryDoc.setStatus("y");
	    	     prjQueryFlwEntryDoc.setLastChgBy(changedBy);
	    	     prjQueryFlwEntryDoc.setLastChgDate(currentDate);
	    	     prjQueryFlwEntryDoc.setLastChgTime(currentTime);
	    	     hbt.save(prjQueryFlwEntryDoc);




	    }catch (Exception e) {

	      System.err.println("Error: " + e.getMessage());
	      e.printStackTrace();
	    }

	    queryFlwEntryList    = session.createCriteria(PrjQueryFlwEntry.class).add(Restrictions.idEq(queryFlwEntryId)).list();
		queryFlwEntryDcoList = session.createCriteria(PrjQueryFlwEntryDoc.class).add(Restrictions.eq("QueryFlwEntry.Id", queryFlwEntryId)).list();
		map.put("queryFlwEntryList", queryFlwEntryList);
		map.put("queryFlwEntryDcoList", queryFlwEntryDcoList);
		return map;

	}


	public Map<String, Object> deleteAttachQueryFlwEntryDocFile(Map<String, Object> generalMap) {

		List<PrjQueryFlwEntry>    queryFlwEntryList = new ArrayList<PrjQueryFlwEntry>();
		List<PrjQueryFlwEntryDoc> queryFlwEntryDcoList = new ArrayList<PrjQueryFlwEntryDoc>();

		Session session = (Session)getSession();
		Map<String, Object> map = new HashMap<String, Object>();

		List queryFlwEntryDocIdList = new ArrayList();
		int queryFlwEntryId = 0;
		int queryFlwEntryDocId = 0;



		if(generalMap.get("queryFlwEntryId") != null){
			queryFlwEntryId =(Integer)generalMap.get("queryFlwEntryId");
		}

		if(generalMap.get("queryFlwEntryDocIdList")!= null){
			queryFlwEntryDocIdList =(List)generalMap.get("queryFlwEntryDocIdList");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);


		if(queryFlwEntryDocIdList.size()>0){
			for (int i = 0; i < queryFlwEntryDocIdList.size(); i++) {
				if(queryFlwEntryDocIdList.get(i) != null){
					queryFlwEntryDocId = Integer.parseInt(queryFlwEntryDocIdList.get(i).toString());
					PrjQueryFlwEntryDoc prjQueryFlwEntryDoc = (PrjQueryFlwEntryDoc)hbt.load(PrjQueryFlwEntryDoc.class, queryFlwEntryDocId);
					hbt.delete(prjQueryFlwEntryDoc);
				}
			}
		}
		queryFlwEntryList    = session.createCriteria(PrjQueryFlwEntry.class).add(Restrictions.idEq(queryFlwEntryId)).list();
		queryFlwEntryDcoList = session.createCriteria(PrjQueryFlwEntryDoc.class).add(Restrictions.eq("QueryFlwEntry.Id", queryFlwEntryId)).list();
		map.put("queryFlwEntryList", queryFlwEntryList);
		map.put("queryFlwEntryDcoList", queryFlwEntryDcoList);
		return map;
	}





/********************************** Methods Start For SQ Approval Status JSP  ******************************************/
	public Map<String, Object> showSQApprovalStatus(int projectId){
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<PrjFesStudyDetail> feasibilityStudyHeaderList = new ArrayList<PrjFesStudyDetail>();
		Session session = (Session)getSession();
		feasibilityStudyHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();

		map.put("feasibilityStudyHeaderList", feasibilityStudyHeaderList);
		map.put("projectList", projectList);

		return map;
	}

	public boolean updateSQApprovalStatus(Map<String, Object> generalMap){
		boolean dataUpdated = false;
	  	String changedBy="";
			Date currentDate =new Date();
			String currentTime ="";
			int    hospitalId =0;
			String message = "";
			String title="";
			String url = "";

			int currentUserId=0;
			int feasibilityStudyId = 0;
			String sqApprovalStatus = "";
			Date sqApprovalDate = null;
			String sqApprovalComments = "";

	  try{
		  feasibilityStudyId = (Integer)generalMap.get("id");
		  currentUserId      = (Integer)generalMap.get("currentUserId");
		  sqApprovalStatus   = (String)generalMap.get("sqApprovalStatus");
		  sqApprovalDate     = (Date) generalMap.get("sqApprovalDate");
		  sqApprovalComments = (String) generalMap.get("sqApprovalComments");

	  		hospitalId   =(Integer)generalMap.get("hospitalId");
	  		changedBy    = (String)generalMap.get("changedBy");
	  		currentDate  = (Date)generalMap.get("currentDate");
	  		currentTime  = (String)generalMap.get("currentTime");

	  		PrjFesStudyHeader prjFesStudyHeader = (PrjFesStudyHeader)getHibernateTemplate().load(PrjFesStudyHeader.class, feasibilityStudyId);
	  		prjFesStudyHeader.setId(feasibilityStudyId);

	  		if(currentUserId != 0){
	  			MasEmployee masEmployee = new MasEmployee();
	  			masEmployee.setId(currentUserId);
	  			prjFesStudyHeader.setSqApproverEmp(masEmployee);
	  		}

	  		prjFesStudyHeader.setSqApprovalStatus(sqApprovalStatus);
	  		prjFesStudyHeader.setSqApproverDate(sqApprovalDate);
	  		prjFesStudyHeader.setSqApproverComments(sqApprovalComments);

			if(hospitalId != 0){
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				prjFesStudyHeader.setHospital(masHospital);
			}
			prjFesStudyHeader.setLastChgBy(changedBy);
			prjFesStudyHeader.setLastChgDate(currentDate);
			prjFesStudyHeader.setLastChgTime(currentTime);

	  	    org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	  		hbt.setFlushModeName("FLUSH_EAGER");
	  		hbt.update(prjFesStudyHeader);
	  		hbt.flush();
	  		hbt.refresh(prjFesStudyHeader);
	  		dataUpdated = true;
	  		}catch (Exception e) {
	  			e.printStackTrace();
	  		}
	  		return dataUpdated;
	}
	public Map<String, Object> viewSqApprovalDocument(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PrjFesStudyHeader> feasibilityHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<PrjFedoc> prjFeasibilityDocumentList = new ArrayList<PrjFedoc>();

		int feasibilityStudyHeaderId = 0;
		if(generalMap.get("feasibilityHeaderId")!= null){
			feasibilityStudyHeaderId =(Integer)generalMap.get("feasibilityHeaderId");
		}
		Session session = (Session)getSession();
		feasibilityHeaderList = session.createCriteria(PrjFesStudyHeader.class).add(Restrictions.idEq(feasibilityStudyHeaderId)).list();
		prjFeasibilityDocumentList = session.createCriteria(PrjFedoc.class).createAlias("FedFeid", "fesHeaderId").add(Restrictions.eq("fesHeaderId.Id", feasibilityStudyHeaderId)).list();
		map.put("prjFeasibilityDocumentList", prjFeasibilityDocumentList);
		map.put("feasibilityHeaderList", feasibilityHeaderList);
		return map;
	}





/********************************** Methods Start For SQ Approval Status JSP  ******************************************/
	public Map<String, Object> showQAApprovalStatus(int projectId){
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<PrjFesStudyDetail> feasibilityStudyHeaderList = new ArrayList<PrjFesStudyDetail>();
		Session session = (Session)getSession();
		feasibilityStudyHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();

		map.put("feasibilityStudyHeaderList", feasibilityStudyHeaderList);
		map.put("projectList", projectList);

		return map;
	}

	public boolean updateQAApprovalStatus(Map<String, Object> generalMap){
		boolean dataUpdated = false;
	  	String changedBy="";
			Date currentDate =new Date();
			String currentTime ="";
			int    hospitalId =0;
			String message = "";
			String title="";
			String url = "";

			int currentUserId=0;
			int feasibilityStudyId = 0;
			String qaApprovalStatus = "";
			Date qaApprovalDate = null;
			String qaApprovalComments = "";

	  try{
		  feasibilityStudyId = (Integer)generalMap.get("id");
		  currentUserId      = (Integer)generalMap.get("currentUserId");
		  qaApprovalStatus   = (String)generalMap.get("qaApprovalStatus");
		  qaApprovalDate     = (Date) generalMap.get("qaApprovalDate");
		  qaApprovalComments = (String) generalMap.get("qaApprovalComments");

	  		hospitalId   =(Integer)generalMap.get("hospitalId");
	  		changedBy    = (String)generalMap.get("changedBy");
	  		currentDate  = (Date)generalMap.get("currentDate");
	  		currentTime  = (String)generalMap.get("currentTime");

	  		PrjFesStudyHeader prjFesStudyHeader = (PrjFesStudyHeader)getHibernateTemplate().load(PrjFesStudyHeader.class, feasibilityStudyId);
	  		prjFesStudyHeader.setId(feasibilityStudyId);

	  		if(currentUserId != 0){
	  			MasEmployee masEmployee = new MasEmployee();
	  			masEmployee.setId(currentUserId);
	  			prjFesStudyHeader.setQaApprover(masEmployee);
	  		}
	  		prjFesStudyHeader.setQaApprovalStatus(qaApprovalStatus);
	  		prjFesStudyHeader.setQaApprovalDate(qaApprovalDate);
	  		prjFesStudyHeader.setQaApproverComments(qaApprovalComments);

			if(hospitalId != 0){
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				prjFesStudyHeader.setHospital(masHospital);
			}
			prjFesStudyHeader.setLastChgBy(changedBy);
			prjFesStudyHeader.setLastChgDate(currentDate);
			prjFesStudyHeader.setLastChgTime(currentTime);

	  	    org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	  		hbt.setFlushModeName("FLUSH_EAGER");
	  		hbt.update(prjFesStudyHeader);
	  		hbt.flush();
	  		hbt.refresh(prjFesStudyHeader);
	  		dataUpdated = true;
	  		}catch (Exception e) {
	  			e.printStackTrace();
	  		}
	  		return dataUpdated;
	}
	public Map<String, Object> viewQaApprovalDocument(Map<String, Object> generalMap) {
		Map<String,Object>  map = new HashMap<String,Object>();
		List<PrjFesStudyHeader> feasibilityHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<PrjFedoc> prjFeasibilityDocumentList = new ArrayList<PrjFedoc>();

		int feasibilityStudyHeaderId = 0;
		if(generalMap.get("feasibilityHeaderId")!= null){
			feasibilityStudyHeaderId =(Integer)generalMap.get("feasibilityHeaderId");
		}
		Session session = (Session)getSession();
		feasibilityHeaderList = session.createCriteria(PrjFesStudyHeader.class).add(Restrictions.idEq(feasibilityStudyHeaderId)).list();
		prjFeasibilityDocumentList = session.createCriteria(PrjFedoc.class).createAlias("FedFeid", "fesHeaderId").add(Restrictions.eq("fesHeaderId.Id", feasibilityStudyHeaderId)).list();
		map.put("prjFeasibilityDocumentList", prjFeasibilityDocumentList);
		map.put("feasibilityHeaderList", feasibilityHeaderList);
		return map;
	}




	@SuppressWarnings("unchecked")
	public Map<String, Object> searchVisitDetails(Map<String, Object> mapForDs)
	{
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjPatvisitsch> patientVisitScheduleList = new ArrayList<PrjPatvisitsch>();
		List<MstrPtvisit> patientVisitList = new ArrayList<MstrPtvisit>();
		List<HrMasVisitType> masVisitTypeList = new ArrayList<HrMasVisitType>();

		Map<String,Object>  map = new HashMap<String,Object>();
		int projectIdWithSearch = 0;
		String visitType = null;
		String visitName = null;

		if(mapForDs.get("projectIdWithSearch")!= null){
			projectIdWithSearch =(Integer)mapForDs.get("projectIdWithSearch");
		}
		if(mapForDs.get("visitName")!= null){
			visitName =(String)mapForDs.get("visitName");
		}
		if(mapForDs.get("visitType")!= null){
			visitType =(String)mapForDs.get("visitType");
		}

		Session session = (Session)getSession();

		try{
			if((visitType!=null) || (visitName==null)){
				patientVisitScheduleList = session.createCriteria(PrjPatvisitsch.class)
												.createAlias("PatientVisit","pv")
												.createAlias("pv.VisitType","vt")
												.add(Restrictions.like("vt.VisitType", visitType))
												.list();
			}else{
				patientVisitScheduleList = session.createCriteria(PrjPatvisitsch.class)
												.createAlias("PatientVisit","pv")
												.add(Restrictions.like("pv.PatientVisitName", visitName))
												.list();
			}
			projectList = session.createCriteria(MstrProject.class)
										.add(Restrictions.idEq(projectIdWithSearch))
										.list();
		/*	patientVisitScheduleList = session.createCriteria(PrjPatvisitsch.class)
										.add(Restrictions.eq("Status", "y")).list();*/
			patientVisitList = session.createCriteria(MstrPtvisit.class)
										.add(Restrictions.eq("Status", "y")).list();
			masVisitTypeList = session.createCriteria(HrMasVisitType.class)
										.add(Restrictions.eq("Status", "y")).list();


		}catch (Exception e) {
			e.printStackTrace();
		}
		map.put("masVisitTypeList", masVisitTypeList);
		map.put("patientVisitScheduleList", patientVisitScheduleList);
		map.put("projectList", projectList);
		map.put("patientVisitList", patientVisitList);

		return map;
	}
	//=========================================By Vishal===================================================
//-----------------------------Site Other Vitals ----------------------------------------------
	public Map<String, Object> showSiteOtherVitalsJsp(int projectId, int siteId){
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjSiteOthervitals> siteOtherVitalsList = new ArrayList<PrjSiteOthervitals>();
		List<MstrSiteHeader> siteHeaderList = new ArrayList<MstrSiteHeader>();
		List<PrjFesStudyHeader> fesStudyHeaderList  = new ArrayList<PrjFesStudyHeader>();
		Session session =(Session) getSession();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		siteOtherVitalsList = session.createCriteria(PrjSiteOthervitals.class).list();
		fesStudyHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
		map.put("siteOtherVitalsList", siteOtherVitalsList);
		map.put("projectList", projectList);
		map.put("fesStudyHeaderList", fesStudyHeaderList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean addSiteOtherVitals(PrjSiteOthervitals prjSiteOthervitals){
		List<PrjFesStudyHeader> fesStudyHeaderList  = new ArrayList<PrjFesStudyHeader>();
		Session session = (Session)getSession();
		boolean successfullyAdded =false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(prjSiteOthervitals);
		hbt.flush();
		hbt.refresh(prjSiteOthervitals);
		successfullyAdded =true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean editSiteOtherVitals(Map<String, Object> generalMap){
		boolean dataUpdated = false;
		String changedBy="";
		Date currentDate =new Date();
		String currentTime ="";
		HttpSession session =null;
		int    hospitalId =0;
		String message = "";
		String title="";
		String url="";
		int SiteOtherVitalId = 0;
		String vitalsCode ="";
		String vitalsName = "";


		try{
			SiteOtherVitalId = (Integer)generalMap.get("id");
			vitalsCode = (String) generalMap.get("vitalsCode");
			vitalsName = (String) generalMap.get("vitalsName");

			changedBy = (String)generalMap.get("changedBy");
			currentDate = (Date)generalMap.get("currentDate");
			currentTime = (String)generalMap.get("currentTime");

		PrjSiteOthervitals prjSiteOthervitals =(PrjSiteOthervitals) getHibernateTemplate().load(PrjSiteOthervitals.class, SiteOtherVitalId);
	//	prjOthervitals.setId(otherVitalId);

//		if(hospitalId != 0){
//		    MasHospital masHospital =new MasHospital();
//		    masHospital.setId(hospitalId);
//		    prjOthervitals.setCompany(masHospital);
//		}

		prjSiteOthervitals.setOvtCode(vitalsCode);
		prjSiteOthervitals.setOvtName(vitalsName);
		prjSiteOthervitals.setLastChgBy(changedBy);
		prjSiteOthervitals.setLastChgDate(currentDate);
		prjSiteOthervitals.setLastChgTime(currentTime);

	    org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.update(prjSiteOthervitals);
		dataUpdated = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	//-----------------------Site Miles Stone---------------------------------------------
	public Map<String, Object> showSiteMilesStoneJsp(int projectId, int siteId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<MstrPtvisit> patientVisitList = new ArrayList<MstrPtvisit>();
		List<PrjSiteMilestone> prjSiteMilestoneList = new ArrayList<PrjSiteMilestone>();
		List<PrjFesStudyHeader> fesStudyHeaderList  = new ArrayList<PrjFesStudyHeader>();
		Session session = (Session)getSession();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		patientVisitList = session.createCriteria(MstrPtvisit.class).list();
		prjSiteMilestoneList = session.createCriteria(PrjSiteMilestone.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
		fesStudyHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
		map.put("projectList", projectList);
		map.put("patientVisitList", patientVisitList);
		map.put("prjSiteMilestoneList", prjSiteMilestoneList);
		map.put("fesStudyHeaderList", fesStudyHeaderList);
		return map;
	}
	public Map<String, Object> addSiteMilesStone(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<MstrPtvisit> patientVisitList = new ArrayList<MstrPtvisit>();
		List<MstrSiteHeader> mstrSiteHeaderList = new ArrayList<MstrSiteHeader>();
		List<PrjSiteMilestone> prjSiteMilestoneList = new ArrayList<PrjSiteMilestone>();
		List<PrjFesStudyHeader> fesStudyHeaderList  = new ArrayList<PrjFesStudyHeader>();
		Session session = (Session)getSession();
		int	hospitalId = 0;
		if(generalMap.get("hospitalId")!= null){
			hospitalId =(Integer)generalMap.get("hospitalId");
		}
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId =(Integer)generalMap.get("projectId");
		}
		int siteId = 0;
		if(generalMap.get("siteId")!= null){
			siteId =(Integer)generalMap.get("siteId");
		}
		 int visitId =0;
		 if(generalMap.get("visitId")!= null){
			 visitId =(Integer)generalMap.get("visitId");
		}

		 BigDecimal siteAmount = new BigDecimal("0");
		 if(generalMap.get("siteAmount")!= null){
			 siteAmount =(BigDecimal)generalMap.get("siteAmount");
		 }
		 BigDecimal amountPercentage = new BigDecimal("0");
		 if(generalMap.get("amountPercentage")!= null){
			 amountPercentage =(BigDecimal)generalMap.get("amountPercentage");
		 }
		 BigDecimal paymentInAmountPerPatient = new BigDecimal("0");
		 if(generalMap.get("paymentInAmountPerPatient")!= null){
			 paymentInAmountPerPatient =(BigDecimal)generalMap.get("paymentInAmountPerPatient");
		 }
		 Date cutOffDate = null;
		 if(generalMap.get("cutOffDate")!= null){
			 cutOffDate =(Date)generalMap.get("cutOffDate");
		 }
		 String changedBy  = "";
		 if(generalMap.get("changedBy")!= null){
			 changedBy =(String)generalMap.get("changedBy");
		 }
		 Date currentDate = new Date();
		 if(generalMap.get("currentDate")!= null){
			 currentDate =(Date)generalMap.get("currentDate");
		 }
		 String	currentTime = "";
		 if(generalMap.get("currentTime")!= null){
			 currentTime =(String)generalMap.get("currentTime");
		 }
		 PrjSiteMilestone prjSiteMilestone = new PrjSiteMilestone();
		 prjSiteMilestone.setCutOfDate(cutOffDate);
		 prjSiteMilestone.setLastChgBy(changedBy);
		 prjSiteMilestone.setLastChgDate(currentDate);
		 prjSiteMilestone.setLastChgTime(currentTime);
		 prjSiteMilestone.setMilesStoneAmount(siteAmount);
		 prjSiteMilestone.setMilesStonePercentage(amountPercentage);
		 prjSiteMilestone.setTotalAmountPerPatient(paymentInAmountPerPatient);
		 prjSiteMilestone.setStatus("y");

		 MasHospital masHospital = new MasHospital();
		 masHospital.setId(hospitalId);
		 prjSiteMilestone.setHospital(masHospital);

		 MstrProject mstrProject = new MstrProject();
		 mstrProject.setId(projectId);
		 prjSiteMilestone.setPrj(mstrProject);

		 MstrSiteHeader mstrSiteHeader = new MstrSiteHeader();
		 mstrSiteHeader.setId(siteId);
		 prjSiteMilestone.setSiteHeader(mstrSiteHeader);

		 MstrPtvisit mstrPtvisit = new MstrPtvisit();
		 mstrPtvisit.setId(visitId);
		 prjSiteMilestone.setPatientVisit(mstrPtvisit);
		 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.save(prjSiteMilestone);
			String message = "";
			boolean saved = false;
			saved =  true;

			if(saved){
				message = "Data save Successfully.";
			}else{
				message = "Some Problem Occured.";
			}
			prjSiteMilestoneList = session.createCriteria(PrjSiteMilestone.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
			projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
			patientVisitList = session.createCriteria(MstrPtvisit.class).list();
			fesStudyHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
			map.put("projectList", projectList);
			map.put("patientVisitList", patientVisitList);
			map.put("prjSiteMilestoneList", prjSiteMilestoneList);
			map.put("fesStudyHeaderList", fesStudyHeaderList);
		return map;
	}

	public Map<String, Object> editSiteMileStone(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<MstrPtvisit> patientVisitList = new ArrayList<MstrPtvisit>();
		List<PrjSiteMilestone> prjSiteMilestoneList = new ArrayList<PrjSiteMilestone>();
		List<PrjFesStudyHeader> fesStudyHeaderList  = new ArrayList<PrjFesStudyHeader>();
		Session session = (Session)getSession();
		int	siteMilesStoneId = 0;
		if(generalMap.get("siteMilesStoneId")!= null){
			siteMilesStoneId =(Integer)generalMap.get("siteMilesStoneId");
		}
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId =(Integer)generalMap.get("projectId");
		}
		int siteId = 0;
		if(generalMap.get("siteId")!= null){
			siteId =(Integer)generalMap.get("siteId");
		}
		 int visitId =0;
		 if(generalMap.get("visitId")!= null){
			 visitId =(Integer)generalMap.get("visitId");
		}
		 BigDecimal siteAmount = new BigDecimal("0");
		 if(generalMap.get("siteAmount")!= null){
			 siteAmount =(BigDecimal)generalMap.get("siteAmount");
		 }
		 BigDecimal sitePercentage = new BigDecimal("0");
		 if(generalMap.get("sitePercentage")!= null){
			 sitePercentage =(BigDecimal)generalMap.get("sitePercentage");
		 }
		 BigDecimal amountPerPatient = new BigDecimal("0");
		 if(generalMap.get("amountPerPatient")!= null){
			 amountPerPatient =(BigDecimal)generalMap.get("amountPerPatient");
		 }
		 Date cutOffDate = null;
		 if(generalMap.get("cutOffDate")!= null){
			 cutOffDate =(Date)generalMap.get("cutOffDate");
		 }
		 String changedBy  = "";
		 if(generalMap.get("changedBy")!= null){
			 changedBy =(String)generalMap.get("changedBy");
		 }
		 Date currentDate = new Date();
		 if(generalMap.get("currentDate")!= null){
			 currentDate =(Date)generalMap.get("currentDate");
		 }
		 String	currentTime = "";
		 if(generalMap.get("currentTime")!= null){
			 currentTime =(String)generalMap.get("currentTime");
		 }
		 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			PrjSiteMilestone prjSiteMilestone = (PrjSiteMilestone)hbt.load(PrjSiteMilestone.class, siteMilesStoneId);

			prjSiteMilestone.setCutOfDate(cutOffDate);
			prjSiteMilestone.setLastChgBy(changedBy);
			prjSiteMilestone.setLastChgDate(currentDate);
			prjSiteMilestone.setLastChgTime(currentTime);
			prjSiteMilestone.setMilesStoneAmount(siteAmount);
			prjSiteMilestone.setMilesStonePercentage(sitePercentage);
			prjSiteMilestone.setTotalAmountPerPatient(amountPerPatient);

			MstrPtvisit mstrPtvisit = new MstrPtvisit();
			mstrPtvisit.setId(visitId);
			prjSiteMilestone.setPatientVisit(mstrPtvisit);

			MstrSiteHeader mstrSiteHeader = new MstrSiteHeader();
			mstrSiteHeader.setId(siteId);
			prjSiteMilestone.setSiteHeader(mstrSiteHeader);

			MstrProject mstrProject = new MstrProject();
			mstrProject.setId(projectId);
			prjSiteMilestone.setPrj(mstrProject);

			hbt.update(prjSiteMilestone);
			String message = "";
			boolean updated = false;
			updated =  true;

			if(updated){
				message = "Data update Successfully.";
			}else{
				message = "Some Problem Occured.";
			}
			map.put("message", message);
			prjSiteMilestoneList = session.createCriteria(PrjSiteMilestone.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
			projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
			patientVisitList = session.createCriteria(MstrPtvisit.class).list();
			fesStudyHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
			map.put("projectList", projectList);
			map.put("patientVisitList", patientVisitList);
			map.put("prjSiteMilestoneList", prjSiteMilestoneList);
			map.put("fesStudyHeaderList", fesStudyHeaderList);
		return map;
	}

	/*   Site Calendar Code Start By Naresh   */
	public Map<String, Object> showSiteCalendarJsp(int projectId, int siteId) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjFesStudyHeader> fesStudyHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<MstrVitals> vitalsMasterList = new ArrayList<MstrVitals>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		List<PrjSiteVital> siteVitalList = new ArrayList<PrjSiteVital>();
		List<HrPrjSiteCalendar> siteCalendarList = new ArrayList<HrPrjSiteCalendar>();
		List<MstrCalendar> calendarList = new ArrayList<MstrCalendar>();

		Session session = (Session)getSession();
		fesStudyHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
		vitalsMasterList = session.createCriteria(MstrVitals.class).add(Restrictions.eq("Status", "y")).list();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
		siteVitalList = session.createCriteria(PrjSiteVital.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();

		siteCalendarList = session.createCriteria(HrPrjSiteCalendar.class)
							.createAlias("Prj", "prj")
							.add(Restrictions.eq("prj.Id", projectId))
							.add(Restrictions.eq("Site.Id", siteId))
							.list();
		calendarList = session.createCriteria(MstrCalendar.class)
							.add(Restrictions.eq("Status", "y")).list();

		map.put("siteCalendarList", siteCalendarList);
		map.put("calendarList", calendarList);

		map.put("fesStudyHeaderList", fesStudyHeaderList);
		map.put("projectList", projectList);
		map.put("vitalsMasterList", vitalsMasterList);
		map.put("currencyList", currencyList);
		map.put("siteVitalList", siteVitalList);
		return map;
	}

	public Map<String, Object> saveSiteCalendar(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<HrPrjSiteCalendar> siteCalendarList = new ArrayList<HrPrjSiteCalendar>();
		List<MstrCalendar> calendarList = new ArrayList<MstrCalendar>();
		List<PrjFesStudyHeader> fesStudyHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<MstrVitals> vitalsMasterList = new ArrayList<MstrVitals>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		List<PrjSiteVital> siteVitalList = new ArrayList<PrjSiteVital>();

		Session session = (Session)getSession();
		int	hospitalId = 0;
		if(generalMap.get("hospitalId")!= null){
			hospitalId =(Integer)generalMap.get("hospitalId");
		}
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId =(Integer)generalMap.get("projectId");
		}
		int siteId = 0;
		if(generalMap.get("siteId")!= null){
			siteId =(Integer)generalMap.get("siteId");
		}
		int calendarId  = 0;
		if(generalMap.get("calendarId")!= null){
			calendarId =(Integer)generalMap.get("calendarId");
		}
		Date plannedDate= null;
		if(generalMap.get("plannedDate")!= null){
			plannedDate =(Date)generalMap.get("plannedDate");
		}
		String plannedRemark = "";
		if(generalMap.get("plannedRemark")!= null){
			plannedRemark =(String)generalMap.get("plannedRemark");
		}
		Date revisedDate= null;
		if(generalMap.get("revisedDate")!= null){
			revisedDate =(Date)generalMap.get("revisedDate");
		}
		String revisedRemark = "";
		if(generalMap.get("revisedRemark")!= null){
			revisedRemark =(String)generalMap.get("revisedRemark");
		}
		Date actualDate= null;
		if(generalMap.get("actualDate")!= null){
			actualDate =(Date)generalMap.get("actualDate");
		}
		String actualRemark = "";
		if(generalMap.get("actualRemark")!= null){
			actualRemark =(String)generalMap.get("actualRemark");
		}
		int noOfDays = 0;
		if(generalMap.get("noOfDays")!= null){
			noOfDays =(Integer)generalMap.get("noOfDays");
		}
		String changedBy  = "";
		 if(generalMap.get("changedBy")!= null){
			 changedBy =(String)generalMap.get("changedBy");
		 }
		 Date currentDate = new Date();
		 if(generalMap.get("currentDate")!= null){
			 currentDate =(Date)generalMap.get("currentDate");
		 }
		 String	currentTime = "";
		 if(generalMap.get("currentTime")!= null){
			 currentTime =(String)generalMap.get("currentTime");
		 }
		 HrPrjSiteCalendar hrPrjSiteCalendar = new HrPrjSiteCalendar();
		 hrPrjSiteCalendar.setPlannedDate(plannedDate);
		 hrPrjSiteCalendar.setPlannedRemark(plannedRemark);
		 hrPrjSiteCalendar.setActualDate(actualDate);
		 hrPrjSiteCalendar.setActualRemark(actualRemark);
		 hrPrjSiteCalendar.setRevisedDate(revisedDate);
		 hrPrjSiteCalendar.setRevisedRemark(revisedRemark);
		 hrPrjSiteCalendar.setNoOfDays(noOfDays);
		 hrPrjSiteCalendar.setLastChgBy(changedBy);
		 hrPrjSiteCalendar.setLastChgDate(currentDate);
		 hrPrjSiteCalendar.setLastChgTime(currentTime);
		 hrPrjSiteCalendar.setStatus("y");

		 MasHospital masHospital = new MasHospital();
		 masHospital.setId(hospitalId);
		 hrPrjSiteCalendar.setHospital(masHospital);

		 MstrCalendar mstrCalendar = new MstrCalendar();
		 mstrCalendar.setId(calendarId);
		 hrPrjSiteCalendar.setCalendar(mstrCalendar);

		 MstrProject mstrProject = new MstrProject();
		 mstrProject.setId(projectId);
		 hrPrjSiteCalendar.setPrj(mstrProject);

		 MstrSiteHeader mstrSiteHeader = new MstrSiteHeader();
		 mstrSiteHeader.setId(siteId);
		 hrPrjSiteCalendar.setSite(mstrSiteHeader);

		 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.save(hrPrjSiteCalendar);
			hbt.refresh(hrPrjSiteCalendar);
			String message = "";
			boolean saved = false;
			saved =  true;

			if(saved){
				message = "Data save Successfully.";
			}else{
				message = "Some Problem Occured.";
			}

			projectList = session.createCriteria(MstrProject.class)
									.add(Restrictions.idEq(projectId)).list();
			siteCalendarList = session.createCriteria(HrPrjSiteCalendar.class)
						.createAlias("Prj", "prj")
						.add(Restrictions.eq("prj.Id", projectId))
						.add(Restrictions.eq("Site.Id", siteId))
						.list();
			calendarList = session.createCriteria(MstrCalendar.class)
					.add(Restrictions.eq("Status", "y")).list();

			map.put("siteCalendarList", siteCalendarList);
			map.put("calendarList", calendarList);

			fesStudyHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
			vitalsMasterList = session.createCriteria(MstrVitals.class).add(Restrictions.eq("Status", "y")).list();
			currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
			siteVitalList = session.createCriteria(PrjSiteVital.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();

			map.put("fesStudyHeaderList", fesStudyHeaderList);
			map.put("vitalsMasterList", vitalsMasterList);
			map.put("currencyList", currencyList);
			map.put("siteVitalList", siteVitalList);

			map.put("projectList", projectList);
			map.put("message", message);
		return map;
	}
	public Map<String, Object> updateSiteCalendar(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<ProjectCalendar> projectCalendarList = new ArrayList<ProjectCalendar>();
		List<MstrCalendar> calendarList = new ArrayList<MstrCalendar>();

		List<HrPrjSiteCalendar> siteCalendarList = new ArrayList<HrPrjSiteCalendar>();
		List<PrjFesStudyHeader> fesStudyHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<MstrVitals> vitalsMasterList = new ArrayList<MstrVitals>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		List<PrjSiteVital> siteVitalList = new ArrayList<PrjSiteVital>();

		Session session = (Session)getSession();
		int siteCalenderId = 0;
		if(generalMap.get("siteCalenderId")!= null){
			siteCalenderId =(Integer)generalMap.get("siteCalenderId");
		}
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId =(Integer)generalMap.get("projectId");
		}
		int siteId = 0;
		if(generalMap.get("siteId")!= null){
			siteId =(Integer)generalMap.get("siteId");
		}
		int calendarId  = 0;
		if(generalMap.get("calendarId")!= null){
			calendarId =(Integer)generalMap.get("calendarId");
		}
		Date plannedDate= null;
		if(generalMap.get("plannedDate")!= null){
			plannedDate =(Date)generalMap.get("plannedDate");
		}
		String plannedRemark = "";
		if(generalMap.get("plannedRemark")!= null){
			plannedRemark =(String)generalMap.get("plannedRemark");
		}
		Date revisedDate= null;
		if(generalMap.get("revisedDate")!= null){
			revisedDate =(Date)generalMap.get("revisedDate");
		}
		String revisedRemark = "";
		if(generalMap.get("revisedRemark")!= null){
			revisedRemark =(String)generalMap.get("revisedRemark");
		}
		Date actualDate= null;
		if(generalMap.get("actualDate")!= null){
			actualDate =(Date)generalMap.get("actualDate");
		}
		String actualRemark = "";
		if(generalMap.get("actualRemark")!= null){
			actualRemark =(String)generalMap.get("actualRemark");
		}
		int noOfDays = 0;
		if(generalMap.get("noOfDays")!= null){
			noOfDays =(Integer)generalMap.get("noOfDays");
		}
		String changedBy  = "";
		 if(generalMap.get("changedBy")!= null){
			 changedBy =(String)generalMap.get("changedBy");
		 }
		 Date currentDate = new Date();
		 if(generalMap.get("currentDate")!= null){
			 currentDate =(Date)generalMap.get("currentDate");
		 }
		 String	currentTime = "";
		 if(generalMap.get("currentTime")!= null){
			 currentTime =(String)generalMap.get("currentTime");
		 }
	 	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		 HrPrjSiteCalendar hrPrjSiteCalendar = (HrPrjSiteCalendar)hbt.load(HrPrjSiteCalendar.class, siteCalenderId);
		 hrPrjSiteCalendar.setActualDate(actualDate);
		 hrPrjSiteCalendar.setActualRemark(actualRemark);
		 hrPrjSiteCalendar.setLastChgBy(changedBy);
		 hrPrjSiteCalendar.setLastChgDate(currentDate);
		 hrPrjSiteCalendar.setLastChgTime(currentTime);
		 hrPrjSiteCalendar.setNoOfDays(noOfDays);
		 hrPrjSiteCalendar.setPlannedDate(plannedDate);
		 hrPrjSiteCalendar.setPlannedRemark(plannedRemark);
		 hrPrjSiteCalendar.setRevisedDate(revisedDate);
		 hrPrjSiteCalendar.setRevisedRemark(revisedRemark);

		 MstrProject mstrProject = new MstrProject();
		 mstrProject.setId(projectId);
		 hrPrjSiteCalendar.setPrj(mstrProject);

		 MstrCalendar mstrCalendar = new MstrCalendar();
		 mstrCalendar.setId(calendarId);
		 hrPrjSiteCalendar.setCalendar(mstrCalendar);

		 MstrSiteHeader mstrSiteHeader = new MstrSiteHeader();
		 mstrSiteHeader.setId(siteId);
		 hrPrjSiteCalendar.setSite(mstrSiteHeader);

		 hbt.update(hrPrjSiteCalendar);
		 hbt.refresh(hrPrjSiteCalendar);
			String message = "";
			boolean updated = false;
			updated =  true;

			if(updated){
				message = "Data update Successfully.";
			}else{
				message = "Some Problem Occured.";
			}
			map.put("message", message);
			projectList = session.createCriteria(MstrProject.class)
			.add(Restrictions.idEq(projectId)).list();

			siteCalendarList = session.createCriteria(HrPrjSiteCalendar.class)
			.createAlias("Prj", "prj")
			.add(Restrictions.eq("prj.Id", projectId))
			.add(Restrictions.eq("Site.Id", siteId))
			.list();

			calendarList = session.createCriteria(MstrCalendar.class)
			.add(Restrictions.eq("Status", "y")).list();

			map.put("siteCalendarList", siteCalendarList);
			map.put("calendarList", calendarList);

			fesStudyHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
			vitalsMasterList = session.createCriteria(MstrVitals.class).add(Restrictions.eq("Status", "y")).list();
			currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
			siteVitalList = session.createCriteria(PrjSiteVital.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();

			map.put("fesStudyHeaderList", fesStudyHeaderList);
			map.put("vitalsMasterList", vitalsMasterList);
			map.put("currencyList", currencyList);
			map.put("siteVitalList", siteVitalList);

			map.put("projectList", projectList);
		return map;
	}
	public Map<String, Object> deleteSiteCalendar(int siteCalendarId,Map<String, Object> generalMap) {
		boolean dataDeleted=false;
		String changedBy = "";
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<ProjectCalendar> projectCalendarList = new ArrayList<ProjectCalendar>();
		List<MstrCalendar> calendarList = new ArrayList<MstrCalendar>();

		List<HrPrjSiteCalendar> siteCalendarList = new ArrayList<HrPrjSiteCalendar>();
		List<PrjFesStudyHeader> fesStudyHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<MstrVitals> vitalsMasterList = new ArrayList<MstrVitals>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		List<PrjSiteVital> siteVitalList = new ArrayList<PrjSiteVital>();

		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		HrPrjSiteCalendar hrPrjSiteCalendar = new HrPrjSiteCalendar();

		changedBy = (String)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");

		hrPrjSiteCalendar =(HrPrjSiteCalendar)getHibernateTemplate().load(HrPrjSiteCalendar.class,siteCalendarId);
		  if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  hrPrjSiteCalendar.setStatus("n");
				  dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  hrPrjSiteCalendar.setStatus("y");
				  dataDeleted=false;
			  }
		  }
		  hrPrjSiteCalendar.setLastChgBy(changedBy);
		  hrPrjSiteCalendar.setLastChgDate(currentDate);
		  hrPrjSiteCalendar.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrPrjSiteCalendar);
		hbt.refresh(hrPrjSiteCalendar);
		String message = "";
		if(dataDeleted){
			message = "Data update Successfully.";
		}else{
			message = "Some Problem Occured.";
		}
		map.put("message", message);
		Session session = (Session)getSession();
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId =(Integer)generalMap.get("projectId");
		}
		int siteId = 0;
		if(generalMap.get("siteId")!= null){
			siteId =(Integer)generalMap.get("siteId");
		}

		projectList = session.createCriteria(MstrProject.class)
		.add(Restrictions.idEq(projectId)).list();

		siteCalendarList = session.createCriteria(HrPrjSiteCalendar.class)
		.createAlias("Prj", "prj")
		.add(Restrictions.eq("prj.Id", projectId))
		.add(Restrictions.eq("Site.Id", siteId))
		.list();

		calendarList = session.createCriteria(MstrCalendar.class)
		.add(Restrictions.eq("Status", "y")).list();

		map.put("siteCalendarList", siteCalendarList);
		map.put("calendarList", calendarList);

		fesStudyHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
		vitalsMasterList = session.createCriteria(MstrVitals.class).add(Restrictions.eq("Status", "y")).list();
		currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
		siteVitalList = session.createCriteria(PrjSiteVital.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();

		map.put("fesStudyHeaderList", fesStudyHeaderList);
		map.put("vitalsMasterList", vitalsMasterList);
		map.put("currencyList", currencyList);
		map.put("siteVitalList", siteVitalList);

		map.put("projectList", projectList);
		return map;
	}
	/*   Site Calendar Code End By Naresh  */


//	public Map<String, Object> showDCFEntryJsp(Map<String, Object> generalMap) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		List<PrjSiteResMap> prjSiteResMapList = new ArrayList<PrjSiteResMap>();
//		List<MstrProject> projectList = new ArrayList<MstrProject>();
//		Users users = new Users();
//		if (generalMap.get("users")!= null) {
//			users = (Users)generalMap.get("users");
//		}
//		int employeeId = users.getEmployee().getId();
//		Session session = (Session)getSession();
//		Set<Integer> prjList  = new HashSet<Integer>();
//		prjSiteResMapList = session.createCriteria(PrjSiteResMap.class).createAlias("Employee", "emp").add(Restrictions.eq("emp.Id", employeeId)).list();
//		for(PrjSiteResMap prjSiteMap :prjSiteResMapList  )
//		{
//			prjList.add(prjSiteMap.getPrj().getId());
//		}
//		projectList = session.createCriteria(MstrProject.class).add(Restrictions.in("Id",prjList)).list();
//
//		map.put("projectList", projectList);
//		return map;
//	}
//
//	public Map<String, Object> searchSiteForProject(Map<String, Object> generalMap) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		List<PrjSiteResMap> prjSiteResMapPrjList = new ArrayList<PrjSiteResMap>();
//		List<PrjSiteResMap> prjSiteResMapSiteList = new ArrayList<PrjSiteResMap>();
//		List<PrjPatvisitsch> prjPatvisitschList   = new ArrayList<PrjPatvisitsch>();
//		List<MstrProject> projectList = new ArrayList<MstrProject>();
//		List<MstrSiteHeader> siteHeaderList = new ArrayList<MstrSiteHeader>();
//		Users users = new Users();
//		if (generalMap.get("users")!= null) {
//			users = (Users)generalMap.get("users");
//		}
//		int employeeId = users.getEmployee().getId();
//		int projectId = 0;
//		if (generalMap.get("projectId")!= null) {
//			projectId = (Integer)generalMap.get("projectId");
//		}
//
//		Session session = (Session)getSession();
//		Set<Integer> prjList  = new HashSet<Integer>();
//		Set<Integer> siteList  = new HashSet<Integer>();
//		prjSiteResMapPrjList = session.createCriteria(PrjSiteResMap.class).createAlias("Employee", "emp").add(Restrictions.eq("emp.Id", employeeId)).list();
//		prjSiteResMapSiteList = session.createCriteria(PrjSiteResMap.class).createAlias("Employee", "emp").add(Restrictions.eq("emp.Id", employeeId)).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).list();
//		prjPatvisitschList    = session.createCriteria(PrjPatvisitsch.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id",projectId)).list();
//		for(PrjSiteResMap prjListMap :prjSiteResMapPrjList  )
//		{
//			prjList.add(prjListMap.getPrj().getId());
//
//		}
//		for(PrjSiteResMap siteListMap :prjSiteResMapSiteList  )
//		{
//			siteList.add(siteListMap.getSiteHeader().getId());
//		}
//		projectList = session.createCriteria(MstrProject.class).add(Restrictions.in("Id",prjList)).list();
//		siteHeaderList = session.createCriteria(MstrSiteHeader.class).add(Restrictions.in("Id",siteList)).list();
//		map.put("projectList", projectList);
//		map.put("prjPatvisitschList",prjPatvisitschList);
//		map.put("siteHeaderList", siteHeaderList);
//		return map;
//	}

	public Map<String, Object> searchPatientForSite(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
//		List<PrjSiteResMap> prjSiteResMapPrjList = new ArrayList<PrjSiteResMap>();
//		List<PrjSiteResMap> prjSiteResMapSiteList = new ArrayList<PrjSiteResMap>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<MstrSiteHeader> siteHeaderList = new ArrayList<MstrSiteHeader>();
		List<PrjAddPtHeader> addPatientList = new ArrayList<PrjAddPtHeader>();
		List<PrjPatvisitsch> prjPatvisitschList   = new ArrayList<PrjPatvisitsch>();
		Users users = new Users();
		if (generalMap.get("users")!= null) {
			users = (Users)generalMap.get("users");
		}
		int employeeId = users.getEmployee().getId();
		int projectId = 0;
		if (generalMap.get("projectId")!= null) {
			projectId = (Integer)generalMap.get("projectId");
		}
		int siteId = 0;
		if (generalMap.get("siteId")!= null) {
			siteId = (Integer)generalMap.get("siteId");
		}


		Session session = (Session)getSession();
//		Set<Integer> prjList  = new HashSet<Integer>();
//		Set<Integer> siteList  = new HashSet<Integer>();
//		prjSiteResMapPrjList = session.createCriteria(PrjSiteResMap.class).createAlias("Employee", "emp").add(Restrictions.eq("emp.Id", employeeId)).list();
//		prjSiteResMapSiteList = session.createCriteria(PrjSiteResMap.class).createAlias("Employee", "emp").add(Restrictions.eq("emp.Id", employeeId)).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).list();
		addPatientList = session.createCriteria(PrjAddPtHeader.class).createAlias("SiteHeader", "siteHeader").add(Restrictions.eq("siteHeader.Id", siteId)).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).list();
		prjPatvisitschList    = session.createCriteria(PrjPatvisitsch.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id",projectId)).list();
//		for(PrjSiteResMap prjListMap :prjSiteResMapPrjList  )
//		{
//			prjList.add(prjListMap.getPrj().getId());
//
//		}
//		for(PrjSiteResMap siteListMap :prjSiteResMapSiteList  )
//		{
//			siteList.add(siteListMap.getSiteHeader().getId());
//		}

		projectList = session.createCriteria(MstrProject.class).add(Restrictions.eq("Id",projectId)).list();
		siteHeaderList = session.createCriteria(MstrSiteHeader.class).add(Restrictions.eq("Id",siteId)).list();
		map.put("projectList", projectList);
		map.put("siteHeaderList", siteHeaderList);
		map.put("addPatientList", addPatientList);
		map.put("prjPatvisitschList",prjPatvisitschList);
		return map;
	}
	public Connection getDBConnection() {
		Session session = (Session) getSession(true);
		Connection connection = null;
		Map<String, Object> map = new HashMap<String, Object>();

		try{
			connection  = session.connection();
			//session.close();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}


		return connection;
	}
	public Map<String, Object> saveDCFEntry(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<MstrSiteHeader> siteHeaderList = new ArrayList<MstrSiteHeader>();
		String message = "";


		Session session = (Session)getSession();
		String	emp_code = "";
		if(generalMap.get("emp_code")!= null){
			emp_code =(String)generalMap.get("emp_code");
		}

		int	projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId =(Integer)generalMap.get("projectId");
		}

		int siteId = 0;
		if(generalMap.get("siteId")!= null){
			siteId =(Integer)generalMap.get("siteId");
		}
		String fileName = "";
		if(generalMap.get("file_name")!= null){
			fileName = (String)generalMap.get("file_name");
		}



			 MstrProject mstrProject = new MstrProject();
			 MstrSiteHeader mstrSiteHeader = new MstrSiteHeader();


			 mstrProject.setId(projectId);
			 mstrSiteHeader.setId(siteId);



			 PrjDcfEntry prjDcfEntry = new PrjDcfEntry();

			 prjDcfEntry.setPrj(mstrProject);
			 prjDcfEntry.setSiteHeader(mstrSiteHeader);
			 prjDcfEntry.setFileName(fileName);

			 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			 hbt.setFlushModeName("FLUSH_AUTO");
			 hbt.setCheckWriteOperations(false);
			 hbt.save(prjDcfEntry);
			 hbt.refresh(prjDcfEntry);

			 boolean saved = false;
			 saved =  true;
			if(saved){
				message = "Data save Successfully.";
			}else{
				message = "Some Problem Occured.";
			}


		projectList = session.createCriteria(MstrProject.class).add(Restrictions.eq("Id",projectId)).list();
		siteHeaderList = session.createCriteria(MstrSiteHeader.class).add(Restrictions.eq("Id",siteId)).list();



			map.put("projectList", projectList);
			map.put("siteHeaderList", siteHeaderList);
			map.put("message", message);
		return map;
	}

	public Map<String, Object> showDCFViewJsp(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<PrjDcfEntry> prjDCFEntryList = new ArrayList<PrjDcfEntry>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<MstrSiteHeader> siteHeaderList = new ArrayList<MstrSiteHeader>();

		String message = "";

		Session session = (Session)getSession();
		String	emp_code = "";
		if(generalMap.get("emp_code")!= null){
			emp_code =(String)generalMap.get("emp_code");
		}

		int	projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId =(Integer)generalMap.get("projectId");
		}

		int siteId = 0;
		if(generalMap.get("siteId")!= null){
			siteId =(Integer)generalMap.get("siteId");
		}

		prjDCFEntryList = session.createCriteria(PrjDcfEntry.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id",projectId)).createAlias("SiteHeader", "siteHeader").add(Restrictions.eq("siteHeader.Id", siteId)).list();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.eq("Id",projectId)).list();
		siteHeaderList = session.createCriteria(MstrSiteHeader.class).add(Restrictions.eq("Id",siteId)).list();

			map.put("projectList", projectList);
			map.put("siteHeaderList", siteHeaderList);
			map.put("prjDCFEntryList", prjDCFEntryList);

		return map;
}

public Map<String, Object> approveProject(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();

		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<Integer> maxBillableSeqNo = new ArrayList<Integer>();
		List<Integer> maxNonBillableSeqNo = new ArrayList<Integer>();

		boolean saved = true;

		String message = "";
		String flag = "";
		boolean flagDuplicate = false;
		int	projectId = 0;
		String status = "";
		String comments = "";
		Date approveDate= new Date();

		Session session = (Session)getSession();

		if(generalMap.get("projectId")!= null){
			projectId =(Integer)generalMap.get("projectId");
		}
		if(generalMap.get("status")!= null){
			status =(String)generalMap.get("status");
		}
		if(generalMap.get("approveDate")!= null){
			approveDate =(Date)generalMap.get("approveDate");
		}
		if(generalMap.get("comments")!= null){
			comments =(String)generalMap.get("comments");
		}
		try{

			projectList = session.createCriteria(MstrProject.class)
									.add(Restrictions.eq("Id", projectId))
									.list();
			maxBillableSeqNo = session.createCriteria(MstrProject.class)
									.setProjection(Projections.projectionList()
											.add(Projections.max("PrjBillableSeq")))
									.list();

			maxNonBillableSeqNo = session.createCriteria(MstrProject.class)
									.setProjection(Projections.projectionList()
											.add(Projections.max("PrjNonBillableSeq")))
									.list();

			if (projectList.size()>0){
				MstrProject mstrProject = projectList.get(0);
				if(mstrProject.getPrjFlagDuplicate() == null
						|| !mstrProject.getPrjFlagDuplicate().equalsIgnoreCase("y")){

					mstrProject.setPrjAppstatus(status);
					mstrProject.setPrjAppcmts(comments);
					mstrProject.setPrjAppDate(approveDate);
					mstrProject.setPrjFlagDuplicate("y");

				if(mstrProject.getBillable()!= null && mstrProject.getBillable().equalsIgnoreCase("y")) {
					if(mstrProject.getExtension()!= null && mstrProject.getExtension().equalsIgnoreCase("y")){
						String parentPrjCode = mstrProject.getProjectExtension().getPrjCode();

						StringTokenizer strTokenCode = new StringTokenizer(parentPrjCode,"/");
						String noAfterSlash = "0";
						String noBeforeSlash = "0";

						if(strTokenCode.hasMoreTokens()){
							noBeforeSlash = strTokenCode.nextToken();
						}if(strTokenCode.hasMoreTokens()){
							noAfterSlash = strTokenCode.nextToken();
						}

						if(!noAfterSlash.equals("0")){
							String newPrjCode = Integer.parseInt(noBeforeSlash)+"/"+(Integer.parseInt(noAfterSlash)+1);
							mstrProject.setPrjCode(newPrjCode);
						} else {
							mstrProject.setPrjCode(Integer.parseInt(noBeforeSlash)+"/1");
						}
					} else if(mstrProject.getExtension()!= null && mstrProject.getExtension().equalsIgnoreCase("n")){
						if(maxBillableSeqNo.get(0) != null && !maxBillableSeqNo.get(0).equals("")){
							int maxNo = maxBillableSeqNo.get(0);

							mstrProject.setPrjCode(String.valueOf(maxNo + 1));
							mstrProject.setPrjBillableSeq(maxNo+1);
						}else{
							mstrProject.setPrjCode("1000");
							mstrProject.setPrjBillableSeq(1000);
						}
					}
				}else if(mstrProject.getBillable()!= null && mstrProject.getBillable().equalsIgnoreCase("n")){
					if(mstrProject.getExtension()!= null && mstrProject.getExtension().equalsIgnoreCase("y")){

						String parentPrjCode = mstrProject.getProjectExtension().getPrjCode();
						StringTokenizer strTokenCode = new StringTokenizer(parentPrjCode,"/");
						String noAfterSlash = "0";
						String noBeforeSlash = "0";

						if(strTokenCode.hasMoreTokens()){
							noBeforeSlash = strTokenCode.nextToken();
						}if(strTokenCode.hasMoreTokens()){
							noAfterSlash = strTokenCode.nextToken();
						}

						if(!noAfterSlash.equals("0")){
							String newPrjCode = Integer.parseInt(noBeforeSlash)+"/"+(Integer.parseInt(noAfterSlash)+1);
							mstrProject.setPrjCode(newPrjCode);
						} else {
							mstrProject.setPrjCode(Integer.parseInt(noBeforeSlash)+"/1");
						}
					}else if(mstrProject.getExtension()!= null && mstrProject.getExtension().equalsIgnoreCase("n")){
						if(maxNonBillableSeqNo.get(0) != null && !maxNonBillableSeqNo.get(0).equals("")){
							int maxNo = maxNonBillableSeqNo.get(0);

							mstrProject.setPrjCode(String.valueOf(maxNo + 1));
							mstrProject.setPrjNonBillableSeq(maxNo+1);
						}else{
							mstrProject.setPrjCode("2000");
							mstrProject.setPrjNonBillableSeq(2000);
						}

					}
				}
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(mstrProject);
					hbt.refresh(mstrProject);
				} else {
					flagDuplicate = true;
				}
			}
		}catch (Exception e) {
			saved = false;
			e.printStackTrace();
		}

		if(saved){
			if(flagDuplicate){
				message = "Duplicate Entry For Project.";
			}else{
				message = "Data saved Successfully.";
			}
		}else{
			message = "Some Problem Occured.";
		}

		map.put("flag", flag);
		map.put("message", message);
		return map;
	}


	public Map<String, Object> showScheduleSettingJsp(Map<String, Object> generalMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<MstrProject> projectList = new ArrayList<MstrProject>();
	List<PrjFesStudyHeader> fesStudyHeaderList = new ArrayList<PrjFesStudyHeader>();
	List<HrMasVisitType> masVisitTypeList = new ArrayList<HrMasVisitType>();
	List<PrjScheduleHeader> prjScheduleHeaderList = new ArrayList<PrjScheduleHeader>();
	List<PrjScheduleDetail> prjDetailList = new ArrayList<PrjScheduleDetail>();
	//List<PrjPatvisitsch> prjpatientVistList = new ArrayList<PrjPatvisitsch>();
	List<MstrPtvisit> ptVisitList = new ArrayList<MstrPtvisit>();
	Session session = (Session)getSession();
	int projectId = 0;
	if(generalMap.get("projectId")!= null){
		projectId = (Integer)generalMap.get("projectId");
	}

	int siteId = 0;
	if(generalMap.get("siteId")!= null){
		siteId = (Integer)generalMap.get("siteId");
	}
	fesStudyHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
	projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
	masVisitTypeList = session.createCriteria(HrMasVisitType.class).add(Restrictions.eq("Status", "y")).list();
	prjDetailList = session.createCriteria(PrjScheduleDetail.class).createAlias("ScheduleHeader", "scHeader").createAlias("scHeader.Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("scHeader.Site", "header").add(Restrictions.eq("header.Id", siteId)).list();
	//prjpatientVistList = session.createCriteria(PrjPatvisitsch.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
	//map.put("prjpatientVistList", prjpatientVistList);
	ptVisitList = session.createCriteria(MstrPtvisit.class).list();
	map.put("ptVisitList", ptVisitList);
	map.put("prjDetailList", prjDetailList);
	map.put("fesStudyHeaderList", fesStudyHeaderList);
	map.put("projectList", projectList);
	map.put("masVisitTypeList", masVisitTypeList);
		return map;
	}
	public Map<String, Object> createSchedule(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PrjPatvisitsch> patienVisitScheduleList = new ArrayList<PrjPatvisitsch>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjFesStudyHeader> fesStudyHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<HrMasVisitType> masVisitTypeList = new ArrayList<HrMasVisitType>();
		List<PrjScheduleDetail> prjDetailList = new ArrayList<PrjScheduleDetail>();
		//List<PrjPatvisitsch> prjpatientVistList = new ArrayList<PrjPatvisitsch>();
		List<MstrPtvisit> ptVisitList = new ArrayList<MstrPtvisit>();
		Session session = (Session)getSession();
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId = (Integer)(generalMap.get("projectId"));
		}
		int siteId = 0;
		if(generalMap.get("siteId")!= null){
			siteId = (Integer)(generalMap.get("siteId"));
		}
		int visitTypeId = 0;
		if(generalMap.get("visitTypeId")!= null){
			visitTypeId = (Integer)(generalMap.get("visitTypeId"));
		}
		int	hospitalId = 0;
		if(generalMap.get("hospitalId")!= null){
			hospitalId = (Integer)(generalMap.get("hospitalId"));
		}

		Date siteInitiationDate = null;
		if(generalMap.get("siteInitiationDate")!= null){
			siteInitiationDate = (Date)(generalMap.get("siteInitiationDate"));
		}
		String changedBy = "";
		if(generalMap.get("changedBy")!= null){
			changedBy = (String)(generalMap.get("changedBy"));
		}
		Date currentDate = new Date();
		if(generalMap.get("currentDate")!= null){
			currentDate = (Date)(generalMap.get("currentDate"));
		}
		String	currentTime = "";
		if(generalMap.get("currentTime")!= null){
			currentTime = (String)(generalMap.get("currentTime"));
		}

		patienVisitScheduleList = session.createCriteria(PrjPatvisitsch.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("VisitType", "vType").add(Restrictions.eq("vType.Id", visitTypeId)).list();
		PrjScheduleHeader prjScheduleHeader = new PrjScheduleHeader();

		MstrProject mstrProject = new MstrProject();
		mstrProject.setId(projectId);
		prjScheduleHeader.setPrj(mstrProject);

		MstrSiteHeader mstrSiteHeader = new MstrSiteHeader();
		mstrSiteHeader.setId(siteId);
		prjScheduleHeader.setSite(mstrSiteHeader);

		HrMasVisitType hrMasVisitType = new HrMasVisitType();
		hrMasVisitType.setId(visitTypeId);
		prjScheduleHeader.setVisit(hrMasVisitType);

		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		prjScheduleHeader.setHospital(masHospital);
		prjScheduleHeader.setLastChgBy(changedBy);
		prjScheduleHeader.setLastChgDate(currentDate);
		prjScheduleHeader.setLastChgTime(currentTime);
		prjScheduleHeader.setSiteInitiationDate(siteInitiationDate);
		prjScheduleHeader.setStatus("y");

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(prjScheduleHeader);

		int interval = 0;
		Date visitDate = null;
		int patientVisitId = 0;
		int visitId  = 0;
		 if(patienVisitScheduleList.size()>0){
			 for(PrjPatvisitsch prjPatvisitsch :patienVisitScheduleList){
				PrjScheduleDetail prjScheduleDetail = new PrjScheduleDetail();
				 interval = prjPatvisitsch.getPvInt();
				 patientVisitId = prjPatvisitsch.getId();
				 visitId = prjPatvisitsch.getPatientVisit().getId();
				try {
					visitDate = HMSUtil.addDaysToDate(HMSUtil.convertDateToStringTypeDate(siteInitiationDate), interval);
				} catch (Exception e) {
					e.printStackTrace();
				}
				MstrPtvisit mstrPtvisit = new MstrPtvisit();
				mstrPtvisit.setId(visitId);
				prjScheduleDetail.setPatientVisit(mstrPtvisit);

				prjPatvisitsch.setId(patientVisitId);
				prjScheduleDetail.setPv(prjPatvisitsch);

				MstrPtvisit mstPtvisit = new MstrPtvisit();
				mstPtvisit.setId(visitId);

				prjScheduleDetail.setScheduleHeader(prjScheduleHeader);
				prjScheduleDetail.setPlannedDate(visitDate);
				prjScheduleDetail.setVisitInterval(interval);
				prjScheduleDetail.setRevisedDate(visitDate);
				hbt.save(prjScheduleDetail);
			 }
		}
		 	ptVisitList = session.createCriteria(MstrPtvisit.class).list();
			map.put("ptVisitList", ptVisitList);
		 	fesStudyHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
			projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
			masVisitTypeList = session.createCriteria(HrMasVisitType.class).add(Restrictions.eq("Status", "y")).list();
			prjDetailList = session.createCriteria(PrjScheduleDetail.class).createAlias("ScheduleHeader", "scHeader").createAlias("scHeader.Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("scHeader.Site", "header").add(Restrictions.eq("header.Id", siteId)).list();
			//prjpatientVistList = session.createCriteria(PrjPatvisitsch.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
			//map.put("prjpatientVistList", prjpatientVistList);
			map.put("fesStudyHeaderList", fesStudyHeaderList);
			map.put("projectList", projectList);
			map.put("masVisitTypeList", masVisitTypeList);
			map.put("prjDetailList", prjDetailList);
			//map.put("visitTypeId", visitTypeId);
		return map;
	}
	public Map<String, Object> editScheduleDetails(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PrjPatvisitsch> patienVisitScheduleList = new ArrayList<PrjPatvisitsch>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjFesStudyHeader> fesStudyHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<HrMasVisitType> masVisitTypeList = new ArrayList<HrMasVisitType>();
		List<PrjScheduleDetail> prjDetailList = new ArrayList<PrjScheduleDetail>();
		//List<PrjPatvisitsch> prjpatientVistList = new ArrayList<PrjPatvisitsch>();
		List<MstrPtvisit> ptVisitList = new ArrayList<MstrPtvisit>();

		List scheduleDetailIdList =new ArrayList();
		List actualDateList =new ArrayList();
		List revisedDateList =new ArrayList();
		List variationList =new ArrayList();
		List statusList =new ArrayList();
		List commentList =new ArrayList();
		List fileList =new ArrayList();
		Session session = (Session)getSession();
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId = (Integer)generalMap.get("projectId");
		}
		int siteId = 0;
		if(generalMap.get("siteId")!= null){
			siteId = (Integer)generalMap.get("siteId");
		}
		int visitTypeId = 0;
		if(generalMap.get("visitTypeId")!= null){
			visitTypeId = (Integer)generalMap.get("visitTypeId");
		}
		if (generalMap.get("actualDateList")!= null) {
			actualDateList = (List)generalMap.get("actualDateList");
		}
		if (generalMap.get("revisedDateList")!= null) {
			revisedDateList = (List)generalMap.get("revisedDateList");
		}
		if (generalMap.get("scheduleDetailIdList")!= null) {
			scheduleDetailIdList = (List)generalMap.get("scheduleDetailIdList");
		}
		if (generalMap.get("variationList")!= null) {
			variationList = (List)generalMap.get("variationList");
		}
		if (generalMap.get("commentList")!= null) {
			commentList = (List)generalMap.get("commentList");
		}
		if (generalMap.get("statusList")!= null) {
			statusList = (List)generalMap.get("statusList");
		}
		int detailId = 0;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if(scheduleDetailIdList.size()>0){
			for (int i = 0; i <scheduleDetailIdList.size(); i++) {
				PrjScheduleDetail prjScheduleDetail= (PrjScheduleDetail)hbt.load(PrjScheduleDetail.class, (new Integer(scheduleDetailIdList.get(i).toString())));
				if(actualDateList.size()>0	){
				if(actualDateList.get(i) != ""){
					Date actualDate = HMSUtil.convertStringTypeDateToDateType(actualDateList.get(i).toString());
					prjScheduleDetail.setActualDate(actualDate);
					}
				}
				if(revisedDateList.size()>0	){
				if(revisedDateList.get(i) != ""){
					Date revisedDate = HMSUtil.convertStringTypeDateToDateType(revisedDateList.get(i).toString());
					prjScheduleDetail.setRevisedDate(revisedDate);
					}
				}
				if(commentList.size()>0){
				if(commentList.get(i) != ""){
					String comment =(String)commentList.get(i);
					prjScheduleDetail.setComment(comment);
				}
				}
				if(statusList.size()>0){
				if(statusList.get(i) != ""){
					String scheduleStatus =(String)statusList.get(i);
					prjScheduleDetail.setScheduleStatus(scheduleStatus);
				}
				}
				if(variationList.size()>0){
				if(variationList.get(i) != ""){
					int variation = Integer.parseInt(variationList.get(i).toString());
					prjScheduleDetail.setVariation(variation);
				}
				}

				hbt.update(prjScheduleDetail);
			}
		}
		fesStudyHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		masVisitTypeList = session.createCriteria(HrMasVisitType.class).add(Restrictions.eq("Status", "y")).list();
		prjDetailList = session.createCriteria(PrjScheduleDetail.class).createAlias("ScheduleHeader", "scHeader").createAlias("scHeader.Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("scHeader.Site", "header").add(Restrictions.eq("header.Id", siteId)).list();
		//prjpatientVistList = session.createCriteria(PrjPatvisitsch.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
		//map.put("prjpatientVistList", prjpatientVistList);
		ptVisitList = session.createCriteria(MstrPtvisit.class).list();
		map.put("ptVisitList", ptVisitList);
		map.put("fesStudyHeaderList", fesStudyHeaderList);
		map.put("projectList", projectList);
		map.put("masVisitTypeList", masVisitTypeList);
		map.put("prjDetailList", prjDetailList);
		map.put("visitTypeId", visitTypeId);
		return map;
	}
	public Map<String, Object> attachScheduleDocument(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PrjScheduleDetail> prjScheduleDetailList = new ArrayList<PrjScheduleDetail>();
		List<PrjScheduleDocument> prjScheduleDocumentList = new ArrayList<PrjScheduleDocument>();
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId =(Integer)generalMap.get("projectId");
		}
		int scheduleDetailId = 0;
		if(generalMap.get("scheduleDetailId")!= null){
			scheduleDetailId =(Integer)generalMap.get("scheduleDetailId");
		}
		Session session = (Session)getSession();
		prjScheduleDetailList = session.createCriteria(PrjScheduleDetail.class).add(Restrictions.idEq(scheduleDetailId)).list();
		prjScheduleDocumentList = session.createCriteria(PrjScheduleDocument.class).createAlias("ScheduleDetail", "scheduleDetail").add(Restrictions.eq("scheduleDetail.Id", scheduleDetailId)).list();
		map.put("prjScheduleDetailList", prjScheduleDetailList);
		map.put("prjScheduleDocumentList", prjScheduleDocumentList);
		return map;
	}
	public Map<String, Object> addCreateScheduleFile(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PrjScheduleDetail> prjScheduleDetailList = new ArrayList<PrjScheduleDetail>();
		List<PrjScheduleDocument> prjScheduleDocumentList = new ArrayList<PrjScheduleDocument>();
		Session session = (Session)getSession();
		String filename = "";
		if(generalMap.get("filename")!= null){
			filename =(String) generalMap.get("filename");
		}
		String uploadURL = "";
		if(generalMap.get("uploadURL")!= null){
			uploadURL =(String) generalMap.get("uploadURL");
		}
		String comments = "";
		if(generalMap.get("comments")!= null){
			comments =(String) generalMap.get("comments");
		}
		int scheduleDetailId = 0;
		if(generalMap.get("scheduleDetailId")!= null){
			scheduleDetailId =(Integer) generalMap.get("scheduleDetailId");
		}

		String fileExtension=null;
		 File file=null;
		 try {
				HibernateTemplate hbt=getHibernateTemplate();
				//hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);

	    		 file=new File(uploadURL + "/" + filename);
	    	     FileInputStream is = new FileInputStream(file);
	    	     long length = file.length();
	    	     ByteBuffer byteBuff=null;
	    	   //  int modLength=length/
	    	     if (length > Integer.MAX_VALUE) {
	            // File is too large
	    	     }
	    	     // Create the byte array to hold the data
	    	     byte[] bytes = new byte[(int)length];
	    	     int offset = 0;
	    	     int numRead = 0;
	    	     while (offset < bytes.length
	    	    		 && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	    	    	 offset += numRead;

	    	     }

	    	     if (offset < bytes.length) {
	    	    	 throw new IOException("Could not completely read file "+file.getName());

	    	     }
	    	     is.close();
	        // Close the input stream and return bytes
	    	    // StringTokenizer strToken=new StringTokenizer( filename,".");

	    	   //  filename=strToken.nextToken();
	    	   //  fileExtension=strToken.nextToken();

	    		PrjScheduleDocument prjScheduleDocument = new PrjScheduleDocument();
	    		prjScheduleDocument.setFileName(filename);

	    		prjScheduleDocument.setComment(comments);
	    		PrjScheduleDetail prjScheduleDetail = new PrjScheduleDetail();
	    		prjScheduleDetail.setId(scheduleDetailId);
	    		prjScheduleDocument.setScheduleDetail(prjScheduleDetail);

	    	     hbt.save(prjScheduleDocument);
	    	     //file.delete();


	    }// end of 'try' loop
		catch (Exception e) {

	      System.err.println("Error: " + e.getMessage());
	      e.printStackTrace();
	    }
		prjScheduleDetailList = session.createCriteria(PrjScheduleDetail.class).add(Restrictions.idEq(scheduleDetailId)).list();
		prjScheduleDocumentList = session.createCriteria(PrjScheduleDocument.class).createAlias("ScheduleDetail", "scheduleDetail").add(Restrictions.eq("scheduleDetail.Id", scheduleDetailId)).list();
		map.put("prjScheduleDetailList", prjScheduleDetailList);
		map.put("prjScheduleDocumentList", prjScheduleDocumentList);
		return map;
	}
	public Map<String, Object> viewCreateScheduleDocument(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PrjScheduleDetail> prjScheduleDetailList = new ArrayList<PrjScheduleDetail>();
		List<PrjScheduleDocument> prjScheduleDocumentList = new ArrayList<PrjScheduleDocument>();

		int scheduleDetailId = 0;
		if(generalMap.get("scheduleDetailId")!= null){
			scheduleDetailId =(Integer)generalMap.get("scheduleDetailId");
		}
		Session session = (Session)getSession();
		prjScheduleDetailList = session.createCriteria(PrjScheduleDetail.class).add(Restrictions.idEq(scheduleDetailId)).list();
		prjScheduleDocumentList = session.createCriteria(PrjScheduleDocument.class).createAlias("ScheduleDetail", "scheduleDetail").add(Restrictions.eq("scheduleDetail.Id", scheduleDetailId)).list();
		map.put("prjScheduleDetailList", prjScheduleDetailList);
		map.put("prjScheduleDocumentList", prjScheduleDocumentList);
		return map;
	}
	public Map<String, Object> updateScheduleSettingJsp(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjFesStudyHeader> fesStudyHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<HrMasVisitType> masVisitTypeList = new ArrayList<HrMasVisitType>();
		List<PrjScheduleDetail> prjScheduleDetailList = new ArrayList<PrjScheduleDetail>();
		List<MstrPtvisit> ptVisitList = new ArrayList<MstrPtvisit>();
		Session session = (Session)getSession();
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId = (Integer)generalMap.get("projectId");
		}

		int siteId = 0;
		if(generalMap.get("siteId")!= null){
			siteId = (Integer)generalMap.get("siteId");
		}
		fesStudyHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		masVisitTypeList = session.createCriteria(HrMasVisitType.class).add(Restrictions.eq("Status", "y")).list();
		prjScheduleDetailList = session.createCriteria(PrjScheduleDetail.class).createAlias("ScheduleHeader", "schedule").createAlias("schedule.Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("schedule.Site", "site").add(Restrictions.eq("site.Id", siteId)).list();
		ptVisitList = session.createCriteria(MstrPtvisit.class).list();

		map.put("ptVisitList", ptVisitList);
		map.put("prjScheduleDetailList", prjScheduleDetailList);
		map.put("fesStudyHeaderList", fesStudyHeaderList);
		map.put("projectList", projectList);
		map.put("masVisitTypeList", masVisitTypeList);
		return map;
	}
	public Map<String, Object> saveUpdateSchedule(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjFesStudyHeader> fesStudyHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<HrMasVisitType> masVisitTypeList = new ArrayList<HrMasVisitType>();
		List<PrjScheduleDetail> prjScheduleDetailList = new ArrayList<PrjScheduleDetail>();
		List<MstrPtvisit> ptVisitList = new ArrayList<MstrPtvisit>();
		int visitTypeId = 0;
		if(generalMap.get("visitTypeId")!= null){
			visitTypeId = (Integer)generalMap.get("visitTypeId");
		}
		Session session = (Session)getSession();
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId = (Integer)generalMap.get("projectId");
		}

		int siteId = 0;
		if(generalMap.get("siteId")!= null){
			siteId = (Integer)generalMap.get("siteId");
		}
		fesStudyHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		masVisitTypeList = session.createCriteria(HrMasVisitType.class).add(Restrictions.eq("Status", "y")).list();
		prjScheduleDetailList = session.createCriteria(PrjScheduleDetail.class).createAlias("ScheduleHeader", "schedule").createAlias("schedule.Visit", "visit").add(Restrictions.eq("visit.Id", visitTypeId)).createAlias("schedule.Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("schedule.Site", "site").add(Restrictions.eq("site.Id", siteId)).list();
		ptVisitList = session.createCriteria(MstrPtvisit.class).list();
		map.put("ptVisitList", ptVisitList);
		map.put("prjScheduleDetailList", prjScheduleDetailList);
		map.put("fesStudyHeaderList", fesStudyHeaderList);
		map.put("projectList", projectList);
		map.put("masVisitTypeList", masVisitTypeList);
		map.put("visitTypeId", visitTypeId);
		return map;
	}
	public Map<String, Object> updateScheduleDetails(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PrjPatvisitsch> patienVisitScheduleList = new ArrayList<PrjPatvisitsch>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<PrjFesStudyHeader> fesStudyHeaderList = new ArrayList<PrjFesStudyHeader>();
		List<PrjScheduleDetail> prjScheduleDetailList = new ArrayList<PrjScheduleDetail>();
		List<HrMasVisitType> masVisitTypeList = new ArrayList<HrMasVisitType>();
		List<PrjScheduleDetail> prjDetailList = new ArrayList<PrjScheduleDetail>();
		//List<PrjPatvisitsch> prjpatientVistList = new ArrayList<PrjPatvisitsch>();
		List<MstrPtvisit> ptVisitList = new ArrayList<MstrPtvisit>();

		List scheduleDetailIdList =new ArrayList();
		List actualDateList =new ArrayList();
		List revisedDateList =new ArrayList();
		List variationList =new ArrayList();
		List statusList =new ArrayList();
		List commentList =new ArrayList();
		List fileList =new ArrayList();
		Session session = (Session)getSession();
		int projectId = 0;
		if(generalMap.get("projectId")!= null){
			projectId = (Integer)generalMap.get("projectId");
		}
		int siteId = 0;
		if(generalMap.get("siteId")!= null){
			siteId = (Integer)generalMap.get("siteId");
		}
		int visitTypeId = 0;
		if(generalMap.get("visitTypeId")!= null){
			visitTypeId = (Integer)generalMap.get("visitTypeId");
		}
		if (generalMap.get("actualDateList")!= null) {
			actualDateList = (List)generalMap.get("actualDateList");
		}
		if (generalMap.get("revisedDateList")!= null) {
			revisedDateList = (List)generalMap.get("revisedDateList");
		}
		if (generalMap.get("scheduleDetailIdList")!= null) {
			scheduleDetailIdList = (List)generalMap.get("scheduleDetailIdList");
		}
		if (generalMap.get("variationList")!= null) {
			variationList = (List)generalMap.get("variationList");
		}
		if (generalMap.get("commentList")!= null) {
			commentList = (List)generalMap.get("commentList");
		}
		if (generalMap.get("statusList")!= null) {
			statusList = (List)generalMap.get("statusList");
		}
		int detailId = 0;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if(scheduleDetailIdList.size()>0){
			for (int i = 0; i <scheduleDetailIdList.size(); i++) {
				PrjScheduleDetail prjScheduleDetail= (PrjScheduleDetail)hbt.load(PrjScheduleDetail.class, (new Integer(scheduleDetailIdList.get(i).toString())));
				if(actualDateList.size()>0	){
				if(actualDateList.get(i) != ""){
					Date actualDate = HMSUtil.convertStringTypeDateToDateType(actualDateList.get(i).toString());
					prjScheduleDetail.setActualDate(actualDate);
					}
				}

				if(commentList.size()>0){
				if(commentList.get(i) != ""){
					String comment =(String)commentList.get(i);
					prjScheduleDetail.setComment(comment);
				}
				}
				if(statusList.size()>0){
				if(statusList.get(i) != ""){
					String scheduleStatus =(String)statusList.get(i);
					prjScheduleDetail.setScheduleStatus(scheduleStatus);
				}
				}
				if(variationList.size()>0){
				if(variationList.get(i) != ""){
					int variation = Integer.parseInt(variationList.get(i).toString());
					prjScheduleDetail.setVariation(variation);
				}
				}

				hbt.update(prjScheduleDetail);
			}
		}
		fesStudyHeaderList = session.createCriteria(PrjFesStudyHeader.class).createAlias("Prj","prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).list();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.idEq(projectId)).list();
		masVisitTypeList = session.createCriteria(HrMasVisitType.class).add(Restrictions.eq("Status", "y")).list();
		prjScheduleDetailList = session.createCriteria(PrjScheduleDetail.class).createAlias("ScheduleHeader", "schedule").createAlias("schedule.Visit", "visit").add(Restrictions.eq("visit.Id", visitTypeId)).createAlias("schedule.Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("schedule.Site", "site").add(Restrictions.eq("site.Id", siteId)).list();

		//prjpatientVistList = session.createCriteria(PrjPatvisitsch.class).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).list();
		//map.put("prjpatientVistList", prjpatientVistList);
		ptVisitList = session.createCriteria(MstrPtvisit.class).list();
		map.put("ptVisitList", ptVisitList);
		map.put("fesStudyHeaderList", fesStudyHeaderList);
		map.put("projectList", projectList);
		map.put("masVisitTypeList", masVisitTypeList);
		map.put("visitTypeId", visitTypeId);
		map.put("prjScheduleDetailList", prjScheduleDetailList);
		return map;
	}




}
