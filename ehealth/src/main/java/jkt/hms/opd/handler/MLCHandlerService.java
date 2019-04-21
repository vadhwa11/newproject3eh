package jkt.hms.opd.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MedicoLegalDetails;
import jkt.hms.masters.business.MortuaryRegisterDetails;
import jkt.hms.util.Box;


public interface MLCHandlerService {


	// *********************---------------------------------------- Common UHID -------------------------------------***********************//
	Map<String, Object> showUHIDJsp();
	
	Map<String, Object> getPaitentDetail(Map<String, Object> detailsMap);

	// *********************---------------------------------------- Start of  Method by Mansi -------------------------------------***********************//

	Map<String, Object> addExamOfMaleAccusedSexualOffence(Box box);

	Map<String, Object> addExamOfFemaleVictimOfSexualAssault(Box box);

	Map<String, Object> addExamOfVictimOfUnnaturalSexualOffence(Box box);

	Map<String, Object> addExamOfEvidenceOfRecentDelivery(Box box);

	
	// *********************---------------------------------------- End of  Method by Mansi -------------------------------------***********************//
	
	//---------------------------------------code by anamika-------------------------------------------------------------------//
	
	Map<String, Object> getMedicoLegalDetailsForMortuary(Box box);

	Map<String, Object> submitMortuaryRegister(Box box);

	Map<String, Object> getPostmortemDetails(Box box);

	Map<String, Object> updatePostMortemExamination(Box box);

	Map<String, Object> showPostmortemExaminationJsp(Box box);

	Map<String, Object> updatePostMortemDetailedNotes(Box box);

	Map<String, Object> showPostmortemDetailNotesJsp(Box box);	
	
	Map<String, Object> showMortuaryRegisterJsp(Box box);
	
	Map<String, Object> showMortuaryRegistedDetails(Box box);
	
	Map<String, Object> showPostmortemRegisteredDetails(Box box);
	
	List<MortuaryRegisterDetails> getMortuaryRegisterDetailsForReport(Box box);
			
	//-------------------------------------------End of code by anamika----------------------------------------------------------------

	
	// VK

	Map<String, Object> addAccidentalRegistration(Box box);
	
	
	// *********************---------------------------------------- Hospital Session and Report Connection -------------------------------------***********************//
 
	Map<String, Object> getHospitalName(Map<String, Object> mapForDs);
	
	Map<String, Object> getConnection();	

	
	// *********************---------------------------------------- Avinash-------------------------------------***********************//

	
		Map<String, Object> submmitTreetmentDischarge(MedicoLegalDetails details, int opdId, int hospitalId, String refNo);

		Map<String, Object> showTreatment_Dischargr_JSP();

		Map<String, Object> submmitDrunknessCertifikate(MedicoLegalDetails details, int opdId, int hospitalId);

		Map<String, Object> submmitMedicoRegister(MedicoLegalDetails details);

		Map<String, Object> getMedicolegalRegisterDetail(Box box);

		Map<String, Object> getDetailAndDisplay(Box box);
		// *********************---------------------------------------- Avinash-------------------------------------***********************//

		Map<String, Object> getAdmissionNumberList(Map<String, Object> requestParameters);

		Map<String, Object> checkWoundCertificate(Box box);

		Map<String, Object> updateWoundCertificateStatus(Box box);

		Map<String, Object> getWaitingListCouseOfDeathFinal();

		Map<String, Object> getCouseOfDeathFinal(Box box);

		Map<String, Object> getWaitingListPostMartemCertificate();

		Map<String, Object> getWaitingListEstimationofAge();

		Map<String, Object> getWaitingListChemicalAnalysis();

		Map<String, Object> getWaitingListVictimAllegedDrugged();

		Map<String, Object> getWaitingListMedicalOfficerCertificate();

		Map<String, Object> getWaitingListExaminationbySMOTTmember();

		Map<String, Object> getWaitingListDNAprofilingexaminationFSL();

		Map<String, Object> getWaitingListPreserveDuringPostmortem();

		Map<String, Object> getWaitingListFormatForReferring();

		Map<String, Object> addCouseOfDeathFinal(Box box);

		Map<String, Object> addChemicalAnalysis(Box box);

		Map<String, Object> getWaitingListAccidentalRegistration();

		Map<String, Object> getAccidentalRegistration(Box box);

		Map<String, Object> getWaitingListExamOfMaleAccusedSexualOffence();

		Map<String, Object> getExamOfMaleAccusedSexual(Box box);

		Map<String, Object> getWaitingListExamOfFemaleVictimOfSexualAssault();

		Map<String, Object> getExamOfFemaleVictimOfSexualAssault(Box box);

		Map<String, Object> getDunknness(Box box);

		Map<String, Object> getWaitingListDunknness();

		Map<String, Object> getWaitingListExamOfVictimOfUnnaturalSexualOffence();

		Map<String, Object> getWaitingListTreatment_Dischargr_JSP();

		Map<String, Object> getExamOfVictimOfUnnaturalSexualOffence(Box box);

		Map<String, Object> getTreatment_Dischargr(Box box);

		Map<String, Object> getWaitingListExamOfEvidenceOfRecentDelivery();

		Map<String, Object> getEvidenceOfRecentDelivery(Box box);

		Map<String, Object> getWaitingListPostExaminToPoliceSurgun();

		Map<String, Object> addPostMartemCertificate(Box box);

		Map<String, Object> addEstimationofAge(Box box);

		Map<String, Object> getPostMartemCertificate(int id);

		Map<String, Object> getChemicalAnalysis(Box box);

		Map<String, Object> addMedicalOfficerCertificate(Box box);

		Map<String, Object> addVictimAllegedDrugged(Box box);

		Map<String, Object> addExaminationbySMOTTmember(Box box);

		Map<String, Object> addDNAprofilingexaminationFSL(Box box);

		Map<String, Object> addPreserveDuringPostmortem(Box box);

		Map<String, Object> getAllMlcWaitingList(int hospitalId, int empId);

		Map<String, Object> getCAUSE_OF_DEATH(Box box);

		Map<String, Object> getEstimationofAge(Box box);
		
		Map<String, Object> getNoObjectionCertificate(Box box);

		Map<String, Object> getVictimAllegedDrugged(Box box);

		Map<String, Object> addReffringPostmortamExam(Box box);

		Map<String, Object> getPreserveDuringPostmortem(Box box);

		Map<String, Object> getDNAprofilingexaminationFSL(Box box);

		Map<String, Object> getFormatForReferring(Box box);

		Map<String, Object> geMedicalOfficerCertificatet(Box box);

		Map<String, Object> getUhid(Box box);

		Map<String, Object> getExaminationbySMOTTmember(Box box);

		Map<String, Object> getPostExaminToPoliceSurgun(Box box);

		Map<String, Object> getProformforRecording(Box box);

		Map<String, Object> addProformforRecording(Box box);

		Map<String, Object> submmitNOObjectionCerificate(Box box);

		Map<String, Object> getAuthenticityCertificate(Box box);

		Map<String, Object> addAuthenticityCertificate(Box box);

		Map<String, Object> getUhidReport(Box box);

		Map<String, Object> getMlcTypeReport(Box box);

		Map<String, Object> getPMNoReport(Box box);

		List<Integer> getMLCIdList(Map<String, Object> mapForDs);
		
		void saveMLCReportCount(Map<String, Object> mapForDs);

		Map<String, Object> updateDrunknessCertifikate(Box box);

		Map<String, Object> updateTreetmentDischarge(Box box);

	
}
