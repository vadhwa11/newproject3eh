package jkt.hms.appointment.handler;

/**
 * @ author: Priyanka Garg
 * Made on: 9th July 2008
 */

import java.util.List;
import java.util.Map;

import jkt.hms.appointment.dataservice.AppointmentDataService;
import jkt.hms.util.Box;

public class AppointmentHandlerServiceImpl implements AppointmentHandlerService {

	AppointmentDataService appointmentDataService = null;

	/**
	 * ------------------------ GETTER AND SETTER METHODS ----------------
	 * 
	 * @return
	 */

	public AppointmentDataService getAppointmentDataService() {
		return appointmentDataService;
	}

	public void setAppointmentDataService(
			AppointmentDataService appointmentDataService) {
		this.appointmentDataService = appointmentDataService;
	}

	/**
	 * -------------------------------- Appointment Setup
	 * ---------------------------
	 */
	public Map<String, Object> showAppSetupJsp() {
		return appointmentDataService.showAppSetupJsp();
	}

	public boolean submitAppointmentSetup(Box box) {
		return appointmentDataService.submitAppointmentSetup(box);
	}

	public Map<String, Object> getRecords(Box box) {
		return appointmentDataService.getRecords(box);
	}

	public boolean updateAppointmentSetup(Box box) {
		return appointmentDataService.updateAppointmentSetup(box);
	}
	
	

	/**
	 * ---------------------- PATIENT APPOINTMENTS -------------------
	 */
	public Map<String, Object> showAppointmentPatientJsp(Map<String, Object> dtailsMap) {
		return appointmentDataService.showAppointmentPatientJsp(dtailsMap);
	}

	public Map<String, Object> showAppointmentPatientDepartmentWise(Box box) {
		return appointmentDataService.showAppointmentPatientDepartmentWise(box);
	}

	public Map<String, Object> showExistingPatients(Box box) {
		return appointmentDataService.showExistingPatients(box);
	}

	public Map<String, Object> submitPatientAppointment(Box box) {
		return appointmentDataService.submitPatientAppointment(box);
	}

	public Map<String, Object> submitDulicatePatientNameAppointment(Box box) {
		return appointmentDataService.submitDulicatePatientNameAppointment(box);
	}

	public Map<String, Object> showListBasedonHinNo(Box box) {
		return appointmentDataService.showListBasedonHinNo(box);
	}
	
	
	public Map<String, Object> getPriorityQueueByDepartId(int departmentId,int hospitalId,String AppointmentDate,String appointmentTime, String visitTime){
		return appointmentDataService.getPriorityQueueByDepartId(departmentId,hospitalId,AppointmentDate,appointmentTime, visitTime);
	}

	/**
	 * -------------------------- INVESTIGATION SETUP ----------------------
	 */
	public Map<String, Object> showAppointmentInvestigationSetupJsp(Map<String, Object> detailMap) {
		return appointmentDataService.showAppointmentInvestigationSetupJsp(detailMap);
	}

	public Map<String, Object> showAppointmentInvestigationSetupDetails(Box box) {
		return appointmentDataService
				.showAppointmentInvestigationSetupDetails(box);
	}

	public boolean submitAppointmentInvestigationSetup(Box box) {
		return appointmentDataService.submitAppointmentInvestigationSetup(box);
	}

	public boolean updateAppointmentInvestigationSetup(Box box) {
		return appointmentDataService.updateAppointmentInvestigationSetup(box);
	}

	/**
	 * ---------------------------------- INVESTIGATION APPOINTMENT
	 * -----------------------
	 * 
	 * @return
	 */
	public Map<String, Object> showAppointmentInvestigationJsp(Map<String, Object> detailMap) {
		return appointmentDataService.showAppointmentInvestigationJsp(detailMap);
	}

	public Map<String, Object> showAppointmentInvestigationWise(Box box) {
		return appointmentDataService.showAppointmentInvestigationWise(box);
	}

	public Map<String, Object> submitInvestigationAppointment(Box box) {
		return appointmentDataService.submitInvestigationAppointment(box);
	}

	public Map<String, Object> submitDulicatePatientNameInvAppointment(Box box) {
		return appointmentDataService
				.submitDulicatePatientNameInvAppointment(box);
	}

	/**
	 * ----------------------------- CANCELLATION FOR PATIENT APPOINTMENTS
	 * ---------------------
	 */
	public Map<String, Object> showAppointmentPatientCancellationJsp() {
		return appointmentDataService.showAppointmentPatientCancellationJsp();
	}

	public Map<String, Object> patientAppointmentList(Box box) {
		return appointmentDataService.patientAppointmentList(box);
	}

	public boolean submitCancelPatientAppointment(Box box) {
		return appointmentDataService.submitCancelPatientAppointment(box);
	}

	/**
	 * ----------------------------- CANCELLATION FOR INVESTIGATION APPOINTMENTS
	 * ---------------------
	 */

	public Map<String, Object> showAppointmentInvestigationCancellationJsp(Map<String, Object> detailMap) {
		return appointmentDataService
				.showAppointmentInvestigationCancellationJsp(detailMap);
	}

	public Map<String, Object> investigationAppointmentList(Box box) {
		return appointmentDataService.investigationAppointmentList(box);
	}

	public boolean submitCancelInvestigationAppointment(Box box) {
		return appointmentDataService.submitCancelInvestigationAppointment(box);
	}

	/**
	 * ------------------------- UPLOAD DOCUMENTS -------------
	 */

	public Map<String, Object> submitUploadDocuments(Box box) {
		return appointmentDataService.submitUploadDocuments(box);
	}

	public Map<String, Object> viewUploadDocuments(Box box) {
		return appointmentDataService.viewUploadDocuments(box);
	}

	/**
	 * -------------------------- For Report By Vishal ----------------------
	 */
	public Map<String, Object> getConnectionForReport() {
		return appointmentDataService.getConnectionForReport();
	}

	public Map<String, Object> getEmployeeDepartmentCategory(Map<String, Object> detailMap) {
		return appointmentDataService.getEmployeeDepartmentCategory(detailMap);
	}
	
	public Map<String, Object> getEquipmentDepartmentCategory(Map<String, Object> detailMap) {
		return appointmentDataService.getEquipmentDepartmentCategory(detailMap);
	}

	@Override
	public Map<String, Object> patientAppointmentRegisterList(Box box) {
		return appointmentDataService.patientAppointmentRegisterList(box);
	}
	@Override
	public Map<String, Object> populatePatientinvestigation(String UhidNo,int departmentId,int hospitalId) {
		
		return appointmentDataService.populatePatientinvestigation(UhidNo,departmentId,hospitalId);
	}

	@Override
	public Map<String, Object> populateInvestigationOrder(String UhidNo,int departmentId,int hospitalId) {
		
		return appointmentDataService.populateInvestigationOrder(UhidNo,departmentId,hospitalId);
	}

	@Override
	public Map<String, Object> getAppDetails(int deptId,int hospitalId, int sessionId) {
		return appointmentDataService.getAppDetails(deptId,hospitalId,sessionId);
	}

	@Override
	public Map<String, Object> ShowDialysisSchedulingSetUpJsp(Box box) {
		// TODO Auto-generated method stub
		return appointmentDataService.ShowDialysisSchedulingSetUpJsp(box);
	}

	@Override
	public Map<String, Object> submitDialysisSetup(Box box) {
		// TODO Auto-generated method stub
		return appointmentDataService.submitDialysisSetup(box);
	}

	@Override
	public Map<String, Object> updateDialysisSetup(Box box) {
		// TODO Auto-generated method stub
		return appointmentDataService.updateDialysisSetup(box);
	}

	@Override
	public Map<String, Object> showDialysisSchedulingJsp(int deptId,
			int hospitalId) {
		return appointmentDataService.showDialysisSchedulingJsp(deptId, hospitalId);
	}

	

	/**
	 * -------------------------- END For Report By Vishal
	 * ----------------------
	 */

	@Override
	public Map<String, Object> getPriorityQueueByDepartIdDialysis(Box box) {
		return appointmentDataService.getPriorityQueueByDepartIdDialysis(box);
	}

	@Override
	public Map<String, Object> submitDialysisScheduling(Box box) {
		return appointmentDataService.submitDialysisScheduling(box);
	}

	@Override
	public Map<String, Object> getServiceCentreWiseSession(Box box) {
		return appointmentDataService.getServiceCentreWiseSession(box);
	}

	@Override
	public Map<String, Object> getServiceCentreSessionForAppointment(Box box) {
		return appointmentDataService.getServiceCentreSessionForAppointment(box);
	}
	
	public Map<String, Object> saveClientAppointmentPatientToServer(Box box){
		return appointmentDataService.saveClientAppointmentPatientToServer(box);
	}
	
	public Map<String, Object> updateClientAppointmentPatientToServer(Box box){
		return appointmentDataService.updateClientAppointmentPatientToServer(box);
	}
	
	public Map<String, Object> getDoctorUnit(Map<String, Object> map){
		return appointmentDataService.getDoctorUnit(map);
	}
	
	public Map<String, Object> getCounterTimingForDepartment(int department ,int hospitalId){
		return appointmentDataService.getCounterTimingForDepartment(department , hospitalId);
	}

	public List<String> getSessionForDepartment(int department ,int hospitalId, String appointmentTime){
		return appointmentDataService.getSessionForDepartment(department , hospitalId, appointmentTime);
	} 
}
