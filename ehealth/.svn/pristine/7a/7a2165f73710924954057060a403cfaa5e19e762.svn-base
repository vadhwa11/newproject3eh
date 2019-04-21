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


import jkt.hrms.projectTracking.dataservice.*;


public class ProjectTrackingMasterHandlerServiceImpl implements ProjectTrackingMasterHandlerService {
	ProjectTrackingMasterDataService projectTrackingMasterDataService = null;

	public ProjectTrackingMasterDataService getProjectTrackingMasterDataService() {
		return projectTrackingMasterDataService;
	}

	public void setProjectTrackingMasterDataService(
			ProjectTrackingMasterDataService projectTrackingMasterDataService) {
		this.projectTrackingMasterDataService = projectTrackingMasterDataService;
	}
//------------------------------------------------------------------------------------
	
	public Map<String, Object> checkForExistingMasters(Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.checkForExistingMasters(generalMap);
	}

	
//-------------------------- Therapeutic Master----------------------------------
	
	public Map<String, Object> searchTherapeutic(String thpCode, String thpDesc) {
		return projectTrackingMasterDataService.searchTherapeutic(thpCode,thpDesc);
	}
	public Map<String, Object> showTherapeuticJsp() {
		return projectTrackingMasterDataService.showTherapeuticJsp();
	}
	public boolean addTherapeutic(MstrTherapeutic mstrTherapeutic) {
		return projectTrackingMasterDataService.addTherapeutic(mstrTherapeutic);
	}
	public boolean editTherapeuticToDatabase(Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.editTherapeuticToDatabase(generalMap);
	}
	public boolean deleteTherapeutic(int therapeuticId,Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.deleteTherapeutic(therapeuticId,generalMap);
	}
	
//-------------------------- Project Role Master   ----------------------------------
	
	public Map<String, Object> searchProjectRole(String prjCode, String prjName) {
		return projectTrackingMasterDataService.searchProjectRole(prjCode,prjName);
	}
	public Map<String, Object> showProjectRoleJsp() {
		return projectTrackingMasterDataService.showProjectRoleJsp();
	}
	public boolean addProjectRole(MstrProjectrole mstrProjectrole) {
		return projectTrackingMasterDataService.addProjectRole(mstrProjectrole);
	}
	public boolean editProjectRoleToDatabase(Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.editProjectRoleToDatabase(generalMap);
	}
	public boolean deleteProjectRole(int projectRoleId,Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.deleteProjectRole(projectRoleId,generalMap);
	}
//-------------------------- Project Type Master   ----------------------------------
	
	public Map<String, Object> searchProjectType(String prjTypeCode, String prjTypeName) {
		return projectTrackingMasterDataService.searchProjectType(prjTypeCode,prjTypeName);
	}
	public Map<String, Object> showProjectTypeJsp() {
		return projectTrackingMasterDataService.showProjectTypeJsp();
	}
	public boolean addProjectType(MstrProjecttype mstrProjectType) {
		return projectTrackingMasterDataService.addProjectType(mstrProjectType);
	}
	public boolean editProjectTypeToDatabase(Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.editProjectTypeToDatabase(generalMap);
	}
	public boolean deleteProjectType(int projectTypeId,Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.deleteProjectType(projectTypeId,generalMap);
	}

	
//-------------------------- Trial Phase Master   ----------------------------------
	
	public Map<String, Object> searchTrialPhase(String trialPhaseCode, String trialPhaseName) {
		return projectTrackingMasterDataService.searchTrialPhase(trialPhaseCode,trialPhaseName);
	}
	public Map<String, Object> showTrialPhaseJsp() {
		return projectTrackingMasterDataService.showTrialPhaseJsp();
	}
	public boolean addTrialPhase(MstrTrialphase mstrTrialphase) {
		return projectTrackingMasterDataService.addTrialPhase(mstrTrialphase);
	}
	public boolean editTrialPhaseToDatabase(Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.editTrialPhaseToDatabase(generalMap);
	}
	public boolean deleteTrialPhase(int trialPhaseId,Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.deleteTrialPhase(trialPhaseId,generalMap);
	}
	
//-------------------------- Sponser Type Master   ----------------------------------
	
	public Map<String, Object> searchSponserType(String sponserTypeCode, String sponserTypeName) {
		return projectTrackingMasterDataService.searchSponserType(sponserTypeCode,sponserTypeName);
	}
	public Map<String, Object> showSponserTypeJsp() {
		return projectTrackingMasterDataService.showSponserTypeJsp();
	}
	public boolean addSponserType(MstrSponsortype mstrSponsortype) {
		return projectTrackingMasterDataService.addSponserType(mstrSponsortype);
	}
	public boolean editSponserTypeToDatabase(Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.editSponserTypeToDatabase(generalMap);
	}
	public boolean deleteSponserType(int sponserTypeId,Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.deleteSponserType(sponserTypeId,generalMap);
	}
	
//-------------------------- Budget Sub-Heading Master   ----------------------------------
	
	public Map<String, Object> searchBudgetSubHeading(String budgetSubHeadingCode, String budgetSubHeadingName) {
		return projectTrackingMasterDataService.searchBudgetSubHeading(budgetSubHeadingCode,budgetSubHeadingName);
	}
	public Map<String, Object> showBudgetSubHeadingJsp() {
		return projectTrackingMasterDataService.showBudgetSubHeadingJsp();
	}
	public boolean addBudgetSubHeading(MstrBudgetSubhead mstrBudgetSubhead) {
		return projectTrackingMasterDataService.addBudgetSubHeading(mstrBudgetSubhead);
	}
	public boolean editBudgetSubHeadingToDatabase(Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.editBudgetSubHeadingToDatabase(generalMap);
	}
	public boolean deleteBudgetSubHeading(int budgetSubHeadingId,Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.deleteBudgetSubHeading(budgetSubHeadingId,generalMap);
	}
	
//-------------------------- Task Type Master   ----------------------------------
	
	public Map<String, Object> searchTaskType(String taskTypeCode, String taskTypeName) {
		return projectTrackingMasterDataService.searchTaskType(taskTypeCode,taskTypeName);
	}
	public Map<String, Object> showTaskTypeJsp() {
		return projectTrackingMasterDataService.showTaskTypeJsp();
	}
	public boolean addTaskType(MstrTaskType mstrTaskType) {
		return projectTrackingMasterDataService.addTaskType(mstrTaskType);
	}
	public boolean editTaskTypeToDatabase(Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.editTaskTypeToDatabase(generalMap);
	}
	public boolean deleteTaskType(int taskTypeId,Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.deleteTaskType(taskTypeId,generalMap);
	}
	
//----------------------------Task Master ------------------------------------------------
	public Map<String, Object> showTaskMasterJsp() {
		return projectTrackingMasterDataService.showTaskMasterJsp();
	}
	
	public Map<String, Object> searchTask(String taskCode, String taskName) {
		return projectTrackingMasterDataService.searchTask(taskCode,taskName);
	}
	public boolean addTask(MstrTask mstrTask) {
		return projectTrackingMasterDataService.addTask(mstrTask);
	}
	public boolean editTaskToDatabase(Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.editTaskToDatabase(generalMap);
	}
	public boolean deleteTask(int taskId,Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.deleteTask(taskId,generalMap);
	}
	
//-------------------------- Budget Type Master   ----------------------------------
	
	public Map<String, Object> searchBudgetType(String budgetTypeCode, String budgetTypeName) {
		return projectTrackingMasterDataService.searchBudgetType(budgetTypeCode,budgetTypeName);
	}
	public Map<String, Object> showBudgetTypeJsp() {
		return projectTrackingMasterDataService.showBudgetTypeJsp();
	}
	public boolean addBudgetType(MstrBudgetType mstrBudgetType) {
		return projectTrackingMasterDataService.addBudgetType(mstrBudgetType);
	}
	public boolean editBudgetTypeToDatabase(Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.editBudgetTypeToDatabase(generalMap);
	}
	public boolean deleteBudgetType(int budgetTypeId,Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.deleteBudgetType(budgetTypeId,generalMap);
	}
	
//-------------------------- Patient Visit Master   ----------------------------------
	
	public Map<String, Object> searchPatientVisit(String patientVisitCode, String patientVisitName) {
		return projectTrackingMasterDataService.searchPatientVisit(patientVisitCode,patientVisitName);
	}
	public Map<String, Object> showPatientVisitJsp() {
		return projectTrackingMasterDataService.showPatientVisitJsp();
	}
	public boolean addPatientVisit(MstrPtvisit mstrPtvisit) {
		return projectTrackingMasterDataService.addPatientVisit(mstrPtvisit);
	}
	public boolean editPatientVisitToDatabase(Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.editPatientVisitToDatabase(generalMap);
	}
	public boolean deletePatientVisit(int patientVisitId,Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.deletePatientVisit(patientVisitId,generalMap);
	}
	
//-------------------------- Document Type Master   ----------------------------------
	
	public Map<String, Object> searchDocumentType(String documentTypeCode, String documentTypeName) {
		return projectTrackingMasterDataService.searchDocumentType(documentTypeCode,documentTypeName);
	}
	public Map<String, Object> showDocumentTypeJsp() {
		return projectTrackingMasterDataService.showDocumentTypeJsp();
	}
	public boolean addDocumentType(MstrDoctype mstrDoctype) {
		return projectTrackingMasterDataService.addDocumentType(mstrDoctype);
	}
	public boolean editDocumentTypeToDatabase(Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.editDocumentTypeToDatabase(generalMap);
	}
	public boolean deleteDocumentType(int documentTypeId,Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.deleteDocumentType(documentTypeId,generalMap);
	}
	//----------------------------Document Master ------------------------------------------------
	public Map<String, Object> showDocumentJsp() {
		return projectTrackingMasterDataService.showDocumentJsp();
	}
	
	public Map<String, Object> searchDocument(String documentCode, String documentName) {
		return projectTrackingMasterDataService.searchDocument(documentCode,documentName);
	}
	public boolean addDocument(MstrDocument mstrDocument) {
		return projectTrackingMasterDataService.addDocument(mstrDocument);
	}
	public boolean editDocumentToDatabase(Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.editDocumentToDatabase(generalMap);
	}
	public boolean deleteDocument(int documentId,Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.deleteDocument(documentId,generalMap);
	}
	
	//----------------------------Rating Master ------------------------------------------------
	public Map<String, Object> showRatingJsp() {
		return projectTrackingMasterDataService.showRatingJsp();
	}
	
	public Map<String, Object> searchRating(String ratingCode, String ratingName) {
		return projectTrackingMasterDataService.searchRating(ratingCode,ratingName);
	}
	public boolean addRating(MstrRating mstrRating) {
		return projectTrackingMasterDataService.addRating(mstrRating);
	}
	public boolean editRatingToDatabase(Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.editRatingToDatabase(generalMap);
	}
	public boolean deleteRating(int ratingId,Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.deleteRating(ratingId,generalMap);
	}
	//----------------------------Department Task Map  ------------------------------------------------
	public Map<String, Object> showDeptTaskMapJsp() {
		return projectTrackingMasterDataService.showDeptTaskMapJsp();
	}
	
	public List getDeptTaskMapFromDB(List toBeassignedList)
	{
		return projectTrackingMasterDataService.getDeptTaskMapFromDB(toBeassignedList);
		
	}
	
	public Map<String, Object> showDeptTaskMapJsp(Integer deptId) 
	{
		return projectTrackingMasterDataService.showDeptTaskMapJsp(deptId);
	}
	public boolean saveDeptTaskMapDB(MstrDeptTaskMap deptTaskMap) {
		return projectTrackingMasterDataService.saveDeptTaskMapDB(deptTaskMap);
	}
	
	public List getDeptTaskMap(Map map)
	{
		return projectTrackingMasterDataService.getDeptTaskMap(map);
	}
	
	//----------------------------Department Task Map  ------------------------------------------------
	public Map<String, Object> showRoleDeptTaskMapJsp() {
		return projectTrackingMasterDataService.showRoleDeptTaskMapJsp();
	}
	
	public List getRoleDeptTaskMapFromDB(List toBeassignedList)
	{
		return projectTrackingMasterDataService.getRoleDeptTaskMapFromDB(toBeassignedList);
		
	}
	
	public Map<String, Object> showRoleDeptTaskMapJsp(Integer deptId, Integer rankId) 
	{
		return projectTrackingMasterDataService.showRoleDeptTaskMapJsp(deptId, rankId);
	}
	public boolean saveRoleDeptTaskMapDB(MstrRoleTaskMap roleTaskMap) {
		return projectTrackingMasterDataService.saveRoleDeptTaskMapDB(roleTaskMap);
	}
	
	public List getRoleDeptTaskMap(Map map)
	{
		return projectTrackingMasterDataService.getRoleDeptTaskMap(map);
	}
	
	//----------------------------Vendor Master ------------------------------------------------
	public Map<String, Object> showVendorJsp() {
		return projectTrackingMasterDataService.showVendorJsp();
	}
	
	public Map<String, Object> searchVendor(String vendorCode, String vendorName) {
		return projectTrackingMasterDataService.searchVendor(vendorCode, vendorName);
	}
	public boolean addVendor(MstrVendor mstrVendor) {
		return projectTrackingMasterDataService.addVendor(mstrVendor);
	}
	public boolean editVendorToDatabase(Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.editVendorToDatabase(generalMap);
	}
	public boolean deleteVendor(int vendorId,Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.deleteVendor(vendorId,generalMap);
	}
	
	//----------------------------Pi Master ------------------------------------------------
	public Map<String, Object> showPiJsp() {
		return projectTrackingMasterDataService.showPiJsp();
	}
	
	public Map<String, Object> searchPi(String piCode, String piName) {
		return projectTrackingMasterDataService.searchPi(piCode, piName);
	}
	public boolean addPi(Map<String, Object> newMap) {
		return projectTrackingMasterDataService.addPi(newMap);
	}
	public boolean editPiToDatabase(Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.editPiToDatabase(generalMap);
	}
	public boolean deletePi(int piId,Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.deletePi(piId,generalMap);
	}
	
	//----------------------------Site Master ------------------------------------------------
	public Map<String, Object> showSiteJsp() {
		return projectTrackingMasterDataService.showSiteJsp();
	}
	
	public Map<String, Object> searchSite(String siteCode, String siteName) {
		return projectTrackingMasterDataService.searchSite(siteCode, siteName);
	}
	public boolean addSite(Map<String, Object> newMap) {
		return projectTrackingMasterDataService.addSite(newMap);
	}
	public boolean editSiteToDatabase(Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.editSiteToDatabase(generalMap);
	}
	public boolean deleteSite(int siteId,Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.deleteSite(siteId,generalMap);
	}
	
//-------------------------- Calendar Master   ----------------------------------
	
	public Map<String, Object> searchCalendar(String calendarCode, String calendarName) {
		return projectTrackingMasterDataService.searchCalendar(calendarCode,calendarName);
	}
	public Map<String, Object> showCalendarJsp() {
		return projectTrackingMasterDataService.showCalendarJsp();
	}
	public boolean addCalendar(MstrCalendar mstrCalendar) {
		return projectTrackingMasterDataService.addCalendar(mstrCalendar);
	}
	public boolean editCalendarToDatabase(Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.editCalendarToDatabase(generalMap);
	}
	public boolean deleteCalendar(int calendarId,Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.deleteCalendar(calendarId,generalMap);
	}
	
//-------------------------- Project Status Master   ----------------------------------
	
	public Map<String, Object> searchProjectStatus(String projectStatusCode, String projectStatusName) {
		return projectTrackingMasterDataService.searchProjectStatus(projectStatusCode,projectStatusName);
	}
	public Map<String, Object> showProjectStatusJsp() {
		return projectTrackingMasterDataService.showProjectStatusJsp();
	}
	public boolean addProjectStatus(MstrProjectStatus mstrProjectStatus) {
		return projectTrackingMasterDataService.addProjectStatus(mstrProjectStatus);
	}
	public boolean editProjectStatusToDatabase(Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.editProjectStatusToDatabase(generalMap);
	}
	public boolean deleteProjectStatus(int projectStatusId,Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.deleteProjectStatus(projectStatusId,generalMap);
	}
	
//-------------------------- Project Status Master   ----------------------------------
	
	public Map<String, Object> searchVendorServiceType(String vendorServiceTypeCode, String vendorServiceTypeName) {
		return projectTrackingMasterDataService.searchVendorServiceType(vendorServiceTypeCode,vendorServiceTypeName);
	}
	public Map<String, Object> showVendorServiceTypeJsp() {
		return projectTrackingMasterDataService.showVendorServiceTypeJsp();
	}
	public boolean addVendorServiceType(VendorServiceType vendorServiceType) {
		return projectTrackingMasterDataService.addVendorServiceType(vendorServiceType);
	}
	public boolean editVendorServiceTypeToDatabase(Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.editVendorServiceTypeToDatabase(generalMap);
	}
	public boolean deleteVendorServiceType(int vendorServiceTypeId,Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.deleteVendorServiceType(vendorServiceTypeId,generalMap);
	}
	
//-------------------------- Sponser Master   ----------------------------------
	
	public Map<String, Object> searchSponsor(String sponsorCode, String sponsorName) {
		return projectTrackingMasterDataService.searchSponsor(sponsorCode,sponsorName);
	}
	public Map<String, Object> showSponsorJsp() {
		return projectTrackingMasterDataService.showSponsorJsp();
	}
	public boolean addSponsor(MstrSponsor mstrSponsor) {
		return projectTrackingMasterDataService.addSponsor(mstrSponsor);
	}
	public boolean editSponsorToDatabase(Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.editSponsorToDatabase(generalMap);
	}
	public boolean deleteSponsor(int sponsorId,Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.deleteSponsor(sponsorId,generalMap);
	}
	//=============================================================
	public Map<String, Object> showVisitTypeJsp() {
		return projectTrackingMasterDataService.showVisitTypeJsp();
	}
 	public boolean addVisitType(HrMasVisitType hrMasVisitType){
		return projectTrackingMasterDataService.addVisitType(hrMasVisitType);
	}
 	public Map<String, Object> searchVisitType(String visitTypeCode, String visitTypeName){
 		return projectTrackingMasterDataService.searchVisitType(visitTypeCode, visitTypeName);
 	}
 	public boolean editVisitTypeToDatabase(Map<String, Object> generalMap) {
 		return projectTrackingMasterDataService.editVisitTypeToDatabase(generalMap);
 	}
 	public boolean deleteVisitType(int visitTypeId,Map<String, Object> generalMap) {
 		return projectTrackingMasterDataService.deleteVisitType(visitTypeId, generalMap);
 	}
//-------------------------- Vitals Master   ----------------------------------
	
	public Map<String, Object> searchVitals(String vitalsCode, String vitalsName) {
		return projectTrackingMasterDataService.searchVitals(vitalsCode,vitalsName);
	}
	public Map<String, Object> showVitalsJsp() {
		return projectTrackingMasterDataService.showVitalsJsp();
	}
	public boolean addVitals(MstrVitals mstrVitals) {
		return projectTrackingMasterDataService.addVitals(mstrVitals);
	}
	public boolean editVitalsToDatabase(Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.editVitalsToDatabase(generalMap);
	}
	public boolean deleteVitals(int vitalsId,Map<String, Object> generalMap) {
		return projectTrackingMasterDataService.deleteVitals(vitalsId,generalMap);
	}
	
}