package jkt.hms.pubHealth.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.LocationParameterMapping;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHospitalType;
import jkt.hms.masters.business.PhSyndromicSurvcillenceMapping;
import jkt.hms.pubHealth.dataservice.PubHealthDataService;
import jkt.hms.util.Box;

public class PubHealthHandlerServiceImpl implements PubHealthHandlerService {

	PubHealthDataService pubHealthDataService = null;

	public PubHealthDataService getPubHealthDataService() {
		return pubHealthDataService;
	}

	public void setPubHealthDataService(
			PubHealthDataService pubHealthDataService) {
		this.pubHealthDataService = pubHealthDataService;
	}

	// @Override
	public Map<String, Object> showDayBlockAllocationJsp(int hospitalId) {

		return pubHealthDataService.showDayBlockAllocationJsp(hospitalId);
	}

	// @Override
	public Map<String, Object> fillLoc(String val,
			Map<String, Object> detailsMap) {
		return pubHealthDataService.fillLoc(val, detailsMap);
	}

	// @Override
	public Map<String, Object> showAdvanceTourPlanJPHNAndJHIJsp(int hospitalId) {
		return pubHealthDataService
				.showAdvanceTourPlanJPHNAndJHIJsp(hospitalId);
	}

	// @Override
	public Map<String, Object> saveDayBlockAllocation(
			Map<String, Object> detailsMap) {
		return pubHealthDataService.saveDayBlockAllocation(detailsMap);
	}

	// @Override
	public Map<String, Object> getDayBlockId(Map<String, Object> detailsMap) {
		return pubHealthDataService.getDayBlockId(detailsMap);
	}

	// @Override
	public Map<String, Object> showAtpJphnJhiJsp(Map<String, Object> detailsMap) {
		return pubHealthDataService.showAtpJphnJhiJsp(detailsMap);
	}

	// @Override
	public Map<String, Object> submitAtpJphnJhi(Box box) {
		return pubHealthDataService.submitAtpJphnJhi(box);
	}

	// @Override
	public Map<String, Object> getAtpJphnJhiDetail(
			Map<String, Object> detailsMap) {
		return pubHealthDataService.getAtpJphnJhiDetail(detailsMap);
	}

	// @Override
	public Map<String, Object> showAtpJphnJhiApprovalJsp(int hospitalId) {
		return pubHealthDataService.showAtpJphnJhiApprovalJsp(hospitalId);
	}

	// @Override
	public Map<String, Object> submitAtpJphnJhiApproval(Box box) {
		return pubHealthDataService.submitAtpJphnJhiApproval(box);
	}

	// @Override
	public Map<String, Object> showSchoolAnganwadiRegistrationJsp(Box box) {
		return pubHealthDataService.showSchoolAnganwadiRegistrationJsp(box);
	}

	// @Override
	public Map<String, Object> submitSchoolAnganwadiRegistration(Box box) {
		return pubHealthDataService.submitSchoolAnganwadiRegistration(box);
	}

	// @Override
	public Map<String, Object> getNameList(Map<String, Object> dataMap) {
		return pubHealthDataService.getNameList(dataMap);
	}

	// @Override
	public Map<String, Object> getNameDetailList(Map<String, Object> dataMap) {
		return pubHealthDataService.getNameDetailList(dataMap);
	}

	// @Override
	public Map<String, Object> showStudentRegistrationJsp(Box box) {
		return pubHealthDataService.showStudentRegistrationJsp(box);
	}

	// @Override
	public Map<String, Object> getAnganwadiNameList(Map<String, Object> dataMap) {
		return pubHealthDataService.getAnganwadiNameList(dataMap);
	}

	// @Override
	public Map<String, Object> populateSection(Map<String, Object> dataMap) {
		return pubHealthDataService.populateSection(dataMap);
	}

	// @Override
	public Map<String, Object> getMemberSurveyList(Map<String, Object> dataMap) {
		return pubHealthDataService.getMemberSurveyList(dataMap);
	}

	// @Override
	public Map<String, Object> getValueMemberSurvey(Map<String, Object> dataMap) {
		return pubHealthDataService.getValueMemberSurvey(dataMap);
	}

	// @Override
	public Map<String, Object> uploadExcel(Map<String, Object> infoMap) {
		return pubHealthDataService.uploadExcel(infoMap);
	}

	// @Override
	public Map<String, Object> addorUpdateStudentRescord(
			Map<String, Object> infoMap) {
		return pubHealthDataService.addorUpdateStudentRescord(infoMap);
	}

	// @Override
	public Map<String, Object> submitStudentRegistration(Box box) {
		return pubHealthDataService.submitStudentRegistration(box);
	}

	// @Override
	public Map<String, Object> showImmunizationJsp(Box box) {

		return pubHealthDataService.showImmunizationJsp(box);
	}

	// @Override
	public Map<String, Object> searchImmunizationDetail(Box box) {

		return pubHealthDataService.searchImmunizationDetail(box);
	}

	// @Override
	public Map<String, Object> showVaccineDetailJsp(Box box) {
		// TODO Auto-generated method stub
		return pubHealthDataService.showVaccineDetailJsp(box);
	}

	// @Override
	public Map<String, Object> submitVaccineDetail(Box box) {
		// TODO Auto-generated method stub
		return pubHealthDataService.submitVaccineDetail(box);
	}

	// @Override
	public Map<String, Object> showJphnAndJhiMonthlyObservationsJsp(
			int hospitalId) {
		return pubHealthDataService
				.showJphnAndJhiMonthlyObservationsJsp(hospitalId);
	}

	// @Override
	public Map<String, Object> submitJphniJhi(Box box) {
		return pubHealthDataService.submitJphniJhi(box);
	}

	// @Override
	public Map<String, Object> generateStudentExcel(Map<String, Object> infoMap) {
		return pubHealthDataService.generateStudentExcel(infoMap);
	}

	// @Override
	public Map<String, Object> getMonths(Map<String, Object> dataMap) {
		return pubHealthDataService.getMonths(dataMap);
	}

	// @Override
	public Map<String, Object> showPhMappingJsp(Box box) {

		return pubHealthDataService.showPhMappingJsp(box);
	}

	// @Override
	public Map<String, Object> getPhcList(Box box) {

		return pubHealthDataService.getPhcList(box);
	}

	// @Override
	public Map<String, Object> getSubCenterList(Box box) {

		return pubHealthDataService.getSubCenterList(box);
	}

	// @Override
	public Map<String, Object> getbasicSectionList(Box box) {

		return pubHealthDataService.getbasicSectionList(box);
	}

	// @Override
	public Map<String, Object> getParametersList(Box box) {

		return pubHealthDataService.getParametersList(box);
	}

	@Override
	public Map<String, Object> showAtPhnJhiPrepairAndSubmmitJsp(
			Map<String, Object> detailMap) {

		return pubHealthDataService.showAtPhnJhiPrepairAndSubmmitJsp(detailMap);
	}

	// @Override
	public Map<String, Object> getDtailThroughDate(Box box) {

		return pubHealthDataService.getDtailThroughDate(box);
	}

	// @Override
	public Map<String, Object> addApproveSubmit(Box box) {
		// TODO Auto-generated method stub
		return pubHealthDataService.addApproveSubmit(box);
	}

	// @Override
	public Map<String, Object> datewiseCompletion(Box box) {

		return pubHealthDataService.datewiseCompletion(box);
	}

	// @Override
	public Map<String, Object> getDtailThroughDate(Map<String, Object> detailMap) {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
	public Map<String, Object> saveDailyWork(Box box) {

		return pubHealthDataService.saveDailyWork(box);
	}

	// @Override
	public Map<String, Object> getlocality(Box box) {
		// TODO Auto-generated method stub
		return pubHealthDataService.getlocality(box);
	}

	// @Override
	public Map<String, Object> getTalukList(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pubHealthDataService.getTalukList(dataMap);
	}

	// @Override
	public Map<String, Object> getvilageList(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pubHealthDataService.getvilageList(dataMap);
	}

	// @Override
	public Map<String, Object> getWardList(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pubHealthDataService.getWardList(dataMap);
	}

	// @Override
	public Map<String, Object> getlocalityList(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pubHealthDataService.getlocalityList(dataMap);
	}

	// @Override
	public Map<String, Object> getParalamentList(Box box) {
		// TODO Auto-generated method stub
		return pubHealthDataService.getParalamentList(box);
	}

	// @Override
	public Map<String, Object> getAssamblyList(Box box) {
		// TODO Auto-generated method stub
		return pubHealthDataService.getAssamblyList(box);
	}

	// @Override
	public Map<String, Object> getLsgiList(Box box) {

		return pubHealthDataService.getLsgiList(box);
	}

	// @Override
	public Map<String, Object> getElectrickSectionList(Box box) {
		// TODO Auto-generated method stub
		return pubHealthDataService.getElectrickSectionList(box);
	}

	// @Override
	public Map<String, Object> getPostOfficeList(Box box) {
		// TODO Auto-generated method stub
		return pubHealthDataService.getPostOfficeList(box);
	}

	// @Override
	public Map<String, Object> saveIntoLocationParameter(
			LocationParameterMapping locmaPing) {
		// TODO Auto-generated method stub
		return pubHealthDataService.saveIntoLocationParameter(locmaPing);
	}

	// @Override
	public Map<String, Object> showPublicHealthHouseSurveyJsp(Box box,
			Map<String, Object> details) {
		return pubHealthDataService
				.showPublicHealthHouseSurveyJsp(box, details);
	}

	// @Override
	public Map<String, Object> phFamilySurveys(Box box,
			Map<String, Object> details) {
		return pubHealthDataService.phFamilySurveys(box, details);
	}

	// @Override
	public Map<String, Object> getDistrictList(Box box) {
		// TODO Auto-generated method stub
		return pubHealthDataService.getDistrictList(box);
	}

	// @Override
	public Map<String, Object> getDistrictForAssamblyList(Box box) {
		// TODO Auto-generated method stub
		return pubHealthDataService.getDistrictForAssamblyList(box);
	}

	// @Override
	public Map<String, Object> getDistrictForLsgList(Box box) {
		// TODO Auto-generated method stub
		return pubHealthDataService.getDistrictForLsgList(box);
	}

	// @Override
	public Map<String, Object> getDistrictForElectricalSecList(Box box) {
		// TODO Auto-generated method stub
		return pubHealthDataService.getDistrictForElectricalSecList(box);
	}

	// @Override
	public Map<String, Object> getDistrictForPostOfficeList(Box box) {
		// TODO Auto-generated method stub
		return pubHealthDataService.getDistrictForPostOfficeList(box);
	}

	// @Override
	public Map<String, Object> updateInlocationParameter(
			LocationParameterMapping locmaPingMap,Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pubHealthDataService.updateInlocationParameter(locmaPingMap, dataMap);
	}

	// @Override
	public Map<String, Object> phEligibleCouple(Box box,
			Map<String, Object> details) {
		return pubHealthDataService.phEligibleCouple(box, details);
	}

	// @Override
	public Map<String, Object> getTalukForElSectionList(
			Map<String, Object> dataMap) {

		return pubHealthDataService.getTalukForElSectionList(dataMap);
	}

	// @Override
	public Map<String, Object> getvilageElSectionList(
			Map<String, Object> dataMap) {
		return pubHealthDataService.getvilageElSectionList(dataMap);
	}

	// @Override
	public Map<String, Object> showPublicHealthVillageSurveyJsp(
			Map<String, Object> details) {

		return pubHealthDataService.showPublicHealthVillageSurveyJsp(details);
	}

	// @Override
	public Map<String, Object> searChPublicHealthVillageSurveyJsp(Box box) {

		return pubHealthDataService.searChPublicHealthVillageSurveyJsp(box);
	}

	// @Override
	public Map<String, Object> getMonthsForApprve(Map<String, Object> dataMap) {

		return pubHealthDataService.getMonthsForApprve(dataMap);
	}

	// @Override
	public Map<String, Object> getDetailByName(Box box) {

		return pubHealthDataService.getDetailByName(box);
	}

	// @Override
	public Map<String, Object> getDistrictBesickSectionList(Box box) {

		return pubHealthDataService.getDistrictBesickSectionList(box);
	}

	// @Override
	public Map<String, Object> getBesicSectionlist(Map<String, Object> dataMap) {

		return pubHealthDataService.getBesicSectionlist(dataMap);
	}

	// @Override
	public Map<String, Object> getSubcenterList(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pubHealthDataService.getSubcenterList(dataMap);
	}

	// @Override
	public Map<String, Object> getMonthsAndVisit(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pubHealthDataService.getMonthsAndVisit(dataMap);
	}

	// @Override
	public Map<String, Object> getlistbyVisit(Box box) {
		// TODO Auto-generated method stub
		return pubHealthDataService.getlistbyVisit(box);
	}

	// @Override
	public Map<String, Object> submitStatus(Box box) {

		return pubHealthDataService.submitStatus(box);
	}

	// @Override
	public Map<String, Object> submitHSAndMOapproval(Box box) {
		// TODO Auto-generated method stub
		return pubHealthDataService.submitHSAndMOapproval(box);
	}

	// @Override
	public Map<String, Object> showAshaWorker(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return pubHealthDataService.showAshaWorker(map);
	}

	// @Override
	public Map<String, Object> getAshaworkerDetail(Box box) {
		// TODO Auto-generated method stub
		return pubHealthDataService.getAshaworkerDetail(box);
	}

	// @Override
	public Map<String, Object> getRegistrationDetail(Box box) {

		return pubHealthDataService.getRegistrationDetail(box);
	}

	// @Override
	public Map<String, Object> getBirthRegistration(Box box) {

		return pubHealthDataService.getBirthRegistration(box);
	}

	// @Override
	public Map<String, Object> getDeathRegistration(Box box) {

		return pubHealthDataService.getDeathRegistration(box);
	}

	// @Override
	public Map<String, Object> getAncRegistration(Box box) {

		return pubHealthDataService.getAncRegistration(box);
	}

	// @Override
	public Map<String, Object> getEcRegistration(Box box) {

		return pubHealthDataService.getEcRegistration(box);
	}

	// @Override
	public Map<String, Object> getFamilyPalRegistration(Box box) {
		// TODO Auto-generated method stub
		return pubHealthDataService.getFamilyPalRegistration(box);
	}

	// @Override
	public Map<String, Object> getCDRRegistration(Box box) {

		return pubHealthDataService.getCDRRegistration(box);
	}

	// @Override
	public Map<String, Object> getNonCDRRegistration(Box box) {

		return pubHealthDataService.getNonCDRRegistration(box);
	}

	// @Override
	public Map<String, Object> getConnectionForReport() {
		// TODO Auto-generated method stub
		return pubHealthDataService.getConnectionForReport();
	}

	// @Override
	public Map<String, Object> runDilevery_detail_Procedure(int hospitalId) {

		return pubHealthDataService.runDilevery_detail_Procedure(hospitalId);
	}

	// @Override
	public Map<String, Object> runDelivryPlaceProcedure(String fromDate, String toDate) {

		return pubHealthDataService.runDelivryPlaceProcedure(fromDate, toDate);
	}

	// @Override
	public Map<String, Object> getDistrictList() {

		return pubHealthDataService.getDistrictList();
	}

	// @Override
	public Map<String, Object> getchclist(Box box) {

		return pubHealthDataService.getchclist(box);
	}

	// @Override
	public Map<String, Object> getBasicCenterList(Box box) {

		return pubHealthDataService.getBasicCenterList(box);
	}

	// @Override
	public Map<String, Object> getSurveyCount(Box box) {
		// TODO Auto-generated method stub
		return pubHealthDataService.getSurveyCount(box);
	}

	// @Override
	public Map<String, Object> sendMailOfSurvey(Box box) {

		return pubHealthDataService.sendMailOfSurvey(box);
	}

	// VK
	// @Override
	public Map<String, Object> showTransferMemberJsp(Box box) {

		return pubHealthDataService.showTransferMemberJsp(box);
	}

	// @Override
	public Map<String, Object> detailTransferMember(Box box,
			Map<String, Object> details) {
		return pubHealthDataService.detailTransferMember(box, details);
	}

	// @Override
	public Map<String, Object> addNewTransferMember(Box box) {
		return pubHealthDataService.addNewTransferMember(box);

	}

	// KM
	// @Override
	public Map<String, Object> showApplockPassword(Box box) {

		return pubHealthDataService.showApplockPassword(box);
	}

	// @Override
	public Map<String, Object> detailApplockPassword(Box box,
			Map<String, Object> details) {
		return pubHealthDataService.detailApplockPassword(box, details);
	}

	// @Override
	public Map<String, Object> showJHIJPHNHouseSurveyJsp(Box box,
			Map<String, Object> details) {

		return pubHealthDataService.showJHIJPHNHouseSurveyJsp(box, details);
	}

	// @Override
	public Map<String, Object> showHouseSurveyINDistrict(Box box,
			Map<String, Object> details) {

		return pubHealthDataService.showHouseSurveyINDistrict(box, details);
	}

	// @Override
	public Map<String, Object> getVillageListHouseSurvey(
			Map<String, Object> dataMap) {

		return pubHealthDataService.getVillageListHouseSurvey(dataMap);
	}

	// @Override
	public Map<String, Object> showHouseSurveyInStateJsp(Box box,
			Map<String, Object> details) {

		return pubHealthDataService.showHouseSurveyInStateJsp(box, details);
	}

	// @Override
	public Map<String, Object> getTalukListHouseSurvey(
			Map<String, Object> dataMap) {

		return pubHealthDataService.getTalukListHouseSurvey(dataMap);
	}

	// @Override
	public Map<String, Object> phMemberSurvey(Box box,
			Map<String, Object> details) {

		return pubHealthDataService.phMemberSurvey(box, details);
	}

	// @Override
	public Map<String, Object> getTalukForTransferedMemberList(
			Map<String, Object> dataMap) {
		return pubHealthDataService.getTalukForTransferedMemberList(dataMap);
	}

	// @Override
	public Map<String, Object> getVillageForTransferedMemberList(
			Map<String, Object> dataMap) {
		return pubHealthDataService.getVillageForTransferedMemberList(dataMap);
	}

	// @Override
	public Map<String, Object> getWardForTransferedMemberList(
			Map<String, Object> dataMap) {
		return pubHealthDataService.getWardForTransferedMemberList(dataMap);
	}

	// @Override
	public Map<String, Object> getSubCentreForTransferedMemberList(
			Map<String, Object> dataMap) {
		return pubHealthDataService
				.getSubCentreForTransferedMemberList(dataMap);
	}

	// @Override
	public Map<String, Object> showPhOpdMainJsp(Box box) {
		return pubHealthDataService.showPhOpdMainJsp(box);
	}

	// @Override
	public Map<String, Object> getClassList(Map<String, Object> dataMap) {
		return pubHealthDataService.getClassList(dataMap);
	}

	// @Override
	public Map<String, Object> getSectionList(Map<String, Object> dataMap) {
		return pubHealthDataService.getSectionList(dataMap);
	}

	// @Override
	public Map<String, Object> getPhStudentRegistrationOpdMainList(
			Map<String, Object> dataMap) {
		return pubHealthDataService
				.getPhStudentRegistrationOpdMainList(dataMap);
	}

	// @Override
	public Map<String, Object> getValueStudentRegistration(Box box) {
		return pubHealthDataService.getValueStudentRegistration(box);
	}

	// @Override
	public Map<String, Object> fillDataForDistrictHospitalType(
			Map<String, Object> dataMap) {
		return pubHealthDataService.fillDataForDistrictHospitalType(dataMap);
	}

	// @Override
	public Map<String, Object> showDepartmentSpeciality(Map<String, Object> map) {
		return pubHealthDataService.showDepartmentSpeciality(map);
	}

	// @Override
	public Map showGroupAndParameterValues(Map generalMap) {
		return pubHealthDataService.showGroupAndParameterValues(generalMap);
	}

	// @Override
	public Map<String, Object> saveSpeciality(Map<String, Object> mapForDS) {
		return pubHealthDataService.saveSpeciality(mapForDS);
	}

	// @Override
	public Map<String, Object> getDistrictForXml() {

		return pubHealthDataService.getDistrictForXml();
	}

	// @Override
	public Map<String, Object> shownXmplRepordt() {

		return pubHealthDataService.shownXmplRepordt();
	}

	public List<Object[]> generateHMISExcelReport(String queryForhmisDataExcel) {
		// TODO Auto-generated method stub
		return pubHealthDataService
				.generateHMISExcelReport(queryForhmisDataExcel);
	}

	@Override
	public Map<String, Object> generateHMISExcelReport(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> showNewTransferMemberJsp(Box box) {

		return pubHealthDataService.showNewTransferMemberJsp(box);
	}

	@Override
	public Map<String, Object> getPhReportDataFromDatabase(Box box) {

		return pubHealthDataService.getPhReportDataFromDatabase(box);
	}

	public String getHospitalName(int i) {
		return pubHealthDataService.getHospitalName(i);
	}
	
	
	@Override
	public Map<String, Object> getHMISCountFromDatabase(Box box) {

		return pubHealthDataService.getHMISCountFromDatabase(box);
	}

	@Override
	public Map<String, Object> submitHmisReportData(Box box) {

		return pubHealthDataService.submitHmisReportData(box);
	}

	@Override
	public Map<String, Object> updateHmisReportData(Box box) {

		return pubHealthDataService.updateHmisReportData(box);
	}

	@Override
	public Map<String, Object> gethmisbyMonthValue(
			Map<String, Object> requestmap) {

		return pubHealthDataService.gethmisbyMonthValue(requestmap);
	}
	
	@Override
	public Map<String, Object> getIdspReportDataHospitalWise(Box box) {

		return pubHealthDataService.getIdspReportDataHospitalWise(box);
	}
	
	
	@Override
	public Map<String, Object> getIdspReportDataFormLHospitalWise(Box box) {

		return pubHealthDataService.getIdspReportDataFormLHospitalWise(box);
	}
	
	
	
	@Override
	public Map<String, Object> getDiseasesIcdMapping(Box box) {

		return pubHealthDataService.getDiseasesIcdMapping(box);
	}
	
	@Override
	public Map<String, Object> addDiseasesIcdMapping(Box box) {

		return pubHealthDataService.addDiseasesIcdMapping(box);
	}
	
	
	@Override
	public Map<String, Object> deleteDiseasesIcdMapping(Box box) {

		return pubHealthDataService.deleteDiseasesIcdMapping(box);
	}
	
	@Override
	public Map<String, Object> getItemListForAutoCompleteForDiseasesIcdMapping(Map mapForDS) {

		return pubHealthDataService.getItemListForAutoCompleteForDiseasesIcdMapping(mapForDS);
	}
	
	@Override
	public Map<String, Object> getHMISParameters(Box box) {

		return pubHealthDataService.getHMISParameters(box);
	}
	
	@Override
	public Map<String, Object> getHMISParameterMapping(Box box) {

		return pubHealthDataService.getHMISParameterMapping(box);
	}

	@Override
	public Map<String, Object> getItemListForAutoCompleteForHmisParameterMapping(Map mapForDS) {

		return pubHealthDataService.getItemListForAutoCompleteForHmisParameterMapping(mapForDS);
	}
	
	@Override
	public Map<String, Object> addHmisParameterMapping(Box box) {

		return pubHealthDataService.addHmisParameterMapping(box);
	}
	
	@Override
	public Map<String, Object> deleteHmisParameterMapping(Box box) {

		return pubHealthDataService.deleteHmisParameterMapping(box);
	}
	
	@Override
	public Map<String, Object> createHmisbyMonthExcelList(Box box) {
		return pubHealthDataService.createHmisbyMonthExcelList(box);
	}
	
	@Override
	public Map<String, Object> getStudentAllDetailsById(Map<String, Object> dataMap) {
		return pubHealthDataService.getStudentAllDetailsById(dataMap);
		}
	
	@Override
	public Map<String, Object> getIndividualStudentDetails(Map<String, Object> dataMap) {
		return pubHealthDataService.getIndividualStudentDetails(dataMap);
		}
	
	
	@Override
	public Map<String, Object> updateIdspReportDataHospitalWise(Box box) {
		return pubHealthDataService.updateIdspReportDataHospitalWise(box);
	}
	
	
	@Override
	public Map<String, Object> updateIdspReportFormLDataHospitalWise(Box box) {
		return pubHealthDataService.updateIdspReportFormLDataHospitalWise(box);
	}
	
	
	@Override
	public Map<String, Object> getItemListForAutoCompleteForICDandInvastigation(
			Map<String, Object> map) {
		
		return pubHealthDataService.getItemListForAutoCompleteForICDandInvastigation(map);
	}
	
	@Override
	public Map<String, Object> addInvastigationIcdMapping(Box box) {
		
		return pubHealthDataService.addInvastigationIcdMapping(box);
	}

	@Override
	public Map<String, Object> showStockReservationForImmunization(Box box) {
		
		return pubHealthDataService.showStockReservationForImmunization(box);
	}


	@Override
	public Map<String, Object> submitResrvedStockForImmunization(Box box) {
		
		return pubHealthDataService.submitResrvedStockForImmunization(box);
	}

	@Override
	public Map<String, Object> showStockConsumptionForImmunization(Box box) {
		
		return pubHealthDataService.showStockConsumptionForImmunization(box);
	}

	@Override
	public Map<String, Object> responseForStockConsumptionForImmunization(Box box) {
		
		return pubHealthDataService.responseForStockConsumptionForImmunization(box);
	}

	@Override
	public Map<String, Object> submitConsumptionForImmunization(Box box) {
		// TODO Auto-generated method stub
		return pubHealthDataService.submitConsumptionForImmunization(box);
	}

	@Override
	public Map<String, Object> fillItemsForDefectiveDrugs(Map<String, Object> dataMap) {
		
		return pubHealthDataService.fillItemsForDefectiveDrugs(dataMap);
	}

	@Override
	public Map<String, Object> getExpiryDateInAjax(Map<String, Object> dataMap) {
		
		return pubHealthDataService.getExpiryDateInAjax(dataMap);
	}
	
	@Override
	public Map<String, Object> addTempDataForAntenatalCareReport(Box box) {
		
		return pubHealthDataService.addTempDataForAntenatalCareReport(box);
	}
	
	@Override
	public Map<String, Object> getIcdInvestigationMapping(Box box) {
		
		return pubHealthDataService.getIcdInvestigationMapping(box);
	}
	
	
	@Override
	public Map<String, Object> deleteIcdInvestigationMapping(Box box) {
		
		return pubHealthDataService.deleteIcdInvestigationMapping(box);
	}
	
	@Override
	public Map<String, Object> vectorSurveyDetail(Box box) {
		
		return pubHealthDataService.vectorSurveyDetail(box);
	}
	
	@Override
	public Map<String, Object> showVectorDetail(Box box,String[] loc) {
		
		return pubHealthDataService.showVectorDetail(box,loc);
	}
	
	@Override
	public Map<String, Object> getMCTSReportData(Box box) {

		return pubHealthDataService.getMCTSReportData(box);
	}

	@Override
	public Map<String, Object> getlocalityList2(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return pubHealthDataService.getlocalityList2(dataMap);
	}
	
	// @Override
		public Map<String, Object> getTalukListForVillageMapping(Map<String, Object> dataMap) {
			// TODO Auto-generated method stub
			return pubHealthDataService.getTalukListForVillageMapping(dataMap);
		}
		
		// @Override
		public Map<String, Object> getvilageListForVillageMapping(Map<String, Object> dataMap) {
			// TODO Auto-generated method stub
			return pubHealthDataService.getvilageListForVillageMapping(dataMap);
		}
		
		// @Override
		public Map<String, Object> populateSubcenterList(Map<String, Object> dataMap) {
			// TODO Auto-generated method stub
			return pubHealthDataService.populateSubcenterList(dataMap);
		}
		
		// @Override
		public Map<String, Object> showFormPJsp(Map<String, Object> dataMap) {
			// TODO Auto-generated method stub
			return pubHealthDataService.showFormPJsp(dataMap);
		}

		@Override
		public Map<String, Object> getlocalitySearch(Map<String, Object> dataMap) {
			return pubHealthDataService.getlocalitySearch(dataMap);
		}

		@Override
		public Map<String, Object> getPHC(Map<String, Object> dataMap) {
			return pubHealthDataService.getPHC(dataMap);
		}

		@Override
		public Map<String, Object> showCampGroupJsp(Box box) {
			
			return pubHealthDataService.showCampGroupJsp(box);
		}

		@Override
		public Map<String, Object> submitCampGroup(Box box) {
			
			return pubHealthDataService.submitCampGroup(box);
		}

		@Override
		public Map<String, Object> showCampJsp(Box box) {
			
			return pubHealthDataService.showCampJsp(box);
		}

		@Override
		public Map<String, Object> submitCamp(Box box) {
			
			return pubHealthDataService.submitCamp(box);
		}
		
		@Override
		public String getInstituteTypeName(int hospitalId) {
			
			return pubHealthDataService.getInstituteTypeName(hospitalId);
		}
		
		@Override
		public Map<String, Object> getBasicCenterListForPhcChc(int hopitalId) {
			
			return pubHealthDataService.getBasicCenterListForPhcChc(hopitalId);
		}

		@Override
		public Map showPhSyndromicSurvcillenceMappingJsp() {
			return pubHealthDataService.showPhSyndromicSurvcillenceMappingJsp();
		}

		@Override
		public boolean addPhSyndromicSurvcillenceMapping(
				PhSyndromicSurvcillenceMapping phSyndromicSurvcillenceMapping) {
			return pubHealthDataService.addPhSyndromicSurvcillenceMapping(phSyndromicSurvcillenceMapping);
		}

		@Override
		public boolean editPhSyndromicSurvcillenceMapping(
				Map<String, Object> generalMap) {
			return pubHealthDataService.editPhSyndromicSurvcillenceMapping(generalMap);
		}

		@Override
		public boolean deletePhSyndromicSurvcillenceMapping(
				int phSyndromicSurvcillenceMappingId,
				Map<String, Object> generalMap) {
		
			return pubHealthDataService.deletePhSyndromicSurvcillenceMapping(phSyndromicSurvcillenceMappingId, generalMap);
		}

		@Override
		public Map<String, Object> searchPhSyndromicSurvcillenceMapping(
				String parameterName) {
				return pubHealthDataService.searchPhSyndromicSurvcillenceMapping(parameterName);
		}
		
		// @Override
		public Map<String, Object> fun_ph_form_s(Date fromDate, Date toDate, int userId) {

			return pubHealthDataService.fun_ph_form_s(fromDate, toDate, userId);
		}
	
		@Override
		public Map<String, Object> getPhReportsParametersMappings(Box box) {
			
			return pubHealthDataService.getPhReportsParametersMappings(box);
		}
		
		@Override
		public Map<String, Object> updatePhReportsParametersMappings(Box box) {
			
			return pubHealthDataService.updatePhReportsParametersMappings(box);
		}
		
		@Override
		public Map<String, Object> getGoiMonthlyCountFromDatabase(Box box) {
			
			return pubHealthDataService.getGoiMonthlyCountFromDatabase(box);
		}
		
		@Override
		public Map<String, Object> getAshapage(Map<String, Object> map) {
			// TODO Auto-generated method stub
			return pubHealthDataService.getAshapage(map);
		}
		
		
		@Override
		public Map<String, Object> getHospitals(Map<String, Object> map) {
			// TODO Auto-generated method stub
			return pubHealthDataService.getHospitals(map);
		}
		
		@Override
		public Map<String, Object> submitAshaWorker(Box box) {
			// TODO Auto-generated method stub
			return pubHealthDataService.submitAshaWorker(box);
		}
		
		@Override
		public Map<String, Object> getAshaEntity(Map<String, Object> map) {
			// TODO Auto-generated method stub
			return pubHealthDataService.getAshaEntity(map);
		}
		
		public String getRankName(int empId) {
			return pubHealthDataService.getRankName(empId);
		}

		// @Override
		public Map<String, Object> submitVaccineDetailPH(Box box) {
			// TODO Auto-generated method stub
			return pubHealthDataService.submitVaccineDetailPH(box);
		}
		
		public Map<String, Object> getImmunNursingCareWaitingList(	Map<String, Object> map) {
			return pubHealthDataService.getImmunNursingCareWaitingList(map);
		}
		
		@Override
		public Map<String, Object> getDetailsForProcWaitList(int hospitalId,int visitId) {
			return pubHealthDataService.getDetailsForProcWaitList(hospitalId,visitId);
		}
		
		public Map<String, Object> getDrugAndProcedureDetails(Map<String, Object> map) {
			return pubHealthDataService.getDrugAndProcedureDetails(map);
		}
		
		@Override
		public Map<String, Object> getItemBatch(Box box) {
			// TODO Auto-generated method stub
			return pubHealthDataService.getItemBatch(box);
		}
		
		@Override
		public Map<String, Object> submitNursingCare(Box box) {
			// TODO Auto-generated method stub
			return pubHealthDataService.submitNursingCare(box);
		}


		@Override
		public Map<String, Object> getWard(Map<String, Object> dataMap) {
			return pubHealthDataService.getWard(dataMap);
		}

		@Override
		public Map<String, Object> showDashboardSurveyCount(Box box) {
			return pubHealthDataService.showDashboardSurveyCount(box);
		}

		@Override
		public Map<String, Object> getMCTSChildReportData(Box box) {
			return pubHealthDataService.getMCTSChildReportData(box);
		}

		@Override
		public Map<String, Object> showPhMappingAdminJsp(Box box) {
			// TODO Auto-generated method stub
			return pubHealthDataService.showPhMappingAdminJsp(box);
		}

		@Override
		public Map<String, Object> getHMISHospitalCountFromDatabase(Box box) {
			return pubHealthDataService.getHMISHospitalCountFromDatabase(box);
		}
		
		@Override
		public Map<String, Object> getHMISReportDataFromDatabase(Box box) {
			return pubHealthDataService.getHMISReportDataFromDatabase(box);
		}

		@Override
		public Map<String, Object> submitHmisHospitalReportData(Box box) {
			return pubHealthDataService.submitHmisHospitalReportData(box);
		}
		
		@Override
		public Map<String, Object> updateHmisHospitalReportData(Box box) {
			return pubHealthDataService.updateHmisHospitalReportData(box);
		}

		@Override
		public Map<String, Object> createHmisHospitalExcelList(Box box) {
			return pubHealthDataService.createHmisHospitalExcelList(box);
		}

		@Override
		public Map<String,Integer> publicHealthPieChart(Box box,List<MasHospital> basicSubList) {
			return pubHealthDataService.publicHealthPieChart(box,basicSubList);
		}
		
		@Override
		public Map<String,String> addSupervisoryDashboardTarget(Box box) {
			return pubHealthDataService.addSupervisoryDashboardTarget(box);
		}

		@Override
		public Map<String, Object> showDashboardTargetDetails(Box box) {
			return pubHealthDataService.showDashboardTargetDetails(box);
		} 
		
		@Override
		public List<Object[]> getHospitalListForTemplateApplication(int districtId) {
			return pubHealthDataService.getHospitalListForTemplateApplication(districtId);
		}
		
		@Override
		public List<MasHospitalType> getHospitalTypeListForPH() {
			return pubHealthDataService.getHospitalTypeListForPH();
		}
		
		public Map<String, Object> gethealthblocklist(Box box) {
			return pubHealthDataService.gethealthblocklist(box);
		}
		
		public Map<String, Object> getPhcChclist(Box box) {
			return pubHealthDataService.getPhcChclist(box);
		}
		
		public Map<String, String> dashboardAuthentication(Box box) {
			return pubHealthDataService.dashboardAuthentication(box);
		}
		
		public Map<String, Object> getHospitalDetails(Box box) {
			return pubHealthDataService.getHospitalDetails(box);
		}
		
		public Map<String, Object> addTabletAssets(Box box) {
			return pubHealthDataService.addTabletAssets(box);
		}
		
		public Map<String, Object> importAssetsDetails(Map utilMap) {
			return pubHealthDataService.importAssetsDetails(utilMap);
		}
		
		public Map<String, Object> searchAssetTablet(Box box) {
			return pubHealthDataService.searchAssetTablet(box);
		}
}
