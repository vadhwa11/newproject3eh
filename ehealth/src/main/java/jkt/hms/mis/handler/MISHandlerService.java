package jkt.hms.mis.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.util.Box;

public interface MISHandlerService {
	// -------------------------------- ED Return form
	// ------------------------------
	Map<String, Object> showEDReturnsJsp();

	Map<String, Object> showEDReturns(String toDate, String fromDate,
			String category, String edStatus);

	boolean editEDReturnsToDatabase(Map<String, Object> generalMap);

	// -------------------------------- ED Return Report form
	// -----------------------
	Map<String, Object> showEDreportsjsp();

	Map<String, Object> searchEDReturn(Date toDate, Date fromDate,
			String category);

	// ---------------------------- Patient Movement Order Report form
	// --------------
	Map<String, Object> showPatientMovementOrderjsp();

	Map<String, Object> searchPatientMovementOrder(String disposal,
			String serviceNo);

	// ------------------------------- Afmsf-1 Def
	// -------------------------------
	boolean editAfmsfDef(Map<String, Object> generalMap);

	Map<String, Object> showAfmsfDefjsp();

	Map<String, Object> showAfmsfDef(Map<String, Object> map);

	// ------------------------------- Afmsf-1 Surplus
	// -------------------------------
	Map<String, Object> showAfmsfSurplusjsp();

	Map<String, Object> showAfmsfSurplus(Map<String, Object> map);

	boolean editAfmsfSurplus(Map<String, Object> generalMap);

	// --------------------- Afmsf-1 Annual Medical Examination
	// ------------------
	Map<String, Object> showAfmsfAnnualMedicalExaminationjsp();

	Map<String, Object> showAfmsfAnnualMedicalExamination(String serviceNo);

	Map<String, Object> editAfmsfAnnualMedicalExamination(
			Map<String, Object> generalMap);

	Map<String, Object> showFatalCasejsp(int inpatientid);

	boolean editFatalcase(Map<String, Object> generalMap);

	Map<String, Object> showTotalAdmissionjsp();

	Map<String, Object> searchTotalAdmission(Date fromDate, Date toDate,
			String serviceType);

	Map<String, Object> showTotalDischargejsp();

	Map<String, Object> searchTotalDischarge();

	Map<String, Object> showMonthlySickReportsjsp();

	Map<String, Object> showMonthlySickDischargeReportjsp();

	List<Object> getAdmissionNoList(Map<String, Object> detailsMap);

	List<Object> getHinNoList(String serviceNo);

	Map<String, Object> getDBConnection();

	/**
	 * -------------------------------- FRW CASES
	 * -------------------------------
	 * 
	 * @return
	 */
	Map<String, Object> showFrwCases();

	Map<String, Object> submitFrwCases(Map<String, Object> generalMap);

	/**
	 * ------------------------ NOTIFIABLE DISEASE ENTRY FORM
	 * ------------------------
	 */

	Map<String, Object> showNotifiableDiseaseJsp(Map<String, Object> generalMap);

	Map<String, Object> showNotifiableDisease(Map<String, Object> generalMap);

	boolean editNotifiableDisease(Map<String, Object> generalMap);

	/**
	 * ------------------------ NOTIFIABLE DISEASE REPORT FORM
	 * ------------------------
	 */
	Map<String, Object> showNotifiableDiseaseReportJsp();

	/**
	 * ------------------------ MALARIA CASE REPORT ------------------------
	 */
	Map<String, Object> showMalariaCaseReportJsp();

	// -------------------------------- Bed Statistics Report form
	// -----------------------
	Map<String, Object> showBedStatisticsSummary();

	// --------------------------Daily Ward Wise Bed
	// Status---------------------------------

	Map<String, Object> showDailyBedStatusReport();

	// ---------------------Birth Certificate--------------------------------

	Map<String, Object> showBirthCertificateJsp();

	Map<String, Object> addBirthCertificate(Map<String, Object> generalMap);

	List<Object> getMotherHin(String serviceNo);

	// ------------------Death Certificate--------------------------------------
	Map<String, Object> showDeathCertificateJsp();

	Map<String, Object> showBirth(int inpatientId);

	Map<String, Object> generateRegNumber(Map<String, Object> regMap);

	Map<String, Object> showDeath(int inpatientid);

	Map<String, Object> getConnectionForReport();

	Map<String, Object> addDeathCertificate(Map<String, Object> generalMap);

	List<Object> getExpiredHin(String serviceNo);

	boolean submitUpdateDeathCertificate(Map<String, Object> generalMap);

	Map<String, Object> showUpdateDeathCertificate(Map<String, Object> map);

	Map<String, Object> showBedStatisticsSummaryjsp(Map<String, Object> map);

	Map<String, Object> showBedStatisticsDetailReport(Map<String, Object> map);

	Map<String, Object> showUpdateBirthCertificate(Map<String, Object> map);

	boolean submitUpdateBirthCertificate(Map<String, Object> generalMap);

	Map<String, Object> showIIBedStateReport(Map<String, Object> map);

	Map<String, Object> chechBed(Map<String, Object> dataMap);

	List<Object> getExpiredAdmissionNumberList(Map<String, Object> detailsMap);

	Map<String, Object> getHinAdNoDetailsFatalCase(
			Map<String, Object> detailsMap);

	Map<String, Object> populateHinNo(Map<String, Object> dataMap);

	Map<String, Object> getFRWDetails(Map<String, Object> dataMap);

	Map<String, Object> getHinAdNoFatalPanchanama(Map<String, Object> detailsMap);

	Map<String, Object> showDeathInformation(Map<String, Object> detailsMap);

	Map<String, Object> showEDreports(Map<String, Object> map);

	Map<String, Object> getHinNoForDeficient(Map<String, Object> dataMap);

	Map<String, Object> getHinNoForSurplus(Map<String, Object> dataMap);

	Map<String, Object> showMisDailyReportJsp();

	Map<String, Object> getHinAdNoForND(Map<String, Object> detailsMap);

	Map<String, Object> getResponceForAME(Map<String, Object> dataMap);

	Map<String, Object> getHiAdListForBD(Map<String, Object> detailsMap);

	Map<String, Object> printPMO(Map<String, Object> detailsMap);

	Map<String, Object> bedStatisticsSummary(Map<String, Object> dataMap);

	// -------------------Total Admission in Excel Formate-----by
	// Kalyan-------------------//
	Map<String, Object> totalAdmissionExcelSoftCopy(Box box);

	Map<String, Object> totalDischargeExcelSoftCopy(Box box);

	Map<String, Object> getTotalMisDailyReport(Map<String, Object> dataMap);

	// -----------T.A.Excel End ---------------//

	Map<String, Object> getDeliveryDetailsForSearch();

	Map<String, Object> getPatientDeliveryDetails(Map<String, Object> mapForDs);

	Map<String, Object> getMotherAndBabyDetails(Map<String, Object> mapForDs);

	Map<String, Object> getPatinetDetails(String hinNo);

	Map<String, Object> getMotherBabyDeatils(Map<String, Object> mapForDs);

	Map<String, Object> addMotherDetails(Map<String, Object> mapForDs);

	Map<String, Object> addBabyDetails(Map<String, Object> mapForDs);

	Map<String, Object> getBabyDetails(Map<String, Object> mapForDs);

}