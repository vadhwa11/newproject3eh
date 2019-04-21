package jkt.hrms.projectTracking.handler;

import java.util.Map;
import java.sql.Connection;

import jkt.hms.masters.business.Users;
import jkt.hrms.masters.business.CntrReqPat;
import jkt.hrms.masters.business.PrjAnsEntry;
import jkt.hrms.masters.business.PrjOthervitals;
import jkt.hrms.masters.business.PrjPatvisitsch;
import jkt.hrms.masters.business.PrjQueryEntry;
import jkt.hrms.masters.business.PrjQueryFlwEntry;
import jkt.hrms.masters.business.PrjReglSub;
import jkt.hrms.masters.business.PrjSiteOthervitals;
import jkt.hrms.masters.business.PrjVendorcontract;
import jkt.hrms.masters.business.ProjectVitals;

public interface ProjectTrackingHandlerService {

	Map<String, Object> saveProjectCreation(Map<String, Object> generalMap);

	Map<String, Object> showProjectCreationJsp();

	Map<String, Object> showSitePaymentScheduleJsp(int projectId);

	Map<String, Object> showProjectVitalsJsp();
	
	Map<String, Object> saveSitePaymentSchedule(Map<String, Object> generalMap);

	Map<String, Object> showRoleWiseResourceReuiredJsp(int projectId);

	Map<String, Object> saveRoleWiseResourceRequired(
			Map<String, Object> generalMap);

	Map<String, Object> updateProjectCreation(Map<String, Object> generalMap);

	Map<String, Object> searchProjectCreation(Map<String, Object> generalMap);

	Map<String, Object> updateSitePaymentSchedule(Map<String, Object> generalMap);

	Map<String, Object> updateRoleWiseResourceRequired(Map<String, Object> generalMap);

	Map<String, Object> showProjectCalendarJsp(int projectId);
	
	Map<String, Object> saveProjectCalendar(Map<String, Object> generalMap);
	
	Map<String, Object> updateProjectCalendar(Map<String, Object> generalMap);
	
	Map<String, Object> showRoleResourceMappingJsp(int projectId);
	
	Map<String, Object> getExistingProjectListForAjax();

	Map<String, Object> showBudgetSettingJsp(int projectId);

	Map<String, Object> saveBudgetSetting(Map<String, Object> generalMap);
	
	Map<String, Object> updateBudgetSetting(Map<String, Object> generalMap);
	
	Map<String, Object> saveRoleResourceMapping(Map<String, Object> generalMap);
	
	Map<String, Object> updateRoleResourceMapping(Map<String, Object> generalMap);
	
	Map<String, Object> showTaskSettingForProjectRole(Map<String, Object> generalMap);
	
	Map<String, Object> saveAssignTaskToRoleResourceHeader(Map<String, Object> generalMap);
	
	Map<String, Object> saveTaskInRoleResourceMappingDetail(Map<String, Object> generalMap);
	
	Map<String, Object> updateTaskInRoleResourceMappingDetail(Map<String, Object> generalMap);
	
	Map<String, Object> showFeasibilityStudyJsp(int projectId);
	
	Map<String, Object> saveSelectedDoctors(Map<String, Object> generalMap);
	
	Map<String, Object> getCallPiDetailForAjax(Map<String, Object> generalMap);
	
	Map<String, Object> saveDoctorsCallDetail(Map<String, Object> generalMap);
	
	Map<String, Object> addSiteDetailForPi(Map<String, Object> generalMap);
	
	Map<String, Object> saveAssignSiteDetails(Map<String, Object> generalMap);
	
	Map<String, Object> updateSelectedPi(Map<String, Object> generalMap);
	
	Map<String, Object> showSqVisitUpdateJsp(int projectId);
	
	Map<String, Object> saveSQVisitUpdateDetails(Map<String, Object> generalMap);
	
	Map<String, Object> updateSQVisitUpdateDetails(Map<String, Object> generalMap);
	
	Map<String, Object> showRequlatoryMenuJsp();
	
	Map<String, Object> showSiteSettingJsp();
	
	Map<String, Object> showProjectSitesList(int projectId);
	
	Map<String, Object> showSiteVitalsJsp(int projectId, int siteId);
	
	Map<String, Object> saveSiteVitals(Map<String, Object> generalMap);
	
	Map<String, Object> updateSiteVitals(Map<String, Object> generalMap);
	
	Map<String, Object> showSiteResourceMappingJsp(int projectId, int siteId);
	
	Map<String, Object> getResourceListFromAjax(Map<String, Object> generalMap);
	
	Map<String, Object> saveSiteResourceMapping(Map<String, Object> generalMap);
	
	Map<String, Object> showApprovalSettingJsp();
	
	Map<String, Object> showProjectApproval(int projectId);
	
	Map<String, Object> showProjectTrackingMenuJsp(Users users);

	Map<String, Object> showAddPatient(int projectId, int siteId);
	
	Map<String, Object> saveAddPatientDetails(Map<String, Object> generalMap);
	
	Map<String, Object> showPatientSchedule(Map<String, Object> generalMap);
	
	Map<String, Object> showSitesListForProjectTracking(Map<String, Object> generalMap);

	Map<String, Object> updateAddPatientSchedule(Map<String, Object> generalMap);
	
	Map<String, Object> ModifyPatientSchedule(Map<String, Object> generalMap);
	
	Map<String, Object> saveModifyPatientSchedule(Map<String, Object> generalMap);
	
	Map<String, Object> updateModifyPatientScheduleByPL(Map<String, Object> generalMap);
//---------------------------------------------Code By  Rajendra--------------------------------------------	

	Map<String, Object> showCountryWisePatientJsp(int projectId);
	boolean addPatientRequired(CntrReqPat cntrReqPat);
	boolean editPatientRequired(Map<String, Object> generalMap);
	boolean deletePatientRequired(Map<String, Object> generalMap);
	Map<String, Object> showOtherVitalsJsp(int projectId);
    boolean addOtherVitals(PrjOthervitals prjOthervitals);
    boolean editOtherVitals(Map<String, Object> generalMap);
    boolean deleteOtherVitals(Map<String, Object> generalMap);
    Map<String, Object> showPatientVisitScheduleJsp(int projectId);
    boolean addPatientVisitSchedule(PrjPatvisitsch prjPatvisitsch);
    boolean editPatientVisitSchedule(Map<String, Object> generalMap);
    boolean deletePatientVisitSchedule(Map<String, Object> generalMap);
    Map<String, Object> showVendorContractJsp(int projectId);
    boolean addVendorContract(PrjVendorcontract prjVendorcontract);
    boolean editVendorContract(Map<String, Object> generalMap);
    boolean deleteVendorContract(Map<String, Object> generalMap);
    Map<String, Object> showAddProjectVitals(int projectId);
    boolean addProjectVital(ProjectVitals projectVitals);
    boolean editProjectVital(Map<String, Object> generalMap);
    boolean deleteProjectVital(Map<String, Object> generalMap);

	Map<String, Object> showRegulatorSubmissionJsp(int projectId);

	Map<String, Object> displayAttachment(int regulatorySubId);

	Map<String, Object> AttachReglSubDocFile(Map<String, Object> generalMap);

	Map<String, Object> deleteAttachReglSubDocFile(Map<String, Object> generalMap);

	boolean addRegulatorySubmission(PrjReglSub prjreglSub);

	boolean editRegulatorySubmission(Map<String, Object> generalMap);

	

	

	

 /********************************* Methods Start For Query Entry JSP  **************************************/
	Map<String, Object> showQueryEntryJsp(int projectId);
    Map<String, Object> displayQueryEntryAttachment(int queryEntryId);
    boolean addQueryEntry(PrjQueryEntry prjQueryEntry);
    boolean editQueryEntry(Map<String, Object> generalMap);
    Map<String, Object> attachQueryEntryDocFile(Map<String, Object> generalMap);
    Map<String, Object> deleteAttachQueryEntryDocFile(Map<String, Object> generalMap);
    
  
  /********************************** Methods Start For Ans Entry JSP  ******************************************/
    Map<String, Object> showAnsEntryJsp(int projectId);
	Map<String, Object> displayAnsEntryAttachment(int ansEntryId);
	boolean addAnsEntry(PrjAnsEntry prjAnsEntry);
	boolean editAnsEntry(Map<String, Object> generalMap);
	Map<String, Object> attachAnsEntryDocFile(Map<String, Object> generalMap);
	Map<String, Object> deleteAttachAnsEntryDocFile(Map<String, Object> generalMap);
	
/********************************** Methods Start For Query Flw Entry JSP  ******************************************/
	Map<String, Object> showQueryFlwEntryJsp(int projectId);
	Map<String, Object> displayQueryFlwEntryAttachment(int queryFlwEntryId);
	boolean addQueryFlwEntry(PrjQueryFlwEntry prjQueryFlwEntry);
	boolean editQueryFlwEntry(Map<String, Object> generalMap);
	Map<String, Object> attachQueryFlwEntryDocFile(Map<String, Object> generalMap);
	Map<String, Object> deleteAttachQueryFlwEntryDocFile(Map<String, Object> generalMap);

	
/********************************** Methods Start For SQ Approval Status JSP  ******************************************/
	Map<String, Object> showSQApprovalStatus(int projectId);
	boolean updateSQApprovalStatus(Map<String, Object> generalMap);

	boolean updateQAApprovalStatus(Map<String, Object> generalMap);
	Map<String, Object> showQAApprovalStatus(int projectId);

	Map<String, Object> searchVisitDetails(Map<String, Object> mapForDs);
	
	/*   Site Calendar Code Start By Naresh   */
	public Map<String, Object> showSiteCalendarJsp(int projectId, int siteId) ;
	
	Map<String, Object> saveSiteCalendar(Map<String, Object> generalMap) ;
	
	Map<String, Object> updateSiteCalendar(Map<String, Object> generalMap) ;
	
	Map<String, Object> deleteSiteCalendar(int siteCalendarId,Map<String, Object> generalMap) ;
	/*   Site Calendar Code End By Naresh   */
	

	
	//======================================By vishal
	//-----------------------------------Site Other Vitals-----------------------------------------
	Map<String, Object> showSiteOtherVitalsJsp(int projectId, int siteId);
	boolean addSiteOtherVitals(PrjSiteOthervitals prjSiteOthervitals);
	boolean editSiteOtherVitals(Map<String, Object> generalMap);
	
	//--------------------Site Miles Stone------------------------------------------
	Map<String, Object> showSiteMilesStoneJsp(int projectId, int siteId);
	Map<String, Object> addSiteMilesStone(Map<String, Object> generalMap);
	Map<String, Object> editSiteMileStone(Map<String, Object> generalMap);

	
	//--------------------DCF Entry------------------------------------------
//	Map<String, Object> showDCFEntryJsp(Map<String, Object> generalMap);
//	Map<String, Object> searchSiteForProject(Map<String, Object> generalMap);
	Map<String, Object> searchPatientForSite(Map<String, Object> generalMap);
	Map<String, Object> saveDCFEntry(Map<String, Object> map);
	Map<String, Object> showDCFViewJsp(Map<String, Object> generalMap);
	public Connection getDBConnection();
	
	public Map<String, Object> approveProject(Map<String, Object> generalMap) ;

	Map<String, Object> displaySqVisitUpdateAttachment(Map<String, Object> generalMap);

	Map<String, Object> addSqVisitUpdateFile(Map<String, Object> generalMap);

	Map<String, Object> viewSqApprovalDocument(Map<String, Object> generalMap);

	Map<String, Object> viewQaApprovalDocument(Map<String, Object> generalMap);

	Map<String, Object> showScheduleSettingJsp(Map<String, Object> generalMap);

	Map<String, Object> createSchedule(Map<String, Object> generalMap);

	Map<String, Object> editScheduleDetails(Map<String, Object> generalMap);

	Map<String, Object> attachScheduleDocument(Map<String, Object> generalMap);

	Map<String, Object> addCreateScheduleFile(Map<String, Object> generalMap);

	Map<String, Object> viewCreateScheduleDocument(Map<String, Object> generalMap);

	Map<String, Object> updateScheduleSettingJsp(Map<String, Object> generalMap);

	Map<String, Object> saveUpdateSchedule(Map<String, Object> generalMap);

	Map<String, Object> updateScheduleDetails(Map<String, Object> generalMap);
}
