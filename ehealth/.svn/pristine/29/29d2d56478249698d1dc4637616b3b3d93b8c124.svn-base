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
import jkt.hms.masters.business.MasReference;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasReligion;
import jkt.hms.masters.business.MasSpecialOfficial;
import jkt.hms.masters.business.MasSpecialityGroup;
import jkt.hms.masters.business.MasSpecialityParameter;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasStream;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasUnitOfMeasurement;
import jkt.hms.masters.business.MasVillage;
import jkt.hms.masters.business.MasWard;
import jkt.hms.masters.business.PhMaster;
import jkt.hms.masters.business.PhMasterData;
import jkt.hms.util.Box;


public interface GeneralMasterHandlerService {

	// ---------------------------- Title----------------------------

	Map<String, Object> showTitleJsp();

	Map<String, Object> searchTitle(String titleCode, String titleName);

	boolean addTitle(MasTitle masTitle);

	boolean editTitleToDatabase(Map<String, Object> generalMap);

	boolean deleteTitle(int titleId, Map<String, Object> generalMap);

	// -----------------------------Relation----------------------------------------------------
	Map<String, Object> searchRelation(String relationCode, String relationName);

	Map<String, Object> showRelationJsp();

	boolean addRelation(MasRelation masRelation);

	boolean editRelationToDatabase(Map<String, Object> generalMap);

	boolean deleteRelation(int relationId, Map<String, Object> generalMap);

	// --------------------RELIGION------------------------------------

	boolean addReligion(MasReligion masReligion);

	boolean deleteReligion(int religionId, Map<String, Object> generalMap);

	boolean editReligionToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchReligion(String titleCode, String titleName);

	Map<String, Object> showReligionJsp();

	// ---------------------------------Marital Status
	// ----------------------------------------

	Map<String, Object> showMaritalStatusJsp();

	Map<String, Object> searchMaritalStatus(String maritalStatusCode,
			String maritalStatusName);

	boolean addMaritalStatus(MasMaritalStatus masMaritalStatus);

	boolean editMaritalStatusToDatabase(Map<String, Object> generalMap);

	boolean deleteMaritalStatus(int maritalStatusId,
			Map<String, Object> generalMap);

	// -----------------------------Disposal------------------------------------------

	Map<String, Object> showDisposalJsp();

	Map<String, Object> searchDisposal(String disposalCode, String disposalName);

	boolean addDisposal(MasDisposal masDisposal);

	boolean editDisposalToDatabase(Map<String, Object> generalMap);

	boolean deleteDisposal(int disposalId, Map<String, Object> generalMap);

	// -----------------------------Disposal------------------------------------------

	Map<String, Object> showDocumentJsp();

	Map<String, Object> searchDocument(String documentCode, String documentName);

	boolean addDocument(MasDocument masdocument);

	boolean editDocumentToDatabase(Map<String, Object> generalMap);

	boolean deleteDocument(int documentId, Map<String, Object> generalMap);

	// ----------------------- Occupation-------------------------

	boolean addOccupation(MasOccupation masOccupation);

	boolean editUnitOfMeasurementToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchOccupation(String occupationCode,
			String occupationName);

	Map<String, Object> showOccupationJsp();

	boolean editOccupationToDatabase(Map<String, Object> generalMap);

	boolean deleteOccupation(int occupationId, Map<String, Object> generalMap);

	// ------------------------ Caste-----------------------------

	boolean addCaste(MasCaste masCaste);

	Map<String, Object> searchCaste(String casteCode, String casteName);

	Map<String, Object> showCasteJsp();

	boolean editCasteToDatabase(Map<String, Object> generalMap);

	boolean deleteCaste(int casteId, Map<String, Object> generalMap);

	// ---------------------- UnitOfMeasurement-----------------------

	boolean addUnitOfMeasurement(MasUnitOfMeasurement masUnitOfMeasurement);

	Map<String, Object> searchUnitOfMeasurement(String unitOfMeasurementCode,
			String unitOfMeasurementName);

	Map<String, Object> showUnitOfMeasurementJsp();

	boolean deleteUnitOfMeasurement(int unitOfMeasurementId,
			Map<String, Object> generalMap);

	// ----------------------- District-----------------------------------------

	boolean addDistrict(Map<String, Object> districtMap);

	Map<String, Object> showDistrict();

	boolean editDistrict(Map<String, Object> generalMap);

	Map<String, Object> searchDistrict(String districtCode, String districtName);

	boolean deleteDistrict(int districtId, Map<String, Object> generalMap);

	// ------------------------------------Taluk--------------------------
	boolean addTaluk(Map<String, Object> talukMap);

	List<MasTaluk> getTalukList();

	Map<String, Object> showTaluk();

	boolean editTaluk(Map<String, Object> generalMap);

	Map<String, Object> searchTaluk(String talukCode, String talukName);

	boolean deleteTaluk(int talukId, Map<String, Object> generalMap);

	// -----------------------Post Code--------------------------------
	boolean addPostCode(MasPostCode masPostCode);

	Map<String, Object> showPostCodeJsp();

	boolean editPostCode(Map<String, Object> generalMap);

	Map<String, Object> searchPostCode(String postCodeCode, String postCodeName);

	boolean deletePostCode(int postCodeId, Map<String, Object> generalMap);

	// ----------------------------------State
	// -------------------------------------

	boolean addState(MasState obj);

	Map<String, Object> showStateJsp();

	Map<String, Object> searchState(String stateCode, String stateName);

	boolean editState(Map<String, Object> generalMap);

	boolean deleteState(int stateId, Map<String, Object> generalMap);

	// ---------------currency-----------------------

	public boolean addCurrency(MasCurrency masCurrency);

	Map<String, Object> showCurrencyJsp();

	Map<String, Object> searchCurrency(String currencyCode, String currencyName);

	boolean editCurrencyToDatabase(Map<String, Object> generalMap);

	public boolean deleteCurrency(int currencyId, Map<String, Object> generalMap);

	// ---------------------country ------------------

	public boolean addCountry(MasCountry masCountry);

	Map<String, Object> showCountryJsp();

	boolean editCountryToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchCountry(String countryCode, String countryName);

	public boolean deleteCountry(int countryId, Map<String, Object> generalMap);

	// ---------------------- Reference ----------------------

	boolean addReference(MasReference referenceMaster);

	boolean deleteReference(int referenceId, Map<String, Object> generalMap);

	Map<String, Object> searchReference(String referenceCode,
			String referenceName);

	Map<String, Object> showReferenceJsp();

	boolean editReferenceToDatabase(Map<String, Object> generalMap);

	// -----------------------------Administrative
	// Sex------------------------------

	Map<String, Object> searchAdministrativeSex(String costCenterCode,
			String costCenterName);

	Map<String, Object> showAdministrativeSexJsp();

	boolean addAdministrativeSex(MasAdministrativeSex masAdministrativeSex);

	boolean editAdministrativeSexToDatabase(Map<String, Object> generalMap);

	boolean deleteAdministrativeSex(int costCenterId,
			Map<String, Object> generalMap);

	// -------------------------------Admission
	// Type----------------------------------

	Map<String, Object> showAdmissionTypeJsp();

	Map<String, Object> searchAdmissionType(String admissionTypeCode,
			String admissionTypeName);

	boolean addAdmissionType(MasAdmissionType masAdmissionType);

	boolean editAdmissionTypeToDatabase(Map<String, Object> generalMap);

	boolean deleteAdmissionType(int admissionTypeId,
			Map<String, Object> generalMap);

	Map<String, Object> getConnection();

	boolean addVillage(MasVillage masVillage);

	List<MasVillage> getVillageList();

	Map<String, Object> showVillage();

	boolean editVillage(Map<String, Object> generalMap);

	Map<String, Object> searchVillage(String villageCode, String villageName);

	boolean deleteVillage(int villageId, Map<String, Object> generalMap);

	Map<String, Object> showCompanyJsp();

	Map<String, Object> searchCompany(String companyCode, String companyName);

	boolean addCompanyDetails(MasCompany masCompany);

	boolean updateCompanyDetails(Map<String, Object> generalMap);

	boolean deleteCompany(int companyId, Map<String, Object> generalMap);

	Map<String, Object> getHospitalName(Map<String, Object> mapForDs);

	Map<String, Object> showBranchMasterJsp();

	boolean addBranch(MasBranch masBranch);

	boolean editBranch(Map<String, Object> generalMap);

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
	
	//------------------ Cradre
	

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

	boolean deleteSanctionPostOrder(int orderId, Map<String, Object> generalMap);

	boolean addSanctionInstitutePost(
			HrInstitutionalSanctionedPost hrInstitutionalSanctionedPost);

	Map<String, Object> searchSanctionInstitutePost(String refOrder);

	boolean editSanctionInstitutePostToDatabase(Map<String, Object> generalMap);

	boolean deleteSanctionInstitutePost(int refOrderId,
			Map<String, Object> generalMap);
	
	
	//-----------------------------------
	Map<String, Object> showGroupJsp();
	
	boolean addGroup(MasSpecialityGroup maGroup);
	
	Map<String, Object> searchGroup(String groupCode,String groupName);
	
	boolean editGroupToDatabase(Map<String, Object> generalMap);
	
	public boolean deleteGroup(int grpId, Map<String, Object> generalMap);
	
	//--------------- ---------------------------
	
	Map<String, Object> showParameterJsp();
	
	boolean addParameter(MasSpecialityParameter masParameter);
	
	Map<String, Object> searchParameter(String parameterCode,String parameterName);
	
	boolean editParameterToDatabase(Map<String, Object> generalMap);
	
	public boolean deleteParameter(int grpId, Map<String, Object> generalMap);
	
	// --------------------   ---------------------------
	
	Map<String, Object> showGroupParaMasterJSP(Map<String, Object> details);


	boolean addGroupParaMaster(Map m);
		
	boolean deleteGroupParaMaster(int id, Map<String, Object> generalMap);
	

	//-------------------------   ---------------------------------
	
	
	boolean addDepartmentGrPara(Map<String, Object> m);

	Map<String, Object> showDepartWiseGrpMaster(Map<String, Object> details);

	boolean deleteDepartWiseGrpMaster(int id, Map<String, Object> generalMap);
	
	//---------------------  ----------------------- ---------------
	
	

	boolean addCommittee(HrCommitteeHeader hrCommHed);

	Map<String, Object> showCommitteeJsp();

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

	boolean deleteElectricalSection(int electricalSectionId,
			Map<String, Object> generalMap);

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
	

	
	Map<String, Object> searchCommittee(String titleCode, String titleName);
	
	//------------------ Department Group Parameter ---------------
	
	Map<String, Object> showDepartmentGroupParameter(Map<String, Object> generalMap);
	
	boolean addDepartmentGroupParameter(Map<String, Object> generalMap);

	boolean editDepartmentGroupParameter(Map<String, Object> generalMap, Box box);

	boolean deleteDepartmentGroupParameter(int id,Map<String, Object> generalMap);
	
	public Map<String, Object> searchDepartmentGroupParameter(String districtName);
	

	Map<String, Object> showSpecialtyTemplate();

	boolean editSpecialtyTemplate(Map<String, Object> generalMap);

	Map<String, Object> searchSpecialtyTemplate(String specialtyTemplateCode,
			String specialtyTemplateName);

	boolean deleteSpecialtyTemplate(int specialtyTemplateId, Map<String, Object> generalMap);

	boolean addSpecialtyTemplate(Map<String, Object> specialtyTemplateMap);
	
	//-----------------      --------------------------

	String getDepartmentNameFromId(int departmentId);
	
	Map<String, Object> showSpecialtyJsp();
	
	public Map<String, Object> showGroupAndParameterValues(Map map);
	
	public Map<String, Object> showPopUpForValues(Map map);
	
	public boolean saveSpeciality(Map generalMap);
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
	
	Map<String, Object> showInstWiseEmpDeptMapJsp(int Inst_id);

	List<HrInstEmpDept> getInstituteWiseEmpDeptMap(Map parameterMap);

	 Map<String, Object> saveInstWiseEmpDept(Map<String, Object> detailsMap);

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

		List<Object[]> getDataForExcelReportServicing(
				String queryForBillServicing);

		

		// Lsg-------------------------------
		

		boolean deleteLsg(int lsgId, Map<String, Object> generalMap);

		boolean editLsg(Map<String, Object> generalMap);

		Map<String, Object> searchLsg(String lsgTypeCode, String lsgTypeName);

		Map<String, Object> showLsg();

		boolean addLsg(MasLsg masLsg);

		Map<String, Object> getDataForExcel(Map<String, Object> mapDetalis);

		List<Object[]> getDataForExcelReportCashRefund(String queryForCashRefund);

		List<Object[]> getDataForExcelReportChargeSlip(String queryForChargeSlip);

		List<Object[]> getDataForExcelReportDailyCash(String querydailyCashReport);

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

		Map<String,Object> populateLsgByDistrictId(int stateId); //govind 11-7-2016
		Map<String,Object> populateWardByLsgId(int lsgId); //govind 12-7-2016

		
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
