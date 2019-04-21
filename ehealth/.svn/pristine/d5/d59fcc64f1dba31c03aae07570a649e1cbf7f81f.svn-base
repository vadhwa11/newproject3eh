package jkt.hms.hes.handler;

import java.util.Map;
import jkt.hms.hes.dataservice.HesDataService;
import jkt.hms.masters.business.HesCylinderTypeMaster;
import jkt.hms.masters.business.HesCylinderUsageMaster;
import jkt.hms.masters.business.HesEquipmentEmergencyMaintenanceBreakdown;
import jkt.hms.masters.business.HesMaintenanceJobMaster;
import jkt.hms.masters.business.HesWorkParticularMaster;
import jkt.hms.util.Box;

public  class HesHandlerServiceImpl implements HesHandlerService
{
	HesDataService hesDataService = null;

	public HesDataService getHesDataService() {
		return hesDataService;
	}

	public void setHesDataService(HesDataService hesDataService) {
		this.hesDataService = hesDataService;
	}

	@Override
	public boolean addWorkParticularData(HesWorkParticularMaster hesWork) {
		return hesDataService.addWorkParticularData(hesWork);
	}

	@Override
	public Map<String, Object> searchWorkParticular(String countryCode,String countryName)
	{
		return hesDataService.searchWorkParticular(countryCode,countryName);
	}
	
	public Map<String, Object> searchEmergencyEquipmentBreakdown(String departmentName)
	{
		return hesDataService.searchEmergencyEquipmentBreakdown(departmentName);
	}

	@Override
	public boolean editWorkParticularToDatabase(Map<String, Object> generalMap) {
		return hesDataService.editWorkParticularToDatabase(generalMap);
	}

	@Override
	public boolean deleteWorkParticularMaster(int workId,Map<String, Object> generalMap)
	{
		return hesDataService.deleteWorkParticularMaster(workId,generalMap);
	}

	public boolean deleteEmergencyEquipmentBreakdown(int equipmentBreakId,Map<String, Object> generalMap)
	{
		return hesDataService.deleteEmergencyEquipmentBreakdown(equipmentBreakId,generalMap);
	}
	@Override
	public Map<String, Object> showMinorRoutineWorkJsp(Box box) {
		return hesDataService.showMinorRoutineWorkJsp(box);
	}

	@Override
	public Map<String, Object> getItemNamesForAutocomplete(Map<String, Object> dataMap)
	{
		return hesDataService.getItemNamesForAutocomplete(dataMap);
	}

	@Override
	public Map<String, Object> getItemClosingStock(Map<String, Object> dataMap) {
		return hesDataService.getItemClosingStock(dataMap);
	}

	@Override
	public boolean submitMinorRoutineWorksEntry(Box box,Map<String, Object> dataMap)
	{
		return hesDataService.submitMinorRoutineWorksEntry(box,dataMap);
	}
	
	@Override
	public Map<String, Object> searchMinorRoutine(Map<String, Object> searchFieldMap) {
		return hesDataService.searchMinorRoutine(searchFieldMap);
	}

	@Override
	public Map<String, Object> modifyMinorRoutine(int radio_str,int deptId) {
		return hesDataService.modifyMinorRoutine(radio_str,deptId);
	}

	@Override
	public Map<String, Object> showWorkParticularMasterJsp() {
		return hesDataService.showWorkParticularMasterJsp();
	}

	@Override
	public boolean updateMinorRoutineWorksEntry(Box box,Map<String, Object> dataMap) {
		return hesDataService.updateMinorRoutineWorksEntry(box,dataMap);
	}

	@Override
	public Map<String, Object> showCylinderTypeMasterJsp() {
		return hesDataService.showCylinderTypeMasterJsp();
	}

	@Override
	public boolean addCylinderType(HesCylinderTypeMaster cylinderTypeMaster) {
		return hesDataService.addCylinderType(cylinderTypeMaster);
	}

	@Override
	public boolean editCylinderType(Map<String, Object> generalMap) {
		return hesDataService.editCylinderType(generalMap);
	}

	@Override
	public boolean deleteCylinderType(int cylinderId,Map<String, Object> generalMap) {
		return hesDataService.deleteCylinderType(cylinderId,generalMap);
	}

	@Override
	public Map<String, Object> searchCylinderType(String cylinderTypeCode,String cylinderTypeName) {
		return hesDataService.searchCylinderType(cylinderTypeCode,cylinderTypeName);
	}

	@Override
	public Map<String, Object> showEmptyCylinderRequestJsp(Box box) {
		return hesDataService.showEmptyCylinderRequestJsp(box);
	}

	@Override
	public boolean submitEmptyCylinderDispatchEntry(Box box,Map<String, Object> dataMap) {
		return hesDataService.submitEmptyCylinderDispatchEntry(box,dataMap);
	}

	@Override
	public Map<String, Object> searchEmptyCylinderDispatchForm(	Map<String, Object> searchFieldMap) {
		return hesDataService.searchEmptyCylinderDispatchForm(searchFieldMap);
	}

	public Map<String, Object> searchEquipmentBreakdownForm(Map<String, Object> searchFieldMap) {
		return hesDataService.searchEquipmentBreakdownForm(searchFieldMap);
	}
	
	
	public Map<String, Object> searchEquipmentCallLogEntryForm(Map<String, Object> searchFieldMap) {
		return hesDataService.searchEquipmentCallLogEntryForm(searchFieldMap);
	}
	
	public Map<String, Object> searchEquipmentMaintenanceForm(Map<String, Object> searchFieldMap) {
		return hesDataService.searchEquipmentMaintenanceForm(searchFieldMap);
	}
	
	@Override
	public Map<String, Object> modifyEmptyCylinderDispatchForm(int radio_str,int deptId) {
		return hesDataService.modifyEmptyCylinderDispatchForm(radio_str,deptId);
	}
	
	public boolean modifyEquipmentBreakdown(Map<String, Object> generalMap){
		return hesDataService.modifyEquipmentBreakdown(generalMap);
	}
	
	public boolean modifyCallLogEntry(Map<String, Object> generalMap){
		return hesDataService.modifyCallLogEntry(generalMap);
	}
    
	public boolean modifyMaintenanceEntry(Map<String, Object> generalMap){
		return hesDataService.modifyMaintenanceEntry(generalMap);
	}

	@Override
	public boolean updateEmptyCylinderDispatchEntry(Box box,Map<String, Object> dataMap) {
		return hesDataService.updateEmptyCylinderDispatchEntry(box,dataMap);
	}
	
	

	@Override
	public Map<String, Object> getCylinderClosingStock(Map<String, Object> dataMap) {
		return hesDataService.getCylinderClosingStock(dataMap);
	}

	@Override
	public Map<String, Object> showCylinderUsageMasterJsp() {
		return hesDataService.showCylinderUsageMasterJsp();
	}

	@Override
	public boolean addCylinderUsage(HesCylinderUsageMaster master) {
		return hesDataService.addCylinderUsage(master);
	}
	
	public boolean addEquipmentBreakdownEntry(HesEquipmentEmergencyMaintenanceBreakdown master , int equipmentBreakdownId) {
		return hesDataService.addEquipmentBreakdownEntry(master,equipmentBreakdownId);
	}

	@Override
	public boolean editCylinderUsage(Map<String, Object> generalMap) {
		return hesDataService.editCylinderUsage(generalMap);
	}
	
	public boolean editEquipmentBreakdownEntryInEmergency(Map<String, Object> generalMap) {
		return hesDataService.editEquipmentBreakdownEntryInEmergency(generalMap);
	}

	@Override
	public boolean deleteCylinderUsage(int cylinderId,Map<String, Object> generalMap) {
		return hesDataService.deleteCylinderUsage(cylinderId,generalMap);
	}

	@Override
	public Map<String, Object> searchCylinderUsage(String cylinderUsageCode,String cylinderUsageName){
		return hesDataService.searchCylinderUsage(cylinderUsageCode,cylinderUsageName);
	}

	@Override
	public Map<String, Object> showMaintenanceJobMasterJsp() {
		return hesDataService.showMaintenanceJobMasterJsp();
	}

	@Override
	public boolean addMaintenanceType(HesMaintenanceJobMaster master) {
		return hesDataService.addMaintenanceType(master);
	}

	@Override
	public boolean deleteMaintenanceType(int cylinderId,Map<String, Object> generalMap) {
		return hesDataService.deleteMaintenanceType(cylinderId,generalMap);
	}

	@Override
	public boolean editMaintenanceType(Map<String, Object> generalMap) {
		return hesDataService.editMaintenanceType(generalMap);
	}

	@Override
	public Map<String, Object> searchMaintenanceType(String maintenanceCode,String maintenanceName) {
		return hesDataService.searchMaintenanceType(maintenanceCode,maintenanceName);
	}

	@Override
	public Map<String, Object> showRefilledCylinderRequestJsp(Box box) {
		return hesDataService.showRefilledCylinderRequestJsp(box);
	}

	@Override
	public boolean submitRefilledCylinderDeliveryEntry(Box box,	Map<String, Object> dataMap) {
		return hesDataService.submitRefilledCylinderDeliveryEntry(box,dataMap);
	}

	@Override
	public Map<String, Object> searchRefilledCylinderDeliveryForm(Map<String, Object> searchFieldMap) {
		return hesDataService.searchRefilledCylinderDeliveryForm(searchFieldMap);
	}

	@Override
	public Map<String, Object> modifyRefilledCylinderDeliveryForm(int radio_str, int deptId) {
		return hesDataService.modifyRefilledCylinderDeliveryForm(radio_str,deptId);
	}

	@Override
	public boolean updateRefilledCylinderDeliveryEntry(Box box,Map<String, Object> dataMap) {
		return hesDataService.updateRefilledCylinderDeliveryEntry(box,dataMap);
	}

	@Override
	public Map<String, Object> showCylinderUsageEntryJsp(Box box) {
		return hesDataService.showCylinderUsageEntryJsp(box);
	}

	@Override
	public boolean submitCylinderUsageFormEntry(Box box,Map<String, Object> dataMap) {
		return hesDataService.submitCylinderUsageFormEntry(box,dataMap);
	}

	@Override
	public Map<String, Object> searchCylinderUsageForm(Map<String, Object> searchFieldMap) {
		return hesDataService.searchCylinderUsageForm(searchFieldMap);
	}

	@Override
	public Map<String, Object> modifyCylinderUsageForm(int radio_str, int deptId) {
		return hesDataService.modifyCylinderUsageForm(radio_str,deptId);
	}

	@Override
	public boolean updateCylinderUsageFormEntry(Box box,Map<String, Object> dataMap) {
		return hesDataService.updateCylinderUsageFormEntry(box,dataMap);
	}
	
	@Override
	public Map<String, Object> showEquipmentDetailsMasterJsp(int hospitalId) {
		return hesDataService.showEquipmentDetailsMasterJsp(hospitalId);
	}
	
	public boolean submitEquipmentEntry(Map<String,Object> objMap ){
		return hesDataService.submitEquipmentEntry(objMap);
	}
	public Map<String, Object> getEntryListForEquipment(Map<String, Object> searchEntryMap){
	    return hesDataService.getEntryListForEquipment(searchEntryMap);
	}
	public Map<String, Object> getEquipmentBreakdown(Map<String, Object> searchEntryMap){
	    return hesDataService.getEquipmentBreakdown(searchEntryMap);
	}
	
	public Map<String, Object> searchEquipmentEntry(Map<String, Object> searchFieldMap){
		return hesDataService.searchEquipmentEntry(searchFieldMap);
	}
	public Map<String,Object> showEquipmentMaintenanceEntryJsp(Map<String, Object> showMap){
		return hesDataService.showEquipmentMaintenanceEntryJsp(showMap);
	}
	
	
	public Map<String, Object>  submitEquipmentMaintenanceEntryJsp(Map<String, Object> subMap){
		return hesDataService.submitEquipmentMaintenanceEntryJsp(subMap);
	}
	
	public Map<String,Object> showEquipmentCallLogEntryJsp(Map<String, Object> showMap){
		return hesDataService.showEquipmentCallLogEntryJsp(showMap);
	}
	
	public Map<String,Object> showEmergencyEquipmentBreakdownCallEntry(Map<String, Object> showMap){
		return hesDataService.showEmergencyEquipmentBreakdownCallEntry(showMap);
	}
	
	
	public Map<String, Object>  submitEquipmentCallLogEntryJsp(Map<String, Object> subMap){
		return hesDataService.submitEquipmentCallLogEntryJsp(subMap);
	}
	
	public Map<String, Object>  submitEquipmentBreakdownEntryJsp(Map<String, Object> subMap){
		return hesDataService.submitEquipmentBreakdownEntryJsp(subMap);
	}
	
	public Map<String, Object>  submitEmergencyEquipmentBreakdownEntryJsp(Map<String, Object> subMap){
		return hesDataService.submitEmergencyEquipmentBreakdownEntryJsp(subMap);
	}
	
	public Map<String, Object> searchEquipmentBreakdownEntry(Map<String, Object> searchFieldMap){
		return hesDataService.searchEquipmentBreakdownEntry(searchFieldMap);
	}
	
	/*public Map<String, Object> searchEquipmentMaintenance(Map<String, Object> searchFieldMap) {
		return hesDataService.searchEquipmentMaintenance(searchFieldMap);
	}*/
	
	public Map<String, Object>  searchMaintenanceEntry(Map<String, Object> searchMap){
		return hesDataService.searchMaintenanceEntry(searchMap);
	}
	public Map<String,Object> showEquipmentBreakdownEntryJsp(Map<String, Object> showMap){
		return hesDataService.showEquipmentBreakdownEntryJsp(showMap);
	}
	public Map<String,Object> showCommunicationJsp(Map<String, Object> dataMap){
		return hesDataService.showCommunicationJsp(dataMap);
	}
	public Map<String, Object>  submitCommunicationMessageJsp(Map<String, Object> dataMap){
		return hesDataService.submitCommunicationMessageJsp(dataMap);
	}

	@Override
	public Map<String, Object> showEquipmentBreakdownUpdateJsp(Map<String, Object> dataMap) {
		return hesDataService.showEquipmentBreakdownUpdateJsp(dataMap);
	}
	
	public Map<String, Object> showEquipmentCallLogUpdateJsp(Map<String, Object> dataMap) {
		return hesDataService.showEquipmentCallLogUpdateJsp(dataMap);
	}
	
	public Map<String, Object> showEquipmentMaintenanceUpdateJsp(Map<String, Object> dataMap) {
		return hesDataService.showEquipmentMaintenanceUpdateJsp(dataMap);
	}
	
	/*public Map<String, Object> showEquipmentMasterModify(Map<String, Object> dataMap) {
		return hesDataService.showEquipmentMasterModify(dataMap);
	}*/
	
	public Map<String, Object> showEquipmentAmcDetails(Map<String, Object> dataMap) {
		return hesDataService.showEquipmentAmcDetails(dataMap);
	}
	
	public Map<String,Object> showEquipmentMasterModify(Map<String, Object> dataMap){
		return hesDataService.showEquipmentMasterModify(dataMap);
	}
	
	public Map<String, Object>  submitEquipmentAMCDetalis(Map<String, Object> dataMap){
		return hesDataService.submitEquipmentAMCDetalis(dataMap);
	}
	
	public Map<String, Object>  getEquipmentAMCDetails(Map<String, Object> dataMap){
		return hesDataService.getEquipmentAMCDetails(dataMap);
	}
	
	
}
