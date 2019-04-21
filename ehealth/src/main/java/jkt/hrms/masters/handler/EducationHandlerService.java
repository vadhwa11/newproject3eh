package jkt.hrms.masters.handler;

import java.util.Map;

import jkt.hrms.masters.business.HrMasCourse;
import jkt.hrms.masters.business.HrMasQualification;
import jkt.hrms.masters.business.HrMasSpecialQualification;

public interface EducationHandlerService {

	// ****************************************** Start Of Course Master by
	// Rajendra ****************************//
	Map<String, Object> showCourseMasterJsp();

	Map<String, Object> searchCourseMaster(String courseCode, String courseName);

	boolean addCourseMaster(HrMasCourse hrMasCourse);

	boolean editCourseMaster(Map<String, Object> map);

	boolean deleteCourseMaster(int courseId, Map<String, Object> generalMap);

	// ****************************************** End Of Course Master by
	// Rajendra ****************************//

	// ****************************************** Start Of Qualification Master
	// by Rajendra ****************************//
	Map<String, Object> showQualificationMasterJsp();

	boolean addQualificationMaster(HrMasQualification hrMasQualification);

	Map<String, Object> searchQualificationMaster(String qualificationCode,
			String qualificationName);

	boolean editQualificationMaster(Map<String, Object> generalMap);

	boolean deleteQualificationMaster(int qualificationId,
			Map<String, Object> generalMap);

	// ****************************************** End Of Qualification Master by
	// Rajendra ****************************//

	// ****************************************** Start Of Special Qualification
	// Master by Rajendra ****************************//
	Map<String, Object> showSpecialQualificationMasterJsp();

	boolean addSpecialQualificationMaster(
			HrMasSpecialQualification hrMasSpecialQualification);

	Map<String, Object> searchSpecialQualificationMaster(
			String specialQualificationCode, String specialQualificationName);

	boolean editSpecialQualificationMaster(Map<String, Object> generalMap);

	boolean deleteSpecialQualificationMaster(int specialQualificationId,
			Map<String, Object> generalMap);

}
