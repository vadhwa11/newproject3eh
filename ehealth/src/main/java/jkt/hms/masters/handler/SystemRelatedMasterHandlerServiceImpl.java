package jkt.hms.masters.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasApkVersion;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDepartmentType;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasInstituteDepartment;
import jkt.hms.masters.business.MasTransactionType;
import jkt.hms.masters.dataservice.SystemRelatedMasterDataService;
import jkt.hms.util.Box;
import jkt.hrms.masters.business.HrMasLeave;

public class SystemRelatedMasterHandlerServiceImpl implements
		SystemRelatedMasterHandlerService {
	SystemRelatedMasterDataService systemRelatedMasterDataService = null;

	// ---------------------------------- Department Type
	// ------------------------------------

	public boolean addDepartmentType(MasDepartmentType masDepartmentType) {
		return systemRelatedMasterDataService
				.addDepartmentType(masDepartmentType);
	}

	public Map<String, Object> showDepartmentTypeJsp() {
		return systemRelatedMasterDataService.showDepartmentTypeJsp();
	}

	public Map<String, Object> searchDepartmentType(String departmentTypeCode,
			String departmentTypeName) {
		return systemRelatedMasterDataService.searchDepartmentType(
				departmentTypeCode, departmentTypeName);
	}

	public boolean editDepartmentTypeToDatabase(Map<String, Object> generalMap) {
		return systemRelatedMasterDataService
				.editDepartmentTypeToDatabase(generalMap);
	}

	public boolean deleteDepartmentType(int departmentTypeId,
			Map<String, Object> generalMap) {
		return systemRelatedMasterDataService.deleteDepartmentType(
				departmentTypeId, generalMap);
	}

	// -----------------------------------------------Transaction Type
	// -----------------------------

	public boolean addTransactionType(MasTransactionType masTransactionType) {
		return systemRelatedMasterDataService
				.addTransactionType(masTransactionType);
	}

	public Map<String, Object> searchTransactionType(
			String transactionTypeCode, String transactionTypeName) {
		return systemRelatedMasterDataService.searchTransactionType(
				transactionTypeCode, transactionTypeName);
	}

	public Map<String, Object> showTransactionTypeJsp() {
		return systemRelatedMasterDataService.showTransactionTypeJsp();
	}

	public boolean editTransactionTypeToDatabase(Map<String, Object> generalMap) {
		return systemRelatedMasterDataService
				.editTransactionTypeToDatabase(generalMap);
	}

	public boolean deleteTransactionType(int transactionTypeId,
			Map<String, Object> generalMap) {
		return systemRelatedMasterDataService.deleteTransactionType(
				transactionTypeId, generalMap);
	}

	// --------------------------------------------Frequency--------------------------------------

	public boolean addFrequency(MasFrequency masFrequency) {
		return systemRelatedMasterDataService.addFrequency(masFrequency);
	}

	public boolean deleteFrequency(int frequencyId,
			Map<String, Object> generalMap) {
		return systemRelatedMasterDataService.deleteFrequency(frequencyId,
				generalMap);
	}

	public boolean editFrequencyToDatabase(Map<String, Object> generalMap) {
		return systemRelatedMasterDataService
				.editFrequencyToDatabase(generalMap);
	}

	public Map<String, Object> searchFrequency(String frequencyCode,
			String frequencyName) {
		return systemRelatedMasterDataService.searchFrequency(frequencyCode,
				frequencyName);
	}

	public Map<String, Object> showFrequencyJsp() {
		return systemRelatedMasterDataService.showFrequencyJsp();
	}

	// ---------------------------------Department
	// Master----------------------------------------------

	public boolean addDepartment(MasDepartment masDepartment) {
		return systemRelatedMasterDataService.addDepartment(masDepartment);
	}

	public boolean deleteDepartment(int departmentId,
			Map<String, Object> generalMap) {
		return systemRelatedMasterDataService.deleteDepartment(departmentId,
				generalMap);
	}

	public boolean editDepartmentToDatabase(Map<String, Object> generalMap) {
		return systemRelatedMasterDataService
				.editDepartmentToDatabase(generalMap);
	}

	public Map<String, Object> searchDepartment(String departmentCode,
			String departmentName) {
		return systemRelatedMasterDataService.searchDepartment(departmentCode,
				departmentName);
	}

	public Map<String, Object> showDepartmentJsp() {
		return systemRelatedMasterDataService.showDepartmentJsp();
	}

	// ---------------------Leave Master-----------------------------
	public Map<String, Object> showLeaveJsp() {
		return systemRelatedMasterDataService.showLeaveJsp();
	}

	public Map<String, Object> addLeave(HrMasLeave hrMasLeave) {
		return systemRelatedMasterDataService.addLeave(hrMasLeave);
	}

	public Map<String, Object> editLeave(Map<String, Object> generalMap) {
		return systemRelatedMasterDataService.editLeave(generalMap);
	}

	public Map<String, Object> searchLeave(String desription) {
		return systemRelatedMasterDataService.searchLeave(desription);
	}

	public Map<String, Object> deleteLeave(Map<String, Object> generalMap) {
		return systemRelatedMasterDataService.deleteLeave(generalMap);
	}

	// ------------------------------------------------------------

	public SystemRelatedMasterDataService getSystemRelatedMasterDataService() {
		return systemRelatedMasterDataService;
	}

	public void setSystemRelatedMasterDataService(
			SystemRelatedMasterDataService systemRelatedMasterDataService) {
		this.systemRelatedMasterDataService = systemRelatedMasterDataService;
	}

	@Override
	public Map<String, Object> showDeptMapJsp(Integer id) {
		return systemRelatedMasterDataService.showDeptMapJsp(id);
	}

	@Override
	public List<MasInstituteDepartment> getInstituteDeptMap(Map parameterMap) {
		return systemRelatedMasterDataService.getInstituteDeptMap(parameterMap);
	}

	@Override
	public boolean saveDeptMapDB(MasInstituteDepartment o) {
		 return systemRelatedMasterDataService.saveDeptMapDB(o);
		
	}

	@Override
	public List<MasDepartment> getDeptMapFromDB(List duplicateToBeAssignedList) {
		return systemRelatedMasterDataService.getDeptMapFromDB(duplicateToBeAssignedList);
	}

	@Override
	public Map<String, Object> fillInst(String val) {
		return systemRelatedMasterDataService.fillInst(val);
	}

	@Override
	public Map<String, Object> showInstituteWiseServiceCentersDetailsJsp(Box box) {
		
		return systemRelatedMasterDataService.showInstituteWiseServiceCentersDetailsJsp(box);	}

	@Override
	public Map<String, Object> submitInstituteWiseCenterDetails(Box box) {
		
		return systemRelatedMasterDataService.submitInstituteWiseCenterDetails(box);
	}

	@Override
	public Map<String, Object> searchInstituteWiseCenterDetails(Box box) {
		
		return systemRelatedMasterDataService.searchInstituteWiseCenterDetails(box);
	}

	@Override
	public boolean deleteVersion(int versionId, Map<String, Object> generalMap) {
		return systemRelatedMasterDataService.deleteVersion(versionId, generalMap);
	}

	@Override
	public Map<String, Object> showVersion() {
		return systemRelatedMasterDataService.showVersion();
	}

	@Override
	public Map<String, Object> searchVersion(String versionCode,
			String versionName) {
		return systemRelatedMasterDataService.searchVersion(versionCode, versionName);
	}

	@Override
	public boolean editVersion(Map<String, Object> generalMap) {
		return systemRelatedMasterDataService.editVersion(generalMap);
	}

	@Override
	public boolean addVersion(MasApkVersion masVersion) {
		return systemRelatedMasterDataService.addVersion(masVersion);
	}

	@Override
	public Map<String, Object> fillInstHospital(int districtId, int instType) {
		return systemRelatedMasterDataService.fillInstHospital(districtId,instType);
	}

	@Override
	public Map<String, Object> showDepartInstiHierarchy(
			Map<String, Object> datamap) {
		return systemRelatedMasterDataService.showDepartInstiHierarchy(datamap);
	}

}
