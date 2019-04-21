package jkt.hms.ot.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.OtConsent;
import jkt.hms.masters.business.OtIntraOperativeTimeOut;
import jkt.hms.masters.business.OtPreOperativeCheckList;
import jkt.hms.masters.business.OtSignOut;
import jkt.hms.masters.business.OtSignOutItemConsume;
import jkt.hms.ot.dataservice.OTDataService;
import jkt.hms.util.Box;

@SuppressWarnings("unchecked")
public class OTHandlerServiceImpl implements OTHandlerService {

	OTDataService otDataService = null;

	public OTDataService getOtDataService() {
		return otDataService;
	}

	public void setOtDataService(OTDataService otDataService) {
		this.otDataService = otDataService;
	}

	public Map<String, Object> getPacClearanceList(Map mapForDS) {
		
		return otDataService.getPacClearanceList(mapForDS);
	}
			
	public Map<String, Object> searchpatient(Map mapForDS) {
		
		return otDataService.searchpatient(mapForDS);
	}

	public Map<String, Object> showPreAnesthesiaForm(Map mapForDS) {
		
		return otDataService.showPreAnesthesiaForm(mapForDS);
	}

	public boolean submitPreAnesthesiaDetails(Map mapForDS) {
		
		return otDataService.submitPreAnesthesiaDetails(mapForDS);
	}

	public Map<String, Object> showPACClearedListForOTBooking(Map mapForDS) {
		
		return otDataService.showPACClearedListForOTBooking(mapForDS);
	}

	public Map<String, Object> showOTBookingJsp(Map mapForDS) {
		
		return otDataService.showOTBookingJsp(mapForDS);
	}

	public Map<String, Object> submitOTBookingDetails(Map mapForDS) {
		
		return otDataService.submitOTBookingDetails(mapForDS);
	}

	public Map<String, Object> getSurgeonListForAutoComplete(Map mapForDS) {
		
		return otDataService.getSurgeonListForAutoComplete(mapForDS);
	}

	public Map<String, Object> searchPatientDetailsForDisposal(Map mapForDS) {
		
		return otDataService.searchPatientDetailsForDisposal(mapForDS);
	}

	public Map<String, Object> showHumanBodyPartsDisposalJsp(Map mapForDS) {
		
		return otDataService.showHumanBodyPartsDisposalJsp(mapForDS);
	}

	public boolean submitHumanBodyPartsDisposal(Map mapForDS) {
		
		return otDataService.submitHumanBodyPartsDisposal(mapForDS);
	}

	public Map<String, Object> searchHumanBodyPartsDisposal(Map mapForDS) {
		
		return otDataService.searchHumanBodyPartsDisposal(mapForDS);
	}

	public Map<String, Object> getEntryNoListForHumanBodyPartsDisposal(
			Map mapForDS) {
		
		return otDataService.getEntryNoListForHumanBodyPartsDisposal(mapForDS);
	}

	public Map<String, Object> showEmergencyOTBookingJsp(Map mapForDS) {
		
		return otDataService.showEmergencyOTBookingJsp(mapForDS);
	}

	public Map<String, Object> searchPatientDetailsForEmergencyOTBooking(
			Map mapForDS) {
		
		return otDataService
				.searchPatientDetailsForEmergencyOTBooking(mapForDS);
	}

	public boolean submitEmergencyOTBookingDetails(Map mapForDS) {
		
		return otDataService.submitEmergencyOTBookingDetails(mapForDS);
	}

	public Map<String, Object> getInvestigationDetails(Map mapForDS) {
		
		return otDataService.getInvestigationDetails(mapForDS);
	}

	/**
	 * --------------------------- OT LIST CHANGE JSP
	 * -------------------------------
	 */
	public Map<String, Object> showOTListChangeJsp(Map<String, Object> mapForDS) {
		
		return otDataService.showOTListChangeJsp(mapForDS);
	}

	public Map<String, Object> getOTSchedule(Map<String, Object> mapForDS) {
		return otDataService.getOTSchedule(mapForDS);
	}

	public Map<String, Object> changeOTSchedule(Map<String, Object> map) {
		
		return otDataService.changeOTSchedule(map);
	}

	public Map<String, Object> updateOTSchedule(Box box) {
		
		return otDataService.updateOTSchedule(box);
	}

	public Map<String, Object> cancelOTSchedule(Box box) {
		
		return otDataService.cancelOTSchedule(box);
	}

	/**
	 * -------------------------- PRE- ANAESTHESIA NOTES ENTRY PROCEDURE
	 * ----------------------
	 */
	public Map<String, Object> searchOtPatientDetails(
			Map<String, Object> mapForDS) {
		
		return otDataService.searchOtPatientDetails(mapForDS);
	}

	public Map<String, Object> showPreAneaesthesiaProcNotesEntryJsp(
			Map<String, Object> mapForDS) {
		
		return otDataService.showPreAneaesthesiaProcNotesEntryJsp(mapForDS);
	}

	public Map<String, Object> submitPreAneaesthesiaProcNotesEntryJsp(Box box,
			List<Integer> pvmsNoList) {
		
		return otDataService.submitPreAneaesthesiaProcNotesEntryJsp(box,
				pvmsNoList);
	}

	public Map<String, Object> getNomenclature(String storeItem) {
		
		return otDataService.getNomenclature(storeItem);
	}

	public Map<String, Object> getStoreItemForAutoComplete(
			Map<String, Object> map) {
		
		return otDataService.getStoreItemForAutoComplete(map);
	}

	public Map<String, Object> showOtProcedureNotesEntryJsp(
			Map<String, Object> mapForDS) {
		
		return otDataService.showOtProcedureNotesEntryJsp(mapForDS);
	}

	public Map<String, Object> getEmpNameForAutoComplete(Map<String, Object> map) {
		
		return otDataService.getEmpNameForAutoComplete(map);
	}

	public Map<String, Object> submitOtProcedureNotesEntryJsp(Box box,
			List<Integer> employeeId) {
		
		return otDataService.submitOtProcedureNotesEntryJsp(box, employeeId);
	}
	
	public Map<String, Object> submitOtProcedureNotesEntryJsp(Box box,
			List<Integer> employeeId,Map<String, Object> mapForDS){
				
				return otDataService.submitOtProcedureNotesEntryJsp(box, employeeId,mapForDS);
			}

	public List<String> getOtProcHinNoList(String serviceNo) {
		
		return otDataService.getOtProcHinNoList(serviceNo);
	}
	
	public String generatePrecriptionNo(int hinId) {
		return otDataService.generatePrecriptionNo(hinId);
	}

	public List<Object> getYearlySerialNoList(Map<String, Object> detailsMap) {
		
		return otDataService.getYearlySerialNoList(detailsMap);
	}

	public List<Object> getOtProcPatientDetailList(
			Map<String, Object> detailsMap) {
		
		return otDataService.getOtProcPatientDetailList(detailsMap);
	}

	/**
	 * -------------------------------- OT Specimen JSP
	 * ---------------------------------
	 * 
	 * @param mapForDS
	 * @return
	 */

	public Map<String, Object> searchSpecimenPatientDetails(
			Map<String, Object> mapForDS) {
		return otDataService.searchSpecimenPatientDetails(mapForDS);
	}

	public Map<String, Object> showSpecimenJspForHin(
			Map<String, Object> mapForDS) {

		return otDataService.showSpecimenJspForHin(mapForDS);
	}

	// ---------------------------- Ot Post Anaesthesia Patient By Mansi
	// -------------------------------------

	public String getYearlySeqForDisplay() {
		return otDataService.getYearlySeqForDisplay();
	}

	public String getMonthlySeqForDisplay() {
		return otDataService.getMonthlySeqForDisplay();
	}

	public Map<String, Object> searchPostAnaesthesiaPatientDetails(
			Map<String, Object> mapForDS) {
		return otDataService.searchPostAnaesthesiaPatientDetails(mapForDS);
	}
	
	 public Map<String, Object> saveOtPostAnaesthesiaReadingJsp(
			Map<String, Object> mapForDS){
		return otDataService.saveOtPostAnaesthesiaReadingJsp(mapForDS);
	}
	 
	 public Map<String, Object> showPatientAllPeriscopeReading(
				Map<String, Object> mapForDS){
			return otDataService.showPatientAllPeriscopeReading(mapForDS);
		}
	
	 public Map<String, Object> saveOtPostAnaesthesiaFinalReadingJsp(
				Map<String, Object> mapForDS){
			return otDataService.saveOtPostAnaesthesiaFinalReadingJsp(mapForDS);
		}

	public Map<String, Object> showPostAnaesthesiaJspForHin(
			Map<String, Object> mapForDS) {
		return otDataService.showPostAnaesthesiaJspForHin(mapForDS);
	}

	public Map<String, Object> showPACDetailJsp(int orderNo, int hinId,
			int visitId) {
		return otDataService.showPACDetailJsp(orderNo, hinId, visitId);
	}

	/*
	 * public Map<String, Object> showPACDetailJsp(int orderNo,int hinId) {
	 * return otDataService.showPACDetailJsp(orderNo,hinId); }
	 */

	public Map<String, Object> getChargeCodeValue(String chargeCodeName) {
		return otDataService.getChargeCodeValue(chargeCodeName);
	}

	public Map<String, Object> getSurgeyForAutoComplete(
			Map<String, Object> mapForDS) {
		return otDataService.getSurgeyForAutoComplete(mapForDS);
	}

	/*public Map<String, Object> getEmpValue(String empName) {
		return otDataService.getEmpValue(empName);
	}*/

	public Map<String, Object> getSurgeonForAutoComplete(
			Map<String, Object> mapForDS) {
		return otDataService.getSurgeonForAutoComplete(mapForDS);
	}

	public Map<String, Object> getItemForAutoComplete(Map<String, Object> map) {
		return otDataService.getItemForAutoComplete(map);
	}

	public Map<String, Object> getItemValue(String nomenclature) {

		return otDataService.getItemValue(nomenclature);
	}

	public boolean submitOtPostAnesthesiaProcedure(Map<String, Object> mapForDS) {
		return otDataService.submitOtPostAnesthesiaProcedure(mapForDS);
	}

	public Map<String, Object> getItemList(Map<String, Object> map) {
		return otDataService.getItemList(map);
	}

	public Map<String, Object> getItemListForAutoComplete(
			Map<String, Object> map) {
		return otDataService.getItemListForAutoComplete(map);
	}

	public Map<String, Object> showOtPostAnesthesiaProcedure(
			Map<String, Object> mapForDS) {
		return otDataService.showOtPostAnesthesiaProcedure(mapForDS);
	}

	public List<Object> getHinNoList(String serviceNo) {
		return otDataService.getHinNoList(serviceNo);
	}

	public List<Object> getVisitNoList(Map<String, Object> detailsMap) {
		return otDataService.getVisitNoList(detailsMap);
	}

	public boolean updateOtPostAnesthesiaProcedure(Map<String, Object> mapForDS) {
		return otDataService.updateOtPostAnesthesiaProcedure(mapForDS);
	}

	public Map<String, Object> showPACDetailInJsp(int orderNo, int hinId,
			int inpatientId) {
		return otDataService.showPACDetailInJsp(orderNo, hinId, inpatientId);
	}

	// ---------------------------- End -------------------------------------
	// ---------------------------- Ot Specimen Dispatch Entry Patient By Mansi
	// -------------------------------------

	public String getEntryNoForDisplay() {
		return otDataService.getEntryNoForDisplay();
	}

	public Map<String, Object> searchSpecimenDispatchEntryPatientDetails(
			Map<String, Object> mapForDS) {
		return otDataService
				.searchSpecimenDispatchEntryPatientDetails(mapForDS);
	}

	public Map<String, Object> showSpecimenDispatchEntryJspForHin(
			Map<String, Object> mapForDS) {
		return otDataService.showSpecimenDispatchEntryJspForHin(mapForDS);
	}

	public boolean submitOtSpecimenDispatchEntry(Map<String, Object> mapForDS) {
		return otDataService.submitOtSpecimenDispatchEntry(mapForDS);
	}

	public List<Object> getEntryHinNoList(String serviceNo) {
		return otDataService.getEntryHinNoList(serviceNo);
	}

	public List<Object> getEntryNoList(Map<String, Object> detailsMap) {
		return otDataService.getEntryNoList(detailsMap);
	}

	public Map<String, Object> showOtSpecimenDispatchEntry(
			Map<String, Object> mapForDS) {
		return otDataService.showOtSpecimenDispatchEntry(mapForDS);
	}

	public boolean updateOtSpecimenDispatchEntry(Map<String, Object> mapForDS) {
		return otDataService.updateOtSpecimenDispatchEntry(mapForDS);
	}

	public List<String> getPreAnaesthesiaHinNoList(String serviceNo) {
		
		return otDataService.getPreAnaesthesiaHinNoList(serviceNo);
	}

	public List<Object> getPreAnaesthesiaYearlySerialNoList(
			Map<String, Object> detailsMap) {
		
		return otDataService.getPreAnaesthesiaYearlySerialNoList(detailsMap);
	}

	public Map<String, Object> getConnectionForReport() {
		return otDataService.getConnectionForReport();
	}

	public Map<String, Object> printPAC(int hinId) {
		return otDataService.printPAC(hinId);
	}

	@Override
	public Map<String, Object> getInvestigationListForRequestionForIP(
			Map<String, Object> map) {
		return otDataService.getInvestigationListForRequestionForIP(map);
	}

	@Override
	public Map<String, Object> showPACDetailHnJsp(int orderNo, int hinId) {
		return otDataService.showPACDetailHnJsp(orderNo,hinId);
	}

	@Override
	public Map<String, Object> getEmpValue(Map<String, Object> mapForDS) {
		return otDataService.getEmpValue(mapForDS);
	}

	@Override
	public Map<String, Object> searchPreOperativeCheckList(
			Map<String, Object> mapForDS) {
		return otDataService.searchPreOperativeCheckList(mapForDS);
	}

	@Override
	public Map<String, Object> searchOtPatientConsentDetails(
			Map<String, Object> mapForDS) {
		return otDataService.searchOtPatientConsentDetails(mapForDS);
	}

	@Override
	public Map<String, Object> showConsentEntryJsp(Map<String, Object> mapForDS) {
		return otDataService.showConsentEntryJsp(mapForDS);
	}

	@Override
	public Map<String, Object> submitConsentForOt(OtConsent otConsent, Box box) {
		return otDataService.submitConsentForOt(otConsent,box);
	}

	@Override
	public Map<String, Object> getHospitalName(int hospitalId) {
		return otDataService.getHospitalName(hospitalId);
	}

	@Override
	public Map<String, Object> showPreOperativeCheckListEntryJsp(
			Map<String, Object> mapForDS) {
		return otDataService.showPreOperativeCheckListEntryJsp(mapForDS);
	}

	@Override
	public Map<String, Object> submitPreOTCheckList(
			OtPreOperativeCheckList otConsent, Box box) {
		return otDataService.submitPreOTCheckList(otConsent,box);
	}

	@Override
	public int getItemId(String itemName) {
		return otDataService.getItemId(itemName);
	}

	@Override
	public Map<String, Object> searchOtSignoutList(Map<String, Object> mapForDS) {
		return otDataService.searchOtSignoutList(mapForDS);
	}

	@Override
	public Map<String, Object> showOtSignoutListEntryJsp(
			Map<String, Object> mapForDS) {
		return otDataService.showOtSignoutListEntryJsp(mapForDS);
	}

	@Override
	public Map<String, Object> submitOtSignOutEntryJsp(OtSignOut otSignOut,
			int hinId) {
		return otDataService.submitOtSignOutEntryJsp(otSignOut,hinId);
	}

	@Override
	public Map<String, Object> submitOtSignOutEntryJsp(
			OtSignOutItemConsume otSignItemConsume) {
		return otDataService.submitOtSignOutEntryJsp(otSignItemConsume);
	}

	@Override
	public Map<String, Object> searchIntraOperativeCheckList(
			Map<String, Object> mapForDS) {
		return otDataService.searchIntraOperativeCheckList(mapForDS);
	}

	@Override
	public Map<String, Object> showIntraOperativeCheckListEntryJsp(
			Map<String, Object> mapForDS) {
		return otDataService.showIntraOperativeCheckListEntryJsp(mapForDS);
	}

	

	@Override
	public Map<String, Object> getOtTime(Map<String, Object> map) {
		return otDataService.getOtTime(map);
	}

	@Override
	public Map<String, Object> getInvestigationListForAutoComplete(
			Map<String, Object> map) {
		return otDataService.getInvestigationListForAutoComplete(map);
	}

	@Override
	public Map<String, Object> getStoreConsumableItemForAutoComplete(
			Map<String, Object> map) {
		return otDataService.getStoreConsumableItemForAutoComplete(map);
	}

	@Override
	public Map<String, Object> getChargeCodeDetailsForOT(String chargeCode,
			int hin) {
		return otDataService.getChargeCodeDetailsForOT(chargeCode,hin);
	}
	//by Vishnu
    public Map<String, Object> showWaitingListForSurgery(Map mapForDS) {
		
		return otDataService.showWaitingListForSurgery(mapForDS);
	}
    
/*public Map<String, Object> searchPatientForSurgery(Map mapForDS) {
		
		return otDataService.searchPatientForSurgery(mapForDS);
	}*/
    
 public Map<String, Object> fillMemberForName(Map dataMap) {
		
		return otDataService.fillMemberForName(dataMap);
	}
 
 @Override
public Map<String, Object> showCalenderForOt(Map dataMap) {
		return otDataService.showCalenderForOt(dataMap);
}

@Override
public Map<String, Object> displayOtTableForUnit(Box box) {
	
	return otDataService.displayOtTableForUnit(box);
}

@Override
public Map<String, Object> showAllergy(Box box, Map<String, Object> dataMap) {
	// TODO Auto-generated method stub
	return otDataService.showAllergy(box,dataMap);
}

@Override
public Map<String, Object> getSurgeryInfoForPatient(int inaptientId) {
	return otDataService.getSurgeryInfoForPatient(inaptientId);
}

@Override
public Map<String, Object> showOpSurgeryPlanningJsp(Map<String, Object> mapForDS) {
	// TODO Auto-generated method stub
	return otDataService.showOpSurgeryPlanningJsp(mapForDS);
}

@Override
public Map<String, Object> getUnitDays(int unitId) {
	return otDataService. getUnitDays(unitId);
}
/*
@Override
public Map<String, Object> getBookingDetails(int unitId, String dayName) {
	return otDataService.getBookingDetails(unitId, dayName);
}*/

@Override
public Map<String, Object> getBookingDetails(int hospitalId,int unitId, String dayName,
		Date bookingDate) {
	// TODO Auto-generated method stub
	return otDataService.getBookingDetails(hospitalId,unitId,dayName,bookingDate);
}

@Override
public boolean cancelServiceInv(int dtId, Date surgeryDate2) {
	return otDataService.cancelServiceInv( dtId,  surgeryDate2);
}

@Override
public List<Inpatient> getHinId(int inpatientId) {
	return otDataService.getHinId(inpatientId);
}

@Override
public Map<String, Object> searchSurgerySafetyCheckList(
		Map<String, Object> mapForDS){
	return otDataService.searchSurgerySafetyCheckList(mapForDS);
}

@Override
public Map<String, Object> showSurgerySafetyCheckListJsp(
		Map<String, Object> mapForDS){
	return otDataService.showSurgerySafetyCheckListJsp(mapForDS);
}

@Override
public Map<String, Object> submitSurgerySafetyCheckList(
		Box box){
	return otDataService.submitSurgerySafetyCheckList(box);
}
@Override
public Map<String, Object> showMinorOtWaitingList(Map mapForDS) {
	return otDataService.showMinorOtWaitingList(mapForDS);
}
@Override
public Map<String, Object> searchMinorOtPatientDetails(Map<String, Object> mapForDS) {
	return otDataService.searchMinorOtPatientDetails(mapForDS);
}
@Override
public Map<String, Object> searchMinorOtSignoutList(Map<String, Object> mapForDS) {
	return otDataService.searchMinorOtSignoutList(mapForDS);
}
@Override
public Map<String, Object> searchOtPatientConsentLetter(Map<String, Object> mapForDS) {
	return otDataService.searchOtPatientConsentLetter(mapForDS);
}
@Override
public Map<String, Object> uploadOtConsentLetter(Map<String, Object> mapForDS) {
	return otDataService.uploadOtConsentLetter(mapForDS);
}

@Override
public Map<String, Object> uploadAndViewDocuments(Map<String, Object> mapForDS) {
	return otDataService.uploadAndViewDocuments(mapForDS);
}
@Override
public Map<String, Object> referBackPatientToOpd(int surgeryId,String submitForm,int userId) {
	return otDataService.referBackPatientToOpd(surgeryId,submitForm,userId);
}

@Override
public String getSurgeryDoctors(int otSignOutId) {
	// TODO Auto-generated method stub
	return otDataService.getSurgeryDoctors(otSignOutId);
}
@Override
public int getRefferedSession(int departmentId,int hospitalId) {
	return otDataService.getRefferedSession(departmentId, hospitalId);
}

@Override
public Map<String, Object> getPacHistory(int orderId) {
	// TODO Auto-generated method stub
	return otDataService.getPacHistory(orderId);
}

@Override
public Map<String, Object> getPreAnesthesiaHistory(int bookingId) {
	// TODO Auto-generated method stub
	return otDataService.getPreAnesthesiaHistory(bookingId);
}

@Override
public Map<String, Object> getYearlySerialNo(int otBookingId) {
	// TODO Auto-generated method stub
	return otDataService.getYearlySerialNo(otBookingId);
}

@Override
public Map<String, Object> showOpPreAnesthesiaForm(Map<String, Object> mapForDS) {
	
	return otDataService.showOpPreAnesthesiaForm(mapForDS);
}

@Override
public Map<String, Object> submitAac(Map<String, Object> mapForDS) {
	
	return otDataService.submitAac(mapForDS);
}

@Override
public Map<String, Object> submitIntrOperatioveForOt(
		OtIntraOperativeTimeOut sSS, int hinId, Map<String, Object> dataMap) {
	return otDataService.submitIntrOperatioveForOt(sSS, hinId, dataMap);
}

@Override
public Map<String, Object> showOpPacHistory(Map<String, Object> mapForDS) {
	return otDataService.showOpPacHistory(mapForDS);
}

@Override
public int getEmployeeIdFromUser(int userId) {
	return otDataService.getEmployeeIdFromUser(userId);
}

@Override
public Map<String, Object> showTableWiseOtList(Map<String, Object> mapForDS) {
	// TODO Auto-generated method stub
	return otDataService.showTableWiseOtList(mapForDS);
}


}
