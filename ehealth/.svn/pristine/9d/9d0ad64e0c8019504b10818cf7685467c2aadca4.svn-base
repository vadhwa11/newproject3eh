package jkt.hms.lab.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import jkt.hms.lab.dataservice.LabDataService;
import jkt.hms.masters.business.DgHistoSampleCollectionDetails;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgMasInvestigationReportTemplate;
import jkt.hms.masters.business.DgMasTestKit;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgSampleCollectionDetails;
import jkt.hms.masters.business.DgSubMasInvestigation;
import jkt.hms.masters.business.IpPhysioReqHeader;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.NursingcareSetup;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientMainLabInfo;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;

public class LabHandlerServiceImpl implements LabHandlerService {

	LabDataService labDataService = null;

	// -------------------------Order Booking----------------------------
	public Map<String, Object> showOrderBookingJsp(Map<String, Object> map) {
		return labDataService.showOrderBookingJsp(map);
	}

	public Map<String, Object> getMainAndSubCharge() {
		return labDataService.getMainAndSubCharge();
	}

	public Map<String, Object> getChargeCode(Map<String, Object> parameterMap) {
		return labDataService.getChargeCode(parameterMap);
	}

	public Map<String, Object> fillItemsForChargeCode(
			Map<String, Object> dataMap) {
		return labDataService.fillItemsForChargeCode(dataMap);
	}

	public Map<String, Object> submitOrderBooking(Map<String, Object> infoMap) {
		return labDataService.submitOrderBooking(infoMap);
	}

	public String getOrderSeqForDisplay(String string) {
		return labDataService.getOrderSeqForDisplay(string);
	}

	public Map<String,Object> submitOrderBookingForInvestigation(Box box,
			Map<String, Object> infoMap) {
		return labDataService.submitOrderBookingForInvestigation(box, infoMap);
	}

	public String generateOrderNumber() {
		return labDataService.generateOrderNumber();
	}

	public Map<String, Object> showOrderBookingForInvestigationJsp(int hinId,int hospitalId) {
		return labDataService.showOrderBookingForInvestigationJsp(hinId,hospitalId);
	}

	public Map<String, Object> getDetailsForSearch(Map<String, Object> dataMap) {
		return labDataService.getDetailsForSearch(dataMap);
	}

	public Map<String, Object> getMainAndSubChargeForLab(
			Map<String, Object> parameterMap) {
		return labDataService.getMainAndSubChargeForLab(parameterMap);
	}

	public Map<String, Object> getPatientDetailsSampleColletion(
			Map<String, Object> mapForDs) {
		return labDataService.getPatientDetailsSampleColletion(mapForDs);
	}

	/*
	 * public Map<String, Object> getDetailsForSample() { return
	 * labDataService.getDetailsForSample(); }
	 */
	public List<Patient> getPatientName(String serviceNo) {
		return labDataService.getPatientName(serviceNo);
	}

	public Map<String, Object> getPatientDetails(String hinNo) {
		return labDataService.getPatientDetails(hinNo);
	}

	public Map<String, Object> getPatientDetail(String visitNo) {
		return labDataService.getPatientDetails(visitNo);
	}

	public Map<String, Object> submitSampleCollection(
			Map<String, Object> parameterMap) {
		return labDataService.submitSampleCollection(parameterMap);
	}
	
	public Map<String, Object> submitSampleCollectionEmpanelled(
			Map<String, Object> parameterMap) {
		return labDataService.submitSampleCollectionEmpanelled(parameterMap);
	}

	/*
	 * public Map<String, Object> showSampleCollectionJsp(Map<String, Object>
	 * map) { return labDataService.showSampleCollectionJsp(map); }
	 */

	public Map<String, Object> getSampleCollectionDetails(Map orderMap) {
		return labDataService.getSampleCollectionDetails(orderMap);
	}

	public Map<String, Object> getSampleValidationSearch(Map<String,Object>mapForDs) {
		return labDataService.getSampleValidationSearch(mapForDs);
	}

	public Map<String, Object> getDetailsForValidationSearch() {
		return labDataService.getDetailsForValidationSearch();
	}

	public Map<String, Object> getPatientDetailsForValidation(
			Map<String, Object> mapForDs) {
		return labDataService.getPatientDetailsForValidation(mapForDs);
	}
	
	public Map<String, Object> getPatientDetailsForValidationForEmpanelled(
			Map<String, Object> mapForDs) {
		return labDataService.getPatientDetailsForValidationForEmpanelled(mapForDs);
	}

	public Map<String, Object> getSampleValidationDetails(Map<String, Object> mapForDs) {
		return labDataService.getSampleValidationDetails(mapForDs);
	}
	
	public Map<String, Object> getSampleValidationDetailsForEmpanelled(Map<String, Object> mapForDs) {
		return labDataService.getSampleValidationDetailsForEmpanelled(mapForDs);
	}

	public String getDiagSeqForDisplay(String string) {
		return labDataService.getDiagSeqForDisplay(string);
	}

	public String getSampleSeqForDisplay(String string) {
		return labDataService.getSampleSeqForDisplay(string);
	}

	public boolean submitSampleAcceptance(Map<String, Object> parameterMap) {
		return labDataService.submitSampleAcceptance(parameterMap);
	}
	
	public boolean submitSampleAcceptanceForEmpanelled(Map<String, Object> parameterMap) {
		return labDataService.submitSampleAcceptanceForEmpanelled(parameterMap);
	}

	public Map<String, Object> showSampleNo() {
		return labDataService.showSampleNo();
	}

	public String generateDiagNumber() {
		return labDataService.generateDiagNumber();
	}

	public Map<String, Object> getSampleValidationGrid(
			Map<String, Object> mapForDs) {
		return labDataService.getSampleValidationGrid(mapForDs);
	}
	
	public Map<String, Object> getSampleValidationGridForEmpanelled(
			Map<String, Object> mapForDs) {
		return labDataService.getSampleValidationGridForEmpanelled(mapForDs);
	}

	public Map<String, Object> getPatientDetail(int visitNo) {
		return labDataService.getPatientDetail(visitNo);
	}

	public Map<String, Object> getSampleCollectionGrid(
			Map<String, Object> mapForDs) {
		return labDataService.getSampleCollectionGrid(mapForDs);
	}

	// --------------------------Reports-------------------------------------

	public Map<String, Object> showDiagnosticRegisterDoctorWise(
			Map<String, Object> map) {
		return labDataService.showDiagnosticRegisterDoctorWise(map);
	}

	public Map<String, Object> showDiagnosticRegisterDiagnosisWise(
			Map<String, Object> map) {
		return labDataService.showDiagnosticRegisterDiagnosisWise(map);
	}

	public Map<String, Object> showPackingListJsp() {
		return labDataService.showPackingListJsp();
	}

	// -----------------------By Vishal start---------------------------------

	public Map<String, Object> getConnectionForReport() {
		return labDataService.getConnectionForReport();
	}

	// ----------------------------------------------------------------------------------------------
	public LabDataService getLabDataService() {
		return labDataService;
	}

	public void setLabDataService(LabDataService labDataService) {
		this.labDataService = labDataService;
	}

	public List<Visit> getVisitNo(Map<String, Object> dataMap) {
		return labDataService.getVisitNo(dataMap);
	}
	public List<Visit> getVisitNoForQC(Map<String, Object> dataMap) {
		return labDataService.getVisitNoForQC(dataMap);
	}

	public Map<String, Object> showDepartmentWiseSummary() {
		return labDataService.showDepartmentWiseSummary();
	}

	public List<DgOrderhd> getOrderNoList(Map<String, Object> detailsMap) {
		return labDataService.getOrderNoList(detailsMap);
	}

	public List<Object> getHinNoList(String serviceNo) {
		return labDataService.getHinNoList(serviceNo);
	}

	public List<Object> getResultList(Map<String, Object> detailsMap) {
		return labDataService.getResultList(detailsMap);
	}

	public Map<String, Object> getPatientDetailsForSampleCollection(
			Map<String, Object> mapForDs) {
		return labDataService.getPatientDetailsForSampleCollection(mapForDs);
	}

	public Map<String, Object> getSampleCollectionDetailsForNext(
			int newCollectionId) {
		return labDataService
				.getSampleCollectionDetailsForNext(newCollectionId);
	}

	public Map<String, Object> getSampleValidationDetailsForNext(int newSampleId,int OrderId) {
		return labDataService.getSampleValidationDetailsForNext(newSampleId,OrderId); //changed by govind 3-11-2016
	}

	public Map<String, Object> showDiagnosticRegisterJsp(Map<String, Object> map) {
		return labDataService.showDiagnosticRegisterJsp(map);
	}

	public Map<String, Object> getOrderDetails(Map<String, Object> infoMap) {
		return labDataService.getOrderDetails(infoMap);
	}

	public Map<String, Object> updateOrderDetails(
			Map<String, Object> creationDetailsMap) {
		return labDataService.updateOrderDetails(creationDetailsMap);
	}

	public Map<String, Object> getChargeCodeDetails(String chargeCodeName,
			int hinId,int hospitalId) {
		return labDataService.getChargeCodeDetails(chargeCodeName, hinId, hospitalId);
	}

	public Map<String, Object> getChargeCodeForAutoComplete(
			Map<String, Object> parameterMap) {
		return labDataService.getChargeCodeForAutoComplete(parameterMap);
	}

	public Map<String, Object> showOrderBookingOP(Map<String, Object> map) {
		return labDataService.showOrderBookingOP(map);
	}

	public Map<String, Object> getMainChargeList() {
		return labDataService.getMainChargeList();
	}

	public Map<String, Object> getSubChargeCodeList(int mainCharge) {
		return labDataService.getSubChargeCodeList(mainCharge);
	}

	public Map<String, Object> getChargeCodeList(int subCharge) {
		return labDataService.getChargeCodeList(subCharge);
	}

	public String getHospitalName(int hospitalId) {
		return labDataService.getHospitalName(hospitalId);
	}

	public String getHospitalAddress(int hospitalId) {
		return labDataService.getHospitalAddress(hospitalId);
	}

	// -------------------------------Start Methods developed by Vivek
	// --------------------------------------
	// public Map<String, Object> getOrganismList(Map<String, Object> dataMap) {
	// // TODO Auto-generated method stub
	// return labDataService.getOrganismList(dataMap);
	// }
	// public Map<String, Object> getSensitivityList(Map<String, Object>
	// dataMap) {
	// // TODO Auto-generated method stub
	// return labDataService.getSensitivityList(dataMap);
	// }
	// public Map<String, Object> saveSensitivity(Map<String, Object> dataMap) {
	// // TODO Auto-generated method stub
	// return labDataService.saveSensitivity(dataMap);
	// }

	// -------------------------------End Methods developed by
	// Vivek------------------------------------------
	public Map<String, Object> getTotalCountDepartmentWise(
			Map<String, Object> mapForDs) {
		return labDataService.getTotalCountDepartmentWise(mapForDs);
	}

	public Map<String, Object> getOrderDtMap(Map<String, Object> mapForDs) {
		return labDataService.getOrderDtMap(mapForDs);
	}

	public Map<String, Object> getResultEntryDetailsForLabOrderStatus(
			int dgResultEntryHeaderLabId, Integer deptId) {
		return labDataService.getResultEntryDetailsForLabOrderStatus(
				dgResultEntryHeaderLabId, deptId);
	}

	public Map<String, Object> getResultForRadiologyTest(
			Map<String, Object> mapForDs) {
		return labDataService.getResultForRadiologyTest(mapForDs);
	}

	public Map<String, Object> getResultEntryDetailsForLabOrderStatus(
			int resultId, int deptId) {
		return labDataService.getResultEntryDetailsForLabOrderStatus(resultId,
				deptId);
	}

	public Map<String, Object> printOrderStatusReport(
			Map<String, Object> mapForDs) {
		return labDataService.printOrderStatusReport(mapForDs);
	}

	public Map<String, Object> showDepartmentWiseMonthlySummary(
			Map<String, Object> mapForDs) {
		return labDataService.showDepartmentWiseMonthlySummary(mapForDs);
	}

	public Map<String, Object> showDailyBloodCollectionReport(
			Map<String, Object> mapForDs) {
		return labDataService.showDailyBloodCollectionReport(mapForDs);
	}

	public Map<String, Object> searchPatientTestResultPrint(
			Map<String, Object> mapForDs) {
		return labDataService.searchPatientTestResultPrint(mapForDs);
	}

	public Map<String, Object> showInvestigationReportTemplateJsp(Box box) {
		return labDataService.showInvestigationReportTemplateJsp(box);
	}

	public boolean addInvestigationReportTemplate(
			DgMasInvestigationReportTemplate dgMasInvestigationReportTemplate) {
		return labDataService
				.addInvestigationReportTemplate(dgMasInvestigationReportTemplate);
	}

	public boolean editInvestigationReportTemplate(
			Map<String, Object> generalMap) {
		return labDataService.editInvestigationReportTemplate(generalMap);
	}

	public boolean deleteInvestigationReportTemplate(int investigationId,
			Map<String, Object> generalMap) {
		return labDataService.deleteInvestigationReportTemplate(
				investigationId, generalMap);
	}

	public Map<String, Object> searchInvestigationReportTemplate(
			String searchField) {
		return labDataService.searchInvestigationReportTemplate(searchField);
	}

	// Lab Integration Code With Machine Start 08 Feb 2011 by Ramdular Prajapati
	// +++++

	public Map<String, Object> fillPatientLabDetail(Map<String, Object> dataMap) {
		return labDataService.fillPatientLabDetail(dataMap);
	}

	public List<DgMasInvestigation> findInvestigationName() {
		return labDataService.findInvestigationName();
	}

	public boolean findLabMachineDetails(int investigationId) {
		return labDataService.findLabMachineDetails(investigationId);
	}

	public boolean findSubInvestigationDetails(Map<String, Object> dataMap) {
		return labDataService.findSubInvestigationDetails(dataMap);
	}

	public Map<String, Object> fillInvestigationName(Map map) {
		return labDataService.fillInvestigationName(map);
	}

	@Override
	public List<DgSubMasInvestigation> getSubinvestigationName(
			int investigationId, String investigationType) {
		return labDataService.getSubinvestigationName(investigationId,
				investigationType);
	}

	public boolean addTestParameter(Box box) {
		// TODO Auto-generated method stub
		return labDataService.addTestParameter(box);
	}

	public List<PatientMainLabInfo> findPatientInfoDetails(String machineName,
			String date) {
		return labDataService.findPatientInfoDetails(machineName, date);
	}

	public List<DgSampleCollectionDetails> findDgSampleCollectionDetails() {
		return labDataService.findDgSampleCollectionDetails();
	}

	public boolean addParameterDiagNo(Box box) {
		return labDataService.addParameterDiagNo(box);
	}

	public boolean checkDiagnosisNoDetails(String diagnosisNo) {
		return labDataService.checkDiagnosisNoDetails(diagnosisNo);
	}

	public List<PatientMainLabInfo> findSampleNo() {
		return labDataService.findSampleNo();
	}

	@Override
	public List<PatientMainLabInfo> checkSampleNo(String fromDate,
			String machineName) {
		return labDataService.checkSampleNo(fromDate, machineName);

	}

	@Override
	public boolean addAnalyserResult(Box box) {
		return labDataService.addAnalyserResult(box);
	}

	@Override
	public boolean invalidateAnalyserResult(String diagNo) {
		return labDataService.invalidateAnalyserResult(diagNo);
	}

	public Map<String, Object> LabResultValidateDetails(String sampleNo,
			String fromdate, String machineName) {

		return labDataService.LabResultValidateDetails(sampleNo, fromdate,
				machineName);

	}

	@Override
	public boolean mergeDataXl300(String date, String date1) {
		return labDataService.mergeDataXl300(date, date1);
	}

	@Override
	public Map<String, Object> showinvestigationForLabIntegeration(
			String machineName) {
		return labDataService.showinvestigationForLabIntegeration(machineName);
	}

	@Override
	public Map<String, Object> getResultEntryDetailsForLabOrderStatusNew(
			int dgResultEntryHeaderLabId, Integer deptId) {
		return labDataService.getResultEntryDetailsForLabOrderStatusNew(
				dgResultEntryHeaderLabId, deptId);
	}

	@Override
	public Map<String, Object> getChargeCodeDetails1(String chargeCodeName,
			int hinId) {
		return labDataService.getChargeCodeDetails1(chargeCodeName, hinId);
	}

	@Override
	public boolean savePhysioIP(IpPhysioReqHeader ipph) {
		return labDataService.savePhysioIP(ipph);
	}

	@Override
	public List<MasHospital> getAllHospital() {

		return labDataService.getAllHospital();

	}

	@Override
	public Map<String, Object> getSampleForHistopatologyTestState(
			Map<String, Object> mapForDs) {
		return labDataService.getSampleForHistopatologyTestState(mapForDs);
	}

	@Override
	public Map<String, Object> getPatientDetailsGrossingInHisto(
			Map<String, Object> mapForDs) {

		return labDataService.getPatientDetailsForGrossingInHisto(mapForDs);
	}

	@Override
	public Map<String, Object> getSampleDetailsForHisto(int orderId, int uid,
			int deptId,int hospitalId) {
		
		return labDataService.getSampleValidationDetailsHisto(orderId, uid, deptId,hospitalId);

	}

	@Override
	public DgHistoSampleCollectionDetails getSampleDetailsOfHistoById(
			int orderId) {
		return labDataService.getSampleDetailsOfHistoById(orderId);
	}

	@Override
	public boolean saveDetailsOfHisto(
			Set<String> priviousHistoId,
			Map<Integer, DgHistoSampleCollectionDetails> oldHistoMapOfPriviousStep,
			Map<Integer, List<DgHistoSampleCollectionDetails>> dgHistoMap) {

		return labDataService.saveDetailsOfHisto(priviousHistoId,
				oldHistoMapOfPriviousStep, dgHistoMap);
	}

	@Override
	public List<NursingcareSetup> getNursingcareSetupList(Box box) {
		return labDataService.getNursingcareSetupList(box);
	}

	@Override
	public boolean saveOrUpdateAnyObject(Object object) {

		return labDataService.saveOrUpdateAnyObject(object);
	}

	@Override
	public Map<String, Object> saveBulkOrderBooking(Box box,
			Map<String, Object> utilMap) {

		return labDataService.saveBulkOrderBooking(box, utilMap);
	}

	@Override
	public Map<String, Object> getInvestigationDetailsForDischargeSummary(
			Map<String, Object> detailsMap) {
		return labDataService
				.getInvestigationDetailsForDischargeSummary(detailsMap);
	}

	@Override
	public Set<DgMasTestKit> getAllTestsKitLab(Map<String, Object> detailsMap) {

		return labDataService.getAllTestsKitLab(detailsMap);
	}

	@Override
	public boolean addTestKitInLab(Box box) {
		 
		return labDataService.addTestKitInLab(box);
	}
	@Override
	public Map<String, Object> showDiagnosticRegisterSummaryJsp(
			Map<String, Object> map) {
		return labDataService.showDiagnosticRegisterSummaryJsp(map);
	}
	
	@Override
	public Map<String, Object> getDiagnosticSummary(Box box) {
		return labDataService.getDiagnosticSummary(box);
	}
	@Override
	public Map<String, Object> viewPacsImage(Box box) {
		return labDataService.viewPacsImage(box);
	}
	
	@Override
	public Map<String, Object> getHospName(int hospitalId) {
		return labDataService.getHospName(hospitalId);
	}
	
	@Override
	public Map<String, Object> getDiagnosticRegisterForMultipleTestType(
			Map<String, Object> parameters) {
		return labDataService.getDiagnosticRegisterForMultipleTestType(parameters);
	}
	@Override
	public Map<String, Object> getResultEntryDetailsForMultipleResultType(
			Integer id, int deptId) {
		return labDataService.getResultEntryDetailsForMultipleResultType(id,deptId);
	}
	
	@Override
	public Map<String, Object> getDiagnosticRegister(
			Map<String, Object> parameters) {
		return labDataService.getDiagnosticRegister(parameters);
	}

	@Override
	public Map<String, Object> getOrderListForPatient(int hospitalId,String hinNo) {
		// TODO Auto-generated method stub
		return labDataService.getOrderListForPatient(hospitalId, hinNo);
	}

	@Override
	public Map<String, Object> getsampleListForOrder(int hospitalId, int orderId) {
		return labDataService.getsampleListForOrder( hospitalId,orderId);
	}

	@Override
	public Map<String,Object> getHinNo(Map<String,Object> dataMap) {
		return labDataService.getHinNo(dataMap);
	}

	


	@Override
	public Map<String, Object> getPatientDetailGrid(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return labDataService.getPatientDetailGrid(dataMap);
	}

	@Override
	public Map<String, Object> getWaitingPatientList(
			Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return labDataService.getWaitingPatientList(mapForDS);
	}

	@Override
	public int getVisitNo(int visitId) {
		// TODO Auto-generated method stub
		return labDataService.getVisitNo(visitId);
	}

	@Override
	public Map<String, Object> getInvestigationDetailsForNewRequest(int val) {
		// TODO Auto-generated method stub
		return labDataService.getInvestigationDetailsForNewRequest(val);
	}

	@Override
	public Map<String, Object> getHospitalForDistrict(int districtId,
			int hospitalTypeId) {
		// TODO Auto-generated method stub
		return labDataService.getHospitalForDistrict(districtId,hospitalTypeId);
	}

	@Override
	public String getHinNo(int order_id) {
		return labDataService.getHinNo(order_id);
	}

	@Override
	public Map<String, Object> showPendingForSmearResultPH(Map<String, Object> map) {
		return labDataService.showPendingForSmearResultPH(map);
	}

	@Override
	public Map<String, Object> sendForSampleValidatePh(Box box) {
		return labDataService.sendForSampleValidatePh(box);
	}

	@Override
	public Map<String, Object> htmlWorksheet(Map<String, Object> dataMap) {
		return labDataService.htmlWorksheet(dataMap);
	}

	@Override
	public Map<String, Object> showInvestigationBySubChargeId(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return labDataService.showInvestigationBySubChargeId(dataMap);
	}
	 
	
	
	public Map<String, Object> getChargeCodeDetailsForInvestigation(ArrayList<String> list,String chargeCodeName,
			int hinId) {
		return labDataService.getChargeCodeDetailsForInvestigation(list,chargeCodeName, hinId);
	}
	
	public Map<String, Object> getChargeCodeRate(String chargeCodeName,
			int hinId) {
		return labDataService.getChargeCodeRate(chargeCodeName, hinId);
	}
	
	
	public Map<String, Object> getLabQueue(
			Map<String, Object> mapForDs) {
		return labDataService.getLabQueue(mapForDs);
	}

	
	public Map<String, Object> getRadioQueue(
			Map<String, Object> mapForDs) {
		return labDataService.getRadioQueue(mapForDs);
	}

	@Override
	public Map<String, Object> getSampleValidationGridRadiology(
			Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		return labDataService.getSampleValidationGridRadiology(mapForDs);
	}

	public Map<String, Object> getSampleCollectionGridIPd(
			Map<String, Object> mapForDs) {
		return labDataService.getSampleCollectionGridIPd(mapForDs);
	}
	
	public Map<String, Object> getSampleValidationGridRadiologyIPD(
			Map<String, Object> mapForDs) {
		return labDataService.getSampleValidationGridRadiologyIPD(mapForDs);
	}

	@Override
	public Map<String, Object> addLabInterfaceDataToSDC(
			Map<String, Object> detMap) {
		return labDataService.addLabInterfaceDataToSDC(detMap);
	}

	@Override
	public Map<String, Object> getPendingValidation(Map<String, Object> pendMap) {
		return labDataService.getPendingValidation(pendMap);
	}

	@Override
	public boolean LabParameterNameCheck(Map<String, Object> dataMap) {
		return labDataService.LabParameterNameCheck(dataMap);
	}

	@Override
	public Map<String, Object> getInpatientList(Map<String, Object> dataMap) {
		return labDataService.getInpatientList(dataMap);
	}

	@Override
	public String getResultType(int investigationId) {
		// TODO Auto-generated method stub
		return labDataService.getResultType(investigationId);
	}

	
	@Override
	public Map<String, Object> bookLabForDoctor(Box box) {
		return labDataService.bookLabForDoctor(box);
	}
	
	@Override
	public Map<String, Object> submitSampleCollectionForOutSideLab(Map<String, Object> parameterMap) {
		return labDataService.submitSampleCollectionForOutSideLab(parameterMap);
	}

	@Override
	public Map<String, Object> showExistingOpOrderBookingJsp(Box box) {
		
		return labDataService.showExistingOpOrderBookingJsp(box);
	}

	@Override
	public Map<String, Object> checkDuplicateInvestigation(Box box) {
		
		return labDataService.checkDuplicateInvestigation(box);
	}

	@Override
	public Map<String, Object> submitOrderBookingForExistingInvestigation(Box box, Map<String, Object> infoMap) {
	
		return labDataService.submitOrderBookingForExistingInvestigation(box,infoMap);
	}

	@Override
	public String saveSampleCollectionToLeanCentralServer(Box box) {
		return labDataService.saveSampleCollectionToLeanCentralServer(box);
	}

	@Override
	public Map<String, Object> getLabInvestigationTracker(Box box) {
		return labDataService.getLabInvestigationTracker(box);
	}

}
