package jkt.hms.lab.dataservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.llp.LLPException;
import jkt.hms.masters.business.CentralServerSampleData;
import jkt.hms.masters.business.DgHistoSampleCollectionDetails;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgMasInvestigationReportTemplate;
import jkt.hms.masters.business.DgMasTestKit;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgSampleCollectionDetails;
import jkt.hms.masters.business.DgSubMasInvestigation;
import jkt.hms.masters.business.IpPhysioReqHeader;
import jkt.hms.masters.business.LeanServerSampleData;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.NursingcareSetup;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientMainLabInfo;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;

public interface LabDataService {

	// ----------------------Order Booking-------------------------------
	Map<String, Object> showOrderBookingJsp(Map<String, Object> map);

	Map<String, Object> getMainAndSubCharge();

	Map<String, Object> getMainAndSubChargeForLab(
			Map<String, Object> parameterMap);

	Map<String, Object> getChargeCode(Map<String, Object> parameterMap);

	Map<String, Object> fillItemsForChargeCode(Map<String, Object> dataMap);

	Map<String, Object> submitOrderBooking(Map<String, Object> infoMap);

	Map<String,Object> submitOrderBookingForInvestigation(Box box,
			Map<String, Object> infoMap);

	String getOrderSeqForDisplay(String string);

	String generateOrderNumber();

	List<Patient> getPatientName(String serviceNo);

	Map<String, Object> getDetailsForSearch(Map<String, Object> dataMap);

	Map<String, Object> getPatientDetailsSampleColletion(
			Map<String, Object> mapForDs);

	// Map<String, Object> getDetailsForSample();

	Map<String, Object> getPatientDetails(String hinNo);

	Map<String, Object> getPatientDetail(int visitNo);

	Map<String, Object> submitSampleCollection(Map<String, Object> parameterMap);
	
	Map<String, Object> submitSampleCollectionEmpanelled(Map<String, Object> parameterMap);
	
	// Map<String, Object> showSampleCollectionJsp(Map<String, Object> map);

	Map<String, Object> getSampleCollectionDetails(Map<String, Object> orderMap);

	Map<String, Object> getSampleValidationSearch(Map<String,Object>mapForDs);

	Map<String, Object> getDetailsForValidationSearch();

	Map<String, Object> getPatientDetailsForValidation(
			Map<String, Object> mapForDs);
	
	Map<String, Object> getPatientDetailsForValidationForEmpanelled(
			Map<String, Object> mapForDs);
	
	Map<String, Object> getSampleValidationDetailsForEmpanelled(
			Map<String, Object> mapForDs);
	
	Map<String, Object> getSampleValidationDetails(Map<String, Object> mapForDs);
	
	Map<String, Object> getSampleValidationDetailsHisto(int orderId, int uid,
			int deptId,int hospitalId);

	Map<String, Object> showOrderBookingForInvestigationJsp(int hinId,int hospitalId);

	String getDiagSeqForDisplay(String string, int subGroupId);

	String getSampleSeqForDisplay(String string);

	boolean submitSampleAcceptance(Map<String, Object> parameterMap);
	
	boolean submitSampleAcceptanceForEmpanelled(Map<String, Object> parameterMap);
	
	Map<String, Object> showSampleNo();

	String generateDiagNumber(int hinId);

	Map<String, Object> getSampleValidationGrid(Map<String, Object> mapForDs);
	
	Map<String, Object> getSampleValidationGridForEmpanelled(Map<String, Object> mapForDs);

	Map<String, Object> getSampleCollectionGrid(Map<String, Object> mapForDs);

	// ----------------------------Report's Screen----------------------
	Map<String, Object> showPackingListJsp();

	Map<String, Object> showDiagnosticRegisterJsp(Map<String, Object> map);

	Map<String, Object> showDiagnosticRegisterDoctorWise(Map<String, Object> map);

	Map<String, Object> showDiagnosticRegisterDiagnosisWise(
			Map<String, Object> map);

	Map<String, Object> getConnectionForReport();

	List<Visit> getVisitNo(Map<String, Object> dataMap);
	
	List<Visit> getVisitNoForQC(Map<String, Object> dataMap);

	Map<String, Object> showDepartmentWiseSummary();

	List<DgOrderhd> getOrderNoList(Map<String, Object> detailsMap);

	List<Object> getHinNoList(String serviceNo);

	List<Object> getResultList(Map<String, Object> detailsMap);

	String getDiagSeqForDisplay(String string);

	String generateDiagNumber();

	Map<String, Object> getPatientDetailsForSampleCollection(
			Map<String, Object> mapForDs);

	Map<String, Object> getSampleCollectionDetailsForNext(int newCollectionId);

	Map<String, Object> getSampleValidationDetailsForNext(int newSampleId, int orderId);

	// //-------------------------------Start Methods developed by Vivek
	// --------------------------------------
	//
	// Map<String, Object> getOrganismList(Map<String, Object> dataMap);
	//
	// Map<String, Object> getSensitivityList(Map<String, Object> dataMap);
	//
	// Map<String, Object> saveSensitivity(Map<String, Object> dataMap);
	//
	// //-------------------------------End Methods developed by
	// Vivek------------------------------------------

	public Map<String, Object> getOrderDetails(Map<String, Object> mapForDs);

	Map<String, Object> updateOrderDetails(
			Map<String, Object> creationDetailsMap);

	Map<String, Object> getChargeCodeDetails(String chargeCodeName, int hinId, int hospitalId);

	Map<String, Object> getChargeCodeForAutoComplete(
			Map<String, Object> parameterMap);

	Map<String, Object> showOrderBookingOP(Map<String, Object> map);

	Map<String, Object> getMainChargeList();

	Map<String, Object> getSubChargeCodeList(int mainCharge);

	Map<String, Object> getChargeCodeList(int subCharge);

	String getHospitalName(int hospitalId);

	String getHospitalAddress(int hospitalId);

	Map<String, Object> getTotalCountDepartmentWise(Map<String, Object> mapForDs);

	Map<String, Object> getOrderDtMap(Map<String, Object> mapForDs);

	Map<String, Object> getResultEntryDetailsForLabOrderStatus(int resultId,
			Integer deptId);

	Map<String, Object> getResultForRadiologyTest(Map<String, Object> mapForDs);

	Map<String, Object> printOrderStatusReport(Map<String, Object> mapForDs);

	Map<String, Object> showDepartmentWiseMonthlySummary(
			Map<String, Object> mapForDs);

	Map<String, Object> showDailyBloodCollectionReport(
			Map<String, Object> mapForDs);

	Map<String, Object> searchPatientTestResultPrint(
			Map<String, Object> mapForDs);

	Map<String, Object> showInvestigationReportTemplateJsp(Box box);

	boolean addInvestigationReportTemplate(
			DgMasInvestigationReportTemplate dgMasInvestigationReportTemplate);

	boolean editInvestigationReportTemplate(Map<String, Object> generalMap);

	boolean deleteInvestigationReportTemplate(int investigationId,
			Map<String, Object> generalMap);

	public Map<String, Object> searchInvestigationReportTemplate(
			String searchField);

	// Lab Integration Code With Machine Start 08 Feb 2011 by Ramdular Prajapati
	// +++++

	Map<String, Object> fillPatientLabDetail(Map<String, Object> dataMap);

	List<DgMasInvestigation> findInvestigationName();

	boolean findLabMachineDetails(int investigationId);

	boolean findSubInvestigationDetails(Map<String, Object> dataMap);

	Map<String, Object> fillInvestigationName(Map map);

	List<DgSubMasInvestigation> getSubinvestigationName(int investigationId,
			String investigationType);

	public boolean addTestParameter(Box box);

	List<PatientMainLabInfo> findPatientInfoDetails(String machineName,
			String date);

	List<DgSampleCollectionDetails> findDgSampleCollectionDetails();

	boolean addParameterDiagNo(Box box);

	boolean checkDiagnosisNoDetails(String diagnosisNo);

	List<PatientMainLabInfo> findSampleNo();

	List<PatientMainLabInfo> checkSampleNo(String fromDate, String machineName);

	boolean addAnalyserResult(Box box);

	boolean invalidateAnalyserResult(String diagNo);

	Map<String, Object> LabResultValidateDetails(String sampleNo,
			String fromdate, String machineName);

	boolean mergeDataXl300(String date, String date1);

	Map<String, Object> showinvestigationForLabIntegeration(String machineName);

	Map<String, Object> getResultEntryDetailsForLabOrderStatusNew(
			int dgResultEntryHeaderLabId, Integer deptId);

	Map<String, Object> getChargeCodeDetails1(String chargeCodeName, int hinId);

	boolean savePhysioIP(IpPhysioReqHeader ipph);

	public List<MasHospital> getAllHospital();

	Map<String, Object> getSampleForHistopatologyTestState(
			Map<String, Object> mapForDs);

	Map<String, Object> getPatientDetailsForGrossingInHisto(
			Map<String, Object> mapForDs);

	Map<String, Object> getSampleDetailsForHisto(int orderId, int uid,
			int deptId);

	DgHistoSampleCollectionDetails getSampleDetailsOfHistoById(int orderId);

	boolean saveDetailsOfHisto(
			Set<String> priviousHistoId,
			Map<Integer, DgHistoSampleCollectionDetails> oldHistoMapOfPriviousStep,
			Map<Integer, List<DgHistoSampleCollectionDetails>> dgHistoMap);

	boolean saveOrUpdateAnyObject(Object object);

	Map<String, Object> saveBulkOrderBooking(Box box,
			Map<String, Object> utilMap);

	List<NursingcareSetup> getNursingcareSetupList(Box box);

	Map<String, Object> getInvestigationDetailsForDischargeSummary(
			Map<String, Object> detailsMap);

	public Set<DgMasTestKit> getAllTestsKitLab(Map<String, Object> detailsMap);

	boolean addTestKitInLab(Box box);
	
	Map<String, Object> showDiagnosticRegisterSummaryJsp(Map<String, Object> map);
	
	Map<String, Object> getDiagnosticSummary(Box box);
	
	Map<String, Object> viewPacsImage(Box box);
	
	Map<String, Object> getHospName(int hospitalId);
	
	Map<String, Object> getDiagnosticRegisterForMultipleTestType(
			Map<String, Object> parameters);
	
	Map<String, Object> getResultEntryDetailsForMultipleResultType(Integer id,
			int deptId);	
	Map<String, Object> getDiagnosticRegister(Map<String, Object> parameters);

	Map<String, Object> getOrderListForPatient(int hospitalId, String hinNo);

	Map<String, Object> getsampleListForOrder(int hospitalId, int orderId);

	Map<String,Object> getHinNo(Map<String,Object> dataMap);

	Map<String, Object> getWaitingPatientList(Map<String, Object> mapForDS);

	int getVisitNo(int visitId);

	Map<String, Object> getInvestigationDetailsForNewRequest(int val);
	

	Map<String, Object> getPatientDetailGrid(Map<String, Object> dataMap);
	/*List<DgOrderdt> getAckFromPackServer(List<DgOrderdt> dgOrderdts)throws FileNotFoundException, IOException,HL7Exception, LLPException; 
*/
	// Lab Integration Code With Machine End 08 Feb 2011 by Ramdular Prajapati
	// ------

	Map<String, Object> getHospitalForDistrict(int districtId,
			int hospitalTypeId);

	String getHinNo(int order_id);

	Map<String, Object> showPendingForSmearResultPH(Map<String, Object> map);

	Map<String, Object> sendForSampleValidatePh(Box box);
	
	Map<String, Object> htmlWorksheet(Map<String, Object> dataMap);
	
	Map<String, Object> showInvestigationBySubChargeId(Map<String, Object> dataMap);
	
	Map<String, Object> getChargeCodeDetailsForInvestigation(ArrayList<String> list,String chargeCodeName, int hinId);
	
	Map<String, Object> getChargeCodeRate(String chargeCodeName, int hinId);
	
	Map<String, Object> getLabQueue(Map<String, Object> mapForDs);
	
	Map<String, Object> getRadioQueue(Map<String, Object> mapForDs);
	
	Map<String, Object> getSampleValidationGridRadiology(Map<String, Object> mapForDs);
	
	Map<String, Object> getSampleCollectionGridIPd(Map<String, Object> mapForDs);
	
	Map<String, Object> getSampleValidationGridRadiologyIPD(Map<String, Object> mapForDs);

	Map<String, Object> addLabInterfaceDataToSDC(Map<String, Object> detMap);

	Map<String, Object> getPendingValidation(Map<String, Object> pendMap);

	boolean LabParameterNameCheck(Map<String, Object> dataMap);

	Map<String, Object> getInpatientList(Map<String, Object> dataMap);
	
	String getResultType(int investigationId);
	
	Map<String, Object> bookLabForDoctor(Box box);
	
	Map<String, Object> submitSampleCollectionForOutSideLab(Map<String, Object> parameterMap);

	Map<String, Object> showExistingOpOrderBookingJsp(Box box);

	Map<String, Object> checkDuplicateInvestigation(Box box);

	Map<String, Object> submitOrderBookingForExistingInvestigation(Box box,
			Map<String, Object> infoMap);
	
String saveSampleCollectionToLeanCentralServer(Box box);
	
	Map<String, Object> getPatientSampleCollectionDataForCentralServer();
	
	Map<String, Object> getPatientSampleCollectionDataForLeanServer();
	
	String updateCentralServerPatientSampleData(
			CentralServerSampleData centralServerSampleData);
	
	String updateLeanServerPatientSampleData(
			LeanServerSampleData leanServerSampleData);	
	
	Map<String, Object> getPatientSampleValidationDataForCentralServer();
	
	Map<String, Object> getPatientSampleValidationDataForLeanServer();
	
	Map<String, Object> getPatientOrderBookingDataForCentralServer();
	
	Map<String, Object> getPatientOrderBookingDataForLeanServer();
	
	Map<String, Object> getHospitalData(Map<String, Object> objectMap);

	Map<String, Object> getLabInvestigationTracker(Box box);
}
