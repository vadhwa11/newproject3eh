package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_case_record_periodontics_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_case_record_periodontics_header"
 */

public abstract class BaseOpdCaseRecordPeriodonticsHeader  implements Serializable {

	public static String REF = "OpdCaseRecordPeriodonticsHeader";
	public static String PROP_FACIAL_SYMMETRY = "FacialSymmetry";
	public static String PROP_ADVERSE_HABITS = "AdverseHabits";
	public static String PROP_ABRASION = "Abrasion";
	public static String PROP_LABIAL_MUCOSA = "LabialMucosa";
	public static String PROP_VESTIBULAR_DEPTH = "VestibularDepth";
	public static String PROP_ATTRITION = "Attrition";
	public static String PROP_METHOD = "Method";
	public static String PROP_MISSING_TEETH_AND_REASON_FOR_I_T = "MissingTeethAndReasonForIT";
	public static String PROP_ANGLES_CLASSIFICATION = "AnglesClassification";
	public static String PROP_MANDIBULAR_ATTACHMENT = "MandibularAttachment";
	public static String PROP_O_P_G_VIEW = "OPGView";
	public static String PROP_MUCOGINGIVAL_PROBLEMS = "MucogingivalProblems";
	public static String PROP_ULCERATION = "Ulceration";
	public static String PROP_FRENAL_ATTACHMENT = "FrenalAttachment";
	public static String PROP_TENSION_TEST2 = "TensionTest2";
	public static String PROP_MAN_LEFT_POSTERIOR = "ManLeftPosterior";
	public static String PROP_TENSION_TEST1 = "TensionTest1";
	public static String PROP_OVERBITE = "Overbite";
	public static String PROP_HABITS = "Habits";
	public static String PROP_MAXILLARY_ATTACHMENT = "MaxillaryAttachment";
	public static String PROP_FILLED_TEETH = "FilledTeeth";
	public static String PROP_FREMITUS_VAL = "FremitusVal";
	public static String PROP_CYANOSIS = "Cyanosis";
	public static String PROP_DENTRIFICES = "Dentrifices";
	public static String PROP_MAX_RIGHT_POSTERIOR = "MaxRightPosterior";
	public static String PROP_STUDY_MODELS_PRE_OPERATIVE = "StudyModelsPreOperative";
	public static String PROP_FAMILYHISTORY = "Familyhistory";
	public static String PROP_ATTACHED_GINGIVA = "AttachedGingiva";
	public static String PROP_I_O_P_A_VIEW = "IOPAView";
	public static String PROP_HISTORY_OF_PRESENT_ILLNESS = "HistoryOfPresentIllness";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PHOTOGRAPHS_PRE_OPERATIVE = "PhotographsPreOperative";
	public static String PROP_BUCCAL_MUCOSA = "BuccalMucosa";
	public static String PROP_VISIT = "Visit";
	public static String PROP_LYMPH_NODE_EXAMINATION = "LymphNodeExamination";
	public static String PROP_PREMATURE_CONTACTS = "PrematureContacts";
	public static String PROP_ABFRACTIOIN = "Abfractioin";
	public static String PROP_FURCATION_INVOLVEMENT = "FurcationInvolvement";
	public static String PROP_MAN_RIGHT_OPOSTERIOR = "ManRightOposterior";
	public static String PROP_ID = "Id";
	public static String PROP_ICTERUS = "Icterus";
	public static String PROP_GINGIVAL_ABSCESS = "GingivalAbscess";
	public static String PROP_FLOOR_OF_MOUTH = "FloorOfMouth";
	public static String PROP_HARD_TISSUE_EXAMINATION = "HardTissueExamination";
	public static String PROP_DRUG_FOOD_ALLERGY = "DrugFoodAllergy";
	public static String PROP_MOBILITY = "Mobility";
	public static String PROP_OTHERS = "Others";
	public static String PROP_PARA_FUNCTIONAL_HABITS = "ParaFunctionalHabits";
	public static String PROP_FREMITUS = "Fremitus";
	public static String PROP_TMJ_EXAMINATION = "TmjExamination";
	public static String PROP_WORKING_SIDE = "WorkingSide";
	public static String PROP_MAN_CLINICAL_FEATURE = "ManClinicalFeature";
	public static String PROP_FEQUENCY = "Fequency";
	public static String PROP_EYES_EARS_NOSE = "EyesEarsNose";
	public static String PROP_PAST_MEDICAL_HISTORY = "PastMedicalHistory";
	public static String PROP_TENSION_TEST = "TensionTest";
	public static String PROP_CLUBBING = "Clubbing";
	public static String PROP_HARD_PALATE = "HardPalate";
	public static String PROP_TONGUE = "Tongue";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_STUDY_MODELS_POST_OPERATIVE = "StudyModelsPostOperative";
	public static String PROP_MAX_ANTERIOR = "MaxAnterior";
	public static String PROP_PHOTOGRAPHS_POST_OPERATIVE = "PhotographsPostOperative";
	public static String PROP_HYPOPLASIA_FLUROSIS = "HypoplasiaFlurosis";
	public static String PROP_TOOTH_FRACTURE = "ToothFracture";
	public static String PROP_MAX_CLINICAL_FEATURE = "MaxClinicalFeature";
	public static String PROP_BALANCING_SIDE = "BalancingSide";
	public static String PROP_MAX_LEFT_POSTERIOR = "MaxLeftPosterior";
	public static String PROP_PERIODONTAL_ABSCESS = "PeriodontalAbscess";
	public static String PROP_LIP_COMPETANCE = "LipCompetance";
	public static String PROP_ABNORMAL_BLEEDING_TENDANCY = "AbnormalBleedingTendancy";
	public static String PROP_PERICORONNAL_ABSCESS = "PericoronnalAbscess";
	public static String PROP_EROSION = "Erosion";
	public static String PROP_SOFT_PALATE = "SoftPalate";
	public static String PROP_MAN_ANTERIOR = "ManAnterior";
	public static String PROP_MOBILITY_VAL = "MobilityVal";
	public static String PROP_FURCATION_INVOLVEMENT_VAL = "FurcationInvolvementVal";
	public static String PROP_CHIEF_COMPLAINT = "ChiefComplaint";
	public static String PROP_TONSILS = "Tonsils";
	public static String PROP_MEDICAL_STATUS = "MedicalStatus";
	public static String PROP_HIN = "Hin";
	public static String PROP_CROSSBITE = "Crossbite";
	public static String PROP_OVERJET = "Overjet";


	// constructors
	public BaseOpdCaseRecordPeriodonticsHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdCaseRecordPeriodonticsHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String chiefComplaint;
	private java.lang.String historyOfPresentIllness;
	private java.lang.String pastMedicalHistory;
	private java.lang.String drugFoodAllergy;
	private java.lang.String abnormalBleedingTendancy;
	private java.lang.String habits;
	private java.lang.String medicalStatus;
	private java.lang.String fequency;
	private java.lang.String dentrifices;
	private java.lang.String method;
	private java.lang.String adverseHabits;
	private java.lang.String paraFunctionalHabits;
	private java.lang.String familyhistory;
	private java.lang.String cyanosis;
	private java.lang.String icterus;
	private java.lang.String clubbing;
	private java.lang.String facialSymmetry;
	private java.lang.String eyesEarsNose;
	private java.lang.String lipCompetance;
	private java.lang.String tmjExamination;
	private java.lang.String lymphNodeExamination;
	private java.lang.String others;
	private java.lang.String buccalMucosa;
	private java.lang.String labialMucosa;
	private java.lang.String tongue;
	private java.lang.String hardPalate;
	private java.lang.String softPalate;
	private java.lang.String floorOfMouth;
	private java.lang.String tonsils;
	private java.lang.String frenalAttachment;
	private java.lang.String maxillaryAttachment;
	private java.lang.String tensionTest1;
	private java.lang.String mandibularAttachment;
	private java.lang.String tensionTest2;
	private java.lang.String maxClinicalFeature;
	private java.lang.String maxRightPosterior;
	private java.lang.String maxAnterior;
	private java.lang.String maxLeftPosterior;
	private java.lang.String manClinicalFeature;
	private java.lang.String manRightOposterior;
	private java.lang.String manAnterior;
	private java.lang.String manLeftPosterior;
	private java.lang.String mucogingivalProblems;
	private java.lang.String tensionTest;
	private java.lang.String attachedGingiva;
	private java.lang.String vestibularDepth;
	private java.lang.String ulceration;
	private java.lang.String gingivalAbscess;
	private java.lang.String periodontalAbscess;
	private java.lang.String pericoronnalAbscess;
	private java.lang.String hardTissueExamination;
	private java.lang.String iOPAView;
	private java.lang.String oPGView;
	private java.lang.String studyModelsPreOperative;
	private java.lang.String studyModelsPostOperative;
	private java.lang.String toothFracture;
	private java.lang.String hypoplasiaFlurosis;
	private java.lang.String attrition;
	private java.lang.String abrasion;
	private java.lang.String erosion;
	private java.lang.String abfractioin;
	private java.lang.String filledTeeth;
	private java.lang.String prematureContacts;
	private java.lang.String furcationInvolvement;
	private java.lang.String missingTeethAndReasonForIT;
	private java.lang.String anglesClassification;
	private java.lang.String overjet;
	private java.lang.String overbite;
	private java.lang.String fremitus;
	private java.lang.String crossbite;
	private java.lang.String workingSide;
	private java.lang.String balancingSide;
	private java.lang.String mobility;
	private java.lang.String photographsPreOperative;
	private java.lang.String photographsPostOperative;
	private java.lang.String furcationInvolvementVal;
	private java.lang.String mobilityVal;
	private java.lang.String fremitusVal;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="case_record_periodontics_header_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: chief_complaint
	 */
	public java.lang.String getChiefComplaint () {
		return chiefComplaint;
	}

	/**
	 * Set the value related to the column: chief_complaint
	 * @param chiefComplaint the chief_complaint value
	 */
	public void setChiefComplaint (java.lang.String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}



	/**
	 * Return the value associated with the column: history_of_present_illness
	 */
	public java.lang.String getHistoryOfPresentIllness () {
		return historyOfPresentIllness;
	}

	/**
	 * Set the value related to the column: history_of_present_illness
	 * @param historyOfPresentIllness the history_of_present_illness value
	 */
	public void setHistoryOfPresentIllness (java.lang.String historyOfPresentIllness) {
		this.historyOfPresentIllness = historyOfPresentIllness;
	}



	/**
	 * Return the value associated with the column: past_medical_history
	 */
	public java.lang.String getPastMedicalHistory () {
		return pastMedicalHistory;
	}

	/**
	 * Set the value related to the column: past_medical_history
	 * @param pastMedicalHistory the past_medical_history value
	 */
	public void setPastMedicalHistory (java.lang.String pastMedicalHistory) {
		this.pastMedicalHistory = pastMedicalHistory;
	}



	/**
	 * Return the value associated with the column: drug_food_allergy
	 */
	public java.lang.String getDrugFoodAllergy () {
		return drugFoodAllergy;
	}

	/**
	 * Set the value related to the column: drug_food_allergy
	 * @param drugFoodAllergy the drug_food_allergy value
	 */
	public void setDrugFoodAllergy (java.lang.String drugFoodAllergy) {
		this.drugFoodAllergy = drugFoodAllergy;
	}



	/**
	 * Return the value associated with the column: abnormal_bleeding_tendancy
	 */
	public java.lang.String getAbnormalBleedingTendancy () {
		return abnormalBleedingTendancy;
	}

	/**
	 * Set the value related to the column: abnormal_bleeding_tendancy
	 * @param abnormalBleedingTendancy the abnormal_bleeding_tendancy value
	 */
	public void setAbnormalBleedingTendancy (java.lang.String abnormalBleedingTendancy) {
		this.abnormalBleedingTendancy = abnormalBleedingTendancy;
	}



	/**
	 * Return the value associated with the column: habits
	 */
	public java.lang.String getHabits () {
		return habits;
	}

	/**
	 * Set the value related to the column: habits
	 * @param habits the habits value
	 */
	public void setHabits (java.lang.String habits) {
		this.habits = habits;
	}



	/**
	 * Return the value associated with the column: medical_status
	 */
	public java.lang.String getMedicalStatus () {
		return medicalStatus;
	}

	/**
	 * Set the value related to the column: medical_status
	 * @param medicalStatus the medical_status value
	 */
	public void setMedicalStatus (java.lang.String medicalStatus) {
		this.medicalStatus = medicalStatus;
	}



	/**
	 * Return the value associated with the column: fequency
	 */
	public java.lang.String getFequency () {
		return fequency;
	}

	/**
	 * Set the value related to the column: fequency
	 * @param fequency the fequency value
	 */
	public void setFequency (java.lang.String fequency) {
		this.fequency = fequency;
	}



	/**
	 * Return the value associated with the column: dentrifices
	 */
	public java.lang.String getDentrifices () {
		return dentrifices;
	}

	/**
	 * Set the value related to the column: dentrifices
	 * @param dentrifices the dentrifices value
	 */
	public void setDentrifices (java.lang.String dentrifices) {
		this.dentrifices = dentrifices;
	}



	/**
	 * Return the value associated with the column: method
	 */
	public java.lang.String getMethod () {
		return method;
	}

	/**
	 * Set the value related to the column: method
	 * @param method the method value
	 */
	public void setMethod (java.lang.String method) {
		this.method = method;
	}



	/**
	 * Return the value associated with the column: adverse_habits
	 */
	public java.lang.String getAdverseHabits () {
		return adverseHabits;
	}

	/**
	 * Set the value related to the column: adverse_habits
	 * @param adverseHabits the adverse_habits value
	 */
	public void setAdverseHabits (java.lang.String adverseHabits) {
		this.adverseHabits = adverseHabits;
	}



	/**
	 * Return the value associated with the column: para_functional_habits
	 */
	public java.lang.String getParaFunctionalHabits () {
		return paraFunctionalHabits;
	}

	/**
	 * Set the value related to the column: para_functional_habits
	 * @param paraFunctionalHabits the para_functional_habits value
	 */
	public void setParaFunctionalHabits (java.lang.String paraFunctionalHabits) {
		this.paraFunctionalHabits = paraFunctionalHabits;
	}



	/**
	 * Return the value associated with the column: familyhistory
	 */
	public java.lang.String getFamilyhistory () {
		return familyhistory;
	}

	/**
	 * Set the value related to the column: familyhistory
	 * @param familyhistory the familyhistory value
	 */
	public void setFamilyhistory (java.lang.String familyhistory) {
		this.familyhistory = familyhistory;
	}



	/**
	 * Return the value associated with the column: cyanosis
	 */
	public java.lang.String getCyanosis () {
		return cyanosis;
	}

	/**
	 * Set the value related to the column: cyanosis
	 * @param cyanosis the cyanosis value
	 */
	public void setCyanosis (java.lang.String cyanosis) {
		this.cyanosis = cyanosis;
	}



	/**
	 * Return the value associated with the column: icterus
	 */
	public java.lang.String getIcterus () {
		return icterus;
	}

	/**
	 * Set the value related to the column: icterus
	 * @param icterus the icterus value
	 */
	public void setIcterus (java.lang.String icterus) {
		this.icterus = icterus;
	}



	/**
	 * Return the value associated with the column: clubbing
	 */
	public java.lang.String getClubbing () {
		return clubbing;
	}

	/**
	 * Set the value related to the column: clubbing
	 * @param clubbing the clubbing value
	 */
	public void setClubbing (java.lang.String clubbing) {
		this.clubbing = clubbing;
	}



	/**
	 * Return the value associated with the column: facial_symmetry
	 */
	public java.lang.String getFacialSymmetry () {
		return facialSymmetry;
	}

	/**
	 * Set the value related to the column: facial_symmetry
	 * @param facialSymmetry the facial_symmetry value
	 */
	public void setFacialSymmetry (java.lang.String facialSymmetry) {
		this.facialSymmetry = facialSymmetry;
	}



	/**
	 * Return the value associated with the column: eyes_ears_nose
	 */
	public java.lang.String getEyesEarsNose () {
		return eyesEarsNose;
	}

	/**
	 * Set the value related to the column: eyes_ears_nose
	 * @param eyesEarsNose the eyes_ears_nose value
	 */
	public void setEyesEarsNose (java.lang.String eyesEarsNose) {
		this.eyesEarsNose = eyesEarsNose;
	}



	/**
	 * Return the value associated with the column: lip_competance
	 */
	public java.lang.String getLipCompetance () {
		return lipCompetance;
	}

	/**
	 * Set the value related to the column: lip_competance
	 * @param lipCompetance the lip_competance value
	 */
	public void setLipCompetance (java.lang.String lipCompetance) {
		this.lipCompetance = lipCompetance;
	}



	/**
	 * Return the value associated with the column: tmj_examination
	 */
	public java.lang.String getTmjExamination () {
		return tmjExamination;
	}

	/**
	 * Set the value related to the column: tmj_examination
	 * @param tmjExamination the tmj_examination value
	 */
	public void setTmjExamination (java.lang.String tmjExamination) {
		this.tmjExamination = tmjExamination;
	}



	/**
	 * Return the value associated with the column: lymph_node_examination
	 */
	public java.lang.String getLymphNodeExamination () {
		return lymphNodeExamination;
	}

	/**
	 * Set the value related to the column: lymph_node_examination
	 * @param lymphNodeExamination the lymph_node_examination value
	 */
	public void setLymphNodeExamination (java.lang.String lymphNodeExamination) {
		this.lymphNodeExamination = lymphNodeExamination;
	}



	/**
	 * Return the value associated with the column: others
	 */
	public java.lang.String getOthers () {
		return others;
	}

	/**
	 * Set the value related to the column: others
	 * @param others the others value
	 */
	public void setOthers (java.lang.String others) {
		this.others = others;
	}



	/**
	 * Return the value associated with the column: buccal_mucosa
	 */
	public java.lang.String getBuccalMucosa () {
		return buccalMucosa;
	}

	/**
	 * Set the value related to the column: buccal_mucosa
	 * @param buccalMucosa the buccal_mucosa value
	 */
	public void setBuccalMucosa (java.lang.String buccalMucosa) {
		this.buccalMucosa = buccalMucosa;
	}



	/**
	 * Return the value associated with the column: labial_mucosa
	 */
	public java.lang.String getLabialMucosa () {
		return labialMucosa;
	}

	/**
	 * Set the value related to the column: labial_mucosa
	 * @param labialMucosa the labial_mucosa value
	 */
	public void setLabialMucosa (java.lang.String labialMucosa) {
		this.labialMucosa = labialMucosa;
	}



	/**
	 * Return the value associated with the column: tongue
	 */
	public java.lang.String getTongue () {
		return tongue;
	}

	/**
	 * Set the value related to the column: tongue
	 * @param tongue the tongue value
	 */
	public void setTongue (java.lang.String tongue) {
		this.tongue = tongue;
	}



	/**
	 * Return the value associated with the column: hard_palate
	 */
	public java.lang.String getHardPalate () {
		return hardPalate;
	}

	/**
	 * Set the value related to the column: hard_palate
	 * @param hardPalate the hard_palate value
	 */
	public void setHardPalate (java.lang.String hardPalate) {
		this.hardPalate = hardPalate;
	}



	/**
	 * Return the value associated with the column: soft_palate
	 */
	public java.lang.String getSoftPalate () {
		return softPalate;
	}

	/**
	 * Set the value related to the column: soft_palate
	 * @param softPalate the soft_palate value
	 */
	public void setSoftPalate (java.lang.String softPalate) {
		this.softPalate = softPalate;
	}



	/**
	 * Return the value associated with the column: floor_of_mouth
	 */
	public java.lang.String getFloorOfMouth () {
		return floorOfMouth;
	}

	/**
	 * Set the value related to the column: floor_of_mouth
	 * @param floorOfMouth the floor_of_mouth value
	 */
	public void setFloorOfMouth (java.lang.String floorOfMouth) {
		this.floorOfMouth = floorOfMouth;
	}



	/**
	 * Return the value associated with the column: tonsils
	 */
	public java.lang.String getTonsils () {
		return tonsils;
	}

	/**
	 * Set the value related to the column: tonsils
	 * @param tonsils the tonsils value
	 */
	public void setTonsils (java.lang.String tonsils) {
		this.tonsils = tonsils;
	}



	/**
	 * Return the value associated with the column: frenal_attachment
	 */
	public java.lang.String getFrenalAttachment () {
		return frenalAttachment;
	}

	/**
	 * Set the value related to the column: frenal_attachment
	 * @param frenalAttachment the frenal_attachment value
	 */
	public void setFrenalAttachment (java.lang.String frenalAttachment) {
		this.frenalAttachment = frenalAttachment;
	}



	/**
	 * Return the value associated with the column: maxillary_attachment
	 */
	public java.lang.String getMaxillaryAttachment () {
		return maxillaryAttachment;
	}

	/**
	 * Set the value related to the column: maxillary_attachment
	 * @param maxillaryAttachment the maxillary_attachment value
	 */
	public void setMaxillaryAttachment (java.lang.String maxillaryAttachment) {
		this.maxillaryAttachment = maxillaryAttachment;
	}



	/**
	 * Return the value associated with the column: tension_test_1
	 */
	public java.lang.String getTensionTest1 () {
		return tensionTest1;
	}

	/**
	 * Set the value related to the column: tension_test_1
	 * @param tensionTest1 the tension_test_1 value
	 */
	public void setTensionTest1 (java.lang.String tensionTest1) {
		this.tensionTest1 = tensionTest1;
	}



	/**
	 * Return the value associated with the column: mandibular_attachment
	 */
	public java.lang.String getMandibularAttachment () {
		return mandibularAttachment;
	}

	/**
	 * Set the value related to the column: mandibular_attachment
	 * @param mandibularAttachment the mandibular_attachment value
	 */
	public void setMandibularAttachment (java.lang.String mandibularAttachment) {
		this.mandibularAttachment = mandibularAttachment;
	}



	/**
	 * Return the value associated with the column: tension_test_2
	 */
	public java.lang.String getTensionTest2 () {
		return tensionTest2;
	}

	/**
	 * Set the value related to the column: tension_test_2
	 * @param tensionTest2 the tension_test_2 value
	 */
	public void setTensionTest2 (java.lang.String tensionTest2) {
		this.tensionTest2 = tensionTest2;
	}



	/**
	 * Return the value associated with the column: max_clinical_feature
	 */
	public java.lang.String getMaxClinicalFeature () {
		return maxClinicalFeature;
	}

	/**
	 * Set the value related to the column: max_clinical_feature
	 * @param maxClinicalFeature the max_clinical_feature value
	 */
	public void setMaxClinicalFeature (java.lang.String maxClinicalFeature) {
		this.maxClinicalFeature = maxClinicalFeature;
	}



	/**
	 * Return the value associated with the column: max_right_posterior
	 */
	public java.lang.String getMaxRightPosterior () {
		return maxRightPosterior;
	}

	/**
	 * Set the value related to the column: max_right_posterior
	 * @param maxRightPosterior the max_right_posterior value
	 */
	public void setMaxRightPosterior (java.lang.String maxRightPosterior) {
		this.maxRightPosterior = maxRightPosterior;
	}



	/**
	 * Return the value associated with the column: max_anterior
	 */
	public java.lang.String getMaxAnterior () {
		return maxAnterior;
	}

	/**
	 * Set the value related to the column: max_anterior
	 * @param maxAnterior the max_anterior value
	 */
	public void setMaxAnterior (java.lang.String maxAnterior) {
		this.maxAnterior = maxAnterior;
	}



	/**
	 * Return the value associated with the column: max_left_posterior
	 */
	public java.lang.String getMaxLeftPosterior () {
		return maxLeftPosterior;
	}

	/**
	 * Set the value related to the column: max_left_posterior
	 * @param maxLeftPosterior the max_left_posterior value
	 */
	public void setMaxLeftPosterior (java.lang.String maxLeftPosterior) {
		this.maxLeftPosterior = maxLeftPosterior;
	}



	/**
	 * Return the value associated with the column: man_clinical_feature
	 */
	public java.lang.String getManClinicalFeature () {
		return manClinicalFeature;
	}

	/**
	 * Set the value related to the column: man_clinical_feature
	 * @param manClinicalFeature the man_clinical_feature value
	 */
	public void setManClinicalFeature (java.lang.String manClinicalFeature) {
		this.manClinicalFeature = manClinicalFeature;
	}



	/**
	 * Return the value associated with the column: man_right_oposterior
	 */
	public java.lang.String getManRightOposterior () {
		return manRightOposterior;
	}

	/**
	 * Set the value related to the column: man_right_oposterior
	 * @param manRightOposterior the man_right_oposterior value
	 */
	public void setManRightOposterior (java.lang.String manRightOposterior) {
		this.manRightOposterior = manRightOposterior;
	}



	/**
	 * Return the value associated with the column: man_anterior
	 */
	public java.lang.String getManAnterior () {
		return manAnterior;
	}

	/**
	 * Set the value related to the column: man_anterior
	 * @param manAnterior the man_anterior value
	 */
	public void setManAnterior (java.lang.String manAnterior) {
		this.manAnterior = manAnterior;
	}



	/**
	 * Return the value associated with the column: man_left_posterior
	 */
	public java.lang.String getManLeftPosterior () {
		return manLeftPosterior;
	}

	/**
	 * Set the value related to the column: man_left_posterior
	 * @param manLeftPosterior the man_left_posterior value
	 */
	public void setManLeftPosterior (java.lang.String manLeftPosterior) {
		this.manLeftPosterior = manLeftPosterior;
	}



	/**
	 * Return the value associated with the column: mucogingival_problems
	 */
	public java.lang.String getMucogingivalProblems () {
		return mucogingivalProblems;
	}

	/**
	 * Set the value related to the column: mucogingival_problems
	 * @param mucogingivalProblems the mucogingival_problems value
	 */
	public void setMucogingivalProblems (java.lang.String mucogingivalProblems) {
		this.mucogingivalProblems = mucogingivalProblems;
	}



	/**
	 * Return the value associated with the column: tension_test
	 */
	public java.lang.String getTensionTest () {
		return tensionTest;
	}

	/**
	 * Set the value related to the column: tension_test
	 * @param tensionTest the tension_test value
	 */
	public void setTensionTest (java.lang.String tensionTest) {
		this.tensionTest = tensionTest;
	}



	/**
	 * Return the value associated with the column: attached_gingiva
	 */
	public java.lang.String getAttachedGingiva () {
		return attachedGingiva;
	}

	/**
	 * Set the value related to the column: attached_gingiva
	 * @param attachedGingiva the attached_gingiva value
	 */
	public void setAttachedGingiva (java.lang.String attachedGingiva) {
		this.attachedGingiva = attachedGingiva;
	}



	/**
	 * Return the value associated with the column: vestibular_depth
	 */
	public java.lang.String getVestibularDepth () {
		return vestibularDepth;
	}

	/**
	 * Set the value related to the column: vestibular_depth
	 * @param vestibularDepth the vestibular_depth value
	 */
	public void setVestibularDepth (java.lang.String vestibularDepth) {
		this.vestibularDepth = vestibularDepth;
	}



	/**
	 * Return the value associated with the column: ulceration
	 */
	public java.lang.String getUlceration () {
		return ulceration;
	}

	/**
	 * Set the value related to the column: ulceration
	 * @param ulceration the ulceration value
	 */
	public void setUlceration (java.lang.String ulceration) {
		this.ulceration = ulceration;
	}



	/**
	 * Return the value associated with the column: gingival_abscess
	 */
	public java.lang.String getGingivalAbscess () {
		return gingivalAbscess;
	}

	/**
	 * Set the value related to the column: gingival_abscess
	 * @param gingivalAbscess the gingival_abscess value
	 */
	public void setGingivalAbscess (java.lang.String gingivalAbscess) {
		this.gingivalAbscess = gingivalAbscess;
	}



	/**
	 * Return the value associated with the column: periodontal_abscess
	 */
	public java.lang.String getPeriodontalAbscess () {
		return periodontalAbscess;
	}

	/**
	 * Set the value related to the column: periodontal_abscess
	 * @param periodontalAbscess the periodontal_abscess value
	 */
	public void setPeriodontalAbscess (java.lang.String periodontalAbscess) {
		this.periodontalAbscess = periodontalAbscess;
	}



	/**
	 * Return the value associated with the column: pericoronnal_abscess
	 */
	public java.lang.String getPericoronnalAbscess () {
		return pericoronnalAbscess;
	}

	/**
	 * Set the value related to the column: pericoronnal_abscess
	 * @param pericoronnalAbscess the pericoronnal_abscess value
	 */
	public void setPericoronnalAbscess (java.lang.String pericoronnalAbscess) {
		this.pericoronnalAbscess = pericoronnalAbscess;
	}



	/**
	 * Return the value associated with the column: hard_tissue_examination
	 */
	public java.lang.String getHardTissueExamination () {
		return hardTissueExamination;
	}

	/**
	 * Set the value related to the column: hard_tissue_examination
	 * @param hardTissueExamination the hard_tissue_examination value
	 */
	public void setHardTissueExamination (java.lang.String hardTissueExamination) {
		this.hardTissueExamination = hardTissueExamination;
	}



	/**
	 * Return the value associated with the column: i_o_p_a_view
	 */
	public java.lang.String getIOPAView () {
		return iOPAView;
	}

	/**
	 * Set the value related to the column: i_o_p_a_view
	 * @param iOPAView the i_o_p_a_view value
	 */
	public void setIOPAView (java.lang.String iOPAView) {
		this.iOPAView = iOPAView;
	}



	/**
	 * Return the value associated with the column: o_p_g_view
	 */
	public java.lang.String getOPGView () {
		return oPGView;
	}

	/**
	 * Set the value related to the column: o_p_g_view
	 * @param oPGView the o_p_g_view value
	 */
	public void setOPGView (java.lang.String oPGView) {
		this.oPGView = oPGView;
	}



	/**
	 * Return the value associated with the column: study_models_pre_operative
	 */
	public java.lang.String getStudyModelsPreOperative () {
		return studyModelsPreOperative;
	}

	/**
	 * Set the value related to the column: study_models_pre_operative
	 * @param studyModelsPreOperative the study_models_pre_operative value
	 */
	public void setStudyModelsPreOperative (java.lang.String studyModelsPreOperative) {
		this.studyModelsPreOperative = studyModelsPreOperative;
	}



	/**
	 * Return the value associated with the column: study_models_post_operative
	 */
	public java.lang.String getStudyModelsPostOperative () {
		return studyModelsPostOperative;
	}

	/**
	 * Set the value related to the column: study_models_post_operative
	 * @param studyModelsPostOperative the study_models_post_operative value
	 */
	public void setStudyModelsPostOperative (java.lang.String studyModelsPostOperative) {
		this.studyModelsPostOperative = studyModelsPostOperative;
	}



	/**
	 * Return the value associated with the column: tooth_fracture
	 */
	public java.lang.String getToothFracture () {
		return toothFracture;
	}

	/**
	 * Set the value related to the column: tooth_fracture
	 * @param toothFracture the tooth_fracture value
	 */
	public void setToothFracture (java.lang.String toothFracture) {
		this.toothFracture = toothFracture;
	}



	/**
	 * Return the value associated with the column: hypoplasia_flurosis
	 */
	public java.lang.String getHypoplasiaFlurosis () {
		return hypoplasiaFlurosis;
	}

	/**
	 * Set the value related to the column: hypoplasia_flurosis
	 * @param hypoplasiaFlurosis the hypoplasia_flurosis value
	 */
	public void setHypoplasiaFlurosis (java.lang.String hypoplasiaFlurosis) {
		this.hypoplasiaFlurosis = hypoplasiaFlurosis;
	}



	/**
	 * Return the value associated with the column: attrition
	 */
	public java.lang.String getAttrition () {
		return attrition;
	}

	/**
	 * Set the value related to the column: attrition
	 * @param attrition the attrition value
	 */
	public void setAttrition (java.lang.String attrition) {
		this.attrition = attrition;
	}



	/**
	 * Return the value associated with the column: abrasion
	 */
	public java.lang.String getAbrasion () {
		return abrasion;
	}

	/**
	 * Set the value related to the column: abrasion
	 * @param abrasion the abrasion value
	 */
	public void setAbrasion (java.lang.String abrasion) {
		this.abrasion = abrasion;
	}



	/**
	 * Return the value associated with the column: erosion
	 */
	public java.lang.String getErosion () {
		return erosion;
	}

	/**
	 * Set the value related to the column: erosion
	 * @param erosion the erosion value
	 */
	public void setErosion (java.lang.String erosion) {
		this.erosion = erosion;
	}



	/**
	 * Return the value associated with the column: abfractioin
	 */
	public java.lang.String getAbfractioin () {
		return abfractioin;
	}

	/**
	 * Set the value related to the column: abfractioin
	 * @param abfractioin the abfractioin value
	 */
	public void setAbfractioin (java.lang.String abfractioin) {
		this.abfractioin = abfractioin;
	}



	/**
	 * Return the value associated with the column: filled_teeth
	 */
	public java.lang.String getFilledTeeth () {
		return filledTeeth;
	}

	/**
	 * Set the value related to the column: filled_teeth
	 * @param filledTeeth the filled_teeth value
	 */
	public void setFilledTeeth (java.lang.String filledTeeth) {
		this.filledTeeth = filledTeeth;
	}



	/**
	 * Return the value associated with the column: premature_contacts
	 */
	public java.lang.String getPrematureContacts () {
		return prematureContacts;
	}

	/**
	 * Set the value related to the column: premature_contacts
	 * @param prematureContacts the premature_contacts value
	 */
	public void setPrematureContacts (java.lang.String prematureContacts) {
		this.prematureContacts = prematureContacts;
	}



	/**
	 * Return the value associated with the column: furcation_involvement
	 */
	public java.lang.String getFurcationInvolvement () {
		return furcationInvolvement;
	}

	/**
	 * Set the value related to the column: furcation_involvement
	 * @param furcationInvolvement the furcation_involvement value
	 */
	public void setFurcationInvolvement (java.lang.String furcationInvolvement) {
		this.furcationInvolvement = furcationInvolvement;
	}



	/**
	 * Return the value associated with the column: missing_teeth_and_reason_for_i_t
	 */
	public java.lang.String getMissingTeethAndReasonForIT () {
		return missingTeethAndReasonForIT;
	}

	/**
	 * Set the value related to the column: missing_teeth_and_reason_for_i_t
	 * @param missingTeethAndReasonForIT the missing_teeth_and_reason_for_i_t value
	 */
	public void setMissingTeethAndReasonForIT (java.lang.String missingTeethAndReasonForIT) {
		this.missingTeethAndReasonForIT = missingTeethAndReasonForIT;
	}



	/**
	 * Return the value associated with the column: angles_classification
	 */
	public java.lang.String getAnglesClassification () {
		return anglesClassification;
	}

	/**
	 * Set the value related to the column: angles_classification
	 * @param anglesClassification the angles_classification value
	 */
	public void setAnglesClassification (java.lang.String anglesClassification) {
		this.anglesClassification = anglesClassification;
	}



	/**
	 * Return the value associated with the column: overjet
	 */
	public java.lang.String getOverjet () {
		return overjet;
	}

	/**
	 * Set the value related to the column: overjet
	 * @param overjet the overjet value
	 */
	public void setOverjet (java.lang.String overjet) {
		this.overjet = overjet;
	}



	/**
	 * Return the value associated with the column: overbite
	 */
	public java.lang.String getOverbite () {
		return overbite;
	}

	/**
	 * Set the value related to the column: overbite
	 * @param overbite the overbite value
	 */
	public void setOverbite (java.lang.String overbite) {
		this.overbite = overbite;
	}



	/**
	 * Return the value associated with the column: fremitus
	 */
	public java.lang.String getFremitus () {
		return fremitus;
	}

	/**
	 * Set the value related to the column: fremitus
	 * @param fremitus the fremitus value
	 */
	public void setFremitus (java.lang.String fremitus) {
		this.fremitus = fremitus;
	}



	/**
	 * Return the value associated with the column: crossbite
	 */
	public java.lang.String getCrossbite () {
		return crossbite;
	}

	/**
	 * Set the value related to the column: crossbite
	 * @param crossbite the crossbite value
	 */
	public void setCrossbite (java.lang.String crossbite) {
		this.crossbite = crossbite;
	}



	/**
	 * Return the value associated with the column: working_side
	 */
	public java.lang.String getWorkingSide () {
		return workingSide;
	}

	/**
	 * Set the value related to the column: working_side
	 * @param workingSide the working_side value
	 */
	public void setWorkingSide (java.lang.String workingSide) {
		this.workingSide = workingSide;
	}



	/**
	 * Return the value associated with the column: balancing_side
	 */
	public java.lang.String getBalancingSide () {
		return balancingSide;
	}

	/**
	 * Set the value related to the column: balancing_side
	 * @param balancingSide the balancing_side value
	 */
	public void setBalancingSide (java.lang.String balancingSide) {
		this.balancingSide = balancingSide;
	}



	/**
	 * Return the value associated with the column: mobility
	 */
	public java.lang.String getMobility () {
		return mobility;
	}

	/**
	 * Set the value related to the column: mobility
	 * @param mobility the mobility value
	 */
	public void setMobility (java.lang.String mobility) {
		this.mobility = mobility;
	}



	/**
	 * Return the value associated with the column: photographs_pre_operative
	 */
	public java.lang.String getPhotographsPreOperative () {
		return photographsPreOperative;
	}

	/**
	 * Set the value related to the column: photographs_pre_operative
	 * @param photographsPreOperative the photographs_pre_operative value
	 */
	public void setPhotographsPreOperative (java.lang.String photographsPreOperative) {
		this.photographsPreOperative = photographsPreOperative;
	}



	/**
	 * Return the value associated with the column: photographs_post_operative
	 */
	public java.lang.String getPhotographsPostOperative () {
		return photographsPostOperative;
	}

	/**
	 * Set the value related to the column: photographs_post_operative
	 * @param photographsPostOperative the photographs_post_operative value
	 */
	public void setPhotographsPostOperative (java.lang.String photographsPostOperative) {
		this.photographsPostOperative = photographsPostOperative;
	}



	/**
	 * Return the value associated with the column: furcation_involvement_val
	 */
	public java.lang.String getFurcationInvolvementVal () {
		return furcationInvolvementVal;
	}

	/**
	 * Set the value related to the column: furcation_involvement_val
	 * @param furcationInvolvementVal the furcation_involvement_val value
	 */
	public void setFurcationInvolvementVal (java.lang.String furcationInvolvementVal) {
		this.furcationInvolvementVal = furcationInvolvementVal;
	}



	/**
	 * Return the value associated with the column: mobility_val
	 */
	public java.lang.String getMobilityVal () {
		return mobilityVal;
	}

	/**
	 * Set the value related to the column: mobility_val
	 * @param mobilityVal the mobility_val value
	 */
	public void setMobilityVal (java.lang.String mobilityVal) {
		this.mobilityVal = mobilityVal;
	}



	/**
	 * Return the value associated with the column: fremitus_val
	 */
	public java.lang.String getFremitusVal () {
		return fremitusVal;
	}

	/**
	 * Set the value related to the column: fremitus_val
	 * @param fremitusVal the fremitus_val value
	 */
	public void setFremitusVal (java.lang.String fremitusVal) {
		this.fremitusVal = fremitusVal;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdCaseRecordPeriodonticsHeader)) return false;
		else {
			jkt.hms.masters.business.OpdCaseRecordPeriodonticsHeader opdCaseRecordPeriodonticsHeader = (jkt.hms.masters.business.OpdCaseRecordPeriodonticsHeader) obj;
			if (null == this.getId() || null == opdCaseRecordPeriodonticsHeader.getId()) return false;
			else return (this.getId().equals(opdCaseRecordPeriodonticsHeader.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}