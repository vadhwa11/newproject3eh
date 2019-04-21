package jkt.hrms.training.dataservice;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.HrCommitteeDetails;
import jkt.hms.masters.business.HrMedicalFitnessFirst;
import jkt.hms.masters.business.HrMedicalRecord;
import jkt.hms.masters.business.HrPatientFitnessCertificate;
import jkt.hms.masters.business.HrPatientSickCertificate;
import jkt.hms.masters.business.HrStudentCertificate;
import jkt.hms.masters.business.HrTrainingService;
import jkt.hms.masters.business.HrVacancyPost;
import jkt.hms.util.Box;
import jkt.hrms.masters.business.HrMasInstructor;
import jkt.hrms.masters.business.HrMasTraining;
import jkt.hrms.masters.business.HrMasTrainingStatus;
import jkt.hrms.masters.business.HrTrainingApprovalStatus;
import jkt.hrms.masters.business.HrTrainingEffective;
import jkt.hrms.masters.business.HrTrainingRequisition;
import jkt.hrms.masters.business.HrTrainingSchedule;
import jkt.hrms.masters.business.MasTrainingType;

public interface TrainingDataService {

	// ***************************************************** Start Training
	// Module's Instructor Master By Rajendra
	// ***********************************//

	Map<String, Object> showInstructorMasterJsp();

	boolean addInstructionMaster(HrMasInstructor hrMasInstructor);

	Map<String, Object> searchInstructorMaster(String instructorCode,
			String instructorName);

	boolean editInstructorMaster(Map<String, Object> generalMap);

	boolean deleteInstructorMaster(int instructorId,
			Map<String, Object> generalMap);

	// ****************************************************** Start Training
	// Module's Training Master By Rajendra
	// *************************************//

	Map<String, Object> showTrainingMasterJsp();

	boolean addTrainingMaster(HrMasTraining hrMasTraining);

	boolean editTrainingMaster(Map<String, Object> generalMap);

	boolean deleteTrainingMaster(int trainingId, Map<String, Object> generalMap);
	Map<String, Object> saveProcessingDetails(Map<String, Object> details, Box box);

	Map<String, Object> searchTrainingMaster(String trainingCode,
			String trainingName);
	
	// added Kaushal Mishra
	Map<String, Object> forwardProcessingDetails(Map<String, Object> details, Box box);
	
	Map<String, Object> cancelApprovalDetails(Map<String, Object> dataMap, Box box);
	
	Map<String, Object> cancelApproval(Map<String, Object> dataMap, Box box); 
	
	Map<String, Object> inactiveEmployeeDetails(Map<String, Object> dataMap, Box box);
	
	Map<String, Object> assignHospitalToEmployee(Map<String, Object> dataMap, Box box);

	// ****************************************************** Start Training
	// Module's Training Requisition By Rajendra
	// *************************************//

	Map<String, Object> showTrainingRequisitionJsp(
			Map<String, Object> parameterMap);

	boolean addTrainingRequisition(HrTrainingRequisition hrTrainingRequisition);

	boolean addTrainingApprovalStatus(
			HrTrainingApprovalStatus hrTrainingApprovalStatus);

	boolean editTrainingRequisition(Map<String, Object> generalMap);

	boolean deleteTrainingRequisition(int trainingRequisitionId,
			Map<String, Object> generalMap);

	Map<String, Object> searchTrainingRequisition(int employeeId);

	// ***************************************** Start Training Module's
	// Training Approval By Rajendra **************************************//
	Map<String, Object> showTrainingApprovalJsp(int currentUserId);

	Map<String, Object> showTrainingApprovalStatus(Date fromDate, Date toDate,
			int currentUserId);

	List<HrTrainingRequisition> updateRequisitionStatus(
			List<HrTrainingRequisition> trainingRequisitionListToBeUpdated);

	HrMasTrainingStatus getTrainingStatusMasterById(int trainingStatusId);

	// ***************************************** Start Training Module's Show
	// Training Status By Rajendra **************************************//
	Map<String, Object> showTrainingStatusJsp(int currentUserId);

	List<HrTrainingRequisition> getTrainingRequisitionList(int currentUserId);

	// ****************************************************** Start Training
	// Module's Training Scheduling By Rajendra
	// *************************************//
	Map<String, Object> showTrainingSchedulingJsp();

	Map addTrainingScheduling(HrTrainingSchedule hrTrainingSchedule);
	Map<String, Object> showTransferProcessingDetailsJsp(Map<String, Object> dataMap);

	boolean editTrainingScheduling(Map<String, Object> generalMap);

	boolean deleteTrainingScheduling(int trainingSchedulingId,
			Map<String, Object> generalMap);

	Map<String, Object> showTrainingScheduling(Date fromDate, Date toDate);

	// ****************************************************** Start Training
	// Module's Training Scheduling By Rajendra
	// *************************************//
	Map<String, Object> showTrainingIntimationJsp();

	Map<String, Object> searchEmployeeList(boolean toAllEmp, int locationId,
			int departmentId, int employeeId);

	// Start by Ramdular on 23-02-2011 For Training and Services Certificate
	// +++++

	Map<String, Object> showTrainingServiceCertificate();

	Map<String, Object> showCertificateStudentAdmission();

	Map<String, Object> showPatientFitnessCertificate();

	Map<String, Object> showPatientSicknessCertificate();

	Map<String, Object> showMedicalCertificateFitnessFirstEntry();

	Map<String, Object> showMedicalExaminationReport();

	Map<String, Object> getConnectionForReport();

	Map<String, Object> showTrainingScheduleReport();

	Map<String, Object> showTrainingRequistionReport();

	Map<String, Object> showTrainingDetailReport();

	Map<String, Object> showTrainingEvaluationReport();

	Map<String, Object> showDepartmentWiseTrainingReport();

	boolean addTrainingServiceCertificate(HrTrainingService hrTrainingService,
			Map<String, Object> dataMap);

	Map<String, Object> searchTrainingServiceCertificate(int entryNos);

	boolean EditTrainingServiceCertificate(Map<String, Object> map);

	boolean addCertificateStudentAdmission(
			HrStudentCertificate hrStudentCertificate);

	Map<String, Object> searchCertificateStudentAdmission(int entryNos);

	boolean editCertificateStudentAdmission(Map<String, Object> map);

	Map<String, Object> searchPatientFitnessCertificate(int entryNos);

	boolean editPatientFitnessCertificate(Map<String, Object> map);

	Map<String, Object> getNameTitle(String regNo);

	boolean addPatientFitnessCertificate(
			HrPatientFitnessCertificate hrPatientFitnessCertificate);

	boolean addPatientSicknessCertificate(
			HrPatientSickCertificate hrPatientSickCertificate);

	Map<String, Object> searchPatientSicknessCertificate(int entryNos);

	boolean editPatientSicknessCertificate(Map<String, Object> map);

	boolean addMedicalCertificateFitnessFirstEntry(
			HrMedicalFitnessFirst hrMedicalFitnessFirst);

	Map<String, Object> searchMedicalCertificateFitnessFirstEntry(int entryNos);

	boolean editMedicalCertificateFitnessFirstEntry(Map<String, Object> map);

	Map<String, Object> searchMedicalExaminationReport(
			Map<String, Object> enquiryMap);

	Map<String, Object> showMedicalExamEntry();

	Boolean addMedicalExamEntry(HrMedicalRecord hrMedicalRecord);

	Map<String, Object> getNameDepartment(String empCode);

	Map<String, Object> showSearchMedicalExamEntry();

	boolean editMedicalExamEntry(Map<String, Object> map);

	Map<String, Object> forUpdateMedicalExamEntry(int empCode);

	Map<String, Object> saveTrainingType(MasTrainingType masTrainingType);

	Map<String, Object> showTrainingTypeJsp();

	Map<String, Object> editTrainingType(Map<String, Object> generalMap);

	Map<String, Object> deleteTrainingType(Map<String, Object> generalMap);

	Map<String, Object> searchTrainingType(String trainingTypeCode,
			String trainingTypeName);

	Map<String, Object> showTrainingEffectivnessJsp(
			Map<String, Object> generalMap);

	Map<String, Object> saveTrainingEffectivness(
			HrTrainingEffective trainingEffective);

	Map<String, Object> editTrainingEffectivness(Map<String, Object> generalMap);

	Map<String, Object> showTransferApplicationJsp(
			Map<String, Object> parameterMap);

	Map<String, Object> showTransferApplicationApprovalJsp(
			Map<String, Object> parameterMap);

	Map<String, Object> saveTransferApplication(Map<String, Object> parameterMap);

	Map<String, Object> saveTransferNotification(
			Map<String, Object> parameterMap);

	Map<String, Object> showTransferNotificationJsp(
			Map<String, Object> parameterMap);

	boolean findNotificationNo(Map<String, Object> parameterMap);

	Map<String, Object> getRelievingWaitingListJsp(
			Map<String, Object> parameterMap);
	Map<String, Object> searchWaitingReleivingListJsp(
			Map<String, Object> parameterMap);
	
	Map<String, Object> showEmpRelievingJsp(Map<String, Object> parameterMap);

	Map<String, Object> saveEmpRelieving(Map<String, Object> parameterMap);

	Map<String, Object> saveEmpJoining(Map<String, Object> parameterMap);

	Map<String, Object> saveEmpDeputaion(Map<String, Object> parameterMap);

	Map<String, Object> getEmpInfoForEmpSuspension(
			Map<String, Object> parameterMap);

	Map<String, Object> saveEmpSuspention(Map<String, Object> parameterMap);

	Map<String, Object> saveEmpTermination(Map<String, Object> parameterMap);

	Map<String, Object> saveEmpDeath(Map<String, Object> parameterMap);

	Map<String, Object> saveTransferApplicationApproval(
			Map<String, Object> parameterMap);

	Map<String, Object> searchTransferApprovalEmployee(
			Map<String, Object> parameterMap);

	Map<String, Object> viewTransferPriority(Map<String, Object> detailMap);

	Map<String, Object> getJoiningWaitingListJsp(
			Map<String, Object> parameterMap);

	Map<String, Object> showEmpjoiningJsp(Map<String, Object> parameterMap);

	Map<String, Object> showSuspentionJsp(Map<String, Object> parameterMap);

	Map<String, Object> getSuspendByList(Map parameterMap);

	Map<String, Object> getRelievingWaitingListForSuspaAndTermin(
			Map<String, Object> parameterMap);

	Map<String, Object> searchWaitingForSuspenTermi(
			Map<String, Object> parameterMap);

	Map<String, Object> showEmpRelievingTerminAndSusp(
			Map<String, Object> parameterMap);

	Map<String, Object> addAttachFile(Map<String, Object> generalMap);

	Map<String, Object> displaySubmitAttachment(Map<String, Object> parameterMap);

	Map<String, Object> saveContractEmployee(Map<String, Object> parameterMap);

	Map<String, Object> searchEmployeeContract(String instructorCode,
			String instructorName);

	Map<String, Object> showMeetingSchedulingJsp();

	Map<String, Object> getMemberListForMeetingByName(
			Map<String, Object> dataMap);

	Map<String, Object> fillMemberForName(Map<String, Object> dataMap);

	Map<String, Object> saveMeetingScheduling(Map<String, Object> dataMap);

	Map<String, Object> deleteAttachFileDepute(Map<String, Object> generalMap);

	Map<String, Object> showSubCommitteeJsp();

	boolean addSubCommittee(HrCommitteeDetails lgl);

	boolean editSubCommitteeToDatabase(Map<String, Object> generalMap);

	Map<String, Object> getCommitteeMember(int committeeId);

	Map<String, Object> showListOfMeetingScheduling(Box box);

	Map<String, Object> showMinutesOfMeetingJsp(Box box);

	Map<String, Object> saveMinutesOfMeeting(Map<String, Object> dataMap);

	Map<String, Object> showVacancyPositionJsp(Map<String, Object> dataMap);
 
	Map<String, Object> searchVacancyPositionJsp(Map<String, Object> map);

	Map<String,Object>  saveVacancyPosition(HrVacancyPost hrvp,Map<String,Object>dataMap);

	Map<String, Object> showTransferProcessingJsp(Map<String, Object> dataMap);

	 

	

}
