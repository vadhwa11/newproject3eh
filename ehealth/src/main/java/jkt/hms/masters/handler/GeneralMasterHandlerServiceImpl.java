package jkt.hms.masters.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.HrCommitteeHeader;
import jkt.hms.masters.business.HrInstEmpDept;
import jkt.hms.masters.business.HrInstitutionalSanctionedPost;
import jkt.hms.masters.business.HrMasSanctionedPostOrder;
import jkt.hms.masters.business.MasAccountSchedule;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAdmissionType;
import jkt.hms.masters.business.MasAnswers;
import jkt.hms.masters.business.MasInstituteDepartment;
import jkt.hms.masters.business.MasLsg;
import jkt.hms.masters.business.MasSpecialityHeading;
import jkt.hms.masters.business.MasTaluk;
import jkt.hms.masters.business.MasBranch;
import jkt.hms.masters.business.MasCadre;
import jkt.hms.masters.business.MasCaste;
import jkt.hms.masters.business.MasCompany;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasCurrency;
import jkt.hms.masters.business.MasDisposal;
import jkt.hms.masters.business.MasDocument;
import jkt.hms.masters.business.MasGrade;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasOccupation;
import jkt.hms.masters.business.MasPostCode;
import jkt.hms.masters.business.MasSpecialOfficial;
import jkt.hms.masters.business.MasSpecialityGroup;
import jkt.hms.masters.business.MasSpecialityParameter;
import jkt.hms.masters.business.MasStream;
import jkt.hms.masters.business.MasReference;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasReligion;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasUnitOfMeasurement;
import jkt.hms.masters.business.MasVillage;
import jkt.hms.masters.business.MasWard;
import jkt.hms.masters.business.PhMaster;
import jkt.hms.masters.business.PhMasterData;
import jkt.hms.masters.dataservice.GeneralMasterDataService;
import jkt.hms.util.Box;

public class GeneralMasterHandlerServiceImpl implements
		GeneralMasterHandlerService {

	GeneralMasterDataService generalMasterDataService = null;

	// ----------------------------------------Title
	// ---------------------------------------------------
	public boolean addTitle(MasTitle masTitle) {
		return generalMasterDataService.addTitle(masTitle);
	}

	public boolean editTitleToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editTitleToDatabase(generalMap);
	}

	public boolean deleteTitle(int titleId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteTitle(titleId, generalMap);
	}

	public Map<String, Object> searchTitle(String titleCode, String titleName) {
		return generalMasterDataService.searchTitle(titleCode, titleName);
	}

	public Map<String, Object> showTitleJsp() {
		return generalMasterDataService.showTitleJsp();
	}

	// ---------------------------Occupation----------------------

	public boolean addOccupation(MasOccupation masOccupation) {
		return generalMasterDataService.addOccupation(masOccupation);
	}

	public boolean editOccupationToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editOccupationToDatabase(generalMap);
	}

	public Map<String, Object> searchOccupation(String occupationCode,
			String occupationName) {
		return generalMasterDataService.searchOccupation(occupationCode,
				occupationName);
	}

	public Map<String, Object> showOccupationJsp() {
		return generalMasterDataService.showOccupationJsp();
	}

	public boolean deleteOccupation(int occupationId,
			Map<String, Object> generalMap) {
		return generalMasterDataService.deleteOccupation(occupationId,
				generalMap);
	}

	// ------------------------------Caste----------------------
	public boolean addCaste(MasCaste masCaste) {
		return generalMasterDataService.addCaste(masCaste);
	}

	public Map<String, Object> searchCaste(String casteCode, String casteName) {
		return generalMasterDataService.searchCaste(casteCode, casteName);
	}

	public Map<String, Object> showCasteJsp() {
		return generalMasterDataService.showCasteJsp();
	}

	public boolean editCasteToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editCasteToDatabase(generalMap);
	}

	public boolean deleteCaste(int casteId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteCaste(casteId, generalMap);
	}

	// --------------------------------Relation --------------------------------

	public boolean addRelation(MasRelation masRelation) {
		return generalMasterDataService.addRelation(masRelation);
	}

	public boolean deleteRelation(int relationId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteRelation(relationId, generalMap);
	}

	public boolean editRelationToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editRelationToDatabase(generalMap);
	}

	public Map<String, Object> searchRelation(String relationCode,
			String relationName) {
		return generalMasterDataService.searchRelation(relationCode,
				relationName);
	}

	public Map<String, Object> showRelationJsp() {
		return generalMasterDataService.showRelationJsp();
	}

	// --------------------------------------Religion-------------------------------------------

	public boolean editReligionToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editReligionToDatabase(generalMap);
	}

	public Map<String, Object> showReligionJsp() {
		return generalMasterDataService.showReligionJsp();
	}

	public boolean addReligion(MasReligion masReligion) {
		return generalMasterDataService.addReligion(masReligion);
	}

	public boolean deleteReligion(int religionId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteReligion(religionId, generalMap);
	}

	public Map<String, Object> searchReligion(String religionCode,
			String religionName) {
		return generalMasterDataService.searchReligion(religionCode,
				religionName);
	}

	// ----------------------------------------Marital Status
	// ----------------------------------------------------------

	public boolean addMaritalStatus(MasMaritalStatus masMaritalStatus) {
		return generalMasterDataService.addMaritalStatus(masMaritalStatus);
	}

	public boolean deleteMaritalStatus(int maritalStatusId,
			Map<String, Object> generalMap) {
		return generalMasterDataService.deleteMaritalStatus(maritalStatusId,
				generalMap);
	}

	public boolean editMaritalStatusToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editMaritalStatusToDatabase(generalMap);
	}

	public Map<String, Object> searchMaritalStatus(String maritalStatusCode,
			String maritalStatusName) {
		return generalMasterDataService.searchMaritalStatus(maritalStatusCode,
				maritalStatusName);
	}

	public Map<String, Object> showMaritalStatusJsp() {
		return generalMasterDataService.showMaritalStatusJsp();
	}

	// -------------------------------------Disposal---------------------------------------------

	public Map<String, Object> showDisposalJsp() {
		return generalMasterDataService.showDisposalJsp();
	}

	public Map<String, Object> searchDisposal(String disposalCode,
			String disposalName) {
		return generalMasterDataService.searchDisposal(disposalCode,
				disposalName);
	}

	public boolean addDisposal(MasDisposal masDisposal) {
		return generalMasterDataService.addDisposal(masDisposal);
	}

	public boolean deleteDisposal(int disposalId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteDisposal(disposalId, generalMap);
	}

	public boolean editDisposalToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editDisposalToDatabase(generalMap);
	}

	// ----------------------------------------Document-------------------------------

	public Map<String, Object> showDocumentJsp() {
		return generalMasterDataService.showDocumentJsp();
	}

	public Map<String, Object> searchDocument(String documentCode,
			String documentName) {
		return generalMasterDataService.searchDocument(documentCode,
				documentName);
	}

	public boolean addDocument(MasDocument masDocument) {
		return generalMasterDataService.addDocument(masDocument);
	}

	public boolean deleteDocument(int documentId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteDocument(documentId, generalMap);
	}

	public boolean editDocumentToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editDocumentToDatabase(generalMap);
	}

	// ---------------------------------UnitOfMeasurementMaster------------------------------------------

	public boolean addUnitOfMeasurement(
			MasUnitOfMeasurement masUnitOfMeasurement) {
		return generalMasterDataService
				.addUnitOfMeasurement(masUnitOfMeasurement);
	}

	public Map<String, Object> searchUnitOfMeasurement(
			String unitOfMeasurementCode, String unitOfMeasurementName) {
		return generalMasterDataService.searchUnitOfMeasurement(
				unitOfMeasurementCode, unitOfMeasurementName);
	}

	public Map<String, Object> showUnitOfMeasurementJsp() {
		return generalMasterDataService.showUnitOfMeasurementJsp();
	}

	public boolean editUnitOfMeasurementToDatabase(
			Map<String, Object> generalMap) {
		return generalMasterDataService
				.editUnitOfMeasurementToDatabase(generalMap);
	}

	public boolean deleteUnitOfMeasurement(int unitOfMeasurementId,
			Map<String, Object> generalMap) {
		return generalMasterDataService.deleteUnitOfMeasurement(
				unitOfMeasurementId, generalMap);
	}

	// ----------------------------- District
	// -------------------------------------------------------

	public boolean addDistrict(Map<String, Object> districtMap) {
		return generalMasterDataService.addDistrict(districtMap);
	}

	public boolean editDistrict(Map<String, Object> generalMap) {
		return generalMasterDataService.editDistrict(generalMap);
	}

	public Map<String, Object> searchDistrict(String districtCode,
			String districtName) {
		return generalMasterDataService.searchDistrict(districtCode,
				districtName);
	}

	public Map<String, Object> showDistrict() {
		return generalMasterDataService.showDistrict();
	}

	public boolean deleteDistrict(int districtId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteDistrict(districtId, generalMap);
	}

	// -----------------------------Taluk------------------------------------
	public boolean addTaluk(Map<String, Object> talukMap) {
		return generalMasterDataService.addTaluk(talukMap);
	}

	public boolean deleteTaluk(int talukId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteTaluk(talukId, generalMap);
	}

	public boolean editTaluk(Map<String, Object> generalMap) {
		return generalMasterDataService.editTaluk(generalMap);
	}

	public Map<String, Object> searchTaluk(String talukCode, String talukName) {
		return generalMasterDataService.searchTaluk(talukCode, talukName);
	}

	public Map<String, Object> showTaluk() {
		return generalMasterDataService.showTaluk();
	}

	// -----------------------------PostCode---------------------------------------------

	public boolean addPostCode(MasPostCode masPostCode) {
		return generalMasterDataService.addPostCode(masPostCode);
	}

	public boolean deletePostCode(int postCodeId, Map<String, Object> generalMap) {
		return generalMasterDataService.deletePostCode(postCodeId, generalMap);
	}

	public boolean editPostCode(Map<String, Object> generalMap) {
		return generalMasterDataService.editPostCode(generalMap);
	}

	public Map<String, Object> searchPostCode(String postCodeCode,
			String postCodeName) {
		return generalMasterDataService.searchPostCode(postCodeCode,
				postCodeName);
	}

	public Map<String, Object> showPostCodeJsp() {
		return generalMasterDataService.showPostCodeJsp();
	}

	// ------------------------State
	// ---------------------------------------------

	public boolean addState(MasState masState) {
		return generalMasterDataService.addState(masState);
	}

	public boolean deleteState(int stateId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteState(stateId, generalMap);
	}

	public boolean editState(Map<String, Object> generalMap) {
		return generalMasterDataService.editState(generalMap);
	}

	public Map<String, Object> searchState(String stateCode, String stateName) {
		return generalMasterDataService.searchState(stateCode, stateName);
	}

	public Map<String, Object> showStateJsp() {
		return generalMasterDataService.showStateJsp();
	}

	// ---------------------currency----------------------
	public boolean addCurrency(MasCurrency masCurrency) {
		return generalMasterDataService.addCurrency(masCurrency);
	}

	public boolean editCurrencyToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editCurrencyToDatabase(generalMap);
	}

	public Map<String, Object> searchCurrency(String currencyCode,
			String currencyName) {
		return generalMasterDataService.searchCurrency(currencyCode,
				currencyName);
	}

	public Map<String, Object> showCurrencyJsp() {
		return generalMasterDataService.showCurrencyJsp();
	}

	public boolean deleteCurrency(int currencyId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteCurrency(currencyId, generalMap);
	}

	// ------------------------------country-----------------

	public boolean addCountry(MasCountry masCountry) {
		return generalMasterDataService.addCountry(masCountry);
	}

	public boolean editCountryToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editCountryToDatabase(generalMap);
	}

	public Map<String, Object> searchCountry(String countryCode,
			String countryName) {
		return generalMasterDataService.searchCountry(countryCode, countryName);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showCountryJsp() {
		return generalMasterDataService.showCountryJsp();
	}

	public boolean deleteCountry(int countryId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteCountry(countryId, generalMap);
	}

	// --------------------

	public List<MasTaluk> getTalukList() {
		return generalMasterDataService.getTalukList();
	}

	// ---------------------------------Reference
	// Master----------------------------------------

	public boolean addReference(MasReference masReference) {
		return generalMasterDataService.addReference(masReference);
	}

	public boolean deleteReference(int referenceId,
			Map<String, Object> generalMap) {
		return generalMasterDataService
				.deleteReference(referenceId, generalMap);
	}

	public boolean editReferenceToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editReferenceToDatabase(generalMap);
	}

	public Map<String, Object> searchReference(String referenceCode,
			String referenceName) {
		return generalMasterDataService.searchReference(referenceCode,
				referenceName);
	}

	public Map<String, Object> showReferenceJsp() {
		return generalMasterDataService.showReferenceJsp();
	}

	// ----------------------------Administrative
	// Sex----------------------------------------

	public Map<String, Object> showAdministrativeSexJsp() {
		return generalMasterDataService.showAdministrativeSexJsp();
	}

	public Map<String, Object> searchAdministrativeSex(
			String administrativeSexCode, String administrativeSexName) {
		return generalMasterDataService.searchAdministrativeSex(
				administrativeSexCode, administrativeSexName);
	}

	public boolean addAdministrativeSex(
			MasAdministrativeSex masAdministrativeSex) {
		return generalMasterDataService
				.addAdministrativeSex(masAdministrativeSex);
	}

	public boolean deleteAdministrativeSex(int administrativeSexId,
			Map<String, Object> generalMap) {
		return generalMasterDataService.deleteAdministrativeSex(
				administrativeSexId, generalMap);
	}

	public boolean editAdministrativeSexToDatabase(
			Map<String, Object> generalMap) {
		return generalMasterDataService
				.editAdministrativeSexToDatabase(generalMap);
	}

	// ------------------------------Admission
	// Type---------------------------------
	public boolean addAdmissionType(MasAdmissionType masAdmissionType) {
		return generalMasterDataService.addAdmissionType(masAdmissionType);
	}

	public boolean deleteAdmissionType(int admissionTypeId,
			Map<String, Object> generalMap) {
		return generalMasterDataService.deleteAdmissionType(admissionTypeId,
				generalMap);
	}

	public boolean editAdmissionTypeToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editAdmissionTypeToDatabase(generalMap);
	}

	public Map<String, Object> searchAdmissionType(String admissionTypeCode,
			String admissionTypeName) {
		return generalMasterDataService.searchAdmissionType(admissionTypeCode,
				admissionTypeName);
	}

	public Map<String, Object> showAdmissionTypeJsp() {
		return generalMasterDataService.showAdmissionTypeJsp();
	}

	public Map<String, Object> getConnection() {
		return generalMasterDataService.getConnection();
	}

	// ----------------------------------------------------------------------

	public GeneralMasterDataService getGeneralMasterDataService() {
		return generalMasterDataService;
	}

	public void setGeneralMasterDataService(
			GeneralMasterDataService generalMasterDataService) {
		this.generalMasterDataService = generalMasterDataService;
	}

	// -----------------------------Village------------------------------------
	public boolean addVillage(MasVillage masVillage) {
		return generalMasterDataService.addVillage(masVillage);
	}

	public boolean deleteVillage(int villageId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteVillage(villageId, generalMap);
	}

	public boolean editVillage(Map<String, Object> generalMap) {
		return generalMasterDataService.editVillage(generalMap);
	}

	public Map<String, Object> searchVillage(String villageCode,
			String villageName) {
		return generalMasterDataService.searchVillage(villageCode, villageName);
	}

	public Map<String, Object> showVillage() {
		return generalMasterDataService.showVillage();
	}

	public List<MasVillage> getVillageList() {
		// TODO Auto-generated method stub
		return null;
	}

	// ----------------------- Company---------------------
	public Map<String, Object> showCompanyJsp() {
		return generalMasterDataService.showCompanyJsp();
	}

	public boolean addCompanyDetails(MasCompany masCompany) {
		return generalMasterDataService.addCompanyDetails(masCompany);
	}

	public boolean deleteCompany(int companyId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteCompany(companyId, generalMap);
	}

	public Map<String, Object> searchCompany(String companyCode,
			String companyName) {
		return generalMasterDataService.searchCompany(companyCode, companyName);
	}

	public boolean updateCompanyDetails(Map<String, Object> generalMap) {
		return generalMasterDataService.updateCompanyDetails(generalMap);
	}

	public Map<String, Object> getHospitalName(Map<String, Object> mapForDs) {
		return generalMasterDataService.getHospitalName(mapForDs);
	}

	
	public boolean addBranch(MasBranch masBranch) {
		
		return generalMasterDataService.addBranch( masBranch);
	}

	
	public boolean editBranch(Map<String, Object> generalMap) {
		
		return generalMasterDataService.editBranch(generalMap);
	}

	
	public Map<String, Object> showBranchMasterJsp() {
		
		return generalMasterDataService.showBranchMasterJsp();
	}

	
	public boolean deleteBranch(int branchId, Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return generalMasterDataService.deleteBranch(branchId,generalMap);
	}
//---------------------------- Grade
	//@Override
	public boolean addGrade(MasGrade masGrade) {
		return generalMasterDataService.addGrade(masGrade);
	}

	//@Override
	public Map<String, Object> showGradeJsp() {
		// TODO Auto-generated method stub
		return generalMasterDataService.showGradeJsp();
	}

	//@Override
	public boolean editGradeToDatabase(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return generalMasterDataService.editGradeToDatabase(generalMap);
	}

	//@Override
	public boolean deleteGrade(int gradeId, Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return generalMasterDataService.deleteGrade(gradeId, generalMap);
	}

	//@Override
	public Map<String, Object> searchGrade(String gradeCode) {
		// TODO Auto-generated method stub
		return generalMasterDataService.searchGrade(gradeCode);
	}

	//@Override
	public Map<String, Object> searchStream(String streamName) {
		// TODO Auto-generated method stub
		return generalMasterDataService.searchStream(streamName);
	}

	//@Override
	public Map<String, Object> showStreamJsp() {
		// TODO Auto-generated method stub
		return generalMasterDataService.showStreamJsp();
	}

	//@Override
	public boolean deleteStream(int streamId, Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return generalMasterDataService.deleteStream(streamId, generalMap);
	}

	//@Override
	public boolean editStreamToDatabase(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return generalMasterDataService.editStreamToDatabase(generalMap);
	}

	//@Override
	public boolean addStream(MasStream masStream) {
		// TODO Auto-generated method stub
		return generalMasterDataService.addStream(masStream);
	}
	
	
//----------------- Cadre
	



	//@Override
	public Map<String, Object> searchCadre(String cadreName) {
		// TODO Auto-generated method stub
		return generalMasterDataService.searchCadre(cadreName);
	}

	//@Override
	public Map<String, Object> showCadreJsp() {
		// TODO Auto-generated method stub
		return generalMasterDataService.showCadreJsp();
	}

	//@Override
	public boolean deleteCadre(int cadreId, Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return generalMasterDataService.deleteCadre(cadreId, generalMap);
	}

	//@Override
	public boolean editCadreToDatabase(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return generalMasterDataService.editCadreToDatabase(generalMap);
	}

	//@Override
	public boolean addCadre(MasCadre masCadre) {
		// TODO Auto-generated method stub
		return generalMasterDataService.addCadre(masCadre);
	}

	//@Override
	public Map<String, Object> searchSpecialOfficial(String specialOfficialName) {
		// TODO Auto-generated method stub
		return generalMasterDataService.searchSpecialOfficial(specialOfficialName);
	}

	//@Override
	public Map<String, Object> showSpecialOfficialJsp() {
		// TODO Auto-generated method stub
		return generalMasterDataService.showSpecialOfficialJsp();
	}

	//@Override
	public boolean deleteSpecialOfficial(int specialOfficialId,
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return generalMasterDataService.deleteSpecialOfficial(specialOfficialId, generalMap);
	}

	//@Override
	public boolean editSpecialOfficialToDatabase(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return generalMasterDataService.editSpecialOfficialToDatabase(generalMap);
	}

	//@Override
	public boolean addSpecialOfficial(MasSpecialOfficial masSpecialOfficial) {
		// TODO Auto-generated method stub
		return generalMasterDataService.addSpecialOfficial(masSpecialOfficial);
	}

	//@Override
	public Map<String, Object> showSanctionPostOrderJsp() {
		return generalMasterDataService.showSanctionPostOrderJsp();
	}

	//@Override
	public boolean addSanctionedPostOrder(HrMasSanctionedPostOrder masSanctionedPostOrder) {
			
		return generalMasterDataService.addSanctionedPostOrder(masSanctionedPostOrder);
	}

	//@Override
	public Map<String, Object> showSanctionPostInstitute() {
		return generalMasterDataService.showSanctionPostInstitute();
	}

	//@Override
	public Map<String, Object> searchOrderNo(String orderNo) {
		return generalMasterDataService.searchOrderNo(orderNo);
	}

	//@Override
	public boolean editSanctionPostOrderToDatabase(
			Map<String, Object> generalMap) {
		return generalMasterDataService.editSanctionPostOrderToDatabase(generalMap);
	}

	//@Override
	public boolean deleteSanctionPostOrder(int orderId,
			Map<String, Object> generalMap) {
		return generalMasterDataService.deleteSanctionPostOrder(orderId,generalMap);
	}

	//@Override
	public boolean addSanctionInstitutePost(
			HrInstitutionalSanctionedPost hrInstitutionalSanctionedPost) {
		return generalMasterDataService.addSanctionInstitutePost(hrInstitutionalSanctionedPost);
	}

	//@Override
	public Map<String, Object> searchSanctionInstitutePost(String refOrder) {
		return generalMasterDataService.searchSanctionInstitutePost(refOrder);
	}

	//@Override
	public boolean editSanctionInstitutePostToDatabase(
			Map<String, Object> generalMap) {
		return generalMasterDataService.editSanctionInstitutePostToDatabase(generalMap);
	}

	//@Override
	public boolean deleteSanctionInstitutePost(int refOrderId,Map<String, Object> generalMap) {
			
		return generalMasterDataService. deleteSanctionInstitutePost( refOrderId,generalMap);
	}
//-----------------------------------------------------
	public Map<String, Object> showGroupJsp() {
		return generalMasterDataService.showGroupJsp();
	}
	
	public boolean addGroup(MasSpecialityGroup maGroup) {
		return generalMasterDataService.addGroup(maGroup);
	}
	public Map<String, Object> searchGroup(String groupCode,String groupName) {
		return generalMasterDataService.searchGroup(groupCode,groupName);
	}
	
	public boolean editGroupToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editGroupToDatabase(generalMap);
	}
	
	public boolean deleteGroup(int grpId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteGroup(grpId, generalMap);
	}
	
	//-----------------------------------------------------
	public Map<String, Object> showParameterJsp() {
		return generalMasterDataService.showParameterJsp();
				
	}
	
	public boolean addParameter(MasSpecialityParameter masParameter){
		
		return generalMasterDataService.addParameter(masParameter);
	}
	
	public Map<String, Object> searchParameter(String parameterCode,String parameterName) {
		return generalMasterDataService.searchParameter(parameterCode,parameterName);
	}
	
	public boolean editParameterToDatabase(Map<String, Object> generalMap){
		return generalMasterDataService.editParameterToDatabase(generalMap);
		
	}
	
	public boolean deleteParameter(int grpId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteParameter(grpId, generalMap);
	}
	
	//--------------------             --------------------------------
	
	public Map<String, Object> showGroupParaMasterJSP(Map<String, Object> details){
		return generalMasterDataService.showGroupParaMasterJSP(details);
	}
	
	
     public boolean addGroupParaMaster(Map m){
		
		return generalMasterDataService.addGroupParaMaster(m);
	}
     
     public boolean deleteGroupParaMaster(int id, Map<String, Object> generalMap) {
 		return generalMasterDataService.deleteGroupParaMaster(id, generalMap);
 	}
     
    
     

 
	//--------------  -----------------------------
 
 
 


//@Override
public Map<String, Object> showDepartWiseGrpMaster(Map<String, Object> details) {
	
	return generalMasterDataService.showDepartWiseGrpMaster(details);
}

 

//@Override
public boolean deleteDepartWiseGrpMaster(int id, Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return generalMasterDataService.deleteDepartWiseGrpMaster(id,generalMap);
}

//------------------------------   --------------------------------  ----

 public Map<String, Object> showCommitteeJsp(){
	
	return generalMasterDataService.showCommitteeJsp();
	
}

public boolean addCommittee(HrCommitteeHeader hrCommHed){

return generalMasterDataService.addCommittee(hrCommHed);

}
public Map<String, Object> searchCommittee(String commCode,String commName) {
	return generalMasterDataService.searchCommittee(commCode,commName);

}
//@Override
public boolean addWard(MasWard masWard) {
	return generalMasterDataService.addWard(masWard);
}

//@Override
public Map<String, Object> showWard() {
	return generalMasterDataService.showWard();
}

//@Override
public boolean editWard(Map<String, Object> generalMap) {
	return generalMasterDataService.editWard(generalMap);
}

//@Override
public Map<String, Object> searchWard(String wardCode, String wardName) {
	return generalMasterDataService.searchWard(wardCode, wardName);
}

//@Override
public boolean deleteWard(int wardId, Map<String, Object> generalMap) {
	return generalMasterDataService.deleteWard(wardId, generalMap);
}


//@Override
public Map showElectricalSection() {
	return generalMasterDataService.showElectricalSection();
}

//@Override
public boolean addElectricalSection(Map<String, Object> electricalSectionMap) {
	return generalMasterDataService.addElectricalSection(electricalSectionMap);
}

//@Override
public boolean editElectricalSection(Map<String, Object> generalMap) {
	return generalMasterDataService.editElectricalSection(generalMap);
}

//@Override
public Map<String, Object> searchElectricalSection(
		String electricalSectionCode, String electricalSectionName) {
	return generalMasterDataService.searchElectricalSection(electricalSectionCode, electricalSectionName);
}

//@Override
public boolean deleteElectricalSection(int electricalSectionId,
		Map<String, Object> generalMap) {
	return generalMasterDataService.deleteElectricalSection(electricalSectionId, generalMap);
}

//@Override
public boolean deletePanchayat(int panchayatId, Map<String, Object> generalMap) {
	return generalMasterDataService.deletePanchayat(panchayatId, generalMap);
}

//@Override
public Map<String, Object> searchPanchayat(String panchayatCode,
		String panchayatName) {
	return generalMasterDataService.searchPanchayat(panchayatCode, panchayatName);
}

//@Override
public Map<String, Object> showPanchayat() {
	return generalMasterDataService.showPanchayat();
}

//@Override
public boolean editPanchayat(Map<String, Object> generalMap) {
	return generalMasterDataService.editPanchayat(generalMap);
}

//@Override
public boolean addPanchayat(Map<String, Object> panchayatMap) {
	return generalMasterDataService.addPanchayat(panchayatMap);
}


//@Override
public Map<String, Object> showLocalityJsp() {
	return generalMasterDataService.showLocalityJsp();
}

//@Override
public Map<String, Object> addLocality(Box box) {
	return generalMasterDataService.addLocality(box);
}

//@Override
public Map<String, Object> updateLocality(Box box) {
	return generalMasterDataService.updateLocality(box);
}

//@Override
public boolean deleteLocality(Box box) {
	return generalMasterDataService.deleteLocality(box);
}

//@Override
public Map<String, Object> searchLocality(Box box) {
	return generalMasterDataService.searchLocality(box);
}



//@Override
public Map showParliyament() {
	return generalMasterDataService.showParliyament();
}

//@Override
public boolean addParliyament(Map<String, Object> parliyamentMap) {
	return generalMasterDataService.addParliyament(parliyamentMap);
}

//@Override
public boolean editParliyament(Map<String, Object> generalMap) {
	return generalMasterDataService.editParliyament(generalMap);
}

//@Override
public Map<String, Object> searchParliyament(String code, String name) {
	return generalMasterDataService.searchParliyament(code, name);
}

//@Override
public boolean deleteParliyament(int parliyamentId, Map<String, Object> generalMap) {
	return generalMasterDataService.deleteParliyament(parliyamentId, generalMap);
}



//@Override
public Map showAssembly() {
	return generalMasterDataService.showAssembly();
}

//@Override
public boolean addAssembly(Map<String, Object> parliyamentMap) {
	return generalMasterDataService.addAssembly(parliyamentMap);
}

//@Override
public boolean editAssembly(Map<String, Object> generalMap) {
	return generalMasterDataService.editAssembly(generalMap);
}

//@Override
public Map<String, Object> searchAssembly(String code, String name) {
	return generalMasterDataService.searchAssembly(code, name);
}

//@Override
public boolean deleteAssembly(int assemblyId, Map<String, Object> generalMap) {
	return generalMasterDataService.deleteAssembly(assemblyId, generalMap);
}



//@Override
public Map<String, Object> showCharityType() {
	return generalMasterDataService.showCharityType();
}

//@Override
public boolean editCharityType(Map<String, Object> generalMap) {
	return generalMasterDataService.editCharityType(generalMap);
}

//@Override
public Map<String, Object> searchCharityType(String charityTypeCode,
		String charityTypeName) {
	return generalMasterDataService.searchCharityType(charityTypeCode, charityTypeName);
}

//@Override
public boolean deleteCharityType(int charityTypeId,
		Map<String, Object> generalMap) {
	return generalMasterDataService.deleteCharityType(charityTypeId, generalMap);
}

//@Override
public boolean addCharityType(Map<String, Object> charityTypeMap) {
	return generalMasterDataService.addCharityType(charityTypeMap);
}


//-----------------Deprtment Group Parameter- --------------------------


public Map<String, Object> showDepartmentGroupParameter(Map<String, Object> generalMap){
	
	return generalMasterDataService.showDepartmentGroupParameter(generalMap);
	
}
public boolean addDepartmentGroupParameter(Map<String, Object> generalMap){

return generalMasterDataService.addDepartmentGroupParameter(generalMap);

}


//@Override
public boolean editDepartmentGroupParameter(Map<String, Object> generalMap,Box box) {
	// TODO Auto-generated method stub
	return  generalMasterDataService.editDepartmentGroupParameter(generalMap,box);
}

public Map<String, Object> searchDepartmentGroupParameter(String districtName){
	
	return  generalMasterDataService.searchDepartmentGroupParameter(districtName);
}


public boolean deleteDepartmentGroupParameter(int id,Map<String, Object> generalMap){
	
	return  generalMasterDataService.deleteDepartmentGroupParameter(id,generalMap);
}

//@Override
public boolean addDepartmentGrPara(Map<String, Object> m) {
	// TODO Auto-generated method stub
	return false;
}

//@Override
public boolean editGroupParaMaster(Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return generalMasterDataService.editGroupParaMaster(generalMap) ;
}


//@Override
public Map<String, Object> showSpecialtyTemplate() {
	return generalMasterDataService.showSpecialtyTemplate();
}

//@Override
public boolean editSpecialtyTemplate(Map<String, Object> generalMap) {
	return generalMasterDataService.editSpecialtyTemplate(generalMap);
}

//@Override
public Map<String, Object> searchSpecialtyTemplate(String specialtyTemplateCode,
		String specialtyTemplateName) {
	return generalMasterDataService.searchSpecialtyTemplate(specialtyTemplateCode, specialtyTemplateName);
}

//@Override
public boolean deleteSpecialtyTemplate(int specialtyTemplateId,
		Map<String, Object> generalMap) {
	return generalMasterDataService.deleteSpecialtyTemplate(specialtyTemplateId, generalMap);
}

//@Override
public boolean addSpecialtyTemplate(Map<String, Object> specialtyTemplateMap) {
	return generalMasterDataService.addSpecialtyTemplate(specialtyTemplateMap);
}


//--------------------------     -----------------------
public String getDepartmentNameFromId(int departmentId) {
	return generalMasterDataService.getDepartmentNameFromId(departmentId);
}

//@Override
public Map<String, Object> showSpecialtyJsp() {
	return generalMasterDataService.showSpecialtyJsp();
}

public Map<String, Object> showGroupAndParameterValues(Map map){
	
	return generalMasterDataService.showGroupAndParameterValues(map);
	
}

public Map<String, Object> showPopUpForValues(Map map){
	
	return generalMasterDataService.showPopUpForValues(map);
	
}

//@Override
public boolean saveSpeciality(Map generalMap) {
	// TODO Auto-generated method stub
	return generalMasterDataService.saveSpeciality(generalMap);
}

//@Override
public boolean editQuestions(Map<String, Object> generalMap) {
	return generalMasterDataService.editQuestions(generalMap);
}

//@Override
public Map<String, Object> showQuestions() {
	return generalMasterDataService.showQuestions();
}

//@Override
public Map<String, Object> searchQuestions(String questionno, String question) {
	return generalMasterDataService.searchQuestions(questionno, question);
}

//@Override
public boolean deleteQuestions(int questionsId, Map<String, Object> generalMap) {
	return generalMasterDataService.deleteQuestions(questionsId, generalMap);
}

//@Override
public boolean addQuestions(Map<String, Object> questionsMap) {
	return generalMasterDataService.addQuestions(questionsMap);
}

//@Override
public Map<String, Object> searchAnswers(String answersName) {
	// TODO Auto-generated method stub
	return generalMasterDataService.searchAnswers(answersName);
}

//@Override
public Map showAnswersJsp() {
	// TODO Auto-generated method stub
	return generalMasterDataService.showAnswersJsp();
}

//@Override
public boolean addAnswers(MasAnswers masAnswers) {
	// TODO Auto-generated method stub
	return generalMasterDataService.addAnswers(masAnswers);
}

//@Override
public boolean editAnswersToDatabase(Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return generalMasterDataService.editAnswersToDatabase(generalMap);
}

//@Override
public boolean deleteAnswers(int answersId, Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return generalMasterDataService.deleteAnswers(answersId, generalMap);
}

//@Override
public Map<String, Object> showQuestionAnswersJsp() {
	// TODO Auto-generated method stub
	return generalMasterDataService.showQuestionAnswersJsp();
}

//@Override
public Map<String, Object> addQuestionAnswers(Box box) {
	// TODO Auto-generated method stub
	return generalMasterDataService.addQuestionAnswers(box);
}

//@Override
public Map<String, Object> updateQuestionAnswers(Box box) {
	// TODO Auto-generated method stub
	return generalMasterDataService.updateQuestionAnswers(box);
}

//@Override
public boolean deleteQuestionAnswers(Box box) {
	// TODO Auto-generated method stub
	return generalMasterDataService.deleteQuestionAnswers(box);
}

//@Override
public Map<String, Object> searchQuestionAnswers(Box box) {
	// TODO Auto-generated method stub
	return generalMasterDataService.searchQuestionAnswers(box);
}

//@Override
public Map showEmpDept() {
	// TODO Auto-generated method stub
	return generalMasterDataService.showEmpDept();
}

//@Override
public boolean addEmpDept(Map<String, Object> empDeptMap) {
	// TODO Auto-generated method stub
	return generalMasterDataService.addEmpDept(empDeptMap);
}

//@Override
public boolean editEmpDept(Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return generalMasterDataService.editEmpDept(generalMap);
}

//@Override
public Map<String, Object> searchEmpDept(String empDeptCode, String empDeptName) {
	// TODO Auto-generated method stub
	return generalMasterDataService.searchEmpDept(empDeptCode, empDeptName);
}

//@Override
public boolean deleteEmpDept(int empDeptId, Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return generalMasterDataService.deleteEmpDept(empDeptId, generalMap);
}



//@Override
public Map<String, Object> showInstWiseEmpDeptJsp(Map<String, Object> dataMap) {
	return generalMasterDataService.showInstWiseEmpDeptJsp( dataMap);
}

//@Override
public Map<String, Object> showInstWiseEmpDeptMapJsp(int Inst_id) {
	return generalMasterDataService.showInstWiseEmpDeptMapJsp(Inst_id);
}

//@Override
public List<HrInstEmpDept> getInstituteWiseEmpDeptMap(Map parameterMap) {
	return generalMasterDataService.getInstituteWiseEmpDeptMap(parameterMap);
}



//@Override
public  Map<String, Object> saveInstWiseEmpDept(Map<String, Object> detailsMap) {
	return generalMasterDataService.saveInstWiseEmpDept(detailsMap);
}

//@Override
public Map<String, Object> fillHospital(int val,
		Map<String, Object> detailsMap) {
	return generalMasterDataService.fillHospital(val, detailsMap);
}

//@Override
public Map<String, Object> showEmpSCMappingJsp(int hospitalId) {
	return generalMasterDataService.showEmpSCMappingJsp(hospitalId);
}

//@Override
public Map<String, Object> saveEmpSCMapping(Map<String, Object> detailsMap) {
	return generalMasterDataService.saveEmpSCMapping(detailsMap);
}

//@Override
public Map<String, Object> fillEmployee(int val, Map<String, Object> detailsMap) {
	return generalMasterDataService.fillEmployee(val,detailsMap);
}

//@Override
public Map<String, Object> populateEmployeeByCategory(int employeeCategoryId, Map<String, Object> detailsMap) {
	return generalMasterDataService.populateEmployeeByCategory(employeeCategoryId,detailsMap);
}

//@Override
public Map showAccountSchedule() {
	return generalMasterDataService.showAccountSchedule();
}

//@Override
public boolean addAccountSchedule(MasAccountSchedule masAccountSchedule) {
	return generalMasterDataService.addAccountSchedule(masAccountSchedule);
}

//@Override
public boolean editAccountSchedule(Map<String, Object> generalMap) {
	return generalMasterDataService.editAccountSchedule(generalMap);
}

//@Override
public Map<String, Object> searchAccountSchedule(int scheduleCode,
		String scheduleName) {
	return generalMasterDataService.searchAccountSchedule(scheduleCode, scheduleName);
}

//@Override
public boolean deleteAccountSchedule(int scheduleId,
		Map<String, Object> generalMap) {
	return generalMasterDataService.deleteAccountSchedule(scheduleId, generalMap);
}

//@Override
public List<MasAccountSchedule> checkExistingAccountSchedule(Box box) {
	return generalMasterDataService.checkExistingAccountSchedule(box);
}

//@Override
public List<Object[]> getDataForExcelReportServicing(String queryForBillServicing) {
	// TODO Auto-generated method stub
	return generalMasterDataService.getDataForExcelReportServicing(queryForBillServicing);
}


// -----------------------------Village------------------------------------
public boolean addLsg(MasLsg masLsg) {
	return generalMasterDataService.addLsg(masLsg);
}

public boolean deleteLsg(int lsgId, Map<String, Object> generalMap) {
	return generalMasterDataService.deleteLsg(lsgId, generalMap);
}

public boolean editLsg(Map<String, Object> generalMap) {
	return generalMasterDataService.editLsg(generalMap);
}

public Map<String, Object> searchLsg(String lsgTypeCode,
		String lsgTypeName) {
	return generalMasterDataService.searchLsg(lsgTypeCode, lsgTypeName);
}

public Map<String, Object> showLsg() {
	return generalMasterDataService.showLsg();
}

@Override
public Map<String, Object> getDataForExcel(Map<String, Object> mapDetalis) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Object[]> getDataForExcelReportCashRefund(String queryForCashRefund) {
	// TODO Auto-generated method stub
	return  generalMasterDataService.getDataForExcelReportCashRefund(queryForCashRefund);
}

@Override
public List<Object[]> getDataForExcelReportChargeSlip(String queryForChargeSlip) {
	// TODO Auto-generated method stub
	return  generalMasterDataService.getDataForExcelReportChargeSlip(queryForChargeSlip);
}

@Override
public List<Object[]> getDataForExcelReportDailyCash(String querydailyCashReport) {
	// TODO Auto-generated method stub
	return  generalMasterDataService.getDataForExcelReportDailyCash(querydailyCashReport);
}

@Override
public List<Object[]> getDataForCashCollectionReport(String queryCashCollectionReport) {
	// TODO Auto-generated method stub
	return  generalMasterDataService.getDataForCashCollectionReport(queryCashCollectionReport);
}

@Override
public Map<String, Object> showMaster() {
	// TODO Auto-generated method stub
	return  generalMasterDataService.showMaster();
}

@Override
public boolean editMaster(Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return  generalMasterDataService.editMaster(generalMap);
}

@Override
public boolean addMaster(PhMaster phMaster) {
	// TODO Auto-generated method stub
	return  generalMasterDataService.addMaster(phMaster);
}

@Override
public Map<String, Object> searchMaster(String masterCode, String masterName) {
	// TODO Auto-generated method stub
	return  generalMasterDataService.searchMaster(masterCode, masterName);
}

@Override
public boolean deleteMaster(int masterId, Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return  generalMasterDataService.deleteMaster(masterId, generalMap);
}

@Override
public Map<String, Object> showPhMasterDataJsp() {
	// TODO Auto-generated method stub
	return  generalMasterDataService.showPhMasterDataJsp();
}

@Override
public boolean deletePhMasterData(int dataId, Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return  generalMasterDataService.deletePhMasterData(dataId, generalMap);
}

@Override
public boolean editPhMasterData(Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return  generalMasterDataService.editPhMasterData(generalMap);
}

@Override
public Map<String, Object> searchPhMasterData(String phMasterDataName) {
	// TODO Auto-generated method stub
	return generalMasterDataService.searchPhMasterData(phMasterDataName);
}

@Override
public boolean addPhMasterData(PhMasterData phMasterData, int masterId) {
	// TODO Auto-generated method stub
	return generalMasterDataService.addPhMasterData(phMasterData, masterId);
}

@Override
public Map<String, Object> existRecord(Map<String, Object> generalMap) {
	return generalMasterDataService.existRecord(generalMap);
}

@Override //govind code 11-7-2016
public Map<String, Object> populateLsgByDistrictId(int districtId) { 
	
	return generalMasterDataService.populateLsgByDistrictId(districtId);
}
 //end code

@Override //govind code 12-7-2016
public Map<String, Object> populateWardByLsgId(int lsgId) { 
	
	return generalMasterDataService.populateWardByLsgId(lsgId);
}
 //end code



//--------------- Heading Master----------------------

@Override
public Map<String, Object> showHeadingJsp() {
	// TODO Auto-generated method stub
	return generalMasterDataService.showHeadingJsp();
}

@Override
public boolean deleteHeading(int headingId, Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return generalMasterDataService.deleteHeading(headingId, generalMap);
}

@Override
public boolean editHeadingToDatabase(Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return generalMasterDataService.editHeadingToDatabase(generalMap);
}

@Override
public Map<String, Object> searchHeading(String headingOne, String headingTwo) {
	// TODO Auto-generated method stub
	return generalMasterDataService.searchHeading(headingOne, headingTwo);
}

@Override
public boolean addHeading(MasSpecialityHeading masHeading) {
	// TODO Auto-generated method stub
	return generalMasterDataService.addHeading(masHeading);
}

@Override
public Map<String, Object> getHospitalListForAutoCompleteItem(
		Map<String, Object> map1) {
	return generalMasterDataService.getHospitalListForAutoCompleteItem(map1);
}

@Override
public Map<String, Object> viewSpecialityTemplate(Box box) {
	
	return generalMasterDataService.viewSpecialityTemplate(box);
}

@Override
public Map<String, Object> showUserSpecilaityTemplateJsp(Box box) {
	
	return generalMasterDataService.showUserSpecilaityTemplateJsp(box);
}

@Override
public Map<String, Object> saveUserSpecialityTemplate(Map<String, Object> dataMap) {
	
	return generalMasterDataService.saveUserSpecialityTemplate(dataMap);
}

@Override
public Map<String, Object> removeSpecialityTemplateApplicationList(
		Map<String, Object> removeTemplateMap) {
	// TODO Auto-generated method stub
	return generalMasterDataService.removeSpecialityTemplateApplicationList(removeTemplateMap);
}

@Override
public Map<String, Object> displayGroupSequence(Box box) {
	// TODO Auto-generated method stub
	return generalMasterDataService.displayGroupSequence(box);
}

@Override
public Map<String, Object> showDeparmentGroupValue(Box box) {
	// TODO Auto-generated method stub
	return generalMasterDataService.showDeparmentGroupValue(box);
}

@Override
public Map<String, Object> importLocality(Map<String, Object> utilMap) {
	return generalMasterDataService.importLocality(utilMap);
}



}
