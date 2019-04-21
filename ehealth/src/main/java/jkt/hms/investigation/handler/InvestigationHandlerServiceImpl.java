package jkt.hms.investigation.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.investigation.dataservice.InvestigationDataService;  
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgSubMasInvestigation;
import jkt.hms.masters.business.DgTemplate;
import jkt.hms.masters.business.MasLioncSubClass;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.dataservice.CommonMasterDataService;
import jkt.hms.util.Box;

public class InvestigationHandlerServiceImpl implements
		InvestigationHandlerService {
	InvestigationDataService investigationDataService = null;
	CommonMasterDataService commonMasterDataService = null;

	// ---------------------------------------------------------------------------------------------------
	public CommonMasterDataService getCommonMasterDataService() {
		return commonMasterDataService;
	}

	public void setCommonMasterDataService(
			CommonMasterDataService commonMasterDataService) {
		this.commonMasterDataService = commonMasterDataService;
	}

	public InvestigationDataService getInvestigationDataService() {
		return investigationDataService;
	}

	public void setInvestigationDataService(
			InvestigationDataService investigationDataService) {
		this.investigationDataService = investigationDataService;
	}

	// ------------------------------------------------------------------------------------------------------

	public Map<String, Object> showInvestigationJsp(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.showInvestigationJsp(box);
	}

	public Map<String, Object> getChargeDetails(int subChargeCodeId) {
		// TODO Auto-generated method stub
		return investigationDataService.getChargeDetails(subChargeCodeId);
	}

	public Map getResponseSubchargeList(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.getResponseSubchargeList(box);
	}

	public Map getChargeDetails(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.getChargeDetails(box);
	}

	public Map getParameterDetails(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.getParameterDetails(box);
	}

	public Map<String, Object> getNormalValueDetails(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.getNormalValueDetails(box);
	}

	public boolean updateSubTest(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.updateSubTest(box);
	}

	public Map<String, Object> getPatientDetails(Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		return investigationDataService.getPatientDetails(mapForDs);
	}

	public boolean checkInvestigationExsist(String investigationCode,
			String investigationName) {
		// TODO Auto-generated method stub
		return investigationDataService.checkInvestigationExsist(
				investigationCode, investigationName);
	}

	public boolean addInvestigation(DgMasInvestigation dgmasInvestigation) {
		// TODO Auto-generated method stub
		return investigationDataService.addInvestigation(dgmasInvestigation);
	}

	public Map<String, Object> searchInvestigation(String investigationCode,
			String investigationName) {
		// TODO Auto-generated method stub
		return investigationDataService.searchInvestigation(investigationCode,
				investigationName);
	}

	public boolean editInvestigation(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return investigationDataService.editInvestigation(generalMap);
	}

	public Map<String, Object> submitResultEntryForMultiple(
			Map<String, Object> parameterMap) {
		return investigationDataService
				.submitResultEntryForMultiple(parameterMap);
	}

	public String generateResultNumber(Map<String, Object> diagMap) {
		// TODO Auto-generated method stub
		return investigationDataService.generateResultNumber(diagMap);
	}

	public Map<String, Object> getPatientDetailsForResultValidation(
			Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		return investigationDataService
				.getPatientDetailsForResultValidation(mapForDs);
	}

	public Map<String, Object> getAllDetails(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.getAllDetails(box);
	}

	public Map<String, Object> getSampleCollectionDetails(
			int sampleCollectionDetailId, int deptId) {
		// TODO Auto-generated method stub
		return investigationDataService.getSampleCollectionDetails(
				sampleCollectionDetailId, deptId);
	}

	public Map getResultList(int resultId) {
		// TODO Auto-generated method stub
		return investigationDataService.getResultList(resultId);
	}

	public Map<String, Object> getResultEntryDetails(
			Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		return investigationDataService.getResultEntryDetails(mapForDs);
	}

	public boolean submitResultValidationForMultiple(Map<String, Object> infoMap) {
		// TODO Auto-generated method stub
		return investigationDataService
				.submitResultValidationForMultiple(infoMap);
	}

	public Map<String, Object> getPatientDetailsForReportCollection(
			Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		return investigationDataService
				.getPatientDetailsForReportCollection(mapForDs);
	}

	public Map<String, Object> getResultDetails(int resultId) {
		// TODO Auto-generated method stub
		return investigationDataService.getResultDetails(resultId);
	}

	public boolean deleteInvestigation(int chargeCodeId,
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return investigationDataService.deleteInvestigation(chargeCodeId,
				generalMap);
	}

	public Map<String, Object> submitResultEntryForSingleParameterWithNormalValue(
			Map<String, Object> parameterMap) {
		return investigationDataService
				.submitResultEntryForSingleParameterWithNormalValue(parameterMap);
	}

	public boolean submitResultValidationForSingleParameter(
			Map<String, Object> infoMap) {
		// TODO Auto-generated method stub
		return investigationDataService
				.submitResultValidationForSingleParameter(infoMap);
	}

	public Map<String, Object> getDetailsForResultValidation(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.getDetailsForResultValidation(dataMap);
	}
	
	public Map<String, Object> getDetailsForResultValidationOnOpd(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.getDetailsForResultValidationOnOpd(dataMap);
	}
	
	public Map<String, Object> getPatientDetailsForResultPrintingOnOpd(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.getPatientDetailsForResultPrintingOnOpd(dataMap);
	}
	

	public Map<String, Object> getSubTestList(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.getSubTestList(box);
	}

	public Map<String, Object> getDetailsForReportCollection(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.getDetailsForReportCollection(dataMap);
	}

	public Map<String, Object> getDetails(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.getDetails(dataMap);
	}

	public boolean submitNormalValues(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.submitNormalValues(box);
	}

	public Map<String, Object> submitResultEntryForTemplate(
			Map<String, Object> parameterMap) {
		// TODO Auto-generated method stub
		return investigationDataService
				.submitResultEntryForTemplate(parameterMap);
	}

	public boolean submitResultValidationForTemplate(Map<String, Object> infoMap) {
		// TODO Auto-generated method stub
		return investigationDataService
				.submitResultValidationForTemplate(infoMap);
	}

	public boolean submitFixedValues(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.submitFixedValues(box);
	}

	public List<DgTemplate> getTemplateList(int chargeCodeId) {
		return investigationDataService.getTemplateList(chargeCodeId);
	}

	public boolean updateTemplate(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return investigationDataService.updateTemplate(map);
	}

	public Map<String, Object> addSubTest(Box box, Map dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.addSubTest(box, dataMap);
	}

	public Map<String, Object> getFixedList(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.getFixedList(box);
	}

	public List<DgSubMasInvestigation> getChargeList(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.getChargeList(box);
	}

	public boolean submitTemplate(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.submitTemplate(dataMap);
	}

	public Map<String, Object> getResultEntryDetailsForNext(int newResultId,
			int deptId) {
		// TODO Auto-generated method stub
		return investigationDataService.getResultEntryDetailsForNext(
				newResultId, deptId);
	}

	public Map<String, Object> getDetailsForSearch(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.getDetailsForSearch(dataMap);
	}
	
	public Map<String, Object> getResultPendingResult(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.getResultPendingResult(dataMap);
	}

	public boolean updateNormalValue(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.updateNormalValue(box);
	}

	public boolean updateFixedValues(Box box) {
		// TODO Auto-generated method stub
		return investigationDataService.updateFixedValues(box);
	}

	public boolean updateReceivedDetails(Map<String, Object> infoMap) {
		// TODO Auto-generated method stub
		return investigationDataService.updateReceivedDetails(infoMap);
	}

	public Map<String, Object> getResultValidationGrid(
			Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		return investigationDataService.getResultValidationGrid(mapForDs);
	}

	public Map<String, Object> getResultGrid(Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		return investigationDataService.getResultGrid(mapForDs);
	}

	public Map<String, Object> getResultViewGrid(Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		return investigationDataService.getResultViewGrid(mapForDs);
	}

	/** method by mansi * */
	public Map<String, Object> getPatientDetailsForResultValidationOrderNo(
			Map<String, Object> mapForDs) {
		return investigationDataService
				.getPatientDetailsForResultValidationOrderNo(mapForDs);
	}

	public Map<String, Object> getPatientDetailsForResultPrinting(
			Map<String, Object> mapForDs) {
		return investigationDataService
				.getPatientDetailsForResultPrinting(mapForDs);
	}

	public Map<String, Object> getConnectionForReport() {
		// TODO Auto-generated method stub
		return investigationDataService.getConnectionForReport();
	}

	public Map<String, Object> getResultEntryForNext(int newSampleCollectionId,
			int deptId) {
		// TODO Auto-generated method stub
		return investigationDataService.getResultEntryForNext(
				newSampleCollectionId, deptId);
	}

	/** end of method * */

	// -------------------------------Start Methods developed by Vivek
	// --------------------------------------
	public Map<String, Object> getOrganismList(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.getOrganismList(dataMap);
	}

	public Map<String, Object> getResultOrganismList(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.getResultOrganismList(dataMap);
	}

	public Map<String, Object> getSensitivityList(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.getSensitivityList(dataMap);
	}

	public Map<String, Object> saveSensitivity(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.saveSensitivity(dataMap);
	}

	public Map<String, Object> getResultSensitivityList(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService.getResultSensitivityList(dataMap);
	}

	public boolean updateResultTemplateForValidation(Map<String, Object> dataMap) {
		return investigationDataService
				.updateResultTemplateForValidation(dataMap);
	}

	public boolean submitResultValidationForSensitivity(
			Map<String, Object> infoMap) {
		// TODO Auto-generated method stub
		return investigationDataService
				.submitResultValidationForSensitivity(infoMap);
	}

	// -------------------------------End Methods developed by
	// Vivek------------------------------------------
	public Map<String, Object> getResultGridLab(Map<String, Object> mapForDs) {
		return investigationDataService.getResultGridLab(mapForDs);
	}
	
	public Map<String, Object> getResultGridLabForEmpanelled(Map<String, Object> mapForDs) {
		return investigationDataService.getResultGridLabForEmpanelled(mapForDs);
	}

	public String generateResultNumberForLab(Map<String, Object> diagMap) {
		return investigationDataService.generateResultNumberForLab(diagMap);
	}

	public Map<String, Object> getDetailsForLab(Map<String, Object> dataMap) {
		return investigationDataService.getDetailsForLab(dataMap);
	}

	public Map<String, Object> getPatientDetailsForLab(
			Map<String, Object> dataMap) {
		return investigationDataService.getPatientDetailsForLab(dataMap);
	}

	public Map<String, Object> getPatientDetailsForLabForEmpanelled(
			Map<String, Object> dataMap) {
		return investigationDataService.getPatientDetailsForLabForEmpanelled(dataMap);
	} 
	
	public Map<String, Object> getBulkPatientDetailsForResultEntry(
			Map<String, Object> dataMap) {
		return investigationDataService.getBulkPatientDetailsForResultEntry(dataMap);
	}

	public Map<String, Object> getSampleCollectionDetailsForLab(
			Map<String, Object> dataMap) {
		return investigationDataService
				.getSampleCollectionDetailsForLab(dataMap);
	}
	
	public Map<String, Object> getSampleCollectionDetailsForLabForEmpanelled(
			Map<String, Object> dataMap) {
		return investigationDataService
				.getSampleCollectionDetailsForLabForEmpanelled(dataMap);
	}

	public Map<String, Object> getResultValidationLabGrid(
			Map<String, Object> dataMap) {
		return investigationDataService.getResultValidationLabGrid(dataMap);
	}
	
	public Map<String, Object> getResultValidationLabGridForEmpanelled(
			Map<String, Object> dataMap) {
		return investigationDataService.getResultValidationLabGridForEmpanelled(dataMap);
	}
	
	public Map<String, Object> getResultEntryLabGridForPostQC(
			Map<String, Object> dataMap) {
		return investigationDataService.getResultEntryLabGridForPostQC(dataMap);
	}

	public Map<String, Object> getPatientDetailsForResultValidationLab(
			Map<String, Object> dataMap) {
		return investigationDataService
				.getPatientDetailsForResultValidationLab(dataMap);
	}
	
	
	public Map<String, Object> getPatientDetailsForResultValidationLabForEmpanelled(
			Map<String, Object> dataMap) {
		return investigationDataService
				.getPatientDetailsForResultValidationLabForEmpanelled(dataMap);
	}

	public Map<String, Object> getResultEntryDetailsLab(
			Map<String, Object> dataMap) {
		return investigationDataService.getResultEntryDetailsLab(dataMap);
	}
	
	public Map<String, Object> getResultEntryDetailsLabForPostQC(Map<String, Object> dataMap) {
		return investigationDataService.getResultEntryDetailsLabForPostQC(dataMap);
	}

	public boolean submitResultValidationForSingleParameterOnly(
			Map<String, Object> dataMap) {
		return investigationDataService
				.submitResultValidationForSingleParameterOnly(dataMap);
	}
	
	public boolean submitResultValidationForSingleParameterOnlyForEmpanelled(
			Map<String, Object> dataMap) {
		return investigationDataService
				.submitResultValidationForSingleParameterOnlyForEmpanelled(dataMap);
	}

	public boolean submitResultValidationLab(Map<String, Object> dataMap) {
		return investigationDataService.submitResultValidationLab(dataMap);
	}
	
	public boolean submitResultValidationLabForEmpanelled(Map<String, Object> dataMap) {
		return investigationDataService.submitResultValidationLabForEmpanelled(dataMap);
	}
	
	public boolean submitResultEntryForMultipleParameterOnlyPostQC(Map<String, Object> dataMap) {
		return investigationDataService.submitResultEntryForMultipleParameterOnlyPostQC(dataMap);
	}
	public Map<String, Object> getPatientHistory(Map<String, Object> dataMap) {
		return investigationDataService.getPatientHistory(dataMap);
	}

	public Map<String, Object> submitResultEntryForSingleParameterOnly(
			Map<String, Object> dataMap) {
		return investigationDataService
				.submitResultEntryForSingleParameterOnly(dataMap);
	}
	
	public Map<String, Object> submitResultEntryForSingleParameterOnlyForEmpanelled(
			Map<String, Object> dataMap) {
		return investigationDataService
				.submitResultEntryForSingleParameterOnlyForEmpanelled(dataMap);
	}
	
	public Map<String, Object> submitResultEntryForSingleParameterOnlyPostQC(
			Map<String, Object> dataMap) {
		return investigationDataService
				.submitResultEntryForSingleParameterOnlyPostQC(dataMap);
	}

	public Map<String, Object> submitResultEntryForSensitive(
			Map<String, Object> dataMap) {
		return investigationDataService.submitResultEntryForSensitive(dataMap);
	}
	
	public Map<String, Object> submitResultEntryForSensitiveForEmpanelled(
			Map<String, Object> dataMap) {
		return investigationDataService.submitResultEntryForSensitiveForEmpanelled(dataMap);
	}


	public Map<String, Object> submitResultEntryForMultipleInvestigationType(
			Map<String, Object> dataMap) {
		return investigationDataService
				.submitResultEntryForMultipleInvestigationType(dataMap);
	}
	
	public Map<String, Object> submitResultEntryForMultipleInvestigationTypeForEmpanelled(
			Map<String, Object> dataMap) {
		return investigationDataService
				.submitResultEntryForMultipleInvestigationTypeForEmpanelled(dataMap);
	}

	public Map<String, Object> getProvisionalReportDetailsOrderNoWiseLab(
			Map<String, Object> dataMap) {
		return investigationDataService
				.getProvisionalReportDetailsOrderNoWiseLab(dataMap);
	}

	public Map<String, Object> getDetailsForFinalReportByOrderNoLab(
			Map<String, Object> dataMap) {
		return investigationDataService
				.getDetailsForFinalReportByOrderNoLab(dataMap);
	}

	public Map<String, Object> getResultEntryCorrectionLabGrid(
			Map<String, Object> dataMap) {
		return investigationDataService
				.getResultEntryCorrectionLabGrid(dataMap);
	}

	public Map<String, Object> getResultEntryDetailsForTemplate(
			String resultNo, int deptId) {
		return investigationDataService.getResultEntryDetailsForTemplate(
				resultNo, deptId);

	}

	public Map<String, Object> submitResultEntryForTemplateTemparory(
			Map<String, Object> dataMap) {
		return investigationDataService
				.submitResultEntryForTemplateTemparory(dataMap);
	}

	public Map<String, Object> addSubTestWithoutAddingInMasInvestigation(
			Box box, Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return investigationDataService
				.addSubTestWithoutAddingInMasInvestigation(box, dataMap);
	}

	public boolean submitResultEntryForModificationTemplate(
			Map<String, Object> infoMap) {
		return investigationDataService
				.submitResultEntryForModificationTemplate(infoMap);
	}

	public Map<String, Object> getAllValidatedTestForLabOrderNoWise(
			Map<String, Object> requestParameters) {
		return investigationDataService
				.getAllValidatedTestForLabOrderNoWise(requestParameters);
	}

	public Map<String, Object> getAllValidatedTestForOrder(
			Map<String, Object> requestParameters) {
		return investigationDataService
				.getAllValidatedTestForOrder(requestParameters);
	}

	public Map<String, Object> showLioncSubClassJsp(Box box) {
		return investigationDataService.showLioncSubClassJsp(box);
	}

	public boolean addLionClass(MasLioncSubClass masLioncSubClass) {
		return investigationDataService.addLionClass(masLioncSubClass);
	}

	public boolean editLionClass(Map<String, Object> generalMap) {
		return investigationDataService.editLionClass(generalMap);
	}

	public boolean deleteLionClass(int chargeCodeId,
			Map<String, Object> generalMap) {
		return investigationDataService.deleteLionClass(chargeCodeId,
				generalMap);
	}

	public Map<String, Object> searchLionSubClass(String searchField) {
		return investigationDataService.searchLionSubClass(searchField);

	}

	public Map<String, Object> getClassForLionC(Box box) {
		return investigationDataService.getClassForLionC(box);
	}

	public Map<String, Object> getLionClass(Box box) {
		return investigationDataService.getLionClass(box);
	}

	public Map<String, Object> getItemList(Box box) {
		return investigationDataService.getItemList(box);
	}

	public Map<String, Object> getItemStock(Box box) {
		return investigationDataService.getItemStock(box);
	}

	public Map<String, Object> getTestName(Map<String, Object> map) {
		return investigationDataService.getTestName(map);
	}

	public Map<String, Object> getDepartmentList(Map<String, Object> map) {
		return investigationDataService.getDepartmentList(map);
	}

	@Override
	public Map<String, Object> getAllPatientDetailsForResultValidationOrderNo(
			Map<String, Object> mapForDs) {
		return investigationDataService
				.getAllPatientDetailsForResultValidationOrderNo(mapForDs);
	}

	@Override
	public Map<String, Object> printOrderStatusReportWard(
			Map<String, Object> mapForDs) {
		return investigationDataService.printOrderStatusReportWard(mapForDs);
	}

	@Override
	public Map<String, Object> showPaitentTestDetailInResultPrinting(
			Map<String, Object> mapForDs) {
		return investigationDataService
				.showPaitentTestDetailInResultPrinting(mapForDs);
	}

	@Override
	public List<UploadDocuments> getDocumentList(int uploadedDocumentId) {
		return investigationDataService.getDocumentList(uploadedDocumentId);
	}

	@Override
	public boolean rejectSampleHisto(int sampleDetailsId,int sampleHisoDetailsId) {
		return investigationDataService.rejectSampleHisto(sampleDetailsId,sampleHisoDetailsId);
	}

	@Override
	public Map<String, Object> getVisitDetails(int hospitalId, String uhID) {
		return investigationDataService.getVisitDetails(hospitalId,  uhID);
	}

	@Override
	public Map<String, Object> getOrderDetails(int visitId) {
		return investigationDataService.getOrderDetails(visitId);
	}

	@Override
	public Map<String, Object> getSamepleDetails(int orderId) {
		return investigationDataService.getSamepleDetails(orderId);
	}

	public Map<String, Object> validateResultEntryForTempelateLab(
			Map<String, Object> dataMap) {
		return investigationDataService
				.validateResultEntryForTempelateLab(dataMap);
	}
	
	public String saveResultEntryToLeanCentralServer(
			Box box) {
		return investigationDataService
				.saveResultEntryToLeanCentralServer(box);
	}
}
