package jkt.hms.masters.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.HrEmployeeExitInterview;
import jkt.hms.masters.business.HrEmployeePerformanceReview;
import jkt.hms.masters.business.HrExitInterviewAnswers;
import jkt.hms.masters.business.MasEmpCategory;
import jkt.hms.masters.business.MasEmpStatus;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDependent;
import jkt.hms.masters.business.MasEmployeeTemp;
import jkt.hms.masters.business.MasFormation;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.MasRecordOfficeAddress;
import jkt.hms.masters.business.MasReferralDoctor;
import jkt.hms.masters.business.MasStoreBrand;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MasWing;
import jkt.hms.util.Box;
import jkt.hrms.masters.business.HrEmployeeBalanceNew;
import jkt.hrms.masters.business.HrEmployeeExperience;
import jkt.hrms.masters.business.HrEmployeePayElements;
import jkt.hrms.masters.business.HrEmployeePayStructure;
import jkt.hrms.masters.business.HrEmployeePersonelDetails;
import jkt.hrms.masters.business.HrMasEmployeeEducation;
import jkt.hrms.masters.business.HrMasLeaveTypeMediator;
import jkt.hrms.masters.business.MasEmployeeContract;
import jkt.hrms.masters.business.MasEmployeeType;
import jkt.hrms.masters.business.MasLocation;
import jkt.hrms.masters.business.UserManager;

public interface PersonnelMasterHandlerService {

	// ------------------------- Emp Status--------------------------------

	Map<String, Object> searchEmpStatus(String empStatusCode,
			String empStatusName);

	Map<String, Object> showEmpStatusJsp();

	boolean addEmpStatus(MasEmpStatus masEmpStatus);

	boolean editEmpStatusToDatabase(Map<String, Object> generalMap);

	boolean deleteEmpStatus(int empStatusId, Map<String, Object> generalMap);

	// ----------------Referral Doctor --------------------------------------
	Map<String, Object> showReferralDoctorJsp();

	Map<String, Object> searchReferralDoctor(String referralDoctorName);

	boolean addReferralDoctor(MasReferralDoctor masReferralDoctor);

	boolean editReferralDoctorToDatabase(Map<String, Object> generalMap);

	boolean deleteReferralDoctor(int referralDoctorId,
			Map<String, Object> generalMap);

	// --------------------Employee Dependent ------------------------

	Map<String, Object> showEmployeeDependentJsp();

	boolean addEmployeeDependent(MasEmployeeDependent masEmployeeDependent);

	boolean editEmployeeDependent(Map<String, Object> generalMap);

	boolean deleteEmployeeDependent(int employeeDependentId,
			Map<String, Object> generalMap);

	Map<String, Object> searchEmployeeDependent(String employeeDependentCode,
			String employeeDependentName);

	// --------------------------------------Rank------------------------------------
	Map<String, Object> showRankJsp();

	boolean addRank(MasRank masRank);

	Map<String, Object> searchRank(String rankCode, String rankName);

	boolean editRankToDatabase(Map<String, Object> generalMap);

	boolean deleteRank(int rankId, Map<String, Object> generalMap);

	// -----------------------------------------
	// formation-----------------------------
	Map<String, Object> showFormationJsp();

	Map<String, Object> searchFormation(String formationCode,
			String formationName);

	boolean editFormationToDatabase(Map<String, Object> generalMap);

	boolean deleteFormation(int formationId, Map<String, Object> generalMap);

	boolean addFormation(MasFormation masFormation);

	// ----------------------------------------Trade
	// -------------------------------------
	Map<String, Object> showTradeJsp();

	boolean deleteTrade(int tradeId, Map<String, Object> generalMap);

	boolean editTradeToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchTrade(String tradeName);

	boolean addTrade(MasTrade masTrade);

	// ---------------------------------------Unit---------------------------------------
	Map<String, Object> showUnitJsp();

	boolean deleteUnit(int unitId, Map<String, Object> generalMap);

	boolean editUnitToDatabase(Map<String, Object> generalMap);

	boolean addUnit(MasUnit masUnit);

	Map<String, Object> searchUnit(String unitName);

	// ------------------------Employee Contract ------------------------
	Map<String, Object> searchEmployeeContract(Integer employeeId);

	Map<String, Object> showEmployeeContractJsp();

	Boolean addEmployeeContract(MasEmployeeContract employeeContract);

	MasEmployeeContract getEmployeeContract(Integer empContractId);

	boolean deleteEmployeeContract(int employeeContractId,
			Map<String, Object> generalMap);

	// -------------------------Employee Education-----------------------
	void addEmployeeEducation(HrMasEmployeeEducation employeeEducation);

	// -------------------------Employee Experience-----------------------
	void addEmployeeExperience(HrEmployeeExperience employeeExperience);

	// ------------------------- Employee -------------------------------

	Map<String, Object> addEmployee(MasEmployee masEmployee, int hospitalId);

	boolean editEmployeeToDatabase(Map<String, Object> generalMap);

	boolean deleteEmployee(int employeeId, Map<String, Object> generalMap);

	Map<String, Object> showEmployeeJsp(Map<String, Object> dataMap);

	Map<String, Object> searchEmployee(String employeeCode, String firstName,
			String lastName, int hospitalId);

	MasHospital getCompany(Integer hospitalId);

	MasEmployee getLastAddedEmployee();

	MasEmployeeType getEmployeeType(Integer employeeTypeId);

	MasEmployee getEmployee(Integer employeeId);

	// -------------------------------------Record Office
	// Address--------------------------------------------

	Map<String, Object> showRecordOfficeAddressJsp();

	Map<String, Object> searchRecordOfficeAddress(String recordOfficeAddress);

	boolean addRecordOfficeAddress(MasRecordOfficeAddress masRecordOfficeAddress);

	boolean deleteRecordOfficeAddress(int recordOfficeAddressId,
			Map<String, Object> generalMap);

	boolean editRecordOfficeAddress(Map<String, Object> generalMap);

	// -----------------------Rank Category-----------------------------------

	Map<String, Object> showRankCategoryJsp();

	Map<String, Object> searchRankCategory(String rankCategoryCode,
			String rankCategoryName);

	boolean addRankCategory(MasRankCategory masRankCategory);

	boolean editRankCategoryToDatabase(Map<String, Object> generalMap);

	boolean deleteRankCategory(int rankCategoryId,
			Map<String, Object> generalMap);

	// -----------------------------BrandMaster---------------------------------

	Map<String, Object> showBrandJsp();

	Map<String, Object> searchBrand(String brandCode, String brandName);

	boolean addBrand(MasStoreBrand masBrand);

	boolean editBrandToDatabase(Map<String, Object> generalMap);

	boolean deleteBrand(int brandId, Map<String, Object> generalMap);

	Map<String, Object> getConnection();

	int getItemId(String pvms);

	// ----------------------Employee Pay Structure-------------------------

	Map<String, Object> showEmployeePayStructureJsp();

	Map<String, Object> searchEmployeePayStructure(Integer employeeId);

	void addEmployeePayStructure(HrEmployeePayStructure employeePayStructure);

	HrEmployeePayStructure getEmployeePayStructure(Integer payStructureId);

	boolean deleteEmployeePayStructure(int employeePayStructureId,
			Map<String, Object> generalMap);

	// ----------------------Employee Pay Elements-------------------------
	Map<String, Object> showEmployeePayElementsJsp();

	Map<String, Object> searchEmployeePayElement(Integer employeeId);

	HrEmployeePayElements getEmployeePayElement(Integer commonId);

	Map<String, Object> addEmployeePayElement(
			HrEmployeePayElements employeePayElement);

	boolean deleteEmployeePayElement(int employeePayElementId,
			Map<String, Object> generalMap);

	// -----------------------Employee Personel Details---------------------
	void addEmployeePersonelDetails(
			HrEmployeePersonelDetails employeePersonelDetails);

	// employee performance review
	Map showEmployeePerformanceReviewJsp(Map parameterMap);

	void addOrUpdateEmployeePerformanceReview(
			HrEmployeePerformanceReview performanceReview);

	Map<String, Object> searchEmployeePerformanceReview(Map parameterMap);

	HrEmployeePerformanceReview getEmployeePerformanceReview(Integer commonId);

	boolean deleteEmployeePerformanceReview(int employeePerformanceReview,
			Map<String, Object> generalMap);

	public void addOrUpdateExitInterviewAnswers(
			List<HrExitInterviewAnswers> exitInterviewAnswersList);

	// Employee Exit Interview
	Map showEmployeeExitInterviewJsp(Map parameterMap);

	void addOrUpdateEmployeeExitInterview(HrEmployeeExitInterview exitInterview);

	List<MasEmployee> getSubordinatesList(Integer employeeId);

	// UserManager
	void addUserManager(UserManager userManager);

	// -------------------------------HrMasLocation------------------------------------
	@SuppressWarnings("unchecked")
	Map searchLocation(String locationCode, String locationName);

	Map<String, Object> showLocationJsp();

	boolean addLocation(MasLocation masLocation);

	boolean deleteLocation(int locationId, Map<String, Object> generalMap);

	boolean editLocationToDatabase(Map<String, Object> generalMap);

	Map<String, Object> addEmployeeCategory(MasEmpCategory masEmpCategory);

	Map<String, Object> showEmployeeCategory();

	Map<String, Object> editEmployeeCategory(Map<String, Object> generalMap);

	Map<String, Object> deleteEmployeeCategory(Map<String, Object> generalMap);

	Map<String, Object> searchEmpCategory(String empCategoryCode,
			String empCategoryName);

	Map<String, Object> showAddEmployeePayElementJsp();

	Map<String, Object> addMultipleEmployeePayElement(Map<String, Object> generalMap);
	
	Map<String, Object> generateReportForEmployeeInformationExcel(Map<String, Object> mapForDs);

	void refreshObject(Object o);

	boolean addEmployee(MasEmployee masEmployee);

	Map<String, Object> showWingJsp();

	boolean addWing(MasWing masWing);

	boolean editWing(Map<String, Object> generalMap);

	boolean deleteWing(int wingId, Map<String, Object> generalMap);

	Map<String, Object> wingSearch(String wingCode, String wingName);


	Map<String, Object> showEmployeeApprovedJsp(int hospitalId);

	boolean submitApproveEmployee(Map<String, Object> map);

	Map<String, Object> showShiftParameterMasterJsp(Map parameterMap);

	MasEmployeeTemp getEmployeeTemp(int employeeId);

	boolean addEmployeeTemp(Map map1);

	List<HrMasLeaveTypeMediator> getMasLeaveTypeMediatorList();

	void addEmployeeBalanceDetails(HrEmployeeBalanceNew hrEmployeeBalanceNew);

	Map<String, Object> getEmployeeCode(Map<String, Object> dataMap);

	Map<String, Object> getListForEmpAddress();

	public void addEmployeeAddress(Map addressMap);

	Map<String, Object> getEducationAndExperForEdit(int empId);

	boolean removeOldExper(MasEmployee masEmployee);

	boolean removeOldEdu(MasEmployee masEmployee);

	boolean removeEmployee(int employeeId, Map<String, Object> generalMap);

	boolean deleteEmpAddress(int employeeId);

	Map<String, Object> getMasInstituteDepartment(Map<String, Object> map);

	Map<String, Object> getMasInstituteEmployeeDepartment(Map<String, Object> map);

	Map<String, Object> showRemovedEmployeeInstitutionMappingJsp(Box box);

	Map<String, Object> showRemovedEmployeeDetail(Box box);

	Map<String, Object> assignInstituteForRemovedEmployee(Box box);

	Map<String, Object> searchRemovedEmployeeInstitutionMappingJsp(Box box);

	Map<String, Object> fillInstHospital(int districtId, int instType);

	Map<String, Object> showTabletDetails(String hospitalName,int districtId);
	
	Map<String, Object> hrInstituteWiseDeptList(int hospitalId);

}
