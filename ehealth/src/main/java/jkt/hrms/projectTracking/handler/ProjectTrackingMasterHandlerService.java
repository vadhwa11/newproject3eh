package jkt.hrms.projectTracking.handler;

import java.util.List;
import java.util.Map;


import jkt.hrms.masters.business.HrMasVisitType;
import jkt.hrms.masters.business.MstrBudgetSubhead;
import jkt.hrms.masters.business.MstrBudgetType;
import jkt.hrms.masters.business.MstrCalendar;
import jkt.hrms.masters.business.MstrDeptTaskMap;
import jkt.hrms.masters.business.MstrDoctype;
import jkt.hrms.masters.business.MstrDocument;
import jkt.hrms.masters.business.MstrPiHeader;
import jkt.hrms.masters.business.MstrProjectStatus;
import jkt.hrms.masters.business.MstrProjectrole;
import jkt.hrms.masters.business.MstrPtvisit;
import jkt.hrms.masters.business.MstrRating;
import jkt.hrms.masters.business.MstrRoleTaskMap;
import jkt.hrms.masters.business.MstrSponsor;
import jkt.hrms.masters.business.MstrSponsortype;
import jkt.hrms.masters.business.MstrTask;
import jkt.hrms.masters.business.MstrTaskType;
import jkt.hrms.masters.business.MstrTherapeutic;
import jkt.hrms.masters.business.MstrProjecttype;
import jkt.hrms.masters.business.MstrTrialphase;
import jkt.hrms.masters.business.MstrVendor;
import jkt.hrms.masters.business.MstrVitals;
import jkt.hrms.masters.business.VendorServiceType;

public interface ProjectTrackingMasterHandlerService {
	
	Map<String, Object> checkForExistingMasters(Map<String, Object> generalMap);
//------------------------------------ Therapeutic master ------------------------------------
	
	Map<String, Object> searchTherapeutic(String thpCode, String thpDesc);

	Map<String, Object> showTherapeuticJsp();

	boolean addTherapeutic(MstrTherapeutic mstrTherapeutic);

	boolean editTherapeuticToDatabase(Map<String, Object> generalMap);

	boolean deleteTherapeutic(int therapeuticId, Map<String, Object> generalMap);
	
//------------------------------------ Project Role master ------------------------------------
	
	Map<String, Object> searchProjectRole(String prjCode, String prjName);
	
	Map<String, Object> showProjectRoleJsp();

	boolean addProjectRole(MstrProjectrole mstrProjectrole);

	boolean editProjectRoleToDatabase(Map<String, Object> generalMap);

	boolean deleteProjectRole(int projectRoleId, Map<String, Object> generalMap);
	
//------------------------------------ Project Type master ------------------------------------
	
	Map<String, Object> searchProjectType(String prjTypeCode, String prjTypeName);
	
	Map<String, Object> showProjectTypeJsp();

	boolean addProjectType(MstrProjecttype mstrProjecttype);

	boolean editProjectTypeToDatabase(Map<String, Object> generalMap);

	boolean deleteProjectType(int projectTypeId, Map<String, Object> generalMap);
	
	
//------------------------------------ Trial Phase master ------------------------------------
	
	Map<String, Object> searchTrialPhase(String trialPhaseCode, String trialPhaseName);
	
	Map<String, Object> showTrialPhaseJsp();

	boolean addTrialPhase(MstrTrialphase mstrTrialphase);

	boolean editTrialPhaseToDatabase(Map<String, Object> generalMap);

	boolean deleteTrialPhase(int trialPhaseId, Map<String, Object> generalMap);
	
//------------------------------------ Sponser Type Phase master ------------------------------------
	
	Map<String, Object> searchSponserType(String sponserTypeCode, String sponserTypeName);
	
	Map<String, Object> showSponserTypeJsp();

	boolean addSponserType(MstrSponsortype mstrSponsortype);

	boolean editSponserTypeToDatabase(Map<String, Object> generalMap);

	boolean deleteSponserType(int sponserTypeId, Map<String, Object> generalMap);


//------------------------------------ Budget Sub-Heading master ------------------------------------

	Map<String, Object> searchBudgetSubHeading(String budgetSubHeadingCode, String budgetSubHeadingName);
	 
	Map<String, Object> showBudgetSubHeadingJsp();
	
	boolean addBudgetSubHeading(MstrBudgetSubhead mstrBudgetSubhead);
	
	boolean editBudgetSubHeadingToDatabase(Map<String, Object> generalMap);
	
	boolean deleteBudgetSubHeading(int budgetSubHeadingId, Map<String, Object> generalMap);
	
	//------------------------------------ Task Type master ------------------------------------

	Map<String, Object> searchTaskType(String taskTypeCode, String taskTypeName);
	 
	Map<String, Object> showTaskTypeJsp();
	
	boolean addTaskType(MstrTaskType mstrTaskType);
	
	boolean editTaskTypeToDatabase(Map<String, Object> generalMap);
	
	boolean deleteTaskType(int taskTypeId, Map<String, Object> generalMap);
	
	//------------------------------------ Task  master ------------------------------------

	Map<String, Object> searchTask(String taskCode, String taskName);
	 
	Map<String, Object> showTaskMasterJsp();
	
	boolean addTask(MstrTask mstrTask);
	
	boolean editTaskToDatabase(Map<String, Object> generalMap);
	
	boolean deleteTask(int taskId, Map<String, Object> generalMap);
	
	//------------------------------------ Budget Type master ------------------------------------

	Map<String, Object> searchBudgetType(String budgetTypeCode, String budgetTypeName);
	 
	Map<String, Object> showBudgetTypeJsp();
	
	boolean addBudgetType(MstrBudgetType mstrBudgetType);
	
	boolean editBudgetTypeToDatabase(Map<String, Object> generalMap);
	
	boolean deleteBudgetType(int budgetTypeId, Map<String, Object> generalMap);
	
	//------------------------------------ Patient Visit master ------------------------------------

	Map<String, Object> searchPatientVisit(String patientVisitCode, String patientVisitName);
	 
	Map<String, Object> showPatientVisitJsp();
	
	boolean addPatientVisit(MstrPtvisit mstrPtvisit);
	
	boolean editPatientVisitToDatabase(Map<String, Object> generalMap);
	
	boolean deletePatientVisit(int budgetTypeId, Map<String, Object> generalMap);
	
	
	//------------------------------------ Document Type master ------------------------------------

	Map<String, Object> searchDocumentType(String documentTypeCode, String documentTypeName);
	 
	Map<String, Object> showDocumentTypeJsp();
	
	boolean addDocumentType(MstrDoctype mstrDoctype);
	
	boolean editDocumentTypeToDatabase(Map<String, Object> generalMap);
	
	boolean deleteDocumentType(int documentTypeId, Map<String, Object> generalMap);
	
	
	//------------------------------------ Document  master ------------------------------------

	Map<String, Object> searchDocument(String documentCode, String documentName);
	 
	Map<String, Object> showDocumentJsp();
	
	boolean addDocument(MstrDocument mstrDocument);
	
	boolean editDocumentToDatabase(Map<String, Object> generalMap);
	
	boolean deleteDocument(int documentId, Map<String, Object> generalMap);
	
	//------------------------------------ Rating  master ------------------------------------

	Map<String, Object> searchRating(String ratingCode, String ratingName);
	 
	Map<String, Object> showRatingJsp();
	
	boolean addRating(MstrRating mstrRating);
	
	boolean editRatingToDatabase(Map<String, Object> generalMap);
	
	boolean deleteRating(int ratingId, Map<String, Object> generalMap);
	
	//------------------------------------ Department Task Map   ------------------------------------

	 
	Map<String, Object> showDeptTaskMapJsp();
	public List getDeptTaskMapFromDB(List toBeassignedList);
	public Map<String, Object> showDeptTaskMapJsp(Integer deptId) ;
	boolean saveDeptTaskMapDB(MstrDeptTaskMap deptTaskMap);
	public List getDeptTaskMap(Map map);
	
	//------------------------------------ Role Task Map   ------------------------------------

	 
	Map<String, Object> showRoleDeptTaskMapJsp();
	public List getRoleDeptTaskMapFromDB(List toBeassignedList);
	public Map<String, Object> showRoleDeptTaskMapJsp(Integer deptId, Integer rankId) ;
	boolean saveRoleDeptTaskMapDB(MstrRoleTaskMap roleTaskMap);
	public List getRoleDeptTaskMap(Map map);
	
	//------------------------------------ Vendor  master ------------------------------------

	Map<String, Object> searchVendor(String vendorCode, String vendorName);
	Map<String, Object> showVendorJsp();
	boolean addVendor(MstrVendor mstrVendor);
	boolean editVendorToDatabase(Map<String, Object> generalMap);
	boolean deleteVendor(int vendorId, Map<String, Object> generalMap);
	
	//------------------------------------ Pi  master ------------------------------------

	Map<String, Object> searchPi(String piCode, String piName);
	Map<String, Object> showPiJsp();
	boolean addPi(Map<String, Object> newMap);
	boolean editPiToDatabase(Map<String, Object> generalMap);
	boolean deletePi(int piId, Map<String, Object> generalMap);
	
	//------------------------------------ Site  master ------------------------------------

	Map<String, Object> searchSite(String siteCode, String siteName);
	Map<String, Object> showSiteJsp();
	boolean addSite(Map<String, Object> newMap);
	boolean editSiteToDatabase(Map<String, Object> generalMap);
	boolean deleteSite(int siteId, Map<String, Object> generalMap);
	
	//------------------------------------ Calendar master ------------------------------------

	Map<String, Object> searchCalendar(String calendarCode, String calendarName);
	 
	Map<String, Object> showCalendarJsp();
	
	boolean addCalendar(MstrCalendar mstrCalendar);
	
	boolean editCalendarToDatabase(Map<String, Object> generalMap);
	
	boolean deleteCalendar(int calendarId, Map<String, Object> generalMap);
	
	//------------------------------------ Project Status master ------------------------------------

	Map<String, Object> searchProjectStatus(String calendarCode, String calendarName);
	 
	Map<String, Object> showProjectStatusJsp();
	
	boolean addProjectStatus(MstrProjectStatus mstrProjectStatus);
	
	boolean editProjectStatusToDatabase(Map<String, Object> generalMap);
	
	boolean deleteProjectStatus(int projectStatusId, Map<String, Object> generalMap);
	
	//------------------------------------ Vendor Service Type master ------------------------------------

	Map<String, Object> searchVendorServiceType(String vendorServiceTypeCode, String vendorServiceTypeName);
	 
	Map<String, Object> showVendorServiceTypeJsp();
	
	boolean addVendorServiceType(VendorServiceType vendorServiceType);
	
	boolean editVendorServiceTypeToDatabase(Map<String, Object> generalMap);
	
	boolean deleteVendorServiceType(int vendorServiceTypeId, Map<String, Object> generalMap);

	
//------------------------------------ Sponser  master ------------------------------------
	
	Map<String, Object> searchSponsor(String sponsorCode, String sponsorName);
	
	Map<String, Object> showSponsorJsp();

	boolean addSponsor(MstrSponsor mstrSponsor);

	boolean editSponsorToDatabase(Map<String, Object> generalMap);

	boolean deleteSponsor(int sponsorId, Map<String, Object> generalMap);
	// 	Method For Site By Naresh
	Map<String, Object> showVisitTypeJsp() ;
	
	boolean addVisitType(HrMasVisitType hrMasVisitType);
	
	Map<String, Object> searchVisitType(String visitTypeCode, String visitTypeName);
	
	boolean editVisitTypeToDatabase(Map<String, Object> generalMap) ;
	
	boolean deleteVisitType(int visitTypeId,Map<String, Object> generalMap) ;
	// Method For Site By Naresh	
	//------------------------------------ Vitals master ------------------------------------

	Map<String, Object> searchVitals(String vitalsCode, String vitalsName);
	 
	Map<String, Object> showVitalsJsp();
	
	boolean addVitals(MstrVitals mstrVitals);
	
	boolean editVitalsToDatabase(Map<String, Object> generalMap);
	
	boolean deleteVitals(int vitalsId, Map<String, Object> generalMap);

}
