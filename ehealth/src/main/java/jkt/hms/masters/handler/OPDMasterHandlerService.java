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
import jkt.hms.util.Box;

public interface OPDMasterHandlerService {

	// ****************************************** Start Of OPD Template by Mansi
	// ****************************//

	Map<String, Object> showOpdTemplateJsp(int hospitalId);

	boolean addOpdTemplate(OpdTemplate opdTemplate);

	boolean editOpdTemplateToDatabase(Map<String, Object> generalMap);

	boolean deleteOpdTemplate(int templateId, Map<String, Object> generalMap);

	Map<String, Object> searchOpdTemplate(String templateCode,
			String templateName);

	// ****************************************** End Of OPD Template by Mansi
	// ****************************//

	// ****************************************** Start Of OPD Treatment Holiday
	// by Mansi ****************************//

	Map<String, Object> searchOpdHoliday(String holidayCode, String holidayName);

	Map<String, Object> showOpdHolidayJsp();

	boolean addOpdHoliday(OpdHoliday opdHoliday);

	boolean editOpdHolidayToDatabase(Map<String, Object> generalMap);

	boolean deleteOpdHoliday(int holidayId, Map<String, Object> generalMap);

	// ****************************************** Start Of OPD Treatment Holiday
	// by Mansi ****************************//

	// ****************************************** Start Of OPD Treatment
	// Template by Mansi ****************************//

	Map<String, Object> showOpdTemplateTreatmentJsp(Box box);

	boolean addOpdTemplateTreatment(OpdTemplateTreatment opdTemplateTreatment);
	
	boolean deleteTemplateTreatment(Map generalMap);//Added By OM Tripathi

	boolean editOpdTemplateTreatment(Map<String, Object> generalMap);

	boolean deleteOpdTemplateTreatment(int templateTreatmentId,
			Map<String, Object> generalMap);

	Map<String, Object> searchOpdTemplateTreatment(String templateGroup);

	Map<String, Object> getTemplateGroup(int templateId, int deptId);

	Map<String, Object> fillItemsInGrid(Map<String, Object> dataMap);

	Map<String, Object> getItemList(Map<String, Object> map);

	// ****************************************** End Of OPD Treatment Template
	// by Mansi ****************************//

	Map<String, Object> searchOpdInstructionTreatment(
			String opdInstructionTreatmentCode,
			String opdInstructionTreatmentName);

	Map<String, Object> showOpdInstructionTreatmentJsp();

	boolean addOpdInstructionTreatment(
			OpdInstructionTreatment opdInstructionTreatment);

	boolean editOpdInstructionTreatmentToDatabase(Map<String, Object> generalMap);

	boolean deleteOpdInstructionTreatment(int opdInstructionTreatmentId,
			Map<String, Object> generalMap);

	// ---------------------------------------End of methods by
	// Vikas-----------------------------------

	Map<String, Object> getInvestigationTemplateGroup(int templateId, int deptId);

	Map<String, Object> fillChargeCodeInGrid(Map<String, Object> dataMap);

	Map<String, Object> getChargeCodeList(Map<String, Object> map);

	Map<String, Object> showOpdTemplateInvestigationJsp();

	boolean addOpdTemplateInvestigation(
			OpdTemplateInvestigation opdTemplateInvestigation);

	boolean editOpdTemplateInvestigation(Map<String, Object> generalMap);

	boolean deleteOpdTemplateInvestigation(int templateInvestigationId,
			Map<String, Object> generalMap);

	// -----------------------------Start of Equipment Master by
	// vishal-------------------------------
	// -------------------------Equipment master--------------------------------
	Map<String, Object> searchOpdEquipment(String equipmentCode,
			String equipmentName);

	Map<String, Object> showOpdEquipmentJsp();

	boolean addOpdEquipment(AppEquipmentMaster appEquipmentMaster);

	boolean editOpdEquipmentToDatabase(Map<String, Object> generalMap);

	boolean deleteOpdEquipment(int equipmentId, Map<String, Object> generalMap);

	// -------------------------------Vaccin master---------------------------
	Map<String, Object> searchOpdVaccin(String vaccinCode, String vaccinName);

	Map<String, Object> showOpdVaccinJsp();

	boolean addOpdVaccin(OpdVaccinMst opdVaccin);
	
	Map checkExistingVaccineMaster(Map<String, Object> generalMap);

	boolean editOpdVaccinToDatabase(Map<String, Object> generalMap);

	boolean deleteOpdVaccin(int vaccinId, Map<String, Object> generalMap);

	Map<String, Object> getConnection();

	Map<String, Object> submitModularity(Map<String, Object> modulMap);

	Map<String, Object> showOpdModalityJsp();

	Map<String, Object> searchOpdModality(String modalityCode, String modalityName);

	boolean addOpdModality(MasModularity masModularity);

	boolean editOpdModalityToDatabase(Map<String, Object> generalMap);

	boolean deleteOpdModality(int holidayId, Map<String, Object> generalMap);

	boolean addFrequency(MasOpdFrequency masOpdFrequency);

	Map<String, Object> showFrequencyJsp();
	
	Map<String, Object> getVaccinationList(Box box);

	Map<String, Object> searchFrequency(String frequencyCode,
			String frequencyName);

	boolean editFrequency(Map<String, Object> generalMap);

	boolean deleteFrequency(int frequencyId, Map<String, Object> generalMap);

	Map<String, Object> addOpdExaminationTemplate(Box box);

	Map<String, Object> searchOpdExaminationTemplate(Box box);

	Map<String, Object> showPrescriptionMappingJsp(int hospitalId);

	Map<String, Object> displayAU(Map<String, Object> dataMap);

	Map<String, Object> submitPrescriptionGrid(Box box);

}
