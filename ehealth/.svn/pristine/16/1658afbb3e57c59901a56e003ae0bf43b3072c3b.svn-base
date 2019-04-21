package jkt.hrms.training.handler;

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
import jkt.hrms.training.dataservice.TrainingDataService;

public class TrainingHandlerServiceImpl implements TrainingHandlerService {

	TrainingDataService trainingDataService = null;

	public TrainingDataService getTrainingDataService() {
		return trainingDataService;
	}

	public void setTrainingDataService(TrainingDataService trainingDataService) {
		this.trainingDataService = trainingDataService;
	}

	// ***************************************** Start Training Module's
	// Instructor Master By Rajendra **************************************//

	public Map<String, Object> showInstructorMasterJsp() {
		return trainingDataService.showInstructorMasterJsp();
	}

	public boolean addInstructionMaster(HrMasInstructor hrMasInstructor) {
		return trainingDataService.addInstructionMaster(hrMasInstructor);
	}

	public Map<String, Object> searchInstructorMaster(String instructorCode,
			String instructorName) {
		return trainingDataService.searchInstructorMaster(instructorCode,
				instructorName);
	}

	public boolean editInstructorMaster(Map<String, Object> generalMap) {
		return trainingDataService.editInstructorMaster(generalMap);
	}

	public boolean deleteInstructorMaster(int instructorId,
			Map<String, Object> generalMap) {
		return trainingDataService.deleteInstructorMaster(instructorId,
				generalMap);
	}

	// ***************************************** Start Training Module's
	// Training Master By Rajendra **************************************//

	public Map<String, Object> showTrainingMasterJsp() {
		return trainingDataService.showTrainingMasterJsp();
	}

	public boolean addTrainingMaster(HrMasTraining hrMasTraining) {
		return trainingDataService.addTrainingMaster(hrMasTraining);
	}

	public boolean editTrainingMaster(Map<String, Object> generalMap) {
		return trainingDataService.editTrainingMaster(generalMap);
	}

	public boolean deleteTrainingMaster(int trainingId,
			Map<String, Object> generalMap) {
		return trainingDataService.deleteTrainingMaster(trainingId, generalMap);
	}

	public Map<String, Object> searchTrainingMaster(String trainingCode,
			String trainingName) {
		return trainingDataService.searchTrainingMaster(trainingCode,
				trainingName);
	}

	// ***************************************** Start Training Module's
	// Training Requisition By Rajendra **************************************//
	public Map<String, Object> showTrainingRequisitionJsp(
			Map<String, Object> parameterMap) {
		return trainingDataService.showTrainingRequisitionJsp(parameterMap);
	}

	public boolean addTrainingRequisition(
			HrTrainingRequisition hrTrainingRequisition) {
		return trainingDataService
				.addTrainingRequisition(hrTrainingRequisition);
	}

	public boolean addTrainingApprovalStatus(
			HrTrainingApprovalStatus hrTrainingApprovalStatus) {
		return trainingDataService
				.addTrainingApprovalStatus(hrTrainingApprovalStatus);
	}

	public boolean editTrainingRequisition(Map<String, Object> generalMap) {
		return trainingDataService.editTrainingRequisition(generalMap);
	}

	public boolean deleteTrainingRequisition(int trainingRequisitionId,
			Map<String, Object> generalMap) {
		return trainingDataService.deleteTrainingRequisition(
				trainingRequisitionId, generalMap);
	}

	public Map<String, Object> searchTrainingRequisition(int employeeId) {
		return trainingDataService.searchTrainingRequisition(employeeId);
	}

	// ***************************************** Start Training Module's
	// Training Approval By Rajendra **************************************//
	public Map<String, Object> showTrainingApprovalJsp(int currentUserId) {
		return trainingDataService.showTrainingApprovalJsp(currentUserId);
	}

	public Map<String, Object> showTrainingApprovalStatus(Date fromDate,
			Date toDate, int currentUserId) {
		return trainingDataService.showTrainingApprovalStatus(fromDate, toDate,
				currentUserId);
	}

	public List<HrTrainingRequisition> updateRequisitionStatus(
			List<HrTrainingRequisition> trainingRequisitionListToBeUpdated) {
		return trainingDataService
				.updateRequisitionStatus(trainingRequisitionListToBeUpdated);
	}

	public HrMasTrainingStatus getTrainingStatusMasterById(int trainingStatusId) {
		return trainingDataService
				.getTrainingStatusMasterById(trainingStatusId);
	}

	// ***************************************** Start Training Module's Show
	// Training Status By Rajendra **************************************//
	public Map<String, Object> showTrainingStatusJsp(int currentUserId) {
		return trainingDataService.showTrainingStatusJsp(currentUserId);
	}

	public List<HrTrainingRequisition> getTrainingRequisitionList(
			int currentUserId) {
		return trainingDataService.getTrainingRequisitionList(currentUserId);
	}

	// ***************************************** Start Training Module's
	// Training Scheduling By Rajendra **************************************//
	public Map<String, Object> showTrainingSchedulingJsp() {
		return trainingDataService.showTrainingSchedulingJsp();
	}
	//VKS
	public Map<String, Object> showVacancyPositionJsp(Map<String, Object> dataMap) {
		return trainingDataService.showVacancyPositionJsp(dataMap);
	}
	public Map<String, Object> searchVacancyPositionJsp(Map<String,Object> map) {
		return trainingDataService.searchVacancyPositionJsp(map);
	}
	
	

	public Map addTrainingScheduling(HrTrainingSchedule hrTrainingSchedule) {
		return trainingDataService.addTrainingScheduling(hrTrainingSchedule);
	}

	public boolean editTrainingScheduling(Map<String, Object> generalMap) {
		return trainingDataService.editTrainingScheduling(generalMap);
	}

	public boolean deleteTrainingScheduling(int trainingSchedulingId,
			Map<String, Object> generalMap) {
		return trainingDataService.deleteTrainingScheduling(
				trainingSchedulingId, generalMap);
	}

	public Map<String, Object> showTrainingScheduling(Date fromDate, Date toDate) {
		return trainingDataService.showTrainingScheduling(fromDate, toDate);
	}

	// ***************************************** Start Training Module's
	// Training Intimation By Rajendra **************************************//
	public Map<String, Object> showTrainingIntimationJsp() {
		return trainingDataService.showTrainingIntimationJsp();
	}

	public Map<String, Object> searchEmployeeList(boolean toAllEmp,
			int locationId, int departmentId, int employeeId) {
		return trainingDataService.searchEmployeeList(toAllEmp, locationId,
				departmentId, employeeId);

	}

	// Start by Ramdular on 23-02-2011 For Training and Services Certificate
	// +++++

	public Map<String, Object> showTrainingServiceCertificate() {
		return trainingDataService.showTrainingServiceCertificate();
	}

	public Map<String, Object> showCertificateStudentAdmission() {
		return trainingDataService.showCertificateStudentAdmission();
	}

	public Map<String, Object> showPatientFitnessCertificate() {
		return trainingDataService.showPatientFitnessCertificate();
	}

	public Map<String, Object> showPatientSicknessCertificate() {
		return trainingDataService.showPatientSicknessCertificate();
	}

	public Map<String, Object> showMedicalCertificateFitnessFirstEntry() {
		return trainingDataService.showMedicalCertificateFitnessFirstEntry();
	}

	public Map<String, Object> showMedicalExaminationReport() {
		return trainingDataService.showMedicalExaminationReport();
	}

	public Map<String, Object> getConnectionForReport() {
		return trainingDataService.getConnectionForReport();
	}

	public Map<String, Object> showTrainingScheduleReport() {

		return trainingDataService.showTrainingScheduleReport();
	}

	public Map<String, Object> showTrainingRequistionReport() {

		return trainingDataService.showTrainingRequistionReport();
	}

	public Map<String, Object> showTrainingDetailReport() {

		return trainingDataService.showTrainingDetailReport();
	}

	public Map<String, Object> showTrainingEvaluationReport() {

		return trainingDataService.showTrainingEvaluationReport();
	}

	public Map<String, Object> showDepartmentWiseTrainingReport() {

		return trainingDataService.showDepartmentWiseTrainingReport();
	}

	@Override
	public boolean addTrainingServiceCertificate(
			HrTrainingService hrTrainingService, Map<String, Object> dataMap) {

		return trainingDataService.addTrainingServiceCertificate(
				hrTrainingService, dataMap);
	}

	@Override
	public Map<String, Object> searchTrainingServiceCertificate(int entryNos) {

		return trainingDataService.searchTrainingServiceCertificate(entryNos);
	}

	@Override
	public boolean EditTrainingServiceCertificate(Map<String, Object> map) {

		return trainingDataService.EditTrainingServiceCertificate(map);
	}

	@Override
	public boolean addCertificateStudentAdmission(
			HrStudentCertificate hrStudentCertificate) {

		return trainingDataService
				.addCertificateStudentAdmission(hrStudentCertificate);
	}

	@Override
	public Map<String, Object> searchCertificateStudentAdmission(int entryNos) {
		// TODO Auto-generated method stub
		return trainingDataService.searchCertificateStudentAdmission(entryNos);
	}

	@Override
	public boolean editCertificateStudentAdmission(Map<String, Object> map) {

		return trainingDataService.editCertificateStudentAdmission(map);

	}

	@Override
	public boolean addPatientFitnessCertificate(
			HrPatientFitnessCertificate hrPatientFitnessCertificate) {

		return trainingDataService
				.addPatientFitnessCertificate(hrPatientFitnessCertificate);

	}

	@Override
	public Map<String, Object> searchPatientFitnessCertificate(int entryNos) {

		return trainingDataService.searchPatientFitnessCertificate(entryNos);
	}

	@Override
	public boolean editPatientFitnessCertificate(Map<String, Object> map) {

		return trainingDataService.editPatientFitnessCertificate(map);
	}

	public Map<String, Object> getNameTitle(String regNo) {
		return trainingDataService.getNameTitle(regNo);
	}

	@Override
	public boolean addPatientSicknessCertificate(
			HrPatientSickCertificate hrPatientSickCertificate) {

		return trainingDataService
				.addPatientSicknessCertificate(hrPatientSickCertificate);
	}

	@Override
	public Map<String, Object> searchPatientSicknessCertificate(int entryNos) {

		return trainingDataService.searchPatientSicknessCertificate(entryNos);
	}

	@Override
	public boolean editPatientSicknessCertificate(Map<String, Object> map) {

		return trainingDataService.editPatientSicknessCertificate(map);
	}

	@Override
	public boolean addMedicalCertificateFitnessFirstEntry(
			HrMedicalFitnessFirst hrMedicalFitnessFirst) {

		return trainingDataService
				.addMedicalCertificateFitnessFirstEntry(hrMedicalFitnessFirst);

	}

	@Override
	public Map<String, Object> searchMedicalCertificateFitnessFirstEntry(
			int entryNos) {

		return trainingDataService
				.searchMedicalCertificateFitnessFirstEntry(entryNos);

	}

	@Override
	public boolean editMedicalCertificateFitnessFirstEntry(
			Map<String, Object> map) {

		return trainingDataService.editMedicalCertificateFitnessFirstEntry(map);

	}

	@Override
	public Map<String, Object> searchMedicalExaminationReport(
			Map<String, Object> enquiryMap) {

		return trainingDataService.searchMedicalExaminationReport(enquiryMap);
	}

	@Override
	public Map<String, Object> showMedicalExamEntry() {

		return trainingDataService.showMedicalExamEntry();
	}

	@Override
	public Boolean addMedicalExamEntry(HrMedicalRecord hrMedicalRecord) {

		return trainingDataService.addMedicalExamEntry(hrMedicalRecord);

	}

	@Override
	public Map<String, Object> getNameDepartment(String empCode) {

		return trainingDataService.getNameDepartment(empCode);

	}

	@Override
	public Map<String, Object> showSearchMedicalExamEntry() {

		return trainingDataService.showSearchMedicalExamEntry();

	}

	@Override
	public boolean editMedicalExamEntry(Map<String, Object> map) {

		return trainingDataService.editMedicalExamEntry(map);
	}

	public Map<String, Object> forUpdateMedicalExamEntry(int empCode) {

		return trainingDataService.forUpdateMedicalExamEntry(empCode);

	}

	public Map<String, Object> saveTrainingType(MasTrainingType masTrainingType) {

		return trainingDataService.saveTrainingType(masTrainingType);
	}

	public Map<String, Object> showTrainingTypeJsp() {

		return trainingDataService.showTrainingTypeJsp();
	}

	public Map<String, Object> editTrainingType(Map<String, Object> generalMap) {

		return trainingDataService.editTrainingType(generalMap);
	}

	public Map<String, Object> deleteTrainingType(Map<String, Object> generalMap) {

		return trainingDataService.deleteTrainingType(generalMap);
	}

	public Map<String, Object> searchTrainingType(String trainingTypeCode,
			String trainingTypeName) {

		return trainingDataService.searchTrainingType(trainingTypeCode,
				trainingTypeName);
	}
	public Map<String, Object> showTrainingEffectivnessJsp(Map<String, Object> generalMap) {
		
		return trainingDataService.showTrainingEffectivnessJsp(generalMap);
	}
	public Map<String, Object> saveTrainingEffectivness(HrTrainingEffective trainingEffective) {
		
		return trainingDataService.saveTrainingEffectivness(trainingEffective);
	}
	public Map<String, Object> editTrainingEffectivness(Map<String, Object> generalMap) {
		
		return trainingDataService.editTrainingEffectivness(generalMap);
	}

	@Override
	public Map<String, Object> showTransferApplicationJsp(
			Map<String, Object> parameterMap) {
		return trainingDataService.showTransferApplicationJsp(parameterMap);
	}

	@Override
	public Map<String, Object> showTransferApplicationApprovalJsp(
			Map<String, Object> parameterMap) {
		return trainingDataService.showTransferApplicationApprovalJsp(parameterMap);
	}

	@Override
	public Map<String, Object> saveTransferApplication(
			Map<String, Object> parameterMap) {
		return trainingDataService.saveTransferApplication(parameterMap);
	}

	@Override
	public Map<String, Object> saveTransferNotification(
			Map<String, Object> parameterMap) {
		return trainingDataService.saveTransferNotification(parameterMap);
	}

	@Override
	public Map<String, Object> showTransferNotificationJsp(
			Map<String, Object> parameterMap) {
		return trainingDataService.showTransferNotificationJsp(parameterMap);
	}

	@Override
	public boolean findNotificationNo(Map<String, Object> parameterMap) {
		return trainingDataService.findNotificationNo(parameterMap);
	}

	@Override
	public Map<String, Object> getRelievingWaitingListJsp(
			Map<String, Object> parameterMap) {
		return trainingDataService.getRelievingWaitingListJsp(parameterMap);
	}
	
	@Override
	public Map<String, Object> searchWaitingReleivingListJsp(
			Map<String, Object> parameterMap) {
		return trainingDataService.searchWaitingReleivingListJsp(parameterMap);
	}
	
	@Override
	public Map<String, Object> showEmpRelievingJsp(
			Map<String, Object> parameterMap) {
		return trainingDataService.showEmpRelievingJsp(parameterMap);
	}

	@Override
	public Map<String, Object> saveEmpRelieving(Map<String, Object> parameterMap) {
		return trainingDataService.saveEmpRelieving(parameterMap);
	}

	@Override
	public Map<String, Object> saveEmpJoining(Map<String, Object> parameterMap) {
		return trainingDataService.saveEmpJoining(parameterMap);
	}

	@Override
	public Map<String, Object> saveEmpDeputaion(Map<String, Object> parameterMap) {
		return trainingDataService.saveEmpDeputaion(parameterMap);
	}

	@Override
	public Map<String, Object> getEmpInfoForEmpSuspension(Map<String, Object> parameterMap) {
			
		return trainingDataService.getEmpInfoForEmpSuspension(parameterMap);
	}

	@Override
	public Map<String, Object> saveEmpSuspention(Map<String, Object> parameterMap) {
			
		return trainingDataService.saveEmpSuspention(parameterMap);
	}

	@Override
	public Map<String, Object> saveEmpTermination(
			Map<String, Object> parameterMap) {
		return trainingDataService.saveEmpTermination(parameterMap);
	}

	@Override
	public Map<String, Object> saveEmpDeath(Map<String, Object> parameterMap) {
		return trainingDataService.saveEmpDeath(parameterMap);
	}

	@Override
	public Map<String, Object> saveTransferApplicationApproval(
			Map<String, Object> parameterMap) {
		return trainingDataService.saveTransferApplicationApproval(parameterMap);
	}

	@Override
	public Map<String, Object> searchTransferApprovalEmployee(
			Map<String, Object> parameterMap) {
		return trainingDataService.searchTransferApprovalEmployee(parameterMap);
	}

	@Override
	public Map<String, Object> viewTransferPriority(
			Map<String, Object> detailMap) {
		return trainingDataService.viewTransferPriority(detailMap);
	}

	@Override
	public Map<String, Object> getJoiningWaitingListJsp(
			Map<String, Object> parameterMap) {
		return trainingDataService.getJoiningWaitingListJsp(parameterMap);
	}

	@Override
	public Map<String, Object> showEmpjoiningJsp(
			Map<String, Object> parameterMap) {
		return trainingDataService.showEmpjoiningJsp(parameterMap);
	}

	@Override
	public Map<String, Object> showSuspentionJsp(
			Map<String, Object> parameterMap) {
		return trainingDataService.showSuspentionJsp(parameterMap);
	}

	@Override
	public Map<String, Object> getSuspendByList(Map parameterMap) {
		return trainingDataService.getSuspendByList(parameterMap);
	}

	@Override
	public Map<String, Object> getRelievingWaitingListForSuspaAndTermin(Map<String, Object> parameterMap) {
			
		return trainingDataService.getRelievingWaitingListForSuspaAndTermin(parameterMap);
	}

	@Override
	public Map<String, Object> searchWaitingForSuspenTermi(
			Map<String, Object> parameterMap) {
		return trainingDataService.searchWaitingForSuspenTermi(parameterMap);
	}

	@Override
	public Map<String, Object> showEmpRelievingTerminAndSusp(
			Map<String, Object> parameterMap) {
		return trainingDataService.showEmpRelievingTerminAndSusp(parameterMap);
	}

	@Override
	public Map<String, Object> addAttachFile(Map<String, Object> generalMap) {
		return trainingDataService.addAttachFile(generalMap);
	}

	@Override
	public Map<String, Object> displaySubmitAttachment(Map<String, Object> parameterMap) {
		return trainingDataService.displaySubmitAttachment(parameterMap);
	}


	@Override
	public Map<String, Object> searchEmployeeContract(String instructorCode,
			String instructorName) {
		// TODO Auto-generated method stub
		return  trainingDataService.searchEmployeeContract(instructorCode,instructorName);
	}
	
	@Override
	public Map<String, Object> saveContractEmployee(Map<String, Object> parameterMap) {
			
		return trainingDataService.saveContractEmployee(parameterMap);
	}

	@Override
	public Map<String, Object> showMeetingSchedulingJsp() {
		return trainingDataService.showMeetingSchedulingJsp();
	}

	@Override
	public Map<String, Object> getMemberListForMeetingByName(Map<String, Object> dataMap) {
			
		return trainingDataService.getMemberListForMeetingByName(dataMap);
	}

	@Override
	public Map<String, Object> fillMemberForName(Map<String, Object> dataMap) {
		return trainingDataService.fillMemberForName(dataMap);
	}

	@Override
	public Map<String, Object> saveMeetingScheduling(Map<String, Object> dataMap) {
		return trainingDataService.saveMeetingScheduling(dataMap);
	}

	@Override
	public Map<String, Object> deleteAttachFileDepute(Map<String, Object> generalMap) {
			
		return trainingDataService.deleteAttachFileDepute(generalMap);
	}

	@Override
	public Map<String, Object> showSubCommitteeJsp() {
		return trainingDataService.showSubCommitteeJsp();
	}

	@Override
	public boolean addSubCommittee(HrCommitteeDetails lgl) {
		return trainingDataService.addSubCommittee(lgl);
	}

	@Override
	public boolean editSubCommitteeToDatabase(Map<String, Object> generalMap) {
		return trainingDataService.editSubCommitteeToDatabase(generalMap);
	}

	@Override
	public Map<String, Object> getCommitteeMember(int committeeId) {
		return trainingDataService.getCommitteeMember(committeeId);
	}

	@Override
	public Map<String, Object> showListOfMeetingScheduling(Box box) {
		return trainingDataService.showListOfMeetingScheduling(box);
	}

	@Override
	public Map<String, Object> showMinutesOfMeetingJsp(Box box) {
		return trainingDataService.showMinutesOfMeetingJsp(box);
	}

	@Override
	public Map<String, Object> saveMinutesOfMeeting(Map<String, Object> dataMap) {
		return trainingDataService.saveMinutesOfMeeting(dataMap);
	}
//VKS
	@Override
	public Map<String, Object> saveVacancyPosition(HrVacancyPost hrvp,Map<String,Object>dataMap) {
	 
		return  trainingDataService.saveVacancyPosition(hrvp,dataMap );
	}
	//VKS
	@Override
	public Map<String, Object> showTransferProcessingJsp(Map<String, Object> dataMap) {
		return trainingDataService.showTransferProcessingJsp(dataMap);
	}
	
@Override
	public Map<String, Object> showTransferProcessingDetailsJsp(
			Map<String, Object> dataMap) {
		return trainingDataService.showTransferProcessingDetailsJsp(dataMap);
	}
	
@Override
public Map<String, Object> saveProcessingDetails(
		Map<String, Object> dataMap, Box box) {
	return trainingDataService.saveProcessingDetails(dataMap, box);
}

// by Kaushal Mishra -----
	
@Override
public Map<String, Object> forwardProcessingDetails(
		Map<String, Object> dataMap, Box box) {
	return trainingDataService.forwardProcessingDetails(dataMap, box);
}

@Override
public Map<String, Object> cancelApprovalDetails(
		Map<String, Object> dataMap, Box box) {
	return trainingDataService.cancelApprovalDetails(dataMap, box);
}

@Override
public Map<String, Object> cancelApproval(
		Map<String, Object> dataMap, Box box) {
	return trainingDataService.cancelApproval(dataMap, box);
}

@Override
public Map<String, Object> inactiveEmployeeDetails(
		Map<String, Object> dataMap, Box box) {
	return trainingDataService.inactiveEmployeeDetails(dataMap, box);
}

@Override
public Map<String, Object> assignHospitalToEmployee(
		Map<String, Object> dataMap, Box box) {
	return trainingDataService.assignHospitalToEmployee(dataMap, box);
}

	
}
