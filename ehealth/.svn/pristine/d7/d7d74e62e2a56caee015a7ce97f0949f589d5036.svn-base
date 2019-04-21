package jkt.hms.ipd.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.BioWasteDisposal;
import jkt.hms.masters.business.IpdHandTakeOver;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.PatientEpisode;
import jkt.hms.masters.business.TempCheckInOutFinal;
import jkt.hms.util.Box;
@SuppressWarnings("unchecked")
public interface IPDHandlerService {
	Map<String, Object> getPatientList(int deptId,int hospitalId,int userId);

	Map<String, Object> searchPatient(Map map);

	Map<String, Object> nursingCareSetup(Box box);

	boolean addNursingCare(Box box);

	Map<String, Object> showFoodTesting(int deptId);

	boolean insertFoodTestingDetails(Map map);

	Map<String, Object> showCaresList(Box box);

	Map<String, Object> getPatientListOnBasisOfCare(Map<String, Object> dataMap);

	Map<String, Object> searchPatientOnBasisOfCare(Box box);

	boolean submitNursingCareEntryDetails(Box box);

	Map<String, Object> showWardList(int deptId,int hospitalId);

	Map<String, Object> showWardConsumptionJsp(Map map);

	Map<String, Object> showStockDetailsJsp(Map map);

	boolean submitWardConsumptionDetails(Map map);

	Map<String, Object> modifyWardConsumptionJsp(Map map);

	boolean deleteStockDetails(Map map);

	Map<String, Object> showPatientIssueJsp(Map map);

	boolean submitPatientIssueDetails(Map map);

	Map<String, Object> viewPatientIssueDetails(Map map);

	Map<String, Object> getItemList(Map map);

	Map<String, Object> fillItemsInGrid(Map map);

	Map<String, Object> showPatientDiagnosisJsp(Map map);

	Map<String, Object> getICDList(Map map);

	boolean addPatientDiagnosisInformation(Map map);

	Map<String, Object> showSilDilJsp(Map map);

	Map<String, Object> getConnectionForReport();

	boolean submitSilDilStatus(Map map);

	// -------------------------------------NursingClinicalChart-------------------------------
	Map<String, Object> showNursingClinicalChartJsp(Box box);

	boolean addNursingClinicalChart(Box box);

	Map getViewClinicalChart(Map<String, Object> dataMap);

	// ------------------------------------------IntakeOutput-------------------------
	Map<String, Object> showIntakeOutputJsp(int inPatient);

	Map<String, Object> showIntakeOutputChartReport(Map<String, Object> requestParameters);

	Map<String, Object> addIntakeOutput(Box box);

	Map getViewIntakeOutput(String radio_str);

	Map<String, Object> getAdmissionNumberList(	Map<String, Object> requestParameters);

	List<Object> getAdmissionNoList(Map<String, Object> detailsMap);

	List<Object> getHinNoList(String serviceNo);

	// --------------------------Reports---------------------------

	Map<String, Object> showFoodTastingReportJsp(int hospitalId);

	Map<String, Object> showNursingCareReportJsp(Map<String, Object> dataMap);

	Map<String, Object> getDBConnection();

	Map<String, Object> getSearchPatientComboDetails(Map<String, Object> requestParameters);

	String getMothersName(String hinNo);

	List<Object> getHinNo(String serviceNo);

	boolean submitWardConsumptionIssueDetails(Map<String, Object> map);

	Map<String, Object> getItemListForWardConsume(Map<String, Object> map);

	Map<String, Object> showDutyNursingReportJsp();

	Map<String, Object> getDiagnosisAndDocumentInit(Map<String, Object> dataMap);

	Map<String, Object> getICDCodeList(Map<String, Object> map);

	Map<String, Object> showWaitingList(Map<String, Object> dataMap);

	Map<String, Object> submitWaitingList(Map<String, Object> dataMap);

	Map<String, Object> getWardRemarksDetails(Map<String, Object> dataMap);

	Map<String, Object> saveWardRemarks(Map<String, Object> dataMap);

	Map<String, Object> getIpIdFormDischargeId(Map<String, Object> tempMap);

	int getInpatientId(String adNo, String hinNo);

	Map<String, Object> showDischargeStatusWiseReport();

	Map<String, Object> getDoctorList();

	boolean saveMessageForDoctors(Box box);

 	Map<String, Object> showHandTakeJsp(Map<String, Object> map);

	String getEntrySeqForDisplay(String string);

	String generateEntryNumber();

	boolean submitHandTakeOver(Box box);

	Map<String, Object> showHandTakeOverReportJsp();

	Map<String, Object> viewHandTakeOver(Map<String, Object> infoMap);

	Map<String, Object> showPrescriptionJsp(Map<String, Object> map);

	Map<String, Object> submitPrescriptionDetails(Map<String, Object> map);

	Map<String, Object> showInPatientPreviousPrescription(Map mapForDS);

	Map<String, Object> getItemStock(Map<String, Object> dataMap);

	Map<String, Object> getItemClosingStock(Map<String, Object> dataMap);

	Map<String, Object> showSendSmsJsp(Map<String, Object> mapDetail);

	Map<String, Object> submitSendSms(Map<String, Object> mapDetail);

	Map<String, Object> showWardWiseDetails(int deptId,int hospitalId);

	Map<String, Object> getItemListForAutoCompleteIpd(Map<String, Object> map);

	List<TempCheckInOutFinal> getNumberOfUser(String year, String month);

	Map<String, Object> getQuery(String year,String month,String days);

	Map<String, Object> showEmployee(int empCategoryId,int hospitalId);

	List<MasEmployee> getEmplist(int empCategoryId,int hospitalId);

	String getMobileNo(int employeeId);

	Map<String, Object> showWardRemarksJsp(int inpatientId);

	Map<String, Object> showProgressNoteJsp(Map<String, Object> mapForDs);

	Map<String, Object> saveProgressNotes(Map<String, Object> dataMap);

	Map<String, Object> getProgressNoteDetails(Map<String, Object> dataMap);

	Map<String, Object> updateMLCData();

	Map<String, Object> getPhysiotherapistPatientList(
			Map<String, Object> mapForDS);

	String getDepartmentNameFromId(int deptId);

	Map<String, Object> getPhysiotherapistList(Map<String, Object> mapForDS);

	Map<String, Object> getDialysisPatientList(Map<String, Object> mapForDS);

	Map<String, Object> getDialysisPatientList1(Map<String, Object> mapForDS);

	Map<String, Object> getPatientDetailsForAdvance(Map<String, Object> mapForDs);

	String generateReceiptNo(String string);

	Map<String, Object> getSystemParamDetails();
	
	
	public Map<String, Object> getPatientDetailsForKitIssue(Box box);
	
	Map<String, Object> getPatientLatestDiagnosisAndDisability(int inpatientId);
	
	Map<String, Object> showNewCaseSheetJsp(Box box);
	
	Map<String, Object> showMedicineIssueDetailJsp(Box box);
	
	Map<String, Object> getDetailOfWaitingInPatient(Map<String, Object> mapForDs);
	
	Map<String, Object> patientAdmissionAccept(Map<String, Object> mapForDs);

	Map<String, Object> getTemplateDetails(Box box);

	Map<String, Object> submitPatientKitIssue(Box box);

	Map<String, Object> submitIpdCaseSheetDetails(Box box, Map<String, Object> generalMap);

	Map<String, Object> searchNextOfKinPatient(Box box);

	Map<String, Object> showCreateVirtualBed(Box box);

	Map<String, Object> submitCreateVirtualBed(Box box);
	
	Map<String, Object> getItemUnit(Box box);

	Map<String, Object> showPatientDetails(Map<String, Object> dataMap);
	
	Map<String, Object> getPatientAllergy(Box box);
	
	Map<String, Object> submitPatientAllergy(Box box);

	Map<String, Object> getPrescriptionListForPatient(Box box);

	boolean submitWardConsumption(Box box);

	boolean checkBedStatus(int bedId);

	Map<String, Object> getDetailsForBedTransferAcceptance(Box box);

	Map<String, Object> submitWardTransferAcceeptance(Box box);

	Map<String, Object> getCareTransferAccepJsp(Box box);

	Map<String, Object> submitcareTransferAcceeptance(Box box);

	Map<String, Object> showWardConsList(int deptId,int hospitalId);

	boolean submitWardConsDetails(Map<String, Object> map);

	Map<String, Object> getNursingCareSttus(Box box);

	Map<String, Object> showAmbulanceRunRegister(Box box);
	
	Map<String, Object> saveAmbulanceRunRegisterDetails(Box box);

	Map<String, Object> getProcedureForDischargeSummary(
			Map<String, Object> detailsMap);

	Map<String, Object> getTreatmentDetailsForDischargeSummary(
			Map<String, Object> detailsMap);

	Map<String, Object> getDetailForDietSchedule(Box box);

	Map<String, Object> getDietItemForAutoComplete(
			Map<String, Object> detailsMap);

	Map<String, Object> getDietCombinationItems(Map<String, Object> detailsMap);

	Map<String, Object> submitDetailForDietSchedule(Box box);

	Map<String, Object> getDietForIndoorPatientList(Box box);

	Map<String, Object> submitDietForIndoorPatient(Box box);

	Map<String, Object> getDetailForPassPrinting(Box box);

	Map<String, Object> submitGeneratepass(Box box);

	Map<String, Object> getItemId(Box box);
	
	Map<String, Object> getPaywardWaitingList(Box box);
	
	Map<String, Object> submitPayward(Box box);

	Map<String, Object> getPrescriptionTemplate(Box box);

	Map<String, Object> getLabInvestigationTemplate(Box box);

	Map<String, Object> houseKeepingSetup(Box box);

	boolean addHouseKeeping(Box box);

	Map<String, Object> searchHouseKeeping(Box box);

	boolean submitHouseKeepingDetails(Box box);

	int getHinId(String adNo);

	Map<String, Object> showBloodRequestEntryJsp(int hinId,int hospitalId);

	String getOrderSeqForDisplay(String string,int hospitalId);

	Map<String, Object> showPatinetissueReport(Date fromDate, Date toDate,
			String regNo, int hospitalId);

	Map<String, Object> searchPatientForPostPaid(Box box);

	Map<String, Object> submitForPostPaid(Box box);
	Map<String, Object> showAmbulanceRunRequest(Box box);

	Map<String, Object> saveAmbulanceRunRequestDetails(Box box);

	Map<String, Object> showWaitingForBlodTransfusionJsp(Box box);

	Map<String, Object> showWardWasteHandoverjsp(Box box);

	Map<String, Object> addWasteHandOver(Box box);

	Map<String, Object> showWardWasteDisposaljsp(Box box);

	Map<String, Object> getDetailsForwasteDisposal(int headerId, int hospitalId);

	boolean saveDispDetails(BioWasteDisposal bioWasteDisposal,int headerId);

	Map<String, Object> getServiceGrid(String service, String hinNo);

	boolean cancelServiceInv(int dtId,String cancelServiceInv);

	Map<String, Object> getIpNoForReport(String hinNo);

	Map<String, Object> getItemForAllergy(String val, int hinId);
	
	Map<String, Object> viewMotherCashSheet(Box box);

	Map<String, Object> ggetDetailsForPendingServices(int inpatientId);

	Map<String, Object> getDetailsForFinalBill(int inpatientId);

	Map<String, Object> populateChargeAmoutForAmbulance(
			Map<String, Object> dataMap);
	
	int getChargeSlipNo(String flag, int hospitalId);

	Map<String, Object> getReferalList(int hospitalId, int userId);

	Map<String, Object> getReferalDetailsList(int remarksId);

	boolean updateReferal(String remarks, int remarksId);
	
	Map<String, Object> displayUnitWiseBed(Map<String, Object> map);

	Map<String, Object> getAllIcdForDischargeSummary(Map<String, Object> detailsMap);

	Map<String, Object> getAllWardRemarks(Map<String, Object> detailsMap);
	
	Map<String, Object> saveObject(Map<String,Object> dataMap,Box box);
	// Added by Amit Das on 23-02-2016
	Map<String, Object> getPatientScheme(int inpatientId);
	// Added by Amit Das on 23-02-2016
	Map<String, Object> updatePatientScheme(Box box);

	Map<String, Object> saveIpdObjectToServer(Map<String,Object> dataMap,Box box);


	Map<String, Object> getMotherBabyDeatils(Map<String, Object> mapForDs);

	Map<String, Object> addMotherDetails(Map<String, Object> mapForDs, Box box);

	Map<String, Object> getBabyDetails(Map<String, Object> mapForDs);

	Map<String, Object> addBabyDetails(Map<String, Object> mapForDs);

	Map<String, Object> getPatinetDetails(String hinNo);
	
	// ---    Vaital View --------------------
	Map<String, Object> showViewVitalPopUp(Box box);
	
	// ----------------------------------Birth
	// Certificate-----------------------------

	Map<String, Object> showBirthCertificateJsp();

	Map<String, Object> addBirthCertificate(Map<String, Object> generalMap);


	Map<String, Object> showBirth(int inpatientId);

	List<Object> getAdmissionNoHinNoList(Map<String, Object> detailsMap);

	List<Object> getMotherHin(String hinNo);

	
	public Map<String, Object> getIPDNoFortDeathCertificate(String hinNo);
	
	Map<String, Object> getPatientInvestigationList(Map<String, Object> mapForDs);

	Map<String, Object> submitInvestigationMonitoring(Box box);

	Map<String, Object> showInvestigationTrend(Map<String, Object> map);

	Map<String, Object> getInvResultForTrend(Box box);

	Map<String, Object> showPreDialysisChechupJsp(Box box);

	Map<String, Object> submitPreConsultationAssessmentDetails(Box box);

	Map<String, Object> showDialysisProcessJsp(Box box);

	Map<String, Object> saveDialysisProcess(Box box);

	Map<String, Object> getInvestigationResultForTrend(Box box);

	Map<String, Object> showWardServiceCanCelledJsp(int inpatientId);

	Map<String, Object> showDetailsReferalRecord(Box box);
	
	Map<String, Object> getInpatientListForSchemeChange(Map<String, Object> map);
	
	Map<String, Object> showDepartmentSpeciality(Map<String, Object> map);
	
	Map<String, Object> showGroupAndParameterValues(Map map);
	
	Map<String, Object> saveSpeciality(Map map);
	
	Map<String, Object> getOutSideAvailableBloodBankList(Map<String, Object> map);
	
	Map<String, Object> getPatientDetailsForLaborRoom1(Box box);
	
	boolean addLaborRoom1(Map<String, Object> map);
	
	Map<String, Object> getPatientDetailsForLaborRoom2(Box box);
	
	//added by govind 5-9-2016
	Map<String, Object> getPatientDetailsForLaborRoom3(Box box);
	
	Map<String, Object> getPatientDetailsForLaborRoom4(Box box);
	//added by govind 5-9-2016
	

	
	Map<String, Object> getPatientEpisodeDetails(Box box);
	
	List<PatientEpisode> getPatientEpisodeList(String hinNo);
	
	Map<String, Object> checkItem(Map<String, Object> dataMap);//added by govind 20-9-2016
	Map<String, Object> getItemBatch(Box box);//added by govind 23-09-2016
	Map<String, Object> submitIPNursingCare(Box box);

	Map<String, Object> saveGeneralSurgery(Box box);

	Map<String, Object> saveNeonatal(Box box);

	Map<String, Object> showNeonatalSpecialityScreenJsp(int inpatientId,
			String motherHinNo, int hinId);

	Map<String, Object> showPatientLabResultIP(Box box);

	Map<String, Object> searchIPStickerReprint(Map<String, Object> datamap);

	Map<String, Object> getIPPrescriptionDetails(Box box);

	Map<String, Object> showPrescribedMedicineJspForNurse(Box box);

	Map<String, Object> submitMedicinePrescriptionByNurse(Box box);
	
	Map<String, Object> getPatientPrescriptionDetails(Map<String, Object>infoMap);

	Map<String, Object> showGeneralSurgrySpecialityTemplateJsp(Box box);

	boolean addLaborRoom2(Map<String, Object> map);
	
	boolean addLaborRoom4(Map<String, Object> map);
	Map<String, Object> checkForBlockedMedicine(Map<String,Object> dataMap);
}

