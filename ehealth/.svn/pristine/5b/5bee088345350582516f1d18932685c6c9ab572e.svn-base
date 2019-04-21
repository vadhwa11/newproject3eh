package jkt.hms.masters.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.HmsNoticeBoard;
import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasCaseType;
import jkt.hms.masters.business.MasComplaint;
import jkt.hms.masters.business.MasComplication;
import jkt.hms.masters.business.MasCostCenter;
import jkt.hms.masters.business.MasDeathCause;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasHospitalType;
import jkt.hms.masters.business.MasIcd;
import jkt.hms.masters.business.MasIcdMainCategory;
import jkt.hms.masters.business.MasIcdSubCategory;
import jkt.hms.masters.business.MasIcdcausegrp;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasMajorCategoryCode;
import jkt.hms.masters.business.MasPatientStatus;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasRoom;
import jkt.hms.masters.business.MasRoomType;
import jkt.hms.masters.business.MasServiceCentreCounter;
import jkt.hms.masters.business.MasServiceStatus;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasSession;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.PrinterCofiguration;
import jkt.hms.util.Box;

public interface HospitalDetailsMasterHandlerService {

	// ---------------Case type-------------------

	boolean addCaseType(MasCaseType masCaseType);

	boolean editCaseTypeToDatabase(Map<String, Object> generalMap);

	boolean deleteCaseType(int caseTypeId, Map<String, Object> generalMap);

	Map<String, Object> searchCaseType(String caseTypeCode, String caseTypeName);

	Map<String, Object> showCaseTypeJsp();

	// ---------------------------Main Charge Code
	// ------------------------------

	boolean addMainChargecode(MasMainChargecode masMainChargecode);
	
	boolean addprinterDetails(PrinterCofiguration printerCofiguration);
	
	boolean checkprinterDetails(Map<String, Object> generalMap);

	boolean editMainChargecodeToDatabase(Map<String, Object> generalMap);
	


	boolean deleteMainChargecode(int mainChargecodeId,
			Map<String, Object> generalMap);

	Map<String, Object> searchMainChargecode(String mainChargecodeCode,
			String mainChargecodeName);

	Map<String, Object> showMainChargecodeJsp();

	// -------------------------Cost Center
	// ----------------------------------------

	Map<String, Object> showCostCenterJsp();

	Map<String, Object> searchCostCenter(String costCenterCode,
			String costCenterName);

	boolean addCostCenter(MasCostCenter masCostCenter);

	boolean editCostCenterToDatabase(Map<String, Object> generalMap);

	boolean deleteCostCenter(int costCenterId, Map<String, Object> generalMap);

	// --------------------------Major Category
	// Code-------------------------------

	Map<String, Object> showMajorCategoryCodeJsp();

	Map<String, Object> searchMajorCategoryCode(String majorCategoryCodeCode,
			String majorCategoryCodeName);

	boolean addMajorCategoryCode(MasMajorCategoryCode masMajorCategoryCode);

	boolean editMajorCategoryCodeToDatabase(Map<String, Object> generalMap);

	boolean deleteMajorCategoryCode(int majorCategoryCodeId,
			Map<String, Object> generalMap);

	// --------------------------------Death Cause---------------------------

	boolean addDeathCause(MasDeathCause masDeathCause);

	boolean deleteDeathCause(int deathCauseId, Map<String, Object> generalMap);

	boolean editDeathCauseToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchDeathCause(String deathCauseCode,
			String deathCauseName);

	Map<String, Object> showDeathCauseJsp();

	// --------------------------Patient
	// Status------------------------------------------

	boolean addPatientStatus(MasPatientStatus masPatientStatus);

	boolean deletePatientStatus(int patientStatusId,
			Map<String, Object> generalMap);

	boolean editPatientStatusToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchPatientStatus(String patientStatusCode,
			String patientStatusName);

	Map<String, Object> showPatientStatusJsp();

	// ---------------------------------------------BED
	// Master--------------------------------------------
	Map<String, Object> showBedJsp(int hospitalId);

	Map<String, Object> searchBed(String bedNumber,int hospitalId);

	boolean addBed(MasBed masBed);

	boolean editBedToDatabase(Map<String, Object> generalMap);

	boolean deleteBed(int bedId, Map<String, Object> generalMap);

	// ------------------------------------COMPLAINT------------------------------------

	boolean addComplaint(MasComplaint masComplaint);

	Map<String, Object> searchComplaint(String complaintCode,
			String complaintName);

	Map<String, Object> showComplaintJsp();

	boolean editComplaintToDatabase(Map<String, Object> generalMap);

	boolean deleteComplaint(int complaintId, Map<String, Object> generalMap);

	// -----------------------------COMPLICATION------------------------

	boolean addComplication(MasComplication masComplication);

	Map<String, Object> searchComplication(String complicationCode,
			String complicationName);

	Map<String, Object> showComplicationJsp();

	boolean editComplicationToDatabase(Map<String, Object> generalMap);

	boolean deleteComplication(int complicationId,
			Map<String, Object> generalMap);

	// ----------------------------Authorizer------------------------

	boolean addAuthorizer(MasAuthorizer masAuthorizer);

	Map<String, Object> showAuthorizerJsp();

	boolean editAuthorizerToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchAuthorizer(String authorizerCode,
			String authorizerName);

	boolean deleteAuthorizer(int authorizerId, Map<String, Object> generalMap);

	// --------------------------------- Room ----------------------
	List<MasDepartment> getDepartmentList();

	boolean addRoom(MasRoom roomMaster);

	Map<String, Object> showRoomJsp();

	boolean editRoomToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchRoom(String roomCode);

	boolean deleteRoom(int roomId, Map<String, Object> generalMap);

	// --------------------------ICD Sub Category------------------

	Map<String, Object> showIcdSubCategoryJsp();

	boolean addIcdSubCategory(MasIcdSubCategory masIcdSubCategory);

	Map<String, Object> searchIcdSubCategory(String icdSubCategoryCode,
			String icdSubCategoryName);

	boolean editIcdSubCategoryToDatabase(Map<String, Object> generalMap);

	boolean deleteIcdSubCategory(int icdSubCategoryId,
			Map<String, Object> generalMap);

	// ---------------------------------Charge
	// Code---------------------------------

	Map<String, Object> searchChargeCode(Map<String, Object> map);

	Map<String, Object> showChargeCodeJsp(Map<String, Object> map);
	
	Map<String, Object> showPrinterDetails();

	boolean addChargeCode(Map<String, Object> dataMap);

	boolean deleteSubTest(Integer subTestId);

	boolean deleteChargeCode(Integer chargeCodeId);

	boolean checkChargeCodeExsist(String chargeCodeCode, String chargeCodeName);

	boolean checkChargeCodeNameExsistForEditing(int chargeCodeId,
			String chargeCodeName);

	boolean editChargeCode(Map<String, Object> generalMap);
	
	boolean editPrinterDetails(Map<String, Object> generalMap);

	@SuppressWarnings("unchecked")
	// ----------------------------sub charge code----------------------
	Map showSubChargeJsp();

	@SuppressWarnings("unchecked")
	Map searchSubCharge(String subChargecodeCode, String subChargecodeName);

	boolean addSubCharge(MasSubChargecode masSubChargecode);

	boolean editSubChargeToDatabase(Map<String, Object> generalMap);

	boolean deleteSubCharge(Integer subChargecodeId,
			Map<String, Object> generalMap);

	// ----------------------- ICD Main Category---------------------------

	Map<String, Object> searchIcdMainCategory(String icdMainCategoryCode,
			String icdMainCategoryName);

	Map<String, Object> showIcdMainCategoryJsp();

	boolean addIcdMainCategory(MasIcdMainCategory masIcdMainCategory);

	boolean editIcdMainCategoryToDatabase(Map<String, Object> generalMap);

	boolean deleteIcdMainCategory(int icdMainCategoryId,
			Map<String, Object> generalMap);

	// ----------------------- ICD ----------------------------

	Map<String, Object> searchIcd(String icdCode, String icdName);

	Map<String, Object> showIcdJsp();

	boolean addIcd(MasIcd masIcd);

	boolean editIcdToDatabase(Map<String, Object> generalMap);

	boolean deleteIcd(int icdId, Map<String, Object> generalMap);

	// --------------------------------Service
	// Type----------------------------------------
	Map<String, Object> searchServiceType(String serviceTypeCode,
			String serviceTypeName);

	Map<String, Object> showServiceTypeJsp();

	boolean addServiceType(MasServiceType masServiceType);

	boolean editServiceTypeToDatabase(Map<String, Object> generalMap);

	boolean deleteServiceType(int serviceTypeId, Map<String, Object> generalMap);

	// ------------------------------------Service
	// Status--------------------------------

	Map<String, Object> searchServiceStatus(String serviceStatusCode,
			String serviceStatusName);

	Map<String, Object> showServiceStatusJsp();

	boolean addServiceStatus(MasServiceStatus masServiceStatus);

	boolean editServiceStatusToDatabase(Map<String, Object> generalMap);

	boolean deleteServiceStatus(int serviceStatusId,
			Map<String, Object> generalMap);

	Map<String, Object> getConnection();

	// ---------------------- Patient type-------------------------------

	boolean addPatientType(MasPatientType masPatientType);

	Map<String, Object> searchPatientType(String patientTypeCode,
			String patientTypeName);

	Map<String, Object> showPatientTypeJsp();

	boolean editPatientTypeToDatabase(Map<String, Object> generalMap);

	boolean deletePatientType(int patientTypeId, Map<String, Object> generalMap);

	// --------------------------------IcdCausegrp-------------------------------
	Map<String, Object> showIcdCauseJsp();

	boolean addIcdCause(MasIcdcausegrp masIcdcausegrp);

	boolean editIcdCauseToDatabase(Map<String, Object> generalMap);

	boolean deleteIcdCause(int causeId, Map<String, Object> generalMap);

	Map<String, Object> searchIcdCause(String causeCode, String causeName);

	boolean deleteChargeCode1(int chargeCodeId, Map<String, Object> generalMap);

	Map<String, Object> getSetupParameterMap(Map<String, Object> dataMap);

	// -----for Notice Board-------------------------------------
	public boolean addNotice(HmsNoticeBoard hmsNoticeBoard);

	Map<String, Object> showNoticeJsp();

	Map<String, Object> searchNotice(String noticeCode, String noticeName);

	boolean editNoticeToDatabase(Map<String, Object> generalMap);

	public boolean deleteNotice(int noticeId, Map<String, Object> generalMap);

	public Map<String, Object> checkForExistingChargeCode(Map<String, Object> generalMap);

	public Map checkForExistingMastersForHospital(Map<String, Object> generalMap);

	Map<String, Object> checkChargeTypeName(int chargeTypeId);

	Map<String, Object> checkMasChargeCodeName(int chargeCodeId);

	int getChargeTypeId(String chargeTypeName);

	Boolean checkStatusMasCharge(int chargeTypeId);

	Map<String, Object> checkMasChargeCodeType(Integer chargeTypeName);

	Map<String, Object> getHospitalList(Map<String, Object> dataMap);

	Map showHospitalTypeJsp();

	boolean addHospitalType(MasHospitalType masHospitalType);

	boolean editHospitalTypeToDatabase(Map<String, Object> generalMap);

	boolean deleteHospitalType(int hospitalTypeId, Map<String, Object> generalMap);

	Map<String, Object> searchHospitalType(String hospitalTypeCode,	String hospitalTypeName);

	Map<String, Object> showBillInstituteWiseServicesJsp(jkt.hms.util.Box box);	

	Map<String, Object> submitBillInstituteWiseServicesJsp(jkt.hms.util.Box box);
	
	Map showRoomType();

	boolean addRoomType(MasRoomType masRoomType);

	boolean editRoomType(Map<String, Object> generalMap);

	Map<String, Object> searchRoomType(String roomTypeCode, String roomTypeName);

	boolean deleteRoomType(int roomTypeId, Map<String, Object> generalMap);

	Map<String, Object> showHospitalUnitJsp(Box box);

	Map<String, Object> getRankDesignation(Map<String, Object> parameterMap);

	Map<String, Object> submitHospitalUnit(Box box);
	
	
	// ------------------------------------Ot Master
		// ----------------------------------------
		boolean addOt(MasBed masBed);

		boolean deleteOt(int bedId, Map<String, Object> generalMap);

		boolean editOtToDatabase(Map<String, Object> generalMap);

		Map<String, Object> searchOt(String bedNumber);

		Map<String, Object> showOtJsp();

		
		Map<String, Object> getEmpDepartmentSearch(Box box);

		Map<String, Object> showDataFromSearch(Box box);

		Map<String, Object> showLocalChargeCodeJsp(int hospitalId);

		Map<String, Object> searchLocalChargeCode(String chargeCodeCode,
				String chargeCodeName, Integer mas_main_charge_id,
				int hospitalId);

		boolean editLocalChargeCode(Map<String, Object> generalMap);

		boolean deleteLocalChargeCode1(int chargeCodeId,
				Map<String, Object> generalMap);

		boolean addSession(MasSession masSession,String hospitalCode);
		
		Map<String, Object> checkSession(Map<String, Object> dataMap);

		Map<String, Object> showSessionJsp(Box box);

		boolean editSessionToDatabase(Map<String, Object> generalMap);

		boolean deleteSession(int sessionId, Map<String, Object> generalMap);

		Map<String, Object> searchSession(String sessionName,Integer hospitalId);

		Map<String, Object> showLocalChargeCodeBlockUnblockJsp(Box box);

		Map<String, Object> saveForBlockUnBlock(List<Integer> invFinalList1,String status, int hospitalId,String reasonToBlock);

		Map<String, Object> getReasonForBlock(int chargeCodeId, int hospitalId,	int deptId);

		Map showActionTaken();

		boolean addActionTaken(Map<String, Object> actionTakenMap);

		boolean editActionTaken(Map<String, Object> generalMap);

		Map<String, Object> searchActionTaken(String charityTypeCode,
				String charityTypeName);

		boolean deleteActionTaken(int charityTypeId,
				Map<String, Object> generalMap);
		Map addSnomedChargeCode(Map<String, Object> map);

		Map<String, Object> showServiceCentreCounterJsp(int hospitalId);

		Map<String, Object> checkForExistingServiceCentreCounter(Map<String, Object> generalMap);

		Map<String, Object> checkForExistingServiceCentreCounterId(
				Map<String, Object> generalMap);

		boolean editServiceCentreCounter(Map<String, Object> generalMap);

		boolean deleteServiceCentreCounter(int serviceCentreCounterId,
				Map<String, Object> generalMap);

		

		boolean addServiceCentreCounter(MasServiceCentreCounter masServiceCentreCounter);

		Map<String, Object> searchServiceCentreCounter(int departmentId,
				String counterNo, int hospitalId);
		boolean removeDoctorFromUnit(String unit_t_id);
		
		Map<String, Object> getMultiDepartmentMappings(Map<String, Object> map);
		
		Map<String, Object> addMultiDepartmentMapping(Map<String, Object> map);
		
		Map<String, Object> deleteMultiDepartmentMapping(Map<String, Object> map);

		Map<String, Object> showDoctorCounterMapping(Map<String, Object> map);

		Map showDoctorCounterValues(Map generalMap);

		Map showEmpValues(Map map);

		boolean editDoctorCounterMapping(Map<String, Object> generalMap);

}