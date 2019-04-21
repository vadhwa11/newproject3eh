package jkt.hms.mis.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.mis.dataservice.MISDataService;
import jkt.hms.util.Box;

public class MISHandlerServiceImpl implements MISHandlerService {

	MISDataService misDataService = null;

	// ------------------------------- ED Return Form
	// ----------------------------
	public Map<String, Object> showEDReturnsJsp() {
		return misDataService.showEDReturnsJsp();
	}

	public Map<String, Object> showEDReturns(String toDate, String fromDate,
			String category, String edStatus) {
		return misDataService.showEDReturns(toDate, fromDate, category,
				edStatus);

	}

	public boolean editEDReturnsToDatabase(Map<String, Object> generalMap) {
		return misDataService.editEDReturnsToDatabase(generalMap);
	}

	public Map<String, Object> searchEDReturn(Date toDate, Date fromDate,
			String category) {
		return misDataService.searchEDReturn(toDate, fromDate, category);
	}

	// ------------------------- ED Return Report Form
	// ---------------------------

	public Map<String, Object> showEDreportsjsp() {

		return misDataService.showEDreportsjsp();
	}

	// ------------------- Patient Movement Order Report Form
	// -------------------

	public Map<String, Object> showPatientMovementOrderjsp() {
		return misDataService.showPatientMovementOrderjsp();
	}

	public Map<String, Object> searchPatientMovementOrder(String disposal,
			String serviceNo) {
		return misDataService.searchPatientMovementOrder(disposal, serviceNo);
	}

	// ------------------------------- Afmsf-1 Def
	// -------------------------------

	public boolean editAfmsfDef(Map<String, Object> generalMap) {
		return misDataService.editAfmsfDef(generalMap);
	}

	public Map<String, Object> showAfmsfDef(Map<String, Object> generalMap) {
		return misDataService.showAfmsfDef(generalMap);
	}

	public Map<String, Object> showAfmsfDefjsp() {
		return misDataService.showAfmsfDefjsp();
	}

	// ------------------------------- Afmsf-1 Surplus
	// -------------------------------
	public boolean editAfmsfSurplus(Map<String, Object> generalMap) {
		return misDataService.editAfmsfSurplus(generalMap);
	}

	public Map<String, Object> showAfmsfSurplus(Map<String, Object> generalMap) {
		return misDataService.showAfmsfSurplus(generalMap);
	}

	public Map<String, Object> showAfmsfSurplusjsp() {
		return misDataService.showAfmsfSurplusjsp();
	}

	// ------------------------ Afmsf-1 AnnualMedicalExamination
	// -------------------------------
	public Map<String, Object> showAfmsfAnnualMedicalExaminationjsp() {
		return misDataService.showAfmsfAnnualMedicalExaminationjsp();
	}

	public Map<String, Object> showAfmsfAnnualMedicalExamination(
			String serviceNo) {
		return misDataService.showAfmsfAnnualMedicalExamination(serviceNo);
	}

	public Map<String, Object> editAfmsfAnnualMedicalExamination(
			Map<String, Object> generalMap) {
		return misDataService.editAfmsfAnnualMedicalExamination(generalMap);
	}

	public Map<String, Object> showFatalCasejsp(int inpatientid) {
		return misDataService.showFatalCasejsp(inpatientid);
	}

	public boolean editFatalcase(Map<String, Object> generalMap) {
		return misDataService.editFatalCase(generalMap);
	}

	public Map<String, Object> showTotalAdmissionjsp() {
		return misDataService.showTotalAdmissionjsp();
	}

	public Map<String, Object> searchTotalAdmission(Date fromDate, Date toDate,
			String serviceType) {
		return misDataService.searchTotalAdmission(fromDate, toDate,
				serviceType);
	}

	public Map<String, Object> showTotalDischargejsp() {
		return misDataService.showTotalDischargejsp();
	}

	public Map<String, Object> searchTotalDischarge() {
		return misDataService.searchTotalDischarge();
	}

	public Map<String, Object> showMonthlySickReportsjsp() {
		return misDataService.showMonthlySickReportsjsp();
	}

	public Map<String, Object> showMonthlySickDischargeReportjsp() {
		return misDataService.showMonthlySickDischargeReportjsp();
	}

	public List<Object> getAdmissionNoList(Map<String, Object> detailsMap) {
		return misDataService.getAdmissionNoList(detailsMap);
	}

	public List<Object> getHinNoList(String serviceNo) {
		return misDataService.getHinNoList(serviceNo);
	}

	public Map<String, Object> showFrwCases() {
		return misDataService.showFrwCases();
	}

	public Map<String, Object> submitFrwCases(Map<String, Object> generalMap) {
		return misDataService.submitFrwCases(generalMap);
	}

	public Map<String, Object> getDBConnection() {
		return misDataService.getDBConnection();
	}

	/**
	 * -------------------- NOTIFIABLE DISEASE ENTRY FORM ------------
	 */
	public Map<String, Object> showNotifiableDiseaseJsp(
			Map<String, Object> generalMap) {
		return misDataService.showNotifiableDiseaseJsp(generalMap);
	}

	public Map<String, Object> showNotifiableDisease(
			Map<String, Object> generalMap) {
		return misDataService.showNotifiableDisease(generalMap);
	}

	public boolean editNotifiableDisease(Map<String, Object> generalMap) {
		return misDataService.editNotifiableDisease(generalMap);
	}

	/**
	 * ------------------------ NOTIFIABLE DISEASE REPORT FORM
	 * ------------------------
	 */

	public Map<String, Object> showNotifiableDiseaseReportJsp() {
		return misDataService.showNotifiableDiseaseReportJsp();
	}

	/**
	 * ------------------------ MALARIA CASE REPORT ------------------------
	 */
	public Map<String, Object> showMalariaCaseReportJsp() {
		return misDataService.showMalariaCaseReportJsp();
	}

	public Map<String, Object> showBedStatisticsDetailReport(
			Map<String, Object> map) {
		return misDataService.showBedStatisticsDetailReport(map);
	}

	// ------------------------- BedStatisticsReport Form
	// ---------------------------

	public Map<String, Object> showBedStatisticsSummary() {
		return misDataService.showBedStatisticsSummary();
	}

	// --------------------------Daily Ward Wise Bed
	// Status---------------------------------
	public Map<String, Object> showDailyBedStatusReport() {
		return misDataService.showDailyBedStatusReport();
	}

	// -----------------------Birth Certificate-----------------------------
	public Map<String, Object> showBirth(int inpatientId) {
		return misDataService.showBirth(inpatientId);
	}

	public Map<String, Object> showBirthCertificateJsp() {
		return misDataService.showBirthCertificateJsp();
	}

	public Map<String, Object> addBirthCertificate(
			Map<String, Object> generalMap) {
		return misDataService.addBirthCertificate(generalMap);
	}

	public List<Object> getMotherHin(String serviceNo) {
		return misDataService.getMotherHin(serviceNo);
	}

	public Map<String, Object> getConnectionForReport() {
		return misDataService.getConnectionForReport();
	}

	public Map<String, Object> generateRegNumber(Map<String, Object> regMap) {
		return misDataService.generateRegNumber(regMap);
	}

	public Map<String, Object> showUpdateBirthCertificate(
			Map<String, Object> map) {

		return misDataService.showUpdateBirthCertificate(map);
	}

	public boolean submitUpdateBirthCertificate(Map<String, Object> generalMap) {
		return misDataService.submitUpdateBirthCertificate(generalMap);
	}

	// ------------------------------Death
	// Certificate--------------------------------------
	public Map<String, Object> showDeathCertificateJsp() {
		return misDataService.showDeathCertificateJsp();
	}

	public Map<String, Object> showDeath(int inpatientid) {
		return misDataService.showDeath(inpatientid);
	}

	public List<Object> getExpiredHin(String serviceNo) {
		return misDataService.getExpiredHin(serviceNo);
	}

	public Map<String, Object> addDeathCertificate(
			Map<String, Object> generalMap) {
		return misDataService.addDeathCertificate(generalMap);
	}

	public Map<String, Object> showUpdateDeathCertificate(
			Map<String, Object> map) {
		return misDataService.showUpdateDeathCertificate(map);
	}

	public boolean submitUpdateDeathCertificate(Map<String, Object> generalMap) {
		return misDataService.submitUpdateDeathCertificate(generalMap);
	}

	/**
	 * ----------------------- II BED STATE ---------------------
	 * 
	 * @return
	 */

	public Map<String, Object> showIIBedStateReport(Map<String, Object> map) {
		return misDataService.showIIBedStateReport(map);
	}

	// ---------------------------------------------------------------------------------------------------------
	public MISDataService getMisDataService() {
		return misDataService;
	}

	public void setMisDataService(MISDataService misDataService) {
		this.misDataService = misDataService;
	}

	public Map<String, Object> showBedStatisticsSummaryjsp(
			Map<String, Object> map) {
		return misDataService.addDeathCertificate(map);
	}

	public Map<String, Object> chechBed(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return misDataService.chechBed(dataMap);
	}

	public List<Object> getExpiredAdmissionNumberList(
			Map<String, Object> detailsMap) {
		// TODO Auto-generated method stub
		return misDataService.getExpiredAdmissionNumberList(detailsMap);
	}

	public Map<String, Object> getHinAdNoDetailsFatalCase(
			Map<String, Object> detailsMap) {
		// TODO Auto-generated method stub
		return misDataService.getHinAdNoDetailsFatalCase(detailsMap);
	}

	public Map<String, Object> populateHinNo(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return misDataService.populateHinNo(dataMap);
	}

	public Map<String, Object> getFRWDetails(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return misDataService.getFRWDetails(dataMap);
	}

	public Map<String, Object> getHinAdNoFatalPanchanama(
			Map<String, Object> detailsMap) {
		// TODO Auto-generated method stub
		return misDataService.getHinAdNoFatalPanchanama(detailsMap);
	}

	public Map<String, Object> showDeathInformation(
			Map<String, Object> detailsMap) {
		// TODO Auto-generated method stub
		return misDataService.showDeathInformation(detailsMap);
	}

	public Map<String, Object> showEDreports(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return misDataService.showEDreports(map);
	}

	public Map<String, Object> getHinNoForDeficient(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return misDataService.getHinNoForDeficient(dataMap);
	}

	public Map<String, Object> getHinNoForSurplus(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return misDataService.getHinNoForSurplus(dataMap);
	}

	public Map<String, Object> showMisDailyReportJsp() {
		// TODO Auto-generated method stub
		return misDataService.showMisDailyReportJsp();
	}

	public Map<String, Object> getHinAdNoForND(Map<String, Object> detailsMap) {
		// TODO Auto-generated method stub
		return misDataService.getHinAdNoForND(detailsMap);
	}

	public Map<String, Object> getResponceForAME(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return misDataService.getResponceForAME(dataMap);
	}

	public Map<String, Object> getHiAdListForBD(Map<String, Object> detailsMap) {
		// TODO Auto-generated method stub
		return misDataService.getHiAdListForBD(detailsMap);
	}

	public Map<String, Object> printPMO(Map<String, Object> detailsMap) {
		return misDataService.printPMO(detailsMap);
	}

	public Map<String, Object> bedStatisticsSummary(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return misDataService.bedStatisticsSummary(dataMap);
	}

	// -------------------Total Admission in Excel Formate-----by
	// Kalyan-------------------//
	public Map<String, Object> totalAdmissionExcelSoftCopy(Box box) {
		// TODO Auto-generated method stub
		return misDataService.totalAdmissionExcelSoftCopy(box);
	}

	// -----------T.A.Excel End ---------------//

	public Map<String, Object> totalDischargeExcelSoftCopy(Box box) {
		// TODO Auto-generated method stub
		return misDataService.totalDischargeExcelSoftCopy(box);
	}

	public Map<String, Object> getTotalMisDailyReport(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return misDataService.getTotalMisDailyReport(dataMap);
	}

	public Map<String, Object> getDeliveryDetailsForSearch() {
		return misDataService.getDeliveryDetailsForSearch();
	}

	public Map<String, Object> getPatientDeliveryDetails(
			Map<String, Object> mapForDs) {
		return misDataService.getPatientDeliveryDetails(mapForDs);
	}

	public Map<String, Object> getMotherAndBabyDetails(
			Map<String, Object> mapForDs) {
		return misDataService.getMotherAndBabyDetails(mapForDs);
	}

	public Map<String, Object> getPatinetDetails(String hinNo) {
		return misDataService.getPatinetDetails(hinNo);
	}

	public Map<String, Object> getMotherBabyDeatils(Map<String, Object> mapForDs) {
		return misDataService.getMotherBabyDeatils(mapForDs);
	}

	public Map<String, Object> addMotherDetails(Map<String, Object> mapForDs) {
		return misDataService.addMotherDetails(mapForDs);
	}

	public Map<String, Object> addBabyDetails(Map<String, Object> mapForDs) {
		return misDataService.addBabyDetails(mapForDs);
	}

	public Map<String, Object> getBabyDetails(Map<String, Object> mapForDs) {
		return misDataService.getBabyDetails(mapForDs);
	}

}
