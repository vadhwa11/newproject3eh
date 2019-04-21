package jkt.hms.pubHealth.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.LocationParameterMapping;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHospitalType;
import jkt.hms.masters.business.PhSyndromicSurvcillenceMapping;
import jkt.hms.util.Box;



public interface PubHealthHandlerService {

	Map<String, Object> showDayBlockAllocationJsp(int hospitalId);

	Map<String, Object> fillLoc(String val, Map<String, Object> detailsMap);

	Map<String, Object> showAdvanceTourPlanJPHNAndJHIJsp(int hospitalId);

	Map<String, Object> saveDayBlockAllocation(Map<String, Object> detailsMap);

	Map<String, Object> getDayBlockId(Map<String, Object> detailsMap);

	Map<String, Object> showAtpJphnJhiJsp(Map<String, Object> detailMap);

	Map<String, Object> submitAtpJphnJhi(Box box);

	Map<String, Object> getAtpJphnJhiDetail(Map<String, Object> detailsMap);

	Map<String, Object> showAtpJphnJhiApprovalJsp(int hospitalId);

	Map<String, Object> submitAtpJphnJhiApproval(Box box);

	Map<String, Object> showSchoolAnganwadiRegistrationJsp(Box box);

	Map<String, Object> submitSchoolAnganwadiRegistration(Box box);

	Map<String, Object> getNameList(Map<String, Object> dataMap);

	Map<String, Object> getNameDetailList(Map<String, Object> dataMap);

	Map<String, Object> showStudentRegistrationJsp(Box box);

	Map<String, Object> getAnganwadiNameList(Map<String, Object> dataMap);

	Map<String, Object> populateSection(Map<String, Object> dataMap);

	Map<String, Object> getMemberSurveyList(Map<String, Object> dataMap);

	Map<String, Object> getValueMemberSurvey(Map<String, Object> dataMap);

	Map<String, Object> uploadExcel(Map<String, Object> infoMap);

	Map<String, Object> addorUpdateStudentRescord(Map<String, Object> infoMap);

	Map<String, Object> submitStudentRegistration(Box box);

	Map<String, Object> showImmunizationJsp(Box box);

	Map<String, Object> searchImmunizationDetail(Box box);

	Map<String, Object> showVaccineDetailJsp(Box box);

	Map<String, Object> submitVaccineDetail(Box box);

	Map<String, Object> showJphnAndJhiMonthlyObservationsJsp(int hospitalId);

	Map<String, Object> submitJphniJhi(Box box);

	Map<String, Object> generateStudentExcel(Map<String, Object> infoMap);

	Map<String, Object> getMonths(Map<String, Object> dataMap);

	Map<String, Object> showPhMappingJsp(Box box);

	Map<String, Object> getPhcList(Box box);

	Map<String, Object> getSubCenterList(Box box);

	Map<String, Object> getbasicSectionList(Box box);

	Map<String, Object> getParametersList(Box box);

	Map<String, Object> showAtPhnJhiPrepairAndSubmmitJsp(Map<String, Object> detailMap);

	Map<String, Object> getDtailThroughDate(Map<String, Object> detailMap);

	Map<String, Object> getDtailThroughDate(Box box);

	Map<String, Object> addApproveSubmit(Box box);

	Map<String, Object> datewiseCompletion(Box box);

	Map<String, Object> saveDailyWork(Box box);

	Map<String, Object> getlocality(Box box);

	Map<String, Object> getTalukList(Map<String, Object> dataMap);

	Map<String, Object> getvilageList(Map<String, Object> dataMap);

	Map<String, Object> getWardList(Map<String, Object> dataMap);

	Map<String, Object> getlocalityList(Map<String, Object> dataMap);

	Map<String, Object> getParalamentList(Box box);

	Map<String, Object> getAssamblyList(Box box);

	Map<String, Object> getLsgiList(Box box);

	Map<String, Object> getElectrickSectionList(Box box);

	Map<String, Object> getPostOfficeList(Box box);

	Map<String, Object> saveIntoLocationParameter(LocationParameterMapping locmaPing);

	Map<String, Object> showPublicHealthHouseSurveyJsp(Box box,	Map<String, Object> details);

	Map<String, Object> phFamilySurveys(Box box, Map<String, Object> details);
	
	Map<String, Object> phEligibleCouple(Box box, Map<String, Object> details);

	Map<String, Object> getDistrictList(Box box);

	Map<String, Object> getDistrictForAssamblyList(Box box);

	Map<String, Object> getDistrictForLsgList(Box box);

	Map<String, Object> getDistrictForElectricalSecList(Box box);

	Map<String, Object> getDistrictForPostOfficeList(Box box);

	Map<String, Object> updateInlocationParameter(
			LocationParameterMapping locmaPingMap,Map<String, Object> dataMap);

	Map<String, Object> getTalukForElSectionList(Map<String, Object> dataMap);

	Map<String, Object> getvilageElSectionList(Map<String, Object> dataMap);

	Map<String, Object> showPublicHealthVillageSurveyJsp(Map<String, Object> details);

	Map<String, Object> searChPublicHealthVillageSurveyJsp(Box box);

	Map<String, Object> getMonthsForApprve(Map<String, Object> dataMap);

	Map<String, Object> getDetailByName(Box box);

	Map<String, Object> getDistrictBesickSectionList(Box box);

	Map<String, Object> getBesicSectionlist(Map<String, Object> dataMap);

	Map<String, Object> getSubcenterList(Map<String, Object> dataMap);

	Map<String, Object> getMonthsAndVisit(Map<String, Object> dataMap);

	Map<String, Object> getlistbyVisit(Box box);

	Map<String, Object> submitStatus(Box box);

	Map<String, Object> submitHSAndMOapproval(Box box);

	Map<String, Object> showAshaWorker(Map<String, Object> datamap);

	Map<String, Object> getAshaworkerDetail(Box box);

	Map<String, Object> getRegistrationDetail(Box box);

	Map<String, Object> getBirthRegistration(Box box);

	Map<String, Object> getDeathRegistration(Box box);

	Map<String, Object> getAncRegistration(Box box);

	Map<String, Object> getEcRegistration(Box box);

	Map<String, Object> getFamilyPalRegistration(Box box);

	Map<String, Object> getCDRRegistration(Box box);

	Map<String, Object> getNonCDRRegistration(Box box);

	Map<String, Object> getConnectionForReport();

	Map<String, Object> runDilevery_detail_Procedure(int hospitalId);

	Map<String, Object> runDelivryPlaceProcedure(String fromDate, String toDate);

	Map<String, Object> getDistrictList();

	Map<String, Object> getchclist(Box box);

	Map<String, Object> getBasicCenterList(Box box);

	Map<String, Object> getSurveyCount(Box box);

	Map<String, Object> sendMailOfSurvey(Box box);

//VK	
	Map<String, Object> showTransferMemberJsp(Box box);

	Map<String, Object> detailTransferMember(Box box, Map<String, Object> details);

	Map<String, Object> addNewTransferMember(Box box);
//KM
	
	Map<String, Object> showApplockPassword(Box box);
	Map<String, Object> detailApplockPassword(Box box, Map<String, Object> details);

	Map<String, Object> showJHIJPHNHouseSurveyJsp(Box box,
			Map<String, Object> details);

	Map<String, Object> showHouseSurveyINDistrict(Box box,
			Map<String, Object> details);

	Map<String, Object> getVillageListHouseSurvey(Map<String, Object> dataMap);

	Map<String, Object> showHouseSurveyInStateJsp(Box box,
			Map<String, Object> details);

	Map<String, Object> getTalukListHouseSurvey(Map<String, Object> dataMap);

	Map<String, Object> phMemberSurvey(Box box, Map<String, Object> details);
	
	Map<String, Object> getTalukForTransferedMemberList(Map<String, Object> dataMap);

	Map<String, Object> getVillageForTransferedMemberList(Map<String, Object> dataMap);

	Map<String, Object> getWardForTransferedMemberList(Map<String, Object> dataMap);	

	Map<String, Object> getSubCentreForTransferedMemberList(Map<String, Object> dataMap);

	Map<String, Object> showPhOpdMainJsp(Box box);

	Map<String, Object> getClassList(Map<String, Object> dataMap);

	Map<String, Object> getSectionList(Map<String, Object> dataMap);

	Map<String, Object> getPhStudentRegistrationOpdMainList(Map<String, Object> dataMap);

	Map<String, Object> getValueStudentRegistration(Box box);

	Map<String, Object> fillDataForDistrictHospitalType(Map<String, Object> dataMap);

	Map<String, Object> showDepartmentSpeciality(Map<String, Object> map);

	Map showGroupAndParameterValues(Map generalMap);

	Map<String, Object> saveSpeciality(Map<String, Object> mapForDS);

	Map<String, Object> getDistrictForXml();

	Map<String, Object> generateHMISExcelReport(Map<String, Object> map);

	List<Object[]> generateHMISExcelReport(String queryForhmisDataExcel);

	Map<String, Object> showNewTransferMemberJsp(Box box);

	Map<String, Object> getPhReportDataFromDatabase(Box box);
	
	String getHospitalName(int i);
	
	Map<String, Object> getHMISCountFromDatabase(Box box);

	Map<String, Object> submitHmisReportData(Box box);

	Map<String, Object> updateHmisReportData(Box box);

	Map<String, Object> gethmisbyMonthValue(Map<String, Object> requestmap);

	Map<String, Object> createHmisbyMonthExcelList(Box box);
	
	Map<String, Object> getIdspReportDataHospitalWise(Box box);
	
	Map<String, Object> getIdspReportDataFormLHospitalWise(Box box);
	
	Map<String, Object> updateIdspReportFormLDataHospitalWise(Box box);

	Map<String, Object> getDiseasesIcdMapping(Box box);
	
	Map<String, Object> addDiseasesIcdMapping(Box box);
	
	Map<String, Object> deleteDiseasesIcdMapping(Box box);
	
	Map<String, Object> getItemListForAutoCompleteForDiseasesIcdMapping(Map mapForDS);
	
	Map<String, Object> getHMISParameters(Box box);
	
	Map<String, Object> getHMISParameterMapping(Box box);
	
	Map<String, Object> getItemListForAutoCompleteForHmisParameterMapping(Map mapForDS);
	
	Map<String, Object> addHmisParameterMapping(Box box);
	
	Map<String, Object> deleteHmisParameterMapping(Box box);
	
	Map<String, Object> getStudentAllDetailsById(Map<String, Object> dataMap);
	
	Map<String, Object> getIndividualStudentDetails(Map<String, Object> dataMap);
	
	Map<String, Object> updateIdspReportDataHospitalWise(Box box);
	
	Map<String, Object>  addInvastigationIcdMapping(Box box);
	
	Map<String, Object> getItemListForAutoCompleteForICDandInvastigation(
				Map<String, Object> map);

	Map<String, Object> showStockReservationForImmunization(Box box);

	Map<String, Object> submitResrvedStockForImmunization(Box box);

	Map<String, Object> showStockConsumptionForImmunization(Box box);

	Map<String, Object> responseForStockConsumptionForImmunization(Box box);

	Map<String, Object> submitConsumptionForImmunization(Box box);

	Map<String, Object> fillItemsForDefectiveDrugs(Map<String, Object> dataMap);

	Map<String, Object> getExpiryDateInAjax(Map<String, Object> dataMap);
	
	Map<String, Object>  addTempDataForAntenatalCareReport(Box box);
	
	Map<String, Object>  getIcdInvestigationMapping(Box box);
	
	Map<String, Object>  deleteIcdInvestigationMapping(Box box);
	
	Map<String, Object>  vectorSurveyDetail(Box box);
	
	Map<String, Object>  showVectorDetail(Box box, String[] loc);
	
	Map<String, Object> getMCTSReportData(Box box);

	Map<String, Object> getlocalityList2(Map<String, Object> dataMap);
	
	Map<String, Object> getTalukListForVillageMapping(Map<String, Object> dataMap);
	
	Map<String, Object> getvilageListForVillageMapping(Map<String, Object> dataMap);
	
	Map<String, Object> populateSubcenterList(Map<String, Object> dataMap);
	
	Map<String, Object> showFormPJsp(Map<String, Object> dataMap);

	Map<String, Object> getlocalitySearch(Map<String, Object> dataMap);

	Map<String, Object> getPHC(Map<String, Object> dataMap);

	Map<String, Object> showCampGroupJsp(Box box);

	Map<String, Object> submitCampGroup(Box box);

	Map<String, Object> showCampJsp(Box box);

	Map<String, Object> submitCamp(Box box);
	
	String getInstituteTypeName(int hospitalId);
	
	Map<String, Object> getBasicCenterListForPhcChc(int hopitalId);

	Map showPhSyndromicSurvcillenceMappingJsp();

	boolean addPhSyndromicSurvcillenceMapping(
			PhSyndromicSurvcillenceMapping phSyndromicSurvcillenceMapping);

	boolean editPhSyndromicSurvcillenceMapping(Map<String, Object> generalMap);

	boolean deletePhSyndromicSurvcillenceMapping(
			int phSyndromicSurvcillenceMappingId, Map<String, Object> generalMap);

	Map<String, Object> searchPhSyndromicSurvcillenceMapping(String parameterName);
	
	Map<String, Object> fun_ph_form_s(Date fromDate, Date toDate, int userId);
	
	Map<String, Object> getPhReportsParametersMappings(Box box);
	
	Map<String, Object> updatePhReportsParametersMappings(Box box);

	Map<String, Object> getAshapage(Map<String, Object> map);
	
	Map<String, Object> getHospitals(Map<String, Object> map);
	
	Map<String, Object> submitAshaWorker(Box box);
	
	Map<String, Object> getAshaEntity(Map<String, Object> map);
	
	Map<String, Object> getGoiMonthlyCountFromDatabase(Box box);
	
	String getRankName(int empId);
	
	Map<String, Object> submitVaccineDetailPH(Box box);

	Map<String, Object> getImmunNursingCareWaitingList(Map<String, Object> map);
	
	Map<String, Object> getDetailsForProcWaitList(int hospitalId, int visitId);
	
	Map<String, Object> getDrugAndProcedureDetails(Map<String, Object> map);
	
	Map<String, Object> getItemBatch(Box box);
	
	Map<String, Object> submitNursingCare(Box box);

	Map<String, Object> getWard(Map<String, Object> detailsMap);

	Map<String, Object> showDashboardSurveyCount(Box box);

	Map<String, Object> getMCTSChildReportData(Box box);

	Map<String, Object> showPhMappingAdminJsp(Box box);
	
	Map<String, Object> getHMISHospitalCountFromDatabase(Box box);
	
	Map<String, Object> getHMISReportDataFromDatabase(Box box);

	Map<String, Object> submitHmisHospitalReportData(Box box);

	Map<String, Object> updateHmisHospitalReportData(Box box);

	Map<String, Object> createHmisHospitalExcelList(Box box);

	Map<String,Integer> publicHealthPieChart(Box box,List<MasHospital> basicSubList);
	
	Map<String,String> addSupervisoryDashboardTarget(Box box);
	
	public Map<String, Object> showDashboardTargetDetails(Box box);
	
	public List<Object[]> getHospitalListForTemplateApplication(int districtId);

	public List<MasHospitalType> getHospitalTypeListForPH();

	public Map<String, Object> gethealthblocklist(Box box);

	Map<String, Object> getPhcChclist(Box box);
	
	Map<String,String> dashboardAuthentication(Box box);
	
	Map<String, Object> getHospitalDetails(Box box);
	
	Map<String, Object> addTabletAssets(Box box);
	
	Map<String, Object> importAssetsDetails(Map utilMap);

	Map<String, Object> searchAssetTablet(Box box);
}
