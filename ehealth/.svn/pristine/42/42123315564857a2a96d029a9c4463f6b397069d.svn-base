package jkt.hms.masters.handler;

import java.util.Map;

import jkt.hms.masters.business.AppEquipmentMaster;
import jkt.hms.masters.business.MasModularity;
import jkt.hms.masters.business.MasOpdFrequency;
import jkt.hms.masters.business.OpdHoliday;
import jkt.hms.masters.business.OpdInstructionTreatment;
import jkt.hms.masters.business.OpdTemplate;
import jkt.hms.masters.business.OpdTemplateInvestigation;
import jkt.hms.masters.business.OpdTemplateTreatment;
import jkt.hms.masters.business.OpdVaccinMst;
import jkt.hms.masters.dataservice.OPDMasterDataService;
import jkt.hms.util.Box;

public class OPDMasterHandlerServiceImpl implements OPDMasterHandlerService {

	OPDMasterDataService opdMasterDataService = null;

	// ****************************************** Start Of OPD Template by Mansi
	// ****************************//

	public boolean addOpdTemplate(OpdTemplate opdTemplate) {
		return opdMasterDataService.addOpdTemplate(opdTemplate);
	}

	public boolean deleteOpdTemplate(int templateId,
			Map<String, Object> generalMap) {
		return opdMasterDataService.deleteOpdTemplate(templateId, generalMap);
	}

	public boolean editOpdTemplateToDatabase(Map<String, Object> generalMap) {
		return opdMasterDataService.editOpdTemplateToDatabase(generalMap);
	}

	public Map<String, Object> showOpdTemplateJsp(int hospitalId) {
		return opdMasterDataService.showOpdTemplateJsp(hospitalId);
	}

	public Map<String, Object> searchOpdTemplate(String templateCode,
			String templateName) {
		return opdMasterDataService.searchOpdTemplate(templateCode,
				templateName);
	}

	public boolean addOpdHoliday(OpdHoliday opdHoliday) {
		return opdMasterDataService.addOpdHoliday(opdHoliday);
	}

	public boolean deleteOpdHoliday(int holidayId,
			Map<String, Object> generalMap) {
		return opdMasterDataService.deleteOpdHoliday(holidayId, generalMap);
	}

	public boolean editOpdHolidayToDatabase(Map<String, Object> generalMap) {
		return opdMasterDataService.editOpdHolidayToDatabase(generalMap);
	}

	public Map<String, Object> searchOpdHoliday(String holidayCode,
			String holidayName) {
		return opdMasterDataService.searchOpdHoliday(holidayCode, holidayName);
	}

	public Map<String, Object> showOpdHolidayJsp() {
		return opdMasterDataService.showOpdHolidayJsp();
	}

	public Map<String, Object> showOpdTemplateTreatmentJsp(Box box) {
		return opdMasterDataService.showOpdTemplateTreatmentJsp(box);
	}

	// ****************************************** End Of OPD Template by Mansi
	// ****************************//

	// ****************************************** Start Of OPD Treatment
	// Template by Mansi ****************************//

	public boolean addOpdTemplateTreatment(
			OpdTemplateTreatment opdTemplateTreatment) {
		return opdMasterDataService
				.addOpdTemplateTreatment(opdTemplateTreatment);
	}
	
	public boolean deleteTemplateTreatment(
			Map generalMap) {
		return opdMasterDataService
				.deleteTemplateTreatment(generalMap); //Added By OM Tripathi
	}

	public boolean deleteOpdTemplateTreatment(int templateTreatmentId,
			Map<String, Object> generalMap) {
		return opdMasterDataService.deleteOpdTemplateTreatment(
				templateTreatmentId, generalMap);
	}

	public boolean editOpdTemplateTreatment(Map<String, Object> generalMap) {
		return opdMasterDataService.editOpdTemplateTreatment(generalMap);
	}

	public Map<String, Object> searchOpdTemplateTreatment(String templateGroup) {
		return opdMasterDataService.searchOpdTemplateTreatment(templateGroup);
	}

	public Map<String, Object> getTemplateGroup(int templateId, int deptId) {
		return opdMasterDataService.getTemplateGroup(templateId, deptId);
	}

	public Map<String, Object> fillItemsInGrid(Map<String, Object> dataMap) {
		return opdMasterDataService.fillItemsInGrid(dataMap);
	}

	public Map<String, Object> getItemList(Map<String, Object> map) {
		return opdMasterDataService.getItemList(map);
	}

	// ****************************************** End Of OPD Treatment Template
	// by Mansi ****************************//

	public boolean addOpdInstructionTreatment(
			OpdInstructionTreatment opdInstructionTreatment) {
		return opdMasterDataService
				.addOpdInstructionTreatment(opdInstructionTreatment);
	}

	public boolean deleteOpdInstructionTreatment(int opdInstructionTreatmentId,
			Map<String, Object> generalMap) {
		return opdMasterDataService.deleteOpdInstructionTreatment(
				opdInstructionTreatmentId, generalMap);
	}

	public boolean editOpdInstructionTreatmentToDatabase(
			Map<String, Object> generalMap) {
		return opdMasterDataService
				.editOpdInstructionTreatmentToDatabase(generalMap);
	}

	public Map<String, Object> searchOpdInstructionTreatment(
			String opdInstructionTreatmentCode,
			String opdInstructionTreatmentName) {
		return opdMasterDataService.searchOpdInstructionTreatment(
				opdInstructionTreatmentCode, opdInstructionTreatmentName);
	}

	public Map<String, Object> showOpdInstructionTreatmentJsp() {
		return opdMasterDataService.showOpdInstructionTreatmentJsp();
	}

	// --------------------------------------------End of methods By
	// Vikas-------------------------------------

	public Map<String, Object> getInvestigationTemplateGroup(int templateId,
			int deptId) {
		return opdMasterDataService.getInvestigationTemplateGroup(templateId,
				deptId);
	}

	public Map<String, Object> fillChargeCodeInGrid(Map<String, Object> dataMap) {
		return opdMasterDataService.fillChargeCodeInGrid(dataMap);
	}

	public Map<String, Object> getChargeCodeList(Map<String, Object> map) {
		return opdMasterDataService.getChargeCodeList(map);
	}

	public Map<String, Object> showOpdTemplateInvestigationJsp() {
		return opdMasterDataService.showOpdTemplateInvestigationJsp();
	}

	public boolean addOpdTemplateInvestigation(
			OpdTemplateInvestigation opdTemplateInvestigation) {
		return opdMasterDataService
				.addOpdTemplateInvestigation(opdTemplateInvestigation);
	}

	public boolean deleteOpdTemplateInvestigation(int templateInvestigationId,
			Map<String, Object> generalMap) {
		return opdMasterDataService.deleteOpdTemplateInvestigation(
				templateInvestigationId, generalMap);
	}

	public boolean editOpdTemplateInvestigation(Map<String, Object> generalMap) {
		return opdMasterDataService.editOpdTemplateInvestigation(generalMap);
	}

	public OPDMasterDataService getOpdMasterDataService() {
		return opdMasterDataService;
	}

	public void setOpdMasterDataService(
			OPDMasterDataService opdMasterDataService) {
		this.opdMasterDataService = opdMasterDataService;
	}

	// ****************************************** Start of Equipment Master by
	// vishal****************************//
	// -----------------------Equipment master-------------
	public Map<String, Object> showOpdEquipmentJsp() {
		return opdMasterDataService.showOpdEquipmentJsp();
	}

	public Map<String, Object> searchOpdEquipment(String equipmentCode,
			String equipmentName) {
		return opdMasterDataService.searchOpdEquipment(equipmentCode,
				equipmentName);
	}

	public boolean addOpdEquipment(AppEquipmentMaster appEquipmentMaster) {
		return opdMasterDataService.addOpdEquipment(appEquipmentMaster);
	}

	public boolean editOpdEquipmentToDatabase(Map<String, Object> generalMap) {
		return opdMasterDataService.editOpdEquipmentToDatabase(generalMap);
	}

	public boolean deleteOpdEquipment(int equipmentId,
			Map<String, Object> generalMap) {
		return opdMasterDataService.deleteOpdEquipment(equipmentId, generalMap);
	}

	// ----------------------Vaccin Master--------------------------------------
	public Map<String, Object> showOpdVaccinJsp() {
		return opdMasterDataService.showOpdVaccinJsp();
	}

	public Map<String, Object> searchOpdVaccin(String vaccinCode,
			String vaccinName) {
		return opdMasterDataService.searchOpdVaccin(vaccinCode, vaccinName);
	}

	public boolean addOpdVaccin(OpdVaccinMst opdVaccin) {
		return opdMasterDataService.addOpdVaccin(opdVaccin);
	}
	 
	public boolean editOpdVaccinToDatabase(Map<String, Object> generalMap) {
		return opdMasterDataService.editOpdVaccinToDatabase(generalMap);
	}
	
	public Map checkExistingVaccineMaster(Map<String, Object> generalMap) {
		return opdMasterDataService.checkExistingVaccineMaster(generalMap);
	}

	public boolean deleteOpdVaccin(int vaccinId, Map<String, Object> generalMap) {
		return opdMasterDataService.deleteOpdVaccin(vaccinId, generalMap);
	}

	public Map<String, Object> getConnection() {
		return opdMasterDataService.getConnection();
	}
	public Map<String, Object> submitModularity(Map<String, Object> modulMap)
	{
		return opdMasterDataService.submitModularity(modulMap);
	}
	public Map<String, Object> showOpdModalityJsp() {
		return opdMasterDataService.showOpdModalityJsp();
	}

	public Map<String, Object> searchOpdModality(String modalityCode,
			String modalityName) {
		return opdMasterDataService.searchOpdModality(modalityCode, modalityName);
	}
	public boolean addOpdModality(MasModularity masModularity) {
		return opdMasterDataService.addOpdModality(masModularity);
	}

	public boolean deleteOpdModality(int holidayId,
			Map<String, Object> generalMap) {
		return opdMasterDataService.deleteOpdModality(holidayId, generalMap);
	}

	public boolean editOpdModalityToDatabase(Map<String, Object> generalMap) {
		return opdMasterDataService.editOpdModalityToDatabase(generalMap);
	}

	@Override
	public boolean addFrequency(MasOpdFrequency masOpdFrequency) {
		return opdMasterDataService.addFrequency(masOpdFrequency);
	}

	@Override
	public Map<String, Object> showFrequencyJsp() {
		return opdMasterDataService.showFrequencyJsp();
	}
	
	@Override
	public Map<String, Object> getVaccinationList(Box box) { 
		return opdMasterDataService.getVaccinationList(box);
	}

	@Override
	public Map<String, Object> searchFrequency(String frequencyCode,
			String frequencyName) {
		return opdMasterDataService.searchFrequency(frequencyCode, frequencyName);
	}

	@Override
	public boolean editFrequency(Map<String, Object> generalMap) {
		return opdMasterDataService.editFrequency(generalMap);
	}

	@Override
	public boolean deleteFrequency(int frequencyId,
			Map<String, Object> generalMap) {
		return opdMasterDataService.deleteFrequency(frequencyId, generalMap);
	}

	@Override
	public Map<String, Object> addOpdExaminationTemplate(Box box) {
		
		return opdMasterDataService.addOpdExaminationTemplate(box);
	}

	@Override
	public Map<String, Object> searchOpdExaminationTemplate(Box box) {
		
		return opdMasterDataService.searchOpdExaminationTemplate(box);
	}

	@Override
	public Map<String, Object> showPrescriptionMappingJsp(int hospitalId) {
		return opdMasterDataService.showPrescriptionMappingJsp(hospitalId);
	}

	@Override
	public Map<String, Object> displayAU(Map<String, Object> dataMap) {
		return opdMasterDataService.displayAU(dataMap);
	}

	@Override
	public Map<String, Object> submitPrescriptionGrid(Box box) {
		return opdMasterDataService.submitPrescriptionGrid(box);
	}


}