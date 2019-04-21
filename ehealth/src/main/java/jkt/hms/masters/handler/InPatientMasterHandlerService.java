package jkt.hms.masters.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.DischargeItems;
import jkt.hms.masters.business.DischargeItemsCategory;
import jkt.hms.masters.business.MasAmbulance;
import jkt.hms.masters.business.MasBabyStatus;
import jkt.hms.masters.business.MasBedStatus;
import jkt.hms.masters.business.MasBodyPart;
import jkt.hms.masters.business.MasCareType;
import jkt.hms.masters.business.MasDelivery;
import jkt.hms.masters.business.MasDischargeStatus;
import jkt.hms.masters.business.MasDisposedTo;
import jkt.hms.masters.business.MasHouseKeeping;
import jkt.hms.masters.business.MasHouseKeepingFrequency;
import jkt.hms.masters.business.MasInjuryNature;
import jkt.hms.masters.business.MasNeonatalProblem;
import jkt.hms.masters.business.MasOutsideTreatment;
import jkt.hms.masters.business.MasPerineumMaintenance;
import jkt.hms.masters.business.OtMasUnitDay;
import jkt.hms.util.Box;

public interface InPatientMasterHandlerService {

	// ----------------------------------------Bed
	// Status----------------------------------------
	boolean addBedStatus(MasBedStatus masBedStatus);

	boolean deleteBedStatus(int bedStatusId, Map<String, Object> generalMap);

	Map<String, Object> searchBedStatus(String bedStatusCode,
			String bedStatusName);

	Map<String, Object> showBedStatusJsp();

	boolean editBedStatusToDatabase(Map<String, Object> generalMap);

	// ----------------------Injury Nature ----------------------

	boolean addInjuryNature(MasInjuryNature masInjuryNature);

	Map<String, Object> searchInjuryNature(String injuryNatureCode,
			String injuryNatureName);

	Map<String, Object> showInjuryNatureJsp();

	boolean editInjuryNatureToDatabase(Map<String, Object> generalMap);

	boolean deleteInjuryNature(int injuryNatureId,
			Map<String, Object> generalMap);

	// ---------------------- Baby Status------------------------

	boolean addBabyStatus(MasBabyStatus masBabyStatus);

	Map<String, Object> searchBabyStatus(String babyStatusCode,
			String babyStatusName);

	Map<String, Object> showBabyStatusJsp();

	boolean editBabyStatusToDatabase(Map<String, Object> generalMap);

	boolean deleteBabyStatus(int babyStatusId, Map<String, Object> generalMap);

	// ------------------------------delivery-------------------------------------
	public boolean addDelivery(MasDelivery masDelivery);

	public boolean deleteDelivery(int deliveryId, Map<String, Object> generalMap);

	Map<String, Object> showDeliveryJsp();

	Map<String, Object> searchDelivery(String deliveryCode, String deliveryName);

	boolean editDeliveryToDatabase(Map<String, Object> generalMap);

	// ----------------------------------CareType---------------------------

	Map<String, Object> showCareTypeJsp();

	Map<String, Object> searchCareType(String careTypeCode, String careTypeName);

	boolean addCareType(MasCareType masCareType);

	boolean editCareTypeToDatabase(Map<String, Object> generalMap);

	boolean deleteCareType(int careTypeId, Map<String, Object> generalMap);

	// ------------------------Disposed
	// TO------------------------------------------

	Map<String, Object> showDisposedToJsp();

	Map<String, Object> searchDisposedTo(String disposedToCode,
			String disposedToName);

	boolean addDisposedTo(MasDisposedTo masDisposedTo);

	boolean editDisposedToToDatabase(Map<String, Object> generalMap);

	boolean deleteDisposedTo(int disposedToId, Map<String, Object> generalMap);

	// ---------------------------Body
	// Part------------------------------------------

	Map<String, Object> showBodyPartJsp();

	Map<String, Object> searchBodyPart(String bodyPartCode, String bodyPartName);

	boolean addBodyPart(MasBodyPart masBodyPart);

	boolean editBodyPartToDatabase(Map<String, Object> generalMap);

	boolean deleteBodyPart(int bodyPartId, Map<String, Object> generalMap);

	// -----------------------Discharge
	// Status-------------------------------------

	Map<String, Object> showDischargeStatusJsp();

	Map<String, Object> searchDischargeStatus(String dischargeStatusCode,
			String dischargeStatusName);

	boolean addDischargeStatus(MasDischargeStatus masDischargeStatus);

	boolean editDischargeStatusToDatabase(Map<String, Object> generalMap);

	boolean deleteDischargeStatus(int dischargeStatusId,
			Map<String, Object> generalMap);

	// ------------------------------Discharge
	// Items-------------------------------------------
	Map<String, Object> showDischargeItemsJsp();

	Map<String, Object> searchDischargeItems(String itemCode,
			String itemDescription);

	boolean addDischargeItems(DischargeItems dischargeItems);

	boolean editDischargeItemsToDatabase(Map<String, Object> generalMap);

	boolean deleteDischargeItems(int dischargeItemsId,
			Map<String, Object> generalMap);

	// -----------------------------------DischargeItemsCategory------------------------------
	Map<String, Object> showDischargeCategoryJsp();

	boolean addDischargeItemsCategory(
			DischargeItemsCategory dischargeItemsCategory);

	boolean editDischargeItemsCategory(Map<String, Object> generalMap);

	boolean deleteDischargeItemsCategory(int dischargeCateogryId,
			Map<String, Object> generalMap);

	Map<String, Object> searchDischargeItemsCategory(String dischargeItem);

	Map<String, Object> showNeonatalProblemJsp();

	boolean editNeonatalProblem(Map<String, Object> generalMap);

	boolean deleteNeonatalProblem(int id, Map<String, Object> generalMap);

	Map<String, Object> searchNeonatalProblem(String neonatalProblemCode,
			String neonatalProblemName);

	boolean addNeonatalProblem(MasNeonatalProblem masNeonatalProblem);

	Map<String, Object> showOutsideTreatmentJsp();

	Map<String, Object> searchOutsideTreatment(String outsideTreatmentCode,
			String outsideTreatmentName);

	boolean addOutsideTreatment(MasOutsideTreatment masOutsideTreatment);

	boolean editOutsideTreatment(Map<String, Object> generalMap);

	boolean deleteOutsideTreatment(int outsideTreatmentId,
			Map<String, Object> generalMap);

	Map<String, Object> showPerineumMaintenanceJsp();

	Map<String, Object> searchPerineumMaintenance(
			String perineumMaintenanceCode, String perineumMaintenanceName);

	boolean addPerineumMaintenance(MasPerineumMaintenance masPerineumMaintenance);

	boolean editPerineumMaintenance(Map<String, Object> generalMap);

	boolean deletePerineumMaintenance(int perineumMaintenanceId,
			Map<String, Object> generalMap);
	
	Map<String, Object> getKitTemplateList(int hospitalId);
	
	Map<String, Object> getItemListForAutoComplete(Map<String, Object> map);
	
	Map<String, Object> getItemListForKitIssueAutoComplete(Map<String, Object> map);
	
	Map<String, Object> submitKitIssueMasterDetails(Box box);

	Map<String, Object> showKitIssueTemplateDetails(Box box);

	Map<String, Object> updateKitIssueMasterDetails(Box box);

	Map<String, Object> deleteKitIssueTemplate(Box box);

	Map<String, Object> getPatientDetailsForKitIssue(Box box);

	Map showHouseKeeping();

	boolean addHouseKeeping(MasHouseKeeping masHouseKeeping);

	boolean editHouseKeeping(Map<String, Object> generalMap);

	Map<String, Object> searchHouseKeeping(String houseKeepingCode,
			String houseKeepingName);

	boolean deleteHouseKeeping(int houseKeepingId,
			Map<String, Object> generalMap);

	Map<String, Object> showHouseKeepingFrequencyJsp();

	boolean deleteHouseKeepingFrequency(int frequencyId,
			Map<String, Object> generalMap);

	boolean editHouseKeepingFrequency(Map<String, Object> generalMap);

	Map<String, Object> searchHouseKeepingFrequency(String frequencyCode,
			String frequencyName);

	boolean addHouseKeepingFrequency(
			MasHouseKeepingFrequency masHouseKeepingFrequency);

	Map<String, Object> showUnitWiseTableJsp(int hospitalId);

	Map<String, Object> getTableList(int departmentId, int hospitalId);

	boolean saveUnitWiseTable(OtMasUnitDay omud);

	List<OtMasUnitDay> checkForExistingData(int bedId, int unitId,
			String dayName,int hospitalId);
	
	
	Map showWasteCategory();

	boolean addWasteCategory(Map<String, Object> wasteCategoryMap);

	boolean editWasteCategory(Map<String, Object> generalMap);

	Map<String, Object> searchWasteCategory(String wasteCategoryCode,
			String wasteCategoryName);

	boolean deleteWasteCategory(int wasteCategoryId,
			Map<String, Object> generalMap);

	Map showWasteContainer();

	boolean addWasteContainer(Map<String, Object> wasteContainerMap);

	boolean editWasteContainer(Map<String, Object> generalMap);

	Map<String, Object> searchWasteContainer(String wasteContainerCode,
			String wasteContainerName);

	boolean deleteWasteContainer(int wasteContainerId,
			Map<String, Object> generalMap);

	Map<String, Object> showAmbulanceJsp();

	boolean deleteAmbulance(int ambulanceId, Map<String, Object> generalMap);

	boolean editAmbulanceToDatabase(Map<String, Object> generalMap);

	boolean addAmbulance(MasAmbulance masAmbulance);

	Map<String, Object> searchAmbulance(String ambulanceNo);

}