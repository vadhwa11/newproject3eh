package jkt.hms.hes.handler;

import java.util.Map;

import jkt.hms.masters.business.HesCylinderTypeMaster;
import jkt.hms.masters.business.HesCylinderUsageMaster;
import jkt.hms.masters.business.HesEquipmentEmergencyMaintenanceBreakdown;
import jkt.hms.masters.business.HesMaintenanceJobMaster;
import jkt.hms.masters.business.HesWorkParticularMaster;
import jkt.hms.util.Box;

public interface HesHandlerService
{
	boolean addWorkParticularData(HesWorkParticularMaster hesWork);

	Map<String, Object> searchWorkParticular(String countryCode,String countryName);
	
	Map<String, Object> searchEmergencyEquipmentBreakdown(String departmentName);

	boolean editWorkParticularToDatabase(Map<String, Object> generalMap);

	boolean deleteWorkParticularMaster(int workId,Map<String, Object> generalMap);
	
	boolean deleteEmergencyEquipmentBreakdown(int equipmentBreakId,Map<String, Object> generalMap);

	Map<String, Object> showMinorRoutineWorkJsp(Box box);

	Map<String, Object> getItemNamesForAutocomplete(Map<String, Object> dataMap);

	Map<String, Object> getItemClosingStock(Map<String, Object> dataMap);

	boolean submitMinorRoutineWorksEntry(Box box,Map<String, Object> dataMap);

	Map<String, Object> searchMinorRoutine(Map<String, Object> searchFieldMap);
	Map<String, Object> modifyMinorRoutine(int radio_str, int deptId);

	Map<String, Object> showWorkParticularMasterJsp();
	
	

	boolean updateMinorRoutineWorksEntry(Box box, Map<String, Object> dataMap);

	Map<String, Object> showCylinderTypeMasterJsp();

	boolean addCylinderType(HesCylinderTypeMaster cylinderTypeMaster);

	boolean editCylinderType(Map<String, Object> generalMap);

	boolean deleteCylinderType(int cylinderId, Map<String, Object> generalMap);

	Map<String, Object> searchCylinderType(String cylinderTypeCode,	String cylinderTypeName);

	Map<String, Object> showEmptyCylinderRequestJsp(Box box);

	boolean submitEmptyCylinderDispatchEntry(Box box,Map<String, Object> dataMap);

	Map<String, Object> searchEmptyCylinderDispatchForm(Map<String, Object> searchFieldMap);
	
	Map<String, Object> searchEquipmentBreakdownForm(Map<String, Object> searchFieldMap);
	
	Map<String, Object> searchEquipmentCallLogEntryForm(Map<String, Object> searchFieldMap);
	
	Map<String, Object> searchEquipmentMaintenanceForm(Map<String, Object> searchFieldMap);

	Map<String, Object> modifyEmptyCylinderDispatchForm(int radio_str,int deptId);
	
	boolean modifyEquipmentBreakdown(Map<String, Object> generalMap);
	
	boolean modifyCallLogEntry(Map<String, Object> generalMap);
	
	boolean modifyMaintenanceEntry(Map<String, Object> generalMap);

	boolean updateEmptyCylinderDispatchEntry(Box box,Map<String, Object> dataMap);

	Map<String, Object> getCylinderClosingStock(Map<String, Object> dataMap);

	Map<String, Object> showCylinderUsageMasterJsp();

	boolean addCylinderUsage(HesCylinderUsageMaster master);
	
	boolean addEquipmentBreakdownEntry(HesEquipmentEmergencyMaintenanceBreakdown master , int equipmentBreakdownId);

	boolean editCylinderUsage(Map<String, Object> generalMap);
	
	boolean editEquipmentBreakdownEntryInEmergency(Map<String, Object> generalMap);

	boolean deleteCylinderUsage(int cylinderId, Map<String, Object> generalMap);

	Map<String, Object> searchCylinderUsage(String cylinderUsageCode,String cylinderUsageName);

	Map<String, Object> showMaintenanceJobMasterJsp();

	boolean addMaintenanceType(HesMaintenanceJobMaster master);

	boolean editMaintenanceType(Map<String, Object> generalMap);

	boolean deleteMaintenanceType(int cylinderId, Map<String, Object> generalMap);

	Map<String, Object> searchMaintenanceType(String maintenanceCode,String maintenanceName);

	Map<String, Object> showRefilledCylinderRequestJsp(Box box);

	boolean submitRefilledCylinderDeliveryEntry(Box box,Map<String, Object> dataMap);

	Map<String, Object> searchRefilledCylinderDeliveryForm(Map<String, Object> searchFieldMap);

	Map<String, Object> modifyRefilledCylinderDeliveryForm(int radio_str,int deptId);

	boolean updateRefilledCylinderDeliveryEntry(Box box,Map<String, Object> dataMap);

	Map<String, Object> showCylinderUsageEntryJsp(Box box);

	boolean submitCylinderUsageFormEntry(Box box, Map<String, Object> dataMap);

	Map<String, Object> searchCylinderUsageForm(Map<String, Object> searchFieldMap);

	Map<String, Object> modifyCylinderUsageForm(int radio_str, int deptId);

	boolean updateCylinderUsageFormEntry(Box box, Map<String, Object> dataMap);
	
	Map<String, Object> showEquipmentDetailsMasterJsp(int hospitalId);
	
	boolean submitEquipmentEntry(Map<String, Object > objMap);
	
	Map<String, Object> searchEquipmentEntry(Map<String, Object > objMap);
	
	Map<String, Object> searchEquipmentBreakdownEntry(Map<String, Object > objMap);
	
	public Map<String, Object> getEntryListForEquipment(Map<String, Object> searchEntryMap);	
	
	public Map<String, Object> getEquipmentBreakdown(Map<String, Object> searchEntryMap);	


	Map<String, Object>  showEquipmentMaintenanceEntryJsp(Map<String,Object> dataMap );
	
	//Map<String, Object> searchEquipmentMaintenance(Map<String, Object> searchFieldMap);
	
	Map<String,Object> submitEquipmentMaintenanceEntryJsp(Map<String,Object> subMap);
	
	Map<String,Object> searchMaintenanceEntry(Map<String,Object> searchMap);
	
	Map<String,Object> submitEquipmentCallLogEntryJsp(Map<String,Object> subMap);
	
	Map<String, Object>  showEquipmentCallLogEntryJsp(Map<String,Object> dataMap );
	
	Map<String, Object>  showEquipmentBreakdownEntryJsp(Map<String,Object> dataMap );
	
	Map<String, Object>  showEmergencyEquipmentBreakdownCallEntry(Map<String,Object> dataMap );
	
	Map<String,Object> submitEquipmentBreakdownEntryJsp(Map<String,Object> subMap);
	
	Map<String,Object> submitEmergencyEquipmentBreakdownEntryJsp(Map<String,Object> subMap);
	
	Map<String, Object>  showCommunicationJsp(Map<String, Object> dataMap);   //Method for Message Communication
	
	Map<String, Object>  submitCommunicationMessageJsp(Map<String, Object> dataMap);

	Map<String, Object> showEquipmentBreakdownUpdateJsp(Map<String, Object> dataMap);
	
	Map<String, Object> showEquipmentCallLogUpdateJsp(Map<String, Object> dataMap);
	
	Map<String, Object> showEquipmentMaintenanceUpdateJsp(Map<String, Object> dataMap);
	
	//Map<String, Object> showEquipmentMasterModify(Map<String, Object> dataMap);
	
	Map<String, Object> showEquipmentAmcDetails(Map<String, Object> dataMap);
	
	Map<String, Object> showEquipmentMasterModify(Map<String, Object> dataMap);
	
	Map<String,Object> submitEquipmentAMCDetalis(Map<String,Object> dataMap);
	
	Map<String,Object> getEquipmentAMCDetails(Map<String,Object> dataMap);
}
