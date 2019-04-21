package jkt.hms.masters.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.DgCollectionCenter;
import jkt.hms.masters.business.DgMasCollection;
import jkt.hms.masters.business.DgMasOrganism;
import jkt.hms.masters.business.DgMasOrganismGroup;
import jkt.hms.masters.business.DgOrgDtl;
import jkt.hms.masters.business.DgOrgGrpDtl;
import jkt.hms.masters.business.DgUom;
import jkt.hms.masters.business.DiagParam;
import jkt.hms.masters.business.MasAnalyzerParameter;
import jkt.hms.masters.business.MasAntibioticLab;
import jkt.hms.masters.business.MasBiopsyLab;
import jkt.hms.masters.business.MasDiagnosisConclusion;
import jkt.hms.masters.business.MasSample;
import jkt.hms.masters.dataservice.LaboratoryMasterDataService;
import jkt.hms.util.Box;

public class LaboratoryMasterHandlerServiceImpl implements
		LaboratoryMasterHandlerService {

	LaboratoryMasterDataService laboratoryMasterDataService = null;

	// --------------------------- Diagnosis Conclusion
	// -----------------------------------

	public boolean addDiagnosisConclusion(
			MasDiagnosisConclusion masDiagnosisConclusion) {
		return laboratoryMasterDataService
				.addDiagnosisConclusion(masDiagnosisConclusion);
	}

	public boolean editDiagnosisConclusionToDatabase(
			Map<String, Object> generalMap) {
		return laboratoryMasterDataService
				.editDiagnosisConclusionToDatabase(generalMap);
	}

	public Map<String, Object> showDiagnosisConclusionJsp() {
		return laboratoryMasterDataService.showDiagnosisConclusionJsp();
	}

	public Map<String, Object> searchDiagnosisConclusion(
			String diagnosisConclusionCode, String diagnosisConclusionName) {
		return laboratoryMasterDataService.searchDiagnosisConclusion(
				diagnosisConclusionCode, diagnosisConclusionName);
	}

	public boolean deleteDiagnosisConclusion(int conclusionId,
			Map<String, Object> generalMap) {
		return laboratoryMasterDataService.deleteDiagnosisConclusion(
				conclusionId, generalMap);
	}

	// ----------------------------------- Biopsy Lab
	// ----------------------------------------------

	public boolean addBiopsyLab(MasBiopsyLab masBiopsyLab) {
		return laboratoryMasterDataService.addBiopsyLab(masBiopsyLab);
	}

	public boolean editBiopsyLabToDatabase(Map<String, Object> generalMap) {
		return laboratoryMasterDataService.editBiopsyLabToDatabase(generalMap);
	}

	public Map<String, Object> searchBiopsyLab(String biopsyLabCode,
			String biopsyLabName) {
		return laboratoryMasterDataService.searchBiopsyLab(biopsyLabCode,
				biopsyLabName);
	}

	public Map<String, Object> showBiopsyLabJsp() {
		return laboratoryMasterDataService.showBiopsyLabJsp();
	}

	public boolean deleteBiopsyLab(int biopsyLabId,
			Map<String, Object> generalMap) {
		return laboratoryMasterDataService.deleteBiopsyLab(biopsyLabId,
				generalMap);
	}

	// ------------------------------------- Sample
	// -----------------------------------
	public boolean addSample(MasSample masSample) {
		return laboratoryMasterDataService.addSample(masSample);
	}

	public boolean deleteSample(int sampleId, Map<String, Object> generalMap) {
		return laboratoryMasterDataService.deleteSample(sampleId, generalMap);
	}

	public boolean editSampleToDatabase(Map<String, Object> generalMap) {
		return laboratoryMasterDataService.editSampleToDatabase(generalMap);
	}

	public Map<String, Object> searchSample(String sampleCode, String sampleName) {
		return laboratoryMasterDataService.searchSample(sampleCode, sampleName);
	}

	public Map<String, Object> showSampleJsp() {
		return laboratoryMasterDataService.showSampleJsp();
	}

	// ---------------------Sample Collection-------------------------
	public boolean addSampleCollection(DgMasCollection dgMasCollection) {
		return laboratoryMasterDataService.addSampleCollection(dgMasCollection);
	}

	public boolean deleteSampleCollection(int collectionId,
			Map<String, Object> generalMap) {
		return laboratoryMasterDataService.deleteSampleCollection(collectionId,
				generalMap);
	}

	public boolean editSampleCollectionToDatabase(Map<String, Object> generalMap) {
		return laboratoryMasterDataService
				.editSampleCollectionToDatabase(generalMap);
	}

	public Map<String, Object> searchSampleCollection(String collectionCode,
			String collectionName) {
		return laboratoryMasterDataService.searchSampleCollection(
				collectionCode, collectionName);
	}

	public Map<String, Object> showSampleCollectionJsp() {
		return laboratoryMasterDataService.showSampleCollectionJsp();
	}

	// -------------------------InvestigationUom-----------------------------------
	public boolean addInvestigationUom(DgUom dgUom) {
		return laboratoryMasterDataService.addInvestigationUom(dgUom);
	}

	public boolean editInvestigationUomToDatabase(Map<String, Object> generalMap) {
		return laboratoryMasterDataService
				.editInvestigationUomToDatabase(generalMap);
	}

	public Map<String, Object> searchInvestigationUom(String uomCode,
			String uomName) {
		return laboratoryMasterDataService.searchInvestigationUom(uomCode,
				uomName);
	}

	public Map<String, Object> showInvestigationUomJsp() {
		return laboratoryMasterDataService.showInvestigationUomJsp();
	}

	public boolean deleteInvestigationUom(int uomId,
			Map<String, Object> generalMap) {
		return laboratoryMasterDataService.deleteInvestigationUom(uomId,
				generalMap);
	}

	// ----------------------------Collection
	// Center--------------------------------------

	public boolean addCollectionCenter(DgCollectionCenter dgCollectionCenter) {
		return laboratoryMasterDataService
				.addCollectionCenter(dgCollectionCenter);
	}

	public boolean deleteCollectionCenter(int collectionCenterId,
			Map<String, Object> generalMap) {
		return laboratoryMasterDataService.deleteCollectionCenter(
				collectionCenterId, generalMap);
	}

	public boolean editCollectionCenterToDatabase(Map<String, Object> generalMap) {
		return laboratoryMasterDataService
				.editCollectionCenterToDatabase(generalMap);
	}

	public Map<String, Object> searchCollectionCenter(
			String collectionCenterCode, String collectionCenterName) {
		return laboratoryMasterDataService.searchCollectionCenter(
				collectionCenterCode, collectionCenterName);
	}

	public Map<String, Object> showCollectionCenterJsp() {
		return laboratoryMasterDataService.showCollectionCenterJsp();
	}

	// ----------------------------------------------------------------------------------------------------
	public LaboratoryMasterDataService getLaboratoryMasterDataService() {
		return laboratoryMasterDataService;
	}

	public void setLaboratoryMasterDataService(
			LaboratoryMasterDataService laboratoryMasterDataService) {
		this.laboratoryMasterDataService = laboratoryMasterDataService;
	}

	// ---------------------------Antibiotic by
	// Vishal-------------------------------

	public Map<String, Object> searchAntibioticLab(String antibioticCode,
			String antibioticName) {
		return laboratoryMasterDataService.searchAntibioticLab(antibioticCode,
				antibioticName);
	}

	public Map<String, Object> showAntibioticLabJsp() {
		return laboratoryMasterDataService.showAntibioticLabJsp();
	}

	public boolean addAntibioticLab(MasAntibioticLab masAntibioticLab) {
		return laboratoryMasterDataService.addAntibioticLab(masAntibioticLab);
	}

	public boolean editAntibioticLabToDatabase(Map<String, Object> generalMap) {
		return laboratoryMasterDataService
				.editAntibioticLabToDatabase(generalMap);
	}

	public boolean deleteAntibioticLab(int antibioticLabId,
			Map<String, Object> generalMap) {
		return laboratoryMasterDataService.deleteAntibioticLab(antibioticLabId,
				generalMap);
	}

	// ----------Organism Master----------------------------------------
	public Map<String, Object> showOrganismJsp() {
		return laboratoryMasterDataService.showOrganismJsp();
	}

	public Map<String, Object> searchOrganism(String organismCode,
			String organismName) {
		return laboratoryMasterDataService.searchOrganism(organismCode,
				organismName);
	}

	public boolean addOrganism(DgMasOrganism dgMasOrganism) {
		return laboratoryMasterDataService.addOrganism(dgMasOrganism);
	}

	public boolean editOrganism(Map<String, Object> generalMap) {
		return laboratoryMasterDataService.editOrganism(generalMap);
	}

	public boolean deleteOrganism(int organismId, Map<String, Object> generalMap) {
		return laboratoryMasterDataService.deleteOrganism(organismId,
				generalMap);
	}

	// ----------Organism Group Master----------------------------------------
	public boolean addOrganismGroup(DgMasOrganismGroup dgMasOrganismGroup) {
		return laboratoryMasterDataService.addOrganismGroup(dgMasOrganismGroup);
	}

	public boolean editOrganismGroupToDatabase(Map<String, Object> generalMap) {
		return laboratoryMasterDataService
				.editOrganismGroupToDatabase(generalMap);
	}

	public boolean deleteOrganismGroup(int organismGroupId,
			Map<String, Object> generalMap) {
		return laboratoryMasterDataService.deleteOrganismGroup(organismGroupId,
				generalMap);
	}

	public Map<String, Object> searchOrganismGroup(String organismGroupCode,
			String organismGroupName) {
		return laboratoryMasterDataService.searchOrganismGroup(
				organismGroupCode, organismGroupName);
	}

	public Map<String, Object> showOrganismGroupJsp() {
		return laboratoryMasterDataService.showOrganismGroupJsp();
	}

	// -----------------------OrganismGroupDetail----------------------------

	public boolean addOrganismGroupDetail(DgOrgGrpDtl dgOrgGrpDtl) {
		return laboratoryMasterDataService.addOrganismGroupDetail(dgOrgGrpDtl);
	}

	public boolean deleteOrganismGroupDetail(int groupDetailId,
			Map<String, Object> generalMap) {
		return laboratoryMasterDataService.deleteOrganismGroupDetail(
				groupDetailId, generalMap);
	}

	public boolean editOrganismGroupDetail(Map<String, Object> generalMap) {
		return laboratoryMasterDataService.editOrganismGroupDetail(generalMap);
	}

	public Map<String, Object> showOrganismGroupDetailJsp(int hospitalId) {
		return laboratoryMasterDataService.showOrganismGroupDetailJsp(hospitalId);
	}

	public Map<String, Object> searchOrganismGroupDetail(String organismGroup,int hospitalId) {
		return laboratoryMasterDataService
				.searchOrganismGroupDetail(organismGroup,hospitalId);
	}

	// ----------------------OrganismDetail--------------------------
	public boolean addOrganismDetail(DgOrgDtl dgOrgDtl) {
		return laboratoryMasterDataService.addOrganismDetail(dgOrgDtl);
	}

	public boolean editOrganismDetail(Map<String, Object> generalMap) {
		return laboratoryMasterDataService.editOrganismDetail(generalMap);
	}

	public Map<String, Object> showOrganismDetailJsp() {
		return laboratoryMasterDataService.showOrganismDetailJsp();
	}

	public boolean deleteOrganismDetail(int detailId,
			Map<String, Object> generalMap) {
		return laboratoryMasterDataService.deleteOrganismDetail(detailId,
				generalMap);
	}

	// ----------------Diag Parameter Master-----------------------------
	public boolean addDiagParam(DiagParam diagParam) {
		return laboratoryMasterDataService.addDiagParam(diagParam);
	}

	public boolean deleteDiagParam(int diagId, Map<String, Object> generalMap) {
		return laboratoryMasterDataService.deleteDiagParam(diagId, generalMap);
	}

	public boolean editDiagParam(Map<String, Object> generalMap) {
		return laboratoryMasterDataService.editDiagParam(generalMap);
	}

	public Map<String, Object> getSubchargeList(Box box) {
		return laboratoryMasterDataService.getSubchargeList(box);
	}

	public Map<String, Object> searchSubChargeInDiagParam(
			String subChargecodeCode, String subChargecodeName) {
		return laboratoryMasterDataService.searchSubChargeInDiagParam(
				subChargecodeCode, subChargecodeName);
	}

	public Map<String, Object> showParamJsp() {
		return laboratoryMasterDataService.showParamJsp();
	}

	public Map<String, Object> getConnection() {
		return laboratoryMasterDataService.getConnection();
	}

	public Map<String, Object> searchOrganismDetail(
			Map<String, Object> generalMap) {
		return laboratoryMasterDataService.searchOrganismDetail(generalMap);
	}

	public Map<String, Object> getSensitivityListAutoComplete(
			Map<String, Object> generalMap) {
		return laboratoryMasterDataService
				.getSensitivityListAutoComplete(generalMap);
	}

	public List<DgOrgGrpDtl> checkExisitingOrgGrpDt(
			Map<String, Object> generalMap) {
		return laboratoryMasterDataService.checkExisitingOrgGrpDt(generalMap);
	}


	@Override
	public Map<String, Object> showAnalyzerParameterJsp(int hospitalId) {
		return laboratoryMasterDataService.showAnalyzerParameterJsp(hospitalId);
	}

	@Override
	public Map<String, Object> checkForExistingAnalyzerParameterId(
			Map<String, Object> generalMap) {
		return laboratoryMasterDataService.checkForExistingAnalyzerParameterId(generalMap);
	}

	@Override
	public boolean editAnalyzerParameter(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return laboratoryMasterDataService.editAnalyzerParameter(generalMap);
	}

	@Override
	public boolean deleteAnalyzerParameter(int analyzerParameterId,
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return laboratoryMasterDataService.deleteAnalyzerParameter(analyzerParameterId, generalMap);
	}

	@Override
	public Map<String, Object> searchAnalyzerParameter(String parameterName,
			String machineName, int hospitalId) {
		// TODO Auto-generated method stub
		return laboratoryMasterDataService.searchAnalyzerParameter(parameterName, machineName, hospitalId);
	}

	@Override
	public Map<String, Object> checkForExistingAnalyzerParameter(
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return laboratoryMasterDataService.checkForExistingAnalyzerParameter(generalMap);
	}

	@Override
	public boolean addAnalyzerParameter(
			MasAnalyzerParameter masAnalyzerParameter) {
		// TODO Auto-generated method stub
		return laboratoryMasterDataService.addAnalyzerParameter(masAnalyzerParameter);
	}
	

}
