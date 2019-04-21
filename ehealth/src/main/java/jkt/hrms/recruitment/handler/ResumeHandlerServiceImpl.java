package jkt.hrms.recruitment.handler;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.exception.DataServiceException;
import jkt.hms.exception.HandlerServiceException;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.Users;
import jkt.hrms.masters.business.MasQualification;
import jkt.hrms.recruitment.dataservice.ResumeDataService;
import jkt.hrms.recruitment.masters.business.HrResumePayElements;
import jkt.hrms.recruitment.masters.business.Resumehrdetails;
import jkt.hrms.recruitment.masters.business.Resumehrdetailshistory;
import jkt.hrms.recruitment.masters.business.Resumejobprofile;
import jkt.hrms.recruitment.masters.business.Resumepersonaldetails;
import jkt.hrms.recruitment.masters.business.Resumestatus;
import jkt.hrms.recruitment.masters.business.Resumestatushistory;
import jkt.hrms.recruitment.masters.business.Resumetechnical;
import jkt.hrms.recruitment.masters.business.Resumetechnicalhistory;

public class ResumeHandlerServiceImpl implements ResumeHandlerService {

	private ResumeDataService resumeDataService;

	public Connection getDBConnection() {
		return resumeDataService.getDBConnection();
	}

	public Object getBinaryFile() {
		return resumeDataService.getBinaryFile();
	}

	public ResumeDataService getResumeDataService() {
		return resumeDataService;
	}

	public void setResumeDataService(ResumeDataService resumeDataService) {
		this.resumeDataService = resumeDataService;
	}

	public List getSkillMasterList() {

		List skillMaster = resumeDataService.getSkillMasterList();
		return skillMaster;
	}

	public List getDuList() {
		List duList = resumeDataService.getDuList();
		return duList;
	}

	public List getProjectDetails() {
		List projectDetails = resumeDataService.getProjectDetails();
		return projectDetails;
	}

	public List<Resumejobprofile> getJobProfiles() {
		List jobProfiles = resumeDataService.getJobProfiles();
		return jobProfiles;
	}

	public Map<String, Object> checkResumeUniqueness(
			Map<String, Object> verificationMap) {
		return (resumeDataService.checkResumeUniqueness(verificationMap));
	}

	public int getLastResumeId() {
		int resumeId = resumeDataService.getLastResumeId();
		return resumeId;
	}

	public Map addResume(Map addResumeDetails) {

		return resumeDataService.addResume(addResumeDetails);

	}

	public List getStatusMasterList() {
		List StatusMasterList = resumeDataService.getStatusMasterList();
		return StatusMasterList;
	}

	public List<String> getProject() {
		List<String> projectList = resumeDataService.getProject();
		return projectList;
	}

	public Map app(Users user) throws HandlerServiceException {
		Map applicationMap = new HashMap();
		List listOfAppName = new ArrayList();
		try {
			applicationMap = resumeDataService.appId(user);
		} catch (DataServiceException e) {
			throw new HandlerServiceException(e.toString());
		}
		return applicationMap;
	}

	public Map searchResume(Map searchCriteriaMap) {
		Map map = new HashMap();
		map = resumeDataService.searchResume(searchCriteriaMap);
		return map;
	}

	public List getRmsUsersList(String roleId) {
		List rmsUsersList = resumeDataService.getRmsUsersList(roleId);
		return rmsUsersList;
	}

	public List getRecruitersList() {
		List recruitersList = resumeDataService.getRecruitersList();
		return recruitersList;
	}

	public Map getdetailsOfResume(int resumeid, String uploadUrl) {

		Map detailsOfResume = resumeDataService.getdetailsOfResume(resumeid,
				uploadUrl);
		return detailsOfResume;
	}

	public Map updateAuthorizationTo(Map authorizationMap) {
		Map updateAuthorizationMap = resumeDataService
				.updateAuthorizationTo(authorizationMap);
		return updateAuthorizationMap;
	}

	public List<Object> getTechnicalHistory(int resumeId) {
		List technicalDetails = resumeDataService.getTechnicalDetails(resumeId);
		return technicalDetails;
	}

	public List getCurrentStatus(int resumeId) {
		List resumeStatus = resumeDataService.getCurrentStatus(resumeId);
		return resumeStatus;
	}

	public boolean addTechDetails(Resumetechnical resumeTechnical,
			Resumetechnicalhistory resumeTechnicalHistory) {
		boolean addTechDetails = resumeDataService.addTechDetails(
				resumeTechnical, resumeTechnicalHistory);
		return addTechDetails;
	}

	public List getHrDetails(int resumeId) {
		List hrDetails = resumeDataService.getHrDetails(resumeId);
		return hrDetails;

	}

	public boolean addHRDetails(Resumehrdetails resumeHrDetails,
			Resumehrdetailshistory resumeHrDetailsHistory) {
		boolean addHRDetails = resumeDataService.addHRDetails(resumeHrDetails,
				resumeHrDetailsHistory);
		return addHRDetails;
	}

	public List getMasterList(String className) {
		List masterList = resumeDataService.getMasterList(className);
		return masterList;
	}

	public int getStatusId(String statusDesc) {
		int statusId = resumeDataService.getStatusId(statusDesc);
		return statusId;
	}

	public boolean addResumeStatus(Resumestatus resumeStatus,
			Resumestatushistory resumeStatusHistory) {
		boolean addResumeStatus = resumeDataService.addResumeStatus(
				resumeStatus, resumeStatusHistory);
		return addResumeStatus;
	}

	public Map editResume(Map editResumeDetails) {

		return resumeDataService.editResume(editResumeDetails);
	}

	public List getResumePersonalDetailsById(Integer id) {
		return resumeDataService.getResumePersonalDetailsById(id);
	}

	public List<Object> getHRHistory(int resumeId) {
		List hrDetails = resumeDataService.getHRHistory(resumeId);
		return hrDetails;
	}

	public List<Object> getStatusHistory(int resumeId) {
		List statusDetails = resumeDataService.getStatusHistory(resumeId);
		return statusDetails;
	}

	public List getStateList(String countryId) {
		List stateList = resumeDataService.getStateList(countryId);
		return stateList;
	}

	public List getDistrictList(String stateId) {
		List stateList = resumeDataService.getDistrictList(stateId);
		return stateList;
	}

	public List getJoinedCandidates() {
		return resumeDataService.getJoinedCandidates();
	}

	public List getCountryList() {
		return resumeDataService.getCountryList();
	}

	public List getHrSelectedResumeList() {
		return resumeDataService.getHrSelectedResumeList();
	}

	public void updateResumeStatus(Resumestatus resumeListToBeUpdated) {
		resumeDataService.updateResumeStatus(resumeListToBeUpdated);
	}

	public Map getAddressMap() {
		return resumeDataService.getAddressMap();
	}

	public Resumetechnical getResumeTechnical(Integer resumeTechnicalId) {
		return resumeDataService.getResumeTechnical(resumeTechnicalId);
	}

	public Resumehrdetails getResumeHr(Integer resumeHrId) {
		return resumeDataService.getResumeHr(resumeHrId);
	}

	public List<Resumepersonaldetails> getUploadedResumes() {
		return resumeDataService.getUploadedResumes();
	}

	public List getStatusMasterListForFinalStatus() {
		return resumeDataService.getStatusMasterListForFinalStatus();
	}

	public List getMasterListWithoutStatus(Class klass) {
		return resumeDataService.getMasterListWithoutStatus(klass);
	}

	public List<MasQualification> getQualificationMasterList() {
		return resumeDataService.getQualificationMasterList();
	}

	public List getMasterList(Class klass) {
		return resumeDataService.getMasterList(klass);
	}

	public Map<String, Object> showResumePayElementsJsp(
			Resumepersonaldetails resume) {
		return resumeDataService.showResumePayElementsJsp(resume);
	}

	public Map addResumePayELementsList(
			List<HrResumePayElements> resumePayELementsList) {
		return resumeDataService
				.addResumePayELementsList(resumePayELementsList);
	}

	public Object loadObject(Class klass, Integer id) {
		return resumeDataService.loadObject(klass, id);
	}

	public void addOrUpdate(Object entity) {
		resumeDataService.addOrUpdate(entity);
	}

	public List<MasDepartment> getDepartmentList() {

		return resumeDataService.getDepartmentList();
	}

	@Override
	public Map<String, Object> getEmployeeForPromo(String id) {
		// TODO Auto-generated method stub
		return resumeDataService.getEmployeeForPromo(id);
	}

	@Override
	public Map saveEmpPromo(Map<String, Object> authorizationMap) {
		return resumeDataService.saveEmpPromo(authorizationMap);
	}

	@Override
	public Map<String, Object> saveResourceRequisitionDetail(Map<String, Object> detailMap) {
			
		return resumeDataService.saveResourceRequisitionDetail(detailMap);
	}

	@Override
	public Map<String, Object> getEmployeeForHrApprovePromo(
			Map<String, Object> detailMap) {
		
		return resumeDataService.getEmployeeForHrApprovePromo(detailMap) ;
	}

	@Override
	public Map updateEmpPromoStatus(Map<String, Object> detailMap) {
		// TODO Auto-generated method stub
		return resumeDataService.updateEmpPromoStatus(detailMap);
	}
}
