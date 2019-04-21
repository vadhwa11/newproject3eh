package jkt.hrms.applicant.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jkt.hrms.applicant.dataservice.ApplicantRegistrationDataService;
import jkt.hrms.masters.business.ApplicantEducation;
import jkt.hrms.masters.business.ApplicantExperience;
import jkt.hrms.masters.business.ApplicantPersonal;
import jkt.hrms.masters.business.ApplicantRefrenceDetails;
import jkt.hrms.masters.business.MasApplicant;

public class ApplicantRegistrationHandlerServiceImpl implements
		ApplicantRegistrationHandlerService {
	private ApplicantRegistrationDataService applicantRegistrationDataService;

	public void setApplicantRegistrationDataService(
			ApplicantRegistrationDataService applicantRegistrationDataService) {
		this.applicantRegistrationDataService = applicantRegistrationDataService;
	}

	public Map<String, Object> showApplicantRegistrationJsp(
			HttpServletRequest request) {
		return applicantRegistrationDataService
				.showApplicantRegistrationJsp(request);

	}

	public List<String> saveMasterDetails(Map<String, Object> dataContentMap) {

		return applicantRegistrationDataService
				.saveMasterDetails(dataContentMap);
	}

	public boolean savePersonalDetails(ApplicantPersonal applicantPersonal) {

		return applicantRegistrationDataService
				.savePersonalDetails(applicantPersonal);
	}

	public boolean saveEducationalDetails(ApplicantEducation applicantEducation) {

		return applicantRegistrationDataService
				.saveEducationalDetails(applicantEducation);
	}

	public boolean saveExperienceDetails(ApplicantExperience applicantExperience) {

		return applicantRegistrationDataService
				.saveExperienceDetails(applicantExperience);
	}

	public String getDepartmentCode(int departmentId) {
		// TODO Auto-generated method stub
		return applicantRegistrationDataService.getDepartmentCode(departmentId);
	}

	public String getJobCode(int jobId) {
		// TODO Auto-generated method stub
		return applicantRegistrationDataService.getJobCode(jobId);
	}

	public boolean updateEducationalDetails(
			ApplicantEducation applicantEducation) {
		return applicantRegistrationDataService
				.updateEducationalDetails(applicantEducation);
	}

	public boolean updateExperienceDetails(
			ApplicantExperience applicantExperience) {
		return applicantRegistrationDataService
				.updateExperienceDetails(applicantExperience);
	}

	public List<String> updateMasterDetails(Map<String, Object> dataContentMap) {
		return applicantRegistrationDataService
				.updateMasterDetails(dataContentMap);
	}

	public boolean updatePersonalDetails(ApplicantPersonal applicantPersonal) {
		return applicantRegistrationDataService
				.updatePersonalDetails(applicantPersonal);
	}

	public MasApplicant getMasterDetails(int id) {

		return applicantRegistrationDataService.getMasterDetails(id);
	}

	public ApplicantPersonal getPersonalDetails(int id) {
		// TODO Auto-generated method stub
		return applicantRegistrationDataService.getPersonalDetails(id);
	}

	public List getEducationalDetails(int id) {
		// TODO Auto-generated method stub
		return applicantRegistrationDataService.getEducationalDetails(id);
	}

	public ApplicantExperience getApplicantExperience(int id) {
		return applicantRegistrationDataService.getApplicantExperience(id);
	}

	public List<ApplicantRefrenceDetails> getApplicantRefrenceDetailsList(int id) {
		// TODO Auto-generated method stub
		return applicantRegistrationDataService
				.getApplicantRefrenceDetailsList(id);
	}
}
