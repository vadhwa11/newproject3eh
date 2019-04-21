package jkt.hms.masters.dataservice;

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

public interface InPatientMasterDataService {

	// ------------------------------------- Bed Status -----------------------

	boolean addBedStatus(MasBedStatus masBedStatus);
	boolean deleteBedStatus(int bedStatusId, Map<String, Object> generalMap);

	boolean editBedStatusToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchBedStatus(String bedStatusCode,
			String bedStatusName);

	Map<String, Object> showBedStatusJsp();

	// -------------------------- Injury Nature
	// ---------------------------------------

	boolean addInjuryNature(MasInjuryNature masInjuryNature);

	boolean editInjuryNatureToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchInjuryNature(String injuryNatureCode,
			String injuryNatureName);

	Map<String, Object> showInjuryNatureJsp();

	boolean deleteInjuryNature(int injuryNatureId,
			Map<String, Object> generalMap);

	// ------------------------------- Baby
	// Status--------------------------------------

	boolean addBabyStatus(MasBabyStatus masBabyStatus);

	boolean editBabyStatusToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchBabyStatus(String babyStatusCode,
			String babyStatusName);

	Map<String, Object> showBabyStatusJsp();

	boolean deleteBabyStatus(int babyStatusId, Map<String, Object> generalMap);

	// ------------------------------delivery-------------------------------------
	public boolean addDelivery(MasDelivery masDelivery);

	public boolean deleteDelivery(int deliveryId, Map<String, Object> generalMap);

	boolean editDeliveryToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchDelivery(String deliveryCode, String deliveryName);

	Map<String, Object> showDeliveryJsp();

	// -----------------------------Care Type--------------------------
	public boolean addCareType(MasCareType masCareType);

	public boolean deleteCareType(int careTypeId, Map<String, Object> generalMap);

	boolean editCareTypeToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchCareType(String careTypeCode, String careTypeName);

	Map<String, Object> showCareTypeJsp();

	// -----------------Disposed TO---------------------------------------

	public boolean addDisposedTo(MasDisposedTo masDisposedTo);

	public boolean deleteDisposedTo(int disposedToId,
			Map<String, Object> generalMap);

	boolean editDisposedToToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchDisposedTo(String disposedToCode,
			String disposedToName);

	Map<String, Object> showDisposedToJsp();

	// -------------------------Body
	// Part-------------------------------------------
	boolean addBodyPart(MasBodyPart masBodyPart);

	boolean deleteBodyPart(int bodyPartId, Map<String, Object> generalMap);

	boolean editBodyPartToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchBodyPart(String bodyPartCode, String bodyPartName);

	Map<String, Object> showBodyPartJsp();

	// -----------------------Discharge Status-----------------------
	boolean addDischargeStatus(MasDischargeStatus masDischargeStatus);

	boolean deleteDischargeStatus(int dischargeStatusId,
			Map<String, Object> generalMap);

	boolean editDischargeStatusToDatabase(Map<String, Object> generalMap);

	Map<String, Object> showDischargeStatusJsp();

	Map<String, Object> searchDischargeStatus(String dischargeStatusCode,
			String dischargeStatusName);

	// ----------------------Discharge Status----------------------
	boolean addDischargeItems(DischargeItems dischargeItems);

	boolean deleteDischargeItems(int dischargeItemsId,
			Map<String, Object> generalMap);

	boolean editDischargeItemsToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchDischargeItems(String itemCode,
			String itemDescription);

	Map<String, Object> showDischargeItemsJsp();

	// -----------------------DischargeItemsCategory-------------------------------
	Map<String, Object> showDischargeCategoryJsp();

	boolean addDischargeItemsCategory(
			DischargeItemsCategory dischargeItemsCategory);

	boolean editDischargeItemsCategory(Map<String, Object> generalMap);

	boolean deleteDischargeItemsCategory(int dischargeCateogryId,
			Map<String, Object> generalMap);

	Map<String, Object> searchDischargeItemsCategory(String dischargeItem);

	Map<String, Object> showNeonatalProblemJsp();

	boolean editNeonatalProblem(Map<String, Object> map);

	boolean deleteNeonatalProblem(int id, Map<String, Object> generalMap);

	Map<String, Object> searchNeonatalProblem(String neonatalProblemCode,
			String neonatalProblemName);;

	boolean addNeonatalProblem(MasNeonatalProblem masNeonatalProblem);

	Map<String, Object> showOutsideTreatmentJsp();

	boolean addOutsideTreatment(MasOutsideTreatment masOutsideTreatment);

	boolean editOutsideTreatment(Map<String, Object> generalMap);

	public Map<String, Object> searchOutsideTreatment(
			String outsideTreatmentCode, String outsideTreatmentName);

	public boolean deleteOutsideTreatment(int outsideTreatmentId,
			Map<String, Object> generalMap);

	Map<String, Object> showPerineumMaintenanceJsp();

	Map<String, Object> searchPerineumMaintenance(
			String perineumMaintenanceCode, String perineumMaintenanceName);

	boolean addPerineumMaintenance(MasPerineumMaintenance masPerineumMaintenance);

	boolean editPerineumMaintenance(Map<String, Object> generalMap);

	boolean deletePerineumMaintenance(int perineumMaintenanceId,
			Map<String, Object> generalMap);
	
	public Map<String, Object> getKitTemplateList(int hospitalId);
	
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
