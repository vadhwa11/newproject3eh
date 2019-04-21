package jkt.hms.masters.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasApkVersion;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDepartmentType;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasInstituteDepartment;
import jkt.hms.masters.business.MasTransactionType;
import jkt.hms.util.Box;
import jkt.hrms.masters.business.HrMasLeave;

public interface SystemRelatedMasterHandlerService {
	// ---------------------------------------------- Department Type
	// ----------------------------------

	boolean addDepartmentType(MasDepartmentType departmentTypeMaster);

	Map<String, Object> searchDepartmentType(String departmentTypeCode,
			String departmentTypeName);

	Map<String, Object> showDepartmentTypeJsp();

	boolean editDepartmentTypeToDatabase(Map<String, Object> generalMap);

	boolean deleteDepartmentType(int departmentTypeId,
			Map<String, Object> generalMap);

	// ---------------------------------------------- Transaction Type
	// --------------------------------------

	boolean addTransactionType(MasTransactionType transactionTypeMaster);

	Map<String, Object> searchTransactionType(String transactionTypeCode,
			String transactionTypeName);

	Map<String, Object> showTransactionTypeJsp();

	boolean editTransactionTypeToDatabase(Map<String, Object> generalMap);

	boolean deleteTransactionType(int transactionTypeId,
			Map<String, Object> generalMap);

	// ----------------------------------------- Frequency
	// ---------------------------------------------

	boolean addFrequency(MasFrequency frequencyMaster);

	Map<String, Object> showFrequencyJsp();

	Map<String, Object> searchFrequency(String frequencyCode,
			String frequencyName);

	boolean editFrequencyToDatabase(Map<String, Object> generalMap);

	boolean deleteFrequency(int frequencyId, Map<String, Object> generalMap);

	// ---------------------------------Department Master----------------

	Map<String, Object> showDepartmentJsp();

	Map<String, Object> searchDepartment(String departmentCode,
			String departmentName);

	boolean addDepartment(MasDepartment masDepartment);

	boolean editDepartmentToDatabase(Map<String, Object> generalMap);

	boolean deleteDepartment(int departmentId, Map<String, Object> generalMap);

	// --------------Leave Master-----------------------------------
	Map<String, Object> showLeaveJsp();

	Map<String, Object> addLeave(HrMasLeave hrMasLeave);

	Map<String, Object> editLeave(Map<String, Object> generalMap);

	Map<String, Object> deleteLeave(Map<String, Object> generalMap);

	Map<String, Object> searchLeave(String desription);


	Map<String, Object> showDeptMapJsp(Integer id);

	List<MasInstituteDepartment> getInstituteDeptMap(Map parameterMap);

	boolean saveDeptMapDB(MasInstituteDepartment o);

	List<MasDepartment> getDeptMapFromDB(List duplicateToBeAssignedList);

	Map<String, Object> fillInst(String val);

	Map<String, Object> showInstituteWiseServiceCentersDetailsJsp(Box box);

	Map<String, Object> submitInstituteWiseCenterDetails(Box box);

	Map<String, Object> searchInstituteWiseCenterDetails(Box box);

	boolean deleteVersion(int versionId, Map<String, Object> generalMap);

	Map<String, Object> showVersion();

	Map<String, Object> searchVersion(String versionCode, String versionName);

	boolean editVersion(Map<String, Object> generalMap);

	boolean addVersion(MasApkVersion masVersion);

	Map<String, Object> fillInstHospital(int districtId, int instType);

	Map<String, Object> showDepartInstiHierarchy(Map<String, Object> datamap);

	

}
