package jkt.hrms.recruitment.dataservice;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import jkt.hms.exception.DataServiceException;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.Users;
import jkt.hrms.masters.business.MasQualification;
import jkt.hrms.recruitment.masters.business.HrResumePayElements;
import jkt.hrms.recruitment.masters.business.Resumehrdetails;
import jkt.hrms.recruitment.masters.business.Resumehrdetailshistory;
import jkt.hrms.recruitment.masters.business.Resumejobprofile;
import jkt.hrms.recruitment.masters.business.Resumepersonaldetails;
import jkt.hrms.recruitment.masters.business.Resumestatus;
import jkt.hrms.recruitment.masters.business.Resumestatushistory;
import jkt.hrms.recruitment.masters.business.Resumetechnical;
import jkt.hrms.recruitment.masters.business.Resumetechnicalhistory;

public interface ResumeDataService {
	Connection getDBConnection();

	List getSkillMasterList();

	List getDuList();

	List getProjectDetails();

	List<Resumejobprofile> getJobProfiles();

	Map<String, Object> checkResumeUniqueness(
			Map<String, Object> verificationMap);

	List getStatusMasterList();

	int getLastResumeId();

	Map<String, Object> addResume(Map<String, Object> addResumeDetails);

	List<String> getProject();

	Map appId(Users user) throws DataServiceException;

	Map<String, Object> searchResume(Map searchCriteriaMap);

	List getRmsUsersList(String roleId);

	List getRecruitersList();

	Map getdetailsOfResume(int resumeid, String uploadUrl);

	Map updateAuthorizationTo(Map<String, Object> authorizationMap);

	List getTechnicalDetails(int resumeId);

	List getCurrentStatus(int resumeId);

	boolean addTechDetails(Resumetechnical resumeTechnical,
			Resumetechnicalhistory resumeTechnicalHistory);

	List getHrDetails(int resumeId);

	boolean addHRDetails(Resumehrdetails resumeHrDetails,
			Resumehrdetailshistory resumeHrDetailsHistory);

	int getStatusId(String statusDesc);

	boolean addResumeStatus(Resumestatus resumeStatus,
			Resumestatushistory resumeStatusHistory);

	List getMasterList(String className);

	Map<String, Object> editResume(Map<String, Object> editResumeDetails);

	List getResumePersonalDetailsById(Integer id);

	List getHRHistory(int resumeId);

	List getStatusHistory(int resumeId);

	List getStateList(String stateName);

	List getDistrictList(String stateId);

	List getJoinedCandidates();

	List getCountryList();

	Object getBinaryFile();

	List getHrSelectedResumeList();

	void updateResumeStatus(Resumestatus resumeListToBeUpdated);

	public Map getAddressMap();

	Resumetechnical getResumeTechnical(Integer resumeTechnicalId);

	Resumehrdetails getResumeHr(Integer resumeHrId);

	List<Resumepersonaldetails> getUploadedResumes();

	List getStatusMasterListForFinalStatus();

	List<MasQualification> getQualificationMasterList();

	List getMasterList(Class klass);

	List getMasterListWithoutStatus(Class klass);

	Map<String, Object> showResumePayElementsJsp(Resumepersonaldetails resume);

	Map addResumePayELementsList(List<HrResumePayElements> resumePayELementsList);

	Object loadObject(Class klass, Integer id);

	void addOrUpdate(Object entity);

	List<MasDepartment> getDepartmentList();

	Map<String, Object> getEmployeeForPromo(String id);

	Map saveEmpPromo(Map<String, Object> authorizationMap);

	Map<String, Object> saveResourceRequisitionDetail(Map<String, Object> detailMap);

	Map<String, Object> getEmployeeForHrApprovePromo(
			Map<String, Object> detailMap);

	Map updateEmpPromoStatus(Map<String, Object> detailMap);
			
}
