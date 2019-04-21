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
import jkt.hms.util.Box;

public interface LaboratoryMasterHandlerService {

	// ------------------------------ Diagnosis
	// Conclusion---------------------------------

	boolean addDiagnosisConclusion(MasDiagnosisConclusion masDiagnosisConclusion);

	Map<String, Object> searchDiagnosisConclusion(
			String diagnosisConclusionCode, String diagnosisConclusionName);

	boolean editDiagnosisConclusionToDatabase(Map<String, Object> generalMap);

	Map<String, Object> showDiagnosisConclusionJsp();

	boolean deleteDiagnosisConclusion(int conclusionId,
			Map<String, Object> generalMap);

	// ------------------------------- Biopsy Lab
	// -----------------------------------------
	boolean addBiopsyLab(MasBiopsyLab masBiopsyLab);

	Map<String, Object> searchBiopsyLab(String biopsyLabCode,
			String biopsyLabName);

	Map<String, Object> showBiopsyLabJsp();

	boolean editBiopsyLabToDatabase(Map<String, Object> generalMap);

	boolean deleteBiopsyLab(int biopsyLabId, Map<String, Object> generalMap);

	// ------------------------------ Sample
	// ----------------------------------------
	Map<String, Object> searchSample(String sampleCode, String sampleName);

	Map<String, Object> showSampleJsp();

	boolean addSample(MasSample masSample);

	boolean editSampleToDatabase(Map<String, Object> generalMap);

	boolean deleteSample(int sampleId, Map<String, Object> generalMap);

	// --------------------------------SampleCollection---------------------------------
	Map<String, Object> showSampleCollectionJsp();

	Map<String, Object> searchSampleCollection(String collectionCode,
			String collectionName);

	boolean addSampleCollection(DgMasCollection dgMasCollection);

	boolean editSampleCollectionToDatabase(Map<String, Object> generalMap);

	boolean deleteSampleCollection(int collectionId,
			Map<String, Object> generalMap);

	// ----------------------------InvestigationUom----------------------------------------

	Map<String, Object> searchInvestigationUom(String uomCode, String uomName);

	boolean addInvestigationUom(DgUom dgUom);

	Map<String, Object> showInvestigationUomJsp();

	boolean editInvestigationUomToDatabase(Map<String, Object> generalMap);

	boolean deleteInvestigationUom(int uomId, Map<String, Object> generalMap);

	// --------------------------Collection
	// Center-----------------------------------

	Map<String, Object> showCollectionCenterJsp();

	Map<String, Object> searchCollectionCenter(String collectionCenterCode,
			String collectionCenterName);

	boolean addCollectionCenter(DgCollectionCenter dgCollectionCenter);

	boolean editCollectionCenterToDatabase(Map<String, Object> generalMap);

	boolean deleteCollectionCenter(int collectionCenterId,
			Map<String, Object> generalMap);

	// -----------------------------Start Organism by Vishal
	// Jain------------------------------------------

	Map<String, Object> getConnection();

	// for Antibiotics
	Map<String, Object> showAntibioticLabJsp();

	Map<String, Object> searchAntibioticLab(String antibioticCode,
			String antibioticName);

	boolean addAntibioticLab(MasAntibioticLab masAntibioticLab);

	boolean editAntibioticLabToDatabase(Map<String, Object> generalMap);

	boolean deleteAntibioticLab(int antibioticLabId,
			Map<String, Object> generalMap);

	// -----------------------------End Code by Vishal
	// Jain------------------------------------------

	Map<String, Object> showOrganismGroupJsp();

	Map<String, Object> searchOrganismGroup(String organismGroupCode,
			String organismGroupName);

	boolean addOrganismGroup(DgMasOrganismGroup dgMasOrganismGroup);

	boolean editOrganismGroupToDatabase(Map<String, Object> generalMap);

	boolean deleteOrganismGroup(int organismGroupId,
			Map<String, Object> generalMap);

	Map<String, Object> searchOrganism(String organismCode, String organismName);

	Map<String, Object> showOrganismJsp();

	boolean addOrganism(DgMasOrganism dgMasOrganism);

	boolean editOrganism(Map<String, Object> generalMap);

	boolean deleteOrganism(int organismId, Map<String, Object> generalMap);

	Map<String, Object> showOrganismGroupDetailJsp(int hospitalId);

	boolean addOrganismGroupDetail(DgOrgGrpDtl dgOrgGrpDtl);

	boolean editOrganismGroupDetail(Map<String, Object> generalMap);

	boolean deleteOrganismGroupDetail(int groupDetailId,
			Map<String, Object> generalMap);

	Map<String, Object> showOrganismDetailJsp();

	boolean addOrganismDetail(DgOrgDtl dgOrgDtl);

	boolean editOrganismDetail(Map<String, Object> generalMap);

	boolean deleteOrganismDetail(int detailId, Map<String, Object> generalMap);

	Map<String, Object> searchOrganismGroupDetail(String organismGroup,int hospitalId);

	Map<String, Object> showParamJsp();

	Map<String, Object> getSubchargeList(Box box);

	boolean addDiagParam(DiagParam diagParam);

	boolean editDiagParam(Map<String, Object> generalMap);

	Map<String, Object> searchSubChargeInDiagParam(String subChargecodeCode,
			String subChargecodeName);

	boolean deleteDiagParam(int diagId, Map<String, Object> generalMap);

	Map<String, Object> searchOrganismDetail(Map<String, Object> generalMap);

	Map<String, Object> getSensitivityListAutoComplete(
			Map<String, Object> generalMap);

	List<DgOrgGrpDtl> checkExisitingOrgGrpDt(Map<String, Object> generalMap);
	Map<String, Object> showAnalyzerParameterJsp(int hospitalId);

	Map<String, Object> checkForExistingAnalyzerParameterId(
			Map<String, Object> generalMap);

	boolean editAnalyzerParameter(Map<String, Object> generalMap);

	boolean deleteAnalyzerParameter(int analyzerParameterId,
			Map<String, Object> generalMap);

	Map<String, Object> searchAnalyzerParameter(String parameterName,
			String machineName, int hospitalId);

	Map<String, Object> checkForExistingAnalyzerParameter(
			Map<String, Object> generalMap);

	boolean addAnalyzerParameter(MasAnalyzerParameter masAnalyzerParameter);
}
