package jkt.hms.adt.dataservice;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.IpAdmissionForLean;
import jkt.hms.masters.business.IpAdmissionForServer;
import jkt.hms.masters.business.LeanServerFinalDischargeData;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.util.Box;

public interface ADTDataService {

	Map<String, Object> getPatientDetails(Map<String, Object> mapForDs);

	Map<String, Object> getAdmissionDetails(Map<String, Object> dataMap);

	Map<String, Object> submitAdmissionInformation(Map<String, Object> admissionMap);

	String getMotherName(String motherAdNo);

	Map<String, Object> saveAttachedAdmission(Map<String, Object> attachMap);

	Map<String, Object> getDetailsForMLC(int hospitalId);

	boolean submitMLCDetails(Map<String, Object> mlcDetailsMap);

	String generateAdNumber(Map<String, Object> adMap);

	String generateMLCNo(Map<String, Object> adMap);

	Map<String, Object> getPatientDetailsForTransfer(Map<String, Object> mapForDs);

	Map<String, Object> getTransferDetails(int hospitalId,int deptId,int inpatientId);

	boolean submitTransferInformation(Map<String, Object> transferMap);

	Map<String, Object> getDischargeDetails(int hospitalId, int inpatientId);

	boolean submitDischargeInformation(Map<String, Object> dischargeMap);

	List<MasDepartment> getDepartmentList();

	Map<String, Object> getDischargePatientList(Map<String, Object> dischargeMap);

	Map<String, Object> getAttachPatientDetails(Map<String, Object> attachPatientMap);

	Map<String, Object> dischargePatient(Map<String, Object> detailsMap);

	Map<String, Object> showExpiryDetails(Map<String, Object> patientDetailsMap);

	boolean submitExpiryDetails(Map<String, Object> expiryDetilsMap,Box box);

	Map<String, Object> getConnectionForReport();

	List getAdmissionNoList(Map<String, Object> detailsMap);

	List<Object> getHinNoList(String serviceNo);

	Map<String, Object> getServiceTypeDepartmentCategory();

	Map<String, Object> getVisitDates(String hinNo, int hospitalId);

	Map<String, Object> getDiagnosis(Map<String, Object> parameterMap) throws ParseException;
	
	Map<String, Object> getPatientAdmissionDetailsForUpdate(String adNo);

	boolean updateAdmissionInformation(Map<String, Object> parameterMap);

	Map<String, Object> getMlcNo(Map<String, Object> details);

	Map<String, Object> getDetailsForSearch();

	Map<String, Object> getPatientDetailsForDischarge(Map<String, Object> mapForDs);

	int getHospitalStaffSLNo();

	boolean saveAdditionalInfoForDischarge(Map<String, Object> parameterMap);

	Map<String, Object> getPatientDiagnosis(String adNo, int inpatientId);
	
	String getAmbulanceStatus(int inpatientId);

	boolean cancelAdmissionInformation(Map<String, Object> parameterMap);

	Map<String, Object> getSiDiData(Map<String, Object> dataMap);

	Map<String, Object> getDiagnosisAndDocInit(Map<String, Object> dataMap);

	Map<String, Object> chechBed(Map<String, Object> dataMap);

	Map<String, Object> checkAdNoDuplication(Map<String, Object> dataMap);

	Map<String, Object> checkForDuplicateOfAdnoInAttach(Map<String, Object> dataMap);

	Map<String, Object> getIcdWithIcdCode(Map<String, Object> dataMap);

	Map<String, Object> getDischargeDetails(Map<String, Object> dataMap);

	Map<String, Object> getDetailsOfDischarge(Map<String, Object> dataMap);

	Map<String, Object> updateDischarge(Map<String, Object> dataMap);

	Map<String, Object> getICDDetails(Box box);

	Map<String, Object> searchExpiryDetails(Map<String, Object> dataMap);

	Map<String, Object> printExpiryDetails(Map<String, Object> dataMap);

	Map<String, Object> searchPatientDischarge(Map<String, Object> dataMap);

	Map<String, Object> checkCancelAdmissionState(Map<String, Object> dataMap);

	Map<String, Object> checkOffLineAdNoDuplicationFor(Map<String, Object> dataMap);

	Map<String, Object> getBedStatus(Box box,int hospitalId);

	Map<String, Object> getChargeCodeDetails(int chargeTypeId);

	public Map<String, Object> getHospitalParameterDetails(int hospitalId);

	Map<String, Object> getMlcDetailsForUpdate(Box box);

	boolean updateMLCDetails(Box box);

	Map<String, Object> showVillageWiseStaticsReportJsp(Map<String, Object> mapDetails);

	boolean patientTransferCalucation(Map<String, Object> transferCalucationMap);
	
	public Map<String, Object> pateintRoomRentCharge(Map<String, Object> detailsMap);

	Map<String, Object> showAppointmentPatientJsp();

/*	Map<String, Object> showDiagnosisWisePatientJsp();*/

	Map<String, Object> getListForDisease(Map<String, Object> dataMap);

	Map<String, Object> getDiseaseId(String diseaseWise);

	String getAdmissionNoListIpId(int inpatientId);

	Map<String, Object> getPatientDetailsForDischargeForWard(int inpatientId);

	boolean updatePatient(int inpatientId);
	
	Map<String, Object> getDetailsForPatientAdission(Map<String, Object> mapForDs);
	
	Map<String, Object> getDetailIpPatientView(Map<String, Object> mapForDs);
	
	Map<String, Object> getAdmissionPatientDetail(Map<String, Object> mapForDs);

	Map<String, Object> getDischargeDetails();

	Map<String, Object> getMLCNoList(Map<String, Object> detailsMap);
	
	Map<String, Object> showMedicoLegalCaseDetailsNew(Map<String, Object> parameterMap);

	Map<String, Object> displayUnitHeadName(Box box);

	boolean checkBedStatus(int bedId);

	Map<String, Object> getIpNo(Map<String, Object> details);

	Map<String, Object> checkMotherDetail(Box box);

	Map<String, Object> updateWoundCertificateStatus(Box box);
	
    Map<String,Object>  getDataForServer();
    
    Map<String,Object>  getDataForDischargePatientFromLeanServer();
    
    Map<String,Object>  getDataForLeanServer();
    
    String updateCentralServerIpAdmissionData(IpAdmissionForServer ipAdmissionForServer);
    
    String updateLeanServerIpDischargeData(LeanServerFinalDischargeData leanServerFinalDischargeData);
    
    String updateLeanServerIpAdmissionData(IpAdmissionForLean ipAdmissionForLeanServer);

    public Map<String, Object> saveObject(Map<String, Object> dataMap,Box box);
    
    Map<String, Object> dischargePatientFromLean(Map<String,Object> dataMap,Box box);
    
    Map<String, Object> pendingMortuaryList(Box box);
    
    Map<String, Object> showRegistrationMourtaryListWithoutMLC(Box box);
    
    Map<String, Object> submitMortuaryRegister(Box box);
    
    Map<String, Object> populateOPNominalRegister(int hospitalId);
    
    Map<String, Object> populateOPClinicalRegister(int hospitalId);
    
    Map<String, Object> populateIPAdmissionRegister(int hospitalId);

	Map<String, Object> getHeaderDetails(Map<String, Object> detailsMap);
	
	Map<String, Object> submitMobileNumberForOTP(Box box);
	
	Map<String, Object> sendSMSForAppointmentDetails(Box box);
	
	String  updateMobileRegistration();
	
	String  updatePatientAppointment();
	
	Map<String, Object> getHospitalData(Map<String, Object> objectMap);
	
	Map<String, Object> sendRegistrationConfirmMessage(Box box);
	
	Map<String, Object> sendAppointmentCancellationMessage(Box box);
	
	Map<String, Object> populateDailyVisitReport(int hospitalId);
	
	Map<String, Object> getServiceCentreDoctors(Box box);
	
	String sendInvestigationResultSMS();
	
	Map<String, Object> getDoctors(Box box);
	
}
