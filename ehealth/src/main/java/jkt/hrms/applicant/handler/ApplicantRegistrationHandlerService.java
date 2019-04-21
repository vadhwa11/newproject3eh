package jkt.hrms.applicant.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jkt.hrms.masters.business.ApplicantEducation;
import jkt.hrms.masters.business.ApplicantExperience;
import jkt.hrms.masters.business.ApplicantPersonal;
import jkt.hrms.masters.business.ApplicantRefrenceDetails;
import jkt.hrms.masters.business.MasApplicant;

public interface ApplicantRegistrationHandlerService {
	public Map<String, Object> showApplicantRegistrationJsp(
			HttpServletRequest request);

	public List<String> saveMasterDetails(Map<String, Object> dataContentMap);

	public boolean saveEducationalDetails(ApplicantEducation applicantEducation);

	public boolean saveExperienceDetails(ApplicantExperience applicantExperience);

	public boolean savePersonalDetails(ApplicantPersonal applicantPersonal);

	public String getDepartmentCode(int departmentId);

	public String getJobCode(int jobId);

	public List<String> updateMasterDetails(Map<String, Object> dataContentMap);

	public boolean updateEducationalDetails(
			ApplicantEducation applicantEducation);

	public boolean updateExperienceDetails(
			ApplicantExperience applicantExperience);

	public boolean updatePersonalDetails(ApplicantPersonal applicantPersonal);

	public MasApplicant getMasterDetails(int id);

	public ApplicantPersonal getPersonalDetails(int id);

	public List getEducationalDetails(int id);

	public ApplicantExperience getApplicantExperience(int id);

	public List<ApplicantRefrenceDetails> getApplicantRefrenceDetailsList(int id);
}
