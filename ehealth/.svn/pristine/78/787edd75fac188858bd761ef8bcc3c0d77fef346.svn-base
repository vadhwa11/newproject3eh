package jkt.hms.adt.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.adt.dataservice.RegistrationDataService;
import jkt.hms.billing.dataservice.OpBillingDataService;
import jkt.hms.masters.business.HospitalDoctorUnitT;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;

public class RegistrationHandlerServiceImpl implements RegistrationHandlerService {

	RegistrationDataService registrationDataService = null;
	OpBillingDataService opBillingDataService = null;

	public Map<String, Object> showSearchPatientRecordsForUpdateJsp(Map<String, Object> getDataMap) {
		return registrationDataService.showSearchPatientRecordsForUpdateJsp(getDataMap);
	}

	public Map<String, Object> visitCreation(String hinNo) {
		return registrationDataService.visitCreation(hinNo);
	}

	public Map<String, Object> showMsgForReg(int deptId) {
		return registrationDataService.showMsgForReg(deptId);
	}

	public Map<String, Object> getLastVisitDetails(Map<String, Object> map) {
		return registrationDataService.getLastVisitDetails(map);
	}

	public Map<String, Object> populatePatientDetailsToVisit(Map<String, Object> map) {
		return registrationDataService.populatePatientDetailsToVisit(map);
	}

	public Map<String, Object> showSearchPatientRecordsForVisitJsp(Map<String, Object> map) {
		return registrationDataService.showSearchPatientRecordsForVisitJsp(map);

	}

	public Map<String, Object> populatePatientDetailsToRegistration(Map<String, Object> map) {
		return registrationDataService.populatePatientDetailsToRegistration(map);
	}

	public Map<String, Object> showSearchPatientRecords(Map<String, Object> map) {
		return registrationDataService.showSearchPatientRecords(map);
	}

	public Map<String, Object> searchPatientFromCitizen(Map<String, Object> map) {
		return registrationDataService.searchPatientFromCitizen(map);
	}

	public Map<String, Object> showRegistrationJsp(int deptId, int hospitalId) {
		return registrationDataService.showRegistrationJsp(deptId, hospitalId);
	}

	public Map<String, Object> submitPatientInformation(Map<String, Object> objectMap) {
		return registrationDataService.submitPatientInformation(objectMap);
	}

	public int getPatientTypeValidityDays(int patientTypeId) {
		return registrationDataService.getPatientTypeValidityDays(patientTypeId);
	}

	public String getHinId(String serviceNo, int serviceTypeId) {
		return registrationDataService.getHinId(serviceNo, serviceTypeId);
	}

	public Map<String, Object> getVisitDetails(int hospitalId) {
		return registrationDataService.getVisitDetails(hospitalId);
	}

	public Map<String, Object> getPatientDetails(Map<String, Object> mapForDs) {
		return registrationDataService.getPatientDetails(mapForDs);
	}

	public Map<String, Object> saveVisitInformation(Map<String, Object> mapForDs) {
		return registrationDataService.saveVisitInformation(mapForDs);
	}

	public Map<String, Object> getUpdateRegistrationDetails() {
		return registrationDataService.getUpdateRegistrationDetails();
	}

	public boolean updateRegistrationInformation(Map<String, Object> valuesMap) {
		return registrationDataService.updateRegistrationInformation(valuesMap);
	}

	public Map<String, Object> getServiceTypeAndRelation(Map<String, Object> parameterMap) {
		return registrationDataService.getServiceTypeAndRelation(parameterMap);
	}

	public Map<String, Object> getMothersName(String motherHinNo) {
		return registrationDataService.getMothersName(motherHinNo);
	}

	public Map<String, Object> getConnectionForReport() {
		return registrationDataService.getConnectionForReport();
	}

	public Map<String, Object> getPatientListForName(Map<String, Object> parameterMap) {
		return registrationDataService.getPatientListForName(parameterMap);
	}

	public List<Object> getHinNoList(String serviceNo) {
		return registrationDataService.getHinNoList(serviceNo);
	}

	public Map<String, Object> getPatientDetailsForUpdate(Map<String, Object> parameterMap) {
		return registrationDataService.getPatientDetailsForUpdate(parameterMap);
	}

	public List<Visit> getVisitNo(Map<String, Object> details) {
		return registrationDataService.getVisitNo(details);
	}

	public Map<String, Object> getPatientVisitDetailsForUpdate(Map<String, Object> parameterMap) {
		return registrationDataService.getPatientVisitDetailsForUpdate(parameterMap);
	}

	public boolean updateVisitInformation(Map<String, Object> parameterMap) {
		return registrationDataService.updateVisitInformation(parameterMap);
	}

	public boolean updateIpPatientInformation(Map<String, Object> parameterMap) {
		return registrationDataService.updateIpPatientInformation(parameterMap);
	}

	public Map<String, Object> getDetailsForVisit() {
		return registrationDataService.getDetailsForVisit();
	}

	public Map<String, Object> getServicePersonName(String serviceNo, int serviceTypeId) {
		return registrationDataService.getServicePersonName(serviceNo, serviceTypeId);
	}

	public RegistrationDataService getRegistrationDataService() {
		return registrationDataService;
	}

	public void setRegistrationDataService(RegistrationDataService registrationDataService) {
		this.registrationDataService = registrationDataService;
	}

	public Map<String, Object> getVisitData(Map<String, Object> dataMap) {

		return registrationDataService.getVisitData(dataMap);
	}

	public Map<String, Object> getTokenNo(Map<String, Object> dataMap) {
		return registrationDataService.getTokenNo(dataMap);
	}

	public Map<String, Object> populatePatientDetails(Map<String, Object> dataMap) {
		return registrationDataService.populatePatientDetails(dataMap);
	}

	public Map<String, Object> getAdmissionNoList(Map<String, Object> dataMap) {
		return registrationDataService.getAdmissionNoList(dataMap);
	}

	public OpBillingDataService getOpBillingDataService() {
		return opBillingDataService;
	}

	public void setOpBillingDataService(OpBillingDataService opBillingDataService) {
		this.opBillingDataService = opBillingDataService;
	}

	public Map<String, Object> populatePostOff(Map<String, Object> dataMap) {
		return registrationDataService.populatePostOff(dataMap);
	}

	public Map<String, Object> populsubDistrictByDistrictId(Map<String, Object> dataMap) {
		return registrationDataService.populsubDistrictByDistrictId(dataMap);
	}

	public Map<String, Object> populateVillage(Map<String, Object> dataMap) {
		return registrationDataService.populateVillage(dataMap);
	}

	public Map<String, Object> getIpAdmissionDetailsForBilling(Map<String, Object> dataMap) {
		return registrationDataService.getIpAdmissionDetailsForBilling(dataMap);
	}

	public Map<String, Object> ajaxForEmployeeDetails(Map<String, Object> dataMap) {
		return registrationDataService.ajaxForEmployeeDetails(dataMap);
	}

	public Map<String, Object> populateDepandentList(Map<String, Object> dataMap) {
		return registrationDataService.populateDepandentList(dataMap);
	}

	public Map<String, Object> getDepandentDetails(Map<String, Object> dataMap) {
		return registrationDataService.getDepandentDetails(dataMap);
	}

	public Map<String, Object> populateVillageFromDist(Map<String, Object> dataMap) {
		return registrationDataService.populateVillageFromDist(dataMap);
	}

	public Map<String, Object> populateVillageOfBlock(Map<String, Object> dataMap) {
		return registrationDataService.populateVillageOfBlock(dataMap);
	}

	public Map<String, Object> populateVillageOftaluk(Map<String, Object> dataMap) {
		return registrationDataService.populateVillageOftaluk(dataMap);
	}

	public Map<String, Object> getPatientDetailForAutoComplete(Map<String, Object> parameterMap) {
		return registrationDataService.getPatientDetailForAutoComplete(parameterMap);
	}

	public Map<String, Object> displayRegisPhoto(String hinNo) {
		return registrationDataService.displayRegisPhoto(hinNo);
	}

	public Map<String, Object> addPhotoFile(Map<String, Object> generalMap) {
		return registrationDataService.addPhotoFile(generalMap);
	}

	public Map<String, Object> updatePatientImage(Map<String, Object> mapDetails) {
		return registrationDataService.updatePatientImage(mapDetails);
	}

	public Map<String, Object> getUserList(Map<String, Object> mapDetails) {
		return registrationDataService.getUserList(mapDetails);
	}

	@Override
	public Map<String, Object> getUserName(int empId) {
		return registrationDataService.getUserName(empId);
	}

	@Override
	public String getHinNo(int hinId) {
		return registrationDataService.getHinNo(hinId);
	}

	// By ujjwal
	@Override
	public String getDepartmentname(int departmentId) {
		return registrationDataService.getDepartmentname(departmentId);
	}

	@Override
	public boolean opdPatientDetailsPhysio(OpdPatientDetails opdPatientDetails) {
		return registrationDataService.opdPatientDetailsPhysio(opdPatientDetails);
	}

	@Override
	public Map<String, Object> getDocForVisit(int deptId) {
		return registrationDataService.getDocForVisit(deptId);
	}

	@Override
	public Map<String, Object> populateRegistrationContact(int deptId) {
		return registrationDataService.populateRegistrationContact(deptId);
	}

	@Override
	public Map<String, Object> populateRegistrationVisit(int deptId, int hospitalId, String hinNo, int page,
			String visitSearch) {
		return registrationDataService.populateRegistrationVisit(deptId, hospitalId, hinNo, page, visitSearch);
	}

	@Override
	public Map<String, Object> populatePatientCitizenData(int citizenId) {
		return registrationDataService.populatePatientCitizenData(citizenId);
	}

	@Override
	public Map<String, Object> populatePatientForUpdate(String hinNo) {
		return registrationDataService.populatePatientForUpdate(hinNo);
	}

	@Override
	public Map<String, Object> populateRegistrationBill(int deptId) {
		return registrationDataService.populateRegistrationBill(deptId);
	}

	@Override
	public Map<String, Object> populateRegistrationCount() {
		return registrationDataService.populateRegistrationCount();
	}

	@Override
	public Map<String, Object> getItemId(Box box) {
		return registrationDataService.getItemId(box);
	}

	@Override
	public Map<String, Object> populateChargeableAmount(Map<String, Object> map) {
		return registrationDataService.populateChargeableAmount(map);
	}

	@Override
	public Map<String, Object> uhidConversion(Box box) {
		return registrationDataService.uhidConversion(box);
	}

	@Override
	public Map<String, Object> populateOnlinePage(int deptId, int hospitalId) {

		return registrationDataService.populateOnlinePage(deptId, hospitalId);
	}

	@Override
	public Map<String, Object> saveOnlineAppointment(Box box) {
		return registrationDataService.saveOnlineAppointment(box);
	}

	@Override
	public boolean getDepartmentByHospitalId(int hospitalId, int deptId) {
		return registrationDataService.getDepartmentByHospitalId(hospitalId, deptId);
	}

	@Override
	public Map<String, Object> searchPatientForUpdateRegistration(String uhidNo) {

		return registrationDataService.searchPatientForUpdateRegistration(uhidNo);

	}

	@Override
	public Map<String, Object> populateDistByState(Map<String, Object> map) {
		return registrationDataService.populateDistByState(map);
	}

	@Override
	public Map<String, Object> populatePostOfficeByVillage(Map<String, Object> map) {

		return registrationDataService.populatePostOfficeByVillage(map);
	}

	@Override
	public Map<String, Object> populateVillageTown(Map<String, Object> map) {

		return registrationDataService.populateVillageTown(map);
	}

	@Override
	public Map<String, Object> getPatientList(String hinNo) {

		return registrationDataService.getPatientList(hinNo);
	}

	@Override
	public int getTokenNumber(int hospitalId, int departmentId, Date date, int pHinId) {

		return registrationDataService.getTokenNumber(hospitalId, departmentId, date, pHinId);
	}

	@Override
	public Map<String, Object> searchUnservicedPatient(Box box) {

		return registrationDataService.searchUnservicedPatient(box);
	}

	@Override
	public Map<String, Object> submitUnservicedPatient(Box box) {

		return registrationDataService.submitUnservicedPatient(box);
	}

	@Override
	public Map<String, Object> populateUhidConversionPage(int hinId) {

		return registrationDataService.populateUhidConversionPage(hinId);
	}

	@Override
	public Map<String, Object> populatePatientOnAadharNo(String aadharNo) {

		return registrationDataService.populatePatientOnAadharNo(aadharNo);
	}

	@Override
	public int getDistrictIdByHospital(int hospitalId) {

		return registrationDataService.getDistrictIdByHospital(hospitalId);
	}

	@Override
	public Map<String, Object> getOneTimePassword(String mobileNumber, String opt) {

		return registrationDataService.getOneTimePassword(mobileNumber, opt);
	}

	@Override
	public boolean checkDuplicateRegistraiton(Map<String, Object> regDataMap) {

		return registrationDataService.checkDuplicateRegistraiton(regDataMap);
	}

	@Override
	public Map<String, Object> showAppRegistrationList(int hospitalId, int visitSessionId) {

		return registrationDataService.showAppRegistrationList(hospitalId, visitSessionId);
	}

	@Override
	public Map<String, Object> getReseveredTokenNo(int departmentId, int hospitalId) {

		return registrationDataService.getReseveredTokenNo(departmentId, hospitalId);
	}

	@Override
	public Map<String, Object> updatePatientPrintStatus(String hinNo, int hinNoRandom) {

		return registrationDataService.updatePatientPrintStatus(hinNo, hinNoRandom);
	}

	@Override
	public Map<String, Object> getTotalVistByHospital(int hospitalId, int departmentId, Date vdate, int pHinId,
			int sessionId, String hospitalCode) {

		return registrationDataService.getTotalVistByHospital(hospitalId, departmentId, vdate, pHinId, sessionId,
				hospitalCode);
	}

	@Override
	public Map<String, Object> populatePincodeByDistrict(Map<String, Object> map) {

		return registrationDataService.populatePincodeByDistrict(map);
	}

	@Override
	public Map<String, Object> lsgByDistrict(int districtId) {

		return registrationDataService.lsgByDistrict(districtId);
	}

	@Override
	public boolean checkDuplicateVisit(int hospitalId, int departmentId, int uhid) {

		return registrationDataService.checkDuplicateVisit(hospitalId, departmentId, uhid);
	}

	@Override
	public boolean savePatientQueue(int hospitalId, int departId, int priority, int tokenNumber, int uhinNo,
			long totalHospitalVisitNo, int visitId) {

		return registrationDataService.savePatientQueue(hospitalId, departId, priority, tokenNumber, uhinNo,
				totalHospitalVisitNo, visitId);
	}

	@Override
	public Map<String, Object> displayImage(String uhidNo) {

		return registrationDataService.displayImage(uhidNo);
	}

	@Override
	public Map<String, Object> populateUnitForDepartment(Map<String, Object> map) {

		return registrationDataService.populateUnitForDepartment(map);
	}

	@Override
	public Map<String, Object> populateDoctorForUnit(int unitId,int departmentId) {

		return registrationDataService.populateDoctorForUnit(unitId,departmentId);
	}

	@Override
	public Map<String, Object> populateDoctorForDepartment(String departmentId, int hospitalId) {

		return registrationDataService.populateDoctorForDepartment(departmentId, hospitalId);
	}

	@Override
	public Map<String, Object> populateUnitForDoctor(int depId, int hospId) {

		return registrationDataService.populateUnitForDoctor(depId, hospId);
	}

	@Override
	public Map<String, Object> visitscheme(int hospitalId, int schemeId, int chargeId, String phinid) {

		return registrationDataService.visitscheme(hospitalId, schemeId, chargeId, phinid);
	}

	@Override
	public Map<String, Object> showRegistrationCardReportJsp(int hospitalId) {

		return registrationDataService.showRegistrationCardReportJsp(hospitalId);
	}

	@Override
	public Map<String, Object> saveRegistrationCardPrintAmount(Map<String, Object> map) {

		return registrationDataService.saveRegistrationCardPrintAmount(map);
	}

	@Override
	public Map<String, Object> showPatientReferalList(int hospitalId, int deptId) {

		return registrationDataService.showPatientReferalList(hospitalId, deptId);
	}

	@Override
	public Map<String, Object> populateSubCenterByHospital(int hospitalId) {

		return registrationDataService.populateSubCenterByHospital(hospitalId);
	}

	@Override
	public Map<String, Object> updatePincodeByDistrict(Map<String, Object> map) {

		return registrationDataService.updatePincodeByDistrict(map);
	}

	@Override
	public Map<String, Object> showPatientInvestigationApp(int hospitalId) {

		return registrationDataService.showPatientInvestigationApp(hospitalId);
	}

	@Override
	public String getDepartmentNameList(String substring) {
		return registrationDataService.getDepartmentNameList(substring);
	}

	@Override
	public Map<String, Object> showSessionList(int hospital) {

		return registrationDataService.showSessionList(hospital);
	}

	@Override
	public Map<String, Object> showPaitentDetail(String hin_no) {

		return registrationDataService.showPaitentDetail(hin_no);
	}

	@Override
	public Map<String, Object> getHospital(int hospitalId) {

		return registrationDataService.getHospital(hospitalId);
	}

	@Override
	public Map<String, Object> saveClientRegisterPatientToServer(Box box) {

		return registrationDataService.saveClientRegisterPatientToServer(box);
	}

	@Override
	public Map<String, Object> showNursingAppointmentList(Box box) {

		return registrationDataService.showNursingAppointmentList(box);
	}

	@Override
	public Map<String, Object> uploadAndViewDocuments(Map<String, Object> map) {

		return registrationDataService.uploadAndViewDocuments(map);
	}

	@Override
	public Map<String, Object> populatePPWardByDistrict(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return registrationDataService.populatePPWardByDistrict(map);
	}

	@Override
	public Map<String, Object> getNameAndMobile(Map<String, Object> map) {
		return registrationDataService.getNameAndMobile(map);
	}

	@Override
	public Map<String, Object> paginationForPatientVisitJsp(int deptId, int hospitalId, String hinNo, int page,
			String visitSearch) {
		return registrationDataService.paginationForPatientVisitJsp(deptId, hospitalId, hinNo, page, visitSearch);
	}

	@Override
	public Map<String, Object> getVisitDetailsForDirectPrinting(Map<String, Object> objectMap) {

		return registrationDataService.getVisitDetailsForDirectPrinting(objectMap);
	}

	@Override
	public Map<String, Object> submitPatientInformationFromOtherSrc(Box box) {

		return registrationDataService.submitPatientInformationFromOtherSrc(box);
	}

	@Override
	public Map<String, Object> getPatientRegistrationDataFromOtherSrc(Box box) {

		return registrationDataService.getPatientRegistrationDataFromOtherSrc(box);
	}

	@Override
	public Map<String, Object> getPatientDetailsForVisitFromOthrSrc(Box box) {

		return registrationDataService.getPatientDetailsForVisitFromOthrSrc(box);
	}

	@Override
	public String getuserName(int empId) {
		return registrationDataService.getuserName(empId);
	}

	@Override
	public Map<String, Object> getOnlineAppointmentDetails(Box box) {

		return registrationDataService.getOnlineAppointmentDetails(box);
	}

	@Override
	public Map<String, Object> submitOnlineAppointmentVisitDetails(Box box) {
		return registrationDataService.submitOnlineAppointmentVisitDetails(box);
	}

	@Override
	public Map<String, Object> submitMobileNumberForOTP(Box box) {
		return registrationDataService.submitMobileNumberForOTP(box);
	}

	@Override
	public String getHospitalName(int hospitalId) {
		return registrationDataService.getHospitalName(hospitalId);
	}

	@Override
	public Map<String, Object> populatePatientCitizenDataAadhaar(String aadhaarNo) {
		return registrationDataService.populatePatientCitizenDataAadhaar(aadhaarNo);
	}

	@Override
	public Boolean checkTokenExist(String uhid, int tokenNo) {

		return registrationDataService.checkTokenExist(uhid, tokenNo);
	}

	@Override
	public Map<String, Object> populatePPLocalityByWardLsg(Map<String, Object> dataMap) {
		return registrationDataService.populatePPLocalityByWardLsg(dataMap);
	}

	@Override
	public Map<String, Object> populateOPDRegister(int hospitalId) {
		return registrationDataService.populateOPDRegister(hospitalId);
	}

	@Override
	public Map<String, Object> showRePrintOpTicketJsp(Box box) {

		return registrationDataService.showRePrintOpTicketJsp(box);
	}

	@Override
	public Map<String, Object> rePrintAdvanceOpTicket(Box box) {

		return registrationDataService.rePrintAdvanceOpTicket(box);
	}

	@Override
	public Map<String, Object> showReferralPrintOpTicketJsp(Box box) {

		return registrationDataService.showReferralPrintOpTicketJsp(box);
	}

	@Override
	public Map<String, Object> populatePPWardByLsg(Map<String, Object> map) {
		return registrationDataService.populatePPWardByLsg(map);
	}

	@Override
	public Map<String, Object> updateTokenNumber(String msgData, int hospitalId) {
		return registrationDataService.updateTokenNumber(msgData, hospitalId);
	}

	@Override
	public Map<String, Object> populateOnlinePageOtherHospital(int deptId, int hospitalId) {

		return registrationDataService.populateOnlinePageOtherHospital(deptId, hospitalId);
	}

	@Override
	public Map<String, Object> populHospitalByDistrictIdHospitalTypeId(Map<String, Object> dataMap) {
		return registrationDataService.populHospitalByDistrictIdHospitalTypeId(dataMap);
	}

	@Override
	public Map<String, Object> getServiceCenterByHospital(Map<String, Object> detailsMap) {
		return registrationDataService.getServiceCenterByHospital(detailsMap);
	}

	@Override
	public Map<String, Object> getSessionByHospital(Map<String, Object> detailsMap) {
		return registrationDataService.getSessionByHospital(detailsMap);
	}

	@Override
	public Map<String, Object> getDoctorUnit(Map<String, Object> map) {
		return registrationDataService.getDoctorUnit(map);
	}

	@Override
	public List<HospitalDoctorUnitT> getUnitDoctors(String unitId, String hospitalId) {
		return registrationDataService.getUnitDoctors(unitId, hospitalId);
	}

	@Override
	public Map<String, Object> getAppointmentDetails(Map<String, Object> map) {
		return registrationDataService.getAppointmentDetails(map);
	}

	@Override
	public List<String> getSessionForDepartment(int deptId, int hospitalId) {
		return registrationDataService.getSessionForDepartment(deptId, hospitalId);
	}

	@Override
	public List<String> getServiceCentersList(int hospitalId, String serviceCenterType) {
		return registrationDataService.getServiceCentersList(hospitalId, serviceCenterType);
	}

	@Override
	public String generateUHID(Map<String, Object> objectMap) {

		return registrationDataService.generateUHID(objectMap);
	}

	@Override
	public String generateUHIDForOtherPlatform(Map<String, Object> objectMap) {

		return registrationDataService.generateUHIDForOtherPlatform(objectMap);
	}

	@Override
	public Map<String, Object> showHeightWeight(String uhId) {
		return registrationDataService.showHeightWeight(uhId);
	}

	@Override
	public String isUnitExist(int hospitalId) {
		return registrationDataService.isUnitExist(hospitalId);
	}

	public Map<String, Object> getPatientDetailsForOPCard(Map<String, Object> mapForDs) {
		return registrationDataService.getPatientDetailsForOPCard(mapForDs);
	}
	
	@Override
	public Map<String, Object> showEditVisitDetails(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return registrationDataService.showEditVisitDetails(dataMap);
	}

	@Override
	public Map<String, Object> getDoctorsForDept(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return registrationDataService.getDoctorsForDept(dataMap);
	}

	@Override
	public Map<String, Object> submitEditVisitDetails(Box box) {
		// TODO Auto-generated method stub
		return registrationDataService.submitEditVisitDetails(box);
	}

	@Override
	public Map<String, Object> showQuickRegistrationJsp(int deptId, int hospitalId) {
		return registrationDataService.showQuickRegistrationJsp(deptId,hospitalId);
	}

	@Override
	public Map<String, Object> getLocalityAutocomplete(String locality) {
		return registrationDataService.getLocalityAutocomplete(locality);
	}

	@Override
	public Map<String, Object> getPatientDetailsForShortScreen(Map<String, Object> dataMap) {
		return registrationDataService.getPatientDetailsForShortScreen(dataMap);
	}

	@Override
	public List<Object[]> getLocalityId(String localityName) {
		return registrationDataService.getLocalityId(localityName);
	}

	@Override
	public Map<String, Object> checkForDoctorWaitingPatients(Box box) {
		return registrationDataService.checkForDoctorWaitingPatients(box);
	}
	
	@Override
	public Map<String, Object> patientVisitDetails(Map<String, Object> dataMap) {
		return registrationDataService.patientVisitDetails(dataMap);
	}
	
	@Override
	public Map<String, Object> submitPatientVisitDetails(Box box) {
		return registrationDataService.submitPatientVisitDetails(box);
	}

	@Override
	public Map<String, Object> getEmployeeDepartment(Map<String, Object> dataMap) {
		
		return registrationDataService.getEmployeeDepartment(dataMap);
	}

	@Override
	public Map<String, Object> showTransferPatientListJsp(
			Map<String, Object> dataMap) {
		return registrationDataService.showTransferPatientListJsp(dataMap);
	}

	@Override
	public Map<String, Object> submitTransferPatients(Box box) {
		return registrationDataService.submitTransferPatients(box);
	}
	
	@Override
	public Map<String, Object> releasedPatientDetails(Map<String, Object> dataMap) {
		return registrationDataService.releasedPatientDetails(dataMap);
	}

	@Override
	public Map<String, Object> populatePersonalReviewAppointmentData(
			int deptId, int hospitalId, int reviewInterval,
			Date appointmentDate, String preference,int empId) {
		return registrationDataService.populatePersonalReviewAppointmentData(deptId,hospitalId,reviewInterval,appointmentDate,preference,empId);
	}

	@Override
	public Map<String, Object> getMinMaxDaysForAppointment(int deptId,int hospitalId) {
		return registrationDataService.getMinMaxDaysForAppointment(deptId,hospitalId);
	}

	@Override
	public Map<String, Object> getAssignedPatientForDoctorSpecific(int docId) {
	return registrationDataService.getAssignedPatientForDoctorSpecific(docId);
	}
	
}