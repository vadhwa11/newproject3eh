package jkt.hms.adt.dataservice;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.BlOpBillDetails;
import jkt.hms.masters.business.BlOpBillHeader;
import jkt.hms.masters.business.CentralServerPatientAppointmentData;
import jkt.hms.masters.business.CentralServerPatientRegData;
import jkt.hms.masters.business.CentralServerVisitData;
import jkt.hms.masters.business.HospitalDoctorUnitT;
import jkt.hms.masters.business.LeanServerPatientAppointmentData;
import jkt.hms.masters.business.LeanServerPatientRegData;
import jkt.hms.masters.business.LeanServerVisitData;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PharmacyLabQueue;
import jkt.hms.masters.business.QueueManagment;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;

public interface RegistrationDataService {

	Map<String, Object> showRegistrationJsp(int deptId, int hospitalId);

	Map<String, Object> submitPatientInformation(Map<String, Object> objectMap);

	String getHinId(String serviceNo, int serviceTypeId);

	Map<String, Object> getVisitDetails(int hospitalId);

	Map<String, Object> getPatientDetails(Map<String, Object> mapForDs);

	Map<String, Object> saveVisitInformation(Map<String, Object> mapForDs);

	Map<String, Object> getUpdateRegistrationDetails();

	boolean updateRegistrationInformation(Map<String, Object> valuesMap);

	Map<String, Object> getServiceTypeAndRelation(Map<String, Object> parameterMap);

	Map<String, Object> getMothersName(String motherHinNo);

	Map<String, Object> getConnectionForReport();

	Map<String, Object> getPatientListForName(Map<String, Object> parameterMap);

	List<Object> getHinNoList(String serviceNo);

	Map<String, Object> getPatientDetailsForUpdate(Map<String, Object> parameterMap);

	List<Visit> getVisitNo(Map<String, Object> details);

	Map<String, Object> getPatientVisitDetailsForUpdate(Map<String, Object> parameterMap);

	boolean updateVisitInformation(Map<String, Object> parameterMap);

	boolean updateIpPatientInformation(Map<String, Object> parameterMap);

	Map<String, Object> getDetailsForVisit();

	Map<String, Object> getServicePersonName(String serviceNo, int serviceTypeId);

	Map<String, Object> getVisitData(Map<String, Object> dataMap);

	Map<String, Object> getTokenNo(Map<String, Object> dataMap);

	Map<String, Object> populatePatientDetails(Map<String, Object> dataMap);

	Map<String, Object> getAdmissionNoList(Map<String, Object> dataMap);

	Map<String, Object> populatePostOff(Map<String, Object> dataMap);

	Map<String, Object> populateVillage(Map<String, Object> dataMap);

	Map<String, Object> populsubDistrictByDistrictId(Map<String, Object> dataMap);

	Map<String, Object> getIpAdmissionDetailsForBilling(Map<String, Object> dataMap);

	Map<String, Object> ajaxForEmployeeDetails(Map<String, Object> dataMap);

	Map<String, Object> populateDepandentList(Map<String, Object> dataMap);

	Map<String, Object> getDepandentDetails(Map<String, Object> dataMap);

	int getPatientTypeValidityDays(int patientTypeId);

	Map<String, Object> populateVillageFromDist(Map<String, Object> dataMap);

	Map<String, Object> populateVillageOfBlock(Map<String, Object> dataMap);

	Map<String, Object> getPatientDetailForAutoComplete(Map<String, Object> parameterMap);

	Map<String, Object> displayRegisPhoto(String hinNo);

	Map<String, Object> addPhotoFile(Map<String, Object> generalMap);

	Map<String, Object> updatePatientImage(Map<String, Object> mapDetails);

	Map<String, Object> getUserList(Map<String, Object> mapDetails);

	Map<String, Object> getUserName(int empId);

	String getHinNo(int hinId);

	// By Ujjwal
	String getDepartmentname(int departmentId);

	boolean opdPatientDetailsPhysio(OpdPatientDetails opdPatientDetails);

	Map<String, Object> getDocForVisit(int deptId);

	Map<String, Object> populateRegistrationContact(int deptId);

	Map<String, Object> populateRegistrationVisit(int deptId, int hospitalId, String hinNo, int page, String visitSearch);

	Map<String, Object> populateRegistrationBill(int deptId);

	Map<String, Object> populateRegistrationCount();

	Map<String, Object> showSearchPatientRecords(Map<String, Object> map);

	Map<String, Object> populatePatientDetailsToRegistration(Map<String, Object> map);

	Map<String, Object> showSearchPatientRecordsForVisitJsp(Map<String, Object> map);

	Map<String, Object> populatePatientDetailsToVisit(Map<String, Object> map);

	Map<String, Object> getLastVisitDetails(Map<String, Object> map);

	Map<String, Object> showMsgForReg(int deptId);

	public Map<String, Object> getItemId(Box box);

	Map<String, Object> showPaitentDetail(String hin_no);

	Map<String, Object> visitCreation(String hinNo);

	Map<String, Object> showSearchPatientRecordsForUpdateJsp(Map<String, Object> getDataMap);

	Map<String, Object> populateChargeableAmount(Map<String, Object> map);

	Map<String, Object> uhidConversion(Box box);

	Map<String, Object> populateOnlinePage(int deptId, int hospitalId);

	Map<String, Object> saveOnlineAppointment(Box box);

	boolean getDepartmentByHospitalId(int hospitalId, int deptId);

	Map<String, Object> searchPatientForUpdateRegistration(String uhidNo);

	Map<String, Object> populateVillageOftaluk(Map<String, Object> map);

	Map<String, Object> populateDistByState(Map<String, Object> map);

	Map<String, Object> populatePatientForUpdate(String hinNo);

	Map<String, Object> searchPatientFromCitizen(Map<String, Object> map);

	Map<String, Object> populatePatientCitizenData(int citizenId);

	Map<String, Object> populatePostOfficeByVillage(Map<String, Object> map);

	Map<String, Object> populateVillageTown(Map<String, Object> map);

	Map<String, Object> getPatientList(String hinNo);

	int getTokenNumber(int hospitalId, int departmentId, Date date, int pHinId);

	Map<String, Object> searchUnservicedPatient(Box box);

	Map<String, Object> submitUnservicedPatient(Box box);

	Map<String, Object> populateUhidConversionPage(int hinId);

	Map<String, Object> populatePatientOnAadharNo(String aadharNo);

	int getDistrictIdByHospital(int hospitalId);

	Map<String, Object> getOneTimePassword(String mobileNumber, String opt);

	boolean checkDuplicateRegistraiton(Map<String, Object> regDataMap);

	Map<String, Object> showAppRegistrationList(int hospitalId, int visitSessionId);

	Map<String, Object> getReseveredTokenNo(int departmentId, int hospitalId);

	Map<String, Object> updatePatientPrintStatus(String hinNo, int hinNoRandom);

	Map<String, Object> getTotalVistByHospital(int hospitalId, int departmentId, Date vdate, int pHinId, int sessionId,
			String hospitalCode);

	Map<String, Object> populatePincodeByDistrict(Map<String, Object> map);

	Map<String, Object> updatePincodeByDistrict(Map<String, Object> map);

	Map<String, Object> lsgByDistrict(int districtId);

	boolean checkDuplicateVisit(int hospitalId, int departmentId, int uhid);

	boolean savePatientQueue(int hospitalId, int departId, int priority, int tokenNumber, int uhinNo,
			long totalHospitalVisitNo, int visitId);

	Map<String, Object> displayImage(String uhidNo);

	Map<String, Object> populateUnitForDepartment(Map<String, Object> map);

	Map<String, Object> populateDoctorForUnit(int unitId, int departmentId);

	Map<String, Object> populateDoctorForDepartment(String departmentId, int hospitalId);

	Map<String, Object> populateUnitForDoctor(int depId, int hospId);

	Map<String, Object> visitscheme(int hospitalId, int schemeId, int chargeId, String phinId);

	Map<String, Object> showRegistrationCardReportJsp(int hospitalId);

	Map<String, Object> saveRegistrationCardPrintAmount(Map<String, Object> map);

	Map<String, Object> showPatientReferalList(int hospitalId, int deptId);

	Map<String, Object> populateSubCenterByHospital(int hospitalId);

	Map<String, Object> showPatientInvestigationApp(int hospitalId);

	String getDepartmentNameList(String substring);

	Map<String, Object> showSessionList(int hospital);

	Map<String, Object> getHospital(int hospitalId);

	Map<String, Object> saveClientRegisterPatientToServer(Box box);

	Map<String, Object> getPatientRegistrationDataForServer();

	Map<String, Object> getPatientRegistrationDataForLeanServer();

	Map<String, Object> getPatientVisitDataForLeanServer();

	Map<String, Object> getPatientVisitDataForCentralServer();

	String updateCentralServerPatientRegData(CentralServerPatientRegData centralServerPatientRegData);

	String updateLeanServerPatientRegData(LeanServerPatientRegData leanServerPatientRegData);

	String updateLeanServerPatientVisitData(LeanServerVisitData leanServerVisitData);

	String updateCentralServerPatientVisitData(CentralServerVisitData centralServerVisitData);

	Map<String, Object> showNursingAppointmentList(Box box);

	Map<String, Object> uploadAndViewDocuments(Map<String, Object> map);

	Map<String, Object> populatePPWardByDistrict(Map<String, Object> map);

	Map<String, Object> getNameAndMobile(Map<String, Object> map);

	Map<String, Object> getPatientVisitUpdateForLeanServer();

	Map<String, Object> getPatientVisitUpdateForCentralServer();

	Map<String, Object> paginationForPatientVisitJsp(int deptId, int hospitalId, String hinNo, int page,
			String visitSearch);

	Map<String, Object> getVisitDetailsForDirectPrinting(Map<String, Object> objectMap);

	Map<String, Object> submitPatientInformationFromOtherSrc(Box box);

	Map<String, Object> getPatientRegistrationDataFromOtherSrc(Box box);

	Map<String, Object> getPatientDetailsForVisitFromOthrSrc(Box box);

	String getuserName(int empId);

	Map<String, Object> getOnlineAppointmentDetails(Box box);

	Map<String, Object> submitOnlineAppointmentVisitDetails(Box box);

	Map<String, Object> submitMobileNumberForOTP(Box box);

	Map<String, Object> getHospitalData(Map<String, Object> objectMap);

	String getHospitalName(int hospitalId);

	Map<String, Object> populatePatientCitizenDataAadhaar(String aadhaarNo);

	boolean checkTokenExist(String uhid, int tokenNo);

	Map<String, Object> populatePPLocalityByWardLsg(Map<String, Object> dataMap);

	Map<String, Object> populateOPDRegister(int hospitalId);

	Map<String, Object> showRePrintOpTicketJsp(Box box);

	Map<String, Object> rePrintAdvanceOpTicket(Box box);

	Map<String, Object> showReferralPrintOpTicketJsp(Box box);

	Map<String, Object> populatePPWardByLsg(Map<String, Object> map);

	Map<String, Object> getTokenAndSerialNo();

	Map<String, Object> updateTokenNumber(String msgData, int hospitalId);

	Map<String, Object> populateOnlinePageOtherHospital(int deptId, int hospitalId);

	Map<String, Object> populHospitalByDistrictIdHospitalTypeId(Map<String, Object> dataMap);

	Map<String, Object> getServiceCenterByHospital(Map<String, Object> detailsMap);

	Map<String, Object> getSessionByHospital(Map<String, Object> detailsMap);

	Map<String, Object> getDoctorUnit(Map<String, Object> map);

	List<HospitalDoctorUnitT> getUnitDoctors(String unitId, String hospitalId);

	Map<String, Object> getAppointmentDetails(Map<String, Object> map);

	List<String> getSessionForDepartment(int deptId, int hospitalId);

	List<String> getServiceCentersList(int hospitalId, String serviceCenterType);

	String generateUHID(Map<String, Object> objectMap);

	Map<String, Object> getPatientAppointmentDataForCentralServer();

	Map<String, Object> getPatientAppointmentDataForLeanServer();

	String updateCentralServerPatientAppointmentData(
			CentralServerPatientAppointmentData centralServerPatientAppointmentData);

	String updateLeanServerPatientAppointmentData(LeanServerPatientAppointmentData leanServerPatientAppointmentData);

	String generateUHIDForOtherPlatform(Map<String, Object> objectMap);

	Map<String, Object> getPatientAppointmentUpdateDataForLeanServer();

	Map<String, Object> showHeightWeight(String uhId);

	Map<String, Object> saveVisitInformationInLeanServer(List<Visit> visitList, List<QueueManagment> managements,
			BlOpBillHeader opBillHeader, BlOpBillDetails opBillDetails, Patient patient, MasHospital hospital);

	Map<String, Object> saveVisitInformationInCentralServer(List<Visit> visitList, List<QueueManagment> managements,
			BlOpBillHeader opBillHeader, BlOpBillDetails opBillDetails, Patient patient, MasHospital hospital);

	String isUnitExist(int hospitalId);

	Map<String, Object> getPatientDetailsForOPCard(Map<String, Object> mapForDs);
	Map<String,Object> showEditVisitDetails(Map<String,Object> dataMap);
	Map<String,Object> getDoctorsForDept(Map<String,Object> dataMap);
	Map<String,Object> submitEditVisitDetails(Box box);

	Map<String, Object> showQuickRegistrationJsp(int deptId, int hospitalId);

	Map<String, Object> getLocalityAutocomplete(String locality);

	Map<String, Object> getPatientDetailsForShortScreen(
			Map<String, Object> dataMap);

	List<Object[]> getLocalityId(String localityName);

	void updateDrWiseTokenDisplay();
	
	Map<String, Object> checkForDoctorWaitingPatients(Box box);
	
	Map<String,Object> patientVisitDetails(Map<String,Object> dataMap);
	
	Map<String,Object> submitPatientVisitDetails(Box box);

	Map<String, Object> getEmployeeDepartment(Map<String, Object> dataMap);
	Map<String, Object> showTransferPatientListJsp(Map<String, Object> dataMap);
	Map<String,Object> submitTransferPatients(Box box);
	
	Map<String,Object> releasedPatientDetails(Map<String,Object> dataMap);

	Map<String, Object> populatePersonalReviewAppointmentData(int deptId,
			int hospitalId, int reviewInterval, Date appointmentDate,
			String preference, int empId);

	Map<String,Object> getMinMaxDaysForAppointment(int deptId,int hospitalId);
	
	Map<String, Object> getAssignedPatientForDoctorSpecific(int docId);

	long getTokenNoForDepartment(Map<String, Object> requestMap);

	PharmacyLabQueue saveQueueNoForPharmacy(int pharmacyDepartmentId, int hospitalId, Visit visit,
			String departmentType, int tokenNo);
}
