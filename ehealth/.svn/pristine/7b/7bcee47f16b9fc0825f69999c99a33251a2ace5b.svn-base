package jkt.hms.adt.handler;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.adt.dataservice.ADTDataService;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.util.Box;

public class ADTHandlerServiceImpl implements ADTHandlerService {

	ADTDataService adtDataService = null;

	// Setters & Getters
	public ADTDataService getAdtDataService() {
		return adtDataService;
	}

	public void setAdtDataService(ADTDataService adtDataService) {
		this.adtDataService = adtDataService;
	}

	public Map<String, Object> getPatientDetails(Map<String, Object> mapForDs) {
		return adtDataService.getPatientDetails(mapForDs);
	}

	public Map<String, Object> getAdmissionDetails(Map<String, Object> dataMap) {
		return adtDataService.getAdmissionDetails(dataMap);
	}

	public Map<String, Object> submitAdmissionInformation(
			Map<String, Object> admissionMap) {
		return adtDataService.submitAdmissionInformation(admissionMap);
	}

	public String getMotherName(String motherAdNo) {
		return adtDataService.getMotherName(motherAdNo);
	}

	public Map<String, Object> saveAttachedAdmission(
			Map<String, Object> attachMap) {
		return adtDataService.saveAttachedAdmission(attachMap);
	}

	public Map<String, Object> getDetailsForMLC(int hospitalId) {
		return adtDataService.getDetailsForMLC(hospitalId);
	}

	public boolean submitMLCDetails(Map<String, Object> mlcDetailsMap) {
		return adtDataService.submitMLCDetails(mlcDetailsMap);
	}

	public String generateAdNumber(Map<String, Object> adMap) {
		return adtDataService.generateAdNumber(adMap);
	}

	public String generateMLCNo(Map<String, Object> adMap) {
		return adtDataService.generateMLCNo(adMap);
	}

	public Map<String, Object> getPatientDetailsForTransfer(
			Map<String, Object> mapForDs) {
		return adtDataService.getPatientDetailsForTransfer(mapForDs);
	}

	public Map<String, Object> getTransferDetails(int hospitalId,int deptId,int inpatientId) {
		return adtDataService.getTransferDetails(hospitalId,deptId,inpatientId);
	}

	public boolean submitTransferInformation(Map<String, Object> transferMap) {
		return adtDataService.submitTransferInformation(transferMap);
	}

	public Map<String, Object> getDischargeDetails(int hospitalId,int inpatientId) {
		return adtDataService.getDischargeDetails(hospitalId,inpatientId);
	}

	public boolean submitDischargeInformation(Map<String, Object> dischargeMap) {
		return adtDataService.submitDischargeInformation(dischargeMap);
	}

	public List<MasDepartment> getDepartmentList() {
		return adtDataService.getDepartmentList();
	}

	public Map<String, Object> getDischargePatientList(
			Map<String, Object> dischargeMap) {
		return adtDataService.getDischargePatientList(dischargeMap);
	}

	public Map<String, Object> getAttachPatientDetails(
			Map<String, Object> attachPatientMap) {
		return adtDataService.getAttachPatientDetails(attachPatientMap);
	}

	public Map<String, Object> dischargePatient(Map<String, Object> detailsMap) {
		return adtDataService.dischargePatient(detailsMap);
	}

	public Map<String, Object> showExpiryDetails(
			Map<String, Object> patientDetailsMap) {
		return adtDataService.showExpiryDetails(patientDetailsMap);
	}

	public boolean submitExpiryDetails(Map<String, Object> expiryDetilsMap,Box box) {
		return adtDataService.submitExpiryDetails(expiryDetilsMap,box);
	}

	public Map<String, Object> getConnectionForReport() {
		return adtDataService.getConnectionForReport();
	}

	public List getAdmissionNoList(Map<String, Object> detailsMap) {
		return adtDataService.getAdmissionNoList(detailsMap);
	}

	public List<Object> getHinNoList(String serviceNo) {
		return adtDataService.getHinNoList(serviceNo);
	}

	public Map<String, Object> getServiceTypeDepartmentCategory() {
		return adtDataService.getServiceTypeDepartmentCategory();
	}

	public Map<String, Object> getVisitDates(String hinNo, int hospitalId) {
		return adtDataService.getVisitDates(hinNo, hospitalId);
	}

	public Map<String, Object> getDiagnosis(Map<String, Object> parameterMap) throws ParseException {
		return adtDataService.getDiagnosis(parameterMap);
	}

	public Map<String, Object> getPatientAdmissionDetailsForUpdate(String adNo) {
		return adtDataService.getPatientAdmissionDetailsForUpdate(adNo);
	}

	public boolean updateAdmissionInformation(Map<String, Object> parameterMap) {
		return adtDataService.updateAdmissionInformation(parameterMap);
	}

	public Map<String, Object> getMlcNo(Map<String, Object> details) {
		return adtDataService.getMlcNo(details);
	}

	public Map<String, Object> getDetailsForSearch() {
		return adtDataService.getDetailsForSearch();
	}

	public Map<String, Object> getPatientDetailsForDischarge(
			Map<String, Object> mapForDs) {
		return adtDataService.getPatientDetailsForDischarge(mapForDs);
	}
	
	@Override
	public Map<String, Object> getDischargeDetails() {
		return adtDataService.getDischargeDetails();
	}

	public int getHospitalStaffSLNo() {
		return adtDataService.getHospitalStaffSLNo();
	}

	public boolean saveAdditionalInfoForDischarge(
			Map<String, Object> parameterMap) {
		return adtDataService.saveAdditionalInfoForDischarge(parameterMap);
	}

	public Map<String, Object> getPatientDiagnosis(String adNo, int inpatientId) {
		return adtDataService.getPatientDiagnosis(adNo, inpatientId);
	}
	
	public String getAmbulanceStatus(int inpatientId) {
		return adtDataService.getAmbulanceStatus(inpatientId);
	}

	public boolean cancelAdmissionInformation(Map<String, Object> parameterMap) {
		return adtDataService.cancelAdmissionInformation(parameterMap);
	}

	public Map<String, Object> getSiDiData(Map<String, Object> dataMap) {
		return adtDataService.getSiDiData(dataMap);
	}

	public Map<String, Object> getDiagnosisAndDocInit(
			Map<String, Object> dataMap) {
		return adtDataService.getDiagnosisAndDocInit(dataMap);
	}

	public Map<String, Object> chechBed(Map<String, Object> dataMap) {

		return adtDataService.chechBed(dataMap);
	}

	public Map<String, Object> checkAdNoDuplication(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return adtDataService.checkAdNoDuplication(dataMap);
	}

	public Map<String, Object> checkForDuplicateOfAdnoInAttach(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return adtDataService.checkForDuplicateOfAdnoInAttach(dataMap);
	}

	public Map<String, Object> getIcdWithIcdCode(Map<String, Object> dataMap) {
		return adtDataService.getIcdWithIcdCode(dataMap);
	}

	public Map<String, Object> getDischargeDetails(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return adtDataService.getDischargeDetails(dataMap);
	}

	public Map<String, Object> getDetailsOfDischarge(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return adtDataService.getDetailsOfDischarge(dataMap);
	}

	public Map<String, Object> updateDischarge(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return adtDataService.updateDischarge(dataMap);
	}

	public Map<String, Object> getICDDetails(Box box) {
		// TODO Auto-generated method stub
		return adtDataService.getICDDetails(box);
	}

	public Map<String, Object> searchExpiryDetails(Map<String, Object> dataMap) {
		return adtDataService.searchExpiryDetails(dataMap);
	}

	public Map<String, Object> printExpiryDetails(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return adtDataService.printExpiryDetails(dataMap);
	}

	public Map<String, Object> searchPatientDischarge(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return adtDataService.searchPatientDischarge(dataMap);
	}

	public Map<String, Object> checkCancelAdmissionState(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return adtDataService.checkCancelAdmissionState(dataMap);
	}

	public Map<String, Object> checkOffLineAdNoDuplicationFor(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return adtDataService.checkOffLineAdNoDuplicationFor(dataMap);
	}

	public Map<String, Object> getBedStatus(Box box, int hospitalId) {
		// TODO Auto-generated method stub
		return adtDataService.getBedStatus(box, hospitalId);
	}

	public Map<String, Object> getChargeCodeDetails(int chargeTypeId) {
		return adtDataService.getChargeCodeDetails(chargeTypeId);
	}

	public Map<String, Object> getHospitalParameterDetails(int hospitalId) {
		return adtDataService.getHospitalParameterDetails(hospitalId);

	}

	public Map<String, Object> getMlcDetailsForUpdate(Box box) {
		return adtDataService.getMlcDetailsForUpdate(box);
	}

	public boolean updateMLCDetails(Box box) {
		return adtDataService.updateMLCDetails(box);
	}

	@Override
	public Map<String, Object> showVillageWiseStaticsReportJsp(
			Map<String, Object> mapDetails) {
		return adtDataService.showVillageWiseStaticsReportJsp(mapDetails);
	}

	@Override
	public boolean patientTransferCalucation(
			Map<String, Object> transferCalucationMap) {
		return adtDataService.patientTransferCalucation(transferCalucationMap);
	}

	@Override
	public Map<String, Object> showAppointmentPatientJsp() {
		return adtDataService.showAppointmentPatientJsp();
	}

	/*
	 * @Override public Map<String, Object> showDiagnosisWisePatientJsp() {
	 * return adtDataService.showDiagnosisWisePatientJsp(); }
	 */
	@Override
	public Map<String, Object> getListForDisease(Map<String, Object> dataMap) {
		return adtDataService.getListForDisease(dataMap);
	}

	@Override
	public Map<String, Object> getDiseaseId(String diseaseWise) {
		return adtDataService.getDiseaseId(diseaseWise);
	}

	@Override
	public String getAdmissionNoListIpId(int inpatientId) {
		return adtDataService.getAdmissionNoListIpId(inpatientId);
	}

	@Override
	public Map<String, Object> getPatientDetailsForDischargeForWard(
			int inpatientId) {
		return adtDataService.getPatientDetailsForDischargeForWard(inpatientId);
	}

	@Override
	public boolean updatePatient(int inpatientId) {
		return adtDataService.updatePatient(inpatientId);
	}

	@Override
	public Map<String, Object> getDetailsForPatientAdission(
			Map<String, Object> mapForDs) {
		return adtDataService.getDetailsForPatientAdission(mapForDs);
	}
	
	@Override
	public Map<String, Object> getDetailIpPatientView(
			Map<String, Object> mapForDs) {
		return adtDataService.getDetailIpPatientView(mapForDs);
	}
	
	@Override
	public Map<String, Object> getAdmissionPatientDetail(
			Map<String, Object> mapForDs) {
		return adtDataService.getAdmissionPatientDetail(mapForDs);
	}


	@Override
	public Map<String, Object> getMLCNoList(Map<String, Object> detailsMap) {
		return adtDataService.getMLCNoList(detailsMap);
	}

	@Override
	public Map<String, Object> showMedicoLegalCaseDetailsNew(
			Map<String, Object> parameterMap) {
		return adtDataService.showMedicoLegalCaseDetailsNew(parameterMap);
	}

	@Override
	public Map<String, Object> displayUnitHeadName(Box box) {
		
		return adtDataService.displayUnitHeadName(box);
	}

	@Override
	public boolean checkBedStatus(int bedId) {
		// TODO Auto-generated method stub
		return adtDataService.checkBedStatus(bedId);
	}

	public Map<String, Object> getIpNo(Map<String, Object> details) {
		return adtDataService.getIpNo(details);
	}

	@Override
	public Map<String, Object> checkMotherDetail(Box box) {
		// TODO Auto-generated method stub
		return adtDataService.checkMotherDetail(box);
	}

	@Override
	public Map<String, Object> updateWoundCertificateStatus(Box box) {
		
		return adtDataService.updateWoundCertificateStatus(box);
	}

	@Override
	public Map<String, Object> saveObject(Map<String, Object> dataMap,Box box) {
		return adtDataService.saveObject(dataMap,box);
		 
	}
	
	@Override
	public Map<String, Object> dischargePatientFromLean(Map<String,Object> dataMap,Box box){
		return adtDataService.dischargePatientFromLean(dataMap,box);
	}
	
	@Override
	public Map<String, Object> pendingMortuaryList(Box box){
		return adtDataService.pendingMortuaryList(box);
	}
	@Override
	public Map<String, Object> showRegistrationMourtaryListWithoutMLC(Box box){
		return adtDataService.showRegistrationMourtaryListWithoutMLC(box);
	}
	
	@Override
	public Map<String, Object> submitMortuaryRegister(Box box){
		return adtDataService.submitMortuaryRegister(box);
	}
	
	@Override
	public Map<String, Object> populateOPNominalRegister(int hospitalId){
		return adtDataService.populateOPNominalRegister(hospitalId);
	}
	
	@Override
	public Map<String, Object> populateOPClinicalRegister(int hospitalId){
		return adtDataService.populateOPClinicalRegister(hospitalId);
	}
	
	@Override
	public	Map<String, Object> populateIPAdmissionRegister(int hospitalId) {
		return adtDataService.populateIPAdmissionRegister(hospitalId);
	}

	@Override
	public Map<String, Object> getHeaderDetails(Map<String, Object> detailsMap) {
		return adtDataService.getHeaderDetails(detailsMap);
	}
	
	@Override
	public Map<String, Object> submitMobileNumberForOTP(Box box){
		return adtDataService.submitMobileNumberForOTP(box);
	}
	
	@Override
	public Map<String, Object> sendSMSForAppointmentDetails(Box box){
		return adtDataService.sendSMSForAppointmentDetails(box);
	}
	
	@Override
	public Map<String, Object> sendRegistrationConfirmMessage(Box box){
		return adtDataService.sendRegistrationConfirmMessage(box);
	}
	
	@Override
	public Map<String, Object> sendAppointmentCancellationMessage(Box box){
		return adtDataService.sendAppointmentCancellationMessage(box);
	}
	
	@Override
	public Map<String, Object> populateDailyVisitReport(int hospitalId){
		return adtDataService.populateDailyVisitReport(hospitalId);
	}
	
	@Override
	public Map<String, Object> getServiceCentreDoctors(Box box){
		return adtDataService.getServiceCentreDoctors(box);
	}

	@Override
	public Map<String, Object> getDoctors(Box box) {
		return adtDataService.getDoctors(box);
	}

	
}
