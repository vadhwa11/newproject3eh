package jkt.hms.bloodBank.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.bloodBank.dataservice.BloodBankDataService;
import jkt.hms.masters.business.BloodAssessmentEntryM;
import jkt.hms.masters.business.BloodConsent;
import jkt.hms.masters.business.BloodMasComponent;
import jkt.hms.masters.business.BloodReactionEntry;
import jkt.hms.masters.business.BloodTransfusion;
import jkt.hms.masters.business.Patient;
import jkt.hms.util.Box;

public class BloodBankHandlerServiceImpl implements BloodBankHandlerService {

	BloodBankDataService bloodBankDataService;

	// ---------------Blood ComponentMaster---------------------

	public Map<String, Object> showBloodComponentJsp(int hospitalId,int departmentId) {
		return bloodBankDataService.showBloodComponentJsp( hospitalId, departmentId);
	}
	
	public Map<String, Object> getBloodSampleCollectionDetail(Box box) {
		return bloodBankDataService.getBloodSampleCollectionDetail(box);
	}
	/*public Map<String, Object> showBloodComponentJsp(int Id) {
		return bloodBankDataService.showBloodComponentJsp(Id);
	}*/

	public boolean addBloodComponent(BloodMasComponent bloodMasComponent) {
		return bloodBankDataService.addBloodComponent(bloodMasComponent);
	}

	public boolean editBloodComponent(Map<String, Object> generalMap) {
		return bloodBankDataService.editBloodComponent(generalMap);
	}

	public boolean deleteBloodComponent(int bloodComponentId,
			Map<String, Object> generalMap) {
		return bloodBankDataService.deleteBloodComponent(bloodComponentId,
				generalMap);
	}

	public Map<String, Object> searchBloodComponent(String bloodComponentCode,
			String bloodComponentName) {
		return bloodBankDataService.searchBloodComponent(bloodComponentCode,
				bloodComponentName);
	}

	public Map<String, Object> showDonorAssesstmentMasterJsp(int page,int recordsPerPage){
		
		return bloodBankDataService.showDonorAssesstmentMasterJsp(page,recordsPerPage);
	}
	// -----Blood Request Entry-----------------------

	public Map<String, Object> getPatientForBloodRequest(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.getPatientForBloodRequest(mapForDs);
	}

	// -----------------------------------------------------------------------
	public BloodBankDataService getBloodBankDataService() {
		return bloodBankDataService;
	}

	public void setBloodBankDataService(
			BloodBankDataService bloodBankDataService) {
		this.bloodBankDataService = bloodBankDataService;
	}

	public Map<String, Object> fillItemsForComponentname(
			Map<String, Object> dataMap) {
		return bloodBankDataService.fillItemsForComponentname(dataMap);
	}

	public Map<String, Object> getDetailsForBloodRequestEnquiry() {
		return bloodBankDataService.getDetailsForBloodRequestEnquiry();
	}

	/*public Map<String, Object> showBloodRequestEntryJsp(int hinId) {
		return bloodBankDataService.showBloodRequestEntryJsp(hinId);
	}*/

	public String getOrderSeqForDisplay(String string,int hospitalId) {
		return bloodBankDataService.getOrderSeqForDisplay(string,hospitalId);
	}

	public String generateOrderNumber() {
		return bloodBankDataService.generateOrderNumber();
	}

	public boolean submitBloodRequestEntry(Map<String, Object> infoMap) {
		return bloodBankDataService.submitBloodRequestEntry(infoMap);
	}

	public Map<String, Object> getComponentNameForAutoComplete(
			Map<String, Object> parameterMap) {
		return bloodBankDataService
				.getComponentNameForAutoComplete(parameterMap);
	}

	public Map<String, Object> showBloodDonationEntryJsp(Box box) {
		return bloodBankDataService.showBloodDonationEntryJsp(box);
	}

	public Map<String, Object> getSampleCollectionGrid(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.getSampleCollectionGrid(mapForDs);
	}

	public Map<String, Object> getDetailsForSampleCollection() {
		return bloodBankDataService.getDetailsForSampleCollection();
	}

	public Map<String, Object> getBloodSampleCollectionDetails(Map orderMap) {
		return bloodBankDataService.getBloodSampleCollectionDetails(orderMap);
	}

	public Map<String, Object> getPatientDetailSampleCollection(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.getPatientDetailSampleCollection(mapForDs);
	}

	public Map<String, Object> getSampleCollectionDetailsForNext(
			int newRequestId) {
		return bloodBankDataService
				.getSampleCollectionDetailsForNext(newRequestId);
	}

	public Map<String, Object> submitBloodSampleCollection(
			Box box) {
		return bloodBankDataService.submitBloodSampleCollection(box);
	}
	
	public Map<String, Object> submitSampleOfBlood(
			Box box) {
		return bloodBankDataService.submitSampleOfBlood(box);
	}
	

	public String generateSampleCollectionNumber() {
		return bloodBankDataService.generateSampleCollectionNumber();
	}

	public String getSampleCollectionSeqForDisplay(String string) {
		return bloodBankDataService.getSampleCollectionSeqForDisplay(string);
	}

	public Map<String, Object> showBloodSampleColletionJsp(int requestId) {
		return bloodBankDataService.showBloodSampleColletionJsp(requestId);
	}

	public String getSampleTestSeqForDisplay(String string) {
		return bloodBankDataService.getSampleTestSeqForDisplay(string);
	}

	public Map<String, Object> getDetailsForSampleValidation() {
		return bloodBankDataService.getDetailsForSampleValidation();
	}

	public Map<String, Object> getPatientDetailSampleValidation(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.getPatientDetailSampleValidation(mapForDs);
	}

	public Map<String, Object> getSampleValidationGrid(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.getSampleValidationGrid(mapForDs);
	}

	public Map<String, Object> showBloodSampleValidationJsp(int sampleId) {
		return bloodBankDataService.showBloodSampleValidationJsp(sampleId);
	}

	public boolean submitBloodSampleValidation(Map<String, Object> parameterMap) {
		return bloodBankDataService.submitBloodSampleValidation(parameterMap);
	}

	public Map<String, Object> getPatientDetailBloodSampleScreening(
			Map<String, Object> mapForDs) {
		return bloodBankDataService
				.getPatientDetailBloodSampleScreening(mapForDs);
	}

	public Map<String, Object> showBloodSampleScreening(int sampleId) {
		return bloodBankDataService.showBloodSampleScreening(sampleId);
	}

	public Map<String, Object> getDetailsForSampleScreeningTest() {
		return bloodBankDataService.getDetailsForSampleScreeningTest();
	}

	public Map<String, Object> getSampleScreeningTestGrid(
			Box box) {
		return bloodBankDataService.getSampleScreeningTestGrid(box);
	}
	
	public Map<String, Object> getTestName(Map<String, Object> parameterMap) {
		return bloodBankDataService.getTestName(parameterMap);
	}

	public String generateSampleTestNumber() {
		return bloodBankDataService.generateSampleTestNumber();
	}

	public boolean submitBloodSampleScreeningTest(Map<String, Object> infoMap) {
		return bloodBankDataService.submitBloodSampleScreeningTest(infoMap);
	}

	public Map<String, Object> getBloodIssueGrid(Map<String, Object> mapForDs) {
		return bloodBankDataService.getBloodIssueGrid(mapForDs);
	}

	public Map<String, Object> getDetailsForBloodIssue() {
		return bloodBankDataService.getDetailsForBloodIssue();
	}

	public Map<String, Object> showStockOpeningBalance() {
		return bloodBankDataService.showStockOpeningBalance();
	}

	public Map<String, Object> showBloodDiscardJsp(int bloodStockDetailId) {
		return bloodBankDataService.showBloodDiscardJsp(bloodStockDetailId);
	}

	public String generateOpeningNumber() {
		return bloodBankDataService.generateOpeningNumber();
	}

	public Map<String, Object> submitStockOpeningBalance(
			Map<String, Object> infoMap) {
		return bloodBankDataService.submitStockOpeningBalance(infoMap);
	}

	public List<Patient> getPateintDetail(String hinNo) {
		return bloodBankDataService.getPateintDetail(hinNo);
	}

	public String getStockSeqNoForDisplay(String string) {
		return bloodBankDataService.getStockSeqNoForDisplay(string);
	}

	public String getDonationSeqNoForDisplay(String string) {
		return bloodBankDataService.getDonationSeqNoForDisplay(string);
	}

	public Map<String, Object>  submitBloodDonationEntry(Map<String, Object> infoMap) {
		return bloodBankDataService.submitBloodDonationEntry(infoMap);
	}

	public String generateDonationNumber() {
		return bloodBankDataService.generateDonationNumber();
	}

	// ------------------------Donor Blood Pending For Sample
	// Screening--------------------------------
	public Map<String, Object> getDetailsForDonorSampleScreening() {
		return bloodBankDataService.getDetailsForDonorSampleScreening();
	}

	public Map<String, Object> getDonorSampleScreeningGrid(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.getDonorSampleScreeningGrid(mapForDs);
	}

	public Map<String, Object> showDonorBloodSampleScreeningTest(int donationId) {
		return bloodBankDataService
				.showDonorBloodSampleScreeningTest(donationId);
	}

	public Map<String, Object> getDonorDetailBloodSampleScreening(
			Map<String, Object> mapForDs) {
		return bloodBankDataService
				.getDonorDetailBloodSampleScreening(mapForDs);
	}

	public String getDonorSampleTestSeqForDisplay(String string) {
		return bloodBankDataService.getDonorSampleTestSeqForDisplay(string);
	}

	public boolean submitDonorBloodSampleScreeningTest(
			Map<String, Object> infoMap) {
		return bloodBankDataService
				.submitDonorBloodSampleScreeningTest(infoMap);
	}

	public Map<String, Object> showBloodComponentSeparationJsp(int hospitalId) {
		return bloodBankDataService.showBloodComponentSeparationJsp( hospitalId);
	}

	public Map<String, Object> getBloodBagNoForAutoComplete(
			Map<String, Object> parameterMap) {
		return bloodBankDataService.getBloodBagNoForAutoComplete(parameterMap);
	}

	public Map<String, Object> getPatientList(String hinNo) {
		return bloodBankDataService.getPatientList(hinNo);
	}

	public Map<String, Object> showBloodTestEntryJsp() {
		return bloodBankDataService.showBloodTestEntryJsp();
	}

	public String generateSerialNumber() {
		return bloodBankDataService.generateSerialNumber();
	}

	public boolean submitBloodTestEntry(Map<String, Object> infoMap) {
		return bloodBankDataService.submitBloodTestEntry(infoMap);
	}
	public boolean submitBloodTestEntryCg(Map<String, Object> infoMap){
	return bloodBankDataService.submitBloodTestEntryCg(infoMap);
}
	
	public boolean submitBloodTestEntrySg(Map<String, Object> infoMap){
		return bloodBankDataService.submitBloodTestEntrySg(infoMap);
		
	}

	public Map<String, Object> fillItemsForInvestigationName(
			Map<String, Object> dataMap) {
		return bloodBankDataService.fillItemsForInvestigationName(dataMap);
	}

	public Map<String, Object> getPatientDetailBloodIssue(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.getPatientDetailBloodIssue(mapForDs);
	}

	public String getBloodIssueSeqForDisplay(String string) {
		return bloodBankDataService.getBloodIssueSeqForDisplay(string);
	}

	public Map<String, Object> showBloodIssueJsp(int screeningId) {
		return bloodBankDataService.showBloodIssueJsp(screeningId);
	}

	public String generateMonthlyNumber() {
		return bloodBankDataService.generateMonthlyNumber();
	}

	/*public boolean submitBloodIssue(Map<String, Object> infoMap) {
		return bloodBankDataService.submitBloodIssue(infoMap);
	}*/
	
	public boolean submitBloodIssue(Box box) {
		return bloodBankDataService.submitBloodIssue(box);
	}

	public String generateDonorSampleTestNumber() {
		return bloodBankDataService.generateDonorSampleTestNumber();
	}

	public String getDiscardSeqForDisplay(String string) {
		return bloodBankDataService.getDiscardSeqForDisplay(string);
	}

	public String generateDiscardNumber() {
		return bloodBankDataService.generateDiscardNumber();
	}

	public boolean submitBloodDiscard(Map<String, Object> parameterMap) {
		return bloodBankDataService.submitBloodDiscard(parameterMap);
	}

	public Map<String, Object> showSearchPatientForReactionJsp(int hospitalId) {
		return bloodBankDataService.showSearchPatientForReactionJsp(hospitalId);
	}

	public Map<String, Object> searchPatientForBloodReaction(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.searchPatientForBloodReaction(mapForDs);
	}

	public Map<String, Object> showReactionFormEntryJsp(int inpatientId,int hospitalId,int deptId) {
		return bloodBankDataService.showReactionFormEntryJsp(inpatientId,hospitalId,deptId);
	}

	public String getEntrySeqForDisplay(String string) {
		return bloodBankDataService.getEntrySeqForDisplay(string);
	}

	public String generateEntryNumber() {
		return bloodBankDataService.generateEntryNumber();
	}

	public boolean submitBloodReactionEntry(BloodReactionEntry bldReactionEntry,Box box) {
		return bloodBankDataService.submitBloodReactionEntry(bldReactionEntry,box);
	}

	public Map<String, Object> showDirectIndirectRegisterReport() {
		return bloodBankDataService.showDirectIndirectRegisterReport();
	}

	public String getSerialSeqForDisplay(String string) {
		return bloodBankDataService.getSerialSeqForDisplay(string);
	}

	public Map<String, Object> getDBConnection() {
		return bloodBankDataService.getDBConnection();
	}

	public Map<String, Object> fillPatientDetail(Map<String, Object> dataMap) {
		return bloodBankDataService.fillPatientDetail(dataMap);
	}

	public Map<String, Object> showPatientSearchForBloodTransfusionJsp() {
		return bloodBankDataService.showPatientSearchForBloodTransfusionJsp();
	}

	public Map<String, Object> getPatientForBloodTransfusion(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.getPatientForBloodTransfusion(mapForDs);
	}

	public Map<String, Object> showConsentBloodTransfusion(int inpatientId) {
		return bloodBankDataService.showConsentBloodTransfusion(inpatientId);
	}

	public int getTransfusionEntrySeqForDisplay(String string) {
		return bloodBankDataService.getTransfusionEntrySeqForDisplay(string);
	}

	public int generateTransfusionEntryNumber() {
		return bloodBankDataService.generateTransfusionEntryNumber();
	}

	public boolean submitBloodTransfusion(BloodTransfusion bloodTransfusion) {
		return bloodBankDataService.submitBloodTransfusion(bloodTransfusion);
	}

	public Map<String, Object> showPatientSearchForDonationJsp(Map<String, Object> map) {
		return bloodBankDataService.showPatientSearchForDonationJsp(map);
	}

	public Map<String, Object> getPatientForUpdateDonation(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.getPatientForUpdateDonation(mapForDs);
	}

	public Map<String, Object> showUpdateDonationEntry(int bloodDonationId) {
		return bloodBankDataService.showUpdateDonationEntry(bloodDonationId);
	}

	public Map<String, Object> submitBloodComponentSeperation(Box box,
			Map<String, Object> dataMap) {
		return bloodBankDataService
				.submitBloodComponentSeperation(box, dataMap);
	}

	public Map<String, Object> showUpdateReactonEntry(int reactionId) {
		return bloodBankDataService.showUpdateReactonEntry(reactionId);
	}

	public Map<String, Object> searchPatientForUpdateReaction(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.searchPatientForUpdateReaction(mapForDs);
	}

	public boolean updateBloodReaction(Map<String, Object> generalMap) {
		return bloodBankDataService.updateBloodReaction(generalMap);
	}

	public Map<String, Object> showPendingForTransfussionReaction() {
		return bloodBankDataService.showPendingForTransfussionReaction();

	}

	public Map<String, Object> searchPatientForTransfussionReaction(
			Map<String, Object> mapForDs) {
		return bloodBankDataService
				.searchPatientForTransfussionReaction(mapForDs);
	}

	public String getTransfussionTestSeqForDisplay(String string) {
		return bloodBankDataService.getTransfussionTestSeqForDisplay(string);
	}

	public Map<String, Object> showTransfussionReaction(int bloodReactionId, int hospitalId) {
		return bloodBankDataService.showTransfussionReaction(bloodReactionId, hospitalId);
	}

	public Map<String, Object> fillDonorDetail(Map<String, Object> dataMap) {
		return bloodBankDataService.fillDonorDetail(dataMap);
	}

	public Map<String, Object> showPopUpBloodIssueJsp(Map<String, Object> map) {
		return bloodBankDataService.showPopUpBloodIssueJsp(map);
	}

	public boolean submitPopbloodIssue(int stockDetailId,
			Map<String, Object> generalMap) {
		return bloodBankDataService.submitPopbloodIssue(stockDetailId,
				generalMap);
	}

	public boolean updateBloodDonation(Box box) {
		return bloodBankDataService.updateBloodDonation(box);
	}

	public boolean updateBloodTestEntry(Box box) {
		return bloodBankDataService.updateBloodTestEntry(box);
	}

	public Map<String, Object> searchPatientForUpdateTest(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.searchPatientForUpdateTest(mapForDs);
	}

	public Map<String, Object> showUpdateTestEntry(int bloodTestId) {
		return bloodBankDataService.showUpdateTestEntry(bloodTestId);
	}

	public int generateTransfusionTestNumber() {
		return bloodBankDataService.generateTransfusionTestNumber();
	}

	public boolean submitTransfussionReaction(Map<String, Object> infoMap) {
		return bloodBankDataService.submitTransfussionReaction(infoMap);
	}

	public Map<String, Object> fillBloodbagForDiscrad(
			Map<String, Object> dataMap) {
		return bloodBankDataService.fillBloodbagForDiscrad(dataMap);
	}

	public Map<String, Object> getTransfusionReactionGrid(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.getTransfusionReactionGrid(mapForDs);
	}

	public Map<String, Object> fillBloodbagForReaction(
			Map<String, Object> dataMap) {
		return bloodBankDataService.fillBloodbagForReaction(dataMap);
	}

	public Map<String, Object> showPendingBloodDiscard(
			Map<String, Object> mapForDs) {
		return bloodBankDataService.showPendingBloodDiscard(mapForDs);
	}

	public Map<String, Object> getComponentNameSeparationForAutoComplete(
			Map<String, Object> parameterMap) {
		return bloodBankDataService
				.getComponentNameSeparationForAutoComplete(parameterMap);
	}

	public Map<String, Object> chechBloodBag(Map<String, Object> dataMap) {
		return bloodBankDataService.chechBloodBag(dataMap);
	}

	public Map<String, Object> fillItemsForComponentnameSeparation(
			Map<String, Object> dataMap) {
		return bloodBankDataService
				.fillItemsForComponentnameSeparation(dataMap);
	}

	@Override
	public boolean submitDonerAssesstmentEntry(Map<String, Object> infoMap) {
		
		return bloodBankDataService.submitDonerAssesstmentEntry(infoMap);
	}

	@Override
	public Map<String,Object> saveAssesstment(Box box) {
		
		return bloodBankDataService.saveAssesstment(box);
	}
	public boolean updateAssesstment(Box box) {
		
		return bloodBankDataService.updateAssesstment(box);
	}

	@Override
	public Map<String, Object> searchAssesstment(Box box) {
		
		return bloodBankDataService.searchAssesstment(box);
	}

	@Override
	public Map<String, Object> showAssesstmentList(String uhidNo) {
		
		return bloodBankDataService.showAssesstmentList(uhidNo);
	}

	@Override
	public int saveAssesstmentEntryHeader(
			BloodAssessmentEntryM asssesstmentEntrym) {
		
		return bloodBankDataService.saveAssesstmentEntryHeader(asssesstmentEntrym);
	}

	@Override
	public Map<String,Object> submitDonorDeferredStatus(Box box) {
	
		return bloodBankDataService.submitDonorDeferredStatus(box);
	}
	
	
	@Override
	public Map<String, Object> showPendingListBloodCollection(Box box) {
		
		return bloodBankDataService.showPendingListBloodCollection(box);
	}
	
	@Override
	public Map<String, Object> showPendingListBloodSampleCollection(Box box) {
		
		return bloodBankDataService.showPendingListBloodSampleCollection(box);
	}

	@Override
	public Map<String, Object> showBloodTestList() {
		
		return bloodBankDataService.showBloodTestList();
	}
	@Override
	public Map<String, Object> showPendingListResultEntry(int hospitalId) {
		return bloodBankDataService.showPendingListResultEntry(hospitalId);
	}

	@Override
	public Map<String, Object> showPendingSampleScreeningTestJsp(Box box) {
		
		return bloodBankDataService.showPendingSampleScreeningTestJsp( box );
	}

	@Override
	public Map<String, Object> showCrossMatchingJsp(int bloodRequestHeaderId,int hospitalId) {
		
		return bloodBankDataService.showCrossMatchingJsp(bloodRequestHeaderId,hospitalId);
	}

	@Override
	public String getOrderSeqForDisplaysample(String string) {
		// TODO Auto-generated method stub
		return bloodBankDataService.getOrderSeqForDisplaysample(string);
	}

	@Override
	public Map<String, Object> showBloodBankRegistryJsp(Box box) {
		// TODO Auto-generated method stub
		return bloodBankDataService.showBloodBankRegistryJsp(box);
	}

	@Override
	public Map<String,Object> registerBloodBank(Box box) {
		
		return bloodBankDataService.registerBloodBank(box);
	}

	@Override
	public Map<String, Object> populateBloodBankRegistryJsp(int hospId) {
		// TODO Auto-generated method stub
		return bloodBankDataService.populateBloodBankRegistryJsp(hospId);
	}

	@Override
	public Map<String, Object> resultEntryFormJsp(int id,int hospitalId) {
		// TODO Auto-generated method stub
		return bloodBankDataService.resultEntryFormJsp(id,hospitalId);
	}

	@Override
	public Map<String, Object> showPendingForResultValidation(int hospitalId) {
		
		return bloodBankDataService.showPendingForResultValidation(hospitalId);
	}
	@Override
	public Map<String, Object> showPendingListResultEntryCg(int hospitalId) {
		
		return bloodBankDataService.showPendingListResultEntryCg(hospitalId);
	}
	@Override
	public Map<String, Object> showPendingListResultEntrySg(int hospitalId) {
		// TODO Auto-generated method stub
		return bloodBankDataService.showPendingListResultEntrySg(hospitalId);
	}
	@Override
	public Map<String, Object> resultEntryValidationJsp(int resultValidateId,int hospitalId) {
		// TODO Auto-generated method stub
		return  bloodBankDataService.resultEntryValidationJsp(resultValidateId,hospitalId);
	}
	@Override
	public boolean validateResulTestEntryt(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return bloodBankDataService.validateResulTestEntryt(map);
	}

	@Override
	public Map<String, Object> showBloodComponentJsp(int componentId) {
		return bloodBankDataService.showBloodComponentJsp(componentId);
	}

	@Override
	public Map<String, Object> showBloodStockRegisterjsp() {
		return bloodBankDataService.showBloodStockRegisterjsp();
	}
	
	@Override
	public Map<String, Object> populateComponentdetails(int componentId) {
		
		return bloodBankDataService.populateComponentdetails(componentId);
	}

	@Override
	public int populateAvailableBlood(int bloodBankId,int ComponentId) {
		
		return bloodBankDataService.populateAvailableBlood(bloodBankId,ComponentId);
	}

	@Override
	public Map<String, Object> showPendingSampleValidationJsp(int bloodBankId) {
		// TODO Auto-generated method stub
		return bloodBankDataService.showPendingSampleValidationJsp(bloodBankId);
	}

	@Override
	public Map<String, Object> bloodtRequestValidationJsp(
			int bloodRequestHeaderId,int hospitalId) {
		
		return bloodBankDataService.bloodtRequestValidationJsp(bloodRequestHeaderId,hospitalId);
	}
	
	@Override
	public boolean validatePatientBloodRequest(Map<String, Object> dataMap) {
		
		return bloodBankDataService.validatePatientBloodRequest(dataMap);
	}

	@Override
	public Map<String, Object> resultEntryFormContJsp(int id,int hospitalId) {
		
		return bloodBankDataService.resultEntryFormContJsp(id,hospitalId);
	} 
	
	@Override
	
	public Map<String,Object> populateBloodBags(int bloodGroupId,int hospitalId){
		return bloodBankDataService.populateBloodBags(bloodGroupId,hospitalId);
		
	}

	@Override
	public Map<String, Object> populateBloodBags(String BagNumber,int hospitalId) {
		
		return bloodBankDataService.populateBloodBags(BagNumber,hospitalId);
	}

	@Override
	public Map<String, Object> submitCrossMatching(Box box) {
		
		return bloodBankDataService.submitCrossMatching(box);
	}

	@Override
	public Map<String, Object> getPendingForBloodIssue(int bloodBankId) {
		
		return bloodBankDataService.getPendingForBloodIssue(bloodBankId);
	}

	@Override
	public Map<String, Object> populateComponentExpirydetails(
			Map<String, Object> map) {
		
		return bloodBankDataService.populateComponentExpirydetails(map);
	}

	@Override
	public Map<String, Object> showIndentBloodBankJsp() {
		
		return bloodBankDataService.showIndentBloodBankJsp();
	}

	@Override
	public Map<String, Object> submitBloodIndentRequest(Box box) {
		
		return bloodBankDataService.submitBloodIndentRequest(box);
	}

	@Override
	public Map<String, Object> showPendingIndentListJsp(int hospitalId) {
		
		return bloodBankDataService.showPendingIndentListJsp(hospitalId);
	}

	@Override
	public Map<String, Object> showIssueOfIndentJsp(int requestHeaderId) {
		
		return bloodBankDataService.showIssueOfIndentJsp(requestHeaderId);
	}

	@Override
	public Map<String, Object> populateBagDetalForIndent(Map<String, Object> map) {
		
		return bloodBankDataService.populateBagDetalForIndent(map);
	}

	@Override
	public Map<String, Object> saveIssueofIndent(Box box) {
		
		return bloodBankDataService.saveIssueofIndent(box);
	}

	@Override
	public Map<String, Object> showPendingAcknowledgmentListJsp(int hospitalId) {
		
		return bloodBankDataService.showPendingAcknowledgmentListJsp(hospitalId);
	}

	@Override
	public Map<String, Object> showbldIssueAcknowledgmentListJsp(int hospitalId) {
		
		return bloodBankDataService.showbldIssueAcknowledgmentListJsp(hospitalId);
	}

	
	
	@Override
	public Map<String, Object> populateIssueIndentBagDetal(int hospitalId,
			int indentId) {
		
		return bloodBankDataService.populateIssueIndentBagDetal(hospitalId,indentId);
	}

	@Override
	public Map<String, Object> populateIssueQuantityDetails(int issueIndentMId,
			int hospitalId) {
		
		return bloodBankDataService.populateIssueQuantityDetails(issueIndentMId,hospitalId);
	}

	@Override
	public Map<String, Object> saveAcknownledgeData(int hospitalId, int indentId) {
		
		return bloodBankDataService.saveAcknownledgeData(hospitalId,indentId);
	}

	@Override
	public String generateIndentOrderNumber() {
		
		return bloodBankDataService.generateIndentOrderNumber();
	}

	@Override
	public Map<String, Object> getConnectionForReport() {
		
		return bloodBankDataService.getConnectionForReport();
	}

	@Override
	public Map<String, Object> editBloodBank(Box box) {
		
		return bloodBankDataService.editBloodBank(box);
	}

	@Override
	public Map<String, Object> showBloodRequestEntryJsp(int hinId, String pTye) {
		return bloodBankDataService.showBloodRequestEntryJsp( hinId,  pTye) ;
	}

	@Override
	public Map<String, Object> populateDistrictByStateId(int stateId) {
		
		return bloodBankDataService.populateDistrictByStateId(stateId);
	}
@Override
public Map<String, Object> showSearchPatientRecordsForVisitJsp(
		Map<String, Object> map){
		return bloodBankDataService.showSearchPatientRecordsForVisitJsp(map);
				 
		}

@Override
public Map<String, Object> populateDonorRegistrationFrom(int deptId,
		int hospitalId, String hinNo, int page) {
	
	return bloodBankDataService.populateDonorRegistrationFrom(deptId,hospitalId,hinNo,page);
}
@Override
public Map<String, Object> getSampleCrossMatchingTestGrid(
		Box box) {
	return bloodBankDataService.getSampleCrossMatchingTestGrid(box);
}

@Override
public Map<String, Object> saveUntestedBloodBags(Box box) {
	
	return bloodBankDataService.saveUntestedBloodBags(box);
}

@Override
public Map<String,Object> populateItemDetailFromStock(int deptId,int  hospitalId, int itemId){
	return bloodBankDataService.populateItemDetailFromStock(deptId,hospitalId,itemId);
}
@Override
public Map<String,Object> populateBagVolume(int deptId,int hospitalId,int itemId){
	return bloodBankDataService.populateBagVolume(deptId,hospitalId,itemId);
}
@Override
public Map<String,Object> showTransfussionFeedback(int hospitalId){
	return bloodBankDataService.showTransfussionFeedback(hospitalId);
}
@Override
public Map<String,Object> showtransfussionDetails(int hospitalId,int transfussionHDId){
	return bloodBankDataService.showtransfussionDetails(hospitalId,transfussionHDId);
}

@Override
public Map<String,Object> submitDonorDeferredDate(Box box) {

	return bloodBankDataService.submitDonorDeferredDate(box);
}
@Override
public Map<String, Object> showBloodCollectionDetail(int itemId,int hospitalId) {

	return bloodBankDataService.showBloodCollectionDetail(itemId,hospitalId);
}

public Map<String, Object> populateBloodRequestForm(
		Map<String, Object> mapForDs) {
	return bloodBankDataService.populateBloodRequestForm(mapForDs);
}

@Override
public Map<String, Object> showPendingbloodRequestJsp(Map<String,Object> map) {
	// TODO Auto-generated method stub
	return bloodBankDataService.showPendingbloodRequestJsp(map);
}

@Override
public Map<String,Object> populatebloodBankQuantity(Map<String, Object> mapForDs){
	return bloodBankDataService.populatebloodBankQuantity(mapForDs);
}

@Override
public Map<String, Object> searchPatientConsentDetails(Map<String, Object> mapForDs) {
	return bloodBankDataService.searchPatientConsentDetails(mapForDs);
}

@Override
public Map<String, Object> showConsentEntryJsp(Map<String, Object> mapForDS) {
	return bloodBankDataService.showConsentEntryJsp(mapForDS);
}

@Override
public Map<String, Object> submitConsentForBlood(BloodConsent bloodConsent, Box box) {
	return bloodBankDataService.submitConsentForBlood(bloodConsent, box);
}

@Override
public Map<String, Object> getHospitalName(int hospitalId) {
	return bloodBankDataService.getHospitalName(hospitalId);
}

@Override
public Map<String, Object> searchBloodPatientConsentLetter(Map<String, Object> mapForDS) {
	return bloodBankDataService.searchBloodPatientConsentLetter(mapForDS);
}

@Override
public Map<String, Object> uploadBloodConsentLetter(Map<String, Object> mapForDS) {
	return bloodBankDataService.uploadBloodConsentLetter(mapForDS);
}

@Override
public Map<String, Object> uploadAndViewDocuments(Map<String, Object> details) {
	return bloodBankDataService.uploadAndViewDocuments(details);
}


}
