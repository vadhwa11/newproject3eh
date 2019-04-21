package jkt.hms.masters.dataservice;

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
import jkt.hms.util.Box;


public interface GeneralMasterDataService {

	// -------------------------- Caste---------------------------------

	boolean addCaste(MasCaste masCaste);

	Map<String, Object> searchCaste(String casteCode, String casteName);

	Map<String, Object> showCasteJsp();

	boolean editCasteToDatabase(Map<String, Object> generalMap);

	boolean deleteCaste(int casteId, Map<String, Object> generalMap);

	// -------------------------- Occupation-----------------------

	boolean addOccupation(MasOccupation masOccupation);

	boolean editOccupationToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchOccupation(String occupationCode,
			String occupationName);

	Map<String, Object> showOccupationJsp();

	boolean deleteOccupation(int occupationId, Map<String, Object> generalMap);

	Map<String, Object> getHospitalName(Map<String, Object> mapForDs);

	// --------------------------------Title--------------------------------

	Map<String, Object> showTitleJsp();

	Map<String, Object> searchTitle(String titleCode, String titleName);

	boolean addTitle(MasTitle masTitle);

	boolean editTitleToDatabase(Map<String, Object> generalMap);

	boolean deleteTitle(int titleId, Map<String, Object> generalMap);

	// --------------------------Relation
	// ---------------------------------------

	Map<String, Object> showRelationJsp();

	Map<String, Object> searchRelation(String relationCode, String relationName);

	boolean addRelation(MasRelation masRelation);

	boolean deleteRelation(int relationId, Map<String, Object> generalMap);

	boolean editRelationToDatabase(Map<String, Object> generalMap);

	// ---------------------------------------Religion--------------------------------

	boolean editReligionToDatabase(Map<String, Object> generalMap);

	boolean addReligion(MasReligion masReligion);

	boolean deleteReligion(int religionId, Map<String, Object> generalMap);

	Map<String, Object> showReligionJsp();

	Map<String, Object> searchReligion(String religionCode, String religionName);

	// ---------------------------------------Marital
	// Status-------------------------------------------

	Map<String, Object> searchMaritalStatus(String maritalStatusCode,
			String maritalStatusName);

	Map<String, Object> showMaritalStatusJsp();

	boolean deleteMaritalStatus(int maritalStatusId,
			Map<String, Object> generalMap);

	boolean addMaritalStatus(MasMaritalStatus masMaritalStatus);

	boolean editMaritalStatusToDatabase(Map<String, Object> generalMap);

	// ----------------------------------------Disposal------------------------------------------

	Map<String, Object> showDisposalJsp();

	Map<String, Object> searchDisposal(String disposalCode, String disposalName);

	boolean addDisposal(MasDisposal masDisposal);

	boolean deleteDisposal(int disposalId, Map<String, Object> generalMap);

	boolean editDisposalToDatabase(Map<String, Object> generalMap);

	// ------------------------------Document-------------------------------------

	Map<String, Object> searchDocument(String documentCode, String documentName);

	Map<String, Object> showDocumentJsp();

	boolean addDocument(MasDocument masDocument);

	boolean deleteDocument(int documentId, Map<String, Object> generalMap);

	boolean editDocumentToDatabase(Map<String, Object> generalMap);

	// --------------------------UnitOfMeasurement
	// Master---------------------------------

	boolean addUnitOfMeasurement(MasUnitOfMeasurement masUnitOfMeasurement);

	Map<String, Object> searchUnitOfMeasurement(String unitOfMeasurementCode,
			String unitOfMeasurementName);

	Map<String, Object> showUnitOfMeasurementJsp();

	boolean editUnitOfMeasurementToDatabase(Map<String, Object> generalMap);

	boolean deleteUnitOfMeasurement(int unitOfMeasurementId,
			Map<String, Object> generalMap);

	// ------------------------------------District--------------------------

	boolean addDistrict(Map<String, Object> districtMap);

	boolean editDistrict(Map<String, Object> generalMap);

	Map<String, Object> searchDistrict(String districtCode, String districtName);

	Map<String, Object> showDistrict();

	boolean deleteDistrict(int districtId, Map<String, Object> generalMap);

	// -------------------------------------------
	// Taluk-------------------------------
	boolean addTaluk(Map<String, Object> talukMap);

	boolean deleteTaluk(int talukId, Map<String, Object> generalMap);

	boolean editTaluk(Map<String, Object> generalMap);

	Map<String, Object> searchTaluk(String talukCode, String talukName);

	Map<String, Object> showTaluk();

	// ----------------------------------------Post
	// Code-------------------------------
	boolean addPostCode(MasPostCode masPostCode);

	boolean deletePostCode(int postCodeId, Map<String, Object> generalMap);

	boolean editPostCode(Map<String, Object> generalMap);

	Map<String, Object> searchPostCode(String postCodeCode, String postCodeName);

	Map<String, Object> showPostCodeJsp();

	// ------------------------State
	// --------------------------------------------

	boolean addState(MasState masState);

	boolean deleteState(int stateId, Map<String, Object> generalMap);

	boolean editState(Map<String, Object> generalMap);

	Map<String, Object> searchState(String stateCode, String stateName);

	Map<String, Object> showStateJsp();

	// ---------------------------currency--------------

	public boolean addCurrency(MasCurrency masCurrency);

	boolean editCurrencyToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchCurrency(String currencyCode, String currencyName);

	Map<String, Object> showCurrencyJsp();

	public boolean deleteCurrency(int currencyId, Map<String, Object> generalMap);

	// ----------------------------country------------------------

	public boolean addCountry(MasCountry masCountry);

	boolean editCountryToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchCountry(String countryCode, String countryName);

	Map<String, Object> showCountryJsp();

	public boolean deleteCountry(int countryId, Map<String, Object> generalMap);

	List<MasTaluk> getTalukList();

	// --------------------------Reference
	// Master---------------------------------

	boolean addReference(MasReference referenceMaster);

	boolean deleteReference(int referenceId, Map<String, Object> generalMap);

	boolean editReferenceToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchReference(String referenceCode,
			String referenceName);

	Map<String, Object> showReferenceJsp();

	// ------------------------------------Administrative
	// Sex------------------------------
	boolean addAdministrativeSex(MasAdministrativeSex masAdministrativeSex);

	boolean deleteAdministrativeSex(int administrativeSexId,
			Map<String, Object> generalMap);

	boolean editAdministrativeSexToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchAdministrativeSex(String administrativeSexCode,
			String administrativeSexName);

	Map<String, Object> showAdministrativeSexJsp();

	// ---------------------------------Admission
	// Type-----------------------------

	boolean addAdmissionType(MasAdmissionType masAdmissionType);

	boolean deleteAdmissionType(int admissionTypeId,
			Map<String, Object> generalMap);

	boolean editAdmissionTypeToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchAdmissionType(String admissionTypeCode,
			String admissionTypeName);

	Map<String, Object> showAdmissionTypeJsp();

	Map<String, Object> getConnection();

	// -------------------------------------------
	// Village-------------------------------
	// boolean addVillage(MasVillage masVillage);

	boolean deleteVillage(int villageId, Map<String, Object> generalMap);

	boolean editVillage(Map<String, Object> generalMap);

	Map<String, Object> searchVillage(String villageCode, String villageName);

	Map<String, Object> showVillage();

	boolean addVillage(MasVillage masVillage);

	// -------------------------------------Company----------------------

	Map<String, Object> showCompanyJsp();

	boolean addCompanyDetails(MasCompany masCompany);

	boolean deleteCompany(int companyId, Map<String, Object> generalMap);

	Map<String, Object> searchCompany(String companyCode, String companyName);

	boolean updateCompanyDetails(Map<String, Object> generalMap);

	boolean addBranch(MasBranch masBranch);

	boolean editBranch(Map<String, Object> generalMap);

	Map<String, Object> showBranchMasterJsp();

	boolean deleteBranch(int branchId, Map<String, Object> generalMap);
	
	//-----------------------------Grade
	
	boolean addGrade(MasGrade masGrade);

	Map<String, Object> showGradeJsp();

	boolean editGradeToDatabase(Map<String, Object> generalMap);

	boolean deleteGrade(int gradeId, Map<String, Object> generalMap);

	Map<String, Object> searchGrade(String gradeCode);
	
	//----------------------- Stream
	
		Map<String, Object> searchStream(String streamName);

		Map<String, Object> showStreamJsp();

		boolean deleteStream(int streamId, Map<String, Object> generalMap);

		boolean editStreamToDatabase(Map<String, Object> generalMap);
		
		boolean addStream(MasStream masStream);
		//------------------------ Cadre
		

		Map<String, Object> showCadreJsp();

		boolean editCadreToDatabase(Map<String, Object> generalMap);

		boolean deleteCadre(int cadreId, Map<String, Object> generalMap);

		Map<String, Object> searchCadre(String cadreName);
		
		boolean addCadre(MasCadre masCadre);
		
		//----------------------- SpecialOfficial
		
		Map<String, Object> searchSpecialOfficial(String specialOfficialName);

		Map<String, Object> showSpecialOfficialJsp();

		boolean deleteSpecialOfficial(int specialOfficialId, Map<String, Object> generalMap);

		boolean editSpecialOfficialToDatabase(Map<String, Object> generalMap);
		
		boolean addSpecialOfficial(MasSpecialOfficial masSpecialOfficial);

		Map<String, Object> showSanctionPostOrderJsp();

		boolean addSanctionedPostOrder(
				HrMasSanctionedPostOrder masSanctionedPostOrder);

		Map<String, Object> showSanctionPostInstitute();

		Map<String, Object> searchOrderNo(String orderNo);

		boolean editSanctionPostOrderToDatabase(Map<String, Object> generalMap);

		boolean deleteSanctionPostOrder(int orderId,Map<String, Object> generalMap);

		boolean addSanctionInstitutePost(
				HrInstitutionalSanctionedPost hrInstitutionalSanctionedPost);

		Map<String, Object> searchSanctionInstitutePost(String refOrder);

		boolean deleteSanctionInstitutePost(int refOrderId, Map<String, Object> generalMap);

		boolean editSanctionInstitutePostToDatabase(
				Map<String, Object> generalMap);
		
		//-----------------------------------------------------------
		
		Map<String, Object> showGroupJsp();
		
		boolean addGroup(MasSpecialityGroup maGroup);
		
		Map<String, Object> searchGroup(String groupCode,String groupName);
		
		boolean editGroupToDatabase(Map<String, Object> generalMap);
		
		boolean deleteGroup(int grpId, Map<String, Object> generalMap);
		
		//---------------------------  ---------------------------------
		
		Map<String, Object> showParameterJsp();
		
		boolean addParameter(MasSpecialityParameter  masParameter);
		
		Map<String, Object> searchParameter(String parameterCode,String parameterName);
		
		boolean editParameterToDatabase(Map<String, Object> generalMap);
		
		boolean deleteParameter(int grpId, Map<String, Object> generalMap);
		
		//-------------------- -----           ---------
		
		Map<String, Object> showGroupParaMasterJSP(Map<String, Object> details);

		boolean addGroupParaMaster(Map m);

		
		boolean deleteGroupParaMaster(int id, Map<String, Object> generalMap);
		
		
		//-----------------------------------   ---------------------------
		
		
		

		Map<String, Object> showDepartWiseGrpMaster(Map<String, Object> details);
		
		boolean addDepartmentGrPara(Map m);

		boolean deleteDepartWiseGrpMaster(int id, Map<String, Object> generalMap);

		
		//-----------------------------   ---------------------------------

		
		Map<String, Object> showCommitteeJsp();
		
		boolean addCommittee(HrCommitteeHeader hrCommHed);

		
		
		
		boolean addWard(MasWard masWard);

		Map<String, Object> showWard();

		boolean editWard(Map<String, Object> generalMap);

		Map<String, Object> searchWard(String wardCode, String wardName);

		boolean deleteWard(int wardId, Map<String, Object> generalMap);
		
		
		
		Map showElectricalSection();

		boolean addElectricalSection(Map<String, Object> electricalSectionMap);

		boolean editElectricalSection(Map<String, Object> generalMap);

		Map<String, Object> searchElectricalSection(String electricalSectionCode,
				String electricalSectionName);

		boolean deleteElectricalSection(int electricalSectionId,Map<String, Object> generalMap);
		
		
		boolean deletePanchayat(int panchayatId, Map<String, Object> generalMap);

		Map<String, Object> searchPanchayat(String panchayatCode,
				String panchayatName);

		Map<String, Object> showPanchayat();

		boolean editPanchayat(Map<String, Object> generalMap);

		boolean addPanchayat(Map<String, Object> panchayatMap);

		

		Map<String, Object> showLocalityJsp();

		Map<String, Object> addLocality(Box box);

		Map<String, Object> updateLocality(Box box);

		boolean deleteLocality(Box box);

		Map<String, Object> searchLocality(Box box);
		
		
		
		Map showParliyament();

		boolean addParliyament(Map<String, Object> parliyamentMap);

		boolean editParliyament(Map<String, Object> generalMap);

		Map<String, Object> searchParliyament(String code, String name);

		boolean deleteParliyament(int parliyamentId, Map<String, Object> generalMap);
		
		
		
		Map showAssembly();

		boolean addAssembly(Map<String, Object> parliyamentMap);

		boolean editAssembly(Map<String, Object> generalMap);

		Map<String, Object> searchAssembly(String code, String name);

		boolean deleteAssembly(int assemblyId, Map<String, Object> generalMap);


		Map<String, Object> showCharityType();

		boolean editCharityType(Map<String, Object> generalMap);

		Map<String, Object> searchCharityType(String charityTypeCode,
				String charityTypeName);

		boolean deleteCharityType(int charityTypeId, Map<String, Object> generalMap);

		boolean addCharityType(Map<String, Object> charityTypeMap);
		
	
		
		
		boolean editGroupParaMaster(Map<String, Object> generalMap);
		
		
		

		Map<String, Object> searchCommittee(String casteCode, String casteName);
		
	//==================== DEpartment Group Parameter ======================================	
		
		Map<String, Object> showDepartmentGroupParameter(Map<String, Object> generalMap);

		boolean addDepartmentGroupParameter(Map<String, Object> generalMap);
		
		boolean editDepartmentGroupParameter(Map<String, Object> generalMap, Box box);

		boolean deleteDepartmentGroupParameter(int id,Map<String, Object> generalMap);
		
		public Map<String, Object> searchDepartmentGroupParameter(String districtName);
		//-------------------------------- 
		
		Map<String, Object> showSpecialtyTemplate();

		boolean editSpecialtyTemplate(Map<String, Object> generalMap);

		Map<String, Object> searchSpecialtyTemplate(String specialtyTemplateCode,
				String specialtyTemplateName);

		boolean deleteSpecialtyTemplate(int specialtyTemplateId, Map<String, Object> generalMap);

		boolean addSpecialtyTemplate(Map<String, Object> specialtyTemplateMap);
		
	// ---------------          ----------------------      
		
		String getDepartmentNameFromId(int departmentId);
		
		Map<String, Object> showSpecialtyJsp();
		
		public Map<String, Object> showGroupAndParameterValues(Map map);

		Map<String, Object> showPopUpForValues(Map map);

		boolean saveSpeciality(Map generalMap);
		
//----------------------------
		//------------------- Questions
		boolean editQuestions(Map<String, Object> generalMap);

		Map<String, Object> showQuestions();

		Map<String, Object> searchQuestions(String questionno, String question);

		boolean deleteQuestions(int questionsId, Map<String, Object> generalMap);

		boolean addQuestions(Map<String, Object> questionsMap);
		
		
		//------------------- Answers
		Map<String, Object> searchAnswers(String answersName);

		Map showAnswersJsp();

		boolean addAnswers(MasAnswers masAnswers);

		boolean editAnswersToDatabase(Map<String, Object> generalMap);

		boolean deleteAnswers(int answersId, Map<String, Object> generalMap);
		
		//------------------------- QuestionAnswers
		Map<String, Object> showQuestionAnswersJsp();

		Map<String, Object> addQuestionAnswers(Box box);

		Map<String, Object> updateQuestionAnswers(Box box);

		boolean deleteQuestionAnswers(Box box);

		Map<String, Object> searchQuestionAnswers(Box box);

		//--------------------------- Mas Emp Dept
		Map showEmpDept();

		boolean addEmpDept(Map<String, Object> empDeptMap);

		boolean editEmpDept(Map<String, Object> generalMap);

		Map<String, Object> searchEmpDept(String empDeptCode, String empDeptName);

		boolean deleteEmpDept(int empDeptId, Map<String, Object> generalMap);
		
		Map<String, Object> showInstWiseEmpDeptJsp(Map<String, Object> dataMap);

		 Map<String, Object> saveInstWiseEmpDept(Map<String, Object> detailsMap);	

		Map<String, Object> showInstWiseEmpDeptMapJsp(int Inst_id);
		
		List<HrInstEmpDept> getInstituteWiseEmpDeptMap(Map parameterMap);
		

		Map<String, Object> fillHospital(int val,Map<String, Object> detailsMap);

		Map<String, Object> showEmpSCMappingJsp(int hospitalId);

		Map<String, Object> saveEmpSCMapping(Map<String, Object> detailsMap);

		Map<String, Object> fillEmployee(int val, Map<String, Object> detailsMap);
		
		Map<String, Object> populateEmployeeByCategory(int employeeCategoryId, Map<String, Object> detailsMap);


		Map showAccountSchedule();

		boolean addAccountSchedule(MasAccountSchedule masAccountSchedule);

		boolean editAccountSchedule(Map<String, Object> generalMap);

		Map<String, Object> searchAccountSchedule(int scheduleCode,
				String scheduleName);

		boolean deleteAccountSchedule(int scheduleId,
				Map<String, Object> generalMap);

		List<MasAccountSchedule> checkExistingAccountSchedule(Box box);

		List<Object[]> getDataForExcelReportServicing(String queryForBillServicing);
		
		List<Object[]> getDataForExcelReportDailyCash(String querydailyCashReport);


		// Lsg-------------------------------
	

		boolean deleteLsg(int lsgId, Map<String, Object> generalMap);

		boolean editLsg(Map<String, Object> generalMap);

		Map<String, Object> searchLsg(String lsgTypeCode, String lsgTypeName);

		Map<String, Object> showLsg();

		boolean addLsg(MasLsg masLsg);

		

		List<Object[]> getDataForExcelReportChargeSlip(String queryForChargeSlip);

		List<Object[]> getDataForExcelReportCashRefund(String queryForCashRefund);

		List<Object[]> getDataForCashCollectionReport(
				String queryCashCollectionReport);
		
		
		Map<String, Object> showMaster();

		boolean editMaster(Map<String, Object> generalMap);

		boolean addMaster(PhMaster phMaster);

		Map<String, Object> searchMaster(String masterCode, String masterName);

		boolean deleteMaster(int masterId, Map<String, Object> generalMap);
		
		
		Map<String, Object> showPhMasterDataJsp();

		boolean deletePhMasterData(int dataId, Map<String, Object> generalMap);

		boolean editPhMasterData(Map<String, Object> generalMap);

		Map<String, Object> searchPhMasterData(String phMasterDataName);

		boolean addPhMasterData(PhMasterData phMasterData, int masterId);
		
		Map<String, Object> existRecord(Map<String, Object> generalMap);

		Map<String, Object> populateLsgByDistrictId(int districtId);//govind code 11-7-2011

		Map<String, Object> populateWardByLsgId(int lsgId);//govind code 11-7-2011s
		
		
		
		//--------------- Heading Master----------------------
		
		Map<String, Object> showHeadingJsp();

		boolean deleteHeading(int headingId, Map<String, Object> generalMap);

		boolean editHeadingToDatabase(Map<String, Object> generalMap);

		Map<String, Object> searchHeading(String headingOne, String headingTwo);

		boolean addHeading(MasSpecialityHeading masHeading);

		Map<String, Object> getHospitalListForAutoCompleteItem(
				Map<String, Object> map1);

		Map<String, Object> viewSpecialityTemplate(Box box);

		Map<String, Object> showUserSpecilaityTemplateJsp(Box box);

		Map<String, Object> saveUserSpecialityTemplate(
				Map<String, Object> dataMap);

		Map<String, Object> removeSpecialityTemplateApplicationList(
				Map<String, Object> removeTemplateMap);

		Map<String, Object> displayGroupSequence(Box box);

		Map<String, Object> showDeparmentGroupValue(Box box);
		
		Map<String, Object> importLocality(Map<String, Object> utilMap);	

}