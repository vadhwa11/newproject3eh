package jkt.hms.opd.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jkt.hms.masters.business.HospitalDoctorUnitT;
import jkt.hms.masters.business.OpPatientReferral;
import jkt.hms.masters.business.PatientFitnessCertificate;
import jkt.hms.opd.dataservice.OPDDataService;
import jkt.hms.util.Box;

public class OPDHandlerServiceImpl implements OPDHandlerService {

	OPDDataService opdDataService = null;

	public OPDDataService getOpdDataService() {
		return opdDataService;
	}

	public void setOpdDataService(OPDDataService opdDataService) {
		this.opdDataService = opdDataService;
	}

	// ---------------------------------------------methods written by
	// vikas-----------------------------------

	public Map<String, Object> getWaitingPatientList(Map mapForDS) {
		return opdDataService.getWaitingPatientList(mapForDS);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchWaitingPatientList(Map map) {
		return opdDataService.searchWaitingPatientList(map);
	}

	public Map<String, Object> getPatientDetails(Map map) {

		return opdDataService.getPatientDetails(map);
	}

	public Map<String, Object> getICDList(Map map) {

		return opdDataService.getICDList(map);
	}

	public Map<String, Object> getOPDDetails(Map mapForDS) {

		return opdDataService.getOPDDetails(mapForDS);
	}
	
	public Map<String, Object> showOPDTreatmentRecords(int templateId) {
		return opdDataService.showOPDTreatmentRecords(templateId);
	}

	public Map<String, Object> getItemListForAutoComplete(Map mapForDS) {
		return opdDataService.getItemListForAutoComplete(mapForDS);
	}
	
	public Map<String, Object> getItemListForAutoCompleteOutItem(Map mapForDS) {
		return opdDataService.getItemListForAutoCompleteOutItem(mapForDS);
	}
	
	public Map<String, Object> getItemListForAutoCompleteOTC(Map mapForDS) {
		return opdDataService.getItemListForAutoCompleteOTC(mapForDS);
	}

	public Map<String, Object> getItemListForAutoCompleteIpd(Map mapForDS) {
		return opdDataService.getItemListForAutoCompleteIpd(mapForDS);
	}

	public Map<String, Object> submitOPDPatientDetails(Map mapForDS) {
		return opdDataService.submitOPDPatientDetails(mapForDS);
	}

	public Map<String, Object> showOPDInvestigationRecords(
			int investigationTemplateId) {
		return opdDataService
				.showOPDInvestigationRecords(investigationTemplateId);
	}

	public Map<String, Object> getInvestigationListForAutoComplete(Map mapForDS) {
		return opdDataService.getInvestigationListForAutoComplete(mapForDS);
	}

	public Map<String, Object> getChargeCodeValue(String chargeCodeName,
			int hinId) {
		return opdDataService.getChargeCodeValue(chargeCodeName, hinId);
	}

	public Map<String, Object> getPreviousPatientVisit(Map mapForDS) {

		return opdDataService.getPreviousPatientVisit(mapForDS);
	}

	public Map<String, Object> viewPreviousVisit(Map mapForDS) {

		return opdDataService.viewPreviousVisit(mapForDS);
	}

	public Map<String, Object> showPatientPrevoiusPrescription(Map mapForDS) {
		return opdDataService.showPatientPrevoiusPrescription(mapForDS);
	}

	public Map<String, Object> showPatientPrevoiusInvestigation(Map mapForDS) {
		return opdDataService.showPatientPrevoiusInvestigation(mapForDS);
	}

	public Map<String, Object> showSurgeryRequisitionJsp(Map mapForDS) {
		return opdDataService.showSurgeryRequisitionJsp(mapForDS);
	}

	public Map<String, Object> showAjaxResponseForSurgeryRequisitionJsp(
			Map mapForDS) {
		return opdDataService
				.showAjaxResponseForSurgeryRequisitionJsp(mapForDS);
	}

	public Map<String, Object> showSurgeryRequisitionJspForHin(Box box) {
		return opdDataService.showSurgeryRequisitionJspForHin(box);
	}

	public boolean submitSurgeryRequisitionDetails(Map mapForDS) {
		return opdDataService.submitSurgeryRequisitionDetails(mapForDS);
	}

	public Map<String, Object> searchPatientDetails(Map mapForDS) {
		return opdDataService.searchPatientDetails(mapForDS);
	}

	public Map<String, Object> submitSurgeryRequisitionDetailsForInpatient(Box box) {
		return opdDataService
				.submitSurgeryRequisitionDetailsForInpatient(box);
	}

	public Map<String, Object> getIcdWithIcdCode(Map mapForDS) {
		return opdDataService.getIcdWithIcdCode(mapForDS);
	}


	public Map<String, Object> submitOphthalmologyDetails(Box box) {
		return opdDataService.submitOphthalmologyDetails(box);
	}

	public Map<String, Object> getPatientOphthalmologyDetails(
			Map<String, Object> parameterMap) {
		return opdDataService.getPatientOphthalmologyDetails(parameterMap);
	}

	public Map<String, Object> getFrequencyList() {
		return opdDataService.getFrequencyList();
	}

	public Map<String, Object> submitOphthalmologyDiagnosis(Box box) {
		return opdDataService.submitOphthalmologyDiagnosis(box);
	}

	public Map<String, Object> getOphthalmologyDiagnosisDetails(
			Map<String, Object> parameterMap) {
		return opdDataService.getOphthalmologyDiagnosisDetails(parameterMap);
	}

	public Map<String, Object> submitOphthalmologyRetinal(Box box) {
		return opdDataService.submitOphthalmologyRetinal(box);
	}

	public Map<String, Object> getOphthalmologyRetinalDetails(
			Map<String, Object> parameterMap) {
		return opdDataService.getOphthalmologyRetinalDetails(parameterMap);
	}

	public Map<String, Object> submitOphthalmologyFollowUp(Box box) {
		return opdDataService.submitOphthalmologyFollowUp(box);
	}

	public Map<String, Object> getOphthalmologyFollowUpDetails(
			Map<String, Object> parameterMap) {
		return opdDataService.getOphthalmologyFollowUpDetails(parameterMap);
	}
	public Map<String, Object> getPatientAllergicDrugs(int visitId) {
		return opdDataService.getPatientAllergicDrugs(visitId);
	}

	public Map<String, Object> fillItemsInGrid(Map<String, Object> dataMap) {
		return opdDataService.fillItemsInGrid(dataMap);
	}

	public Map<String, Object> getItemList(Map<String, Object> map) {
		return opdDataService.getItemList(map);
	}

	public Map<String, Object> addPatientAllergicDrugs(
			Map<String, Object> infoMap) {
		return opdDataService.addPatientAllergicDrugs(infoMap);
	}

	public Map<String, Object> getItem() {
		return opdDataService.getItem();
	}

	public Map<String, Object> getPatientHistory(int visitId) {
		return opdDataService.getPatientHistory(visitId);
	}

	public boolean addPatientHistory(Map<String, Object> infoMap) {
		return opdDataService.addPatientHistory(infoMap);
	}

	public Map<String, Object> viewPatientHistory(
			Map<String, Object> parameterMap) {
		return opdDataService.viewPatientHistory(parameterMap);
	}


	public Map<String, Object> getPediatricVaccinationPlanJsp(int visitId) {
		return opdDataService.getPediatricVaccinationPlanJsp(visitId);
	}

	public Map<String, Object> addPediatricVaccinationPlan(Box box) {
		return opdDataService.addPediatricVaccinationPlan(box);
	}

	public Map<String, Object> updatePediatricVaccinationPlan(Box box) {
		return opdDataService.updatePediatricVaccinationPlan(box);
	}
	public Map<String, Object> getPediatricCaseSheet(int visitId) {
		return opdDataService.getPediatricCaseSheet(visitId);
	}

	public Map<String, Object> getImmunizationCardDetail(int visitId, int hinId) {
		return opdDataService.getImmunizationCardDetail(visitId, hinId);
	}

	public Map<String, Object> addPediatricCaseSheet(Box box) {
		return opdDataService.addPediatricCaseSheet(box);
	}

	public Map<String, Object> viewPediatricCaseSheet(
			Map<String, Object> parameterMap) {
		return opdDataService.viewPediatricCaseSheet(parameterMap);
	}


	public Map<String, Object> showOBGJsp(int visitId) {
		return opdDataService.showOBGJsp(visitId);
	}

	public Map<String, Object> addOBGOne(Box box) {
		return opdDataService.addOBGOne(box);
	}

	public Map<String, Object> updateOBG(Box box) {
		return opdDataService.updateOBG(box);
	}

	public Map<String, Object> addOrUpdateOBGJsp(Box box) {
		return opdDataService.addOrUpdateOBGJsp(box);
	}


	public Map<String, Object> showENTJsp(int visitId) {
		return opdDataService.showENTJsp(visitId);
	}

	public Map<String, Object> addEnt(Box box) {
		return opdDataService.addEnt(box);
	}

	public Map<String, Object> viewEnt(Map<String, Object> parameterMap) {
		return opdDataService.viewEnt(parameterMap);
	}

	public Map<String, Object> viewOBGONE(Map<String, Object> parameterMap) {
		return opdDataService.viewOBGONE(parameterMap);
	}

	public Map<String, Object> viewOBGTWO(Map<String, Object> parameterMap) {
		return opdDataService.viewOBGTWO(parameterMap);

	}

	public Map<String, Object> viewOBGTHREE(Map<String, Object> parameterMap) {
		return opdDataService.viewOBGTHREE(parameterMap);

	}

	public Map<String, Object> viewOBGFOUR(Map<String, Object> parameterMap) {
		return opdDataService.viewOBGFOUR(parameterMap);
	}


	public List<Object> getHinNoList(String serviceNo) {
		return opdDataService.getHinNoList(serviceNo);
	}

	public List<Object> getVisitNoList(Map<String, Object> detailsMap) {
		return opdDataService.getVisitNoList(detailsMap);
	}

	public Map<String, Object> getConnectionForReport() {
		return opdDataService.getConnectionForReport();
	}

	public Map<String, Object> showDailyDepartmentWiseReportJsp(Map<String,Object> map) {
		return opdDataService.showDailyDepartmentWiseReportJsp(map);
	}

	public Map<String, Object> showDailyOPDInvestigationsReportJsp() {
		return opdDataService.showDailyOPDInvestigationsReportJsp();
	}

	public Map<String, Object> showDailyOPDPrescriptionsReportJsp(Map<String, Object> map) {
		return opdDataService.showDailyOPDPrescriptionsReportJsp(map);
	}

	public Map<String, Object> showDailyOPDRankCategoryReportJsp() {
		return opdDataService.showDailyOPDRankCategoryReportJsp();
	}

	public Map<String, Object> viewPatientAllergicDrug(
			Map<String, Object> parameterMap) {
		return opdDataService.viewPatientAllergicDrug(parameterMap);
	}


	public Map<String, Object> getCardiologyDepartmentDetails(int visitId) {
		return opdDataService.getCardiologyDepartmentDetails(visitId);
	}

	public boolean addCardiologyDepartmentDetails(Map<String, Object> infoMap) {
		return opdDataService.addCardiologyDepartmentDetails(infoMap);
	}

	public Map<String, Object> viewCardiologyDepartmentDetails(
			Map<String, Object> parameterMap) {
		return opdDataService.viewCardiologyDepartmentDetails(parameterMap);
	}


	public Map<String, Object> getGastroEnterologyEndoscopy(int visitId) {
		return opdDataService.getGastroEnterologyEndoscopy(visitId);
	}

	public boolean addGastroEnterologyEndoscopy(Map<String, Object> infoMap) {
		return opdDataService.addGastroEnterologyEndoscopy(infoMap);
	}

	public Map<String, Object> viewGastroEnterologyEndoscopy(
			Map<String, Object> parameterMap) {
		return opdDataService.viewGastroEnterologyEndoscopy(parameterMap);
	}


	public Map<String, Object> getGastroEnterologyColonoscopy(int visitId) {
		return opdDataService.getGastroEnterologyColonoscopy(visitId);
	}

	public boolean addGastroEnterologyColonoscopy(Map<String, Object> infoMap) {
		return opdDataService.addGastroEnterologyColonoscopy(infoMap);
	}

	public Map<String, Object> viewGastroEnterologyColonoscopy(
			Map<String, Object> parameterMap) {
		return opdDataService.viewGastroEnterologyColonoscopy(parameterMap);
	}

	public Map<String, Object> getAntenatalCard(int visitId) {
		return opdDataService.getAntenatalCard(visitId);
	}
	
	public Map<String, Object> getAntenatalCard2(int visitId,int hinId,Box box) {
		return opdDataService.getAntenatalCard2(visitId,hinId,box);
	}

	public boolean addAntenatalCard(Map<String, Object> infoMap) {
		return opdDataService.addAntenatalCard(infoMap);
	}

	public Map<String, Object> addAntenatalCard2(Map<String, Object> infoMap) {
		return opdDataService.addAntenatalCard2(infoMap);
	}

	public Map<String, Object> viewAntenatalCard(
			Map<String, Object> parameterMap) {
		return opdDataService.viewAntenatalCard(parameterMap);
	}

	public Map<String, Object> updateAntenatalCard(Box box) {
		return opdDataService.updateAntenatalCard(box);
	}

	public Map<String, Object> getGravidagramHTN(int visitId) {
		return opdDataService.getGravidagramHTN(visitId);
	}

	public Map<String, Object> getAntenatalCardEdit(int aId, int visitId) {
		return opdDataService.getAntenatalCardEdit(aId, visitId);
	}

	public boolean addGravidagramHTN(Map<String, Object> infoMap) {
		return opdDataService.addGravidagramHTN(infoMap);
	}

	public Map<String, Object> viewGravidagramHTN(
			Map<String, Object> parameterMap) {
		return opdDataService.viewGravidagramHTN(parameterMap);
	}

	public Map<String, Object> getGravidagramGestationalDiabitiesOne(int visitId) {
		return opdDataService.getGravidagramGestationalDiabitiesOne(visitId);
	}

	public boolean addGravidagramGestationalDiabitiesOne(
			Map<String, Object> infoMap) {
		return opdDataService.addGravidagramGestationalDiabitiesOne(infoMap);
	}

	public Map<String, Object> viewGravidagramGestationalDiabitiesOne(
			Map<String, Object> parameterMap) {
		return opdDataService
				.viewGravidagramGestationalDiabitiesOne(parameterMap);
	}

	public Map<String, Object> getGravidagramGestationalDiabitiesTwo(int visitId) {
		return opdDataService.getGravidagramGestationalDiabitiesTwo(visitId);
	}

	public boolean addGravidagramGestationalDiabitiesTwo(
			Map<String, Object> infoMap) {
		return opdDataService.addGravidagramGestationalDiabitiesTwo(infoMap);
	}

	public Map<String, Object> viewGravidagramGestationalDiabitiesTwo(
			Map<String, Object> parameterMap) {
		return opdDataService
				.viewGravidagramGestationalDiabitiesTwo(parameterMap);
	}

	public String generateOrderNumber() {
		return opdDataService.generateOrderNumber();
	}

	public Map<String, Object> addOncosurgeryCaseSheet(Box box) {
		return opdDataService.addOncosurgeryCaseSheet(box);
	}

	public Map<String, Object> showOncosurgeryCaseSheetJsp(int visitId) {
		return opdDataService.showOncosurgeryCaseSheetJsp(visitId);
	}

	public Map<String, Object> viewOncosurgeryCaseSheet(
			Map<String, Object> parameterMap) {
		return opdDataService.viewOncosurgeryCaseSheet(parameterMap);

	}

	public Map<String, Object> addUrologyCaseSheet(Box box) {
		return opdDataService.addUrologyCaseSheet(box);
	}

	public Map<String, Object> showUrologyCaseSheetJsp(int visitId) {
		return opdDataService.showUrologyCaseSheetJsp(visitId);
	}

	public Map<String, Object> viewUrologyCaseSheet(
			Map<String, Object> parameterMap) {
		return opdDataService.viewUrologyCaseSheet(parameterMap);

	}

	public Map<String, Object> addOncosurgery(Box box) {
		return opdDataService.addOncosurgery(box);
	}

	public Map<String, Object> showOncosurgeryJsp(int visitId) {
		return opdDataService.showOncosurgeryJsp(visitId);
	}

	public Map<String, Object> viewOncosurgery(Map<String, Object> parameterMap) {
		return opdDataService.viewOncosurgery(parameterMap);

	}

	public Map<String, Object> showPatientPreviousHinNumber(
			Map<String, Object> mapForDS) {
		return opdDataService.showPatientPreviousHinNumber(mapForDS);
	}

	public String getDepartmentNameFromId(int departmentId) {
		return opdDataService.getDepartmentNameFromId(departmentId);
	}

	public Map<String, Object> viewPreviousNextVisit(
			Map<String, Object> mapForDS) {
		return opdDataService.viewPreviousNextVisit(mapForDS);
	}

	public Map<String, Object> getOpdTemplateDepartmentWise(int visitId) {
		return opdDataService.getOpdTemplateDepartmentWise(visitId);
	}

	public boolean addOpdTemplateDepartmentWise(Map<String, Object> infoMap) {
		return opdDataService.addOpdTemplateDepartmentWise(infoMap);
	}

	public Map<String, Object> viewOpdTemplateDepartmentWise(
			Map<String, Object> parameterMap) {
		return opdDataService.viewOpdTemplateDepartmentWise(parameterMap);
	}

	public Map<String, Object> viewOpdTemplateDepartmentWisePreNext(
			Map<String, Object> parameterMap) {
		return opdDataService
				.viewOpdTemplateDepartmentWisePreNext(parameterMap);
	}

	public boolean submitSocioEconomicHistory(Map<String, Object> map) {
		return opdDataService.submitSocioEconomicHistory(map);
	}

	public Map<String, Object> viewGynaecology(Map<String, Object> parameterMap) {
		return opdDataService.viewGynaecology(parameterMap);
	}

	public boolean submitComplaints(Map<String, Object> map) {
		return opdDataService.submitComplaints(map);
	}

	public boolean submitGeneralExaminaton(Map<String, Object> map) {
		return opdDataService.submitGeneralExaminaton(map);
	}

	public boolean submitMedicalSurgicalHistory(Map<String, Object> map) {
		return opdDataService.submitMedicalSurgicalHistory(map);
	}

	public boolean submitSystemicExamination(Map<String, Object> map) {
		return opdDataService.submitSystemicExamination(map);
	}

	public Map<String, Object> showUploadingDocumentsJsp(int visitId) {
		return opdDataService.showUploadingDocumentsJsp(visitId);
	}

	public Map<String, Object> submitUploadDocuments(Box box) {
		return opdDataService.submitUploadDocuments(box);
	}

	public Map<String, Object> viewPatientDetails(Map<String, Object> map) {
		return opdDataService.viewPatientDetails(map);
	}

	public Map<String, Object> checkItem(Map<String, Object> dataMap) {
		return opdDataService.checkItem(dataMap);
	}

	public String generatePrecriptionNo(int hinId) {
		return opdDataService.generatePrecriptionNo(hinId);
	}

	public Map<String, Object> getDispensingPriceForItem(
			Map<String, Object> dataMap) {
		return opdDataService.getDispensingPriceForItem(dataMap);
	}

	public Map<String, Object> getItemBrandName(Map<String, Object> dataMap) {

		return opdDataService.getItemBrandName(dataMap);
	}

	public Map<String, Object> getItemBrandManufacturerName(
			Map<String, Object> dataMap) {
		return opdDataService.getItemBrandManufacturerName(dataMap);
	}

	public Map<String, Object> getDrugTypeOfItem(Map<String, Object> dataMap) {
		return opdDataService.getDrugTypeOfItem(dataMap);
	}

	public Map<String, Object> getPhysiotherapistList(
			Map<String, Object> dataMap) {
		return opdDataService.getPhysiotherapistList(dataMap);
	}

	public Map<String, Object> getPhysiotherapistPatientList(
			Map<String, Object> dataMap) {
		return opdDataService.getPhysiotherapistPatientList(dataMap);
	}

	public boolean submitOPDPhysiotherapyJsp(Box box) {
		return opdDataService.submitOPDPhysiotherapyJsp(box);
	}

	public Map<String, Object> addImmunizationCard(Box box,
			Map<String, Object> dataMap) {
		return opdDataService.addImmunizationCard(box, dataMap);
	}

	public Map<String, Object> getDepartmentName(Map mapForDS) {
		return opdDataService.getDepartmentName(mapForDS);
	}

	public Map<String, Object> getTokenNumber(Map tokenMap) {
		return opdDataService.getTokenNumber(tokenMap);
	}

	public Map<String, Object> getMasChargeCode() {
		return opdDataService.getMasChargeCode();
	}

	public Map<String, Object> getChargeCodeDetails(String chargeCode, int hinId) {
		return opdDataService.getChargeCodeDetails(chargeCode, hinId);
	}

	public Map<String, Object> showPreviousSystemPatientPrescriptions(
			Map<String, Object> mapForDS) {
		return opdDataService.showPreviousSystemPatientPrescriptions(mapForDS);
	}

	@Override
	public Map<String, Object> showPopupTokenJsp(Map<String, Object> mapForDS) {
		return opdDataService.showPopupTokenJsp(mapForDS);
	}
	@Override
	public Map<String, Object> showToeknDisplayForNurseJsp(Map<String, Object> mapForDS) {
		return opdDataService.showToeknDisplayForNurseJsp(mapForDS);
	}

	public Map<String, Object> showTreatment(Map<String, Object> map) {
		return opdDataService.showTreatment(map);
	}

	public Map<String, Object> showTreatmentPopUp(Map<String, Object> map) {
		return opdDataService.showTreatmentPopUp(map);
	}
	
	public Map<String, Object> getPhysiotherapyPreviousDetails(Map<String, Object> map)
	{
		return opdDataService.getPhysiotherapyPreviousDetails(map);
	}

	public Map<String, Object> updateVistToken(Map<String, Object> mapForToken) {
		return opdDataService.updateVistToken(mapForToken);
		}

	@Override
	public Map<String, Object> getPhysiotherapistPatientList1(	Map<String, Object> mapForDS) {
		return opdDataService.getPhysiotherapistPatientList1(mapForDS);	}

	@Override
	public Map<String, Object> getPreviousStudentVisit(
			Map<String, Object> mapForDS) {
		return opdDataService.getPreviousStudentVisit(mapForDS);
	}

	@Override
	public Map<String, Object> getstudentDetail(Map<String, Object> detailsMap) {
		return opdDataService.getstudentDetail(detailsMap);
	}

	@Override
	public Map<String, Object> getstudentDetail1(Map<String, Object> detailsMap) {
		return opdDataService.getstudentDetail1(detailsMap);
	}

	@Override
	public Map<String, Object> submitforPhysio(int empId, int deptId,int hinId) {
		return opdDataService.submitforPhysio(empId,deptId, hinId);
	}

	@Override
	public Map<String, Object> filldoctoreName(int deptId) {
		return opdDataService.submitforPhysio(deptId);
	}

	@Override
	public Map<String, Object> showreferralPatientJsp(int deptId) {
		return opdDataService.showreferralPatientJsp(deptId);
	}

	@Override
	public Map<String, Object> searchPatient(String hinNo) {
		// TODO Auto-generated method stub
		return opdDataService.searchPatient(hinNo);
	}

	@Override
	public boolean submitReferalPatient(OpPatientReferral opPatientReferral) {
		return opdDataService.submitReferalPatient(opPatientReferral);
	}

	@Override
	public boolean submitPatientForFitness(PatientFitnessCertificate fitness) {
		return opdDataService.submitPatientForFitness(fitness);
	}

	@Override
	public Map<String, Object> showWaitingforBillingPhysiotherapyPatientList() {
		return opdDataService.showWaitingforBillingPhysiotherapyPatientList();
	}

	@Override
	public Map<String, Object> getPatientDetailsForJSSK(Map<String, Object> mapForDs) {
		return opdDataService.getPatientDetailsForJSSK(mapForDs);
	}

	@Override
	public boolean updateBills(int inpatientId) {
		return opdDataService.updateBills(inpatientId);
	}

	@Override
	public Map<String, Object> searchPatientForMLC(Map<String, Object> mapForDs) {
		return opdDataService.searchPatientForMLC(mapForDs);
	}
	@Override
	public Map<String, Object> getSnomedCTDetails(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return opdDataService.getSnomedCTDetails(map);
	}
	@Override
	public Map<String, Object> savePataientPreConsultationAssessment(Box box, Map map){
		return opdDataService.savePataientPreConsultationAssessment(box, map);
	}
	
	@Override
	public Map<String, Object> showPopUpPresentComplaint(Map<String, Object> dataMap) {
		return opdDataService.showPopUpPresentComplaint(dataMap);
	}
	
	@Override
	public Map<String, Object> showPopUpFamilyHistory(
			Map<String, Object> dataMap) {
		return opdDataService.showPopUpFamilyHistory(dataMap);
	}
	
	@Override
	public Map<String, Object> showPopUpHistoryOfPastIllness(
			Map<String, Object> dataMap) {
		return opdDataService.showPopUpHistoryOfPastIllness(dataMap);
	}
	
	@Override
	public Map<String, Object> showPopUpPersonalHistory(
			Map<String, Object> dataMap) {
		return opdDataService.showPopUpPersonalHistory(dataMap);
	}
	
	@Override
	public Map<String, Object> showPopUpMedicationHistory(
			Map<String, Object> dataMap) {
		return opdDataService.showPopUpMedicationHistory(dataMap);
	}
	
	@Override
	public Map<String, Object> autoCompleteForDiagnosis(Map<String, Object> dataMap) {
		return opdDataService.autoCompleteForDiagnosis(dataMap);
	}
	
	@Override
	public Map<String, Object> showPopUpGeneralExamination(Map<String, Object> dataMap) {
		return opdDataService.showPopUpGeneralExamination(dataMap);
	}

	@Override
	public Map<String, Object> showPopUpSystemicExamination(Map<String, Object> dataMap) {
		return opdDataService.showPopUpSystemicExamination(dataMap);
	}
	
	@Override
	public Map<String, Object> showPopUpLocalExamination(Map<String, Object> dataMap) {
		return opdDataService.showPopUpLocalExamination(dataMap);
	}
	
	
	
	@Override
	public Map<String, Object> getSecondOpinion(Map<String, Object> dataMap) {
		return opdDataService.getSecondOpinion(dataMap);
	}

	@Override
	public Map<String, Object> getPatientVisitDetails(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return opdDataService.getPatientVisitDetails(map);
	}
	public Map<String,Object>submitSecondOpinion(Map<String,Object>map){
		// TODO Auto-generated method stub
		return opdDataService.submitSecondOpinion(map);
	}
	
	public Map<String,Object>getDistrictHospital(Map<String,Object>map){
		// TODO Auto-generated method stub
		return opdDataService.getDistrictHospital(map);
	}
	
	public Map<String,Object>getHospitalDepartment(Map<String,Object>map){
		// TODO Auto-generated method stub
		return opdDataService.getHospitalDepartment(map);
	}
	
	public Map<String,Object>getDoctorDepartment(Map<String,Object>map){
		// TODO Auto-generated method stub
		return opdDataService.getDoctorDepartment(map);
	}
	public Map<String, Object> showDiagnosis(Map<String, Object> map) {
		return opdDataService.showDiagnosis(map);
	}

	@Override
	public Map<String, Object> showDiagnosisPopUp(Map<String, Object> map) {

		return opdDataService.showDiagnosisPopUp(map);
	}
	@Override
	public Map<String, Object> showUploadingDocumentsJsp(int visitId, int inpatientId,Map<String, Object> mapForDS){
		return opdDataService.showUploadingDocumentsJsp(visitId, inpatientId,mapForDS);
	}
	
	
	public Map<String, Object> submitDifferentialDiagnosis(String arr[])
	{
		return opdDataService.submitDifferentialDiagnosis(arr);
	}
	
	public Map<String, Object> getDrugAndProcedureDetails(Map<String, Object> map)
	{
		return opdDataService.getDrugAndProcedureDetails(map);
	}
	
	public Map<String, Object> getPatientVitalTrends(Map<String, Object> map)
	{
		return opdDataService.getPatientVitalTrends(map);
	}
	public Map<String, Object> getPayward(Map<String, Object> map)
	{
		return opdDataService.getPayward(map);
	}
	
	public Map<String, Object> getObservationWardAdmissionWaitingList(Map<String, Object> map)
	{
		return opdDataService.getObservationWardAdmissionWaitingList(map);
	}

	public Map<String, Object> opdPatientObservationStatus(	Map<String, Object> map) {
		return opdDataService.opdPatientObservationStatus(map);
	}
	
	public Map<String, Object> getOPNursingCareWaitingList(	Map<String, Object> map) {
		return opdDataService.getOPNursingCareWaitingList(map);
	}
	
	public Map<String, Object> getObservationWard(Map<String, Object> map){
		return opdDataService.getObservationWard(map);
	}
	
	@Override
	public Map<String, Object> getNursingCareProcedureAutoList(
			Map<String, Object> map) {
		return opdDataService.getNursingCareProcedureAutoList(map);
	}

	@Override
	public Map<String, Object> submitPrescriptionTamplate(Box box){
		return opdDataService.submitPrescriptionTamplate(box);
	}
	
	@Override
	public Map<String, Object> submitInvestigationTamplate(Box box){
		return opdDataService.submitInvestigationTamplate(box);
	}
	
	@Override
	public Map<String, Object> getProcedureOrder(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return opdDataService.getProcedureOrder(map);
	}
	
	@Override
	public Map<String, Object> getPrescriptionTemplate(Box box) {
		// TODO Auto-generated method stub
		return opdDataService.getPrescriptionTemplate(box);
	}
	
	@Override
	public Map<String, Object> submitProcedureOrder(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return opdDataService.submitProcedureOrder(map);
	}
	
	@Override
	public Map<String, Object> getLabInvestigationTemplate(Box box) {
		// TODO Auto-generated method stub
		return opdDataService.getLabInvestigationTemplate(box);
	}
	
	@Override
	public Map<String, Object> showDiseaseFeatures(Box box) {
		
		return opdDataService.showDiseaseFeatures(box);
	}
	
	@Override
	public void getChangeVisitStatus(Integer visitId) {
		
		opdDataService.getChangeVisitStatus(visitId);
	}
	
	@Override
	public Map<String, Object> showDepartmentSpeciality(Map<String, Object> map) {
		
		return opdDataService.showDepartmentSpeciality(map);
	}
	
	@Override
	public Map<String, Object> submitSnomedTemplates(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return opdDataService.submitSnomedTemplates(map);
	}
	
	@Override
	public boolean changeVisitStatus(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return opdDataService.changeVisitStatus(map);
	}
	@Override
	public Map<String, Object> showDisplayImagesJsp(Map<String, Object> mapForDS) {
		return opdDataService.showDisplayImagesJsp(mapForDS);
	}
	@Override
	public Map<String, Object> submitImagesList(Map<String, Object> map,Box box) {
		
		return opdDataService.submitImagesList(map,box);
	}

	
	@Override
	public Map<String, Object> openImageForDisplay(int imageId,int hospitalId,int deptId) {
		
		return opdDataService.openImageForDisplay(imageId,hospitalId,deptId);
	}
	
	@Override
	public Map<String, Object> saveAndGetTempComorbidity(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return opdDataService.saveAndGetTempComorbidity(map);
	}
	
	@Override
	public Map<String, Object> submitCantraDrugAndDiesease(Box box) {
		// TODO Auto-generated method stub
		return opdDataService.submitCantraDrugAndDiesease(box);
	}
	
	@Override
	public Map<String, Object> showObervationPatientList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Map<String, Object> checkDrugCantraIndicative(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return opdDataService.checkDrugCantraIndicative(map);
	}
	
	@Override
	public Map<String, Object> showVaccineDetailJsp(Box box) {
		// TODO Auto-generated method stub
		return opdDataService.showVaccineDetailJsp(box);
	}

	@Override
	public Map<String, Object> displayAU(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return opdDataService.displayAU(dataMap);
	}
	@Override
	public Map<String, Object> getItemListForAutoCompleteAllergy(
			Map<String, Object> map) {
		// TODO Auto-generated method stub
		return opdDataService.getItemListForAutoCompleteAllergy(map);
	}
	
	@Override
	public Map<String, Object> submitNursingCare(Box box) {
		// TODO Auto-generated method stub
		return opdDataService.submitNursingCare(box);
	}
	
	@Override
	public Map<String, Object> submitObservationWard(Map<String, Object> map,Box box) {
		// TODO Auto-generated method stub
		return opdDataService.submitObservationWard(map,box);
	}
	
	@Override
	public Map<String, Object> patientDischargeAndAdmit(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return opdDataService.patientDischargeAndAdmit(map);
	}
	
	@Override
	public Map<String, Object> referObservationToOpd(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return opdDataService.referObservationToOpd(map);
	}
	
	@Override
	public Map<String, Object> checkInvestigationItem(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return opdDataService.checkInvestigationItem(map);
	}
	
	@Override
	public Map<String, Object> checkInvestigationItemIsBlocked(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return opdDataService.checkInvestigationItemIsBlocked(map);
	}
	
	@Override
	public Map<String, Object> showSecondOpnionListJsp(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return opdDataService.showSecondOpnionListJsp(map);
	}

	
	@Override
	public Map<String, Object> checkItemStockQty(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return opdDataService.checkItemStockQty(map);
	}
	
	@Override
	public Map<String, Object> getItemBatch(Box box) {
		// TODO Auto-generated method stub
		return opdDataService.getItemBatch(box);
	}
	
	@Override
	public Map<String, Object> getpatientRefered(Box box) {
		// TODO Auto-generated method stub
		return opdDataService.getpatientRefered(box);
	}
	
	
	@Override
	public	Map<String, Object> getInjectionDetailsForAppointment(Box box){
		// TODO Auto-generated method stub
		return opdDataService.getInjectionDetailsForAppointment(box);
	}
	
	@Override
	public Map<String, Object> issueInjectionFromReception(Box box) {
		// TODO Auto-generated method stub
		return opdDataService.issueInjectionFromReception(box);
	}
	
	@Override
	public Map<String, Object> saveInjectionRegisterDetails(Box box) {
		// TODO Auto-generated method stub
		return opdDataService.saveInjectionRegisterDetails(box);
	}
	
	@Override
	public Map<String, Object> saveInjectionAppointment(Box box) {
		// TODO Auto-generated method stub
		return opdDataService.saveInjectionAppointment(box);
	}
	
	@Override
	public Map<String, Object> getPendingInjectionList(Box box,Date FromDate,Date ToDate,int hospitalId) {
		// TODO Auto-generated method stub
		return opdDataService.getPendingInjectionList(box,FromDate,ToDate,hospitalId);
	}
	
	@Override
	public Map<String, Object> deleteOPDdetails(Box box) {
		// TODO Auto-generated method stub
		return opdDataService.deleteOPDdetails(box);
	}
	@Override
	public Map<String, Object> getICDListwithID(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return  opdDataService.getICDListwithID(map);
	}

	

	@Override
	public Map<String, Object> populateSecondOpinionForm(
			Map<String, Object> dataMap) {
		
		return opdDataService.populateSecondOpinionForm(dataMap);
	}

	

	@Override
	public Map<String, Object> updatSecondOpinionPatient(Box box) {
		// TODO Auto-generated method stub
		return opdDataService.updatSecondOpinionPatient(box);
	}
	
	@Override
	public Map<String, Object> getTemplate(Box box) {
		// TODO Auto-generated method stub
		return opdDataService.getTemplate(box);
	}
	
	@Override
	public Map<String, Object> getDetailsForProcWaitList(int hospitalId,int visitId) {
		return opdDataService.getDetailsForProcWaitList(hospitalId,visitId);
	}
	
	@Override
	public Map<String, Object> getRouteAutoList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return opdDataService.getRouteAutoList(map);
	}

	

	@Override
	public Map<String, Object> getSnomedList(Map<String, Object> map) {
		return opdDataService.getSnomedList(map);
	}

	

	@Override
	public Map<String, Object> getICDListBasedOnSnomedId(Map<String, Object> map) {
		return opdDataService.getICDListBasedOnSnomedId(map);
	}
	
	//VK
	public Map<String, Object> getOPClinicalReadViewList(Map<String, Object> mapForDS) {
		return opdDataService.getOPClinicalReadViewList(mapForDS);
	}
	
	@Override
	public Map<String, Object> removeCantraDisease(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return opdDataService.removeCantraDisease(map);
	}
	@Override
	public Map<String, Object> removeCantraDrugs(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return opdDataService.removeCantraDrugs(map);
	}


	@Override
	public Map<String, Object> getBedStatus(int deptId, int hospitalId) {
		// TODO Auto-generated method stub
		return opdDataService.getBedStatus(deptId, hospitalId);
	}
	
	@Override
	public Map<String, Object> getLoincSnomedList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return opdDataService.getLoincSnomedList(map);
	}
	@Override
	public Map<String, Object> populatMasInstitute(Map<String, Object> dataMap) {
		return opdDataService.populatMasInstitute(dataMap);
	}


	@Override
	public Map<String, Object> getInvestigationListForAutoComplete1(
			Map mapForDS) {
		// TODO Auto-generated method stub
		return  opdDataService.getInvestigationListForAutoComplete1(mapForDS);
	}

	@Override
	public Map<String, Object> getTodayOtherPrescription(int hinId, int visitId) {
		return opdDataService.getTodayOtherPrescription(hinId,visitId);
	}

	
	@Override
	public Map<String, Object> getItemForAllergy(String itemCode, int visitId) {
		return opdDataService.getItemForAllergy(itemCode,visitId);
	}
	
	@Override
	public Map<String, Object> showGroupAndParameterValues(Map map) {
		return opdDataService.showGroupAndParameterValues(map);
	}
	
	@Override
	public Map<String, Object> saveSpeciality(Map map,Box box) {
		return opdDataService.saveSpeciality(map,box);
	}
	@Override
	public boolean submitExpiryDetails(Map<String,Object> map){
		return opdDataService.submitExpiryDetails(map);
	}
	@Override
	public Map<String,Object> printExpiryDetails(Map<String,Object> map){
		return opdDataService.printExpiryDetails(map);
	
		
		
	
	}


	@Override
	public Map<String, Object> getdeadPatientDetails(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return opdDataService.getdeadPatientDetails(map);
	}

	@Override
	public void saveComorbidity(Map map, Map<Integer, Integer> savedIcd) {
		opdDataService.saveComorbidity(map,savedIcd);
	}




	@Override
	public Map<String, Object> getOpdOphthalmology(int visitId) {
		return opdDataService.getOpdOphthalmology(visitId);
	}

	@Override
	public Map<String, Object> uploadAndViewDocuments(Map<String, Object> dataMap) {
		return opdDataService.uploadAndViewDocuments(dataMap);
	}
	@Override
	public Map<String, Object> showPoliceIntimationDetail(int hospitalId) {
		// TODO Auto-generated method stub
		return opdDataService.showPoliceIntimationDetail(hospitalId);
	}
	@Override
	public Map<String, Object> displayPoliceIntimationDetail(Box box) {
		// TODO Auto-generated method stub
		return opdDataService.displayPoliceIntimationDetail(box);
	}
	@Override
	public Map<String, Object> submitPoliceIntimationDetail(Box box) {
		// TODO Auto-generated method stub
		return opdDataService.submitPoliceIntimationDetail(box);
	}


	@Override
	public Map<String, Object> saveNursingCare(Box box) {
		return opdDataService.saveNursingCare(box);
	}

	

	@Override
	public Map<String, Object> getProcedureDetailsForPopUp(Box box) {
		return opdDataService.getProcedureDetailsForPopUp(box);
	}

	@Override
	public Map<String, Object> checkForAlreadyIssuedPrescribtion(String itemCode, int visitId,int hospitalId){
		return opdDataService.checkForAlreadyIssuedPrescribtion(itemCode,visitId, hospitalId);
	}

	

	@Override
	public String getHinNo(int visitId) {
		return opdDataService.getHinNo(visitId);
	}

	@Override
	public Map<String, Object> doPatientRelease(Map<String, Object> dataMap) {
		return opdDataService.doPatientRelease(dataMap);
	}

	@Override
	public int getOrderId() {
		// TODO Auto-generated method stub
		return opdDataService.getOrderId();
	}
	
	@Override
	public Map<String, Object> openVideoForDisplay(int imageId) {
		
		return opdDataService.openVideoForDisplay(imageId);
	}

	@Override
	public Map<String, Object> displayTravelHistory(Box box) {
		
		return opdDataService.displayTravelHistory(box);
	}
	
	@Override
	public Map<String, Object> getOutpatientListForSchemeChange(Map<String, Object> dataMap) {
		
		return opdDataService.getOutpatientListForSchemeChange(dataMap);
	}
	
	@Override
	public Map<String, Object> updatePatientScheme(Box box) {
		
		return opdDataService.updatePatientScheme(box);
	}
	
	@Override
	public Map<String, Object> showNCDPattern(Box box) {
		return opdDataService.showNCDPattern(box);
	}
	
	@Override
	public Map<String, Object> showRNTCPDetail(Box box) {
		return opdDataService.showRNTCPDetail(box);
	}
	
	@Override
	public Map<String, Object> showFpisRecord(Box box) {
		return opdDataService.showFpisRecord(box);
	}
	
	public void displayCurrentPatientToken(Map map) {

		 opdDataService.displayCurrentPatientToken(map);
	}
	
	@Override
	public Map<String, Object> getWaitingQueue(Map<String, Object> mapForDS) {
		return opdDataService.getWaitingQueue(mapForDS);
	}
	
	@Override
	public Map<String, Object> getWaitingQueueJspData(Map<String, Object> mapForDS) {
		return opdDataService.getWaitingQueueJspData(mapForDS);
	}
	
	@Override
	public Map<String, Object> showPopupTokenList(Map<String, Object> mapForDS) {
		return opdDataService.showPopupTokenList(mapForDS);
	}

	@Override
	public Map<String, Object> saveNicuCaseRecord(Map<String, Object> mapForDS,Box box) {
		return opdDataService.saveNicuCaseRecord(mapForDS,box);
	}

	@Override
	public Map<String, Object> saveDeaddictionCentre(Box box) {
		return opdDataService.saveDeaddictionCentre(box);
	}
	
	@Override
	public Map<String, Object> checkMappedCharge(Map<String, Object> map) {
		return opdDataService.checkMappedCharge(map);
	}
	
	
	
	@Override
	public Map<String, Object> referBackNursingPatientToOpd(Map<String, Object> map) {
		return opdDataService.referBackNursingPatientToOpd(map);
	}
	
	@Override
	public Map<String, Object> saveENTExamination(Box box) {
		
		return opdDataService.saveENTExamination(box);
	}

	@Override
	public Map<String, Object> saveLeprosyProforma(Box box) {
		
		return opdDataService.saveLeprosyProforma(box);
	}
	
	

	@Override
	public Map<String, Object> getPatientEpisodeDetails(Box box) {	
		return opdDataService.getPatientEpisodeDetails(box);
	}
	
	
	
	@Override
	public Map<String, Object> getPatientEpisodeList(String hinNo)  {	
		return opdDataService.getPatientAndEpisodeList(hinNo);
	}
	
	//added by govind 15-9-2016
	@Override
	public Map<String, Object> updatePrescriptionTamplate(Box box){
		return opdDataService.updatePrescriptionTamplate(box);
	}
	
	@Override
	public Map<String, Object> deletePrescriptionTamplate(Box box){
		return opdDataService.deletePrescriptionTamplate(box);
	}

	@Override
	public Map<String, Object> savePsychogeriatricClinic(Box box) {
		
		return opdDataService.savePsychogeriatricClinic(box);
	}
	public Map<String, Object> saveMedicine(Box box) {
		
		return opdDataService.saveMedicine(box);
	}

	@Override
	public Map<String, Object> saveOrthopedicsSpeciality(Box box) {
		
		return opdDataService.saveOrthopedicsSpeciality(box);
	}
	
	@Override
	public Map<String, Object> getIpDeapartmentMappings(Box box) {
		
		return opdDataService.getIpDeapartmentMappings(box);
	}
	
	@Override
	public Map<String, Object> addIpDepartmentsMapping(Map<String, Object> mapForDs) {
		
		return opdDataService.addIpDepartmentsMapping(mapForDs);
	}
	
	@Override
	public Map<String, Object> editIpDepartmentsMapping(Map<String, Object> mapForDs) {
		
		return opdDataService.editIpDepartmentsMapping(mapForDs);
	}
	
	@Override
	public Map<String, Object> deleteIpDepartmentsMapping(Map<String, Object> mapForDs) {
		
		return opdDataService.deleteIpDepartmentsMapping(mapForDs);
	}

	@Override
	public Map<String, Object> saveRespiratoryClinic(Box box,Map<String, Object> generalMap) {
		
		return opdDataService.saveRespiratoryClinic(box,generalMap);
	}

	@Override
	public Map<String, Object> saveGeneralProforma(Box box,Map<String, Object> generalMap) {
		
		return opdDataService.saveGeneralProforma(box,generalMap);
	}

	@Override
	public Map<String, Object> getSpecialityTemplateName(Box box) {
		// TODO Auto-generated method stub
		return opdDataService.getSpecialityTemplateName(box);
	}
	
	public String getAntenatalCardStatus(int hinId) {
		return opdDataService.getAntenatalCardStatus(hinId);
	}

	@Override
	public String getHospitalName(Integer hospitalId) {
		return opdDataService.getHospitalName(hospitalId);
	}

	@Override
	public Map<String, Object> showPatientLabResult(Box box) {
		
		return opdDataService.showPatientLabResult(box);
	}

	@Override
	public Map<String, Object> displayLabTest(Box box) {
	
		return opdDataService.displayLabTest(box);
	}
	
	@Override
	public Map<String, Object> checkForExistingDisplayName(Box box){

		return opdDataService.checkForExistingDisplayName(box);
	}
	
	@Override
	public Map<String, Object> getServiceCenters(Box box){

		return opdDataService.getServiceCenters(box);
	}
	
	@Override
	public Map<String, Object> getDisplayDepartmentType(Map<String,Object> mapForDS){
		return opdDataService.getDisplayDepartmentType(mapForDS);
	}

	@Override
	public Map<String, Object> getQueueListParticularDoctor(Box box) {
		return opdDataService.getQueueListParticularDoctor(box);
	}
	@Override
	public Map<String, Object> getTokenXML(Map<String, Object> mapForDS) {
		return opdDataService.getTokenXML(mapForDS);
	}
	
	@Override
	public Map<String, Object> bookCounterForDoctor(Box box) {
		return opdDataService.bookCounterForDoctor(box);
	}

	public String getAntenatalCardVisitStatus(int visitId) {
		return opdDataService.getAntenatalCardVisitStatus(visitId);
	}

	@Override
	public Map showGroupAndParameterValuesNew(Map generalMap) {
		
		return opdDataService.showGroupAndParameterValuesNew(generalMap);
	}

	@Override
	public Map<String, Object> getANCSummary(Box box) {
		
		return opdDataService.getANCSummary(box);
	}
	
	@Override
	public Map<String, Object> saveOralMedicine(Map<String, Object> mapForDS, Box box, HttpServletRequest request) {
		return opdDataService.saveOralMedicine(mapForDS, box, request);
	}

	@Override
	public Map<String, Object> savePreAssessmentClinic(Map<String, Object> mapForDS, Box box, HttpServletRequest request) {
		return opdDataService.savePreAssessmentClinic(mapForDS, box, request);
	}

	@Override
	public Map<String, Object> submitOutsideLab(Box box) {
		return opdDataService.submitOutsideLab(box);
	}

	@Override
	public Map<String, Object> saveMaxillofacialTraumaProforma(
			Map<String, Object> mapForDS, Box box, HttpServletRequest request) {
		return opdDataService.saveMaxillofacialTraumaProforma(mapForDS, box, request);
	}

	@Override
	public Map<String, Object> saveCaseRecordOfPeriodontics(
			Map<String, Object> mapForDS, Box box, HttpServletRequest request) {
		return opdDataService.saveCaseRecordOfPeriodontics(mapForDS, box, request);
	}

	@Override
	public Map<String, Object> saveOralAndMaxillofacialSurgery(
			Map<String, Object> mapForDS, Box box, HttpServletRequest request) {
		return opdDataService.saveOralAndMaxillofacialSurgery(mapForDS, box, request);
	}

	@Override
	public Map<String, Object> showOralAndMaxillofacialSurgery() {
		return opdDataService.showOralAndMaxillofacialSurgery();
	}

	@Override
	public Map<String, Object> saveImplantPlanning(
			Map<String, Object> mapForDS, Box box, HttpServletRequest request) {
		return opdDataService.saveImplantPlanning(mapForDS, box, request);
	}

	@Override
	public Map<String, Object> saveRemovablePartialProsthodontics(
			Map<String, Object> mapForDS, Box box, HttpServletRequest request) {
		return opdDataService.saveRemovablePartialProsthodontics(mapForDS, box, request);
	}
	
	@Override
	public Map<String, Object> saveFixedProsthodontics(
			Map<String, Object> mapForDS, Box box, HttpServletRequest request) {
		return opdDataService.saveFixedProsthodontics(mapForDS, box, request);
	}
	
	@Override
	public Map<String, Object> saveEndodontics(
			Map<String, Object> mapForDS, Box box, HttpServletRequest request) {
		return opdDataService.saveEndodontics(mapForDS, box, request);
	}

	@Override
	public Map<String, Object> saveDiagnosticRecord(Map<String, Object> mapForDS, Box box, HttpServletRequest request) {
		
		return opdDataService.saveDiagnosticRecord(mapForDS,box, request);
	}

	@Override
	public Map<String, Object> saveMaxillofacialProsthesis(Map<String, Object> mapForDS, Box box, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return opdDataService.saveMaxillofacialProsthesis(mapForDS,box, request);
	}

	@Override
	public Map<String, Object> saveCommunityOralHealthCaseHistory(
			Map<String, Object> mapForDS, Box box, HttpServletRequest request) {
		return opdDataService.saveCommunityOralHealthCaseHistory(mapForDS, box, request);
	}

	@Override
	public Map<String, Object> savePedodonticsVitalStatistics(
			Map<String, Object> mapForDS, Box box, HttpServletRequest request) {
		return opdDataService.savePedodonticsVitalStatistics(mapForDS,box,request);
	}

	@Override
	public Map<String, Object> saveOralMedicinePathology(Map<String, Object> mapForDS, Box box, HttpServletRequest request) {
		
		return opdDataService.saveOralMedicinePathology(mapForDS,box,request);
	}
	@Override
	public Map<String, Object> getDoctorUnit(Map<String, Object> map) {
		return opdDataService.getDoctorUnit(map);
	}

	@Override
	public List<HospitalDoctorUnitT> getUnitDoctors(String unitId) {
		
		return opdDataService.getUnitDoctors(unitId);
	}

	@Override
	public Map<String, Object> savePsCaseRecordOrthodotics(
			Map<String, Object> mapForDS, Box box, HttpServletRequest request) {
		return opdDataService.savePsCaseRecordOrthodotics(mapForDS, box, request);
	}

	@Override
	public Map<String, Object> showRespiratoryClinicJsp(Box box) {
		
		return opdDataService.showRespiratoryClinicJsp(box);
	}

	@Override
	public Map<String, Object> showInfertilityClinic(int visitId,int hinId) {
		
		return opdDataService.showInfertilityClinic(visitId,hinId);
	}

	@Override
	public Map<String, Object> submitInfertilityClinic(Map<String, Object> mapForDS, Box box, HttpServletRequest request) {
		
		return opdDataService.submitInfertilityClinic(mapForDS, box, request);
	}

	@Override
	public Map<String, Object> getClinicalSummaryHistoryData(Box box) {
		
		return opdDataService.getClinicalSummaryHistoryData(box);
	}

	@Override
	public Map<String, Object> getClinicalSummaryDetail(Box box) {
		// TODO Auto-generated method stub
		return opdDataService.getClinicalSummaryDetail(box);
	}

	@Override
	public Map<String, Object> showTaperdMedicine(Box box) {
		return opdDataService.showTaperdMedicine(box);
	}

	@Override
	public Map<String, Object> getAllValidatedTestForLabOrderNoWise(Map<String, Object> requestParameters) {
		
		return opdDataService.getAllValidatedTestForLabOrderNoWise(requestParameters);
	}

	@Override
	public Map<String, Object> printNicuCaseRecord(Map<String, Object> mapForDS) {
		return opdDataService.printNicuCaseRecord(mapForDS);
	}

	@Override
	public Map<String, Object> printHeightWeightGraph(Map<String, Object> requestParametersMap) {
		
		return opdDataService. printHeightWeightGraph(requestParametersMap);
	}

	@Override
	public Map<String, Object> showNicuCaseRecordJsp(Box box) {
		return opdDataService.showNicuCaseRecordJsp(box);
	}

	@Override
	public Map<String, Object> printHeightWeightHeadCircumferenceGraph(Map<String, Object> requestParametersMap) {
		
		return opdDataService. printHeightWeightHeadCircumferenceGraph(requestParametersMap);
	}

	@Override
	public Map<String, Object> printWeightPercentiles(Map<String, Object> requestParametersMap) {
		
		return opdDataService.printWeightPercentiles(requestParametersMap);
	}

	@Override
	public Map<String, Object> printHeightPercentiles(Map<String, Object> requestParametersMap) {
		// TODO Auto-generated method stub
		return opdDataService.printHeightPercentiles(requestParametersMap);
	}

	@Override
	public Map<String, Object> printHeadCircumferencePercentiles(Map<String, Object> requestParametersMap) {
		
		return opdDataService.printHeadCircumferencePercentiles(requestParametersMap);
	}

	@Override
	public Map<String, Object> printGrowthRecord(Map<String, Object> requestParametersMap) {
		
		return opdDataService.printGrowthRecord(requestParametersMap);
	}
	@Override
	public Map<String, Object> showOutSideResultEntryForAntenatal(Map<String, Object> requestParametersMap) {
		
		return opdDataService.showOutSideResultEntryForAntenatal(requestParametersMap);
	}
	@Override
	public Map<String, Object> saveOutSideResultEntryForAntenatal(Map<String, Object> requestParametersMap) {
		
		return opdDataService.saveOutSideResultEntryForAntenatal(requestParametersMap);
	}
	
	
	@Override
	public Map<String, Object> getMedicineTemplateDetails(Box box) {
		
		return opdDataService.getMedicineTemplateDetails(box);
	}

	@Override
	public Map<String, Object> showOrthopedicJsp(
			Map<String, Object> requestParametersMap) {
		return opdDataService.showOrthopedicJsp(requestParametersMap);
	}

	@Override
	public Map<String, Object> getContactLensTemplateDetails(Box box) {
		return opdDataService.getContactLensTemplateDetails(box);
	}

	@Override
	public Map<String, Object> saveContactLensTemplate(Box box) {
		return opdDataService.saveContactLensTemplate(box);
	}
	
	@Override
	public Map<String, Object> showAudiologicalExaminationJsp(
			Map<String, Object> requestParametersMap) {
		return opdDataService.showAudiologicalExaminationJsp(requestParametersMap);
	}
	
	@Override
	public Map<String, Object> saveAudiologicalExamEntSpeciality(Box box) {
		return opdDataService.saveAudiologicalExamEntSpeciality(box);
	}
	
	@Override
	public Map<String, Object> showNephrologyCaseSheetJsp(
			Map<String, Object> requestParametersMap) {
		return opdDataService.showNephrologyCaseSheetJsp(requestParametersMap);
	}
	
	@Override
	public Map<String, Object> saveNephrologyCaseSheetJsp(Box box) {
		return opdDataService.saveNephrologyCaseSheetJsp(box);
	}

	@Override
	public Map<String, Object> saveGynecologyCaseSheet(
			Map<String, Object> mapForDS, Box box) {
		return opdDataService.saveGynecologyCaseSheet(mapForDS, box);
	}
	
	@Override
	public Map<String, Object> showDermatologyLeprosyProformaJsp(Map<String, Object> requestParametersMap) {
		
		return opdDataService.showDermatologyLeprosyProformaJsp(requestParametersMap);
	}
	
	@Override
	public Map<String, Object> showGeneralPsychiatricCaseRecord(Box box) {
		return opdDataService.showGeneralPsychiatricCaseRecord(box);
	}


	@Override
	public Map<String, Object> showOutSideResultEntryDermotology(
			Map<String, Object> requestParametersMap) {
		return opdDataService.showOutSideResultEntryDermotology(requestParametersMap);
	}

	@Override
	public Map<String, Object> showDermatologyGeneralProformaJsp(
			Map<String, Object> requestParametersMap) {
		return opdDataService.showDermatologyGeneralProformaJsp(requestParametersMap);
	}

	@Override
	public Map<String, Object> saveOutSideResultEntryForDermotology(
			Map<String, Object> requestParametersMap) {
		return opdDataService.saveOutSideResultEntryForDermotology(requestParametersMap);
	}
	
	@Override
	public Map<String, Object> getPhototherapyProformaDetails(Box box) {
		return opdDataService.getPhototherapyProformaDetails(box);
	}
	
	@Override
	public Map<String, Object> savePhototherapyProforma(Map<String, Object> mapForDS, Box box, HttpServletRequest request) {
		return opdDataService.savePhototherapyProforma(mapForDS, box, request);
	}
	
	@Override
	public Map<String, Object> showFamilyPlanningGynecologyJsp(
			Map<String, Object> famPlanGynMap) {
		// TODO Auto-generated method stub
		return opdDataService.showFamilyPlanningGynecologyJsp(famPlanGynMap);
	}

	@Override
	public Map<String, Object> saveFamilyPlanningGynecologyJsp(Box box) {
		// TODO Auto-generated method stub
		return opdDataService.saveFamilyPlanningGynecologyJsp(box);
	}
	
	@Override
	public Map<String, Object> saveGeneralPsychiatricCaseRecord(Map<String, Object> mapForDS, Box box){
		return opdDataService.saveGeneralPsychiatricCaseRecord(mapForDS,box);
	}
	

	@Override
	public Map<String, Object> showOutSideLabResultEntry(
			Map<String, Object> requestParametersMap) {
		return opdDataService.showOutSideLabResultEntry(requestParametersMap);
	}
	
	@Override
	public Map<String, Object> getMLCFromRefered() {
		
		return opdDataService.getMLCFromRefered();
	}


	@Override
	public Map<String, Object> htmlTemplateRpt(Map<String, Object> mapForDS) {
		return opdDataService.htmlTemplateRpt(mapForDS);
	}

	@Override
	public Map<String, Object> showDeaddictionCentreJsp(Map<String, Object> requestParametersMap) {		
		return opdDataService.showDeaddictionCentreJsp(requestParametersMap);
	}

	@Override
	public Map<String, Object> showPsychogeriatricClinicJsp(
			Map<String, Object> requestParametersMap) {
		
		return opdDataService.showPsychogeriatricClinicJsp(requestParametersMap);
	}


	@Override
	public Map<String, Object> getFixedInvestigations() {
		return opdDataService.getFixedInvestigations();
	}
	
	@Override
	public Map<String, Object> getMemberDetails(Map map) {
		return opdDataService.getMemberDetails(map);
	}
	
	@Override
	public Map<String, Object> checkForBlockedMedicine(Map<String,Object> dataMap) {
		// TODO Auto-generated method stub
		return opdDataService.checkForBlockedMedicine(dataMap);
	}

	@Override
	public void unBlockMedicine(int medicineTableId) {
		// TODO Auto-generated method stub
		opdDataService.unBlockMedicine(medicineTableId);
	}
	
	@Override
	public Map<String, Object> setVisitUptoTimeOfDoctor(Box box) {
		return opdDataService.setVisitUptoTimeOfDoctor(box);
	}
	
	@Override
	public Map<String, Object> getDrWiseWaitingQueue(Map<String, Object> mapForDS) {
		return opdDataService.getDrWiseWaitingQueue(mapForDS);
	}

	@Override
	public Map<String, Object> getmasAdministrativeSexList() {
		return opdDataService.getmasAdministrativeSexList();
	}

	@Override
	public Map<String, Object> printBMIChart(
			Map<String, Object> requestParametersMap) {
		return opdDataService.printBMIChart(requestParametersMap);
	}
	
	public Map<String, Object> getprescriptionListHTML(Map<String, Object> mapForDS) {
		return opdDataService.getprescriptionListHTML(mapForDS);
	}
	
	
	
	public Map<String, Object> getInvestigationionHTML(Map<String, Object> mapForDS) {
		return opdDataService.getInvestigationionHTML(mapForDS);
	
	}
	
	public Map<String, Object> printANCHtml(Map<String, Object> mapForDS) {
		return opdDataService.printANCHtml(mapForDS);
	
	}
	
	public Map<String, Object> transferToCommonPool(Box box) {
		return opdDataService.transferToCommonPool(box);
	}

	@Override
	public Map<String, Object> saveHemoDialysis(Map<String, Object> infoMap) {
		return opdDataService.saveHemoDialysis(infoMap);
		
	}

	@Override
	public Map<String, Object> showHemoDialysis(Map<String, Object> requestMap) {
		return opdDataService.showHemoDialysis(requestMap);
	}

	@Override
	public Map<String, Object> getVitalDetails(Map<String, Object> requestMap) {
		return opdDataService.getVitalDetails(requestMap);
	}
	
	@Override
	public Map<String, Object> getDoctorSpecificPatientList(Map<String, Object> mapForDS) {
		return opdDataService.getDoctorSpecificPatientList(mapForDS);
	}

	@Override
	public Map<String, Object> getSubParameterDetails(Map<String, Object> generalMap) {
		
		return opdDataService.getSubParameterDetails(generalMap);
	}

	@Override
	public Map<String, Object> displaySubParameterResult(Box box) {
	
		return opdDataService.displaySubParameterResult(box);
	}

	@Override
	public Map<String, Object> showENTExaminationJsp(Box box) {
		// TODO Auto-generated method stub
		return opdDataService.showENTExaminationJsp(box);
	}

	@Override
	public Map<String, Object> viewENTExaminationImages(Box box) {
		
		return opdDataService.viewENTExaminationImages(box);
	}

	@Override
	public Map<String, Object> displayDateWiseENTImages(Box box) {
		// TODO Auto-generated method stub
		return opdDataService.displayDateWiseENTImages(box);
	}


	@Override
	public Map<String, Object> getFamilyTreeDetails(Map<String, Object> infoMap) {
	
		return opdDataService.getFamilyTreeDetails(infoMap);
	}
	
	@Override
	public Map<String, Object> submitFamilyTreeMembers(Map<String, Object> infoMap) {
	
		return opdDataService.submitFamilyTreeMembers(infoMap);
	}

	@Override
	public Map<String, Object> checkForDuplicateExternalTest(
			Map<String, Object> map) {
		return opdDataService.checkForDuplicateExternalTest(map);
	}
	
}