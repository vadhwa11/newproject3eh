package jkt.hms.bloodBank.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.BloodAssessmentEntryM;
import jkt.hms.masters.business.BloodConsent;
import jkt.hms.masters.business.BloodMasComponent;
import jkt.hms.masters.business.BloodReactionEntry;
import jkt.hms.masters.business.BloodTransfusion;
import jkt.hms.masters.business.Patient;
import jkt.hms.util.Box;

public interface BloodBankHandlerService {

	// ------Blood Componentmaster------------------------
	Map<String, Object> showBloodComponentJsp(int hospitalId,int departmentId);
	
	Map<String, Object> getBloodSampleCollectionDetail(Box box);
	
	//Map<String, Object> showBloodComponentJsp(int Id);

	Map<String, Object> searchBloodComponent(String bloodComponentCode,
			String bloodComponentName);

	boolean addBloodComponent(BloodMasComponent bloodMasComponent);

	boolean editBloodComponent(Map<String, Object> generalMap);

	boolean deleteBloodComponent(int bloodComponentId,
			Map<String, Object> generalMap);
	
	Map<String, Object> showDonorAssesstmentMasterJsp(int page,int recordsPerPage);

	// --------------------Blood Request Entry-----------------------------

	Map<String, Object> getPatientForBloodRequest(Map<String, Object> mapForDs);

	Map<String, Object> fillItemsForComponentname(Map<String, Object> dataMap);

	Map<String, Object> getDetailsForBloodRequestEnquiry();

	Map<String, Object> showBloodRequestEntryJsp(int hinId,String pTye);

	String getOrderSeqForDisplay(String string,int hospitalId);

	String generateOrderNumber();

	boolean submitBloodRequestEntry(Map<String, Object> infoMap);

	Map<String, Object> getComponentNameForAutoComplete(
			Map<String, Object> parameterMap);
	
	Map<String,Object> showPendingForResultValidation(int hospitalId);

	Map<String, Object> showBloodDonationEntryJsp(Box box);

	Map<String, Object> getSampleCollectionGrid(Map<String, Object> mapForDs);

	Map<String, Object> getDetailsForSampleCollection();

	Map<String, Object> getPatientDetailSampleCollection(
			Map<String, Object> mapForDs);

	Map<String, Object> getBloodSampleCollectionDetails(Map orderMap);

	Map<String, Object> submitBloodSampleCollection(
			Box box);
	
	Map<String, Object> submitSampleOfBlood(
			Box box);

	Map<String, Object> getSampleCollectionDetailsForNext(int newRequestId);

	String generateSampleCollectionNumber();

	Map<String, Object> showBloodSampleColletionJsp(int requestId);

	String getSampleCollectionSeqForDisplay(String string);

	String getSampleTestSeqForDisplay(String string);

	Map<String, Object> getDetailsForSampleValidation();

	Map<String, Object> getSampleValidationGrid(Map<String, Object> mapForDs);

	Map<String, Object> getPatientDetailSampleValidation(
			Map<String, Object> mapForDs);

	Map<String, Object> showBloodSampleValidationJsp(int sampleId);

	boolean submitBloodSampleValidation(Map<String, Object> parameterMap);

	Map<String, Object> getPatientDetailBloodSampleScreening(
			Map<String, Object> mapForDs);

	Map<String, Object> showBloodSampleScreening(int sampleId);

	Map<String, Object> getDetailsForSampleScreeningTest();

	Map<String, Object> getSampleScreeningTestGrid(Box box);
	
	Map<String, Object> getSampleCrossMatchingTestGrid(Box box);
	
	Map<String, Object> getTestName(Map<String, Object> parameterMap);

	boolean submitBloodSampleScreeningTest(Map<String, Object> infoMap);

	String generateSampleTestNumber();

	Map<String, Object> getDetailsForBloodIssue();

	Map<String, Object> getBloodIssueGrid(Map<String, Object> mapForDs);

	Map<String, Object> showStockOpeningBalance();

	Map<String, Object> showBloodDiscardJsp(int bloodStockDetailId);

	String generateOpeningNumber();

	Map<String, Object> submitStockOpeningBalance(Map<String, Object> infoMap);

	List<Patient> getPateintDetail(String hinNo);

	String getStockSeqNoForDisplay(String string);

	Map<String, Object>  submitBloodDonationEntry(Map<String, Object> infoMap);
	
	boolean submitDonerAssesstmentEntry(Map<String, Object> infoMap);

	String generateDonationNumber();

	String getDonationSeqNoForDisplay(String string);

	// ------------------------Donor Blood Pending For Sample
	// Screening--------------------------------
	Map<String, Object> getDetailsForDonorSampleScreening();

	Map<String, Object> getDonorSampleScreeningGrid(Map<String, Object> mapForDs);

	Map<String, Object> showDonorBloodSampleScreeningTest(int donationId);

	Map<String, Object> getDonorDetailBloodSampleScreening(
			Map<String, Object> mapForDs);

	String getDonorSampleTestSeqForDisplay(String string);

	boolean submitDonorBloodSampleScreeningTest(Map<String, Object> infoMap);

	Map<String, Object> showBloodComponentSeparationJsp(int hospitalId);

	Map<String, Object> getBloodBagNoForAutoComplete(
			Map<String, Object> parameterMap);

	Map<String, Object> getPatientList(String hinNo);

	Map<String, Object> showBloodTestEntryJsp();

	String generateSerialNumber();

	boolean submitBloodTestEntry(Map<String, Object> infoMap);
	
boolean submitBloodTestEntryCg(Map<String, Object> infoMap);
	
	boolean submitBloodTestEntrySg(Map<String, Object> infoMap);

	Map<String, Object> fillItemsForInvestigationName(
			Map<String, Object> dataMap);

	Map<String, Object> getPatientDetailBloodIssue(Map<String, Object> mapForDs);

	Map<String, Object> showBloodIssueJsp(int screeningId);

	String getBloodIssueSeqForDisplay(String string);

	//boolean submitBloodIssue(Map<String, Object> infoMap);
	boolean submitBloodIssue(Box box);

	String generateMonthlyNumber();

	String generateDonorSampleTestNumber();

	String getDiscardSeqForDisplay(String string);

	String generateDiscardNumber();

	boolean submitBloodDiscard(Map<String, Object> parameterMap);

	Map<String, Object> showSearchPatientForReactionJsp(int hospitalId);

	Map<String, Object> searchPatientForBloodReaction(
			Map<String, Object> mapForDs);

	Map<String, Object> showReactionFormEntryJsp(int inpatientId,int hospitalId,int deptId);

	String getEntrySeqForDisplay(String string);

	boolean submitBloodReactionEntry(BloodReactionEntry bldReactionEntry,Box box);

	String generateEntryNumber();

	Map<String, Object> showDirectIndirectRegisterReport();

	String getSerialSeqForDisplay(String string);

	Map<String, Object> getDBConnection();

	Map<String, Object> fillPatientDetail(Map<String, Object> dataMap);

	Map<String, Object> showPatientSearchForBloodTransfusionJsp();

	Map<String, Object> getPatientForBloodTransfusion(
			Map<String, Object> mapForDs);

	Map<String, Object> showConsentBloodTransfusion(int inpatientId);

	int getTransfusionEntrySeqForDisplay(String string);

	int generateTransfusionEntryNumber();

	boolean submitBloodTransfusion(BloodTransfusion bloodTransfusion);

	Map<String, Object> showPatientSearchForDonationJsp(Map<String, Object> map);

	Map<String, Object> getPatientForUpdateDonation(Map<String, Object> mapForDs);

	Map<String, Object> showUpdateDonationEntry(int bloodDonationId);

	Map<String, Object> submitBloodComponentSeperation(Box box,
			Map<String, Object> dataMap);

	Map<String, Object> showPopUpBloodIssueJsp(Map<String, Object> map);

	Map<String, Object> showUpdateReactonEntry(int reactionId);

	Map<String, Object> searchPatientForUpdateReaction(
			Map<String, Object> mapForDs);

	boolean updateBloodReaction(Map<String, Object> generalMap);

	Map<String, Object> showPendingForTransfussionReaction();

	Map<String, Object> searchPatientForTransfussionReaction(
			Map<String, Object> mapForDs);

	Map<String, Object> showTransfussionReaction(int bloodReactionId, int hospitalId);

	String getTransfussionTestSeqForDisplay(String string);

	Map<String, Object> fillDonorDetail(Map<String, Object> dataMap);

	boolean submitPopbloodIssue(int stockDetailId,
			Map<String, Object> generalMap);

	boolean updateBloodDonation(Box box);

	boolean updateBloodTestEntry(Box box);

	Map<String, Object> searchPatientForUpdateTest(Map<String, Object> mapForDs);

	Map<String, Object> showUpdateTestEntry(int bloodTestId);

	int generateTransfusionTestNumber();

	boolean submitTransfussionReaction(Map<String, Object> infoMap);

	Map<String, Object> fillBloodbagForDiscrad(Map<String, Object> dataMap);

	Map<String, Object> getTransfusionReactionGrid(Map<String, Object> mapForDs);

	Map<String, Object> fillBloodbagForReaction(Map<String, Object> dataMap);

	Map<String, Object> showPendingBloodDiscard(Map<String, Object> mapForDs);

	Map<String, Object> getComponentNameSeparationForAutoComplete(
			Map<String, Object> parameterMap);

	Map<String, Object> chechBloodBag(Map<String, Object> dataMap);

	Map<String, Object> fillItemsForComponentnameSeparation(
			Map<String, Object> dataMap);
	
	Map<String,Object> saveAssesstment(Box box);
	
	boolean updateAssesstment(Box box);
	
	Map<String, Object> searchAssesstment(Box box);
	
	Map<String, Object> showAssesstmentList(String UhidNo);
	
	int saveAssesstmentEntryHeader(BloodAssessmentEntryM asssesstmentEntrym);
	
	Map<String,Object> submitDonorDeferredStatus(Box box);
	
	Map<String, Object> showPendingListBloodCollection(Box box);
	
	Map<String, Object> showPendingListBloodSampleCollection(Box box);
	
	Map<String, Object> showBloodTestList();
	 Map<String, Object> showPendingListResultEntry(int hospitalId);
	 
	 Map<String, Object> showPendingListResultEntryCg(int hospitalId);
	 
	 Map<String,Object> showPendingSampleScreeningTestJsp(Box box );
	 
	 Map<String,Object> showCrossMatchingJsp(int bloodRequestHeaderId,int hospitalId);
	 String getOrderSeqForDisplaysample(String string);
	Map<String,Object> showBloodBankRegistryJsp(Box box);
	Map<String,Object> populateBloodBankRegistryJsp(int hospId);
	
	Map<String,Object> registerBloodBank(Box box);
	Map<String,Object> resultEntryFormJsp(int id,int hospitalId);
	Map<String,Object> showPendingListResultEntrySg(int hospitalId);
	
	 Map<String,Object> resultEntryValidationJsp(int resultValidateId,int hospitalId);
	 
	 boolean validateResulTestEntryt(Map<String,Object> map);
	Map<String, Object> showBloodComponentJsp(int componentId);

	Map<String, Object> showBloodStockRegisterjsp();
	
	Map<String, Object> populateComponentdetails(int componentId);
	
	int populateAvailableBlood(int bloodBankId,int ComponentId);
	
	Map<String,Object> showPendingSampleValidationJsp(int bloodBankId);
	
	Map<String,Object> bloodtRequestValidationJsp(int bloodRequestHeaderId,int hospitalId);
	
	boolean validatePatientBloodRequest(Map<String, Object> dataMap);
	
	Map<String,Object> resultEntryFormContJsp(int id,int hospitalId);
	
	Map<String,Object> populateBloodBags(int bloodGroupId,int hospitalId);
	
	Map<String,Object> populateBloodBags(String BagNumber,int hospitalId);
	
	Map<String,Object> submitCrossMatching(Box box);
	
	Map<String,Object> getPendingForBloodIssue(int bloodBankId);
	
	Map<String,Object> populateComponentExpirydetails(Map<String,Object> map);
	
	Map<String,Object> showIndentBloodBankJsp();
	
	Map<String,Object> submitBloodIndentRequest(Box box);
	
	Map<String,Object> showPendingIndentListJsp(int hospitalId);
	
	Map<String,Object> showIssueOfIndentJsp(int requestHeaderId);
	
	Map<String,Object> populateBagDetalForIndent(Map<String,Object> map);
	
	Map<String,Object> saveIssueofIndent(Box box);
	
	Map<String,Object> showPendingAcknowledgmentListJsp(int hospitalId);
	Map<String,Object> showbldIssueAcknowledgmentListJsp(int hospitalId);
	
	Map<String,Object> populateIssueIndentBagDetal(int hospitalId,int indentId);
	
	Map<String,Object> populateIssueQuantityDetails(int issueIndentMId,int hospitalId);
	
	Map<String,Object> saveAcknownledgeData(int hospitalId,int indentId);
	
	String generateIndentOrderNumber();
	
	Map<String, Object> getConnectionForReport();
	
	Map<String,Object> editBloodBank(Box box);
	
	Map<String,Object> populateDistrictByStateId(int stateId);
	
	Map<String, Object> showSearchPatientRecordsForVisitJsp(
			Map<String, Object> getDataMap);
	
	Map<String, Object> populateDonorRegistrationFrom(int deptId,int hospitalId,String hinNo,int page);

	Map<String,Object> saveUntestedBloodBags(Box box);
	
	Map<String,Object> populateItemDetailFromStock(int deptId,int hospitalId,int itemId);
	
	Map<String,Object> populateBagVolume(int deptId,int hospitalId,int itemId);
	
	Map<String,Object> showTransfussionFeedback(int hospitalId);
	
	Map<String,Object> showtransfussionDetails(int hospitalId,int transfussionHDId);
	
	Map<String,Object> submitDonorDeferredDate(Box box);
	
	Map<String, Object> showBloodCollectionDetail(int itemId,int hospitalId);
	
	Map<String, Object> populateBloodRequestForm(Map<String, Object> mapForDs);
	
	Map<String,Object> showPendingbloodRequestJsp(Map<String,Object> map);
	
	Map<String,Object> populatebloodBankQuantity(Map<String,Object> mapForDs);

	Map<String, Object> searchPatientConsentDetails(Map<String, Object> mapForDS);

	Map<String, Object> showConsentEntryJsp(Map<String, Object> mapForDS);

	Map<String, Object> submitConsentForBlood(BloodConsent bloodConsent, Box box);
	
	Map<String, Object> getHospitalName(int hospitalId);

	Map<String, Object> searchBloodPatientConsentLetter(Map<String, Object> mapForDS);

	Map<String, Object> uploadBloodConsentLetter(Map<String, Object> mapForDS);

	Map<String, Object> uploadAndViewDocuments(Map<String, Object> details);
	
}
