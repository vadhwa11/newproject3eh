package jkt.hms.ot.dataservice;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.OtConsent;
import jkt.hms.masters.business.OtIntraOperativeTimeOut;
import jkt.hms.masters.business.OtPreOperativeCheckList;
import jkt.hms.masters.business.OtSignOut;
import jkt.hms.masters.business.OtSignOutItemConsume;
import jkt.hms.util.Box;

@SuppressWarnings("unchecked")
public interface OTDataService {

	Map<String, Object> getPacClearanceList(Map mapForDS);
	//by Vishnu
	Map<String, Object> showWaitingListForSurgery(Map mapForDS);
	//Map<String, Object> searchPatientForSurgery(Map mapForDS);
	Map<String, Object> fillMemberForName(Map dataMap);

	Map<String, Object> searchpatient(Map mapForDS);

	Map<String, Object> showPreAnesthesiaForm(Map mapForDS);

	boolean submitPreAnesthesiaDetails(Map mapForDS);

	Map<String, Object> showPACClearedListForOTBooking(Map mapForDS);

	Map<String, Object> showOTBookingJsp(Map mapForDS);

	Map<String, Object> submitOTBookingDetails(Map mapForDS);

	Map<String, Object> getSurgeonListForAutoComplete(Map mapForDS);

	Map<String, Object> searchPatientDetailsForDisposal(Map mapForDS);

	Map<String, Object> showHumanBodyPartsDisposalJsp(Map mapForDS);

	boolean submitHumanBodyPartsDisposal(Map mapForDS);

	Map<String, Object> searchHumanBodyPartsDisposal(Map mapForDS);

	Map<String, Object> getEntryNoListForHumanBodyPartsDisposal(Map mapForDS);

	Map<String, Object> showEmergencyOTBookingJsp(Map mapForDS);

	boolean submitEmergencyOTBookingDetails(Map mapForDS);

	Map<String, Object> searchPatientDetailsForEmergencyOTBooking(Map mapForDS);

	Map<String, Object> getInvestigationDetails(Map mapForDS);

	/**
	 * ------------------------------- OT LIST CHANGE JSP
	 * ---------------------------
	 * 
	 * @param mapForDS
	 * @return
	 */

	Map<String, Object> showOTListChangeJsp(Map<String, Object> mapForDS);

	Map<String, Object> getOTSchedule(Map<String, Object> mapForDS);

	Map<String, Object> changeOTSchedule(Map<String, Object> map);

	Map<String, Object> updateOTSchedule(Box box);

	Map<String, Object> cancelOTSchedule(Box box);

	/**
	 * -------------------------- PRE- ANAESTHESIA NOTES ENTRY PROCEDURE
	 * ----------------------
	 */
	Map<String, Object> searchOtPatientDetails(Map<String, Object> mapForDS);

	Map<String, Object> showPreAneaesthesiaProcNotesEntryJsp(
			Map<String, Object> mapForDS);

	Map<String, Object> submitPreAneaesthesiaProcNotesEntryJsp(Box box,
			List<Integer> pvmsNoList);

	Map<String, Object> getNomenclature(String storeItem);

	Map<String, Object> getStoreItemForAutoComplete(Map<String, Object> map);

	/**
	 * -------------------------- OT PROCEDURE NOTES ENTRY PROCEDURE
	 * ----------------------
	 */
	Map<String, Object> showOtProcedureNotesEntryJsp(
			Map<String, Object> mapForDS);

	Map<String, Object> getEmpNameForAutoComplete(Map<String, Object> map);

	Map<String, Object> submitOtProcedureNotesEntryJsp(Box box,
			List<Integer> employeeId);
	
	Map<String, Object> submitOtProcedureNotesEntryJsp(Box box,
			List<Integer> employeeId,Map<String, Object> mapForDS);
	
	

	List<String> getOtProcHinNoList(String serviceNo);
	
	public String generatePrecriptionNo(int hinId);

	List<Object> getYearlySerialNoList(Map<String, Object> detailsMap);

	/**
	 * -------------------------------- OT Specimen JSP
	 * ---------------------------------
	 * 
	 * @param mapForDS
	 * @return
	 */

	Map<String, Object> searchSpecimenPatientDetails(
			Map<String, Object> mapForDS);

	Map<String, Object> showSpecimenJspForHin(Map<String, Object> mapForDS);

	/**
	 * -------------------------- OT Post Anaesthesia PROCEDURE
	 * ----------------------
	 */

	Map<String, Object> searchPostAnaesthesiaPatientDetails(
			Map<String, Object> mapForDS);
	
	Map<String, Object> saveOtPostAnaesthesiaReadingJsp(
			Map<String, Object> mapForDS);
			
			Map<String, Object> showPatientAllPeriscopeReading(
					Map<String, Object> mapForDS);
	
	Map<String, Object> saveOtPostAnaesthesiaFinalReadingJsp(
			Map<String, Object> mapForDS);
	
	Map<String, Object> showPostAnaesthesiaJspForHin(
			Map<String, Object> mapForDS);

	String getYearlySeqForDisplay();

	String getMonthlySeqForDisplay();

	Map<String, Object> showPACDetailJsp(int orderNo, int hinId, int visitId);

	// Map<String, Object> showPACDetailJsp(int orderNo, int hinId);

	Map<String, Object> getChargeCodeValue(String chargeCodeName);

	Map<String, Object> getSurgeyForAutoComplete(Map<String, Object> mapForDS);

//	Map<String, Object> getEmpValue(String empName);

	Map<String, Object> getSurgeonForAutoComplete(Map<String, Object> mapForDS);

	Map<String, Object> getItemValue(String nomenclature);

	Map<String, Object> getItemForAutoComplete(Map<String, Object> map);

	boolean submitOtPostAnesthesiaProcedure(Map<String, Object> mapForDS);

	Map<String, Object> getItemListForAutoComplete(Map<String, Object> map);

	Map<String, Object> getItemList(Map<String, Object> map);

	Map<String, Object> showOtPostAnesthesiaProcedure(
			Map<String, Object> mapForDS);

	List<Object> getVisitNoList(Map<String, Object> detailsMap);

	List<Object> getHinNoList(String serviceNo);

	boolean updateOtPostAnesthesiaProcedure(Map<String, Object> mapForDS);

	Map<String, Object> searchSpecimenDispatchEntryPatientDetails(
			Map<String, Object> mapForDS);

	Map<String, Object> showSpecimenDispatchEntryJspForHin(
			Map<String, Object> mapForDS);

	String getEntryNoForDisplay();

	boolean submitOtSpecimenDispatchEntry(Map<String, Object> mapForDS);

	List<Object> getEntryNoList(Map<String, Object> detailsMap);

	List<Object> getOtProcPatientDetailList(Map<String, Object> detailsMap);

	List<Object> getEntryHinNoList(String serviceNo);

	Map<String, Object> showOtSpecimenDispatchEntry(Map<String, Object> mapForDS);

	boolean updateOtSpecimenDispatchEntry(Map<String, Object> mapForDS);

	Map<String, Object> showPACDetailInJsp(int orderNo, int hinId,
			int inpatientId);

	List<String> getPreAnaesthesiaHinNoList(String serviceNo);

	List<Object> getPreAnaesthesiaYearlySerialNoList(
			Map<String, Object> detailsMap);
	Map<String, Object> getConnectionForReport();

	Map<String, Object> printPAC(int hinId);

	Map<String, Object> getInvestigationListForRequestionForIP(Map<String, Object> map);

	Map<String, Object> showPACDetailHnJsp(int orderNo, int hinId);

	Map<String, Object> getEmpValue(Map<String, Object> mapForDS);

	Map<String, Object> searchPreOperativeCheckList(Map<String, Object> mapForDS);

	Map<String, Object> searchOtPatientConsentDetails(Map<String, Object> mapForDS);

	Map<String, Object> showConsentEntryJsp(Map<String, Object> mapForDS);

	Map<String, Object> submitConsentForOt(OtConsent otConsent, Box box);

	Map<String, Object> getHospitalName(int hospitalId);

	Map<String, Object> submitPreOTCheckList(OtPreOperativeCheckList otConsent,
			Box box);

	Map<String, Object> showPreOperativeCheckListEntryJsp(
			Map<String, Object> mapForDS);

	int getItemId(String itemName);

	Map<String, Object> searchOtSignoutList(Map<String, Object> mapForDS);

	Map<String, Object> showOtSignoutListEntryJsp(Map<String, Object> mapForDS);

	Map<String, Object> submitOtSignOutEntryJsp(OtSignOut otSignOut, int hinId);

	Map<String, Object> submitOtSignOutEntryJsp(
			OtSignOutItemConsume otSignItemConsume);

	Map<String, Object> searchIntraOperativeCheckList(
			Map<String, Object> mapForDS);

	Map<String, Object> showIntraOperativeCheckListEntryJsp(
			Map<String, Object> mapForDS);

	Map<String, Object> submitIntrOperatioveForOt(OtIntraOperativeTimeOut sSS,int hinId,Map<String,Object> dataMap);

	Map<String, Object> getOtTime(Map<String, Object> map);

	Map<String, Object> getInvestigationListForAutoComplete(Map<String, Object> map);

	Map<String, Object> getStoreConsumableItemForAutoComplete(
			Map<String, Object> map);

	Map<String, Object> getChargeCodeDetailsForOT(String chargeCode, int hin);
	
	Map<String, Object> showCalenderForOt(Map<String, Object> mapForDS);
	Map<String, Object> displayOtTableForUnit(Box box);
	Map<String, Object> showAllergy(Box box, Map<String, Object> dataMap);
	Map<String, Object> getSurgeryInfoForPatient(int inaptientId);
	Map<String, Object> showOpSurgeryPlanningJsp(Map<String, Object> mapForDS);
	Map<String, Object> getUnitDays(int unitId);
	
	Map<String, Object> getBookingDetails(int hospitalId,int unitId, String dayName,Date bookingDate);
	boolean cancelServiceInv(int dtId, Date surgeryDate2);
	List<Inpatient> getHinId(int inpatientId);
	
	Map<String, Object> searchSurgerySafetyCheckList(
			Map<String, Object> mapForDS);
	Map<String, Object> showSurgerySafetyCheckListJsp(
			Map<String, Object> mapForDS);
	Map<String, Object> submitSurgerySafetyCheckList(Box box);

	Map<String, Object> showMinorOtWaitingList(Map mapForDS);
	
	Map<String, Object> searchMinorOtPatientDetails(Map<String, Object> mapForDS);
	
	Map<String, Object> searchMinorOtSignoutList(Map<String, Object> mapForDS);
	
	Map<String, Object> searchOtPatientConsentLetter(Map<String, Object> mapForDS);
	
	Map<String, Object> uploadOtConsentLetter(Map<String, Object> mapForDS);
	
	Map<String, Object> uploadAndViewDocuments(Map<String, Object> generalMap);
	String getSurgeryDoctors(int otSignOutId);
	
	
	Map<String, Object> referBackPatientToOpd(int surgeryId,String submitForm,int userId);
	int getRefferedSession(int departmentId,int hospitalId);
	
	Map<String, Object> getPacHistory(int orderId);
	Map<String, Object> getPreAnesthesiaHistory(int bookingId);
	Map<String, Object> getYearlySerialNo(int otBookingId);
	Map<String,Object> showOpPreAnesthesiaForm(Map<String, Object> mapForDS);
	
	Map<String,Object> submitAac(Map<String,Object> mapForDS);
	Map<String,Object> showOpPacHistory(Map<String,Object> mapForDS);
	int getEmployeeIdFromUser(int userId);
	Map<String,Object> showTableWiseOtList(Map<String, Object> mapForDS);
}
