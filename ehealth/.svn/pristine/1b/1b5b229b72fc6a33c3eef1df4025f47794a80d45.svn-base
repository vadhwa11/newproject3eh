package jkt.hrms.masters.handler;

import java.util.Map;

import jkt.hrms.masters.business.HrMasCourse;
import jkt.hrms.masters.business.HrMasQualification;
import jkt.hrms.masters.business.HrMasSpecialQualification;
import jkt.hrms.masters.dataservice.EducationDataService;

public class EducationHandlerServiceImpl implements EducationHandlerService {

	EducationDataService educationDataService = null;

	public EducationDataService getEducationDataService() {
		return educationDataService;
	}

	public void setEducationDataService(
			EducationDataService educationDataService) {
		this.educationDataService = educationDataService;
	}

	// *************************** Start of Course Master By Rajendra
	// **************************************************************//
	public Map<String, Object> showCourseMasterJsp() {
		return educationDataService.showCourseMasterJsp();
	}

	public Map<String, Object> searchCourseMaster(String courseCode,
			String courseName) {
		return educationDataService.searchCourseMaster(courseCode, courseName);

	}

	public boolean addCourseMaster(HrMasCourse hrMasCourse) {
		return educationDataService.addCourseMaster(hrMasCourse);
	}

	public boolean editCourseMaster(Map<String, Object> map) {
		return educationDataService.editCourseMaster(map);
	}

	public boolean deleteCourseMaster(int courseId,
			Map<String, Object> generalMap) {
		return educationDataService.deleteCourseMaster(courseId, generalMap);
	}

	// *************************** End of Course Master
	// **************************************************************//

	// *************************** Start of Qualification Master By Rajendra
	// **************************************************************//

	public Map<String, Object> showQualificationMasterJsp() {
		return educationDataService.showQualificationMasterJsp();
	}

	public boolean addQualificationMaster(HrMasQualification hrMasQualification) {
		return educationDataService.addQualificationMaster(hrMasQualification);
	}

	public Map<String, Object> searchQualificationMaster(
			String qualificationCode, String qualificationName) {
		return educationDataService.searchQualificationMaster(
				qualificationCode, qualificationName);
	}

	public boolean editQualificationMaster(Map<String, Object> generalMap) {
		return educationDataService.editQualificationMaster(generalMap);
	}

	public boolean deleteQualificationMaster(int qualificationId,
			Map<String, Object> generalMap) {
		return educationDataService.deleteQualificationMaster(qualificationId,
				generalMap);
	}

	// *************************** End of Qualification Master
	// **************************************************************//

	// *************************** Start of Special Qualification Master By
	// Rajendra **************************************************************//

	public Map<String, Object> showSpecialQualificationMasterJsp() {
		return educationDataService.showSpecialQualificationMasterJsp();
	}

	public boolean addSpecialQualificationMaster(
			HrMasSpecialQualification hrMasSpecialQualification) {
		return educationDataService
				.addSpecialQualificationMaster(hrMasSpecialQualification);
	}

	public Map<String, Object> searchSpecialQualificationMaster(
			String specialQualificationCode, String specialQualificationName) {
		return educationDataService.searchSpecialQualificationMaster(
				specialQualificationCode, specialQualificationName);
	}

	public boolean editSpecialQualificationMaster(Map<String, Object> generalMap) {
		return educationDataService.editSpecialQualificationMaster(generalMap);
	}

	public boolean deleteSpecialQualificationMaster(int specialQualificationId,
			Map<String, Object> generalMap) {
		return educationDataService.deleteSpecialQlualificationMaster(
				specialQualificationId, generalMap);
	}

}
