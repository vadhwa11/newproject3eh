package jkt.hrms.recruitment.handler;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import jkt.hms.exception.HandlerServiceException;
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

public interface ResumeHandlerService {
	Connection getDBConnection();

	List getSkillMasterList();

	List getDuList();

	List getProjectDetails();

	List<Resumejobprofile> getJobProfiles();

	Map<String, Object> checkResumeUniqueness(
			Map<String, Object> verificationMap);

	int getLastResumeId();

	Map addResume(Map addResumeDetails);

	List getStatusMasterList();

	List<String> getProject();

	Map app(Users user) throws HandlerServiceException;

	Map searchResume(Map searchCriteriaMap);

	List getRmsUsersList(String roleId);

	List getRecruitersList();

	Map getdetailsOfResume(int resumeid, String uploadUrl);

	Map updateAuthorizationTo(Map authorizationMap);

	List<Object> getTechnicalHistory(int resumeId);

	List getCurrentStatus(int resumeId);

	boolean addTechDetails(Resumetechnical resumeTechnical,
			Resumetechnicalhistory resumeTechnicalHistory);

	List getHrDetails(int resumeId);

	boolean addHRDetails(Resumehrdetails resumeHrDetails,
			Resumehrdetailshistory resumeHrDetailsHistory);

	List getMasterList(String className);

	int getStatusId(String statusDesc);

	boolean addResumeStatus(Resumestatus resumeStatus,
			Resumestatushistory resumeStatusHistory);

	Map editResume(Map editResumeDetails);

	List getResumePersonalDetailsById(Integer id);

	List<Object> getHRHistory(int resumeId);

	List<Object> getStatusHistory(int resumeId);

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

	Map<String, Object> saveResourceRequisitionDetail(
			Map<String, Object> detailMap);

	Map<String, Object> getEmployeeForHrApprovePromo(
			Map<String, Object> detailMap);

	Map updateEmpPromoStatus(Map<String, Object> detailMap);
}
