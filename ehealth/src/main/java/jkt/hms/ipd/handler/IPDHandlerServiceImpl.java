package jkt.hms.ipd.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.ipd.dataservice.IPDDataService;
import jkt.hms.masters.business.BioWasteDisposal;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.PatientEpisode;
import jkt.hms.masters.business.TempCheckInOutFinal;
import jkt.hms.util.Box;

public class IPDHandlerServiceImpl implements IPDHandlerService {

	IPDDataService ipdDataService = null;

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchPatient(Map map) {
		return ipdDataService.searchPatient(map);
	}

	public Map<String, Object> nursingCareSetup(Box box) {
		return ipdDataService.nursingCareSetup(box);
	}

	public Map<String, Object> getConnectionForReport() {
		return ipdDataService.getConnectionForReport();
	}

	@SuppressWarnings("unchecked")
	public boolean addNursingCare(Box box) {
		return ipdDataService.addNursingCare(box);
	}

	public Map<String, Object> showFoodTesting(int deptId) {
		return ipdDataService.showFoodTesting(deptId);
	}

	@SuppressWarnings("unchecked")
	public boolean insertFoodTestingDetails(Map map) {
		return ipdDataService.insertFoodTestingDetails(map);
	}

	public Map<String, Object> showCaresList(Box box) {
		return ipdDataService.showCaresList(box);
	}

	public Map<String, Object> getPatientListOnBasisOfCare(Map<String, Object> dataMap) {
		return ipdDataService.getPatientListOnBasisOfCare(dataMap);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchPatientOnBasisOfCare(Box box) {
		return ipdDataService.searchPatientOnBasisOfCare(box);
	}

	@SuppressWarnings("unchecked")
	public boolean submitNursingCareEntryDetails(Box box) {

		return ipdDataService.submitNursingCareEntryDetails(box);
	}

	/*
	 * list of ward/department (non-Javadoc)
	 *
	 * @see jkt.hms.ipd.handler.IPDHandlerService#showWardList()
	 */

	public Map<String, Object> showWardList(int deptId,int hospitalId) {
		return ipdDataService.showWardList(deptId,hospitalId);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showWardConsumptionJsp(Map map) {
		return ipdDataService.showWardConsumptionJsp(map);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showStockDetailsJsp(Map map) {
		return ipdDataService.showStockDetailsJsp(map);
	}

	@SuppressWarnings("unchecked")
	public boolean submitWardConsumptionDetails(Map map) {
		return ipdDataService.submitWardConsumptionDetails(map);
	}

	public Map<String, Object> modifyWardConsumptionJsp(Map map) {
		return ipdDataService.modifyWardConsumptionjsp(map);
	}

	public boolean deleteStockDetails(Map map) {
		return ipdDataService.deleteStockDetails(map);
	}

	public Map<String, Object> showPatientIssueJsp(Map map) {
		return ipdDataService.showPatientIssueJsp(map);
	}

	public boolean submitPatientIssueDetails(Map map) {
		return ipdDataService.submitPatientIssueDetails(map);
	}

	public Map<String, Object> viewPatientIssueDetails(Map map) {
		return ipdDataService.viewPatientIssueDetails(map);
	}

	public Map<String, Object> getItemList(Map map) {
		return ipdDataService.getItemList(map);
	}

	public Map<String, Object> fillItemsInGrid(Map map) {
		return ipdDataService.fillItemsInGrid(map);
	}

	public Map<String, Object> showPatientDiagnosisJsp(Map map) {
		return ipdDataService.showPatientDiagnosisJsp(map);
	}

	public Map<String, Object> getICDList(Map map) {
		return ipdDataService.getICDList(map);
	}

	public boolean addPatientDiagnosisInformation(Map map) {
		return ipdDataService.addPatientDiagnosisInformation(map);
	}

	public Map<String, Object> showSilDilJsp(Map map) {
		return ipdDataService.showSilDilJsp(map);
	}

	public boolean submitSilDilStatus(Map map) {
		return ipdDataService.submitSilDilStatus(map);
	}

	// -----------------------------Clinical
	// Chart--------------------------------------
	public Map<String, Object> showNursingClinicalChartJsp(Box box) {
		return ipdDataService.showNursingClinicalChartJsp(box);
	}

	public boolean addNursingClinicalChart(Box box) {
		return ipdDataService.addNursingClinicalChart(box);
	}

	public Map getViewClinicalChart(Map<String, Object> dataMap) {
		return ipdDataService.getViewClinicalChart(dataMap);
	}

	// ---------------------------Intake Output
	// Chart--------------------------------------
	public Map<String, Object> showIntakeOutputJsp(int inPatient) {
		return ipdDataService.showIntakeOutputJsp(inPatient);
	}

	public Map<String, Object> addIntakeOutput(Box box) {
		return ipdDataService.addIntakeOutput(box);
	}

	@SuppressWarnings("unchecked")
	public Map getViewIntakeOutput(String radio_str) {
		return ipdDataService.getViewIntakeOutput(radio_str);
	}

	public Map<String, Object> showIntakeOutputChartReport(
			Map<String, Object> requestParameters) {
		return ipdDataService.showIntakeOutputChartReport(requestParameters);
	}

	public Map<String, Object> getAdmissionNumberList(
			Map<String, Object> requestParameters) {
		return ipdDataService.getAdmissionNumberList(requestParameters);
	}

	public List<Object> getAdmissionNoList(Map<String, Object> detailsMap) {
		return ipdDataService.getAdmissionNoList(detailsMap);
	}

	// -----------------------------------Reports---------------------------------
	public Map<String, Object> showFoodTastingReportJsp(int hospitalId) {
		return ipdDataService.showFoodTastingReportJsp(hospitalId);
	}

	public Map<String, Object> showNursingCareReportJsp(
			Map<String, Object> dataMap) {
		return ipdDataService.showNursingCareReportJsp(dataMap);
	}

	public String getMothersName(String hinNo) {
		return ipdDataService.getMothersName(hinNo);
	}

	public List<Object> getHinNo(String serviceNo) {
		return ipdDataService.getHinNo(serviceNo);
	}

	public List<Object> getHinNoList(String serviceNo) {
		return ipdDataService.getHinNoList(serviceNo);
	}

	public Map<String, Object> getSearchPatientComboDetails(
			Map<String, Object> requestParameters) {
		return ipdDataService.getSearchPatientComboDetails(requestParameters);
	}

	// ---------------------------------------------------------------------------------------------------------
	public Map<String, Object> getDBConnection() {
		return ipdDataService.getDBConnection();
	}

	public void setIpdDataService(IPDDataService ipdDataService) {
		this.ipdDataService = ipdDataService;
	}

	public Map<String, Object> getPatientList(int deptId,int hospitalId,int userId) {
		return ipdDataService.getPatientList(deptId,hospitalId,userId);
	}

	public boolean submitWardConsumptionIssueDetails(Map<String, Object> map) {

		return ipdDataService.submitWardConsumptionIssueDetails(map);
	}

	public Map<String, Object> getItemListForWardConsume(Map<String, Object> map) {
		return ipdDataService.getItemListForWardConsume(map);
	}

	public Map<String, Object> showDutyNursingReportJsp() {
		return ipdDataService.showDutyNursingReportJsp();
	}

	public Map<String, Object> getDiagnosisAndDocumentInit(
			Map<String, Object> dataMap) {

		return ipdDataService.getDiagnosisAndDocumentInit(dataMap);
	}

	public Map<String, Object> getICDCodeList(Map<String, Object> map) {
		return ipdDataService.getICDCodeList(map);
	}

	public Map<String, Object> showWaitingList(Map<String, Object> dataMap) {

		return ipdDataService.showWaitingList(dataMap);
	}

	public Map<String, Object> submitWaitingList(Map<String, Object> dataMap) {

		return ipdDataService.submitWaitingList(dataMap);
	}

	public Map<String, Object> getWardRemarksDetails(Map<String, Object> dataMap) {

		return ipdDataService.getWardRemarksDetails(dataMap);
	}

	public Map<String, Object> saveWardRemarks(Map<String, Object> dataMap) {

		return ipdDataService.saveWardRemarks(dataMap);
	}

	public Map<String, Object> getIpIdFormDischargeId(
			Map<String, Object> tempMap) {

		return ipdDataService.getIpIdFormDischargeId(tempMap);
	}

	public int getInpatientId(String adNo, String hinNo) {
		return ipdDataService.getInpatientId(adNo, hinNo);
	}

	public Map<String, Object> showDischargeStatusWiseReport() {
		return ipdDataService.showDischargeStatusWiseReport();
	}

	public Map<String, Object> getDoctorList() {
		return ipdDataService.getDoctorList();
	}

	public boolean saveMessageForDoctors(Box box) {
		return ipdDataService.saveMessageForDoctors(box);
	}

	@Override
	public Map<String, Object> showHandTakeOverReportJsp() {
		return ipdDataService.showHandTakeOverReportJsp();
	}

	@Override
	public String generateEntryNumber() {
		return ipdDataService.generateEntryNumber();
	}

	@Override
	public String getEntrySeqForDisplay(String string) {
		return ipdDataService.getEntrySeqForDisplay(string);
	}

	@Override
	public Map<String, Object> showHandTakeJsp(Map<String, Object> map) {
		return ipdDataService.showHandTakeJsp(map);
	}

	@Override
	public boolean submitHandTakeOver(Box box) {
		return ipdDataService.submitHandTakeOver(box);
	}

	public Map<String, Object> viewHandTakeOver(Map<String, Object> infoMap)
	{
		return ipdDataService.viewHandTakeOver(infoMap);
	}

	@Override
	public Map<String, Object> showPrescriptionJsp(Map<String, Object> map) {
		return ipdDataService.showPrescriptionJsp(map);

	}
	public 	Map<String, Object> submitPrescriptionDetails(Map<String, Object> map)
	{
		return ipdDataService.submitPrescriptionDetails(map);
	}
	public Map<String, Object> showInPatientPreviousPrescription(Map map)
	{
		return ipdDataService.showInPatientPreviousPrescription(map);

	}

	public Map<String, Object> getItemStock(Map<String, Object> dataMap)
	{
		return ipdDataService.getItemStock(dataMap);
	}
	public Map<String, Object> getItemClosingStock(Map<String, Object> dataMap)
	{
		return ipdDataService.getItemClosingStock(dataMap);
	}

	public Map<String, Object> showSendSmsJsp(Map<String, Object> mapDetail) {
		return ipdDataService.showSendSmsJsp(mapDetail);
	}

	public Map<String, Object> submitSendSms(Map<String, Object> mapDetail) {
		return ipdDataService.submitSendSms(mapDetail);
	}
	public Map<String, Object> showWardWiseDetails(int deptId,int hospitalId)
	{
		return ipdDataService.showWardWiseDetails(deptId,hospitalId);
	}

	@Override
	public Map<String, Object> getItemListForAutoCompleteIpd(
			Map<String, Object> map) {
		return ipdDataService.getItemListForAutoCompleteIpd(map);
	}

	@Override
	public Map<String, Object> showPatinetissueReport(Date fromDate, Date toDate,String regNo,int hospitalId) {
		return ipdDataService.showPatinetissueReport(fromDate,toDate,regNo,hospitalId);
	}

	@Override
	public List<TempCheckInOutFinal> getNumberOfUser(String year, String month) {
		return ipdDataService.getNumberOfUser(year,month);
	}

	@Override
	public Map<String, Object> getQuery(String year,String month,String days) {
		return ipdDataService.getQuery(year,month,days);
	}

	@Override
	public Map<String, Object> showEmployee(int empCategoryId,int hospitalId) {
		return ipdDataService.showEmployee(empCategoryId,hospitalId);
	}

	@Override
	public List<MasEmployee> getEmplist(int empCategoryId,int hospitalId) {
		return ipdDataService.getEmplist(empCategoryId,hospitalId);
	}

	@Override
	public String getMobileNo(int employeeId) {
		return ipdDataService.getMobileNo(employeeId);
	}

	@Override
	public Map<String, Object> showWardRemarksJsp(int inpatientId) {
		return ipdDataService.showWardRemarksJsp(inpatientId);
	}

	@Override
	public Map<String, Object> showProgressNoteJsp(Map<String, Object> mapForDs) {
		return ipdDataService.showProgressNoteJsp(mapForDs);
	}

	@Override
	public Map<String, Object> saveProgressNotes(Map<String, Object> dataMap) {
		return ipdDataService.saveProgressNotes(dataMap);
	}

	@Override
	public Map<String, Object> getProgressNoteDetails(Map<String, Object> dataMap) {
		return ipdDataService.getProgressNoteDetails(dataMap);
	}

	@Override
	public Map<String, Object> updateMLCData() {
		return ipdDataService.updateMLCData();
	}

	@Override
	public Map<String, Object> getPhysiotherapistPatientList(
			Map<String, Object> mapForDS) {
		return ipdDataService.getPhysiotherapistPatientList(mapForDS);
	}

	@Override
	public String getDepartmentNameFromId(int deptId) {
		return ipdDataService.getDepartmentNameFromId(deptId);
	}

	@Override
	public Map<String, Object> getPhysiotherapistList(
			Map<String, Object> mapForDS) {
		return ipdDataService.getPhysiotherapistList(mapForDS);
	}

	@Override
	public Map<String, Object> getDialysisPatientList(
			Map<String, Object> mapForDS) {
		return ipdDataService.getDialysisPatientList(mapForDS);
	}

	@Override
	public Map<String, Object> getDialysisPatientList1(
			Map<String, Object> mapForDS) {
		return ipdDataService.getDialysisPatientList1(mapForDS);
	}

	@Override
	public String generateReceiptNo(String string) {
		return ipdDataService.generateReceiptNo(string);
	}

	@Override
	public Map<String, Object> getPatientDetailsForAdvance(
			Map<String, Object> mapForDs) {
		return ipdDataService.getPatientDetailsForAdvance(mapForDs);
	}

	@Override
	public Map<String, Object> getSystemParamDetails() {
		return ipdDataService.getSystemParamDetails();
	}
	
	@Override
	public Map<String, Object> getPatientDetailsForKitIssue(Box box) {
		return ipdDataService.getPatientDetailsForKitIssue(box);
	}
	
	@Override
	public Map<String, Object> getPatientLatestDiagnosisAndDisability(int inpatientId) {
		return ipdDataService.getPatientLatestDiagnosisAndDisability(inpatientId);
	}

	@Override
	public Map<String, Object> showNewCaseSheetJsp(Box box) {
		return ipdDataService.showNewCaseSheetJsp(box);
	}
	
	@Override
	public Map<String, Object> showMedicineIssueDetailJsp(Box box) {
		
		return ipdDataService.showMedicineIssueDetailJsp(box);
	}
	
	@Override
	public Map<String, Object> getDetailOfWaitingInPatient(
			Map<String, Object> mapForDs) {
		return ipdDataService.getDetailOfWaitingInPatient(mapForDs);
	}
	
	@Override
	public Map<String, Object> patientAdmissionAccept(
			Map<String, Object> mapForDs) {
		return ipdDataService.patientAdmissionAccept(mapForDs);
	}
	
	@Override
	public Map<String, Object> getTemplateDetails(Box box) {
		return ipdDataService.getTemplateDetails(box);
	}
	
	@Override
	public Map<String, Object> submitPatientKitIssue(Box box) {
		return ipdDataService.submitPatientKitIssue(box) ;
	}
	
	@Override
	public Map<String, Object> submitIpdCaseSheetDetails(Box box,Map<String, Object> generalMap) {
		return ipdDataService.submitIpdCaseSheetDetails(box,generalMap);
	}
	
	@Override
	public Map<String, Object> searchNextOfKinPatient(Box box) {
		return ipdDataService.searchNextOfKinPatient(box);
	}
	
	@Override
	public Map<String, Object> showCreateVirtualBed(Box box) {
		return ipdDataService.showCreateVirtualBed(box);
	}
	
	@Override
	public Map<String, Object> submitCreateVirtualBed(Box box) {
		return ipdDataService.submitCreateVirtualBed(box);
	}
	
	@Override
	public Map<String, Object> getItemUnit(Box box) {
		return ipdDataService.getItemUnit(box);
	}
	
	@Override
	public Map<String, Object> showPatientDetails(Map<String, Object> dataMap) {
		
		return ipdDataService.showPatientDetails(dataMap);
	}
	
	@Override
	public Map<String, Object> getPatientAllergy(Box box) {
		return   ipdDataService.getPatientAllergy(box);
	}

	
	@Override
	public Map<String, Object> submitPatientAllergy(Box box) {
		return ipdDataService.submitPatientAllergy(box);
	}
	
	@Override
	public Map<String, Object> getPrescriptionListForPatient(Box box) {
		return ipdDataService.getPrescriptionListForPatient(box);
	}
	
	@Override
	public boolean submitWardConsumption(Box box) {
		return ipdDataService.submitWardConsumption(box);
	}
	
	@Override
	public boolean  checkBedStatus(int bedId)
	{
		return ipdDataService.checkBedStatus(bedId);
	}
	
	@Override
	public Map<String, Object>  getDetailsForBedTransferAcceptance(Box box)
	{
		return ipdDataService.getDetailsForBedTransferAcceptance(box);
	}
	
	@Override
	public Map<String, Object>  submitWardTransferAcceeptance(Box box)
	{
		return ipdDataService.submitWardTransferAcceeptance(box);
	}
	
	@Override
	public Map<String, Object>  getCareTransferAccepJsp(Box box)
	{
		return ipdDataService.getCareTransferAccepJsp(box);
	}
	
	
	@Override
	public Map<String, Object>  submitcareTransferAcceeptance(Box box)
	{
		return ipdDataService.submitcareTransferAcceeptance(box);
	}
	
	@Override
	public Map<String, Object> showWardConsList(int deptId,int hospitalId) {
		return ipdDataService.showWardConsList(deptId,hospitalId);
	}

	@Override
	public boolean submitWardConsDetails(Map<String, Object> map) {
		return ipdDataService.submitWardConsDetails(map);
	}
	
	
	@Override
	public Map<String, Object>  getNursingCareSttus(Box box)
	{
		return ipdDataService.getNursingCareSttus(box);
	}
	
	@Override
	public Map<String, Object>  showAmbulanceRunRegister(Box box)
	{
		return ipdDataService.showAmbulanceRunRegister(box);
	}
	
	@Override
	public Map<String, Object> saveAmbulanceRunRegisterDetails(Box box) {
		return ipdDataService.saveAmbulanceRunRegisterDetails(box);
	}
	
	@Override
	public Map<String, Object> getProcedureForDischargeSummary(Map<String, Object> detailsMap) {
		return ipdDataService.getProcedureForDischargeSummary(detailsMap);
	}

	@Override
	public Map<String, Object> getTreatmentDetailsForDischargeSummary(Map<String, Object> detailsMap) {
		return ipdDataService.getTreatmentDetailsForDischargeSummary(detailsMap) ;
	}
	
	@Override
	public Map<String, Object> getDetailForDietSchedule(Box box)
	{
		return ipdDataService.getDetailForDietSchedule(box);
	}
	
	@Override
	public Map<String, Object> submitDetailForDietSchedule(Box box)
	{
		return ipdDataService.submitDetailForDietSchedule(box);
	}
	
	@Override
	public Map<String, Object> getDietItemForAutoComplete(Map<String, Object> detailsMap)
	{
		return ipdDataService.getDietItemForAutoComplete(detailsMap);
	}
	
	@Override
	public Map<String, Object> getDietCombinationItems(Map<String, Object> detailsMap)
	{
		return ipdDataService.getDietCombinationItems(detailsMap);
	}
	
@Override
public Map<String, Object> getDietForIndoorPatientList(Box box)
{
	return ipdDataService.getDietForIndoorPatientList(box);
}

@Override
public Map<String, Object> submitDietForIndoorPatient(Box box)
{
	return ipdDataService.submitDietForIndoorPatient(box);
}

@Override
public Map<String, Object>  getDetailForPassPrinting(Box box)
{
	return ipdDataService.getDetailForPassPrinting(box);
}

@Override
public Map<String, Object>  submitGeneratepass(Box box)
{
	return ipdDataService.submitGeneratepass(box);
}
	
@Override
public Map<String, Object> getItemId(Box box) {
	return ipdDataService.getItemId(box);
}

@Override
public Map<String, Object> getPaywardWaitingList(Box box) {
	return ipdDataService.getPaywardWaitingList(box);
}
@Override
public Map<String, Object> submitPayward(Box box) {
	// TODO Auto-generated method stub
	return ipdDataService.submitPayward(box);
}

@Override
public Map<String, Object> getPrescriptionTemplate(Box box) {
	// TODO Auto-generated method stub
	return ipdDataService.getPrescriptionTemplate(box);
}

@Override
public Map<String, Object> getLabInvestigationTemplate(Box box) {
	// TODO Auto-generated method stub
	return ipdDataService.getLabInvestigationTemplate(box);
}

@Override
public Map<String, Object> houseKeepingSetup(Box box) {
	return ipdDataService.houseKeepingSetup(box);
}

@Override
public boolean addHouseKeeping(Box box) {
	return ipdDataService.addHouseKeeping(box);
}

@Override
public Map<String, Object> searchHouseKeeping(Box box)
{
	return ipdDataService.searchHouseKeeping(box);

}

@Override
public boolean submitHouseKeepingDetails(Box box)
{
	return ipdDataService.submitHouseKeepingDetails(box);
}

@Override
public int getHinId(String adNo) {
	return ipdDataService.getHinId(adNo);
}

@Override
public Map<String, Object> showBloodRequestEntryJsp(int hinId,int hospitalId) {
	return ipdDataService.showBloodRequestEntryJsp(hinId,hospitalId);
}

@Override
public String getOrderSeqForDisplay(String string,int hospitalId) {
	return ipdDataService.getOrderSeqForDisplay(string,hospitalId);
}

@Override
public Map<String, Object> searchPatientForPostPaid(Box box) {
	return ipdDataService.searchPatientForPostPaid(box);
}

@Override
public Map<String, Object> submitForPostPaid(Box box) {
	return ipdDataService.submitForPostPaid(box);
}

@Override
public Map<String, Object> showAmbulanceRunRequest(Box box) {
	return ipdDataService.showAmbulanceRunRequest(box);
}

@Override
public Map<String, Object> saveAmbulanceRunRequestDetails(Box box) {
	return ipdDataService. saveAmbulanceRunRequestDetails(box) ;
}

@Override
public Map<String, Object> showWaitingForBlodTransfusionJsp(Box box) {
	return ipdDataService.showWaitingForBlodTransfusionJsp(box);
}

@Override
public Map<String, Object> showWardWasteHandoverjsp(Box box) {
	return ipdDataService. showWardWasteHandoverjsp(box) ;
}

@Override
public Map<String, Object> addWasteHandOver(Box box) {
	return ipdDataService.addWasteHandOver(box);
}

@Override
public Map<String, Object> showWardWasteDisposaljsp(Box box) {
	return ipdDataService.showWardWasteDisposaljsp(box);
}

@Override
public Map<String, Object> getDetailsForwasteDisposal(int headerId,
		int hospitalId) {
	return ipdDataService.getDetailsForwasteDisposal(headerId,hospitalId);
}

@Override
public boolean saveDispDetails(BioWasteDisposal bioWasteDisposal,int headerId) {
	return ipdDataService.saveDispDetails(bioWasteDisposal,headerId);
}

@Override
public Map<String, Object> getServiceGrid(String service, String hinNo) {
	return ipdDataService.getServiceGrid(service,hinNo);
}



@Override
public boolean cancelServiceInv(int dtId, String cancelServiceInv) {
	return ipdDataService.cancelServiceInv(dtId,cancelServiceInv);
}

@Override
public Map<String, Object> getIpNoForReport(String hinNo) {
	
	return ipdDataService.getIpNoForReport(hinNo);
}

@Override
public Map<String, Object> getItemForAllergy(String val, int hinId) {
	return ipdDataService. getItemForAllergy( val,  hinId);
}
public Map<String, Object> viewMotherCashSheet(Box box) {
	
	return ipdDataService.viewMotherCashSheet(box);
}

@Override
public Map<String, Object> ggetDetailsForPendingServices(int inpatientId) {
	return ipdDataService.ggetDetailsForPendingServices(inpatientId);
}

@Override
public Map<String, Object> getDetailsForFinalBill(int inpatientId) {
	return ipdDataService.getDetailsForFinalBill(inpatientId);
}

@Override
public Map<String, Object> populateChargeAmoutForAmbulance(Map<String, Object> dataMap) {
	
	return ipdDataService.populateChargeAmoutForAmbulance(dataMap);
}


@Override
public int getChargeSlipNo(String flag, int hospitalId) {
	
	return ipdDataService.getChargeSlipNo(flag, hospitalId);
}

@Override
public Map<String, Object> getReferalList(int hospitalId, int userId) {
	return ipdDataService.getReferalList( hospitalId,  userId);
}

@Override
public Map<String, Object> getReferalDetailsList(int remarksId) {
	return ipdDataService.getReferalDetailsList(remarksId);
}

@Override
public boolean updateReferal(String remarks, int remarksId) {
	return ipdDataService.updateReferal(remarks,remarksId);
}


@Override
public Map<String, Object> displayUnitWiseBed(Map<String, Object> map) {
	return ipdDataService.displayUnitWiseBed(map);
}

@Override
public Map<String, Object> getAllIcdForDischargeSummary(Map<String, Object> detailsMap) {
	return ipdDataService.getAllIcdForDischargeSummary(detailsMap);
}

@Override
public Map<String, Object> getAllWardRemarks(Map<String, Object> detailsMap) {
	return ipdDataService.getAllWardRemarks(detailsMap);
}

@Override
public Map<String, Object> saveObject(Map<String, Object> dataMap, Box box) {
	return ipdDataService.saveObject(dataMap,box);  
}

@Override
public Map<String, Object> getPatientScheme(int inpatientId) {
	return ipdDataService.getPatientScheme(inpatientId);
}

@Override
public Map<String, Object> updatePatientScheme(Box box) {
	return ipdDataService.updatePatientScheme(box);
}

@Override
public Map<String, Object> getIPDNoFortDeathCertificate(String hinNo) {
	return ipdDataService.getIPDNoFortDeathCertificate(hinNo);
}

@Override
public Map<String, Object> saveIpdObjectToServer(Map<String,Object> dataMap,Box box){
	return ipdDataService.saveIpdObjectToServer(dataMap,box);  
}

@Override
public Map<String, Object> getMotherBabyDeatils(
		Map<String, Object> mapForDs) {
	return ipdDataService.getMotherBabyDeatils(mapForDs);
}

public Map<String, Object> addMotherDetails(Map<String, Object> mapForDs,Box box) {
	return ipdDataService.addMotherDetails(mapForDs,box);
}

@Override
public Map<String, Object> getBabyDetails(Map<String, Object> mapForDs) {
	return ipdDataService.getBabyDetails(mapForDs);
}
@Override
public Map<String, Object> addBabyDetails(Map<String, Object> mapForDs) {
	return ipdDataService.addBabyDetails(mapForDs);
}

@Override
public Map<String, Object> getPatinetDetails(String hinNo) {
	return ipdDataService.getPatinetDetails(hinNo);
}
//---    Vaital View --------------------

		@Override
public Map<String, Object> showViewVitalPopUp(Box box) {
	
	return ipdDataService.showViewVitalPopUp(box);
}
		@Override
		public Map<String, Object> showBirthCertificateJsp() {
			return ipdDataService.showBirthCertificateJsp();
		}

		@Override
		public Map<String, Object> addBirthCertificate(
				Map<String, Object> generalMap) {
			return ipdDataService.addBirthCertificate(generalMap);
		}

		

		// -----------------------Birth Certificate-----------------------------
		public Map<String, Object> showBirth(int inpatientId) {
			return ipdDataService.showBirth(inpatientId);
		}
		
		public List<Object> getAdmissionNoHinNoList(Map<String, Object> detailsMap) {
			return ipdDataService.getAdmissionNoHinNoList(detailsMap);
		}
		
		@Override
		public List<Object> getMotherHin(String hinNo) {
			return ipdDataService.getMotherHin(hinNo);
		}

		@Override
		public Map<String, Object> getPatientInvestigationList(
				Map<String, Object> mapForDs) {
			return ipdDataService.getPatientInvestigationList(mapForDs);
		}

		@Override
		public Map<String, Object> submitInvestigationMonitoring(Box box) {
			return ipdDataService.submitInvestigationMonitoring(box);
		}

		@Override
		public Map<String, Object> showInvestigationTrend(Map<String, Object> map) {
			return ipdDataService.showInvestigationTrend(map);
		}

		@Override
		public Map<String, Object> getInvResultForTrend(Box box) {
			return ipdDataService.getInvResultForTrend(box);
		}

		@Override
		public Map<String, Object> showPreDialysisChechupJsp(Box box) {
			return ipdDataService.showPreDialysisChechupJsp(box);
		}

		@Override
		public Map<String, Object> submitPreConsultationAssessmentDetails(
				Box box) {
			return ipdDataService.submitPreConsultationAssessmentDetails(box);
		}

		@Override
		public Map<String, Object> showDialysisProcessJsp(Box box) {
			
			return ipdDataService.showDialysisProcessJsp(box);
		}

		@Override
		public Map<String, Object> saveDialysisProcess(Box box) {
		
			return ipdDataService.saveDialysisProcess(box);
		}

		@Override
		public Map<String, Object> getInvestigationResultForTrend(Box box) {
			return ipdDataService.getInvestigationResultForTrend(box);
		}

		@Override
		public Map<String, Object> showWardServiceCanCelledJsp(int inpatientId) {
			return ipdDataService.showWardServiceCanCelledJsp(inpatientId);
		}

		@Override
		public Map<String, Object> showDetailsReferalRecord(Box box) {
			
			return ipdDataService.showDetailsReferalRecord(box);
		}
		
		public Map<String, Object> getInpatientListForSchemeChange(Map<String, Object> map){
			return ipdDataService.getInpatientListForSchemeChange(map);
		}
		
		public Map<String, Object> showDepartmentSpeciality(Map<String, Object> map){
			return ipdDataService.showDepartmentSpeciality(map);
		}
		
		public Map<String, Object> showGroupAndParameterValues(Map map){
			return ipdDataService.showGroupAndParameterValues(map);
		}
		
		public Map<String, Object> saveSpeciality(Map map) {
			return ipdDataService.showGroupAndParameterValues(map);
		}
		
		public Map<String, Object> getOutSideAvailableBloodBankList(Map<String, Object> map) {
			return ipdDataService.getOutSideAvailableBloodBankList(map);
		}
	
		public Map<String, Object> getPatientDetailsForLaborRoom1(Box box){
			return ipdDataService.getPatientDetailsForLaborRoom1(box);
		}

		@Override
		public boolean addLaborRoom1(Map<String, Object> map) {
			return ipdDataService.addLaborRoom1(map);
		}

		@Override
		public Map<String, Object> getPatientDetailsForLaborRoom2(Box box) {
			return ipdDataService.getPatientDetailsForLaborRoom2(box);
		}
		
		//added by govind 5-9-2016
		@Override
		public Map<String, Object> getPatientDetailsForLaborRoom3(Box box) {
			return ipdDataService.getPatientDetailsForLaborRoom3(box);
		}
		
		@Override
		public Map<String, Object> getPatientDetailsForLaborRoom4(Box box) {
			return ipdDataService.getPatientDetailsForLaborRoom4(box);
		}
		//added by govind 5-9-2016

		
		@Override
		public Map<String, Object> getPatientEpisodeDetails(Box box) {	
			return ipdDataService.getPatientEpisodeDetails(box);
		}
		
		
		
		@Override
		public List<PatientEpisode> getPatientEpisodeList(String hinNo)  {	
			return ipdDataService.getPatientEpisodeList(hinNo);
		}
		
		public Map<String, Object> checkItem(Map<String, Object> dataMap) {
			return ipdDataService.checkItem(dataMap);
		}
		
		//added by govind 23-09-2016
		@Override
		public Map<String, Object> getItemBatch(Box box) {
			// TODO Auto-generated method stub
			return ipdDataService.getItemBatch(box);
		}
		@Override
		public Map<String, Object> submitIPNursingCare(Box box) {
			// TODO Auto-generated method stub
			return ipdDataService.submitIPNursingCare(box);
		}
		//added by govind 23-09-2016

		@Override
		public Map<String, Object> saveGeneralSurgery(Box box) {
			return ipdDataService.saveGeneralSurgery(box);
		}

		@Override
		public Map<String, Object> showNeonatalSpecialityScreenJsp(
				int inpatientId,String  motherHinNo ,int hinId) {
			return ipdDataService.showNeonatalSpecialityScreenJsp(inpatientId,motherHinNo,hinId);
		}
		@Override
		public Map<String, Object> saveNeonatal(Box box) {
			return ipdDataService.saveNeonatal(box);
		}

		@Override
		public Map<String, Object> showPatientLabResultIP(Box box) {
			return ipdDataService.showPatientLabResultIP(box);
		}

		@Override
		public Map<String, Object> searchIPStickerReprint(
				Map<String, Object> datamap) {
			return ipdDataService.searchIPStickerReprint(datamap);
		}

		@Override
		public Map<String, Object> getIPPrescriptionDetails(Box box) {
			return ipdDataService.getIPPrescriptionDetails(box);
		}

		@Override
		public Map<String, Object> showPrescribedMedicineJspForNurse(Box box) {
		
			return ipdDataService.showPrescribedMedicineJspForNurse(box);
		}

		@Override
		public Map<String, Object> submitMedicinePrescriptionByNurse(Box box) {
			
			return ipdDataService.submitMedicinePrescriptionByNurse(box);
		}
		
		
		@Override
		public Map<String, Object> getPatientPrescriptionDetails(Map<String, Object>infoMap) {
			
			return ipdDataService.getPatientPrescriptionDetails(infoMap);
		}

		public Map<String, Object> showGeneralSurgrySpecialityTemplateJsp(Box box){
			return ipdDataService.showGeneralSurgrySpecialityTemplateJsp(box);
		}

		@Override
		public boolean addLaborRoom2(Map<String, Object> map) {
			return ipdDataService.addLaborRoom2(map);
		}

		@Override
		public boolean addLaborRoom4(Map<String, Object> map) {
			return ipdDataService.addLaborRoom4(map);
		}

		@Override
		public Map<String, Object> checkForBlockedMedicine(
				Map<String, Object> dataMap) {
			// TODO Auto-generated method stub
			return ipdDataService.checkForBlockedMedicine(dataMap);
		}

	
		
}