package jkt.hms.opd.dataservice;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jkt.hms.masters.business.CentralServerOpdData;
import jkt.hms.masters.business.HospitalDoctorUnitT;
import jkt.hms.masters.business.LeanServerOpdData;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.OpPatientReferral;
import jkt.hms.masters.business.PatientEpisode;
import jkt.hms.masters.business.PatientFitnessCertificate;
import jkt.hms.util.Box;

public interface OPDDataService {

	// ------------------------------------------methods writen by
	// vikas----------------------------------

	Map<String, Object> getWaitingPatientList(Map mapForDS);

	Map<String, Object> searchWaitingPatientList(Map mapForDS);

	Map<String, Object> getPatientDetails(Map map);

	Map<String, Object> getICDList(Map map);

	Map<String, Object> getOPDDetails(Map mapForDS);

	Map<String, Object> showOPDTreatmentRecords(int templateId);

	Map<String, Object> getItemListForAutoComplete(Map mapForDS);
	
	Map<String, Object> getItemListForAutoCompleteOutItem(Map mapForDS);
	
	Map<String, Object> getItemListForAutoCompleteOTC(Map mapForDS);

	Map<String, Object> getItemListForAutoCompleteIpd(Map mapForDS);

	Map<String, Object> submitOPDPatientDetails(Map mapForDS);

	Map<String, Object> showOPDInvestigationRecords(int investigationTemplateId);

	Map<String, Object> getInvestigationListForAutoComplete(Map mapForDS);

	Map<String, Object> getChargeCodeValue(String chargeCodeName,int hinId);

	Map<String, Object> getPreviousPatientVisit(Map mapForDS);

	Map<String, Object> viewPreviousVisit(Map mapForDS);

	Map<String, Object> showPatientPrevoiusPrescription(Map mapForDS);

	Map<String, Object> showPatientPrevoiusInvestigation(Map mapForDS);

	Map<String, Object> showSurgeryRequisitionJsp(Map mapForDS);

	Map<String, Object> showAjaxResponseForSurgeryRequisitionJsp(Map mapForDS);

	Map<String, Object> showSurgeryRequisitionJspForHin(Box box);

	boolean submitSurgeryRequisitionDetails(Map mapForDS);

	Map<String, Object> searchPatientDetails(Map mapForDS);

	Map<String, Object> submitSurgeryRequisitionDetailsForInpatient(Box box);

	Map<String, Object> getIcdWithIcdCode(Map mapForDS);

	// ------------------------------------------End od methods BY
	// Vikas----------------------------------

	// ----------------------------------------Methods By
	// Ritu--------------------------------------------

	Map<String, Object> submitOphthalmologyDetails(Box box);

	Map<String, Object> getPatientOphthalmologyDetails(
			Map<String, Object> parameterMap);

	Map<String, Object> getFrequencyList();

	Map<String, Object> submitOphthalmologyDiagnosis(Box box);

	Map<String, Object> getOphthalmologyDiagnosisDetails(
			Map<String, Object> parameterMap);

	Map<String, Object> submitOphthalmologyRetinal(Box box);

	Map<String, Object> getOphthalmologyRetinalDetails(
			Map<String, Object> parameterMap);

	Map<String, Object> submitOphthalmologyFollowUp(Box box);

	Map<String, Object> getOphthalmologyFollowUpDetails(
			Map<String, Object> parameterMap);

	// ----------------------------------------End of Methods by
	// Ritu----------------------------------------------

	/**
	 * --------------------------------------------Start of Methods For By
	 * Mansi-------------------------
	 *
	 */

	// ................................... Patient Allergic Drugs
	// ............................
	Map<String, Object> getPatientAllergicDrugs(int visitId);

	Map<String, Object> fillItemsInGrid(Map<String, Object> dataMap);

	Map<String, Object> getItemList(Map<String, Object> map);

	Map<String, Object> addPatientAllergicDrugs(Map<String, Object> infoMap);

	Map<String, Object> getItem();

	// ................................... Patient History
	// ............................

	Map<String, Object> getPatientHistory(int visitId);

	boolean addPatientHistory(Map<String, Object> infoMap);

	Map<String, Object> viewPatientHistory(Map<String, Object> parameterMap);

	// ................................Pediatric Vaccination Plan
	// .............................

	Map<String, Object> getPediatricVaccinationPlanJsp(int visitId);

	Map<String, Object> addPediatricVaccinationPlan(Box box);

	Map<String, Object> updatePediatricVaccinationPlan(Box box);

	// ................................... Pediatric Case Sheet
	// ............................

	Map<String, Object> getPediatricCaseSheet(int visitId);

	Map<String, Object> getImmunizationCardDetail(int visitId ,int hinId);

	Map<String, Object> addPediatricCaseSheet(Box box);

	Map<String, Object> viewPediatricCaseSheet(Map<String, Object> parameterMap);

	// ................................... OBG .............................

	Map<String, Object> showOBGJsp(int visitId);

	Map<String, Object> addOBGOne(Box box);

	Map<String, Object> updateOBG(Box box);

	Map<String, Object> addOrUpdateOBGJsp(Box box);

	Map<String, Object> viewOBGONE(Map<String, Object> parameterMap);

	Map<String, Object> viewOBGTWO(Map<String, Object> parameterMap);

	Map<String, Object> viewOBGTHREE(Map<String, Object> parameterMap);

	Map<String, Object> viewOBGFOUR(Map<String, Object> parameterMap);

	// ................................... ENT .............................

	Map<String, Object> showENTJsp(int visitId);

	Map<String, Object> addEnt(Box box);

	Map<String, Object> viewEnt(Map<String, Object> parameterMap);

	// ......................................Report...................................

	List<Object> getHinNoList(String serviceNo);

	List<Object> getVisitNoList(Map<String, Object> detailsMap);

	Map<String, Object> getConnectionForReport();

	Map<String, Object> showDailyDepartmentWiseReportJsp(Map<String, Object> map);

	Map<String, Object> showDailyOPDInvestigationsReportJsp();

	Map<String, Object> showDailyOPDPrescriptionsReportJsp(Map<String, Object> map);

	Map<String, Object> showDailyOPDRankCategoryReportJsp();

	Map<String, Object> viewPatientAllergicDrug(Map<String, Object> parameterMap);

	// -------------------------------- Cardiology Department
	// Details----------------------------

	Map<String, Object> getCardiologyDepartmentDetails(int visitId);

	boolean addCardiologyDepartmentDetails(Map<String, Object> infoMap);

	Map<String, Object> viewCardiologyDepartmentDetails(
			Map<String, Object> parameterMap);

	// -------------------------------- Gastro-Enterology
	// Endoscopy----------------------------

	Map<String, Object> getGastroEnterologyEndoscopy(int visitId);

	boolean addGastroEnterologyEndoscopy(Map<String, Object> infoMap);

	Map<String, Object> viewGastroEnterologyEndoscopy(
			Map<String, Object> parameterMap);

	// -------------------------------- Gastro-Enterology
	// Colonoscopy----------------------------

	Map<String, Object> getGastroEnterologyColonoscopy(int visitId);

	boolean addGastroEnterologyColonoscopy(Map<String, Object> infoMap);

	Map<String, Object> viewGastroEnterologyColonoscopy(
			Map<String, Object> parameterMap);

	// -------------------------------- ANTENATAL
	// CARD----------------------------

	Map<String, Object> getAntenatalCard(int visitId);
	
	Map<String, Object> getAntenatalCard2(int visitId,int hinId, Box box);

	boolean addAntenatalCard(Map<String, Object> infoMap);

	Map<String, Object> addAntenatalCard2(Map<String, Object> infoMap);

	Map<String, Object> viewAntenatalCard(Map<String, Object> parameterMap);

	Map<String, Object> updateAntenatalCard(Box box);

	Map<String, Object> getAntenatalCardEdit(int aId, int visitId);

	Map<String, Object> getGravidagramHTN(int visitId);

	boolean addGravidagramHTN(Map<String, Object> infoMap);

	Map<String, Object> viewGravidagramHTN(Map<String, Object> parameterMap);

	Map<String, Object> getGravidagramGestationalDiabitiesOne(int visitId);

	boolean addGravidagramGestationalDiabitiesOne(Map<String, Object> infoMap);

	Map<String, Object> viewGravidagramGestationalDiabitiesOne(
			Map<String, Object> parameterMap);

	Map<String, Object> getGravidagramGestationalDiabitiesTwo(int visitId);

	boolean addGravidagramGestationalDiabitiesTwo(Map<String, Object> infoMap);

	Map<String, Object> viewGravidagramGestationalDiabitiesTwo(
			Map<String, Object> parameterMap);

	/**
	 * --------------------------------------------End of Methods For By
	 * Mansi-------------------------
	 *
	 */

	String generateOrderNumber();

	Map<String, Object> addOncosurgeryCaseSheet(Box box);

	Map<String, Object> showOncosurgeryCaseSheetJsp(int visitId);

	Map<String, Object> viewOncosurgeryCaseSheet(
			Map<String, Object> parameterMap);

	Map<String, Object> addUrologyCaseSheet(Box box);

	Map<String, Object> showUrologyCaseSheetJsp(int visitId);

	Map<String, Object> viewUrologyCaseSheet(Map<String, Object> parameterMap);

	Map<String, Object> showOncosurgeryJsp(int visitId);

	Map<String, Object> addOncosurgery(Box box);

	Map<String, Object> viewOncosurgery(Map<String, Object> parameterMap);

	Map<String, Object> showPatientPreviousHinNumber(
			Map<String, Object> mapForDS);

	String getDepartmentNameFromId(int departmentId);

	Map<String, Object> viewPreviousNextVisit(Map<String, Object> mapForDS);

	Map<String, Object> getOpdTemplateDepartmentWise(int visitId);

	boolean addOpdTemplateDepartmentWise(Map<String, Object> infoMap);

	Map<String, Object> viewOpdTemplateDepartmentWise(
			Map<String, Object> parameterMap);

	Map<String, Object> viewOpdTemplateDepartmentWisePreNext(
			Map<String, Object> parameterMap);

	/** methods by abha * */
	public Map<String, Object> viewGynaecology(Map<String, Object> parameterMap);

	boolean submitSocioEconomicHistory(Map<String, Object> map);

	boolean submitComplaints(Map<String, Object> map);

	boolean submitMedicalSurgicalHistory(Map<String, Object> map);

	boolean submitGeneralExaminaton(Map<String, Object> map);

	boolean submitSystemicExamination(Map<String, Object> map);

	Map<String, Object> showUploadingDocumentsJsp(int visitId);

	Map<String, Object> submitUploadDocuments(Box box);

	Map<String, Object> viewPatientDetails(Map<String, Object> map);

	Map<String, Object> checkItem(Map<String, Object> dataMap);

	public String generatePrecriptionNo(int hinId);

	Map<String, Object> getDispensingPriceForItem(Map<String, Object> dataMap);

	Map<String, Object> getItemBrandName(Map<String, Object> dataMap) ;

	Map<String, Object> getItemBrandManufacturerName(Map<String, Object> dataMap);

	Map<String, Object> getDrugTypeOfItem(Map<String, Object> dataMap);

	Map<String, Object> getPhysiotherapistList(Map<String,Object> dataMap);

	Map<String, Object> getPhysiotherapistPatientList(Map<String,Object> dataMap);

	boolean submitOPDPhysiotherapyJsp(Box box);

	Map<String, Object> addImmunizationCard(Box box,Map<String,Object> dataMap);

	@SuppressWarnings("unchecked")
	Map<String, Object> getDepartmentName(Map mapForDS);

	@SuppressWarnings("unchecked")
	Map<String, Object> getTokenNumber(Map tokenMap);

	Map<String, Object> getMasChargeCode();

	Map<String, Object> getChargeCodeDetails(String chargeCode, int hinId);

	//--------- By Mansi
	Map<String, Object> showPreviousSystemPatientPrescriptions(Map<String, Object> mapForDS);

	Map<String, Object> showPopupTokenJsp(Map<String, Object> mapForDS);
	
	Map<String, Object> showTreatment(Map<String, Object> map);
	
	Map<String, Object> showTreatmentPopUp(Map<String, Object> map);
	
	Map<String, Object> getPhysiotherapyPreviousDetails(Map<String, Object> map);
	
	Map<String, Object> updateVistToken(Map<String, Object> mapForToken);

	Map<String, Object> getPhysiotherapistPatientList1(	Map<String, Object> mapForDS);

	Map<String, Object> getPreviousStudentVisit(Map<String, Object> mapForDS);

	Map<String, Object> getstudentDetail(Map<String, Object> detailsMap);

	Map<String, Object> getstudentDetail1(Map<String, Object> detailsMap);

	Map<String, Object> submitforPhysio(int empId, int deptId,int hinId);

	Map<String, Object> submitforPhysio(int deptId);

	Map<String, Object> showreferralPatientJsp(int deptId);

	Map<String, Object> searchPatient(String hinNo);

	boolean submitReferalPatient(OpPatientReferral opPatientReferral);

	boolean submitPatientForFitness(PatientFitnessCertificate fitness);

	Map<String, Object> showWaitingforBillingPhysiotherapyPatientList();

	Map<String, Object> getPatientDetailsForJSSK(Map<String, Object> mapForDs);

	boolean updateBills(int inpatientId);

	Map<String, Object> searchPatientForMLC(Map<String, Object> mapForDs);
	
	Map<String, Object> getSnomedCTDetails(Map mapForDs);
	
	Map<String, Object> savePataientPreConsultationAssessment(Box box, Map map);
	
	Map<String, Object> nextWaitingPatient(Map map);
	
	Map<String, Object> showPopUpPresentComplaint(Map<String, Object> dataMap);

	Map<String, Object> showPopUpFamilyHistory(Map<String, Object> dataMap);

	Map<String, Object> showPopUpHistoryOfPastIllness(
			Map<String, Object> dataMap);

	Map<String, Object> showPopUpPersonalHistory(Map<String, Object> dataMap);

	Map<String, Object> showPopUpMedicationHistory(Map<String, Object> dataMap);

	Map<String, Object> autoCompleteForDiagnosis(Map<String, Object> dataMap);
	
	Map<String, Object> showPopUpGeneralExamination(Map<String, Object> dataMap);

	Map<String, Object> showPopUpSystemicExamination(Map<String, Object> dataMap);
	
	Map<String, Object> getSecondOpinion(Map<String, Object> map);
	
	Map<String, Object> getPatientVisitDetails(Map<String, Object> map);

	Map<String, Object> showPopUpLocalExamination(Map<String, Object> dataMap);
	
	Map<String, Object> submitSecondOpinion(Map<String, Object> dataMap);

	Map<String, Object> getDistrictHospital(Map<String, Object> dataMap);
	
	Map<String, Object> getHospitalDepartment(Map<String, Object> dataMap);
	
	Map<String, Object> getDoctorDepartment(Map<String, Object> dataMap);

	Map<String, Object> showUploadingDocumentsJsp(int visitId, int inpatientId,
			Map<String, Object> mapForDS);
	
	Map<String, Object> showDiagnosis(Map<String, Object> map);
	
	Map<String, Object> showDiagnosisPopUp(Map<String, Object> map);
	
	Map<String, Object> submitDifferentialDiagnosis(String arr[]);
	
	Map<String, Object> getDrugAndProcedureDetails(Map<String, Object> map);
	
	Map<String, Object> getPatientVitalTrends(Map<String, Object> map);
	
	Map<String, Object> getPayward(Map<String, Object> map);
	
	Map<String, Object> getObservationWardAdmissionWaitingList(Map<String, Object> map);
	
	Map<String, Object> opdPatientObservationStatus(Map<String, Object> map);
	
	Map<String, Object> getOPNursingCareWaitingList(Map<String, Object> map);
	
	Map<String, Object> getObservationWard(Map<String, Object> map);

	Map<String, Object> submitPrescriptionTamplate(Box box);

	Map<String, Object> submitInvestigationTamplate(Box box);
	
	Map<String, Object> getNursingCareProcedureAutoList(Map<String, Object> map);
	
	Map<String, Object> getProcedureOrder(Map<String, Object> map);
	
	Map<String, Object> getPrescriptionTemplate(Box box);
	
	Map<String, Object> submitProcedureOrder(Map<String, Object> map);
	
	Map<String, Object> getLabInvestigationTemplate(Box box);
	
	Map<String, Object> showDiseaseFeatures(Box box);
	
	void getChangeVisitStatus(Integer visitId);
	
	Map<String, Object> showDepartmentSpeciality(Map<String, Object> map);
	
	Map<String, Object> submitSnomedTemplates(Map<String, Object> map);
	
	boolean changeVisitStatus(Map<String, Object> map);

	Map<String, Object> showDisplayImagesJsp(Map<String, Object> mapForDS);

	Map<String, Object> submitImagesList(Map<String, Object> map,Box box);
	
	Map<String, Object> openImageForDisplay(int imageId,int hospitalId,int deptId);
	
	Map<String, Object> showObervationPatientList(Map<String, Object> map);
	
	Map<String, Object> saveAndGetTempComorbidity(Map<String, Object> map);
	
	Map<String, Object> submitCantraDrugAndDiesease(Box box);
	
	Map<String, Object> checkDrugCantraIndicative(Map<String, Object> map);
	
	Map<String, Object> showVaccineDetailJsp(Box box) ;
	
	Map<String, Object> displayAU(Map<String, Object> dataMap);
	
	Map<String, Object> getItemListForAutoCompleteAllergy(Map<String, Object> map);

	Map<String, Object> submitNursingCare(Box box);

	Map<String, Object> showToeknDisplayForNurseJsp(Map<String, Object> mapForDS);
	
	Map<String, Object> submitObservationWard(Map<String, Object> map,Box box);
	
	Map<String, Object> patientDischargeAndAdmit(Map<String, Object> map);
	
	Map<String, Object> referObservationToOpd(Map<String, Object> map);
	
	Map<String, Object> checkInvestigationItem(Map<String, Object> map);
	
	Map<String, Object> checkInvestigationItemIsBlocked(Map<String, Object> map);
	
	Map<String, Object> showSecondOpnionListJsp (Map<String, Object> map);
	
	Map<String, Object> checkItemStockQty(Map<String, Object> map);
	
	Map<String, Object> getPendingInjectionList(Box box,Date FromDate,Date ToDate,int hospitalId);
	
	Map<String, Object> getItemBatch(Box box);
	
	Map<String, Object> getpatientRefered(Box box);
	
	
	Map<String, Object> getInjectionDetailsForAppointment(Box box);
	
	Map<String, Object> issueInjectionFromReception(Box box);
	
	Map<String, Object> saveInjectionRegisterDetails(Box box);
	
	Map<String, Object> saveInjectionAppointment(Box box);
	
	Map<String, Object> deleteOPDdetails(Box box);
	
	Map<String, Object> populateSecondOpinionForm(Map<String, Object> dataMap);
	
	Map<String, Object> updatSecondOpinionPatient(Box box);

	Map<String, Object> getICDListwithID(Map<String, Object> map);
	
	Map<String, Object> getTemplate(Box box);
	
	Map<String,Object> getDataForServer();
	
	Map<String,Object> getDataForLeanServer();
	
	String updateCentralServerOPDData(CentralServerOpdData centralServerOpdData); 
	
	String updateLeanServerOPDData(LeanServerOpdData leanServerOpdData); 
	
	Map<String, Object> getDetailsForProcWaitList(int hospitalId, int visitId);
	
	Map<String, Object> getRouteAutoList(Map<String, Object> map);

	Map<String, Object> getSnomedList(Map<String, Object> map);

	Map<String, Object> getICDListBasedOnSnomedId(Map<String, Object> map);
	
	Map<String, Object> getOPClinicalReadViewList(Map mapForDS);
	
	Map<String, Object> removeCantraDrugs(Map<String, Object> map);
	
	Map<String, Object> removeCantraDisease(Map<String, Object> map);

	Map<String, Object> getBedStatus(int deptId, int hospitalId);

	Map<String, Object> getLoincSnomedList(Map<String, Object> map);
	
	Map<String, Object> populatMasInstitute(Map<String, Object> dataMap);

	Map<String, Object> getInvestigationListForAutoComplete1(Map mapForDS);

	Map<String, Object> getTodayOtherPrescription(int hinId, int visitId);

	Map<String, Object> getItemForAllergy(String itemCode, int visitId);
	
	Map<String, Object> showGroupAndParameterValues(Map map);
	
	Map<String, Object> saveSpeciality(Map map,Box box);
	
	Map<String,Object> getdeadPatientDetails(Map<String, Object> map);
	
	boolean submitExpiryDetails(Map<String,Object> map);
	
	Map<String,Object> printExpiryDetails(Map<String,Object> map);

	void saveComorbidity(Map map,Map<Integer,Integer> savedIcd);
	
	Map<String, Object> getOpdOphthalmology(int visitId);

	Map<String, Object> uploadAndViewDocuments(Map<String, Object> details);

	Map<String, Object> showPoliceIntimationDetail(int hospitalId);

	Map<String, Object> displayPoliceIntimationDetail(Box box);

	Map<String, Object> submitPoliceIntimationDetail(Box box);

	Map<String, Object> saveNursingCare(Box box);

	Map<String, Object> getProcedureDetailsForPopUp(Box box);
	
	Map<String, Object> checkForAlreadyIssuedPrescribtion(String itemCode, int visitId,int hospitalId);

	String getHinNo(int visitId);

	Map<String, Object> doPatientRelease(Map<String, Object> dataMap);

	int getOrderId();
	
	Map<String, Object> openVideoForDisplay(int imageId);

	Map<String, Object> displayTravelHistory(Box box);
	
	Map<String, Object> getOutpatientListForSchemeChange(Map<String, Object> dataMap);
	
	Map<String, Object> updatePatientScheme(Box box);
	
	Map<String, Object> showNCDPattern(Box box);
	
	Map<String, Object> showRNTCPDetail(Box box);
	
	Map<String, Object> showFpisRecord(Box box);
	
	void displayCurrentPatientToken(Map map);
	
	Map<String, Object> getWaitingQueue(Map<String, Object> mapForDS);
	
	Map<String, Object> getWaitingQueueJspData(Map<String, Object> mapForDS);
	
	Map<String, Object> showPopupTokenList(Map<String, Object> mapForDS);
	
	Map<String, Object> saveNicuCaseRecord(Map<String, Object> mapForDS, Box box);
	
	Map<String, Object> saveDeaddictionCentre(Box box);
	
	Map<String, Object> checkMappedCharge(Map<String, Object> map);
	
	
	 
	 Map<String, Object> referBackNursingPatientToOpd(Map<String, Object> map);
	 
	Map<String, Object> saveENTExamination(Box box);
	
	Map<String, Object> getPatientAndEpisodeList(String hinNo);//added by govind
	
	List<PatientEpisode> getPatientEpisodeList(String hinNo);
	
	Map<String, Object> getPatientEpisodeDetails(Box box);

	Map<String, Object> saveLeprosyProforma(Box box);
	
	List<MasStoreItem> getItemIdFromPVMS(String pvmsNo);
	//added by govind 15-9-2016
	Map<String, Object> updatePrescriptionTamplate(Box box);
	Map<String, Object> deletePrescriptionTamplate(Box box);

	Map<String, Object> savePsychogeriatricClinic(Box box);

	Map<String, Object> saveMedicine(Box box);

	Map<String, Object> saveOrthopedicsSpeciality(Box box);
	
	Map<String, Object> getIpDeapartmentMappings(Box box);
	
	Map<String, Object> addIpDepartmentsMapping(Map<String, Object> mapForDs);
	
	Map<String, Object> editIpDepartmentsMapping(Map<String, Object> mapForDs);
	
	Map<String, Object> deleteIpDepartmentsMapping(Map<String, Object> mapForDs);

	Map<String, Object> saveRespiratoryClinic(Box box,Map<String, Object> generalMap);

	Map<String, Object> saveGeneralProforma(Box box,Map<String, Object> generalMap);


	Map<String, Object> getSpecialityTemplateName(Box box);
	
	String getAntenatalCardStatus(int hinId);
	
	 Map<String, Object> getHospitalData(Map<String, Object> objectMap);

	String getHospitalName(Integer hospitalId);

	Map<String, Object> showPatientLabResult(Box box);

	Map<String, Object> displayLabTest(Box box);
	
	Map<String, Object> checkForExistingDisplayName(Box box);
	
	Map<String, Object> getServiceCenters(Box box);
	
	Map<String, Object> getDisplayDepartmentType(Map<String,Object> mapForDS);

	Map<String, Object> getQueueListParticularDoctor(Box box);

	Map<String, Object> getTokenXML(Map<String, Object> mapForDS);

	Map<String, Object> bookCounterForDoctor(Box box);

	String getAntenatalCardVisitStatus(int visitId);

	Map showGroupAndParameterValuesNew(Map generalMap);

	Map<String, Object> getANCSummary(Box box);
	
	Map<String, Object> saveOralMedicine(Map<String, Object> mapForDS, Box box, HttpServletRequest request);

	Map<String, Object> savePreAssessmentClinic(Map<String, Object> mapForDS, Box box, HttpServletRequest request);

	Map<String, Object> submitOutsideLab(Box box);
	
	Map<String, Object> saveMaxillofacialTraumaProforma(
			Map<String, Object> mapForDS, Box box, HttpServletRequest request);
	
	Map<String, Object> saveCaseRecordOfPeriodontics(
			Map<String, Object> mapForDS, Box box, HttpServletRequest request);

	Map<String, Object> showOralAndMaxillofacialSurgery();
	
	Map<String, Object> saveOralAndMaxillofacialSurgery(
			Map<String, Object> mapForDS, Box box, HttpServletRequest request);
	
	Map<String, Object> saveImplantPlanning(Map<String, Object> mapForDS,Box box, HttpServletRequest request);
	
	Map<String, Object> saveRemovablePartialProsthodontics(
			Map<String, Object> mapForDS, Box box, HttpServletRequest request);
	
	Map<String, Object> saveFixedProsthodontics(Map<String, Object> mapForDS,
			Box box, HttpServletRequest request);
	
	Map<String, Object> saveEndodontics(Map<String, Object> mapForDS, Box box,	HttpServletRequest request);

	Map<String, Object> saveDiagnosticRecord(Map<String, Object> mapForDS,
			Box box, HttpServletRequest request);

	Map<String, Object> saveMaxillofacialProsthesis(
			Map<String, Object> mapForDS, Box box, HttpServletRequest request);
	
	Map<String, Object> saveCommunityOralHealthCaseHistory(Map<String, Object> mapForDS, Box box, HttpServletRequest request);

	Map<String, Object> savePedodonticsVitalStatistics(
			Map<String, Object> mapForDS, Box box, HttpServletRequest request);

	Map<String, Object> saveOralMedicinePathology(Map<String, Object> mapForDS,
			Box box, HttpServletRequest request);
	Map<String, Object> getDoctorUnit(Map<String, Object> map);
	List<HospitalDoctorUnitT> getUnitDoctors(String unitId);
	
	Map<String, Object> savePsCaseRecordOrthodotics(Map<String, Object> mapForDS, Box box, HttpServletRequest request);
	

	Map<String, Object> showRespiratoryClinicJsp(Box box);

	Map<String, Object> showInfertilityClinic(int visitId, int hinId);

	Map<String, Object> submitInfertilityClinic(Map<String, Object> mapForDS,
			Box box, HttpServletRequest request);

	Map<String, Object> getClinicalSummaryHistoryData(Box box);

	Map<String, Object> getClinicalSummaryDetail(Box box);

	Map<String, Object> showTaperdMedicine(Box box);

	Map<String, Object> getAllValidatedTestForLabOrderNoWise(
			Map<String, Object> requestParameters);

	
	Map<String, Object> printNicuCaseRecord(Map<String, Object> mapForDS);

	Map<String, Object> printHeightWeightGraph(
			Map<String, Object> requestParametersMap);
	
	Map<String, Object> showNicuCaseRecordJsp(Box box);

	Map<String, Object> printHeightWeightHeadCircumferenceGraph(
			Map<String, Object> requestParametersMap);

	Map<String, Object> printWeightPercentiles(
			Map<String, Object> requestParametersMap);

	Map<String, Object> printHeightPercentiles(
			Map<String, Object> requestParametersMap);

	Map<String, Object> printHeadCircumferencePercentiles(
			Map<String, Object> requestParametersMap);

	Map<String, Object> printGrowthRecord(
			Map<String, Object> requestParametersMap);
	
	Map<String, Object> getMedicineTemplateDetails(Box box);

	
	Map<String, Object> showOutSideResultEntryForAntenatal(Map<String, Object> requestParametersMap);
	Map<String, Object> saveOutSideResultEntryForAntenatal(Map<String, Object> requestParametersMap);

	Map<String, Object> showOrthopedicJsp(
			Map<String, Object> requestParametersMap);
	
	Map<String, Object> getContactLensTemplateDetails(Box box);

	Map<String, Object> saveContactLensTemplate(Box box);

	Map<String, Object> showAudiologicalExaminationJsp(
			Map<String, Object> requestParametersMap);
	
	Map<String, Object> saveAudiologicalExamEntSpeciality(Box box);

	Map<String, Object> showNephrologyCaseSheetJsp(
			Map<String, Object> requestParametersMap);  
	
	Map<String, Object> saveNephrologyCaseSheetJsp(Box box); 
	
	
	Map<String, Object> saveGynecologyCaseSheet(Map<String, Object> mapForDS,
			Box box);

	Map<String, Object> showDermatologyLeprosyProformaJsp(
			Map<String, Object> requestParametersMap);

	Map<String, Object> showOutSideResultEntryDermotology(
			Map<String, Object> requestParametersMap);

	Map<String, Object> showDermatologyGeneralProformaJsp(
			Map<String, Object> requestParametersMap);

	Map<String, Object> saveOutSideResultEntryForDermotology(
			Map<String, Object> requestParametersMap);
	
	Map<String, Object> getPhototherapyProformaDetails(Box box);

	Map<String, Object> savePhototherapyProforma(Map<String, Object> mapForDS, Box box, HttpServletRequest request); 

	Map<String, Object> showFamilyPlanningGynecologyJsp(
			Map<String, Object> requestParametersMap);  
	
	Map<String, Object> saveFamilyPlanningGynecologyJsp(Box box);

	Map<String, Object> showGeneralPsychiatricCaseRecord(Box box);
	
	Map<String, Object> saveGeneralPsychiatricCaseRecord(Map<String, Object> mapForDS, Box box);

	Map<String, Object> showOutSideLabResultEntry(
			Map<String, Object> requestParametersMap);
	
	Map<String, Object> getMLCFromRefered();
	
	Map<String, Object> htmlTemplateRpt(Map<String, Object> mapForDS);
	
	Map<String, Object> showDeaddictionCentreJsp(Map<String, Object> requestParametersMap);
	Map<String, Object> showPsychogeriatricClinicJsp(Map<String, Object> requestParametersMap);
	
	Map<String, Object> getFixedInvestigations();
	
	Map<String, Object> getMemberDetails(Map map);

	Map<String, Object> checkForBlockedMedicine(Map<String,Object> dataMap);
	void unBlockMedicine(int medicineTableId);
	
	Map<String, Object> setVisitUptoTimeOfDoctor(Box box);
	
	Map<String, Object> getDrWiseWaitingQueue(Map<String, Object> mapForDS);
	
	Map<String, Object> getmasAdministrativeSexList();

	Map<String, Object> printBMIChart(Map<String, Object> requestParametersMap);
	
	
	Map<String, Object> getprescriptionListHTML(Map<String, Object> mapForDS);
	
	Map<String, Object> getInvestigationionHTML(Map<String, Object> mapForDS);
	
	Map<String, Object> printANCHtml(Map<String, Object> mapForDS);
	
	Map<String, Object> transferToCommonPool(Box box);
	
	Map<String, Object> saveHemoDialysis(Map<String, Object> infoMap);

	Map<String, Object> showHemoDialysis(Map<String, Object> requestMap);
	Map<String, Object> getVitalDetails(Map<String, Object> requestMap);
	
	Map<String, Object> getDoctorSpecificPatientList(Map<String, Object> mapForDS);

	Map<String, Object> getSubParameterDetails(Map<String, Object> generalMap);

	Map<String, Object> displaySubParameterResult(Box box);

	Map<String, Object> showENTExaminationJsp(Box box);

	Map<String, Object> viewENTExaminationImages(Box box);

	Map<String, Object> displayDateWiseENTImages(Box box);

	
	Map<String, Object> getFamilyTreeDetails(Map<String, Object> mapForDS);
	
	Map<String, Object> submitFamilyTreeMembers(Map<String, Object> mapForDS);

	Map<String, Object> checkForDuplicateExternalTest(Map<String, Object> map);
}

