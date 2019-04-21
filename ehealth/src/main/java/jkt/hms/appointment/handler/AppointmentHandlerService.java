package jkt.hms.appointment.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.util.Box;

/**
 * @ author: Priyanka Garg Made on: 9th July 2008
 */


public interface AppointmentHandlerService {

	Map<String, Object> showAppSetupJsp();

	Map<String, Object> getRecords(Box box);

	boolean submitAppointmentSetup(Box box);

	boolean updateAppointmentSetup(Box box);

	/**
	 * -------------------------------------- PATIENT APPOINTMENTS
	 * --------------------------------
	 * @param dtailsMap 
	 * 
	 * @return
	 */

	Map<String, Object> showAppointmentPatientJsp(Map<String, Object> dtailsMap);

	Map<String, Object> showAppointmentPatientDepartmentWise(Box box);

	Map<String, Object> showExistingPatients(Box box);

	Map<String, Object> submitPatientAppointment(Box box);

	Map<String, Object> submitDulicatePatientNameAppointment(Box box);

	Map<String, Object> showListBasedonHinNo(Box box);
	
	Map<String, Object> getPriorityQueueByDepartId(int departmentId,int hospitalId,String AppointmentDate,String appointmentTime, String visitTime);

	/**
	 * ------------------------------- INVESTIGATION SETUP
	 * ------------------------------------
	 * @param detailMap 
	 * 
	 * @return
	 */

	Map<String, Object> showAppointmentInvestigationSetupJsp(Map<String, Object> detailMap);

	Map<String, Object> showAppointmentInvestigationSetupDetails(Box box);

	boolean submitAppointmentInvestigationSetup(Box box);

	boolean updateAppointmentInvestigationSetup(Box box);

	/**
	 * ---------------------------------- INVESTIGATION APPOINTMENT
	 * -----------------------
	 * @param detailMap 
	 * 
	 * @return
	 */
	Map<String, Object> showAppointmentInvestigationJsp(Map<String, Object> detailMap);

	Map<String, Object> showAppointmentInvestigationWise(Box box);

	Map<String, Object> submitInvestigationAppointment(Box box);

	Map<String, Object> submitDulicatePatientNameInvAppointment(Box box);

	/**
	 * ------------------------------- CANCELLATION FOR PATIENT APPOINTMENTS
	 * -------------------
	 * 
	 * @return
	 */

	Map<String, Object> showAppointmentPatientCancellationJsp();

	Map<String, Object> patientAppointmentList(Box box);

	boolean submitCancelPatientAppointment(Box box);

	/**
	 * ------------------------------- CANCELLATION FOR INVESTIGATION
	 * APPOINTMENTS -------------------
	 * @param detailMap 
	 * 
	 * @return
	 */

	Map<String, Object> showAppointmentInvestigationCancellationJsp(Map<String, Object> detailMap);

	boolean submitCancelInvestigationAppointment(Box box);

	Map<String, Object> investigationAppointmentList(Box box);

	/**
	 * --------------------------------- UPLOAD DOCUMENTS
	 * -------------------------
	 * 
	 */

	Map<String, Object> submitUploadDocuments(Box box);

	Map<String, Object> viewUploadDocuments(Box box);

	/**
	 * ------------------------------- For Report by
	 * Vishal------------------------------------
	 * 
	 * @return
	 */
	Map<String, Object> getConnectionForReport();

	Map<String, Object> getEmployeeDepartmentCategory(Map<String, Object> detailMap);

	Map<String, Object> getEquipmentDepartmentCategory(Map<String, Object> detailMap);

	Map<String, Object> patientAppointmentRegisterList(Box box);
	
	Map<String,Object> populateInvestigationOrder(String UhidNo,int departmentId,int hospitalId);
	
	Map<String,Object> populatePatientinvestigation(String UhidNo,int departmentId,int hospitalId);

	Map<String, Object> getAppDetails(int deptId,int hospitalId, int sessionId);

	Map<String, Object> ShowDialysisSchedulingSetUpJsp(Box box);

	Map<String, Object> submitDialysisSetup(Box box);

	Map<String, Object> updateDialysisSetup(Box box);

	Map<String, Object> showDialysisSchedulingJsp(int deptId, int hospitalId);

	//Map<String, Object> getPriorityQueueByDepartIdDialysis(int departmentId,int hospitalId, String appointmentDate);

	Map<String, Object> getPriorityQueueByDepartIdDialysis(Box box);

	Map<String, Object> submitDialysisScheduling(Box box);
	
	Map<String, Object> getServiceCentreWiseSession(Box box);

	Map<String, Object> getServiceCentreSessionForAppointment(Box box);
	
	Map<String, Object> saveClientAppointmentPatientToServer(Box box);
	
	Map<String, Object> updateClientAppointmentPatientToServer(Box box);

	Map<String, Object> getDoctorUnit(Map<String, Object> map);
	
	Map<String, Object> getCounterTimingForDepartment(int department ,int hospitalId);
	
	List<String> getSessionForDepartment(int deptId,int hospitalId,String appointmentTime);
}
