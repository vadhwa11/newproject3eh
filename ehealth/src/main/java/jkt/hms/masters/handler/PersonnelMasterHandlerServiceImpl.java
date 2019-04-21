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
import jkt.hms.masters.dataservice.PersonnelMasterDataService;
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

public class PersonnelMasterHandlerServiceImpl implements
		PersonnelMasterHandlerService {
	PersonnelMasterDataService personnelMasterDataService = null;

	// ------------------------------ Emp Status-----------------

	public boolean addEmpStatus(MasEmpStatus masEmpStatus) {
		return personnelMasterDataService.addEmpStatus(masEmpStatus);
	}

	public boolean deleteEmpStatus(int empStatusId,
			Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteEmpStatus(empStatusId,
				generalMap);
	}

	public boolean editEmpStatusToDatabase(Map<String, Object> generalMap) {
		return personnelMasterDataService.editEmpStatusToDatabase(generalMap);
	}

	public Map<String, Object> searchEmpStatus(String empStatusCode,
			String empStatusName) {
		return personnelMasterDataService.searchEmpStatus(empStatusCode,
				empStatusName);
	}

	public Map<String, Object> showEmpStatusJsp() {
		return personnelMasterDataService.showEmpStatusJsp();
	}

	// ------------------------------ Employee Dependent-----------------------

	public Map<String, Object> showEmployeeDependentJsp() {
		return personnelMasterDataService.showEmployeeDependentJsp();
	}

	public boolean addEmployeeDependent(
			MasEmployeeDependent masEmployeeDependent) {
		return personnelMasterDataService
				.addEmployeeDependent(masEmployeeDependent);
	}

	public boolean deleteEmployeeDependent(int employeeDependentId,
			Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteEmployeeDependent(
				employeeDependentId, generalMap);
	}

	public boolean editEmployeeDependent(Map<String, Object> generalMap) {
		return personnelMasterDataService.editEmployeeDependent(generalMap);
	}

	public Map<String, Object> searchEmployeeDependent(
			String employeeDependentCode, String employeeDependentName) {
		return personnelMasterDataService.searchEmployeeDependent(
				employeeDependentCode, employeeDependentName);
	}

	// --------------------------------ReferralDoctor---------------------------------------
	public boolean addReferralDoctor(MasReferralDoctor masReferralDoctor) {
		return personnelMasterDataService.addReferralDoctor(masReferralDoctor);
	}

	public boolean deleteReferralDoctor(int referralDoctorId,
			Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteReferralDoctor(
				referralDoctorId, generalMap);
	}

	public boolean editReferralDoctorToDatabase(Map<String, Object> generalMap) {
		return personnelMasterDataService
				.editReferralDoctorToDatabase(generalMap);
	}

	public Map<String, Object> searchReferralDoctor(String referralDoctorName) {
		return personnelMasterDataService
				.searchReferralDoctor(referralDoctorName);
	}

	public Map<String, Object> showReferralDoctorJsp() {
		return personnelMasterDataService.showReferralDoctorJsp();
	}

	// -------------------------------- Rank
	// --------------------------------------
	public boolean addRank(MasRank masRank) {
		return personnelMasterDataService.addRank(masRank);
	}

	public boolean deleteRank(int rankId, Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteRank(rankId, generalMap);
	}

	public boolean editRankToDatabase(Map<String, Object> generalMap) {
		return personnelMasterDataService.editRankToDatabase(generalMap);
	}

	public Map<String, Object> searchRank(String rankCode, String rankName) {
		return personnelMasterDataService.searchRank(rankCode, rankName);
	}

	public Map<String, Object> showRankJsp() {
		return personnelMasterDataService.showRankJsp();
	}

	// ---------------------------------Formation---------------------------------------

	public boolean addFormation(MasFormation masFormation) {
		return personnelMasterDataService.addFormation(masFormation);
	}

	public boolean deleteFormation(int formationId,
			Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteFormation(formationId,
				generalMap);
	}

	public boolean editFormationToDatabase(Map<String, Object> generalMap) {
		return personnelMasterDataService.editFormationToDatabase(generalMap);
	}

	public Map<String, Object> searchFormation(String formationCode,
			String formationName) {
		return personnelMasterDataService.searchFormation(formationCode,
				formationName);
	}

	public Map<String, Object> showFormationJsp() {
		return personnelMasterDataService.showFormationJsp();
	}

	// ---------------------------------Employee ---------------------------

	public Map<String, Object> addEmployee(MasEmployee masEmployee,int hospitalId) {
		return personnelMasterDataService.addEmployee(masEmployee,hospitalId);
	}

	public boolean deleteEmployee(int employeeId, Map<String, Object> generalMap) {
		return personnelMasterDataService
				.deleteEmployee(employeeId, generalMap);
	}

	public boolean editEmployeeToDatabase(Map<String, Object> generalMap) {
		return personnelMasterDataService.editEmployeeToDatabase(generalMap);
	}

	public Map<String, Object> showEmployeeJsp(Map<String, Object> dataMap) {
		return personnelMasterDataService.showEmployeeJsp(dataMap);
	}

	public Map<String, Object> searchEmployee(String employeeCode,
			String firstName, String lastName,int hospitalId) {
		return personnelMasterDataService.searchEmployee(employeeCode,
				firstName, lastName,hospitalId);
	}

	public MasHospital getCompany(Integer hospitalId) {
		return personnelMasterDataService.getCompany(hospitalId);
	}

	public MasEmployee getLastAddedEmployee() {
		return personnelMasterDataService.getLastAddedEmployee();
	}

	public MasEmployeeType getEmployeeType(Integer employeeTypeId) {
		return personnelMasterDataService.getEmployeeType(employeeTypeId);
	}

	public MasEmployee getEmployee(Integer employeeId) {
		return personnelMasterDataService.getEmployee(employeeId);
	}

	// ---------------------------------------Trade--------------------------
	public boolean addTrade(MasTrade masTrade) {
		return personnelMasterDataService.addTrade(masTrade);
	}

	public boolean deleteTrade(int tradeId, Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteTrade(tradeId, generalMap);
	}

	public boolean editTradeToDatabase(Map<String, Object> generalMap) {
		return personnelMasterDataService.editTradeToDatabase(generalMap);
	}

	public Map<String, Object> searchTrade(String tradeName) {
		return personnelMasterDataService.searchTrade(tradeName);
	}

	public Map<String, Object> showTradeJsp() {
		return personnelMasterDataService.showTradeJsp();
	}

	// -----------------------------------------Unit-----------------------------------
	public boolean addUnit(MasUnit masUnit) {
		return personnelMasterDataService.addUnit(masUnit);
	}

	public boolean deleteUnit(int unitId, Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteUnit(unitId, generalMap);
	}

	public boolean editUnitToDatabase(Map<String, Object> generalMap) {
		return personnelMasterDataService.editUnitToDatabase(generalMap);
	}

	public Map<String, Object> searchUnit(String unitName) {
		return personnelMasterDataService.searchUnit(unitName);
	}

	public Map<String, Object> showUnitJsp() {
		return personnelMasterDataService.showUnitJsp();
	}

	// ------------------------------------------Record Office Address
	// -------------------------------
	public boolean addRecordOfficeAddress(
			MasRecordOfficeAddress masRecordOfficeAddress) {
		return personnelMasterDataService
				.addRecordOfficeAddress(masRecordOfficeAddress);
	}

	public boolean editRecordOfficeAddress(Map<String, Object> generalMap) {
		return personnelMasterDataService.editRecordOfficeAddress(generalMap);
	}

	public boolean deleteRecordOfficeAddress(int recordOfficeAddressId,
			Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteRecordOfficeAddress(
				recordOfficeAddressId, generalMap);
	}

	public Map<String, Object> searchRecordOfficeAddress(
			String recordOfficeAddress) {
		return personnelMasterDataService
				.searchRecordOfficeAddress(recordOfficeAddress);
	}

	public Map<String, Object> showRecordOfficeAddressJsp() {
		return personnelMasterDataService.showRecordOfficeAddressJsp();
	}

	// -----------------------------Rank
	// Category----------------------------------------
	public boolean addRankCategory(MasRankCategory masRankCategory) {
		return personnelMasterDataService.addRankCategory(masRankCategory);
	}

	public boolean deleteRankCategory(int rankCategoryId,
			Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteRankCategory(rankCategoryId,
				generalMap);
	}

	public boolean editRankCategoryToDatabase(Map<String, Object> generalMap) {
		return personnelMasterDataService
				.editRankCategoryToDatabase(generalMap);
	}

	public Map<String, Object> searchRankCategory(String rankCategoryCode,
			String rankCategoryName) {
		return personnelMasterDataService.searchRankCategory(rankCategoryCode,
				rankCategoryName);
	}

	public Map<String, Object> showRankCategoryJsp() {
		return personnelMasterDataService.showRankCategoryJsp();
	}

	// -----------------------------Brand
	// Master-------------------------------------

	public boolean addBrand(MasStoreBrand masBrand) {
		return personnelMasterDataService.addBrand(masBrand);
	}

	public boolean deleteBrand(int brandId, Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteBrand(brandId, generalMap);
	}

	public boolean editBrandToDatabase(Map<String, Object> generalMap) {
		return personnelMasterDataService.editBrandToDatabase(generalMap);
	}

	public Map<String, Object> searchBrand(String brandCode, String brandName) {
		return personnelMasterDataService.searchBrand(brandCode, brandName);
	}

	public Map<String, Object> showBrandJsp() {
		return personnelMasterDataService.showBrandJsp();
	}

	public Map<String, Object> getConnection() {
		return personnelMasterDataService.getConnection();
	}

	// ---------------------------------------------------------------------------------------
	public PersonnelMasterDataService getPersonnelMasterDataService() {
		return personnelMasterDataService;
	}

	public void setPersonnelMasterDataService(
			PersonnelMasterDataService personnelMasterDataService) {
		this.personnelMasterDataService = personnelMasterDataService;
	}

	public int getItemId(String pvms) {
		return personnelMasterDataService.getItemId(pvms);
	}

	// -----------------------Employee Contract--------------------------
	public Map<String, Object> searchEmployeeContract(Integer employeeId) {
		return personnelMasterDataService.searchEmployeeContract(employeeId);
	}

	public Map<String, Object> showEmployeeContractJsp() {
		return personnelMasterDataService.showEmployeeContractJsp();
	}

	public Boolean addEmployeeContract(MasEmployeeContract employeeContract) {
		return personnelMasterDataService.addEmployeeContract(employeeContract);
	}

	public MasEmployeeContract getEmployeeContract(Integer empContractId) {
		return personnelMasterDataService.getEmployeeContract(empContractId);
	}

	public boolean deleteEmployeeContract(int employeeContractId,
			Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteEmployeeContract(
				employeeContractId, generalMap);
	}

	// --------------------------Employee Education----------------------
	public void addEmployeeEducation(HrMasEmployeeEducation employeeEducation) {
		personnelMasterDataService.addEmployeeEducation(employeeEducation);
	}

	// --------------------------Employee Education----------------------
	public void addEmployeeExperience(HrEmployeeExperience employeeExperience) {
		personnelMasterDataService.addEmployeeExperience(employeeExperience);
	}

	// --------------------------Employee Pay Structure-------------------
	public Map<String, Object> showEmployeePayStructureJsp() {
		return personnelMasterDataService.showEmployeePayStructureJsp();
	}

	public Map<String, Object> searchEmployeePayStructure(Integer employeeId) {
		return personnelMasterDataService
				.searchEmployeePayStructure(employeeId);
	}

	public void addEmployeePayStructure(
			HrEmployeePayStructure employeePayStructure) {
		personnelMasterDataService
				.addEmployeePayStructure(employeePayStructure);
	}

	public HrEmployeePayStructure getEmployeePayStructure(Integer payStructureId) {
		return personnelMasterDataService
				.getEmployeePayStructure(payStructureId);

	}

	public boolean deleteEmployeePayStructure(int employeePayStructureId,
			Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteEmployeePayStructure(
				employeePayStructureId, generalMap);
	}

	// --------------------------Employee Pay Elements-------------------
	public Map<String, Object> showEmployeePayElementsJsp() {
		return personnelMasterDataService.showEmployeePayElementsJsp();
	}

	public Map<String, Object> searchEmployeePayElement(Integer employeeId) {
		return personnelMasterDataService.searchEmployeePayElement(employeeId);
	}

	public HrEmployeePayElements getEmployeePayElement(Integer commonId) {
		return personnelMasterDataService.getEmployeePayElement(commonId);
	}

	public Map<String, Object> addEmployeePayElement(
			HrEmployeePayElements employeePayElement) {
		return personnelMasterDataService
				.addEmployeePayElement(employeePayElement);
	}

	public boolean deleteEmployeePayElement(int employeePayElementId,
			Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteEmployeePayElement(
				employeePayElementId, generalMap);
	}

	// -----------------------Employee Personel Details----------------------
	public void addEmployeePersonelDetails(
			HrEmployeePersonelDetails employeePersonelDetails) {
		personnelMasterDataService
				.addEmployeePersonelDetails(employeePersonelDetails);
	}

	// employee performance review

	public Map showEmployeePerformanceReviewJsp(Map parameterMap) {
		return personnelMasterDataService
				.showEmployeePerformanceReviewJsp(parameterMap);
	}

	public void addOrUpdateEmployeePerformanceReview(
			HrEmployeePerformanceReview performanceReview) {
		personnelMasterDataService
				.addOrUpdateEmployeePerformanceReview(performanceReview);
	}

	public Map<String, Object> searchEmployeePerformanceReview(Map parameterMap) {
		return personnelMasterDataService
				.searchEmployeePerformanceReview(parameterMap);
	}

	public HrEmployeePerformanceReview getEmployeePerformanceReview(
			Integer commonId) {
		return personnelMasterDataService
				.getEmployeePerformanceReview(commonId);
	}

	public boolean deleteEmployeePerformanceReview(
			int employeePerformanceReview, Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteEmployeePerformanceReview(
				employeePerformanceReview, generalMap);
	}

	// Employee Exit Interview
	public Map showEmployeeExitInterviewJsp(Map parameterMap) {
		return personnelMasterDataService
				.showEmployeeExitInterviewJsp(parameterMap);
	}

	public void addOrUpdateEmployeeExitInterview(
			HrEmployeeExitInterview exitInterview) {
		personnelMasterDataService
				.addOrUpdateEmployeeExitInterview(exitInterview);
	}

	public void addOrUpdateExitInterviewAnswers(
			List<HrExitInterviewAnswers> exitInterviewAnswersList) {
		personnelMasterDataService
				.addOrUpdateExitInterviewAnswers(exitInterviewAnswersList);
	}

	public void addUserManager(UserManager userManager) {
		personnelMasterDataService.addUserManager(userManager);
	}

	public List<MasEmployee> getSubordinatesList(Integer employeeId) {
		return personnelMasterDataService.getSubordinatesList(employeeId);
	}

	public boolean addLocation(MasLocation masLocation) {
		return personnelMasterDataService.addLocation(masLocation);
	}

	public boolean deleteLocation(int locationId, Map<String, Object> generalMap) {
		return personnelMasterDataService
				.deleteLocation(locationId, generalMap);
	}

	public boolean editLocationToDatabase(Map<String, Object> generalMap) {
		return personnelMasterDataService.editLocationToDatabase(generalMap);
	}

	public Map searchLocation(String locationCode, String locationName) {
		return personnelMasterDataService.searchLocation(locationCode,
				locationName);
	}

	public Map<String, Object> showLocationJsp() {
		return personnelMasterDataService.showLocationJsp();
	}

	public Map<String, Object> addEmployeeCategory(MasEmpCategory masEmpCategory) {

		return personnelMasterDataService.addEmployeeCategory(masEmpCategory);
	}

	public Map<String, Object> showEmployeeCategory() {

		return personnelMasterDataService.showEmployeeCategory();
	}

	public Map<String, Object> editEmployeeCategory(
			Map<String, Object> generalMap) {

		return personnelMasterDataService.editEmployeeCategory(generalMap);
	}

	public Map<String, Object> deleteEmployeeCategory(
			Map<String, Object> generalMap) {

		return personnelMasterDataService.deleteEmployeeCategory(generalMap);
	}

	public Map<String, Object> searchEmpCategory(String empCategoryCode,
			String empCategoryName) {

		return personnelMasterDataService.searchEmpCategory(empCategoryCode,
				empCategoryName);
	}

	public Map<String, Object> showAddEmployeePayElementJsp() {
		
		return personnelMasterDataService.showAddEmployeePayElementJsp();
	}

	public Map<String, Object> addMultipleEmployeePayElement(Map<String, Object> generalMap) {
		
		return personnelMasterDataService.addMultipleEmployeePayElement(generalMap);
	}
	
	public Map<String, Object> generateReportForEmployeeInformationExcel(Map<String, Object> mapForDs) {
		return personnelMasterDataService.generateReportForEmployeeInformationExcel(mapForDs);
	}

	@Override
	public void refreshObject(Object o) {
		// TODO Auto-generated method stub
		 personnelMasterDataService.refreshObject(o);
		
		
	}

	@Override
	public boolean addEmployee(MasEmployee masEmployee) {
		// TODO Auto-generated method stub
		return  personnelMasterDataService.addEmployee(masEmployee);
	}

	@Override
	public Map<String, Object> showWingJsp() {
		// TODO Auto-generated method stub
		return personnelMasterDataService.showWingJsp();
	}

	@Override
	public boolean addWing(MasWing masWing) {
		return personnelMasterDataService.addWing(masWing);
	}

	@Override
	public boolean editWing(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return personnelMasterDataService.editWing(generalMap);
	}

	@Override
	public boolean deleteWing(int wingId, Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteWing(wingId,generalMap);
	}

	@Override
	public Map<String, Object> wingSearch(String wingCode, String wingName) {
		return personnelMasterDataService.wingSearch(wingCode,wingName);
	}
	
	@Override
	public Map<String, Object> showEmployeeApprovedJsp(int hospitalId) {
		return  personnelMasterDataService.showEmployeeApprovedJsp(hospitalId);
	}

	@Override
	public boolean submitApproveEmployee(Map<String, Object> map) {
		return  personnelMasterDataService.submitApproveEmployee(map);
	}

	@Override
	public Map<String, Object> showShiftParameterMasterJsp(Map parameterMap) {
		return  personnelMasterDataService.showShiftParameterMasterJsp(parameterMap);
	}

	@Override
	public MasEmployeeTemp getEmployeeTemp(int employeeId) {
		// TODO Auto-generated method stub
		return  personnelMasterDataService.getEmployeeTemp(employeeId) ;
	}

	@Override
	public boolean addEmployeeTemp(Map map1) {
		// TODO Auto-generated method stub
		return personnelMasterDataService.addEmployeeTemp(map1) ;
	}

	@Override
	public List<HrMasLeaveTypeMediator> getMasLeaveTypeMediatorList() {
		// TODO Auto-generated method stub
		return personnelMasterDataService.getMasLeaveTypeMediatorList() ;
	}

	@Override
	public void addEmployeeBalanceDetails(
			HrEmployeeBalanceNew hrEmployeeBalanceNew) {
		// TODO Auto-generated method stub
		 personnelMasterDataService.addEmployeeBalanceDetails(hrEmployeeBalanceNew) ;
		
	}

	@Override
	public Map<String, Object> getEmployeeCode(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return personnelMasterDataService.getEmployeeCode(dataMap) ;
	}

	@Override
	public Map<String, Object> getListForEmpAddress() {
		return personnelMasterDataService.getListForEmpAddress() ;
	}

	@Override
	public void addEmployeeAddress(Map addressMap) {
		personnelMasterDataService.addEmployeeAddress(addressMap) ;
		
	}

	@Override
	public Map<String, Object> getEducationAndExperForEdit(int empId) {
		return personnelMasterDataService.getEducationAndExperForEdit(empId) ;
	}

	@Override
	public boolean removeOldExper(MasEmployee masEmployee) {
		return personnelMasterDataService.removeOldExper(masEmployee) ;
	}

	@Override
	public boolean removeOldEdu(MasEmployee masEmployee) {
		return personnelMasterDataService.removeOldEdu(masEmployee) ;
	}

	@Override
	public boolean removeEmployee(int employeeId, Map<String, Object> generalMap) {
		return personnelMasterDataService.removeEmployee(employeeId,generalMap) ;
	}

	@Override
	public boolean deleteEmpAddress(int employeeId) {
		return personnelMasterDataService.deleteEmpAddress(employeeId) ;
	}
	
	@Override
	public Map<String, Object> getMasInstituteDepartment(Map<String, Object> map) {
		return personnelMasterDataService.getMasInstituteDepartment(map) ;
	}

	@Override
	public Map<String, Object> getMasInstituteEmployeeDepartment(
			Map<String, Object> map) {
		return personnelMasterDataService.getMasInstituteEmployeeDepartment(map);
	}

	@Override
	public Map<String, Object> showRemovedEmployeeInstitutionMappingJsp(Box box) {
		
		return personnelMasterDataService.showRemovedEmployeeInstitutionMappingJsp(box);
	}

	@Override
	public Map<String, Object> showRemovedEmployeeDetail(Box box) {
		
		return personnelMasterDataService.showRemovedEmployeeDetail(box);
	}

	@Override
	public Map<String, Object> assignInstituteForRemovedEmployee(Box box) {
		// TODO Auto-generated method stub
		return personnelMasterDataService.assignInstituteForRemovedEmployee(box);
	}

	@Override
	public Map<String, Object> searchRemovedEmployeeInstitutionMappingJsp(
			Box box) {
		// TODO Auto-generated method stub
		return personnelMasterDataService.searchRemovedEmployeeInstitutionMappingJsp(box);
	}

	@Override
	public Map<String, Object> fillInstHospital(int districtId, int instType) {
		return personnelMasterDataService.fillInstHospital(districtId,instType);
	}
	
	@Override
	public Map<String, Object> showTabletDetails(String hospitalName,int districtId) {
		return personnelMasterDataService.showTabletDetails(hospitalName, districtId);
	}

	@Override
	public Map<String, Object> hrInstituteWiseDeptList(int hospitalId) {
		return personnelMasterDataService.hrInstituteWiseDeptList(hospitalId);
	}
}
