package jkt.hms.investigation.dataservice;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.CentralServerResultData;
import jkt.hms.masters.business.CentralServerSampleData;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgSubMasInvestigation;
import jkt.hms.masters.business.DgTemplate;
import jkt.hms.masters.business.LeanServerResultData;
import jkt.hms.masters.business.LeanServerSampleData;
import jkt.hms.masters.business.MasLioncSubClass;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.util.Box;

public interface InvestigationDataService {

	public Map<String, Object> showInvestigationJsp(Box box);

	// public Map<String, Object> showSubInvestigationJsp(int chargeCodeId);
	public Map<String, Object> getChargeDetails(int subChargeCodeId);

	public List<DgSubMasInvestigation> getChargeList(Box box);

	public Map<String, Object> addSubTest(Box box, Map dataMap);

	public Map<String, Object> getResponseSubchargeList(Box box);

	public Map<String, Object> getChargeDetails(Box box);

	public Map<String, Object> getParameterDetails(Box box);

	public Map<String, Object> getNormalValueDetails(Box box);

	public boolean updateSubTest(Box box);

	public Map<String, Object> getDetailsForSearch(Map<String, Object> dataMap);
	
	public Map<String, Object> getResultPendingResult(Map<String, Object> dataMap);
	
	public Map<String, Object> getPatientDetails(Map<String, Object> mapForDs);

	public Map<String, Object> getAllDetails(Box box);

	public boolean checkInvestigationExsist(String investigationCode,
			String investigationName);

	boolean addInvestigation(DgMasInvestigation dgmasInvestigation);

	public Map<String, Object> searchInvestigation(String investigationCode,
			String investigationName);

	public boolean editInvestigation(Map<String, Object> generalMap);

	Map<String, Object> submitResultEntryForMultiple(
			Map<String, Object> parameterMap);

	public String generateResultNumber(Map<String, Object> diagMap);

	Map<String, Object> getPatientDetailsForResultValidation(
			Map<String, Object> mapForDs);

	public Map<String, Object> getSampleCollectionDetails(
			int sampleCollectionDetailId, int deptId);

	public Map getResultList(int resultId);

	public Map<String, Object> getResultEntryDetails(Map<String, Object> mapForDs);

	public boolean submitResultValidationForMultiple(Map<String, Object> infoMap);

	public Map<String, Object> getPatientDetailsForReportCollection(
			Map<String, Object> mapForDs);

	public Map<String, Object> getResultDetails(int resultId);

	public boolean deleteInvestigation(int chargeCodeId,
			Map<String, Object> generalMap);

	Map<String, Object> submitResultEntryForSingleParameterWithNormalValue(
			Map<String, Object> parameterMap);

	public boolean submitResultValidationForSingleParameter(
			Map<String, Object> infoMap);

	public Map<String, Object> getDetailsForResultValidation(
			Map<String, Object> dataMap);
	
	public Map<String, Object> getDetailsForResultValidationOnOpd(
			Map<String, Object> dataMap);
	
	public Map<String, Object> getPatientDetailsForResultPrintingOnOpd(
			Map<String, Object> dataMap);
	
	
	public Map<String, Object> getSubTestList(Box box);

	public Map<String, Object> getDetailsForReportCollection(
			Map<String, Object> dataMap);

	public Map<String, Object> getDetails(Map<String, Object> dataMap);

	public boolean submitNormalValues(Box box);

	public Map<String, Object> submitResultEntryForTemplate(
			Map<String, Object> parameterMap);

	public boolean submitResultValidationForTemplate(Map<String, Object> infoMap);

	public boolean submitFixedValues(Box box);

	public boolean submitTemplate(Map<String, Object> dataMap);

	public List<DgTemplate> getTemplateList(int chargeCodeId);

	public boolean updateTemplate(Map<String, Object> map);

	public Map<String, Object> getFixedList(Box box);

	public Map<String, Object> getResultEntryDetailsForNext(int newResultId,
			int deptId);

	public boolean updateNormalValue(Box box);

	public boolean updateFixedValues(Box box);

	public boolean updateReceivedDetails(Map<String, Object> infoMap);

	public Map<String, Object> getResultValidationGrid(
			Map<String, Object> mapForDs);

	public Map<String, Object> getResultGrid(Map<String, Object> mapForDs);

	public Map<String, Object> getResultViewGrid(Map<String, Object> mapForDs);

	public Map<String, Object> getPatientDetailsForResultValidationOrderNo(
			Map<String, Object> mapForDs);
	public Map<String, Object> getPatientDetailsForResultPrinting(
			Map<String, Object> mapForDs);
	

	public Map<String, Object> getConnectionForReport();

	public Map<String, Object> getResultEntryForNext(int newSampleCollectionId,
			int deptId);

	public boolean updateResultTemplateForValidation(Map<String, Object> dataMap);

	// -------------------------------Start Methods developed by Vivek
	// --------------------------------------

	Map<String, Object> getOrganismList(Map<String, Object> dataMap);

	Map<String, Object> getResultOrganismList(Map<String, Object> dataMap);

	Map<String, Object> getSensitivityList(Map<String, Object> dataMap);

	Map<String, Object> getResultSensitivityList(Map<String, Object> dataMap);

	Map<String, Object> saveSensitivity(Map<String, Object> dataMap);

	// -------------------------------End Methods developed by
	// Vivek------------------------------------------
	Map<String, Object> getResultGridLab(Map<String, Object> dataMap);
	
	Map<String, Object> getResultGridLabForEmpanelled(Map<String, Object> dataMap);
	
	String generateResultNumberForLab(Map<String, Object> diagMap);

	Map<String, Object> getDetailsForLab(Map<String, Object> dataMap);

	Map<String, Object> getPatientDetailsForLab(Map<String, Object> dataMap);
	
	Map<String, Object> getPatientDetailsForLabForEmpanelled(Map<String, Object> dataMap);
	
	Map<String, Object> getBulkPatientDetailsForResultEntry(Map<String, Object> dataMap);

	Map<String, Object> getSampleCollectionDetailsForLab(
			Map<String, Object> dataMap);
	
	Map<String, Object> getSampleCollectionDetailsForLabForEmpanelled(
			Map<String, Object> dataMap);
	
	Map<String, Object> getResultValidationLabGrid(Map<String, Object> dataMap);
	
	Map<String, Object> getResultValidationLabGridForEmpanelled(Map<String, Object> dataMap);
	
	Map<String, Object> getResultEntryLabGridForPostQC(Map<String, Object> dataMap);

	Map<String, Object> getPatientDetailsForResultValidationLab(
			Map<String, Object> dataMap);
	
	Map<String, Object> getPatientDetailsForResultValidationLabForEmpanelled(
			Map<String, Object> dataMap);
	
	Map<String, Object> getResultEntryDetailsLab(Map<String, Object> dataMap);
	
	Map<String, Object> getResultEntryDetailsLabForPostQC(Map<String, Object> dataMap);
	
	boolean submitResultValidationForSingleParameterOnly(
			Map<String, Object> dataMap);
	
	boolean submitResultValidationForSingleParameterOnlyForEmpanelled(
			Map<String, Object> dataMap);

	boolean submitResultValidationLab(Map<String, Object> dataMap);
	
	boolean submitResultValidationLabForEmpanelled(Map<String, Object> dataMap);
	
	boolean submitResultEntryForMultipleParameterOnlyPostQC(Map<String, Object> dataMap);
	
	Map<String, Object> getPatientHistory(Map<String, Object> dataMap);
	
	Map<String, Object> submitResultEntryForSingleParameterOnly(
			Map<String, Object> dataMap);
	
	Map<String, Object> submitResultEntryForSingleParameterOnlyForEmpanelled(
			Map<String, Object> dataMap);
	
	
	Map<String, Object> submitResultEntryForSingleParameterOnlyPostQC(
			Map<String, Object> dataMap);
	
	Map<String, Object> submitResultEntryForMultipleInvestigationTypeForEmpanelled(
			Map<String, Object> dataMap);

	Map<String, Object> submitResultEntryForMultipleInvestigationType(
			Map<String, Object> dataMap);

	Map<String, Object> getProvisionalReportDetailsOrderNoWiseLab(
			Map<String, Object> dataMap);

	Map<String, Object> getDetailsForFinalReportByOrderNoLab(
			Map<String, Object> dataMap);

	Map<String, Object> getResultEntryCorrectionLabGrid(
			Map<String, Object> dataMap);

	public boolean submitResultValidationForSensitivity(
			Map<String, Object> infoMap);

	Map<String, Object> getResultEntryDetailsForTemplate(String resultNo,
			int deptId);

	Map<String, Object> submitResultEntryForTemplateTemparory(
			Map<String, Object> dataMap);

	Map<String, Object> addSubTestWithoutAddingInMasInvestigation(Box box,
			Map<String, Object> dataMap);

	public boolean submitResultEntryForModificationTemplate(
			Map<String, Object> infoMap);

	public Map<String, Object> getAllValidatedTestForLabOrderNoWise(
			Map<String, Object> requestParameters);

	public Map<String, Object> getAllValidatedTestForOrder(Map<String, Object> requestParameters);
	public Map<String, Object> showLioncSubClassJsp(Box box);
	boolean addLionClass(MasLioncSubClass masLioncSubClass);
	public boolean editLionClass(Map<String, Object> generalMap);
	public boolean deleteLionClass(int chargeCodeId,
			Map<String, Object> generalMap);
	public Map<String, Object> searchLionSubClass(String searchField);
	Map<String, Object> getClassForLionC(Box box);
	 public Map<String,Object> getLionClass(Box box);
	public Map<String, Object> getItemList(Box box);
	 public Map<String, Object>getItemStock(Box box);
	 public Map<String, Object>getTestName(Map<String, Object>map);
	 Map<String, Object> submitResultEntryForSensitive(
				Map<String, Object> dataMap);
	 
	 Map<String, Object> submitResultEntryForSensitiveForEmpanelled(
				Map<String, Object> dataMap);
	 
	 public Map<String, Object>getDepartmentList(Map<String, Object>map);

	public Map<String, Object> getAllPatientDetailsForResultValidationOrderNo(Map<String, Object> mapForDs);

	public Map<String, Object> printOrderStatusReportWard(Map<String, Object> mapForDs);
	public Map<String, Object> showPaitentTestDetailInResultPrinting(Map<String, Object> mapForDs);

	public List<UploadDocuments> getDocumentList(int uploadedDocumentId);

	public boolean rejectSampleHisto(int sampleDetailsId,int sampleHisoDetailsId);

	public Map<String, Object> getVisitDetails(int hospitalId, String uhID);

	public Map<String, Object> getOrderDetails(int visitId);

	public Map<String, Object> getSamepleDetails(int orderId);
	
	public Map<String, Object> validateResultEntryForTempelateLab(
			Map<String, Object> dataMap);
	
	public String saveResultEntryToLeanCentralServer(Box box);
	
	public Map<String, Object> getPatientResultEntryDataForCentralServer();
	
	public Map<String, Object> getPatientResultEntryDataForLeanServer();
	
	public String updateCentralServerPatientResultData(
			CentralServerResultData centralServerResultData);
	
	public String updateLeanServerPatientResultData(
			LeanServerResultData leanServerResultData);	
	
	public Map<String, Object> getPatientResultValidationDataForCentralServer();
	
	public Map<String, Object> getPatientResultValidationDataForLeanServer();
	
	public Map<String, Object> getHospitalData(Map<String, Object> objectMap);

}
