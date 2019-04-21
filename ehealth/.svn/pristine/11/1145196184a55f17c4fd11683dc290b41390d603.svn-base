package jkt.hms.opd.handler;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MedicoLegalDetails;
import jkt.hms.masters.business.MortuaryRegisterDetails;
import jkt.hms.opd.dataservice.MLCDataService;
import jkt.hms.util.Box;


public class MLCHandlerServiceImpl implements MLCHandlerService {

	MLCDataService mlcDataService = null;


	public MLCDataService getMlcDataService() {
		return mlcDataService;
	}

	public void setMlcDataService(MLCDataService mlcDataService) {
		this.mlcDataService = mlcDataService;
	}




	// *********************---------------------------------------- Common UHID -------------------------------------***********************//

	@Override
	public Map<String, Object> showUHIDJsp() {
		return mlcDataService.showUHIDJsp();
	}
		
	public Map<String, Object> getPaitentDetail(Map<String, Object> detailsMap) {
		return mlcDataService.getPaitentDetail(detailsMap);
	}
	
	// *********************---------------------------------------- Start of  Method by Mansi -------------------------------------***********************//

	@Override
	public Map<String, Object> addExamOfMaleAccusedSexualOffence(Box box) {
		return mlcDataService.addExamOfMaleAccusedSexualOffence(box);
	}

	@Override
	public Map<String, Object> addExamOfFemaleVictimOfSexualAssault(Box box) {
		return mlcDataService.addExamOfFemaleVictimOfSexualAssault(box);
	}
	@Override
	public Map<String, Object> addExamOfVictimOfUnnaturalSexualOffence(Box box) {
		return mlcDataService.addExamOfVictimOfUnnaturalSexualOffence(box);
	}
		
	@Override
	public Map<String, Object> addExamOfEvidenceOfRecentDelivery(Box box) {
		return mlcDataService.addExamOfEvidenceOfRecentDelivery(box);
	}

		

	@Override
	public Map<String, Object> getAdmissionNumberList(
			Map<String, Object> requestParameters) {
		return mlcDataService.getAdmissionNumberList(requestParameters);
	}
	// *********************---------------------------------------- End of  Method by Mansi -------------------------------------***********************//
	
	//--------------------------------------------------------code by anamika-------------------------------------------------------------------------------//
	@Override
	public Map<String, Object> getMedicoLegalDetailsForMortuary(Box box) {
		// TODO Auto-generated method stub
		return mlcDataService.getMedicoLegalDetailsForMortuary(box);
	}

	@Override
	public Map<String, Object> submitMortuaryRegister(Box box) {
		
		return mlcDataService.submitMortuaryRegister(box);
	}

	@Override
	public Map<String, Object> getPostmortemDetails(Box box) {
		
		return mlcDataService.getPostmortemDetails(box);
	}

	@Override
	public Map<String, Object> updatePostMortemExamination(Box box) {
		
		return mlcDataService.updatePostMortemExamination(box);
	}

	@Override
	public Map<String, Object> showPostmortemExaminationJsp(Box box) {
		
		return mlcDataService.showPostmortemExaminationJsp(box);
	}

	@Override
	public Map<String, Object> updatePostMortemDetailedNotes(Box box) {
		
		return mlcDataService.updatePostMortemDetailedNotes(box);
	}

	@Override
	public Map<String, Object> showPostmortemDetailNotesJsp(Box box) {
		
		return mlcDataService.showPostmortemDetailNotesJsp(box);
	}
	
	// Added by Kaushal Mishra 05-05-2016
	@Override
	public Map<String, Object> showMortuaryRegisterJsp(Box box) {
		
		return mlcDataService.showMortuaryRegisterJsp(box);
	}
	
	@Override
	public Map<String, Object> showMortuaryRegistedDetails(Box box) {
		
		return mlcDataService.showMortuaryRegistedDetails(box);
	}
	
	@Override
	public Map<String, Object> showPostmortemRegisteredDetails(Box box) {
		
		return mlcDataService.showPostmortemRegisteredDetails(box);
	}

	@Override
	public List<MortuaryRegisterDetails> getMortuaryRegisterDetailsForReport(Box box) {
		
		return mlcDataService.getMortuaryRegisterDetailsForReport(box);
	}
	
//-------------------------------------end of code by anamika--------------------------	
 	
//VK
	@Override
	public Map<String, Object> addAccidentalRegistration(Box box) {
		return mlcDataService.addAccidentalRegistration(box);
		 
	}
	// *********************---------------------------------------- Hospital Session and Report Connection -------------------------------------***********************//
	
		@Override
		public Map<String, Object> getHospitalName(Map<String, Object> mapForDs) {
			return mlcDataService.getHospitalName(mapForDs);
		}

		@Override
		public Map<String, Object> getConnection() {
			return mlcDataService.getConnection();	
		}
		
		
		
		// *********************---------------------------------------- Avinash-------------------------------------***********************//

			
			@Override
			public Map<String, Object> submmitTreetmentDischarge(
					MedicoLegalDetails details,int opdid,int hospitalId,String refNo) {
				
				return mlcDataService.submmitTreetmentDischarge(details,opdid,hospitalId,refNo);
			}

			@Override
			public Map<String, Object> showTreatment_Dischargr_JSP() {
				
				return mlcDataService.showTreatment_Dischargr_JSP();
			}

			@Override
			public Map<String, Object> submmitDrunknessCertifikate(
					MedicoLegalDetails details,int opdId,int hospitalId) {
				
				return mlcDataService.submmitDrunknessCertifikate(details,opdId,hospitalId);
			}

			@Override
			public Map<String, Object> submmitMedicoRegister(MedicoLegalDetails details) {
				
				return mlcDataService.submmitMedicoRegister(details);
			}

			@Override
			public Map<String, Object> getMedicolegalRegisterDetail(Box box) {
				
				return mlcDataService.getMedicolegalRegisterDetail(box);
			}

			@Override
			public Map<String, Object> getDetailAndDisplay(Box box) {
				
				return mlcDataService.getDetailAndDisplay(box);
			}

			@Override
			public Map<String, Object> checkWoundCertificate(Box box) {
				
				return mlcDataService.checkWoundCertificate(box);
			}

			@Override
			public Map<String, Object> updateWoundCertificateStatus(Box box) {
			
				return mlcDataService.updateWoundCertificateStatus(box);
			}

			@Override
			public Map<String, Object> getWaitingListCouseOfDeathFinal() {
				// TODO Auto-generated method stub
				return mlcDataService.getWaitingListCouseOfDeathFinal();
			}

			@Override
			public Map<String, Object> getCouseOfDeathFinal(Box box) {
			
				return mlcDataService.getCouseOfDeathFinal(box);
			}

			@Override
			public Map<String, Object> getWaitingListPostMartemCertificate() {
			
				return mlcDataService.getWaitingListPostMartemCertificate();
			}

			@Override
			public Map<String, Object> getWaitingListEstimationofAge() {
				
				return mlcDataService.getWaitingListEstimationofAge();
			}

			@Override
			public Map<String, Object> getWaitingListChemicalAnalysis() {
				
				return mlcDataService.getWaitingListChemicalAnalysis();

			}

			@Override
			public Map<String, Object> getWaitingListVictimAllegedDrugged() {
				
				return mlcDataService.getWaitingListVictimAllegedDrugged();
			}

			@Override
			public Map<String, Object> getWaitingListMedicalOfficerCertificate() {
				// TODO Auto-generated method stub
				return mlcDataService.getWaitingListMedicalOfficerCertificate();
			}

			@Override
			public Map<String, Object> getWaitingListExaminationbySMOTTmember() {
				
				return mlcDataService.getWaitingListExaminationbySMOTTmember();
			}

			@Override
			public Map<String, Object> getWaitingListDNAprofilingexaminationFSL() {
			
				return mlcDataService.getWaitingListDNAprofilingexaminationFSL();
			}

			@Override
			public Map<String, Object> getWaitingListPreserveDuringPostmortem() {
				
				return mlcDataService.getWaitingListPreserveDuringPostmortem();
			}

			@Override
			public Map<String, Object> getWaitingListFormatForReferring() {
			
				return mlcDataService.getWaitingListFormatForReferring();
			}

			@Override
			public Map<String, Object> addCouseOfDeathFinal(Box box) {
				
				return mlcDataService.addCouseOfDeathFinal(box);
			}

			@Override
			public Map<String, Object> addChemicalAnalysis(Box box) {
			
				return  mlcDataService.addChemicalAnalysis(box);
			}

			@Override
			public Map<String, Object> getWaitingListAccidentalRegistration() {
				
				return  mlcDataService.getWaitingListAccidentalRegistration();
			}

			@Override
			public Map<String, Object> getAccidentalRegistration(Box box) {
				
				return mlcDataService.getAccidentalRegistration(box);
			}

			@Override
			public Map<String, Object> getWaitingListExamOfMaleAccusedSexualOffence() {
			
				return mlcDataService.getWaitingListExamOfMaleAccusedSexualOffence();
			}

			@Override
			public Map<String, Object> getExamOfMaleAccusedSexual(Box box) {
				return mlcDataService.getExamOfMaleAccusedSexual(box);
			}

			@Override
			public Map<String, Object> getWaitingListExamOfFemaleVictimOfSexualAssault() {
				
				return mlcDataService.getWaitingListExamOfFemaleVictimOfSexualAssault();
			}

			@Override
			public Map<String, Object> getExamOfFemaleVictimOfSexualAssault(Box box) {
				
				return mlcDataService.getExamOfFemaleVictimOfSexualAssault(box);
			}

			@Override
			public Map<String, Object> getDunknness(Box box) {
				
				return mlcDataService.getDunknness(box);
			}

			@Override
			public Map<String, Object> getWaitingListDunknness() {
				
				return mlcDataService.getWaitingListDunknness();
			}

			@Override
			public Map<String, Object> getWaitingListExamOfVictimOfUnnaturalSexualOffence() {
				
				return mlcDataService.getWaitingListExamOfVictimOfUnnaturalSexualOffence();
			}

			@Override
			public Map<String, Object> getWaitingListTreatment_Dischargr_JSP() {
				
				return mlcDataService.getWaitingListTreatment_Dischargr_JSP();
			}

			@Override
			public Map<String, Object> getExamOfVictimOfUnnaturalSexualOffence(Box box) {
			
				return mlcDataService.getExamOfVictimOfUnnaturalSexualOffence(box);
			}

			@Override
			public Map<String, Object> getTreatment_Dischargr(Box box) {
				
				return  mlcDataService.getTreatment_Dischargr(box);
			}

			@Override
			public Map<String, Object> getWaitingListExamOfEvidenceOfRecentDelivery() {
				
				return mlcDataService.getWaitingListExamOfEvidenceOfRecentDelivery();
			}

			@Override
			public Map<String, Object> getEvidenceOfRecentDelivery(Box box) {
			
				return mlcDataService.getEvidenceOfRecentDelivery(box);
			}

			@Override
			public Map<String, Object> getWaitingListPostExaminToPoliceSurgun() {
				
				return mlcDataService.getWaitingListPostExaminToPoliceSurgun();
			}

			@Override
			public Map<String, Object> addPostMartemCertificate(Box box) {
				
				return mlcDataService.addPostMartemCertificate(box);
			}

			@Override
			public Map<String, Object> addEstimationofAge(Box box) {
				
				return mlcDataService.addEstimationofAge(box);
			}

			@Override
			public Map<String, Object> getPostMartemCertificate(int id) {
				
				return mlcDataService.getPostMartemCertificate(id);
			}

			@Override
			public Map<String, Object> getChemicalAnalysis(Box box) {
				
				return mlcDataService.getChemicalAnalysis(box);
			}

			@Override
			public Map<String, Object> addMedicalOfficerCertificate(Box box) {
				
				return mlcDataService.addMedicalOfficerCertificate(box);
			}

			@Override
			public Map<String, Object> addVictimAllegedDrugged(Box box) {
				
				return mlcDataService.addVictimAllegedDrugged(box);
			}

			@Override
			public Map<String, Object> addExaminationbySMOTTmember(Box box) {
				
				return mlcDataService.addExaminationbySMOTTmember(box);
			}

			@Override
			public Map<String, Object> addDNAprofilingexaminationFSL(Box box) {
			
				return mlcDataService.addDNAprofilingexaminationFSL(box);
			}

			@Override
			public Map<String, Object> addPreserveDuringPostmortem(Box box) {
			
				return mlcDataService.addPreserveDuringPostmortem(box);
			}

			@Override
			public Map<String, Object> getAllMlcWaitingList(int hospitalId, int empId) {
				
				return mlcDataService.getAllMlcWaitingList(hospitalId, empId) ;
			}

			@Override
			public Map<String, Object> getCAUSE_OF_DEATH(Box box) {
				
				return mlcDataService.getCAUSE_OF_DEATH(box);
			}

			@Override
			public Map<String, Object> getEstimationofAge(Box box) {
			
				return mlcDataService.getEstimationofAge(box);
			}
			
			@Override
			public Map<String, Object> getNoObjectionCertificate(Box box){
				return mlcDataService.getNoObjectionCertificate(box);
			}

			@Override
			public Map<String, Object> getVictimAllegedDrugged(Box box) {
				
				return mlcDataService.getVictimAllegedDrugged(box);
			}

			@Override
			public Map<String, Object> addReffringPostmortamExam(Box box) {
			
				return mlcDataService.addReffringPostmortamExam(box);
			}

			@Override
			public Map<String, Object> getPreserveDuringPostmortem(Box box) {
			
				return mlcDataService.getPreserveDuringPostmortem(box);
			}

			@Override
			public Map<String, Object> getDNAprofilingexaminationFSL(Box box) {
		
				return  mlcDataService.getDNAprofilingexaminationFSL(box);
			}

			@Override
			public Map<String, Object> getFormatForReferring(Box box) {
			
				return  mlcDataService.getFormatForReferring(box);
			}

			@Override
			public Map<String, Object> geMedicalOfficerCertificatet(Box box) {
			
				return  mlcDataService.geMedicalOfficerCertificatet(box);
			}

			@Override
			public Map<String, Object> getUhid(Box box) {
				return  mlcDataService.getUhid(box);
			}

			@Override
			public Map<String, Object> getExaminationbySMOTTmember(Box box) {
				
				return  mlcDataService.getExaminationbySMOTTmember(box);
			}

			@Override
			public Map<String, Object> getPostExaminToPoliceSurgun(Box box) {
			
				return  mlcDataService.getPostExaminToPoliceSurgun(box);
			}

			@Override
			public Map<String, Object> getProformforRecording(Box box) {
			
				return mlcDataService.getProformforRecording(box);
			}

			@Override
			public Map<String, Object> addProformforRecording(Box box) {
			
				return mlcDataService.addProformforRecording(box);
			}

			@Override
			public Map<String, Object> submmitNOObjectionCerificate(Box box) {
				
				return mlcDataService.submmitNOObjectionCerificate(box);
			}

			@Override
			public Map<String, Object> getAuthenticityCertificate(Box box) {
				
				return  mlcDataService.getAuthenticityCertificate(box);
			}

			@Override
			public Map<String, Object> addAuthenticityCertificate(Box box) {
			
				return mlcDataService.addAuthenticityCertificate(box);
			}

			
			@Override
			public Map<String, Object> getUhidReport(Box box) {
				return  mlcDataService.getUhidReport(box);
			}
			

			@Override
			public Map<String, Object> getMlcTypeReport(Box box) {
				return  mlcDataService.getMlcTypeReport(box);
			}

			@Override
			public Map<String, Object> getPMNoReport(Box box) {
				return  mlcDataService.getPMNoReport(box);
			}

			@Override
			public List<Integer> getMLCIdList(Map<String, Object> mapForDs) {
				return  mlcDataService.getMLCIdList(mapForDs);
			}

			@Override
			public void saveMLCReportCount(Map<String, Object> mapForDs) {
				  mlcDataService.saveMLCReportCount(mapForDs);
			}

			@Override
			public Map<String, Object> updateDrunknessCertifikate(Box box) {
				 return mlcDataService.updateDrunknessCertifikate(box);
			}
			@Override
			public Map<String, Object> updateTreetmentDischarge(Box box) {
				 return mlcDataService.updateTreetmentDischarge(box);
			}
			
			// *********************---------------------------------------- Start-------------------------------------***********************//

			
	
}
